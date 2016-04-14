/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_prestamo_expediente.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_prestamo_expediente_ingreso(){
    var urlListadoCgg_res_prestamo_expediente_ingreso=URL_WS+"Cgg_res_prestamo_expediente";
    var tituloListadoCgg_res_prestamo_expediente_ingreso='Lista de expedientes ingresados';
    var descListadoCgg_res_prestamo_expediente='Formulario que permite consultar los expedientes en prestamo';

    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_prestamo_expediente.
     */
    var btnEliminarCgg_res_prestamo_expediente_ingreso = new Ext.Button({
        id:'btnEliminarCgg_res_prestamo_expediente',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_prestamo_expediente,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_prestamo_expediente(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_prestamo_expediente_ingreso(r){
                            winFrmListadoCgg_res_prestamo_expediente_ingreso.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_prestamo_expediente_ingreso,
                                    msg: 'La informaci\u00f3n de Res prestamo expediente ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_prestamo_expediente_ingreso.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_prestamo_expediente_ingreso,
                                    msg: 'La informaci\u00f3n de Res prestamo expediente no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_prestamo_expediente_ingreso.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrpex_codigo',grdCgg_res_prestamo_expediente_ingreso.getSelectionModel().getSelected().get('CRPEX_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_prestamo_expediente_ingreso,"delete",param, true, CallBackCgg_res_prestamo_expediente_ingreso);
                    }catch(inErr){
                        winFrmListadoCgg_res_prestamo_expediente_ingreso.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_prestamo_expediente.
     */
    var btnSalirCgg_res_prestamo_expediente_ingreso = new Ext.Button({
        id:'btnSalirCgg_res_prestamo_expediente_ingreso',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_prestamo_expediente_ingreso.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_prestamo_expediente.
     */
    var cmCgg_res_prestamo_expediente_ingreso = new Ext.grid.ColumnModel([
        {dataIndex:'CRPEX_CODIGO',hidden:true,header:'Codigo',width:150,sortable:true},
        {dataIndex:'CUSU_CODIGO',hidden:true,header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRPER_CODIGO',hidden:true,header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRPER_NUMERO_EXPEDIENTE',header:'N° expediente',width:150,sortable:true},
        {dataIndex:'CRPER_NOMBRE_RECIBE',header:'Solicitante',width:150,sortable:true},
        {dataIndex:'CGG_CRPER_CODIGO',hidden:true,header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRPER_NOMBRE_ENTREGA',header:'Entrega',width:150,sortable:true},
        {dataIndex:'CRPEX_FECHA_OPERACION',header:'Fecha Ingreso',width:150,sortable:true},
        {dataIndex:'CRPEX_MOVIMIENTO',hidden:true,header:'Movimiento',width:150,sortable:true},
        {dataIndex:'CRPEX_OBSERVACION',header:'Observacion',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_prestamo_expediente por un campo especifico.
     */
    var gsCgg_res_prestamo_expediente_ingreso = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_prestamo_expediente",
            method:"selectPrestacionExpeIngreso",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPEX_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRPEX_CODIGO'},
            {name:'CUSU_CODIGO'},
            {name:'CRPER_CODIGO'},
            {name:'CRPER_NOMBRE_RECIBE'},
            {name:'CGG_CRPER_CODIGO'},
            {name:'CRPER_NOMBRE_ENTREGA'},
           {name:'CRPER_NUMERO_EXPEDIENTE'},
            {name:'CRPEX_FECHA_OPERACION'},
            {name:'CRPEX_MOVIMIENTO'},
            {name:'CRPEX_OBSERVACION'}
        ]),
        sortInfo:{field: 'CUSU_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_prestamo_expediente.
     */
    var pgBarCgg_res_prestamo_expediente_ingreso= new Ext.PagingToolbar({
        store: gsCgg_res_prestamo_expediente_ingreso,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_prestamo_expediente en un formato tabular de filas y columnas.
     */
    var grdCgg_res_prestamo_expediente_ingreso = new Ext.grid.GridPanel({
        cm:cmCgg_res_prestamo_expediente_ingreso,
        store:gsCgg_res_prestamo_expediente_ingreso,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_prestamo_expediente_ingreso,
                width:200
            })
        ],
        bbar:pgBarCgg_res_prestamo_expediente_ingreso
       });
    gsCgg_res_prestamo_expediente_ingreso.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_prestamo_expediente.
     */
    var winFrmListadoCgg_res_prestamo_expediente_ingreso = new Ext.Window({
        id:'winFrmListadoCgg_res_prestamo_expediente_ingreso',
        title:tituloListadoCgg_res_prestamo_expediente_ingreso,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo(''+tituloListadoCgg_res_prestamo_expediente_ingreso,descListadoCgg_res_prestamo_expediente),
        items:[grdCgg_res_prestamo_expediente_ingreso],
        bbar:[btnEliminarCgg_res_prestamo_expediente_ingreso,'->',btnSalirCgg_res_prestamo_expediente_ingreso]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_prestamo_expediente_ingreso.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_prestamo_expediente.
     * @returns ventana winFrmCgg_res_prestamo_expediente.
     * @base FrmListadoCgg_res_prestamo_expediente_ingreso.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_prestamo_expediente_ingreso;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_prestamo_expediente.
     * @base FrmListadoCgg_res_prestamo_expediente_ingreso.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_prestamo_expediente_ingreso.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_prestamo_expediente_ingreso;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_prestamo_expediente_ingreso;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_prestamo_expediente_ingreso.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_prestamo_expediente_ingreso.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_prestamo_expediente desde una instancia.
 */
FrmListadoCgg_res_prestamo_expediente_ingreso.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_prestamo_expediente desde una instancia.
 */
FrmListadoCgg_res_prestamo_expediente_ingreso.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_prestamo_expediente,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_prestamo_expediente_ingreso.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_prestamo_expediente desde una instancia.
 */
FrmListadoCgg_res_prestamo_expediente_ingreso.prototype.loadData = function(){
    this.loadData();
}
