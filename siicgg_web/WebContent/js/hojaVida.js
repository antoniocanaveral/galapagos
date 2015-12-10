
function loadHojaVida(){	
	new SpinnerControl('numCgppr_nivel_aprobado', 'up2', 'dn2', {
		interval: 1,
		round: 0,
		max: 15,
		min: 1
	});
	new SpinnerControl('txtCginf_hijos', 'up3', 'dn3', {
		interval: 1,
		round: 0,
		max: 15,
		min: 0
	});
	new SpinnerControl('cgcer_duracion', 'up4', 'dn4', {
		interval: 1,
		round: 0,
		max: 500,
		min: 0
	});
	/**
	*	Permite crear un nuevo formulario para ingresos o modificaciones de datos
	**/
	function showForm(frm){
		document.getElementById("divBgModal").style.display="block";
		frm.style.display="block";	
	}
	
	/**
	*	DETERMINA DATOS RELACIONADOS CON EL USUARIO LOGONEADO.
	**/
	if (document.getElementById("txtUsuario").value =="false")return;
	document.getElementById("divTablaHojaVida").display="block";
	var userObject;	
	var url = URL_WS+"SessionManager?request=userobject";
	new Ajax.Request(url, {
		method: 'get',
		asynchronous : false,
		onSuccess: function(transport) {
			userObject = eval("("+transport.responseText+")");
		},
		onFailure: function(transport) {
		}
	});
	var codigoPersona=userObject.CRPER_CODIGO;		
	cargarImagenCurriculum();
	var fileFoto = document.getElementById("frmFotoCurriculum");
	fileFoto.action = URL_WS+"Cgg_res_persona_fotoCurriculumSRV";
	/**
	*	Panel del tab Panel principal de Hoja de Vida
	**/
	var tabInfo = new bsxTabPanel({
		id:"tabInfo",
		width:690,
		renderTo:"divTabInfo",
		items:[
			{id:"prf",width:80,title:"Perfil",toolTip:'Perfil profesional',contentId:"FrmPresentacionPerfil"},
			{id:"inf",width:80,title:"Informaci\u00F3n adicional",toolTip:'Informaci\u00F3n adicional',contentId:"FrmListadoInformacionLaboral"},
			{id:"cer",width:80,title:"Cursos realizados",toolTip:'Descripci\u00F3n de los cursos realizados',contentId:"FrmListadoCertificado"},			
			{id:"exp",width:80,title:"Experiencia",toolTip:'Experiencia laboral en sus distintos campos de empleo',contentId:"FrmListadoExperienciaLaboral"},
			{id:"des",width:80,title:"Destrezas",toolTip:'Descripci\u00F3n de sus destrezas y habilidades ',contentId:"FrmListadoDestrezaPersona"},
			{id:"idi",width:80,title:"Idiomas",toolTip:'Listado de idiomas que practica',contentId:"FrmListadoIdiomaPersona"},			
		],
		events:{
			tabSelect:function(v){				
				if(('tabFrmPresentacionPerfil')==v){
					
				}
				if('tabFrmListadoInformacionLaboral'==v){
					fnLoadInformacionLaboral();
				}
				if(('tabFrmListadoCertificado')==v){
					grdCertificadoPersona.reload();
					grdPerfilAdjuntoCertificado.reload();
				}
				if(('tabFrmListadoExperienciaLaboral')==v){
					grdExperienciaLaboral.reload();	
				}
				if(('tabFrmListadoDestrezaPersona')==v){
					grdDestrezaPersona.reload();
					grdHabilidadesPersona.reload();
					cbxDestrezas.reload();	
					cbxHabilidades.reload();
				}
				if(('tabFrmListadoIdiomaPersona')==v){
					grdIdiomaPersona.reload();
					cbxIdiomas.reload();
				}
			}
		}
	});
	
	
	/**
	*	VARIABLES PARA DATOS DE LA PERSONA
	**/
	var imgFotoCurriculum = document.getElementById("imgFotoCurriculum");		
	var frmFotoCurriculum = document.getElementById("frmFotoCurriculum");
	var crper_foto_curriculum = document.getElementById("crper_foto_curriculum");
	var btnSubirFoto = document.getElementById("btnSubirFoto");	
	var txtCrper_request = document.getElementById("txtCrper_request");
	var txtCrper_codigo = document.getElementById("txtCrper_codigo");
	var tdNombres = document.getElementById("tdNombres");
	var tdApellidos = document.getElementById("tdApellidos");
	var tdDocumentoIdentidad = document.getElementById("tdDocumentoIdentidad");
	var tdFechaNacimiento = document.getElementById("tdFechaNacimiento");
	var tdGenero = document.getElementById("tdGenero");	
	var tdEstadoCivil = document.getElementById("tdEstadoCivil");
	var tdNumeroHijos = document.getElementById("tdNumeroHijos");
	var tdNacionalidad = document.getElementById("tdNacionalidad");
	var tdPais = document.getElementById("tdPais");
	var tdProvincia = document.getElementById("tdProvincia");
	var tdCanton = document.getElementById("tdCanton");
	var tdParroquia = document.getElementById("tdParroquia");
	var tdEstadoLaboral = document.getElementById("tdEstadoLaboral");
	var chkEstadoLaboral = document.getElementById("chkEstadoLaboral");
	var cgg_cpais_codigo = document.getElementById("cgg_cpais_codigo");
	var cctn_codigo = document.getElementById("cctn_codigo");
	var cprr_codigo = document.getElementById("cprr_codigo");
	var crper_empleado = document.getElementById("crper_empleado");
	var gbxEstadoLaboral = $("gbxEstadoLaboral");
	var swCiudad = false;
	var swDatosPersona = false;
	var swProvincia = false;
	var swPais = false;
	
	txtCrper_codigo.value = codigoPersona;
	txtCrper_request.value = 'update';
	var tmpFormulario = 0;
	/**
	*	FUNCION QUE PERMITE VISUALIZAR SI LOS ADJUNTO FUERON O NO ALMACENADOS
	**/
	function fnSubirImagen(){			
		var a = eval('('+this.contentDocument.body.childNodes[0].data+')');
		if (a.success ==true ){			
			if (tmpFormulario == 1){
				grdPerfilAdjunto.reload();
				btnSalirAll(FrmPerfilAdjunto);			
			}else{
				if(tmpFormulario == 2){
					grdPerfilAdjuntoCertificado.reload();					
					divBgModal.style.display="block";
					FrmPerfilAdjuntoCertificado.style.display="block";
					btnSalirAll(FrmPerfilAdjuntoCertificado);			
				}else{
					cargarImagenCurriculum();				
				}
			}
			tmpFormulario = 0;
		}else{	
			divBgModal.style.display="none";
			FrmPerfilAdjuntoCertificado.style.display="none";

		}
		if(tmpFormulario != 1 && tmpFormulario != 2){
			cargarImagenCurriculum();
		}
		btnSalirAll($("divAlmacenando"));
	}
	
	btnSubirFoto.onclick = function(){		
		cgg_cpais_codigo.value = cbxPais.dom.value;
		cctn_codigo.value = cbxCiudad.dom.value;
		cprr_codigo.value = cbxParroquia.dom.value;		
		crper_empleado.value = gbxEstadoLaboral.checked;
		document.getElementById('upload_target').onload = fnSubirImagen;
		frmFotoCurriculum.submit();
		$("imgCargando").style.visibility = 'visible';
	}

	
	function cargarImagenCurriculum(){
		/**
		*	LOAD FOTO CURRICULUM
		*/
		function CallBackSelectCgg_res_personaFoto(v){
			var a = eval('('+v+')');
			if(a.length>0){					
				if(a[0].FOTO_CURRICULUM)
					imgFotoCurriculum.src = "data:image/jpg;base64," + a[0].FOTO_CURRICULUM;
				else
					imgFotoCurriculum.src = "css/image/male_avatar.jpeg"
			}
			$("imgCargando").style.visibility = 'hidden';
		}
		var param = new SOAPClientParameters();				
		param.add('inCrper_codigo',codigoPersona);						
		param.add('format','JSON');		
		SOAPClient.invoke(URL_WS+"Cgg_res_persona","selectFotoCurriculumById",param, true, CallBackSelectCgg_res_personaFoto);
	}
	
	/**
	*	LOAD DATOS DE LA PERSONA PARA LA HOJA DE VIDA
	*/	
	function CallBackSelectCgg_res_persona(v){
		var a = eval('('+v+')');
		if(a.length>0){	
			swDatosPersona = true;
			tdNombres.innerHTML = a[0].CRPER_NOMBRES?a[0].CRPER_NOMBRES:'&nbsp;';
			tdApellidos.innerHTML = (a[0].CRPER_APELLIDO_PATERNO + ' '+a[0].CRPER_APELLIDO_MATERNO)?a[0].CRPER_APELLIDO_PATERNO + ' '+a[0].CRPER_APELLIDO_MATERNO:'&nbsp;';
			tdDocumentoIdentidad.innerHTML = a[0].CRPER_NUM_DOC_IDENTIFIC?a[0].CRPER_NUM_DOC_IDENTIFIC:'&nbsp;';
			tdFechaNacimiento.innerHTML = ((a[0].CRPER_FECHA_NACIMIENTO?a[0].CRPER_FECHA_NACIMIENTO:'&nbsp;').split(" "))[0];
			var v='';
			switch(a[0].CRPER_GENERO){
				case 0:v="Masculino";break;
				case 1:v="Femenino";break;
				default :v="No especificado";break;
			}
			tdGenero.innerHTML = v;			
			tdEstadoCivil.innerHTML = a[0].CRECV_DESCRPCION?a[0].CRECV_DESCRPCION:'&nbsp;';
			tdNumeroHijos.innerHTML = a[0].CGINF_HIJOS?a[0].CGINF_HIJOS:0;
			tdNacionalidad.innerHTML = a[0].CGNCN_NACIONALIDAD?a[0].CGNCN_NACIONALIDAD:'&nbsp;';
			codigoPais = a[0].CGG_CPAIS_CODIGO?a[0].CGG_CPAIS_CODIGO:'&nbsp;';
			if(swPais==true)
				cbxPais.dom.value = a[0].CGG_CPAIS_CODIGO?a[0].CGG_CPAIS_CODIGO:'&nbsp;';			
			codigoCiudad = a[0].CCTN_CODIGO;
			if (swCiudad==true)
				cbxCiudad.dom.value = a[0].CCTN_CODIGO;
			cbxParroquia.dom.value = a[0].CPRR_CODIGO?a[0].CPRR_CODIGO:'&nbsp;';
			codigoProvincia = a[0].CGPRV_CODIGO;
			if (swProvincia == true)
				cbxProvincia.dom.value = a[0].CGPRV_CODIGO;
			gbxEstadoLaboral.checked = a[0].CRPER_EMPLEADO?a[0].CRPER_EMPLEADO:false;
			try{
				if(!imgFotoCurriculum.src){
					var img = '';
					switch(a[0].CRPER_GENERO){
						case 0:img="css/image/male_avatar.jpeg";break;
						case 1:img="css/image/female_avatar.jpg";break;
						default :img="css/image/male_avatar.jpeg";break;
					}
					imgFotoCurriculum.src = img;
				}
			}catch(ex){
			}
		}
	}
	var param = new SOAPClientParameters();				
	param.add('inCrper_codigo',codigoPersona);						
	param.add('format','JSON');		
	
	SOAPClient.invoke(URL_WS+"Cgg_res_persona","selectDatosPersonalesById",param, true, CallBackSelectCgg_res_persona);
	
	/*VARIABLES DE LOS COMPONENTES DE INFORMACION LABORAL*/
	var FrmListadoInformacionLaboral = document.getElementById("FrmListadoInformacionLaboral");
	var chkCginf_trab_otra_ciudad = document.getElementById("chkCginf_trab_otra_ciudad");
	var txtCrper_aspiracion_salarial = document.getElementById("txtCrper_aspiracion_salarial");
	var txtCginf_disponibilidad = document.getElementById("txtCginf_disponibilidad");
	var txtCginf_hijos = document.getElementById("txtCginf_hijos");
	var txtCginf_Calificacion = document.getElementById("txtCginf_Calificacion");
	var txtCginf_licencia_cond = document.getElementById("txtCginf_licencia_cond");
	var cbmCginf_estado_laboral = document.getElementById("cbmCginf_estado_laboral");	
	var cbmCginf_obserbaciones = document.getElementById("cbmCginf_obserbaciones");	
	var btnCginf_Guardar = document.getElementById("btnCginf_Guardar");	
	var isEditInformacionLaboral;
	var metodoInformacionLaboral;
	var codigoInformacionLaboral;
	
	txtCrper_aspiracion_salarial.onkeypress = function(){
		if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;
	}
	txtCginf_hijos.onkeypress = function(){
		if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;
	}
	
	/*VARIABLES DE LOS COMPONENTES DE IDIOMAS*/	
	var divBgModal = document.getElementById("divBgModal");
	var FrmListadoIdiomaPersona = document.getElementById("FrmListadoIdiomaPersona");
	var FrmIdiomaPersona = document.getElementById("FrmIdiomaPersona");
	var txtCgidp_codigo = document.getElementById("txtCgidp_codigo");
	var numCgidp_escritura = document.getElementById("numCgidp_escritura");
	var numCgidp_lectura = document.getElementById("numCgidp_lectura");
	var numCgidp_hablar = document.getElementById("numCgidp_hablar");
	var numCgidp_escuchar = document.getElementById("numCgidp_escuchar");
	var btnGuardarCgg_gem_idioma_persona = document.getElementById("btnGuardarCgg_gem_idioma_persona");
	var btnNuevoCgg_gem_idioma_persona = document.getElementById("btnNuevoCgg_gem_idioma_persona");
	var btnEditarCgg_gem_idioma_persona = document.getElementById("btnEditarCgg_gem_idioma_persona");
	var btnEliminarCgg_gem_idioma_persona = document.getElementById("btnEliminarCgg_gem_idioma_persona");
	
	document.getElementById("btnSalirCgg_gem_idioma_persona").onclick=function(){
		btnSalirAll(FrmIdiomaPersona);
	}
	
	btnEditarCgg_gem_idioma_persona.onclick=function(){	
		if (txtCgidp_codigo.value){
			numCgidp_escritura.focus();
			divBgModal.style.display="block";
			FrmIdiomaPersona.style.display="block";	
			cbxIdiomas.dom.disabled = true;
		}else{
			new bsxMessageBox({
				title:"Idiomas",
				msg:"Seleccione un idioma",
				icon:"iconInfo"
			});
		}
	}
	
	var metodoIdiomaPersona;
	
	/*VARIABLES DE LOS COMPONENTES DE CERTIFICADOS*/
	var FrmListadoCertificado = document.getElementById("FrmListadoCertificado");
	var FrmCertificado = document.getElementById("FrmCertificado");
	var cgcer_codigo = document.getElementById("cgcer_codigo");
	var crper_codigo = document.getElementById("crper_codigo");
	crper_codigo.value=codigoPersona;
	var cgcer_tipo = document.getElementById("cgcer_tipo");
	var cgcer_institucion = document.getElementById("cgcer_institucion");
	var cgcer_nombre = document.getElementById("cgcer_nombre");
	var cgcer_descripcion = document.getElementById("cgcer_descripcion");
	var cgcer_duracion = document.getElementById("cgcer_duracion");
	var cgcer_observacion = document.getElementById("cgcer_observacion");	
	var cgcer_fecha_inicio = document.getElementById("cgcer_fecha_inicio");
	var cgcer_fecha_fin = document.getElementById("cgcer_fecha_fin");
	var cgcer_tipo_adjunto = document.getElementById("cgcer_tipo_adjunto");
	var cgcer_nombre_adjunto = document.getElementById("cgcer_nombre_adjunto");

	var txtRequest = document.getElementById("request");
	var btnNuevoCgg_gem_certificado = document.getElementById("btnNuevoCgg_gem_certificado");
	var btnEditarCgg_gem_certificado = document.getElementById("btnEditarCgg_gem_certificado");
	var btnEliminarCgg_gem_certificado = document.getElementById("btnEliminarCgg_gem_certificado");
	var btnGuardarCgg_gem_certificado = document.getElementById("btnGuardarCgg_gem_certificado");
	var btnSalirCgg_gem_certificado = document.getElementById("btnSalirCgg_gem_certificado");
	var metodoCertificado = '';
	/*
	*Componente Fecha para perfil profesional
	*/
	new JsDatePick({
        useMode:2,
        target:"cgcer_fecha_inicio",
        dateFormat:"%Y-%m-%d",
        imgPath:"../css/image/jsdatepicker/"		
    });
	new JsDatePick({
        useMode:2,
        target:"cgcer_fecha_fin",
        dateFormat:"%Y-%m-%d",
        imgPath:"../css/image/jsdatepicker/"		
    });
	
	
	btnNuevoCgg_gem_certificado.onclick=function(){
		metodoCertificado = 'insert';
		limpiarControlesExperienciaLaboral();	
		txtRequest.value="INSERT";
		showForm(FrmCertificado);
	}	
	btnEditarCgg_gem_certificado.onclick=function(){
		if(cgcer_codigo.value){
			metodoCertificado = 'update';
			showForm(FrmCertificado);
			txtRequest.value="UPDATE";
		}else{
			new bsxMessageBox({
				title:"Certificados",
				msg:"Seleccione un certificado",
				icon:"iconInfo"
			});
		}
	}	
	btnSalirCgg_gem_certificado.onclick=function(){btnSalirAll(FrmCertificado);}
	btnGuardarCgg_gem_certificado.onclick=function(){
		if(cgcer_fecha_inicio.value>cgcer_fecha_fin.value){		
			new bsxMessageBox({
					title:"Fechas",
					msg:"La fecha de finalizaci\u00F3n no puede ser menor que la fecha de inicio",
					icon:"iconError",
					close:function(){
						cgcer_fecha_fin.focus();						
					}
			});			
			return;
		}
		
		function CallBackCgg_gem_certificadofrm(r){			
			if(r=='true'){
				grdCertificadoPersona.reload();
				btnSalirAll(FrmCertificado);
			}else{
				new bsxMessageBox({
					title:"Adjuntos",
					msg:"Los datos no han podido ser eliminado.",
					icon:"iconInfo"
				});					
			}
			metodoCertificado='';
		}		
		if(!metodoCertificado){
			return;
		}
		var param = new SOAPClientParameters();
		if(metodoCertificado == 'update' && cgcer_codigo.value.length>0){
			param.add('inCgcer_codigo',cgcer_codigo.value);
		}
		param.add('inCrper_codigo',codigoPersona);
		param.add('inCgcer_institucion',cgcer_institucion.value);
		param.add('inCgcer_nombre',cgcer_nombre.value);
		param.add('inCgcer_descripcion', cgcer_descripcion.value);
		param.add('inCgcer_duracion',cgcer_duracion.value);
		param.add('inCgcer_fecha_inicio',(cgcer_fecha_inicio.value.length!=0)?cgcer_fecha_inicio.value+'T00:00:00':null);
		param.add('inCgcer_fecha_fin',(cgcer_fecha_fin.value.length!=0)?cgcer_fecha_inicio.value+'T00:00:00':null);		
		param.add('inCgcer_tipo_adjunto','');
		param.add('inCgcer_nombre_adjunto','');
		param.add('inCgcer_adjunto','');
		param.add('inCgcer_observacion',cgcer_observacion.value);
		param.add('inCgcer_tipo',cgcer_tipo.value);		
		SOAPClient.invoke(URL_WS+"Cgg_gem_certificado",metodoCertificado,param, true, CallBackCgg_gem_certificadofrm);
	}
	
	
	/*VARIABLES DE LOS COMPONENTES DE EXPERIENCIA LABORAL*/
	var FrmListadoExperienciaLaboral = document.getElementById("FrmListadoExperienciaLaboral");
	var FrmExperienciaLaboral = document.getElementById("FrmExperienciaLaboral");
	var txtCgexl_codigo = document.getElementById("txtCgexl_codigo");
	var txtCgexl_razon_social = document.getElementById("txtCgexl_razon_social");
	var txtCgexl_ciudad = document.getElementById("txtCgexl_ciudad");
	var txtCgexl_cargo = document.getElementById("txtCgexl_cargo");
	var txtCgexl_descripcion = document.getElementById("txtCgexl_descripcion");
	var dtCgexl_fecha_inicio = document.getElementById("dtCgexl_fecha_inicio")||'';
	var dtCgexl_fecha_fin = document.getElementById("dtCgexl_fecha_fin")||'';
	var numCgexl_personas_cargo = document.getElementById('numCgexl_personas_cargo');
	var txtCgexl_contacto = document.getElementById("txtCgexl_contacto");
	var txtCgexl_telefono = document.getElementById("txtCgexl_telefono");
	var txtCgexl_observaciones = document.getElementById("txtCgexl_observaciones");
	var btnNuevoCgg_gem_experiencia_laboral = document.getElementById("btnNuevoCgg_gem_experiencia_laboral");
	var btnEditarCgg_gem_experiencia_laboral = document.getElementById("btnEditarCgg_gem_experiencia_laboral");
	var btnGuardarCgg_gem_experiencia_laboral = document.getElementById("btnGuardarCgg_gem_experiencia_laboral");
	var btnSalirCgg_gem_experiencia_laboral = document.getElementById("btnSalirCgg_gem_experiencia_laboral");
	var btnEliminarCgg_gem_experiencia_laboral = document.getElementById("btnEliminarCgg_gem_experiencia_laboral");
	var metodoExperienciaLaboral;
	numCgexl_personas_cargo.onkeypress = function(){
		if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;
	}
	txtCgexl_telefono.onkeypress = function(){
		if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;
	}
	/*
	*Componente Fecha para experiencia Laboral
	*/
	new JsDatePick({
        useMode:2,
        target:"dtCgexl_fecha_inicio",
        dateFormat:"%Y-%m-%d",
        imgPath:"../css/image/jsdatepicker/"		
    });
	new JsDatePick({
        useMode:2,
        target:"dtCgexl_fecha_fin",
        dateFormat:"%Y-%m-%d",
        imgPath:"../css/image/jsdatepicker/"		
    });
	
	btnNuevoCgg_gem_experiencia_laboral.onclick=function(){
		limpiarControlesExperienciaLaboral();	
		showForm(FrmExperienciaLaboral);
	}
	
	btnEditarCgg_gem_experiencia_laboral.onclick=function(){
		if(txtCgexl_codigo.value){
			showForm(FrmExperienciaLaboral);	
		}else{
			new bsxMessageBox({
				title:"Experiencia Laboral",
				msg:"Seleccione un dato",
				icon:"iconInfo"
			});
		}
	}
	
	btnSalirCgg_gem_experiencia_laboral.onclick=function(){
		btnSalirAll(FrmExperienciaLaboral);
	}
	
	/*VARIABLES DE LOS COMPONENTES DE DESTREZA DE LA PERSONA*/
	var FrmListadoDestrezaPersona = document.getElementById("FrmListadoDestrezaPersona");
	var FrmDestrezaPersona = document.getElementById("FrmDestrezaPersona");
	var txtCgdpr_codigo = document.getElementById("txtCgdpr_codigo");
	var txtCgdst_codigo = document.getElementById("txtCgdst_codigo");
	var btnGuardarCgg_gem_destreza_persona = document.getElementById("btnGuardarCgg_gem_destreza_persona");
	var btnNuevoCgg_gem_destreza_persona = document.getElementById("btnNuevoCgg_gem_destreza_persona");
	var btnEditarCgg_gem_destreza_persona = document.getElementById("btnEditarCgg_gem_destreza_persona");
	var btnEliminarCgg_gem_destreza_persona = document.getElementById("btnEliminarCgg_gem_destreza_persona");
	
	document.getElementById("btnSalirCgg_gem_destreza_persona").onclick=function(){
	var btnNuevoCgg_gem_habilidades_persona = document.getElementById("btnNuevoCgg_gem_habilidades_persona");
	var btnEditarCgg_gem_habilidades_persona = document.getElementById("btnEditarCgg_gem_habilidades_persona");
	var btnEliminarCgg_gem_habilidades_persona = document.getElementById("btnEliminarCgg_gem_habilidades_persona");
	var btnGuardarCgg_gem_habilidades_persona = document.getElementById("btnGuardarCgg_gem_habilidades_persona");
	var btnSalirCgg_gem_habilidades_persona = document.getElementById("btnSalirCgg_gem_habilidades_persona");
	var txtCgdpr_codigoHabilidades = document.getElementById("txtCgdpr_codigoHabilidades");
	}
	document.getElementById("btnSalirCgg_gem_destreza_persona").onclick=function(){

		btnSalirAll(FrmDestrezaPersona);
	}
	btnSalirCgg_gem_habilidades_persona.onclick = function(){
		btnSalirAll(FrmHabilidadesPersona);
	}
	var metodoDestrezaPersona;
	var metodoHabilidadesPersona;
	
	/*VARIABLES DE LOS COMPONENTES PERFIL PROFESIONAL DE LA PERSONA*/
	var FrmListadoPerfilProfesional = document.getElementById("FrmListadoPerfilProfesional");
	var FrmPerfilProfesionalFrmPerfilProfesional = document.getElementById("FrmPerfilProfesional");
	var txtCgppr_codigo = document.getElementById("txtCgppr_codigo");
	var txtCgien_codigo = document.getElementById("txtCgien_codigo");
	var txtCgtpr_codigo = document.getElementById("txtCgtpr_codigo");
	var txtCgesp_codigo = document.getElementById("txtCgesp_codigo");
	var numCgppr_nivel_aprobado = document.getElementById("numCgppr_nivel_aprobado");
	var dtCgppr_fecha_inicio = document.getElementById("dtCgppr_fecha_inicio");
	var dtCgppr_fecha_fin = document.getElementById("dtCgppr_fecha_fin");
	var chkCgppr_confirmado = document.getElementById("chkCgppr_confirmado");
	var chkCgppr_predeterminado = document.getElementById("chkCgppr_predeterminado");
	var btnNuevoCgg_gem_perfil_profesional = document.getElementById("btnNuevoCgg_gem_perfil_profesional");
	var btnEditarCgg_gem_perfil_profesional = document.getElementById("btnEditarCgg_gem_perfil_profesional");
	var btnEliminarCgg_gem_perfil_profesional = document.getElementById("btnEliminarCgg_gem_perfil_profesional");
	var btnGuardarCgg_gem_perfil_prof = document.getElementById("btnGuardarCgg_gem_perfil_prof");
	var btnSalirCgg_gem_perfil_prof = document.getElementById("btnSalirCgg_gem_perfil_prof");
	var btnListadoCgg_gem_institucion_nivel = document.getElementById("btnListadoCgg_gem_institucion_nivel");	
	var btnListadoCgg_titulo_profesional = document.getElementById("btnListadoCgg_titulo_profesional");
	var btnListadoCgg_especialidad = document.getElementById("btnListadoCgg_especialidad");
	var btnSeleccionarInstitucionNivel = document.getElementById("btnSeleccionarInstitucionNivel");
	var btnSeleccionarTituloProfesional = document.getElementById("btnSeleccionarTituloProfesional");
	var btnSeleccionarEspecialidad = document.getElementById("btnSeleccionarEspecialidad");
	var btnSalirInstitucionNivel = document.getElementById("btnSalirInstitucionNivel");
	var btnSalirTituloProfesional = document.getElementById("btnSalirTituloProfesional");
	var btnSalirEspecialidad = document.getElementById("btnSalirEspecialidad");
	/*
	*Componente Fecha para perfil profesional
	*/
	new JsDatePick({
        useMode:2,
        target:"dtCgppr_fecha_inicio",
        dateFormat:"%Y-%m-%d",
        imgPath:"../css/image/jsdatepicker/"		
    });
	new JsDatePick({
        useMode:2,
        target:"dtCgppr_fecha_fin",
        dateFormat:"%Y-%m-%d",
        imgPath:"../css/image/jsdatepicker/"		
    });
	
	
	var codigoEspecialidad;
	var codigoInstitucionNivel;
	var nombreInstitucion;
	var codigoTituloProfesional;
	var nombreTituloProfesional;
	numCgppr_nivel_aprobado.onkeypress = function(){
		if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;
	}
	
	/*VARIABLES DE LOS COMPONENTES DE CONTACTOS*/	
	var txtCrprc_codigo = document.getElementById("txtCrprc_codigo");
	var txtCrprc_contacto = document.getElementById("txtCrprc_contacto");
	var btnGuardarCgg_gem_contacto_persona = document.getElementById("btnGuardarCgg_gem_contacto_persona");
	var btnSalirCgg_gem_contacto_persona = document.getElementById("btnSalirCgg_gem_contacto_persona");
	var btnNuevoCgg_gem_contacto_persona = document.getElementById("btnNuevoCgg_gem_contacto_persona");
	var btnEditarCgg_gem_contacto_persona = document.getElementById("btnEditarCgg_gem_contacto_persona");
	var btnEliminarCgg_gem_contacto_persona = document.getElementById("btnEliminarCgg_gem_contacto_persona");
	var FrmContactoPersona = document.getElementById("FrmContactoPersona");
	
	
	/*VARIABLES DE LOS COMPONENTES DE PERFIL ADJUNTO*/	
	var FrmListadoPerfilAdjunto = document.getElementById("FrmListadoPerfilAdjunto");
	var FrmPerfilAdjunto = document.getElementById("FrmPerfilAdjunto");	
	var btnNuevoListadoCgg_gem_perfil_adjunto = document.getElementById("btnNuevoListadoCgg_gem_perfil_adjunto");
	var btnEditarListadoCgg_gem_perfil_adjunto = document.getElementById("btnEditarListadoCgg_gem_perfil_adjunto");
	var frmPerfilAdjunto = document.getElementById("frmPerfilAdjunto");
	var cgpfa_codigo = document.getElementById("cgpfa_codigo");
	var crper_codigoAdjunto = document.getElementById("crper_codigoAdjunto");
	crper_codigoAdjunto.value = codigoPersona;
	var cgpfa_descripcion = document.getElementById("cgpfa_descripcion");
	var cgpfa_adjunto = document.getElementById("cgpfa_adjunto");
	var cgpfa_tipo_adjunto = document.getElementById("cgpfa_tipo_adjunto");
	var cgpfa_nombre_adjunto = document.getElementById("cgpfa_nombre_adjunto");
	var requestAdjuntos = document.getElementById("requestAdjuntos");
	var cgpfa_tipo = document.getElementById("cgpfa_tipo");
	
	var btnGuardarCgg_gem_perfil_adjunto = document.getElementById("btnGuardarCgg_gem_perfil_adjunto");
	var btnSalirCgg_gem_perfil_adjunto = document.getElementById("btnSalirCgg_gem_perfil_adjunto");
	var btnAdjuntosCgg_gem_perfil_profesional = document.getElementById("btnAdjuntosCgg_gem_perfil_profesional");
	var btnSalirCggListado_gem_perfil_adjunto = document.getElementById("btnSalirCggListado_gem_perfil_adjunto");
	var btnEliminarListadoCgg_gem_perfil_adjunto = document.getElementById("btnEliminarListadoCgg_gem_perfil_adjunto");
	
	var codigoPerfilProfesional;
	var nombreAdjunto;
	var swPerfilAdjunto = true;
	
	var frmPerfilAdjuntoCertificado = document.getElementById("frmPerfilAdjuntoCertificado");
	var cgpfa_codigoCertificado = document.getElementById("cgpfa_codigoCertificado");
	var crper_codigoCertificado = document.getElementById("crper_codigoCertificado");
	var cgpfa_descripcionCertificado = document.getElementById("cgpfa_descripcionCertificado");
	var cgpfa_adjuntoCertificado= document.getElementById("cgpfa_adjuntoCertificado");
	var cgpfa_tipo_adjuntoCertificado = document.getElementById("cgpfa_tipo_adjuntoCertificado");
	var cgpfa_nombre_adjuntoCertificado = document.getElementById("cgpfa_nombre_adjuntoCertificado");
	var requestAdjuntosCertificado = document.getElementById("requestAdjuntosCertificado");
	var cgpfa_tipoCertificado = document.getElementById("cgpfa_tipoCertificado");
	var btnNuevoListadoCgg_gem_perfil_adjuntoCertificado = document.getElementById("btnNuevoListadoCgg_gem_perfil_adjuntoCertificado");
	var btnEditarListadoCgg_gem_perfil_adjuntoCertificado = document.getElementById("btnEditarListadoCgg_gem_perfil_adjuntoCertificado");
	var btnEliminarListadoCgg_gem_perfil_adjuntoCertificado = document.getElementById("btnEliminarListadoCgg_gem_perfil_adjuntoCertificado");
	var btnGuardarCgg_gem_perfil_adjuntoCertificado = document.getElementById("btnGuardarCgg_gem_perfil_adjuntoCertificado");
	var btnSalirCgg_gem_perfil_adjuntoCertificado = document.getElementById("btnSalirCgg_gem_perfil_adjuntoCertificado");
	var swPerfilAdjuntoCertificado = true;
	btnGuardarCgg_gem_perfil_adjunto.onclick=function(){
		var fileFotoPerfilAdjunto = document.getElementById("frmPerfilAdjunto");
		fileFotoPerfilAdjunto.action = URL_WS+"Cgg_gem_perfil_adjuntoSRV";
		document.getElementById('upload_target').onload = fnSubirImagen;		
		if (swPerfilAdjunto==false)	{
			if(cgpfa_adjunto.value && cgpfa_descripcion.value){
				cgpfa_tipo.value = '0';
				fileFotoPerfilAdjunto.submit();
			}else{
				new bsxMessageBox({
					title:"Adjuntos",
					msg:"Seleccione un Archivo",
					icon:"iconInfo"
				});
				return;
			}
		}else{
			if(cgpfa_descripcion.value){
				cgpfa_tipo.value = '0';
				fileFotoPerfilAdjunto.submit();
			}else{
				new bsxMessageBox({
					title:"Adjuntos",
					msg:"Ingrese la descripci\u00F3n",
					icon:"iconInfo"
				});
				return;
			}
		}
		tmpFormulario = 1;
		
		showForm($("divAlmacenando"));
	}
	btnGuardarCgg_gem_perfil_adjuntoCertificado.onclick=function(){
		frmPerfilAdjuntoCertificado.action = URL_WS+'Cgg_gem_perfil_adjuntoSRV';
		document.getElementById('upload_target').onload = fnSubirImagen;
		
		if (swPerfilAdjuntoCertificado==false)	{
			if(cgpfa_adjuntoCertificado.value && cgpfa_descripcionCertificado.value){
				cgpfa_tipoCertificado.value = '1';				
				frmPerfilAdjuntoCertificado.submit();					
			}else{			
				new bsxMessageBox({
					title:"Adjuntos",
					msg:"Seleccione un Archivo",
					icon:"iconInfo"
				});
				return;
			}
		}else{
			if(cgpfa_descripcionCertificado.value){
				cgpfa_tipoCertificado.value = '1';
				frmPerfilAdjuntoCertificado.submit();
			}else{
				new bsxMessageBox({
					title:"Adjuntos",
					msg:"Ingrese la descripci\u00F3n",
					icon:"iconInfo"
				});
				return;
			}
		}
		tmpFormulario = 2;
		showForm($("divAlmacenando"));
		
	}
	btnEditarListadoCgg_gem_perfil_adjunto.onclick=function(){
		if(cgpfa_codigo.value){
			requestAdjuntos.value = 'update';
			showForm(FrmPerfilAdjunto);		
			swPerfilAdjunto = true;			
		}else{
			new bsxMessageBox({
				title:"Adjunto",
				msg:"Seleccione un Adjunto",
				icon:"iconInfo"
			});
		}
	}
	btnEditarListadoCgg_gem_perfil_adjuntoCertificado.onclick=function(){
		if(cgpfa_codigoCertificado.value){
			requestAdjuntosCertificado.value = 'update';
			showForm(FrmPerfilAdjuntoCertificado);		
			swPerfilAdjuntoCertificado = true;			
		}else{
			new bsxMessageBox({
				title:"Adjunto",
				msg:"Seleccione un Adjunto",
				icon:"iconInfo"
			});
		}
	}
	btnEliminarListadoCgg_gem_perfil_adjunto.onclick = function(){		
		function CallBackCgg_gem_perfil_adjunto(r){			
			if(r=='true'){				
				grdPerfilAdjunto.reload();
			}else{
				new bsxMessageBox({
					title:"Adjuntos",
					msg:"El adjunto no ha podido ser eliminado.",
					icon:"iconInfo"
				});					
		}}		
		if(cgpfa_codigo.value){
			var param = new SOAPClientParameters();
			param.add('inCgpfa_codigo',cgpfa_codigo.value);
			SOAPClient.invoke(URL_WS+"Cgg_gem_perfil_adjunto","delete",param, true, CallBackCgg_gem_perfil_adjunto);
		}else{
			new bsxMessageBox({
				title:"Adjuntos",
				msg:"Selecciones el adjunto a eliminar",
				icon:"iconInfo"
			});		
		}
	}
	btnEliminarListadoCgg_gem_perfil_adjuntoCertificado.onclick = function(){		
		function CallBackCgg_gem_perfil_adjuntoCertificado(r){			
			if(r=='true'){				
				grdPerfilAdjuntoCertificado.reload();
			}else{
				new bsxMessageBox({
					title:"Adjuntos",
					msg:"El adjunto no ha podido ser eliminado.",
					icon:"iconInfo"
				});					
		}}		
		if(cgpfa_codigoCertificado.value){
			var param = new SOAPClientParameters();
			param.add('inCgpfa_codigo',cgpfa_codigoCertificado.value);
			SOAPClient.invoke(URL_WS+"Cgg_gem_perfil_adjunto","delete",param, true, CallBackCgg_gem_perfil_adjuntoCertificado);
		}else{
			new bsxMessageBox({
				title:"Adjuntos",
				msg:"Selecciones el adjunto a eliminar",
				icon:"iconInfo"
			});		
		}
	}
	btnEliminarCgg_gem_contacto_persona.onclick = function(){
		function CallBackCgg_res_persona_contacto(r){			
			if(r=='true'){
				limpiarControlesContactoPersona();				
				grdContactoPersona.reload();
			}else{
				new bsxMessageBox({
					title:"Contactos",
					msg:"El contacto no ha podido ser eliminado.",
					icon:"iconInfo"
				});
			}}	
		if(txtCrprc_codigo.value){
			var param = new SOAPClientParameters();
			param.add('inCrprc_codigo',txtCrprc_codigo.value);
			SOAPClient.invoke(URL_WS+"Cgg_res_persona_contacto","delete",param, true, CallBackCgg_res_persona_contacto);
		}else{
			new bsxMessageBox({
				title:"Contactos",
				msg:"Selecciones el contacto a eliminar.",
				icon:"iconInfo"
			});	
		}
	}
	btnEliminarCgg_gem_idioma_persona.onclick = function(){
		function CallBackCgg_gem_idioma_persona(r){			
			if(r=='true'){
				limpiarControlesIdiomaPersona();				
				grdIdiomaPersona.reload();
			}else{
				new bsxMessageBox({
						title:'Idiomas',
						msg: 'La informaci\u00f3n sobre el idioma no ha podido ser eliminada.',
						icon: "iconInfo"
				});
		}}
		if (txtCgidp_codigo.value){
			var param = new SOAPClientParameters();
			param.add('inCgidp_codigo',txtCgidp_codigo.value);
			SOAPClient.invoke(URL_WS+"Cgg_gem_idioma_persona","delete",param, true, CallBackCgg_gem_idioma_persona);
		}else{
			new bsxMessageBox({
				title:"Idiomas",
				msg:"Selecciones el idioma a eliminar.",
				icon:"iconInfo"
			});	
		}
	}
	btnEliminarCgg_gem_destreza_persona.onclick = function(){
		function CallBackCgg_gem_destreza_persona(r) {			
			if (r == 'true') {
				limpiarControlesDestrezaPersona();								
				grdDestrezaPersona.reload();

			}else{
				Ext.Msg.show({
					title: 'Destrezas',
					msg: 'La informaci\u00f3n sobre destrezas no ha podido ser eliminada.',
					icon: "iconInfo"
				});
			}
		}
		if(txtCgdpr_codigo.value){		
			var param = new SOAPClientParameters();
			param.add('inCgdpr_codigo', txtCgdpr_codigo.value);
			SOAPClient.invoke(URL_WS+"Cgg_gem_destreza_persona", "delete", param, true, CallBackCgg_gem_destreza_persona);
		}else{
			new bsxMessageBox({
				title:"Destrezas",
				msg:"Seleccione la destreza a eliminar",
				icon:"iconInfo"
			});
		}
	}
	btnEliminarCgg_gem_experiencia_laboral.onclick = function(){
		function CallBackCgg_gem_experiencia_laboral(r){			
			if(r=='true'){
				limpiarControlesExperienciaLaboral();				
				grdExperienciaLaboral.reload();
			}else{
				new bsxMessageBox({
						title:'Experiencia laboral',
						msg: 'La informaci\u00f3n sobre la experiencia laboral no ha podido ser eliminada.',						
						icon: "iconInfo"
				});
		}}
		if(txtCgexl_codigo.value){
			var param = new SOAPClientParameters();
			param.add('inCgexl_codigo',txtCgexl_codigo.value);
			SOAPClient.invoke(URL_WS+"Cgg_gem_experiencia_laboral","delete",param, true, CallBackCgg_gem_experiencia_laboral);
		}else{
			new bsxMessageBox({
				title:"Experiencia laboral",
				msg:"Seleccione una experiencia laboral",
				icon:"iconInfo"
			});
		}
	}
	btnEliminarCgg_gem_certificado.onclick = function(){
		function CallBackCgg_gem_certificado(r) {			
			if (r == 'true') {
				frmCertificado.reset();
				grdCertificadoPersona.reload();
			} else {
				new bsxMessageBox({
					title: 'Certificados',
					msg: 'La informaci\u00f3n sobre el certificado no ha podido ser eliminada.',
					icon: "iconInfo"
				});
			}
		}	
		if(cgcer_codigo.value){
			var param = new SOAPClientParameters();
			param.add('inCgcer_codigo', cgcer_codigo.value);
			SOAPClient.invoke(URL_WS+"Cgg_gem_certificado", "delete", param, true, CallBackCgg_gem_certificado);
		}else{
			new bsxMessageBox({
				title:"Certificados",
				msg:"Seleccione un certificado",
				icon:"iconInfo"
			});
		}
	}
	cgpfa_adjunto.onchange = function(){	
		var a = cgpfa_adjunto.value.split('\\');
		var b = cgpfa_adjunto.value.split('.');
		cgpfa_nombre_adjunto.value = a[a.length-1];
		cgpfa_tipo_adjunto.value = b[b.length-1];		
	}
	cgpfa_adjuntoCertificado.onchange = function(){	
		var a = cgpfa_adjuntoCertificado.value.split('\\');
		var b = cgpfa_adjuntoCertificado.value.split('.');
		cgpfa_nombre_adjuntoCertificado.value = a[a.length-1];
		cgpfa_tipo_adjuntoCertificado.value = b[b.length-1];		
	}
	btnNuevoListadoCgg_gem_perfil_adjunto.onclick = function(){
		frmPerfilAdjunto.reset();	
		showForm(FrmPerfilAdjunto);		
		crper_codigo.value = codigoPersona;
		requestAdjuntos.value = 'insert';
		swPerfilAdjunto = false;
	}
	btnNuevoListadoCgg_gem_perfil_adjuntoCertificado.onclick = function(){
		frmPerfilAdjuntoCertificado.reset();	
		showForm(FrmPerfilAdjuntoCertificado);		
		crper_codigoCertificado.value = codigoPersona;
		requestAdjuntosCertificado.value = 'insert';
		swPerfilAdjuntoCertificado = false;
	}
	
	btnEditarCgg_gem_contacto_persona.onclick=function(){
		cbxTipoContacto.dom.disabled = true;
		if(txtCrprc_codigo.value){
			showForm(FrmContactoPersona);	
		}else{
			new bsxMessageBox({
				title:"Contacto",
				msg:"Seleccione un Contacto",
				icon:"iconInfo"
			});
		}
	}
	/*btnSalirCggListado_gem_perfil_adjunto.onclick = function(){
		btnSalirAll(FrmListadoPerfilAdjunto);
	}*/
	
	btnSalirCgg_gem_perfil_adjunto.onclick = function(){
		btnSalirAll(FrmPerfilAdjunto);
	}
	btnSalirCgg_gem_perfil_adjuntoCertificado.onclick = function(){
		btnSalirAll(FrmPerfilAdjuntoCertificado);
	}
	btnSalirCgg_gem_contacto_persona.onclick=function(){
		btnSalirAll(FrmContactoPersona);
	}
	btnNuevoCgg_gem_contacto_persona.onclick=function(){
		cbxTipoContacto.dom.disabled = false;
		limpiarControlesContactoPersona();	
		showForm(FrmContactoPersona);
	}
	btnNuevoCgg_gem_perfil_profesional.onclick=function(){
		limpiarControlesPerfilProfesional();	
		showForm(FrmPerfilProfesional);
	}
	
	btnEditarCgg_gem_perfil_profesional.onclick=function(){
		if(txtCgppr_codigo.value){
			showForm(FrmPerfilProfesional);	
		}else{
			new bsxMessageBox({
				title:"Perfil Profesional",
				msg:"Seleccione un Perfil",
				icon:"iconInfo"
			});
		}
	}
	btnEliminarCgg_gem_perfil_profesional.onclick=function(){
		function CallBackCgg_gem_perfil_profesional(r) {			
			if (r == 'true') {			
				grdPerfilProfesional.reload();
			} else {
				new bsxMessageBox({
					title: 'Perfil',
					msg: 'La informaci\u00f3n sobre el perfil no ha podido ser eliminada.',
					icon: "iconInfo"
				});
			}
		}	
		if(txtCgppr_codigo.value){
			var param = new SOAPClientParameters();
			param.add('inCgppr_codigo', txtCgppr_codigo.value);
			SOAPClient.invoke(URL_WS+"Cgg_gem_perfil_prof", "delete", param, true, CallBackCgg_gem_perfil_profesional);
		}else{
			new bsxMessageBox({
				title:"Perfil",
				msg:"Seleccione un perfil",
				icon:"iconInfo"
			});
		}
	}
	
	btnSalirCgg_gem_perfil_prof.onclick=function(){
		btnSalirAll(FrmPerfilProfesional);
	}
	btnListadoCgg_gem_institucion_nivel.onclick= function(){
		grdInstitucionNivel.setParam("inCgnes_codigo",cbxNivelEstudio.dom.value);
		showForm(FrmListadoInstitucionNivel);
		grdInstitucionNivel.show();
		grdInstitucionNivel.reload();
	}

	btnSeleccionarInstitucionNivel.onclick=function(){		
		if(codigoInstitucionNivel.length>0){
			btnSalirAll(FrmListadoInstitucionNivel);	
			txtCgien_codigo.value = nombreInstitucion;			
		}else{
			new bsxMessageBox({
				title:"Instituci\u00F3n",
				msg:"Seleccione una Instituci\u00F3n",
				icon:"iconInfo"
			});
		}
	}
	btnSalirInstitucionNivel.onclick=function(){
		btnSalirAll(FrmListadoInstitucionNivel);
	}
	btnListadoCgg_titulo_profesional.onclick= function(){
		grdTituloProfesional.setParam("inCgnes_codigo",cbxNivelEstudio.dom.value);
		showForm(FrmListadoTituloProfesional);
		grdTituloProfesional.show();
		grdTituloProfesional.reload();
	}
	btnSeleccionarTituloProfesional.onclick=function(){		
		if(codigoTituloProfesional.length>0){
			btnSalirAll(FrmListadoTituloProfesional);	
			txtCgtpr_codigo.value = nombreTituloProfesional;			 	
		}else{
			new bsxMessageBox({
				title:"Instituci\u00F3n",
				msg:"Seleccione un t\u00EDtulo profesional",
				icon:"iconInfo"
			});
		}
	}
	btnSalirTituloProfesional.onclick=function(){
		btnSalirAll(FrmListadoTituloProfesional);
	}
	btnListadoCgg_especialidad.onclick= function(){
		grdEspecialidad.setParam("inCgnes_codigo",cbxNivelEstudio.dom.value);
		showForm(FrmListadoEspecialidad);
		grdEspecialidad.show();
		grdEspecialidad.reload();
	}
	btnSeleccionarEspecialidad.onclick=function(){		
		if(codigoEspecialidad.length>0){
			btnSalirAll(FrmListadoEspecialidad);	
			txtCgesp_codigo.value = nombreEspecialidad;			 	
		}else{
			new bsxMessageBox({
				title:"Instituci\u00F3n",
				msg:"Seleccione un t\u00EDtulo profesional",
				icon:"iconInfo"
			});
		}
	}
	btnSalirEspecialidad.onclick=function(){
		btnSalirAll(FrmListadoEspecialidad);
	}
	function fnLoadInformacionLaboral(){
		/**
		*	LOAD INFORMACION LABORAL
		*/
		function CallBackSelectCgg_gem_informacion_laboral(v){
			var a = eval('('+v+')');
			if(a.length>0){
				if(a[0].CGINF_CODIGO){
					isEditInformacionLaboral=true;
					metodoInformacionLaboral='update';
				}else{
					metodoInformacionLaboral='insert';
				}
				cargarComponentesInformacionLaboral(a);
			}else{
					metodoInformacionLaboral='insert';
			}
		}
		var param = new SOAPClientParameters();				
		param.add('inCrper_codigo',codigoPersona);						
		param.add('format','JSON');		
		SOAPClient.invoke(URL_WS+"Cgg_gem_informacion_laboral","selectInformacionLaboralById",param, true, CallBackSelectCgg_gem_informacion_laboral);
	}
	/**
	*	GRID LISTADO IDIOMAS PERSONAS
	*/
	
	var colTableIdiomaPersona=[	
		{name:'CGIDP_CODIGO',title:'Codigo',width:150,hidden:true},
		{name:'CRPER_CODIGO',title:'Codigo',width:150,hidden:true},
		{name:'CGIDM_CODIGO',title:'Codigo',width:150,hidden:true},
		{name:'CGIDM_NOMBRE',title:'Idioma',width:100},
		{name:'CGIDP_ESCRITURA',title:'Escritura',width:100,align:"center",renderer: rndPorcentaje},
		{name:'CGIDP_LECTURA',title:'Lectura',width:100,align:"center",renderer:rndPorcentaje},
		{name:'CGIDP_HABLAR',title:'Hablar',width:100,align:"center",renderer:rndPorcentaje},
		{name:'CGIDP_ESCUCHAR',title:'Escuchar',width:100,align:"center",renderer:rndPorcentaje}
	];
			
	var grdIdiomaPersona = new bsxTable({
		id:"grdIdiomaPersona",
		renderTo:"divGrdIdiomaPersona",
		width:"680",
		height:"300",
		
		webService:{
			url:URL_WS+"Cgg_gem_idioma_persona",
			method:"selectPageIdiomasPersona",
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},		
			params:[
				{name:"start",value:"0"},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:"CRPER_CODIGO"},
				{name:"dir",value:"ASC"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"},				
				{name:"inCrper_codigo",value:codigoPersona}				
			]			
		},
		columns:colTableIdiomaPersona,
		events:{
			selectedRow:function(t,dr,r){
				txtCgidp_codigo.value=dr.CGIDP_CODIGO;
				cbxIdiomas.dom.value=dr.CGIDM_CODIGO;
				numCgidp_escritura.value=dr.CGIDP_ESCRITURA;
				numCgidp_lectura.value=dr.CGIDP_LECTURA;
				numCgidp_hablar.value=dr.CGIDP_HABLAR;
				numCgidp_escuchar.value=dr.CGIDP_ESCUCHAR
			}
		}
	});	
	grdIdiomaPersona.show();
	
	btnNuevoCgg_gem_idioma_persona.onclick=function(){
		limpiarControlesIdiomaPersona();
		numCgidp_escritura.focus();
		divBgModal.style.display="block";
		FrmIdiomaPersona.style.display="block";	
		cbxIdiomas.dom.disabled = false;
	}
	
	numCgidp_escritura.onkeypress = function(e){
		tecla = (document.all) ? e.keyCode : e.which;
		if (tecla==8 || tecla==13) return true; 
		patron = /\d/;
		te = String.fromCharCode(tecla); 
		return patron.test(te);  
	}
	numCgidp_lectura.onkeypress = function(e){
		tecla = (document.all) ? e.keyCode : e.which;
		if (tecla==8 || tecla==13) return true; 
		patron = /\d/;
		te = String.fromCharCode(tecla); 
		return patron.test(te); 
	}
	numCgidp_hablar.onkeypress = function(e){
		tecla = (document.all) ? e.keyCode : e.which;
		if (tecla==8 || tecla==13) return true; 
		patron = /\d/;
		te = String.fromCharCode(tecla); 
		return patron.test(te); 
	}
	numCgidp_escuchar.onkeypress = function(e){
		tecla = (document.all) ? e.keyCode : e.which;
		if (tecla==8 || tecla==13) return true; 
		patron = /\d/;
		te = String.fromCharCode(tecla); 
		return patron.test(te); 
	}	
	/*
	*Creacion de un combobox con datos de un webservices
	*/
	var cbxIdiomas = new bsxComboBox({
		id:"cbxIdiomas",
		renderTo:"tdCbxIdiomas",		
		displayField:"CGIDM_NOMBRE",
		valueField:"CGIDM_CODIGO",
		
		webService:{
			url:URL_WS+"Cgg_gem_idioma",
			method:"selectAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		}		
	});	

	function btnSalirAll(frm){
		divBgModal.style.display="none";
		frm.style.display="none";			
	}
	/**
	*	GUARDAR O ACTUALIZAR DATOS DE IDIOMAS DE LA PERSONA
	*/
	btnGuardarCgg_gem_idioma_persona.onclick=function(){
		function CallBackCgg_gem_idioma_persona(v){
			if (v=="true"){
				limpiarControlesIdiomaPersona();
				btnSalirAll(FrmIdiomaPersona);
				grdIdiomaPersona.reload();
			}else{
				new bsxMessageBox({
					title:"Idioma",
					msg:"Informaci\u00F3n de idioma no almacenada!",
					icon:"iconError"
				});
			}
		}
		var param = new SOAPClientParameters();	
		if (txtCgidp_codigo.value){
			metodoIdiomaPersona = 'update';
			param.add('inCgidp_codigo',txtCgidp_codigo.value);
		}else{
			metodoIdiomaPersona = 'insert';
		}
		param.add('inCrper_codigo',codigoPersona);						
		param.add('inCgidm_codigo',cbxIdiomas.dom.value);
		param.add('inCgidp_escritura',numCgidp_escritura.value);
		param.add('inCgidp_lectura',numCgidp_lectura.value);		
		param.add('inCgidp_hablar',numCgidp_hablar.value);
		param.add('inCgidp_escuchar',numCgidp_escuchar.value);		
		SOAPClient.invoke(URL_WS+"Cgg_gem_idioma_persona",metodoIdiomaPersona,param, true, CallBackCgg_gem_idioma_persona);
	}
	
	/**
	*	GUARDAR O ACTUALIZAR LOS DATOS DE INFORMACION GENERAL
	*/
	btnCginf_Guardar.onclick=function(){
		function CallBackCgg_gem_informacion_laboral(v){
			if (v=="true"){

			}else{				
				new bsxMessageBox({
					title:"Informaci\u00F3n laboral",
					msg:"Informaci\u00F3n no almacenada",
					icon:"iconError"
				});
			}
		}
		var param = new SOAPClientParameters();		
		if(isEditInformacionLaboral)
			param.add('inCginf_codigo',codigoInformacionLaboral);
		param.add('inCrper_codigo',codigoPersona);
		if (chkCginf_trab_otra_ciudad.checked){							
			param.add('inCginf_trab_otra_ciudad','1')
		}else{
			param.add('inCginf_trab_otra_ciudad','0')
		}
		param.add('inCginf_disponibilidad',txtCginf_disponibilidad.value);		
		param.add('inCginf_calificacion',txtCginf_Calificacion.value);
		
		
		if(txtCginf_licencia_cond.checked){
			param.add('inCginf_licencia_conducir','1');
		}else{
			param.add('inCginf_licencia_conducir','0');
		}
		param.add('inCginf_estado_laboral',cbmCginf_estado_laboral.value);
		param.add('inCginf_hijos',txtCginf_hijos.value);
		param.add('inCginf_observaciones',cbmCginf_obserbaciones.value);
		param.add('inCrper_aspiracion_salarial',txtCrper_aspiracion_salarial.value);			
		SOAPClient.invoke(URL_WS+"Cgg_gem_informacion_laboral",metodoInformacionLaboral,param, true, CallBackCgg_gem_informacion_laboral);
	}
	
	/**
	*	GRID LISTADO CERTIFICADOS PERSONA
	*/	
	var colTableCertificadoPersona=[
		{name: 'CGCER_CODIGO',title: 'Codigo',width: 150,hidden:true},
		{name: 'CRPER_CODIGO',title: 'Codigo',width: 150,hidden:true},		
		{name: 'CGCER_TIPO',title: 'Tipo',width: 150,renderer:rndTipoCertificado},
		{name: 'CGCER_INSTITUCION',title: 'Instituci\u00F3n',width: 150},
		{name: 'CGCER_NOMBRE',title: 'Certificado',width: 150,sortable: true},
		{name: 'CGCER_DESCRIPCION',title: 'Descripci\u00F3n',width: 150,hidden:true},
		{name: 'CGCER_DURACION',title: 'Horas',width: 100,renderer: rndDuracionHoras},
		{name: 'CGCER_FECHA_INICIO',title: 'Fecha inicio',width: 100,
			renderer:function(v){
				return v.split(' ')[0];
			}
		},
		{name: 'CGCER_FECHA_FIN',title: 'Fecha fin',width: 100,
			renderer:function(v){
				return v.split(' ')[0];
			}
		},
		{name: 'CGCER_TIPO_ADJUNTO',title: 'Tipo adjunto',width: 150,hidden:true},
		{name: 'CGCER_NOMBRE_ADJUNTO',title: 'Nombre adjunto',width: 150,hidden:true},
		{name: 'CGCER_OBSERVACION',title: 'Observacion',width: 150}
	];
			
	var grdCertificadoPersona = new bsxTable({
		id:"grdCertificadoPersona",
		renderTo:"divGrdCertificado",
		width:"650",
		height:"200",
		
		webService:{
			url:URL_WS+"Cgg_gem_certificado",
			method:"selectPageCertificadosPersona",
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},
			params:[
				{name:"start",value:"0"},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:"CRPER_CODIGO"},
				{name:"dir",value:"ASC"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"},				
				{name:"inCrper_codigo",value:codigoPersona}				
			]			
		},
		columns:colTableCertificadoPersona,		
		events:{			
			selectedRow:function(t,dr,r){			
				cgcer_codigo.value = dr.CGCER_CODIGO;
				cgcer_tipo.value = dr.CGCER_TIPO;
				cgcer_institucion.value = dr.CGCER_INSTITUCION;
				cgcer_nombre.value = dr.CGCER_NOMBRE;
				cgcer_descripcion.value = dr.CGCER_DESCRIPCION;
				cgcer_duracion.value = dr.CGCER_DURACION;
				cgcer_observacion.value = dr.CGCER_OBSERVACION;
				cgcer_fecha_inicio.value = dr.CGCER_FECHA_INICIO?dr.CGCER_FECHA_INICIO.split(' ')[0]:null;
				cgcer_fecha_fin.value = dr.CGCER_FECHA_FIN?dr.CGCER_FECHA_FIN.split(' ')[0]:null;
				cgcer_tipo_adjunto.value = dr.CGCER_TIPO_ADJUNTO;
				cgcer_nombre_adjunto.value = dr.CGCER_NOMBRE_ADJUNTO;
				crper_codigo.value = dr.CRPER_CODIGO;				
			}
		}
	});	
	grdCertificadoPersona.show();
	
	cgcer_duracion.onkeypress = function(){
		if (event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;
	}
	
	/**
	*	GRID LISTADO EXPERIENCIA DE LA PERSONA
	*/
	
	var colTableExperienciaLaboral=[	
		{name:'CGEXL_CODIGO',title:'Codigo',width:150,hidden:true},
		{name:'CRPER_CODIGO',title:'Codigo',width:150,hidden:true},			
		{name:'CGEXL_RAZON_SOCIAL',title:'Razon social',width:130},
		{name:'CGEXL_CIUDAD',title:'Ciudad',width:130},
		{name:'CGEXL_CARGO',title:'Cargo',width:150},
		{name:'CGEXL_DESCRIPCION',title:'Descripci\u00F3n',width:150},
		{name:'CGEXL_PERSONAS_CARGO',title:'Personas a cargo',width:120, 
			renderer:function(v){
				if(v)					
					return v
				else
					return "Ninguna"
			}
		},
		{name:'CGEXL_FECHA_INICIO',title:'F. inicio',width:75,
			renderer:function(v){
				return v.split(' ')[0];
			}
		},
		{name:'CGEXL_FECHA_FIN',title:'F. fin',width:75,
			renderer:function(v){
				return v.split(' ')[0];
			}
		},			
		{name:'CGEXL_CONTACTO',title:'Referencia',width:150},
		{name:'CGEXL_TELEFONO',title:'Telefono',width:90},
		{name:'CGEXL_OBSERVACIONES',title:'Observaciones',width:150}
	];
			
	var grdExperienciaLaboral = new bsxTable({
		id:"grdExperienciaLaboral",
		renderTo:"divGrdExperienciaLaboral",
		width:"680",
		height:"300",		
		webService:{
			url:URL_WS+"Cgg_gem_experiencia_laboral",
			method:"selectPageExpLabPersona",
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},
			params:[
				{name:"start",value:"0"},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:"CRPER_CODIGO"},
				{name:"dir",value:"ASC"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"},				
				{name:"inCrper_codigo",value:codigoPersona}				
			]			
		},
		columns:colTableExperienciaLaboral,
		events:{
			load:function(ds){
				
			},
			selectedRow:function(t,dr,r){
				txtCgexl_codigo.value = dr.CGEXL_CODIGO;
				txtCgexl_razon_social.value = dr.CGEXL_RAZON_SOCIAL;
				txtCgexl_ciudad.value = dr.CGEXL_CIUDAD;
				txtCgexl_cargo.value = dr.CGEXL_CARGO;
				txtCgexl_descripcion.value = dr.CGEXL_DESCRIPCION;				
				dtCgexl_fecha_inicio.value = dr.CGEXL_FECHA_INICIO.split(' ')[0]||'';
				dtCgexl_fecha_fin.value = dr.CGEXL_FECHA_FIN.split(' ')[0]||'';
				numCgexl_personas_cargo.value = dr.CGEXL_PERSONAS_CARGO;
				txtCgexl_contacto.value = dr.CGEXL_CONTACTO;
				txtCgexl_telefono.value = dr.CGEXL_TELEFONO;
				txtCgexl_observaciones.value = dr.CGEXL_OBSERVACIONES;
			}
		}
	});	
	grdExperienciaLaboral.show();
	
	/**
	*	GUARDAR O ACTUALIZAR DATOS SOBRE EXPERIENCIA LABORAL DE LA PERSONA
	*/
	btnGuardarCgg_gem_experiencia_laboral.onclick=function(){
		if (!dtCgexl_fecha_inicio.value.length>0){
			new bsxMessageBox({
				title:"Alerta",
				msg:"Es necesario ingresar la fecha de inicio",
				icon:"iconError",
				close:function(){
					dtCgexl_fecha_inicio.focus();
					return;	
				}				
			});
					
		}
		if (!dtCgexl_fecha_fin.value.length>0){			
			new bsxMessageBox({
				title:"Alerta",
				msg:"Es necesario ingresar la fecha de finalizaci\u00F3n",
				icon:"iconError",
				close:function(){
					dtCgexl_fecha_fin.focus();
					return;
				}
			});
						
		}
		if(dtCgexl_fecha_inicio.value > dtCgexl_fecha_fin.value){
			new bsxMessageBox({
				title:"Alerta",
				msg:"La fecha de finalizacion debe ser mayor que la fecha de inicio",
				icon:"iconError",
				close:function(){
					dtCgexl_fecha_fin.focus();
					return;
				}
			});
			
		}
		function CallBackCgg_gem_experiencia_laboral(v){
			if (v=="true"){
				limpiarControlesExperienciaLaboral();
				grdExperienciaLaboral.reload();
				btnSalirAll(FrmExperienciaLaboral);
			}else{
				new bsxMessageBox({title:"Experiencia laboral",msg:'Informaci\u00F3n no almacenada',icon:"iconError"});				
			}
		}
		var param = new SOAPClientParameters();	
		if (txtCgexl_codigo.value){
			metodoExperienciaLaboral = 'update';
			param.add('inCgexl_codigo',txtCgexl_codigo.value);
		}else{
			metodoExperienciaLaboral = 'insert';
		}
		param.add('inCrper_codigo',codigoPersona);						
		param.add('inCgexl_fecha_inicio',(dtCgexl_fecha_inicio.value.length==0)?null:dtCgexl_fecha_inicio.value+'T00:00:00');
		param.add('inCgexl_fecha_fin',(dtCgexl_fecha_fin.value.length==0)?null:dtCgexl_fecha_fin.value+'T00:00:00');
		param.add('inCgexl_razon_social',txtCgexl_razon_social.value);		
		param.add('inCgexl_ciudad',txtCgexl_ciudad.value);
		param.add('inCgexl_cargo',txtCgexl_cargo.value);	
		param.add('inCgexl_descripcion',txtCgexl_descripcion.value);	
		param.add('inCgexl_personas_cargo',numCgexl_personas_cargo.value?numCgexl_personas_cargo.value:0);	
		param.add('inCgexl_contacto',txtCgexl_contacto.value);	
		param.add('inCgexl_telefono',txtCgexl_telefono.value);	
		param.add('inCgexl_observaciones',txtCgexl_descripcion.value);	
		
		SOAPClient.invoke(URL_WS+"Cgg_gem_experiencia_laboral",metodoExperienciaLaboral,param, true, CallBackCgg_gem_experiencia_laboral);
	}
	
	/**
	*	GRID LISTADO DESTREZA PERSONA
	*/
	
	var colTableDestrezaPersona=[		
		{name:'CGDPR_CODIGO',title:'Codigo destreza persona',width:120,hidden:true},
		{name:'CRPER_CODIGO',title:'Codigo persona',width:150,hidden:true},
		{name:'CGDST_CODIGO',title:'Codigo destreza',width:150,hidden:true},
		{name:'CGDST_DESCRIPCION',title:'Destreza',width:300}
	];
			
	var grdDestrezaPersona = new bsxTable({
		id:"grdDestrezaPersona",
		renderTo:"divGrdDestrezaPersona",
		width:"320",
		height:"300",		
		webService:{
			url:URL_WS+"Cgg_gem_destreza_persona",
			method:"selectPageDestrezaPersona",
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},			
			params:[
				{name:"start",value:"0"},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:"CRPER_CODIGO"},
				{name:"dir",value:"ASC"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"},				
				{name:"inCrper_codigo",value:codigoPersona},
				{name:"inCgdst_tipo",value:true}
			]			
		},
		columns:colTableDestrezaPersona,
		events:{
			selectedRow:function(t,dr,r){
				txtCgdpr_codigo.value = dr.CGDPR_CODIGO;
				cbxDestrezas.dom.value = dr.CGDST_CODIGO;
			}
		}
	});	
	grdDestrezaPersona.show();

	/*
	*Creacion de un combobox con datos de un webservices
	*/
	var cbxDestrezas = new bsxComboBox({
		id:"cbxDestrezas",
		renderTo:"tdDestrezas",		
		displayField:"CGDST_DESCRIPCION",
		valueField:"CGDST_CODIGO",
		webService:{
			url:URL_WS+"Cgg_gem_destreza",
			method:"selectAllByTipo",
			params:[							
				{name:"format",value:"JSON"},
				{name:"inCgdst_tipo",value:true}
			]
		}		
	});	
	
	btnNuevoCgg_gem_destreza_persona.onclick = function(){		
		cbxDestrezas.reload();
		limpiarControlesDestrezaPersona();
		divBgModal.style.display="block";
		FrmDestrezaPersona .style.display="block";	
	}
	
	btnEditarCgg_gem_destreza_persona.onclick=function(){
		cbxDestrezas.reload();
		if(txtCgdpr_codigo.value){
			divBgModal.style.display="block";
			FrmDestrezaPersona.style.display="block";	
		}
		else{
			new bsxMessageBox({
				title:"Destrezas",
				msg:"Seleccione una destreza",
				icon:"iconInfo"
			});
		}
	}
	
	btnGuardarCgg_gem_destreza_persona.onclick = function(){
		function CallBackCgg_gem_destreza_persona(v){
			if (v=="true"){
				limpiarControlesDestrezaPersona();
				btnSalirAll(FrmDestrezaPersona);
				grdDestrezaPersona.reload();
			}else{
				new bsxMessageBox({
					title:"Destreza",
					msg:"Datos no almacenados",
					icon:"iconInfo"
				});
			}
		}
		var param = new SOAPClientParameters();			
		if (txtCgdpr_codigo.value.length>0){
			metodoDestrezaPersona = 'update';
			param.add('inCgdpr_codigo',txtCgdpr_codigo.value);
		}else{
			metodoDestrezaPersona = 'insert';
		}
		param.add('inCrper_codigo',codigoPersona);						
		param.add('inCgdst_codigo',cbxDestrezas.dom.value/*txtCgdst_codigo.value*/);	
		SOAPClient.invoke(URL_WS+"Cgg_gem_destreza_persona",metodoDestrezaPersona,param, true, CallBackCgg_gem_destreza_persona);	
	}
	/**
	* LISTADO HABILIDADES DE LAS PERSONAS
	*/
	var colTableHabilidadesPersona=[		
		{name:'CGDPR_CODIGO',title:'Codigo destreza persona',width:120,hidden:true},
		{name:'CRPER_CODIGO',title:'Codigo persona',width:150,hidden:true},
		{name:'CGDST_CODIGO',title:'Codigo destreza',width:150,hidden:true},
		{name:'CGDST_DESCRIPCION',title:'Habilidades',width:300}
	];
	var grdHabilidadesPersona = new bsxTable({
		id:"grdHabilidadesPersona",
		renderTo:"divGrdHabilidadesPersona",
		width:"320",
		height:"300",		
		webService:{
			url:URL_WS+"Cgg_gem_destreza_persona",
			method:"selectPageDestrezaPersona",
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},			
			params:[
				{name:"start",value:"0"},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:"CRPER_CODIGO"},
				{name:"dir",value:"ASC"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"},				
				{name:"inCrper_codigo",value:codigoPersona},
				{name:"inCgdst_tipo",value:false}
			]			
		},
		columns:colTableHabilidadesPersona,		
		events:{
			selectedRow:function(t,dr,r){
				txtCgdpr_codigoHabilidades.value = dr.CGDPR_CODIGO;
				cbxHabilidades.dom.value = dr.CGDST_CODIGO;
			}
		}
	});	
	grdHabilidadesPersona.show();

	/*
	*Creacion de un combobox con datos de un webservices
	*/
	var cbxHabilidades = new bsxComboBox({
		id:"cbxHabilidades",
		renderTo:"tdHabilidades",		
		displayField:"CGDST_DESCRIPCION",
		valueField:"CGDST_CODIGO",
		webService:{
			url:URL_WS+"Cgg_gem_destreza",
			method:"selectAllByTipo",
			params:[							
				{name:"format",value:"JSON"},
				{name:"inCgdst_tipo",value:false}
			]
		}		
	});	
	
	btnNuevoCgg_gem_habilidades_persona.onclick = function(){
		cbxHabilidades.reload();
		limpiarControlesHabilidadesPersona();
		divBgModal.style.display="block";
		FrmHabilidadesPersona .style.display="block";	
	}
	
	btnEditarCgg_gem_habilidades_persona.onclick=function(){	
		cbxHabilidades.reload();
		if(txtCgdpr_codigoHabilidades.value){
			divBgModal.style.display="block";
			FrmHabilidadesPersona.style.display="block";	
		}
		else{
			new bsxMessageBox({
				title:"Habilidades",
				msg:"Seleccione una destreza",
				icon:"iconInfo"
			});
		}
	}
	
	btnGuardarCgg_gem_habilidades_persona.onclick = function(){
		function CallBackCgg_gem_habilidades_persona(v){
			if (v=="true"){
				limpiarControlesDestrezaPersona();
				btnSalirAll(FrmHabilidadesPersona);
				grdHabilidadesPersona.reload();
			}else{
				new bsxMessageBox({
					title:"Habilidades",
					msg:"Datos no almacenados",
					icon:"iconInfo"
				});
			}
		}
		var param = new SOAPClientParameters();			
		if (txtCgdpr_codigo.value.length>0){
			metodoHabilidadesPersona = 'update';
			param.add('inCgdpr_codigo',txtCgdpr_codigoHabilidades.value);
		}else{
			metodoHabilidadesPersona = 'insert';
		}
		param.add('inCrper_codigo',codigoPersona);						
		param.add('inCgdst_codigo',cbxHabilidades.dom.value/*txtCgdst_codigo.value*/);	
		SOAPClient.invoke(URL_WS+"Cgg_gem_destreza_persona",metodoHabilidadesPersona,param, true, CallBackCgg_gem_habilidades_persona);	
	}
	btnEliminarCgg_gem_habilidades_persona.onclick = function(){
		function CallBackCgg_gem_habilidades_personas(r) {			
			if (r == 'true') {	
				limpiarControlesHabilidadesPersona();								
				grdHabilidadesPersona.reload();

			}else{
				Ext.Msg.show({
					title: 'Habilidades',
					msg: 'La informaci\u00f3n sobre habilidades no ha podido ser eliminada.',
					icon: "iconInfo"
				});
			}
		}
		if(txtCgdpr_codigoHabilidades.value){		
			var param = new SOAPClientParameters();
			param.add('inCgdpr_codigo', txtCgdpr_codigoHabilidades.value);
			SOAPClient.invoke(URL_WS+"Cgg_gem_destreza_persona", "delete", param, true, CallBackCgg_gem_habilidades_personas);
		}else{
			new bsxMessageBox({
				title:"Habilidades",
				msg:"Seleccione la habilidad a eliminar",
				icon:"iconInfo"
			});
		}
	}
	
	/**
	*	GRID LISTADO PERFIL PROFESIONAL
	*/
	
	var colTablePerfilProfesional=[			
		{name:'CGNES_DESCRIPCION',title:'Nivel de estudio',width:100},			
		{name:'CGIED_NOMBRE',title:'Instituci\u00F3n',width:150},
		{name:'CGTPR_DESCRIPCION',title:'Titulo Profesional',width:150},
		{name:'CGESP_NOMBRE',title:'Especialidad',width:150},
		{name:'CGMDC_DESCRIPCION',title:'Modalidad',width:100},
		{name:'CGPPR_NIVEL_APROBADO',title:'Nivel aprobado',width:150, renderer:rndNivelAprobado},		
		{name:'CGPPR_FECHA_INICIO',title:'Fecha inicio',width:150},
		{name:'CGPPR_FECHA_FIN',title:'Fecha fin',width:150}/*,		
		{name:'CGPPR_PREDETERMINADO',title:'Predeterminado',width:150}		*/
	];
			
	var grdPerfilProfesional = new bsxTable({
		id:"grdPerfilProfesional",
		renderTo:"divGrdPerfilProfesional",		
		width:"670",
		height:"100",		
		webService:{
			url:URL_WS+"Cgg_gem_perfil_prof",
			method:"selectPagePerfilProfesional",
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},			
			params:[
				{name:"start",value:"0"},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:"CRPER_CODIGO"},
				{name:"dir",value:"ASC"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"},				
				{name:"inCrper_codigo",value:codigoPersona}				
			]			
		},
		columns:colTablePerfilProfesional,		
		events:{
			selectedRow:function(t,dr,r){
				txtCgppr_codigo.value = dr.CGPPR_CODIGO;
				cbxNivelEstudio.dom.value = dr.CGNES_CODIGO;
				txtCgien_codigo.value = dr.CGIED_NOMBRE;
				txtCgtpr_codigo.value = dr.CGTPR_DESCRIPCION;
				txtCgesp_codigo.value = dr.CGESP_NOMBRE;
				cbxModalidadEstudio.dom.value = dr.CGMDC_CODIGO;
				numCgppr_nivel_aprobado.value = dr.CGPPR_NIVEL_APROBADO;
				dtCgppr_fecha_inicio.value = dr.CGPPR_FECHA_INICIO||'';
				dtCgppr_fecha_fin.value = dr.CGPPR_FECHA_FIN||'';
				chkCgppr_confirmado.checked = dr.CGPPR_CONFIRMADO;
				chkCgppr_predeterminado.checked = dr.CGPPR_PREDETERMINADO;
				codigoInstitucionNivel = dr.CGIEN_CODIGO;
				codigoTituloProfesional = dr.CGTPR_CODIGO;
				codigoEspecialidad = dr.CGESP_CODIGO;
				codigoPerfilProfesional = dr.CGPPR_CODIGO;			
			}
		}
	});	
	grdPerfilProfesional.show();
	grdPerfilProfesional.reload();
	/*
	*Creacion de un combobox con datos de un webservices
	*/
	var cbxNivelEstudio = new bsxComboBox({
		id:"cbxNivelEstudio",
		renderTo:"tdNivelEstudio",	
		width : 140,
		displayField:"CGNES_DESCRIPCION",
		valueField:"CGNES_CODIGO",
		webService:{
			url:URL_WS+"Cgg_nivel_estudio",
			method:"selectAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		}		
	});	
	cbxNivelEstudio.reload();
	
	var cbxModalidadEstudio = new bsxComboBox({
		id:"cbxModalidadEstudio",
		renderTo:"tdModalidadEstudio",
		width:140,
		displayField:"CGMDC_DESCRIPCION",
		valueField:"CGMDC_CODIGO",
		webService:{
			url:URL_WS+"Cgg_modalidad_curso",
			method:"selectAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		}		
	});	
	cbxModalidadEstudio.reload();	
	btnGuardarCgg_gem_perfil_prof.onclick = function(){
		var swFlag = true;
		if (!dtCgppr_fecha_inicio.value){
			swFlag = false;
			new bsxMessageBox({
				title:"Alerta",
				msg:"Es necesario ingresar la fecha de inicio",
				icon:"iconError",
				close:function(){
					dtCgppr_fecha_inicio.focus();					
				}
			});
			return;			
		}
		if (!dtCgppr_fecha_fin.value.length>0){
			swFlag = false;
			new bsxMessageBox({
				title:"Alerta",
				msg:"Es necesario ingresar la fecha de finalizaci\u00F3n",
				icon:"iconError",
				close:function(){
					dtCgppr_fecha_fin.focus();					
				}
			});
			return;			
		}
		if(dtCgppr_fecha_fin.value<dtCgppr_fecha_inicio.value){
			swFlag = false;
			new bsxMessageBox({
				title:"Alerta",
				msg:"No puede ser la fecha final menor que la fecha de inicio",
				icon:"iconError",
				close:function(){
					dtCgppr_fecha_fin.focus();					
				}
			});
			return;
		}
		if(txtCgien_codigo.value.length==0){
			swFlag = false;
			new bsxMessageBox({
				title:"Alerta",
				msg:"Seleccione una instituci\u00F3n",
				icon:"iconError",
				close:function(){
					
				}
			});		
			return;	
		}
		if(txtCgtpr_codigo.value.length==0){
			swFlag = false;
			new bsxMessageBox({
				title:"Alerta",
				msg:"Seleccione un t\u00EDtulo",
				icon:"iconError",
				close:function(){
					
				}
			});		
			return;	
		}
		if(txtCgesp_codigo.value.length==0){
			swFlag = false;
			new bsxMessageBox({
				title:"Alerta",
				msg:"Seleccione una especialidad",
				icon:"iconError",
				close:function(){
					
				}
			});		
			return;	
		}
		function CallBackCgg_gem_perfil_profesional(v){
			if (v=="true"){				
				btnSalirAll(FrmPerfilProfesional);
				limpiarControlesPerfilProfesional();								
				grdPerfilProfesional.reload();
			}else{				
				new bsxMessageBox({
					title:"Informaci\u00F3",
					msg:"No se pudo almacenar la informaci\u00F3n",
					icon:"iconError"
				});
			}
		}
		var param = new SOAPClientParameters();			
		if (txtCgppr_codigo.value.length>0){
			metodoPerfilProfesional = 'update';
			param.add('inCgppr_codigo',txtCgppr_codigo.value);
		}else{
			metodoPerfilProfesional = 'insert';
		}
		if ($("chkCgppr_finalizado").checked){			
			numCgppr_nivel_aprobado.value = '0';
		}		
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1;
		var yyyy = today.getFullYear();		
		if (mm<10)
			mm = '0'+mm;
		if (dd<10)
			dd = '0'+dd;			
		var fechaConfirmacion = yyyy+'-'+mm+'-'+dd+'T00:00:00';		
		param.add('inCgesp_codigo',codigoEspecialidad);
		param.add('inCgtpr_codigo',codigoTituloProfesional);
		param.add('inCgmdc_codigo',cbxModalidadEstudio.dom.value);		
		param.add('inCrper_codigo',codigoPersona);		
		param.add('inCgien_codigo',codigoInstitucionNivel);
		param.add('inCgppr_nivel_aprobado',numCgppr_nivel_aprobado.value);
		param.add('inCgppr_fecha_inicio',dtCgppr_fecha_inicio.value+'T00:00:00');
		param.add('inCgppr_fecha_fin',dtCgppr_fecha_fin.value+'T00:00:00');
		param.add('inCgppr_confirmado',false);
		param.add('inCgppr_fecha_confirmacion',fechaConfirmacion);
		param.add('inCgppr_predeterminado',false);
		if (swFlag==true){
		SOAPClient.invoke(URL_WS+"Cgg_gem_perfil_prof",metodoPerfilProfesional,param, true, CallBackCgg_gem_perfil_profesional);	
		}
	}
	
	/**
	*	GRID LISTADO INSTICTUCIONES EDUCATIVAS
	*/
	
	var colTableInstitucionNivel=[			
		{name:'CGIEN_CODIGO',title:'Codigo',width:150,hidden:true},
		{name:'CGNES_CODIGO',title:'Codigo',width:150,hidden:true},
		{name:'CGIED_CODIGO',title:'Codigo',width:150,hidden:true},
		{name:'CGIED_NOMBRE',title:'Instituci\u00F3n',width:250},		
		{name:'CGIED_DIRECCION',title:'Direcci\u00F3n',width:150}
	];
			
	var grdInstitucionNivel = new bsxTable({
		id:"grdInstitucionNivel",
		renderTo:"divGrdInstitucionNivel",
		width:"480",
		height:"250",
		pagin:true,
		search:true,
		webService:{
			url:URL_WS+"Cgg_institucion_nivel",
			method:"selectPageInstitucionByIdNivel",
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},
			/*Parametros que se envia a los webService*/
			params:[
				{name:"start",value:"0"},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:"CGNES_CODIGO"},
				{name:"dir",value:"ASC"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"},				
				{name:"inCgnes_codigo",value:cbxNivelEstudio.dom.value}
			]			
		},
		columns:colTableInstitucionNivel,
		events:{
			load:function(ds){
				codigoInstitucionNivel='';
			},
			selectedRow:function(t,dr,r){				
				codigoInstitucionNivel = dr.CGIEN_CODIGO;
				nombreInstitucion = dr.CGIED_NOMBRE;
			}
		}
	});	
	/*grdInstitucionNivel.show();
	grdInstitucionNivel.reload();*/
	
	/**
	*	GRID LISTADO INSTICTUCIONES EDUCATIVAS
	*/
	
	var colTableTituloProfesional=[			
		{name:'CGTPR_CODIGO',title:'Codigo',width:150,hidden:true},
		{name:'CGNES_CODIGO',title:'Codigo',width:150,hidden:true},
		{name:'CGNES_DESCRIPCION',title:'Nivel de Estudio',width:120,hidden:true},
		{name:'CGTPR_DESCRIPCION',title:'Descripci\u00F3n',width:380}
	];
			
	var grdTituloProfesional = new bsxTable({
		id:"grdTituloProfesional",
		renderTo:"divGrdTituloProfesional",
		width:"480",
		height:"250",
		search:true,pagin:true,
		webService:{
			url:URL_WS+"Cgg_titulo_profesional",
			method:"selectPageTituloByIdNivelEstudio",
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},
			/*Parametros que se envia a los webService*/
			params:[
				{name:"start",value:"0"},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:"CGTPR_CODIGO"},
				{name:"dir",value:"ASC"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"},				
				{name:"inCgnes_codigo",value:cbxNivelEstudio.dom.value}
			]			
		},
		columns:colTableTituloProfesional,
		events:{
			load:function(ds){
				codigoTituloProfesional='';
			},
			selectedRow:function(t,dr,r){				
				codigoTituloProfesional = dr.CGTPR_CODIGO;
				nombreTituloProfesional = dr.CGTPR_DESCRIPCION;
			}
		}
	});	
	/**
	*	GRID LISTADO ESPECIALIDADES
	*/
	
	var colTableEspecialidad=[		
		{name:'CGESP_CODIGO',title:'Codigo',width:90,hidden:true},
		{name:'CGNES_CODIGO',title:'Codigo',width:150,hidden:true},
		{name:'CGNES_DESCRIPCION',title:'Nivel de Educaci\u00F3n',width:130,hidden:true},
		{name:'CGESP_NOMBRE',title:'Nombre',width:200,sortable:true},
		{name:'CGESP_DESCRIPCION',title:'Descripcion',width:350}
	];
			
	var grdEspecialidad = new bsxTable({
		id:"grdEspecialidad",
		renderTo:"divGrdEspecialidad",
		width:"480",
		height:"250",
		search:true,pagin:true,
		webService:{
			url:URL_WS+"Cgg_especialidad",
			method:"selectPageEspecialidadByIdNivelEstudio",
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},
			/*Parametros que se envia a los webService*/
			params:[
				{name:"start",value:"0"},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:"CGESP_CODIGO"},
				{name:"dir",value:"ASC"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"},				
				{name:"inCgnes_codigo",value:cbxNivelEstudio.dom.value}
			]			
		},
		columns:colTableEspecialidad,
		events:{
			load:function(ds){
				codigoEspecialidad='';
			},
			selectedRow:function(t,dr,r){	
				codigoEspecialidad = dr.CGESP_CODIGO;
				nombreEspecialidad = dr.CGESP_DESCRIPCION;
			}
		}
	});	
	/*
	*Creacion de un combobox con datos de un webservices
	*/
	var cbxTipoContacto = new bsxComboBox({
		id:"cbxTipoContacto",
		renderTo:"tdCbxTipoContacto",		
		displayField:"CRTCO_NOMBRE",
		valueField:"CRTCO_CODIGO",
		webService:{
			url:URL_WS+"Cgg_res_tipo_contacto",
			method:"selectAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		}		
	});	
	cbxTipoContacto.reload();
	/**
	*	GRID LISTADO IDIOMAS PERSONAS
	*/
	
	var grdContactoPersona = new bsxTable({
		id:"grdContactoPersona",
		renderTo:"divGrdContactoPersona",
		width:"230",
		height:"206",
		webService:{
			url:URL_WS+"Cgg_res_persona_contacto",
			method:"selectPageContactosPersona",
			reader:{totalCountName:"totalCount",dataSetName:"dataSet"},		
			params:[
				{name:"start",value:"0"},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:"CRTCO_NOMBRE"},
				{name:"dir",value:"ASC"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"},
				{name:"inCrper_codigo",value:codigoPersona}	
			]
		},
		columns:[{name:'CRTCO_NOMBRE',title:'Tipo',width:75},{name:'CRPRC_CONTACTO',title:'Contacto',width:150}],
		events:{
			selectedRow:function(t,dr,r){
				txtCrprc_codigo.value = dr.CRPRC_CODIGO;
				txtCrprc_contacto.value = dr.CRPRC_CONTACTO;
				cbxTipoContacto.dom.value = dr.CRTCO_CODIGO;				
			}
		}
	});	
	grdContactoPersona.show();
	grdContactoPersona.reload();	
	/**
	*	GUARDAR O ACTUALIZAR DATOS SOBRE CONTACTOS DE LA PERSONA
	*/
	btnGuardarCgg_gem_contacto_persona.onclick=function(){
		function CallBackCgg_gem_contacto_persona(v){
			if (v=="true"){
				limpiarControlesContactoPersona();
				grdContactoPersona.reload();
				btnSalirAll(FrmContactoPersona);
			}else{
				new bsxMessageBox({title:"Contactos",msg:'Informaci\u00F3n no almacenada',icon:"iconError"});				
			}
		}
		var param = new SOAPClientParameters();	
		if (txtCrprc_codigo.value.length>0){
			metodoContactoPersona = 'update';
			param.add('inCrprc_codigo',txtCrprc_codigo.value);
		}else{
			metodoContactoPersona = 'insert';
		}
		param.add('inCrtco_codigo',cbxTipoContacto.dom.value);						
		param.add('inCrper_codigo',codigoPersona);
		param.add('inCrprc_descripcion','');
		param.add('inCrprc_contacto',txtCrprc_contacto.value);			
		
		SOAPClient.invoke(URL_WS+"Cgg_res_persona_contacto",metodoContactoPersona,param, true, CallBackCgg_gem_contacto_persona);
	}
	
	/**
	*	GRID LISTADO IDIOMAS PERSONAS
	*/
	
	var colTablePerfilAdjunto=[		
		{name:'CGPFA_TIPO_ADJUNTO',width:20,
			renderer:function(v){
				var extArchivo = v.toUpperCase();
				var srcValor = 'css/icon/adjunto.png'
				if(extArchivo == 'PDF'){
					srcValor = 'css/icon/pdf.gif'
				}else{
					if(extArchivo == 'JPG' || extArchivo == 'JPEG' || extArchivo == 'PNG' || extArchivo == 'BMP' || extArchivo == 'GIF'){
						srcValor='css/icon/images.jpg';
					}else{
						if(extArchivo == 'DOC' || extArchivo == 'DOCX'){
							srcValor = 'css/icon/word07.gif';
						}else{
							if(extArchivo == 'TXT'){
								srcValor = 'css/icon/txt.gif'
							}
						}
					}
				}
				return "<img src='"+srcValor+"'/>";
			}
		},
		{name:'CGPFA_DESCRIPCION',title:'Descripci\u00F3n',width:550},
		{name: 'CGPFA_CODIGO',title:'Adjunto',width:30, 
			renderer:function(v,r){					
				var url1 =URL_WS+'DocViewer'+'?table=cgg_gem_perfil_adjunto&keyc=cgpfa_codigo&keyv='+v+'&column=cgpfa_adjunto&fn='+r.CGPFA_NOMBRE_ADJUNTO+'&request=view';
				return "<button onclick=\"window.open('"+url1+"');\"><img src='"+'css/icon/buscar.png'+"'/></button>";								
			}
		},
		{name:'CGPFA_CODIGO',width:15,
			renderer:function(v,r){	
				var url1 = URL_WS+'DocViewer'+'?table=cgg_gem_perfil_adjunto&keyc=cgpfa_codigo&keyv='+v+'&column=cgpfa_adjunto&fn='+r.CGPFA_NOMBRE_ADJUNTO+'&request=download';
				return "<button onclick=\"window.open('"+url1+"');\"><img src='"+'css/icon/kget.png'+"'/></button>";								
			}
		}	
		
	];
			
	var grdPerfilAdjunto = new bsxTable({
		id:"grdPerfilAdjunto",
		renderTo:"divGrdPerfilAdjunto",
		width:"670",
		height:"100",
		
		webService:{
			url:URL_WS+"Cgg_gem_perfil_adjunto",
			method:"selectAdjuntosByIdPersona",
			params:[
				{name:"format",value:"JSON"},				
				{name:"inCgpfa_tipo",value:0},	
				{name:"inCrper_codigo",value:codigoPersona}				
			]			
		},
		columns:colTablePerfilAdjunto,		
		events:{
			selectedRow:function(t,dr,r){
				cgpfa_codigo.value = dr.CGPFA_CODIGO;
				crper_codigo.value = dr.CRPER_CODIGO;
				cgpfa_descripcion.value = dr.CGPFA_DESCRIPCION;
				cgpfa_tipo_adjunto.value = dr.CGPFA_TIPO_ADJUNTO;
				cgpfa_nombre_adjunto.value = dr.CGPFA_NOMBRE_ADJUNTO;				
			}
		}
	});	
	grdPerfilAdjunto.show();
	grdPerfilAdjunto.reload();
	
	var grdPerfilAdjuntoCertificado = new bsxTable({
		id:"grdPerfilAdjuntoCertificado",
		renderTo:"divGrdPerfilAdjuntoCertificado",
		width:"675",
		height:"100",
		
		webService:{
			url:URL_WS+"Cgg_gem_perfil_adjunto",
			method:"selectAdjuntosByIdPersona",			
			params:[
				{name:"format",value:"JSON"},				
				{name:"inCgpfa_tipo",value:1},	
				{name:"inCrper_codigo",value:codigoPersona}				
			]			
		},
		columns:colTablePerfilAdjunto,		
		events:{
			selectedRow:function(t,dr,r){
				cgpfa_codigoCertificado.value = dr.CGPFA_CODIGO;
				crper_codigoCertificado.value = dr.CRPER_CODIGO;
				cgpfa_descripcionCertificado.value = dr.CGPFA_DESCRIPCION;
				cgpfa_tipo_adjuntoCertificado.value = dr.CGPFA_TIPO_ADJUNTO;				
				cgpfa_nombre_adjuntoCertificado.value = dr.CGPFA_NOMBRE_ADJUNTO;				
			}
		}
	});	
	grdPerfilAdjuntoCertificado.show();

	/*
	*Creacion de un combobox con datos de un webservices
	*/
	var cbxPais = new bsxComboBox({
		id:"cbxPais",
		width:105,
		renderTo:"tdPais",		
		displayField:"CPAIS_NOMBRE",
		valueField:"CPAIS_CODIGO",		
		webService:{
			url:URL_WS+"Cgg_pais",
			method:"selectAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		},
		events:{
            load:function(v){
				cbxPais.dom.value = "cgg_cpais_codigo";
				var newOpt = new Option("No especificado", "");
				cbxPais.dom.options[cbxPais.dom.length] = newOpt;
				cbxPais.dom.selectedIndex=cbxPais.dom.length-1;
				swPais = true;
				if(codigoPais)
					cbxPais.dom.value = codigoPais;
				
            }
        }		
	});		
	cbxPais.reload();
	
	var cbxProvincia = new bsxComboBox({
		id:"cbxProvincia",
		width:105,
		renderTo:"tdProvincia",		
		displayField:"CGPRV_NOMBRE",
		valueField:"CGPRV_CODIGO",
		webService:{
			url:URL_WS+"Cgg_provincia",
			method:"selectAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		},
		events:{
            load:function(v){			
				var newOpt = new Option("No especificado", "");
				cbxProvincia.dom.options[cbxProvincia.dom.length] = newOpt;
				cbxProvincia.dom.selectedIndex=cbxProvincia.dom.length-1;
				if (swDatosPersona==true)
					cbxProvincia.dom.value = codigoProvincia;
				swProvincia = true;
            }
        }
	});	
	cbxProvincia.reload();
	var cbxCiudad = new bsxComboBox({
		id:"cbxCiudad",
		width:105,
		renderTo:"tdCanton",		
		displayField:"CCTN_NOMBRE",
		valueField:"CCTN_CODIGO",
		webService:{
			url:URL_WS+"Cgg_canton",
			method:"selectAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		},
		events:{
            load:function(v){
				cbxCiudad.dom.value = "cctn_codigo";
				var newOpt = new Option("No especificado", "");
				cbxCiudad.dom.options[cbxCiudad.dom.length] = newOpt;
				cbxCiudad.dom.selectedIndex=cbxCiudad.dom.length-1;
				if(swDatosPersona==true)
					cbxCiudad.dom.value = codigoCiudad;
				swCiudad = true;				
            }
        }
	});	
	cbxCiudad.reload();
	var cbxParroquia = new bsxComboBox({
		id:"cbxParroquia",
		renderTo:"tdParroquia",		
		displayField:"CPRR_NOMBRE",
		valueField:"CPRR_CODIGO",
		webService:{
			url:URL_WS+"Cgg_parroquia",
			method:"selectAll",
			params:[							
				{name:"format",value:"JSON"}
			]
		},
		events:{			
            load:function(v){
				cbxParroquia.dom.name = "cprr_codigo";
				var newOpt = new Option("No especificado", "");
				cbxParroquia.dom.options[cbxParroquia.dom.length] = newOpt;
				cbxParroquia.dom.selectedIndex=cbxParroquia.dom.length-1;
            }
        }		
	});	
	cbxParroquia.reload();
	/**
	* FUNCIONES
	*/	
	var divCginf_Calificacion = document.getElementById("divCginf_Calificacion");
	function cargarComponentesInformacionLaboral(datos){
		if(datos[0].CGINF_TRAB_OTRA_CIUDAD==1)
			chkCginf_trab_otra_ciudad.checked=true;
		else
			chkCginf_trab_otra_ciudad.checked=false;
		txtCrper_aspiracion_salarial.value=datos[0].CRPER_ASPIRACION_SALARIAL||'';
		if (datos[0].CGINF_DISPONIBILIDAD)
			txtCginf_disponibilidad.value=datos[0].CGINF_DISPONIBILIDAD
		if(datos[0].CGINF_HIJOS)
			txtCginf_hijos.value=datos[0].CGINF_HIJOS	
		
		txtCginf_Calificacion.value=datos[0].CGINF_CALIFICACION||0;
		setCalificacion (txtCginf_Calificacion.value);
		
		
		if(datos[0].CGINF_LICENCIA_CONDUCIR==1)
			txtCginf_licencia_cond.checked=true;
		else
			txtCginf_licencia_cond.checked=false;
		cbmCginf_estado_laboral.value=datos[0].CGINF_ESTADO_LABORAL;
		if(datos[0].CGINF_OBSERVACIONES)
			cbmCginf_obserbaciones.value=datos[0].CGINF_OBSERVACIONES
		codigoInformacionLaboral=datos[0].CGINF_CODIGO;
		
	}
	function setCalificacion(v){
		txtCginf_Calificacion.value = v;
		divCginf_Calificacion.innerHTML="";
		for (var i = 1;i<=5 ; i++){
			var strUrlImg = (i<= v)?"staron.jpg":"staroff.jpg";
			divCginf_Calificacion.innerHTML+="<img title='"+i+"' src='css/image/"+strUrlImg+"' id ='imgCal"+i+"'/>";			
		}
		/*for (var i = 1;i<=10 ; i++){
			document.getElementById("imgCal"+i).onclick = function(){
				setCalificacion(this.title);
			}
		}*/
	}
	function limpiarControlesIdiomaPersona(){
		txtCgidp_codigo.value='';
		cbxIdiomas.dom.value = 0;
		numCgidp_escritura.value='';
		numCgidp_lectura.value = '';
		numCgidp_hablar.value = '';
		numCgidp_escuchar.value = '';
	}
	function limpiarControlesExperienciaLaboral(){
		txtCgexl_codigo.value='';
		txtCgexl_razon_social.value='';
		txtCgexl_ciudad.value = '';
		txtCgexl_cargo.value = '';
		txtCgexl_descripcion.value = '';
		dtCgexl_fecha_inicio.value = '';
		dtCgexl_fecha_fin.value = '';
		numCgexl_personas_cargo.value = '';
		txtCgexl_contacto.value = '';
		txtCgexl_telefono.value = '';
		txtCgexl_observaciones.value = '';
	}
	function limpiarControlesDestrezaPersona(){
		txtCgdpr_codigo.value='';
		cbxDestrezas.dom.index = 0;
	}
	function limpiarControlesHabilidadesPersona(){
		txtCgdpr_codigoHabilidades.value='';
		cbxHabilidades.dom.index = 0;
	}
	function limpiarControlesPerfilProfesional(){
		txtCgppr_codigo.value = '';
		txtCgien_codigo.value = '';
		txtCgtpr_codigo.value = '';
		txtCgesp_codigo.value = '';
		numCgppr_nivel_aprobado.value = '';
		dtCgppr_fecha_inicio.value = '';
		dtCgppr_fecha_fin.value = '';
		chkCgppr_confirmado.checked = false;
		chkCgppr_predeterminado.checked = false;

	}
	function limpiarControlesContactoPersona(){
		txtCrprc_codigo.value = '';
		txtCrprc_contacto.value = '';
	}
	function rndDuracionHoras(v){
		return v + " horas";
	}
	function rndTipoCertificado(v){
		switch(v){
			case 0:v="Curso de capacitaci\u00F3n";break;
			case 1:v="Seminario";break;
			case 2:v="Cartificados laborales o acad\u00E9micas";break;
			default: v="Curso de capacitaci\u00F3n";break;
        }
		return v;
	}
	function rndPorcentaje(v){
		return v + " %";
	}
	function rndNivelAprobado(v){	
		switch(v){
			case '0':v= "Finalizado";break;			
			default: v= v + " Niveles"
        }
		return v;
	}
	var a = $("up2");
		var b = $("dn2");

	a.style.display = "none";
	b.style.display = "none";
	numCgppr_nivel_aprobado.disabled = true;
	$("chkCgppr_finalizado").onclick = function(){
		
		if ($("chkCgppr_finalizado").checked){
			a.style.display = "none";
			b.style.display = "none";
			numCgppr_nivel_aprobado.disabled = true;
		}
		else{
			a.style.display = "block";
			b.style.display = "block";
			numCgppr_nivel_aprobado.value = '0';
			numCgppr_nivel_aprobado.disabled = false;
		}
	}
	setHeightForm();
}
	
