package com.viacao.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.acol.exception.DAOException;
import com.viacao.services.persistence.BaseDB;
import com.viacao.vo.OnibusVO;

public class OnibusDAO extends BaseDB {
	private Logger logger = Logger.getLogger(this.getClass());

	public OnibusDAO() throws DAOException {
		super();
	}
	
	/**
	 * SQLInserir
	 * @return String
	 */
	private String getSQLInserir(){
		StringBuffer sql = new StringBuffer();
		
		sql.append("INSERT INTO onibus (");
		sql.append("					seq_onibus, ");
		sql.append("					tipo, ");
		sql.append("					empresa, ");
		sql.append("					placa, ");		
		sql.append("					qtd_poltrona) ");
		sql.append("VALUES (seq_onibus.nextval, upper(?), upper(?),upper(?), ?)");
		
		return sql.toString();
	}
	
	/**
	 * Insere um novo ônibus no banco
	 * @param onibusVO
	 * @throws DAOException
	 */
	public void inserir(OnibusVO onibusVO) throws DAOException{
		try {
			pstmt = getPstmt(getSQLInserir());
			pstmt.setString(1, onibusVO.getTipo());
			pstmt.setString(2, onibusVO.getEmpresa());
			pstmt.setString(3, onibusVO.getPlaca());
			pstmt.setInt(4, onibusVO.getQtdPoltrona().intValue());
			
			pstmt.executeUpdate();
		} catch(SQLException e) {
			logger.fatal("Erro ocorrido no metodo inserir em :: OnibusDAO", e);
			throw new DAOException(e);
		} finally {
			release();
		}
	}
	
	/**
	 * Deleta um ônibus do banco
	 * @param onibusVO
	 * @throws DAOException
	 */
	public void deletar(OnibusVO onibusVO) throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append("DELETE onibus WHERE seq_onibus = ?");
		
		try{
			pstmt = getPstmt(sql.toString());
			pstmt.setInt(1, onibusVO.getSeqOnibus().intValue());
			
			pstmt.executeUpdate();
		}catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo deletar em :: OnibusDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
	}
	
	/**
	 * SQLAlterar
	 * @return String
	 */
	private String getSQLAlterar(){
		StringBuffer sql = new StringBuffer();
		
		sql.append("UPDATE onibus ");
		sql.append("SET tipo = upper(?), ");
		sql.append("	empresa = upper(?), ");
		sql.append("	placa = upper(?), ");
		sql.append("	qtd_poltrona = upper(?) ");		
		sql.append("WHERE seq_onibus = ?");
		
		return sql.toString();
	}
	
	/**
	 * Altera um ônibus do banco
	 * @param onibusVO
	 * @throws DAOException
	 */
	public void alterar(OnibusVO onibusVO) throws DAOException{		
		try{
			pstmt = getPstmt(getSQLAlterar());
			pstmt.setString(1, onibusVO.getTipo());
			pstmt.setString(2, onibusVO.getEmpresa());
			pstmt.setString(3, onibusVO.getPlaca());
			pstmt.setInt(4, onibusVO.getQtdPoltrona().intValue());
			pstmt.setInt(5, onibusVO.getSeqOnibus().intValue());
			
			pstmt.executeUpdate();
		}catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo alterar em :: OnibusDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
	}
	
	/**
	 * Recupera um ônibus do banco
	 * @param onibusVO
	 * @throws DAOException
	 */
	public OnibusVO getOnibus(OnibusVO onibusVO) throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT 	seq_onibus, tipo, empresa, placa, qtd_poltrona FROM onibus WHERE seq_onibus = ?");
		
		try{
			pstmt = getPstmt(sql.toString());
			pstmt.setInt(1, onibusVO.getSeqOnibus().intValue());
			
			rowSet = executeQuery(pstmt);
			if(rowSet.next()){
				OnibusVO oniVO = new OnibusVO();
				oniVO.setTipo(rowSet.getString("tipo"));
				oniVO.setEmpresa(rowSet.getString("empresa"));
				oniVO.setPlaca(rowSet.getString("placa"));
				oniVO.setQtdPoltrona(new Integer(rowSet.getInt("qtd_poltrona")));
				
				return oniVO;
			}
		}catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo getOnibus em :: OnibusDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
		return null;
	}
	
	/**
	 * SQLListarOnibus
	 * @param OnibusVO
	 * @return String
	 */
	private String getSQLListarOnibus(OnibusVO oniVO){
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT seq_onibus, tipo, empresa, placa, qtd_poltrona ");
		sql.append("FROM onibus ");
		sql.append("WHERE 1=1 ");
		//--filtro tipo
		sql.append("AND tipo like upper('%<param_tipo>%') ");
		//--filtro empresa
		sql.append("AND empresa like upper('%<param_empresa>%') ");		
		//--filtro placa
		sql.append("AND placa like upper('%<param_placa>%') ");
		//--filtro quantidade de poltrona
		sql.append("AND qtd_poltrona = <param_qtd_poltrona>");
		
		return sql.toString();
	}
	
	/**
	 * Recupera uma lista de ônibus do banco
	 * @param onibusVO
	 * @throws DAOException
	 */
	public List<OnibusVO> getListaOnibus(OnibusVO onibusVO) throws DAOException{
		try{
			pstmt = getPstmt(getSQLListarOnibus(onibusVO));
			
			rowSet = executeQuery(pstmt);
			List<OnibusVO> listaOnibus = new ArrayList<OnibusVO>();
			while(rowSet.next()){
				OnibusVO oniVO = new OnibusVO();
				oniVO.setSeqOnibus(new Integer(rowSet.getInt("qtd_poltrona")));
				oniVO.setTipo(rowSet.getString("tipo"));
				oniVO.setEmpresa(rowSet.getString("empresa"));
				oniVO.setPlaca(rowSet.getString("placa"));
				oniVO.setQtdPoltrona(new Integer(rowSet.getInt("qtd_poltrona")));
				
				listaOnibus.add(oniVO);
				
				return listaOnibus;
			}
		}catch(SQLException e){
			logger.fatal("Erro ocorrido no metodo getListaOnibus em :: OnibusDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
		return null;
	}

}
