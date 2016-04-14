/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_sec_rol.
 * @param {String} INSENTENCIA_CGG_SEC_ROL Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_SEC_ROL Registro de datos de la tabla Cgg_sec_rol.
 * @constructor
 * @base FrmListadoCgg_sec_rol
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_sec_rol(INSENTENCIA_CGG_SEC_ROL, INRECORD_CGG_SEC_ROL) {
    var inSentenciaCgg_sec_rol = INSENTENCIA_CGG_SEC_ROL;
    var inRecordCgg_sec_rol = INRECORD_CGG_SEC_ROL;
    var urlCgg_sec_rol = URL_WS + "Cgg_sec_rol";
    var tituloCgg_sec_rol = 'Rol';
    var descCgg_sec_rol = 'El formulario permite administrar la informaci\u00f3n de un Rol del sistema.';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO ROL
     */
    var txtCsrol_codigo = new Ext.form.TextField({
        id: 'txtCsrol_codigo',
        name: 'txtCsrol_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        allowBlank: false,
        value: "KEYGEN",
        hidden: true,
        hideLabel: true,
        maxLength: 20
    });
    /**
     * Ext.form.TextField NOMBRE DEL ROL
     */
    var txtCsrol_nombre = new Ext.form.TextField({
        id: 'txtCsrol_nombre',
        name: 'txtCsrol_nombre',
        fieldLabel: 'Nombre',
        anchor: '98%',
        allowBlank: false,
        maxLength: 100
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_sec_rol
     */
    var btnGuardarCgg_sec_rol = new Ext.Button({
        id: 'btnGuardarCgg_sec_rol',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        listeners: {
            click: function () {
                if (pnlCgg_sec_rol.getForm().isValid() == false) {
                    return;
                }
                try {
                    function CallBackCgg_sec_rol(r) {
                        winFrmCgg_sec_rol.getEl().unmask();
                        if (r == 'true') {
                            Ext.Msg.show({
                                title: tituloCgg_sec_rol,
                                msg: 'La informaci\u00f3n del Rol ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_sec_rol.close()
                        } else {
                            Ext.Msg.show({
                                title: tituloCgg_sec_rol,
                                msg: 'La informaci\u00f3n del Rol no ha podido ser almacenada. '+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_sec_rol.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if (isEdit) param.add('inCsrol_codigo', txtCsrol_codigo.getValue());
                    param.add('inCsrol_nombre', txtCsrol_nombre.getValue());
                    SOAPClient.invoke(urlCgg_sec_rol, INSENTENCIA_CGG_SEC_ROL, param, true, CallBackCgg_sec_rol);
                } catch (inErr) {
                    winFrmCgg_sec_rol.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_sec_rol.
     */
    var btnCancelarCgg_sec_rol = new Ext.Button({
        id: 'btnCancelarCgg_sec_rol',
        text: 'Cancelar',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
                pnlCgg_sec_rol.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_sec_rol.
     */
    var btnCerrarCgg_sec_rol = new Ext.Button({
        id: 'btnCerrarCgg_sec_rol',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_sec_rol.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_sec_rol.
     */
    var pnlCgg_sec_rol = new Ext.form.FormPanel({
        frame: true,
        labelWidth: 100,
        items: [txtCsrol_codigo, txtCsrol_nombre]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_sec_rol.
     */
    var winFrmCgg_sec_rol = new Ext.Window({
        id: 'winFrmCgg_sec_rol',
        title: tituloCgg_sec_rol,
        tbar: getPanelTitulo(tituloCgg_sec_rol, descCgg_sec_rol),
        items: [pnlCgg_sec_rol],
        width: 400,
        minWidth: 400,
        maximizable: true,
        minimizable: true,
        constrain: true,
        bbar: [btnGuardarCgg_sec_rol, btnCancelarCgg_sec_rol, '->', btnCerrarCgg_sec_rol]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_sec_rol.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */

    function habilitarCgg_sec_rolCtrls(inEstado) {
        estado = !inEstado;
        txtCsrol_codigo.setDisabled(estado);
        txtCsrol_nombre.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_sec_rol.
     */

    function cargarCgg_sec_rolCtrls() {
        if (inRecordCgg_sec_rol) {
            txtCsrol_codigo.setValue(inRecordCgg_sec_rol.get('CSROL_CODIGO'));
            txtCsrol_nombre.setValue(inRecordCgg_sec_rol.get('CSROL_NOMBRE'));
            isEdit = true;
            habilitarCgg_sec_rolCtrls(true);
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_sec_rol.
     * @returns ventana winFrmCgg_sec_rol.
     * @base FrmCgg_sec_rol.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_sec_rol;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_sec_rol.
     * @base FrmCgg_sec_rol.prototype.loadData
     */
    this.loadData = function () {
        cargarCgg_sec_rolCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_sec_rol desde una instancia.
 */
FrmCgg_sec_rol.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_sec_rol desde una instancia.
 */
FrmCgg_sec_rol.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_sec_rol,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_sec_rol.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_sec_rol desde una instancia.
 */
FrmCgg_sec_rol.prototype.loadData = function () {
    this.loadData();
}