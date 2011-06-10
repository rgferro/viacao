package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.viacao.vo.OnibusVO;

public class ManterOnibusForm extends ActionForm {
	
	private OnibusVO onibusVO;
	private List listaOnibus;
	
	public void inicializar(){
		this.onibusVO = new OnibusVO();
		this.listaOnibus = new ArrayList();
	}
	
	public OnibusVO getOnibusVO() {
		return onibusVO;
	}

	public void setOnibusVO(OnibusVO onibusVO) {
		this.onibusVO = onibusVO;
	}
	
	public List getListaOnibus() {
		return listaOnibus;
	}

	public void setListaOnibus(List listaOnibus) {
		this.listaOnibus = listaOnibus;
	}
		
}
