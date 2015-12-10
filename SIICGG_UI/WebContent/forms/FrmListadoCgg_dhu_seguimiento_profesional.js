/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_seguimiento_profesional.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_seguimiento_profesional(inDescktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Beca/Seguimiento Profesional';
    var urlListadoCgg_dhu_seguimiento_profesional=URL_WS+"Cgg_dhu_seguimiento_profesional";
    var tituloListadoCgg_dhu_seguimiento_profesional='Seguimiento profesional';
    var descListadoCgg_dhu_seguimiento_profesional='El formulario permite administrar informaci\u00f3n sobre los diferentes seguimientos profesionales de un residente becado';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_seguimiento_profesional.
     */
    var btnNuevoCgg_dhu_seguimiento_profesional = new Ext.Button({
        id:'btnNuevoCgg_dhu_seguimiento_profesional',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_dhu_seguimiento_profesional = new FrmCgg_dhu_seguimiento_profesional("insert");
                objCgg_dhu_seguimiento_profesional.closeHandler(function(){
                    gsCgg_dhu_seguimiento_profesional.reload();
                });
                objCgg_dhu_seguimiento_profesional.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_seguimiento_profesional.
     */
    var btnEditarCgg_dhu_seguimiento_profesional = new Ext.Button({
        id:'btnEditarCgg_dhu_seguimiento_profesional',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_dhu_seguimiento_profesional.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_seguimiento_profesional = new FrmCgg_dhu_seguimiento_profesional("update",r);
                    objCgg_dhu_seguimiento_profesional.closeHandler(function(){
                        gsCgg_dhu_seguimiento_profesional.reload();
                    });
                    objCgg_dhu_seguimiento_profesional.loadData();
                    objCgg_dhu_seguimiento_profesional.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_seguimiento_profesional.
     */
    var btnEliminarCgg_dhu_seguimiento_profesional = new Ext.Button({
        id:'btnEliminarCgg_dhu_seguimiento_profesional',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_seguimiento_profesional,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_seguimiento_profesional(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_seguimiento_profesional(r){
                            winFrmListadoCgg_dhu_seguimiento_profesional.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_seguimiento_profesional,
                                    msg: 'La informaci\u00f3n  ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_seguimiento_profesional.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_seguimiento_profesional,
                                    msg: 'La informaci\u00f3n  no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_seguimiento_profesional.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdspr_codigo',grdCgg_dhu_seguimiento_profesional.getSelectionModel().getSelected().get('CDSPR_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_seguimiento_profesional,"delete",param, true, CallBackCgg_dhu_seguimiento_profesional);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_seguimiento_profesional.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_seguimiento_profesional.
     */
    var btnSalirCgg_dhu_seguimiento_profesional = new Ext.Button({
        id:'btnSalirCgg_dhu_seguimiento_profesional',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_seguimiento_profesional.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_seguimiento_profesional.
     */
    var cmCgg_dhu_seguimiento_profesional = new Ext.grid.ColumnModel([
        {dataIndex:'CDSPR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDBEC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_NOMBRES',header:'Nombre',width:150,sortable:true},
        {dataIndex:'CRPER_APELLIDO_PATERNO',header:'Apellido paterno',width:150,sortable:true},
        {dataIndex:'CRPER_APELLIDO_MATERNO',header:'Apellido materno',width:150,sortable:true},
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'No. documento',width:150,sortable:true},
        {dataIndex:'CDBEC_NUMERO_CONVENIO',header:'No. convenio',width:150,sortable:true},
        {dataIndex:'CDTBC_NOMBRE',header:'Tipo convenio',width:150,sortable:true},
        {dataIndex:'CDBEC_BECA_DEVENGADA',header:'Beca devengada',width:150,sortable:true,renderer:function(inCdbecdebendaga){
            if(inCdbecdebendaga==true){
                return('SI');
            }
            if(inCdbecdebendaga==false){
                return('NO');
            }
        }},
        {dataIndex:'CDBEC_FUNCIONARIO',header:'Funcionario',width:150,sortable:true},
        {dataIndex:'CGESP_NOMBRE',header:'Especialidad',width:150,sortable:true},
        {dataIndex:'CDSPR_ANIO',header:'Anio',width:150,sortable:true},
        {dataIndex:'CDSPR_FECHA_INGRESO',header:'Fecha ingreso',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CDSPR_INSTITUCION',header:'Instituci\u00f3n',width:150,sortable:true},
        {dataIndex:'CDSPR_CARGO',header:'Cargo',width:150,sortable:true},
        {dataIndex:'CDSPR_FECHA_SALIDA',header:'Fecha salida',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CDSPR_OBSERVACIONES',header:'Observaciones',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_seguimiento_profesional por un campo especifico.
     */
    var gsCgg_dhu_seguimiento_profesional = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_seguimiento_profesional",
            method:"selectPageSeguimientoProf",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDSPR_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDSPR_CODIGO'},
            {name:'CDBEC_CODIGO'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_APELLIDO_MATERNO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CDBEC_NUMERO_CONVENIO'},
            {name:'CDTBC_NOMBRE'},
            {name:'CDBEC_BECA_DEVENGADA'},
            {name:'CDBEC_FUNCIONARIO'},
            {name:'CGESP_NOMBRE'},
            {name:'CDSPR_ANIO'},
            {name:'CDSPR_FECHA_INGRESO'},
            {name:'CDSPR_INSTITUCION'},
            {name:'CDSPR_CARGO'},
            {name:'CDSPR_FECHA_SALIDA'},
            {name:'CDSPR_OBSERVACIONES'}
        ]),
        sortInfo:{field: 'CDBEC_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_seguimiento_profesional.
     */
    var pgBarCgg_dhu_seguimiento_profesional= new Ext.PagingToolbar({
        store: gsCgg_dhu_seguimiento_profesional,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_seguimiento_profesional en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_seguimiento_profesional = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_seguimiento_profesional,
        store:gsCgg_dhu_seguimiento_profesional,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_seguimiento_profesional,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_seguimiento_profesional,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_seguimiento_profesional.hidden){
                    btnEditarCgg_dhu_seguimiento_profesional.fireEvent('click', btnEditarCgg_dhu_seguimiento_profesional);
                }
            }}});
    gsCgg_dhu_seguimiento_profesional.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_seguimiento_profesional.
     */
    if(inDescktop){
    var winFrmListadoCgg_dhu_seguimiento_profesional = inDescktop.createWindow({
        id:'winFrmListadoCgg_dhu_seguimiento_profesional',
        title:tituloListadoCgg_dhu_seguimiento_profesional,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_seguimiento_profesional,descListadoCgg_dhu_seguimiento_profesional),
        items:[grdCgg_dhu_seguimiento_profesional],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_dhu_seguimiento_profesional,btnEditarCgg_dhu_seguimiento_profesional,btnEliminarCgg_dhu_seguimiento_profesional,'->',btnSalirCgg_dhu_seguimiento_profesional]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_dhu_seguimiento_profesional.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_seguimiento_profesional.
     * @returns ventana winFrmCgg_dhu_seguimiento_profesional.
     * @base FrmListadoCgg_dhu_seguimiento_profesional.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_seguimiento_profesional;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_seguimiento_profesional.
     * @base FrmListadoCgg_dhu_seguimiento_profesional.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_seguimiento_profesional.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_seguimiento_profesional;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_seguimiento_profesional;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_seguimiento_profesional.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_seguimiento_profesional.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_seguimiento_profesional desde una instancia.
 */
FrmListadoCgg_dhu_seguimiento_profesional.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_seguimiento_profesional desde una instancia.
 */
FrmListadoCgg_dhu_seguimiento_profesional.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_seguimiento_profesional,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_seguimiento_profesional.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_seguimiento_profesional desde una instancia.
 */
FrmListadoCgg_dhu_seguimiento_profesional.prototype.loadData = function(){
    this.loadData();
}
