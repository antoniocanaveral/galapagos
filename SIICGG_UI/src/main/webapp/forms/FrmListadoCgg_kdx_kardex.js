/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_kdx_kardex.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_kdx_kardex(inDescktop){
    var optMenu = 'Kardex/Kardex';
    var urlListadoCgg_kdx_kardex=URL_WS+"Cgg_kdx_kardex";
    var tituloListadoCgg_kdx_kardex='Kardex';
    var descListadoCgg_kdx_kardex='El formulario permite administrar informaci\u00f3n de Kardex de especie';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_kdx_kardex.
     */
    var btnNuevoCgg_kdx_kardex = new Ext.Button({
        id:'btnNuevoCgg_kdx_kardex',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_kdx_kardex = new FrmCgg_kdx_kardex("insert");
                objCgg_kdx_kardex.closeHandler(function(){
                    gsCgg_kdx_kardex.reload();
                });
                objCgg_kdx_kardex.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_kdx_kardex.
     */
    var btnEditarCgg_kdx_kardex = new Ext.Button({
        id:'btnEditarCgg_kdx_kardex',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_kdx_kardex.getSelectionModel().getSelected();
                var tmpContador = 0
                if(r){
                    var tmpRecord
                    for(var i=0;i< gsCgg_kdx_kardex.getCount();i++)
                    {
                        if (gsCgg_kdx_kardex.getAt(i).get('CKESP_CODIGO') == r.get('CKESP_CODIGO'))
                        {
                            tmpContador += 1;
                        }
                        /*if(tmpContador>1)
                         {
                         break;
                         }*/
                    }
                    if (r.get('CKKRD_TIPO_MOVIMIENTO') == TypeMovimientoKardek.INVENTARIO_INICIAL && tmpContador == 1)
                    {
                        var objCgg_kdx_kardex = new FrmCgg_kdx_kardex("update",r);
                        objCgg_kdx_kardex.closeHandler(function(){
                            gsCgg_kdx_kardex.reload();
                        });
                        objCgg_kdx_kardex.loadData();
                        objCgg_kdx_kardex.show();
                    }
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_kdx_kardex.
     */
    var btnEliminarCgg_kdx_kardex = new Ext.Button({
        id:'btnEliminarCgg_kdx_kardex',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        visible:false,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_kdx_kardex,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_kdx_kardex(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_kdx_kardex(r){
                            winFrmListadoCgg_kdx_kardex.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_kardex,
                                    msg: 'La informaci\u00f3n de kardex ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_kdx_kardex.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_kdx_kardex,
                                    msg: 'La informaci\u00f3n de kardex no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_kdx_kardex.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCkkrd_codigo',grdCgg_kdx_kardex.getSelectionModel().getSelected().get('CKKRD_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_kdx_kardex,"delete",param, true, CallBackCgg_kdx_kardex);
                    }catch(inErr){
                        winFrmListadoCgg_kdx_kardex.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_kdx_kardex.
     */
    var btnSalirCgg_kdx_kardex = new Ext.Button({
        id:'btnSalirCgg_kdx_kardex',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_kdx_kardex.close();
            }}
    });
    /**
     * Ext.form.NumberField TIPO DE MOVIMIENTO:
     0 .- INVENTARIO INICIAL
     1.-  INGRESO
     2.-  SALIDA

     */
    /**
     * Ext.form.NumberField TIPO DE OPERACION:
     0.- COMPRA
     1.- VENTA
     2.- ANULACION
     3.- DEVOLUCION
     4.- OTRAS
     */

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_kardex.
     */
    var cmCgg_kdx_kardex = new Ext.grid.ColumnModel([
        {dataIndex:'CKKRD_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKESP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKESP_NOMBRE',header:'Especie',width:150,sortable:true},
        {dataIndex:'CKKRD_NUMERO',header:'N\u00famero',width:100,sortable:true},
        {dataIndex:'CKKRD_DETALLE',header:'Detalle',width:150,sortable:true},
        {dataIndex:'CKKRD_FECHA_REGISTRO',header:'Fecha registro',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CKKRD_TIPO_MOVIMIENTO',header:'Tipo movimiento',width:150,sortable:true,
            renderer:function(value)
            {
                if (value == TypeMovimientoKardek.INVENTARIO_INICIAL)
                {
                    return 'INVENTARIO INICIAL'
                }
                else if (value == TypeMovimientoKardek.INGRESO)
                {
                    return 'INGRESO'
                }
                else (value == TypeMovimientoKardek.SALIDA)
                {
                    return 'SALIDA'
                }

            }
        },
        {dataIndex:'CKKRD_TIPO_OPERACION',header:'Tipo operacion',width:150,sortable:true,
            renderer:function(value)
            {
                if (value == TypeOperacionKardex.COMPRA)
                {
                    return 'COMPRA'
                }
                else if (value ==  TypeOperacionKardex.VENTA)
                {
                    return 'TRANSFERENCIA'
                }
                else (value ==  TypeOperacionKardex.OTRAS)
                {
                    return 'INVENTARIO'
                }

            }
        },
        {dataIndex:'CKKRD_INGRESO_CANTIDAD',header:'Cantidad I',width:150,sortable:true},
        {dataIndex:'CKKRD_INGRESO_PU',header:'PU I',width:150,sortable:true},
        {dataIndex:'CKKRD_INGRESO_TOTAL',header:'Total I',width:150,sortable:true},
        {dataIndex:'CKKRD_SALIDA_CANTIDAD',header:'Cantidad S',width:150,sortable:true},
        {dataIndex:'CKKRD_SALIDA_PU',header:'PU S',width:150,sortable:true},
        {dataIndex:'CKKRD_SALIDA_TOTAL',header:'Total S',width:150,sortable:true},
        {dataIndex:'CKKRD_TOTAL_CANTIDAD',header:'Cantidad Total',width:150,sortable:true},
        {dataIndex:'CKKRD_TOTAL_PU',header:'PU',width:150,sortable:true},
        {dataIndex:'CKKRD_TOTAL_TOTAL',header:'Total',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_kardex por un campo especifico.
     */
    var gsCgg_kdx_kardex = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_kardex",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKKRD_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CKKRD_CODIGO'},
            {name:'CKESP_CODIGO'},
            {name:'CKESP_NOMBRE'},
            {name:'CKKRD_NUMERO'},
            {name:'CKKRD_DETALLE'},
            {name:'CKKRD_FECHA_REGISTRO'},
            {name:'CKKRD_TIPO_MOVIMIENTO'},
            {name:'CKKRD_TIPO_OPERACION'},
            {name:'CKKRD_INGRESO_CANTIDAD'},
            {name:'CKKRD_INGRESO_PU'},
            {name:'CKKRD_INGRESO_TOTAL'},
            {name:'CKKRD_SALIDA_CANTIDAD'},
            {name:'CKKRD_SALIDA_PU'},
            {name:'CKKRD_SALIDA_TOTAL'},
            {name:'CKKRD_TOTAL_CANTIDAD'},
            {name:'CKKRD_TOTAL_PU'},
            {name:'CKKRD_TOTAL_TOTAL'}
        ]),
        sortInfo:{field: 'CKKRD_NUMERO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'},
        groupField: 'CKESP_NOMBRE'
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_kdx_kardex.
     */
    var pgBarCgg_kdx_kardex= new Ext.PagingToolbar({
        store: gsCgg_kdx_kardex,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_kardex en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_kardex = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_kardex,
        store:gsCgg_kdx_kardex,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_kdx_kardex,
                width:200
            })
        ],
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Movimientos" : "Movimiento"]})'
        }),
        bbar:pgBarCgg_kdx_kardex,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_kdx_kardex.hidden){
                    btnEditarCgg_kdx_kardex.fireEvent('click', btnEditarCgg_kdx_kardex);
                }
            }}});
    gsCgg_kdx_kardex.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_kdx_kardex.
     */
    if(inDescktop){
        var winFrmListadoCgg_kdx_kardex = inDescktop.createWindow({
            id:'winFrmListadoCgg_kdx_kardex',
            title:tituloListadoCgg_kdx_kardex,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo(tituloListadoCgg_kdx_kardex,descListadoCgg_kdx_kardex),
            items:[grdCgg_kdx_kardex],
            bbar:[btnNuevoCgg_kdx_kardex,btnEditarCgg_kdx_kardex,btnEliminarCgg_kdx_kardex,'->',btnSalirCgg_kdx_kardex]
        });
    }
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_kdx_kardex.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_kdx_kardex.
     * @returns ventana winFrmCgg_kdx_kardex.
     * @base FrmListadoCgg_kdx_kardex.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_kdx_kardex;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_kdx_kardex.
     * @base FrmListadoCgg_kdx_kardex.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_kdx_kardex.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_kdx_kardex;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_kdx_kardex;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_kdx_kardex.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_kdx_kardex.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_kdx_kardex desde una instancia.
 */
FrmListadoCgg_kdx_kardex.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_kdx_kardex desde una instancia.
 */
FrmListadoCgg_kdx_kardex.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_kdx_kardex,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_kdx_kardex.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_kdx_kardex desde una instancia.
 */
FrmListadoCgg_kdx_kardex.prototype.loadData = function(){
    this.loadData();
}
