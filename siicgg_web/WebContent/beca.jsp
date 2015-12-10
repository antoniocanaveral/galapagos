<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Informaci&oacute;n de Becas</title>
<link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css" />
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css" />
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/bsxTable.js"></script>
<script type="text/javascript" src="js/bsxMessageBox.js"></script>
<script type="text/javascript" src="js/beca.js"></script>
</head>
<body onLoad="loadBeca();">
<input type="hidden" id="txtCodigoModulo"
	value=<% out.println(request.getParameter("CWMOD_CODIGO"));%> />
<input type="hidden" id="txtUsuario"
	value=<% try{ out.println(request.getUserPrincipal().getName()); }catch(Exception ex){ out.println(false); } %> /></input>

<div class="tituloPrincipal">Informaci&oacute;n de Becas</div>
<div class="tituloSecundario"></div>
<div id="divBgModal" class="bgtransparent"
	style="width: 100%; height: 100%"></div>

<br />
<table width="690" border=0 cellpadding=0 cellspacing=0
	style="font-size: 11px">
	<tr>
		<td>
		<div id="FrmListadoPreguntas">
		<table width="689" border="0" style="font-size: 11px">
			<tr>
				<td colspan="2">
				<div id="divBecaBeneficiario"></div>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
		</div>
		</td>
	</tr>
</table>
</body>
</html>