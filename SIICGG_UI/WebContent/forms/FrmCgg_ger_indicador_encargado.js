/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_ger_indicador_encargado.
* @param {String} IN_SENTENCIA_CGG_GER_INDICADOR_ENCARGADO Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_GER_INDICADOR_ENCARGADO Registro de datos de la tabla Cgg_ger_indicador_encargado.
* @constructor
* @base FrmListadoCgg_ger_indicador_encargado
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_ger_indicador_encargado(IN_SENTENCIA_CGG_GER_INDICADOR_ENCARGADO,IN_RECORD_CGG_GER_INDICADOR_ENCARGADO){	
	var inSentenciaCgg_ger_indicador_encargado = IN_SENTENCIA_CGG_GER_INDICADOR_ENCARGADO;
	var inRecordCgg_ger_indicador_encargado=IN_RECORD_CGG_GER_INDICADOR_ENCARGADO;
	var urlCgg_ger_indicador_encargado=URL_WS+"Cgg_ger_indicador_encargado";
	var tituloCgg_ger_indicador_encargado='Ger indicador encargado';
	var descCgg_ger_indicador_encargado='El formulario permite administrar la informaci\u00f3n de la tabla Ger indicador encargado';
	var isEdit = false;
	var codigoCanton;
	var codigoUsuario;
	var codigoIndicador;
	function Cgg_indicador_encargado_data(){		
		/**
		* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_ger_indicador.
		*/
		this.columnModel = new Ext.grid.ColumnModel([
				{dataIndex:'CGGIN_NOMBRE',header:'Nombre',width:500,sortable:true},
				{dataIndex:'CGGIN_DESCRIPCION',header:'Descripcion',width:350,sortable:true,hidden:true}
		]);
		/**
		* Ext.data.Store Agrupacion de registros de la tabla Cgg_ger_indicador por un campo especifico.
		*/
		this.store = new Ext.data.Store({
				proxy:new Ext.ux.bsx.SoapProxy({
						url:URL_WS+"Cgg_ger_indicador",
						method:"selectPageDirect",
						pagin:true
				}),
				remoteSort:true,
				reader:new Ext.data.JsonReader({
						id:'CGGIN_CODIGO',
						root:'dataSet',
						totalProperty: 'totalCount'
				},[
					{name:'CGGIN_CODIGO'},
					{name:'CGGIT_CODIGO'},
					{name:'CGGIN_NOMBRE'},
					{name:'CGGIN_DESCRIPCION'}
				]),
				sortInfo:{field: 'CGGIT_CODIGO', direction: 'ASC'},
				baseParams:{keyword:"",format:'JSON'}
		});
	}
	
	
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCggie_codigo = new Ext.form.TextField({
			id:'txtCggie_codigo',
			name:'txtCggie_codigo',
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
			fieldLabel :'Cant\u00F3n',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
	*/
	var btnCctn_codigoCgg_ger_indicador_encargado = new Ext.Button({
			id:'btnCctn_codigoCgg_ger_indicador_encargado',
			//text:'Cctn_codigo',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_canton = new FrmListadoCgg_canton();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_canton.getStore(),tmpFLCgg_canton.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								codigoCanton = tmpRecord.get('CCTN_CODIGO');
								txtCctn_codigo.setValue(tmpRecord.get('CCTN_NOMBRE'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	var txtCusu_codigo = new Ext.form.TextField({
			id:'txtCusu_codigo',
			name:'txtCusu_codigo',
			fieldLabel :'Usuario',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
	*/
	var btnCusu_codigoCgg_ger_indicador_encargado = new Ext.Button({
			id:'btnCusu_codigoCgg_ger_indicador_encargado',
			//text:'Cusu_codigo',
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
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCggin_codigo = new Ext.form.TextField({
			id:'txtCggin_codigo',
			name:'txtCggin_codigo',
			fieldLabel :'Indicador',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var btnCggin_codigoCgg_ger_indicador_encargado = new Ext.Button({
			id:'btnCggin_codigoCgg_ger_indicador_encargado',
			//text:'Cggin_codigo',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_ger_indicador = new Cgg_indicador_encargado_data();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_ger_indicador.store,tmpFLCgg_ger_indicador.columnModel);
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								codigoIndicador = tmpRecord.get('CGGIN_CODIGO');
								txtCggin_codigo.setValue(tmpRecord.get('CGGIN_NOMBRE'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_ger_indicador_encargado
	*/
	var btnGuardarCgg_ger_indicador_encargado = new Ext.Button({
			id:'btnGuardarCgg_ger_indicador_encargado',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (!pnlCgg_ger_indicador_encargado.getForm().isValid()){
						return;
					}
					try{
						function CallBackCgg_ger_indicador_encargado(r){
							winFrmCgg_ger_indicador_encargado.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_ger_indicador_encargado,
										msg: 'La informaci\u00f3n de Ger indicador encargado ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_ger_indicador_encargado.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_ger_indicador_encargado,
										msg: 'La informaci\u00f3n de Ger indicador encargado no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_ger_indicador_encargado.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCggie_codigo',txtCggie_codigo.getValue());
						param.add('inCctn_codigo',codigoCanton);//txtCctn_codigo.getValue());
						param.add('inCusu_codigo',codigoUsuario);//txtCusu_codigo.getValue());
						param.add('inCggin_codigo',codigoIndicador);//txtCggin_codigo.getValue());
						SOAPClient.invoke(urlCgg_ger_indicador_encargado,IN_SENTENCIA_CGG_GER_INDICADOR_ENCARGADO,param, true, CallBackCgg_ger_indicador_encargado);
					}catch(inErr){
						winFrmCgg_ger_indicador_encargado.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_ger_indicador_encargado.
	*/
	var btnCancelarCgg_ger_indicador_encargado = new Ext.Button({
			id:'btnCancelarCgg_ger_indicador_encargado',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_ger_indicador_encargado.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_ger_indicador_encargado.
	*/
	var btnCerrarCgg_ger_indicador_encargado = new Ext.Button({
			id:'btnCerrarCgg_ger_indicador_encargado',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_ger_indicador_encargado.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_ger_indicador_encargado.
	*/
	var pnlCgg_ger_indicador_encargado = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[
				txtCggie_codigo,
				{
					xtype:'panel',
					layout:'column',
					items:[{
						columnWidth:.87,
						layout:'form',
						items:[txtCggin_codigo]
						},{
						columnWidth:.13,
						layout:'form',
						items:[btnCggin_codigoCgg_ger_indicador_encargado]
						}
					]
				},
				{
					xtype:'panel',
					layout:'column',
					items:[{
						columnWidth:.87,
						layout:'form',
						items:[txtCctn_codigo]
						},
						{columnWidth:.13,
						layout:'form',
						items:[btnCctn_codigoCgg_ger_indicador_encargado]}
					]
				},
				{
					xtype:'panel',
					layout:'column',
					items:[{
						columnWidth:.87,
						layout:'form',
						items:[txtCusu_codigo]
						},{
							columnWidth:.13,
							layout:'form',
							items:[btnCusu_codigoCgg_ger_indicador_encargado]
					}]
				}
				
			]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_ger_indicador_encargado.
	*/
	var winFrmCgg_ger_indicador_encargado = new Ext.Window({
			id:'winFrmCgg_ger_indicador_encargado',
			title:tituloCgg_ger_indicador_encargado,
			iconCls:'iconAplicacion',
			width:400,
			minWidth:400,
			maximizable:false,
			minimizable:false,
			constrain:true,
			modal : true,
			tbar:getPanelTitulo(tituloCgg_ger_indicador_encargado,descCgg_ger_indicador_encargado),
			items:[pnlCgg_ger_indicador_encargado],
			bbar:[btnGuardarCgg_ger_indicador_encargado,btnCancelarCgg_ger_indicador_encargado,'->',btnCerrarCgg_ger_indicador_encargado]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_ger_indicador_encargado.getBottomToolbar());
	/**
	* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_ger_indicador_encargado.
	* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	*/
	function habilitarCgg_ger_indicador_encargadoCtrls(inEstado){
		estado=!inEstado;
		txtCggie_codigo.setDisabled(estado);
		txtCctn_codigo.setDisabled(estado);
		txtCusu_codigo.setDisabled(estado);
		txtCggin_codigo.setDisabled(estado);
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_ger_indicador_encargado.
	*/
	function cargarCgg_ger_indicador_encargadoCtrls(){
		if(inRecordCgg_ger_indicador_encargado){
			txtCggie_codigo.setValue(inRecordCgg_ger_indicador_encargado.get('CGGIE_CODIGO'));
			codigoCanton = inRecordCgg_ger_indicador_encargado.get('CCTN_CODIGO');
			txtCctn_codigo.setValue(inRecordCgg_ger_indicador_encargado.get('CCTN_NOMBRE'));
	
			
			codigoUsuario = inRecordCgg_ger_indicador_encargado.get('CUSU_CODIGO');
			txtCusu_codigo.setValue(inRecordCgg_ger_indicador_encargado.get('CUSU_NOMBRE_USUARIO'));
	
			
			codigoIndicador = inRecordCgg_ger_indicador_encargado.get('CGGIN_CODIGO');
			txtCggin_codigo.setValue( inRecordCgg_ger_indicador_encargado.get('CGGIN_NOMBRE'));
		
			isEdit = true;
			habilitarCgg_ger_indicador_encargadoCtrls(true);
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_ger_indicador_encargado.
	* @returns ventana winFrmCgg_ger_indicador_encargado.
	* @base FrmCgg_ger_indicador_encargado.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_ger_indicador_encargado;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_ger_indicador_encargado.
	* @base FrmCgg_ger_indicador_encargado.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_ger_indicador_encargadoCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_ger_indicador_encargado desde una instancia.
*/
FrmCgg_ger_indicador_encargado.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_ger_indicador_encargado desde una instancia.
*/
FrmCgg_ger_indicador_encargado.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_ger_indicador_encargado,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_ger_indicador_encargado.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_ger_indicador_encargado desde una instancia.
*/
FrmCgg_ger_indicador_encargado.prototype.loadData = function(){
	this.loadData();
}
