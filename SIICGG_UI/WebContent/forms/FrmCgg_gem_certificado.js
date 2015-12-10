/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_certificado.
 * @param {String} IN_SENTENCIA_CGG_GEM_CERTIFICADO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_GEM_CERTIFICADO Registro de datos de la tabla Cgg_gem_certificado.
 * @constructor
 * @base FrmListadoCgg_gem_certificado
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_gem_certificado(IN_SENTENCIA_CGG_GEM_CERTIFICADO, IN_RECORD_CGG_GEM_CERTIFICADO,IN_CRPER_CODIGO) {
    var inSentenciaCgg_gem_certificado = IN_SENTENCIA_CGG_GEM_CERTIFICADO;
    var inRecordCgg_gem_certificado = IN_RECORD_CGG_GEM_CERTIFICADO;
    var urlCgg_gem_certificado = URL_WS + "Cgg_gem_certificado";
    var tituloCgg_gem_certificado = 'Gem certificado';
    var descCgg_gem_certificado = 'El formulario permite administrar la informaci\u00f3n de la tabla Gem certificado';
    var isEdit = false;
    var inCrper_codigo = IN_CRPER_CODIGO;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCgcer_codigo = new Ext.form.TextField({
        id: 'txtCgcer_codigo',
        name: 'txtCgcer_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        value: "KEYGEN",
        hidden: true,
        hideLabel: true,
        allowBlank: false,
        submitValue:false
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE LA PERSONA
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id: 'txtCrper_codigo',
        name: 'txtCrper_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        readOnly: 'true',
        allowBlank: false,
        hidden: true,
        submitValue:false
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE LA PERSONA
     */
    var btnCrper_codigoCgg_gem_certificado = new Ext.Button({
        id: 'btnCrper_codigoCgg_gem_certificado',
        text: 'Crper_codigo',
        iconCls: 'iconCrper_codigo',
        listeners: {
            click: function () {
                var tmpFLCgg_res_persona = new FrmListadoCgg_res_persona();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(), tmpFLCgg_res_persona.getColumnModel());
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord) txtCrper_codigo.setValue(tmpRecord.get('CRPER_CODIGO'));
                });
                objBusqueda.show();
            }
        },
        hidden:true
    });
    /**
     * Ext.form.TextArea NOMBRE DE LA UNIDAD EDUCATIVA
     */
    var txtCgcer_institucion = new Ext.form.TextField({
        id: 'txtCgcer_institucion',
        name: 'txtCgcer_institucion',
        fieldLabel: 'Institucion',
        anchor: '98%',
        allowBlank: false,
        submitValue:false
    });
	
	/**
     * IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
     */
    var btnCgcer_institucion = new Ext.Button({
        id: 'btnCgcer_institucion',
        text: '',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpFLCgg_institucion_educativa = new FrmListadoCgg_institucion_educativa();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_institucion_educativa.getStore(), tmpFLCgg_institucion_educativa.getColumnModel());
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord) {
						txtCgcer_institucion.setValue(tmpRecord.get('CGIED_NOMBRE'));				
					}
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField NOMBRE DEL CURSO
     */
    var txtCgcer_nombre = new Ext.form.TextField({
        id: 'txtCgcer_nombre',
        name: 'txtCgcer_nombre',
        fieldLabel: 'Nombre',
        anchor: '98%',
        allowBlank: false,
        submitValue:false
    });
    /**
     * Ext.form.TextArea DESCRIPCION DEL CURSO
     */
    var txtCgcer_descripcion = new Ext.form.TextArea({
        id: 'txtCgcer_descripcion',
        name: 'txtCgcer_descripcion',
        fieldLabel: 'Descripcion',
        width: '90%',
        allowBlank: false,
        submitValue:false
    });
    /**
     * Ext.form.NumberField DURACION DEL CURSOS (HORAS)
     */
    var numCgcer_duracion = new Ext.form.NumberField({
        id: 'numCgcer_duracion',
        name: 'numCgcer_duracion',
        fieldLabel: 'Duracion (horas)',
        allowBlank: false,
        disabled: false,
        submitValue:false,
		width: '35%'
    });
    /**
     * Ext.form.DateField FECHA DE  INICIO DEL CURSO
     */
    var dtCgcer_fecha_inicio = new Ext.form.DateField({
        id: 'dtCgcer_fecha_inicio',
        name: 'dtCgcer_fecha_inicio',
        fieldLabel: 'Fecha inicio',
        allowBlank: false,
        format: 'd/m/Y',
        value: new Date(),
        submitValue:false
    });
    /**
     * Ext.form.DateField FECHA DE  FIN DEL CURSO
     */
    var dtCgcer_fecha_fin = new Ext.form.DateField({
        id: 'dtCgcer_fecha_fin',
        name: 'dtCgcer_fecha_fin',
        fieldLabel: 'Fecha fin',
        allowBlank: false,
        format: 'd/m/Y',
        value: new Date(),
        submitValue:false
    });
    /**
     * Ext.form.TextField NO ESPECIFICADO
     */
    var txtCgcer_tipo_adjunto = new Ext.form.TextField({
        id: 'txtCgcer_tipo_adjunto',
        name: 'txtCgcer_tipo_adjunto',
        fieldLabel: 'Tipo adjunto',
        anchor: '98%',
        allowBlank: false,
        submitValue:false,
		hidden:true,
		value:'txt'
    });
    /**
     * Ext.form.TextField NOMBRE DEL DOCUMENTO ADJUNTO
     */
    var txtCgcer_nombre_adjunto = new Ext.form.TextField({
        id: 'txtCgcer_nombre_adjunto',
        name: 'txtCgcer_nombre_adjunto',
        fieldLabel: 'Nombre adjunto',
        anchor: '98%',
        allowBlank: false,
        submitValue:false,
		hidden:true,
		value:'ninguno'
    });
    /**
     * ARCHIVOS DE LOS CERTIFICADOS DIGITALIZADOS
     */
    /*var filCgcer_adjunto = new Ext.form.FileUploadField({
        id: 'filCgcer_adjunto',
        name: 'filCgcer_adjunto',
        fieldLabel: 'Adjunto',
        anchor: '98%',
        disabled: false,
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        }
    });*/
    var cgcer_adjunto = new Ext.form.FileUploadField({
        id: 'cgcer_adjunto',
        name: 'cgcer_adjunto',
        fieldLabel: 'Adjunto',
        anchor: '98%',
        disabled: false,
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        },
        listeners: {
            'fileselected': function(fb, v){
                txtCgcer_nombre_adjunto.setValue(cgcer_adjunto.getValue());
				var b = txtCgcer_nombre_adjunto.getValue().split('.');
				txtCgcer_tipo_adjunto.setValue(b[b.length-1]);
            }
        }
    });
    /**
     * Ext.form.TextArea INFORMACION ADICIONAL
     */
    var txtCgcer_observacion = new Ext.form.TextArea({
        id: 'txtCgcer_observacion',
        name: 'txtCgcer_observacion',
        fieldLabel: 'Observacion',
        width: '90%',
        allowBlank: false,
        submitValue:false
    });
    /**
     * Ext.form.NumberField TIPO DE CERTIFICACION LABORAL O PERSONAL
     0 - CURSO DE CAPACITACION
     1 - SEMINARIO
     2 - CERTIFICACIONES LABORALES O ACADEMICAS
     */
    /*var numCgcer_tipo = new Ext.form.NumberField({
        id: 'numCgcer_tipo',
        name: 'numCgcer_tipo',
        fieldLabel: 'Tipo',
        allowBlank: false,
        disabled: false
    });*/
    var numCgcer_tipo = new Ext.form.ComboBox({
        id:'numCgcer_tipo',
        name:'numCgcer_tipo',
        fieldLabel:'Tipo',
        store: [
                        ['0', 'Curso de Capacitaci\u00F3n'],
                        ['1', 'Seminario'],
                        ['2', 'Cer. Labor. o Acad\u00E9micas']
                   ],
        typeAhead: true,
        forceSelection: true,
        triggerAction: 'all',
        emptyText:'Seleccione el tipo de certificaci\u00F3n...',
        selectOnFocus:true,
        editable:false,
		allowBlank: false,
        submitValue:false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_certificado
     */
    var btnGuardarCgg_gem_certificado = new Ext.Button({
        id: 'btnGuardarCgg_gem_certificado',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        listeners: {
            click: function () {
                if (!pnlCgg_gem_certificado.getForm().isValid()) {
                    return;
                }
				var a = txtCgcer_nombre_adjunto.getValue().split('\\');				
				var b = txtCgcer_nombre_adjunto.getValue().split('.');	
                //Ext.getCmp('pnlCgg_gem_certificado').getForm().submit({
                pnlCgg_gem_certificado.getForm().submit({
                    url: URL_WS + "Cgg_gem_certificadoSRV",
                    waitMsg: 'Enviando formulario...',
                    success: function (fp, o) {
                        Ext.Msg.show({
                            title: tituloCgg_gem_certificado,
                            msg: 'La informaci\u00f3n sobre los certificados ha sido almacenada.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                        winFrmCgg_gem_certificado.close();
                    },
                    failure: function (o) {
                        Ext.Msg.show({
                            title: tituloCgg_gem_certificado,
                            msg: 'La informaci\u00f3n sobre los certificados no ha podido ser almacenada.' + (o.message ? o.message : o),
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    },//.format('Y-m-d H:i:s')
                    params: {request:inSentenciaCgg_gem_certificado,
                        cgcer_codigo: txtCgcer_codigo.getValue(),
                        crper_codigo:inCrper_codigo,
                        cgcer_institucion:txtCgcer_institucion.getValue(),
                        cgcer_nombre: txtCgcer_nombre.getValue(),
                        cgcer_descripcion: txtCgcer_descripcion.getValue(),
                        cgcer_duracion:numCgcer_duracion.getValue(),
                        cgcer_fecha_inicio:dtCgcer_fecha_inicio.getValue().format('Y-m-d H:i:s'),
                        cgcer_fecha_fin:dtCgcer_fecha_fin.getValue().format('Y-m-d H:i:s'),
                        cgcer_tipo_adjunto:b[b.length-1],
                        cgcer_nombre_adjunto:a[a.length-1],
                        cgcer_observacion:txtCgcer_observacion.getValue(),
                        cgcer_tipo:numCgcer_tipo.getValue()
					}
                });
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_certificado.
     */
    var btnCancelarCgg_gem_certificado = new Ext.Button({
        id: 'btnCancelarCgg_gem_certificado',
        text: 'Cancelar',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
                pnlCgg_gem_certificado.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_gem_certificado.
     */
    var btnCerrarCgg_gem_certificado = new Ext.Button({
        id: 'btnCerrarCgg_gem_certificado',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_gem_certificado.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_gem_certificado.
     */
    var pnlCgg_gem_certificado = new Ext.form.FormPanel({
        frame: true,
        labelWidth: 100,
        items: [txtCgcer_codigo,
			numCgcer_tipo,
			{xtype:'panel',layout:'column',items:[{columnWidth:.9,layout:'form',items:[txtCgcer_institucion]},{columnWidth:.1,layout:'form',items:[btnCgcer_institucion]}]},
			txtCgcer_nombre, 
			txtCgcer_descripcion, 
			numCgcer_duracion, 
			dtCgcer_fecha_inicio, 
			dtCgcer_fecha_fin, 
			txtCgcer_tipo_adjunto, 
			txtCgcer_nombre_adjunto, /*filCgcer_adjunto,*/
			cgcer_adjunto, 
			txtCgcer_observacion			
		],
        fileUpload:true
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_certificado.
     */
    var winFrmCgg_gem_certificado = new Ext.Window({
        id: 'winFrmCgg_gem_certificado',
        title: tituloCgg_gem_certificado,
        iconCls: 'iconAplicacion',
        width: 400,
        minWidth: 400,        
		maximizable:false,
		minimizable:false,			
		modal:true,
        constrainHeader: true,
        tbar: getPanelTitulo(tituloCgg_gem_certificado, descCgg_gem_certificado),
        items: [pnlCgg_gem_certificado],
        bbar: [btnGuardarCgg_gem_certificado, btnCancelarCgg_gem_certificado, '->', btnCerrarCgg_gem_certificado]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_gem_certificado.getBottomToolbar());    
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_gem_certificado.
     */
    function cargarCgg_gem_certificadoCtrls() {
        if (inRecordCgg_gem_certificado) {
            txtCgcer_codigo.setValue(inRecordCgg_gem_certificado.get('CGCER_CODIGO'));
			
            txtCrper_codigo.setValue(inRecordCgg_gem_certificado.get('CRPER_CODIGO'));
            txtCgcer_institucion.setValue(inRecordCgg_gem_certificado.get('CGCER_INSTITUCION'));
            txtCgcer_nombre.setValue(inRecordCgg_gem_certificado.get('CGCER_NOMBRE'));
            txtCgcer_descripcion.setValue(inRecordCgg_gem_certificado.get('CGCER_DESCRIPCION'));
            numCgcer_duracion.setValue(inRecordCgg_gem_certificado.get('CGCER_DURACION'));            
            dtCgcer_fecha_inicio.setValue(inRecordCgg_gem_certificado.get('CGCER_FECHA_INICIO')?formatShortDate(inRecordCgg_gem_certificado.get('CGCER_FECHA_INICIO')):null);
            dtCgcer_fecha_fin.setValue(inRecordCgg_gem_certificado.get('CGCER_FECHA_FIN')?formatShortDate(inRecordCgg_gem_certificado.get('CGCER_FECHA_FIN')):null);
            txtCgcer_tipo_adjunto.setValue(inRecordCgg_gem_certificado.get('CGCER_TIPO_ADJUNTO'));
			alert(inRecordCgg_gem_certificado.get('CGCER_TIPO_ADJUNTO'));
            txtCgcer_nombre_adjunto.setValue(inRecordCgg_gem_certificado.get('CGCER_NOMBRE_ADJUNTO'));
			alert(inRecordCgg_gem_certificado.get('CGCER_NOMBRE_ADJUNTO'));
            cgcer_adjunto.setValue(inRecordCgg_gem_certificado.get('CGCER_NOMBRE_ADJUNTO'));
            //numCgcer_adjunto.setValue(inRecordCgg_gem_certificado.get('CGCER_ADJUNTO'));
            txtCgcer_observacion.setValue(inRecordCgg_gem_certificado.get('CGCER_OBSERVACION'));
            numCgcer_tipo.setValue(inRecordCgg_gem_certificado.get('CGCER_TIPO'));
            isEdit = true;            
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_gem_certificado.
     * @returns ventana winFrmCgg_gem_certificado.
     * @base FrmCgg_gem_certificado.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_gem_certificado;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_gem_certificado.
     * @base FrmCgg_gem_certificado.prototype.loadData
     */
    this.loadData = function () {
        cargarCgg_gem_certificadoCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_certificado desde una instancia.
 */
FrmCgg_gem_certificado.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_certificado desde una instancia.
 */
FrmCgg_gem_certificado.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_certificado,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_gem_certificado.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_certificado desde una instancia.
 */
FrmCgg_gem_certificado.prototype.loadData = function () {
    this.loadData();
}