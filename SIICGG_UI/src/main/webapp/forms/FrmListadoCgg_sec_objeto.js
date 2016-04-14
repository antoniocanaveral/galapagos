/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_sec_objeto.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_sec_objeto(inDesktop){
    var optMenu = 'Seguridad/Objetos';
    var urlListadoCgg_sec_objeto=URL_WS+"Cgg_sec_objeto";
    var tituloListadoCgg_sec_objeto='Listado de objetos del sistema';
    var descListadoCgg_sec_objeto='El formulario permite visualizar la informaci\u00f3n de los objetos.';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_sec_objeto.
     */
    var btnNuevoCgg_sec_objeto = new Ext.Button({
        id:'btnNuevoCgg_sec_objeto',
        text:'Actualizar',
        iconCls:'iconRecargar',
        listeners:{
            click:function(){
                var tmpTimeout = Ext.Ajax.timeout;
                Ext.Ajax.timeout = 90000;
                if(tbTiposObjetos.getActiveTab() == grdCgg_sec_objeto){
                    grdCgg_sec_objeto.getEl().mask('Actualizando ...', 'x-mask-loading');
                    Ext.Ajax.request({
                        url: 'ListarObjetos',
                        success: function(r){
                            Ext.Ajax.timeout = tmpTimeout;
                            grdCgg_sec_objeto.getEl().unmask();
                            Ext.Msg.show({
                                title:tituloListadoCgg_sec_objeto,
                                msg: 'Se ha actualizado el listado de objetos exitosamente.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            gsCgg_sec_objeto.reload();
                        },
                        failure: function(r){
                            Ext.Ajax.timeout = tmpTimeout;
                            grdCgg_sec_objeto.getEl().unmask();
                            Ext.Msg.show({
                                title:tituloListadoCgg_sec_objeto,
                                msg: 'No se ha actualizado el listado de objetos exitosamente.'+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        },
                        params: { request: 'fill' }
                    });
                }else{
                    grdWSObjetos.getEl().mask('Actualizando ...', 'x-mask-loading');
                    Ext.Ajax.request({
                        url: URL_WS+'ListarObjetos',
                        success: function(r){
                            grdWSObjetos.getEl().unmask();
                            Ext.Msg.show({
                                title:tituloListadoCgg_sec_objeto,
                                msg: 'Se ha actualizado el listado de objetos exitosamente.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            gsWSObjetos.reload();
                        },
                        failure: function(r){
                            grdWSObjetos.getEl().unmask();
                            Ext.Msg.show({
                                title:tituloListadoCgg_sec_objeto,
                                msg: 'No se ha actualizado el listado de objetos exitosamente.'+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        },
                        params: { request: 'fill' }
                    });

                }
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_sec_objeto.
     */
    var btnSalirCgg_sec_objeto = new Ext.Button({
        id:'btnSalirCgg_sec_objeto',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_sec_objeto.close();
            }}
    });
    /**
     * Ext.Button Boton que permite registras las dependencias de los objetos del sistema.
     */
    var btnDepCgg_sec_objeto = new Ext.Button({
        id:'btnDepCgg_sec_objeto',
        text:'Dependencias',
        iconCls:'iconDep',
        listeners:{
            click:function(){
                var r;
                if(tbTiposObjetos.getActiveTab() == grdCgg_sec_objeto)
                    r = grdCgg_sec_objeto.getSelectionModel().getSelected();
                else
                    r = grdWSObjetos.getSelectionModel().getSelected();
                if(r){
                    var tmpDependencia = new FrmListadoCgg_sec_obj_dependencia(inDesktop, r, (tbTiposObjetos.getActiveTab() == grdCgg_sec_objeto?0:1));
                    tmpDependencia.show();
                }
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sec_objeto.
     */
    var cmCgg_sec_objeto = new Ext.grid.ColumnModel([
        {dataIndex:'CSOBJ_NOMBRE',header:'Nombre',width:200,sortable:true},
        {dataIndex:'CSOBJ_RUTA',header:'Ruta',width:150,sortable:true,hidden:true},
        {dataIndex:'CSOBJ_DESCRIPCION',header:'Descripci\u00f3n',width:350,sortable:true},
        {dataIndex:'DEPENDENCIAS',header:'Depen.',width:80,sortable:true}
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_sec_objeto por un campo especifico.
     */
    var gsCgg_sec_objeto = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_sec_objeto",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        groupField:'CSOBJ_RUTA',
        reader:new Ext.data.JsonReader({
            id:'CSOBJ_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CSOBJ_CODIGO'},
            {name:'CSOBJ_NOMBRE'},
            {name:'CSOBJ_RUTA'},
            {name:'CSOBJ_DESCRIPCION'},
            {name:'DEPENDENCIAS'}
        ]),
        sortInfo:{field: 'CSOBJ_RUTA', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON',inTypeObject:'0',inCsrol_codigo:''}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sec_objeto.
     */
    var cmWSObjetos = new Ext.grid.ColumnModel([
        {dataIndex:'CSOBJ_NOMBRE',header:'Nombre',width:200,sortable:true},
        {dataIndex:'CSOBJ_RUTA',header:'Ruta',width:150,sortable:true,hidden:true},
        {dataIndex:'CSOBJ_DESCRIPCION',header:'Descripci\u00f3n',width:350,sortable:true},
        {dataIndex:'DEPENDENCIAS',header:'Depen.',width:80,sortable:true}
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_sec_objeto por un campo especifico.
     */
    var gsWSObjetos = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_sec_objeto",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        groupField:'CSOBJ_RUTA',
        reader:new Ext.data.JsonReader({
            id:'CSOBJ_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CSOBJ_CODIGO'},
            {name:'CSOBJ_NOMBRE'},
            {name:'CSOBJ_RUTA'},
            {name:'CSOBJ_DESCRIPCION'},
            {name:'DEPENDENCIAS'}
        ]),
        sortInfo:{field: 'CSOBJ_RUTA', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON',inTypeObject:'1',inCsrol_codigo:''}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_sec_objeto.
     */
    var pgBarCgg_sec_objeto= new Ext.PagingToolbar({
        store: gsCgg_sec_objeto,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_sec_objeto.
     */
    var pgBarWSObjetos= new Ext.PagingToolbar({
        store: gsWSObjetos,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sec_objeto en un formato tabular de filas y columnas.
     */
    var grdCgg_sec_objeto = new Ext.grid.GridPanel({
        title:'Interface visual',
        cm:cmCgg_sec_objeto,
        store:gsCgg_sec_objeto,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_sec_objeto,
                width:200
            })
        ],
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        bbar:pgBarCgg_sec_objeto
    });
    gsCgg_sec_objeto.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sec_objeto en un formato tabular de filas y columnas.
     */
    var grdWSObjetos = new Ext.grid.GridPanel({
        title:'Servicios web',
        cm:cmWSObjetos,
        store:gsWSObjetos,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsWSObjetos,
                width:200
            })
        ],
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        bbar:pgBarWSObjetos
    });
    gsWSObjetos.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    var tbTiposObjetos = new Ext.TabPanel({
        activeTab:0,
        region:'center',
        items:[grdCgg_sec_objeto,grdWSObjetos]
    });
    if(inDesktop){
        /**
         * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_sec_objeto.
         */
        var winFrmListadoCgg_sec_objeto = inDesktop.createWindow({
            id:'winFrmListadoCgg_sec_objeto',
            title:tituloListadoCgg_sec_objeto,
            width:680,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo(tituloListadoCgg_sec_objeto,descListadoCgg_sec_objeto),
            items:[tbTiposObjetos],
            bbar:[btnNuevoCgg_sec_objeto,'-',btnDepCgg_sec_objeto,'->',btnSalirCgg_sec_objeto]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_sec_objeto.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_sec_objeto.
     * @returns ventana winFrmCgg_sec_objeto.
     * @base FrmListadoCgg_sec_objeto.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_sec_objeto;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_sec_objeto.
     * @base FrmListadoCgg_sec_objeto.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_sec_objeto.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_sec_objeto;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_sec_objeto;
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getWSColumnModel = function(){
        return cmWSObjetos;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getWSStore = function(){
        return gsWSObjetos;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_sec_objeto.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_sec_objeto.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_sec_objeto.prototype.getWSColumnModel = function(){
    this.getWSColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_sec_objeto.prototype.getWSStore = function(){
    this.getWSStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_sec_objeto desde una instancia.
 */
FrmListadoCgg_sec_objeto.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_sec_objeto desde una instancia.
 */
FrmListadoCgg_sec_objeto.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_sec_objeto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_sec_objeto.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_sec_objeto desde una instancia.
 */
FrmListadoCgg_sec_objeto.prototype.loadData = function(){
    this.loadData();
}
