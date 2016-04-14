/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_kdx_vd_denominacion.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_kdx_vd_denominacion(){
    var urlListadoCgg_kdx_vd_denominacion=URL_WS+"Cgg_kdx_vd_denominacion";
    var tituloListadoCgg_kdx_vd_denominacion='Kdx vd denominacion';
    var descListadoCgg_kdx_vd_denominacion='El formulario permite administrar informaci\u00f3n de la tabla Kdx vd denominacion';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_kdx_vd_denominacion.
     */
    var btnNuevoCgg_kdx_vd_denominacion = new Ext.Button({
        id:'btnNuevoCgg_kdx_vd_denominacion',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_kdx_vd_denominacion = new FrmCgg_kdx_vd_denominacion("insert");
                objCgg_kdx_vd_denominacion.closeHandler(function(){
                    gsCgg_kdx_vd_denominacion.reload();
                });
                objCgg_kdx_vd_denominacion.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_kdx_vd_denominacion.
     */
    var btnEditarCgg_kdx_vd_denominacion = new Ext.Button({
        id:'btnEditarCgg_kdx_vd_denominacion',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_kdx_vd_denominacion.getSelectionModel().getSelected();
                if(r){
                    var objCgg_kdx_vd_denominacion = new FrmCgg_kdx_vd_denominacion("update",r);
                    objCgg_kdx_vd_denominacion.closeHandler(function(){
                        gsCgg_kdx_vd_denominacion.reload();
                    });
                    objCgg_kdx_vd_denominacion.loadData();
                    objCgg_kdx_vd_denominacion.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_kdx_vd_denominacion.
     */
    var btnEliminarCgg_kdx_vd_denominacion = new Ext.Button({
        id:'btnEliminarCgg_kdx_vd_denominacion',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_kdx_vd_denominacion,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_kdx_vd_denominacion(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_kdx_vd_denominacion(r){
                            winFrmListadoCgg_kdx_vd_denominacion.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_vd_denominacion,
                                    msg: 'La informaci\u00f3n de Kdx vd denominacion ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_kdx_vd_denominacion.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_vd_denominacion,
                                    msg: 'La informaci\u00f3n de Kdx vd denominacion no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_kdx_vd_denominacion.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCkvdd_codigo',grdCgg_kdx_vd_denominacion.getSelectionModel().getSelected().get('CKVDD_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_kdx_vd_denominacion,"delete",param, true, CallBackCgg_kdx_vd_denominacion);
                    }catch(inErr){
                        winFrmListadoCgg_kdx_vd_denominacion.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_kdx_vd_denominacion.
     */
    var btnSalirCgg_kdx_vd_denominacion = new Ext.Button({
        id:'btnSalirCgg_kdx_vd_denominacion',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_kdx_vd_denominacion.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_vd_denominacion.
     */
    var cmCgg_kdx_vd_denominacion = new Ext.grid.ColumnModel([
        {dataIndex:'CKVDD_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CKVNT_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CKDNM_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CKVDD_CANTIDAD',header:'Cantidad',width:150,sortable:true},
        {dataIndex:'CKVDD_VALOR',header:'Valor',width:150,sortable:true},
        {dataIndex:'CKVDD_TOTAL',header:'Total',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_vd_denominacion por un campo especifico.
     */
    var gsCgg_kdx_vd_denominacion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_vd_denominacion",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKVDD_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CKVDD_CODIGO'},
            {name:'CKVNT_CODIGO'},
            {name:'CKDNM_CODIGO'},
            {name:'CKVDD_CANTIDAD'},
            {name:'CKVDD_VALOR'},
            {name:'CKVDD_TOTAL'}
        ]),
        sortInfo:{field: 'CKVNT_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_kdx_vd_denominacion.
     */
    var pgBarCgg_kdx_vd_denominacion= new Ext.PagingToolbar({
        store: gsCgg_kdx_vd_denominacion,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_vd_denominacion en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_vd_denominacion = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_vd_denominacion,
        store:gsCgg_kdx_vd_denominacion,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_kdx_vd_denominacion,
                width:200
            })
        ],
        bbar:pgBarCgg_kdx_vd_denominacion,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_kdx_vd_denominacion.hidden){
                    btnEditarCgg_kdx_vd_denominacion.fireEvent('click', btnEditarCgg_kdx_vd_denominacion);
                }
            }}});
    gsCgg_kdx_vd_denominacion.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_kdx_vd_denominacion.
     */
    var winFrmListadoCgg_kdx_vd_denominacion = new Ext.Window({
        id:'winFrmListadoCgg_kdx_vd_denominacion',
        title:tituloListadoCgg_kdx_vd_denominacion,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_vd_denominacion,descListadoCgg_kdx_vd_denominacion),
        items:[grdCgg_kdx_vd_denominacion],
        bbar:[btnNuevoCgg_kdx_vd_denominacion,btnEditarCgg_kdx_vd_denominacion,btnEliminarCgg_kdx_vd_denominacion,'->',btnSalirCgg_kdx_vd_denominacion]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_kdx_vd_denominacion.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_kdx_vd_denominacion.
     * @returns ventana winFrmCgg_kdx_vd_denominacion.
     * @base FrmListadoCgg_kdx_vd_denominacion.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_kdx_vd_denominacion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_kdx_vd_denominacion.
     * @base FrmListadoCgg_kdx_vd_denominacion.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_kdx_vd_denominacion.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_kdx_vd_denominacion;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_kdx_vd_denominacion;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_kdx_vd_denominacion.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_kdx_vd_denominacion.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_kdx_vd_denominacion desde una instancia.
 */
FrmListadoCgg_kdx_vd_denominacion.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_kdx_vd_denominacion desde una instancia.
 */
FrmListadoCgg_kdx_vd_denominacion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_kdx_vd_denominacion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_kdx_vd_denominacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_kdx_vd_denominacion desde una instancia.
 */
FrmListadoCgg_kdx_vd_denominacion.prototype.loadData = function(){
    this.loadData();
}
