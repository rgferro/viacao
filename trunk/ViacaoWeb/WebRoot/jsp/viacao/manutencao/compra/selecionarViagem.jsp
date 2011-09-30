<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript">

function ir(){
	var frm = document.forms[0];
	frm.task.value = 'condicoesDeCompra';
	frm.submit();
}

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
							<input type="radio">Ida e Volta
							<input type="radio">Ida
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="10%">
							Origem
						</td>
						<td width="42%">
							<select name="Origem" size="1">
								<option selected="selected">Origem
								<option>Rio de Janeiro
								<option>Petrópolis 
								<option>Juiz de Fora
							</select>
						</td>
						<td class="texto" width="08%">
							Destino
						</td>
						<td width="42%">
							<select name="Destino" size="1">
								<option selected="selected">Destino
								<option>Rio de Janeiro
								<option>Petrópolis 
								<option>Juiz de Fora
							</select>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="10%">
							Data Ida
						</td>
						<td colspan="3">
							<input size="10" class="inputobrigatorio">
								<img src="images/calendar.gif" align="center"></img>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center"><input class="botao" value="Buscar"></td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center">
					<tr class="fundoescuro">
						<td class="texto" colspan="8" align="left"><b><i>RIO DE JANEIRO</b></i> para <i><b>JUIZ DE FORA</b></i> - 26/09/2011</td>
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
					<tr>
						<td align="center" colspan="8" class="texto">Nenhuma viagem foi encontrada!</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center"><input type="radio"></td>
						<td align="center">17:00</td>
						<td align="center">19:30</td>
						<td align="center">R$ 30,00</td>
						<td align="center">Executivo</td>
						<td align="center">15</td>
						<td align="center">Util</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center"><input type="radio"></td>
						<td align="center">17:00</td>
						<td align="center">19:30</td>
						<td align="center">R$ 30,00</td>
						<td align="center">Executivo</td>
						<td align="center">15</td>
						<td align="center">Util</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center"><input type="radio"></img></td>
						<td align="center">17:00</td>
						<td align="center">19:30</td>
						<td align="center">R$ 30,00</td>
						<td align="center">Executivo</td>
						<td align="center">15</td>
						<td align="center">Util</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center">
					<tr class="fundoescuro">
						<td class="texto" colspan="8" align="left"><b><i>JUIZ DE FORA</b></i> para <i><b>RIO DE JANEIRO</b></i> - 30/09/2011</td>
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
					<tr>
						<td align="center" colspan="8" class="texto">Nenhuma viagem foi encontrada!</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center"><input type="radio"></td>
						<td align="center">17:00</td>
						<td align="center">19:30</td>
						<td align="center">R$ 30,00</td>
						<td align="center">Executivo</td>
						<td align="center">15</td>
						<td align="center">Util</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center"><input type="radio"></img></td>
						<td align="center">17:00</td>
						<td align="center">19:30</td>
						<td align="center">R$ 30,00</td>
						<td align="center">Executivo</td>
						<td align="center">15</td>
						<td align="center">Util</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center"><input type="radio"></img></td>
						<td align="center">17:00</td>
						<td align="center">19:30</td>
						<td align="center">R$ 30,00</td>
						<td align="center">Executivo</td>
						<td align="center">15</td>
						<td align="center">Util</td>
					</tr>
				</table>
				<br/>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center">
							<input class="botao" value="Comprar" type="button" onclick= ir();>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</html:form>
