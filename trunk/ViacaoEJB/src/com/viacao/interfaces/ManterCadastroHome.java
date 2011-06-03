package com.viacao.interfaces;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface ManterCadastroHome extends EJBHome {
	public static final String COMP_NAME = "java:comp/env/ejb/ManterCadastro";
	public static final String JNDI_NAME = "ManterCadastro";
	
	public ManterCadastro create() throws RemoteException, CreateException;

}
