function loadOfertasByUsuario(){	
	setHeightForm();
	var userObject;
	var codigoCandidato;	
	var winAplicar =$("winAplicar");
	var txtUsuario = $("txtUsuario");
	var txtAplico = $("txtAplico");
	var codigoVacante = $("txtCodigoVacante").value;
	var codigoUsuario = $("txtCodigoUsuario").value;	
	var RolUsuario = "";
	$("lnkAtras").href="ofertasByUsuario.jsp";
	if ($("txtView").value != "true"){
		$("lnkAtras").href="gestionEmpleo.jsp";
		
		$("divAvisoInfo").style.display = (txtAplico.value=="1")?"block":"none";
		
		if (txtUsuario.value !="false"){		
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
			codigoCandidato=userObject.CUSU_CODIGO;
			if ($("txtUsuario").value!="false"){
				function CallBackRolUsuario(r){
					RolUsuario = r;
				}   
				SOAPClient.invoke(URL_WS+"Cgg_gem_vacante", "getRolUsuario", null, false, CallBackRolUsuario);  
			}
		}    
		$("divAviso").style.display = (txtUsuario.value=="false" || RolUsuario!="CSROL_GEAPL")?"block":"none";
		$("divAplicar").style.display = (txtUsuario.value=="false" || txtAplico.value=="1" || RolUsuario!="CSROL_GEAPL")?"none":"block";
	}
	var divAplicar=$("divAplicar");
	divAplicar.onclick=function(){
		divAplicar.style.display = 'none';
		$('divAplicando').style.display = 'block';
		function callBackAplicar(v,req){
			if(req.status == 500){				
				new bsxMessageBox({
					title:"Aplicar",
					msg:getErrorMessage(v.message),
					icon:"iconError"
				});
				$('divAplicando').style.display = 'none';
				divAplicar.style.display = 'block';
			}else{
				if (v=="true"){
					function CallBackIndicador1(r){			
						var res = eval(r);
						parent.document.getElementById('divIndicador').innerHTML = "<table style='font-size:11'>"+				
							"<tr><td>Visto por empresas:</td><td><b>"+res[0].OBSERVADO+"</b></td></tr>"+
							"<tr><td>Aplicaciones realizadas:</td><td><b>"+res[0].APLICACIONES+"</b></td></tr>"+
							"<tr><td>Inasistenacias a entrevistas:</td><td><b>"+res[0].FALTA+"</b></td></tr>"+
						"</table>";						
					}	
					var param = new SOAPClientParameters(); 		
					param.add('inCusu_codigo',codigoCandidato);		
					SOAPClient.invoke(URL_WS+"Cgg_atc_gestion_empleo", "selectEstadistica", param, false, CallBackIndicador1);
				
					divModalAplicar.style.display="none";					
					winAplicar.style.display="none";	
					new bsxMessageBox({
						title:"Aplicar",
						msg:"Felicidades, desde este momento usted forma parte como candidato de la oferta!",
						icon:"iconInfo",
						close:function(){							
							document.location = "gestionEmpleo.jsp";
						}
					});
					
				}
			}			
		}
		var param = new SOAPClientParameters();
		param.add('inCusu_codigo',codigoCandidato);
		param.add('inCgvcn_codigo',codigoVacante);
		param.add('inCgcnd_aspiracion_salarial',null);
		param.add('inCgcnd_observacion',null);
        SOAPClient.invoke(URL_WS+"Cgg_gem_candidato","insert",param, true, callBackAplicar);
	}
	presentarDatosOferta(codigoVacante);	
	
	function datosEmpresa(ro){
		function CallBackCgg_gem_usuario_info(r,req){			
			if(req.status == 500){
				//alert("sadasds");
			}
			var rw = eval(r)[0];			
			if (!rw.CRPJR_CODIGO){				
				$("thNombreEmpresaPersona").innerHTML = 'Persona:';
				$("tdEmpresa").innerHTML = rw.CRPER_NOMBRES+' '+rw.CRPER_APELLIDO_PATERNO;
			}else{
				$("thNombreEmpresaPersona")?$("thNombreEmpresaPersona").innerHTML = 'Empresa:':'';
				$("tdEmpresa").innerHTML = rw.CRPJR_RAZON_SOCIAL;				
			}	
			$("tdCGCRG_NOMBRE").innerHTML = ro.CGCRG_NOMBRE;			
			$("tdCGVCN_DIRECCION").innerHTML = ro.CGVCN_DIRECCION;			
			$("tdCGVCN_TITULO").innerHTML = ro.CGARE_NOMBRE;			
//				$("tdCGARE_NOMBRE").innerHTML = ro.CGARE_NOMBRE;			
			$("tdCGVCN_DESCRIPCION").innerHTML = ro.CGVCN_DESCRIPCION;			
			$("tdCGTCN_DESCRIPCION").innerHTML = ro.CGTCN_DESCRIPCION;			
			$("tdCGVCN_NUMERO_VACANTES").innerHTML = ro.CGVCN_NUMERO_VACANTES;			
			$("tdCGVCN_SALARIO").innerHTML = ro.CGVCN_SALARIO +" "+ ro.CGTSA_NOMBRE;
		}
		var param = new SOAPClientParameters();
		param.add("inCusu_codigo",codigoUsuario);
		param.add("format","JSON");
		SOAPClient.invoke(URL_WS+"Cgg_atc_gestion_empleo", "selectInformacionUsuario", param, true, CallBackCgg_gem_usuario_info);
	}
	
	function presentarDatosOferta(codigoVacante){		
		function CallBackCgg_gem_oferta_detalle(r){			
			var cadena = eval(r);			
			datosEmpresa(cadena[0]);
			fnRequisitos();
		};
		var param = new SOAPClientParameters();
		param.add("inCgvcn_codigo",codigoVacante);
		param.add("format","JSON");
		SOAPClient.invoke(URL_WS+"Cgg_atc_gestion_empleo", "select", param, true, CallBackCgg_gem_oferta_detalle);
	}
	$("tdRequisitos").innerHTML = "<img src='css/icon/cargando.gif'/>"
	function fnRequisitos(){
		function CallBackCgg_gem_requisitos(record){			
			var r = eval(record);						
			var cadena='<ul>';
			for (i=0;i<r.length;i++)
				cadena += '<li>'+r[i].CGRVC_REQUISITO + ' </li> ';
			cadena+='</ul>';
			$("tdRequisitos").innerHTML = cadena;
			setHeightForm();
		};
		var param = new SOAPClientParameters();
		param.add("inCgvcn_codigo",codigoVacante);		
		SOAPClient.invoke(URL_WS+"Cgg_atc_gestion_empleo", "selectFKVacante", param, true, CallBackCgg_gem_requisitos);
	}	
}
	