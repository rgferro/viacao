<%@ include file="/jsp/common/taglibs.jsp"%>
<script type="text/javascript">
function confirmar(seqRodoviaria){
alert(seqRodoviaria);
	var frm = document.forms[0];
		frm.seqRodoviaria.value = seqRodoviaria;
		frm.task.value = 'confirmaDeletar';
		frm.submit();
alert('oooo');
}
function voltar(){
	var frm = document.forms[0];
    	frm.task.value = 'unspecified';
    	frm.submit();
}
</script>
<html:form action="/manterRodoviaria">
	<html:hidden property="seqRodoviaria" name="manterRodoviariaForm" />
	<html:hidden property="task" name="manterRodoviariaForm" />

	<table width="600" border="0" align="center">
		<tr>
			<td>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">
							Exclusão de Rodoviária
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" id="cadastrar"
					class="bordatabela">
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">
							Confirmação de exclusão de Rodoviária
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="05%">
							Rodoviária
						</td>
						<td width="45%">
							<html:text disabled="true" styleClass="inputdeletar" name="manterRodoviariaForm"  size="20" property="rodoviariaVO.nomRodoviaria"/>
						</td>
						<td class="texto" align="center" width="05%">
							Estado
						</td>
						<td width="45%">
							<html:text styleClass="inputdeletar" size="20"  name="manterRodoviariaForm" property="rodoviariaVO.enderecoVO.estado"
								disabled="true"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="05%">
							Cidade
						</td>
						<td width="45%">
							<html:text styleClass="inputdeletar" size="20"  name="manterRodoviariaForm" property="rodoviariaVO.enderecoVO.cidade"
								disabled="true"/>
						</td>
						<td class="texto" align="center" width="05%">
							Bairro
						</td>
						<td width="45%">
							<html:text styleClass="inputdeletar" size="20"  name="manterRodoviariaForm" property="rodoviariaVO.enderecoVO.bairro"
								disabled="true"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="05%">
							Logradouro
						</td>
						<td width="95%" colspan="3">
							<html:text styleClass="inputdeletar" size="101"  name="manterRodoviariaForm"  property="rodoviariaVO.enderecoVO.logradouro"
								disabled="true"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="center" width="05%">
							Número
						</td>
						<td width="45%">
							<html:text styleClass="inputdeletar" size="20"  name="manterRodoviariaForm" property="rodoviariaVO.enderecoVO.numero"
								disabled="true"/>
						</td>
						<td class="texto" align="center" width="05%">
							Complemento
						</td>
						<td width="45%">
							<html:text styleClass="inputdeletar" size="20"  name="manterRodoviariaForm"  property="rodoviariaVO.enderecoVO.complemento"
								disabled="true"/>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center">
							<input type="button" class="botao" value="Voltar"
								onclick="voltar()" />
						</td>
						<td align="center">
							<input type="button" class="botao" value="Confirmar"
								onclick="confirmar('<c:out value="${manterRodoviariaForm.seqRodoviaria}"/>')" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</html:form>