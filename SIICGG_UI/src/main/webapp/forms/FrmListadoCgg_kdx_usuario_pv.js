/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_kdx_usuario_pv.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_kdx_usuario_pv(){
    var urlListadoCgg_kdx_usuario_pv=URL_WS+"Cgg_kdx_usuario_pv";
    var tituloListadoCgg_kdx_usuario_pv='Kdx usuario pv';
    var descListadoCgg_kdx_usuario_pv='El formulario permite administrar informaci\u00f3n de la tabla Kdx usuario pv';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_kdx_usuario_pv.
     */
    var btnNuevoCgg_kdx_usuario_pv = new Ext.Button({
        id:'btnNuevoCgg_kdx_usuario_pv',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_kdx_usuario_pv = new FrmCgg_kdx_usuario_pv("insert");
                objCgg_kdx_usuario_pv.closeHandler(function(){
                    gsCgg_kdx_usuario_pv.reload();
                });
                objCgg_kdx_usuario_pv.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_kdx_usuario_pv.
     */
    var btnEditarCgg_kdx_usuario_pv = new Ext.Button({
        id:'btnEditarCgg_kdx_usuario_pv',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_kdx_usuario_pv.getSelectionModel().getSelected();
                if(r){
                    var objCgg_kdx_usuario_pv = new FrmCgg_kdx_usuario_pv("update",r);
                    objCgg_kdx_usuario_pv.closeHandler(function(){
                        gsCgg_kdx_usuario_pv.reload();
                    });
                    objCgg_kdx_usuario_pv.loadData();
                    objCgg_kdx_usuario_pv.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_kdx_usuario_pv.
     */
    var btnEliminarCgg_kdx_usuario_pv = new Ext.Button({
        id:'btnEliminarCgg_kdx_usuario_pv',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_kdx_usuario_pv,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_kdx_usuario_pv(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_kdx_usuario_pv(r){
                            winFrmListadoCgg_kdx_usuario_pv.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_usuario_pv,
                                    msg: 'La informaci\u00f3n de Kdx usuario pv ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_kdx_usuario_pv.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_usuario_pv,
                                    msg: 'La informaci\u00f3n de Kdx usuario pv no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_kdx_usuario_pv.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCkupv_codigo',grdCgg_kdx_usuario_pv.getSelectionModel().getSelected().get('CKUPV_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_kdx_usuario_pv,"delete",param, true, CallBackCgg_kdx_usuario_pv);
                    }catch(inErr){
                        winFrmListadoCgg_kdx_usuario_pv.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_kdx_usuario_pv.
     */
    var btnSalirCgg_kdx_usuario_pv = new Ext.Button({
        id:'btnSalirCgg_kdx_usuario_pv',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_kdx_usuario_pv.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_usuario_pv.
     */
    var chkCkpvt_activo = new Ext.grid.CheckColumn(
    {dataIndex:'CKPVT_ACTIVO',header:'Activo',width:150,sortable:true});
    var cmCgg_kdx_usuario_pv = new Ext.grid.ColumnModel([
        {dataIndex:'CKUPV_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CKPVT_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CUSU_CODIGO',header:'Codigo',width:150,sortable:true},
        chkCkpvt_activo]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_usuario_pv por un campo especifico.
     */
    var gsCgg_kdx_usuario_pv = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_usuario_pv",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKUPV_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CKUPV_CODIGO'},
            {name:'CKPVT_CODIGO'},
            {name:'CUSU_CODIGO'},
            {name:'CKPVT_ACTIVO'}
        ]),
        sortInfo:{field: 'CKPVT_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_kdx_usuario_pv.
     */
    var pgBarCgg_kdx_usuario_pv= new Ext.PagingToolbar({
        store: gsCgg_kdx_usuario_pv,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_usuario_pv en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_usuario_pv = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_usuario_pv,
        store:gsCgg_kdx_usuario_pv,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_kdx_usuario_pv,
                width:200
            })
        ],
        bbar:pgBarCgg_kdx_usuario_pv,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_kdx_usuario_pv.hidden){
                    btnEditarCgg_kdx_usuario_pv.fireEvent('click', btnEditarCgg_kdx_usuario_pv);
                }
            }}});
    gsCgg_kdx_usuario_pv.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_kdx_usuario_pv.
     */
    var winFrmListadoCgg_kdx_usuario_pv = new Ext.Window({
        id:'winFrmListadoCgg_kdx_usuario_pv',
        title:tituloListadoCgg_kdx_usuario_pv,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_usuario_pv,descListadoCgg_kdx_usuario_pv),
        items:[grdCgg_kdx_usuario_pv],
        bbar:[btnNuevoCgg_kdx_usuario_pv,btnEditarCgg_kdx_usuario_pv,btnEliminarCgg_kdx_usuario_pv,'->',btnSalirCgg_kdx_usuario_pv]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_kdx_usuario_pv.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_kdx_usuario_pv.
     * @returns ventana winFrmCgg_kdx_usuario_pv.
     * @base FrmListadoCgg_kdx_usuario_pv.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_kdx_usuario_pv;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_kdx_usuario_pv.
     * @base FrmListadoCgg_kdx_usuario_pv.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_kdx_usuario_pv.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_kdx_usuario_pv;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_kdx_usuario_pv;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_kdx_usuario_pv.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_kdx_usuario_pv.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_kdx_usuario_pv desde una instancia.
 */
FrmListadoCgg_kdx_usuario_pv.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_kdx_usuario_pv desde una instancia.
 */
FrmListadoCgg_kdx_usuario_pv.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_kdx_usuario_pv,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_kdx_usuario_pv.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_kdx_usuario_pv desde una instancia.
 */
FrmListadoCgg_kdx_usuario_pv.prototype.loadData = function(){
    this.loadData();
}
