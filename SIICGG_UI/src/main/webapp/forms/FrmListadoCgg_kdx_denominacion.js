/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_kdx_denominacion.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_kdx_denominacion(inDesktop){
    var optMenu = 'Kardex/Configurac\u00f3n/Denominaci\u00f3n monetaria';
    var urlListadoCgg_kdx_denominacion=URL_WS+"Cgg_kdx_denominacion";
    var tituloListadoCgg_kdx_denominacion='Denominaci\u00f3n monetaria';
    var descListadoCgg_kdx_denominacion='El formulario permite administrar informaci\u00f3n de denominaci\u00f3on monetaria';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_kdx_denominacion.
     */
    var btnNuevoCgg_kdx_denominacion = new Ext.Button({
        id:'btnNuevoCgg_kdx_denominacion',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_kdx_denominacion = new FrmCgg_kdx_denominacion("insert");
                objCgg_kdx_denominacion.closeHandler(function(){
                    gsCgg_kdx_denominacion.reload();
                });
                objCgg_kdx_denominacion.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_kdx_denominacion.
     */
    var btnEditarCgg_kdx_denominacion = new Ext.Button({
        id:'btnEditarCgg_kdx_denominacion',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_kdx_denominacion.getSelectionModel().getSelected();
                if(r){
                    var objCgg_kdx_denominacion = new FrmCgg_kdx_denominacion("update",r);
                    objCgg_kdx_denominacion.closeHandler(function(){
                        gsCgg_kdx_denominacion.reload();
                    });
                    objCgg_kdx_denominacion.loadData();
                    objCgg_kdx_denominacion.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_kdx_denominacion.
     */
    var btnEliminarCgg_kdx_denominacion = new Ext.Button({
        id:'btnEliminarCgg_kdx_denominacion',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_kdx_denominacion,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_kdx_denominacion(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_kdx_denominacion(r){
                            winFrmListadoCgg_kdx_denominacion.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_denominacion,
                                    msg: 'La informaci\u00f3n de denominaci\u00f3on monetaria ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_kdx_denominacion.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_denominacion,
                                    msg: 'La informaci\u00f3n de denominaci\u00f3on monetaria no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_kdx_denominacion.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCkdnm_codigo',grdCgg_kdx_denominacion.getSelectionModel().getSelected().get('CKDNM_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_kdx_denominacion,"delete",param, true, CallBackCgg_kdx_denominacion);
                    }catch(inErr){
                        winFrmListadoCgg_kdx_denominacion.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_kdx_denominacion.
     */
    var btnSalirCgg_kdx_denominacion = new Ext.Button({
        id:'btnSalirCgg_kdx_denominacion',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_kdx_denominacion.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_denominacion.
     */
    var cmCgg_kdx_denominacion = new Ext.grid.ColumnModel([
        {dataIndex:'CKDNM_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable :false},
        {dataIndex:'CKTPG_DESCRIPCION',header:'Tipo pago',width:150,sortable:true,hidden:true},
        {dataIndex:'CKDNM_DENOMINACION',header:'Denominaci\u00f3n',width:150,sortable:true},
        {dataIndex:'CKDNM_VALOR_MONETARIO',header:'Valor monetario',width:150,sortable:true},
        {dataIndex:'CKDNM_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_denominacion por un campo especifico.
     */
    var gsCgg_kdx_denominacion = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_denominacion",
            method:"selectPageDirect1",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKDNM_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CKDNM_CODIGO'},
            {name:'CKTPG_CODIGO'},
            {name:'CKTPG_DESCRIPCION'},
            {name:'CKDNM_DENOMINACION'},
            {name:'CKDNM_OBSERVACION'},
            {name:'CKDNM_VALOR_MONETARIO'}
        ]),
        sortInfo:{field: 'CKTPG_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'},
        groupField: 'CKTPG_DESCRIPCION'
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_kdx_denominacion.
     */
    var pgBarCgg_kdx_denominacion= new Ext.PagingToolbar({
        store: gsCgg_kdx_denominacion,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_denominacion en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_denominacion = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_denominacion,
        store:gsCgg_kdx_denominacion,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_kdx_denominacion,
                width:200
            })
        ],
        bbar:pgBarCgg_kdx_denominacion,
        view: new Ext.grid.GroupingView({
            forceFit: true,
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Tipos" : "Tipo"]})'
        }),
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_kdx_denominacion.hidden){
                    btnEditarCgg_kdx_denominacion.fireEvent('click', btnEditarCgg_kdx_denominacion);
                }
            }}});
    gsCgg_kdx_denominacion.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_kdx_denominacion.
     */
    var winFrmListadoCgg_kdx_denominacion = null;
    if(inDesktop!==null && inDesktop!==undefined){
        winFrmListadoCgg_kdx_denominacion = inDesktop.createWindow({
            id:'winFrmListadoCgg_kdx_denominacion',
            title:tituloListadoCgg_kdx_denominacion,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_denominacion,descListadoCgg_kdx_denominacion),
            items:[grdCgg_kdx_denominacion],
            bbar:[btnNuevoCgg_kdx_denominacion,btnEditarCgg_kdx_denominacion,btnEliminarCgg_kdx_denominacion,'->',btnSalirCgg_kdx_denominacion]
        });
    }
    else
    {
        winFrmListadoCgg_kdx_denominacion = new Ext.Window({
            id:'winFrmListadoCgg_kdx_denominacion',
            title:tituloListadoCgg_kdx_denominacion,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_denominacion,descListadoCgg_kdx_denominacion),
            items:[grdCgg_kdx_denominacion],
            bbar:[btnNuevoCgg_kdx_denominacion,btnEditarCgg_kdx_denominacion,btnEliminarCgg_kdx_denominacion,'->',btnSalirCgg_kdx_denominacion]
        });
    }
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_kdx_denominacion.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_kdx_denominacion.
     * @returns ventana winFrmCgg_kdx_denominacion.
     * @base FrmListadoCgg_kdx_denominacion.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_kdx_denominacion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_kdx_denominacion.
     * @base FrmListadoCgg_kdx_denominacion.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_kdx_denominacion.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_kdx_denominacion;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_kdx_denominacion;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_kdx_denominacion.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_kdx_denominacion.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_kdx_denominacion desde una instancia.
 */
FrmListadoCgg_kdx_denominacion.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_kdx_denominacion desde una instancia.
 */
FrmListadoCgg_kdx_denominacion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_kdx_denominacion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_kdx_denominacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_kdx_denominacion desde una instancia.
 */
FrmListadoCgg_kdx_denominacion.prototype.loadData = function(){
    this.loadData();
}
