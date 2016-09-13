MyDesktop = new Ext.app.App({
    init :function(){
        Ext.QuickTips.init();
    },

    getModules : function(){		
        return [
        new MyDesktop.smimControlResidencia(),
        new MyDesktop.resFaseProceso(),
        new MyDesktop.StartMenuKardexTct(),
        new MyDesktop.resPersona(),
        new MyDesktop.StartMenuVehiculos(),
        new MyDesktop.StartMenuTct(),
        new MyDesktop.StartMenuMovilidad(),
        new MyDesktop.StartMenuMovilidadInterna(),
        new MyDesktop.StartMenuComite(),
        new MyDesktop.StartMenuSeguridad(),
        new MyDesktop.StartMenuItemConfiguracion(),
        new MyDesktop.StartMenuGestionEmpleo(),
        new MyDesktop.StartMenuDesarrolloHumano(),
        new MyDesktop.StartMenuJuridico(),
        new MyDesktop.StartMenuGerencial(),
        new MyDesktop.StartOffline(),
        new MyDesktop.mReporte()
        ];
    },
    getStartConfig : function(){		
        return {
            id:'lblBienvenido',
            title:'Bienvenido',
            iconCls:'iconPersona',
            toolItems: [{
                text:'Cambiar clave',
                iconCls:'iconClave',
                scope:this,
                handler:function(){
                    var tmpUserSession = new UserSession();
                    var tmpDlg = new DlgUsuarioAC(tmpUserSession);
                    tmpDlg.show();
                }
            },{
                text:'Preferencias',
                iconCls:'iconPrefs',
                scope:this,
                menu: {
                    items:[{
                        text: 'Formato de reportes',
                        scope: this,
                        menu:{

                            items:['<b class="menu-title">Escoja un formato de reporte</b>',
                            {
                                id:'miHtml',
                                text: 'Html(Pagina Web)',
                                iconCls:'',
                                checked:false,
                                group: 'formato',
                                handler: miFormatoHandler
                            },

                            {
                                id:'miPdf',
                                text: 'Adobe Pdf',
                                iconCls:'',
                                checked:true,
                                group: 'formato',
                                handler: miFormatoHandler
                            },

                            {
                                id:'miRtf',
                                text: 'Microsoft Word',
                                iconCls:'',
                                checked:false,
                                group: 'formato',
                                handler: miFormatoHandler
                            },

                            {
                                id:'miXls',
                                text: 'Microsoft Excel',
                                iconCls:'',
                                checked:false,
                                group: 'formato',
                                handler: miFormatoHandler
                            },

                            {
                                id:'miCsv',
                                text: 'Microsoft Excel(CSV)',
                                iconCls:'',
                                checked:false,
                                group: 'formato',
                                handler: miFormatoHandler
                            },

                            {
                                id:'miSwf',
                                text: 'Adobe Flash',
                                iconCls:'',
                                checked:false,
                                group: 'formato',
                                handler: miFormatoHandler
                            }
                            ]
                        }
                    }
                    ]
                }
            },{
                text:'Ayuda',
                iconCls:'iconAyuda',
                scope:this,
                menu: {
                    items:[{
                        text: 'Acerca de ..',
                        scope: this,
                        handler:function(){
                            var objAcerca = new FrmAcercade();
                            objAcerca.show();
                        }
                    }
                    ]
                }                
            },'-',{
                text:'Salir',
                iconCls:'iconSalir',
                scope:this,
                handler:function(){
                    Ext.MessageBox.confirm(APP_TITLE, 'Esta seguro que desea salir del sistema?', function(inBtn){
                        if (inBtn=="yes")
                            window.location=URL_LOGOUT;
                    });
                }
            }]
        }
    }
});

/**
 * Menu para creacion de submenus dentro del menu inicio de la aplicacion.
 */
