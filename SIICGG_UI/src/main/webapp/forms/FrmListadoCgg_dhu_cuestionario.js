/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_cuestionario.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_cuestionario(inDesktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Curso/Encuestas/Cuestionario';
    var urlListadoCgg_dhu_cuestionario=URL_WS+"Cgg_dhu_cuestionario";
    var tituloListadoCgg_dhu_cuestionario='Cuestionario';
    var descListadoCgg_dhu_cuestionario='El formulario permite administrar informaci\u00f3n sobre los diferentes cuestionarios';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_cuestionario.
     */
    var btnNuevoCgg_dhu_cuestionario = new Ext.Button({
        id:'btnNuevoCgg_dhu_cuestionario',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_dhu_cuestionario = new FrmCgg_dhu_cuestionario("insert");
                objCgg_dhu_cuestionario.closeHandler(function(){
                    gsCgg_dhu_cuestionario.reload();
                });
                objCgg_dhu_cuestionario.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_cuestionario.
     */
    var btnEditarCgg_dhu_cuestionario = new Ext.Button({
        id:'btnEditarCgg_dhu_cuestionario',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_dhu_cuestionario.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_cuestionario = new FrmCgg_dhu_cuestionario("update",r);
                    objCgg_dhu_cuestionario.closeHandler(function(){
                        gsCgg_dhu_cuestionario.reload();
                    });
                    objCgg_dhu_cuestionario.loadData();
                    objCgg_dhu_cuestionario.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_cuestionario.
     */
    var btnEliminarCgg_dhu_cuestionario = new Ext.Button({
        id:'btnEliminarCgg_dhu_cuestionario',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_cuestionario,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_cuestionario(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_cuestionario(r){
                            winFrmListadoCgg_dhu_cuestionario.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_cuestionario,
                                    msg: 'La informaci\u00f3n ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_cuestionario.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_cuestionario,
                                    msg: 'La informaci\u00f3n no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_cuestionario.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdenc_codigo',grdCgg_dhu_cuestionario.getSelectionModel().getSelected().get('CDENC_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_cuestionario,"delete",param, true, CallBackCgg_dhu_cuestionario);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_cuestionario.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_cuestionario.
     */
    var btnSalirCgg_dhu_cuestionario = new Ext.Button({
        id:'btnSalirCgg_dhu_cuestionario',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_cuestionario.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_cuestionario.
     */
    var cmCgg_dhu_cuestionario = new Ext.grid.ColumnModel([
        {dataIndex:'CDENC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CDENC_NOMBRE',header:'Encuesta',width:150,sortable:true,hidden:true},
        {dataIndex:'CDPRG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CDPRG_DESCRIPCION',header:'Descripci\u00f3n',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_cuestionario por un campo especifico.
     */
    var gsCgg_dhu_cuestionario = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_cuestionario",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({

            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDENC_CODIGO'},
            {name:'CDENC_NOMBRE'},
            {name:'CDPRG_CODIGO'},
            {name:'CDPRG_DESCRIPCION'},
			{name:'CDCST_CODIGO'}
        ]),
        sortInfo:{field: 'CDENC_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"},
        groupField:'CDENC_NOMBRE'
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_cuestionario.
     */
    var pgBarCgg_dhu_cuestionario= new Ext.PagingToolbar({
        store: gsCgg_dhu_cuestionario,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_cuestionario en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_cuestionario = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_cuestionario,
        store:gsCgg_dhu_cuestionario,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        view: new Ext.grid.GroupingView({
            forceFit:true,
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_cuestionario,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_cuestionario,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_cuestionario.hidden){
                    btnEditarCgg_dhu_cuestionario.fireEvent('click', btnEditarCgg_dhu_cuestionario);
                }
            }}});
    gsCgg_dhu_cuestionario.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_cuestionario.
     */
    if(inDesktop){
        var winFrmListadoCgg_dhu_cuestionario = inDesktop.createWindow({
            id:'winFrmListadoCgg_dhu_cuestionario',
            title:tituloListadoCgg_dhu_cuestionario,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_cuestionario,descListadoCgg_dhu_cuestionario),
            items:[grdCgg_dhu_cuestionario],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_dhu_cuestionario,btnEditarCgg_dhu_cuestionario,btnEliminarCgg_dhu_cuestionario,'->',btnSalirCgg_dhu_cuestionario]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_dhu_cuestionario.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_cuestionario.
     * @returns ventana winFrmCgg_dhu_cuestionario.
     * @base FrmListadoCgg_dhu_cuestionario.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_cuestionario;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_cuestionario.
     * @base FrmListadoCgg_dhu_cuestionario.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_cuestionario.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_cuestionario;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_cuestionario;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_cuestionario.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_cuestionario.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_cuestionario desde una instancia.
 */
FrmListadoCgg_dhu_cuestionario.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_cuestionario desde una instancia.
 */
FrmListadoCgg_dhu_cuestionario.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_cuestionario,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_cuestionario.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_cuestionario desde una instancia.
 */
FrmListadoCgg_dhu_cuestionario.prototype.loadData = function(){
    this.loadData();
}
