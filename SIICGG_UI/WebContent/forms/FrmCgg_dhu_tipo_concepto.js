/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_tipo_concepto.
 * @param {String} INSENTENCIA_CGG_DHU_TIPO_CONCEPTO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_DHU_TIPO_CONCEPTO Registro de datos de la tabla Cgg_dhu_tipo_concepto.
 * @constructor
 * @base FrmListadoCgg_dhu_tipo_concepto
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_tipo_concepto(INSENTENCIA_CGG_DHU_TIPO_CONCEPTO,INRECORD_CGG_DHU_TIPO_CONCEPTO){
    var inSentenciaCgg_dhu_tipo_concepto = INSENTENCIA_CGG_DHU_TIPO_CONCEPTO;
    var inRecordCgg_dhu_tipo_concepto=INRECORD_CGG_DHU_TIPO_CONCEPTO;
    var urlCgg_dhu_tipo_concepto=URL_WS+"Cgg_dhu_tipo_concepto";
    var tituloCgg_dhu_tipo_concepto='Tipo concepto desembolso';
    var descCgg_dhu_tipo_concepto='El formulario permite administrar informaci\u00f3n del tipo concepto de desembolso';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CONCEPTO DE DESEMBOLSO
     */
    var txtCdtcp_codigo = new Ext.form.TextField({
        id:'txtCdtcp_codigo',
        name:'txtCdtcp_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField NOMBRE DEL CONCEPTO DE DESEMBOLSO
     */
    var txtCdtcp_nombre_desembolso = new Ext.form.TextField({
        id:'txtCdtcp_nombre_desembolso',
        name:'txtCdtcp_nombre_desembolso',
        fieldLabel :'Nombre desembolso',
        anchor:'98%',
        allowBlank :false,
        maxLength :20
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_tipo_concepto
     */
    var btnGuardarCgg_dhu_tipo_concepto = new Ext.Button({
        id:'btnGuardarCgg_dhu_tipo_concepto',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_dhu_tipo_concepto.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_dhu_tipo_concepto(r){
                        winFrmCgg_dhu_tipo_concepto.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_tipo_concepto,
                                msg: 'La informaci\u00f3n  ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_tipo_concepto.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_tipo_concepto,
                                msg: 'La informaci\u00f3n no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_tipo_concepto.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCdtcp_codigo',txtCdtcp_codigo.getValue());
                    param.add('inCdtcp_nombre_desembolso',txtCdtcp_nombre_desembolso.getValue());
                    SOAPClient.invoke(urlCgg_dhu_tipo_concepto,INSENTENCIA_CGG_DHU_TIPO_CONCEPTO,param, true, CallBackCgg_dhu_tipo_concepto);
                }catch(inErr){
                    winFrmCgg_dhu_tipo_concepto.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_tipo_concepto.
     */
    var btnCancelarCgg_dhu_tipo_concepto = new Ext.Button({
        id:'btnCancelarCgg_dhu_tipo_concepto',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_dhu_tipo_concepto.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_tipo_concepto.
     */
    var btnCerrarCgg_dhu_tipo_concepto = new Ext.Button({
        id:'btnCerrarCgg_dhu_tipo_concepto',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_dhu_tipo_concepto.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_tipo_concepto.
     */
    var pnlCgg_dhu_tipo_concepto = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCdtcp_codigo,txtCdtcp_nombre_desembolso]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_tipo_concepto.
     */
    var winFrmCgg_dhu_tipo_concepto = new Ext.Window({
        id:'winFrmCgg_dhu_tipo_concepto',
        title:tituloCgg_dhu_tipo_concepto,
        tbar:getPanelTitulo(tituloCgg_dhu_tipo_concepto,descCgg_dhu_tipo_concepto),
        items:[pnlCgg_dhu_tipo_concepto],
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
		modal : true,
		resizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_dhu_tipo_concepto,btnCancelarCgg_dhu_tipo_concepto,'->',btnCerrarCgg_dhu_tipo_concepto]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_tipo_concepto.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_tipo_conceptoCtrls(inEstado){
        estado=!inEstado;
        txtCdtcp_codigo.setDisabled(estado);
        txtCdtcp_nombre_desembolso.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_tipo_concepto.
     */
    function cargarCgg_dhu_tipo_conceptoCtrls(){
        if(inRecordCgg_dhu_tipo_concepto){
            txtCdtcp_codigo.setValue(inRecordCgg_dhu_tipo_concepto.get('CDTCP_CODIGO'));
            txtCdtcp_nombre_desembolso.setValue(inRecordCgg_dhu_tipo_concepto.get('CDTCP_NOMBRE_DESEMBOLSO'));
            isEdit = true;
            habilitarCgg_dhu_tipo_conceptoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_tipo_concepto.
     * @returns ventana winFrmCgg_dhu_tipo_concepto.
     * @base FrmCgg_dhu_tipo_concepto.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_tipo_concepto;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_tipo_concepto.
     * @base FrmCgg_dhu_tipo_concepto.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_tipo_conceptoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_tipo_concepto desde una instancia.
 */
FrmCgg_dhu_tipo_concepto.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_tipo_concepto desde una instancia.
 */
FrmCgg_dhu_tipo_concepto.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_tipo_concepto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_tipo_concepto.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_tipo_concepto desde una instancia.
 */
FrmCgg_dhu_tipo_concepto.prototype.loadData = function(){
    this.loadData();
}
