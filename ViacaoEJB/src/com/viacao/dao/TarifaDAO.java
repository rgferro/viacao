package com.viacao.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import sun.jdbc.rowset.CachedRowSet;

import com.acol.exception.DAOException;
import com.acol.util.DoubleUtils;
import com.acol.util.StringUtil;
import com.viacao.services.persistence.BaseDB;
import com.viacao.vo.TarifaVO;

public class TarifaDAO extends BaseDB{
	private Logger logger = Logger.getLogger(this.getClass());
	
	public TarifaDAO() throws DAOException {
		super();
	}

	/**
	 * Insere uma nova tarifa
	 * @param TarifaVO
	 * @throws DAOException
	 */
	public void inserir (TarifaVO tarifaVO) throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append("INSERT INTO tarifa (seq_tarifa, nom_tarifa, valor_tarifa) VALUES (seq_tarifa.nextval,upper (?), ?)");
		
		try {
			pstmt = getPstmt(sql.toString());
			pstmt.setString(1, tarifaVO.getNomTarifa());
			pstmt.setDouble(2, tarifaVO.getValor().doubleValue());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo inserir em :: TarifaDAO", e);
			throw new DAOException(e);
		} finally {
			release();
		}
	}
	
	/**
	 * Deleta uma tarifa
	 * @param TarifaVO
	 * @throws DAOException
	 */
	public void deletar(TarifaVO tarifaVO) throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append("DELETE 	tarifa WHERE seq_tarifa = ?");
		
		try {
			pstmt = getPstmt(sql.toString());
			pstmt.setInt(1, tarifaVO.getSeqTarifa().intValue());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo deletar em :: TarifaDAO", e);
			throw new DAOException(e);
		} finally {
			release();
		}
	}
	
	/**
	 * SQL
	 * @return
	 */
	private String getSQLAlterar() 
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append(" UPDATE 	tarifa ");
		sql.append("SET 		nom_tarifa = upper(?), ");
		sql.append("		valor_tarifa = ? ");
		sql.append(" WHERE 	seq_tarifa = ? ");
		
		return sql.toString();
	}
	
	/**
	 * Altera uma tarifa
	 * @param TarifaVO
	 * @throws DAOException
	 */
	public void alterar(TarifaVO tarifaVO) throws DAOException{		
		try {
			pstmt = getPstmt(getSQLAlterar());
			pstmt.setString(1, tarifaVO.getNomTarifa());
			pstmt.setDouble(2, tarifaVO.getValor().doubleValue());
			pstmt.setInt(3, tarifaVO.getSeqTarifa().intValue());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo alterar em :: TarifaDAO", e);
			throw new DAOException(e);
		} finally {
			release();
		}
	}
	
	/**
	 * Recupera todas as tarifas
	 * @return
	 * @throws DAOException
	 */
	public List<TarifaVO> getListaTarifa(TarifaVO tarifaVO) throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT seq_tarifa, nom_tarifa, valor_tarifa ");
		sql.append(" FROM 	tarifa ");
		if(tarifaVO != null){
			sql.append(" WHERE 1=1");
			if(!StringUtil.empty(tarifaVO.getNomTarifa())){
				sql.append(" AND nom_tarifa like upper('%"+tarifaVO.getNomTarifa()+"%')");
			}
			if(!DoubleUtils.empty(tarifaVO.getValor())){
				sql.append(" AND valor_tarifa = "+tarifaVO.getValor().doubleValue());
			}
		}
		sql.append(" ORDER BY 2");
		
		try {
			pstmt = getPstmt(sql.toString());
			rowSet = executeQuery(pstmt);

			List<TarifaVO> listaTarifas = new ArrayList<TarifaVO>();
			while (next()) {		
				TarifaVO tarifasVO = new TarifaVO();
				tarifasVO.setSeqTarifa(new Integer(rowSet.getString("seq_tarifa")));
				tarifasVO.setNomTarifa(rowSet.getString("nom_tarifa"));
				tarifasVO.setValor(new Double(rowSet.getString("valor_tarifa")));
				
				listaTarifas.add(tarifasVO);
			}
			
			return listaTarifas;			
		} catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo getListaTarifa em :: TarifaDAO", e);
			throw new DAOException(e);
		} finally {
			release();
		}
	}
	
	/**
	 * Recupera todas as tarifas
	 * @return
	 * @throws DAOException
	 */
	public TarifaVO getTarifa(TarifaVO tarifaVO) throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT 	seq_tarifa, nom_tarifa, valor_tarifa FROM tarifa WHERE 	seq_tarifa =  ?");
		
		try {
			pstmt = getPstmt(sql.toString());
			pstmt.setInt(1, tarifaVO.getSeqTarifa().intValue());
			rowSet = executeQuery(pstmt);	
			TarifaVO tarifasVO = new TarifaVO();
			if (next()) {		
				tarifasVO.setSeqTarifa(new Integer(rowSet.getString("seq_tarifa")));
				tarifasVO.setNomTarifa(rowSet.getString("nom_tarifa"));
				tarifasVO.setValor(new Double(rowSet.getString("valor_tarifa")));
			}
			
			return tarifasVO;
		} catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo getTarifa em :: TarifaDAO", e);
			throw new DAOException(e);
		} finally {
			release();
		}
	}
}
