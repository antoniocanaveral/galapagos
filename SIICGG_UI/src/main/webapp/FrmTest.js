/**
 * Created by acanaveral on 20/5/16.
 */


function FrmTest(inCRSEG_CODIGO){

    var tituloCgg_res_adjunto='Documento adjunto';
    var descCgg_res_adjunto='El formulario permite subir sus archivos adjuntos';

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
    /*var filCradj_archivo_adjunto = new Ext.form.FileUploadField({
        id:'filCradj_archivo_adjunto',
        name:'filCradj_archivo_adjunto',
        fieldLabel :'Archivo adjunto',
        disabled :false,
        anchor:'98%',
        allowBlank:false,
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        }
    });*/
    var filCradj_archivo_adjunto = new Ext.ux.form.AlfrescoFM({
        id:'filCradj_archivo_adjunto',
        name:'filCradj_archivo_adjunto',
        fieldLabel :'Adjuntos',
        text: 'Adjunto',
        tableName : 'Tabla',
        recordID : '1'
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmTest
     */
    var btnGuardarCgg_res_adjunto = new Ext.Button({
        id:'btnGuardarCgg_res_adjunto',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_adjunto.getForm().isValid()==false){
                    return;
                }
                pnlCgg_res_adjunto.getEl().mask('Guardando...', 'x-mask-loading');
                pnlCgg_res_adjunto.getForm().submit({
                    url:URL_WS+"SubirAdjuntoSeguimientoSRV",
                    success:function(inForm,inAction){
                        pnlCgg_res_adjunto.getEl().unmask();
                        if(inAction.result.msg.trim()=='true'){
                            Ext.MsgPopup.msg(tituloCgg_res_adjunto, "Su archivo adjunto ha sido guardado.",MsgPopup.INFO);
                            winFrmTest.close();
                        }else{
                            Ext.MsgPopup.msg(tituloCgg_res_adjunto, "Su archivo adjunto no ha sido guardado.\nError:"+inAction.result.msg,MsgPopup.WARNING);
                        }
                    },
                    failure:function(inForm,inAction){
                        pnlCgg_res_adjunto.getEl().unmask();
                        Ext.MsgPopup.msg(tituloCgg_res_adjunto, "Su archivo adjunto no ha sido guardado.\nError:"+inAction.result.msg,MsgPopup.WARNING);
                    },
                    params:{
                        inCrseg_codigo:inCRSEG_CODIGO
                    }
                });

            }
        }
    });

    /**
     * Boton que permite cerrar la ventana winFrmTest.
     */
    var btnCerrarCgg_res_adjunto = new Ext.Button({
        id:'btnCerrarCgg_res_adjunto',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmTest.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmTest.
     */
    var pnlCgg_res_adjunto = new Ext.form.FormPanel({
        id:'pnlCgg_res_adjunto',
        frame:true,
        labelWidth :100,
        items:[filCradj_archivo_adjunto,txtCradj_observacion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_adjunto.
     */
    var winFrmTest = new Ext.Window({
        id:'winFrmTest',
        title:tituloCgg_res_adjunto,
        tbar:getPanelTitulo(tituloCgg_res_adjunto,descCgg_res_adjunto),
        items:[pnlCgg_res_adjunto],
        width:400,
        minWidth:400,
        constrain:true,
        modal:true,
        bbar:[btnGuardarCgg_res_adjunto,'->',btnCerrarCgg_res_adjunto]
    });

    /**
     * Funcion miembro que devuelve la ventana winFrmTest.
     * @returns ventana winFrmTest.
     * @base FrmTest.prototype.show
     */
    this.getWindow = function(){
        return winFrmTest;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmTest.
     * @base FrmTest.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_adjuntoCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmTest desde una instancia.
 */
FrmTest.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmTest desde una instancia.
 */
FrmTest.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmTest,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmTest.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmTest desde una instancia.
 */
FrmTest.prototype.loadData = function(){
    this.loadData();
}
