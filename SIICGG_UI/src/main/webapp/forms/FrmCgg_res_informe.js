/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_informe.
* @param {String} INSENTENCIA_CGG_RES_INFORME Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} INRECORD_CGG_RES_INFORME Registro de datos de la tabla Cgg_res_informe.
* @constructor
* @base FrmListadoCgg_res_informe
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_res_informe(INSENTENCIA_CGG_RES_INFORME,inCrseg_codigo){
    var tituloCgg_res_informe='Informe';
    var descCgg_res_informe='El formulario permite administrar informaci\u00f3n del informe';
    
    /**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE INFORME
*/
    var txtCrinf_codigo = new Ext.form.TextField({
        id:'txtCrinf_codigo',
        name:'txtCrinf_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
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
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
* IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
*/
    /* var btnCrseg_codigoCgg_res_informe = new Ext.Button({
        id:'btnCrseg_codigoCgg_res_informe',
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
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
* IDENTIFICATIVO UNICO DE REGISTRO SECCION
*/
    /*var btnCrsec_codigoCgg_res_informe = new Ext.Button({
    id:'btnCrsec_codigoCgg_res_informe',
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
        anchor:'60%',
        allowBlank :false,
        maxLength :20
    });
    /**
* Ext.form.DateField FECHA DE REALIZACION DEL INFORME
*/
    var dtCrinf_fecha_informe = new Ext.form.DateField({
        id:'dtCrinf_fecha_informe',
        name:'dtCrinf_fecha_informe',
        fieldLabel :'Fecha',
        allowBlank :false,
        value:CURRENT_DATE,
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
        tableName : 'Cgg_res_informe',
        validateRecordID:true,
        recordID : txtCrinf_codigo.value
    });

    var btnGuardarCgg_res_informe = new Ext.Button({
        id:'btnGuardarCgg_res_informe',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if(validarInforme()==false){
                    return;
                }
                adjunto.recordID = txtCrinf_codigo.value;
                pnlCinfoComponentes.getEl().mask('Guardando...', 'x-mask-loading');
                pnlCgg_res_Adjunto.getForm().submit({
                    url:URL_WS+"InformeAdjuntoSeguimientoSRV",
                    success:function(inForm,inAction){
                        pnlCinfoComponentes.getEl().unmask();                        
                        if(inAction.result.msg.trim()=='true'){
                            Ext.MsgPopup.msg(tituloCgg_res_informe,"El informe ha sido registrado!.", MsgPopup.INFO);
                            //winFrmCgg_res_informe.close()
                        }                        
                    },
                    failure:function(inForm,inAction){
                        pnlCinfoComponentes.getEl().unmask();
                        Ext.MsgPopup.msg(tituloCgg_res_informe,"El informe no pudo ser registrado!.\nError:"+inAction.result.msg, MsgPopup.WARNING);
                    },
                    params:{
                        inOperacion:INSENTENCIA_CGG_RES_INFORME,
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
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_informe.
*/
    var btnCancelarCgg_res_informe = new Ext.Button({
        id:'btnCancelarCgg_res_informe',
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
* Boton que permite cerrar la ventana winFrmCgg_res_informe.
*/
    var btnCerrarCgg_res_informe = new Ext.Button({
        id:'btnCerrarCgg_res_informe',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerrar formulario',
        listeners:{
            click:function(){
                winFrmCgg_res_informe.close();
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
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_informe.
*/
    var winFrmCgg_res_informe = new Ext.Window({
        id:'winFrmCgg_res_informe',
        title:tituloCgg_res_informe,
        tbar:getPanelTitulo(tituloCgg_res_informe,descCgg_res_informe),
        items:[pnlCinfoComponentes],
        width:500,
        minWidth:400,
        resizable:false,
        modal:true,        
        constrain:true,
        bbar:[btnGuardarCgg_res_informe,btnCancelarCgg_res_informe,'->',btnCerrarCgg_res_informe]
    });

    /**
* Funcion miembro que devuelve la ventana winFrmCgg_res_informe.
* @returns ventana winFrmCgg_res_informe.
* @base FrmCgg_res_informe.prototype.show
*/
    this.getWindow = function(){
        return winFrmCgg_res_informe;
    }
    /**
* Funcion miembro que carga los controles de la ventana winFrmCgg_res_informe.
* @base FrmCgg_res_informe.prototype.loadData
*/
    this.loadData = function(){
        cargarCgg_res_informeCtrls();
    }
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_informe desde una instancia.
*/
FrmCgg_res_informe.prototype.show = function(){
    this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_informe desde una instancia.
*/
FrmCgg_res_informe.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_informe,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_res_informe.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_informe desde una instancia.
*/
FrmCgg_res_informe.prototype.loadData = function(){
    this.loadData();
}
