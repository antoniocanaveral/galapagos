/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_aeropuerto.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_aeropuerto(inDesktop){
    var optMenu = 'TCT/Aeropuerto';
    var urlListadoCgg_res_aeropuerto=URL_WS+"Cgg_res_aeropuerto";
    var tituloListadoCgg_res_aeropuerto='Aeropuerto';
    var descListadoCgg_res_aeropuerto='El formulario permite administrar informaci\u00f3n del Aeropuerto';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_aeropuerto.
     */
    var btnNuevoCgg_res_aeropuerto = new Ext.Button({
        id:'btnNuevoCgg_res_aeropuerto',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_aeropuerto = new FrmCgg_res_aeropuerto("insert");
                objCgg_res_aeropuerto.closeHandler(function(){
                    gsCgg_res_aeropuerto.reload();
                });
                objCgg_res_aeropuerto.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_aeropuerto.
     */
    var btnEditarCgg_res_aeropuerto = new Ext.Button({
        id:'btnEditarCgg_res_aeropuerto',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_aeropuerto.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_aeropuerto = new FrmCgg_res_aeropuerto("update",r);
                    objCgg_res_aeropuerto.closeHandler(function(){
                        gsCgg_res_aeropuerto.reload();
                    });
                    objCgg_res_aeropuerto.loadData();
                    objCgg_res_aeropuerto.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_aeropuerto.
     */
    var btnEliminarCgg_res_aeropuerto = new Ext.Button({
        id:'btnEliminarCgg_res_aeropuerto',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_aeropuerto,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_aeropuerto(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_aeropuerto(r){
                            winFrmListadoCgg_res_aeropuerto.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_aeropuerto,
                                    msg: 'La informaci\u00f3n del Aeropuerto ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_aeropuerto.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_aeropuerto,
                                    msg: 'La informaci\u00f3n del Aeropuerto no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_aeropuerto.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCarpt_codigo',grdCgg_res_aeropuerto.getSelectionModel().getSelected().get('CARPT_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_aeropuerto,"delete",param, true, CallBackCgg_res_aeropuerto);
                    }catch(inErr){
                        winFrmListadoCgg_res_aeropuerto.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_aeropuerto.
     */
    var btnSalirCgg_res_aeropuerto = new Ext.Button({
        id:'btnSalirCgg_res_aeropuerto',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_aeropuerto.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_aeropuerto.
     */
    var cmCgg_res_aeropuerto = new Ext.grid.ColumnModel([        
        {dataIndex:'CANTON',header:'Cant\u00f3n',width:150,sortable:true},
        {dataIndex:'CARPT_NOMBRE',header:'Nombre',width:250,sortable:true},
		{dataIndex:'CARPT_TIPO_AEREOPUERTO',header:'<i>Tipo</i>',width:100,sortable:true,
			renderer:function(v){
				return ("<i>"+((v==1)?"Interno":'Externo')+"</i>");
			}
		}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_aeropuerto por un campo especifico.
     */
    var gsCgg_res_aeropuerto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_aeropuerto",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CARPT_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CARPT_CODIGO'},
            {name:'CCTN_CODIGO'},
            {name:'CANTON'},
            {name:'CARPT_NOMBRE'},
			{name:'CARPT_TIPO_AEREOPUERTO'}
        ]),
        sortInfo:{field: 'CCTN_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_aeropuerto.
     */
    var pgBarCgg_res_aeropuerto= new Ext.PagingToolbar({
        store: gsCgg_res_aeropuerto,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_aeropuerto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_aeropuerto = new Ext.grid.GridPanel({
        cm:cmCgg_res_aeropuerto,
        store:gsCgg_res_aeropuerto,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_aeropuerto,
                width:200
            })
        ],
        bbar:pgBarCgg_res_aeropuerto,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_aeropuerto.hidden){
                    btnEditarCgg_res_aeropuerto.fireEvent('click', btnEditarCgg_res_aeropuerto);
                }
            }}});
    gsCgg_res_aeropuerto.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_aeropuerto.
     */
    if(inDesktop){
        var winFrmListadoCgg_res_aeropuerto = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_aeropuerto',
            title:tituloListadoCgg_res_aeropuerto,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_aeropuerto,descListadoCgg_res_aeropuerto),
            items:[grdCgg_res_aeropuerto],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_aeropuerto,btnEditarCgg_res_aeropuerto,btnEliminarCgg_res_aeropuerto,'->',btnSalirCgg_res_aeropuerto]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_res_aeropuerto.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_aeropuerto.
     * @returns ventana winFrmCgg_res_aeropuerto.
     * @base FrmListadoCgg_res_aeropuerto.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_aeropuerto;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_aeropuerto.
     * @base FrmListadoCgg_res_aeropuerto.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_aeropuerto.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_aeropuerto;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_aeropuerto;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_aeropuerto.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_aeropuerto.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_aeropuerto desde una instancia.
 */
FrmListadoCgg_res_aeropuerto.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_aeropuerto desde una instancia.
 */
FrmListadoCgg_res_aeropuerto.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_aeropuerto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_aeropuerto.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_aeropuerto desde una instancia.
 */
FrmListadoCgg_res_aeropuerto.prototype.loadData = function(){
    this.loadData();
}
