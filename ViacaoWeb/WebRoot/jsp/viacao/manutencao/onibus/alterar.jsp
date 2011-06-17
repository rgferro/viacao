<%@ include file="/jsp/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<script>
function confirmar(){
	var frm = document.forms[0];
		frm.task.value = 'alterarOnibus';
	frm.submit();
}

function voltar(){
	var frm = document.forms[0];
	frm.task.value = 'unspecified';
	frm.submit();
}
function limpar(){
	var frm = document.forms[0];
	frm.task.value = 'limpar';
	frm.submit();
}
function somenteNumero(obj,e,ast,virg,ponto){
	var tecla=(window.event)?event.keyCode:e.which;
	if (tecla == 13) {
		obj.focus();  obj.select();
		return true
	}
	if((tecla > 47 && tecla < 58)){ 
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
	if((tecla > 96 && tecla < 123) || (tecla > 64 && tecla < 91)){ 
		return true;
	}else{
		return false;
	}
}
function formataPlaca(obj,e,menos){
	var tecla=(window.event)?event.keyCode:e.which;
	var teste = obj.value.search("[-]");
	if(obj.value.length < 3){
		return somenteLetra(obj,e);
	} else
	if(obj.value.length == 3 && teste == -1){
		obj.value = obj.value + "-";
		return somenteNumero(obj,e,'false','false','false');;
	} else
	if(obj.value.length > 3 && obj.value.length < 8){
		return somenteNumero(obj,e,'false','false','false');
	} else{
		return false;
	}
}
</script>

<link href="css/portal.css" rel="stylesheet" type="text/css">
<html:form action="/manterOnibus">
<html:hidden property="task" name="manterOnibusForm"/>
	<table width="600" border="0" align="center">
		<tr>
			<td>
			<jsp:include page="/jsp/common/mensagens.jsp" />
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Atualização de Ônibus</td>
					</tr>
				</table>
				<br>
				<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">Atualização de Ônibus</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="18%" height="20" align="center">Empresa</td>
						<td width="32%">
							<html:text name="manterOnibusForm" property="onibusVO.empresa" styleClass="input"/>
						</td>
						<td class="texto" width="05%" height="20">Tipo</td>
						<td width="45%">
							<html:text name="manterOnibusForm" property="onibusVO.tipo" styleClass="input"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td class="texto" width="18%" height="20" align="center">Qtd Poltronas</td>
						<td width="32%">
							<html:text onkeypress="return somenteNumero(this,event,false,false,false)" maxlength="3" name="manterOnibusForm" property="onibusVO.qtdPoltronas" styleClass="input"/>
						</td>
						<td class="texto" width="05%" height="20" align="center">Placa</td>
						<td width="45%">
							<html:text onkeypress="return formataPlaca(this,event,true)" name="manterOnibusForm" property="onibusVO.placa" styleClass="input"/>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center">
							<html:button value="Voltar" property="" styleClass="botao" onclick="voltar();"/>
						</td>
						<td align="center">
							<html:button value="Confirmar" property="" styleClass="botao" onclick="confirmar();"/>
						</td>
						<td align="center">
							<html:reset value="Limpar" styleClass="botao" onclick="limpar();"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</html:form>
