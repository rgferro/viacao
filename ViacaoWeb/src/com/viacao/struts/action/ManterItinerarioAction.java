/**
 * 
 */
package com.viacao.struts.action;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.acol.util.CollectionsUtil;
import com.viacao.services.util.EstagioServices;
import com.viacao.struts.form.ManterItinerarioForm;
import com.viacao.utils.Constantes;
import com.viacao.vo.ItinerarioVo;
import com.viacao.vo.RodoviariaVO;
import com.viacao.vo.TarifaVO;

/**
 * @author Wallace Gonçalves
 * Classe responsável pelo CRUD de Itinerario.
 *
 */
public class ManterItinerarioAction extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ManterItinerarioForm form = (ManterItinerarioForm) frm;
		form.inicializar();
		
		return buscar(mapping, frm, request, response);	
	}
	
	public ActionForward linkCadastrar(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ManterItinerarioForm form = (ManterItinerarioForm) frm;
		form.inicializar();
		form.setListaTarifas(EstagioServices.getManterCadastroBean().getListaTarifa(new TarifaVO()));
		form.setListaRodoviariaDestino(EstagioServices.getManterCadastroBean().listaInicioRodoviaria(new RodoviariaVO()));
		form.setListaRodoviariaOrigem(EstagioServices.getManterCadastroBean().listaInicioRodoviaria(new RodoviariaVO()));
		
		return mapping.findForward("cadastrar");		
	}
	
	public ActionForward buscar(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ManterItinerarioForm form = (ManterItinerarioForm) frm;
		form.setListaItinerario(EstagioServices.getManterCadastroBean().getListaItinerario(form.getItinerarioVo()));
		
		return mapping.findForward("listar");		
	}
	
	public ActionForward limparOrigem(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ManterItinerarioForm form = (ManterItinerarioForm) frm;
		form.setListaRodoviariaOrigem(EstagioServices.getManterCadastroBean().listaInicioRodoviaria(new RodoviariaVO()));
		form.getListaRodoviariaOrigem().remove(CollectionsUtil.find(form.getListaRodoviariaOrigem(), "seqRodoviaria", form.getSeqRodoviariaDestino()));
		
		if(form.getPagina().equals("cadastrar")){
			return mapping.findForward("cadastrar");
		}else{
			return mapping.findForward("alterar");
		}		
	}
	
	public ActionForward limparDestino(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ManterItinerarioForm form = (ManterItinerarioForm) frm;
		form.setListaRodoviariaDestino(EstagioServices.getManterCadastroBean().listaInicioRodoviaria(new RodoviariaVO()));
		form.getListaRodoviariaDestino().remove(CollectionsUtil.find(form.getListaRodoviariaDestino(), "seqRodoviaria", form.getSeqRodoviariaOrigem()));
		
		if(form.getPagina().equals("cadastrar")){
			return mapping.findForward("cadastrar");
		}else{
			return mapping.findForward("alterar");
		}	
	}
	
	private ItinerarioVo getItinerarioVo(ManterItinerarioForm form)throws Exception{
		form.getItinerarioVo().setSeqItinerario(form.getSeqItinerario());
		return EstagioServices.getManterCadastroBean().getItinerario(form.getItinerarioVo());		
	}
	
	
	/**
	 * Método responsável por cadastrar um itinerario.
	 * @param mapping - ActionMapping
	 * @param form - ActionForm
	 * @param request - HttpServletRequest
	 * @param response - HttpServletResponse
	 * @return mapping.findForward
	 * @throws Exception
	 */
	public ActionForward cadastrarItinerario(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ManterItinerarioForm form = (ManterItinerarioForm) frm;
		ActionMessages messages = new ActionMessages();
		messages = form.validate(request);
		if(messages.isEmpty()){
			try{
				form.getItinerarioVo().setListaTarifas(form.getListaTarifasEscolhidas());
				EstagioServices.getManterCadastroBean().inserirItinerario(form.getItinerarioVo());
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.incluir"));
			}catch (Exception e) {
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
			}
			saveMessages(request, messages);
			return unspecified(mapping, frm, request, response);
		}
		saveMessages(request, messages);
		return mapping.findForward("cadastrar");
	}
	
	/**
	 * Método que altera um itinerario.
	 * @param mapping - ActionMapping
	 * @param form - ActionForm
	 * @param request - HttpServletRequest
	 * @param response - HttpServletResponse
	 * @return mapping.findForward
	 * @throws Exception
	 */
	public ActionForward alterar(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ManterItinerarioForm form = (ManterItinerarioForm) frm;
		ActionMessages messages = new ActionMessages();
		try{
			form.setItinerarioVo(getItinerarioVo(form));
			form.setListaTarifas(EstagioServices.getManterCadastroBean().getListaTarifa(new TarifaVO()));
			Iterator<TarifaVO> it = form.getItinerarioVo().getListaTarifas().iterator();
			while(it.hasNext()){
				TarifaVO tarifaVO = it.next();
				CollectionsUtil.removeObjectsFromList(form.getListaTarifas(), tarifaVO.getSeqTarifa(), "seqTarifa");
			}
			form.setListaRodoviariaDestino(EstagioServices.getManterCadastroBean().listaInicioRodoviaria(new RodoviariaVO()));
			form.setListaRodoviariaOrigem(EstagioServices.getManterCadastroBean().listaInicioRodoviaria(new RodoviariaVO()));
			form.setListaTarifasEscolhidas(form.getItinerarioVo().getListaTarifas());
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
			saveMessages(request, messages);
			return unspecified(mapping, frm, request, response);
		}
		return mapping.findForward("alterar");
	}
	public ActionForward confirmAlterar(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ActionMessages messages = new ActionMessages();
		ManterItinerarioForm form = (ManterItinerarioForm) frm;
		messages = form.validate(request);
		if(messages.isEmpty()){
			try{
				EstagioServices.getManterCadastroBean().alterarItinerario(form.getItinerarioVo());
				messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.alterar"));
				saveMessages(request, messages);
				return unspecified(mapping, frm, request, response);
			}catch (Exception e) {
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
				saveMessages(request, messages);
				return unspecified(mapping, frm, request, response);
			}
		}
		saveMessages(request, messages);
		return mapping.findForward("alterar");
	}
	
	public ActionForward consultar(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ManterItinerarioForm form = (ManterItinerarioForm) frm;
		form.setItinerarioVo(getItinerarioVo(form));
		
		return mapping.findForward("consultar");
	}
	
	/**
	 * Método que exclui um itinerario.
	 * @param mapping - ActionMapping
	 * @param form - ActionForm
	 * @param request - HttpServletRequest
	 * @param response - HttpServletResponse
	 * @return mapping.findForward
	 * @throws Exception
	 */
	public ActionForward deletar(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ManterItinerarioForm form = (ManterItinerarioForm)frm;
		form.setItinerarioVo(getItinerarioVo(form));		
		
		return mapping.findForward("deletar");
	}
	public ActionForward confirmDeletar(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		ActionMessages messages = new ActionMessages();
		ManterItinerarioForm form = (ManterItinerarioForm) frm;
		
		try{
			EstagioServices.getManterCadastroBean().deletarItinerario(form.getItinerarioVo());
			messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.deletar"));
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		return unspecified(mapping, frm, request, response);
	}
	
	public ActionForward forwardListar(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("listar");
	}
	
	/**
	 * Adiciona o objeto TarifaVO na lista de destino.
	 * @param mapping - ActionMapping
	 * @param frm - ActionForm
	 * @param request - HttpServletRequest
	 * @param response - HttpServletResponse
	 * @return apping.findForward
	 * @throws Exception
	 */
	public ActionForward adicionarLista(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ManterItinerarioForm form = (ManterItinerarioForm)frm;
		ActionMessages messages = new ActionMessages();
		
		TarifaVO tarifaVO = new TarifaVO();
		
		if(form.getCboTarifa()==0){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.selecionado"));
			form.setIsconfirme(false);			
		}else {
			tarifaVO =(TarifaVO)CollectionsUtil.find(form.getListaTarifas(), "seqTarifa", form.getCboTarifa());
			
			if(tarifaVO == null){
				form.setIsconfirme(false);	
			}else {
				form.setIsconfirme(true);	
			}
		}
		if(form.isIsconfirme()){
			form.getListaTarifasEscolhidas().add(tarifaVO);
			form.getListaTarifas().remove(tarifaVO);
			form.setCboTarifa(0);
		}
		saveMessages(request, messages);		
		if(form.getPagina().equals("cadastrar")){
			return mapping.findForward("cadastrar");
		}else{
			return mapping.findForward("alterar");
		}
	}
	
	/**
	 * Remove o objeto TarifaVO da lista de destino e atualiza a lista de origem.
	 * @param mapping - ActionMapping
	 * @param frm - ActionForm
	 * @param request - HttpServletRequest
	 * @param response - HttpServletResponse
	 * @return apping.findForward
	 * @throws Exception
	 */
	public ActionForward removerLista(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ManterItinerarioForm form = (ManterItinerarioForm)frm;
		ActionMessages messages = new ActionMessages();
		TarifaVO tarifaVO = new TarifaVO();
		
		if(form.getCboTarifaDestino()==0){			
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.selecionado"));
			form.setIsconfirme(false);
		}else {
			tarifaVO = (TarifaVO) CollectionsUtil.find(form.getListaTarifasEscolhidas(), "seqTarifa", form.getCboTarifaDestino());
			
			if(tarifaVO == null){
				form.setIsconfirme(false);
			}else {
				form.setIsconfirme(true);
			}
		}
		if(form.isIsconfirme()){					
			form.getListaTarifas().add(tarifaVO);		
			form.getListaTarifasEscolhidas().remove(tarifaVO);
			form.setCboTarifaDestino(0);
		}
		saveMessages(request, messages);		
		if(form.getPagina().equals("cadastrar")){
			return mapping.findForward("cadastrar");
		}else{
			return mapping.findForward("alterar");
		}
		
	}
	
	/**
	 * Remove os objetos TarifaVO da lista de destino.
	 * @param mapping - ActionMapping
	 * @param frm - ActionForm
	 * @param request - HttpServletRequest
	 * @param response - HttpServletResponse
	 * @return apping.findForward
	 * @throws Exception
	 */
	public ActionForward limparCamposDaTabela(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		return unspecified(mapping, frm, request, response);
	}
}
