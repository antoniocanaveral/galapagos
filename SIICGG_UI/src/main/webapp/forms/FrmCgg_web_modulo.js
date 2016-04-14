/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_web_modulo.
* @param {String} IN_SENTENCIA_CGG_WEB_MODULO Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_WEB_MODULO Registro de datos de la tabla Cgg_web_modulo.
* @constructor
* @base FrmListadoCgg_web_modulo
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_web_modulo(IN_SENTENCIA_CGG_WEB_MODULO,IN_RECORD_CGG_WEB_MODULO){
	var inSentenciaCgg_web_modulo = IN_SENTENCIA_CGG_WEB_MODULO;
	var inRecordCgg_web_modulo=IN_RECORD_CGG_WEB_MODULO;
	var urlCgg_web_modulo=URL_WS+"PublicWS/Cgg_web_modulo";
	var tituloCgg_web_modulo='M\u00F3dulo';
	var descCgg_web_modulo='El formulario permite administrar la informaci\u00F3n sobre el m\u00F3dulo';
	var isEdit = false;
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCwmod_codigo = new Ext.form.TextField({
			id:'txtCwmod_codigo',
			name:'txtCwmod_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
	});
	/**
	* Ext.form.TextField NOMBRE DEL MODULO
	*/
	var txtCwmod_nombre = new Ext.form.TextField({
			id:'txtCwmod_nombre',
			name:'txtCwmod_nombre',
			fieldLabel :'Nombre',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* Ext.form.TextArea DESCRIPCION ACERCA DEL MODULO
	*/
	var txtCwmod_descripcion = new Ext.form.TextArea({
			id:'txtCwmod_descripcion',
			name:'txtCwmod_descripcion',
			fieldLabel :'Descripcion',
			width:'90%',
			allowBlank :false
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_web_modulo
	*/
	var btnGuardarCgg_web_modulo = new Ext.Button({
			id:'btnGuardarCgg_web_modulo',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (!pnlCgg_web_modulo.getForm().isValid()){
						return;
					}
					try{
						function CallBackCgg_web_modulo(r){
							winFrmCgg_web_modulo.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_web_modulo,
										msg: 'La informaci\u00f3n de Web modulo ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_web_modulo.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_web_modulo,
										msg: 'La informaci\u00f3n de Web modulo no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_web_modulo.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCwmod_codigo',txtCwmod_codigo.getValue());
						param.add('inCwmod_nombre',txtCwmod_nombre.getValue());
						param.add('inCwmod_descripcion',txtCwmod_descripcion.getValue());
						SOAPClient.invoke(urlCgg_web_modulo,IN_SENTENCIA_CGG_WEB_MODULO,param, true, CallBackCgg_web_modulo);
					}catch(inErr){
						winFrmCgg_web_modulo.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_web_modulo.
	*/
	var btnCancelarCgg_web_modulo = new Ext.Button({
			id:'btnCancelarCgg_web_modulo',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_web_modulo.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_web_modulo.
	*/
	var btnCerrarCgg_web_modulo = new Ext.Button({
			id:'btnCerrarCgg_web_modulo',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_web_modulo.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_web_modulo.
	*/
	var pnlCgg_web_modulo = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCwmod_codigo,txtCwmod_nombre,txtCwmod_descripcion]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_web_modulo.
	*/
	var winFrmCgg_web_modulo = new Ext.Window({
			id:'winFrmCgg_web_modulo',
			title:tituloCgg_web_modulo,
			iconCls:'iconAplicacion',
			width:400,
			minWidth:400,
			maximizable:false,
			minimizable:false,
			resizable : false,
			constrain:true,
			modal : true,
			tbar:getPanelTitulo(tituloCgg_web_modulo,descCgg_web_modulo),
			items:[pnlCgg_web_modulo],
			bbar:[btnGuardarCgg_web_modulo,btnCancelarCgg_web_modulo,'->',btnCerrarCgg_web_modulo]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_web_modulo.getBottomToolbar());
	/**
	* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_web_modulo.
	* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	*/
	function habilitarCgg_web_moduloCtrls(inEstado){
		estado=!inEstado;
		txtCwmod_codigo.setDisabled(estado);
		txtCwmod_nombre.setDisabled(estado);
		txtCwmod_descripcion.setDisabled(estado);
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_web_modulo.
	*/
	function cargarCgg_web_moduloCtrls(){
		if(inRecordCgg_web_modulo){
			txtCwmod_codigo.setValue(inRecordCgg_web_modulo.get('CWMOD_CODIGO'));
			txtCwmod_nombre.setValue(inRecordCgg_web_modulo.get('CWMOD_NOMBRE'));
			txtCwmod_descripcion.setValue(inRecordCgg_web_modulo.get('CWMOD_DESCRIPCION'));
			isEdit = true;
			habilitarCgg_web_moduloCtrls(true);
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_web_modulo.
	* @returns ventana winFrmCgg_web_modulo.
	* @base FrmCgg_web_modulo.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_web_modulo;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_web_modulo.
	* @base FrmCgg_web_modulo.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_web_moduloCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_web_modulo desde una instancia.
*/
FrmCgg_web_modulo.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_web_modulo desde una instancia.
*/
FrmCgg_web_modulo.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_web_modulo,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_web_modulo.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_web_modulo desde una instancia.
*/
FrmCgg_web_modulo.prototype.loadData = function(){
	this.loadData();
}
