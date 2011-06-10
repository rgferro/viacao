package com.viacao.interfaces;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.EJBObject;

import com.acol.exception.DAOException;
import com.viacao.dao.OnibusDAO;
import com.viacao.vo.OnibusVO;

public interface ManterCadastro extends EJBObject {

	/**
	 * Insere um novo �nibus no banco.
	 * @param OnibusVO.
	 * @throws RemoteException.
	 */
	public void insertExemplo (OnibusVO onibusVO) throws RemoteException;
	
	/**
	 * Deleta um �nibus do banco.
	 * @param OnibusVO.
	 * @throws RemoteException.
	 */
	public void deletar(OnibusVO onibusVO) throws RemoteException;
	
	/**
	 * Altera as informa��o de um �nibus no banco.
	 * @param OnibusVO.
	 * @throws RemoteException.
	 */
	public void alterar(OnibusVO onibusVO) throws RemoteException;
	
	/**
	 * Recupera um objeto �nibus do banco.
	 * @param OnibusVO.
	 * @throws RemoteException.
	 */
	public OnibusVO getOnibus(OnibusVO onibusVO) throws RemoteException;
	
	/**
	 * Recupera uma lista de �nibus cadastrados no banco.
	 * @param OnibusVO.
	 * @throws RemoteException.
	 */
	public List getListaOnibus(OnibusVO onibusVO) throws RemoteException;
}
