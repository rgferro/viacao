package com.viacao.interfaces;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBObject;

import com.acol.exception.business.ChildRecordFoundException;
import com.acol.exception.business.UniqueConstraintViolatedException;
import com.viacao.vo.ClienteVO;
import com.viacao.vo.EnderecoVO;
import com.viacao.vo.FisicaVO;
import com.viacao.vo.ItinerarioVo;
import com.viacao.vo.JuridicaVO;
import com.viacao.vo.OnibusVO;
import com.viacao.vo.RodoviariaVO;
import com.viacao.vo.TarifaVO;
import com.viacao.vo.ViagemVO;
public interface ManterCadastro extends EJBObject {
	
	public void inserir(TarifaVO tarifaVO) throws RemoteException, UniqueConstraintViolatedException;	
	public void deletar(TarifaVO tarifaVO) throws RemoteException, ChildRecordFoundException;	
	public void alterar(TarifaVO tarifaVO) throws RemoteException, UniqueConstraintViolatedException;	
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
	public List<ItinerarioVo> getListaItinerario(ItinerarioVo itinerarioVo) throws RemoteException;

	public void inserir(RodoviariaVO rodoviariaVO) throws RemoteException;	
	public void alterar(RodoviariaVO rodoviariaVO) throws RemoteException;
	public RodoviariaVO getRodoviaria(RodoviariaVO rodoviariaVO) throws RemoteException;
	public List<RodoviariaVO> getListaRodoviaria (RodoviariaVO rodoviariaVO) throws RemoteException;
	public List<RodoviariaVO> listaInicioRodoviaria(RodoviariaVO rodoviariaVO) throws RemoteException;

	public void insert(EnderecoVO enderecoVO) throws  RemoteException;
	public void alterarEndereco(EnderecoVO enderecoVO) throws RemoteException;
	public void deletarEndereco(EnderecoVO enderecoVO) throws RemoteException;
	public EnderecoVO getEndereco(EnderecoVO enderecoVO) throws  RemoteException;
	
	
	public void inserir(ViagemVO viagemVO) throws RemoteException;	
	public void deletar(ViagemVO viagemVO) throws RemoteException;	
	public void alterar(ViagemVO viagemVO) throws RemoteException;	
	public ViagemVO getViagem(ViagemVO viagemVO) throws RemoteException;
	public List<ViagemVO> getListaViagem(ViagemVO viagemVO) throws RemoteException;
	
	public void inserirCliente(ClienteVO clienteVO) throws RemoteException;
	public void inserirFisica(FisicaVO fisicaVO) throws RemoteException;
	public void deletarCliente(ClienteVO clienteVO) throws RemoteException, ChildRecordFoundException;
	public void alterarCliente(ClienteVO clienteVO) throws RemoteException, UniqueConstraintViolatedException;
	public void alterarFisica(FisicaVO fisicaVO) throws RemoteException, UniqueConstraintViolatedException;
	public FisicaVO getClienteFisica (FisicaVO fisicaVO) throws RemoteException;
	public List< FisicaVO > getListaClienteFisica (FisicaVO fisicaVO) throws RemoteException;
	public ClienteVO getCliente (ClienteVO clienteVO) throws RemoteException;
	
	public void inserirJuridica(JuridicaVO juridicaVO) throws RemoteException;
	public void alterarJuridica(JuridicaVO juridicaVO) throws RemoteException;
	public JuridicaVO getClienteJuridica (JuridicaVO juridicaVO) throws RemoteException;
	public List<JuridicaVO> getListaClienteJuridica (JuridicaVO juridicaVO) throws RemoteException;
	
	public List<ViagemVO> getListaViagensCompraIda(ViagemVO viagemVO) throws RemoteException;
	public List<ViagemVO> getListaViagensCompraVolta(ViagemVO viagemVO) throws RemoteException;
}
