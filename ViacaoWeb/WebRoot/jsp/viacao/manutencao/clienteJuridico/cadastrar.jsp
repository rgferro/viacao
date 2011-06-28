<%@ include file="/jsp/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<script type="text/javascript">
function cadastrar(){
	var frm = document.forms[0];
	frm.task.value = 'inserirJuridica';
	frm.submit();
}

function voltar(){
	var frm = document.forms[0];
	frm.task.value = 'unspecified';
	frm.submit();
}
</script>

<link href="css/portal.css" rel="stylesheet" type="text/css">

<html:form action="/manterCliente">
<html:hidden property="task" name="manterJuridicaForm"/>
	<table width="600" border="0" align="center">
		<tr>
			<td>
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Cadastro<br></td>
					</tr>
				</table>
	
				<br>
				<table width="100%" border="0" align="center" id="cadastrar" class="bordatabela">
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">Cadastro<br></td>
					</tr>
					<tr class="fundoclaro">
						<td align="left" colspan="4"><ul><b><li>Dados de Acesso:</ul></td>
					</tr>
	
					<tr class="fundoclaro">
						<td width="22%" align="center">Login</td>
						<td width="88%" align="left" colspan="3">
							<html:text name="manterJuridicaForm" property="juridicaVO.clienteVO.login" size="20" styleClass="inputobrigatorio"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td width="22%" align="center">Senha</td>
						<td width="78%" align="left" colspan="3">
							<html:text name="manterJuridicaForm" property="juridicaVO.clienteVO.senha" size="20" styleClass="inputobrigatorio"/>
						</td>
					</tr>
	
					<tr class="fundoclaro">
						<td width="22%" align="center">Confirme a sua senha</td>
						<td width="78%" align="left" colspan="3">
							<input type="text" class="inputobrigatorio" size="20"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center">
							<html-el:radio name="manterJuridicaForm" property="tipUsuario" value="USUARIO"/>
								Usuário</td>
						<td align="left" colspan="3">
							<html-el:radio name="manterJuridicaForm" property="tipUsuario" value="ADMINISTRADOR"/>
								Administrador</td> 
					</tr>
	
					<tr class="fundoclaro">
						<td align="left" colspan="4"><ul><b><li>Dados Pessoais:</ul></td>
					</tr>
					
					<tr class="fundoclaro">
						<td align="left" colspan="4" class="texto"><u><i>Pessoa Jurídica</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">Nome responsável</td>
						<td align="left" colspan="3" width="78%">
							<html:text name="manterJuridicaForm" property="juridicaVO.nomResponsavel" size="50" styleClass="inputobrigatorio"/>
						</td> 
					</tr>
					<tr class="fundoclaro">
	
						<td align="center" width="22%">E-mail</td>
						<td align="left" colspan="3" width="78%">
							<html:text name="manterJuridicaForm" property="juridicaVO.clienteVO.email" size="30" styleClass="inputobrigatorio"/>
						</td> 
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">Nome da Empresa</td>
						<td align="left" colspan="3" width="78%">
							<html:text name="manterJuridicaForm" property="juridicaVO.nomFantasia" size="50" styleClass="inputobrigatorio"/>
						</td> 
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">Razão social</td>
	
						<td align="left" colspan="3" width="78%">
							<html:text name="manterJuridicaForm" property="juridicaVO.razaoSocial" size="50" styleClass="inputobrigatorio"/>
						</td> 
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">CNPJ</td>
						<td align="left" width="28%">
							<html:text name="manterJuridicaForm" property="juridicaVO.cnpj" size="20" styleClass="inputobrigatorio"/>
						</td>
						<td align="center" width="18%">Inscrição estadual</td>
						<td align="left" width="32%%">
							<html:text name="manterJuridicaForm" property="juridicaVO.numInscricao" size="20" styleClass="inputobrigatorio"/>
						</td>
					</tr>
	
					<tr class="fundoclaro">
						<td align="left" colspan="4"><ul><b><li>Endereço:</ul></td>
					</tr>			
					<tr class="fundoclaro">
						<td align="center" width="22%">Logradouro</td>
						<td align="left" width="78%" colspan="3">
							<html:text name="manterJuridicaForm" property="juridicaVO.clienteVO.enderecoVO.logradouro" size="88" styleClass="inputobrigatorio"/>
						</td>
					</tr>
					<tr class="fundoclaro">
	
						<td align="center" width="22%">Número</td>
						<td align="left" width="28%">
							<html:text name="manterJuridicaForm" property="juridicaVO.clienteVO.enderecoVO.numero" size="5" styleClass="inputobrigatorio"/>
						</td>
						<td align="center" width="18%">Complemento</td>
						<td align="left" width="32%%">
							<html:text name="manterJuridicaForm" property="juridicaVO.clienteVO.enderecoVO.complemento" size="30" styleClass="input"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">Bairro</td>
	
						<td align="left" width="28%">
							<html:text name="manterJuridicaForm" property="juridicaVO.clienteVO.enderecoVO.bairro" size="20" styleClass="inputobrigatorio"/>
						</td>
						<td align="center" width="18%">Cidade</td>
						<td align="left" width="32%%">
							<html:text name="manterJuridicaForm" property="juridicaVO.clienteVO.enderecoVO.cidade" size="20" styleClass="inputobrigatorio"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">Estado</td>
						<td align="left" width="78%" colspan="3">
							<html:text name="manterJuridicaForm" property="juridicaVO.clienteVO.enderecoVO.estado" size="5" styleClass="inputobrigatorio"/>
						</td>
					</tr>
	
				</table>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center">
							<html:button value="Voltar" property="" styleClass="botao" onclick="voltar();"/>
						</td>
						<td align="center">
							<html:button value="Cadastrar" property="" styleClass="botao" onclick="cadastrar();"/>
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