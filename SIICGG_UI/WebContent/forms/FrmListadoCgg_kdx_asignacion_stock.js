/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_kdx_asignacion.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_kdx_asignacion_stock(inDescktop){
    var optMenu = 'Kardex/Consulta/Stock de asignaciones';
    var urlListadoCgg_kdx_asignacion=URL_WS+"Cgg_kdx_asignacion";
    var tituloListadoCgg_kdx_asignacion='Stock de especies en punto de venta';
    var descListadoCgg_kdx_asignacion='El formulario permite administrar informaci\u00f3n de Stock de especies en punto de venta';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_kdx_asignacion_stock.
     */
    var btnNuevoCgg_kdx_asignacion = new Ext.Button({
        id:'btnNuevoCgg_kdx_asignacion',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        menu:[
            {
                text:'Desde PV',
                listeners:{
                    click:function(){
                        var objCgg_kdx_asignacion = new FrmCgg_kdx_asignacion("insert",TypeAsignacion.TRANSFERENCIA);
                        objCgg_kdx_asignacion.closeHandler(function(){
                            gsCgg_kdx_asignacion.reload();
                        });
                        objCgg_kdx_asignacion.show();
                    }}
            },
            {
                text:'Entre usuarios',
                listeners:{
                    click:function(){
                        var objCgg_kdx_asignacion = new FrmCgg_kdx_asignacion("insert",TypeAsignacion.USUARIOS);
                        objCgg_kdx_asignacion.closeHandler(function(){
                            gsCgg_kdx_asignacion.reload();
                        });
                        objCgg_kdx_asignacion.show();
                    }}
            }]
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_kdx_asignacion_stock.
     */
    var btnEditarCgg_kdx_asignacion = new Ext.Button({
        id:'btnEditarCgg_kdx_asignacion',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_kdx_asignacion.getSelectionModel().getSelected();
                if(r){
                    var objCgg_kdx_asignacion = new FrmCgg_kdx_asignacion("update",r);
                    objCgg_kdx_asignacion.closeHandler(function(){
                        gsCgg_kdx_asignacion.reload();
                    });
                    objCgg_kdx_asignacion.loadData();
                    objCgg_kdx_asignacion.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_kdx_asignacion_stock.
     */
    var btnEliminarCgg_kdx_asignacion = new Ext.Button({
        id:'btnEliminarCgg_kdx_asignacion',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_kdx_asignacion,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_kdx_asignacion(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_kdx_asignacion(r){
                            winFrmListadoCgg_kdx_asignacion_stock.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_asignacion,
                                    msg: 'La informaci\u00f3n de Asignaci\u00f3n de especies ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_kdx_asignacion.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_asignacion,
                                    msg: 'La informaci\u00f3n de Asignaci\u00f3n de especies no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_kdx_asignacion_stock.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCkasg_codigo',grdCgg_kdx_asignacion.getSelectionModel().getSelected().get('CKASG_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_kdx_asignacion,"delete",param, true, CallBackCgg_kdx_asignacion);
                    }catch(inErr){
                        winFrmListadoCgg_kdx_asignacion_stock.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_kdx_asignacion_stock.
     */
    var btnSalirCgg_kdx_asignacion = new Ext.Button({
        id:'btnSalirCgg_kdx_asignacion',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_kdx_asignacion_stock.close();
            }}
    });    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_asignacion.
     */
    var cmCgg_kdx_asignacion = new Ext.grid.ColumnModel([
        {dataIndex:'CKASG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKTRN_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKASG_NUMERO_ASIGNACION',header:'No. asignacion',width:150,sortable:true},
        {dataIndex:'CKESP_NOMBRE',header:'Especie',width:150,sortable:true,hidden:true},
        {dataIndex:'CKUPV_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_NOMBRES_USUARIO_ENTREGA',header:'Usuario entrega',width:150,sortable:true},
        {dataIndex:'CGG_CKUPV_CODIGO',header:'Ckupv codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_NOMBRES_USUARIO_RECIBE',header:'Usuario recibe',width:150,sortable:true},
        {dataIndex:'CGG_CKASG_CODIGO',header:'Ckasg codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKASG_FECHA_RECEPCION',header:'Fecha recepcion',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CKASG_CANTIDAD',header:'Cantidad',width:150,sortable:true},
        {dataIndex:'CKASG_PRECIO_UNITARIO',header:'Precio unitario',width:150,sortable:true},
        {dataIndex:'CKASG_SERIE_INICIO',header:'Serie inicio',width:150,sortable:true},
        {dataIndex:'CKASG_SERIE_FIN',header:'Serie fin',width:150,sortable:true},
        {dataIndex:'CKASG_CANTIDAD_DISPONIBLE',header:'Cantidad disponible',width:150,sortable:true},
        {dataIndex:'CKASG_ESTADO_ASIGNACION',header:'Estado asignacion',width:150,sortable:true,renderer:function(inCkasg_estado){
            if(inCkasg_estado==TypeEstadoAsignacion.REGISTRADA){
                return('REGISTRADA')
            }
            if(inCkasg_estado==TypeEstadoAsignacion.REASIGNADA){
                return('REASIGNADA')
            }
            if(inCkasg_estado==TypeEstadoAsignacion.FINALIZADA){
                return('FINALIZADA')
            }
        }},
        {dataIndex:'CKASG_OBSERVACION',header:'Observacion',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_asignacion por un campo especifico.
     */
    var gsCgg_kdx_asignacion = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_asignacion",
            method:"selectStockPV",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKASG_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CKASG_CODIGO'},
            {name:'CKTRN_CODIGO'},
            {name:'CKESP_NOMBRE'},
            {name:'CKUPV_CODIGO'},
            {name:'CRPER_NOMBRES_USUARIO_ENTREGA'},
            {name:'CGG_CKUPV_CODIGO'},
            {name:'CRPER_NOMBRES_USUARIO_RECIBE'},
            {name:'CGG_CKASG_CODIGO'},
            {name:'CKASG_NUMERO_ASIGNACION'},
            {name:'CKASG_FECHA_RECEPCION'},
            {name:'CKASG_CANTIDAD'},
            {name:'CKASG_PRECIO_UNITARIO'},
            {name:'CKASG_SERIE_INICIO'},
            {name:'CKASG_SERIE_FIN'},
            {name:'CKASG_CANTIDAD_DISPONIBLE'},
            {name:'CKASG_ESTADO_ASIGNACION'},
            {name:'CKASG_OBSERVACION'}
        ]),
        sortInfo:{field: 'CKESP_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'},
        groupField: 'CKESP_NOMBRE'
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_kdx_asignacion.
     */
    var pgBarCgg_kdx_asignacion= new Ext.PagingToolbar({
        store: gsCgg_kdx_asignacion,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_asignacion en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_asignacion = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_asignacion,
        store:gsCgg_kdx_asignacion,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_kdx_asignacion,
                width:200
            })
        ],
         view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Asignaciones" : "Asignacion"]})'
        }),
        bbar:pgBarCgg_kdx_asignacion,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_kdx_asignacion.hidden){
                    btnEditarCgg_kdx_asignacion.fireEvent('click', btnEditarCgg_kdx_asignacion);
                }
            }}});
    gsCgg_kdx_asignacion.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_kdx_asignacion.
     */
    if(inDescktop){
        var winFrmListadoCgg_kdx_asignacion_stock = inDescktop.createWindow({
            id:'winFrmListadoCgg_kdx_asignacion_stock',
            title:tituloListadoCgg_kdx_asignacion,
            iconCls:'iconAplicacion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_asignacion,descListadoCgg_kdx_asignacion),
            items:[grdCgg_kdx_asignacion],
            bbar:['->',btnSalirCgg_kdx_asignacion]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_kdx_asignacion_stock.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_kdx_asignacion_stock.
     * @returns ventana winFrmCgg_kdx_asignacion.
     * @base FrmListadoCgg_kdx_asignacion_stock.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_kdx_asignacion_stock;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_kdx_asignacion_stock.
     * @base FrmListadoCgg_kdx_asignacion_stock.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_kdx_asignacion.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_kdx_asignacion;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_kdx_asignacion;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_kdx_asignacion_stock.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_kdx_asignacion_stock.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_kdx_asignacion_stock desde una instancia.
 */
FrmListadoCgg_kdx_asignacion_stock.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_kdx_asignacion_stock desde una instancia.
 */
FrmListadoCgg_kdx_asignacion_stock.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_kdx_asignacion_stock,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_kdx_asignacion_stock.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_kdx_asignacion_stock desde una instancia.
 */
FrmListadoCgg_kdx_asignacion_stock.prototype.loadData = function(){
    this.loadData();
}
