<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript">
function ir(){
	var frm = document.forms[0];
	frm.task.value = 'compraConcluida';
	frm.submit();
}
</script>

<html:form action="/manterCompra">
<html:hidden property="task" name="manterCompraForm"/>
	<table width="600" border="0" align="center">
		<tr>
			<td>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Dados do cart�o</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" class="bordatabela">
					<tr class="fundoescuro">
						<td class="texto" colspan="5" align="center">Dados do cart�o</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" colspan="2">Nome impresso no cart�o</td>
						<td colspan="3"><input class="inputobrigatorio" size="85"></td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" colspan="2" width="40%">N�mero do cart�o</td>
						<td width="20%"><input class="inputobrigatorio" size="25"></td>
						<td class="texto" width="16%">V�lidade do cart�o</td>
						<td width="24%"><input class="inputobrigatorio" size="10"></td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="40%" colspan="2">C�digo de seguran�a</td>
						<td width="12%" colspan="3"><input class="inputobrigatorio" size="5"></td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center">
							<input class="botao" value="Prosseguir" type="button" onclick= ir();>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</html:form>