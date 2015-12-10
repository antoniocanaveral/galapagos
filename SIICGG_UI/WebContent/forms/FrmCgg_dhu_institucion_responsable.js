/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_institucion_responsable.
 * @param {String} INSENTENCIA_CGG_DHU_INSTITUCION_RESPONSABLE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_DHU_INSTITUCION_RESPONSABLE Registro de datos de la tabla Cgg_dhu_institucion_responsable.
 * @constructor
 * @base FrmListadoCgg_dhu_institucion_responsable
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_institucion_responsable(INSENTENCIA_CGG_DHU_INSTITUCION_RESPONSABLE,INRECORD_CGG_DHU_INSTITUCION_RESPONSABLE){
    var inSentenciaCgg_dhu_institucion_responsable = INSENTENCIA_CGG_DHU_INSTITUCION_RESPONSABLE;
    var inRecordCgg_dhu_institucion_responsable=INRECORD_CGG_DHU_INSTITUCION_RESPONSABLE;
    var urlCgg_dhu_institucion_responsable=URL_WS+"Cgg_dhu_institucion_responsable";
    var tituloCgg_dhu_institucion_responsable='Instituci\u00F3n responsable';
    var descCgg_dhu_institucion_responsable='El formulario permite administrar informaci\u00f3n de instituci\u00f3n responsable';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION RESPONSABLE
     */
    var txtCditr_codigo = new Ext.form.TextField({
        id:'txtCditr_codigo',
        name:'txtCditr_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField NOMBRE DE LA INSTITUCION RESPONSABLE
     */
    var txtCditr_nombre = new Ext.form.TextField({
        id:'txtCditr_nombre',
        name:'txtCditr_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false,
        maxLength :20
    });
    /**
     * Ext.form.TextArea DESCRIPCION DE
     */
    var txtCditr_descripcion = new Ext.form.TextArea({
        id:'txtCditr_descripcion',
        name:'txtCditr_descripcion',
        fieldLabel :'Descripci\u00F3n',
        width:'90%',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_institucion_responsable
     */
    var btnGuardarCgg_dhu_institucion_responsable = new Ext.Button({
        id:'btnGuardarCgg_dhu_institucion_responsable',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_dhu_institucion_responsable.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_dhu_institucion_responsable(r){
                        winFrmCgg_dhu_institucion_responsable.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_institucion_responsable,
                                msg: 'La informaci\u00f3n ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_institucion_responsable.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_institucion_responsable,
                                msg: 'La informaci\u00f3n no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_institucion_responsable.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCditr_codigo',txtCditr_codigo.getValue());
                    param.add('inCditr_nombre',txtCditr_nombre.getValue());
                    param.add('inCditr_descripcion',txtCditr_descripcion.getValue());
                    SOAPClient.invoke(urlCgg_dhu_institucion_responsable,INSENTENCIA_CGG_DHU_INSTITUCION_RESPONSABLE,param, true, CallBackCgg_dhu_institucion_responsable);
                }catch(inErr){
                    winFrmCgg_dhu_institucion_responsable.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_institucion_responsable.
     */
    var btnCancelarCgg_dhu_institucion_responsable = new Ext.Button({
        id:'btnCancelarCgg_dhu_institucion_responsable',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_dhu_institucion_responsable.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_institucion_responsable.
     */
    var btnCerrarCgg_dhu_institucion_responsable = new Ext.Button({
        id:'btnCerrarCgg_dhu_institucion_responsable',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tootip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_dhu_institucion_responsable.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_institucion_responsable.
     */
    var pnlCgg_dhu_institucion_responsable = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCditr_codigo,txtCditr_nombre,txtCditr_descripcion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_institucion_responsable.
     */
    var winFrmCgg_dhu_institucion_responsable = new Ext.Window({
        id:'winFrmCgg_dhu_institucion_responsable',
        title:tituloCgg_dhu_institucion_responsable,
        tbar:getPanelTitulo(tituloCgg_dhu_institucion_responsable,descCgg_dhu_institucion_responsable),
        items:[pnlCgg_dhu_institucion_responsable],
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
		modal : true,
        constrain:true,
        bbar:[btnGuardarCgg_dhu_institucion_responsable,btnCancelarCgg_dhu_institucion_responsable,'->',btnCerrarCgg_dhu_institucion_responsable]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_institucion_responsable.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_institucion_responsableCtrls(inEstado){
        estado=!inEstado;
        txtCditr_codigo.setDisabled(estado);
        txtCditr_nombre.setDisabled(estado);
        txtCditr_descripcion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_institucion_responsable.
     */
    function cargarCgg_dhu_institucion_responsableCtrls(){
        if(inRecordCgg_dhu_institucion_responsable){
            txtCditr_codigo.setValue(inRecordCgg_dhu_institucion_responsable.get('CDITR_CODIGO'));
            txtCditr_nombre.setValue(inRecordCgg_dhu_institucion_responsable.get('CDITR_NOMBRE'));
            txtCditr_descripcion.setValue(inRecordCgg_dhu_institucion_responsable.get('CDITR_DESCRIPCION'));
            isEdit = true;
            habilitarCgg_dhu_institucion_responsableCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_institucion_responsable.
     * @returns ventana winFrmCgg_dhu_institucion_responsable.
     * @base FrmCgg_dhu_institucion_responsable.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_institucion_responsable;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_institucion_responsable.
     * @base FrmCgg_dhu_institucion_responsable.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_institucion_responsableCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_institucion_responsable desde una instancia.
 */
FrmCgg_dhu_institucion_responsable.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_institucion_responsable desde una instancia.
 */
FrmCgg_dhu_institucion_responsable.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_institucion_responsable,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_institucion_responsable.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_institucion_responsable desde una instancia.
 */
FrmCgg_dhu_institucion_responsable.prototype.loadData = function(){
    this.loadData();
}
