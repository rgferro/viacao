package com.viacao.interfaces;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBObject;

import com.viacao.vo.ExemploVO;


/**
 * Interface de negócios do ProcessoBean
 * 
 * @author Luiz Henrique
 */
public interface Processo extends EJBObject {
	
	public void insertExemplo (ExemploVO exemploVO) throws RemoteException;
	
	public void deleteExemplo(ExemploVO exemploVO) throws RemoteException;
	
	public void updateExemplo(ExemploVO exemploVO) throws RemoteException;
	
	public List readExemplo() throws RemoteException;
	
	public ExemploVO getExemplo(String seqExemplo) throws RemoteException;
}
	

