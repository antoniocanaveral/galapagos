/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_registro_encuesta.
* @param {String} INSENTENCIA_CGG_DHU_REGISTRO_ENCUESTA Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} INRECORD_CGG_DHU_REGISTRO_ENCUESTA Registro de datos de la tabla Cgg_dhu_registro_encuesta.
* @constructor
* @base FrmListadoCgg_dhu_registro_encuesta
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_dhu_registro_encuesta(INSENTENCIA_CGG_DHU_REGISTRO_ENCUESTA,INRECORD_CGG_DHU_REGISTRO_ENCUESTA){	
	var inSentenciaCgg_dhu_registro_encuesta = INSENTENCIA_CGG_DHU_REGISTRO_ENCUESTA;
	var inRecordCgg_dhu_registro_encuesta=INRECORD_CGG_DHU_REGISTRO_ENCUESTA;
	var urlCgg_dhu_registro_encuesta=URL_WS+"Cgg_dhu_registro_encuesta";
	var tituloCgg_dhu_registro_encuesta='Registro encuesta';
	var descCgg_dhu_registro_encuesta='El formulario permite administrar informaci\u00f3n de registro encuesta';
	var isEdit = false;
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ENCUESTAS
	*/
	var txtCdrge_codigo = new Ext.form.TextField({
			id:'txtCdrge_codigo',
			name:'txtCdrge_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			allowBlank :false,
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			maxLength :20
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	*/
	var txtCdprg_codigo = new Ext.form.TextField({
			id:'txtCdprg_codigo',
			name:'txtCdprg_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			allowBlank :false,
			readOnly:'true',
			maxLength :20
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA PREGUNTA
	*/
	var btnCdprg_codigoCgg_dhu_registro_encuesta = new Ext.Button({
			id:'btnCdprg_codigoCgg_dhu_registro_encuesta',
			text:'Cdprg_codigo',
			iconCls:'iconCdprg_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_dhu_pregunta = new FrmListadoCgg_dhu_pregunta();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_pregunta.getStore(),tmpFLCgg_dhu_pregunta.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCdprg_codigo.setValue(tmpRecord.get('CDPRG_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
	*/
	var txtCdres_codigo = new Ext.form.TextField({
			id:'txtCdres_codigo',
			name:'txtCdres_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			allowBlank :false,
			readOnly:'true',
			maxLength :20
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE LA RESPUESTA
	*/
	var btnCdres_codigoCgg_dhu_registro_encuesta = new Ext.Button({
			id:'btnCdres_codigoCgg_dhu_registro_encuesta',
			text:'Cdres_codigo',
			iconCls:'iconCdres_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_dhu_respuesta = new FrmListadoCgg_dhu_respuesta();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_respuesta.getStore(),tmpFLCgg_dhu_respuesta.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCdres_codigo.setValue(tmpRecord.get('CDRES_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE APLICACION DE LA ENCUESTA
	*/
	var txtCdape_codigo = new Ext.form.TextField({
			id:'txtCdape_codigo',
			name:'txtCdape_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			allowBlank :false,
			readOnly:'true',
			maxLength :20
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE APLICACION DE LA ENCUESTA
	*/
	var btnCdape_codigoCgg_dhu_registro_encuesta = new Ext.Button({
			id:'btnCdape_codigoCgg_dhu_registro_encuesta',
			text:'Cdape_codigo',
			iconCls:'iconCdape_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_dhu_aplicacion_encuesta = new FrmListadoCgg_dhu_aplicacion_encuesta();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_aplicacion_encuesta.getStore(),tmpFLCgg_dhu_aplicacion_encuesta.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCdape_codigo.setValue(tmpRecord.get('CDAPE_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextArea REDACCION DEL TEXTO DE RESPUESTA A PREGUNTAS ABIERTAS
	*/
	var txtCdrge_respuesta_abierta = new Ext.form.TextArea({
			id:'txtCdrge_respuesta_abierta',
			name:'txtCdrge_respuesta_abierta',
			fieldLabel :'Respuesta abierta',
			width:'90%',
			allowBlank :false
	});
	/**
	* Ext.form.DateField FECHA DE REGISTRO DE LA  ENCUESTA
	*/
	var dtCdrge_fecha_registro = new Ext.form.DateField({
			id:'dtCdrge_fecha_registro',
			name:'dtCdrge_fecha_registro',
			fieldLabel :'Fecha registro',
			allowBlank :false,
			value:new Date()
	});
	/**
	* Ext.form.TextArea OBSERVACION DE LA ENCUESTA
	*/
	var txtCdrge_observacion = new Ext.form.TextArea({
			id:'txtCdrge_observacion',
			name:'txtCdrge_observacion',
			fieldLabel :'Observaci\u00f3n',
			width:'90%',
			allowBlank :false
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_registro_encuesta
	*/
	var btnGuardarCgg_dhu_registro_encuesta = new Ext.Button({
			id:'btnGuardarCgg_dhu_registro_encuesta',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (pnlCgg_dhu_registro_encuesta.getForm().isValid()==false){
						return;
					}
					try{
						function CallBackCgg_dhu_registro_encuesta(r){
							winFrmCgg_dhu_registro_encuesta.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_dhu_registro_encuesta,
										msg: 'La informaci\u00f3n de Dhu registro encuesta ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_dhu_registro_encuesta.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_dhu_registro_encuesta,
										msg: 'La informaci\u00f3n de Dhu registro encuesta no ha podido ser almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_dhu_registro_encuesta.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCdrge_codigo',txtCdrge_codigo.getValue());
						param.add('inCdprg_codigo',txtCdprg_codigo.getValue());
						param.add('inCdres_codigo',txtCdres_codigo.getValue());
						param.add('inCdape_codigo',txtCdape_codigo.getValue());
						param.add('inCdrge_respuesta_abierta',txtCdrge_respuesta_abierta.getValue());
						param.add('inCdrge_fecha_registro',dtCdrge_fecha_registro.getValue().format('c'));
						param.add('inCdrge_observacion',txtCdrge_observacion.getValue());
						SOAPClient.invoke(urlCgg_dhu_registro_encuesta,INSENTENCIA_CGG_DHU_REGISTRO_ENCUESTA,param, true, CallBackCgg_dhu_registro_encuesta);
					}catch(inErr){
						winFrmCgg_dhu_registro_encuesta.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_registro_encuesta.
	*/
	var btnCancelarCgg_dhu_registro_encuesta = new Ext.Button({
			id:'btnCancelarCgg_dhu_registro_encuesta',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_dhu_registro_encuesta.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_dhu_registro_encuesta.
	*/
	var btnCerrarCgg_dhu_registro_encuesta = new Ext.Button({
			id:'btnCerrarCgg_dhu_registro_encuesta',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_dhu_registro_encuesta.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_registro_encuesta.
	*/
	var pnlCgg_dhu_registro_encuesta = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCdrge_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCdprg_codigo]},{columnWidth:.4,layout:'form',items:[btnCdprg_codigoCgg_dhu_registro_encuesta]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCdres_codigo]},{columnWidth:.4,layout:'form',items:[btnCdres_codigoCgg_dhu_registro_encuesta]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCdape_codigo]},{columnWidth:.4,layout:'form',items:[btnCdape_codigoCgg_dhu_registro_encuesta]}]},txtCdrge_respuesta_abierta,dtCdrge_fecha_registro,txtCdrge_observacion]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_registro_encuesta.
	*/
	var winFrmCgg_dhu_registro_encuesta = new Ext.Window({
			id:'winFrmCgg_dhu_registro_encuesta',
			title:tituloCgg_dhu_registro_encuesta,
			tbar:getPanelTitulo(tituloCgg_dhu_registro_encuesta,descCgg_dhu_registro_encuesta),
			items:[pnlCgg_dhu_registro_encuesta],
			width:400,
			minWidth:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			bbar:[btnGuardarCgg_dhu_registro_encuesta,btnCancelarCgg_dhu_registro_encuesta,'->',btnCerrarCgg_dhu_registro_encuesta]
	});
	/**
	* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_registro_encuesta.
	* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	*/
	function habilitarCgg_dhu_registro_encuestaCtrls(inEstado){
		estado=!inEstado;
		txtCdrge_codigo.setDisabled(estado);
		txtCdprg_codigo.setDisabled(estado);
		txtCdres_codigo.setDisabled(estado);
		txtCdape_codigo.setDisabled(estado);
		txtCdrge_respuesta_abierta.setDisabled(estado);
		dtCdrge_fecha_registro.setDisabled(estado);
		txtCdrge_observacion.setDisabled(estado);
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_registro_encuesta.
	*/
	function cargarCgg_dhu_registro_encuestaCtrls(){
		if(inRecordCgg_dhu_registro_encuesta){
			txtCdrge_codigo.setValue(inRecordCgg_dhu_registro_encuesta.get('CDRGE_CODIGO'));
			txtCdprg_codigo.setValue(inRecordCgg_dhu_registro_encuesta.get('CDPRG_CODIGO'));
			txtCdres_codigo.setValue(inRecordCgg_dhu_registro_encuesta.get('CDRES_CODIGO'));
			txtCdape_codigo.setValue(inRecordCgg_dhu_registro_encuesta.get('CDAPE_CODIGO'));
			txtCdrge_respuesta_abierta.setValue(inRecordCgg_dhu_registro_encuesta.get('CDRGE_RESPUESTA_ABIERTA'));
			dtCdrge_fecha_registro.setValue(inRecordCgg_dhu_registro_encuesta.get('CDRGE_FECHA_REGISTRO'));
			txtCdrge_observacion.setValue(inRecordCgg_dhu_registro_encuesta.get('CDRGE_OBSERVACION'));
			isEdit = true;
			habilitarCgg_dhu_registro_encuestaCtrls(true);
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_dhu_registro_encuesta.
	* @returns ventana winFrmCgg_dhu_registro_encuesta.
	* @base FrmCgg_dhu_registro_encuesta.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_dhu_registro_encuesta;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_registro_encuesta.
	* @base FrmCgg_dhu_registro_encuesta.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_dhu_registro_encuestaCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_registro_encuesta desde una instancia.
*/
FrmCgg_dhu_registro_encuesta.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_registro_encuesta desde una instancia.
*/
FrmCgg_dhu_registro_encuesta.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_registro_encuesta,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_dhu_registro_encuesta.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_registro_encuesta desde una instancia.
*/
FrmCgg_dhu_registro_encuesta.prototype.loadData = function(){
	this.loadData();
}
