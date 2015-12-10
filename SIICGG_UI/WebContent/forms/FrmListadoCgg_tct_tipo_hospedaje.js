/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_tct_tipo_hospedaje.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_tct_tipo_hospedaje(inDesktop){
    var optMenu = 'TCT/Tipo hospedaje';
    var urlListadoCgg_tct_tipo_hospedaje=URL_WS+"Cgg_tct_tipo_hospedaje";
    var tituloListadoCgg_tct_tipo_hospedaje='Tipo Hospedaje';
    var descListadoCgg_tct_tipo_hospedaje='El formulario permite administrar informaci\u00f3n del Tipo Hospedaje';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_tct_tipo_hospedaje.
     */
    var btnNuevoCgg_tct_tipo_hospedaje = new Ext.Button({
        id:'btnNuevoCgg_tct_tipo_hospedaje',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_tct_tipo_hospedaje = new FrmCgg_tct_tipo_hospedaje("insert");
                objCgg_tct_tipo_hospedaje.closeHandler(function(){
                    gsCgg_tct_tipo_hospedaje.reload();
                });
                objCgg_tct_tipo_hospedaje.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_tct_tipo_hospedaje.
     */
    var btnEditarCgg_tct_tipo_hospedaje = new Ext.Button({
        id:'btnEditarCgg_tct_tipo_hospedaje',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_tct_tipo_hospedaje.getSelectionModel().getSelected();
                if(r){
                    var objCgg_tct_tipo_hospedaje = new FrmCgg_tct_tipo_hospedaje("update",r);
                    objCgg_tct_tipo_hospedaje.closeHandler(function(){
                        gsCgg_tct_tipo_hospedaje.reload();
                    });
                    objCgg_tct_tipo_hospedaje.loadData();
                    objCgg_tct_tipo_hospedaje.show();
                }else{
                    Ext.MessageBox.alert('Tipo Hospedaje', 'Seleccione un registro para continuar');
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_tct_tipo_hospedaje.
     */
    var btnEliminarCgg_tct_tipo_hospedaje = new Ext.Button({
        id:'btnEliminarCgg_tct_tipo_hospedaje',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_tct_tipo_hospedaje,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_tct_tipo_hospedaje(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_tct_tipo_hospedaje(r){
                            winFrmListadoCgg_tct_tipo_hospedaje.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_tct_tipo_hospedaje,
                                    msg: 'La informaci\u00f3n del Tipo Hospedaje ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_tct_tipo_hospedaje.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_tct_tipo_hospedaje,
                                    msg: 'La informaci\u00f3n del Tipo Hospedaje no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_tct_tipo_hospedaje.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCtthj_codigo',grdCgg_tct_tipo_hospedaje.getSelectionModel().getSelected().get('CTTHJ_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_tct_tipo_hospedaje,"delete",param, true, CallBackCgg_tct_tipo_hospedaje);
                    }catch(inErr){
                        winFrmListadoCgg_tct_tipo_hospedaje.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_tct_tipo_hospedaje.
     */
    var btnSalirCgg_tct_tipo_hospedaje = new Ext.Button({
        id:'btnSalirCgg_tct_tipo_hospedaje',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_tct_tipo_hospedaje.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_tct_tipo_hospedaje.
     */
    var cmCgg_tct_tipo_hospedaje = new Ext.grid.ColumnModel([
        {dataIndex:'CTTHJ_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CTTHJ_NOMBRE',header:'Nombre',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_tct_tipo_hospedaje por un campo especifico.
     */
    var gsCgg_tct_tipo_hospedaje = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_tct_tipo_hospedaje",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CTTHJ_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CTTHJ_CODIGO'},
            {name:'CTTHJ_NOMBRE'}
        ]),
        sortInfo:{field: 'CTTHJ_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_tct_tipo_hospedaje.
     */
    var pgBarCgg_tct_tipo_hospedaje= new Ext.PagingToolbar({
        store: gsCgg_tct_tipo_hospedaje,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_tct_tipo_hospedaje en un formato tabular de filas y columnas.
     */
    var grdCgg_tct_tipo_hospedaje = new Ext.grid.GridPanel({
        cm:cmCgg_tct_tipo_hospedaje,
        store:gsCgg_tct_tipo_hospedaje,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        viewConfig:{forceFit:true},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_tct_tipo_hospedaje,
                width:200
            })
        ],
        bbar:pgBarCgg_tct_tipo_hospedaje,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_tct_tipo_hospedaje.hidden){
                    btnEditarCgg_tct_tipo_hospedaje.fireEvent('click', btnEditarCgg_tct_tipo_hospedaje);
                }
            }}});
    gsCgg_tct_tipo_hospedaje.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_tct_tipo_hospedaje.
     */
    if(inDesktop){
        var winFrmListadoCgg_tct_tipo_hospedaje =  inDesktop.createWindow({
            id:'winFrmListadoCgg_tct_tipo_hospedaje',
            title:tituloListadoCgg_tct_tipo_hospedaje,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_tct_tipo_hospedaje,descListadoCgg_tct_tipo_hospedaje),
            items:[grdCgg_tct_tipo_hospedaje],
            bbar:[btnNuevoCgg_tct_tipo_hospedaje,btnEditarCgg_tct_tipo_hospedaje,btnEliminarCgg_tct_tipo_hospedaje,'->',btnSalirCgg_tct_tipo_hospedaje]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_tct_tipo_hospedaje.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_tct_tipo_hospedaje.
     * @returns ventana winFrmCgg_tct_tipo_hospedaje.
     * @base FrmListadoCgg_tct_tipo_hospedaje.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_tct_tipo_hospedaje;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_tct_tipo_hospedaje.
     * @base FrmListadoCgg_tct_tipo_hospedaje.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_tct_tipo_hospedaje.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_tct_tipo_hospedaje;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_tct_tipo_hospedaje;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_tct_tipo_hospedaje.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_tct_tipo_hospedaje.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_tct_tipo_hospedaje desde una instancia.
 */
FrmListadoCgg_tct_tipo_hospedaje.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_tct_tipo_hospedaje desde una instancia.
 */
FrmListadoCgg_tct_tipo_hospedaje.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_tct_tipo_hospedaje,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_tct_tipo_hospedaje.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_tct_tipo_hospedaje desde una instancia.
 */
FrmListadoCgg_tct_tipo_hospedaje.prototype.loadData = function(){
    this.loadData();
}
