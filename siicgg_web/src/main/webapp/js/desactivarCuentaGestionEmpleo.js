function loadDesactivarCuentaGestionEmpleo(){

	
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
	var codigoUsuario=userObject.CUSU_CODIGO;	
	//alert(codigoUsuario);
	var txtContrasenia = document.getElementById("txtContrasenia");

	var btnAceptarDesactivarCuenta = document.getElementById("btnAceptarDesactivarCuenta");
	
	btnAceptarDesactivarCuenta.onclick = function(){
		if (txtContrasenia.value.length>0){
			//if (txtContrasenia.value == txtVerificar.value){
				function CallBackVerificarClave(v){
					//alert(v);
					if(v == 'true'){
						function CallBackDeleteUsuario(r){	
							//alert(r);
							if(r == 'true'){
								new bsxMessageBox({
									title:"Gestion de Empleo",
									msg:"La cuenta ha sido desactivada",
									icon:"iconInfo",
									close:function(){top.window.location="PrivateWS/SessionWeb?request=logout";}
								});
							}else{
								new bsxMessageBox({
									title:"Gestion de Empleo",
									msg:"La cuenta no ha podido ser desactivada",
									icon:"iconError"
								});
							}
							btnSalirAll(FrmConfirmarDesactivarCuenta);
						}
						var param = new SOAPClientParameters();				
						param.add('inCusu_codigo',codigoUsuario);						
						//param.add('inCusu_clave_acceso',txtContrasenia.value);		
						SOAPClient.invoke(URL_WS+"Cgg_sec_usuario_rol","deleteByUsuarioRolAplicante",param, true, CallBackDeleteUsuario);
					}else{
						new bsxMessageBox({
							title:"Contraseña",
							msg:"La contraseña es incorrecta",
							icon:"iconError"
						});
					}
				}
				var param = new SOAPClientParameters();				
				param.add('inCusu_codigo',codigoUsuario);						
				param.add('inCusu_clave_acceso',txtContrasenia.value);		
				SOAPClient.invoke(URL_WS+"Cgg_usuario","verificarContraseniaByUsuario",param, true, CallBackVerificarClave);
/*			}else{
				alert('Las contraseñas no coinciden');
			}*/
		}else{
			alert('Ingrese contraseña');
		}
	}
}
	
	