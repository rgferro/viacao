<%@ include file="/jsp/common/taglibs.jsp"%>

<link href="css/portal.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/custom-theme/jquery-ui-1.8.13.custom.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery-ui-1.8.13.custom.min.js"></script>
<script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>


<script type="text/javascript">

function voltar(){
	var frm = document.forms[0];
	frm.task.value = 'unspecified';
	frm.submit();
}

$(function() {
	$( "#datepicker" ).datepicker({
		showOn: "button",
		buttonImage: "images/calendar.gif",
		buttonImageOnly: true
	});
});
</script>


<html:form action="/manterViagem">

<html:hidden name="manterViagemForm" property="task"/>
<html:hidden name="manterViagemForm" property="listaViagem"/>
<html:hidden name="manterViagemForm" property="listaItinerario"/>
<html:hidden name="manterViagemForm" property="listaOnibus"/>
<html:hidden name="manterViagemForm" property="seqViagem"/>
<html:hidden name="manterViagemForm" property="acao"/>
<html:hidden name="manterViagemForm" property="busca"/>


	<table width="600" border="0" align="center">
		<tr>
			<td>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Consulta de Viagens
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">Consultar Viagem
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
					<tr class="fundoescuro">
						<td class="texto" align="left" width="13%">Viagem</td>
						<td colspan="3"><input class="input" size="41" value="Rio de Janeiro - Juiz de Fora" disabled="disabled">
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="left" width="13%">Tipo Ônibus</td>
						<td width="37%"><input class="input" size="17" value="Executivo" disabled="disabled">
						</td>
						<td class="texto" align="left" width="13%">Data</td>
						<td width="33%"><input class="input" size="17" value="06/06/2011" disabled="disabled" id="datepicker">
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="left" width="13%">Hora Saída</td>
						<td width="37%"><input class="input" size="8" value="18:00" disabled="disabled">
						</td>
						<td class="texto" align="left" width="16%">Hora Chegada</td>
						<td width="37%"><input class="input" size="8" value="22:00" disabled="disabled">
						</td>
					</tr>
				</table>
					<tr>
						<td align="center">
							<img title="Consultar" property="seqViagem" src="images/lupagif.png" border="0" height="20" width="20" onmouseover="mudaImagemOver(this,'pesquisar');" onmouseout="mudaImagemOut(this, 'pesquisar')" onclick="javascript: inicio('pesquisar');"/>			
					</tr>
	</table>
</html:form>