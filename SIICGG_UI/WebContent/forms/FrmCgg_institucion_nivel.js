/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_institucion_nivel.
* @param {String} IN_SENTENCIA_CGG_INSTITUCION_NIVEL Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_INSTITUCION_NIVEL Registro de datos de la tabla Cgg_institucion_nivel.
* @constructor
* @base FrmListadoCgg_institucion_nivel
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_institucion_nivel(IN_SENTENCIA_CGG_INSTITUCION_NIVEL,IN_RECORD_CGG_INSTITUCION_NIVEL){	
	var inSentenciaCgg_institucion_nivel = IN_SENTENCIA_CGG_INSTITUCION_NIVEL;
	var inRecordCgg_institucion_nivel=IN_RECORD_CGG_INSTITUCION_NIVEL;
	var urlCgg_institucion_nivel=URL_WS+"Cgg_institucion_nivel";
	var tituloCgg_institucion_nivel='Institucion nivel';
	var descCgg_institucion_nivel='El formulario permite administrar la informaci\u00f3n de la tabla Institucion nivel';
	var isEdit = false;
	/**
	* Ext.form.TextField NO ESPECIFICADO
	*/
	var txtCgien_codigo = new Ext.form.TextField({
			id:'txtCgien_codigo',
			name:'txtCgien_codigo',
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
	var txtCgnes_codigo = new Ext.form.TextField({
			id:'txtCgnes_codigo',
			name:'txtCgnes_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var btnCgnes_codigoCgg_institucion_nivel = new Ext.Button({
			id:'btnCgnes_codigoCgg_institucion_nivel',
			text:'Cgnes_codigo',
			iconCls:'iconCgnes_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_nivel_estudio = new FrmListadoCgg_nivel_estudio();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_nivel_estudio.getStore(),tmpFLCgg_nivel_estudio.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCgnes_codigo.setValue(tmpRecord.get('CGNES_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	*/
	var txtCgied_codigo = new Ext.form.TextField({
			id:'txtCgied_codigo',
			name:'txtCgied_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE INSTITUCION EDUCATIVA
	*/
	var btnCgied_codigoCgg_institucion_nivel = new Ext.Button({
			id:'btnCgied_codigoCgg_institucion_nivel',
			text:'Cgied_codigo',
			iconCls:'iconCgied_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_institucion_educativa = new FrmListadoCgg_institucion_educativa();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_institucion_educativa.getStore(),tmpFLCgg_institucion_educativa.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCgied_codigo.setValue(tmpRecord.get('CGIED_CODIGO'));
					});
					objBusqueda.show();
			}}
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_institucion_nivel
	*/
	var btnGuardarCgg_institucion_nivel = new Ext.Button({
			id:'btnGuardarCgg_institucion_nivel',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (!pnlCgg_institucion_nivel.getForm().isValid()){
						return;
					}
					try{
						function CallBackCgg_institucion_nivel(r){
							winFrmCgg_institucion_nivel.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_institucion_nivel,
										msg: 'La informaci\u00f3n de Institucion nivel ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_institucion_nivel.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_institucion_nivel,
										msg: 'La informaci\u00f3n de Institucion nivel no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_institucion_nivel.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCgien_codigo',txtCgien_codigo.getValue());
						param.add('inCgnes_codigo',txtCgnes_codigo.getValue());
						param.add('inCgied_codigo',txtCgied_codigo.getValue());
						SOAPClient.invoke(urlCgg_institucion_nivel,IN_SENTENCIA_CGG_INSTITUCION_NIVEL,param, true, CallBackCgg_institucion_nivel);
					}catch(inErr){
						winFrmCgg_institucion_nivel.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_institucion_nivel.
	*/
	var btnCancelarCgg_institucion_nivel = new Ext.Button({
			id:'btnCancelarCgg_institucion_nivel',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_institucion_nivel.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_institucion_nivel.
	*/
	var btnCerrarCgg_institucion_nivel = new Ext.Button({
			id:'btnCerrarCgg_institucion_nivel',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_institucion_nivel.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_institucion_nivel.
	*/
	var pnlCgg_institucion_nivel = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCgien_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCgnes_codigo]},{columnWidth:.4,layout:'form',items:[btnCgnes_codigoCgg_institucion_nivel]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCgied_codigo]},{columnWidth:.4,layout:'form',items:[btnCgied_codigoCgg_institucion_nivel]}]}]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_institucion_nivel.
	*/
	var winFrmCgg_institucion_nivel = new Ext.Window({
			id:'winFrmCgg_institucion_nivel',
			title:tituloCgg_institucion_nivel,
			iconCls:'iconAplicacion',
			width:400,
			minWidth:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			tbar:getPanelTitulo(tituloCgg_institucion_nivel,descCgg_institucion_nivel),
			items:[pnlCgg_institucion_nivel],
			bbar:[btnGuardarCgg_institucion_nivel,btnCancelarCgg_institucion_nivel,'->',btnCerrarCgg_institucion_nivel]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_institucion_nivel.getBottomToolbar());
	/**
	* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_institucion_nivel.
	* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	*/
	function habilitarCgg_institucion_nivelCtrls(inEstado){
		estado=!inEstado;
		txtCgien_codigo.setDisabled(estado);
		txtCgnes_codigo.setDisabled(estado);
		txtCgied_codigo.setDisabled(estado);
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_institucion_nivel.
	*/
	function cargarCgg_institucion_nivelCtrls(){
		if(inRecordCgg_institucion_nivel){
			txtCgien_codigo.setValue(inRecordCgg_institucion_nivel.get('CGIEN_CODIGO'));
			txtCgnes_codigo.setValue(inRecordCgg_institucion_nivel.get('CGNES_CODIGO'));
			txtCgied_codigo.setValue(inRecordCgg_institucion_nivel.get('CGIED_CODIGO'));
			isEdit = true;
			habilitarCgg_institucion_nivelCtrls(true);
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_institucion_nivel.
	* @returns ventana winFrmCgg_institucion_nivel.
	* @base FrmCgg_institucion_nivel.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_institucion_nivel;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_institucion_nivel.
	* @base FrmCgg_institucion_nivel.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_institucion_nivelCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_institucion_nivel desde una instancia.
*/
FrmCgg_institucion_nivel.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_institucion_nivel desde una instancia.
*/
FrmCgg_institucion_nivel.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_institucion_nivel,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_institucion_nivel.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_institucion_nivel desde una instancia.
*/
FrmCgg_institucion_nivel.prototype.loadData = function(){
	this.loadData();
}
