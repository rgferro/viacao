package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.viacao.vo.ClienteVO;
import com.viacao.vo.EnderecoVO;
import com.viacao.vo.FisicaVO;

public class ManterClienteForm extends ActionForm{
	
	private FisicaVO fisicaVO;
	private List<FisicaVO> listaClienteFisico;
	
	public void inicializar(){
		this.fisicaVO = new FisicaVO();
		this.fisicaVO.setClienteVO(new ClienteVO());
		this.fisicaVO.getClienteVO().setEnderecoVO(new EnderecoVO());
		this.listaClienteFisico = new ArrayList<FisicaVO>();
	}

	public FisicaVO getFisicaVO() {
		return fisicaVO;
	}

	public void setFisicaVO(FisicaVO fisicaVO) {
		this.fisicaVO = fisicaVO;
	}

	public List<FisicaVO> getListaClienteFisico() {
		return listaClienteFisico;
	}

	public void setListaClienteFisico(List<FisicaVO> listaClienteFisico) {
		this.listaClienteFisico = listaClienteFisico;
	}
}
