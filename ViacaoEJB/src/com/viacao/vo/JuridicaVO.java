package com.viacao.vo;

import com.acol.util.IntegerUtils;
import com.acol.util.StringUtil;

public class JuridicaVO {

	private Integer  seqJuridica;
	private ClienteVO clienteVO;
	private String razaoSocial;
	private String nomResponsavel;
	private String cnpj;
	private String numInscricao;
	private String nomFantasia;
	
	public boolean isEmpty(){
		if(IntegerUtils.empty(this.seqJuridica)){
			return true;
		}
		if (StringUtil.empty(this.razaoSocial)){
			return true;
		}
		if (StringUtil.empty(this.nomResponsavel)){
			return true;
		}
		if (StringUtil.empty(this.cnpj)){
			return true;
		}
		if (StringUtil.empty(this.numInscricao)){
			return true;
		}
		if (StringUtil.empty(this.nomFantasia)){
			return true;
		}
		return false;
	}

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
