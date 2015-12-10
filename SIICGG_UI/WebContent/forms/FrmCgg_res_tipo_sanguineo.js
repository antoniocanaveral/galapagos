/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_tipo_sanguineo.
 * @param {String} INSENTENCIA_CGG_RES_TIPO_SANGUINEO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_TIPO_SANGUINEO Registro de datos de la tabla Cgg_res_tipo_sanguineo.
 * @constructor
 * @base FrmListadoCgg_res_tipo_sanguineo
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_tipo_sanguineo(INSENTENCIA_CGG_RES_TIPO_SANGUINEO,INRECORD_CGG_RES_TIPO_SANGUINEO){
    var inSentenciaCgg_res_tipo_sanguineo = INSENTENCIA_CGG_RES_TIPO_SANGUINEO;
    var inRecordCgg_res_tipo_sanguineo=INRECORD_CGG_RES_TIPO_SANGUINEO;
    var urlCgg_res_tipo_sanguineo=URL_WS+"Cgg_res_tipo_sanguineo";
    var tituloCgg_res_tipo_sanguineo='Tipo sangu\u00edneo';
    var descCgg_res_tipo_sanguineo='El formulario permite administrar informaci\u00f3n de tipo sangu\u00edneo';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGSITRO
     */
    var txtCrtsg_codigo = new Ext.form.TextField({
        id:'txtCrtsg_codigo',
        name:'txtCrtsg_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField DESCRIPCION DEL TIPO SANGUINEO
     */
    var txtCrtsg_descrpcion = new Ext.form.TextField({
        id:'txtCrtsg_descrpcion',
        name:'txtCrtsg_descrpcion',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%',
        allowBlank :false,
        maxLength :20
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_tipo_sanguineo
     */
    var btnGuardarCgg_res_tipo_sanguineo = new Ext.Button({
        id:'btnGuardarCgg_res_tipo_sanguineo',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:'Guardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_tipo_sanguineo.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_tipo_sanguineo(r){
                        winFrmCgg_res_tipo_sanguineo.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_tipo_sanguineo,
                                msg: 'La informaci\u00f3n de tipo sangu\u00edneo ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_tipo_sanguineo.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_tipo_sanguineo,
                                msg: 'La informaci\u00f3n de tipo sangu\u00edneo no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_tipo_sanguineo.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrtsg_codigo',txtCrtsg_codigo.getValue());
                    param.add('inCrtsg_descrpcion',txtCrtsg_descrpcion.getValue());
                    SOAPClient.invoke(urlCgg_res_tipo_sanguineo,INSENTENCIA_CGG_RES_TIPO_SANGUINEO,param, true, CallBackCgg_res_tipo_sanguineo);
                }catch(inErr){
                    winFrmCgg_res_tipo_sanguineo.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_tipo_sanguineo.
     */
    var btnCancelarCgg_res_tipo_sanguineo = new Ext.Button({
        id:'btnCancelarCgg_res_tipo_sanguineo',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:'Cancelar edici\u00f3n',
        listeners:{
            click:function(){
                pnlCgg_res_tipo_sanguineo.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_tipo_sanguineo.
     */
    var btnCerrarCgg_res_tipo_sanguineo = new Ext.Button({
        id:'btnCerrarCgg_res_tipo_sanguineo',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_tipo_sanguineo.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_tipo_sanguineo.
     */
    var pnlCgg_res_tipo_sanguineo = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCrtsg_codigo,txtCrtsg_descrpcion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_tipo_sanguineo.
     */
    var winFrmCgg_res_tipo_sanguineo = new Ext.Window({
        id:'winFrmCgg_res_tipo_sanguineo',
        title:tituloCgg_res_tipo_sanguineo,
        tbar:getPanelTitulo(tituloCgg_res_tipo_sanguineo,descCgg_res_tipo_sanguineo),
        items:[pnlCgg_res_tipo_sanguineo],
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        resizable:false,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_res_tipo_sanguineo,btnCancelarCgg_res_tipo_sanguineo,'->',btnCerrarCgg_res_tipo_sanguineo]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_tipo_sanguineo.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_tipo_sanguineoCtrls(inEstado){
        estado=!inEstado;
        txtCrtsg_codigo.setDisabled(estado);
        txtCrtsg_descrpcion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_tipo_sanguineo.
     */
    function cargarCgg_res_tipo_sanguineoCtrls(){
        if(inRecordCgg_res_tipo_sanguineo){
            txtCrtsg_codigo.setValue(inRecordCgg_res_tipo_sanguineo.get('CRTSG_CODIGO'));
            txtCrtsg_descrpcion.setValue(inRecordCgg_res_tipo_sanguineo.get('CRTSG_DESCRPCION'));
            isEdit = true;
            habilitarCgg_res_tipo_sanguineoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_tipo_sanguineo.
     * @returns ventana winFrmCgg_res_tipo_sanguineo.
     * @base FrmCgg_res_tipo_sanguineo.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_tipo_sanguineo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_tipo_sanguineo.
     * @base FrmCgg_res_tipo_sanguineo.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_tipo_sanguineoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_tipo_sanguineo desde una instancia.
 */
FrmCgg_res_tipo_sanguineo.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_tipo_sanguineo desde una instancia.
 */
FrmCgg_res_tipo_sanguineo.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_tipo_sanguineo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_tipo_sanguineo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_tipo_sanguineo desde una instancia.
 */
FrmCgg_res_tipo_sanguineo.prototype.loadData = function(){
    this.loadData();
}
