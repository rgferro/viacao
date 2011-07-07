package com.viacao.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.acol.exception.DAOException;
import com.acol.util.StringUtil;
import com.viacao.services.persistence.BaseDB;
import com.viacao.vo.ClienteVO;
import com.viacao.vo.EnderecoVO;
import com.viacao.vo.JuridicaVO;

public class JuridicaDAO extends BaseDB{
	
	private Logger logger = Logger.getLogger(this.getClass());

	public JuridicaDAO() throws DAOException {
		super();
	}
	
	/**
	 * SQL InserirJuridica
	 * @return query InserirJuridica
	 * @throws DAOException
	 */
	public String getSQLInserirJuridica(JuridicaVO juridicaVO) throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append(" INSERT INTO juridica(");
		sql.append("			 	seq_juridica, ");
		sql.append("			 	seq_cliente_fk, ");
		sql.append("			 	razao_social, ");
		sql.append("			 	nom_fantasia, ");
		sql.append("			 	nom_responsavel, ");
		sql.append("			 	cnpj, ");
		sql.append("			 	num_inscricao) ");
		sql.append(" VALUES (	 ?, ");
		sql.append("			 "+juridicaVO.getClienteVO().getSeqCliente()+", ");
		sql.append("			 upper ('"+juridicaVO.getRazaoSocial()+"'), ");
		sql.append("			 upper ('"+juridicaVO.getNomFantasia()+"'), ");
		sql.append("			 upper ('"+juridicaVO.getNomResponsavel()+"'), ");
		sql.append("			 upper ('"+juridicaVO.getCnpj()+"'), ");
		sql.append("			 upper ('"+juridicaVO.getNumInscricao()+"')) ");
	   
