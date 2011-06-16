package com.viacao.vo;

import java.text.DecimalFormat;

public class TarifaVO {
	
	Integer seqTarifa; 
	String nomTarifa;
	Double valor;
	
	public Integer getSeqTarifa() {
		return seqTarifa;
	}
	public void setSeqTarifa(Integer seqTarifa) {
		this.seqTarifa = seqTarifa;
	}
	public String getNomTarifa() {
		return nomTarifa;
	}
	public void setNomTarifa(String nomTarifa) {
		this.nomTarifa = nomTarifa;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getNomValor(){
		DecimalFormat fmt = new DecimalFormat("0.00");
		return nomTarifa + " - R$" + fmt.format(valor);
	}

}
