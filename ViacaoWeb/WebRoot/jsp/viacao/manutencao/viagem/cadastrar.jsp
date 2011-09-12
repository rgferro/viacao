<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript">
$(function() {
		$( "#datepicker" ).datepicker({
			changeMonth: true,
			changeYear: true,
			showAnim: 'slideDown' 
		});
	});
</script>


<html:form action="/manterViagem">

<html:hidden name="manterViagemForm" property="task"/>

	<table width="600" border="0" align="center">
		<tr>
			<td>
			<jsp:include page="/jsp/common/mensagens.jsp" />
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Cadastro de Viagens
						</td>
					</tr>
				</table>

				<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
					<tr class="fundoclaro">
						<td class="texto" width="20%" height="20" align="left">Itinerário
						</td>
						<td width="37%" colspan="3">
							<html:select name="manterViagemForm" property="viagemVO.itinerarioVo.seqItinerario" styleId="lista" styleClass="inputobrigatorio">
								<html:option value="-1">SELECIONE</html:option>
    							<html:optionsCollection  name="manterViagemForm" property="listaItinerario" label="origemDestino" value="seqItinerario"/>
    						</html:select>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="13%" height="20" align="left">Tipo de Ônibus
						</td>
						<td width="37%">
							<html:select name="manterViagemForm" property="viagemVO.onibusVO.seqOnibus" styleId="lista" styleClass="inputobrigatorio">
								<html:option value="-1">SELECIONE</html:option>
								<html:optionsCollection  name="manterViagemForm" property="listaOnibus" label="tipo" value="seqOnibus"/>	
    						</html:select>
						</td>
						<td class="texto" width="13%" height="20" align="left">Data
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaSaida.data" styleClass="inputobrigatorio" styleId="datepicker" size="12"/>
						</td>	
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="05%" align="left">Hora Saída
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaSaida.horaMinuto" maxlength="4" size="5" styleClass="inputobrigatorio" onkeypress="return somenteNumero(this, event,false,false,false);" onchange="formataHoraMin(this);"/>
						</td>
						<td class="texto" width="05%" align="left">Hora Chegada
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaChegada.horaMinuto" maxlength="4" size="5" styleClass="inputobrigatorio" onkeypress="return somenteNumero(this, event,false,false,false);" onchange="formataHoraMin(this);"/>
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center">
				<tr>
					<td align="center"><html:button value="Voltar" property="" styleClass="botao"  onclick="go('manterViagem.do?task=unspecified')"/></td>
					<td align="center"><html:button value="Cadastrar" property="" styleClass="botao" onclick="go('manterViagem.do?task=inserirViagem')" /></td>
					<td align="center"><html:button value="Limpar" property="" styleClass="botao" onclick="go('manterViagem.do?task=paginaCadastrarViagem')" /></td>
				</tr>
			</table>
		</tr>
	</table>	
</html:form>