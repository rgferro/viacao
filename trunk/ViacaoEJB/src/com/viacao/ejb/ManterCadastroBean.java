package com.viacao.ejb;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.apache.log4j.Logger;

import com.acol.exception.DAOException;
import com.viacao.dao.ItinerarioDAO;
import com.viacao.dao.OnibusDAO;
import com.viacao.vo.ItinerarioVo;
import com.viacao.dao.TarifaDAO;
import com.viacao.vo.OnibusVO;
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
	
// Métodos de negócio
	
	
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
	 * Insere um novo ônibus no banco.
	 * @param OnibusVO.
	 * @throws DAOException.
	 */
	public void inserir(OnibusVO onibusVO){
		try{
			OnibusDAO odao = new OnibusDAO();
			odao.inserir(onibusVO);
		}catch(DAOException e){
			logger.fatal("Erro ao inserir ônibus", e);
			throw new EJBException(e);
		}
	}
	
	/**
	 * Deleta um ônibus do banco.
	 * @param OnibusVO.
	 * @throws DAOException.
	 */
	public void deletar(OnibusVO onibusVO){
		try{
			OnibusDAO odao = new OnibusDAO();
			odao.deletar(onibusVO);
		}catch(DAOException e){
			logger.fatal("Erro ao deletar ônibus", e);
			throw new EJBException(e);
		}
	}
	
	/**
	 * Altera as informação de um ônibus no banco.
	 * @param OnibusVO.
	 * @throws DAOException.
	 */
	public void alterar(OnibusVO onibusVO){
		try{
			OnibusDAO odao = new OnibusDAO();
			odao.alterar(onibusVO);
		}catch(DAOException e){
			logger.fatal("Erro ao deletar ônibus", e);
			throw new EJBException(e);
		}
	}
	
	/**
	 * Recupera um objeto ônibus do banco.
	 * @param OnibusVO.
	 * @throws DAOException.
	 * *@return OnibusVO.
	 */
	public OnibusVO getOnibus(OnibusVO onibusVO){
		try{
			OnibusDAO odao = new OnibusDAO();
			return odao.getOnibus(onibusVO);
		}catch(DAOException e){
			logger.fatal("Erro ao deletar ônibus", e);
			throw new EJBException(e);
		}
	}
	
	/**
	 * Recupera uma lista de ônibus cadastrados no banco.
	 * @param OnibusVO.
	 * @throws DAOException.
	 * @return List.
	 */
	public List<OnibusVO> getListaOnibus(OnibusVO onibusVO){
		try{
			OnibusDAO odao = new OnibusDAO();
			return odao.getListaOnibus(onibusVO);
		}catch(DAOException e){
			logger.fatal("Erro ao deletar ônibus", e);
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
}
