function loadInicio(){	
	var divTituloPrincipal = document.getElementById("divTituloPrincipal");
	var divDescripcionPrincipal = document.getElementById("divDescripcionPrincipal");
	var tdContenido = document.getElementById("tdContenido");
	var codigoPagina = document.getElementById("txtCodigoPagina").value;
	function CallBackSelectCgg_web_pagina(v){
		var a = eval('('+v+')');
		if(a.length>0){					
			divTituloPrincipal.innerHTML = a[0].CWPAG_NOMBRE;
			divDescripcionPrincipal.innerHTML = a[0].CWPAG_TITULO;
			tdContenido.innerHTML = a[0].CWPAG_DESCRIPCION;
			
		}	
		setHeightForm();
	}
	var param = new SOAPClientParameters();				
	param.add('inCwpag_codigo',codigoPagina);						
	param.add('format','JSON');		
	SOAPClient.invoke(URL_WS+"Cgg_web_pagina","select",param, true, CallBackSelectCgg_web_pagina);
	
	setHeightForm();
}
	