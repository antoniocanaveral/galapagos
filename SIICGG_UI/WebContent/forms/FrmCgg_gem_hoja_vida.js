/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_isla.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_gem_hoja_vida(inDesktop,in_Crper_codigo){
    var tituloCgg_gem_hoja_vida='Hoja de Vida';
    var descCgg_gem_hoja_vida='El formulario permite administrar informaci\u00f3n sobre la hoja de vida de la persona';  

    /**
	 * Ext.Button Boton que permite salir de la ventana winFrmCgg_gem_hoja_vida.
	 */
    var btnSalirCgg_gem_hoja_vida = new Ext.Button({
        id:'btnSalirCgg_isla',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Salir del formulario',
        listeners:{
            click:function(){
                winFrmCgg_gem_hoja_vida.close();
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
    /*
    0 - CURSO DE CAPACITACION
1 - SEMINARIO
2 - CERTIFICACIONES LABORALES O ACADEMICAS
     */
/*
"<tpl if='shortName > \"\"'>","<span>{shortName}</span>", "</tpl>",
  */
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
	var tplInformacionLaboral = new Ext.Template(
		'<table width="100%" height="300px" class="cggTemplate"><tr>'+		
			'<td width="60%" valign="top"><table cellspacing=5>'+
                '<tr><th>Disponibilidad para trabajar en otra ciudad:</th><td><span id="spTrab_otra_ciudad"></span></td></tr>',
                '<tr><th>Aspiraci\u00F3n Salarial:</th><td><span>$ {CRPER_ASPIRACION_SALARIAL}</span></td></tr>',
                '<tr><th>Tiempo para asumir un  uevo puesto:</th><td><span>{CGINF_DISPONIBILIDAD}</span></td></tr>',
                '<tr><th>Veh\u00EDculo propio:</th><td><span id="spVehiculo"></span></td></tr>',				
				        
			'</table></td>'+
            '<td width="40%" valign="top">  <table cellspacing=5>'+
				//'<tr><th>Estado Civil:</th><td><span>{CRECV_DESCRPCION}</span></td></tr>',	
				'<tr><th>Licencia de conducir:</th><td><span id="spLicenciaConducir"></span></td></tr>',
				'<tr><th>Estado Laboral:</th><td><span id="spEstadoLaboralPersona"></span></td></tr>',
				'<tr><th>Observaci\u00F3n:</th><td><span>{CGINF_OBSERVACIONES}</span></td></tr>', 
				//+
			'</table> </td>'+
		'</tr></table>'
	);
	
    /**
	* Ext.grid.ColumnModel Define el modelo de columnas para el EL GRID
	*/
	var cmCgg_contacto_persona = new Ext.grid.ColumnModel([
            {dataIndex:'CRTCO_NOMBRE',header:'Tipo de Contacto',width:100,sortable:true},
			{dataIndex:'CRTCO_NOMBRE',header:'Tipo de Contacto',width:100,sortable:true},
			{dataIndex:'CRPRC_CONTACTO',header:'Contacto',width:450,sortable:true}
			]);
    /**
	  * Ext.data.Store registros de la tabla Cgg_res_persona por un campo especifico.
	  */
    var gscCgg_gem_contacto_persona = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_persona_contacto",
           // method:"selectContactosPersonaById"
            method:"selectPersonaContacto"
        }),
        reader:new Ext.data.JsonReader({},[
            {
            name:'CRTCO_NOMBRE'
            },
            {
            name:'CRPRC_CONTACTO'
            },
            {
            name:'CRTCO_NOMBRE_IMAGEN'
            }
        ]),
        baseParams:{
            inCrper_codigo:in_Crper_codigo,
            format:"JSON"
        }
    });
//    gscCgg_gem_contacto_persona.reload();

    /**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Bsx_canton en un formato tabular de filas y columnas.
	*/
	var grdCgg_contacto_persona = new Ext.grid.GridPanel({
			cm:cmCgg_contacto_persona,
			store:gscCgg_gem_contacto_persona,
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
            region:"center"

	});

    /**
	* Ext.grid.ColumnModel Define el modelo de columnas para el EL GRID
	*/
	var cmPersonaEducacionFormal = new Ext.grid.ColumnModel([
			{dataIndex:'CGNES_DESCRIPCION',header:'Nivel de Estudio',width:100,sortable:true},
			{dataIndex:'CGIED_NOMBRE',header:'Instituci\u00F3n Educativa',width:200,sortable:true},			
            {dataIndex:'CGTPR_DESCRIPCION',header:'T\u00EDtulo',width:140,sortable:true},
			{dataIndex:'CGESP_NOMBRE',header:'Especialidad',width:140,sortable:true},
			{dataIndex:'CGPPR_FECHA_INICIO',header:'Fecha Inicio',width:70,sortable:true},
			{dataIndex:'CGPPR_FECHA_FIN',header:'Fecha F\u00EDn',width:70,sortable:true}
			]);
    /**
	  * Ext.data.Store registros de la tabla Cgg_res_persona por un campo especifico.
	  */
    var gscPersonaEducacionFormal = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_gem_perfil_prof",
            method:"selectEducacionById"
        }),
        reader:new Ext.data.JsonReader({},[
            {name:'CGIED_NOMBRE'},
            {name:'CGNES_DESCRIPCION'},
            {name:'CGESP_NOMBRE'},
            {name:'CGTPR_DESCRIPCION'},
            {name:'CGPPR_FECHA_INICIO'},
			{name:'CGPPR_FECHA_FIN'}
			/*			
			IED.CGIED_NOMBRE, 
		NES.CGNES_DESCRIPCION,
		ESP.CGESP_NOMBRE,
		TPR.CGTPR_DESCRIPCION,
		PPR.CGPPR_FECHA_INICIO,
		PPR.CGPPR_FECHA_FIN*/
        ]),
        baseParams:{
            inCrper_codigo:in_Crper_codigo,
            format:"JSON"
        }
    });
