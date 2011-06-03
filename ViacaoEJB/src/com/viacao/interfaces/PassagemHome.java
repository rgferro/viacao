package com.viacao.interfaces;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface PassagemHome extends EJBHome {
	public static final String COMP_NAME = "java:comp/env/ejb/Passagem";
	public static final String JNDI_NAME = "Passagem";
	
	public Passagem create() throws RemoteException, CreateException;

}
