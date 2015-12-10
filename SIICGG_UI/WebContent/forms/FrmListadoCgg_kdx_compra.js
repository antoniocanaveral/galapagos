/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_kdx_compra.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_kdx_compra(inDescktop){
    var optMenu = 'Kardex/Ingresos';
    var urlListadoCgg_kdx_compra=URL_WS+"Cgg_kdx_compra";
    var tituloListadoCgg_kdx_compra='Listado de Compras';
    var descListadoCgg_kdx_compra='El formulario permite administrar informaci\u00f3n de las compras de especies';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_kdx_compra.
     */
    var btnNuevoCgg_kdx_compra = new Ext.Button({
        id:'btnNuevoCgg_kdx_compra',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_kdx_compra = new FrmCgg_kdx_compra("insert");
                objCgg_kdx_compra.closeHandler(function(){
                    gsCgg_kdx_compra.reload();
                });
                objCgg_kdx_compra.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_kdx_compra.
     */
    var btnEditarCgg_kdx_compra = new Ext.Button({
        id:'btnEditarCgg_kdx_compra',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_kdx_compra.getSelectionModel().getSelected();
                if(r){
                    var objCgg_kdx_compra = new FrmCgg_kdx_compra("update",r);
                    objCgg_kdx_compra.closeHandler(function(){
                        gsCgg_kdx_compra.reload();
                    });
                    objCgg_kdx_compra.loadData();
                    objCgg_kdx_compra.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_kdx_compra.
     */
    var btnEliminarCgg_kdx_compra = new Ext.Button({
        id:'btnEliminarCgg_kdx_compra',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_kdx_compra,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_kdx_compra(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_kdx_compra(r){
                            winFrmListadoCgg_kdx_compra.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_compra,
                                    msg: 'La informaci\u00f3n de registro de compra ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_kdx_compra.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_compra,
                                    msg: 'La informaci\u00f3n de  registro de compra no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_kdx_compra.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCkcmp_codigo',grdCgg_kdx_compra.getSelectionModel().getSelected().get('CKCMP_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_kdx_compra,"delete",param, true, CallBackCgg_kdx_compra);
                    }catch(inErr){
                        winFrmListadoCgg_kdx_compra.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_kdx_compra.
     */
    var btnSalirCgg_kdx_compra = new Ext.Button({
        id:'btnSalirCgg_kdx_compra',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_kdx_compra.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_compra.
     */
    var cmCgg_kdx_compra = new Ext.grid.ColumnModel([
        {dataIndex:'CKCMP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
         {dataIndex:'CKCMP_FACTURA',header:'Factura',width:150,sortable:true},
         {dataIndex:'CKESP_NOMBRE',header:'Especie',width:150,sortable:true},
        {dataIndex:'CKCMP_LOTE',header:'Lote',width:150,sortable:true},
        {dataIndex:'CKCMP_FECHA_INGRESO',header:'Fecha ingreso',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CKCMP_SERIE',header:'Serie',width:150,sortable:true,hidden:true},
        {dataIndex:'CKCMP_PROCEDENCIA',header:'Procedencia',width:150,sortable:true},
        {dataIndex:'CKCMP_CANTIDAD',header:'Cantidad',width:150,sortable:true},
        {dataIndex:'CKCMP_TOTAL',header:'Total',width:150,sortable:true},
		{dataIndex:'CKCMP_USUARIO_INSERT',header:'Responsable',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_compra por un campo especifico.
     */
    var gsCgg_kdx_compra = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_compra",
            method:"selectPageWithEspecie",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKCMP_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CKCMP_CODIGO'},
            {name:'CKCMP_LOTE'},
            {name:'CKESP_NOMBRE'},
            {name:'CKCMP_FECHA_INGRESO'},
            {name:'CKCMP_SERIE'},
            {name:'CKCMP_PROCEDENCIA'},
            {name:'CKCMP_CANTIDAD'},
            {name:'CKCMP_FACTURA'},
            {name:'CKCMP_TOTAL'},
			{name:'CKCMP_USUARIO_INSERT'}
        ]),
        sortInfo:{field: 'CKCMP_LOTE', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'},
        groupField: 'CKCMP_FECHA_INGRESO'
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_kdx_compra.
     */
    var pgBarCgg_kdx_compra= new Ext.PagingToolbar({
        store: gsCgg_kdx_compra,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_compra en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_compra = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_compra,
        store:gsCgg_kdx_compra,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_kdx_compra,
                width:200
            })
        ],
        view: new Ext.grid.GroupingView({
           groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Ingresos" : "Ingreso"]})'
        }),
        bbar:pgBarCgg_kdx_compra,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_kdx_compra.hidden){
                    btnEditarCgg_kdx_compra.fireEvent('click', btnEditarCgg_kdx_compra);
                }
            }}});
    gsCgg_kdx_compra.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_kdx_compra.
     */
    if(inDescktop){
	var winFrmListadoCgg_kdx_compra = inDescktop.createWindow({
		id:'winFrmListadoCgg_kdx_compra',
		title:tituloListadoCgg_kdx_compra,
		width:600,
		minWidth:600,
		height:400,
		minHeight:400,
		maximizable:true,
		minimizable:true,
		constrain:true,
		layout:'border',
		tbar:getPanelTitulo(tituloListadoCgg_kdx_compra,descListadoCgg_kdx_compra),
		items:[grdCgg_kdx_compra],
		bbar:[btnNuevoCgg_kdx_compra,btnEditarCgg_kdx_compra,btnEliminarCgg_kdx_compra,'->',btnSalirCgg_kdx_compra]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_kdx_compra.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_kdx_compra.
     * @returns ventana winFrmCgg_kdx_compra.
     * @base FrmListadoCgg_kdx_compra.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_kdx_compra;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_kdx_compra.
     * @base FrmListadoCgg_kdx_compra.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_kdx_compra.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_kdx_compra;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_kdx_compra;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_kdx_compra.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_kdx_compra.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_kdx_compra desde una instancia.
 */
FrmListadoCgg_kdx_compra.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_kdx_compra desde una instancia.
 */
FrmListadoCgg_kdx_compra.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_kdx_compra,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_kdx_compra.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_kdx_compra desde una instancia.
 */
FrmListadoCgg_kdx_compra.prototype.loadData = function(){
    this.loadData();
}
