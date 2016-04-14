<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Bienvenida</title>
<link rel="stylesheet" type="text/css" href="css/bsxTabla.css" />
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript" src="js/SoapClient.js"></script>
<script type="text/javascript" src="js/bsxTable.js"></script>
<script type="text/javascript" src="js/bsxComboBox.js"></script>
<script type="text/javascript" src="js/cgg_gem_subscripcion_oferta.js"></script>
<script type="text/javascript">
		function setHeightForm(){
			loadModulo();
			try{
				parent.document.getElementById('iFrameBody').height =0;			
				parent.document.getElementById('iFrameBody').height = document["body"].offsetHeightForm+40;
			}catch(e){				
			}			
		}	
	</script>
</head>
<body onload="setHeightForm();">
<input type="hidden" id="txtUsuario"
	value=<% 
		try{
			out.println(request.getUserPrincipal().getName());
		}catch(Exception ex){
			out.println(false);
		}
	%> />

<div class="tituloPrincipal" style="float: left; padding-top: 8px">Subscripci&oacute;n
a ofertas de empleo</div>
<br>
<br>
<table border=1 cellspacing=0 width="100%">
	<tr>
		<div id="trGrdAreaCargos2"></div>
	</tr>
	<tr id="combo">
	</tr>
</table>
<div id="divCbxUno"></div>

</body>
</html>