/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_embarcacion.
 * @param {String} INSENTENCIA_CGG_RES_EMBARCACION Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_EMBARCACION Registro de datos de la tabla Cgg_res_embarcacion.
 * @constructor
 * @base FrmListadoCgg_res_embarcacion
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_embarcacion(INSENTENCIA_CGG_RES_EMBARCACION,INRECORD_CGG_RES_EMBARCACION){
    var inSentenciaCgg_res_embarcacion = INSENTENCIA_CGG_RES_EMBARCACION;
    var inRecordCgg_res_embarcacion=INRECORD_CGG_RES_EMBARCACION;
    var urlCgg_res_embarcacion=URL_WS+"Cgg_res_embarcacion";
    var tituloCgg_res_embarcacion='Embarcaci\u00f3n';
    var descCgg_res_embarcacion='El formulario permite administrar informaci\u00f3n de Embarcaci\u00f3n';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCremb_codigo = new Ext.form.TextField({
        id:'txtCremb_codigo',
        name:'txtCremb_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true
    });
    /**
     * Ext.form.TextField NOMBRE DE LA EMBARCACION
     */
    var txtCremb_nombre = new Ext.form.TextField({
        id:'txtCremb_nombre',
        name:'txtCremb_nombre',
        fieldLabel :'Nombre',
        anchor:'98%'
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_embarcacion
     */
    var btnGuardarCgg_res_embarcacion = new Ext.Button({
        id:'btnGuardarCgg_res_embarcacion',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_res_embarcacion.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_embarcacion(r){
                        winFrmCgg_res_embarcacion.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_embarcacion,
                                msg: 'La informaci\u00f3n de Embarcaci\u00f3n ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_embarcacion.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_embarcacion,
                                msg: 'La informaci\u00f3n de Embarcaci\u00f3n no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_embarcacion.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCremb_codigo',txtCremb_codigo.getValue());
                    param.add('inCremb_nombre',txtCremb_nombre.getValue());
                    SOAPClient.invoke(urlCgg_res_embarcacion,INSENTENCIA_CGG_RES_EMBARCACION,param, true, CallBackCgg_res_embarcacion);
                }catch(inErr){
                    winFrmCgg_res_embarcacion.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_embarcacion.
     */
    var btnCancelarCgg_res_embarcacion = new Ext.Button({
        id:'btnCancelarCgg_res_embarcacion',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_res_embarcacion.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_embarcacion.
     */
    var btnCerrarCgg_res_embarcacion = new Ext.Button({
        id:'btnCerrarCgg_res_embarcacion',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_res_embarcacion.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_embarcacion.
     */
    var pnlCgg_res_embarcacion = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCremb_codigo,txtCremb_nombre]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_embarcacion.
     */
    var winFrmCgg_res_embarcacion = new Ext.Window({
        id:'winFrmCgg_res_embarcacion',
        title:tituloCgg_res_embarcacion,
        tbar:getPanelTitulo(tituloCgg_res_embarcacion,descCgg_res_embarcacion),
        items:[pnlCgg_res_embarcacion],
        width:400,
        minWidth:400,
        modal:true,
        resizable :false,
        maximizable:false,
        minimizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_res_embarcacion,btnCancelarCgg_res_embarcacion,'->',btnCerrarCgg_res_embarcacion]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_embarcacion.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_embarcacionCtrls(inEstado){
        estado=!inEstado;
        txtCremb_codigo.setDisabled(estado);
        txtCremb_nombre.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_embarcacion.
     */
    function cargarCgg_res_embarcacionCtrls(){
        if(inRecordCgg_res_embarcacion){
            txtCremb_codigo.setValue(inRecordCgg_res_embarcacion.get('CREMB_CODIGO'));
            txtCremb_nombre.setValue(inRecordCgg_res_embarcacion.get('CREMB_NOMBRE'));
            isEdit = true;
            habilitarCgg_res_embarcacionCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_embarcacion.
     * @returns ventana winFrmCgg_res_embarcacion.
     * @base FrmCgg_res_embarcacion.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_embarcacion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_embarcacion.
     * @base FrmCgg_res_embarcacion.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_embarcacionCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_embarcacion desde una instancia.
 */
FrmCgg_res_embarcacion.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_embarcacion desde una instancia.
 */
FrmCgg_res_embarcacion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_embarcacion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_embarcacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_embarcacion desde una instancia.
 */
FrmCgg_res_embarcacion.prototype.loadData = function(){
    this.loadData();
}
