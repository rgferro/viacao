package com.viacao.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import sun.jdbc.rowset.CachedRowSet;

import com.acol.exception.DAOException;
import com.acol.util.StringUtil;
import com.viacao.services.persistence.BaseDB;
import com.viacao.vo.EnderecoVO;
import com.viacao.vo.RodoviariaVO;

public class RodoviariaDAO  extends BaseDB{
	
	private Logger logger = Logger.getLogger(this.getClass());
	public RodoviariaDAO() throws DAOException {
		super();
	
	}
	
	/*
	 *
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
		sql.append("    ?,                                  ");
		sql.append("    upper(?))    ");
		
		return sql.toString();
	}
	/*
	 * insere uma nova rodoviaria juntamente com o nome da rodoviaria,
	 * apos ter inserido o endereço na query SQL-01 que encontra-se na classe EnderecoDAO 
	 * (inserção controlada na classe ManterCadastroBean)
	 * SQL-04
	 * */
	public void inserir(RodoviariaVO rodoviariaVO)throws DAOException{
		try {
			pstmt = getPstmt(getInserirSQL());
			pstmt.setInt(1, rodoviariaVO.getEnderecoVO().getSeqEndereco());
			pstmt.setString(2, rodoviariaVO.getNomRodoviaria());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			logger.fatal("Erro ocorrido no metodo inserir em :: RodoviariaDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
	}
		
	/*
	 * SQL-06
	 * */
	private String getAlterarSQL(RodoviariaVO rodoviariaVO){
		
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE rodoviaria                                   					 					");
		sql.append("    SET 		                                      										");
		sql.append(" 	      nom_rodoviaria = upper('"+rodoviariaVO.getNomRodoviaria()+"')                  	");
		sql.append("   WHERE                                              										");
		sql.append("     seq_rodoviaria = "+rodoviariaVO.getSeqRodoviaria()                                      );
		
		return sql.toString();
	}
	/*
	 * altera o nome da rodoviaria apos ter alterado os enderecos na query SQL-02 
	 * localizado na classe EnderecoDAO (alteraçao controlada na classe ManterCadastroBean)
	 * SQL-06
	 * */
	public void alterar(RodoviariaVO rodoviariaVO)throws DAOException{
		try {
			pstmt = getPstmt(getAlterarSQL(rodoviariaVO));
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
	private String getRodoviariaSQL(){
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
	 * busca os dados de uma rodoviaria para ações de: consultar, alterar, deletar;
	 * referentes ao seq da rodoviaria selecionada 
	 * SQL-07
	 * */
	public RodoviariaVO getRodoviaria(RodoviariaVO rodoviariaVO)throws DAOException{
	try {
		pstmt = getPstmt(getRodoviariaSQL());
		pstmt.setInt(1, rodoviariaVO.getSeqRodoviaria());
		rowSet = executeQuery(pstmt);
		RodoviariaVO rodoviaria =  new RodoviariaVO();
		if(next()){
			rodoviaria.setSeqRodoviaria(new Integer(rowSet.getString("seq_Rodoviaria")));
			rodoviaria.setEnderecoVO(new EnderecoVO());
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
		sql.append(" SELECT r.seq_rodoviaria,                                       			 	");
		sql.append("        e.seq_endereco,                                         			 	");
		sql.append("        r.nom_rodoviaria,                                       			 	");
		sql.append("        e.logradouro,                                           			 	");
		sql.append("        e.numero,                                               			 	");
		sql.append("        e.complemento,                                          			 	");
		sql.append("        e.bairro,                                               			 	");
		sql.append("        e.cidade,                                               			 	");
		sql.append("        e.estado                                                			 	");
		sql.append("  FROM endereco e,                                              			 	");
		sql.append("       rodoviaria r                                                          	");
		sql.append("  WHERE r.seq_endereco_fk = e.seq_endereco                                   	");
		if(!StringUtil.empty(rodoviariaVO.getNomRodoviaria().trim())){
			 //filtro por nome da rodoviaria                                            
			sql.append("   AND r.nom_rodoviaria like upper('%"+rodoviariaVO.getNomRodoviaria().trim()+"%')  	");
		}
		if(!StringUtil.empty(rodoviariaVO.getEnderecoVO().getCidade())){			 
		              //filtro por cidade                                         
		sql.append("   AND e.cidade like upper('%"+rodoviariaVO.getEnderecoVO().getCidade().trim()+"%')          	");
		}
		if(!StringUtil.empty(rodoviariaVO.getEnderecoVO().getEstado())){
		              //filtro por estado                                         
		sql.append("   AND e.estado like upper('%"+rodoviariaVO.getEnderecoVO().getEstado().trim()+"%')          	");
		}
		return sql.toString();
	}
	/*
	 * Busca as rodoviarias de acordo com: 
	 * o nome da rodoviaria e/ou nome da cidade  e/ou nome do estado;
	 * ( buscas com nome aproximado) 
	 * SQL-08
	 * */
	public List<RodoviariaVO> getListaRodoviaria(RodoviariaVO rodoviariaVO)throws DAOException{
		try {
			pstmt = getPstmt(getListaRodoviariaSQL(rodoviariaVO));
			rowSet = executeQuery(pstmt); 
			List<RodoviariaVO> listaRodoviaria = new ArrayList<RodoviariaVO>();
			while(next()){
				RodoviariaVO rodoviaria = new RodoviariaVO();
				if(!StringUtil.empty(rodoviariaVO.getNomRodoviaria())){
					rodoviaria.setSeqRodoviaria(new Integer(rowSet.getString("seq_Rodoviaria")));
					rodoviaria.setNomRodoviaria(rowSet.getString("nom_rodoviaria"));
					
					rodoviaria.setEnderecoVO(new EnderecoVO());
					rodoviaria.getEnderecoVO().setCidade(rowSet.getString("cidade"));
					rodoviaria.getEnderecoVO().setEstado(rowSet.getString("estado"));
				}
				
				if(!StringUtil.empty(rodoviariaVO.getEnderecoVO().getCidade())){
					rodoviaria.setSeqRodoviaria(new Integer(rowSet.getString("seq_Rodoviaria")));
					rodoviaria.setNomRodoviaria(rowSet.getString("nom_rodoviaria"));
					
					rodoviaria.setEnderecoVO(new EnderecoVO());
					rodoviaria.getEnderecoVO().setCidade(rowSet.getString("cidade"));
					rodoviaria.getEnderecoVO().setEstado(rowSet.getString("estado"));		
				
				}
				if(!StringUtil.empty(rodoviariaVO.getEnderecoVO().getEstado())){
					rodoviaria.setSeqRodoviaria(new Integer(rowSet.getString("seq_Rodoviaria")));
					rodoviaria.setNomRodoviaria(rowSet.getString("nom_rodoviaria"));
					
					rodoviaria.setEnderecoVO(new EnderecoVO());
					rodoviaria.getEnderecoVO().setCidade(rowSet.getString("cidade"));
					rodoviaria.getEnderecoVO().setEstado(rowSet.getString("estado"));
				}
				if(StringUtil.empty(rodoviariaVO.getEnderecoVO().getEstado())&& StringUtil.empty(rodoviariaVO.getEnderecoVO().getCidade())&& StringUtil.empty(rodoviariaVO.getNomRodoviaria())){
					rodoviaria.setSeqRodoviaria(new Integer(rowSet.getString("seq_Rodoviaria")));
					rodoviaria.setNomRodoviaria(rowSet.getString("nom_rodoviaria"));
					
					rodoviaria.setEnderecoVO(new EnderecoVO());
					rodoviaria.getEnderecoVO().setCidade(rowSet.getString("cidade"));
					rodoviaria.getEnderecoVO().setEstado(rowSet.getString("estado"));
				}
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
		
	public String listaInicioRodoviariaSQL(RodoviariaVO rodoviariaVO){
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT 	r.seq_rodoviaria,                             ");
		sql.append(" 		    e.seq_endereco,                               ");
		sql.append(" 		    r.nom_rodoviaria,                             ");
		sql.append(" 	      	e.logradouro,                                 ");
		sql.append(" 		    e.numero,                                     ");
		sql.append(" 		    e.complemento,                                ");
		sql.append(" 		    e.bairro,                                     ");
		sql.append(" 		    e.cidade,                                     ");
		sql.append(" 	      	e.estado                                      ");
		sql.append(" FROM  		endereco e,                                   ");
		sql.append("          	rodoviaria r                                  ");
		sql.append(" WHERE                                               	  ");
		sql.append("        	r.seq_endereco_fk = e.seq_endereco            ");
	
		return sql.toString();
	} 
	
	/*
	 * busca todas as rodoviarias cadastradas
	 * SQL-07(modificada)
	 * */
	public List<RodoviariaVO> listaInicioRodoviaria(RodoviariaVO rodoviariaVO)throws DAOException{
		try {
			pstmt = getPstmt(listaInicioRodoviariaSQL(rodoviariaVO));
			rowSet = executeQuery(pstmt);
			List<RodoviariaVO> listaInicioRodoviaria = new ArrayList<RodoviariaVO>();
			while(next()){
				RodoviariaVO rodoviaria =  new RodoviariaVO();
				rodoviaria.setSeqRodoviaria(new Integer(rowSet.getString("seq_Rodoviaria")));
				rodoviaria.setEnderecoVO(new EnderecoVO());
				rodoviaria.getEnderecoVO().setSeqEndereco(new Integer(rowSet.getString("seq_Endereco")));
				rodoviaria.setNomRodoviaria(rowSet.getString("nom_Rodoviaria"));
				rodoviaria.getEnderecoVO().setLogradouro(rowSet.getString("logradouro"));
				rodoviaria.getEnderecoVO().setNumero(rowSet.getString("numero"));
				rodoviaria.getEnderecoVO().setComplemento(rowSet.getString("complemento"));
				rodoviaria.getEnderecoVO().setBairro(rowSet.getString("bairro"));
				rodoviaria.getEnderecoVO().setCidade(rowSet.getString("cidade"));
				rodoviaria.getEnderecoVO().setEstado(rowSet.getString("estado"));
			listaInicioRodoviaria.add(rodoviaria);
			}
			return listaInicioRodoviaria;
		} catch (Exception e) {
			logger.fatal("Erro ocorrido no metodo listaRodoviaria em :: RodoviariaDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
	}
}
