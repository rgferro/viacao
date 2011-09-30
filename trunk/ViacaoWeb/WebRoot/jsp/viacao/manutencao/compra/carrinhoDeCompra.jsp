<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript">
function ir(){
	var frm = document.forms[0];
	frm.task.value = 'dadosCartao';
	frm.submit();
}
</script>

<html:form action="/manterCompra">
<html:hidden property="task" name="manterCompraForm"/>
	<table width="100%" border="0" align="center">
		<tr class="fundoescuro">
			<td colspan="8" align="left">Carrinho de Compra</td>
		</tr>
	</table>
	<br/>
	<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
		<tr class="fundoescuro">
			<td width="10%" align="center">Data</td>
			<td width="18%" align="center">Partida</td>
			<td width="18%" align="center">Chegada</td>
			<td width="9%" align="center">Poltrona</td>
			<td width="15%" align="center">Valor</td>					
			<td width="10%" align="center">Nome Passageiro</td>
			<td width="14%" align="center">N° Doc</td>
			<td width="8%" align="center">&nbsp;</td>
		</tr>
		<tr class="fundoclaro">
			<td align="center">26/09/2011</td>
			<td align="center">Rio de Janeiro - 19:30h</td>
			<td align="center">Juiz de Fora - 22:00h</td>
			<td align="center">13</td>
			<td align="center">R$60,00</td>
			<td align="center"><input class="inputobrigatorio" size="10"/></td>
			<td align="center"><input class="inputobrigatorio" size="10"/></td>
			<td align="center"><img title="Excluir" src="images/excluir.png"></td>
		</tr>
		<tr class="fundoclaro">
			<td align="center">30/09/2011</td>
			<td align="center">Juiz de Fora - 22:00h</td>
			<td align="center">Rio de Janeiro - 19:30h</td>
			<td align="center">13</td>
			<td align="center">R$60,00</td>
			<td align="center"><input class="inputobrigatorio" size="10"/></td>
			<td align="center"><input class="inputobrigatorio" size="10"/></td>
			<td align="center"><img title="Excluir" src="images/excluir.png"></td>
		</tr>
		<tr class="fundoescuro">
			<td class="texto" colspan="7" align="left">Total</td>
			<td class="texto" colspan="7" align="left">R$120,00</td>
		</tr>
	</table>
	<br/>
	<table width="40%" border="0" align="center" id="cadastrar" class="bordatabela">
		<tr class="fundoescuro">
			<td class="texto" align="left" colspan="2">Forma de Pagamento</td>
		</tr>
		<tr class="fundoclaro">
			<td align="left" width="15%">Tipo de Pagamento</td>
			<td align="center" width="25%">
				<select name="" size="1">
					<option selected="selected">Selecione
					<option>À Vista
					<option>Parcela 2x
					<option>Parcela 3x
					<option>Parcela 4x
				</select>
			</td>
		</tr>
		<tr class="fundoclaro">
			<td align="left">Bandeira Cartão</td>
			<td align="center">
				<select name="" size="1">
					<option selected="selected">Selecione
					<option>Visa 
					<option>MasterCard
					<option>American
				</select>
			</td>
		</tr>
	</table>
	<br/>
	<table width="100%" border="0" align="center">
		<tr>
			<td align="center">
				<input class="botao" value="Confirmar" type="button" onclick= ir();>
			</td>
		</tr>
	</table>
</html:form>