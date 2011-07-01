<%@ include file="/jsp/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<link href="css/portal.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/custom-theme/jquery-ui-1.8.13.custom.css" type="text/css"></link>

<script type="text/javascript" src="js/jquery-ui-1.8.13.custom.min.js"></script>
<script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>

<script type="text/javascript">

function cadastrar(){
	var frm = document.forms[0];
	frm.task.value = 'cadastrarViagem';
	frm.submit();
}

function voltar(){
	var frm = document.forms[0];
	frm.task.value = 'unspecified';
	frm.submit();
}

function adicionar() {
	var frm = document.forms[0];
	frm.task.value = "adicionarLista";	
	frm.submit();
}

function remover() {
	var frm = document.forms[0];
	frm.task.value = "removerLista";
	frm.submit();
}

$(function() {
	$( "#datepicker" ).datepicker({
		showOn: "button",
		buttonImage: "images/calendar.gif",
		buttonImageOnly: true
	});
});
</script>


<html:form action="/manterViagem">

<html:hidden name="manterViagemForm" property="task"/>
<html:hidden name="manterViagemForm" property="viagemVO"/>
<html:hidden name="manterViagemForm" property="listaViagem"/>
<html:hidden name="manterViagemForm" property="listaItinerario"/>
<html:hidden name="manterViagemForm" property="listaOnibus"/>
<html:hidden name="manterViagemForm" property="acao"/>
<html:hidden name="manterViagemForm" property="cadastrar"/>

	<table width="600" border="0" align="center">
		<tr>
			<td>
			<jsp:include page="/jsp/common/mensagens.jsp"/>
			<table width="100%" border="0" align="center">
				<tr>
					<td class="titulo">Cadastrar Viagem
					</td>
				</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Cadastramento de Viagens
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
					<tr class="fundoclaro">
						<td class="texto" width="20%" height="20" align="left">Itinerário
						</td>
						<td width="37%">
							<html:select name="manterViagemForm" property="viagemVO.itinerarioVo.seqItinerario" styleId="lista" styleClass="input">
    							<html:optionsCollection  name="manterViagemForm" property="listaItinerario" label="origemDestino" value="seqItinerario"/>
    						</html:select>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="13%" height="20" align="left">Tipo de Ônibus
						</td>
						<td width="37%">
							<html:select name="manterViagemForm" property="viagemVO.onibuisVO.seqOnibus" styleId="lista" styleClass="input">
								<html:optionsCollection  name="manterViagemForm" property="listaOnibus" label="listaTipoOnibus" value="seqOnibus"/>	
    						</html:select>
						</td>
						<td class="texto" width="13%" height="20" align="left">Data
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaSaida" styleClass="input"/><img src="images/calendar.gif" styleId="datepicker"/>
						</td>	
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="05%" align="left">Hora Saída
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaSaida" styleClass="input"/>
						</td>
						<td class="texto" width="05%" align="left">Hora Chegada
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaChegada" styleClass="input"/>
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center">
							<img title="Voltar" property="" src="images/seta-esquerda.gif.png" border="0" height="20" width="20" onclick="executar();"/>
						</td>	
						<td align="center">
							<html:reset title="Limpar" styleClass="botao" value="Limpar"/>
						</td>	
						<td align="center">
							<img title="Confirmar Cadastro" property="" src="images/confirmar.png" border="0" height="20" width="20" onclick="confirmar();"/>
						</td>	
					</tr>
			</table>
		</tr>
	</table>	
</html:form>