package br.com.bma.fluxosCobranca11.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fluig.api.client.env.FluigClient;

import br.com.bma.fluxosCobranca11.config.SecurityConfig;
import br.com.bma.fluxosCobranca11.model.dto.ConfigFluigDTO;

@Service
public class fluigService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private String getUrlFluig;

	public String executePost(String endPoint, String body) {
		FluigClient fluig = openClient();
		String result = fluig.post(endPoint, body);
		return replaceSpecialCharacter(result);
	}
	
	public FluigClient openClient() {
		FluigClient fluig = new FluigClient().setHost(getUrlFluig)
				.setConsumerKey("fluxosCobranca").setConsumerSecret("secretkeyfluxoscobranca")
				.setTokenAccess("709973f7-6cbe-4f64-a560-bacb16c01f9b")
				.setTokenSecret("a980ab18-f4a3-4fca-a6ad-ed471868d9b48368f481-2049-482f-ac54-85edfb284327").connect();
		
		return fluig;
	}
	
	private String replaceSpecialCharacter(String result) {

		/* ACENTOS VOGAL A */
		
		result = result.replaceAll("Ã\\u0081", "Á");
		
		result = result.replaceAll("Ã¡", "á");
		
		result = result.replaceAll("Ã\\u0082", "Â");
		
		result = result.replaceAll("Ã¢", "â");
		
		result = result.replaceAll("Ã\\u0083", "Ã");
		
		result = result.replaceAll("Ã£", "ã");
		
		result = result.replaceAll("Ã\\u0080", "À");
				
		/* ACENTOS VOGAL E */
		
		result = result.replaceAll("Ã\\u0089", "É");
		
		result = result.replaceAll("Ã©", "é");
		
		result = result.replaceAll("Ã\\u008a", "Ê");
		
		result = result.replaceAll("Ãª", "ê");
		
		result = result.replaceAll("Ã\\u0088", "È");
		
		result = result.replaceAll("Ã¨", "è");
		
		/* ACENTOS VOGAL I */
		
		result = result.replaceAll("Ã\\u008d", "Í");
		
		result = result.replaceAll("Ã\\u00ad", "í");
		
		result = result.replaceAll("Ã\\u008e", "Î");
		
		result = result.replaceAll("Ã®", "î");
		
		result = result.replaceAll("Ã\\u008c", "Ì");
		
		result = result.replaceAll("Ã¬", "ì");
		
		/* ACENTOS VOGAL O */
		
		result = result.replaceAll("Ã\\u0093", "Ó");
		
		result = result.replaceAll("Ã³", "ó");
		
		result = result.replaceAll("Ã\\u0094", "Ô"); 
		
		result = result.replaceAll("Ã´", "ô");
		
		result = result.replaceAll("Ã\\u0092", "Ò");

		result = result.replaceAll("Ã²", "ò");
		
		result = result.replaceAll("Ã\\u0095", "Õ");
		
		result = result.replaceAll("Ãµ", "õ");
		
		/* ACENTOS VOGAL U */
		
		result = result.replaceAll("Ã\\u0099", "Ù"); 
		
		result = result.replaceAll("Ã¹", "ù"); 
		
		result = result.replaceAll("Ã\\u009a", "Ú"); 
		
		result = result.replaceAll("Ãº", "ú"); 
		
		result = result.replaceAll("Ã\\u009b", "Û"); 
		
		result = result.replaceAll("Ã»", "û"); 
		
		
		/* CONSOANTES */
		
		result = result.replaceAll("Ã\\u0087", "Ç"); 
		
		result = result.replaceAll("Ã§", "ç"); 
		
		result = result.replaceAll("Ã\\u0091", "Ñ"); 
		
		result = result.replaceAll("Ã±", "ñ"); 
		
		result = result.replaceAll("Â³", "2"); 
		
		return result;
	}
}
