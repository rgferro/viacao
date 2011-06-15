package com.viacao.dao;


import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.acol.exception.DAOException;
import com.viacao.services.persistence.BaseDB;
import com.viacao.vo.EnderecoVO;
import com.viacao.vo.OnibusVO;

public class EnderecoDAO extends BaseDB {
	private Logger logger = Logger.getLogger(this.getClass());
	
	public EnderecoDAO() throws DAOException {
		super();
		
	}
	private String getInsertSQL(){
		StringBuffer sql = new StringBuffer();
		
		sql.append("  INSERT INTO endereco(            ");
		sql.append("    seq_endereco,                  ");
		sql.append("    logradouro,                    ");
		sql.append("    numero,                        ");
		sql.append("    complemento,                   ");
		sql.append("    bairro,                        ");
		sql.append("    cidade,                        ");
		sql.append("    estado)                        ");
		sql.append("   VALUES(                         ");
		sql.append("     seq_endereco.nextval,         ");
		sql.append("     upper(?),  				   ");
		sql.append("     upper(?),       			   ");
		sql.append("     upper(?), 					   ");
		sql.append("     upper(?),       			   ");
		sql.append("     upper(?),      			   ");
		sql.append("     upper(?))      			   ");
		
		return sql.toString();
	}
	
	public void insert(EnderecoVO enderecoVO)throws DAOException{
		try {
			pstmt = getPstmt(getInsertSQL());
			
			pstmt.setString(1, enderecoVO.getLogradouro());
			pstmt.setString(2, enderecoVO.getNumero());
			pstmt.setString(3, enderecoVO.getComplemento());
			pstmt.setString(4, enderecoVO.getBairro());
			pstmt.setString(5, enderecoVO.getCidade());
			pstmt.setString(6, enderecoVO.getEstado());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo insert em :: EnderecoDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
		
	}
	
	private String getAlterarSQL(EnderecoVO enderecoVO){
		StringBuffer sql = new StringBuffer();
		
		sql.append(" UPDATE endereco                                                                    ");
		sql.append("  SET 	                                                                            ");
		sql.append("       logradouro = upper('"+enderecoVO.getLogradouro()+"'),                        ");
		sql.append(" 	      numero = upper('"+enderecoVO.getNumero() +"),			                    ");
		sql.append("        complemento = upper('"+enderecoVO.getComplemento()+"'),                     ");
		sql.append("        bairro = upper('"+enderecoVO.getBairro()+"'),                               ");
		sql.append("        cidade = upper('"+enderecoVO.getCidade()+"'),                               ");
		sql.append("        estado = upper('"+enderecoVO.getEstado()+"')                                ");
		sql.append("  WHERE seq_endereco = "+enderecoVO.getSeqEndereco()                                 );
		
		return sql.toString();
	}
	public void alterar(EnderecoVO enderecoVO)throws DAOException{
		try {
			pstmt = getPstmt(getAlterarSQL(enderecoVO));
			rowSet = executeQuery(pstmt);
		} catch (Exception e) {
			logger.fatal("Erro ocorrido no metodo alterar em :: EnderecoDAO", e);
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
	                        //filtro logradouro                                  
		sql.append("          AND logradouro like upper('%"+enderecoVO.getLogradouro()+"%')");
							//filtro numero                                       
		sql.append("          AND numero like upper('%"+enderecoVO.getNumero()+"%') ");
							//filtro bairro                                      
		sql.append("          AND bairro like upper('%"+enderecoVO.getBairro()+"%') ");
							//filtro cidade                                      
		sql.append("          AND cidade like upper('%"+enderecoVO.getCidade()+"%') ");
							//filtro estado                                      
		sql.append("          AND estado like upper('%"+enderecoVO.getEstado()+"%') ");
							//filtro complemento                                 
		sql.append("          AND complemento like upper('%"+enderecoVO.getComplemento()+"%') ");
		
		return sql.toString();
	}
	public EnderecoVO getEndereco(EnderecoVO enderecoVO)throws DAOException{
		try{
			pstmt = getPstmt(getEnderecoSQL(enderecoVO));
			rowSet = executeQuery(pstmt);
			EnderecoVO endereco = new EnderecoVO();
			
			if(rowSet.next()){
				endereco.setLogradouro(rowSet.getString("logradouro"));
				endereco.setNumero(rowSet.getString("numero"));
				endereco.setComplemento(rowSet.getString("complemento"));
				endereco.setBairro(rowSet.getString("bairro"));
				endereco.setCidade(rowSet.getString("cidade"));
				endereco.setEstado(rowSet.getString("estado"));
				
			}
			return endereco;
		}catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo getOnibus em :: OnibusDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
		
	}
		
		
	
}
