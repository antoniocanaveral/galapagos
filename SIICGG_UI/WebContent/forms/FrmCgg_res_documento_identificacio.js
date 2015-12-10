/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_documento_identificacio.
 * @param {String} INSENTENCIA_CGG_RES_DOCUMENTO_IDENTIFICACIO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_DOCUMENTO_IDENTIFICACIO Registro de datos de la tabla Cgg_res_documento_identificacio.
 * @constructor
 * @base FrmListadoCgg_res_documento_identificacio
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_documento_identificacio(INSENTENCIA_CGG_RES_DOCUMENTO_IDENTIFICACIO,INRECORD_CGG_RES_DOCUMENTO_IDENTIFICACIO){
    var inSentenciaCgg_res_documento_identificacio = INSENTENCIA_CGG_RES_DOCUMENTO_IDENTIFICACIO;
    var inRecordCgg_res_documento_identificacio=INRECORD_CGG_RES_DOCUMENTO_IDENTIFICACIO;
    var urlCgg_res_documento_identificacio=URL_WS+"Cgg_res_documento_identificacio";
    var tituloCgg_res_documento_identificacio='Documento identificaci\u00f3n';
    var descCgg_res_documento_identificacio='El formulario permite administrar informaci\u00f3n de documento de identificaci\u00f3n';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrdid_codigo = new Ext.form.TextField({
        id:'txtCrdid_codigo',
        name:'txtCrdid_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField DESCRIPCION DEL DOCUMENTO DE IDENTIFICACION
     */
    var txtCrdid_descripcion = new Ext.form.TextField({
        id:'txtCrdid_descripcion',
        name:'txtCrdid_descripcion',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%',
        allowBlank :false,
        maxLength :200
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_documento_identificacio
     */
    var btnGuardarCgg_res_documento_identificacio = new Ext.Button({
        id:'btnGuardarCgg_res_documento_identificacio',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:'Guardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_documento_identificacio.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_documento_identificacio(r){
                        winFrmCgg_res_documento_identificacio.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_documento_identificacio,
                                msg: 'La informaci\u00f3n de documento identificaci\u00f3n ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_documento_identificacio.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_documento_identificacio,
                                msg: 'La informaci\u00f3n de documento identificaci\u00f3n no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_documento_identificacio.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrdid_codigo',txtCrdid_codigo.getValue());
                    param.add('inCrdid_descripcion',txtCrdid_descripcion.getValue());
                    SOAPClient.invoke(urlCgg_res_documento_identificacio,INSENTENCIA_CGG_RES_DOCUMENTO_IDENTIFICACIO,param, true, CallBackCgg_res_documento_identificacio);
                }catch(inErr){
                    winFrmCgg_res_documento_identificacio.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_documento_identificacio.
     */
    var btnCancelarCgg_res_documento_identificacio = new Ext.Button({
        id:'btnCancelarCgg_res_documento_identificacio',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:'Cancelar edici\u00f3n',
        listeners:{
            click:function(){
                pnlCgg_res_documento_identificacio.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_documento_identificacio.
     */
    var btnCerrarCgg_res_documento_identificacio = new Ext.Button({
        id:'btnCerrarCgg_res_documento_identificacio',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_documento_identificacio.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_documento_identificacio.
     */
    var pnlCgg_res_documento_identificacio = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCrdid_codigo,txtCrdid_descripcion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_documento_identificacio.
     */
    var winFrmCgg_res_documento_identificacio = new Ext.Window({
        id:'winFrmCgg_res_documento_identificacio',
        title:tituloCgg_res_documento_identificacio,
        tbar:getPanelTitulo(tituloCgg_res_documento_identificacio,descCgg_res_documento_identificacio),
        items:[pnlCgg_res_documento_identificacio],
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        resizable:false,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_res_documento_identificacio,btnCancelarCgg_res_documento_identificacio,'->',btnCerrarCgg_res_documento_identificacio]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_documento_identificacio.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_documento_identificacioCtrls(inEstado){
        estado=!inEstado;
        txtCrdid_codigo.setDisabled(estado);
        txtCrdid_descripcion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_documento_identificacio.
     */
    function cargarCgg_res_documento_identificacioCtrls(){
        if(inRecordCgg_res_documento_identificacio){
            txtCrdid_codigo.setValue(inRecordCgg_res_documento_identificacio.get('CRDID_CODIGO'));
            txtCrdid_descripcion.setValue(inRecordCgg_res_documento_identificacio.get('CRDID_DESCRIPCION'));
            isEdit = true;
            habilitarCgg_res_documento_identificacioCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_documento_identificacio.
     * @returns ventana winFrmCgg_res_documento_identificacio.
     * @base FrmCgg_res_documento_identificacio.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_documento_identificacio;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_documento_identificacio.
     * @base FrmCgg_res_documento_identificacio.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_documento_identificacioCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_documento_identificacio desde una instancia.
 */
FrmCgg_res_documento_identificacio.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_documento_identificacio desde una instancia.
 */
FrmCgg_res_documento_identificacio.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_documento_identificacio,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_documento_identificacio.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_documento_identificacio desde una instancia.
 */
FrmCgg_res_documento_identificacio.prototype.loadData = function(){
    this.loadData();
}
