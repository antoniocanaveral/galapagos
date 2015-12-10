
function FrmListadoCgg_dhu_adjunto(inDescktop){
	var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Beca/Configuraci\u00F3n/Adjunto Beca';
    var urlListadoCgg_dhu_adjunto=URL_WS+"Cgg_dhu_adjunto";
    var tituloListadoCgg_dhu_adjunto='Adjuntos';
    var descListadoCgg_dhu_adjunto='El formulario permite administrar informaci\u00f3n sobre los diferentes adjuntos de una beca';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_adjunto.
     */
    var btnNuevoCgg_dhu_adjunto = new Ext.Button({
        id:'btnNuevoCgg_dhu_adjunto',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_dhu_adjunto = new FrmCgg_dhu_adjunto("insert");
                objCgg_dhu_adjunto.closeHandler(function(){
                    gsCgg_dhu_adjunto.reload();
                });
                objCgg_dhu_adjunto.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_adjunto.
     */
    var btnEditarCgg_dhu_adjunto = new Ext.Button({
        id:'btnEditarCgg_dhu_adjunto',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_dhu_adjunto.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_adjunto = new FrmCgg_dhu_adjunto("update",r);
                    objCgg_dhu_adjunto.closeHandler(function(){
                        gsCgg_dhu_adjunto.reload();
                    });
                    objCgg_dhu_adjunto.loadData();
                    objCgg_dhu_adjunto.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_adjunto.
     */
    var btnEliminarCgg_dhu_adjunto = new Ext.Button({
        id:'btnEliminarCgg_dhu_adjunto',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_adjunto,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_adjunto(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_adjunto(r){
                            winFrmListadoCgg_dhu_adjunto.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_adjunto,
                                    msg: 'La informaci\u00f3n ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_adjunto.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_adjunto,
                                    msg: 'La informaci\u00f3n  no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_adjunto.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdad_codigo',grdCgg_dhu_adjunto.getSelectionModel().getSelected().get('CDAD_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_adjunto,"delete",param, true, CallBackCgg_dhu_adjunto);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_adjunto.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_adjunto.
     */
    var btnSalirCgg_dhu_adjunto = new Ext.Button({
        id:'btnSalirCgg_dhu_adjunto',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_adjunto.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_adjunto.
     */
    var cmCgg_dhu_adjunto = new Ext.grid.ColumnModel([
        {dataIndex:'CDAD_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDBEC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDAD_DESCRIPCION',header:'Descripci\u00f3n',width:150,sortable:true},
        {dataIndex:'CDAD_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true},
        {dataIndex:'CDAD_NOMBRE_ADJUNTO',header:'Nombre adjunto',width:150,sortable:true},
        {dataIndex:'CDAD_ADJUNTO',header:'Adjunto',width:150,sortable:true},
        {dataIndex:'CDAD_TIPO',header:'Tipo',width:150,sortable:true,renderer:function(inCdad_tipo){
         if(inCdad_tipo==TypeAdjuntoBeca.CONTRATO_BECA){
             return('CONTRATO DE BECA');
         }
         if(inCdad_tipo==TypeAdjuntoBeca.INFORME){
             return('INFORME');
         }
         if(inCdad_tipo==TypeAdjuntoBeca.MEMORANDUM_APROBACIONES){
             return('MEMORANDUM DE APROBACIONES');
         }
         if(inCdad_tipo==TypeAdjuntoBeca.OTROS){
             return('Otros');
         }

        }},
        {dataIndex:'CDAD_DESCRIPCION_CONTENIDO',header:'Descripcion contenido',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_adjunto por un campo especifico.
     */
    var gsCgg_dhu_adjunto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_adjunto",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDAD_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDAD_CODIGO'},
            {name:'CDBEC_CODIGO'},
            {name:'CDAD_DESCRIPCION'},
            {name:'CDAD_OBSERVACION'},
            {name:'CDAD_NOMBRE_ADJUNTO'},
            {name:'CDAD_ADJUNTO'},
            {name:'CDAD_TIPO'},
            {name:'CDAD_DESCRIPCION_CONTENIDO'}
        ]),
        sortInfo:{field: 'CDBEC_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_adjunto.
     */
    var pgBarCgg_dhu_adjunto= new Ext.PagingToolbar({
        store: gsCgg_dhu_adjunto,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_adjunto en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_adjunto = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_adjunto,
        store:gsCgg_dhu_adjunto,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_adjunto,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_adjunto,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_adjunto.hidden){
                    btnEditarCgg_dhu_adjunto.fireEvent('click', btnEditarCgg_dhu_adjunto);
                }
            }}});
    gsCgg_dhu_adjunto.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_adjunto.
     */
    if(inDescktop){
    var winFrmListadoCgg_dhu_adjunto = inDescktop.createWindow({
        id:'winFrmListadoCgg_dhu_adjunto',
        title:tituloListadoCgg_dhu_adjunto,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_adjunto,descListadoCgg_dhu_adjunto),
        items:[grdCgg_dhu_adjunto],
        bbar:[btnNuevoCgg_dhu_adjunto,btnEditarCgg_dhu_adjunto,btnEliminarCgg_dhu_adjunto,'->',btnSalirCgg_dhu_adjunto]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_dhu_adjunto.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_adjunto.
     * @returns ventana winFrmCgg_dhu_adjunto.
     * @base FrmListadoCgg_dhu_adjunto.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_adjunto;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_adjunto.
     * @base FrmListadoCgg_dhu_adjunto.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_adjunto.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_adjunto;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_adjunto;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_adjunto.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_adjunto.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_adjunto desde una instancia.
 */
FrmListadoCgg_dhu_adjunto.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_adjunto desde una instancia.
 */
FrmListadoCgg_dhu_adjunto.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_adjunto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_adjunto.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_adjunto desde una instancia.
 */
FrmListadoCgg_dhu_adjunto.prototype.loadData = function(){
    this.loadData();
}
