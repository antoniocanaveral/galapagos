/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_carnet.
 * @param {String} IN_SENTENCIA_CGG_RES_CARNET Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_RES_CARNET Registro de datos de la tabla Cgg_res_carnet.
 * @constructor
 * @base FrmListadoCgg_res_carnet
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_res_carnet(IN_SENTENCIA_CGG_RES_CARNET, IN_RECORD_CGG_RES_CARNET) {
    var inSentenciaCgg_res_carnet = IN_SENTENCIA_CGG_RES_CARNET;
    var inRecordCgg_res_carnet = IN_RECORD_CGG_RES_CARNET;
    var urlCgg_res_carnet = URL_WS + "Cgg_res_carnet";
    var tituloCgg_res_carnet = 'Carnetizaci\u00f3n';
    var descCgg_res_carnet = 'El formulario permite administrar la informaci\u00f3n del carnet de la persona.';
    var tmpCrrsdFechaInicio;
    var tmpCrrsdFechaFin;
    var isEdit = false;
	var tmpPersona = false;
	var tmpPlugin;
	var tmpResidencia;
	var tmpFechaAprobacion;
	var tmpCarnet;
	var tmpPrsFoto;
	var tmpPrsFirma;
	var tmpPrsFir;
	var tmpPrsFirAudit;
	var tmpAdjuntos;
	var tmpDuracion;
	var tmpCuenta;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CARNET
     */
    var txtCrcnt_codigo = new Ext.form.TextField({
        id: 'txtCrcnt_codigo',
        name: 'txtCrcnt_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        value: "KEYGEN",
        hidden: true,
        hideLabel: true,
        allowBlank: false
    });
	var cbxCrcnt_motivo = new Ext.form.ComboBox({
		id:'cbxCrcnt_motivo',
        fieldLabel :'Motivo',
        typeAhead: true,
        triggerAction: 'all',
        lazyRender:true,
        mode: 'local',
        anchor:'98%',
        disabled:true,
        store: dsMotivoCarnet,
		submitValue:false,
		listeners:{
			select:function(inSource, inRecord, inIndex){
				if(inIndex == 0){
					Ext.Msg.show({
						title:tituloCgg_res_carnet,
						msg: 'La persona ya recibio un carnet anteriormente.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});
					cbxCrcnt_motivo.setValue(2);
				}
				if(inIndex > 1 ){	
					dtCrcnt_fecha_emision.setValue(tmpCrrsdFechaInicio);
					dtCrcnt_fecha_caducidad.setValue(tmpCrrsdFechaFin);
				}else if(inIndex == 1){
					if(tmpResidencia.CRRSD_MODALIDAD == 0){
						dtCrcnt_fecha_emision.setValue(tmpCrrsdFechaFin);
						dtCrcnt_fecha_caducidad.setValue(tmpCrrsdFechaFin.add(Date.MONTH, tmpDuracion).add(Date.DAY,-1));
					}else{
						cbxCrcnt_motivo.setValue(2);
						Ext.Msg.show({
							title:tituloCgg_res_carnet,
							msg: 'La residencia temporal no puede renovar el carnet con la misma residencia.',
							buttons: Ext.Msg.OK,
							icon: Ext.MessageBox.INFO
						});
					}
					
				}
			}
		}
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE SEGUIMIENTO DE ESPECIE
     */
    var txtCrcnt_serie = new Ext.form.TextField({
        id: 'txtCrcnt_serie',
        name: 'txtCrcnt_serie',
        fieldLabel: 'Serie',
        anchor: '98%',
        allowBlank: false,
		maxLength:20
    });
    /**
     * Ext.form.DateField FECHA DE EMISION DEL CARNET
     */
    var dtCrcnt_fecha_emision = new Ext.form.DateField({
        id: 'dtCrcnt_fecha_emision',
        name: 'dtCrcnt_fecha_emision',
        fieldLabel: 'Aprobaci\u00f3n',
        allowBlank: false,
		readOnly:true,
		submitValue:false
    });
    /**
     * Ext.form.DateField FECHA DE CADUCIDAD DE LA ESPECIE
     */
    var dtCrcnt_fecha_caducidad = new Ext.form.DateField({
        id: 'dtCrcnt_fecha_caducidad',
        name: 'dtCrcnt_fecha_caducidad',
        fieldLabel: 'Caducidad',
        allowBlank: false,
        format: 'd/m/Y',
        value: new Date(),
		readOnly:true,
		submitValue:false
    });
    /**
     * Ext.form.DateField FECHA DE REALIZACION DE DEPOSITO POR EL VALOR DE LA ESPECIE
     */
    var dtCrcnt_fecha_deposito = new Ext.form.DateField({
        id: 'dtCrcnt_fecha_deposito',
        name: 'dtCrcnt_fecha_deposito',
        fieldLabel: 'Fecha',
        allowBlank: false,
        format: 'd/m/Y',
        value:CURRENT_DATE,
		maxValue:CURRENT_DATE,
		submitValue:false
    });
	
	var fldPeriodo = new Ext.form.FieldSet({
		title:'Periodo',
		labelWidth:62,
		items:[dtCrcnt_fecha_emision,dtCrcnt_fecha_caducidad]
	});
    /**
     * Ext.form.Checkbox SI EL CARNET YA FUE IMPRESO
     */
    var chkCrcnt_carnet_impreso = new Ext.form.Checkbox({
        id: 'chkCrcnt_carnet_impreso',
        name: 'chkCrcnt_carnet_impreso',
        fieldLabel: 'Carnet impreso',
        allowBlank: false,
        checked: false,
		disabled:true
    });
	/**
	* Ext.form.TextField NUMERO O SERIE DEL COMPROBANTE DE DEPOSITO
	*/
	var txtCrcnt_numero_comp = new Ext.form.TextField({
			id:'txtCrcnt_numero_comp',
			name:'txtCrcnt_numero_comp',
			fieldLabel :'Numero',
			anchor:'98%',
			allowBlank :false,
			maxLength:100
	});
    /**
     * Ext.form.NumberField VALOR DEPOSITADO
     */
    var numCrcnt_valor = new Ext.form.NumberField({
        id: 'numCrcnt_valor',
        name: 'numCrcnt_valor',
        fieldLabel: 'Valor',
		anchor:'98%',
        allowBlank: false
    });

	//AC==>
	var btnAdjuntos = new Ext.ux.form.AlfrescoFM({
		id:'compAdjunto',   //(opcional)
		name:'compAdjunto', //(opcional)
		fieldLabel :'Respaldos',
		text: 'Adjuntos',    //(opcional -> Texto del botón)
		tableName: 'Cgg_res_carnet',
		validateRecordID:true,
		recordID : null,
		filter : null
	});
	btnAdjuntos.addListener("updateData",function(t){
		t.recordID = null;
		t.recordID = txtCrcnt_codigo.getValue();
		t.filter = null;
		r=null;
	});
	//<== AC

	/*var filCompDeposito = new Ext.form.FileUploadField({
			id:'filCompDeposito',
			name:'filCompDeposito',
			fieldLabel :'Comp.',
			disabled :false,
			anchor:'98%',
			buttonCfg: {
				text: '',
				iconCls: 'iconAdjunto'
			}
	});*/
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA BANCARIA EN LA QUE SE REALIZO EL DEPOSITO
	*/
	var txtCrcpj_codigo = new Ext.form.TextField({
			id:'txtCrcpj_codigo',
			name:'txtCrcpj_codigo',
			fieldLabel :'Cuenta',
			anchor:'100%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA BANCARIA EN LA QUE SE REALIZO EL DEPOSITO
	*/
	var btnCrcpj_codigoCgg_res_carnet = new Ext.Button({
			id:'btnCrcpj_codigoCgg_res_carnet',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_res_cuenta_personajuridica = new FrmListadoCgg_res_cuenta_personajuridica();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_res_cuenta_personajuridica.getStore(),tmpFLCgg_res_cuenta_personajuridica.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								tmpCuenta = tmpRecord.get('CRCPJ_CODIGO');
								txtCrcpj_codigo.setValue(tmpRecord.get('CRPJR_RAZON_SOCIAL'));
							}
					});
					objBusqueda.show();
			}}
	});
	var fldDeposito = new Ext.form.FieldSet({
		title:'Dep\u00f3sito',
		labelWidth:50,
		items:[{xtype:'panel',layout:'column',items:[
			{columnWidth:.9,layout:'form',items:[txtCrcpj_codigo]},
			{columnWidth:.1,layout:'form',items:[btnCrcpj_codigoCgg_res_carnet]}]},
			txtCrcnt_numero_comp,numCrcnt_valor,dtCrcnt_fecha_deposito,btnAdjuntos]//filCompDeposito]
	});
    /**
     * Ext.form.TextArea INFORMACION ADICIONAL
     */
    var txtCrcnt_observacion = new Ext.form.TextArea({
        id: 'txtCrcnt_observacion',
        name: 'txtCrcnt_observacion',
        fieldLabel: 'Observacion',
        width: '98%'
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_carnet
     */
    var btnGuardarCgg_res_carnet = new Ext.Button({
        id: 'btnGuardarCgg_res_carnet',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        listeners: {
            click: function () {
                if (pnlCgg_res_carnet.getForm().isValid() == false) {
                    return;
                }
                try {
					pnlCgg_res_carnet.getEl().mask('Espere un momento por favor.<br>El tiempo de respuesta depender\u00E1 del tama\u00F1o de sus archivos adjuntos.', 'x-mask-loading');
					pnlCgg_res_carnet.getForm().submit({
							url: URL_WS+"Cgg_res_carnetSRV",
							success: function(fp, o){
								Ext.Msg.show({
										title:tituloCgg_res_carnet,
										msg: 'La informaci\u00f3n del carnet ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});
								winFrmCgg_res_carnet.close();
							},
							failure:function(o, inO){
								Ext.Msg.show({
										title:tituloCgg_res_carnet,
										msg: 'La informaci\u00f3n de carnet no ha podido ser almacenada. '+(inO.result.msg),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
								pnlCgg_res_carnet.getEl().unmask();
							},
							params:{
								request:'insert',
								crcpj_codigo:tmpCuenta,
								crcnt_codigo:txtCrcnt_codigo.getValue(),
								crper_codigo:tmpPersona.get('CRPER_CODIGO'),
								crrsd_codigo:tmpResidencia.CRRSD_CODIGO,
								crcnt_fecha_caducidad:dtCrcnt_fecha_caducidad.getValue().format(TypeDateFormat.ISO8601Long),
								crcnt_fecha_deposito:dtCrcnt_fecha_deposito.getValue().format(TypeDateFormat.ISO8601Long),
								crcnt_fecha_aprobacion:dtCrcnt_fecha_emision.getValue().format(TypeDateFormat.ISO8601Long),
								foto:tmpPrsFoto,
								firma:tmpPrsFirma,
								fir:tmpPrsFir,
								firAudit:tmpPrsFirAudit,
								crcnt_motivo:cbxCrcnt_motivo.getValue()
							}
					});
                } catch (inErr) {
                    winFrmCgg_res_carnet.getEl().unmask();
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_carnet.
     */
    var btnCancelarCgg_res_carnet = new Ext.Button({
        id: 'btnCancelarCgg_res_carnet',
        text: 'Cancelar',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
                pnlCgg_res_carnet.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_carnet.
     */
    var btnCerrarCgg_res_carnet = new Ext.Button({
        id: 'btnCerrarCgg_res_carnet',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_res_carnet.close();
            }
        }
    });
	var pnlCrnDatos = new Ext.Panel({
		layout:'form',
		frame:true,
		region:'west',
		width:260,
		labelWidth:72,
		items:[txtCrcnt_codigo,
				cbxCrcnt_motivo,
				txtCrcnt_serie, 
				fldPeriodo, 
				fldDeposito,
				txtCrcnt_observacion]
	});
	
	var btnCapturarFoto = new Ext.Button({
		id:'btnCapturarFoto',
		text:'Capturar',
		iconCls:'iconCamara',
		handler:function(){
			if(!tmpPlugin)
				tmpPlugin = document.getElementById("bsxCrnBiometric");
			tmpPrsFoto = tmpPlugin.getPhoto()
			if(tmpPrsFoto && tmpPrsFoto.length > 0){
				var tmpImgFoto = document.getElementById("imgFotoPrsnCrn");
				tmpImgFoto.src = 'data:image/jpg;base64,'+tmpPrsFoto;
			}else{
				Ext.Msg.show({
					title: tituloCgg_res_carnet,
                    msg: tmpPlugin.message,
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
			}
		}
	});
	
	var btnCapturarFirma = new Ext.Button({
		id:'btnCapturarFirma',
		text:'Capturar',
		iconCls:'iconFirma',
		handler:function(){
			if(!tmpPlugin)
				tmpPlugin = document.getElementById("bsxCrnBiometric");
			tmpPrsFirma = tmpPlugin.getSignature()
			if(tmpPrsFirma && tmpPrsFirma.length > 0){
				var tmpImgFirma = document.getElementById("imgFirmaPrsnCrn");
				tmpImgFirma.src = 'data:image/jpg;base64,'+tmpPrsFirma;
			}else{
				Ext.Msg.show({
					title: tituloCgg_res_carnet,
                    msg: tmpPlugin.message,
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
			}
		}
	});
	
	var btnCapturarHuella = new Ext.Button({
		id:'btnCapturarHuella',
		text:'Capturar',
		iconCls:'iconHand',
		handler:function(){
			if(!tmpPlugin)
				tmpPlugin = document.getElementById("bsxCrnBiometric");
			var tmpIdPersona;
			if(tmpPersona.get('CRPER_NUM_DOC_IDENTIFIC') && tmpPersona.get('CRPER_NUM_DOC_IDENTIFIC').length > 0)
				tmpIdPersona = tmpPersona.get('CRPER_NUM_DOC_IDENTIFIC');
			else if(tmpPersona.get('CRPER_NUMERO_RESIDENCIA') && tmpPersona.get('CRPER_NUMERO_RESIDENCIA').length > 0)
				tmpIdPersona = tmpPersona.get('CRPER_NUMERO_RESIDENCIA');
			else if(tmpPersona.get('CRPER_CODIGO') && tmpPersona.get('CRPER_CODIGO').length > 0)
				tmpIdPersona = tmpPersona.get('CRPER_CODIGO');
				
			var tmpHuella = tmpPlugin.enroll(tmpIdPersona);
			if(tmpHuella == 0){
				var tmpFirAuditText = tmpPlugin.firAuditText;
				Ext.Ajax.request({
					url: URL_WS+'Biometrico',
					success: function(inResponse){
						var tmpJSON = Ext.util.JSON.decode(inResponse.responseText)
						var tmpImgHuella = document.getElementById("imgHuellaPrsnCrn");
						tmpImgHuella.src = 'data:image/jpg;base64,'+tmpJSON.msg;
						tmpPrsFir = tmpPlugin.firText;
						tmpPrsFirAudit = tmpPlugin.firAuditText;
					},
					failure: function(inResponse){
					},
					params: { 
						op: 'photo',
						data: tmpFirAuditText
					}
				});
			}else{
				Ext.Msg.show({
					title: tituloCgg_res_carnet,
                    msg: tmpPlugin.message,
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
			}
		}
	});
	
	var pnlFotoCrn = new Ext.Panel({
		frame:true,
		title:'Foto',
		iconCls:'iconCamara',
		html:'<img id="imgFotoPrsnCrn" height="300" width="300" src="resources/images/male_avatar.jpeg"/>',
		bbar:[btnCapturarFoto]
	});
	
	var pnlFirmaCrn = new Ext.Panel({
		title:'Firma',
		frame:true,
		iconCls:'iconFirma',
		html:'<img id="imgFirmaPrsnCrn" height="200" width="800" src="resources/images/signature.png"/>',
		bbar:[btnCapturarFirma]
	});
	
	var pnlHuellaCrn = new Ext.Panel({
		title:'Huella dactilar',
		frame:true,
		iconCls:'iconHand',
		html:'<img id="imgHuellaPrsnCrn" height="280" width="600" src="resources/images/fingerprint.jpg"/>',
		bbar:[btnCapturarHuella]
	});
	
	var tbCarnet = new Ext.TabPanel({
		frame:true,
		activeTab:0,
		region:'center',
		html:'<object id="bsxCrnBiometric" type="' + SII_mimeType + '" width="0" height="0"></object>',
		items:[pnlFotoCrn,pnlFirmaCrn,pnlHuellaCrn]
	});
	/**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_carnet.
     */
    var pnlCgg_res_carnet = new Ext.form.FormPanel({
		region:'center',
		layout:'border',
		fileUpload:true,
        items: [pnlCrnDatos,tbCarnet]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_carnet.
     */
    var winFrmCgg_res_carnet = new Ext.Window({
        id: 'winFrmCgg_res_carnet',
        title: tituloCgg_res_carnet,
		iconCls:'iconCarnet',
		layout:'border',
        width: 900,
        minWidth: 400,
		height:560,
        maximizable: true,
        minimizable: true,
        constrain: true,
        tbar: getPanelTitulo(tituloCgg_res_carnet, descCgg_res_carnet),
        items: [pnlCgg_res_carnet],
        bbar: [btnGuardarCgg_res_carnet, btnCancelarCgg_res_carnet, '->', btnCerrarCgg_res_carnet],
		listeners:{
			show:function(){
				if(!tmpPersona)
					return;
					
				for (i = 0; i < tbCarnet.items.length; i++) {
					tbCarnet.setActiveTab(i);
				}
				tbCarnet.setActiveTab(0);
				
				if(tmpAdjuntos){
					tmpPrsFoto = tmpAdjuntos[0].CRPER_FOTO;
					tmpPrsFirma = tmpAdjuntos[0].CRPER_FIRMA;
					tmpPrsFirAudit = tmpAdjuntos[0].CRPER_HUELLA_CADENA;
					tmpPrsFir = tmpAdjuntos[0].CRPER_HUELLA_DACTILAR;
					
					if(tmpAdjuntos[0].CRPER_HUELLA_IMAGEN){
						var tmpImgHuella = document.getElementById("imgHuellaPrsnCrn");
						tmpImgHuella.src = 'data:image/jpg;base64,'+tmpAdjuntos[0].CRPER_HUELLA_IMAGEN;
					}
					if(tmpAdjuntos[0].CRPER_FOTO){
						var tmpImgFoto = document.getElementById("imgFotoPrsnCrn");
						tmpImgFoto.src = 'data:image/jpg;base64,'+tmpPrsFoto;
					}
					if(tmpAdjuntos[0].CRPER_FIRMA){
						var tmpImgFirma = document.getElementById("imgFirmaPrsnCrn");
						tmpImgFirma.src = 'data:image/jpg;base64,'+tmpPrsFirma;
					}
				}
			}
		}
    });
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_carnet.
     * @returns ventana winFrmCgg_res_carnet.
     * @base FrmCgg_res_carnet.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_res_carnet;
    }
	
	function loadCarnet(){
		var tmpDate;
		tmpDuracion = SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF17')).data.CGCNF_VALOR_NUMERICO;
		
		if(tmpCarnet && tmpResidencia){
			dtCrcnt_fecha_emision.setReadOnly(tmpResidencia.CRRSD_MODALIDAD == 1);
			dtCrcnt_fecha_caducidad.setReadOnly(tmpResidencia.CRRSD_MODALIDAD == 1);
			cbxCrcnt_motivo.setValue(2);
			cbxCrcnt_motivo.setDisabled(false);
			tmpCrrsdFechaInicio = Date.parse(tmpResidencia.CRRSD_FECHA_INICIO.substr(0,tmpResidencia.CRRSD_FECHA_INICIO.lastIndexOf('.')));
			if(tmpResidencia.CRRSD_MODALIDAD == 0){
				tmpCrrsdFechaFin = tmpCrrsdFechaInicio.add(Date.MONTH, tmpDuracion);
				tmpCrrsdFechaFin = tmpCrrsdFechaFin.add(Date.DAY, -1);
			}else
				tmpCrrsdFechaFin = Date.parse(tmpResidencia.CRRSD_FECHA_CADUCIDAD.substr(0,tmpResidencia.CRRSD_FECHA_CADUCIDAD.lastIndexOf('.')));
				
			dtCrcnt_fecha_emision.setValue(Date.parse(tmpResidencia.CRRSD_FECHA_INICIO.substr(0,tmpResidencia.CRRSD_FECHA_INICIO.lastIndexOf('.'))));
			dtCrcnt_fecha_caducidad.setValue(tmpCrrsdFechaFin);
		}else if (tmpResidencia){
			dtCrcnt_fecha_emision.setReadOnly(tmpResidencia.CRRSD_MODALIDAD == 1);
			dtCrcnt_fecha_caducidad.setReadOnly(tmpResidencia.CRRSD_MODALIDAD == 1);
			tmpCrrsdFechaInicio = Date.parse(tmpResidencia.CRRSD_FECHA_INICIO.substr(0,tmpResidencia.CRRSD_FECHA_INICIO.lastIndexOf('.')));
			dtCrcnt_fecha_emision.setValue(tmpCrrsdFechaInicio);
			cbxCrcnt_motivo.setValue(0);
			cbxCrcnt_motivo.setDisabled(true);
			if(tmpResidencia.CRRSD_MODALIDAD == 0){
				tmpCrrsdFechaFin = tmpCrrsdFechaInicio.add(Date.MONTH, tmpDuracion);
				tmpCrrsdFechaFin = tmpCrrsdFechaFin.add(Date.DAY, -1);
			}else{
				tmpCrrsdFechaFin = Date.parse(tmpResidencia.CRRSD_FECHA_CADUCIDAD.substr(0,tmpResidencia.CRRSD_FECHA_CADUCIDAD.lastIndexOf('.')));
			}
			dtCrcnt_fecha_caducidad.setValue(tmpCrrsdFechaFin);
		}
	}
	
	/**
     * Funcion miembro que establece la Persona que recibe el carnet.
     * @param inPersona Record de Persona
     */
	this.setPersona = function(inPersona){
		tmpPersona = inPersona;
	}
	/**
     * Funcion miembro que establece la residencia de la Persona.
     * @param inResidencia Record de Residencia
     */
	this.setResidencia = function(inResidencia){
		tmpResidencia = inResidencia;
		loadCarnet();
	}
	/**
     * Funcion miembro que establece el carnet actual de una Persona.
     * @param inTramites
     */
	this.setCarnet = function(inCarnet){
		tmpCarnet = inCarnet;
		loadCarnet();
	}
	
	this.setAdjuntos = function(inAdjuntos){
		tmpAdjuntos = inAdjuntos;
	}
}
/**
* Funcion prototipo. Establece la Persona.
* @param inIdPersona Identificador de Persona.
*/
FrmCgg_res_carnet.prototype.setPersona = function(inPersona){
	this.setPersona(inPersona);
}
/**
* Funcion prototipo. Establece la residencia de la Persona.
* @param inIdPersona Identificador de Persona.
*/
FrmCgg_res_carnet.prototype.setResidencia = function(inResidencia){
	this.setResidencia(inResidencia);
}
/**
* Funcion prototipo. Establece los tramites de carnetizacion de la Persona.
* @param inCarnet Carnet de la Persona.
*/
FrmCgg_res_carnet.prototype.setCarnet = function(inCarnet){
	this.setCarnet(inCarnet);
}
/**
* Funcion prototipo. Establece los datos de biometricos de la Persona.
* @param inAdjuntos Informacion de adjuntos.
*/
FrmCgg_res_carnet.prototype.setAdjuntos = function(inAdjuntos){
	this.setAdjuntos(inAdjuntos);
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_carnet desde una instancia.
 */
FrmCgg_res_carnet.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_carnet desde una instancia.
 */
FrmCgg_res_carnet.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_carnet,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_carnet.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
