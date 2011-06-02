package com.viacao.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.viacao.services.util.EstagioServices;
import com.viacao.struts.form.ExemploForm;
import com.viacao.utils.Constantes;
import com.viacao.vo.ExemploVO;

public class ExemploAction extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ExemploForm frm = (ExemploForm)form;
		try{
			ExemploVO exemploVO = null;
			if(frm.getBusca().equals("pesquisar")){
				exemploVO = frm.getExemploVO();
			}
			frm.inicializar();
			frm.setListaExemplo(EstagioServices.getProcessoBean().readExemplo(exemploVO));
		}catch (Exception e) {
			ActionMessages messages = new ActionMessages();
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
			saveMessages(request, messages);
		}
		return forwardListar(mapping, form, request, response);
	}
	
	public ActionForward incluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ExemploForm frm = (ExemploForm)form;
		ActionMessages messages = new ActionMessages();
		try{
			EstagioServices.getProcessoBean().insertExemplo(frm.getExemploVO());
			messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.incluir"));
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward getExemplo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ExemploForm frm = (ExemploForm)form;
		try{
			frm.setExemploVO(EstagioServices.getProcessoBean().getExemplo(frm.getSeqExemplo()));
		}catch (Exception e) {
			ActionMessages messages = new ActionMessages();
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
			saveMessages(request, messages);
		}
		return forwardListar(mapping, form, request, response);
	}
	
	public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ExemploForm frm = (ExemploForm)form;
		ActionMessages messages = new ActionMessages();
		try{
			EstagioServices.getProcessoBean().updateExemplo(frm.getExemploVO());
			frm.setExemploVO(new ExemploVO());
			messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.alterar"));
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward deletar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ExemploForm frm = (ExemploForm)form;
		ActionMessages messages = new ActionMessages();
		try{
			EstagioServices.getProcessoBean().deleteExemplo(frm.getExemploVO());
			frm.setExemploVO(new ExemploVO());
			messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.deletar"));
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
