/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_categoria.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_categoria(inDesktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Curso/Encuestas/Categor\u00EDa';
    var urlListadoCgg_dhu_categoria=URL_WS+"Cgg_dhu_categoria";
    var tituloListadoCgg_dhu_categoria='Categor\u00eda';
    var descListadoCgg_dhu_categoria='El formulario permite administrar informaci\u00f3n sobre las categor\u00EDas de un cuestionario de preguntas';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_categoria.
     */
    var btnNuevoCgg_dhu_categoria = new Ext.Button({
        id:'btnNuevoCgg_dhu_categoria',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_dhu_categoria = new FrmCgg_dhu_categoria("insert");
                objCgg_dhu_categoria.closeHandler(function(){
                    gsCgg_dhu_categoria.reload();
                });
                objCgg_dhu_categoria.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_categoria.
     */
    var btnEditarCgg_dhu_categoria = new Ext.Button({
        id:'btnEditarCgg_dhu_categoria',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_dhu_categoria.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_categoria = new FrmCgg_dhu_categoria("update",r);
                    objCgg_dhu_categoria.closeHandler(function(){
                        gsCgg_dhu_categoria.reload();
                    });
                    objCgg_dhu_categoria.loadData();
                    objCgg_dhu_categoria.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_categoria.
     */
    var btnEliminarCgg_dhu_categoria = new Ext.Button({
        id:'btnEliminarCgg_dhu_categoria',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'\u00BFSeguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_categoria,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_categoria(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_categoria(r){
                            winFrmListadoCgg_dhu_categoria.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_categoria,
                                    msg: 'La informaci\u00f3n de Categor\u00eda ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_categoria.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_categoria,
                                    msg: 'La informaci\u00f3n de Categor\u00eda no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_categoria.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdcat_codigo',grdCgg_dhu_categoria.getSelectionModel().getSelected().get('CDCAT_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_categoria,"delete",param, true, CallBackCgg_dhu_categoria);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_categoria.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_categoria.
     */
    var btnSalirCgg_dhu_categoria = new Ext.Button({
        id:'btnSalirCgg_dhu_categoria',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_categoria.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_categoria.
     */
    var cmCgg_dhu_categoria = new Ext.grid.ColumnModel([
        {dataIndex:'CDCAT_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true, hideable:false},
        {dataIndex:'CGG_CDCAT_CODIGO',header:'Cdcat_codigo',width:150,sortable:true, hidden:true, hideable:false},
        {dataIndex:'SUB_CATEGORIA',header:'Categor\u00EDa',width:150,sortable:true},
        {dataIndex:'CDCAT_NOMBRE',header:'Nombre',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_categoria por un campo especifico.
     */
    var gsCgg_dhu_categoria = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_categoria",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDCAT_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDCAT_CODIGO'},
            {name:'CGG_CDCAT_CODIGO'},
            {name:'SUB_CATEGORIA'},
            {name:'CDCAT_NOMBRE'}
        ]),
        groupField:'SUB_CATEGORIA',
        sortInfo: {
            field: 'SUB_CATEGORIA',
            direction: 'ASC'
        },
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_categoria.
     */
    var pgBarCgg_dhu_categoria= new Ext.PagingToolbar({
        store: gsCgg_dhu_categoria,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_categoria en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_categoria = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_categoria,
        store:gsCgg_dhu_categoria,
        region:'center',
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})',forceFit:true
        }),
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_categoria,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_categoria,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_categoria.hidden){
                    btnEditarCgg_dhu_categoria.fireEvent('click', btnEditarCgg_dhu_categoria);
                }
            }}});
    gsCgg_dhu_categoria.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_categoria.
     */
    if(inDesktop){
        var winFrmListadoCgg_dhu_categoria = inDesktop.createWindow({
            id:'winFrmListadoCgg_dhu_categoria',
            title:tituloListadoCgg_dhu_categoria,
            iconCls:'iconAplicacion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_categoria,descListadoCgg_dhu_categoria),
            items:[grdCgg_dhu_categoria],
            bbar:[btnNuevoCgg_dhu_categoria,btnEditarCgg_dhu_categoria,btnEliminarCgg_dhu_categoria,'->',btnSalirCgg_dhu_categoria]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_dhu_categoria.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_categoria.
     * @returns ventana winFrmCgg_dhu_categoria.
     * @base FrmListadoCgg_dhu_categoria.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_categoria;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_categoria.
     * @base FrmListadoCgg_dhu_categoria.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_categoria.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_categoria;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_categoria;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_categoria.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_categoria.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_categoria desde una instancia.
 */
FrmListadoCgg_dhu_categoria.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_categoria desde una instancia.
 */
FrmListadoCgg_dhu_categoria.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_categoria,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_categoria.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_categoria desde una instancia.
 */
FrmListadoCgg_dhu_categoria.prototype.loadData = function(){
    this.loadData();
}
