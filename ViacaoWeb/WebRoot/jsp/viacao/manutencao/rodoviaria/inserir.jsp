<%@ include file="/jsp/common/taglibs.jsp" %>
<script type="text/javascript">

function cadastrar(){
	frm = document.forms[0];
	frm.task.value= 'inserir';
	frm.submit();
}
</script>
<form action="/manterRodoviaria">
	<table width="600" border="0" align="center">
		<tr>
			<td>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Cadastro de Rodovi�ria</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">Cadastro de Rodovi�ria</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="05%">Rodovi�ria</td>
						<td width="45%"><input class="input" size="20"></td>
						<td class="texto" align="center" width="05%">Estado</td>
						<td width="45%"><input class="input" size="20"></td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="05%">Cidade</td>
						<td width="45%"><input class="input" size="20"></td>
						<td class="texto" align="center" width="05%">Bairro</td>
						<td width="45%"><input class="input" size="20"></td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="05%">Logradouro</td>
						<td width="95%" colspan="3"><input class="input" size="101"></td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="05%">N�mero</td>
						<td width="45%"><input class="input" size="5"></td>
						<td class="texto" align="center" width="05%">Complemento</td>
						<td width="45%"><input class="input" size="20"></td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>						
						<td align="center">
							<html:button value="Voltar" property="" styleClass="botao" onclick="voltar();"/>
						</td>
						<td align="center">
							<html:button value="Cadastrar" property="" styleClass="botao" onclick="cadastrar();"/>
						</td>
						<td align="center">
							<html:reset value="Limpar" styleClass="botao"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>