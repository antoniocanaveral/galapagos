/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_denominacion.
 * @param {String} IN_SENTENCIA_CGG_KDX_DENOMINACION Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_KDX_DENOMINACION Registro de datos de la tabla Cgg_kdx_denominacion.
 * @constructor
 * @base FrmListadoCgg_kdx_denominacion
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_kdx_denominacion(IN_SENTENCIA_CGG_KDX_DENOMINACION,IN_RECORD_CGG_KDX_DENOMINACION){    
    var inSentenciaCgg_kdx_denominacion = IN_SENTENCIA_CGG_KDX_DENOMINACION;
    var inRecordCgg_kdx_denominacion=IN_RECORD_CGG_KDX_DENOMINACION;
    var urlCgg_kdx_denominacion=URL_WS+"Cgg_kdx_denominacion";
    var tituloCgg_kdx_denominacion='Denominaci\u00f3n monetaria';
    var descCgg_kdx_denominacion='El formulario permite administrar la informaci\u00f3n de Denominaci\u00f3n monetaria';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE LA DENOMINACION
     */
    var txtCkdnm_codigo = new Ext.form.TextField({
        id:'txtCkdnm_codigo',
        name:'txtCkdnm_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PAGO
     */
    var txtCktpg_codigo = new Ext.form.TextField({
        id:'txtCktpg_codigo',
        name:'txtCktpg_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PAGO
     */
    var txtCktpg_descripcion = new Ext.form.TextField({
        id:'txtCktpg_descripcion',
        name:'txtCktpg_descripcion',
        fieldLabel :'Tipo pago',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PAGO
     */
    var btnCktpg_codigoCgg_kdx_denominacion = new Ext.Button({
        id:'btnCktpg_codigoCgg_kdx_denominacion',
        iconCls:'iconBuscar',
        tooltip:TypeTooltip.BUSCAR + 'tipo pago',
        listeners:{
            click:function(){
                var tmpFLCgg_kdx_tipo_pago = new FrmListadoCgg_kdx_tipo_pago();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_tipo_pago.getStore(),tmpFLCgg_kdx_tipo_pago.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        txtCktpg_codigo.setValue(tmpRecord.get('CKTPG_CODIGO'));
                        txtCktpg_descripcion.setValue(tmpRecord.get('CKTPG_DESCRIPCION'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField NOMBRE DE LA DENOMINACION MONETARIA
     */
    var txtCkdnm_denominacion = new Ext.form.TextField({
        id:'txtCkdnm_denominacion',
        name:'txtCkdnm_denominacion',
        fieldLabel :'Denominacion',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.TextArea INFORMACION ADICIONAL
     */
    var txtCkdnm_observacion = new Ext.form.TextArea({
        id:'txtCkdnm_observacion',
        name:'txtCkdnm_observacion',
        fieldLabel :'Observacion',
        width:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.NumberField VALOR MONETARIO QUE REPRESENTA LA DENOMINACION
     */
    
        var spfCkdnm_valor_monetario = new Ext.ux.form.SpinnerField({
            id:'spfCkdnm_valor_monetario',
            name:'spfCkdnm_valor_monetario',
            fieldLabel :'Valor monetario',
            anchor:'50%',
            allowBlank :false,
            disabled :false,
            value:'1',
            minValue: 0,
            maxValue: 100,
            allowDecimals: true,
            allowNegative: false,
            decimalPrecision: 2,
            incrementValue: 0.01,
            alternateIncrementValue: 1,
            accelerate: true
        });

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_denominacion
     */
    var btnGuardarCgg_kdx_denominacion = new Ext.Button({
        id:'btnGuardarCgg_kdx_denominacion',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_kdx_denominacion.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_kdx_denominacion(r){
                        winFrmCgg_kdx_denominacion.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_kdx_denominacion,
                                msg: 'La informaci\u00f3n de Denominaci\u00f3n monetaria ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_kdx_denominacion.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_kdx_denominacion,
                                msg: 'La informaci\u00f3n de Denominaci\u00f3n monetaria no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_kdx_denominacion.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCkdnm_codigo',txtCkdnm_codigo.getValue());
                    param.add('inCktpg_codigo',txtCktpg_codigo.getValue());
                    param.add('inCkdnm_denominacion',txtCkdnm_denominacion.getValue());
                    param.add('inCkdnm_observacion',txtCkdnm_observacion.getValue());
                    param.add('inCkdnm_valor_monetario',spfCkdnm_valor_monetario.getValue());
                    SOAPClient.invoke(urlCgg_kdx_denominacion,IN_SENTENCIA_CGG_KDX_DENOMINACION,param, true, CallBackCgg_kdx_denominacion);
                }catch(inErr){
                    winFrmCgg_kdx_denominacion.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_denominacion.
     */
    var btnCancelarCgg_kdx_denominacion = new Ext.Button({
        id:'btnCancelarCgg_kdx_denominacion',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_kdx_denominacion.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_kdx_denominacion.
     */
    var btnCerrarCgg_kdx_denominacion = new Ext.Button({
        id:'btnCerrarCgg_kdx_denominacion',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_kdx_denominacion.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_denominacion.
     */
    var pnlCgg_kdx_denominacion = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCkdnm_codigo,
            {
                xtype:'panel',layout:'column',items:
                    [
                        {columnWidth:.6,layout:'form',items:[txtCktpg_descripcion]},
                        {columnWidth:.4,layout:'form',items:[btnCktpg_codigoCgg_kdx_denominacion]}
                    ]
            },
            txtCkdnm_denominacion,spfCkdnm_valor_monetario,txtCkdnm_observacion
            ]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_denominacion.
     */
    var winFrmCgg_kdx_denominacion = new Ext.Window({
        id:'winFrmCgg_kdx_denominacion',
        title:tituloCgg_kdx_denominacion,
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        modal:true,
        resizable:false,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_kdx_denominacion,descCgg_kdx_denominacion),
        items:[pnlCgg_kdx_denominacion],
        bbar:[btnGuardarCgg_kdx_denominacion,btnCancelarCgg_kdx_denominacion,'->',btnCerrarCgg_kdx_denominacion]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_kdx_denominacion.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_kdx_denominacionCtrls(inEstado){
        estado=!inEstado;
        txtCkdnm_codigo.setDisabled(estado);
        txtCktpg_codigo.setDisabled(estado);
        txtCkdnm_denominacion.setDisabled(estado);
        txtCkdnm_observacion.setDisabled(estado);
        spfCkdnm_valor_monetario.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_denominacion.
     */
    function cargarCgg_kdx_denominacionCtrls(){
        if(inRecordCgg_kdx_denominacion){
            txtCkdnm_codigo.setValue(inRecordCgg_kdx_denominacion.get('CKDNM_CODIGO'));
            txtCktpg_codigo.setValue(inRecordCgg_kdx_denominacion.get('CKTPG_CODIGO'));
            txtCkdnm_denominacion.setValue(inRecordCgg_kdx_denominacion.get('CKDNM_DENOMINACION'));
            txtCkdnm_observacion.setValue(inRecordCgg_kdx_denominacion.get('CKDNM_OBSERVACION'));
            spfCkdnm_valor_monetario.setValue(inRecordCgg_kdx_denominacion.get('CKDNM_VALOR_MONETARIO'));
            isEdit = true;
            habilitarCgg_kdx_denominacionCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_kdx_denominacion.
     * @returns ventana winFrmCgg_kdx_denominacion.
     * @base FrmCgg_kdx_denominacion.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_kdx_denominacion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_denominacion.
     * @base FrmCgg_kdx_denominacion.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_kdx_denominacionCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_denominacion desde una instancia.
 */
FrmCgg_kdx_denominacion.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_denominacion desde una instancia.
 */
FrmCgg_kdx_denominacion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_denominacion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_kdx_denominacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_denominacion desde una instancia.
 */
FrmCgg_kdx_denominacion.prototype.loadData = function(){
    this.loadData();
}
