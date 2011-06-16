package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.acol.util.StringUtil;
import com.viacao.utils.Constantes;
import com.viacao.vo.TarifaVO;

public class ManterTarifaForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	private TarifaVO tarifaVO;
	private List<TarifaVO> listaTarifas;
	private String task;
	private String acao;
	private Integer seqTarifa;
	private String busca = "";
	
	public void inicializar(){
		tarifaVO = new TarifaVO();
		listaTarifas = new ArrayList<TarifaVO>();
		acao = "INCLUIR";
	}

	public ActionMessages validacao(ActionMapping mapping, HttpServletRequest request) {
		ActionMessages messages = new ActionMessages();
		if(StringUtil.empty(this.tarifaVO.getNomTarifa())){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio","Nome da Tarifa"));
		}
		if(this.tarifaVO.getValor().intValue() == 0){
			this.tarifaVO.setValor(null);
			if(messages.isEmpty()){
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio","Valor da Tarifa"));
			}
		}
		return messages;
	}
	public TarifaVO getTarifaVO() {
		return tarifaVO;
	}

	public void setTarifaVO(TarifaVO tarifaVO) {
		this.tarifaVO = tarifaVO;
	}

	public List<TarifaVO> getListaTarifas() {
		return listaTarifas;
	}

	public void setListaTarifas(List<TarifaVO> listaTarifas) {
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
