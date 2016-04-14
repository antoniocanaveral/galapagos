/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_prestamo_expediente.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_prestamo_expediente(inDesktop){
    var optMenu = 'Control de Residencia/Archivo';
    var urlListadoCgg_res_prestamo_expediente=URL_WS+"Cgg_res_prestamo_expediente";
    var tituloListadoCgg_res_prestamo_expediente='Listado de expedientes';
    var descListadoCgg_res_prestamo_expediente='El formulario permite administrar informaci\u00f3n de la tabla Res prestamo expediente';

     var btnNuevoCgg_res_historial_movimiento = new Ext.Button({
        id:'btnNuevoCgg_res_historial_movimiento',
        text:'Historial',
        tooltip:'Historial de movimiento',
        iconCls:'iconListado',
        listeners:{
            click:function(){

                    var objListadoCgg_res_historial_movimiento = new FrmListadoCgg_res_prestamo_expediente_hisstorial();
                    objListadoCgg_res_historial_movimiento.closeHandler(function(){

                    });
                    objListadoCgg_res_historial_movimiento.show();
                

            }}
    });
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_prestamo_expediente.
     */
    var btnNuevoCgg_res_prestamo_expediente = new Ext.Button({
        id:'btnNuevoCgg_res_prestamo_expediente',
        text:'Nuevo',
        iconCls:'iconNuevo',

        menu:[
            {text:'Salida expediente',
                iconCls:'iconNuevo',
                tooltip:'Registro salida expediente',
                listeners:{
                    click:function(){
                        var r=grdCgg_res_prestamo_expediente.getSelectionModel().getSelected();
                         if(r){
                        var salida=(grdCgg_res_prestamo_expediente.getSelectionModel().getSelected().get('CRPEX_MOVIMIENTO'));

                             if((salida==TypeMovimientoExpediente.ARCHIVO) || (salida==TypeMovimientoExpediente.INGRESO)){
                            var objCgg_res_salida_expediente = new FrmCgg_res_prestamo_expediente('insert',r);
                            objCgg_res_salida_expediente.closeHandler(function(){
                                gsCgg_res_prestamo_persona.reload();
                            });
                            objCgg_res_salida_expediente.show();
                        }else{
                            Ext.MessageBox.alert('Salida', 'No existe ingreso de expediente ');
                        }}

                    }}},{text:'Ingreso expediente',
                iconCls:'iconNuevo',
                tooltip:'Registro ingreso expediente',
                listeners:{
                    click:function(){
                       
                        var r=grdCgg_res_prestamo_expediente.getSelectionModel().getSelected();
                         if(r){
                        var ingreso=(grdCgg_res_prestamo_expediente.getSelectionModel().getSelected().get('CRPEX_MOVIMIENTO'));

                             if(ingreso==TypeMovimientoExpediente.SALIDA){
                            var objCgg_res_ingreso_expediente = new FrmCgg_res_prestamo_expediente('insert',r);
                            objCgg_res_ingreso_expediente.closeHandler(function(){
                                gsCgg_res_prestamo_persona.reload();

                            });

                            objCgg_res_ingreso_expediente.show();
                        }else{
                            Ext.MessageBox.alert('Ingreso', 'No existe salida de expediente ');
                        }

                         }

                    }}}
    ]

    });


    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_prestamo_expediente.
     */
    var btnSalirCgg_res_prestamo_expediente = new Ext.Button({
        id:'btnSalirCgg_res_prestamo_expediente',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Salir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_prestamo_expediente.close();
            }}
    });   
      /**
     *  Ext.ux.grid.RowExpander Expandir fila
     **/
    var expanderPrestamo = new Ext.ux.grid.RowExpander({
        tpl : new Ext.XTemplate(
               '<SPAN style="color:blue"><b>Movimiento:</b><br></SPAN>'+
                    '<table id="box-table-a" cborder="0" align="left">' +
                        '<tbody>' +
                        '<tr>' +
                        '<th style="width: 2%;">No</th>' +
                        '<th style="width: 10%;">Nombre</th>' +
                        '<th style="width: 5%;">Movimiento</th>' +
                        '<th style="width: 10%;">Fecha operacion</th>' +
                        '</tr>'+
                        '<tpl>'+
                            '<tr>' +
                            '<td ><b><font size="1" face="Arial, Helvetica, sans-serif">{#}</font></td> ' +
                            '<td ><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_NOMBRE_REALIZA}</font> </td> ' +
                            '<td >',
                                '<tpl if="CRPEX_MOVIMIENTO == 1">',
                                     '<b><font size="1" face="Arial, Helvetica, sans-serif">INGRESO</font></b>',
                                '</tpl>',
                                '<tpl if="CRPEX_MOVIMIENTO == 2">',
                                      '<b><font size="1" face="Arial, Helvetica, sans-serif">SALIDA</font></b>',
                                '</tpl>',
                            '</td>' +
                            '<td ><font size="1" face="Arial, Helvetica, sans-serif">{[this.myDate(values.CRPEX_FECHA_OPERACION)]}</font> </td> ' +
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
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_prestamo_expediente.
     */
    var cmCgg_res_prestamo_persona = new Ext.grid.ColumnModel([
         expanderPrestamo,
        {dataIndex:'CRPEX_NOMBRE',header:'Nombre persona',width:200,sortable:true},
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'Cedula/pasaporte',width:100,sortable:true},
		{dataIndex:'CRPER_NUMERO_RESIDENCIA',header:'Carn\u00e9t',width:70,sortable:true},
        {dataIndex:'CRPER_NUMERO_EXPEDIENTE',header:'N expediente',width:150,sortable:true},
        {dataIndex:'CRPER_FECHA_ARCHIVO',header:'Fecha archivo',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CRPER_NOMBRE_REALIZA',header:'Realiza Movimiento',width:150,sortable:true},
        {dataIndex:'CRPEX_MOVIMIENTO',header:'Movimiento',width:150,sortable:true,renderer:function(inMovimiento){
            if(inMovimiento==TypeMovimientoExpediente.ARCHIVO){
                return('ARCHIVO')
            }  if(inMovimiento==TypeMovimientoExpediente.SALIDA){
                return('SALIDA')
            }if(inMovimiento==TypeMovimientoExpediente.INGRESO){
                return('INGRESO')
            }
        }},
       {dataIndex:'CRPEX_FECHA_OPERACION',hidden:true,header:'Fecha operaci\u00f3',width:150,sortable:true,renderer:truncDate}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_prestamo_expediente por un campo especifico.
     */
    var gsCgg_res_prestamo_persona = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_prestamo_expediente",
            method:"selectPrestacionExpePersona",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPER_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[  {name:'CRPER_CODIGO'},
            {name:'CRPEX_NOMBRE'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
			{name:'CRPER_NUMERO_RESIDENCIA'},
            {name:'CRPER_NUMERO_EXPEDIENTE'},
            {name:'CRPER_NOMBRE_REALIZA'},
            {name:'CRPER_FECHA_ARCHIVO'},
            {name:'CRPEX_MOVIMIENTO'},
            {name:'CRPEX_FECHA_OPERACION'}


        ]),
        sortInfo:{field: 'CRPER_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_prestamo_expediente.
     */
    var pgBarCgg_res_prestamo_persona= new Ext.PagingToolbar({
        store: gsCgg_res_prestamo_persona,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_prestamo_expediente en un formato tabular de filas y columnas.
     */
    var grdCgg_res_prestamo_expediente = new Ext.grid.GridPanel({
        cm:cmCgg_res_prestamo_persona,
        store:gsCgg_res_prestamo_persona,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_prestamo_persona,
                width:200
            })
        ],
        bbar:pgBarCgg_res_prestamo_persona,
        plugins: expanderPrestamo,
        animCollapse: false});
    gsCgg_res_prestamo_persona.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });

     var winFrmListadoCgg_res_prestamo_expediente = null;


     if (inDesktop!== null && inDesktop!==undefined) {
        winFrmListadoCgg_res_prestamo_expediente = inDesktop.createWindow({
        id:'winFrmListadoCgg_res_prestamo_expediente',
        title:tituloListadoCgg_res_prestamo_expediente,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('  '+tituloListadoCgg_res_prestamo_expediente,descListadoCgg_res_prestamo_expediente),
        items:[grdCgg_res_prestamo_expediente],
        bbar:[btnNuevoCgg_res_prestamo_expediente,btnNuevoCgg_res_historial_movimiento,'->',btnSalirCgg_res_prestamo_expediente]

    });


          applyGrants(winFrmListadoCgg_res_prestamo_expediente.getBottomToolbar());
    }
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_prestamo_expediente.
     */

    /**
     * Funcion que aplica los privilegios del usuario.
     */

    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_prestamo_expediente.
     * @returns ventana winFrmCgg_res_prestamo_expediente.
     * @base FrmListadoCgg_res_prestamo_expediente.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_prestamo_expediente;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_prestamo_expediente.
     * @base FrmListadoCgg_res_prestamo_expediente.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_prestamo_persona.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_prestamo_persona;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_prestamo_persona;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_prestamo_expediente.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_prestamo_expediente.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_prestamo_expediente desde una instancia.
 */
FrmListadoCgg_res_prestamo_expediente.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_prestamo_expediente desde una instancia.
 */
FrmListadoCgg_res_prestamo_expediente.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_prestamo_expediente,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_prestamo_expediente.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_prestamo_expediente desde una instancia.
 */
FrmListadoCgg_res_prestamo_expediente.prototype.loadData = function(){
    this.loadData();
}
