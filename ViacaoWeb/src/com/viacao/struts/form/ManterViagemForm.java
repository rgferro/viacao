package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.viacao.utils.Constantes;
import com.viacao.vo.DataVO;
import com.viacao.vo.ItinerarioVo;
import com.viacao.vo.OnibusVO;
import com.viacao.vo.RodoviariaVO;
import com.viacao.vo.ViagemVO;


public class ManterViagemForm extends ActionForm {
	
	private ViagemVO viagemVO;
	private List<ViagemVO> listaViagem;
	private List<ItinerarioVo> listaItinerario;
	private List<OnibusVO> listaOnibus;
	private Integer seqViagem;
	private String acao;
	private String task;
	
	
	public void inicializar(){
		this.viagemVO = new ViagemVO();
		this.viagemVO.setItinerarioVo(new ItinerarioVo());
		this.viagemVO.getItinerarioVo().setRodoviariaDestinoVO(new RodoviariaVO());
		this.viagemVO.getItinerarioVo().setRodoviariaOrigemVO(new RodoviariaVO());
		this.viagemVO.setOnibusVO(new OnibusVO());
		this.viagemVO.setHoraSaida(new DataVO());
		this.viagemVO.setHoraChegada(new DataVO());		
		this.listaViagem = new ArrayList<ViagemVO>();
		this.listaItinerario = new ArrayList<ItinerarioVo>();
		this.listaOnibus = new ArrayList<OnibusVO>();
		this.seqViagem = null;
		this.task = "";
	}
	
	public ActionMessages validate(HttpServletRequest request){
		ActionMessages messages = new ActionMessages();
		
		if(viagemVO.getItinerarioVo().equals("") || viagemVO.getItinerarioVo() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio.itinerario"));
		}
		
		if(viagemVO.getOnibusVO().equals("") || viagemVO.getOnibusVO() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio.onibus"));
		}		
		
		if(viagemVO.getHoraSaida().equals("") || viagemVO.getHoraSaida() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio.HoraSaida"));
		}
		
		if(viagemVO.getHoraChegada().equals("") || viagemVO.getHoraChegada() == null){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio.HoraChegada"));
		}
		
		return messages;
	}	
	
	public ViagemVO getViagemVO() {
		return viagemVO;
	}

	public void setViagemVO(ViagemVO viagemVO) {
		this.viagemVO = viagemVO;
	}
	
	public List<ViagemVO> getListaViagem() {
		return listaViagem;
	}

	public void setListaViagem(List<ViagemVO> listaViagem) {
		this.listaViagem = listaViagem;
	}

	public Integer getSeqViagem() {
		return seqViagem;
	}

	public void setSeqViagem(Integer seqViagem) {
		this.seqViagem = seqViagem;
	}
	
	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public List<ItinerarioVo> getListaItinerario() {
		return listaItinerario;
	}

	public void setListaItinerario(List<ItinerarioVo> listaItinerario) {
		this.listaItinerario = listaItinerario;
	}

	public List<OnibusVO> getListaOnibus() {
		return listaOnibus;
	}

	public void setListaOnibus(List<OnibusVO> listaOnibus) {
		this.listaOnibus = listaOnibus;
	}

}

