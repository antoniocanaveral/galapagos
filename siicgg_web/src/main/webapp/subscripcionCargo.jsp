<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Subscripci&oacute;n</title>
<link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css" />
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxTable.js"></script>
<script type="text/javascript" src="js/bsxComboBox.js"></script>
<script type="text/javascript" src="js/subscripcionCargo.js"></script>
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
<div class="tituloPrincipal">Cargos de inter&eacute;s</div>
<div class="DescripcionPrincipal">Seleccione los cargos de
inter&eacute;s para usted y tendr&aacute; un listado actualizado de
noticias de ofertas de empleo publicadas.</div>

<table border=0 cellspacing=0 width="100%">
	<tr>
		<td id="combo"></td>
	</tr>
	<tr>
		<td>
		<div id="trGrdAreaCargos"></div>
		</td>
</table>
</body>
</html>