/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_sec_perfil_rol.
 * @param {String} INSENTENCIA_CGG_SEC_PERFIL_ROL Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_SEC_PERFIL_ROL Registro de datos de la tabla Cgg_sec_perfil_rol.
 * @constructor
 * @base FrmListadoCgg_sec_perfil_rol
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_sec_usuario_rol(INSENTENCIA_CGG_SEC_PERFIL_ROL, INRECORD_CGG_SEC_PERFIL_ROL) {
    var inSentenciaCgg_sec_perfil_rol = INSENTENCIA_CGG_SEC_PERFIL_ROL;
    var inRecordCgg_sec_perfil_rol = INRECORD_CGG_SEC_PERFIL_ROL;
    var urlCgg_sec_usuario_rol = URL_WS + "Cgg_sec_usuario_rol";
    var tituloCgg_sec_perfil_rol = 'Rol';
    var descCgg_sec_perfil_rol = 'El formulario permite administrar el rol que sera asignado al perfil.';
    var isEdit = false;
	var tmpRol;
	var tmpUsuario;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO PERFIL - ROL
     */
    var txtCsper_codigo = new Ext.form.TextField({
        id: 'txtCsper_codigo',
        name: 'txtCsper_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        allowBlank: false,
        value: "KEYGEN",
        hidden: true,
        hideLabel: true
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO ROL
     */
    var txtCsrol_codigo = new Ext.form.TextField({
        id: 'txtCsrol_codigo',
        name: 'txtCsrol_codigo',
        fieldLabel: 'Rol',
        anchor: '98%',
        allowBlank: false,
        readOnly: 'true',
        maxLength: 20
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO ROL
     */
    var btnCsrol_codigoCgg_sec_perfil_rol = new Ext.Button({
        id: 'btnCsrol_codigoCgg_sec_perfil_rol',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpFLCgg_sec_rol = new FrmListadoCgg_sec_rol();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_sec_rol.getStore(), tmpFLCgg_sec_rol.getColumnModel());
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord){
						tmpRol = tmpRecord.get('CSROL_CODIGO');
						txtCsrol_codigo.setValue(tmpRecord.get('CSROL_NOMBRE'));
					}
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_sec_usuario_rol
     */
    var btnGuardarCgg_sec_perfil_rol = new Ext.Button({
        id: 'btnGuardarCgg_sec_perfil_rol',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        listeners: {
            click: function () {
                if (pnlCgg_sec_perfil_rol.getForm().isValid() == false) {
                    return;
                }
                try {
                    function CallBackCgg_sec_perfil_rol(r) {
                        winFrmCgg_sec_usuario_rol.getEl().unmask();
                        if (r == 'true') {
                            Ext.Msg.show({
                                title: tituloCgg_sec_perfil_rol,
                                msg: 'La informaci\u00f3n del Rol ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_sec_usuario_rol.close()
                        } else {
                            Ext.Msg.show({
                                title: tituloCgg_sec_perfil_rol,
                                msg: 'La informaci\u00f3n del Rol no ha podido ser almacenada. '+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_sec_usuario_rol.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if (isEdit) param.add('inCsper_codigo', txtCsper_codigo.getValue());
                    param.add('inCsrol_codigo', tmpRol);
                    param.add('inCusu_codigo', tmpUsuario);
                    SOAPClient.invoke(urlCgg_sec_usuario_rol, INSENTENCIA_CGG_SEC_PERFIL_ROL, param, true, CallBackCgg_sec_perfil_rol);
                } catch (inErr) {
                    winFrmCgg_sec_usuario_rol.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_sec_usuario_rol.
     */
    var btnCancelarCgg_sec_perfil_rol = new Ext.Button({
        id: 'btnCancelarCgg_sec_perfil_rol',
        text: 'Cancelar',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
                pnlCgg_sec_perfil_rol.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_sec_usuario_rol.
     */
    var btnCerrarCgg_sec_perfil_rol = new Ext.Button({
        id: 'btnCerrarCgg_sec_perfil_rol',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_sec_usuario_rol.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_sec_usuario_rol.
     */
    var pnlCgg_sec_perfil_rol = new Ext.form.FormPanel({
        frame: true,
        labelWidth: 50,
        items: [txtCsper_codigo,
        {
            xtype: 'panel',
            layout: 'column',
            items: [{
                columnWidth: .9,
                layout: 'form',
                items: [txtCsrol_codigo]},
            {
                columnWidth: .1,
                layout: 'form',
                items: [btnCsrol_codigoCgg_sec_perfil_rol]}]}
        ]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_sec_perfil_rol.
     */
    var winFrmCgg_sec_usuario_rol = new Ext.Window({
        id: 'winFrmCgg_sec_usuario_rol',
        title: tituloCgg_sec_perfil_rol,
        tbar: getPanelTitulo(tituloCgg_sec_perfil_rol, descCgg_sec_perfil_rol),
        items: [pnlCgg_sec_perfil_rol],
        width: 400,
        minWidth: 400,
        maximizable: true,
        minimizable: true,
        constrain: true,
        bbar: [btnGuardarCgg_sec_perfil_rol, btnCancelarCgg_sec_perfil_rol, '->', btnCerrarCgg_sec_perfil_rol]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_sec_usuario_rol.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */

    function habilitarCgg_sec_perfil_rolCtrls(inEstado) {
        estado = !inEstado;
        txtCsper_codigo.setDisabled(estado);
        txtCsrol_codigo.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_sec_usuario_rol.
     */

    function cargarCgg_sec_perfil_rolCtrls() {
        if (inRecordCgg_sec_perfil_rol) {
            txtCsper_codigo.setValue(inRecordCgg_sec_perfil_rol.get('CSPER_CODIGO'));
            txtCsrol_codigo.setValue(inRecordCgg_sec_perfil_rol.get('ROL'));
			tmpRol = inRecordCgg_sec_perfil_rol.get('CSROL_CODIGO')
            tmpUsuario = inRecordCgg_sec_perfil_rol.get('CUSU_CODIGO');
            isEdit = true;
            habilitarCgg_sec_perfil_rolCtrls(true);
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_sec_usuario_rol.
     * @returns ventana winFrmCgg_sec_usuario_rol.
     * @base FrmCgg_sec_usuario_rol.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_sec_usuario_rol;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_sec_usuario_rol.
     * @base FrmCgg_sec_usuario_rol.prototype.loadData
     */
    this.loadData = function () {
        cargarCgg_sec_perfil_rolCtrls();
    }
	/**
	* Funcion miembro que establece el codigo del Perfil.
	*/
    this.setUsuario = function(inUsuario){
	    tmpUsuario = inUsuario;
	}
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_sec_usuario_rol desde una instancia.
 */
FrmCgg_sec_usuario_rol.prototype.setUsuario = function (inUsuario) {
	this.setUsuario(inUsuario);
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_sec_usuario_rol desde una instancia.
 */
FrmCgg_sec_usuario_rol.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_sec_usuario_rol desde una instancia.
 */
FrmCgg_sec_usuario_rol.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_sec_usuario_rol,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_sec_usuario_rol.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_sec_usuario_rol desde una instancia.
 */
FrmCgg_sec_usuario_rol.prototype.loadData = function () {
    this.loadData();
}