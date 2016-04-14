/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_kdx_tipo_pago.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_kdx_tipo_pago(inDesktop){
    var optMenu = 'Kardex/Configurac\u00f3n/Tipo de pago';
    var urlListadoCgg_kdx_tipo_pago=URL_WS+"Cgg_kdx_tipo_pago";
    var tituloListadoCgg_kdx_tipo_pago='Tipo pago';
    var descListadoCgg_kdx_tipo_pago='El formulario permite administrar informaci\u00f3n del Tipo de pago';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_kdx_tipo_pago.
     */
    var btnNuevoCgg_kdx_tipo_pago = new Ext.Button({
        id:'btnNuevoCgg_kdx_tipo_pago',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_kdx_tipo_pago = new FrmCgg_kdx_tipo_pago("insert");
                objCgg_kdx_tipo_pago.closeHandler(function(){
                    gsCgg_kdx_tipo_pago.reload();
                });
                objCgg_kdx_tipo_pago.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_kdx_tipo_pago.
     */
    var btnEditarCgg_kdx_tipo_pago = new Ext.Button({
        id:'btnEditarCgg_kdx_tipo_pago',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_kdx_tipo_pago.getSelectionModel().getSelected();
                if(r){
                    var objCgg_kdx_tipo_pago = new FrmCgg_kdx_tipo_pago("update",r);
                    objCgg_kdx_tipo_pago.closeHandler(function(){
                        gsCgg_kdx_tipo_pago.reload();
                    });
                    objCgg_kdx_tipo_pago.loadData();
                    objCgg_kdx_tipo_pago.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_kdx_tipo_pago.
     */
    var btnEliminarCgg_kdx_tipo_pago = new Ext.Button({
        id:'btnEliminarCgg_kdx_tipo_pago',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_kdx_tipo_pago,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_kdx_tipo_pago(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_kdx_tipo_pago(r){
                            winFrmListadoCgg_kdx_tipo_pago.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_tipo_pago,
                                    msg: 'La informaci\u00f3n de Tipo pago ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_kdx_tipo_pago.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_tipo_pago,
                                    msg: 'La informaci\u00f3n de Tipo pago no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_kdx_tipo_pago.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCktpg_codigo',grdCgg_kdx_tipo_pago.getSelectionModel().getSelected().get('CKTPG_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_kdx_tipo_pago,"delete",param, true, CallBackCgg_kdx_tipo_pago);
                    }catch(inErr){
                        winFrmListadoCgg_kdx_tipo_pago.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_kdx_tipo_pago.
     */
    var btnSalirCgg_kdx_tipo_pago = new Ext.Button({
        id:'btnSalirCgg_kdx_tipo_pago',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_kdx_tipo_pago.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_tipo_pago.
     */
    var cmCgg_kdx_tipo_pago = new Ext.grid.ColumnModel([
        {dataIndex:'CKTPG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKTPG_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
        {dataIndex:'CKTPG_OBSERVACION',header:'Observacion',width:200,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_tipo_pago por un campo especifico.
     */
    var gsCgg_kdx_tipo_pago = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_tipo_pago",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKTPG_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CKTPG_CODIGO'},
            {name:'CKTPG_DESCRIPCION'},
            {name:'CKTPG_OBSERVACION'}
        ]),
        sortInfo:{field: 'CKTPG_DESCRIPCION', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_kdx_tipo_pago.
     */
    var pgBarCgg_kdx_tipo_pago= new Ext.PagingToolbar({
        store: gsCgg_kdx_tipo_pago,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_tipo_pago en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_tipo_pago = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_tipo_pago,
        store:gsCgg_kdx_tipo_pago,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        viewConfig:{forceFit:true},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_kdx_tipo_pago,
                width:200
            })
        ],
        bbar:pgBarCgg_kdx_tipo_pago,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_kdx_tipo_pago.hidden){
                    btnEditarCgg_kdx_tipo_pago.fireEvent('click', btnEditarCgg_kdx_tipo_pago);
                }
            }}});
    gsCgg_kdx_tipo_pago.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_kdx_tipo_pago.
     */
    var winFrmListadoCgg_kdx_tipo_pago = null;
    if(inDesktop!==null && inDesktop!==undefined){
        winFrmListadoCgg_kdx_tipo_pago = inDesktop.createWindow({
            id:'winFrmListadoCgg_kdx_tipo_pago',
            title:tituloListadoCgg_kdx_tipo_pago,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_tipo_pago,descListadoCgg_kdx_tipo_pago),
            items:[grdCgg_kdx_tipo_pago],
            bbar:[btnNuevoCgg_kdx_tipo_pago,btnEditarCgg_kdx_tipo_pago,btnEliminarCgg_kdx_tipo_pago,'->',btnSalirCgg_kdx_tipo_pago]
        });
    }
    else
    {
        winFrmListadoCgg_kdx_tipo_pago = new Ext.Window({
            id:'winFrmListadoCgg_kdx_tipo_pago',
            title:tituloListadoCgg_kdx_tipo_pago,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_tipo_pago,descListadoCgg_kdx_tipo_pago),
            items:[grdCgg_kdx_tipo_pago],
            bbar:[btnNuevoCgg_kdx_tipo_pago,btnEditarCgg_kdx_tipo_pago,btnEliminarCgg_kdx_tipo_pago,'->',btnSalirCgg_kdx_tipo_pago]
        });
    }


/**
 * Funcion que aplica los privilegios del usuario.
 */
applyGrants(winFrmListadoCgg_kdx_tipo_pago.getBottomToolbar());
/**
 * Funcion miembro que devuelve la ventana winFrmListadoCgg_kdx_tipo_pago.
 * @returns ventana winFrmCgg_kdx_tipo_pago.
 * @base FrmListadoCgg_kdx_tipo_pago.prototype.show
 */
this.getWindow = function(){
    return winFrmListadoCgg_kdx_tipo_pago;
}
/**
 * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_kdx_tipo_pago.
 * @base FrmListadoCgg_kdx_tipo_pago.prototype.loadData
 */
this.loadData = function(){
    gsCgg_kdx_tipo_pago.load();
}
/**
 * Funcion miembro que develve el ColumnModel utilizado en el listado.
 */
this.getColumnModel = function(){
    return cmCgg_kdx_tipo_pago;
}
/**
 * Funcion miembro que develve el Store utilizado en el listado.
 */
this.getStore = function(){
    return gsCgg_kdx_tipo_pago;
}
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_kdx_tipo_pago.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_kdx_tipo_pago.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_kdx_tipo_pago desde una instancia.
 */
FrmListadoCgg_kdx_tipo_pago.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_kdx_tipo_pago desde una instancia.
 */
FrmListadoCgg_kdx_tipo_pago.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_kdx_tipo_pago,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_kdx_tipo_pago.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_kdx_tipo_pago desde una instancia.
 */
FrmListadoCgg_kdx_tipo_pago.prototype.loadData = function(){
    this.loadData();
}
