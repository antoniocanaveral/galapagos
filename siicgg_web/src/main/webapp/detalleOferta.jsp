<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Detalle de la oferta</title>
<link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css" />
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css" />
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxMessageBox.js"></script>
<script type="text/javascript" src="js/detalleOferta.js"></script>
</head>
<body onLoad="loadOfertasByUsuario();">
<input type="hidden" id="txtUsuario"
	value=<% 
		try{
			out.println(request.getUserPrincipal().getName());
		}catch(Exception ex){
			out.println(false);
		}
	%> />

<input type="hidden" id="txtCodigoVacante"
	value=<% out.println(request.getParameter("codVacante"));%> />
<input type="hidden" id="txtCodigoUsuario"
	value=<% out.println(request.getParameter("codUsuario"));%> />
<input type="hidden" id="txtView"
	value=<% out.println(request.getParameter("view"));%> />
<input type="hidden" id="txtAplico"
	value=<% out.println(request.getParameter("aplico"));%> />

<div class="tituloPrincipal">Detalle de la oferta</div>
<div class="descripcionPrincipal">Aqu&iacute; podras encontrar
m&aacute;s informaci&oacute;n de la oferta de tu interes.</div>
<br>
<table align="center" style="font-size: 10px">
	<tr>
		<td>
		<div class="linksPrincipal">
		<div style="width: 250; margin: auto auto; font-size: 13;"
			class="link"><a id="lnkAtras" href="#"><img
			src="css/icon/anterior.png" /> Regresar al listado de ofertas</a></div>
		</div>
		<br>
		<div id="divAviso"
			style="display: none; width: 440; margin: auto auto;"
			class="divAviso">Para aplicar a la oferta de empleo debe poseer
		una cuenta de usuario y estar habilitado en el sistema de
		gesti&oacute;n de empleo. Si no lo est&aacute;, comun&iacute;quese con
		el administrador del sistema.</div>
		<div id="divAvisoInfo"
			style="display: none; width: 440; margin: auto auto;"
			class="divAvisoInfo">Actualmente usted esta registrado como
		candidato para esta oferta.</div>
		<br>
		<div class="divDetalleOferta">
		<table width="100%" class="detalleOferta" border=0 align="center"
			cellpadding=3 cellspacing=2>
			<tr>
				<td colspan="3" class="tdTitulo">Informaci&oacute;n del empleo</td>
			</tr>
			<tr>
				<th width="120">Cargo:</th>
				<td id="tdCGCRG_NOMBRE">&nbsp;</td>
				<td rowspan=3 width=120 align="center">
				<div style="width: 75; padding: 15 15; display: none"
					class='divBtnAplicar' id="divAplicar">Click aqu&iacute; para
				aplicar a esta oferta</div>
				<div id="divAplicando" style="display: none"><img
					src="css/icon/cargando.gif" /> Por favor espere...</div>
				</td>
			</tr>
			<tr>
				<th>Lugar:</th>
				<td id="tdCGVCN_DIRECCION">&nbsp;</td>
			</tr>
			<!-- <tr>
		<th>T&iacute;tulo prof.:</th>
		<td id="tdCGARE_NOMBRE">&nbsp;</td>
	  </tr>-->
			<tr>
				<th>Sector Productivo:</th>
				<td id="tdCGVCN_TITULO">&nbsp;</td>
			</tr>
			<tr>
				<th>Descripci&oacute;n:</th>
				<td id="tdCGVCN_DESCRIPCION" colspan=2>&nbsp;</td>
			</tr>
			<tr>
				<th>Requisitos:</th>
				<td id="tdRequisitos" colspan=2>&nbsp;</td>
			</tr>
			<tr>
				<th>Tipo de contrato:</th>
				<td id="tdCGTCN_DESCRIPCION" colspan=2>&nbsp;</td>
			</tr>
			<tr>
				<th>No. de vacantes:</th>
				<td id="tdCGVCN_NUMERO_VACANTES" colspan=2>&nbsp;</td>
			</tr>
			<tr>
				<th>Salarios $:</th>
				<td id="tdCGVCN_SALARIO" colspan=2></td>
			</tr>
			<tr>
				<td colspan="3" class="tdTitulo">Informaci&oacute;n del
				empleador</td>
			</tr>
			<tr>
				<th id="thNombreEmpresaPersona">&nbsp;</th>
				<td id="tdEmpresa" colspan=2>&nbsp;</td>
			</tr>
		</table>
		</div>
		</td>
	</tr>
</table>
<div id="divModalAplicar" class="bgtransparent"
	style="width: 100%; height: 100%"></div>
<div id="winAplicar" class="bgmodal">
<div class="cssFormularioBorde"><span id="spanTitle"
	class="cssFormularioTitulo"><b></b></span>
<table border=0 class="bsxWindows">
	<input type="hidden" id="txtCodigoVacante" />
	<tbody>
		<tr>
			<td>Aspiraci&oacute;n salarial $:</td>
			<td><input type="text" id="txtAspiracion" value="120" size=10 />
			</td>
		</tr>
		<tr>
			<td>Descripci&oacute;n:</td>
			<td><TEXTAREA id="txtDescripcion"></TEXTAREA></td>
		</tr>
	</tbody>

</table>
<div id="divBtnControlesIdiomaPersona" class="cssTabButton">
<button id="btnAceptar"><img src="css/icon/save.png" /> Aceptar</button>
<button
	onClick="document.getElementById('winAplicar').style.display='none';document.getElementById('divModalAplicar').style.display='none';">
<img src="css/icon/salir.png" /> Cerrar</button>
</div>
</div>
</div>
</body>
</html>