<%@ page import="com.besixplus.sii.util.Env" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<script type="text/javascript" src="lib/jquery/jquery.js"></script>
<script type="text/javascript" src="lib/jquery/ui.core.min.js"></script>
<script type="text/javascript" src="lib/jquery/ui.tabs.min.js"></script>
<script type="text/javascript" src="lib/jquery/ui.datepicker.js"></script>
<script type="text/javascript" src="lib/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="lib/validador.js"></script>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxComboBox.js"></script>
<script type="text/javascript" src="js/tramiteResidencia.js"></script>
	<%out.println(Env.loadExternalScripts("siicgg_web/javascripts.properties"));%>


<link rel="stylesheet" type="text/css" href="css/jquery/ui.all.css" />
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/form.css" />


<style type="text/css">
.form-label {
	width: 150px !important;
}

.form-label-left {
	width: 150px !important;
}

.form-line {
	padding: 3px;
}

.form-label-right {
	width: 150px !important;
}

.form-all {
	width: 650px;
	color: #000000 !important;
	/* font-family:"Arial Black";*/
	font-size: 10px;
}

td.hovered {
	background-color: lightblue;
	color: #666;
}
/*#myForm label.error {
	margin-left: 10px;
	width: auto;
	display: inline;*/ /*.tooltip {
        background-color:#000;
        border:1px solid #fff;
        padding:10px 15px;
        width:200px;
        display:none;
        color:#fff;
        text-align:left;
        font-size:12px;

         outline radius for mozilla/firefox only
        -moz-box-shadow:0 0 10px #000;
        -webkit-box-shadow:0 0 10px #000;
    }*/
}
</style>

<script type="text/javascript">
		function setHeightForm(){
			
			
			try{
				parent.document.getElementById('iFrameBody').height =0;			
				parent.document.getElementById('iFrameBody').height = document["body"].offsetHeightForm+40;
			}catch(e){				
			}			
		}
		/*$.validator.setDefaults({
	        submitHandler: function() { alert("submitted!"); }
        });*/
	</script>




</head>
<BODY>
<div>Registro de tramites de residencia</div>
<div class="jotform-form" id="myForm">
<div class="form-all">
<fieldset><legend>Informaci&oacute;n auspiciante</legend>
<ul class="form-section">
	<div class="form-line"><label class="form-label-left"
		id="lblCrper_identificacion"> Tipo identificaci&oacute;n </label>
	<div class="form-input">
	<div id='divTipoIdentificacion'></div>
	</div>
	</div>

	<div class="form-line"><label class="form-label-left"
		id="lblNumDocAuspiciante" for="txtNumDocAuspiciante"> No. doc.
	identific </label>
	<div class="form-input"><input type="text" class="form-textbox"
		id="txtNumDocAuspiciante" name="txtNumDocAuspiciante" size="20" />
	<button id="btnBuscarAuspiciante" title="Buscar auspiciante"><img
		src="css/icon/buscar.png" /></button>
	</div>
	</div>
	<div class="form-line"><label class="form-label-left"
		id="lblAuspiciante" for="txtNombreAuspiciante"> Auspiciante </label>
	<div class="form-input"><span class="form-sub-label-container">
	<input class="form-textbox" type="text" size="20"
		name="txtNombreAuspiciante" id="txtNombreAuspiciante" /> <label
		class="form-sub-label" for="txtNombreAuspiciante"
		id="lblNombreAuspiciante1"> Nombre </label> </span><span
		class="form-sub-label-container"> <input class="form-textbox"
		type="text" size="15" name="txtApellidoAuspiciante"
		id="txtApellidoAuspiciante" /> <label class="form-sub-label"
		for="txtApellidoAuspiciante" id="lblApellidoAuspiciante1">
	Apellido </label> </span></div>
	</div>
	<li class="form-line"><label class="form-label-left"
		id="lblNumResidenciaAuspiciante" for="txtNumResidenciaAuspiciante">
	No. residencia </label>
	<div class="form-input"><input type="text" class="form-textbox"
		id="txtNumResidenciaAuspiciante" name="txtNumResidenciaAuspiciante"
		size="20" /></div>
	</li>
</ul>
</fieldset>
<div id="tabs">
<ul>
	<li><a href="#divAuspiciado">Informaci&oacute;n Beneficiario</a></li>
	<li><a href="#divContacto">Contacto</a></li>

