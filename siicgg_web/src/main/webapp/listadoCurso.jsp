<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Listado de cursos</title>
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css" />
<link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css" />
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/bsxComboBox.js"></script>
<script type="text/javascript" src="js/bsxTable.js"></script>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxMessageBox.js"></script>
<script type="text/javascript" src="js/listadoCursos.js"></script>
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
<body onLoad="loadListadoCursos();">
<input type="hidden" id="txtUsuario"
	value=<% try{ out.println(request.getUserPrincipal().getName()); }catch(Exception ex){ out.println(false); } %> /></input>
<div class="tituloPrincipal">Listado de Cursos</div>
<div id="divBgModal" class="bgtransparent"
	style="width: 100%; height: 100%"></div>
<div class="descripcionPrincipal">El formulario permite visualizar
el listado de cursos al cual podr&aacute;s inscribirte.</div>
<br />
<br />

<table width="496" border=0 cellpadding=0 cellspacing=0 align="left"
	style="font-size: 11">
	<tr>
		<td width="432">
		<table width="595" border="0" style="font-size: 11px" cellpadding="0"
			cellspacing="0">
			<tr>
				<th width="85">
				<div align="left">Tipo de Curso:</div>
				</th>
				<td width="244" id="tdTipoCurso">&nbsp;</td>
				<td width="244"><img src="css/icon/flag.png"
					title="Pre-inscrito" />Cursos a los que ya est&aacute;
				pre-inscrito</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
				<td width="22">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3">
				<div id="divGrdListadoCursos"></div>
				</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
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
				<th>N. Documento de identificaci&oacute;n</th>
				<td id="tdCedulaIdentidad"></td>
			</tr>
			<tr>
				<th>Curso a pre-registrar</th>
				<td id="tdCursoPreRegistrar"></td>
			</tr>
		</table>
		<form id="frmPreRegistroCurso" enctype="multipart/form-data"
			method="post" action="">
		<table class="infoTabla" width="100%" cellspacing="0" cellpadding="3">
			<tr>
				<th width="150">Sector productivo:</th>
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