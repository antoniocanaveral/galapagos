/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_tipo_tramite.
 * @param {String} INSENTENCIA_CGG_RES_TIPO_TRAMITE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_TIPO_TRAMITE Registro de datos de la tabla Cgg_res_tipo_tramite.
 * @constructor
 * @base FrmListadoCgg_res_tipo_tramite
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_tipo_tramite(INSENTENCIA_CGG_RES_TIPO_TRAMITE,INRECORD_CGG_RES_TIPO_TRAMITE){
	var inSentenciaCgg_res_tipo_tramite = INSENTENCIA_CGG_RES_TIPO_TRAMITE;
	var inRecordCgg_res_tipo_tramite=INRECORD_CGG_RES_TIPO_TRAMITE;
	var urlCgg_res_tipo_tramite=URL_WS+"Cgg_res_tipo_tramite";
	var tituloCgg_res_tipo_tramite='Tipo de tr\u00E1mite';
	var descCgg_res_tipo_tramite='Ingrese o edite la informaci\u00F3n de su tr\u00E1mite.';
	var isEdit = false;
	/**
	 * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
	 */
	var txtCrtpt_codigo = new Ext.form.TextField({
		id:'txtCrtpt_codigo',
		name:'txtCrtpt_codigo',
		fieldLabel :'Codigo',
		anchor:'98%',
		allowBlank :false,
		value:"KEYGEN",
		hidden:true,
		hideLabel:true
	});
	/**
	 * Ext.form.TextField NOMBRE DEL TIPO DE TRAMITE
	 */
	var txtCrtpt_nombre = new Ext.form.TextField({
		id:'txtCrtpt_nombre',
		name:'txtCrtpt_nombre',
		fieldLabel :'Nombre',
		anchor:'98%',
		allowBlank :false,
		maxLength :100
	});
	/**
	* Ext.form.TextField ABREVIATURA DEL NOMBRE DEL TIPO DE TRAMITE
	*/
	var txtCrtpt_abreviatura = new Ext.form.TextField({
			id:'txtCrtpt_abreviatura',
			name:'txtCrtpt_abreviatura',
			fieldLabel :'Abreviatura',
			anchor:'98%',
			maxLength:5,
			allowBlank :false
	});
	/**
	* Ext.form.NumberField INDICE DE RELEVANCIA
	*/
	var numCrtpt_indice = new Ext.form.NumberField({
			id:'numCrtpt_indice',
			name:'numCrtpt_indice',
			fieldLabel :'Indice',
			allowBlank :false,
			disabled :false
	});
	/**
	 * Ext.form.TextArea OBSERVACIONES AL TIPO DE TRAMITE
	 */
	var txtCrtpt_observaciones = new Ext.form.TextArea({
		id:'txtCrtpt_observaciones',
		name:'txtCrtpt_observaciones',
		fieldLabel :'Observaciones',
		width:'97%',
		allowBlank :true
	});
	/**
	 * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_tipo_tramite
	 */
	var btnGuardarCgg_res_tipo_tramite = new Ext.Button({
		id:'btnGuardarCgg_res_tipo_tramite',
		text:'Guardar',
		iconCls:'iconGuardar',
                tooltip:'Guardar tipo tr\u00E1mite',
		listeners:{
		click:function(){
		if (pnlCgg_res_tipo_tramite.getForm().isValid()==false){
			return;
		}
		try{
			function CallBackCgg_res_tipo_tramite(r){
				winFrmCgg_res_tipo_tramite.getEl().unmask();
				if(r=='true'){
					Ext.Msg.show({
						title:tituloCgg_res_tipo_tramite,
						msg: 'El tipo de tr\u00E1mite ha sido almacenado.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});winFrmCgg_res_tipo_tramite.close()
				}else{
					Ext.Msg.show({
						title:tituloCgg_res_tipo_tramite,
						msg: 'El tipo de tr\u00E1mite no ha sido almacenado.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
				}
			}
			winFrmCgg_res_tipo_tramite.getEl().mask('Guardando...', 'x-mask-loading');
			var param = new SOAPClientParameters();
			if(isEdit)
				param.add('inCrtpt_codigo',txtCrtpt_codigo.getValue());
			param.add('inCrtpt_nombre',txtCrtpt_nombre.getValue());
			param.add('inCrtpt_abreviatura',txtCrtpt_abreviatura.getValue());
			param.add('inCrtpt_indice',numCrtpt_indice.getValue());
			param.add('inCrtpt_observaciones',txtCrtpt_observaciones.getValue());
			SOAPClient.invoke(urlCgg_res_tipo_tramite,INSENTENCIA_CGG_RES_TIPO_TRAMITE,param, true, CallBackCgg_res_tipo_tramite);
		}catch(inErr){
			winFrmCgg_res_tipo_tramite.getEl().unmask();
		}
	}}
	});
	/**
	 * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_tipo_tramite.
	 */
	var btnCancelarCgg_res_tipo_tramite = new Ext.Button({
		id:'btnCancelarCgg_res_tipo_tramite',
		text:'Cancelar',
		iconCls:'iconCancelar',
                tooltip:'Cancelar tipo tr\u00E1mite',
		listeners:{
		click:function(){
		pnlCgg_res_tipo_tramite.getForm().reset();
	}}
	});
	/**
	 * Boton que permite cerrar la ventana winFrmCgg_res_tipo_tramite.
	 */
	var btnCerrarCgg_res_tipo_tramite = new Ext.Button({
		id:'btnCerrarCgg_res_tipo_tramite',
		text:'Cerrar',
		iconCls:'iconCerrar',
                tooltip:'Cerrar formulario',
		listeners:{
		click:function(){
		winFrmCgg_res_tipo_tramite.close();
	}}
	});
	/**
	 * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_tipo_tramite.
	 */
	var pnlCgg_res_tipo_tramite = new Ext.form.FormPanel({
		frame:true,
		labelWidth :100,
		items:[txtCrtpt_codigo,txtCrtpt_nombre,txtCrtpt_abreviatura,numCrtpt_indice,txtCrtpt_observaciones]
	});
	/**
	 * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_tipo_tramite.
	 */
	var winFrmCgg_res_tipo_tramite = new Ext.Window({
		id:'winFrmCgg_res_tipo_tramite',
		title:tituloCgg_res_tipo_tramite,
		tbar:getPanelTitulo(tituloCgg_res_tipo_tramite,descCgg_res_tipo_tramite),
		items:[pnlCgg_res_tipo_tramite],
		width:400,
		minWidth:400,
                modal:true,
                resizable:false,
                maximizable:false,
                minimizable:false,
		constrain:true,               
		bbar:[btnGuardarCgg_res_tipo_tramite,btnCancelarCgg_res_tipo_tramite,'->',btnCerrarCgg_res_tipo_tramite]
	});
	/**
	 * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_tipo_tramite.
	 */
	function cargarCgg_res_tipo_tramiteCtrls(){
		if(inRecordCgg_res_tipo_tramite){
			txtCrtpt_codigo.setValue(inRecordCgg_res_tipo_tramite.get('CRTPT_CODIGO'));
			txtCrtpt_nombre.setValue(inRecordCgg_res_tipo_tramite.get('CRTPT_NOMBRE'));
			txtCrtpt_abreviatura.setValue(inRecordCgg_res_tipo_tramite.get('CRTPT_ABREVIATURA'));
			numCrtpt_indice.setValue(inRecordCgg_res_tipo_tramite.get('CRTPT_INDICE'));
			txtCrtpt_observaciones.setValue(inRecordCgg_res_tipo_tramite.get('CRTPT_OBSERVACIONES'));
			isEdit = true;
		}}
	/**
	 * Funcion miembro que devuelve la ventana winFrmCgg_res_tipo_tramite.
	 * @returns ventana winFrmCgg_res_tipo_tramite.
	 * @base FrmCgg_res_tipo_tramite.prototype.show
	 */
	this.getWindow = function(){
		return winFrmCgg_res_tipo_tramite;
	}
	/**
	 * Funcion miembro que carga los controles de la ventana winFrmCgg_res_tipo_tramite.
	 * @base FrmCgg_res_tipo_tramite.prototype.loadData
	 */
	this.loadData = function(){
		cargarCgg_res_tipo_tramiteCtrls();
	}}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_tipo_tramite desde una instancia.
 */
FrmCgg_res_tipo_tramite.prototype.show = function(){
	this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_tipo_tramite desde una instancia.
 */
FrmCgg_res_tipo_tramite.prototype.close = function(){
	this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_tipo_tramite,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_tipo_tramite.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_tipo_tramite desde una instancia.
 */
FrmCgg_res_tipo_tramite.prototype.loadData = function(){
	this.loadData();
}
