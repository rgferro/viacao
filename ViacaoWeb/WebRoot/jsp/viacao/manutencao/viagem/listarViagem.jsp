<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript">

</script>

<html:form action="/manterViagem">

	<table width="600" border="0" align="center">
		<tr>
			<td>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Viagens</td>
					</tr>
				</table>
				<br>
				<table>
					<tr>
						<td class="link">
							<img src="images/fetch.gif"/> Cadastrar Nova Viagem
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center" id="consulta" class="bordatabela">
				<tr class="fundoescuro">
						<td class="texto" colspan="4" align="center">Busca de Viagens</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="05%" height="20" align="center">
							Origem
						</td>
						<td width="45%">
							<html:text name="manterViagemForm" property=""/>
						</td>
						<td class="texto" width="05%" height="20">
							Destino
						</td>
						<td width="45%">
							<html:text name="manterViagemForm" property=""/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="05%" height="20" align="center">
							Tipo
						</td>
						<td width="45%">
							<html:text name="manterViagemForm" property=""/>
						</td>
						<td class="texto" width="05%" height="20" align="center">
							Data	
						</td>
						<td width="45%" colspan="3">
							<html:text name="manterViagemForm" property=""/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="%" height="20" align="center">
							Hora
						</td>
						<td width="45%" colspan="3">
							<html:text name="manterViagemForm" property=""/>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td colspan="4" align="center">
							<html:button styleClass="botao" value="Buscar" property="" onclick=""/>
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" class="bordatabela">
					<tr class="fundoescuro">
						<td width="10%" height="20" colspan="3">&nbsp;</td>
						<td width="20%"  align="center">Origem</td>
						<td width="20%" align="center">Destino</td>
						<td width="20%" align="center">Tipo</td>
						<td width="15%" align="center">Data</td>
						<td width="15%" align="center">Hora</td>
					</tr>
					<logic:notEmpty>
						<logic:iterate id="lista" name="manterViagemForm" property="listaViagem">
							<tr class="fundoclaro">
								<td align="center">
									<a href="javascript: selecionar('ALTERANDO', '<c:out value="${}"/>');">
									<img title="Editar" src="images/icon_editar.gif"></a>
								</td>
								<td align="center">
									<a href="javascript: selecionar('DELETANDO', '<c:out value="${}"/>');">
									<img title="Deletar" src="images/icon_lixeira.gif"></a>
								</td>
								<td align="center"><bean:write name="lista" property=""/></td>
								<td align="center"><bean:write name="lista" property=""/></td>
								<td align="center"><bean:write name="lista" property=""/></td>
								<td align="center"><bean:write name="lista" property=""/></td>
								<td align="center"><bean:write name="lista" property=""/></td>
							</tr>
						</logic:iterate>
					</logic:notEmpty>
					<logic:empty>
						<tr>
							<td colspan="5">
								Não há Viagens cadastradas.
							</td>
						</tr>
					</logic:empty>
				</table>
			</td>
		</tr>
	</table>
</html:form>