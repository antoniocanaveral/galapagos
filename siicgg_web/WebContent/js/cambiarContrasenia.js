function loadCambiarContrasenia(){	
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
	var codigoUsuario = userObject.CUSU_CODIGO;
	var codigoPersona = userObject.CRPER_CODIGO;
	
	/**
     * Componentes del FrmCambiarContrasenia
     */
	 
	var txtUsuario = document.getElementById("txtUsuario");
	
	var FrmCambiarContrasenia = document.getElementById("FrmCambiarContrasenia");
	var txtCusu_nombre_usuarioAC = document.getElementById("txtCusu_nombre_usuarioAC");
	txtCusu_nombre_usuarioAC.value= txtUsuario.value;
	txtCusu_nombre_usuarioAC.readOnly = true;
	var txtCusu_clave_accesoAC = document.getElementById("txtCusu_clave_accesoAC");
	var txtConfirmarClaveAC = document.getElementById("txtConfirmarClaveAC");
	var btnCusu_Guardar = document.getElementById("btnCusu_Guardar");
	var btnCusu_Cancelar = document.getElementById("btnCusu_Cancelar");
	var txtCusu_clave_actual = document.getElementById("txtCusu_clave_actual");
	
	btnCusu_Guardar.onclick = function(){
	
		function CallBackCgg_usuario(v){			
			if (v=="true"){	
				new bsxMessageBox({title:"Cambiar contrase&ntilde;a",
					msg:'su contrase&ntilde;a ha sido cambiada',
					icon:"iconInfo",
					close:function(){top.window.location="PrivateWS/SessionWeb?request=logout";}
				});				
			}else{
				new bsxMessageBox({title:"Cambiar contrase&ntilde;a",msg:"Las contrase&ntilde no coinciden",icon:"iconError"});				
			}
		}
		//selectPersonaContacto
		var jsonContactos = '[]';
		function CallBackCgg_web_contactos(r){					
			var a = eval('('+r+')');			
			if(a.length>0){
				jsonContactos = '[';	
				var codigo;
				for(i=0;i<a.length;i++){					
					codigo = a[i].CRTCO_CODIGO;
					if(codigo =='CRTCO1'){											
						jsonContactos += ((i>1)?',':'')+'{"email":"'+a[i].CRPRC_CONTACTO+'"}';
					}					
				}
				jsonContactos += ']';
				//alert(jsonContactos);
			}
		}	
		
		
		var param = new SOAPClientParameters();
		param.add('inCrper_codigo', codigoPersona);
		param.add('format', 'JSON');
		SOAPClient.invoke(URL_WS+"Cgg_res_persona_contacto", "selectPersonaContacto", param, false, CallBackCgg_web_contactos);
		
		if(!(txtCusu_clave_accesoAC.value == txtConfirmarClaveAC.value)){
			new bsxMessageBox({title:"Cambiar contrase&ntilde;a",msg:"Las contrase&ntilde;as no coinciden",icon:"iconError"});				
			return;
		}
		if(txtCusu_clave_actual.value.length==0)return;
		
		var param = new SOAPClientParameters();
		param.add('inCusu_codigo', codigoUsuario);
		param.add('inCusu_clave_acceso_anterior', txtCusu_clave_actual.value);
		param.add('inCusu_clave_acceso', txtCusu_clave_accesoAC.value);
		param.add('inCusu_cambiar_clave', false);
		param.add('inNotificaciones', jsonContactos);
		SOAPClient.invoke(URL_WS+"Cgg_usuario", 'updateClave', param, true, CallBackCgg_usuario);
	}
	
}
	