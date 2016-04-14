/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_requisito.
 * @param {String} INSENTENCIA_CGG_RES_REQUISITO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_REQUISITO Registro de datos de la tabla Cgg_res_requisito.
 * @constructor
 * @base FrmListadoCgg_res_requisito
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_requisito(INSENTENCIA_CGG_RES_REQUISITO,INRECORD_CGG_RES_REQUISITO){
	var inSentenciaCgg_res_requisito = INSENTENCIA_CGG_RES_REQUISITO;
	var inRecordCgg_res_requisito=INRECORD_CGG_RES_REQUISITO;
	var urlCgg_res_requisito=URL_WS+"Cgg_res_requisito";
	var tituloCgg_res_requisito='Requisito tr\u00E1mite residencia';
	var descCgg_res_requisito='El formulario permite ingresar un nuevo requesito para el tr\u00E1mite de residencia';
	var isEdit = false;
	/**
	 * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE REQUISITO
	 */
	var txtCrreq_codigo = new Ext.form.TextField({
		id:'txtCrreq_codigo',
		name:'txtCrreq_codigo',
		fieldLabel :'Codigo',
		anchor:'98%',
		allowBlank :false,
		value:"KEYGEN",
		hidden:true,
		hideLabel:true,
		maxLength :20
	});
	/**
	 * Ext.form.TextField DESCRIPCION DEL REQUISITO
	 */
	var txtCrreq_descripcion = new Ext.form.TextField({
		id:'txtCrreq_descripcion',
		name:'txtCrreq_descripcion',
		fieldLabel :'Descripci\u00F3n',
		anchor:'98%',
		allowBlank :false,
		maxLength :100
	});
	/**
	 * Ext.form.TextArea NO ESPECIFICADO
	 */
	var txtCrreq_observacion = new Ext.form.TextArea({
		id:'txtCrreq_observacion',
		name:'txtCrreq_observacion',
		fieldLabel :'Observaci\u00F3n',
		width:'97%',
		allowBlank :true
	});
	/**
	 * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_requisito
	 */
	var btnGuardarCgg_res_requisito = new Ext.Button({
		id:'btnGuardarCgg_res_requisito',
		text:'Guardar',
		iconCls:'iconGuardar',
		listeners:{
		click:function(){
		if (pnlCgg_res_requisito.getForm().isValid()==false){
			return;
		}
		try{
			function CallBackCgg_res_requisito(r){
				winFrmCgg_res_requisito.getEl().unmask();
				if(r=='true'){
					Ext.Msg.show({
						title:tituloCgg_res_requisito,
						msg: 'La informaci\u00F3n del requisito de residencia ha sido almacenada.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});winFrmCgg_res_requisito.close()
				}else{
					Ext.Msg.show({
						title:tituloCgg_res_requisito,
						msg: 'La informaci\u00F3n del requisito de residencia no ha podido ser almacenada.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
				}
			}
			winFrmCgg_res_requisito.getEl().mask('Guardando...', 'x-mask-loading');
			var param = new SOAPClientParameters();
			if(isEdit)
			param.add('inCrreq_codigo',txtCrreq_codigo.getValue());
			param.add('inCrreq_descripcion',txtCrreq_descripcion.getValue());
			param.add('inCrreq_observacion',txtCrreq_observacion.getValue());
			SOAPClient.invoke(urlCgg_res_requisito,INSENTENCIA_CGG_RES_REQUISITO,param, true, CallBackCgg_res_requisito);
		}catch(inErr){
			winFrmCgg_res_requisito.getEl().unmask();
		}
	}}
	});
	/**
	 * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_requisito.
	 */
	var btnCancelarCgg_res_requisito = new Ext.Button({
		id:'btnCancelarCgg_res_requisito',
		text:'Cancelar',
		iconCls:'iconCancelar',
		listeners:{
		click:function(){
		pnlCgg_res_requisito.getForm().reset();
	}}
	});
	/**
	 * Boton que permite cerrar la ventana winFrmCgg_res_requisito.
	 */
	var btnCerrarCgg_res_requisito = new Ext.Button({
		id:'btnCerrarCgg_res_requisito',
		text:'Cerrar',
		iconCls:'iconCerrar',
		listeners:{
		click:function(){
		winFrmCgg_res_requisito.close();
	}}
	});
	/**
	 * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_requisito.
	 */
	var pnlCgg_res_requisito = new Ext.form.FormPanel({
		frame:true,
		labelWidth :100,
		items:[txtCrreq_codigo,txtCrreq_descripcion,txtCrreq_observacion]
	});
	/**
	 * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_requisito.
	 */
	var winFrmCgg_res_requisito = new Ext.Window({
		id:'winFrmCgg_res_requisito',
		title:tituloCgg_res_requisito,
		tbar:getPanelTitulo(tituloCgg_res_requisito,descCgg_res_requisito),
		items:[pnlCgg_res_requisito],
		width:400,		
		minWidth:400,
	        resizable: false,
		maximizable:false,
		minimizable:false,
		modal:true,
		constrain:true,
		bbar:[btnGuardarCgg_res_requisito,btnCancelarCgg_res_requisito,'->',btnCerrarCgg_res_requisito]
	});
	/**
	 * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_requisito.
	 * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	 */
	function habilitarCgg_res_requisitoCtrls(inEstado){
		estado=!inEstado;
		txtCrreq_codigo.setDisabled(estado);
		txtCrreq_descripcion.setDisabled(estado);
		txtCrreq_observacion.setDisabled(estado);
	}
	/**
	 * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_requisito.
	 */
	function cargarCgg_res_requisitoCtrls(){
		if(inRecordCgg_res_requisito){
			txtCrreq_codigo.setValue(inRecordCgg_res_requisito.get('CRREQ_CODIGO'));
			txtCrreq_descripcion.setValue(inRecordCgg_res_requisito.get('CRREQ_DESCRIPCION'));
			txtCrreq_observacion.setValue(inRecordCgg_res_requisito.get('CRREQ_OBSERVACION'));
			isEdit = true;
			habilitarCgg_res_requisitoCtrls(true);
		}}
	/**
	 * Funcion miembro que devuelve la ventana winFrmCgg_res_requisito.
	 * @returns ventana winFrmCgg_res_requisito.
	 * @base FrmCgg_res_requisito.prototype.show
	 */
	this.getWindow = function(){
		return winFrmCgg_res_requisito;
	}
	/**
	 * Funcion miembro que carga los controles de la ventana winFrmCgg_res_requisito.
	 * @base FrmCgg_res_requisito.prototype.loadData
	 */
	this.loadData = function(){
		cargarCgg_res_requisitoCtrls();
	}}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_requisito desde una instancia.
 */
FrmCgg_res_requisito.prototype.show = function(){
	this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_requisito desde una instancia.
 */
FrmCgg_res_requisito.prototype.close = function(){
	this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_requisito,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_requisito.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_requisito desde una instancia.
 */
FrmCgg_res_requisito.prototype.loadData = function(){
	this.loadData();
}
