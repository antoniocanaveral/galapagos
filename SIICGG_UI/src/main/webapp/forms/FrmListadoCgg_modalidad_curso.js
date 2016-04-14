/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_modalidad_curso.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_modalidad_curso(inDesktop){
    var optMenu = 'Configuraci\u00F3n/Educaci\u00F3n/Modalidad de estudio';
    var urlListadoCgg_modalidad_curso=URL_WS+"Cgg_modalidad_curso";
    var tituloListadoCgg_modalidad_curso='Modalidad curso';
    var descListadoCgg_modalidad_curso='El formulario permite administrar informaci\u00f3n de Modalidad curso formaci\u00f3n profesional';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_modalidad_curso.
     */
    var btnNuevoCgg_modalidad_curso = new Ext.Button({
        id:'btnNuevoCgg_modalidad_curso',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_modalidad_curso = new FrmCgg_modalidad_curso("insert");
                objCgg_modalidad_curso.closeHandler(function(){
                    gsCgg_modalidad_curso.reload();
                });
                objCgg_modalidad_curso.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_modalidad_curso.
     */
    var btnEditarCgg_modalidad_curso = new Ext.Button({
        id:'btnEditarCgg_modalidad_curso',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_modalidad_curso.getSelectionModel().getSelected();
                if(r){
                    var objCgg_modalidad_curso = new FrmCgg_modalidad_curso("update",r);
                    objCgg_modalidad_curso.closeHandler(function(){
                        gsCgg_modalidad_curso.reload();
                    });
                    objCgg_modalidad_curso.loadData();
                    objCgg_modalidad_curso.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_modalidad_curso.
     */
    var btnEliminarCgg_modalidad_curso = new Ext.Button({
        id:'btnEliminarCgg_modalidad_curso',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_modalidad_curso,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_modalidad_curso(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_modalidad_curso(r){
                            winFrmListadoCgg_modalidad_curso.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_modalidad_curso,
                                    msg: 'La informaci\u00f3n de Modalidad curso ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_modalidad_curso.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_modalidad_curso,
                                    msg: 'La informaci\u00f3n de Modalidad curso no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_modalidad_curso.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCgmdc_codigo',grdCgg_modalidad_curso.getSelectionModel().getSelected().get('CGMDC_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_modalidad_curso,"delete",param, true, CallBackCgg_modalidad_curso);
                    }catch(inErr){
                        winFrmListadoCgg_modalidad_curso.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_modalidad_curso.
     */
    var btnSalirCgg_modalidad_curso = new Ext.Button({
        id:'btnSalirCgg_modalidad_curso',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_modalidad_curso.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_modalidad_curso.
     */
    var cmCgg_modalidad_curso = new Ext.grid.ColumnModel([
        {dataIndex:'CGMDC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CGMDC_DESCRIPCION',header:'Descripcion',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_modalidad_curso por un campo especifico.
     */
    var gsCgg_modalidad_curso = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_modalidad_curso",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CGMDC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CGMDC_CODIGO'},
            {name:'CGMDC_DESCRIPCION'}
        ]),
        sortInfo:{field: 'CGMDC_DESCRIPCION', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_modalidad_curso.
     */
    var pgBarCgg_modalidad_curso= new Ext.PagingToolbar({
        store: gsCgg_modalidad_curso,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_modalidad_curso en un formato tabular de filas y columnas.
     */
    var grdCgg_modalidad_curso = new Ext.grid.GridPanel({
        cm:cmCgg_modalidad_curso,
        store:gsCgg_modalidad_curso,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        viewConfig:{forceFit:true},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_modalidad_curso,
                width:200
            })
        ],
        bbar:pgBarCgg_modalidad_curso,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_modalidad_curso.hidden){
                    btnEditarCgg_modalidad_curso.fireEvent('click', btnEditarCgg_modalidad_curso);
                }
            }}});
    gsCgg_modalidad_curso.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_modalidad_curso.
     */
     var winFrmListadoCgg_modalidad_curso = null;

    if(inDesktop!==null && inDesktop!==undefined){
        winFrmListadoCgg_modalidad_curso  = inDesktop.createWindow({
            id:'winFrmListadoCgg_modalidad_curso',
            title:tituloListadoCgg_modalidad_curso,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_modalidad_curso,descListadoCgg_modalidad_curso),
            items:[grdCgg_modalidad_curso],
            bbar:[btnNuevoCgg_modalidad_curso,btnEditarCgg_modalidad_curso,btnEliminarCgg_modalidad_curso,'->',btnSalirCgg_modalidad_curso]
        });
    }
    else
    {
            winFrmListadoCgg_modalidad_curso = new Ext.Window({
            id:'winFrmListadoCgg_modalidad_curso',
            title:tituloListadoCgg_modalidad_curso,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_modalidad_curso,descListadoCgg_modalidad_curso),
            items:[grdCgg_modalidad_curso],
            bbar:[btnNuevoCgg_modalidad_curso,btnEditarCgg_modalidad_curso,btnEliminarCgg_modalidad_curso,'->',btnSalirCgg_modalidad_curso]
        });
    }
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_modalidad_curso.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_modalidad_curso.
     * @returns ventana winFrmCgg_modalidad_curso.
     * @base FrmListadoCgg_modalidad_curso.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_modalidad_curso;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_modalidad_curso.
     * @base FrmListadoCgg_modalidad_curso.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_modalidad_curso.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_modalidad_curso;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_modalidad_curso;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_modalidad_curso.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_modalidad_curso.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_modalidad_curso desde una instancia.
 */
FrmListadoCgg_modalidad_curso.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_modalidad_curso desde una instancia.
 */
FrmListadoCgg_modalidad_curso.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_modalidad_curso,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_modalidad_curso.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_modalidad_curso desde una instancia.
 */
FrmListadoCgg_modalidad_curso.prototype.loadData = function(){
    this.loadData();
}
