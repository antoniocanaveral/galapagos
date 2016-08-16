    /**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_seguimiento.
* @constructor
* @param inDesktop Escritorio web de la aplicacion.
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_res_seguimiento(inDesktop){
    var optMenu = 'Control de Residencia/Seguimiento de tr\u00e1mites';
    var urlListadoCgg_res_seguimiento=URL_WS+"Cgg_res_seguimiento";
    var tituloListadoCgg_res_seguimiento='Revisi\u00F3n del seguimiento';
    var descListadoCgg_res_seguimiento='El formulario permite revisar informaci\u00f3n del seguimiento';
    var isVehiculo = false;
    /**
* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_seguimiento.
*/
    var btnEditarCgg_res_seguimiento = new Ext.Button({
        id:'btnEditarCgg_res_seguimiento',
        text:'Revisar',
        iconCls:'iconBuscar',
        tooltip:'Revisar',
        listeners:{
            click:function(){
                var r=grdCgg_res_seguimiento.getSelectionModel().getSelected();
                if(r){

                    var scpRevisionSeguimiento = new SOAPClientParameters();
                    scpRevisionSeguimiento.add('inCrseg_codigo',r.get('CRSEG_CODIGO'));

                    SOAPClient.invoke(URL_WS+'Cgg_res_seguimiento', 'revisionSeguimiento', scpRevisionSeguimiento, true, function(inServiceResponse){
                        
                        });

                    var objCgg_res_seguimiento = inDesktop.getWindow('winFrmCgg_res_seguimiento');
                    if (objCgg_res_seguimiento){
                        objCgg_res_seguimiento.maximize();
                        objCgg_res_seguimiento.close();
                    }
                    objCgg_res_seguimiento = new FrmCgg_res_seguimiento(r,inDesktop);
                    objCgg_res_seguimiento.closeHandler(function(){
                        gsCgg_res_seguimiento.reload();
                        comprobarSeguimiento();
                    });
                    objCgg_res_seguimiento.loadData();
                    if(isVehiculo)
                        objCgg_res_seguimiento.setVehiculo();
                    objCgg_res_seguimiento.show();
                }
            }
        }
    });
  
    /**
* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_seguimiento.
*/
    var btnSalirCgg_res_seguimiento = new Ext.Button({
        id:'btnSalirCgg_res_seguimiento',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Salir del formulario',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_seguimiento.close();
            }
        }
    });
    /**
* Ext.Button Boton para obtener reportes, general o individual.
*/var btnReporteCgg_res_seguimiento = new Ext.Button({
        id:'btnReporteCgg_res_seguimiento',
        name:'btnReporteCgg_res_seguimiento',
        text:'Reportes',
        iconCls:'iconImprimir',
        tooltip:'Imprimir seguimiento',
        menu:[
        {
            text:'Mis tr\u00E1mites ',
            handler:function(){
                var params = [];
                

                params[0]={
                    label:'Fecha inicio',
                    paramName:'P_FECHA_INICIAL',
                    paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
                    type:'date'
                };

                params[1]={
                    label:'Fecha fin',
                    paramName:'P_FECHA_FINAL',
                    paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
                    type:'date'
                };

                params[2]={
                    label:'Usuario',
                    paramName:'P_CUSU_CODIGO',
                    paramValue:new UserSession().getUserID(),
                    value:new UserSession().getUserData().CUSU_NOMBRE_USUARIO,
                    type:'direct'
                };

                params[3]={
                    objectName:'FrmListadoCgg_res_tipo_solicitud_tramite',
                    label:'Tipo solicitud',
                    valueField:'CRTST_CODIGO',
                    displayField:'CRTST_DESCRIPCION',
                    paramName:'P_CRTST_CODIGO',
                    paramValue:'',
                    type:'searchable'
                };
				
				params[4]={
                    objectName:'FrmListadoCgg_res_seccion',
                    label:'Secci\u00f3n',
                    valueField:'CRSEC_CODIGO',
                    displayField:'CRSEC_NOMBRE',
                    paramName:'P_CRSEC_CODIGO',
                    paramValue:'',
                    type:'searchable'
                };
				
                params[5]={
                    label:'Atenci\u00f3n',
                    paramName:'P_CRSEG_ESTADO_ATENCION',
                    value:dsEstadoAtencion,
                    paramValue:'',
                    type:'combo',
                    required:true
                };

                var reporte = new FrmCriterioReporte('rptListadoSolicitudesResidenciaReceptados', '/Reports/sii/residencia', null);
                reporte.addParams(params);
                reporte.show();
            }
        }
        ]
    });
       
    /**
     *  Ext.ux.grid.RowExpander Expandir fila
     **/
    var reSeguimiento = new Ext.ux.grid.RowExpander({
        tpl : new Ext.Template(       
            '<br> <table style="width:100%;" border="0"> <tr> <td style="width:50%;"> <div style="vertical-align:middle;"> <table id="ver-zebra" style="width:100%;" border="0"> <colgroup> <col class="vzebra-odd"/> <col class="vzebra-even"/> </colgroup> <tr><td width="100">Datos de Tr&aacute;mite</td> <td></td> </tr> <tr><td width="100">N&uacute;mero</td><td>{CRTRA_ANIO}-{CRTRA_NUMERO}</td></tr> <tr><td width="100">Beneficiario</td><td>{CRPER_BENEFICIARIO}<br/></td></tr> <tr><td width="100">Auspiciante</td><td>{CRPER_AUSPICIANTE}</td></tr> <tr><td width="100">Recepci&oacute;n</td><td>{FECHA_RECEPCION_TRAMITE}</td></tr> <tr><td width="100">Tipo solicitud</td><td>{CRTST_DESCRIPCION}</td></tr> <tr><td width="100">Transeunte</td><td></td></tr> <tr><td width="100">Fecha entrada:</td><td>{CRTRA_FECHA_ENTRADA}</td></tr> <tr><td width="100">Fecha salida:</td><td>{CRTRA_FECHA_SALIDA}</td></tr> </table> </div> </td> <td style="width:50%;"> <table id="ver-zebra" style="width:100%;" border="0"> <colgroup> <col class="vzebra-odd"/><col class="vzebra-even"/></colgroup> <tr><td width="100">Datos de fase</td> <td></td> </tr> <tr><td width="100">Anterior</td><td>{CRFAS_NOMBRE_ANTERIOR}</td></tr> <tr><td width="100">Actual</td><td class="textoResultado">{CRFAS_NOMBRE}</td></tr> <tr><td width="100">Recepci&oacute;n</td><td>{CRSEG_FECHA_RECEPCION}</td></tr> <tr><td width="100">Revisi&oacute;n</td><td>{CRSEG_FECHA_REVISION}</td></tr> <tr><td width="100">Despacho</td><td>{CRSEG_FECHA_DESPACHO}</td></tr> </table> </td> </tr> <tr> <td colspan="2"><p/>{SEGUIMIENTO_HTML}</td> </tr> </table>'
            )
    });


    var cbcCRTRA_GRUPO =  new Ext.grid.CheckColumn({
        dataIndex:'CRTRA_GRUPO',
        header:'Grupal',
        width:80,
        sortable:true
    });

    /**
* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_seguimiento.
*/
    var cmCgg_res_seguimiento = new Ext.grid.ColumnModel([
        reSeguimiento,
        {
            dataIndex:'CRSEG_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },

        {
            dataIndex:'CRSEG_NUMERO',
            header:'Seg.',
            width:60,
            sortable:true
        },

        {
            dataIndex:'CRSEG_DESCRIPCION',
            header:'Descripci\u00F3n',
            width:100,
            sortable:true,
            hidden:true
        },

        {
            dataIndex:'CRTRA_CODIGO',
            header:'Tr\u00E1mite',
            width:60,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'CRTRA_ANIO',
            header:'A\u00F1o',
            width:50,
            sortable:true
        },

        {
            dataIndex:'CRTRA_NUMERO',
            header:'Tr\u00E1mite',
            width:80,
            sortable:true
        },

        {
            dataIndex:'CRTST_DESCRIPCION',
            header:'Tipo solicitud',
            width:100,
            sortable:true
        },

        {
            dataIndex:'CRPER_AUSPICIANTE',
            header:'Auspiciante',
            width:150,
            sortable:true
        },

        {
            dataIndex:'VEHICULO',
            header:'Veh\u00edculo',
            width:150,
            sortable:true,
            hidden:true
        },

        {
            dataIndex:'CRPER_BENEFICIARIO',
            header:'Beneficiario',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CGG_CRPER_CODIGO',
            header:'CGG_CRPER_CODIGO',
            width:70,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'CGG_CRSEG_CODIGO',
            header:'Seguimiento recursivo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'CRFAS_CODIGO',
            header:'Fase',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'CGG_CRFAS_CODIGO',
            header:'Fase recursiva',
            width:50,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'CUSU_CODIGO',
            header:'Usuario',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'CRSEG_ESTADO_ATENCION',
            header:'Estado',
            width:100,
            sortable:true,
            renderer:function(inCRSEG_ESTADO_ATENCION){
                for(var x=0;x<dsEstadoAtencionSeguimiento.length;x++){
                    if(dsEstadoAtencionSeguimiento[x][0]==inCRSEG_ESTADO_ATENCION){
                        return dsEstadoAtencionSeguimiento[x][1];
                    }                                            
                }
                return NO_DATA_MESSAGE;
            }
        },
        {
            dataIndex:'CRSEG_OBSERVACION',
            header:'Observaci\u00F3n',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'CRSEG_TIPO_RESPUESTA',
            header:'Respuesta',
            width:100,
            sortable:true,
            renderer:function(inCRSEG_TIPO_RESPUESTA){
                for(TipoRespuesta in TypeRespuestaSeguimiento){
                    if(eval('TypeRespuestaSeguimiento.'+TipoRespuesta)==inCRSEG_TIPO_RESPUESTA){
                        return TipoRespuesta;
                    }
                }
                return NO_DATA_MESSAGE;
            }
        },
        {
            dataIndex:'CRSEG_TIPO_ACTIVIDAD',
            header:'Tipo actividad',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'CRSEG_FECHA_RECEPCION',
            header:'Fecha recepci\u00F3n',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'CRTRA_FECHA_RECEPCION',
            header:'Recepci\u00F3n',
            width:80,
            sortable:true,
            renderer:truncDate
        },

        {
            dataIndex:'CRSEG_FECHA_REVISION',
            header:'Fecha revisi\u00F3n',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'CRSEG_FECHA_DESPACHO',
            header:'Fecha despacho',
            width:150,
            sortable:true,
            hidden:true,
            renderer:truncDate
        },

        {
            dataIndex:'CRSEG_ESTADO_HIJO',
            header:'Seguimiento',
            width:100,
            sortable:true,
            renderer:function(inCRSEG_ESTADO_HIJO){
                for(TipoHijo in TypeEstadoHijo){
                    if(eval('TypeEstadoHijo.'+TipoHijo) == inCRSEG_ESTADO_HIJO){
                        return TipoHijo;
                    }
                }
                return NO_DATA_MESSAGE;
            }
        },
        {
            dataIndex:'CRSEG_FECHA_REAPERTURA',
            header:'Fecha reapertura',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'CRSEG_VECES_REVISION',
            header:'Veces revisi\u00F3n',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'CUSU_ANTERIOR',
            header:'Usuario Ant.',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'CRSEG_DESCRIPCION',
            header:'Descripci\u00F3n',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CISLA_CODIGO',
            header:'Isla',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },

        {
            dataIndex:'CISLA_NOMBRE',
            header:'Isla',
            width:100,
            sortable:true
        },
        cbcCRTRA_GRUPO,
        {
            dataIndex:'CRTRA_ORDEN',
            header:'Transeunte',
            width:100,
            sortable:true
        }
        ]);
    /**
* Ext.data.Store Agrupacion de registros de la tabla Cgg_res_seguimiento por un campo especifico.
*/
    var gsCgg_res_seguimiento = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_seguimiento",
            method:"selectPageDirect1",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRSEG_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {name:'CRSEG_CODIGO'},
        {name:'CGG_CRSEG_CODIGO'},
        {name:'CRTRA_CODIGO'},
        {name:'CRFAS_CODIGO'},
        {name:'CGG_CRFAS_CODIGO'},
        {name:'CUSU_CODIGO'},
        {name:'CRSEG_DESCRIPCION'},
        {name:'CRSEG_ESTADO_ATENCION'},
        {name:'CRSEG_OBSERVACION'},
        {name:'CRSEG_TIPO_RESPUESTA'},
        {name:'CRSEG_TIPO_ACTIVIDAD'},
        {name:'CRSEG_FECHA_RECEPCION'},
        {name:'CRSEG_FECHA_REVISION'},
        {name:'CRSEG_FECHA_DESPACHO'},
        {name:'CRSEG_ESTADO_HIJO'},
        {name:'CRSEG_USUARIO_INSERT'},
        {name:'CRTRA_NUMERO'},
        {name:'CRFAS_NOMBRE'},
        {name:'CUSU_APELLIDOS'},
        {name:'CUSU_ANTERIOR'},
        {name:'CRTRA_FECHA_RECEPCION'},
        {name:'CISLA_CODIGO'},
        {name:'CRSEG_NUMERO'},
        {name:'CRPJR_CODIGO'},
        {name:'CRTRA_OBSERVACION'},
        {name:'CRTRA_COMUNICADO_RADIAL'},
        {name:'CRPER_CODIGO'},
        {name:'CRPER_BENEFICIARIO'},
		{name:'CGG_CRPER_NUM_DOC_IDENTIFIC'},
        {name:'CGG_CRPER_CODIGO'},
        {name:'CRPER_AUSPICIANTE'},
        {name:'CRTRA_ANIO'},
        {name:'CISLA_NOMBRE'},
        {name:'CRTRA_ACTIVIDAD_RESIDENCIA'},
        {name:'CRTST_DESCRIPCION'},
        {name:'CRFAS_NOMBRE_ANTERIOR'},
        {name:'CRPJR_RAZON_SOCIAL'},
        {name:'CRTST_CODIGO'},
        {name:'VEHICULO'},
        {name:'CRPRO_CODIGO'},
        {name:'SEGUIMIENTO_HTML'},
        {name:'CRTRA_FOLIO'},
        {name:'CRTRA_DIAS_PERMANENCIA'},
        {name:'CRTRA_FECHA_ENTRADA'},
        {name:'CRTRA_FECHA_SALIDA'},
        {name:'CRTRA_GRUPO'},
        {name:'CRTRA_ORDEN'},
        {name:'CRETT_CODIGO'},
        {name:'REP_CRPER_CODIGO'},
        {name:'CHANGE_CRTST_CODIGO'},
        {name:'CRTT_CODIGO'}
        ]),
        groupField:'CRTRA_FECHA_RECEPCION',
        sortInfo:{
            field: 'CRSEG_FECHA_RECEPCION',
            direction: 'DESC'
        },
        baseParams:{
            keyword:"",
            format:"JSON",
            inCrtst_codigo:SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','13')).get('CGCNF_VALOR_CADENA')
        }
    });
    /**
* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_seguimiento.
*/
    var pgBarCgg_res_seguimiento= new Ext.PagingToolbar({
        store: gsCgg_res_seguimiento,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });

    var gvCgg_res_seguimiento = new Ext.grid.GroupingView({
        enableRowBody:true,
        groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Tr\u00E1mites" : "Tr\u00E1mite"]})',
        getRowClass: function(inRecord, inRowIndex, inRowParams, inStore){
            var resCss='';
            switch (inRecord.get('CRSEG_ESTADO_HIJO')) {
                case TypeEstadoHijo.SINHIJOS:
                    resCss = '';
                    break;
                case TypeEstadoHijo.SINRESPUESTAS:
                    resCss = 'row-orange';
                    break;
                case TypeEstadoHijo.RESPUESTAPARCIAL:
                    resCss = 'row-yellow';
                    break;
                case TypeEstadoHijo.RESPUESTATOTAL:
                    resCss = 'row-green';
                    break;
                default:
                    resCss='';
                    break;
            }
            return resCss;
        }
    });
    
    /**
* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_seguimiento en un formato tabular de filas y columnas.
*/
    var grdCgg_res_seguimiento = new Ext.grid.GridPanel({
        cm:cmCgg_res_seguimiento,
        store:gsCgg_res_seguimiento,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        viewConfig:gvCgg_res_seguimiento,
        tbar: [
        'Buscar: ', ' ',
        new Ext.ux.bsx.SearchField({
            id:'sfCgg_res_seguimiento',
            store:gsCgg_res_seguimiento,
            width:300
        })
        ],
        plugins:[reSeguimiento,new Ext.ux.grid.AutoSizeColumns()],
        bbar:pgBarCgg_res_seguimiento,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_seguimiento.hidden){
                    btnEditarCgg_res_seguimiento.fireEvent('click', btnEditarCgg_res_seguimiento);
                }
            }
        },              
        animCollapse: false
    });
    gsCgg_res_seguimiento.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON"
        }
    });


    /**
* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_seguimiento.
*/
    var winFrmListadoCgg_res_seguimiento = null;
    if(inDesktop){
        winFrmListadoCgg_res_seguimiento = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_seguimiento',
            title:tituloListadoCgg_res_seguimiento,
            tbar:getPanelTitulo(tituloListadoCgg_res_seguimiento,descListadoCgg_res_seguimiento),
            items:[grdCgg_res_seguimiento],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            iconCls:'iconSeguimiento',
            bbar:[btnEditarCgg_res_seguimiento,'-',btnReporteCgg_res_seguimiento,'->',btnSalirCgg_res_seguimiento],
            listeners:{
                show:function(){
                    if(isVehiculo){
                        cmCgg_res_seguimiento.setColumnHeader(8,'Solicitante');
                        cmCgg_res_seguimiento.setHidden(9, false);
                        cmCgg_res_seguimiento.setHidden(10, true);
                        cmCgg_res_seguimiento.setHidden(31, true);
                        cmCgg_res_seguimiento.setHidden(32, true);
                    }
                    Ext.getCmp('sfCgg_res_seguimiento').focus(true,400);
                }
            }
        });
		/**
		* Funcion que aplica los privilegios del usuario.
		*/
		applyGrants(winFrmListadoCgg_res_seguimiento.getBottomToolbar());
    }

    
    /**
* Funcion miembro que devuelve la ventana winFrmListadoCgg_res_seguimiento.
* @returns ventana winFrmCgg_res_seguimiento.
* @base FrmListadoCgg_res_seguimiento.prototype.show
*/
    this.getWindow = function(){
        return winFrmListadoCgg_res_seguimiento;
    }
    /**
* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_seguimiento.
* @base FrmListadoCgg_res_seguimiento.prototype.loadData
*/
    this.loadData = function(){
        gsCgg_res_seguimiento.load();
    }
    /**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
    this.getColumnModel = function(){
        return cmCgg_res_seguimiento;
    }
    /**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
    this.getStore = function(){
        return gsCgg_res_seguimiento;
    }
	
    this.setVehiculo = function(){
        isVehiculo = true;
        gsCgg_res_seguimiento.baseParams.inCrtst_codigo = SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','12')).get('CGCNF_VALOR_CADENA');
        gsCgg_res_seguimiento.reload();
    }
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_res_seguimiento.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_res_seguimiento.prototype.getStore = function(){
    this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_seguimiento desde una instancia.
*/
FrmListadoCgg_res_seguimiento.prototype.show = function(){
    this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_seguimiento desde una instancia.
*/
FrmListadoCgg_res_seguimiento.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_seguimiento,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_res_seguimiento.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_seguimiento desde una instancia.
*/
FrmListadoCgg_res_seguimiento.prototype.loadData = function(){
    this.loadData();
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_seguimiento desde una instancia.
*/
FrmListadoCgg_res_seguimiento.prototype.setVehiculo = function(){
    this.setVehiculo();
}
