<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
	<link rel="stylesheet" type="text/css" href="css/modulo.css" />
	<link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css" />
	<link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css" />
	<link rel="stylesheet" type="text/css" href="css/jsDatePick_ltr.css" />
	<link rel="stylesheet" type="text/css" href="css/dialog.2.1.css" />
	<link rel="stylesheet" type="text/css" href="css/jquery/jquery-ui.css"/>
	<link rel="stylesheet" type="text/css" href="css/jquery/ui.all.css"/>


	<script type="text/javascript" src="js/config.js"></script>
	<script type="text/javascript" src="js/Reporte.js"></script>
	<script type="text/javascript" src="js/bsxMessageBox.js"></script>
	<script type="text/javascript" src="lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="lib/jquery.raty.js"></script>
	<script type="text/javascript" src="lib/jquery/ui.core.min.js"></script>
	<script type="text/javascript" src="lib/jquery/ui.dialog.js"></script>
	<script type="text/javascript" src="lib/jquery/ui.datepicker.js"></script>
	<script type="text/javascript" src="lib/jquery/ui.resizable.js"></script>
	<script type="text/javascript" src="lib/jquery/ui.draggable.js"></script>
	<script type="text/javascript" src="lib/jquery/jquery.tmpl.min.js"></script>
	<script type="text/javascript" src="lib/jquery/ui.tabs.min.js"></script>
	<script type="text/javascript" src="lib/jquery/jquery.jstree.js"></script>
	<script type="text/javascript" src="lib/validador.js"></script>
	<script type="text/javascript" src="js/SoapClient.js"></script>
	<script type="text/javascript" src="js/bsxTable.js"></script>
	<script type="text/javascript" src="js/bsxComboBox.js"></script>
	<script type="text/javascript" src="lib/jquery/jquery.jstree.js"></script>
	<script type="text/javascript" src="js/ingresoTCT.js"></script>
	<script type="text/javascript" src="js/prototype.js"></script>
	<script type="text/javascript" src="js/modernizr-1.6.js"></script>
	<script type="text/javascript" src="js/jsDatePick.min.1.3.js"></script>
	<script type="text/javascript" src="js/dialog.2.1.js"></script>
	<script type="text/javascript" src="js/date.js"></script>
	<!--script type="text/javascript" src="js/date/core.js"></script>
	<script type="text/javascript" src="js/date/parser.js"></script>
	<script type="text/javascript" src="js/date/sugarpak.js"></script>
	<script type="text/javascript" src="js/date/globalization/es-EC.js"></script-->
	<style type="text/css">

	input[type="radio"] {
	  display: none;
	}

	label {
	  color: grey;
	  font-size: 25px;
	}
	.Invisible {
		display: none;
	}

	.clasificacion {
	  direction: rtl;
	  unicode-bidi: bidi-override;
	  text-align: left;
	}
	.clasificacion label {
		font-size: 1.5em;
	}

	label:hover,
	label:hover ~ label {
	  color: orange;
	}

	input[type="radio"]:checked ~ label {
	  color: orange;
	}

	input[type="radio"] ~ label {
	  color: grey;
	}

	.form-line-error {
		border: 1px solid #dd8888;
		background: #FFCCCC;
		/*border:1px solid #FFAAAA;*/
		color: #333;
	}

	.form-text-error {
		color: #333;
	}

	.txtMensaje{
		color: #7f969f;
		font-size: 12px !important;
		font-weight: 500;
		padding: 10px;
	}

	#tblHospedaje.tabla {
		border: 1px solid #e0e0e0 !important;
	}
	#tblHospedaje.tabla thead {
		border-bottom: 1px solid #e0e0e0;
	}
	#tblHospedaje th {
		color: #7f969f;
		font-size: 0.95em;
		font-weight: 500;
		text-transform: uppercase;
	}
	#tblHospedaje.tabla tbody {
		display: table-row-group !important;
		height: auto !important;
		vertical-align: top !important;
	}
	#tblHospedaje.tabla tbody td {
		cursor: pointer;
		height: 30px;
	}
	.labelDate{
		padding-left: 20px;
		padding-right: 10px;
	}

	/*ENCUESTA*/

	.itemContainer {
	  margin: auto;
	  padding: 0 95px;
		padding-bottom: 10px;
	  text-align: center;
	}

	.itemTitle{
		color: #888888;
		font-size: 12px !important;
		line-height: 2;
	}

	.itemRateYo{
		text-align: center;
	}

	.selectEncuesta {
		margin-left: 15.35%;
		padding-left: 10px;
		width: 27.7%;
	}
	.inputEncuesta {
		margin-left: 15.35%;
		padding-left: 10px;
		width: 27.7%;
	}

	.checkContainer {
		display: inline-block;
		margin: auto;
		padding-left: 35%;
	}

	.checkItem {
		display: inline-block;
		float: left;
		width: 50px !important;
	}
	.checkTitle {
		color: #888888;
		display: inline-block;
		font-size: 12px !important;
		line-height: 2;
	}
	#tblEncuesta.tabla {
		/*border: 1px solid #e0e0e0 !important;*/
		/*margin-left: -10px;*/
	}

	td[id*="ENCPR"] {
		padding: 15px;
		color: #287697;
		font-size: 12px;
	}
