/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_tipo_contrato.
 * @param {String} IN_SENTENCIA_CGG_GEM_TIPO_CONTRATO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_GEM_TIPO_CONTRATO Registro de datos de la tabla Cgg_gem_tipo_contrato.
 * @constructor
 * @base FrmListadoCgg_gem_tipo_contrato
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_gem_tipo_contrato(IN_SENTENCIA_CGG_GEM_TIPO_CONTRATO, IN_RECORD_CGG_GEM_TIPO_CONTRATO) {    
    var inSentenciaCgg_gem_tipo_contrato = IN_SENTENCIA_CGG_GEM_TIPO_CONTRATO;
    var inRecordCgg_gem_tipo_contrato = IN_RECORD_CGG_GEM_TIPO_CONTRATO;
    var urlCgg_gem_tipo_contrato = URL_WS + "Cgg_gem_tipo_contrato";
    var tituloCgg_gem_tipo_contrato = 'Tipo de contrato';
    var descCgg_gem_tipo_contrato = 'El formulario permite administrar la informaci\u00f3n de los tipos de contrato que se aplican a las ofertas';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO TIPO CONTRATO
     */
    var txtCgtcn_codigo = new Ext.form.TextField({
        id: 'txtCgtcn_codigo',
        name: 'txtCgtcn_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        value: "KEYGEN",
        hidden: true,
        hideLabel: true,
        allowBlank: false
    });
    /**
     * Ext.form.TextField DESCRIPCION DEL TIPO DE CONTRATO DE TRABAJO
     */
    var txtCgtcn_descripcion = new Ext.form.TextField({
        id: 'txtCgtcn_descripcion',
        name: 'txtCgtcn_descripcion',
        fieldLabel: 'Nombre',
        anchor: '98%',
        allowBlank: false
    });
    /**
     * Ext.form.TextField OBSERVACION DEL TIPO DE CONTRATO DE TRABAJO
     */
    var txtCgtcn_observacion = new Ext.form.TextArea({
        id: 'txtCgtcn_observacion',
        name: 'txtCgtcn_observacion',
        fieldLabel: 'Observaci\u00f3n',
        anchor: '98%'        
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_tipo_contrato
     */
    var btnGuardarCgg_gem_tipo_contrato = new Ext.Button({
        id: 'btnGuardarCgg_gem_tipo_contrato',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        listeners: {
            click: function () {
                if (pnlCgg_gem_tipo_contrato.getForm().isValid() == false) {
                    return;
                }
                try {
                    function CallBackCgg_gem_tipo_contrato(r) {
                        winFrmCgg_gem_tipo_contrato.getEl().unmask();
                        if (r == 'true') {
                            Ext.Msg.show({
                                title: tituloCgg_gem_tipo_contrato,
                                msg: 'La informaci\u00f3n ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_gem_tipo_contrato.close()
                        } else {
                            Ext.Msg.show({
                                title: tituloCgg_gem_tipo_contrato,
                                msg: 'La informaci\u00f3n no ha podido ser almacenada. ',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_gem_tipo_contrato.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if (isEdit) param.add('inCgtcn_codigo', txtCgtcn_codigo.getValue());
                    param.add('inCgtcn_descripcion', txtCgtcn_descripcion.getValue());
                    param.add('inCgtcn_observacion', txtCgtcn_observacion.getValue());
                    SOAPClient.invoke(urlCgg_gem_tipo_contrato, IN_SENTENCIA_CGG_GEM_TIPO_CONTRATO, param, true, CallBackCgg_gem_tipo_contrato);
                } catch (inErr) {
                    winFrmCgg_gem_tipo_contrato.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_tipo_contrato.
     */
    var btnCancelarCgg_gem_tipo_contrato = new Ext.Button({
        id: 'btnCancelarCgg_gem_tipo_contrato',
        text: 'Cancelar',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
                pnlCgg_gem_tipo_contrato.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_gem_tipo_contrato.
     */
    var btnCerrarCgg_gem_tipo_contrato = new Ext.Button({
        id: 'btnCerrarCgg_gem_tipo_contrato',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_gem_tipo_contrato.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_gem_tipo_contrato.
     */
    var pnlCgg_gem_tipo_contrato = new Ext.form.FormPanel({
        frame: true,
        labelWidth: 100,
        items: [txtCgtcn_codigo, txtCgtcn_descripcion, txtCgtcn_observacion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_tipo_contrato.
     */
    var winFrmCgg_gem_tipo_contrato = new Ext.Window({
        id: 'winFrmCgg_gem_tipo_contrato',
        title: tituloCgg_gem_tipo_contrato,
        width: 400,
        minWidth: 400,
        maximizable: false,
        minimizable: false,
        constrainHeader: true,
		resizable:false,
		modal:true,
        tbar: getPanelTitulo(tituloCgg_gem_tipo_contrato, descCgg_gem_tipo_contrato),
        items: [pnlCgg_gem_tipo_contrato],
        bbar: [btnGuardarCgg_gem_tipo_contrato, btnCancelarCgg_gem_tipo_contrato, '->', btnCerrarCgg_gem_tipo_contrato]
    });
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_gem_tipo_contrato.
     */
    function cargarCgg_gem_tipo_contratoCtrls() {
        if (inRecordCgg_gem_tipo_contrato) {
            txtCgtcn_codigo.setValue(inRecordCgg_gem_tipo_contrato.get('CGTCN_CODIGO'));
            txtCgtcn_descripcion.setValue(inRecordCgg_gem_tipo_contrato.get('CGTCN_DESCRIPCION'));
            txtCgtcn_observacion.setValue(inRecordCgg_gem_tipo_contrato.get('CGTCN_OBSERVACION'));
            isEdit = true;            
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_gem_tipo_contrato.
     * @returns ventana winFrmCgg_gem_tipo_contrato.
     * @base FrmCgg_gem_tipo_contrato.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_gem_tipo_contrato;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_gem_tipo_contrato.
     * @base FrmCgg_gem_tipo_contrato.prototype.loadData
     */
    this.loadData = function () {
        cargarCgg_gem_tipo_contratoCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_tipo_contrato desde una instancia.
 */
FrmCgg_gem_tipo_contrato.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_tipo_contrato desde una instancia.
 */
FrmCgg_gem_tipo_contrato.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_tipo_contrato,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_gem_tipo_contrato.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_tipo_contrato desde una instancia.
 */
FrmCgg_gem_tipo_contrato.prototype.loadData = function () {
    this.loadData();
}