package com.viacao.struts.action;

import java.rmi.RemoteException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.acol.exception.SystemException;
import com.acol.util.CollectionsUtil;
import com.viacao.services.util.EstagioServices;
import com.viacao.struts.form.ManterCompraForm;
import com.viacao.struts.form.ManterItinerarioForm;
import com.viacao.utils.Constantes;
import com.viacao.vo.ItinerarioVo;
import com.viacao.vo.RodoviariaVO;
import com.viacao.vo.ViagemVO;


public class ManterCompraAction extends DispatchAction{

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		ManterCompraForm frm = (ManterCompraForm) form;
		
		frm.inicializar();
		
		try {
			frm.setListaRodoviariaOrigem(EstagioServices.getManterCadastroBean().listaInicioRodoviaria(new RodoviariaVO()));
			frm.setListaRodoviariaDestino(EstagioServices.getManterCadastroBean().listaInicioRodoviaria(new RodoviariaVO()));
		} catch (RemoteException e) {
		
		}
		
			
		return mapping.findForward("selecionarViagem");
	}
	
	public ActionForward buscaViagens(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		ManterCompraForm frm = (ManterCompraForm) form;
		ActionMessages messages = new ActionMessages();
		messages = frm.validate(request);
		
		try {
			ViagemVO viagemVO = new ViagemVO();
			viagemVO.setItinerarioVo(new ItinerarioVo());
			viagemVO.getItinerarioVo().setRodoviariaOrigemVO(new RodoviariaVO());
			viagemVO.getItinerarioVo().setRodoviariaDestinoVO(new RodoviariaVO());
			
			viagemVO.getItinerarioVo().setRodoviariaOrigemVO((RodoviariaVO) CollectionsUtil.returnObjectFromList(frm.getListaRodoviariaOrigem(), frm.getSeqRodoviariaOrigem().toString(), "seqRodoviaria"));
			frm.getViagemVO().getItinerarioVo().setRodoviariaOrigemVO(viagemVO.getItinerarioVo().getRodoviariaOrigemVO());
	
			viagemVO.getItinerarioVo().setRodoviariaDestinoVO((RodoviariaVO) CollectionsUtil.returnObjectFromList(frm.getListaRodoviariaDestino(), frm.getSeqRodoviariaDestino().toString(), "seqRodoviaria"));
			frm.getViagemVO().getItinerarioVo().setRodoviariaDestinoVO(viagemVO.getItinerarioVo().getRodoviariaDestinoVO());
			
			viagemVO.setHoraSaida(frm.getHoraSaidaIda());
			
			if(!frm.getHoraSaidaVolta().isEmpty()){
				viagemVO.setHoraChegada(frm.getHoraSaidaVolta());
			}else{
				viagemVO.setHoraChegada(null);
			}
			
			frm.setListaViagensIda(EstagioServices.getManterCadastroBean().getListaViagensCompraIda(viagemVO));
			frm.setListaViagensVolta(EstagioServices.getManterCadastroBean().getListaViagensCompraVolta(viagemVO));
			
			frm.getViagemVO().getItinerarioVo().setRodoviariaOrigemVO(viagemVO.getItinerarioVo().getRodoviariaOrigemVO());
			frm.getViagemVO().getItinerarioVo().setRodoviariaDestinoVO(viagemVO.getItinerarioVo().getRodoviariaDestinoVO());
			
			if(frm.getTipViagem().equals("idaVolta")){
				if(frm.getListaViagensIda().isEmpty() || frm.getListaViagensVolta().isEmpty()){
					messages.add(Constantes.MESSAGE_AVISO, new ActionMessage("error.busca.viagens", "Ida e Volta"));
					saveMessages(request, messages);
					return unspecified(mapping, form, request, response);
				}
			}else{
				if(frm.getListaViagensIda().isEmpty()){
					messages.add(Constantes.MESSAGE_AVISO, new ActionMessage("error.busca.viagens", "Ida"));
					saveMessages(request, messages);
					return unspecified(mapping, form, request, response);
				}
			}
			
		} catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
			saveMessages(request, messages);
		}
		
		return mapping.findForward("selecionarViagem");
	}
	
	public ActionForward limparOrigem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ManterCompraForm frm = (ManterCompraForm) form;
		frm.setListaRodoviariaOrigem(EstagioServices.getManterCadastroBean().listaInicioRodoviaria(new RodoviariaVO()));
		frm.getListaRodoviariaOrigem().remove(CollectionsUtil.find(frm.getListaRodoviariaOrigem(), "seqRodoviariaDestino", frm.getSeqRodoviariaDestino()));
		
		if(frm.getPagina().equals("selecionarViagem")){
			return mapping.findForward("selecionarViagem");
		}else{
			return mapping.findForward("selecionarViagem");
		}		
	}
	
	public ActionForward limparDestino(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ManterCompraForm frm = (ManterCompraForm) form;
		frm.setListaRodoviariaDestino(EstagioServices.getManterCadastroBean().listaInicioRodoviaria(new RodoviariaVO()));
		frm.getListaRodoviariaDestino().remove(CollectionsUtil.find(frm.getListaRodoviariaDestino(), "seqRodoviariaOrigem", frm.getSeqRodoviariaOrigem()));
		
		if(frm.getPagina().equals("selecionarViagem")){
			return mapping.findForward("selecionarViagem");
		}else{
			return mapping.findForward("selecionarViagem");
		}	
	}
	
	public ActionForward condicoesDeCompra(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterCompraForm frm = (ManterCompraForm) form;
		
		return mapping.findForward("condicoesCompra");
	}
	
	public ActionForward escolherPoltrona(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterCompraForm frm = (ManterCompraForm) form;
		
		return mapping.findForward("escolherPoltrona");
	}
	
	public ActionForward selecionarPoltrona(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterCompraForm frm = (ManterCompraForm) form;
		
		frm.setPoltrona(request.getParameter("seqPoltrona"));
		
		
		return mapping.findForward("condicoesCompra");
	}
	
	public ActionForward carrinhoDeCompra(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterCompraForm frm = (ManterCompraForm) form;
		
		return mapping.findForward("carrinhoDeCompra");
	}
	
	public ActionForward dadosCartao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterCompraForm frm = (ManterCompraForm) form;
		
		return mapping.findForward("dadosCartao");
	}

	public ActionForward compraConcluida(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		ManterCompraForm frm = (ManterCompraForm) form;
		
		return mapping.findForward("compraConcluida");
	}

}
