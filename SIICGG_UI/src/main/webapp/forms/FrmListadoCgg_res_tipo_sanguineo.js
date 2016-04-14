/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_tipo_sanguineo.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_tipo_sanguineo(inDesktop){    
	var optMenu = 'Configuraci\u00F3n/Administraci\u00F3n de persona/Administraci\u00F3n de tipo sangu\u00EDneo';
    var urlListadoCgg_res_tipo_sanguineo=URL_WS+"Cgg_res_tipo_sanguineo";
    var tituloListadoCgg_res_tipo_sanguineo='Listado tipo sangu\u00EDneo';
    var descListadoCgg_res_tipo_sanguineo='El formulario permite administrar informaci\u00F3n de tipo sangu\u00EDneo';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_tipo_sanguineo.
     */
    var btnNuevoCgg_res_tipo_sanguineo = new Ext.Button({
        id:'btnNuevoCgg_res_tipo_sanguineo',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Nuevo registro',
        listeners:{
            click:function(){
                var objCgg_res_tipo_sanguineo = new FrmCgg_res_tipo_sanguineo("insert");
                objCgg_res_tipo_sanguineo.closeHandler(function(){
                    gsCgg_res_tipo_sanguineo.reload();
                });
                objCgg_res_tipo_sanguineo.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_tipo_sanguineo.
     */
    var btnEditarCgg_res_tipo_sanguineo = new Ext.Button({
        id:'btnEditarCgg_res_tipo_sanguineo',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:'Editar informaci\u00f3n tipo sanguineo',
        listeners:{
            click:function(){
                var r=grdCgg_res_tipo_sanguineo.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_tipo_sanguineo = new FrmCgg_res_tipo_sanguineo("update",r);
                    objCgg_res_tipo_sanguineo.closeHandler(function(){
                        gsCgg_res_tipo_sanguineo.reload();
                    });
                    objCgg_res_tipo_sanguineo.loadData();
                    objCgg_res_tipo_sanguineo.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_tipo_sanguineo.
     */
    var btnEliminarCgg_res_tipo_sanguineo = new Ext.Button({
        id:'btnEliminarCgg_res_tipo_sanguineo',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:'Eliminar registro seleccionado',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_tipo_sanguineo,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_tipo_sanguineo(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_tipo_sanguineo(r){
                            winFrmListadoCgg_res_tipo_sanguineo.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_tipo_sanguineo,
                                    msg: 'La informaci\u00f3n de tipo sanguineo ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_tipo_sanguineo.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_tipo_sanguineo,
                                    msg: 'La informaci\u00f3n de tipo sanguineo no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_tipo_sanguineo.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrtsg_codigo',grdCgg_res_tipo_sanguineo.getSelectionModel().getSelected().get('CRTSG_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_tipo_sanguineo,"delete",param, true, CallBackCgg_res_tipo_sanguineo);
                    }catch(inErr){
                        winFrmListadoCgg_res_tipo_sanguineo.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_tipo_sanguineo.
     */
    var btnSalirCgg_res_tipo_sanguineo = new Ext.Button({
        id:'btnSalirCgg_res_tipo_sanguineo',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Salir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_tipo_sanguineo.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_tipo_sanguineo.
     */
    var cmCgg_res_tipo_sanguineo = new Ext.grid.ColumnModel([
        {dataIndex:'CRTSG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRTSG_DESCRPCION',header:'Descrpcion',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_tipo_sanguineo por un campo especifico.
     */
    var gsCgg_res_tipo_sanguineo = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_tipo_sanguineo",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRTSG_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRTSG_CODIGO'},
            {name:'CRTSG_DESCRPCION'}
        ]),
        sortInfo:{field: 'CRTSG_DESCRPCION', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_tipo_sanguineo.
     */
    var pgBarCgg_res_tipo_sanguineo= new Ext.PagingToolbar({
        store: gsCgg_res_tipo_sanguineo,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_tipo_sanguineo en un formato tabular de filas y columnas.
     */
    var grdCgg_res_tipo_sanguineo = new Ext.grid.GridPanel({
        cm:cmCgg_res_tipo_sanguineo,
        store:gsCgg_res_tipo_sanguineo,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        viewConfig:{forceFit:true},
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_tipo_sanguineo,
                width:200
            })
        ],
        bbar:pgBarCgg_res_tipo_sanguineo,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_tipo_sanguineo.hidden){
                    btnEditarCgg_res_tipo_sanguineo.fireEvent('click', btnEditarCgg_res_tipo_sanguineo);
                }
            }}});
    gsCgg_res_tipo_sanguineo.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_tipo_sanguineo.
     */
     var winFrmListadoCgg_res_tipo_sanguineo = null;
    if(inDesktop!==null && inDesktop!==undefined){
        winFrmListadoCgg_res_tipo_sanguineo = inDesktop.createWindow({
         id:'winFrmListadoCgg_res_tipo_sanguineo',
        title:tituloListadoCgg_res_tipo_sanguineo,
        tbar:getPanelTitulo(tituloListadoCgg_res_tipo_sanguineo,descListadoCgg_res_tipo_sanguineo),
        items:[grdCgg_res_tipo_sanguineo],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_res_tipo_sanguineo,btnEditarCgg_res_tipo_sanguineo,btnEliminarCgg_res_tipo_sanguineo,'->',btnSalirCgg_res_tipo_sanguineo]
    });
    }
    else
    {
        winFrmListadoCgg_res_tipo_sanguineo = new Ext.Window({
         id:'winFrmListadoCgg_res_tipo_sanguineo',
        title:tituloListadoCgg_res_tipo_sanguineo,
        tbar:getPanelTitulo(tituloListadoCgg_res_tipo_sanguineo,descListadoCgg_res_tipo_sanguineo),
        items:[grdCgg_res_tipo_sanguineo],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_res_tipo_sanguineo,btnEditarCgg_res_tipo_sanguineo,btnEliminarCgg_res_tipo_sanguineo,'->',btnSalirCgg_res_tipo_sanguineo]
    });

    }
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_tipo_sanguineo.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_tipo_sanguineo.
     * @returns ventana winFrmCgg_res_tipo_sanguineo.
     * @base FrmListadoCgg_res_tipo_sanguineo.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_tipo_sanguineo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_tipo_sanguineo.
     * @base FrmListadoCgg_res_tipo_sanguineo.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_tipo_sanguineo.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_tipo_sanguineo;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_tipo_sanguineo;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_tipo_sanguineo.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_tipo_sanguineo.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_tipo_sanguineo desde una instancia.
 */
FrmListadoCgg_res_tipo_sanguineo.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_tipo_sanguineo desde una instancia.
 */
FrmListadoCgg_res_tipo_sanguineo.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_tipo_sanguineo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_tipo_sanguineo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_tipo_sanguineo desde una instancia.
 */
FrmListadoCgg_res_tipo_sanguineo.prototype.loadData = function(){
    this.loadData();
}
