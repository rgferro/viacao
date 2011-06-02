package com.viacao.ejb;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.apache.log4j.Logger;

import com.acol.exception.DAOException;
import com.viacao.dao.ExemploDAO;
import com.viacao.vo.ExemploVO;

public class ProcessoBean implements SessionBean {
	
	
	private static final long serialVersionUID = -7410774185541528820L;
	private static Logger logger = Logger.getLogger(ProcessoBean.class);
	
	// Container callbacks
	public void setSessionContext(SessionContext ctx) {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void ejbCreate() {}
	
	// Métodos de negócio
	
	
	public void insertExemplo (ExemploVO exemploVO){ 
		try {
			ExemploDAO dao = new ExemploDAO(); 
			dao.insertExemplo(exemploVO);
		} catch (DAOException e) {
			logger.fatal("Erro ocorrido no metodo insertExemplo :: ProcessoBean", e);
			throw new EJBException(e);
		}
	}	
	
	public void deleteExemplo(ExemploVO exemploVO){ 
		try {
			ExemploDAO dao = new ExemploDAO(); 
			dao.deleteExemplo(exemploVO);
		} catch (DAOException e) {
			logger.fatal("Erro ocorrido no metodo deleteExemplo :: ProcessoBean", e);
			throw new EJBException(e);
		}
	}	
	public void updateExemplo(ExemploVO exemploVO){ 
		try {
			ExemploDAO dao = new ExemploDAO(); 
			dao.updateExemplo(exemploVO);
		} catch (DAOException e) {
			logger.fatal("Erro ocorrido no metodo updateExemplo :: ProcessoBean", e);
			throw new EJBException(e);
		}
	}	
	public List readExemplo(){ 
		try {
			ExemploDAO dao = new ExemploDAO(); 
			return dao.readExemplo();
		} catch (DAOException e) {
			logger.fatal("Erro ocorrido no metodo readExemplo :: ProcessoBean", e);
			throw new EJBException(e);
		}
	}	
	public ExemploVO getExemplo(String seqExemplo){ 
		try {
			ExemploDAO dao = new ExemploDAO(); 
			return dao.getExemplo(seqExemplo);
		} catch (DAOException e) {
			logger.fatal("Erro ocorrido no metodo readExemplo :: ProcessoBean", e);
			throw new EJBException(e);
		}
	}	
	
}
