/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_adjunto.
* @param {String} IN_SENTENCIA_CGG_RES_ADJUNTO Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_RES_ADJUNTO Registro de datos de la tabla Cgg_res_adjunto.
* @constructor
* @base FrmListadoCgg_res_adjunto
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_res_adjuntoOrg(IN_SENTENCIA_CGG_RES_ADJUNTO,IN_RECORD_CGG_RES_ADJUNTO){
	var inSentenciaCgg_res_adjunto = IN_SENTENCIA_CGG_RES_ADJUNTO;
	var inRecordCgg_res_adjunto=IN_RECORD_CGG_RES_ADJUNTO;
	var urlCgg_res_adjunto=URL_WS+"Cgg_res_adjunto";
	var tituloCgg_res_adjunto='Adjunto';
	var descCgg_res_adjunto='El formulario permite administrar la informaci\u00f3n de un adjunto';
	var isEdit = false;
	var tmpDependencias = new Array();
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ADJUNTO
	*/
	var txtCradj_codigo = new Ext.form.TextField({
			id:'txtCradj_codigo',
			name:'txtCradj_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
	});
	/**
	* Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO PERSONA
	*/
	var txtCrper_codigo = new Ext.form.TextField({
			id:'txtCrper_codigo',
			name:'txtCrper_codigo',
			fieldLabel :'Persona',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO PERSONA
	*/
	var btnCrper_codigoCgg_res_adjunto = new Ext.Button({
			id:'btnCrper_codigoCgg_res_adjunto',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_res_persona = new Persona();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								tmpDependencias['PERSONA'] = tmpRecord.get('CRPER_CODIGO');
								txtCrper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+' '+tmpRecord.get('CRPER_APELLIDO_PATERNO')+' '+tmpRecord.get('CRPER_APELLIDO_MATERNO'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE INFORME
	*/
	var txtCrinf_codigo = new Ext.form.TextField({
			id:'txtCrinf_codigo',
			name:'txtCrinf_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE INFORME
	*/
	var btnCrinf_codigoCgg_res_adjunto = new Ext.Button({
			id:'btnCrinf_codigoCgg_res_adjunto',
			text:'Crinf_codigo',
			iconCls:'iconCrinf_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_res_informe_pareja = new FrmListadoCgg_res_informe_pareja();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_res_informe_pareja.getStore(),tmpFLCgg_res_informe_pareja.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCrinf_codigo.setValue(tmpRecord.get('CRINF_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO NOTIFICACION
	*/
	var txtCrnot_codigo = new Ext.form.TextField({
			id:'txtCrnot_codigo',
			name:'txtCrnot_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO NOTIFICACION
	*/
	var btnCrnot_codigoCgg_res_adjunto = new Ext.Button({
			id:'btnCrnot_codigoCgg_res_adjunto',
			text:'Crnot_codigo',
			iconCls:'iconCrnot_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_res_notificacion = new FrmListadoCgg_res_notificacion();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_res_notificacion.getStore(),tmpFLCgg_res_notificacion.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCrnot_codigo.setValue(tmpRecord.get('CRNOT_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	var txtCrres_codigo = new Ext.form.TextField({
			id:'txtCrres_codigo',
			name:'txtCrres_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
	*/
	var btnCrres_codigoCgg_res_adjunto = new Ext.Button({
			id:'btnCrres_codigoCgg_res_adjunto',
			text:'Crres_codigo',
			iconCls:'iconCrres_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_res_resolucion = new FrmListadoCgg_res_resolucion();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_res_resolucion.getStore(),tmpFLCgg_res_resolucion.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCrres_codigo.setValue(tmpRecord.get('CRRES_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO GARANTIA
	*/
	var txtCrdpt_codigo = new Ext.form.TextField({
			id:'txtCrdpt_codigo',
			name:'txtCrdpt_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO GARANTIA
	*/
	var btnCrdpt_codigoCgg_res_adjunto = new Ext.Button({
			id:'btnCrdpt_codigoCgg_res_adjunto',
			text:'Crdpt_codigo',
			iconCls:'iconCrdpt_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_res_deposito_garantia = new FrmListadoCgg_res_deposito_garantia();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_res_deposito_garantia.getStore(),tmpFLCgg_res_deposito_garantia.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCrdpt_codigo.setValue(tmpRecord.get('CRDPT_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	*/
	var txtCrseg_codigo = new Ext.form.TextField({
			id:'txtCrseg_codigo',
			name:'txtCrseg_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
	*/
	var btnCrseg_codigoCgg_res_adjunto = new Ext.Button({
			id:'btnCrseg_codigoCgg_res_adjunto',
			text:'Crseg_codigo',
			iconCls:'iconCrseg_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_res_seguimiento = new FrmListadoCgg_res_seguimiento();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_res_seguimiento.getStore(),tmpFLCgg_res_seguimiento.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCrseg_codigo.setValue(tmpRecord.get('CRSEG_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	*/
	var txtCrtpt_codigo = new Ext.form.TextField({
			id:'txtCrtpt_codigo',
			name:'txtCrtpt_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	*/
	var btnCrtpt_codigoCgg_res_adjunto = new Ext.Button({
			id:'btnCrtpt_codigoCgg_res_adjunto',
			text:'Crtpt_codigo',
			iconCls:'iconCrtpt_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_res_tipo_tramite = new FrmListadoCgg_res_tipo_tramite();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_res_tipo_tramite.getStore(),tmpFLCgg_res_tipo_tramite.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCrtpt_codigo.setValue(tmpRecord.get('CRTPT_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	*/
	var txtCrssc_codigo = new Ext.form.TextField({
			id:'txtCrssc_codigo',
			name:'txtCrssc_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGIsTRO DE SESION
	*/
	var btnCrssc_codigoCgg_res_adjunto = new Ext.Button({
			id:'btnCrssc_codigoCgg_res_adjunto',
			text:'Crssc_codigo',
			iconCls:'iconCrssc_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_res_sesion_comite = new FrmListadoCgg_res_sesion_comite();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_res_sesion_comite.getStore(),tmpFLCgg_res_sesion_comite.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCrssc_codigo.setValue(tmpRecord.get('CRSSC_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE REQUISITO DE TRAMITE
	*/
	var txtCrrqt_codigo = new Ext.form.TextField({
			id:'txtCrrqt_codigo',
			name:'txtCrrqt_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* Ext.form.TextField IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	var txtCvveh_codigo = new Ext.form.TextField({
			id:'txtCvveh_codigo',
			name:'txtCvveh_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICADOR UNICO DE REGISTRO DE VEHICULO
	*/
	var btnCvveh_codigoCgg_res_adjunto = new Ext.Button({
			id:'btnCvveh_codigoCgg_res_adjunto',
			text:'Cvveh_codigo',
			iconCls:'iconCvveh_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_veh_vehiculo = new FrmListadoCgg_veh_vehiculo();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_veh_vehiculo.getStore(),tmpFLCgg_veh_vehiculo.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCvveh_codigo.setValue(tmpRecord.get('CVVEH_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField OBSERVACION DEL ARCHIVO ADJUNTO
	*/
	var txtCradj_observacion = new Ext.form.TextArea({
			id:'txtCradj_observacion',
			name:'txtCradj_observacion',
			fieldLabel :'Observacion',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* ARCHIVO DIGITAL ANEXO 
	*/
	var filCradj_archivo_adjunto = new Ext.form.FileUploadField({
			id:'filCradj_archivo_adjunto',
			name:'filCradj_archivo_adjunto',
			fieldLabel :'Archivo adjunto',
			anchor:'98%',
			disabled :false,
			buttonCfg: {
				text: '',
				iconCls: 'iconAdjunto'
			}
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_res_adjuntoOrg
	*/
	var btnGuardarCgg_res_adjunto = new Ext.Button({
			id:'btnGuardarCgg_res_adjunto',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (!pnlCgg_res_adjunto.getForm().isValid()){
						return;
					}
					pnlCgg_res_adjunto.getEl().mask('Guardando...', 'x-mask-loading');
					pnlCgg_res_adjunto.getForm().submit({
							url: URL_WS+"Cgg_res_adjuntoSRV",
							success: function(fp, o){
								Ext.Msg.show({
										title:tituloCgg_res_adjunto,
										msg: 'La informaci\u00f3n del adjunto ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});
								pnlCgg_res_adjunto.getEl().unmask();
								winFrmCgg_res_adjuntoOrg.close();
							},
							failure:function(o){
								Ext.Msg.show({
										title:tituloCgg_res_adjunto,
										msg: 'La informaci\u00f3n del adjunto no ha podido ser almacenada.'+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							},
							params:{
								inCradj_codigo:txtCradj_codigo.getValue(),
								crper_codigo:tmpDependencias['PERSONA']
							}
					});
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_adjuntoOrg.
	*/
	var btnCancelarCgg_res_adjunto = new Ext.Button({
			id:'btnCancelarCgg_res_adjunto',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_res_adjunto.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_res_adjuntoOrg.
	*/
	var btnCerrarCgg_res_adjunto = new Ext.Button({
			id:'btnCerrarCgg_res_adjunto',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_res_adjuntoOrg.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_adjuntoOrg.
	*/
	var pnlCgg_res_adjunto = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			fileUpload:true,
			items:[{xtype:'panel',layout:'column',items:[
					{columnWidth:.92,layout:'form',items:[txtCrper_codigo]},
					{columnWidth:.08,layout:'form',items:[btnCrper_codigoCgg_res_adjunto]}]},
				txtCradj_observacion,
				filCradj_archivo_adjunto
				]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_adjunto.
	*/
	var winFrmCgg_res_adjuntoOrg = new Ext.Window({
			id:'winFrmCgg_res_adjuntoOrg',
			title:tituloCgg_res_adjunto,
			iconCls:'iconAplicacion',
			width:400,
			minWidth:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			tbar:getPanelTitulo(tituloCgg_res_adjunto,descCgg_res_adjunto),
			items:[pnlCgg_res_adjunto],
			bbar:[btnGuardarCgg_res_adjunto,btnCancelarCgg_res_adjunto,'->',btnCerrarCgg_res_adjunto]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_res_adjuntoOrg.getBottomToolbar());
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_adjuntoOrg.
	*/
	function cargarCgg_res_adjuntoCtrls(){
		if(inRecordCgg_res_adjunto){
			tmpDependencias['PERSONA'] = inRecordCgg_res_adjunto.get('CRPER_CODIGO');
			txtCradj_codigo.setValue(inRecordCgg_res_adjunto.get('CRADJ_CODIGO'));
			txtCrper_codigo.setValue(inRecordCgg_res_adjunto.get('PERSONA'));
			txtCrinf_codigo.setValue(inRecordCgg_res_adjunto.get('CRINF_CODIGO'));
			txtCrnot_codigo.setValue(inRecordCgg_res_adjunto.get('CRNOT_CODIGO'));
			txtCrres_codigo.setValue(inRecordCgg_res_adjunto.get('CRRES_CODIGO'));
			txtCrdpt_codigo.setValue(inRecordCgg_res_adjunto.get('CRDPT_CODIGO'));
			txtCrseg_codigo.setValue(inRecordCgg_res_adjunto.get('CRSEG_CODIGO'));
			txtCrtpt_codigo.setValue(inRecordCgg_res_adjunto.get('CRTPT_CODIGO'));
			txtCrssc_codigo.setValue(inRecordCgg_res_adjunto.get('CRSSC_CODIGO'));
			txtCrrqt_codigo.setValue(inRecordCgg_res_adjunto.get('CRRQT_CODIGO'));
			txtCvveh_codigo.setValue(inRecordCgg_res_adjunto.get('CVVEH_CODIGO'));
			txtCradj_observacion.setValue(inRecordCgg_res_adjunto.get('CRADJ_OBSERVACION'));
			numCradj_archivo_adjunto.setValue(inRecordCgg_res_adjunto.get('CRADJ_ARCHIVO_ADJUNTO'));
			isEdit = true;
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_res_adjuntoOrg.
	* @returns ventana winFrmCgg_res_adjuntoOrg.
	* @base FrmCgg_res_adjuntoOrg.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_res_adjuntoOrg;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_res_adjuntoOrg.
	* @base FrmCgg_res_adjuntoOrg.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_res_adjuntoCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_adjuntoOrg desde una instancia.
*/
FrmCgg_res_adjuntoOrg.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_adjuntoOrg desde una instancia.
*/
FrmCgg_res_adjuntoOrg.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_adjuntoOrg,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_res_adjuntoOrg.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_adjuntoOrg desde una instancia.
*/
FrmCgg_res_adjuntoOrg.prototype.loadData = function(){
	this.loadData();
}