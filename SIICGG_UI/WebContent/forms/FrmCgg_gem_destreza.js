/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_destreza.
* @param {String} IN_SENTENCIA_CGG_GEM_DESTREZA Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_GEM_DESTREZA Registro de datos de la tabla Cgg_gem_destreza.
* @constructor
* @base FrmListadoCgg_gem_destreza
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_gem_destreza(IN_SENTENCIA_CGG_GEM_DESTREZA,IN_RECORD_CGG_GEM_DESTREZA){	
	var inSentenciaCgg_gem_destreza = IN_SENTENCIA_CGG_GEM_DESTREZA;
	var inRecordCgg_gem_destreza=IN_RECORD_CGG_GEM_DESTREZA;
	var urlCgg_gem_destreza=URL_WS+"Cgg_gem_destreza";
	var tituloCgg_gem_destreza='Destreza/Habilidad';
	var descCgg_gem_destreza='El formulario permite administrar la informaci\u00f3n de destrezas/Habilidades';
	var isEdit = false;
	var tipoDestreza = true;
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCgdst_codigo = new Ext.form.TextField({
			id:'txtCgdst_codigo',
			name:'txtCgdst_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
	});
	/**
	* Ext.form.TextField DESCRIPCION DE LA EXPERIENCIA LABORAL
	*/
	var txtCgdst_descripcion = new Ext.form.TextField({
			id:'txtCgdst_descripcion',
			name:'txtCgdst_descripcion',
			fieldLabel :'Descripcion',
			anchor:'98%',
			allowBlank :false
	});
	var gbTipo = new Ext.form.RadioGroup({ 
			fieldLabel: 'Tipo', 
			vertical: false, 
			id:"gbTipo", 
			items: [ 
				{boxLabel: 'Destreza', name: 'rgTipo', id:'destreza',inputValue: true,checked:(inRecordCgg_gem_destreza?(inRecordCgg_gem_destreza.get('CGDST_TIPO')?true:false):true)},
				{boxLabel: 'Habilidad', name: 'rgTipo',id:'habilidad', inputValue: false,checked:(inRecordCgg_gem_destreza?(inRecordCgg_gem_destreza.get('CGDST_TIPO')?false:true):false) }			
			],
			listeners:{
				change:function(group,radio){
					if(radio.getRawValue() == 'true')
					{						
						tipoDestreza = true;
					}
					else
					{
						tipoDestreza = false;					
						
					}
				}
			}
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_destreza
	*/
	var btnGuardarCgg_gem_destreza = new Ext.Button({
			id:'btnGuardarCgg_gem_destreza',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (pnlCgg_gem_destreza.getForm().isValid()==false){
						return;
					}
					try{
						function CallBackCgg_gem_destreza(r){
							winFrmCgg_gem_destreza.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_gem_destreza,
										msg: 'La informaci\u00f3n de destreza/habilidad ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_gem_destreza.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_gem_destreza,
										msg: 'La informaci\u00f3n de destreza/habilidad no ha podido ser almacenada. '+r,
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_gem_destreza.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCgdst_codigo',txtCgdst_codigo.getValue());
						param.add('inCgdst_descripcion',txtCgdst_descripcion.getValue());
						param.add('inCgdst_tipo',tipoDestreza);
						SOAPClient.invoke(urlCgg_gem_destreza,IN_SENTENCIA_CGG_GEM_DESTREZA,param, true, CallBackCgg_gem_destreza);
					}catch(inErr){
						winFrmCgg_gem_destreza.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_destreza.
	*/
	var btnCancelarCgg_gem_destreza = new Ext.Button({
			id:'btnCancelarCgg_gem_destreza',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_gem_destreza.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_gem_destreza.
	*/
	var btnCerrarCgg_gem_destreza = new Ext.Button({
			id:'btnCerrarCgg_gem_destreza',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_gem_destreza.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_gem_destreza.
	*/
	var pnlCgg_gem_destreza = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[gbTipo,txtCgdst_codigo,txtCgdst_descripcion]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_destreza.
	*/
	var winFrmCgg_gem_destreza = new Ext.Window({
			id:'winFrmCgg_gem_destreza',
			title:tituloCgg_gem_destreza,
			width:400,
			minWidth:400,
			maximizable:true,
			minimizable:true,
			constrainHeader:true,
			modal:true,
			tbar:getPanelTitulo(tituloCgg_gem_destreza,descCgg_gem_destreza),
			items:[pnlCgg_gem_destreza],
			bbar:[btnGuardarCgg_gem_destreza,btnCancelarCgg_gem_destreza,'->',btnCerrarCgg_gem_destreza]
	});	
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_gem_destreza.
	*/
	function cargarCgg_gem_destrezaCtrls(){
		if(inRecordCgg_gem_destreza){
			txtCgdst_codigo.setValue(inRecordCgg_gem_destreza.get('CGDST_CODIGO'));
			txtCgdst_descripcion.setValue(inRecordCgg_gem_destreza.get('CGDST_DESCRIPCION'));
			tipoDestreza = inRecordCgg_gem_destreza.get('CGDST_TIPO')
			isEdit = true;		
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_gem_destreza.
	* @returns ventana winFrmCgg_gem_destreza.
	* @base FrmCgg_gem_destreza.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_gem_destreza;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_gem_destreza.
	* @base FrmCgg_gem_destreza.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_gem_destrezaCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_destreza desde una instancia.
*/
FrmCgg_gem_destreza.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_destreza desde una instancia.
*/
FrmCgg_gem_destreza.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_destreza,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_gem_destreza.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_destreza desde una instancia.
*/
FrmCgg_gem_destreza.prototype.loadData = function(){
	this.loadData();
}
