/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_estado_civil.
 * @param {String} INSENTENCIA_CGG_RES_ESTADO_CIVIL Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_ESTADO_CIVIL Registro de datos de la tabla Cgg_res_estado_civil.
 * @constructor
 * @base FrmListadoCgg_res_estado_civil
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_estado_civil(INSENTENCIA_CGG_RES_ESTADO_CIVIL,INRECORD_CGG_RES_ESTADO_CIVIL){
    var inSentenciaCgg_res_estado_civil = INSENTENCIA_CGG_RES_ESTADO_CIVIL;
    var inRecordCgg_res_estado_civil=INRECORD_CGG_RES_ESTADO_CIVIL;
    var urlCgg_res_estado_civil=URL_WS+"Cgg_res_estado_civil";
    var tituloCgg_res_estado_civil='Estado civil';
    var descCgg_res_estado_civil='El formulario permite administrar informaci\u00f3n de Estado civil';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGSITRO
     */
    var txtCrecv_codigo = new Ext.form.TextField({
        id:'txtCrecv_codigo',
        name:'txtCrecv_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField DESCRIPCION DEL TIPO DE RESIDENCIA
     */
    var txtCrecv_descrpcion = new Ext.form.TextField({
        id:'txtCrecv_descrpcion',
        name:'txtCrecv_descrpcion',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%',
        allowBlank :false,
        maxLength :100
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_estado_civil
     */
    var btnGuardarCgg_res_estado_civil = new Ext.Button({
        id:'btnGuardarCgg_res_estado_civil',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:'Guardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_estado_civil.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_estado_civil(r){
                        winFrmCgg_res_estado_civil.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_estado_civil,
                                msg: 'La informaci\u00f3n de estado civil ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_estado_civil.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_estado_civil,
                                msg: 'La informaci\u00f3n de estado civil no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_estado_civil.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrecv_codigo',txtCrecv_codigo.getValue());
                    param.add('inCrecv_descrpcion',txtCrecv_descrpcion.getValue());
                    SOAPClient.invoke(urlCgg_res_estado_civil,INSENTENCIA_CGG_RES_ESTADO_CIVIL,param, true, CallBackCgg_res_estado_civil);
                }catch(inErr){
                    winFrmCgg_res_estado_civil.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_estado_civil.
     */
    var btnCancelarCgg_res_estado_civil = new Ext.Button({
        id:'btnCancelarCgg_res_estado_civil',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:'Cancelar edici\u00f3n',
        listeners:{
            click:function(){
                pnlCgg_res_estado_civil.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_estado_civil.
     */
    var btnCerrarCgg_res_estado_civil = new Ext.Button({
        id:'btnCerrarCgg_res_estado_civil',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_estado_civil.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_estado_civil.
     */
    var pnlCgg_res_estado_civil = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCrecv_codigo,txtCrecv_descrpcion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_estado_civil.
     */
    var winFrmCgg_res_estado_civil = new Ext.Window({
        id:'winFrmCgg_res_estado_civil',
        title:tituloCgg_res_estado_civil,
        tbar:getPanelTitulo(tituloCgg_res_estado_civil,descCgg_res_estado_civil),
        items:[pnlCgg_res_estado_civil],
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        resizable:false,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_res_estado_civil,btnCancelarCgg_res_estado_civil,'->',btnCerrarCgg_res_estado_civil]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_estado_civil.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_estado_civilCtrls(inEstado){
        estado=!inEstado;
        txtCrecv_codigo.setDisabled(estado);
        txtCrecv_descrpcion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_estado_civil.
     */
    function cargarCgg_res_estado_civilCtrls(){
        if(inRecordCgg_res_estado_civil){
            txtCrecv_codigo.setValue(inRecordCgg_res_estado_civil.get('CRECV_CODIGO'));
            txtCrecv_descrpcion.setValue(inRecordCgg_res_estado_civil.get('CRECV_DESCRPCION'));
            isEdit = true;
            habilitarCgg_res_estado_civilCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_estado_civil.
     * @returns ventana winFrmCgg_res_estado_civil.
     * @base FrmCgg_res_estado_civil.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_estado_civil;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_estado_civil.
     * @base FrmCgg_res_estado_civil.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_estado_civilCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_estado_civil desde una instancia.
 */
FrmCgg_res_estado_civil.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_estado_civil desde una instancia.
 */
FrmCgg_res_estado_civil.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_estado_civil,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_estado_civil.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_estado_civil desde una instancia.
 */
FrmCgg_res_estado_civil.prototype.loadData = function(){
    this.loadData();
}
