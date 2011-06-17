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
function getExemplo(acao,seq) {
	var frm = document.forms[0];
	if(acao == "alterar"){
		frm.acao.value = "ALTERAR";
	}
	if(acao == "deletar"){
		frm.acao.value = "DELETAR";
	}
	frm.seqExemplo.value = seq;
	frm.task.value = "getExemplo";
	frm.submit();
}
function oi(){
}
</script>

<html:form action="/exemplo">

<html:hidden name="exemploForm" property="task"/>
<html:hidden name="exemploForm" property="seqExemplo"/>
<html:hidden name="exemploForm" property="acao"/>
<html:hidden name="exemploForm" property="busca"/>
<table width="600" border="0" align="center">
	<tr>
		<td>
			<jsp:include page="/jsp/common/mensagens.jsp" />
			
			<table width="100%" border="0" cellpadding="0" cellspacing="2" align="center" >
				<tr>
					<td class="titulo">Exemplo</td>
				</tr>
			</table>	
			<table width="100%" border="0" align="center" id="inserir" class="bordatabela">
				<tr class="fundoescuro" align="center">
					<td class="texto" width="20%" height="20">Ação</td>					
					<td width="40%" class="texto">
						Nome do exemplo
					</td>
					<td width="40%" class="texto">
						Descrição do exemplo
					</td>
					<td width="20%" colspan="3">&nbsp;</td>
				</tr>
				<tr class="fundoclaro">
					<c:set var="disable" value="false"/>
					<logic:equal name="exemploForm" property="acao" value="DELETAR">
						<td align="center" style="color: #FF0000">
						<c:set var="disable" value="true"/>
					</logic:equal>
					<logic:notEqual name="exemploForm" property="acao" value="DELETAR">
						<td align="center" style="color: #0000FF">
					</logic:notEqual>
						<b><bean:write name="exemploForm" property="acao"/></b></td>
					<td>
						<html:text name="exemploForm" size="40" property="exemploVO.nomeExemplo" styleClass="input" disabled="${disable}"/>
					</td>
					<td>
						<html:text name="exemploForm" size="40" property="exemploVO.descricao" styleClass="input" disabled="${disable}"/>
					</td>
					<td align="center"><img title="Pesquisar!" src="images/icon_lupa.gif" onclick="javascript: inicio('pesquisar');"></td>
					<td align="center"><img title="Confirmar!" src="images/confirmar.gif" onclick="javascript: confirmar('<bean:write name="exemploForm" property="acao"/>');"></td>
					<td align="center"><img title="Cancelar!" src="images/cancelar.gif" onclick="javascript: inicio('');"></td>
				</tr>
			</table>
			<br>
			<table width="100%" border="0" cellpadding="0" cellspacing="2" align="center" class="bordatabela">
				<tr class="fundoescuro">
					<td width="10%" height="20" colspan="2">&nbsp;</td>
					<td width="45%"  align="center">Nome do Exemplo</td>
					<td width="45%" align="center">Descricao</td>
				</tr>
				<logic:empty name="exemploForm" property="listaExemplo">
					<tr>
						<td align="center" colspan="4" class="texto">Nenhum exemplo foi cadastrado!!</td>
					</tr>
				</logic:empty>
				<logic:iterate id="varInterno" name="exemploForm" property="listaExemplo" indexId="index">
					<c:if test="${index % 2 == 0}">
						<tr class="fundobranco">
					</c:if>
					<c:if test="${index % 2 != 0}">
						<tr class="fundoclaro">
					</c:if>
						<td><img title="Editar!" src="images/icon_editar.gif" onclick="javascript: getExemplo('alterar',<bean:write name="varInterno" property="seqExemplo"/>);"></td>
						<td><img title="Deletar!" src="images/icon_lixeira.gif" onclick="javascript: getExemplo('deletar', <bean:write name="varInterno" property="seqExemplo"/>);"></td>
						<td align="center"><bean:write name="varInterno" property="nomeExemplo"/></td>
						<td align="center"><bean:write name="varInterno" property="descricao"/></td>
					</tr>
				</logic:iterate>
			</table>
		</td>
	</tr>
</table>
</html:form>