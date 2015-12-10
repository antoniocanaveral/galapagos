/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_tct_tipo_hospedaje.
 * @param {String} IN_SENTENCIA_CGG_TCT_TIPO_HOSPEDAJE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_TCT_TIPO_HOSPEDAJE Registro de datos de la tabla Cgg_tct_tipo_hospedaje.
 * @constructor
 * @base FrmListadoCgg_tct_tipo_hospedaje
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_tct_tipo_hospedaje(IN_SENTENCIA_CGG_TCT_TIPO_HOSPEDAJE,IN_RECORD_CGG_TCT_TIPO_HOSPEDAJE){
    var inSentenciaCgg_tct_tipo_hospedaje = IN_SENTENCIA_CGG_TCT_TIPO_HOSPEDAJE;
    var inRecordCgg_tct_tipo_hospedaje=IN_RECORD_CGG_TCT_TIPO_HOSPEDAJE;
    var urlCgg_tct_tipo_hospedaje=URL_WS+"Cgg_tct_tipo_hospedaje";
    var tituloCgg_tct_tipo_hospedaje='Tipo Hospedaje';
    var descCgg_tct_tipo_hospedaje='El formulario permite administrar la informaci\u00f3n del Tipo Hospedaje';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE HOSPEDAJE
     */
    var txtCtthj_codigo = new Ext.form.TextField({
        id:'txtCtthj_codigo',
        name:'txtCtthj_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true
    });
    /**
     * Ext.form.TextField NOMBRE DEL TIPO DE HOSPEDAJE
     */
    var txtCtthj_nombre = new Ext.form.TextField({
        id:'txtCtthj_nombre',
        name:'txtCtthj_nombre',
        fieldLabel :'Nombre',
        anchor:'98%'
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_tct_tipo_hospedaje
     */
    var btnGuardarCgg_tct_tipo_hospedaje = new Ext.Button({
        id:'btnGuardarCgg_tct_tipo_hospedaje',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_tct_tipo_hospedaje.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_tct_tipo_hospedaje(r){
                        winFrmCgg_tct_tipo_hospedaje.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_tct_tipo_hospedaje,
                                msg: 'La informaci\u00f3n del Tipo Hospedaje ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_tct_tipo_hospedaje.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_tct_tipo_hospedaje,
                                msg: 'La informaci\u00f3n del Tipo Hospedaje no ha podido ser almacenada. '+ (r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_tct_tipo_hospedaje.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCtthj_codigo',txtCtthj_codigo.getValue());
                    param.add('inCtthj_nombre',txtCtthj_nombre.getValue());
                    SOAPClient.invoke(urlCgg_tct_tipo_hospedaje,IN_SENTENCIA_CGG_TCT_TIPO_HOSPEDAJE,param, true, CallBackCgg_tct_tipo_hospedaje);
                }catch(inErr){
                    winFrmCgg_tct_tipo_hospedaje.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_tct_tipo_hospedaje.
     */
    var btnCancelarCgg_tct_tipo_hospedaje = new Ext.Button({
        id:'btnCancelarCgg_tct_tipo_hospedaje',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_tct_tipo_hospedaje.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_tct_tipo_hospedaje.
     */
    var btnCerrarCgg_tct_tipo_hospedaje = new Ext.Button({
        id:'btnCerrarCgg_tct_tipo_hospedaje',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_tct_tipo_hospedaje.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_tct_tipo_hospedaje.
     */
    var pnlCgg_tct_tipo_hospedaje = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCtthj_codigo,txtCtthj_nombre]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_tct_tipo_hospedaje.
     */
    var winFrmCgg_tct_tipo_hospedaje = new Ext.Window({
        id:'winFrmCgg_tct_tipo_hospedaje',
        title:tituloCgg_tct_tipo_hospedaje,
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        modal :true,
        resizeable:false,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_tct_tipo_hospedaje,descCgg_tct_tipo_hospedaje),
        items:[pnlCgg_tct_tipo_hospedaje],
        bbar:[btnGuardarCgg_tct_tipo_hospedaje,btnCancelarCgg_tct_tipo_hospedaje,'->',btnCerrarCgg_tct_tipo_hospedaje]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_tct_tipo_hospedaje.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_tct_tipo_hospedajeCtrls(inEstado){
        estado=!inEstado;
        txtCtthj_codigo.setDisabled(estado);
        txtCtthj_nombre.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_tct_tipo_hospedaje.
     */
    function cargarCgg_tct_tipo_hospedajeCtrls(){
        if(inRecordCgg_tct_tipo_hospedaje){
            txtCtthj_codigo.setValue(inRecordCgg_tct_tipo_hospedaje.get('CTTHJ_CODIGO'));
            txtCtthj_nombre.setValue(inRecordCgg_tct_tipo_hospedaje.get('CTTHJ_NOMBRE'));
            isEdit = true;
            habilitarCgg_tct_tipo_hospedajeCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_tct_tipo_hospedaje.
     * @returns ventana winFrmCgg_tct_tipo_hospedaje.
     * @base FrmCgg_tct_tipo_hospedaje.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_tct_tipo_hospedaje;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_tct_tipo_hospedaje.
     * @base FrmCgg_tct_tipo_hospedaje.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_tct_tipo_hospedajeCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_tct_tipo_hospedaje desde una instancia.
 */
FrmCgg_tct_tipo_hospedaje.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_tct_tipo_hospedaje desde una instancia.
 */
FrmCgg_tct_tipo_hospedaje.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_tct_tipo_hospedaje,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_tct_tipo_hospedaje.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_tct_tipo_hospedaje desde una instancia.
 */
FrmCgg_tct_tipo_hospedaje.prototype.loadData = function(){
    this.loadData();
}
