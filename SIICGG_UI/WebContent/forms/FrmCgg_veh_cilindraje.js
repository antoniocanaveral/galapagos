/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_veh_cilindraje.
* @param {String} INSENTENCIA_CGG_VEH_CILINDRAJE Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} INRECORD_CGG_VEH_CILINDRAJE Registro de datos de la tabla Cgg_veh_cilindraje.
* @constructor
* @base FrmListadoCgg_veh_cilindraje
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_veh_cilindraje(INSENTENCIA_CGG_VEH_CILINDRAJE,INRECORD_CGG_VEH_CILINDRAJE){
    var inSentenciaCgg_veh_cilindraje = INSENTENCIA_CGG_VEH_CILINDRAJE;
    var inRecordCgg_veh_cilindraje=INRECORD_CGG_VEH_CILINDRAJE;
    var urlCgg_veh_cilindraje=URL_WS+"Cgg_veh_cilindraje";
    var tituloCgg_veh_cilindraje='Cilindraje';
    var descCgg_veh_cilindraje='El formulario permite administrar informaci\u00f3n del cilindraje';
    var isEdit = false;
    /**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CILINDRAJE
*/
    var txtCvcln_codigo = new Ext.form.TextField({
        id:'txtCvcln_codigo',
        name:'txtCvcln_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
* Ext.form.NumberField CILINDRAJE DEL MOTOR
*/
    var numCvcln_cilindraje = new Ext.form.NumberField({
        id:'numCvcln_cilindraje',
        nname:'numCvcln_cilindraje',
        fieldLabel :'Cilindraje',
        allowBlank :false,
        disabled :false,
		anchor:'98%'
    });/**
* Ext.form.TextArea INFORMACION ADICIONAL
*/
    var txtCvcln_observacion = new Ext.form.TextArea({
        id:'txtCvcln_observacion',
        name:'txtCvcln_observacion',
        fieldLabel :'Observaci\u00F3n',
        width:'98%'
    });
    /**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_veh_cilindraje
*/
    var btnGuardarCgg_veh_cilindraje = new Ext.Button({
        id:'btnGuardarCgg_veh_cilindraje',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:'Guardar cilindraje',
        listeners:{
            click:function(){
                if (pnlCgg_veh_cilindraje.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_veh_cilindraje(r){
                        winFrmCgg_veh_cilindraje.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_veh_cilindraje,
                                msg: 'La informaci\u00f3n de cilindraje ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_veh_cilindraje.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_veh_cilindraje,
                                msg: 'La informaci\u00f3n de cilindraje no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_veh_cilindraje.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCvcln_codigo',txtCvcln_codigo.getValue());
                    param.add('inCvcln_cilindraje',numCvcln_cilindraje.getValue());
                    param.add('inCvcln_observacion',txtCvcln_observacion.getValue());
                    SOAPClient.invoke(urlCgg_veh_cilindraje,INSENTENCIA_CGG_VEH_CILINDRAJE,param, true, CallBackCgg_veh_cilindraje);
                }catch(inErr){
                    winFrmCgg_veh_cilindraje.getEl().unmask();
                }
            }
        }
    });
/**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_veh_cilindraje.
*/
var btnCancelarCgg_veh_cilindraje = new Ext.Button({
    id:'btnCancelarCgg_veh_cilindraje',
    text:'Cancelar',
    iconCls:'iconCancelar',
    tooltip:'Cancelar informaci\u00F3n',
    listeners:{
        click:function(){
            pnlCgg_veh_cilindraje.getForm().reset();
        }
    }
});
/**
* Boton que permite cerrar la ventana winFrmCgg_veh_cilindraje.
*/
var btnCerrarCgg_veh_cilindraje = new Ext.Button({
    id:'btnCerrarCgg_veh_cilindraje',
    text:'Cerrar',
    iconCls:'iconCerrar',
    tooltip:'Cerrar formulario',
    listeners:{
        click:function(){
            winFrmCgg_veh_cilindraje.close();
        }
    }
});
/**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_veh_cilindraje.
*/
var pnlCgg_veh_cilindraje = new Ext.form.FormPanel({
    frame:true,
    labelWidth :100,
    items:[txtCvcln_codigo,numCvcln_cilindraje,txtCvcln_observacion]
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_veh_cilindraje.
*/
var winFrmCgg_veh_cilindraje = new Ext.Window({
    id:'winFrmCgg_veh_cilindraje',
    title:tituloCgg_veh_cilindraje,
    tbar:getPanelTitulo(tituloCgg_veh_cilindraje,descCgg_veh_cilindraje),
    items:[pnlCgg_veh_cilindraje],
    width:400,
    minWidth:400,
    maximizable:true,
    minimizable:true,
    constrain:true,
    bbar:[btnGuardarCgg_veh_cilindraje,btnCancelarCgg_veh_cilindraje,'->',btnCerrarCgg_veh_cilindraje]
});
/**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_veh_cilindraje.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
function habilitarCgg_veh_cilindrajeCtrls(inEstado){
    estado=!inEstado;
    txtCvcln_codigo.setDisabled(estado);
    numCvcln_cilindraje.setDisabled(estado);
    txtCvcln_observacion.setDisabled(estado);
}
/**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_veh_cilindraje.
*/
function cargarCgg_veh_cilindrajeCtrls(){
    if(inRecordCgg_veh_cilindraje){
        txtCvcln_codigo.setValue(inRecordCgg_veh_cilindraje.get('CVCLN_CODIGO'));
        numCvcln_cilindraje.setValue(inRecordCgg_veh_cilindraje.get('CVCLN_CILINDRAJE'));
        txtCvcln_observacion.setValue(inRecordCgg_veh_cilindraje.get('CVCLN_OBSERVACION'));
        isEdit = true;
        habilitarCgg_veh_cilindrajeCtrls(true);
    }
}
/**
* Funcion miembro que devuelve la ventana winFrmCgg_veh_cilindraje.
* @returns ventana winFrmCgg_veh_cilindraje.
* @base FrmCgg_veh_cilindraje.prototype.show
*/
this.getWindow = function(){
    return winFrmCgg_veh_cilindraje;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_veh_cilindraje.
* @base FrmCgg_veh_cilindraje.prototype.loadData
*/
this.loadData = function(){
    cargarCgg_veh_cilindrajeCtrls();
}
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_veh_cilindraje desde una instancia.
*/
FrmCgg_veh_cilindraje.prototype.show = function(){
    this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_veh_cilindraje desde una instancia.
*/
FrmCgg_veh_cilindraje.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_veh_cilindraje,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_veh_cilindraje.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_veh_cilindraje desde una instancia.
*/
FrmCgg_veh_cilindraje.prototype.loadData = function(){
    this.loadData();
}
