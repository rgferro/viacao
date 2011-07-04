package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.viacao.utils.Constantes;
import com.viacao.vo.ClienteVO;
import com.viacao.vo.EnderecoVO;
import com.viacao.vo.FisicaVO;
import com.viacao.vo.JuridicaVO;

public class ManterJuridicaForm extends ActionForm {

	private Integer seqJuridica;
	private JuridicaVO juridicaVO;
	private List<JuridicaVO> listaClienteJuridico;
	private String task;
	private String tipUsuario;
	private String acao;

	public void inicializar(){
		juridicaVO = new JuridicaVO();
		juridicaVO.setClienteVO(new ClienteVO());
		juridicaVO.getClienteVO().setEnderecoVO(new EnderecoVO());
		listaClienteJuridico = new ArrayList<JuridicaVO>();
		task = "";
		tipUsuario = "";
		acao = "";
	}
	
	public ActionMessages validate(HttpServletRequest request){
		ActionMessages messages = new ActionMessages();
		
		if(juridicaVO.getClienteVO().getLogin().equals("") || juridicaVO.getClienteVO().getLogin() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Login"));
		}
		
		if(juridicaVO.getClienteVO().getSenha().equals("") || juridicaVO.getClienteVO().getSenha() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Senha"));
		}
		
		if(juridicaVO.getClienteVO().getEmail().equals("") || juridicaVO.getClienteVO().getEmail() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "E-mail"));
		}
		
		if(this.tipUsuario.equals("") || this.tipUsuario == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.radio", "Usuário"));
		}
		
		if(tipUsuario.equals("USUARIO")){
			if(juridicaVO.getNomResponsavel().equals("") || juridicaVO.getNomResponsavel() == null){
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Nome Responsável"));
			}
	
			if(juridicaVO.getNomFantasia().equals("") || juridicaVO.getNomFantasia() == null){
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Nome Fantasia"));
			}
	
			if(juridicaVO.getRazaoSocial().equals("") || juridicaVO.getRazaoSocial() == null){
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Razão Social"));
			}
			
			if(juridicaVO.getCnpj().equals("") || juridicaVO.getCnpj() == null){
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "CNPJ"));
			}
			
			if(juridicaVO.getNumInscricao().equals("") || juridicaVO.getNumInscricao() == null){
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Inscrição estadual"));
			}
		}
		
		if(juridicaVO.getClienteVO().getEnderecoVO().getLogradouro().equals("")
				|| juridicaVO.getClienteVO().getEnderecoVO().getLogradouro() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Logradouro"));
		}
		
		if(juridicaVO.getClienteVO().getEnderecoVO().getNumero().equals("")
				|| juridicaVO.getClienteVO().getEnderecoVO().getNumero() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Número"));
		}
		
		if(juridicaVO.getClienteVO().getEnderecoVO().getBairro().equals("")
				|| juridicaVO.getClienteVO().getEnderecoVO().getBairro() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Bairro"));
		}
		
		if(juridicaVO.getClienteVO().getEnderecoVO().getCidade().equals("")
				|| juridicaVO.getClienteVO().getEnderecoVO().getCidade() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Cidade"));
		}
		
		if(juridicaVO.getClienteVO().getEnderecoVO().getEstado().equals("")
				|| juridicaVO.getClienteVO().getEnderecoVO().getEstado() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Estado"));
		}
		
		return messages;
	}
	
	public JuridicaVO getJuridicaVO() {
		return juridicaVO;
	}

	public void setJuridicaVO(JuridicaVO juridicaVO) {
		this.juridicaVO = juridicaVO;
	}

	public List<JuridicaVO> getListaClienteJuridico() {
		return listaClienteJuridico;
	}
	
	public void setListaClienteJuridico(List<JuridicaVO> listaClienteJuridico) {
		this.listaClienteJuridico = listaClienteJuridico;
	}

	public Integer getSeqJuridica() {
		return seqJuridica;
	}

	public void setSeqJuridica(Integer seqJuridica) {
		this.seqJuridica = seqJuridica;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getTipUsuario() {
		return tipUsuario;
	}

	public void setTipUsuario(String tipUsuario) {
		this.tipUsuario = tipUsuario;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
	
}
