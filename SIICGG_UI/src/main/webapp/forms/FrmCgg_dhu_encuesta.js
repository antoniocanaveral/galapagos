/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_encuesta.
 * @param {String} INSENTENCIA_CGG_DHU_ENCUESTA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_DHU_ENCUESTA Registro de datos de la tabla Cgg_dhu_encuesta.
 * @constructor
 * @base FrmListadoCgg_dhu_encuesta
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_encuesta(INSENTENCIA_CGG_DHU_ENCUESTA,INRECORD_CGG_DHU_ENCUESTA){
    var inSentenciaCgg_dhu_encuesta = INSENTENCIA_CGG_DHU_ENCUESTA;
    var inRecordCgg_dhu_encuesta=INRECORD_CGG_DHU_ENCUESTA;
    var urlCgg_dhu_encuesta=URL_WS+"Cgg_dhu_encuesta";
    var tituloCgg_dhu_encuesta='Encuesta';
    var descCgg_dhu_encuesta='El formulario permite administrar informaci\u00f3n de la Encuesta';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE EVALUACION
     */
    var txtCdenc_codigo = new Ext.form.TextField({
        id:'txtCdenc_codigo',
        name:'txtCdenc_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField NOMBRE DE LA EVALUACION
     */
    var txtCdenc_nombre = new Ext.form.TextField({
        id:'txtCdenc_nombre',
        name:'txtCdenc_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField OBSERVACION DE LA EVALUACION
     */
    var txtCdenc_observacion = new Ext.form.TextField({
        id:'txtCdenc_observacion',
        name:'txtCdenc_observacion',
        fieldLabel :'Observaci\u00f3n',
        anchor:'98%'
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_encuesta
     */
    var btnGuardarCgg_dhu_encuesta = new Ext.Button({
        id:'btnGuardarCgg_dhu_encuesta',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_dhu_encuesta.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_dhu_encuesta(r){
                        winFrmCgg_dhu_encuesta.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_encuesta,
                                msg: 'La informaci\u00f3n de la Encuesta ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_encuesta.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_encuesta,
                                msg: 'La informaci\u00f3n de la Encuesta no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_encuesta.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCdenc_codigo',txtCdenc_codigo.getValue());
                    param.add('inCdenc_nombre',txtCdenc_nombre.getValue());
                    param.add('inCdenc_observacion',txtCdenc_observacion.getValue());
                    SOAPClient.invoke(urlCgg_dhu_encuesta,INSENTENCIA_CGG_DHU_ENCUESTA,param, true, CallBackCgg_dhu_encuesta);
                }catch(inErr){
                    winFrmCgg_dhu_encuesta.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_encuesta.
     */
    var btnCancelarCgg_dhu_encuesta = new Ext.Button({
        id:'btnCancelarCgg_dhu_encuesta',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_dhu_encuesta.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_encuesta.
     */
    var btnCerrarCgg_dhu_encuesta = new Ext.Button({
        id:'btnCerrarCgg_dhu_encuesta',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_dhu_encuesta.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_encuesta.
     */
    var pnlCgg_dhu_encuesta = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCdenc_codigo,txtCdenc_nombre,txtCdenc_observacion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_encuesta.
     */
    var winFrmCgg_dhu_encuesta = new Ext.Window({
        id:'winFrmCgg_dhu_encuesta',
        title:tituloCgg_dhu_encuesta,
        tbar:getPanelTitulo(tituloCgg_dhu_encuesta,descCgg_dhu_encuesta),
        items:[pnlCgg_dhu_encuesta],
        width:400,
        minWidth:400,
        modal:true,
        resizable:false,
        maximizable:false,
        minimizable:true,
        constrain:true,
        bbar:[btnGuardarCgg_dhu_encuesta,btnCancelarCgg_dhu_encuesta,'->',btnCerrarCgg_dhu_encuesta]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_encuesta.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_encuestaCtrls(inEstado){
        estado=!inEstado;
        txtCdenc_codigo.setDisabled(estado);
        txtCdenc_nombre.setDisabled(estado);
        txtCdenc_observacion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_encuesta.
     */
    function cargarCgg_dhu_encuestaCtrls(){
        if(inRecordCgg_dhu_encuesta){
            txtCdenc_codigo.setValue(inRecordCgg_dhu_encuesta.get('CDENC_CODIGO'));
            txtCdenc_nombre.setValue(inRecordCgg_dhu_encuesta.get('CDENC_NOMBRE'));
            txtCdenc_observacion.setValue(inRecordCgg_dhu_encuesta.get('CDENC_OBSERVACION'));
            isEdit = true;
            habilitarCgg_dhu_encuestaCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_encuesta.
     * @returns ventana winFrmCgg_dhu_encuesta.
     * @base FrmCgg_dhu_encuesta.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_encuesta;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_encuesta.
     * @base FrmCgg_dhu_encuesta.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_encuestaCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_encuesta desde una instancia.
 */
FrmCgg_dhu_encuesta.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_encuesta desde una instancia.
 */
FrmCgg_dhu_encuesta.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_encuesta,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_encuesta.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_encuesta desde una instancia.
 */
FrmCgg_dhu_encuesta.prototype.loadData = function(){
    this.loadData();
}
