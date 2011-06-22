package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.viacao.vo.ClienteVO;
import com.viacao.vo.EnderecoVO;
import com.viacao.vo.FisicaVO;
import com.viacao.vo.JuridicaVO;

public class ManterJuridicaForm extends ActionForm {

	private Integer seqjuridica;
	private JuridicaVO juridicaVO;
	private List<JuridicaVO> listaClienteJuridico;
	
	public void inicializar(){
		this.juridicaVO = new JuridicaVO();
		this.juridicaVO.setClienteVO(new ClienteVO());
		this.juridicaVO.getClienteVO().setEnderecoVO(new EnderecoVO());
		this.listaClienteJuridico = new ArrayList<JuridicaVO>();
	}
	
	public JuridicaVO getJuridicaVO() {
		return juridicaVO;
	}

	public void setJuridicaVO(JuridicaVO juridicaVO) {
		this.juridicaVO = juridicaVO;
	}

	public List<JuridicaVO> getListaClienteJuridico() {
		return listaClienteJuridico;
	}
	
	public void setListaClienteJuridico(List<JuridicaVO> listaClienteJuridico) {
		this.listaClienteJuridico = listaClienteJuridico;
	}

	public Integer getSeqjuridica() {
		return seqjuridica;
	}

	public void setSeqjuridica(Integer seqjuridica) {
		this.seqjuridica = seqjuridica;
	}
}
