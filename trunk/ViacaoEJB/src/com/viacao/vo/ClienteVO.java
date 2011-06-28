package com.viacao.vo;

import com.acol.util.IntegerUtils;
import com.acol.util.StringUtil;

public class ClienteVO {
	
	private Integer seqCliente;
	private EnderecoVO enderecoVO;
	private String login;
	private String senha;
	private String email;
	
	public boolean isEmpty(){
		if(IntegerUtils.empty(this.seqCliente)){
			return true;
		}
		if(StringUtil.empty(this.login)){
			return true;
		}
		if(StringUtil.empty(this.senha)){
			return true;
		}
		if(StringUtil.empty(this.email)){
			return true;
		}
		return false;
	}
	
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
