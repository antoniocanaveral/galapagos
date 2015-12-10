/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_tipo_notificacion.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_tipo_notificacion(inDesktop){
    var optMenu = 'Configuraci\u00F3n/Administraci\u00F3n de residencia/Administraci\u00F3n tipo notificaci\u00F3n';
    var urlListadoCgg_res_tipo_notificacion=URL_WS+"Cgg_res_tipo_notificacion";
    var tituloListadoCgg_res_tipo_notificacion='Listado tipo notificaci\u00f3n';
    var descListadoCgg_res_tipo_notificacion='Formulario para administrar informaci\u00f3n del tipo de notificaci\u00f3n para las notificaciones de personas irregulares';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_tipo_notificacion.
     */
    var btnNuevoCgg_res_tipo_notificacion = new Ext.Button({
        id:'btnNuevoCgg_res_tipo_notificacion',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Ingreso tipo notificaci\u00f3n',
        listeners:{
            click:function(){
                var objCgg_res_tipo_notificacion = new FrmCgg_res_tipo_notificacion("insert");
                objCgg_res_tipo_notificacion.closeHandler(function(){
                    gsCgg_res_tipo_notificacion.reload();
                });
                objCgg_res_tipo_notificacion.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_tipo_notificacion.
     */
    var btnEditarCgg_res_tipo_notificacion = new Ext.Button({
        id:'btnEditarCgg_res_tipo_notificacion',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:'Edita tipo notificaci\u00f3n seleccionado',
        listeners:{
            click:function(){
                var r=grdCgg_res_tipo_notificacion.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_tipo_notificacion = new FrmCgg_res_tipo_notificacion("update",r);
                    objCgg_res_tipo_notificacion.closeHandler(function(){
                        gsCgg_res_tipo_notificacion.reload();
                    });
                    objCgg_res_tipo_notificacion.loadData();
                    objCgg_res_tipo_notificacion.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_tipo_notificacion.
     */
    var btnEliminarCgg_res_tipo_notificacion = new Ext.Button({
        id:'btnEliminarCgg_res_tipo_notificacion',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:'Elimina tipo notificaci\u00f3n seleccionado',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_tipo_notificacion,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_tipo_notificacion(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_tipo_notificacion(r){
                            winFrmListadoCgg_res_tipo_notificacion.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_tipo_notificacion,
                                    msg: 'La informaci\u00f3n de tipo notificaci\u00f3n ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_tipo_notificacion.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_tipo_notificacion,
                                    msg: 'La informaci\u00f3n de tipo notificaci\u00f3n no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_tipo_notificacion.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrtnt_codigo',grdCgg_res_tipo_notificacion.getSelectionModel().getSelected().get('CRTNT_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_tipo_notificacion,"delete",param, true, CallBackCgg_res_tipo_notificacion);
                    }catch(inErr){
                        winFrmListadoCgg_res_tipo_notificacion.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_tipo_notificacion.
     */
    var btnSalirCgg_res_tipo_notificacion = new Ext.Button({
        id:'btnSalirCgg_res_tipo_notificacion',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Cerrar',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_tipo_notificacion.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_tipo_notificacion.
     */
    var cmCgg_res_tipo_notificacion = new Ext.grid.ColumnModel([
        {dataIndex:'CRTNT_CODIGO',hidden:true,header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRTNT_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
        {dataIndex:'CRTNT_CAUSAL_SALIDA',header:'Causal salida',width:150,sortable:true,xtype:'booleancolumn',trueText: 'Si',falseText: 'No',editor: {
            xtype: 'checkbox'}},
        {dataIndex:'CRTNT_SUSTENTO_LEGAL',header:'Sustento legal',width:150,sortable:true},
        {dataIndex:'CRTNT_CAUSAL_CADUCIDAD',header:'Causal caducidad',width:150,sortable:true,xtype:'booleancolumn',trueText: 'Si',falseText: 'No',editor: {
            xtype: 'checkbox'}}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_tipo_notificacion por un campo especifico.
     */
    var gsCgg_res_tipo_notificacion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_tipo_notificacion",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRTNT_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRTNT_CODIGO'},
            {name:'CRTNT_DESCRIPCION'},
            {name:'CRTNT_CAUSAL_SALIDA'},
            {name:'CRTNT_SUSTENTO_LEGAL'},
            {name:'CRTNT_CAUSAL_CADUCIDAD'}
        ]),
        sortInfo:{field: 'CRTNT_DESCRIPCION', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_tipo_notificacion.
     */
    var pgBarCgg_res_tipo_notificacion= new Ext.PagingToolbar({
        store: gsCgg_res_tipo_notificacion,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_tipo_notificacion en un formato tabular de filas y columnas.
     */
    var grdCgg_res_tipo_notificacion = new Ext.grid.GridPanel({
        cm:cmCgg_res_tipo_notificacion,
        store:gsCgg_res_tipo_notificacion,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_tipo_notificacion,
                width:200
            })
        ],
        bbar:pgBarCgg_res_tipo_notificacion,
        viewconfig:{
            forceFit:true
        },
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_tipo_notificacion.hidden){
                    btnEditarCgg_res_tipo_notificacion.fireEvent('click', btnEditarCgg_res_tipo_notificacion);
                }
            }}});
    gsCgg_res_tipo_notificacion.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_tipo_notificacion.
     */
    var winFrmListadoCgg_res_tipo_notificacion =null;
    if (inDesktop){
             winFrmListadoCgg_res_tipo_notificacion = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_tipo_notificacion',
            title:tituloListadoCgg_res_tipo_notificacion,
            tbar:getPanelTitulo(''+tituloListadoCgg_res_tipo_notificacion,descListadoCgg_res_tipo_notificacion),
            items:[grdCgg_res_tipo_notificacion],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            resizable:true,
            //constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_tipo_notificacion,btnEditarCgg_res_tipo_notificacion,btnEliminarCgg_res_tipo_notificacion,'->',btnSalirCgg_res_tipo_notificacion]
        });
    }
    else
    {
            winFrmListadoCgg_res_tipo_notificacion = new Ext.Window({
            id:'winFrmListadoCgg_res_tipo_notificacion',
            title:tituloListadoCgg_res_tipo_notificacion,
            tbar:getPanelTitulo(''+tituloListadoCgg_res_tipo_notificacion,descListadoCgg_res_tipo_notificacion),
            items:[grdCgg_res_tipo_notificacion],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            resizable:true,
            //constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_tipo_notificacion,btnEditarCgg_res_tipo_notificacion,btnEliminarCgg_res_tipo_notificacion,'->',btnSalirCgg_res_tipo_notificacion]
        });

    }
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_tipo_notificacion.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_tipo_notificacion.
     * @returns ventana winFrmCgg_res_tipo_notificacion.
     * @base FrmListadoCgg_res_tipo_notificacion.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_tipo_notificacion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_tipo_notificacion.
     * @base FrmListadoCgg_res_tipo_notificacion.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_tipo_notificacion.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_tipo_notificacion;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_tipo_notificacion;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_tipo_notificacion.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_tipo_notificacion.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_tipo_notificacion desde una instancia.
 */
FrmListadoCgg_res_tipo_notificacion.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_tipo_notificacion desde una instancia.
 */
FrmListadoCgg_res_tipo_notificacion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_tipo_notificacion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_tipo_notificacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_tipo_notificacion desde una instancia.
 */
FrmListadoCgg_res_tipo_notificacion.prototype.loadData = function(){
    this.loadData();
}
