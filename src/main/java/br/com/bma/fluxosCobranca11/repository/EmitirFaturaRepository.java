package br.com.bma.fluxosCobranca11.repository;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.bma.fluxosCobranca11.model.dto.EmitirFaturaDTO;
import br.com.bma.fluxosCobranca11.model.dto.FaturasEmitidasDTO;
import br.com.bma.fluxosCobranca11.model.dto.PropostaDTO;
import br.com.bma.fluxosCobranca11.model.dto.RetornoFormDatasetDTO;
import br.com.bma.fluxosCobranca11.service.fluigService;
import br.com.bma.fluxosCobranca11.utils.FunctionUtil;
import br.com.bma.fluxosCobranca11.ws.ProcessAttachmentDtoArray;
import br.com.bma.fluxosCobranca11.ws.ProcessTaskAppointmentDtoArray;
import br.com.bma.fluxosCobranca11.ws.WorkflowEngineService;
import net.java.dev.jaxb.array.StringArrayz;

@Repository
public class EmitirFaturaRepository {
	
	@Autowired
	private fluigService fluigService;
	
	@Autowired
	private WorkflowEngineService workflowEngineService;
		
	@Autowired
	private String getUsuarioFluig;
	
	@Autowired
	private String getSenhaFluig;
	
	@Autowired
	private Integer getCompanyId;
	
	@Autowired
	private String getMatriculaFluig;
	
	public static final String KEY_FILHOS = "tablename";
	public static final String VALUE_FILHOS = "tblCliAssPlan";

