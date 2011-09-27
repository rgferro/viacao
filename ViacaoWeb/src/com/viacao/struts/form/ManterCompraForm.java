package com.viacao.struts.form;

import org.apache.struts.action.ActionForm;

public class ManterCompraForm extends ActionForm{
	
	private String task;
	private String poltrona;
	
	public void inicializar(){
		this.task = "";
		this.poltrona = "";
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getPoltrona() {
		return poltrona;
	}

	public void setPoltrona(String poltrona) {
		this.poltrona = poltrona;
	}

}
