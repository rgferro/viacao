package com.viacao.ejb;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.apache.log4j.Logger;

public class ViagemBean implements SessionBean {
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ViagemBean.class);
	
	// Container callbacks
	public void setSessionContext(SessionContext ctx) {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void ejbCreate() {}
	
	// Métodos de negócio
	

}
