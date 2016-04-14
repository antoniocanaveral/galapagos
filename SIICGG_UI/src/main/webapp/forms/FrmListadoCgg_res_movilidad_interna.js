/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_movilidad_interna.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_movilidad_interna(inDescktop){
    var optMenu = 'Movilidad interna/Movilidad Interna';
    var urlListadoCgg_res_movilidad_interna=URL_WS+"Cgg_res_movilidad_interna";
    var tituloListadoCgg_res_movilidad_interna='Listado de desplazamiento interno entre islas';
    var descListadoCgg_res_movilidad_interna='El formulario permite administrar informaci\u00f3n de movilidad interna';
	var tmpUserSession = new UserSession();
	
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
	 * Ext.data.Store Almacenamiento de informacion de embarcaciones.
	 */
	var tmpStoreEmbarcacion= new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_res_embarcacion",
			method:"selectAll"
		}),
		reader:new Ext.data.JsonReader({},[
			{name:'CREMB_CODIGO'},
			{name:'CREMB_NOMBRE'}
		]),
		baseParams:{
			format:TypeFormat.JSON
		}
	});
	tmpStoreEmbarcacion.load();
	
	/**
	 * Ext.data.Store Almacenamiento de informacion de aerolinea.
	 */
	var tmpStoreAerolinea= new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_res_aerolinea",
			method:"selectAll"
		}),
		reader:new Ext.data.JsonReader({},[
			{name:'CRALN_CODIGO'},
			{name:'CRALN_NOMBRE'},
			{name:'CRALN_TIPO_AEROLINEA'}
		]),
		baseParams:{
			format:TypeFormat.JSON
		},
		listeners:{
			load:function(inStore, inRecords, inOptions){
				for(i = 0; i < inRecords.length; i++)
					if(inRecords[i].data.CRALN_TIPO_AEROLINEA == 0)
						inStore.remove(inRecords[i]);
				inStore.sort('CRALN_NOMBRE', 'ASC');
			}
		}
	});
	tmpStoreAerolinea.load();
	
    /**
     * Ext.Button Boton que permite  registrar la salida de una persona.
     */
    var btnNuevoCgg_res_movilidad_interna_Salida = new Ext.Button({
        id:'btnNuevoCgg_res_movilidad_interna_Salida',
        text:'Registro salida',
        tooltip:'Registro salida isla',
        iconCls:'bogus',
        listeners:{
            click:function(){
                var objCgg_res_movilidad_interna = new FrmCgg_res_movilidad_interna("insert");
				objCgg_res_movilidad_interna.setUserSession(tmpUserSession);
				objCgg_res_movilidad_interna.setStoreAerolinea(tmpStoreAerolinea);
				objCgg_res_movilidad_interna.setStoreEmbarcacion(tmpStoreEmbarcacion);
				objCgg_res_movilidad_interna.setStoreHospedaje(gsCgg_tct_tipo_hospedaje);
				objCgg_res_movilidad_interna.setStoreActividad(gsCgg_tct_actividad);
                objCgg_res_movilidad_interna.closeHandler(function(){
                    gsCgg_res_movilidad_interna.reload();
                });
                objCgg_res_movilidad_interna.show();
            }}
    });
    /**
     * Ext.Button Boton que permite  registrar ingreso de una persona.
     */
    var btnNuevoCgg_res_movilidad_interna_Ingreso = new Ext.Button({
        id:'btnNuevoCgg_res_movilidad_interna_Ingreso',
        text:'Registro ingreso',
        tooltip:'Registro ingreso a la isla',
        iconCls:'bogus',
       listeners:{
            click:function(){
                var objCgg_res_movilidad_interna_ingreso = new FrmCgg_res_movilidad_interna_ingreso("insert");
				objCgg_res_movilidad_interna_ingreso.setUserSession(tmpUserSession);
				objCgg_res_movilidad_interna_ingreso.setStoreAerolinea(tmpStoreAerolinea);
				objCgg_res_movilidad_interna_ingreso.setStoreEmbarcacion(tmpStoreEmbarcacion);
				objCgg_res_movilidad_interna_ingreso.setStoreHospedaje(gsCgg_tct_tipo_hospedaje);
				objCgg_res_movilidad_interna_ingreso.setStoreActividad(gsCgg_tct_actividad);
                objCgg_res_movilidad_interna_ingreso.closeHandler(function(){
                    gsCgg_res_movilidad_interna.reload();
                });
                objCgg_res_movilidad_interna_ingreso.show();
            }}
    });

    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_movilidad_interna.
     */
    var btnSalirCgg_res_movilidad_interna = new Ext.Button({
        id:'btnSalirCgg_res_movilidad_interna',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_res_movilidad_interna.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_movilidad_interna.
     */
    var cmCgg_res_movilidad_interna = new Ext.grid.ColumnModel([
        {dataIndex:'CRMLE_NOMBRE',header:'Muelle origen',width:150,sortable:true},
        {dataIndex:'CGG_CRMLE_NOMBRE',header:'Muelle destino',width:150,sortable:true},
        {dataIndex:'CREMB_NOMBRE',header:'Embarcaci\u00f3n',width:150,sortable:true},
        {dataIndex:'CRPER_NOMBRE',header:'Nombre persona',width:150,sortable:true},
        {dataIndex:'CRMOV_CODIGO',hidden:true,header:'Codigo',width:150,sortable:true},
        {dataIndex:'CARPT_NOMBRE',header:'Aeropuerto origen',width:150,sortable:true},
        {dataIndex:'CARPT_NOMBRE_DESTINO',header:'Arepuerto destino',width:150,sortable:true},
        {dataIndex:'CRALN_NOMBRE',header:'Aerlinea',width:100,sortable:true},
        {dataIndex:'CRALN_DESCRIPCION_VUELO',header:'Descripcion vuelo',width:150,sortable:true},
        {dataIndex:'CRMVI_FECHA_VIAJE',header:'Fecha viaje',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CRMVI_TIPO_OPERACION',hidden:true,header:'Operaci\u00f3n',width:70,sortable:true},
        {dataIndex:'CRMVI_OBSERVACION',header:'Observacion',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_movilidad_interna por un campo especifico.
     */
    var gsCgg_res_movilidad_interna = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_movilidad_interna",
            method:"selectMovilidadInternaPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRMVI_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRMVI_CODIGO'},
            {name:'CRMLE_CODIGO'},
            {name:'CRMLE_NOMBRE'},
            {name:'CGG_CRMLE_CODIGO'},
            {name:'CGG_CRMLE_NOMBRE'},
            {name:'CREMB_CODIGO'},
            {name:'CREMB_NOMBRE'},
            {name:'CRPER_NOMBRE'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_NUMERO_RESIDENCIA'},
            {name:'CARPT_CODIGO'},
            {name:'CARPT_NOMBRE'},
            {name:'CGG_CARPT_CODIGO'},
            {name:'CARPT_NOMBRE_DESTINO'},
            {name:'CRALN_CODIGO'},
            {name:'CRALN_NOMBRE'},
            {name:'CRALN_DESCRIPCION_VUELO'},
            {name:'CRMVI_FECHA_VIAJE'},
            {name:'CRMVI_TIPO_OPERACION'},
            {name:'CRMVI_OBSERVACION'}
        ]),
        sortInfo:{field: 'CRMLE_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'},
        groupField:'CRMVI_FECHA_VIAJE'
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_movilidad_interna.
     */
    var pgBarCgg_res_movilidad_interna= new Ext.PagingToolbar({
        store: gsCgg_res_movilidad_interna,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_movilidad_interna en un formato tabular de filas y columnas.
     */
    var grdCgg_res_movilidad_interna = new Ext.grid.GridPanel({
        cm:cmCgg_res_movilidad_interna,
        store:gsCgg_res_movilidad_interna,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_movilidad_interna,
                width:200
            })
        ],
        bbar:pgBarCgg_res_movilidad_interna,
        view: new Ext.grid.GroupingView({
                    groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Vuelos" : "Vuelo"]})'
                })});
    gsCgg_res_movilidad_interna.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_movilidad_interna.
     */
    if(inDescktop){
    var winFrmListadoCgg_res_movilidad_interna = inDescktop.createWindow({
        id:'winFrmListadoCgg_res_movilidad_interna',
        title:tituloListadoCgg_res_movilidad_interna,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo(tituloListadoCgg_res_movilidad_interna,descListadoCgg_res_movilidad_interna),
        items:[grdCgg_res_movilidad_interna],
        bbar:[btnNuevoCgg_res_movilidad_interna_Salida,btnNuevoCgg_res_movilidad_interna_Ingreso,'->',btnSalirCgg_res_movilidad_interna]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_movilidad_interna.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_movilidad_interna.
     * @returns ventana winFrmCgg_res_movilidad_interna.
     * @base FrmListadoCgg_res_movilidad_interna.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_movilidad_interna;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_movilidad_interna.
     * @base FrmListadoCgg_res_movilidad_interna.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_movilidad_interna.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_movilidad_interna;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_movilidad_interna;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_movilidad_interna.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_movilidad_interna.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_movilidad_interna desde una instancia.
 */
FrmListadoCgg_res_movilidad_interna.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_movilidad_interna desde una instancia.
 */
FrmListadoCgg_res_movilidad_interna.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_movilidad_interna,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_movilidad_interna.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_movilidad_interna desde una instancia.
 */
FrmListadoCgg_res_movilidad_interna.prototype.loadData = function(){
    this.loadData();
}
