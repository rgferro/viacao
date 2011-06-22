package com.viacao.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.viacao.services.util.EstagioServices;
import com.viacao.struts.form.ManterJuridicaForm;
import com.viacao.vo.FisicaVO;
import com.viacao.vo.JuridicaVO;

public class ManterJuridicaAction extends DispatchAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterJuridicaForm frm = (ManterJuridicaForm)form;
		frm.inicializar();		
		return listarJuridica(mapping, form, request, response);
	}
	
	public ActionForward listarJuridica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterJuridicaForm frm = (ManterJuridicaForm)form;
		JuridicaVO juridicaVO = new JuridicaVO();
		
		juridicaVO.setRazaoSocial(frm.getJuridicaVO().getRazaoSocial());
		juridicaVO.getClienteVO().setLogin(frm.getJuridicaVO().getClienteVO().getLogin());
		juridicaVO.getClienteVO().setEmail(frm.getJuridicaVO().getClienteVO().getEmail());
		
		List<JuridicaVO> listaClienteJuridico = EstagioServices.getManterCadastroBean().getListaClienteJuridica(juridicaVO);
		frm.setListaClienteJuridico(listaClienteJuridico);
		return null;
	}
	
	public ActionForward inserirJuridica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterJuridicaForm frm = (ManterJuridicaForm)form;
		
		try{
			EstagioServices.getManterCadastroBean().inserirJuridica(frm.getJuridicaVO());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public ActionForward alterarJuridica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterJuridicaForm frm = (ManterJuridicaForm)form;
		
		try{
			EstagioServices.getManterCadastroBean().alterarJuridica(frm.getJuridicaVO());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public ActionForward getJuridica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterJuridicaForm frm = (ManterJuridicaForm)form;
		JuridicaVO juridicaVO = new JuridicaVO();
		
		juridicaVO.setSeqJuridica(frm.getSeqjuridica());
		
		List<JuridicaVO> listaClienteJuridico = EstagioServices.getManterCadastroBean().getListaClienteJuridica(juridicaVO);
		frm.setListaClienteJuridico(listaClienteJuridico);
		return null;
	}
}
