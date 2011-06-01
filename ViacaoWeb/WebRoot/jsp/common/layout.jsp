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
<jsp:include page="cabecalho.jsp"></jsp:include>
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
