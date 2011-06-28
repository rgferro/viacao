<%@ include file="/jsp/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<link type="text/css" href="css/custom-theme/jquery-ui-1.8.13.custom.css" rel="stylesheet" />	
<script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.13.custom.min.js"></script>

<script type="text/javascript">
function buscar(){
	var frm = document.forms[0];
	frm.task.value = 'listarJuridica';
	frm.submit();
}
</script>

<html:form action="/manterCliente">
<html:hidden property="task" name="manterJuridicaForm"/>
	<table width="600" border="0" align="center">
		<tr>
			<td>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Usu�rio Jur�dico</td>
					</tr>
				</table>
				<table>
					<tr>
						<td class="texto">Bem vindo administrador Jo�o.</td>
					</tr>
				</table>
				<br>
				<table>
					<tr>
						<td class="link"><img src="images/fetch.gif"/>
							<a href="<%request.getContextPath();%>?task=paginaCadastrarClienteJuridica">
								Cadastrar uma nova conta
							</a>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center" class="bordatabela">
					<tr class="fundoescuro">
						<td class="texto" colspan="4" align="center">Busca de usu�rio jur�dico</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="20%" align="center">Nome da empresa</td>
						<td width="80%" colspan="4">
							<html:text name="manterJuridicaForm" property="juridicaVO.razaoSocial" size="90" styleClass="input"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="20%" height="20" align="center">Login</td>
						<td width="30%">
							<html:text name="manterJuridicaForm" property="juridicaVO.clienteVO.login" size="20" styleClass="input"/>
						</td>
						<td class="texto" width="08%" height="20">E-mail</td>
						<td width="42%">
							<html:text name="manterJuridicaForm" property="juridicaVO.clienteVO.email" size="30" styleClass="input"/>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td colspan="4" align="center">
							<html:button value="Buscar" property="" styleClass="botao" onclick="buscar();"/>
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" class="bordatabela">
					<tr class="fundoescuro">
						<td width="15%" height="20" colspan="3">&nbsp;</td>
						<td width="40%"  align="center">Nome da empresa</td>
						<td width="20%" align="center">Login</td>
						<td width="25%" align="center">E-mail</td>					
					</tr>
					<logic:empty name="manterJuridicaForm" property="listaClienteJuridico">
						<tr>
							<td align="center" colspan="6" class="texto">Nenhum usu�rio foi encontrado!</td>
						</tr>
					</logic:empty>
					<logic:notEmpty name="manterJuridicaForm" property="listaClienteJuridico">
						<logic:iterate id="listaJuridica" name="manterJuridicaForm" property="listaClienteJuridico">
							<tr class="fundoclaro">
								<td align="center">
									<a href="<%request.getContextPath();%>?task=getJuridica&seqjuridica="+<c:out value="${listaJuridica.seqjuridica}"/>+"&acao=ALTERAR">
										<img title="Editar" src="images/icon_editar.gif">
									</a>
								</td>
								<td align="center">
									<a href="<%request.getContextPath();%>?task=getJuridica&acao=DELETAR">
										<img title="Deletar" src="images/icon_lixeira.gif">
									</a>
								</td>
								<td align="center">
									<a href="<%request.getContextPath();%>?task=getJuridica&acao=CONSULTAR">
										<img title="Deletar" src="images/icon_lupa.gif">
									</a>
								</td>
								<td align="left">
									<bean:write name="listaJuridica" property="razaoSocial"/>
								</td>
								<td align="left">
									<bean:write name="listaJuridica" property="clienteVO.login"/>
								</td>
								<td align="left">
									<bean:write name="listaJuridica" property="clienteVO.email"/>
								</td>
							</tr>
						</logic:iterate>
					</logic:notEmpty>
				</table>
			</td>
		</tr>
	</table>
</html:form>
