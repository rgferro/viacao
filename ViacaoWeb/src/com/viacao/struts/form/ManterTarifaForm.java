package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.viacao.utils.Constantes;
import com.viacao.vo.TarifaVO;

public class ManterTarifaForm extends ActionForm{

	private TarifaVO tarifaVO;
	private List listaTarifas;
	private String task;
	private String acao;
	private Integer seqTarifa;
	private String busca = "";
	
	public void inicializar(){
		tarifaVO = new TarifaVO();
		listaTarifas = new ArrayList();
		acao = "INCLUIR";
	}

	public TarifaVO getTarifaVO() {
		return tarifaVO;
	}

	public void setTarifaVO(TarifaVO tarifaVO) {
		this.tarifaVO = tarifaVO;
	}

	public List getListaTarifas() {
		return listaTarifas;
	}

	public void setListaTarifas(List listaTarifas) {
		this.listaTarifas = listaTarifas;
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

	public Integer getSeqTarifa() {
		return seqTarifa;
	}

	public void setSeqTarifa(Integer seqTarifa) {
		this.seqTarifa = seqTarifa;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}
}
