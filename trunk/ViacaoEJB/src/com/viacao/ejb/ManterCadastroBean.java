package com.viacao.ejb;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.apache.log4j.Logger;

import com.acol.exception.DAOException;
import com.viacao.dao.EnderecoDAO;
import com.viacao.dao.ItinerarioDAO;
import com.viacao.dao.OnibusDAO;
import com.viacao.dao.RodoviariaDAO;
import com.viacao.vo.ItinerarioVo;
import com.viacao.dao.TarifaDAO;
import com.viacao.vo.EnderecoVO;
import com.viacao.vo.OnibusVO;
import com.viacao.vo.RodoviariaVO;
import com.viacao.vo.TarifaVO;

public class ManterCadastroBean implements SessionBean {
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ManterCadastroBean.class);
	
	// Container callbacks
	public void setSessionContext(SessionContext ctx) {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void ejbCreate() {}
	
// M�todos de neg�cio
	
	
	public void inserir (TarifaVO tarifaVO){ 
		try {
			TarifaDAO dao = new TarifaDAO(); 
			dao.inserir(tarifaVO);
		} catch (DAOException e) {
			logger.fatal("Erro ocorrido no metodo inserir :: ManterCadastroBean", e);
			throw new EJBException(e);
		}
	}	
	
	public void deletar(TarifaVO tarifaVO){ 
		try {
			TarifaDAO dao = new TarifaDAO(); 
			dao.deletar(tarifaVO);
		} catch (DAOException e) {
			logger.fatal("Erro ocorrido no metodo deletar :: ManterCadastroBean", e);
			throw new EJBException(e);
		}
	}	
	public void alterar(TarifaVO tarifaVO){ 
		try {
			TarifaDAO dao = new TarifaDAO();
			dao.alterar(tarifaVO);
		} catch (DAOException e) {
			logger.fatal("Erro ocorrido no metodo alterar :: ManterCadastroBean", e);
			throw new EJBException(e);
		}
	}	
	public List<TarifaVO> getListaTarifa(TarifaVO tarifaVO){ 
		try {
			TarifaDAO dao = new TarifaDAO(); 
			return dao.getListaTarifa(tarifaVO);
		} catch (DAOException e) {
			logger.fatal("Erro ocorrido no metodo getListaTarifa :: ManterCadastroBean", e);
			throw new EJBException(e);
		}
	}	
	public TarifaVO getTarifa(TarifaVO tarifaVO){ 
		try {
			TarifaDAO dao = new TarifaDAO(); 
			return dao.getTarifa(tarifaVO);
		} catch (DAOException e) {
			logger.fatal("Erro ocorrido no metodo getTarifa :: ManterCadastroBean", e);
			throw new EJBException(e);
		}
	}	
	
	/**
	 * Insere um novo �nibus no banco.
	 * @param OnibusVO.
	 * @throws DAOException.
	 */
	public void inserir(OnibusVO onibusVO){
		try{
			OnibusDAO odao = new OnibusDAO();
			odao.inserir(onibusVO);
		}catch(DAOException e){
			logger.fatal("Erro ao inserir �nibus", e);
			throw new EJBException(e);
		}
	}
	
	/**
	 * Deleta um �nibus do banco.
	 * @param OnibusVO.
	 * @throws DAOException.
	 */
	public void deletar(OnibusVO onibusVO){
		try{
			OnibusDAO odao = new OnibusDAO();
			odao.deletar(onibusVO);
		}catch(DAOException e){
			logger.fatal("Erro ao deletar �nibus", e);
			throw new EJBException(e);
		}
	}
	
	/**
	 * Altera as informa��o de um �nibus no banco.
	 * @param OnibusVO.
	 * @throws DAOException.
	 */
	public void alterar(OnibusVO onibusVO){
		try{
			OnibusDAO odao = new OnibusDAO();
			odao.alterar(onibusVO);
		}catch(DAOException e){
			logger.fatal("Erro ao deletar �nibus", e);
			throw new EJBException(e);
		}
	}
	
	/**
	 * Recupera um objeto �nibus do banco.
	 * @param OnibusVO.
	 * @throws DAOException.
	 * *@return OnibusVO.
	 */
	public OnibusVO getOnibus(OnibusVO onibusVO){
		try{
			OnibusDAO odao = new OnibusDAO();
			return odao.getOnibus(onibusVO);
		}catch(DAOException e){
			logger.fatal("Erro ao deletar �nibus", e);
			throw new EJBException(e);
		}
	}
	
	/**
	 * Recupera uma lista de �nibus cadastrados no banco.
	 * @param OnibusVO.
	 * @throws DAOException.
	 * @return List.
	 */
	public List<OnibusVO> getListaOnibus(OnibusVO onibusVO){
		try{
			OnibusDAO odao = new OnibusDAO();
			return odao.getListaOnibus(onibusVO);
		}catch(DAOException e){
			logger.fatal("Erro ao deletar �nibus", e);
			throw new EJBException(e);
		}
	}
	
	/**
	 * Inseri um itinerario no banco.
	 * @param itinerarioVo
	 */
	public void inserirItinerario(ItinerarioVo itinerarioVo){
		try{
			ItinerarioDAO dao = new ItinerarioDAO();
			dao.inserir(itinerarioVo);
		}catch (DAOException e) {
			logger.fatal("Erro ao inserir itinerario", e);
			throw new EJBException(e);
		}
	}
	
	/**
	 * Exclui um itinerario.
	 * @param itinerarioVo
	 */
	public void deletarItinerario(ItinerarioVo itinerarioVo){
		try{
			ItinerarioDAO dao = new ItinerarioDAO();
			dao.excluir(itinerarioVo);
		}catch (DAOException e) {
			logger.fatal("Erro ao deletar itinerario", e);
			throw new EJBException(e);
		}
	}
	/**
	 * Altera um itinerario.
	 * @param itinerarioVo
	 */
	public void alterarItinerario(ItinerarioVo itinerarioVo){
		try{
			ItinerarioDAO dao = new ItinerarioDAO();
			dao.alterar(itinerarioVo);
		}catch (DAOException e) {
			logger.fatal("Erro ao alterar itinerario", e);
			throw new EJBException(e);
		}
	}
	
	/**
	 * Recuperar um itinerario
	 * @param itinerarioVo
	 * @return
	 */
	public ItinerarioVo getItinerario(ItinerarioVo itinerarioVo){
		try{
			ItinerarioDAO dao = new ItinerarioDAO();
			return dao.getItinerario(itinerarioVo);
		}catch (DAOException e) {
			logger.fatal("Erro ao buscar itinerario", e);
			throw new EJBException(e);
		}
	}
	
	public List<ItinerarioVo> listaItinerario(ItinerarioVo itinerarioVo){
		try{
			ItinerarioDAO dao = new ItinerarioDAO();
			return dao.listaItinerario(itinerarioVo);
		}catch (DAOException e) {
			logger.fatal("Erro ao buscar a lista de itinerarios", e);
			throw new EJBException(e);
		}
	}
//--------------------------------------Rodoviaria----------------------------------------------------------------------
	
	public void inserir(RodoviariaVO rodoviariaVO){
		try{
			RodoviariaDAO dao = new RodoviariaDAO();
		    dao.inserir(rodoviariaVO);
		}catch(DAOException e){
			logger.fatal("Erro ao inserir Rodoviaria :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
		
	}
	public void deletar(RodoviariaVO rodoviariaVO){
		try {
			RodoviariaDAO dao = new RodoviariaDAO();
			dao.deletar(rodoviariaVO);
		} catch (Exception e) {
			logger.fatal("Erro ao deletar Rodoviaria :: ManterCadastroBean",e);
			throw new EJBException(e);
		}	
	}
	public void alterar(RodoviariaVO rodoviariaVO){
		try {
			RodoviariaDAO dao = new RodoviariaDAO();
			dao.alterar(rodoviariaVO);
		} catch (Exception e) {
			logger.fatal("Erro ao alterar Rodoviaria :: ManterCadastroBen", e);
			throw new EJBException(e);
		}
	}
	public RodoviariaVO getRodoviaria(RodoviariaVO rodoviariaVO){
		try {
			RodoviariaDAO dao = new RodoviariaDAO();
			return dao.getRodoviaria(rodoviariaVO);
		} catch (Exception e) {
			logger.fatal("Erro em getRodoviaria :: ManterCadastroBen ",e);
			throw new EJBException(e);
		}
	}
	public List<RodoviariaVO> getListaRodoviaria(RodoviariaVO rodoviariaVO){
		try {
			RodoviariaDAO dao = new RodoviariaDAO();
			return dao.getListaRodoviaria(rodoviariaVO);
		} catch (Exception e) {
			logger.fatal("Erro em getListaRodoviaria :: ManterCadastroBen ", e);
			throw new EJBException(e);
		}
	}
//---------------------------------------Endereco----------------------------------------------------------------------	
	public void insert(EnderecoVO enderecoVO){
		try {
			EnderecoDAO dao = new EnderecoDAO();
			dao.insert(enderecoVO);
		} catch (Exception e) {
			logger.fatal("Erro ao inserir Endereco :: ManterCadastro",e);
			throw new EJBException(e);
		}
	}
	public void alterar(EnderecoVO enderecoVO){
		try {
			EnderecoDAO dao = new EnderecoDAO();
			dao.alterar(enderecoVO);
		} catch (Exception e) {
			logger.fatal("Erro ao alterar  Endereco :: ManterCadastro",e);
			throw new EJBException(e);
		}
	}
	public EnderecoVO getEndereco(EnderecoVO enderecoVO){
		try {
			EnderecoDAO dao = new EnderecoDAO();
			return dao.getEndereco(enderecoVO);
		} catch (Exception e) {
			logger.fatal("Erro em getEndereco :: ManterCadastro",e);
			throw new EJBException(e);
		}
	}

}
