package br.com.bma.fluxosCobranca11.ws;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.com.bma.fluxosCobranca11.model.dto.RetornoFormDatasetDTO;

public interface AbstractFluigRepository<T extends RetornoFormDatasetDTO> extends Serializable {

	default List<T> fazerConversao(String json, Type tipoLista){
		ArrayList<T>  lista = new Gson().fromJson(json, tipoLista);
		return lista;
	}
}
