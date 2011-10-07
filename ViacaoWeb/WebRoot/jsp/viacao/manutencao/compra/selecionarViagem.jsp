<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript">

	function buscar(obj){
		var frm = document.forms[0];
		if(obj == 'novaBusca'){
			frm.task.value = 'unspecified';
		}else{
			frm.task.value = 'buscaViagens';
		}
		frm.submit();
	}

	function abre(acao){
		if(acao == 'idaVolta'){
			document.getElementById('idaVolta').style.display = '';
		}else{ 
			document.getElementById('idaVolta').style.display = 'none';
		} 
	}
	
	function limpar(obj,acao){
		var frm = document.forms[0];
		if(acao == 'origem'){
			frm.seqRodoviariaOrigem.value = obj.value;
			frm.task.value = 'limparDestino';
		}else{
			frm.seqRodoviariaDestino.value = obj.value;
			frm.task.value = 'limparOrigem';
		}
		frm.pagina.value = 'selecionarViagem';
		frm.submit();
	}

	$(function() {
		$( "#datepicker" ).datepicker({
			changeMonth: true,
			changeYear: true,
			showAnim: 'slideDown' 
		});
	});
	
	$(function() {
		$( "#datepicker1" ).datepicker({
			changeMonth: true,
			changeYear: true,
			showAnim: 'slideDown' 
		});
	});
	

</script>

