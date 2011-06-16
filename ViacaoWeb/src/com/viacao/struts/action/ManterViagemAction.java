package com.viacao.struts.action;

import java.util.ArrayList;
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
import com.viacao.vo.OnibusVO;
import com.viacao.vo.ViagemVO;

public class ManterViagemAction extends DispatchAction{

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm)form;
		
		frm.inicializar();
//		frm.setListaViagem(EstagioServices.getManterCadastroBean().getListaViagem(frm.getViagemVO()));
		
			return mapping.findForward("listar");
	}
	
	public ActionForward listarViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm)form;
		
//		frm.setListaViagem(EstagioServices.getManterCadastroBean().getListaViagem(frm.getViagemVO()));
		
			return mapping.findForward("listar");
	}

	public ActionForward inserirViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm)form;
		
		ViagemVO viagemVO = new ViagemVO();
		
		viagemVO.setItinerarioVO(frm.getViagemVO().getItinerarioVO());
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
			
		viagemVO.setItinerarioVO(frm.getViagemVO().getItinerarioVO());
		viagemVO.setOnibusVO(frm.getViagemVO().getOnibusVO());
		viagemVO.setHoraSaida(frm.getViagemVO().getHoraSaida());
		viagemVO.setHoraChegada(frm.getViagemVO().getHoraChegada());
			
//		EstagioServices.getManterCadastroBean().alterar(viagemVO);
			
			return mapping.findForward("listar");
		}
	
	public ActionForward deletarViagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterViagemForm frm = (ManterViagemForm) form;
		
		ViagemVO viagemVO = new ViagemVO();
			
		viagemVO.setItinerarioVO(frm.getViagemVO().getItinerarioVO());
		viagemVO.setOnibusVO(frm.getViagemVO().getOnibusVO());
		viagemVO.setHoraSaida(frm.getViagemVO().getHoraSaida());
		viagemVO.setHoraChegada(frm.getViagemVO().getHoraChegada());
			
//		EstagioServices.getManterCadastroBean().alterar(viagemVO);
			
			return mapping.findForward("listar");
	}

}
