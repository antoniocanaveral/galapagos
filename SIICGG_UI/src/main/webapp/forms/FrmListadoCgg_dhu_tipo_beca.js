/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_tipo_beca.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_tipo_beca(inDescktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Beca/Configuraci\u00F3n/Tipo de beca';
    var urlListadoCgg_dhu_tipo_beca=URL_WS+"Cgg_dhu_tipo_beca";
    var tituloListadoCgg_dhu_tipo_beca='Tipo beca';
    var descListadoCgg_dhu_tipo_beca='El formulario permite administrar informaci\u00f3n sobre los diferentes tipos de beca';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_tipo_beca.
     */
    var btnNuevoCgg_dhu_tipo_beca = new Ext.Button({
        id:'btnNuevoCgg_dhu_tipo_beca',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_dhu_tipo_beca = new FrmCgg_dhu_tipo_beca("insert");
                objCgg_dhu_tipo_beca.closeHandler(function(){
                    gsCgg_dhu_tipo_beca.reload();
                });
                objCgg_dhu_tipo_beca.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_tipo_beca.
     */
    var btnEditarCgg_dhu_tipo_beca = new Ext.Button({
        id:'btnEditarCgg_dhu_tipo_beca',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_dhu_tipo_beca.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_tipo_beca = new FrmCgg_dhu_tipo_beca("update",r);
                    objCgg_dhu_tipo_beca.closeHandler(function(){
                        gsCgg_dhu_tipo_beca.reload();
                    });
                    objCgg_dhu_tipo_beca.loadData();
                    objCgg_dhu_tipo_beca.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_tipo_beca.
     */
    var btnEliminarCgg_dhu_tipo_beca = new Ext.Button({
        id:'btnEliminarCgg_dhu_tipo_beca',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_tipo_beca,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_tipo_beca(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_tipo_beca(r){
                            winFrmListadoCgg_dhu_tipo_beca.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_tipo_beca,
                                    msg: 'La informaci\u00f3n  ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_tipo_beca.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_tipo_beca,
                                    msg: 'La informaci\u00f3n  no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_tipo_beca.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdtbc_codigo',grdCgg_dhu_tipo_beca.getSelectionModel().getSelected().get('CDTBC_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_tipo_beca,"delete",param, true, CallBackCgg_dhu_tipo_beca);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_tipo_beca.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_tipo_beca.
     */
    var btnSalirCgg_dhu_tipo_beca = new Ext.Button({
        id:'btnSalirCgg_dhu_tipo_beca',
        text:'Salir',
        iconCls:'iconSalir',
         tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_tipo_beca.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_tipo_beca.
     */
    var cmCgg_dhu_tipo_beca = new Ext.grid.ColumnModel([
        {dataIndex:'CDTBC_CODIGO',hidden:true,header:'Codigo',width:150,sortable:true},
        {dataIndex:'CDTBC_NOMBRE',header:'Nombre',width:150,sortable:true},
        {dataIndex:'CDTBC_ABREVIATURA',header:'Abreviatura',width:150,sortable:true},
        {dataIndex:'CDTBC_ESTADO_BECA',header:'Estado beca',width:150,sortable:true,renderer:function(inCdhu_Estado_beca){
            if(inCdhu_Estado_beca==TypeEstadoBeca.ACTIVO){
                return('ACTIVO');
            }
            if(inCdhu_Estado_beca==TypeEstadoBeca.INACTIVO){
                return('INACTIVO');
            }
            if(inCdhu_Estado_beca==TypeEstadoBeca.NO_VIGENTE){
                return('NO_VIGENTE');
            }
        }}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_tipo_beca por un campo especifico.
     */
    var gsCgg_dhu_tipo_beca = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_tipo_beca",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDTBC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDTBC_CODIGO'},
            {name:'CDTBC_NOMBRE'},
            {name:'CDTBC_ABREVIATURA'},
            {name:'CDTBC_ESTADO_BECA'}
        ]),
        sortInfo:{field: 'CDTBC_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_tipo_beca.
     */
    var pgBarCgg_dhu_tipo_beca= new Ext.PagingToolbar({
        store: gsCgg_dhu_tipo_beca,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_tipo_beca en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_tipo_beca = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_tipo_beca,
        store:gsCgg_dhu_tipo_beca,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_tipo_beca,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_tipo_beca,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_tipo_beca.hidden){
                    btnEditarCgg_dhu_tipo_beca.fireEvent('click', btnEditarCgg_dhu_tipo_beca);
                }
            }}});
    gsCgg_dhu_tipo_beca.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_tipo_beca.
     */
    if(inDescktop){
    var winFrmListadoCgg_dhu_tipo_beca = inDescktop.createWindow({
        id:'winFrmListadoCgg_dhu_tipo_beca',
        title:tituloListadoCgg_dhu_tipo_beca,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_tipo_beca,descListadoCgg_dhu_tipo_beca),
        items:[grdCgg_dhu_tipo_beca],
        bbar:[btnNuevoCgg_dhu_tipo_beca,btnEditarCgg_dhu_tipo_beca,btnEliminarCgg_dhu_tipo_beca,'->',btnSalirCgg_dhu_tipo_beca]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_dhu_tipo_beca.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_tipo_beca.
     * @returns ventana winFrmCgg_dhu_tipo_beca.
     * @base FrmListadoCgg_dhu_tipo_beca.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_tipo_beca;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_tipo_beca.
     * @base FrmListadoCgg_dhu_tipo_beca.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_tipo_beca.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_tipo_beca;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_tipo_beca;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_tipo_beca.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_tipo_beca.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_tipo_beca desde una instancia.
 */
FrmListadoCgg_dhu_tipo_beca.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_tipo_beca desde una instancia.
 */
FrmListadoCgg_dhu_tipo_beca.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_tipo_beca,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_tipo_beca.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_tipo_beca desde una instancia.
 */
FrmListadoCgg_dhu_tipo_beca.prototype.loadData = function(){
    this.loadData();
}
