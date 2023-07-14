package br.com.bma.fluxosCobranca11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bma.fluxosCobranca11.interfaces.RealizarDistribuicaoInterface;
import br.com.bma.fluxosCobranca11.model.dto.RealizarDistribuicaoDTO;
import br.com.bma.fluxosCobranca11.repository.RealizarDistribuicaoRepository;
import br.com.bma.fluxosCobranca11.utils.FluigUtil;
import net.java.dev.jaxb.array.StringArrayArray;

@Service
public class RealizarDistribuicaoService implements RealizarDistribuicaoInterface {
	
	@Autowired
	private RealizarDistribuicaoRepository realizarDistribuicaoRepository;

	public RealizarDistribuicaoDTO findByIdFluig(int id) {
		try {
			RealizarDistribuicaoDTO distribuicao = realizarDistribuicaoRepository.findByIdFluig(id);
			return distribuicao;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public StringArrayArray inserirNovaDistribuicao(RealizarDistribuicaoDTO dto) {
		try {
			StringArrayArray retorno = realizarDistribuicaoRepository.inserirNovaDistribuicao(dto);
			FluigUtil.validarRetornoStringArrayArray(retorno, null);
			return retorno;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