</style>

</head>
<body onLoad="loadIngresoTCT();">
<br />
<br />
	
<div class="tituloPrincipal">Formulario de Registro Previo para la
TCT</div>
<div class="descripcionPrincipal">Ingrese su informaci&oacute;n
para pre-registrar sus datos antes del ingreso a la ciudad de
Gal&aacute;pagos</div>
<br />
<br />

<div id="divBgModal" class="bgtransparent"
	style="width: 100%; height: 100%"></div>
<table style="width: 100%;" align="center">
	<tbody>

		<tr>

			<td width="40%" valign="top">

			<fieldset style="font-size: 11px">

				<legend><b>Tipo de Registro</b></legend>
				<table width="100%" style="font-size: 11px">
					<tbody>
					<tr>
						<td width="15%">* Categoria:</td>
						<td width="35%" id="tdCategoria"></td>
					
						<td width="15%">* Tipo de registro:</td>
						<td width="35%" id="tdTipoRegistro"></td>
					</tr>
					</tbody>
			</table>
			</fieldset>

			</td>

		</tr>


		<tr>
			<td width="100%" valign="top">

			<fieldset style="font-size: 11px"><legend><b>Transporte a Gal&aacute;pagos</b> </legend>
			<table width="100%" style="font-size: 11px">
				<tbody>
					<tr>
						<td width="15%">* Medio de Transporte:</td>
						<td width="35%" id="tdMedioTransporte">
							<select id="cbmMedioTransporte" style="width: 80%;" name="cbmMedioTransporte">
								<option value="AVION">A&eacute;reo</option>
								<option value="BARCO">Mar&iacute;timo</option>
							</select>
						</td>
						<td width="15%"></td><!--Celda en Blanco-->
						<td width="35%"></td><!--Celda en Blanco-->
					</tr>
					<tr>
						<td width="15%">* Origen:</td>
						<td width="35%" id="tdOrigen"></td>

						<td width="15%">* Aerolinea/Nav&iacute;o:</td>
						<td width="35%" id="tdAereolinea"></td>

					</tr>
					<tr id="vueloDetail" style="display: none;">

						<td width="15%">* Nro. de vuelo/nav&iacute;o:</td>
						<td width="35%">
							<input name="txtNroVuelo" type="text" id="txtNroVuelo" style="width: 80%; display: block;" maxlength="20"/>
							<select name="cmbNroVuelo" type="text" id="cmbNroVuelo" style="width: 80%; display: none;"/>
						</td>
				
						<td width="15%">* Destino:</td>
						<td width="35%" id="tdDestino"></td>
					</tr>
				</tbody>
			</table>
			</fieldset>
			</td>
		</tr>

		<tr>
			<td colspan="3">
				<fieldset style="font-size: 11px"><legend><b>Hospedaje/s</b></legend>
					<table width="100%" style="font-size: 11px">
						<tbody>
						<tr>
							<td colspan="4">
								<p class="txtMensaje">Por favor Ingrese cada uno de los alojamientos donde se hospedar&aacute; durante todo su viaje en Gal&aacute;pagos
									y el tiempo que permanecer&aacute; en cada uno de ellos. <br/>Si se hospeda en varios lugares, por favor agregue todos los necesarios.
								</p>
							</td>
						</tr>
						<tr>
							<td colspan="4">
								<table style="width: 100%;" border="0" align="center" cellspacing="0" cellpadding="0">
									<tbody>
										<tr>
											<td>
												<table style="font-size: 11px; border: 1px solid transparent"
													   border="0" cellspacing="0">
													<tbody>
													<tr>
														<td>
															<button id="btnAgregarHospedaje" type="button"><img
																	src="css/icon/add.png" alt="add" />Agregar Hospedaje</button>
														</td>
														<td>
															<button id="btnEliminarHospedaje" type="button"><img
																	src="css/icon/remove.png" alt="remove" />Eliminar Hospedaje</button>
														</td>
													</tr>
													</tbody>
												</table>
											</td>
										</tr>
										<tr>
											<td colspan="2">
												<form action="" id="frmHospedajes" method="get">
													<table class="tabla" cellspacing="0" width="100%" border="0"
														   id='tblHospedaje'
														   style="font-size: 11px; border: 1px solid #CCCCCC">
														<thead style="border-bottom: 1px solid #CCCCCC; width: 100%">
														<tr height="30px">
															<th width="16%">
																<div align="left">Tipo de Hospedaje</div>
															</th>
															<th width="16%">
																<div align="left">Isla</div>
															</th>
															<th width="20%">
																<div align="left">Lugar de Hospedaje</div>
															</th>
															<th width="16%">
																<div align="left">Fecha de Ingreso</div>
															</th>
															<th width="16%">
																<div align="left">Fecha de Salida</div>
															</th>
															<th width="16%">
																<div align="left">N&uacute;mero de D&iacute;as</div>
															</th>
														</tr>
														</thead>
														<tbody
																style="width: 100%; overflow: auto; display: block"></tbody>
													</table>
												</form>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr id="rangoViajeDetail">
							<td width="65%" colspan="3">
								<spam class="labelDate" >* Ingreso a Gal&aacute;pagos:</spam>
								<input name="dtFechaIngreso" type="text" id="dtFechaIngreso" readonly="true" disabled/>
								<spam class="labelDate" >* Salida de Gal&aacute;pagos:</spam>
								<input name="dtFechaSalida" type="text" id="dtFechaSalida" readonly="true" disabled/>
							</td>
							<td width="35%">
								<div style="float: right;">
									<spam class="labelDate" style="float: left;">Total D&iacute;as:</spam>
									<input name="txtTotalDias" style="float: left;margin-right: 30px; width: 100px;" type="text" id="txtTotalDias" value="0" readonly="true" disabled/>
								</div>
							</td>
						</tr>
						</tbody>
					</table>
				</fieldset>
			</td>
		</tr>


		<tr>
			<td colspan="3">
			<fieldset style="font-size: 11px"><legend><b>* Listado de personas</b></legend>
			<table style="width: 100%;" border="0" align="center" cellspacing="0" cellpadding="0">
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
									<th width="100">
										<div align="left">Correo Electr&oacute;nico</div>
									</th>
									<th width="50">
										<div align="left">C&oacute;digo Postal</div>
									</th>
								</tr>
							</thead>
							<tbody
								style="width: 100%; overflow: auto; display: block"></tbody>
						</table>
						</form>
						</td>
					</tr>

				</tbody>
			</table>
			</fieldset>
			</td>
		</tr>


		<tr>
			<td colspan="3">
				<fieldset style="font-size: 11px"><legend><b>Informaci&oacute;n  del viaje</b></legend>
					<table width="100%" style="font-size: 11px">
						<tbody>
							<tr>
								<td width="15%">* &iquest;Usted est&aacute; viajando?</td>
								<td width="35%" id="tdInformacionViaje1"></td>
								<td width="15%">* N&uacute;mero de miembros</td>
								<td width="35%"><input name="textNumeroMiembros" type="text" id="txtNumeroMiembros" onkeypress="return aceptarNumeros(event, this);" maxlength="10"/></td>
							</tr>
						</tbody>
					</table>
				</fieldset>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<fieldset style="font-size: 11px"><legend><b>Encuesta</b></legend>
					<table id="tblEncuesta" class="tabla" width="100%" style="font-size: 11px">
						<tbody></tbody>
					</table>
				</fieldset>
			</td>
		</tr>
		<tr>
			<td>
				<table style="font-size: 11px; border: 1px solid transparent"
					   border="0" cellspacing="0">
					<tbody>
					<tr>
						<button type='button' id="btnGuardarTTC"><img src="css/icon/save.png" alt="save" />Guardar</button>
					</tr>
					</tbody>
				</table>
			</td>
		</tr>

	</tbody>
