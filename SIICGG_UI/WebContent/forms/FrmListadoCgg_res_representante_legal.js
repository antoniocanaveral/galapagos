/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_representante_legal.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_representante_legal(){
    var optMenu = 'Res representante legal';
    var urlListadoCgg_res_representante_legal=URL_WS+"Cgg_res_representante_legal";
    var tituloListadoCgg_res_representante_legal='Res representante legal';
    var descListadoCgg_res_representante_legal='El formulario permite administrar informaci\u00f3n de la tabla Res representante legal';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_representante_legal.
     */
    var btnNuevoCgg_res_representante_legal = new Ext.Button({
        id:'btnNuevoCgg_res_representante_legal',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_representante_legal = new FrmCgg_res_representante_legal("insert");
                objCgg_res_representante_legal.closeHandler(function(){
                    gsCgg_res_representante_legal.reload();
                });
                objCgg_res_representante_legal.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_representante_legal.
     */
    var btnEditarCgg_res_representante_legal = new Ext.Button({
        id:'btnEditarCgg_res_representante_legal',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_representante_legal.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_representante_legal = new FrmCgg_res_representante_legal("update",r);
                    objCgg_res_representante_legal.closeHandler(function(){
                        gsCgg_res_representante_legal.reload();
                    });
                    objCgg_res_representante_legal.loadData();
                    objCgg_res_representante_legal.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_representante_legal.
     */
    var btnEliminarCgg_res_representante_legal = new Ext.Button({
        id:'btnEliminarCgg_res_representante_legal',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_representante_legal,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_representante_legal(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_representante_legal(r){
                            winFrmListadoCgg_res_representante_legal.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_representante_legal,
                                    msg: 'La informaci\u00f3n de Res representante legal ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_representante_legal.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_representante_legal,
                                    msg: 'La informaci\u00f3n de Res representante legal no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_representante_legal.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrrpt_codigo',grdCgg_res_representante_legal.getSelectionModel().getSelected().get('CRRPT_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_representante_legal,"delete",param, true, CallBackCgg_res_representante_legal);
                    }catch(inErr){
                        winFrmListadoCgg_res_representante_legal.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_representante_legal.
     */
    var btnSalirCgg_res_representante_legal = new Ext.Button({
        id:'btnSalirCgg_res_representante_legal',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_representante_legal.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_representante_legal.
     */
    var chkCrrpt_activo = new Ext.grid.CheckColumn(
    {dataIndex:'CRRPT_ACTIVO',header:'Activo',width:150,sortable:true});
    var cmCgg_res_representante_legal = new Ext.grid.ColumnModel([
        {dataIndex:'CRRPT_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRPJR_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRRPT_FECHA_REGISTRO',header:'Fecha registro',width:150,sortable:true},
        chkCrrpt_activo,
        {dataIndex:'COLUMN_11',header:'11',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_representante_legal por un campo especifico.
     */
    var gsCgg_res_representante_legal = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_representante_legal",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRRPT_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRRPT_CODIGO'},
            {name:'CRPER_CODIGO'},
            {name:'CRPJR_CODIGO'},
            {name:'CRRPT_FECHA_REGISTRO'},
            {name:'CRRPT_ACTIVO'},
            {name:'COLUMN_11'}
        ]),
        sortInfo:{field: 'CRPER_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_representante_legal.
     */
    var pgBarCgg_res_representante_legal= new Ext.PagingToolbar({
        store: gsCgg_res_representante_legal,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_representante_legal en un formato tabular de filas y columnas.
     */
    var grdCgg_res_representante_legal = new Ext.grid.GridPanel({
        cm:cmCgg_res_representante_legal,
        store:gsCgg_res_representante_legal,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_representante_legal,
                width:200
            })
        ],
        bbar:pgBarCgg_res_representante_legal,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_representante_legal.hidden){
                    btnEditarCgg_res_representante_legal.fireEvent('click', btnEditarCgg_res_representante_legal);
                }
            }}});
    gsCgg_res_representante_legal.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_representante_legal.
     */
    var winFrmListadoCgg_res_representante_legal = new Ext.Window({
        id:'winFrmListadoCgg_res_representante_legal',
        title:tituloListadoCgg_res_representante_legal,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_representante_legal,descListadoCgg_res_representante_legal),
        items:[grdCgg_res_representante_legal],
        bbar:[btnNuevoCgg_res_representante_legal,btnEditarCgg_res_representante_legal,btnEliminarCgg_res_representante_legal,'->',btnSalirCgg_res_representante_legal]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_representante_legal.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_representante_legal.
     * @returns ventana winFrmCgg_res_representante_legal.
     * @base FrmListadoCgg_res_representante_legal.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_representante_legal;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_representante_legal.
     * @base FrmListadoCgg_res_representante_legal.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_representante_legal.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_representante_legal;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_representante_legal;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_representante_legal.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_representante_legal.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_representante_legal desde una instancia.
 */
FrmListadoCgg_res_representante_legal.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_representante_legal desde una instancia.
 */
FrmListadoCgg_res_representante_legal.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_representante_legal,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_representante_legal.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_representante_legal desde una instancia.
 */
FrmListadoCgg_res_representante_legal.prototype.loadData = function(){
    this.loadData();
}
