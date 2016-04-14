/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_nacionalidad.
 * @param {String} INSENTENCIA_CGG_NACIONALIDAD Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_NACIONALIDAD Registro de datos de la tabla Cgg_nacionalidad.
 * @constructor
 * @base FrmListadoCgg_nacionalidad
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_nacionalidad(INSENTENCIA_CGG_NACIONALIDAD,INRECORD_CGG_NACIONALIDAD){
    var inSentenciaCgg_nacionalidad = INSENTENCIA_CGG_NACIONALIDAD;
    var inRecordCgg_nacionalidad=INRECORD_CGG_NACIONALIDAD;
    var urlCgg_nacionalidad=URL_WS+"Cgg_nacionalidad";
    var tituloCgg_nacionalidad='Nacionalidad';
    var descCgg_nacionalidad='El formulario permite administrar informaci\u00f3n de Nacionalidad';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE NACIONALIDAD
     */
    var txtCgncn_codigo = new Ext.form.TextField({
        id:'txtCgncn_codigo',
        name:'txtCgncn_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField NOMBRE DE LA NACIONALIDAD
     */
    var txtCgncn_nacionalidad = new Ext.form.TextField({
        id:'txtCgncn_nacionalidad',
        name:'txtCgncn_nacionalidad',
        fieldLabel :'Nacionalidad',
        anchor:'98%',
        allowBlank :false,
        maxLength :100
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_nacionalidad
     */
    var btnGuardarCgg_nacionalidad = new Ext.Button({
        id:'btnGuardarCgg_nacionalidad',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:'Guardar',
        listeners:{
            click:function(){
                if (pnlCgg_nacionalidad.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_nacionalidad(r){
                        winFrmCgg_nacionalidad.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_nacionalidad,
                                msg: 'La informaci\u00f3n de Nacionalidad ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_nacionalidad.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_nacionalidad,
                                msg: 'La informaci\u00f3n de Nacionalidad no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_nacionalidad.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCgncn_codigo',txtCgncn_codigo.getValue());
                    param.add('inCgncn_nacionalidad',txtCgncn_nacionalidad.getValue());
                    SOAPClient.invoke(urlCgg_nacionalidad,INSENTENCIA_CGG_NACIONALIDAD,param, true, CallBackCgg_nacionalidad);
                }catch(inErr){
                    winFrmCgg_nacionalidad.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_nacionalidad.
     */
    var btnCancelarCgg_nacionalidad = new Ext.Button({
        id:'btnCancelarCgg_nacionalidad',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:'Cancelar edici\u00f3n',        
        listeners:{
            click:function(){
                pnlCgg_nacionalidad.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_nacionalidad.
     */
    var btnCerrarCgg_nacionalidad = new Ext.Button({
        id:'btnCerrarCgg_nacionalidad',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerrar',
        listeners:{
            click:function(){
                winFrmCgg_nacionalidad.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_nacionalidad.
     */
    var pnlCgg_nacionalidad = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCgncn_codigo,txtCgncn_nacionalidad]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_nacionalidad.
     */
    var winFrmCgg_nacionalidad = new Ext.Window({
        id:'winFrmCgg_nacionalidad',
        title:tituloCgg_nacionalidad,
        tbar:getPanelTitulo(tituloCgg_nacionalidad,descCgg_nacionalidad),
        items:[pnlCgg_nacionalidad],
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        modal:true,
        resizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_nacionalidad,btnCancelarCgg_nacionalidad,'->',btnCerrarCgg_nacionalidad]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_nacionalidad.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_nacionalidadCtrls(inEstado){
        estado=!inEstado;
        txtCgncn_codigo.setDisabled(estado);
        txtCgncn_nacionalidad.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_nacionalidad.
     */
    function cargarCgg_nacionalidadCtrls(){
        if(inRecordCgg_nacionalidad){
            txtCgncn_codigo.setValue(inRecordCgg_nacionalidad.get('CGNCN_CODIGO'));
            txtCgncn_nacionalidad.setValue(inRecordCgg_nacionalidad.get('CGNCN_NACIONALIDAD'));
            isEdit = true;
            habilitarCgg_nacionalidadCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_nacionalidad.
     * @returns ventana winFrmCgg_nacionalidad.
     * @base FrmCgg_nacionalidad.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_nacionalidad;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_nacionalidad.
     * @base FrmCgg_nacionalidad.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_nacionalidadCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_nacionalidad desde una instancia.
 */
FrmCgg_nacionalidad.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_nacionalidad desde una instancia.
 */
FrmCgg_nacionalidad.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_nacionalidad,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_nacionalidad.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_nacionalidad desde una instancia.
 */
FrmCgg_nacionalidad.prototype.loadData = function(){
    this.loadData();
}
