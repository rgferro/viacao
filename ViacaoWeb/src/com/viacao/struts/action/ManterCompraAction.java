package com.viacao.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.viacao.struts.form.ManterCompraForm;


public class ManterCompraAction extends DispatchAction{

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterCompraForm frm = (ManterCompraForm) form;
			
		return mapping.findForward("selecionarViagem");
	}
	
	public ActionForward condicoesDeCompra(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterCompraForm frm = (ManterCompraForm) form;
		
		return mapping.findForward("condicoesCompra");
	}
	
	public ActionForward escolherPoltrona(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterCompraForm frm = (ManterCompraForm) form;
		
		return mapping.findForward("escolherPoltrona");
	}
	
	public ActionForward selecionarPoltrona(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterCompraForm frm = (ManterCompraForm) form;
		
		frm.setPoltrona(request.getParameter("seqPoltrona"));
		
		
		return mapping.findForward("condicoesCompra");
	}
	
	public ActionForward carrinhoDeCompra(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterCompraForm frm = (ManterCompraForm) form;
		
		return mapping.findForward("carrinhoDeCompra");
	}
	
	public ActionForward dadosCartao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterCompraForm frm = (ManterCompraForm) form;
		
		return mapping.findForward("dadosCartao");
	}

	public ActionForward compraConcluida(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterCompraForm frm = (ManterCompraForm) form;
		
		return mapping.findForward("compraConcluida");
	}

}
