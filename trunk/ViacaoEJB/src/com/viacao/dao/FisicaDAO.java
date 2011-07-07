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

public class FisicaDAO extends BaseDB{
	
	private Logger logger = Logger.getLogger(this.getClass());

	public FisicaDAO() throws DAOException {
		super();
	}
	
	/**
	 * SQL InserirFisica
	 * @return query InserirFisica
	 * @throws DAOException
	 */
	public String getSQLInserirFisica(FisicaVO fisicaVO) throws DAOException {
		StringBuffer sql = new StringBuffer();
	
		sql.append(" INSERT INTO fisica ( ");
		sql.append("						seq_fisica, ");
		sql.append("						seq_cliente_fk, ");
		sql.append("						nom_pessoa, ");
		sql.append("						cpf_pessoa, ");
		sql.append("						rg_pessoa ) ");
		sql.append(" VALUES (	?, ");
		sql.append("			"+fisicaVO.getClienteVO().getSeqCliente().intValue()+", ");
		sql.append("			upper ('"+fisicaVO.getNomPessoa()+"'), ");
		sql.append("			upper ('"+fisicaVO.getCpfPessoa()+"'), ");
		sql.append("			upper ('"+fisicaVO.getRgPessoa()+"')) ");
	   
		return sql.toString();
	}
	
