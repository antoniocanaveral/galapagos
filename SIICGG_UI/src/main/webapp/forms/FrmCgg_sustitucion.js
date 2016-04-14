/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_sustitucion.
 * @param {String} INSENTENCIA_CGG_SUSTITUCION Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_SUSTITUCION Registro de datos de la tabla Cgg_sustitucion.
 * @constructor
 * @base FrmListadoCgg_sustitucion
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_sustitucion(INSENTENCIA_CGG_SUSTITUCION, INRECORD_CGG_SUSTITUCION) {
    var inSentenciaCgg_sustitucion = INSENTENCIA_CGG_SUSTITUCION;
    var inRecordCgg_sustitucion = INRECORD_CGG_SUSTITUCION;
    var urlCgg_sustitucion = URL_WS + "Cgg_sustitucion";
    var tituloCgg_sustitucion = 'Sustituci\u00f3n de usuario';
    var descCgg_sustitucion = 'El formulario permite administrar informaci\u00f3n de la sustituci\u00f3n de usuario.';
    var isEdit = false;
    var tmpFK = new Array(2);
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCsust_codigo = new Ext.form.TextField({
        id: 'txtCsust_codigo',
        name: 'txtCsust_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        value: "KEYGEN",
        hidden: true,
        hideLabel: true,
        allowBlank: false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE ENCARGA LA RESPONSABILIDAD
     */
    var txtCusu_codigo = new Ext.form.TextField({
        id: 'txtCusu_codigo',
        name: 'txtCusu_codigo',
        fieldLabel: 'Sustituido',
        anchor: '98%',
        readOnly: 'true',
        allowBlank: false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE ENCARGA LA RESPONSABILIDAD
     */
    var btnCusu_codigoCgg_sustitucion = new Ext.Button({
        id: 'btnCusu_codigoCgg_sustitucion',
        text: '',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpFLCgg_usuario = new FrmListadoCgg_usuario();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_usuario.getStore(), tmpFLCgg_usuario.getColumnModel());                
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord) {
                        tmpFK['SUSTITUIDO'] = tmpRecord.get('CUSU_CODIGO');
                        txtCusu_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+' '+tmpRecord.get('CRPER_APELLIDO_PATERNO'));
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE RECIBE EL ENCARGO
     */
    var txtCgg_cusu_codigo = new Ext.form.TextField({
        id: 'txtCgg_cusu_codigo',
        name: 'txtCgg_cusu_codigo',
        fieldLabel: 'Usuario',
        anchor: '98%',
        readOnly: 'true',
        allowBlank: false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO QUE RECIBE EL ENCARGO
     */
    var btnCgg_cusu_codigoCgg_sustitucion = new Ext.Button({
        id: 'btnCgg_cusu_codigoCgg_sustitucion',
        text: '',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpFLCgg_usuario = new FrmListadoCgg_usuario();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_usuario.getStore(), tmpFLCgg_usuario.getColumnModel());
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord){
                        tmpFK['SUSTITUTO'] = tmpRecord.get('CUSU_CODIGO');
                        txtCgg_cusu_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+' '+tmpRecord.get('CRPER_APELLIDO_PATERNO'));
                    }
                });
                objBusqueda.show();
            }
        }
    });
    var cbxModalidad = new Ext.form.ComboBox({
        fieldLabel :'Modalidad',
        typeAhead: true,
        triggerAction: 'all',
        lazyRender:true,
        editable:false,
        mode: 'local',
        anchor:'60%',
        emptyText:'Seleccione la modalidad.',
        store: dsModalidad,
        value:0,
        listeners:{
            select:function(inComboBox, inRecord, inIndex){
                dtCsust_fecha_fin.setDisabled((inIndex == 1));
            }
        }
    });    
	
    /**
	* Ext.form.DateField INICIO DEL PERIODO DE SUSTITUCION
	*/
    var dtCsust_fecha_inicio = new Ext.form.DateField({
        id:'dtCsust_fecha_inicio',
        name:'dtCsust_fecha_inicio',
        fieldLabel :'Fecha inicio',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    /**
	* Ext.form.DateField FIN DEL PERIODO DE SUSTITUCION
	*/
    var dtCsust_fecha_fin = new Ext.form.DateField({
        id:'dtCsust_fecha_fin',
        name:'dtCsust_fecha_fin',
        fieldLabel :'Fecha fin',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    /**
     * Ext.form.Checkbox ALMACENA INFORMACION SOBRE LA VIGENCIA DEL ENCARGO
     0 - INACTIVO
     1 - ACTIVO
     */
    var chkCsust_estado_encargo = new Ext.form.Checkbox({
        id: 'chkCsust_estado_encargo',
        name: 'chkCsust_estado_encargo',
        fieldLabel: 'Vigente',
        allowBlank:false,
        checked:true
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_sustitucion
     */
    var btnGuardarCgg_sustitucion = new Ext.Button({
        id: 'btnGuardarCgg_sustitucion',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        listeners: {
            click: function () {
                if (pnlCgg_sustitucion.getForm().isValid() == false) {
                    return;
                }
                try {
                    function CallBackCgg_sustitucion(r) {
                        winFrmCgg_sustitucion.getEl().unmask();
                        if (r == 'true') {
                            Ext.Msg.show({
                                title: tituloCgg_sustitucion,
                                msg: 'La informaci\u00f3n de Sustituci\u00f3n ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_sustitucion.close()
                        } else {
                            Ext.Msg.show({
                                title: tituloCgg_sustitucion,
                                msg: 'La informaci\u00f3n de Sustituci\u00f3n no ha podido ser almacenada. '+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_sustitucion.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if (isEdit) param.add('inCsust_codigo', txtCsust_codigo.getValue());
                    param.add('inCusu_codigo', tmpFK['SUSTITUIDO']);
                    param.add('inCgg_cusu_codigo', tmpFK['SUSTITUTO']);
                    param.add('inCsust_modalidad',cbxModalidad.getValue());
                    param.add('inCsust_fecha_inicio',dtCsust_fecha_inicio.getValue().format(TypeDateFormat.Custom));
                    param.add('inCsust_fecha_fin',dtCsust_fecha_fin.getValue().format(TypeDateFormat.Custom));
                    param.add('inCsust_estado_encargo', chkCsust_estado_encargo.getValue());
                    SOAPClient.invoke(urlCgg_sustitucion, INSENTENCIA_CGG_SUSTITUCION, param, true, CallBackCgg_sustitucion);
                } catch (inErr) {
                    winFrmCgg_sustitucion.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_sustitucion.
     */
    var btnCancelarCgg_sustitucion = new Ext.Button({
        id: 'btnCancelarCgg_sustitucion',
        text: 'Cancelar',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
                pnlCgg_sustitucion.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_sustitucion.
     */
    var btnCerrarCgg_sustitucion = new Ext.Button({
        id: 'btnCerrarCgg_sustitucion',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_sustitucion.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_sustitucion.
     */
    var pnlCgg_sustitucion = new Ext.form.FormPanel({
        frame: true,
        labelWidth: 70,
        items: [txtCsust_codigo,
        {
            xtype: 'panel',
            layout: 'column',
            items: [{
                columnWidth: .92,
                layout: 'form',
                items: [txtCusu_codigo]
            },

            {
                columnWidth: .08,
                layout: 'form',
                items: [btnCusu_codigoCgg_sustitucion]
            }]
        },

        {
            xtype: 'panel',
            layout: 'column',
            items: [{
                columnWidth: .92,
                layout: 'form',
                items: [txtCgg_cusu_codigo]
            },

            {
                columnWidth: .08,
                layout: 'form',
                items: [btnCgg_cusu_codigoCgg_sustitucion]
            }]
        },
        cbxModalidad,
        dtCsust_fecha_inicio,
        dtCsust_fecha_fin,
        chkCsust_estado_encargo
        ]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_sustitucion.
     */
    var winFrmCgg_sustitucion = new Ext.Window({
        id: 'winFrmCgg_sustitucion',
        title: tituloCgg_sustitucion,
        tbar: getPanelTitulo(tituloCgg_sustitucion, descCgg_sustitucion),
        items: [pnlCgg_sustitucion],
        width: 400,
        minWidth: 400,
        modal:true,
        resizable:false,
        constrain: true,
        bbar: [btnGuardarCgg_sustitucion, btnCancelarCgg_sustitucion, '->', btnCerrarCgg_sustitucion]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_sustitucion.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */

    function habilitarCgg_sustitucionCtrls(inEstado) {
        estado = !inEstado;
        txtCsust_codigo.setDisabled(estado);
        txtCusu_codigo.setDisabled(estado);
        txtCgg_cusu_codigo.setDisabled(estado);
        cbxModalidad.setDisabled(estado);
        dtCsust_fecha_inicio.setDisabled(estado);
        dtCsust_fecha_fin.setDisabled(estado);
        chkCsust_estado_encargo.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_sustitucion.
     */

    function cargarCgg_sustitucionCtrls() {
        if (inRecordCgg_sustitucion) {
            txtCsust_codigo.setValue(inRecordCgg_sustitucion.get('CSUST_CODIGO'));
            txtCusu_codigo.setValue(inRecordCgg_sustitucion.get('SUSTITUIDO'));
            txtCgg_cusu_codigo.setValue(inRecordCgg_sustitucion.get('SUSTITUTO'));
            cbxModalidad.setValue(inRecordCgg_sustitucion.get('CSUST_MODALIDAD'));
            dtCsust_fecha_inicio.setValue(truncDate(inRecordCgg_sustitucion.get('CSUST_FECHA_INICIO')));
            dtCsust_fecha_fin.setValue(truncDate(inRecordCgg_sustitucion.get('CSUST_FECHA_FIN')));
            chkCsust_estado_encargo.setValue(inRecordCgg_sustitucion.get('CSUST_ESTADO_ENCARGO'));
            isEdit = true;
            habilitarCgg_sustitucionCtrls(true);
            dtCsust_fecha_fin.setDisabled(cbxModalidad.getValue());
            tmpFK['SUSTITUIDO'] = inRecordCgg_sustitucion.get('CUSU_CODIGO');
            tmpFK['SUSTITUTO'] = inRecordCgg_sustitucion.get('CGG_CUSU_CODIGO');
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_sustitucion.
     * @returns ventana winFrmCgg_sustitucion.
     * @base FrmCgg_sustitucion.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_sustitucion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_sustitucion.
     * @base FrmCgg_sustitucion.prototype.loadData
     */
    this.loadData = function () {
        cargarCgg_sustitucionCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_sustitucion desde una instancia.
 */
FrmCgg_sustitucion.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_sustitucion desde una instancia.
 */
FrmCgg_sustitucion.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_sustitucion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_sustitucion.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_sustitucion desde una instancia.
 */
FrmCgg_sustitucion.prototype.loadData = function () {
    this.loadData();
}