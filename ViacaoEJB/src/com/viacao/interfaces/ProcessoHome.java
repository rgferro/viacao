package com.viacao.interfaces;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 * Home do FluxoProcessoBean
 * 
 * @author Luiz Henrique
 */
public interface ProcessoHome extends EJBHome {
	public static final String COMP_NAME = "java:comp/env/ejb/Processo";
	public static final String JNDI_NAME = "Processo";
	
	public Processo create() throws RemoteException, CreateException;
	
}
