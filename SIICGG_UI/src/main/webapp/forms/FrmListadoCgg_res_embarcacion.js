/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_embarcacion.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_embarcacion(){
    var optMenu = 'Movilidad interna/Embarcacion';
    var urlListadoCgg_res_embarcacion=URL_WS+"Cgg_res_embarcacion";
    var tituloListadoCgg_res_embarcacion='Embarcaci\u00f3n';
    var descListadoCgg_res_embarcacion='El formulario permite administrar informaci\u00f3n de la Embarcaci\u00f3n';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_embarcacion.
     */
    var btnNuevoCgg_res_embarcacion = new Ext.Button({
        id:'btnNuevoCgg_res_embarcacion',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_res_embarcacion = new FrmCgg_res_embarcacion("insert");
                objCgg_res_embarcacion.closeHandler(function(){
                    gsCgg_res_embarcacion.reload();
                });
                objCgg_res_embarcacion.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_embarcacion.
     */
    var btnEditarCgg_res_embarcacion = new Ext.Button({
        id:'btnEditarCgg_res_embarcacion',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_res_embarcacion.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_embarcacion = new FrmCgg_res_embarcacion("update",r);
                    objCgg_res_embarcacion.closeHandler(function(){
                        gsCgg_res_embarcacion.reload();
                    });
                    objCgg_res_embarcacion.loadData();
                    objCgg_res_embarcacion.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_embarcacion.
     */
    var btnEliminarCgg_res_embarcacion = new Ext.Button({
        id:'btnEliminarCgg_res_embarcacion',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_embarcacion,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_embarcacion(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_embarcacion(r){
                            winFrmListadoCgg_res_embarcacion.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_embarcacion,
                                    msg: 'La informaci\u00f3n de Embarcaci\u00f3n ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_embarcacion.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_embarcacion,
                                    msg: 'La informaci\u00f3n de Embarcaci\u00f3n no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_embarcacion.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCremb_codigo',grdCgg_res_embarcacion.getSelectionModel().getSelected().get('CREMB_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_embarcacion,"delete",param, true, CallBackCgg_res_embarcacion);
                    }catch(inErr){
                        winFrmListadoCgg_res_embarcacion.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_embarcacion.
     */
    var btnSalirCgg_res_embarcacion = new Ext.Button({
        id:'btnSalirCgg_res_embarcacion',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_res_embarcacion.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_embarcacion.
     */
    var cmCgg_res_embarcacion = new Ext.grid.ColumnModel([
        {dataIndex:'CREMB_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true},
        {dataIndex:'CREMB_NOMBRE',header:'Nombre',width:580,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_embarcacion por un campo especifico.
     */
    var gsCgg_res_embarcacion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_embarcacion",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CREMB_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CREMB_CODIGO'},
            {name:'CREMB_NOMBRE'}
        ]),
        sortInfo:{field: 'CREMB_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_embarcacion.
     */
    var pgBarCgg_res_embarcacion= new Ext.PagingToolbar({
        store: gsCgg_res_embarcacion,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_embarcacion en un formato tabular de filas y columnas.
     */
    var grdCgg_res_embarcacion = new Ext.grid.GridPanel({
        cm:cmCgg_res_embarcacion,
        store:gsCgg_res_embarcacion,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_embarcacion,
                width:200
            })
        ],
        bbar:pgBarCgg_res_embarcacion,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_embarcacion.hidden){
                    btnEditarCgg_res_embarcacion.fireEvent('click', btnEditarCgg_res_embarcacion);
                }
            }}});
    gsCgg_res_embarcacion.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_embarcacion.
     */
    var winFrmListadoCgg_res_embarcacion = new Ext.Window({
        id:'winFrmListadoCgg_res_embarcacion',
        title:tituloListadoCgg_res_embarcacion,
        tbar:getPanelTitulo(tituloListadoCgg_res_embarcacion,descListadoCgg_res_embarcacion),
        items:[grdCgg_res_embarcacion],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_res_embarcacion,btnEditarCgg_res_embarcacion,btnEliminarCgg_res_embarcacion,'->',btnSalirCgg_res_embarcacion]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_embarcacion.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_embarcacion.
     * @returns ventana winFrmCgg_res_embarcacion.
     * @base FrmListadoCgg_res_embarcacion.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_embarcacion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_embarcacion.
     * @base FrmListadoCgg_res_embarcacion.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_embarcacion.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_embarcacion;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_embarcacion;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_embarcacion.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_embarcacion.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_embarcacion desde una instancia.
 */
FrmListadoCgg_res_embarcacion.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_embarcacion desde una instancia.
 */
FrmListadoCgg_res_embarcacion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_embarcacion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_embarcacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_embarcacion desde una instancia.
 */
FrmListadoCgg_res_embarcacion.prototype.loadData = function(){
    this.loadData();
}
