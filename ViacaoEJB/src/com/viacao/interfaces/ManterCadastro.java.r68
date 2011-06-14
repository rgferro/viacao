package com.viacao.interfaces;

import java.rmi.RemoteException;
import java.util.List;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.EJBObject;

import com.viacao.vo.ExemploVO;
import com.viacao.vo.TarifaVO;

import com.acol.exception.DAOException;
import com.viacao.dao.OnibusDAO;
import com.viacao.vo.OnibusVO;

public interface ManterCadastro extends EJBObject {
	
	public void inserir(TarifaVO tarifaVO) throws RemoteException;
	
	public void deletar(TarifaVO tarifaVO) throws RemoteException;
	
	public void alterar(TarifaVO tarifaVO) throws RemoteException;
	
	public List getListaTarifa(TarifaVO tarifaVO) throws RemoteException;
	
	public TarifaVO getTarifa(TarifaVO tarifaVO) throws RemoteException;
	
	public void inserir(OnibusVO onibusVO) throws RemoteException;
	
	public void deletar(OnibusVO onibusVO) throws RemoteException;
	
	public void alterar(OnibusVO onibusVO) throws RemoteException;
	
	public List getListaOnibus(OnibusVO onibusVO) throws RemoteException;

}
