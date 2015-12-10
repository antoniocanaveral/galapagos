/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_muelle.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_muelle(){
    var optMenu = 'Movilidad interna/Muelle';
    var urlListadoCgg_res_muelle=URL_WS+"Cgg_res_muelle";
    var tituloListadoCgg_res_muelle='Listado de Muelle';
    var descListadoCgg_res_muelle='El formulario permite administrar informaci\u00f3n de Muelle';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_muelle.
     */
    var btnNuevoCgg_res_muelle = new Ext.Button({
        id:'btnNuevoCgg_res_muelle',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_res_muelle = new FrmCgg_res_muelle("insert");
                objCgg_res_muelle.closeHandler(function(){
                    gsCgg_res_muelle.reload();
                });
                objCgg_res_muelle.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_muelle.
     */
    var btnEditarCgg_res_muelle = new Ext.Button({
        id:'btnEditarCgg_res_muelle',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_res_muelle.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_muelle = new FrmCgg_res_muelle("update",r);
                    objCgg_res_muelle.closeHandler(function(){
                        gsCgg_res_muelle.reload();
                    });
                    objCgg_res_muelle.loadData();
                    objCgg_res_muelle.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_muelle.
     */
    var btnEliminarCgg_res_muelle = new Ext.Button({
        id:'btnEliminarCgg_res_muelle',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_muelle,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_muelle(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_muelle(r){
                            winFrmListadoCgg_res_muelle.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_muelle,
                                    msg: 'La informaci\u00f3n de Muelle ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_muelle.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_muelle,
                                    msg: 'La informaci\u00f3n de Muelle no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_muelle.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrmle_codigo',grdCgg_res_muelle.getSelectionModel().getSelected().get('CRMLE_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_muelle,"delete",param, true, CallBackCgg_res_muelle);
                    }catch(inErr){
                        winFrmListadoCgg_res_muelle.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_muelle.
     */
    var btnSalirCgg_res_muelle = new Ext.Button({
        id:'btnSalirCgg_res_muelle',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_res_muelle.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_muelle.
     */
    var cmCgg_res_muelle = new Ext.grid.ColumnModel([
        {dataIndex:'CRMLE_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true},
        {dataIndex:'CCTN_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true},
        {dataIndex:'CANTON',header:'Cant\u00f3n',width:290,sortable:true},
        {dataIndex:'CRMLE_NOMBRE',header:'Nombre',width:290,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_muelle por un campo especifico.
     */
    var gsCgg_res_muelle = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_muelle",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRMLE_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRMLE_CODIGO'},
            {name:'CCTN_CODIGO'},
            {name:'CANTON'},
            {name:'CRMLE_NOMBRE'}
        ]),
        sortInfo:{field: 'CCTN_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_muelle.
     */
    var pgBarCgg_res_muelle= new Ext.PagingToolbar({
        store: gsCgg_res_muelle,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_muelle en un formato tabular de filas y columnas.
     */
    var grdCgg_res_muelle = new Ext.grid.GridPanel({
        cm:cmCgg_res_muelle,
        store:gsCgg_res_muelle,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_muelle,
                width:200
            })
        ],
        bbar:pgBarCgg_res_muelle,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_muelle.hidden){
                    btnEditarCgg_res_muelle.fireEvent('click', btnEditarCgg_res_muelle);
                }
            }}});
    gsCgg_res_muelle.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_muelle.
     */
    var winFrmListadoCgg_res_muelle = new Ext.Window({
        id:'winFrmListadoCgg_res_muelle',
        title:tituloListadoCgg_res_muelle,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_muelle,descListadoCgg_res_muelle),
        items:[grdCgg_res_muelle],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_res_muelle,btnEditarCgg_res_muelle,btnEliminarCgg_res_muelle,'->',btnSalirCgg_res_muelle]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_muelle.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_muelle.
     * @returns ventana winFrmCgg_res_muelle.
     * @base FrmListadoCgg_res_muelle.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_muelle;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_muelle.
     * @base FrmListadoCgg_res_muelle.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_muelle.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_muelle;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_muelle;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_muelle.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_muelle.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_muelle desde una instancia.
 */
FrmListadoCgg_res_muelle.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_muelle desde una instancia.
 */
FrmListadoCgg_res_muelle.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_muelle,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_muelle.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_muelle desde una instancia.
 */
FrmListadoCgg_res_muelle.prototype.loadData = function(){
    this.loadData();
}
