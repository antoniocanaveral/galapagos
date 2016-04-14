/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_adjunto.
 * @constructor
 * @base FrmListadoCgg_res_adjunto
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_adjunto(inCrrqt_codigo,inCradj_codigo,inCrseg_codigo){
    var urlCgg_res_adjunto=URL_WS+"Cgg_res_adjunto";
    var tituloCgg_res_adjunto='Archivo adjunto';
    var descCgg_res_adjunto='El formulario permite administrar subir archivos adjuntos.';
    var dialogResult = null;
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCradj_codigo = new Ext.form.TextField({
        id:'txtCradj_codigo',
        name:'txtCradj_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO PERSONA
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        submitValue:false,
        allowBlank:false
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO PERSONA
     */
    var btnCrper_codigoCgg_res_adjunto = new Ext.Button({
        id:'btnCrper_codigoCgg_res_adjunto',
        text:'Crper_codigo',
        iconCls:'iconCrper_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_res_persona = new FrmListadoCgg_res_persona();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpDependencias['PERSONA'] = tmpRecord.get('CRPER_CODIGO');
                        txtCrper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+' '+tmpRecord.get('CRPER_APELLIDO_PATERNO')+' '+tmpRecord.get('CRPER_APELLIDO_MATERNO'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE INFORME
     */
    var txtCrinf_codigo = new Ext.form.TextField({
        id:'txtCrinf_codigo',
        name:'txtCrinf_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        submitValue:false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE INFORME
     */
    var btnCrinf_codigoCgg_res_adjunto = new Ext.Button({
        id:'btnCrinf_codigoCgg_res_adjunto',
        text:'Crinf_codigo',
        iconCls:'iconCrinf_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_res_informe_pareja = new FrmListadoCgg_res_informe_pareja();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_informe_pareja.getStore(),tmpFLCgg_res_informe_pareja.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpDependencias['PAREJA'] = tmpRecord.get('CRINF_CODIGO');
                        txtCrinf_codigo.setValue(tmpRecord.get('CRINF_EXTRACTO'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO NOTIFICACION
     */
    var txtCrnot_codigo = new Ext.form.TextField({
        id:'txtCrnot_codigo',
        name:'txtCrnot_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        submitValue:false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO NOTIFICACION
     */
    var btnCrnot_codigoCgg_res_adjunto = new Ext.Button({
        id:'btnCrnot_codigoCgg_res_adjunto',
        text:'Crnot_codigo',
        iconCls:'iconCrnot_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_res_notificacion = new FrmListadoCgg_res_notificacion();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_notificacion.getStore(),tmpFLCgg_res_notificacion.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpDependencias['NOTIFICACION'] = tmpRecord.get('CRNOT_CODIGO');
                        txtCrnot_codigo.setValue(tmpRecord.get('CRNOT_NUMERO_NOTIFICACION'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
     */
    var txtCrres_codigo = new Ext.form.TextField({
        id:'txtCrres_codigo',
        name:'txtCrres_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        submitValue:false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
     */
    var btnCrres_codigoCgg_res_adjunto = new Ext.Button({
        id:'btnCrres_codigoCgg_res_adjunto',
        text:'Crres_codigo',
        iconCls:'iconCrres_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_res_resolucion = new FrmListadoCgg_res_resolucion();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_resolucion.getStore(),tmpFLCgg_res_resolucion.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpDependencias['RESOLUCION'] = tmpRecord.get('CRRES_CODIGO');
                        txtCrres_codigo.setValue(tmpRecord.get('CRRES_NUMERO_RESOLUCION'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO GARANTIA
     */
    var txtCrdpt_codigo = new Ext.form.TextField({
        id:'txtCrdpt_codigo',
        name:'txtCrdpt_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        submitValue:false
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO GARANTIA
     */
    var btnCrdpt_codigoCgg_res_adjunto = new Ext.Button({
        id:'btnCrdpt_codigoCgg_res_adjunto',
        text:'Crdpt_codigo',
        iconCls:'iconCrdpt_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_res_deposito_garantia = new FrmListadoCgg_res_deposito_garantia();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_deposito_garantia.getStore(),tmpFLCgg_res_deposito_garantia.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpDependencias['GARANTIA'] = tmpRecord.get('CRDPT_CODIGO');
                        txtCrdpt_codigo.setValue(tmpRecord.get('CRDPT_NUMERO_DOCUMENTO'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
     */
    var txtCrseg_codigo = new Ext.form.TextField({
        id:'txtCrseg_codigo',
        name:'txtCrseg_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        submitValue:false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
     */
    var btnCrseg_codigoCgg_res_adjunto = new Ext.Button({
        id:'btnCrseg_codigoCgg_res_adjunto',
        text:'Crseg_codigo',
        iconCls:'iconCrseg_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_res_seguimiento = new FrmListadoCgg_res_seguimiento();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_seguimiento.getStore(),tmpFLCgg_res_seguimiento.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpDependencias['SEGUIMIENTO'] = tmpRecord.get('CRSEG_CODIGO');
                        txtCrseg_codigo.setValue(tmpRecord.get('CRSEG_CODIGO'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
     */
    var txtCrtpt_codigo = new Ext.form.TextField({
        id:'txtCrtpt_codigo',
        name:'txtCrtpt_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank:false,
        submitValue:false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
     */
    var btnCrtpt_codigoCgg_res_adjunto = new Ext.Button({
        id:'btnCrtpt_codigoCgg_res_adjunto',
        text:'Crtpt_codigo',
        iconCls:'iconCrtpt_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_res_tipo_tramite = new FrmListadoCgg_res_tipo_tramite();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_tipo_tramite.getStore(),tmpFLCgg_res_tipo_tramite.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpDependencias['TRAMITE'] = tmpRecord.get('CRTPT_CODIGO');
                        txtCrtpt_codigo.setValue(tmpRecord.get('CRTPT_NOMBRE'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextArea DESCRIPCION DEL CONTENIDO DEL ARCHIVO
     */
    var txtCradj_contenido = new Ext.form.TextArea({
        id:'txtCradj_contenido',
        name:'txtCradj_contenido',
        fieldLabel :'Contenido',
        width:'90%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField NOMBRE DEL DOCUMENTO ADJUNTO
     */
    var txtCradj_nombre_adjunto = new Ext.form.TextField({
        id:'txtCradj_nombre_adjunto',
        name:'txtCradj_nombre_adjunto',
        fieldLabel :'Nombre adjunto',
        anchor:'98%',
        readOnly:true
    });
    /**
     * Ext.form.TextField OBSERVACION DEL ARCHIVO ADJUNTO
     */
    var txtCradj_observacion = new Ext.form.TextArea({
        id:'txtCradj_observacion',
        name:'txtCradj_observacion',
        fieldLabel :'Observaci\u00f3n',
        anchor:'98%'
    });
    /**
     * ARCHIVO DIGITAL ANEXO
     */
    var filCradj_archivo_adjunto = new Ext.form.FileUploadField({
        id:'filCradj_archivo_adjunto',
        name:'filCradj_archivo_adjunto',
        fieldLabel :'Archivo adjunto',
        disabled :false,
        anchor:'98%',
        allowBlank:false,
        blankText:'Establezca el adjunto, por favor.',
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        }
    });
    /**
     * Ext.form.DateField FECHA DE REGISTRO DEL ARCHIVO EN EL SISTEMA
     */
    var dtCradj_fecha_registro = new Ext.form.DateField({
        id:'dtCradj_fecha_registro',
        name:'dtCradj_fecha_registro',
        fieldLabel :'Fecha registro',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_adjunto
     */
    var btnGuardarCgg_res_adjunto = new Ext.Button({
        id:'btnGuardarCgg_res_adjunto',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(inThis,inEvent){
                dialogResult = inThis.getText();
                if (pnlCgg_res_adjunto.getForm().isValid()==false){
                    return;
                }
                pnlCgg_res_adjunto.getEl().mask('Guardando...', 'x-mask-loading');
                pnlCgg_res_adjunto.getForm().submit({
                    url: URL_WS+"Cgg_res_adjuntoSRV",
                    success:function(inForm,inAction){
                        pnlCgg_res_adjunto.getEl().unmask();
                        if(inAction.result.msg=='true'){
                            Ext.MsgPopup.msg(tituloCgg_res_adjunto, "Su archivo adjunto ha sido guardado.",MsgPopup.INFO);
                            winFrmCgg_res_adjunto.close();
                        }else{
                            Ext.MsgPopup.msg(tituloCgg_res_adjunto, "Su archivo adjunto no ha sido guardado.\nError:"+inAction.result.msg,MsgPopup.WARNING);
                        }
                    },
                    failure:function(inForm,inAction){
                        pnlCgg_res_adjunto.getEl().unmask();
                        Ext.MsgPopup.msg(tituloCgg_res_adjunto, "Su archivo adjunto no ha sido guardado.\nError:"+inAction.result.msg,MsgPopup.WARNING);
                    },
                    params:{
                        inCradj_codigo:inCradj_codigo,
                        inCrrqt_codigo:inCrrqt_codigo,
                        inCrseg_codigio:inCrseg_codigo
                    }
                });
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_adjunto.
     */
    var btnCancelarCgg_res_adjunto = new Ext.Button({
        id:'btnCancelarCgg_res_adjunto',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){                
                pnlCgg_res_adjunto.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_adjunto.
     */
    var btnCerrarCgg_res_adjunto = new Ext.Button({
        id:'btnCerrarCgg_res_adjunto',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(inThis){
                dialogResult = inThis.getText();
                winFrmCgg_res_adjunto.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_adjunto.
     */
    var pnlCgg_res_adjunto = new Ext.form.FormPanel({
        id:'pnlCgg_res_adjunto',
        frame:true,
        fileUpload:true,
        labelWidth :100,
        items:[filCradj_archivo_adjunto,txtCradj_observacion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_adjunto.
     */
    var winFrmCgg_res_adjunto = new Ext.Window({
        id:'winFrmCgg_res_adjunto',
        title:tituloCgg_res_adjunto,
        tbar:getPanelTitulo(tituloCgg_res_adjunto,descCgg_res_adjunto),
        items:[pnlCgg_res_adjunto],
        width:400,
        minWidth:400,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_res_adjunto,btnCancelarCgg_res_adjunto,'->',btnCerrarCgg_res_adjunto]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_adjunto.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_adjuntoCtrls(inEstado){
        estado=!inEstado;
        txtCradj_codigo.setDisabled(estado);
        txtCrper_codigo.setDisabled(estado);
        txtCrinf_codigo.setDisabled(estado);
        txtCrnot_codigo.setDisabled(estado);
        txtCrres_codigo.setDisabled(estado);
        txtCrdpt_codigo.setDisabled(estado);
        txtCrseg_codigo.setDisabled(estado);
        txtCrtpt_codigo.setDisabled(estado);
        txtCradj_contenido.setDisabled(estado);
        txtCradj_nombre_adjunto.setDisabled(estado);
        txtCradj_observacion.setDisabled(estado);
        filCradj_archivo_adjunto.setDisabled(estado);
        dtCradj_fecha_registro.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_adjunto.
     */
    function cargarCgg_res_adjuntoCtrls(){
        if(inRecordCgg_res_adjunto){
            tmpDependencias['PERSONA'] = inRecordCgg_res_adjunto.get('CRPER_CODIGO');
            tmpDependencias['TRAMITE'] = inRecordCgg_res_adjunto.get('CRTPT_CODIGO');
            txtCradj_codigo.setValue(inRecordCgg_res_adjunto.get('CRADJ_CODIGO'));
            txtCrper_codigo.setValue(inRecordCgg_res_adjunto.get('PERSONA'));
            txtCrinf_codigo.setValue(inRecordCgg_res_adjunto.get('CRINF_CODIGO'));
            txtCrnot_codigo.setValue(inRecordCgg_res_adjunto.get('CRNOT_CODIGO'));
            txtCrres_codigo.setValue(inRecordCgg_res_adjunto.get('CRRES_CODIGO'));
            txtCrdpt_codigo.setValue(inRecordCgg_res_adjunto.get('CRDPT_CODIGO'));
            txtCrseg_codigo.setValue(inRecordCgg_res_adjunto.get('CRSEG_CODIGO'));
            txtCrtpt_codigo.setValue(inRecordCgg_res_adjunto.get('TRAMITE'));
            txtCradj_contenido.setValue(inRecordCgg_res_adjunto.get('CRADJ_CONTENIDO'));
            txtCradj_nombre_adjunto.setValue(inRecordCgg_res_adjunto.get('CRADJ_NOMBRE_ADJUNTO'));
            txtCradj_observacion.setValue(inRecordCgg_res_adjunto.get('CRADJ_OBSERVACION'));
            dtCradj_fecha_registro.setValue(truncDate(inRecordCgg_res_adjunto.get('CRADJ_FECHA_REGISTRO')));
            isEdit = true;
            habilitarCgg_res_adjuntoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_adjunto.
     * @returns ventana winFrmCgg_res_adjunto.
     * @base FrmCgg_res_adjunto.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_adjunto;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_adjunto.
     * @base FrmCgg_res_adjunto.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_adjuntoCtrls();
    }

	this.dialogResult = function(){
		return dialogResult;
	}
}

/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_adjunto desde una instancia.
 */
FrmCgg_res_adjunto.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_adjunto desde una instancia.
 */
FrmCgg_res_adjunto.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_adjunto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_adjunto.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_adjunto desde una instancia.
 */
FrmCgg_res_adjunto.prototype.loadData = function(){
    this.loadData();
}

/**
 * Funcion prototipo. Devuelve el resultado de la subida de un adjunto.
 */
FrmCgg_res_adjunto.prototype.dialogResult= function(){
    return this.dialogResult();
}
