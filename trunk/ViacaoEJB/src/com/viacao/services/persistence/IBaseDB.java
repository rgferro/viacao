package com.viacao.services.persistence;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import sun.jdbc.rowset.CachedRowSet;


import com.acol.exception.DAOException;

/**
 * @author mayworm
 */
public interface IBaseDB {
	
	
	
	/**
	* Realiza a conex�o.
	* @throws SQLException
	* 04/12/2003
	*
	*/
	public abstract void connect() throws SQLException;

	/**
	* Verifica se est� conectado.
	* @throws SQLException
	* 04/12/2003
	*
	*/
	public abstract  boolean isConnected() throws SQLException;
	

	/**
	 * Prepara o Command para executar
	 * uma DML informada.
	 * @throws SQLException
	 * 14/05/2003
	 *
	 */

	public abstract  PreparedStatement getPstmt(String statement) throws SQLException;
	
	/**
	 * Prepara o Command para chamar um stored procedure
	 * @throws SQLException
	 * 09/12/2003
	 *
	 */
	public abstract  Statement getStmt() throws SQLException;
	
	/**
	 * Prepara o Command para chamar um stored procedure
	 * 09/12/2003
	 *
	 */
	public abstract  CallableStatement getCstmt(String statement) throws SQLException;

	/**
	 * Proximo registro.
	 * @return boolean
	 * @throws SQLException
	 * 14/05/2003
	 *
	 */
	public abstract boolean next() throws SQLException;

	/**
	 * Registro anterior.
	 * @return boolean
	 * @throws SQLException
	 * 14/05/2003
	 * @throws 
	 *
	 */
	public abstract boolean previous() throws SQLException;
	
	/**
	 * Fecha o PreparedeStatement, o CallableStatement e a 
	 * conexao.
	 * 14/05/2003
	 * @throws DAOException Em caso de ocorr�ncia de SQLException
	 *
	 */	
	public abstract void release() throws DAOException;

	/**
	 * Executa uma query de um prepared statement encapsulando a cria��o
	 * de uma implementa��o do CachedRowSet.
	 * <P>
	 * Luiz Henrique - 20/05/2005
	 * @param p - O PreparedStatement que cont�m a query a ser executada.
	 * @return Uma implementa��o do CachedRowSet populado.
	 * @throws DAOException Em caso de SQLException
	 */
	public abstract CachedRowSet executeQuery(PreparedStatement p) throws DAOException;

}