//    gscPersonaEducacionFormal.reload();

    /**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Bsx_canton en un formato tabular de filas y columnas.
	*/
	var grdPersonaEducacionFormal = new Ext.grid.GridPanel({
			cm:cmPersonaEducacionFormal,
			store:gscPersonaEducacionFormal,
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
            //height:100
            region:"center"
	});
     /**
	* Ext.grid.ColumnModel Define el modelo de columnas para el EL GRID
	*/
	var cmCertificadosPersona = new Ext.grid.ColumnModel([
			{dataIndex:'CGCER_INSTITUCION',header:'Instituci\u00F3n Educat\u00EDva',width:150,sortable:true},
            {dataIndex:'CGCER_NOMBRE',header:'Certificado',width:150,sortable:true},
            {dataIndex:'CGCER_DESCRIPCION',header:'Descripci\u00F3n',width:150,sortable:true},
            {dataIndex:'CGCER_DURACION',header:'Duraci\u00F3n (Horas)',width:100,sortable:true, renderer: rndDuracion},
            {dataIndex:'CGCER_FECHA_INICIO',header:'Fecha Inicio',width:90,sortable:true, renderer:rndFormatFecha},
            {dataIndex:'CGCER_FECHA_FIN',header:'Fecha Finalizaci\u00F3n',width:110,sortable:true, renderer:rndFormatFecha},
            {dataIndex:'CGCER_TIPO',header:'Tipo de Certificado',width:150,sortable:true, renderer: rndTipoCertificado,hidden:true},			
			{xtype: 'actioncolumn',width: 80,header:'Adjunto',
				items: [{
					iconCls: 'iconBuscar',                // Use a URL in the icon config
					tooltip: 'Ver adjunto',
					handler: function(grid, rowIndex, colIndex) {
						grdCertificadosPersona.getSelectionModel().selectRow(rowIndex);
						var rAdjuntoCertificado = grdCertificadosPersona.getSelectionModel().getSelected();
						if(rAdjuntoCertificado){
							var objCrate_data = rAdjuntoCertificado.get('CGCER_CODIGO');
							if(objCrate_data){
								var url1 = URL_DOC_VIEWER+'?table=cgg_gem_certificado&keyc=cgcer_codigo&keyv='+objCrate_data +'&column=cgcer_adjunto&fn='+rAdjuntoCertificado.get('CGCER_NOMBRE_ADJUNTO')+'&request=view';
								//alert(url1);
								window.open(url1);
							}
							
						}
					}
				}]
			},
			
			]);
   
    /**
	  * Ext.data.Store registros de la tabla Cgg_res_persona por un campo especifico.
	  */
    var gscCertificadosPersona = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_gem_certificado",
            method:"selectCertificadosPersonaById"
        }),
        reader:new Ext.data.JsonReader({},[
			{
            name:'CGCER_CODIGO'
            },
            {
            name:'CGCER_INSTITUCION'
            },
            {
            name:'CGCER_NOMBRE'
            },
			{
            name:'CGCER_NOMBRE_ADJUNTO'
            },
            {
            name:'CGCER_DESCRIPCION'
            },
            {
            name:'CGCER_DURACION'
            },
            {
            name:'CGCER_FECHA_INICIO'
            },
            {
            name:'CGCER_FECHA_FIN'
            },
            {
            name:'CGCER_TIPO'
            }

        ]),
        baseParams:{
            inCrper_codigo:in_Crper_codigo,
            format:"JSON"
        },
        groupField:'CGCER_TIPO'
    });
