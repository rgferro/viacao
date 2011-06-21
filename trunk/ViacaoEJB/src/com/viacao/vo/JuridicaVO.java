package com.viacao.vo;

public class JuridicaVO {

	private Integer  seqJuridica;
	private ClienteVO clienteVO;
	private String razaoSocial;
	private String nomResponsavel;
	private String cnpj;
	private String numInscricao;
	private String nomFantasia;
	

	public Integer getSeqJuridica() {
		return seqJuridica;
	}
	
	public void setSeqJuridica(Integer seqJuridica) {
		this.seqJuridica = seqJuridica;
	}
	
	public ClienteVO getClienteVO() {
		return clienteVO;
	}
	
	public void setClienteVO(ClienteVO clienteVO) {
		this.clienteVO = clienteVO;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getNomResponsavel() {
		return nomResponsavel;
	}
	
	public void setNomResponsavel(String nomResponsavel) {
		this.nomResponsavel = nomResponsavel;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getNumInscricao() {
		return numInscricao;
	}
	
	public void setNumInscricao(String numInscricao) {
		this.numInscricao = numInscricao;
	}
	
	public String getNomFantasia() {
		return nomFantasia;
	}

	public void setNomFantasia(String nomFantasia) {
		this.nomFantasia = nomFantasia;
	}
}
