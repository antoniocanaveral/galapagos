function loadModulo(){	
	var userObject;
	var url = URL_WS+"PublicWS/Cgg_atc_gestion_empleo";
	/*new Ajax.Request(url, {
		method: 'get',
		asynchronous : false,
		onSuccess: function(transport) {
			userObject = eval("("+transport.responseText+")");
		},
		onFailure: function(transport) {
			alert(transport);
		}
	});
	var codigoUsuario=userObject.CUSU_CODIGO;*/
	var btnActivarCuenta = document.getElementById("btnActivarCuenta");
	var txtCarnetResidencia = document.getElementById("txtCarnetResidencia");
	btnActivarCuenta.onclick=function(){
		function CallBackActivarCuenta(v){			
			var srtResul = v;
			if (srtResul.length){		
				new bsxMessageBox({title:"Activar cuenta",
					msg:'Su cuenta esta activada para utilizar en Gesti&oacute;n de empleo',
					icon:"iconInfo",
					close:function(){top.location.reload();}
				});
				//frmDenunciaSugerencia.reset();				
			}else{
				new bsxMessageBox({title:"Activar cuenta",msg:v,icon:"iconError"});				
			}
		}
		var param = new SOAPClientParameters();			
		metodoRes_denuncia = 'insert';
		param.add('crperNumeroResidencia',txtCarnetResidencia.value);		
		SOAPClient.invoke(url,"activarUsuarioGestionEmpleo",param, true, CallBackActivarCuenta);
	}
}