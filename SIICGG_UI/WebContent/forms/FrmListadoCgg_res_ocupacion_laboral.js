/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_ocupacion_laboral.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_ocupacion_laboral(){
    var urlListadoCgg_res_ocupacion_laboral=URL_WS+"Cgg_res_ocupacion_laboral";
    var tituloListadoCgg_res_ocupacion_laboral='Listado Res ocupacion laboral';
    var descListadoCgg_res_ocupacion_laboral='El formulario permite administrar informaci\u00f3n de la tabla Res ocupacion laboral';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_ocupacion_laboral.
     */
    var btnNuevoCgg_res_ocupacion_laboral = new Ext.Button({
        id:'btnNuevoCgg_res_ocupacion_laboral',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_ocupacion_laboral = new FrmCgg_res_ocupacion_laboral("insert");
                objCgg_res_ocupacion_laboral.closeHandler(function(){
                    gsCgg_res_ocupacion_laboral.reload();
                });
                objCgg_res_ocupacion_laboral.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_ocupacion_laboral.
     */
    var btnEditarCgg_res_ocupacion_laboral = new Ext.Button({
        id:'btnEditarCgg_res_ocupacion_laboral',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_ocupacion_laboral.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_ocupacion_laboral = new FrmCgg_res_ocupacion_laboral("update",r);
                    objCgg_res_ocupacion_laboral.closeHandler(function(){
                        gsCgg_res_ocupacion_laboral.reload();
                    });
                    objCgg_res_ocupacion_laboral.loadData();
                    objCgg_res_ocupacion_laboral.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_ocupacion_laboral.
     */
    var btnEliminarCgg_res_ocupacion_laboral = new Ext.Button({
        id:'btnEliminarCgg_res_ocupacion_laboral',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_ocupacion_laboral,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_ocupacion_laboral(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_ocupacion_laboral(r){
                            winFrmListadoCgg_res_ocupacion_laboral.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_ocupacion_laboral,
                                    msg: 'La informaci\u00f3n de Res ocupacion laboral ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_ocupacion_laboral.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_ocupacion_laboral,
                                    msg: 'La informaci\u00f3n de Cgg_res_ocupacion_laboral no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_ocupacion_laboral.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrocl_codigo',grdCgg_res_ocupacion_laboral.getSelectionModel().getSelected().get('CROCL_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_ocupacion_laboral,"delete",param, true, CallBackCgg_res_ocupacion_laboral);
                    }catch(inErr){
                        winFrmListadoCgg_res_ocupacion_laboral.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_ocupacion_laboral.
     */
    var btnSalirCgg_res_ocupacion_laboral = new Ext.Button({
        id:'btnSalirCgg_res_ocupacion_laboral',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_ocupacion_laboral.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_ocupacion_laboral.
     */
    var cmCgg_res_ocupacion_laboral = new Ext.grid.ColumnModel([
        {dataIndex:'CROCL_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CGG_CRPER_CODIGO',header:'Crper codigo',width:150,sortable:true},
        {dataIndex:'CGCRG_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CSCTP_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRPJR_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CROCL_TIPO',header:'Tipo',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_ocupacion_laboral por un campo especifico.
     */
    var gsCgg_res_ocupacion_laboral = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_ocupacion_laboral",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CROCL_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CROCL_CODIGO'},
            {name:'CRPER_CODIGO'},
            {name:'CGG_CRPER_CODIGO'},
            {name:'CGCRG_CODIGO'},
            {name:'CSCTP_CODIGO'},
            {name:'CRPJR_CODIGO'},
            {name:'CROCL_TIPO'}
        ]),
        sortInfo:{field: 'CRPER_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_ocupacion_laboral.
     */
    var pgBarCgg_res_ocupacion_laboral= new Ext.PagingToolbar({
        store: gsCgg_res_ocupacion_laboral,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_ocupacion_laboral en un formato tabular de filas y columnas.
     */
    var grdCgg_res_ocupacion_laboral = new Ext.grid.GridPanel({
        cm:cmCgg_res_ocupacion_laboral,
        store:gsCgg_res_ocupacion_laboral,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_ocupacion_laboral,
                width:200
            })
        ],
        bbar:pgBarCgg_res_ocupacion_laboral,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_ocupacion_laboral.hidden){
                    btnEditarCgg_res_ocupacion_laboral.fireEvent('click', btnEditarCgg_res_ocupacion_laboral);
                }
            }}});
    gsCgg_res_ocupacion_laboral.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_ocupacion_laboral.
     */
    var winFrmListadoCgg_res_ocupacion_laboral = new Ext.Window({
        id:'winFrmListadoCgg_res_ocupacion_laboral',
        title:tituloListadoCgg_res_ocupacion_laboral,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_ocupacion_laboral,descListadoCgg_res_ocupacion_laboral),
        items:[grdCgg_res_ocupacion_laboral],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_res_ocupacion_laboral,btnEditarCgg_res_ocupacion_laboral,btnEliminarCgg_res_ocupacion_laboral,'->',btnSalirCgg_res_ocupacion_laboral]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_ocupacion_laboral.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_ocupacion_laboral.
     * @returns ventana winFrmCgg_res_ocupacion_laboral.
     * @base FrmListadoCgg_res_ocupacion_laboral.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_ocupacion_laboral;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_ocupacion_laboral.
     * @base FrmListadoCgg_res_ocupacion_laboral.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_ocupacion_laboral.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_ocupacion_laboral;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_ocupacion_laboral;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_ocupacion_laboral.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_ocupacion_laboral.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_ocupacion_laboral desde una instancia.
 */
FrmListadoCgg_res_ocupacion_laboral.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_ocupacion_laboral desde una instancia.
 */
FrmListadoCgg_res_ocupacion_laboral.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_ocupacion_laboral,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_ocupacion_laboral.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_ocupacion_laboral desde una instancia.
 */
FrmListadoCgg_res_ocupacion_laboral.prototype.loadData = function(){
    this.loadData();
}
