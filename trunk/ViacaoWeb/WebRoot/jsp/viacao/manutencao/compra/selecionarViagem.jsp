<link href="css/portal.css" rel="stylesheet" type="text/css">
<form action="/exemplo">
<table width="600" border="0" align="center">
	<tr>
		<td>
			<table width="100%" border="0" align="center">
				<tr>
					<td class="titulo">Consulta dessfdsd</td>
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
			<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
				<tr class="fundoescuro">
					<td class="texto" colspan="8" align="center">Resultado da consulta</td>
				</tr>
				<tr class="fundoescuro">
					<td width="05%" height="20">&nbsp;</td>
					<td width="18%"  align="center">Origem</td>
					<td width="17%" align="center">Destino</td>
					<td width="15%" align="center">Tipo</td>
					<td width="10%" align="center">Data</td>
					<td width="10%" align="center">Hora</td>
					<td width="15%" align="center">Valor</td>
					<td width="10%" align="center">Poltronas vagas</td>
				</tr>
				<tr>
					<td align="center" colspan="8" class="texto">Nenhuma viagem foi encontrada!</td>
				</tr>
				<tr class="fundoclaro">
					<td align="center"><input type="radio"></td>
					<td align="center">Rio de Janeiro</td>
					<td align="center">Juiz de Fora</td>
					<td align="center">Executivo</td>
					<td align="center">06/06/2011</td>
					<td align="center">17:00</td>
					<td align="center">R$ 30,00</td>
					<td align="center">15</td>
				</tr>
				<tr class="fundoclaro">
					<td align="center"><input type="radio"></td>
					<td align="center">Rio de Janeiro</td>
					<td align="center">Petrópolis</td>
					<td align="center">Convencional</td>
					<td align="center">06/06/2011</td>
					<td align="center">20:00</td>
					<td align="center">R$ 15,00</td>
					<td align="center">10</td>
				</tr>
				<tr class="fundoclaro">
					<td align="center"><input type="radio"></img></td>
					<td align="center">Petrópolis</td>
					<td align="center">Juiz de Fora</td>
					<td align="center">Executivo</td>
					<td align="center">06/06/2011</td>
					<td align="center">22:00</td>
					<td align="center">R$ 20,00</td>
					<td align="center">08</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
