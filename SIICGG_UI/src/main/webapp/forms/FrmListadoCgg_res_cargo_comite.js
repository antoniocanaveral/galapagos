/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_cargo_comite.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_cargo_comite(inDesktop){
    var optMenu = 'Comite/Cargos de Comite';
    var urlListadoCgg_res_cargo_comite=URL_WS+"Cgg_res_cargo_comite";
    var tituloListadoCgg_res_cargo_comite='Cargo Comit\u00e9';
    var descListadoCgg_res_cargo_comite='El formulario permite administrar informaci\u00f3n del Cargo Comit\u00e9';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_cargo_comite.
     */
    var btnNuevoCgg_res_cargo_comite = new Ext.Button({
        id:'btnNuevoCgg_res_cargo_comite',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_cargo_comite = new FrmCgg_res_cargo_comite("insert");
                objCgg_res_cargo_comite.closeHandler(function(){
                    gsCgg_res_cargo_comite.reload();
                });
                objCgg_res_cargo_comite.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_cargo_comite.
     */
    var btnEditarCgg_res_cargo_comite = new Ext.Button({
        id:'btnEditarCgg_res_cargo_comite',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_cargo_comite.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_cargo_comite = new FrmCgg_res_cargo_comite("update",r);
                    objCgg_res_cargo_comite.closeHandler(function(){
                        gsCgg_res_cargo_comite.reload();
                    });
                    objCgg_res_cargo_comite.loadData();
                    objCgg_res_cargo_comite.show();
                }else{
                    Ext.MessageBox.alert('Cargo Comit\u00e9', 'Seleccione un registro para continuar');
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_cargo_comite.
     */
    var btnEliminarCgg_res_cargo_comite = new Ext.Button({
        id:'btnEliminarCgg_res_cargo_comite',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                var r=grdCgg_res_cargo_comite.getSelectionModel().getSelected();
                if(r){
                    Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_cargo_comite,icon: Ext.MessageBox.QUESTION});
                    function SWRCgg_res_cargo_comite(btn){if (btn=='yes'){
                        try{
                            function CallBackCgg_res_cargo_comite(r){
                                winFrmListadoCgg_res_cargo_comite.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_res_cargo_comite,
                                        msg: 'La informaci\u00f3n del Cargo Comit\u00e9 ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_res_cargo_comite.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_res_cargo_comite,
                                        msg: 'La informaci\u00f3n del Cargo Comit\u00e9 no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }}
                            winFrmListadoCgg_res_cargo_comite.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCrcrg_codigo',grdCgg_res_cargo_comite.getSelectionModel().getSelected().get('CRCRG_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_res_cargo_comite,"delete",param, true, CallBackCgg_res_cargo_comite);
                        }catch(inErr){
                            winFrmListadoCgg_res_cargo_comite.getEl().unmask();
                        }}}
                }else{
                    Ext.MessageBox.alert('Cargo Comit\u00e9', 'Seleccione un registro para continuar');
                }

            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_cargo_comite.
     */
    var btnSalirCgg_res_cargo_comite = new Ext.Button({
        id:'btnSalirCgg_res_cargo_comite',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_cargo_comite.close();
            }}
    });
    var checkColumn = new Ext.grid.CheckColumn({
        header: 'Voto dirimente',
        dataIndex:'CRCRG_VOTO_DIRIMENTE',
        width: 80,
        sortable:true
    });
	var chkCrcrg_principal = new Ext.grid.CheckColumn(
		{dataIndex:'CRCRG_PRINCIPAL',header:'Principal',width:80,sortable:true});
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_cargo_comite.
     */
    var cmCgg_res_cargo_comite = new Ext.grid.ColumnModel([
        {dataIndex:'CRCRG_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true},
        {dataIndex:'CRCOM_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'COMITE',header:'Comit\u00e9',width:250,sortable:true,hidden:true},
        {dataIndex:'CRCRG_NOMBRE',header:'Nombre',width:250,sortable:true},
		chkCrcrg_principal,
        checkColumn]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_cargo_comite por un campo especifico.
     */
    var gsCgg_res_cargo_comite = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_cargo_comite",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRCRG_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRCRG_CODIGO'},
            {name:'CRCOM_CODIGO'},
            {name:'COMITE'},
            {name:'CRCRG_NOMBRE'},
			{name:'CRCRG_PRINCIPAL'},
            {name:'CRCRG_VOTO_DIRIMENTE'}
        ]),
        //sortInfo:{field: 'CRCRG_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"},
        groupField:'COMITE',
        sortInfo: {
            field: 'COMITE',
            direction: 'ASC'
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_cargo_comite.
     */
    var pgBarCgg_res_cargo_comite= new Ext.PagingToolbar({
        store: gsCgg_res_cargo_comite,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_cargo_comite en un formato tabular de filas y columnas.
     */
    var grdCgg_res_cargo_comite = new Ext.grid.GridPanel({
        cm:cmCgg_res_cargo_comite,
        store:gsCgg_res_cargo_comite,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        view: new Ext.grid.GroupingView({
            forceFit:true,
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_cargo_comite,
                width:200
            })
        ],
        bbar:pgBarCgg_res_cargo_comite,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_cargo_comite.hidden){
                    btnEditarCgg_res_cargo_comite.fireEvent('click', btnEditarCgg_res_cargo_comite);
                }
            }
        }
    });
    gsCgg_res_cargo_comite.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_cargo_comite.
     */
    if(inDesktop){
        var winFrmListadoCgg_res_cargo_comite = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_cargo_comite',
            title:tituloListadoCgg_res_cargo_comite,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_cargo_comite,descListadoCgg_res_cargo_comite),
            items:[grdCgg_res_cargo_comite],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_cargo_comite,btnEditarCgg_res_cargo_comite,btnEliminarCgg_res_cargo_comite,'->',btnSalirCgg_res_cargo_comite]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_res_cargo_comite.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_cargo_comite.
     * @returns ventana winFrmCgg_res_cargo_comite.
     * @base FrmListadoCgg_res_cargo_comite.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_cargo_comite;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_cargo_comite.
     * @base FrmListadoCgg_res_cargo_comite.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_cargo_comite.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_cargo_comite;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_cargo_comite;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_cargo_comite.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_cargo_comite.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_cargo_comite desde una instancia.
 */
FrmListadoCgg_res_cargo_comite.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_cargo_comite desde una instancia.
 */
FrmListadoCgg_res_cargo_comite.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_cargo_comite,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_cargo_comite.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_cargo_comite desde una instancia.
 */
FrmListadoCgg_res_cargo_comite.prototype.loadData = function(){
    this.loadData();
}
