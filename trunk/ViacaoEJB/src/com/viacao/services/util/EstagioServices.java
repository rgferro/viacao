package com.viacao.services.util;

import org.apache.log4j.Logger;

import com.acol.exception.SystemException;
import com.acol.services.EJBHomeFactory;
import com.viacao.interfaces.Cliente;
import com.viacao.interfaces.ClienteHome;
import com.viacao.interfaces.ManterCadastro;
import com.viacao.interfaces.ManterCadastroHome;
import com.viacao.interfaces.Passagem;
import com.viacao.interfaces.PassagemHome;
import com.viacao.interfaces.Processo;
import com.viacao.interfaces.ProcessoHome;
import com.viacao.interfaces.Viagem;
import com.viacao.interfaces.ViagemHome;

public class EstagioServices {
	private static Logger logger = Logger.getLogger(EstagioServices.class);
	
	private EstagioServices() {}
	
	public static Processo getProcessoBean() throws SystemException {
		try {
			ProcessoHome home = (ProcessoHome) EJBHomeFactory.getInstance().lookUpHome(ProcessoHome.class, ProcessoHome.COMP_NAME);
			return home.create();
		} catch (Exception e) {
			logger.fatal("Erro em EstagioServices.getProcessoBean()", e);
			throw new SystemException (e);
		}
	}
	public static ManterCadastro getManterCadastroBean() throws SystemException {
		try {
			ManterCadastroHome home = (ManterCadastroHome) EJBHomeFactory.getInstance().lookUpHome(ManterCadastroHome.class, ManterCadastroHome.COMP_NAME);
			return home.create();
		} catch (Exception e) {
			logger.fatal("Erro em EstagioServices.getManterCadastroBean()", e);
			throw new SystemException (e);
		}
	}
	public static Cliente getClienteBean() throws SystemException {
		try {
			ClienteHome home = (ClienteHome) EJBHomeFactory.getInstance().lookUpHome(ClienteHome.class, ClienteHome.COMP_NAME);
			return home.create();
		} catch (Exception e) {
			logger.fatal("Erro em EstagioServices.getManterCadastroBean()", e);
			throw new SystemException (e);
		}
	}
	public static Passagem getPassagemBean() throws SystemException {
		try {
			PassagemHome home = (PassagemHome) EJBHomeFactory.getInstance().lookUpHome(PassagemHome.class, PassagemHome.COMP_NAME);
			return home.create();
		} catch (Exception e) {
			logger.fatal("Erro em EstagioServices.getManterCadastroBean()", e);
			throw new SystemException (e);
		}
	}
	public static Viagem getViagemBean() throws SystemException {
		try {
			ViagemHome home = (ViagemHome) EJBHomeFactory.getInstance().lookUpHome(ViagemHome.class, ViagemHome.COMP_NAME);
			return home.create();
		} catch (Exception e) {
			logger.fatal("Erro em EstagioServices.getManterCadastroBean()", e);
			throw new SystemException (e);
		}
	}
}
