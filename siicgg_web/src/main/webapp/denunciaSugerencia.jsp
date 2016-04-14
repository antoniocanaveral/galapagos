<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Denucias y Sugerencias</title>
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
<script type="text/javascript" src="js/denunciaSugerencia.js"></script>
<script type="text/javascript" src="js/prototype.js"></script>
</head>
<body onLoad="loadDenunciaSugerencia();">

<input type="hidden" id="txtUsuario"
	value=<% 
		try{
			out.println(request.getUserPrincipal().getName());
		}catch(Exception ex){
			out.println(false);
		}
	%> />

<div class="tituloPrincipal">Registre su denuncia y/o sugerencia</div>
<div class="descripcionPrincipal">Si tiene alguna sugerencia o
denuncia que desea reportar, estaremos gustosos en atenderla, cuanto
antes le responderemos!</div>
<div id="divBgModal" class="bgtransparent"
	style="width: 100%; height: 100%"></div>
<table width="450" border=0 cellpadding=0 cellspacing=0 align="center">
	<tr>
		<td><br>
		<div class="cssFormularioBorde">
		<form id="frmDenunciaSugerencia">
		<table width="100%" border="0"
			style="font-family: 'MS Sans Serif', Geneva, sans-serif;">
			<tr>
				<th width="130">C&eacute;dula/Pasaporte;</th>
				<td><input name="nunDsuge_cedula_pasaporte" type="text"
					id="nunDsuge_cedula_pasaporte" readonly="true"></td>
			</tr>
			<tr>
				<th>Nombres:</th>
				<td><input name="txtDsuge_denunciante" type="text"
					id="txtDsuge_denunciante" size=40 readonly="true"></td>
			</tr>
			<tr>
				<th>Apellidos:</th>
				<td><input name="txtDsuge_denunciante_apellido" type="text"
					id="txtDsuge_denunciante_apellido" size=40 readonly="true"></td>
			</tr>
			<tr>
				<th>Contacto (e-mail):</th>
				<td><input name="txtDsuge_contacto" type="text"
					id="txtDsuge_contacto" size=50 readonly="true"></td>
			</tr>
			<tr>
				<td colspan=2><textarea name="txtDsuge_descripcion"
					id="txtDsuge_descripcion" rows="5" cols=50></textarea></td>
			</tr>
			<tr>
				<th><input name="gbDsuge_tipo_denuncia" type="radio"
					id="gbDsuge_tipo_denuncia" value="true" checked /> Sugerencia</th>
				<th><input type="radio" id="gbDsuge_tipo_denuncia"
					name="gbDsuge_tipo_denuncia" value="false" />Denuncia</th>
			</tr>
		</table>
		</form>
		<div id="divBtnControlesDenunciaSugerencia" class="cssTabButton">
		<button id="btnGuardarDenunciaSugerencia"><img
			src="css/icon/aceptar.png" />Enviar</button>
		<button id="btnLimpiarDenunciaSugerencia"><img
			src="css/icon/editclear.png" />Limpiar formulario</button>
		</div>
		</div>
		</td>
	</tr>
	<tr>
		<td><br>
		<div class="cssFormularioBorde"
			style="width: 450; color: #525252; font-family: 'MS Sans Serif', Geneva, sans-serif; font-size: 11px;">
		<div>Todas las denuncias y sugerencias seran atendidas y se
		guardar&aacute; absoluta reserva de la informaci&oacute;n enviada</div>
		</div>
		</td>
	</tr>
</table>
</body>
</html>