<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Comunicado Radial</title>
<link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css" />
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/bsxTabPanel.css" />
<link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css" />
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxTable.js"></script>
<script type="text/javascript" src="js/bsxComboBox.js"></script>
<script type="text/javascript" src="js/bsxTabPanel.js"></script>
<script type="text/javascript" src="js/bsxMessageBox.js"></script>
<script type="text/javascript" src="js/cambiarContrasenia.js"></script>
<script type="text/javascript" src="js/prototype.js"></script>
<script type="text/javascript">
		function setHeightForm(){		
			try{
				parent.document.getElementById('iFrameBody').height =0;			
				parent.document.getElementById('iFrameBody').height = document["body"].offsetHeightForm+40;
			}catch(e){				
			}			
		}	
	</script>
<style type="text/css">
<!--
.Visible {
	display: block;
}

.Invisible {
	display: none;
}

.Estilo1 {
	color: #FFFFFF
}
-->
</style>
</head>
<body onLoad="loadCambiarContrasenia();">

<input type="hidden" id="txtUsuario"
	value=<% 
		try{
			out.println(request.getUserPrincipal().getName());
		}catch(Exception ex){
			out.println(false);
		}
	%> />
<div class="menu" valign="top">
<div class="tituloPrincipal" style="float: left; padding-top: 8px">Cambiar
Contrase&ntilde;a</div>
<!--<ul >
		<li><a href="#">Inicio</a></li>
		<li><a href="#">Nosotros</a></li>
		<li><a href="#">Servicios</a></li>
		<li style="border-right:0"><a href="#">Contacto</a></li>
	</ul>--></div>
<br>
<br>
<div id="divBgModal" class="bgtransparent"
	style="width: 100%; height: 100%"></div>
<div id="divTabInfo">Para cambiar su contrase&ntilde;a debe tener
en cuenta las siguientes indicaciones:
<ul>
	<li>La contrase&ntilde;a que va a cambiar afectara a todo el
	sitema.</li>
</ul>
</div>
<br>
<br>
<table width="690" border=0 cellpadding=0 cellspacing=0>
	<tr>
		<td>
		<div id="FrmCambiarContrasenia">
		<table border=0 class="cssTabPanel">
			<tr>
				<th width=150>Nombre de usuario:</th>
				<td width="105"><input name="txtCusu_nombre_usuarioAC"
					type="text" id="txtCusu_nombre_usuarioAC"></td>
			</tr>
			<tr>
				<th>Clave actual:</th>
				<td><input name="txtCusu_clave_actual" type="password"
					id="txtCusu_clave_actual"></td>
			</tr>
			<tr>
				<th width=150>Clave de Acceso:</th>
				<td width="105"><input name="txtCusu_clave_accesoAC"
					type="password" id="txtCusu_clave_accesoAC"></td>
			</tr>
			<tr>
				<th width=150>Confirmar Clave:</th>
				<td width="105"><input name="txtConfirmarClaveAC"
					type="password" id="txtConfirmarClaveAC"></td>
			</tr>
			<tr>
				<td>
				<button id="btnCusu_Guardar"><img src="css/icon/save.png" />Guardar</button>
				</td>
				<td>
				<button id="btnCusu_Cancelar"><img src="css/icon/save.png" />Cancelar</button>
				</td>
			</tr>
		</table>
		</div>
		</td>
	</tr>
</table>
<button id="btnReload1" style="display: none"></button>
</body>
</html>