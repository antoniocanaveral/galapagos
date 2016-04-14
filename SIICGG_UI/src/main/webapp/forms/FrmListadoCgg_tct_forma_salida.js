/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_tct_forma_salida.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_tct_forma_salida(inDesktop){
    var optMenu = 'Movilidad/Forma Salida';
    var urlListadoCgg_tct_forma_salida=URL_WS+"Cgg_tct_forma_salida";
    var tituloListadoCgg_tct_forma_salida='Salida';
    var descListadoCgg_tct_forma_salida='El formulario permite administrar informaci\u00f3n de Salida';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_tct_forma_salida.
     */
    var btnNuevoCgg_tct_forma_salida = new Ext.Button({
        id:'btnNuevoCgg_tct_forma_salida',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_tct_forma_salida = new FrmCgg_tct_forma_salida("insert");
                objCgg_tct_forma_salida.closeHandler(function(){
                    gsCgg_tct_forma_salida.reload();
                });
                objCgg_tct_forma_salida.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_tct_forma_salida.
     */
    var btnEditarCgg_tct_forma_salida = new Ext.Button({
        id:'btnEditarCgg_tct_forma_salida',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_tct_forma_salida.getSelectionModel().getSelected();
                if(r){
                    var objCgg_tct_forma_salida = new FrmCgg_tct_forma_salida("update",r);
                    objCgg_tct_forma_salida.closeHandler(function(){
                        gsCgg_tct_forma_salida.reload();
                    });
                    objCgg_tct_forma_salida.loadData();
                    objCgg_tct_forma_salida.show();
                }else{
                    Ext.MessageBox.alert('Salida', 'Seleccione un registro para continuar');

                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_tct_forma_salida.
     */
    var btnEliminarCgg_tct_forma_salida = new Ext.Button({
        id:'btnEliminarCgg_tct_forma_salida',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_tct_forma_salida,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_tct_forma_salida(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_tct_forma_salida(r){
                            winFrmListadoCgg_tct_forma_salida.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_tct_forma_salida,
                                    msg: 'La informaci\u00f3n de la Salida ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_tct_forma_salida.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_tct_forma_salida,
                                    msg: 'La informaci\u00f3n de la Salida no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_tct_forma_salida.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCtfsl_codigo',grdCgg_tct_forma_salida.getSelectionModel().getSelected().get('CTFSL_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_tct_forma_salida,"delete",param, true, CallBackCgg_tct_forma_salida);
                    }catch(inErr){
                        winFrmListadoCgg_tct_forma_salida.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_tct_forma_salida.
     */
    var btnSalirCgg_tct_forma_salida = new Ext.Button({
        id:'btnSalirCgg_tct_forma_salida',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_tct_forma_salida.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_tct_forma_salida.
     */
    var cmCgg_tct_forma_salida = new Ext.grid.ColumnModel([
        {dataIndex:'CTFSL_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true},
        {dataIndex:'CTFSL_NOMBRE',header:'Nombre',width:550,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_tct_forma_salida por un campo especifico.
     */
    var gsCgg_tct_forma_salida = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_tct_forma_salida",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CTFSL_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CTFSL_CODIGO'},
            {name:'CTFSL_NOMBRE'}
        ]),
        sortInfo:{field: 'CTFSL_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_tct_forma_salida.
     */
    var pgBarCgg_tct_forma_salida= new Ext.PagingToolbar({
        store: gsCgg_tct_forma_salida,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_tct_forma_salida en un formato tabular de filas y columnas.
     */
    var grdCgg_tct_forma_salida = new Ext.grid.GridPanel({
        cm:cmCgg_tct_forma_salida,
        store:gsCgg_tct_forma_salida,
        viewConfig:{forceFit:true},
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_tct_forma_salida,
                width:200
            })
        ],
        bbar:pgBarCgg_tct_forma_salida,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_tct_forma_salida.hidden){
                    btnEditarCgg_tct_forma_salida.fireEvent('click', btnEditarCgg_tct_forma_salida);
                }
            }}});
    gsCgg_tct_forma_salida.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_tct_forma_salida.
     */
    if(inDesktop){
        var winFrmListadoCgg_tct_forma_salida = inDesktop.createWindow({
            id:'winFrmListadoCgg_tct_forma_salida',
            title:tituloListadoCgg_tct_forma_salida,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_tct_forma_salida,descListadoCgg_tct_forma_salida),
            items:[grdCgg_tct_forma_salida],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_tct_forma_salida,btnEditarCgg_tct_forma_salida,btnEliminarCgg_tct_forma_salida,'->',btnSalirCgg_tct_forma_salida]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_tct_forma_salida.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_tct_forma_salida.
     * @returns ventana winFrmCgg_tct_forma_salida.
     * @base FrmListadoCgg_tct_forma_salida.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_tct_forma_salida;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_tct_forma_salida.
     * @base FrmListadoCgg_tct_forma_salida.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_tct_forma_salida.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_tct_forma_salida;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_tct_forma_salida;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_tct_forma_salida.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_tct_forma_salida.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_tct_forma_salida desde una instancia.
 */
FrmListadoCgg_tct_forma_salida.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_tct_forma_salida desde una instancia.
 */
FrmListadoCgg_tct_forma_salida.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_tct_forma_salida,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_tct_forma_salida.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_tct_forma_salida desde una instancia.
 */
FrmListadoCgg_tct_forma_salida.prototype.loadData = function(){
    this.loadData();
}