MyDesktop.StartMenuItem = Ext.extend(Ext.app.Module, {
    init : function(){
        this.launcher = {
            text: 'Window hola',
            iconCls:'bogus'
        }
    },
    createWindow: function(src){
        var desktop = this.app.getDesktop();
        try{
            var win = desktop.getWindow('win'+src.windowId);
            if(!win){
                var param="(desktop";
                if (src.params)
                    for (var k=0;k<src.params.length;k++)
                        param+= ",\""+src.params[k]+"\"";
                param+=");"
                win = eval('new '+src.windowId+param);
                win.show();
            }else
                win.toFront();
        }catch(Exception){
            Ext.MessageBox.show({
                title:'Control de acceso',
                msg:'No tiene los permisos necesarios para hacer uso de este modulo.\nPor favor consulte con el Administrador del Sistema. '+Exception.message,
                icon:Ext.Msg.INFO,
                buttons:Ext.Msg.OK
            });
        }
    }
});

MyDesktop.resFaseProceso = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            text: 'Administraci\u00f3n procesos',
            iconCls: 'iconProceso',
            handler: function() {
                return false;
            },
            menu: {
                items:[{
                    text: 'Definici\u00f3n de proceso',
                    iconCls:'bogus',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmCgg_res_fase_general'
                },
                {
                    text: 'Listado de fases',
                    iconCls:'iconListado',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_fase'
                }
                ]
            }
        }
    }
});

MyDesktop.resPersona = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            text: 'Administraci\u00F3n persona',
            iconCls: 'iconPersona',
            handler: function() {
                return false;
            },
            menu: {
                items:[{
                    text: 'Especialidad',
                    iconCls:'iconListado',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_especialidad'
                },{
                    text: 'Instituci\u00f3n educativa',
                    iconCls:'iconListado',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_institucion_educativa'
                },{
                    text: 'Modalidad curso',
                    iconCls:'iconListado',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_modalidad_curso'
                },{
                    text: 'Nivel estudio',
                    iconCls:'iconListado',
                    handler : this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_nivel_estudio'
                },{
                    text: 'Perfil profesional',
                    iconCls:'bogus',
                    handler : this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_gem_perfil_prof'
                },{
                    text: 'Persona',
                    iconCls:'iconListado',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_persona'
                },{
                    text: 'Registrar observado',
                    iconCls:'bogus',
                    handler : this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_observado'
                },{
                    text: 'Titulo profesional',
                    iconCls:'iconListado',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_titulo_profesional'
                }
                ]
            }
        }
    }
});

MyDesktop.smimControlResidencia = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            text: 'Control de residencia',
            iconCls: 'iconResidencia',
            handler: function() {
                return false;
            },
            menu: {
                items:[{
                    text: 'Listado de tr\u00E1mites',
                    iconCls:'iconListado',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_tramite'
                },{
                    text: 'Listado de transe\u00fantes',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_transeunte'
                },{
                    text: 'Seguimiento de tr\u00E1mites',
                    iconCls: 'iconSeguimiento',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_seguimiento'
                },{
                    text: 'Historial de tr\u00e1mite',
                    iconCls:'iconHistorial',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmHistorialTramite'
                },{
                    text: 'Historial de persona',
                    iconCls:'iconHistorialPersona',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmCgg_res_persona_historial'
                },{
                    text: 'Informaci\u00f3n documental',
                    iconCls:'iconListado',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_adjunto'
                },{
                    text: 'Comunicaciones',
                    iconCls:'iconListado',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_comunicado'
                },{
                    text: 'Notificaciones',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_notificacion'
                },{
                    text: 'Denuncias',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    params: [TypeDenuncia.RESIDENCIA],
                    windowId:'FrmListadoCgg_res_denuncia'
                },{
                    text: 'Archivo',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_prestamo_expediente'
                },{
                    text: 'Carnetizaci\u00f3n',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_carnet'
                },{
                    text: 'Usuarios',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmAdministradorPersonaUsuario'
                },{
                    text: 'Dep\u00F3sito de garant\u00EDa',
                    iconCls:'bogus',
                    handler : this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_deposito_garantia'
                },'-',{
                    text: 'Operativos de seguimiento',
                    iconCls: 'iconOperativo',
                    handler: function() {
                        return false;
                    },
                    menu: {
                        items:[{
                            text: 'Matrimonio',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_res_matrimonio'
                        },{
                            text: 'Oficiales de Seguimiento',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_res_oficial_seguimiento'
                        }]
                    }
                }
                ]
            }
        }
    }
});


