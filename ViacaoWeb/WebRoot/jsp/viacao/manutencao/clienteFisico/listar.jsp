<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript">
	function selecionar(acao, seqF, seqE, seqC){
		var frm = document.forms[0];
		frm.seqFisica.value = seqF;
		frm.seqEndereco.value = seqE;
		frm.seqCliente.value = seqC;
		frm.acao.value = acao;
		frm.task.value = 'getFisica';
		frm.submit();
	}
	
	
</script>

<html:form action="/manterClienteFisica">
<html:hidden property="task" name="manterClienteFisicaForm"/>
<html:hidden property="seqFisica" name="manterClienteFisicaForm"/>
<html:hidden property="seqEndereco" name="manterClienteFisicaForm"/>
<html:hidden property="seqCliente" name="manterClienteFisicaForm"/>
<html:hidden property="acao" name="manterClienteFisicaForm"/>

	<table width="600" border="0" align="center">
		<tr>
			<td>
				<jsp:include page="/jsp/common/mensagens.jsp" />
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Usuário Físico</td>
					</tr>
				</table>
				<table>
					<tr>
						<td class="texto">Bem vindo administrador <c:out value="${listaClienteFisico.fisicaVO.nomPessoa}"/>.</td>
					</tr>
				</table>
				<table>
	
					<tr>
						<td class="link"><img src="images/fetch.gif"/>
							<a href="<%request.getContextPath();%>?task=paginaCadastrarClienteFisica&acao=CADASTRAR">Cadastrar uma nova conta</a>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center" class="bordatabela">
					<tr class="fundoescuro">
						<td class="texto" colspan="4" align="center">Busca de usuário físico</td>
	
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="10%" height="20" align="center">Nome</td>
						<td width="45%" colspan="3">
							<html:text name="manterClienteFisicaForm" property="fisicaVO.nomPessoa" styleClass="input" size="100"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="10%" height="20" align="center">Login</td>
						<td width="45%">
							<html:text name="manterClienteFisicaForm" property="fisicaVO.clienteVO.login" styleClass="input" size="52"/>
						</td>
					
						<td class="texto" width="10%" height="20">E-mail</td>
						<td width="45%">
							<html:text name="manterClienteFisicaForm" property="fisicaVO.clienteVO.email" styleClass="input" size="30"/>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td colspan="4" align="center"><input class="botao" value="Buscar"></td>
					</tr>
	
				</table>
				<br>
				<table width="100%" border="0" align="center" class="bordatabela">
					<tr class="fundoescuro">
						<td width="15%" height="20" colspan="3">&nbsp;</td>
						<td width="40%"  align="center">Nome</td>
						<td width="20%" align="center">Login</td>
						<td width="25%" align="center">E-mail</td>					
						<td width="25%" align="center">Tipo Usuario</td>					
					</tr>
					<logic:empty name="manterClienteFisicaForm" property="listaClienteFisico">
						<tr>
							<td align="center" colspan="6" class="texto">Nenhum usuário foi encontrado!</td>
						</tr>
					</logic:empty>
					<logic:iterate id="lista" name="manterClienteFisicaForm" property="listaClienteFisico">
						<tr class="fundoclaro">
							<td align="center">
								<a href="javascript: selecionar('ALTERAR', <c:out value="${lista.seqFisica}"/>, <c:out value="${lista.clienteVO.enderecoVO.seqEndereco}"/>, <c:out value="${lista.clienteVO.seqCliente}"/>)">
									<img title="Editar!" src="images/icon_editar3off.png" height="20" width="20" border="0" onmouseover="mudaImagemOver(this,'editar');" onmouseout="mudaImagemOut(this, 'editar')">
								</a>
							</td>
							<td align="center">
								<a href="javascript: selecionar('DELETAR', <c:out value="${lista.seqFisica}"/>, <c:out value="${lista.clienteVO.enderecoVO.seqEndereco}"/>, <c:out value="${lista.clienteVO.seqCliente}"/>)">
									<img title="Deletar!" src="images/icon_lixeira3off.png" height="20" width="20" border="0" onmouseover="mudaImagemOver(this,'deletar');" onmouseout="mudaImagemOut(this, 'deletar')">
								</a>
							</td>
							<td align="center">
								<a href="javascript: selecionar('CONSULTAR', <c:out value="${lista.seqFisica}"/>, <c:out value="${lista.clienteVO.enderecoVO.seqEndereco}"/>, <c:out value="${lista.clienteVO.seqCliente}"/>)">
									<img title="Consultar!" src="images/zoomoff.png" height="20" width="20" border="0" onmouseover="mudaImagemOver(this,'consultar');" onmouseout="mudaImagemOut(this, 'consultar')">
								</a>
							</td>
							<td align="center">
								<bean:write name="lista" property="nomPessoa"/>
							</td>
							<td align="center">
								<bean:write name="lista" property="clienteVO.login"/>
							</td>
							<td align="center">
								<bean:write name="lista" property="clienteVO.email"/>
							</td>
							<td align="center">
								<c:if test="${lista.nomPessoa ne null}">
									Usuário
								</c:if>
								<c:if test="${lista.nomPessoa eq null}">
									Administrador
								</c:if>
							</td>
						</tr>
					</logic:iterate>
				</table>
			</td>
		</tr>
	</table>
</html:form>
