/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_area_funcional.
 * @param {String} IN_SENTENCIA_CGG_GEM_AREA_FUNCIONAL Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_GEM_AREA_FUNCIONAL Registro de datos de la tabla Cgg_gem_area_funcional.
 * @constructor
 * @base FrmListadoCgg_gem_area_funcional
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_gem_area_funcional(IN_SENTENCIA_CGG_GEM_AREA_FUNCIONAL, IN_RECORD_CGG_GEM_AREA_FUNCIONAL) {    
    var inSentenciaCgg_gem_area_funcional = IN_SENTENCIA_CGG_GEM_AREA_FUNCIONAL;
    var inRecordCgg_gem_area_funcional = IN_RECORD_CGG_GEM_AREA_FUNCIONAL;
    var urlCgg_gem_area_funcional = URL_WS + "Cgg_gem_area_funcional";
    var tituloCgg_gem_area_funcional = 'Categor\u00edas';
    var descCgg_gem_area_funcional = 'El formulario permite administrar la informaci\u00f3n de las categor\u00edas.';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
     */
    var txtCgare_codigo = new Ext.form.TextField({
        id: 'txtCgare_codigo',
        name: 'txtCgare_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        value: "KEYGEN",
        hidden: true,
        hideLabel: true,
        allowBlank: false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO DEL AREA FUNCIONAL DE LA EMPREA
     */
    var txtCgare_nombre = new Ext.form.TextField({
        id: 'txtCgare_nombre',
        name: 'txtCgare_nombre',
        fieldLabel: 'Categor\u00eda',
        anchor: '98%',
        allowBlank: false
    });
    /**
     * Ext.form.TextField NO ESPECIFICADO
     */
    var txtCgare_descripcion = new Ext.form.TextArea({
        id: 'txtCgare_descripcion',
        name: 'txtCgare_descripcion',
        fieldLabel: 'Descripci\u00f3n',
        anchor: '98%'        
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_area_funcional
     */
    var btnGuardarCgg_gem_area_funcional = new Ext.Button({
        id: 'btnGuardarCgg_gem_area_funcional',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        listeners: {
            click: function () {
                if (pnlCgg_gem_area_funcional.getForm().isValid() == false) {
                    return;
                }
                try {
                    function CallBackCgg_gem_area_funcional(r) {
                        winFrmCgg_gem_area_funcional.getEl().unmask();
						
                        if (r == 'true') {
                            Ext.Msg.show({
                                title: tituloCgg_gem_area_funcional,
                                msg: 'La informaci\u00f3n de la categor\u00eda ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_gem_area_funcional.close()
                        } else {
                            Ext.Msg.show({
                                title: tituloCgg_gem_area_funcional,
                                msg: 'La informaci\u00f3n de la categor\u00eda no ha podido ser almacenada. ' + r.message.split(': ')[1],
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_gem_area_funcional.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if (isEdit) param.add('inCgare_codigo', txtCgare_codigo.getValue());
                    param.add('inCgare_nombre', txtCgare_nombre.getValue());
                    param.add('inCgare_descripcion', txtCgare_descripcion.getValue());
                    SOAPClient.invoke(urlCgg_gem_area_funcional, IN_SENTENCIA_CGG_GEM_AREA_FUNCIONAL, param, true, CallBackCgg_gem_area_funcional);
                } catch (inErr) {
                    winFrmCgg_gem_area_funcional.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_area_funcional.
     */
    var btnCancelarCgg_gem_area_funcional = new Ext.Button({
        id: 'btnCancelarCgg_gem_area_funcional',
        text: 'Cancelar',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
                pnlCgg_gem_area_funcional.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_gem_area_funcional.
     */
    var btnCerrarCgg_gem_area_funcional = new Ext.Button({
        id: 'btnCerrarCgg_gem_area_funcional',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_gem_area_funcional.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_gem_area_funcional.
     */
    var pnlCgg_gem_area_funcional = new Ext.form.FormPanel({
        frame: true,
        labelWidth: 75,
        items: [txtCgare_codigo, txtCgare_nombre, txtCgare_descripcion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_area_funcional.
     */
    var winFrmCgg_gem_area_funcional = new Ext.Window({
        id: 'winFrmCgg_gem_area_funcional',
        title: tituloCgg_gem_area_funcional,
        width: 400,
        minWidth: 400,
        maximizable: false,
        minimizable: true,
		modal:true,		
        constrainHeader: true,
        tbar: getPanelTitulo(tituloCgg_gem_area_funcional, descCgg_gem_area_funcional),
        items: [pnlCgg_gem_area_funcional],
        bbar: [btnGuardarCgg_gem_area_funcional, btnCancelarCgg_gem_area_funcional, '->', btnCerrarCgg_gem_area_funcional]
    });
    
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_gem_area_funcional.
     */

    function cargarCgg_gem_area_funcionalCtrls() {
        if (inRecordCgg_gem_area_funcional) {
            txtCgare_codigo.setValue(inRecordCgg_gem_area_funcional.get('CGARE_CODIGO'));
            txtCgare_nombre.setValue(inRecordCgg_gem_area_funcional.get('CGARE_NOMBRE'));
            txtCgare_descripcion.setValue(inRecordCgg_gem_area_funcional.get('CGARE_DESCRIPCION'));
            isEdit = true;           
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_gem_area_funcional.
     * @returns ventana winFrmCgg_gem_area_funcional.
     * @base FrmCgg_gem_area_funcional.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_gem_area_funcional;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_gem_area_funcional.
     * @base FrmCgg_gem_area_funcional.prototype.loadData
     */
    this.loadData = function () {
        cargarCgg_gem_area_funcionalCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_area_funcional desde una instancia.
 */
FrmCgg_gem_area_funcional.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_area_funcional desde una instancia.
 */
FrmCgg_gem_area_funcional.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_area_funcional,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_gem_area_funcional.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_area_funcional desde una instancia.
 */
FrmCgg_gem_area_funcional.prototype.loadData = function () {
    this.loadData();
}