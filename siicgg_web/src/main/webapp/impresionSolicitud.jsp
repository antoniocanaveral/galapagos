<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="lib/jquery/jquery.js"></script>
<script type="text/javascript" src="lib/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="lib/jquery/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxComboBox.js"></script>
<script type="text/javascript" src="js/impresionSolicitud.js"></script>
<script type="text/javascript" src="js/Reporte.js"></script>



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
	padding: 10px;
}

.form-label-right {
	width: 150px !important;
}

.form-all {
	width: 650px;
	font-family: "Trebuchet MS";
	font-size: 12px;
}

#myDiv {
	background-image: url(css/image/com.gif);
	background-repeat: no-repeat;
	background-position: 400px 5px;
	padding-top: 0px;
	text-align: justify;
	background-color: #ebf8fc;
	border-radius: 10px;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
}

div.divTramite {
	width: 98%;
	margin: 1%;
	padding: 10px
}

table#tableSeguimiento {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	width: 90%;
	border-spacing: 5px 5px;
	border-collapse: collapse;
	font-family: verdana, arial;
	font-size: 10pt
}

.font {
	font-family: verdana, arial;
	font-size: 10pt
}

#tableSeguimiento tbody tr.even td {
	background-color: #eee;
}

#tableSeguimiento tbody tr.odd  td {
	background-color: #fff;
}

tr,td {
	text-align: left;
}

th {
	text-align: center;
}

th:hover {
	cursor: pointer;
}

#divInfoTramite {
	background-image: url(css/image/tramite.png);
	background-repeat: no-repeat;
	background-position: top center;
	padding-top: 0px;
	text-align: justify;
	height: 48px;
}

.divTramiteGeneral {
	background-image: url(css/image/tramite.png);
	background-repeat: no-repeat;
	background-position: top center;
	padding-top: 0px;
	text-align: justify;
	height: 48px;
}

.divSeguimiento {
	background-image: url(css/image/nodo.png);
	background-repeat: no-repeat;
	background-position: top center;
	padding-top: 0px;
	text-align: justify;
	height: 48px;
}

.divSeguimientoAtendido {
	background-image: url(css/image/despachado.png);
	background-repeat: no-repeat;
	background-position: top center;
	padding-top: 0px;
	text-align: justify;
	height: 48px;
}

.divSeguimientoPendiente {
	background-image: url(css/image/pendiente.png);
	background-repeat: no-repeat;
	background-position: top center;
	padding-top: 0px;
	text-align: justify;
	height: 48px;
}

.link {
	
}
</style>


</head>
<body>
<input type="hidden" id="txtUsuario"
	value=<% try{ out.println(request.getUserPrincipal().getName()); }catch(Exception ex){ out.println(false); } %> /></input>
<div style="padding-top: 10px; height: 100%;">
<div class="tituloPrincipal" style="padding-top: 8px">Impresi&oacute;n
de solicitud de transeunte.</div>
<div class="descripcionPrincipal">El formulario permite visualizar
todos las solicitudes de transeuntes aprobadas</div>
<br />
<br />
<div id="divLogineo" style="display: none; width: 646" class="divAviso"></div>
<div class="form-all">
<div id="divTramite" class="divTramite"></div>

</div>
</div>
</body>
</html>