//    gscCertificadosPersona.reload();

    /**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Bsx_canton en un formato tabular de filas y columnas.
	*/
	var grdCertificadosPersona = new Ext.grid.EditorGridPanel({
			cm:cmCertificadosPersona,
			store:gscCertificadosPersona,
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
            region:"center",
            view: new Ext.grid.GroupingView({
                groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
                }),
			clicksToEdit: 1
	});

    /**
	* Ext.grid.ColumnModel Define el modelo de columnas para el EL GRID
	*/
	var cmPersonaIdiomas = new Ext.grid.ColumnModel([
			{dataIndex:'CGIDM_NOMBRE',header:'Idioma',width:100,sortable:true},
            {dataIndex:'CGIDP_ESCRITURA',header:'Porcentaje Escrito',width:120,sortable:true, renderer:rndPorcentaje},
            {dataIndex:'CGIDP_LECTURA',header:'Porcentaje Lectura',width:120,sortable:true,renderer:rndPorcentaje},
            {dataIndex:'CGIDP_HABLAR',header:'Porcentaje Hablado',width:120,sortable:true,renderer:rndPorcentaje},
            {dataIndex:'CGIDP_ESCUCHAR',header:'Porcentaje Escuchado',width:120,sortable:true,renderer:rndPorcentaje}
			]);
    /**
	  * Ext.data.Store registros de la tabla Cgg_res_persona por un campo especifico.
	  */
    var gscPersonaIdiomas = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_gem_idioma_persona",
            method:"selectIdiomasPersonaById"
        }),
        reader:new Ext.data.JsonReader({},[
            {
            name:'CGIDM_NOMBRE'
            },
            {
            name:'CGIDP_ESCRITURA'
            },
            {
            name:'CGIDP_LECTURA'
            },
            {
            name:'CGIDP_HABLAR'
            },
            {
            name:'CGIDP_ESCUCHAR'
            }
        ]),
        baseParams:{
            inCrper_codigo:in_Crper_codigo,
            format:"JSON"
        }
    });
