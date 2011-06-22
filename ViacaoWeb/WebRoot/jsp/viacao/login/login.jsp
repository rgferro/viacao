<%@ include file="/jsp/common/taglibs.jsp" %>
<script type="text/javascript">

</script>
<html:form action="/login">
<table width="600" border="0" align="center">
	<tr>
		<td><jsp:include page="/jsp/common/mensagens.jsp" /></td>
	</tr>
	<tr>
		<td>
			<table width="50%" border="0" align="center" class="bordatabela">
				<tr class="fundoescuro">
					<td class="texto" colspan="2" align="center">Login<br></td>
				</tr>
				<tr class="fundoclaro" >
					<td width="10%" class="texto">Login</td>
					<td><html:text property="clienteVO.login" size="30" name="loginForm" styleClass="input" maxlength="20"/></td>
				</tr>
				<tr class="fundoclaro">
					<td width="10%" class="texto">Senha</td>
					<td><html:text property="clienteVO.senha" size="30" name="loginForm" styleClass="input" maxlength="20"/></td>
				</tr>
			</table>
			<table width="50%" border="0" align="center" id="buscar">
				<tr>
					<td colspan="2" class="link"><img src="images/fetch.gif"/>&nbsp;<a href="#">Cadastrar Novo cliente</a></td>
				</tr>
			</table>
			<br>
			<table width="50%" border="0" align="center">
				<tr>
					<td align="center"><input class="botao" value="Cancelar" type="button" onclick="go('exemplo.do')"/></td>
					<td align="center"><input class="botao" value="Login" type="button" onclick="go('login.do?task=logar')"/></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</html:form>