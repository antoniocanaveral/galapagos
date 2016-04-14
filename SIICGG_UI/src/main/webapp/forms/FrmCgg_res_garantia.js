/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_garantia.
 * @param {String} INSENTENCIA_CGG_RES_GARANTIA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_GARANTIA Registro de datos de la tabla Cgg_res_garantia.
 * @constructor
 * @base FrmListadoCgg_res_garantia
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_garantia(INSENTENCIA_CGG_RES_GARANTIA,INRECORD_CGG_RES_GARANTIA){
	var inSentenciaCgg_res_garantia = INSENTENCIA_CGG_RES_GARANTIA;
	var inRecordCgg_res_garantia=INRECORD_CGG_RES_GARANTIA;
	var urlCgg_res_garantia=URL_WS+"Cgg_res_garantia";
	var tituloCgg_res_garantia='Garant\u00EDa de residencia';
	var descCgg_res_garantia='El formulario permite ingresar nueva informaci\u00f3n de las garant\u00EDas a aplicarse a los tr\u00E1mites de residencia';
	var isEdit = false;
	/**
	 * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO
	 */
	var txtCrgrt_codigo = new Ext.form.TextField({
		id:'txtCrgrt_codigo',
		name:'txtCrgrt_codigo',
		fieldLabel :'Codigo',
		anchor:'98%',
		allowBlank :false,
		value:"KEYGEN",
		hidden:true,
		hideLabel:true,
		maxLength :20
	});
	/**
	 * Ext.form.TextField DESCRIPCION DEL TIPO DE RESIDENCIA
	 */
	var txtCrgrt_descrpcion = new Ext.form.TextField({
		id:'txtCrgrt_descrpcion',
		name:'txtCrgrt_descrpcion',
		fieldLabel :'Descripci\u00f3n',
		anchor:'98%',
		allowBlank :false,
		maxLength :100
	});	
        /**
	 * Ext.ux.form.SpinnerField COSTO A PAGAR POR LA GARANTIA
	 */
        var spfCrgrt_valor = new Ext.ux.form.SpinnerField({
            id:'spfCrgrt_valor',
            name:'spfCrgrt_valor',
            fieldLabel :'Valor',
            anchor:'50%',
            allowBlank :false,
            disabled :false,
            value:1,
            minValue: 0,            
            allowDecimals: true,
            allowNegative: false,
            decimalPrecision:3,
            accelerate: true
        });

	var btnGuardarCgg_res_garantia = new Ext.Button({
		id:'btnGuardarCgg_res_garantia',
		text:'Guardar',
                tooltip:'Guardar garant\u00EDa',
		iconCls:'iconGuardar',
		listeners:{
		click:function(){
		if (pnlCgg_res_garantia.getForm().isValid()==false){
			return;
		}
		try{
			function CallBackCgg_res_garantia(r){
				winFrmCgg_res_garantia.getEl().unmask();
				if(r=='true'){
					Ext.Msg.show({
						title:tituloCgg_res_garantia,
						msg: 'La informaci\u00f3n de garant\u00EDa ha sido almacenada.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});winFrmCgg_res_garantia.close()
				}else{
					Ext.Msg.show({
						title:tituloCgg_res_garantia,
						msg: 'La informaci\u00f3n de garant\u00EDa no ha podido ser almacenada.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
				}
			}
			winFrmCgg_res_garantia.getEl().mask('Guardando...', 'x-mask-loading');
			var param = new SOAPClientParameters();
			if(isEdit)
				param.add('inCrgrt_codigo',txtCrgrt_codigo.getValue());
			param.add('inCrgrt_descrpcion',txtCrgrt_descrpcion.getValue());			
                        param.add('inCrgrt_valor',spfCrgrt_valor.getValue());
			SOAPClient.invoke(urlCgg_res_garantia,INSENTENCIA_CGG_RES_GARANTIA,param, true, CallBackCgg_res_garantia);
		}catch(inErr){
			winFrmCgg_res_garantia.getEl().unmask();
		}
	}}
	});
	/**
	 * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_garantia.
	 */
	var btnCancelarCgg_res_garantia = new Ext.Button({
		id:'btnCancelarCgg_res_garantia',
		text:'Cancelar',
		tooltip:'Cancelar garant\u00EDa',
		iconCls:'iconCancelar',
		listeners:{
		click:function(){
		pnlCgg_res_garantia.getForm().reset();
	}}
	});
	/**
	 * Boton que permite cerrar la ventana winFrmCgg_res_garantia.
	 */
	var btnCerrarCgg_res_garantia = new Ext.Button({
		id:'btnCerrarCgg_res_garantia',
		text:'Cerrar',
		tooltip:'Cierra el formulario',
		iconCls:'iconCerrar',
		listeners:{
		click:function(){
		winFrmCgg_res_garantia.close();
	}}
	});
	/**
	 * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_garantia.
	 */
	var pnlCgg_res_garantia = new Ext.form.FormPanel({
		frame:true,
		labelWidth :100,		
                items:[txtCrgrt_codigo,txtCrgrt_descrpcion,spfCrgrt_valor]
	});
	/**
	 * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_garantia.
	 */
	var winFrmCgg_res_garantia = new Ext.Window({
		id:'winFrmCgg_res_garantia',
		title:tituloCgg_res_garantia,
		tbar:getPanelTitulo(tituloCgg_res_garantia,descCgg_res_garantia),
		items:[pnlCgg_res_garantia],
		width:400,
		minWidth:400,
		resizable:false,
		maximizable:false,
		minimizable:false,
		modal:true,
		constrain:true,
		bbar:[btnGuardarCgg_res_garantia,btnCancelarCgg_res_garantia,'->',btnCerrarCgg_res_garantia]
	});
	/**
	 * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_garantia.
	 * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	 */
	function habilitarCgg_res_garantiaCtrls(inEstado){
		estado=!inEstado;
		txtCrgrt_codigo.setDisabled(estado);
		txtCrgrt_descrpcion.setDisabled(estado);
		spfCrgrt_valor.setDisabled(estado);
	}
	/**
	 * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_garantia.
	 */
	function cargarCgg_res_garantiaCtrls(){
		if(inRecordCgg_res_garantia){
			txtCrgrt_codigo.setValue(inRecordCgg_res_garantia.get('CRGRT_CODIGO'));
			txtCrgrt_descrpcion.setValue(inRecordCgg_res_garantia.get('CRGRT_DESCRPCION'));			
                        spfCrgrt_valor.setValue(inRecordCgg_res_garantia.get('CRGRT_VALOR'));
			isEdit = true;
			habilitarCgg_res_garantiaCtrls(true);
		}}
	/**
	 * Funcion miembro que devuelve la ventana winFrmCgg_res_garantia.
	 * @returns ventana winFrmCgg_res_garantia.
	 * @base FrmCgg_res_garantia.prototype.show
	 */
	this.getWindow = function(){
		return winFrmCgg_res_garantia;
	}
	/**
	 * Funcion miembro que carga los controles de la ventana winFrmCgg_res_garantia.
	 * @base FrmCgg_res_garantia.prototype.loadData
	 */
	this.loadData = function(){
		cargarCgg_res_garantiaCtrls();
	}}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_garantia desde una instancia.
 */
FrmCgg_res_garantia.prototype.show = function(){
	this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_garantia desde una instancia.
 */
FrmCgg_res_garantia.prototype.close = function(){
	this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_garantia,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_garantia.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_garantia desde una instancia.
 */
FrmCgg_res_garantia.prototype.loadData = function(){
	this.loadData();
}
