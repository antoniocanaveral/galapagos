/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_operacion_validacion.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_operacion_validacion(inDesktop){    
	var optMenu = 'Configuraci\u00F3n/Control de informaci\u00F3n/Administraci\u00F3n de operaciones de validaci\u00F3n';
    var urlListadoCgg_operacion_validacion=URL_WS+"Cgg_operacion_validacion";
    var tituloListadoCgg_operacion_validacion='Operacion validacion';
    var descListadoCgg_operacion_validacion='El formulario permite administrar informaci\u00f3n de la tabla Operacion validacion';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_operacion_validacion.
     */
    var btnNuevoCgg_operacion_validacion = new Ext.Button({
        id:'btnNuevoCgg_operacion_validacion',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_operacion_validacion = new FrmCgg_operacion_validacion("insert");
                objCgg_operacion_validacion.closeHandler(function(){
                    gsCgg_operacion_validacion.reload();
                });
                objCgg_operacion_validacion.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_operacion_validacion.
     */
    var btnEditarCgg_operacion_validacion = new Ext.Button({
        id:'btnEditarCgg_operacion_validacion',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_operacion_validacion.getSelectionModel().getSelected();
                if(r){
                    var objCgg_operacion_validacion = new FrmCgg_operacion_validacion("update",r);
                    objCgg_operacion_validacion.closeHandler(function(){
                        gsCgg_operacion_validacion.reload();
                    });
                    objCgg_operacion_validacion.loadData();
                    objCgg_operacion_validacion.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_operacion_validacion.
     */
    var btnEliminarCgg_operacion_validacion = new Ext.Button({
        id:'btnEliminarCgg_operacion_validacion',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_operacion_validacion,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_operacion_validacion(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_operacion_validacion(r){
                            winFrmListadoCgg_operacion_validacion.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_operacion_validacion,
                                    msg: 'La informaci\u00f3n de Operacion validacion ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_operacion_validacion.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_operacion_validacion,
                                    msg: 'La informaci\u00f3n de Operacion validacion no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_operacion_validacion.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCopvl_codigo',grdCgg_operacion_validacion.getSelectionModel().getSelected().get('COPVL_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_operacion_validacion,"delete",param, true, CallBackCgg_operacion_validacion);
                    }catch(inErr){
                        winFrmListadoCgg_operacion_validacion.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_operacion_validacion.
     */
    var btnSalirCgg_operacion_validacion = new Ext.Button({
        id:'btnSalirCgg_operacion_validacion',
        text:'Salir',
        iconCls:'iconSalir',
         tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_operacion_validacion.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_operacion_validacion.
     */
    var cmCgg_operacion_validacion = new Ext.grid.ColumnModel([
        {dataIndex:'COPVL_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'COPVL_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
        {dataIndex:'COPVL_FORMULARIO',header:'Formulario',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_operacion_validacion por un campo especifico.
     */
    var gsCgg_operacion_validacion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_operacion_validacion",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'COPVL_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'COPVL_CODIGO'},
            {name:'COPVL_DESCRIPCION'},
            {name:'COPVL_FORMULARIO'}
        ]),
        sortInfo:{field: 'COPVL_DESCRIPCION', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_operacion_validacion.
     */
    var pgBarCgg_operacion_validacion= new Ext.PagingToolbar({
        store: gsCgg_operacion_validacion,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_operacion_validacion en un formato tabular de filas y columnas.
     */
    var grdCgg_operacion_validacion = new Ext.grid.GridPanel({
        cm:cmCgg_operacion_validacion,
        store:gsCgg_operacion_validacion,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        viewConfig:{forceFit:true},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_operacion_validacion,
                width:200
            })
        ],
        bbar:pgBarCgg_operacion_validacion,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_operacion_validacion.hidden){
                    btnEditarCgg_operacion_validacion.fireEvent('click', btnEditarCgg_operacion_validacion);
                }
            }}});
    gsCgg_operacion_validacion.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_operacion_validacion.
     */

    var winFrmListadoCgg_operacion_validacion =  null;
    if(inDesktop!==null && inDesktop!==undefined)
    {
        winFrmListadoCgg_operacion_validacion = inDesktop.createWindow({
            id:'winFrmListadoCgg_operacion_validacion',
            title:tituloListadoCgg_operacion_validacion,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_operacion_validacion,descListadoCgg_operacion_validacion),
            items:[grdCgg_operacion_validacion],
            bbar:[btnNuevoCgg_operacion_validacion,btnEditarCgg_operacion_validacion,btnEliminarCgg_operacion_validacion,'->',btnSalirCgg_operacion_validacion]
        });


    }
    else
    {
        winFrmListadoCgg_operacion_validacion = new Ext.Window({
            id:'winFrmListadoCgg_operacion_validacion',
            title:tituloListadoCgg_operacion_validacion,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_operacion_validacion,descListadoCgg_operacion_validacion),
            items:[grdCgg_operacion_validacion],
            bbar:[btnNuevoCgg_operacion_validacion,btnEditarCgg_operacion_validacion,btnEliminarCgg_operacion_validacion,'->',btnSalirCgg_operacion_validacion]
        });
    }
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_operacion_validacion.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_operacion_validacion.
     * @returns ventana winFrmCgg_operacion_validacion.
     * @base FrmListadoCgg_operacion_validacion.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_operacion_validacion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_operacion_validacion.
     * @base FrmListadoCgg_operacion_validacion.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_operacion_validacion.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_operacion_validacion;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_operacion_validacion;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_operacion_validacion.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_operacion_validacion.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_operacion_validacion desde una instancia.
 */
FrmListadoCgg_operacion_validacion.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_operacion_validacion desde una instancia.
 */
FrmListadoCgg_operacion_validacion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_operacion_validacion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_operacion_validacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_operacion_validacion desde una instancia.
 */
FrmListadoCgg_operacion_validacion.prototype.loadData = function(){
    this.loadData();
}
