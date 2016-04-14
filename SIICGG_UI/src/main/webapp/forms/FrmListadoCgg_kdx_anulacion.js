/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_kdx_anulacion.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_kdx_anulacion(){
    var optMenu = 'Kardex/Anulaci\u00f3n';
    var urlListadoCgg_kdx_anulacion=URL_WS+"Cgg_kdx_anulacion";
    var tituloListadoCgg_kdx_anulacion='Anulaci\u00f3n de especies';
    var descListadoCgg_kdx_anulacion='El formulario permite administrar informaci\u00f3n de Anulaci\u00f3n de especies';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_kdx_anulacion.
     */
    var btnNuevoCgg_kdx_anulacion = new Ext.Button({
        id:'btnNuevoCgg_kdx_anulacion',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_kdx_anulacion = new FrmCgg_kdx_anulacion("insert");
                objCgg_kdx_anulacion.closeHandler(function(){
                    gsCgg_kdx_anulacion.reload();
                });
                objCgg_kdx_anulacion.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_kdx_anulacion.
     */
    var btnEditarCgg_kdx_anulacion = new Ext.Button({
        id:'btnEditarCgg_kdx_anulacion',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_kdx_anulacion.getSelectionModel().getSelected();
                if(r){
                    var objCgg_kdx_anulacion = new FrmCgg_kdx_anulacion("update",r);
                    objCgg_kdx_anulacion.closeHandler(function(){
                        gsCgg_kdx_anulacion.reload();
                    });
                    objCgg_kdx_anulacion.loadData();
                    objCgg_kdx_anulacion.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_kdx_anulacion.
     */
    var btnEliminarCgg_kdx_anulacion = new Ext.Button({
        id:'btnEliminarCgg_kdx_anulacion',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_kdx_anulacion,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_kdx_anulacion(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_kdx_anulacion(r){
                            winFrmListadoCgg_kdx_anulacion.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_anulacion,
                                    msg: 'La informaci\u00f3n de Anulaci\u00f3n de especies ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_kdx_anulacion.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_anulacion,
                                    msg: 'La informaci\u00f3n de Anulaci\u00f3n de especies no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_kdx_anulacion.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCkanl_codigo',grdCgg_kdx_anulacion.getSelectionModel().getSelected().get('CKANL_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_kdx_anulacion,"delete",param, true, CallBackCgg_kdx_anulacion);
                    }catch(inErr){
                        winFrmListadoCgg_kdx_anulacion.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_kdx_anulacion.
     */
    var btnSalirCgg_kdx_anulacion = new Ext.Button({
        id:'btnSalirCgg_kdx_anulacion',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_kdx_anulacion.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_anulacion.
     */
    var cmCgg_kdx_anulacion = new Ext.grid.ColumnModel([
        {dataIndex:'CKANL_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKASG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKUPV_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKANL_NUMERO_ANULACION',header:'Numero anulacion',width:150,sortable:true},
        {dataIndex:'CKANL_FECHA_ANULACION',header:'Fecha anulacion',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CKANL_CANTIDAD',header:'Cantidad',width:150,sortable:true},
        {dataIndex:'CKANL_PRECIO_UNITARIO',header:'Precio unitario',width:150,sortable:true},
        {dataIndex:'CKANL_PRECIO_TOTAL',header:'Precio total',width:150,sortable:true},
        {dataIndex:'CKANL_SERIE_INICIO',header:'Serie inicio',width:150,sortable:true},
        {dataIndex:'CKANL_SERIE_FIN',header:'Serie fin',width:150,sortable:true},
        {dataIndex:'CKANL_OBSERVACION',header:'Observacion',width:150,sortable:true,hidden:true},
        {dataIndex:'CKANL_JUSTIFICACION',header:'Justificacion',width:150,sortable:true,hidden:true},
        {dataIndex:'CKANL_TIPO_ANULACION',header:'Tipo anulacion',width:150,sortable:true,hidden:true},
        {dataIndex:'CKANL_ESTADO_ANULACION',header:'Estado anulacion',width:150,sortable:true,hidden:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_anulacion por un campo especifico.
     */
    var gsCgg_kdx_anulacion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_anulacion",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKANL_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CKANL_CODIGO'},
            {name:'CKASG_CODIGO'},
            {name:'CKUPV_CODIGO'},
            {name:'CKANL_NUMERO_ANULACION'},
            {name:'CKANL_FECHA_ANULACION'},
            {name:'CKANL_CANTIDAD'},
            {name:'CKANL_PRECIO_UNITARIO'},
            {name:'CKANL_PRECIO_TOTAL'},
            {name:'CKANL_SERIE_INICIO'},
            {name:'CKANL_SERIE_FIN'},
            {name:'CKANL_OBSERVACION'},
            {name:'CKANL_JUSTIFICACION'},
            {name:'CKANL_TIPO_ANULACION'},
            {name:'CKANL_ESTADO_ANULACION'}
        ]),
        sortInfo:{field: 'CKASG_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_kdx_anulacion.
     */
    var pgBarCgg_kdx_anulacion= new Ext.PagingToolbar({
        store: gsCgg_kdx_anulacion,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_anulacion en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_anulacion = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_anulacion,
        store:gsCgg_kdx_anulacion,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_kdx_anulacion,
                width:200
            })
        ],
        bbar:pgBarCgg_kdx_anulacion,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_kdx_anulacion.hidden){
                    btnEditarCgg_kdx_anulacion.fireEvent('click', btnEditarCgg_kdx_anulacion);
                }
            }}});
    gsCgg_kdx_anulacion.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_kdx_anulacion.
     */
    var winFrmListadoCgg_kdx_anulacion = new Ext.Window({
        id:'winFrmListadoCgg_kdx_anulacion',
        title:tituloListadoCgg_kdx_anulacion,
        iconCls:'iconAplicacion',
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_anulacion,descListadoCgg_kdx_anulacion),
        items:[grdCgg_kdx_anulacion],
        bbar:[btnNuevoCgg_kdx_anulacion,btnEditarCgg_kdx_anulacion,'->',btnSalirCgg_kdx_anulacion]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_kdx_anulacion.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_kdx_anulacion.
     * @returns ventana winFrmCgg_kdx_anulacion.
     * @base FrmListadoCgg_kdx_anulacion.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_kdx_anulacion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_kdx_anulacion.
     * @base FrmListadoCgg_kdx_anulacion.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_kdx_anulacion.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_kdx_anulacion;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_kdx_anulacion;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_kdx_anulacion.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_kdx_anulacion.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_kdx_anulacion desde una instancia.
 */
FrmListadoCgg_kdx_anulacion.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_kdx_anulacion desde una instancia.
 */
FrmListadoCgg_kdx_anulacion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_kdx_anulacion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_kdx_anulacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_kdx_anulacion desde una instancia.
 */
FrmListadoCgg_kdx_anulacion.prototype.loadData = function(){
    this.loadData();
}
