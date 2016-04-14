<html>
<head>
<title>SIICGG Atenci&oacute;n al cliente</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
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
		<td style="padding-top: 25px; padding-bottom: 20px;" valign="top">
		<table align="center" width="900px" border=0 cellspacing=0
			cellpadding=0 bgcolor="#ffffff" style="border: 1px solid #CFD7D8;">
			<tr height="120px">
				<td valign="top">
				<table align="center" width="100%" border=0 cellspacing=0
					cellpadding=0>
					<tr height="25px">
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td width="142" rowspan="2" align="left" valign="bottom"><img
							src="css/image/mapa.gif" width="124" height="107">
						<div class="clsAcceso" align="center"><a href="/sii"
							style="font-size: 11px">Acceso a siicgg</a></div>
						</td>
					</tr>
					<tr>
						<td width="170" align="center" valign="middle"><img
							src="css/image/logoSII.gif" alt=""></td>
						<td align="left" valign="middle"><img
							src="css/image/TituloSII.gif" alt=""></td>
						<td width="67" align="center" valign="middle"><img
							src="css/image/transparente.gif" width="65" height="62"></td>
						<td width="85" align="center" valign="middle"><img
							src="css/image/seguro.gif" width="48" height="62"></td>
						<td width="33" align="center" valign="middle">&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>

			<tr height="100%">
				<td valign="top" style="border-top: 1px solid #E6E6E6;">
				<table width=920 height="100%" border="0" cellpadding=0
					cellspacing=0 style="min-width: 750px;">
					<tr>
						<td valign="top" width=200 style="min-width: 180px;"><!--Area de la fecha-->
						<div id="divFecha" align="center"></div>
						<div id="lnkAccesoLogin" style="display: none">Click
						aqu&iacute; para ingresar al sistema</div>
						<div id="divLogin" class="login"
							style="display: none; background-color: #E6EFC2; border-color: #C1D573">
						<div id="divUsuario"></div>
						<div id="divFrase"><img src="css/icon/cargando.gif" />cargando...</div>
						<table width="100%">
							<tr>
								<td>
								<div id="btnCambiarClave" style="float: left" class="linkNormal">Cambiar
								clave</div>
								</td>
								<td>
								<div id="btnAcceso" class="linkNormal" style="float: right"
									onClick="">Salir</div>
								</td>
							</tr>
						</table>
						</div>
						<div id="pnlGestionEmpleo" class="login" style="display: none">
						<div id="loading" class="cargandoIcon"
							style="text-indent: 20px; height: 100%">Cargando...</div>
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
							style="display: none; border-top: 1px solid #CCCCCC; margin-right: 10px">
						</div>


						</div>
						<!--Panel de accesos directos-->
						<table width="100%" class="accesoDirecto" cellpadding="0"
							cellspacing="0" style="margin-top: 10px">
							<tr>
								<td valign="middle">
								<div id="divInicio">
								<div class="icon iconInicio"></div>
								<span class="tituloAcceso">Inicio</span><br />
								<span class="descripcionAcceso">P&aacute;gina inicial</span></div>
								</td>
							</tr>
							<tr>
								<td valign="middle" id="tdGestionEmpleo">
								<div id="divGestEmpleo">
								<div class="icon iconGE"></div>
								<span class="tituloAcceso">Gesti&oacute;n Empleo</span><br />
								<span class="descripcionAcceso">Si deseas encontrar
								empleo</span></div>
								<div id="divGestEmpleo-Items" class="clsItems"
									style="display: none">
								<div style="max-width: 175px">
								<ul>
									<li id="linkCandidatos"
										style="list-style-image: url(css/icon/group.png);">Buscar
									empleo</li>
									<li style="list-style-image: url(css/icon/bricks.png);">Publicar
									ofertas</li>
									<ul style="margin: 0px; padding-left: 20px">
										<li id="linkAdministrador" title="Si deseas publicar ofertas">Persona
										Natural</li>
										<li id="linkEmpresas">Persona Jur&iacute;dica</li>
									</ul>
									<li
										style="margin-bottom: 0px 5px 10px 0px; width: 120px; cursor: default; list-style-type: none; border-bottom: 1px dotted #EE8E41">&nbsp;</li>
									<li id="linkContacto"
										style="list-style-image: url(css/icon/book_open.png);">Cont&aacute;ctenos</li>
									<li id="linkPreguntas"
										style="list-style-image: url(css/icon/comment.png);">Preg.
									Frecuentes</li>
									<li id="linkAtencionGEM"
										style="list-style-image: url(css/icon/msn.png);">Atenci&oacute;n
									en l&iacute;nea</li>
								</ul>
								</div>
								</div>
								</td>
							</tr>
							<tr>
								<td valign="center">
								<div id="divDesarrollo">
								<div class="icon iconDH"></div>
								<span class="tituloAcceso">Desarrollo Humano</span><br />
								<span class="descripcionAcceso">Si deseas regsitrarte a
								cursos de capacitaci&oacute;n</span></div>
								<div id="divDesarrollo-Items" class="clsItems"
									style="display: none">
								<div style="max-width: 175px">
								<ul>
									<li id="linkBecaBeneficiario"
										style="list-style-image: url(css/icon/newspaper.png);">Beneficiarios
									de becas</li>
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
								<span class="tituloAcceso">Pre-registro TCT</span> <span
									class="descripcionAcceso">Registrate con
								anticipaci&oacute;n si deseas ingresar a Gal&aacute;pagos</span></div>
								<div id="divPreRegistroTCT-Items" class="clsItems"
									style="display: none">
								<div style="max-width: 175px">
								<ul>
									<li id="linkAtencionTCT"
										style="list-style-image: url(css/icon/msn.png);">Atenci&oacute;n
									en l&iacute;nea</li>
								</ul>
								</div>
								</div>
								</td>
							</tr>
							<tr>
								<td valign="center">
								<div id="divTramitesVehiculo">
								<div class="icon iconVehiculo"></div>
								<span class="tituloAcceso">Veh&iacute;culos</span><br />
								<span class="descripcionAcceso">Registra tus
								tr&aacute;mites de veh&iacute;culos</span></div>
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
									<li id="linkAtencionV"
										style="list-style-image: url(css/icon/msn.png);">Atenci&oacute;n
									en l&iacute;nea</li>
								</ul>
								</div>
								</div>
								</td>
							</tr>
							<tr>
								<td valign="center" style="border-bottom: 1px dashed #C8C8C8;">
								<div id="divTramitesResidencia">
								<div class="icon iconTR"></div>
								<span class="tituloAcceso">Residencia</span><br />
								<span class="descripcionAcceso">Registra tus
								tr&aacute;mites de residencia</span></div>
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
										style="list-style-image: url(css/icon/requisitos.png);">Requisitos</li>
									<li id="btnImpresionSolicitud"
										style="list-style-image: url(css/icon/printer.png);">Certificados</li>
									<li id="btnComite"
										style="list-style-image: url(css/icon/group.png);">Inf.
									Comit&eacute;</li>
									<li
										style="margin-bottom: 0px 5px 10px 0px; width: 120px; cursor: default; list-style-type: none; border-bottom: 1px dotted #EE8E41">&nbsp;</li>
									<li id="linkContactoR"
										style="list-style-image: url(css/icon/book_open.png);">Cont&aacute;ctenos</li>
									<li id="linkPreguntasR"
										style="list-style-image: url(css/icon/comment.png);">Preg.
									Frecuentes</li>
									<li id="linkAtencionR"
										style="list-style-image: url(css/icon/msn.png);">Atenci&oacute;n
									en l&iacute;nea</li>
								</ul>
								</div>
								</div>
								</td>
							</tr>
						</table>
						<div style="height: 22px">&nbsp;</div>
						<div id="divVarios" class="pnlVarios"
							style="vertical-align: bottom; display: none">
						<ul>
							<span style="color: #006699"><b>VIDEO TUTORIALES</b></span>
							<li>Para empresas de Gesti&oacute;n de Empleo</li>
							<li>Para agencias de viaje</li>
						</ul>
						<ul>
							<span style="color: #006699;"><b>DESCARGAS</b></span>
							<li>Descarga manual usaurio</li>
							<li>Descarga formatos</li>
						</ul>
						</div>
						</td>
						<td width="15px">&nbsp;</td>
						<td valign="top"><!--Contenido de la pagina web-->
						<table width="100%" cellpadding=0 cellspacing=0 scrolling="no">
							<tr>
								<td>
								<div id="divCargando" class="cargando"><span>Cargando...</span></div>
								<iframe frameborder="0" scrolling="no" id="iFrameBody"
									src="bienvenida.jsp?CWPAG_CODIGO=CWPAG1"
									style="margin: 0; padding: 0; max-width: 700px;" width="100%"
									onload="document.getElementById('divCargando').style.visibility='hidden';">
								</iframe></td>
							</tr>
						</table>
					</tr>
				</table>
				</td>
			</tr>

			<tr height="100%">
				<td valign="top"
					style="border-top: 1px solid #E6E6E6; padding: 10px">
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
					<tr>
						<td width="48" height="54"><img src="css/image/logocgg.gif"
							width="41" height="46" longdesc="cgg"></td>
						<td width="354" align="left" valign="middle">
						<div class="divAcercaDe" align="left" style="color: #1373A0">
						<div align="left"><b>Consejo de Gobierno de
						Gal&aacute;pagos.</b></div>
						</div>
						<div class="divAcercaDe" align="left">
						<div align="left"><a href="http://www.cgg.gob.ec">http://www.cgg.gob.ec</a></div>
						</div>
						<div class="divAcercaDe" align="left">
						<div align="left"><b>Oficina Matriz: Isla San
						Crist&oacute;bal</b></div>
						</div>
						<div class="divAcercaDe" align="left">
						<div align="left">Av. 12 de Febrero, V&iacute;a el Progreso
						(Cerro Patricio)</div>
						</div>
						</td>
						<td width="203">&nbsp;</td>
						<td width=189 align="right" valign="middle">
						<div class="divAcercaDe" style="color: #1373A0"><b>Desarrollado
						por besixplus cía ltda.</b></div>
						<div class="divAcercaDe"><a href="http://www.besixplus.com">
						http://www.besixplus.com</a></div>
						<div class="divAcercaDe">contacto@besixplus.com</div>
						<div class="divAcercaDe">Ambato-Ecuador</div>
						</td>
						<td width="102"><img src="css/image/logoBesixplus.jpg"
							alt="besixplus" width="102" height="45"
							longdesc="besixplus cia ltda"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
</body>
</html>
