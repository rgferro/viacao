/**
 * 
 */
package com.viacao.vo;

import java.util.List;

/**
 * @author Wallace Gonçalves
 *
 */
public class ItinerarioVo {
	
	private Integer seqItinerario;
	private Double valorPassagem;
	
	private RodoviariaVO rodoviariaOrigemVO;
	private RodoviariaVO rodoviariaDestinoVO;
	private List<TarifaVO> listaTarifas;
	private String tempoViagem;
	
	
	/**
	 * Obtém o atributo seqItinerario
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
	 * Obtém o atributo listaTarifas
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

	/**
	 * Obtém o atributo rodoviariaOrigemVO
	 * @return Valor do atributo rodoviariaOrigemVO
	 */
	public RodoviariaVO getRodoviariaOrigemVO() {
		return rodoviariaOrigemVO;
	}
	/**
	 * Altera o atributo rodoviariaOrigemVO
	 * @param rodoviariaOrigemVO Novo valor do atributo
	 */
	public void setRodoviariaOrigemVO(RodoviariaVO rodoviariaOrigemVO) {
		this.rodoviariaOrigemVO = rodoviariaOrigemVO;
	}
	/**
	 * Obtém o atributo rodoviariaDestinoVO
	 * @return Valor do atributo rodoviariaDestinoVO
	 */
	public RodoviariaVO getRodoviariaDestinoVO() {
		return rodoviariaDestinoVO;
	}
	/**
	 * Altera o atributo rodoviariaDestinoVO
	 * @param rodoviariaDestinoVO Novo valor do atributo
	 */
	public void setRodoviariaDestinoVO(RodoviariaVO rodoviariaDestinoVO) {
		this.rodoviariaDestinoVO = rodoviariaDestinoVO;
	}
	/**
	 * Obtém o atributo valorPassagem
	 * @return Valor do atributo valorPassagem
	 */
	public Double getValorPassagem() {
		return valorPassagem;
	}
	/**
	 * Altera o atributo valorPassagem
	 * @param valorPassagem Novo valor do atributo
	 */
	public void setValorPassagem(Double valorPassagem) {
		this.valorPassagem = valorPassagem;
	}
	/**
	 * Obtém o atributo tempoViagem
	 * @return Valor do atributo tempoViagem
	 */
	public String getTempoViagem() {
		return tempoViagem;
	}
	/**
	 * Altera o atributo tempoViagem
	 * @param tempoViagem Novo valor do atributo
	 */
	public void setTempoViagem(String tempoViagem) {
		this.tempoViagem = tempoViagem;
	}
}
