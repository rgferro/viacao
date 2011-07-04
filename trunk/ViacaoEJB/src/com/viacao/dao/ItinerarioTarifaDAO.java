package com.viacao.dao;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.acol.exception.DAOException;
import com.viacao.services.persistence.BaseDB;

public class ItinerarioTarifaDAO extends BaseDB{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	public ItinerarioTarifaDAO()throws DAOException{
		super();
	}


	/**
	 * SQLInserir
	 * @return sql
	 */
	private String getSQLInserirItinerarioTarifa(){
		StringBuffer sql = new StringBuffer();
		
		sql.append(" INSERT INTO itinerario_tarifa ( 		\n");
		sql.append(" seq_itinerario_tarifa,  				\n");
		sql.append(" seq_itinerario_fk, 		\n");
		sql.append(" seq_tarifa_fk)   	\n");
		sql.append(" VALUES (seq_itinerario_tarifa.nextval, ? , ? ) 				\n");
		
		return sql.toString();
	}
	
	/**
	 * Insere um itinerario no banco
	 * @param itinerarioVo
	 * @throws DAOException
	 */
	public void inserirItinerarioTarifa(Integer seqItinerario, Integer seqTarifa)throws DAOException{
		
		try {
			pstmt = getPstmt(getSQLInserirItinerarioTarifa());
			pstmt.setInt(1, seqItinerario);
			pstmt.setInt(2, seqTarifa);
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			logger.fatal("Erro ocorrido no metodo inserirItinerarioTarifa em :: ItinerarioDAO", e);
			throw new DAOException(e);
		} finally {
			release();
		}	
	}
	
	/**
	 * Exlui um itinerario do banco.
	 * @param itinerarioVo
	 * @throws DAOException
	 */
	public void excluirItinerarioTarifa(Integer seqItinerario)throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append("DELETE itinerario_tarifa it WHERE it.seq_itinerario_fk = ?");
		
		try{
			pstmt = getPstmt(sql.toString());
			pstmt.setInt(1, seqItinerario);
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo excluir em :: ItinerarioDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
	}
}