</table>
<!--class="componetHide"-->
<div id="FrmIngresoHospedaje" class="componetHide" style="position: fixed; left: 180px; top: 200px; background-color: #fff;">
	<div class="cssFormularioBorde">
		<span class="cssFormularioTitulo"><b>Datos de Hospedaje</b></span>
		<form action="" id="frmHospedaje" method="get">
			<table width="815px" border="0" class="cssForularioInterno">
				<tr>
					<td width="25%">* Tipo de hospedaje:</td>
					<td width="25%" id="divTipoHospedaje"></td>

					<td width="25%">* Isla de hospedaje:</td>
					<td width="25%" id="divIslaHospedaje"></td>
				</tr>
				<tr>
					<td width="25%"><div id="labelHospedaje"></div></td>
					<td width="25%">
						<div id="divNombreHospedaje"></div>
						<div id="divNombreHospedajeIsla"></div>
						<input name="divLugarHospedaje" type="text" id="divLugarHospedaje" maxlength="200"/>
					</td>
					<td width="25%"></td><!--Celda en Blanco-->
					<td width="25%"></td><!--Celda en Blanco-->
				</tr>
				<tr>
					<td width="25%">* Fecha de Ingreso:</td>
					<td width="25%"><input name="dtFechaIngresoHospedaje" type="text" id="dtFechaIngresoHospedaje"
										   style="width: 80%;" /></td>

					<td width="25%">* Fecha de Salida:</td>
					<td width="25%"><input name="dtFechaSalidaHospedaje" type="text" id="dtFechaSalidaHospedaje"
										   style="width: 80%;" /></td>
				</tr>
			</table>
		</form>
		<div id="divBtnControlesIngresoHospedaje" class="cssTabButton">
			<button id="btnAceptarHospedaje" ><img
					src="css/icon/apply.png" />Aceptar</button>
			<button id="btnSalirHospedaje" type="reset"><img
					src="css/icon/salir.png" />Salir</button>
		</div>
	</div>
