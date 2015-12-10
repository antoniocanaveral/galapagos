/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_respuesta.
 * @param {String} INSENTENCIA_CGG_DHU_RESPUESTA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_DHU_RESPUESTA Registro de datos de la tabla Cgg_dhu_respuesta.
 * @constructor
 * @base FrmListadoCgg_dhu_respuesta
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_respuesta(INSENTENCIA_CGG_DHU_RESPUESTA,INRECORD_CGG_DHU_RESPUESTA){
    var inSentenciaCgg_dhu_respuesta = INSENTENCIA_CGG_DHU_RESPUESTA;
    var inRecordCgg_dhu_respuesta=INRECORD_CGG_DHU_RESPUESTA;
    var urlCgg_dhu_respuesta=URL_WS+"Cgg_dhu_respuesta";
    var tituloCgg_dhu_respuesta='Respuesta';
    var descCgg_dhu_respuesta='El formulario permite administrar informaci\u00f3n de la Respuesta';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
     */
    var txtCdres_codigo = new Ext.form.TextField({
        id:'txtCdres_codigo',
        name:'txtCdres_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField DESCRIPCION DE LA RESPUESTA
     */
    var txtCdres_descripcion = new Ext.form.TextField({
        id:'txtCdres_descripcion',
        name:'txtCdres_descripcion',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_respuesta
     */
    var btnGuardarCgg_dhu_respuesta = new Ext.Button({
        id:'btnGuardarCgg_dhu_respuesta',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_dhu_respuesta.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_dhu_respuesta(r){
                        winFrmCgg_dhu_respuesta.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_respuesta,
                                msg: 'La informaci\u00f3n de Respuesta ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_respuesta.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_respuesta,
                                msg: 'La informaci\u00f3n de Respuesta no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_respuesta.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCdres_codigo',txtCdres_codigo.getValue());
                    param.add('inCdres_descripcion',txtCdres_descripcion.getValue());
                    SOAPClient.invoke(urlCgg_dhu_respuesta,INSENTENCIA_CGG_DHU_RESPUESTA,param, true, CallBackCgg_dhu_respuesta);
                }catch(inErr){
                    winFrmCgg_dhu_respuesta.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_respuesta.
     */
    var btnCancelarCgg_dhu_respuesta = new Ext.Button({
        id:'btnCancelarCgg_dhu_respuesta',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_dhu_respuesta.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_respuesta.
     */
    var btnCerrarCgg_dhu_respuesta = new Ext.Button({
        id:'btnCerrarCgg_dhu_respuesta',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_dhu_respuesta.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_respuesta.
     */
    var pnlCgg_dhu_respuesta = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCdres_codigo,txtCdres_descripcion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_respuesta.
     */
    var winFrmCgg_dhu_respuesta = new Ext.Window({
        id:'winFrmCgg_dhu_respuesta',
        title:tituloCgg_dhu_respuesta,
        tbar:getPanelTitulo(tituloCgg_dhu_respuesta,descCgg_dhu_respuesta),
        items:[pnlCgg_dhu_respuesta],
        width:400,
        minWidth:400,
        modal:true,
        resizable:false,
        maximizable:false,
        minimizable:true,
        constrain:true,
        bbar:[btnGuardarCgg_dhu_respuesta,btnCancelarCgg_dhu_respuesta,'->',btnCerrarCgg_dhu_respuesta]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_respuesta.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_respuestaCtrls(inEstado){
        estado=!inEstado;
        txtCdres_codigo.setDisabled(estado);
        txtCdres_descripcion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_respuesta.
     */
    function cargarCgg_dhu_respuestaCtrls(){
        if(inRecordCgg_dhu_respuesta){
            txtCdres_codigo.setValue(inRecordCgg_dhu_respuesta.get('CDRES_CODIGO'));
            txtCdres_descripcion.setValue(inRecordCgg_dhu_respuesta.get('CDRES_DESCRIPCION'));
            isEdit = true;
            habilitarCgg_dhu_respuestaCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_respuesta.
     * @returns ventana winFrmCgg_dhu_respuesta.
     * @base FrmCgg_dhu_respuesta.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_respuesta;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_respuesta.
     * @base FrmCgg_dhu_respuesta.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_respuestaCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_respuesta desde una instancia.
 */
FrmCgg_dhu_respuesta.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_respuesta desde una instancia.
 */
FrmCgg_dhu_respuesta.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_respuesta,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_respuesta.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_respuesta desde una instancia.
 */
FrmCgg_dhu_respuesta.prototype.loadData = function(){
    this.loadData();
}
