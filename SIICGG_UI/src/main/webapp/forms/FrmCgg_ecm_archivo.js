/**
 * Created by acanaveral on 8/8/16.
 */
function FrmCgg_ecm_archivo(INSENTENCIA_CGG_ECM_ARCHIVO, currentRecord){
    var tituloCgg_ecm_archivo='Gesti\u00f3n de Archivos';
    var descCgg_ecm_archivo='El formulario permite administrar informaci\u00f3n de archivos indexados en Alfresco';
    var urlCgg_ecm_archivo=URL_WS+"Cgg_ecm_archivo";
    var objArchivo = {
                ECMCH_CODIGO : "KEYGEN",
                ECMCH_TIPO : "GENE",
                ECMCH_USUARIO_UPDATE : "",
                ECMCH_UPDATEABLE : true,
                ECMCH_USUARIO_INSERT : "",
                ECMCH_ASUNTO : "",
                ECMCH_FECHA_UPDATE : null,
                ECMCH_FECHA_INSERT : null,
                ECMCH_ESTADO : "",
                ECMCH_FECHA : null,
                ECMCH_DESCRIPCION : "",
                ECMCH_EXTRACTO : ""
            };

    var readOnly = false;
    if(currentRecord) {
        readOnly = !currentRecord.get('ECMCH_UPDATEABLE');
        objArchivo = currentRecord.json;
    }
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE INFORME
     */
    var txtEcmch_codigo = new Ext.form.TextField({
        id:'txtEcmch_codigo',
        name:'txtEcmch_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        disabled : readOnly,
        value:(objArchivo!=null?objArchivo.ECMCH_CODIGO:null)!=null?objArchivo.ECMCH_CODIGO:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });

    /**
     * Ext.form.TextField NUMERO DE INFORME DE RESPUESTA AL SEGUIMIENTO
     */

    var dsTipoArchivo = new Ext.data.ArrayStore({
        fields: ['code', 'name'],
        idIndex: 0
    });
    dsTipoArchivo.loadData(tipoArchivo);
    var cbxEcmch_tipo = new Ext.form.ComboBox({
        id:"cbxEcmch_tipo",
        store:dsTipoArchivo,
        fieldLabel :'Tipo de documento',
        displayField : 'name',
        disabled : readOnly,
        valueField : 'code',
        triggerAction:'all',
        mode: 'local',
        forceSelection:true,
        value: (objArchivo!=null?objArchivo.ECMCH_TIPO:null)!=null?objArchivo.ECMCH_TIPO:null,
        anchor:'50%'
    });

    /*
    var txtEcmch_tipo = new Ext.form.TextField({
        id:'txtEcmch_tipo',
        name:'txtEcmch_tipo',
        fieldLabel :'Tipo',
        disabled : readOnly,
        value:(currentRecord!=null?currentRecord.get('ECMCH_TIPO'):null)!=null?currentRecord.get('ECMCH_TIPO'):null,
        readOnly:((currentRecord!=null?currentRecord.get('ECMCH_TIPO'):null)!=null?true:false),
        anchor:'60%',
        allowBlank :false,
        maxLength :20
    });
    */
    var chkEcmch_updateable = new Ext.form.Checkbox({
        id:'chkEcmch_updateable',
        name:'chkEcmch_updateable',
        fieldLabel :'Editable',
        disabled : readOnly,
        checked : (objArchivo!=null?objArchivo.ECMCH_UPDATEABLE:null)!=null?objArchivo.ECMCH_UPDATEABLE:true
    });

    /**
     * Ext.form.DateField FECHA DE REALIZACION DEL INFORME
     */
    var selectedDate = (objArchivo!=null?objArchivo.ECMCH_FECHA:null);
    console.log("SelectedDate: "+selectedDate);
    if(selectedDate!=null)
        selectedDate = selectedDate.split(" ")[0].split('-').reverse().join('/');
    else
        selectedDate = CURRENT_DATE;

    var dtEcmch_fecha = new Ext.form.DateField({
        id:'dtEcmch_fecha',
        name:'dtEcmch_fecha',
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
    var txtEcmch_asunto = new Ext.form.TextField({
        id:'txtEcmch_asunto',
        name:'txtEcmch_asunto',
        fieldLabel :'Asunto',
        anchor:'98%',
        disabled : readOnly,
        value:(objArchivo!=null?objArchivo.ECMCH_ASUNTO:null)!=null?objArchivo.ECMCH_ASUNTO:null,
        allowBlank :true,
        maxLength :100
    });
    /**
     * Ext.form.TextArea RESUMEN DEL CONTENIDO DEL INFORME
     */
    var txtEcmch_extracto = new Ext.form.HtmlEditor({
        id:'txtEcmch_extracto',
        name:'txtEcmch_extracto',
        fieldLabel :'Extracto',
        anchor:'98%',
        disabled : readOnly,
        value:(objArchivo!=null?objArchivo.ECMCH_EXTRACTO:null)!=null?objArchivo.ECMCH_EXTRACTO:null,
        enableFontSize:false,
        enableLinks:false,
        height:100,
        allowBlank:false
    });
    /**
     * Ext.form.TextField DESCRIPCION DE LOS DOCUMENTOS DIGITALIZADOS ADJUNTOS EN EL SEGUIMIENTO
     */
    var txtEcmch_descripcion = new Ext.form.TextArea({
        id:'txtEcmch_descripcion',
        name:'txtEcmch_descripcion',
        fieldLabel :'Descripci\u00F3n',
        disabled : readOnly,
        value:(objArchivo!=null?objArchivo.ECMCH_DESCRIPCION:null)!=null?objArchivo.ECMCH_DESCRIPCION:null,
        anchor:'98%'
    });

    function validarInforme(){
        var flag = true;

        if(cbxEcmch_tipo.getValue()== undefined || cbxEcmch_tipo.getValue()==null || cbxEcmch_tipo.getValue().trim().length ==0){
            cbxEcmch_tipo.markInvalid("Establezca el tipo de archivo, por favor.");
            flag =false;
        }

        if(txtEcmch_asunto.getValue()== undefined || txtEcmch_asunto.getValue()==null || txtEcmch_asunto.getValue().trim().length ==0){
            txtEcmch_asunto.markInvalid("Establezca el asunto del archivo, por favor.");
            flag =false;
        }

        if(txtEcmch_extracto.getValue()== undefined || txtEcmch_extracto.getValue()==null || txtEcmch_extracto.getValue().trim().length ==0){
            txtEcmch_extracto.markInvalid("Establezca un extracto del archivo, por favor.");
            flag =false;
        }
        return flag;
    }

    var adjunto = new Ext.ux.form.AlfrescoFM({
        id:'compAdjunto_ecm_archivo',  //(opcional)
        name:'compAdjunto_ecm_archivo',       //(opcional)
        fieldLabel :'Adjuntos',         //(opcional -> Despliega la etiqueta del comoponente. Si no se define, aparece solo el botón)
        text: 'Adjunto',                //(opcional -> Texto del botón)
        tableName : 'Cgg_ecm_archivo',
        isReadOnly: readOnly,
        validateRecordID:true,
        recordID : txtEcmch_codigo.value
    });

    adjunto.addListener("updateData",function(t){
        t.recordID = null;
        t.recordID = txtEcmch_codigo.value;
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

                objArchivo.ECMCH_CODIGO         =   txtEcmch_codigo.getValue();
                objArchivo.ECMCH_TIPO           =   cbxEcmch_tipo.getValue();
                objArchivo.ECMCH_ASUNTO         =   txtEcmch_asunto.getValue();
                objArchivo.ECMCH_EXTRACTO       =   txtEcmch_extracto.getValue();
                objArchivo.ECMCH_DESCRIPCION    =   txtEcmch_descripcion.getValue();
                objArchivo.ECMCH_FECHA          =   dtEcmch_fecha.getValue().format('Y-m-d');
                objArchivo.ECMCH_UPDATEABLE     =   chkEcmch_updateable.getValue();

                try{
                    function CallBackCgg_ecm_archivo(r){
                        pnlCinfoComponentes.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_especialidad,
                                msg: 'El archivo ha sido registrado!.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_especialidad.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_especialidad,
                                msg: 'El archivo no pudo ser registrado!.\nError:'+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    var param = new SOAPClientParameters();
                    param.add("in_objEcmch",JSON.stringify(objArchivo));
                    SOAPClient.invoke(urlCgg_ecm_archivo,INSENTENCIA_CGG_ECM_ARCHIVO,param, true, CallBackCgg_ecm_archivo);
                }catch(inErr){
                    pnlCinfoComponentes.getEl().unmask();
                    Ext.MsgPopup.msg(tituloCgg_ecm_archivo,"El archivo no pudo ser registrado!", MsgPopup.WARNING);
                }
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
        height:100,
        fileUpload:true,
        items:[adjunto]
        //items:[filCrinfo_archivo_adjunto,txtEcmch_descripcion]
    });

    var pnlfsCgg_res_Adjunto = new Ext.form.FieldSet({
        id:'pnlCgg_res_Adjunto',
        title:'Adjuntos',
        region:'center',
        height:60,
        items:[pnlCgg_res_Adjunto]
    });

    var pnlCinfoComponentes = new Ext.Panel({
        id:'pnlCinfoComponentes',
        frame:true,
        layout:'form',
        items:[cbxEcmch_tipo,chkEcmch_updateable,dtEcmch_fecha,txtEcmch_asunto,txtEcmch_descripcion,txtEcmch_extracto,pnlfsCgg_res_Adjunto]
    });

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_ecm_archivo.
     */
    var winFrmCgg_ecm_archivo = new Ext.Window({
        id:'winFrmCgg_ecm_archivo',
        title:tituloCgg_ecm_archivo,
        tbar:getPanelTitulo(tituloCgg_ecm_archivo,descCgg_ecm_archivo),
        items:[pnlCinfoComponentes],
        width:800,
        minWidth:500,
        resizable:true,
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
        //cargarCgg_ecm_archivoCtrls();
        console.log("Controls");
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