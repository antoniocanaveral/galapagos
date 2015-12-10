/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_titulo_profesional.
* @param {String} IN_SENTENCIA_CGG_TITULO_PROFESIONAL Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_TITULO_PROFESIONAL Registro de datos de la tabla Cgg_titulo_profesional.
* @constructor
* @base FrmListadoCgg_titulo_profesional
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_titulo_profesional(IN_SENTENCIA_CGG_TITULO_PROFESIONAL,IN_RECORD_CGG_TITULO_PROFESIONAL){
	var inSentenciaCgg_titulo_profesional = IN_SENTENCIA_CGG_TITULO_PROFESIONAL;
	var inRecordCgg_titulo_profesional=IN_RECORD_CGG_TITULO_PROFESIONAL;
	var urlCgg_titulo_profesional=URL_WS+"Cgg_titulo_profesional";
	var tituloCgg_titulo_profesional='Titulo profesional';
	var descCgg_titulo_profesional='El formulario permite administrar la informaci\u00f3n de la tabla Titulo profesional';
	var isEdit = false;
	var codigoNivelEstudio="";
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TITULO PROFESIONAL
	*/
	var txtCgtpr_codigo = new Ext.form.TextField({
			id:'txtCgtpr_codigo',
			name:'txtCgtpr_codigo',
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
			fieldLabel :'Nivel de Estudio',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var btnCgnes_codigoCgg_titulo_profesional = new Ext.Button({
			id:'btnCgnes_codigoCgg_titulo_profesional',
			//text:'Cgnes_codigo',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_nivel_estudio = new FrmListadoCgg_nivel_estudio();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_nivel_estudio.getStore(),tmpFLCgg_nivel_estudio.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){							
								codigoNivelEstudio = tmpRecord.get('CGNES_CODIGO');
								txtCgnes_codigo.setValue(tmpRecord.get('CGNES_DESCRIPCION'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField DESCRIPCION DEL TITULO PROFESIONAL
	*/
	var txtCgtpr_descripcion = new Ext.form.TextField({
			id:'txtCgtpr_descripcion',
			name:'txtCgtpr_descripcion',
			fieldLabel :'Descripcion',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_titulo_profesional
	*/
	var btnGuardarCgg_titulo_profesional = new Ext.Button({
			id:'btnGuardarCgg_titulo_profesional',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (!pnlCgg_titulo_profesional.getForm().isValid()){
						return;
					}
					try{
						function CallBackCgg_titulo_profesional(r){
							winFrmCgg_titulo_profesional.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_titulo_profesional,
										msg: 'La informaci\u00f3n de Titulo profesional ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_titulo_profesional.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_titulo_profesional,
										msg: 'La informaci\u00f3n de Titulo profesional no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_titulo_profesional.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCgtpr_codigo',txtCgtpr_codigo.getValue());
						//param.add('inCgnes_codigo',txtCgnes_codigo.getValue());
						param.add('inCgnes_codigo',codigoNivelEstudio);
						param.add('inCgtpr_descripcion',txtCgtpr_descripcion.getValue());
						SOAPClient.invoke(urlCgg_titulo_profesional,IN_SENTENCIA_CGG_TITULO_PROFESIONAL,param, true, CallBackCgg_titulo_profesional);
					}catch(inErr){
						winFrmCgg_titulo_profesional.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_titulo_profesional.
	*/
	var btnCancelarCgg_titulo_profesional = new Ext.Button({
			id:'btnCancelarCgg_titulo_profesional',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_titulo_profesional.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_titulo_profesional.
	*/
	var btnCerrarCgg_titulo_profesional = new Ext.Button({
			id:'btnCerrarCgg_titulo_profesional',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_titulo_profesional.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_titulo_profesional.
	*/
	var pnlCgg_titulo_profesional = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCgtpr_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCgnes_codigo]},{columnWidth:.4,layout:'form',items:[btnCgnes_codigoCgg_titulo_profesional]}]},txtCgtpr_descripcion]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_titulo_profesional.
	*/
	var winFrmCgg_titulo_profesional = new Ext.Window({
			id:'winFrmCgg_titulo_profesional',
			title:tituloCgg_titulo_profesional,
			iconCls:'iconAplicacion',
			width:400,
			minWidth:400,
			maximizable:false,
			minimizable:false,
			modal:true,
			constrain:true,
			tbar:getPanelTitulo(tituloCgg_titulo_profesional,descCgg_titulo_profesional),
			items:[pnlCgg_titulo_profesional],
			bbar:[btnGuardarCgg_titulo_profesional,btnCancelarCgg_titulo_profesional,'->',btnCerrarCgg_titulo_profesional]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_titulo_profesional.getBottomToolbar());
	/**
	* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_titulo_profesional.
	* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	*/
	function habilitarCgg_titulo_profesionalCtrls(inEstado){
		estado=!inEstado;
		txtCgtpr_codigo.setDisabled(estado);
		txtCgnes_codigo.setDisabled(estado);
		txtCgtpr_descripcion.setDisabled(estado);
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_titulo_profesional.
	*/
	function cargarCgg_titulo_profesionalCtrls(){
		if(inRecordCgg_titulo_profesional){
			txtCgtpr_codigo.setValue(inRecordCgg_titulo_profesional.get('CGTPR_CODIGO'));
			codigoNivelEstudio = inRecordCgg_titulo_profesional.get('CGNES_CODIGO');			
			txtCgnes_codigo.setValue(inRecordCgg_titulo_profesional.get('CGNES_DESCRIPCION'));
			txtCgtpr_descripcion.setValue(inRecordCgg_titulo_profesional.get('CGTPR_DESCRIPCION'));
			isEdit = true;
			habilitarCgg_titulo_profesionalCtrls(true);
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_titulo_profesional.
	* @returns ventana winFrmCgg_titulo_profesional.
	* @base FrmCgg_titulo_profesional.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_titulo_profesional;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_titulo_profesional.
	* @base FrmCgg_titulo_profesional.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_titulo_profesionalCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_titulo_profesional desde una instancia.
*/
FrmCgg_titulo_profesional.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_titulo_profesional desde una instancia.
*/
FrmCgg_titulo_profesional.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_titulo_profesional,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_titulo_profesional.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_titulo_profesional desde una instancia.
*/
FrmCgg_titulo_profesional.prototype.loadData = function(){
	this.loadData();
}
