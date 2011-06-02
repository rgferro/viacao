<%@ include file="taglibs.jsp"%> 

<logic:messagesPresent message="true">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0" class="texto">
	
		<!-- MENSAGENS DE ERRO -->
		<html:messages  id="messages" message="true" property="ERRO">
			<tr>
				<td width="10%">
					<img src='images/icon_erro.gif' border=0 /> 
				</td>
				<td>
					<b><c:out value="${messages}" escapeXml="false"/></b>
				</td>
			</tr>
		</html:messages>
		
		<!-- MENSAGENS DE SUCESSO -->
		<html:messages  id="messages" message="true" property="SUCESSO">
			<tr>
				<td width="10%">
					<img src='images/icon_sucesso.gif' border=0 /> 
				</td>
				<td>
					<b><c:out value="${messages}" escapeXml="false"/></b>
				</td>
			</tr>
		</html:messages>
		<!-- MENSAGENS DE AVISO -->
		<html:messages  id="messages" message="true" property="AVISO">
			<tr>
				<td width="10%">
					<img src='images/icon_atencao.gif' border=0 /> 
				</td>
				<td>
					<b><c:out value="${messages}" escapeXml="false"/></b>
				</td>
			</tr>
		</html:messages>
	</table>
</logic:messagesPresent>
<BR>