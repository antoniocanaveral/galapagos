/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_estado_civil.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_estado_civil(inDesktop){
    var optMenu = 'Configuraci\u00F3n/Administraci\u00F3n de persona/Administraci\u00F3n de estado civil';
    var urlListadoCgg_res_estado_civil=URL_WS+"Cgg_res_estado_civil";
    var tituloListadoCgg_res_estado_civil=' Listado estado civil';
    var descListadoCgg_res_estado_civil='El formulario permite administrar informaci\u00f3n de tipos de estado civil';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_estado_civil.
     */
    var btnNuevoCgg_res_estado_civil = new Ext.Button({
        id:'btnNuevoCgg_res_estado_civil',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Nuevo registro',
        listeners:{
            click:function(){
                var objCgg_res_estado_civil = new FrmCgg_res_estado_civil("insert");
                objCgg_res_estado_civil.closeHandler(function(){
                    gsCgg_res_estado_civil.reload();
                });
                objCgg_res_estado_civil.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_estado_civil.
     */
    var btnEditarCgg_res_estado_civil = new Ext.Button({
        id:'btnEditarCgg_res_estado_civil',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:'Editar informaci\u00f3n estado civil',
        listeners:{
            click:function(){
                var r=grdCgg_res_estado_civil.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_estado_civil = new FrmCgg_res_estado_civil("update",r);
                    objCgg_res_estado_civil.closeHandler(function(){
                        gsCgg_res_estado_civil.reload();
                    });
                    objCgg_res_estado_civil.loadData();
                    objCgg_res_estado_civil.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_estado_civil.
     */
    var btnEliminarCgg_res_estado_civil = new Ext.Button({
        id:'btnEliminarCgg_res_estado_civil',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:'Eliminar registro seleccionado',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_estado_civil,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_estado_civil(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_estado_civil(r){
                            winFrmListadoCgg_res_estado_civil.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_estado_civil,
                                    msg: 'La informaci\u00f3n de  estado civil ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_estado_civil.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_estado_civil,
                                    msg: 'La informaci\u00f3n de estado civil no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_estado_civil.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrecv_codigo',grdCgg_res_estado_civil.getSelectionModel().getSelected().get('CRECV_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_estado_civil,"delete",param, true, CallBackCgg_res_estado_civil);
                    }catch(inErr){
                        winFrmListadoCgg_res_estado_civil.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_estado_civil.
     */
    var btnSalirCgg_res_estado_civil = new Ext.Button({
        id:'btnSalirCgg_res_estado_civil',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Salir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_estado_civil.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_estado_civil.
     */
    var cmCgg_res_estado_civil = new Ext.grid.ColumnModel([
        {dataIndex:'CRECV_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRECV_DESCRPCION',header:'Descrpcion',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_estado_civil por un campo especifico.
     */
    var gsCgg_res_estado_civil = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_estado_civil",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRECV_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRECV_CODIGO'},
            {name:'CRECV_DESCRPCION'}
        ]),
        sortInfo:{field: 'CRECV_DESCRPCION', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_estado_civil.
     */
    var pgBarCgg_res_estado_civil= new Ext.PagingToolbar({
        store: gsCgg_res_estado_civil,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_estado_civil en un formato tabular de filas y columnas.
     */
    var grdCgg_res_estado_civil = new Ext.grid.GridPanel({
        cm:cmCgg_res_estado_civil,
        store:gsCgg_res_estado_civil,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        viewConfig:{forceFit:true},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_estado_civil,
                width:200
            })
        ],
        bbar:pgBarCgg_res_estado_civil,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_estado_civil.hidden){
                    btnEditarCgg_res_estado_civil.fireEvent('click', btnEditarCgg_res_estado_civil);
                }
            }}});
    gsCgg_res_estado_civil.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_estado_civil.
     */
    var winFrmListadoCgg_res_estado_civil = null;
    if(inDesktop!==null && inDesktop!==undefined){
        winFrmListadoCgg_res_estado_civil = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_estado_civil',
            title:tituloListadoCgg_res_estado_civil,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_estado_civil,descListadoCgg_res_estado_civil),
            items:[grdCgg_res_estado_civil],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_estado_civil,btnEditarCgg_res_estado_civil,btnEliminarCgg_res_estado_civil,'->',btnSalirCgg_res_estado_civil]
        });
    }
    else
    {
        winFrmListadoCgg_res_estado_civil = new Ext.Window({
            id:'winFrmListadoCgg_res_estado_civil',
            title:tituloListadoCgg_res_estado_civil,
            tbar:getPanelTitulo(tituloListadoCgg_res_estado_civil,descListadoCgg_res_estado_civil),
            items:[grdCgg_res_estado_civil],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_estado_civil,btnEditarCgg_res_estado_civil,btnEliminarCgg_res_estado_civil,'->',btnSalirCgg_res_estado_civil]
    });
    }

    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_estado_civil.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_estado_civil.
     * @returns ventana winFrmCgg_res_estado_civil.
     * @base FrmListadoCgg_res_estado_civil.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_estado_civil;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_estado_civil.
     * @base FrmListadoCgg_res_estado_civil.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_estado_civil.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_estado_civil;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_estado_civil;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_estado_civil.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_estado_civil.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_estado_civil desde una instancia.
 */
FrmListadoCgg_res_estado_civil.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_estado_civil desde una instancia.
 */
FrmListadoCgg_res_estado_civil.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_estado_civil,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_estado_civil.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_estado_civil desde una instancia.
 */
FrmListadoCgg_res_estado_civil.prototype.loadData = function(){
    this.loadData();
}
