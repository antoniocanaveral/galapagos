<%@ page import="com.besixplus.sii.util.Env" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Inicio</title>
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<%out.println(Env.loadExternalScripts("siicgg_web/javascripts.properties"));%>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/inicio.js"></script>

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
<body onLoad="loadInicio();inicio();">
<input type="hidden" id="txtUsuario"
	value=<% try{ out.println(request.getUserPrincipal().getName()); }catch(Exception ex){ out.println(false); } %> /></input>
<input type="hidden" id="txtCodigoPagina"
	value=<% out.println(request.getParameter("CWPAG_CODIGO"));%> />
<div class="tituloPrincipal" id="divTituloPrincipal"></div>
<div class="descripcionPrincipal" id="divDescripcionPrincipal"></div>
<div id="divBgModal" class="bgtransparent"
	style="width: 100%; height: 100%"></div>
<br>
<br>
<div style="padding-top: 10px; height: 100%;">
<table width="680" border=0 cellpadding=0 cellspacing=0>
	<tr>
		<td width="432" id="tdContenido"></td>
	</tr>
</table>
</div>
<!--<script type="text/javascript">
		
		var segundos = 3
		var dire = "css/image/" 

		var imagenes=new Array()
		imagenes[0]="node.png"
		imagenes[1]="user.png"
		imagenes[2]="mapa.gif"
		imagenes[3]="user.png"

		if(dire != "" && dire.charAt(dire.length-1) != "/")
		{dire = dire + "/"}

		var preImagenes = new Array();
		var test = document.getElementById("foto");
		if (test) 
			
			for (pre = 0; pre < imagenes.length; pre++){
				preImagenes[pre] = new Image()
				preImagenes[pre].src = dire + imagenes[pre]
			}
		
		cont=0
		function presImagen(){
			document.foto.src= dire + imagenes[cont]
			subeOpacidad()
			if (cont < imagenes.length-1)
				{cont ++}
			else
				{cont=0}
			tiempo=window.setTimeout('bajaOpacidad()',segundos*1000)
		}
		var iex = navigator.appName=="Microsoft Internet Explorer" ? true : false;
		var fi = iex?'filters.alpha.opacity':'style.MozOpacity'
		var opa = iex ? 100 : 1;
		function bajaOpacidad(){
			eval(opa)
			if(opa >= 0){
				cambia()
				opa -= iex?10:0.1;
				setTimeout('bajaOpacidad()',20)
			}
			else{presImagen()}
		}

		function subeOpacidad(){
			opaci = iex?100:1;
			if(opa <= opaci){
				cambia()
				opa += iex?10: 0.1;
				setTimeout('subeOpacidad()',20)
			}
		}
		function cambia(){
			eval('document.foto.' + fi + ' = opa')
		}
		var tiempo
		function inicio(){
			var test = document.getElementById("foto");
			if (!test) 
				return;
			clearTimeout(tiempo)
			bajaOpacidad()
		}

		</script>-->
</body>
</html>