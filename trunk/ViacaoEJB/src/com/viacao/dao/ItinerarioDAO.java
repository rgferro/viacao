/**
 * 
 */
package com.viacao.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import sun.jdbc.rowset.CachedRowSet;

import com.acol.exception.DAOException;
import com.acol.util.DoubleUtils;
import com.acol.util.IntegerUtils;
import com.acol.util.StringUtil;
import com.viacao.services.persistence.BaseDB;
import com.viacao.vo.ItinerarioVo;
import com.viacao.vo.RodoviariaVO;
import com.viacao.vo.TarifaVO;

/**
 * @author Wallace Gonçalves  
 */
public class ItinerarioDAO extends BaseDB{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	public ItinerarioDAO()throws DAOException{
		super();
	}
	
	/**
	 * SQLInserir
	 * @return sql
	 */
	private String getSQLInserir(){
		StringBuffer sql = new StringBuffer();
		
		sql.append(" INSERT INTO itinerario ( 		\n");
		sql.append(" seq_itinerario,  				\n");
		sql.append(" seq_rodoviaria_origem_fk, 		\n");
		sql.append(" seq_rodoviaria_destino_fk,  	\n");
		sql.append(" tempo_viagem,  				\n");
		sql.append(" valor_passagem)  				\n");
		sql.append(" VALUES (seq_itinerario.nextval, ?, ?,?,?) \n");
		
		return sql.toString();
	}
	
	/**
	 * Insere um itinerario no banco
	 * @param itinerarioVo
	 * @throws DAOException
	 */
	public void inserir(ItinerarioVo itinerarioVo)throws DAOException{
		
		try {
			pstmt = getPstmt(getSQLInserir());
			pstmt.setInt(1, itinerarioVo.getRodoviariaOrigemVO().getSeqRodoviaria());
			pstmt.setInt(2, itinerarioVo.getRodoviariaDestinoVO().getSeqRodoviaria());
			pstmt.setString(3, itinerarioVo.getTempoViagem());
			pstmt.setDouble(4, itinerarioVo.getValorPassagem());
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			logger.fatal("Erro ocorrido no metodo inserir em :: ItinerarioDAO", e);
			throw new DAOException(e);
		} finally {
			release();
		}	
	}
	
	/**
	 * Exlui um itinerario do banco.
	 * @param itinerarioVo
	 * @throws DAOException
	 */
	public void excluir(ItinerarioVo itinerarioVo)throws DAOException{
		StringBuffer sql = new StringBuffer();
		
		sql.append("DELETE itinerario i WHERE i.seq_itinerario = ?");
		
		try{
			pstmt = getPstmt(sql.toString());
			pstmt.setInt(1, itinerarioVo.getSeqItinerario().intValue());
			pstmt.executeUpdate();
		}catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo excluir em :: ItinerarioDAO", e);
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
		
		sql.append(" UPDATE  itinerario SET 		\n");
		sql.append(" 	 	 seq_rodoviaria_origem_fk = ?, \n");
		sql.append("         seq_rodoviaria_destino_fk = ?, \n");
		sql.append("         tempo_viagem = ?, \n");
		sql.append("         valor_passagem = ? \n");
		sql.append("  WHERE  seq_itinerario = ? \n");
		
		return sql.toString();
	}
	
