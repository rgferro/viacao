<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript">

	function voltar(){
		var frm = document.forms[0];
		frm.task.value = 'unspecified';
		frm.submit();
	}
	
	function confirmar(){
		var frm = document.forms[0];
		frm.task.value = 'alterarFisica';
		frm.submit();
	}
</script>

<link href="css/portal.css" rel="stylesheet" type="text/css">

<html:form action="/manterClienteFisica">
<html:hidden property="task" name="manterClienteFisicaForm"/>
	<table width="600" border="0" align="center">
		<tr>
			<td>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Alterar Usu�rio<br></td>
					</tr>
				</table>
				<table width="100%" border="0" align="center" class="bordatabela">
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">Confirmar altera��o de Usu�rio<br></td>
					</tr>
					<tr class="fundoclaro">
						<td align="left" colspan="4"><ul><b><li>Dados de Acesso:</ul></td>
					</tr>
	
					<tr class="fundoclaro">
						<td width="22%" align="center">Login</td>
						<td width="88%" align="left" colspan="3">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.login" styleClass="input" maxlength="20"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td width="22%" align="center">Senha</td>
						<td width="78%" align="left" colspan="3">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.senha" styleClass="input" maxlength="20"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">E-mail</td>
	
						<td align="left" colspan="3" width="78%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.email" styleClass="input" maxlength="20"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="left" colspan="4"><ul><b><li>Dados Pessoais:</ul></td>
					</tr>	
					<tr class="fundoclaro">
	
						<td align="left" colspan="4" class="texto"><u><i>Pessoa F�sica</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">Nome</td>
						<td align="left" colspan="3" width="78%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.nomPessoa" styleClass="input" maxlength="50"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">CPF</td>
						<td align="left" width="28%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.cpfPessoa" styleClass="input" maxlength="20"/>
						</td>
						<td align="center" width="05%">RG</td>
						<td align="left" width="45%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.rgPessoa" styleClass="input" maxlength="20"/>
						</td>
					</tr>
	
					<tr class="fundoclaro">
						<td align="left" colspan="4"><ul><b><li>Endere�o:</ul></td>
					</tr>			
					<tr class="fundoclaro">
						<td align="center" width="22%">Logradouro</td>
						<td align="left" width="78%" colspan="3">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.logradouro" styleClass="input" maxlength="70"/>
						</td>
					</tr>
					<tr class="fundoclaro">
	
						<td align="center" width="22%">N�mero</td>
						<td align="left" width="28%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.numero" styleClass="input" maxlength="10"/>
						</td>
						<td align="center" width="18%">Complemento</td>
						<td align="left" width="32%%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.complemento" styleClass="input" maxlength="20"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">Bairro</td>
						<td align="left" width="28%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.bairro" styleClass="input" maxlength="30"/>
						</td>
						<td align="center" width="18%">Cidade</td>
						<td align="left" width="32%%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.cidade" styleClass="input" maxlength="30"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">Estado</td>
						<td align="left" width="78%" colspan="3">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.estado" styleClass="input" maxlength="30"/>
						</td>
					</tr>
	
				</table>
				<br>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center">
							<html:button value="Voltar" property="" styleClass="botao" onclick="voltar();"/>
						</td>
						<td align="center">
							<html:button value="Confirmar" property="" styleClass="botao" onclick="confirmar();"/>
						</td>
						
					</tr>
				</table>
			</td>
		</tr>
	</table>
</html:form>