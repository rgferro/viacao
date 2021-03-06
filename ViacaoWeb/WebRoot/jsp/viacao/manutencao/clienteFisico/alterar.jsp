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
				<jsp:include page="/jsp/common/mensagens.jsp"/>
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
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.login" styleClass="inputobrigatorio" size="20" maxlength="20"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td width="22%" align="center">Senha</td>
						<td width="78%" align="left" colspan="3">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.senha" styleClass="inputobrigatorio" size="20" maxlength="20"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">E-mail</td>
	
						<td align="left" colspan="3" width="78%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.email" styleClass="inputobrigatorio" size="30" maxlength="20"/>
						</td>
					</tr>
					<c:if test="${manterClienteFisicaForm.tipUsuario eq 'USUARIO'}">
						<tr class="fundoclaro">
							<td align="left" colspan="4"><ul><b><li>Dados Pessoais:</ul></td>
						</tr>	
						<tr class="fundoclaro">
		
							<td align="left" colspan="4" class="texto"><u><i>Pessoa F�sica</td>
						</tr>
						<tr class="fundoclaro">
							<td align="center" width="22%">Nome</td>
							<td align="left" colspan="3" width="78%">
								<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.nomPessoa" styleClass="inputobrigatorio" size="50" maxlength="50"/>
							</td>
						</tr>
						<tr class="fundoclaro">
							<td align="center" width="22%">CPF</td>
							<td align="left" width="28%">
								<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.cpfPessoa" styleClass="inputobrigatorio" size="15" maxlength="20" onkeypress="return somenteNumero(this,event,false,false,false)"/>
							</td>
							<td align="center" width="05%">RG</td>
							<td align="left" width="45%">
								<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.rgPessoa" styleClass="inputobrigatorio" size="15" maxlength="20" onkeypress="return somenteNumero(this,event,false,false,false)"/>
							</td>
						</tr>
					</c:if>
					<tr class="fundoclaro">
						<td align="left" colspan="4"><ul><b><li>Endere�o:</ul></td>
					</tr>			
					<tr class="fundoclaro">
						<td align="center" width="22%">Logradouro</td>
						<td align="left" width="78%" colspan="3">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.logradouro" styleClass="inputobrigatorio" size="90" maxlength="70"/>
						</td>
					</tr>
					<tr class="fundoclaro">
	
						<td align="center" width="22%">N�mero</td>
						<td align="left" width="28%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.numero" styleClass="inputobrigatorio" size="5" maxlength="10" onkeypress="return somenteNumero(this,event,false,false,false)"/>
						</td>
						<td align="center" width="18%">Complemento</td>
						<td align="left" width="32%%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.complemento" styleClass="input" size="30" maxlength="20"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">Bairro</td>
						<td align="left" width="28%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.bairro" styleClass="inputobrigatorio" size="20" maxlength="30"/>
						</td>
						<td align="center" width="18%">Cidade</td>
						<td align="left" width="32%%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.cidade" styleClass="inputobrigatorio" size="20" maxlength="30"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">Estado</td>
						<td align="left" width="78%" colspan="3">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.estado" styleClass="inputobrigatorio" size="5" maxlength="30"/>
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