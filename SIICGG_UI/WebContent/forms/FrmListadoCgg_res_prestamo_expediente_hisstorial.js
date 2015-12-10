/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_prestamo_expediente.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_prestamo_expediente_hisstorial(){
    var urlListadoCgg_res_prestamo_expediente_historial=URL_WS+"Cgg_res_prestamo_expediente";
    var tituloListadoCgg_res_prestamo_expediente_historial='Lista de movimiento de expedientes';
    var descListadoCgg_res_prestamo_expediente='Formulario que permite consultar los expedientes en prestamo';
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_prestamo_expediente.
     */
    var btnSalirCgg_res_prestamo_expediente_historial = new Ext.Button({
        id:'btnSalirCgg_res_prestamo_expediente_historial',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_prestamo_expediente_historial.close();
            }}
    });    
    var expanderHistorial = new Ext.ux.grid.RowExpander({
        tpl : new Ext.XTemplate(
               '<SPAN style="color:blue"><b>Movimiento:</b><br></SPAN>'+
                    '<table id="box-table-a" cborder="0" align="left">' +
                        '<tbody>' +
                        '<tr>' +
                        '<th style="width: 2%;">No</th>' +
                        '<th style="width: 15%;">Nombre</th>' +
                        '<th style="width: 5%;">Movimiento</th>' +
                        '<th style="width: 10%;">Fecha operacion</th>' +
                        '<th style="width: 10%;">Observacion</th>' +
                        '</tr>'+
                        '<tpl for="MOVIMIENTO"'+
                            '<tr>' +
                            '<td ><b><font size="1" face="Arial, Helvetica, sans-serif">{#}</font></td> ' +
                            '<td ><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_NOMBRE_RECIBE}</font> </td> ' +
                            '<td >',
                                '<tpl if="CRPEX_MOVIMIENTO == 1">',
                                     '<b><font size="1" face="Arial, Helvetica, sans-serif">INGRESO</font></b>',
                                '</tpl>',
                                '<tpl if="CRPEX_MOVIMIENTO == 2">',
                                      '<b><font size="1" face="Arial, Helvetica, sans-serif">SALIDA</font></b>',
                                '</tpl>',
                            '</td>' +
                            '<td ><font size="1" face="Arial, Helvetica, sans-serif">{[this.myDate(values.CRPEX_FECHA_OPERACION)]}</font> </td> ' +
                            '<td ><font size="1" face="Arial, Helvetica, sans-serif">{CRPEX_OBSERVACION}</font> </td> ' +
                            '</tr>' +
                        '</tpl>',
                        '</tbody>' +
                    '</table>',
                 {
            // XTemplate configuration:
            compiled: true,
            disableFormats: true,
            // member functions:
            myDate: function(CRPEX_FECHA_OPERACION){
                return truncDate(CRPEX_FECHA_OPERACION);
            }
        })
    });

    
    /**
     *
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_prestamo_expediente.
     */
    var cmCgg_res_prestamo_expediente_historial = new Ext.grid.ColumnModel([
         expanderHistorial,
        {dataIndex:'CRPER_CODIGO',hidden:true,header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRPER_NUMERO_EXPEDIENTE',header:'No expediente',width:150,sortable:true},
        {dataIndex:'CRPER_NOMBRE_PERSONA',header:'Persona',width:150,sortable:true},
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'Cedula/Pasaporte',width:150,sortable:true},
        {dataIndex:'CRPER_FECHA_ARCHIVO',header:'Fecha Archivo',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'PRESTAMOEXPEDIENTE',hidden:true,header:'Nombre',width:300,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_prestamo_expediente por un campo especifico.
     */
    var gsCgg_res_prestamo_expediente_historial = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_persona",
            method:"selectExpedientePersona",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPER_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRPER_CODIGO'},
            {name:'CRPER_NOMBRE_PERSONA'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_NUMERO_EXPEDIENTE'},
            {name:'CRPER_FECHA_ARCHIVO'},
            {name:'PRESTAMOEXPEDIENTE'},
            {name:'MOVIMIENTO'}
        ]),
        sortInfo:{field: 'CRPER_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_prestamo_expediente.
     */
    var pgBarCgg_res_prestamo_expediente_historial= new Ext.PagingToolbar({
        store: gsCgg_res_prestamo_expediente_historial,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_prestamo_expediente en un formato tabular de filas y columnas.
     */
    var grdCgg_res_prestamo_expediente_historial = new Ext.grid.GridPanel({
        cm:cmCgg_res_prestamo_expediente_historial,
        store:gsCgg_res_prestamo_expediente_historial,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_prestamo_expediente_historial,
                width:200
            })
        ],
        bbar:pgBarCgg_res_prestamo_expediente_historial,
        plugins: expanderHistorial,
        animCollapse: false

       });
    gsCgg_res_prestamo_expediente_historial.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_prestamo_expediente.
     */
    var winFrmListadoCgg_res_prestamo_expediente_historial = new Ext.Window({
        id:'winFrmListadoCgg_res_prestamo_expediente_historial',
        title:tituloListadoCgg_res_prestamo_expediente_historial,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
		modal:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo(''+tituloListadoCgg_res_prestamo_expediente_historial,descListadoCgg_res_prestamo_expediente),
        items:[grdCgg_res_prestamo_expediente_historial],
        bbar:['->',btnSalirCgg_res_prestamo_expediente_historial]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_prestamo_expediente_historial.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_prestamo_expediente.
     * @returns ventana winFrmCgg_res_prestamo_expediente.
     * @base FrmListadoCgg_res_prestamo_expediente_ingreso.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_prestamo_expediente_historial;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_prestamo_expediente.
     * @base FrmListadoCgg_res_prestamo_expediente_hisstorial.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_prestamo_expediente_historial.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_prestamo_expediente_historial;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_prestamo_expediente_historial;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_prestamo_expediente_hisstorial.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_prestamo_expediente_hisstorial.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_prestamo_expediente desde una instancia.
 */
FrmListadoCgg_res_prestamo_expediente_hisstorial.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_prestamo_expediente desde una instancia.
 */
FrmListadoCgg_res_prestamo_expediente_hisstorial.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_prestamo_expediente,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_prestamo_expediente_hisstorial.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_prestamo_expediente desde una instancia.
 */
FrmListadoCgg_res_prestamo_expediente_hisstorial.prototype.loadData = function(){
    this.loadData();
}
