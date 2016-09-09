<%@ page import="com.besixplus.sii.util.Env" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<link rel="stylesheet" type="text/css" href="css/jquery/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="css/jquery/ui.all.css" />
<link rel="stylesheet" type="text/css" href="css/form.css" />
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css" />
<link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css" />
<link rel="stylesheet" type="text/css" href="css/bsxTabPanel.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery/jstree/style.css" />
	<%out.println(Env.loadExternalScripts("siicgg_web/javascripts.properties"));%>
<script type="text/javascript" src="js/Reporte.js"></script>
<script type="text/javascript" src="js/bsxMessageBox.js"></script>
<script type="text/javascript" src="lib/jquery/jquery.js"></script>
<script type="text/javascript" src="lib/jquery/ui.core.min.js"></script>
<script type="text/javascript" src="lib/jquery/ui.dialog.js"></script>
<script type="text/javascript" src="lib/jquery/ui.resizable.js"></script>
<script type="text/javascript" src="lib/jquery/ui.draggable.js"></script>
<script type="text/javascript" src="lib/jquery/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="lib/jquery/ui.tabs.min.js"></script>
<script type="text/javascript" src="lib/validador.js"></script>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxTable.js"></script>
<script type="text/javascript" src="js/bsxComboBox.js"></script>
<script type="text/javascript" src="lib/jquery/jquery.jstree.js"></script>
<script type="text/javascript" src="js/tramiteVehiculo.js"></script>
</head>
<BODY>
<input type="hidden" id="txtUsuario"
	value=<% try{ out.println(request.getUserPrincipal().getName()); }catch(Exception ex){ out.println(false); } %> /></input>
<div class="tituloPrincipal" style="padding-top: 8px">Registro de
tr&aacute;mites de veh&iacute;culos</div>
<div class="descripcionPrincipal">El formulario permite registrar
e iniciar su tramite de veh&iacute;culo</div>
<br />
<br />
<div id="divLogineo" style="display: none; width: 646" class="divAviso"></div>
<div id="myForm" style="display: none">
<div class="form-all">
<fieldset><legend><b>Informaci&oacute;n
auspiciante</b></legend>
<ul class="form-section">
	<li class="form-line"><label class="form-label-left"
		id="lblIslaTramite" for="divIslaTramite"> Recepci&oacute;n
	tr&aacute;mite </label>
	<div class="form-input">
	<div id='divIslaTramite'></div>
	</div>
	<label class="obligatorio">(*)</label></li>
	<div id="divCargando1" class="cargando"
		style="display: none; position: fixed;"><span>Cargando...</span></div>
	<li class="form-line"><label class="form-label-left"
		id="lblTipoResidencia" for="divTipoResidenciaPadre"> Tipo
	tr&aacute;mite </label>
	<div class="form-input">
	<div id='divTipoResidenciaPadre'></div>
	</div>
	<label class="obligatorio">(*)</label></li>
	<li class="form-line"><label class="form-label-left"
		id="llblMotivoResidencia" for="divTipoSolicitudResidencia">
	Motivo tr&aacute;mite </label>
	<div class="form-input">
	<div id='divTipoSolicitudResidencia'></div>
	</div>
	<label class="obligatorio">(*)</label></li>
	<div class="form-line"><label class="form-label-left"
		id="lblIdentificacionAuspiciante" for="txtIdentificacionAuspiciante">Tipo
	identificaci&oacute;n </label>
	<div class="form-input"><input type="text" class="form-textbox"
		id="txtIdentificacionAuspiciante" name="txtIdentificacionAuspiciante"
		size="20" /></div>
	</div>
	<div class="form-line"><label class="form-label-left"
		id="lblNumDocAuspiciante" for="txtNumDocAuspiciante"> No. doc.
	identific </label>
	<div class="form-input"><input type="text" class="form-textbox"
		id="txtNumDocAuspiciante" name="txtNumDocAuspiciante" size="20" /> <label
		class="obligatorio">(*)</label></div>
	</div>
	<div class="form-line"><label class="form-label-left"
		id="lblAuspiciante" for="txtNombreAuspiciante"> Auspiciante </label>
	<div class="form-input"><span class="form-sub-label-container">
	<input class="form-textbox" type="text" size="40"
		name="txtNombreAuspiciante" id="txtNombreAuspiciante" /> <label
		class="form-sub-label" for="txtNombreAuspiciante"
		id="lblNombreAuspiciante1"> Nombres y Apellidos </label> </span></div>
	</div>
	<div id="divEmpresa" class="form-line" style="display: none"><label
		class="form-label-left" id="lblAuspiciantePJ"
		for="txtNombreAuspiciantePJ"> Empresa </label>
	<div class="form-input"><span class="form-sub-label-container">
	<input class="form-textbox" type="text" size="20"
		name="txtNombreAuspiciantePJ" id="txtNombreAuspiciantePJ" /> </span></div>
	</div>
	<li class="form-line"><label class="form-label-left"
		id="lblNumeroResidencia" for="txtNumeroResidencia"> No.
	residencia</label>
	<div class="form-input"><input type="text" class="form-textbox"
		id="txtNumeroResidencia" name="txtNumeroResidencia" size="20" /></div>
	</li>
	<li class="form-line"><label class="form-label-left"
		id="lblNacionalidad" for="txtNacionalidad"> Nacionalidad</label>
	<div class="form-input"><input type="text" class="form-textbox"
		id="txtNacionalidad" name="txtNacionalidad" size="20" /></div>
	</li>
	<li class="form-line"><label class="form-label-left"
		id="lblEstadoCivil" for="txtEstadoCivil"> Estado Civil</label>
	<div class="form-input"><input type="text" class="form-textbox"
		id="txtEstadoCivil" name="txtEstadoCivil" size="20" /> <label>
	Datos maritales? <input type="checkbox" name="chkDatosConyuge"
		id="chkDatosConyuge" /> </label></div>
	</li>
	<div id="divConyuge" style="display: none">
	<li class="form-line"><label class="form-label-left"
		id="lblNumConyuge" for="txtNumConyuge"> No.
	identificaci&oacute;n</label>
	<div class="form-input"><input type="text" class="form-textbox"
		id="txtNumConyuge" name="txtNumConyuge" size="20" />
	<button id="btnBuscarConyuge" title="Buscar conyuge"><img
		src="css/icon/buscar.png" /></button>
	</div>
	</li>
	<li class="form-line"><label class="form-label-left"
		id="lblConyuge" for="txtNombreConyuge"> Conyuge </label>
	<div class="form-input"><span class="form-sub-label-container">
	<input class="form-textbox" type="text" size="20"
		name="txtNombreConyuge" id="txtNombreConyuge" /> <label
		class="form-sub-label" for="txtNombreConyuge" id="lblNombreConyuge1">
	Nombre </label> </span> <span class="form-sub-label-container"> <input
		class="form-textbox" type="text" size="15" name="txtApellidoConyuge"
		id="txtApellidoConyuge" /> <label class="form-sub-label"
		for="txtApellidoConyuge" id="lblApellidoConyuge1"> Apellido </label> </span>
	</div>
	</li>
	</div>
	<li class="form-line"><label class="form-label-left"
		id="lblJustificacion" for="txtJustificacion">Motivo</label>
	<div class="form-input"><textarea name="txtJustificacion"
		id="txtJustificacion" rows="3" cols="40"></textarea></div>
	<label class="obligatorio">(*)</label></li>
