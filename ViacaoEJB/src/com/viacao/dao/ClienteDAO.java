package com.viacao.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import sun.jdbc.rowset.CachedRowSet;

import com.acol.exception.DAOException;
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
		
		System.out.println(sql.toString());
	   
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
		
		System.out.println(sql.toString());
	   
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
		
		System.out.println(sql.toString());
	
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
		
		System.out.println(sql.toString());
		
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
		sql.append(" FROM	endereco e, cliente c, fisica f,juridica j ");
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
		sql.append(" FROM	endereco e, cliente c, fisica f,juridica j ");
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
	
//------------------------------------- JURIDICA -------------------------------------------------------------	
	
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
				juriVO.setSeqJuridica(new Integer(rowSet.getString("SEQ_JURIDICA")));
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