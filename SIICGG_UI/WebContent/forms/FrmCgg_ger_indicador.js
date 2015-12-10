/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_ger_indicador.
* @param {String} IN_SENTENCIA_CGG_GER_INDICADOR Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_GER_INDICADOR Registro de datos de la tabla Cgg_ger_indicador.
* @constructor
* @base FrmListadoCgg_ger_indicador
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_ger_indicador(IN_SENTENCIA_CGG_GER_INDICADOR,IN_RECORD_CGG_GER_INDICADOR){
	var inSentenciaCgg_ger_indicador = IN_SENTENCIA_CGG_GER_INDICADOR;
	var inRecordCgg_ger_indicador=IN_RECORD_CGG_GER_INDICADOR;
	var urlCgg_ger_indicador=URL_WS+"Cgg_ger_indicador";
	var tituloCgg_ger_indicador='Ger indicador';
	var descCgg_ger_indicador='El formulario permite administrar la informaci\u00f3n de la tabla Ger indicador';
	var isEdit = false;
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCggin_codigo = new Ext.form.TextField({
			id:'txtCggin_codigo',
			name:'txtCggin_codigo',
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
	var txtCggit_codigo = new Ext.form.TextField({
			id:'txtCggit_codigo',
			name:'txtCggit_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var btnCggit_codigoCgg_ger_indicador = new Ext.Button({
			id:'btnCggit_codigoCgg_ger_indicador',
			text:'',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_ger_indicador_tipo = new FrmListadoCgg_ger_indicador_tipo();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_ger_indicador_tipo.getStore(),tmpFLCgg_ger_indicador_tipo.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								codigoTipo = tmpRecord.get('CGGIT_CODIGO')
								txtCggit_codigo.setValue(tmpRecord.get('CGGIT_DESCRIPCION'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	/*var txtCusu_codigo = new Ext.form.TextField({
			id:'txtCusu_codigo',
			name:'txtCusu_codigo',
			fieldLabel :'Usuario',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});*/
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	/*var btnCggit_codigoCgg_usuario = new Ext.Button({
			id:'btnCggit_codigoCgg_usuario',
			text:'',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_usuario = new FrmListadoCgg_usuario();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_usuario.getStore(),tmpFLCgg_usuario.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								codigoUsuario = tmpRecord.get('CUSU_CODIGO');
								txtCusu_codigo.setValue(tmpRecord.get('CUSU_NOMBRE_USUARIO'));
							}
					});
					objBusqueda.show();
			}}
	});*/
	
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCctn_codigo = new Ext.form.TextField({
			id:'txtCctn_codigo',
			name:'txtCctn_codigo',
			fieldLabel :'Cant\u00F3n',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var btnCggCctn_canton = new Ext.Button({
			id:'btnCggCctn_canton',
			text:'',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_canton = new FrmListadoCgg_canton();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_canton.getStore(),tmpFLCgg_canton.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								codigoCanton = tmpRecord.get ('CCTN_CODIGO');
								txtCctn_codigo.setValue(tmpRecord.get('CCTN_NOMBRE'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField NOMBRE DEL INDICADOR
	*/
	var txtCggin_nombre = new Ext.form.TextField({
			id:'txtCggin_nombre',
			name:'txtCggin_nombre',
			fieldLabel :'Nombre',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* Ext.form.TextArea DESCRIPCION DEL INDICADOR
	*/
	var txtCggin_descripcion = new Ext.form.TextArea({
			id:'txtCggin_descripcion',
			name:'txtCggin_descripcion',
			fieldLabel :'Descripcion',
			width:'90%',
			allowBlank :false
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_ger_indicador
	*/
	var btnGuardarCgg_ger_indicador = new Ext.Button({
			id:'btnGuardarCgg_ger_indicador',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (!pnlCgg_ger_indicador.getForm().isValid()){
						return;
					}
					try{
						function CallBackCgg_ger_indicador(r){
							winFrmCgg_ger_indicador.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_ger_indicador,
										msg: 'La informaci\u00f3n de Ger indicador ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_ger_indicador.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_ger_indicador,
										msg: 'La informaci\u00f3n de Ger indicador no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_ger_indicador.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCggin_codigo',txtCggin_codigo.getValue());
						param.add('inCggit_codigo',codigoTipo);//txtCggit_codigo.getValue());
						//param.add('inCusu_codigo',codigoUsuario);//txtCusu_codigo.getValue());
						//param.add('inCctn_codigo',codigoCanton);
						param.add('inCggin_nombre',txtCggin_nombre.getValue());
						param.add('inCggin_descripcion',txtCggin_descripcion.getValue());
						SOAPClient.invoke(urlCgg_ger_indicador,IN_SENTENCIA_CGG_GER_INDICADOR,param, true, CallBackCgg_ger_indicador);
					}catch(inErr){
						winFrmCgg_ger_indicador.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_ger_indicador.
	*/
	var btnCancelarCgg_ger_indicador = new Ext.Button({
			id:'btnCancelarCgg_ger_indicador',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_ger_indicador.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_ger_indicador.
	*/
	var btnCerrarCgg_ger_indicador = new Ext.Button({
			id:'btnCerrarCgg_ger_indicador',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_ger_indicador.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_ger_indicador.
	*/
	var pnlCgg_ger_indicador = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[
				txtCggin_codigo,
				{
					xtype:'panel',
					layout:'column',
					items:[
					{
						columnWidth:.87,
						layout:'form',
						items:[txtCggit_codigo]
					},{columnWidth:.13,
						layout:'form',
						items:[btnCggit_codigoCgg_ger_indicador]
					}]
				}/*,
				{
					xtype:'panel',
					layout:'column',
					items:[
					{
						columnWidth:.87,
						layout:'form',
						items:[txtCusu_codigo]
					},{columnWidth:.13,
						layout:'form',
						items:[btnCggit_codigoCgg_usuario]
					}]
				},
				{
					xtype:'panel',
					layout:'column',
					items:[
					{
						columnWidth:.87,
						layout:'form',
						items:[txtCctn_codigo]
					},{columnWidth:.13,
						layout:'form',
						items:[btnCggCctn_canton]
					}]
				}*/,
				txtCggin_nombre,
				txtCggin_descripcion
			]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_ger_indicador.
	*/
	var winFrmCgg_ger_indicador = new Ext.Window({
			id:'winFrmCgg_ger_indicador',
			title:tituloCgg_ger_indicador,
			iconCls:'iconAplicacion',
			
			/*minwidth:400,
			minHeight:400,
			maxHeight:400,
			maxWidth:400,*/
			
			width:400,
			minWidth:400,
			//height:400,
			minHeight:400,
			layout:'anchor',
			modal:true,
			constrain:true,
			maximizable:false,
			minimizable:false,
			constrain:true,
			modal : true,
			tbar:getPanelTitulo(tituloCgg_ger_indicador,descCgg_ger_indicador),
			items:[pnlCgg_ger_indicador],
			bbar:[btnGuardarCgg_ger_indicador,btnCancelarCgg_ger_indicador,'->',btnCerrarCgg_ger_indicador]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_ger_indicador.getBottomToolbar());
	/**
	* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_ger_indicador.
	* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	*/
	function habilitarCgg_ger_indicadorCtrls(inEstado){
		estado=!inEstado;
		txtCggin_codigo.setDisabled(estado);
		txtCggit_codigo.setDisabled(estado);
		txtCggin_nombre.setDisabled(estado);
		txtCggin_descripcion.setDisabled(estado);
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_ger_indicador.
	*/
	function cargarCgg_ger_indicadorCtrls(){
		if(inRecordCgg_ger_indicador){
			txtCggin_codigo.setValue(inRecordCgg_ger_indicador.get('CGGIN_CODIGO'));
			codigoTipo = inRecordCgg_ger_indicador.get('CGGIT_CODIGO');
			
			var param = new SOAPClientParameters();
			param.add('inCggit_codigo',codigoTipo);
			param.add('format',TypeFormat.JSON);

			var tmpTipo = SOAPClient.invoke(URL_WS+'Cgg_ger_indicador_tipo', 'select', param, false, null);
			try{
				tmpTipo = Ext.util.JSON.decode(tmpTipo);
				tmpTipo=tmpTipo[0];
				txtCggit_codigo.setValue(tmpTipo.CGGIT_DESCRIPCION);
			}catch(inErr){
				txtCggit_codigo.setValue('');
			}
			/*
			codigoUsuario = inRecordCgg_ger_indicador.get('CUSU_CODIGO');
			param = new SOAPClientParameters();
			param.add('inCusu_codigo',codigoUsuario);
			param.add('format',TypeFormat.JSON);

			var tmpTipo = SOAPClient.invoke(URL_WS+'Cgg_usuario', 'select', param, false, null);
			try{
				tmpTipo = Ext.util.JSON.decode(tmpTipo);
				tmpTipo=tmpTipo[0];
				txtCusu_codigo.setValue(tmpTipo.CUSU_NOMBRE_USUARIO);
			}catch(inErr){
				txtCusu_codigo.setValue('');
			}
			
			codigoCanton = inRecordCgg_ger_indicador.get('CCTN_CODIGO')
			param = new SOAPClientParameters();
			param.add('inCctn_codigo',codigoCanton);
			param.add('format',TypeFormat.JSON);

			var tmpTipo = SOAPClient.invoke(URL_WS+'Cgg_canton', 'select', param, false, null);
			try{
				tmpTipo = Ext.util.JSON.decode(tmpTipo);
				tmpTipo=tmpTipo[0];
				txtCctn_codigo.setValue(tmpTipo.CCTN_NOMBRE);
			}catch(inErr){
				txtCctn_codigo.setValue('');
			}*/
			
		
			//txtCctn_codigo.setValue(inRecordCgg_ger_indicador.get('CCTN_CODIGO'));
			txtCggin_nombre.setValue(inRecordCgg_ger_indicador.get('CGGIN_NOMBRE'));
			txtCggin_descripcion.setValue(inRecordCgg_ger_indicador.get('CGGIN_DESCRIPCION'));
			isEdit = true;
			habilitarCgg_ger_indicadorCtrls(true);
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_ger_indicador.
	* @returns ventana winFrmCgg_ger_indicador.
	* @base FrmCgg_ger_indicador.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_ger_indicador;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_ger_indicador.
	* @base FrmCgg_ger_indicador.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_ger_indicadorCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_ger_indicador desde una instancia.
*/
FrmCgg_ger_indicador.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_ger_indicador desde una instancia.
*/
FrmCgg_ger_indicador.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_ger_indicador,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_ger_indicador.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_ger_indicador desde una instancia.
*/
FrmCgg_ger_indicador.prototype.loadData = function(){
	this.loadData();
}
