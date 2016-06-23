/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_seguimiento_economico.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_seguimiento_economico(inDescktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Beca/Seguimiento Econ\u00F3mico';
    var urlListadoCgg_dhu_seguimiento_economico=URL_WS+"Cgg_dhu_seguimiento_economico";
    var tituloListadoCgg_dhu_seguimiento_economico='Seguimiento econ\u00F3mico';
    var descListadoCgg_dhu_seguimiento_economico='El formulario permite administrar informaci\u00f3n sobre los diferentes seguimientos econ\u00F3micos';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_seguimiento_economico.
     */
    var btnNuevoCgg_dhu_seguimiento_economico = new Ext.Button({
        id:'btnNuevoCgg_dhu_seguimiento_economico',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_dhu_seguimiento_economico = new FrmCgg_dhu_seguimiento_economico("insert");
                objCgg_dhu_seguimiento_economico.closeHandler(function(){
                    gsCgg_dhu_seguimiento_economico.reload();
                });
                objCgg_dhu_seguimiento_economico.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_seguimiento_economico.
     */
    var btnEditarCgg_dhu_seguimiento_economico = new Ext.Button({
        id:'btnEditarCgg_dhu_seguimiento_economico',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_dhu_seguimiento_economico.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_seguimiento_economico = new FrmCgg_dhu_seguimiento_economico("update",r);
                    objCgg_dhu_seguimiento_economico.closeHandler(function(){
                        gsCgg_dhu_seguimiento_economico.reload();
                    });
                    objCgg_dhu_seguimiento_economico.loadData();
                    objCgg_dhu_seguimiento_economico.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_seguimiento_economico.
     */
    var btnEliminarCgg_dhu_seguimiento_economico = new Ext.Button({
        id:'btnEliminarCgg_dhu_seguimiento_economico',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_seguimiento_economico,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_seguimiento_economico(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_seguimiento_economico(r){
                            winFrmListadoCgg_dhu_seguimiento_economico.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_seguimiento_economico,
                                    msg: 'La informaci\u00f3n  ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_seguimiento_economico.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_seguimiento_economico,
                                    msg: 'La informaci\u00f3n  no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_seguimiento_economico.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdsec_codigo',grdCgg_dhu_seguimiento_economico.getSelectionModel().getSelected().get('CDSEC_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_seguimiento_economico,"delete",param, true, CallBackCgg_dhu_seguimiento_economico);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_seguimiento_economico.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_seguimiento_economico.
     */
    var btnSalirCgg_dhu_seguimiento_economico = new Ext.Button({
        id:'btnSalirCgg_dhu_seguimiento_economico',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_seguimiento_economico.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_seguimiento_economico.
     */
    var cmCgg_dhu_seguimiento_economico = new Ext.grid.ColumnModel([
        {dataIndex:'CDSEC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDTCP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDACD_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDBEC_NUMERO_CONVENIO',header:'Contrato beca',width:150,sortable:true},
        {dataIndex:'CRPER_NOMBRES',header:'Nombre',width:150,sortable:true},
        {dataIndex:'CRPER_APELLIDO_PATERNO',header:'Primer apellido',width:150,sortable:true},
        {dataIndex:'CRPER_APELLIDO_MATERNO',header:'Segundo apellido',width:150,sortable:true},
        {dataIndex:'CDSEC_CODIGO_TRANSFERENCIA',header:'C\u00f3digo transferencia',width:150,sortable:true},
        {dataIndex:'CDSEC_VALOR',header:'Valor',width:150,sortable:true},
        {dataIndex:'CDSEC_FECHA_TRANSFERENCIA',header:'Fecha transferencia',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CDSEC_CODIGO_TRANSF_IECE',header:'C\u00f3digo transf iece',width:150,sortable:true},
        {dataIndex:'CDSEC_VALOR_IECE',header:'Valor iece',width:150,sortable:true},
        {dataIndex:'CDSEC_FECHA_TRANSF_IECE',header:'Fecha transf iece',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CDSEC_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_seguimiento_economico por un campo especifico.
     */
    var gsCgg_dhu_seguimiento_economico = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_seguimiento_economico",
            method:"selectPageSeguimientoEco",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDSEC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDSEC_CODIGO'},
            {name:'CDTCP_CODIGO'},
            {name:'CDACD_CODIGO'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_APELLIDO_MATERNO'},
            {name:'CDBEC_NUMERO_CONVENIO'},
            {name:'CDBEC_FUNCIONARIO'},
            {name:'CDACD_NUMERO_CICLO'},
            {name:'CDACD_ESTADO_APROBACION'},
            {name:'CDSEC_CODIGO_TRANSFERENCIA'},
            {name:'CDSEC_VALOR'},
            {name:'CDSEC_FECHA_TRANSFERENCIA'},
            {name:'CDSEC_CODIGO_TRANSF_IECE'},
            {name:'CDSEC_VALOR_IECE'},
            {name:'CDSEC_FECHA_TRANSF_IECE'},
            {name:'CDSEC_OBSERVACION'}
        ]),
        sortInfo:{field: 'CDBEC_NUMERO_CONVENIO', direction: 'ASC'},
        groupField:"CDBEC_NUMERO_CONVENIO",
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_seguimiento_economico.
     */
    var pgBarCgg_dhu_seguimiento_economico= new Ext.PagingToolbar({
        store: gsCgg_dhu_seguimiento_economico,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_seguimiento_economico en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_seguimiento_economico = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_seguimiento_economico,
        store:gsCgg_dhu_seguimiento_economico,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
          view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_seguimiento_economico,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_seguimiento_economico,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_seguimiento_economico.hidden){
                    btnEditarCgg_dhu_seguimiento_economico.fireEvent('click', btnEditarCgg_dhu_seguimiento_economico);
                }
            }}});
    gsCgg_dhu_seguimiento_economico.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_seguimiento_economico.
     */
    if(inDescktop){
    var winFrmListadoCgg_dhu_seguimiento_economico = inDescktop.createWindow({
        id:'winFrmListadoCgg_dhu_seguimiento_economico',
        title:tituloListadoCgg_dhu_seguimiento_economico,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_seguimiento_economico,descListadoCgg_dhu_seguimiento_economico),
        items:[grdCgg_dhu_seguimiento_economico],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_dhu_seguimiento_economico,btnEditarCgg_dhu_seguimiento_economico,btnEliminarCgg_dhu_seguimiento_economico,'->',btnSalirCgg_dhu_seguimiento_economico]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_dhu_seguimiento_economico.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_seguimiento_economico.
     * @returns ventana winFrmCgg_dhu_seguimiento_economico.
     * @base FrmListadoCgg_dhu_seguimiento_economico.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_seguimiento_economico;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_seguimiento_economico.
     * @base FrmListadoCgg_dhu_seguimiento_economico.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_seguimiento_economico.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_seguimiento_economico;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_seguimiento_economico;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_seguimiento_economico.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_seguimiento_economico.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_seguimiento_economico desde una instancia.
 */
FrmListadoCgg_dhu_seguimiento_economico.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_seguimiento_economico desde una instancia.
 */
FrmListadoCgg_dhu_seguimiento_economico.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_seguimiento_economico,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_seguimiento_economico.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_seguimiento_economico desde una instancia.
 */
FrmListadoCgg_dhu_seguimiento_economico.prototype.loadData = function(){
    this.loadData();
}
