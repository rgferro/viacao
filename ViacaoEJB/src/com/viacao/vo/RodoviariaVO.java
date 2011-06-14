package com.viacao.vo;

public class RodoviariaVO {

	private Integer seqRodoviaria;
	private String nomRodoviaria;
	private EnderecoVO enderecoVO;
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
	/**
	 * Obtém o atributo nomRodoviaria
	 * @return Valor do atributo nomRodoviaria
	 */
	public String getNomRodoviaria() {
		return nomRodoviaria;
	}
	/**
	 * Altera o atributo nomRodoviaria
	 * @param nomRodoviaria Novo valor do atributo
	 */
	public void setNomRodoviaria(String nomRodoviaria) {
		this.nomRodoviaria = nomRodoviaria;
	}
	/**
	 * Obtém o atributo enderecoVO
	 * @return Valor do atributo enderecoVO
	 */
	public EnderecoVO getEnderecoVO() {
		return enderecoVO;
	}
	/**
	 * Altera o atributo enderecoVO
	 * @param enderecoVO Novo valor do atributo
	 */
	public void setEnderecoVO(EnderecoVO enderecoVO) {
		this.enderecoVO = enderecoVO;
	}	
}
