package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.viacao.utils.Constantes;
import com.viacao.vo.EnderecoVO;
import com.viacao.vo.RodoviariaVO;

public class ManterRodoviariaForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	private RodoviariaVO rodoviariaVO;
	private List<RodoviariaVO> listaRodoviaria;
	private String task;
	private String acao;
	
	public void inicializar(){
		rodoviariaVO = new RodoviariaVO();
		rodoviariaVO.setEnderecoVO(new EnderecoVO());
		listaRodoviaria = new ArrayList<RodoviariaVO>();
		task = "";
	}
	public ActionMessages validate(HttpServletRequest request){
		ActionMessages messages = new ActionMessages();
		
		if(rodoviariaVO.getNomRodoviaria().equals("") || rodoviariaVO.getNomRodoviaria() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio.nomRodoviaria"));
		}
		
		if(rodoviariaVO.getEnderecoVO().getLogradouro().equals("") || rodoviariaVO.getEnderecoVO().getLogradouro() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio.logradouro"));
		}		
		
		if(rodoviariaVO.getEnderecoVO().getNumero().equals("") || rodoviariaVO.getEnderecoVO().getNumero() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio.numero"));
		}

		if(rodoviariaVO.getEnderecoVO().getComplemento().equals("") ||rodoviariaVO.getEnderecoVO().getComplemento() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio.complemento"));
		}
		if(rodoviariaVO.getEnderecoVO().getBairro().equals("") || rodoviariaVO.getEnderecoVO().getBairro() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("erro.vazio.bairro"));
		}
		if(rodoviariaVO.getEnderecoVO().getCidade().equals("") || rodoviariaVO.getEnderecoVO().getCidade() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("erro.vazio.cidade"));
		}
		if(rodoviariaVO.getEnderecoVO().getEstado().equals("") || rodoviariaVO.getEnderecoVO().getEstado() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("erro.vazio.estado"));
		}
		
		return messages;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public RodoviariaVO getRodoviariaVO() {
		return rodoviariaVO;
	}
	public void setRodoviariaVO(RodoviariaVO rodoviariaVO) {
		this.rodoviariaVO = rodoviariaVO;
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
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
}
