/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_jur_historial_acuerdo.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_jur_historial_acuerdo(inDesktop){
    var optMenu = 'Jur\u00eddico/Historial Acuerdo';
    var urlListadoCgg_jur_historial_acuerdo=URL_WS+"Cgg_jur_historial_acuerdo";
    var tituloListadoCgg_jur_historial_acuerdo='Historial Acuerdo';
    var descListadoCgg_jur_historial_acuerdo='El formulario permite administrar informaci\u00f3n de Historial Acuerdo';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_jur_historial_acuerdo.
     */
    var btnNuevoCgg_jur_historial_acuerdo = new Ext.Button({
        id:'btnNuevoCgg_jur_historial_acuerdo',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_jur_historial_acuerdo = new FrmCgg_jur_historial_acuerdo("insert");
                objCgg_jur_historial_acuerdo.closeHandler(function(){
                    gsCgg_jur_historial_acuerdo.reload();
                });
                objCgg_jur_historial_acuerdo.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_jur_historial_acuerdo.
     */
    var btnEditarCgg_jur_historial_acuerdo = new Ext.Button({
        id:'btnEditarCgg_jur_historial_acuerdo',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_jur_historial_acuerdo.getSelectionModel().getSelected();
                if(r){
                    var objCgg_jur_historial_acuerdo = new FrmCgg_jur_historial_acuerdo("update",r);
                    objCgg_jur_historial_acuerdo.closeHandler(function(){
                        gsCgg_jur_historial_acuerdo.reload();
                    });
                    objCgg_jur_historial_acuerdo.show();
                    objCgg_jur_historial_acuerdo.loadData(r);

                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_jur_historial_acuerdo.
     */
    var btnEliminarCgg_jur_historial_acuerdo = new Ext.Button({
        id:'btnEliminarCgg_jur_historial_acuerdo',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_jur_historial_acuerdo,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_jur_historial_acuerdo(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_jur_historial_acuerdo(r){
                            winFrmListadoCgg_jur_historial_acuerdo.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_jur_historial_acuerdo,
                                    msg: 'La informaci\u00f3n de Historial Acuerdo ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_jur_historial_acuerdo.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_jur_historial_acuerdo,
                                    msg: 'La informaci\u00f3n de Historial Acuerdo no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_jur_historial_acuerdo.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCjhac_codigo',grdCgg_jur_historial_acuerdo.getSelectionModel().getSelected().get('CJHAC_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_jur_historial_acuerdo,"delete",param, true, CallBackCgg_jur_historial_acuerdo);
                    }catch(inErr){
                        winFrmListadoCgg_jur_historial_acuerdo.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_jur_historial_acuerdo.
     */
    var btnSalirCgg_jur_historial_acuerdo = new Ext.Button({
        id:'btnSalirCgg_jur_historial_acuerdo',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_jur_historial_acuerdo.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_jur_historial_acuerdo.
     */
    var cmCgg_jur_historial_acuerdo = new Ext.grid.ColumnModel([
        {dataIndex:'CJACU_NUMERO',header:'N\u00famero',width:150,sortable:true},
        {dataIndex:'CJACU_ANIO',header:'A\u00f1o',width:150,sortable:true},
        {dataIndex:'CJHAC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CJACU_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CRPJR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CRPJR_RAZON_SOCIAL',header:'Raz\u00f3n Social',width:150,sortable:true},
        {dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'PERSONA',header:'Persona',width:150,sortable:true},
        {dataIndex:'CJTPR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CJTPR_NOMBRE',header:'Nombre Proceso',width:150,sortable:true},
        {dataIndex:'CJACU_OBJETO',header:'Objeto',width:150,sortable:true},
        {dataIndex:'CJACU_FECHA_SUSCRIPCION',header:'Fecha suscripci\u00f3n',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CJACU_FECHA_INICIO',header:'Fecha inicio',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CJACU_RESPONSABLE',header:'Responsable',width:150,sortable:true},
        {dataIndex:'CJACU_ESTADO_EJECUCION',header:'Estado ejecuci\u00f3n',width:150,sortable:true,renderer:function(inCjacu_estado_ejecucion) {
            return dsEstadoEjecucion[inCjacu_estado_ejecucion][1];
        }},
        {dataIndex:'CJTPR_TIPO',header:'Tipo',width:150,sortable:true,renderer:function(inCjacu_tipo) {
            return dsTipoAcuerdo[inCjacu_tipo][1];
        } },
        {dataIndex:'CJACU_TIPO_PERSONA',header:'Tipo persona',width:150,sortable:true,renderer:function(inCjacu_tipo_adversario) {
            return dsTipoAdversario[inCjacu_tipo_adversario][1];
        }},
        {dataIndex:'CJACU_COSTO',header:'Costo',width:150,sortable:true},
        {dataIndex:'CJACU_TIEMPO',header:'Tiempo',width:150,sortable:true},
        {dataIndex:'CJHAC_DESCRIPCION',header:'Descripci\u00f3n',width:150,sortable:true},
        {dataIndex:'CJHAC_RESPONSABLE',header:'Responsable',width:150,sortable:true},
        {dataIndex:'CJHAC_FECHA',header:'Fecha',width:150,sortable:true,renderer:truncDate}
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_jur_historial_acuerdo por un campo especifico.
     */
    var gsCgg_jur_historial_acuerdo = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_historial_acuerdo",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CJHAC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CJHAC_CODIGO'},
            {name:'CJACU_CODIGO'},
            {name:'CRPJR_CODIGO'},
            {name:'CRPJR_RAZON_SOCIAL'},
            {name:'CRPER_CODIGO'},
            {name:'PERSONA'},
            {name:'CJTPR_CODIGO'},
            {name:'CJTPR_NOMBRE'},
            {name:'CJACU_ANIO'},
            {name:'CJACU_NUMERO'},
            {name:'CJACU_OBJETO'},
            {name:'CJACU_FECHA_SUSCRIPCION'},
            {name:'CJACU_FECHA_INICIO'},
            {name:'CJACU_RESPONSABLE'},
            {name:'CJACU_ESTADO_EJECUCION'},
            {name:'CJTPR_TIPO'},
            {name:'CJACU_TIPO_PERSONA'},
            {name:'CJACU_COSTO'},
            {name:'CJACU_TIEMPO'},
            {name:'CJHAC_DESCRIPCION'},
            {name:'CJHAC_RESPONSABLE'},
            {name:'CJHAC_FECHA'}
        ]),
        groupField:'CJACU_NUMERO',
        sortInfo: {
            field: 'CJACU_CODIGO',
            direction: 'ASC'
        },
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_jur_historial_acuerdo.
     */
    var pgBarCgg_jur_historial_acuerdo= new Ext.PagingToolbar({
        store: gsCgg_jur_historial_acuerdo,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_jur_historial_acuerdo en un formato tabular de filas y columnas.
     */
    var grdCgg_jur_historial_acuerdo = new Ext.grid.GridPanel({
        cm:cmCgg_jur_historial_acuerdo,
        store:gsCgg_jur_historial_acuerdo,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_jur_historial_acuerdo,
                width:200
            })
        ],
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        bbar:pgBarCgg_jur_historial_acuerdo,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_jur_historial_acuerdo.hidden){
                    btnEditarCgg_jur_historial_acuerdo.fireEvent('click', btnEditarCgg_jur_historial_acuerdo);
                }
            }}});
    gsCgg_jur_historial_acuerdo.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_jur_historial_acuerdo.
     */

    if(inDesktop){
        var winFrmListadoCgg_jur_historial_acuerdo = inDesktop.createWindow({
            id:'winFrmListadoCgg_jur_historial_acuerdo',
            title:tituloListadoCgg_jur_historial_acuerdo,
            iconCls:'iconAplicacion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_jur_historial_acuerdo,descListadoCgg_jur_historial_acuerdo),
            items:[grdCgg_jur_historial_acuerdo],
            bbar:[btnNuevoCgg_jur_historial_acuerdo,btnEditarCgg_jur_historial_acuerdo,btnEliminarCgg_jur_historial_acuerdo,'->',btnSalirCgg_jur_historial_acuerdo]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_jur_historial_acuerdo.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_jur_historial_acuerdo.
     * @returns ventana winFrmCgg_jur_historial_acuerdo.
     * @base FrmListadoCgg_jur_historial_acuerdo.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_jur_historial_acuerdo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_jur_historial_acuerdo.
     * @base FrmListadoCgg_jur_historial_acuerdo.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_jur_historial_acuerdo.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_jur_historial_acuerdo;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_jur_historial_acuerdo;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_jur_historial_acuerdo.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_jur_historial_acuerdo.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_jur_historial_acuerdo desde una instancia.
 */
FrmListadoCgg_jur_historial_acuerdo.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_jur_historial_acuerdo desde una instancia.
 */
FrmListadoCgg_jur_historial_acuerdo.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_jur_historial_acuerdo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_jur_historial_acuerdo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_jur_historial_acuerdo desde una instancia.
 */
FrmListadoCgg_jur_historial_acuerdo.prototype.loadData = function(){
    this.loadData();
}
