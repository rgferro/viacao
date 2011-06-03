package com.viacao.interfaces;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface ViagemHome extends EJBHome {
	public static final String COMP_NAME = "java:comp/env/ejb/Viagem";
	public static final String JNDI_NAME = "Viagem";
	
	public Viagem create() throws RemoteException, CreateException;

}
