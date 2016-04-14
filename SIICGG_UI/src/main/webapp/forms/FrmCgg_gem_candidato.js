/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_candidato.
 * @param {String} IN_ESTADO_CGG_GEM_CANDIDATO Estado (aceptar/rechazar) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_GEM_CANDIDATO Registro de datos de la tabla Cgg_gem_candidato.
 * @constructor
 * @base FrmListadoCgg_gem_candidato
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_gem_candidato(IN_ESTADO_CGG_GEM_CANDIDATO, IN_RECORD_CGG_GEM_CANDIDATO,inRecordVacante) {
    var urlCgg_gem_candidato = URL_WS + "Cgg_gem_candidato";
    var tituloCgg_gem_candidato = (IN_ESTADO_CGG_GEM_CANDIDATO=="aceptar")?tituloCgg_gem_candidato = "Aceptar candidato para entrevista":tituloCgg_gem_candidato = "Rechazar candidato para entrevista";
    var descCgg_gem_candidato = 'El formulario permite administrar la informaci\u00f3n de la aceptaci\u00f3n o rechazo del candidato';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO CANDIDATO
     */
	 
    var txtCgcnd_codigo = new Ext.form.TextField({
        id: 'txtCgcnd_codigo',
        name: 'txtCgcnd_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        value: "KEYGEN",
        hidden: true,
        hideLabel: true,
        allowBlank: false
    });    
    /**
     * Ext.form.DateField FECHA TENTATIVA PARA LA ENTREVISTA
     */
    var dtCgcnd_fecha_entrevista = new Ext.form.DateField({
        id: 'dtCgcnd_fecha_entrevista',
        name: 'dtCgcnd_fecha_entrevista',
        fieldLabel: 'Fecha entrevista',
        allowBlank: false,
        format: 'd/m/Y',
        value: new Date(),
		minValue:new Date()
    });   
    /**
     * Ext.form.TextArea DESCRIPCION QUE REGISTRA EL ADMINISTRADOR DE GESTION DE EMPLEO CUANDO SE RECHAZA O ACEPTA UN APLICANTE
     */
    var txtCgcnd_descripcion = new Ext.form.TextArea({
        id: 'txtCgcnd_descripcion',
        name: 'txtCgcnd_descripcion',
        fieldLabel: 'Descripci\u00f3n',
        width: '90%'        
    });
    /**
     * Ext.form.NumberField SI LA PERSONA FUE CONTRATADA PARA LLENAR LA VACANTE
     0 - NO SELECCIONADO
     1 - SELECCIONADO PARA ENTREVISTA
     2 - RECHAZADO PARA ENTREVISTA
	 3 - NO SELECCIONADO PARA LA VACANTE
	 4 - SELECCIONADO PARA LA VACANTE
     */
    var numCgcnd_seleccionado = new Ext.form.NumberField({
        id: 'numCgcnd_seleccionado',
        name: 'numCgcnd_seleccionado',
        fieldLabel: 'Seleccionado',
        allowBlank: false,
        hidden: true
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_candidato
     */
    var btnGuardarCgg_gem_candidato = new Ext.Button({
        id: 'btnGuardarCgg_gem_candidato',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        listeners: {
            click: function () {
                if (pnlCgg_gem_candidato.getForm().isValid() == false) {
                    return;
                }
                try {
                    function CallBackCgg_gem_candidato(r) {
                        winFrmCgg_gem_candidato.getEl().unmask();
                        if (r == 1  && numCgcnd_seleccionado.getValue() ==2) {
							Ext.Msg.show({
								title: tituloCgg_gem_candidato,
								msg:'La informaci\u00f3n ha sido almacenada.',
								buttons: Ext.Msg.OK,
								icon: Ext.MessageBox.INFO
							});                            
                            winFrmCgg_gem_candidato.close();
                        } else {
							if (r >= 1){
								Ext.Msg.show({
									title: tituloCgg_gem_candidato,
									msg: 'La informaci\u00f3n ha sido almacenada.',
									buttons: Ext.Msg.OK,
									icon: Ext.MessageBox.INFO
								});
								winFrmCgg_gem_candidato.close();
							}else
								Ext.Msg.show({
									title: tituloCgg_gem_candidato,
									msg: 'La informaci\u00f3n no ha podido ser almacenada. ' + r,
									buttons: Ext.Msg.OK,
									icon: Ext.MessageBox.ERROR
								});								
                        }
						
                    }
                    winFrmCgg_gem_candidato.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    param.add('inCgcnd_codigo', txtCgcnd_codigo.getValue());
					param.add('inCgvcn_codigo', inRecordVacante.get("CGVCN_CODIGO"));
                    param.add('inCgcnd_fecha_entrevista', dtCgcnd_fecha_entrevista.getValue().format(TypeDateFormat.Custom));
                    param.add('inCgcnd_descripcion', txtCgcnd_descripcion.getValue());
					param.add('inCgcnd_observacion', '');
					param.add('inCgcnd_detalle', '');
                    param.add('inCgcnd_seleccionado', numCgcnd_seleccionado.getValue());
                    SOAPClient.invoke(urlCgg_gem_candidato, "update", param, true, CallBackCgg_gem_candidato);
                } catch (inErr) {
                    winFrmCgg_gem_candidato.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_candidato.
     */
    var btnCancelarCgg_gem_candidato = new Ext.Button({
        id: 'btnCancelarCgg_gem_candidato',
        text: 'Cancelar',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
                pnlCgg_gem_candidato.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_gem_candidato.
     */
    var btnCerrarCgg_gem_candidato = new Ext.Button({
        id: 'btnCerrarCgg_gem_candidato',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_gem_candidato.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_gem_candidato.
     */
    var pnlCgg_gem_candidato = new Ext.form.FormPanel({
        frame: true,
        labelWidth: 100,
		height:100,
        items: [txtCgcnd_codigo,dtCgcnd_fecha_entrevista,txtCgcnd_descripcion, numCgcnd_seleccionado]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_candidato.
     */
    var winFrmCgg_gem_candidato = new Ext.Window({
        id: 'winFrmCgg_gem_candidato',
        title: tituloCgg_gem_candidato,
        width: 400,
        minWidth: 400,
        maximizable: true,
        minimizable: true,
        constrainHeader: true,
		layout:'fit',
		modal:true,
        tbar: getPanelTitulo(tituloCgg_gem_candidato, descCgg_gem_candidato),
        items: [pnlCgg_gem_candidato],
        bbar: [btnGuardarCgg_gem_candidato, btnCancelarCgg_gem_candidato, '->', btnCerrarCgg_gem_candidato]
    });	
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_gem_candidato.
     */

    function cargarCgg_gem_candidatoCtrls() {
        if (IN_RECORD_CGG_GEM_CANDIDATO) {
            txtCgcnd_codigo.setValue(IN_RECORD_CGG_GEM_CANDIDATO.get('CGCND_CODIGO'));            
            txtCgcnd_descripcion.setValue(IN_RECORD_CGG_GEM_CANDIDATO.get('CGCND_DESCRIPCION'));
			var estado_CGG_GEM_CANDIDATO = "0";
			if (IN_ESTADO_CGG_GEM_CANDIDATO == "aceptar"){				
				estado_CGG_GEM_CANDIDATO = "1";
			}else if (IN_ESTADO_CGG_GEM_CANDIDATO == "rechazar"){
				dtCgcnd_fecha_entrevista.hide();
				estado_CGG_GEM_CANDIDATO = "2";
			}
            numCgcnd_seleccionado.setValue(estado_CGG_GEM_CANDIDATO);
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_gem_candidato.
     * @returns ventana winFrmCgg_gem_candidato.
     * @base FrmCgg_gem_candidato.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_gem_candidato;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_gem_candidato.
     * @base FrmCgg_gem_candidato.prototype.loadData
     */
    this.loadData = function () {
        cargarCgg_gem_candidatoCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_candidato desde una instancia.
 */
FrmCgg_gem_candidato.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_candidato desde una instancia.
 */
FrmCgg_gem_candidato.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_candidato,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_gem_candidato.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_candidato desde una instancia.
 */
FrmCgg_gem_candidato.prototype.loadData = function () {
    this.loadData();
}