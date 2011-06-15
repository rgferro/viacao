<%@ include file="/jsp/common/taglibs.jsp" %>

<script>
function confirmar(acao) {
	var frm = document.forms[0];
	if(acao == "INCLUIR"){
		frm.task.value = "incluir";
	}
	if(acao == "ALTERAR"){
		frm.task.value = "alterar";
	}
	if(acao == "DELETAR"){
		frm.task.value = "deletar";
	}
	frm.submit();
}
function inicio(flag) {
	var frm = document.forms[0];
	frm.busca.value = flag;
	frm.task.value = "unspecified";
	frm.submit();
}
function getTarifa(acao,seq) {
	var frm = document.forms[0];
	if(acao == "alterar"){
		frm.acao.value = "ALTERAR";
	}
	if(acao == "deletar"){
		frm.acao.value = "DELETAR";
	}
	frm.seqTarifa.value = seq;
	frm.task.value = "getTarifa";
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
	// Quando o usuario for digitar um numero, acrescenta uma virgula a partir do 3º caracter.
	// E se o usuario digitar uma virgula ele nao deixa outro ponto ser inserido. 

function formataCampoDecimal(maxlength,obj,e,ast,virg,ponto){
	var tecla=(window.event)?event.keyCode:e.which;
	var teste = obj.value.search("[.]");
	if(somenteNumero(obj,e,ast,virg,ponto)){
		if ((tecla == 46)&&(ponto)){
			if(teste == -1){
				if(obj.value.length == 0){
					obj.value = obj.value + "0.";
					return false;
				}else{
					return true;
				}
			}else{
				return false;
			}
		}else{
			if(teste == -1 && tecla != 8){
				if(obj.value.length == maxlength - 3){
					if(maxlength == 3){
						obj.value = obj.value + "0.";
					}else{
						obj.value = obj.value + ".";
					}
				}
				return true;
			}else{
				if(tecla != 8){
					for(var i=3; i <= obj.value.length;i++){
						if(obj.value.length == i){
							if(obj.value.indexOf(".")== i-3){
									return false;
								}
						}
					}
				}
			}
		}
	}else{
		return false;
	}
}
</script>
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
</script>

<html:form action="/manterTarifa">

<html:hidden name="manterTarifaForm" property="task"/>
<html:hidden name="manterTarifaForm" property="seqTarifa"/>
<html:hidden name="manterTarifaForm" property="acao"/>
<html:hidden name="manterTarifaForm" property="busca"/>
<body onLoad="MM_preloadImages('images/cancelar.png','images/confirmar.png','images/icon_lupa.png')">
<table width="600" border="0" align="center">
	<tr>
		<td>
			<jsp:include page="/jsp/common/mensagens.jsp" />
			
			<table width="100%" border="0" cellpadding="0" cellspacing="2" align="center" >
				<tr>
					<td class="titulo">ManterTarifa</td>
				</tr>
			</table>	
			<table width="100%" border="0" align="center" id="inserir" class="bordatabela">
				<tr class="fundoescuro" align="center">
					<td class="texto" width="20%" height="20">Ação</td>					
					<td width="40%" class="texto">
						Nome da Tarifa
					</td>
					<td width="40%" class="texto">
						Valor
					</td>
					<td width="20%" colspan="3">&nbsp;</td>
				</tr>
				<tr class="fundoclaro">
					<c:set var="disable" value="false"/>
					<logic:equal name="manterTarifaForm" property="acao" value="DELETAR">
						<td align="center" style="color: #FF0000">
						<c:set var="disable" value="true"/>
					</logic:equal>
					<logic:notEqual name="manterTarifaForm" property="acao" value="DELETAR">
						<td align="center" style="color: #0000FF">
					</logic:notEqual>
						<b><bean:write name="manterTarifaForm" property="acao"/></b></td>
					<td>
						<html:text name="manterTarifaForm" size="40" property="tarifaVO.nomTarifa" styleClass="input" disabled="${disable}"/>
					</td>
					<td>
						<html:text name="manterTarifaForm" size="40" property="tarifaVO.valor" styleClass="input" disabled="${disable}" onkeypress="return formataCampoDecimal(6,this,event,false,false,true)"/>
					</td>
					<td align="center"><a href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image3','','images/icon_lupa.png',1)"><img title="Pesquisar!" src="images/icon_lupaoff.png" name="Image3" height="16" width="16" onclick="javascript: inicio('pesquisar');"></a></td>
					<td align="center"><a href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image2','','images/confirmar.png',1)"><img title="Confirmar!" src="images/confirmaroff.png" name="Image2" height="16" width="16" onclick="javascript: confirmar('<bean:write name="manterTarifaForm" property="acao"/>');"></a></td>
					<td align="center"><a href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image1','','images/cancelar.png',1)"><img title="Cancelar!" src="images/cancelaroff.png" name="Image1" height="16" width="16" onclick="javascript: inicio('');"></a></td>
				</tr>
			</table>
			<br>
			<table width="100%" border="0" cellpadding="0" cellspacing="2" align="center" class="bordatabela">
				<tr class="fundoescuro">
					<td width="10%" height="20" colspan="2">&nbsp;</td>
					<td width="45%"  align="center">Nome da Tarifa</td>
					<td width="45%" align="center">Valor(R$)</td>
				</tr>
				<logic:empty name="manterTarifaForm" property="listaTarifas">
					<tr>
						<td align="center" colspan="4" class="texto">Nenhuma tarifa foi encontrada!</td>
					</tr>
				</logic:empty>
				<logic:iterate id="varInterno" name="manterTarifaForm" property="listaTarifas" indexId="index">
					<c:if test="${index % 2 == 0}">
						<tr class="fundobranco">
					</c:if>
					<c:if test="${index % 2 != 0}">
						<tr class="fundoclaro">
					</c:if>
					<tr>
						<td><img title="Editar!" src="images/icon_editar3.png" height="20" width="20" onclick="javascript: getTarifa('alterar',<bean:write name="varInterno" property="seqTarifa"/>);"></a></td>
						<td><img title="Deletar!" src="images/icon_lixeira3.png" height="20" width="20" name="Image4" onclick="javascript: getTarifa('deletar', <bean:write name="varInterno" property="seqTarifa"/>);"></a></td>
						<td align="center"><bean:write name="varInterno" property="nomTarifa"/></td>
						<td align="center"><bean:write name="varInterno" property="valor"/></td>
					</tr>
				</logic:iterate>
			</table>
		</td>
	</tr>
</table>
</body>
</html:form>