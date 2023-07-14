package br.com.bma.fluxosCobranca11.ws;


import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.ws.BindingProvider;

import br.com.bma.fluxosCobranca11.ws.ECMWorkflowEngineServiceService;
import br.com.bma.fluxosCobranca11.ws.WorkflowEngineService;

public abstract class FluigServiceFactory {

	public static final String WORKFLOWENGINE_WSDL_NAME = "/ECMWorkflowEngineService?wsdl";
	public static final String CARD_WSDL_NAME = "/ECMCardService?wsdl";
	public static final String CARDINDEX_WSDL_NAME = "/ECMCardIndexService?wsdl";
	public static final String DATASET_WSDL_NAME = "/ECMDatasetService?wsdl";

	public static WorkflowEngineService criarWorkflowEngineService(String urlFluigStr) {
		String urlCompleta = urlFluigStr + WORKFLOWENGINE_WSDL_NAME;
		URL urlFluig = criarURL(urlCompleta);
		ECMWorkflowEngineServiceService workfloxEngineService = new ECMWorkflowEngineServiceService(urlFluig);
		WorkflowEngineService service = workfloxEngineService.getWorkflowEngineServicePort();
		BindingProvider bp = (BindingProvider) service;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, urlCompleta);
		return service;
	}	

	private static URL criarURL(String urlFluigStr) {
		
		URL urlFluig;
		try {
			urlFluig = new URL(urlFluigStr);
			return urlFluig;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		/*try {
			URL urlFluig = new URL(urlFluigStr);
			return urlFluig;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}*/
	}
}


