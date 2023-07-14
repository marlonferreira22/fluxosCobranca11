package br.com.bma.fluxosCobranca11.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigRandomPassword {
	private boolean maiusculas;
	private boolean minusculas;
	private boolean caracteresEspeciais;
	private boolean numeros;
	private int tamanhoSenha;
	private List<Integer> numerosDisponiveis;

	public ConfigRandomPassword() {
		popularDefaults();
	}

	public void zerarDefaults() {
		popularDefaults();
	}

	private void popularDefaults() {
		this.tamanhoSenha = 6;
		this.numerosDisponiveis = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}

	public List<String> retornaNumerosDisponiveisComoString() {
		if (numerosDisponiveis != null && numerosDisponiveis.size() > 0) {
			List<String> numerosComoString = numerosDisponiveis.stream().map(numero -> String.valueOf(numero))
					.collect(Collectors.toList());
			return numerosComoString;
		}
		return new ArrayList<String>();
	}

	public boolean isMaiusculas() {
		return maiusculas;
	}

	public void setMaiusculas(boolean maiusculas) {
		this.maiusculas = maiusculas;
	}

	public boolean isMinusculas() {
		return minusculas;
	}

	public void setMinusculas(boolean minusculas) {
		this.minusculas = minusculas;
	}

	public boolean isCaracteresEspeciais() {
		return caracteresEspeciais;
	}

	public void setCaracteresEspeciais(boolean caracteresEspeciais) {
		this.caracteresEspeciais = caracteresEspeciais;
	}

	public boolean isNumeros() {
		return numeros;
	}

	public int getTamanhoSenha() {
		return tamanhoSenha;
	}

	public void setTamanhoSenha(int tamanhoSenha) {
		this.tamanhoSenha = tamanhoSenha;
		validarTamanhoSenha();
	}

	private void validarTamanhoSenha() {
		if (tamanhoSenha <= 0)
			throw new RuntimeException("O tamanho da senha não pode ser igual ou menor que 0");
	}

	public List<Integer> getNumerosDisponiveis() {
		return numerosDisponiveis;
	}

	public void setNumerosDisponiveis(List<Integer> numerosDisponiveis) {
		this.numerosDisponiveis = numerosDisponiveis;
	}

	public void setNumeros(boolean numeros) {
		this.numeros = numeros;
	}
}
