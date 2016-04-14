/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_seccion.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_seccion(inDesktop){
    var optMenu='Configuraci\u00F3n/Distrubuci\u00F3n departamental/Administraci\u00F3n secci\u00F3n';
    var urlListadoCgg_res_seccion=URL_WS+"Cgg_res_seccion";
    var tituloListadoCgg_res_seccion='Secci\u00f3n';
    var descListadoCgg_res_seccion='El formulario permite administrar informaci\u00f3n de las secciones del CGG.';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_seccion.
     */
    var btnNuevoCgg_res_seccion = new Ext.Button({
        id:'btnNuevoCgg_res_seccion',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_seccion = new FrmCgg_res_seccion("insert");
                objCgg_res_seccion.closeHandler(function(){
                    gsCgg_res_seccion.reload();
                });
                objCgg_res_seccion.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_seccion.
     */
    var btnEditarCgg_res_seccion = new Ext.Button({
        id:'btnEditarCgg_res_seccion',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_seccion.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_seccion = new FrmCgg_res_seccion("update",r);
                    objCgg_res_seccion.closeHandler(function(){
                        gsCgg_res_seccion.reload();
                    });
                    objCgg_res_seccion.loadData();
                    objCgg_res_seccion.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_seccion.
     */
    var btnEliminarCgg_res_seccion = new Ext.Button({
        id:'btnEliminarCgg_res_seccion',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_seccion,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_seccion(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_seccion(r){
                            winFrmListadoCgg_res_seccion.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_seccion,
                                    msg: 'La informaci\u00f3n de Res seccion ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_seccion.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_seccion,
                                    msg: 'La informaci\u00f3n de Res seccion no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_seccion.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrsec_codigo',grdCgg_res_seccion.getSelectionModel().getSelected().get('CRSEC_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_seccion,"delete",param, true, CallBackCgg_res_seccion);
                    }catch(inErr){
                        winFrmListadoCgg_res_seccion.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_seccion.
     */
    var btnSalirCgg_res_seccion = new Ext.Button({
        id:'btnSalirCgg_res_seccion',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_seccion.close();
            }}
    });
    /**
     * Ext.Button Boton para obtener reportes, general o individual.
     */var btnReporteCgg_res_seccion = new Ext.Button({
        id:'btnReporteCgg_res_seccion',
        name:'btnReporteCgg_res_seccion',
        text:'Reportes',
        iconCls:'iconImprimir',
        menu:[
            {text:'General',
                handler:function(){
                    window.open(URL_REPORTS_SERVER, 'JasperServer');
                }},{text:'Individual',
                handler:function(){
                    window.open(URL_REPORTS_SERVER, 'JasperServer');
                }}
        ]
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_seccion.
     */
    var cmCgg_res_seccion = new Ext.grid.ColumnModel([
        {dataIndex:'CRSEC_NOMBRE',header:'Nombre',width:350,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_seccion por un campo especifico.
     */
    var gsCgg_res_seccion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_seccion",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRSEC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRSEC_CODIGO'},
            {name:'CRSEC_NOMBRE'}
        ]),
        sortInfo:{field: 'CRSEC_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_seccion.
     */
    var pgBarCgg_res_seccion= new Ext.PagingToolbar({
        store: gsCgg_res_seccion,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_seccion en un formato tabular de filas y columnas.
     */
    var grdCgg_res_seccion = new Ext.grid.GridPanel({
        cm:cmCgg_res_seccion,
        store:gsCgg_res_seccion,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_seccion,
                width:200
            })
        ],
        bbar:pgBarCgg_res_seccion,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_seccion.disabled){
                    btnEditarCgg_res_seccion.fireEvent('click', btnEditarCgg_res_seccion);
                }
            }}});
    gsCgg_res_seccion.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_seccion.
     */
    var winFrmListadoCgg_res_seccion = null;
    
if(inDesktop!=null && inDesktop!=undefined){
    winFrmListadoCgg_res_seccion = inDesktop.createWindow({
        id:'winFrmListadoCgg_res_seccion',
        title:tituloListadoCgg_res_seccion,
        iconCls:'iconAplicacion',
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_seccion,descListadoCgg_res_seccion),
        items:[grdCgg_res_seccion],
        bbar:[btnNuevoCgg_res_seccion,btnEditarCgg_res_seccion,btnEliminarCgg_res_seccion,'-',btnReporteCgg_res_seccion,'->',btnSalirCgg_res_seccion]
    });
}else{
    winFrmListadoCgg_res_seccion = new Ext.Window({
        id:'winFrmListadoCgg_res_seccion',
        title:tituloListadoCgg_res_seccion,
        iconCls:'iconAplicacion',
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_seccion,descListadoCgg_res_seccion),
        items:[grdCgg_res_seccion],
        bbar:[btnNuevoCgg_res_seccion,btnEditarCgg_res_seccion,btnEliminarCgg_res_seccion,'-',btnReporteCgg_res_seccion,'->',btnSalirCgg_res_seccion]
    });
}
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_seccion.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_seccion.
     * @returns ventana winFrmCgg_res_seccion.
     * @base FrmListadoCgg_res_seccion.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_seccion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_seccion.
     * @base FrmListadoCgg_res_seccion.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_seccion.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_seccion;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_seccion;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_seccion.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_seccion.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_seccion desde una instancia.
 */
FrmListadoCgg_res_seccion.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_seccion desde una instancia.
 */
FrmListadoCgg_res_seccion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_seccion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_seccion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_seccion desde una instancia.
 */
FrmListadoCgg_res_seccion.prototype.loadData = function(){
    this.loadData();
}
