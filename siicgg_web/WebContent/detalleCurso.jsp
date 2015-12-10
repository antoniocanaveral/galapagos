<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Detalle del curso</title>
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css" />
<link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css" />
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/bsxComboBox.js"></script>
<script type="text/javascript" src="js/bsxTable.js"></script>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxMessageBox.js"></script>
<script type="text/javascript" src="js/detalleCurso.js"></script>
<script type="text/javascript" src="js/prototype.js"></script>
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
<body onLoad="loadDetalleCurso();">
<input type="hidden" id="txtUsuario"
	value=<% try{ out.println(request.getUserPrincipal().getName()); }catch(Exception ex){ out.println(false); } %> /></input>
<div id="divDatosCurso" class="bgmodal componetHide">
<% out.println(request.getParameter("datos"));%>
</div>
<input type="hidden" id="txtTipoCurso"
	value=<% out.println(request.getParameter("tipoCurso"));%> /></input>
<div class="tituloPrincipal">Detalle del curso</div>
<div id="divBgModal" class="bgtransparent"
	style="width: 100%; height: 100%"></div>
<div class="descripcionPrincipal">El formulario permite visualizar
las carateristicas principales del curso seleccionado</div>
<br />
<br />
<button id="btnAtras"><img src="css/icon/atras.gif" />Atras</button>
<div id="divLogineo" style="display: none; width: 646" class="divAviso"></div>
<div id="divCabecera" style="display: none; width: 646"
	class="divAvisoInfo"></div>
<div id="divRegistrado" style="display: none; width: 646"
	class="divAvisoInfo"></div>
<table width="496" border=0 cellpadding=0 cellspacing=0 align="left"
	style="font-size: 11">
	<tr>
		<td width="432">
		<table width="651" border="0">
			<tr>
				<td width="643"><!-- <fieldset style="font-size:11px"> <legend><b>Detalle general del curso</b> </legend>-->
				<table width="646" border="0" style="font-size: 13px">
					<tr>
						<th width="50">Curso:</th>
						<td width="586" colspan="3" id="tdCurso"
							style="color: #006699; font-weight: bold">&nbsp;</td>
					</tr>
				</table>
				<br />
				<table border="0" class="cssCV" style="font-size: 11px; width: 646"
					cellspacing="0" cellpadding="5">
					<tr>
						<th>Tipo de curso:</th>
						<td width="144" id="tdTipoCurso">&nbsp;</td>
						<th width="131">Coordinador:</th>
						<td width="144" id="tdCoordinador">&nbsp;</td>
					</tr>
					<tr>
						<th>Patrocinador:</th>
						<td id="tdPatrocinador">&nbsp;</td>
						<th>N. M&oacute;dulos:</th>
						<td id="tdNumeroModulos">&nbsp;</td>
					</tr>
					<tr>
						<th>Cupo m&aacute;ximo:</th>
						<td id="tdCuposMaximos" style="color: #009933; font-weight: bold">&nbsp;</td>
						<th>Cupos disponibles:</th>
						<td id="tdCuposDisponibles"
							style="color: #009933; font-weight: bold">&nbsp;</td>
					</tr>
					<tr>
						<th>Duraci&oacute;n:</th>
						<td id="tdDuracion">&nbsp;</td>
						<th>Horario:</th>
						<td id="tdHorario">&nbsp;</td>
					</tr>
					<tr>
						<th>Lugar:</th>
						<td id="tdLugar">&nbsp;</td>
						<th>Local:</th>
						<td id="tdLocal">&nbsp;</td>
					</tr>
					<tr>
						<th>Fecha Inicio:</th>
						<td id="tdFechaInicio">&nbsp;</td>
						<th>Costo final<br />
						(incluido descuentos):</th>
						<td id="tdCosto">&nbsp;</td>
					</tr>
					<tr>
						<th>Fecha Finalizaci&oacute;n:</th>
						<td id="tdFechaFin">&nbsp;</td>
						<th>&nbsp;</th>
						<td></td>
					</tr>
					<tr>
						<th>Contenido:</th>
						<td colspan="3" id="tdContenidoModulos">&nbsp;</td>
					</tr>
					<tr>
						<th>&nbsp;</th>
						<td id="tdFechaFin">&nbsp;</td>
						<th>&nbsp;</th>
						<td>
						<div align="right">
						<button id="btnInscribirse"><img
							src="css/icon/ico_inscripcion.gif" />Inscribirse al curso</button>
						</div>
						</td>
					</tr>
				</table>
				<!--</fieldset>--></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td>
		<div id="FrmPreRegistroCurso" class="bgmodal componetHide"
			style="position: fixed; left: 70; top: 35; background-color: #fff;">
		<div class="cssFormularioBorde"><span
			class="cssFormularioTitulo"><b>Pre-inscripci&oacute;n</b></span>
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
				<th>N. Documento de identificaci&oacute;n:</th>
				<td id="tdCedulaIdentidad"></td>
			</tr>
			<tr>
				<th>Curso a pre-registrar:</th>
				<td id="tdCursoPreRegistrar"></td>
			</tr>
		</table>
		<form id="frmPreRegistroCurso" enctype="multipart/form-data"
			method="post" action="">
		<table class="infoTabla" width="100%" cellspacing="0" cellpadding="3">
			<tr>
				<th width="150">Sector productivo en el que trabaja:</th>
				<td width="350" id="tdSectorProductivo"></td>
			</tr>
			<tr>
				<th valign="top">Actividad que realiza:</th>
				<td><textarea cols="45" id="txtActividad" rows="3"></textarea>
				</td>
			</tr>
			<div id="divBgModal" class="bgtransparent"
				style="width: 100%; height: 100%"></div>
		</table>
		</form>
		<div>
		<button id="btnGuardar" type="reset"><img
			src="css/icon/save.png" />Guardar</button>
		<button id="btnCancelar"><img src="css/icon/salir.png" />Cerrar</button>
		</div>
		</fieldset>
		</div>
		</div>
		</td>
	</tr>
</table>
</body>
</html>