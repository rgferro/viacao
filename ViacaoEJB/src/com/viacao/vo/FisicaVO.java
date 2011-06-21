package com.viacao.vo;

public class FisicaVO {
	
	Integer seqFisica;
	ClienteVO clienteVO;
	String nomPessoa;
	String cpfPessoa;
	String rgPessoa;
	
	public Integer getSeqFisica() {
		return seqFisica;
	}
	public void setSeqFisica(Integer seqFisica) {
		this.seqFisica = seqFisica;
	}
	public ClienteVO getClienteVO() {
		return clienteVO;
	}
	public void setClienteVO(ClienteVO clienteVO) {
		this.clienteVO = clienteVO;
	}
	public String getNomPessoa() {
		return nomPessoa;
	}
	public void setNomPessoa(String nomPessoa) {
		this.nomPessoa = nomPessoa;
	}
	public String getCpfPessoa() {
		return cpfPessoa;
	}
	public void setCpfPessoa(String cpfPessoa) {
		this.cpfPessoa = cpfPessoa;
	}
	public String getRgPessoa() {
		return rgPessoa;
	}
	public void setRgPessoa(String rgPessoa) {
		this.rgPessoa = rgPessoa;
	}

}
