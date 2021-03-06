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
import com.viacao.struts.form.ManterOnibusForm;
import com.viacao.utils.Constantes;
import com.viacao.vo.OnibusVO;

public class ManterOnibusAction extends DispatchAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		frm.inicializar();
		return listarOnibus(mapping, form, request, response);
	}
	
	public ActionForward listarOnibus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		OnibusVO onibusVO = new OnibusVO();
		
		onibusVO.setEmpresa(frm.getOnibusVO().getEmpresa());
		onibusVO.setPlaca(frm.getOnibusVO().getPlaca());
		if(frm.getQtdPoltronas().equals("") || frm.getQtdPoltronas() == null){
			onibusVO.setQtdPoltronas(0);
		}else{
			onibusVO.setQtdPoltronas(new Integer(frm.getQtdPoltronas()));
		}
		onibusVO.setTipo(frm.getOnibusVO().getTipo());
		
		frm.setListaOnibus(EstagioServices.getManterCadastroBean().getListaOnibus(onibusVO));
		return mapping.findForward("listar");
	}
	
	public ActionForward paginaCadastrarOnibus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		frm.inicializar();
		return mapping.findForward("inserir");
	}
	
	public ActionForward inserirOnibus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		ActionMessages messages = new ActionMessages();
		OnibusVO onibusVO = new OnibusVO();
		messages = frm.validate(request);

		try{			
			onibusVO.setEmpresa(frm.getOnibusVO().getEmpresa());
			onibusVO.setPlaca(frm.getOnibusVO().getPlaca());
			
			if(frm.getQtdPoltronas().equals("") || frm.getQtdPoltronas() == null){
				onibusVO.setQtdPoltronas(0);
			}else{
				onibusVO.setQtdPoltronas(new Integer(frm.getQtdPoltronas()));
			}
			onibusVO.setTipo(frm.getOnibusVO().getTipo());
			
			if(messages.isEmpty()){
				EstagioServices.getManterCadastroBean().inserir(onibusVO);
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.incluir"));
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
	public ActionForward inserirOnibusNovo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		ActionMessages messages = new ActionMessages();
		OnibusVO onibusVO = new OnibusVO();

		try{
			onibusVO.setEmpresa(frm.getEmpresaParam());
			onibusVO.setPlaca(frm.getPlacaParam());
			onibusVO.setQtdPoltronas(new Integer(frm.getQtdPoltronaParam()));
			onibusVO.setTipo(frm.getTipoParam());
			
			if(messages.isEmpty()){
				EstagioServices.getManterCadastroBean().inserir(onibusVO);
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.incluir"));
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
	
	public ActionForward recuperarOnibus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		ActionMessages messages = new ActionMessages();
		OnibusVO onibusVO = new OnibusVO();
		
		onibusVO.setSeqOnibus(frm.getSeqOnibus());
		frm.setOnibusVO(EstagioServices.getManterCadastroBean().getOnibus(onibusVO));
		frm.setQtdPoltronas(frm.getOnibusVO().getQtdPoltronas().toString());
		
		if(frm.getAcao().equals("DELETAR")){
			return mapping.findForward("deletar");
		}else{
			return mapping.findForward("alterar");
		}
	}
	
	public ActionForward alterarOnibus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		ActionMessages messages = new ActionMessages();
		OnibusVO onibusVO = new OnibusVO();
		messages = frm.validate(request);
		
		try{
			onibusVO.setSeqOnibus(frm.getOnibusVO().getSeqOnibus());
			onibusVO.setEmpresa(frm.getOnibusVO().getEmpresa());
			onibusVO.setPlaca(frm.getOnibusVO().getPlaca());
			
			if(frm.getQtdPoltronas().equals("") || frm.getQtdPoltronas() == null){
				onibusVO.setQtdPoltronas(0);
			}else{
				onibusVO.setQtdPoltronas(new Integer(frm.getQtdPoltronas()));
			}
			onibusVO.setTipo(frm.getOnibusVO().getTipo());
			
			if(messages.isEmpty()){
				EstagioServices.getManterCadastroBean().alterar(onibusVO);
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.alterar"));
			}else{
				saveMessages(request, messages);
				return mapping.findForward("alterar");
			}
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward deletarOnibus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		ActionMessages messages = new ActionMessages();
		OnibusVO onibusVO = new OnibusVO();
		
		try{
			onibusVO.setSeqOnibus(frm.getOnibusVO().getSeqOnibus());
			onibusVO.setEmpresa(frm.getOnibusVO().getEmpresa());
			onibusVO.setPlaca(frm.getOnibusVO().getPlaca());
			onibusVO.setQtdPoltronas(frm.getOnibusVO().getQtdPoltronas());
			onibusVO.setTipo(frm.getOnibusVO().getTipo());
			
			EstagioServices.getManterCadastroBean().deletar(onibusVO);
			messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.deletar"));
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward limpar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
			frm.getOnibusVO().setQtdPoltronas(null);
			frm.setQtdPoltronas(null);
			frm.getOnibusVO().setPlaca("");
			frm.getOnibusVO().setTipo("");
			frm.getOnibusVO().setEmpresa("");
		return mapping.findForward("alterar");
	}
}
