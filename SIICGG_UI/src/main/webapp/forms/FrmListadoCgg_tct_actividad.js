/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_tct_actividad.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_tct_actividad(inDesktop){
    var optMenu = 'TCT/Actividad';
    var urlListadoCgg_tct_actividad=URL_WS+"Cgg_tct_actividad";
    var tituloListadoCgg_tct_actividad='Actividad';
    var descListadoCgg_tct_actividad='El formulario permite administrar informaci\u00f3n de la Actividad';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_tct_actividad.
     */
    var btnNuevoCgg_tct_actividad = new Ext.Button({
        id:'btnNuevoCgg_tct_actividad',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_tct_actividad = new FrmCgg_tct_actividad("insert");
                objCgg_tct_actividad.closeHandler(function(){
                    gsCgg_tct_actividad.reload();
                });
                objCgg_tct_actividad.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_tct_actividad.
     */
    var btnEditarCgg_tct_actividad = new Ext.Button({
        id:'btnEditarCgg_tct_actividad',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_tct_actividad.getSelectionModel().getSelected();
                if(r){
                    var objCgg_tct_actividad = new FrmCgg_tct_actividad("update",r);
                    objCgg_tct_actividad.closeHandler(function(){
                        gsCgg_tct_actividad.reload();
                    });
                    objCgg_tct_actividad.loadData();
                    objCgg_tct_actividad.show();
                }else{
                    Ext.MessageBox.alert('Actividad', 'Seleccione un registro para continuar');
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_tct_actividad.
     */
    var btnEliminarCgg_tct_actividad = new Ext.Button({
        id:'btnEliminarCgg_tct_actividad',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_tct_actividad,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_tct_actividad(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_tct_actividad(r){
                            winFrmListadoCgg_tct_actividad.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_tct_actividad,
                                    msg: 'La informaci\u00f3n de la Actividad ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_tct_actividad.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_tct_actividad,
                                    msg: 'La informaci\u00f3n de la Actividad no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_tct_actividad.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCtact_codigo',grdCgg_tct_actividad.getSelectionModel().getSelected().get('CTACT_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_tct_actividad,"delete",param, true, CallBackCgg_tct_actividad);
                    }catch(inErr){
                        winFrmListadoCgg_tct_actividad.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_tct_actividad.
     */
    var btnSalirCgg_tct_actividad = new Ext.Button({
        id:'btnSalirCgg_tct_actividad',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_tct_actividad.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_tct_actividad.
     */
    var cmCgg_tct_actividad = new Ext.grid.ColumnModel([
        {dataIndex:'CTACT_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true},
        {dataIndex:'CTACT_NOMBRE',header:'Nombre',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_tct_actividad por un campo especifico.
     */
    var gsCgg_tct_actividad = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_tct_actividad",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CTACT_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CTACT_CODIGO'},
            {name:'CTACT_NOMBRE'}
        ]),
        sortInfo:{field: 'CTACT_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_tct_actividad.
     */
    var pgBarCgg_tct_actividad= new Ext.PagingToolbar({
        store: gsCgg_tct_actividad,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_tct_actividad en un formato tabular de filas y columnas.
     */
    var grdCgg_tct_actividad = new Ext.grid.GridPanel({
        cm:cmCgg_tct_actividad,
        store:gsCgg_tct_actividad,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        viewConfig:{forceFit:true},
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_tct_actividad,
                width:200
            })
        ],
        bbar:pgBarCgg_tct_actividad,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_tct_actividad.hidden){
                    btnEditarCgg_tct_actividad.fireEvent('click', btnEditarCgg_tct_actividad);
                }
            }}});
    gsCgg_tct_actividad.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_tct_actividad.
     */
    if(inDesktop){
        var winFrmListadoCgg_tct_actividad =  inDesktop.createWindow({
            id:'winFrmListadoCgg_tct_actividad',
            title:tituloListadoCgg_tct_actividad,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_tct_actividad,descListadoCgg_tct_actividad),
            items:[grdCgg_tct_actividad],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_tct_actividad,btnEditarCgg_tct_actividad,btnEliminarCgg_tct_actividad,'->',btnSalirCgg_tct_actividad]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_tct_actividad.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_tct_actividad.
     * @returns ventana winFrmCgg_tct_actividad.
     * @base FrmListadoCgg_tct_actividad.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_tct_actividad;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_tct_actividad.
     * @base FrmListadoCgg_tct_actividad.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_tct_actividad.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_tct_actividad;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_tct_actividad;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_tct_actividad.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_tct_actividad.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_tct_actividad desde una instancia.
 */
FrmListadoCgg_tct_actividad.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_tct_actividad desde una instancia.
 */
FrmListadoCgg_tct_actividad.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_tct_actividad,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_tct_actividad.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_tct_actividad desde una instancia.
 */
FrmListadoCgg_tct_actividad.prototype.loadData = function(){
    this.loadData();
}
