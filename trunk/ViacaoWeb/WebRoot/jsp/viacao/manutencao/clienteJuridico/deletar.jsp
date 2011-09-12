<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript">

	function voltar(){
		var frm = document.forms[0];
		frm.task.value = 'unspecified';
		frm.submit();
	}
	
	function confirmar(){
		var frm = document.forms[0];
		frm.task.value = 'deletarJuridica';
		frm.submit();
	}
</script>

<link href="css/portal.css" rel="stylesheet" type="text/css">

<html:form action="/manterClienteJuridica">
<html:hidden property="task" name="manterJuridicaForm"/>
	<table width="600" border="0" align="center">
		<tr>
			<td>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Excluir Usuário<br></td>
					</tr>
				</table>
				<table width="100%" border="0" align="center" class="bordatabela">
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">Deletar Usuário<br></td>
					</tr>
					<tr class="fundoclaro">
						<td align="left" colspan="4"><ul><b><li>Dados de Acesso:</ul></td>
					</tr>
	
					<tr class="fundoclaro">
						<td width="22%" align="center">Login</td>
						<td width="88%" align="left" colspan="3">
							<html:text disabled="true" name="manterJuridicaForm" property="juridicaVO.clienteVO.login" styleClass="inputdeletar" size="20" maxlength="20"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td width="22%" align="center">Senha</td>
						<td width="78%" align="left" colspan="3">
							<html:text disabled="true" name="manterJuridicaForm" property="juridicaVO.clienteVO.senha" styleClass="inputdeletar" size="20" maxlength="20"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">E-mail</td>
	
						<td align="left" colspan="3" width="78%">
							<html:text disabled="true" name="manterJuridicaForm" property="juridicaVO.clienteVO.email" styleClass="inputdeletar" size="30" maxlength="20"/>
						</td>
					</tr>
					<c:if test="${manterJuridicaForm.tipUsuario eq 'USUARIO'}">
						<tr class="fundoclaro">
							<td align="left" colspan="4"><ul><b><li>Dados Pessoais:</ul></td>
						</tr>	
						<tr class="fundoclaro">
						<td align="left" colspan="4" class="texto"><u><i>Pessoa Jurídica</td>
						</tr>
						<tr class="fundoclaro">
							<td align="center" width="22%">Nome responsável</td>
							<td align="left" colspan="3" width="78%">
								<html:text disabled="true" name="manterJuridicaForm" property="juridicaVO.nomResponsavel" styleClass="inputdeletar" size="50" maxlength="50"/>
							</td> 
						</tr>
						<tr class="fundoclaro">
							<td align="center" width="22%">Nome da Empresa</td>
							<td align="left" colspan="3" width="78%">
								<html:text disabled="true" name="manterJuridicaForm" property="juridicaVO.nomFantasia" styleClass="inputdeletar" size="50" maxlength="50"/>
							</td> 
						</tr>
						<tr class="fundoclaro">
							<td align="center" width="22%">Razão social</td>
		
							<td align="left" colspan="3" width="78%">
								<html:text disabled="true" name="manterJuridicaForm" property="juridicaVO.razaoSocial" styleClass="inputdeletar" size="50" maxlength="50"/>
							</td> 
						</tr>
						<tr class="fundoclaro">
							<td align="center" width="22%">CNPJ</td>
							<td align="left" width="28%">
								<html:text disabled="true" name="manterJuridicaForm" property="juridicaVO.cnpj" styleClass="inputdeletar" size="20" maxlength="80"/>
							</td>
							<td align="center" width="18%">Inscrição estadual</td>
							<td align="left" width="32%%">
								<html:text disabled="true" name="manterJuridicaForm" property="juridicaVO.numInscricao" styleClass="inputdeletar" size="20" maxlength="30"/>
							</td>
						</tr>
					</c:if>
					<tr class="fundoclaro">
						<td align="left" colspan="4"><ul><b><li>Endereço:</ul></td>
					</tr>			
					<tr class="fundoclaro">
						<td align="center" width="22%">Logradouro</td>
						<td align="left" width="78%" colspan="3">
							<html:text disabled="true" name="manterJuridicaForm" property="juridicaVO.clienteVO.enderecoVO.logradouro" styleClass="inputdeletar" size="90" maxlength="70"/>
						</td>
					</tr>
					<tr class="fundoclaro">
	
						<td align="center" width="22%">Número</td>
						<td align="left" width="28%">
							<html:text disabled="true" name="manterJuridicaForm" property="juridicaVO.clienteVO.enderecoVO.numero" styleClass="inputdeletar" size="5" maxlength="10"/>
						</td>
						<td align="center" width="18%">Complemento</td>
						<td align="left" width="32%%">
							<html:text disabled="true" name="manterJuridicaForm" property="juridicaVO.clienteVO.enderecoVO.complemento" styleClass="inputdeletar" size="30" maxlength="20"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">Bairro</td>
						<td align="left" width="28%">
							<html:text disabled="true" name="manterJuridicaForm" property="juridicaVO.clienteVO.enderecoVO.bairro" styleClass="inputdeletar" size="20" maxlength="30"/>
						</td>
						<td align="center" width="18%">Cidade</td>
						<td align="left" width="32%%">
							<html:text disabled="true" name="manterJuridicaForm" property="juridicaVO.clienteVO.enderecoVO.cidade" styleClass="inputdeletar" size="20" maxlength="30"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">Estado</td>
						<td align="left" width="78%" colspan="3">
							<html:text disabled="true" name="manterJuridicaForm" property="juridicaVO.clienteVO.enderecoVO.estado" styleClass="inputdeletar" size="5" maxlength="30"/>
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
