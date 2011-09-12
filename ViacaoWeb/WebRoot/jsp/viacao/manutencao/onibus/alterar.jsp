<%@ include file="/jsp/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<script>
function confirmar(){
	var frm = document.forms[0];
		frm.task.value = 'alterarOnibus';
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
<html:form action="/manterOnibus">
<html:hidden property="task" name="manterOnibusForm"/>
	<table width="600" border="0" align="center">
		<tr>
			<td>
			<jsp:include page="/jsp/common/mensagens.jsp" />
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Atualização de Ônibus</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">Atualização de Ônibus</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="18%" height="20" align="center">Empresa</td>
						<td width="32%">
							<html:text name="manterOnibusForm" property="onibusVO.empresa" styleClass="inputobrigatorio"/>
						</td>
						<td class="texto" width="05%" height="20">Tipo</td>
						<td width="45%">
							<html:text name="manterOnibusForm" property="onibusVO.tipo" styleClass="inputobrigatorio"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="18%" height="20" align="center">Qtd Poltronas</td>
						<td width="32%">
							<html:text onkeypress="return somenteNumero(this,event,false,false,false)" maxlength="3" name="manterOnibusForm" property="qtdPoltronas" styleClass="inputobrigatorio"/>
						</td>
						<td class="texto" width="05%" height="20" align="center">Placa</td>
						<td width="45%">
							<html:text onkeypress="return formataPlaca(this,event,true)" name="manterOnibusForm" property="onibusVO.placa" styleClass="inputobrigatorio" maxlength="8"/>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center">
							<html:button value="Voltar" property="" styleClass="botao" onclick="voltar();"/>
						</td>
						<td align="center">
							<html:button value="Confirmar" property="" styleClass="botao" onclick="confirmar();"/>
						</td>
						<td align="center">
							<html:reset value="Limpar" styleClass="botao" onclick="limpar();"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</html:form>
