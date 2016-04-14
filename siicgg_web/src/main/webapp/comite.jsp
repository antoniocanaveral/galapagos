<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Informaci&oacute;n del comite</title>
<link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css" />
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css" />
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/bsxTable.js"></script>
<script type="text/javascript" src="js/bsxMessageBox.js"></script>
<script type="text/javascript" src="js/comite.js"></script>
</head>
<body onLoad="loadComite();">
<input type="hidden" id="txtCodigoModulo"
	value=<% out.println(request.getParameter("CWMOD_CODIGO"));%> />
<input type="hidden" id="txtUsuario"
	value=<% try{ out.println(request.getUserPrincipal().getName()); }catch(Exception ex){ out.println(false); } %> /></input>

<div class="tituloPrincipal">Informaci&oacute;n de Comite</div>
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
				<td width="103">Comite:</td>
				<td width="576">
				<div id="divComite"></div>
				</td>
			</tr>
			<tr>
				<td colspan="2"><B>INTEGRANTES:</B>
				<div id="divMiembrosComite" style='padding-left: 20px;'></div>
				<b>*suplentes</b></td>
			</tr>
			<tr>
				<td colspan="2">
				<div id="divResolucionesComite"></div>
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