/**
 * 
 */
package com.viacao.vo;

import java.util.List;

/**
 * @author Wallace Gon�alves
 *
 */
public class ItinerarioVo {
	
	private Integer seqItinerario;
	private Double passagem;
	private List<TarifaVO> listaTarifas;
	
	
	/**
	 * Obt�m o atributo seqItinerario
	 * @return Valor do atributo seqItinerario
	 */
	public Integer getSeqItinerario() {
		return seqItinerario;
	}
	/**
	 * Altera o atributo seqItinerario
	 * @param seqItinerario Novo valor do atributo
	 */
	public void setSeqItinerario(Integer seqItinerario) {
		this.seqItinerario = seqItinerario;
	}
	/**
	 * Obt�m o atributo passagem
	 * @return Valor do atributo passagem
	 */
	public Double getPassagem() {
		return passagem;
	}
	/**
	 * Altera o atributo passagem
	 * @param passagem Novo valor do atributo
	 */
	public void setPassagem(Double passagem) {
		this.passagem = passagem;
	}
	/**
	 * Obt�m o atributo listaTarifas
	 * @return Valor do atributo listaTarifas
	 */
	public List<TarifaVO> getListaTarifas() {
		return listaTarifas;
	}
	/**
	 * Altera o atributo listaTarifas
	 * @param listaTarifas Novo valor do atributo
	 */
	public void setListaTarifas(List<TarifaVO> listaTarifas) {
		this.listaTarifas = listaTarifas;
	}
}