</div>

<div id="FrmIngresoPersona" class="componetHide"
	style="position: fixed; left: 130px; top: 50px; background-color: #fff;">
<div class="cssFormularioBorde"><span class="cssFormularioTitulo"><b>Datos
de la persona</b></span>
<form action="" id="frmPersona" method="get">
<table width="600px" height="400px" border="0" class="cssForularioInterno">
	<tr>
		<th colspan=2 style="color: #039BD7">Usted se esta
		pre-registrando como <b>TURISTA</b> <input name="txtTipo"
			type="hidden" id="txtTipo" width="80%" /></th>
	</tr>
	<tr>
		<th width="30%">* Tipo de documento:</th>
		<td width="70%" id="tdTipoDocumento"></td>
	</tr>
	<tr>
		<th width="30%">* N&uacute;mero de documento:</th>
		<td width="70%"><input name="txtNumeroDocumento" type="text"
			id="txtNumeroDocumento" style="width: 55%" />&nbsp;
			<button type='button' id="btnVerificar"><img
				src="css/icon/buscar.png" title="verificar" /> Verificar</button>
			<br>
			<div id="divInfoValidacion" style="display: none; color: orange"><img
				src='css/icon/cargando.gif' /> Verificando, espere por favor.</div>
		</td>
	</tr>
	<tr>
		<th width="30%">* Nombres completos:</th>
		<td width="70%"><input name="txtNombrePersona" type="text"
			id="txtNombrePersona" style="width: 80%;" readonly="true" /></td>
	</tr>
	<tr>
		<th>* Apellidos completos:</th>
		<td><input name="txtApellidoPersona" type="text"
			id="txtApellidoPersona" style="width: 80%;" readonly="true" /></td>
	</tr>
	<tr>
		<th>* Fecha de nacimiento:</th>
		<td><input name="txtFechaNacimiento" type="text"
			id="txtFechaNacimiento" style="width: 50%;" disabled="disabled" /> ejemplo:
		23/01/1989</td>
	</tr>
	<tr>
		<th>* Estado Civil:</th>
		<td id="tdEstadoCivil"></td>
	</tr>
	<tr>
		<th>* G&eacute;nero:</th>
		<td><select id="cbmGenero" style="width: 80%;" name="cbmGenero" disabled="disabled">
			<option value="0">Masculino</option>
			<option value="1">Femenino</option>
		</select></td>
	</tr>
	<tr>
		<th>* Pa&iacute;s de residencia:</th>
		<td id="tdPaisResidencia"></td>
	</tr>
	<tr>
		<th>C&oacute;digo Postal:</th>
		<td><input name="txtCodigoPostal" type="text" id="txtCodigoPostal" style="width: 80%;" /></td>
	</tr>
	<tr>
		<th>* Nacionalidad:</th>
		<td id="tdNacionalidad"></td>
	</tr>

	<tr>
		<th>Estudios:</th>
		<td><select id="cbmEstudios" name="cbmEstudios">
			<option value="0">Primaria</option>
			<option value="1">Secuandaria</option>
			<option value="2">Superior</option>
			<option value="3">Otros</option>
		</select></td>
	</tr>

	<tr>
		<th>* Correo Electr&oacute;nico:</th>
		<td><input name="txtCorreoElectronico" type="text" id="txtCorreoElectronico" style="width: 80%;" /></td>
	</tr>

	<tr>
		<th>* Confirmaci&oacute;n Correo Electr&oacute;nico:</th>
		<td><input name="txtConfirCorreoElectronico" type="text" id="txtConfirCorreoElectronico" style="width: 80%;" /></td>
	</tr>

	<tr class="Invisible">
		<th>Tipo de especie:</th>
		<td id="tdEspecies"><input name="txtTipoEspecie" type="text"
			id="txtTipoEspecie" value="VALORADA" readonly="true" style="width: 80%;" /></td>
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
</BODY>
</html>