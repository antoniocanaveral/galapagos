/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_sec_objeto.
* @param {String} IN_SENTENCIA_CGG_SEC_OBJETO Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_SEC_OBJETO Registro de datos de la tabla Cgg_sec_objeto.
* @constructor
* @base FrmListadoCgg_sec_objeto
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_sec_objeto(IN_SENTENCIA_CGG_SEC_OBJETO,IN_RECORD_CGG_SEC_OBJETO){
	var inSentenciaCgg_sec_objeto = IN_SENTENCIA_CGG_SEC_OBJETO;
	var inRecordCgg_sec_objeto=IN_RECORD_CGG_SEC_OBJETO;
	var urlCgg_sec_objeto=URL_WS+"Cgg_sec_objeto";
	var tituloCgg_sec_objeto='Sec objeto';
	var descCgg_sec_objeto='El formulario permite administrar la informaci\u00f3n de la tabla Sec objeto';
	var isEdit = false;
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	*/
	var txtCsobj_codigo = new Ext.form.TextField({
			id:'txtCsobj_codigo',
			name:'txtCsobj_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
	});
	/**
	* Ext.form.TextField NOMBRE DEL OBJETO
	*/
	var txtCsobj_nombre = new Ext.form.TextField({
			id:'txtCsobj_nombre',
			name:'txtCsobj_nombre',
			fieldLabel :'Nombre',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* Ext.form.TextArea RUTA DEL ARCHIVO QUE CONTIENE AL OBJETO
	*/
	var txtCsobj_ruta = new Ext.form.TextArea({
			id:'txtCsobj_ruta',
			name:'txtCsobj_ruta',
			fieldLabel :'Ruta',
			width:'90%',
			allowBlank :false
	});
	/**
	* Ext.form.TextArea TEXTO DESCRIPTIVO DEL OBJETO
	*/
	var txtCsobj_descripcion = new Ext.form.TextArea({
			id:'txtCsobj_descripcion',
			name:'txtCsobj_descripcion',
			fieldLabel :'Descripcion',
			width:'90%',
			allowBlank :false
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_sec_objeto
	*/
	var btnGuardarCgg_sec_objeto = new Ext.Button({
			id:'btnGuardarCgg_sec_objeto',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (pnlCgg_sec_objeto.getForm().isValid()==false){
						return;
					}
					try{
						function CallBackCgg_sec_objeto(r){
							winFrmCgg_sec_objeto.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_sec_objeto,
										msg: 'La informaci\u00f3n de Sec objeto ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_sec_objeto.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_sec_objeto,
										msg: 'La informaci\u00f3n de Sec objeto no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_sec_objeto.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCsobj_codigo',txtCsobj_codigo.getValue());
						param.add('inCsobj_nombre',txtCsobj_nombre.getValue());
						param.add('inCsobj_ruta',txtCsobj_ruta.getValue());
						param.add('inCsobj_descripcion',txtCsobj_descripcion.getValue());
						SOAPClient.invoke(urlCgg_sec_objeto,IN_SENTENCIA_CGG_SEC_OBJETO,param, true, CallBackCgg_sec_objeto);
					}catch(inErr){
						winFrmCgg_sec_objeto.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_sec_objeto.
	*/
	var btnCancelarCgg_sec_objeto = new Ext.Button({
			id:'btnCancelarCgg_sec_objeto',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_sec_objeto.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_sec_objeto.
	*/
	var btnCerrarCgg_sec_objeto = new Ext.Button({
			id:'btnCerrarCgg_sec_objeto',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_sec_objeto.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_sec_objeto.
	*/
	var pnlCgg_sec_objeto = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCsobj_codigo,txtCsobj_nombre,txtCsobj_ruta,txtCsobj_descripcion]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_sec_objeto.
	*/
	var winFrmCgg_sec_objeto = new Ext.Window({
			id:'winFrmCgg_sec_objeto',
			title:tituloCgg_sec_objeto,
			width:400,
			minWidth:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			tbar:getPanelTitulo(tituloCgg_sec_objeto,descCgg_sec_objeto),
			items:[pnlCgg_sec_objeto],
			bbar:[btnGuardarCgg_sec_objeto,btnCancelarCgg_sec_objeto,'->',btnCerrarCgg_sec_objeto]
	});
	/**
	* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_sec_objeto.
	* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	*/
	function habilitarCgg_sec_objetoCtrls(inEstado){
		estado=!inEstado;
		txtCsobj_codigo.setDisabled(estado);
		txtCsobj_nombre.setDisabled(estado);
		txtCsobj_ruta.setDisabled(estado);
		txtCsobj_descripcion.setDisabled(estado);
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_sec_objeto.
	*/
	function cargarCgg_sec_objetoCtrls(){
		if(inRecordCgg_sec_objeto){
			txtCsobj_codigo.setValue(inRecordCgg_sec_objeto.get('CSOBJ_CODIGO'));
			txtCsobj_nombre.setValue(inRecordCgg_sec_objeto.get('CSOBJ_NOMBRE'));
			txtCsobj_ruta.setValue(inRecordCgg_sec_objeto.get('CSOBJ_RUTA'));
			txtCsobj_descripcion.setValue(inRecordCgg_sec_objeto.get('CSOBJ_DESCRIPCION'));
			isEdit = true;
			habilitarCgg_sec_objetoCtrls(true);
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_sec_objeto.
	* @returns ventana winFrmCgg_sec_objeto.
	* @base FrmCgg_sec_objeto.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_sec_objeto;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_sec_objeto.
	* @base FrmCgg_sec_objeto.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_sec_objetoCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_sec_objeto desde una instancia.
*/
FrmCgg_sec_objeto.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_sec_objeto desde una instancia.
*/
FrmCgg_sec_objeto.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_sec_objeto,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_sec_objeto.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_sec_objeto desde una instancia.
*/
FrmCgg_sec_objeto.prototype.loadData = function(){
	this.loadData();
}
