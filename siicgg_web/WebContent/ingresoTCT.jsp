<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Pre-registro TCT</title>
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css" />
<link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css" />
<link rel="stylesheet" type="text/css" href="css/jsDatePick_ltr.css" />
<link rel="stylesheet" type="text/css" href="css/dialog.2.1.css" />

<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxComboBox.js"></script>
<script type="text/javascript" src="js/bsxMessageBox.js"></script>
<script type="text/javascript" src="js/ingresoTCT.js"></script>
<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript" src="js/modernizr-1.6.js"></script>
<script type="text/javascript" src="js/jsDatePick.min.1.3.js"></script>
<script type="text/javascript" src="js/dialog.2.1.js"></script>
<script type="text/javascript" src="js/date.js"></script>
<script type="text/javascript" src="lib/validador.js"></script>
<style type="text/css">
.Visible {
	display: block;
}

.Invisible {
	display: none;
}
</style>
</head>
<body onLoad="loadIngresoTCT();">
<input type="hidden" id="txtUsuario"
	value=<% try{ out.println(request.getUserPrincipal().getName()); }catch(Exception ex){ out.println(false); } %>></input>
<div class="tituloPrincipal">Formulario de Registro Previo para la
TCT</div>
<div class="descripcionPrincipal">Ingrese su informaci&oacute;n
para pre-registrar sus datos antes del ingreso a la ciudad de
Gal&aacute;pagos</div>
<br />
<br />
<div id="divBgModal" class="bgtransparent"
	style="width: 100%; height: 100%"></div>
<table style="width: 700;" align="center">
	<tbody>
		<tr>
			<td width="34%" valign="top">
			<fieldset style="font-size: 11px"><legend><b>Datos
			de entrada </b> </legend>
			<table width="100%" height="170" style="font-size: 11px">
				<tbody>
					<tr>
						<td width="50">Aerolinea:</td>
						<td id="tdAereolinea"></td>
					</tr>
					<tr>
						<td>Origen:</td>
						<td id="tdOrigen"></td>
					</tr>
					<tr>
						<td>Destino:</td>
						<td id="tdDestino"></td>
					</tr>
					<tr>
						<td>Ingreso:</td>
						<td><input name="text" type="text" id="dtFechaIngreso"
							size="12" readonly="true" /></td>
					</tr>
					<tr>
						<td>Salida:</td>
						<td><input name="text" type="text" id="dtFechaSalida"
							size="12" readonly="true" /></td>
					</tr>
				</tbody>
			</table>
			</fieldset>
			</td>
			<td width="33%" valign="top">
			<fieldset style="font-size: 11px"><legend><b>Actividad
			</b> </legend>
			<table height="170" style="font-size: 11px" width="100%" border="0"
				cellspacing="0" id='tblActividad'>
				<tbody
					style="width: 100%; overflow: scroll; height: 170px; display: block;"></tbody>
			</table>
			</fieldset>
			</td>
			<td width="33%" valign="top">
			<fieldset style="font-size: 11px"><legend><b>Hospedaje</b></legend>
			<table height="170" style="font-size: 11px" width="100%" border="0"
				align="center" cellspacing="0" id='tblHospedaje'>
				<tbody
					style="width: 100%; height: 170px; overflow: scroll; display: block;"></tbody>
			</table>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td colspan="3">
			<fieldset style="font-size: 11px"><legend><b>Listado
			de personas</b></legend>
			<table style="width: 100%;" border="0" align="center" cellspacing="0"
				cellpadding="0">
				<tbody>
					<tr>
						<td>
						<table style="font-size: 11px; border: 1px solid transparent"
							border="0" cellspacing="0">
							<tbody>
								<tr>
									<td>
									<button id="btnAgregar" type="button"><img
										src="css/icon/add.png" alt="add" />A&ntilde;adir</button>
									</td>
									<td>
									<button id="btnEliminar" type="button"><img
										src="css/icon/remove.png" alt="remove" />Borrar</button>
									</td>
									<td>
									<button id="btnEditar" type="button"><img
										src="css/icon/edit.png" alt="edit" />Editar</button>
									</td>
								</tr>
							</tbody>
						</table>
						</td>
					</tr>
					<tr>
						<td colspan="2">
						<form action="" id="frmPersonaRegistro" method="get">
						<table class="tabla" cellspacing="0" width="100%" border="0"
							id='tblPersona'
							style="font-size: 11px; border: 1px solid #CCCCCC">
							<thead style="border-bottom: 1px solid #CCCCCC; width: 100%">
								<tr height="30px">
									<th width="80">
									<div align="left">Documento</div>
									</th>
									<th width="80">
									<div align="left">N&uacute;mero D.</div>
									</th>
									<th width="110">
									<div align="left">Nombres</div>
									</th>
									<th width="110">
									<div align="left">Apellidos</div>
									</th>
									<th width="50">
									<div align="left">G&eacute;nero</div>
									</th>
									<th width="80">
									<div align="left">Nacionalidad</div>
									</th>
									<th width="100">
									<div align="left">F. nacimiento</div>
									</th>
									<th class="Invisible">
									<div align="left">Tipo especie</div>
									</th>
									<th width="80" class="Invisible">
									<div align="left">Estado</div>
									</th>
									<th class="Invisible">
									<div align="left">Tipo</div>
									</th>
									<th class="Invisible">
									<div align="left">No. aut.</div>
									</th>
									<th class="Invisible">
									<div align="left">Pais</div>
									</th>
									<th class="Invisible">
									<div align="left">Codigo Tramite</div>
									</th>
								</tr>
							</thead>
							<tbody
								style="width: 100%; height: 120; overflow: auto; display: block"></tbody>
						</table>
						</form>
						</td>
					</tr>
					<tr>
						<td>
						<table style="font-size: 11px; border: 1px solid transparent"
							border="0" cellspacing="0">
							<tbody>
								<tr>
									<button type='button' id="btnGuardarTTC"><img
										src="css/icon/save.png" alt="save" />Guardar</button>
								</tr>
							</tbody>
						</table>
						</td>
					</tr>
				</tbody>
			</table>
			</fieldset>
			</td>
		</tr>
	</tbody>
