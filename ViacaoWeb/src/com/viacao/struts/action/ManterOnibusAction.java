package com.viacao.struts.action;

import java.util.List;

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
		frm.getOnibusVO().setSeqOnibus(new Integer(request.getParameter("seqOnibus")));
		List listaOnibus = EstagioServices.getManterCadastroBean().getListaOnibus(frm.getOnibusVO());
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
	
	public ActionForward paginaAlterarOnibus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		OnibusVO onibusVO = new OnibusVO();
		
		frm.getOnibusVO().setEmpresa(onibusVO.getEmpresa());
		frm.getOnibusVO().setPlaca(onibusVO.getPlaca());
		frm.getOnibusVO().setQtdPoltrona(onibusVO.getQtdPoltrona());
		frm.getOnibusVO().setTipo(onibusVO.getTipo());
		
		return mapping.findForward("alterar");
	}
	
	public ActionForward alterarOnibus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		OnibusVO onibusVO = new OnibusVO();
		
		onibusVO.setEmpresa(frm.getOnibusVO().getEmpresa());
		onibusVO.setPlaca(frm.getOnibusVO().getPlaca());
		onibusVO.setQtdPoltrona(frm.getOnibusVO().getQtdPoltrona());
		onibusVO.setTipo(frm.getOnibusVO().getTipo());
		
		EstagioServices.getManterCadastroBean().alterar(onibusVO);
		return mapping.findForward("inserir");
	}
	
	public ActionForward deletarOnibus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterOnibusForm frm = (ManterOnibusForm) form;
		OnibusVO onibusVO = new OnibusVO();
		
		onibusVO.setEmpresa(frm.getOnibusVO().getEmpresa());
		onibusVO.setPlaca(frm.getOnibusVO().getPlaca());
		onibusVO.setQtdPoltrona(frm.getOnibusVO().getQtdPoltrona());
		onibusVO.setTipo(frm.getOnibusVO().getTipo());
		
		EstagioServices.getManterCadastroBean().deletar(onibusVO);
		return mapping.findForward("inserir");
	}

}