	/**
	 * alterar um itinerario.
	 * @param itinerarioVo
	 * @throws DAOException
	 */
	public void alterar(ItinerarioVo itinerarioVo)throws DAOException{
		try{
			pstmt = getPstmt(getSQLAlterar());
			pstmt.setInt(1, itinerarioVo.getRodoviariaOrigemVO().getSeqRodoviaria());
			pstmt.setInt(2, itinerarioVo.getRodoviariaDestinoVO().getSeqRodoviaria());
			pstmt.setString(3, itinerarioVo.getTempoViagem());
			pstmt.setDouble(4, itinerarioVo.getValorPassagem());
			pstmt.setInt(5, itinerarioVo.getSeqItinerario());
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo alterar em :: ItinerarioDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
	}
	
	/**
	 * SQLItinerario
	 * @return String
	 */
	private String getSQLItinerario(ItinerarioVo itinerarioVo){
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select  i.seq_itinerario,  \n");
		sql.append("         t.seq_tarifa,  \n");
		sql.append("         i.seq_rodoviaria_origem_fk,  \n");
		sql.append("         i.seq_rodoviaria_destino_fk,  \n");
		sql.append("         (select r.nom_rodoviaria from rodoviaria r where r.seq_rodoviaria = i.seq_rodoviaria_origem_fk) origem, \n");
		sql.append("         (select r.nom_rodoviaria from rodoviaria r where r.seq_rodoviaria = i.seq_rodoviaria_destino_fk) destino, \n");
		sql.append("         i.tempo_viagem,  \n");
		sql.append("         i.valor_passagem,  \n");
		sql.append("         t.nom_tarifa,  \n");
		sql.append("         t.valor_tarifa \n");
		sql.append(" from itinerario i, tarifa t, itinerario_tarifa it  \n");
		sql.append(" where i.seq_itinerario = it.seq_itinerario_fk (+)  \n");
		sql.append(" and it.seq_tarifa_fk  = t.seq_tarifa (+) \n");
		
		//filtro por seq itinerario
		if(!IntegerUtils.empty(itinerarioVo.getSeqItinerario())){
			sql.append(" and i.seq_itinerario = "+itinerarioVo.getSeqItinerario().intValue()+"\n");
		}
		
		// filtro por origem da viagem
		if(!StringUtil.empty(itinerarioVo.getRodoviariaOrigemVO().getNomRodoviaria())){
			sql.append(" and (SELECT r.nom_rodoviaria " +
					"		  FROM rodoviaria r " +
					"		  WHERE r.seq_rodoviaria = i.seq_rodoviaria_origem_fk) " +
					"		  LIKE upper('%"+itinerarioVo.getRodoviariaOrigemVO().getNomRodoviaria()+"%')		\n");
		}
		// filtro por destino da viagem
		if(!StringUtil.empty(itinerarioVo.getRodoviariaDestinoVO().getNomRodoviaria())){
			sql.append(" and (SELECT r.nom_rodoviaria " +
					"		  FROM rodoviaria r " +
					"		  WHERE r.seq_rodoviaria = i.seq_rodoviaria_destino_fk) " +
					"		  LIKE upper('%"+itinerarioVo.getRodoviariaDestinoVO().getNomRodoviaria()+"%')		\n");
		}
		// filtro por tempo da viagem
		if(!StringUtil.empty(itinerarioVo.getTempoViagem())){
			sql.append(" and i.tempo_viagem = '"+itinerarioVo.getTempoViagem()+"'	\n");
		}
		// filtro por valor da passagem da viagem
		if(!DoubleUtils.empty(itinerarioVo.getValorPassagem())){
			sql.append(" and i.valor_passagem = "+itinerarioVo.getValorPassagem());
		}
		
		return sql.toString();
	}
	
	/**
	 * Recupera um Itinerario cadastrado no banco.
	 * @param itinerarioVo
	 * @return
	 * @throws DAOException
	 */
	public ItinerarioVo getItinerario(ItinerarioVo itinerarioVo)throws DAOException{
		try{
			pstmt = getPstmt(getSQLItinerario(itinerarioVo));
			rowSet = executeQuery(pstmt);
			
			ItinerarioVo inVo = new ItinerarioVo();
			inVo.setListaTarifas(new ArrayList<TarifaVO>());
			inVo.setRodoviariaDestinoVO(new RodoviariaVO());
			inVo.setRodoviariaOrigemVO(new RodoviariaVO());
			
			while(rowSet.next()){
				if(inVo.getSeqItinerario() == null){
					inVo.setSeqItinerario(new Integer(rowSet.getInt("seq_itinerario")));
					inVo.getRodoviariaOrigemVO().setNomRodoviaria(rowSet.getString("origem"));
					inVo.getRodoviariaOrigemVO().setSeqRodoviaria(Integer.valueOf(rowSet.getString("seq_rodoviaria_origem_fk")));
					inVo.getRodoviariaDestinoVO().setNomRodoviaria(rowSet.getString("destino"));
					inVo.getRodoviariaDestinoVO().setSeqRodoviaria(Integer.valueOf(rowSet.getString("seq_rodoviaria_destino_fk")));
					inVo.setTempoViagem(rowSet.getString("tempo_viagem"));
					inVo.setValorPassagem(Double.valueOf(rowSet.getString("valor_passagem")));
				}
				if(!StringUtil.empty(rowSet.getString("nom_tarifa"))){
					TarifaVO tarifaVO = new TarifaVO();
					tarifaVO.setNomTarifa(rowSet.getString("nom_tarifa"));
					tarifaVO.setSeqTarifa(Integer.valueOf(rowSet.getString("seq_tarifa")));
					tarifaVO.setValor(Double.valueOf(rowSet.getString("valor_tarifa")));
					inVo.getListaTarifas().add(tarifaVO);
				}
			}
			return inVo;
		}catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo getItinerario em :: ItinerarioDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
	}
	
	private String getSQLListaItinerario(ItinerarioVo itinerarioVo){
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select  i.seq_itinerario,  \n");
		sql.append("         t.seq_tarifa,  \n");
		sql.append("         i.seq_rodoviaria_origem_fk,  \n");
		sql.append("         i.seq_rodoviaria_destino_fk,  \n");
		sql.append("         (select r.nom_rodoviaria from rodoviaria r where r.seq_rodoviaria = i.seq_rodoviaria_origem_fk) origem, \n");
		sql.append("         (select r.nom_rodoviaria from rodoviaria r where r.seq_rodoviaria = i.seq_rodoviaria_destino_fk) destino, \n");
		sql.append("         i.tempo_viagem,  \n");
		sql.append("         i.valor_passagem,  \n");
		sql.append("         t.nom_tarifa,  \n");
		sql.append("         t.valor_tarifa \n");
		sql.append(" from itinerario i, tarifa t, itinerario_tarifa it  \n");
		sql.append(" where i.seq_itinerario = it.seq_itinerario_fk (+)  \n");
		sql.append(" and it.seq_tarifa_fk  = t.seq_tarifa (+) \n");
		
		// filtro por origem da viagem
		if(!StringUtil.empty(itinerarioVo.getRodoviariaOrigemVO().getNomRodoviaria())){
			sql.append(" and (SELECT r.nom_rodoviaria " +
					"		  FROM rodoviaria r " +
					"		  WHERE r.seq_rodoviaria = i.seq_rodoviaria_origem_fk) " +
					"		  LIKE upper('%"+itinerarioVo.getRodoviariaOrigemVO().getNomRodoviaria()+"%')		\n");
		}
		// filtro por destino da viagem
		if(!StringUtil.empty(itinerarioVo.getRodoviariaDestinoVO().getNomRodoviaria())){
			sql.append(" and (SELECT r.nom_rodoviaria " +
					"		  FROM rodoviaria r " +
					"		  WHERE r.seq_rodoviaria = i.seq_rodoviaria_destino_fk) " +
					"		  LIKE upper('%"+itinerarioVo.getRodoviariaDestinoVO().getNomRodoviaria()+"%')		\n");
		}
		// filtro por tempo da viagem
		if(!StringUtil.empty(itinerarioVo.getTempoViagem())){
			sql.append(" and i.tempo_viagem like '%"+itinerarioVo.getTempoViagem()+"%'	\n");
		}
		// filtro por valor da passagem da viagem
		if(!DoubleUtils.empty(itinerarioVo.getValorPassagem())){
			sql.append(" and i.valor_passagem = "+itinerarioVo.getValorPassagem());
		}
		
		return sql.toString();
	}
	
	public List<ItinerarioVo> getListaItinerario (ItinerarioVo itinerarioVo)throws DAOException{
		try{
			pstmt = getPstmt(getSQLListaItinerario(itinerarioVo));
			
			rowSet = executeQuery(pstmt);
			
			List<ItinerarioVo> lista = new ArrayList<ItinerarioVo>();
			ItinerarioVo itinerario = new ItinerarioVo();
			
			Integer seqAnterior = 0;
			while(rowSet.next()){
				if(Integer.valueOf(rowSet.getInt("seq_itinerario")).intValue() != seqAnterior){
					itinerario = new ItinerarioVo();
					itinerario.setListaTarifas(new ArrayList<TarifaVO>());
					itinerario.setRodoviariaDestinoVO(new RodoviariaVO());
					itinerario.setRodoviariaOrigemVO(new RodoviariaVO());
					itinerario.setSeqItinerario(new Integer(rowSet.getInt("seq_itinerario")));
					itinerario.getRodoviariaOrigemVO().setNomRodoviaria(rowSet.getString("origem"));
					itinerario.getRodoviariaOrigemVO().setSeqRodoviaria(Integer.valueOf(rowSet.getString("seq_rodoviaria_origem_fk")));
					itinerario.getRodoviariaDestinoVO().setNomRodoviaria(rowSet.getString("destino"));
					itinerario.getRodoviariaDestinoVO().setSeqRodoviaria(Integer.valueOf(rowSet.getString("seq_rodoviaria_destino_fk")));
					itinerario.setTempoViagem(rowSet.getString("tempo_viagem"));
					itinerario.setValorPassagem(Double.valueOf(rowSet.getString("valor_passagem")));
					lista.add(itinerario);
				}
				if(!StringUtil.empty(rowSet.getString("nom_tarifa"))){
					TarifaVO tarifaVO = new TarifaVO();
					tarifaVO.setNomTarifa(rowSet.getString("nom_tarifa"));
					tarifaVO.setSeqTarifa(Integer.valueOf(rowSet.getString("seq_tarifa")));
					tarifaVO.setValor(Double.valueOf(rowSet.getString("valor_tarifa")));
					itinerario.getListaTarifas().add(tarifaVO);
				}
				seqAnterior = itinerario.getSeqItinerario();
			}
			return lista;
			
		}catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo listaItinerario em :: ItinerarioDAO");
			throw new DAOException(e);
		}finally{
			release();
		}
	}
	
}
