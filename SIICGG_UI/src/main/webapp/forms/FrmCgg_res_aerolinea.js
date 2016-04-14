/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_aerolinea.
 * @param {String} INSENTENCIA_CGG_RES_AEROLINEA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_AEROLINEA Registro de datos de la tabla Cgg_res_aerolinea.
 * @constructor
 * @base FrmListadoCgg_res_aerolinea
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_aerolinea(INSENTENCIA_CGG_RES_AEROLINEA,INRECORD_CGG_RES_AEROLINEA){
    var inSentenciaCgg_res_aerolinea = INSENTENCIA_CGG_RES_AEROLINEA;
    var inRecordCgg_res_aerolinea=INRECORD_CGG_RES_AEROLINEA;
    var urlCgg_res_aerolinea=URL_WS+"Cgg_res_aerolinea";
    var tituloCgg_res_aerolinea='Aerol\u00ednea';
    var descCgg_res_aerolinea='El formulario permite administrar informaci\u00f3n de la Aerol\u00ednea';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCraln_codigo = new Ext.form.TextField({
        id:'txtCraln_codigo',
        name:'txtCraln_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true
    });
    /**
     * Ext.form.TextField NOMBRE DE LA AEROLINEA
     */
    var txtCraln_nombre = new Ext.form.TextField({
        id:'txtCraln_nombre',
        name:'txtCraln_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.NumberField IDENTIFICATIVO DEL TIPO DE AEROLINEA
     0 - EXTERNO
     1 - INTERNO
     */
    var numCraln_tipo_aerolinea = new Ext.form.NumberField({
        id:'numCraln_tipo_aerolinea',
        name:'numCraln_tipo_aerolinea',
        fieldLabel :'Tipo aerolinea',
        allowBlank :false,
        disabled :false
    });
    var sttipo_aerolinea = new Ext.data.ArrayStore({
        fields:['id','tipoaerolinea'],
        data:dsTipoAerolinea
    });
    var cbxCraln_tipo = new Ext.form.ComboBox({
        id:'cbxCraln_tipo',
        name:'cbxCraln_tipo',
        store:sttipo_aerolinea ,
        fieldLabel :'Tipo aerolinea',
        displayField: 'tipoaerolinea',
        valueField: 'id',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        hiddenId:'cbxCraln_tipoH',
        hiddenName:'cbxCraln_tipoH',
        hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'70%',
        triggerAction:'all',
        emptyText : 'Seleccione una opci\u00f3n..'
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_aerolinea
     */
    var btnGuardarCgg_res_aerolinea = new Ext.Button({
        id:'btnGuardarCgg_res_aerolinea',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_aerolinea.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_aerolinea(r){
                        winFrmCgg_res_aerolinea.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_aerolinea,
                                msg: 'La informaci\u00f3n de la Aerol\u00ednea ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_aerolinea.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_aerolinea,
                                msg: 'La informaci\u00f3n de la Aerol\u00ednea no ha podido ser almacenada.'+ (r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_aerolinea.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCraln_codigo',txtCraln_codigo.getValue());
                    param.add('inCraln_nombre',txtCraln_nombre.getValue());
                    param.add('inCraln_tipo_aerolinea',cbxCraln_tipo.getValue());
                    SOAPClient.invoke(urlCgg_res_aerolinea,INSENTENCIA_CGG_RES_AEROLINEA,param, true, CallBackCgg_res_aerolinea);
                }catch(inErr){
                    winFrmCgg_res_aerolinea.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_aerolinea.
     */
    var btnCancelarCgg_res_aerolinea = new Ext.Button({
        id:'btnCancelarCgg_res_aerolinea',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_aerolinea.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_aerolinea.
     */
    var btnCerrarCgg_res_aerolinea = new Ext.Button({
        id:'btnCerrarCgg_res_aerolinea',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_aerolinea.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_aerolinea.
     */
    var pnlCgg_res_aerolinea = new Ext.form.FormPanel({
        frame:true,
        labelWidth :50,
        items:[txtCraln_codigo,txtCraln_nombre,cbxCraln_tipo]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_aerolinea.
     */
    var winFrmCgg_res_aerolinea = new Ext.Window({
        id:'winFrmCgg_res_aerolinea',
        title:tituloCgg_res_aerolinea,
        tbar:getPanelTitulo(tituloCgg_res_aerolinea,descCgg_res_aerolinea),
        items:[pnlCgg_res_aerolinea],
        width:400,
        minWidth:400,
        modal:true,
        resizable :false,
        maximizable:false,
        minimizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_res_aerolinea,btnCancelarCgg_res_aerolinea,'->',btnCerrarCgg_res_aerolinea]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_aerolinea.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_aerolineaCtrls(inEstado){
        estado=!inEstado;
        txtCraln_codigo.setDisabled(estado);
        txtCraln_nombre.setDisabled(estado);
        cbxCraln_tipo.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_aerolinea.
     */
    function cargarCgg_res_aerolineaCtrls(){
        if(inRecordCgg_res_aerolinea){
            txtCraln_codigo.setValue(inRecordCgg_res_aerolinea.get('CRALN_CODIGO'));
            txtCraln_nombre.setValue(inRecordCgg_res_aerolinea.get('CRALN_NOMBRE'));
            cbxCraln_tipo.setValue(inRecordCgg_res_aerolinea.get('CRALN_TIPO_AEROLINEA'));
            isEdit = true;
            habilitarCgg_res_aerolineaCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_aerolinea.
     * @returns ventana winFrmCgg_res_aerolinea.
     * @base FrmCgg_res_aerolinea.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_aerolinea;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_aerolinea.
     * @base FrmCgg_res_aerolinea.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_aerolineaCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_aerolinea desde una instancia.
 */
FrmCgg_res_aerolinea.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_aerolinea desde una instancia.
 */
FrmCgg_res_aerolinea.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_aerolinea,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_aerolinea.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_aerolinea desde una instancia.
 */
FrmCgg_res_aerolinea.prototype.loadData = function(){
    this.loadData();
}
