/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_configuracion.
* @param {String} INSENTENCIA_CGG_CONFIGURACION Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} INRECORD_CGG_CONFIGURACION Registro de datos de la tabla Cgg_configuracion.
* @constructor
* @base FrmListadoCgg_configuracion
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_configuracion(INSENTENCIA_CGG_CONFIGURACION,INRECORD_CGG_CONFIGURACION){
    var inSentenciaCgg_configuracion = INSENTENCIA_CGG_CONFIGURACION;
    var inRecordCgg_configuracion=INRECORD_CGG_CONFIGURACION;
    var urlCgg_configuracion=URL_WS+"Cgg_configuracion";
    var tituloCgg_configuracion='Parametro de configuraci\u00f3n';
    var descCgg_configuracion='El formulario permite administrar informaci\u00f3n de paramtros de configuraci\u00f3n.';
    var isEdit = false;
    /**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CONFIGURACION
*/
    var txtCgcnf_codigo = new Ext.form.TextField({
        id:'txtCgcnf_codigo',
        name:'txtCgcnf_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
* Ext.form.TextField NOMBRE DEL VALOR DE CONFIGURACION
*/
    var txtCgcnf_configuracion = new Ext.form.TextField({
        id:'txtCgcnf_configuracion',
        name:'txtCgcnf_configuracion',
        fieldLabel :'Configuraci\u00f3n',
        anchor:'98%',
        allowBlank :false,
        maxLength :100
    });
    /**
* Ext.form.TextField VALOR DE CONFIGURACION TIPO TEXTO
*/
    var txtCgcnf_valor_cadena = new Ext.form.TextField({
        id:'txtCgcnf_valor_cadena',
        name:'txtCgcnf_valor_cadena',
        fieldLabel :'Valor textual',
        anchor:'98%',        
        maxLength:500
    });
    /**
* Ext.form.NumberField VALOR DE CONFIGURACION TIPO NUMERICO
*/
    var numCgcnf_valor_numerico = new Ext.form.NumberField({
        id:'numCgcnf_valor_numerico',
        nname:'numCgcnf_valor_numerico',
        fieldLabel :'Valor numerico'        
    });

    /**
* Boton que permite almacenar la informacion de la ventana winFrmCgg_configuracion
*/
    var btnGuardarCgg_configuracion = new Ext.Button({
        id:'btnGuardarCgg_configuracion',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_configuracion.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_configuracion(r){
                        winFrmCgg_configuracion.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_configuracion,
                                msg: 'La informaci\u00f3n de Configuracion ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_configuracion.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_configuracion,
                                msg: 'La informaci\u00f3n de Configuracion no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_configuracion.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCgcnf_codigo',txtCgcnf_codigo.getValue());
                    param.add('inCgcnf_configuracion',txtCgcnf_configuracion.getValue());
                    param.add('inCgcnf_valor_cadena',txtCgcnf_valor_cadena.getValue());
                    param.add('inCgcnf_valor_numerico',numCgcnf_valor_numerico.getValue());
                    SOAPClient.invoke(urlCgg_configuracion,INSENTENCIA_CGG_CONFIGURACION,param, true, CallBackCgg_configuracion);
                }catch(inErr){
                    winFrmCgg_configuracion.getEl().unmask();
                }
            }
        }
    });
    /**
* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_configuracion.
*/
    var btnCancelarCgg_configuracion = new Ext.Button({
        id:'btnCancelarCgg_configuracion',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_configuracion.getForm().reset();
            }
        }
    });
    /**
* Boton que permite cerrar la ventana winFrmCgg_configuracion.
*/
    var btnCerrarCgg_configuracion = new Ext.Button({
        id:'btnCerrarCgg_configuracion',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_configuracion.close();
            }
        }
    });
    /**
* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_configuracion.
*/
    var pnlCgg_configuracion = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCgcnf_codigo,txtCgcnf_configuracion,txtCgcnf_valor_cadena,numCgcnf_valor_numerico]
    });
    /**
* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_configuracion.
*/
    var winFrmCgg_configuracion = new Ext.Window({
        id:'winFrmCgg_configuracion',
        title:tituloCgg_configuracion,
        tbar:getPanelTitulo(tituloCgg_configuracion,descCgg_configuracion),
        items:[pnlCgg_configuracion],
        width:400,
        minWidth:400,
        constrain:true,
        modal:true,
        bbar:[btnGuardarCgg_configuracion,btnCancelarCgg_configuracion,'->',btnCerrarCgg_configuracion]
    });
    /**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_configuracion.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
    function habilitarCgg_configuracionCtrls(inEstado){
        var estado=!inEstado;
        txtCgcnf_codigo.setDisabled(estado);
        txtCgcnf_configuracion.setDisabled(estado);
        txtCgcnf_valor_cadena.setDisabled(estado);
        numCgcnf_valor_numerico.setDisabled(estado);
    }
    /**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_configuracion.
*/
    function cargarCgg_configuracionCtrls(){
        if(inRecordCgg_configuracion){
            txtCgcnf_codigo.setValue(inRecordCgg_configuracion.get('CGCNF_CODIGO'));
            txtCgcnf_configuracion.setValue(inRecordCgg_configuracion.get('CGCNF_CONFIGURACION'));
            txtCgcnf_valor_cadena.setValue(inRecordCgg_configuracion.get('CGCNF_VALOR_CADENA'));
            numCgcnf_valor_numerico.setValue(inRecordCgg_configuracion.get('CGCNF_VALOR_NUMERICO'));
            isEdit = true;
            habilitarCgg_configuracionCtrls(true);
        }
    }
    /**
* Funcion miembro que devuelve la ventana winFrmCgg_configuracion.
* @returns ventana winFrmCgg_configuracion.
* @base FrmCgg_configuracion.prototype.show
*/
    this.getWindow = function(){
        return winFrmCgg_configuracion;
    }
    /**
* Funcion miembro que carga los controles de la ventana winFrmCgg_configuracion.
* @base FrmCgg_configuracion.prototype.loadData
*/
    this.loadData = function(){
        cargarCgg_configuracionCtrls();
    }
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_configuracion desde una instancia.
*/
FrmCgg_configuracion.prototype.show = function(){
    this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_configuracion desde una instancia.
*/
FrmCgg_configuracion.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_configuracion,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_configuracion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_configuracion desde una instancia.
*/
FrmCgg_configuracion.prototype.loadData = function(){
    this.loadData();
}
