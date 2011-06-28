package com.viacao.ejb;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.apache.log4j.Logger;

import com.acol.exception.DAOException;
import com.acol.exception.business.ChildRecordFoundException;
import com.acol.exception.business.UniqueConstraintViolatedException;
import com.viacao.dao.ClienteDAO;
import com.viacao.dao.EnderecoDAO;
import com.viacao.dao.ItinerarioDAO;
import com.viacao.dao.OnibusDAO;
import com.viacao.dao.RodoviariaDAO;
import com.viacao.dao.TarifaDAO;
import com.viacao.dao.ViagemDAO;
import com.viacao.vo.ClienteVO;
import com.viacao.vo.EnderecoVO;
import com.viacao.vo.FisicaVO;
import com.viacao.vo.ItinerarioVo;
import com.viacao.vo.JuridicaVO;
import com.viacao.vo.OnibusVO;
import com.viacao.vo.RodoviariaVO;
import com.viacao.vo.TarifaVO;
import com.viacao.vo.ViagemVO;

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
	
	/**
	 * Insere uma nova tarifa
	 * @param TarifaVO
	 * @throws DAOException
	 */
	public void inserir (TarifaVO tarifaVO) throws UniqueConstraintViolatedException{ 
		try {
			TarifaDAO dao = new TarifaDAO(); 
			dao.inserir(tarifaVO);
		} catch (DAOException e) {
			e.checkUniqueConstraintViolated();
			logger.fatal("Erro ocorrido no metodo inserir :: ManterCadastroBean", e);
			throw new EJBException(e);
		}
	}	
	
	/**
	 * Deleta uma tarifa
	 * @param TarifaVO
	 * @throws DAOException
	 */
	public void deletar(TarifaVO tarifaVO) throws ChildRecordFoundException{ 
		try {
			TarifaDAO dao = new TarifaDAO(); 
			dao.deletar(tarifaVO);
		} catch (DAOException e) {
			e.checkChildRecordFound();
			logger.fatal("Erro ocorrido no metodo deletar :: ManterCadastroBean", e);
			throw new EJBException(e);
		} 
	}	
	
	/**
	 * Altera uma tarifa
	 * @param TarifaVO
	 * @throws DAOException
	 */
	public void alterar(TarifaVO tarifaVO) throws UniqueConstraintViolatedException{ 
		try {
			TarifaDAO dao = new TarifaDAO();
			dao.alterar(tarifaVO);
		} catch (DAOException e) {
			e.checkUniqueConstraintViolated();
			logger.fatal("Erro ocorrido no metodo alterar :: ManterCadastroBean", e);
			throw new EJBException(e);
		}
	}
	
	/**
	 * Recupera todas as tarifas
	 * @return
	 * @throws DAOException
	 */
	public List<TarifaVO> getListaTarifa(TarifaVO tarifaVO){ 
		try {
			TarifaDAO dao = new TarifaDAO(); 
			return dao.getListaTarifa(tarifaVO);
		} catch (DAOException e) {
			logger.fatal("Erro ocorrido no metodo getListaTarifa :: ManterCadastroBean", e);
			throw new EJBException(e);
		}
	}	
	
	/**
	 * Recupera todas as tarifas
	 * @return
	 * @throws DAOException
	 */
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
		}catch (Exception e) {
			logger.fatal("Erro ao buscar a lista de itinerarios", e);
			throw new EJBException(e);
		}
	}
