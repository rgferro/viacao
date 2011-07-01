<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript">
	function teste(acao){
		if(acao == 'fisica'){
			document.getElementById('fisica').style.display = '';
		} 
		if(acao == 'juridica'){
			document.getElementById('fisica').style.display = 'none';
		} 
		if(acao == 'limpar') {
			document.getElementById('fisica').style.display = 'none';
			document.getElementById('juridica').style.display = 'none';
		}
	}
	
	function voltar(){
		var frm = document.forms[0];
		frm.task.value = 'unspecified';
		frm.submit();
	}
	
	function cadastrar(){
		var frm = document.forms[0];
		frm.task.value = 'inserirFisica';
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
</script>

<link href="css/portal.css" rel="stylesheet" type="text/css">

<html:form action="/manterClienteFisica">
<html:hidden property="task" name="manterClienteFisicaForm"/>
	<table width="600" border="0" align="center">
		<tr>
			<td>
				<jsp:include page="/jsp/common/mensagens.jsp" />
				<table width="100%" border="0" align="center">
					<tr>
						<td class="titulo">Cadastrar Usuário<br></td>
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
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.login" styleClass="inputobrigatorio" size="20" maxlength="20"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center">Senha</td>
						<td align="left" colspan="3">
							<input type="password" name="fisicaVO.clienteVO.senha" size="20" class="inputobrigatorio" maxlength="20"/>
						</td>
					</tr>
					<c:set var="testSenha"/>
					<tr class="fundoclaro">
						<td align="center">Confirme a sua senha</td>
						<td align="left" colspan="3">
							<input type="password" name="testSenha" size="20" class="inputobrigatorio" maxlength="20" size="20" maxlength="20"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center" width="22%">E-mail</td>
	
						<td align="left" colspan="3" width="78%">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.email" styleClass="inputobrigatorio" size="30" maxlength="20"/>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="center">
							<html-el:radio name="manterClienteFisicaForm" property="tipUsuario" value="USUARIO" onclick="teste('fisica');"/>Usuário
						</td>
						<td align="left" colspan="3" >
							<html-el:radio name="manterClienteFisicaForm" property="tipUsuario" value="ADMINISTRADOR" onclick="teste('juridica');"/>Administrador
						</td> 
					</tr>	
					<tr>
						<td colspan="4">
							<table width="100%" border="0" align="center" class="bordatabela" style="display: none;" id="fisica">
								<tr class="fundoclaro">
									<td align="left" colspan="4"><ul><b><li>Dados Pessoais:</ul></td>
								</tr>
								<tr class="fundoclaro">
									<td align="left" colspan="4" class="texto"><u><i>Pessoa Física</td>
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
										<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.cpfPessoa" styleClass="inputobrigatorio" size="15" maxlength="20"/>
									</td>
									<td align="center" width="05%">RG</td>
									<td align="left" width="45%">
										<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.rgPessoa" styleClass="inputobrigatorio" size="15" maxlength="20"/>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr class="fundoclaro">
						<td align="left" colspan="4"><ul><b><li>Endereço:</ul></td>
					</tr>			
					<tr class="fundoclaro">
						<td align="center" width="22%">Logradouro</td>
						<td align="left" width="78%" colspan="3">
							<html:text disabled="false" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.logradouro" styleClass="inputobrigatorio" size="90" maxlength="70"/>
						</td>
					</tr>
					<tr class="fundoclaro">
	
						<td align="center" width="22%">Número</td>
						<td align="left" width="28%">
							<html:text disabled="false" onkeypress="return somenteNumero(this,event,false,false,false)" name="manterClienteFisicaForm" property="fisicaVO.clienteVO.enderecoVO.numero" styleClass="inputobrigatorio" size="5" maxlength="10"/>
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
						<td align="center"><input class="botao" value="Voltar" type="button" onclick="voltar()"/></td>
						<td align="center"><input class="botao" value="Cadastrar" type="button" onclick="cadastrar()"/></td>
						<td align="center"><input class="botao" value="Limpar" type="reset" onclick="teste('limpar');"/></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</html:form>