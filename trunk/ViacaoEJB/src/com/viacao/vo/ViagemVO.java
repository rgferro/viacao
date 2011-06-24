package com.viacao.vo;

import com.viacao.vo.DataVO;

public class ViagemVO {

	private Integer  seqViagem; 
	private ItinerarioVo itinerarioVo;
	private OnibusVO onibusVO;
	private DataVO horaSaida;
	private DataVO horaChegada;
	
	/**
	 * Obtém o atributo seqViagem
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
	
	
	public ItinerarioVo getItinerarioVo() {
		return itinerarioVo;
	}
	public void setItinerarioVo(ItinerarioVo itinerarioVo) {
		this.itinerarioVo = itinerarioVo;
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
	public void setHoraSaida(DataVO Saida) {
		this.horaSaida = horaSaida;
	}
	public DataVO getHoraChegada() {
		return horaChegada;
	}
	public void setHoraChegada(DataVO Chegada) {
		this.horaChegada =horaChegada;
	}
}
