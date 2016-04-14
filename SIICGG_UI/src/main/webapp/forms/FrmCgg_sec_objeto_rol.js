/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_sec_objeto_rol.
* @param {String} IN_SENTENCIA_CGG_SEC_OBJETO_ROL Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_SEC_OBJETO_ROL Registro de datos de la tabla Cgg_sec_objeto_rol.
* @constructor
* @base FrmListadoCgg_sec_objeto_rol
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_sec_objeto_rol(IN_SENTENCIA_CGG_SEC_OBJETO_ROL,IN_RECORD_CGG_SEC_OBJETO_ROL){
	var inSentenciaCgg_sec_objeto_rol = IN_SENTENCIA_CGG_SEC_OBJETO_ROL;
	var inRecordCgg_sec_objeto_rol=IN_RECORD_CGG_SEC_OBJETO_ROL;
	var urlCgg_sec_objeto_rol=URL_WS+"Cgg_sec_objeto_rol";
	var tituloCgg_sec_objeto_rol='Objeto';
	var descCgg_sec_objeto_rol='El formulario permite administrar el objeto concedido al rol.';
	var isEdit = false;
	var tmpDatos = new Array();
	var tmpObjetos = new Array();
	var tmpTipoObjeto;
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO_ROL
	*/
	var txtCsbjr_codigo = new Ext.form.TextField({
			id:'txtCsbjr_codigo',
			name:'txtCsbjr_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	*/
	var txtCsobj_codigo = new Ext.form.TextField({
			id:'txtCsobj_codigo',
			name:'txtCsobj_codigo',
			fieldLabel :'Objeto',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE OBJETO
	*/
	var btnCsobj_codigoCgg_sec_objeto_rol = new Ext.Button({
			id:'btnCsobj_codigoCgg_sec_objeto_rol',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
				var tmpStore;
				var tmpColumnModel;
				var tmpFLCgg_sec_objeto = new FrmListadoCgg_sec_objeto();
				if(tmpTipoObjeto == 0){
					tmpStore = tmpFLCgg_sec_objeto.getStore();
					tmpColumnModel = tmpFLCgg_sec_objeto.getColumnModel();
				}else{
					tmpStore = tmpFLCgg_sec_objeto.getWSStore();
					tmpColumnModel = tmpFLCgg_sec_objeto.getWSColumnModel();
				}
				tmpStore.baseParams.inCsrol_codigo = tmpDatos['ROL'];
				tmpColumnModel.setHidden(1, false);
					var objBusqueda = new DlgBusqueda(tmpStore,tmpColumnModel, true);
					objBusqueda.closeHandler(function(){
							var tmpRecords = objBusqueda.getSelectedRows();
							if(tmpRecords){
								for(i = 0; i < tmpRecords.length; i++){
									tmpObjetos.push(tmpRecords[i].get('CSOBJ_CODIGO'));
								}
								if(tmpRecords.length > 1)
									txtCsobj_codigo.setValue('Varios ...');
								else
									txtCsobj_codigo.setValue(tmpRecords[0].get('CSOBJ_NOMBRE'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.Checkbox SI TIENE ACCESO DIRECTO EN EL ESCRITORIO
	*/
	var chkCsbjr_acceso_directo = new Ext.form.Checkbox({
			id:'chkCsbjr_acceso_directo',
			name:'chkCsbjr_acceso_directo',
			fieldLabel :'Acceso directo'
	});
	/**
	* Ext.form.TextField TEXTO DEL ACCESO DIRECTO. SOLO ES APLICABLE A LOS OBJETOS VISUALES.
	*/
	var txtCsbjr_acceso_directo_texto = new Ext.form.TextField({
		id:'txtCsbjr_acceso_directo_texto',
		name:'txtCsbjr_acceso_directo_texto',
		fieldLabel :'Texto',
		anchor:'98%',
		maxLength:20
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_sec_objeto_rol
	*/
	var btnGuardarCgg_sec_objeto_rol = new Ext.Button({
			id:'btnGuardarCgg_sec_objeto_rol',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if(chkCsbjr_acceso_directo.getValue() && txtCsbjr_acceso_directo_texto.getValue().trim().length == 0){
						Ext.Msg.show({
										title:tituloCgg_sec_objeto_rol,
										msg: 'Por favor ingrese el texto del acceso directo.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});
						return;
					}
					if (pnlCgg_sec_objeto_rol.getForm().isValid()==false){
						return;
					}
					try{
						function CallBackCgg_sec_objeto_rol(r){
							
								winFrmCgg_sec_objeto_rol.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloCgg_sec_objeto_rol,
											msg: 'La informaci\u00f3n de Objeto ha sido almacenada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});winFrmCgg_sec_objeto_rol.close()
								}else{
									Ext.Msg.show({
											title:tituloCgg_sec_objeto_rol,
											msg: 'La informaci\u00f3n del Objeto no ha podido ser almacenada. '+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
								}
							
						}
						winFrmCgg_sec_objeto_rol.getEl().mask('Guardando...', 'x-mask-loading');
						var tmpJSONObjects ='[';
						for (i = 0; i < tmpObjetos.length; i++){
							if(tmpJSONObjects.length > 1)
								tmpJSONObjects += ",";
							tmpJSONObjects += "{\"CSBJR_CODIGO\":\""+txtCsbjr_codigo.getValue()+"\",";
							tmpJSONObjects += "\"CSROL_CODIGO\":\""+tmpDatos['ROL']+"\",";
							tmpJSONObjects += "\"CSOBJ_CODIGO\":\""+tmpObjetos[i]+"\",";
							tmpJSONObjects += "\"CSBJR_ACCESO_DIRECTO\":\""+chkCsbjr_acceso_directo.getValue()+"\",";
							tmpJSONObjects += "\"CSBJR_ACCESO_DIRECTO_TEXTO\":\""+txtCsbjr_acceso_directo_texto.getValue()+"\"}";
						}
						tmpJSONObjects +=']';
						var param = new SOAPClientParameters();
						param.add('inObjects',tmpJSONObjects);
						SOAPClient.invoke(urlCgg_sec_objeto_rol,"insertJSON",param, true, CallBackCgg_sec_objeto_rol);
					}catch(inErr){
						winFrmCgg_sec_objeto_rol.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_sec_objeto_rol.
	*/
	var btnCancelarCgg_sec_objeto_rol = new Ext.Button({
			id:'btnCancelarCgg_sec_objeto_rol',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_sec_objeto_rol.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_sec_objeto_rol.
	*/
	var btnCerrarCgg_sec_objeto_rol = new Ext.Button({
			id:'btnCerrarCgg_sec_objeto_rol',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_sec_objeto_rol.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_sec_objeto_rol.
	*/
	var pnlCgg_sec_objeto_rol = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCsbjr_codigo,
			{xtype:'panel',layout:'column',items:[{columnWidth:.92,layout:'form',items:[txtCsobj_codigo]},{columnWidth:.08,layout:'form',items:[btnCsobj_codigoCgg_sec_objeto_rol]}]}
			]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_sec_objeto_rol.
	*/
	var winFrmCgg_sec_objeto_rol = new Ext.Window({
			id:'winFrmCgg_sec_objeto_rol',
			title:tituloCgg_sec_objeto_rol,
			width:400,
			minWidth:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			modal:true,
			tbar:getPanelTitulo(tituloCgg_sec_objeto_rol,descCgg_sec_objeto_rol),
			items:[pnlCgg_sec_objeto_rol],
			bbar:[btnGuardarCgg_sec_objeto_rol,btnCancelarCgg_sec_objeto_rol,'->',btnCerrarCgg_sec_objeto_rol]
	});
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_sec_objeto_rol.
	* @returns ventana winFrmCgg_sec_objeto_rol.
	* @base FrmCgg_sec_objeto_rol.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_sec_objeto_rol;
	}
	/**
	* Funcion miembro que asigna el Rol de trabajo dentro del formulario.
	*/
	this.setRol = function(inRol){
		tmpDatos['ROL'] = inRol;
	}
	/**
	* Funcion miembro que asigna el Tipo de objeto de trabajo dentro del formulario.
	*/
	this.setTypeObject = function(inTypeObject){
		tmpTipoObjeto = inTypeObject;
		chkCsbjr_acceso_directo.setDisabled(inTypeObject == 1);
		if(tmpTipoObjeto == 0){
			pnlCgg_sec_objeto_rol.add(chkCsbjr_acceso_directo);
			pnlCgg_sec_objeto_rol.add(txtCsbjr_acceso_directo_texto);
		}
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_sec_objeto_rol.
	*/
	function cargarCgg_sec_objeto_rolCtrls(){
		if(inRecordCgg_sec_objeto_rol){
			txtCsbjr_codigo.setValue(inRecordCgg_sec_objeto_rol.get('CSBJR_CODIGO'));
			tmpDatos['ROL'] = inRecordCgg_sec_objeto_rol.get('CSROL_CODIGO');
			tmpObjetos.push(inRecordCgg_sec_objeto_rol.get('CSOBJ_CODIGO'));
			txtCsobj_codigo.setValue(inRecordCgg_sec_objeto_rol.get('CSOBJ_NOMBRE'));
			chkCsbjr_acceso_directo.setValue(inRecordCgg_sec_objeto_rol.data.CSBJR_ACCESO_DIRECTO);
			txtCsbjr_acceso_directo_texto.setValue(inRecordCgg_sec_objeto_rol.get('CSBJR_ACCESO_DIRECTO_TEXTO'));
			isEdit = true;
			chkCsbjr_acceso_directo.setDisabled(tmpTipoObjeto == 1);
		}
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_sec_objeto_rol.
	* @base FrmCgg_sec_objeto_rol.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_sec_objeto_rolCtrls();
	}
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_sec_objeto_rol desde una instancia.
*/
FrmCgg_sec_objeto_rol.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_sec_objeto_rol desde una instancia.
*/
FrmCgg_sec_objeto_rol.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_sec_objeto_rol,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_sec_objeto_rol.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite establecer el Rol de trabajo dentro del formulario.
*/
FrmCgg_sec_objeto_rol.prototype.setRol = function(inRol){
	this.setRol(inRol);
}
/**
* Funcion prototipo. Permite establecer el Tipo de objeto de trabajo dentro del formulario.
*/
FrmCgg_sec_objeto_rol.prototype.setTypeObject = function(inTypeObject){
	this.setTypeObject(inTypeObject);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_sec_objeto_rol desde una instancia.
*/
FrmCgg_sec_objeto_rol.prototype.loadData = function(){
	this.loadData();
}