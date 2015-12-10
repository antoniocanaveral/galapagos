/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_web_pagina.
* @param {String} IN_SENTENCIA_CGG_WEB_PAGINA Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_WEB_PAGINA Registro de datos de la tabla Cgg_web_pagina.
* @constructor
* @base FrmListadoCgg_web_pagina
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_web_pagina(IN_SENTENCIA_CGG_WEB_PAGINA,IN_RECORD_CGG_WEB_PAGINA){
	var inSentenciaCgg_web_pagina = IN_SENTENCIA_CGG_WEB_PAGINA;
	var inRecordCgg_web_pagina=IN_RECORD_CGG_WEB_PAGINA;
	var urlCgg_web_pagina=URL_WS+"PublicWS/Cgg_web_pagina";
	var tituloCgg_web_pagina='Sitio web';
	var descCgg_web_pagina='El formulario permite administrar la informaci\u00f3n sobre el sitio web';
	var isEdit = false;
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGSITRO
	*/
	var txtCwpag_codigo = new Ext.form.TextField({
			id:'txtCwpag_codigo',
			name:'txtCwpag_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
	});
	/**
	* Ext.form.TextField NOMBRE COMPLETO DE LA PAGINA WEB
	*/
	var txtCwpag_nombre = new Ext.form.TextField({
			id:'txtCwpag_nombre',
			name:'txtCwpag_nombre',
			fieldLabel :'Nombre',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* Ext.form.TextField CONTENIDO DE LA FRASE O MENSAJE
	*/
	var txtCwpag_titulo = new Ext.form.TextField({
			id:'txtCwpag_titulo',
			name:'txtCwpag_titulo',
			fieldLabel :'Titulo',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* Ext.form.TextArea CONTENIDO DE LA FRASE O MENSAJE
	*/
	var txtCwpag_descripcion = new Ext.form.HtmlEditor({
			id:'txtCwpag_descripcion',
			name:'txtCwpag_descripcion',
			fieldLabel :'Contenido',
			anchor:'100%',			
			allowBlank :false
	});
	/**
	* Ext.form.TextArea DATOS DE CONFIGURACION DE MENSAJES QUE APARECEN EN LA PAGIN
	*/
	var txtCwpag_configuracion = new Ext.form.TextArea({
			id:'txtCwpag_configuracion',
			name:'txtCwpag_configuracion',
			fieldLabel :'Configuracion',
			width:'90%',
			hidden:true
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_web_pagina
	*/
	var btnGuardarCgg_web_pagina = new Ext.Button({
			id:'btnGuardarCgg_web_pagina',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (!pnlCgg_web_pagina.getForm().isValid()){
						return;
					}
					try{
						function CallBackCgg_web_pagina(r){
							winFrmCgg_web_pagina.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_web_pagina,
										msg: 'La informaci\u00f3n de Web pagina ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_web_pagina.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_web_pagina,
										msg: 'La informaci\u00f3n de Web pagina no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_web_pagina.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCwpag_codigo',txtCwpag_codigo.getValue());
						param.add('inCwpag_nombre',txtCwpag_nombre.getValue());
						param.add('inCwpag_titulo',txtCwpag_titulo.getValue());
						param.add('inCwpag_descripcion',txtCwpag_descripcion.getValue());
						param.add('inCwpag_configuracion',txtCwpag_configuracion.getValue());
						SOAPClient.invoke(urlCgg_web_pagina,IN_SENTENCIA_CGG_WEB_PAGINA,param, true, CallBackCgg_web_pagina);
					}catch(inErr){
						winFrmCgg_web_pagina.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_web_pagina.
	*/
	var btnCancelarCgg_web_pagina = new Ext.Button({
			id:'btnCancelarCgg_web_pagina',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_web_pagina.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_web_pagina.
	*/
	var btnCerrarCgg_web_pagina = new Ext.Button({
			id:'btnCerrarCgg_web_pagina',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_web_pagina.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_web_pagina.
	*/
	var pnlCgg_web_pagina = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			region : 'center',			
			items:[txtCwpag_codigo,txtCwpag_nombre,txtCwpag_titulo,txtCwpag_configuracion,txtCwpag_descripcion]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_web_pagina.
	*/
	var winFrmCgg_web_pagina = new Ext.Window({
			id:'winFrmCgg_web_pagina',
			title:tituloCgg_web_pagina,
			iconCls:'iconAplicacion',
			width:600,
			minWidth:400,
			height:400,
			maximizable:true,
			minimizable:false,
			modal : true,
			layout:'border',
			constrain:true,
			tbar:getPanelTitulo(tituloCgg_web_pagina,descCgg_web_pagina),
			items:[pnlCgg_web_pagina],
			bbar:[btnGuardarCgg_web_pagina,btnCancelarCgg_web_pagina,'->',btnCerrarCgg_web_pagina]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_web_pagina.getBottomToolbar());
	/**
	* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_web_pagina.
	* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	*/
	function habilitarCgg_web_paginaCtrls(inEstado){
		estado=!inEstado;
		txtCwpag_codigo.setDisabled(estado);
		txtCwpag_nombre.setDisabled(estado);
		txtCwpag_titulo.setDisabled(estado);
		txtCwpag_descripcion.setDisabled(estado);
		txtCwpag_configuracion.setDisabled(estado);
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_web_pagina.
	*/
	function cargarCgg_web_paginaCtrls(){
		if(inRecordCgg_web_pagina){
			txtCwpag_codigo.setValue(inRecordCgg_web_pagina.get('CWPAG_CODIGO'));
			txtCwpag_nombre.setValue(inRecordCgg_web_pagina.get('CWPAG_NOMBRE'));
			txtCwpag_titulo.setValue(inRecordCgg_web_pagina.get('CWPAG_TITULO'));
			txtCwpag_descripcion.setValue(inRecordCgg_web_pagina.get('CWPAG_DESCRIPCION'));
			txtCwpag_configuracion.setValue(inRecordCgg_web_pagina.get('CWPAG_CONFIGURACION'));
			isEdit = true;
			habilitarCgg_web_paginaCtrls(true);
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_web_pagina.
	* @returns ventana winFrmCgg_web_pagina.
	* @base FrmCgg_web_pagina.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_web_pagina;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_web_pagina.
	* @base FrmCgg_web_pagina.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_web_paginaCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_web_pagina desde una instancia.
*/
FrmCgg_web_pagina.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_web_pagina desde una instancia.
*/
FrmCgg_web_pagina.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_web_pagina,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_web_pagina.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_web_pagina desde una instancia.
*/
FrmCgg_web_pagina.prototype.loadData = function(){
	this.loadData();
}
