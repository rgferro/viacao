<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript" language="javascript">

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

function limparCampos(){
	var frm = document.forms[0];
	frm.task.value = "limparCamposDaTabela";
	frm.submit();
}

function cadastrar(){
	var frm = document.forms[0];
	frm.task.value = "cadastrarItinerario";
	frm.submit();
}

</script>

<html:form action="/manterItinerario">

<html:hidden name="manterItinerarioForm" property="task"/>
<html:hidden name="manterItinerarioForm" property="seqRodoviaria"/>

<table width="600" border="0" align="center" >
	<tr>
		<td>
			<jsp:include page="/jsp/common/mensagens.jsp" />
			<table width="100%" border="0" align="center" class="bordatabela">
				<tr class="fundoescuro">
					<td colspan="4" align="center" class="texto">Cadastro de Itinerario</td>
				</tr>
				<tr class="fundoescuro">
					<td class="texto" align="center" width="20%">Origem:</td>
					<td width="30%">
						<html:select name="manterItinerarioForm" property="itinerarioVo.rodoviariaOrigemVO.seqRodoviaria" styleClass="input">
							<html:optionsCollection name="manterItinerarioForm" property="listaRodoviaria" label="nomRodoviaria" value="seqRodoviaria" />							
						</html:select>						
					</td>
					<td class="texto" align="center" width="20%">Destino:</td>
					<td width="30%">
						<html:select name="manterItinerarioForm" property="itinerarioVo.rodoviariaDestinoVO.seqRodoviaria" styleClass="input">
							<html:optionsCollection name="manterItinerarioForm" property="listaRodoviariaDestino" label="nomRodoviaria" value="seqRodoviaria" />							
						</html:select>
					</td>
				</tr>
				<tr class="fundoescuro">
					<td class="texto" align="center" width="20%">Tempo de Viagem</td>
					<td class="texto" colspan="3" width="80%"><html:text styleClass="input" size="20" name="manterItinerarioForm" property="itinerarioVo.tempoViagem" />min.</td>					
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
				</table>			
			<table width="100%" border="0" align="center">
				<tr>
					<td align="center"><html:button value="Voltar" property="" styleClass="botao" /></td>
					<td align="center"><html:button value="Cadastrar" property="" styleClass="botao" onclick="javascript: cadastrar();" /></td>
					<td align="center"><html:button value="Limpar" property="" styleClass="botao" onclick="javascript: limparCampos();" /></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</html:form>