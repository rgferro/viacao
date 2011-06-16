<%@ include file="/jsp/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<style>
	/*Define a classe dos alarmes*/
	#alarme{
			z-index:3000;
			background-color:#E4F1F1;
			display:none;
			position:absolute;
			top:45%;
			left:49%;
			margin-left:-150px;
			margin-top:-100px;
			padding:10px;
			width:300px;
			height:200px;
			border:1px solid #d0d0d0;
		}
	
	/*Bloqueando a pagina durante o pop up*/
	#tela{
			z-index:2000;
			display:none;
			position:absolute;
			padding:10px;
			width:800px;
			height:100%;
		}
</style>

<script type="text/javascript">
function excluir(){
	var frm = document.forms[0];
	frm.task.value = 'deletarOnibus';
	frm.submit();
}

function abrirPopUp(){
	document.getElementById('alarme').style.display='block';
	document.getElementById('tela').style.display='block';
}
	
function fecharPopUp(){
	document.getElementById('alarme').style.display='none';
	document.getElementById('tela').style.display='none';
}
</script>

<link href="css/portal.css" rel="stylesheet" type="text/css">

<html:form action="/manterOnibus">
<html:hidden property="task" name="manterOnibusForm"/>

	<div class="alarme" id="alarme">
		<br><br>
		<p align="center"><b>Tem certeza que deseja excluir o Ônibus?</b></p>
		<br><br>
		<table align="center" border="0">
			<tr>
				<td align="center">
					<input type="submit" value="Sim" class="botao" onclick="javascript: excluir();">	
				</td>
				<td align="center">
					<input type="submit" value="Não" class="botao" onclick="javascript: fecharPopUp();">
				</td>
			</tr>
		</table>
	</div>
	
	<div class="tela" id="tela"></div>
	
	<table width="600" border="0" align="center">
		<tr>
			<td>
			<jsp:include page="/jsp/common/mensagens.jsp" />
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
						<td class="texto" width="18%" height="20" align="center">Empresa</td>
						<td width="32%">
							<html:text disabled="true" name="manterOnibusForm" property="onibusVO.empresa" styleClass="input"/>
						</td>
						<td class="texto" width="05%" height="20">Tipo</td>
						<td width="45%">
							<html:text disabled="true" name="manterOnibusForm" property="onibusVO.tipo" styleClass="input"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="18%" height="20" align="center">Qtd Poltronas</td>
						<td width="32%">
							<html:text disabled="true" onkeypress="return somenteNumero(this,event,false,false,false)" maxlength="3" name="manterOnibusForm" property="onibusVO.qtdPoltronas" styleClass="input"/>
						</td>
						<td class="texto" width="05%" height="20" align="center">Placa</td>
						<td width="45%">
							<html:text disabled="true" onkeypress="return formataPlaca(this,event,true)" name="manterOnibusForm" property="onibusVO.placa" styleClass="input"/>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center">
							<html:button value="Voltar" property="" styleClass="botao" onclick="voltar();"/>
						</td>
						<td align="center">
							<html:button value="Excluir" property="" styleClass="botao" onclick="abrirPopUp();"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</html:form>
