package com.viacao.services.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import sun.jdbc.rowset.CachedRowSet;

import com.acol.exception.BaseException;
import com.acol.exception.DAOException;
import com.acol.services.ServiceLocator;
 
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
	* @throws DAOException Em caso de ocorr�ncia de SQLException
    */
	protected BaseDB()throws DAOException {
		this(true);
	}
	
     /**
	* Construtor da BaseDB que pode obter ou nao uma connection
	* quando se instancia
	* @param connectNow - Se verdadeiro faz com que BaseDB conecte
	* no instante da instancia��o. Se falso, isto poder� ser feito
	* mais tarde se necess�rio por meio do m�todo 'conect'
	* 
	* @throws DAOException Em caso de ocorr�ncia de SQLException
	* 
	*/
	protected BaseDB(boolean connectNow) throws DAOException { 	
		try {
			ServiceLocator locator = ServiceLocator.instance();
			cachedDS = (DataSource) locator.getService("java:comp/env/jdbc/EstagioDS");	
			if(connectNow){
				   connect();
				}
		} catch (BaseException e) {
			logger.fatal("BaseDB(boolean) BaseException", e);
		} catch (NullPointerException e) {
			logger.fatal("@@@ NullPointerException: DataSource Nulo @@@", e);
		} catch (RuntimeException e) {
			logger.fatal("@@@ RuntimeException: DataSource Nulo @@@", e);
		} catch (SQLException e) {
			logger.fatal("Erro no inicializador de BaseDB", e);
		}
	}
      
	/**
	 * Realiza a conex�o.
	 * @throws SQLException
	 */
	public void connect() throws SQLException {
		logger.debug("connect() - CONECTANDO >>>>>>>>");
		con = (!isConnected() ? cachedDS.getConnection() : con);
	}

	/**
	 * Verifica se est� conectado.
	 * @throws SQLException
	 * 
	 * @return true se estiver conectado ou false em caso contr�rio 
	 * 
	 */
	public boolean isConnected() throws SQLException{
	   return ( con != null && !con.isClosed() ) ? true : false;
	}
	

	/**
	 * Prepara o Command para executar
	 * uma DML informada.
	 * 
	 *  @param statement � usado como argumento para prepareStatement(String)
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
	 * @throws SQLException Durante a cria��o do statement
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
	 * @throws DAOException Em caso de ocorr�ncia de SQLException
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
	 * M�todo que executa uma query do prepared statement e encapsula
	 * a cria��o e popula��o do CachedRowSet.
	 * @param p - PreparedStatement
	 * @return Uma implementa��o do CachedRowSet
	 * @throws DAOException Em caso de ocorr�ncia de SQLException
	 */
	public CachedRowSet executeQuery(PreparedStatement p) throws DAOException{
		try {
			rowSet = new CachedRowSet();
			rowSet.populate(p.executeQuery());
			rowSet.beforeFirst();
		
			return rowSet; 
		} catch (SQLException e) {
			logger.fatal("Erro ao executar query", e);
			throw new DAOException(e);
		}
	}
	
	public CachedRowSet executeQuery(String statement) throws DAOException {
		try {
			if (stmt == null) {
				getStmt();
			}
			
			rowSet = new CachedRowSet();
			rowSet.populate(stmt.executeQuery(statement));
			rowSet.beforeFirst();
			
			return rowSet; 
		} catch (SQLException e) {
			throw new DAOException(e) ;
		}
	}
	
	/**
	 * Obs.: Cuidado ao utilizar esse m�todo pois ele abrira uma conection (<code>connect()</code>) e ao final,
	 * executar� o <code>release()</code>. Portanto, se vc o utilizar no meio do seu metodo, ele ir� fechar a conection
	 * atual do dao. Use esse m�todo no inicio de seus m�todos.
	 * @param seqName String
	 * @return int next sequence value
	 * @throws DAOException - erro inesperado
	 */
	public int getSequenceNextValue(String seqName) throws DAOException {
		try {
			String sql = "SELECT " + seqName + ".NEXTVAL FROM DUAL";
			CachedRowSet rs = executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return -1;
			}
		} catch (Exception e) {
			throw new DAOException(e) ;
		} finally {
			release();
		}
	}



}