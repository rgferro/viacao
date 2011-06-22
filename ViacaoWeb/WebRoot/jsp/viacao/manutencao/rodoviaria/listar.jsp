<%@ include file="/jsp/common/taglibs.jsp"%>

<script type="text/javascript">

function buscar(){
	var frm = document.forms[0];
		frm.task.value ='getListaRodoviaria';
	frm.submit();
}
function alterar(seqRodoviaria){
alert(seqRodoviaria);
	var frm = document.forms[0];
		frm.seqRodoviaria.value = seqRodoviaria;
		frm.task.value = 'alterar';
	frm.submit();

}
function deletar(seqRodoviaria){
alert(seqRodoviaria);
	var frm = document.forms[0];
		frm.seqRodoviaria.value = seqRodoviaria;
		frm.task.value = 'deletar';
	frm.submit();
alert('oooo');
}
</script>

<html:form action="/manterRodoviaria">
	<html:hidden property="task" name="manterRodoviariaForm" />
	<html:hidden property="seqRodoviaria" name="manterRodoviariaForm" />


	<table width="600" border="0" align="center">
		<tr>
			<td>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">
							Rodoviária
						</td>
					</tr>
				</table>
				<br>
				<table>
					<tr>
						<td class="link">
							<a href="<%request.getContextPath();%>?task=inserir"><img
									src="images/fetch.gif" /> Cadastrar Nova Rodoviária</a>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center" id="consulta"
					class="bordatabela">
					<tr class="fundoescuro">
						<td class="texto" width="05%" height="20" align="center">
							Rodoviária
						</td>
						<td width="45%">
							<html:text name="manterRodoviariaForm" size="20"
								property="rodoviariaVO.nomRodoviaria" />
						</td>
						<td class="texto" width="05%" height="20">
							Estado
						</td>
						<td width="45%">
							<html:text name="manterRodoviariaForm" size="20"
								property="rodoviariaVO.enderecoVO.estado" />
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="05%" height="20" align="center">
							Cidade
						</td>
						<td width="45%" colspan="3">
							<html:text name="manterRodoviariaForm" size="20"
								property="rodoviariaVO.enderecoVO.cidade" />
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td colspan="4" align="center">
							<html:button property="" styleClass="botao" value="Buscar"
								onclick="buscar();" />
						</td>
					</tr>
				</table>
				<br />
				<table width="100%" border="0" align="center" class="bordatabela">
					<tr class="fundoescuro">
						<td width="15%" height="20" colspan="3">
							&nbsp;
						</td>
						<td width="20%" align="center">
							Rodoviária
						</td>
						<td width="20%" align="center">
							Estado
						</td>
						<td width="25%" align="center">
							Cidade
						</td>
					</tr>
					<logic:empty name="manterRodoviariaForm"
						property="listaInicioRodoviaria">
						<tr>
							<td align="center" colspan="7" class="texto">
								Nenhuma rodoviária foi cadastrado!
							</td>
						</tr>
					</logic:empty>
					<logic:iterate id="idLista" name="manterRodoviariaForm"
						property="listaInicioRodoviaria">
						<tr class="fundoclaro">
							<td align="center">
								<a
									href="javascript: alterar('<c:out value="${idLista.seqRodoviaria}"/>')">
									<img title="Editar" src="images/icon_editar.gif" /> </a>
							</td>
							<td align="center">
								<a
									href="javascript: deletar('<c:out value="${idLista.seqRodoviaria}"/>')">
									<img title="Deletar" src="images/icon_lixeira.gif" /> </a>
							</td>
							<td align="center">
								<img title="Consultar" src="images/icon_lupa.gif" />
							</td>
							<td align="center">
								<bean:write name="idLista" property="nomRodoviaria" />
							</td>
							<td align="center">
								<bean:write name="idLista" property="enderecoVO.estado" />
							</td>
							<td align="center">
								<bean:write name="idLista" property="enderecoVO.cidade" />
							</td>
						</tr>
					</logic:iterate>
				</table>
			</td>
		</tr>
	</table>
</html:form>
