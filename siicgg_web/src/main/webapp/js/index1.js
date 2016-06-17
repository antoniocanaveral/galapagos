var divCargando;
var RolUsuario;
function loadInit(){	
	var txtUsuario = document.getElementById("txtUsuario");
	if (txtUsuario.value!="false"){
		function CallBackRolUsuario(r){
			RolUsuario = r;
		}	
		SOAPClient.invoke(URL_WS+"Cgg_gem_vacante", "getRolUsuario", null, false, CallBackRolUsuario);	
	}
	divCargando = document.getElementById("divCargando");
	loadFecha();
	loadSeleccionModulo();
	var divUsuario = document.getElementById("divUsuario");
	var pnlGestionEmpleo = document.getElementById("pnlGestionEmpleo");
	pnlGestionEmpleo.style.display="none";
	var txtUsuario = document.getElementById("txtUsuario");
	var btnAcceso = document.getElementById("btnAcceso");	
	var btnCambiarClave = document.getElementById("btnCambiarClave");	
	if (txtUsuario.value!="false"){
		var userObject;	
		var url = URL_WS+"SessionManager?request=userobject";
		new Ajax.Request(url, {
			method: 'get',
			asynchronous : false,
			onSuccess: function(transport) {
				userObject = eval("("+transport.responseText+")");
			},
			onFailure: function(transport) {alert(transport);}
		});
		
		var codigoUsuario=userObject.CUSU_CODIGO;	
		var estadoUsuario = userObject.CUSU_ACTIVO;
		var usuarioInterno = userObject.CUSU_USUARIO_INTERNO;
		
		if (estadoUsuario == true){		
			btnCambiarClave.onclick = function(){
				document.getElementById("iFrameBody").src="cambiarContrasenia.jsp";
			}
		}else{
			btnCambiarClave.innerHTML ="Cuenta inactiva";
		}
		
		function CallBackFrase(r){			
			var res = eval(r);
			$("divFrase").innerHTML = res[0].CWFB_CONTENIDO;
		}	
		var param = new SOAPClientParameters(); 		
		param.add('inCwfb_codigo',null);					
		param.add('format', "JSON");					
		SOAPClient.invoke(URL_WS+"Cgg_web_frase_bienvenida", "select", param, true, CallBackFrase);	
		
		function CallBackIndicador(r){			
			var res = eval(r);
			$("divIndicador").innerHTML = "<table style='font-size:11'>"+				
				"<tr><td>Visto por empresas:</td><td><b>"+res[0].OBSERVADO+"</b></td></tr>"+
				"<tr><td>Aplicaciones realizadas:</td><td><b>"+res[0].APLICACIONES+"</b></td></tr>"+
				"<tr><td>Inasistenacias a entrevistas:</td><td><b>"+res[0].FALTA+"</b></td></tr>"+
			"</table>";
		}	
		var param = new SOAPClientParameters(); 		
		param.add('inCusu_codigo',codigoUsuario);		
		SOAPClient.invoke(URL_WS_PUBLIC+"Cgg_atc_gestion_empleo", "selectEstadistica", param, true, CallBackIndicador);
				
		
		btnAcceso.innerHTML="Salir";
		divUsuario.innerHTML = "<b>Bienvenido</b><br> "+ userObject.CRPER_NOMBRES+" "+userObject.CRPER_APELLIDO_PATERNO+"";		
		btnAcceso.onclick=function(){
			window.location="PrivateWS/SessionWeb?request=logout";
		}
	}
	divCargando.style.visibility="hidden";
}
function loadFecha(){
	var fecha = new Date();
	var days = ['Domingo','Lunes','Martes','Mi&eacute;rcoles','Jueves','Viernes','S&aacute;bado'];
	var months = ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'];
	var months_c = ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'];
	var f_day = fecha.getDay();
	var f_date = fecha.getDate();
	var f_month = fecha.getMonth();
	var f_year = fecha.getFullYear();
	document.getElementById("divFecha").innerHTML=days[f_day] +", "+f_date+ " de " + months_c[f_month] + " de " + f_year;	
}

