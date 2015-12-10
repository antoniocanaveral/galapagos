/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_tipo_cacademico.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_tipo_cacademico(inDescktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Beca/Configuraci\u00F3n/Tipo Certificado';
    var urlListadoCgg_dhu_tipo_cacademico=URL_WS+"Cgg_dhu_tipo_cacademico";
    var tituloListadoCgg_dhu_tipo_cacademico='Tipo certificado';
    var descListadoCgg_dhu_tipo_cacademico='El formulario permite administrar informaci\u00f3n sobre los diferentes tipos de certificados acad\u00E9micos';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_tipo_cacademico.
     */
    var btnNuevoCgg_dhu_tipo_cacademico = new Ext.Button({
        id:'btnNuevoCgg_dhu_tipo_cacademico',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_dhu_tipo_cacademico = new FrmCgg_dhu_tipo_cacademico("insert");
                objCgg_dhu_tipo_cacademico.closeHandler(function(){
                    gsCgg_dhu_tipo_cacademico.reload();
                });
                objCgg_dhu_tipo_cacademico.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_tipo_cacademico.
     */
    var btnEditarCgg_dhu_tipo_cacademico = new Ext.Button({
        id:'btnEditarCgg_dhu_tipo_cacademico',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_dhu_tipo_cacademico.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_tipo_cacademico = new FrmCgg_dhu_tipo_cacademico("update",r);
                    objCgg_dhu_tipo_cacademico.closeHandler(function(){
                        gsCgg_dhu_tipo_cacademico.reload();
                    });
                    objCgg_dhu_tipo_cacademico.loadData();
                    objCgg_dhu_tipo_cacademico.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_tipo_cacademico.
     */
    var btnEliminarCgg_dhu_tipo_cacademico = new Ext.Button({
        id:'btnEliminarCgg_dhu_tipo_cacademico',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_tipo_cacademico,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_tipo_cacademico(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_tipo_cacademico(r){
                            winFrmListadoCgg_dhu_tipo_cacademico.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_tipo_cacademico,
                                    msg: 'La informaci\u00f3n de Dhu tipo cacademico ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_tipo_cacademico.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_tipo_cacademico,
                                    msg: 'La informaci\u00f3n  no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_tipo_cacademico.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdtca_codigo',grdCgg_dhu_tipo_cacademico.getSelectionModel().getSelected().get('CDTCA_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_tipo_cacademico,"delete",param, true, CallBackCgg_dhu_tipo_cacademico);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_tipo_cacademico.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_tipo_cacademico.
     */
    var btnSalirCgg_dhu_tipo_cacademico = new Ext.Button({
        id:'btnSalirCgg_dhu_tipo_cacademico',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_tipo_cacademico.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_tipo_cacademico.
     */
    var cmCgg_dhu_tipo_cacademico = new Ext.grid.ColumnModel([
        {dataIndex:'CDTCA_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDTCA_NOMBRE',header:'Nombre',width:150,sortable:true},
        {dataIndex:'CDTCA_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_tipo_cacademico por un campo especifico.
     */
    var gsCgg_dhu_tipo_cacademico = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_tipo_cacademico",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDTCA_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDTCA_CODIGO'},
            {name:'CDTCA_NOMBRE'},
            {name:'CDTCA_OBSERVACION'}
        ]),
        sortInfo:{field: 'CDTCA_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_tipo_cacademico.
     */
    var pgBarCgg_dhu_tipo_cacademico= new Ext.PagingToolbar({
        store: gsCgg_dhu_tipo_cacademico,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_tipo_cacademico en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_tipo_cacademico = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_tipo_cacademico,
        store:gsCgg_dhu_tipo_cacademico,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_tipo_cacademico,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_tipo_cacademico,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_tipo_cacademico.hidden){
                    btnEditarCgg_dhu_tipo_cacademico.fireEvent('click', btnEditarCgg_dhu_tipo_cacademico);
                }
            }}});
    gsCgg_dhu_tipo_cacademico.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_tipo_cacademico.
     */
    if(inDescktop){
    var winFrmListadoCgg_dhu_tipo_cacademico = new Ext.Window({
        id:'winFrmListadoCgg_dhu_tipo_cacademico',
        title:tituloListadoCgg_dhu_tipo_cacademico,
        tbar:getPanelTitulo('Listado'+tituloListadoCgg_dhu_tipo_cacademico,descListadoCgg_dhu_tipo_cacademico),
        items:[grdCgg_dhu_tipo_cacademico],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_dhu_tipo_cacademico,btnEditarCgg_dhu_tipo_cacademico,btnEliminarCgg_dhu_tipo_cacademico,'->',btnSalirCgg_dhu_tipo_cacademico]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_dhu_tipo_cacademico.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_tipo_cacademico.
     * @returns ventana winFrmCgg_dhu_tipo_cacademico.
     * @base FrmListadoCgg_dhu_tipo_cacademico.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_tipo_cacademico;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_tipo_cacademico.
     * @base FrmListadoCgg_dhu_tipo_cacademico.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_tipo_cacademico.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_tipo_cacademico;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_tipo_cacademico;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_tipo_cacademico.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_tipo_cacademico.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_tipo_cacademico desde una instancia.
 */
FrmListadoCgg_dhu_tipo_cacademico.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_tipo_cacademico desde una instancia.
 */
FrmListadoCgg_dhu_tipo_cacademico.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_tipo_cacademico,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_tipo_cacademico.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_tipo_cacademico desde una instancia.
 */
FrmListadoCgg_dhu_tipo_cacademico.prototype.loadData = function(){
    this.loadData();
}
