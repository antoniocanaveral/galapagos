<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Requisitos por tipo de solicitud de residencia</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/superfish.css"
	media="screen">
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="lib/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="lib/jquery/jquery.js"></script>
<script type="text/javascript" src="lib/jquery/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="lib/hoverIntent.js"></script>
<script type="text/javascript" src="lib/superfish.js"></script>
<script type="text/javascript" src="js/requisitosTipoSolicitud.js"></script>
<script type="text/javascript" src="js/Reporte.js"></script>
</head>
<body onLoad="loadrequisitosTipoSolicitud();">
<input type="hidden" id="txtUsuario"
	value=<% try{ out.println(request.getUserPrincipal().getName()); }catch(Exception ex){ out.println(false); } %> /></input>
<div style="padding-top: 10px; position: relative; height: 800">
<div class="tituloPrincipal">Requisitos para las solicitudes de
Residencia</div>
<div class="descripcionPrincipal">Verifique cuales son los
requisitos de cada una de las solicitudes de Residencia</div>
<br>
<fieldset style="width: 650; float: left; clear: left; border: #fdf5e6">
<div id="divMenu" style="padding-bottom: 20px"></div>
<br>
<div id="tmpMensaje"></div>
<div id="divTipoSolicitud"
	style="padding-top: 10px; padding-bottom: 20px; font-size: 12px; color: gray"></div>
<div id="divFrmListadoRequisitos"></div>
</fieldset>
</div>
</body>
</html>