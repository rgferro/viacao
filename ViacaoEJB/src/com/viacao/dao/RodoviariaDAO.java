package com.viacao.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.acol.exception.DAOException;
import com.viacao.services.persistence.BaseDB;
import com.viacao.vo.RodoviariaVO;

public class RodoviariaDAO  extends BaseDB{
	
	private Logger logger = Logger.getLogger(this.getClass());
	public RodoviariaDAO() throws DAOException {
		super();
	
	}
	
	/*
	 * SQL-04
	 * */
	private String getInserirSQL(){
		StringBuffer sql = new StringBuffer();
		
		sql.append(" INSERT INTO rodoviaria(                ");
		sql.append("   seq_rodoviaria,                      ");
		sql.append("   seq_endereco_fk,                     ");
		sql.append("   nom_rodoviaria)                      ");
		sql.append("  VALUES (                              ");
		sql.append("    seq_rodoviaria.nextval,             ");
		sql.append("    <param_seq_endereco>,               ");
		sql.append("    upper('<param_nom_rodoviaria>'))    ");
		
		return sql.toString();
	}
	
	/*
	 * SQL-04
	 * */
	public void inserir(RodoviariaVO rodoviariaVO)throws DAOException{
		try {
			pstmt = getPstmt(getInserirSQL());
			pstmt.setInt(1, rodoviariaVO.getSeqRodoviaria());
			pstmt.setInt(2, rodoviariaVO.getEnderecoVO().getSeqEndereco());
			pstmt.setString(3, rodoviariaVO.getNomRodoviaria());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			logger.fatal("Erro ocorrido no metodo inserir em :: RodoviariaDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
	}
	
	/*
	 * SQL-05
	 * */
	private String getDeletarSQL(){
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE 	rodoviaria     ");
		sql.append(" WHERE 	seq_rodoviaria = ? ");
		return sql.toString();
		
	}
	public void deletar(RodoviariaVO rodoviariaVO)throws DAOException{
    try {
			pstmt = getPstmt(getDeletarSQL());
			pstmt.setInt(1, rodoviariaVO.getSeqRodoviaria());
			pstmt.executeUpdate();
        } catch (Exception e) {
		   logger.fatal("Erro ocorrido no metodo deletar em :: RodoviariaDAO", e);
		   throw new DAOException(e);
	    } finally {
		release();
	    }
	}	
	/*
	 * SQL-06
	 * */
	private String getAlterarSQL(){
		
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE rodoviaria                                    ");
		sql.append("    SET 		                                      ");
		sql.append(" 	      nom_rodoviaria = upper(?)                   ");
		sql.append("   WHERE                                              ");
		sql.append("     seq_rodoviaria = ?	                              ");
		
		return sql.toString();
	}
	/*
	 * SQL-06
	 * */
	public void alterar(RodoviariaVO rodoviariaVO)throws DAOException{
		try {
			pstmt = getPstmt(getAlterarSQL());
			pstmt.setString(1, rodoviariaVO.getNomRodoviaria());
			pstmt.setInt(3, rodoviariaVO.getSeqRodoviaria());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			logger.fatal("Erro ocorrido no metodo deletar em :: RodoviariaDAO", e);
			   throw new DAOException(e);
		}finally{
			release();
		}
	}
	/*
	 * SQL-07
	 * */
	private String getOnibusSQL(){
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT 	r.seq_rodoviaria,                      ");
		sql.append("         e.seq_endereco,                           ");
		sql.append("         r.nom_rodoviaria,                         ");
		sql.append("         e.logradouro,                             ");
		sql.append("         e.numero,                                 ");
		sql.append("         e.complemento,                            ");
		sql.append("         e.bairro,                                 ");
		sql.append("         e.cidade,                                 ");
		sql.append("         e.estado                                  ");
		sql.append("  FROM  endereco e,                                ");
		sql.append("        rodoviaria r                               ");
		sql.append("   WHERE                                           ");
		sql.append("     r.seq_endereco_fk = e.seq_endereco            ");
		sql.append("    AND                                            ");
		sql.append("      r.seq_rodoviaria = ?                         ");
		
		return sql.toString();
	}
	/*
	 * SQL-07
	 * */
	public RodoviariaVO getRodoviaria(RodoviariaVO rodoviariaVO)throws DAOException{
	try {
		pstmt = getPstmt(getOnibusSQL());
		pstmt.setInt(1, rodoviariaVO.getSeqRodoviaria());
		rowSet = executeQuery(pstmt);
		RodoviariaVO rodoviaria =  new RodoviariaVO();
		if(next()){
			rodoviaria.setSeqRodoviaria(new Integer(rowSet.getString("seq_Rodoviaria")));
			rodoviaria.getEnderecoVO().setSeqEndereco(new Integer(rowSet.getString("seq_Endereco")));
			rodoviaria.setNomRodoviaria(rowSet.getString("nom_Rodoviaria"));
			rodoviaria.getEnderecoVO().setLogradouro(rowSet.getString("logradouro"));
			rodoviaria.getEnderecoVO().setNumero(rowSet.getString("numero"));
			rodoviaria.getEnderecoVO().setComplemento(rowSet.getString("complemento"));
			rodoviaria.getEnderecoVO().setBairro(rowSet.getString("bairro"));
			rodoviaria.getEnderecoVO().setCidade(rowSet.getString("cidade"));
			rodoviaria.getEnderecoVO().setEstado(rowSet.getString("estado"));
		}
		return rodoviaria;
	} catch (Exception e) {
		logger.fatal("Erro ocorrido no metodo getOnibus em :: RodoviariaDAO", e);
		   throw new DAOException(e);
	}finally{
		release();	
	}
	
  }
	/*
	 * SQL-08
	 * */
	private String getListaRodoviariaSQL(RodoviariaVO rodoviariaVO){
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT r.seq_rodoviaria,                                       ");
		sql.append("        e.seq_endereco,                                         ");
		sql.append("        r.nom_rodoviaria,                                       ");
		sql.append("        e.logradouro,                                           ");
		sql.append("        e.numero,                                               ");
		sql.append("        e.complemento,                                          ");
		sql.append("        e.bairro,                                               ");
		sql.append("        e.cidade,                                               ");
		sql.append("        e.estado                                                ");
		sql.append("  FROM endereco e,                                              ");
		sql.append("       rodoviaria r                                             ");
		sql.append("  WHERE r.seq_endereco_fk = e.seq_endereco                      ");
		sql.append("   AND r.seq_rodoviaria = "+ rodoviariaVO.getSeqRodoviaria()     );
		              //filtro por nome da rodoviaria                                            
		sql.append("   AND r.nom_rodoviaria like upper('%"+rodoviariaVO.getNomRodoviaria()+"%')  ");
		              //filtro por cidade                                         
		sql.append("   AND e.cidade like upper('%"+rodoviariaVO.getNomRodoviaria()+"%')          ");
		              //filtro por estado                                         
		sql.append("   AND e.estado like upper('%"+rodoviariaVO.getNomRodoviaria()+"%')          ");
		
		return sql.toString();
	}
	public List<RodoviariaVO> getListaRodoviaria(RodoviariaVO rodoviariaVO)throws DAOException{
		try {
			pstmt = getPstmt(getListaRodoviariaSQL(rodoviariaVO));
			rowSet = executeQuery(pstmt); 
			List<RodoviariaVO> listaRodoviaria = new ArrayList<RodoviariaVO>();
			while(next()){
				RodoviariaVO rodoviaria = new RodoviariaVO();
				rodoviaria.setSeqRodoviaria(new Integer(rowSet.getString("seq_rodoviaria")));
				rodoviaria.getEnderecoVO().setSeqEndereco(new Integer(rowSet.getString("seq_endereco")));
				rodoviaria.getEnderecoVO().setLogradouro(rowSet.getString("logradouro"));
				rodoviaria.getEnderecoVO().setNumero(rowSet.getString("numero"));
				rodoviaria.getEnderecoVO().setComplemento(rowSet.getString("complemento"));
				rodoviaria.getEnderecoVO().setBairro(rowSet.getString("bairro"));
				rodoviaria.getEnderecoVO().setCidade(rowSet.getString("cidade"));
				rodoviaria.getEnderecoVO().setEstado(rowSet.getString("estado"));
			   listaRodoviaria.add(rodoviaria);
			}
			return listaRodoviaria;
			
		} catch (Exception e) {
			logger.fatal("Erro ocorrido no metodo getListaRodoviaria em :: RodoviariaDAO", e);
			   throw new DAOException(e);
		}finally{
			release();
		}
		
	}
}
