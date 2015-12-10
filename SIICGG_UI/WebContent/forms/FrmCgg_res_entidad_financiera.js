/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_entidad_financiera.
 * @param {String} INSENTENCIA_CGG_RES_ENTIDAD_FINANCIERA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_ENTIDAD_FINANCIERA Registro de datos de la tabla Cgg_res_entidad_financiera.
 * @constructor
 * @base FrmListadoCgg_res_entidad_financiera
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_entidad_financiera(INSENTENCIA_CGG_RES_ENTIDAD_FINANCIERA,INRECORD_CGG_RES_ENTIDAD_FINANCIERA){
    var inSentenciaCgg_res_entidad_financiera = INSENTENCIA_CGG_RES_ENTIDAD_FINANCIERA;
    var inRecordCgg_res_entidad_financiera=INRECORD_CGG_RES_ENTIDAD_FINANCIERA;
    var urlCgg_res_entidad_financiera=URL_WS+"Cgg_res_entidad_financiera";
    var tituloCgg_res_entidad_financiera='Entidad financiera';
    var descCgg_res_entidad_financiera='El formulario permite ingresar informaci\u00F3n de entidades donde se pueden realizar el dep\u00F3sito de garant\u00EDas';
    var isEdit = false;
    /**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGSITRO
*/
    var txtCretf_codigo = new Ext.form.TextField({
        id:'txtCretf_codigo',
        name:'txtCretf_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
	* Ext.form.TextField NOMBRE DE LA ENTIDAD FINANCIERA
	*/
    var txtCretf_nombre_entidad = new Ext.form.TextField({
        id:'txtCretf_nombre_entidad',
        name:'txtCretf_nombre_entidad',
        fieldLabel :'Nombre entidad',
        anchor:'98%',
        allowBlank :false
    });
    /**
	* Ext.form.TextField DESCRIPCION DE LA ENTIDAD BANCARIA
	*/
    var txtCretf_descripcion = new Ext.form.TextField({
        id:'txtCretf_descripcion',
        name:'txtCretf_descripcion',
        fieldLabel :'Descripcion',
        anchor:'98%',
        allowBlank :false
    });
    /**
	 * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_entidad_financiera
	 */
    var btnGuardarCgg_res_entidad_financiera = new Ext.Button({
        id:'btnGuardarCgg_res_entidad_financiera',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:'Guardar entidad financiera',
        listeners:{
            click:function(){
                if (pnlCgg_res_entidad_financiera.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_entidad_financiera(r){
                        winFrmCgg_res_entidad_financiera.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_entidad_financiera,
                                msg: 'La informaci\u00f3n de entidad financiera ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_res_entidad_financiera.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_entidad_financiera,
                                msg: 'La informaci\u00f3n de entidad financiera no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_entidad_financiera.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCretf_codigo',txtCretf_codigo.getValue());
                    param.add('inCretf_nombre_entidad',txtCretf_nombre_entidad.getValue());
                    param.add('inCretf_descripcion',txtCretf_descripcion.getValue());
                    SOAPClient.invoke(urlCgg_res_entidad_financiera,INSENTENCIA_CGG_RES_ENTIDAD_FINANCIERA,param, true, CallBackCgg_res_entidad_financiera);
                }catch(inErr){
                    winFrmCgg_res_entidad_financiera.getEl().unmask();
                }
            }
        }
    });
    /**
	 * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_entidad_financiera.
	 */
    var btnCancelarCgg_res_entidad_financiera = new Ext.Button({
        id:'btnCancelarCgg_res_entidad_financiera',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:'Cancelar informaci\u00f3n',
        listeners:{
            click:function(){
                pnlCgg_res_entidad_financiera.getForm().reset();
            }
        }
    });
    /**
	 * Boton que permite cerrar la ventana winFrmCgg_res_entidad_financiera.
	 */
    var btnCerrarCgg_res_entidad_financiera = new Ext.Button({
        id:'btnCerrarCgg_res_entidad_financiera',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerra formulario',
        listeners:{
            click:function(){
                winFrmCgg_res_entidad_financiera.close();
            }
        }
    });
    /**
	 * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_entidad_financiera.
	 */
    var pnlCgg_res_entidad_financiera = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCretf_codigo,txtCretf_nombre_entidad,txtCretf_descripcion]
    });
    /**
	 * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_entidad_financiera.
	 */
    var winFrmCgg_res_entidad_financiera = new Ext.Window({
        id:'winFrmCgg_res_entidad_financiera',
        title:tituloCgg_res_entidad_financiera,
        tbar:getPanelTitulo(tituloCgg_res_entidad_financiera,descCgg_res_entidad_financiera),
        items:[pnlCgg_res_entidad_financiera],
        width:400,
        minWidth:400,
        resizable: false,
        maximizable:false,
        minimizable:false,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_res_entidad_financiera,btnCancelarCgg_res_entidad_financiera,'->',btnCerrarCgg_res_entidad_financiera]
    });
    /**
* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_entidad_financiera.
* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
*/
    function habilitarCgg_res_entidad_financieraCtrls(inEstado){
        estado=!inEstado;
        txtCretf_codigo.setDisabled(estado);
        txtCretf_nombre_entidad.setDisabled(estado);
        txtCretf_descripcion.setDisabled(estado);
    }
    /**
* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_entidad_financiera.
*/
    function cargarCgg_res_entidad_financieraCtrls(){
        if(inRecordCgg_res_entidad_financiera){
            txtCretf_codigo.setValue(inRecordCgg_res_entidad_financiera.get('CRETF_CODIGO'));
            txtCretf_nombre_entidad.setValue(inRecordCgg_res_entidad_financiera.get('CRETF_NOMBRE_ENTIDAD'));
            txtCretf_descripcion.setValue(inRecordCgg_res_entidad_financiera.get('CRETF_DESCRIPCION'));
            isEdit = true;
            habilitarCgg_res_entidad_financieraCtrls(true);
        }
    }
/**
* Funcion miembro que devuelve la ventana winFrmCgg_res_entidad_financiera.
* @returns ventana winFrmCgg_res_entidad_financiera.
* @base FrmCgg_res_entidad_financiera.prototype.show
*/
this.getWindow = function(){
    return winFrmCgg_res_entidad_financiera;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmCgg_res_entidad_financiera.
* @base FrmCgg_res_entidad_financiera.prototype.loadData
*/
this.loadData = function(){
    cargarCgg_res_entidad_financieraCtrls();
}
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_entidad_financiera desde una instancia.
*/
FrmCgg_res_entidad_financiera.prototype.show = function(){
    this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_entidad_financiera desde una instancia.
*/
FrmCgg_res_entidad_financiera.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_entidad_financiera,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_res_entidad_financiera.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_entidad_financiera desde una instancia.
*/
FrmCgg_res_entidad_financiera.prototype.loadData = function(){
    this.loadData();
}

