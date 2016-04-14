/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_nivel_estudio.
 * @param {String} INSENTENCIA_CGG_NIVEL_ESTUDIO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_NIVEL_ESTUDIO Registro de datos de la tabla Cgg_nivel_estudio.
 * @constructor
 * @base FrmListadoCgg_nivel_estudio
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_nivel_estudio(INSENTENCIA_CGG_NIVEL_ESTUDIO,INRECORD_CGG_NIVEL_ESTUDIO){
    var inSentenciaCgg_nivel_estudio = INSENTENCIA_CGG_NIVEL_ESTUDIO;
    var inRecordCgg_nivel_estudio=INRECORD_CGG_NIVEL_ESTUDIO;
    var urlCgg_nivel_estudio=URL_WS+"Cgg_nivel_estudio";
    var tituloCgg_nivel_estudio='Nivel estudio';
    var descCgg_nivel_estudio='El formulario permite administrar la informaci\u00f3n de Nivel estudio en educaci\u00f3n formal';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCgnes_codigo = new Ext.form.TextField({
        id:'txtCgnes_codigo',
        name:'txtCgnes_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField DESCRIPCION DEL NIVEL DE ESTUDIO
     */
    var txtCgnes_descripcion = new Ext.form.TextField({
        id:'txtCgnes_descripcion',
        name:'txtCgnes_descripcion',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.NumberField JERARQUIA DEL NIVEL DE ESTUDIO
     */


    var numCgnes_grado = new Ext.ux.form.SpinnerField({
        id:'numCgnes_grado',
        name:'numCgnes_grado',
        fieldLabel :'Grado',
        allowBlank :false,
        disabled :false,
        minValue: 1,
        maxValue: 10,
        anchor:'60%'

    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_nivel_estudio
     */
    var btnGuardarCgg_nivel_estudio = new Ext.Button({
        id:'btnGuardarCgg_nivel_estudio',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_nivel_estudio.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_nivel_estudio(r){
                        winFrmCgg_nivel_estudio.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_nivel_estudio,
                                msg: 'La informaci\u00f3n de Nivel estudio ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_nivel_estudio.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_nivel_estudio,
                                msg: 'La informaci\u00f3n de Nivel estudio no ha podido ser almacenada. '+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_nivel_estudio.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCgnes_codigo',txtCgnes_codigo.getValue());
                    param.add('inCgnes_descripcion',txtCgnes_descripcion.getValue());
                    param.add('inCgnes_grado',numCgnes_grado.getValue());
                    SOAPClient.invoke(urlCgg_nivel_estudio,INSENTENCIA_CGG_NIVEL_ESTUDIO,param, true, CallBackCgg_nivel_estudio);
                }catch(inErr){
                    winFrmCgg_nivel_estudio.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_nivel_estudio.
     */
    var btnCancelarCgg_nivel_estudio = new Ext.Button({
        id:'btnCancelarCgg_nivel_estudio',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_nivel_estudio.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_nivel_estudio.
     */
    var btnCerrarCgg_nivel_estudio = new Ext.Button({
        id:'btnCerrarCgg_nivel_estudio',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_nivel_estudio.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_nivel_estudio.
     */
    var pnlCgg_nivel_estudio = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCgnes_codigo,txtCgnes_descripcion,numCgnes_grado]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_nivel_estudio.
     */
    var winFrmCgg_nivel_estudio = new Ext.Window({
        id:'winFrmCgg_nivel_estudio',
        title:tituloCgg_nivel_estudio,
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        constrain:true,
        resizable:false,
        modal:true,
        tbar:getPanelTitulo(tituloCgg_nivel_estudio,descCgg_nivel_estudio),
        items:[pnlCgg_nivel_estudio],
        bbar:[btnGuardarCgg_nivel_estudio,btnCancelarCgg_nivel_estudio,'->',btnCerrarCgg_nivel_estudio]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_nivel_estudio.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_nivel_estudioCtrls(inEstado){
        estado=!inEstado;
        txtCgnes_codigo.setDisabled(estado);
        txtCgnes_descripcion.setDisabled(estado);
        numCgnes_grado.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_nivel_estudio.
     */
    function cargarCgg_nivel_estudioCtrls(){
        if(inRecordCgg_nivel_estudio){
            txtCgnes_codigo.setValue(inRecordCgg_nivel_estudio.get('CGNES_CODIGO'));
            txtCgnes_descripcion.setValue(inRecordCgg_nivel_estudio.get('CGNES_DESCRIPCION'));
            numCgnes_grado.setValue(inRecordCgg_nivel_estudio.get('CGNES_GRADO'));
            isEdit = true;
            habilitarCgg_nivel_estudioCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_nivel_estudio.
     * @returns ventana winFrmCgg_nivel_estudio.
     * @base FrmCgg_nivel_estudio.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_nivel_estudio;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_nivel_estudio.
     * @base FrmCgg_nivel_estudio.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_nivel_estudioCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_nivel_estudio desde una instancia.
 */
FrmCgg_nivel_estudio.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_nivel_estudio desde una instancia.
 */
FrmCgg_nivel_estudio.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_nivel_estudio,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_nivel_estudio.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_nivel_estudio desde una instancia.
 */
FrmCgg_nivel_estudio.prototype.loadData = function(){
    this.loadData();
}
