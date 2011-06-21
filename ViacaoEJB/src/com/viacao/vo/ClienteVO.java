package com.viacao.vo;

public class ClienteVO {
	
	Integer seqCliente;
	EnderecoVO enderecoVO;
	String login;
	String senha;
	String email;
	
	public Integer getSeqCliente() {
		return seqCliente;
	}
	public void setSeqCliente(Integer seqCliente) {
		this.seqCliente = seqCliente;
	}
	public EnderecoVO getEnderecoVO() {
		return enderecoVO;
	}
	public void setEnderecoVO(EnderecoVO enderecoVO) {
		this.enderecoVO = enderecoVO;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
