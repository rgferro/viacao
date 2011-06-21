package com.viacao.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.acol.exception.DAOException;
import com.viacao.services.persistence.BaseDB;
import com.viacao.vo.ClienteVO;
import com.viacao.vo.EnderecoVO;
import com.viacao.vo.FisicaVO;


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
	public String getSQLInserirCliente() throws DAOException {
		StringBuffer sql = new StringBuffer();
	
		sql.append(" INSERT INTO cliente ( ");
		sql.append("						seq_cliente, ");
		sql.append("						seq_endereco_fk, ");
		sql.append("						login, ");
		sql.append("						senha, ");
		sql.append("						email ) ");
		sql.append(" VALUES 	seq_cliente.nextval, ");
		sql.append("			?, ");
		sql.append("			upper ('?'), ");
		sql.append("			upper ('?'), ");
		sql.append("			upper ('?')) ");
	   
		return sql.toString();
	}
	
	/**
	 * Insere um cliente no banco de dados
	 * @param clienteVO
	 * @throws DAOException
	 */
	public void inserirCliente(ClienteVO clienteVO) throws DAOException{
		
		try{
			pstmt = getPstmt(getSQLInserirCliente());
			pstmt.setInt(1, clienteVO.getEnderecoVO().getSeqEndereco().intValue());
			pstmt.setString(2, clienteVO.getLogin());
			pstmt.setString(3, clienteVO.getSenha());
			pstmt.setString(4, clienteVO.getEmail());
			
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo inserir cliente em :: ClienteDAO", e);
		}
		finally{
			release();
		}
		
	}
	
	/**
	 * SQL InserirFisica
	 * @return query InserirFisica
	 * @throws DAOException
	 */
	public String getSQLInserirFisica() throws DAOException {
		StringBuffer sql = new StringBuffer();
	
		sql.append(" INSERT INTO fisica ( ");
		sql.append("						seq_fisica, ");
		sql.append("						seq_cliente_fk, ");
		sql.append("						nom_pessoa, ");
		sql.append("						cpf_pessoa, ");
		sql.append("						rg_pessoa ) ");
		sql.append(" VALUES 	seq_fisica.nextval, ");
		sql.append("			?, ");
		sql.append("			upper ('?'), ");
		sql.append("			upper ('?'), ");
		sql.append("			upper ('?')) ");
	   
		return sql.toString();
	}
	
	/**
	 * Insere um cliente fisico no banco de dados
	 * @param fisicaVO
	 * @throws DAOException
	 */
	public void inserirFisica(FisicaVO fisicaVO) throws DAOException{
		
		try{
			pstmt = getPstmt(getSQLInserirFisica());
			pstmt.setInt(1, fisicaVO.getClienteVO().getSeqCliente().intValue());
			pstmt.setString(2, fisicaVO.getNomPessoa());
			pstmt.setString(3, fisicaVO.getCpfPessoa());
			pstmt.setString(4, fisicaVO.getRgPessoa());
			
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo inserir fisica em :: ClienteDAO", e);
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
	public String getSQLAlterarCliente() throws DAOException {;
		StringBuffer sql = new StringBuffer();
	
		sql.append(" UPDATE	cliente ");
		sql.append(" SET 	login	= upper ('?'), ");
		sql.append("		senha   = upper ('?'), ");
		sql.append("		email 	= upper ('?') ");
		sql.append(" WHERE	seq_cliente = ? ");
	
		return sql.toString();
	}
	
	/**
	 * Altera um cliente no banco de dados
	 * @param clienteVO
	 * @throws DAOException
	 */
	public void alterarCliente(ClienteVO clienteVO) throws DAOException{
		
		try{
			pstmt = getPstmt(getSQLAlterarCliente());
			pstmt.setString(1, clienteVO.getLogin());
			pstmt.setString(2, clienteVO.getSenha());
			pstmt.setString(3, clienteVO.getEmail());
			pstmt.setInt(4, clienteVO.getSeqCliente().intValue());
			
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
	
	/**
	 * SQL AlterarFisica
	 * @return query AlterarFisica
	 * @throws DAOException
	 */
	public String getSQLAlterarFisica() throws DAOException {;
		StringBuffer sql = new StringBuffer();
	
		sql.append(" UPDATE	fisica ");
		sql.append(" SET 	nom_pessoa	= upper ('?'), ");
		sql.append("		CPF_pessoa	= upper ('?'), ");
		sql.append("		RG_pessoa	= upper ('?') ");
		sql.append(" WHERE	seq_fisica	= ? ");
	
		return sql.toString();
	}
	
	/**
	 * Altera um cliente fisico no banco de dados
	 * @param fisicaVO
	 * @throws DAOException
	 */
	public void alterarFisica(FisicaVO fisicaVO) throws DAOException{
		
		try{
			pstmt = getPstmt(getSQLAlterarFisica());
			pstmt.setString(1, fisicaVO.getNomPessoa());
			pstmt.setString(2, fisicaVO.getCpfPessoa());
			pstmt.setString(3, fisicaVO.getRgPessoa());
			pstmt.setInt(4, fisicaVO.getSeqFisica().intValue());
			
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo AlterarFisica em :: ClienteDAO", e);
			throw new DAOException(e);
		}
		finally{
			release();
		}
		
	}
	
	/**
	 * SQL 
	 * @return
	 */
	public String getSQLClienteFisica(){
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT	c.login, ");
		sql.append("  		c.senha, ");
		sql.append("        c.email, ");
		sql.append("        f.nom_pessoa, ");
		sql.append("       	f.cpf_pessoa, ");
		sql.append("        f.rg_pessoa, ");
		sql.append("        e.logradouro, ");
		sql.append("		e.numero, ");
		sql.append("        e.complemento, ");
		sql.append("        e.bairro, ");
		sql.append("        e.cidade, ");
		sql.append("        e.estado ");
		sql.append(" FROM	endereco e, cliente c, fisica f ");
		sql.append(" WHERE	f.seq_cliente_fk = c.seq_cliente ");
		sql.append(" AND	c.seq_endereco_fk = e.seq_endereco ");
		sql.append(" AND 	seq_fisica = ? ");
		
		return sql.toString();
	}
	
	public FisicaVO getClienteFisica (FisicaVO fisicaVO) throws DAOException{
		
		try{
			pstmt = getPstmt(getSQLClienteFisica());
			pstmt.setInt(1, fisicaVO.getSeqFisica().intValue());
			rowSet = executeQuery(pstmt);
			
			FisicaVO fVO = new FisicaVO();;
			if(rowSet.next()){
				fVO.setSeqFisica(new Integer(rowSet.getInt("seq_fisica")));
				fVO.setClienteVO(new ClienteVO());
				fVO.getClienteVO().setLogin(rowSet.getString("login"));
				fVO.getClienteVO().setSenha(rowSet.getString("senha"));
				fVO.getClienteVO().setEmail(rowSet.getString("email"));
				fVO.setNomPessoa(rowSet.getString("nom_pessoa"));
				fVO.setCpfPessoa(rowSet.getString("cpf_pessoa"));
				fVO.setRgPessoa(rowSet.getString("rg_pessoa"));
				fVO.getClienteVO().setEnderecoVO(new EnderecoVO());
				fVO.getClienteVO().getEnderecoVO().setLogradouro(rowSet.getString("logradouro"));
				fVO.getClienteVO().getEnderecoVO().setNumero(rowSet.getString("numero"));
				fVO.getClienteVO().getEnderecoVO().setComplemento(rowSet.getString("complemento"));
				fVO.getClienteVO().getEnderecoVO().setBairro(rowSet.getString("bairro"));
				fVO.getClienteVO().getEnderecoVO().setCidade(rowSet.getString("cidade"));
				fVO.getClienteVO().getEnderecoVO().setEstado(rowSet.getString("estado"));
			}
			return fVO;
		}
		catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo getClienteFisica em :: ClienteDAO", e);
			throw new DAOException(e);
		}
		finally{
			release();
		}
	}
	
	private String getSQLListaClienteFisica(FisicaVO fisicaVO){
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT	c.login, ");
		sql.append("  		c.senha, ");
		sql.append("        c.email, ");
		sql.append("        f.nom_pessoa, ");
		sql.append("       	f.cpf_pessoa, ");
		sql.append("        f.rg_pessoa, ");
		sql.append("        e.logradouro, ");
		sql.append("		e.numero, ");
		sql.append("        e.complemento, ");
		sql.append("        e.bairro, ");
		sql.append("        e.cidade, ");
		sql.append("        e.estado ");
		sql.append(" FROM	endereco e, cliente c, fisica f ");
		sql.append(" WHERE	f.seq_cliente_fk = c.seq_cliente ");
		sql.append(" AND 	c.seq_endereco_fk = e.seq_endereco ");
		
		// filtro por nome pessoa
		if(fisicaVO.getNomPessoa() != null){
			sql.append(" AND f.nom_pessoa LIKE upper ('%"+ fisicaVO.getNomPessoa() +"%') ");
		}
		// filtro por login cliente
		if(fisicaVO.getClienteVO().getLogin() != null){
			sql.append(" AND c.login LIKE upper ('%"+ fisicaVO.getClienteVO().getLogin() +"%') ");
		}
		// filtro por email cliente
		if(fisicaVO.getClienteVO().getEmail() != null){
			sql.append(" AND c.email LIKE upper ('%"+ fisicaVO.getClienteVO().getEmail() +"%') ");
		}
		
		return sql.toString();
	}
	
	public List< FisicaVO > getListaClienteFisica (FisicaVO fisicaVO) throws DAOException{
		
		try{
			pstmt = getPstmt(getSQLListaClienteFisica(fisicaVO));
			
			rowSet = executeQuery(pstmt);
			List<FisicaVO> lista = new ArrayList<FisicaVO>();
			
			while(rowSet.next()){
				FisicaVO fisica = new FisicaVO();
				fisica.setSeqFisica(new Integer(rowSet.getInt("seq_fisica")));
				fisica.setClienteVO(new ClienteVO());
				fisica.getClienteVO().setLogin(rowSet.getString("login"));
				fisica.getClienteVO().setSenha(rowSet.getString("senha"));
				fisica.getClienteVO().setEmail(rowSet.getString("email"));
				fisica.setNomPessoa(rowSet.getString("nom_pessoa"));
				fisica.setCpfPessoa(rowSet.getString("cpf_pessoa"));
				fisica.setRgPessoa(rowSet.getString("rg_pessoa"));
				fisica.getClienteVO().setEnderecoVO(new EnderecoVO());
				fisica.getClienteVO().getEnderecoVO().setLogradouro(rowSet.getString("logradouro"));
				fisica.getClienteVO().getEnderecoVO().setNumero(rowSet.getString("numero"));
				fisica.getClienteVO().getEnderecoVO().setComplemento(rowSet.getString("complemento"));
				fisica.getClienteVO().getEnderecoVO().setBairro(rowSet.getString("bairro"));
				fisica.getClienteVO().getEnderecoVO().setCidade(rowSet.getString("cidade"));
				fisica.getClienteVO().getEnderecoVO().setEstado(rowSet.getString("estado"));
				lista.add(fisica);
			}
			return lista;
		}
		catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo ListaClienteFisica em :: ClienteDAO");
			throw new DAOException(e);
		}
		finally{
			release();
		}
	}
}