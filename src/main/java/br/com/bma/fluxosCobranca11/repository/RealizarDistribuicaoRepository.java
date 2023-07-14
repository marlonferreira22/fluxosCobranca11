package br.com.bma.fluxosCobranca11.repository;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonValue;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.bma.fluxosCobranca11.model.dto.ClienteAssuntoDTO;
import br.com.bma.fluxosCobranca11.model.dto.ConfigFluigDTO;
import br.com.bma.fluxosCobranca11.model.dto.EmitirFaturaDTO;
import br.com.bma.fluxosCobranca11.model.dto.FaturasEmitidasDTO;
import br.com.bma.fluxosCobranca11.model.dto.RealizarDistribuicaoDTO;
import br.com.bma.fluxosCobranca11.model.dto.RetornoFormDatasetDTO;
import br.com.bma.fluxosCobranca11.service.fluigService;
import br.com.bma.fluxosCobranca11.utils.FunctionUtil;
import br.com.bma.fluxosCobranca11.ws.ProcessAttachmentDtoArray;
import br.com.bma.fluxosCobranca11.ws.ProcessTaskAppointmentDtoArray;
import br.com.bma.fluxosCobranca11.ws.WorkflowEngineService;
import net.java.dev.jaxb.array.StringArrayz;
import net.java.dev.jaxb.array.StringArrayArray;

@Repository
public class RealizarDistribuicaoRepository {

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
	public static final String VALUE_FILHOS = "tblCliAss";
	
