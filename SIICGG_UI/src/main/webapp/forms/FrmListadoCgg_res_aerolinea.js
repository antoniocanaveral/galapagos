/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_aerolinea.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_aerolinea(inDesktop){
    var optMenu = 'TCT/Aerolinea';
    var urlListadoCgg_res_aerolinea=URL_WS+"Cgg_res_aerolinea";
    var tituloListadoCgg_res_aerolinea='Aerol\u00ednea';
    var descListadoCgg_res_aerolinea='El formulario permite administrar informaci\u00f3n de la Aerol\u00ednea';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_aerolinea.
     */
    var btnNuevoCgg_res_aerolinea = new Ext.Button({
        id:'btnNuevoCgg_res_aerolinea',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_aerolinea = new FrmCgg_res_aerolinea("insert");
                objCgg_res_aerolinea.closeHandler(function(){
                    gsCgg_res_aerolinea.reload();
                });
                objCgg_res_aerolinea.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_aerolinea.
     */
    var btnEditarCgg_res_aerolinea = new Ext.Button({
        id:'btnEditarCgg_res_aerolinea',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_aerolinea.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_aerolinea = new FrmCgg_res_aerolinea("update",r);
                    objCgg_res_aerolinea.closeHandler(function(){
                        gsCgg_res_aerolinea.reload();
                    });
                    objCgg_res_aerolinea.loadData();
                    objCgg_res_aerolinea.show();
                }else{
                    Ext.MessageBox.alert('Aerol\u00ednea', 'Seleccione un registro para continuar');
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_aerolinea.
     */
    var btnEliminarCgg_res_aerolinea = new Ext.Button({
        id:'btnEliminarCgg_res_aerolinea',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_aerolinea,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_aerolinea(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_aerolinea(r){
                            winFrmListadoCgg_res_aerolinea.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_aerolinea,
                                    msg: 'La informaci\u00f3n de la Aerol\u00ednea ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_aerolinea.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_aerolinea,
                                    msg: 'La informaci\u00f3n de la Aerol\u00ednea no ha podido ser eliminada.'+ (r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_aerolinea.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCraln_codigo',grdCgg_res_aerolinea.getSelectionModel().getSelected().get('CRALN_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_aerolinea,"delete",param, true, CallBackCgg_res_aerolinea);
                    }catch(inErr){
                        winFrmListadoCgg_res_aerolinea.getEl().unmask();
                    }}}

            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_aerolinea.
     */
    var btnSalirCgg_res_aerolinea = new Ext.Button({
        id:'btnSalirCgg_res_aerolinea',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_aerolinea.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_aerolinea.
     */
    var cmCgg_res_aerolinea = new Ext.grid.ColumnModel([
        {dataIndex:'CRALN_CODIGO',header:'Codigo',width:150,sortable:true, hidden: true},
        {dataIndex:'CRALN_NOMBRE',header:'Nombre',width:580,sortable:true},
		{dataIndex:'CRALN_TIPO_AEROLINEA',hidden:true,header:'Tipo aerolinea',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_aerolinea por un campo especifico.
     */
    var gsCgg_res_aerolinea = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_aerolinea",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRALN_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRALN_CODIGO'},
            {name:'CRALN_NOMBRE'},
			{name:'CRALN_TIPO_AEROLINEA'}
        ]),
        sortInfo:{field: 'CRALN_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_aerolinea.
     */
    var pgBarCgg_res_aerolinea= new Ext.PagingToolbar({
        store: gsCgg_res_aerolinea,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_aerolinea en un formato tabular de filas y columnas.
     */
    var grdCgg_res_aerolinea = new Ext.grid.GridPanel({
        cm:cmCgg_res_aerolinea,
        store:gsCgg_res_aerolinea,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_aerolinea,
                width:200
            })
        ],
        bbar:pgBarCgg_res_aerolinea,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_aerolinea.hidden){
                    btnEditarCgg_res_aerolinea.fireEvent('click', btnEditarCgg_res_aerolinea);
                }
            }}});
    gsCgg_res_aerolinea.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_aerolinea.
     */
    if(inDesktop){
        var winFrmListadoCgg_res_aerolinea = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_aerolinea',
            title:tituloListadoCgg_res_aerolinea,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_aerolinea,descListadoCgg_res_aerolinea),
            items:[grdCgg_res_aerolinea],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_aerolinea,btnEditarCgg_res_aerolinea,btnEliminarCgg_res_aerolinea,'->',btnSalirCgg_res_aerolinea]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_res_aerolinea.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_aerolinea.
     * @returns ventana winFrmCgg_res_aerolinea.
     * @base FrmListadoCgg_res_aerolinea.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_aerolinea;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_aerolinea.
     * @base FrmListadoCgg_res_aerolinea.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_aerolinea.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_aerolinea;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_aerolinea;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_aerolinea.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_aerolinea.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_aerolinea desde una instancia.
 */
FrmListadoCgg_res_aerolinea.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_aerolinea desde una instancia.
 */
FrmListadoCgg_res_aerolinea.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_aerolinea,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_aerolinea.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_aerolinea desde una instancia.
 */
FrmListadoCgg_res_aerolinea.prototype.loadData = function(){
    this.loadData();
}
