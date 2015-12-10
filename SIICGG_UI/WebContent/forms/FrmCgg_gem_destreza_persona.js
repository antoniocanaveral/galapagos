/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_destreza_persona.
* @param {String} INSENTENCIA_CGG_GEM_DESTREZA_PERSONA Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} INRECORD_CGG_GEM_DESTREZA_PERSONA Registro de datos de la tabla Cgg_gem_destreza_persona.
* @constructor
* @base FrmListadoCgg_gem_destreza_persona
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_gem_destreza_persona(INSENTENCIA_CGG_GEM_DESTREZA_PERSONA,INRECORD_CGG_GEM_DESTREZA_PERSONA,IN_CRPER_CODIGO){	
	var inSentenciaCgg_gem_destreza_persona = INSENTENCIA_CGG_GEM_DESTREZA_PERSONA;
	var inRecordCgg_gem_destreza_persona=INRECORD_CGG_GEM_DESTREZA_PERSONA;
	var urlCgg_gem_destreza_persona=URL_WS+"Cgg_gem_destreza_persona";
	var tituloCgg_gem_destreza_persona='Destrezas/Habilidades';
	var descCgg_gem_destreza_persona='El formulario permite administrar informaci\u00f3n de destrezas/habilidades de la persona';
	var isEdit = false;
	var inCrper_codigo = IN_CRPER_CODIGO;
	var codigoDestreza = "";
	var tipoDestreza = true;
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCgdpr_codigo = new Ext.form.TextField({
			id:'txtCgdpr_codigo',
			name:'txtCgdpr_codigo',
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
			maxLength :20
	});
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	var btnCrper_codigoCgg_gem_destreza_persona = new Ext.Button({
			id:'btnCrper_codigoCgg_gem_destreza_persona',
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
			}}
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCgdst_codigo = new Ext.form.TextField({
			id:'txtCgdst_codigo',
			name:'txtCgdst_codigo',
			fieldLabel :'Descripci\u00f3n',
			anchor:'98%',
			allowBlank :false,
			readOnly:'true'
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var btnCgdst_codigoCgg_gem_destreza_persona = new Ext.Button({
			id:'btnCgdst_codigoCgg_gem_destreza_persona',			
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_gem_destreza = new FrmListadoCgg_gem_destrezaTipo(tipoDestreza);
					var objBusqueda = new DlgBusqueda(tmpFLCgg_gem_destreza.getStore(),tmpFLCgg_gem_destreza.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord)
							{
								codigoDestreza=tmpRecord.get('CGDST_CODIGO')
								txtCgdst_codigo.setValue(tmpRecord.get('CGDST_DESCRIPCION'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_destreza_persona
	*/
	var btnGuardarCgg_gem_destreza_persona = new Ext.Button({
			id:'btnGuardarCgg_gem_destreza_persona',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (pnlCgg_gem_destreza_persona.getForm().isValid()==false){
						return;
					}
					try{
						function CallBackCgg_gem_destreza_persona(r){
							winFrmCgg_gem_destreza_persona.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_gem_destreza_persona,
										msg: 'La informaci\u00f3n de destreza/habilidad de la persona ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_gem_destreza_persona.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_gem_destreza_persona,
										msg: 'La informaci\u00f3n de destreza/habilidad de la persona no ha podido ser almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_gem_destreza_persona.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCgdpr_codigo',txtCgdpr_codigo.getValue());
						//param.add('inCrper_codigo',txtCrper_codigo.getValue());
						param.add('inCrper_codigo',inCrper_codigo);
						//param.add('inCgdst_codigo',txtCgdst_codigo.getValue());
						param.add('inCgdst_codigo',codigoDestreza);
						SOAPClient.invoke(urlCgg_gem_destreza_persona,INSENTENCIA_CGG_GEM_DESTREZA_PERSONA,param, true, CallBackCgg_gem_destreza_persona);
					}catch(inErr){
						winFrmCgg_gem_destreza_persona.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_destreza_persona.
	*/
	var btnCancelarCgg_gem_destreza_persona = new Ext.Button({
			id:'btnCancelarCgg_gem_destreza_persona',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_gem_destreza_persona.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_gem_destreza_persona.
	*/
	var btnCerrarCgg_gem_destreza_persona = new Ext.Button({
			id:'btnCerrarCgg_gem_destreza_persona',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_gem_destreza_persona.close();
			}}
	});
	var gbTipo = new Ext.form.RadioGroup({ 
		fieldLabel: 'Tipo', 
		vertical: false, 
		id:"gbTipo", 
		items: [ 
			{boxLabel: 'Destreza', name: 'rgTipo', id:'destreza',inputValue: true,checked:true},
			{boxLabel: 'Habilidad', name: 'rgTipo',id:'habilidad', inputValue: false }			
			],
		listeners:{
			change:function(group,radio){
				if(radio.getRawValue() == true)                
					tipoDestreza = true;                
                else                
					tipoDestreza = false;                
			}
		}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_gem_destreza_persona.
	*/
	var pnlCgg_gem_destreza_persona = new Ext.form.FormPanel({
			frame:true,			
			items:[gbTipo,
				txtCgdpr_codigo,
				{xtype:'panel',
				layout:'column',
				items:[{columnWidth:.85,layout:'form',items:[txtCgdst_codigo]},
					{columnWidth:.15,layout:'form',items:[btnCgdst_codigoCgg_gem_destreza_persona]}
					]
				}
			]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_destreza_persona.
	*/
	var winFrmCgg_gem_destreza_persona = new Ext.Window({
			id:'winFrmCgg_gem_destreza_persona',
			title:tituloCgg_gem_destreza_persona,
			tbar:getPanelTitulo(tituloCgg_gem_destreza_persona,descCgg_gem_destreza_persona),
			items:[pnlCgg_gem_destreza_persona],
			width:400,
			minWidth:400,
			maximizable:false,
			minimizable:false,
			resizable:false,
			modal:true,
			constrainHeader:true,
			bbar:[btnGuardarCgg_gem_destreza_persona,btnCancelarCgg_gem_destreza_persona,'->',btnCerrarCgg_gem_destreza_persona]
	});	
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_gem_destreza_persona.
	*/
	function cargarCgg_gem_destreza_personaCtrls(){
		if(inRecordCgg_gem_destreza_persona){
			txtCgdpr_codigo.setValue(inRecordCgg_gem_destreza_persona.get('CGDPR_CODIGO'));
			txtCrper_codigo.setValue(inRecordCgg_gem_destreza_persona.get('CRPER_CODIGO'));
			txtCgdst_codigo.setValue(inRecordCgg_gem_destreza_persona.get('CGDST_DESCRIPCION'));
			if (inRecordCgg_gem_destreza_persona.get('CGDST_TIPO'))
				Ext.getCmp('destreza').checked = true;
			else
				Ext.getCmp('habilidad').checked = true;
			codigoDestreza = inRecordCgg_gem_destreza_persona.get('CGDST_CODIGO')
			isEdit = true;			
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_gem_destreza_persona.
	* @returns ventana winFrmCgg_gem_destreza_persona.
	* @base FrmCgg_gem_destreza_persona.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_gem_destreza_persona;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_gem_destreza_persona.
	* @base FrmCgg_gem_destreza_persona.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_gem_destreza_personaCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_destreza_persona desde una instancia.
*/
FrmCgg_gem_destreza_persona.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_destreza_persona desde una instancia.
*/
FrmCgg_gem_destreza_persona.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_destreza_persona,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_gem_destreza_persona.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_destreza_persona desde una instancia.
*/
FrmCgg_gem_destreza_persona.prototype.loadData = function(){
	this.loadData();
}
