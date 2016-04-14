/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_kardex.
 * @param {String} IN_SENTENCIA_CGG_KDX_KARDEX Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_KDX_KARDEX Registro de datos de la tabla Cgg_kdx_kardex.
 * @constructor
 * @base FrmListadoCgg_kdx_kardex
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_kdx_kardex(IN_SENTENCIA_CGG_KDX_KARDEX,IN_RECORD_CGG_KDX_KARDEX){
    var inSentenciaCgg_kdx_kardex = IN_SENTENCIA_CGG_KDX_KARDEX;
    var inRecordCgg_kdx_kardex=IN_RECORD_CGG_KDX_KARDEX;
    var urlCgg_kdx_kardex=URL_WS+"Cgg_kdx_kardex";
    var tituloCgg_kdx_kardex='Inventario inicial';
    var descCgg_kdx_kardex='El formulario permite administrar la informaci\u00f3n de la Inventario inicial';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DEL KARDEX
     */
    var txtCkkrd_codigo = new Ext.form.TextField({
        id:'txtCkkrd_codigo',
        name:'txtCkkrd_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE
     */
    var txtCkesp_codigo = new Ext.form.TextField({
        id:'txtCkesp_codigo',
        name:'txtCkesp_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE
     */
    var txtCkesp_nombre = new Ext.form.TextField({
        id:'txtCkesp_nombre',
        name:'txtCkesp_nombre',
        fieldLabel :'Tipo especie',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE LA ESPECIE
     */
    var btnCkesp_codigoCgg_kdx_kardex = new Ext.Button({
        id:'btnCkesp_codigoCgg_kdx_kardex',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_kdx_especie = new FrmListadoCgg_kdx_especie();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_especie.getStore(),tmpFLCgg_kdx_especie.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        try
                        {

                            var param = new SOAPClientParameters();
                            param.add('inCkesp_codigo',tmpRecord.get('CKESP_CODIGO'));
                            var  r =   SOAPClient.invoke(urlCgg_kdx_kardex,'verificaInventarioInicial',param, false, false);
                            if(r.toUpperCase() == 'TRUE' )
                            {
                                Ext.Msg.show({
                                    title:tituloCgg_kdx_kardex,
                                    msg: 'El tipo de especie seleccionada '+ tmpRecord.get('CKESP_NOMBRE') +' ya tiene registrado su inventario inicial. ',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                                txtCkesp_codigo.reset();
                                txtCkesp_nombre.reset();
                                numCkkrd_total_pu.reset();
                            }
                            else
                            {
                                txtCkesp_codigo.setValue(tmpRecord.get('CKESP_CODIGO'));
                                txtCkesp_nombre.setValue(tmpRecord.get('CKESP_NOMBRE'));
                                numCkkrd_total_pu.setValue(tmpRecord.get('CKESP_PRECIO'));
                            }
                        }
                        catch(Exception)
                        {
                             txtCkesp_codigo.setValue(tmpRecord.get('CKESP_CODIGO'));
                             txtCkesp_nombre.setValue(tmpRecord.get('CKESP_NOMBRE'));
                             numCkkrd_total_pu.setValue(tmpRecord.get('CKESP_PRECIO'));
                        }


                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.NumberField NUMERO DEL MOVIMIENTO
     */
    var numCkkrd_numero = new Ext.form.NumberField({
        id:'numCkkrd_numero',
        name:'numCkkrd_numero',
        fieldLabel :'Numero',
        allowBlank :true,
        readOnly : true,
        value : 1
    });
    /**
     * Ext.form.TextField DETALLE DEL MOVIMIENTO
     */
    var txtCkkrd_detalle = new Ext.form.TextField({
        id:'txtCkkrd_detalle',
        name:'txtCkkrd_detalle',
        fieldLabel :'Detalle',
        anchor:'98%',
        allowBlank :false,
        value:'INVENTARIO INICIAL'
    });
    /**
     * Ext.form.DateField FECHA DE REGISTRO DE MOVIMIENTO
     */
    var dtCkkrd_fecha_registro = new Ext.form.DateField({
        id:'dtCkkrd_fecha_registro',
        name:'dtCkkrd_fecha_registro',
        fieldLabel :'Fecha registro',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    /**
     * Ext.form.NumberField TIPO DE MOVIMIENTO:
     0 .- INVENTARIO INICIAL
     1.-  INGRESO
     2.-  SALIDA

     */

    var numCkkrd_tipo_movimiento = new Ext.form.NumberField({
        id:'numCkkrd_tipo_movimiento',
        name:'numCkkrd_tipo_movimiento',
        fieldLabel :'Tipo movimiento',
        allowBlank :false,
        disabled :false,
        value:TypeMovimientoKardek.INVENTARIO_INICIAL
    });
    /**
     * Ext.form.NumberField TIPO DE OPERACION:
     0.- COMPRA
     1.- VENTA
     2.- ANULACION
     3.- DEVOLUCION
     4.- OTRAS
     */
    var numCkkrd_tipo_operacion = new Ext.form.NumberField({
        id:'numCkkrd_tipo_operacion',
        name:'numCkkrd_tipo_operacion',
        fieldLabel :'Tipo operacion',
        allowBlank :false,
        disabled :false,
        value:TypeOperacionKardex.OTRAS
    });
    /**
     * Ext.form.NumberField CANTIDAD DE ESPECIES QUE INGRESARON
     */
    var numCkkrd_ingreso_cantidad = new Ext.form.NumberField({
        id:'numCkkrd_ingreso_cantidad',
        name:'numCkkrd_ingreso_cantidad',
        fieldLabel :'Ingreso cantidad',
        disabled :false
    });
    /**
     * Ext.form.NumberField PRECIO UNITARIO DE COMPRA
     */
    var numCkkrd_ingreso_pu = new Ext.form.NumberField({
        id:'numCkkrd_ingreso_pu',
        name:'numCkkrd_ingreso_pu',
        fieldLabel :'Ingreso pu',
        disabled :false
    });
    /**
     * Ext.form.NumberField TOTAL CONTABLE DE INGRESO
     */
    var numCkkrd_ingreso_total = new Ext.form.NumberField({
        id:'numCkkrd_ingreso_total',
        name:'numCkkrd_ingreso_total',
        fieldLabel :'Ingreso total',
        disabled :false
    });
    /**
     * Ext.form.NumberField CANTIDAD DE ESPECIES ENTREGADAS
     */
    var numCkkrd_salida_cantidad = new Ext.form.NumberField({
        id:'numCkkrd_salida_cantidad',
        name:'numCkkrd_salida_cantidad',
        fieldLabel :'Salida cantidad',
        disabled :false
    });
    /**
     * Ext.form.NumberField PRECIO UNITARIO DE VENTA
     */
    var numCkkrd_salida_pu = new Ext.form.NumberField({
        id:'numCkkrd_salida_pu',
        name:'numCkkrd_salida_pu',
        fieldLabel :'Salida pu',
        disabled :false
    });
    /**
     * Ext.form.NumberField TOTAL CONTABLE DE VENTA
     */
    var numCkkrd_salida_total = new Ext.form.NumberField({
        id:'numCkkrd_salida_total',
        name:'numCkkrd_salida_total',
        fieldLabel :'Salida total',
        disabled :false
    });
    /**
     * Ext.form.NumberField CANTIDAD TOTAL
     */
    var numCkkrd_total_cantidad = new Ext.form.NumberField({
        id:'numCkkrd_total_cantidad',
        name:'numCkkrd_total_cantidad',
        fieldLabel :'Cantidad',
        allowBlank :false,
        disabled :false,
        value:0,
        listeners:{
            change:function()
            {
                numCkkrd_total_total.setValue(numCkkrd_total_cantidad.getValue()*numCkkrd_total_pu.getValue());
            }
        }
    });
    /**
     * Ext.form.NumberField PRECIO UNITARIO
     */
    var numCkkrd_total_pu = new Ext.form.NumberField({
        id:'numCkkrd_total_pu',
        name:'numCkkrd_total_pu',
        fieldLabel :'Precio Unitario',
        allowBlank :false,
        disabled : true,
        value:0
    });
    /**
     * Ext.form.NumberField TOTAL CONTABLE
     */
    var numCkkrd_total_total = new Ext.form.NumberField({
        id:'numCkkrd_total_total',
        name:'numCkkrd_total_total',
        fieldLabel :'Total',
        allowBlank :false,
        disabled : true,
        value:0
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_kardex
     */
    var btnGuardarCgg_kdx_kardex = new Ext.Button({
        id:'btnGuardarCgg_kdx_kardex',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_kdx_kardex.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_kdx_kardex(r){
                        winFrmCgg_kdx_kardex.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_kdx_kardex,
                                msg: 'La informaci\u00f3n de Inventario inicial ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_kdx_kardex.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_kdx_kardex,
                                msg: 'La informaci\u00f3n de Inventario inicial no ha podido ser almacenada. '+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_kdx_kardex.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCkkrd_codigo',txtCkkrd_codigo.getValue());
                    param.add('inCkesp_codigo',txtCkesp_codigo.getValue());
                    param.add('inCkkrd_numero',numCkkrd_numero.getValue());
                    param.add('inCkkrd_detalle',txtCkkrd_detalle.getValue());
                    param.add('inCkkrd_fecha_registro',dtCkkrd_fecha_registro.getValue().format('c'));
                    param.add('inCkkrd_tipo_movimiento',numCkkrd_tipo_movimiento.getValue());
                    param.add('inCkkrd_tipo_operacion',numCkkrd_tipo_operacion.getValue());
                    param.add('inCkkrd_ingreso_cantidad',numCkkrd_ingreso_cantidad.getValue()?numCkkrd_ingreso_cantidad.getValue():0);
                    param.add('inCkkrd_ingreso_pu',numCkkrd_ingreso_pu.getValue()?numCkkrd_ingreso_pu.getValue():0);
                    param.add('inCkkrd_ingreso_total',numCkkrd_ingreso_total.getValue()?numCkkrd_ingreso_total.getValue():0);
                    param.add('inCkkrd_salida_cantidad',numCkkrd_salida_cantidad.getValue()?numCkkrd_salida_cantidad.getValue():0);
                    param.add('inCkkrd_salida_pu',numCkkrd_salida_pu.getValue()?numCkkrd_salida_pu.getValue():0);
                    param.add('inCkkrd_salida_total',numCkkrd_salida_total.getValue()?numCkkrd_salida_total.getValue():0);
                    param.add('inCkkrd_total_cantidad',numCkkrd_total_cantidad.getValue());
                    param.add('inCkkrd_total_pu',numCkkrd_total_pu.getValue());
                    param.add('inCkkrd_total_total',numCkkrd_total_total.getValue());
                    SOAPClient.invoke(urlCgg_kdx_kardex,IN_SENTENCIA_CGG_KDX_KARDEX,param, true, CallBackCgg_kdx_kardex);
                }catch(inErr){
                    winFrmCgg_kdx_kardex.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_kardex.
     */
    var btnCancelarCgg_kdx_kardex = new Ext.Button({
        id:'btnCancelarCgg_kdx_kardex',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_kdx_kardex.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_kdx_kardex.
     */
    var btnCerrarCgg_kdx_kardex = new Ext.Button({
        id:'btnCerrarCgg_kdx_kardex',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_kdx_kardex.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_kardex.
     */
    var pnlCgg_kdx_kardex = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCkkrd_codigo,
            {
                xtype:'panel',layout:'column',items:[
                {columnWidth:.6,layout:'form',items:[txtCkesp_nombre]},{columnWidth:.4,layout:'form',items:[btnCkesp_codigoCgg_kdx_kardex]}]
            },numCkkrd_numero,txtCkkrd_detalle,numCkkrd_total_cantidad,numCkkrd_total_pu,numCkkrd_total_total]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_kardex.
     */
    var winFrmCgg_kdx_kardex = new Ext.Window({
        id:'winFrmCgg_kdx_kardex',
        title:tituloCgg_kdx_kardex,
        width:400,
        minWidth:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_kdx_kardex,descCgg_kdx_kardex),
        items:[pnlCgg_kdx_kardex],
        bbar:[btnGuardarCgg_kdx_kardex,btnCancelarCgg_kdx_kardex,'->',btnCerrarCgg_kdx_kardex]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_kdx_kardex.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_kdx_kardexCtrls(inEstado){
        var estado=!inEstado;
        txtCkkrd_codigo.setDisabled(estado);
        txtCkesp_nombre.setDisabled(estado);
        numCkkrd_numero.setDisabled(estado);
        txtCkkrd_detalle.setDisabled(estado);
        numCkkrd_ingreso_cantidad.setDisabled(estado);
        numCkkrd_ingreso_pu.setDisabled(estado);
        numCkkrd_ingreso_total.setDisabled(estado);
        numCkkrd_salida_cantidad.setDisabled(estado);
        numCkkrd_salida_pu.setDisabled(estado);
        numCkkrd_salida_total.setDisabled(estado);
        numCkkrd_total_cantidad.setDisabled(estado);
        btnCkesp_codigoCgg_kdx_kardex.setVisible(false);
        btnGuardarCgg_kdx_kardex.setDisabled(true);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_kardex.
     */
    function cargarCgg_kdx_kardexCtrls(){
        if(inRecordCgg_kdx_kardex){
            txtCkkrd_codigo.setValue(inRecordCgg_kdx_kardex.get('CKKRD_CODIGO'));
            txtCkesp_codigo.setValue(inRecordCgg_kdx_kardex.get('CKESP_CODIGO'));
            txtCkesp_nombre.setValue(inRecordCgg_kdx_kardex.get('CKESP_NOMBRE'));
            numCkkrd_numero.setValue(inRecordCgg_kdx_kardex.get('CKKRD_NUMERO'));
            txtCkkrd_detalle.setValue(inRecordCgg_kdx_kardex.get('CKKRD_DETALLE'));
            dtCkkrd_fecha_registro.setValue(truncDate(inRecordCgg_kdx_kardex.get('CKKRD_FECHA_REGISTRO')));
            numCkkrd_tipo_movimiento.setValue(inRecordCgg_kdx_kardex.get('CKKRD_TIPO_MOVIMIENTO'));
            numCkkrd_tipo_operacion.setValue(inRecordCgg_kdx_kardex.get('CKKRD_TIPO_OPERACION'));
            numCkkrd_ingreso_cantidad.setValue(inRecordCgg_kdx_kardex.get('CKKRD_INGRESO_CANTIDAD'));
            numCkkrd_ingreso_pu.setValue(inRecordCgg_kdx_kardex.get('CKKRD_INGRESO_PU'));
            numCkkrd_ingreso_total.setValue(inRecordCgg_kdx_kardex.get('CKKRD_INGRESO_TOTAL'));
            numCkkrd_salida_cantidad.setValue(inRecordCgg_kdx_kardex.get('CKKRD_SALIDA_CANTIDAD'));
            numCkkrd_salida_pu.setValue(inRecordCgg_kdx_kardex.get('CKKRD_SALIDA_PU'));
            numCkkrd_salida_total.setValue(inRecordCgg_kdx_kardex.get('CKKRD_SALIDA_TOTAL'));
            numCkkrd_total_cantidad.setValue(inRecordCgg_kdx_kardex.get('CKKRD_TOTAL_CANTIDAD'));
            numCkkrd_total_pu.setValue(inRecordCgg_kdx_kardex.get('CKKRD_TOTAL_PU'));
            numCkkrd_total_total.setValue(inRecordCgg_kdx_kardex.get('CKKRD_TOTAL_TOTAL'));
            isEdit = true;
            habilitarCgg_kdx_kardexCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_kdx_kardex.
     * @returns ventana winFrmCgg_kdx_kardex.
     * @base FrmCgg_kdx_kardex.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_kdx_kardex;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_kardex.
     * @base FrmCgg_kdx_kardex.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_kdx_kardexCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_kardex desde una instancia.
 */
FrmCgg_kdx_kardex.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_kardex desde una instancia.
 */
FrmCgg_kdx_kardex.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_kardex,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_kdx_kardex.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_kardex desde una instancia.
 */
FrmCgg_kdx_kardex.prototype.loadData = function(){
    this.loadData();
}