//--------------------------------------Rodoviaria----------------------------------------------------------------------
	
	public void inserir(RodoviariaVO rodoviariaVO){
		try{
			insert(rodoviariaVO.getEnderecoVO());
			rodoviariaVO.setEnderecoVO(getEndereco(rodoviariaVO.getEnderecoVO()));
			RodoviariaDAO dao = new RodoviariaDAO();
		    dao.inserir(rodoviariaVO);
		}catch(DAOException e){
			logger.fatal("Erro ao inserir Rodoviaria :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
		
	}

	public void alterar(RodoviariaVO rodoviariaVO){
		try {
			alterarEndereco(rodoviariaVO.getEnderecoVO());
			rodoviariaVO.setEnderecoVO(getEndereco(rodoviariaVO.getEnderecoVO()));
			RodoviariaDAO dao = new RodoviariaDAO();
			dao.alterar(rodoviariaVO);
		} catch (Exception e) {
			logger.fatal("Erro ao alterar Rodoviaria :: ManterCadastroBean", e);
			throw new EJBException(e);
		}
	}
	public RodoviariaVO getRodoviaria(RodoviariaVO rodoviariaVO){
		try {
			RodoviariaDAO dao = new RodoviariaDAO();
			return dao.getRodoviaria(rodoviariaVO);
		} catch (Exception e) {
			logger.fatal("Erro em getRodoviaria :: ManterCadastroBean ",e);
			throw new EJBException(e);
		}
	}
	public List<RodoviariaVO> getListaRodoviaria(RodoviariaVO rodoviariaVO){
		try {
			RodoviariaDAO dao = new RodoviariaDAO();
			return dao.getListaRodoviaria(rodoviariaVO);
		} catch (Exception e) {
			logger.fatal("Erro em getListaRodoviaria :: ManterCadastroBean ", e);
			throw new EJBException(e);
		}
	}
	public List<RodoviariaVO> listaInicioRodoviaria(RodoviariaVO rodoviariaVO){
		try {
			RodoviariaDAO dao = new RodoviariaDAO();
			return dao.listaInicioRodoviaria(rodoviariaVO);
		} catch (Exception e) {
			logger.fatal("Erro em listaInicioRodoviaria :: ManterCadastroBean");
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
	public void alterarEndereco(EnderecoVO enderecoVO){
		try {
			EnderecoDAO dao = new EnderecoDAO();
			dao.alterarEndereco(enderecoVO);
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
	public void deletarEndereco(EnderecoVO enderecoVO){
		try {
			EnderecoDAO dao= new EnderecoDAO();
			dao.deletarEndereco(enderecoVO);
		} catch (Exception e) {
			logger.fatal("Erro em deletarEndereco :: MnaterCAdastro", e);
			throw new EJBException(e);
		}
	}


//---------------------------------VIAGEM-----------------------------------------
	/**
	 * Insere uma nova viagem no banco.
	 * @param ViagemVO.
	 * @throws DAOException.
	 */
	public void inserir(ViagemVO viagemVO){
		try {
			ViagemDAO dao = new ViagemDAO();
			dao.inserir(viagemVO);
		} catch (Exception e) {
			logger.fatal("Erro em inserir Viagem :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
	}
	
	/**
	 * Deleta uma viagem do banco.
	 * @param ViagemVO.
	 * @throws DAOException.
	 */
	public void deletar(ViagemVO viagemVO){
		try {
			ViagemDAO dao = new ViagemDAO();
			dao.deletar(viagemVO);
		} catch (Exception e) {
			logger.fatal("Erro ao deletar Viagem :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
	}
	
	/**
	 * Altera as informa��o de uma viagem no banco.
	 * @param ViagemVO.
	 * @throws DAOException.
	 */
	public void alterar(ViagemVO viagemVO){
		try {
			ViagemDAO dao = new ViagemDAO();
			dao.alterar(viagemVO);
		} catch (Exception e) {
			logger.fatal("Erro ao deletar Viagem :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
	}
	
	/**
	 * Recupera uma viagem do banco.
	 * @param ViagemVO.
	 * @throws DAOException.
	 * *@return ViagemVO.
	 */
	public ViagemVO getViagem (ViagemVO viagemVO){
		try {
			ViagemDAO dao = new ViagemDAO();
			return dao.getViagem(viagemVO);
		} catch (Exception e) {
			logger.fatal("Erro em getViagem :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
	}
	
	/**
	 * Recupera uma lista de viagens cadastradas no banco.
	 * @param ViagemVO.
	 * @throws DAOException.
	 * @return List.
	 */
	public List< ViagemVO > getListaViagem (ViagemVO viagemVO){
		try {
			ViagemDAO dao = new ViagemDAO();
			return dao.getListaViagem(viagemVO);
		} catch (Exception e) {
			logger.fatal("Erro em getListaViagem :: ManterCadastroBean ", e);
			throw new EJBException(e);
		}
	}

//--------------------------------CLIENTE-----------------------------------------
	
	public void inserirCliente(ClienteVO clienteVO){
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.inserirCliente(clienteVO);
		} catch (Exception e) {
			logger.fatal("Erro em inserirCliente :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
	}

	public void inserirFisica(FisicaVO fisicaVO){
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.inserirFisica(fisicaVO);
		} catch (Exception e) {
			logger.fatal("Erro em inserirFisica :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
	}
	
	public void deletarCliente(ClienteVO clienteVO){
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.deletarCliente(clienteVO);
		} catch (Exception e) {
			logger.fatal("Erro em deletarCliente :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
	}
	
	public void alterarCliente(ClienteVO clienteVO){
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.alterarCliente(clienteVO);
		} catch (Exception e) {
			logger.fatal("Erro em alterarCliente :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
	}

	public void alterarFisica(FisicaVO fisicaVO){
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.alterarFisica(fisicaVO);
		} catch (Exception e) {
			logger.fatal("Erro em alterarFisica :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
	}
	
	public FisicaVO getClienteFisica (FisicaVO fisicaVO){
		try {
			ClienteDAO dao = new ClienteDAO();
			return dao.getClienteFisica(fisicaVO);
		} catch (Exception e) {
			logger.fatal("Erro em getClienteFisica :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
	}
	
	public List< FisicaVO > getListaClienteFisica (FisicaVO fisicaVO){
		try {
			ClienteDAO dao = new ClienteDAO();
			return dao.getListaClienteFisica(fisicaVO);
		} catch (Exception e) {
			logger.fatal("Erro em getListaClienteFisica :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
	}
	
	public void inserirJuridica(JuridicaVO juridicaVO){
		try {
			EnderecoDAO enderDao = new EnderecoDAO();
			ClienteDAO dao = new ClienteDAO();
			enderDao.insert(juridicaVO.getClienteVO().getEnderecoVO());
			dao.inserirCliente(juridicaVO.getClienteVO());
			dao.inserirJuridica(juridicaVO);
		} catch (Exception e) {
			logger.fatal("Erro em inserirJuridica :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
	}
	
	public void alterarJuridica(JuridicaVO juridicaVO){
		try {
			EnderecoDAO enderDao = new EnderecoDAO();
			ClienteDAO dao = new ClienteDAO();
			enderDao.alterarEndereco(juridicaVO.getClienteVO().getEnderecoVO());
			dao.alterarCliente(juridicaVO.getClienteVO());
			dao.alterarJuridica(juridicaVO);
		} catch (Exception e) {
			logger.fatal("Erro em alterarJuridica :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
	}
	
	public JuridicaVO getClienteJuridica (JuridicaVO juridicaVO){
		try {
			ClienteDAO dao = new ClienteDAO();
			return dao.getClienteJuridica(juridicaVO);
		} catch (Exception e) {
			logger.fatal("Erro em getClienteJuridica :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
	}
	
	public List<JuridicaVO> getListaClienteJuridica (JuridicaVO juridicaVO){
		try {
			ClienteDAO dao = new ClienteDAO();
			return dao.getListaClienteJuridica(juridicaVO);
		} catch (Exception e) {
			logger.fatal("Erro em getListaClienteJuridica :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
	}
	/**
	 * Seleciona um clienteVO, e recupera o seu enderecoVO.
	 * @return ClienteVO e o seu EnderecoVO
	 */
	public ClienteVO getCliente (ClienteVO clienteVO){
		try{
			ClienteDAO dao = new ClienteDAO();
			ClienteVO clienteVO2 = dao.getCliente(clienteVO);
			if (clienteVO2.isEmpty() == false){
				EnderecoDAO dao2 = new EnderecoDAO();
				clienteVO2.setEnderecoVO(dao2.getEndereco(clienteVO2.getEnderecoVO()));
			}
			return clienteVO2;
		}catch (Exception e) {
			logger.fatal("Erro em getCliente :: ManterCadastroBean",e);
			throw new EJBException(e);
		}
	}
}
