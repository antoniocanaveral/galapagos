/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_kdx_transferencia.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_kdx_transferencia_pv(inDescktop){
    var optMenu = 'Kardex/Consulta/Transferencias por punto de venta';
    var urlListadoCgg_kdx_transferencia_pv=URL_WS+"Cgg_kdx_transferencia";
    var tituloListadoCgg_kdx_transferencia_pv='Transferencia punto de venta';
    var descListadoCgg_kdx_transferencia_pv='El formulario permite administrar informaci\u00f3n de la tranferencia punto de venta';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_kdx_transferencia_pv.
     */
    var btnNuevoCgg_kdx_transferencia_pv = new Ext.Button({
        id:'btnNuevoCgg_kdx_transferencia_pv',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_kdx_transferencia = new FrmCgg_kdx_transferencia("insert");
                objCgg_kdx_transferencia.closeHandler(function(){
                    gsCgg_kdx_transferencia_pv.reload();
                });
                objCgg_kdx_transferencia.loadData();
                objCgg_kdx_transferencia.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_kdx_transferencia_pv.
     */
    var btnEditarCgg_kdx_transferencia_pv = new Ext.Button({
        id:'btnEditarCgg_kdx_transferencia_pv',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_kdx_transferencia_pv.getSelectionModel().getSelected();
                if(r){
                    var objCgg_kdx_transferencia = new FrmCgg_kdx_transferencia("update",r);
                    objCgg_kdx_transferencia.closeHandler(function(){
                        gsCgg_kdx_transferencia_pv.reload();
                    });
                    objCgg_kdx_transferencia.loadData();
                    objCgg_kdx_transferencia.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_kdx_transferencia_pv.
     */
    var btnEliminarCgg_kdx_transferencia_pv = new Ext.Button({
        id:'btnEliminarCgg_kdx_transferencia_pv',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMIAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_kdx_transferencia_pv,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_kdx_transferencia_pv(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_kdx_transferencia_pv(r){
                            winFrmListadoCgg_kdx_transferencia_pv.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_transferencia_pv,
                                    msg: 'La informaci\u00f3n de Kdx transferencia ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_kdx_transferencia_pv.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_transferencia_pv,
                                    msg: 'La informaci\u00f3n de Kdx transferencia no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_kdx_transferencia_pv.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCktrn_codigo',grdCgg_kdx_transferencia_pv.getSelectionModel().getSelected().get('CKTRN_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_kdx_transferencia_pv,"delete",param, true, CallBackCgg_kdx_transferencia_pv);
                    }catch(inErr){
                        winFrmListadoCgg_kdx_transferencia_pv.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_kdx_transferencia_pv.
     */
    var btnSalirCgg_kdx_transferencia_pv = new Ext.Button({
        id:'btnSalirCgg_kdx_transferencia_pv',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_kdx_transferencia_pv.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto Cgg_kdx_transferencia_pv.
     */
    var cmCgg_kdx_transferencia_pv = new Ext.grid.ColumnModel([
        {dataIndex:'CKTRN_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKPVT_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true},
        {dataIndex:'CKPVT_NOMBRE',header:'Punto de Venta',width:150,sortable:true,hidden:true},
        {dataIndex:'CKESP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKESP_NOMBRE',header:'Especie',width:150,sortable:true},
        {dataIndex:'CKTRN_NUMERO_TRANSFERENCIA',header:'Numero transferencia',width:150,sortable:true},
        {dataIndex:'CKTRN_FECHA_RECEPCION',header:'Fecha recepci\u00f3n',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CKTRN_CANTIDAD',header:'Cantidad',width:150,sortable:true},
        {dataIndex:'CKTRN_PRECIO_UNITARIO',header:'Precio unitario',width:150,sortable:true},
        {dataIndex:'CKTRN_CANTIDAD_DISPONIBLE',header:'Cantidad Disponible',width:150,sortable:true},
        {dataIndex:'CKTRN_SERIE_INICIO',header:'Serie inicio',width:150,sortable:true},
        {dataIndex:'CKTRN_SERIE_FIN',header:'Serie fin',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_transferencia_pv por un campo especifico.
     */
    var gsCgg_kdx_transferencia_pv = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_transferencia",
            method:"selectPageByPuntoVenta",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKTRN_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CKTRN_CODIGO'},
            {name:'CKPVT_CODIGO'},
            {name:'CKPVT_NOMBRE'},
            {name:'CKESP_CODIGO'},
            {name:'CKESP_NOMBRE'},
            {name:'CKTRN_NUMERO_TRANSFERENCIA'},
            {name:'CKTRN_FECHA_RECEPCION'},
            {name:'CKTRN_CANTIDAD'},
            {name:'CKTRN_PRECIO_UNITARIO'},
            {name:'CKTRN_CANTIDAD_DISPONIBLE'},    
            {name:'CKTRN_SERIE_INICIO'},
            {name:'CKTRN_SERIE_FIN'}
        ]),
        sortInfo:{field: 'CKTRN_FECHA_RECEPCION', direction: 'DESC'},
        baseParams:{keyword:"",format:'JSON'},
        groupField: 'CKESP_NOMBRE'
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_kdx_transferencia.
     */
    var pgBarCgg_kdx_transferencia_pv= new Ext.PagingToolbar({
        store: gsCgg_kdx_transferencia_pv,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_transferencia en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_transferencia_pv = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_transferencia_pv,
        store:gsCgg_kdx_transferencia_pv,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_kdx_transferencia_pv,
                width:200
            })
        ],
        bbar:pgBarCgg_kdx_transferencia_pv,
        view: new Ext.grid.GroupingView({
            forceFit: true,
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Transferencias" : "Transferencia"]})'
        }),
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_kdx_transferencia_pv.hidden){
                    btnEditarCgg_kdx_transferencia_pv.fireEvent('click', btnEditarCgg_kdx_transferencia_pv);
                }
            }}});
    gsCgg_kdx_transferencia_pv.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_kdx_transferencia.
     */
    if(inDescktop){
    var winFrmListadoCgg_kdx_transferencia_pv = inDescktop.createWindow({
        id:'winFrmListadoCgg_kdx_transferencia_pv',
        title:tituloListadoCgg_kdx_transferencia_pv,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_transferencia_pv,descListadoCgg_kdx_transferencia_pv),
        items:[grdCgg_kdx_transferencia_pv],
        bbar:['->',btnSalirCgg_kdx_transferencia_pv]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_kdx_transferencia_pv.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_kdx_transferencia_pv.
     * @returns ventana winFrmCgg_kdx_transferencia_pv.
     * @base FrmListadoCgg_kdx_transferencia_pv.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_kdx_transferencia_pv;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_kdx_transferencia_pv.
     * @base FrmListadoCgg_kdx_transferencia_pv.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_kdx_transferencia_pv.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_kdx_transferencia_pv;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_kdx_transferencia_pv;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_kdx_transferencia_pv.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_kdx_transferencia_pv.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_kdx_transferencia_pv desde una instancia.
 */
FrmListadoCgg_kdx_transferencia_pv.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_kdx_transferencia_pv desde una instancia.
 */
FrmListadoCgg_kdx_transferencia_pv.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_kdx_transferencia_pv,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_kdx_transferencia_pv.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_kdx_transferencia_pv desde una instancia.
 */
FrmListadoCgg_kdx_transferencia_pv.prototype.loadData = function(){
    this.loadData();
}
