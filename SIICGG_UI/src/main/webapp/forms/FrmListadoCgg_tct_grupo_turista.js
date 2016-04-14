/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_tct_grupo_turista.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_tct_grupo_turista(inDesktop){
    var optMenu = 'Tct grupo turista';
    var urlListadoCgg_tct_grupo_turista=URL_WS+"Cgg_tct_grupo_turista";
    var tituloListadoCgg_tct_grupo_turista='Grupo Turista';
    var descListadoCgg_tct_grupo_turista='El formulario permite administrar informaci\u00f3n de Grupo Turista';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_tct_grupo_turista.
     */
    var btnNuevoCgg_tct_grupo_turista = new Ext.Button({
        id:'btnNuevoCgg_tct_grupo_turista',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_tct_grupo_turista = new FrmCgg_tct_grupo_turista("insert");
                objCgg_tct_grupo_turista.closeHandler(function(){
                    gsCgg_tct_grupo_turista.reload();
                });
                objCgg_tct_grupo_turista.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_tct_grupo_turista.
     */
    var btnEditarCgg_tct_grupo_turista = new Ext.Button({
        id:'btnEditarCgg_tct_grupo_turista',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_tct_grupo_turista.getSelectionModel().getSelected();
                if(r){
                    var objCgg_tct_grupo_turista = new FrmCgg_tct_grupo_turista("update",r);
                    objCgg_tct_grupo_turista.closeHandler(function(){
                        gsCgg_tct_grupo_turista.reload();
                    });
                    objCgg_tct_grupo_turista.loadData();
                    objCgg_tct_grupo_turista.show();
                }else{
                    Ext.MessageBox.alert('Grupo Turista', 'Seleccione un registro para continuar');
                }

            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_tct_grupo_turista.
     */
    var btnEliminarCgg_tct_grupo_turista = new Ext.Button({
        id:'btnEliminarCgg_tct_grupo_turista',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_tct_grupo_turista,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_tct_grupo_turista(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_tct_grupo_turista(r){
                            winFrmListadoCgg_tct_grupo_turista.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_tct_grupo_turista,
                                    msg: 'La informaci\u00f3n de Grupo Turista ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_tct_grupo_turista.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_tct_grupo_turista,
                                    msg: 'La informaci\u00f3n de Grupo Turista no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_tct_grupo_turista.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCtgtr_codigo',grdCgg_tct_grupo_turista.getSelectionModel().getSelected().get('CTGTR_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_tct_grupo_turista,"delete",param, true, CallBackCgg_tct_grupo_turista);
                    }catch(inErr){
                        winFrmListadoCgg_tct_grupo_turista.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_tct_grupo_turista.
     */
    var btnSalirCgg_tct_grupo_turista = new Ext.Button({
        id:'btnSalirCgg_tct_grupo_turista',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_tct_grupo_turista.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_tct_grupo_turista.
     */
    var cmCgg_tct_grupo_turista = new Ext.grid.ColumnModel([
        {dataIndex:'CTGTR_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CUSU_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CTADC_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CTGTR_NUMERO',header:'Numero',width:150,sortable:true},
        {dataIndex:'CTGTR_FECHA_RESERVA',header:'Fecha reserva',width:150,sortable:true},
        {dataIndex:'CTGTR_FECHA_INGRESO',header:'Fecha ingreso',width:150,sortable:true},
        {dataIndex:'CTGTR_FECHA_SALIDA',header:'Fecha salida',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_tct_grupo_turista por un campo especifico.
     */
    var gsCgg_tct_grupo_turista = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_tct_grupo_turista",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CTGTR_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CTGTR_CODIGO'},
            {name:'CUSU_CODIGO'},
            {name:'CTADC_CODIGO'},
            {name:'CTGTR_NUMERO'},
            {name:'CTGTR_FECHA_RESERVA'},
            {name:'CTGTR_FECHA_INGRESO'},
            {name:'CTGTR_FECHA_SALIDA'}
        ]),
        sortInfo:{field: 'CUSU_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_tct_grupo_turista.
     */
    var pgBarCgg_tct_grupo_turista= new Ext.PagingToolbar({
        store: gsCgg_tct_grupo_turista,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_tct_grupo_turista en un formato tabular de filas y columnas.
     */
    var grdCgg_tct_grupo_turista = new Ext.grid.GridPanel({
        cm:cmCgg_tct_grupo_turista,
        store:gsCgg_tct_grupo_turista,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_tct_grupo_turista,
                width:200
            })
        ],
        bbar:pgBarCgg_tct_grupo_turista,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_tct_grupo_turista.hidden){
                    btnEditarCgg_tct_grupo_turista.fireEvent('click', btnEditarCgg_tct_grupo_turista);
                }
            }}});
    gsCgg_tct_grupo_turista.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_tct_grupo_turista.
     */
    if(inDesktop){
        var winFrmListadoCgg_tct_grupo_turista =inDesktop.createWindow({
            id:'winFrmListadoCgg_tct_grupo_turista',
            title:tituloListadoCgg_tct_grupo_turista,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_tct_grupo_turista,descListadoCgg_tct_grupo_turista),
            items:[grdCgg_tct_grupo_turista],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_tct_grupo_turista,btnEditarCgg_tct_grupo_turista,btnEliminarCgg_tct_grupo_turista,'->',btnSalirCgg_tct_grupo_turista]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_tct_grupo_turista.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_tct_grupo_turista.
     * @returns ventana winFrmCgg_tct_grupo_turista.
     * @base FrmListadoCgg_tct_grupo_turista.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_tct_grupo_turista;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_tct_grupo_turista.
     * @base FrmListadoCgg_tct_grupo_turista.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_tct_grupo_turista.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_tct_grupo_turista;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_tct_grupo_turista;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_tct_grupo_turista.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_tct_grupo_turista.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_tct_grupo_turista desde una instancia.
 */
FrmListadoCgg_tct_grupo_turista.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_tct_grupo_turista desde una instancia.
 */
FrmListadoCgg_tct_grupo_turista.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_tct_grupo_turista,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_tct_grupo_turista.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_tct_grupo_turista desde una instancia.
 */
FrmListadoCgg_tct_grupo_turista.prototype.loadData = function(){
    this.loadData();
}
