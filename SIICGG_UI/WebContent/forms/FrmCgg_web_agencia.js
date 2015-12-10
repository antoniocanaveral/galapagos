/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_web_agencia.
 * @param {String} IN_SENTENCIA_CGG_WEB_AGENCIA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_WEB_AGENCIA Registro de datos de la tabla Cgg_web_agencia.
 * @constructor
 * @base FrmListadoCgg_web_agencia
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_web_agencia(IN_SENTENCIA_CGG_WEB_AGENCIA, IN_RECORD_CGG_WEB_AGENCIA) {
    var inSentenciaCgg_web_agencia = IN_SENTENCIA_CGG_WEB_AGENCIA;
    var inRecordCgg_web_agencia = IN_RECORD_CGG_WEB_AGENCIA;
    var urlCgg_web_agencia = URL_WS + "PublicWS/Cgg_web_agencia";
	var urlCgg_web_modulo = URL_WS + "PublicWS/Cgg_web_modulo";
    var tituloCgg_web_agencia = 'Web agencia';
    var descCgg_web_agencia = 'El formulario permite administrar la informaci\u00f3n de la tabla Web agencia';
    var isEdit = false;
	var tmpCodigo;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCwage_codigo = new Ext.form.TextField({
        id: 'txtCwage_codigo',
        name: 'txtCwage_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        value: "KEYGEN",
        hidden: true,
        hideLabel: true,
        allowBlank: false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCwmod_codigo = new Ext.form.TextField({
        id: 'txtCwmod_codigo',
        name: 'txtCwmod_codigo',
        fieldLabel: 'M\u00F3dulo',
        anchor: '98%',
        readOnly: 'true',
        allowBlank: false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO
     */
    var btnCwmod_codigoCgg_web_agencia = new Ext.Button({
        id: 'btnCwmod_codigoCgg_web_agencia',
        //text: 'Cwmod_codigo',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpFLCgg_web_modulo = new FrmListadoCgg_web_modulo();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_web_modulo.getStore(), tmpFLCgg_web_modulo.getColumnModel());
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord){ 
						tmpCodigo = tmpRecord.get('CWMOD_CODIGO');
						txtCwmod_codigo.setValue(tmpRecord.get('CWMOD_NOMBRE'));
					}
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField NOMBRE DE LA AGENCIA
     */
    var txtCwage_nombre = new Ext.form.TextField({
        id: 'txtCwage_nombre',
        name: 'txtCwage_nombre',
        fieldLabel: 'Nombre',
        anchor: '92%',
        allowBlank: false
    });
    /**
     * Ext.form.TextArea DESCRIPCION ACERCA DE LA AGENCIA
     */
    var txtCwage_descripcion = new Ext.form.TextArea({
        id: 'txtCwage_descripcion',
        name: 'txtCwage_descripcion',
        fieldLabel: 'Descripcion',
        anchor: '92%',
        allowBlank: false
    });
    /**
     * Ext.form.TextField ALMACENA EL NOMBRE DEL ENCARGADO DE LA AGENCIA
     */
    var txtCwage_encargado = new Ext.form.TextField({
        id: 'txtCwage_encargado',
        name: 'txtCwage_encargado',
        fieldLabel: 'Encargado',
        anchor: '92%',
        allowBlank: false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_web_agencia
     */
    var btnGuardarCgg_web_agencia = new Ext.Button({
        id: 'btnGuardarCgg_web_agencia',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        listeners: {
            click: function () {
                if (!pnlCgg_web_agencia.getForm().isValid()) {
                    return;
                }
                try {
                    function CallBackCgg_web_agencia(r) {
                        winFrmCgg_web_agencia.getEl().unmask();
                        if (r == 'true') {
                            Ext.Msg.show({
                                title: tituloCgg_web_agencia,
                                msg: 'La informaci\u00f3n de Web agencia ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_web_agencia.close()
                        } else {
                            Ext.Msg.show({
                                title: tituloCgg_web_agencia,
                                msg: 'La informaci\u00f3n de Web agencia no ha podido ser almacenada. ' + (r.message ? r.message : r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_web_agencia.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if (isEdit) param.add('inCwage_codigo', txtCwage_codigo.getValue());
                    param.add('inCwmod_codigo', tmpCodigo)//txtCwmod_codigo.getValue());
                    param.add('inCwage_nombre', txtCwage_nombre.getValue());
                    param.add('inCwage_descripcion', txtCwage_descripcion.getValue());
                    param.add('inCwage_encargado', txtCwage_encargado.getValue());
                    SOAPClient.invoke(urlCgg_web_agencia, IN_SENTENCIA_CGG_WEB_AGENCIA, param, true, CallBackCgg_web_agencia);
                } catch (inErr) {
                    winFrmCgg_web_agencia.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_web_agencia.
     */
    var btnCancelarCgg_web_agencia = new Ext.Button({
        id: 'btnCancelarCgg_web_agencia',
        text: 'Cancelar',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
                pnlCgg_web_agencia.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_web_agencia.
     */
    var btnCerrarCgg_web_agencia = new Ext.Button({
        id: 'btnCerrarCgg_web_agencia',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_web_agencia.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_web_agencia.
     */
    var pnlCgg_web_agencia = new Ext.form.FormPanel({
        frame: true,
        labelWidth: 100,
        items: [txtCwage_codigo,
        {
            xtype: 'panel',
            layout: 'column',
            items: [{
                columnWidth: .85,
                layout: 'form',
                items: [txtCwmod_codigo]
            },
            {
                columnWidth: .15,
                layout: 'form',
                items: [btnCwmod_codigoCgg_web_agencia]
            }]
        },
        txtCwage_nombre, txtCwage_descripcion, txtCwage_encargado]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_web_agencia.
     */
    var winFrmCgg_web_agencia = new Ext.Window({
        id: 'winFrmCgg_web_agencia',
        title: tituloCgg_web_agencia,
        iconCls: 'iconAplicacion',
        width: 400,
        minWidth: 400,
        maximizable: true,
        minimizable: true,
        constrain: true,
        tbar: getPanelTitulo(tituloCgg_web_agencia, descCgg_web_agencia),
        items: [pnlCgg_web_agencia],
        bbar: [btnGuardarCgg_web_agencia, btnCancelarCgg_web_agencia, '->', btnCerrarCgg_web_agencia]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_web_agencia.getBottomToolbar());
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_web_agencia.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */

    function habilitarCgg_web_agenciaCtrls(inEstado) {
        estado = !inEstado;
        txtCwage_codigo.setDisabled(estado);
        txtCwmod_codigo.setDisabled(estado);
        txtCwage_nombre.setDisabled(estado);
        txtCwage_descripcion.setDisabled(estado);
        txtCwage_encargado.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_web_agencia.
     */

    function cargarCgg_web_agenciaCtrls() {
        if (inRecordCgg_web_agencia) {
            txtCwage_codigo.setValue(inRecordCgg_web_agencia.get('CWAGE_CODIGO'));            
			tmpCodigo = inRecordCgg_web_agencia.get('CWMOD_CODIGO');
			var param = new SOAPClientParameters();			
			param.add('format','JSON');
			param.add('inCwmod_codigo',tmpCodigo);
			var r = SOAPClient.invoke(urlCgg_web_modulo, 'select', param, false, null);
			r= eval('{'+r+'}');
			txtCwmod_codigo.setValue(r[0].CWMOD_NOMBRE);
			
            txtCwage_nombre.setValue(inRecordCgg_web_agencia.get('CWAGE_NOMBRE'));
            txtCwage_descripcion.setValue(inRecordCgg_web_agencia.get('CWAGE_DESCRIPCION'));
            txtCwage_encargado.setValue(inRecordCgg_web_agencia.get('CWAGE_ENCARGADO'));
            isEdit = true;
            habilitarCgg_web_agenciaCtrls(true);
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_web_agencia.
     * @returns ventana winFrmCgg_web_agencia.
     * @base FrmCgg_web_agencia.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_web_agencia;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_web_agencia.
     * @base FrmCgg_web_agencia.prototype.loadData
     */
    this.loadData = function () {
        cargarCgg_web_agenciaCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_web_agencia desde una instancia.
 */
FrmCgg_web_agencia.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_web_agencia desde una instancia.
 */
FrmCgg_web_agencia.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_web_agencia,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_web_agencia.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_web_agencia desde una instancia.
 */
FrmCgg_web_agencia.prototype.loadData = function () {
    this.loadData();
}