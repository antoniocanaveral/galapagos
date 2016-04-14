/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_gem_perfil_adjunto.
* @param {String} IN_SENTENCIA_CGG_GEM_PERFIL_ADJUNTO Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_GEM_PERFIL_ADJUNTO Registro de datos de la tabla Cgg_gem_perfil_adjunto.
* @constructor
* @base FrmListadoCgg_gem_perfil_adjunto
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_gem_perfil_adjunto(IN_SENTENCIA_CGG_GEM_PERFIL_ADJUNTO,IN_RECORD_CGG_GEM_PERFIL_ADJUNTO,IN_CRPER_CODIGO,IN_CGPFA_TIPO){	
	var inSentenciaCgg_gem_perfil_adjunto = IN_SENTENCIA_CGG_GEM_PERFIL_ADJUNTO;
	var inRecordCgg_gem_perfil_adjunto=IN_RECORD_CGG_GEM_PERFIL_ADJUNTO;
	var urlCgg_gem_perfil_adjunto=URL_WS+"Cgg_gem_perfil_adjunto";
	var tituloCgg_gem_perfil_adjunto='Gem perfil adjunto';
	var descCgg_gem_perfil_adjunto='El formulario permite administrar la informaci\u00f3n de la tabla Gem perfil adjunto';
	var isEdit = false;
	var codigoPersona= IN_CRPER_CODIGO;
	var tipoAdjunto = IN_CGPFA_TIPO;
	/**
	* Ext.form.TextField CODIGO QUE IDENTIFICA EL ADJUNTO DE UNA BECA 
	
	*/
	var txtCgpfa_codigo = new Ext.form.TextField({
			id:'txtCgpfa_codigo',
			name:'txtCgpfa_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false,
			submitValue:false
	});
	/**
	* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PERFIL PROFESIONAL
	*/
	var txtCgppr_codigo = new Ext.form.TextField({
			id:'txtCgppr_codigo',
			name:'txtCgppr_codigo',
			fieldLabel :'Codigo Perfil',
			anchor:'98%',
			allowBlank :false,
			submitValue:false
	});
	/**
	* Ext.form.TextArea CAMPO DE TEXTO DE UNA DESCRIPCION DE DOCUMENTO
	*/
	var txtCgpfa_descripcion = new Ext.form.TextArea({
			id:'txtCgpfa_descripcion',
			name:'txtCgpfa_descripcion',
			fieldLabel :'Descripcion',
			width:'90%',
			allowBlank :false,
			submitValue:false
	});
	/**
	* Ext.form.TextField NOMBRE DEL DOCUMENTO ADJUNTO
	*/
	var txtCgpfa_nombre_adjunto = new Ext.form.TextField({
			id:'txtCgpfa_nombre_adjunto',
			name:'txtCgpfa_nombre_adjunto',
			fieldLabel :'Nombre adjunto',
			anchor:'98%',
			allowBlank :false,
			submitValue:false
	});
	/**
	* Ext.form.TextField NO ESPECIFICADO
	*/
	var txtCgpfa_tipo_adjunto = new Ext.form.TextField({
			id:'txtCgpfa_tipo_adjunto',
			name:'txtCgpfa_tipo_adjunto',
			fieldLabel :'Tipo adjunto',
			anchor:'98%',
			allowBlank :false,
			submitValue:false
	});
	/**
	* CONTENIDO BINARIO DEL DOCUMENTO ADJUNTO
	*/
	var cgpfa_adjunto = new Ext.form.FileUploadField({
			id:'cgpfa_adjunto',
			name:'cgpfa_adjunto',
			fieldLabel :'Adjunto',
			anchor:'98%',
			disabled :false,
			buttonCfg: {
				text: '',
				iconCls: 'iconAdjunto'
			},
			listeners: {
				'fileselected': function(fb, v){
					txtCgpfa_nombre_adjunto.setValue(cgpfa_adjunto.getValue())
				}
			}
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_gem_perfil_adjunto
	*/
	var btnGuardarCgg_gem_perfil_adjunto = new Ext.Button({
			id:'btnGuardarCgg_gem_perfil_adjunto',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (!pnlCgg_gem_perfil_adjunto.getForm().isValid()){
						return;
					}
					var a = txtCgpfa_nombre_adjunto.getValue().split('\\');
					var b = txtCgpfa_nombre_adjunto.getValue().split('.');
					//alert(b[b.length-1]);
					pnlCgg_gem_perfil_adjunto.getForm().submit({
							url: URL_WS+"Cgg_gem_perfil_adjuntoSRV",
							waitMsg: 'Enviando formulario...',
							success: function(fp, o){
								Ext.Msg.show({
										title:tituloCgg_gem_perfil_adjunto,
										msg: 'El adjunto ha sido almacenado correctamente.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});
								winFrmCgg_gem_perfil_adjunto.close();
							},
							failure:function(r){
								Ext.Msg.show({
										title:tituloCgg_gem_perfil_adjunto,
										msg: 'El adjunto no ha podido ser almacenado.'+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							},
							params: {request:inSentenciaCgg_gem_perfil_adjunto,
									cgpfa_codigo: txtCgpfa_codigo.getValue(),
									//cgppr_codigo: txtCgppr_codigo.getValue(),
									crper_codigo: codigoPersona,
									cgpfa_tipo : tipoAdjunto,
									cgpfa_descripcion: txtCgpfa_descripcion.getValue(),
									cgpfa_nombre_adjunto: a[a.length-1],
									cgpfa_tipo_adjunto: b[b.length-1]
							}
					});
				}
			}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_gem_perfil_adjunto.
	*/
	var btnCancelarCgg_gem_perfil_adjunto = new Ext.Button({
			id:'btnCancelarCgg_gem_perfil_adjunto',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_gem_perfil_adjunto.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_gem_perfil_adjunto.
	*/
	var btnCerrarCgg_gem_perfil_adjunto = new Ext.Button({
			id:'btnCerrarCgg_gem_perfil_adjunto',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_gem_perfil_adjunto.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_gem_perfil_adjunto.
	*/
	var pnlCgg_gem_perfil_adjunto = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,			
			items:[txtCgpfa_codigo,
				//txtCgppr_codigo,
				cgpfa_adjunto,
				txtCgpfa_descripcion
				//txtCgpfa_nombre_adjunto
				//txtCgpfa_tipo_adjunto
			],
			fileUpload:true
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_gem_perfil_adjunto.
	*/
	var winFrmCgg_gem_perfil_adjunto = new Ext.Window({
			id:'winFrmCgg_gem_perfil_adjunto',
			title:tituloCgg_gem_perfil_adjunto,
			iconCls:'iconAplicacion',
			width:400,
			minWidth:400,
			maximizable:false,
			minimizable:false,			
			modal:true,
			constrainHeader:true,
			tbar:getPanelTitulo(tituloCgg_gem_perfil_adjunto,descCgg_gem_perfil_adjunto),
			items:[pnlCgg_gem_perfil_adjunto],
			bbar:[btnGuardarCgg_gem_perfil_adjunto,btnCancelarCgg_gem_perfil_adjunto,'->',btnCerrarCgg_gem_perfil_adjunto]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmCgg_gem_perfil_adjunto.getBottomToolbar());	
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_gem_perfil_adjunto.
	*/
	function cargarCgg_gem_perfil_adjuntoCtrls(){
		if(inRecordCgg_gem_perfil_adjunto){
			txtCgpfa_codigo.setValue(inRecordCgg_gem_perfil_adjunto.get('CGPFA_CODIGO'));
			//txtCgppr_codigo.setValue(inRecordCgg_gem_perfil_adjunto.get('CGPPR_CODIGO'));
			codigoPerfil = inRecordCgg_gem_perfil_adjunto.get('CGPPR_CODIGO');
			txtCgpfa_descripcion.setValue(inRecordCgg_gem_perfil_adjunto.get('CGPFA_DESCRIPCION'));
			txtCgpfa_nombre_adjunto.setValue(inRecordCgg_gem_perfil_adjunto.get('CGPFA_NOMBRE_ADJUNTO'));
			cgpfa_adjunto.setValue(inRecordCgg_gem_perfil_adjunto.get('CGPFA_NOMBRE_ADJUNTO'))
			txtCgpfa_tipo_adjunto.setValue(inRecordCgg_gem_perfil_adjunto.get('CGPFA_TIPO_ADJUNTO'));			
			isEdit = true;			
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_gem_perfil_adjunto.
	* @returns ventana winFrmCgg_gem_perfil_adjunto.
	* @base FrmCgg_gem_perfil_adjunto.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_gem_perfil_adjunto;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_gem_perfil_adjunto.
	* @base FrmCgg_gem_perfil_adjunto.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_gem_perfil_adjuntoCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_gem_perfil_adjunto desde una instancia.
*/
FrmCgg_gem_perfil_adjunto.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_gem_perfil_adjunto desde una instancia.
*/
FrmCgg_gem_perfil_adjunto.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_gem_perfil_adjunto,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_gem_perfil_adjunto.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_gem_perfil_adjunto desde una instancia.
*/
FrmCgg_gem_perfil_adjunto.prototype.loadData = function(){
	this.loadData();
}
