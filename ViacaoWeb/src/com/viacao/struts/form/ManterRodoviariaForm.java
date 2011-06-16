package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.viacao.vo.EnderecoVO;
import com.viacao.vo.RodoviariaVO;

public class ManterRodoviariaForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	private RodoviariaVO rodoviariaVO;
	private EnderecoVO enderecoVO;
	private List<RodoviariaVO> listaRodoviaria;
	private String task;
	
	public void inicializar(){
		rodoviariaVO = new RodoviariaVO();
		enderecoVO = new EnderecoVO();
		listaRodoviaria = new ArrayList<RodoviariaVO>();
		task = "";
	}
	
	public RodoviariaVO getRodoviariaVO() {
		return rodoviariaVO;
	}
	public void setRodoviariaVO(RodoviariaVO rodoviariaVO) {
		this.rodoviariaVO = rodoviariaVO;
	}
	public EnderecoVO getEnderecoVO() {
		return enderecoVO;
	}
	public void setEnderecoVO(EnderecoVO enderecoVO) {
		this.enderecoVO = enderecoVO;
	}
	public List<RodoviariaVO> getListaRodoviaria() {
		return listaRodoviaria;
	}
	public void setListaRodoviaria(List<RodoviariaVO> listaRodoviaria) {
		this.listaRodoviaria = listaRodoviaria;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	

}
