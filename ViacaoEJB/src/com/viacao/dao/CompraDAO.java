package com.viacao.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.acol.exception.DAOException;
import com.viacao.services.persistence.BaseDB;
import com.viacao.vo.DataVO;
import com.viacao.vo.ItinerarioVo;
import com.viacao.vo.OnibusVO;
import com.viacao.vo.RodoviariaVO;
import com.viacao.vo.ViagemVO;

public class CompraDAO extends BaseDB {
	private Logger logger = Logger.getLogger(this.getClass());
	
	public CompraDAO() throws DAOException{
		super();
	}
	
	public String getSQLListaViagensCompraIda(ViagemVO viagemVO){
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT vg.seq_viagem, ");
		sql.append("		(SELECT      r.nom_rodoviaria ");
		sql.append("			FROM  	 rodoviaria r ");
		sql.append("			WHERE 	 r.seq_rodoviaria = it.seq_rodoviaria_origem_fk) origem, ");
		sql.append("		(SELECT      r.nom_rodoviaria ");
		sql.append("			FROM   	 rodoviaria r ");
		sql.append("			WHERE  	 r.seq_rodoviaria = it.seq_rodoviaria_destino_fk) destino,");
		sql.append("		o.tipo, ");
		sql.append("		o.empresa, ");
		sql.append("		o.qtd_poltrona, ");
		sql.append("		it.valor_passagem, ");
		sql.append("		to_char(vg.data_hora_saida, 'DD/MM/YYYY') data_saida, ");
		sql.append("		to_char(vg.data_hora_saida, 'HH24:MI:SS') hora_saida, ");
		sql.append("		to_char(vg.data_hora_chegada, 'DD/MM/YYYY') data_chegada, ");
		sql.append("		to_char(vg.data_hora_chegada, 'HH24:MI:SS') hora_chegada ");
		sql.append(" FROM   itinerario it, viagem vg, onibus o ");
		sql.append(" WHERE 	it.seq_itinerario = vg.seq_itinerario_fk (+) ");
		sql.append(" AND 	o.seq_onibus = vg.seq_onibus_fk ");
		sql.append(" AND    to_char(vg.data_hora_saida, 'DD/MM/YYYY') = '"+ viagemVO.getHoraSaida() +"' ");
		sql.append(" AND    (SELECT		r.nom_rodoviaria ");
		sql.append("			FROM  	rodoviaria r ");
		sql.append("			WHERE 	r.seq_rodoviaria = it.seq_rodoviaria_origem_fk) ");
		sql.append("		 LIKE upper('%"+ viagemVO.getItinerarioVo().getRodoviariaOrigemVO().getNomRodoviaria() +"%') ");

		return sql.toString();
	}
	
