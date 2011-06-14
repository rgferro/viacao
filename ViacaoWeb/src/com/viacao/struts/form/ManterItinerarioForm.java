/**
 * 
 */
package com.viacao.struts.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.viacao.vo.ItinerarioVo;

/**
 * @author Wallace Gonçalves
 *
 */
public class ManterItinerarioForm extends ActionForm{
	
	private static final long serialVersionUID = 1L;
	
	private ItinerarioVo itinerarioVo;
	private List<ItinerarioVo> lista;
	
	public void inicializar(){
		this.itinerarioVo = new ItinerarioVo();
		this.lista = new ArrayList<ItinerarioVo>();
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
	 * Obtém o atributo lista
	 * @return Valor do atributo lista
	 */
	public List<ItinerarioVo> getLista() {
		return lista;
	}

	/**
	 * Altera o atributo lista
	 * @param lista Novo valor do atributo
	 */
	public void setLista(List<ItinerarioVo> lista) {
		this.lista = lista;
	}
}