/**
 * Mene item. Menu de configuracion de valores del SIICGG
 */
MyDesktop.StartMenuItemConfiguracion = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            text: 'Configuraci\u00F3n',
            iconCls: 'iconConfiguracion',
            handler: function() {
                return false;
            },
            menu: {
                items:[{
                    text:"Administraci\u00F3n de residencia",
                    iconCls:'bogus',
                    menu:{
                        items:[{
                            text: 'Administraci\u00F3n requisitos tr\u00E1mites residencia',
                            iconCls:'bogus',
                            handler: this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_res_requisito'
                        },{
                            text: 'Administraci\u00F3n tipo notificaci\u00F3n',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_res_tipo_notificacion'
                        },{
                            text: 'Administraci\u00F3n garant\u00EDa',
                            iconCls:'bogus',
                            handler : this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_res_garantia'
                        },{
                            text: 'Administraci\u00F3n de tipo de solicitud tr\u00E1mite',
                            iconCls:'bogus',
                            handler : this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_res_tipo_solicitud_tramite'
                        },{
                            text: 'Administraci\u00F3n estado tr\u00E1mite',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_res_estado_tramite'
                        },{
                            text: 'Administraci\u00F3n tipos de tr\u00E1mites',
                            iconCls:'bogus',
                            handler: this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_res_tipo_tramite'
                        }
                        ]
                    }
                },{
                    text:"Distribuci\u00f3n geogr&aacute;fica",
                    iconCls:'bogus',
                    menu:{
                        items:[{
                            text: 'Administraci\u00f3n de pa\u00EDs',
                            iconCls:'bogus',
                            handler : this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_pais'
                        },{
                            text: 'Administraci\u00f3n de provincia',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_provincia'
                        },{
                            text: 'Administraci\u00f3n de cant\u00f3n',
                            iconCls:'bogus',
                            handler : this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_canton'
                        },{
                            text: 'Administraci\u00f3n de parroquias',
                            iconCls:'bogus',
                            handler : this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_parroquia'
                        },{
                            text: 'Administraci\u00f3n de isla',
                            iconCls:'bogus',
                            handler : this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_isla'
                        }]
                    }
                },{
                    text:"Distribuci\u00f3n departamental",
                    iconCls:'bogus',
                    menu:{
                        items:[{
                            text: 'Administraci\u00F3n cargo',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_res_cargo'
                        },{
                            text: 'Administraci\u00F3n seccion',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_res_seccion'
                        }
                        ]
                    }
                },{
                    text:'Administraci\u00f3n de persona',
                    iconCls:'bogus',
                    menu:{
                        items:[{
                            text: 'Administraci\u00f3n de estado civil',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_res_estado_civil'
                        },{
                            text: 'Administraci\u00F3n de tipo contacto',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_res_tipo_contacto'
                        },{
                            text: 'Administraci\u00f3n de tipo sanguineo',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_res_tipo_sanguineo'
                        },{
                            text: 'Administraci\u00f3n de nacionalidad',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_nacionalidad'
                        },{
                            text: 'Administraci\u00f3n de documentos',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_res_documento_identificacio'
                        },{
                            text:'Idiomas',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope:this,
                            windowId:'FrmListadoCgg_gem_idioma'
                        },'-',{
                            text: 'Administraci\u00f3n de persona jur\u00EDdica',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_res_persona_juridica'
                        }
                        ]
                    }
                },{
                    text:"Listados adicionales",
                    iconCls:'bogus',
                    menu:{
                        items:[{
                            text: 'Administraci\u00f3n de Procesos',
                            iconCls:'bogus',
                            handler : this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_res_proceso'
                        },{
                            text: 'Administraci\u00F3n criterio de fase',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_jur_criterio'
                        },{
                            text: 'Administraci\u00f3n veh\u00EDculo sector',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_veh_sector'

                        }]
                    }
                },{
                    text:"Control de informaci\u00f3n",
                    iconCls:'iconRegla',
                    menu:{
                        items:[{
                            text: 'Administraci\u00F3n de validaci\u00F3nes',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_regla_validacion'
                        },
                        {
                            text: 'Administraci\u00F3n de operaciones de validaci\u00F3n',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_operacion_validacion'
                        }]
                    }
                },{
                    text:"Sitio Web",
                    iconCls:'bogus',
                    menu:{
                        items:[{
                            text: 'Administraci\u00F3n de p\u00E1ginas',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_web_pagina'
                        },'-',
                        {
                            text: 'Administraci\u00F3n de frases de bienvenida',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_web_frase_bienvenida'
                        },'-',{
                            text:'Administraci\u00F3n de m\u00F3dulos',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope:this,
                            windowId:'FrmListadoCgg_web_modulo'
                        },{
                            text:'Administraci\u00F3n de agencias',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope:this,
                            windowId:'FrmListadoCgg_web_agencia'
                        },{
                            text:'Contactos Agencias',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope:this,
                            windowId:'FrmListadoCgg_res_agencia_contacto'
                        }]
                    }
                },{
                    text: 'Administraci\u00f3n de Archivos',
                    iconCls:'iconAdjunto',
                    handler :this.createWindow,
                    scope:this,
                    windowId:'FrmListadoCgg_ecm_archivo'
                },{
                    text: 'Administraci\u00f3n sector productivo',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_sector_productivo'
                },{
                    text: 'Administraci\u00F3n par\u00E1metros configuraci\u00f3n',
                    iconCls:'iconConfiguracion',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_configuracion'
                },{
                    text: 'Servicio de notificaciones',
                    iconCls:'iconMegafono',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_buzon_correo'
                },'-',{
                    text: 'Reportes del sistema',                   
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_sec_reporte'
                }
                ]
            }
        }
    }
});

