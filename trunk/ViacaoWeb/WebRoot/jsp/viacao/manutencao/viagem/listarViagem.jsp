<%@ include file="/jsp/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<link type="text/css" href="css/custom-theme/jquery-ui-1.8.13.custom.css" rel="stylesheet"/>	
<script type="text/javascript" src="js/jquery-1.5.1.min.js">

<script type="text/javascript">

function buscar(){
	var frm = document.forms[0];
		frm.task.value ='listar';
	frm.submit();
}
function recuperarViagem(seqViagem, acao){
	var frm = document.forms[0];
		frm.acao.value = acao;
		frm.seqViagem.value = seqViagem;
		frm.task.value = 'alterar';
	frm.submit();

}

function mudaImagemOver(obj, acao){

	if(acao == "editar"){
		obj.src = 'images/icon_editar3.png';
	}
	if(acao == "deletar"){
		obj.src = 'images/icon_lixeira3.png';
	}
	if(acao == "confirmar"){
		obj.src = 'images/accept1.png';
	}
	if(acao == "pesquisar"){
		obj.src = 'images/zoom.png';
	}
	if(acao == "cancelar"){
		obj.src = 'images/delete1.png';
	}

}

function mudaImagemOut(obj, acao){

	if(acao == "editar"){
		obj.src = 'images/icon_editar3off.png';
	}
	if(acao == "deletar"){
		obj.src = 'images/icon_lixeira3off.png';
	}
	if(acao == "confirmar"){
		obj.src = 'images/acceptoff.png';
	}
	if(acao == "pesquisar"){
		obj.src = 'images/zoomoff.png';
	}
	if(acao == "cancelar"){
		obj.src = 'images/deleteoff.png';
	}

}
</script>

<link href="css/portal.css" rel="stylesheet" type="text/css">

<html:form action="/manterViagem">

<html:hidden name="manterViagemForm" property="task"/>
<html:hidden name="manterViagemForm" property="viagemVO"/>
<html:hidden name="manterViagemForm" property="listaViagem"/>
<html:hidden name="manterViagemForm" property="listaItinerario"/>
<html:hidden name="manterViagemForm" property="listaOnibus"/>
<html:hidden name="manterViagemForm" property="seqViagem"/>
<html:hidden name="manterViagemForm" property="seqOnibus"/>
<html:hidden name="manterViagemForm" property="acao"/>

	<table width="600" border="0" align="center">
		<tr>
			<td>
				<jsp:include page="/jsp/common/mensagens.jsp" />
					<table width="100%" border="0" align="center">
						<tr>
							<td class="titulo">Viagens</td>
						</tr>
					</table>
					<table>
						<tr>
							<td class="link"><img src="images/fetch.gif"/>
								<a href="<%request.getContextPath();%>?task=paginaCadastrarViagem&acao=CADASTRAR">Cadastrar Nova Viagem ?</a>
							</td>
						</tr>
					</table>
					<table width="100%" border="0" align="center" id="consulta" class="bordatabela">
					<tr class="fundoescuro">
							<td class="texto" colspan="4" align="center">Busca de Viagens
							</td>
						</tr>
					</table>
					<table width="100%" border="0" align="center" id="consulta" class="bordatabela">
						<tr class="fundoclaro">
							<td class="texto" width="13%" height="20" align="left">Origem
							</td>
							<td width="37%">
								<html:text name="manterViagemForm" property="viagemVO.itinerarioVo.rodoviariaOrigemVO.nomRodoviaria" size="35" styleClass="input"/>
							</td>
							<td class="texto" width="18%" height="20" align="left">Destino
							</td>
							<td width="32%">
								<html:text name="manterViagemForm" property="viagemVO.itinerarioVo.rodoviariaDestinoVO.nomRodoviaria" size="30" styleClass="input"/>
							</td>
						</tr>
						<tr class="fundoclaro">
							<td class="texto" height="20" align="left">Tipo de Ônibus	
							</td>
							<td width="37%">
								<html:text name="manterViagemForm" property="viagemVO.onibusVO.tipo" styleClass="input"/>
							</td>
							<td class="texto" height="20" align="left">Data
							</td>
							<td width="37%">
								<html:text name="manterViagemForm" property="viagemVO.horaSaida.data" styleClass="input"/><img src="images/calendar.gif" styleId="datepicker"/>
							</td>
						<tr class="fundoclaro">
							<td align="left" class="texto">Hora Saída
							</td>
							<td width="37%">
								<html:text name="manterViagemForm" property="viagemVO.horaSaida" styleClass="input"/>
							</td>
							<td align="left" class="texto">Hora Chegada
							</td>
							<td width="37%">
								<html:text name="manterViagemForm" property="viagemVO.horaChegada" styleClass="input"/>
							</td>
						</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center">
					<tr>
						<td colspan="4" align="center">
							<html:button styleClass="botao" value="Buscar" title="Consultar" property="" onclick="pesquisar();"/>
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" class="bordatabela">
					<tr class="fundoescuro">
						<td width="15%" colspan="3" align="center">
						</td>
						<td width="15%"  align="center">Origem
						</td>
						<td width="15%" align="center">Destino
						</td>
						<td width="15%" align="center">Tipo de Ônibus
						</td>
						<td width="15%" align="center">Data
						</td>
						<td width="15%" align="center">Hora Saída
						</td>
						<td width="15%" align="center">Hora Chegada
						</td>
					</tr>
						<logic:iterate id="lista" name="manterViagemForm" property="listaViagem">
							<tr class="fundoclaro">
								<td align="center">
									<a href="javascript: recuperar('<c:out value="${idLista.seqViagem}"/>', 'ALTERAR')">
										<img title="Editar" src="images/icon_editar3off.png"
											height="20" width="20" border="0"
											onmouseover="mudaImagemOver(this,'editar');"
											onmouseout="mudaImagemOut(this, 'editar')"> </a>
								</td>
								<td align="center">
									<a href="javascript: recuperar('<c:out value="${idLista.seqViagem}"/>', 'DELETAR')">
										<img title="Deletar" src="images/icon_lixeira3off.png"
											height="20" width="20" border="0"
											onmouseover="mudaImagemOver(this,'deletar');"
											onmouseout="mudaImagemOut(this, 'deletar')"> </a>
								</td>
								<td align="center">
									<a href="javascript: recuperar('<c:out value="${idLista.seqViagem}"/>', 'CONSULTAR')">
										<img title="Pesquisar" src="images/zoomoff.png" border="0"
											height="20" width="20" border="0"
											onmouseover="mudaImagemOver(this,'pesquisar');"
											onmouseout="mudaImagemOut(this, 'pesquisar')"> </a>
	
								</td>
								<td align="center">
									<bean:write name="lista" property="itinerarioVo.rodoviariaOrigemVO.nomRodoviaria"/>
								</td>
									<td align="center">
										<bean:write name="lista" property="itinerarioVo.rodoviariaDestinoVO.nomRodoviaria"/>
									</td>
									<td align="center">
										<bean:write name="lista" property="onibusVO.tipo"/>
									</td>
									<td align="center">
										<bean:write name="lista" property="horaSaida.data"/>
									</td>
									<td align="center">
										<bean:write name="lista" property="horaSaida.horaMinutoSegundo"/>
									</td>
									<td align="center">
										<bean:write name="lista" property="horaChegada.horaMinutoSegundo"/>
									</td>
						</logic:iterate>
				</table>
			</td>
		</tr>
	</table>
</html:form>
