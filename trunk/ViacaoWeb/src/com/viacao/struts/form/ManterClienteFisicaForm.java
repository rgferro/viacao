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

public class ManterClienteFisicaForm extends ActionForm{
	
	private FisicaVO fisicaVO;
	private List<FisicaVO> listaClienteFisico;
	private Integer seqFisica;
	private Integer seqEndereco;
	private Integer seqCliente;
	private String tipUsuario;
	private String task;
	private String acao;

	public void inicializar(){
		this.fisicaVO = new FisicaVO();
		this.fisicaVO.setClienteVO(new ClienteVO());
		this.fisicaVO.getClienteVO().setEnderecoVO(new EnderecoVO());
		this.listaClienteFisico = new ArrayList<FisicaVO>();
		this.seqFisica = null;
		this.seqEndereco = null;
		this.tipUsuario = "";
		this.task = "";
		this.acao = "";
	}
	
	public ActionMessages validate(HttpServletRequest request) {
		ActionMessages messages = new ActionMessages();
		
		if(fisicaVO.getClienteVO().getLogin() == null || fisicaVO.getClienteVO().getLogin().equals("")){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Login"));
		}
		if(fisicaVO.getClienteVO().getSenha() == null || fisicaVO.getClienteVO().getSenha().equals("")){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Senha"));
		}
		if(tipUsuario.equals("USUARIO")){
			if(fisicaVO.getNomPessoa() == null || fisicaVO.getNomPessoa().equals("")){
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "NomPessoa"));
			}
			if(fisicaVO.getClienteVO().getEmail() == null || fisicaVO.getClienteVO().getEmail().equals("")){
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Email"));
			}
			if(fisicaVO.getCpfPessoa() == null || fisicaVO.getCpfPessoa().equals("")){
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "CPF"));
			}
			if(fisicaVO.getRgPessoa() == null || fisicaVO.getRgPessoa().equals("")){
				messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "RG"));
			}
		}
		if(fisicaVO.getClienteVO().getEnderecoVO().getLogradouro() == null || fisicaVO.getClienteVO().getEnderecoVO().getLogradouro().equals("")){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Logradouro"));
		}
		if(fisicaVO.getClienteVO().getEnderecoVO().getNumero() == null || fisicaVO.getClienteVO().getEnderecoVO().getNumero().equals("")){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Numero"));
		}
		if(fisicaVO.getClienteVO().getEnderecoVO().getBairro() == null || fisicaVO.getClienteVO().getEnderecoVO().getBairro().equals("")){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Bairro"));
		}
		if(fisicaVO.getClienteVO().getEnderecoVO().getCidade() == null || fisicaVO.getClienteVO().getEnderecoVO().getCidade().equals("")){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Cidade"));
		}
		if(fisicaVO.getClienteVO().getEnderecoVO().getEstado() == null || fisicaVO.getClienteVO().getEnderecoVO().getEstado().equals("")){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Estado"));
		}
		return messages;
	}
	

	public FisicaVO getFisicaVO() {
		return fisicaVO;
	}

	public void setFisicaVO(FisicaVO fisicaVO) {
		this.fisicaVO = fisicaVO;
	}

	public List<FisicaVO> getListaClienteFisico() {
		return listaClienteFisico;
	}

	public void setListaClienteFisico(List<FisicaVO> listaClienteFisico) {
		this.listaClienteFisico = listaClienteFisico;
	}

	public Integer getSeqFisica() {
		return seqFisica;
	}

	public void setSeqFisica(Integer seqFisica) {
		this.seqFisica = seqFisica;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Integer getSeqEndereco() {
		return seqEndereco;
	}

	public void setSeqEndereco(Integer seqEndereco) {
		this.seqEndereco = seqEndereco;
	}

	public Integer getSeqCliente() {
		return seqCliente;
	}

	public void setSeqCliente(Integer seqCliente) {
		this.seqCliente = seqCliente;
	}

	public String getTipUsuario() {
		return tipUsuario;
	}

	public void setTipUsuario(String tipUsuario) {
		this.tipUsuario = tipUsuario;
	}
		
}
