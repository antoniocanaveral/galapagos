/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_nacionalidad.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_nacionalidad(inDesktop){
    var optMenu = 'Configuraci\u00F3n/Administraci\u00F3n de persona/Administraci\u00F3n de nacionalidad';
    var urlListadoCgg_nacionalidad=URL_WS+"Cgg_nacionalidad";
    var tituloListadoCgg_nacionalidad='Listado nacionalidad';
    var descListadoCgg_nacionalidad='El formulario permite administrar informaci\u00F3n de Nacionalidad';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_nacionalidad.
     */
    var btnNuevoCgg_nacionalidad = new Ext.Button({
        id:'btnNuevoCgg_nacionalidad',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Nuevo registro',
        listeners:{
            click:function(){
                var objCgg_nacionalidad = new FrmCgg_nacionalidad("insert");
                objCgg_nacionalidad.closeHandler(function(){
                    gsCgg_nacionalidad.reload();
                });
                objCgg_nacionalidad.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_nacionalidad.
     */
    var btnEditarCgg_nacionalidad = new Ext.Button({
        id:'btnEditarCgg_nacionalidad',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:'Editar informaci\u00f3n de nacionalidad',
        listeners:{
            click:function(){
                var r=grdCgg_nacionalidad.getSelectionModel().getSelected();
                if(r){
                    var objCgg_nacionalidad = new FrmCgg_nacionalidad("update",r);
                    objCgg_nacionalidad.closeHandler(function(){
                        gsCgg_nacionalidad.reload();
                    });
                    objCgg_nacionalidad.loadData();
                    objCgg_nacionalidad.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_nacionalidad.
     */
    var btnEliminarCgg_nacionalidad = new Ext.Button({
        id:'btnEliminarCgg_nacionalidad',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:'Eliminar registro seleccionado',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_nacionalidad,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_nacionalidad(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_nacionalidad(r){
                            winFrmListadoCgg_nacionalidad.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_nacionalidad,
                                    msg: 'La informaci\u00f3n de nacionalidad ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_nacionalidad.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_nacionalidad,
                                    msg: 'La informaci\u00f3n de nacionalidad no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_nacionalidad.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCgncn_codigo',grdCgg_nacionalidad.getSelectionModel().getSelected().get('CGNCN_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_nacionalidad,"delete",param, true, CallBackCgg_nacionalidad);
                    }catch(inErr){
                        winFrmListadoCgg_nacionalidad.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_nacionalidad.
     */
    var btnSalirCgg_nacionalidad = new Ext.Button({
        id:'btnSalirCgg_nacionalidad',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Salir',
        listeners:{
            click:function(){
                winFrmListadoCgg_nacionalidad.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_nacionalidad.
     */
    var cmCgg_nacionalidad = new Ext.grid.ColumnModel([
        {dataIndex:'CGNCN_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CGNCN_NACIONALIDAD',header:'Nacionalidad',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_nacionalidad por un campo especifico.
     */
    var gsCgg_nacionalidad = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_nacionalidad",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CGNCN_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CGNCN_CODIGO'},
            {name:'CGNCN_NACIONALIDAD'}
        ]),
        sortInfo:{field: 'CGNCN_NACIONALIDAD', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_nacionalidad.
     */
    var pgBarCgg_nacionalidad= new Ext.PagingToolbar({
        store: gsCgg_nacionalidad,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_nacionalidad en un formato tabular de filas y columnas.
     */
    var grdCgg_nacionalidad = new Ext.grid.GridPanel({
        cm:cmCgg_nacionalidad,
        store:gsCgg_nacionalidad,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        viewConfig:{forceFit:true},
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_nacionalidad,
                width:200
            })
        ],
        bbar:pgBarCgg_nacionalidad,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_nacionalidad.hidden){
                    btnEditarCgg_nacionalidad.fireEvent('click', btnEditarCgg_nacionalidad);
                }
            }}});
    gsCgg_nacionalidad.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_nacionalidad.
     */
    var winFrmListadoCgg_nacionalidad = null;
    if(inDesktop!==null && inDesktop!==undefined){
        winFrmListadoCgg_nacionalidad = inDesktop.createWindow({
            id:'winFrmListadoCgg_nacionalidad',
            title:tituloListadoCgg_nacionalidad,
            tbar:getPanelTitulo(tituloListadoCgg_nacionalidad,descListadoCgg_nacionalidad),
            items:[grdCgg_nacionalidad],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_nacionalidad,btnEditarCgg_nacionalidad,btnEliminarCgg_nacionalidad,'->',btnSalirCgg_nacionalidad]
        });
    }
    else
    {
        winFrmListadoCgg_nacionalidad = new Ext.Window({
            id:'winFrmListadoCgg_nacionalidad',
            title:tituloListadoCgg_nacionalidad,
            tbar:getPanelTitulo(tituloListadoCgg_nacionalidad,descListadoCgg_nacionalidad),
            items:[grdCgg_nacionalidad],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_nacionalidad,btnEditarCgg_nacionalidad,btnEliminarCgg_nacionalidad,'->',btnSalirCgg_nacionalidad]
        });

    }
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_nacionalidad.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_nacionalidad.
     * @returns ventana winFrmCgg_nacionalidad.
     * @base FrmListadoCgg_nacionalidad.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_nacionalidad;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_nacionalidad.
     * @base FrmListadoCgg_nacionalidad.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_nacionalidad.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_nacionalidad;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_nacionalidad;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_nacionalidad.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_nacionalidad.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_nacionalidad desde una instancia.
 */
FrmListadoCgg_nacionalidad.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_nacionalidad desde una instancia.
 */
FrmListadoCgg_nacionalidad.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_nacionalidad,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_nacionalidad.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_nacionalidad desde una instancia.
 */
FrmListadoCgg_nacionalidad.prototype.loadData = function(){
    this.loadData();
}
