/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_kdx_venta_detalle.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_kdx_venta_detalle(inDescktop){
    var urlListadoCgg_kdx_venta_detalle=URL_WS+"Cgg_kdx_venta_detalle";
    var tituloListadoCgg_kdx_venta_detalle='Kdx venta detalle';
    var descListadoCgg_kdx_venta_detalle='El formulario permite administrar informaci\u00f3n de la tabla Kdx venta detalle';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_kdx_venta_detalle.
     */
    var btnNuevoCgg_kdx_venta_detalle = new Ext.Button({
        id:'btnNuevoCgg_kdx_venta_detalle',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_kdx_venta_detalle = new FrmCgg_kdx_venta_detalle("insert");
                objCgg_kdx_venta_detalle.closeHandler(function(){
                    gsCgg_kdx_venta_detalle.reload();
                });
                objCgg_kdx_venta_detalle.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_kdx_venta_detalle.
     */
    var btnEditarCgg_kdx_venta_detalle = new Ext.Button({
        id:'btnEditarCgg_kdx_venta_detalle',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_kdx_venta_detalle.getSelectionModel().getSelected();
                if(r){
                    var objCgg_kdx_venta_detalle = new FrmCgg_kdx_venta_detalle("update",r);
                    objCgg_kdx_venta_detalle.closeHandler(function(){
                        gsCgg_kdx_venta_detalle.reload();
                    });
                    objCgg_kdx_venta_detalle.loadData();
                    objCgg_kdx_venta_detalle.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_kdx_venta_detalle.
     */
    var btnEliminarCgg_kdx_venta_detalle = new Ext.Button({
        id:'btnEliminarCgg_kdx_venta_detalle',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_kdx_venta_detalle,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_kdx_venta_detalle(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_kdx_venta_detalle(r){
                            winFrmListadoCgg_kdx_venta_detalle.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_venta_detalle,
                                    msg: 'La informaci\u00f3n de Kdx venta detalle ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_kdx_venta_detalle.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_venta_detalle,
                                    msg: 'La informaci\u00f3n de Kdx venta detalle no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_kdx_venta_detalle.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCkvdt_codigo',grdCgg_kdx_venta_detalle.getSelectionModel().getSelected().get('CKVDT_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_kdx_venta_detalle,"delete",param, true, CallBackCgg_kdx_venta_detalle);
                    }catch(inErr){
                        winFrmListadoCgg_kdx_venta_detalle.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_kdx_venta_detalle.
     */
    var btnSalirCgg_kdx_venta_detalle = new Ext.Button({
        id:'btnSalirCgg_kdx_venta_detalle',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_kdx_venta_detalle.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_venta_detalle.
     */
    var cmCgg_kdx_venta_detalle = new Ext.grid.ColumnModel([
        {dataIndex:'CKVDT_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CKVNT_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CKESP_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CTREG_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CKVDT_CANTIDAD',header:'Cantidad',width:150,sortable:true},
        {dataIndex:'CKVDT_SERIE',header:'Serie',width:150,sortable:true},
        {dataIndex:'CKVDT_PRECIO_UNITARIO',header:'Precio unitario',width:150,sortable:true},
        {dataIndex:'CKVDT_TOTAL',header:'Total',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_venta_detalle por un campo especifico.
     */
    var gsCgg_kdx_venta_detalle = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_venta_detalle",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKVDT_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CKVDT_CODIGO'},
            {name:'CKVNT_CODIGO'},
            {name:'CKESP_CODIGO'},
            {name:'CTREG_CODIGO'},
            {name:'CKVDT_CANTIDAD'},
            {name:'CKVDT_SERIE'},
            {name:'CKVDT_PRECIO_UNITARIO'},
            {name:'CKVDT_TOTAL'}
        ]),
        sortInfo:{field: 'CKVNT_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_kdx_venta_detalle.
     */
    var pgBarCgg_kdx_venta_detalle= new Ext.PagingToolbar({
        store: gsCgg_kdx_venta_detalle,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_venta_detalle en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_venta_detalle = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_venta_detalle,
        store:gsCgg_kdx_venta_detalle,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_kdx_venta_detalle,
                width:200
            })
        ],
        bbar:pgBarCgg_kdx_venta_detalle,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_kdx_venta_detalle.hidden){
                    btnEditarCgg_kdx_venta_detalle.fireEvent('click', btnEditarCgg_kdx_venta_detalle);
                }
            }}});
    gsCgg_kdx_venta_detalle.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_kdx_venta_detalle.
     */
    if(inDescktop){
    var winFrmListadoCgg_kdx_venta_detalle = inDescktop.createWindow({
        id:'winFrmListadoCgg_kdx_venta_detalle',
        title:tituloListadoCgg_kdx_venta_detalle,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_venta_detalle,descListadoCgg_kdx_venta_detalle),
        items:[grdCgg_kdx_venta_detalle],
        bbar:[btnNuevoCgg_kdx_venta_detalle,btnEditarCgg_kdx_venta_detalle,btnEliminarCgg_kdx_venta_detalle,'->',btnSalirCgg_kdx_venta_detalle]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_kdx_venta_detalle.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_kdx_venta_detalle.
     * @returns ventana winFrmCgg_kdx_venta_detalle.
     * @base FrmListadoCgg_kdx_venta_detalle.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_kdx_venta_detalle;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_kdx_venta_detalle.
     * @base FrmListadoCgg_kdx_venta_detalle.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_kdx_venta_detalle.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_kdx_venta_detalle;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_kdx_venta_detalle;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_kdx_venta_detalle.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_kdx_venta_detalle.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_kdx_venta_detalle desde una instancia.
 */
FrmListadoCgg_kdx_venta_detalle.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_kdx_venta_detalle desde una instancia.
 */
FrmListadoCgg_kdx_venta_detalle.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_kdx_venta_detalle,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_kdx_venta_detalle.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_kdx_venta_detalle desde una instancia.
 */
FrmListadoCgg_kdx_venta_detalle.prototype.loadData = function(){
    this.loadData();
}
