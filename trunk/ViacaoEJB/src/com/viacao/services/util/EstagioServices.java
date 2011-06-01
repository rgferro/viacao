package com.viacao.services.util;

import org.apache.log4j.Logger;

import com.acol.exception.SystemException;
import com.acol.services.EJBHomeFactory;
import com.viacao.interfaces.Processo;
import com.viacao.interfaces.ProcessoHome;

public class EstagioServices {
	private static Logger logger = Logger.getLogger(EstagioServices.class);
	
	private EstagioServices() {}
	
	public static Processo getProcessoBean() throws SystemException {
		try {
			ProcessoHome home = (ProcessoHome) EJBHomeFactory.getInstance().lookUpHome(ProcessoHome.class, ProcessoHome.COMP_NAME);
			return home.create();
		} catch (Exception e) {
			logger.fatal("Erro em EstagioServices.getFluxoProcessoBean()", e);
			throw new SystemException (e);
		}
	}
}
