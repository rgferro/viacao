package com.viacao.interfaces;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBObject;

import com.viacao.vo.ItinerarioVo;
import com.viacao.vo.OnibusVO;
import com.viacao.vo.TarifaVO;
import com.viacao.vo.ViagemVO;

public interface ManterCadastro extends EJBObject {
	
	public void inserir(TarifaVO tarifaVO) throws RemoteException;	
	public void deletar(TarifaVO tarifaVO) throws RemoteException;	
	public void alterar(TarifaVO tarifaVO) throws RemoteException;	
	public List<TarifaVO> getListaTarifa(TarifaVO tarifaVO) throws RemoteException;	
	public TarifaVO getTarifa(TarifaVO tarifaVO) throws RemoteException;
	
	public void inserir(OnibusVO onibusVO) throws RemoteException;	
	public void deletar(OnibusVO onibusVO) throws RemoteException;	
	public void alterar(OnibusVO onibusVO) throws RemoteException;	
	public List<OnibusVO> getListaOnibus(OnibusVO onibusVO) throws RemoteException;	
	public OnibusVO getOnibus(OnibusVO onibusVO) throws RemoteException;	
	
	public void inserirItinerario (ItinerarioVo itinerarioVo) throws RemoteException;
	public void deletarItinerario(ItinerarioVo itinerarioVo) throws RemoteException;	
	public void alterarItinerario(ItinerarioVo itinerarioVo) throws RemoteException;
	public ItinerarioVo getItinerario(ItinerarioVo itinerarioVo) throws RemoteException;
	public List<ItinerarioVo> listaItinerario(ItinerarioVo itinerarioVo) throws RemoteException;
	
	public void inserir(ViagemVO viagemVO) throws RemoteException;	
	public void deletar(ViagemVO viagemVO) throws RemoteException;	
	public void alterar(ViagemVO viagemVO) throws RemoteException;	
	public ViagemVO getViagem(ViagemVO viagemVO) throws RemoteException;
	public List<ViagemVO> getListaViagem(ViagemVO viagemVO) throws RemoteException;	;		

}