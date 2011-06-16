package com.viacao.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.viacao.services.util.EstagioServices;
import com.viacao.struts.form.ManterRodoviariaForm;


public class ManterRodoviariaAction extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping,ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterRodoviariaForm frm = (ManterRodoviariaForm)form;
		frm.inicializar();
		
		return mapping.findForward("inserir");
	}
	public ActionForward inserir(ActionMapping mapping, ActionForm form, HttpServletRequest request ,HttpServletResponse response) throws Exception{
		ManterRodoviariaForm frm = (ManterRodoviariaForm)form;
		
		frm.setListaRodoviaria(EstagioServices.getManterCadastroBean().getListaRodoviaria(frm.getRodoviariaVO()));
		
		return mapping.findForward("listar");
	}
	public ActionForward deletar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterRodoviariaForm frm = (ManterRodoviariaForm)form;
		
		return null;
	}
	public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterRodoviariaForm frm = (ManterRodoviariaForm)form;
		
		return null;
	}
	public ActionForm getRodoviaria(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterRodoviariaForm frm = (ManterRodoviariaForm)form;
		
		
		return null;
	}
 
}
