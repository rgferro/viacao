<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript" language="javascript">

function adicionar() {
	var frm = document.forms[0];
	frm.task.value = "adicionarLista";	
	frm.pagina.value = 'alterar';
	frm.submit();
}

function remover() {
	var frm = document.forms[0];
	frm.task.value = "removerLista";
	frm.pagina.value = 'alterar';
	frm.submit();
}

function limparCampos(){
	var frm = document.forms[0];
	frm.task.value = "limparCamposDaTabela";
	frm.submit();
}

function alterar(){
	var frm = document.forms[0];
	frm.task.value = "confirmAlterar";
	frm.submit();
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
	frm.pagina.value = 'alterar';
	frm.submit();
}
</script>

<html:form action="/manterItinerario">

<html:hidden name="manterItinerarioForm" property="task"/>
<html:hidden name="manterItinerarioForm" property="seqRodoviariaOrigem"/>
<html:hidden name="manterItinerarioForm" property="seqRodoviariaDestino"/>
<html:hidden name="manterItinerarioForm" property="pagina"/>

<table width="600" border="0" align="center" >
	<tr>
		<td>
			<jsp:include page="/jsp/common/mensagens.jsp" />
			<table width="100%" border="0" align="center" class="bordatabela">
				<tr class="fundoescuro">
					<td colspan="4" align="center" class="texto">Cadastro de Itinerario</td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" align="center" width="18%">Origem:</td>
					<td width="32%">
						<html:select name="manterItinerarioForm" property="itinerarioVo.rodoviariaOrigemVO.seqRodoviaria" styleClass="input" onchange="limpar(this,'origem');">
							<html:option value="-1">SELECIONE</html:option>
							<html:optionsCollection name="manterItinerarioForm" property="listaRodoviariaOrigem" label="nomRodoviaria" value="seqRodoviaria" />							
						</html:select>						
					</td>
					<td class="texto" align="center" width="18%">Destino:</td>
					<td width="32%">
						<html:select name="manterItinerarioForm" property="itinerarioVo.rodoviariaDestinoVO.seqRodoviaria" styleClass="input" onchange="limpar(this,'destino');">
							<html:option value="-1">SELECIONE</html:option>
							<html:optionsCollection name="manterItinerarioForm" property="listaRodoviariaDestino" label="nomRodoviaria" value="seqRodoviaria" />							
						</html:select>
					</td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" align="center">Tempo de Viagem</td>
					<td class="texto">
						<html:text styleClass="input" size="5" maxlength="4" name="manterItinerarioForm" property="itinerarioVo.tempoViagem" onkeypress="return somenteNumero(this, event,false,false,false);" onchange="formataHoraMin(this);"/>
					</td>					
					<td class="texto" height="20" align="center">Valor (em R$)</td>
					<td>
						<html:text name="manterItinerarioForm" size="40" property="itinerarioVo.valorPassagem" styleClass="input" onchange="formataValor(this,6);" disabled="${disable}" onkeypress="return formataCampoDecimal(6,this,event,false,false,true)"/>
					</td>					
				</tr>				
			</table>			
				<table width="100%" border="0" align="center">
					<tr class="fundoescuro">
						<td class="texto" width="45%" align="center">Escolha as tarifas desejadas</td>
						<td width="10%"></td>
						<td class="texto" width="45%" align="center">Tarifas Selecionadas</td>
					</tr>
					<tr>
						<td width="45%" align="right">							
							<html:select name="manterItinerarioForm" property="cboTarifa" style="width: 270px;" size="10" styleClass="input">
								<html:optionsCollection name="manterItinerarioForm" property="listaTarifas" label="nomValor" value="seqTarifa" />
							</html:select>
						</td>
						<td width="10%">
							<table width="100%" border="0" align="center">
								<tr>
									<td align="center">
										<img src="images/seta-direita.GIF" height="20" width="30" title="Inserir" onclick="javascript: adicionar()"></img>							
									</td>	
								</tr>
								<tr>	
									<td align="center">
										<img src="images/seta-esquerda.gif" height="20" width="30" title="Remover" onclick="javascript: remover();"></img>										
									</td>
								</tr>
							</table>
						</td>
						<td width="45%" >
							<html:select name="manterItinerarioForm" property="cboTarifaDestino" style="width: 270px;" size="10" styleClass="input">
								<html:optionsCollection name="manterItinerarioForm" property="listaTarifasEscolhidas" label="nomValor" value="seqTarifa"/>
							</html:select>
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td>
						</td>
						<td class="fundoclaro" align="center">
							Total: 
							<c:set var="total" value="0"/>
							<logic:iterate id="it" name="manterItinerarioForm" property="listaTarifasEscolhidas">
								<c:set var="total" value="${total + it.valor}"/>
							</logic:iterate>
							<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${total}"/>
						</td>
					</tr>
				</table>			
			<table width="50%" border="0" align="center">
				<tr>
								<td align="center"><html:button value="Voltar" property="" styleClass="botao"  onclick="go('manterItinerario.do?task=unspecified')"/></td>
					<td align="center"><html:button value="Alterar" property="" styleClass="botao" onclick="javascript: alterar();" /></td>
					
				</tr>
			</table>
		</td>
	</tr>
</table>
</html:form>