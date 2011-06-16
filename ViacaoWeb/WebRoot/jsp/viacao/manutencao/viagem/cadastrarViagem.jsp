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
	frm.task.value = 'cadastrarViagem';
}
</script>

<link href="css/portal.css" rel="stylesheet" type="text/css">

<form action="/manterViagem">
	<table width="600" border="0" align="center">
		<tr>
			<td>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Cadastro de Viagem
						</td>
					</tr>
				</table>
				<br>
				
				<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">Cadastro de Viagem
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="15%">Itinerário
						</td>
						<td width="85%" colspan="3">
							<select name="Origem" size="1">
								<option selected="selected">Itinerário
								<option>Rio de Janeiro - Juiz de Fora
								<option>Rio de Janeiro - Petrópolis
								<option>Juiz de Fora - Rio de Janeiro
								<option>Juiz de Fora - Petrópolis
							</select>
						</td>
					</tr>
					
					<tr class="fundoclaro">
						<td class="texto" align="center" width="15%">Tipo
						</td>
						<td width="35%">
							<select name="Origem" size="1">
								<option selected="selected">Ônibus
								<option>Convencional
								<option>Convencional c/ ar
								<option>Executivo
							</select>
						</td>
						<td class="texto" align="center" width="18%">Data
						</td>
						<td width="32%"><input class="input" size="15" value="" align="center"> 
							<img src="images/icone-calendario.jpg" align="center"/>
						</td>
					</tr>
					
					<tr class="fundoclaro">
						<td align="center" width="15%" class="texto">Hora de partida
						</td>
						<td width="15%"><input class="input" size="8" value=""/>
						<td align="center" width="18%" class="texto">Hora de chegada
						</td>
						<td width="32%"><input class="input" size="8" value="">
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center"><input class="botao" value="Voltar"/>
						<td align="center"><input class="botao" value="Cadastrar"/>
						<td align="center"><input class="botao" value="Limpar"/>
					</tr>
				</table>
			</td>
		</tr>
	</table>	
</form>