//    gscPersonaIdiomas.reload();

    /**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Bsx_canton en un formato tabular de filas y columnas.
	*/
	var grdPersonaIdiomas = new Ext.grid.GridPanel({
			cm:cmPersonaIdiomas,
			store:gscPersonaIdiomas,
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
            region:"center"
	});
    /**
	* Ext.grid.ColumnModel Define el modelo de columnas para el EL GRID
	*/
	var cmExperienciaLaboralPersona = new Ext.grid.ColumnModel([
			{dataIndex:'CGEXL_RAZON_SOCIAL',header:'Empresa',width:150,sortable:true},
            {dataIndex:'CGEXL_CARGO',header:'Cargo',width:150,sortable:true},
            {dataIndex:'CGEXL_FECHA_INICIO',header:'Fecha Inicio',width:90,sortable:true,renderer:rndFormatFecha},
            {dataIndex:'CGEXL_FECHA_FIN',header:'Fecha Fin',width:90,sortable:true,renderer:rndFormatFecha},
            {dataIndex:'CGEXL_CONTACTO',header:'Referencia',width:150,sortable:true},
            {dataIndex:'CGEXL_TELEFONO',header:'Contacto Referencia',width:150,sortable:true}
			]);
    /**
	  * Ext.data.Store registros de la tabla Cgg_res_persona por un campo especifico.
	  */
    var gscExperienciaLaboralPersona = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_gem_experiencia_laboral",
            method:"selectExpLaboralPersonaById"
        }),
        reader:new Ext.data.JsonReader({},[
            {
            name:'CGEXL_RAZON_SOCIAL'
            },
            {
            name:'CGEXL_CARGO'
            },
            {
            name:'CGEXL_FECHA_INICIO'
            },
            {
            name:'CGEXL_FECHA_FIN'
            },
            {
            name:'CGEXL_CONTACTO'
            },
            {
            name:'CGEXL_TELEFONO'
            }
        ]),
        baseParams:{
            inCrper_codigo:in_Crper_codigo,
            format:"JSON"
        }
    });
//    gscExperienciaLaboralPersona.reload();

    /**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Bsx_canton en un formato tabular de filas y columnas.
	*/
	var grdExperienciaLaboralPersona = new Ext.grid.GridPanel({
			cm:cmExperienciaLaboralPersona,
			store:gscExperienciaLaboralPersona,
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
            region:"center"
	});

    /**
	* Ext.grid.ColumnModel Define el modelo de columnas para el EL GRID
	*/
	var cmDestrezasPersona = new Ext.grid.ColumnModel([
			{dataIndex:'CGDST_DESCRIPCION',header:'Destrezas',width:550,sortable:true}
			]);
    /**
	  * Ext.data.Store registros de la tabla Cgg_res_persona por un campo especifico.
	  */
    var gscDestrezasPersona = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_gem_destreza_persona",
            method:"selectDestrezasPersonaById"
        }),
        reader:new Ext.data.JsonReader({},[
            {
            name:'CGDST_DESCRIPCION'
            }
        ]),
        baseParams:{
            inCrper_codigo:in_Crper_codigo,
            format:"JSON"
        }
    });
