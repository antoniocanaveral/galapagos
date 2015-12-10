/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_tipo_pago.
 * @param {String} IN_SENTENCIA_CGG_KDX_TIPO_PAGO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_KDX_TIPO_PAGO Registro de datos de la tabla Cgg_kdx_tipo_pago.
 * @constructor
 * @base FrmListadoCgg_kdx_tipo_pago
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_kdx_tipo_pago(IN_SENTENCIA_CGG_KDX_TIPO_PAGO,IN_RECORD_CGG_KDX_TIPO_PAGO){
    var inSentenciaCgg_kdx_tipo_pago = IN_SENTENCIA_CGG_KDX_TIPO_PAGO;
    var inRecordCgg_kdx_tipo_pago=IN_RECORD_CGG_KDX_TIPO_PAGO;
    var urlCgg_kdx_tipo_pago=URL_WS+"Cgg_kdx_tipo_pago";
    var tituloCgg_kdx_tipo_pago='Tipo pago';
    var descCgg_kdx_tipo_pago='El formulario permite administrar la informaci\u00f3n de la Tipo pago';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PAGO
     */
    var txtCktpg_codigo = new Ext.form.TextField({
        id:'txtCktpg_codigo',
        name:'txtCktpg_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField NOMBRE DEL TIPO DE PAGO
     */
    var txtCktpg_descripcion = new Ext.form.TextField({
        id:'txtCktpg_descripcion',
        name:'txtCktpg_descripcion',
        fieldLabel :'Descripcion',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.TextArea INFORMACION ADICIONAL
     */
    var txtCktpg_observacion = new Ext.form.TextArea({
        id:'txtCktpg_observacion',
        name:'txtCktpg_observacion',
        fieldLabel :'Observaci\u00f3n',
        width:'98%',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_tipo_pago
     */
    var btnGuardarCgg_kdx_tipo_pago = new Ext.Button({
        id:'btnGuardarCgg_kdx_tipo_pago',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_kdx_tipo_pago.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_kdx_tipo_pago(r){
                        winFrmCgg_kdx_tipo_pago.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_kdx_tipo_pago,
                                msg: 'La informaci\u00f3n de Tipo pago ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_kdx_tipo_pago.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_kdx_tipo_pago,
                                msg: 'La informaci\u00f3n de Tipo pago no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_kdx_tipo_pago.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCktpg_codigo',txtCktpg_codigo.getValue());
                    param.add('inCktpg_descripcion',txtCktpg_descripcion.getValue());
                    param.add('inCktpg_observacion',txtCktpg_observacion.getValue());
                    SOAPClient.invoke(urlCgg_kdx_tipo_pago,IN_SENTENCIA_CGG_KDX_TIPO_PAGO,param, true, CallBackCgg_kdx_tipo_pago);
                }catch(inErr){
                    winFrmCgg_kdx_tipo_pago.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_tipo_pago.
     */
    var btnCancelarCgg_kdx_tipo_pago = new Ext.Button({
        id:'btnCancelarCgg_kdx_tipo_pago',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_kdx_tipo_pago.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_kdx_tipo_pago.
     */
    var btnCerrarCgg_kdx_tipo_pago = new Ext.Button({
        id:'btnCerrarCgg_kdx_tipo_pago',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_kdx_tipo_pago.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_tipo_pago.
     */
    var pnlCgg_kdx_tipo_pago = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCktpg_codigo,txtCktpg_descripcion,txtCktpg_observacion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_tipo_pago.
     */
    var winFrmCgg_kdx_tipo_pago = new Ext.Window({
        id:'winFrmCgg_kdx_tipo_pago',
        title:tituloCgg_kdx_tipo_pago,
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        modal:true,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_kdx_tipo_pago,descCgg_kdx_tipo_pago),
        items:[pnlCgg_kdx_tipo_pago],
        bbar:[btnGuardarCgg_kdx_tipo_pago,btnCancelarCgg_kdx_tipo_pago,'->',btnCerrarCgg_kdx_tipo_pago]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_kdx_tipo_pago.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_kdx_tipo_pagoCtrls(inEstado){
        estado=!inEstado;
        txtCktpg_codigo.setDisabled(estado);
        txtCktpg_descripcion.setDisabled(estado);
        txtCktpg_observacion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_tipo_pago.
     */
    function cargarCgg_kdx_tipo_pagoCtrls(){
        if(inRecordCgg_kdx_tipo_pago){
            txtCktpg_codigo.setValue(inRecordCgg_kdx_tipo_pago.get('CKTPG_CODIGO'));
            txtCktpg_descripcion.setValue(inRecordCgg_kdx_tipo_pago.get('CKTPG_DESCRIPCION'));
            txtCktpg_observacion.setValue(inRecordCgg_kdx_tipo_pago.get('CKTPG_OBSERVACION'));
            isEdit = true;
            habilitarCgg_kdx_tipo_pagoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_kdx_tipo_pago.
     * @returns ventana winFrmCgg_kdx_tipo_pago.
     * @base FrmCgg_kdx_tipo_pago.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_kdx_tipo_pago;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_tipo_pago.
     * @base FrmCgg_kdx_tipo_pago.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_kdx_tipo_pagoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_tipo_pago desde una instancia.
 */
FrmCgg_kdx_tipo_pago.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_tipo_pago desde una instancia.
 */
FrmCgg_kdx_tipo_pago.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_tipo_pago,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_kdx_tipo_pago.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_tipo_pago desde una instancia.
 */
FrmCgg_kdx_tipo_pago.prototype.loadData = function(){
    this.loadData();
}
