<%@ include file="taglibs.jsp"%> 
<link type="text/css" href="css/custom-theme/jquery-ui-1.8.13.custom.css" rel="stylesheet" />	
<script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.13.custom.min.js"></script>
<script type="text/javascript">
			$(function(){
				//hover states on the static widgets
				$('#dialog_link, ul#icons li').hover(
					function() { $(this).addClass('ui-state-hover'); }, 
					function() { $(this).removeClass('ui-state-hover'); }
				);		
			});
</script>
		
<logic:messagesPresent message="true">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0" class="texto">
	
		<!-- MENSAGENS DE ERRO -->
		<html:messages  id="messages" message="true" property="ERRO">
			<tr>
				<td width="10%">
					<div class="ui-widget">
						<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;"> 
							<p><span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span> 
							<b><c:out value="${messages}" escapeXml="false"/></b></p>
						</div>
					</div>	
				</td>
			</tr>
		</html:messages>
		
		<!-- MENSAGENS DE SUCESSO -->
		<html:messages  id="messages" message="true" property="SUCESSO">
			<tr>
				<td width="10%">
					<div class="ui-widget">
						<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;"> 
							<p><span class="ui-icon ui-icon-circle-check" style="float: left; margin-right: .3em;"></span>
							<b><c:out value="${messages}" escapeXml="false"/></b></p>
						</div>
					</div>
				</td>
			</tr>
		</html:messages>
		<!-- MENSAGENS DE AVISO -->
		<html:messages  id="messages" message="true" property="AVISO">
			<tr>
				<td width="10%">
					<img src='images/icon_atencao.gif' border=0 /> 
				</td>
				<td>
					<b><c:out value="${messages}" escapeXml="false"/></b>
				</td>
			</tr>
		</html:messages>
	</table>
</logic:messagesPresent>
<BR>