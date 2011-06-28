<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript">
	function teste(acao){
		if(acao == 'fisica'){
			document.getElementById(acao).style.display = '';
			document.getElementById('juridica').style.display = 'none';
		} 
		if (acao == 'juridica'){
			document.getElementById('fisica').style.display = 'none';
			document.getElementById('juridica').style.display = 'none';
		} if(acao == 'limpar') {
			document.getElementById('fisica').style.display = 'none';
			document.getElementById('juridica').style.display = 'none';
		}
	}
	
	function voltar(){
		var frm = document.forms[0];
		frm.task.value = 'unspecified';
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
						<td class="titulo">Cadastrar Usu�rio<br></td>
					</tr>
				</table>
				<table width="100%" border="0" align="center" class="bordatabela">
					<tr class="fundoescuro">
						<td colspan="4" align="center" class="texto">Cadastro<br></td>
					</tr>
					<tr class="fundoclaro">
						<td align="left" colspan="4"><ul><b><li>Dados de Acesso:</ul></td>
					</tr>
	
					<tr class="fundoclaro">
						<td align="center">Login</td>
						<td align="left" colspan="3">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.login" styleClass="inputobrigatorio" size="20" />
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center">Senha</td>
						<td align="left" colspan="3">
							<input type="password" name="clienteVO.senha" size="20" class="inputobrigatorio" maxlength="20">
						</td>
					</tr>
					<c:set var="testSenha"/>
					<tr class="fundoclaro">
						<td align="center">Confirme a sua senha</td>
						<td align="left" colspan="3">
							<input type="password" name="testSenha" size="20" class="inputobrigatorio" maxlength="20" size="20" >
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center">
							<input type="radio" name="radio2" onclick="teste('fisica');">Usuario
						</td>
						<td align="left" colspan="3" >
							<input type="radio" name="radio2" onclick="teste('juridica');">Administrador
						</td> 
					</tr>
					<tr class="fundoclaro">
						<td align="left" colspan="4"><ul><b><li>Dados Pessoais:</ul></td>
					</tr>	
					<tr>
						<td colspan="4">
							<table width="100%" border="0" align="center" class="bordatabela" style="display: none;" id="fisica">
								<tr class="fundoclaro">
				
									<td align="left" colspan="4" class="texto"><u><i>Pessoa F�sica</td>
								</tr>
								<tr class="fundoclaro">
									<td align="center" width="22%">Nome</td>
									<td align="left" colspan="3" width="78%">
										<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.nomPessoa" styleClass="inputobrigatorio" size="50" />
									</td>
								</tr>
								<tr class="fundoclaro">
									<td align="center" width="22%">E-mail</td>
				
									<td align="left" colspan="3" width="78%">
										<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.email" styleClass="inputobrigatorio" size="30" />
									</td>
								</tr>
								<tr class="fundoclaro">
									<td align="center" width="22%">CPF</td>
									<td align="left" width="28%">
										<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.cpfPessoa" styleClass="inputobrigatorio" size="15" />
									</td>
									<td align="center" width="05%">RG</td>
									<td align="left" width="45%">
										<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.rgPessoa" styleClass="inputobrigatorio" size="15" />
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="left" colspan="4"><ul><b><li>Endere�o:</ul></td>
					</tr>			
					<tr class="fundoclaro">
						<td align="center" width="22%">Logradouro</td>
						<td align="left" width="78%" colspan="3">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.logradouro" styleClass="inputobrigatorio" size="90" />
						</td>
					</tr>
					<tr class="fundoclaro">
	
						<td align="center" width="22%">N�mero</td>
						<td align="left" width="28%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.numero" styleClass="inputobrigatorio" size="5" />
						</td>
						<td align="center" width="18%">Complemento</td>
						<td align="left" width="32%%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.complemento" styleClass="inputobrigatorio" size="30" />
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">Bairro</td>
						<td align="left" width="28%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.bairro" styleClass="inputobrigatorio" size="20" />
						</td>
						<td align="center" width="18%">Cidade</td>
						<td align="left" width="32%%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.cidade" styleClass="inputobrigatorio" size="20" />
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">Estado</td>
						<td align="left" width="78%" colspan="3">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.estado" styleClass="inputobrigatorio" size="5" />
						</td>
					</tr>
	
				</table>
				<br>
				<table width="100%" border="0" align="center">
					<tr>
						<td align="center"><input class="botao" value="Voltar" type="button" onclick="voltar()"/></td>
						<td align="center"><input class="botao" value="Cadastrar" type="button" onclick=""/></td>
						<td align="center"><input class="botao" value="Limpar" type="reset" onclick="teste('limpar');"/></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</html:form>