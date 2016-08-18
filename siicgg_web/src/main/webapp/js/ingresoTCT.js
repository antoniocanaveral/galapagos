
	  jQuery.noConflict();
	  jQuery(document).ready(function() {
		  jQuery("#chkDatosConyuge").click(function(){
		        if (jQuery(this).is(":checked"))
		        {
		        	jQuery("#divConyuge").show();
		            //setHeightForm();
		            //alert('sii')
		        }
		        else{
		        	jQuery("#divConyuge").hide();}
		        setHeightForm();
		    });
		  
	  });   
	  var valorCalificacion1 = '';
	  var valorCalificacion2 = '';
	  var valorCalificacion3 = '';
	  var valorCalificacion4 = '';
	  var valorCalificacion5 = '';
	  var valorCalificacion6 = '';
	  var valorCalificacion7 = '';
	  var valorCalificacion8 = '';
	  var valorCalificacion9 = '';
	  var valorCalificacion10 = '';
	  var valorCalificacion11 = '';
	  var valorCalificacion12 = '';
	  var valorCalificacion13 = '';
	  
	  function colcarValorCal(tipo,valor){
		  
		  switch (tipo) {
		  case '1':
		    valorCalificacion1 = valor;
		    break;
		  case '2': 
		    valorCalificacion2 = valor;
		    break;
		  case '3': 
			valorCalificacion3 = valor;
		    break; 
		  case '4':
			valorCalificacion4 = valor;
		    break;
		  case '5':
			valorCalificacion5 = valor;
			break;
		  case '6':
			valorCalificacion6 = valor;
			break;
		  case '7':
			valorCalificacion7 = valor;
			break;
		  case '8':
			valorCalificacion8 = valor;
			break;
		  case '9':
			valorCalificacion9 = valor;
			break;
		  case '10':
			valorCalificacion10 = valor;
			break;
		  case '11':
			valorCalificacion11 = valor;
		    break;
		  case '12':
			valorCalificacion12 = valor;
			break;
		  case '13':
			valorCalificacion13 = valor;
			break;
		 }
	}
	  
	  //Acepta solo numeros 
	  function aceptarNumeros(e, field) {
			key = e.keyCode ? e.keyCode : e.which;
			if (key == 8 || key == 46)
				return true;
			
			if (key > 47 && key < 58) {
				return true;
			}
			return false;
		}
	  
