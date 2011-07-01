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

import com.acol.vo.DataVO;
import com.viacao.services.util.EstagioServices;
import com.viacao.struts.form.ManterOnibusForm;
import com.viacao.struts.form.ManterViagemForm;
import com.viacao.utils.Constantes;
import com.viacao.vo.ItinerarioVo;
import com.viacao.vo.OnibusVO;
import com.viacao.vo.ViagemVO;

public class ManterViagemAction extends DispatchAction{

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm)form;
		frm.inicializar();
//		frm.setListaViagem(EstagioServices.getManterCadastroBean().getListaViagem(frm.getViagemVO()));
//		frm.inicializar();
		
		return listarViagem(mapping, form, request, response);
	}
	
	public ActionForward listarViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm)form;
		ViagemVO viagemVO = new ViagemVO();
		frm.setListaViagem(EstagioServices.getManterCadastroBean().getListaViagem(frm.getViagemVO()));
		
			return mapping.findForward("listar");
	}
	
	public ActionForward paginaCadastrarViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm)form;
		frm.setListaItinerario(EstagioServices.getManterCadastroBean().listaItinerario(new ItinerarioVo()));
		frm.setListaOnibus(EstagioServices.getManterCadastroBean().getListaOnibus(new OnibusVO()));
		
			return mapping.findForward("cadastrar");
	}
	
	public ActionForward inserirViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm) form;
		ActionMessages messages = new ActionMessages();
		ViagemVO viagemVO = new ViagemVO();
		messages = frm.validate(request);

		try{			
			viagemVO.setItinerarioVo(frm.getViagemVO().getItinerarioVo());
			viagemVO.setOnibusVO(frm.getViagemVO().getOnibusVO());
			
			if(frm.getViagemVO().getOnibusVO().equals("") || frm.getViagemVO().getOnibusVO() == null){
				viagemVO.setOnibusVO(null);
			}
			else{
				viagemVO.setOnibusVO(new OnibusVO());
			}
			viagemVO.setOnibusVO(frm.getViagemVO().getOnibusVO());
			
			if(messages.isEmpty()){
				EstagioServices.getManterCadastroBean().inserir(viagemVO);
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
	
	public ActionForward inserirNovaViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm)form;
		ActionMessages messages = new ActionMessages();
		ViagemVO viagemVO = new ViagemVO();

		try{
			viagemVO.setSeqViagem(frm.getViagemVO().getSeqViagem());
			viagemVO.setItinerarioVo(frm.getViagemVO().getItinerarioVo());
			viagemVO.setOnibusVO(frm.getViagemVO().getOnibusVO());
			viagemVO.setHoraSaida(frm.getViagemVO().getHoraSaida());
			viagemVO.setHoraChegada(frm.getViagemVO().getHoraChegada());
		
//		EstagioServices.getManterCadastroBean().inserir(viagemVO);
			if(messages.isEmpty()){
			EstagioServices.getManterCadastroBean().inserir(viagemVO);
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
	
	public ActionForward recuperarViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm)form;
		ActionMessages messages = new ActionMessages();
		ViagemVO viagemVO = new ViagemVO();
		
		viagemVO.setSeqViagem(frm.getSeqViagem());
//		frm.setViagemVO(EstagioServices.getManterCadastroBean().getViagem(viagemVO));
//		frm.setOnibusVO(frm.setViagemVO().getOnibusVO(). toString());
		
		if(frm.getSeqViagem().equals("DELETAR")){
			return mapping.findForward("deletar");
		}
			else{
				return mapping.findForward("alterar");
			}
		if(frm.getSeqViagem().equals("ALTERAR")){
			return mapping.findForward("alterar");
		}
			else{
				return mapping.findForward("listar");
			}
	}
	
	public ActionForward alterarViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm) form;
		ActionMessages messages = new ActionMessages();
		ViagemVO viagemVO = new ViagemVO();
		messages = frm.validate(request);
		
		try{
			viagemVO.setSeqViagem(frm.getViagemVO().getSeqViagem());
			viagemVO.setItinerarioVo(frm.getViagemVO().getItinerarioVo());
			viagemVO.setOnibusVO(frm.getViagemVO().getOnibusVO());
			viagemVO.setHoraSaida(frm.getViagemVO().getHoraSaida());
			viagemVO.setHoraChegada(frm.getViagemVO().getHoraChegada());
			
			if(frm.getViagemVO().getOnibusVO().equals("") || frm.getViagemVO().getOnibusVO() == null){
//				EstagioServices.getManterCadastroBean().alterar(viagemVO);
				viagemVO.setOnibusVO(null);
			}
			else{
				viagemVO.setOnibusVO(new OnibusVO());
			}
			viagemVO.setOnibusVO(frm.getViagemVO().getOnibusVO());

			if(messages.isEmpty()){
				EstagioServices.getManterCadastroBean().alterar(viagemVO);
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
	
	public ActionForward deletarViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm) form;
		ActionMessages messages = new ActionMessages();
		ViagemVO viagemVO = new ViagemVO();
		
		try{
			viagemVO.setSeqViagem(frm.getViagemVO().getSeqViagem());
			viagemVO.setItinerarioVo(frm.getViagemVO().getItinerarioVo());
			viagemVO.setOnibusVO(frm.getViagemVO().getOnibusVO());
			viagemVO.setHoraSaida(frm.getViagemVO().getHoraSaida());
			viagemVO.setHoraChegada(frm.getViagemVO().getHoraChegada());
//		EstagioServices.getManterCadastroBean().deletar(viagemVO);
			messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.deletar"));
		}
		catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return unspecified(mapping, form, request, response);
	}
	
	public ActionForward limpar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm) form;
			frm.getViagemVO().setSeqViagem(null);
			frm.setListaViagem(null);
			frm.getViagemVO().setItinerarioVo(null);
			frm.setListaItinerario(null);
			frm.getViagemVO().setOnibusVO(new OnibusVO());
			frm.getViagemVO().setHoraSaida(null);
			frm.getViagemVO().setHoraChegada(null);
		return mapping.findForward("alterar");
	}
}
