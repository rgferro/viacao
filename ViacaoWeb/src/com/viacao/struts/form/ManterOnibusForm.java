package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.viacao.vo.OnibusVO;

public class ManterOnibusForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	
	private OnibusVO onibusVO;
	private List<OnibusVO> listaOnibus;
	private Integer seqOnibus;
	private String acao;

	public void inicializar(){
		this.onibusVO = new OnibusVO();
		this.listaOnibus = new ArrayList<OnibusVO>();
		this.seqOnibus = null;
	}
	
	public OnibusVO getOnibusVO() {
		return onibusVO;
	}

	public void setOnibusVO(OnibusVO onibusVO) {
		this.onibusVO = onibusVO;
	}
	
	public List<OnibusVO> getListaOnibus() {
		return listaOnibus;
	}

	public void setListaOnibus(List<OnibusVO> listaOnibus) {
		this.listaOnibus = listaOnibus;
	}
	
	public Integer getSeqOnibus() {
		return seqOnibus;
	}

	public void setSeqOnibus(Integer seqOnibus) {
		this.seqOnibus = seqOnibus;
	}
	
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
		
}
