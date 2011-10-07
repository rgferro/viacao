/**
 * 
 */
package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.acol.util.DoubleUtils;
import com.acol.util.IntegerUtils;
import com.viacao.utils.Constantes;
import com.viacao.vo.EnderecoVO;
import com.viacao.vo.ItinerarioVo;
import com.viacao.vo.RodoviariaVO;
import com.viacao.vo.TarifaVO;

/**
 * @author Wallace Gonçalves
 *
 */
public class ManterItinerarioForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	
	private ItinerarioVo itinerarioVo;
	private List<TarifaVO> listaTarifas;
	private List<TarifaVO> listaTarifasEscolhidas;
	private List<ItinerarioVo> listaItinerario;
	private List<RodoviariaVO> listaRodoviaria;
	private List<RodoviariaVO> listaRodoviariaDestino;
	private List<RodoviariaVO> listaRodoviariaOrigem;
	private Integer seqRodoviariaOrigem;
	private Integer seqRodoviariaDestino;
	private Integer seqItinerario;
	private Integer cboTarifa;
	private Integer cboTarifaDestino;
	private String task;
	private String pagina;
	private boolean isconfirme;
	
	public void inicializar(){
		this.itinerarioVo = new ItinerarioVo();
		this.listaItinerario = new ArrayList<ItinerarioVo>();
		this.listaTarifas = new ArrayList<TarifaVO>();
		this.listaTarifasEscolhidas = new ArrayList<TarifaVO>();
		this.listaRodoviaria = new ArrayList<RodoviariaVO>();
		this.listaRodoviariaDestino = new ArrayList<RodoviariaVO>();
		this.cboTarifa = new Integer(0);
		this.cboTarifaDestino = new Integer(0);
		this.seqRodoviariaOrigem = new Integer(0);
		this.seqRodoviariaDestino = new Integer(0);
		this.isconfirme = false;
		this.getItinerarioVo().setRodoviariaOrigemVO(new RodoviariaVO());
		this.getItinerarioVo().setRodoviariaDestinoVO(new RodoviariaVO());
		this.getItinerarioVo().getRodoviariaOrigemVO().setEnderecoVO(new EnderecoVO());
		this.getItinerarioVo().getRodoviariaDestinoVO().setEnderecoVO(new EnderecoVO());
		this.getItinerarioVo().setListaTarifas(new ArrayList<TarifaVO>());
		
	}
	
	public ActionMessages validate(HttpServletRequest request) {
		ActionMessages messages = new ActionMessages();
		
		if(this.itinerarioVo.getRodoviariaOrigemVO().getSeqRodoviaria() == -1){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Origem"));
		}
		if(this.itinerarioVo.getRodoviariaDestinoVO().getSeqRodoviaria() == -1){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Destino"));
		}
		if(this.itinerarioVo.getTempoViagem().equals("")){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Tempo"));
		}
		if(DoubleUtils.empty(this.itinerarioVo.getValorPassagem())){
			messages.add(Constantes.MESSAGE_ERRO, new ActionMessage("error.vazio", "Valor"));
		}
		
		return messages;
	}

	/**
	 * Obtém o atributo itinerarioVo
	 * @return Valor do atributo itinerarioVo
	 */
	public ItinerarioVo getItinerarioVo() {
		return itinerarioVo;
	}

	/**
	 * Altera o atributo itinerarioVo
	 * @param itinerarioVo Novo valor do atributo
	 */
	public void setItinerarioVo(ItinerarioVo itinerarioVo) {
		this.itinerarioVo = itinerarioVo;
	}
	
	/**
	 * Obtém o atributo listaTarifas
	 * @return Valor do atributo listaTarifas
	 */
	public List<TarifaVO> getListaTarifas() {
		return listaTarifas;
	}

	/**
	 * Altera o atributo listaTarifas
	 * @param listaTarifas Novo valor do atributo
	 */
	public void setListaTarifas(List<TarifaVO> listaTarifas) {
		this.listaTarifas = listaTarifas;
	}

	/**
	 * Obtém o atributo listaTarifasEscolhidas
	 * @return Valor do atributo listaTarifasEscolhidas
	 */
	public List<TarifaVO> getListaTarifasEscolhidas() {
		return listaTarifasEscolhidas;
	}

	/**
	 * Altera o atributo listaTarifasEscolhidas
	 * @param listaTarifasEscolhidas Novo valor do atributo
	 */
	public void setListaTarifasEscolhidas(List<TarifaVO> listaTarifasEscolhidas) {
		this.listaTarifasEscolhidas = listaTarifasEscolhidas;
	}

	/**
	 * Obtém o atributo task
	 * @return Valor do atributo task
	 */
	public String getTask() {
		return task;
	}

	/**
	 * Altera o atributo task
	 * @param task Novo valor do atributo
	 */
	public void setTask(String task) {
		this.task = task;
	}

	/**
	 * Obtém o atributo listaItinerario
	 * @return Valor do atributo listaItinerario
	 */
	public List<ItinerarioVo> getListaItinerario() {
		return listaItinerario;
	}

	/**
	 * Altera o atributo listaItinerario
	 * @param listaItinerario Novo valor do atributo
	 */
	public void setListaItinerario(List<ItinerarioVo> listaItinerario) {
		this.listaItinerario = listaItinerario;
	}

	/**
	 * Obtém o atributo isconfirme
	 * @return Valor do atributo isconfirme
	 */
	public boolean isIsconfirme() {
		return isconfirme;
	}

	/**
	 * Altera o atributo isconfirme
	 * @param isconfirme Novo valor do atributo
	 */
	public void setIsconfirme(boolean isconfirme) {
		this.isconfirme = isconfirme;
	}

	/**
	 * Obtém o atributo cboTarifa
	 * @return Valor do atributo cboTarifa
	 */
	public Integer getCboTarifa() {
		return cboTarifa;
	}

	/**
	 * Altera o atributo cboTarifa
	 * @param cboTarifa Novo valor do atributo
	 */
	public void setCboTarifa(Integer cboTarifa) {
		this.cboTarifa = cboTarifa;
	}

	/**
	 * Obtém o atributo cboTarifaDestino
	 * @return Valor do atributo cboTarifaDestino
	 */
	public Integer getCboTarifaDestino() {
		return cboTarifaDestino;
	}

	/**
	 * Altera o atributo cboTarifaDestino
	 * @param cboTarifaDestino Novo valor do atributo
	 */
	public void setCboTarifaDestino(Integer cboTarifaDestino) {
		this.cboTarifaDestino = cboTarifaDestino;
	}

	/**
	 * Obtém o atributo listaRodoviaria
	 * @return Valor do atributo listaRodoviaria
	 */
	public List<RodoviariaVO> getListaRodoviaria() {
		return listaRodoviaria;
	}

	/**
	 * Altera o atributo listaRodoviaria
	 * @param listaRodoviaria Novo valor do atributo
	 */
	public void setListaRodoviaria(List<RodoviariaVO> listaRodoviaria) {
		this.listaRodoviaria = listaRodoviaria;
	}

	/**
	 * Obtém o atributo listaRodoviariaDestino
	 * @return Valor do atributo listaRodoviariaDestino
	 */
	public List<RodoviariaVO> getListaRodoviariaDestino() {
		return listaRodoviariaDestino;
	}

	/**
	 * Altera o atributo listaRodoviariaDestino
	 * @param listaRodoviariaDestino Novo valor do atributo
	 */
	public void setListaRodoviariaDestino(List<RodoviariaVO> listaRodoviariaDestino) {
		this.listaRodoviariaDestino = listaRodoviariaDestino;
	}	

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public List<RodoviariaVO> getListaRodoviariaOrigem() {
		return listaRodoviariaOrigem;
	}

	public void setListaRodoviariaOrigem(List<RodoviariaVO> listaRodoviariaOrigem) {
		this.listaRodoviariaOrigem = listaRodoviariaOrigem;
	}

	public Integer getSeqRodoviariaOrigem() {
		return seqRodoviariaOrigem;
	}

	public void setSeqRodoviariaOrigem(Integer seqRodoviariaOrigem) {
		this.seqRodoviariaOrigem = seqRodoviariaOrigem;
	}

	public Integer getSeqRodoviariaDestino() {
		return seqRodoviariaDestino;
	}

	public void setSeqRodoviariaDestino(Integer seqRodoviariaDestino) {
		this.seqRodoviariaDestino = seqRodoviariaDestino;
	}

	public Integer getSeqItinerario() {
		return seqItinerario;
	}

	public void setSeqItinerario(Integer seqItinerario) {
		this.seqItinerario = seqItinerario;
	}
	
	/**
	 * @return the nomRodoviariaConcatOrigem
	 */
	public String getNomRodoviariaConcatOrigem() {
		System.out.println(this.itinerarioVo.getRodoviariaOrigemVO().getNomRodoviaria());
		System.out.println(this.itinerarioVo.getRodoviariaOrigemVO().getEnderecoVO().getCidade());
		return this.itinerarioVo.getRodoviariaOrigemVO().getNomRodoviaria() + " - " + this.itinerarioVo.getRodoviariaOrigemVO().getEnderecoVO().getCidade();
	}

	/**
	 * @return the nomRodoviariaConcatDestino
	 */
	public String getNomRodoviariaConcatDestino() {
		return this.itinerarioVo.getRodoviariaDestinoVO().getNomRodoviaria() + " - " + this.itinerarioVo.getRodoviariaDestinoVO().getEnderecoVO().getCidade();
	}

}