MyDesktop.resSeguimiento = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            
            
            handler: function() {
                return false;
            },
            menu: {
                items:[
            ]
            }
        }
    }
});

/**
 * Menu item. Menu de Vehiculos
 */
MyDesktop.StartMenuVehiculos = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            text: 'Veh\u00edculos',
            iconCls: 'iconVehiculos',
            handler: function() {
                return false;
            },
            menu: {
                items:[{
                    text:'Seguimiento de tr\u00e1mites',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_seguimiento_vehiculo'
                },{
                    text: 'Estados',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_veh_estado_vhmt'
                },{
                    text: 'Combustible',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_veh_combustible'
                },{
                    text: 'Motores',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_veh_motor'
                },{
                    text: 'Cilindraje',
                    iconCls:'bogus',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_veh_cilindraje'
                },{
                    text: 'Marcas',
                    iconCls:'bogus',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_veh_marca'
                },{
                    text: 'Color',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_veh_color'
                },{
                    text: 'Categorias',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_veh_categoria'
                },{
                    text: 'Veh\u00edculos',
                    iconCls:'bogus',
                    handler :this.createWindow,
                    scope:this,
                    windowId:'FrmListadoCgg_veh_vehiculo'
                }]
            }
        }
    }
});
/**
 * Menu item. Menu de configuracion de valores del SIICGG
 */
