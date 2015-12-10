/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_institucion_responsable.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_institucion_responsable(inDescktop){ 
	var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Curso/Configuraci\u00F3n/Instituci\u00F3n';
    var urlListadoCgg_dhu_institucion_responsable=URL_WS+"Cgg_dhu_institucion_responsable";
    var tituloListadoCgg_dhu_institucion_responsable='instituciones responsables';
    var descListadoCgg_dhu_institucion_responsable='El formulario permite administrar informaci\u00f3n de la instituci\u00f3n responsable';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_institucion_responsable.
     */
    var btnNuevoCgg_dhu_institucion_responsable = new Ext.Button({
        id:'btnNuevoCgg_dhu_institucion_responsable',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_dhu_institucion_responsable = new FrmCgg_dhu_institucion_responsable("insert");
                objCgg_dhu_institucion_responsable.closeHandler(function(){
                    gsCgg_dhu_institucion_responsable.reload();
                });
                objCgg_dhu_institucion_responsable.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_institucion_responsable.
     */
    var btnEditarCgg_dhu_institucion_responsable = new Ext.Button({
        id:'btnEditarCgg_dhu_institucion_responsable',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_dhu_institucion_responsable.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_institucion_responsable = new FrmCgg_dhu_institucion_responsable("update",r);
                    objCgg_dhu_institucion_responsable.closeHandler(function(){
                        gsCgg_dhu_institucion_responsable.reload();
                    });
                    objCgg_dhu_institucion_responsable.loadData();
                    objCgg_dhu_institucion_responsable.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_institucion_responsable.
     */
    var btnEliminarCgg_dhu_institucion_responsable = new Ext.Button({
        id:'btnEliminarCgg_dhu_institucion_responsable',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_institucion_responsable,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_institucion_responsable(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_institucion_responsable(r){
                            winFrmListadoCgg_dhu_institucion_responsable.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_institucion_responsable,
                                    msg: 'La informaci\u00f3n ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_institucion_responsable.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_institucion_responsable,
                                    msg: 'La informaci\u00f3n no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_institucion_responsable.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCditr_codigo',grdCgg_dhu_institucion_responsable.getSelectionModel().getSelected().get('CDITR_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_institucion_responsable,"delete",param, true, CallBackCgg_dhu_institucion_responsable);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_institucion_responsable.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_institucion_responsable.
     */
    var btnSalirCgg_dhu_institucion_responsable = new Ext.Button({
        id:'btnSalirCgg_dhu_institucion_responsable',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_institucion_responsable.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_institucion_responsable.
     */
    var cmCgg_dhu_institucion_responsable = new Ext.grid.ColumnModel([
        {dataIndex:'CDITR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDITR_NOMBRE',header:'Nombre',width:200,sortable:true},
        {dataIndex:'CDITR_DESCRIPCION',header:'Descripci\u00f3n',width:200,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_institucion_responsable por un campo especifico.
     */
    var gsCgg_dhu_institucion_responsable = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_institucion_responsable",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDITR_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDITR_CODIGO'},
            {name:'CDITR_NOMBRE'},
            {name:'CDITR_DESCRIPCION'}
        ]),
        sortInfo:{field: 'CDITR_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_institucion_responsable.
     */
    var pgBarCgg_dhu_institucion_responsable= new Ext.PagingToolbar({
        store: gsCgg_dhu_institucion_responsable,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_institucion_responsable en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_institucion_responsable = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_institucion_responsable,
        store:gsCgg_dhu_institucion_responsable,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_institucion_responsable,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_institucion_responsable,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_institucion_responsable.hidden){
                    btnEditarCgg_dhu_institucion_responsable.fireEvent('click', btnEditarCgg_dhu_institucion_responsable);
                }
            }}});
    gsCgg_dhu_institucion_responsable.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_institucion_responsable.
     */
    if(inDescktop){
    var winFrmListadoCgg_dhu_institucion_responsable = inDescktop.createWindow({
        id:'winFrmListadoCgg_dhu_institucion_responsable',
        title:tituloListadoCgg_dhu_institucion_responsable,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_institucion_responsable,descListadoCgg_dhu_institucion_responsable),
        items:[grdCgg_dhu_institucion_responsable],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_dhu_institucion_responsable,btnEditarCgg_dhu_institucion_responsable,btnEliminarCgg_dhu_institucion_responsable,'->',btnSalirCgg_dhu_institucion_responsable]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_dhu_institucion_responsable.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_institucion_responsable.
     * @returns ventana winFrmCgg_dhu_institucion_responsable.
     * @base FrmListadoCgg_dhu_institucion_responsable.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_institucion_responsable;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_institucion_responsable.
     * @base FrmListadoCgg_dhu_institucion_responsable.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_institucion_responsable.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_institucion_responsable;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_institucion_responsable;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_institucion_responsable.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_institucion_responsable.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_institucion_responsable desde una instancia.
 */
FrmListadoCgg_dhu_institucion_responsable.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_institucion_responsable desde una instancia.
 */
FrmListadoCgg_dhu_institucion_responsable.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_institucion_responsable,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_institucion_responsable.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_institucion_responsable desde una instancia.
 */
FrmListadoCgg_dhu_institucion_responsable.prototype.loadData = function(){
    this.loadData();
}
