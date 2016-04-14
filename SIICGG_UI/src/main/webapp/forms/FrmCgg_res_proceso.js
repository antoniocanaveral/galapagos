/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_proceso.
 * @param {String} INSENTENCIA_CGG_RES_PROCESO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_PROCESO Registro de datos de la tabla Cgg_res_proceso.
 * @constructor
 * @base FrmListadoCgg_res_proceso
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_proceso(INSENTENCIA_CGG_RES_PROCESO,INRECORD_CGG_RES_PROCESO){
    var inSentenciaCgg_res_proceso = INSENTENCIA_CGG_RES_PROCESO;
    var inRecordCgg_res_proceso=INRECORD_CGG_RES_PROCESO;
    var urlCgg_res_proceso=URL_WS+"Cgg_res_proceso";
    var tituloCgg_res_proceso='Registro de proceso';
    var descCgg_res_proceso='Formulario de ingreso de la informaci\u00f3n de los procesos';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
     */
    var txtCrpro_codigo = new Ext.form.TextField({
        id:'txtCrpro_codigo',
        name:'txtCrpro_codigo',
        fieldLabel :'Codigo',
       anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField INFORMACION DE IDENTIFICACION DEL PROCESO
     */
    var txtCrpro_nombre = new Ext.form.TextField({
        id:'txtCrpro_nombre',
        name:'txtCrpro_nombre',
        fieldLabel :'Nombre proceso',
        region: 'center',
        anchor:'98%',
        allowBlank :false,
        maxLength :100
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_proceso
     */
    var btnGuardarCgg_res_proceso = new Ext.Button({
        id:'btnGuardarCgg_res_proceso',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:'Almacena la informaci\u00f3n de proceso.',
        listeners:{
            click:function(){
                if (pnlCgg_res_proceso.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_proceso(r){
                        winFrmCgg_res_proceso.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_proceso,
                                msg: 'La informaci\u00f3n fue almacenada correctamente',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_proceso.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_proceso,
                                msg: 'No se pudo almacenar la informaci\u00f3n del proceso',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                
                    winFrmCgg_res_proceso.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                    {
                        param.add('inCrpro_codigo',txtCrpro_codigo.getValue());
                    }
                    param.add('inCrpro_nombre',txtCrpro_nombre.getValue());
                    SOAPClient.invoke(urlCgg_res_proceso,INSENTENCIA_CGG_RES_PROCESO,param, true, CallBackCgg_res_proceso);
                }catch(inErr){
                    winFrmCgg_res_proceso.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_proceso.
     */
    var btnCancelarCgg_res_proceso = new Ext.Button({
        id:'btnCancelarCgg_res_proceso',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:'Cancela la informaci\u00f3n almacenar.',
        listeners:{
            click:function(){
                pnlCgg_res_proceso.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_proceso.
     */
    var btnCerrarCgg_res_proceso = new Ext.Button({
        id:'btnCerrarCgg_res_proceso',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Salir.',
        listeners:{
            click:function(){
                winFrmCgg_res_proceso.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_proceso.
     */
    var pnlCgg_res_proceso = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCrpro_codigo,txtCrpro_nombre]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_proceso.
     */
    var winFrmCgg_res_proceso = new Ext.Window({
        id:'winFrmCgg_res_proceso',
        title:tituloCgg_res_proceso,
        tbar:getPanelTitulo(tituloCgg_res_proceso,descCgg_res_proceso),
        items:[pnlCgg_res_proceso],
        modal: true,
        width:400,
        minWidth:400,				
        resizable: false,
        constrain:true,
        bbar:[btnGuardarCgg_res_proceso,btnCancelarCgg_res_proceso,'->',btnCerrarCgg_res_proceso]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_proceso.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_procesoCtrls(inEstado){
        var estado=!inEstado;
        txtCrpro_codigo.setDisabled(estado);
        txtCrpro_nombre.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_proceso.
     */
    function cargarCgg_res_procesoCtrls(){
        if(inRecordCgg_res_proceso){
            txtCrpro_codigo.setValue(inRecordCgg_res_proceso.get('CRPRO_CODIGO'));
            txtCrpro_nombre.setValue(inRecordCgg_res_proceso.get('CRPRO_NOMBRE'));
            isEdit = true;
            habilitarCgg_res_procesoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_proceso.
     * @returns ventana winFrmCgg_res_proceso.
     * @base FrmCgg_res_proceso.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_proceso;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_proceso.
     * @base FrmCgg_res_proceso.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_procesoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_proceso desde una instancia.
 */
FrmCgg_res_proceso.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_proceso desde una instancia.
 */
FrmCgg_res_proceso.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_proceso,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_proceso.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_proceso desde una instancia.
 */
FrmCgg_res_proceso.prototype.loadData = function(){
    this.loadData();
}
