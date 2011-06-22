package com.viacao.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.acol.util.StringUtil;
import com.viacao.utils.Constantes;
import com.viacao.vo.ClienteVO;
import com.viacao.vo.FisicaVO;
import com.viacao.vo.JuridicaVO;

public class LoginForm extends ActionForm {
	private FisicaVO fisicaVO;
	private JuridicaVO juridicaVO;
	private ClienteVO clienteVO;
	
	public void inicializar(ActionMapping mapping, HttpServletRequest request) {
		this.fisicaVO = new FisicaVO();
		this.juridicaVO = new JuridicaVO();
		this.clienteVO = new ClienteVO();
	}
	
	public ActionMessages validacao (ActionMapping mapping, HttpServletRequest request){
		ActionMessages messages = new ActionMessages();
		
		if(StringUtil.empty(this.clienteVO.getLogin())){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio","login"));		
		}
		if(StringUtil.empty(this.clienteVO.getSenha())){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio","senha"));
		}
		return messages;
	}
	
	public FisicaVO getFisicaVO() {
		return fisicaVO;
	}
	public void setFisicaVO(FisicaVO fisicaVO) {
		this.fisicaVO = fisicaVO;
	}
	public JuridicaVO getJuridicaVO() {
		return juridicaVO;
	}
	public void setJuridicaVO(JuridicaVO juridicaVO) {
		this.juridicaVO = juridicaVO;
	}
	public ClienteVO getClienteVO() {
		return clienteVO;
	}
	public void setClienteVO(ClienteVO clienteVO) {
		this.clienteVO = clienteVO;
	}

}
