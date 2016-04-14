/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_nivel_estudio.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_nivel_estudio(inDesktop){
    var optMenu = 'Configuraci\u00F3n/Educaci\u00F3n/Nivel de Estudio';
    var urlListadoCgg_nivel_estudio=URL_WS+"Cgg_nivel_estudio";
    var tituloListadoCgg_nivel_estudio='Nivel estudio';
    var descListadoCgg_nivel_estudio='El formulario permite administrar informaci\u00f3n de Nivel estudio';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_nivel_estudio.
     */
    var btnNuevoCgg_nivel_estudio = new Ext.Button({
        id:'btnNuevoCgg_nivel_estudio',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_nivel_estudio = new FrmCgg_nivel_estudio("insert");
                objCgg_nivel_estudio.closeHandler(function(){
                    gsCgg_nivel_estudio.reload();
                });
                objCgg_nivel_estudio.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_nivel_estudio.
     */
    var btnEditarCgg_nivel_estudio = new Ext.Button({
        id:'btnEditarCgg_nivel_estudio',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_nivel_estudio.getSelectionModel().getSelected();
                if(r){
                    var objCgg_nivel_estudio = new FrmCgg_nivel_estudio("update",r);
                    objCgg_nivel_estudio.closeHandler(function(){
                        gsCgg_nivel_estudio.reload();
                    });
                    objCgg_nivel_estudio.loadData();
                    objCgg_nivel_estudio.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_nivel_estudio.
     */
    var btnEliminarCgg_nivel_estudio = new Ext.Button({
        id:'btnEliminarCgg_nivel_estudio',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_nivel_estudio,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_nivel_estudio(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_nivel_estudio(r){
                            winFrmListadoCgg_nivel_estudio.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_nivel_estudio,
                                    msg: 'La informaci\u00f3n de Nivel estudio ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_nivel_estudio.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_nivel_estudio,
                                    msg: 'La informaci\u00f3n de Nivel estudio no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_nivel_estudio.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCgnes_codigo',grdCgg_nivel_estudio.getSelectionModel().getSelected().get('CGNES_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_nivel_estudio,"delete",param, true, CallBackCgg_nivel_estudio);
                    }catch(inErr){
                        winFrmListadoCgg_nivel_estudio.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_nivel_estudio.
     */
    var btnSalirCgg_nivel_estudio = new Ext.Button({
        id:'btnSalirCgg_nivel_estudio',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_nivel_estudio.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_nivel_estudio.
     */
    var cmCgg_nivel_estudio = new Ext.grid.ColumnModel([
        {dataIndex:'CGNES_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CGNES_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
        {dataIndex:'CGNES_GRADO',header:'Grado',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_nivel_estudio por un campo especifico.
     */
    var gsCgg_nivel_estudio = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_nivel_estudio",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CGNES_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CGNES_CODIGO'},
            {name:'CGNES_DESCRIPCION'},
            {name:'CGNES_GRADO'}
        ]),
        sortInfo:{field: 'CGNES_DESCRIPCION', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_nivel_estudio.
     */
    var pgBarCgg_nivel_estudio= new Ext.PagingToolbar({
        store: gsCgg_nivel_estudio,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_nivel_estudio en un formato tabular de filas y columnas.
     */
    var grdCgg_nivel_estudio = new Ext.grid.GridPanel({
        cm:cmCgg_nivel_estudio,
        store:gsCgg_nivel_estudio,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        viewConfig:{forceFit:true},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_nivel_estudio,
                width:200
            })
        ],
        bbar:pgBarCgg_nivel_estudio,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_nivel_estudio.hidden){
                    btnEditarCgg_nivel_estudio.fireEvent('click', btnEditarCgg_nivel_estudio);
                }
            }}});
    gsCgg_nivel_estudio.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_nivel_estudio.
     */
     var winFrmListadoCgg_nivel_estudio = null;

    if(inDesktop!==null && inDesktop!==undefined){
        winFrmListadoCgg_nivel_estudio  = inDesktop.createWindow({
            id:'winFrmListadoCgg_nivel_estudio',
            title:tituloListadoCgg_nivel_estudio,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_nivel_estudio,descListadoCgg_nivel_estudio),
            items:[grdCgg_nivel_estudio],
            bbar:[btnNuevoCgg_nivel_estudio,btnEditarCgg_nivel_estudio,btnEliminarCgg_nivel_estudio,'->',btnSalirCgg_nivel_estudio]
        });
    }
    else
    {
        winFrmListadoCgg_nivel_estudio = new Ext.Window({
            id:'winFrmListadoCgg_nivel_estudio',
            title:tituloListadoCgg_nivel_estudio,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_nivel_estudio,descListadoCgg_nivel_estudio),
            items:[grdCgg_nivel_estudio],
            bbar:[btnNuevoCgg_nivel_estudio,btnEditarCgg_nivel_estudio,btnEliminarCgg_nivel_estudio,'->',btnSalirCgg_nivel_estudio]
        });
    }


    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_nivel_estudio.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_nivel_estudio.
     * @returns ventana winFrmCgg_nivel_estudio.
     * @base FrmListadoCgg_nivel_estudio.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_nivel_estudio;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_nivel_estudio.
     * @base FrmListadoCgg_nivel_estudio.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_nivel_estudio.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_nivel_estudio;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_nivel_estudio;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_nivel_estudio.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_nivel_estudio.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_nivel_estudio desde una instancia.
 */
FrmListadoCgg_nivel_estudio.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_nivel_estudio desde una instancia.
 */
FrmListadoCgg_nivel_estudio.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_nivel_estudio,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_nivel_estudio.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_nivel_estudio desde una instancia.
 */
FrmListadoCgg_nivel_estudio.prototype.loadData = function(){
    this.loadData();
}
