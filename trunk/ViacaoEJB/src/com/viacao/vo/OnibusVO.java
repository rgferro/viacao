package com.viacao.vo;

public class OnibusVO {

	private Integer seqOnibus;
	private String tipo;
	private String empresa;
	private String placa;
	private Integer qtdPoltronas;
	
	/**
	 * Obt�m o atributo seqOnibus
	 * @return Valor do atributo seqOnibus
	 */
	public Integer getSeqOnibus() {
		return seqOnibus;
	}
	/**
	 * Altera o atributo seqOnibus
	 * @param seqOnibus Novo valor do atributo
	 */
	public void setSeqOnibus(Integer seqOnibus) {
		this.seqOnibus = seqOnibus;
	}
	/**
	 * Obt�m o atributo tipo
	 * @return Valor do atributo tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * Altera o atributo tipo
	 * @param tipo Novo valor do atributo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * Obt�m o atributo empresa
	 * @return Valor do atributo empresa
	 */
	public String getEmpresa() {
		return empresa;
	}
	/**
	 * Altera o atributo empresa
	 * @param empresa Novo valor do atributo
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	/**
	 * Obt�m o atributo placa
	 * @return Valor do atributo placa
	 */
	public String getPlaca() {
		return placa;
	}
	/**
	 * Altera o atributo placa
	 * @param placa Novo valor do atributo
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	/**
	 * Obt�m o atributo qtdPoltrona
	 * @return Valor do atributo qtdPoltrona
	 */
	public Integer getQtdPoltronas() {
		return qtdPoltronas;
	}
	/**
	 * Altera o atributo qtdPoltrona
	 * @param qtdPoltrona Novo valor do atributo
	 */
	public void setQtdPoltronas(Integer qtdPoltronas) {
		this.qtdPoltronas = qtdPoltronas;
	}
	
}
