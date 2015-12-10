/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_sadjunto.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_sadjunto(inDescktop){
    //var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Beca/Configuraci\u00F3n';
    var urlListadoCgg_dhu_sadjunto=URL_WS+"Cgg_dhu_sadjunto";
    var tituloListadoCgg_dhu_sadjunto='Listado adjunto seguimiento academico';
    var descListadoCgg_dhu_sadjunto='El formulario permite administrar informaci\u00f3n de los adjuntos de seguimiento academico';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_sadjunto.
     */
    var btnNuevoCgg_dhu_sadjunto = new Ext.Button({
        id:'btnNuevoCgg_dhu_sadjunto',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_dhu_sadjunto = new FrmCgg_dhu_sadjunto("insert");
                objCgg_dhu_sadjunto.closeHandler(function(){
                    gsCgg_dhu_sadjunto.reload();
                });
                objCgg_dhu_sadjunto.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_sadjunto.
     */
    var btnEditarCgg_dhu_sadjunto = new Ext.Button({
        id:'btnEditarCgg_dhu_sadjunto',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_dhu_sadjunto.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_sadjunto = new FrmCgg_dhu_sadjunto("update",r);
                    objCgg_dhu_sadjunto.closeHandler(function(){
                        gsCgg_dhu_sadjunto.reload();
                    });
                    objCgg_dhu_sadjunto.loadData();
                    objCgg_dhu_sadjunto.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_sadjunto.
     */
    var btnEliminarCgg_dhu_sadjunto = new Ext.Button({
        id:'btnEliminarCgg_dhu_sadjunto',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_sadjunto,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_sadjunto(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_sadjunto(r){
                            winFrmListadoCgg_dhu_sadjunto.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_sadjunto,
                                    msg: 'La informaci\u00f3n de Dhu sadjunto ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_sadjunto.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_sadjunto,
                                    msg: 'La informaci\u00f3n no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_sadjunto.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdsad_codigo',grdCgg_dhu_sadjunto.getSelectionModel().getSelected().get('CDSAD_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_sadjunto,"delete",param, true, CallBackCgg_dhu_sadjunto);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_sadjunto.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_sadjunto.
     */
    var btnSalirCgg_dhu_sadjunto = new Ext.Button({
        id:'btnSalirCgg_dhu_sadjunto',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_sadjunto.close();
            }}
    });    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_sadjunto.
     */
    var cmCgg_dhu_sadjunto = new Ext.grid.ColumnModel([
        {dataIndex:'CDSAD_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CDACD_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CDBCR_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CDSAD_FECHA_REGISTRO',header:'Fecha registro',width:150,sortable:true},
        {dataIndex:'CDSAD_NOMBRE_ADJUNTO',header:'Nombre adjunto',width:150,sortable:true},
        {dataIndex:'CDSAD_ADJUNTO',header:'Adjunto',width:150,sortable:true},
        {dataIndex:'CDSAD_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_sadjunto por un campo especifico.
     */
    var gsCgg_dhu_sadjunto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_sadjunto",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDSAD_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[

                
        ]),
        sortInfo:{field: 'CDACD_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_sadjunto.
     */
    var pgBarCgg_dhu_sadjunto= new Ext.PagingToolbar({
        store: gsCgg_dhu_sadjunto,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_sadjunto en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_sadjunto = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_sadjunto,
        store:gsCgg_dhu_sadjunto,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_sadjunto,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_sadjunto,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_sadjunto.hidden){
                    btnEditarCgg_dhu_sadjunto.fireEvent('click', btnEditarCgg_dhu_sadjunto);
                }
            }}});
    gsCgg_dhu_sadjunto.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_sadjunto.
     */
    if(inDescktop){
    var winFrmListadoCgg_dhu_sadjunto = new Ext.Window({
        id:'winFrmListadoCgg_dhu_sadjunto',
        title:tituloListadoCgg_dhu_sadjunto,
        tbar:getPanelTitulo(tituloListadoCgg_dhu_sadjunto,descListadoCgg_dhu_sadjunto),
        items:[grdCgg_dhu_sadjunto],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_dhu_sadjunto,btnEditarCgg_dhu_sadjunto,btnEliminarCgg_dhu_sadjunto,'->',btnSalirCgg_dhu_sadjunto]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_dhu_sadjunto.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_sadjunto.
     * @returns ventana winFrmCgg_dhu_sadjunto.
     * @base FrmListadoCgg_dhu_sadjunto.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_sadjunto;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_sadjunto.
     * @base FrmListadoCgg_dhu_sadjunto.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_sadjunto.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_sadjunto;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_sadjunto;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_sadjunto.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_sadjunto.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_sadjunto desde una instancia.
 */
FrmListadoCgg_dhu_sadjunto.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_sadjunto desde una instancia.
 */
FrmListadoCgg_dhu_sadjunto.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_sadjunto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_sadjunto.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_sadjunto desde una instancia.
 */
FrmListadoCgg_dhu_sadjunto.prototype.loadData = function(){
    this.loadData();
}
