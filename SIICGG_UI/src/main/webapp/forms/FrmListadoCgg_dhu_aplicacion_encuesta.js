/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_aplicacion_encuesta.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_aplicacion_encuesta(inDesktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Curso/Encuestas/Aplicaci\u00F3n encuesta';
    var urlListadoCgg_dhu_aplicacion_encuesta=URL_WS+"Cgg_dhu_aplicacion_encuesta";
    var tituloListadoCgg_dhu_aplicacion_encuesta='Aplicaci\u00f3n Encuesta';
    var descListadoCgg_dhu_aplicacion_encuesta='El formulario permite administrar informaci\u00f3n de la Aplicaci\u00f3n Encuesta';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_aplicacion_encuesta.
     */
    var btnNuevoCgg_dhu_aplicacion_encuesta = new Ext.Button({
        id:'btnNuevoCgg_dhu_aplicacion_encuesta',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_dhu_aplicacion_encuesta = new FrmCgg_dhu_aplicacion_encuesta("insert");
                objCgg_dhu_aplicacion_encuesta.closeHandler(function(){
                    gsCgg_dhu_aplicacion_encuesta.reload();
                });
                objCgg_dhu_aplicacion_encuesta.show();
            }}
    });
    /**
     * Ext.Button Boton que permite consultar el registro de la encuesta.
     */
    var btnNuevoCgg_dhu_registro_encuesta = new Ext.Button({
        id:'btnNuevoCgg_dhu_registro_encuesta',
        text:'Encuestas aplicadas',
        //iconCls:'iconNuevo',
        tooltip:'Encuestas aplicadas',
        listeners:{
            click:function(){
                var objCgg_dhu_registro_encuesta = new FrmListadoCgg_dhu_registro_encuesta(inDesktop);               
                objCgg_dhu_registro_encuesta.show();
            }}
    });
    
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_aplicacion_encuesta.
     */
    var btnEliminarCgg_dhu_aplicacion_encuesta = new Ext.Button({
        id:'btnEliminarCgg_dhu_aplicacion_encuesta',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_aplicacion_encuesta,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_aplicacion_encuesta(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_aplicacion_encuesta(r){
                            winFrmListadoCgg_dhu_aplicacion_encuesta.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_aplicacion_encuesta,
                                    msg: 'La informaci\u00f3n de Dhu aplicacion encuesta ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_aplicacion_encuesta.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_aplicacion_encuesta,
                                    msg: 'La informaci\u00f3n de Cgg_dhu_aplicacion_encuesta no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_aplicacion_encuesta.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdape_codigo',grdCgg_dhu_aplicacion_encuesta.getSelectionModel().getSelected().get('CDAPE_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_aplicacion_encuesta,"delete",param, true, CallBackCgg_dhu_aplicacion_encuesta);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_aplicacion_encuesta.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_aplicacion_encuesta.
     */
    var btnSalirCgg_dhu_aplicacion_encuesta = new Ext.Button({
        id:'btnSalirCgg_dhu_aplicacion_encuesta',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_aplicacion_encuesta.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_aplicacion_encuesta.
     */
    var cmCgg_dhu_aplicacion_encuesta = new Ext.grid.ColumnModel([
        {dataIndex:'CDAPE_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCRE_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDENC_NOMBRE',header:'Encuesta',width:150,sortable:true},
        {dataIndex:'CDAPE_FECHA',header:'Fecha',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CDAPE_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_aplicacion_encuesta por un campo especifico.
     */
    var gsCgg_dhu_aplicacion_encuesta = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_aplicacion_encuesta",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDAPE_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDAPE_CODIGO'},
            {name:'CDCRE_CODIGO'},
            {name:'CDENC_NOMBRE'},
            {name:'CDAPE_FECHA'},
            {name:'CDAPE_OBSERVACION'}
        ]),
        sortInfo:{field: 'CDCRE_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_aplicacion_encuesta.
     */
    var pgBarCgg_dhu_aplicacion_encuesta= new Ext.PagingToolbar({
        store: gsCgg_dhu_aplicacion_encuesta,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_aplicacion_encuesta en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_aplicacion_encuesta = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_aplicacion_encuesta,
        store:gsCgg_dhu_aplicacion_encuesta,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_aplicacion_encuesta,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_aplicacion_encuesta
       /* listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_aplicacion_encuesta.disabled){
                    btnEditarCgg_dhu_aplicacion_encuesta.fireEvent('click', btnEditarCgg_dhu_aplicacion_encuesta);
                }
            }}*/});
    gsCgg_dhu_aplicacion_encuesta.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_aplicacion_encuesta.
     */
     if(inDesktop){
        var winFrmListadoCgg_dhu_aplicacion_encuesta = inDesktop.createWindow({

        id:'winFrmListadoCgg_dhu_aplicacion_encuesta',
        title:tituloListadoCgg_dhu_aplicacion_encuesta,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_aplicacion_encuesta,descListadoCgg_dhu_aplicacion_encuesta),
        items:[grdCgg_dhu_aplicacion_encuesta],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_dhu_aplicacion_encuesta,btnEliminarCgg_dhu_aplicacion_encuesta,btnNuevoCgg_dhu_registro_encuesta,'->',btnSalirCgg_dhu_aplicacion_encuesta]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_dhu_aplicacion_encuesta.getBottomToolbar());
     }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_aplicacion_encuesta.
     * @returns ventana winFrmCgg_dhu_aplicacion_encuesta.
     * @base FrmListadoCgg_dhu_aplicacion_encuesta.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_aplicacion_encuesta;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_aplicacion_encuesta.
     * @base FrmListadoCgg_dhu_aplicacion_encuesta.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_aplicacion_encuesta.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_aplicacion_encuesta;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_aplicacion_encuesta;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_aplicacion_encuesta.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_aplicacion_encuesta.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_aplicacion_encuesta desde una instancia.
 */
FrmListadoCgg_dhu_aplicacion_encuesta.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_aplicacion_encuesta desde una instancia.
 */
FrmListadoCgg_dhu_aplicacion_encuesta.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_aplicacion_encuesta,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_aplicacion_encuesta.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_aplicacion_encuesta desde una instancia.
 */
FrmListadoCgg_dhu_aplicacion_encuesta.prototype.loadData = function(){
    this.loadData();
}
