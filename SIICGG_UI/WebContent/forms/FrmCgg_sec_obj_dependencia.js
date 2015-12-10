/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_sec_obj_dependencia.
* @param {String} IN_SENTENCIA_CGG_SEC_OBJ_DEPENDENCIA Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_SEC_OBJ_DEPENDENCIA Registro de datos de la tabla Cgg_sec_obj_dependencia.
* @constructor
* @base FrmListadoCgg_sec_obj_dependencia
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_sec_obj_dependencia(IN_SENTENCIA_CGG_SEC_OBJ_DEPENDENCIA,IN_RECORD_CGG_SEC_OBJ_DEPENDENCIA){
	var inSentenciaCgg_sec_obj_dependencia = IN_SENTENCIA_CGG_SEC_OBJ_DEPENDENCIA;
	var inRecordCgg_sec_obj_dependencia=IN_RECORD_CGG_SEC_OBJ_DEPENDENCIA;
	var urlCgg_sec_obj_dependencia=URL_WS+"Cgg_sec_obj_dependencia";
	var tituloCgg_sec_obj_dependencia='Sec obj dependencia';
	var descCgg_sec_obj_dependencia='El formulario permite administrar la informaci\u00f3n de la tabla Sec obj dependencia';
	var isEdit = false;
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE DEPENDENCIA
	*/
	var txtCsbjd_codigo = new Ext.form.TextField({
			id:'txtCsbjd_codigo',
			name:'txtCsbjd_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO DEPENDIENTE
	*/
	var txtCsobj_codigo = new Ext.form.TextField({
			id:'txtCsobj_codigo',
			name:'txtCsobj_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO DEPENDIENTE
	*/
	var btnCsobj_codigoCgg_sec_obj_dependencia = new Ext.Button({
			id:'btnCsobj_codigoCgg_sec_obj_dependencia',
			text:'Csobj_codigo',
			iconCls:'iconCsobj_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_sec_objeto = new FrmListadoCgg_sec_objeto();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_sec_objeto.getStore(),tmpFLCgg_sec_objeto.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCsobj_codigo.setValue(tmpRecord.get('CSOBJ_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	*/
	var txtCgg_csobj_codigo = new Ext.form.TextField({
			id:'txtCgg_csobj_codigo',
			name:'txtCgg_csobj_codigo',
			fieldLabel :'Csobj codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	*/
	var btnCgg_csobj_codigoCgg_sec_obj_dependencia = new Ext.Button({
			id:'btnCgg_csobj_codigoCgg_sec_obj_dependencia',
			text:'Cgg_csobj_codigo',
			iconCls:'iconCgg_csobj_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_sec_objeto = new FrmListadoCgg_sec_objeto();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_sec_objeto.getStore(),tmpFLCgg_sec_objeto.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCgg_csobj_codigo.setValue(tmpRecord.get('CGG_CSOBJ_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_sec_obj_dependencia
	*/
	var btnGuardarCgg_sec_obj_dependencia = new Ext.Button({
			id:'btnGuardarCgg_sec_obj_dependencia',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (!pnlCgg_sec_obj_dependencia.getForm().isValid()){
						return;
					}
					try{
						function CallBackCgg_sec_obj_dependencia(r){
							winFrmCgg_sec_obj_dependencia.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_sec_obj_dependencia,
										msg: 'La informaci\u00f3n de Sec obj dependencia ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_sec_obj_dependencia.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_sec_obj_dependencia,
										msg: 'La informaci\u00f3n de Sec obj dependencia no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_sec_obj_dependencia.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCsbjd_codigo',txtCsbjd_codigo.getValue());
						param.add('inCsobj_codigo',txtCsobj_codigo.getValue());
						param.add('inCgg_csobj_codigo',txtCgg_csobj_codigo.getValue());
						SOAPClient.invoke(urlCgg_sec_obj_dependencia,IN_SENTENCIA_CGG_SEC_OBJ_DEPENDENCIA,param, true, CallBackCgg_sec_obj_dependencia);
					}catch(inErr){
						winFrmCgg_sec_obj_dependencia.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_sec_obj_dependencia.
	*/
	var btnCancelarCgg_sec_obj_dependencia = new Ext.Button({
			id:'btnCancelarCgg_sec_obj_dependencia',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_sec_obj_dependencia.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_sec_obj_dependencia.
	*/
	var btnCerrarCgg_sec_obj_dependencia = new Ext.Button({
			id:'btnCerrarCgg_sec_obj_dependencia',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_sec_obj_dependencia.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_sec_obj_dependencia.
	*/
	var pnlCgg_sec_obj_dependencia = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCsbjd_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCsobj_codigo]},{columnWidth:.4,layout:'form',items:[btnCsobj_codigoCgg_sec_obj_dependencia]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCgg_csobj_codigo]},{columnWidth:.4,layout:'form',items:[btnCgg_csobj_codigoCgg_sec_obj_dependencia]}]}]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_sec_obj_dependencia.
	*/
	var winFrmCgg_sec_obj_dependencia = new Ext.Window({
			id:'winFrmCgg_sec_obj_dependencia',
			title:tituloCgg_sec_obj_dependencia,
			iconCls:'iconAplicacion',
			width:400,
			minWidth:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			tbar:getPanelTitulo(tituloCgg_sec_obj_dependencia,descCgg_sec_obj_dependencia),
			items:[pnlCgg_sec_obj_dependencia],
			bbar:[btnGuardarCgg_sec_obj_dependencia,btnCancelarCgg_sec_obj_dependencia,'->',btnCerrarCgg_sec_obj_dependencia]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_sec_obj_dependencia.getBottomToolbar());
	/**
	* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_sec_obj_dependencia.
	* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	*/
	function habilitarCgg_sec_obj_dependenciaCtrls(inEstado){
		estado=!inEstado;
		txtCsbjd_codigo.setDisabled(estado);
		txtCsobj_codigo.setDisabled(estado);
		txtCgg_csobj_codigo.setDisabled(estado);
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_sec_obj_dependencia.
	*/
	function cargarCgg_sec_obj_dependenciaCtrls(){
		if(inRecordCgg_sec_obj_dependencia){
			txtCsbjd_codigo.setValue(inRecordCgg_sec_obj_dependencia.get('CSBJD_CODIGO'));
			txtCsobj_codigo.setValue(inRecordCgg_sec_obj_dependencia.get('CSOBJ_CODIGO'));
			txtCgg_csobj_codigo.setValue(inRecordCgg_sec_obj_dependencia.get('CGG_CSOBJ_CODIGO'));
			isEdit = true;
			habilitarCgg_sec_obj_dependenciaCtrls(true);
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_sec_obj_dependencia.
	* @returns ventana winFrmCgg_sec_obj_dependencia.
	* @base FrmCgg_sec_obj_dependencia.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_sec_obj_dependencia;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_sec_obj_dependencia.
	* @base FrmCgg_sec_obj_dependencia.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_sec_obj_dependenciaCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_sec_obj_dependencia desde una instancia.
*/
FrmCgg_sec_obj_dependencia.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_sec_obj_dependencia desde una instancia.
*/
FrmCgg_sec_obj_dependencia.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_sec_obj_dependencia,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_sec_obj_dependencia.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_sec_obj_dependencia desde una instancia.
*/
FrmCgg_sec_obj_dependencia.prototype.loadData = function(){
	this.loadData();
}
