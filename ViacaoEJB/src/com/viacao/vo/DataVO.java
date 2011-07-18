package com.viacao.vo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.acol.util.StringUtil;

public class DataVO implements Serializable, Comparable
{
	private String dia;
	private String mes;
	private String ano;
	private String data;
	private String hora;
	private String minuto;
	private String segundo;
	private static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat SDF_HORA = new SimpleDateFormat("HHmmss");
	
	public DataVO() 
	{
		SDF.setLenient(false);
		SDF_HORA.setLenient(false);
	}
	
	public DataVO(String data) throws Exception
	{
		SDF.setLenient(false);
		SDF_HORA.setLenient(false);
		setData(data);
	}

	public DataVO(Calendar cal) {
		int dia = cal.get(Calendar.DAY_OF_MONTH);
		int mes = cal.get(Calendar.MONTH) + 1;
		int ano = cal.get(Calendar.YEAR);
		
		int hor = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int seg = cal.get(Calendar.SECOND);
	
		this.dia = StringUtil.lPad(String.valueOf(dia), 2, "0"); 
		this.mes = StringUtil.lPad(String.valueOf(mes), 2, "0"); 
		this.ano = StringUtil.lPad(String.valueOf(ano), 4, "0");
		
		this.hora = StringUtil.lPad(String.valueOf(hor), 2, "0"); 
		this.minuto = StringUtil.lPad(String.valueOf(min), 2, "0"); 
		this.segundo = StringUtil.lPad(String.valueOf(seg), 2, "0"); 
	}
	
	public String toString()
	{
		return getData();
	}
	
	/**
	 * @return Returns the ano.
	 */
	public String getAno() {
		return ano;
	}
	/**
	 * @param ano The ano to set.
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}
	/**
	 * @return Returns the dia.
	 */
	public String getDia() {
		return dia;
	}
	/**
	 * @param dia The dia to set.
	 */
	public void setDia(String dia) {
		this.dia = dia;
	}
	/**
	 * @return Returns the mes.
	 */
	public String getMes() {
		return mes;
	}
	/**
	 * @param mes The mes to set.
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	public String getDataHoraMinSeg(){
		return getData()+" "+getHoraMinutoSegundo();
	}
	/**
	 * @return Returns the data.
	 */
	public String getData() 
	{
		if (StringUtil.empty(dia) && StringUtil.empty(mes) && StringUtil.empty(ano))
			data = null;
		else
			data =  dia + "/" + mes + "/" + ano;
		return data;
	}
	/**
	 * @return Returns the data.
	 */
	public String getDiaMes() 
	{
		if (StringUtil.empty(dia) && StringUtil.empty(mes) && StringUtil.empty(ano))
			data = null;
		else
			data =  dia + "/" + mes;
		return data;
	}
	/**
	 * @param data The data to set.
	 * @throws Exception 
	 */
	public void setData(String data) throws Exception 
	{
		try{
			if (! StringUtil.empty(data))
			{
				this.data = data;
				int posIni, posFim;
				posIni = data.indexOf("/");
				posFim = data.lastIndexOf("/");
				dia = data.substring(0,posIni);
				mes = data.substring(posIni+1,posFim);
				ano = data.substring(posFim+1,posFim+5);

			}
			else
			{
				this.data = null;
				dia = null;
				mes = null;
				ano = null;
			}
		}catch (Exception e) {
			throw new Exception("DataVO:setData - erro ao tentar inserir data no objeto. Verifique o formato da data.", e);
		}
	}
	
	/**
	 * @param horaMinutoSegundo The horaMinutoSegundo to set.
	 * @throws Exception 
	 */
	public void setHoraMinutoSegundo(String horaMinutoSegundo) throws Exception 
	{
		try{
			if (! StringUtil.empty(horaMinutoSegundo))
			{
				int posIni, posFim;
				posIni = horaMinutoSegundo.indexOf(":");
				posFim = horaMinutoSegundo.lastIndexOf(":");
				hora = horaMinutoSegundo.substring(0,posIni);
				minuto = horaMinutoSegundo.substring(posIni+1,posFim);
				segundo = horaMinutoSegundo.substring(posFim+1);
			}
			else
			{
				hora = null;
				minuto = null;
				segundo = null;
			}
		}
		catch (Exception e) 
		{
			throw new Exception("DataVO:setHoraMinutoSegundo - erro ao tentar inserir horaMinutoSegundo no objeto. Verifique o formato da horaMinutoSegundo.", e);
		}
	}
	
