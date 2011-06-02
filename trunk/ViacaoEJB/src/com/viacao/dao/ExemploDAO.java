package com.viacao.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.acol.exception.DAOException;
import com.viacao.services.persistence.BaseDB;
import com.viacao.vo.ExemploVO;

public class ExemploDAO extends BaseDB{
	private Logger logger = Logger.getLogger(this.getClass());
	
	public ExemploDAO() throws DAOException {
		super();
	}

	/**
	 * Insere um novo exemplo
	 * @param exemploVO
	 * @throws DAOException
	 */
	public void insertExemplo (ExemploVO exemploVO) throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append("INSERT INTO exemplo (seq_exemplo, nome_exemplo, descricao) VALUES (seq_exemplo.nextval, ?, ?)");
		
		try {
			pstmt = getPstmt(sql.toString());
			pstmt.setString(1, exemploVO.getNomeExemplo());
			pstmt.setString(2, exemploVO.getDescricao());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo insertExemplo em :: ExemploDAO", e);
			throw new DAOException(e);
		} finally {
			release();
		}
	}
	
	/**
	 * Deleta um exemplo
	 * @param exemploVO
	 * @throws DAOException
	 */
	public void deleteExemplo(ExemploVO exemploVO) throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append("DELETE exemplo WHERE seq_exemplo = ?");
		
		try {
			pstmt = getPstmt(sql.toString());
			pstmt.setInt(1, exemploVO.getSeqExemplo().intValue());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo deleteExemplo em :: ExemploDAO", e);
			throw new DAOException(e);
		} finally {
			release();
		}
	}
	
	/**
	 * SQL
	 * @return
	 */
	private String getSQLUpdate() 
	{
		StringBuffer sql = new StringBuffer();
		
		sql.append(" UPDATE 	exemplo SET 		\n");
		sql.append("			nome_exemplo = ?, 	\n");
		sql.append("			descricao = ?		\n");
		sql.append(" WHERE 		seq_exemplo = ?		\n");
		
		return sql.toString();
	}
	
	/**
	 * Altera um exemplo
	 * @param exemploVO
	 * @throws DAOException
	 */
	public void updateExemplo(ExemploVO exemploVO) throws DAOException{		
		try {
			pstmt = getPstmt(getSQLUpdate());
			pstmt.setString(1, exemploVO.getNomeExemplo());
			pstmt.setString(2, exemploVO.getDescricao());
			pstmt.setInt(3, exemploVO.getSeqExemplo().intValue());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo updateExemplo em :: ExemploDAO", e);
			throw new DAOException(e);
		} finally {
			release();
		}
	}
	
	/**
	 * Recupera todos os exemplos
	 * @return
	 * @throws DAOException
	 */
	public List readExemplo() throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT seq_exemplo, nome_exemplo, descricao FROM exemplo ORDER BY 2");
		
		try {
			pstmt = getPstmt(sql.toString());
			rowSet = executeQuery(pstmt);	

			List listaDeExemplo = new ArrayList();
			while (next()) {		
				ExemploVO exemploVO = new ExemploVO();
				exemploVO.setSeqExemplo(new Integer(rowSet.getString("seq_exemplo")));
				exemploVO.setNomeExemplo(rowSet.getString("nome_exemplo"));
				exemploVO.setDescricao(rowSet.getString("descricao"));
				
				listaDeExemplo.add(exemploVO);
			}
			
			return listaDeExemplo;			
		} catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo readExemplo em :: ExemploDAO", e);
			throw new DAOException(e);
		} finally {
			release();
		}
	}
	
	public ExemploVO getExemplo(String seqExemplo) throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT seq_exemplo, nome_exemplo, descricao FROM exemplo WHERE seq_exemplo = ?");
		
		try {
			pstmt = getPstmt(sql.toString());
			pstmt.setString(1, seqExemplo);
			rowSet = executeQuery(pstmt);	
			ExemploVO exeVO = new ExemploVO();
			if (next()) {		
				exeVO.setSeqExemplo(new Integer(rowSet.getString("seq_exemplo")));
				exeVO.setNomeExemplo(rowSet.getString("nome_exemplo"));
				exeVO.setDescricao(rowSet.getString("descricao"));
			}
			
			return exeVO;			
		} catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo getExemplo em :: ExemploDAO", e);
			throw new DAOException(e);
		} finally {
			release();
		}
	}
}
