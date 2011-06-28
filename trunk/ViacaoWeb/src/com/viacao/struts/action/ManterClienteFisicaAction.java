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
import com.viacao.struts.form.ManterClienteFisicaForm;
import com.viacao.struts.form.ManterJuridicaForm;
import com.viacao.struts.form.ManterOnibusForm;
import com.viacao.utils.Constantes;
import com.viacao.vo.ClienteVO;
import com.viacao.vo.FisicaVO;
import com.viacao.vo.JuridicaVO;

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
		
		FisicaVO fisicaVO = new FisicaVO();
		
		try{
			fisicaVO.setSeqFisica(frm.getSeqFisica());
			fisicaVO.setCpfPessoa(frm.getFisicaVO().getCpfPessoa());
			fisicaVO.setNomPessoa(frm.getFisicaVO().getNomPessoa());
			fisicaVO.setRgPessoa(frm.getFisicaVO().getRgPessoa());
			
			EstagioServices.getManterCadastroBean().inserirFisica(fisicaVO);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
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
		
		FisicaVO fisicaVO = new FisicaVO();
		
		try{
			fisicaVO.getClienteVO().setLogin(frm.getFisicaVO().getClienteVO().getLogin());
			fisicaVO.getClienteVO().setSenha(frm.getFisicaVO().getClienteVO().getSenha());
			
			fisicaVO.setSeqFisica(frm.getFisicaVO().getSeqFisica());
			fisicaVO.setCpfPessoa(frm.getFisicaVO().getCpfPessoa());
			fisicaVO.setNomPessoa(frm.getFisicaVO().getNomPessoa());
			fisicaVO.setRgPessoa(frm.getFisicaVO().getRgPessoa());
			fisicaVO.getClienteVO().setEmail(frm.getFisicaVO().getClienteVO().getEmail());
			
			fisicaVO.getClienteVO().getEnderecoVO().setLogradouro(frm.getFisicaVO().getClienteVO().getEnderecoVO().getLogradouro());
			fisicaVO.getClienteVO().getEnderecoVO().setNumero(frm.getFisicaVO().getClienteVO().getEnderecoVO().getNumero());
			fisicaVO.getClienteVO().getEnderecoVO().setComplemento(frm.getFisicaVO().getClienteVO().getEnderecoVO().getComplemento());
			fisicaVO.getClienteVO().getEnderecoVO().setBairro(frm.getFisicaVO().getClienteVO().getEnderecoVO().getComplemento());
			fisicaVO.getClienteVO().getEnderecoVO().setCidade(frm.getFisicaVO().getClienteVO().getEnderecoVO().getCidade());
			fisicaVO.getClienteVO().getEnderecoVO().setEstado(frm.getFisicaVO().getClienteVO().getEnderecoVO().getCidade());
			
			EstagioServices.getManterCadastroBean().alterarFisica(fisicaVO);
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward alterarCliente(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterClienteFisicaForm frm = (ManterClienteFisicaForm)form;
		
		ClienteVO clienteVO = new ClienteVO();
		
		try{
			clienteVO.setSeqCliente(frm.getFisicaVO().getClienteVO().getSeqCliente());
			clienteVO.setEmail(frm.getFisicaVO().getClienteVO().getEmail());
			clienteVO.setEnderecoVO(frm.getFisicaVO().getClienteVO().getEnderecoVO());
			clienteVO.setLogin(frm.getFisicaVO().getClienteVO().getLogin());
			clienteVO.setSenha(frm.getFisicaVO().getClienteVO().getSenha());
			
			EstagioServices.getManterCadastroBean().alterarCliente(clienteVO);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public ActionForward getFisica(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterClienteFisicaForm frm = (ManterClienteFisicaForm)form;
		
		FisicaVO fisicaVO = new FisicaVO();
		
		frm.getAcao();
		
		fisicaVO.setSeqFisica(frm.getSeqFisica());
		
		frm.setFisicaVO(EstagioServices.getManterCadastroBean().getClienteFisica(fisicaVO));
		
		frm.getFisicaVO();
		
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
