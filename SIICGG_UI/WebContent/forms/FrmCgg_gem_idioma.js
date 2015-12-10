/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_idioma.
* @param {String} INSENTENCIA_CGG_GEM_IDIOMA Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} INRECORD_CGG_GEM_IDIOMA Registro de datos de la tabla Cgg_gem_idioma.
* @constructor
* @base FrmListadoCgg_gem_idioma
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_gem_idioma(INSENTENCIA_CGG_GEM_IDIOMA,INRECORD_CGG_GEM_IDIOMA){
	var inSentenciaCgg_gem_idioma = INSENTENCIA_CGG_GEM_IDIOMA;
	var inRecordCgg_gem_idioma=INRECORD_CGG_GEM_IDIOMA;
	var urlCgg_gem_idioma=URL_WS+"Cgg_gem_idioma";
	var tituloCgg_gem_idioma='Gem idioma';
	var descCgg_gem_idioma='El formulario permite administrar informaci\u00f3n de la tabla Gem idioma';
	var isEdit = false;
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCgidm_codigo = new Ext.form.TextField({
			id:'txtCgidm_codigo',
			name:'txtCgidm_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			allowBlank :false,
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			maxLength :20
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO DEL IDIOMA
	*/
	var txtCgidm_nombre = new Ext.form.TextField({
			id:'txtCgidm_nombre',
			name:'txtCgidm_nombre',
			fieldLabel :'Nombre',
			anchor:'98%',
			allowBlank :false,
			maxLength :20
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_idioma
	*/
	var btnGuardarCgg_gem_idioma = new Ext.Button({
			id:'btnGuardarCgg_gem_idioma',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (pnlCgg_gem_idioma.getForm().isValid()==false){
						return;
					}
					try{
						function CallBackCgg_gem_idioma(r){
							winFrmCgg_gem_idioma.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_gem_idioma,
										msg: 'La informaci\u00f3n de Gem idioma ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_gem_idioma.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_gem_idioma,
										msg: 'La informaci\u00f3n de Gem idioma no ha podido ser almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_gem_idioma.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCgidm_codigo',txtCgidm_codigo.getValue());
						param.add('inCgidm_nombre',txtCgidm_nombre.getValue());
						SOAPClient.invoke(urlCgg_gem_idioma,INSENTENCIA_CGG_GEM_IDIOMA,param, true, CallBackCgg_gem_idioma);
					}catch(inErr){
						winFrmCgg_gem_idioma.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_idioma.
	*/
	var btnCancelarCgg_gem_idioma = new Ext.Button({
			id:'btnCancelarCgg_gem_idioma',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_gem_idioma.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_gem_idioma.
	*/
	var btnCerrarCgg_gem_idioma = new Ext.Button({
			id:'btnCerrarCgg_gem_idioma',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_gem_idioma.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_gem_idioma.
	*/
	var pnlCgg_gem_idioma = new Ext.form.FormPanel({
			frame:true,
			labelWidth :75,
			items:[txtCgidm_codigo,txtCgidm_nombre]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_idioma.
	*/
	var winFrmCgg_gem_idioma = new Ext.Window({
			id:'winFrmCgg_gem_idioma',
			title:tituloCgg_gem_idioma,
			tbar:getPanelTitulo(tituloCgg_gem_idioma,descCgg_gem_idioma),
			items:[pnlCgg_gem_idioma],
			width:400,
			minWidth:400,
			maximizable:true,
			minimizable:true,
			constrainHeader:true,
			modal:true,
			bbar:[btnGuardarCgg_gem_idioma,btnCancelarCgg_gem_idioma,'->',btnCerrarCgg_gem_idioma]
	});
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_gem_idioma.
	*/
	function cargarCgg_gem_idiomaCtrls(){
		if(inRecordCgg_gem_idioma){
			txtCgidm_codigo.setValue(inRecordCgg_gem_idioma.get('CGIDM_CODIGO'));
			txtCgidm_nombre.setValue(inRecordCgg_gem_idioma.get('CGIDM_NOMBRE'));
			isEdit = true;
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_gem_idioma.
	* @returns ventana winFrmCgg_gem_idioma.
	* @base FrmCgg_gem_idioma.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_gem_idioma;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_gem_idioma.
	* @base FrmCgg_gem_idioma.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_gem_idiomaCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_idioma desde una instancia.
*/
FrmCgg_gem_idioma.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_idioma desde una instancia.
*/
FrmCgg_gem_idioma.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_idioma,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_gem_idioma.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_idioma desde una instancia.
*/
FrmCgg_gem_idioma.prototype.loadData = function(){
	this.loadData();
}
