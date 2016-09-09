<%@ page import="com.besixplus.sii.util.Env" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Pre-registro a cursos de capacitaci&oacute;n /
formaci&oacute;n</title>
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css" />
<link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css" />
	<%out.println(Env.loadExternalScripts("siicgg_web/javascripts.properties"));%>
<script type="text/javascript" src="js/bsxComboBox.js"></script>
<script type="text/javascript" src="js/bsxTable.js"></script>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxMessageBox.js"></script>
<script type="text/javascript" src="js/preRegistroCurso.js"></script>
<script type="text/javascript" src="js/prototype.js"></script>
</head>
<body onLoad="loadModulo();">
<input type="hidden" id="txtUsuario"
	value=<% try{ out.println(request.getUserPrincipal().getName()); }catch(Exception ex){ out.println(false); } %> /></input>
<input type="hidden" id="txtCodigoCurso"
	value=<% try{ out.println(request.getParameter("codigoCurso")); }catch(Exception ex){ out.println(false); } %> /></input>
<input type="hidden" id="txtTipoResidente"
	value=<% try{ out.println(request.getParameter("tipoResidente")); }catch(Exception ex){ out.println(false); } %> /></input>
<div class="tituloPrincipal">Pre-registro a cusrsos de
capacitaci&oacute;n / formaci&oacute;n</div>
<div class="descripcionPrincipal">Ingrese la informaci&oacute;n
solicitada para que pueda pre-registrarse a los cursos de
capacitaci&oacute;n / formaci&oacute;n abiertos.</div>
<br />
<br />
<fieldset style="width: 500;"><legend><b>DATOS
DEL RESIDENTE</b></legend>

<table class="infoTabla" width="100%" border="0" cellspacing="0"
	cellpadding="3"
	summary="Pre-registro de cursos de capacitaci&oacute;n/formaci&oacute;n">
	<tr>
		<th width="46%">Nombre:</th>
		<td width="54%" id="tdNombrePersona"></td>
	</tr>
	<tr>
		<th>N. Documento de identificaci&oacute;n</th>
		<td id="tdCedulaIdentidad"></td>
	</tr>
</table>
<form id="frmPreRegistroCurso" enctype="multipart/form-data"
	method="post" action="">
<table class="infoTabla" width="100%" cellspacing="0" cellpadding="3">
	<tr>
		<th width="150">Sector productivo:</th>
		<td width="350" id="tdSectorProductivo"></td>
	</tr>
	<tr>
		<th valign="top">Actividad que realiza:</th>
		<td><textarea cols="45" id="txtActividad" rows="3"></textarea></td>
	</tr>
	<div id="divBgModal" class="bgtransparent"
		style="width: 100%; height: 100%"></div>
</table>
<div>
<button id="btnGuardar" type="reset">Guardar</button>
</div>
</form>
</fieldset>

</body>
</html>