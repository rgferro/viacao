<%@ include file="/jsp/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<script type="text/javascript">
function excluir(){
	var frm = document.forms[0];
	frm.task.value = 'deletarOnibus';
	frm.submit();
}

function voltar(){
	var frm = document.forms[0];
	frm.task.value = 'unspecified';
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
						<td class="titulo">Deletar Ônibus</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">Deletar Ônibus</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="18%" height="20" align="center">Empresa</td>
						<td width="32%">
							<html:text disabled="true" name="manterOnibusForm" property="onibusVO.empresa" styleClass="input"/>
						</td>
						<td class="texto" width="05%" height="20">Tipo</td>
						<td width="45%">
							<html:text disabled="true" name="manterOnibusForm" property="onibusVO.tipo" styleClass="input"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="18%" height="20" align="center">Qtd Poltronas</td>
						<td width="32%">
							<html:text disabled="true" onkeypress="return somenteNumero(this,event,false,false,false)" maxlength="3" name="manterOnibusForm" property="onibusVO.qtdPoltronas" styleClass="input"/>
						</td>
						<td class="texto" width="05%" height="20" align="center">Placa</td>
						<td width="45%">
							<html:text disabled="true" onkeypress="return formataPlaca(this,event,true)" name="manterOnibusForm" property="onibusVO.placa" styleClass="input"/>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center">
							<html:button value="Voltar" property="" styleClass="botao" onclick="voltar();"/>
						</td>
						<td align="center">
							<html:button value="Excluir" property="" styleClass="botao" onclick="excluir();"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</html:form>
