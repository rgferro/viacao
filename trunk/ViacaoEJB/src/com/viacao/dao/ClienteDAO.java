package com.viacao.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import sun.jdbc.rowset.CachedRowSet;

import com.acol.exception.DAOException;
import com.acol.util.StringUtil;
import com.viacao.services.persistence.BaseDB;
import com.viacao.vo.ClienteVO;
import com.viacao.vo.EnderecoVO;
import com.viacao.vo.FisicaVO;
import com.viacao.vo.JuridicaVO;


public class ClienteDAO extends BaseDB{
	private Logger logger = Logger.getLogger(this.getClass());
	
	public ClienteDAO() throws DAOException{
		super();
	}
	
	/**
	 * SQL InserirCliente
	 * @return query InserirCliente
	 * @throws DAOException
	 */
	public String getSQLInserirCliente(ClienteVO clienteVO) throws DAOException {
		StringBuffer sql = new StringBuffer();
	
		sql.append(" INSERT INTO cliente ( ");
		sql.append("						seq_cliente, ");
		sql.append("						seq_endereco_fk, ");
		sql.append("						login, ");
		sql.append("						senha, ");
		sql.append("						email ) ");
		sql.append(" VALUES (	?, ");
		sql.append("			"+clienteVO.getEnderecoVO().getSeqEndereco().intValue()+", ");
		sql.append("			upper ('"+clienteVO.getLogin()+"'), ");
		sql.append("			upper ('"+clienteVO.getSenha()+"'), ");
		sql.append("			upper ('"+clienteVO.getEmail()+"')) ");
	   
		return sql.toString();
	}
	
	/**
	 * Insere um cliente no banco de dados
	 * @param clienteVO
	 * @throws DAOException
	 */
	public Integer inserirCliente(ClienteVO clienteVO) throws DAOException{	
		try{
			Integer seq = getSequenceNextValue("seq_cliente");
			
			connect();
			
			pstmt = getPstmt(getSQLInserirCliente(clienteVO));
			
			pstmt.setInt(1, seq.intValue());
			
			pstmt.executeUpdate();
			
			return seq;
		}
		catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo inserir cliente em :: ClienteDAO", e);
			throw new DAOException(e);
		}
		finally{
			release();
		}
	}
	
	
	
	
	
	/**
	 * Deleta um cliente no banco de dados
	 * @param clienteVO
	 * @throws DAOException
	 */
	public void deletarCliente(ClienteVO clienteVO) throws DAOException{
		
		StringBuffer sql = new StringBuffer();
				
		sql.append(" DELETE FROM endereco e WHERE seq_endereco = ? ");
		
		try{
			pstmt = getPstmt(sql.toString());
			pstmt.setInt(1, clienteVO.getEnderecoVO().getSeqEndereco().intValue());
			
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo deletarCliente em :: ClienteDAO", e);
			throw new DAOException(e);
		}
		finally{
			release();
		}
		
	}
	
	/**
	 * SQL AlterarCliente
	 * @return query AlterarCliente
	 * @throws DAOException
	 */
	public String getSQLAlterarCliente(ClienteVO clienteVO) throws DAOException {;
		StringBuffer sql = new StringBuffer();
	
		sql.append(" UPDATE	cliente ");
		sql.append(" SET 	login	= upper ('"+ clienteVO.getLogin().trim() +"'), ");
		sql.append("		senha   = upper ('"+ clienteVO.getSenha() +"'), ");
		sql.append("		email 	= upper ('"+ clienteVO.getEmail().trim() +"') ");
		sql.append(" WHERE	seq_cliente = "+ clienteVO.getSeqCliente() +" ");
	
		return sql.toString();
	}
	
	/**
	 * Altera um cliente no banco de dados
	 * @param clienteVO
	 * @throws DAOException
	 */
	public void alterarCliente(ClienteVO clienteVO) throws DAOException{
		
		try{
			pstmt = getPstmt(getSQLAlterarCliente(clienteVO));	
			
			pstmt.executeUpdate();
			
		}
		catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo alterarCliente em :: ClienteDAO", e);
			throw new DAOException(e);
		}
		finally{
			release();
		}
		
	}	
	
	public String getSQLGetCliente() throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT c.seq_cliente, c.login, c.senha, c.email, c.seq_endereco_fk ");
		sql.append(" FROM cliente c ");		
		sql.append(" WHERE c.senha LIKE upper (?) ");
		sql.append(" AND c.login LIKE upper (?) ");
	
		return sql.toString();
	}
	
	public ClienteVO getCliente (ClienteVO clienteVO) throws DAOException{
		try{
			pstmt = getPstmt(getSQLGetCliente());
			pstmt.setString(1,"%"+clienteVO.getSenha()+"%");
			pstmt.setString(2, "%"+clienteVO.getLogin()+"%");
			
			rowSet = executeQuery(pstmt);
			ClienteVO clienteVO2 = new ClienteVO();
			while(rowSet.next()){
				clienteVO2 = new ClienteVO();
				clienteVO2.setLogin(rowSet.getString("login"));
				clienteVO2.setEmail(rowSet.getString("email"));
				clienteVO2.setSenha(rowSet.getString("senha"));
				clienteVO2.setSeqCliente(new Integer(rowSet.getInt("seq_cliente")));
				clienteVO2.setEnderecoVO(new EnderecoVO());
				clienteVO2.getEnderecoVO().setSeqEndereco(new Integer(rowSet.getInt("seq_endereco_fk")));
			}
		return clienteVO2;
		}
		catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo inserir juridica em :: ClienteDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
	}
}