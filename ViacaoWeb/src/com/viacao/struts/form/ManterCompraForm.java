package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.acol.util.IntegerUtils;
import com.acol.util.StringUtil;
import com.sun.xml.internal.ws.util.StringUtils;
import com.viacao.utils.Constantes;
import com.viacao.vo.DataVO;
import com.viacao.vo.ItinerarioVo;
import com.viacao.vo.OnibusVO;
import com.viacao.vo.RodoviariaVO;
import com.viacao.vo.ViagemVO;

public class ManterCompraForm extends ActionForm{
	
	private OnibusVO onibusVO;
	private ViagemVO viagemVO;
	private List<RodoviariaVO> listaRodoviariaOrigem;
	private List<RodoviariaVO> listaRodoviariaDestino;
	private List<ViagemVO> listaViagensIda;
	private List<ViagemVO> listaViagensVolta;
	private String task;
	private String poltrona;
	private DataVO horaSaidaIda;
	private DataVO horaSaidaVolta;
	private Integer seqRodoviariaDestino;
	private Integer seqRodoviariaOrigem;
	private String tipViagem;
	private String pagina;
	
	public void inicializar(){
		this.task = "";
		this.poltrona = "";
		this.listaRodoviariaOrigem = new ArrayList<RodoviariaVO>();
		this.listaRodoviariaDestino = new ArrayList<RodoviariaVO>();
		this.seqRodoviariaOrigem = null;
		this.seqRodoviariaDestino = null;
		this.viagemVO = new ViagemVO();
		this.viagemVO.setItinerarioVo(new ItinerarioVo());
		this.viagemVO.setOnibusVO(new OnibusVO());
		this.viagemVO.getItinerarioVo().setRodoviariaOrigemVO(new RodoviariaVO());
		this.viagemVO.getItinerarioVo().setRodoviariaDestinoVO(new RodoviariaVO());
		this.tipViagem = "idaVolta";
		this.horaSaidaIda = new DataVO();
		this.horaSaidaVolta = new DataVO();
	}
	
	public ActionMessages validate(HttpServletRequest request) {
		ActionMessages messages = new ActionMessages();
		
		if(IntegerUtils.empty(this.seqRodoviariaOrigem)){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Origem"));
		}
		if(IntegerUtils.empty(this.seqRodoviariaDestino)){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Destino"));
		}
		if(this.horaSaidaIda == null || this.horaSaidaIda.equals("")){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Data Ida"));
		}
		
		return messages;
	}

	/**
	 * @return the onibusVO
	 */
	public OnibusVO getOnibusVO() {
		return onibusVO;
	}

	/**
	 * @param onibusVO the onibusVO to set
	 */
	public void setOnibusVO(OnibusVO onibusVO) {
		this.onibusVO = onibusVO;
	}

	/**
	 * @return the viagemVO
	 */
	public ViagemVO getViagemVO() {
		return viagemVO;
	}

	/**
	 * @param viagemVO the viagemVO to set
	 */
	public void setViagemVO(ViagemVO viagemVO) {
		this.viagemVO = viagemVO;
	}

	/**
	 * @return the listaRodoviariaOrigem
	 */
	public List getListaRodoviariaOrigem() {
		return listaRodoviariaOrigem;
	}

	/**
	 * @param listaRodoviariaOrigem the listaRodoviariaOrigem to set
	 */
	public void setListaRodoviariaOrigem(List listaRodoviariaOrigem) {
		this.listaRodoviariaOrigem = listaRodoviariaOrigem;
	}

	/**
	 * @return the listaRodoviariaDestino
	 */
	public List getListaRodoviariaDestino() {
		return listaRodoviariaDestino;
	}

	/**
	 * @param listaRodoviariaDestino the listaRodoviariaDestino to set
	 */
	public void setListaRodoviariaDestino(List listaRodoviariaDestino) {
		this.listaRodoviariaDestino = listaRodoviariaDestino;
	}

	/**
	 * @return the task
	 */
	public String getTask() {
		return task;
	}

	/**
	 * @param task the task to set
	 */
	public void setTask(String task) {
		this.task = task;
	}

	/**
	 * @return the poltrona
	 */
	public String getPoltrona() {
		return poltrona;
	}

	/**
	 * @param poltrona the poltrona to set
	 */
	public void setPoltrona(String poltrona) {
		this.poltrona = poltrona;
	}

	/**
	 * @return the horaSaidaIda
	 */
	public DataVO getHoraSaidaIda() {
		return horaSaidaIda;
	}

	/**
	 * @param horaSaidaIda the horaSaidaIda to set
	 */
	public void setHoraSaidaIda(DataVO horaSaidaIda) {
		this.horaSaidaIda = horaSaidaIda;
	}

	/**
	 * @return the horaSaidaVolta
	 */
	public DataVO getHoraSaidaVolta() {
		return horaSaidaVolta;
	}

	/**
	 * @param horaSaidaVolta the horaSaidaVolta to set
	 */
	public void setHoraSaidaVolta(DataVO horaSaidaVolta) {
		this.horaSaidaVolta = horaSaidaVolta;
	}

	/**
	 * @return the seqRodoviariaDestino
	 */
	public Integer getSeqRodoviariaDestino() {
		return seqRodoviariaDestino;
	}

	/**
	 * @param seqRodoviariaDestino the seqRodoviariaDestino to set
	 */
	public void setSeqRodoviariaDestino(Integer seqRodoviariaDestino) {
		this.seqRodoviariaDestino = seqRodoviariaDestino;
	}

	/**
	 * @return the seqRodoviariaOrigem
	 */
	public Integer getSeqRodoviariaOrigem() {
		return seqRodoviariaOrigem;
	}

	/**
	 * @param seqRodoviariaOrigem the seqRodoviariaOrigem to set
	 */
	public void setSeqRodoviariaOrigem(Integer seqRodoviariaOrigem) {
		this.seqRodoviariaOrigem = seqRodoviariaOrigem;
	}

	/**
	 * @return the pagina
	 */
	public String getPagina() {
		return pagina;
	}

	/**
	 * @param pagina the pagina to set
	 */
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	/**
	 * @return the tipViagem
	 */
	public String getTipViagem() {
		return tipViagem;
	}

	/**
	 * @param tipViagem the tipViagem to set
	 */
	public void setTipViagem(String tipViagem) {
		this.tipViagem = tipViagem;
	}

	/**
	 * @return the listaViagensIda
	 */
	public List<ViagemVO> getListaViagensIda() {
		return listaViagensIda;
	}

	/**
	 * @param listaViagensIda the listaViagensIda to set
	 */
	public void setListaViagensIda(List<ViagemVO> listaViagensIda) {
		this.listaViagensIda = listaViagensIda;
	}

	/**
	 * @return the listaViagensVolta
	 */
	public List<ViagemVO> getListaViagensVolta() {
		return listaViagensVolta;
	}

	/**
	 * @param listaViagensVolta the listaViagensVolta to set
	 */
	public void setListaViagensVolta(List<ViagemVO> listaViagensVolta) {
		this.listaViagensVolta = listaViagensVolta;
	}

}
