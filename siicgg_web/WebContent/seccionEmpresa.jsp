<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>Detalle de la oferta</title>
<link rel="stylesheet" type="text/css" href="css/modulo.css" />
<script type="text/javascript" src="js/config.js"></script>
<script type="text/javascript">
		function setHeightForm(){		
			try{
				parent.document.getElementById('iFrameBody').height =0;			
				parent.document.getElementById('iFrameBody').height = document["body"].offsetHeightForm+40;
			}catch(e){				
			}			
		}	
	</script>

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

<div class="tituloPrincipal">Secci&oacute;n de Empresas</div>


<br>
<br>
<div id="divAviso" style="width: 440; margin: auto auto;"
	class="divAviso">Si desea acceder al sistema como Empresa, por
favor acceda mediante el panel</div>

</body>
</html>