/**
 * 
 */
package com.viacao.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.acol.exception.DAOException;
import com.viacao.services.persistence.BaseDB;
import com.viacao.vo.ItinerarioVo;

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
		
		sql.append(" INSERT INTO itinerario ( \n");
		sql.append(" seq_itinerario,  \n");
		sql.append(" seq_rodoviaria_origem_fk,  \n");
		sql.append(" seq_rodoviaria_destino_fk,  \n");
		sql.append(" tempo_viagem, valor_passagem)  \n");
		sql.append(" VALUES ( \n");
		sql.append(" seq_itinerario.nextval,  \n");
		sql.append(" ?,  \n");
		sql.append(" ?,  \n");
		sql.append(" to_date( ?, 'HH24:MI:SS'),  \n");
		sql.append(" ?) \n");
		
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
			pstmt.setString(3, itinerarioVo.getTempoViagem().getHoraMinutoSegundo());
			pstmt.setDouble(4, itinerarioVo.getValorPassagem());
			pstmt.executeQuery();
			
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
			pstmt.executeQuery();
			
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
		sql.append("         tempo_viagem = to_date('?', 'HH24:MI:SS'), \n");
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
			pstmt.setString(3, itinerarioVo.getTempoViagem().getData());
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
	private String getSQLItinerario(){
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select  it.seq_itinerario_tarifa, \n");
		sql.append("         i.seq_itinerario,  \n");
		sql.append("         t.seq_tarifa,  \n");
		sql.append("         (select r.nom_rodoviaria from rodoviaria r where r.seq_rodoviaria = i.seq_rodoviaria_origem_fk) origem, \n");
		sql.append("         (select r.nom_rodoviaria from rodoviaria r where r.seq_rodoviaria = i.seq_rodoviaria_destino_fk) destino, \n");
		sql.append("         i.tempo_viagem,  \n");
		sql.append("         i.valor_passagem,  \n");
		sql.append("         t.nom_tarifa,  \n");
		sql.append("         t.valor_tarifa \n");
		sql.append(" from itinerario i, tarifa t, itinerario_tarifa it  \n");
		sql.append(" where i.seq_itinerario = it.seq_itinerario_fk (+)  \n");
		sql.append(" and it.seq_tarifa_fk  = t.seq_tarifa (+) \n");
		sql.append(" and i.seq_itinerario = ? \n");
		
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
			pstmt = getPstmt(getSQLItinerario());
			pstmt.setInt(1, itinerarioVo.getSeqItinerario().intValue());			
			rowSet = executeQuery(pstmt);
			
			if(rowSet.next()){
				ItinerarioVo inVo = new ItinerarioVo();
				inVo.setSeqItinerario(new Integer(rowSet.getInt("seq_itinerario")));
				
				return inVo;
			}
			
		}catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo getItinerario em :: ItinerarioDAO", e);
			throw new DAOException(e);
		}finally{
			release();
		}
		return null;
	}
	
	private String getSQLListaItinerario(){
		StringBuffer sql = new StringBuffer();
		
		sql.append(" select  it.seq_itinerario_tarifa, \n");
		sql.append("         i.seq_itinerario, \n");
		sql.append("         t.seq_tarifa, \n");
		sql.append("         (select r.nom_rodoviaria from rodoviaria r where r.seq_rodoviaria = i.seq_rodoviaria_origem_fk) origem, \n");
		sql.append("         (select r.nom_rodoviaria from rodoviaria r where r.seq_rodoviaria = i.seq_rodoviaria_destino_fk) destino, \n");
		sql.append("         i.tempo_viagem, \n");
		sql.append("         i.valor_passagem, \n");
		sql.append("         t.nom_tarifa, \n");
		sql.append("         t.valor_tarifa\n");
		sql.append(" from itinerario i, tarifa t, itinerario_tarifa it \n");
		sql.append(" where i.seq_itinerario = it.seq_itinerario_fk (+) \n");
		sql.append(" and it.seq_tarifa_fk  = t.seq_tarifa (+)\n");
		// filtro por origem da viagem
		sql.append(" and (select r.nom_rodoviaria from rodoviaria r where r.seq_rodoviaria = i.seq_rodoviaria_origem_fk) like upper(?)\n");
		// filtro por destino da viagem
		sql.append(" and (select r.nom_rodoviaria from rodoviaria r where r.seq_rodoviaria = i.seq_rodoviaria_destino_fk) like upper(?)\n");
		// filtro por tempo da viagem\n");
		sql.append(" and to_char(i.tempo_viagem, 'HH24:MI:SS') = ?\n");
		// filtro por valor da passagem da viagem
		sql.append(" and i.valor_passagem = ? \n");
		
		return sql.toString();
	}
	
	public List<ItinerarioVo> listaItinerario (ItinerarioVo itinerarioVo)throws DAOException{
		try{
			pstmt = getPstmt(getSQLListaItinerario());
			
			rowSet = executeQuery(pstmt);
			List<ItinerarioVo> lista = new ArrayList<ItinerarioVo>();
			
			while(rowSet.next()){
				ItinerarioVo itinerario = new ItinerarioVo();
				itinerario.setSeqItinerario(new Integer(rowSet.getInt("seq_itinerario")));
				itinerario.getRodoviariaOrigemVO().setSeqRodoviaria(new Integer(rowSet.getInt("seq_rodoviaria_origem")));
				itinerario.getRodoviariaDestinoVO().setSeqRodoviaria(new Integer(rowSet.getInt("seq_rodoviaria_destino")));
				
				lista.add(itinerario);
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
