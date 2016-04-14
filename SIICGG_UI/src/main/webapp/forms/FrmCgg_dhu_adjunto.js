/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_adjunto.
 * @param {String} IN_SENTENCIA_CGG_DHU_ADJUNTO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_DHU_ADJUNTO Registro de datos de la tabla Cgg_dhu_adjunto.
 * @constructor
 * @base FrmListadoCgg_dhu_adjunto
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_adjunto(IN_SENTENCIA_CGG_DHU_ADJUNTO,IN_RECORD_CGG_DHU_ADJUNTO){
    var inSentenciaCgg_dhu_adjunto = IN_SENTENCIA_CGG_DHU_ADJUNTO;
    var inRecordCgg_dhu_adjunto=IN_RECORD_CGG_DHU_ADJUNTO;
    var urlCgg_dhu_adjunto=URL_WS+"Cgg_dhu_adjunto";
    var tituloCgg_dhu_adjunto='Adjunto';
    var descCgg_dhu_adjunto='El formulario permite administrar la informaci\u00f3n de adjunto';
    var isEdit = false;
    var tmpDependencias = new Array(2);
    var tmpDatosConfirmados = false; //Variable boolean utilizada para controlar la confirmacion del ingreso o actualización de información

    var objPerfilPersona ={
        CDAD_CODIGO:'KEYGEN',
        CDBEC_CODIGO:'',
        CDAD_DESCRIPCION:'',
        CDAD_OBSERVACION:'',
        CDAD_NOMBRE_ADJUNTO:'',
        CDAD_ADJUNTO:'',
        CDAD_TIPO:'',
        CDAD_DESCRIPCION_CONTENIDO:''

    };

    /**
     * Ext.form.TextField CODIGO QUE IDENTIFICA EL ADJUNTO DE UNA BECA

     */
    var txtCdad_codigo = new Ext.form.TextField({
        id:'txtCdad_codigo',
        name:'txtCdad_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE BECA
     */
    var txtCdbec_codigo = new Ext.form.TextField({
        id:'txtCdbec_codigo',
        name:'txtCdbec_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true'

    });

    /**
     * Ext.form.TextArea CAMPO DE TEXTO DE UNA DESCRIPCION DE DOCUMENTO
     */
    var txtCdad_descripcion = new Ext.form.TextArea({
        id:'txtCdad_descripcion',
        name:'txtCdad_descripcion',
        fieldLabel :'Descripci\u00f3n',
        width:'90%',
        allowBlank :false
    });
    /**
     * Ext.form.TextArea CAMPO DE TEXTO DE OBSERVACION DEL DOCUMENTO
     */
    var txtCdad_observacion = new Ext.form.TextArea({
        id:'txtCdad_observacion',
        name:'txtCdad_observacion',
        fieldLabel :'Observaci\u00f3n',
        width:'90%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField NOMBRE DEL DOCUMENTO ADJUNTO
     */
    var txtCdad_nombre_adjunto = new Ext.form.TextField({
        id:'txtCdad_nombre_adjunto',
        name:'txtCdad_nombre_adjunto',
        fieldLabel :'Nombre adjunto',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * CONTENIDO BINARIO DEL DOCUMENTO ADJUNTO
     */
    var filCdad_adjunto = new Ext.form.FileUploadField({
        id:'filCdad_adjunto',
        name:'filCdad_adjunto',
        fieldLabel :'Adjunto',
        anchor:'98%',
        disabled :false,
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        }
    });
    /**
     * Ext.form.NumberField TIPO DEL DOCUMENTO ADJUNTO A LA BECA VALORES:
     0 - CONTRATO DE BECA
     1 - INFORME
     2 - MEMORANDUM DE APROBACIONES
     3 - OTROS
     */
    var numCdad_tipo = new Ext.form.NumberField({
        id:'numCdad_tipo',
        name:'numCdad_tipo',
        fieldLabel :'Tipo',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.combobox de tipo de ciclo

     */

    var cbxCdhu_tipo_adjunto = new Ext.form.ComboBox({
        id:'cbxCdhu_tipo_adjunto',
        name:'cbxCdhu_tipo_adjunto',
        store: dtCdad_tipo,
        fieldLabel :'Tipo documento',
        displayField: 'tipo_adjunto',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        hiddenId:'cbxCdhu_tipo_adjuntoH',
        hiddenName:'cbxCdhu_tipo_adjuntoH',
        hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'98%',
        triggerAction:'all',
        emptyText : 'Seleccione una opci\u00f3n..',
        valueField:'id_tipo_adjunto'
    });
    /**
     * Ext.form.TextArea CAMPO DE TEXTO DESCRIPCION CONTENIDO
     */
    var txtCdad_descripcion_contenido = new Ext.form.TextArea({
        id:'txtCdad_descripcion_contenido',
        name:'txtCdad_descripcion_contenido',
        fieldLabel :'Descripci\u00f3n contenido',
        width:'90%',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_adjunto
     */
    var btnGuardarCgg_dhu_adjunto = new Ext.Button({
        id:'btnGuardarCgg_dhu_adjunto',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_dhu_adjunto.getForm().isValid()==false){
                    return;
                }
                    objPerfilPersona.CDAD_CODIGO = txtCdad_codigo.getValue();
                    objPerfilPersona.CDBEC_CODIGO = txtCdbec_codigo.getValue();
                    objPerfilPersona.CDAD_DESCRIPCION= txtCdad_descripcion.getRawValue();
                    objPerfilPersona.CDAD_OBSERVACION= txtCdad_observacion.getValue();
                    objPerfilPersona.CDAD_NOMBRE_ADJUNTO= txtCdad_nombre_adjunto.getValue();
                    objPerfilPersona.CDAD_TIPO= cbxCdhu_tipo_adjunto.getValue();
                    objPerfilPersona.CDAD_DESCRIPCION_CONTENIDO= txtCdad_descripcion_contenido.getRawValue();
                    tmpDatosConfirmados =  true;
                if (filCdad_adjunto.getValue() && filCdad_adjunto.getValue().length > 0)
                    txtCdad_nombre_adjunto.setValue(txtCdad_nombre_adjunto.getValue());


                tmpDependencias['CODIGO_BECA'] = tmpDependencias['CODIGO_BECA']? tmpDependencias['CODIGO_BECA'] : null;

                Ext.getCmp('pnlCgg_dhu_adjunto').getForm().submit({
                    url: URL_WS+"Cgg_dhu_adjuntoSRV",
                    waitMsg: 'Enviando formulario...',
                    success: function(fp, o){
                        Ext.Msg.show({
                            title:tituloCgg_dhu_adjunto,
                            msg: 'La informaci\u00f3n ha sido almacenada.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                        winFrmCgg_dhu_adjunto.close();
                    },
                    failure:function(o){
                        Ext.Msg.show({
                            title:tituloCgg_dhu_adjunto,
                            msg: 'La informaci\u00f3n no ha podido ser almacenada.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    },
                    params:{
                        request:IN_SENTENCIA_CGG_DHU_ADJUNTO,
                        cdbec_codigo:null


                    }


                });
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_adjunto.
     */
    var btnCancelarCgg_dhu_adjunto = new Ext.Button({
        id:'btnCancelarCgg_dhu_adjunto',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_dhu_adjunto.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_adjunto.
     */
    var btnCerrarCgg_dhu_adjunto = new Ext.Button({
        id:'btnCerrarCgg_dhu_adjunto',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_dhu_adjunto.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_adjunto.
     */
    var pnlCgg_dhu_adjunto = new Ext.form.FormPanel({
        id:'pnlCgg_dhu_adjunto',
        fileUpload:true,
        frame:true,
        labelWidth :100,
        items:[txtCdad_codigo,
            txtCdad_descripcion,txtCdad_observacion,
            txtCdad_nombre_adjunto,
            filCdad_adjunto,
            cbxCdhu_tipo_adjunto,
            txtCdad_descripcion_contenido]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_adjunto.
     */
    var winFrmCgg_dhu_adjunto = new Ext.Window({
        id:'winFrmCgg_dhu_adjunto',
        title:tituloCgg_dhu_adjunto,
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        constrain:true,
		modal:true,
		resizable:false,
        tbar:getPanelTitulo(tituloCgg_dhu_adjunto,descCgg_dhu_adjunto),
        items:[pnlCgg_dhu_adjunto],
        bbar:[btnGuardarCgg_dhu_adjunto,btnCancelarCgg_dhu_adjunto,'->',btnCerrarCgg_dhu_adjunto]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_adjunto.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_adjuntoCtrls(inEstado){
        estado=!inEstado;
        txtCdad_codigo.setDisabled(estado);
        txtCdbec_codigo.setDisabled(estado);
        txtCdad_descripcion.setDisabled(estado);
        txtCdad_observacion.setDisabled(estado);
        txtCdad_nombre_adjunto.setDisabled(estado);
        filCdad_adjunto.setDisabled(estado);
        cbxCdhu_tipo_adjunto.setDisabled(estado);
        txtCdad_descripcion_contenido.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_adjunto.
     */
    function cargarCgg_dhu_adjuntoCtrls(){
        if(inRecordCgg_dhu_adjunto){
            txtCdad_codigo.setValue(inRecordCgg_dhu_adjunto.get('CDAD_CODIGO'));
            txtCdbec_codigo.setValue(inRecordCgg_dhu_adjunto.get('CDBEC_CODIGO'));
            txtCdad_descripcion.setValue(inRecordCgg_dhu_adjunto.get('CDAD_DESCRIPCION'));
            txtCdad_observacion.setValue(inRecordCgg_dhu_adjunto.get('CDAD_OBSERVACION'));
            txtCdad_nombre_adjunto.setValue(inRecordCgg_dhu_adjunto.get('CDAD_NOMBRE_ADJUNTO'));
            filCdad_adjunto.setValue(inRecordCgg_dhu_adjunto.get('CDAD_ADJUNTO'));
            cbxCdhu_tipo_adjunto.setValue(inRecordCgg_dhu_adjunto.get('CDAD_TIPO'));
            txtCdad_descripcion_contenido.setValue(inRecordCgg_dhu_adjunto.get('CDAD_DESCRIPCION_CONTENIDO'));
            isEdit = true;
            habilitarCgg_dhu_adjuntoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_adjunto.
     * @returns ventana winFrmCgg_dhu_adjunto.
     * @base FrmCgg_dhu_adjunto.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_adjunto;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_adjunto.
     * @base FrmCgg_dhu_adjunto.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_adjuntoCtrls();
    }
/**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_adjunto.
     * @base FrmCgg_res_persona_contacto.prototype.loadData
     */
    this.getData = function(){
        if (tmpDatosConfirmados)
            return objPerfilPersona;
        else
            return null;
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_adjunto desde una instancia.
 */
FrmCgg_dhu_adjunto.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_adjunto desde una instancia.
 */
FrmCgg_dhu_adjunto.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_adjunto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_adjunto.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_adjunto desde una instancia.
 */
FrmCgg_dhu_adjunto.prototype.loadData = function(){
    this.loadData();
}
