<%@ include file="/jsp/common/taglibs.jsp" %>

<br>
<div name="divMensagensHeader" id="divMensagensHeader" style="display: none">
	<img src="<%=request.getContextPath()%>images/icon_atencao.gif" align="absmiddle"><span class="portaltexto11"><b><font color="red">Atenção aos erros abaixo:</font></b></span>
</div>
		
<div name="divMensagens" id="divMensagens" class="portaltexto11" style="color:red">
<table width="90%" border="0" cellspacing="3" cellpadding="0">
	<tr> 
	    <td class="portaltexto11">
		<logic:messagesPresent>
		<c:if test="${formJaValidado == 'true'}">
			<html:messages id="error">
				<bean:write name="error" filter="false"/>
			</html:messages>
		</c:if>
		<c:if test="${formJaValidado != 'true'}">
			<img src="<%=request.getContextPath()%>images/icon_atencao.gif" align="absmiddle"><span class="portaltexto11"><b><font color="red">Atenção aos erros abaixo:</font></b></span>
			<ul style="color:red">
			<html:messages id="error">
				<li><span class="portaltexto11" style="color:red"><bean:write name="error" filter="false"/></span></li>
			</html:messages>
			</ul>
		</c:if>
		<script>
window.scrollTo(0,0);
if(parent) {
	parent.window.scrollTo(0,0);
}
		</script>
		</logic:messagesPresent>
		</td>	
	</tr>  	
	<tr> 
	    <td class="portaltexto11" align="center">
   		<c:if test="${mensagemSucesso != null}">
   			<img src="<%=request.getContextPath()%>images/icon_sucesso.gif" align="absmiddle"><c:out value="${requestScope.mensagemSucesso}" escapeXml="false" />
		</c:if>
   		<c:if test="${mensagemAtencao != null}">
   			<img src="<%=request.getContextPath()%>images/icon_atencao.gif" align="absmiddle"> <c:out value="${requestScope.mensagemAtencao}" escapeXml="false" />
		</c:if>
		</td>
	</tr>  	
</table>	
</div>
<br>