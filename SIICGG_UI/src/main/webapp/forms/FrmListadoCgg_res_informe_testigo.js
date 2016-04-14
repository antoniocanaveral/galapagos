/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_informe_testigo.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_informe_testigo(){
    var urlListadoCgg_res_informe_testigo=URL_WS+"Cgg_res_informe_testigo";
    var tituloListadoCgg_res_informe_testigo='Informe Testigo';
    var descListadoCgg_res_informe_testigo='El formulario permite administrar informaci\u00f3n del Informe Testigo';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_informe_testigo.
     */
    var btnNuevoCgg_res_informe_testigo = new Ext.Button({
        id:'btnNuevoCgg_res_informe_testigo',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_informe_testigo = new FrmCgg_res_informe_testigo("insert");
                objCgg_res_informe_testigo.closeHandler(function(){
                    gsCgg_res_informe_testigo.reload();
                });
                objCgg_res_informe_testigo.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_informe_testigo.
     */
    var btnEditarCgg_res_informe_testigo = new Ext.Button({
        id:'btnEditarCgg_res_informe_testigo',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_informe_testigo.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_informe_testigo = new FrmCgg_res_informe_testigo("update",r);
                    objCgg_res_informe_testigo.loadTestigo(grdCgg_res_informe_testigo.getSelectionModel().getSelected().get('CRINT_CODIGO'));
                    objCgg_res_informe_testigo.closeHandler(function(){
                        gsCgg_res_informe_testigo.reload();
                    });
                    objCgg_res_informe_testigo.loadData();
                    objCgg_res_informe_testigo.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_informe_testigo.
     */
    var btnEliminarCgg_res_informe_testigo = new Ext.Button({
        id:'btnEliminarCgg_res_informe_testigo',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_informe_testigo,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_informe_testigo(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_informe_testigo(r){
                            winFrmListadoCgg_res_informe_testigo.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_informe_testigo,
                                    msg: 'La informaci\u00f3n del Informe Testigo ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_informe_testigo.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_informe_testigo,
                                    msg: 'La informaci\u00f3n delInforme Testigo no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_informe_testigo.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrint_codigo',grdCgg_res_informe_testigo.getSelectionModel().getSelected().get('CRINT_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_informe_testigo,"delete",param, true, CallBackCgg_res_informe_testigo);
                    }catch(inErr){
                        winFrmListadoCgg_res_informe_testigo.getEl().unmask();
                    }}}
            }}
    });
   
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_informe_testigo.
     */
    var btnSalirCgg_res_informe_testigo = new Ext.Button({
        id:'btnSalirCgg_res_informe_testigo',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_informe_testigo.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_informe_testigo.
     */
    var cmCgg_res_informe_testigo = new Ext.grid.ColumnModel([
        {dataIndex:'CRINT_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true},
        {dataIndex:'CRMTR_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true},
        {dataIndex:'CRINT_NUMERO',header:'N\u00famero',width:150,sortable:true},
        {dataIndex:'CRINT_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true,width:300}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_informe_testigo por un campo especifico.
     */
    var gsCgg_res_informe_testigo = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_informe_testigo",
            method:"selectMatrimonio",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRINT_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRINT_CODIGO'},
            {name:'CRMTR_CODIGO'},
            {name:'CRINT_NUMERO'},
            {name:'CRINT_OBSERVACION'}
        ]),
        sortInfo:{field: 'CRMTR_CODIGO', direction: 'ASC'},
        baseParams:{keyword:'',inCrmtr_codigo:'',format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_informe_testigo.
     */
    var pgBarCgg_res_informe_testigo= new Ext.PagingToolbar({
        store: gsCgg_res_informe_testigo,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_informe_testigo en un formato tabular de filas y columnas.
     */
    var grdCgg_res_informe_testigo = new Ext.grid.GridPanel({
        cm:cmCgg_res_informe_testigo,
        store:gsCgg_res_informe_testigo,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
         viewConfig:{forceFit:true},
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_informe_testigo,
                width:200
            })
        ],
        bbar:pgBarCgg_res_informe_testigo,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_informe_testigo.hidden){
                    btnEditarCgg_res_informe_testigo.fireEvent('click', btnEditarCgg_res_informe_testigo);
                }
            }}});
    gsCgg_res_informe_testigo.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });

    

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_informe_testigo.
     */
    var winFrmListadoCgg_res_informe_testigo = new Ext.Window({
        id:'winFrmListadoCgg_res_informe_testigo',
        title:tituloListadoCgg_res_informe_testigo,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_informe_testigo,descListadoCgg_res_informe_testigo),
        items:[grdCgg_res_informe_testigo],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:false,
        constrain:true,
		modal:true,
        layout:'border',
        bbar:[btnEditarCgg_res_informe_testigo,btnEliminarCgg_res_informe_testigo,'->',btnSalirCgg_res_informe_testigo]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_informe_testigo.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_informe_testigo.
     * @returns ventana winFrmCgg_res_informe_testigo.
     * @base FrmListadoCgg_res_informe_testigo.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_informe_testigo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_informe_testigo.
     * @base FrmListadoCgg_res_informe_testigo.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_informe_testigo.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_informe_testigo;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_informe_testigo;
    }
    /*/**
     * Funcion que permite cargar la codigo de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    function cargarCgg_res_matrimonioCtrls(inCodigo){
        gsCgg_res_informe_testigo.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON",
        inCrmtr_codigo:inCodigo
        }
    });
    }
    /**
     * Funcion que permite cargar la codgi de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    this.loadMatrimonio = function(inCodigo){
        cargarCgg_res_matrimonioCtrls(inCodigo);
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_informe_testigo.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_informe_testigo.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_informe_testigo desde una instancia.
 */
FrmListadoCgg_res_informe_testigo.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_informe_testigo desde una instancia.
 */
FrmListadoCgg_res_informe_testigo.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_informe_testigo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_informe_testigo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_informe_testigo desde una instancia.
 */
FrmListadoCgg_res_informe_testigo.prototype.loadData = function(){
    this.loadData();
}
FrmListadoCgg_res_informe_testigo.prototype.loadMatrimonio = function(inCodigo){
    this.loadMatrimonio(inCodigo);
}
