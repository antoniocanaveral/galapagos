/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_tipo_cacademico.
 * @param {String} INSENTENCIA_CGG_DHU_TIPO_CACADEMICO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_DHU_TIPO_CACADEMICO Registro de datos de la tabla Cgg_dhu_tipo_cacademico.
 * @constructor
 * @base FrmListadoCgg_dhu_tipo_cacademico
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_tipo_cacademico(INSENTENCIA_CGG_DHU_TIPO_CACADEMICO,INRECORD_CGG_DHU_TIPO_CACADEMICO){
    var inSentenciaCgg_dhu_tipo_cacademico = INSENTENCIA_CGG_DHU_TIPO_CACADEMICO;
    var inRecordCgg_dhu_tipo_cacademico=INRECORD_CGG_DHU_TIPO_CACADEMICO;
    var urlCgg_dhu_tipo_cacademico=URL_WS+"Cgg_dhu_tipo_cacademico";
    var tituloCgg_dhu_tipo_cacademico='Tipo certificado';
    var descCgg_dhu_tipo_cacademico='El formulario permite administrar informaci\u00f3n del tipo de certificado acad\u00e9mico';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CERTIFICADO ACADEMICO
     */
    var txtCdtca_codigo = new Ext.form.TextField({
        id:'txtCdtca_codigo',
        name:'txtCdtca_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField NOMBRE DEL CERTIFICADO
     */
    var txtCdtca_nombre = new Ext.form.TextField({
        id:'txtCdtca_nombre',
        name:'txtCdtca_nombre',
        fieldLabel :'Nombre',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField INFORMACION ADICIONAL
     */
    var txtCdtca_observacion = new Ext.form.TextArea({
        id:'txtCdtca_observacion',
        name:'txtCdtca_observacion',
        fieldLabel :'Observaci\u00f3n',
        anchor:'98%'
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_tipo_cacademico
     */
    var btnGuardarCgg_dhu_tipo_cacademico = new Ext.Button({
        id:'btnGuardarCgg_dhu_tipo_cacademico',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_dhu_tipo_cacademico.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_dhu_tipo_cacademico(r){
                        winFrmCgg_dhu_tipo_cacademico.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_tipo_cacademico,
                                msg: 'La informaci\u00f3n de Dhu tipo cacademico ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_tipo_cacademico.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_tipo_cacademico,
                                msg: 'La informaci\u00f3n de Dhu tipo cacademico no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_tipo_cacademico.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCdtca_codigo',txtCdtca_codigo.getValue());
                    param.add('inCdtca_nombre',txtCdtca_nombre.getValue());
                    param.add('inCdtca_observacion',txtCdtca_observacion.getValue());
                    SOAPClient.invoke(urlCgg_dhu_tipo_cacademico,INSENTENCIA_CGG_DHU_TIPO_CACADEMICO,param, true, CallBackCgg_dhu_tipo_cacademico);
                }catch(inErr){
                    winFrmCgg_dhu_tipo_cacademico.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_tipo_cacademico.
     */
    var btnCancelarCgg_dhu_tipo_cacademico = new Ext.Button({
        id:'btnCancelarCgg_dhu_tipo_cacademico',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_dhu_tipo_cacademico.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_tipo_cacademico.
     */
    var btnCerrarCgg_dhu_tipo_cacademico = new Ext.Button({
        id:'btnCerrarCgg_dhu_tipo_cacademico',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_dhu_tipo_cacademico.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_tipo_cacademico.
     */
    var pnlCgg_dhu_tipo_cacademico = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCdtca_codigo,txtCdtca_nombre,txtCdtca_observacion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_tipo_cacademico.
     */
    var winFrmCgg_dhu_tipo_cacademico = new Ext.Window({
        id:'winFrmCgg_dhu_tipo_cacademico',
        title:tituloCgg_dhu_tipo_cacademico,
        tbar:getPanelTitulo(tituloCgg_dhu_tipo_cacademico,descCgg_dhu_tipo_cacademico),
        items:[pnlCgg_dhu_tipo_cacademico],
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
		modal:true,
		resizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_dhu_tipo_cacademico,btnCancelarCgg_dhu_tipo_cacademico,'->',btnCerrarCgg_dhu_tipo_cacademico]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_tipo_cacademico.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_tipo_cacademicoCtrls(inEstado){
        estado=!inEstado;
        txtCdtca_codigo.setDisabled(estado);
        txtCdtca_nombre.setDisabled(estado);
        txtCdtca_observacion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_tipo_cacademico.
     */
    function cargarCgg_dhu_tipo_cacademicoCtrls(){
        if(inRecordCgg_dhu_tipo_cacademico){
            txtCdtca_codigo.setValue(inRecordCgg_dhu_tipo_cacademico.get('CDTCA_CODIGO'));
            txtCdtca_nombre.setValue(inRecordCgg_dhu_tipo_cacademico.get('CDTCA_NOMBRE'));
            txtCdtca_observacion.setValue(inRecordCgg_dhu_tipo_cacademico.get('CDTCA_OBSERVACION'));
            isEdit = true;
            habilitarCgg_dhu_tipo_cacademicoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_tipo_cacademico.
     * @returns ventana winFrmCgg_dhu_tipo_cacademico.
     * @base FrmCgg_dhu_tipo_cacademico.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_tipo_cacademico;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_tipo_cacademico.
     * @base FrmCgg_dhu_tipo_cacademico.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_tipo_cacademicoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_tipo_cacademico desde una instancia.
 */
FrmCgg_dhu_tipo_cacademico.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_tipo_cacademico desde una instancia.
 */
FrmCgg_dhu_tipo_cacademico.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_tipo_cacademico,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_tipo_cacademico.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_tipo_cacademico desde una instancia.
 */
FrmCgg_dhu_tipo_cacademico.prototype.loadData = function(){
    this.loadData();
}
