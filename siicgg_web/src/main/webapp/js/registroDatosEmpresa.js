function loadRegistroDatosEmpresa(){
	var codigoUsuario = $("txtUsuario").value;	
	if (codigoUsuario=="false"){
		window.location='https://'+URL_SERVER+URL_APP+'bienvenida.jsp?CWPAG_CODIGO=CWPAG1';
		return;
	}
	var userObject;
	
	new Ajax.Request(URL_WS+"SessionManager?request=userobject", {
		method: 'get',
		asynchronous : false,
		onSuccess: function(transport) {
			userObject = eval("("+transport.responseText+")");
		},
		onFailure: function(transport) {
			alert(transport);
		}
	});
	var codigoPersona=userObject.CRPER_CODIGO;	
	/*VARIABLES DE LOS COMPONENTES DE REGISTRO DATOS EMPRESA*/
	var txtRdemp_razon_social = document.getElementById("txtRdemp_razon_social");
	var numtRdemp_RUC = document.getElementById("numtRdemp_RUC");
	var txtRdemp_nombre = document.getElementById("txtRdemp_nombre");	
	var txtRdemp_apellido = document.getElementById("txtRdemp_apellido");
	var numRdemp_cedula = document.getElementById("numRdemp_cedula");
	var txtRdemp_direccion = document.getElementById("txtRdemp_direccion");
	var numRdemp_Telefono = document.getElementById("numRdemp_Telefono");
	var txtRdemp_email = document.getElementById("txtRdemp_email");
	var btnGuardarRegistroControlEmpresa = document.getElementById("btnGuardarRegistroControlEmpresa");
	var btnSalirRegistroControlEmpresa = document.getElementById("btnSalirRegistroControlEmpresa");
	var FrmRegistroDatosEmpresa = document.getElementById("FrmRegistroDatosEmpresa");
	var FormularioRegistroEmpresarial = document.getElementById("FormularioRegistroEmpresarial");	
	FormularioRegistroEmpresarial.action = URL_WS_PUBLIC+"Cgg_gem_preregistro_empresaSRV";	
	var metodoGem_preregistro_empresa;
	var tdCedula = document.getElementById("tdCedula");
	
	var txtRdemp_Representante = document.getElementById("txtRdemp_Representante");
	var numRdemp_FechaCreacion = document.getElementById("numRdemp_FechaCreacion");
	var btnLimpiarRegistroControlEmpresa = document.getElementById("btnLimpiarRegistroControlEmpresa");
	btnLimpiarRegistroControlEmpresa.onclick=function(){
		FormularioRegistroEmpresarial.reset();
	}
	new JsDatePick({
        useMode:2,
        target:"numRdemp_FechaCreacion",
        dateFormat:"%Y-%m-%d",
        imgPath:"..images/jsdatepicker/",
		limitToToday:true
    });
	var numRdemp_Actividad = document.getElementById("numRdemp_Actividad");
	var numRdemp_NumeroEmpleados = document.getElementById("numRdemp_NumeroEmpleados");
	var chkPublicar = document.getElementById("chkPublicar");
	var cgpre_adjunto = document.getElementById("cgpre_adjunto");
	var nombreAdjunto = document.getElementById("cgpre_nombre_adjunto");
	var tipoAdjunto = document.getElementById("cgpre_tipo_adjunto");
	var cgpre_sector = document.getElementById("cgpre_sector");
	var cgpre_tipo = document.getElementById("cgpre_tipo");
	var txtEmail = document.getElementById("txtEmail");
	var btnBuscarPersona = $("btnBuscarPersona");	
	txtRdemp_Representante.innerHTML = userObject.CRPER_NOMBRES + ' ' +userObject.CRPER_APELLIDO_PATERNO;
	cgpre_representante.value = codigoPersona;
	
	/*
	*Creacion de un combobox con datos de un webservices ISLAS
	*/
	var cbxIsla = new bsxComboBox({
		id:"cbxIsla",
		renderTo:"tdIsla",		
		displayField:"CISLA_NOMBRE",
		valueField:"CISLA_CODIGO",
		width:120,
		webService:{
			url:URL_WS+"Cgg_isla",
			method:"selectAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		}		
	});	
	cbxIsla.reload();
	numtRdemp_RUC.onkeypress = function(event){
		if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;
	}
	numRdemp_cedula.onkeypress = function(event){
		
		if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;
	}
	numRdemp_Telefono.onkeypress = function(event){
		if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;
	}
	numRdemp_NumeroEmpleados.onkeypress = function(event){
		if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;
	}
	function showForm(frm){
		document.getElementById("divBgModal").style.display="block";
		frm.style.display="block";	
	}
	btnBuscarPersona.onclick = function(){
		//showForm($("FrmDatosPersona"));
		$("trNombre").style.display = "block";	
		$("tdNombre").innerHTML='<img src="css/icon/cargando.gif"/> <i> Por favor espere...</i>';
		function CallBackSelectCgg_res_datos_persona(v){
			var a = eval('('+v+')');			
			if(a.length>0 && a[0].CRPER_CODIGO){
				$("tdNombre").innerHTML = (a[0].CRPER_NOMBRES||""+" "+a[0].CRPER_APELLIDO_PATERNO||""+' '+a[0].CRPER_APELLIDO_MATERNO||"")||"";
				var codigoPersonaByNumDoc = a[0].CRPER_CODIGO;
				setHeightForm();
				function CallBackSelectCgg_res_personaContacto(v){
					var a = eval('('+v+')');					
					if(a.length>0){	
						for(i=0;i<a.length;i++){
							if(a[i].CRTCO_CODIGO == 'CRTCO1'){					
								$("tdNombre").innerHTML += " ("+((a[i].CRPRC_CONTACTO)||"")+")";
								return;
							}
						}
					}
				}
				var param = new SOAPClientParameters();				
				param.add('inCrper_codigo',codigoPersonaByNumDoc);						
				param.add('format','JSON');		
				
				SOAPClient.invoke(URL_WS+"Cgg_res_persona_contacto","selectPersonaContacto",param, true, CallBackSelectCgg_res_personaContacto);
			}else
			$("tdNombre").innerHTML	="No existe informaci&oacute;n relacionada al n&uacute;mero de c&eacute;dula"		;
		}
		var param = new SOAPClientParameters();				
		param.add('inCrper_num_doc_identific',numRdemp_cedula.value);						
		param.add('format','JSON');		
		
		SOAPClient.invoke(URL_WS+"Cgg_res_persona","selectNumDoc",param, true, CallBackSelectCgg_res_datos_persona);
	}
	function CallBackSelectCgg_res_persona(v){
		var a = eval('('+v+')');		
		if(a.length>0){	
			for(i=0;i<a.length;i++){
				if(a[i].CRTCO_CODIGO == 'CRTCO1'){					
					txtRdemp_Representante.innerHTML += " ("+a[i].CRPRC_CONTACTO+")";
					return;
				}
			}
		}
	}
	var param = new SOAPClientParameters();				
	param.add('inCrper_codigo',codigoPersona);						
	param.add('format','JSON');		
	
	SOAPClient.invoke(URL_WS+"Cgg_res_persona_contacto","selectPersonaContacto",param, true, CallBackSelectCgg_res_persona);
	var cbxSector = new bsxComboBox({
		id:"cbxSector",		
		renderTo:"tdSector",		
		displayField:"CSCTP_NOMBRE",
		valueField:"CSCTP_CODIGO",
		width:120,
		webService:{
			url:URL_WS_PUBLIC+"Cgg_gem_preregistro_empresa",
			method:"selecSectorAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		},
		events: {
			load:function(v){				
				cgpre_sector.value = cbxSector.dom.value;
				cbxSector.dom.onchange = function(){					
					cgpre_sector.value = cbxSector.dom.value;					
				}
			}
		}		
	});
	cbxSector.reload();	
	
	
	var cbxTipo = new bsxComboBox({
		id:"cbxTipo",		
		renderTo:"tdTipo",		
		displayField:"CVSCT_NOMBRE",
		valueField:"CVSCT_CODIGO",
		webService:{
			url:URL_WS_PUBLIC+"Cgg_gem_preregistro_empresa",
			method:"selectTitoAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		},
		events: {
			load:function(v){				
				cgpre_tipo.value = cbxTipo.dom.value;
				cbxTipo.dom.onchange = function(){					
					cgpre_tipo.value = cbxTipo.dom.value;					
				}
			}
		}		
	});		
	cbxTipo.reload();	
	
	/*cgpre_sector
	cgpre_tipo*/
	/**
	*	GUARDAR O ACTUALIZAR DATOS SOBRE EXPERIENCIA LABORAL DE LA PERSONA
	*/
	cgpre_adjunto.onchange = function(){
		var a = cgpre_adjunto.value.split('\\');
		var b = cgpre_adjunto.value.split('.');
		nombreAdjunto.value = a[a.length-1];
		tipoAdjunto.value = b[b.length-1];	
	}
	/**
	*	FUNCION QUE PERMITE VISUALIZAR SI LOS ADJUNTO FUERON O NO ALMACENADOS
	**/
	function fnSubirImagen(){			
		var a = eval('('+this.contentDocument.body.childNodes[0].data+')');
		if (a.success ==true ){			
			new bsxMessageBox({
				title:"Informaci\u00F3",
				msg:"Los datos de su empresa han sido enviados al administrador para su aprobaci\u00F3n",
				icon:"iconOk",
				close:function(){
					FormularioRegistroEmpresarial.reset();
					document.location = 'bienvenida.jsp?CWPAG_CODIGO=CWPAG1';
				}
			});
			
		}else{				
			new bsxMessageBox({
				title:"Informaci\u00F3",
				msg:a.msg,
				icon:"iconError"
			});
		}
		
	}
	btnGuardarRegistroControlEmpresa.onclick = function(){		
		$("cgpre_cisla_codigo").value = cbxIsla.dom.value;
		if($("numtRdemp_RUC").value){
			if($("txtRdemp_razon_social").value){
				if($("numRdemp_FechaCreacion").value){
					if($("numRdemp_NumeroEmpleados").value){
						if($("numRdemp_Telefono").value){
							if($("txtRdemp_email").value){
								if($("numRdemp_Actividad").value){
									if($("txtRdemp_direccion").value){
										if($("cgpre_adjunto").value){
											numRdemp_FechaCreacion.value = numRdemp_FechaCreacion.value+ " 00:00:00" ;
											document.getElementById('upload_target').onload = fnSubirImagen;
											FormularioRegistroEmpresarial.submit();
											numRdemp_FechaCreacion.value = (numRdemp_FechaCreacion.value).split(" ")[0] ;
										}else{
											new bsxMessageBox({
												title:"Error",
												msg:'Ingrese el documento de nombramiento de la empresa',
												icon:"iconError",
												close:function(){
													$("cgpre_adjunto").focus();
												}
											});
										}
									}else{
										new bsxMessageBox({
											title:"Error",
											msg:'Ingrese la direcc\u00F3n de la empresa',
											icon:"iconError",
											close:function(){
												$("txtRdemp_direccion").focus();
											}
										});
									}
								}else{
									new bsxMessageBox({
										title:"Error",
										msg:'Ingrese la actividad de la empresa',
										icon:"iconError",
										close:function(){
											$("numRdemp_Actividad").focus();
										}
									});
								}
							}else{
								new bsxMessageBox({
									title:"Error",
									msg:'Ingrese una direcci\u00F3n electeronica de la empresa',
									icon:"iconError",
									close:function(){
										$("txtRdemp_email").focus();
									}
								});
							}
						}else{
							new bsxMessageBox({
								title:"Error",
								msg:'Ingrese n\u00FAmero telef\u00F3nico',
								icon:"iconError",
								close:function(){
									$("numRdemp_Telefono").focus();
								}
							});
						}
					}else{
						new bsxMessageBox({
							title:"Error",
							msg:'Ingrese el n\u00FAmero de empleados',
							icon:"iconError",
							close:function(){
								$("numRdemp_NumeroEmpleados").focus();
							}
						});
					}
				}else{
					new bsxMessageBox({
						title:"Error",
						msg:'Ingrese la fecha de creaci\u00F3n de la empresa',
						icon:"iconError",
						close:function(){
							$("numRdemp_FechaCreacion").focus();
						}
					});
				}
			}else{
				new bsxMessageBox({
					title:"Error",
					msg:'Ingrese raz\u00F3n social',
					icon:"iconError",
					close:function(){
						$("txtRdemp_razon_social").focus();
					}
				});
			}			
		}else{
			new bsxMessageBox({
				title:"Error",
				msg:'Ingrese n\u00FAmero de Ruc',
				icon:"iconError",
				close:function(){
					$("numtRdemp_RUC").focus();
				}
			});			
		}
		
		
	}
	chkPublicar.onclick =function(){			
		if(!chkPublicar.checked){		
			tdCedula.style.display="table-cell"			
		}
		else{
			tdCedula.style.display="none"
			$("trNombre").style.display = "none";		
		}
		setHeightForm();
	}	
	setHeightForm();	
}
	