MyDesktop.StartMenuComite = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            text: 'Comit\u00e9',
            iconCls: 'iconComite',
            handler: function() {
                return false;
            },
            menu: {
                items:[{
                    text: 'Comit\u00e9',
                    iconCls:'bogus',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_comite'
                },{
                    text: 'Cargo de Comit\u00e9',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_cargo_comite'
                },{
                    text: 'Miembros de Comit\u00e9',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_miembro_comite'
                },{
                    text: 'Sesi\u00f3n de Comit\u00e9',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_sesion_comite'
                },{
                    text: 'Asistencia a sesi\u00F3n Comit\u00e9',
                    iconCls:'bogus',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_sesion_miembro'
                },{
                    text: 'Resoluciones',
                    iconCls:'bogus',
                    handler :this.createWindow,
                    scope:this,
                    windowId:'FrmListadoCgg_res_resolucion'
                },{
                    text: 'Voto',
                    iconCls:'bogus',
                    handler : this.createWindow,
                    scope:this,
                    windowId:'FrmListadoCgg_res_voto'
                },{
                    text: 'Voto Administrador',
                    iconCls:'bogus',
                    handler : this.createWindow,
                    scope:this,
                    windowId:'FrmListadoCgg_res_voto_administrador'
                }]
            }
        }
    }
});
/**
 * Menu item. Menu de configuracion de valores del SIICGG
 */
MyDesktop.StartMenuSeguridad = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            text: 'Seguridad',
            iconCls: 'iconSeguridad',
            handler: function() {
                return false;
            },
            menu: {
                items:[{
                    text: 'Privilegios',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_sec_objeto_rol'
                },{
                    text: 'Perfiles',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_sec_usuario_rol'
                },{
                    text: 'Objetos',
                    iconCls:'bogus',
                    handler : this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_sec_objeto'
                },{
                    text: 'Roles',
                    iconCls:'bogus',
                    handler : this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_sec_rol'
                },{
                    text: 'Sustitucion',
                    iconCls:'bogus',
                    handler : this.createWindow,
                    scope:this,
                    windowId:'FrmListadoCgg_sustitucion'
                },{
                    text: 'Usuario',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope:this,
                    windowId:'FrmListadoCgg_usuario'
                },{
                    text: 'Sesiones',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope:this,
                    windowId:'FrmListadoCgg_sec_sesion'
                }]
            }
        }
    }
});
/**
 * Menu item. Menu de configuracion de valores del SIICGG
 */
MyDesktop.StartMenuTct = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            text: 'TCT',
            iconCls: 'iconTCT',
            handler: function() {
                return false;
            },
            menu: {
                items:[{
                    text: 'Aerolinea',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_aerolinea'
                },{
                    text: 'Aeropuerto',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_aeropuerto'
                },{
                    text: 'Actividad',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_tct_actividad'
                },{
                    text: 'Registro TCT',
                    iconCls:'bogus',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_tct_registro'
                },{
                    text: 'Tipo Hospedaje',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_tct_tipo_hospedaje'
                },{
                    text: 'Ingreso fallido',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_tct_ingreso_fallido'
                },{
            	    text: 'Reporte Financiero',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmCgg_tct_reporte_finaniero'
                }
                ]
            }
        }
    }
});
/**
 * Menu item. Menu de configuracion de valores del SIICGG
 */
MyDesktop.StartMenuMovilidad = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            text: 'Movilidad',
            iconCls: 'iconTCT',
            handler: function() {
                return false;
            },
            menu: {
                items:[{
                    text: 'Forma Salida',
                    iconCls:'bogus',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_tct_forma_salida'
                },{
                    text:"Movimiento Turistas/Transeuntes",
                    iconCls:'iconMovilidad',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_movilidad'
                },{
                    text: 'Movimiento Residentes',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_movilidad_residentes'

                },{
                    text: 'Expulsion',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_expulsion'
                }]

            }
        }
    }
});

/**
 * Menu item. Menu de configuracion de valores del SIICGG
 */
MyDesktop.StartMenuMovilidadInterna = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            text: 'Movilidad Interna',
            iconCls: 'iconTCT',
            handler: function() {
                return false;
            },
            menu: {
                items:[{
                    text: 'Movilidad Interna',
                    iconCls:'bogus',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_movilidad_interna'
                },{
                    text: 'Muelle',
                    iconCls:'bogus',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_muelle'
                },{
                    text:"Embarcaci\u00f3n",
                    iconCls:'bogus',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_res_embarcacion'

                }]

            }
        }
    }
});