	/**
	 * Insere um cliente fisico no banco de dados
	 * @param fisicaVO
	 * @throws DAOException
	 */	
	public Integer inserirFisica(FisicaVO fisicaVO) throws DAOException{
		
		try{
			Integer seq = getSequenceNextValue("seq_fisica");
			
			connect();
			
			pstmt = getPstmt(getSQLInserirFisica(fisicaVO));
			
			pstmt.setInt(1, seq.intValue());
			
			pstmt.executeUpdate();
			
			return seq;
		}
		catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo inserir fisica em :: ClienteDAO", e);
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
	public String getSQLAlterarFisica(FisicaVO fisicaVO) throws DAOException {;
		StringBuffer sql = new StringBuffer();
	
		sql.append(" UPDATE	fisica ");
		sql.append(" SET 	nom_pessoa	= upper ('"+fisicaVO.getNomPessoa()+"'), ");
		sql.append("		CPF_pessoa	= upper ('"+fisicaVO.getCpfPessoa()+"'), ");
		sql.append("		RG_pessoa	= upper ('"+fisicaVO.getRgPessoa()+"') ");
		sql.append(" WHERE	seq_fisica	=  "+ fisicaVO.getSeqFisica()+"  ");
	
		return sql.toString();
	}
	
	/**
	 * Altera um cliente fisico no banco de dados
	 * @param fisicaVO
	 * @throws DAOException
	 */
	public void alterarFisica(FisicaVO fisicaVO) throws DAOException{
		
		try{
			pstmt = getPstmt(getSQLAlterarFisica(fisicaVO));
	
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
	 * SQL getSQLClienteFisica
	 * @return query getClienteFisica
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
		sql.append(" WHERE	f.seq_cliente_fk(+) = c.seq_cliente ");
		sql.append(" AND	c.seq_endereco_fk = e.seq_endereco ");
		sql.append(" AND 	c.seq_cliente = ? ");
		
		return sql.toString();
	}
	
	/**
	 * Recupera um Cliente Fisica no banco
	 * @param fisicaVO
	 * @return fisicaVO
	 * @throws DAOException
	 */
	public FisicaVO getClienteFisica (FisicaVO fisicaVO) throws DAOException{
		
		try{
			pstmt = getPstmt(getSQLClienteFisica());
			pstmt.setInt(1, fisicaVO.getClienteVO().getSeqCliente());
			rowSet = executeQuery(pstmt);
			
			FisicaVO fVO = new FisicaVO();
			fVO.setClienteVO(new ClienteVO());
			fVO.getClienteVO().setEnderecoVO(new EnderecoVO());
			if(rowSet.next()){
				fVO.getClienteVO().setLogin(rowSet.getString("login"));
				fVO.getClienteVO().setSenha(rowSet.getString("senha"));
				fVO.getClienteVO().setEmail(rowSet.getString("email"));
				if(rowSet.getString("nom_pessoa") != null){
					fVO.setNomPessoa(rowSet.getString("nom_pessoa"));
				}
				if(rowSet.getString("nom_pessoa") != null){
					fVO.setCpfPessoa(rowSet.getString("cpf_pessoa").trim());
				}
				if(rowSet.getString("nom_pessoa") != null){
					fVO.setRgPessoa(rowSet.getString("rg_pessoa").trim());
				}
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
	
	/**
	 * SQL getSQLListaClienteFisica
	 * @param fisicaVO
	 * @return query getListaClienteFisica
	 */
	private String getSQLListaClienteFisica(FisicaVO fisicaVO){
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT f.seq_fisica, ");
		sql.append("  		c.seq_cliente, ");
		sql.append("  		e.seq_endereco, ");
		sql.append("  		c.seq_endereco_fk, ");
		sql.append("  		c.login, ");
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
		sql.append(" WHERE c.seq_endereco_fk = e.seq_endereco ");
		sql.append(" AND f.seq_cliente_fk(+) = c.seq_cliente ");
		sql.append(" AND c.seq_cliente not in (select j.seq_cliente_fk from juridica j) ");
		sql.append(" AND c.seq_cliente not in (select f.seq_cliente_fk from fisica f) ");
		
		sql.append(" UNION ");
		
		sql.append(" SELECT	f.seq_fisica, ");
		sql.append("  		c.seq_cliente, ");
		sql.append("  		e.seq_endereco, ");
		sql.append("  		c.seq_endereco_fk, ");
		sql.append("  		c.login, ");
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
		sql.append(" WHERE	f.seq_cliente_fk  = c.seq_cliente ");
		sql.append(" AND 	c.seq_endereco_fk = e.seq_endereco ");
		
		// filtro por nome pessoa
		if(fisicaVO.getNomPessoa() != null){
			sql.append(" AND f.nom_pessoa LIKE upper ('%"+ fisicaVO.getNomPessoa() +"%') ");
		}
		// filtro por login cliente
		if(fisicaVO.getClienteVO() != null){
			sql.append(" AND c.login LIKE upper ('%"+ fisicaVO.getClienteVO().getLogin() +"%') ");
		}
		// filtro por email cliente
		if(fisicaVO.getClienteVO() != null){
			sql.append(" AND c.email LIKE upper ('%"+ fisicaVO.getClienteVO().getEmail() +"%') ");
		}
		
		return sql.toString();
	}
	
	/**
	 * Recupera lista de clientes no banco de dados
	 * @param fisicaVO
	 * @return List<clienteVO>
	 * @throws DAOException
	 */
	public List<FisicaVO> getListaClienteFisica (FisicaVO fisicaVO) throws DAOException{
		
		try{
			pstmt = getPstmt(getSQLListaClienteFisica(fisicaVO));
			
			rowSet = executeQuery(pstmt);
			List<FisicaVO> lista = new ArrayList<FisicaVO>();
			
			while(rowSet.next()){
				FisicaVO fisica = new FisicaVO();
				fisica.setSeqFisica(new Integer(rowSet.getInt("seq_fisica")));
				fisica.setClienteVO(new ClienteVO());
				fisica.getClienteVO().setEnderecoVO(new EnderecoVO());
				fisica.getClienteVO().setSeqCliente(new Integer(rowSet.getInt("seq_cliente")));
				fisica.getClienteVO().getEnderecoVO().setSeqEndereco(new Integer(rowSet.getInt("seq_endereco")));
				fisica.getClienteVO().setLogin(rowSet.getString("login"));
				fisica.getClienteVO().setSenha(rowSet.getString("senha"));
				fisica.getClienteVO().setEmail(rowSet.getString("email"));
				fisica.setNomPessoa(rowSet.getString("nom_pessoa"));
				fisica.setCpfPessoa(rowSet.getString("cpf_pessoa"));
				fisica.setRgPessoa(rowSet.getString("rg_pessoa"));				
				fisica.getClienteVO().setEnderecoVO(new EnderecoVO());
				fisica.getClienteVO().getEnderecoVO().setSeqEndereco(rowSet.getInt("seq_endereco_fk"));
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
