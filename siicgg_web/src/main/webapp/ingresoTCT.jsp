<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css" />
<link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css" />
<link rel="stylesheet" type="text/css" href="css/jsDatePick_ltr.css" />
<link rel="stylesheet" type="text/css" href="css/dialog.2.1.css" />


<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/Reporte.js"></script>
<script type="text/javascript" src="js/bsxMessageBox.js"></script>
<script type="text/javascript" src="lib/jquery/jquery.js"></script>
<script type="text/javascript" src="lib/jquery/ui.core.min.js"></script>
<script type="text/javascript" src="lib/jquery/ui.dialog.js"></script>
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
<style type="text/css">

input[type="radio"] {
  display: none;
}

label {
  color: grey;
  font-size: 25px;
}

.clasificacion {
  direction: rtl;
  unicode-bidi: bidi-override;
  text-align: left;
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
<table style="width: 700;" align="center">
	<tbody>

		<tr>

			<td width="40%" valign="top">

			<fieldset style="font-size: 11px">

				<legend><b> </b> </legend>
				<table width="100%" height="40" style="font-size: 11px">
					<tbody>
					<tr>
						<td width="150">* Categoria:</td>
						<td id="tdCategoria"></td>
					
						<td width="150">* Tipo de registro:</td>
						<td id="tdTipoRegistro"></td>
					</tr>
					</tbody>
			</table>
			</fieldset>

			</td>

		</tr>


		<tr>
			<td width="100%" valign="top">

			<fieldset style="font-size: 11px"><legend><b>Datos
			de entrada </b> </legend>
			<table width="100%" height="100" style="font-size: 11px">
				<tbody>
					<tr>
						<td width="150">* Aerolinea:</td>
						<td id="tdAereolinea"></td>
					
						<td width="150">* Nro. de vuelo:</td>
						<td><input name="txtNroVuelo" type="text"
								   id="txtNroVuelo" width="150" style="width:'210';" maxlength="20"/></td>
					</tr>
					<tr>
						<td width="150">* Origen:</td>
						<td id="tdOrigen"></td>
				
						<td width="150">* Destino:</td>
						<td id="tdDestino"></td>
					</tr>
					<tr>
						<td width="150">* Ingreso:</td>
						<td><input name="text" type="text" id="dtFechaIngreso"
							size="12" readonly="true" /></td>
				
						<td width="150">* Salida:</td>
						<td><input name="text" type="text" id="dtFechaSalida"
							size="12" readonly="true" /></td>
					</tr>
				</tbody>
			</table>
			</fieldset>
			</td>
		</tr>

		<tr>
			<td colspan="3">
				<fieldset style="font-size: 11px"><legend><b>Hospedaje/s</b></legend>
					<table width="100%" height="100" style="font-size: 11px">
						<tbody>
							<tr>
							<td width="150">* Tipo de hospedaje:</td>
							<td id="divTipoHospedaje"></td>
						</tr>
						<tr>
							<td width="150">* Isla de hospedaje:</td>
							<td id="divIslaHospedaje"></td>
						</tr>
						<tr>
							<td width="150"><div id="labelHospedaje"></div></td>
							<td><div id="divNombreHospedaje"></div>
							<div id="divNombreHospedajeIsla"></div>
							<input name="divLugarHospedaje" type="text" id="divLugarHospedaje" maxlength="200"/>
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
								</tr>
							</thead>
							<tbody
								style="width: 100%; height: 120; overflow: auto; display: block"></tbody>
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
					<table width="100%" height="120" style="font-size: 11px">
						<tbody>

						<tr>
							<td width="250">* &iquest;Usted est&aacute; viajando?</td>
							<td id="tdInformacionViaje1"></td>
							<td width="250">* N&uacute;mero de miembros</td>
							<td><input name="textNumeroMiembros" type="text" id="txtNumeroMiembros" onkeypress="return aceptarNumeros(event, this);" maxlength="10"/></td>
						</tr>

						<tr>
							<td width="250">* &iquest;Qu&eacute; motiva su viaje a Gal&aacute;pagos?</td>
							<td id="tdInformacionViaje2"></td>
							<td width="250">* &iquest;Usted est&aacute; viajando a Gal&aacute;pagos dentro de un tour organizado y contratado fuera de Gal&aacute;pagos?</td>
							<td id="tdInformacionViaje4"></td>
						</tr>

						<tr>
							<td width="250">* &iquest;De d&oacute;nde se informa de las actividades que realizar&aacute; en Gal&aacute;pagos?</td>
							<td id="tdInformacionViaje3"></td>
							<td width="250">* &iquest;Cu&aacute;l?</td>
							<td><input name="textCual" type="text" id="txtCual" maxlength="200"/></td>
						</tr>


						</tbody>
					</table>
					<table width="100%" style="font-size: 11px;border: 1px solid #ddd;">
						<tbody>
						   <tr>
						       <td width="50%" style="border-bottom: 1px solid #ddd;">* Califique con estrellas (1 menor valoraci&oacute;n, 4 mayor valoraci&oacute;n) qu&eacute; tan importantes son los siguientes atractivos para su decisi&oacute;n de visitar Gal&aacute;pagos
						       </td>
							   <td width="50%">
								   <table width="100%" style="border: 1px solid #ddd;">
									   <tbody>
								            <tr>
								             <td style="border-bottom: 1px solid #ddd;"><p id="vidaMarina">Vida Marina</p></td>
								             <td style="border-bottom: 1px solid #ddd;">
								            <div>
											  <p class="clasificacion">
											    <input id="marina1" name="estrellas" value="4" type="radio" onclick="colcarValorCal('1',this.value);">
											    <label for="marina1">&#9733;</label>
											    <input id="marina2" name="estrellas" value="3" type="radio" onclick="colcarValorCal('1',this.value);">
											    <label for="marina2">&#9733;</label>
											    <input id="marina3" name="estrellas" value="2" type="radio" onclick="colcarValorCal('1',this.value);">
											    <label for="marina3">&#9733;</label>
											    <input id="marina4" name="estrellas" value="1" type="radio" onclick="colcarValorCal('1',this.value);">
											    <label for="marina4">&#9733;</label>
											  </p>
											</div>
								             </td>
								            </tr>
								            <tr>
								             <td  width="50%" height="15px" style="border-bottom: 1px solid #ddd;"><p id="solyplaya">Sol y Playa</p></td>
								             <td  width="50%" height="15px" style="border-bottom: 1px solid #ddd;">
								              <div>
											  <p class="clasificacion">
											    <input id="sol1" name="estrellas1" value="4" type="radio" onclick="colcarValorCal('2',this.value);">
											    <label for="sol1">&#9733;</label>
											    <input id="sol2" name="estrellas1" value="3" type="radio" onclick="colcarValorCal('2',this.value);">
											    <label for="sol2">&#9733;</label>
											    <input id="sol3" name="estrellas1" value="2" type="radio" onclick="colcarValorCal('2',this.value);">
											    <label for="sol3">&#9733;</label>
											    <input id="sol4" name="estrellas1" value="1" type="radio" onclick="colcarValorCal('2',this.value);">
											    <label for="sol4">&#9733;</label>
											  </p>
											</div>
								              </td>
								            </tr>
								            <tr>
								             <td width="50%" style="border-bottom: 1px solid #ddd;"><p id="vidaterrestre">Vida Terrestre</p></td>
								             <td width="50%" style="border-bottom: 1px solid #ddd;">
								              <div>
											  <p class="clasificacion">
											    <input id="terrestre1" name="estrellas2" value="4" type="radio" onclick="colcarValorCal('3',this.value);">
											    <label for="terrestre1">&#9733;</label>
											    <input id="terrestre2" name="estrellas2" value="3" type="radio" onclick="colcarValorCal('3',this.value);">
											    <label for="terrestre2">&#9733;</label>
											    <input id="terrestre3" name="estrellas2" value="2" type="radio" onclick="colcarValorCal('3',this.value);">
											    <label for="terrestre3">&#9733;</label>
											    <input id="terrestre4" name="estrellas2" value="1" type="radio" onclick="colcarValorCal('3',this.value);">
											    <label for="terrestre4">&#9733;</label>
											  </p>
											</div>
								             </td>
								            </tr>
								            <tr>
								             <td><p id="paisaje">Paisaje</p></td>
								             <td>
								             <div>
											  <p class="clasificacion">
											    <input id="paisaje1" name="estrellas3" value="4" type="radio" onclick="colcarValorCal('4',this.value);">
											    <label for="paisaje1">&#9733;</label>
											    <input id="paisaje2" name="estrellas3" value="3" type="radio" onclick="colcarValorCal('4',this.value);">
											    <label for="paisaje2">&#9733;</label>
											    <input id="paisaje3" name="estrellas3" value="2" type="radio" onclick="colcarValorCal('4',this.value);">
											    <label for="paisaje3">&#9733;</label>
											    <input id="paisaje4" name="estrellas3" value="1" type="radio" onclick="colcarValorCal('4',this.value);">
											    <label for="paisaje4">&#9733;</label>
											  </p>
											</div>
								             </td>
								            </tr>
								       </tbody>
						           </table>
							   </td>
						   </tr>
						   <tr>
						   <td width="50%">* Califique con estrellas (1 menor valoraci&oacute;n, 4 mayor valoraci&oacute;n) qu&eacute; tan importantes son las siguientes actividades en su decisi&oacute;n de visitar Gal&aacute;pagos
						   </td>
						   <td width="50%">
						       <table width="100%" style="font-size: 11px;border: 1px solid #ddd;">
								    <tbody>
							                <tr>
								             <td width="50%" style="border-bottom: 1px solid #ddd;"><p id="crucero">Crucero</p></td>
								             <td width="50%" style="border-bottom: 1px solid #ddd;">
								             <div>
											  <p class="clasificacion">
											    <input id="crucero1" name="estrellas5" value="4" type="radio" onclick="colcarValorCal('5',this.value);">
											    <label for="crucero1">&#9733;</label>
											    <input id="crucero2" name="estrellas5" value="3" type="radio" onclick="colcarValorCal('5',this.value);">
											    <label for="crucero2">&#9733;</label>
											    <input id="crucero3" name="estrellas5" value="2" type="radio" onclick="colcarValorCal('5',this.value);">
											    <label for="crucero3">&#9733;</label>
											    <input id="crucero4" name="estrellas5" value="1" type="radio" onclick="colcarValorCal('5',this.value);">
											    <label for="crucero4">&#9733;</label>
											  </p>
											</div>
								             </td>
								            </tr>
								            <tr>
								             <td width="50%" style="border-bottom: 1px solid #ddd;"><p id="buceo">Buceo</p></td>
								             <td width="50%" style="border-bottom: 1px solid #ddd;">
								              <div>
											  <p class="clasificacion">
											    <input id="buceo1" name="estrellas6" value="4" type="radio" onclick="colcarValorCal('6',this.value);">
											    <label for="buceo1">&#9733;</label>
											    <input id="buceo2" name="estrellas6" value="3" type="radio" onclick="colcarValorCal('6',this.value);">
											    <label for="buceo2">&#9733;</label>
											    <input id="buceo3" name="estrellas6" value="2" type="radio" onclick="colcarValorCal('6',this.value);">
											    <label for="buceo3">&#9733;</label>
											    <input id="buceo4" name="estrellas6" value="1" type="radio" onclick="colcarValorCal('6',this.value);">
											    <label for="buceo4">&#9733;</label>
											  </p>
											</div>
								             </td>
								            </tr>
								            <tr>
								             <td width="50%" style="border-bottom: 1px solid #ddd;"><p id="snorkel">Snorkel</p></td>
								             <td width="50%" style="border-bottom: 1px solid #ddd;">
								             <div>
											  <p class="clasificacion">
											    <input id="snorkel1" name="estrellas7" value="4" type="radio" onclick="colcarValorCal('7',this.value);">
											    <label for="snorkel1">&#9733;</label>
											    <input id="snorkel2" name="estrellas7" value="3" type="radio" onclick="colcarValorCal('7',this.value);">
											    <label for="snorkel2">&#9733;</label>
											    <input id="snorkel3" name="estrellas7" value="2" type="radio" onclick="colcarValorCal('7',this.value);">
											    <label for="snorkel3">&#9733;</label>
											    <input id="snorkel4" name="estrellas7" value="1" type="radio" onclick="colcarValorCal('7',this.value);">
											    <label for="snorkel4">&#9733;</label>
											  </p>
											</div>
								             </td>
								            </tr>
								            <tr>
								             <td width="50%" style="border-bottom: 1px solid #ddd;"><p id="kayak">Kayak</p></td>
								             <td width="50%" style="border-bottom: 1px solid #ddd;">
								              <div>
											  <p class="clasificacion">
											    <input id="kayak1" name="estrellas8" value="4" type="radio" onclick="colcarValorCal('8',this.value);">
											    <label for="kayak1">&#9733;</label>
											    <input id="kayak2" name="estrellas8" value="3" type="radio" onclick="colcarValorCal('8',this.value);">
											    <label for="kayak2">&#9733;</label>
											    <input id="kayak3" name="estrellas8" value="2" type="radio" onclick="colcarValorCal('8',this.value);">
											    <label for="kayak3">&#9733;</label>
											    <input id="kayak4" name="estrellas8" value="1" type="radio" onclick="colcarValorCal('8',this.value);">
											    <label for="kayak4">&#9733;</label>
											  </p>
											</div>
								             </td>
								            </tr>
								            <tr>
								             <td width="50%" style="border-bottom: 1px solid #ddd;"><p id="surf">Surf</p></td>
								             <td width="50%" style="border-bottom: 1px solid #ddd;">
								              <div>
											  <p class="clasificacion">
											    <input id="surf1" name="estrellas9" value="4" type="radio" onclick="colcarValorCal('9',this.value);">
											    <label for="surf1">&#9733;</label>
											    <input id="surf2" name="estrellas9" value="3" type="radio" onclick="colcarValorCal('9',this.value);">
											    <label for="surf2">&#9733;</label>
											    <input id="surf3" name="estrellas9" value="2" type="radio" onclick="colcarValorCal('9',this.value);">
											    <label for="surf3">&#9733;</label>
											    <input id="surf4" name="estrellas9" value="1" type="radio" onclick="colcarValorCal('9',this.value);">
											    <label for="surf4">&#9733;</label>
											  </p>
											</div>
								             </td>
								            </tr>
								            <tr>
								             <td width="50%" style="border-bottom: 1px solid #ddd;"><p id="senderisimo">Senderismo</p></td>
								             <td width="50%" style="border-bottom: 1px solid #ddd;">
								             <div>
											  <p class="clasificacion">
											    <input id="senderismo1" name="estrellas10" value="4" type="radio" onclick="colcarValorCal('10',this.value);">
											    <label for="senderismo1">&#9733;</label>
											    <input id="senderismo2" name="estrellas10" value="3" type="radio" onclick="colcarValorCal('10',this.value);">
											    <label for="senderismo2">&#9733;</label>
											    <input id="senderismo3" name="estrellas10" value="2" type="radio" onclick="colcarValorCal('10',this.value);">
											    <label for="senderismo3">&#9733;</label>
											    <input id="senderismo4" name="estrellas10" value="1" type="radio" onclick="colcarValorCal('10',this.value);">
											    <label for="senderismo4">&#9733;</label>
											  </p>
											</div>
								             </td>
								            </tr>
								            <tr>
								             <td width="50%" style="border-bottom: 1px solid #ddd;"><p id="observacion">Observaci&oacute;n e interpretaci&oacute;n de vida silvestre</p></td>
								             <td width="50%" style="border-bottom: 1px solid #ddd;">
								              <div>
											  <p class="clasificacion">
											    <input id="silvestre1" name="estrellas11" value="4" type="radio" onclick="colcarValorCal('11',this.value);">
											    <label for="silvestre1">&#9733;</label>
											    <input id="silvestre2" name="estrellas11" value="3" type="radio" onclick="colcarValorCal('11',this.value);">
											    <label for="silvestre2">&#9733;</label>
											    <input id="silvestre3" name="estrellas11" value="2" type="radio" onclick="colcarValorCal('11',this.value);">
											    <label for="silvestre3">&#9733;</label>
											    <input id="silvestre4" name="estrellas11" value="1" type="radio" onclick="colcarValorCal('11',this.value);">
											    <label for="silvestre4">&#9733;</label>
											  </p>
											</div>
								             </td>
								            </tr>
								            <tr>
								             <td width="50%" style="border-bottom: 1px solid #ddd;"><p id="fotografia">Fotograf&iacute;a</p></td>
								             <td width="50%" style="border-bottom: 1px solid #ddd;">
								              <div>
											  <p class="clasificacion">
											    <input id="fotografia1" name="estrellas12" value="4" type="radio" onclick="colcarValorCal('12',this.value);">
											    <label for="fotografia1">&#9733;</label>
											    <input id="fotografia2" name="estrellas12" value="3" type="radio" onclick="colcarValorCal('12',this.value);">
											    <label for="fotografia2">&#9733;</label>
											    <input id="fotografia3" name="estrellas12" value="2" type="radio" onclick="colcarValorCal('12',this.value);">
											    <label for="fotografia3">&#9733;</label>
											    <input id="fotografia4" name="estrellas12" value="1" type="radio" onclick="colcarValorCal('12',this.value);">
											    <label for="fotografia4">&#9733;</label>
											  </p>
											</div>
								             </td>
								            </tr>
								            <tr>
								             <td><p id="persa">Pesca vivencial</p></td>
								             <td>
								              <div>
											  <p class="clasificacion">
											    <input id="pesca1" name="estrellas13" value="4" type="radio" onclick="colcarValorCal('13',this.value);">
											    <label for="pesca1">&#9733;</label>
											    <input id="pesca2" name="estrellas13" value="3" type="radio" onclick="colcarValorCal('13',this.value);">
											    <label for="pesca2">&#9733;</label>
											    <input id="pesca3" name="estrellas13" value="2" type="radio" onclick="colcarValorCal('13',this.value);">
											    <label for="pesca3">&#9733;</label>
											    <input id="pesca4" name="estrellas13" value="1" type="radio" onclick="colcarValorCal('13',this.value);">
											    <label for="pesca4">&#9733;</label>
											  </p>
											</div>
								             </td>
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
<!--class="componetHide"-->
<div id="FrmIngresoPersona" class="componetHide"
	style="position: fixed; left: 130; top: 50; background-color: #fff;">
<div class="cssFormularioBorde"><span class="cssFormularioTitulo"><b>Datos
de la persona</b></span>
<form action="" id="frmPersona" method="get">
<table width="450" height="400" border="0" class="cssForularioInterno">
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
		<th>Estado Civil:</th>
		<td><select id="cbmEstadoCivil" name="cbmEstadoCivil" disabled="disabled">
			<option value="0">Soltero/a</option>
			<option value="1">Casado/a</option>
			<option value="2">Divorsiado/a</option>
			<option value="3">Viudo/a</option>
			<option value="4">Union Libre</option>
			<option value="5">Se ignora</option>
		</select></td>
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
		<th>C&oacute;digo Postal:</th>
		<td><input name="txtCodigoPostal" type="text"
				   id="txtCodigoPostal" width="150" readonly="true" /></td>
	</tr>
	<tr>
		<th>Nacionalidad:</th>
		<td id="tdNacionalidad"></td>
	</tr>

	<tr>
		<th>Estudios:</th>
		<td><select id="cbmEstudios" name="cbmEstudios" disabled="disabled">
			<option value="0">Primarioa</option>
			<option value="1">Secuandaria</option>
			<option value="1">Superior</option>
			<option value="1">Otros</option>
		</select></td>
	</tr>

	<tr>
		<th>Correo Electr&oacute;nico:</th>
		<td><input name="txtCorreoElectronico" type="text"
				   id="txtCorreoElectronico" width="150" readonly="true" /></td>
	</tr>

	<tr>
		<th>Confirmaci&oacute;n Correo Electr&oacute;nico:</th>
		<td><input name="txtConfirCorreoElectronico" type="text"
				   id="txtConfirCorreoElectronico" width="150" readonly="true" /></td>
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
</BODY>
</html>