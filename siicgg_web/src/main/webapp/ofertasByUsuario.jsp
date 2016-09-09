<%@ page import="com.besixplus.sii.util.Env" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Comunicado Radial</title>
<link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css" />
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/bsxTabPanel.css" />
<link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css" />
	<%out.println(Env.loadExternalScripts("siicgg_web/javascripts.properties"));%>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxTable.js"></script>
<script type="text/javascript" src="js/bsxComboBox.js"></script>
<script type="text/javascript" src="js/bsxTabPanel.js"></script>
<script type="text/javascript" src="js/bsxMessageBox.js"></script>
<script type="text/javascript" src="js/ofertasByUsuario.js"></script>
<script type="text/javascript" src="js/prototype.js"></script>
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

.Estilo1 {
	color: #FFFFFF
}
-->
</style>
</head>
<body onLoad="loadOfertasByUsuario();">

<input type="hidden" id="txtUsuario"
	value=<% 
		try{
			out.println(request.getUserPrincipal().getName());
		}catch(Exception ex){
			out.println(false);
		}
	%> />
<div class="menu" valign="top">
<div class="tituloPrincipal" style="float: left; padding-top: 8px">Mis
aplicaciones a ofertas de empleo</div>
<!--<ul >
		<li><a href="#">Inicio</a></li>
		<li><a href="#">Nosotros</a></li>
		<li><a href="#">Servicios</a></li>
		<li style="border-right:0"><a href="#">Contacto</a></li>
	</ul>--></div>

<br>
<br>
<div id="divBgModal" class="bgtransparent"
	style="width: 100%; height: 100%"></div>
<div id="divTabInfo">Muestra un listado de las aplicaciones que
usted a realizado en el sitema de gesti&oacute;n de empleo</div>

<br>
<br>
<table width="690" border=0 cellpadding=0 cellspacing=0>
	<tr>
		<td>

		<div id="divGrdOfertasByUsuario"></div>
		</td>
	</tr>
	<tr>
		<td>
		<div id="FrmOfertasDetalle" />
		</td>
	</tr>
</table>
<button id="btnReload1" style="display: none"></button>
</body>
</html>