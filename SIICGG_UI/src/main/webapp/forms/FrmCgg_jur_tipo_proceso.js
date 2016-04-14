/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_jur_tipo_proceso.
 * @param {String} IN_SENTENCIA_CGG_JUR_TIPO_PROCESO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_JUR_TIPO_PROCESO Registro de datos de la tabla Cgg_jur_tipo_proceso.
 * @constructor
 * @base FrmListadoCgg_jur_tipo_proceso
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_jur_tipo_proceso(IN_SENTENCIA_CGG_JUR_TIPO_PROCESO,IN_RECORD_CGG_JUR_TIPO_PROCESO){
    var inSentenciaCgg_jur_tipo_proceso = IN_SENTENCIA_CGG_JUR_TIPO_PROCESO;
    var inRecordCgg_jur_tipo_proceso=IN_RECORD_CGG_JUR_TIPO_PROCESO;
    var urlCgg_jur_tipo_proceso=URL_WS+"Cgg_jur_tipo_proceso";
    var tituloCgg_jur_tipo_proceso='Tipo proceso jur\u00eddico';
    var descCgg_jur_tipo_proceso='El formulario permite administrar la informaci\u00f3n del Tipo proceso jur\u00eddico';
    var isEdit = false;

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE PROCESO DE CONTRATACION
     */
    var txtCjtpr_codigo = new Ext.form.TextField({
        id:'txtCjtpr_codigo',
        name:'txtCjtpr_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField NOMBRE DEL PROCESO DE CONVENIO. EN CASO DE CONTRATOS LOS TIPOS SON CONTRATACION DIRECTA, MINIMA CUANTIA, ETC, Y EN CASO DE CONVENIOS ES: MARCO, ESPECIFICO Y COMODATO. SE DISCRIMINAN POR EL CAMPO DE TIPO DE PROCESO
     */
    var txtCjtpr_nombre = new Ext.form.TextField({
        id:'txtCjtpr_nombre',
        name:'txtCjtpr_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField CADENA DE TEXTO DE DESCRIPCION DEL PROCESO DE CONTRATACION.
     */
    var txtCjtpr_descripcion = new Ext.form.TextArea({
        id:'txtCjtpr_descripcion',
        name:'txtCjtpr_descripcion',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%',
        allowBlank:false
    });
    /**
     * Ext.form.NumberField TIPO DE PROCESO:
     0 - CONTRATO
     1 - CONVENIO
     */

    var cbxCjtpr_tipo = new Ext.form.ComboBox({
        id:'cbxCjtpr_tipo',
        name:'cbxCjtpr_tipo',
        store: dsTipoAcuerdo,
        fieldLabel :'Tipo acuerdo',
        anchor:'75%',
        mode:'local',
        forceSelection:true,
        triggerAction:'all',
        editable:false,
        value:0,
        emptyText:'Seleccione un Tipo'
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_jur_tipo_proceso
     */
    var btnGuardarCgg_jur_tipo_proceso = new Ext.Button({
        id:'btnGuardarCgg_jur_tipo_proceso',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (!pnlCgg_jur_tipo_proceso.getForm().isValid()){
                    return;
                }
                try{
                    function CallBackCgg_jur_tipo_proceso(r){
                        winFrmCgg_jur_tipo_proceso.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_jur_tipo_proceso,
                                msg: 'el Tipo de proceso ha sido almacenado.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_jur_tipo_proceso.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_jur_tipo_proceso,
                                msg: 'La informaci\u00f3n de Tipo proceso no ha podido ser almacenado. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_jur_tipo_proceso.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCjtpr_codigo',txtCjtpr_codigo.getValue());
                    param.add('inCjtpr_nombre',txtCjtpr_nombre.getValue());
                    param.add('inCjtpr_descripcion',txtCjtpr_descripcion.getValue());
                    param.add('inCjtpr_tipo',cbxCjtpr_tipo.getValue());
                    SOAPClient.invoke(urlCgg_jur_tipo_proceso,IN_SENTENCIA_CGG_JUR_TIPO_PROCESO,param, true, CallBackCgg_jur_tipo_proceso);
                }catch(inErr){
                    winFrmCgg_jur_tipo_proceso.getEl().unmask();
                }
            }
        }
    });
/**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_jur_tipo_proceso.
     */
var btnCancelarCgg_jur_tipo_proceso = new Ext.Button({
    id:'btnCancelarCgg_jur_tipo_proceso',
    text:'Cancelar',
    iconCls:'iconCancelar',
    listeners:{
        click:function(){
            pnlCgg_jur_tipo_proceso.getForm().reset();
        }
    }
});
/**
     * Boton que permite cerrar la ventana winFrmCgg_jur_tipo_proceso.
     */
var btnCerrarCgg_jur_tipo_proceso = new Ext.Button({
    id:'btnCerrarCgg_jur_tipo_proceso',
    text:'Cerrar',
    iconCls:'iconCerrar',
    listeners:{
        click:function(){
            winFrmCgg_jur_tipo_proceso.close();
        }
    }
});
/**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_jur_tipo_proceso.
     */
var pnlCgg_jur_tipo_proceso = new Ext.form.FormPanel({
    frame:true,
    labelWidth :100,
    items:[txtCjtpr_codigo,txtCjtpr_nombre,txtCjtpr_descripcion,cbxCjtpr_tipo]
});
/**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_jur_tipo_proceso.
     */
var winFrmCgg_jur_tipo_proceso = new Ext.Window({
    id:'winFrmCgg_jur_tipo_proceso',
    title:tituloCgg_jur_tipo_proceso,
    iconCls:'iconAplicacion',
    width:400,
    minWidth:400,
    maximizable:false,
    modal:true,
    resizable:false,
    constrain:true,
    tbar:getPanelTitulo(tituloCgg_jur_tipo_proceso,descCgg_jur_tipo_proceso),
    items:[pnlCgg_jur_tipo_proceso],
    bbar:[btnGuardarCgg_jur_tipo_proceso,btnCancelarCgg_jur_tipo_proceso,'->',btnCerrarCgg_jur_tipo_proceso]
});
/**
     * Funcion que aplica los privilegios del usuario.
     */
applyGrants(winFrmCgg_jur_tipo_proceso.getBottomToolbar());
/**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_jur_tipo_proceso.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
function habilitarCgg_jur_tipo_procesoCtrls(inEstado){
    var estado=!inEstado;
    txtCjtpr_codigo.setDisabled(estado);
    txtCjtpr_nombre.setDisabled(estado);
    txtCjtpr_descripcion.setDisabled(estado);
    cbxCjtpr_tipo.setDisabled(estado);
}
/**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_jur_tipo_proceso.
     */
function cargarCgg_jur_tipo_procesoCtrls(){
    if(inRecordCgg_jur_tipo_proceso){
        txtCjtpr_codigo.setValue(inRecordCgg_jur_tipo_proceso.get('CJTPR_CODIGO'));
        txtCjtpr_nombre.setValue(inRecordCgg_jur_tipo_proceso.get('CJTPR_NOMBRE'));
        txtCjtpr_descripcion.setValue(inRecordCgg_jur_tipo_proceso.get('CJTPR_DESCRIPCION'));
        cbxCjtpr_tipo.setValue(inRecordCgg_jur_tipo_proceso.get('CJTPR_TIPO'));
        isEdit = true;
        habilitarCgg_jur_tipo_procesoCtrls(true);
    }
}
/**
     * Funcion miembro que devuelve la ventana winFrmCgg_jur_tipo_proceso.
     * @returns ventana winFrmCgg_jur_tipo_proceso.
     * @base FrmCgg_jur_tipo_proceso.prototype.show
     */
this.getWindow = function(){
    return winFrmCgg_jur_tipo_proceso;
}
/**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_jur_tipo_proceso.
     * @base FrmCgg_jur_tipo_proceso.prototype.loadData
     */
this.loadData = function(){
    cargarCgg_jur_tipo_procesoCtrls();
}
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_jur_tipo_proceso desde una instancia.
 */
FrmCgg_jur_tipo_proceso.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_jur_tipo_proceso desde una instancia.
 */
FrmCgg_jur_tipo_proceso.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_jur_tipo_proceso,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_jur_tipo_proceso.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_jur_tipo_proceso desde una instancia.
 */
FrmCgg_jur_tipo_proceso.prototype.loadData = function(){
    this.loadData();
}