/**
 * Menu item. Menu de Gestion de empleo
 */
MyDesktop.StartMenuGestionEmpleo = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            text: 'Gesti&oacute;n de empleo',
            iconCls: 'iconGestionEmpleo',
            handler: function() {
                return false;
            },
            menu: {
                items:[/*{
                 text:'Solicitud de clave',
                 iconCls:'bogus',
                 handler:this.createWindow,
                 scope:this,
                 windowId:'FrmListadoCgg_gem_area_funcional'
                 },*/{
                    text:'Ofertas vacantes',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope:this,
                    windowId:'FrmListadoCgg_gem_vacante'
                },{
                    text:'Administraci\u00F3n busqueda perf\u00EDl',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope:this,
                    windowId:'FrmListadoCgg_gem_busqueda_perfil',
                    params: [false]
                },{
                    text:'Administraci\u00F3n de Empresas',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope:this,
                    windowId:'FrmListadoCgg_gem_empresa'
                },"-",{
                    text:'Administraci\u00F3n de destrezas',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope:this,
                    windowId:'FrmListadoCgg_gem_destreza'
                },"-",{
                    text: 'Denuncias de gesti\u00F3n de empleo',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    params: [TypeDenuncia.GESTIONEMPLEO],
                    windowId:'FrmListadoCgg_res_denuncia'
                },"-",{
                    text: 'Administrac\u00f3n preguntas frecuentes',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_web_preguntas'
                },
                {
                    text:"Configuraci\u00F3n",
                    iconCls:'iconConfiguracion',
                    menu:{
                        items:[{
                            text:'Area funcional',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope:this,
                            windowId:'FrmListadoCgg_gem_area_funcional'
                        },{
                            text:'Cargos',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope:this,
                            windowId:'FrmListadoCgg_gem_cargo'
                        },{
                            text:'Tipos de contratos',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope:this,
                            windowId:'FrmListadoCgg_gem_tipo_contrato'
                        },{
                            text:'Tipos de salarios',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope:this,
                            windowId:'FrmListadoCgg_gem_tipo_salario'
                        },{
                            text:'Administraci\u00F3n de destrezas',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope:this,
                            windowId:'FrmListadoCgg_gem_destreza'
                        }]
                    }
                }]
            }
        }
    }
});
/**
 * Menu item. Menu de Kardex TCT
 */
MyDesktop.StartMenuKardexTct = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            text: 'Kardex',
            iconCls: 'iconTCT',
            handler: function() {
                return false;
            },
            menu: {
                items:[{
                    text:'Punto de venta',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope:this,
                    windowId:'FrmListadoCgg_kdx_punto_venta'
                },{
                    text: 'Tipo de pago',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_kdx_tipo_pago'
                },{
                    text: 'Denominaciones',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_kdx_denominacion'
                },{
                    text: 'Transferencia',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_kdx_transferencia'
                },{
                    text: 'Transferencia punto de venta',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_kdx_transferencia_pv'
                },{
                    text: 'Asignaci\u00f3n',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_kdx_asignacion'
                },
                {
                    text: 'Stock de asignaciones',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_kdx_asignacion_stock'
                },{
                    text: 'Ingresos',
                    iconCls:'bogus',
                    handler :this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_kdx_compra'
                },{
                    text: 'Ventas',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_kdx_venta'
                },{
                    text: 'Cierre caja',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_kdx_cierre'
                },{
                    text: 'Kardex',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_kdx_kardex'
                },{
                    text: 'Tipos de especies',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_kdx_especie'
                }, {
                    text: 'Anulaci\u00f3n especie',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_kdx_anulacion'
                }]
            }
        }
    }
});
/**
 * Menu item. Menu de Desarrollo Humano
 */
