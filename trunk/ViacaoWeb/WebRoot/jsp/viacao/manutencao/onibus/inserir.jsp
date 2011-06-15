<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>  
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
function cadastrar(){
	frm = document.forms[0];
	frm.task.value = 'inserirOnibus';
}
</script>

<link href="css/portal.css" rel="stylesheet" type="text/css">

<form action="/manterOnibus">
	<table width="600" border="0" align="center">
		<tr>
			<td>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Cadastro de Ônibus</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">Cadastro de Ônibus</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="18%">Empresa</td>
						<td width="32%" align="left">
							<html:text name="manterOnibusForm" property="onibusVO.empresa"/>
						</td>
						<td class="texto" align="center" width="05%">Tipo</td>
						<td width="45%" align="left">
							<html:text name="manterOnibusForm" property="onibusVO.tipo"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="18%">Qtd de Poltrona</td>
						<td width="32%" align="left">
							<html:text name="manterOnibusForm" property="onibusVO.qtdPoltrona"/>
						</td>
						<td class="texto" align="center" width="05%">Placa</td>
						<td width="45%" align="left">
							<html:text name="manterOnibusForm" property="onibusVO.placa"/>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center">
							<html:button value="Voltar" property="" styleClass="botao"
								onclick="<%request.getContextPath();%>task=?unspecified"/>
						</td>
						<td align="center">
							<html:button value="Cadastrar" property="" styleClass="botao" onclick="cadastrar();"/>
						</td>
						<td align="center">
							<html:reset value="Limpar" styleClass="botao"/>							
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>
