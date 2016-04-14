/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_tct_actividad.
 * @param {String} INSENTENCIA_CGG_TCT_ACTIVIDAD Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_TCT_ACTIVIDAD Registro de datos de la tabla Cgg_tct_actividad.
 * @constructor
 * @base FrmListadoCgg_tct_actividad
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_tct_actividad(INSENTENCIA_CGG_TCT_ACTIVIDAD,INRECORD_CGG_TCT_ACTIVIDAD){
    var inSentenciaCgg_tct_actividad = INSENTENCIA_CGG_TCT_ACTIVIDAD;
    var inRecordCgg_tct_actividad=INRECORD_CGG_TCT_ACTIVIDAD;
    var urlCgg_tct_actividad=URL_WS+"Cgg_tct_actividad";
    var tituloCgg_tct_actividad='Actividad';
    var descCgg_tct_actividad='El formulario permite administrar informaci\u00f3n de la Actividad';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ACTIVIDADES
     */
    var txtCtact_codigo = new Ext.form.TextField({
        id:'txtCtact_codigo',
        name:'txtCtact_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true
    });
    /**
     * Ext.form.TextField NOMBRE DE LA ACTIVIDAD  A REALIZAR
     */
    var txtCtact_nombre = new Ext.form.TextField({
        id:'txtCtact_nombre',
        name:'txtCtact_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_tct_actividad
     */
    var btnGuardarCgg_tct_actividad = new Ext.Button({
        id:'btnGuardarCgg_tct_actividad',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_tct_actividad.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_tct_actividad(r){
                        winFrmCgg_tct_actividad.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_tct_actividad,
                                msg: 'La informaci\u00f3n de la Actividad ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_tct_actividad.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_tct_actividad,
                                msg: 'La informaci\u00f3n de la Actividad no ha podido ser almacenada. '+ (r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_tct_actividad.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCtact_codigo',txtCtact_codigo.getValue());
                    param.add('inCtact_nombre',txtCtact_nombre.getValue());
                    SOAPClient.invoke(urlCgg_tct_actividad,INSENTENCIA_CGG_TCT_ACTIVIDAD,param, true, CallBackCgg_tct_actividad);
                }catch(inErr){
                    winFrmCgg_tct_actividad.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_tct_actividad.
     */
    var btnCancelarCgg_tct_actividad = new Ext.Button({
        id:'btnCancelarCgg_tct_actividad',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_tct_actividad.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_tct_actividad.
     */
    var btnCerrarCgg_tct_actividad = new Ext.Button({
        id:'btnCerrarCgg_tct_actividad',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_tct_actividad.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_tct_actividad.
     */
    var pnlCgg_tct_actividad = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCtact_codigo,txtCtact_nombre]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_tct_actividad.
     */
    var winFrmCgg_tct_actividad = new Ext.Window({
        id:'winFrmCgg_tct_actividad',
        title:tituloCgg_tct_actividad,
        tbar:getPanelTitulo(tituloCgg_tct_actividad,descCgg_tct_actividad),
        items:[pnlCgg_tct_actividad],
        width:405,
        resizable:false,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_tct_actividad,btnCancelarCgg_tct_actividad,'->',btnCerrarCgg_tct_actividad]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_tct_actividad.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_tct_actividadCtrls(inEstado){
        estado=!inEstado;
        txtCtact_codigo.setDisabled(estado);
        txtCtact_nombre.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_tct_actividad.
     */
    function cargarCgg_tct_actividadCtrls(){
        if(inRecordCgg_tct_actividad){
            txtCtact_codigo.setValue(inRecordCgg_tct_actividad.get('CTACT_CODIGO'));
            txtCtact_nombre.setValue(inRecordCgg_tct_actividad.get('CTACT_NOMBRE'));
            isEdit = true;
            habilitarCgg_tct_actividadCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_tct_actividad.
     * @returns ventana winFrmCgg_tct_actividad.
     * @base FrmCgg_tct_actividad.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_tct_actividad;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_tct_actividad.
     * @base FrmCgg_tct_actividad.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_tct_actividadCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_tct_actividad desde una instancia.
 */
FrmCgg_tct_actividad.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_tct_actividad desde una instancia.
 */
FrmCgg_tct_actividad.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_tct_actividad,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_tct_actividad.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_tct_actividad desde una instancia.
 */
FrmCgg_tct_actividad.prototype.loadData = function(){
    this.loadData();
}
