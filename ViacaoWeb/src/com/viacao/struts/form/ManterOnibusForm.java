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
import com.viacao.vo.OnibusVO;

public class ManterOnibusForm extends ActionForm {

	private OnibusVO onibusVO;
	private List<OnibusVO> listaOnibus;
	private Integer seqOnibus;
	private String acao;
	private String task;
	
	private String empresaParam;
	private String tipoParam;
	private String qtdPoltronaParam;
	private String placaParam;
	

	public void inicializar(){
		this.onibusVO = new OnibusVO();
		this.onibusVO.setQtdPoltronas(0);
		this.onibusVO.setEmpresa("");
		this.listaOnibus = new ArrayList<OnibusVO>();
		this.seqOnibus = null;
		this.task = "";
	}
	
	public ActionMessages validate(HttpServletRequest request){
		ActionMessages messages = new ActionMessages();
		
		if(onibusVO.getEmpresa().equals("") || onibusVO.getEmpresa() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio.empresa"));
		}
		
		if(onibusVO.getTipo().equals("") || onibusVO.getTipo() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio.tipo"));
		}		
		
		if(onibusVO.getQtdPoltronas() == 0 || onibusVO.getQtdPoltronas() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio.poltronas"));
		}

		if(onibusVO.getPlaca().equals("") || onibusVO.getPlaca() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio.placa"));
		}
		
		return messages;
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
	
	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getEmpresaParam() {
		return empresaParam;
	}

	public void setEmpresaParam(String empresaParam) {
		this.empresaParam = empresaParam;
	}

	public String getTipoParam() {
		return tipoParam;
	}

	public void setTipoParam(String tipoParam) {
		this.tipoParam = tipoParam;
	}

	public String getQtdPoltronaParam() {
		return qtdPoltronaParam;
	}

	public void setQtdPoltronaParam(String qtdPoltronaParam) {
		this.qtdPoltronaParam = qtdPoltronaParam;
	}

	public String getPlacaParam() {
		return placaParam;
	}

	public void setPlacaParam(String placaParam) {
		this.placaParam = placaParam;
	}
}
