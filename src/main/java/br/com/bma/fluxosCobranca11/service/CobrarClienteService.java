package br.com.bma.fluxosCobranca11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bma.fluxosCobranca11.model.dto.CobrarClienteDTO;
import br.com.bma.fluxosCobranca11.repository.CobrarClienteRepository;
import br.com.bma.fluxosCobranca11.utils.FluigUtil;
import net.java.dev.jaxb.array.StringArrayArray;

@Service
public class CobrarClienteService {
	
	@Autowired
	private CobrarClienteRepository cobrarClienteRepository;
	
	public CobrarClienteDTO findByIdFluig(int id) {
		try {			
			CobrarClienteDTO cobrarCliente = cobrarClienteRepository.findByIdFluig(id);
			return cobrarCliente;			
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public StringArrayArray inserirNovaCobranca(CobrarClienteDTO dto) {
		try {
			StringArrayArray retorno = cobrarClienteRepository.inserirNovaCobranca(dto);
			FluigUtil.validarRetornoStringArrayArray(retorno, null);
			return retorno;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
