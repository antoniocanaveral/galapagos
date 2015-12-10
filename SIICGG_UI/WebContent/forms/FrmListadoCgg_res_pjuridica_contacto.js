/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_pjuridica_contacto.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_pjuridica_contacto(){
    var urlListadoCgg_res_pjuridica_contacto=URL_WS+"Cgg_res_pjuridica_contacto";
    var tituloListadoCgg_res_pjuridica_contacto='Res pjuridica contacto';
    var descListadoCgg_res_pjuridica_contacto='El formulario permite administrar informaci\u00f3n de la tabla Res pjuridica contacto';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_pjuridica_contacto.
     */
    var btnNuevoCgg_res_pjuridica_contacto = new Ext.Button({
        id:'btnNuevoCgg_res_pjuridica_contacto',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_pjuridica_contacto = new FrmCgg_res_pjuridica_contacto("insert");
                objCgg_res_pjuridica_contacto.closeHandler(function(){
                    gsCgg_res_pjuridica_contacto.reload();
                });
                objCgg_res_pjuridica_contacto.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_pjuridica_contacto.
     */
    var btnEditarCgg_res_pjuridica_contacto = new Ext.Button({
        id:'btnEditarCgg_res_pjuridica_contacto',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_pjuridica_contacto.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_pjuridica_contacto = new FrmCgg_res_pjuridica_contacto("update",r);
                    objCgg_res_pjuridica_contacto.closeHandler(function(){
                        gsCgg_res_pjuridica_contacto.reload();
                    });
                    objCgg_res_pjuridica_contacto.loadData();
                    objCgg_res_pjuridica_contacto.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_pjuridica_contacto.
     */
    var btnEliminarCgg_res_pjuridica_contacto = new Ext.Button({
        id:'btnEliminarCgg_res_pjuridica_contacto',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_pjuridica_contacto,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_pjuridica_contacto(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_pjuridica_contacto(r){
                            winFrmListadoCgg_res_pjuridica_contacto.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_pjuridica_contacto,
                                    msg: 'La informaci\u00f3n de Res pjuridica contacto ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_pjuridica_contacto.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_pjuridica_contacto,
                                    msg: 'La informaci\u00f3n de Res pjuridica contacto no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_pjuridica_contacto.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrpjc_codigo',grdCgg_res_pjuridica_contacto.getSelectionModel().getSelected().get('CRPJC_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_pjuridica_contacto,"delete",param, true, CallBackCgg_res_pjuridica_contacto);
                    }catch(inErr){
                        winFrmListadoCgg_res_pjuridica_contacto.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_pjuridica_contacto.
     */
    var btnSalirCgg_res_pjuridica_contacto = new Ext.Button({
        id:'btnSalirCgg_res_pjuridica_contacto',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_pjuridica_contacto.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_pjuridica_contacto.
     */
    var chkCrpjc_principal = new Ext.grid.CheckColumn(
    {dataIndex:'CRPJC_PRINCIPAL',header:'Principal',width:150,sortable:true});
    var cmCgg_res_pjuridica_contacto = new Ext.grid.ColumnModel([
        {dataIndex:'CRPJC_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRPJR_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRTCO_CODIGO',header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRPJC_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
        {dataIndex:'CRPJC_CONTACTO',header:'Contacto',width:150,sortable:true},
        chkCrpjc_principal]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_pjuridica_contacto por un campo especifico.
     */
    var gsCgg_res_pjuridica_contacto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_pjuridica_contacto",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPJC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRPJC_CODIGO'},
            {name:'CRPJR_CODIGO'},
            {name:'CRTCO_CODIGO'},
            {name:'CRPJC_DESCRIPCION'},
            {name:'CRPJC_CONTACTO'},
            {name:'CRPJC_PRINCIPAL'}
        ]),
        sortInfo:{field: 'CRPJR_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_pjuridica_contacto.
     */
    var pgBarCgg_res_pjuridica_contacto= new Ext.PagingToolbar({
        store: gsCgg_res_pjuridica_contacto,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_pjuridica_contacto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_pjuridica_contacto = new Ext.grid.GridPanel({
        cm:cmCgg_res_pjuridica_contacto,
        store:gsCgg_res_pjuridica_contacto,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_pjuridica_contacto,
                width:200
            })
        ],
        bbar:pgBarCgg_res_pjuridica_contacto,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_pjuridica_contacto.hidden){
                    btnEditarCgg_res_pjuridica_contacto.fireEvent('click', btnEditarCgg_res_pjuridica_contacto);
                }
            }}});
    gsCgg_res_pjuridica_contacto.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_pjuridica_contacto.
     */
    var winFrmListadoCgg_res_pjuridica_contacto = new Ext.Window({
        id:'winFrmListadoCgg_res_pjuridica_contacto',
        title:tituloListadoCgg_res_pjuridica_contacto,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_pjuridica_contacto,descListadoCgg_res_pjuridica_contacto),
        items:[grdCgg_res_pjuridica_contacto],
        bbar:[btnNuevoCgg_res_pjuridica_contacto,btnEditarCgg_res_pjuridica_contacto,btnEliminarCgg_res_pjuridica_contacto,'->',btnSalirCgg_res_pjuridica_contacto]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_pjuridica_contacto.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_pjuridica_contacto.
     * @returns ventana winFrmCgg_res_pjuridica_contacto.
     * @base FrmListadoCgg_res_pjuridica_contacto.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_pjuridica_contacto;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_pjuridica_contacto.
     * @base FrmListadoCgg_res_pjuridica_contacto.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_pjuridica_contacto.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_pjuridica_contacto;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_pjuridica_contacto;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_pjuridica_contacto.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_pjuridica_contacto.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_pjuridica_contacto desde una instancia.
 */
FrmListadoCgg_res_pjuridica_contacto.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_pjuridica_contacto desde una instancia.
 */
FrmListadoCgg_res_pjuridica_contacto.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_pjuridica_contacto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_pjuridica_contacto.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_pjuridica_contacto desde una instancia.
 */
FrmListadoCgg_res_pjuridica_contacto.prototype.loadData = function(){
    this.loadData();
}
