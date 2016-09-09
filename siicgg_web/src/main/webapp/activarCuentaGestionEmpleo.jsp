<%@ page import="com.besixplus.sii.util.Env" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Registro Empresarial</title>
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css" />
<%out.println(Env.loadExternalScripts("siicgg_web/javascripts.properties"));%>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxMessageBox.js"></script>
<script type="text/javascript" src="js/activarCuentaGestionEmpleo.js"></script>
<script type="text/javascript">
		function setHeightForm(){		
			try{
				parent.document.getElementById('iFrameBody').height =0;			
				parent.document.getElementById('iFrameBody').height = document["body"].offsetHeightForm+40;
			}catch(e){				
			}			
		}	
	</script>
<style type="text/css">
<!--
.Visible {
	display: block;
}

.Invisible {
	display: none;
}
-->
</style>
</head>
<body onLoad="loadModulo();">

<input type="hidden" id="txtUsuario"
	value=<% 
		try{
			out.println(request.getUserPrincipal().getName());
		}catch(Exception ex){
			out.println(false);
		}
	%> />
<div class="menu" valign="top">
<div class="tituloPrincipal" style="float: left; padding-top: 8px">Activar
cuenta para gesti&oacute;n de empleo</div>
<!--<ul >
		<li><a href="#">Inicio</a></li>
		<li><a href="#">Nosotros</a></li>
		<li><a href="#">Servicios</a></li>
		<li style="border-right:0"><a href="#">Contacto</a></li>
	</ul>--></div>
<br>
<br>
<div id="divTabInfo">Para activar su cuenta para Gesti&oacute;n de
empleo, tome en cuenta los siguiente:<br>
</div>
<br>
<br>
<table width="400" border=0 cellpadding=0 cellspacing=0 align="left">
	<tr>
		<td>No. carnet de residencia:</td>
		<td><input type="text" id="txtCarnetResidencia"></td>
		<td>
		<button id="btnActivarCuenta"><img
			src="css/icon/aceptar.png" />Enviar</button>
		</td>
	</tr>
</table>

</body>
</html>