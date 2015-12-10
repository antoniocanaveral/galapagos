function loadModulo(){	
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
	var codigoPersona = userObject.CRPER_CODIGO;
	var cedulaPersona = userObject.CRPER_NUM_DOC_IDENTIFIC;
	var txtCodigoCurso = $("txtCodigoCurso");
	var txtTipoResidente = $("txtTipoResidente");
	var swPreregistro = true;
	//alert(txtCodigoCurso.value);
	//alert(txtTipoResidente.value)
	//alert('codigo: '+codigoPersona+' cedula: '+cedulaPersona);
	
	
	
	var FrmListadoCurso = $("FrmListadoCurso");
	var frmPreRegistroCurso = $("frmPreRegistroCurso");
	var btnSalirCurso = $("btnSalirCurso");
	
	
	function CallBackSelectDatos(v){
		//alert(v);		
		return;
		var a = eval('('+v+')');
		if(a.length>0){			
			if (a[0].CODIGO=='04' && txtTipoResidente != 0){
				swPreregistro = false;
				alert('NO se puede inscribir al curso por ser residente temporal');
			}
		}
		
	}
	var param = new SOAPClientParameters();				
	param.add('inCrper_num_doc_identific',cedulaPersona);						
	param.add('format','JSON');		
	SOAPClient.invoke(URL_WS+"Cgg_dhu_asistente_curso","selectAsistenteResidente",param, true, CallBackSelectDatos);
	
	
	var btnBuscar = $("btnBuscar");
	
	
	var cbxSectorProductivo = new bsxComboBox({
		id:"cbxSectorProductivo",
		width:150,
		renderTo:"tdSectorProductivo",		
		displayField:"CSCTP_NOMBRE",
		valueField:"CSCTP_CODIGO",
		webService:{
			url:URL_WS+"Cgg_sector_productivo",
			method:"selectAll",
			params:[{name:"format",value:"JSON"}]
		}		
	});	
	cbxSectorProductivo.reload();
	
	$("tdNombrePersona").innerHTML = userObject.CRPER_NOMBRES + ' ' + userObject.CRPER_APELLIDO_PATERNO + ' ' + userObject.CRPER_APELLIDO_MATERNO
	$("tdCedulaIdentidad").innerHTML = userObject.CRPER_NUM_DOC_IDENTIFIC;
	
	
	
	$("btnGuardar").onclick = function(){
		if(swPreregistro == true){
			try{
				function CallBackCgg_dhu_asistente_curso(r){
					//alert(r);
					if(r == "true"){
						alert("La informaci\u00F3n a sido almacenada correctamente");
						frmPreRegistroCurso.reset();						
					}else{
						alert("La informaci\u00F3n no se pudo almacenar");
					}
					document.location = 'listadoCurso.jsp';
				}
				var param = new SOAPClientParameters();
				param.add('inCrper_codigo',codigoPersona);
				param.add('inCdcur_codigo',txtCodigoCurso.value);
				param.add('inCsctp_codigo',cbxSectorProductivo.dom.value);
				param.add('inCusu_codigo',codigoUsuario);
				param.add('inCdasc_actividad_realizada',txtActividad.value);
				param.add('inCdasc_nota_final',null);
				param.add('inCdasc_numero_certificado',null);
				param.add('inCdasc_fecha_emision_certificado',null);
				param.add('inCdasc_estado_inscripcion',0);////
				param.add('inCdasc_aprobado',3);
				SOAPClient.invoke(URL_WS+"Cgg_dhu_asistente_curso",'insert',param, true, CallBackCgg_dhu_asistente_curso);
			}catch(inErr){
				alert(inErr);
			}
		}
	}
	
	function btnSalirAll(frm){
		divBgModal.style.display="none";
		frm.style.display="none";			
	}
	function showForm(frm){
		document.getElementById("divBgModal").style.display="block";
		frm.style.display="block";	
	}
}
	