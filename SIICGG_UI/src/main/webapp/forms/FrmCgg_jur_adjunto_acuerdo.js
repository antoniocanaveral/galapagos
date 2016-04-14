/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_jur_adjunto_acuerdo.
 * @param {String} IN_SENTENCIA_CGG_JUR_ADJUNTO_ACUERDO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_JUR_ADJUNTO_ACUERDO Registro de datos de la tabla Cgg_jur_adjunto_acuerdo.
 * @constructor
 * @base FrmListadoCgg_jur_adjunto_acuerdo
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_jur_adjunto_acuerdo(IN_SENTENCIA_CGG_JUR_ADJUNTO_ACUERDO,IN_RECORD_CGG_JUR_ADJUNTO_ACUERDO){
    var inSentenciaCgg_jur_adjunto_acuerdo = IN_SENTENCIA_CGG_JUR_ADJUNTO_ACUERDO;
    var inRecordCgg_jur_adjunto_acuerdo=IN_RECORD_CGG_JUR_ADJUNTO_ACUERDO;
    var urlCgg_jur_adjunto_acuerdo=URL_WS+"Cgg_jur_adjunto_acuerdo";
    var tituloCgg_jur_adjunto_acuerdo='Adjunto Acuerdo';
    var descCgg_jur_adjunto_acuerdo='El formulario permite administrar la informaci\u00f3n de Adjunto Acuerdo';
    var isEdit = false;


    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO DE ACUERDO
     */
    var txtCjada_codigo = new Ext.form.TextField({
        id:'txtCjada_codigo',
        name:'txtCjada_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField DESCRIP`CION DEL ARCHIVO ADJUNTO
     */
    var txtCjada_descripcion = new Ext.form.TextField({
        id:'txtCjada_descripcion',
        name:'txtCjada_descripcion',
        fieldLabel :'Descripci\u00f3n ',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField NO ESPECIFICADO
     */
    var txtCjada_nombre_adjunto = new Ext.form.TextField({
        id:'txtCjada_nombre_adjunto',
        name:'txtCjada_nombre_adjunto',
        fieldLabel :'Nombre adjunto',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * ARCHIVO DIGITAL
     */
    var filCjada_adjunto = new Ext.form.FileUploadField({
        id:'filCjada_adjunto',
        name:'filCjada_adjunto',
        fieldLabel :'Adjunto',
        anchor:'98%',
        disabled :false,
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        }
    });
    /*/**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_jur_adjunto_acuerdo
     */
    var btnGuardarCgg_jur_adjunto_acuerdo = new Ext.Button({
        id:'btnGuardarCgg_jur_adjunto_acuerdo',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                
   /*             if (pnlCgg_jur_adjunto_acuerdo.getForm().isValid()==false){
                    return;
                }

                  if (filCjada_adjunto.getValue() && filCjada_adjunto.getValue().length > 0)
                    txtCjada_nombre_adjunto.setValue(txtCjada_nombre_adjunto.getValue());

                Ext.getCmp('pnlCgg_jur_adjunto_acuerdo').getForm().submit({
                    url: URL_WS+"Cgg_jur_adjunto_acuerdoSRV",
                    waitMsg: 'Enviando formulario...',
                    success: function(fp, o){
                        Ext.Msg.show({
                            title:tituloCgg_jur_adjunto_acuerdo,
                            msg: 'La informaci\u00f3n de Jur adjunto acuerdo ha sido almacenada.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                        winFrmCgg_jur_adjunto_acuerdo.close();
                    },
                    failure:function(o){
                        Ext.Msg.show({
                            title:tituloCgg_jur_adjunto_acuerdo,
                            msg: 'La informaci\u00f3n de Jur adjunto acuerdo no ha podido ser almacenada.'+(r.message?r.message:r),
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    },
                    params:{
                       cjacu_codigo:null
                    }
                });*/
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_jur_adjunto_acuerdo.
     */
    var btnCancelarCgg_jur_adjunto_acuerdo = new Ext.Button({
        id:'btnCancelarCgg_jur_adjunto_acuerdo',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_jur_adjunto_acuerdo.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_jur_adjunto_acuerdo.
     */
    var btnCerrarCgg_jur_adjunto_acuerdo = new Ext.Button({
        id:'btnCerrarCgg_jur_adjunto_acuerdo',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_jur_adjunto_acuerdo.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_jur_adjunto_acuerdo.
     */
    var pnlCgg_jur_adjunto_acuerdo = new Ext.form.FormPanel({
        id :'pnlCgg_jur_adjunto_acuerdo',
        frame:true,
        labelWidth :100,
        items:[txtCjada_codigo,
            txtCjada_nombre_adjunto,filCjada_adjunto,txtCjada_descripcion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_jur_adjunto_acuerdo.
     */
    var winFrmCgg_jur_adjunto_acuerdo = new Ext.Window({
        id:'winFrmCgg_jur_adjunto_acuerdo',
        title:tituloCgg_jur_adjunto_acuerdo,
        iconCls:'iconAplicacion',
        width:400,
        minWidth:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_jur_adjunto_acuerdo,descCgg_jur_adjunto_acuerdo),
        items:[pnlCgg_jur_adjunto_acuerdo],
        bbar:[btnGuardarCgg_jur_adjunto_acuerdo,btnCancelarCgg_jur_adjunto_acuerdo,'->',btnCerrarCgg_jur_adjunto_acuerdo]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_jur_adjunto_acuerdo.getBottomToolbar());
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_jur_adjunto_acuerdo.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_jur_adjunto_acuerdoCtrls(inEstado){
        estado=!inEstado;
        txtCjada_codigo.setDisabled(estado);
        txtCjacu_codigo.setDisabled(estado);
        txtCjada_descripcion.setDisabled(estado);
        txtCjada_nombre_adjunto.setDisabled(estado);
        numCjada_adjunto.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_jur_adjunto_acuerdo.
     */
    function cargarCgg_jur_adjunto_acuerdoCtrls(){
        if(inRecordCgg_jur_adjunto_acuerdo){
            txtCjada_codigo.setValue(inRecordCgg_jur_adjunto_acuerdo.get('CJADA_CODIGO'));
            txtCjacu_codigo.setValue(inRecordCgg_jur_adjunto_acuerdo.get('CJACU_CODIGO'));
            txtCjada_descripcion.setValue(inRecordCgg_jur_adjunto_acuerdo.get('CJADA_DESCRIPCION'));
            txtCjada_nombre_adjunto.setValue(inRecordCgg_jur_adjunto_acuerdo.get('CJADA_NOMBRE_ADJUNTO'));
            numCjada_adjunto.setValue(inRecordCgg_jur_adjunto_acuerdo.get('CJADA_ADJUNTO'));
            isEdit = true;
            habilitarCgg_jur_adjunto_acuerdoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_jur_adjunto_acuerdo.
     * @returns ventana winFrmCgg_jur_adjunto_acuerdo.
     * @base FrmCgg_jur_adjunto_acuerdo.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_jur_adjunto_acuerdo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_jur_adjunto_acuerdo.
     * @base FrmCgg_jur_adjunto_acuerdo.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_jur_adjunto_acuerdoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_jur_adjunto_acuerdo desde una instancia.
 */
FrmCgg_jur_adjunto_acuerdo.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_jur_adjunto_acuerdo desde una instancia.
 */
FrmCgg_jur_adjunto_acuerdo.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_jur_adjunto_acuerdo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_jur_adjunto_acuerdo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_jur_adjunto_acuerdo desde una instancia.
 */
FrmCgg_jur_adjunto_acuerdo.prototype.loadData = function(){
    this.loadData();
}
