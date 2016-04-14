<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Registro Empresarial</title>
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css" />
<link rel="stylesheet" type="text/css" href="css/jsDatePick_ltr.css" />
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxComboBox.js"></script>
<script type="text/javascript" src="js/bsxMessageBox.js"></script>
<script type="text/javascript" src="js/registroDatosEmpresa.js"></script>
<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript" src="js/jsDatePick.min.1.3.js"></script>
<style type="text/css">
.Visible {
	display: block;
}

.Invisible {
	display: none;
}

.Estilo2 {
	font-size: 40%;
}

.Estilo3 {
	font-size: 30%
}
</style>
</head>
<body onLoad="loadRegistroDatosEmpresa();">
<input type="hidden" id="txtUsuario"
	value=<% try{ out.println(request.getUserPrincipal().getName()); }catch(Exception ex){ out.println(false); } %> /></input>
<div class="tituloPrincipal">Pre-registro de datos de empresa</div>
<div id="divBgModal" class="bgtransparent"
	style="width: 100%; height: 100%"></div>
<div class="descripcionPrincipal">El formulario permite el
pre-registro de una empresa para que forme parte del sistema de
gesti&oacute;n de empleo. Para registrar su empresa por favor ingrese
toda la informaci&oacute;n solicitada.</div>
<br />
<table width="432" border=0 cellpadding=0 cellspacing=0 align="center">
	<tr>
		<td width="432"><iframe id="upload_target" name="upload_target"
			src="" style="width: 0; height: 0; border: 0px solid #fff;"></iframe>
		<form method="post" enctype="multipart/form-data"
			name="FormularioRegistroEmpresarial"
			id="FormularioRegistroEmpresarial" target="upload_target"><input
			name="cgpre_cisla_codigo" id="cgpre_cisla_codigo" type="hidden"
			value="">
		<table border="0" width="100%"
			style="font-size: 12; text-align: left; background-color: #FFFFFF; border: 0 solid transparent"
			class="cssFormularioBorde">
			<tr>
				<td>
				<fieldset><legend>Datos de la empresa</legend>
				<table border="0" style="border: 0 solid transparent">
					<tr>
						<th width="120px">RUC:</th>
						<td colspan="3"><input name="cgpre_ruc" type="text"
							id="numtRdemp_RUC" size="20" maxlength="13" /></td>
					</tr>
					<tr>
						<th>Raz&oacute;n social:</th>
						<td colspan="3"><input name="cgpre_razon_social" type="text"
							id="txtRdemp_razon_social" size="50" /></td>
					</tr>
					<tr>
						<th>Isla a la que pertenece:</th>
						<td colspan="3" id="tdIsla"></td>
					</tr>
					<tr>
						<th>Fecha creaci&oacute;n</th>
						<td><input name="cgpre_fecha_creacion" type="text"
							id="numRdemp_FechaCreacion" size="12" readonly /></td>
						<th>N&uacute;mero empleados:</th>
						<td><input name="cgpre_numero_empleado" type="text"
							id="numRdemp_NumeroEmpleados" size="7" maxlength="3" /></td>
					</tr>
					<tr>
						<th width="120px">Sector:</th>
						<td width="62" id="tdSector"></td>
						<th width="64">Tipo:</th>
						<td id="tdTipo">&nbsp;</td>
					</tr>
					<tr></tr>
					<tr>
						<th>Tel&eacute;fono:</th>
						<td><input name="cgpre_telefono" type="text"
							id="numRdemp_Telefono" size="12" /></td>
						<th>Email:</th>
						<td><input name="cgpre_email" type="text" id="txtRdemp_email"
							size="25" /></td>
					</tr>
					<tr>
						<th>Actividad:</th>
						<td colspan="3"><input name="cgpre_actividad" type="text"
							id="numRdemp_Actividad" size="60" /></td>
					</tr>
					<tr>
						<th>Direcci&oacute;n:</th>
						<td colspan="3"><textarea name="cgpre_direccion" cols="30"
							rows="3" id="txtRdemp_direccion"></textarea></td>
					</tr>
				</table>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td>
				<fieldset><legend>Datos del representante legal</legend>
				<table border="0" style="border: 0 solid transparent">
					<tr>
						<th width="60px">Nombres:</th>
						<td style="font-size: 10" id="txtRdemp_Representante"></td>
					</tr>
					<tr>
						<th>&nbsp;</th>
						<td style="font-size: 10">Seleccione el archivo digitalizado
						de su nombramiento</td>
					</tr>
					<tr>
						<th>Archivo:</th>
						<td><input name="cgpre_adjunto" type="file"
							id="cgpre_adjunto"
							accept="application/PDF, image/gif, image/jpeg, image/png,image/bmp, image/png,/image/jpg"
							value="-" /></td>
					</tr>
					<tr>
						<td colspan="2" style="font-size: 10">&iquest;Es usted el
						responsable de publicar ofertas por parte de la empresa? <input
							name="chkPublicar" type="checkbox" id="chkPublicar"
							value="checkbox" checked /></td>
					</tr>
					<tr class="Invisible">
						<td colspan="2"><input name="request" type="hidden"
							id="request" value="insert" /> <input name="cgpre_codigo"
							type="hidden" id="cgpre_codigo" value="KEYGEN" /> <input
							name="cgpre_tipo_adjunto" type="hidden" id="cgpre_tipo_adjunto"
							value="" /> <input name="cgpre_nombre_adjunto" type="hidden"
							id="cgpre_nombre_adjunto" value="" /> <input
							name="cgpre_representante" type="hidden" id="cgpre_representante" />
						<input type="hidden" name="cgpre_sector" id="cgpre_sector" /> <input
							type="hidden" name="cgpre_tipo" id="cgpre_tipo" /></td>
					</tr>
				</table>
				</fieldset>
				</td>
			</tr>
			<tr>
				<td>
				<fieldset style="display: none" id="tdCedula"><legend>Empleado
				responsable del publicar ofertas</legend>
				<table border="0" style="font-size: 12; border: 0 solid transparent">
					<tr style="display: block">
						<th width="75">C&eacute;dula:</th>
						<td style="font-size: 10" valign='bottom'>Digite el
						n&uacute;mero de c&eacute;dula de un empleado de su empresa para
						que sea el responsable de publicar ofertas.<br />
						<input name="cgpre_cedula" type="text" id="numRdemp_cedula"
							size="20" maxlength="10" /> &#160;
						<button id="btnBuscarPersona" type="button"><img
							src="css/icon/buscar.png" /></button>
						</td>
					</tr>
					<tr id="trNombre" style="display: none">
						<th width="75">Nombre:</th>
						<td id="tdNombre">&nbsp;</td>
					</tr>
				</table>
				</fieldset>
				</td>
			</tr>
		</table>
		</form>
		</td>
	</tr>
	<tr>
		<td>

		<div id="divBtnControlesRegistroDatosEmpresa" class="cssTabButton">
		<button id="btnGuardarRegistroControlEmpresa"><img
			src="css/icon/add.png" />Enviar</button>
		<button id="btnLimpiarRegistroControlEmpresa" type="reset"><img
			src="css/icon/editclear.png" />Limpiar formulario</button>
		</div>

		</td>
	</tr>
</table>
</body>
</html>