/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_modalidad_curso.
 * @param {String} INSENTENCIA_CGG_MODALIDAD_CURSO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_MODALIDAD_CURSO Registro de datos de la tabla Cgg_modalidad_curso.
 * @constructor
 * @base FrmListadoCgg_modalidad_curso
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_modalidad_curso(INSENTENCIA_CGG_MODALIDAD_CURSO,INRECORD_CGG_MODALIDAD_CURSO){
    var inSentenciaCgg_modalidad_curso = INSENTENCIA_CGG_MODALIDAD_CURSO;
    var inRecordCgg_modalidad_curso=INRECORD_CGG_MODALIDAD_CURSO;
    var urlCgg_modalidad_curso=URL_WS+"Cgg_modalidad_curso";
    var tituloCgg_modalidad_curso='Modalidad curso';
    var descCgg_modalidad_curso='El formulario permite administrar la informaci\u00f3n de Modalidad curso formaci\u00f3n profesional';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE MODALIDAD DE CURSO
     */
    var txtCgmdc_codigo = new Ext.form.TextField({
        id:'txtCgmdc_codigo',
        name:'txtCgmdc_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField DESCRIPCION DE LA MODALIDAD DE CURSO
     */
    var txtCgmdc_descripcion = new Ext.form.TextField({
        id:'txtCgmdc_descripcion',
        name:'txtCgmdc_descripcion',
        fieldLabel :'Descripcion',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_modalidad_curso
     */
    var btnGuardarCgg_modalidad_curso = new Ext.Button({
        id:'btnGuardarCgg_modalidad_curso',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_modalidad_curso.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_modalidad_curso(r){
                        winFrmCgg_modalidad_curso.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_modalidad_curso,
                                msg: 'La informaci\u00f3n de Modalidad curso ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_modalidad_curso.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_modalidad_curso,
                                msg: 'La informaci\u00f3n de Modalidad curso no ha podido ser almacenada. '+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_modalidad_curso.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCgmdc_codigo',txtCgmdc_codigo.getValue());
                    param.add('inCgmdc_descripcion',txtCgmdc_descripcion.getValue());
                    SOAPClient.invoke(urlCgg_modalidad_curso,INSENTENCIA_CGG_MODALIDAD_CURSO,param, true, CallBackCgg_modalidad_curso);
                }catch(inErr){
                    winFrmCgg_modalidad_curso.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_modalidad_curso.
     */
    var btnCancelarCgg_modalidad_curso = new Ext.Button({
        id:'btnCancelarCgg_modalidad_curso',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_modalidad_curso.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_modalidad_curso.
     */
    var btnCerrarCgg_modalidad_curso = new Ext.Button({
        id:'btnCerrarCgg_modalidad_curso',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_modalidad_curso.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_modalidad_curso.
     */
    var pnlCgg_modalidad_curso = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCgmdc_codigo,txtCgmdc_descripcion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_modalidad_curso.
     */
    var winFrmCgg_modalidad_curso = new Ext.Window({
        id:'winFrmCgg_modalidad_curso',
        title:tituloCgg_modalidad_curso,
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        resizable:false,
        modal:true,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_modalidad_curso,descCgg_modalidad_curso),
        items:[pnlCgg_modalidad_curso],
        bbar:[btnGuardarCgg_modalidad_curso,btnCancelarCgg_modalidad_curso,'->',btnCerrarCgg_modalidad_curso]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_modalidad_curso.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_modalidad_cursoCtrls(inEstado){
        estado=!inEstado;
        txtCgmdc_codigo.setDisabled(estado);
        txtCgmdc_descripcion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_modalidad_curso.
     */
    function cargarCgg_modalidad_cursoCtrls(){
        if(inRecordCgg_modalidad_curso){
            txtCgmdc_codigo.setValue(inRecordCgg_modalidad_curso.get('CGMDC_CODIGO'));
            txtCgmdc_descripcion.setValue(inRecordCgg_modalidad_curso.get('CGMDC_DESCRIPCION'));
            isEdit = true;
            habilitarCgg_modalidad_cursoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_modalidad_curso.
     * @returns ventana winFrmCgg_modalidad_curso.
     * @base FrmCgg_modalidad_curso.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_modalidad_curso;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_modalidad_curso.
     * @base FrmCgg_modalidad_curso.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_modalidad_cursoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_modalidad_curso desde una instancia.
 */
FrmCgg_modalidad_curso.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_modalidad_curso desde una instancia.
 */
FrmCgg_modalidad_curso.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_modalidad_curso,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_modalidad_curso.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_modalidad_curso desde una instancia.
 */
FrmCgg_modalidad_curso.prototype.loadData = function(){
    this.loadData();
}
