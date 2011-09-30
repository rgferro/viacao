package com.viacao.vo;

import com.viacao.interfaces.Passagem;

public class CompraVO {
	
	private Integer seqCompra;
	private PassagemVO passagemVO;
	private CartaoVO cartaoVO;
	private Double valorCompra;
	private String tipoPagamento;
	
	/**
	 * @return the seqCompra
	 */
	public Integer getSeqCompra() {
		return seqCompra;
	}
	/**
	 * @param seqCompra the seqCompra to set
	 */
	public void setSeqCompra(Integer seqCompra) {
		this.seqCompra = seqCompra;
	}
	/**
	 * @return the passagemVO
	 */
	public PassagemVO getPassagemVO() {
		return passagemVO;
	}
	/**
	 * @param passagemVO the passagemVO to set
	 */
	public void setPassagemVO(PassagemVO passagemVO) {
		this.passagemVO = passagemVO;
	}
	/**
	 * @return the cartaoVO
	 */
	public CartaoVO getCartaoVO() {
		return cartaoVO;
	}
	/**
	 * @param cartaoVO the cartaoVO to set
	 */
	public void setCartaoVO(CartaoVO cartaoVO) {
		this.cartaoVO = cartaoVO;
	}
	/**
	 * @return the valorCompra
	 */
	public Double getValorCompra() {
		return valorCompra;
	}
	/**
	 * @param valorCompra the valorCompra to set
	 */
	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}
	/**
	 * @return the tipoPagamento
	 */
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	/**
	 * @param tipoPagamento the tipoPagamento to set
	 */
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

}
