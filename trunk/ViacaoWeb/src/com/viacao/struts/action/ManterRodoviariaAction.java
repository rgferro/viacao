package com.viacao.struts.action;

import java.rmi.RemoteException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.acol.exception.SystemException;
import com.viacao.services.util.EstagioServices;
import com.viacao.struts.form.ManterRodoviariaForm;




public class ManterRodoviariaAction extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping,ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		ManterRodoviariaForm frm = (ManterRodoviariaForm)form;
		frm.inicializar();
		frm.setListaInicioRodoviaria(EstagioServices.getManterCadastroBean().listaInicioRodoviaria(frm.getRodoviariaVO()));
		return forward(mapping, form, request, response);
	}
	
	public ActionForward inserir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ){
		ManterRodoviariaForm frm = (ManterRodoviariaForm)form;
		frm.inicializar();
		return mapping.findForward("inserir");
	}
	
	public ActionForward confirmaInserir(ActionMapping mapping, ActionForm form, HttpServletRequest request ,HttpServletResponse response) throws Exception{
		ManterRodoviariaForm frm = (ManterRodoviariaForm)form;
		EstagioServices.getManterCadastroBean().inserir(frm.getRodoviariaVO());	
		return unspecified(mapping, form, request, response);
	}
	
	private void getRodoviaria(ManterRodoviariaForm form) throws RemoteException, SystemException{
		form.getRodoviariaVO().setSeqRodoviaria(form.getSeqRodoviaria());
		form.setRodoviariaVO(EstagioServices.getManterCadastroBean().getRodoviaria(form.getRodoviariaVO()));
	}
	
	public ActionForward deletar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ManterRodoviariaForm frm = (ManterRodoviariaForm)form;
		getRodoviaria(frm);
		return mapping.findForward("deletar");
	}
	public ActionForward confirmaDeletar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ManterRodoviariaForm frm = (ManterRodoviariaForm)form;
		
		EstagioServices.getManterCadastroBean().deletarEndereco(frm.getRodoviariaVO().getEnderecoVO());
		
		return unspecified(mapping, form, request, response);
	}

	public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		ManterRodoviariaForm frm = (ManterRodoviariaForm)form;
		getRodoviaria(frm);
		return mapping.findForward("alterar");
	}
	
	public ActionForward confirmaAlterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ManterRodoviariaForm frm = (ManterRodoviariaForm)form;
		EstagioServices.getManterCadastroBean().alterar(frm.getRodoviariaVO());
		
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward consultar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ManterRodoviariaForm frm = (ManterRodoviariaForm)form;
		getRodoviaria(frm);
		return mapping.findForward("consultar");
	}
	
	public ActionForward buscarRodoviaria(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		ManterRodoviariaForm frm = (ManterRodoviariaForm)form;
		frm.setListaInicioRodoviaria(EstagioServices.getManterCadastroBean().getListaRodoviaria(frm.getRodoviariaVO()));
		return forward(mapping, form, request, response);
	}
	
	public ActionForward forward(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
		return mapping.findForward("listar"); 
	}
	
}
