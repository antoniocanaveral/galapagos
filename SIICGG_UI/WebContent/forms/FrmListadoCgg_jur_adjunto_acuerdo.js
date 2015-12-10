/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_jur_adjunto_acuerdo.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_jur_adjunto_acuerdo(){
    var urlListadoCgg_jur_adjunto_acuerdo=URL_WS+"Cgg_jur_adjunto_acuerdo";
    var tituloListadoCgg_jur_adjunto_acuerdo='Jur adjunto acuerdo';
    var descListadoCgg_jur_adjunto_acuerdo='El formulario permite administrar informaci\u00f3n de la tabla Jur adjunto acuerdo';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_jur_adjunto_acuerdo.
     */
    var btnNuevoCgg_jur_adjunto_acuerdo = new Ext.Button({
        id:'btnNuevoCgg_jur_adjunto_acuerdo',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_jur_adjunto_acuerdo = new FrmCgg_jur_adjunto_acuerdo("insert");
                objCgg_jur_adjunto_acuerdo.closeHandler(function(){
                    gsCgg_jur_adjunto_acuerdo.reload();
                });
                objCgg_jur_adjunto_acuerdo.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_jur_adjunto_acuerdo.
     */
    var btnEditarCgg_jur_adjunto_acuerdo = new Ext.Button({
        id:'btnEditarCgg_jur_adjunto_acuerdo',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_jur_adjunto_acuerdo.getSelectionModel().getSelected();
                if(r){
                    var objCgg_jur_adjunto_acuerdo = new FrmCgg_jur_adjunto_acuerdo("update",r);
                    objCgg_jur_adjunto_acuerdo.closeHandler(function(){
                        gsCgg_jur_adjunto_acuerdo.reload();
                    });
                    objCgg_jur_adjunto_acuerdo.loadData();
                    objCgg_jur_adjunto_acuerdo.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_jur_adjunto_acuerdo.
     */
    var btnEliminarCgg_jur_adjunto_acuerdo = new Ext.Button({
        id:'btnEliminarCgg_jur_adjunto_acuerdo',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_jur_adjunto_acuerdo,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_jur_adjunto_acuerdo(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_jur_adjunto_acuerdo(r){
                            winFrmListadoCgg_jur_adjunto_acuerdo.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_jur_adjunto_acuerdo,
                                    msg: 'La informaci\u00f3n de Jur adjunto acuerdo ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_jur_adjunto_acuerdo.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_jur_adjunto_acuerdo,
                                    msg: 'La informaci\u00f3n de Jur adjunto acuerdo no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_jur_adjunto_acuerdo.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCjada_codigo',grdCgg_jur_adjunto_acuerdo.getSelectionModel().getSelected().get('CJADA_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_jur_adjunto_acuerdo,"delete",param, true, CallBackCgg_jur_adjunto_acuerdo);
                    }catch(inErr){
                        winFrmListadoCgg_jur_adjunto_acuerdo.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_jur_adjunto_acuerdo.
     */
    var btnSalirCgg_jur_adjunto_acuerdo = new Ext.Button({
        id:'btnSalirCgg_jur_adjunto_acuerdo',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_jur_adjunto_acuerdo.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_jur_adjunto_acuerdo.
     */
    var cmCgg_jur_adjunto_acuerdo = new Ext.grid.ColumnModel([
        {dataIndex:'CJADA_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CJACU_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CJADA_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
        {dataIndex:'CJADA_NOMBRE_ADJUNTO',header:'Nombre adjunto',width:150,sortable:true},
        {dataIndex:'CJADA_ADJUNTO',header:'Adjunto',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_jur_adjunto_acuerdo por un campo especifico.
     */
    var gsCgg_jur_adjunto_acuerdo = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_adjunto_acuerdo",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CJADA_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CJADA_CODIGO'},
            {name:'CJACU_CODIGO'},
            {name:'CJADA_DESCRIPCION'},
            {name:'CJADA_NOMBRE_ADJUNTO'},
            {name:'CJADA_ADJUNTO'}
        ]),
        sortInfo:{field: 'CJACU_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_jur_adjunto_acuerdo.
     */
    var pgBarCgg_jur_adjunto_acuerdo= new Ext.PagingToolbar({
        store: gsCgg_jur_adjunto_acuerdo,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_jur_adjunto_acuerdo en un formato tabular de filas y columnas.
     */
    var grdCgg_jur_adjunto_acuerdo = new Ext.grid.GridPanel({
        cm:cmCgg_jur_adjunto_acuerdo,
        store:gsCgg_jur_adjunto_acuerdo,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_jur_adjunto_acuerdo,
                width:200
            })
        ],
        bbar:pgBarCgg_jur_adjunto_acuerdo,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_jur_adjunto_acuerdo.hidden){
                    btnEditarCgg_jur_adjunto_acuerdo.fireEvent('click', btnEditarCgg_jur_adjunto_acuerdo);
                }
            }}});
    gsCgg_jur_adjunto_acuerdo.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_jur_adjunto_acuerdo.
     */
    var winFrmListadoCgg_jur_adjunto_acuerdo = new Ext.Window({
        id:'winFrmListadoCgg_jur_adjunto_acuerdo',
        title:tituloListadoCgg_jur_adjunto_acuerdo,
        iconCls:'iconAplicacion',
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_jur_adjunto_acuerdo,descListadoCgg_jur_adjunto_acuerdo),
        items:[grdCgg_jur_adjunto_acuerdo],
        bbar:[btnNuevoCgg_jur_adjunto_acuerdo,btnEditarCgg_jur_adjunto_acuerdo,btnEliminarCgg_jur_adjunto_acuerdo,'->',btnSalirCgg_jur_adjunto_acuerdo]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_jur_adjunto_acuerdo.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_jur_adjunto_acuerdo.
     * @returns ventana winFrmCgg_jur_adjunto_acuerdo.
     * @base FrmListadoCgg_jur_adjunto_acuerdo.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_jur_adjunto_acuerdo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_jur_adjunto_acuerdo.
     * @base FrmListadoCgg_jur_adjunto_acuerdo.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_jur_adjunto_acuerdo.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_jur_adjunto_acuerdo;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_jur_adjunto_acuerdo;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_jur_adjunto_acuerdo.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_jur_adjunto_acuerdo.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_jur_adjunto_acuerdo desde una instancia.
 */
FrmListadoCgg_jur_adjunto_acuerdo.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_jur_adjunto_acuerdo desde una instancia.
 */
FrmListadoCgg_jur_adjunto_acuerdo.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_jur_adjunto_acuerdo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_jur_adjunto_acuerdo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_jur_adjunto_acuerdo desde una instancia.
 */
FrmListadoCgg_jur_adjunto_acuerdo.prototype.loadData = function(){
    this.loadData();
}
