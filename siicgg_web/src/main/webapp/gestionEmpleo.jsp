<%@ page import="com.besixplus.sii.util.Env" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Gesti&oacute;n de empleo</title>
<link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css" />
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
	<%out.println(Env.loadExternalScripts("siicgg_web/javascripts.properties"));%>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxTable.js"></script>
<script type="text/javascript" src="js/gestionEmpleo.js"></script>
</head>
<body onload="loadModulo()">
<input type="hidden" id="txtUsuario"
	value=<% 
		try{
			out.println(request.getUserPrincipal().getName());
		}catch(Exception ex){
			out.println(false);
		}
	%> />
<div class="tituloPrincipal">Gesti&oacute;n de empleo</div>
<div class="descripcionPrincipal">Bienvenido! si desea encontrar
empleo, ingresa al sistema y encontraras oportunidades de trabajo de
forma f&aacute;cil y sencilla.</div>
<br>
<br>
<div>
<table border=0 cellspacing=0 width=700>
	<tr id="trTabBusqueda0">
	</tr>
	<tr id="trTabBusqueda1">
	</tr>
</table>
<div style="border: 1px solid #E2BD7E; width: 698px">
<table id="tblFiltro" border=0 cellspacing=0 cellpadding=0
	style="width: 100%">
	<tr>
		<td valign="top">
		<table border=0 cellpadding=0 cellspacing=0 height="100%"
			id="tblFilto" class="tblFiltro">
			<thead>
				<tr>
					<td id="tblFiltroTitulo" class="tblFiltroTitulo" valign="top">
					</td>
				</tr>
			</thead>
			<tbody id="tblFiltroBody"
				style="overflow-y: auto; display: block; height: 500px; width: 120px;">
				<tr>
					<td></td>
				</tr>
			</tbody>
		</table>
		</td>
		<td valign="top">
		<div id="divTabla1"></div>
		</td>
	</tr>
</table>
</div>
</div>
</body>
</html>