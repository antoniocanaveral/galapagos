/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_busqueda_perfil.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */

function FrmListadoCgg_gem_busqueda_perfil(inDesktop,btn) {
    var optMenu = 'Gesti\u00F3n de Empleo/Busqueda de perfiles';
    var urlListadoCgg_gem_busqueda_perfil = URL_WS + "Cgg_gem_busqueda_perfil";
    var tituloListadoCgg_gem_busqueda_perfil = 'Busqueda din\u00E1mica de perfiles';
    var descListadoCgg_gem_busqueda_perfil = 'El formulario permite realizar busquedas din\u00E1micas de acuerdo a ciertos parametros de busqueda';
	var codigoPersona;
	var recTmp;
    /**
     * Ext.Button Boton que permite visualizar la hoja de vida de la persona selccionada.
     */
    var btnHojaVida = new Ext.Button({
        id: 'btnHojaVida',
        text: 'Hoja de Vida',
        iconCls: 'iconHojaVida',
		disabled : true,
        listeners: {
            click: function () {
                if (codigoPersona){
					new FrmCgg_gem_hoja_vida(null,codigoPersona).show();	
				}
            }
        }
    });
	
	 /**
     * Ext.Button Boton que permite visualizar la hoja de vida de la persona selccionada.
     */
    var btnSeleccionarCNDHV = new Ext.Button({
        id: 'btnSeleccionarCNDHV',
        text: 'Seleccionar',
        iconCls: 'iconAceptar',		
		disabled:true,
        listeners: {
            click: function () {
                recTmp = grdCgg_res_persona.getSelectionModel().getSelected();
				winFrmListadoCgg_gem_busqueda_perfil.close();
            }
        }
    });
 
    
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_busqueda_perfil.
     */
    var btnSalirCgg_gem_busqueda_perfil = new Ext.Button({
        id: 'btnSalirCgg_gem_busqueda_perfil',
        text: 'Salir',
        iconCls: 'iconSalir',
        listeners: {
            click: function () {
                winFrmListadoCgg_gem_busqueda_perfil.close();
            }
        }
    });
    
    /**
     * Ext.Button Boton para administrar la informacion de la hoja de vida.
     */
    var btnHojaDeVidaCgg_res_persona = new Ext.Toolbar.SplitButton({
        id:'btnHojaDeVidaCgg_res_persona',
        name:'btnHojaDeVidaCgg_res_persona',
        text:'Hoja de Vida',
        disabled:true,
        iconCls:'iconHojaVida',
        menu:[            
			{text:'Informaci\u00F3n Laboral',
                handler:function(){
					if (codigoPersona){
						new FrmCgg_gem_informacion_laboral("","",codigoPersona,"","busqueda_perfil").show();	
					}                    
                }
            },{text:'Educaci\u00F3n Formal',
                handler:function(){
                    if (codigoPersona){
						new FrmListadoCgg_gem_perfil_prof(inDesktop,codigoPersona,"","busqueda_perfil").show();	
					}                    
                }
            },{text:'Certificados Obtenidos',
                handler:function(){
                    if (codigoPersona){
						new FrmListadoCgg_gem_certificado(inDesktop,codigoPersona,"","busqueda_perfil").show();	
					}
                }
            },{text:'Idiomas',
                handler:function(){
					if (codigoPersona){
						new FrmListadoCgg_gem_idioma_persona(inDesktop,codigoPersona,"","busqueda_perfil").show();	
					}                     
                }
            },{text:'Experiencia Laboral',
                handler:function(){
					if (codigoPersona){
						new FrmListadoCgg_gem_experiencia_laboral(inDesktop,codigoPersona,"","busqueda_perfil").show();	
					} 					
                }
            },{text:'Destrezas',
                handler:function(){
					if (codigoPersona){
						new FrmListadoCgg_gem_destreza_persona(inDesktop,codigoPersona,"","busqueda_perfil").show();	
					}					
                }
            }
        ],
		listeners:{
            click:function(){        
					var r=grdCgg_res_persona.getSelectionModel().getSelected();
                    var inCrper_codigo = r.get('CRPER_CODIGO');
					var objFrmCgg_gem_administracion_hoja_vida = new FrmCgg_gem_administracion_hoja_vida(inDesktop,codigoPersona,"busqueda_perfil");
					objFrmCgg_gem_administracion_hoja_vida.closeHandler(function(){
						gsCgg_res_persona.reload();
					});
					objFrmCgg_gem_administracion_hoja_vida.show();
            }
		}
    });
	/**
     * Ext.form.TextArea NIVELES DE ESTUDIO SELCCIONADOS
     */	
	 
    var txtCgbper_nivel = new Ext.form.TextArea({
        id: 'txtCgbper_nivel',
        name: 'txtCgbper_nivel',
        fieldLabel: 'Nivel de estudio',        
		anchor: '100%',
		height:37,	
		readOnly:true
      });
	var arrRecNIvel =[];
	var btnCgbper_nivel = new Ext.Button({
        id: 'btnCgbper_nivel',
        text: '',		
        iconCls: 'iconNuevo',
        listeners: {
            click: function () {
				var tmpDireccion = "";
				var sm = new Ext.grid.CheckboxSelectionModel({
					listeners: {						
					}
				});			
				new Ext.Window({
					id:'winTmpBusquedaNivel',
					iconCls:"iconBuscar",
					title:"Seleccione un nivel de estudio",
					items:[new Ext.grid.GridPanel({
						cm:new Ext.grid.ColumnModel([
							sm,						
							{dataIndex:'CGNES_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
							{dataIndex:'CGNES_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
							{dataIndex:'CGNES_GRADO',header:'Grado',width:150,sortable:true,hidden:true}
						]),
						store:new Ext.data.Store({
							proxy:new Ext.ux.bsx.SoapProxy({
								url:URL_WS+"Cgg_nivel_estudio",
								method:"selectAll"
							}),
							autoLoad:true,							
							reader:new Ext.data.JsonReader({},[
								{name:'CGNES_CODIGO'},
								{name:'CGNES_DESCRIPCION'}//,
								//{name:'CGNES_GRADO'}
							]),
							baseParams:{
								format:"JSON"
							},listeners:{
								"load":function(store,recs){									
									var arrTmp = new Array();
									var tmpArrValue=txtCgbper_nivel.getValue().split(", ");
									for (var i=0;i<tmpArrValue.length;i++)
										for(var f =0;f<recs.length;f++)										
											if (recs[f].get("CGNES_DESCRIPCION") == tmpArrValue[i])
												arrTmp.push(f);
									sm.selectRows(arrTmp);
								}
							}
						}),
						region:'center',
						sm:sm,						
						loadMask:{msg:"Cargando..."}						
					})],										
					constrainHeader:true,				
					width: 250,					
					height: 300,
					minWidth: 250,
					minHeight: 300,
					maximizable: false,
					minimizable: false,
					
					modal:true,
					layout:'border',        
					bbar:[{text:'Aceptar',iconCls:'iconAceptar',handler:function(){
						var tmpNivel="";
						arrRecNIvel = sm.getSelections();
						for (i=0;i<arrRecNIvel.length;i++)
							tmpNivel+=(i>0?', ':'')+arrRecNIvel[i].get("CGNES_DESCRIPCION");
						txtCgbper_nivel.setValue(tmpNivel);
						Ext.getCmp('winTmpBusquedaNivel').close();
						if (Ext.getCmp('winTmpBusquedaNivel')) Ext.getCmp('winTmpBusquedaNivel') = null;
					}}]					
				}).show();					
            }
        }
    });
	
	/**
	*	ESPECIALIDAD
	*/
	var txtCgbper_especialidad = new Ext.form.TextArea({
        id: 'txtCgbper_especialidad',
        name: 'txtCgbper_especialidad',
        fieldLabel: 'Especialidad',        
		anchor: '100%',
		height:37,	
		readOnly:true
    });
	var arrRecEspecialidad =[];
	var btnCgbper_especialidad = new Ext.Button({
        id: 'btnCgbper_especialidad',
        text: '',		
        iconCls: 'iconNuevo',
        listeners: {
            click: function () {				
				
				var smEspecialidad = new Ext.grid.CheckboxSelectionModel({
					listeners: {						
					}
				});	
				if(arrRecNIvel.length>0){
					//alert(createJSONObject(arrRecNIvel));
					var cadena = ''
					for(i=0;i<arrRecNIvel.length;i++){
						cadena +=  arrRecNIvel[i].get("CGNES_CODIGO");
						cadena += (i<arrRecNIvel.length-1)?';':'';
					}
					
					gsCgg_especialidadByNivel = new Ext.data.Store({
							proxy:new Ext.ux.bsx.SoapProxy({
									url:URL_WS+"Cgg_especialidad",
									method:"selectPageEspecialidadBYNIVELES",
									pagin:true
							}),
							remoteSort:true,
							reader:new Ext.data.JsonReader({
									id:'CGESP_CODIGO',
									root:'dataSet',
									totalProperty: 'totalCount'
							},[
								{name:'CGESP_CODIGO'},
								{name:'CGNES_CODIGO'},
								{name:'CGESP_NOMBRE'},
								{name:'CGESP_DESCRIPCION'},
								{name:'CGNES_DESCRIPCION'}
							]),			
							sortInfo:{field: 'CGESP_CODIGO', direction: 'ASC'},
							baseParams:{keyword:"",format:'JSON',inCgnes_codigo:cadena}
					});
					
					//gsCgg_especialidadByNivel.baseParams.inCgnes_codigo = cadena;
					
					gsCgg_especialidadByNivel.reload({
						params:{
							start:0,
							limit:RECORD_PAGE
						}
					});
				}else{					
					var gsCgg_especialidad = new Ext.data.Store({
						proxy:new Ext.ux.bsx.SoapProxy({
							url:URL_WS+"Cgg_especialidad",
							method:"selectPage",
							pagin:true
						}),
						//autoLoad:true,		
						remoteSort:true,							
						reader:new Ext.data.JsonReader({
							id:'CGESP_CODIGO',
							root:'dataSet',
							totalProperty: 'totalCount'},
						[
							{name:'CGESP_CODIGO'},
							{name:'CGNES_CODIGO'},
							{name:'CGESP_NOMBRE'},
							{name:'CGESP_DESCRIPCION'},
							{name:'CGNES_DESCRIPCION'}
						]),						
						sortInfo:{field: 'CGNES_CODIGO', direction: 'ASC'},
						baseParams:{keyword:"",format:'JSON',start:0,limit:RECORD_PAGE}
					});
					gsCgg_especialidad.reload({params:{
							start:0,
							limit:RECORD_PAGE,
							format:'JSON'
						}
					});
				}
				var tmpDireccion = "";
						
				new Ext.Window({
					id:'winTmpBusquedaEspecialidad',
					iconCls:"iconBuscar",
					title:"Seleccione una especialidad",
					items:[new Ext.grid.GridPanel({
						cm:new Ext.grid.ColumnModel([
							smEspecialidad,						
							{dataIndex:'CGNES_DESCRIPCION',header:'Nivel de Educaci\u00F3n',width:130,sortable:true,hidden:true},
							{dataIndex:'CGESP_NOMBRE',header:'Nombre',width:200,sortable:true},
							{dataIndex:'CGESP_DESCRIPCION',header:'Descripcion',width:250,sortable:true}
						]),	
						bbar:new Ext.PagingToolbar({
								store: (arrRecNIvel.length>0)?gsCgg_especialidadByNivel:gsCgg_especialidad,						
								displayInfo: true,
								pageSize:RECORD_PAGE,
								displayMsg: 'Mostrando {0} - {1} de {2}',
								temptyMsg: 'No hay informaci\u00f3n para mostrar'
						}),						
						store: (arrRecNIvel.length>0)?gsCgg_especialidadByNivel:gsCgg_especialidad,
						region:'center',
						sm:smEspecialidad,						
						loadMask:{msg:"Cargando..."}						
					})],										
					constrainHeader:true,
					width: 450,					
					height: 300,
					minWidth: 450,
					minHeight: 300,
					maximizable: false,
					minimizable: false,
					modal:true,
					layout:'border',        
					bbar:[{text:'Aceptar',iconCls:'iconAceptar',handler:function(){
						var tmpEspecialidad="";
						arrRecEspecialidad = smEspecialidad.getSelections();
						for (i=0;i<arrRecEspecialidad.length;i++)
							tmpEspecialidad+=(i>0?', ':'')+arrRecEspecialidad[i].get("CGESP_NOMBRE");
						txtCgbper_especialidad.setValue(tmpEspecialidad);
						Ext.getCmp('winTmpBusquedaEspecialidad').close();
						if (Ext.getCmp('winTmpBusquedaEspecialidad')) Ext.getCmp('winTmpBusquedaEspecialidad') = null;
					}}]					
				}).show();					
            }
        }
    });
	/**
	*	TITULO PROFESIONAL
	*/	
	var txtCgbper_titulo_profesional = new Ext.form.TextArea({
        id: 'txtCgbper_titulo_profesional',
        name: 'txtCgbper_titulo_profesional',
        fieldLabel: 'T\u00EDtulo profesional',        
		anchor: '100%',
		height:37,	
		readOnly:true        
    });
	var arrRecTituloProfesional =[];
	var btnCgbper_titulo_profesional = new Ext.Button({
        id: 'btnCgbper_titulo_profesional',
        text: '',		
        iconCls: 'iconNuevo',
        listeners: {
            click: function () {				
				var sm = new Ext.grid.CheckboxSelectionModel({});					
				if(arrRecNIvel.length>0){					
					var cadena = ''
					for(i=0;i<arrRecNIvel.length;i++){
						cadena +=  arrRecNIvel[i].get("CGNES_CODIGO");
						cadena += (i<arrRecNIvel.length-1)?';':'';
					}					
					var gsCgg_titulo_profesionalByNiveles = new Ext.data.Store({
							proxy:new Ext.ux.bsx.SoapProxy({
									url:URL_WS+"Cgg_titulo_profesional",
									method:"selectPageTituloByNiveles",
									pagin:true
							}),
							remoteSort:true,
							reader:new Ext.data.JsonReader({
									id:'CGTPR_CODIGO',
									root:'dataSet',
									totalProperty: 'totalCount'
							},[
								{name:'CGTPR_CODIGO'},
								{name:'CGNES_CODIGO'},
								{name:'CGNES_DESCRIPCION'},
								{name:'CGTPR_DESCRIPCION'}
							]),
							sortInfo:{field: 'CGNES_CODIGO', direction: 'ASC'},
							baseParams:{keyword:"",format:'JSON',inCgnes_codigo:cadena}
					});	
					
					gsCgg_titulo_profesionalByNiveles.reload({
						params:{
							start:0,
							limit:RECORD_PAGE
						}
					});
				}else{					
					var gsCgg_Titulo_profesional = new Ext.data.Store({
							proxy:new Ext.ux.bsx.SoapProxy({
								url:URL_WS+"Cgg_titulo_profesional",
								method:"selectPage",
								pagin:true
							}),
							remoteSort:true,							
							reader:new Ext.data.JsonReader({
								id:'CGTPR_CODIGO',
								root:'dataSet',
								totalProperty: 'totalCount'
							},[
								{name:'CGTPR_CODIGO'},
								{name:'CGNES_CODIGO'},
								{name:'CGNES_DESCRIPCION'},
								{name:'CGTPR_DESCRIPCION'}
							]),
							sortInfo:{field: 'CGTPR_CODIGO', direction: 'ASC'},
							baseParams:{
								keyword:"",format:"JSON",start:0,limit:RECORD_PAGE
							},listeners:{
								"load":function(store,recs){									
									var arrTmp = new Array();
									var tmpArrValue=txtCgbper_titulo_profesional.getValue().split(", ");
									for (var i=0;i<tmpArrValue.length;i++)
										for(var f =0;f<recs.length;f++)										
											if (recs[f].get("CGTPR_DESCRIPCION") == tmpArrValue[i])
												arrTmp.push(f);
									sm.selectRows(arrTmp);
								}
							}
						});
					gsCgg_Titulo_profesional.reload({params:{
							start:0,
							limit:RECORD_PAGE,
							format:'JSON'
						}
					});
				}
				new Ext.Window({
					id:'winTmpBusquedaTituloProfesional',
					iconCls:"iconBuscar",
					title:"Seleccione un Titulo Profesional",
					items:[new Ext.grid.GridPanel({
						cm:new Ext.grid.ColumnModel([
							sm,						
							{dataIndex:'CGNES_DESCRIPCION',header:'Nivel de Estudio',width:120,sortable:true,hidden:true},
							{dataIndex:'CGTPR_DESCRIPCION',header:'Descripci\u00F3n',width:380,sortable:true}
						]),
						tbar: ['Buscar: ', ' ',new Ext.ux.bsx.SearchField({
								id:'sfBusqueda',
							store:(arrRecNIvel.length>0)?gsCgg_titulo_profesionalByNiveles:gsCgg_Titulo_profesional,
							width:200
						})],
						bbar:new Ext.PagingToolbar({
								store: (arrRecNIvel.length>0)?gsCgg_titulo_profesionalByNiveles:gsCgg_Titulo_profesional,
								displayInfo: true,
								pageSize:RECORD_PAGE,
								displayMsg: 'Mostrando {0} - {1} de {2}',
								temptyMsg: 'No hay informaci\u00f3n para mostrar'
						}),	
						store:(arrRecNIvel.length>0)?gsCgg_titulo_profesionalByNiveles:gsCgg_Titulo_profesional,
						region:'center',
						sm:sm,						
						loadMask:{msg:"Cargando..."}						
					})],	
					constrainHeader:true,
					width: 450,					
					height: 300,
					minWidth: 450,
					minHeight: 300,
					maximizable: false,
					minimizable: false,
					modal:true,
					layout:'border',        
					bbar:[{text:'Aceptar',iconCls:'iconAceptar',handler:function(){
						var tmpTituloProfesional="";
						arrRecTituloProfesional = sm.getSelections();
						for (i=0;i<arrRecTituloProfesional.length;i++)
							tmpTituloProfesional+=(i>0?', ':'')+arrRecTituloProfesional[i].get("CGTPR_DESCRIPCION");
						txtCgbper_titulo_profesional.setValue(tmpTituloProfesional);
						Ext.getCmp('winTmpBusquedaTituloProfesional').close();
						if (Ext.getCmp('winTmpBusquedaTituloProfesional')) Ext.getCmp('winTmpBusquedaTituloProfesional') = null;
					}}]					
				}).show();					
            }
        }
    });
	/**
	*	DESTREZAS
	*/	
	var txtCgbper_destrezas = new Ext.form.TextArea({
        id: 'txtCgbper_destrezas',
        name: 'txtCgbper_destrezas',
        fieldLabel: 'Destrezas',        
		anchor: '100%',
		height:37,	
		readOnly:true        
    });
	var arrRecDestrezas =[];
	var btnCgbper_destrezas = new Ext.Button({
        id: 'btnCgbper_destrezas',
        text: '',		
        iconCls: 'iconNuevo',
        listeners: {
            click: function () {
				var tmpDireccion = "";
				var sm = new Ext.grid.CheckboxSelectionModel({
					listeners: {						
					}
				});			
				new Ext.Window({
					id:'winTmpBusquedaDestrezas',
					iconCls:"iconBuscar",
					title:"Seleccione las Destreza",
					items:[new Ext.grid.GridPanel({
						cm:new Ext.grid.ColumnModel([
							sm,						
							{dataIndex: 'CGDST_CODIGO',header: 'Codigo',width: 150,sortable: true,hidden:true},
							{dataIndex: 'CGDST_DESCRIPCION',header: 'Descripcion',width: 350,sortable: true}
						]),
						store:new Ext.data.Store({
							proxy:new Ext.ux.bsx.SoapProxy({
								url:URL_WS+"Cgg_gem_destreza",
								method:"selectAll"
							}),
							autoLoad:true,							
							reader:new Ext.data.JsonReader({},[
								{name: 'CGDST_CODIGO'},
								{name: 'CGDST_DESCRIPCION'}
							]),
							baseParams:{
								format:"JSON"
							},listeners:{
								"load":function(store,recs){									
									var arrTmp = new Array();
									var tmpArrValue=txtCgbper_destrezas.getValue().split(", ");
									for (var i=0;i<tmpArrValue.length;i++)
										for(var f =0;f<recs.length;f++)										
											if (recs[f].get("CGDST_DESCRIPCION") == tmpArrValue[i])
												arrTmp.push(f);
									sm.selectRows(arrTmp);
								}
							}
						}),
						region:'center',
						sm:sm,						
						loadMask:{msg:"Cargando..."}						
					})],					
					constrainHeader:true,
					width: 450,					
					height: 300,
					minWidth: 450,
					minHeight: 300,
					maximizable: false,
					minimizable: false,
					modal:true,
					layout:'border',        
					bbar:[{text:'Aceptar',iconCls:'iconAceptar',handler:function(){
						var tmpDestrezas="";
						arrRecDestrezas = sm.getSelections();
						for (i=0;i<arrRecDestrezas.length;i++)
							tmpDestrezas+=(i>0?', ':'')+arrRecDestrezas[i].get("CGDST_DESCRIPCION");
						txtCgbper_destrezas.setValue(tmpDestrezas);
						Ext.getCmp('winTmpBusquedaDestrezas').close();
						if (Ext.getCmp('winTmpBusquedaDestrezas')) Ext.getCmp('winTmpBusquedaDestrezas') = null;
					}}]					
				}).show();					
            }
        }
    });
	/**
	*	IDIOMAS
	*/	
	var txtCgbper_idiomas = new Ext.form.TextArea({
        id: 'txtCgbper_idiomas',
        name: 'txtCgbper_idiomas',
        fieldLabel: 'Idiomas',        
		anchor: '100%',
		height:37,	
		readOnly:true        
    });
	var arrRecIdiomas =[];
	var btnCgbper_idiomas = new Ext.Button({
        id: 'btnCgbper_idiomas',
        text: '',		
        iconCls: 'iconNuevo',
        listeners: {
            click: function () {
				var tmpDireccion = "";
				var sm = new Ext.grid.CheckboxSelectionModel({
					listeners: {						
					}
				});			
				new Ext.Window({
					id:'winTmpBusquedaIdiomas',
					iconCls:"iconBuscar",
					title:"Seleccione los idiomas",
					items:[new Ext.grid.GridPanel({
						cm:new Ext.grid.ColumnModel([
							sm,						
							{dataIndex:'CGIDM_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
							{dataIndex:'CGIDM_NOMBRE',header:'Nombre',width:150,sortable:true}
						]),
						store:new Ext.data.Store({
							proxy:new Ext.ux.bsx.SoapProxy({
								url:URL_WS+"Cgg_gem_idioma",
								method:"selectAll"
							}),
							autoLoad:true,							
							reader:new Ext.data.JsonReader({},[
								{name:'CGIDM_CODIGO'},
								{name:'CGIDM_NOMBRE'}
							]),
							baseParams:{
								format:"JSON"
							},listeners:{
								"load":function(store,recs){									
									var arrTmp = new Array();
									var tmpArrValue=txtCgbper_idiomas.getValue().split(", ");
									for (var i=0;i<tmpArrValue.length;i++)
										for(var f =0;f<recs.length;f++)										
											if (recs[f].get("CGIDM_NOMBRE") == tmpArrValue[i])
												arrTmp.push(f);
									sm.selectRows(arrTmp);
								}
							}
						}),
						region:'center',
						sm:sm,						
						loadMask:{msg:"Cargando..."}						
					})],					
					constrainHeader:true,
					width: 250,					
					height: 300,
					minWidth: 250,
					minHeight: 300,
					maximizable: false,
					minimizable: false,
					modal:true,
					layout:'border',        
					bbar:[{text:'Aceptar',iconCls:'iconAceptar',handler:function(){
						var tmpIdiomas="";
						arrRecIdiomas = sm.getSelections();
						for (i=0;i<arrRecIdiomas.length;i++)
							tmpIdiomas+=(i>0?', ':'')+arrRecIdiomas[i].get("CGIDM_NOMBRE");
						txtCgbper_idiomas.setValue(tmpIdiomas);
						Ext.getCmp('winTmpBusquedaIdiomas').close();
						if (Ext.getCmp('winTmpBusquedaIdiomas')) Ext.getCmp('winTmpBusquedaIdiomas') = null;
					}}]					
				}).show();					
            }
        }
    });
	/**
	*	ISLAS
	*/	
	var txtCgbper_islas = new Ext.form.TextArea({
        id: 'txtCgbper_islas',
        name: 'txtCgbper_islas',
        fieldLabel: 'Islas',        
		anchor: '100%',
		height:37,		
		readOnly:true
    });
	var arrRecIslas =[];
	var btnCgbper_islas = new Ext.Button({
        id: 'btnCgbper_islas',
        text: '',		
        iconCls: 'iconNuevo',
        listeners: {
            click: function () {
				var tmpDireccion = "";
				var sm = new Ext.grid.CheckboxSelectionModel({
					listeners: {						
					}
				});			
				new Ext.Window({
					id:'winTmpBusquedaIslas',
					iconCls:"iconBuscar",
					title:"Seleccione una isla",
					items:[new Ext.grid.GridPanel({
						cm:new Ext.grid.ColumnModel([
							sm,						
							{dataIndex:'CISLA_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
							{dataIndex:'CISLA_NOMBRE',header:'Nombre',width:200,sortable:true}
						]),
						store:new Ext.data.Store({
							proxy:new Ext.ux.bsx.SoapProxy({
								url:URL_WS+"Cgg_isla",
								method:"selectAll"
							}),
							autoLoad:true,							
							reader:new Ext.data.JsonReader({},[
								{name:'CISLA_CODIGO'},
								{name:'CISLA_NOMBRE'}
							]),
							baseParams:{
								format:"JSON"
							},listeners:{
								"load":function(store,recs){									
									var arrTmp = new Array();
									var tmpArrValue=txtCgbper_islas.getValue().split(", ");
									for (var i=0;i<tmpArrValue.length;i++)
										for(var f =0;f<recs.length;f++)										
											if (recs[f].get("CISLA_NOMBRE") == tmpArrValue[i])
												arrTmp.push(f);
									sm.selectRows(arrTmp);
								}
							}
						}),
						region:'center',
						sm:sm,						
						loadMask:{msg:"Cargando..."}						
					})],					
					maximizable:false,
					constrainHeader:true,
					width:250,
					height:300,
					modal:true,
					layout:'border',        
					bbar:[{text:'Aceptar',iconCls:'iconAceptar',handler:function(){
						var tmpIslas="";
						arrRecIslas = sm.getSelections();
						for (i=0;i<arrRecIslas.length;i++)
							tmpIslas+=(i>0?', ':'')+arrRecIslas[i].get("CISLA_NOMBRE");
						txtCgbper_islas.setValue(tmpIslas);
						Ext.getCmp('winTmpBusquedaIslas').close();
						if (Ext.getCmp('winTmpBusquedaIslas')) Ext.getCmp('winTmpBusquedaIslas') = null;
					}}]					
				}).show();					
            }
        }
    });
	
	
	var cadenaNiveles = '';
	var cadenaEspecialidades = '';
	var cadenaTitulos = '';
	var cadenaDestrezas = '';
	var cadenaIdiomas = '';
	var cadenaIslas = '';
	/**
	 * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona de acurdo a parametros seleccionados.
	 */	
	 //function cargarStorePersona(){
		var gsCgg_res_persona = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_gem_perfil_prof",
					method:"selectPageDinamicoPersonas",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CRPER_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CUSU_CODIGO'},
				{name:'CRPER_CODIGO'},
				{name:'CRPER_NOMBRES'},
				{name:'CRPER_APELLIDO_PATERNO'},
				{name:'CRPER_APELLIDO_MATERNO'},
				{name:'CRPER_GENERO'},
				{name:'CRPER_NUM_DOC_IDENTIFIC'},
				{name:'CRPER_NUMERO_RESIDENCIA'},			
				{name:'CGNES_DESCRIPCION'},
				{name:'CGESP_NOMBRE'},
				{name:'CGTPR_DESCRIPCION'},
				{name:'CGDST_DESCRIPCION'},
				{name:'CGIDM_NOMBRE'},
				{name:'CISLA_NOMBRE'},	
				{name:'CGINF_CALIFICACION'}	
			]),
			sortInfo:{field: 'CRPER_NOMBRES', direction: 'ASC'},
			baseParams:{
				keyword:"",
				format:'JSON',
				inCodigoNiveles:cadenaNiveles,
				inCodigoEspecialidades:cadenaEspecialidades,
				inCodigoTitulos:cadenaTitulos,
				inCodigoDestrezas:cadenaDestrezas,
				inCodigoIdiomas : cadenaIdiomas,
				inCodigoIslas : cadenaIslas,
				start:0,
				limit:RECORD_PAGE
			}							
		});		
	/**
	* ACEPTAR LA BUSQUEDA
	*/
	var btnBuscarPerfil = new Ext.Button({
			id:'btnBuscarPerfil',
			text:'Buscar',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){		
						//Envio de codigos niveles de estudio
						cadenaNiveles = '';
						for(i=0;i<arrRecNIvel.length;i++){
							cadenaNiveles +=  arrRecNIvel[i].get("CGNES_CODIGO");
							cadenaNiveles += (i<arrRecNIvel.length-1)?';':'';
						}					
						cadenaEspecialidades = '';
						for(i=0;i<arrRecEspecialidad.length;i++){
							cadenaEspecialidades +=  arrRecEspecialidad[i].get("CGESP_CODIGO");
							cadenaEspecialidades += (i<arrRecEspecialidad.length-1)?';':'';
						}
						cadenaTitulos = '';
						for(i=0;i<arrRecTituloProfesional.length;i++){
							cadenaTitulos +=  arrRecTituloProfesional[i].get("CGTPR_CODIGO");
							cadenaTitulos += (i<arrRecTituloProfesional.length-1)?';':'';
						}						
						cadenaDestrezas = '';
						for(i=0;i<arrRecDestrezas.length;i++){
							cadenaDestrezas +=  arrRecDestrezas[i].get("CGDST_CODIGO");
							cadenaDestrezas += (i<arrRecDestrezas.length-1)?';':'';
						}						
						cadenaIdiomas = '';
						for(i=0;i<arrRecIdiomas.length;i++){
							cadenaIdiomas +=  arrRecIdiomas[i].get("CGIDM_CODIGO");
							cadenaIdiomas += (i<arrRecIdiomas.length-1)?';':'';
						}						
						cadenaIslas = '';
						for(i=0;i<arrRecIslas.length;i++){
							cadenaIslas +=  arrRecIslas[i].get("CISLA_CODIGO");
							cadenaIslas += (i<arrRecIslas.length-1)?';':'';
						}
						
						gsCgg_res_persona.baseParams.inCodigoNiveles = cadenaNiveles;						
						gsCgg_res_persona.baseParams.inCodigoEspecialidades = cadenaEspecialidades;						
						gsCgg_res_persona.baseParams.inCodigoTitulos = cadenaTitulos;						
						gsCgg_res_persona.baseParams.inCodigoDestrezas = cadenaDestrezas;						
						gsCgg_res_persona.baseParams.inCodigoIdiomas = cadenaIdiomas;						
						gsCgg_res_persona.baseParams.inCodigoIslas = cadenaIslas;					
						gsCgg_res_persona.reload({
							params:{
								start:0,
								limit:RECORD_PAGE,
								format:'JSON'						
							}
						});

				}
			}
	});
	
	
	
	 /**
    * new Ext.Panel Panel que contiene las opciones de busqueda
    */
	var framePerfilProfesional = {
		columnWidth: .50,
		labelWidth:65,
		layout: 'form',
		items: [{
			xtype:'panel',
			anchor:'97%',
			layout: 'form',			
			items :[{
				xtype: 'panel',
				layout: 'column',
				items: [{
					columnWidth: .9,
					layout: 'form',
					items: [txtCgbper_nivel]
				},{
					columnWidth: .1,
					layout: 'form',
					items: [btnCgbper_nivel]
				}]
			},{
				xtype: 'panel',
				layout: 'column',
				items: [{
					columnWidth: .9,
					layout: 'form',
					items: [txtCgbper_especialidad]
				},
				{
					columnWidth: .1,
					layout: 'form',
					items: [btnCgbper_especialidad]
				}]
			},{
				xtype: 'panel',
				layout: 'column',
				items: [{
					columnWidth: .9,
					layout: 'form',
					items: [txtCgbper_titulo_profesional]
				},
				{
					columnWidth: .1,
					layout: 'form',
					items: [btnCgbper_titulo_profesional]
				}]
			}
			]
		}]
	}
	var pnlOpcionesBusquedaPerfil = new Ext.form.FormPanel({
		id:"pnlOpcionesBusquedaPerfil",
        autoHeight:true,   		
        region:'north' ,
		labelWidth :100,
		frame:true,		
		items:[
		{
			xtype:'fieldset',
            title: 'Busqueda avanzada',
            collapsible: true,   
			autoHeight:true,
			layout : 'form',
			region : 'north',
			listeners:{
				collapse:function(inPanel) {					
					winFrmListadoCgg_gem_busqueda_perfil.doLayout(true);
				},
				expand:function(inPanel) {
					winFrmListadoCgg_gem_busqueda_perfil.doLayout(true);
				}
			},
            items :[		
		
			{
			xtype: 'panel',
			layout: 'column',			
			items: [framePerfilProfesional,
				{
					columnWidth: .50,
					labelWidth:65,
					layout: 'form',					
					items: [{
						xtype: 'panel',				
						layout: 'form',						
						items :[{
								xtype: 'panel',
								layout: 'column',
								items: [{
									columnWidth: .9,
									layout: 'form',
									items: [txtCgbper_destrezas]
								},
								{
									columnWidth: .1,
									layout: 'form',
									items: [btnCgbper_destrezas]
								}]
							},{
								xtype: 'panel',
								layout: 'column',
								items: [{
									columnWidth: .9,
									layout: 'form',
									items: [txtCgbper_idiomas]
								},
								{
									columnWidth: .1,
									items:[btnCgbper_idiomas]
								}]
							},{
								xtype: 'panel',
								layout: 'column',
								items: [{
									columnWidth: .9,
									layout: 'form',
									items: [txtCgbper_islas]
								},{
									columnWidth: .1,
									items: [btnCgbper_islas]
								}]
						}]
					}]
				}				
			]}	
]			
		}]
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_titulo_profesional.
	*/
	var pgBarCgg_res_persona= new Ext.PagingToolbar({
			store: gsCgg_res_persona,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_titulo_profesional.
	*/
	function rndGenero(v){
		switch(v){
			case 0:v="Masculino";break;
			case 1:v="Femenino";break;
			default :v="No especificado";break;
        }
		return v;
	}
	var cmCgg_res_persona = new Ext.grid.ColumnModel([		
			{dataIndex:'CRPER_NUMERO_RESIDENCIA',header:'No. de residencia',width:80,sortable:true},
			{dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'Doc identidad.',width:85,sortable:true},
			{dataIndex:'CRPER_NOMBRES',header:'Nombre',width:200,sortable:true,renderer:function(v,x,r){
				return v + " "+ r.data.CRPER_APELLIDO_PATERNO +" "+r.data.CRPER_APELLIDO_MATERNO ;
			}},			
			{dataIndex:'CRPER_GENERO',header:'G\u00E9nero',width:75,sortable:true, renderer:rndGenero},			
			{dataIndex:'CGNES_DESCRIPCION',header:'Nivel de estudio',width:90,sortable:true},
			{dataIndex:'CGESP_NOMBRE',header:'Especialidad',width:90,sortable:true},
			{dataIndex:'CGTPR_DESCRIPCION',header:'T\u00EDtulo profesional',width:120,sortable:true},
			{dataIndex:'CGDST_DESCRIPCION',header:'Destreza',width:100,sortable:true},
			{dataIndex:'CGIDM_NOMBRE',header:'Idioma',width:60,sortable:true},
			{dataIndex:'CISLA_NOMBRE',header:'Isla',width:90,sortable:true},		
			{dataIndex:'CGINF_CALIFICACION',header:'Calificaci\u00F3n.',width:90,sortable:true,renderer:
				function(v){
					var tmpCalif = "";
					for (i=1;i<=5;i++){
						tmpCalif += (i<=v)?
							"<img src='resources/images/staron.jpg' title='"+i+"'/>":
							"<img src='resources/images/staroff.jpg' title='"+i+"'/>";
					}
					return tmpCalif;
				}
			}		
	]);
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_titulo_profesional en un formato tabular de filas y columnas.
	*/
	var grdCgg_res_persona = new Ext.grid.GridPanel({
			cm:cmCgg_res_persona,
			store:gsCgg_res_persona,
			region:'center',			
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},						
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_res_persona,
						width:200
				}),
				btnBuscarPerfil
			],
			bbar:pgBarCgg_res_persona,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if (btnSeleccionarCNDHV.isVisible()){
						btnSeleccionarCNDHV.fireEvent('click');
					}
				}
			}
	});	
	gsCgg_res_persona.reload({
        params: {
            start: 0,
            limit: RECORD_PAGE,
            format: 'JSON'
        }
    });
	 grdCgg_res_persona.getSelectionModel().on("selectionchange",function(valor){
		var estado=valor.hasSelection();
		btnHojaVida.setDisabled(!estado);
		btnSeleccionarCNDHV.setDisabled(!estado);
		btnHojaDeVidaCgg_res_persona.setDisabled(!estado);
	});
	grdCgg_res_persona.getSelectionModel().on('rowselect', function(sm, rowIdx, r) {	
			codigoPersona = r.get("CRPER_CODIGO");
	});
	var pnlListadoCgg_gem_busqueda_perfil = new Ext.form.FormPanel({
		id:"pnlListadoCgg_gem_busqueda_perfil",
		items:[grdCgg_res_persona],
		region:'center',
		layout: 'border'		
	});
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gem_busqueda_perfil.
     */
	 if(inDesktop!==null && inDesktop!==undefined){
		var winFrmListadoCgg_gem_busqueda_perfil = inDesktop.createWindow({
			id: 'winFrmListadoCgg_gem_busqueda_perfil',
			title: tituloListadoCgg_gem_busqueda_perfil,
			width: 700,
			minWidth: 700,
			height: 500,
			minHeight: 500,
			maximizable: true,
			minimizable: true,
			constrainHeader: true,
			layout: 'border',
			modal:true,
			forceLayout : true,
			tbar: getPanelTitulo('Listado ' + tituloListadoCgg_gem_busqueda_perfil, descListadoCgg_gem_busqueda_perfil),
			items: [pnlOpcionesBusquedaPerfil,pnlListadoCgg_gem_busqueda_perfil],
			bbar: [btnHojaDeVidaCgg_res_persona,'->', btnSalirCgg_gem_busqueda_perfil]			
		});
	}else{
		var winFrmListadoCgg_gem_busqueda_perfil = new Ext.Window({
			id: 'winFrmListadoCgg_gem_busqueda_perfil',
			title: tituloListadoCgg_gem_busqueda_perfil,
			width: 700,
			minWidth: 700,
			height: 500,
			minHeight: 500,
			modal:true,
			maximizable: true,
			minimizable: true,
			constrainHeader: true,
			layout: 'border',
			tbar: getPanelTitulo('Listado ' + tituloListadoCgg_gem_busqueda_perfil, descListadoCgg_gem_busqueda_perfil),
			items: [pnlOpcionesBusquedaPerfil,pnlListadoCgg_gem_busqueda_perfil],
			bbar: [btnSeleccionarCNDHV,btnHojaDeVidaCgg_res_persona,'->', btnSalirCgg_gem_busqueda_perfil]
			
		});
	}

    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_gem_busqueda_perfil.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_busqueda_perfil.
     * @returns ventana winFrmCgg_gem_busqueda_perfil.
     * @base FrmListadoCgg_gem_busqueda_perfil.prototype.show
     */
    this.getWindow = function () {
        return winFrmListadoCgg_gem_busqueda_perfil;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gem_busqueda_perfil.
     * @base FrmListadoCgg_gem_busqueda_perfil.prototype.loadData
     */
    this.loadData = function () {
        gsCgg_gem_busqueda_perfil.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function () {
        return cmCgg_gem_busqueda_perfil;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function () {
        return gsCgg_gem_busqueda_perfil;
    }
	this.getSelectedRow = function(){
        return recTmp;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_gem_busqueda_perfil.prototype.getColumnModel = function () {
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_gem_busqueda_perfil.prototype.getStore = function () {
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_busqueda_perfil desde una instancia.
 */
FrmListadoCgg_gem_busqueda_perfil.prototype.show = function () {
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_busqueda_perfil desde una instancia.
 */
FrmListadoCgg_gem_busqueda_perfil.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_busqueda_perfil,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_gem_busqueda_perfil.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gem_busqueda_perfil desde una instancia.
 */
FrmListadoCgg_gem_busqueda_perfil.prototype.loadData = function () {
    this.loadData();
}