</ul>
</fieldset>
<div id="tabs">
<ul>
	<li><a href="#divAuspiciado"><b>Datos veh&iacute;culo</b></a></li>
	<li><a href="#divContacto"><b>Contacto</b></a></li>
</ul>
<!-- <fieldset> <legend>Datos vehiculo</legend>-->
<div id="divAuspiciado">
<ul class="form-section">
	<li class="form-line"><label class="form-label-left"
		id="lblVehiculoTipo" for="cbxVehiculoTipo"> Tipo
	veh&iacute;culo </label>
	<div class="form-input"><select name="cbxVehiculoTipo"
		id="cbxVehiculoTipo"></select></div>
	<label class="obligatorio">(*)</label> <label id='lblVehiculoExistente'>
	Vehiculo existente? <input type="checkbox" name="chkVehiculoExistente"
		id="chkVehiculoExistente" /> </label></li>
	<li class="form-line"><label class="form-label-left"
		id="lblVehiculoCategoria" for="txtVehiculoCategoria">
	Categoria </label>
	<div class="form-input"><input type="text" class="form-textbox"
		name="txtVehiculoCategoria" id="txtVehiculoCategoria" size="20" /> <label
		class="obligatorio">(*)</label>
	<button id="btnBuscarCategoria" title="Buscar categoria"><img
		src="css/icon/buscar.png" /></button>
	</div>
	</li>
	<li class="form-line"><label class="form-label-left"
		id="lblVehiculoSector" for="divVehiculoSector"> Sector </label>
	<div class="form-input">
	<div id='divVehiculoSector'></div>
	</div>
	<label class="obligatorio">(*)</label></li>
	<li class="form-line"><label class="form-label-left"
		id="lblVehiculoSectorProductivo" for="divVehiculoSectorProductivo">
	Sector product. </label>
	<div class="form-input">
	<div id='divVehiculoSectorProductivo'></div>
	</div>
	<label class="obligatorio">(*)</label></li>
	<li class="form-line"><label class="form-label-left"
		id="lblVehiculoCilindraje" for="divVehiculoCilindraje">
	Cilindraje </label>
	<div class="form-input">
	<div id='divVehiculoCilindraje'></div>
	</div>
	<label class="obligatorio">(*)</label></li>
	<li class="form-line"><label class="form-label-left"
		id="lblVehiculoCombustible" for="divVehiculoCombustible">
	Combustible </label>
	<div class="form-input">
	<div id='divVehiculoCombustible'></div>
	</div>
	<label class="obligatorio">(*)</label></li>
	<li class="form-line"><label class="form-label-left"
		id="lblVehiculoTonelaje" for="txtVehiculoTonelaje">Tonelaje</label>
	<div class="form-input"><input type="text" class="form-textbox"
		id="txtVehiculoTonelaje" name="txtVehiculoTonelaje" size="20" /> <label
		class="obligatorio">(*)</label></div>
	</li>
	<li class="form-line"><label class="form-label-left"
		id="lblVehiculoFabricacion" for="txtVehiculoFabricacion">A&ntilde;o
	fabricaci&oacute;n</label>
	<div class="form-input"><input type="text" class="form-textbox"
		id="txtVehiculoFabricacion" name="txtVehiculoFabricacion" size="20" />
	<label class="obligatorio">(*)</label></div>
	</li>
	<div id="divReemplaza" style="display: none"><label
		class="form-label-left" id="lblVehiculoReemplaza"
		for="divVehiculoCombustible"> Reemplaza a </label>
	<div class="form-input">
	<div id='divVehiculoReemplaza'></div>
	</div>
	</div>
