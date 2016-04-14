/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_veh_combustible.
* @param {String} IN_SENTENCIA_CGG_VEH_COMBUSTIBLE Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_VEH_COMBUSTIBLE Registro de datos de la tabla Cgg_veh_combustible.
* @constructor
* @base FrmListadoCgg_veh_combustible
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_veh_combustible(IN_SENTENCIA_CGG_VEH_COMBUSTIBLE,IN_RECORD_CGG_VEH_COMBUSTIBLE){
	var inSentenciaCgg_veh_combustible = IN_SENTENCIA_CGG_VEH_COMBUSTIBLE;
	var inRecordCgg_veh_combustible=IN_RECORD_CGG_VEH_COMBUSTIBLE;
	var urlCgg_veh_combustible=URL_WS+"Cgg_veh_combustible";
	var tituloCgg_veh_combustible='Combustible';
	var descCgg_veh_combustible='El formulario permite administrar la informaci\u00f3n de los combustibles.';
	var isEdit = false;
	/**
	* Ext.form.TextField IDENTIFICADOR UNICO DE REGISTRO DE COMBUSTIBLE
	*/
	var txtCvcmb_codigo = new Ext.form.TextField({
			id:'txtCvcmb_codigo',
			name:'txtCvcmb_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
	});
	/**
	* Ext.form.TextField IDENTIFICADOR DESCRIPTIVO DEL COMBUSTIBLE.
	*/
	var txtCvcmb_nombre = new Ext.form.TextField({
			id:'txtCvcmb_nombre',
			name:'txtCvcmb_nombre',
			fieldLabel :'Nombre',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* Ext.form.TextArea INFORMACION ADICIONAL
	*/
	var txtCvcmb_observacion = new Ext.form.TextArea({
			id:'txtCvcmb_observacion',
			name:'txtCvcmb_observacion',
			fieldLabel :'Observaci\u00f3n',
			width:'98%'
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_veh_combustible
	*/
	var btnGuardarCgg_veh_combustible = new Ext.Button({
			id:'btnGuardarCgg_veh_combustible',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (pnlCgg_veh_combustible.getForm().isValid()==false){
						return;
					}
					try{
						function CallBackCgg_veh_combustible(r){
							winFrmCgg_veh_combustible.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_veh_combustible,
										msg: 'La informaci\u00f3n de Combustible ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_veh_combustible.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_veh_combustible,
										msg: 'La informaci\u00f3n de Combustible no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_veh_combustible.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCvcmb_codigo',txtCvcmb_codigo.getValue());
						param.add('inCvcmb_nombre',txtCvcmb_nombre.getValue());
						param.add('inCvcmb_observacion',txtCvcmb_observacion.getValue());
						SOAPClient.invoke(urlCgg_veh_combustible,IN_SENTENCIA_CGG_VEH_COMBUSTIBLE,param, true, CallBackCgg_veh_combustible);
					}catch(inErr){
						winFrmCgg_veh_combustible.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_veh_combustible.
	*/
	var btnCancelarCgg_veh_combustible = new Ext.Button({
			id:'btnCancelarCgg_veh_combustible',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_veh_combustible.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_veh_combustible.
	*/
	var btnCerrarCgg_veh_combustible = new Ext.Button({
			id:'btnCerrarCgg_veh_combustible',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_veh_combustible.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_veh_combustible.
	*/
	var pnlCgg_veh_combustible = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCvcmb_codigo,txtCvcmb_nombre,txtCvcmb_observacion]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_veh_combustible.
	*/
	var winFrmCgg_veh_combustible = new Ext.Window({
			id:'winFrmCgg_veh_combustible',
			title:tituloCgg_veh_combustible,
			width:400,
			minWidth:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			tbar:getPanelTitulo(tituloCgg_veh_combustible,descCgg_veh_combustible),
			items:[pnlCgg_veh_combustible],
			bbar:[btnGuardarCgg_veh_combustible,btnCancelarCgg_veh_combustible,'->',btnCerrarCgg_veh_combustible]
	});
	/**
	* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_veh_combustible.
	* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	*/
	function habilitarCgg_veh_combustibleCtrls(inEstado){
		estado=!inEstado;
		txtCvcmb_codigo.setDisabled(estado);
		txtCvcmb_nombre.setDisabled(estado);
		txtCvcmb_observacion.setDisabled(estado);
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_veh_combustible.
	*/
	function cargarCgg_veh_combustibleCtrls(){
		if(inRecordCgg_veh_combustible){
			txtCvcmb_codigo.setValue(inRecordCgg_veh_combustible.get('CVCMB_CODIGO'));
			txtCvcmb_nombre.setValue(inRecordCgg_veh_combustible.get('CVCMB_NOMBRE'));
			txtCvcmb_observacion.setValue(inRecordCgg_veh_combustible.get('CVCMB_OBSERVACION'));
			isEdit = true;
			habilitarCgg_veh_combustibleCtrls(true);
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_veh_combustible.
	* @returns ventana winFrmCgg_veh_combustible.
	* @base FrmCgg_veh_combustible.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_veh_combustible;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_veh_combustible.
	* @base FrmCgg_veh_combustible.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_veh_combustibleCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_veh_combustible desde una instancia.
*/
FrmCgg_veh_combustible.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_veh_combustible desde una instancia.
*/
FrmCgg_veh_combustible.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_veh_combustible,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_veh_combustible.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_veh_combustible desde una instancia.
*/
FrmCgg_veh_combustible.prototype.loadData = function(){
	this.loadData();
}