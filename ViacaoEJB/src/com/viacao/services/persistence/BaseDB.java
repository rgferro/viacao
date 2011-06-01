package com.viacao.services.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.acol.exception.DAOException;

import sun.jdbc.rowset.CachedRowSet;
 
/** 
 * Super classe para os data command beans que
 * criam, alteram ou excluem dados.
 * 
 * @author Marcelo Mayworm
 */
public abstract class BaseDB implements IBaseDB{
	/**   
	 * Logger for this class
	 */
	private static Logger logger = Logger.getLogger(BaseDB.class);

	protected PreparedStatement pstmt;
	protected CallableStatement cstmt;
	protected Statement stmt;
	protected Connection con;
	protected static DataSource cachedDS;
	protected CachedRowSet rowSet = null;

    /**
	 * Construtor default de BaseDB - Connecta ao se instanciar a classe
	 * 
	 * @throws DAOException Em caso de SQLException
     */
    protected BaseDB() throws DAOException {
      	loadBase();
	}


    protected abstract void loadBase();
      
	/**
	 * Realiza a conexão.
	 * @throws SQLException
	 */
	public void connect() throws SQLException {
		logger.debug("connect() - CONECTANDO >>>>>>>>");
		con = (!isConnected() ? cachedDS.getConnection() : con);
	}

	/**
	 * Verifica se está conectado.
	 * @throws SQLException
	 * 
	 * @return true se estiver conectado ou false em caso contrário 
	 * 
	 */
	public boolean isConnected() throws SQLException{
	   return ( con != null && !con.isClosed() ) ? true : false;
	}
	

	/**
	 * Prepara o Command para executar
	 * uma DML informada.
	 * 
	 *  @param statement é usado como argumento para prepareStatement(String)
	 * 
	 * @throws DAOException
	 */
	public PreparedStatement getPstmt(String statement) throws SQLException{
		if(!isConnected()){
		   throw new IllegalStateException("DAO is not connected!");
		}
		return pstmt = con.prepareStatement(statement);
	}
	
	/**
	 * Prepara o Command para chamar um stored procedure
	 * @throws SQLException Durante a criação do statement
	 */
	public  Statement getStmt() throws SQLException{
		logger.debug("Executando getStmt :: BaseDB");
		if(!isConnected()){
		   throw new IllegalStateException("DAO is not connected!");
		}
		try{
			
			return stmt = con.createStatement();
		}catch(SQLException e){
			logger.debug("Erro em obter Statement :: "+e);
			throw e;
		}
	}

	
	/**
	 * Prepara o Command para chamar um stored procedure
	 */
	public  CallableStatement getCstmt(String statement) throws SQLException{
		if(!isConnected()){
		   throw new IllegalStateException("DAO is not connected!");
		}
		return cstmt = con.prepareCall(statement);
	}


	/**
	 * Proximo registro.
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean next() throws SQLException {
		return rowSet.next();
	}

	/**
	 * Registro anterior.
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean previous() throws SQLException {
		return rowSet.previous();
	}
	
	/**
	 * Fecha o PreparedStatement, o CallableStatement e a 
	 * conexao.
	 * @throws DAOException Em caso de ocorrência de SQLException
	 */	
	public void release() throws DAOException {
		try{
			if (pstmt != null){
				pstmt.close();
			}
			if (cstmt != null){
				cstmt.close();
			}
			if (con != null){
				con.close();
			}
				
		}catch(SQLException e){
	          logger.error("Erro ocorrido na tentativa de limpar os resources de dados.", e);
	          throw new DAOException(e);
	     }
	}
	
	/**
	 * Método que executa uma query do prepared statement e encapsula
	 * a criação e população do CachedRowSet.
	 * @param p - PreparedStatement
	 * @return Uma implementação do CachedRowSet
	 * @throws DAOException Em caso de ocorrência de SQLException
	 */
	public CachedRowSet executeQuery(PreparedStatement p) throws DAOException{
		try{
			CachedRowSet rowSet = new CachedRowSet();
			rowSet.populate(p.executeQuery());
			
			return rowSet;
		} catch(SQLException e){
			logger.error("Erro ocorrido ao tentar executar a query.", e);
			throw new DAOException(e);
		}
	}


}