	public EmitirFaturaDTO findByIdFluig(int id) {		
		
		long start = System.currentTimeMillis();

		Function<Integer, String> function = x -> {
			try {
				return findByIdFluigRest(x);
			} catch (Exception e) {
				LoggerFactory.getLogger(FunctionUtil.class)
						.error("EmitirFaturaRepository.findByIdFluig({}): {}", e.getMessage());
				return null;
			}
		};

		String result = function.apply(id);

		try {
			result = FunctionUtil.realizarTentativaConexaoRest(result, id, function);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONObject jsonReturn = new JSONObject(result);

		long elapsed = System.currentTimeMillis() - start;

		System.out.println(String.format("Tempo em milesegundos %s", elapsed));

		List<EmitirFaturaDTO> lista = new ArrayList<>();

		boolean existeLeilao = jsonReturn.getJSONObject("content").has("values");

		JSONArray values = null;

		if (!existeLeilao)
			return null;

		values = jsonReturn.getJSONObject("content").getJSONArray("values");

		String retorno = values.toString().replace(RetornoFormDatasetDTO.METADATA_ID, "metadataId")
				.replace(RetornoFormDatasetDTO.METADATA_PARENT_ID, "parentId")
				.replace(RetornoFormDatasetDTO.METADATA_VERSION, "version")
				.replace(RetornoFormDatasetDTO.METADATA_CARD_INDEX_VERSION, "cardIndexVersionId")
				.replace(RetornoFormDatasetDTO.METADATA_ACTIVE, "active")
				.replace(RetornoFormDatasetDTO.METADATA_NUM_SOLICITACAO, "numSolicitacao");

		Type tipoLista = new TypeToken<ArrayList<EmitirFaturaDTO>>() {
		}.getType();
		lista = fazerConversao(retorno, tipoLista); 

		popularFaturasEmitidas(lista);

		return (lista != null && lista.size() > 0) ? lista.get(0) : null;
	}
	
	private List<EmitirFaturaDTO> fazerConversao(String retorno, Type tipoLista) {
		ArrayList<EmitirFaturaDTO>  lista = new Gson().fromJson(retorno, tipoLista);
		return lista;
		
	}

	private String findByIdFluigRest(int id) throws Exception {
		long startConnect = System.currentTimeMillis();

		JsonArrayBuilder jsonFields = createArrayBuilder();

		JsonArrayBuilder jsonConstraints;

		jsonConstraints = Json.createArrayBuilder().add(constraintNumSolicitacao(id)).add(constraintActive());

		JsonArrayBuilder jsonOrder = Json.createArrayBuilder().add("metadata#id");

		String json = createObjectBuilder(jsonFields, jsonConstraints, jsonOrder);

		String result = fluigService.executePost("api/public/ecm/dataset/datasets", json);

		long elapsedConnect = System.currentTimeMillis() - startConnect;

		System.out.println(String.format("Tempo em milesegundos %s", elapsedConnect));

		return result;
	}
	
	public JsonArrayBuilder createArrayBuilder() {
		JsonArrayBuilder jsonFields = Json.createArrayBuilder().add("id").add("cardid").add("companyid")
				.add("vetorFaturas").add("statusSolicitacao").add("indiceControle").add("indiceBaixaFat")
				.add("flagControle").add("analistaResp").add("solVisita")
				.add("dataVisita").add("dataRegistro").add("nomeAnalista").add("nomeSocio")
				.add("cliente").add("zoom_cliente").add("assunto").add("zoom_assunto")
				.add("planoAcao").add("zoom_plano").add("descPlano").add("dtlembrete").add("numSolicitacao");

		return jsonFields;
	}
	
	public JsonObject constraintActive() {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", "metadata#active")
				.add("_initialValue", true).add("_finalValue", true).add("_type", 1).add("_likeSearch", false).build();

		return jsonConstraint;
	}
	
	public String createObjectBuilder(JsonArrayBuilder jsonFields, JsonArrayBuilder jsonConstraints,
			JsonArrayBuilder jsonOrder) {

		String json = Json.createObjectBuilder().add("name", "dsEmitirFaturas").add("fields", jsonFields)
				.add("constraints", jsonConstraints).add("order", jsonOrder).build().toString();
		return json;
	}
	
	public JsonObject constraintNumSolicitacao(int id) {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", RetornoFormDatasetDTO.METADATA_NUM_SOLICITACAO)
				.add("_initialValue", id).add("_finalValue", id).add("_type", 1).add("_likeSearch", false).build();
		return jsonConstraint;
	}
	
	public JsonObject constraintMetadataId(int id) {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", RetornoFormDatasetDTO.METADATA_ID)
				.add("_initialValue", id).add("_finalValue", id).add("_type", 1).add("_likeSearch", false).build();
		return jsonConstraint;
	}
	
	private void popularPropostasDasNegociacoes(List<EmitirFaturaDTO> negociacoes) {
		
		if (negociacoes != null && negociacoes.size() > 0) {
			for (EmitirFaturaDTO negociacao : negociacoes) {
				List<PropostaDTO> propostasDaNegociacao = pegarPropostas(negociacao);
				propostasDaNegociacao = filtrarPropostasPreenchidas(propostasDaNegociacao);
				//negociacao.setPropostas(propostasDaNegociacao);

				// Se vier vazio, insere o principal
				if (propostasDaNegociacao == null
						|| (propostasDaNegociacao != null && propostasDaNegociacao.size() == 0))
					criarPropostaComDadosPrincipais(negociacao);
			}
		}
	}
	
	private void popularFaturasEmitidas(List<EmitirFaturaDTO> negociacoes) {
		
		if (negociacoes != null && negociacoes.size() > 0) {
			for (EmitirFaturaDTO negociacao : negociacoes) {
				List<FaturasEmitidasDTO> propostasDaNegociacao = pegarFaturasEmitidas(negociacao);
				//propostasDaNegociacao = filtrarPropostasPreenchidas(propostasDaNegociacao);
				//propostasDaNegociacao = filtrarFaturasEmitidasPreenchidas(propostasDaNegociacao);
				//negociacao.setPropostas(propostasDaNegociacao);
				negociacao.setFaturasEmitidas(propostasDaNegociacao);

				// Se vier vazio, insere o principal
				if (propostasDaNegociacao == null
						|| (propostasDaNegociacao != null && propostasDaNegociacao.size() == 0))
					//criarPropostaComDadosPrincipais(negociacao);
					criarFaturasComDadosPrincipais(negociacao);
			}
		}
	}
	
	private void criarFaturasComDadosPrincipais(EmitirFaturaDTO negociacao) {
		FaturasEmitidasDTO propostaPrincipal = new FaturasEmitidasDTO();
		propostaPrincipal.setMetadataId(negociacao.getMetadataId());
		propostaPrincipal.setCardIndexId(negociacao.getCardIndexId());
		propostaPrincipal.setCardIndexVersionId(negociacao.getCardIndexVersionId());
		propostaPrincipal.setVersion(negociacao.getVersion());
		propostaPrincipal.setActive(negociacao.isActive());
		propostaPrincipal.setParentId(negociacao.getParentId());
		propostaPrincipal.setNumSolicitacao(negociacao.getNumSolicitacao());
		/*propostaPrincipal.setDataNegociacao(negociacao.getDataProposta());
		propostaPrincipal.setDescricaoNegociacao(negociacao.getDescricaoProposta());
		propostaPrincipal.setValorNegociacao(negociacao.getValorProposta());
		propostaPrincipal.setNomeNegociacao(negociacao.getNomeProposta());*/
		//negociacao.adicionarProposta(propostaPrincipal);
		negociacao.adicionarFaturasEmitidas(propostaPrincipal);
		
	}
	
	private void criarPropostaComDadosPrincipais(EmitirFaturaDTO negociacao) {
		PropostaDTO propostaPrincipal = new PropostaDTO();
		propostaPrincipal.setMetadataId(negociacao.getMetadataId());
		propostaPrincipal.setCardIndexId(negociacao.getCardIndexId());
		propostaPrincipal.setCardIndexVersionId(negociacao.getCardIndexVersionId());
		propostaPrincipal.setVersion(negociacao.getVersion());
		propostaPrincipal.setActive(negociacao.isActive());
		propostaPrincipal.setParentId(negociacao.getParentId());
		/*propostaPrincipal.setDataNegociacao(negociacao.getDataProposta());
		propostaPrincipal.setDescricaoNegociacao(negociacao.getDescricaoProposta());
		propostaPrincipal.setValorNegociacao(negociacao.getValorProposta());
		propostaPrincipal.setNomeNegociacao(negociacao.getNomeProposta());*/
		negociacao.adicionarProposta(propostaPrincipal);
		
	}

	// Filtra as propostas com todos os dados preenchidos
	private List<PropostaDTO> filtrarPropostasPreenchidas(List<PropostaDTO> propostasDaNegociacao) {
		if (propostasDaNegociacao != null && propostasDaNegociacao.size() > 0) {
			List<PropostaDTO> listaFiltrada = propostasDaNegociacao.stream()
					.filter(p -> p.getDataNegociacao() != null && !p.getDataNegociacao().isEmpty())
					.collect(Collectors.toList());
			return listaFiltrada;
		}
		return propostasDaNegociacao;
	}
	
	// Filtra as faturas emitidas com todos os dados preenchidos
		/*private List<FaturasEmitidasDTO> filtrarFaturasEmitidasPreenchidas(List<FaturasEmitidasDTO> propostasDaNegociacao) {
			if (propostasDaNegociacao != null && propostasDaNegociacao.size() > 0) {
				List<FaturasEmitidasDTO> listaFiltrada = propostasDaNegociacao.stream()
						.filter(p -> p.getDataNegociacao() != null && !p.getDataNegociacao().isEmpty())
						.collect(Collectors.toList());
				return listaFiltrada;
			}
			return propostasDaNegociacao;
		}*/
	
	private List<FaturasEmitidasDTO> pegarFaturasEmitidas(EmitirFaturaDTO negociacao) {
		try {
			if (negociacao != null) {
				
				long start = System.currentTimeMillis();

				Function<EmitirFaturaDTO, String> function = x -> {
					try {
						return pegarFaturasEmitidasRest(negociacao);
					} catch (Exception e) {
						//LoggerFactory.getLogger(this.getClass())
						//		.error("NegociacaoEquipamentoRepositoryImpl.pegarPropostas(): {}", e.getMessage());
						return null;
					}
				};

				String result = function.apply(negociacao);

				result = FunctionUtil.realizarTentativaConexaoRest(result, negociacao, function);

				JSONObject jsonReturn = new JSONObject(result);

				long elapsed = System.currentTimeMillis() - start;

				System.out.println(String.format("Tempo em milesegundos %s", elapsed));

				List<FaturasEmitidasDTO> lista = new ArrayList<>();

				boolean existeLeilao = jsonReturn.getJSONObject("content").has("values");

				JSONArray values = null;

				if (!existeLeilao)
					return lista;
				values = jsonReturn.getJSONObject("content").getJSONArray("values");

				String retorno = values.toString().replace(RetornoFormDatasetDTO.METADATA_ID, "metadataId")
						.replace(RetornoFormDatasetDTO.METADATA_PARENT_ID, "parentId")
						.replace(RetornoFormDatasetDTO.METADATA_VERSION, "version")
						.replace(RetornoFormDatasetDTO.METADATA_CARD_INDEX_ID, "cardIndexId")
						.replace(RetornoFormDatasetDTO.METADATA_CARD_INDEX_VERSION, "cardIndexVersionId")
						.replace(RetornoFormDatasetDTO.METADATA_ACTIVE, "active")
						.replace(RetornoFormDatasetDTO.METADATA_NUM_SOLICITACAO, "numSolicitacao");

				Type tipoLista = new TypeToken<ArrayList<FaturasEmitidasDTO>>() {
				}.getType();
				lista = new Gson().fromJson(retorno, tipoLista);
				return lista;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private List<PropostaDTO> pegarPropostas(EmitirFaturaDTO negociacao) {
		try {
			if (negociacao != null) {
				
				long start = System.currentTimeMillis();

				Function<EmitirFaturaDTO, String> function = x -> {
					try {
						//return pegarPropostasRest(negociacao);
						return pegarFaturasEmitidasRest(negociacao);
					} catch (Exception e) {
						//LoggerFactory.getLogger(this.getClass())
						//		.error("NegociacaoEquipamentoRepositoryImpl.pegarPropostas(): {}", e.getMessage());
						return null;
					}
				};

				String result = function.apply(negociacao);

				result = FunctionUtil.realizarTentativaConexaoRest(result, negociacao, function);

				JSONObject jsonReturn = new JSONObject(result);

				long elapsed = System.currentTimeMillis() - start;

				System.out.println(String.format("Tempo em milesegundos %s", elapsed));

				List<PropostaDTO> lista = new ArrayList<>();

				boolean existeLeilao = jsonReturn.getJSONObject("content").has("values");

				JSONArray values = null;

				if (!existeLeilao)
					return lista;
				values = jsonReturn.getJSONObject("content").getJSONArray("values");

				String retorno = values.toString().replace(RetornoFormDatasetDTO.METADATA_ID, "metadataId")
						.replace(RetornoFormDatasetDTO.METADATA_PARENT_ID, "parentId")
						.replace(RetornoFormDatasetDTO.METADATA_VERSION, "version")
						.replace(RetornoFormDatasetDTO.METADATA_CARD_INDEX_ID, "cardIndexId")
						.replace(RetornoFormDatasetDTO.METADATA_CARD_INDEX_VERSION, "cardIndexVersionId")
						.replace(RetornoFormDatasetDTO.METADATA_ACTIVE, "active")
						.replace(RetornoFormDatasetDTO.METADATA_NUM_SOLICITACAO, "numSolicitacao");

				Type tipoLista = new TypeToken<ArrayList<PropostaDTO>>() {
				}.getType();
				lista = new Gson().fromJson(retorno, tipoLista);
				// lista = fazerConversao(retorno, tipoLista);
				return lista;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String pegarPropostasRest(EmitirFaturaDTO negociacao) throws Exception {

		long startConnect = System.currentTimeMillis();

		JsonArrayBuilder jsonFields = createArrayBuilderProposta();

		JsonArrayBuilder jsonConstraints;

		jsonConstraints = Json.createArrayBuilder().add(constraintTablename()).add(constraintNumSolicitacao(negociacao))
				.add(constraintMetadataVersion(negociacao));

		JsonArrayBuilder jsonOrder = Json.createArrayBuilder().add(RetornoFormDatasetDTO.METADATA_ID);

		String json = createObjectBuilder(jsonFields, jsonConstraints, jsonOrder);

		String result = fluigService.executePost("api/public/ecm/dataset/datasets", json);

		long elapsedConnect = System.currentTimeMillis() - startConnect;

		System.out.println(String.format("Tempo em milesegundos %s", elapsedConnect));

		return result;

	}
	
	private String pegarFaturasEmitidasRest(EmitirFaturaDTO negociacao) throws Exception {

		long startConnect = System.currentTimeMillis();

		JsonArrayBuilder jsonFields = createArrayBuilderFaturasEmitidas();

		JsonArrayBuilder jsonConstraints;

		jsonConstraints = Json.createArrayBuilder().add(constraintTablename()).add(constraintMetadataId(negociacao))
				.add(constraintMetadataVersion(negociacao));

		JsonArrayBuilder jsonOrder = Json.createArrayBuilder().add(RetornoFormDatasetDTO.METADATA_ID);

		String json = createObjectBuilder(jsonFields, jsonConstraints, jsonOrder);

		String result = fluigService.executePost("api/public/ecm/dataset/datasets", json);

		long elapsedConnect = System.currentTimeMillis() - startConnect;

		System.out.println(String.format("Tempo em milesegundos %s", elapsedConnect));

		return result;

	}
	
	public JsonArrayBuilder createArrayBuilderProposta() {
		JsonArrayBuilder jsonFields = Json.createArrayBuilder().add("descricaoNegociacao").add("dataNegociacao")
				.add("nomeNegociacao").add("valorNegociacao").add("nomeCQGNegociacao");

		return jsonFields;
	}
	
	public JsonArrayBuilder createArrayBuilderFaturasEmitidas() {
		JsonArrayBuilder jsonFields = Json.createArrayBuilder().add("tblCliente").add("tblAssunto")
				.add("tblPlano").add("tblControle");

		return jsonFields;
	}
	
	public JsonObject constraintTablename() {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", KEY_FILHOS)
				.add("_initialValue", VALUE_FILHOS).add("_finalValue", VALUE_FILHOS).add("_type", 1)
				.add("_likeSearch", false).build();
		return jsonConstraint;
	}
	
	public JsonObject constraintNumSolicitacao(EmitirFaturaDTO negociacao) {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", RetornoFormDatasetDTO.METADATA_NUM_SOLICITACAO)
				.add("_initialValue", negociacao.getNumSolicitacao().toString())
				.add("_finalValue", negociacao.getNumSolicitacao().toString()).add("_type", 1).add("_likeSearch", false)
				.build();
		return jsonConstraint;
	}
	
	public JsonObject constraintMetadataId(EmitirFaturaDTO negociacao) {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", RetornoFormDatasetDTO.METADATA_ID)
				.add("_initialValue", negociacao.getMetadataId().toString())
				.add("_finalValue", negociacao.getMetadataId().toString()).add("_type", 1).add("_likeSearch", false)
				.build();
		return jsonConstraint;
	}
	
	public JsonObject constraintMetadataVersion(EmitirFaturaDTO negociacao) {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", RetornoFormDatasetDTO.METADATA_VERSION)
				.add("_initialValue", negociacao.getVersion().toString())
				.add("_finalValue", negociacao.getVersion().toString()).add("_type", 1).add("_likeSearch", false)
				.build();
		return jsonConstraint;
	}

	public net.java.dev.jaxb.array.StringArrayArray inserirNovaFatura(EmitirFaturaDTO dto) {
		try {
			
			net.java.dev.jaxb.array.StringArrayArray toReturn = new net.java.dev.jaxb.array.StringArrayArray();
			String comments = "Inserindo Nova Fatura";
			ProcessAttachmentDtoArray attachments = new ProcessAttachmentDtoArray();
			net.java.dev.jaxb.array.StringArrayArray cardData = cardDataParaNovaFatura(dto);
			ProcessTaskAppointmentDtoArray appointment = new ProcessTaskAppointmentDtoArray();
			
			StringArrayz colleagueIds = new StringArrayz();
			boolean completeTask = false;
			boolean managerMode = true;
			toReturn = workflowEngineService.saveAndSendTask(getUsuarioFluig, getSenhaFluig,
					getCompanyId, Integer.valueOf(dto.getNumSolicitacao()/*dto.getNumeroSolicitacao()*/),
					/*FluigStatusNegociacaoEquipamento.Negociante.getIdEstadoFluig()*/ 21, colleagueIds, comments,
					getMatriculaFluig, completeTask, attachments, cardData, appointment, managerMode, 0);			
			
			return toReturn;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}		
	}

	private net.java.dev.jaxb.array.StringArrayArray cardDataParaNovaFatura(EmitirFaturaDTO dto) {
		try {
			net.java.dev.jaxb.array.StringArrayArray stringArrayArray = cardData(dto);

			StringArrayz status = new StringArrayz();
			status.getItem().add("statusSolicitacao");
			status.getItem().add((dto.getStatusSolicitacao() != null) ? dto.getStatusSolicitacao().toString() : "");
			stringArrayArray.getItem().add(status);

			for (FaturasEmitidasDTO currentFatura : dto.getFaturasEmitidas()) {
				int indexAtualMaisUm = dto.getFaturasEmitidas().indexOf(currentFatura) + 1;

				StringArrayz tblCliente = new StringArrayz();
				tblCliente.getItem().add("tblCliente___" + indexAtualMaisUm);
				tblCliente.getItem().add(currentFatura.getTblCliente());

				StringArrayz tblAssunto = new StringArrayz();
				tblAssunto.getItem().add("tblAssunto___" + indexAtualMaisUm);
				tblAssunto.getItem().add(currentFatura.getTblAssunto());

				StringArrayz tblPlano = new StringArrayz();
				tblPlano.getItem().add("tblPlano___" + indexAtualMaisUm);
				tblPlano.getItem().add(currentFatura.getTblPlano());

				StringArrayz tblControle = new StringArrayz();
				tblControle.getItem().add("tblControle___" + indexAtualMaisUm);
				tblControle.getItem().add(currentFatura.getTblControle());

				stringArrayArray.getItem().add(tblCliente);
				stringArrayArray.getItem().add(tblAssunto);
				stringArrayArray.getItem().add(tblPlano);
				stringArrayArray.getItem().add(tblControle);
			}
			return stringArrayArray;
		} catch (Exception e) {
			throw e;
		}
	}

	private net.java.dev.jaxb.array.StringArrayArray cardData(EmitirFaturaDTO dto) {
		net.java.dev.jaxb.array.StringArrayArray stringArrayArray = new net.java.dev.jaxb.array.StringArrayArray();
		try {
			StringArrayz vetorFaturas = new StringArrayz();
			vetorFaturas.getItem().add("vetorFaturas");
			vetorFaturas.getItem().add(dto.getVetorFaturas());

			StringArrayz statusSolicitacao = new StringArrayz();
			statusSolicitacao.getItem().add("statusSolicitacao");
			statusSolicitacao.getItem().add(dto.getStatusSolicitacao());

			StringArrayz indiceControle = new StringArrayz();
			indiceControle.getItem().add("indiceControle");
			indiceControle.getItem().add(dto.getIndiceControle());

			StringArrayz indiceBaixaFat = new StringArrayz();
			indiceBaixaFat.getItem().add("indiceBaixaFat");
			indiceBaixaFat.getItem().add(dto.getIndiceBaixaFat());

			StringArrayz flagControle = new StringArrayz();
			flagControle.getItem().add("flagControle");
			flagControle.getItem().add(dto.getFlagControle());

			StringArrayz analistaResp = new StringArrayz();
			analistaResp.getItem().add("analistaResp");
			analistaResp.getItem().add(dto.getAnalistaResp());

			StringArrayz solVisita = new StringArrayz();
			solVisita.getItem().add("solVisita");
			solVisita.getItem().add(dto.getSolVisita());

			StringArrayz dataVisita = new StringArrayz();
			dataVisita.getItem().add("dataVisita");
			dataVisita.getItem().add(dto.getDataVisita());

			StringArrayz dataRegistro = new StringArrayz();
			dataRegistro.getItem().add("dataRegistro");
			dataRegistro.getItem().add(dto.getDataRegistro());

			StringArrayz nomeAnalista = new StringArrayz();
			nomeAnalista.getItem().add("nomeAnalista");
			nomeAnalista.getItem().add(dto.getNomeAnalista());

			StringArrayz nomeSocio = new StringArrayz();
			nomeSocio.getItem().add("nomeSocio");
			nomeSocio.getItem().add(dto.getNomeSocio());

			StringArrayz cliente = new StringArrayz();
			cliente.getItem().add("cliente");
			cliente.getItem().add(dto.getCliente());

			StringArrayz zoom_cliente = new StringArrayz();
			zoom_cliente.getItem().add("zoom_cliente");
			zoom_cliente.getItem().add(dto.getZoom_cliente());

			StringArrayz assunto = new StringArrayz();
			assunto.getItem().add("assunto");
			assunto.getItem().add(dto.getAssunto());

			StringArrayz zoom_assunto = new StringArrayz();
			zoom_assunto.getItem().add("zoom_assunto");
			zoom_assunto.getItem().add(dto.getZoom_assunto());

			StringArrayz planoAcao = new StringArrayz();
			planoAcao.getItem().add("planoAcao");
			planoAcao.getItem().add(dto.getPlanoAcao());

			StringArrayz zoom_plano = new StringArrayz();
			zoom_plano.getItem().add("zoom_plano");
			zoom_plano.getItem().add(dto.getZoom_plano());

			StringArrayz descPlano = new StringArrayz();
			descPlano.getItem().add("descPlano");
			descPlano.getItem().add(dto.getDescPlano());

			StringArrayz dtlembrete = new StringArrayz();
			dtlembrete.getItem().add("dtlembrete");
			dtlembrete.getItem().add(dto.getDtlembrete());
			
			StringArrayz numSolicitacao = new StringArrayz();
			numSolicitacao.getItem().add("numSolicitacao");
			numSolicitacao.getItem().add(dto.getNumSolicitacao().toString());

			stringArrayArray.getItem().add(vetorFaturas);
			stringArrayArray.getItem().add(statusSolicitacao);
			stringArrayArray.getItem().add(indiceControle);
			stringArrayArray.getItem().add(indiceBaixaFat);
			stringArrayArray.getItem().add(flagControle);
			stringArrayArray.getItem().add(analistaResp);
			stringArrayArray.getItem().add(solVisita);
			stringArrayArray.getItem().add(dataVisita);
			stringArrayArray.getItem().add(dataRegistro);
			stringArrayArray.getItem().add(nomeAnalista);
			stringArrayArray.getItem().add(nomeSocio);
			stringArrayArray.getItem().add(cliente);
			stringArrayArray.getItem().add(zoom_cliente);
			stringArrayArray.getItem().add(assunto);
			stringArrayArray.getItem().add(zoom_assunto);
			stringArrayArray.getItem().add(planoAcao);
			stringArrayArray.getItem().add(zoom_plano);
			stringArrayArray.getItem().add(descPlano);
			stringArrayArray.getItem().add(dtlembrete);
			stringArrayArray.getItem().add(numSolicitacao);
		} catch (Exception e) {
			throw e;
		}
		return stringArrayArray;
	}

}
