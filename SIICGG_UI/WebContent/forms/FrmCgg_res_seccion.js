/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_seccion.
* @param {String} IN_SENTENCIA_CGG_RES_SECCION Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_RES_SECCION Registro de datos de la tabla Cgg_res_seccion.
* @constructor
* @base FrmListadoCgg_res_seccion
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_res_seccion(IN_SENTENCIA_CGG_RES_SECCION,IN_RECORD_CGG_RES_SECCION){
    var optMenu = 'Res seccion';
    var inSentenciaCgg_res_seccion = IN_SENTENCIA_CGG_RES_SECCION;
    var inRecordCgg_res_seccion=IN_RECORD_CGG_RES_SECCION;
    var urlCgg_res_seccion=URL_WS+"Cgg_res_seccion";
    var tituloCgg_res_seccion='Secci\u00f3n';
    var descCgg_res_seccion='El formulario permite administrar la informaci\u00f3n de las secciones del CGG.';
    var isEdit = false;
    /**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO SECCION
*/
    var txtCrsec_codigo = new Ext.form.TextField({
        id:'txtCrsec_codigo',
        name:'txtCrsec_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
* Ext.form.TextField NOMBRE DEL DOCUMENTO DE RESPUESTA
*/
    var txtCrsec_nombre = new Ext.form.TextField({
        id:'txtCrsec_nombre',
        name:'txtCrsec_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false
    });
    /**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_res_seccion
*/
    var btnGuardarCgg_res_seccion = new Ext.Button({
        id:'btnGuardarCgg_res_seccion',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (!pnlCgg_res_seccion.getForm().isValid()){
                    return;
                }
                try{
                    function CallBackCgg_res_seccion(r){
                        winFrmCgg_res_seccion.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_seccion,
                                msg: 'La informaci\u00f3n de secci\u00f3n ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_res_seccion.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_seccion,
                                msg: 'La informaci\u00f3n de secci\u00f3n no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_seccion.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrsec_codigo',txtCrsec_codigo.getValue());
                    param.add('inCrsec_nombre',txtCrsec_nombre.getValue());
                    SOAPClient.invoke(urlCgg_res_seccion,IN_SENTENCIA_CGG_RES_SECCION,param, true, CallBackCgg_res_seccion);
                }catch(inErr){
                    winFrmCgg_res_seccion.getEl().unmask();
                }
            }
        }
    });
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_seccion.
*/
var btnCancelarCgg_res_seccion = new Ext.Button({
    id:'btnCancelarCgg_res_seccion',
    text:'Cancelar',
    iconCls:'iconCancelar',
    listeners:{
        click:function(){
            pnlCgg_res_seccion.getForm().reset();
        }
    }
});
/**
* Boton que permite cerrar la ventana winFrmCgg_res_seccion.
*/
var btnCerrarCgg_res_seccion = new Ext.Button({
    id:'btnCerrarCgg_res_seccion',
    text:'Cerrar',
    iconCls:'iconCerrar',
    listeners:{
        click:function(){
            winFrmCgg_res_seccion.close();
        }
    }
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_seccion.
*/
var pnlCgg_res_seccion = new Ext.form.FormPanel({
    frame:true,
    labelWidth :100,
    items:[txtCrsec_codigo,txtCrsec_nombre]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_seccion.
*/
var winFrmCgg_res_seccion = new Ext.Window({
    id:'winFrmCgg_res_seccion',
    title:tituloCgg_res_seccion,
    iconCls:'iconAplicacion',
    width:400,
    minWidth:400,
    constrain:true,
    modal:true,
    resizable:false,
    tbar:getPanelTitulo(tituloCgg_res_seccion,descCgg_res_seccion),
    items:[pnlCgg_res_seccion],
    bbar:[btnGuardarCgg_res_seccion,btnCancelarCgg_res_seccion,'->',btnCerrarCgg_res_seccion]
});
/**
* Funcion que aplica los privilegios del usuario.
*/
applyGrants(winFrmCgg_res_seccion.getBottomToolbar());
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_seccion.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_res_seccionCtrls(inEstado){
    estado=!inEstado;
    txtCrsec_codigo.setDisabled(estado);
    txtCrsec_nombre.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_seccion.
*/
function cargarCgg_res_seccionCtrls(){
    if(inRecordCgg_res_seccion){
        txtCrsec_codigo.setValue(inRecordCgg_res_seccion.get('CRSEC_CODIGO'));
        txtCrsec_nombre.setValue(inRecordCgg_res_seccion.get('CRSEC_NOMBRE'));
        isEdit = true;
        habilitarCgg_res_seccionCtrls(true);
    }
}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_res_seccion.
* @returns ventana winFrmCgg_res_seccion.
* @base FrmCgg_res_seccion.prototype.show
*/
this.getWindow = function(){
    return winFrmCgg_res_seccion;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_res_seccion.
* @base FrmCgg_res_seccion.prototype.loadData
*/
this.loadData = function(){
    cargarCgg_res_seccionCtrls();
}
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_seccion desde una instancia.
*/
FrmCgg_res_seccion.prototype.show = function(){
    this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_seccion desde una instancia.
*/
FrmCgg_res_seccion.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_seccion,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_res_seccion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_seccion desde una instancia.
*/
FrmCgg_res_seccion.prototype.loadData = function(){
    this.loadData();
}
