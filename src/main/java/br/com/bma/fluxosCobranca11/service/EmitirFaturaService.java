package br.com.bma.fluxosCobranca11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bma.fluxosCobranca11.model.dto.EmitirFaturaDTO;
import br.com.bma.fluxosCobranca11.repository.EmitirFaturaRepository;
import br.com.bma.fluxosCobranca11.utils.FluigUtil;
import net.java.dev.jaxb.array.StringArrayArray;

@Service
public class EmitirFaturaService {
	
	@Autowired
	private EmitirFaturaRepository repository;
	
	public EmitirFaturaDTO findByIdFluig(int id) {
		try {
			EmitirFaturaDTO fatura = repository.findByIdFluig(id);
			return fatura;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public StringArrayArray inserirNovaFatura(EmitirFaturaDTO dto) {
		try {
			StringArrayArray retorno = repository.inserirNovaFatura(dto);
			FluigUtil.validarRetornoStringArrayArray(retorno, null);
			return retorno;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
