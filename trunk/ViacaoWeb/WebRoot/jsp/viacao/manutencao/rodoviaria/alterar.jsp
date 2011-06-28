<%@ include file="/jsp/common/taglibs.jsp"%>

<script type="text/javascript">
function voltar(){
	var frm = document.forms[0];
		frm.task.value = 'unspecified';
		frm.submit();
}
function confirmar(seqRodoviaria){
	var frm = document.forms[0];
		frm.seqRodoviaria.value = seqRodoviaria;
		frm.task.value = 'confirmaAlterar';
		frm.submit();
}
function somenteNumero(obj,e,ast,virg,ponto){
	var tecla=(window.event)?event.keyCode:e.which;
	if (tecla == 13) {
		obj.focus();  obj.select();
		return true
	}
	if((tecla > 47 && tecla < 58) || (tecla == 8) || (tecla == 0)){ 
		return true;
	}else{
		if((tecla == 9)) return true;
		if ((tecla == 8)) return true;
		if ((tecla == 0)) return true;
		if ((tecla == 42)&&(ast)) return true; //permite asterísco
		if ((tecla == 44)&&(virg)) return true; //permite vírgula
		if ((tecla == 46)&&(ponto)) return true; //permite ponto
		return false;
	}
}
function somenteLetra(obj,e){
	var tecla=(window.event)?event.keyCode:e.which;
	if (tecla == 13) {
		obj.focus();  obj.select();
		return true
	}
	if((tecla > 96 && tecla < 123) || (tecla > 64 && tecla < 91) || (tecla == 32) || (tecla == 8) || (tecla == 0)){ 
		return true;
	}else{
		return false;
	}
}
function somenteLetraENumero(obj,e){
	var tecla=(window.event)?event.keyCode:e.which;
	if (tecla == 13) {
		obj.focus();  obj.select();
		return true
	}
	if((tecla > 96 && tecla < 123) || (tecla > 64 && tecla < 91) || (tecla == 32) || (tecla > 47 && tecla < 58) || (tecla == 46) || (tecla == 44) || (tecla == 8) || (tecla == 0)){
		return true;
	}else{
		return false;
	}
}
</script>
<html:form action="/manterRodoviaria">
	<html:hidden name="manterRodoviariaForm" property="task" />
	<html:hidden name="manterRodoviariaForm" property="seqRodoviaria" />

	<table width="600" border="0" align="center">
		<tr>
			<td>
				<jsp:include page="/jsp/common/mensagens.jsp" />
				<table width="100%" border="0" align="left">
					<tr>
						<td class="titulo">
							Edição de Rodoviária
						</td>
					</tr>
				</table>
		<tr>
			<td>
				<table width="100%" border="0" align="left" id="cadastrar"
					class="bordatabela">
					<tr class="fundoclaro">
						<td class="texto" align="left" width="05%">
							Rodoviária:
						</td>
						<td width="45%">
							<html:text styleClass="input" size="30"
								name="manterRodoviariaForm"
								property="rodoviariaVO.nomRodoviaria" />
						</td>
						<td class="texto" align="left" width="05%">
							Estado:
						</td>
						<td width="45%">
							<html:text styleClass="input" size="20" maxlength="20"
								name="manterRodoviariaForm"
								property="rodoviariaVO.enderecoVO.estado"
								onkeypress="return somenteLetra(this,event)" />
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="left" width="05%">
							Cidade:
						</td>
						<td width="45%">
							<html:text styleClass="input" size="30"
								name="manterRodoviariaForm"
								property="rodoviariaVO.enderecoVO.cidade"
								onkeypress="return somenteLetra(this,event)" />
						</td>
						<td class="texto" align="left" width="05%">
							Bairro:
						</td>
						<td width="45%">
							<html:text styleClass="input" size="20"
								name="manterRodoviariaForm"
								property="rodoviariaVO.enderecoVO.bairro"
								onkeypress="return somenteLetra(this,event)" />
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="left" width="05%">
							Logradouro:
						</td>
						<td width="95%" colspan="3">
							<html:text styleClass="input" size="85"
								name="manterRodoviariaForm"
								property="rodoviariaVO.enderecoVO.logradouro"
								onkeypress="return somenteLetra(this,event)" />
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" align="left" width="05%">
							Número:
						</td>
						<td width="45%">
							<html:text styleClass="input" size="7" maxlength="5"
								name="manterRodoviariaForm"
								property="rodoviariaVO.enderecoVO.numero"
								onkeypress="return somenteNumero(this,event,false,false,false)" />
						</td>
						<td class="texto" align="left" width="05%">
							Complemento:
						</td>
						<td width="45%">
							<html:text styleClass="input" size="20"
								name="manterRodoviariaForm"
								property="rodoviariaVO.enderecoVO.complemento"
								onkeypress="return somenteLetraENumero(this,event)" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<td>
			<table width="100%" border="0" align="center">
				<tr>
					<td align="center">
						<input type="button" class="botao" value="Voltar"
							onclick="voltar()">
					</td>
					<td align="center">
						<input type="button" class="botao" value="Confirmar"
							onclick="confirmar('<c:out value="${manterRodoviariaForm.seqRodoviaria}"/>')">
					</td>
					<td align="center">
						<html:reset value="Resetar" styleClass="botao" />
					</td>
				</tr>
			</table>
		</td>

	</table>
</html:form>