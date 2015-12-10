/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_ger_matriz.
* @param {String} IN_SENTENCIA_CGG_GER_MATRIZ Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_GER_MATRIZ Registro de datos de la tabla Cgg_ger_matriz.
* @constructor
* @base FrmListadoCgg_ger_matriz
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_ger_matriz(IN_SENTENCIA_CGG_GER_MATRIZ,IN_RECORD_CGG_GER_MATRIZ,inRecordNew){
	var inSentenciaCgg_ger_matriz = IN_SENTENCIA_CGG_GER_MATRIZ;
	var inRecordCgg_ger_matriz=IN_RECORD_CGG_GER_MATRIZ;
	var urlCgg_ger_matriz=URL_WS+"Cgg_ger_matriz";
	var tituloCgg_ger_matriz='Indicador';
	var descCgg_ger_matriz='El formulario permite administrar la informaci\u00f3n del Indicador';
	var isEdit = false;
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCggma_codigo = new Ext.form.TextField({
			id:'txtCggma_codigo',
			name:'txtCggma_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	var txtCctn_codigo = new Ext.form.TextField({
			id:'txtCctn_codigo',
			name:'txtCctn_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			hidden:true,
			readOnly:'true',
			allowBlank :false
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCggin_codigo = new Ext.form.TextField({
			id:'txtCggin_codigo',
			name:'txtCggin_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:true,
			allowBlank :false,
			hidden:true
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	var txtCusu_codigo = new Ext.form.TextField({
			id:'txtCusu_codigo',
			name:'txtCusu_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:true,
			allowBlank :false,
			hidden:true
	});
	/**
	* Ext.form.TextField MES DEL INDICADOR
	*/
	var txtCggma_mes = new Ext.form.TextField({
			id:'txtCggma_mes',
			name:'txtCggma_mes',
			fieldLabel :'Mes',
			readOnly:true,
			hidden:true,
			anchor:'98%',
			allowBlank :false
	});
	/**
	* Ext.form.TextField AÑO DEL INIDICADOR
	*/
	var txtCggma_anio = new Ext.form.TextField({
			id:'txtCggma_anio',
			name:'txtCggma_anio',
			fieldLabel :'Anio',
			anchor:'98%',
			allowBlank :false,
			hidden:true
	});
	/**
	* Ext.form.NumberField VALOR DEL INDICADOR
	*/
	var numCggma_valor = new Ext.form.NumberField({
			id:'numCggma_valor',
			name:'numCggma_valor',
			fieldLabel :'Valor',
			allowBlank :false,
			disabled :false
	});
	/**
	* Ext.form.TextField DESCRIPCION DEL VALOR DE LA MATRIZ
	*/
	var txtCggma_descripcion = new Ext.form.TextArea({
			id:'txtCggma_descripcion',
			name:'txtCggma_descripcion',
			fieldLabel :'Observaci\u00f3n',
			anchor:'98%'
	});
	/**
	* Ext.form.NumberField NUMERO DE ACTUALIZACIONES DEL REGISTRO
	*/
	var numCggma_actualizaciones = new Ext.form.NumberField({
			id:'numCggma_actualizaciones',
			name:'numCggma_actualizaciones',
			fieldLabel :'Actualizaciones',
			allowBlank :false,
			disabled :false,
			value:0,
			hidden:true
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_ger_matriz
	*/
	var btnGuardarCgg_ger_matriz = new Ext.Button({
			id:'btnGuardarCgg_ger_matriz',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (!pnlCgg_ger_matriz.getForm().isValid()){
						return;
					}
					try{
						function CallBackCgg_ger_matriz(r){
							winFrmCgg_ger_matriz.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_ger_matriz,
										msg: 'La informaci\u00f3n de Indicador ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_ger_matriz.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_ger_matriz,
										msg: 'La informaci\u00f3n de Indicador no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_ger_matriz.getEl().mask('Guardando...', 'x-mask-loading');
						var tmpuserSessionData = new UserSession().getUserData();	
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCggma_codigo',txtCggma_codigo.getValue());
						param.add('inCctn_codigo',txtCctn_codigo.getValue());
						param.add('inCggin_codigo',txtCggin_codigo.getValue());
						param.add('inCusu_codigo',tmpuserSessionData.CUSU_CODIGO);
						param.add('inCggma_mes',txtCggma_mes.getValue());
						param.add('inCggma_anio',txtCggma_anio.getValue());
						param.add('inCggma_valor',numCggma_valor.getValue());
						param.add('inCggma_descripcion',txtCggma_descripcion.getValue());
						param.add('inCggma_actualizaciones',numCggma_actualizaciones.getValue());
						SOAPClient.invoke(urlCgg_ger_matriz,IN_SENTENCIA_CGG_GER_MATRIZ,param, true, CallBackCgg_ger_matriz);
					}catch(inErr){
						winFrmCgg_ger_matriz.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_ger_matriz.
	*/
	var btnCancelarCgg_ger_matriz = new Ext.Button({
			id:'btnCancelarCgg_ger_matriz',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_ger_matriz.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_ger_matriz.
	*/
	var btnCerrarCgg_ger_matriz = new Ext.Button({
			id:'btnCerrarCgg_ger_matriz',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_ger_matriz.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_ger_matriz.
	*/
	var pnlCgg_ger_matriz = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCggma_codigo,txtCctn_codigo,txtCggin_codigo,txtCusu_codigo,txtCggma_mes,txtCggma_anio,numCggma_valor,txtCggma_descripcion,numCggma_actualizaciones]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_ger_matriz.
	*/
	var winFrmCgg_ger_matriz = new Ext.Window({
			id:'winFrmCgg_ger_matriz',
			title:tituloCgg_ger_matriz,
			iconCls:'iconAplicacion',
			width:400,
			minWidth:400,
			maximizable:true,
			minimizable:true,
			modal:true,
			constrain:true,
			tbar:getPanelTitulo(tituloCgg_ger_matriz,descCgg_ger_matriz),
			items:[pnlCgg_ger_matriz],
			bbar:[btnGuardarCgg_ger_matriz,btnCancelarCgg_ger_matriz,'->',btnCerrarCgg_ger_matriz]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_ger_matriz.getBottomToolbar());
	/**
	* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_ger_matriz.
	* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	*/
	function habilitarCgg_ger_matrizCtrls(inEstado){
		estado=!inEstado;
		txtCggma_codigo.setDisabled(estado);
		txtCctn_codigo.setDisabled(estado);
		txtCggin_codigo.setDisabled(estado);
		txtCusu_codigo.setDisabled(estado);
		txtCggma_mes.setDisabled(estado);
		txtCggma_anio.setDisabled(estado);
		numCggma_valor.setDisabled(estado);
		txtCggma_descripcion.setDisabled(estado);
		numCggma_actualizaciones.setDisabled(estado);
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_ger_matriz.
	*/
	function cargarCgg_ger_matrizCtrls(){
		if(inRecordCgg_ger_matriz){
			txtCggma_codigo.setValue(inRecordCgg_ger_matriz.CGGMA_CODIGO);
			txtCctn_codigo.setValue(inRecordCgg_ger_matriz.CCTN_CODIGO);
			txtCggin_codigo.setValue(inRecordCgg_ger_matriz.CGGIN_CODIGO);
			txtCusu_codigo.setValue(inRecordCgg_ger_matriz.CUSU_CODIGO);
			txtCggma_mes.setValue(inRecordCgg_ger_matriz.CGGMA_MES);
			txtCggma_anio.setValue(inRecordCgg_ger_matriz.CGGMA_ANIO);
			numCggma_valor.setValue(inRecordCgg_ger_matriz.CGGMA_VALOR);
			txtCggma_descripcion.setValue(inRecordCgg_ger_matriz.CGGMA_DESCRIPCION);
			numCggma_actualizaciones.setValue(inRecordCgg_ger_matriz.CGGMA_ACTUALIZACIONES);
			isEdit = true;
			habilitarCgg_ger_matrizCtrls(true);
		}else{
			txtCctn_codigo.setValue(inRecordNew.CCTN_CODIGO);
			txtCggin_codigo.setValue(inRecordNew.CGGIN_CODIGO);
			txtCusu_codigo.setValue(inRecordNew.CUSU_CODIGO);
			txtCggma_mes.setValue(inRecordNew.CGGMA_MES);
			txtCggma_anio.setValue(inRecordNew.CGGMA_ANIO);
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_ger_matriz.
	* @returns ventana winFrmCgg_ger_matriz.
	* @base FrmCgg_ger_matriz.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_ger_matriz;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_ger_matriz.
	* @base FrmCgg_ger_matriz.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_ger_matrizCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_ger_matriz desde una instancia.
*/
FrmCgg_ger_matriz.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_ger_matriz desde una instancia.
*/
FrmCgg_ger_matriz.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_ger_matriz,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_ger_matriz.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_ger_matriz desde una instancia.
*/
FrmCgg_ger_matriz.prototype.loadData = function(){
	this.loadData();
}
