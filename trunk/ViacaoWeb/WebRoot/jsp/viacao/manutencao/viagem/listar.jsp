<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript">

function recuperar(seqViagem, acao){
	var frm = document.forms[0];
		frm.seqViagem.value = seqViagem;
	if(acao == 'ALTERAR'){
		frm.task.value = 'alterar';
	}
	if(acao == 'DELETAR'){
		frm.task.value = 'deletar';
	}
	if(acao == 'CONSULTAR'){
		frm.task.value = 'consultar';
	}	
	frm.submit();
}

$(function() {
		$( "#datepicker" ).datepicker({
			changeMonth: true,
			changeYear: true,
			showAnim: 'slideDown' 
		});
	});
</script>

<link href="css/portal.css" rel="stylesheet" type="text/css">

<html:form action="/manterViagem">

<html:hidden name="manterViagemForm" property="task"/>
<html:hidden name="manterViagemForm" property="seqViagem"/>

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
								<a href="manterViagem.do?task=paginaCadastrarViagem">Cadastrar Nova Viagem</a>
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
							<td class="texto" width="20%" height="20" align="left">Origem
							</td>
							<td width="30%">
								<html:text name="manterViagemForm" property="viagemVO.itinerarioVo.rodoviariaOrigemVO.nomRodoviaria" size="35" styleClass="input"/>
							</td>
							<td class="texto" width="20%" height="20" align="left">Destino
							</td>
							<td width="30%">
								<html:text name="manterViagemForm" property="viagemVO.itinerarioVo.rodoviariaDestinoVO.nomRodoviaria" size="30" styleClass="input"/>
							</td>
						</tr>
						<tr class="fundoclaro">
							<td class="texto" height="20" align="left">Tipo de Ônibus	
							</td>
							<td >
								<html:text name="manterViagemForm" property="viagemVO.onibusVO.tipo" styleClass="input"/>
							</td>
							<td class="texto" height="20" align="left">Data
							</td>
							<td >
								<html:text name="manterViagemForm" property="viagemVO.horaSaida.data" styleClass="input" size="12" styleId="datepicker"/>
							</td>
						<tr class="fundoclaro">
							<td align="left" class="texto">Hora Saída
							</td>
							<td >
								<html:text name="manterViagemForm" property="viagemVO.horaSaida.horaMinuto" maxlength="4" size="5" styleClass="input" onkeypress="return somenteNumero(this, event,false,false,false);" onchange="formataHoraMin(this);"/>
							</td>
							<td align="left" class="texto">Hora Chegada
							</td>
							<td >
								<html:text name="manterViagemForm" property="viagemVO.horaChegada.horaMinuto" maxlength="4" size="5" styleClass="input" onkeypress="return somenteNumero(this, event,false,false,false);" onchange="formataHoraMin(this);"/>
							</td>
						</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center">
					<tr>
						<td colspan="4" align="center">
							<html:button styleClass="botao" value="Buscar" title="Consultar" property="" onclick="go('manterViagem.do?task=listarViagem')"/>
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" class="bordatabela">
					<tr class="fundoescuro">
						<td width="10%" colspan="3" align="center">
						</td>
						<td width="25%"  align="center">Origem
						</td>
						<td width="25%" align="center">Destino
						</td>
						<td width="10%" align="center">Tipo de Ônibus
						</td>
						<td width="10%" align="center">Data
						</td>
						<td width="10%" align="center">Hora Saída
						</td>
						<td width="10%" align="center">Hora Chegada
						</td>
					</tr>
						<logic:iterate id="lista" name="manterViagemForm" property="listaViagem">
							<tr class="fundoclaro">
								<td align="center">
									<a href="javascript: recuperar('<c:out value="${lista.seqViagem}"/>', 'ALTERAR')">
										<img title="Editar" src="images/icon_editar3off.png"
											height="20" width="20" border="0"
											onmouseover="mudaImagemOver(this,'editar');"
											onmouseout="mudaImagemOut(this, 'editar')"> </a>
								</td>
								<td align="center">
									<a href="javascript: recuperar('<c:out value="${lista.seqViagem}"/>', 'DELETAR')">
										<img title="Deletar" src="images/icon_lixeira3off.png"
											height="20" width="20" border="0"
											onmouseover="mudaImagemOver(this,'deletar');"
											onmouseout="mudaImagemOut(this, 'deletar')"> </a>
								</td>
								<td align="center">
									<a href="javascript: recuperar('<c:out value="${lista.seqViagem}"/>', 'CONSULTAR')">
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
										<bean:write name="lista" property="horaSaida.horaMinuto"/>
									</td>
									<td align="center">
										<bean:write name="lista" property="horaChegada.horaMinuto"/>
									</td>
						</logic:iterate>
				</table>
			</td>
		</tr>
	</table>
</html:form>
