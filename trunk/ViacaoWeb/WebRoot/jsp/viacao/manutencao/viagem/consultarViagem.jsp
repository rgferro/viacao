<%@ include file="/jsp/common/taglibs.jsp"%>

<script type="text/javascript">
function voltar(){
var frm = document.forms[0];
	frm.task.value = 'unspecified';
	frm.submit();
}
</script>

<link href="css/portal.css" rel="stylesheet" type="text/css">
<html:form action="/manterViagem">

<html:hidden name="manterTarifaForm" property="task"/>
<html:hidden name="manterTarifaForm" property="listaViagem"/>
<html:hidden name="manterTarifaForm" property="listaItinerario"/>
<html:hidden name="manterTarifaForm" property="listaOnibus"/>
<html:hidden name="manterTarifaForm" property="seqViagem"/>
<html:hidden name="manterTarifaForm" property="acao"/>
<html:hidden name="manterTarifaForm" property="busca"/>

<table width="600" border="0" align="center">
	<tr>
		<td>
			<table width="100%" border="0" align="center">
				<tr>
					<td class="titulo">Consulta de Viagens</td>
				</tr>
			</table>
			<br>
			<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
				<tr class="fundoescuro">
					<td colspan="4" align="center" class="texto">Consultar Viagem</td>
				</tr>
			</table>
			<br>
			<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
				<tr class="fundoescuro">
					<td class="texto" align="left" width="13%">Viagem</td>
					<td colspan="3"><input class="input" size="41" value="Rio de Janeiro - Juiz de Fora" disabled="disabled"></td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" align="left" width="13%">Tipo</td>
					<td width="37%"><input class="input" size="17" value="Executivo" disabled="disabled"></td>
					<td class="texto" align="left" width="13%">Data</td>
					<td width="37%"><input class="input" size="17" value="06/06/2011" disabled="disabled"></td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" align="left" width="13%">Hora Saída</td>
					<td width="33%"><input class="input" size="8" value="18:00" disabled="disabled"></td>
					<td class="texto" align="left" width="13%">Hora Chegada</td>
					<td width="33%"><input class="input" size="08" value="22:00" disabled="disabled"></td>
				</tr>
			</table>
			<br>
				<tr>
					<td align="center">
						<html:button styleClass="botao" value="Buscar" property="" src="images/zoomoff.png" border="0" height="20" width="20" onmouseover="mudaImagemOver(this,'pesquisar');" onmouseout="mudaImagemOut(this, 'pesquisar')" onclick="javascript: inicio('pesquisar');"/>				
				</tr>
	</table>
</html:form>