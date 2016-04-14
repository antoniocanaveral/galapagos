/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_tct_forma_salida.
 * @param {String} IN_SENTENCIA_CGG_TCT_FORMA_SALIDA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_TCT_FORMA_SALIDA Registro de datos de la tabla Cgg_tct_forma_salida.
 * @constructor
 * @base FrmListadoCgg_tct_forma_salida
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_tct_forma_salida(IN_SENTENCIA_CGG_TCT_FORMA_SALIDA,IN_RECORD_CGG_TCT_FORMA_SALIDA){
    var inSentenciaCgg_tct_forma_salida = IN_SENTENCIA_CGG_TCT_FORMA_SALIDA;
    var inRecordCgg_tct_forma_salida=IN_RECORD_CGG_TCT_FORMA_SALIDA;
    var urlCgg_tct_forma_salida=URL_WS+"Cgg_tct_forma_salida";
    var tituloCgg_tct_forma_salida='Salida';
    var descCgg_tct_forma_salida='El formulario permite administrar la informaci\u00f3n de la Salida';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCtfsl_codigo = new Ext.form.TextField({
        id:'txtCtfsl_codigo',
        name:'txtCtfsl_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true
    });
    /**
     * Ext.form.TextField NOMBRE DE LA FORMA DE SALIDA
     */
    var txtCtfsl_nombre = new Ext.form.TextField({
        id:'txtCtfsl_nombre',
        name:'txtCtfsl_nombre',
        fieldLabel :'Nombre',
        anchor:'98%'
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_tct_forma_salida
     */
    var btnGuardarCgg_tct_forma_salida = new Ext.Button({
        id:'btnGuardarCgg_tct_forma_salida',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_tct_forma_salida.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_tct_forma_salida(r){
                        winFrmCgg_tct_forma_salida.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_tct_forma_salida,
                                msg: 'La informaci\u00f3n de la Salida ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_tct_forma_salida.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_tct_forma_salida,
                                msg: 'La informaci\u00f3n de la Salida no ha podido ser almacenada. '+ (r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_tct_forma_salida.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCtfsl_codigo',txtCtfsl_codigo.getValue());
                    param.add('inCtfsl_nombre',txtCtfsl_nombre.getValue());
                    SOAPClient.invoke(urlCgg_tct_forma_salida,IN_SENTENCIA_CGG_TCT_FORMA_SALIDA,param, true, CallBackCgg_tct_forma_salida);
                }catch(inErr){
                    winFrmCgg_tct_forma_salida.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_tct_forma_salida.
     */
    var btnCancelarCgg_tct_forma_salida = new Ext.Button({
        id:'btnCancelarCgg_tct_forma_salida',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_tct_forma_salida.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_tct_forma_salida.
     */
    var btnCerrarCgg_tct_forma_salida = new Ext.Button({
        id:'btnCerrarCgg_tct_forma_salida',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_tct_forma_salida.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_tct_forma_salida.
     */
    var pnlCgg_tct_forma_salida = new Ext.form.FormPanel({
        frame:true,
        labelWidth :50,
        items:[txtCtfsl_codigo,txtCtfsl_nombre]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_tct_forma_salida.
     */
    var winFrmCgg_tct_forma_salida = new Ext.Window({
        id:'winFrmCgg_tct_forma_salida',
        title:tituloCgg_tct_forma_salida,
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        modal:true,
        resizable:false,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_tct_forma_salida,descCgg_tct_forma_salida),
        items:[pnlCgg_tct_forma_salida],
        bbar:[btnGuardarCgg_tct_forma_salida,btnCancelarCgg_tct_forma_salida,'->',btnCerrarCgg_tct_forma_salida]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_tct_forma_salida.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_tct_forma_salidaCtrls(inEstado){
        estado=!inEstado;
        txtCtfsl_codigo.setDisabled(estado);
        txtCtfsl_nombre.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_tct_forma_salida.
     */
    function cargarCgg_tct_forma_salidaCtrls(){
        if(inRecordCgg_tct_forma_salida){
            txtCtfsl_codigo.setValue(inRecordCgg_tct_forma_salida.get('CTFSL_CODIGO'));
            txtCtfsl_nombre.setValue(inRecordCgg_tct_forma_salida.get('CTFSL_NOMBRE'));
            isEdit = true;
            habilitarCgg_tct_forma_salidaCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_tct_forma_salida.
     * @returns ventana winFrmCgg_tct_forma_salida.
     * @base FrmCgg_tct_forma_salida.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_tct_forma_salida;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_tct_forma_salida.
     * @base FrmCgg_tct_forma_salida.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_tct_forma_salidaCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_tct_forma_salida desde una instancia.
 */
FrmCgg_tct_forma_salida.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_tct_forma_salida desde una instancia.
 */
FrmCgg_tct_forma_salida.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_tct_forma_salida,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_tct_forma_salida.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_tct_forma_salida desde una instancia.
 */
FrmCgg_tct_forma_salida.prototype.loadData = function(){
    this.loadData();
}
