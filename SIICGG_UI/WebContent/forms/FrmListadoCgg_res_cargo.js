/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_cargo.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_cargo(){
    var optMenu='Configuraci\u00F3n/Distrubuci\u00F3n departamental/Administraci\u00F3n cargo';
    var urlListadoCgg_res_cargo=URL_WS+"Cgg_res_cargo";
    var tituloListadoCgg_res_cargo='Res cargo';
    var descListadoCgg_res_cargo='El formulario permite administrar informaci\u00f3n de la tabla Res cargo';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_cargo.
     */
    var btnNuevoCgg_res_cargo = new Ext.Button({
        id:'btnNuevoCgg_res_cargo',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_cargo = new FrmCgg_res_cargo("insert");
                objCgg_res_cargo.closeHandler(function(){
                    gsCgg_res_cargo.reload();
                });
                objCgg_res_cargo.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_cargo.
     */
    var btnEditarCgg_res_cargo = new Ext.Button({
        id:'btnEditarCgg_res_cargo',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_cargo.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_cargo = new FrmCgg_res_cargo("update",r);
                    objCgg_res_cargo.closeHandler(function(){
                        gsCgg_res_cargo.reload();
                    });
                    objCgg_res_cargo.loadData();
                    objCgg_res_cargo.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_cargo.
     */
    var btnEliminarCgg_res_cargo = new Ext.Button({
        id:'btnEliminarCgg_res_cargo',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_cargo,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_cargo(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_cargo(r){
                            winFrmListadoCgg_res_cargo.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_cargo,
                                    msg: 'La informaci\u00f3n de Res cargo ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_cargo.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_cargo,
                                    msg: 'La informaci\u00f3n de Res cargo no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_cargo.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrcrg_codigo',grdCgg_res_cargo.getSelectionModel().getSelected().get('CRCRG_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_cargo,"delete",param, true, CallBackCgg_res_cargo);
                    }catch(inErr){
                        winFrmListadoCgg_res_cargo.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_cargo.
     */
    var btnSalirCgg_res_cargo = new Ext.Button({
        id:'btnSalirCgg_res_cargo',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_cargo.close();
            }}
    });
    /**
     * Ext.Button Boton para obtener reportes, general o individual.
     */var btnReporteCgg_res_cargo = new Ext.Button({
        id:'btnReporteCgg_res_cargo',
        name:'btnReporteCgg_res_cargo',
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
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_cargo.
     */
    var cmCgg_res_cargo = new Ext.grid.ColumnModel([
        {dataIndex:'CRSEC_NOMBRE',header:'Seccion',width:150,sortable:true},
        {dataIndex:'CRCRG_NOMBRE',header:'Nombre',width:350,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_cargo por un campo especifico.
     */
    var gsCgg_res_cargo = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_cargo",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRCRG_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRCRG_CODIGO'},
            {name:'CRCRG_NOMBRE'},
            {name:'CRSEC_CODIGO'},
            {name:'CRSEC_NOMBRE'}
        ]),
        sortInfo:{field: 'CRCRG_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_cargo.
     */
    var pgBarCgg_res_cargo= new Ext.PagingToolbar({
        store: gsCgg_res_cargo,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_cargo en un formato tabular de filas y columnas.
     */
    var grdCgg_res_cargo = new Ext.grid.GridPanel({
        cm:cmCgg_res_cargo,
        store:gsCgg_res_cargo,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_cargo,
                width:200
            })
        ],
        bbar:pgBarCgg_res_cargo,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_cargo.disabled){
                    btnEditarCgg_res_cargo.fireEvent('click', btnEditarCgg_res_cargo);
                }
            }}});
    gsCgg_res_cargo.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_cargo.
     */
    var winFrmListadoCgg_res_cargo = new Ext.Window({
        id:'winFrmListadoCgg_res_cargo',
        title:tituloListadoCgg_res_cargo,
        iconCls:'iconAplicacion',
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_cargo,descListadoCgg_res_cargo),
        items:[grdCgg_res_cargo],
        bbar:[btnNuevoCgg_res_cargo,btnEditarCgg_res_cargo,btnEliminarCgg_res_cargo,'-',btnReporteCgg_res_cargo,'->',btnSalirCgg_res_cargo]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_cargo.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_cargo.
     * @returns ventana winFrmCgg_res_cargo.
     * @base FrmListadoCgg_res_cargo.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_cargo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_cargo.
     * @base FrmListadoCgg_res_cargo.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_cargo.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_cargo;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_cargo;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_cargo.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_cargo.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_cargo desde una instancia.
 */
FrmListadoCgg_res_cargo.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_cargo desde una instancia.
 */
FrmListadoCgg_res_cargo.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_cargo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_cargo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_cargo desde una instancia.
 */
FrmListadoCgg_res_cargo.prototype.loadData = function(){
    this.loadData();
}
