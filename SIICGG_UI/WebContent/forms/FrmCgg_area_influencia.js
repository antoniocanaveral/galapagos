/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_area_influencia.
 * @param {String} IN_SENTENCIA_CGG_AREA_INFLUENCIA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_AREA_INFLUENCIA Registro de datos de la tabla Cgg_area_influencia.
 * @constructor
 * @base FrmListadoCgg_area_influencia
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_area_influencia(IN_SENTENCIA_CGG_AREA_INFLUENCIA,IN_RECORD_CGG_AREA_INFLUENCIA){
    var inSentenciaCgg_area_influencia = IN_SENTENCIA_CGG_AREA_INFLUENCIA;
    var inRecordCgg_area_influencia=IN_RECORD_CGG_AREA_INFLUENCIA;
    var urlCgg_area_influencia=URL_WS+"Cgg_area_influencia";
    var tituloCgg_area_influencia='Area Influencia';
    var descCgg_area_influencia='El formulario permite administrar la informaci\u00f3n de Area Influencia';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE AREA DE INFLUENCIA
     */
    var txtCainf_codigo = new Ext.form.TextField({
        id:'txtCainf_codigo',
        name:'txtCainf_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField NOMBRE DEL AREA DE INFLUENCIA
     */
    var txtCainf_nombre = new Ext.form.TextField({
        id:'txtCainf_nombre',
        name:'txtCainf_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField ALMACENA LA DESCRIPCION DEL AREA DE INFLUENCIA
     */
    var txtCainf_descripcion = new Ext.form.TextArea({
        id:'txtCainf_descripcion',
        name:'txtCainf_descripcion',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_area_influencia
     */
    var btnGuardarCgg_area_influencia = new Ext.Button({
        id:'btnGuardarCgg_area_influencia',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (!pnlCgg_area_influencia.getForm().isValid()){
                    return;
                }
                try{
                    function CallBackCgg_area_influencia(r){
                        winFrmCgg_area_influencia.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_area_influencia,
                                msg: 'El Area de influencia ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_area_influencia.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_area_influencia,
                                msg: 'El Area de influencia no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_area_influencia.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCainf_codigo',txtCainf_codigo.getValue());
                    param.add('inCainf_nombre',txtCainf_nombre.getValue());
                    param.add('inCainf_descripcion',txtCainf_descripcion.getValue());
                    SOAPClient.invoke(urlCgg_area_influencia,IN_SENTENCIA_CGG_AREA_INFLUENCIA,param, true, CallBackCgg_area_influencia);
                }catch(inErr){
                    winFrmCgg_area_influencia.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_area_influencia.
     */
    var btnCancelarCgg_area_influencia = new Ext.Button({
        id:'btnCancelarCgg_area_influencia',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_area_influencia.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_area_influencia.
     */
    var btnCerrarCgg_area_influencia = new Ext.Button({
        id:'btnCerrarCgg_area_influencia',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_area_influencia.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_area_influencia.
     */
    var pnlCgg_area_influencia = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCainf_codigo,txtCainf_nombre,txtCainf_descripcion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_area_influencia.
     */
    var winFrmCgg_area_influencia = new Ext.Window({
        id:'winFrmCgg_area_influencia',
        title:tituloCgg_area_influencia,
        iconCls:'iconAplicacion',
        width:400,
        minWidth:400,
        maximizable:false,
        modal:true,
        resizable:false,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_area_influencia,descCgg_area_influencia),
        items:[pnlCgg_area_influencia],
        bbar:[btnGuardarCgg_area_influencia,btnCancelarCgg_area_influencia,'->',btnCerrarCgg_area_influencia]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_area_influencia.getBottomToolbar());
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_area_influencia.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_area_influenciaCtrls(inEstado){
        estado=!inEstado;
        txtCainf_codigo.setDisabled(estado);
        txtCainf_nombre.setDisabled(estado);
        txtCainf_descripcion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_area_influencia.
     */
    function cargarCgg_area_influenciaCtrls(){
        if(inRecordCgg_area_influencia){
            txtCainf_codigo.setValue(inRecordCgg_area_influencia.get('CAINF_CODIGO'));
            txtCainf_nombre.setValue(inRecordCgg_area_influencia.get('CAINF_NOMBRE'));
            txtCainf_descripcion.setValue(inRecordCgg_area_influencia.get('CAINF_DESCRIPCION'));
            isEdit = true;
            habilitarCgg_area_influenciaCtrls(true);
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_area_influencia.
     * @returns ventana winFrmCgg_area_influencia.
     * @base FrmCgg_area_influencia.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_area_influencia;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_area_influencia.
     * @base FrmCgg_area_influencia.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_area_influenciaCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_area_influencia desde una instancia.
 */
FrmCgg_area_influencia.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_area_influencia desde una instancia.
 */
FrmCgg_area_influencia.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_area_influencia,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_area_influencia.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_area_influencia desde una instancia.
 */
FrmCgg_area_influencia.prototype.loadData = function(){
    this.loadData();
}
