<%@ include file="/jsp/common/taglibs.jsp" %>
<script>
function confirmar(acao) {
	var frm = document.forms[0];
	if(acao == "INCLUIR"){
		frm.task.value = "incluir";
	}
	if(acao == "ALTERAR"){
		frm.task.value = "alterar";
	}
	if(acao == "DELETAR"){
		frm.task.value = "deletar";
	}
	frm.submit();
}
function inicio(flag) {
	var frm = document.forms[0];
	frm.busca.value = flag;
	frm.task.value = "unspecified";
	frm.submit();
}
function getTarifa(acao,seq) {
	var frm = document.forms[0];
	if(acao == "alterar"){
		frm.acao.value = "ALTERAR";
	}
	if(acao == "deletar"){
		frm.acao.value = "DELETAR";
	}
	frm.seqTarifa.value = seq;
	frm.task.value = "getTarifa";
	frm.submit();
}

</script>

<html:form action="/manterTarifa">

<html:hidden name="manterTarifaForm" property="task"/>
<html:hidden name="manterTarifaForm" property="seqTarifa"/>
<html:hidden name="manterTarifaForm" property="acao"/>
<html:hidden name="manterTarifaForm" property="busca"/>
<table width="600" border="0" align="center">
	<tr>
		<td>
			<jsp:include page="/jsp/common/mensagens.jsp" />
			
			<table width="100%" border="0" cellpadding="0" cellspacing="2" align="center" >
				<tr>
					<td class="titulo">ManterTarifa</td>
				</tr>
			</table>	
			<table width="100%" border="0" align="center" id="inserir" class="bordatabela">
				<tr class="fundoescuro" align="center">
					<td width="20%" height="20">Ação</td>					
					<td width="40%">
						Nome da Tarifa
					</td>
					<td width="40%">
						Valor
					</td>
					<td width="20%" colspan="3">&nbsp;</td>
				</tr>
				<tr class="fundoclaro">
					<c:set var="disable" value="false"/>
					<logic:equal name="manterTarifaForm" property="acao" value="DELETAR">
						<td align="center" style="color: #FF0000">
						<c:set var="disable" value="true"/>
					</logic:equal>
					<logic:notEqual name="manterTarifaForm" property="acao" value="DELETAR">
						<td align="center" style="color: #0000FF">
					</logic:notEqual>
						<b><bean:write name="manterTarifaForm" property="acao"/></b></td>
					<c:if test="${manterTarifaForm.acao eq 'ALTERAR'}">
					<td>
						<html:text name="manterTarifaForm" size="40" property="tarifaVO.nomTarifa" styleClass="inputobrigatorio" disabled="${disable}"/>
					</td>
					<td>
						<html:text name="manterTarifaForm" size="40" property="tarifaVO.valor" styleClass="inputobrigatorio" disabled="${disable}" onkeypress="return formataCampoDecimal(6,this,event,false,false,true)"/>
					</td>
					</c:if>	
					<c:if test="${manterTarifaForm.acao ne 'ALTERAR'}">
					<td>
						<html:text name="manterTarifaForm" size="40" property="tarifaVO.nomTarifa" styleClass="input" disabled="${disable}"/>
					</td>
					<td>
						<html:text name="manterTarifaForm" size="40" property="tarifaVO.valor" styleClass="input" disabled="${disable}" onkeypress="return formataCampoDecimal(6,this,event,false,false,true)"/>
					</td>
					</c:if>	
					<td align="center"><img title="Pesquisar!" src="images/zoomoff.png" border="0" height="20" width="20" onmouseover="mudaImagemOver(this,'pesquisar');" onmouseout="mudaImagemOut(this, 'pesquisar')" onclick="javascript: inicio('pesquisar');"></td>
					<td align="center"><img title="Confirmar!" src="images/acceptoff.png" border="0" height="20" width="20" onmouseover="mudaImagemOver(this,'confirmar');" onmouseout="mudaImagemOut(this, 'confirmar')" onclick="javascript: confirmar('<bean:write name="manterTarifaForm" property="acao"/>');"></td>
					<td align="center"><img title="Cancelar!" src="images/deleteoff.png" border="0" height="20" width="20" onmouseover="mudaImagemOver(this,'cancelar');" onmouseout="mudaImagemOut(this, 'cancelar')" onclick="javascript: inicio('');"></td>
				</tr>
			</table>
			<br>
			<table width="100%" border="0" cellpadding="0" cellspacing="2" align="center" class="bordatabela">
				<tr class="fundoescuro">
					<td width="10%" height="10" colspan="2">&nbsp;</td>
					<td width="45%"  align="center">Nome da Tarifa</td>
					<td width="45%" align="center">Valor(R$)</td>
				</tr>
				<logic:empty name="manterTarifaForm" property="listaTarifas">
					<tr>
						<td align="center" colspan="4" class="texto">
							<br><strong>Nenhuma tarifa foi encontrada!</strong>
						</td>
					</tr>
				</logic:empty>
				<logic:iterate id="varInterno" name="manterTarifaForm" property="listaTarifas" indexId="index">
					<c:if test="${index % 2 != 0}">
						<tr class="fundobranco">
					</c:if>
					<c:if test="${index % 2 == 0}">
						<tr class="fundoclaro">
					</c:if>
						<td><img title="Editar!" src="images/icon_editar3off.png" height="20" width="20" onclick="javascript: getTarifa('alterar',<bean:write name="varInterno" property="seqTarifa"/>);" onmouseover="mudaImagemOver(this,'editar');" onmouseout="mudaImagemOut(this, 'editar')"></td>
						<td><img title="Deletar!" src="images/icon_lixeira3off.png" height="20" width="20" onclick="javascript: getTarifa('deletar', <bean:write name="varInterno" property="seqTarifa"/>);" onmouseover="mudaImagemOver(this,'deletar');" onmouseout="mudaImagemOut(this, 'deletar')"></td>
						<td align="center"><bean:write name="varInterno" property="nomTarifa"/></td>
						<td align="center"><fmt:formatNumber maxFractionDigits="2" minFractionDigits="2" value="${varInterno.valor}"/></td>
					</tr>
				</logic:iterate>
			</table>
		</td>
	</tr>
</table>
</html:form>