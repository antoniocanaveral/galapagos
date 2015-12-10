/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_tipo_notificacion.
 * @param {String} INSENTENCIA_CGG_RES_TIPO_NOTIFICACION Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_TIPO_NOTIFICACION Registro de datos de la tabla Cgg_res_tipo_notificacion.
 * @constructor
 * @base FrmListadoCgg_res_tipo_notificacion
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_tipo_notificacion(INSENTENCIA_CGG_RES_TIPO_NOTIFICACION,INRECORD_CGG_RES_TIPO_NOTIFICACION){
    var inSentenciaCgg_res_tipo_notificacion = INSENTENCIA_CGG_RES_TIPO_NOTIFICACION;
    var inRecordCgg_res_tipo_notificacion=INRECORD_CGG_RES_TIPO_NOTIFICACION;
    var urlCgg_res_tipo_notificacion=URL_WS+"Cgg_res_tipo_notificacion";
    var tituloCgg_res_tipo_notificacion='Ingreso tipo notificaci\u00f3n';
    var descCgg_res_tipo_notificacion='Formulario para ingresar informaci\u00f3n de tipo notificaci\u00f3n';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGSITRO
     */
    var txtCrtnt_codigo = new Ext.form.TextField({
        id:'txtCrtnt_codigo',
        name:'txtCrtnt_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField DESCRIPCION DEL TIPO DE RESIDENCIA
     */
    var txtCrtnt_descripcion = new Ext.form.TextField({
        id:'txtCrtnt_descripcion',
        name:'txtCrtnt_descripcion',
        fieldLabel :'Tipo notificacion',
        anchor:'98%',
        allowBlank :false,
        maxLength:100
    });
    /**
     * Ext.form.Checkbox ESTADO QUE DETERMINA SI EL TIPO DE NOTIFICACION ES CAUSAL DE SALIDA
     */
    var chkCrtnt_causal_salida = new Ext.form.Checkbox({
        id:'chkCrtnt_causal_salida',
        name:'chkCrtnt_causal_salida',
        fieldLabel :'Causal salida',
        allowBlank :false,
        checked:true
    });
    /**
     * Ext.form.TextArea DESCRIPCION DEL SUSTENTO LEGAL QUE RESPALDA LA NOTIFICACION
     */
    var txtCrtnt_sustento_legal = new Ext.form.TextArea({
        id:'txtCrtnt_sustento_legal',
        name:'txtCrtnt_sustento_legal',
        fieldLabel :'Sustento legal',
        width:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.Checkbox ESTADO QUE DETERMINA SI EL TIPO DE NOTIFICACION TENDRA UNA CONSECUENCIA
     */
    var chkCrtnt_causal_caducidad = new Ext.form.Checkbox({
        id:'chkCrtnt_causal_caducidad',
        name:'chkCrtnt_causal_caducidad',
        fieldLabel :'Causal caducidad',
        allowBlank :false,
        checked:true
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_tipo_notificacion
     */
    var btnGuardarCgg_res_tipo_notificacion = new Ext.Button({
        id:'btnGuardarCgg_res_tipo_notificacion',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:'Almacena la inforci\u00f3n tipo notificaci\u00f3n',
        listeners:{
            click:function(){
                if (pnlCgg_res_tipo_notificacion.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_tipo_notificacion(r){
                        winFrmCgg_res_tipo_notificacion.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_tipo_notificacion,
                                msg: 'La informaci\u00f3n de tipo notificaci\u00f3n ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_tipo_notificacion.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_tipo_notificacion,
                                msg: 'La informaci\u00f3n de tipo notificaci\u00f3n no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_tipo_notificacion.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                    param.add('inCrtnt_codigo',txtCrtnt_codigo.getValue());
                    param.add('inCrtnt_descripcion',txtCrtnt_descripcion.getValue());
                    param.add('inCrtnt_causal_salida',chkCrtnt_causal_salida.getValue());
                    param.add('inCrtnt_sustento_legal',txtCrtnt_sustento_legal.getValue());
                    param.add('inCrtnt_causal_caducidad',chkCrtnt_causal_caducidad.getValue());
                    SOAPClient.invoke(urlCgg_res_tipo_notificacion,INSENTENCIA_CGG_RES_TIPO_NOTIFICACION,param, true, CallBackCgg_res_tipo_notificacion);
                }catch(inErr){
                    winFrmCgg_res_tipo_notificacion.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_tipo_notificacion.
     */
    var btnCancelarCgg_res_tipo_notificacion = new Ext.Button({
        id:'btnCancelarCgg_res_tipo_notificacion',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:'Cancela la inforci\u00f3n almacenarse ',
        listeners:{
            click:function(){
                pnlCgg_res_tipo_notificacion.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_tipo_notificacion.
     */
    var btnCerrarCgg_res_tipo_notificacion = new Ext.Button({
        id:'btnCerrarCgg_res_tipo_notificacion',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Salir',
        listeners:{
            click:function(){
                winFrmCgg_res_tipo_notificacion.close();
            }}
    });

    var pnlCgg_res_tipo_notificacion_causal = new Ext.Panel({
           labelWidth: 100,
           frame:false,
           items: [{
               xtype:'fieldset',
               //checkboxName:'chkControlCausal',
               //checkboxToggle:true,
               title: 'Causal',
               autoHeight:true,
               //defaults: {width: 210},
             // collapsed: true,
               items :[
                   {
                       xtype:'panel',
                       layout:'column',
                       items:[
                           {
                               columnWidth:.6,
                               layout:'form',
                               items:[chkCrtnt_causal_salida ]
                           }, {
                               columnWidth:.4,
                               layout:'form',
                               items:[chkCrtnt_causal_caducidad]
                           }

                       ]
                   }

               ]


           }]
       });
     /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_tipo_notificacion.
     */
    var pnlCgg_res_tipo_notificacion = new Ext.form.FormPanel({
        frame:true,
        labelWidth :120,
        items: [{

               autoHeight:true,
               items :[
                   {
                       xtype:'panel',
                       layout:'column',
                       items:[
                           {
                               columnWidth:.6,
                               layout:'form',
                               items:[txtCrtnt_codigo ]
                           },
                       ]
                   },
                   {
                       xtype:'panel',
                       layout:'column',
                       items:[
                           {
                               columnWidth:.9,
                               layout:'form',
                               items:[txtCrtnt_descripcion]
                           }

                       ]
                   },
                       {
                       xtype:'panel',
                       layout:'column',
                       items:[
                           {
                               columnWidth:.9,
                               layout:'form',
                               items:[txtCrtnt_sustento_legal]
                           }

                       ]
                   }, pnlCgg_res_tipo_notificacion_causal
               ]


           }   ]

    });

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_tipo_notificacion.
     */
    var winFrmCgg_res_tipo_notificacion = new Ext.Window({
        id:'winFrmCgg_res_tipo_notificacion',
        title:tituloCgg_res_tipo_notificacion,
        tbar:getPanelTitulo(tituloCgg_res_tipo_notificacion,descCgg_res_tipo_notificacion),
        items:[pnlCgg_res_tipo_notificacion],
        width:400,
        minWidth:400,
        resizable: true,
        modal: true,
        constrain:true,
        bbar:[btnGuardarCgg_res_tipo_notificacion,btnCancelarCgg_res_tipo_notificacion,'->',btnCerrarCgg_res_tipo_notificacion]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_tipo_notificacion.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_tipo_notificacionCtrls(inEstado){
        estado=!inEstado;
        txtCrtnt_codigo.setDisabled(estado);
        txtCrtnt_descripcion.setDisabled(estado);
        chkCrtnt_causal_salida.setDisabled(estado);
        txtCrtnt_sustento_legal.setDisabled(estado);
        chkCrtnt_causal_caducidad.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_tipo_notificacion.
     */
    function cargarCgg_res_tipo_notificacionCtrls(){
        if(inRecordCgg_res_tipo_notificacion){
            txtCrtnt_codigo.setValue(inRecordCgg_res_tipo_notificacion.get('CRTNT_CODIGO'));
            txtCrtnt_descripcion.setValue(inRecordCgg_res_tipo_notificacion.get('CRTNT_DESCRIPCION'));
            chkCrtnt_causal_salida.setValue(inRecordCgg_res_tipo_notificacion.get('CRTNT_CAUSAL_SALIDA'));
            txtCrtnt_sustento_legal.setValue(inRecordCgg_res_tipo_notificacion.get('CRTNT_SUSTENTO_LEGAL'));
            chkCrtnt_causal_caducidad.setValue(inRecordCgg_res_tipo_notificacion.get('CRTNT_CAUSAL_CADUCIDAD'));
            isEdit = true;
            habilitarCgg_res_tipo_notificacionCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_tipo_notificacion.
     * @returns ventana winFrmCgg_res_tipo_notificacion.
     * @base FrmCgg_res_tipo_notificacion.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_tipo_notificacion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_tipo_notificacion.
     * @base FrmCgg_res_tipo_notificacion.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_tipo_notificacionCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_tipo_notificacion desde una instancia.
 */
FrmCgg_res_tipo_notificacion.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_tipo_notificacion desde una instancia.
 */
FrmCgg_res_tipo_notificacion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_tipo_notificacion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_tipo_notificacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_tipo_notificacion desde una instancia.
 */
FrmCgg_res_tipo_notificacion.prototype.loadData = function(){
    this.loadData();
}
