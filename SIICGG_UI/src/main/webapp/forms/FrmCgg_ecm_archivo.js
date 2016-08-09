/**
 * Created by acanaveral on 8/8/16.
 */
function FrmCgg_ecm_archivo(INSENTENCIA_CGG_ECM_ARCHIVO, inCrseg_codigo, currentRecord, isReadOnly){
    var tituloCgg_ecm_archivo='Informe';
    var descCgg_ecm_archivo='El formulario permite administrar informaci\u00f3n del informe';
    var readOnly = (isReadOnly!=null && isReadOnly==true)?true:false;

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE INFORME
     */
    var txtCrinf_codigo = new Ext.form.TextField({
        id:'txtCrinf_codigo',
        name:'txtCrinf_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        disabled : readOnly,
        value:(currentRecord!=null?currentRecord.get('CRISE_CODIGO'):null)!=null?currentRecord.get('CRISE_CODIGO'):"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
     */
    var txtCrseg_codigo = new Ext.form.TextField({
        id:'txtCrseg_codigo',
        name:'txtCrseg_codigo',
        fieldLabel :'Seguimiento',
        anchor:'98%',
        disabled : readOnly,
        value: (currentRecord!=null?currentRecord.get('CRSEG_CODIGO'):null)!=null?currentRecord.get('CRSEG_CODIGO'):null,
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
     */
    /* var btnCrseg_codigoCgg_ecm_archivo = new Ext.Button({
     id:'btnCrseg_codigoCgg_ecm_archivo',
     iconCls:'iconBuscar',
     listeners:{
     click:function(){
     var tmpFLCgg_res_seguimiento = new FrmListadoCgg_res_seguimiento();
     var objBusqueda = new DlgBusqueda(tmpFLCgg_res_seguimiento.getStore(),tmpFLCgg_res_seguimiento.getColumnModel());
     objBusqueda.closeHandler(function(){
     var tmpRecord = objBusqueda.getSelectedRow();
     if(tmpRecord!=null && tmpRecord!=undefined)
     {
     txtCrseg_codigo.setValue(tmpRecord.get('CRSEG_NOMBRE'));
     tmpSeguimiento=tmpRecord.get('CRSEG_CODIGO');
     }
     });
     objBusqueda.show();
     }
     }
     });*/
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO SECCION
     */
    var txtCrsec_codigo = new Ext.form.TextField({
        id:'txtCrsec_codigo',
        name:'txtCrsec_codigo',
        fieldLabel :'Seccci\u00F3n',
        anchor:'98%',
        disabled : readOnly,
        value:(currentRecord!=null?currentRecord.get('CRSEC_CODIGO'):null)!=null?currentRecord.get('CRSEC_CODIGO'):null,
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO SECCION
     */
    /*var btnCrsec_codigoCgg_ecm_archivo = new Ext.Button({
     id:'btnCrsec_codigoCgg_ecm_archivo',
     iconCls:'iconBuscar',
     listeners:{
     click:function(){
     var tmpFLCgg_res_seccion = new FrmListadoCgg_res_seccion();
     var objBusqueda = new DlgBusqueda(tmpFLCgg_res_seccion.getStore(),tmpFLCgg_res_seccion.getColumnModel());
     objBusqueda.closeHandler(function(){
     var tmpRecord = objBusqueda.getSelectedRow();
     if(tmpRecord!=null && tmpRecord!=undefined)
     {
     txtCrsec_codigo.setValue(tmpRecord.get('CRSEC_NOMBRE'));
     tmpSeccion=tmpRecord.get('CRSEC_CODIGO');
     }
     });
     objBusqueda.show();
     }
     }
     });*/
    /**
     * Ext.form.TextField NUMERO DE INFORME DE RESPUESTA AL SEGUIMIENTO
     */
    var txtCrinf_numero_informe = new Ext.form.TextField({
        id:'txtCrinf_numero_informe',
        name:'txtCrinf_numero_informe',
        fieldLabel :'N\u00FAmero',
        disabled : readOnly,
        value:(currentRecord!=null?currentRecord.get('CRISE_NUMERO_INFORME'):null)!=null?currentRecord.get('CRISE_NUMERO_INFORME'):null,
        readOnly:((currentRecord!=null?currentRecord.get('CRISE_NUMERO_INFORME'):null)!=null?true:false),
        anchor:'60%',
        allowBlank :false,
        maxLength :20
    });
    /**
     * Ext.form.DateField FECHA DE REALIZACION DEL INFORME
     */
    var selectedDate = (currentRecord!=null?currentRecord.get('CRISE_FECHA_INFORME'):null);
    console.log("SelectedDate: "+selectedDate);
    if(selectedDate!=null)
        selectedDate = selectedDate.split(" ")[0].split('-').reverse().join('/');
    else
        selectedDate = CURRENT_DATE;

    var dtCrinf_fecha_informe = new Ext.form.DateField({
        id:'dtCrinf_fecha_informe',
        name:'dtCrinf_fecha_informe',
        fieldLabel :'Fecha',
        allowBlank :false,
        disabled : readOnly,
        value: selectedDate,
        format:'d/m/Y',
        maxValue:CURRENT_DATE
    });
    /**
     * Ext.form.TextField ASUNTO DEL INFORME
     */
    var txtCrinf_asunto_informe = new Ext.form.TextField({
        id:'txtCrinf_asunto_informe',
        name:'txtCrinf_asunto_informe',
        fieldLabel :'Asunto',
        anchor:'98%',
        disabled : readOnly,
        value:(currentRecord!=null?currentRecord.get('CRISE_ASUNTO_INFORME'):null)!=null?currentRecord.get('CRISE_ASUNTO_INFORME'):null,
        allowBlank :true,
        maxLength :100
    });
    /**
     * Ext.form.TextArea RESUMEN DEL CONTENIDO DEL INFORME
     */
    var txtCrinf_extracto_informe = new Ext.form.HtmlEditor({
        id:'txtCrinf_extracto_informe',
        name:'txtCrinf_extracto_informe',
        fieldLabel :'Extracto',
        anchor:'98%',
        disabled : readOnly,
        value:(currentRecord!=null?currentRecord.get('CRISE_EXTRACTO_INFORME'):null)!=null?currentRecord.get('CRISE_EXTRACTO_INFORME'):null,
        enableFontSize:false,
        enableLinks:false,
        height:100,
        allowBlank:false
    });
    /**
     * Ext.form.TextField DESCRIPCION DE LOS DOCUMENTOS DIGITALIZADOS ADJUNTOS EN EL SEGUIMIENTO
     */
    var txtCrinf_descripcion_adjunto = new Ext.form.TextArea({
        id:'txtCrinf_descripcion_adjunto',
        name:'txtCrinf_descripcion_adjunto',
        fieldLabel :'Descripci\u00F3n',
        anchor:'100%'
    });
    /**
     * ARCHIVO DIGITAL ANEXO
     */
    var filCrinfo_archivo_adjunto = new Ext.form.FileUploadField({
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

    function validarInforme(){
        var flag = true;

        if(txtCrinf_numero_informe.getValue()== undefined || txtCrinf_numero_informe.getValue()==null || txtCrinf_numero_informe.getValue().trim().length ==0){
            txtCrinf_numero_informe.markInvalid("Establezca el numero de informe, por favor.");
            flag =false;
        }

        if(txtCrinf_asunto_informe.getValue()== undefined || txtCrinf_asunto_informe.getValue()==null || txtCrinf_asunto_informe.getValue().trim().length ==0){
            txtCrinf_asunto_informe.markInvalid("Establezca el asunto del informe, por favor.");
            flag =false;
        }

        if(txtCrinf_extracto_informe.getValue()== undefined || txtCrinf_extracto_informe.getValue()==null || txtCrinf_extracto_informe.getValue().trim().length ==0){
            txtCrinf_extracto_informe.markInvalid("Establezca un extracto del informe, por favor.");
            flag =false;
        }
        return flag;
    }

    var adjunto = new Ext.ux.form.AlfrescoFM({
        id:'compAdjunto',  //(opcional)
        name:'compAdjunto',       //(opcional)
        fieldLabel :'Adjuntos',         //(opcional -> Despliega la etiqueta del comoponente. Si no se define, aparece solo el botón)
        text: 'Adjunto',                //(opcional -> Texto del botón)
        tableName : 'Cgg_ecm_archivo_seguimiento',
        isReadOnly: readOnly,
        validateRecordID:true,
        recordID : txtCrinf_codigo.value
    });

    var btnGuardarCgg_ecm_archivo = new Ext.Button({
        id:'btnGuardarCgg_ecm_archivo',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if(validarInforme()==false){
                    return;
                }
                pnlCinfoComponentes.getEl().mask('Guardando...', 'x-mask-loading');
                pnlCgg_res_Adjunto.getForm().submit({
                    url:URL_WS+"InformeAdjuntoSeguimientoSRV",
                    success:function(inForm,inAction){
                        pnlCinfoComponentes.getEl().unmask();
                        var res = inAction.result.msg.trim().split(",");
                        if(res[0]=='true'){
                            Ext.MsgPopup.msg(tituloCgg_ecm_archivo,"El informe ha sido registrado!.", MsgPopup.INFO);
                            if(res.length>1) {
                                INSENTENCIA_CGG_ECM_ARCHIVO = "update";
                                adjunto.recordID = res[1];
                            }
                            //winFrmCgg_ecm_archivo.close()
                        }
                    },
                    failure:function(inForm,inAction){
                        pnlCinfoComponentes.getEl().unmask();
                        Ext.MsgPopup.msg(tituloCgg_ecm_archivo,"El informe no pudo ser registrado!.\nError:"+inAction.result.msg, MsgPopup.WARNING);
                    },
                    params:{
                        inOperacion:INSENTENCIA_CGG_ECM_ARCHIVO,
                        inCrise_codigo:txtCrinf_codigo.getValue(),
                        inCrseg_codigo:inCrseg_codigo,
                        inCrise_numero_informe:txtCrinf_numero_informe.getValue(),
                        inCrise_fecha_informe:dtCrinf_fecha_informe.getValue().format('d/m/Y'),
                        inCrise_asunto_informe:txtCrinf_asunto_informe.getValue(),
                        inCrise_extracto_informe:txtCrinf_extracto_informe.getValue(),
                        inCrise_descripcion_adjunto:txtCrinf_descripcion_adjunto.getValue()
                    }
                });
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_ecm_archivo.
     */
    var btnCancelarCgg_ecm_archivo = new Ext.Button({
        id:'btnCancelarCgg_ecm_archivo',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:'Cancelar informaci\u00F3',
        listeners:{
            click:function(){
                pnlCinfoComponentes.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_ecm_archivo.
     */
    var btnCerrarCgg_ecm_archivo = new Ext.Button({
        id:'btnCerrarCgg_ecm_archivo',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerrar formulario',
        listeners:{
            click:function(){
                winFrmCgg_ecm_archivo.close();
            }
        }
    });

    var pnlCgg_res_Adjunto = new Ext.form.FormPanel({
        id:'pnlCgg_res_Adjunto',
        region:'center',
        labelWidth :90,
        height:130,
        fileUpload:true,
        items:[adjunto]
        //items:[filCrinfo_archivo_adjunto,txtCrinf_descripcion_adjunto]
    });

    var pnlfsCgg_res_Adjunto = new Ext.form.FieldSet({
        id:'pnlCgg_res_Adjunto',
        title:'Adjunto del informe',
        region:'center',
        height:122,
        items:[pnlCgg_res_Adjunto]
    });

    var pnlCinfoComponentes = new Ext.Panel({
        id:'pnlCinfoComponentes',
        frame:true,
        layout:'form',
        items:[txtCrinf_numero_informe,dtCrinf_fecha_informe,txtCrinf_asunto_informe,txtCrinf_extracto_informe,pnlfsCgg_res_Adjunto]
    });

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_ecm_archivo.
     */
    var winFrmCgg_ecm_archivo = new Ext.Window({
        id:'winFrmCgg_ecm_archivo',
        title:tituloCgg_ecm_archivo,
        tbar:getPanelTitulo(tituloCgg_ecm_archivo,descCgg_ecm_archivo),
        items:[pnlCinfoComponentes],
        width:500,
        minWidth:400,
        resizable:false,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_ecm_archivo,btnCancelarCgg_ecm_archivo,'->',btnCerrarCgg_ecm_archivo]
    });

    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_ecm_archivo.
     * @returns ventana winFrmCgg_ecm_archivo.
     * @base FrmCgg_ecm_archivo.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_ecm_archivo;
    };
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_ecm_archivo.
     * @base FrmCgg_ecm_archivo.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_ecm_archivoCtrls();
    };
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_ecm_archivo desde una instancia.
 */
FrmCgg_ecm_archivo.prototype.show = function(){
    this.getWindow().show();
};
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_ecm_archivo desde una instancia.
 */
FrmCgg_ecm_archivo.prototype.close = function(){
    this.getWindow().close();
};
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_ecm_archivo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_ecm_archivo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
};
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_ecm_archivo desde una instancia.
 */
FrmCgg_ecm_archivo.prototype.loadData = function(){
    this.loadData();
};