<%@ include file="/jsp/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<script>
function confirmar(){
	var frm = document.forms[0];
	frm.task.value = 'alterarViagem';
	frm.submit();
}

function voltar(){
	var frm = document.forms[0];
	frm.task.value = 'unspecified';
	frm.submit();
}
function limpar(){
	var frm = document.forms[0];
	frm.task.value = 'limpar';
	frm.submit();
}
</script>

<link href="css/portal.css" rel="stylesheet" type="text/css">

<html:form action="/manterViagem">

<html:hidden name="manterViagemForm" property="task"/>
<html:hidden name="manterViagemForm" property="viagemVO"/>
<html:hidden name="manterViagemForm" property="listaViagem"/>
<html:hidden name="manterViagemForm" property="listaItinerario"/>
<html:hidden name="manterViagemForm" property="listaOnibus"/>
<html:hidden name="manterViagemForm" property="seqViagem"/>
<html:hidden name="manterViagemForm" property="acao"/>
<html:hidden name="manterViagemForm" property="editar"/>

	<table width="600" border="0" align="center">
		<tr>
			<td>
			<jsp:include page="/jsp/common/mensagens.jsp" />
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Edição de Viagem
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">Editar Viagem
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="13%">Viagem
						</td>
						<td width="37%">
							<html:select name="manterViagemForm" property="viagemVO.itinerarioVo.seqItinerario" styleId="lista" styleClass="input">
	    						<html:optionsCollection  name="manterViagemForm" property="listaItinerario" label="origemDestino" value="seqItinerario"/>
	    					</html:select>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="13%">Tipo de Ônibus
						</td>
						<td width="37%">
							<html:select name="manterViagemForm" property="viagemVO.onibuisVO.tipo" styleId="lista" styleClass="input"/>
	    				</td>
						<td class="texto" align="center" width="13%">Data
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaSaida" styleClass="input"/><img src="images/calendar.gif" styleId="datepicker"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="13%">Hora Saída
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaSaida" styleClass="input"/>
						</td>
						<td class="texto" align="center" width="13%">Hora Chegada
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaChegada" styleClass="input"/>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center">
							<html:button styleClass="botao" value="Voltar" property="" onclick="voltar();"/>
						</td>	
						<td align="center">
							<html:button styleClass="botao" value="Cadastrar" property="" onclick="confirmar();"/>
						</td>	
						<td align="center">
							<html:reset styleClass="botao" value="Limpar" onclick="executar();"/>
						</td>	
					</tr>
				</table>
			</td>
		</tr>
	</table>
</html:form>