<%@ include file="/jsp/common/taglibs.jsp"%>

<script type="text/javascript">

function cadastrar(){
	frm = document.forms[0];
	frm.task.value= 'confirmaInserir';
	frm.submit();
}
function voltar(){
	frm = document.forms[0];
	frm.task.value = 'unspecified';
	frm.submit();
}
</script>
<html:form action="/manterRodoviaria">
	<html:hidden name="manterRodoviariaForm" property="task" />

	<table width="600" border="0" align="center">
		<tr>
			<td>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">
							Cadastro de Rodoviária
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" id="cadastrar"
					class="bordatabela">
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">
							Cadastro de Rodoviária
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="05%">
							Rodoviária
						</td>
						<td width="45%">
							<html:text styleClass="input" size="20"
								name="manterRodoviariaForm"
								property="rodoviariaVO.nomRodoviaria" />
						</td>
						<td class="texto" align="center" width="05%">
							Estado
						</td>
						<td width="45%">
							<html:text styleClass="input" size="20"
								name="manterRodoviariaForm"
								property="rodoviariaVO.enderecoVO.estado" />
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="05%">
							Cidade
						</td>
						<td width="45%">
							<html:text styleClass="input" size="20"
								name="manterRodoviariaForm"
								property="rodoviariaVO.enderecoVO.cidade" />
						</td>
						<td class="texto" align="center" width="05%">
							Bairro
						</td>
						<td width="45%">
							<html:text styleClass="input" size="20"
								name="manterRodoviariaForm"
								property="rodoviariaVO.enderecoVO.bairro" />
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="05%">
							Logradouro
						</td>
						<td width="95%" colspan="3">
							<html:text styleClass="input" size="101"
								name="manterRodoviariaForm"
								property="rodoviariaVO.enderecoVO.logradouro" />
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="05%">
							Número
						</td>
						<td width="45%">
							<html:text styleClass="input" size="5"
								name="manterRodoviariaForm"
								property="rodoviariaVO.enderecoVO.numero" />
						</td>
						<td class="texto" align="center" width="05%">
							Complemento
						</td>
						<td width="45%">
							<html:text styleClass="input" size="20"
								name="manterRodoviariaForm"
								property="rodoviariaVO.enderecoVO.complemento" />
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center">
							<html:button value="Voltar" property="" styleClass="botao"
								onclick="voltar();" />
						</td>
						<td align="center">
							<html:button value="Cadastrar" property="" styleClass="botao"
								onclick="cadastrar();" />
						</td>
						<td align="center">
							<html:reset value="Limpar" styleClass="botao" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</html:form>

