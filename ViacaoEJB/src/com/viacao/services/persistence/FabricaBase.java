package com.viacao.services.persistence;

import org.apache.log4j.Logger;

import com.acol.exception.DAOException;
import com.viacao.services.persistence.bases.BaseEstagio;

/**
 * Fabrica de Base de Dados.
 * 
 * @author Luiz Henrique
 */
public class FabricaBase {
	
	private FabricaBase() {
	}
	
	private static Logger logger = Logger.getLogger(FabricaBase.class);
	
	public static final int ESTAGIO = 1;
	
	public static IBaseDB getBase(int base){
		IBaseDB db = null;
		
		switch (base) {
		case 1:
			try {
				db = new BaseEstagio();
			} catch (DAOException e) {
				logger.fatal("Erro ao criar base: FabricaBase.getBase(int)", e);
			}
			break;
		default:
			break;
		}		
		return db;
	}
}