/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_movilidad.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_movilidad(inDesktop){
    var optMenu = 'Movilidad/Movimiento Turistas-Transeuntes';
    var urlListadoCgg_res_movilidad=URL_WS+"Cgg_res_movilidad";
    var tituloListadoCgg_res_movilidad='Listado de ingreso de personas a la provincia';
    var descListadoCgg_res_movilidad='El formulario permite administrar la informaci\u00f3n del registro de ingreso de personas a la provincia';
	var tmpUserSession = new UserSession();
	var tmpNacionalidad= new Nacionalidad();
	
	var gsCgg_tct_actividad = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_tct_actividad",
            method:"selectAll"
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CTACT_CODIGO'
        },[
            {name:'CTACT_CODIGO'},
            {name:'CTACT_NOMBRE'}
        ]),
        baseParams:{
            format:"JSON"
        },
		listeners:{
			load:function(){
				btnNuevoCgg_res_movilidad.setDisabled(false);
			}
		}
    });
	
	var gsCgg_tct_tipo_hospedaje = new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_tct_tipo_hospedaje",
			method:"selectAll",
			pagin:false
		}),
		remoteSort:false,
		reader:new Ext.data.JsonReader({
			id:'CTTHJ_CODIGO'
		},[
			{name:'CTTHJ_CODIGO'},
			{name:'CTTHJ_NOMBRE'}
		]),
		baseParams:{
			format:'JSON'
		},
		listeners:{
			load:function(){
				gsCgg_tct_actividad.load();
			}
		}
	});
	gsCgg_tct_tipo_hospedaje.load();
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_movilidad.
     */
    var btnNuevoCgg_res_movilidad = new Ext.Button({
        id:'btnNuevoCgg_res_movilidad',
        text:'Ingreso',
        iconCls:'iconIngreso',
		disabled:true,
        listeners:{
            click:function(){
                var objCgg_res_movilidad = new FrmCgg_res_movilidad("insert");
				objCgg_res_movilidad.setStoreActividad(gsCgg_tct_actividad);
				objCgg_res_movilidad.setStoreHospedaje(gsCgg_tct_tipo_hospedaje);
				objCgg_res_movilidad.setUserSession(tmpUserSession);
				objCgg_res_movilidad.setNacionalidad(tmpNacionalidad.getStore());
                objCgg_res_movilidad.closeHandler(function(){
                    gsCgg_res_movilidad.reload();
                });
                objCgg_res_movilidad.show();
            }
        }
    });
	/**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_movilidad.
     */
    var btnNuevoCgg_res_movilidad2 = new Ext.Button({
        id:'btnNuevoCgg_res_movilidad2',
        text:'Salida',
        iconCls:'iconSalida',
        listeners:{
            click:function(){
                var objCgg_res_movilidad = new FrmCgg_res_movilidad_salida("insert");
				objCgg_res_movilidad.setUserSession(tmpUserSession);
                objCgg_res_movilidad.closeHandler(function(){
                    gsCgg_res_movilidad.reload();
                });
                objCgg_res_movilidad.show();
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_movilidad.
     */
    var btnSalirCgg_res_movilidad = new Ext.Button({
        id:'btnSalirCgg_res_movilidad',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_movilidad.close();
            }
        }
    });
    /**
     * Ext.Button Boton para obtener reportes, general o individual.
     */var btnReporteCgg_res_movilidad = new Ext.Toolbar.SplitButton({
        id:'btnReporteCgg_res_movilidad',
        name:'btnReporteCgg_res_movilidad',
        text:'Tiempos de estad\u00eda',
        iconCls:'iconImprimir',
        menu:[
            {
                text:'Listado de turistas y transeuntes',
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

                    /*params[2]={
                        objectName:'FrmListadoCgg_res_tipo_solicitud_tramite',
                        label:'Tipo solicitud',
                        valueField:'CRTST_CODIGO',
                        displayField:'CRTST_DESCRIPCION',
                        paramName:'P_CRTST_CODIGO',
                        value:'',
						paramValue:'',
                        required:false,
                        type:'searchable'
                    };*/

                     params[2]=
                                        {
                                            label:'Tipo residencia',
                                            paramName:'P_CRTST_CODIGO',
                                            value: dsTipoSolicitudPadre,
                                            paramValue:'',
                                            type:'combo',
                                            required:false
                                        };
                                        
                    params[3]={
                        label:'Operaci\u00f3n',
                        paramName:'P_CRMOV_TIPO_OPERACION',
                        value:dsTipoOperacion,
						paramValue:'',
                        type:'combo'
                    };
					params[4]={
                        objectName:'FrmListadoCgg_res_aeropuerto',
                        label:'Aeropuerto',
                        valueField:'CARPT_CODIGO',
                        displayField:'CARPT_NOMBRE',
                        paramName:'P_CARPT_CODIGO',
                        value:'',
						paramValue:'',
                        required:false,
                        type:'searchable'
                    };
					params[5] = {
						type:'input',
						label:'Vuelo',
						value:'',
						paramValue:'',
						required:false,
						paramName:'P_CRMOV_NUMERO_VUELO'
					};
					 params[6]=
                     {
                        objectName:'FrmListadoCgg_usuario',
                        label:'Usuario',
                        valueField:'CUSU_CODIGO',
                        displayField:'CUSU_NOMBRE_USUARIO',
                        paramName:'P_CUSU_CODIGO',
                        paramValue:'',
                        type:'searchable'
                    };

                    var reporte = new FrmCriterioReporte('rptListadodeTuristasTranseuntesNacionalesExtranjeros', '/Reports/sii/tct', null);
                    reporte.addParams(params);
                    reporte.show();
                }
            },
            {
                text:'Listado de excedido dias galapagos',
                handler:function(){
                    var params = [];                                      
                    params[0] = {
                            type:'input',
                            label:'N. filas',
                            value:'',
                            paramValue:'',
                            required:false,
                            paramName:'P_INICIO'
                    };
                    var reporte = new FrmCriterioReporte('rptListadoExcedidoDia', '/Reports/sii/tct', null);
                    reporte.addParams(params);
                    reporte.show();
                }
            }
        ],
		handler:function(){
        var params = [];

        var tmpCurrentDate = new Date();
					tmpCurrentDate.setDate(tmpCurrentDate.getDate()-365);
                    
        params[0]={
            label:'Fecha inicio',
            paramName:'P_FECHA_INICIAL',
            value:tmpCurrentDate,
            paramValue:tmpCurrentDate.toString('yyyyMMddhhmmss'),
            type:'date'
        };

        params[1]={
            label:'Fecha fin',
            paramName:'P_FECHA_FINAL',
            paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
            type:'date'
        };
        params[2]={
            required:false,
            label:'Nombres',
            paramName:'P_CRPER_NOMBRES',
            paramValue:'',
            value:'',
            type:'input'
        };
        params[3]={
            required:false,
            label:'Apellidos',
            paramName:'P_CRPER_APELLIDOS',
            paramValue:'',
            value:'',
            type:'input'
        };
        params[4]={
            required:false,
            label:'Identificaci\u00f3n',
            paramName:'P_CRPER_NUM_DOC_IDENTIFIC',
            paramValue:'',
            value:'',
            type:'input'
        };
        var reporte = new FrmCriterioReporte('rptTiemposEstadiaporPersona', '/Reports/sii/tct', null);
        reporte.addParams(params);
        reporte.show();
    }
    });
	/**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmCgg_tct_ingreso_salida_csv.
     */
    var btnNuevoCgg_tct_ingreso_salida= new Ext.Button({
        id:'btnNuevoCgg_tct_ingreso_salida',
        text:'Ingreso/Salida csv',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_tct_ingreso_salida = new FrmCgg_tct_ingreso_salida_csv(inDesktop);
				//objCgg_res_movilidad.setUserSession(tmpUserSession);
                objCgg_tct_ingreso_salida.closeHandler(function(){
                    gsCgg_res_movilidad.reload();
                });
                objCgg_tct_ingreso_salida.show();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_movilidad.
     */
    var chkCrmov_filtro_interno = new Ext.grid.CheckColumn(
		{dataIndex:'CRMOV_FILTRO_INTERNO',header:'Filtro interno',width:100,sortable:true});
    var cmCgg_res_movilidad = new Ext.grid.ColumnModel([
        {dataIndex:'CTREG_CODIGO_BARRAS',header:'Codigo Barras',width:150,sortable:true},
        {dataIndex:'AEROLINEA',header:'Aerolinea',width:80,sortable:true},
        {dataIndex:'AEROPUER_ORIGEN',header:'Aeropuerto origen',width:150,sortable:true},
        {dataIndex:'AEROPUER_DESTINO',header:'Aeropuerto arribo',width:150,sortable:true},
        {dataIndex:'CTREG_FECHA_INGRESO',header:'Ingreso',width:100,sortable:true,renderer:truncDate},
        {dataIndex:'CTREG_FECHA_SALIDA',header:'Salida',width:100,sortable:true,renderer:truncDate},
        {dataIndex:'DOCUMENTO',header:'Tipo documento',width:100,sortable:true},
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'Numero documento',width:150,sortable:true},
        {dataIndex:'CRPER_NOMBRES',header:'Nombres',width:150,sortable:true},
        {dataIndex:'CRPER_APELLIDO_PATERNO',header:'Apellidos',width:150,sortable:true},
        {dataIndex:'NACIONALIDAD',header:'Nacionalidad',width:150,sortable:true},
        {dataIndex:'PAIS_RESIDENCIA',header:'Pais Residencia',width:150,sortable:true},
        {dataIndex:'CRTRA_NUMERO',header:'Numero certificado',width:150,sortable:true},
        {dataIndex:'CRMOV_FECHA_VIAJE',header:'Fecha viaje',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CRMOV_NUMERO_VUELO',header:'Vuelo',width:70,sortable:true},
		{dataIndex:'ESTADIA',header:'Estad\u00eda',width:50,sortable:true},
		{dataIndex:'EXCESO',header:'Excedido',width:50,sortable:true},
        {dataIndex:'CRMOV_OBSERVACION',header:'Observacion',width:150,sortable:true},
        {dataIndex:'CRMOV_TIPO_SALIDA',header:'Tipo_salida',width:150,sortable:true,hidden:true},
        {dataIndex:'TIPO_RESIDENCIA',header:'Tipo Residencia',width:150,sortable:true},
        chkCrmov_filtro_interno
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_movilidad por un campo especifico.
     */
    var gsCgg_res_movilidad = new  Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_movilidad",
            method:"selectPageIngreso",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRMOV_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRMOV_CODIGO'},
            {name:'CTREG_CODIGO'},
            {name:'CRPER_CODIGO'},
            {name:'CTREG_CODIGO_BARRAS'},
            {name:'CRALN_CODIGO'},
            {name:'AEROLINEA'},
            {name:'CARPT_CODIGO'},
            {name:'AEROPUER_ORIGEN'},
            {name:'CGG_CARPT_CODIGO'},
            {name:'AEROPUER_DESTINO'},
            {name:'CTREG_FECHA_INGRESO'},
            {name:'CTREG_FECHA_SALIDA'},
            {name:'CRDID_CODIGO'},
            {name:'DOCUMENTO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_GENERO'},
            {name:'CRPER_FECHA_NACIMIENTO'},
            {name:'CGNCN_CODIGO'},
            {name:'NACIONALIDAD'},            
			{name:'CPAIS_CODIGO'},
            {name:'PAIS_RESIDENCIA'},
            {name:'CRTRA_CODIGO'},
            {name:'CRTRA_NUMERO'},            
			{name:'CRMOV_FECHA_VIAJE'},
            {name:'CRMOV_TIPO_OPERACION'},
            {name:'CRMOV_NUMERO_VUELO'},
            {name:'CRMOV_OBSERVACION'},
            {name:'CRMOV_TIPO_SALIDA'},
            {name:'TIPO_RESIDENCIA'},
            {name:'CTREG_ESTADO_REGISTRO'},            
			{name:'CRMOV_FILTRO_INTERNO'},
			{name:'ESTADIA'},
			{name:'EXCESO'}
        ]),
        sortInfo:{
            field: 'CRMOV_FECHA_VIAJE',
            direction: 'DESC'
        },
        baseParams:{
            keyword:"",
            format:"JSON",
            start:0,
            limit:RECORD_PAGE
        },
        groupField:'CRMOV_FECHA_VIAJE'
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_movilidad.
     */
    var pgBarCgg_res_movilidad= new Ext.PagingToolbar({
        store: gsCgg_res_movilidad,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_movilidad en un formato tabular de filas y columnas.
     */
    var grdCgg_res_movilidad = new Ext.grid.GridPanel({
        cm:cmCgg_res_movilidad,
        store:gsCgg_res_movilidad,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_movilidad,
                width:200
            })
        ],
        bbar:pgBarCgg_res_movilidad,
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        })
    });
	gsCgg_res_movilidad.reload({params:{
        start:0,
        limit:RECORD_PAGE
		}
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_movilidad.
     */
    if(inDesktop){
        var winFrmListadoCgg_res_movilidad = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_movilidad',
            title:tituloListadoCgg_res_movilidad,
            tbar:getPanelTitulo(tituloListadoCgg_res_movilidad,descListadoCgg_res_movilidad),
            items:[grdCgg_res_movilidad],
			iconCls:'iconMovilidad',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_movilidad,btnNuevoCgg_res_movilidad2,'-',btnReporteCgg_res_movilidad,btnNuevoCgg_tct_ingreso_salida,'->',btnSalirCgg_res_movilidad]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_res_movilidad.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_movilidad.
     * @returns ventana winFrmCgg_res_movilidad.
     * @base FrmListadoCgg_res_movilidad.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_movilidad;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_movilidad.
     * @base FrmListadoCgg_res_movilidad.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_movilidad.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_movilidad;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_movilidad;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_movilidad.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_movilidad.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_movilidad desde una instancia.
 */
FrmListadoCgg_res_movilidad.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_movilidad desde una instancia.
 */
FrmListadoCgg_res_movilidad.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_movilidad,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_movilidad.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_movilidad desde una instancia.
 */
FrmListadoCgg_res_movilidad.prototype.loadData = function(){
    this.loadData();
}
