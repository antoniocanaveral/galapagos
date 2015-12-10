/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_tipo_concepto.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_tipo_concepto(inDescktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Beca/Configuraci\u00F3n/Concepto desembolso';
    var urlListadoCgg_dhu_tipo_concepto=URL_WS+"Cgg_dhu_tipo_concepto";
    var tituloListadoCgg_dhu_tipo_concepto='Tipo concepto desembolso';
    var descListadoCgg_dhu_tipo_concepto='El formulario permite administrar informaci\u00f3n sobre los diferentes tipos de concepto de desembolso';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_tipo_concepto.
     */
    var btnNuevoCgg_dhu_tipo_concepto = new Ext.Button({
        id:'btnNuevoCgg_dhu_tipo_concepto',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_dhu_tipo_concepto = new FrmCgg_dhu_tipo_concepto("insert");
                objCgg_dhu_tipo_concepto.closeHandler(function(){
                    gsCgg_dhu_tipo_concepto.reload();
                });
                objCgg_dhu_tipo_concepto.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_tipo_concepto.
     */
    var btnEditarCgg_dhu_tipo_concepto = new Ext.Button({
        id:'btnEditarCgg_dhu_tipo_concepto',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_dhu_tipo_concepto.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_tipo_concepto = new FrmCgg_dhu_tipo_concepto("update",r);
                    objCgg_dhu_tipo_concepto.closeHandler(function(){
                        gsCgg_dhu_tipo_concepto.reload();
                    });
                    objCgg_dhu_tipo_concepto.loadData();
                    objCgg_dhu_tipo_concepto.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_tipo_concepto.
     */
    var btnEliminarCgg_dhu_tipo_concepto = new Ext.Button({
        id:'btnEliminarCgg_dhu_tipo_concepto',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_tipo_concepto,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_tipo_concepto(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_tipo_concepto(r){
                            winFrmListadoCgg_dhu_tipo_concepto.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_tipo_concepto,
                                    msg: 'La informaci\u00f3n ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_tipo_concepto.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_tipo_concepto,
                                    msg: 'La informaci\u00f3n  no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_tipo_concepto.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdtcp_codigo',grdCgg_dhu_tipo_concepto.getSelectionModel().getSelected().get('CDTCP_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_tipo_concepto,"delete",param, true, CallBackCgg_dhu_tipo_concepto);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_tipo_concepto.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_tipo_concepto.
     */
    var btnSalirCgg_dhu_tipo_concepto = new Ext.Button({
        id:'btnSalirCgg_dhu_tipo_concepto',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_tipo_concepto.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_tipo_concepto.
     */
    var cmCgg_dhu_tipo_concepto = new Ext.grid.ColumnModel([
        {dataIndex:'CDTCP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDTCP_NOMBRE_DESEMBOLSO',header:'Nombre desembolso',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_tipo_concepto por un campo especifico.
     */
    var gsCgg_dhu_tipo_concepto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_tipo_concepto",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDTCP_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDTCP_CODIGO'},
            {name:'CDTCP_NOMBRE_DESEMBOLSO'}
        ]),
        sortInfo:{field: 'CDTCP_NOMBRE_DESEMBOLSO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_tipo_concepto.
     */
    var pgBarCgg_dhu_tipo_concepto= new Ext.PagingToolbar({
        store: gsCgg_dhu_tipo_concepto,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_tipo_concepto en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_tipo_concepto = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_tipo_concepto,
        store:gsCgg_dhu_tipo_concepto,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_tipo_concepto,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_tipo_concepto,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_tipo_concepto.hidden){
                    btnEditarCgg_dhu_tipo_concepto.fireEvent('click', btnEditarCgg_dhu_tipo_concepto);
                }
            }}});
    gsCgg_dhu_tipo_concepto.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_tipo_concepto.
     */
    if(inDescktop){
    var winFrmListadoCgg_dhu_tipo_concepto = inDescktop.createWindow({
        id:'winFrmListadoCgg_dhu_tipo_concepto',
        title:tituloListadoCgg_dhu_tipo_concepto,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_tipo_concepto,descListadoCgg_dhu_tipo_concepto),
        items:[grdCgg_dhu_tipo_concepto],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_dhu_tipo_concepto,btnEditarCgg_dhu_tipo_concepto,btnEliminarCgg_dhu_tipo_concepto,'->',btnSalirCgg_dhu_tipo_concepto]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_dhu_tipo_concepto.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_tipo_concepto.
     * @returns ventana winFrmCgg_dhu_tipo_concepto.
     * @base FrmListadoCgg_dhu_tipo_concepto.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_tipo_concepto;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_tipo_concepto.
     * @base FrmListadoCgg_dhu_tipo_concepto.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_tipo_concepto.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_tipo_concepto;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_tipo_concepto;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_tipo_concepto.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_tipo_concepto.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_tipo_concepto desde una instancia.
 */
FrmListadoCgg_dhu_tipo_concepto.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_tipo_concepto desde una instancia.
 */
FrmListadoCgg_dhu_tipo_concepto.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_tipo_concepto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_tipo_concepto.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_tipo_concepto desde una instancia.
 */
FrmListadoCgg_dhu_tipo_concepto.prototype.loadData = function(){
    this.loadData();
}