	/**
	 * @param horaMinuto The horaMinutoSegundo to set.
	 * @throws Exception 
	 */
	public void setHoraMinuto(String horaMinuto) throws Exception 
	{
		try{
			if (! StringUtil.empty(horaMinuto))
			{
				int posIni;
				posIni = horaMinuto.indexOf(":");
				hora = horaMinuto.substring(0,posIni);
				minuto = horaMinuto.substring(posIni+1);
			}
			else
			{
				hora = null;
				minuto = null;
			}
		}
		catch (Exception e) 
		{
			throw new Exception("DataVO:setHoraMinutoSegundo - erro ao tentar inserir horaMinutoSegundo no objeto. Verifique o formato da horaMinutoSegundo.", e);
		}
	}
	
	public boolean isEmpty()
	{
		return StringUtil.empty(getData());
	}
	
	public boolean isValid()
	{
		try
		{
			String data = getData();
			
			if (! StringUtil.empty(data) && data.substring(data.lastIndexOf("/")+1).length() == 4){
				SDF.setLenient(false);
				SDF.parse(data);
				return true;
			}
			
			return false;
		}
		catch(ParseException e)
		{
			return false;
		}
	}
	
	public Date getDate()
	{
		String data = "";
		String format = "";
		if(this.getData()==null) {
			data = this.getHoraMinutoSegundo();
			format = "HH:mm:ss";
		} else {
			data = this.getData() + " " + this.getHoraMinutoSegundo();
			format = "dd/MM/yyyy HH:mm:ss";
		}
		
		Date retorno = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			retorno = sdf.parse(data);
		} catch (Exception e) {}
		return retorno;
	}
	
	public String getHoraMinutoSegundo()
	{
		if(getHoraMinuto().equals("")){
			return "";
		}else{
			return getHoraMinuto() + ":" + StringUtil.nvl(getSegundo(),"00"); 
		}
	}
	
	public String getHoraMinuto()
	{
		if(getHora() == null){
			return "";
		}else{
			return StringUtil.nvl(getHora(),"00") + ":" + StringUtil.nvl(getMinuto(),"00");
		}
	}
	
	public boolean isValidHoraMinuto()
	{
		try
		{
			if (!StringUtil.empty(getHora()) && !StringUtil.empty(getMinuto()))
			{
				SDF_HORA.parse(getHora() + getMinuto() + "00");
				return true;
			}
			
			return false;
		}
		catch(ParseException e)
		{
			return false;
		}
	}
	
	public boolean isValidHoraMinutoSegundo()
	{
		try
		{
			if (!StringUtil.empty(getHora()) && !StringUtil.empty(getMinuto()) && !StringUtil.empty(getSegundo()))
			{
				SDF_HORA.parse(getHora() + getMinuto() + getSegundo());
				return true;
			}
			
			return false;
		}
		catch(ParseException e)
		{
			return false;
		}
	}
	
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getMinuto() {
		return minuto;
	}

	public void setMinuto(String minuto) {
		this.minuto = minuto;
	}

	public String getSegundo() {
		return segundo;
	}

	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}

	public int compareTo(Object obj) {
		if(obj==null || !(obj instanceof DataVO)) return -1;
		
		DataVO dataVO = (DataVO) obj;
		
		Date dataThis = this.getDate();
		Date dataObj = dataVO.getDate();
		
		if(dataThis == null) {
			if(dataObj==null) {
				return 0;
			} else {
				return -1;
			}
		} else {
			if(dataObj==null) {
				return 1;
			} else {
				return dataThis.compareTo(dataObj);
			}
		}
	}
	
}
