/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_venta.
 * @param {String} IN_SENTENCIA_CGG_KDX_VENTA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_KDX_VENTA Registro de datos de la tabla Cgg_kdx_venta.
 * @constructor
 * @base FrmListadoCgg_kdx_venta
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_kdx_venta(IN_SENTENCIA_CGG_KDX_VENTA,IN_RECORD_CGG_KDX_VENTA){   
    var inSentenciaCgg_kdx_venta = IN_SENTENCIA_CGG_KDX_VENTA;
    var inRecordCgg_kdx_venta=IN_RECORD_CGG_KDX_VENTA;
    var urlCgg_kdx_venta=URL_WS+"Cgg_kdx_venta";
    var tituloCgg_kdx_venta='Venta TCT';
    var descCgg_kdx_venta='El formulario permite administrar la informaci\u00f3n de la tabla Venta TCT';
    var isEdit = false;
    var tmpTotalVendidas = 1 ;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE  VENTA
     */
    var txtCkvnt_codigo = new Ext.form.TextField({
        id:'txtCkvnt_codigo',
        name:'txtCkvnt_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
     */
    var txtCkasg_codigo = new Ext.form.TextField({
        id:'txtCkasg_codigo',
        name:'txtCkasg_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE ASIGNACION
     */
    var btnCkasg_codigoCgg_kdx_venta = new Ext.Button({
        id:'btnCkasg_codigoCgg_kdx_venta',
        text:'Ckasg_codigo',
        iconCls:'iconCkasg_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_kdx_asignacion = new FrmListadoCgg_kdx_asignacion();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_asignacion.getStore(),tmpFLCgg_kdx_asignacion.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCkasg_codigo.setValue(tmpRecord.get('CKASG_CODIGO'));
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.NumberField LOTE AL QUE CORRESPONDE LA VENTA
     */
    var numCkvnt_lote = new Ext.form.NumberField({
        id:'numCkvnt_lote',
        name:'numCkvnt_lote',
        fieldLabel :'Lote',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.DateField FECHA DE INGRESO DE LAS ESPECIES
     */
    var dtCkvnt_fecha_ingreso = new Ext.form.DateField({
        id:'dtCkvnt_fecha_ingreso',
        name:'dtCkvnt_fecha_ingreso',
        fieldLabel :'Fecha ingreso',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    /**
     * Ext.form.TextField NUMERO SECUENCIAL UNICO DE IDENTIFICACION DE LA VENTA
     */
    var txtCkvnt_numero_venta = new Ext.form.TextField({
        id:'txtCkvnt_numero_venta',
        name:'txtCkvnt_numero_venta',
        fieldLabel :'Numero venta',
        anchor:'60%',
        allowBlank :false,
        readOnly:'true'
    });
    /**
     * Ext.form.NumberField SERIE DE INICIO DE ESPECIES
     */
    var numCkvnt_serie_inicio = new Ext.form.NumberField({
        id:'numCkvnt_serie_inicio',
        name:'numCkvnt_serie_inicio',
        fieldLabel :'Serie inicio',
        allowBlank :false,
        disabled :false,
        enableKeyEvents:true,
        listeners: {
            specialkey: function(field, e){
                if (e.getKey() == e.ENTER) {
                   numCkvnt_serie_fin.setValue(numCkvnt_serie_inicio.getValue()+tmpTotalVendidas-1);
                }
            },
             change:function(ctrl,newValue,oldValue){
                numCkvnt_serie_fin.setValue(numCkvnt_serie_inicio.getValue()+tmpTotalVendidas-1);
            }
        }
    });
    /**
     * Ext.form.NumberField SERIE DE FIN DE ESPECIES
     */
    var numCkvnt_serie_fin = new Ext.form.NumberField({
        id:'numCkvnt_serie_fin',
        name:'numCkvnt_serie_fin',
        fieldLabel :'Serie fin',
        allowBlank :false,
        disabled : true
    });
    /**
     * Ext.form.NumberField TOTAL DE ESPECIES DE LA FACTURA
     */
    var numCkvnt_cantidad = new Ext.form.NumberField({
        id:'numCkvnt_cantidad',
        name:'numCkvnt_cantidad',
        fieldLabel :'Cantidad',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.TextField TOTAL DE LA FACTURA
     */
    var txtCkvnt_total = new Ext.form.TextField({
        id:'txtCkvnt_total',
        name:'txtCkvnt_total',
        fieldLabel :'Total',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.NumberField ESTADO DEL REGISTRO DE VENTA UTILIZADO PARA OPERACIONES
     0.-  REGISTRADA
     1.-  CONTABILIZADA
     */
    var numCkvnt_estado_venta = new Ext.form.NumberField({
        id:'numCkvnt_estado_venta',
        name:'numCkvnt_estado_venta',
        fieldLabel :'Estado venta',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_venta_detalle.
     */
    var cmCgg_kdx_venta_detalle = new Ext.grid.ColumnModel([
        {dataIndex:'CKVDT_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKVNT_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKESP_CODIGO',header:'Especie',width:150,sortable:true,hidden:true},
        {dataIndex:'CKESP_NOMBRE',header:'Especie',width:150,sortable:true},
        {dataIndex:'CTREG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CKVDT_CANTIDAD',header:'Cantidad',width:150,sortable:true},
        {dataIndex:'CKVDT_SERIE',header:'Serie',width:150,sortable:true,hidden:true},
        {dataIndex:'CKVDT_PRECIO_UNITARIO',header:'Precio unitario',width:150,sortable:true},
        {dataIndex:'CKVDT_TOTAL',header:'Total',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_venta_detalle por un campo especifico.
     */
    var gsCgg_kdx_venta_detalle = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_venta_detalle",
            method:"selectGROUPBYVENTA",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {name:'CKVDT_CODIGO'},
            {name:'CKVNT_CODIGO'},
            {name:'CKESP_CODIGO'},
            {name:'CKESP_NOMBRE'},
            {name:'CTREG_CODIGO'},
            {name:'CKVDT_CANTIDAD'},
            {name:'CKVDT_SERIE'},
            {name:'CKVDT_PRECIO_UNITARIO'},
            {name:'CKVDT_TOTAL'}
        ]),
        //sortInfo:{field: 'CKVNT_CODIGO', direction: 'ASC'},
        baseParams:{inCkvnt_codigo:"",format:'JSON'},
        listeners:{
            load:function()
            {

                var tmpTotal  = gsCgg_kdx_venta_detalle.getTotalCount();
                grdCgg_kdx_venta_detalle.getSelectionModel().selectFirstRow();
                if (tmpTotal>0)
                {
                    tmpTotalVendidas = grdCgg_kdx_venta_detalle.getSelectionModel().getSelected().get('CKVDT_CANTIDAD');
                }
            }

        }
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_venta_detalle en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_venta_detalle = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_venta_detalle,
        store:gsCgg_kdx_venta_detalle,
        region:'center',
        anchor:'100% 100%',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        viewConfig:{forceFit:true}
    });


    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_venta
     */
    var btnGuardarCgg_kdx_venta = new Ext.Button({
        id:'btnGuardarCgg_kdx_venta',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (!pnlCgg_kdx_venta.getForm().isValid()){
                    return;
                }
                try{
                    function CallBackCgg_kdx_venta(r){
                        winFrmCgg_kdx_venta.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_kdx_venta,
                                msg: 'La informaci\u00f3n de Venta TCT ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_kdx_venta.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_kdx_venta,
                                msg: 'La informaci\u00f3n de Venta TCT no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_kdx_venta.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCkvnt_codigo',txtCkvnt_codigo.getValue());
                    param.add('inCkasg_codigo',txtCkasg_codigo.getValue());
                    param.add('inCkvnt_lote',numCkvnt_lote.getValue());
                    param.add('inCkvnt_fecha_ingreso',dtCkvnt_fecha_ingreso.getValue().format(TypeDateFormat.Custom));
                    param.add('inCkvnt_numero_venta',txtCkvnt_numero_venta.getValue());
                    param.add('inCkvnt_serie_inicio',numCkvnt_serie_inicio.getValue());
                    param.add('inCkvnt_serie_fin',numCkvnt_serie_fin.getValue());
                    param.add('inCkvnt_cantidad',numCkvnt_cantidad.getValue());
                    param.add('inCkvnt_total',txtCkvnt_total.getValue());
                    param.add('inCkvnt_estado_venta',TypeEstadoVenta.CONFIRMADA);
                    SOAPClient.invoke(urlCgg_kdx_venta,IN_SENTENCIA_CGG_KDX_VENTA,param, true, CallBackCgg_kdx_venta);
                }catch(inErr){
                    winFrmCgg_kdx_venta.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_venta.
     */
    var btnCancelarCgg_kdx_venta = new Ext.Button({
        id:'btnCancelarCgg_kdx_venta',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_kdx_venta.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_kdx_venta.
     */
    var btnCerrarCgg_kdx_venta = new Ext.Button({
        id:'btnCerrarCgg_kdx_venta',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_kdx_venta.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_venta.
     */
    var pnlCgg_kdx_venta_detalle = new Ext.form.FormPanel({
        frame:false,
        labelWidth :100,
        region:'center',
        border:'layout',
        items:[grdCgg_kdx_venta_detalle]
    });

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_venta.
     */
    var pnlCgg_kdx_venta = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        height:130,
        region:'north',
        layout:'form',
        items:[txtCkvnt_codigo,
            txtCkvnt_numero_venta,dtCkvnt_fecha_ingreso,numCkvnt_serie_inicio,numCkvnt_serie_fin]//,numCkvnt_cantidad,txtCkvnt_total,numCkvnt_estado_venta]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_venta.
     */
    var winFrmCgg_kdx_venta = new Ext.Window({
        id:'winFrmCgg_kdx_venta',
        title:tituloCgg_kdx_venta,
        iconCls:'iconAplicacion',
        layout:'border',
        width:500,
        minWidth:500,
        height:400,
        miHeight:350,
        maximizable:true,
        minimizable:false,
        modal:true,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_kdx_venta,descCgg_kdx_venta),
        items:[pnlCgg_kdx_venta,pnlCgg_kdx_venta_detalle],
        bbar:[btnGuardarCgg_kdx_venta,btnCancelarCgg_kdx_venta,'->',btnCerrarCgg_kdx_venta]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_kdx_venta.getBottomToolbar());
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_kdx_venta.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_kdx_ventaCtrls(inEstado){
        estado=!inEstado;
        txtCkvnt_codigo.setDisabled(estado);
        txtCkasg_codigo.setDisabled(estado);
        numCkvnt_lote.setDisabled(estado);
        dtCkvnt_fecha_ingreso.setDisabled(estado);
        txtCkvnt_numero_venta.setDisabled(estado);
        numCkvnt_serie_inicio.setDisabled(estado);
        numCkvnt_serie_fin.setDisabled(estado);
        numCkvnt_cantidad.setDisabled(estado);
        txtCkvnt_total.setDisabled(estado);
        numCkvnt_estado_venta.setDisabled(estado);
        if( numCkvnt_estado_venta.getValue() ==  TypeEstadoVenta.CONTABILIZADA)
        {
            btnGuardarCgg_kdx_venta.setDisabled(true);
        }
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_venta.
     */
    function cargarCgg_kdx_ventaCtrls(){
        if(inRecordCgg_kdx_venta){
            txtCkvnt_codigo.setValue(inRecordCgg_kdx_venta.get('CKVNT_CODIGO'));
            txtCkasg_codigo.setValue(inRecordCgg_kdx_venta.get('CKASG_CODIGO'));
            numCkvnt_lote.setValue(inRecordCgg_kdx_venta.get('CKVNT_LOTE'));
            dtCkvnt_fecha_ingreso.setValue(inRecordCgg_kdx_venta.get('CKVNT_FECHA_INGRESO')?truncDate(inRecordCgg_kdx_venta.get('CKVNT_FECHA_INGRESO')):new Date());
            txtCkvnt_numero_venta.setValue(inRecordCgg_kdx_venta.get('CKVNT_NUMERO_VENTA'));
            numCkvnt_serie_inicio.setValue(inRecordCgg_kdx_venta.get('CKVNT_SERIE_INICIO'));
            numCkvnt_serie_fin.setValue(inRecordCgg_kdx_venta.get('CKVNT_SERIE_FIN'));
            numCkvnt_cantidad.setValue(inRecordCgg_kdx_venta.get('CKVNT_CANTIDAD'));
            txtCkvnt_total.setValue(inRecordCgg_kdx_venta.get('CKVNT_TOTAL'));
            numCkvnt_estado_venta.setValue(inRecordCgg_kdx_venta.get('CKVNT_ESTADO_VENTA'));
            isEdit = true;
            habilitarCgg_kdx_ventaCtrls(true);
            gsCgg_kdx_venta_detalle.reload({params:{
                inCkvnt_codigo:inRecordCgg_kdx_venta.get('CKVNT_CODIGO'),
                format:TypeFormat.JSON
            }
            });

        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_kdx_venta.
     * @returns ventana winFrmCgg_kdx_venta.
     * @base FrmCgg_kdx_venta.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_kdx_venta;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_venta.
     * @base FrmCgg_kdx_venta.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_kdx_ventaCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_venta desde una instancia.
 */
FrmCgg_kdx_venta.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_venta desde una instancia.
 */
FrmCgg_kdx_venta.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_venta,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_kdx_venta.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_venta desde una instancia.
 */
FrmCgg_kdx_venta.prototype.loadData = function(){
    this.loadData();
}
