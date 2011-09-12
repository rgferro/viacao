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
			<jsp:include page="/jsp/common/mensagens.jsp"/>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Alterar Viagem
						</td>
					</tr>
				</table>

				<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
					<tr class="fundoclaro">
						<td class="texto" width="20%" height="20" align="left">Origem
						</td>
						<td width="30%">
							<html:text name="manterViagemForm" property="viagemVO.itinerarioVo.rodoviariaOrigemVO.nomRodoviaria" size="30" styleClass="inputdeletar" disabled="true"/>
						</td>
						<td class="texto" width="20%" height="20" align="left">Destino
						</td>
						<td width="30%">
							<html:text name="manterViagemForm" property="viagemVO.itinerarioVo.rodoviariaDestinoVO.nomRodoviaria" size="30" styleClass="inputdeletar" disabled="true"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="13%" height="20" align="left">Tipo de Ônibus
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.onibusVO.tipo" styleClass="inputdeletar" disabled="true"/>
						</td>
						<td class="texto" width="13%" height="20" align="left">Data
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaSaida.data" styleClass="inputdeletar" size="12" disabled="true"/>
						</td>	
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="05%" align="left">Hora Saída
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaSaida.horaMinuto" maxlength="4" size="5" styleClass="inputdeletar" onkeypress="return somenteNumero(this, event,false,false,false);" onchange="formataHoraMin(this);" disabled="true"/>
						</td>
						<td class="texto" width="05%" align="left">Hora Chegada
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaChegada.horaMinuto" maxlength="4" size="5" styleClass="inputdeletar" onkeypress="return somenteNumero(this, event,false,false,false);" onchange="formataHoraMin(this);" disabled="true"/>
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center">
				<tr>
					<td align="center"><html:button value="Voltar" property="" styleClass="botao"  onclick="go('manterViagem.do?task=unspecified')"/></td>
					<td align="center"><html:button value="Confirmar" property="" styleClass="botao" onclick="go('manterViagem.do?task=deletar')" /></td>
			</table>
		</tr>
	</table>	
</html:form>