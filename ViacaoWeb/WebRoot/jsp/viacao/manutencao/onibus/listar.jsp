<%@ include file="/jsp/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link type="text/css" href="css/custom-theme/jquery-ui-1.8.13.custom.css" rel="stylesheet" />	
<script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.13.custom.min.js"></script>
<script type="text/javascript">
function selecionar(acao, seq){
	var frm = document.forms[0];
	frm.acao.value = acao;
	frm.seqOnibus.value = seq;
	frm.task.value = 'recuperarOnibus';
	frm.submit();
}

function buscar(){
	var frm = document.forms[0];
	frm.task.value = 'listarOnibus';
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
<html:hidden property="acao" name="manterOnibusForm"/>
<html:hidden property="empresaParam" name="manterOnibusForm"/>
<html:hidden property="tipoParam" name="manterOnibusForm"/>
<html:hidden property="qtdPoltronaParam" name="manterOnibusForm"/>
<html:hidden property="placaParam" name="manterOnibusForm"/>
<html:hidden property="seqOnibus" name="manterOnibusForm"/>
	<table width="600" border="0" align="center">
		<tr>
			<td>
				<jsp:include page="/jsp/common/mensagens.jsp" />
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Ônibus</td>
					</tr>
				</table>
				<table>
					<tr>
						<td class="link"><img src="images/fetch.gif"/>
							<a href="<%request.getContextPath();%>?task=paginaCadastrarOnibus&acao=CADASTRAR">Cadastrar Novo Ônibus</a>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center" class="bordatabela">
					<tr class="fundoescuro">
						<td class="texto" colspan="4" align="center">Busca de Ônibus</td>
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
							<html:text name="manterOnibusForm" property="qtdPoltronas" styleClass="input" onkeypress="return somenteNumero(this,event,false,false,true)"/>
						</td>
						<td class="texto" width="05%" height="20" align="center">Placa</td>
						<td width="45%">
							<html:text name="manterOnibusForm" property="onibusVO.placa" styleClass="input"/>
						</td>
					</tr>
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td colspan="4" align="center">
							<html:button value="Buscar" property="" styleClass="botao" onclick="buscar();"/>
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
					<logic:empty name="manterOnibusForm" property="listaOnibus">
					<tr>
						<td align="center" colspan="6" class="texto">Nenhum ônibus foi encontrado!</td>
					</tr>
					</logic:empty>	
					<logic:iterate id="lista" name="manterOnibusForm" property="listaOnibus">
						<tr class="fundoclaro">
							<td align="center">
								<a href="javascript: selecionar('ALTERAR', <c:out value="${lista.seqOnibus}"/>)">
									<img title="Editar!" src="images/icon_editar3off.png" height="20" width="20" onmouseover="mudaImagemOver(this,'editar');" onmouseout="mudaImagemOut(this, 'editar')">
								</a>
							</td>
							<td align="center">
								<a href="javascript: selecionar('DELETAR', <c:out value="${lista.seqOnibus}"/>)">
									<img title="Deletar!" src="images/icon_lixeira3off.png" height="20" width="20" onmouseover="mudaImagemOver(this,'deletar');" onmouseout="mudaImagemOut(this, 'deletar')">
								</a>
							</td>
							<td align="center">
								<bean:write name="lista" property="empresa"/>
							</td>
							<td align="center">
								<bean:write name="lista" property="tipo"/>
							</td>
							<td align="center">
								<bean:write name="lista" property="qtdPoltronas"/>
							</td>
							<td align="center">
								<bean:write name="lista" property="placa"/>
							</td>
						</tr>
					</logic:iterate>
				</table>
			</td>
		</tr>
	</table>
</html:form>