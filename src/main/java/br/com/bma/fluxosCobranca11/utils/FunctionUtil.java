package br.com.bma.fluxosCobranca11.utils;

import java.io.Serializable;
import java.util.function.Function;

import org.slf4j.LoggerFactory;

import br.com.bma.fluxosCobranca11.model.dto.CobrarClienteDTO;
import br.com.bma.fluxosCobranca11.model.dto.EmitirFaturaDTO;
import br.com.bma.fluxosCobranca11.model.dto.RealizarDistribuicaoDTO;

public class FunctionUtil implements Serializable {

private static final long serialVersionUID = 4594456489226815472L;
	
	private static final int WAIT_ONE_SECOND = 1000;
	
	public static String realizarTentativaConexaoRest(String result, int id, Function<Integer, String> function) throws Exception {
		try {
			System.out.println("Entrou em realizarTentativaConexaoRest");
			if (StringUtils.isBlank(result)) {
				int maximoTentativas = 2;
				for (int i = 0; i <= maximoTentativas; i++) {
					Thread.sleep(WAIT_ONE_SECOND);
					result = function.apply(id);
					if (StringUtils.isNotBlank(result)) {
						break;
					}
				}
				
			}
			System.out.println("saiu de realizarTentativaConexaoRest");
			return result;
			
		} catch (Exception e) {
			LoggerFactory.getLogger(FunctionUtil.class).error("FunctionUtil.realizarTentativaConexaoRest({}): {}", 
					result, e.getMessage());
			throw new Exception(e);
		}
	}

	public static String realizarTentativaConexaoRest(String result, EmitirFaturaDTO dto,
			Function<EmitirFaturaDTO, String> function) throws Exception {
		try {
			if (StringUtils.isBlank(result)) {
				int maximoTentativas = 2;
				for (int i = 0; i <= maximoTentativas; i++) {
					Thread.sleep(WAIT_ONE_SECOND);
					result = function.apply(dto);
					if (StringUtils.isNotBlank(result)) {
						break;
					}
				}
				
			}
			return result;
			
		} catch (Exception e) {
			//LoggerFactory.getLogger(FunctionUtil.class).error("LeilaoRepositoryImpl.realizarTentativaConexao({}): {}", 
			//		result, e.getMessage());
			throw new Exception(e);
		}
	}

	public static String realizarTentativaConexaoCobrarClienteRest(String result, CobrarClienteDTO dto,
			Function<CobrarClienteDTO, String> function) throws Exception {
		try {
			if (StringUtils.isBlank(result)) {
				int maximoTentativas = 2;
				for (int i = 0; i <= maximoTentativas; i++) {
					Thread.sleep(WAIT_ONE_SECOND);
					result = function.apply(dto);
					if (StringUtils.isNotBlank(result)) {
						break;
					}
				}
				
			}
			return result;
			
		} catch (Exception e) {
			//LoggerFactory.getLogger(FunctionUtil.class).error("LeilaoRepositoryImpl.realizarTentativaConexao({}): {}", 
			//		result, e.getMessage());
			throw new Exception(e);
		}
	}

	public static String realizarTentativaConexaoRest(String result, RealizarDistribuicaoDTO dto,
			Function<RealizarDistribuicaoDTO, String> function) throws Exception {
		try {
			if (StringUtils.isBlank(result)) {
				int maximoTentativas = 2;
				for (int i = 0; i <= maximoTentativas; i++) {
					Thread.sleep(WAIT_ONE_SECOND);
					result = function.apply(dto);
					if (StringUtils.isNotBlank(result)) {
						break;
					}
				}
				
			}
			return result;
			
		} catch (Exception e) {
			//LoggerFactory.getLogger(FunctionUtil.class).error("LeilaoRepositoryImpl.realizarTentativaConexao({}): {}", 
			//		result, e.getMessage());
			throw new Exception(e);
		}
	}
}
