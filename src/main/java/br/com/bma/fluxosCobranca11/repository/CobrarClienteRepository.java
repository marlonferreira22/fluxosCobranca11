package br.com.bma.fluxosCobranca11.repository;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

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

import br.com.bma.fluxosCobranca11.model.dto.ClienteAssuntoFaturaDTO;
import br.com.bma.fluxosCobranca11.model.dto.CobrarClienteDTO;
import br.com.bma.fluxosCobranca11.model.dto.RetornoFormDatasetDTO;
import br.com.bma.fluxosCobranca11.service.fluigService;
import br.com.bma.fluxosCobranca11.utils.FunctionUtil;
import br.com.bma.fluxosCobranca11.ws.ProcessAttachmentDtoArray;
import br.com.bma.fluxosCobranca11.ws.ProcessTaskAppointmentDtoArray;
import br.com.bma.fluxosCobranca11.ws.WorkflowEngineService;
import net.java.dev.jaxb.array.StringArrayz;

@Repository
public class CobrarClienteRepository {
	
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
	public static final String VALUE_FILHOS = "tblCliAssFat";

	public CobrarClienteDTO findByIdFluig(int id) {		
		
		long start = System.currentTimeMillis();

		Function<Integer, String> function = x -> {
			try {
				return findByIdFluigRest(x);
			} catch (Exception e) {
				LoggerFactory.getLogger(FunctionUtil.class)
						.error("CobrarClienteRepository.findByIdFluig({}): {}", e.getMessage());
				return null;
			}
		};

		String result = function.apply(id);

		try {
			result = FunctionUtil.realizarTentativaConexaoRest(result, id, function);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject jsonReturn = new JSONObject(result);

		long elapsed = System.currentTimeMillis() - start;

		System.out.println(String.format("Tempo em milesegundos %s", elapsed));

		List<CobrarClienteDTO> lista = new ArrayList<>();

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

		Type tipoLista = new TypeToken<ArrayList<CobrarClienteDTO>>() {
		}.getType();
		lista = fazerConversao(retorno, tipoLista); 

		popularAssuntoFatura(lista);

		return (lista != null && lista.size() > 0) ? lista.get(0) : null;
	}
	
	private List<CobrarClienteDTO> fazerConversao(String retorno, Type tipoLista) {
		ArrayList<CobrarClienteDTO>  lista = new Gson().fromJson(retorno, tipoLista);
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
				.add("temFiscal").add("temCompliance").add("temJuridico").add("temCliente")
				.add("statusSolicitacao").add("indiceControle").add("indiceBaixaFat")
				.add("flagControle").add("analistaResp").add("solVisita").add("dataVisita")
				.add("dataRegistro").add("nomeAnalista").add("nomeSocio").add("cliente")
				.add("zoom_cliente").add("assunto").add("zoom_assunto")
				.add("fatura").add("zoom_fatura").add("checkTemFiscal").add("checkTemJuridico")
				.add("checkTemCompliance").add("checkTemCliente").add("dtlembrete")
				.add("descPla").add("descPlaFiscal").add("descPlaJuridico").add("descPlaCompliance")
				.add("descPlaCliente").add("numSolicitacao");

		return jsonFields;
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
	
	public JsonObject constraintActive() {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", "metadata#active")
				.add("_initialValue", true).add("_finalValue", true).add("_type", 1).add("_likeSearch", false).build();

		return jsonConstraint;
	}
	
	public String createObjectBuilder(JsonArrayBuilder jsonFields, JsonArrayBuilder jsonConstraints,
			JsonArrayBuilder jsonOrder) {

		String json = Json.createObjectBuilder().add("name", "dsCobrarCliente").add("fields", jsonFields)
				.add("constraints", jsonConstraints).add("order", jsonOrder).build().toString();
		return json;
	}
	
	private void popularAssuntoFatura(List<CobrarClienteDTO> negociacoes) {
		
		if (negociacoes != null && negociacoes.size() > 0) {
			for (CobrarClienteDTO negociacao : negociacoes) {
				List<ClienteAssuntoFaturaDTO> propostasDaNegociacao = pegarAssuntoFatura(negociacao);				
				negociacao.setClienteAssuntoFaturaDTO(propostasDaNegociacao);

				// Se vier vazio, insere o principal
				if (propostasDaNegociacao == null
						|| (propostasDaNegociacao != null && propostasDaNegociacao.size() == 0))
					criarAssuntoComDadosPrincipais(negociacao);
			}
		}
	}
	
	private void criarAssuntoComDadosPrincipais(CobrarClienteDTO negociacao) {
		ClienteAssuntoFaturaDTO propostaPrincipal = new ClienteAssuntoFaturaDTO();
		propostaPrincipal.setMetadataId(negociacao.getMetadataId());
		propostaPrincipal.setCardIndexId(negociacao.getCardIndexId());
		propostaPrincipal.setCardIndexVersionId(negociacao.getCardIndexVersionId());
		propostaPrincipal.setVersion(negociacao.getVersion());
		propostaPrincipal.setActive(negociacao.isActive());
		propostaPrincipal.setParentId(negociacao.getParentId());
		propostaPrincipal.setNumSolicitacao(negociacao.getNumSolicitacao());
		negociacao.adicionarAssuntoFatura(propostaPrincipal);
		
	}

	private List<ClienteAssuntoFaturaDTO> pegarAssuntoFatura(CobrarClienteDTO negociacao) {
		try {
			if (negociacao != null) {
				
				long start = System.currentTimeMillis();

				Function<CobrarClienteDTO, String> function = x -> {
					try {
						//return pegarPropostasRest(negociacao);
						return pegarAssuntoFaturaRest(negociacao);
					} catch (Exception e) {
						//LoggerFactory.getLogger(this.getClass())
						//		.error("NegociacaoEquipamentoRepositoryImpl.pegarPropostas(): {}", e.getMessage());
						return null;
					}
				};

				String result = function.apply(negociacao);

				result = FunctionUtil.realizarTentativaConexaoCobrarClienteRest(result, negociacao, function);

				JSONObject jsonReturn = new JSONObject(result);

				long elapsed = System.currentTimeMillis() - start;

				System.out.println(String.format("Tempo em milesegundos %s", elapsed));

				List<ClienteAssuntoFaturaDTO> lista = new ArrayList<>();

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

				Type tipoLista = new TypeToken<ArrayList<ClienteAssuntoFaturaDTO>>() {
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
	
	private String pegarAssuntoFaturaRest(CobrarClienteDTO negociacao) throws Exception {

		long startConnect = System.currentTimeMillis();

		JsonArrayBuilder jsonFields = createArrayBuilderAssuntoFatura();

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
	
	public JsonArrayBuilder createArrayBuilderAssuntoFatura() {
		JsonArrayBuilder jsonFields = Json.createArrayBuilder().add("tblCliente").add("tblAssunto")
				.add("tblFatura").add("tblControle");

		return jsonFields;
	}
	
	public JsonObject constraintTablename() {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", KEY_FILHOS)
				.add("_initialValue", VALUE_FILHOS).add("_finalValue", VALUE_FILHOS).add("_type", 1)
				.add("_likeSearch", false).build();
		return jsonConstraint;
	}
	
	public JsonObject constraintNumSolicitacao(CobrarClienteDTO negociacao) {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", RetornoFormDatasetDTO.METADATA_NUM_SOLICITACAO)
				.add("_initialValue", negociacao.getNumSolicitacao().toString())
				.add("_finalValue", negociacao.getNumSolicitacao().toString()).add("_type", 1).add("_likeSearch", false)
				.build();
		return jsonConstraint;
	}
	
	public JsonObject constraintMetadataId(CobrarClienteDTO negociacao) {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", RetornoFormDatasetDTO.METADATA_ID)
				.add("_initialValue", negociacao.getMetadataId().toString())
				.add("_finalValue", negociacao.getMetadataId().toString()).add("_type", 1).add("_likeSearch", false)
				.build();
		return jsonConstraint;
	}
	
	public JsonObject constraintMetadataVersion(CobrarClienteDTO negociacao) {
		JsonObject jsonConstraint = Json.createObjectBuilder().add("_field", RetornoFormDatasetDTO.METADATA_VERSION)
				.add("_initialValue", negociacao.getVersion().toString())
				.add("_finalValue", negociacao.getVersion().toString()).add("_type", 1).add("_likeSearch", false)
				.build();
		return jsonConstraint;
	}

	public net.java.dev.jaxb.array.StringArrayArray inserirNovaCobranca(CobrarClienteDTO dto) {
		
		try {			
			net.java.dev.jaxb.array.StringArrayArray toReturn = new net.java.dev.jaxb.array.StringArrayArray();
			String comments = "Inserindo Nova Cobrança";
			ProcessAttachmentDtoArray attachments = new ProcessAttachmentDtoArray();
			net.java.dev.jaxb.array.StringArrayArray cardData = cardDataParaCobranca(dto);
			ProcessTaskAppointmentDtoArray appointment = new ProcessTaskAppointmentDtoArray();
			
			StringArrayz colleagueIds = new StringArrayz();
			boolean completeTask = false;
			boolean managerMode = true;
			toReturn = workflowEngineService.saveAndSendTask(getUsuarioFluig, getSenhaFluig,
					getCompanyId, Integer.valueOf(dto.getNumSolicitacao()),	14, colleagueIds, comments,
					getMatriculaFluig, completeTask, attachments, cardData, appointment, managerMode, 0);			
			return toReturn;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private net.java.dev.jaxb.array.StringArrayArray cardDataParaCobranca(CobrarClienteDTO dto) {
		try {
			net.java.dev.jaxb.array.StringArrayArray stringArrayArray = cardData(dto);

			StringArrayz status = new StringArrayz();
			status.getItem().add("statusSolicitacao");
			status.getItem().add((dto.getStatusSolicitacao() != null) ? dto.getStatusSolicitacao().toString() : "");
			stringArrayArray.getItem().add(status);

			for (ClienteAssuntoFaturaDTO currentFatura : dto.getClienteAssuntoFaturaDTO()) {
				int indexAtualMaisUm = dto.getClienteAssuntoFaturaDTO().indexOf(currentFatura) + 1;

				StringArrayz tblCliente = new StringArrayz();
				tblCliente.getItem().add("tblCliente___" + indexAtualMaisUm);
				tblCliente.getItem().add(currentFatura.getTblCliente());

				StringArrayz tblAssunto = new StringArrayz();
				tblAssunto.getItem().add("tblAssunto___" + indexAtualMaisUm);
				tblAssunto.getItem().add(currentFatura.getTblAssunto());

				StringArrayz tblFatura = new StringArrayz();
				tblFatura.getItem().add("tblFatura___" + indexAtualMaisUm);
				tblFatura.getItem().add(currentFatura.getTblFatura());

				StringArrayz tblControle = new StringArrayz();
				tblControle.getItem().add("tblControle___" + indexAtualMaisUm);
				tblControle.getItem().add(currentFatura.getTblControle());
				
				StringArrayz numSolicitacao = new StringArrayz();
				numSolicitacao.getItem().add("numSolicitacao");
				numSolicitacao.getItem().add(dto.getNumSolicitacao().toString());

				stringArrayArray.getItem().add(tblCliente);
				stringArrayArray.getItem().add(tblAssunto);
				stringArrayArray.getItem().add(tblFatura);
				stringArrayArray.getItem().add(tblControle);
				stringArrayArray.getItem().add(numSolicitacao);
			}
			return stringArrayArray;
		} catch (Exception e) {
			throw e;
		}
	}

	private net.java.dev.jaxb.array.StringArrayArray cardData(CobrarClienteDTO dto) {
		net.java.dev.jaxb.array.StringArrayArray stringArrayArray = new net.java.dev.jaxb.array.StringArrayArray();
		try {
			StringArrayz temFiscal = new StringArrayz();
			temFiscal.getItem().add("temFiscal");
			temFiscal.getItem().add(dto.getTemFiscal());

			StringArrayz temCompliance = new StringArrayz();
			temCompliance.getItem().add("temCompliance");
			temCompliance.getItem().add(dto.getTemCompliance());

			StringArrayz temJuridico = new StringArrayz();
			temJuridico.getItem().add("temJuridico");
			temJuridico.getItem().add(dto.getTemJuridico());

			StringArrayz temCliente = new StringArrayz();
			temCliente.getItem().add("temCliente");
			temCliente.getItem().add(dto.getTemCliente());

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

			StringArrayz fatura = new StringArrayz();
			fatura.getItem().add("fatura");
			fatura.getItem().add(dto.getFatura());
			
			StringArrayz zoom_fatura = new StringArrayz();
			zoom_fatura.getItem().add("zoom_fatura");
			zoom_fatura.getItem().add(dto.getZoom_fatura());
			
			StringArrayz checkTemFiscal = new StringArrayz();
			checkTemFiscal.getItem().add("checkTemFiscal");
			checkTemFiscal.getItem().add(dto.getCheckTemFiscal());
			
			StringArrayz checkTemJuridico = new StringArrayz();
			checkTemJuridico.getItem().add("checkTemJuridico");
			checkTemJuridico.getItem().add(dto.getCheckTemJuridico());
			
			StringArrayz checkTemCompliance = new StringArrayz();
			checkTemCompliance.getItem().add("checkTemCompliance");
			checkTemCompliance.getItem().add(dto.getTemCompliance());
			
			StringArrayz checkTemCliente = new StringArrayz();
			checkTemCliente.getItem().add("checkTemCliente");
			checkTemCliente.getItem().add(dto.getCheckTemCliente());
			
			StringArrayz dtlembrete = new StringArrayz();
			dtlembrete.getItem().add("dtlembrete");
			dtlembrete.getItem().add(dto.getDtlembrete());
			
			StringArrayz descPla = new StringArrayz();
			descPla.getItem().add("descPla");
			descPla.getItem().add(dto.getDescPla());
			
			StringArrayz descPlaFiscal = new StringArrayz();
			descPlaFiscal.getItem().add("descPlaFiscal");
			descPlaFiscal.getItem().add(dto.getDescPlaFiscal());
			
			StringArrayz descPlaJuridico = new StringArrayz();
			descPlaJuridico.getItem().add("descPlaJuridico");
			descPlaJuridico.getItem().add(dto.getDescPlaJuridico());
			
			StringArrayz descPlaCompliance = new StringArrayz();
			descPlaCompliance.getItem().add("descPlaCompliance");
			descPlaCompliance.getItem().add(dto.getDescPlaCompliance());
			
			StringArrayz descPlaCliente = new StringArrayz();
			descPlaCliente.getItem().add("descPlaCliente");
			descPlaCliente.getItem().add(dto.getDescPlaCliente());
			
			StringArrayz numSolicitacao = new StringArrayz();
			numSolicitacao.getItem().add("numSolicitacao");
			numSolicitacao.getItem().add(dto.getNumSolicitacao().toString());			

			stringArrayArray.getItem().add(temFiscal);
			stringArrayArray.getItem().add(temCompliance);
			stringArrayArray.getItem().add(temJuridico);
			stringArrayArray.getItem().add(temCliente);
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
			stringArrayArray.getItem().add(zoom_assunto);
			stringArrayArray.getItem().add(cliente);
			stringArrayArray.getItem().add(zoom_cliente);
			stringArrayArray.getItem().add(assunto);
			stringArrayArray.getItem().add(zoom_assunto);
			stringArrayArray.getItem().add(fatura);
			stringArrayArray.getItem().add(zoom_fatura);
			stringArrayArray.getItem().add(checkTemFiscal);
			stringArrayArray.getItem().add(checkTemJuridico);
			stringArrayArray.getItem().add(checkTemCompliance);
			stringArrayArray.getItem().add(checkTemCliente);
			stringArrayArray.getItem().add(dtlembrete);
			stringArrayArray.getItem().add(descPla);
			stringArrayArray.getItem().add(descPlaFiscal);
			stringArrayArray.getItem().add(descPlaJuridico);
			stringArrayArray.getItem().add(descPlaCompliance);
			stringArrayArray.getItem().add(descPlaCliente);
			stringArrayArray.getItem().add(numSolicitacao);
		} catch (Exception e) {
			throw e;
		}
		return stringArrayArray;
	}

}
