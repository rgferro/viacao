<%@ include file="/jsp/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

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
					<td class="texto" align="center" width="13%">Viagem
					</td>
					<td colspan="3"><input class="input" size="50" value="Rio de Janeiro - Juiz de Fora" disabled="disabled">
					</td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" align="center" width="13%">Tipo de Ônibus
					</td>
					<td width="37%"><input class="input" size="20" value="Executivo" disabled="disabled"/>
					<td class="texto" align="center" width="13%">Data
					</td>
					<td width="33%"><input class="input" size="17" value="06/06/2011" disabled="disabled"/>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" align="center" width="13%">Hora Saída
					</td>
					<td width="37%"><input class="input" size="8" value="18:00" disabled="disabled"/>
					<td class="texto" align="center" width="17%">Hora Chegada
					</td>
					<td width="33%"><input class="input" size="08" value="22:00" disabled="disabled"/>
				</tr>
			</table>
			<table width="100%" border="0" align="center">
				<tr>
					<td align="center">
						<html:button value="Voltar" property="" styleClass="botao" title="Voltar" onclick="voltar();"/>
					<td align="center">
						<html:button value="Excluir" property="" styleClass="botao" title="Confirmar Exclusão" onclick="excluir();"><img src="../../../../images/acceptoff.png"></img></html:button>        
					<td align="center">
						<html:button value="Cancelar" property="" styleClass="botao" title="Cancelar Exclusão" onclick="cancelar();"><img src="../../../../images/deleteoff.png"></img></html:button>
				</tr>
			</table>
		</td>
	</tr>
</table>
</html:form>