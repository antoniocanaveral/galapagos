/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_web_frase_bienvenida.
 * @param {String} IN_SENTENCIA_CGG_WEB_FRASE_BIENVENIDA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_WEB_FRASE_BIENVENIDA Registro de datos de la tabla Cgg_web_frase_bienvenida.
 * @constructor
 * @base FrmListadoCgg_web_frase_bienvenida
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_web_frase_bienvenida(IN_SENTENCIA_CGG_WEB_FRASE_BIENVENIDA, IN_RECORD_CGG_WEB_FRASE_BIENVENIDA) {
    var inSentenciaCgg_web_frase_bienvenida = IN_SENTENCIA_CGG_WEB_FRASE_BIENVENIDA;
    var inRecordCgg_web_frase_bienvenida = IN_RECORD_CGG_WEB_FRASE_BIENVENIDA;
    var urlCgg_web_frase_bienvenida = URL_WS + "Cgg_web_frase_bienvenida";
    var tituloCgg_web_frase_bienvenida = 'Web frase bienvenida';
    var descCgg_web_frase_bienvenida = 'El formulario permite administrar la informaci\u00f3n de la tabla Web frase bienvenida';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGSITRO
     */
    var txtCwfb_codigo = new Ext.form.TextField({
        id: 'txtCwfb_codigo',
        name: 'txtCwfb_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        value: "KEYGEN",
        hidden: true,
        hideLabel: true,
        allowBlank: false
    });
    /**
     * Ext.form.TextArea CONTENIDO DE LA FRASE O MENSAJE
     */
    var txtCwfb_contenido = new Ext.form.TextArea({
        id: 'txtCwfb_contenido',
        name: 'txtCwfb_contenido',
        fieldLabel: 'Contenido',
        width: '90%',
        allowBlank: false
    });
    /**
     * Ext.form.Checkbox HABILIDATO PARA MOSTRAR O NO
     */
    var chkCwfb_hibilitado = new Ext.form.Checkbox({
        id: 'chkCwfb_hibilitado',
        name: 'chkCwfb_hibilitado',
        fieldLabel: 'Hibilitado',
        allowBlank: false,
        checked: true
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_web_frase_bienvenida
     */
    var btnGuardarCgg_web_frase_bienvenida = new Ext.Button({
        id: 'btnGuardarCgg_web_frase_bienvenida',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        listeners: {
            click: function () {
                if (!pnlCgg_web_frase_bienvenida.getForm().isValid()) {
                    return;
                }
                try {
                    function CallBackCgg_web_frase_bienvenida(r) {
                        winFrmCgg_web_frase_bienvenida.getEl().unmask();
                        if (r == 'true') {
                            Ext.Msg.show({
                                title: tituloCgg_web_frase_bienvenida,
                                msg: 'La informaci\u00f3n de Web frase bienvenida ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_web_frase_bienvenida.close()
                        } else {
                            Ext.Msg.show({
                                title: tituloCgg_web_frase_bienvenida,
                                msg: 'La informaci\u00f3n de Web frase bienvenida no ha podido ser almacenada. ' + (r.message ? r.message : r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_web_frase_bienvenida.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if (isEdit) param.add('inCwfb_codigo', txtCwfb_codigo.getValue());
                    param.add('inCwfb_contenido', txtCwfb_contenido.getValue());
                    param.add('inCwfb_hibilitado', chkCwfb_hibilitado.getValue());
                    SOAPClient.invoke(urlCgg_web_frase_bienvenida, IN_SENTENCIA_CGG_WEB_FRASE_BIENVENIDA, param, true, CallBackCgg_web_frase_bienvenida);
                } catch (inErr) {
                    winFrmCgg_web_frase_bienvenida.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_web_frase_bienvenida.
     */
    var btnCancelarCgg_web_frase_bienvenida = new Ext.Button({
        id: 'btnCancelarCgg_web_frase_bienvenida',
        text: 'Cancelar',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
                pnlCgg_web_frase_bienvenida.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_web_frase_bienvenida.
     */
    var btnCerrarCgg_web_frase_bienvenida = new Ext.Button({
        id: 'btnCerrarCgg_web_frase_bienvenida',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_web_frase_bienvenida.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_web_frase_bienvenida.
     */
    var pnlCgg_web_frase_bienvenida = new Ext.form.FormPanel({
        frame: true,
        labelWidth: 100,
        items: [txtCwfb_codigo, txtCwfb_contenido, chkCwfb_hibilitado]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_web_frase_bienvenida.
     */
    var winFrmCgg_web_frase_bienvenida = new Ext.Window({
        id: 'winFrmCgg_web_frase_bienvenida',
        title: tituloCgg_web_frase_bienvenida,
        iconCls: 'iconAplicacion',
        width: 400,
        minWidth: 400,
        maximizable: true,
        minimizable: true,
        constrain: true,
        tbar: getPanelTitulo(tituloCgg_web_frase_bienvenida, descCgg_web_frase_bienvenida),
        items: [pnlCgg_web_frase_bienvenida],
        bbar: [btnGuardarCgg_web_frase_bienvenida, btnCancelarCgg_web_frase_bienvenida, '->', btnCerrarCgg_web_frase_bienvenida]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_web_frase_bienvenida.getBottomToolbar());
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_web_frase_bienvenida.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */

    function habilitarCgg_web_frase_bienvenidaCtrls(inEstado) {
        estado = !inEstado;
        txtCwfb_codigo.setDisabled(estado);
        txtCwfb_contenido.setDisabled(estado);
        chkCwfb_hibilitado.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_web_frase_bienvenida.
     */

    function cargarCgg_web_frase_bienvenidaCtrls() {
        if (inRecordCgg_web_frase_bienvenida) {
            txtCwfb_codigo.setValue(inRecordCgg_web_frase_bienvenida.get('CWFB_CODIGO'));
            txtCwfb_contenido.setValue(inRecordCgg_web_frase_bienvenida.get('CWFB_CONTENIDO'));
            chkCwfb_hibilitado.setValue(inRecordCgg_web_frase_bienvenida.get('CWFB_HIBILITADO'));
            isEdit = true;
            habilitarCgg_web_frase_bienvenidaCtrls(true);
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_web_frase_bienvenida.
     * @returns ventana winFrmCgg_web_frase_bienvenida.
     * @base FrmCgg_web_frase_bienvenida.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_web_frase_bienvenida;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_web_frase_bienvenida.
     * @base FrmCgg_web_frase_bienvenida.prototype.loadData
     */
    this.loadData = function () {
        cargarCgg_web_frase_bienvenidaCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_web_frase_bienvenida desde una instancia.
 */
FrmCgg_web_frase_bienvenida.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_web_frase_bienvenida desde una instancia.
 */
FrmCgg_web_frase_bienvenida.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_web_frase_bienvenida,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_web_frase_bienvenida.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_web_frase_bienvenida desde una instancia.
 */
FrmCgg_web_frase_bienvenida.prototype.loadData = function () {
    this.loadData();
}