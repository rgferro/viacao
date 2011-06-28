<%@ include file="/jsp/common/taglibs.jsp"%>

<script type="text/javascript">

function buscar(){
	var frm = document.forms[0];
		frm.task.value ='buscarRodoviaria';
	frm.submit();
}
function alterar(seqRodoviaria){
	var frm = document.forms[0];
		frm.seqRodoviaria.value = seqRodoviaria;
		frm.task.value = 'alterar';
	frm.submit();

}
function deletar(seqRodoviaria){
	var frm = document.forms[0];
		frm.seqRodoviaria.value = seqRodoviaria;
		frm.task.value = 'deletar';
	frm.submit();
}
function consultar(seqRodoviaria){
	var frm = document.forms[0];
		frm.seqRodoviaria.value = seqRodoviaria;
		frm.task.value = 'consultar';
	frm.submit();	
}
function mudaImagemOver(obj, acao){

	if(acao == "editar"){
		obj.src = 'images/icon_editar3.png';
	}
	if(acao == "deletar"){
		obj.src = 'images/icon_lixeira3.png';
	}
	if(acao == "confirmar"){
		obj.src = 'images/accept1.png';
	}
	if(acao == "pesquisar"){
		obj.src = 'images/zoom.png';
	}
	if(acao == "cancelar"){
		obj.src = 'images/delete1.png';
	}

}
function mudaImagemOut(obj, acao){

	if(acao == "editar"){
		obj.src = 'images/icon_editar3off.png';
	}
	if(acao == "deletar"){
		obj.src = 'images/icon_lixeira3off.png';
	}
	if(acao == "confirmar"){
		obj.src = 'images/acceptoff.png';
	}
	if(acao == "pesquisar"){
		obj.src = 'images/zoomoff.png';
	}
	if(acao == "cancelar"){
		obj.src = 'images/deleteoff.png';
	}

}
</script>

<html:form action="/manterRodoviaria">
	<html:hidden property="task" name="manterRodoviariaForm" />
	<html:hidden property="seqRodoviaria" name="manterRodoviariaForm" />
	<table width="600" border="0" align="center">
		<tr>
			<td>
				<jsp:include page="/jsp/common/mensagens.jsp" />
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">
							Rodoviária
						</td>
					</tr>
				</table>
				<table>
					<tr>
						<td class="link">
							<a href="<%request.getContextPath();%>?task=inserir"><img
									src="images/fetch.gif" border="0" /> Cadastrar Nova Rodoviária</a>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center" id="consulta"
					class="bordatabela">
					<tr class="fundoclaro">
						<td class="texto" width="05%" height="20" align="center">
							Rodoviária
						</td>
						<td width="45%">
							<html:text name="manterRodoviariaForm" size="20"
								property="rodoviariaVO.nomRodoviaria" styleClass="input" />
						</td>
						<td class="texto" width="05%" height="20">
							Estado
						</td>
						<td width="45%">
							<html:text name="manterRodoviariaForm" size="20"
								property="rodoviariaVO.enderecoVO.estado" styleClass="input" />
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="05%" height="20" align="center">
							Cidade
						</td>
						<td width="45%" colspan="3">
							<html:text name="manterRodoviariaForm" size="20"
								property="rodoviariaVO.enderecoVO.cidade" styleClass="input" />
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td colspan="4" align="center">
							<html:button property="" styleClass="botao" value="Buscar"
								onclick="javascript: buscar();" />
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
									<img title="Editar!" src="images/icon_editar3off.png"
										height="20" width="20" border="0"
										onmouseover="mudaImagemOver(this,'editar');"
										onmouseout="mudaImagemOut(this, 'editar')"> </a>
							</td>
							<td align="center">
								<a
									href="javascript: deletar('<c:out value="${idLista.seqRodoviaria}"/>')">
									<img title="Deletar!" src="images/icon_lixeira3off.png"
										height="20" width="20" border="0"
										onmouseover="mudaImagemOver(this,'deletar');"
										onmouseout="mudaImagemOut(this, 'deletar')"> </a>
							</td>
							<td align="center">
								<a
									href="javascript: consultar('<c:out value="${idLista.seqRodoviaria}"/>')">
									<img title="Pesquisar!" src="images/zoomoff.png" border="0"
										height="20" width="20" border="0"
										onmouseover="mudaImagemOver(this,'pesquisar');"
										onmouseout="mudaImagemOut(this, 'pesquisar')"> </a>

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
