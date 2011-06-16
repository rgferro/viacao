/**
 * 
 */
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
import com.viacao.struts.form.ManterItinerarioForm;
import com.viacao.utils.Constantes;
import com.viacao.vo.ItinerarioVo;

/**
 * @author Wallace Gon�alves
 * Classe respons�vel pelo CRUD de Itinerario.
 *
 */
public class ManterItinerarioAction extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ManterItinerarioForm form = (ManterItinerarioForm) frm;
		form.inicializar();
		
		return mapping.findForward("cadastrar");
		
		//return forwardListar(mapping, form, request, response);
		
	}
	
	/**
	 * M�todo respons�vel por cadastrar um itinerario.
	 * @param mapping - ActionMapping
	 * @param form - ActionForm
	 * @param request - HttpServletRequest
	 * @param response - HttpServletResponse
	 * @return mapping.findForward
	 * @throws Exception
	 */
	public ActionForward cadastrarItinerario(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ManterItinerarioForm form = (ManterItinerarioForm) frm;
		ActionMessages messages = new ActionMessages();
		
		try{
			EstagioServices.getManterCadastroBean().inserirItinerario(form.getItinerarioVo());
			messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.incluir"));
			
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		
		return unspecified(mapping, frm, request, response);
	}
	
	/**
	 * M�todo que altera um itinerario.
	 * @param mapping - ActionMapping
	 * @param form - ActionForm
	 * @param request - HttpServletRequest
	 * @param response - HttpServletResponse
	 * @return mapping.findForward
	 * @throws Exception
	 */
	public ActionForward alterarItinerario(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ManterItinerarioForm form = (ManterItinerarioForm) frm;
		ActionMessages messages = new ActionMessages();
		
		try{
			EstagioServices.getManterCadastroBean().alterarItinerario(form.getItinerarioVo());
			form.setItinerarioVo(new ItinerarioVo());
			messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.alterar"));
			
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		
		saveMessages(request, messages);
		
		return unspecified(mapping, frm, request, response);
	}
	
	public ActionForward excluirItinerario(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ManterItinerarioForm form = (ManterItinerarioForm)frm;
		
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward forwardListar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("listar");
	}
}