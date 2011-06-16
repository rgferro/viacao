/**
 * 
 */
package com.viacao.struts.action;

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
		form.setListaTarifas(EstagioServices.getManterCadastroBean().getListaTarifa(new TarifaVO()));
		form.setListaRodoviaria(EstagioServices.getManterCadastroBean().getListaRodoviaria(new RodoviariaVO()));
		form.setListaRodoviariaDestino(EstagioServices.getManterCadastroBean().getListaRodoviaria(new RodoviariaVO()));
		
		return mapping.findForward("cadastrar");
		
		//return forwardListar(mapping, form, request, response);
		
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
		
		try{
			
			form.setListaTarifas(EstagioServices.getManterCadastroBean().getListaTarifa(new TarifaVO()));
			
			CollectionsUtil.sort(form.getListaTarifas(), "nomTarifa");
			
			EstagioServices.getManterCadastroBean().inserirItinerario(form.getItinerarioVo());
			messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.incluir"));
			
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		saveMessages(request, messages);
		
		return unspecified(mapping, frm, request, response);
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
	public ActionForward alterarItinerario(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ManterItinerarioForm form = (ManterItinerarioForm) frm;
		ActionMessages messages = new ActionMessages();
		
		try{
			EstagioServices.getManterCadastroBean().alterarItinerario(form.getItinerarioVo());
			form.setItinerarioVo(new ItinerarioVo());
			messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.alterar"));
			
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		
		saveMessages(request, messages);
		
		return unspecified(mapping, frm, request, response);
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
	public ActionForward excluirItinerario(ActionMapping mapping, ActionForm frm, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		ManterItinerarioForm form = (ManterItinerarioForm)frm;
		ActionMessages messages = new ActionMessages();
		
		try{
			EstagioServices.getManterCadastroBean().deletarItinerario(form.getItinerarioVo());
			form.setItinerarioVo(new ItinerarioVo());			
			messages.add(Constantes.MESSAGE_SUCESSO, new ActionMessage("sucesso.deletar"));
			
		}catch (Exception e) {
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.acesso"));
		}
		
		saveMessages(request, messages);
		
		return unspecified(mapping, form, request, response);
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
		return mapping.findForward("cadastrar");
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
		return mapping.findForward("cadastrar");
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
