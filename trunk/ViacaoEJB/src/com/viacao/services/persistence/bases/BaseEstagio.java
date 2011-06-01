package com.viacao.services.persistence.bases;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.acol.exception.BaseException;
import com.acol.exception.DAOException;
import com.acol.services.ServiceLocator;
import com.viacao.services.persistence.BaseDB;

/**
 * @author mayworm
 */
public class BaseEstagio extends BaseDB{
	/**   
	 * Logger for this class
	 */
	private static Logger logger = Logger.getLogger(BaseEstagio.class);

	/**
	 * @throws DAOException Em caso de ocorrência de SQLException
	 */
	public BaseEstagio() throws DAOException {
		super();
	}

	/**
	 * 
	 */
	protected void loadBase() {     	
		try {
			ServiceLocator locator = ServiceLocator.instance();
			cachedDS = (DataSource) locator.getService("java:comp/env/jdbc/EstagioDS");			
		} catch (BaseException e) {
			logger.fatal("BaseDB(boolean) BaseException", e);
		} catch (NullPointerException e) {
			logger.fatal("@@@ NullPointerException: DataSource Nulo @@@", e);
		} catch (RuntimeException e) {
			logger.fatal("@@@ RuntimeException: DataSource Nulo @@@", e);
		}
	}
}
