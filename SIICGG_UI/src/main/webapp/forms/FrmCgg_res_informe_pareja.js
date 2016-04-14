/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_informe_pareja.
 * @param {String} INSENTENCIA_CGG_RES_INFORME_PAREJA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_INFORME_PAREJA Registro de datos de la tabla Cgg_res_informe_pareja.
 * @constructor
 * @base FrmListadoCgg_res_informe_pareja
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_informe_pareja(INSENTENCIA_CGG_RES_INFORME_PAREJA,INRECORD_CGG_RES_INFORME_PAREJA){
    var inSentenciaCgg_res_informe_pareja = INSENTENCIA_CGG_RES_INFORME_PAREJA;
    var inRecordCgg_res_informe_pareja=INRECORD_CGG_RES_INFORME_PAREJA;
    var urlCgg_res_informe_pareja=URL_WS+"Cgg_res_informe_pareja";
    var tituloCgg_res_informe_pareja='Informe Pareja';
    var descCgg_res_informe_pareja='El formulario permite administrar informaci\u00f3n del Informe Pareja';
    var isEdit = false;
    var tmpCradj_codigo_adjunto;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrinf_codigo = new Ext.form.TextField({
        id:'txtCrinf_codigo',
        name:'txtCrinf_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrmtr_codigo = new Ext.form.TextField({
        id:'txtCrmtr_codigo',
        name:'txtCrmtr_codigo',
        fieldLabel :'Codigo',
        anchor:'100%',
        allowBlank :false,
        readOnly:'true'
    });
     /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrofm_codigo = new Ext.form.TextField({
        id:'txtCrofm_codigo',
        name:'txtCrofm_codigo',
        fieldLabel :'Codigo',
        anchor:'100%',
        allowBlank :false,
        readOnly:'true'
    });
    /**
     * Ext.form.DateField FECHA DE ENTREGA DEL INFORME DE SEGUIMEINTO A PAREJAS
     */
    var dtCrinf_fecha_entrega = new Ext.form.DateField({
        id:'dtCrinf_fecha_entrega',
        name:'dtCrinf_fecha_entrega',
        fieldLabel :'Fecha entrega',
        allowBlank :false,
        value:new Date()
    });
    /**
     * Ext.form.TextArea RESUMEN DEL CONTENIDO DEL INFORME
     */
    var txtCrinf_extracto = new Ext.form.TextArea({
        id:'txtCrinf_extracto',
        name:'txtCrinf_extracto',
        fieldLabel :'Extracto',
        width:'96%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField NUMERO SECUENCIAL DE INFORME
     */
    var txtCrinf_numero_documento = new Ext.form.TextField({
        id:'txtCrinf_numero_documento',
        name:'txtCrinf_numero_documento',
        fieldLabel :'N\u00famero',
        anchor:'97%',
        allowBlank :false,
        readOnly:true
    });

    /**
     * Ext.form.TextArea INFORMACION ADICIONAL - HISTORIAL JSON
     */
    var txtCrinf_observacion = new Ext.form.TextArea({
        id:'txtCrinf_observacion',
        name:'txtCrinf_observacion',
        fieldLabel :'Observaci\u00f3n',
        width:'96%',
        allowBlank :false
    });
   
    /**
     * Ext.form.TextField NOMBRE DEL DOCUMENTO ADJUNTO
     */
    var txtCradj_nombre_adjunto = new Ext.form.TextField({
        id:'txtCradj_nombre_adjunto',
        name:'txtCradj_nombre_adjunto',
        fieldLabel :'Nombre',
        anchor:'100%',
        readOnly:true,
        submitValue:true

    });
    /**
     * ARCHIVO DIGITAL ANEXO
     */
    var filCradj_archivo_adjunto = new Ext.form.FileUploadField({
        id:'filCradj_archivo_adjunto',
        name:'filCradj_archivo_adjunto',
        fieldLabel :'Adjunto',
        disabled :false,
        anchor:'100%',
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        }
    });

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_informe_pareja
     */
    var btnGuardarCgg_res_informe_pareja = new Ext.Button({
        id:'btnGuardarCgg_res_informe_pareja',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){

                try{
                    function CallBackCgg_res_informe_pareja(r){                       
                        winFrmCgg_res_informe_pareja.getEl().unmask();
                        if(typeof(r)=='string'){
                            if (filCradj_archivo_adjunto.getValue())
                                txtCradj_nombre_adjunto.setValue(filCradj_archivo_adjunto.getValue());
                            winFrmCgg_res_informe_pareja.getEl().mask('Guardando...', 'x-mask-loading');
                            pnlCgg_res_Adjunto.getForm().submit({
                                url:URL_WS+"Cgg_res_adjuntoSRV",
                                success:function(fp,o){
                                    winFrmCgg_res_informe_pareja.getEl().unmask();
                                    Ext.Msg.show({
                                        title:tituloCgg_res_informe_pareja,
                                        msg: 'La informaci\u00f3n del Informe pareja ha sido almacenada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    winFrmCgg_res_informe_pareja.close()
                                },
                                failure:function(o){
                                    winFrmCgg_res_informe_pareja.getEl().unmask();
                                    Ext.Msg.show({
                                        title:tituloCgg_res_informe_pareja,
                                        msg: 'La informaci\u00f3n del Informe pareja no ha podido ser almacenada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                },
                                params:{
                                    request:INSENTENCIA_CGG_RES_INFORME_PAREJA,
                                    inCrinf_codigo:(isEdit?txtCrinf_codigo.getValue():r),
                                    inCradj_codigo:(isEdit?tmpCradj_codigo_adjunto:'KEYGEN')

                                }
                            });
                        }
                    }
                    winFrmCgg_res_informe_pareja.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit){
                        param.add('inCrinf_codigo',txtCrinf_codigo.getValue());
                        param.add('inCrofm_codigo',txtCrofm_codigo.getValue());
                    }else
                    {
                        param.add('inCrmtr_codigo',txtCrmtr_codigo.getValue());
                    }
                    param.add('inCrinf_fecha_entrega',dtCrinf_fecha_entrega.getValue().format('c'));
                    param.add('inCrinf_extracto',txtCrinf_extracto.getValue());
                    param.add('inCrinf_numero_documento',txtCrinf_numero_documento.getValue());
                    param.add('inCrinf_observacion',txtCrinf_observacion.getValue());
                    SOAPClient.invoke(urlCgg_res_informe_pareja,INSENTENCIA_CGG_RES_INFORME_PAREJA,param, true, CallBackCgg_res_informe_pareja);
                }catch(inErr){
                    winFrmCgg_res_informe_pareja.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_informe_pareja.
     */
    var btnCancelarCgg_res_informe_pareja = new Ext.Button({
        id:'btnCancelarCgg_res_informe_pareja',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_informe_pareja.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_informe_pareja.
     */
    var btnCerrarCgg_res_informe_pareja = new Ext.Button({
        id:'btnCerrarCgg_res_informe_pareja',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_informe_pareja.close();
            }}
    });
    var pnlCgg_res_Adjunto = new Ext.form.FormPanel({
        id:'pnlCgg_res_Adjunto',
        region:'center',
        labelWidth :90,
        height:90,
          fileUpload:true,
        items:[txtCradj_nombre_adjunto,filCradj_archivo_adjunto]
    });

    var pnlfsCgg_res_Adjunto = new Ext.form.FieldSet({
        id:'pnlfsCgg_res_Adjunto',
        title:'Adjunto',
        collapsible:false,
        region:'center',
        labelWidth :90,
        height:90,
          fileUpload:true,
        items:[pnlCgg_res_Adjunto]
    });

    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_informe_pareja.
     */
    var pnlCgg_res_informe_pareja = new Ext.Panel({
        frame:true,
        labelWidth :100,
        layout:'form',
        items:[txtCrinf_codigo,txtCrinf_numero_documento,
				dtCrinf_fecha_entrega,txtCrinf_extracto,txtCrinf_observacion,pnlfsCgg_res_Adjunto]
    });
    /**
     * Funcion que permite cargar el  codigo del documento generado
     */
    function generarNumeroDocumento(){
        function callBackGenerarNumero(r){
            txtCrinf_numero_documento.setValue(r);
        }
        SOAPClient.invoke(urlCgg_res_informe_pareja,'numeroDocumento',false, false, callBackGenerarNumero);
    }
    generarNumeroDocumento();
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_informe_pareja.
     */
    var winFrmCgg_res_informe_pareja = new Ext.Window({
        id:'winFrmCgg_res_informe_pareja',
        title:tituloCgg_res_informe_pareja,
        tbar:getPanelTitulo(tituloCgg_res_informe_pareja,descCgg_res_informe_pareja),
        items:[pnlCgg_res_informe_pareja],
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        resizable : false,
        constrain:true,
        modal:true,
        bbar:[btnGuardarCgg_res_informe_pareja,btnCancelarCgg_res_informe_pareja,'->',btnCerrarCgg_res_informe_pareja]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_informe_pareja.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_informe_parejaCtrls(inEstado){
        estado=!inEstado;
        txtCrinf_codigo.setDisabled(estado);
        txtCrofm_codigo.setDisabled(estado);
        dtCrinf_fecha_entrega.setDisabled(estado);
        txtCrinf_extracto.setDisabled(estado);
        txtCrinf_numero_documento.setDisabled(estado);
        txtCrinf_observacion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_informe_pareja.
     */
    function cargarCgg_res_informe_parejaCtrls(){
        if(inRecordCgg_res_informe_pareja){
            txtCrinf_codigo.setValue(inRecordCgg_res_informe_pareja.get('CRINF_CODIGO'));
            txtCrofm_codigo.setValue(inRecordCgg_res_informe_pareja.get('CROFM_CODIGO'));
            dtCrinf_fecha_entrega.setValue(truncDate(inRecordCgg_res_informe_pareja.get('CRINF_FECHA_ENTREGA')));
            txtCrinf_extracto.setValue(inRecordCgg_res_informe_pareja.get('CRINF_EXTRACTO'));
            txtCrinf_numero_documento.setValue(inRecordCgg_res_informe_pareja.get('CRINF_NUMERO_DOCUMENTO'));
            txtCrinf_observacion.setValue(inRecordCgg_res_informe_pareja.get('CRINF_OBSERVACION'));
            txtCradj_nombre_adjunto.setValue(inRecordCgg_res_informe_pareja.get('ADJUNTO'));
            tmpCradj_codigo_adjunto=inRecordCgg_res_informe_pareja.get('CODIGO_ADJUNTO');
            isEdit = true;
            habilitarCgg_res_informe_parejaCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_informe_pareja.
     * @returns ventana winFrmCgg_res_informe_pareja.
     * @base FrmCgg_res_informe_pareja.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_informe_pareja;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_informe_pareja.
     * @base FrmCgg_res_informe_pareja.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_informe_parejaCtrls();
    }
    /**
     * Funcion que permite cargar la codigo de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    function cargarCgg_res_matrimonioCtrls(inCodigo){      
            txtCrmtr_codigo.setValue(inCodigo);

        }
    /**
     * Funcion que permite cargar la codgi de los controles de la ventana winFrmListadoCgg_res_matrimonio.
     */
    this.loadMatrimonio = function(inCodigo){
        cargarCgg_res_matrimonioCtrls(inCodigo);		
    }
	
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_informe_pareja desde una instancia.
 */
FrmCgg_res_informe_pareja.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_informe_pareja desde una instancia.
 */
FrmCgg_res_informe_pareja.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_informe_pareja,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_informe_pareja.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_informe_pareja desde una instancia.
 */
FrmCgg_res_informe_pareja.prototype.loadData = function(){
    this.loadData();
}
/**
 * Funcion que permite cargar la codgi de los controles de la ventana winFrmListadoCgg_res_matrimonio.
 */
FrmCgg_res_informe_pareja.prototype.loadMatrimonio = function(){
    this.loadMatrimonio();
}
