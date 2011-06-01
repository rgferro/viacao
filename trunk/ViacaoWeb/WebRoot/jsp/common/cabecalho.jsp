<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/pagina.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/menu.js">

</script>
</head>
 <body onload="menuDropDown(4);">
  <img src="cabecalho/banner.jpg" width="100%" height="133"/>
 <table cellspacing="0" align="center" width="100%" style="background-image: url(cabecalho/fundobanner.jpg);">
 <tr>
 <td>
<table cellspacing="0" align="center" >
 <tr>
 <td>
<ul id="menu_dropdown" class="menubar">
   <li class="submenu"><a href="<%=request.getContextPath()%>/gerenciarTimes.do?task=listarTodosOsTimes">Times</a>
      <ul class="menu">
      </ul>
  </li>
   <li class="submenu"><a href="<%=request.getContextPath()%>/mostrarTimeCampeonatoMenu.do">Campeonatos</a>
      <ul class="menu">
      </ul>
  </li>
  <li class="submenu"><a href="<%=request.getContextPath()%>/gerenciarConta.do?task=iniciarPagLogin">Logar</a>
      <ul class="menu">                                                        
      </ul>
 </ul>
</td>
</tr>
</table>
</td>
</tr>
</table>
</body>
</html>