</table>
<!--class="componetHide"-->
<div id="FrmIngresoPersona" class="componetHide"
	style="position: fixed; left: 150; top: 45; background-color: #fff;">
<div class="cssFormularioBorde"><span class="cssFormularioTitulo"><b>Datos
de la persona</b></span>
<form action="" id="frmPersona" method="get">
<table width="400" height="349" border="0" class="cssForularioInterno">
	<tr>
		<th colspan=2 style="color: #039BD7">Usted se esta
		pre-registrando como <b>TURISTA</b> <input name="txtTipo"
			type="hidden" id="txtTipo" width="150" /></th>
	</tr>
	<tr>
		<th width="120">Tipo de documento:</th>
		<td id="tdTipoDocumento"></td>
	</tr>
	<tr>
		<th>N&uacute;mero de documento:</th>
		<td><input name="txtNumeroDocumento" type="text"
			id="txtNumeroDocumento" width="150" />&nbsp;
		<button type='button' id="btnVerificar"><img
			src="css/icon/buscar.png" title="verificar" /> Verificar</button>
		<br>
		<div id="divInfoValidacion" style="display: none; color: orange"><img
			src='css/icon/cargando.gif' /> Verificando, espere por favor.</div>
		</td>
	</tr>
	<tr>
		<th>Nombres completos:</th>
		<td><input name="txtNombrePersona" type="text"
			id="txtNombrePersona" width="150" readonly="true" /></td>
	</tr>
	<tr>
		<th>Apellidos completos:</th>
		<td><input name="txtApellidoPersona" type="text"
			id="txtApellidoPersona" width="150" readonly="true" /></td>
	</tr>
	<tr>
		<th>Fecha de nacimiento:</th>
		<td><input name="txtFechaNacimiento" type="text"
			id="txtFechaNacimiento" width="150" disabled="disabled" /> ejemplo:
		23/01/1989</td>
	</tr>
	<tr>
		<th>G&eacute;nero:</th>
		<td><select id="cbmGenero" name="cbmGenero" disabled="disabled">
			<option value="0">Masculino</option>
			<option value="1">Femenino</option>
		</select></td>
	</tr>
	<tr>
		<th>Pa&iacute;s de residencia:</th>
		<td id="tdPaisResidencia"></td>
	</tr>
	<tr>
		<th>Nacionalidad:</th>
		<td id="tdNacionalidad"></td>
	</tr>
	<tr class="Invisible">
		<th>Tipo de especie:</th>
		<td id="tdEspecies"><input name="txtTipoEspecie" type="text"
			id="txtTipoEspecie" value="VALORADA" readonly="true" width="150" /></td>
	</tr>
	<tr class="Invisible">
		<th height="29">No. aut.</th>
		<td><input name="txtNumeroAut" type="text" id="txtNumeroAut"
			width="150" /></td>
	</tr>
	<tr class="Invisible">
		<th height="29">&nbsp;</th>
		<td id="tdConfiguracion">&nbsp;</td>
	</tr>
	<input id="txtCodigoPersona" name="txtCodigoPersona" type="hidden"
		value="" />
	<input id="txtCodigoTramite" name="txtCodigoTramite" type="hidden"
		value="" />
	<input id="txtCodigoEspecie" name="txtCodigoEspecie" type="hidden"
		value="" />
</table>
</form>
<div id="divBtnControlesIngresoPersona" class="cssTabButton">
<button id="btnAceptarIngreso" disabled="disabled"><img
	src="css/icon/apply.png" />Aceptar</button>
<button id="btnSalirIngreso" type="reset"><img
	src="css/icon/salir.png" />Salir</button>
</div>
</div>
</div>
</body>
</html>