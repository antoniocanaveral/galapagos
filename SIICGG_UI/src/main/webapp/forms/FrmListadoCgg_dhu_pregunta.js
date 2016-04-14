/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_pregunta.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_pregunta(inDesktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Curso/Encuestas/Pregunta';
    var urlListadoCgg_dhu_pregunta=URL_WS+"Cgg_dhu_pregunta";
    var tituloListadoCgg_dhu_pregunta='Preguntas';
    var descListadoCgg_dhu_pregunta='El formulario permite administrar informaci\u00f3n sobre las preguntas';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_pregunta.
     */
    var btnNuevoCgg_dhu_pregunta = new Ext.Button({
        id:'btnNuevoCgg_dhu_pregunta',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_dhu_pregunta = new FrmCgg_dhu_pregunta("insert");
                objCgg_dhu_pregunta.closeHandler(function(){
                    gsCgg_dhu_pregunta.reload();
                });
                objCgg_dhu_pregunta.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_pregunta.
     */
    var btnEditarCgg_dhu_pregunta = new Ext.Button({
        id:'btnEditarCgg_dhu_pregunta',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_dhu_pregunta.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_pregunta = new FrmCgg_dhu_pregunta("update",r);
                    objCgg_dhu_pregunta.closeHandler(function(){
                        gsCgg_dhu_pregunta.reload();
                    });
                    objCgg_dhu_pregunta.loadData();
                    objCgg_dhu_pregunta.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_pregunta.
     */
    var btnEliminarCgg_dhu_pregunta = new Ext.Button({
        id:'btnEliminarCgg_dhu_pregunta',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_pregunta,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_pregunta(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_pregunta(r){
                            winFrmListadoCgg_dhu_pregunta.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_pregunta,
                                    msg: 'La informaci\u00f3n sobre la pregunta ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_pregunta.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_pregunta,
                                    msg: 'La informaci\u00f3n sobre la pregunta no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_pregunta.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdprg_codigo',grdCgg_dhu_pregunta.getSelectionModel().getSelected().get('CDPRG_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_pregunta,"delete",param, true, CallBackCgg_dhu_pregunta);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_pregunta.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_pregunta.
     */
    var btnSalirCgg_dhu_pregunta = new Ext.Button({
        id:'btnSalirCgg_dhu_pregunta',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_pregunta.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_pregunta.
     */
    var chkCdprg_cuantificable = new Ext.grid.CheckColumn({
		dataIndex:'CDPRG_CUANTIFICABLE',header:'Cuantificable',width:150,sortable:true}
	);
    var chkCdprg_multiple = new Ext.grid.CheckColumn(
		{dataIndex:'CDPRG_MULTIPLE',header:'Selecci\u00f3n M\u00faltiple',width:150,sortable:true}
	);
    var cmCgg_dhu_pregunta = new Ext.grid.ColumnModel([
        {dataIndex:'CDPRG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CDCAT_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CDCAT_NOMBRE',header:'Categor\u00EDa',width:150,sortable:true,hidden:true},
        {dataIndex:'CDPRG_DESCRIPCION',header:'Pregunta',width:150,sortable:true},
        chkCdprg_cuantificable,
        chkCdprg_multiple]
	);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_pregunta por un campo especifico.
     */
    var gsCgg_dhu_pregunta = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_pregunta",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDPRG_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDPRG_CODIGO'},
            {name:'CDCAT_CODIGO'},
            {name:'CDCAT_NOMBRE'},
            {name:'CDPRG_DESCRIPCION'},
            {name:'CDPRG_CUANTIFICABLE'},
            {name:'CDPRG_MULTIPLE'}
        ]),
        groupField:'CDCAT_NOMBRE',
        sortInfo: {
            field: 'CDCAT_NOMBRE',
            direction: 'ASC'
        },
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_pregunta.
     */
    var pgBarCgg_dhu_pregunta= new Ext.PagingToolbar({
        store: gsCgg_dhu_pregunta,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_pregunta en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_pregunta = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_pregunta,
        store:gsCgg_dhu_pregunta,
        region:'center',

        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})',forceFit:true
        }),
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_pregunta,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_pregunta,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_pregunta.hidden){
                    btnEditarCgg_dhu_pregunta.fireEvent('click', btnEditarCgg_dhu_pregunta);
                }
            }}});
    gsCgg_dhu_pregunta.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_pregunta.
     */
    if(inDesktop){
        var winFrmListadoCgg_dhu_pregunta = inDesktop.createWindow({
            id:'winFrmListadoCgg_dhu_pregunta',
            title:tituloListadoCgg_dhu_pregunta,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_pregunta,descListadoCgg_dhu_pregunta),
            items:[grdCgg_dhu_pregunta],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_dhu_pregunta,btnEditarCgg_dhu_pregunta,btnEliminarCgg_dhu_pregunta,'->',btnSalirCgg_dhu_pregunta]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_dhu_pregunta.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_pregunta.
     * @returns ventana winFrmCgg_dhu_pregunta.
     * @base FrmListadoCgg_dhu_pregunta.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_pregunta;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_pregunta.
     * @base FrmListadoCgg_dhu_pregunta.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_pregunta.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_pregunta;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_pregunta;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_pregunta.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_pregunta.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_pregunta desde una instancia.
 */
FrmListadoCgg_dhu_pregunta.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_pregunta desde una instancia.
 */
FrmListadoCgg_dhu_pregunta.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_pregunta,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_pregunta.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_pregunta desde una instancia.
 */
FrmListadoCgg_dhu_pregunta.prototype.loadData = function(){
    this.loadData();
}