MyDesktop.StartMenuDesarrolloHumano = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            text: 'Desarrollo Humano',
            iconCls: 'iconDesHumano',
            handler: function() {
                return false;
            },
            menu: {
                items:[{
                    text:"Administraci\u00f3n de Beca",
                    iconCls:'bogus',
                    menu:{
                        items:[{
                            text: 'Registro beca',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_dhu_beca'
                        },{
                            text: 'Seguimiento Acad\u00e9mico',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_dhu_seguimiento_academico'
                        },{
                            text: 'Seguimiento Econ\u00f3mico',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_dhu_seguimiento_economico'
                        },{
                            text: 'Seguimiento Profesional',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_dhu_seguimiento_profesional'
                        },{
                            text:"Configuraci\u00f3n",
                            iconCls:'bogus',
                            menu:{
                                items:[
                                {
                                    text: 'Concepto desembolso',
                                    iconCls:'bogus',
                                    handler :this.createWindow,
                                    scope: this,
                                    windowId:'FrmListadoCgg_dhu_tipo_concepto'
                                },{
                                    text: 'Beca Certificado',
                                    iconCls:'bogus',
                                    handler:this.createWindow,
                                    scope: this,
                                    windowId:'FrmListadoCgg_dhu_beca_certificado'
                                }, '-',{
                                    text: 'Tipo de beca',
                                    iconCls:'bogus',
                                    handler:this.createWindow,
                                    scope: this,
                                    windowId:'FrmListadoCgg_dhu_tipo_beca'
                                },{
                                    text: 'Tipo Certificado',
                                    iconCls:'bogus',
                                    handler:this.createWindow,
                                    scope: this,
                                    windowId:'FrmListadoCgg_dhu_tipo_cacademico'
                                } ]
                            }
                        }]
                    }
                },{
                    text:"Administraci\u00f3n de Curso",
                    iconCls:'bogus',
                    menu:{
                        items:[{
                            text: 'Cursos',
                            iconCls:'bogus',
                            handler:this.createWindow,
                            scope: this,
                            windowId:'FrmListadoCgg_dhu_curso'
                        },{
                            text:"Asistentes curso",
                            iconCls:'bogus',
                            menu:{
                                items:[

                                {
                                    text: 'Registro asistente',
                                    iconCls:'bogus',
                                    handler:this.createWindow,
                                    scope: this,
                                    windowId:'FrmListadoCgg_dhu_asistente_curso'
                                }
                                ]
                            }
                        },{
                            text:"Configuraci\u00f3n",
                            iconCls:'bogus',
                            menu:{
                                items:[

                                {
                                    text: 'Tipo de curso',
                                    iconCls:'bogus',
                                    handler:this.createWindow,
                                    scope: this,
                                    windowId:'FrmListadoCgg_dhu_tipo_curso'
                                },{
                                    text: 'Instituci\u00F3n',
                                    iconCls:'bogus',
                                    handler:this.createWindow,
                                    scope: this,
                                    windowId:'FrmListadoCgg_dhu_institucion_responsable'
                                }
                                ]
                            }
                        },{
                            text:"Encuestas",
                            iconCls:'bogus',
                            menu:{
                                items:[ {
                                    text: 'Categor\u00EDa',
                                    iconCls:'bogus',
                                    handler:this.createWindow,
                                    scope: this,
                                    windowId:'FrmListadoCgg_dhu_categoria'
                                }, {
                                    text: 'Pregunta',
                                    iconCls:'bogus',
                                    handler:this.createWindow,
                                    scope: this,
                                    windowId:'FrmListadoCgg_dhu_pregunta'
                                },
                                {
                                    text: 'Respuesta',
                                    iconCls:'bogus',
                                    handler:this.createWindow,
                                    scope: this,
                                    windowId:'FrmListadoCgg_dhu_respuesta'
                                },
                                {
                                    text: 'Pregunta / Respuesta',
                                    iconCls:'bogus',
                                    handler:this.createWindow,
                                    scope: this,
                                    windowId:'FrmListadoCgg_dhu_pregunta_respuesta'
                                }, {
                                    text: 'Encuesta',
                                    iconCls:'bogus',
                                    handler:this.createWindow,
                                    scope: this,
                                    windowId:'FrmListadoCgg_dhu_encuesta'
                                },
                                {
                                    text: 'Cuestionario',
                                    iconCls:'bogus',
                                    handler:this.createWindow,
                                    scope: this,
                                    windowId:'FrmListadoCgg_dhu_cuestionario'
                                },

                                {
                                    text: 'Cronograma Encuesta',
                                    iconCls:'bogus',
                                    handler:this.createWindow,
                                    scope: this,
                                    windowId:'FrmListadoCgg_dhu_cronograma_encuesta'
                                },
                                {
                                    text: 'Aplicaci\u00F3n Encuesta',
                                    iconCls:'bogus',
                                    handler:this.createWindow,
                                    scope: this,
                                    windowId:'FrmListadoCgg_dhu_aplicacion_encuesta'
                                }

                                ]
                            }
                        }
                        ]
                    }
                }]
            }
        }
    }
});

