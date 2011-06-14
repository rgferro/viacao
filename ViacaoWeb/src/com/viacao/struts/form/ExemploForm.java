package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.viacao.vo.ExemploVO;

public class ExemploForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	private ExemploVO exemploVO;
	private List<ExemploVO> listaExemplo;
	private String task;
	private String acao;
	private String seqExemplo;
	private String busca = "";
	
	public void inicializar(){
		exemploVO = new ExemploVO();
		listaExemplo = new ArrayList<ExemploVO>();
		acao = "INCLUIR";
	}

	public ExemploVO getExemploVO() {
		return exemploVO;
	}

	public void setExemploVO(ExemploVO exemploVO) {
		this.exemploVO = exemploVO;
	}


	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public String getSeqExemplo() {
		return seqExemplo;
	}

	public void setSeqExemplo(String seqExemplo) {
		this.seqExemplo = seqExemplo;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public List<ExemploVO> getListaExemplo() {
		return listaExemplo;
	}

	public void setListaExemplo(List<ExemploVO> listaExemplo) {
		this.listaExemplo = listaExemplo;
	}
	

}
