package com.viacao.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.acol.exception.business.ChildRecordFoundException;
import com.acol.exception.business.UniqueConstraintViolatedException;
import com.viacao.services.util.EstagioServices;
import com.viacao.struts.form.ManterTarifaForm;
import com.viacao.utils.Constantes;
import com.viacao.vo.TarifaVO;



public class ManterTarifaAction extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterTarifaForm frm = (ManterTarifaForm)form;
		try{
			TarifaVO tarifaVO = null;
			if(frm.getBusca().equals("pesquisar")){
				tarifaVO = frm.getTarifaVO();
			}
			frm.inicializar();
			frm.setListaTarifas(EstagioServices.getManterCadastroBean().getListaTarifa(tarifaVO));
		}catch (Exception e) {
			ActionMessages messages = new ActionMessages();
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
			saveMessages(request, messages);
		}
		return forwardListar(mapping, form, request, response);
	}
	
	public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterTarifaForm frm = (ManterTarifaForm)form;
		ActionMessages messages = frm.validacao(mapping, request);
		if(!messages.isEmpty()){
			saveMessages(request, messages);
			return forwardListar(mapping, form, request, response);
		}else{
			try{
				EstagioServices.getManterCadastroBean().inserir(frm.getTarifaVO());
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.incluir"));
			}catch (UniqueConstraintViolatedException e) {
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.insert","tarifa"));
			}catch (Exception e) {
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
			}
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward getTarifa(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterTarifaForm frm = (ManterTarifaForm)form;
		try{
			frm.getTarifaVO().setSeqTarifa(frm.getSeqTarifa());
			frm.setTarifaVO(EstagioServices.getManterCadastroBean().getTarifa(frm.getTarifaVO()));
		}catch (Exception e) {
			ActionMessages messages = new ActionMessages();
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
			saveMessages(request, messages);
		}
		return forwardListar(mapping, form, request, response);
	}
	
	public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterTarifaForm frm = (ManterTarifaForm)form;
		ActionMessages messages = frm.validacao(mapping, request);
		if(!messages.isEmpty()){
			saveMessages(request, messages);
			return forwardListar(mapping, form, request, response);
		}else{
			try{
				EstagioServices.getManterCadastroBean().alterar(frm.getTarifaVO());
				frm.setTarifaVO(new TarifaVO());
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.alterar"));
			}catch (UniqueConstraintViolatedException e) {
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.update","tarifa"));
			}catch (Exception e) {
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
			}
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward deletar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterTarifaForm frm = (ManterTarifaForm)form;
		ActionMessages messages = new ActionMessages();
		try{
			EstagioServices.getManterCadastroBean().deletar(frm.getTarifaVO());
			frm.setTarifaVO(new TarifaVO());
			messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.deletar"));
		}catch (ChildRecordFoundException e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.delete","tarifa"));
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward forwardListar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("listar");
	}
}