function loadSeleccionModulo(){
	var arrDivs=[];
	function moduloOnClick(){
		var thisArray ="";
		for (k=0;k<arrDivs.length;k++)
			if (arrDivs[k].idComponent == this.id){
				thisArray = arrDivs[k];
				break;
			}

		for (k=0;k<arrDivs.length;k++){
		
			var tmpComp = document.getElementById(arrDivs[k].idComponent);
			if (arrDivs[k].parent){
				if (arrDivs[k].items)
					if (arrDivs[k].idComponent == this.id)
						document.getElementById(this.id+"-Items").style.display = 'inline';
					else
						if (thisArray.parent)
							document.getElementById(arrDivs[k].idComponent+"-Items").style.display = 'none';
			}else
				if (arrDivs[k].idComponent == this.id)
					this.className="select";				
				else
					document.getElementById(arrDivs[k].idComponent).className="noSelect";					
				
			if (tmpComp.id == this.id){
				setOptionModuloSeleccionado(this.id);
				if (arrDivs[k].page)
					document.getElementById("iFrameBody").src=arrDivs[k].page;
				else
					divCargando.style.visibility="hidden";
			}	
			
		}
		divCargando.style.visibility="visible";
		for (var k=0;k<arrDivs.length;k++)	{					
			if (arrDivs[k].idComponent == this.id)
				if (arrDivs[k].page)
					document.getElementById("iFrameBody").src=arrDivs[k].page;
				else
					divCargando.style.visibility="hidden";
		}		
	}
	/*Menu Inicio*/
	arrDivs.push({parent:true,items:true,idComponent:"divInicio",page:"bienvenida.jsp?CWPAG_CODIGO=CWPAG1"});	
	arrDivs.push({idComponent:"lnkInicio",page:"bienvenida.jsp?CWPAG_CODIGO=CWPAG1",toolTip:"Ir a la p\u00e1gina inicial"});
	arrDivs.push({idComponent:"lnkNoticias",page:"bienvenida.jsp?CWPAG_CODIGO=CWPAG2",toolTip:"Ver noticias actualizadas del CGG"});
	
	/*Menu Gestion de empleo*/
	arrDivs.push({parent:true,items:true,idComponent:"divGestEmpleo",page:"gestionEmpleo.jsp"});
	arrDivs.push({idComponent:"linkCandidatos",page:"gestionEmpleo.jsp",toolTip:"Si deseas conseguir trabajo"});
	arrDivs.push({idComponent:"linkEmpresas",page:"gestionEmpleo.jsp",toolTip:"Si deseas ingresar ofertas laborales"});
	arrDivs.push({idComponent:"linkAdministrador",page:"gestionEmpleo.jsp",toolTip:"Si eres un administrador del sistema"});
	arrDivs.push({idComponent:"linkContacto",page:"contactanos.jsp?CWMOD_CODIGO=CWMOD1",toolTip:"Ver los datos de contactos de gesti&oacute;n de empleo"});
	arrDivs.push({idComponent:"linkPreguntas",page:"preguntasFrecuentes.jsp?CWMOD_CODIGO=CWMOD1",toolTip:'Mira o registra preguntas sobre gesti&oacute;n de empleo'});

	/*Menu de Pre-registro de TCT*/
	arrDivs.push({parent:true,idComponent:"divPreRegistroTCT",page:"ingresoTCT.jsp"});
	
	/*Menu de Pre-registro de Usuarios*/
	arrDivs.push({parent:true,idComponent:"divUsuarios",page:"cambiarContrasenia.jsp"});	
	
	/*Menu de Desarrollo Humano*/
	arrDivs.push({parent:true,items:true,idComponent:"divDesarrollo",page:"listadoCurso.jsp"});	
	arrDivs.push({idComponent:"linkPreregistrocurso",page:"listadoCurso.jsp",toolTip:"Ver los datos de contactos de desarrollo humano"});
	arrDivs.push({idComponent:"linkContactoDH",page:"contactanos.jsp?CWMOD_CODIGO=CWMOD4",toolTip:"Ver los datos de contactos de desarrollo humano"});
	arrDivs.push({idComponent:"linkPreguntasDH",page:"preguntasFrecuentes.jsp?CWMOD_CODIGO=CWMOD4",toolTip:'Mira o registra preguntas sobre desarrollo humano'});

	
	/*Menu de Tramites*/
	arrDivs.push({parent:true,items:true,idComponent:"divTramitesResidencia"});	
	arrDivs.push({idComponent:"btnIngresoTramites",page:"tramiteResidencia.jsp"});	
	arrDivs.push({idComponent:"btnConsultaTramites",page:"consultaTramite.jsp"});	
	arrDivs.push({idComponent:"btnRequisitosTramites",page:"requisitosTipoSolicitud.jsp"});
    arrDivs.push({idComponent:"btnImpresionSolicitud",page:"impresionSolicitud.jsp"});
	arrDivs.push({idComponent:"linkContactoR",page:"contactanos.jsp?CWMOD_CODIGO=CWMOD3"});
	arrDivs.push({idComponent:"linkPreguntasR",page:"preguntasFrecuentes.jsp?CWMOD_CODIGO=CWMOD3"});
	
	/*Menu de Tramites vehiculos*/
	arrDivs.push({parent:true,items:true,idComponent:"divTramitesVehiculo"});	
	arrDivs.push({idComponent:"btnIngresoTramitesV",page:"tramiteVehiculo.jsp"});	
	arrDivs.push({idComponent:"linkContactoV",page:"contactanos.jsp?CWMOD_CODIGO=CWMOD5"});
	arrDivs.push({idComponent:"linkPreguntasV",page:"preguntasFrecuentes.jsp?CWMOD_CODIGO=CWMOD5"});
	/*arrDivs.push({idComponent:"btnConsultaTramitesV",page:"consultaTramite.jsp"});	
	arrDivs.push({idComponent:"btnRequisitosTramitesV",page:"tramiteVehiculo.jsp"});		
	*/
	for (k=0; k<arrDivs.length;k++){		
		var tmpComp = document.getElementById(arrDivs[k].idComponent);
		if (arrDivs[k].items){
			tmpComp.onmouseover = function(){this.style.backgroundColor = "#E6E6E6";}
			tmpComp.onmouseout = function(){this.style.backgroundColor = "#F5F5F5";}
			//document.getElementById(tmpComp.id+"-Items").style.display = 'none';
		}
		tmpComp.onclick=moduloOnClick;
		if (arrDivs[k].toolTip)	
			tmpComp.title=arrDivs[k].toolTip;
	}
	
	document.getElementById("linkAdministrador").onclick=function(){
		window.open('/sii/','_blank');
	}
}