	public List<ViagemVO> getListaViagensCompraIda(ViagemVO viagemVO)throws Exception, DAOException {
		try {
			pstmt = getPstmt(getSQLListaViagensCompraIda(viagemVO));
			
			rowSet = executeQuery(pstmt);
			
			List<ViagemVO> lista = new ArrayList<ViagemVO>();
			
			while(next()){
				ViagemVO viagem = new ViagemVO();
				viagem.setSeqViagem(new Integer(rowSet.getInt("seq_viagem")));
				viagem.setItinerarioVo(new ItinerarioVo());
				viagem.getItinerarioVo().setRodoviariaOrigemVO(new RodoviariaVO());
				viagem.getItinerarioVo().setRodoviariaDestinoVO(new RodoviariaVO());
				viagem.getItinerarioVo().getRodoviariaOrigemVO().setNomRodoviaria(rowSet.getString("origem"));
				viagem.getItinerarioVo().getRodoviariaDestinoVO().setNomRodoviaria(rowSet.getString("destino"));
				viagem.setOnibusVO(new OnibusVO());
				viagem.getOnibusVO().setTipo(rowSet.getString("tipo"));
				viagem.getOnibusVO().setEmpresa(rowSet.getString("empresa"));
				viagem.getOnibusVO().setQtdPoltronas(new Integer(rowSet.getInt("qtd_poltrona")));
				viagem.getItinerarioVo().setValorPassagem(new Double(rowSet.getString("valor_passagem")));
				viagem.setHoraSaida(new DataVO(rowSet.getString("data_saida")));
				viagem.getHoraSaida().setHoraMinutoSegundo(rowSet.getString("hora_saida"));
				viagem.setHoraChegada(new DataVO(rowSet.getString("data_chegada")));
				viagem.getHoraChegada().setHoraMinutoSegundo(rowSet.getString("hora_chegada"));
				lista.add(viagem);
			}
			return lista;
		} catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo listaViagensCompraIda em :: CompraDAO");
			throw new DAOException(e);
		}finally{
			release();
		}
	}
	
	public String getSQLListaViagensCompraVolta(ViagemVO viagemVO){
		StringBuffer sql = new StringBuffer();
		
		sql.append(" SELECT vg.seq_viagem, ");
		sql.append("		(SELECT      r.nom_rodoviaria ");
		sql.append("			FROM  	 rodoviaria r ");
		sql.append("			WHERE 	 r.seq_rodoviaria = it.seq_rodoviaria_origem_fk) origem, ");
		sql.append("		(SELECT      r.nom_rodoviaria ");
		sql.append("			FROM   	 rodoviaria r ");
		sql.append("			WHERE  	 r.seq_rodoviaria = it.seq_rodoviaria_destino_fk) destino,");
		sql.append("		o.tipo, ");
		sql.append("		o.empresa, ");
		sql.append("		o.qtd_poltrona, ");
		sql.append("		it.valor_passagem, ");
		sql.append("		to_char(vg.data_hora_saida, 'DD/MM/YYYY') data_saida, ");
		sql.append("		to_char(vg.data_hora_saida, 'HH24:MI:SS') hora_saida, ");
		sql.append("		to_char(vg.data_hora_chegada, 'DD/MM/YYYY') data_chegada, ");
		sql.append("		to_char(vg.data_hora_chegada, 'HH24:MI:SS') hora_chegada ");
		sql.append(" FROM   itinerario it, viagem vg, onibus o ");
		sql.append(" WHERE 	it.seq_itinerario = vg.seq_itinerario_fk (+) ");
		sql.append(" AND 	o.seq_onibus = vg.seq_onibus_fk ");
		sql.append(" AND    to_char(vg.data_hora_saida, 'DD/MM/YYYY') = '"+ viagemVO.getHoraChegada() +"' ");
		sql.append(" AND    (SELECT		r.nom_rodoviaria ");
		sql.append("			FROM  	rodoviaria r ");
		sql.append("			WHERE 	r.seq_rodoviaria = it.seq_rodoviaria_origem_fk) ");
		sql.append("		 LIKE upper('%"+ viagemVO.getItinerarioVo().getRodoviariaDestinoVO().getNomRodoviaria() +"%') ");
		
		return sql.toString();
	}
	
	public List<ViagemVO> getListaViagensCompraVolta(ViagemVO viagemVO)throws Exception, DAOException {
		try {
			pstmt = getPstmt(getSQLListaViagensCompraVolta(viagemVO));
			
			rowSet = executeQuery(pstmt);
			
			List<ViagemVO> lista = new ArrayList<ViagemVO>();
			
			while(next()){
				ViagemVO viagem = new ViagemVO();
				viagem.setSeqViagem(new Integer(rowSet.getInt("seq_viagem")));
				viagem.setItinerarioVo(new ItinerarioVo());
				viagem.getItinerarioVo().setRodoviariaOrigemVO(new RodoviariaVO());
				viagem.getItinerarioVo().setRodoviariaDestinoVO(new RodoviariaVO());
				viagem.getItinerarioVo().getRodoviariaOrigemVO().setNomRodoviaria(rowSet.getString("origem"));
				viagem.getItinerarioVo().getRodoviariaDestinoVO().setNomRodoviaria(rowSet.getString("destino"));
				viagem.setOnibusVO(new OnibusVO());
				viagem.getOnibusVO().setTipo(rowSet.getString("tipo"));
				viagem.getOnibusVO().setEmpresa(rowSet.getString("empresa"));
				viagem.getOnibusVO().setQtdPoltronas(new Integer(rowSet.getInt("qtd_poltrona")));
				viagem.getItinerarioVo().setValorPassagem(new Double(rowSet.getString("valor_passagem")));
				viagem.setHoraSaida(new DataVO(rowSet.getString("data_saida")));
				viagem.getHoraSaida().setHoraMinutoSegundo(rowSet.getString("hora_saida"));
				viagem.setHoraChegada(new DataVO(rowSet.getString("data_chegada")));
				viagem.getHoraChegada().setHoraMinutoSegundo(rowSet.getString("hora_chegada"));
				lista.add(viagem);
			}
			return lista;
		} catch (SQLException e) {
			logger.fatal("Erro ocorrido no metodo listaViagensCompraVolta em :: CompraDAO");
			throw new DAOException(e);
		}finally{
			release();
		}
	}
}
