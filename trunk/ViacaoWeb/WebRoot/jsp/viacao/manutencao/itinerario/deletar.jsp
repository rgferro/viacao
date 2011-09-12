<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript" language="javascript">
function deletar(){
	var frm = document.forms[0];
	frm.task.value = "confirmDeletar";
	frm.submit();
}
</script>

<html:form action="/manterItinerario">
<html:hidden name="manterItinerarioForm" property="task"/>

<table width="600" border="0" align="center" >
	<tr>
		<td>
			<jsp:include page="/jsp/common/mensagens.jsp" />
			<table width="100%" border="0" align="center" class="bordatabela">
				<tr class="fundoescuro">
					<td colspan="4" align="center" class="texto">Deletar Itinerário</td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" align="center" width="18%">Origem:</td>
					<td width="32%">
						<html:text name="manterItinerarioForm" property="itinerarioVo.rodoviariaOrigemVO.nomRodoviaria" disabled="true" styleClass="inputdeletar" size="20"/>			
					</td>
					<td class="texto" align="center" width="18%">Destino:</td>
					<td width="32%">
						<html:text name="manterItinerarioForm" property="itinerarioVo.rodoviariaDestinoVO.nomRodoviaria" disabled="true" styleClass="inputdeletar" size="20"/>
					</td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" align="center">Tempo de Viagem</td>
					<td class="texto">
						<html:text name="manterItinerarioForm" property="itinerarioVo.tempoViagem" disabled="true" styleClass="inputdeletar" size="5"/>
					</td>					
					<td class="texto" height="20" align="center">Valor (em R$)</td>
					<td>
						<html:text name="manterItinerarioForm" size="15" property="itinerarioVo.valorPassagem" styleClass="inputdeletar" onchange="formataValor(this,6);" disabled="true"/>
						<!--<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${manterItinerarioForm.itinerarioVo.valorPassagem}"/>-->
					</td>					
				</tr>				
			</table>			
				<table width="45%" border="0" align="center">
					<tr class="fundoescuro">
						<td class="texto" align="center">Tarifas Selecionadas</td>
					</tr>
					<tr>
						<td align="center">
							<html:select name="manterItinerarioForm" property="cboTarifaDestino" style="width: 270px;" size="10" styleClass="input" disabled="true">
								<html:optionsCollection name="manterItinerarioForm" property="itinerarioVo.listaTarifas" label="nomValor" value="seqTarifa"/>
							</html:select>
						</td>
					</tr>
					<tr>
						<td class="fundoclaro" align="center">
							Total: 
							<c:set var="total" value="0"/>
							<logic:iterate id="it" name="manterItinerarioForm" property="itinerarioVo.listaTarifas">
								<c:set var="total" value="${total + it.valor}"/>
							</logic:iterate>
							<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${total}"/>
						</td>
					</tr>
				</table>			
			<table width="50%" border="0" align="center">
				<tr>
								<td align="center"><html:button value="Voltar" property="" styleClass="botao"  onclick="go('manterItinerario.do?task=unspecified')"/></td>
					<td align="center"><html:button value="Deletar" property="" styleClass="botao" onclick="javascript: deletar();" /></td>
					
				</tr>
			</table>
		</td>
	</tr>
</table>
</html:form>