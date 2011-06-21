<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript">

</script>

<html:form action="/manterViagem">
<html:hidden property="task" name="manterViagemForm"/>

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
						<td class="link"><img src="images/fetch.gif"/>
							<a href="<%request.getContextPath();%>?task=paginaCadastrarViagem&acao=CADASTRAR">Cadastrar Nova Viagem</a>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center" id="consulta" class="bordatabela">
				<tr class="fundoescuro">
						<td class="texto" colspan="4" align="center">Busca de Viagens</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="13%" height="20" align="left">
							Origem
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.itinerarioVo.rodoviariaOrigemVO.nomRodoviaria" size="35" styleClass="input"/>
						</td>
						<td class="texto" width="18%" height="20" align="left">
							Destino
						</td>
						<td width="32%">
							<html:text name="manterViagemForm" property="viagemVO.itinerarioVo.rodoviariaDestinoVO.nomRodoviaria" size="30" styleClass="input"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" height="20" align="left">
							Data
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaSaida" styleClass="input"/>
						</td>
						<td class="texto" height="20" align="left">
							Tipo de Ônibus	
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.onibusVO.tipo" styleClass="input"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="left" class="texto">Hora Saída
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaSaida" styleClass="input"/>
						</td>
						<td align="left" class="texto">Hora Chegada
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaChegada" styleClass="input"/>
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
						<td width="10%" height="20" colspan="2">&nbsp;</td>
						<td width="15%"  align="center">Origem</td>
						<td width="15%" align="center">Destino</td>
						<td width="15%" align="center">Tipo de Ônibus</td>
						<td width="15%" align="center">Data</td>
						<td width="15%" align="center">Hora Saída</td>
						<td width="15%" align="center">Hora Chegada</td>
					</tr>
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
								<td align="center"><bean:write name="lista" property="itinerarioVo.rodoviariaOrigemVO.nomRodoviaria"/></td>
								<td align="center"><bean:write name="lista" property="itinerarioVo.rodoviariaDestinoVO.nomRodoviaria"/></td>
								<td align="center"><bean:write name="lista" property="onibusVO.tipo"/></td>
								<td align="center"><bean:write name="lista" property="horaSaida.data"/></td>
								<td align="center"><bean:write name="lista" property="horaSaida.horaMinutoSegundo"/></td>
								<td align="center"><bean:write name="lista" property="horaChegada.horaMinutoSegundo"/></td>
							</tr>
						</logic:iterate>
				</table>
			</td>
		</tr>
	</table>
</html:form>
