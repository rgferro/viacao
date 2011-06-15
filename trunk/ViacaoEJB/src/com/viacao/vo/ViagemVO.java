package com.viacao.vo;

import com.acol.vo.DataVO;

public class ViagemVO {

	private String Viagem;
	private Integer  seqViagem; 
	private ItinerarioVo itinerarioVO;
	private OnibusVO onibusVO;
	private DataVO horaSaida;
	private DataVO horaChegada;
	
	
	public String getViagem() {
		return Viagem;
	}
	public void setViagem(String viagem) {
		Viagem = viagem;
	}
	
	/**
	 * Obt�m o atributo seqViagem
	 * @return Valor do atributo seqViagem
	 */
	public Integer getSeqViagem() {
		return seqViagem;
	}
	
	/**
	 * Altera o atributo seqViagem
	 * @param seqViagem Novo valor do atributo
	 */
	public void setSeqViagem(Integer seqViagem) {
		this.seqViagem = seqViagem;
	}
	
	
	public ItinerarioVo getItinerarioVO() {
		return itinerarioVO;
	}
	public void setItinerarioVO(ItinerarioVo itinerarioVO) {
		this.itinerarioVO = itinerarioVO;
	}
	public OnibusVO getOnibusVO() {
		return onibusVO;
	}
	public void setOnibusVO(OnibusVO onibusVO) {
		this.onibusVO = onibusVO;
	}
	public DataVO getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(DataVO horaSaida) {
		this.horaSaida = horaSaida;
	}
	public DataVO getHoraChegada() {
		return horaChegada;
	}
	public void setHoraChegada(DataVO horaChegada) {
		this.horaChegada = horaChegada;
	}
}
