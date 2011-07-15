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

function getJuridica(acao, seqJ, seqE, seqC){
	var frm = document.forms[0];
	frm.seqEndereco.value = seqE;
	frm.seqCliente.value = seqC;
	frm.seqJuridica.value = seqJ;
	frm.acao.value = acao;
	frm.task.value = 'getJuridica';
	frm.submit();
}
</script>

<html:form action="/manterClienteJuridica">
<html:hidden property="task" name="manterJuridicaForm"/>
<html:hidden property="seqJuridica" name="manterJuridicaForm"/>
<html:hidden property="seqEndereco" name="manterJuridicaForm"/>
<html:hidden property="seqCliente" name="manterJuridicaForm"/>
<html:hidden property="acao" name="manterJuridicaForm"/>
	<table width="600" border="0" align="center">
		<tr>
			<td>
				<jsp:include page="/jsp/common/mensagens.jsp" />
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Usuário Jurídico</td>
					</tr>
				</table>
				<table>
					<tr>
						<td class="link"><img src="images/fetch.gif"/>
							<a href="manterClienteJuridica.do?task=paginaCadastrarClienteJuridica">
								Cadastrar um novo cliente juridico
							</a>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center" class="bordatabela">
					<tr class="fundoescuro">
						<td class="texto" colspan="4" align="center">Busca de usuário jurídico</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="20%" align="center">Nome da empresa</td>
						<td width="80%" colspan="4">
							<html:text name="manterJuridicaForm" property="juridicaVO.razaoSocial" size="50" styleClass="input"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="20%" height="20" align="center">Login</td>
						<td width="30%">
							<html:text name="manterJuridicaForm" property="juridicaVO.clienteVO.login" size="30" styleClass="input"/>
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
						<td width="5%" height="10" colspan="3">&nbsp;</td>
						<td width="40%"  align="center">Nome da empresa</td>
						<td width="20%" align="center">Login</td>
						<td width="30%" align="center">E-mail</td>	
						<td width="5%" align="center">Tipo</td>				
					</tr>
					<logic:empty name="manterJuridicaForm" property="listaClienteJuridico">
						<tr>
							<td align="center" colspan="7" class="texto">Nenhum usuário foi encontrado!</td>
						</tr>
					</logic:empty>
					<logic:notEmpty name="manterJuridicaForm" property="listaClienteJuridico">
						<logic:iterate id="listaJuridica" name="manterJuridicaForm" property="listaClienteJuridico">
							<tr class="fundoclaro">
								<td align="center">
									<a href="javascript: getJuridica('ALTERAR', <c:out value="${listaJuridica.seqJuridica}"/>, <c:out value="${listaJuridica.clienteVO.enderecoVO.seqEndereco}"/>, <c:out value="${listaJuridica.clienteVO.seqCliente}"/>);">
										<img title="Editar!" src="images/icon_editar3off.png" height="20" width="20" border="0" onmouseover="mudaImagemOver(this,'editar');" onmouseout="mudaImagemOut(this, 'editar')">
									</a>
								</td>
								<td align="center">
									<a href="javascript: getJuridica('DELETAR', <c:out value="${listaJuridica.seqJuridica}"/>, <c:out value="${listaJuridica.clienteVO.enderecoVO.seqEndereco}"/>, <c:out value="${listaJuridica.clienteVO.seqCliente}"/>);">
										<img title="Deletar!" src="images/icon_lixeira3off.png" height="20" width="20" border="0" onmouseover="mudaImagemOver(this,'deletar');" onmouseout="mudaImagemOut(this, 'deletar')">
									</a>
								</td>
								<td align="center">
									<a href="javascript: getJuridica('CONSULTAR', <c:out value="${listaJuridica.seqJuridica}"/>, <c:out value="${listaJuridica.clienteVO.enderecoVO.seqEndereco}"/>, <c:out value="${listaJuridica.clienteVO.seqCliente}"/>);">
										<img title="Consultar!" src="images/zoomoff.png" height="20" width="20" border="0" onmouseover="mudaImagemOver(this,'consultar');" onmouseout="mudaImagemOut(this, 'consultar')">
									</a>
								</td>
								<td align="center">
									<bean:write name="listaJuridica" property="razaoSocial"/>
								</td>
								<td align="center">
									<bean:write name="listaJuridica" property="clienteVO.login"/>
								</td>
								<td align="center">
									<bean:write name="listaJuridica" property="clienteVO.email"/>
								</td>
								<td align="center">
								<c:if test="${listaJuridica.razaoSocial ne null}">
									USUÁRIO
								</c:if>
								<c:if test="${listaJuridica.razaoSocial eq null}">
									ADMINISTRADOR
								</c:if>
							</td>
							</tr>
						</logic:iterate>
					</logic:notEmpty>
				</table>
			</td>
		</tr>
	</table>
</html:form>
