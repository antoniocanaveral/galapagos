/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_veh_estado_vhmt.
* @param {String} IN_SENTENCIA_CGG_VEH_ESTADO_VHMT Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_VEH_ESTADO_VHMT Registro de datos de la tabla Cgg_veh_estado_vhmt.
* @constructor
* @base FrmListadoCgg_veh_estado_vhmt
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_veh_estado_vhmt(IN_SENTENCIA_CGG_VEH_ESTADO_VHMT,IN_RECORD_CGG_VEH_ESTADO_VHMT){
	var inSentenciaCgg_veh_estado_vhmt = IN_SENTENCIA_CGG_VEH_ESTADO_VHMT;
	var inRecordCgg_veh_estado_vhmt=IN_RECORD_CGG_VEH_ESTADO_VHMT;
	var urlCgg_veh_estado_vhmt=URL_WS+"Cgg_veh_estado_vhmt";
	var tituloCgg_veh_estado_vhmt='Estado';
	var descCgg_veh_estado_vhmt='El formulario permite administrar la informaci\u00f3n de un Estado.';
	var isEdit = false;
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO ESTADO VEHICULO MOTOR
	*/
	var txtCvsvm_codigo = new Ext.form.TextField({
			id:'txtCvsvm_codigo',
			name:'txtCvsvm_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
	});
	/**
	* Ext.form.TextField NOMBRE IDENTIFICATIVO DEL ESTADO DE UN MOTOR.
	*/
	var txtCvsvm_nombre = new Ext.form.TextField({
			id:'txtCvsvm_nombre',
			name:'txtCvsvm_nombre',
			fieldLabel :'Nombre',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* Ext.form.TextArea INFORMACION ADICIONAL
	*/
	var txtCvsvm_obervacion = new Ext.form.TextArea({
			id:'txtCvsvm_obervacion',
			name:'txtCvsvm_obervacion',
			fieldLabel :'Obervaci\u00f3n',
			width:'98%',
			allowBlank :false
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_veh_estado_vhmt
	*/
	var btnGuardarCgg_veh_estado_vhmt = new Ext.Button({
			id:'btnGuardarCgg_veh_estado_vhmt',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (!pnlCgg_veh_estado_vhmt.getForm().isValid()){
						return;
					}
					try{
						function CallBackCgg_veh_estado_vhmt(r){
							winFrmCgg_veh_estado_vhmt.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_veh_estado_vhmt,
										msg: 'La informaci\u00f3n de Estado ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_veh_estado_vhmt.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_veh_estado_vhmt,
										msg: 'La informaci\u00f3n de Estado no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_veh_estado_vhmt.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCvsvm_codigo',txtCvsvm_codigo.getValue());
						param.add('inCvsvm_nombre',txtCvsvm_nombre.getValue());
						param.add('inCvsvm_obervacion',txtCvsvm_obervacion.getValue());
						SOAPClient.invoke(urlCgg_veh_estado_vhmt,IN_SENTENCIA_CGG_VEH_ESTADO_VHMT,param, true, CallBackCgg_veh_estado_vhmt);
					}catch(inErr){
						winFrmCgg_veh_estado_vhmt.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_veh_estado_vhmt.
	*/
	var btnCancelarCgg_veh_estado_vhmt = new Ext.Button({
			id:'btnCancelarCgg_veh_estado_vhmt',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_veh_estado_vhmt.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_veh_estado_vhmt.
	*/
	var btnCerrarCgg_veh_estado_vhmt = new Ext.Button({
			id:'btnCerrarCgg_veh_estado_vhmt',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_veh_estado_vhmt.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_veh_estado_vhmt.
	*/
	var pnlCgg_veh_estado_vhmt = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCvsvm_codigo,txtCvsvm_nombre,txtCvsvm_obervacion]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_veh_estado_vhmt.
	*/
	var winFrmCgg_veh_estado_vhmt = new Ext.Window({
			id:'winFrmCgg_veh_estado_vhmt',
			title:tituloCgg_veh_estado_vhmt,
			iconCls:'iconAplicacion',
			width:400,
			minWidth:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			tbar:getPanelTitulo(tituloCgg_veh_estado_vhmt,descCgg_veh_estado_vhmt),
			items:[pnlCgg_veh_estado_vhmt],
			bbar:[btnGuardarCgg_veh_estado_vhmt,btnCancelarCgg_veh_estado_vhmt,'->',btnCerrarCgg_veh_estado_vhmt]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_veh_estado_vhmt.getBottomToolbar());
	/**
	* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_veh_estado_vhmt.
	* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	*/
	function habilitarCgg_veh_estado_vhmtCtrls(inEstado){
		estado=!inEstado;
		txtCvsvm_codigo.setDisabled(estado);
		txtCvsvm_nombre.setDisabled(estado);
		txtCvsvm_obervacion.setDisabled(estado);
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_veh_estado_vhmt.
	*/
	function cargarCgg_veh_estado_vhmtCtrls(){
		if(inRecordCgg_veh_estado_vhmt){
			txtCvsvm_codigo.setValue(inRecordCgg_veh_estado_vhmt.get('CVSVM_CODIGO'));
			txtCvsvm_nombre.setValue(inRecordCgg_veh_estado_vhmt.get('CVSVM_NOMBRE'));
			txtCvsvm_obervacion.setValue(inRecordCgg_veh_estado_vhmt.get('CVSVM_OBERVACION'));
			isEdit = true;
			habilitarCgg_veh_estado_vhmtCtrls(true);
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_veh_estado_vhmt.
	* @returns ventana winFrmCgg_veh_estado_vhmt.
	* @base FrmCgg_veh_estado_vhmt.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_veh_estado_vhmt;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_veh_estado_vhmt.
	* @base FrmCgg_veh_estado_vhmt.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_veh_estado_vhmtCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_veh_estado_vhmt desde una instancia.
*/
FrmCgg_veh_estado_vhmt.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_veh_estado_vhmt desde una instancia.
*/
FrmCgg_veh_estado_vhmt.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_veh_estado_vhmt,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_veh_estado_vhmt.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_veh_estado_vhmt desde una instancia.
*/
FrmCgg_veh_estado_vhmt.prototype.loadData = function(){
	this.loadData();
}
