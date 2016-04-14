/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_kdx_venta.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_kdx_venta(inDesktop){
    var optMenu = 'Kardex/Venta';
    var urlListadoCgg_kdx_venta=URL_WS+"Cgg_kdx_venta";
    var tituloListadoCgg_kdx_venta='Venta TCT';
    var descListadoCgg_kdx_venta='El formulario permite administrar informaci\u00f3n de venta de TCT';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_kdx_venta.
     */
    var btnNuevoCgg_kdx_venta = new Ext.Button({
        id:'btnNuevoCgg_kdx_venta',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        hidden:true,
        listeners:{
            click:function(){
                var objCgg_kdx_venta = new FrmCgg_kdx_venta("insert");
                objCgg_kdx_venta.closeHandler(function(){
                    gsCgg_kdx_venta.reload();
                });
                objCgg_kdx_venta.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_kdx_venta.
     */
    var btnEditarCgg_kdx_venta = new Ext.Button({
        id:'btnEditarCgg_kdx_venta',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_kdx_venta.getSelectionModel().getSelected();
                if(r){
                    var objCgg_kdx_venta = new FrmCgg_kdx_venta("update",r);
                    objCgg_kdx_venta.closeHandler(function(){
                        gsCgg_kdx_venta.reload();
                    });
                    objCgg_kdx_venta.loadData();
                    objCgg_kdx_venta.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_kdx_venta.
     */
    var btnEliminarCgg_kdx_venta = new Ext.Button({
        id:'btnEliminarCgg_kdx_venta',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        hidden:true,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_kdx_venta,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_kdx_venta(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_kdx_venta(r){
                            winFrmListadoCgg_kdx_venta.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_venta,
                                    msg: 'La informaci\u00f3n de Venta TCT ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_kdx_venta.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_venta,
                                    msg: 'La informaci\u00f3n de Venta TCT no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_kdx_venta.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCkvnt_codigo',grdCgg_kdx_venta.getSelectionModel().getSelected().get('CKVNT_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_kdx_venta,"delete",param, true, CallBackCgg_kdx_venta);
                    }catch(inErr){
                        winFrmListadoCgg_kdx_venta.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_kdx_venta.
     */
    var btnSalirCgg_kdx_venta = new Ext.Button({
        id:'btnSalirCgg_kdx_venta',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_kdx_venta.close();
            }}
    });
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_venta por un campo especifico.
     */
    var gsCgg_kdx_venta = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_venta",
            method:"selectPageByEstado",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKVNT_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CKVNT_CODIGO'},
            {name:'CKASG_CODIGO'},
            {name:'CKESP_NOMBRE'},
            {name:'CKVNT_LOTE'},
            {name:'CKVNT_FECHA_INGRESO'},
            {name:'CKVNT_NUMERO_VENTA'},
            {name:'CKVNT_SERIE_INICIO'},
            {name:'CKVNT_SERIE_FIN'},
            {name:'CKVNT_CANTIDAD'},
            {name:'CKVNT_TOTAL'},
            {name:'CKVNT_ESTADO_VENTA'}
        ]),
        sortInfo:{field: 'CKVNT_FECHA_INGRESO', direction: 'DESC'},
        baseParams:{keyword:"",format:'JSON',inCkvnt_estado_venta:TypeEstadoVenta.TODOS},
        groupField: 'CKVNT_FECHA_INGRESO'
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_venta.
     */
    var cmCgg_kdx_venta = new Ext.grid.ColumnModel([
        {dataIndex:'CKVNT_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKASG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKVNT_NUMERO_VENTA',header:'No. venta',width:100,sortable:true},
        {dataIndex:'CKESP_NOMBRE',header:'Especie',width:150,sortable:true},
        {dataIndex:'CKVNT_FECHA_INGRESO',header:'Fecha ingreso',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CKVNT_LOTE',header:'Lote',width:150,sortable:true},
        {dataIndex:'CKVNT_SERIE_INICIO',header:'Serie inicio',width:150,sortable:true},
        {dataIndex:'CKVNT_SERIE_FIN',header:'Serie fin',width:150,sortable:true},
        {dataIndex:'CKVNT_CANTIDAD',header:'Cantidad',width:150,sortable:true},
        {dataIndex:'CKVNT_TOTAL',header:'Total',width:150,sortable:true},
        {dataIndex:'CKVNT_ESTADO_VENTA',header:'Estado venta',width:150,sortable:true,renderer:function(inCkvnt_Estado){
            if(inCkvnt_Estado==TypeEstadoVenta.REGISTRADA){
                return('REGISTRADA')
            }
            if(inCkvnt_Estado==TypeEstadoVenta.CONFIRMADA){
                return('CONFIRMADA')
            }
            if(inCkvnt_Estado==TypeEstadoVenta.CONTABILIZADA){
                return('CONTABILIZADA')
            }
        }}]);
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_kdx_venta.
     */
    var pgBarCgg_kdx_venta= new Ext.PagingToolbar({
        store: gsCgg_kdx_venta,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_venta en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_venta = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_venta,
        store:gsCgg_kdx_venta,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_kdx_venta,
                width:200
            })
        ],
        bbar:pgBarCgg_kdx_venta,
         view: new Ext.grid.GroupingView({
           groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Ventas" : "Venta"]})'
        }),
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_kdx_venta.hidden){
                    btnEditarCgg_kdx_venta.fireEvent('click', btnEditarCgg_kdx_venta);
                }
            }}});
    gsCgg_kdx_venta.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_kdx_venta.
     */
    var winFrmListadoCgg_kdx_venta = null;

    if(inDesktop){
        winFrmListadoCgg_kdx_venta  = inDesktop.createWindow({
            id:'winFrmListadoCgg_kdx_venta',
            title:tituloListadoCgg_kdx_venta,
            iconCls:'iconAplicacion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_venta,descListadoCgg_kdx_venta),
            items:[grdCgg_kdx_venta],
            bbar:[btnEditarCgg_kdx_venta,btnEliminarCgg_kdx_venta,'->',btnSalirCgg_kdx_venta]
        });
    }
    else
    {
        winFrmListadoCgg_kdx_venta  = new Ext.Window({
            id:'winFrmListadoCgg_kdx_venta',
            title:tituloListadoCgg_kdx_venta,
            iconCls:'iconAplicacion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_venta,descListadoCgg_kdx_venta),
            items:[grdCgg_kdx_venta],
            bbar:[btnNuevoCgg_kdx_venta,btnEditarCgg_kdx_venta,btnEliminarCgg_kdx_venta,'->',btnSalirCgg_kdx_venta]
        });
    }


    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_kdx_venta.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_kdx_venta.
     * @returns ventana winFrmCgg_kdx_venta.
     * @base FrmListadoCgg_kdx_venta.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_kdx_venta;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_kdx_venta.
     * @base FrmListadoCgg_kdx_venta.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_kdx_venta.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_kdx_venta;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_kdx_venta;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_kdx_venta.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_kdx_venta.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_kdx_venta desde una instancia.
 */
FrmListadoCgg_kdx_venta.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_kdx_venta desde una instancia.
 */
FrmListadoCgg_kdx_venta.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_kdx_venta,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_kdx_venta.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_kdx_venta desde una instancia.
 */
FrmListadoCgg_kdx_venta.prototype.loadData = function(){
    this.loadData();
}
