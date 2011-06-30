<%@ include file="/jsp/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<script type="text/javascript">

function excluir(){
	var frm = document.forms[0];
	frm.task.value = 'deletarViagem';
	frm.submit();
}

function voltar(){
	var frm = document.forms[0];
	frm.task.value = 'unspecified';
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
<html:hidden name="manterViagemForm" property="deletar"/>


	<table width="600" border="0" align="center">
		<tr>
			<td>
			<jsp:include page="/jsp/common/mensagens.jsp" />
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Exclusão de Viagens
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">Confirmação de Exclusão da Viagem
						</td>
					</tr>
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="left" width="13%">Viagem
						</td>
						<td width="37%">
							<html:select name="manterViagemForm" property="viagemVO.itinerarioVo.seqItinerario" styleId="lista" styleClass="input">
	    						<html:optionsCollection  name="manterViagemForm" property="listaItinerario" label="origemDestino" value="seqItinerario" disabled="disabled"/>
	    					</html:select>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="left" width="13%">Tipo de Ônibus
						</td>
						<td width="37%">
							<html:select name="manterViagemForm" property="viagemVO.onibuisVO.tipo" styleId="lista" styleClass="input" disabled="disabled"/>
						</td>
						<td class="texto" align="left" width="13%">Data
						</td>
						<td width="33%">
							<html:text name="manterViagemForm" property="viagemVO.horaSaida" styleClass="input" styleId="datepicker" disabled="disabled"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="left" width="13%">Hora Saída
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaSaida" styleClass="input" disabled="disabled"/>
						</td>
						<td class="texto" align="left" width="17%">Hora Chegada
						</td>
						<td width="33%">
							<html:text name="manterViagemForm" property="viagemVO.horaChegada" styleClass="input" disabled="disabled"/>
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center">
							<html:button value="Voltar" property="" styleClass="botao" title="Voltar" onclick="voltar();"/>
						</td>	
						<td align="center">
							<html:button value="Excluir" property="" styleClass="botao" title="Confirmar Exclusão" onclick="excluir();"/>   
						</td>  
						<td align="center">
							<html:button value="Cancelar" property="" styleClass="botao" title="Cancelar Exclusão" onclick="cancelar();"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</html:form>