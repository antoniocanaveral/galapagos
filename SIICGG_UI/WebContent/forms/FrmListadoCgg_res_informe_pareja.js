/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_informe_pareja.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_informe_pareja(){
    var urlListadoCgg_res_informe_pareja=URL_WS+"Cgg_res_informe_pareja";
    var tituloListadoCgg_res_informe_pareja='Informe Pareja';
    var descListadoCgg_res_informe_pareja='El formulario permite administrar informaci\u00f3n del Informe Pareja';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_informe_pareja.
     */
    var btnNuevoCgg_res_informe_pareja = new Ext.Button({
        id:'btnNuevoCgg_res_informe_pareja',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_informe_pareja = new FrmCgg_res_informe_pareja("insert");
                objCgg_res_informe_pareja.closeHandler(function(){
                    gsCgg_res_informe_pareja.reload();
                });
                objCgg_res_informe_pareja.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_informe_pareja.
     */
    var btnEditarCgg_res_informe_pareja = new Ext.Button({
        id:'btnEditarCgg_res_informe_pareja',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_informe_pareja.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_informe_pareja = new FrmCgg_res_informe_pareja("update",r);
                    objCgg_res_informe_pareja.loadMatrimonio(grdCgg_res_informe_pareja.getSelectionModel().getSelected().get('CRINF_CODIGO'));
                    objCgg_res_informe_pareja.closeHandler(function(){
                        gsCgg_res_informe_pareja.reload();
                    });
                    objCgg_res_informe_pareja.loadData();
                    objCgg_res_informe_pareja.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_informe_pareja.
     */
    var btnEliminarCgg_res_informe_pareja = new Ext.Button({
        id:'btnEliminarCgg_res_informe_pareja',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_informe_pareja,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_informe_pareja(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_informe_pareja(r){
                            winFrmListadoCgg_res_informe_pareja.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_informe_pareja,
                                    msg: 'La informaci\u00f3n del Informe Pareja ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_informe_pareja.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_informe_pareja,
                                    msg: 'La informaci\u00f3n del Informe Pareja no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_informe_pareja.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrinf_codigo',grdCgg_res_informe_pareja.getSelectionModel().getSelected().get('CRINF_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_informe_pareja,"delete",param, true, CallBackCgg_res_informe_pareja);
                    }catch(inErr){
                        winFrmListadoCgg_res_informe_pareja.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_informe_pareja.
     */
    var btnSalirCgg_res_informe_pareja = new Ext.Button({
        id:'btnSalirCgg_res_informe_pareja',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_informe_pareja.close();
            }}
    });
      /**
     * Ext.Button Boton que permite visualizar un archivo adjunto.
     */
    var btnVerCgg_res_informe_pareja = new Ext.Button({
        id:'btnVerCgg_res_informe_pareja',
        text:'Ver',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                 var r=grdCgg_res_informe_pareja.getSelectionModel().getSelected();
                if(r && r.get('ADJUNTO'))
                {
                    window.open(URL_DOC_VIEWER + '?table=Cgg_res_adjunto&keyc=cradj_codigo&keyv=' + r.get('CODIGO_ADJUNTO') + '&column=cradj_archivo_adjunto&fn=' + r.get('ADJUNTO') + '&request=view');
                }
            }}
    });

     /**
     * Ext.Button Boton que permite visualizar un archivo adjunto.
     */
    var btnDescargarCgg_res_informe_pareja = new Ext.Button({
        id:'btnDescargarCgg_res_informe_pareja',
        text:'Descargar',
        iconCls:'iconDescargar',
        listeners:{
            click:function(){
                var r=grdCgg_res_informe_pareja.getSelectionModel().getSelected();
                if(r && r.get('ADJUNTO'))
                {
                    window.open(URL_DOC_VIEWER + '?table=Cgg_res_adjunto&keyc=cradj_codigo&keyv=' + r.get('CODIGO_ADJUNTO') + '&column=cradj_archivo_adjunto&fn=' + r.get('ADJUNTO') + '&request=download');
                }
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_informe_pareja.
     */
    var cmCgg_res_informe_pareja = new Ext.grid.ColumnModel([
        {dataIndex:'CRINF_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true},
        {dataIndex:'CROFM_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true},
        {dataIndex:'CRINF_FECHA_ENTREGA',header:'Fecha entrega',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CRINF_EXTRACTO',header:'Extracto',width:150,sortable:true},
        {dataIndex:'CRINF_NUMERO_DOCUMENTO',header:'Numero Documento',width:150,sortable:true},
        {dataIndex:'CRINF_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true},
        {dataIndex:'CODIGO_ADJUNTO',header:'CODIGO',width:150,sortable:true, hidden :true},
        {dataIndex:'ADJUNTO',header:'Adjunto',width:150,sortable:true},
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_informe_pareja por un campo especifico.
     */
    var gsCgg_res_informe_pareja = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_informe_pareja",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRINF_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRINF_CODIGO'},
            {name:'CODIGO_ADJUNTO'},
            {name:'ADJUNTO'},
            {name:'CROFM_CODIGO'},
            {name:'CRINF_FECHA_ENTREGA'},
            {name:'CRINF_EXTRACTO'},
            {name:'CRINF_NUMERO_DOCUMENTO'},
            {name:'CRINF_OBSERVACION'}

        ]),
        sortInfo:{field: 'CROFM_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",inCrmtr_codigo:'',format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_informe_pareja.
     */
    var pgBarCgg_res_informe_pareja= new Ext.PagingToolbar({
        store: gsCgg_res_informe_pareja,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_informe_pareja en un formato tabular de filas y columnas.
     */
    var grdCgg_res_informe_pareja = new Ext.grid.GridPanel({
        cm:cmCgg_res_informe_pareja,
        store:gsCgg_res_informe_pareja,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        viewConfig:{forceFit:true},
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_informe_pareja,
                width:200
            })
        ],
        bbar:pgBarCgg_res_informe_pareja,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_informe_pareja.hidden){
                    btnEditarCgg_res_informe_pareja.fireEvent('click', btnEditarCgg_res_informe_pareja);
                }
            }}});
    gsCgg_res_informe_pareja.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_informe_pareja.
     */
    var winFrmListadoCgg_res_informe_pareja = new Ext.Window({
        id:'winFrmListadoCgg_res_informe_pareja',
        title:tituloListadoCgg_res_informe_pareja,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_informe_pareja,descListadoCgg_res_informe_pareja),
        items:[grdCgg_res_informe_pareja],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:false,
        constrain:true,
        layout:'border',
		modal:true,
        bbar:[btnEditarCgg_res_informe_pareja,btnEliminarCgg_res_informe_pareja,'-',btnVerCgg_res_informe_pareja,btnDescargarCgg_res_informe_pareja,'->',btnSalirCgg_res_informe_pareja]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_informe_pareja.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_informe_pareja.
     * @returns ventana winFrmCgg_res_informe_pareja.
     * @base FrmListadoCgg_res_informe_pareja.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_informe_pareja;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_informe_pareja.
     * @base FrmListadoCgg_res_informe_pareja.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_informe_pareja.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_informe_pareja;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_informe_pareja;
    }
    /*/**
     * Funcion que permite cargar la codigo de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    function cargarCgg_res_matrimonioCtrls(inCodigo){
        gsCgg_res_informe_pareja.reload({params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON",
            inCrmtr_codigo:inCodigo
        }
        });
    }
    /**
     * Funcion que permite cargar la codgi de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    this.loadMatrimonio = function(inCodigo){
        cargarCgg_res_matrimonioCtrls(inCodigo);
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_informe_pareja.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_informe_pareja.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_informe_pareja desde una instancia.
 */
FrmListadoCgg_res_informe_pareja.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_informe_pareja desde una instancia.
 */
FrmListadoCgg_res_informe_pareja.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_informe_pareja,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_informe_pareja.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_informe_pareja desde una instancia.
 */
FrmListadoCgg_res_informe_pareja.prototype.loadData = function(){
    this.loadData();
}