<html:form action="/manterCompra">
<html:hidden property="task" name="manterCompraForm"/>

	<table width="600" border="0" align="center">
		<tr>
			<td>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Consulta de Passagem</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" id="buscar" class="bordatabela">
					<tr class="fundoescuro">
						<td class="texto" align="center" colspan="4">Escolha a origem e o destino que deseja:</td>
					</tr>
					<tr class="fundoclaro">
						<td colspan="4" align="center">
							<html-el:radio name="manterCompraForm" property="tipViagem" value="idaVolta" onclick="abre('idaVolta');"/>Ida e Volta
							<html-el:radio name="manterCompraForm" property="tipViagem" value="volta" onclick="abre('ida');"/>Ida
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="10%">
							Origem
						</td>
						<td width="42%">
							<html:select name="manterCompraForm" property="seqRodoviariaOrigem" styleClass="inputobrigatorio" onchange="limpar(this,'origem');">
								<html:option value="-1">SELECIONE</html:option>
								<html:optionsCollection name="manterCompraForm" property="listaRodoviariaOrigem" label="nomRodoviariaConcatOrigem" value="seqRodoviaria"/>
							</html:select>
						</td>
						<td class="texto" width="08%">
							Destino
						</td>
						<td width="42%">
							<html:select name="manterCompraForm" property="seqRodoviariaDestino" styleClass="inputobrigatorio" onchange="limpar(this,'destino');">
								<html:option value="-1">SELECIONE</html:option>
								<html:optionsCollection name="manterCompraForm" property="listaRodoviariaDestino" label="nomRodoviariaConcatDestino" value="seqRodoviaria"/>
							</html:select>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="10%">
							Data Ida
						</td>
						<td colspan="3">
							<html:text name="manterCompraForm" property="horaSaidaIda.data" styleClass="inputobrigatorio" styleId="datepicker"/>
						</td>
					</tr>
					<tr class="fundoclaro" style="display: '';" id="idaVolta">
						<td class="texto" width="10%">
							Data Volta
						</td>
						<td colspan="3">
							<html:text name="manterCompraForm" property="horaSaidaVolta.data" styleClass="inputobrigatorio" styleId="datepicker1"/>
						</td>
					</tr>
				</table>
				<c:if test="${manterCompraForm.listaViagensIda != null || manterCompraForm.listaViagensIda != null}">
					<table width="100%" border="0" align="center">
						<tr>
							<td colspan="4" align="center">
								<html:button value="Nova Busca" property="" styleClass="botao" onclick="javascript: buscar('novaBusca');"/>
							</td>
						</tr>
					</table>
				</c:if>
				<c:if test="${manterCompraForm.listaViagensIda == null && manterCompraForm.listaViagensIda == null}">
					<table width="100%" border="0" align="center">
						<tr>
							<td colspan="4" align="center">
								<html:button value="Buscar" property="" styleClass="botao" onclick="javascript: buscar();"/>
							</td>
						</tr>
					</table>
				</c:if>
				<br>
				<logic:empty name="manterCompraForm" property="listaViagensIda">
					<jsp:include page="/jsp/common/mensagens.jsp" />
				</logic:empty>
				<logic:notEmpty name="manterCompraForm" property="listaViagensIda">
					<table width="100%" border="0" align="center">
						<tr class="fundoescuro">
							<td class="texto" colspan="8" align="left"><b><i><c:out value="${manterCompraForm.viagemVO.itinerarioVo.rodoviariaOrigemVO.enderecoVO.cidade}"/></b></i> para <i><b><c:out value="${manterCompraForm.viagemVO.itinerarioVo.rodoviariaDestinoVO.enderecoVO.cidade}"/></b></i> - <c:out value="${manterCompraForm.horaSaidaIda}"/></td>
						</tr>
					</table>
					<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
						<tr class="fundoescuro">
							<td width="10%" align="center">Selecione</td>
							<td width="12%" align="center">Hora Partida</td>
							<td width="12%" align="center">Chegada Prevista</td>
							<td width="15%" align="center">Valor</td>
							<td width="15%" align="center">Tipo</td>					
							<td width="10%" align="center">Poltronas vagas</td>
							<td width="14%" align="center">Empresa</td>
						</tr>
						<logic:iterate id="lista" name="manterCompraForm" property="listaViagensIda">
							<tr class="fundoclaro">
								<td align="center"><input type="radio"></td>
								<td align="center"><bean:write name="lista" property="horaSaida.horaMinutoSegundo"/></td>
								<td align="center"><bean:write name="lista" property="horaChegada.horaMinutoSegundo"/></td>
								<td align="center"><bean:write name="lista" property="itinerarioVo.valorPassagem"/></td>
								<td align="center"><bean:write name="lista" property="onibusVO.tipo"/></td>
								<td align="center"><bean:write name="lista" property="onibusVO.qtdPoltronas"/></td>
								<td align="center"><bean:write name="lista" property="onibusVO.empresa"/></td>
							</tr>
						</logic:iterate>
					</table>
				</logic:notEmpty>
				<br>
				<logic:notEmpty name="manterCompraForm" property="listaViagensVolta">
					<table width="100%" border="0" align="center">
						<tr class="fundoescuro">
							<td class="texto" colspan="8" align="left"><b><i><c:out value="${manterCompraForm.viagemVO.itinerarioVo.rodoviariaDestinoVO.enderecoVO.cidade}"/></b></i> para <i><b><c:out value="${manterCompraForm.viagemVO.itinerarioVo.rodoviariaOrigemVO.enderecoVO.cidade}"/></b></i> - <c:out value="${manterCompraForm.horaSaidaVolta}"/></td>
						</tr>
					</table>
					<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
						<tr class="fundoescuro">
							<td width="10%" align="center">Selecione</td>
							<td width="12%" align="center">Hora Partida</td>
							<td width="12%" align="center">Chegada Prevista</td>
							<td width="15%" align="center">Valor</td>
							<td width="15%" align="center">Tipo</td>					
							<td width="10%" align="center">Poltronas vagas</td>
							<td width="14%" align="center">Empresa</td>
						</tr>
						<logic:iterate id="lista" name="manterCompraForm" property="listaViagensVolta">
							<tr class="fundoclaro">
								<td align="center"><input type="radio"></td>
								<td align="center"><bean:write name="lista" property="horaSaida.horaMinutoSegundo"/></td>
								<td align="center"><bean:write name="lista" property="horaChegada.horaMinutoSegundo"/></td>
								<td align="center"><bean:write name="lista" property="itinerarioVo.valorPassagem"/></td>
								<td align="center"><bean:write name="lista" property="onibusVO.tipo"/></td>
								<td align="center"><bean:write name="lista" property="onibusVO.qtdPoltronas"/></td>
								<td align="center"><bean:write name="lista" property="onibusVO.empresa"/></td>
							</tr>
						</logic:iterate>
					</table>
					<br/>
					<table width="100%" border="0" align="center">
						<tr>
							<td align="center">
								<input class="botao" value="Comprar" type="button" onclick= ir();>
							</td>
						</tr>
					</table>
				</logic:notEmpty>		
			</td>
		</tr>
	</table>
</html:form>
