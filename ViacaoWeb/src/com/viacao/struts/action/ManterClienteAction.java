package com.viacao.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.viacao.services.util.EstagioServices;
import com.viacao.struts.form.ManterClienteForm;
import com.viacao.vo.FisicaVO;

public class ManterClienteAction extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ManterClienteForm frm = (ManterClienteForm)form;
		
		FisicaVO fisicaVO = new FisicaVO();
		
		frm.setListaClienteFisico(EstagioServices.getManterCadastroBean().getListaClienteFisica(fisicaVO));
		
		return null;
	}
	
	
}
