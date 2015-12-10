/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_movilidad.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_movilidad_residentes(inDesktop){
    var optMenu = 'Movilidad/Movimiento Residentes';
    var urlListadoCgg_res_movilidad=URL_WS+"Cgg_res_movilidad";
    var tituloListadoCgg_res_movilidad='Registro de Ingreso de Residentes a la Provincia';
    var descListadoCgg_res_movilidad='El formulario permite administrar la informaci\u00f3n del Registro de Ingreso de Residentes a la Provincia';
	var tmpUserSession = new UserSession();
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_movilidad_residentes.
     */
    var btnNuevoCgg_res_movilidad3 = new Ext.Button({
        id:'btnNuevoCgg_res_movilidad3',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_movilidad = new FrmCgg_res_movilidad_residentes("insert");
				objCgg_res_movilidad.setUserSession(tmpUserSession);
                objCgg_res_movilidad.closeHandler(function(){
                    gsCgg_res_movilidad_residentes3.reload();
                });
                objCgg_res_movilidad.show();
            }}
    });
	/**
     * Ext.Button Boton que permite exportar datos residentes.
     */
    var btnExportableResidentes = new Ext.Button({
        id:'btnExportableResidentes',
        text:'Exportable aerolinea',
        iconCls:'iconDescargar',
        listeners:{
            click:function(){
                var exportableResidencia = new DlgExportableResidencia();
			    exportableResidencia.show();
            }}
    });

    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_movilidad_residentes.
     */
    var btnSalirCgg_res_movilidad3 = new Ext.Button({
        id:'btnSalirCgg_res_movilidad3',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_movilidad_residentes.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_movilidad.
     */
    var cmCgg_res_movilidad_residentes3 = new Ext.grid.ColumnModel([
        {dataIndex:'DOCUMENTO',header:'Tipo Documnento',width:100,sortable:true},
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'No. documento',width:100,sortable:true},
        {dataIndex:'CRPER_NUMERO_RESIDENCIA',header:'Carnet',width:60,sortable:true},
        {dataIndex:'CRPER_NOMBRES',header:'Nombres',width:150,sortable:true},
        {dataIndex:'CRPER_APELLIDO_PATERNO',header:'Apellido',width:150,sortable:true},
        {dataIndex:'CRPER_GENERO',header:'Genero',width:50,sortable:true,renderer:function(inCrper_genero){
            return dsGeneroPersona[inCrper_genero][1];
        }},
        {dataIndex:'NACIONALIDAD',header:'Nacionalidad',width:150,sortable:true},
        {dataIndex:'AEROLINEA',header:'Aerolinea',width:100,sortable:true},
        {dataIndex:'AEROPUER_ORIGEN',header:'Aeropuerto partida',width:150,sortable:true},
        {dataIndex:'AEROPUER_DESTINO',header:'Aeropuerto arribo',width:150,sortable:true},
        {dataIndex:'CRMOV_FECHA_VIAJE',header:'Fecha viaje',width:100,sortable:true,renderer:truncDate},
        {dataIndex:'CRMOV_TIPO_OPERACION',header:'Operaci\u00f3n',width:70,sortable:true, renderer:function(inCrmov_tipo_operacion){
            return dsTipoOperacion[inCrmov_tipo_operacion][1];
		}},
        {dataIndex:'CRMOV_NUMERO_VUELO',header:'Vuelo',width:80,sortable:true},
        {dataIndex:'CRMOV_OBSERVACION',header:'Observacion',width:150,sortable:true},
        {dataIndex:'CRMOV_TIPO_SALIDA',header:'Tipo_salida',width:150,sortable:true,hidden:true},
        {dataIndex:'TIPO_RESIDENCIA',header:'Residencia',width:150,sortable:true}

    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_movilidad por un campo especifico.
     */
    var gsCgg_res_movilidad_residentes3 = new  Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_movilidad",
            method:"selectPageResidentesIngreso",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRMOV_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRMOV_CODIGO'},
            {name:'CRPER_CODIGO'},
            {name:'CRDID_CODIGO'},
            {name:'DOCUMENTO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_NUMERO_RESIDENCIA'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_GENERO'},
            {name:'CRPER_FECHA_NACIMIENTO'},
            {name:'CGNCN_CODIGO'},
            {name:'NACIONALIDAD'},
            {name:'CRALN_CODIGO'},
            {name:'AEROLINEA'},
            {name:'CARPT_CODIGO'},
            {name:'AEROPUER_ORIGEN'},
            {name:'CGG_CARPT_CODIGO'},
            {name:'AEROPUER_DESTINO'},
            {name:'CRMOV_FECHA_VIAJE'},
            {name:'CRMOV_FECHA_INSERT'},
            {name:'CRMOV_TIPO_OPERACION'},
            {name:'CRMOV_NUMERO_VUELO'},
            {name:'CRMOV_OBSERVACION'},
            {name:'CRMOV_TIPO_SALIDA'},
            {name:'TIPO_RESIDENCIA'}
        ]),
        baseParams:{keyword:"",format:"JSON"},
        groupField:'CRMOV_FECHA_VIAJE',
        sortInfo: {
            field: 'CRMOV_FECHA_VIAJE',
            direction: 'DESC'
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_movilidad.
     */
    var pgBarCgg_res_movilidad_residentes3= new Ext.PagingToolbar({
        store: gsCgg_res_movilidad_residentes3,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_movilidad en un formato tabular de filas y columnas.
     */
    var grdCgg_res_movilidad_residentes3 = new Ext.grid.GridPanel({
        cm:cmCgg_res_movilidad_residentes3,
        store:gsCgg_res_movilidad_residentes3,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_movilidad_residentes3,
                width:200
            })
        ],
        bbar:pgBarCgg_res_movilidad_residentes3,
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        })
    });
    gsCgg_res_movilidad_residentes3.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_movilidad.
     */
    if(inDesktop){
        var winFrmListadoCgg_res_movilidad_residentes = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_movilidad_residentes',
            title:tituloListadoCgg_res_movilidad,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_movilidad,descListadoCgg_res_movilidad),
            items:[grdCgg_res_movilidad_residentes3],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_movilidad3,btnExportableResidentes,'->',btnSalirCgg_res_movilidad3]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_res_movilidad_residentes.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_movilidad_residentes.
     * @returns ventana winFrmCgg_res_movilidad.
     * @base FrmListadoCgg_res_movilidad_residentes.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_movilidad_residentes;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_movilidad_residentes.
     * @base FrmListadoCgg_res_movilidad_residentes.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_movilidad_residentes3.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_movilidad_residentes3;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_movilidad_residentes3;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_movilidad_residentes.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_movilidad_residentes.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_movilidad_residentes desde una instancia.
 */
FrmListadoCgg_res_movilidad_residentes.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_movilidad_residentes desde una instancia.
 */
FrmListadoCgg_res_movilidad_residentes.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_movilidad_residentes,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_movilidad_residentes.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_movilidad_residentes desde una instancia.
 */
FrmListadoCgg_res_movilidad_residentes.prototype.loadData = function(){
    this.loadData();
}

