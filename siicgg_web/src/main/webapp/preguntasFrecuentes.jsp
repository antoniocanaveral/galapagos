<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Preguntas Frecuentes</title>
<link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css" />
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css" />
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/bsxTable.js"></script>
<script type="text/javascript" src="js/bsxMessageBox.js"></script>
<script type="text/javascript" src="js/preguntasFrecuentes.js"></script>
<style type="text/css">
<!--
.Visible {
	display: block;
}

.Invisible {
	display: none;
}

.Estilo1 {
	font-size: 30px;
	font-family: Arial, Helvetica, sans-serif;
}

.Estilo5 {
	font-size: 50px
}

.Estilo6 {
	color: #003366;
	font-weight: bold;
}
-->
</style>
</head>
<body onLoad="loadPreguntasFrecuentes();">
<input type="hidden" id="txtCodigoModulo"
	value=<% out.println(request.getParameter("CWMOD_CODIGO"));%> />
<input type="hidden" id="txtUsuario"
	value=<% try{ out.println(request.getUserPrincipal().getName()); }catch(Exception ex){ out.println(false); } %> /></input>

<div class="tituloPrincipal">Preguntas Frecuentes</div>
<div class="tituloSecundario">Envianos tu pregunta o alguna
inquietud que tengas para que podamos atenderte.</div>

<div id="divBgModal" class="bgtransparent"
	style="width: 100%; height: 100%"></div>

<br />
<table width="690" border=0 cellpadding=0 cellspacing=0
	style="font-size: 11px">
	<tr>
		<td>
		<div id="FrmListadoPreguntas">
		<table width="689" border="0" style="font-size: 11px">
			<tr>
				<td width="103">Ingresa tu pregunta:</td>
				<td width="576"><input name="txtPregunta" type="text"
					id="txtPregunta" style="width: 400" />
				<button id="btnEnviar">Enviar</button>
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<div id="divListadoPreguntas"></div>
				<!--
									<fieldset style="font-size:11px">
                                        <legend><b>Listado de Preguntas
                                            </b>
                                        </legend>
                                        <table class="tabla" height="170" style="font-size:11px" width="100%" border="0" cellspacing="0" id='tblPregunta'>
                                            <tbody style="width:100%;height:100%;overflow:auto;display:block;"></tbody>
                                        </table>
                                    </fieldset>
									--></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</table>
		</div>
		</td>
	</tr>
</table>
</body>
</html>