/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_tipo_curso.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_tipo_curso(inDescktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Curso/Configuraci\u00F3n/Tipo de curso';
    var urlListadoCgg_dhu_tipo_curso=URL_WS+"Cgg_dhu_tipo_curso";
    var tituloListadoCgg_dhu_tipo_curso=' Tipo curso';
    var descListadoCgg_dhu_tipo_curso='El formulario permite administrar informaci\u00f3n de los tipos de cursos';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_tipo_curso.
     */
    var btnNuevoCgg_dhu_tipo_curso = new Ext.Button({
        id:'btnNuevoCgg_dhu_tipo_curso',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_dhu_tipo_curso = new FrmCgg_dhu_tipo_curso("insert");
                objCgg_dhu_tipo_curso.closeHandler(function(){
                    gsCgg_dhu_tipo_curso.reload();
                });
                objCgg_dhu_tipo_curso.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_tipo_curso.
     */
    var btnEditarCgg_dhu_tipo_curso = new Ext.Button({
        id:'btnEditarCgg_dhu_tipo_curso',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_dhu_tipo_curso.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_tipo_curso = new FrmCgg_dhu_tipo_curso("update",r);
                    objCgg_dhu_tipo_curso.closeHandler(function(){
                        gsCgg_dhu_tipo_curso.reload();
                    });
                    objCgg_dhu_tipo_curso.loadData();
                    objCgg_dhu_tipo_curso.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_tipo_curso.
     */
    var btnEliminarCgg_dhu_tipo_curso = new Ext.Button({
        id:'btnEliminarCgg_dhu_tipo_curso',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_tipo_curso,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_tipo_curso(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_tipo_curso(r){
                            winFrmListadoCgg_dhu_tipo_curso.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_tipo_curso,
                                    msg: 'El registro seleccionado se ha eliminado correctamente.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_tipo_curso.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_tipo_curso,
                                    msg: 'El registro seleccionado no ha podido ser eliminado.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_tipo_curso.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdtcr_codigo',grdCgg_dhu_tipo_curso.getSelectionModel().getSelected().get('CDTCR_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_tipo_curso,"delete",param, true, CallBackCgg_dhu_tipo_curso);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_tipo_curso.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_tipo_curso.
     */
    var btnSalirCgg_dhu_tipo_curso = new Ext.Button({
        id:'btnSalirCgg_dhu_tipo_curso',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_tipo_curso.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_tipo_curso.
     */
    var cmCgg_dhu_tipo_curso = new Ext.grid.ColumnModel([
        {dataIndex:'CDTCR_CODIGO',header:'Codigo',width:200,sortable:true,hidden:true},
        {dataIndex:'CDTCR_NOMBRE',header:'Curso',width:200,sortable:true},
         {dataIndex:'CDTCR_TIPO_RESIDENTE',header:'Curso',width:200,sortable:true,hidden:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_tipo_curso por un campo especifico.
     */
    var gsCgg_dhu_tipo_curso = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_tipo_curso",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDTCR_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDTCR_CODIGO'},
            {name:'CDTCR_NOMBRE'},
            {name:'CDTCR_TIPO_RESIDENTE'}
        ]),
        sortInfo:{field: 'CDTCR_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_tipo_curso.
     */
    var pgBarCgg_dhu_tipo_curso= new Ext.PagingToolbar({
        store: gsCgg_dhu_tipo_curso,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_tipo_curso en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_tipo_curso = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_tipo_curso,
        store:gsCgg_dhu_tipo_curso,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
		viewConfig:{forceFit:true},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_tipo_curso,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_tipo_curso,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_tipo_curso.hidden){
                    btnEditarCgg_dhu_tipo_curso.fireEvent('click', btnEditarCgg_dhu_tipo_curso);
                }
            }}});
    gsCgg_dhu_tipo_curso.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_tipo_curso.
     */
    if(inDescktop){
    var winFrmListadoCgg_dhu_tipo_curso = inDescktop.createWindow({
        id:'winFrmListadoCgg_dhu_tipo_curso',
        title:tituloListadoCgg_dhu_tipo_curso,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_tipo_curso,descListadoCgg_dhu_tipo_curso),
        items:[grdCgg_dhu_tipo_curso],
        width:400,
        minWidth:400,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_dhu_tipo_curso,btnEditarCgg_dhu_tipo_curso,btnEliminarCgg_dhu_tipo_curso,'->',btnSalirCgg_dhu_tipo_curso]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_dhu_tipo_curso.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_tipo_curso.
     * @returns ventana winFrmCgg_dhu_tipo_curso.
     * @base FrmListadoCgg_dhu_tipo_curso.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_tipo_curso;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_tipo_curso.
     * @base FrmListadoCgg_dhu_tipo_curso.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_tipo_curso.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_tipo_curso;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_tipo_curso;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_tipo_curso.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_tipo_curso.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_tipo_curso desde una instancia.
 */
FrmListadoCgg_dhu_tipo_curso.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_tipo_curso desde una instancia.
 */
FrmListadoCgg_dhu_tipo_curso.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_tipo_curso,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_tipo_curso.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_tipo_curso desde una instancia.
 */
FrmListadoCgg_dhu_tipo_curso.prototype.loadData = function(){
    this.loadData();
}
