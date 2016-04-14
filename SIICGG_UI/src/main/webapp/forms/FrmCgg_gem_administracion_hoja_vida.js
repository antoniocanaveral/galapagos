/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_isla.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_gem_administracion_hoja_vida(inDesktop,in_Crper_codigo,IN_BUSQUEDA_PERFIL){    
    var tituloCgg_gem_administracion_hoja_vida='Hoja de Vida';
    var descCgg_gem_administracion_hoja_vida='El formulario permite administrar informaci\u00f3n sobre la hoja de vida de la persona';
    in_Crper_codigo=in_Crper_codigo?in_Crper_codigo:'CRPER1010';

    /**
	 * Ext.Button Boton que permite salir de la ventana winFrmCgg_gem_administracion_hoja_vida.
	 */
    var btnSalirCgg_gem_administracion_hoja_vida = new Ext.Button({
        id:'btnSalirCgg_gem_administracion_hoja_vida',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Salir del formulario',
		hidden:true,
        listeners:{
            click:function(){
                winFrmCgg_gem_administracion_hoja_vida.close();
            }
        }
    });
    function rndFormatFecha(v){
		return Ext.util.Format.date(v,"Y-m-d");
	}
    function rndDuracion(v){
		return v + " horas";
	}
    function rndTipoCertificado(v){
		switch(v){
			case 0:v="Curso de capacitaci\u00F3n";break;
			case 1:v="Seminario";break;
			case 2:v="Cartificafi\u00F3nes laborales o acad\u00E9micas";break;
        }
		return v;
	}

    function rndPorcentaje(v){
		return v + " %";
	}

    var tplPersonaDatosPersonales = new Ext.Template(
		'<table width="100%" height="300px" class="cggTemplate"><tr>'+
			'<td width="30px" valign="top"><table cellspacing=5>'+
				'<tr><th>Imagen:</th></tr>'+
                '<tr><td><img id="imgFotoCurriculum" width="80px" height="100px" style="padding:10px"/></td></tr>'
                +
		'</table></td>'+
			'<td width="60%" valign="top"><table cellspacing=5>'+
                '<tr><th>Nombre:</th><td><span>{CRPER_NOMBRES}</span></td></tr>',
                '<tr><th>Apellido:</th><td><span>{CRPER_APELLIDO_PATERNO} {CRPER_APELLIDO_MATERNO}</span></td></tr>',
                '<tr><th>Documento Iden.:</th><td><span>{CRPER_NUM_DOC_IDENTIFIC}</span></td></tr>',
                '<tr><th>Fecha Nacimiento:</th><td><span>{CRPER_FECHA_NACIMIENTO:date("d/m/Y")}</span></td></tr>',
				'<tr><th>Edad Actual:</th><td><span id="spEdad"></span></td></tr>',
				'<tr><th>Tipo Sangre:</th><td><span>{CRTSG_DESCRPCION}</span></td></tr>',
                '<tr><th>G\u00E9nero:</th><td><span id="spGenero"></span></td></tr>',            
			'</table></td>'+
            '<td width="40%" valign="top">  <table cellspacing=5>'+
				'<tr><th>Estado Civil:</th><td><span>{CRECV_DESCRPCION}</span></td></tr>',				
				'<tr><th>N\u00FAmero de Hijos:</th><td><span id="spNumHijos"></span></td></tr>',
                '<tr><th>Nacionalidad:</th><td><span>{CGNCN_NACIONALIDAD}</span></td></tr>',
                '<tr><th>Pa\u00EDs:</th><td><span>{CPAIS_NOMBRE}</span></td></tr>',
                '<tr><th>Provincia:</th><td><span>{CGPRV_NOMBRE}</span></td></tr>',
                '<tr><th>Cant\u00F3n:</th><td><span>{CCTN_NOMBRE}</span></td></tr>',
                '<tr><th>Estado Laboral:</th><td><span id="spEstadoLaboral"></span></td></tr>'
                //'<tr><th>Aspiraci\u00F3n Salarial:</th><td><span>$ {CRPER_ASPIRACION_SALARIAL}</span></td></tr>'
				+
			'</table> </td>'+
		'</tr></table>'
	);
	
    /**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre las destrezas de la persona
    */
	var pnlPersonaInformacionLaboral = new Ext.Panel({
		id:"pnlPersonaInformacionLaboral",
		title:"Informaci\u00F3n Laboral",       
        layout:"border",
        anchor:"100%",       
		items:[new FrmCgg_gem_informacion_laboral("","",in_Crper_codigo,"adminHojaVida",IN_BUSQUEDA_PERFIL?"busqueda_perfil":"").getPanel()]
	});	
   
    
    /**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre los contactos de una persona
    */
	var pnlPersonaContactos = new Ext.Panel({
		id:"pnlPersonaContactos",
		title:"Contactos",
        layout:"border",
        anchor:"100%",
        items:[/*grdCgg_contacto_persona*/new FrmListadoCgg_res_persona_contacto("",in_Crper_codigo,"adminHojaVida",IN_BUSQUEDA_PERFIL?"busqueda_perfil":"").getPanel()]
	});
    /**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre la Educación Formal de la persona
    */
	var pnlPersonaEducacionFormal = new Ext.Panel({
		id:"pnlPersonaEducacionFormal",
		title:"Educaci\u00F3n Formal",
        layout:"border",
        anchor:"100%",
        items:[/*grdPersonaEducacionFormal*/new FrmListadoCgg_gem_perfil_prof("",in_Crper_codigo,"adminHojaVida",IN_BUSQUEDA_PERFIL?"busqueda_perfil":"").getPanel()]
	});
    /**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre los titulos que ha obtenido la persona
    */
	var pnlPersonaCertificados = new Ext.Panel({
		id:"pnlPersonaCertificados",
		title:"Certificados Obtenidos",
        layout:"border",
        anchor:"100%",
        items:[/*grdCertificadosPersona*/new FrmListadoCgg_gem_certificado("",in_Crper_codigo,"adminHojaVida",IN_BUSQUEDA_PERFIL?"busqueda_perfil":"").getPanel()]
	});
    /**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre los titulos que ha obtenido la persona
    */
	var pnlPersonaIdiomas = new Ext.Panel({
		id:"pnlPersonaIdiomas",
		title:"Idiomas",
        layout:"border",
        anchor:"100%",
        items:[/*grdPersonaIdiomas*/ new FrmListadoCgg_gem_idioma_persona("",in_Crper_codigo,"adminHojaVida",IN_BUSQUEDA_PERFIL?"busqueda_perfil":"").getPanel()]
	});
    /**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre los titulos que ha obtenido la persona
    */
	var pnlPersonaExperienciaLaboral = new Ext.Panel({
		id:"pnlPersonaExperienciaLaboral",
		title:"Experiencia Laboral",
        layout:"border",
        anchor:"100%",
        items:[/*grdExperienciaLaboralPersona*/new FrmListadoCgg_gem_experiencia_laboral("",in_Crper_codigo,"adminHojaVida",IN_BUSQUEDA_PERFIL?"busqueda_perfil":"").getPanel()]
	});
    /**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre las destrezas de la persona
    */
	var pnlPersonaDestrezas =  new Ext.Panel({
		id:"pnlPersonaDestrezas",
		title:"Destrezas",
        layout:"border",
        anchor:"100%",		
        items:[new FrmListadoCgg_gem_destreza_persona("",in_Crper_codigo,"adminHojaVida",IN_BUSQUEDA_PERFIL?"busqueda_perfil":"").getPanel()]
	}
	);
	/**
     * CAMBIAR DE IMAGEN DEL CURRICULUM
     */
    var btnCgg_gem_administracion_imagen = new Ext.Button({
        id: 'btnCgg_gem_administracion_imagen',
        text: 'Imagen',
        iconCls: 'iconAdjunto',
		tooltip:'Cambiar imagen',
        listeners: {
            click: function () {
				/*var objCND = new ObjectBusquedaCandidato();
                var objBusqueda = new DlgBusqueda(objCND.store,objCND.cm);
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord){
						txtCgcnd_codigo.setValue(tmpRecord.get('NOMBRE_USUARIO'));
						txtCgcnd_codigo_id= tmpRecord.get('CGCND_CODIGO');
					}
					
                });
                objBusqueda.show();*/
            }
        }
    });
	
    /**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre las destrezas de la persona
    */
	var pnlDatosPersonalesPersona = new Ext.Panel({
		id:"pnlDatosPersonalesPersona",
		title: 'Datos personales',    		
        region:'center',
        html:'cargando',
        loadMask:{msg:"Cargando..."},
		tbar:[btnCgg_gem_administracion_imagen]
	});
	
	/**
    * new Ext.TabPanel Panel que contiene el template para visualizar la informacion de la hoja de vida de la persona.
    */
	var tpnlPersonaDatosPersonales = new Ext.TabPanel({
		id:"tpnlPersonaDatosPersonales",
		activeTab: 0,
        region:'center',
		enableTabScroll:true,		
		items:[pnlDatosPersonalesPersona,pnlPersonaContactos,pnlPersonaInformacionLaboral,pnlPersonaEducacionFormal,pnlPersonaCertificados,pnlPersonaIdiomas,pnlPersonaExperienciaLaboral,pnlPersonaDestrezas]
	});
    /**
	  * Ext.data.Store registros de la tabla Cgg_res_persona por un campo especifico.
	  */
    var gscCgg_gem_administracion_hoja_vida = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_persona",
            method:"selectDatosPersonalesById"
        }),
        reader:new Ext.data.JsonReader({},[
            {name:'CRPER_NOMBRES'},
			{name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_APELLIDO_MATERNO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_FECHA_NACIMIENTO',type:"date",dateFormat:'Y-m-d H:i:s.u'},
			{name:'CGNCN_NACIONALIDAD'},
            {name:'CRPER_GENERO'},
            {name:'CRECV_DESCRPCION'},
            {name:'CPAIS_NOMBRE'},
            {name:'CGPRV_NOMBRE'},
            {name:'CCTN_NOMBRE'},
            {name:'CRPER_EMPLEADO'},
			{name:'CRPER_NUMERO_RESIDENCIA'},
			{name:'CRTSG_DESCRPCION'},
			{name:'CGINF_HIJOS'},
            {name:'CRPER_ASPIRACION_SALARIAL'}
        ]),
        baseParams:{
            inCrper_codigo:in_Crper_codigo,
            format:"JSON"
        },
        listeners:{
            'load':function(obj,rec){
                if(gscCgg_gem_administracion_hoja_vida.getCount()>0){
                    tplPersonaDatosPersonales.overwrite(pnlDatosPersonalesPersona.body,rec[0].data);                    
                    var valorFoto = gscCgg_gem_foto_curriculum.getAt(0).get('FOTO_CURRICULUM')
                    if(valorFoto!=null && valorFoto!=undefined && valorFoto!="")
                    {
                        document.getElementById('imgFotoCurriculum').src="data:image/jpg;base64,"+gscCgg_gem_foto_curriculum.getAt(0).get('FOTO_CURRICULUM')
                    }else{
                        if(rec[0].get('CRPER_GENERO')==0){
                            document.getElementById('imgFotoCurriculum').src="resources/images/male_avatar.jpeg"
                        }
                        if(rec[0].get('CRPER_GENERO')==1){
                            document.getElementById('imgFotoCurriculum').src="resources/images/female_avatar.jpg"
                        }
                    }
                    if(rec[0].get('CRPER_GENERO')==0){
                           document.getElementById('spGenero').innerHTML="Masculino"
                    }
                    if(rec[0].get('CRPER_GENERO')==1){
                        document.getElementById('spGenero').innerHTML="Femenino"
                    }
                    if(rec[0].get('CRPER_EMPLEADO'))
                        document.getElementById('spEstadoLaboral').innerHTML="Activo"
                    else
                        document.getElementById('spEstadoLaboral').innerHTML="Pasivo"
						
					if(rec[0].get('CGINF_HIJOS')){
						document.getElementById('spNumHijos').innerHTML=rec[0].get('CGINF_HIJOS')
					}else{
						document.getElementById('spNumHijos').innerHTML="0"
					}					
					if (rec[0].get('CRPER_FECHA_NACIMIENTO')){
						var edad = fnCalcularEdad(rec[0].get('CRPER_FECHA_NACIMIENTO'));
						document.getElementById('spEdad').innerHTML=edad+" a\u00F1os"
					}
					
                }
            }

        }
    });
	 function fnCalcularEdad(fechaNacimiento){		        
		var dia_nacim = fechaNacimiento.getDay();
        var mes_nacim = fechaNacimiento.getMonth();
        var anio_nacim = fechaNacimiento.getFullYear();
		fecha_hoy = new Date();
		ahora_anio = fecha_hoy.getFullYear();
		ahora_mes = fecha_hoy.getMonth();
		ahora_dia = fecha_hoy.getDay();
		edad = (ahora_anio) - anio_nacim;
		if ( ahora_mes < (mes_nacim))
		{
		  edad--;
		}
		if (((mes_nacim) == ahora_mes) && (ahora_dia < dia_nacim))
		{
		  edad--;
		}

		return edad;
	}
	
     /**
	  * Ext.data.Store registros de la tabla Cgg_res_persona por un campo especifico.
	  */
    var gscCgg_gem_foto_curriculum = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_persona",
            method:"selectFotoCurriculumById"
        }),
        reader:new Ext.data.JsonReader({},[
            {
            name:'FOTO_CURRICULUM'
            }
        ]),
        baseParams:{
            inCrper_codigo:in_Crper_codigo,
            format:"JSON"
        },
        listeners:{
            'load':function(obj,rec){					
				gscCgg_gem_administracion_hoja_vida.load();
            }
        }
    });
	
	
    /**
	  * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_isla.
	  */

    
       var winFrmCgg_gem_administracion_hoja_vida = new Ext.Window({
            id:'winFrmCgg_gem_administracion_hoja_vida',
            tbar:getPanelTitulo(tituloCgg_gem_administracion_hoja_vida,descCgg_gem_administracion_hoja_vida),
            title:tituloCgg_gem_administracion_hoja_vida,		
			width:700,
			minWidth:700,
			height:500,
			minHeight:300,
            maximizable:false,
			minimizable:false,			
			modal:true,
            constrain:true,            
            items:[tpnlPersonaDatosPersonales],
            listeners:{
                'show':function(){
                    gscCgg_gem_foto_curriculum.load()
                }
            },
            layout:'border',           
            bbar:['->',btnSalirCgg_gem_administracion_hoja_vida]
        });
    
    /**
	  * Funcion que aplica los privilegios del usuario.
	  */
    //applyGrants(winFrmCgg_gem_administracion_hoja_vida.getBottomToolbar());
    /**
	  * Funcion miembro que devuelve la ventana winFrmListadoCgg_isla.
	  * @returns ventana winFrmCgg_isla.
	  * @base FrmListadoCgg_isla.prototype.show
	  */
    this.getWindow = function(){
        return winFrmCgg_gem_administracion_hoja_vida;
    }
    /**
	  * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_isla.
	  * @base FrmListadoCgg_isla.prototype.loadData
	  */
    this.loadData = function(){
        gscCgg_gem_administracion_hoja_vida.load();
    }

    /**
	  * Funcion miembro que develve el Store utilizado en el listado.
	  */
    this.getStore = function(){
        return gscCgg_gem_administracion_hoja_vida;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmCgg_gem_administracion_hoja_vida.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmCgg_gem_administracion_hoja_vida.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_isla desde una instancia.
 */
FrmCgg_gem_administracion_hoja_vida.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_isla desde una instancia.
 */
FrmCgg_gem_administracion_hoja_vida.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_isla,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_gem_administracion_hoja_vida.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_isla desde una instancia.
 */
FrmCgg_gem_administracion_hoja_vida.prototype.loadData = function(){
    this.loadData();
}