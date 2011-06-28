package com.viacao.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.viacao.services.util.EstagioServices;
import com.viacao.struts.form.ManterJuridicaForm;
import com.viacao.struts.form.ManterOnibusForm;
import com.viacao.utils.Constantes;
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
		
//		juridicaVO.setRazaoSocial(frm.getJuridicaVO().getRazaoSocial());
//		juridicaVO.getClienteVO().setLogin(frm.getJuridicaVO().getClienteVO().getLogin());
//		juridicaVO.getClienteVO().setEmail(frm.getJuridicaVO().getClienteVO().getEmail());
		
		List<JuridicaVO> listaClienteJuridico = EstagioServices.getManterCadastroBean().getListaClienteJuridica(frm.getJuridicaVO());
		frm.setListaClienteJuridico(listaClienteJuridico);
		return mapping.findForward("listar");
	}
	
	public ActionForward paginaCadastrarClienteJuridica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterJuridicaForm frm = (ManterJuridicaForm)form;
		return mapping.findForward("cadastrar");
	}
	
	public ActionForward inserirJuridica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterJuridicaForm frm = (ManterJuridicaForm)form;
		ActionMessages messages = new ActionMessages();
		messages = frm.validate(request);
		
		try{
			if(messages.isEmpty()){
				EstagioServices.getManterCadastroBean().inserirJuridica(frm.getJuridicaVO());
			}else{
				saveMessages(request, messages);
				return mapping.findForward("inserir");
			}
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward alterarJuridica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterJuridicaForm frm = (ManterJuridicaForm)form;
		ActionMessages messages = new ActionMessages();
		messages = frm.validate(request);
		
		try{
			if(messages.isEmpty()){
				EstagioServices.getManterCadastroBean().alterarJuridica(frm.getJuridicaVO());
			}else{
				saveMessages(request, messages);
				return mapping.findForward("inserir");
			}
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward getJuridica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterJuridicaForm frm = (ManterJuridicaForm)form;
		ActionMessages messages = new ActionMessages();
		JuridicaVO juridicaVO = new JuridicaVO();
		
		juridicaVO.setSeqJuridica(frm.getSeqjuridica());
		
		List<JuridicaVO> listaClienteJuridico = EstagioServices.getManterCadastroBean().getListaClienteJuridica(juridicaVO);
		frm.setListaClienteJuridico(listaClienteJuridico);

		if(frm.getAcao().equals("DELETAR")){
			return mapping.findForward("deletar");
		}else if(frm.getAcao().equals("CONSULTAR")){
			return mapping.findForward("consultar");
		}else{
			return mapping.findForward("alterar");
		}
	}
}
