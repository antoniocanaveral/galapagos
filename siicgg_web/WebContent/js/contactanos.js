function loadContactanos(){		
	var codigoModulo = $("txtCodigoModulo").value;
	
	/**
     * Componentes del FrmCambiarContrasenia
     */
	 
	var txtUsuario = document.getElementById("txtUsuario");
		
	var tdAgencia = document.getElementById("tdAgencia");
	var tdDescripcionAgencia = document.getElementById("tdDescripcionAgencia");
	var tdEncargado = document.getElementById("tdEncargado");
	var tdDireccion = document.getElementById("tdDireccion");
	var tdTelefono = document.getElementById("tdTelefono");
	var tdEmail = document.getElementById("tdEmail");
	var tdFax = document.getElementById("tdFax");
	var divContactos = document.getElementById("divContactos");
	
	
	
	function CallBackCgg_web_agencias(r){		
		var a = eval('('+r+')');		
		if(a.length>0){			
			for(i=0;i<a.length;i++){
				fnContactos(a[i].CWAGE_CODIGO);
			}
		}else{
			divContactos.innerHTML +="";
			setHeightForm();
		}		
	}	
	var param = new SOAPClientParameters();
	param.add('inCwmod_codigo', codigoModulo);
	param.add('format', 'JSON');
	SOAPClient.invoke(URL_WS+"PublicWS/Cgg_web_agencia", "selectAgenciasCGG_WEB_MODULO", param, true, CallBackCgg_web_agencias);
	
	var wsTmp=true;
	function fnContactos(codigoAgencia){
		function CallBackCgg_web_contactos(r){
			if (wsTmp){
				divContactos.innerHTML='';
				wsTmp=false;
			}			
				
			var a = eval('('+r+')');
			//alert(r);
			var codigoDivContactos = '';
			var txtTelefono = '<ul>';
			var txtEmail = '<ul>';
			var txtDireccion = '<ul>';
			var txtFax = '<ul>';
			if(a.length>0){
				codigoDivContactos = '<table class="cssForularioInterno" border=0 width="97%">'+
                '<tr><th width="100">Oficina:</th><td width = "275">'+a[0].CWAGE_NOMBRE+' ( '+a[0].CWAGE_DESCRIPCION+' )</td></tr>'+								
				'<tr><th>Encargado:</th><td>'+a[0].CWAGE_ENCARGADO+'</td></tr>';
				for(i=0;i<a.length;i++){				
					var codigo = a[i].CRTCO_CODIGO;
					if(codigo =='CRTCO1'){					
						txtEmail += '<li>'+a[i].CWCAG_CONTACTO + '</li>';
					}
					if(codigo =='CRTCO2'){
						txtTelefono += '<li>' + a[i].CWCAG_CONTACTO + '</li>'
					}
					if(codigo =='CRTCO3'){
						txtDireccion += '<li>'+a[i].CWCAG_CONTACTO + '</li>';
					}
					if(codigo =='CRTCO4'){
						txtFax += '<li>'+a[i].CWCAG_CONTACTO + '</li>';
					}
				}
				txtEmail += '</ul>';
				txtTelefono += '</ul>';
				txtDireccion += '</ul>';
				txtFax += '</ul>';
				codigoDivContactos += '<tr><th>Direcci&oacute;n:</th><td>'+txtDireccion+'</td></tr>'+
				'<tr><th>Telefono:</th><td>'+txtTelefono+'</td></tr>'+
				'<tr><th>E-mail:</th><td>'+txtEmail+'</td></tr>'+
				'<tr><th>Fax:</th><td>'+txtFax+'</td></tr>'+
				'<tr><td colspan=2><div style="border-bottom:1px dashed #E2BD7E">&nbsp;</div> </td></tr></table> </br>';
				
			}
			divContactos.innerHTML += codigoDivContactos;
			setHeightForm();
		}	
			
		var param = new SOAPClientParameters();
		param.add('inCwage_codigo', codigoAgencia);
		param.add('format', 'JSON');
		SOAPClient.invoke(URL_WS+"PublicWS/Cgg_web_agencia", "selectContactosByAgencia", param, true, CallBackCgg_web_contactos);
	}
	
	
}
	