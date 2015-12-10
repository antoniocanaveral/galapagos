<html>
<head>
<title>SIICGG Atenci&oacute;n al cliente</title>
<link rel="stylesheet" type="text/css" href="css/style1.css" />
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/prototype.js"></script>
</head>
<body onLoad="loadInit()">
<input type="hidden" id="txtUsuario"
	value=<% 
		try{
			out.println(request.getUserPrincipal().getName());
		}catch(Exception ex){
			out.println(false);
		}
	%> />

<table width="100%" height="100%" border=0 cellspacing=0 cellpadding=0>
	<tr>
		<td>
		<table align="center" width="800px" height="100%" border=0
			cellspacing=0 cellpadding=0>
			<tr height="120px">
				<td valign="top">
				<table align="center" width="100%">
					<tr>
						<td align="right" class="tituloAcceso">
						<div align="center">CONSEJO DE GOBIERNO <br />
						DEL REGIMEN ESPECIAL DE<br />
						GALAPAGOS</div>
						</td>
						<td class="bnr-logo">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>

			<tr height="100%">
				<td valign="top">
				<table width="900px" height="100%" border="0" cellpadding=0
					cellspacing=0 style="min-width: 750px;">
					<tr>
						<td valign="top" width="180px" style="min-width: 180px;"><!--Area de la fecha-->
						<div id="divFecha" style="width: 100%"></div>
						<!--Area de login para usuarios registrados-->
						<div class="login"
							style="background-color: #E2F0F9; border: 1px solid #A9D1E9"
							id="divLogin">
						<div id="divUsuario"></div>
						<div
							style="border-top: 1 dashed #C1D573; margin: 3; height: auto; display: none"></div>
						<div id="divFrase"></div>
						<span id="btnCambiarClave"
							style="align: left; display: none; font-size: 11;">Cambiar
						clave</span>
						<div align="right" style="display: block">
						<button id="btnAcceso" style="font-size: 13; font-weight: bold;"><b>Ingresar</b></button>
						</div>
						</div>
						<div id="pnlGestionEmpleo" class="login">
						<div id="loading" class="cargandoIcon"
							style="text-indent: 20; height: 100%">Cargando...</div>
						<div id="btnInfoAdicional" style="display: none"></div>
						<ul class="linkLI">
							<li id="btnBuscarEmpleo" style="display: none">Ver ofertas
							de empleo</li>
							<li id="btnHojaVida" style="display: none">Mi Curriculum</li>
							<li id="btnAplicaciones" style="display: none">Mis
							Aplicaciones</li>
							<li id="btnDenunciaSugerencia" style="display: none">Denuncia
							y Sugerencia</li>
							<li id="btnSubscripcionCargos" style="display: none">Cargos
							de inter&eacute;s</li>
							<li id="btnActivarCuenta" style="display: none">Inscribir al
							sistema</li>
							<li id="btnEmpresasRegistradas" style="display: none">Empresas
							afiliadas</li>
							<li id="btnDesactivarCuenta" style="display: none">Dar de
							baja del sistema</li>
							<li id="btnRegistroEmpresa" style="display: none">Registro
							de empresa</li>
							<li id="btnAccederSistema" style="display: none">Acceder al
							sistema</li>
							<li id="btnComunicadoRadial" style="display: none">Comunicado
							Radial</li>
						</ul>
						<div id="divIndicador" class="descripcionAcceso"
							style="display: none; border-top: 1 solid #CCCCCC; margin-right: 10">
						</div>


						</div>
						<!--Panel de accesos directos-->
						<table width="100%" class="accesoDirecto" cellpadding="0"
							cellspacing="0">
							<tr>
								<td valign="middle" style="border-top: 0px;">
								<div id="divInicio">
								<div class="icon iconInicio"></div>
								<div class="title tituloAcceso">
								<div style="margin-top: 12px">Inicio</div>
								</div>
								<div><!--class="load"--></div>
								</div>
								<div id="divInicio-Items" class="clsItems"
									style="display: block">
								<div>
								<ul>
									<li id="lnkInicio"
										style="list-style-image: url(css/icon/house.png);">Inicio</li>
									<li id="lnkNoticias"
										style="list-style-image: url(css/icon/newspaper.png);">Noticias</li>
								</ul>
								</div>
								</div>
								</td>
							</tr>
							<tr>
								<td valign="middle" id="tdGestionEmpleo">
								<div id="divGestEmpleo">
								<div class="icon iconGE"></div>
								<div class="title tituloAcceso">
								<div style="margin-top: 12px">Empleo</div>
								</div>
								<div><!--class="load"--></div>
								</div>
								<div id="divGestEmpleo-Items" class="clsItems"
									style="display: none">
								<div style="max-width: 175px">
								<ul>
									<li id="linkCandidatos"
										style="list-style-image: url(css/icon/group.png);">Candidatos</li>
									<li id="linkAdministrador"
										style="list-style-image: url(css/icon/user_gray.png);">Persona
									Natural</li>
									<li id="linkEmpresas"
										style="list-style-image: url(css/icon/bricks.png);">Persona
									Jur&iacute;dica</li>
									<li
										style="margin-bottom: 0px 5px 10px 0px; width: 120px; cursor: default; list-style-type: none; border-bottom: 1px dotted #EE8E41">&nbsp;</li>
									<li id="linkContacto"
										style="list-style-image: url(css/icon/book_open.png);">Cont&aacute;ctenos</li>
									<li id="linkPreguntas"
										style="list-style-image: url(css/icon/comment.png);">Preg.
									Frecuentes</li>
								</ul>
								</div>
								</div>
								</td>
							</tr>
							<tr>
								<td valign="center">
								<div id="divDesarrollo">
								<div class="icon iconDH"></div>
								<div class="title tituloAcceso">
								<div style="margin-top: 12px">Des. Humano</div>
								</div>
								<div><!--class="load"--></div>
								</div>
								<div id="divDesarrollo-Items" class="clsItems"
									style="display: none">
								<div style="max-width: 175px">
								<ul>
									<li id="linkPreregistrocurso"
										style="list-style-image: url(css/icon/ico_inscripcion.gif);">Pre-inscripci&oacute;n
									curso</li>
									<li
										style="margin-bottom: 0px 5px 10px 0px; width: 120px; cursor: default; list-style-type: none; border-bottom: 1px dotted #EE8E41">&nbsp;</li>
									<li id="linkContactoDH"
										style="list-style-image: url(css/icon/book_open.png);">Cont&aacute;ctenos</li>
									<li id="linkPreguntasDH"
										style="list-style-image: url(css/icon/comment.png);">Preg.
									Frecuentes</li>
								</ul>
								</div>
								</div>
								</td>
							</tr>
							<tr>
								<td valign="center">
								<div id="divPreRegistroTCT">
								<div class="icon iconRS"></div>
								<div class="title tituloAcceso">
								<div style="margin-top: 12px">Pre-registro TCT</div>
								</div>
								<div><!--class="load"--></div>
								</div>
								</td>
							</tr>
							<tr style="display: none">
								<td valign="center">
								<div id="divUsuarios">
								<div class="icon iconUser"></div>
								<div class="title tituloAcceso">
								<div style="margin-top: 12px">Usuarios</div>
								</div>
								<div><!--class="load"--></div>
								</div>
								</td>
							</tr>
							<tr>
								<td valign="center">
								<div id="divTramitesVehiculo">
								<div class="icon iconVehiculo"></div>
								<div class="title tituloAcceso">
								<div style="margin-top: 12px">Veh&iacute;culos</div>
								</div>
								<div><!--class="load"--></div>
								</div>
								<div id="divTramitesVehiculo-Items" class="clsItems"
									style="display: none">
								<div style="height: 100%;">
								<ul>
									<li id="btnIngresoTramitesV"
										style="list-style-image: url(css/icon/add.png);">Ingreso
									tr&aacute;mites</li>
									<li
										style="margin-bottom: 0px 5px 10px 0px; width: 120px; cursor: default; list-style-type: none; border-bottom: 1px dotted #EE8E41">&nbsp;</li>
									<li id="linkContactoV"
										style="list-style-image: url(css/icon/book_open.png);">Cont&aacute;ctenos</li>
									<li id="linkPreguntasV"
										style="list-style-image: url(css/icon/comment.png);">Preg.
									Frecuentes</li>
									<!--<li id="btnConsultaTramitesV" >Consulta tramites</li>                            
							<li id="btnRequisitosTramitesV" >Requisito solicitudes</li>-->
								</ul>
								</div>
								</div>
								</td>
							</tr>
							<tr>
								<td valign="center">
								<div id="divTramitesResidencia">
								<div class="icon iconTR"></div>
								<div class="title tituloAcceso">
								<div style="margin-top: 12px">Residencia</div>
								</div>
								<div><!--class="load"--></div>
								</div>
								<div id="divTramitesResidencia-Items" class="clsItems"
									style="display: none">
								<div style="height: 100%;">
								<ul>
									<li id="btnIngresoTramites"
										style="list-style-image: url(css/icon/add.png);">Ingreso
									tr&aacute;mites</li>
									<li id="btnConsultaTramites"
										style="list-style-image: url(css/icon/buscar.png);">Consulta
									tr&aacute;mites</li>
									<li id="btnRequisitosTramites"
										style="list-style-image: url(css/icon/requisitos.png);">Requisito
									solicitudes</li>
									<li id="btnImpresionSolicitud"
										style="list-style-image: url(css/icon/printer.png);">Impresi&oacute;n
									Certificados</li>
									<li
										style="margin-bottom: 0px 5px 10px 0px; width: 120px; cursor: default; list-style-type: none; border-bottom: 1px dotted #EE8E41">&nbsp;</li>
									<li id="linkContactoR"
										style="list-style-image: url(css/icon/book_open.png);">Cont&aacute;ctenos</li>
									<li id="linkPreguntasR"
										style="list-style-image: url(css/icon/comment.png);">Preg.
									Frecuentes</li>
								</ul>
								</div>
								</div>
								</td>
							</tr>
						</table>
						<div>&nbsp;</div>
						</td>
						<td width="15px" style="border-top: 1px solid #E6E6E6;">&nbsp;</td>
						<td valign="top" style="border-top: 1px solid #E6E6E6;"><!--Contenido de la pagina web-->
						<table width="100%" cellpadding=0 cellspacing=0 scrolling="no">
							<tr>
								<td>
								<div id="divCargando" class="cargando"><span>Cargando...</span></div>
								<iframe frameborder="0" scrolling="no" id="iFrameBody"
									src="bienvenida.jsp?CWPAG_CODIGO=CWPAG1"
									style="margin: 0; padding: 0; max-width: 700;" width="100%"
									onload="document.getElementById('divCargando').style.visibility='hidden';">
								</iframe></td>
							</tr>
						</table>
					</tr>
				</table>
				</td>
			</tr>

		</table>
		<tr height="50px">
			<td class="panelCopy" align="center" valign="center"><!--Area de menus inferiores
	<table align="center" cellpadding="5px"><tr>
		<td><span>Inicio</span></td>
		<td><span>Seguimiento</span></td>
		<td><span>Gestion de empleo</span></td>
		<td><span>Proyectos</span></td>
		<td><span>Contactenos</span></td>
	</tr></table>
	Area del contacto direccion de la institucion-->
			<table width="800px">
				<!--<tr>
		<td colspan="5" align="right"><span>
				Oficina Central CGG: Ecuador - San Crist&oacute;bal - Puerto Baquerizo Moreno.<br/>
				Telf: (05)2520133 - (05)2520171 - (05)2520172 - (05)2520185 - (05)2521008<br/>
		</span></td>
	</tr>-->
				<tr>
					<td colspan="5" align="right"><span style="margin-top: 20px">Copyright
					&copy; 2011 besixplus http://www.besixplus.com</span></td>
				</tr>
			</table>
			<div></div>
			</td>
		</tr>
</table>

</body>
</html>