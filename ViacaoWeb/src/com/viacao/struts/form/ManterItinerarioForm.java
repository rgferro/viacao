/**
 * 
 */
package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

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
	private Integer seqRodoviaria;
	private Integer cboTarifa;
	private Integer cboTarifaDestino;
	private String task;
	private String tempoViagem;
	private boolean isconfirme;
	
	public void inicializar(){
		this.itinerarioVo = new ItinerarioVo();
		this.listaItinerario = new ArrayList<ItinerarioVo>();
		this.listaTarifas = new ArrayList<TarifaVO>();
		this.listaTarifasEscolhidas = new ArrayList<TarifaVO>();
		this.listaRodoviaria = new ArrayList<RodoviariaVO>();
		this.listaRodoviariaDestino = new ArrayList<RodoviariaVO>();
		this.seqRodoviaria = new Integer(0);
		this.cboTarifa = new Integer(0);
		this.cboTarifaDestino = new Integer(0);
		this.isconfirme = false;
		this.getItinerarioVo().setRodoviariaOrigemVO(new RodoviariaVO());
		this.getItinerarioVo().setRodoviariaDestinoVO(new RodoviariaVO());
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

	/**
	 * Obtém o atributo tempoViagem
	 * @return Valor do atributo tempoViagem
	 */
	public String getTempoViagem() {
		return tempoViagem;
	}

	/**
	 * Altera o atributo tempoViagem
	 * @param tempoViagem Novo valor do atributo
	 */
	public void setTempoViagem(String tempoViagem) {
		this.tempoViagem = tempoViagem;
	}

	/**
	 * Obtém o atributo seqRodoviaria
	 * @return Valor do atributo seqRodoviaria
	 */
	public Integer getSeqRodoviaria() {
		return seqRodoviaria;
	}

	/**
	 * Altera o atributo seqRodoviaria
	 * @param seqRodoviaria Novo valor do atributo
	 */
	public void setSeqRodoviaria(Integer seqRodoviaria) {
		this.seqRodoviaria = seqRodoviaria;
	}	
}