		return sql.toString();
	}
	
	/**
	 * Cadastra um cliente juridico no banco de dados
	 * @param JuridicaVO
	 * @throws DAOException
	 */
	public Integer inserirJuridica(JuridicaVO juridicaVO) throws DAOException{
		try{
			Integer seq = getSequenceNextValue("seq_juridica");
			
			connect();
			
			pstmt = getPstmt(getSQLInserirJuridica(juridicaVO));
			pstmt.setInt(1, seq.intValue());
			
			pstmt.executeUpdate();
			
			return seq;
		}
		catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo inserir juridica em :: ClienteDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
	}
	
	/**
	 * SQL AlterarJuridica
	 * @return query AlterarJuridica
	 * @throws DAOException
	 */
	public String getSQLAlterarJuridica() throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append("UPDATE 	juridica ");
		sql.append("SET 	razao_social = 		upper (?), ");
		sql.append("		nom_fantasia = 		upper (?), ");
		sql.append("		nom_responsavel = 	upper (?), ");
		sql.append("		cnpj = 				upper (?), ");
		sql.append("		num_inscricao = 	upper (?) ");
		sql.append("WHERE 	seq_juridica = 		?");
		
		return sql.toString();
	}
	
	/**
	 * Altera um cliente juridico no banco de dados
	 * @param JuridicaVO
	 * @throws DAOException
	 */
	public void alterarJuridica(JuridicaVO juridicaVO) throws DAOException{
		try{
			
			pstmt = getPstmt(getSQLAlterarJuridica());
			pstmt.setString(1, juridicaVO.getRazaoSocial());
			pstmt.setString(2, juridicaVO.getNomFantasia());
			pstmt.setString(3, juridicaVO.getNomResponsavel());
			pstmt.setString(4, juridicaVO.getCnpj());
			pstmt.setString(5, juridicaVO.getNumInscricao());
			pstmt.setInt(6, juridicaVO.getSeqJuridica());
			
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo alterar juridica em :: ClienteDAO", e);
		}finally{
			release();
		}
	}
	
	/**
	 * SQL getClienteJuridica
	 * @return query getClienteJuridica
	 * @throws DAOException
	 */
	public String getSQLGetClienteJuridica() throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT 	c.login 			LOGIN, ");
		sql.append("   		c.senha 			SENHA, ");
		sql.append("   		c.email 			EMAIL, ");
		sql.append("		j.razao_social 		RAZAO_SOCIAL, ");
		sql.append("		j.nom_fantasia 		NOM_FANTASIA, ");
		sql.append("		j.nom_responsavel 	NOM_RESPONSAVEL, ");
		sql.append("		j.cnpj 				CNPJ, ");
		sql.append("		j.num_inscricao 	NUM_INSCRICAO, ");
		sql.append("      	e.logradouro 		LOGRADOURO, ");
		sql.append("      	e.numero 			NUMERO, ");
		sql.append("    	e.complemento 		COMPLEMENTO, ");
		sql.append("      	e.bairro 			BAIRRO, ");
		sql.append("      	e.cidade 			CIDADE, ");
		sql.append("      	e.estado 			ESTADO ");
		sql.append("FROM 	endereco e, cliente c, juridica j ");
		sql.append("WHERE 	j.seq_cliente_fk = c.seq_cliente ");
		sql.append("   AND 	c.seq_endereco_fk = e.seq_endereco ");
		sql.append("   AND 	seq_juridica = ?");
		
		return sql.toString();
	}
	
	/**
	 * Recupera um cliente juridico no banco de dados
	 * @param JuridicaVO
	 * @throws DAOException
	 * @return JuridicaVO
	 */
	public JuridicaVO getClienteJuridica (JuridicaVO juridicaVO) throws DAOException{
		try{
			pstmt = getPstmt(getSQLGetClienteJuridica());
			pstmt.setInt(1, juridicaVO.getSeqJuridica());
			
			rowSet = executeQuery(pstmt);
			
			JuridicaVO juriVO = new JuridicaVO();
			juriVO.setClienteVO(new ClienteVO());
			juriVO.getClienteVO().setEnderecoVO(new EnderecoVO());
			if(rowSet.next()){
				juriVO.getClienteVO().setLogin(rowSet.getString("LOGIN"));
				juriVO.getClienteVO().setSenha(rowSet.getString("SENHA"));
				juriVO.getClienteVO().setEmail(rowSet.getString("EMAIL"));
				juriVO.setRazaoSocial(rowSet.getString("RAZAO_SOCIAL"));
				juriVO.setNomFantasia(rowSet.getString("NOM_FANTASIA"));
				juriVO.setNomResponsavel(rowSet.getString("NOM_RESPONSAVEL"));
				juriVO.setCnpj(rowSet.getString("CNPJ"));
				juriVO.setNumInscricao(rowSet.getString("NUM_INSCRICAO"));
				juriVO.getClienteVO().getEnderecoVO().setLogradouro(rowSet.getString("LOGRADOURO"));
				juriVO.getClienteVO().getEnderecoVO().setNumero(rowSet.getString("NUMERO"));
				juriVO.getClienteVO().getEnderecoVO().setComplemento(rowSet.getString("COMPLEMENTO"));
				juriVO.getClienteVO().getEnderecoVO().setBairro(rowSet.getString("BAIRRO"));
				juriVO.getClienteVO().getEnderecoVO().setCidade(rowSet.getString("CIDADE"));
				juriVO.getClienteVO().getEnderecoVO().setEstado(rowSet.getString("ESTADO"));
			}
			
			return juriVO;
		}
		catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo inserir juridica em :: ClienteDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
	}
	
	/**
	 * SQL getListaClienteJuridica
	 * @return query getListaClienteJuridica
	 * @throws DAOException
	 */
	public String getSQLGetListaClienteJuridica(JuridicaVO juridicaVO) throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT c.seq_cliente, ");
		sql.append("  		e.seq_endereco, ");
		sql.append("  		c.seq_endereco_fk, ");
		sql.append("	 	c.login 			LOGIN, ");
		sql.append("   		c.senha 			SENHA, ");
		sql.append("   		c.email 			EMAIL, ");
		sql.append("   		j.seq_juridica 		SEQ_JURIDICA, ");
		sql.append("   		j.razao_social 		RAZAO_SOCIAL, ");
		sql.append("		j.nom_fantasia 		NOM_FANTASIA, ");
		sql.append("		j.nom_responsavel 	NOM_RESPOSAVEL, ");
		sql.append("		j.cnpj 				CNPJ, ");
		sql.append("		j.num_inscricao 	NUM_INSCRICAO, ");
		sql.append("     	e.logradouro 		LOGRADOURO, ");
		sql.append("     	e.numero 			NUMERO, ");
		sql.append("      	e.complemento 		COMPLEMENTO, ");
		sql.append("      	e.bairro 			BAIRRO, ");
		sql.append("      	e.cidade 			CIDADE, ");
		sql.append("      	e.estado 			ESTADO ");
		sql.append(" FROM	endereco e, cliente c,juridica j ");
		sql.append(" WHERE c.seq_endereco_fk = e.seq_endereco ");
		sql.append(" AND j.seq_cliente_fk(+) = c.seq_cliente ");
		sql.append(" AND c.seq_cliente not in (select j.seq_cliente_fk from juridica j) ");
		sql.append(" AND c.seq_cliente not in (select f.seq_cliente_fk from fisica f) ");
		
		sql.append(" UNION ");
		
		sql.append(" SELECT		c.seq_cliente, ");
		sql.append("  			e.seq_endereco, ");
		sql.append("  			c.seq_endereco_fk, ");
		sql.append("	 		c.login 			LOGIN, ");
		sql.append("   			c.senha 			SENHA, ");
		sql.append("   			c.email 			EMAIL, ");
		sql.append("   			j.seq_juridica 		SEQ_JURIDICA, ");
		sql.append("   			j.razao_social 		RAZAO_SOCIAL, ");
		sql.append("			j.nom_fantasia 		NOM_FANTASIA, ");
		sql.append("			j.nom_responsavel 	NOM_RESPOSAVEL, ");
		sql.append("			j.cnpj 				CNPJ, ");
		sql.append("			j.num_inscricao 	NUM_INSCRICAO, ");
		sql.append("      		e.logradouro 		LOGRADOURO, ");
		sql.append("      		e.numero 			NUMERO, ");
		sql.append("      		e.complemento 		COMPLEMENTO, ");
		sql.append("      		e.bairro 			BAIRRO, ");
		sql.append("      		e.cidade 			CIDADE, ");
		sql.append("      		e.estado 			ESTADO ");
		sql.append("FROM 		endereco e, cliente c, juridica j ");
		sql.append("WHERE 		j.seq_cliente_fk = c.seq_cliente ");
		sql.append("   	  AND 	c.seq_endereco_fk = e.seq_endereco ");
		if(juridicaVO.getRazaoSocial() != null){
			sql.append("      AND 	j.razao_social LIKE upper ('%" + juridicaVO.getRazaoSocial() + "%') ");
		}
		if(juridicaVO.getClienteVO().getLogin() != null){
			sql.append("      AND 	c.login LIKE upper ('%" + juridicaVO.getClienteVO().getLogin() + "%') ");
		}
		if(juridicaVO.getClienteVO().getEmail() != null){
			sql.append("      AND 	c.email LIKE upper ('%" + juridicaVO.getClienteVO().getEmail() + "%')");
		}

		return sql.toString();
	}
	
	/**
	 * Recupera lista de clientes juridicos no banco de dados
	 * @param JuridicaVO
	 * @throws DAOException
	 * @return List<ClienteVO>
	 */
	public List<JuridicaVO> getListaClienteJuridica (JuridicaVO juridicaVO) throws DAOException{
		try{
			pstmt = getPstmt(getSQLGetListaClienteJuridica(juridicaVO));
			
			rowSet = executeQuery(pstmt);
			
			List<JuridicaVO> listaClienteJuridica = new ArrayList();
			while(rowSet.next()){
				JuridicaVO juriVO = new JuridicaVO();
				juriVO.setClienteVO(new ClienteVO());
				juriVO.getClienteVO().setEnderecoVO(new EnderecoVO());
				juriVO.getClienteVO().setSeqCliente(new Integer(rowSet.getString("seq_cliente")));
				juriVO.getClienteVO().getEnderecoVO().setSeqEndereco(new Integer(rowSet.getString("seq_endereco")));
				juriVO.getClienteVO().getEnderecoVO().setSeqEndereco(new Integer(rowSet.getString("seq_endereco_fk")));
				juriVO.getClienteVO().setLogin(rowSet.getString("LOGIN"));
				juriVO.getClienteVO().setSenha(rowSet.getString("SENHA"));
				juriVO.getClienteVO().setEmail(rowSet.getString("EMAIL"));
				if(!StringUtil.empty(rowSet.getString("SEQ_JURIDICA"))){
					juriVO.setSeqJuridica(new Integer(rowSet.getString("SEQ_JURIDICA")));
				}
				juriVO.setRazaoSocial(rowSet.getString("RAZAO_SOCIAL"));
				juriVO.setNomFantasia(rowSet.getString("NOM_FANTASIA"));
				juriVO.setNomResponsavel(rowSet.getString("NOM_RESPOSAVEL"));
				juriVO.setCnpj(rowSet.getString("CNPJ"));
				juriVO.setNumInscricao(rowSet.getString("NUM_INSCRICAO"));
				juriVO.getClienteVO().getEnderecoVO().setLogradouro(rowSet.getString("LOGRADOURO"));
				juriVO.getClienteVO().getEnderecoVO().setNumero(rowSet.getString("NUMERO"));
				juriVO.getClienteVO().getEnderecoVO().setComplemento(rowSet.getString("COMPLEMENTO"));
				juriVO.getClienteVO().getEnderecoVO().setBairro(rowSet.getString("BAIRRO"));
				juriVO.getClienteVO().getEnderecoVO().setCidade(rowSet.getString("CIDADE"));
				juriVO.getClienteVO().getEnderecoVO().setEstado(rowSet.getString("ESTADO"));
				
				listaClienteJuridica.add(juriVO);
			}
			
			return listaClienteJuridica;
		}
		catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo inserir juridica em :: ClienteDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
	}

}
