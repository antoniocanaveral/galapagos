/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_cargo.
 * @param {String} IN_SENTENCIA_CGG_GEM_CARGO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_GEM_CARGO Registro de datos de la tabla Cgg_gem_cargo.
 * @constructor
 * @base FrmListadoCgg_gem_cargo
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_gem_cargo(IN_SENTENCIA_CGG_GEM_CARGO, IN_RECORD_CGG_GEM_CARGO) {    
    var inSentenciaCgg_gem_cargo = IN_SENTENCIA_CGG_GEM_CARGO;
    var inRecordCgg_gem_cargo = IN_RECORD_CGG_GEM_CARGO;
    var urlCgg_gem_cargo = URL_WS + "Cgg_gem_cargo";
    var tituloCgg_gem_cargo = 'Cargos';
    var descCgg_gem_cargo = 'El formulario permite administrar la informaci\u00f3n los cargos.';
    var isEdit = false;
    var tmpArea = null;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
     */
    var txtCgcrg_codigo = new Ext.form.TextField({
        id: 'txtCgcrg_codigo',
        name: 'txtCgcrg_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        value: "KEYGEN",
        hidden: true,
        hideLabel: true,
        allowBlank: false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
     */
    var txtCgare_codigo = new Ext.form.TextField({
        id: 'txtCgare_codigo',
        name: 'txtCgare_codigo',
        fieldLabel: 'Categor\u00eda',
        anchor: '98%',
        readOnly: 'true',
		allowBlank: false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE AREA FUNCIONAL
     */
    var btnCgare_codigoCgg_gem_cargo = new Ext.Button({
        id: 'btnCgare_codigoCgg_gem_cargo',
        text: '',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpFLCgg_gem_area_funcional = new Cgg_gem_area_funcional_data();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_gem_area_funcional.store, tmpFLCgg_gem_area_funcional.columnModel);
                objBusqueda.closeHandler(function() {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord){
                        txtCgare_codigo.setValue(tmpRecord.get('CGARE_NOMBRE'));
                        tmpArea = tmpRecord.get('CGARE_CODIGO');
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO DEL CARGO
     */
    var txtCgcrg_nombre = new Ext.form.TextField({
        id: 'txtCgcrg_nombre',
        name: 'txtCgcrg_nombre',
        fieldLabel: 'Cargo',
        anchor: '98%',
        allowBlank: false
    });
    /**
     * Ext.form.TextField DESCRIPCION BREVE DEL CARGO
     */
    var txtCgcrg_descripcion = new Ext.form.TextArea({
        id: 'txtCgcrg_descripcion',
        name: 'txtCgcrg_descripcion',
        fieldLabel: 'Descripci\u00f3n',
        anchor: '98%'        
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_cargo
     */
    var btnGuardarCgg_gem_cargo = new Ext.Button({
        id: 'btnGuardarCgg_gem_cargo',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        listeners: {
            click: function () {
                if (pnlCgg_gem_cargo.getForm().isValid() == false) {
                    return;
                }
                try {
                    function CallBackCgg_gem_cargo(r) {
						//alert(r);
                        winFrmCgg_gem_cargo.getEl().unmask();
                        if (r == 'true') {
                            Ext.Msg.show({
                                title: tituloCgg_gem_cargo,
                                msg: 'La informaci\u00f3n de cargo ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_gem_cargo.close()
                        } else {
                            Ext.Msg.show({
                                title: tituloCgg_gem_cargo,
                                msg: 'La informaci\u00f3n de cargo no ha podido ser almacenada. ' + r.message.split(': ')[1],
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_gem_cargo.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if (isEdit) param.add('inCgcrg_codigo', txtCgcrg_codigo.getValue());
                    param.add('inCgare_codigo', tmpArea);
                    param.add('inCgcrg_nombre', txtCgcrg_nombre.getValue());
                    param.add('inCgcrg_descripcion', txtCgcrg_descripcion.getValue());
                    SOAPClient.invoke(urlCgg_gem_cargo, IN_SENTENCIA_CGG_GEM_CARGO, param, true, CallBackCgg_gem_cargo);
                } catch (inErr) {
                    winFrmCgg_gem_cargo.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_cargo.
     */
    var btnCancelarCgg_gem_cargo = new Ext.Button({
        id: 'btnCancelarCgg_gem_cargo',
        text: 'Cancelar',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
                pnlCgg_gem_cargo.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_gem_cargo.
     */
    var btnCerrarCgg_gem_cargo = new Ext.Button({
        id: 'btnCerrarCgg_gem_cargo',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_gem_cargo.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_gem_cargo.
     */
    var pnlCgg_gem_cargo = new Ext.form.FormPanel({
        frame: true,
        labelWidth: 75,
        items: [txtCgcrg_codigo,
        {
            xtype: 'panel',
            layout: 'column',
            items: [{
                columnWidth: .6,
                layout: 'form',
                items: [txtCgare_codigo]
            },
            {
                columnWidth: .4,
                layout: 'form',
                items: [btnCgare_codigoCgg_gem_cargo]
            }]
        },
        txtCgcrg_nombre, txtCgcrg_descripcion]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_cargo.
     */
    var winFrmCgg_gem_cargo = new Ext.Window({
        id: 'winFrmCgg_gem_cargo',
        title: tituloCgg_gem_cargo,
        width: 400,
        minWidth: 400,                
        constrainHeader: true,
        modal:true,
        tbar: getPanelTitulo(tituloCgg_gem_cargo, descCgg_gem_cargo),
        items: [pnlCgg_gem_cargo],
        bbar: [btnGuardarCgg_gem_cargo, btnCancelarCgg_gem_cargo, '->', btnCerrarCgg_gem_cargo]
    });
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_gem_cargo.
     */

    function cargarCgg_gem_cargoCtrls() {
        if (inRecordCgg_gem_cargo) {
            txtCgcrg_codigo.setValue(inRecordCgg_gem_cargo.get('CGCRG_CODIGO'));
            tmpArea=inRecordCgg_gem_cargo.get('CGARE_CODIGO');
			txtCgare_codigo.setValue(inRecordCgg_gem_cargo.get('CGARE_NOMBRE'));
            txtCgcrg_nombre.setValue(inRecordCgg_gem_cargo.get('CGCRG_NOMBRE'));
            txtCgcrg_descripcion.setValue(inRecordCgg_gem_cargo.get('CGCRG_DESCRIPCION'));
            isEdit = true;
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_gem_cargo.
     * @returns ventana winFrmCgg_gem_cargo.
     * @base FrmCgg_gem_cargo.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_gem_cargo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_gem_cargo.
     * @base FrmCgg_gem_cargo.prototype.loadData
     */
    this.loadData = function () {
        cargarCgg_gem_cargoCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_cargo desde una instancia.
 */
FrmCgg_gem_cargo.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_cargo desde una instancia.
 */
FrmCgg_gem_cargo.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_cargo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_gem_cargo.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_cargo desde una instancia.
 */
FrmCgg_gem_cargo.prototype.loadData = function () {
    this.loadData();
}