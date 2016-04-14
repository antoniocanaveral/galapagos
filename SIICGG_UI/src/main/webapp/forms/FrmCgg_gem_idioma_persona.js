/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_idioma_persona.
* @param {String} INSENTENCIA_CGG_GEM_IDIOMA_PERSONA Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} INRECORD_CGG_GEM_IDIOMA_PERSONA Registro de datos de la tabla Cgg_gem_idioma_persona.
* @constructor
* @base FrmListadoCgg_gem_idioma_persona
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_gem_idioma_persona(INSENTENCIA_CGG_GEM_IDIOMA_PERSONA,INRECORD_CGG_GEM_IDIOMA_PERSONA,inCrper_codigo){
	var inSentenciaCgg_gem_idioma_persona = INSENTENCIA_CGG_GEM_IDIOMA_PERSONA;
	var inRecordCgg_gem_idioma_persona=INRECORD_CGG_GEM_IDIOMA_PERSONA;
	var urlCgg_gem_idioma_persona=URL_WS+"Cgg_gem_idioma_persona";
	var tituloCgg_gem_idioma_persona='Idiomas de la persona';
	var descCgg_gem_idioma_persona='El formulario permite administrar informaci\u00f3n sobre los Idiomas de la persona';
	var isEdit = false;
    var codigoIdioma = "";
    
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCgidp_codigo = new Ext.form.TextField({
			id:'txtCgidp_codigo',
			name:'txtCgidp_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			allowBlank :false,
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			maxLength :20
	});
	/**
	* Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	var txtCrper_codigo = new Ext.form.TextField({
			id:'txtCrper_codigo',
			name:'txtCrper_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			allowBlank :false,
			readOnly:'true',
			maxLength :20/*,
            hidden:true*/
	});
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	var btnCrper_codigoCgg_gem_idioma_persona = new Ext.Button({
			id:'btnCrper_codigoCgg_gem_idioma_persona',
			text:'Crper_codigo',
			iconCls:'iconCrper_codigo',
			listeners:{
				click:function(){
					var tmpFLCgg_res_persona = new FrmListadoCgg_res_persona();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(),tmpFLCgg_res_persona.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
								txtCrper_codigo.setValue(tmpRecord.get('CRPER_CODIGO'));                                
					});
					objBusqueda.show();
			}}/*,
            hidden:true*/
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCgidm_codigo = new Ext.form.TextField({
			id:'txtCgidm_codigo',
			name:'txtCgidm_codigo',
			fieldLabel :'Idioma',
			anchor:'98%',
			allowBlank :false,
			readOnly:'true',
			maxLength :20
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var btnCgidm_codigoCgg_gem_idioma_persona = new Ext.Button({
			id:'btnCgidm_codigoCgg_gem_idioma_persona',
			//text:'Cgidm_codigo',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_gem_idioma = new FrmListadoCgg_gem_idioma();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_gem_idioma.getStore(),tmpFLCgg_gem_idioma.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
                            {
                                codigoIdioma=tmpRecord.get('CGIDM_CODIGO');
								txtCgidm_codigo.setValue(tmpRecord.get('CGIDM_NOMBRE'));
                            }
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO DEL IDIOMA
	*/
	var txtCgidp_nombre = new Ext.form.TextField({
			id:'txtCgidp_nombre',
			name:'txtCgidp_nombre',
			fieldLabel :'Nombre',
			anchor:'98%',
			allowBlank :false,
			maxLength :20/*,
            hidden:true*/
	});
	/**
	* Ext.form.NumberField PROCENTAJE QUE DOMINA EL IDIOMA DE FORMA ESCRITA
	*/
	var numCgidp_escritura = new Ext.form.NumberField({
	id:'numCgidp_escritura',nname:'numCgidp_escritura',fieldLabel :'Escritura %',allowBlank :false,disabled :false});/**
	* Ext.form.NumberField PROCENTAJE QUE DOMINA EL IDIOMA EN LA LECTURA
	*/
	var numCgidp_lectura = new Ext.form.NumberField({
	id:'numCgidp_lectura',nname:'numCgidp_lectura',fieldLabel :'Lectura %',allowBlank :false,disabled :false});/**
	* Ext.form.NumberField PROCENTAJE QUE DOMINA EL IDIOMA EN FORMA ORAL
	*/
	var numCgidp_hablar = new Ext.form.NumberField({
	id:'numCgidp_hablar',nname:'numCgidp_hablar',fieldLabel :'Hablar %',allowBlank :false,disabled :false});/**
	* Ext.form.NumberField PROCENTAJE QUE DOMINA EL IDIOMA EN FORMA AUDITIVA
	*/
	var numCgidp_escuchar = new Ext.form.NumberField({
	id:'numCgidp_escuchar',nname:'numCgidp_escuchar',fieldLabel :'Escuchar %',allowBlank :false,disabled :false});/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_idioma_persona
	*/
	var btnGuardarCgg_gem_idioma_persona = new Ext.Button({
			id:'btnGuardarCgg_gem_idioma_persona',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (pnlCgg_gem_idioma_persona.getForm().isValid()==false){                        
						return;
					}
					try{
						function CallBackCgg_gem_idioma_persona(r){

							winFrmCgg_gem_idioma_persona.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_gem_idioma_persona,
										msg: 'La informaci\u00f3n sobre el idioma de la persona ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_gem_idioma_persona.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_gem_idioma_persona,
										msg: 'La informaci\u00f3n sobre el idioma de la persona no ha podido ser almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_gem_idioma_persona.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCgidp_codigo',txtCgidp_codigo.getValue());
						//param.add('inCrper_codigo',txtCrper_codigo.getValue());
                        param.add('inCrper_codigo',inCrper_codigo);
						//param.add('inCgidm_codigo',txtCgidm_codigo.getValue());
                        param.add('inCgidm_codigo',codigoIdioma);
						//param.add('inCgidp_nombre',txtCgidp_nombre.getValue());
						param.add('inCgidp_escritura',numCgidp_escritura.getValue());
						param.add('inCgidp_lectura',numCgidp_lectura.getValue());
						param.add('inCgidp_hablar',numCgidp_hablar.getValue());
						param.add('inCgidp_escuchar',numCgidp_escuchar.getValue());
						SOAPClient.invoke(urlCgg_gem_idioma_persona,INSENTENCIA_CGG_GEM_IDIOMA_PERSONA,param, true, CallBackCgg_gem_idioma_persona);
					}catch(inErr){
						winFrmCgg_gem_idioma_persona.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_idioma_persona.
	*/
	var btnCancelarCgg_gem_idioma_persona = new Ext.Button({
			id:'btnCancelarCgg_gem_idioma_persona',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_gem_idioma_persona.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_gem_idioma_persona.
	*/
	var btnCerrarCgg_gem_idioma_persona = new Ext.Button({
			id:'btnCerrarCgg_gem_idioma_persona',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_gem_idioma_persona.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_gem_idioma_persona.
	*/
	var pnlCgg_gem_idioma_persona = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCgidp_codigo/*,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCrper_codigo]},{columnWidth:.4,layout:'form',items:[btnCrper_codigoCgg_gem_idioma_persona]}]}*/,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCgidm_codigo]},{columnWidth:.4,layout:'form',items:[btnCgidm_codigoCgg_gem_idioma_persona]}]},/*txtCgidp_nombre,*/numCgidp_escritura,numCgidp_lectura,numCgidp_hablar,numCgidp_escuchar]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_idioma_persona.
	*/
	var winFrmCgg_gem_idioma_persona = new Ext.Window({
			id:'winFrmCgg_gem_idioma_persona',
			title:tituloCgg_gem_idioma_persona,
			tbar:getPanelTitulo(tituloCgg_gem_idioma_persona,descCgg_gem_idioma_persona),
			items:[pnlCgg_gem_idioma_persona],
			width:400,
			minWidth:400,
			maximizable:false,
			minimizable:false,			
			modal:true,
			constrainHeader:true,
			bbar:[btnGuardarCgg_gem_idioma_persona,btnCancelarCgg_gem_idioma_persona,'->',btnCerrarCgg_gem_idioma_persona]
	});	
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_gem_idioma_persona.
	*/
	function cargarCgg_gem_idioma_personaCtrls(){
		if(inRecordCgg_gem_idioma_persona){
			txtCgidp_codigo.setValue(inRecordCgg_gem_idioma_persona.get('CGIDP_CODIGO'));
			txtCrper_codigo.setValue(inRecordCgg_gem_idioma_persona.get('CRPER_CODIGO'));
			txtCgidm_codigo.setValue(inRecordCgg_gem_idioma_persona.get('CGIDM_NOMBRE'));
            codigoIdioma=inRecordCgg_gem_idioma_persona.get('CGIDM_CODIGO');
			//txtCgidp_nombre.setValue(inRecordCgg_gem_idioma_persona.get('CGIDP_NOMBRE'));
			numCgidp_escritura.setValue(inRecordCgg_gem_idioma_persona.get('CGIDP_ESCRITURA'));
			numCgidp_lectura.setValue(inRecordCgg_gem_idioma_persona.get('CGIDP_LECTURA'));
			numCgidp_hablar.setValue(inRecordCgg_gem_idioma_persona.get('CGIDP_HABLAR'));
			numCgidp_escuchar.setValue(inRecordCgg_gem_idioma_persona.get('CGIDP_ESCUCHAR'));
			isEdit = true;			
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_gem_idioma_persona.
	* @returns ventana winFrmCgg_gem_idioma_persona.
	* @base FrmCgg_gem_idioma_persona.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_gem_idioma_persona;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_gem_idioma_persona.
	* @base FrmCgg_gem_idioma_persona.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_gem_idioma_personaCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_idioma_persona desde una instancia.
*/
FrmCgg_gem_idioma_persona.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_idioma_persona desde una instancia.
*/
FrmCgg_gem_idioma_persona.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_idioma_persona,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_gem_idioma_persona.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_idioma_persona desde una instancia.
*/
FrmCgg_gem_idioma_persona.prototype.loadData = function(){
	this.loadData();
}
