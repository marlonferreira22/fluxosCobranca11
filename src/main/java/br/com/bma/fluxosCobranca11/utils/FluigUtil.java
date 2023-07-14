package br.com.bma.fluxosCobranca11.utils;

import java.io.Serializable;
import java.util.List;

import br.com.bma.fluxosCobranca11.ws.StringArrayArray;
import net.java.dev.jaxb.array.StringArrayz;


public abstract class FluigUtil implements Serializable {
	
	private static final String ERROR_GENERICO = "Ocorreu um erro inesperado no Fluig";
	private static final String ERROR_NAME = "ERROR";

	public static void validarRetornoStringArrayArray(net.java.dev.jaxb.array.StringArrayArray retorno, String mensagemGenerica)
			throws RuntimeException {
		String mensagem = (mensagemGenerica != null && !mensagemGenerica.isEmpty()) ? mensagemGenerica : ERROR_GENERICO;

		// Se algum for nulo
		if (retorno == null || (retorno != null && retorno.getItem() == null))
			throw new RuntimeException(mensagem);

		// Se não tiver nada no retorno também
		if (retorno.getItem().size() == 0)
			throw new RuntimeException(mensagem);

		// Valida se retornou um somente, verifica se é o ERROR
		if (retorno.getItem().size() == 1) {
			StringArrayz strArray = retorno.getItem().get(0);
			List<String> strings = strArray.getItem();
			if (strings != null && strings.size() == 2) {
				String primeiro = strings.get(0);
				if (primeiro.equals(ERROR_NAME))
					throw new RuntimeException(strings.get(1));
			}
		}
	}
}
