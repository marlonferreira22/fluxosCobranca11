package br.com.bma.fluxosCobranca11.utils;

import java.io.Serializable;

public class AsciiDTO implements Serializable {

private static final long serialVersionUID = 1L;
	
	private String caractere;
    private Short index;

    public AsciiDTO (String caractere, Short index){
        this.caractere = caractere;
        this.index = index;
    }

    public AsciiDTO (String caractere, Integer index){
        this.caractere = caractere;
        this.index = (index != null) ? index.shortValue() : null;
    }

    public String getCaractere() {
        return caractere;
    }

    public void setCaractere(String caractere) {
        this.caractere = caractere;
    }

    public Short getIndex() {
        return index;
    }

    public void setIndex(Short index) {
        this.index = index;
    }
}
