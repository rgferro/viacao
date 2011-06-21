package com.viacao.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.acol.vo.DataVO;
import com.viacao.services.util.EstagioServices;
import com.viacao.struts.form.ManterViagemForm;
import com.viacao.vo.ItinerarioVo;
import com.viacao.vo.OnibusVO;
import com.viacao.vo.ViagemVO;

public class ManterViagemAction extends DispatchAction{

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm)form;
		

		ViagemVO viagemVO = new ViagemVO();

		frm.inicializar();
//		frm.setListaViagem(EstagioServices.getManterCadastroBean().getListaViagem(frm.getViagemVO()));

		
//		frm.inicializar();
		frm.setListaViagem(EstagioServices.getManterCadastroBean().getListaViagem(viagemVO)); 
		
		return mapping.findForward("listar");
	}
	
	public ActionForward listarViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm)form;
		
//		frm.setListaViagem(EstagioServices.getManterCadastroBean().getListaViagem(frm.getViagemVO()));
		
			return mapping.findForward("listar");
	}
	
	public ActionForward paginaCadastrarViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm)form;
		frm.setListaItinerario(EstagioServices.getManterCadastroBean().listaItinerario(new ItinerarioVo()));
		frm.setListaOnibus(EstagioServices.getManterCadastroBean().getListaOnibus(new OnibusVO()));
		return mapping.findForward("cadastrar");
	}
	
	public ActionForward inserirViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm)form;
		
		ViagemVO viagemVO = new ViagemVO();
		
		viagemVO.setItinerarioVo(frm.getViagemVO().getItinerarioVo());
		viagemVO.setOnibusVO(frm.getViagemVO().getOnibusVO());
		viagemVO.setHoraSaida(frm.getViagemVO().getHoraSaida());
		viagemVO.setHoraChegada(frm.getViagemVO().getHoraChegada());
		
//		EstagioServices.getManterCadastroBean().inserir(viagemVO);
		
			return mapping.findForward("listar");
	}
	
	public ActionForward recuperarViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm)form;
		
		ViagemVO viagemVO = new ViagemVO();
		
		viagemVO.setSeqViagem(frm.getSeqViagem());
//		frm.setViagemVO(EstagioServices.getManterCadastroBean().getViagem(viagemVO));
		
		if(frm.getAcao().equals("deletando")){
			
			return mapping.findForward("deletar");
		}
		else{
			
			return mapping.findForward("alterar");
		}
	}		
	public ActionForward alterarViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm) form;
		
		ViagemVO viagemVO = new ViagemVO();
			
		viagemVO.setItinerarioVo(frm.getViagemVO().getItinerarioVo());
		viagemVO.setOnibusVO(frm.getViagemVO().getOnibusVO());
		viagemVO.setHoraSaida(frm.getViagemVO().getHoraSaida());
		viagemVO.setHoraChegada(frm.getViagemVO().getHoraChegada());
			
//		EstagioServices.getManterCadastroBean().alterar(viagemVO);
			
			return mapping.findForward("listar");
		}
	
	public ActionForward deletarViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm) form;
		
		ViagemVO viagemVO = new ViagemVO();
			
		viagemVO.setItinerarioVo(frm.getViagemVO().getItinerarioVo());
		viagemVO.setOnibusVO(frm.getViagemVO().getOnibusVO());
		viagemVO.setHoraSaida(frm.getViagemVO().getHoraSaida());
		viagemVO.setHoraChegada(frm.getViagemVO().getHoraChegada());
			
//		EstagioServices.getManterCadastroBean().alterar(viagemVO);
			
			return mapping.findForward("listar");
	}

}
