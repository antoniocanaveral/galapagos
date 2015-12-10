/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_respuesta.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_respuesta(inDesktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Curso/Encuestas/Respuesta';
    var urlListadoCgg_dhu_respuesta=URL_WS+"Cgg_dhu_respuesta";
    var tituloListadoCgg_dhu_respuesta='Respuesta';
    var descListadoCgg_dhu_respuesta='El formulario permite administrar informaci\u00f3n sobre las diferentes respuestas que se pueden asignar a las preguntas';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_respuesta.
     */
    var btnNuevoCgg_dhu_respuesta = new Ext.Button({
        id:'btnNuevoCgg_dhu_respuesta',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_dhu_respuesta = new FrmCgg_dhu_respuesta("insert");
                objCgg_dhu_respuesta.closeHandler(function(){
                    gsCgg_dhu_respuesta.reload();
                });
                objCgg_dhu_respuesta.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_respuesta.
     */
    var btnEditarCgg_dhu_respuesta = new Ext.Button({
        id:'btnEditarCgg_dhu_respuesta',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_dhu_respuesta.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_respuesta = new FrmCgg_dhu_respuesta("update",r);
                    objCgg_dhu_respuesta.closeHandler(function(){
                        gsCgg_dhu_respuesta.reload();
                    });
                    objCgg_dhu_respuesta.loadData();
                    objCgg_dhu_respuesta.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_respuesta.
     */
    var btnEliminarCgg_dhu_respuesta = new Ext.Button({
        id:'btnEliminarCgg_dhu_respuesta',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_respuesta,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_respuesta(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_respuesta(r){
                            winFrmListadoCgg_dhu_respuesta.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_respuesta,
                                    msg: 'La informaci\u00f3n de Respuesta ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_respuesta.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_respuesta,
                                    msg: 'La informaci\u00f3n de Respuesta no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_respuesta.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdres_codigo',grdCgg_dhu_respuesta.getSelectionModel().getSelected().get('CDRES_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_respuesta,"delete",param, true, CallBackCgg_dhu_respuesta);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_respuesta.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_respuesta.
     */
    var btnSalirCgg_dhu_respuesta = new Ext.Button({
        id:'btnSalirCgg_dhu_respuesta',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_respuesta.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_respuesta.
     */
    var cmCgg_dhu_respuesta = new Ext.grid.ColumnModel([
        {dataIndex:'CDRES_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true, hiddeable:false},
        {dataIndex:'CDRES_DESCRIPCION',header:'Descripci\u00f3n',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_respuesta por un campo especifico.
     */
    var gsCgg_dhu_respuesta = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_respuesta",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDRES_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDRES_CODIGO'},
            {name:'CDRES_DESCRIPCION'}
        ]),
        sortInfo:{field: 'CDRES_DESCRIPCION', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_respuesta.
     */
    var pgBarCgg_dhu_respuesta= new Ext.PagingToolbar({
        store: gsCgg_dhu_respuesta,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_respuesta en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_respuesta = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_respuesta,
        store:gsCgg_dhu_respuesta,
        region:'center',
        viewConfig:{forceFit:true},       
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_respuesta,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_respuesta,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_respuesta.hidden){
                    btnEditarCgg_dhu_respuesta.fireEvent('click', btnEditarCgg_dhu_respuesta);
                }
            }}});
    gsCgg_dhu_respuesta.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_respuesta.
     */
    if(inDesktop){
        var winFrmListadoCgg_dhu_respuesta = inDesktop.createWindow({
            id:'winFrmListadoCgg_dhu_respuesta',
            title:tituloListadoCgg_dhu_respuesta,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_respuesta,descListadoCgg_dhu_respuesta),
            items:[grdCgg_dhu_respuesta],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_dhu_respuesta,btnEditarCgg_dhu_respuesta,btnEliminarCgg_dhu_respuesta,'->',btnSalirCgg_dhu_respuesta]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_dhu_respuesta.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_respuesta.
     * @returns ventana winFrmCgg_dhu_respuesta.
     * @base FrmListadoCgg_dhu_respuesta.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_respuesta;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_respuesta.
     * @base FrmListadoCgg_dhu_respuesta.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_respuesta.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_respuesta;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_respuesta;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_respuesta.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_respuesta.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_respuesta desde una instancia.
 */
FrmListadoCgg_dhu_respuesta.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_respuesta desde una instancia.
 */
FrmListadoCgg_dhu_respuesta.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_respuesta,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_respuesta.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_respuesta desde una instancia.
 */
FrmListadoCgg_dhu_respuesta.prototype.loadData = function(){
    this.loadData();
}
