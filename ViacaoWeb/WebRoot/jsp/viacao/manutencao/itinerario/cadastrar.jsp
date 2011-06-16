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

</script>

<html:form action="/manterItinerario">

<html:hidden name="manterItinerarioForm" property="task"/>

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
						<html:select name="manterItinerarioForm" property="seq" styleClass="input">
							<html:option value="369">NOVO RIO</html:option>
							<html:option value="370">ANTIGA RIO</html:option>
							<html:option value="387">ROD. NITEROI</html:option>
							<html:option value="388">ROD. JUIZ DE FORA</html:option>							
						</html:select>						
					</td>
					<td class="texto" align="center" width="20%">Destino:</td>
					<td width="30%">
						<html:select name="manterItinerarioForm" property="seq" styleClass="input">
							<html:option value="369">NOVO RIO</html:option>
							<html:option value="370">ANTIGA RIO</html:option>
							<html:option value="387">ROD. NITEROI</html:option>
							<html:option value="388">ROD. JUIZ DE FORA</html:option>
						</html:select>
					</td>
				</tr>
				<tr class="fundoescuro">
					<td class="texto" align="center" width="20%">Tempo de Viagem</td>
					<td class="texto" colspan="3" width="80%"><input class="input" size="20" value="">min.</td>
				</tr>				
			</table>			
				<table width="100%" border="0" align="center">
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
							<html:select name="manterItinerarioForm" property="cboTarifa" style="width: 270px;" size="10" styleClass="input">
								<html:optionsCollection name="manterItinerarioForm" property="listaTarifasEscolhidas" label="nomValor" value="seqTarifa"/>
							</html:select>
						</td>
					</tr>
				</table>			
			<table width="100%" border="0" align="center">
				<tr>
					<td align="center"><input class="botao" value="Voltar"></td>
					<td align="center"><input class="botao" value="Cadastrar"></td>
					<td align="center"><input class="botao" value="Limpar"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</html:form>