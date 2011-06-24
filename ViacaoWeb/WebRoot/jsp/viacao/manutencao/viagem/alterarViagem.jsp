<%@ include file="/jsp/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

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
<form action="/manterViagem">
<html:hidden property="task" name="manterViagemForm"/>
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
					<td colspan="3"><input class="input" size="50" value="Rio de Janeiro - Juiz de Fora"></td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" align="center" width="13%">Tipo de Ônibus</td>
					<td width="37%"><input class="input" size="20" value="Executivo"></td>
					<td class="texto" align="center" width="13%">Data</td>
					<td width="37%"><input class="input" size="20" value="06/06/2011"></td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" align="center" width="13%">Hora Saída</td>
					<td width="37%"><input class="input" size="8" value="18:00"></td>
					<td class="texto" align="center" width="13%">Hora Chegada</td>
					<td width="37%"><input class="input" size="08" value="22:00"></td>
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
							<html:reset styleClass="botao" value="Limpar"/>
						</td>	
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>