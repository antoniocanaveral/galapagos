/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_oficial_seguimiento.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_oficial_seguimiento_usuario(){
    var urlListadoCgg_res_oficial_seguimiento_usuario=URL_WS+"Cgg_res_oficial_seguimiento_usuario";
    var tituloListadoCgg_res_oficial_seguimiento_usuario='Listado Res oficial seguimiento';
    var descListadoCgg_res_oficial_seguimiento_usuario='El formulario permite administrar informaci\u00f3n de la tabla Res oficial seguimiento';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_oficial_seguimiento_usuario.
     */
    var btnNuevoCgg_res_oficial_seguimiento_usuario = new Ext.Button({
        id:'btnNuevoCgg_res_oficial_seguimiento_usuario',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_oficial_seguimiento_usuario = new FrmCgg_res_oficial_seguimiento_usuario("insert");

                objCgg_res_oficial_seguimiento_usuario.closeHandler(function(){
                    gsCgg_res_oficial_seguimiento_usuario.reload();
                });
                objCgg_res_oficial_seguimiento_usuario.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_oficial_seguimiento_usuario.
     */
    var btnEditarCgg_res_oficial_seguimiento_usuario = new Ext.Button({
        id:'btnEditarCgg_res_oficial_seguimiento_usuario',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_oficial_seguimiento_usuario.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_oficial_seguimiento_usuario = new FrmCgg_res_oficial_seguimiento_usuario("update",r);
                    objCgg_res_oficial_seguimiento_usuario.closeHandler(function(){
                        gsCgg_res_oficial_seguimiento_usuario.reload();
                    });
                    objCgg_res_oficial_seguimiento_usuario.loadData();
                    objCgg_res_oficial_seguimiento_usuario.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_oficial_seguimiento_usuario.
     */
    var btnEliminarCgg_res_oficial_seguimiento_usuario = new Ext.Button({
        id:'btnEliminarCgg_res_oficial_seguimiento_usuario',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_oficial_seguimiento_usuario,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_oficial_seguimiento_usuario(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_oficial_seguimiento_usuario(r){
                            winFrmListadoCgg_res_oficial_seguimiento_usuario.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_oficial_seguimiento_usuario,
                                    msg: 'La informaci\u00f3n de Res oficial seguimiento ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_oficial_seguimiento_usuario.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_oficial_seguimiento_usuario,
                                    msg: 'La informaci\u00f3n de Cgg_res_oficial_seguimiento_usuario no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_oficial_seguimiento_usuario.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrosg_codigo',grdCgg_res_oficial_seguimiento_usuario.getSelectionModel().getSelected().get('CROSG_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_oficial_seguimiento_usuario,"delete",param, true, CallBackCgg_res_oficial_seguimiento_usuario);
                    }catch(inErr){
                        winFrmListadoCgg_res_oficial_seguimiento_usuario.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_oficial_seguimiento_usuario.
     */
    var btnSalirCgg_res_oficial_seguimiento_usuario = new Ext.Button({
        id:'btnSalirCgg_res_oficial_seguimiento_usuario',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_oficial_seguimiento_usuario.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto Cgg_res_oficial_seguimiento_usuario.
     */
    var cmCgg_res_oficial_seguimiento_usuario = new Ext.grid.ColumnModel([
        {dataIndex:'CROSG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CUSU_CODIGO',header:'Usuario',width:150,sortable:true,hidden:true},
        {dataIndex:'CUSU_NOMBRES',header:'Nombres',width:150,sortable:true},
        {dataIndex:'CUSU_APELLIDOS',header:'Apellidos',width:150,sortable:true}
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_oficial_seguimiento_usuario por un campo especifico.
     */
    var gsCgg_res_oficial_seguimiento_usuario = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_oficial_seguimiento_usuario",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CROSG_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CROSG_CODIGO'},
            {name:'CUSU_CODIGO'},
            {name:'CUSU_NOMBRES'},
            {name:'CUSU_APELLIDOS'}
        ]),
        sortInfo:{field: 'CUSU_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_oficial_seguimiento_usuario.
     */
    var pgBarCgg_res_oficial_seguimiento_usuario= new Ext.PagingToolbar({
        store: gsCgg_res_oficial_seguimiento_usuario,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_oficial_seguimiento_usuario en un formato tabular de filas y columnas.
     */
    var grdCgg_res_oficial_seguimiento_usuario = new Ext.grid.GridPanel({
        cm:cmCgg_res_oficial_seguimiento_usuario,
        store:gsCgg_res_oficial_seguimiento_usuario,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_oficial_seguimiento_usuario,
                width:200
            })
        ],
        bbar:pgBarCgg_res_oficial_seguimiento_usuario,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_oficial_seguimiento_usuario.hidden){
                    btnEditarCgg_res_oficial_seguimiento_usuario.fireEvent('click', btnEditarCgg_res_oficial_seguimiento_usuario);
                }
            }}});
    gsCgg_res_oficial_seguimiento_usuario.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_oficial_seguimiento_usuario.
     */
    var winFrmListadoCgg_res_oficial_seguimiento_usuario = new Ext.Window({
        id:'winFrmListadoCgg_res_oficial_seguimiento_usuario',
        title:tituloListadoCgg_res_oficial_seguimiento_usuario,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_oficial_seguimiento_usuario,descListadoCgg_res_oficial_seguimiento_usuario),
        items:[grdCgg_res_oficial_seguimiento_usuario],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_res_oficial_seguimiento_usuario,btnEditarCgg_res_oficial_seguimiento_usuario,btnEliminarCgg_res_oficial_seguimiento_usuario,'->',btnSalirCgg_res_oficial_seguimiento_usuario]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_oficial_seguimiento_usuario.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_oficial_seguimiento_usuario.
     * @returns ventana winFrmCgg_res_oficial_seguimiento_usuario.
     * @base FrmListadoCgg_res_oficial_seguimiento_usuario.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_oficial_seguimiento_usuario;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_oficial_seguimiento_usuario.
     * @base FrmListadoCgg_res_oficial_seguimiento_usuario.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_oficial_seguimiento_usuario.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_oficial_seguimiento_usuario;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_oficial_seguimiento_usuario;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_oficial_seguimiento_usuario.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_oficial_seguimiento_usuario.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_oficial_seguimiento_usuario desde una instancia.
 */
FrmListadoCgg_res_oficial_seguimiento_usuario.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_oficial_seguimiento_usuario desde una instancia.
 */
FrmListadoCgg_res_oficial_seguimiento_usuario.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_oficial_seguimiento_usuario,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_oficial_seguimiento_usuario.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_oficial_seguimiento_usuario desde una instancia.
 */
FrmListadoCgg_res_oficial_seguimiento_usuario.prototype.loadData = function(){
    this.loadData();
}