function loadIngresoTCT(){		

	function showForm(frm){
		$("divBgModal").style.display="block";
		frm.style.display="block";	
	}
	function btnSalirAll(frm){
		$("divBgModal").style.display="none";
		frm.style.display="none";					
	}
	var tmpObjReglasValidacion = null;
	var cbxAerolinea = $("cbxAerolinea");
	var dtFechaIngreso = $("dtFechaIngreso");
	var dtFechaSalida = $("dtFechaSalida");
	var tblActividad = $("tblActividad");
	var tblHospedaje = $("tblHospedaje");
	var btnAgregar = $("btnAgregar");
	var btnEliminar = $("btnEliminar");
	var txtFechaNacimiento = $("txtFechaNacimiento");
	var btnAceptarIngreso = $("btnAceptarIngreso");
	var btnSalirIngreso = $("btnSalirIngreso");	
	var txtNumeroDocumento = $("txtNumeroDocumento"); 
	var txtNombrePersona = $("txtNombrePersona");
	var txtApellidoPersona = $("txtApellidoPersona");
	var cbmGenero = $("cbmGenero");	
	var txtTipo = $("txtTipo");
	var txtNumeroAut = $("txtNumeroAut");
	var frmPersona = $("frmPersona");
	var btnGuardarTTC = $("btnGuardarTTC");
	var txtCodigoPersona = $("txtCodigoPersona");
	var txtCodigoTramite = $("txtCodigoTramite");
	var frmPersonaRegistro = $("frmPersonaRegistro");
	var txtCodigoEspecie = $("txtCodigoEspecie");
	var btnEditar = $("btnEditar");
	var tblPersona = $("tblPersona");
	var filaTablaPersona = '';
	var posicion = -1;
	var posicionEdit = -1;
	var swEdit = false;
	var swValido = false;
	var tmpCarpt_codigo_origen=null;
	var tmpCusu_nombre;
	var flagValido = true;
	var mensaje;
	dtFechaIngreso.value = Date.today().toString("dd/MM/yyyy");
    dtFechaSalida.value = Date.today().toString("dd/MM/yyyy");
    jQuery("#divNombreHospedaje").show();
	jQuery("#divNombreHospedajeIsla").hide();
	jQuery("#divLugarHospedaje").hide();
    jQuery("#labelHospedaje").html("* Nombre del sitio de hospedaje");
    jQuery('#cbxNombreHospedaje').html('');
	jQuery('#cbxNombreHospedaje').append("<option value='0'>Seleccione un item</option>");
	jQuery("#txtNroVuelo").val('');
	jQuery("#txtNumeroMiembros").val('');
	jQuery("#txtCual").val('');
	//jQuery("input:radio[checked=false]");
	jQuery("input[type=radio]").attr('checked', false);
	
	
	valorCalificacion1 = '';
	valorCalificacion2 = '';
	valorCalificacion3 = '';
	valorCalificacion4 = '';
	valorCalificacion5 = '';
	valorCalificacion6 = '';
	valorCalificacion7 = '';
	valorCalificacion8 = '';
	valorCalificacion9 = '';
	valorCalificacion10 = '';
	valorCalificacion11 = '';
	valorCalificacion12 = '';
	valorCalificacion13 = '';
	  
	btnSalirIngreso.onclick = function(){
		btnSalirAll($("FrmIngresoPersona"));
	}
	btnEditar.onclick = function(){
		if (filaTablaPersona){
			if(posicion>0){
				txtNumeroDocumento.readOnly = true;
				cbxTipoDocumento.dom.value = tblPersona.rows[posicion].cells[0].id;
				cbxNacionalidad.dom.value = tblPersona.rows[posicion].cells[5].id;
				txtNombrePersona.value = tblPersona.rows[posicion].cells[2].innerHTML;
				txtApellidoPersona.value = tblPersona.rows[posicion].cells[3].innerHTML;
				txtNumeroDocumento.value = tblPersona.rows[posicion].cells[1].innerHTML;
				txtFechaNacimiento.value = tblPersona.rows[posicion].cells[6].innerHTML;
				cbmGenero.value = tblPersona.rows[posicion].cells[4].id;
				cbxPaisResidencia.dom.value = tblPersona.rows[posicion].cells[11].id;
				txtCodigoPersona.value = tblPersona.rows[posicion].cells[2].id;
				txtCodigoTramite.value = tblPersona.rows[posicion].cells[12].id;
				txtCodigoEspecie.value = tblPersona.rows[posicion].cells[7].id;				
				swEdit = true;
				btnAceptarIngreso.visibled=false;
				showForm(FrmIngresoPersona);			
			}
		}
	}
	function fnVerificarDatos(){		
		jQuery('.form-line-error').removeClass("form-line-error");
        var isComplete =  true;
        if(jQuery("#cbxCategoria").val()==0)
        {
        	jQuery('#cbxCategoria').addClass("form-line-error");
            isComplete = false;
        }
        if(jQuery("#cbxTipoRegistro").val()==0)
        {
        	jQuery('#cbxTipoRegistro').addClass("form-line-error");
            isComplete = false;
        }

       if(jQuery("#cbxAerolineaAux").val()==0)
        {
        	jQuery('#cbxAerolineaAux').addClass("form-line-error");
            isComplete = false;
        }
        if(jQuery("#cbxOrigenAux").val()==0)
        {
        	jQuery('#cbxOrigenAux').addClass("form-line-error");
            isComplete = false;
        }
        if(jQuery("#cbxDestinoAux").val()==0)
        {
        	jQuery('#cbxDestinoAux').addClass("form-line-error");
            isComplete = false;
        }
        if(jQuery("#cbxTipoHospedaje").val()==0)
        {
        	jQuery('#cbxTipoHospedaje').addClass("form-line-error");
            isComplete = false;
        }else{
        	if(jQuery("#cbxTipoHospedaje").val()==102){
        		if(jQuery("#cbxNombreHospedaje").val()==0){
        			jQuery('#cbxNombreHospedaje').addClass("form-line-error");
                    isComplete = false;
        		}    
        	}else if(jQuery("#cbxTipoHospedaje").val()==104){
        		if(jQuery("#cbxNombreHospedajeIsla").val()==0){
        			jQuery('#cbxNombreHospedajeIsla').addClass("form-line-error");
                    isComplete = false;
        		}  
        		if(jQuery("#cbxIslaHospedaje").val()==0){
        			jQuery('#cbxIslaHospedaje').addClass("form-line-error");
                    isComplete = false;
        		} 
        		
        	}else if(jQuery("#cbxTipoHospedaje").val()==103){
        		if(jQuery("#divLugarHospedaje").val().trim()==''){
        			jQuery('#divLugarHospedaje').addClass("form-line-error");
                    isComplete = false;
        		}  
        		if(jQuery("#cbxIslaHospedaje").val()==0){
        			jQuery('#cbxIslaHospedaje').addClass("form-line-error");
                    isComplete = false;
        		} 
        	}
        	
        	
        }
        if(jQuery("#cbxInformacionViaje1Aux").val()==0)
        {
        	jQuery('#cbxInformacionViaje1Aux').addClass("form-line-error");
            isComplete = false;
        }
        if(jQuery("#cbxInformacionViaje2Aux").val()==0)
        {
        	jQuery('#cbxInformacionViaje2Aux').addClass("form-line-error");
            isComplete = false;
        }
        if(jQuery("#cbxInformacionViaje3Aux").val()==0)
        {
        	jQuery('#cbxInformacionViaje3Aux').addClass("form-line-error");
            isComplete = false;
        }
        if(jQuery("#cbxInformacionViaje4Aux").val()==0)
        {
        	jQuery('#cbxInformacionViaje4Aux').addClass("form-line-error");
            isComplete = false;
        }
        
        if(jQuery("#txtNroVuelo").val().trim()=='')
        {
        	jQuery('#txtNroVuelo').addClass("form-line-error");
            isComplete = false;
        }
        
        if(jQuery("#txtNumeroMiembros").val().trim()=='')
        {
        	jQuery('#txtNumeroMiembros').addClass("form-line-error");
            isComplete = false;
        }
        
        if(jQuery("#txtCual").val().trim()=='')
        {
        	jQuery('#txtCual').addClass("form-line-error");
            isComplete = false;
        }
        
        if(valorCalificacion1==''){
        	 jQuery('#vidaMarina').addClass("form-line-error");
        	 isComplete = false;
        }
        
        if(valorCalificacion2==''){
       	 jQuery('#solyplaya').addClass("form-line-error");
       	 isComplete = false;
       }
        
        if(valorCalificacion3==''){
       	 jQuery('#vidaterrestre').addClass("form-line-error");
       	 isComplete = false;
       }
        
        if(valorCalificacion4==''){
       	 jQuery('#paisaje').addClass("form-line-error");
       	 isComplete = false;
       }
        
        if(valorCalificacion5==''){
       	 jQuery('#crucero').addClass("form-line-error");
       	 isComplete = false;
       }
        
        if(valorCalificacion6==''){
       	 jQuery('#buceo').addClass("form-line-error");
       	 isComplete = false;
       }
        
        if(valorCalificacion7==''){
       	 jQuery('#snorkel').addClass("form-line-error");
       	 isComplete = false;
       }
        
        if(valorCalificacion8==''){
       	 jQuery('#kayak').addClass("form-line-error");
       	 isComplete = false;
       }
        
        if(valorCalificacion9==''){
       	 jQuery('#surf').addClass("form-line-error");
       	 isComplete = false;
       }
        
        if(valorCalificacion10==''){
       	 jQuery('#senderisimo').addClass("form-line-error");
       	 isComplete = false;
       }
        
        if(valorCalificacion11==''){
          	 jQuery('#observacion').addClass("form-line-error");
          	 isComplete = false;
          }
        
        if(valorCalificacion12==''){
          	 jQuery('#fotografia').addClass("form-line-error");
          	 isComplete = false;
          }
        
        if(valorCalificacion13==''){
          	 jQuery('#persa').addClass("form-line-error");
          	 isComplete = false;
          }
		
        if(isComplete ==false){
        	new bsxMessageBox({
        		title:'Alerta',
                msg: 'Por favor verifique que todos los datos del formulario hayan sido ingresados correctamente.',
                icon: "iconInfo"
			});	
        	return false;
        	
        }else{
        	if((jQuery("#cbxInformacionViaje1Aux").val()==16) || (jQuery("#cbxInformacionViaje1Aux").val()==15)){
	        	 if((jQuery("#txtNumeroMiembros").val().trim()=='0') || (jQuery("#txtNumeroMiembros").val().trim()=='1')){
	             	jQuery('#txtNumeroMiembros').addClass("form-line-error");
	            			new bsxMessageBox({
	            				title:"Error de Ingreso",
	            				msg:'El n&uacute;mero de miembros debe ser mayor a 1',
	            				icon:"iconError"
	            			});			
	            	 return false;
	             }
        	}
        	
        	var arrFecha =dtFechaIngreso.value.split('/');
    		var dateIngreso= new Date (arrFecha[2],arrFecha[1],arrFecha[0]);
    		var arrFecha =dtFechaSalida.value.split('/');
    		var dateSalida= new Date (arrFecha[2],arrFecha[1],arrFecha[0]);
        	if(dateSalida<dateIngreso){
    			new bsxMessageBox({
    				title:"Error de Ingreso",
    				msg:'La fecha de salida debe ser mayor o igual a la fecha de ingreso',
    				icon:"iconError"
    			});		
    			return false;
        	}
        	
        }
		return isComplete;
	}
	
	btnAgregar.onclick = function(){
		frmPersona.reset();
		txtNumeroDocumento.readOnly = false;
		swEdit = false;
		showForm($("FrmIngresoPersona"));
		fnHabilitarControles(true);
		btnAceptarIngreso.disabled = true;
	}
	btnEliminar.onclick = function(){
		if(filaTablaPersona){
			var tbodyPersona = tblPersona.tBodies[0];	
			tbodyPersona.removeChild(filaTablaPersona);
			filaTablaPersona='';
		}
	}
	var objIngreso = new JsDatePick({
        useMode:2,
        target:"dtFechaIngreso",
        dateFormat:"%d/%m/%Y",
        imgPath:"../css/image/jsdatepicker/"
		//limitToToday:true
    });
	var objSalida =new JsDatePick({
        useMode:2,
        target:"dtFechaSalida",
        dateFormat:"%d/%m/%Y",
        imgPath:"..images/jsdatepicker/"
		//limitToToday:true
    });
	new JsDatePick({
        useMode:2,
        target:"txtFechaNacimiento",
        dateFormat:"%d/%m/%Y",
        imgPath:"..images/jsdatepicker/"
		//limitToToday:true
    });
	
	btnAceptarIngreso.onclick = function(){	
		btnAceptarIngreso.disabled=true;	
		if(cbxTipoDocumento.dom.value == 1){
			if (validarCedula(txtNumeroDocumento.value) == false){
				new bsxMessageBox({
					title:"N\u00famero de c\u00E9dula inv\u00E1lido",
					msg:'En n\u00famero ingresado es inv\u00E1lido, por favor ingrese un n\u00f1mero v\u00E1lido para continuar',
					icon:"iconError"
				});
				return;
			}
		}
		var swVerificado = false;
		if(trim(txtNumeroDocumento.value)==0){				
			txtNumeroDocumento.focus();
			swVerificado=false;
		}else if(trim(txtNombrePersona.value)==0){				
			txtNombrePersona.focus();
			swVerificado=false;
		}else if(trim(txtApellidoPersona.value)==0){				
			txtApellidoPersona.focus();
			swVerificado=false;
		}else if(txtFechaNacimiento.value.length==0){
			txtFechaNacimiento.focus();
			swVerificado = false;
		}else{
			swVerificado = true;
		}		
		if (swVerificado == true && flagValido == true){
			fnLlenarPersona();
		}else{
			new bsxMessageBox({
				title:"Error validaci\u00f3n",
				msg:'<span>No se puede realizar el registro de la persona.!!</span>'+mensaje,
				icon:"iconError"
			});	
		}
	}
	$("btnVerificar").onclick=function(){
		if (cbxTipoDocumento.dom.value == 1 && validarCedula(txtNumeroDocumento.value) == false){
			
			new bsxMessageBox({
				title:"N\u00famero de documento inv\u00E1lido",
				msg:'El n\u00famero de documento es inv\u00E1lido, por favor intente nuevamente con un n\u00famero de documento v\u00E1lido',
				icon:"iconError",
				close:function(){
					txtNumeroDocumento.focus();
				}
			});
			txtNombrePersona.value = '';			
			txtApellidoPersona.value = '';
			txtFechaNacimiento.value = '';			
			return;
		}
		consultarPersona();	
	}
	
	txtNumeroDocumento.onkeypress = function (event){
		fnHabilitarControles(true);
		fnLimpiarControles();	
        if (event.which == '13') {
            if (cbxTipoDocumento.dom.value == 1 && validarCedula(txtNumeroDocumento.value) == false){			
				
				new bsxMessageBox({
					title:"N\u00famero de documento inv\u00E1lido",
					msg:'El n\u00famero de documento es inv\u00E1lido, por favor intente nuevamente con un n\u00famero de documento v\u00E1lido',
					icon:"iconError",
					close:function(){
						txtNumeroDocumento.focus();
					}
				});
					
				return;
			}
			consultarPersona();		
        }
    }
	function fnLimpiarControles(){
		txtNombrePersona.value = '';			
		txtApellidoPersona.value = '';
		txtFechaNacimiento.value = '';	
	}
	txtNumeroDocumento.onchange = function (){			                    
		fnLimpiarControles();		
    }	
	
	btnGuardarTTC.onclick = function(){
		btnGuardarTTC.disabled=false;
		if (fnVerificarDatos()==true){			
			if(tblPersona.rows.length<=1){
				new bsxMessageBox({
					title:"Pre-registro TCT",
					msg:"Para enviar la informaci\u00f3n por favor a\u00f1ada por lo menos una persona.",
					icon:"iconError"
				});	
				btnGuardarTTC.disabled=false;
				return
			}
				
			var jsonPersona = '[';
			var i=0;
			var textos='';
			for (var i=1;i<tblPersona.rows.length;i++) {
				var genero = '0';
				if (tblPersona.rows[i].cells[4].innerHTML == 'M'){
					genero = '0';
				}else{
					genero = '1';
				}
				var a = (tblPersona.rows[i].cells[6].innerHTML).split('/');
				var fechaNac = a[2]+'-'+a[1]+'-'+a[0]+'T00:00:00';
				jsonPersona += ((i==1)?'':',')+'{"CRDID_CODIGO":"'+tblPersona.rows[i].cells[0].id+'","CGNCN_CODIGO":"'+tblPersona.rows[i].cells[5].id+'",'+
				'"CRPER_NOMBRES":"'+tblPersona.rows[i].cells[2].innerHTML+'",'+
				'"CRPER_APELLIDO_PATERNO":"'+tblPersona.rows[i].cells[3].innerHTML+'",'+
				'"CRPER_NUM_DOC_IDENTIFIC":"'+tblPersona.rows[i].cells[1].innerHTML+'",'+
				'"CRPER_FECHA_NACIMIENTO":"'+fechaNac+'",'+
				'"CRPER_GENERO":"'+genero+'",'+
				'"CGG_CPAIS_CODIGO":"'+tblPersona.rows[i].cells[11].id+'",'+
				'"CRPER_CODIGO":"'+tblPersona.rows[i].cells[2].id+'",'+
				'"CRTRA_CODIGO":"'+tblPersona.rows[i].cells[12].id+'",'+
				'"CKESP_CODIGO":"'+tblPersona.rows[i].cells[7].id+'",'+
				'"CTREG_OBSERVACION":" "}';
			}
			jsonPersona += ']';			
			
			function CallBackCgg_tct_registro(r) {			
				r = eval ("("+r+")");
				if(r.success){
					new bsxMessageBox({
						title:"Pre-registro TCT",
						msg:"La informaci\u00f3n del Pre-Registro ha sido almacenada. Gracias por utilizar nuestros servicios en l\u00ednea",
						icon:"iconOk",
						close:function(){
							btnGuardarTTC.disabled=false;
							//document.location = 'inicio.jsp?CWPAG_CODIGO=CWPAG1';
						}
					});	
					frmPersonaRegistro.reset();
					var tbodyPersona = tblPersona.tBodies[0];
					var totalFilas = tblPersona.rows.length;
					for (var i=totalFilas-1;i>=1;i--) {					
						tbodyPersona.removeChild(tblPersona.rows[i]);
					}
					
					loadIngresoTCT();
				}else{
					new bsxMessageBox({
						title:"Pre-registro TCT",
						msg:'La informaci\u00f3n del Pre- Registro no ha podido ser almacenada. ' + (r.message?r.message:r),
						icon:"iconError"
					});			
					btnGuardarTTC.disabled=false;
				}
			}
			
			var param = new SOAPClientParameters();		
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth()+1;
			var yyyy = today.getFullYear();		
			if (mm<10)	mm = '0'+mm;		
			if (dd<10)	dd = '0'+dd;		
			var fechaPreregsitro = yyyy+'-'+mm+'-'+dd+'T00:00:00';
			var arrFecha = dtFechaIngreso.value.split('/');
			var fechaIngreso = arrFecha[2]+'-'+arrFecha[1]+'-'+arrFecha[0]+'T00:00:00';			
			arrFecha = dtFechaSalida.value.split('/');
			var fechaSalida = arrFecha[2]+'-'+arrFecha[1]+'-'+arrFecha[0]+'T00:00:00';	
			var jsonAtractivos = '';
			
			jsonAtractivos = '[{"VALOR1":"'+valorCalificacion1+'", "VALOR2":"'+valorCalificacion2+'", "VALOR3":"'+valorCalificacion3 +'", "VALOR4":"'+valorCalificacion4 +
			'", "VALOR5":"'+ valorCalificacion5+'", "VALOR6":"'+valorCalificacion6 +'", "VALOR7":"'+valorCalificacion7 +'", "VALOR8":"'+valorCalificacion8 +'", "VALOR9":"'+valorCalificacion9 +
			'", "VALOR10":"'+ valorCalificacion10+'", "VALOR11":"'+ valorCalificacion11+'", "VALOR12":"'+ valorCalificacion12+'", "VALOR13":"'+ valorCalificacion13+'"}]';
			
			
			param.add('inCarpt_codigo', cbxOrigenAux.dom.value);
			param.add('inCgg_carpt_codigo', cbxDestinoAux.dom.value);
			param.add('inCraln_codigo', cbxAerolineaAux.dom.value);
			param.add('inCtreg_numero', null);		
			param.add('inCtreg_fecha_preregistro',fechaPreregsitro);
			param.add('inCtreg_fecha_ingreso',fechaIngreso);
			param.add('inCtreg_codigo_barras', 0);
			param.add('inCtreg_fecha_salida', fechaSalida);
			param.add('inCtreg_categoria', cbxCategoria.dom.value );
			param.add('inCtreg_tipo_registro', cbxTipoRegistro.dom.value);
			param.add('inCtreg_vuelo', jQuery("#txtNroVuelo").val());
			param.add('inCtreg_tipo_hospedaje', cbxTipoHospedaje.dom.value);
			
        	if(jQuery("#cbxTipoHospedaje").val()==102){
        		param.add('inCtreg_nombre_crucero', cbxNombreHospedaje.dom.value);
        		param.add('inCtreg_nombre_hotel', null);
        		param.add('inCtreg_isla_hospedaje', null);
        	}else if(jQuery("#cbxTipoHospedaje").val()==104){
        		param.add('inCtreg_nombre_hotel', cbxNombreHospedajeIsla.dom.value);
        		param.add('inCtreg_isla_hospedaje', cbxIslaHospedaje.dom.value);
        		param.add('inCtreg_nombre_crucero', null);
        	}else if(jQuery("#cbxTipoHospedaje").val()==103){
        		param.add('inCtreg_isla_hospedaje', cbxIslaHospedaje.dom.value);
        		param.add('inCtreg_nombre_crucero', null);
        		param.add('inCtreg_nombre_hotel', null);
        	}
	        	
			param.add('inCtreg_lugar_hospedaje', jQuery("#divLugarHospedaje").val());
			param.add('inCtreg_viaje_acompanante', cbxInformacionViaje1Aux.dom.value);
			param.add('inCtreg_viaje_motivo', cbxInformacionViaje2Aux.dom.value);
			param.add('inCtreg_viaje_actividades', cbxInformacionViaje3Aux.dom.value);
			param.add('inCtreg_viaje_miembros', jQuery("#txtNumeroMiembros").val());
			param.add('inCtreg_viaje_tour', cbxInformacionViaje4Aux.dom.value);
			param.add('inCtreg_viaje_cual', jQuery("#txtCual").val());
			param.add('inAtractivos_JSON', jsonAtractivos);  	
			param.add('inPersona_JSON', jsonPersona);  			
			SOAPClient.invoke(URL_WS+"PublicWS/Cgg_tct_registro", "insert", param, true, CallBackCgg_tct_registro);
		}else btnGuardarTTC.disabled=false;
	}
	
	
	/*
	 *Creación de un combobox para Categoría
	 */
	var cbxCategoria = new bsxComboBox({
		id:"cbxCategoria",
		renderTo:"tdCategoria",
		displayField:"TCTCAT_NOMBRE",
		valueField:"TCTCAT_CODIGO",
		webService:{
			url:URL_WS+"Cgg_tct_categoria",
			method:"selectAll",
			params:[
				{name:"format",value:"JSON"}
			]
		},
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxCategoria').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxCategoria").val(0);
			}
		}
	});
	cbxCategoria.reload();

	/*
	 *Creación de un combobox para Tipo de Registro
	 */
	var cbxTipoRegistro = new bsxComboBox({
		id:"cbxTipoRegistro",
		renderTo:"tdTipoRegistro",
		displayField:"TCTTR_NOMBRE",
		valueField:"TCTTR_CODIGO",
		webService:{
			url:URL_WS+"Cgg_tct_tipo_registro",
			method:"selectAll",
			params:[
				{name:"format",value:"JSON"}
			]
		},
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxTipoRegistro').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxTipoRegistro").val(0);
			}
		}
	});
	cbxTipoRegistro.reload();
	
	/*
	*Creacion de un combobox para las aereolineas
	*/
	var cbxAerolineaAux = new bsxComboBox({
		id:"cbxAerolineaAux",		
		renderTo:"tdAereolinea",		
		displayField:"CRALN_NOMBRE",
		valueField:"CRALN_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_res_aerolinea",
			method:"selectAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		},		
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxAerolineaAux').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxAerolineaAux").val(0);
			}
		}
	});	
	cbxAerolineaAux.reload();
	/*
	*Creacion de un combobox para los origenes de las aereolineas
	*/
	var cbxOrigenAux = new bsxComboBox({
		id:"cbxOrigenAux",
		renderTo:"tdOrigen",		
		displayField:"CARPT_NOMBRE",
		valueField:"CARPT_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_res_aeropuerto",
			method:"selectDirectByTipo",
			params:[							
				{name:"format",value:"JSON"},
				{name:"inCarpt_tipo_aereopuerto",value:0}
			]
		},
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxOrigenAux').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxOrigenAux").val(0);
			}
		}
	});	
	cbxOrigenAux.reload();
	/*
	*Creacion de un combobox para los destinos de la aereolineas
	*/
	var cbxDestinoAux = new bsxComboBox({
		id:"cbxDestinoAux",
		renderTo:"tdDestino",		
		displayField:"CARPT_NOMBRE",
		valueField:"CARPT_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_res_aeropuerto",
			method:"selectDirectByTipo",
			params:[							
				{name:"format",value:"JSON"},
				{name:"inCarpt_tipo_aereopuerto",value:1}
			]
		},
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxDestinoAux').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxDestinoAux").val(0);
			}
		}
	});	
	cbxDestinoAux.reload();
	/*
	*Creacion de un combobox para las aereolineas
	*/
	var cbxTipoDocumento = new bsxComboBox({
		id:"cbxTipoDocumento",
		renderTo:"tdTipoDocumento",		
		displayField:"CRDID_DESCRIPCION",
		valueField:"CRDID_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_res_documento_identificacio",
			method:"selectAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		},
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxTipoDocumento').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxTipoDocumento").val(0);
			}
		}	
	});	
	cbxTipoDocumento.reload();
	
	cbxTipoDocumento.dom.onchange = function(){		
		fnLimpiarControles();
		fnHabilitarControles(true);
		txtNumeroDocumento.value = '';
		txtNumeroDocumento.focus();
	}
	/*
	*Creacion de un combobox para las nacionalidades
	*/
	var cbxPaisResidencia = new bsxComboBox({
		id:"cbxPaisResidencia",
		renderTo:"tdPaisResidencia",		
		displayField:"CPAIS_NOMBRE",
		valueField:"CPAIS_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_pais",
			method:"selectAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		},
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxPaisResidencia').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxPaisResidencia").val(0);
			}
		}	
	});	
	cbxPaisResidencia.reload();
	/*
	*Creacion de un combobox para las nacionalidades
	*/
	var cbxNacionalidad = new bsxComboBox({
		id:"cbxNacionalidad",
		renderTo:"tdNacionalidad",		
		displayField:"CGNCN_NACIONALIDAD",
		valueField:"CGNCN_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_nacionalidad",
			method:"selectAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		},
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxPaisResidencia').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxPaisResidencia").val(0);
			}
		}	
	});	
	cbxNacionalidad.reload();
	
	/*
	*Creacion de un combobox para las aereolineas
	*/
	var cbxConfiguracion = new bsxComboBox({
		id:"cbxConfiguracion",
		renderTo:"tdConfiguracion",		
		displayField:"CGCNF_VALOR_CADENA",
		valueField:"CGCNF_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_configuracion",
			method:"select",
			params:[							
				{name:"format",value:"JSON"},
				{name:"inCgcnf_codigo",value:"CONF35"}
			]
		},
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxConfiguracion').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxConfiguracion").val(0);
			}
		}
	});	
	cbxConfiguracion.reload();

	/*
	 *Creacion de un combobox para la isla de hospedaje
	 */

	var cbxIslaHospedaje = new bsxComboBox({
		id:"cbxIslaHospedaje",
		renderTo:"divIslaHospedaje",
		displayField:"CISLA_NOMBRE",
		valueField:"CISLA_CODIGO",
		webService:{
			url:URL_WS+"Cgg_isla",
			method:"selectAllAtencionCliente",
			params:[
				{name:"format",value:"JSON"}
			]
		},
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxIslaHospedaje').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxIslaHospedaje").val(0);
			}
		}
	});
	cbxIslaHospedaje.reload();

	/*
	 *Creacion de un combobox para el tipo de hospedaje
	 */

	var cbxTipoHospedaje = new bsxComboBox({
		id:"cbxTipoHospedaje",
		renderTo:"divTipoHospedaje",
		displayField:"CDCATA_DESCRIPCION",
		valueField:"CDCATA_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_catalogo",
			method:"selectByType",
			params:[							
				{name:"format",value:"JSON"},
				{name:"in_identificador",value:"9"}
			]
		},
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxTipoHospedaje').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxTipoHospedaje").val(0);
			}
		}
	});
	cbxTipoHospedaje.reload();

	/*
	 *Creacion de un combobox para el nombre de hospedaje
	 */

	var cbxNombreHospedaje = new bsxComboBox({
		id:"cbxNombreHospedaje",
		renderTo:"divNombreHospedaje",
		displayField:"CDCATA_DESCRIPCION",
		valueField:"CDCATA_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_catalogo",
			method:"selectByType",
			params:[							
				{name:"format",value:"JSON"},
				{name:"in_identificador",value:"8"}
			]
		},
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxNombreHospedaje').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxNombreHospedaje").val(0);
			}
		}
	});
	

	
	var cbxNombreHospedajeIsla = new bsxComboBox({
		id:"cbxNombreHospedajeIsla",
		renderTo:"divNombreHospedajeIsla",
		displayField:"CDISHO_NOMBRE",
		valueField:"CDISHO_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_isla_hotel",
			method:"selectByIsland",
			params:[							
				{name:"format",value:"JSON"},
				{name:"in_isla_codigo",value:""}
			]
		},
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxNombreHospedajeIsla').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxNombreHospedajeIsla").val(0);
			}
		}
	});
	
	/*
	*Creacion de un combobox para la informacion del viaje - usted esta viajando con
	*/
	var cbxInformacionViaje1Aux = new bsxComboBox({
		id:"cbxInformacionViaje1Aux",
		renderTo:"tdInformacionViaje1",		
		displayField:"CDCATA_DESCRIPCION",
		valueField:"CDCATA_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_catalogo",
			method:"selectByType",
			params:[							
				{name:"format",value:"JSON"},
				{name:"in_identificador",value:"4"}
			]
		},
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxInformacionViaje1Aux').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxInformacionViaje1Aux").val(0);
			}
		}
	});	
	cbxInformacionViaje1Aux.reload();
	
	/*
	*Creacion de un combobox para la informacion del viaje - usted esta viajando con
	*/
	var cbxInformacionViaje2Aux = new bsxComboBox({
		id:"cbxInformacionViaje2Aux",
		renderTo:"tdInformacionViaje2",		
		displayField:"CDCATA_DESCRIPCION",
		valueField:"CDCATA_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_catalogo",
			method:"selectByType",
			params:[							
				{name:"format",value:"JSON"},
				{name:"in_identificador",value:"5"}
			]
		},
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxInformacionViaje2Aux').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxInformacionViaje2Aux").val(0);
			}
		}
	});	
	cbxInformacionViaje2Aux.reload();
	
	/*
	*Creacion de un combobox para la informacion del viaje - usted esta viajando con
	*/
	var cbxInformacionViaje3Aux = new bsxComboBox({
		id:"cbxInformacionViaje3Aux",
		renderTo:"tdInformacionViaje3",		
		displayField:"CDCATA_DESCRIPCION",
		valueField:"CDCATA_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_catalogo",
			method:"selectByType",
			params:[							
				{name:"format",value:"JSON"},
				{name:"in_identificador",value:"6"}
			]
		},
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxInformacionViaje3Aux').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxInformacionViaje3Aux").val(0);
			}
		}
		
	});	
	cbxInformacionViaje3Aux.reload();
	
	
	
	/*
	*Creacion de un combobox para la informacion del viaje - usted esta viajando con
	*/
	var cbxInformacionViaje4Aux = new bsxComboBox({
		id:"cbxInformacionViaje4Aux",
		renderTo:"tdInformacionViaje4",		
		displayField:"CDCATA_DESCRIPCION",
		valueField:"CDCATA_CODIGO",
		webService:{
			url:URL_WS+"PublicWS/Cgg_catalogo",
			method:"selectByType",
			params:[							
				{name:"format",value:"JSON"},
				{name:"in_identificador",value:"7"}
			]
		},
		width: 210,
		events:{
			load:function(v){
				jQuery('#cbxInformacionViaje4Aux').prepend("<option value='0'>Seleccione un item</option>");
				jQuery("#cbxInformacionViaje4Aux").val(0);
			}
		}
	});	
	cbxInformacionViaje4Aux.reload();

	function fnHabilitarControles(estado){
		txtNombrePersona.readOnly = estado;
		txtApellidoPersona.readOnly = estado;
		txtFechaNacimiento.disabled = estado;
		cbmGenero.disabled = estado;
	}
	
	function consultarPersona()
    {	   flagValido = true; 
			$("divInfoValidacion").style.display = "block";
			btnAceptarIngreso.disabled = true;			
			function CallBackCgg_tct_persona(r){
				var tmpselect = eval('('+r+')');
				if (tmpselect.length== 0 ){
					txtNombrePersona.focus();				
					txtNombrePersona.value = '';
					txtApellidoPersona.value = '';
					var numeroIdentificacion=txtNumeroDocumento.value;					
					txtCodigoPersona.value = '';
					txtCodigoTramite.value = '';
					txtCodigoEspecie.value = '';					
					txtNumeroDocumento.value = numeroIdentificacion;
					fnHabilitarControles(false);
					btnAceptarIngreso.disabled = false;
					$("divInfoValidacion").style.display = "none";
				}else{
					                        
					fnHabilitarControles(true);
					txtCodigoPersona.value=tmpselect[0].CRPER_CODIGO;					
					txtNombrePersona.value = tmpselect[0].CRPER_NOMBRES;
					txtApellidoPersona.value= tmpselect[0].CRPER_APELLIDO_PATERNO;				  
				   var tmps= (tmpselect[0].CRPER_GENERO+" ").trim();
					if (tmps.length>0)
						cbmGenero.value = tmpselect[0].CRPER_GENERO;
					
					cbxNacionalidad.value = tmpselect[0].CGNCN_CODIGO;						
					cbxPaisResidencia.value = tmpselect[0].CGG_CPAIS_CODIGO;
					if(tmpselect[0].CKESP_CODIGO)
						txtCodigoEspecie.value=tmpselect[0].CKESP_CODIGO;
					else
						txtCodigoEspecie.value = cbxConfiguracion.dom.value;

					var fecha = tmpselect[0].CRPER_FECHA_NACIMIENTO.split(' ')
					var b = fecha[0].split('-');
					var fechaNacimiento = b[2]+'/'+b[1]+'/'+b[0];
					txtFechaNacimiento.value = fechaNacimiento;
					txtCodigoTramite.value = (tmpselect[0].CRTRA_CODIGO)?tmpselect[0].CRTRA_CODIGO:'';
					var numero_tramite = tmpselect[0].CRTRA_NUMERO;
					txtTipo.value=tmpselect[0].TIPO_RESIDENCIA;						
					if(numero_tramite){
						txtTipo.value = 'TRANSEUNTE';
					}else{
						txtTipo.value='TURISTA';
					}					
					validarReglas(txtCodigoPersona.value);
				}
             

            }
            var param = new SOAPClientParameters();
			var arrFecha = dtFechaIngreso.value.split('/');
			var fechaIngreso = arrFecha[2]+'-'+arrFecha[1]+'-'+arrFecha[0];			
            param.add('inCrper_num_doc_identific',txtNumeroDocumento.value);
			param.add('inCrdid_codigo',cbxTipoDocumento.dom.value);
            param.add('inCtreg_fecha_ingreso',fechaIngreso+'T00:00:00');
            param.add('format','JSON');
            SOAPClient.invoke(URL_WS+"PublicWS/Cgg_tct_registro",'selectPersonaTct',param, true, CallBackCgg_tct_persona);
     
    }

	var cont = 1;
	function fnLlenarPersona(){
		var tbodyPersona = tblPersona.tBodies[0];
		if(swEdit==false){
			if(tblPersona.rows.length>1){
				for (var i=1;i<tblPersona.rows.length;i++) {
					if(tblPersona.rows[i].cells[1].innerHTML == txtNumeroDocumento.value){					
						new bsxMessageBox({
							title:"Error de ingreso",
							msg:'La persona ya pertenece al listado de pre-registro.',
							icon:"iconError"
						});	
						return;
					}				
				}
			}
		}else{
			tblPersona.rows[posicion].cells[0].id = cbxTipoDocumento.dom.value;
			tblPersona.rows[posicion].cells[5].id = cbxNacionalidad.dom.value;
			tblPersona.rows[posicion].cells[2].innerHTML = txtNombrePersona.value;
			tblPersona.rows[posicion].cells[3].innerHTML = txtApellidoPersona.value;
			tblPersona.rows[posicion].cells[1].innerHTML = txtNumeroDocumento.value;
			tblPersona.rows[posicion].cells[6].innerHTML = txtFechaNacimiento.value;
			tblPersona.rows[posicion].cells[4].id = cbmGenero.value;
			if(cbmGenero.value == 0){				
				tblPersona.rows[posicion].cells[4].innerHTML = 'M';
			}else{
				tblPersona.rows[posicion].cells[4].innerHTML = 'F';				
			}
			tblPersona.rows[posicion].cells[11].id = cbxPaisResidencia.dom.value;
			tblPersona.rows[posicion].cells[2].id = txtCodigoPersona.value;
			
			tblPersona.rows[posicion].cells[7].id = txtCodigoEspecie.value;
			tblPersona.rows[posicion].cells[5].innerHTML = cbxNacionalidad.dom.options[cbxNacionalidad.dom.selectedIndex].text;
			tblPersona.rows[posicion].cells[7].innerHTML = cbxConfiguracion.dom.options[cbxConfiguracion.dom.selectedIndex].text;
			tblPersona.rows[posicion].cells[0].innerHTML = cbxTipoDocumento.dom.options[cbxTipoDocumento.dom.selectedIndex].text;
			tblPersona.rows[posicion].cells[11].innerHTML = cbxPaisResidencia.dom.options[cbxPaisResidencia.dom.selectedIndex].text;
			
			tblPersona.rows[posicion].cells[12].id = (txtCodigoTramite.value)?txtCodigoTramite.value:"";			
			tblPersona.rows[posicion].cells[12].innerHTML = txtCodigoTramite.value;
			swEdit = false;
			btnSalirAll($("FrmIngresoPersona"));
			
			return;
		}
		var fila =tbodyPersona.insertRow(tblPersona.rows.length-1);
		fila.id = 'tr'+cont;
		fila.onclick = function(){		
			filaTablaPersona = this;
			posicion = this.sectionRowIndex+1;
			for (var i=1;i<tblPersona.rows.length;i++) {							
					tblPersona.rows[i].className = "rowNoSelectTable";								
			}
			this.className="rowSelectTable";
			
		};
		
		cont++;

		var celda= fila.insertCell(0);
		celda.id = cbxTipoDocumento.dom.value;
		celda.innerHTML = cbxTipoDocumento.dom.options[cbxTipoDocumento.dom.selectedIndex].text;
		celda.width = 80;

		celda= fila.insertCell(1);		
		celda.innerHTML = txtNumeroDocumento.value;
		celda.width = 80;

		celda= fila.insertCell(2);	
		celda.id = txtCodigoPersona.value;
		celda.innerHTML = txtNombrePersona.value;
		celda.width = 110;

		celda= fila.insertCell(3);
		celda.innerHTML = txtApellidoPersona.value;
		celda.width = 110;
		
		celda= fila.insertCell(4);
		if(cbmGenero.value == 0){
			celda.id = '0';
			celda.innerHTML = 'M';
		}else{
			celda.innerHTML = 'F';
			celda.id = '1';
		}
		celda.width = 40;
		
		celda= fila.insertCell(5);
		celda.id = cbxNacionalidad.dom.value;
		celda.innerHTML = cbxNacionalidad.dom.options[cbxNacionalidad.dom.selectedIndex].text;
		celda.width = 80;

		celda= fila.insertCell(6);
		celda.innerHTML = txtFechaNacimiento.value;
		celda.width = 100;

		celda= fila.insertCell(7);
		celda.style.display = "none";
		celda.id = cbxConfiguracion.dom.options[cbxConfiguracion.dom.selectedIndex].text;
		celda.innerHTML = cbxConfiguracion.dom.options[cbxConfiguracion.dom.selectedIndex].text;
	
		celda= fila.insertCell(8);
		
		celda.innerHTML = 'PREREGISTRADA';
		celda.style.display = "none";		

		celda= fila.insertCell(9);
		celda.style.display="none";
		celda.innerHTML = txtTipo.value;

		celda= fila.insertCell(10);
		celda.innerHTML = txtNumeroAut.value;
		
		celda= fila.insertCell(11);
		celda.id = cbxPaisResidencia.dom.value;
		celda.style.display="none";
		celda.innerHTML = cbxPaisResidencia.dom.options[cbxPaisResidencia.dom.selectedIndex].text;
		
		celda= fila.insertCell(12);		
		celda.id = (txtCodigoTramite.value)?txtCodigoTramite.value:"";
		celda.style.display="none";
		celda.innerHTML = txtCodigoTramite.value;
		btnSalirAll($("FrmIngresoPersona"));		
	}
	function CallBackReglasTipoSolicitud(r)
	{
		try
		{			
			tmpObjReglasValidacion  = r;		
		}
		catch(inErr)
		{			
			tmpObjReglasValidacion =[];
		}

	}
	var param = new SOAPClientParameters();
	param.add('inCopvl_formulario','FrmCgg_tct_registro');
	param.add('format','JSON');
	SOAPClient.invoke(URL_WS+'PublicWS/Cgg_regla_validacion' ,'selectOperacionValidacionByForm',param, true,CallBackReglasTipoSolicitud);
	/*
     * Funcion encargada de obtener los valores definidos en cada una de las reglas de validacion
     * */

    function evaluarReglasValidacion(objReglasValidacion1)
    {
        for(var i=0;i<objReglasValidacion1.length;i++)
        {           
            var objTmp =  eval('('+objReglasValidacion1[i].CRTSE_CAMPO_EVALUACION+')')[0]; 
            for (var key in objTmp) {
                objTmp[key] = eval(objTmp[key]);
            }
            objReglasValidacion1[i].CRTSE_CAMPO_EVALUACION ='['+JSON.stringify(objTmp)+']';
        }
        return (JSON.stringify(objReglasValidacion1));

    }
	
	
	/*
     * Funcion definida para invocar el proceso de validacion
     *
     * */
    function validarReglas(codigoPersona)
    {        
	btnAceptarIngreso.disabled = true;	
            function CallBackCgg_regla_validacion(r){                
				var validacion = eval('('+r+')');    
				
				if(validacion.resultadoValidacion != undefined){
					if(validacion.resultadoValidacion == 'false'){
						mensaje = '<table style="font-size:12">';							
						var j=1;
						for(i=0;i<validacion.dataSet.length;i++){								
							if(validacion.dataSet[i].CRVAL_APROBADO == 'FALSE'){
								mensaje += '<tr><th>'+j+'</th><td>'+validacion.dataSet[i].CRVAL_SUGERENCIA+'</td></tr>'
								j++;
							}
						}
						mensaje += '</table>';							
						new bsxMessageBox({
							title:"Error validaci\u00f3n",
							msg:'<span>No se puede realizar el registro de la persona.!!</span>'+mensaje,//+tplNotificacion.apply(validacion.dataSet),
							icon:"iconError",
							close:function(){
								flagValido = false;
								btnAceptarIngreso.disabled = false;
								$("divInfoValidacion").style.display = "none";									
							}
						});	
						
					}else{						
						flagValido = true;	
						btnAceptarIngreso.disabled = false;	
						$("divInfoValidacion").style.display = "none";
					}
				}
            }            
			tmpCarpt_codigo_origen = cbxAerolineaAux.dom.value;
			tmpNumeroDocumento = txtNumeroDocumento.value;
			tmpCrper_codigo = codigoPersona?codigoPersona:'';
			tmpCusu_nombre = null;
			var arrFecha = dtFechaIngreso.value.split('/');
			var fechaIngreso = arrFecha[2]+'-'+arrFecha[1]+'-'+arrFecha[0];		

			tmpFechaIngreso = fechaIngreso+'T00:00:00';
//dtFechaIngreso.value.format(TypeDateFormat.ISO8601Long);

            objReglasValidacion  = eval('('+tmpObjReglasValidacion+')');/*Ext.decode(tmpObjReglasValidacion);*/
            var param = new SOAPClientParameters();
			var jsonevalualRegla = evaluarReglasValidacion(objReglasValidacion);			
            param.add('inJSON_reglas_validacion',jsonevalualRegla);
			param.add('jsonData',null);
            SOAPClient.invoke(URL_WS+'PublicWS/Cgg_regla_validacion' ,'ejecutarReglaTipoSolicitud',param, true, CallBackCgg_regla_validacion);
    }
	setHeightForm();
	jQuery("#cbxInformacionViaje1Aux").change(function() {
		  var tipo = jQuery(this).val();
		  if(tipo == 13){
			  jQuery("#txtNumeroMiembros").val(1);
			  jQuery("#txtNumeroMiembros").attr('disabled', true);
		  } else if(tipo == 14){
			  jQuery("#txtNumeroMiembros").val(2);
			  jQuery("#txtNumeroMiembros").attr('disabled', true);
		  } else if((tipo == 15)||(tipo == 16)||(tipo == 0)){
			  jQuery("#txtNumeroMiembros").val(0);
			  jQuery("#txtNumeroMiembros").attr('disabled', false);
		  } 
		 
	});
	
	
	
	jQuery("#cbxTipoHospedaje").change(function() {
		  var tipo = jQuery(this).val();
		  if(tipo == 102){//CRUCERO
			  jQuery("#cbxIslaHospedaje").val(0);
			  jQuery("#cbxIslaHospedaje").attr('disabled', true);
			  jQuery("#labelHospedaje").html("* Nombre del sitio de hospedaje");
			  jQuery("#divNombreHospedaje").show();
			  jQuery("#divNombreHospedajeIsla").hide();
			  jQuery("#divLugarHospedaje").hide();
			  jQuery("#divLugarHospedaje").val('');
			  cbxNombreHospedaje.reload();
		  } else if(tipo == 104){//HOTEL
			  jQuery("#cbxIslaHospedaje").attr('disabled', false); 
			  jQuery("#cbxIslaHospedaje").val(0);
			  jQuery("#labelHospedaje").html("* Nombre del sitio de hospedaje");
			  jQuery("#divNombreHospedaje").hide();
			  jQuery("#divNombreHospedajeIsla").show();
			  jQuery("#divLugarHospedaje").hide();
			  jQuery('#cbxNombreHospedajeIsla').html('');
			  jQuery('#cbxNombreHospedajeIsla').append("<option value='0'>Seleccione un item</option>");
			  jQuery("#divLugarHospedaje").val('');
		  }else{//DOMICILIO AMIGO/FAMILIAR
			  jQuery("#cbxIslaHospedaje").attr('disabled', false); 
			  jQuery("#cbxIslaHospedaje").val(0);
			  jQuery("#labelHospedaje").html("* Lugar de hospedaje");
			  jQuery("#divNombreHospedaje").hide();
			  jQuery("#divNombreHospedajeIsla").hide();
			  jQuery("#divLugarHospedaje").show();
			  jQuery("#divLugarHospedaje").val('');
		  }
		 
	});
	
	
	jQuery("#cbxIslaHospedaje").change(function() {
		var tipo = jQuery(this).val();
		cbxNombreHospedajeIsla.setParam('in_isla_codigo',tipo);
		cbxNombreHospedajeIsla.reload();
		
	});
	
}
	
