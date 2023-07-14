package br.com.bma.fluxosCobranca11.interfaces;

import org.springframework.stereotype.Service;

import br.com.bma.fluxosCobranca11.model.dto.RealizarDistribuicaoDTO;
import net.java.dev.jaxb.array.StringArrayArray;

@Service
public interface RealizarDistribuicaoInterface {

	RealizarDistribuicaoDTO findByIdFluig(int id);
	StringArrayArray inserirNovaDistribuicao(RealizarDistribuicaoDTO dto);
}
