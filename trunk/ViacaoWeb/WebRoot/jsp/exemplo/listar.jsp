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
$(function() {
		// a workaround for a flaw in the demo system (http://dev.jqueryui.com/ticket/4375), ignore!
		$( "#dialog:ui-dialog" ).dialog( "destroy" );
		
		var empresa = $( "#empresa" ),
			tipo = $( "#tipo" ),
			qtdPoltrona = $( "#qtdPoltrona" ),
			placa = $( "#placa" ),
			allFields = $( [] ).add( empresa ).add( tipo ).add( qtdPoltrona ).add( placa ),
			tips = $( ".validateTips" );

		function updateTips( t ) {
			tips
				.text( t )
				.addClass( "ui-state-error" );
			setTimeout(function() {
				tips.removeClass( "ui-state-error", 1500 );
			}, 500 );
		}

		function checkLength( o, n, min, max ) {
			if ( o.val().length > max || o.val().length < min ) {
				o.addClass( "ui-state-error" );
				updateTips( "Em " + n + " é aceito um min. de " +
					min + " e um max. de " + max + "." );
				return false;
			} else {
				return true;
			}
		}

		function checkRegexp( o, regexp, n ) {
			if ( !( regexp.test( o.val() ) ) ) {
				o.addClass( "ui-state-error" );
				updateTips( n );
				return false;
			} else {
				return true;
			}
		}
		
		$( "#dialog-form" ).dialog({
			autoOpen: false,
			show: "fade",
			hide: "explode",
			resizable: false,
			height: 300,
			width: 350,
			modal: true,
			buttons: {
				"Cadastrar": function() {
					var bValid = true;
					var frm = document.forms[0];
					
					
					
					bValid = bValid && checkLength( empresa, "Empresa", 1, 50 );
					bValid = bValid && checkLength( tipo, "Tipo", 1, 20 );
					bValid = bValid && checkLength( qtdPoltrona, "Qtd Poltronas", 1, 3 );
					bValid = bValid && checkLength( placa, "Placa", 8, 8 );

					bValid = bValid && checkRegexp( empresa, /^[a-z]([0-9a-z_ ])+$/i, "Campo Empresa só aceita: a-z, 0-9" );
					// From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
					// bValid = bValid && checkRegexp( email, /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i, "eg. ui@jquery.com" );
					bValid = bValid && checkRegexp( tipo, /^([0-9a-zA-Z ])+$/, "Campo Tipo só aceita : a-z, 0-9" );
					bValid = bValid && checkRegexp( qtdPoltrona, /^([0-9])+$/, "Campo Qtd Poltronas só aceita : 0-9" );
					bValid = bValid && checkRegexp( placa, /^([0-9a-zA-Z-])+$/, "Campo Placa só aceita : a-z, 0-9, e "-" " );

					if ( bValid ) {
						frm.empresaParam.value = document.getElementById('empresa').value;
						frm.tipoParam.value = document.getElementById('tipo').value;
						frm.qtdPoltronaParam.value = document.getElementById('qtdPoltrona').value;
						frm.placaParam.value = document.getElementById('placa').value;
						frm.task.value = 'inserirOnibusNovo'
						frm.submit();
					}
					
					if ( bValid ) {
						$( "#users tbody" ).append( "<tr>" +
							"<td>" + empresa.val() + "</td>" + 
							"<td>" + tipo.val() + "</td>" + 
							"<td>" + qtdPoltrona.val() + "</td>" +
							"<td>" + placa.val() + "</td>" +
						"</tr>" );
						 
						$( this ).dialog( "close" );
					}
					
					
				},
				Cancel: function() {
					$( this ).dialog( "close" );
				}
			},
			close: function() {
				allFields.val( "" ).removeClass( "ui-state-error" );
			}
		});

		$( "#create-user" )
			.button()
			.click(function() {
				$( "#dialog-form" ).dialog( "open" );
			});
	});
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
							<html:text name="manterOnibusForm" property="onibusVO.qtdPoltronas" styleClass="input" value=""/>
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
	<div id="dialog-form" title="Create new user" >
	<p class="validateTips"></p>
	<table class="bordatabela" align="center" width="300px">
		<tr class="fundoescuro">
			<td align="center">
				<p>Todos os Campos são Obrigatórios!</p>
			</td>
		</tr>
	</table>

	<html:form action="/manterOnibus" >
	<table class="bordatabela" align="center" width="300px">
		<tr>
			<td class="fundoclaro" width="75px">
				<label for="empresa">Empresa:</label>
			</td>
			<td class="fundoclaro" align="left" width="75px">
				<input type="text" size="50" name="empresa" id="empresa" class="text ui-widget-content ui-corner-all" />
			</td>
		</tr>
		<tr>
			<td class="fundobranco" width="75px">
				<label for="tipo">Tipo:</label>
			</td>
			<td align="left" width="75px">
				<input type="text" size="50" name="tipo" id="tipo" value="" class="text ui-widget-content ui-corner-all" />
			</td>
		</tr>
		<tr>
			<td class="fundoclaro" width="75px">
				<label for="qtdPoltrona">Qtd Poltronas:</label>
			</td>
			<td class="fundoclaro" align="left" width="75px" >
				<input type="text" onkeypress="return somenteNumero(this,event,false,false,false)" size="5" maxlength="3" name="qtdPoltrona" id="qtdPoltrona" value="" class="text ui-widget-content ui-corner-all" />
			</td>
		</tr>
		<tr>
			<td class="fundobranco" width="75px">
				<label for="placa">Placa:</label>
			</td>
			<td align="left" width="75px">
				<input type="text" onkeypress="return formataPlaca(this,event,true)" name="placa" id="placa" value="" class="text ui-widget-content ui-corner-all" />
			</td>
		</tr>
	</table>
	</html:form>
</div>
<div align="center">
<button title="Novo Cadastrar" id="create-user" style="width: 10px; height: 10px;"></button>
</div>
</html:form>