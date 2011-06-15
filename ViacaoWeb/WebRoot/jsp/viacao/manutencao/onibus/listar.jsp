<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript">
function selecionar(acao, seq){
	frm = document.forms[0];
	frm.acao.value = acao;
	frm.seqOnibus.value = seq;
	frm.task.value = 'recuperarOnibus';
}
</script>

<html:form action="/manterOnibus">

	<table width="600" border="0" align="center">
		<tr>
			<td>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Ônibus</td>
					</tr>
				</table>
				<br>
				<table>
					<tr>
						<td class="link"><img src="images/fetch.gif"/>
							<a href="">Cadastrar Novo Ônibus</a></td>
					</tr>
				</table>
				<table width="100%" border="0" align="center" id="consulta" class="bordatabela">
					<tr class="fundoescuro">
						<td class="texto" colspan="4" align="center">Busca de Ônibus</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="18%" height="20" align="center">Empresa</td>
						<td width="32%">
							<html:text name="manterOnibusForm" property="onibusVO.empresa"/>
						</td>
						<td class="texto" width="05%" height="20">Tipo</td>
						<td width="45%">
							<html:text name="manterOnibusForm" property="onibusVO.tipo"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="18%" height="20" align="center">Qtd Poltronas</td>
						<td width="32%">
							<html:text name="manterOnibusForm" property="onibusVO.qtdPoltrona"/>
						</td>
						<td class="texto" width="05%" height="20" align="center">Placa</td>
						<td width="45%">
							<html:text name="manterOnibusForm" property="onibusVO.placa"/>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td colspan="4" align="center">
							<html:button styleClass="botao" value="Buscar" property="" onclick=""/>
						</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" class="bordatabela">
					<tr class="fundoescuro">
						<td width="15%" height="20" colspan="2">&nbsp;</td>
						<td width="20%"  align="center">Empresa</td>
						<td width="20%" align="center">Tipo</td>
						<td width="25%" align="center">Qtd Poltronas</td>
						<td width="20%" align="center">Placa</td>
					</tr>
					<tr>
						<td align="center" colspan="6" class="texto">Nenhum ônibus foi cadastrado!</td>
					</tr>
					<logic:notEmpty>
						<logic:iterate id="lista" name="manterOnibusForm" property="listaOnibus">
							<tr class="fundoclaro">
								<td align="center">
									<a href="javascript: selecionar('ALTERANDO', '<c:out value="${lista.seqOnibus}"/>');">
									<img title="Editar" src="images/icon_editar.gif"></a>
								</td>
								<td align="center">
									<a href="javascript: selecionar('DELETANDO', '<c:out value="${lista.seqOnibus}"/>');">
									<img title="Deletar" src="images/icon_lixeira.gif"></a>
								</td>
								<td align="center"><bean:write name="lista" property="empresa"/></td>
								<td align="center"><bean:write name="lista" property="tipo"/></td>
								<td align="center"><bean:write name="lista" property="qtdPoltrona"/></td>
								<td align="center"><bean:write name="lista" property="placa"/></td>
							</tr>
						</logic:iterate>
					</logic:notEmpty>
					<logic:empty>
						<tr>
							<td colspan="5">
								Não há Ônibus cadastrados.
							</td>
						</tr>
					</logic:empty>
				</table>
			</td>
		</tr>
	</table>
</html:form>