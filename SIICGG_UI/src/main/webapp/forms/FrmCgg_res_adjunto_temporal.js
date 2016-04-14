/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_adjunto_temporal.
* @param {String} IN_SENTENCIA_CGG_RES_ADJUNTO_TEMPORAL Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_RES_ADJUNTO_TEMPORAL Registro de datos de la tabla Cgg_res_adjunto_temporal.
* @constructor
* @base FrmListadoCgg_res_adjunto_temporal
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_res_adjunto_temporal(IN_SENTENCIA_CGG_RES_ADJUNTO_TEMPORAL,IN_RECORD_CGG_RES_ADJUNTO_TEMPORAL){    
    var inSentenciaCgg_res_adjunto_temporal = IN_SENTENCIA_CGG_RES_ADJUNTO_TEMPORAL;
    var inRecordCgg_res_adjunto_temporal=IN_RECORD_CGG_RES_ADJUNTO_TEMPORAL;
    var urlCgg_res_adjunto_temporal=URL_WS+"Cgg_res_adjunto_temporal";
    var tituloCgg_res_adjunto_temporal='Archivo adjunto';
    var descCgg_res_adjunto_temporal='El formulario permite subir su archivo adjunto';
    var isEdit = false;
    var dialogResult = null;

    /**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO TEMPORAL
*/
    var txtCrate_codigo = new Ext.form.TextField({
        id:'txtCrate_codigo',
        name:'txtCrate_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });

    /**
* CONTENIDO BINARIO DEL ARCHIVO TEMPORAL.
*/
    var filCrate_archivo = new Ext.form.FileUploadField({
        id:'filCrate_archivo',
        name:'filCrate_archivo',
        fieldLabel :'Archivo',
        anchor:'98%',
        allowBlank:false,
        blankText:'Seleccione su adjunto, por favor.',
        disabled :false,
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        }
    });
    /**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_res_adjunto_temporal
*/
    var btnGuardarCgg_res_adjunto_temporal = new Ext.Button({
        id:'btnGuardarCgg_res_adjunto_temporal',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_adjunto_temporal.getForm().isValid()==false){
                    return;
                }
                pnlCgg_res_adjunto_temporal.getEl().mask('Guardando...', 'x-mask-loading');
                Ext.getCmp('pnlCgg_res_adjunto_temporal').getForm().submit({
                    url: URL_WS+"Cgg_res_adjunto_temporalSRV",                    
                    params:{
                        inCjsgc_codigo:'KEYGEN'
                    },
                    success: function(inForm,inAction){                        
                        pnlCgg_res_adjunto_temporal.getEl().unmask();
                        var result = Ext.util.JSON.decode(inAction.result.msg);                        
                        if(result.CRATE_CODIGO.substr(0, 5)=='CRATE' ){
                            dialogResult = result;
                            Ext.MsgPopup.msg(tituloCgg_res_adjunto_temporal, "Su archivo adjunto ha sido guardado.",MsgPopup.INFO);
                            winFrmCgg_res_adjunto_temporal.close();
                        }else{
                            Ext.MsgPopup.msg(tituloCgg_res_adjunto_temporal, "Su archivo adjunto no ha sido guardado.\nError:"+inAction.response.responseText,MsgPopup.WARNING);
                        }                                                
                    },
                    failure:function(inForm,inAction){
                        pnlCgg_res_adjunto_temporal.getEl().unmask();
                        Ext.MsgPopup.msg(tituloCgg_res_adjunto_temporal, "Su archivo adjunto no ha sido guardado.\nError:"+inAction.result,MsgPopup.WARNING);
                    }
                });
            }
        }
    });
    /**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_adjunto_temporal.
*/
    var btnCancelarCgg_res_adjunto_temporal = new Ext.Button({
        id:'btnCancelarCgg_res_adjunto_temporal',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_adjunto_temporal.getForm().reset();
            }
        }
    });
    /**
* Boton que permite cerrar la ventana winFrmCgg_res_adjunto_temporal.
*/
    var btnCerrarCgg_res_adjunto_temporal = new Ext.Button({
        id:'btnCerrarCgg_res_adjunto_temporal',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                dialogResult = null;
                winFrmCgg_res_adjunto_temporal.close();
            }
        }
    });
    /**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_adjunto_temporal.
*/
    var pnlCgg_res_adjunto_temporal = new Ext.form.FormPanel({
        id:'pnlCgg_res_adjunto_temporal',
        frame:true,
        labelWidth :100,
        fileUpload:true,
        items:[txtCrate_codigo,filCrate_archivo]
    });
    /**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_adjunto_temporal.
*/
    var winFrmCgg_res_adjunto_temporal = new Ext.Window({
        id:'winFrmCgg_res_adjunto_temporal',
        title:tituloCgg_res_adjunto_temporal,
        width:400,
        minWidth:400,
        constrain:true,
        modal:true,
        tbar:getPanelTitulo(tituloCgg_res_adjunto_temporal,descCgg_res_adjunto_temporal),
        items:[pnlCgg_res_adjunto_temporal],
        bbar:[btnGuardarCgg_res_adjunto_temporal,btnCancelarCgg_res_adjunto_temporal,'->',btnCerrarCgg_res_adjunto_temporal]
    });
    /**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_adjunto_temporal.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
    function habilitarCgg_res_adjunto_temporalCtrls(inEstado){
        estado=!inEstado;
        txtCrate_codigo.setDisabled(estado);
        txtCrate_nombre.setDisabled(estado);
        txtCrate_tipo_contenido.setDisabled(estado);
        numCrate_archivo.setDisabled(estado);
    }
    /**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_adjunto_temporal.
*/
    function cargarCgg_res_adjunto_temporalCtrls(){
        if(inRecordCgg_res_adjunto_temporal){
            txtCrate_codigo.setValue(inRecordCgg_res_adjunto_temporal.get('CRATE_CODIGO'));
            txtCrate_nombre.setValue(inRecordCgg_res_adjunto_temporal.get('CRATE_NOMBRE'));
            txtCrate_tipo_contenido.setValue(inRecordCgg_res_adjunto_temporal.get('CRATE_TIPO_CONTENIDO'));
            numCrate_archivo.setValue(inRecordCgg_res_adjunto_temporal.get('CRATE_ARCHIVO'));
            isEdit = true;
            habilitarCgg_res_adjunto_temporalCtrls(true);
        }
    }
    /**
* Funcion miembro que devuelve la ventana winFrmCgg_res_adjunto_temporal.
* @returns ventana winFrmCgg_res_adjunto_temporal.
* @base FrmCgg_res_adjunto_temporal.prototype.show
*/
    this.getWindow = function(){
        return winFrmCgg_res_adjunto_temporal;
    }
    /**
* Funcion miembro que carga los controles de la ventana winFrmCgg_res_adjunto_temporal.
* @base FrmCgg_res_adjunto_temporal.prototype.loadData
*/
    this.loadData = function(){
        cargarCgg_res_adjunto_temporalCtrls();
    }

    this.getDialogResult = function(){
        return dialogResult;
    }
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_adjunto_temporal desde una instancia.
*/
FrmCgg_res_adjunto_temporal.prototype.show = function(){
    this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_adjunto_temporal desde una instancia.
*/
FrmCgg_res_adjunto_temporal.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_adjunto_temporal,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_res_adjunto_temporal.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_adjunto_temporal desde una instancia.
*/
FrmCgg_res_adjunto_temporal.prototype.loadData = function(){
    this.loadData();
}

FrmCgg_res_adjunto_temporal.prototype.dialogResult = function(){
    return this.getDialogResult();
}