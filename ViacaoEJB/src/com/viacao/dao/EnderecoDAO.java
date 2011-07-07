package com.viacao.dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import sun.jdbc.rowset.CachedRowSet;

import com.acol.exception.DAOException;
import com.acol.util.StringUtil;
import com.viacao.services.persistence.BaseDB;
import com.viacao.vo.EnderecoVO;
import com.viacao.vo.OnibusVO;

public class EnderecoDAO extends BaseDB {
	private Logger logger = Logger.getLogger(this.getClass());
	
	public EnderecoDAO() throws DAOException {
		super();
		
	}
	/*
	 * SQL-01 
	 * */
	private String getInsertSQL(EnderecoVO enderecoVO){
		StringBuffer sql = new StringBuffer();
		
		sql.append("  INSERT INTO	endereco(            ");
		sql.append("    			seq_endereco,                  ");
		sql.append("    			logradouro,                    ");
		sql.append("   				numero,                        ");
		sql.append("    			complemento,                   ");
		sql.append("    			bairro,                        ");
		sql.append("    			cidade,                        ");
		sql.append("    			estado)                        ");
		sql.append("   VALUES(                         						");
		sql.append("     		?,							   				");
		sql.append("     		upper('"+enderecoVO.getLogradouro()+"'),	");
		sql.append("     		upper("+enderecoVO.getNumero()+"),			");
		sql.append("     		upper('"+enderecoVO.getComplemento()+"'),	");
		sql.append("     		upper('"+enderecoVO.getBairro()+"'),		");
		sql.append("     		upper('"+enderecoVO.getCidade()+"'),		");
		sql.append("     		upper('"+enderecoVO.getEstado()+"'))		");
		
		return sql.toString();
	}
	
	/*
	 * SQL-01 
	 * */ 
	public Integer insert(EnderecoVO enderecoVO)throws DAOException{
		try {
			
			Integer seq = getSequenceNextValue("seq_endereco");
			
			connect();
			
			pstmt = getPstmt(getInsertSQL(enderecoVO));
			
			pstmt.setInt(1, seq.intValue());
			
			pstmt.executeUpdate();
			
			return seq;
			
		} catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo insert em :: EnderecoDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
		
	}
	/*
	 * SQL-02 
	 * */
	private String getAlterarEnderecoSQL(EnderecoVO enderecoVO){
		StringBuffer sql = new StringBuffer();
		
		sql.append(" UPDATE endereco                                                                    ");
		sql.append("  SET 	                                                                            ");
		sql.append("       logradouro = upper('"+enderecoVO.getLogradouro()+"'),                        ");
		sql.append(" 	      numero = upper('"+enderecoVO.getNumero() +"'),			                    ");
		sql.append("        complemento = upper('"+enderecoVO.getComplemento()+"'),                     ");
		sql.append("        bairro = upper('"+enderecoVO.getBairro()+"'),                               ");
		sql.append("        cidade = upper('"+enderecoVO.getCidade()+"'),                               ");
		sql.append("        estado = upper('"+enderecoVO.getEstado()+"')                                ");
		sql.append("  WHERE seq_endereco = "+enderecoVO.getSeqEndereco()                                 );
		
		
		return sql.toString();
	}
	/*
	 * SQL-02 
	 * */
	public void alterarEndereco(EnderecoVO enderecoVO)throws DAOException{
		try {
			
			pstmt = getPstmt(getAlterarEnderecoSQL(enderecoVO));		
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			logger.fatal("Erro ocorrido no metodo alterar em :: EnderecoDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
	
	}
	
	private String getEnderecoSQL(EnderecoVO enderecoVO){
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT seq_endereco,                                           ");
		sql.append("        logradouro,                                             ");
		sql.append("        numero,                                                 ");
		sql.append("        complemento,                                            ");
		sql.append("        bairro,                                                 ");
		sql.append("        cidade,                                                 ");
		sql.append("        estado                                                  ");
		sql.append("   FROM endereco                                                ");
		sql.append("       WHERE 1=1                                                ");
		if(!StringUtil.empty(enderecoVO.getLogradouro())){
	                        //filtro logradouro                                  
		sql.append("          AND logradouro like upper('%"+enderecoVO.getLogradouro()+"%')");
		}
		if(!StringUtil.empty(enderecoVO.getNumero())){
							//filtro numero                                       
		sql.append("          AND numero like upper('%"+enderecoVO.getNumero()+"%') ");
		}
		if(!StringUtil.empty(enderecoVO.getBairro())){
							//filtro bairro                                      
		sql.append("          AND bairro like upper('%"+enderecoVO.getBairro()+"%') ");
		}
		if(!StringUtil.empty(enderecoVO.getCidade())){
							//filtro cidade                                      
		sql.append("          AND cidade like upper('%"+enderecoVO.getCidade()+"%') ");
		}
		if(!StringUtil.empty(enderecoVO.getEstado())){
							//filtro estado                                      
		sql.append("          AND estado like upper('%"+enderecoVO.getEstado()+"%') ");
		}
		if(!StringUtil.empty(enderecoVO.getComplemento())){
							//filtro complemento                                 
		sql.append("          AND complemento like upper('%"+enderecoVO.getComplemento()+"%') ");
		}
		if(!(enderecoVO.getSeqEndereco() == null)){
							//filtro seq_endereco                             
		sql.append("          AND seq_endereco like upper('%"+enderecoVO.getSeqEndereco()+"%') ");
		}
		
		return sql.toString();
	}
	public EnderecoVO getEndereco(EnderecoVO enderecoVO)throws DAOException{
		try{
			pstmt = getPstmt(getEnderecoSQL(enderecoVO));
			rowSet = executeQuery(pstmt);
			EnderecoVO endereco = new EnderecoVO();
			
			if(rowSet.next()){
				endereco.setSeqEndereco(Integer.valueOf(rowSet.getString("seq_endereco")));
				endereco.setLogradouro(rowSet.getString("logradouro"));
				endereco.setNumero(rowSet.getString("numero"));
				endereco.setComplemento(rowSet.getString("complemento"));
				endereco.setBairro(rowSet.getString("bairro"));
				endereco.setCidade(rowSet.getString("cidade"));
				endereco.setEstado(rowSet.getString("estado"));	
				endereco.setSeqEndereco(new Integer(rowSet.getString("seq_endereco")));
			}
			return endereco;
		}catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo getOnibus em :: EnderecoDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
		
	}
	
	
	private String deletarEnderecoSQL(){
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE  endereco         ");
		sql.append(" WHERE   seq_endereco = ? ");
		
		return sql.toString();
		
	}
	public void deletarEndereco(EnderecoVO enderecoVO)throws DAOException{
		try {
			pstmt = getPstmt(deletarEnderecoSQL());
			pstmt.setInt(1, enderecoVO.getSeqEndereco());
			pstmt.executeUpdate();
		} catch (Exception e) {
			logger.fatal("Erro ocorrido no metodo deletarEnedereco :: EnderecoDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
	}
	
}
