package com.viacao.interfaces;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface ClienteHome extends EJBHome {
	public static final String COMP_NAME = "java:comp/env/ejb/Cliente";
	public static final String JNDI_NAME = "Cliente";
	
	public Cliente create() throws RemoteException, CreateException;

}