</ul>
<div id="divAuspiciado">
<ul class="form-section">
	<li class="form-line"><label class="form-label-left"
		id="lblIdentificacionBeneficiario"
		for="divTipoIdentificacionBeneficiario"> Tipo
	identificaci&oacute;n </label>
	<div class="form-input">
	<div id='divTipoIdentificacionBeneficiario'></div>
	</div>
	</li>
	<li class="form-line"><label class="form-label-left"
		id="lblNumDocBeneficiario" for="txtNumDocBeneficiario"> No.
	doc. identific </label>
	<div class="form-input"><input type="text" class="form-textbox"
		id="txtNumDocBeneficiario" name="txtNumDocBeneficiario" size="20" />
	</div>
	</li>
	<li class="form-line" id="id_1"><label class="form-label-left"
		id="lblBeneficiario" for="txtNombreBeneficiario"> Beneficiario
	</label>
	<div class="form-input"><span class="form-sub-label-container">
	<input class="form-textbox" type="text" size="25"
		name="txtNombreBeneficiario" id="txtNombreBeneficiario" /> <label
		class="form-sub-label" for="txtNombreBeneficiario" id="sublabel_first">
	Nombres </label> </span> <span class="form-sub-label-container"> <input
		class="form-textbox" type="text" size="15"
		name="txtApellidoPaternoBeneficiario"
		id="txtApellidoPaternoBeneficiario" /> <label class="form-sub-label"
		for="txtApellidoPaternoBeneficiario" id="sublabel_middle">
	Primer Apellido </label> </span> <span class="form-sub-label-container"> <input
		class="form-textbox" type="text" size="15"
		name="txtApellidoMaternoBeneficiario"
		id="txtApellidoMaternoBeneficiario" /> <label class="form-sub-label"
		for="txtApellidoMaternoBeneficiario" id="sublabel_last">
	Segundo Apellido </label> </span></div>
	</li>
	<li class="form-line"><label class="form-label-left"
		id="lblPaisResidencia" for="divPaisResidencia"> Pa&iacute;s
	residencia </label>
	<div class="form-input">
	<div id='divPaisResidencia'></div>
	</div>
	</li>
	<li class="form-line"><label class="form-label-left"
		id="lblNacionalidadBeneficiario" for="divNacionalidadBeneficiario">
	Nacionalidad </label>
	<div class="form-input">
	<div id='divNacionalidadBeneficiario'></div>
	</div>
	</li>
	<li class="form-line"><label class="form-label-left"
		id="lblFechaNacimiento" for="dtFechaNacimiento"> Fecha de
	nacimiento </label> <input type="text" id="dtFechaNacimiento"
		name='dtFechaNacimiento'></li>
	<li class="form-line"><label class="form-label-left"
		id="llblGenero" for="divTipoSolicitudResidencia"> Genero </label> <input
		type="radio" name="rdbtnGenero" value="0" checked="checked"
		id="rdMasculino" /> <label for="rdMasculino">Masculino</label> <input
		type="radio" name="rdbtnGenero" value="1" id="rdFemenino" /> <label
		for="rdFemenino">Femenino</label></li>
	<li class="form-line"><label class="form-label-left"
		id="lblIslaTramite" for="divIslaTramite"> Isla tr&aacute;mite
	</label>
	<div class="form-input">
	<div id='divIslaTramite'></div>
	</div>
	</li>
	<li class="form-line"><label class="form-label-left"
		id="lblTipoResidencia" for="divTipoResidenciaPadre"> Tipo
	residencia </label>
	<div class="form-input">
	<div id='divTipoResidenciaPadre'></div>
	</div>
	</li>
	<li class="form-line"><label class="form-label-left"
		id="llblMotivoResidencia" for="divTipoSolicitudResidencia">
	Motivo residencia </label>
	<div class="form-input">
	<div id='divTipoSolicitudResidencia'></div>
	</div>
	</li>
</ul>
</div>
<div id="divContacto">
<div class="form-line cssTabButton">
<button id="create-user"><img src="css/icon/save.png" /></button>
</div>
<input type="text" id="myRes" />
<table id="users">
	<thead>
		<tr class="ui-widget-header">
			<th width="20%">Name</th>
			<th width="20%">Email</th>
			<th width="20%">Password</th>
		</tr>
	</thead>
	<tbody>

		<tr>
			<td>John Doe</td>
			<td>john.doe@example.com</td>
			<td>johndoe1</td>
		</tr>
	</tbody>
</table>

</div>

</div>

</div>
<br>


<div class="cssTabButton">
<button id="btnGuardarTramiteResidencia"><img
	src="css/icon/save.png" />Seleccionar</button>
<button id="btnSalirTramiteResidencia"><img
	src="css/icon/save.png" />Cerrar</button>
</div>
</div>


</BODY>
</html>