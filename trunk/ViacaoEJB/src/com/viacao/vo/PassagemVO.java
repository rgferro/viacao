package com.viacao.vo;

public class PassagemVO {
	
	private Integer seqPassagem;
	private ViagemVO viagemVO;
	private ClienteVO clienteVO;
	private Integer numBilhete;
	private Integer numPoltrona;
	private Double valorPassagem;
	
	/**
	 * @return the seqPassagem
	 */
	public Integer getSeqPassagem() {
		return seqPassagem;
	}
	/**
	 * @param seqPassagem the seqPassagem to set
	 */
	public void setSeqPassagem(Integer seqPassagem) {
		this.seqPassagem = seqPassagem;
	}
	/**
	 * @return the viagemVO
	 */
	public ViagemVO getViagemVO() {
		return viagemVO;
	}
	/**
	 * @param viagemVO the viagemVO to set
	 */
	public void setViagemVO(ViagemVO viagemVO) {
		this.viagemVO = viagemVO;
	}
	/**
	 * @return the clienteVO
	 */
	public ClienteVO getClienteVO() {
		return clienteVO;
	}
	/**
	 * @param clienteVO the clienteVO to set
	 */
	public void setClienteVO(ClienteVO clienteVO) {
		this.clienteVO = clienteVO;
	}
	/**
	 * @return the numBilhete
	 */
	public Integer getNumBilhete() {
		return numBilhete;
	}
	/**
	 * @param numBilhete the numBilhete to set
	 */
	public void setNumBilhete(Integer numBilhete) {
		this.numBilhete = numBilhete;
	}
	/**
	 * @return the numPoltrona
	 */
	public Integer getNumPoltrona() {
		return numPoltrona;
	}
	/**
	 * @param numPoltrona the numPoltrona to set
	 */
	public void setNumPoltrona(Integer numPoltrona) {
		this.numPoltrona = numPoltrona;
	}
	/**
	 * @return the valorPassagem
	 */
	public Double getValorPassagem() {
		return valorPassagem;
	}
	/**
	 * @param valorPassagem the valorPassagem to set
	 */
	public void setValorPassagem(Double valorPassagem) {
		this.valorPassagem = valorPassagem;
	}
}
