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
import com.viacao.services.util.EstagioServices;
import com.viacao.struts.form.ManterViagemForm;
import com.viacao.utils.Constantes;
import com.viacao.vo.OnibusVO;
import com.viacao.vo.ViagemVO;

public class ManterViagemAction extends DispatchAction{

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm)form;
		frm.inicializar();
		return listarViagem(mapping, form, request, response);
	}
	
	public ActionForward listarViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm)form;
		frm.setListaViagem(EstagioServices.getManterCadastroBean().getListaViagem(frm.getViagemVO()));
		return mapping.findForward("listar");
	}
	
	public ActionForward paginaCadastrarViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm)form;
		frm.limparViagemVO();
		frm.setListaItinerario(EstagioServices.getManterCadastroBean().getListaItinerario(frm.getViagemVO().getItinerarioVo()));
		frm.setListaOnibus(EstagioServices.getManterCadastroBean().getListaOnibus(new OnibusVO()));
		return mapping.findForward("cadastrar");
	}
	
	public ActionForward inserirViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm) form;
		ActionMessages messages = new ActionMessages();
		messages = frm.validate(request);
		try{	
			if(messages.isEmpty()){
				EstagioServices.getManterCadastroBean().inserir(frm.getViagemVO());
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.incluir"));
			}
			else{
				saveMessages(request, messages);
				return mapping.findForward("cadastrar");
			}
		}
		catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	
	private void getViagemVO(ManterViagemForm frm) throws Exception{
		frm.getViagemVO().setSeqViagem(frm.getSeqViagem());
		frm.setViagemVO(EstagioServices.getManterCadastroBean().getViagem(frm.getViagemVO()));
	}
	
	public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm) form;
		ActionMessages messages = new ActionMessages();
		try{
			frm.limparViagemVO();
			frm.setListaItinerario(EstagioServices.getManterCadastroBean().getListaItinerario(frm.getViagemVO().getItinerarioVo()));
			frm.setListaOnibus(EstagioServices.getManterCadastroBean().getListaOnibus(new OnibusVO()));
			getViagemVO(frm);
		}
		catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return mapping.findForward("alterar");
	}
	
	public ActionForward confirmAlterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm) form;
		ActionMessages messages = new ActionMessages();
		messages = frm.validate(request);
		try{	
			if(messages.isEmpty()){
				EstagioServices.getManterCadastroBean().alterar(frm.getViagemVO());
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.alterar"));
			}
			else{
				saveMessages(request, messages);
				return mapping.findForward("alterar");
			}
		}
		catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	public ActionForward deletar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm) form;
		ActionMessages messages = new ActionMessages();
		try{
			getViagemVO(frm);
			EstagioServices.getManterCadastroBean().deletar(frm.getViagemVO());
			messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.deletar"));
		}
		catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
}
