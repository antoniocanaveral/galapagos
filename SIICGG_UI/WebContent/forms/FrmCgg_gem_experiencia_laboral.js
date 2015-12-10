/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_experiencia_laboral.
* @param {String} IN_SENTENCIA_CGG_GEM_EXPERIENCIA_LABORAL Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_GEM_EXPERIENCIA_LABORAL Registro de datos de la tabla Cgg_gem_experiencia_laboral.
* @constructor
* @base FrmListadoCgg_gem_experiencia_laboral
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_gem_experiencia_laboral(IN_SENTENCIA_CGG_GEM_EXPERIENCIA_LABORAL,IN_RECORD_CGG_GEM_EXPERIENCIA_LABORAL,IN_CRPER_CODIGO){
	var inSentenciaCgg_gem_experiencia_laboral = IN_SENTENCIA_CGG_GEM_EXPERIENCIA_LABORAL;
	var inRecordCgg_gem_experiencia_laboral=IN_RECORD_CGG_GEM_EXPERIENCIA_LABORAL;
	var urlCgg_gem_experiencia_laboral=URL_WS+"Cgg_gem_experiencia_laboral";
	var tituloCgg_gem_experiencia_laboral='Experiencia laboral';
	var descCgg_gem_experiencia_laboral='El formulario permite administrar la informaci\u00f3n sobre la experiencia laboral de la persona';
	var isEdit = false;
	var inCrper_codigo=IN_CRPER_CODIGO;
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCgexl_codigo = new Ext.form.TextField({
			id:'txtCgexl_codigo',
			name:'txtCgexl_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
	});
	/**
	* Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	var txtCrper_codigo = new Ext.form.TextField({
			id:'txtCrper_codigo',
			name:'txtCrper_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* CODIGO IDENTIFICATIVO DE REGISTRO
	*/
	var btnCrper_codigoCgg_gem_experiencia_laboral = new Ext.Button({
			id:'btnCrper_codigoCgg_gem_experiencia_laboral',
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
	* Ext.form.DateField FECHA DE INICIO DE ACTIVIDADES DENTRO DE LA EMPRESA
	*/
	var dtCgexl_fecha_inicio = new Ext.form.DateField({
			id:'dtCgexl_fecha_inicio',
			name:'dtCgexl_fecha_inicio',
			fieldLabel :'Fecha inicio',
			allowBlank :false,
			format :'d/m/Y',
			value:new Date()
	});
	/**
	* Ext.form.DateField FECHA DE FINALIZACION DE LAS ACTIVIDADES DENTRO DE LA EMPRESA
	*/
	var dtCgexl_fecha_fin = new Ext.form.DateField({
			id:'dtCgexl_fecha_fin',
			name:'dtCgexl_fecha_fin',
			fieldLabel :'Fecha fin',
			allowBlank :false,
			format :'d/m/Y',
			value:new Date()
	});
	/**
	* Ext.form.TextField EMPRESA DONDE LABORO
	*/
	var txtCgexl_razon_social = new Ext.form.TextField({
			id:'txtCgexl_razon_social',
			name:'txtCgexl_razon_social',
			fieldLabel :'Razon social',
			anchor:'98%',
			allowBlank :false
	});
	
	/**
     * PERSONA JURIDICA
     */
    var btnCgexl_razon_social = new Ext.Button({
        id: 'btnCgexl_razon_social',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpFLCgg_res_persona_juridica = new FrmListadoCgg_res_persona_juridica();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona_juridica.getStore(), tmpFLCgg_res_persona_juridica.getColumnModel());
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord) {
                        txtCgexl_razon_social.setValue(tmpRecord.get('CRPJR_RAZON_SOCIAL'));                        
                    }
                });
                objBusqueda.show();
            }
        }
    });
	
	/**
	* Ext.form.TextField NO ESPECIFICADO
	*/
	var txtCgexl_ciudad = new Ext.form.TextField({
			id:'txtCgexl_ciudad',
			name:'txtCgexl_ciudad',
			fieldLabel :'Ciudad',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO DE ISLA O CIUDAD
	*/
    var btnCgexl_ciudad = new Ext.Button({
        id:'btnCgexl_ciudad',        
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_isla = new FrmListadoCgg_isla();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_isla.getStore(),tmpFLCgg_isla.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){                        
                        txtCgexl_ciudad.setValue(tmpRecord.get('CISLA_NOMBRE'));
                    }
                });
                objBusqueda.show();
            }
        }
    });
	/**
	* Ext.form.TextField NOMBRE DEL CARGO
	*/
	var txtCgexl_cargo = new Ext.form.TextField({
			id:'txtCgexl_cargo',
			name:'txtCgexl_cargo',
			fieldLabel :'Cargo',
			anchor:'98%',
			allowBlank :false
	});
	/**
     * CARGO DE UNA PERSONA
     */
    var btnCgexl_cargo = new Ext.Button({
        id: 'btnCgexl_cargo',
        text: '',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpFLCgg_gem_cargo = new FrmListadoCgg_gem_cargo();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_gem_cargo.getStore(), tmpFLCgg_gem_cargo.getColumnModel());
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord) {
						txtCgexl_cargo.setValue(tmpRecord.get('CGCRG_NOMBRE'));										
					}
                });
                objBusqueda.show();
            }
        }
    });
	/**
	* Ext.form.TextArea DESCRIPCION DEL CARGO DESEMPENIADO
	*/
	var txtCgexl_descripcion = new Ext.form.TextArea({
			id:'txtCgexl_descripcion',
			name:'txtCgexl_descripcion',
			fieldLabel :'Descripcion',
			width:'90%',
			allowBlank :false
	});
	/**
	* Ext.form.NumberField CANTIDAD DE PERSONAS BAJO SU MANDO
	*/
	var numCgexl_personas_cargo = new Ext.form.NumberField({
			id:'numCgexl_personas_cargo',
			name:'numCgexl_personas_cargo',
			fieldLabel :'Personas cargo',
			allowBlank :false,
			disabled :false
	});
	/**
	* Ext.form.TextField NOMBRE DE LA PERSONA PARA CONTACTARSE POR REFERENCIAS
	*/
	var txtCgexl_contacto = new Ext.form.TextField({
			id:'txtCgexl_contacto',
			name:'txtCgexl_contacto',
			fieldLabel :'Contacto',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* Ext.form.TextField NUMERO DE TELEFONO DE LA PERSONA PARA CONTACTARSE POR REFERENCIAS
	*/
	var txtCgexl_telefono = new Ext.form.TextField({
			id:'txtCgexl_telefono',
			name:'txtCgexl_telefono',
			fieldLabel :'Telefono',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* Ext.form.TextArea INFORMACION ADICIONAL
	*/
	var txtCgexl_observaciones = new Ext.form.TextArea({
			id:'txtCgexl_observaciones',
			name:'txtCgexl_observaciones',
			fieldLabel :'Observaciones',
			width:'90%',
			allowBlank :false
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_experiencia_laboral
	*/
	var btnGuardarCgg_gem_experiencia_laboral = new Ext.Button({
			id:'btnGuardarCgg_gem_experiencia_laboral',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (!pnlCgg_gem_experiencia_laboral.getForm().isValid()){
						return;
					}
					try{
						function CallBackCgg_gem_experiencia_laboral(r){
							winFrmCgg_gem_experiencia_laboral.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_gem_experiencia_laboral,
										msg: 'La informaci\u00f3n sobre la experiencia laboral ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_gem_experiencia_laboral.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_gem_experiencia_laboral,
										msg: 'La informaci\u00f3n sobre la experiencia laboral no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_gem_experiencia_laboral.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCgexl_codigo',txtCgexl_codigo.getValue());
						//param.add('inCrper_codigo',txtCrper_codigo.getValue());						
						param.add('inCrper_codigo',inCrper_codigo);
						param.add('inCgexl_fecha_inicio',dtCgexl_fecha_inicio.getValue().format('c'));
						param.add('inCgexl_fecha_fin',dtCgexl_fecha_fin.getValue().format('c'));
						param.add('inCgexl_razon_social',txtCgexl_razon_social.getValue());
						param.add('inCgexl_ciudad',txtCgexl_ciudad.getValue());
						param.add('inCgexl_cargo',txtCgexl_cargo.getValue());
						param.add('inCgexl_descripcion',txtCgexl_descripcion.getValue());
						param.add('inCgexl_personas_cargo',numCgexl_personas_cargo.getValue());
						param.add('inCgexl_contacto',txtCgexl_contacto.getValue());
						param.add('inCgexl_telefono',txtCgexl_telefono.getValue());
						param.add('inCgexl_observaciones',txtCgexl_observaciones.getValue());
						SOAPClient.invoke(urlCgg_gem_experiencia_laboral,IN_SENTENCIA_CGG_GEM_EXPERIENCIA_LABORAL,param, true, CallBackCgg_gem_experiencia_laboral);
					}catch(inErr){
						winFrmCgg_gem_experiencia_laboral.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_experiencia_laboral.
	*/
	var btnCancelarCgg_gem_experiencia_laboral = new Ext.Button({
			id:'btnCancelarCgg_gem_experiencia_laboral',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_gem_experiencia_laboral.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_gem_experiencia_laboral.
	*/
	var btnCerrarCgg_gem_experiencia_laboral = new Ext.Button({
			id:'btnCerrarCgg_gem_experiencia_laboral',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_gem_experiencia_laboral.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_gem_experiencia_laboral.
	*/
	var pnlCgg_gem_experiencia_laboral = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCgexl_codigo,/*,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCrper_codigo]},{columnWidth:.4,layout:'form',items:[btnCrper_codigoCgg_gem_experiencia_laboral]}]}*/				
				{
					xtype:'fieldset',
                    columnWidth: 0.75,
                    title: 'Empresa',
                    layout: 'form',
					items:[
						{xtype:'panel',layout:'column',items:[{columnWidth:.9,layout:'form',items:[txtCgexl_razon_social]},{columnWidth:.1,layout:'form',items:[btnCgexl_razon_social]}]},						
						{xtype:'panel',layout:'column',items:[{columnWidth:.9,layout:'form',items:[txtCgexl_ciudad]},{columnWidth:.1,layout:'form',items:[btnCgexl_ciudad]}]},
						{xtype:'panel',layout:'column',items:[{columnWidth:.9,layout:'form',items:[txtCgexl_cargo]},{columnWidth:.1,layout:'form',items:[btnCgexl_cargo]}]},
						txtCgexl_descripcion,
						dtCgexl_fecha_inicio,
						dtCgexl_fecha_fin,
						numCgexl_personas_cargo
					]
				},
				{					
                        xtype:'fieldset',
                        columnWidth: 0.75,
                        title: 'Contactos',
                        layout: 'form',
						items:[txtCgexl_contacto,
							txtCgexl_telefono
						]
				},			
				txtCgexl_observaciones
			]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_experiencia_laboral.
	*/
	var winFrmCgg_gem_experiencia_laboral = new Ext.Window({
			id:'winFrmCgg_gem_experiencia_laboral',
			title:tituloCgg_gem_experiencia_laboral,
			iconCls:'iconAplicacion',
			width:400,
			minWidth:400,			
			maximizable:false,
			minimizable:false,			
			modal:true,
			constrainHeader:true,
			tbar:getPanelTitulo(tituloCgg_gem_experiencia_laboral,descCgg_gem_experiencia_laboral),
			items:[pnlCgg_gem_experiencia_laboral],
			bbar:[btnGuardarCgg_gem_experiencia_laboral,btnCancelarCgg_gem_experiencia_laboral,'->',btnCerrarCgg_gem_experiencia_laboral]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_gem_experiencia_laboral.getBottomToolbar());	
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_gem_experiencia_laboral.
	*/	
	function cargarCgg_gem_experiencia_laboralCtrls(){
		if(inRecordCgg_gem_experiencia_laboral){
			txtCgexl_codigo.setValue(inRecordCgg_gem_experiencia_laboral.get('CGEXL_CODIGO'));
			txtCrper_codigo.setValue(inRecordCgg_gem_experiencia_laboral.get('CRPER_CODIGO'));
			dtCgexl_fecha_inicio.setValue(inRecordCgg_gem_experiencia_laboral.get('CGEXL_FECHA_INICIO')?formatShortDate(inRecordCgg_gem_experiencia_laboral.get('CGEXL_FECHA_INICIO')):null);
			dtCgexl_fecha_fin.setValue(inRecordCgg_gem_experiencia_laboral.get('CGEXL_FECHA_FIN')?formatShortDate(inRecordCgg_gem_experiencia_laboral.get('CGEXL_FECHA_FIN')):null);
			txtCgexl_razon_social.setValue(inRecordCgg_gem_experiencia_laboral.get('CGEXL_RAZON_SOCIAL'));
			txtCgexl_ciudad.setValue(inRecordCgg_gem_experiencia_laboral.get('CGEXL_CIUDAD'));
			txtCgexl_cargo.setValue(inRecordCgg_gem_experiencia_laboral.get('CGEXL_CARGO'));
			txtCgexl_descripcion.setValue(inRecordCgg_gem_experiencia_laboral.get('CGEXL_DESCRIPCION'));
			numCgexl_personas_cargo.setValue(inRecordCgg_gem_experiencia_laboral.get('CGEXL_PERSONAS_CARGO'));
			txtCgexl_contacto.setValue(inRecordCgg_gem_experiencia_laboral.get('CGEXL_CONTACTO'));
			txtCgexl_telefono.setValue(inRecordCgg_gem_experiencia_laboral.get('CGEXL_TELEFONO'));
			txtCgexl_observaciones.setValue(inRecordCgg_gem_experiencia_laboral.get('CGEXL_OBSERVACIONES'));
			isEdit = true;			
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_gem_experiencia_laboral.
	* @returns ventana winFrmCgg_gem_experiencia_laboral.
	* @base FrmCgg_gem_experiencia_laboral.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_gem_experiencia_laboral;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_gem_experiencia_laboral.
	* @base FrmCgg_gem_experiencia_laboral.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_gem_experiencia_laboralCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_experiencia_laboral desde una instancia.
*/
FrmCgg_gem_experiencia_laboral.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_experiencia_laboral desde una instancia.
*/
FrmCgg_gem_experiencia_laboral.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_experiencia_laboral,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_gem_experiencia_laboral.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_experiencia_laboral desde una instancia.
*/
FrmCgg_gem_experiencia_laboral.prototype.loadData = function(){
	this.loadData();
}

