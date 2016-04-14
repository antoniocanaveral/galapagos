<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Cuenta Gestión de Empleo</title>
<link rel="stylesheet" type="text/css" href="css/bsxTabla.css" />
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/bsxTabPanel.css" />
<link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css" />
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxTable.js"></script>
<script type="text/javascript" src="js/bsxComboBox.js"></script>
<script type="text/javascript" src="js/bsxTabPanel.js"></script>
<script type="text/javascript" src="js/bsxMessageBox.js"></script>
<script type="text/javascript" src="js/contactanos.js"></script>
<script type="text/javascript" src="js/prototype.js"></script>
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
<body onLoad="loadContactanos();">

<input type="hidden" id="txtUsuario"
	value=<% 
		try{
			out.println(request.getUserPrincipal().getName());
		}catch(Exception ex){
			out.println(false);
		}
	%> />
<input type="hidden" id="txtCodigoModulo"
	value=<% out.println(request.getParameter("CWMOD_CODIGO"));%> />

<div class="tituloPrincipal">Cont&aacute;ctanos</div>
<div class="descripcionPrincipal">Aqu&iacute; podr&aacute;s
encontrar la informaci&oacute;n de nuestros cont&aacute;ctos..</div>
<br>
<br>

<br>
<br>
<table width="432" border=0 cellpadding=0 cellspacing=0 align="center">
	<tr>
		<td width="432">


		<div id="divContactos"><img src="css/icon/cargando.gif" />&nbsp;Cargando,
		espere por favor...</div>

		</td>
	</tr>
</table>
</body>
</html>