//    gscDestrezasPersona.reload();

    /**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Bsx_canton en un formato tabular de filas y columnas.
	*/
	var grdDestrezasPersona = new Ext.grid.GridPanel({
			cm:cmDestrezasPersona,
			store:gscDestrezasPersona,
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
            region:"center"
	});
	/**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre las destrezas de la persona
    */
	var pnlPersonaInformacionLaboral = new Ext.Panel({
		id:"pnlPersonaInformacionLaboral",
		title:"Informaci\u00F3n Laboral",       
        //height:180,        
        region:'north',
        html:'cargando',
        loadMask:{msg:"Cargando..."},
        listeners:{
            'activate':function(){
				gscInformacionLaboral.reload()
               // gscDestrezasPersona
            }
        }
	});	
   /**
	  * Ext.data.Store registros de la tabla Cgg_gem_informacion_laboral por un campo especifico.
	  */
    var gscInformacionLaboral = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_gem_informacion_laboral",
            method:"selectInformacionLaboralById"
        }),
        reader:new Ext.data.JsonReader({},[
            {
            name:'CGINF_CODIGO'
            },
            {
            name:'CRPER_CODIGO'
            },
            {
            name:'CGINF_TRAB_OTRA_CIUDAD'
            },
            {
            name:'CRPER_ASPIRACION_SALARIAL'
            },
            {
            name:'CGINF_DISPONIBILIDAD'
            },
            {
            name:'CGINF_VEHICULO'
            },
            {
            name:'CGINF_LICENCIA_CONDUCIR'
            },
            {
            name:'CGINF_ESTADO_LABORAL'
            },
            {
            name:'CGINF_HIJOS'
            },
            {
            name:'CGINF_OBSERVACIONES'
            }
        ]),
        baseParams:{
            inCrper_codigo:in_Crper_codigo,
            format:"JSON"
        },
		listeners:{
			'load':function(obj,rec){
				if(gscInformacionLaboral.getCount()>0){
					tplInformacionLaboral.overwrite(pnlPersonaInformacionLaboral.body,rec[0].data);
					var v="";					
					switch(rec[0].get('CGINF_TRAB_OTRA_CIUDAD')){
						case '0':v="No";break;
						case '1':v="Si";break;
						case '2':v="Otro";break;
						default : v="Ninguno"; break;
					}
					document.getElementById('spTrab_otra_ciudad').innerHTML=v;										
					switch(rec[0].get('CGINF_VEHICULO')){
						case '0':v="No";break;
						case '1':v="Si";break;
						case '2':v="Otro";break;
						default : v="Ninguno"; break;
					}
					document.getElementById('spVehiculo').innerHTML=v;
					switch(rec[0].get('CGINF_LICENCIA_CONDUCIR')){
						case '0':v="No";break;
						case '1':v="Si";break;
						case '2':v="Otro";break;
						default : v="Ninguno"; break;
					}
					document.getElementById('spLicenciaConducir').innerHTML=v;										
					switch(rec[0].get('CGINF_ESTADO_LABORAL')){
						case '0':v="No";break;
						case '1':v="Si";break;
						case '2':v="Otro";break;
						default : v="Ninguno"; break;
					}
					document.getElementById('spEstadoLaboralPersona').innerHTML=v;
				}
			}
		}
    });
	//gscInformacionLaboral.reload();
    
    /**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre los contactos de una persona
    */
	var pnlPersonaContactos = new Ext.Panel({
		id:"pnlPersonaContactos",
		title:"Contactos",
        layout:"border",
        anchor:"100%",
        items:[grdCgg_contacto_persona],
        listeners:{
            'activate':function(){
                gscCgg_gem_contacto_persona.reload()
            }
        }
	});
    /**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre la Educación Formal de la persona
    */
	var pnlPersonaEducacionFormal = new Ext.Panel({
		id:"pnlPersonaEducacionFormal",
		title:"Educaci\u00F3n Formal",
        layout:"border",
        anchor:"100%",
        items:[grdPersonaEducacionFormal],
        listeners:{
            'activate':function(){
                gscPersonaEducacionFormal.reload()
            }
        }
	});
    /**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre los titulos que ha obtenido la persona
    */
	var pnlPersonaCertificados = new Ext.Panel({
		id:"pnlPersonaCertificados",
		title:"Certificados Obtenidos",
        layout:"border",
        anchor:"100%",
        items:[grdCertificadosPersona],
        listeners:{
            'activate':function(){
                gscCertificadosPersona.reload()
            }
        }
	});
    /**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre los titulos que ha obtenido la persona
    */
	var pnlPersonaIdiomas = new Ext.Panel({
		id:"pnlPersonaIdiomas",
		title:"Idiomas",
        layout:"border",
        anchor:"100%",
        items:[grdPersonaIdiomas],
        listeners:{
            'activate':function(){
                gscPersonaIdiomas.reload()
            }
        }
	});
    /**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre los titulos que ha obtenido la persona
    */
	var pnlPersonaExperienciaLaboral = new Ext.Panel({
		id:"pnlPersonaExperienciaLaboral",
		title:"Experiencia Laboral",
        layout:"border",
        anchor:"100%",
        items:[grdExperienciaLaboralPersona],
        listeners:{
            'activate':function(){
                gscExperienciaLaboralPersona.reload()
            }
        }
	});
    /**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre las destrezas de la persona
    */
	var pnlPersonaDestrezas = new Ext.Panel({
		id:"pnlPersonaDestrezas",
		title:"Destrezas",
        layout:"border",
        anchor:"100%",
        items:[grdDestrezasPersona],
        listeners:{
            'activate':function(){
                gscDestrezasPersona.reload()
            }
        }
	});
	
    /**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre las destrezas de la persona
    */
	var pnlDatosPersonalesPersona = new Ext.Panel({
		id:"pnlDatosPersonalesPersona",
        height:180,        
        region:'north',
        html:'cargando',
        loadMask:{msg:"Cargando..."}
	});
	/**
    * new Ext.TabPanel Panel que contiene el template para visualizar la informacion de la hoja de vida de la persona.
    */
	var tpnlPersonaDatosPersonales = new Ext.TabPanel({
		id:"tpnlPersonaDatosPersonales",
		activeTab: 0,
		//height:200,
        //frame:true,
        region:'center',
		enableTabScroll:true,
		items:[pnlPersonaContactos,pnlPersonaInformacionLaboral,pnlPersonaEducacionFormal,pnlPersonaCertificados,pnlPersonaIdiomas,pnlPersonaExperienciaLaboral,pnlPersonaDestrezas]
	});
    /**
	  * Ext.data.Store registros de la tabla Cgg_res_persona por un campo especifico.
	  */
    var gscCgg_gem_hoja_vida = new Ext.data.Store({
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
                if(gscCgg_gem_hoja_vida.getCount()>0){
                    tplPersonaDatosPersonales.overwrite(pnlDatosPersonalesPersona.body,rec[0].data);
                    //alert(gscCgg_gem_foto_curriculum.getAt(0).get('FOTO_CURRICULUM'));
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
					
					switch(rec[0].get('CRPER_GENERO')){
						case 0:document.getElementById('spGenero').innerHTML="Masculino";break;
						case 1:document.getElementById('spGenero').innerHTML="Femenino";break;
						default :document.getElementById('spGenero').innerHTML="No especificado";break;
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
					//var actual = new Date();
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
                gscCgg_gem_hoja_vida.load()
            }
        }
    });
	
    /**
	  * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_isla.
	  */

    
        winFrmCgg_gem_hoja_vida = new Ext.Window({
            id:'winFrmCgg_gem_hoja_vida',
            tbar:getPanelTitulo(tituloCgg_gem_hoja_vida,descCgg_gem_hoja_vida),
            title:tituloCgg_gem_hoja_vida,
            width:600,
            minWidth:600,
            height:450,
            minHeight:400,
            maximizable:false,
			minimizable:false,			
			modal:true,
            constrainHeader:true,            
            items:[pnlDatosPersonalesPersona,tpnlPersonaDatosPersonales],
            listeners:{
                'show':function(){
                    gscCgg_gem_foto_curriculum.load()
                }
            },
            layout:'border',
           // tbar:getPanelTitulo('Listado '+tituloListadoCgg_regla_validacion,descListadoCgg_regla_validacion)
            bbar:['->',btnSalirCgg_gem_hoja_vida]
        });
    
    /**
	  * Funcion que aplica los privilegios del usuario.
	  */
    //applyGrants(winFrmCgg_gem_hoja_vida.getBottomToolbar());
    /**
	  * Funcion miembro que devuelve la ventana winFrmListadoCgg_isla.
	  * @returns ventana winFrmCgg_isla.
	  * @base FrmListadoCgg_isla.prototype.show
	  */
    this.getWindow = function(){
        return winFrmCgg_gem_hoja_vida;
    }
    /**
	  * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_isla.
	  * @base FrmListadoCgg_isla.prototype.loadData
	  */
    this.loadData = function(){
        gscCgg_gem_hoja_vida.load();
    }
    /**
	  * Funcion miembro que develve el ColumnModel utilizado en el listado.
	  */
    this.getColumnModel = function(){
        return cmCgg_isla;
    }
    /**
	  * Funcion miembro que develve el Store utilizado en el listado.
	  */
    this.getStore = function(){
        return gscCgg_gem_hoja_vida;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmCgg_gem_hoja_vida.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmCgg_gem_hoja_vida.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_isla desde una instancia.
 */
FrmCgg_gem_hoja_vida.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_isla desde una instancia.
 */
FrmCgg_gem_hoja_vida.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_isla,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_gem_hoja_vida.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_isla desde una instancia.
 */
FrmCgg_gem_hoja_vida.prototype.loadData = function(){
    this.loadData();
}