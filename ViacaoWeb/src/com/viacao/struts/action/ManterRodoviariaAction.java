package com.viacao.struts.action;

import java.rmi.RemoteException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.acol.exception.SystemException;
import com.acol.exception.business.ChildRecordFoundException;
import com.viacao.services.util.EstagioServices;
import com.viacao.struts.form.ManterRodoviariaForm;
import com.viacao.utils.Constantes;

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
		ActionMessages messages = frm.validate(request);
		if(!messages.isEmpty()){
			saveMessages(request, messages);
			return mapping.findForward("inserir");
		}else{
			try{
				EstagioServices.getManterCadastroBean().inserir(frm.getRodoviariaVO());
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.incluir"));
			}catch (RemoteException e) {
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.insert","rodoviária"));
			}catch (Exception e) {
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
			}
		}
		saveMessages(request, messages);
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
		ActionMessages messages = new ActionMessages();
		try{
			EstagioServices.getManterCadastroBean().deletarEndereco(frm.getRodoviariaVO().getEnderecoVO());
			messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.deletar"));
		}catch (RemoteException e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.delete","rodoviária"));
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		ManterRodoviariaForm frm = (ManterRodoviariaForm)form;
		getRodoviaria(frm);
		return mapping.findForward("alterar");
	}
	
	public ActionForward confirmaAlterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ManterRodoviariaForm frm = (ManterRodoviariaForm)form;
		ActionMessages messages = frm.validate(request);
		if(!messages.isEmpty()){
			saveMessages(request, messages);
			return mapping.findForward("alterar");
		}else{
			try{
				EstagioServices.getManterCadastroBean().alterar(frm.getRodoviariaVO());
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.alterar"));
			}catch (RemoteException e) {
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.update","rodoviária"));
			}catch (Exception e) {
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
			}
		}
		saveMessages(request, messages);		
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
