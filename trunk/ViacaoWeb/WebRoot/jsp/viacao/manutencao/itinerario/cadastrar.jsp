<%@ include file="/jsp/common/taglibs.jsp" %>
<html:form action="/manterItinerario">
<table width="600" border="0" align="center">
	<tr>
		<td>
			<jsp:include page="/jsp/common/mensagens.jsp" />
			<table width="100%" border="0" align="center">
				<tr>
					<td class="titulo">Cadastro de Itinerario</td>
				</tr>
			</table><br>
			<table width="100%" border="0" align="center" class="bordatabela">
				<tr class="fundoescuro">
					<td colspan="4" align="center" class="texto">Cadastro de Itinerario</td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" align="center" width="20%">Origem:</td>
					<td width="30%">
						<select name="Origem" size="1">
							<option>Origem</option>
							<option>Rio de Janeiro</option>
							<option>Juiz de Fora</option>
							<option>Petrópolis</option>
						</select>
					</td>
					<td class="texto" align="center" width="20%">Destino:</td>
					<td width="30%">
						<select name="Origem" size="1">
							<option selected="selected">Destino</option>
							<option>Rio de Janeiro</option>
							<option>Juiz de Fora</option>
							<option>Petrópolis</option>
						</select>
					</td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" align="center" width="20%">Tempo de Viagem</td>
					<td colspan="3" width="80%"><input class="input" size="20" value="">min.</td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" align="center" colspan="4">Escolha as tarifas desejadas:</td>
				</tr>
				<tr>
					<td colspan="2">
						<table class="bordatabela" cellpadding="1" cellspacing="2" width="100%">
							<tr class="fundobranco">
								<td>Pedagio Juiz de Fora</td>
								<td align="right">R$ 3,00</td>
							</tr>
							<tr class="fundobranco">
								<td>Pedagio Petrópolis</td>
								<td align="right">R$ 2,00</td>
							</tr>
							<tr class="fundobranco">
								<td>Embarque</td>
								<td align="right">R$ 2,36</td>
							</tr>
							<tr class="fundobranco">
								<td>Seguro</td>
								<td align="right">R$ 8,00</td>
							</tr>
							<tr style="background: silver">
								<td><b>Total:</b></td>
								<td align="right"><b>R$ 15,36</b></td>
							</tr>
						</table>
					</td>
					<td align="center">
						<img src="images/seta-esquerda.gif" height="20" title="Inserir"></img>
						<img src="images/seta-direita.GIF" height="20" title="Excluir"></img>
					</td>					
					<td>
						<table class="bordatabela" cellpadding="1" cellspacing="2" width="100%">
							<tr class="fundobranco">
								<td>&nbsp;</td>
							</tr>
							<tr class="fundobranco">
								<td>&nbsp;</td>
							</tr>
							<tr class="fundobranco">
								<td>&nbsp;</td>
							</tr>
							<tr class="fundobranco">
								<td>&nbsp;</td>
							</tr>
							<tr style="background: silver">
								<td><b>Total:</b></td>
								<td align="right"><b>R$ 00,00</b></td>
							</tr>
						</table>
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