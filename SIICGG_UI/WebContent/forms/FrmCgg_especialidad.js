/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_especialidad.
* @param {String} IN_SENTENCIA_CGG_ESPECIALIDAD Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_ESPECIALIDAD Registro de datos de la tabla Cgg_especialidad.
* @constructor
* @base FrmListadoCgg_especialidad
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_especialidad(IN_SENTENCIA_CGG_ESPECIALIDAD,IN_RECORD_CGG_ESPECIALIDAD){
	var inSentenciaCgg_especialidad = IN_SENTENCIA_CGG_ESPECIALIDAD;
	var inRecordCgg_especialidad=IN_RECORD_CGG_ESPECIALIDAD;
	var urlCgg_especialidad=URL_WS+"Cgg_especialidad";
	var tituloCgg_especialidad='Especialidad';
	var descCgg_especialidad='El formulario permite administrar la informaci\u00f3n de la tabla Especialidad';
	var isEdit = false;
	var codigoNivelEstudio="";
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIALIDAD
	*/
	var txtCgesp_codigo = new Ext.form.TextField({
			id:'txtCgesp_codigo',
			name:'txtCgesp_codigo',
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
	var btnCgnes_codigoCgg_especialidad = new Ext.Button({
			id:'btnCgnes_codigoCgg_especialidad',
			//text:'Cgnes_codigo',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_nivel_estudio = new FrmListadoCgg_nivel_estudio();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_nivel_estudio.getStore(),tmpFLCgg_nivel_estudio.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
							{
								codigoNivelEstudio = tmpRecord.get('CGNES_CODIGO')
								txtCgnes_codigo.setValue(tmpRecord.get('CGNES_DESCRIPCION'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField NO ESPECIFICADO
	*/
	var txtCgesp_nombre = new Ext.form.TextField({
			id:'txtCgesp_nombre',
			name:'txtCgesp_nombre',
			fieldLabel :'Nombre',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* Ext.form.TextArea DESCRIPCION DE LA ESPECIALIDAD O PROFESION
	*/
	var txtCgesp_descripcion = new Ext.form.TextArea({
			id:'txtCgesp_descripcion',
			name:'txtCgesp_descripcion',
			fieldLabel :'Descripcion',
			width:'90%',
			allowBlank :false
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_especialidad
	*/
	var btnGuardarCgg_especialidad = new Ext.Button({
			id:'btnGuardarCgg_especialidad',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (!pnlCgg_especialidad.getForm().isValid()){
						return;
					}
					try{
						function CallBackCgg_especialidad(r){
							winFrmCgg_especialidad.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_especialidad,
										msg: 'La informaci\u00f3n de Especialidad ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_especialidad.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_especialidad,
										msg: 'La informaci\u00f3n de Especialidad no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_especialidad.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCgesp_codigo',txtCgesp_codigo.getValue());
						//param.add('inCgnes_codigo',txtCgnes_codigo.getValue());
						param.add('inCgnes_codigo',codigoNivelEstudio);
						param.add('inCgesp_nombre',txtCgesp_nombre.getValue());
						param.add('inCgesp_descripcion',txtCgesp_descripcion.getValue());
						SOAPClient.invoke(urlCgg_especialidad,IN_SENTENCIA_CGG_ESPECIALIDAD,param, true, CallBackCgg_especialidad);
					}catch(inErr){
						winFrmCgg_especialidad.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_especialidad.
	*/
	var btnCancelarCgg_especialidad = new Ext.Button({
			id:'btnCancelarCgg_especialidad',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_especialidad.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_especialidad.
	*/
	var btnCerrarCgg_especialidad = new Ext.Button({
			id:'btnCerrarCgg_especialidad',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_especialidad.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_especialidad.
	*/
	var pnlCgg_especialidad = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCgesp_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCgnes_codigo]},{columnWidth:.4,layout:'form',items:[btnCgnes_codigoCgg_especialidad]}]},txtCgesp_nombre,txtCgesp_descripcion]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_especialidad.
	*/
	var winFrmCgg_especialidad = new Ext.Window({
			id:'winFrmCgg_especialidad',
			title:tituloCgg_especialidad,
			iconCls:'iconAplicacion',
			width:400,
			minWidth:400,
			maximizable:false,
			minimizable:false,
			modal: true,
			constrain:true,
			tbar:getPanelTitulo(tituloCgg_especialidad,descCgg_especialidad),
			items:[pnlCgg_especialidad],
			bbar:[btnGuardarCgg_especialidad,btnCancelarCgg_especialidad,'->',btnCerrarCgg_especialidad]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_especialidad.getBottomToolbar());
	/**
	* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_especialidad.
	* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	*/
	function habilitarCgg_especialidadCtrls(inEstado){
		estado=!inEstado;
		txtCgesp_codigo.setDisabled(estado);
		txtCgnes_codigo.setDisabled(estado);
		txtCgesp_nombre.setDisabled(estado);
		txtCgesp_descripcion.setDisabled(estado);
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_especialidad.
	*/
	function cargarCgg_especialidadCtrls(){
		if(inRecordCgg_especialidad){
			txtCgesp_codigo.setValue(inRecordCgg_especialidad.get('CGESP_CODIGO'));
			codigoNivelEstudio = inRecordCgg_especialidad.get('CGNES_CODIGO');
			//alert(inRecordCgg_especialidad.get('CGNES_CODIGO'));
			txtCgnes_codigo.setValue(inRecordCgg_especialidad.get('CGNES_DESCRIPCION'));
			txtCgesp_nombre.setValue(inRecordCgg_especialidad.get('CGESP_NOMBRE'));
			txtCgesp_descripcion.setValue(inRecordCgg_especialidad.get('CGESP_DESCRIPCION'));
			isEdit = true;
			habilitarCgg_especialidadCtrls(true);
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_especialidad.
	* @returns ventana winFrmCgg_especialidad.
	* @base FrmCgg_especialidad.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_especialidad;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_especialidad.
	* @base FrmCgg_especialidad.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_especialidadCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_especialidad desde una instancia.
*/
FrmCgg_especialidad.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_especialidad desde una instancia.
*/
FrmCgg_especialidad.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_especialidad,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_especialidad.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_especialidad desde una instancia.
*/
FrmCgg_especialidad.prototype.loadData = function(){
	this.loadData();
}
