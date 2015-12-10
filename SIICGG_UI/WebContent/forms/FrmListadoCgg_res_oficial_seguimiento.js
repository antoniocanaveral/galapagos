/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_oficial_seguimiento.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_oficial_seguimiento(inDesktop){
    var optMenu = 'Control de Residencia/Operativos de seguimiento/Oficiales de seguimiento';
    var urlListadoCgg_res_oficial_seguimiento=URL_WS+"Cgg_res_oficial_seguimiento";
    var tituloListadoCgg_res_oficial_seguimiento='Oficiales de seguimiento';
    var descListadoCgg_res_oficial_seguimiento='El formulario permite administrar informaci\u00f3n de las personas encargadas de realizar seguimiento.';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_oficial_seguimiento.
     */
    var btnNuevoCgg_res_oficial_seguimiento = new Ext.Button({
        id:'btnNuevoCgg_res_oficial_seguimiento',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_oficial_seguimiento = new FrmCgg_res_oficial_seguimiento("insert");
                objCgg_res_oficial_seguimiento.closeHandler(function(){
                    gsCgg_res_oficial_seguimiento.reload();
                });
                objCgg_res_oficial_seguimiento.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_oficial_seguimiento.
     */
    var btnEditarCgg_res_oficial_seguimiento = new Ext.Button({
        id:'btnEditarCgg_res_oficial_seguimiento',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_oficial_seguimiento.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_oficial_seguimiento = new FrmCgg_res_oficial_seguimiento("update",r);
                    objCgg_res_oficial_seguimiento.closeHandler(function(){
                        gsCgg_res_oficial_seguimiento.reload();
                    });
                    objCgg_res_oficial_seguimiento.loadData();
                    objCgg_res_oficial_seguimiento.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_oficial_seguimiento.
     */
    var btnEliminarCgg_res_oficial_seguimiento = new Ext.Button({
        id:'btnEliminarCgg_res_oficial_seguimiento',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_oficial_seguimiento,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_oficial_seguimiento(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_oficial_seguimiento(r){
                            winFrmListadoCgg_res_oficial_seguimiento.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_oficial_seguimiento,
                                    msg: 'La informaci\u00f3n del oficial seguimiento ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_oficial_seguimiento.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_oficial_seguimiento,
                                    msg: 'La informaci\u00f3n del oficial seguimiento no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_oficial_seguimiento.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrosg_codigo',grdCgg_res_oficial_seguimiento.getSelectionModel().getSelected().get('CROSG_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_oficial_seguimiento,"delete",param, true, CallBackCgg_res_oficial_seguimiento);
                    }catch(inErr){
                        winFrmListadoCgg_res_oficial_seguimiento.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_oficial_seguimiento.
     */
    var btnSalirCgg_res_oficial_seguimiento = new Ext.Button({
        id:'btnSalirCgg_res_oficial_seguimiento',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_oficial_seguimiento.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_oficial_seguimiento.
     */
    var checkColumn = new Ext.grid.CheckColumn({dataIndex:'CUSU_USUARIO_INTERNO',header:'Usuario interno',width:80,sortable:true});
    var checkColumn1 = new Ext.grid.CheckColumn({dataIndex:'CROSG_TIPO_OFICIAL',header:'Jefe seguimiento',width:80,sortable:true});
    var cmCgg_res_oficial_seguimiento = new Ext.grid.ColumnModel([
        {dataIndex:'CROSG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CUSU_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'NOMBRES',header:'Nombres',width:150,sortable:true},
        {dataIndex:'APELLIDOS',header:'Apellidos',width:150,sortable:true},
        {dataIndex:'CUSU_NOMBRE_USUARIO',header:'Nombre usuario',width:150,sortable:true},
        checkColumn,checkColumn1
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_oficial_seguimiento por un campo especifico.
     */
    var gsCgg_res_oficial_seguimiento = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_oficial_seguimiento",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CUSU_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CROSG_CODIGO'},
            {name:'CUSU_CODIGO'},
            {name:'NOMBRES'},
            {name:'APELLIDOS'},
            {name:'CUSU_NOMBRE_USUARIO'},
            {name:'CUSU_USUARIO_INTERNO'},
            {name:'CROSG_TIPO_OFICIAL'}
        ]),
        sortInfo:{field: 'CUSU_NOMBRE_USUARIO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_oficial_seguimiento.
     */
    var pgBarCgg_res_oficial_seguimiento= new Ext.PagingToolbar({
        store: gsCgg_res_oficial_seguimiento,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_oficial_seguimiento en un formato tabular de filas y columnas.
     */
    var grdCgg_res_oficial_seguimiento = new Ext.grid.GridPanel({
        cm:cmCgg_res_oficial_seguimiento,
        store:gsCgg_res_oficial_seguimiento,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_oficial_seguimiento,
                width:200
            })
        ],
        bbar:pgBarCgg_res_oficial_seguimiento,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_oficial_seguimiento.hidden){
                    btnEditarCgg_res_oficial_seguimiento.fireEvent('click', btnEditarCgg_res_oficial_seguimiento);
                }
            }}});
    gsCgg_res_oficial_seguimiento.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_oficial_seguimiento.
     */
    if(inDesktop){
        var winFrmListadoCgg_res_oficial_seguimiento = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_oficial_seguimiento',
            title:tituloListadoCgg_res_oficial_seguimiento,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_oficial_seguimiento,descListadoCgg_res_oficial_seguimiento),
            items:[grdCgg_res_oficial_seguimiento],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_oficial_seguimiento,btnEditarCgg_res_oficial_seguimiento,btnEliminarCgg_res_oficial_seguimiento,'->',btnSalirCgg_res_oficial_seguimiento]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_res_oficial_seguimiento.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_oficial_seguimiento.
     * @returns ventana winFrmCgg_res_oficial_seguimiento.
     * @base FrmListadoCgg_res_oficial_seguimiento.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_oficial_seguimiento;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_oficial_seguimiento.
     * @base FrmListadoCgg_res_oficial_seguimiento.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_oficial_seguimiento.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_oficial_seguimiento;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_oficial_seguimiento;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_oficial_seguimiento.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_oficial_seguimiento.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_oficial_seguimiento desde una instancia.
 */
FrmListadoCgg_res_oficial_seguimiento.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_oficial_seguimiento desde una instancia.
 */
FrmListadoCgg_res_oficial_seguimiento.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_oficial_seguimiento,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_oficial_seguimiento.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_oficial_seguimiento desde una instancia.
 */
FrmListadoCgg_res_oficial_seguimiento.prototype.loadData = function(){
    this.loadData();
}
