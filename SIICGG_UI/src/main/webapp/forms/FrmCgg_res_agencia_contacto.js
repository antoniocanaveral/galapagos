/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_agencia_contacto.
* @param {String} IN_SENTENCIA_CGG_RES_AGENCIA_CONTACTO Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_RES_AGENCIA_CONTACTO Registro de datos de la tabla Cgg_res_agencia_contacto.
* @constructor
* @base FrmListadoCgg_res_agencia_contacto
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_res_agencia_contacto(IN_SENTENCIA_CGG_RES_AGENCIA_CONTACTO,IN_RECORD_CGG_RES_AGENCIA_CONTACTO){
	var inSentenciaCgg_res_agencia_contacto = IN_SENTENCIA_CGG_RES_AGENCIA_CONTACTO;
	var inRecordCgg_res_agencia_contacto=IN_RECORD_CGG_RES_AGENCIA_CONTACTO;
	var urlCgg_res_agencia_contacto=URL_WS+"PublicWS/Cgg_res_agencia_contacto";
	var tituloCgg_res_agencia_contacto='Contacto Agencia';
	var descCgg_res_agencia_contacto='El formulario permite administrar la informaci\u00f3n del contacto de la agencia';
	var isEdit = false;
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCwcag_codigo = new Ext.form.TextField({
			id:'txtCwcag_codigo',
			name:'txtCwcag_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCwage_codigo = new Ext.form.TextField({
			id:'txtCwage_codigo',
			name:'txtCwage_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var btnCwage_codigoCgg_res_agencia_contacto = new Ext.Button({
			id:'btnCwage_codigoCgg_res_agencia_contacto',
			text:'Cwage_codigo',
			iconCls:'iconCwage_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_web_agencia = new FrmListadoCgg_web_agencia();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_web_agencia.getStore(),tmpFLCgg_web_agencia.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCwage_codigo.setValue(tmpRecord.get('CWAGE_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	*/
	var txtCrtco_codigo = new Ext.form.TextField({
			id:'txtCrtco_codigo',
			name:'txtCrtco_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE CONTACTO
	*/
	var btnCrtco_codigoCgg_res_agencia_contacto = new Ext.Button({
			id:'btnCrtco_codigoCgg_res_agencia_contacto',
			text:'Crtco_codigo',
			iconCls:'iconCrtco_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_res_tipo_contacto = new FrmListadoCgg_res_tipo_contacto();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_res_tipo_contacto.getStore(),tmpFLCgg_res_tipo_contacto.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCrtco_codigo.setValue(tmpRecord.get('CRTCO_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField VALOR ASIGNADO AL CONTACTO
	*/
	var txtCwcag_descripcion = new Ext.form.TextField({
			id:'txtCwcag_descripcion',
			name:'txtCwcag_descripcion',
			fieldLabel :'Descripcion',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* Ext.form.TextField NUMERO DE CONTACTO, DIRECCION DE CORREO ELECTRONICO
	*/
	var txtCwcag_contacto = new Ext.form.TextField({
			id:'txtCwcag_contacto',
			name:'txtCwcag_contacto',
			fieldLabel :'Contacto',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_res_agencia_contacto
	*/
	var btnGuardarCgg_res_agencia_contacto = new Ext.Button({
			id:'btnGuardarCgg_res_agencia_contacto',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (!pnlCgg_res_agencia_contacto.getForm().isValid()){
						return;
					}
					try{
						function CallBackCgg_res_agencia_contacto(r){
							winFrmCgg_res_agencia_contacto.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_res_agencia_contacto,
										msg: 'La informaci\u00f3n del contacto de la agencia ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_res_agencia_contacto.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_res_agencia_contacto,
										msg: 'La informaci\u00f3n del contacto de la agencia no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_res_agencia_contacto.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCwcag_codigo',txtCwcag_codigo.getValue());
						param.add('inCwage_codigo',txtCwage_codigo.getValue());
						param.add('inCrtco_codigo',txtCrtco_codigo.getValue());
						param.add('inCwcag_descripcion',txtCwcag_descripcion.getValue());
						param.add('inCwcag_contacto',txtCwcag_contacto.getValue());
						SOAPClient.invoke(urlCgg_res_agencia_contacto,IN_SENTENCIA_CGG_RES_AGENCIA_CONTACTO,param, true, CallBackCgg_res_agencia_contacto);
					}catch(inErr){
						winFrmCgg_res_agencia_contacto.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_agencia_contacto.
	*/
	var btnCancelarCgg_res_agencia_contacto = new Ext.Button({
			id:'btnCancelarCgg_res_agencia_contacto',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_res_agencia_contacto.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_res_agencia_contacto.
	*/
	var btnCerrarCgg_res_agencia_contacto = new Ext.Button({
			id:'btnCerrarCgg_res_agencia_contacto',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_res_agencia_contacto.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_agencia_contacto.
	*/
	var pnlCgg_res_agencia_contacto = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCwcag_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCwage_codigo]},{columnWidth:.4,layout:'form',items:[btnCwage_codigoCgg_res_agencia_contacto]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCrtco_codigo]},{columnWidth:.4,layout:'form',items:[btnCrtco_codigoCgg_res_agencia_contacto]}]},txtCwcag_descripcion,txtCwcag_contacto]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_agencia_contacto.
	*/
	var winFrmCgg_res_agencia_contacto = new Ext.Window({
			id:'winFrmCgg_res_agencia_contacto',
			title:tituloCgg_res_agencia_contacto,
			iconCls:'iconAplicacion',
			width:400,
			minWidth:400,
			maximizable:false,
			minimizable:false,
			modal : true,
			resizable : false,
			constrain:true,
			tbar:getPanelTitulo(tituloCgg_res_agencia_contacto,descCgg_res_agencia_contacto),
			items:[pnlCgg_res_agencia_contacto],
			bbar:[btnGuardarCgg_res_agencia_contacto,btnCancelarCgg_res_agencia_contacto,'->',btnCerrarCgg_res_agencia_contacto]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_res_agencia_contacto.getBottomToolbar());
	/**
	* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_agencia_contacto.
	* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	*/
	function habilitarCgg_res_agencia_contactoCtrls(inEstado){
		estado=!inEstado;
		txtCwcag_codigo.setDisabled(estado);
		txtCwage_codigo.setDisabled(estado);
		txtCrtco_codigo.setDisabled(estado);
		txtCwcag_descripcion.setDisabled(estado);
		txtCwcag_contacto.setDisabled(estado);
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_agencia_contacto.
	*/
	function cargarCgg_res_agencia_contactoCtrls(){
		if(inRecordCgg_res_agencia_contacto){
			txtCwcag_codigo.setValue(inRecordCgg_res_agencia_contacto.get('CWCAG_CODIGO'));
			txtCwage_codigo.setValue(inRecordCgg_res_agencia_contacto.get('CWAGE_CODIGO'));
			txtCrtco_codigo.setValue(inRecordCgg_res_agencia_contacto.get('CRTCO_CODIGO'));
			txtCwcag_descripcion.setValue(inRecordCgg_res_agencia_contacto.get('CWCAG_DESCRIPCION'));
			txtCwcag_contacto.setValue(inRecordCgg_res_agencia_contacto.get('CWCAG_CONTACTO'));
			isEdit = true;
			habilitarCgg_res_agencia_contactoCtrls(true);
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_res_agencia_contacto.
	* @returns ventana winFrmCgg_res_agencia_contacto.
	* @base FrmCgg_res_agencia_contacto.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_res_agencia_contacto;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_res_agencia_contacto.
	* @base FrmCgg_res_agencia_contacto.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_res_agencia_contactoCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_agencia_contacto desde una instancia.
*/
FrmCgg_res_agencia_contacto.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_agencia_contacto desde una instancia.
*/
FrmCgg_res_agencia_contacto.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_agencia_contacto,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_res_agencia_contacto.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_agencia_contacto desde una instancia.
*/
FrmCgg_res_agencia_contacto.prototype.loadData = function(){
	this.loadData();
}
