<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Empresas</title>
<link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css" />
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxTable.js"></script>
<script type="text/javascript" src="js/listadoEmpresas.js"></script>
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
<body onLoad="loadListadoEmpresas();">

<input type="hidden" id="txtUsuario"
	value=<% 
		try{
			out.println(request.getUserPrincipal().getName());
		}catch(Exception ex){
			out.println(false);
		}
	%> />

<div class="tituloPrincipal">Listado de empresas afiliadas</div>
<div class="descripcionPrincipal">Listado de empresas registradas
en el sistema de Gesti&oacute;n de empleo en las que el personal puede
laborar</div>
<div id="divBgModal" class="bgtransparent"
	style="width: 100%; height: 100%"></div>

<br>
<br>
<table width="432" border=0 cellpadding=0 cellspacing=0 align="center">
	<tr>
		<td>
		<div id="FrmListadoEmpresas">


		<div id="divGrdListadoEmpresas"></div>

		</div>
		</td>
	</tr>
</table>
</body>
</html>