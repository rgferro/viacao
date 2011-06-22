<%@ include file="/jsp/common/taglibs.jsp" %>
<fmt:setLocale value="pt_BR"/>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>

<title><tiles:getAsString name="title"/></title>

<link href="<%=request.getContextPath() %>/css/portal.css" rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath() %>/script/validation.js"></script>
<script src="<%=request.getContextPath() %>/js/viacao.js"></script>

<c:set var="clienteVO" value="<%= request.getSession().getAttribute("clienteVO")%>"></c:set>
<c:set var="adm" value="<%= request.getSession().getAttribute("Adm")%>"></c:set>

<c:if test="${clienteVO == null && adm == null}">
	<jsp:include page="cabecalhoGeral.jsp"></jsp:include>
</c:if>
<c:if test="${clienteVO != null}">
	<jsp:include page="cabecalhoCliente.jsp"></jsp:include>
</c:if>
<c:if test="${adm != null}">
	<jsp:include page="cabecalhoAdm.jsp"></jsp:include>
</c:if>

</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td class="portaltitulo" align="center"></td>
	</tr>

	<tr>
		<td>
			<table width="800" align="center" border="0">
				<tr>
					<td>
					&nbsp;
<tiles:insert attribute="body" />
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
</table>

</body>
</html>
