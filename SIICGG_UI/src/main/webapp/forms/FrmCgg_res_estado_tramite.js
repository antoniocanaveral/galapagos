/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_estado_tramite.
 * @param {String} INSENTENCIA_CGG_RES_ESTADO_TRAMITE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_ESTADO_TRAMITE Registro de datos de la tabla Cgg_res_estado_tramite.
 * @constructor
 * @base FrmListadoCgg_res_estado_tramite
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_estado_tramite(INSENTENCIA_CGG_RES_ESTADO_TRAMITE,INRECORD_CGG_RES_ESTADO_TRAMITE){
    var inSentenciaCgg_res_estado_tramite = INSENTENCIA_CGG_RES_ESTADO_TRAMITE;
    var inRecordCgg_res_estado_tramite=INRECORD_CGG_RES_ESTADO_TRAMITE;
    var urlCgg_res_estado_tramite=URL_WS+"Cgg_res_estado_tramite";
    var tituloCgg_res_estado_tramite='Estados de tr\u00E1mite';
    var descCgg_res_estado_tramite='Formulario para el ingreso de la informaci\u00f3n de los estados de tr\u00E1mite';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */

   var txtCrett_codigo = new Ext.form.TextField({
        id:'txtCrett_codigo',
        name:'txtCrett_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField NOMBRE DEL ESTADO DEL TRAMITE
     */
    var txtCrett_nombre = new Ext.form.TextField({
        id:'txtCrett_nombre',
        name:'txtCrett_nombre',
        fieldLabel :'Nombre estado',
        anchor:'98%',
        xtype:'textfield',
        allowBlank :false        
    });
    /**
     * Ext.form.TextField ABREVIATURA DEL ESTADO DEL TRAMITE
     */
    var txtCrett_abreviatura = new Ext.form.TextField({
        id:'txtCrett_abreviatura',
        name:'txtCrett_abreviatura',
        fieldLabel :'Abreviatura',
        anchor:'98%',
        allowBlank :false,
        maxLength :20
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_estado_tramite
     */
    var btnGuardarCgg_res_estado_tramite = new Ext.Button({
        id:'btnGuardarCgg_res_estado_tramite',
        text:'Guardar',
        iconCls:'iconGuardar',
		tooltip:'Almacena la informaci\u00f3n del estado.',
        listeners:{
            click:function(){
                if (pnlCgg_res_estado_tramite.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_estado_tramite(r){
                        winFrmCgg_res_estado_tramite.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_estado_tramite,
                                msg: 'La informaci\u00f3n del estado del tr\u00E1mite ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_estado_tramite.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_estado_tramite,
                                msg: 'La informaci\u00f3n del estado del tr\u00E1mite no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_estado_tramite.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrett_codigo',txtCrett_codigo.getValue());
                    param.add('inCrett_nombre',txtCrett_nombre.getValue());
                    param.add('inCrett_abreviatura',txtCrett_abreviatura.getValue());
                    SOAPClient.invoke(urlCgg_res_estado_tramite,INSENTENCIA_CGG_RES_ESTADO_TRAMITE,param, true, CallBackCgg_res_estado_tramite);
                }catch(inErr){
                    winFrmCgg_res_estado_tramite.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_estado_tramite.
     */
    var btnCancelarCgg_res_estado_tramite = new Ext.Button({
        id:'btnCancelarCgg_res_estado_tramite',
        text:'Cancelar',
        iconCls:'iconCancelar',
		tooltip:'Cancela la informaci\u00f3n almacenarce',
        listeners:{
            click:function(){
                pnlCgg_res_estado_tramite.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_estado_tramite.
     */
    var btnCerrarCgg_res_estado_tramite = new Ext.Button({
        id:'btnCerrarCgg_res_estado_tramite',
        text:'Cerrar',
        iconCls:'iconCerrar',
		tooltip:'Cierra la ventana del registro de los estados del tr\u00E1mite.',
        listeners:{
            click:function(){
                winFrmCgg_res_estado_tramite.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_estado_tramite.
     */
    var pnlCgg_res_estado_tramite = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCrett_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.9,layout:'form',items:[txtCrett_nombre]},{columnWidth:.9,layout:'form',items:[txtCrett_abreviatura]}]}]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_estado_tramite.
     */
    var winFrmCgg_res_estado_tramite = new Ext.Window({
        id:'winFrmCgg_res_estado_tramite',
        title:tituloCgg_res_estado_tramite,
        tbar:getPanelTitulo(tituloCgg_res_estado_tramite,descCgg_res_estado_tramite),
        items:[pnlCgg_res_estado_tramite],
        modal: true,
	resizable: false,
        width:400,
        minWidth:400,
        constrain:true,
        bbar:[btnGuardarCgg_res_estado_tramite,btnCancelarCgg_res_estado_tramite,'->',btnCerrarCgg_res_estado_tramite]
    });

    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_estado_tramite.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_estado_tramiteCtrls(inEstado){
        estado=!inEstado;
        txtCrett_codigo.setDisabled(estado);
        txtCrett_nombre.setDisabled(estado);
        txtCrett_abreviatura.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_estado_tramite.
     */
    function cargarCgg_res_estado_tramiteCtrls(){
        if(inRecordCgg_res_estado_tramite){
            txtCrett_codigo.setValue(inRecordCgg_res_estado_tramite.get('CRETT_CODIGO'));
            txtCrett_nombre.setValue(inRecordCgg_res_estado_tramite.get('CRETT_NOMBRE'));
            txtCrett_abreviatura.setValue(inRecordCgg_res_estado_tramite.get('CRETT_ABREVIATURA'));
            isEdit = true;
            habilitarCgg_res_estado_tramiteCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_estado_tramite.
     * @returns ventana winFrmCgg_res_estado_tramite.
     * @base FrmCgg_res_estado_tramite.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_estado_tramite;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_estado_tramite.
     * @base FrmCgg_res_estado_tramite.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_estado_tramiteCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_estado_tramite desde una instancia.
 */
FrmCgg_res_estado_tramite.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_estado_tramite desde una instancia.
 */
FrmCgg_res_estado_tramite.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_estado_tramite,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_estado_tramite.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_estado_tramite desde una instancia.
 */
FrmCgg_res_estado_tramite.prototype.loadData = function(){
    this.loadData();
}
