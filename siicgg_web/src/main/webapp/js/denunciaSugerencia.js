function loadDenunciaSugerencia(){	
	var frmDenunciaSugerencia = document.getElementById("frmDenunciaSugerencia");
	var txtDsuge_denunciante = document.getElementById("txtDsuge_denunciante");
	var txtDsuge_denunciante_apellido = document.getElementById("txtDsuge_denunciante_apellido");
	var nunDsuge_cedula_pasaporte = document.getElementById("nunDsuge_cedula_pasaporte");
	var txtDsuge_contacto = document.getElementById("txtDsuge_contacto");
	var txtDsuge_descripcion = document.getElementById("txtDsuge_descripcion");
	var gbDsuge_tipo_denuncia = document.getElementById("gbDsuge_tipo_denuncia");
	var btnGuardarDenunciaSugerencia = document.getElementById("btnGuardarDenunciaSugerencia");
	
	var userObject;	
	var url = URL_WS+"SessionManager?request=userobject";
	new Ajax.Request(url, {
		method: 'get',
		asynchronous : false,
		onSuccess: function(transport) {
			userObject = eval("("+transport.responseText+")");
		},
		onFailure: function(transport) {
			alert(transport);
		}
	});
	var codigoPersona = userObject.CRPER_CODIGO;
	function CallBackCgg_web_contactos(r){
		var a = eval('('+r+')');			
		if(a.length>0){			
			var codigo;
			for(i=0;i<a.length;i++){					
				codigo = a[i].CRTCO_CODIGO;
				if(codigo =='CRTCO1'){											
					txtDsuge_contacto.value = a[i].CRPRC_CONTACTO;
					return;
				}
			}			
		}
	}	
	
	
	var param = new SOAPClientParameters();
	param.add('inCrper_codigo', codigoPersona);
	param.add('format', 'JSON');
	SOAPClient.invoke(URL_WS+"Cgg_res_persona_contacto", "selectPersonaContacto", param, false, CallBackCgg_web_contactos);
	nunDsuge_cedula_pasaporte.value=userObject.CRPER_NUM_DOC_IDENTIFIC;
	txtDsuge_denunciante.value = userObject.CRPER_NOMBRES;
	txtDsuge_denunciante_apellido.value = userObject.CRPER_APELLIDO_PATERNO + ' '+userObject.CRPER_APELLIDO_MATERNO;
	
	
	
	document.getElementById("btnLimpiarDenunciaSugerencia").onclick=function(){
		//frmDenunciaSugerencia.reset();
		txtDsuge_descripcion.value= '';
	};
	nunDsuge_cedula_pasaporte.onkeypress = function(){
		if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;
	}
	
	btnGuardarDenunciaSugerencia.onclick=function(){
		function CallBackCgg_atc_denuncia_sugerencia(v){
			if (v=="true"){
				new bsxMessageBox({
					title:"Denuncias/sugerencias",
					msg:'Informaci\u00F3n almacenada correctamente',
					icon:"iconInfo",
					close:function(){
						document.location = 'bienvenida.jsp?CWPAG_CODIGO=CWPAG1';
					}
				});	
				//frmDenunciaSugerencia.reset();
				
			}else{
				new bsxMessageBox({title:"Denuncias/sugerencias",msg:'Informaci\u00F3n no almacenada',icon:"iconError"});				
			}
		}
		
		var param = new SOAPClientParameters();			
		metodoRes_denuncia = 'insert';
		//////////////////
		param.add('inCusu_codigo',null);
		param.add('inCrden_anio',new Date().getFullYear());
		param.add('inCrden_numero', '0');
		param.add('inCrden_fecha_recepcion', new Date());
		param.add('inCrden_numero_doc_ident',nunDsuge_cedula_pasaporte.value);
		param.add('inCrden_nombres', txtDsuge_denunciante.value);
		param.add('inCrden_apellidos', txtDsuge_denunciante_apellido.value);
		param.add('inCrden_descripcion', txtDsuge_descripcion.value);
		param.add('inCrden_contacto',txtDsuge_contacto.value );
		param.add('inCrden_tipo', 1);		
		param.add('inCrden_denuncia', gbDsuge_tipo_denuncia.checked);
		param.add('inCrden_seguimiento', null);
		param.add('inCrden_estado_denuncia',0);	
		SOAPClient.invoke(URL_WS+"PublicWS/Cgg_atc_denuncia_sugerencia",metodoRes_denuncia,param, true, CallBackCgg_atc_denuncia_sugerencia);
	}
	
}
	