/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_kdx_compra_detalle.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_kdx_compra_detalle(){
    var urlListadoCgg_kdx_compra_detalle=URL_WS+"Cgg_kdx_compra_detalle";
    var tituloListadoCgg_kdx_compra_detalle='Kdx compra detalle';
    var descListadoCgg_kdx_compra_detalle='El formulario permite administrar informaci\u00f3n de  Kdx compra detalle';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_kdx_compra_detalle.
     */
    var btnNuevoCgg_kdx_compra_detalle = new Ext.Button({
        id:'btnNuevoCgg_kdx_compra_detalle',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_kdx_compra_detalle = new FrmCgg_kdx_compra_detalle("insert");
                objCgg_kdx_compra_detalle.closeHandler(function(){
                    gsCgg_kdx_compra_detalle.reload();
                });
                objCgg_kdx_compra_detalle.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_kdx_compra_detalle.
     */
    var btnEditarCgg_kdx_compra_detalle = new Ext.Button({
        id:'btnEditarCgg_kdx_compra_detalle',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_kdx_compra_detalle.getSelectionModel().getSelected();
                if(r){
                    var objCgg_kdx_compra_detalle = new FrmCgg_kdx_compra_detalle("update",r);
                    objCgg_kdx_compra_detalle.closeHandler(function(){
                        gsCgg_kdx_compra_detalle.reload();
                    });
                    objCgg_kdx_compra_detalle.loadData();
                    objCgg_kdx_compra_detalle.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_kdx_compra_detalle.
     */
    var btnEliminarCgg_kdx_compra_detalle = new Ext.Button({
        id:'btnEliminarCgg_kdx_compra_detalle',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_kdx_compra_detalle,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_kdx_compra_detalle(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_kdx_compra_detalle(r){
                            winFrmListadoCgg_kdx_compra_detalle.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_compra_detalle,
                                    msg: 'La informaci\u00f3n de Kdx compra detalle ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_kdx_compra_detalle.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_compra_detalle,
                                    msg: 'La informaci\u00f3n de Kdx compra detalle no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_kdx_compra_detalle.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCkcmd_codigo',grdCgg_kdx_compra_detalle.getSelectionModel().getSelected().get('CKCMD_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_kdx_compra_detalle,"delete",param, true, CallBackCgg_kdx_compra_detalle);
                    }catch(inErr){
                        winFrmListadoCgg_kdx_compra_detalle.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_kdx_compra_detalle.
     */
    var btnSalirCgg_kdx_compra_detalle = new Ext.Button({
        id:'btnSalirCgg_kdx_compra_detalle',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_kdx_compra_detalle.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_compra_detalle.
     */
    var cmCgg_kdx_compra_detalle = new Ext.grid.ColumnModel([
        {dataIndex:'CKCMD_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CKCMP_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CKTES_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CKCMD_CANTIDAD',header:'Cantidad',width:150,sortable:true},
        {dataIndex:'CKCMD_PRECIO_UNITARIO',header:'Precio unitario',width:150,sortable:true},
        {dataIndex:'CKCMD_TOTAL',header:'Total',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_compra_detalle por un campo especifico.
     */
    var gsCgg_kdx_compra_detalle = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_compra_detalle",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKCMD_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CKCMD_CODIGO'},
            {name:'CKCMP_CODIGO'},
            {name:'CKTES_CODIGO'},
            {name:'CKCMD_CANTIDAD'},
            {name:'CKCMD_PRECIO_UNITARIO'},
            {name:'CKCMD_TOTAL'}
        ]),
        sortInfo:{field: 'CKCMP_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_kdx_compra_detalle.
     */
    var pgBarCgg_kdx_compra_detalle= new Ext.PagingToolbar({
        store: gsCgg_kdx_compra_detalle,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_compra_detalle en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_compra_detalle = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_compra_detalle,
        store:gsCgg_kdx_compra_detalle,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_kdx_compra_detalle,
                width:200
            })
        ],
        bbar:pgBarCgg_kdx_compra_detalle,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_kdx_compra_detalle.hidden){
                    btnEditarCgg_kdx_compra_detalle.fireEvent('click', btnEditarCgg_kdx_compra_detalle);
                }
            }}});
    gsCgg_kdx_compra_detalle.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_kdx_compra_detalle.
     */
    var winFrmListadoCgg_kdx_compra_detalle = new Ext.Window({
        id:'winFrmListadoCgg_kdx_compra_detalle',
        title:tituloListadoCgg_kdx_compra_detalle,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_compra_detalle,descListadoCgg_kdx_compra_detalle),
        items:[grdCgg_kdx_compra_detalle],
        bbar:[btnNuevoCgg_kdx_compra_detalle,btnEditarCgg_kdx_compra_detalle,btnEliminarCgg_kdx_compra_detalle,'->',btnSalirCgg_kdx_compra_detalle]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_kdx_compra_detalle.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_kdx_compra_detalle.
     * @returns ventana winFrmCgg_kdx_compra_detalle.
     * @base FrmListadoCgg_kdx_compra_detalle.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_kdx_compra_detalle;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_kdx_compra_detalle.
     * @base FrmListadoCgg_kdx_compra_detalle.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_kdx_compra_detalle.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_kdx_compra_detalle;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_kdx_compra_detalle;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_kdx_compra_detalle.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_kdx_compra_detalle.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_kdx_compra_detalle desde una instancia.
 */
FrmListadoCgg_kdx_compra_detalle.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_kdx_compra_detalle desde una instancia.
 */
FrmListadoCgg_kdx_compra_detalle.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_kdx_compra_detalle,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_kdx_compra_detalle.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_kdx_compra_detalle desde una instancia.
 */
FrmListadoCgg_kdx_compra_detalle.prototype.loadData = function(){
    this.loadData();
}
