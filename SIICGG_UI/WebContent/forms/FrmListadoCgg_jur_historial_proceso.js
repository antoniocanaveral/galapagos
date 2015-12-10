/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_jur_historial_proceso.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_jur_historial_proceso(inDesktop){
    var optMenu = 'Jur\u00eddico/Historial procesos';
    var urlListadoCgg_jur_historial_proceso=URL_WS+"Cgg_jur_historial_proceso";
    var tituloListadoCgg_jur_historial_proceso='Historial Proceso Judicial';
    var descListadoCgg_jur_historial_proceso='El formulario permite administrar informaci\u00f3n de Historial Proceso Judicial';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_jur_historial_proceso.
     */
    var btnNuevoCgg_jur_historial_proceso = new Ext.Button({
        id:'btnNuevoCgg_jur_historial_proceso',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_jur_historial_proceso = new FrmCgg_jur_historial_proceso("insert");
                objCgg_jur_historial_proceso.closeHandler(function(){
                    gsCgg_jur_historial_proceso.reload();
                });
                objCgg_jur_historial_proceso.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_jur_historial_proceso.
     */
    var btnEditarCgg_jur_historial_proceso = new Ext.Button({
        id:'btnEditarCgg_jur_historial_proceso',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_jur_historial_proceso.getSelectionModel().getSelected();
                if(r){
                    var objCgg_jur_historial_proceso = new FrmCgg_jur_historial_proceso("update",r);
                    objCgg_jur_historial_proceso.closeHandler(function(){
                        gsCgg_jur_historial_proceso.reload();
                    });
                    objCgg_jur_historial_proceso.show();
                    objCgg_jur_historial_proceso.loadData(r);
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_jur_historial_proceso.
     */
    var btnEliminarCgg_jur_historial_proceso = new Ext.Button({
        id:'btnEliminarCgg_jur_historial_proceso',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_jur_historial_proceso,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_jur_historial_proceso(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_jur_historial_proceso(r){
                            winFrmListadoCgg_jur_historial_proceso.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_jur_historial_proceso,
                                    msg: 'La informaci\u00f3n de Historial Proceso Judicial ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_jur_historial_proceso.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_jur_historial_proceso,
                                    msg: 'La informaci\u00f3n de Historial Proceso Judicial no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_jur_historial_proceso.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCjhtp_codigo',grdCgg_jur_historial_proceso.getSelectionModel().getSelected().get('CJHTP_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_jur_historial_proceso,"delete",param, true, CallBackCgg_jur_historial_proceso);
                    }catch(inErr){
                        winFrmListadoCgg_jur_historial_proceso.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_jur_historial_proceso.
     */
    var btnSalirCgg_jur_historial_proceso = new Ext.Button({
        id:'btnSalirCgg_jur_historial_proceso',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_jur_historial_proceso.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_jur_historial_proceso.
     */
    var cmCgg_jur_historial_proceso = new Ext.grid.ColumnModel([
              {dataIndex:'CJPJU_NUMERO',header:'N\u00famero',width:150,sortable:true},
        {dataIndex:'CJHTP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CJPJU_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CCTN_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CCTN_NOMBRE',header:'Canton',width:150,sortable:true},
        {dataIndex:'CRPJR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CRPJR_RAZON_SOCIAL',header:'Raz\u00f3n Social',width:150,sortable:true},
        {dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'PERSONA',header:'Persona',width:150,sortable:true},      
        {dataIndex:'CJPJU_TIPO_PROCESO',header:'Tipo proceso',width:150,sortable:true,renderer:function(inCjpju_tipo_proceso) {
            return dsTipoProceso[inCjpju_tipo_proceso][1];
        }},
        {dataIndex:'CJPJU_TIPO_ADVERSARIO',header:'Tipo adversario',width:150,sortable:true,renderer:function(inCjpju_tipo_adversario) {
            return dsTipoAdversario[inCjpju_tipo_adversario][1];
        }},
        {dataIndex:'CJPJU_FECHA_INICIO',header:'Fecha inicio',width:150,sortable:true, renderer:truncDate},
        {dataIndex:'CJPJU_FECHA_FINALIZACION',header:'Fecha finalizaci\u00f3n',width:150,sortable:true, renderer:truncDate},
        {dataIndex:'CJPJU_ESTADO_EJECUCION',header:'Estado ejecuci\u00f3n',width:150,sortable:true,renderer:function(inCjpj_estado_ejecucion) {
            return dsEstadoEjecucion[inCjpj_estado_ejecucion][1];
        }},
        {dataIndex:'CJHTP_DESCRIPCION',header:'Descripci\u00f3n',width:150,sortable:true},
        {dataIndex:'CJHTP_TIPO',header:'Tipo',width:150,sortable:true,renderer:function(inCjhtp_tipo) {
            return dsTipoMovimientoProceso[inCjhtp_tipo][1];
        }},
        {dataIndex:'CJHTP_RESPONSABLE',header:'Responsable',width:150,sortable:true},
        {dataIndex:'CJHTP_FECHA',header:'Fecha',width:150,sortable:true, renderer:truncDate}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_jur_historial_proceso por un campo especifico.
     */
    var gsCgg_jur_historial_proceso = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_historial_proceso",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CJHTP_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CJHTP_CODIGO'},
            {name:'CJPJU_CODIGO'},
            {name:'CCTN_CODIGO'},
            {name:'CCTN_NOMBRE'},
            {name:'CRPJR_CODIGO'},
            {name:'CRPJR_RAZON_SOCIAL'},
            {name:'CRPER_CODIGO'},
            {name:'PERSONA'},
            {name:'CJPJU_NUMERO'},
            {name:'CJPJU_TIPO_PROCESO'},
            {name:'CJPJU_TIPO_ADVERSARIO'},
            {name:'CJPJU_FECHA_INICIO'},
            {name:'CJPJU_FECHA_FINALIZACION'},
            {name:'CJPJU_ESTADO_EJECUCION'},
            {name:'CJHTP_DESCRIPCION'},
            {name:'CJHTP_TIPO'},
            {name:'CJHTP_RESPONSABLE'},
            {name:'CJHTP_FECHA'}
        ]),
        groupField:'CJPJU_NUMERO',
        sortInfo: {
            field: 'CJPJU_CODIGO',
            direction: 'ASC'
        },
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_jur_historial_proceso.
     */
    var pgBarCgg_jur_historial_proceso= new Ext.PagingToolbar({
        store: gsCgg_jur_historial_proceso,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_jur_historial_proceso en un formato tabular de filas y columnas.
     */
    var grdCgg_jur_historial_proceso = new Ext.grid.GridPanel({
        cm:cmCgg_jur_historial_proceso,
        store:gsCgg_jur_historial_proceso,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_jur_historial_proceso,
                width:200
            })
        ],
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        bbar:pgBarCgg_jur_historial_proceso,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_jur_historial_proceso.hidden){
                    btnEditarCgg_jur_historial_proceso.fireEvent('click', btnEditarCgg_jur_historial_proceso);
                }
            }}});
    gsCgg_jur_historial_proceso.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_jur_historial_proceso.
     */
    if(inDesktop){
        var winFrmListadoCgg_jur_historial_proceso = inDesktop.createWindow({
            id:'winFrmListadoCgg_jur_historial_proceso',
            title:tituloListadoCgg_jur_historial_proceso,
            iconCls:'iconAplicacion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_jur_historial_proceso,descListadoCgg_jur_historial_proceso),
            items:[grdCgg_jur_historial_proceso],
            bbar:[btnNuevoCgg_jur_historial_proceso,btnEditarCgg_jur_historial_proceso,btnEliminarCgg_jur_historial_proceso,'->',btnSalirCgg_jur_historial_proceso]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_jur_historial_proceso.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_jur_historial_proceso.
     * @returns ventana winFrmCgg_jur_historial_proceso.
     * @base FrmListadoCgg_jur_historial_proceso.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_jur_historial_proceso;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_jur_historial_proceso.
     * @base FrmListadoCgg_jur_historial_proceso.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_jur_historial_proceso.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_jur_historial_proceso;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_jur_historial_proceso;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_jur_historial_proceso.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_jur_historial_proceso.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_jur_historial_proceso desde una instancia.
 */
FrmListadoCgg_jur_historial_proceso.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_jur_historial_proceso desde una instancia.
 */
FrmListadoCgg_jur_historial_proceso.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_jur_historial_proceso,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_jur_historial_proceso.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_jur_historial_proceso desde una instancia.
 */
FrmListadoCgg_jur_historial_proceso.prototype.loadData = function(){
    this.loadData();
}
