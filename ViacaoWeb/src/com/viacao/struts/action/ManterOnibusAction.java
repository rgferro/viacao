package com.viacao.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.viacao.services.util.EstagioServices;
import com.viacao.struts.form.ManterOnibusForm;
import com.viacao.vo.OnibusVO;

public class ManterOnibusAction extends DispatchAction {
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		frm.inicializar();
		frm.setListaOnibus(EstagioServices.getManterCadastroBean().getListaOnibus(frm.getOnibusVO()));
		
		return mapping.findForward("listar");
	}
	
	public ActionForward listarOnibus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		
		frm.setListaOnibus(EstagioServices.getManterCadastroBean().getListaOnibus(frm.getOnibusVO()));
		
		return mapping.findForward("listar");
	}
	
	public ActionForward inserirOnibus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		OnibusVO onibusVO = new OnibusVO();
		
		onibusVO.setEmpresa(frm.getOnibusVO().getEmpresa());
		onibusVO.setPlaca(frm.getOnibusVO().getPlaca());
		onibusVO.setQtdPoltrona(frm.getOnibusVO().getQtdPoltrona());
		onibusVO.setTipo(frm.getOnibusVO().getTipo());
		
		EstagioServices.getManterCadastroBean().inserir(onibusVO);
		return mapping.findForward("listar");
	}
	
	public ActionForward recuperarOnibus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		OnibusVO onibusVO = new OnibusVO();
		
		onibusVO.setSeqOnibus(frm.getSeqOnibus());
		frm.setOnibusVO(EstagioServices.getManterCadastroBean().getOnibus(onibusVO));
		
		if(frm.getAcao().equals("deletando")){
			return mapping.findForward("deletar");
		}else{
			return mapping.findForward("alterar");
		}
	}
	
	public ActionForward alterarOnibus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		OnibusVO onibusVO = new OnibusVO();
		
		onibusVO.setEmpresa(frm.getOnibusVO().getEmpresa());
		onibusVO.setPlaca(frm.getOnibusVO().getPlaca());
		onibusVO.setQtdPoltrona(frm.getOnibusVO().getQtdPoltrona());
		onibusVO.setTipo(frm.getOnibusVO().getTipo());
		
		EstagioServices.getManterCadastroBean().alterar(onibusVO);
		return mapping.findForward("listar");
	}
	
	public ActionForward deletarOnibus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		OnibusVO onibusVO = new OnibusVO();
		
		onibusVO.setEmpresa(frm.getOnibusVO().getEmpresa());
		onibusVO.setPlaca(frm.getOnibusVO().getPlaca());
		onibusVO.setQtdPoltrona(frm.getOnibusVO().getQtdPoltrona());
		onibusVO.setTipo(frm.getOnibusVO().getTipo());
		
		EstagioServices.getManterCadastroBean().deletar(onibusVO);
		return mapping.findForward("listar");
	}

}
