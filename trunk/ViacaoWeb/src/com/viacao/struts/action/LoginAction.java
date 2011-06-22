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
import com.viacao.struts.form.LoginForm;
import com.viacao.utils.Constantes;
import com.viacao.vo.ClienteVO;
import com.viacao.vo.JuridicaVO;

public class LoginAction extends DispatchAction {

	/*
	 *M�todo que inicializa a p�gina login
	 *return p�gina login 
	 * */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginForm frm = (LoginForm) form;
		frm.inicializar(mapping, request);
		request.getSession().removeAttribute("clienteVO");
	return mapping.findForward("login");
	}
	
	/*
	 * M�todo verifica se o us�ario ir� se logar e se � cliente ou administrador
	 * return p�gina de login (n�o usu�rio)
	 * 
	 */
	public ActionForward logar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginForm frm = (LoginForm) form;
		ActionMessages messages = frm.validacao(mapping, request);
		
		ClienteVO clienteVO = EstagioServices.getManterCadastroBean().getCliente(frm.getClienteVO());
		 
		if((clienteVO.isEmpty() == true)){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.login", "login", "senha"));
			saveMessages(request, messages);
			return mapping.findForward("login");
		}
		/*
		JuridicaVO juridicaVO = new JuridicaVO();
		FisicaVO fisicaVO = new FisicaVO();
		
		if((juridicaVO.isEmpty() == true)&&(fisicaVO.isempty() == true)){
			request.getSession().setAttribute("Adm", clienteVO);
		}
		*/
		request.getSession().setAttribute("clienteVO", clienteVO);
		saveMessages(request, messages);
		return mapping.findForward("login");
	}
	
	

}
