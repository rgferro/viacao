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
import com.viacao.services.util.EstagioServices;
import com.viacao.struts.form.ManterClienteFisicaForm;
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
		frm.getListaClienteJuridico();
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
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.incluir"));
			}else{
				saveMessages(request, messages);
				return mapping.findForward("cadastrar");
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
				frm.getJuridicaVO().setSeqJuridica(frm.getSeqJuridica());
				frm.getJuridicaVO().getClienteVO().setSeqCliente(frm.getSeqCliente());
				frm.getJuridicaVO().getClienteVO().getEnderecoVO().setSeqEndereco(frm.getSeqEndereco());
				
				EstagioServices.getManterCadastroBean().alterarJuridica(frm.getJuridicaVO());
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.alterar"));
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
	
	public ActionForward deletarJuridica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterJuridicaForm frm = (ManterJuridicaForm)form;
		ActionMessages messages = frm.validate(request);		
		
		try{
			if(messages.isEmpty()){
				frm.getJuridicaVO().getClienteVO().getEnderecoVO().setSeqEndereco(frm.getSeqEndereco());
				EstagioServices.getManterCadastroBean().deletarCliente(frm.getJuridicaVO().getClienteVO());
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.deletar"));
			}else{
				saveMessages(request, messages);
				return mapping.findForward("deletar");
			}
		}catch (ChildRecordFoundException e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.delete","juridica"));
		}
		catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward getJuridica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterJuridicaForm frm = (ManterJuridicaForm)form;
		ActionMessages messages = new ActionMessages();
		JuridicaVO juridicaVO = new JuridicaVO();
		
		juridicaVO.setSeqJuridica(frm.getSeqJuridica());
		
		frm.setJuridicaVO(EstagioServices.getManterCadastroBean().getClienteJuridica(juridicaVO));
		
		if(frm.getJuridicaVO().getNomResponsavel() == null){
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
	
	public ActionForward limpar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterJuridicaForm frm = (ManterJuridicaForm)form;
		frm.getJuridicaVO().getClienteVO().setLogin("");
		frm.getJuridicaVO().getClienteVO().setSenha("");
		frm.getJuridicaVO().getClienteVO().setEmail("");
		
		frm.getJuridicaVO().setCnpj("");
		frm.getJuridicaVO().setNomFantasia("");
		frm.getJuridicaVO().setNomResponsavel("");
		frm.getJuridicaVO().setNumInscricao("");
		frm.getJuridicaVO().setRazaoSocial("");
		
		frm.getJuridicaVO().getClienteVO().getEnderecoVO().setBairro("");
		frm.getJuridicaVO().getClienteVO().getEnderecoVO().setCidade("");
		frm.getJuridicaVO().getClienteVO().getEnderecoVO().setComplemento("");
		frm.getJuridicaVO().getClienteVO().getEnderecoVO().setEstado("");
		frm.getJuridicaVO().getClienteVO().getEnderecoVO().setLogradouro("");
		frm.getJuridicaVO().getClienteVO().getEnderecoVO().setNumero("");
		
		return mapping.findForward("alterar");
	}
}
