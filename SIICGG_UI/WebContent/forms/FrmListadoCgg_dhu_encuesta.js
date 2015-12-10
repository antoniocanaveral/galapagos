/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_encuesta.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_encuesta(inDesktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Curso/Encuestas/Encuesta';
    var urlListadoCgg_dhu_encuesta=URL_WS+"Cgg_dhu_encuesta";
    var tituloListadoCgg_dhu_encuesta='Encuestas';
    var descListadoCgg_dhu_encuesta='El formulario permite administrar informaci\u00f3n sobre las diferentes encuestas';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_encuesta.
     */
    var btnNuevoCgg_dhu_encuesta = new Ext.Button({
        id:'btnNuevoCgg_dhu_encuesta',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_dhu_encuesta = new FrmCgg_dhu_encuesta("insert");
                objCgg_dhu_encuesta.closeHandler(function(){
                    gsCgg_dhu_encuesta.reload();
                });
                objCgg_dhu_encuesta.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_encuesta.
     */
    var btnEditarCgg_dhu_encuesta = new Ext.Button({
        id:'btnEditarCgg_dhu_encuesta',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_dhu_encuesta.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_encuesta = new FrmCgg_dhu_encuesta("update",r);
                    objCgg_dhu_encuesta.closeHandler(function(){
                        gsCgg_dhu_encuesta.reload();
                    });
                    objCgg_dhu_encuesta.loadData();
                    objCgg_dhu_encuesta.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_encuesta.
     */
    var btnEliminarCgg_dhu_encuesta = new Ext.Button({
        id:'btnEliminarCgg_dhu_encuesta',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_encuesta,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_encuesta(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_encuesta(r){
                            winFrmListadoCgg_dhu_encuesta.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_encuesta,
                                    msg: 'La informaci\u00f3n de Encuesta ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_encuesta.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_encuesta,
                                    msg: 'La informaci\u00f3n de Encuesta no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_encuesta.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdenc_codigo',grdCgg_dhu_encuesta.getSelectionModel().getSelected().get('CDENC_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_encuesta,"delete",param, true, CallBackCgg_dhu_encuesta);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_encuesta.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_encuesta.
     */
    var btnSalirCgg_dhu_encuesta = new Ext.Button({
        id:'btnSalirCgg_dhu_encuesta',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_encuesta.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_encuesta.
     */
    var cmCgg_dhu_encuesta = new Ext.grid.ColumnModel([
        {dataIndex:'CDENC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true, hiddeable:false},
        {dataIndex:'CDENC_NOMBRE',header:'Nombre',width:150,sortable:true},
        {dataIndex:'CDENC_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_encuesta por un campo especifico.
     */
    var gsCgg_dhu_encuesta = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_encuesta",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDENC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDENC_CODIGO'},
            {name:'CDENC_NOMBRE'},
            {name:'CDENC_OBSERVACION'}
        ]),
        sortInfo:{field: 'CDENC_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_encuesta.
     */
    var pgBarCgg_dhu_encuesta= new Ext.PagingToolbar({
        store: gsCgg_dhu_encuesta,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_encuesta en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_encuesta = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_encuesta,
        store:gsCgg_dhu_encuesta,
        region:'center',
        viewConfig:{forceFit:true},
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_encuesta,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_encuesta,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_encuesta.hidden){
                    btnEditarCgg_dhu_encuesta.fireEvent('click', btnEditarCgg_dhu_encuesta);
                }
            }}});
    gsCgg_dhu_encuesta.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_encuesta.
     */
    if(inDesktop){
        var winFrmListadoCgg_dhu_encuesta = inDesktop.createWindow({
            id:'winFrmListadoCgg_dhu_encuesta',
            title:tituloListadoCgg_dhu_encuesta,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_encuesta,descListadoCgg_dhu_encuesta),
            items:[grdCgg_dhu_encuesta],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_dhu_encuesta,btnEditarCgg_dhu_encuesta,btnEliminarCgg_dhu_encuesta,'->',btnSalirCgg_dhu_encuesta]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_dhu_encuesta.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_encuesta.
     * @returns ventana winFrmCgg_dhu_encuesta.
     * @base FrmListadoCgg_dhu_encuesta.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_encuesta;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_encuesta.
     * @base FrmListadoCgg_dhu_encuesta.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_encuesta.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_encuesta;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_encuesta;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_encuesta.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_encuesta.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_encuesta desde una instancia.
 */
FrmListadoCgg_dhu_encuesta.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_encuesta desde una instancia.
 */
FrmListadoCgg_dhu_encuesta.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_encuesta,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_encuesta.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_encuesta desde una instancia.
 */
FrmListadoCgg_dhu_encuesta.prototype.loadData = function(){
    this.loadData();
}
