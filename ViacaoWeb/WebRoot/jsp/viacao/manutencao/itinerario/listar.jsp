<%@ include file="/jsp/common/taglibs.jsp" %>
<script>
function selecionar(acao, seq){
	var frm = document.forms[0];
	frm.seqItinerario.value = seq;
	if(acao == 'PESQUISAR'){
		frm.task.value = 'consultar';
	}
	if(acao == 'ALTERAR'){
		frm.task.value = 'alterar';
	}
	if(acao == 'DELETAR'){
		frm.task.value = 'deletar';
	}	
	frm.submit();
}
</script>
<html:form action="/manterItinerario">

<html:hidden name="manterItinerarioForm" property="task"/>
<html:hidden name="manterItinerarioForm" property="seqItinerario"/>
<table width="600" border="0" align="center">
	<tr>
		<td>
			<jsp:include page="/jsp/common/mensagens.jsp" />
			<table width="100%" border="0" align="center">
				<tr>
					<td class="titulo">Intinerário</td>
				</tr>

			</table>
			<table>
				<tr>
					<td class="link"><img src="images/fetch.gif"/><a href="manterItinerario.do?task=linkCadastrar"> Cadastrar Novo Intinerário</a></td>
				</tr>
			</table>
			<table width="100%" border="0" align="center" id="consulta" class="bordatabela">

			<tr class="fundoescuro">
					<td class="texto" colspan="4" align="center">Busca de Intinerários</td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" width="12%" height="20" align="center">Origem</td>
					<td width="38%"><html:text styleClass="input" name="manterItinerarioForm" property="itinerarioVo.rodoviariaOrigemVO.nomRodoviaria"/></td>
					<td class="texto" width="12%" height="20" align="center">Destino</td>
					<td width="38%"><html:text styleClass="input" name="manterItinerarioForm" property="itinerarioVo.rodoviariaDestinoVO.nomRodoviaria"/></td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" width="18%" height="20" align="center">Tempo (hh:mm)</td>
					<td width="32%"><html:text styleClass="input" size="5" maxlength="4" name="manterItinerarioForm" property="itinerarioVo.tempoViagem" onkeypress="return somenteNumero(this, event,false,false,false);" onchange="formataHoraMin(this);"/></td>
					<td class="texto" width="18%" height="20" align="center">Valor (em R$)</td>
					<td width="32%">
						<c:if test="${manterItinerarioForm.itinerarioVo.valorPassagem == 0}">
							<html:text styleClass="input" name="manterItinerarioForm" property="itinerarioVo.valorPassagem" value=""/>
						</c:if>
						<c:if test="${manterItinerarioForm.itinerarioVo.valorPassagem > 0 || manterItinerarioForm.itinerarioVo.valorPassagem == null}">
							<html:text styleClass="input" name="manterItinerarioForm" property="itinerarioVo.valorPassagem"/>
						</c:if>
					</td>
				</tr>
			</table>
			<table width="100%" border="0" align="center">
				<tr>
					<td colspan="4" align="center"><html:button value="Buscar" property="" styleClass="botao" onclick="javascript: go('manterItinerario.do?task=buscar');"/></td>
				</tr>
			</table>
			<br>
			<table width="100%" border="0" align="center" class="bordatabela">

				<tr class="fundoescuro">
					<td width="15%" height="20" colspan="3">&nbsp;</td>
					<td width="20%"  align="center">Origem</td>
					<td width="20%" align="center">Destino</td>
					<td width="25%" align="center">Tempo (hh:mm)</td>
					<td width="25%" align="center">Valor (em R$)</td>
				</tr>

			<logic:empty name="manterItinerarioForm" property="listaItinerario">
				<tr>
					<td align="center" colspan="8" class="texto">Nenhuma itinerário foi cadastrado!</td>
				</tr>
			</logic:empty>
			<logic:notEmpty name="manterItinerarioForm" property="listaItinerario">
				<logic:iterate id="itinerario" name="manterItinerarioForm" property="listaItinerario">
					<tr class="fundoclaro">
					<td align="center">
						<a href="javascript: selecionar('ALTERAR', <c:out value="${itinerario.seqItinerario}"/>)">
							<img title="Editar!" src="images/icon_editar3off.png" height="20" width="20" border="0" onmouseover="mudaImagemOver(this,'editar');" onmouseout="mudaImagemOut(this, 'editar')">
						</a>
					</td>
					<td align="center">
						<a href="javascript: selecionar('DELETAR', <c:out value="${itinerario.seqItinerario}"/>)">
							<img title="Deletar!" src="images/icon_lixeira3off.png" height="20" width="20" border="0" onmouseover="mudaImagemOver(this,'deletar');" onmouseout="mudaImagemOut(this, 'deletar')">
						</a>
					</td>
					<td align="center">
								<a
									href="javascript: selecionar('PESQUISAR','<c:out value="${itinerario.seqItinerario}"/>')">
									<img title="Pesquisar!" src="images/zoomoff.png" border="0"
										height="20" width="20" border="0"
										onmouseover="mudaImagemOver(this,'pesquisar');"
										onmouseout="mudaImagemOut(this, 'pesquisar')"> </a>

							</td>
					<td align="left"><bean:write name="itinerario" property="rodoviariaOrigemVO.nomRodoviaria"/></td>
					<td align="left"><bean:write name="itinerario" property="rodoviariaDestinoVO.nomRodoviaria"/></td>
					<td align="center"><bean:write name="itinerario" property="tempoViagem"/></td>
					<td align="right">
					<c:set var="total" value="0"/>
							<logic:iterate id="it" name="itinerario" property="listaTarifas">
								<c:set var="total" value="${total + it.valor}"/>
							</logic:iterate>
					<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${total+itinerario.valorPassagem}"/></td>
				</tr>
				</logic:iterate>
			</logic:notEmpty>
			</table>
		</td>
	</tr>
</table>
</html:form>