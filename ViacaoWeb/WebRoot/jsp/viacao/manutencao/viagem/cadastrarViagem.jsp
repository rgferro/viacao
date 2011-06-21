<%@ include file="/jsp/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


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
</script>


<link href="css/portal.css" rel="stylesheet" type="text/css">
<html:form action="/manterViagem">
<html:hidden property="task" name="manterViagemForm"/>
	<table width="600" border="0" align="center">
		<tr>
			<td>
			<jsp:include page="/jsp/common/mensagens.jsp" />
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Cadastramento de Viagens
						</td>
					</tr>
					<br>
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">Cadastrar Viagem
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
					<tr class="fundoclaro">
						<td class="texto" width="13%" height="20" align="center">Itinerário
						</td>
						<td width="37%">
							<html:select name="manterViagemForm" property="viagemVO.itinerarioVo.seqItinerario" styleId="lista" styleClass="inputobrigatorio">
    							<html:option value="">SELECIONE</html:option>
    							<html:optionsCollection  name="manterViagemForm" property="listaItinerario" label="origemDestino" value="seqItinerario"/>
    						</html:select>
						</td>
						<td class="texto" width="13%" height="20" align="center">Data
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaSaida.data"/><img src="images/icone-calendario.jpg" class="link" align="center"/>
						</td>	
					</tr>
					<br>
					<tr class="fundoclaro">
						<td class="texto" width="05%" align="center">Hora Saída
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaSaida.horaMinutoSegundo"/>
						</td>
						<td class="texto" width="05%" align="center">Hora Chegada
						</td>
						<td width="37%">
							<html:text name="manterViagemForm" property="viagemVO.horaChegada.horaMinutoSegundo"/>
						</td>
					</tr>
					<br>
					<tr class="fundoclaro">
						<td class="texto" width="13%" height="20" align="center">Tipo de Ônibus
						</td>
						<td width="37%">
							<html:select name="manterViagemForm" property="listaOnibus" styleId="lista" styleClass="inputobrigatorio">
    							<html:option value=""></html:option>
    							<logic:iterate id="lista" name="manterViagemForm" property="listaOnibus">
    								<html:option value="${lista.seqOnibus}">
    									<c:out value="${lista.tipo}"/>
    								</html:option>
    							</logic:iterate>
    						</html:select>
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center">
							<html:button styleClass="botao" value="Voltar" property="" onclick="voltar();"/>
						</td>	
						<td align="center">
							<html:button styleClass="botao" value="Cadastrar" property="" onclick="confirmar();"/>
						</td>	
						<td align="center">
							<html:reset styleClass="botao" value="Limpar"/>
						</td>	
					</tr>
				</table>
		</tr>
	</table>	
</html:form>