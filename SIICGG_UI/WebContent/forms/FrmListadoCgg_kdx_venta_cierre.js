/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_kdx_venta_cierre.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_kdx_venta_cierre(inDescktop){
    var urlListadoCgg_kdx_venta_cierre=URL_WS+"Cgg_kdx_venta_cierre";
    var tituloListadoCgg_kdx_venta_cierre='Kdx venta cierre';
    var descListadoCgg_kdx_venta_cierre='El formulario permite administrar informaci\u00f3n de la tabla Kdx venta cierre';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_kdx_venta_cierre.
     */
    var btnNuevoCgg_kdx_venta_cierre = new Ext.Button({
        id:'btnNuevoCgg_kdx_venta_cierre',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_kdx_venta_cierre = new FrmCgg_kdx_venta_cierre("insert");
                objCgg_kdx_venta_cierre.closeHandler(function(){
                    gsCgg_kdx_venta_cierre.reload();
                });
                objCgg_kdx_venta_cierre.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_kdx_venta_cierre.
     */
    var btnEditarCgg_kdx_venta_cierre = new Ext.Button({
        id:'btnEditarCgg_kdx_venta_cierre',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_kdx_venta_cierre.getSelectionModel().getSelected();
                if(r){
                    var objCgg_kdx_venta_cierre = new FrmCgg_kdx_venta_cierre("update",r);
                    objCgg_kdx_venta_cierre.closeHandler(function(){
                        gsCgg_kdx_venta_cierre.reload();
                    });
                    objCgg_kdx_venta_cierre.loadData();
                    objCgg_kdx_venta_cierre.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_kdx_venta_cierre.
     */
    var btnEliminarCgg_kdx_venta_cierre = new Ext.Button({
        id:'btnEliminarCgg_kdx_venta_cierre',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_kdx_venta_cierre,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_kdx_venta_cierre(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_kdx_venta_cierre(r){
                            winFrmListadoCgg_kdx_venta_cierre.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_venta_cierre,
                                    msg: 'La informaci\u00f3n de Kdx venta cierre ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_kdx_venta_cierre.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_venta_cierre,
                                    msg: 'La informaci\u00f3n de Kdx venta cierre no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_kdx_venta_cierre.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCkvtc_codigo',grdCgg_kdx_venta_cierre.getSelectionModel().getSelected().get('CKVTC_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_kdx_venta_cierre,"delete",param, true, CallBackCgg_kdx_venta_cierre);
                    }catch(inErr){
                        winFrmListadoCgg_kdx_venta_cierre.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_kdx_venta_cierre.
     */
    var btnSalirCgg_kdx_venta_cierre = new Ext.Button({
        id:'btnSalirCgg_kdx_venta_cierre',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_kdx_venta_cierre.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_venta_cierre.
     */
    var cmCgg_kdx_venta_cierre = new Ext.grid.ColumnModel([
        {dataIndex:'CKVTC_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CKVNT_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CKCRR_CODIGO',header:'Codigo',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_venta_cierre por un campo especifico.
     */
    var gsCgg_kdx_venta_cierre = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_venta_cierre",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKVTC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CKVTC_CODIGO'},
            {name:'CKVNT_CODIGO'},
            {name:'CKCRR_CODIGO'}
        ]),
        sortInfo:{field: 'CKVNT_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_kdx_venta_cierre.
     */
    var pgBarCgg_kdx_venta_cierre= new Ext.PagingToolbar({
        store: gsCgg_kdx_venta_cierre,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_venta_cierre en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_venta_cierre = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_venta_cierre,
        store:gsCgg_kdx_venta_cierre,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_kdx_venta_cierre,
                width:200
            })
        ],
        bbar:pgBarCgg_kdx_venta_cierre,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_kdx_venta_cierre.hidden){
                    btnEditarCgg_kdx_venta_cierre.fireEvent('click', btnEditarCgg_kdx_venta_cierre);
                }
            }}});
    gsCgg_kdx_venta_cierre.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_kdx_venta_cierre.
     */
    if(inDescktop){
    var winFrmListadoCgg_kdx_venta_cierre = inDescktop.createWindow({
        id:'winFrmListadoCgg_kdx_venta_cierre',
        title:tituloListadoCgg_kdx_venta_cierre,
        iconCls:'iconAplicacion',
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_venta_cierre,descListadoCgg_kdx_venta_cierre),
        items:[grdCgg_kdx_venta_cierre],
        bbar:[btnNuevoCgg_kdx_venta_cierre,btnEditarCgg_kdx_venta_cierre,btnEliminarCgg_kdx_venta_cierre,'->',btnSalirCgg_kdx_venta_cierre]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_kdx_venta_cierre.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_kdx_venta_cierre.
     * @returns ventana winFrmCgg_kdx_venta_cierre.
     * @base FrmListadoCgg_kdx_venta_cierre.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_kdx_venta_cierre;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_kdx_venta_cierre.
     * @base FrmListadoCgg_kdx_venta_cierre.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_kdx_venta_cierre.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_kdx_venta_cierre;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_kdx_venta_cierre;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_kdx_venta_cierre.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_kdx_venta_cierre.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_kdx_venta_cierre desde una instancia.
 */
FrmListadoCgg_kdx_venta_cierre.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_kdx_venta_cierre desde una instancia.
 */
FrmListadoCgg_kdx_venta_cierre.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_kdx_venta_cierre,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_kdx_venta_cierre.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_kdx_venta_cierre desde una instancia.
 */
FrmListadoCgg_kdx_venta_cierre.prototype.loadData = function(){
    this.loadData();
}
