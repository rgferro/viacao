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

import com.acol.exception.business.ChildRecordFoundException;
import com.acol.exception.business.UniqueConstraintViolatedException;
import com.viacao.services.util.EstagioServices;
import com.viacao.struts.form.ManterClienteFisicaForm;
import com.viacao.utils.Constantes;
import com.viacao.vo.ClienteVO;
import com.viacao.vo.FisicaVO;

public class ManterClienteFisicaAction extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterClienteFisicaForm frm = (ManterClienteFisicaForm)form;
		frm.inicializar();
		
		FisicaVO fisicaVO = new FisicaVO();
		
		frm.setListaClienteFisico(EstagioServices.getManterCadastroBean().getListaClienteFisica(fisicaVO));
		
		return mapping.findForward("listar");
	}
	
	public ActionForward listarFisica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterClienteFisicaForm frm = (ManterClienteFisicaForm)form;
		
		FisicaVO fisicaVO = new FisicaVO();
		
		if(frm.getSeqFisica() != null){
			fisicaVO.setSeqFisica(frm.getSeqFisica());
		}
		
		List<FisicaVO> listaClienteFisico = EstagioServices.getManterCadastroBean().getListaClienteFisica(fisicaVO);
		frm.setListaClienteFisico(listaClienteFisico);
		
		return null;
	}
	
	public ActionForward inserirFisica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterClienteFisicaForm frm = (ManterClienteFisicaForm)form;
		ActionMessages messages = frm.validate(request);
		
		frm.getTipUsuario();
		
		try{
			if(messages.isEmpty()){
				if(frm.getTipUsuario().equals("ADMINISTRADOR")){
					frm.getFisicaVO().setCpfPessoa("");
					frm.getFisicaVO().setNomPessoa("");
					frm.getFisicaVO().setRgPessoa("");
				}
				
				EstagioServices.getManterCadastroBean().inserirFisica(frm.getFisicaVO());
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.incluir"));
				
			}else{
				saveMessages(request, messages);
				return mapping.findForward("cadastrar");
			}
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
			saveMessages(request, messages);
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward paginaCadastrarClienteFisica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterClienteFisicaForm frm = (ManterClienteFisicaForm)form;
		
		frm.inicializar();
		
		return mapping.findForward("cadastrar");
	}
	
	public ActionForward alterarFisica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterClienteFisicaForm frm = (ManterClienteFisicaForm)form;
		ActionMessages messages = new ActionMessages();
		messages = frm.validate(request);
		
		try{
			if(messages.isEmpty()){
				frm.getFisicaVO().setSeqFisica(frm.getSeqFisica());
				frm.getFisicaVO().getClienteVO().setSeqCliente(frm.getSeqCliente());
				frm.getFisicaVO().getClienteVO().getEnderecoVO().setSeqEndereco(frm.getSeqEndereco());
				
				EstagioServices.getManterCadastroBean().alterarFisica(frm.getFisicaVO());
				
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.alterar"));
			}else{
				saveMessages(request, messages);
				return mapping.findForward("inserir");
			}
		}catch (UniqueConstraintViolatedException e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.update","fisica"));
		}
		catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward deletarFisica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterClienteFisicaForm frm = (ManterClienteFisicaForm)form;
		ActionMessages messages = frm.validate(request);		
		
		try{
			if(messages.isEmpty()){
				frm.getFisicaVO().getClienteVO().getEnderecoVO().setSeqEndereco(frm.getSeqEndereco());
				EstagioServices.getManterCadastroBean().deletarCliente(frm.getFisicaVO().getClienteVO());
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.deletar"));
			}else{
				saveMessages(request, messages);
				return mapping.findForward("deletar");
			}
		}catch (ChildRecordFoundException e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.delete","fisica"));
		}
		catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward getFisica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterClienteFisicaForm frm = (ManterClienteFisicaForm)form;
		
		FisicaVO fisicaVO = new FisicaVO();
		
		fisicaVO.setClienteVO(new ClienteVO());
		fisicaVO.getClienteVO().setSeqCliente(frm.getSeqCliente());
		
		frm.setFisicaVO(EstagioServices.getManterCadastroBean().getClienteFisica(fisicaVO));
		
		if(frm.getFisicaVO().getNomPessoa() == null){
			frm.setTipUsuario("ADMINISTRADOR");
		}else{
			frm.setTipUsuario("USUARIO");
		}
		
		if(frm.getAcao().equals("DELETAR")){
			return mapping.findForward("deletar");
		}else if(frm.getAcao().equals("CONSULTAR")){
			return mapping.findForward("consultar");
		}else{
			return mapping.findForward("alterar");
		}
	}
	
	public ActionForward trocaForm(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterClienteFisicaForm frm = (ManterClienteFisicaForm) form;
		
		response.sendRedirect(request.getContextPath()+"/manterJuridica.do?task=inserirJuridica");
		return null;
	}
	
	
}
