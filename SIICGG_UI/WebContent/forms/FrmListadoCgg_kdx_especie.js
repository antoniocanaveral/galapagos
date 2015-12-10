/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_kdx_especie.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_kdx_especie(inDesktop){
    var optMenu = 'Kardex/Especies';
    var urlListadoCgg_kdx_especie=URL_WS+"Cgg_kdx_especie";
    var tituloListadoCgg_kdx_especie='Kardex Especie';
    var descListadoCgg_kdx_especie='El formulario permite administrar informaci\u00f3n de Kardex Especie';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_kdx_especie.
     */
    var btnNuevoCgg_kdx_especie = new Ext.Button({
        id:'btnNuevoCgg_kdx_especie',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_kdx_especie = new FrmCgg_kdx_especie("insert");
                objCgg_kdx_especie.closeHandler(function(){
                    gsCgg_kdx_especie.reload();
                });
                objCgg_kdx_especie.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_kdx_especie.
     */
    var btnEditarCgg_kdx_especie = new Ext.Button({
        id:'btnEditarCgg_kdx_especie',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_kdx_especie.getSelectionModel().getSelected();
                if(r){
                    var objCgg_kdx_especie = new FrmCgg_kdx_especie("update",r);
                    objCgg_kdx_especie.closeHandler(function(){
                        gsCgg_kdx_especie.reload();
                    });
                    objCgg_kdx_especie.loadData();
                    objCgg_kdx_especie.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_kdx_especie.
     */
    var btnEliminarCgg_kdx_especie = new Ext.Button({
        id:'btnEliminarCgg_kdx_especie',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_kdx_especie,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_kdx_especie(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_kdx_especie(r){
                            winFrmListadoCgg_kdx_especie.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_especie,
                                    msg: 'La informaci\u00f3n de Kardex Especie ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_kdx_especie.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_especie,
                                    msg: 'La informaci\u00f3n de Kardex Especie no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_kdx_especie.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCkesp_codigo',grdCgg_kdx_especie.getSelectionModel().getSelected().get('CKESP_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_kdx_especie,"delete",param, true, CallBackCgg_kdx_especie);
                    }catch(inErr){
                        winFrmListadoCgg_kdx_especie.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_kdx_especie.
     */
    var btnSalirCgg_kdx_especie = new Ext.Button({
        id:'btnSalirCgg_kdx_especie',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_kdx_especie.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_especie.
     */
    var cmCgg_kdx_especie = new Ext.grid.ColumnModel([
        {dataIndex:'CKESP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hiddeable:true},
        {dataIndex:'CKESP_NOMBRE',header:'Nombre',width:150,sortable:true},
        {dataIndex:'CKESP_PRECIO',header:'Precio',width:150,sortable:true,renderer: 'usMoney'},
        {dataIndex:'CKESP_CANTIDAD',header:'Stock',width:150,sortable:true},
        {dataIndex:'CKESP_DISPONIBLE_MIN',header:'Stock min',width:150,sortable:true},
        {dataIndex:'CKESP_DISPONIBLE_MAX',header:'Stock max',width:150,sortable:true},
        {dataIndex:'CKESP_TIPO',header:'Tipo',width:150,sortable:true,
            renderer:function(value)
            {
                switch (value)
                {
                    case TypeEspecie.RESIDENCIA:
                        return 'Residencia';
                        break;
                    case TypeEspecie.TCT:
                        return 'TCT';
                        break;
                    default:
                        return 'Otros';
                }
            }
        }]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_especie por un campo especifico.
     */
    var gsCgg_kdx_especie = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_especie",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKESP_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CKESP_CODIGO'},
            {name:'CKESP_NOMBRE'},
            {name:'CKESP_PRECIO'},
            {name:'CKESP_CANTIDAD'},
            {name:'CKESP_DISPONIBLE_MIN'},
            {name:'CKESP_DISPONIBLE_MAX'},
            {name:'CKESP_TIPO'},
			{name:'CKESP_INDICE'},
			{name:'CKESP_REPORTE'}
        ]),
        sortInfo:{field: 'CKESP_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_kdx_especie.
     */
    var pgBarCgg_kdx_especie= new Ext.PagingToolbar({
        store: gsCgg_kdx_especie,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_especie en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_especie = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_especie,
        store:gsCgg_kdx_especie,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_kdx_especie,
                width:200
            })
        ],
        viewConfig:{forceFit:true},
        bbar:pgBarCgg_kdx_especie,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_kdx_especie.hidden){
                    btnEditarCgg_kdx_especie.fireEvent('click', btnEditarCgg_kdx_especie);
                }
            }}});
    gsCgg_kdx_especie.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_kdx_especie.
     */
    var winFrmListadoCgg_kdx_especie = null;
    if(inDesktop!==null && inDesktop!==undefined){
        winFrmListadoCgg_kdx_especie  = inDesktop.createWindow({
            id:'winFrmListadoCgg_kdx_especie',
            title:tituloListadoCgg_kdx_especie,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_especie,descListadoCgg_kdx_especie),
            items:[grdCgg_kdx_especie],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_kdx_especie,btnEditarCgg_kdx_especie,btnEliminarCgg_kdx_especie,'->',btnSalirCgg_kdx_especie]
        });
    }
    else
    {
        winFrmListadoCgg_kdx_especie = new Ext.Window({
            id:'winFrmListadoCgg_kdx_especie',
            title:tituloListadoCgg_kdx_especie,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_especie,descListadoCgg_kdx_especie),
            items:[grdCgg_kdx_especie],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_kdx_especie,btnEditarCgg_kdx_especie,btnEliminarCgg_kdx_especie,'->',btnSalirCgg_kdx_especie]
        });
    }
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_kdx_especie.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_kdx_especie.
     * @returns ventana winFrmCgg_kdx_especie.
     * @base FrmListadoCgg_kdx_especie.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_kdx_especie;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_kdx_especie.
     * @base FrmListadoCgg_kdx_especie.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_kdx_especie.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_kdx_especie;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_kdx_especie;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_kdx_especie.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_kdx_especie.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_kdx_especie desde una instancia.
 */
FrmListadoCgg_kdx_especie.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_kdx_especie desde una instancia.
 */
FrmListadoCgg_kdx_especie.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_kdx_especie,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_kdx_especie.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_kdx_especie desde una instancia.
 */
FrmListadoCgg_kdx_especie.prototype.loadData = function(){
    this.loadData();
}
