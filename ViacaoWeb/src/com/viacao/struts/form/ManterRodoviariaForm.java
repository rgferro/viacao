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
import com.viacao.vo.EnderecoVO;
import com.viacao.vo.RodoviariaVO;

public class ManterRodoviariaForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	private RodoviariaVO rodoviariaVO;

	private List<RodoviariaVO> listaRodoviaria;
	private List<RodoviariaVO> listaInicioRodoviaria;
	private List<RodoviariaVO> recuperaRodoviaria;
	
	private String task;
	private String acao;
	private Integer seqRodoviaria;

	public void inicializar(){
		rodoviariaVO = new RodoviariaVO();
		rodoviariaVO.setEnderecoVO(new EnderecoVO());
		listaRodoviaria = new ArrayList<RodoviariaVO>();
		this.listaInicioRodoviaria = new ArrayList<RodoviariaVO>();
		this.recuperaRodoviaria = new ArrayList<RodoviariaVO>();
		task = "";
	}
	public ActionMessages validate(HttpServletRequest request){
		ActionMessages messages = new ActionMessages();
		
		if(rodoviariaVO.getNomRodoviaria().equals("") || rodoviariaVO.getNomRodoviaria() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Nome da Rodoviária"));
		}
		
		if(rodoviariaVO.getEnderecoVO().getLogradouro().equals("") || rodoviariaVO.getEnderecoVO().getLogradouro() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Logradouro"));
		}		
		
		if(rodoviariaVO.getEnderecoVO().getNumero().equals("") || rodoviariaVO.getEnderecoVO().getNumero() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Número"));
		}

		if(rodoviariaVO.getEnderecoVO().getComplemento().equals("") ||rodoviariaVO.getEnderecoVO().getComplemento() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Complemento"));
		}
		if(rodoviariaVO.getEnderecoVO().getBairro().equals("") || rodoviariaVO.getEnderecoVO().getBairro() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Bairro"));
		}
		if(rodoviariaVO.getEnderecoVO().getCidade().equals("") || rodoviariaVO.getEnderecoVO().getCidade() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Cidade"));
		}
		if(rodoviariaVO.getEnderecoVO().getEstado().equals("") || rodoviariaVO.getEnderecoVO().getEstado() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Estado"));
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
	
	/**
	 * @return the listaRodoviaria
	 */
	public List<RodoviariaVO> getListaRodoviaria() {
		return listaRodoviaria;
	}
	/**
	 * @param listaRodoviaria the listaRodoviaria to set
	 */
	public void setListaRodoviaria(List<RodoviariaVO> listaRodoviaria) {
		this.listaRodoviaria = listaRodoviaria;
	}
	/**
	 * @return the recuperaRodoviaria
	 */
	public List<RodoviariaVO> getRecuperaRodoviaria() {
		return recuperaRodoviaria;
	}
	/**
	 * @param recuperaRodoviaria the recuperaRodoviaria to set
	 */
	public void setRecuperaRodoviaria(List<RodoviariaVO> recuperaRodoviaria) {
		this.recuperaRodoviaria = recuperaRodoviaria;
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
	/**
	 * @return the listaInicioRodoviaria
	 */
	public List<RodoviariaVO> getListaInicioRodoviaria() {
		return listaInicioRodoviaria;
	}
	/**
	 * @param listaInicioRodoviaria the listaInicioRodoviaria to set
	 */
	public void setListaInicioRodoviaria(List<RodoviariaVO> listaInicioRodoviaria) {
		this.listaInicioRodoviaria = listaInicioRodoviaria;
	}
	/**
	 * @return the seqRodoviaria
	 */
	public Integer getSeqRodoviaria() {
		return seqRodoviaria;
	}
	/**
	 * @param seqRodoviaria the seqRodoviaria to set
	 */
	public void setSeqRodoviaria(Integer seqRodoviaria) {
		this.seqRodoviaria = seqRodoviaria;
	}
}
