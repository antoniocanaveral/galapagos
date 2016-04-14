/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_beca_certificado.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_beca_certificado(inDescktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Beca/Configuraci\u00F3n/Beca Certificado';
    var urlListadoCgg_dhu_beca_certificado=URL_WS+"Cgg_dhu_beca_certificado";
    var tituloListadoCgg_dhu_beca_certificado='Beca certificado';
    var descListadoCgg_dhu_beca_certificado='El formulario permite administrar informaci\u00f3n sobre los diferentes certificados de beca';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_beca_certificado.
     */
    var btnNuevoCgg_dhu_beca_certificado = new Ext.Button({
        id:'btnNuevoCgg_dhu_beca_certificado',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_dhu_beca_certificado = new FrmCgg_dhu_beca_certificado("insert");
                objCgg_dhu_beca_certificado.closeHandler(function(){
                    gsCgg_dhu_beca_certificado.reload();
                });
                objCgg_dhu_beca_certificado.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_beca_certificado.
     */
    var btnEditarCgg_dhu_beca_certificado = new Ext.Button({
        id:'btnEditarCgg_dhu_beca_certificado',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_dhu_beca_certificado.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_beca_certificado = new FrmCgg_dhu_beca_certificado("update",r);
                    objCgg_dhu_beca_certificado.closeHandler(function(){
                        gsCgg_dhu_beca_certificado.reload();
                    });
                    objCgg_dhu_beca_certificado.loadData();
                    objCgg_dhu_beca_certificado.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_beca_certificado.
     */
    var btnEliminarCgg_dhu_beca_certificado = new Ext.Button({
        id:'btnEliminarCgg_dhu_beca_certificado',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_beca_certificado,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_beca_certificado(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_beca_certificado(r){
                            winFrmListadoCgg_dhu_beca_certificado.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_beca_certificado,
                                    msg: 'La informaci\u00f3n ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_beca_certificado.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_beca_certificado,
                                    msg: 'La informaci\u00f3n  no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_beca_certificado.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdbcr_codigo',grdCgg_dhu_beca_certificado.getSelectionModel().getSelected().get('CDBCR_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_beca_certificado,"delete",param, true, CallBackCgg_dhu_beca_certificado);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_beca_certificado.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_beca_certificado.
     */
    var btnSalirCgg_dhu_beca_certificado = new Ext.Button({
        id:'btnSalirCgg_dhu_beca_certificado',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_beca_certificado.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_beca_certificado.
     */
    var cmCgg_dhu_beca_certificado = new Ext.grid.ColumnModel([
        {dataIndex:'CDBCR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDTCA_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDTBC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDTCA_NOMBRE',header:'Certificado',width:150,sortable:true},
        {dataIndex:'CDTBC_NOMBRE',header:'Tipo beca',width:150,sortable:true},
        {dataIndex:'CDBCR_OBLIGATORIO',header:'Obligatorio',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_beca_certificado por un campo especifico.
     */
    var gsCgg_dhu_beca_certificado = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_beca_certificado",
            method:"selectCertificadoPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDBCR_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDBCR_CODIGO'},
            {name:'CDTCA_CODIGO'},
            {name:'CDTCA_NOMBRE'},
            {name:'CDTBC_CODIGO'},
            {name:'CDTBC_NOMBRE'},
            {name:'CDBCR_OBLIGATORIO'}
        ]),
        sortInfo:{field: 'CDTCA_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_beca_certificado.
     */
    var pgBarCgg_dhu_beca_certificado= new Ext.PagingToolbar({
        store: gsCgg_dhu_beca_certificado,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_beca_certificado en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_beca_certificado = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_beca_certificado,
        store:gsCgg_dhu_beca_certificado,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_beca_certificado,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_beca_certificado,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_beca_certificado.hidden){
                    btnEditarCgg_dhu_beca_certificado.fireEvent('click', btnEditarCgg_dhu_beca_certificado);
                }
            }}});
    gsCgg_dhu_beca_certificado.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_beca_certificado.
     */
    if(inDescktop){
    var winFrmListadoCgg_dhu_beca_certificado = inDescktop.createWindow({
        id:'winFrmListadoCgg_dhu_beca_certificado',
        title:tituloListadoCgg_dhu_beca_certificado,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_beca_certificado,descListadoCgg_dhu_beca_certificado),
        items:[grdCgg_dhu_beca_certificado],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_dhu_beca_certificado,btnEditarCgg_dhu_beca_certificado,btnEliminarCgg_dhu_beca_certificado,'->',btnSalirCgg_dhu_beca_certificado]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_dhu_beca_certificado.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_beca_certificado.
     * @returns ventana winFrmCgg_dhu_beca_certificado.
     * @base FrmListadoCgg_dhu_beca_certificado.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_beca_certificado;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_beca_certificado.
     * @base FrmListadoCgg_dhu_beca_certificado.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_beca_certificado.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_beca_certificado;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_beca_certificado;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_beca_certificado.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_beca_certificado.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_beca_certificado desde una instancia.
 */
FrmListadoCgg_dhu_beca_certificado.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_beca_certificado desde una instancia.
 */
FrmListadoCgg_dhu_beca_certificado.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_beca_certificado,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_beca_certificado.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_beca_certificado desde una instancia.
 */
FrmListadoCgg_dhu_beca_certificado.prototype.loadData = function(){
    this.loadData();
}
