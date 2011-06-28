package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessages;

import com.viacao.vo.ClienteVO;
import com.viacao.vo.EnderecoVO;
import com.viacao.vo.FisicaVO;
import com.viacao.vo.JuridicaVO;

public class ManterClienteFisicaForm extends ActionForm{
	
	private FisicaVO fisicaVO;
	private List<FisicaVO> listaClienteFisico;
	private Integer seqFisica;
	private Integer seqEndereco;
	private String task;
	private String acao;

	public void inicializar(){
		this.fisicaVO = new FisicaVO();
		this.fisicaVO.setClienteVO(new ClienteVO());
		this.fisicaVO.getClienteVO().setEnderecoVO(new EnderecoVO());
		this.listaClienteFisico = new ArrayList<FisicaVO>();
		this.seqFisica = null;
		this.seqEndereco = null;
		this.task = "";
		this.acao = "";
	}
	
	public ActionMessages validate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
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

	public Integer getSeqFisica() {
		return seqFisica;
	}

	public void setSeqFisica(Integer seqFisica) {
		this.seqFisica = seqFisica;
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

	public Integer getSeqEndereco() {
		return seqEndereco;
	}

	public void setSeqEndereco(Integer seqEndereco) {
		this.seqEndereco = seqEndereco;
	}
		
}
