<%@ include file="/jsp/common/taglibs.jsp" %>

<script type="text/javascript">
function ir(parametro){
	var frm = document.forms[0];
	alert(parametro);
	if(parametro == "ir"){
		frm.task.value = 'carrinhoDeCompra';
	}else{
		frm.task.value = 'condicoesDeCompra';
	}
	frm.submit();
}

function selecionarPoltrona(o, seqPoltrona){
	var frm = document.forms[0];
	
	if (o.className == "libre"){
	    o.className = "seleccionada";
	    var formDibujo=document.getElementById("dibujo");
	    var newField = document.createElement("input");
	    newField.type = "hidden";
	    newField.seqPoltrona = seqPoltrona;
	    newField.value = o.firstChild.data;
	    o.appendChild(newField);
	} else {
	    o.className = "libre";
	    if (o.lastChild.type == "hidden"){
	            o.removeChild(o.lastChild);
	    }
	}
	
	//go('manterCompra.do?task=selecionarPoltrona&seqPoltrona='+seqPoltrona);
}
</script>

<html:form action="/manterCompra">
<html:hidden property="task" name="manterCompraForm"/>
<table width="600" border="0" align="center">
	<tr>
		<td>
			<table width="100%" border="0" align="center">
				<tr>
					<td class="titulo">Escolher Poltrona</td>
				</tr>
			</table>
			<br>
			<table width="100%" border="0" align="center" id="buscar" class="bordatabela">
				<tr class="fundoescuro">
					<td class="texto" align="center" colspan="4"><b><i>RIO DE JANEIRO</b></i> para <i><b>JUIZ DE FORA</b></i> - 26/09/2011</td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" width="10%">Origem</td>
					<td width="35%"><input class="input" value="Rio de Janeiro" size="20" disabled="disabled"></td>
					<td class="texto" width="15%">Destino</td>
					<td width="40%"><input class="input" value="Juiz de Fora" size="20" disabled="disabled"></td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" width="10%">Data Partida</td>
					<td width="32%"><input class="input" value="26/09/2011" size="15" disabled="disabled"></td>
					<td class="texto" width="08%">Hora Partida</td>
					<td width="42%"><input class="input" value="15:00" size="10" disabled="disabled"></td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" width="10%">Data Chegada</td>
					<td width="32%"><input class="input" value="06/06/2011" size="15" disabled="disabled"></td>
					<td class="texto" width="08%">Hora Chegada</td>
					<td width="42%"><input class="input" value="19:00" size="10" disabled="disabled"></td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" width="15%">Tempo de viagem</td>
					<td width="32%"><input class="input" value="240" size="6" disabled="disabled">min.</td>
					<td align="center" colspan="2"><a href="" class="link">Visualizar percurso</a></td>
				</tr>
			</table>
			<table width="100%" border="0" align="center" id="buscar" class="bordatabela">
				<tr class="fundoescuro">
					<td class="texto" align="center" colspan="4">Detalhes do ônibus</td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" width="18%">Tipo de ônibus</td>
					<td width="32%"><input class="input" value="Executivo" size="20" disabled="disabled"></td>
					<td class="texto" width="08%">Empresa</td>
					<td width="42%"><input class="input" value="Util" size="20" disabled="disabled"></td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" width="18%">Qtd. de poltrona</td>
					<td width="32%"><input class="input" value="18" size="3" disabled="disabled"></td>
					<td class="texto" width="23%">Qtd. de poltrona vagas</td>
					<td width="27%"><input class="input" value="08" size="3" disabled="disabled"></td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" width="18%">Placa</td>
					<td width="82%" colspan="3"><input class="input" value="ANS-3669" size="12" disabled="disabled"></td>
				</tr>
			</table>
			<br>
			<br>
			
			<div id="fndLegenda">
			
			</div>
						<div id="buss">
							<table class="cpo1" border="0" cellpadding="2" cellspacing="2" >
								<tr>
									<td>
										<table class="cpo1" border="0" cellpadding="2" cellspacing="2">
											<tr>
												<td class="ocupada">03</td>
												<td class="ocupada">07</td>
												<td class="ocupada">11</td>
												<td class="ocupada">15</td>
												<td class="ocupada">19</td>
												<td class="libre" onclick="selecionarPoltrona(this, 'bi0');">23</td>
												<td class="ocupada">27</td>
												<td class="ocupada">31</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">35</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">39</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">43</td>
												<td class="vacia">&nbsp;&nbsp;</td>
											</tr>
											<tr>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">04</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">08</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">12</td>
												<td class="ocupada">16</td><td class="ocupada">20</td>
												<td class="ocupada">24</td><td class="ocupada">28</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">32</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">36</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">40</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">44</td>
												<td class="vacia">&nbsp;&nbsp;</td>
											</tr>
											<tr>
												<td class="vacia">&nbsp;&nbsp;</td>
												<td class="vacia">&nbsp;&nbsp;</td>
												<td class="vacia">&nbsp;&nbsp;</td>
												<td class="vacia">&nbsp;&nbsp;</td>
												<td class="vacia">&nbsp;&nbsp;</td>
												<td class="vacia">&nbsp;&nbsp;</td>
												<td class="vacia">&nbsp;&nbsp;</td>
												<td class="vacia">&nbsp;&nbsp;</td>
												<td class="vacia">&nbsp;&nbsp;</td>
												<td class="vacia">&nbsp;&nbsp;</td>
												<td class="vacia">&nbsp;&nbsp;</td>
												<td class="vacia">&nbsp;&nbsp;</td>
											</tr>
											<tr>
												<td class="ocupada">02</td>
												<td class="ocupada">06</td>
												<td class="ocupada">10</td>
												<td class="ocupada">14</td>
												<td class="ocupada">18</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">22</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">26</td>
												<td class="ocupada">30</td>
												<td class="ocupada">34</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">38</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">42</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">46</td>
											</tr>
											<tr>
												<td class="ocupada">01</td>
												<td class="ocupada">05</td>
												<td class="ocupada">09</td>
												<td class="ocupada">13</td>
												<td class="ocupada">17</td>
												<td class="ocupada">21</td>
												<td class="ocupada">25</td>
												<td class="ocupada">29</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">33</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">37</td>
												<td class="libre" onclick="selecionarPoltrona(this,'bi0');">41</td>
												<td class="ocupada">45</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</div>
			<br/>
			<br>
			<table width="100%" border="0" align="center" id="buscar" class="bordatabela">
				<tr class="fundoescuro">
					<td class="texto" align="center" colspan="4"><b><i>JUIZ DE FORA</b></i> para <i><b>RIO DE JANEIRO</b></i> - 29/09/2011</td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" width="10%">Origem</td>
					<td width="35%"><input class="input" value="Juiz de Fora" size="20" disabled="disabled"></td>
					<td class="texto" width="15%">Destino</td>
					<td width="40%"><input class="input" value="Rio de Janeiro" size="20" disabled="disabled"></td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" width="10%">Data Partida</td>
					<td width="32%"><input class="input" value="29/09/2011" size="15" disabled="disabled"></td>
					<td class="texto" width="08%">Hora Partida</td>
					<td width="42%"><input class="input" value="15:00" size="10" disabled="disabled"></td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" width="10%">Data Chegada</td>
					<td width="32%"><input class="input" value="29/09/2011" size="15" disabled="disabled"></td>
					<td class="texto" width="08%">Hora Chegada</td>
					<td width="42%"><input class="input" value="19:00" size="10" disabled="disabled"></td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" width="15%">Tempo de viagem</td>
					<td width="32%"><input class="input" value="240" size="6" disabled="disabled">min.</td>
					<td align="center" colspan="2"><a href="" class="link">Visualizar percurso</a></td>
				</tr>
			</table>
			<table width="100%" border="0" align="center" id="buscar" class="bordatabela">
				<tr class="fundoescuro">
					<td class="texto" align="center" colspan="4">Detalhes do ônibus</td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" width="18%">Tipo de ônibus</td>
					<td width="32%"><input class="input" value="Executivo" size="20" disabled="disabled"></td>
					<td class="texto" width="08%">Empresa</td>
					<td width="42%"><input class="input" value="Util" size="20" disabled="disabled"></td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" width="18%">Qtd. de poltrona</td>
					<td width="32%"><input class="input" value="18" size="3" disabled="disabled"></td>
					<td class="texto" width="23%">Qtd. de poltrona vagas</td>
					<td width="27%"><input class="input" value="08" size="3" disabled="disabled"></td>
				</tr>
				<tr class="fundoclaro">
					<td class="texto" width="18%">Placa</td>
					<td width="82%" colspan="3"><input class="input" value="ANS-3669" size="12" disabled="disabled"></td>
				</tr>
			</table>
			<br>
			<br>
			
			<div id="fndLegenda">
			
			</div>
				<div id="buss">
					<table class="cpo1" border="0" cellpadding="2" cellspacing="2" >
						<tr>
							<td>
								<table class="cpo1" border="0" cellpadding="2" cellspacing="2">
									<tr>
										<td class="libre">03</td>
										<td class="libre">07</td>
										<td class="libre">11</td>
										<td class="libre">15</td>
										<td class="libre">19</td>
										<td class="libre" onclick="selecionarPoltrona(this, 'bi0');">23</td>
										<td class="libre">27</td>
										<td class="libre">31</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">35</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">39</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">43</td>
										<td class="vacia">&nbsp;&nbsp;</td>
									</tr>
									<tr>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">04</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">08</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">12</td>
										<td class="libre">16</td><td class="libre">20</td>
										<td class="libre">24</td><td class="libre">28</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">32</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">36</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">40</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">44</td>
										<td class="vacia">&nbsp;&nbsp;</td>
									</tr>
									<tr>
										<td class="vacia">&nbsp;&nbsp;</td>
										<td class="vacia">&nbsp;&nbsp;</td>
										<td class="vacia">&nbsp;&nbsp;</td>
										<td class="vacia">&nbsp;&nbsp;</td>
										<td class="vacia">&nbsp;&nbsp;</td>
										<td class="vacia">&nbsp;&nbsp;</td>
										<td class="vacia">&nbsp;&nbsp;</td>
										<td class="vacia">&nbsp;&nbsp;</td>
										<td class="vacia">&nbsp;&nbsp;</td>
										<td class="vacia">&nbsp;&nbsp;</td>
										<td class="vacia">&nbsp;&nbsp;</td>
										<td class="vacia">&nbsp;&nbsp;</td>
									</tr>
									<tr>
										<td class="libre">02</td>
										<td class="libre">06</td>
										<td class="libre">10</td>
										<td class="libre">14</td>
										<td class="libre">18</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">22</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">26</td>
										<td class="libre">30</td>
										<td class="libre">34</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">38</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">42</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">46</td>
									</tr>
									<tr>
										<td class="libre">01</td>
										<td class="libre">05</td>
										<td class="libre">09</td>
										<td class="libre">13</td>
										<td class="libre">17</td>
										<td class="libre">21</td>
										<td class="libre">25</td>
										<td class="libre">29</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">33</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">37</td>
										<td class="libre" onclick="selecionarPoltrona(this,'bi0');">41</td>
										<td class="libre">45</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			<br/>
			<table width="30%" border="0" align="center">
				<tr>
					<td align="center">
						<input class="botao" value="Voltar" type="button" onclick=ir();>
					</td>
					<td align="center">
						<input class="botao" value="Efetuar compra" type="button" onclick=ir('ir');>
					</td>
				</tr>
			</table>
			<br>
		</td>
	</tr>
</table>
</html:form>