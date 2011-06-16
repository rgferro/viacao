package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.viacao.vo.ViagemVO;


public class ManterViagemForm extends ActionForm{

	private static final long serialVersionUID = 1L;
	
	private ViagemVO viagemVO;
	private List<ViagemVO> listaViagem;
	private Integer seqViagem;
	private String acao;
	
	
	public void inicializar(){
		this.viagemVO = new ViagemVO();
		this.listaViagem = new ArrayList<ViagemVO>();
		this.seqViagem = null;
	}
	
	public ViagemVO getViagemVO() {
		return viagemVO;
	}

	public void setViagemVO(ViagemVO viagemVO) {
		this.viagemVO = viagemVO;
	}
	
	public List<ViagemVO> getListaViagem() {
		return listaViagem;
	}

	public void setListaViagem(List<ViagemVO> listaViagem) {
		this.listaViagem = listaViagem;
	}

	public Integer getSeqViagem() {
		return seqViagem;
	}

	public void setSeqViagem(Integer seqViagem) {
		this.seqViagem = seqViagem;
	}
	
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
}

