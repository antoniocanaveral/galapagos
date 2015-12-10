/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_tipo_contacto.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_tipo_contacto(inDesktop){
	var optMenu = 'Configuraci\u00F3n/Administraci\u00F3n de persona/Administraci\u00F3n de tipo contacto';
    var urlListadoCgg_res_tipo_contacto=URL_WS+"Cgg_res_tipo_contacto";
    var tituloListadoCgg_res_tipo_contacto='Listado tipo contacto';
    var descListadoCgg_res_tipo_contacto='El formulario permite administrar informaci\u00f3n de tipo contacto';
    var tmpUserSession = new UserSession();
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_tipo_contacto.
     */
    var btnNuevoCgg_res_tipo_contacto = new Ext.Button({
        id:'btnNuevoCgg_res_tipo_contacto',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_tipo_contacto = new FrmCgg_res_tipo_contacto("insert");
                objCgg_res_tipo_contacto.closeHandler(function(){
                    gsCgg_res_tipo_contacto.reload();
                });
                objCgg_res_tipo_contacto.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_tipo_contacto.
     */
    var btnEditarCgg_res_tipo_contacto = new Ext.Button({
        id:'btnEditarCgg_res_tipo_contacto',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_tipo_contacto.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_tipo_contacto = new FrmCgg_res_tipo_contacto("update",r);
                    objCgg_res_tipo_contacto.closeHandler(function(){
                        gsCgg_res_tipo_contacto.reload();
                    });
                    objCgg_res_tipo_contacto.loadData();
                    objCgg_res_tipo_contacto.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_tipo_contacto.
     */
    var btnEliminarCgg_res_tipo_contacto = new Ext.Button({
        id:'btnEliminarCgg_res_tipo_contacto',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_tipo_contacto,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_tipo_contacto(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_tipo_contacto(r){
                            winFrmListadoCgg_res_tipo_contacto.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_tipo_contacto,
                                    msg: 'La informaci\u00f3n de Res tipo contacto ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_tipo_contacto.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_tipo_contacto,
                                    msg: 'La informaci\u00f3n de Cgg_res_tipo_contacto no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_tipo_contacto.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrtco_codigo',grdCgg_res_tipo_contacto.getSelectionModel().getSelected().get('CRTCO_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_tipo_contacto,"delete",param, true, CallBackCgg_res_tipo_contacto);
                    }catch(inErr){
                        winFrmListadoCgg_res_tipo_contacto.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_tipo_contacto.
     */
    var btnSalirCgg_res_tipo_contacto = new Ext.Button({
        id:'btnSalirCgg_res_tipo_contacto',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_tipo_contacto.close();
            }}
    });    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_tipo_contacto.
     */
    var cmCgg_res_tipo_contacto = new Ext.grid.ColumnModel([
        {dataIndex:'CRTCO_CODIGO',header:'Imagen',width:150,sortable:true,renderer:
                function(value, metaData, record){
                    var auxCadena = null;
                      new Ajax.Request(URL_DOC_VIEWER, {
                      onSuccess: function(response) {
                          auxCadena = '<div><img src="/siiws/tmp/'+tmpUserSession.getUserName().trim()+'/'+record.get('CRTCO_NOMBRE_IMAGEN')+'"/></div>';
                      },
                      onFailure:function(response){

                      },
                      asynchronous:false,
                      parameters:{
                            table:'cgg_res_tipo_contacto',
                            keyc:'crtco_codigo',
                            keyv:record.get('CRTCO_CODIGO'),
                            column:'crtco_imagen',
                            fn:record.get('CRTCO_NOMBRE_IMAGEN'),
                            request:'view'
                        }
                    });
                    return auxCadena;
                 }},
        {dataIndex:'CRTCO_NOMBRE',header:'Nombre',width:150,sortable:true},
        {dataIndex:'CRTCO_NOMBRE_IMAGEN',header:'Nombre imagen',width:150,sortable:true,hidden:true},
        {dataIndex:'CRTCO_IMAGEN',header:'Imagen',width:150,sortable:true,hidden:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_tipo_contacto por un campo especifico.
     */
    var gsCgg_res_tipo_contacto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_tipo_contacto",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRTCO_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRTCO_CODIGO'},
            {name:'CRTCO_NOMBRE'},
            {name:'CRTCO_NOMBRE_IMAGEN'},
            {name:'CRTCO_IMAGEN'}
        ]),
        sortInfo:{field: 'CRTCO_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_tipo_contacto.
     */
    var pgBarCgg_res_tipo_contacto= new Ext.PagingToolbar({
        store: gsCgg_res_tipo_contacto,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
     
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_tipo_contacto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_tipo_contacto = new Ext.grid.GridPanel({
        cm:cmCgg_res_tipo_contacto,
        store:gsCgg_res_tipo_contacto,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        viewConfig:{forceFit:true},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_tipo_contacto,
                width:200
            })
        ],
        bbar:pgBarCgg_res_tipo_contacto,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_tipo_contacto.hidden){
                    btnEditarCgg_res_tipo_contacto.fireEvent('click', btnEditarCgg_res_tipo_contacto);
                }
            }}});
    gsCgg_res_tipo_contacto.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_tipo_contacto.
     */
    var winFrmListadoCgg_res_tipo_contacto = null;
if(inDesktop !== null && inDesktop !==undefined){
    winFrmListadoCgg_res_tipo_contacto = inDesktop.createWindow({
        id:'winFrmListadoCgg_res_tipo_contacto',
        title:tituloListadoCgg_res_tipo_contacto,
        tbar:getPanelTitulo(tituloListadoCgg_res_tipo_contacto,descListadoCgg_res_tipo_contacto),
        items:[grdCgg_res_tipo_contacto],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_res_tipo_contacto,btnEditarCgg_res_tipo_contacto,btnEliminarCgg_res_tipo_contacto,'->',btnSalirCgg_res_tipo_contacto]
    });
}else{
    winFrmListadoCgg_res_tipo_contacto = new Ext.Window({
        id:'winFrmListadoCgg_res_tipo_contacto',
        title:tituloListadoCgg_res_tipo_contacto,
        tbar:getPanelTitulo(tituloListadoCgg_res_tipo_contacto,descListadoCgg_res_tipo_contacto),
        items:[grdCgg_res_tipo_contacto],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_res_tipo_contacto,btnEditarCgg_res_tipo_contacto,btnEliminarCgg_res_tipo_contacto,'->',btnSalirCgg_res_tipo_contacto]
    });
}


    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_tipo_contacto.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_tipo_contacto.
     * @returns ventana winFrmCgg_res_tipo_contacto.
     * @base FrmListadoCgg_res_tipo_contacto.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_tipo_contacto;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_tipo_contacto.
     * @base FrmListadoCgg_res_tipo_contacto.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_tipo_contacto.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_tipo_contacto;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_tipo_contacto;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_tipo_contacto.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_tipo_contacto.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_tipo_contacto desde una instancia.
 */
FrmListadoCgg_res_tipo_contacto.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_tipo_contacto desde una instancia.
 */
FrmListadoCgg_res_tipo_contacto.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_tipo_contacto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_tipo_contacto.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_tipo_contacto desde una instancia.
 */
FrmListadoCgg_res_tipo_contacto.prototype.loadData = function(){
    this.loadData();
}
