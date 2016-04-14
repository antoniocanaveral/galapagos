/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_documento_identificacio.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_documento_identificacio(inDesktop){
    var optMenu = 'Configuraci\u00F3n/Administraci\u00F3n de persona/Administraci\u00F3n de documentos';
    var urlListadoCgg_res_documento_identificacio=URL_WS+"Cgg_res_documento_identificacio";
    var tituloListadoCgg_res_documento_identificacio='Listado documento identificaci\u00f3n';
    var descListadoCgg_res_documento_identificacio='El formulario permite administrar informaci\u00f3n de los tipos de documento identificaci\u00f3n';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_documento_identificacio.
     */
    var btnNuevoCgg_res_documento_identificacio = new Ext.Button({
        id:'btnNuevoCgg_res_documento_identificacio',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Nuevo registro',
        listeners:{
            click:function(){
                var objCgg_res_documento_identificacio = new FrmCgg_res_documento_identificacio("insert");
                objCgg_res_documento_identificacio.closeHandler(function(){
                    gsCgg_res_documento_identificacio.reload();
                });
                objCgg_res_documento_identificacio.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_documento_identificacio.
     */
    var btnEditarCgg_res_documento_identificacio = new Ext.Button({
        id:'btnEditarCgg_res_documento_identificacio',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:'Editar informac\u00f3n documento identificaci\u00f3n',
        listeners:{
            click:function(){
                var r=grdCgg_res_documento_identificacio.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_documento_identificacio = new FrmCgg_res_documento_identificacio("update",r);
                    objCgg_res_documento_identificacio.closeHandler(function(){
                        gsCgg_res_documento_identificacio.reload();
                    });
                    objCgg_res_documento_identificacio.loadData();
                    objCgg_res_documento_identificacio.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_documento_identificacio.
     */
    var btnEliminarCgg_res_documento_identificacio = new Ext.Button({
        id:'btnEliminarCgg_res_documento_identificacio',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:'Eliminar registro seleccionado',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_documento_identificacio,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_documento_identificacio(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_documento_identificacio(r){
                            winFrmListadoCgg_res_documento_identificacio.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_documento_identificacio,
                                    msg: 'La informaci\u00f3n de documento identificaci\u00f3n ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_documento_identificacio.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_documento_identificacio,
                                    msg: 'La informaci\u00f3n de documento identificaci\u00f3n no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_documento_identificacio.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrdid_codigo',grdCgg_res_documento_identificacio.getSelectionModel().getSelected().get('CRDID_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_documento_identificacio,"delete",param, true, CallBackCgg_res_documento_identificacio);
                    }catch(inErr){
                        winFrmListadoCgg_res_documento_identificacio.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_documento_identificacio.
     */
    var btnSalirCgg_res_documento_identificacio = new Ext.Button({
        id:'btnSalirCgg_res_documento_identificacio',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Salir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_documento_identificacio.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_documento_identificacio.
     */
    var cmCgg_res_documento_identificacio = new Ext.grid.ColumnModel([
        {dataIndex:'CRDID_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRDID_DESCRIPCION',header:'Descripcion',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_documento_identificacio por un campo especifico.
     */
    var gsCgg_res_documento_identificacio = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_documento_identificacio",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRDID_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRDID_CODIGO'},
            {name:'CRDID_DESCRIPCION'}
        ]),
        sortInfo:{field: 'CRDID_DESCRIPCION', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_documento_identificacio.
     */
    var pgBarCgg_res_documento_identificacio= new Ext.PagingToolbar({
        store: gsCgg_res_documento_identificacio,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_documento_identificacio en un formato tabular de filas y columnas.
     */
    var grdCgg_res_documento_identificacio = new Ext.grid.GridPanel({
        cm:cmCgg_res_documento_identificacio,
        store:gsCgg_res_documento_identificacio,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        viewConfig:{forceFit:true},
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_documento_identificacio,
                width:200
            })
        ],
        bbar:pgBarCgg_res_documento_identificacio,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_documento_identificacio.hidden){
                    btnEditarCgg_res_documento_identificacio.fireEvent('click', btnEditarCgg_res_documento_identificacio);
                }
            }}});
    gsCgg_res_documento_identificacio.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_documento_identificacio.
     */
    var winFrmListadoCgg_res_documento_identificacio = null;
    if(inDesktop!==null && inDesktop!==undefined){
        winFrmListadoCgg_res_documento_identificacio = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_documento_identificacio',
            title:tituloListadoCgg_res_documento_identificacio,
            tbar:getPanelTitulo(tituloListadoCgg_res_documento_identificacio,descListadoCgg_res_documento_identificacio),
            items:[grdCgg_res_documento_identificacio],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_documento_identificacio,btnEditarCgg_res_documento_identificacio,btnEliminarCgg_res_documento_identificacio,'->',btnSalirCgg_res_documento_identificacio]
        });
    }
    else
    {
        winFrmListadoCgg_res_documento_identificacio = new Ext.Window({
            id:'winFrmListadoCgg_res_documento_identificacio',
            title:tituloListadoCgg_res_documento_identificacio,
            tbar:getPanelTitulo(tituloListadoCgg_res_documento_identificacio,descListadoCgg_res_documento_identificacio),
            items:[grdCgg_res_documento_identificacio],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_documento_identificacio,btnEditarCgg_res_documento_identificacio,btnEliminarCgg_res_documento_identificacio,'->',btnSalirCgg_res_documento_identificacio]
        });
    }
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_documento_identificacio.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_documento_identificacio.
     * @returns ventana winFrmCgg_res_documento_identificacio.
     * @base FrmListadoCgg_res_documento_identificacio.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_documento_identificacio;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_documento_identificacio.
     * @base FrmListadoCgg_res_documento_identificacio.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_documento_identificacio.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_documento_identificacio;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_documento_identificacio;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_documento_identificacio.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_documento_identificacio.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_documento_identificacio desde una instancia.
 */
FrmListadoCgg_res_documento_identificacio.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_documento_identificacio desde una instancia.
 */
FrmListadoCgg_res_documento_identificacio.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_documento_identificacio,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_documento_identificacio.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_documento_identificacio desde una instancia.
 */
FrmListadoCgg_res_documento_identificacio.prototype.loadData = function(){
    this.loadData();
}