	public RealizarDistribuicaoDTO findByIdFluig(int id) {
		long start = System.currentTimeMillis();
		System.out.println("Entrou em findByIdFluig");

		Function<Integer, String> function = x -> {
			try {
				return findByIdFluigRest(x);
			} catch (Exception e) {
				LoggerFactory.getLogger(FunctionUtil.class)
						.error("RealizarDistribuicaoRepository.findByIdFluig({}): {}", e.getMessage());
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
		
		List<RealizarDistribuicaoDTO> lista = new ArrayList<>();
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

		Type tipoLista = new TypeToken<ArrayList<RealizarDistribuicaoDTO>>() {			
		}.getType();
		
		lista = fazerConversao(retorno, tipoLista);
		
		popularDistribuicoesEmitidas(lista);
		
		System.out.println("Saiu de findByIdFluig");

		return (lista != null && lista.size() > 0) ? lista.get(0) : null;		
	}

	private void popularDistribuicoesEmitidas(List<RealizarDistribuicaoDTO> negociacoes) {
		System.out.println("Entrou em popularDistribuicoesEmitidas");
		if (negociacoes != null && negociacoes.size() > 0) {
			for (RealizarDistribuicaoDTO negociacao : negociacoes) {
				List<ClienteAssuntoDTO> propostasDaNegociacao = pegarClienteAssunto(negociacao);
				negociacao.setClienteAssunto(propostasDaNegociacao);
				
				// Se vier vazio, insere o principal
				if (propostasDaNegociacao == null
						|| (propostasDaNegociacao != null && propostasDaNegociacao.size() == 0))
					criarDistribuicaoComDadosPrincipais(negociacao);
			}
		}
		System.out.println("Saiu de popularDistribuicoesEmitidas");
		
	}

	private void criarDistribuicaoComDadosPrincipais(RealizarDistribuicaoDTO negociacao) {
		ClienteAssuntoDTO propostaPrincipal = new ClienteAssuntoDTO();
		propostaPrincipal.setMetadataId(negociacao.getMetadataId());
		propostaPrincipal.setCardIndexId(negociacao.getCardIndexId());
		propostaPrincipal.setCardIndexVersionId(negociacao.getCardIndexVersionId());
		propostaPrincipal.setVersion(negociacao.getVersion());
		propostaPrincipal.setActive(negociacao.isActive());
		propostaPrincipal.setParentId(negociacao.getParentId());
		propostaPrincipal.setNumSolicitacao(negociacao.getNumSolicitacao());
		negociacao.adicionarClienteAssunto(propostaPrincipal);
		
	}

	private List<ClienteAssuntoDTO> pegarClienteAssunto(RealizarDistribuicaoDTO negociacao) {
		try {
			System.out.println("Entrou em pegarClienteAssunto");
			if (negociacao != null) {
				long start = System.currentTimeMillis();

				Function<RealizarDistribuicaoDTO, String> function = x -> {
					try {
						return pegarClienteAssuntoRest(negociacao);
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
				
				List<ClienteAssuntoDTO> lista = new ArrayList<>();
				
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
				
				Type tipoLista = new TypeToken<ArrayList<ClienteAssuntoDTO>>() {					
				}.getType();
				lista = new Gson().fromJson(retorno, tipoLista);
				return lista;
			}
			System.out.println("Saiu em pegarClienteAssunto");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String pegarClienteAssuntoRest(RealizarDistribuicaoDTO negociacao) {
		System.out.println("Entrou em pegarClienteAssuntoRest");
		long startConnect = System.currentTimeMillis();

		JsonArrayBuilder jsonFields = createArrayBuilderClienteAssunto();

		JsonArrayBuilder jsonConstraints;

		jsonConstraints = Json.createArrayBuilder().add(constraintTablename()).add(constraintMetadataId(negociacao))
				.add(constraintMetadataVersion(negociacao));

		JsonArrayBuilder jsonOrder = Json.createArrayBuilder().add(RetornoFormDatasetDTO.METADATA_ID);

		String json = createObjectBuilder(jsonFields, jsonConstraints, jsonOrder);

		String result = fluigService.executePost("api/public/ecm/dataset/datasets", json);

		long elapsedConnect = System.currentTimeMillis() - startConnect;

		System.out.println("Saiu de pegarClienteAssuntoRest");
		System.out.println(String.format("Tempo em milesegundos %s", elapsedConnect));

		return result;
	}
	
	public JsonObject constraintMetadataVersion(RealizarDistribuicaoDTO negociacao) {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", RetornoFormDatasetDTO.METADATA_VERSION)
				.add("_initialValue", negociacao.getVersion().toString())
				.add("_finalValue", negociacao.getVersion().toString()).add("_type", 1).add("_likeSearch", false)
				.build();
		return jsonConstraint;
	}
	
	public JsonObject constraintNumSolicitacao(RealizarDistribuicaoDTO negociacao) {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", RetornoFormDatasetDTO.METADATA_NUM_SOLICITACAO)
				.add("_initialValue", negociacao.getMetadataId().toString())
				.add("_finalValue", negociacao.getMetadataId().toString()).add("_type", 1).add("_likeSearch", false)
				.build();
		return jsonConstraint;
	}
	
	public JsonObject constraintMetadataId(RealizarDistribuicaoDTO negociacao) {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", RetornoFormDatasetDTO.METADATA_ID)
				.add("_initialValue", negociacao.getMetadataId().toString())
				.add("_finalValue", negociacao.getMetadataId().toString()).add("_type", 1).add("_likeSearch", false)
				.build();
		return jsonConstraint;
	}

	public JsonObject constraintTablename() {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", KEY_FILHOS)
				.add("_initialValue", VALUE_FILHOS).add("_finalValue", VALUE_FILHOS).add("_type", 1)
				.add("_likeSearch", false).build();
		return jsonConstraint;
	}

	public JsonArrayBuilder createArrayBuilderClienteAssunto() {
		JsonArrayBuilder jsonFields = Json.createArrayBuilder().add("tblCliente").add("tblAssunto")
				.add("acaoSelecionada");

		return jsonFields;
	}

	private List<RealizarDistribuicaoDTO> fazerConversao(String retorno, Type tipoLista) {
		ArrayList<RealizarDistribuicaoDTO> lista = new Gson().fromJson(retorno, tipoLista);
		return lista;
	}

	private String findByIdFluigRest(int id) throws Exception {
		
		long startConnect = System.currentTimeMillis();
		
		System.out.println("Entrou em findByIdFluigRest");

		JsonArrayBuilder jsonFields = createArrayBuilder();

		JsonArrayBuilder jsonConstraints;

		jsonConstraints = Json.createArrayBuilder().add(constraintMetaNumSolicitacao(id)).add(constraintActive());

		JsonArrayBuilder jsonOrder = Json.createArrayBuilder().add("metadata#id");

		String json = createObjectBuilder(jsonFields, jsonConstraints, jsonOrder);

		String result = fluigService.executePost("api/public/ecm/dataset/datasets", json);

		long elapsedConnect = System.currentTimeMillis() - startConnect;
		
		System.out.println("saiu de findByIdFluigRest");

		System.out.println(String.format("Tempo em milesegundos %s", elapsedConnect));

		return result;
	}

	public JsonArrayBuilder createArrayBuilder() {
		JsonArrayBuilder jsonFields = Json.createArrayBuilder().add("id").add("cardid").add("companyid")
				.add("temTransferir").add("statusSolicitacao").add("indiceControle").add("indiceBaixaFat")
				.add("flagControle").add("analistaResp").add("solVisita")
				.add("dataVisita").add("dataRegistro").add("nomeAnalista").add("nomeSocio")
				.add("zoom_cliente").add("zoom_assunto").add("descPlano").add("dtlembrete")
				.add("descPlanoDist").add("descPlanoTransf").add("numSolicitacao");				

		return jsonFields;
	}
	
	public JsonObject constraintMetaNumSolicitacao(int id) {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", RetornoFormDatasetDTO.METADATA_NUM_SOLICITACAO)
				.add("_initialValue", id).add("_finalValue", id).add("_type", 1).add("_likeSearch", false).build();
		return jsonConstraint;
	}
	
	public JsonObject constraintMetadataId(int id) {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", RetornoFormDatasetDTO.METADATA_ID)
				.add("_initialValue", id).add("_finalValue", id).add("_type", 1).add("_likeSearch", false).build();
		return jsonConstraint;
	}
	
	public JsonObject constraintActive() {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", "metadata#active")
				.add("_initialValue", true).add("_finalValue", true).add("_type", 1).add("_likeSearch", false).build();

		return jsonConstraint;
	}
	
	public String createObjectBuilder(JsonArrayBuilder jsonFields, JsonArrayBuilder jsonConstraints,
			JsonArrayBuilder jsonOrder) {

		String json = Json.createObjectBuilder().add("name", "dsRealizarDistribuicao").add("fields", jsonFields)
				.add("constraints", jsonConstraints).add("order", jsonOrder).build().toString();
		return json;
	}

	public StringArrayArray inserirNovaDistribuicao(RealizarDistribuicaoDTO dto) {
		try {
			net.java.dev.jaxb.array.StringArrayArray toReturn = new net.java.dev.jaxb.array.StringArrayArray();
			String comments = "Inserindo Nova Distribuição";
			ProcessAttachmentDtoArray attachments = new ProcessAttachmentDtoArray();
			net.java.dev.jaxb.array.StringArrayArray cardData = cardDataParaNovaDistribuicao(dto);
			ProcessTaskAppointmentDtoArray appointment = new ProcessTaskAppointmentDtoArray();
			
			StringArrayz colleagueIds = new StringArrayz();
			boolean completeTask = false;
			boolean managerMode = true;
			toReturn = workflowEngineService.saveAndSendTask(getUsuarioFluig, getSenhaFluig,
					getCompanyId, Integer.valueOf(dto.getNumSolicitacao()), 17, colleagueIds, comments,
					getMatriculaFluig, completeTask, attachments, cardData, appointment, managerMode, 0);			
			
			return toReturn;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private net.java.dev.jaxb.array.StringArrayArray cardDataParaNovaDistribuicao(RealizarDistribuicaoDTO dto) {
		try {
			net.java.dev.jaxb.array.StringArrayArray stringArrayArray = cardData(dto);

			StringArrayz status = new StringArrayz();
			status.getItem().add("statusSolicitacao");
			status.getItem().add((dto.getStatusSolicitacao() != null) ? dto.getStatusSolicitacao().toString() : "");
			stringArrayArray.getItem().add(status);

			for (ClienteAssuntoDTO currentFatura : dto.getClienteAssunto()) {
				int indexAtualMaisUm = dto.getClienteAssunto().indexOf(currentFatura) + 1;

				StringArrayz tblCliente = new StringArrayz();
				tblCliente.getItem().add("tblCliente___" + indexAtualMaisUm);
				tblCliente.getItem().add(currentFatura.getTblCliente());

				StringArrayz tblAssunto = new StringArrayz();
				tblAssunto.getItem().add("tblAssunto___" + indexAtualMaisUm);
				tblAssunto.getItem().add(currentFatura.getTblAssunto());

				StringArrayz acaoSelecionada = new StringArrayz();
				acaoSelecionada.getItem().add("acaoSelecionada___" + indexAtualMaisUm);
				acaoSelecionada.getItem().add(currentFatura.getAcaoSelecionada());

				stringArrayArray.getItem().add(tblCliente);
				stringArrayArray.getItem().add(tblAssunto);
				stringArrayArray.getItem().add(acaoSelecionada);
			}
			return stringArrayArray;
		} catch (Exception e) {
			throw e;
		}
	}

	private net.java.dev.jaxb.array.StringArrayArray cardData(RealizarDistribuicaoDTO dto) {
		net.java.dev.jaxb.array.StringArrayArray stringArrayArray = new net.java.dev.jaxb.array.StringArrayArray();
		try {
			StringArrayz temTransferir = new StringArrayz();
			temTransferir.getItem().add("temTransferir");
			temTransferir.getItem().add(dto.getTemTransferir());

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

			StringArrayz zoom_cliente = new StringArrayz();
			zoom_cliente.getItem().add("zoom_cliente");
			zoom_cliente.getItem().add(dto.getZoom_cliente());

			StringArrayz zoom_assunto = new StringArrayz();
			zoom_assunto.getItem().add("zoom_assunto");
			zoom_assunto.getItem().add(dto.getZoom_assunto());

			StringArrayz descPlano = new StringArrayz();
			descPlano.getItem().add("descPlano");
			descPlano.getItem().add(dto.getDescPlano());

			StringArrayz dtlembrete = new StringArrayz();
			dtlembrete.getItem().add("dtlembrete");
			dtlembrete.getItem().add(dto.getDtlembrete());
			
			StringArrayz descPlanoDist = new StringArrayz();
			descPlanoDist.getItem().add("descPlanoDist");
			descPlanoDist.getItem().add(dto.getDescPlanoDist());
			
			StringArrayz descPlanoTransf = new StringArrayz();
			descPlanoTransf.getItem().add("descPlanoTransf");
			descPlanoTransf.getItem().add(dto.getDescPlanoTransf());
			
			StringArrayz numSolicitacao = new StringArrayz();
			numSolicitacao.getItem().add("numSolicitacao");
			numSolicitacao.getItem().add(dto.getNumSolicitacao().toString());

			stringArrayArray.getItem().add(temTransferir);
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
			stringArrayArray.getItem().add(zoom_cliente);
			stringArrayArray.getItem().add(zoom_assunto);
			stringArrayArray.getItem().add(descPlano);
			stringArrayArray.getItem().add(dtlembrete);
			stringArrayArray.getItem().add(descPlanoDist);
			stringArrayArray.getItem().add(descPlanoTransf);
			stringArrayArray.getItem().add(numSolicitacao);
		} catch (Exception e) {
			throw e;
		}
		return stringArrayArray;
	}
	
	
}
