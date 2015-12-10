/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_cuenta_personajuridica.
* @param {String} IN_SENTENCIA_CGG_RES_CUENTA_PERSONAJURIDICA Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_RES_CUENTA_PERSONAJURIDICA Registro de datos de la tabla Cgg_res_cuenta_personajuridica.
* @constructor
* @base FrmListadoCgg_res_cuenta_personajuridica
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_res_cuenta_personajuridica(IN_SENTENCIA_CGG_RES_CUENTA_PERSONAJURIDICA,IN_RECORD_CGG_RES_CUENTA_PERSONAJURIDICA){
	var inSentenciaCgg_res_cuenta_personajuridica = IN_SENTENCIA_CGG_RES_CUENTA_PERSONAJURIDICA;
	var inRecordCgg_res_cuenta_personajuridica=IN_RECORD_CGG_RES_CUENTA_PERSONAJURIDICA;
	var urlCgg_res_cuenta_personajuridica=URL_WS+"Cgg_res_cuenta_personajuridica";
	var tituloCgg_res_cuenta_personajuridica='Cuenta bancaria';
	var descCgg_res_cuenta_personajuridica='El formulario permite administrar la informaci\u00f3n de la cuenta bancaria de una Persona Juridica.';
	var isEdit = false;
	var tmpPersonaJuridica;
	var tmpEntidadFinanciera;
	var tmpTitular;
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CUENTA 
	*/
	var txtCrcpj_codigo = new Ext.form.TextField({
			id:'txtCrcpj_codigo',
			name:'txtCrcpj_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGSITRO DE ENTIDAD FINANCIERA
	*/
	var txtCgg_crpjr_codigo = new Ext.form.TextField({
			id:'txtCgg_crpjr_codigo',
			name:'txtCgg_crpjr_codigo',
			fieldLabel :'Entidad',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGSITRO DE ENTIDAD FINANCIERA
	*/
	var btnCrpjr_codigoCgg_res_cuenta_personajuridica = new Ext.Button({
			id:'btnCrpjr_codigoCgg_res_cuenta_personajuridica',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_res_entidad_financiera = new FrmListadoCgg_res_persona_juridica();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_res_entidad_financiera.getStore(),tmpFLCgg_res_entidad_financiera.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								tmpEntidadFinanciera = tmpRecord.get('CRPJR_CODIGO');
								txtCgg_crpjr_codigo.setValue(tmpRecord.get('CRPJR_RAZON_SOCIAL'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA TITULAR DE LA CUENTA
	*/
	var txtCPJCrper_codigo = new Ext.form.TextField({
			id:'txtCPJCrper_codigo',
			name:'txtCPJCrper_codigo',
			fieldLabel :'Titular',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA TITULAR DE LA CUENTA
	*/
	var btnCrper_codigoCgg_res_cuenta_personajuridica = new Ext.Button({
			id:'btnCrper_codigoCgg_res_cuenta_personajuridica',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_res_persona = new Persona();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								tmpTitular = tmpRecord.get('CRPER_CODIGO');
								txtCPJCrper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('CRPER_APELLIDO_PATERNO')+" "+tmpRecord.get('CRPER_APELLIDO_MATERNO'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField NUMERO DE LA CUENTA BANCARIA
	*/
	var txtCrcpj_numero_cuenta = new Ext.form.TextField({
			id:'txtCrcpj_numero_cuenta',
			name:'txtCrcpj_numero_cuenta',
			fieldLabel :'Numero de cuenta',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* Ext.form.TextField DESCRIPCION DE LA CUENTA BANCARIA
	*/
	var txtCrcpj_descripcion = new Ext.form.TextField({
			id:'txtCrcpj_descripcion',
			name:'txtCrcpj_descripcion',
			fieldLabel :'Descripci\u00f3n',
			anchor:'98%'
	});
	/**
	* Ext.form.NumberField TIPO DE CUENTA BANCARIA
	*/
	var cbxCrcpj_tipo_cuenta = new Ext.form.ComboBox({
        fieldLabel :'Tipo de cuenta',
        typeAhead: true,
        triggerAction: 'all',
        lazyRender:true,
		forceSelection:true,
        mode: 'local',
        anchor:'98%',
		editable:false,
        emptyText:'Seleccione el tipo...',
        store: dsTipoCuentaBancaria
    });
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_res_cuenta_personajuridica
	*/
	var btnGuardarCgg_res_cuenta_personajuridica = new Ext.Button({
			id:'btnGuardarCgg_res_cuenta_personajuridica',
			text:'Aceptar',
			iconCls:'iconAceptar',
			listeners:{
				click:function(){
					if (pnlCgg_res_cuenta_personajuridica.getForm().isValid()==false){
						return;
					}
					try{
						IN_RECORD_CGG_RES_CUENTA_PERSONAJURIDICA.data.CGG_CRPJR_CODIGO = tmpEntidadFinanciera;
						IN_RECORD_CGG_RES_CUENTA_PERSONAJURIDICA.data.CRPJR_CODIGO = tmpPersonaJuridica;
						IN_RECORD_CGG_RES_CUENTA_PERSONAJURIDICA.data.CRPER_CODIGO = tmpTitular;
						IN_RECORD_CGG_RES_CUENTA_PERSONAJURIDICA.data.CRCPJ_NUMERO_CUENTA = txtCrcpj_numero_cuenta.getValue();
						IN_RECORD_CGG_RES_CUENTA_PERSONAJURIDICA.data.CRCPJ_DESCRIPCION = txtCrcpj_descripcion.getValue();
						IN_RECORD_CGG_RES_CUENTA_PERSONAJURIDICA.data.CRCPJ_TIPO_CUENTA = cbxCrcpj_tipo_cuenta.getValue();
						IN_RECORD_CGG_RES_CUENTA_PERSONAJURIDICA.data.TITULAR = txtCPJCrper_codigo.getValue();
						IN_RECORD_CGG_RES_CUENTA_PERSONAJURIDICA.data.CRPJR_RAZON_SOCIAL = txtCgg_crpjr_codigo.getValue();
						winFrmCgg_res_cuenta_personajuridica.close();
					}catch(inErr){
						winFrmCgg_res_cuenta_personajuridica.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_cuenta_personajuridica.
	*/
	var btnCancelarCgg_res_cuenta_personajuridica = new Ext.Button({
			id:'btnCancelarCgg_res_cuenta_personajuridica',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_res_cuenta_personajuridica.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_res_cuenta_personajuridica.
	*/
	var btnCerrarCgg_res_cuenta_personajuridica = new Ext.Button({
			id:'btnCerrarCgg_res_cuenta_personajuridica',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_res_cuenta_personajuridica.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_cuenta_personajuridica.
	*/
	var pnlCgg_res_cuenta_personajuridica = new Ext.form.FormPanel({
			frame:true,
			labelWidth :110,
			items:[txtCrcpj_codigo,
				{xtype:'panel',layout:'column',items:[
					{columnWidth:.92,layout:'form',items:[txtCgg_crpjr_codigo]},
					{columnWidth:.08,layout:'form',items:[btnCrpjr_codigoCgg_res_cuenta_personajuridica]}]},
				{xtype:'panel',layout:'column',items:[
					{columnWidth:.92,layout:'form',items:[txtCPJCrper_codigo]},
					{columnWidth:.08,layout:'form',items:[btnCrper_codigoCgg_res_cuenta_personajuridica]}]},
				txtCrcpj_numero_cuenta,txtCrcpj_descripcion,cbxCrcpj_tipo_cuenta]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_cuenta_personajuridica.
	*/
	var winFrmCgg_res_cuenta_personajuridica = new Ext.Window({
			id:'winFrmCgg_res_cuenta_personajuridica',
			title:tituloCgg_res_cuenta_personajuridica,
			width:400,
			minWidth:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			modal:true,
			tbar:getPanelTitulo(tituloCgg_res_cuenta_personajuridica,descCgg_res_cuenta_personajuridica),
			items:[pnlCgg_res_cuenta_personajuridica],
			bbar:[btnGuardarCgg_res_cuenta_personajuridica,btnCancelarCgg_res_cuenta_personajuridica,'->',btnCerrarCgg_res_cuenta_personajuridica]
	});
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_cuenta_personajuridica.
	*/
	function cargarCgg_res_cuenta_personajuridicaCtrls(){
		if(inRecordCgg_res_cuenta_personajuridica){
			tmpTitular = inRecordCgg_res_cuenta_personajuridica.get('CRPER_CODIGO');
			tmpEntidadFinanciera = inRecordCgg_res_cuenta_personajuridica.get('CGG_CRPJR_CODIGO');
			txtCrcpj_codigo.setValue(inRecordCgg_res_cuenta_personajuridica.get('CRCPJ_CODIGO'));
			txtCgg_crpjr_codigo.setValue(inRecordCgg_res_cuenta_personajuridica.get('CRPJR_RAZON_SOCIAL'));
			tmpPersonaJuridica = inRecordCgg_res_cuenta_personajuridica.get('CRPJR_CODIGO');
			txtCPJCrper_codigo.setValue(inRecordCgg_res_cuenta_personajuridica.get('TITULAR'));
			txtCrcpj_numero_cuenta.setValue(inRecordCgg_res_cuenta_personajuridica.get('CRCPJ_NUMERO_CUENTA'));
			txtCrcpj_descripcion.setValue(inRecordCgg_res_cuenta_personajuridica.get('CRCPJ_DESCRIPCION'));
			cbxCrcpj_tipo_cuenta.setValue(inRecordCgg_res_cuenta_personajuridica.get('CRCPJ_TIPO_CUENTA'));
			isEdit = true;
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_res_cuenta_personajuridica.
	* @returns ventana winFrmCgg_res_cuenta_personajuridica.
	* @base FrmCgg_res_cuenta_personajuridica.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_res_cuenta_personajuridica;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_res_cuenta_personajuridica.
	* @base FrmCgg_res_cuenta_personajuridica.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_res_cuenta_personajuridicaCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_cuenta_personajuridica desde una instancia.
*/
FrmCgg_res_cuenta_personajuridica.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_cuenta_personajuridica desde una instancia.
*/
FrmCgg_res_cuenta_personajuridica.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_cuenta_personajuridica,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_res_cuenta_personajuridica.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_cuenta_personajuridica desde una instancia.
*/
FrmCgg_res_cuenta_personajuridica.prototype.loadData = function(){
	this.loadData();
}
