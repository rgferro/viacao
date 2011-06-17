<%@ include file="/jsp/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<script type="text/javascript">
function confirmar(){
	var frm = document.forms[0];
	frm.task.value = 'inserirOnibus';
	frm.submit();
}

function voltar(){
	var frm = document.forms[0];
	frm.task.value = 'unspecified';
	frm.submit();
}

function somenteNumeroLetra(obj,e,numero,letra){
	var tecla=(window.event)?event.keyCode:e.which;
	if (tecla == 13) {
		obj.focus();  obj.select();
		return true
	}
	if(letra){
		if((tecla > 96 && tecla < 123) || (tecla > 64 && tecla < 91)){ 
			return true;
		}
	}
	if(numero){
		if((tecla > 47 && tecla < 58)){ 
			return true;
		}
	}
	if((tecla == 9)) return true;
	if ((tecla == 8)) return true;
	if ((tecla == 0)) return true;
	return false;
}

function formataPlaca(obj,e,menos){
	var tecla=(window.event)?event.keyCode:e.which;
	var teste = obj.value.search("[-]");
	
	if(obj.value.length < 3){
		return somenteNumeroLetra(obj,e,false,true);
	} else
	if(obj.value.length == 3 && teste == -1){
		obj.value = obj.value + "-";
		return somenteNumeroLetra(obj,e,true,false);
	} else
	if(obj.value.length > 3){
		if(teste == -1 && tecla ==45){
			return true;
		}
		var cont = 0;
		for(var i=0 ; i < 3; i++){
			if(obj.value.substring(0,3)[i].search("[a-z^A-Z]") < 0){
				cont++;
			}
		}
		if(cont > 0){
			return somenteNumeroLetra(obj,e,false,true);
			
		}else{
			return somenteNumeroLetra(obj,e,true,false);
		}
	} else{
		return false;
	}
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
						<td class="titulo">Cadastro de Ônibus</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">Cadastro de Ônibus</td>
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
							<html:text value="" onkeypress="return somenteNumeroLetra(this,event,true,false)" maxlength="3" name="manterOnibusForm" property="onibusVO.qtdPoltronas" styleClass="input"/>
						</td>
						<td class="texto" width="05%" height="20" align="center">Placa</td>
						<td width="45%">
							<html:text onkeypress="return formataPlaca(this,event,true)" name="manterOnibusForm" property="onibusVO.placa" styleClass="input" maxlength="8"/>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center">
							<html:button value="Voltar" property="" styleClass="botao" onclick="voltar();"/>
						</td>
						<td align="center">
							<html:button value="Cadastrar" property="" styleClass="botao" onclick="confirmar();"/>
						</td>
						<td align="center">
							<html:reset value="Limpar" styleClass="botao"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</html:form>
