<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript">
function ir(parametro){
	var frm = document.forms[0];
	frm.task.value = '';
	frm.submit();
}

</script>
<form action="/exemplo">
<table width="600" border="0" align="center">
	<tr>
		<td>
			<table width="100%" border="0" align="center">
				<tr>
					<td class="titulo">Concluir Compra</td>
				</tr>
			</table>
			<br>
			<table width="100%" border="0" align="center">
				<tr>
					<td align="center" colspan="4" class="texto"><img height="25" src="images/check-icon2.png"></img> Compra efetuada com sucesso!</td>
				</tr>
			</table>
			<br>
			<table width="100%" border="0" align="center" class="bordatabela">
				<tr class="fundoescuro">
					<td colspan="4">O que deseja realizar agora?</td>
				</tr>
			</table>
			<br>
			<table width="100%" border="0" align="center">
				<tr>
					<td><input type="button" class="botao" value="Imprimir passagem"></td>
					<td><input type="button" class="botao" value="Enviar passagem para e-mail"></td>
					<td><input type="button" class="botao" value="Retorna para p�gina inicial" onclick=ir();></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