function setOptionModuloSeleccionado(idModulo){
	document.getElementById("btnBuscarEmpleo").style.display="none";
	document.getElementById("btnHojaVida").style.display="none";
	document.getElementById("btnAplicaciones").style.display="none";
	document.getElementById("btnDenunciaSugerencia").style.display="none";
	document.getElementById("btnSubscripcionCargos").style.display="none";
	document.getElementById("btnEmpresasRegistradas").style.display="none";
	document.getElementById("btnDesactivarCuenta").style.display="none";
	document.getElementById("loading").style.display="none";
	document.getElementById("divIndicador").style.display="none";
	document.getElementById("btnRegistroEmpresa").style.display="none";	
	document.getElementById("btnAccederSistema").style.display="none";	
	$("divIndicador").style.display="none";
	if(idModulo == "linkCandidatos"){			
		pnlGestionEmpleo.style.display="block";				
		if (txtUsuario.value!="false"){			
			document.getElementById("btnHojaVida").onclick=function(){document.getElementById("iFrameBody").src="hojaVida.jsp";}
			document.getElementById("btnDenunciaSugerencia").onclick=function(){document.getElementById("iFrameBody").src="denunciaSugerencia.jsp";}
			document.getElementById("btnSubscripcionCargos").onclick=function(){document.getElementById("iFrameBody").src="subscripcionCargo.jsp";}
			document.getElementById("btnAplicaciones").onclick=function(){document.getElementById("iFrameBody").src="ofertasByUsuario.jsp";}
			document.getElementById("btnActivarCuenta").onclick=function(){document.getElementById("iFrameBody").src="activarCuentaGestionEmpleo.jsp";}
			document.getElementById("btnDesactivarCuenta").onclick=function(){document.getElementById("iFrameBody").src="desactivarCuentaGestionEmpleo.jsp";}
			document.getElementById("btnBuscarEmpleo").onclick=function(){document.getElementById("iFrameBody").src="gestionEmpleo.jsp";}
			document.getElementById("btnEmpresasRegistradas").onclick=function(){document.getElementById("iFrameBody").src="listadoEmpresas.jsp";}
			document.getElementById("btnComunicadoRadial").onclick=function(){document.getElementById("iFrameBody").src="comunicadoRadial.jsp";}			
			document.getElementById("btnAccederSistema").onclick=function(){window.open('/sii','_blank');}
			if (RolUsuario == "CSROL_GEAPL"){
				document.getElementById("divIndicador").style.display="none";
				document.getElementById("btnBuscarEmpleo").style.display="block";
				document.getElementById("btnHojaVida").style.display="block";
				document.getElementById("btnAplicaciones").style.display="block";
				document.getElementById("btnDenunciaSugerencia").style.display="block";
				document.getElementById("btnSubscripcionCargos").style.display="block";
				document.getElementById("btnEmpresasRegistradas").style.display="block";
				document.getElementById("btnDesactivarCuenta").style.display="block";
				$("divIndicador").style.display="block";
			}else {				
				document.getElementById("btnActivarCuenta").style.display="block";			
			}
		}else{
			$("btnInfoAdicional").style.fontSize ="11";
			$("btnInfoAdicional").innerHTML = "Por favor presione el bot&oacute;n <b>Ingresar</b>, del panel superior para para acceder a las opciones del sistema"
			document.getElementById("btnInfoAdicional").style.display="block";
		}
	}else if(idModulo == "linkEmpresas"){		
		pnlGestionEmpleo.style.display="block";
		if (txtUsuario.value!="false"){
			pnlGestionEmpleo.style.display="block";
			document.getElementById("btnRegistroEmpresa").onclick=function(){document.getElementById("iFrameBody").src="registroDatosEmpresa.jsp";}
			document.getElementById("btnDenunciaSugerencia").onclick=function(){document.getElementById("iFrameBody").src="denunciaSugerencia.jsp";}
			document.getElementById("btnDenunciaSugerencia").style.display="block";
			document.getElementById("btnRegistroEmpresa").style.display="block";	
			document.getElementById("btnAccederSistema").style.display="block";	
		}else{
			$("btnInfoAdicional").style.fontSize ="11";
			$("btnInfoAdicional").innerHTML = "<ul><li>Si desea registrar su empresa por favor de click en <b>Ingresar</b> del panel superior.</li><li>Si desea registrar ofertas de empleo click <a href='/sii/'><b>aqu&iacute;</b></a></li></ul>";
			document.getElementById("btnInfoAdicional").style.display="block";			
		}
	}
}