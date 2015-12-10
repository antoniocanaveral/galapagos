/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_kdx_punto_venta.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_kdx_punto_venta(inDesktop){
    var optMenu = 'Kardex/Punto de venta';
    var urlListadoCgg_kdx_punto_venta=URL_WS+"Cgg_kdx_punto_venta";
    var tituloListadoCgg_kdx_punto_venta='Punto de venta';
    var descListadoCgg_kdx_punto_venta='El formulario permite administrar informaci\u00f3n de Puntos de venta de especies';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_kdx_punto_venta.
     */
    var btnNuevoCgg_kdx_punto_venta = new Ext.Button({
        id:'btnNuevoCgg_kdx_punto_venta',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_kdx_punto_venta = new FrmCgg_kdx_punto_venta("insert");
                objCgg_kdx_punto_venta.closeHandler(function(){
                    gsCgg_kdx_punto_venta.reload();
                });
                objCgg_kdx_punto_venta.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_kdx_punto_venta.
     */
    var btnEditarCgg_kdx_punto_venta = new Ext.Button({
        id:'btnEditarCgg_kdx_punto_venta',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_kdx_punto_venta.getSelectionModel().getSelected();
                if(r){
                    var objCgg_kdx_punto_venta = new FrmCgg_kdx_punto_venta("update",r);
                    objCgg_kdx_punto_venta.closeHandler(function(){
                        gsCgg_kdx_punto_venta.reload();
                    });
                    objCgg_kdx_punto_venta.loadData();
                    objCgg_kdx_punto_venta.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_kdx_punto_venta.
     */
    var btnEliminarCgg_kdx_punto_venta = new Ext.Button({
        id:'btnEliminarCgg_kdx_punto_venta',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_kdx_punto_venta,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_kdx_punto_venta(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_kdx_punto_venta(r){
                            winFrmListadoCgg_kdx_punto_venta.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_punto_venta,
                                    msg: 'La informaci\u00f3n de Kdx punto venta ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_kdx_punto_venta.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_punto_venta,
                                    msg: 'La informaci\u00f3n de Kdx punto venta no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_kdx_punto_venta.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCkpvt_codigo',grdCgg_kdx_punto_venta.getSelectionModel().getSelected().get('CKPVT_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_kdx_punto_venta,"delete",param, true, CallBackCgg_kdx_punto_venta);
                    }catch(inErr){
                        winFrmListadoCgg_kdx_punto_venta.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_kdx_punto_venta.
     */
    var btnSalirCgg_kdx_punto_venta = new Ext.Button({
        id:'btnSalirCgg_kdx_punto_venta',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_kdx_punto_venta.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_punto_venta.
     */
    var cmCgg_kdx_punto_venta = new Ext.grid.ColumnModel([
        {dataIndex:'CKPVT_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKPVT_NOMBRE',header:'Punto de Venta',width:150,sortable:true},
        {dataIndex:'CCTN_CODIGO',header:'Ciudad',width:150,sortable:true,
            renderer:function(inCCTN_CODIGO){
                try{
                    var rCiudad=SCGG_CANTON.getAt(SCGG_CANTON.findExact('CCTN_CODIGO',inCCTN_CODIGO));
                    return rCiudad.get('CCTN_NOMBRE');
                }catch(inError){
                    return '';
                }

            }
        },
        {dataIndex:'CKPVT_OBSERVACION',header:'Observaci\u00f3n',width:200,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_punto_venta por un campo especifico.
     */
    var gsCgg_kdx_punto_venta = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_punto_venta",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKPVT_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CKPVT_CODIGO'},
            {name:'CCTN_CODIGO'},
            {name:'CKPVT_NOMBRE'},
            {name:'CKPVT_OBSERVACION'}
        ]),
        sortInfo:{field: 'CCTN_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_kdx_punto_venta.
     */
    var pgBarCgg_kdx_punto_venta= new Ext.PagingToolbar({
        store: gsCgg_kdx_punto_venta,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_punto_venta en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_punto_venta = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_punto_venta,
        store:gsCgg_kdx_punto_venta,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        viewConfig:{forceFit:true},
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_kdx_punto_venta,
                width:200
            })
        ],
        bbar:pgBarCgg_kdx_punto_venta,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_kdx_punto_venta.hidden){
                    btnEditarCgg_kdx_punto_venta.fireEvent('click', btnEditarCgg_kdx_punto_venta);
                }
            }}});
    gsCgg_kdx_punto_venta.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_kdx_punto_venta.
     */
    var winFrmListadoCgg_kdx_punto_venta = null;
    if(inDesktop!==null && inDesktop!==undefined){
        winFrmListadoCgg_kdx_punto_venta = inDesktop.createWindow({
            id:'winFrmListadoCgg_kdx_punto_venta',
            title:tituloListadoCgg_kdx_punto_venta,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_punto_venta,descListadoCgg_kdx_punto_venta),
            items:[grdCgg_kdx_punto_venta],
            bbar:[btnNuevoCgg_kdx_punto_venta,btnEditarCgg_kdx_punto_venta,btnEliminarCgg_kdx_punto_venta,'->',btnSalirCgg_kdx_punto_venta]
        });
    }
    else
    {
        winFrmListadoCgg_kdx_punto_venta = new Ext.Window({
            id:'winFrmListadoCgg_kdx_punto_venta',
            title:tituloListadoCgg_kdx_punto_venta,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            modal:true,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_punto_venta,descListadoCgg_kdx_punto_venta),
            items:[grdCgg_kdx_punto_venta],
            bbar:[btnNuevoCgg_kdx_punto_venta,btnEditarCgg_kdx_punto_venta,btnEliminarCgg_kdx_punto_venta,'->',btnSalirCgg_kdx_punto_venta]
        });
    }
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_kdx_punto_venta.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_kdx_punto_venta.
     * @returns ventana winFrmCgg_kdx_punto_venta.
     * @base FrmListadoCgg_kdx_punto_venta.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_kdx_punto_venta;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_kdx_punto_venta.
     * @base FrmListadoCgg_kdx_punto_venta.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_kdx_punto_venta.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_kdx_punto_venta;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_kdx_punto_venta;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_kdx_punto_venta.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_kdx_punto_venta.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_kdx_punto_venta desde una instancia.
 */
FrmListadoCgg_kdx_punto_venta.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_kdx_punto_venta desde una instancia.
 */
FrmListadoCgg_kdx_punto_venta.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_kdx_punto_venta,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_kdx_punto_venta.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_kdx_punto_venta desde una instancia.
 */
FrmListadoCgg_kdx_punto_venta.prototype.loadData = function(){
    this.loadData();
}