MyDesktop.StartMenuJuridico = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            text: 'Juridico',
            iconCls: 'iconJuridico',
            handler: function() {
                return false;
            },
            menu: {
                items:[{
                    text:'Acuerdos',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope:this,
                    windowId:'FrmListadoCgg_jur_acuerdo'
                },{
                    text: 'Anticipo',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_jur_anticipo'
                },{
                    text: 'Historial Acuerdos',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_jur_historial_acuerdo'
                },'-',{
                    text: 'Procesos Judiciales',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_jur_proceso_judicial'
                },{
                    text: 'Asesor',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_jur_asesor'
                },{
                    text: 'Historial Procesos',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_jur_historial_proceso'
                },'-',{
                    text: 'Tipo Proceso',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_jur_tipo_proceso'
                },{
                    text: 'Area Influencia',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_area_influencia'
                },{
                    text: 'Criterios',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope: this,
                    windowId:'FrmListadoCgg_jur_seguimiento_criterio_juridico'
                }
                ]
            }
        }
    }
});

MyDesktop.StartMenuGerencial = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            text: 'Gerencial',
            iconCls:'iconGerencial',
            handler: this.createWindow,
            scope: this,
            menu: {
                items:[
                {
                    text:'Listado de reporte indicadores',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope:this,
                    windowId:'FrmCgg_gerencial_reporte'
                },{
                    text:'Subsistema gerencial',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope:this,
                    windowId:'FrmCgg_gerencial_matriz'
                },'-',{
                    text:'Administraci\u00f3n encargado indicador ',
                    iconCls:'bogus',
                    handler:this.createWindow,
                    scope:this,
                    windowId:'FrmListadoCgg_ger_indicador_encargado'
                }
                ]
            }            
        }
    }
});


MyDesktop.StartOffline = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            text: 'Offline',
            iconCls:'iconOffline',
            handler: this.createWindow,
            scope: this,
            menu: {
                items:[
                {
                    text:'Tct',
                    iconCls:'bogus',
                    handler:function(){
                        var usuarioPvt = new FrmCgg_usuario_pvt();
                        usuarioPvt.show();
                    },
                    scope:this                    
                },{
                    text:'E/S persona',
                    iconCls:'bogus',
                    handler:function(){
                        /*var Canton_offlin = new FrmCgg_canton_offline();
                        Canton_offlin.show();*/
                        var url = 'https://'+ URL_SERVER +URL_WS+'/PublicWS/DatosConfigMovilidadSRV?tipo=file';
                        var open_link = window.open('');
                        open_link.location= url ;
                    },
                    scope:this
                },{
                    text:'Notificaci\u00f3n',
                    iconCls:'bogus',
                    handler:function(){
                        //                        var Canton_noti_offlin = new FrmCgg_canton_noti_offline();
                        //                           Canton_noti_offlin.show();
                        var open_link = window.open('');
                        var url = 'https://'+ URL_SERVER +URL_WS+'/PublicWS/DatosConfigNotificacionSRV?tipo=file';
                        open_link.location= url ;
                    },
                    scope:this
                }
                ]
            }
        }
    }
});