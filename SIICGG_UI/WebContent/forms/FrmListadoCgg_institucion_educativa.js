/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_institucion_educativa.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_institucion_educativa(inDesktop){
    var optMenu = 'Configuraci\u00F3n/Educaci\u00F3n/Instituci\u00F3n Educativa';
    var urlListadoCgg_institucion_educativa=URL_WS+"Cgg_institucion_educativa";
    var tituloListadoCgg_institucion_educativa='Institucion educativa';
    var descListadoCgg_institucion_educativa='El formulario permite administrar informaci\u00f3n de la tabla Institucion educativa';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_institucion_educativa.
     */
    var btnNuevoCgg_institucion_educativa = new Ext.Button({
        id:'btnNuevoCgg_institucion_educativa',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_institucion_educativa = new FrmCgg_institucion_educativa("insert");
                objCgg_institucion_educativa.closeHandler(function(){
                    gsCgg_institucion_educativa.reload();
                });
                objCgg_institucion_educativa.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_institucion_educativa.
     */
    var btnEditarCgg_institucion_educativa = new Ext.Button({
        id:'btnEditarCgg_institucion_educativa',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_institucion_educativa.getSelectionModel().getSelected();
                if(r){
                    var objCgg_institucion_educativa = new FrmCgg_institucion_educativa("update",r);
                    objCgg_institucion_educativa.closeHandler(function(){
                        gsCgg_institucion_educativa.reload();
                    });
                    objCgg_institucion_educativa.loadData();
                    objCgg_institucion_educativa.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_institucion_educativa.
     */
    var btnEliminarCgg_institucion_educativa = new Ext.Button({
        id:'btnEliminarCgg_institucion_educativa',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_institucion_educativa,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_institucion_educativa(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_institucion_educativa(r){
                            winFrmListadoCgg_institucion_educativa.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_institucion_educativa,
                                    msg: 'La informaci\u00f3n de Institucion educativa ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_institucion_educativa.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_institucion_educativa,
                                    msg: 'La informaci\u00f3n de Institucion educativa no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_institucion_educativa.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCgied_codigo',grdCgg_institucion_educativa.getSelectionModel().getSelected().get('CGIED_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_institucion_educativa,"delete",param, true, CallBackCgg_institucion_educativa);
                    }catch(inErr){
                        winFrmListadoCgg_institucion_educativa.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_institucion_educativa.
     */
    var btnSalirCgg_institucion_educativa = new Ext.Button({
        id:'btnSalirCgg_institucion_educativa',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_institucion_educativa.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_institucion_educativa.
     */
    var cmCgg_institucion_educativa = new Ext.grid.ColumnModel([
        {dataIndex:'CGIED_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
		{dataIndex:'CGIED_NOMBRE',header:'Nombre',width:200,sortable:true},
        {dataIndex:'CGIED_DESCRIPCION',header:'Descripci\u00F3n',width:200,sortable:true},
        {dataIndex:'CPAIS_CODIGO',header:'Pa\u00eds',width:100,sortable:true,
            renderer:function(inCPAIS_CODIGO){
                try{
                    var rPais=SCGG_PAIS.getAt(SCGG_PAIS.findExact('CPAIS_CODIGO',inCPAIS_CODIGO));
                    return rPais.get('CPAIS_NOMBRE');
                }catch(inError){
                    return '';
                }

            }},
        {dataIndex:'CGIED_DIRECCION',header:'Direccion',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_institucion_educativa por un campo especifico.
     */
    var gsCgg_institucion_educativa = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_institucion_educativa",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CGIED_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CGIED_CODIGO'},
            {name:'CPAIS_CODIGO'},
			{name:'CGIED_NOMBRE'},
            {name:'CGIED_DESCRIPCION'},
            {name:'CGIED_DIRECCION'}
        ]),
        sortInfo:{field: 'CGIED_DESCRIPCION', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_institucion_educativa.
     */
    var pgBarCgg_institucion_educativa= new Ext.PagingToolbar({
        store: gsCgg_institucion_educativa,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_institucion_educativa en un formato tabular de filas y columnas.
     */
    var grdCgg_institucion_educativa = new Ext.grid.GridPanel({
        cm:cmCgg_institucion_educativa,
        store:gsCgg_institucion_educativa,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        viewConfig:{forceFit:true},
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_institucion_educativa,
                width:200
            })
        ],
        bbar:pgBarCgg_institucion_educativa,
      //  plugins:expander,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_institucion_educativa.hidden){
                    btnEditarCgg_institucion_educativa.fireEvent('click', btnEditarCgg_institucion_educativa);
                }
            }}});
    gsCgg_institucion_educativa.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_institucion_educativa.
     */
    var winFrmListadoCgg_institucion_educativa = null;
    if(inDesktop!==null && inDesktop!==undefined){
        winFrmListadoCgg_institucion_educativa = inDesktop.createWindow({
            id:'winFrmListadoCgg_institucion_educativa',
            title:tituloListadoCgg_institucion_educativa,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo(tituloListadoCgg_institucion_educativa,descListadoCgg_institucion_educativa),
            items:[grdCgg_institucion_educativa],
            bbar:[btnNuevoCgg_institucion_educativa,btnEditarCgg_institucion_educativa,btnEliminarCgg_institucion_educativa,'->',btnSalirCgg_institucion_educativa]
        });
    }
    else
    {
        winFrmListadoCgg_institucion_educativa = new Ext.Window({
            id:'winFrmListadoCgg_institucion_educativa',
            title:tituloListadoCgg_institucion_educativa,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo(tituloListadoCgg_institucion_educativa,descListadoCgg_institucion_educativa),
            items:[grdCgg_institucion_educativa],
            bbar:[btnNuevoCgg_institucion_educativa,btnEditarCgg_institucion_educativa,btnEliminarCgg_institucion_educativa,'->',btnSalirCgg_institucion_educativa]
        });
    }

    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_institucion_educativa.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_institucion_educativa.
     * @returns ventana winFrmCgg_institucion_educativa.
     * @base FrmListadoCgg_institucion_educativa.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_institucion_educativa;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_institucion_educativa.
     * @base FrmListadoCgg_institucion_educativa.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_institucion_educativa.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_institucion_educativa;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_institucion_educativa;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_institucion_educativa.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_institucion_educativa.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_institucion_educativa desde una instancia.
 */
FrmListadoCgg_institucion_educativa.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_institucion_educativa desde una instancia.
 */
FrmListadoCgg_institucion_educativa.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_institucion_educativa,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_institucion_educativa.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_institucion_educativa desde una instancia.
 */
FrmListadoCgg_institucion_educativa.prototype.loadData = function(){
    this.loadData();
}
