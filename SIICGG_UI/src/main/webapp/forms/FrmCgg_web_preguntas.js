/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_web_preguntas.
* @param {String} IN_SENTENCIA_CGG_WEB_PREGUNTAS Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_WEB_PREGUNTAS Registro de datos de la tabla Cgg_web_preguntas.
* @constructor
* @base FrmListadoCgg_web_preguntas
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_web_preguntas(IN_SENTENCIA_CGG_WEB_PREGUNTAS,IN_RECORD_CGG_WEB_PREGUNTAS){
	var inSentenciaCgg_web_preguntas = IN_SENTENCIA_CGG_WEB_PREGUNTAS;
	var inRecordCgg_web_preguntas=IN_RECORD_CGG_WEB_PREGUNTAS;
	var urlCgg_web_preguntas=URL_WS+"Cgg_web_preguntas";
	var tituloCgg_web_preguntas='Web preguntas';
	var descCgg_web_preguntas='El formulario permite administrar la informaci\u00f3n de la tabla Web preguntas';
	var isEdit = false;
	var codigoModulo = '';
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO PREGUNTAS
	*/
	var txtCwprg_codigo = new Ext.form.TextField({
			id:'txtCwprg_codigo',
			name:'txtCwprg_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var txtCwmod_codigo = new Ext.form.TextField({
			id:'txtCwmod_codigo',
			name:'txtCwmod_codigo',
			fieldLabel :'M\u00F3dulo',
			anchor:'98%',
			readOnly:'true',
			allowBlank :false
	});
	/**
	* IDENTIFICATIVO UNICO DE REGISTRO
	*/
	var btnCwmod_codigoCgg_web_preguntas = new Ext.Button({
			id:'btnCwmod_codigoCgg_web_preguntas',
			//text:'Cwmod_codigo',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_web_modulo = new FrmListadoCgg_web_modulo();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_web_modulo.getStore(),tmpFLCgg_web_modulo.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								txtCwmod_codigo.setValue(tmpRecord.get('CWMOD_NOMBRE'));
								codigoModulo = tmpRecord.get('CWMOD_CODIGO');
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextArea PREGUNTA EMITIDA POR EL USUARIO
	*/
	var txtCwprg_pregunta = new Ext.form.TextArea({
			id:'txtCwprg_pregunta',
			name:'txtCwprg_pregunta',
			fieldLabel :'Pregunta',
			width:'90%',
			allowBlank :false
	});
	/**
	* Ext.form.TextArea RESPUESTA DE PARTE DEL RESPONSABLE DEL MODULO
	*/
	var txtCwprg_respuesta = new Ext.form.TextArea({
			id:'txtCwprg_respuesta',
			name:'txtCwprg_respuesta',
			fieldLabel :'Respuesta',
			width:'90%',
			allowBlank :false
	});
	/**
	* Ext.form.TextArea OBSERVACION REFERENTE AL MODULO
	*/
	var txtCwprg_observacion = new Ext.form.TextArea({
			id:'txtCwprg_observacion',
			name:'txtCwprg_observacion',
			fieldLabel :'Observacion',
			width:'90%',
			allowBlank :false
	});
	/**
	* Ext.form.NumberField ALMACENA LA PRIORIDAD DE LA PREGUNTA.
	0 - BUENA
	1 - MALA
	2 - PESIMA
	*/
	var numCwprg_prioridad = new Ext.form.NumberField({
			id:'numCwprg_prioridad',
			name:'numCwprg_prioridad',
			fieldLabel :'Prioridad',
			allowBlank :false,
			disabled :false
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_web_preguntas
	*/
	var btnGuardarCgg_web_preguntas = new Ext.Button({
			id:'btnGuardarCgg_web_preguntas',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (!pnlCgg_web_preguntas.getForm().isValid()){
						return;
					}
					try{
						function CallBackCgg_web_preguntas(r){
							winFrmCgg_web_preguntas.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_web_preguntas,
										msg: 'La informaci\u00f3n sobre la pregunta ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_web_preguntas.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_web_preguntas,
										msg: 'La informaci\u00f3n sobre la pregunta no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_web_preguntas.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCwprg_codigo',txtCwprg_codigo.getValue());
						param.add('inCwmod_codigo',codigoModulo);//txtCwmod_codigo.getValue());
						param.add('inCwprg_pregunta',txtCwprg_pregunta.getValue());
						param.add('inCwprg_respuesta',txtCwprg_respuesta.getValue());
						param.add('inCwprg_observacion',txtCwprg_observacion.getValue());
						param.add('inCwprg_prioridad',numCwprg_prioridad.getValue());
						SOAPClient.invoke(urlCgg_web_preguntas,IN_SENTENCIA_CGG_WEB_PREGUNTAS,param, true, CallBackCgg_web_preguntas);
					}catch(inErr){
						winFrmCgg_web_preguntas.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_web_preguntas.
	*/
	var btnCancelarCgg_web_preguntas = new Ext.Button({
			id:'btnCancelarCgg_web_preguntas',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_web_preguntas.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_web_preguntas.
	*/
	var btnCerrarCgg_web_preguntas = new Ext.Button({
			id:'btnCerrarCgg_web_preguntas',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_web_preguntas.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_web_preguntas.
	*/
	var pnlCgg_web_preguntas = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCwprg_codigo,
				{
					xtype:'panel',
					layout:'column',
					items:[{
							columnWidth:.87,
							layout:'form',
							items:[txtCwmod_codigo]
						},{
							columnWidth:.13,
							layout:'form',
							items:[btnCwmod_codigoCgg_web_preguntas]
					}]
				},
				txtCwprg_pregunta,
				txtCwprg_respuesta,
				txtCwprg_observacion,
				numCwprg_prioridad
			]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_web_preguntas.
	*/
	var winFrmCgg_web_preguntas = new Ext.Window({
			id:'winFrmCgg_web_preguntas',
			title:tituloCgg_web_preguntas,
			iconCls:'iconAplicacion',			
			width:400,
            minWidth:400,
			maxWidth:400,
            height:360,
            minHeight:360,
			maxHeight : 360,
            maximizable:false,
			minimizable:false,
			modal : true,
			constrain:true,
			tbar:getPanelTitulo(tituloCgg_web_preguntas,descCgg_web_preguntas),
			items:[pnlCgg_web_preguntas],
			bbar:[btnGuardarCgg_web_preguntas,btnCancelarCgg_web_preguntas,'->',btnCerrarCgg_web_preguntas]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_web_preguntas.getBottomToolbar());
	/**
	* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_web_preguntas.
	* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	*/
	function habilitarCgg_web_preguntasCtrls(inEstado){
		estado=!inEstado;
		txtCwprg_codigo.setDisabled(estado);
		txtCwmod_codigo.setDisabled(estado);
		txtCwprg_pregunta.setDisabled(estado);
		txtCwprg_respuesta.setDisabled(estado);
		txtCwprg_observacion.setDisabled(estado);
		numCwprg_prioridad.setDisabled(estado);
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_web_preguntas.
	*/
	function cargarCgg_web_preguntasCtrls(){
		if(inRecordCgg_web_preguntas){
			txtCwprg_codigo.setValue(inRecordCgg_web_preguntas.get('CWPRG_CODIGO'));
			//txtCwmod_codigo.setValue(inRecordCgg_web_preguntas.get('CWMOD_CODIGO'));
			var params = new SOAPClientParameters();
			params.add('inCwmod_codigo',inRecordCgg_web_preguntas.get('CWMOD_CODIGO'));
			params.add('format','JSON');
			var tmpResult = SOAPClient.invoke(URL_WS+"PublicWS/Cgg_web_modulo", 'select', params, false, null);
			var nombreModulo = '';
			try{
				tmpResult = eval('('+tmpResult+')');
				nombreModulo = tmpResult[0].CWMOD_NOMBRE;
			}catch(inErr){
				nombreModulo = '';
			}
			txtCwmod_codigo.setValue(nombreModulo);
			codigoModulo = inRecordCgg_web_preguntas.get('CWMOD_CODIGO');
			txtCwprg_pregunta.setValue(inRecordCgg_web_preguntas.get('CWPRG_PREGUNTA'));
			txtCwprg_respuesta.setValue(inRecordCgg_web_preguntas.get('CWPRG_RESPUESTA'));
			txtCwprg_observacion.setValue(inRecordCgg_web_preguntas.get('CWPRG_OBSERVACION'));
			numCwprg_prioridad.setValue(inRecordCgg_web_preguntas.get('CWPRG_PRIORIDAD'));
			isEdit = true;
			habilitarCgg_web_preguntasCtrls(true);
			txtCwprg_pregunta.readOnly = true;
			btnCwmod_codigoCgg_web_preguntas.hidden = true;
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_web_preguntas.
	* @returns ventana winFrmCgg_web_preguntas.
	* @base FrmCgg_web_preguntas.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_web_preguntas;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_web_preguntas.
	* @base FrmCgg_web_preguntas.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_web_preguntasCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_web_preguntas desde una instancia.
*/
FrmCgg_web_preguntas.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_web_preguntas desde una instancia.
*/
FrmCgg_web_preguntas.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_web_preguntas,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_web_preguntas.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_web_preguntas desde una instancia.
*/
FrmCgg_web_preguntas.prototype.loadData = function(){
	this.loadData();
}