</ul>
<span class="obligatorio"> Los campos marcados con (*) son
obligatorios</span></div>
<!-- </fieldset> -->
<div id="divContacto">
<div class="form-line cssTabButton">
<div id="divBgModal" class="bgtransparent"
	style="width: 100%; height: 100%"></div>
<table width="200" border="0" style="font-size: 11px">
	<tr>
		<td><!--  -->
		<div id="divBtnControlesContactoPersona" class="cssTabButton"
			style="border-top: 1px solid gray; border: medium">
		<button id="btnNuevoCgg_gem_contacto_persona"><img
			src="css/icon/add.png" />A&ntilde;adir</button>
		<button id="btnEditarCgg_gem_contacto_persona"><img
			src="css/icon/edit.png" />Editar</button>
		<button id="btnEliminarCgg_gem_contacto_persona"><img
			src="css/icon/eliminar.png" />Borrar</button>
		</div>
		<br />
		<div id="FrmListadoContactoPersona" style="border: 1px solid gray">
		<!--<div id="divGrdContactoPersona"></div>-->
		<table class="tabla" cellspacing="0" border="0"
			id='tblContactosPersona'
			style="font-size: 11px; border: 1px solid #CCCCCC; width: 600px">
			<thead
				style="display: block; border-bottom: 1px solid #CCCCCC; width: 100%">
				<tr>
					<th width="225px">
					<div align="left">Tipo</div>
					</th>
					<th width="365px">
					<div align="left">Contacto</div>
					</th>
					<th class="Invisible">
					<div align="left">Descripcion</div>
					</th>
				</tr>
			</thead>
			<tbody
				style="width: 100%; height: 153px; overflow: auto; display: block"></tbody>
		</table>
		</div>
		<div id="FrmContactoPersona" class="bgmodal componetHide"
			style="position: fixed; left: 140; top: 315; background-color: #fff;">
		<div class="cssFormularioBorde"><span
			class="cssFormularioTitulo"><b>Contactos</b></span> <input
			type="hidden" id="txtCrprc_codigo" name="txtCrprc_codigo" />
		<table width="300" border="0" style="font-size: 11px">
			<tr>
				<th>Tipo:</th>
				<td id="tdCbxTipoContacto"></td>
			</tr>
			<tr>
				<th>Contacto:</th>
				<td><input name="txtCrprc_contacto" type="text"
					id="txtCrprc_contacto" style="width: 180px" /></td>
			</tr>
		</table>
		<div class="cssTabButton">
		<button id="btnGuardarCgg_gem_contacto_persona"><img
			src="css/icon/save.png" />Guardar</button>
		<button id="btnSalirCgg_gem_contacto_persona"><img
			src="css/icon/salir.png" />Salir</button>
		</div>
		</div>
		</div>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
</table>
</div>
</div>
</div>
</div>
<br />
<div id="dlgVehiculos" title="Vehiculos">
<div id="divGrdVehiculo"></div>
</div>
<div id="dlgVehiculoCategoria" title="Vehiculos">
<div id='divVehiculoCategoria'></div>

</div>
<div id="dlgReglaValidacion" title="Regla validacion">
<div id="divReglaValidacion" class="divTramite"></div>
</div>
<div class="cssTabButton">
<button id="btnGuardarTramiteVehiculos"><img
	src="css/icon/save.png" />Guardar</button>
<button id="btnSalirTramiteVehiculos"><img
	src="css/icon/salir.png" />Cerrar</button>
</div>
</div>
</BODY>
</html>