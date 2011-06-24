<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link type="text/css" href="css/custom-theme/jquery-ui-1.8.13.custom.css" rel="stylesheet"/>	
<script type="text/javascript" src="js/jquery-1.5.1.min.js"/>
<script type="text/javascript" src="js/jquery-ui-1.8.13.custom.min.js"/>
<script type="text/javascript"/>




<link href="css/portal.css" rel="stylesheet" type="text/css">

<html:form action="/manterViagem">
<html:hidden property="task" name="manterViagemForm"/>
<html:hidden property="acao" name="manterViagemmanterForm"/>
<html:hidden property="empresaParam" name="manterViagemForm"/>
<html:hidden property="tipoParam" name="manterViagemForm"/>
<html:hidden property="qtdPoltronaParam" name="manterViagemForm"/>
<html:hidden property="placaParam" name="manterViagemForm"/>
<html:hidden property="seqOnibus" name="manterViagemForm"/>