package com.viacao.vo;

public class CartaoVO {
	
	private Integer seqCartao;
	private ClienteVO clienteVO;
	private String nomeTitular;
	private Integer numeroCartao;
	private DataVO dataValidade;
	private String bandeiraCartao;
	private Integer codSeguranca;
	
	/**
	 * @return the seqCartao
	 */
	public Integer getSeqCartao() {
		return seqCartao;
	}
	/**
	 * @param seqCartao the seqCartao to set
	 */
	public void setSeqCartao(Integer seqCartao) {
		this.seqCartao = seqCartao;
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
	 * @return the nomeTitular
	 */
	public String getNomeTitular() {
		return nomeTitular;
	}
	/**
	 * @param nomeTitular the nomeTitular to set
	 */
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	/**
	 * @return the numeroCartao
	 */
	public Integer getNumeroCartao() {
		return numeroCartao;
	}
	/**
	 * @param numeroCartao the numeroCartao to set
	 */
	public void setNumeroCartao(Integer numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	/**
	 * @return the dataValidade
	 */
	public DataVO getDataValidade() {
		return dataValidade;
	}
	/**
	 * @param dataValidade the dataValidade to set
	 */
	public void setDataValidade(DataVO dataValidade) {
		this.dataValidade = dataValidade;
	}
	/**
	 * @return the bandeiraCartao
	 */
	public String getBandeiraCartao() {
		return bandeiraCartao;
	}
	/**
	 * @param bandeiraCartao the bandeiraCartao to set
	 */
	public void setBandeiraCartao(String bandeiraCartao) {
		this.bandeiraCartao = bandeiraCartao;
	}
	/**
	 * @return the codSeguranca
	 */
	public Integer getCodSeguranca() {
		return codSeguranca;
	}
	/**
	 * @param codSeguranca the codSeguranca to set
	 */
	public void setCodSeguranca(Integer codSeguranca) {
		this.codSeguranca = codSeguranca;
	}

}
