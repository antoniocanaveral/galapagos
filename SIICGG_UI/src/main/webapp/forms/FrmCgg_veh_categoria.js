/**
* Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_veh_categoria.
* @param {String} IN_SENTENCIA_CGG_VEH_CATEGORIA Sentencia (insert/update) para el tratamiento de la informacion.
* @param {Ext.data.Record} IN_RECORD_CGG_VEH_CATEGORIA Registro de datos de la tabla Cgg_veh_categoria.
* @constructor
* @base FrmListadoCgg_veh_categoria
* @author Besixplus Cia. Ltda.
*/
function FrmCgg_veh_categoria(IN_SENTENCIA_CGG_VEH_CATEGORIA,IN_RECORD_CGG_VEH_CATEGORIA){
	var inSentenciaCgg_veh_categoria = IN_SENTENCIA_CGG_VEH_CATEGORIA;
	var inRecordCgg_veh_categoria=IN_RECORD_CGG_VEH_CATEGORIA;
	var urlCgg_veh_categoria=URL_WS+"Cgg_veh_categoria";
	var tituloCgg_veh_categoria='Categor\u00eda';
	var descCgg_veh_categoria='El formulario permite administrar la informaci\u00f3n de las categorias que pertencen los veh\u00edculos.';
	var isEdit = false;
	var tmpCatPadre;
	/**
	* Ext.form.TextField IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
	*/
	var txtCvctg_codigo = new Ext.form.TextField({
			id:'txtCvctg_codigo',
			name:'txtCvctg_codigo',
			fieldLabel :'Codigo',
			anchor:'98%',
			value:"KEYGEN",
			hidden:true,
			hideLabel:true,
			allowBlank :false
	});
	/**
	* Ext.form.TextField IDENTIFICADOR UNICO DE REGISTRO  DE CATEGORIA RELACIONADO.
	*/
	var txtCgg_cvctg_codigo = new Ext.form.TextField({
			id:'txtCgg_cvctg_codigo',
			name:'txtCgg_cvctg_codigo',
			fieldLabel :'Categor\u00eda padre',
			anchor:'98%',
			readOnly:'true'
	});
	/**
	* IDENTIFICADOR UNICO DE REGISTRO  DE CATEGORIA RELACIONADO.
	*/
	var btnCgg_cvctg_codigoCgg_veh_categoria = new Ext.Button({
			id:'btnCgg_cvctg_codigoCgg_veh_categoria',
			iconCls:'iconBuscar',
			listeners:{
				click:function(){
					var tmpFLCgg_veh_categoria = new FrmListadoCgg_veh_categoria();
					var objBusqueda = new DlgBusqueda(tmpFLCgg_veh_categoria.getStore(),tmpFLCgg_veh_categoria.getColumnModel());
					objBusqueda.closeHandler(function(){
							var tmpRecord = objBusqueda.getSelectedRow();
							if(tmpRecord){
								tmpCatPadre = tmpRecord.get('CVCTG_CODIGO');
								txtCgg_cvctg_codigo.setValue(tmpRecord.get('CVCTG_NOMBRE'));
							}
					});
					objBusqueda.show();
			}}
	});
	/**
	* Ext.form.TextField NOMBRE DESCRIPTIVO DE LA CATEGORIA.
	*/
	var txtCvctg_nombre = new Ext.form.TextField({
			id:'txtCvctg_nombre',
			name:'txtCvctg_nombre',
			fieldLabel :'Nombre',
			anchor:'98%',
			allowBlank :false
	});
	/**
	* Ext.form.TextArea INFORMACION ADICIONAL
	*/
	var txtCvctg_observacion = new Ext.form.TextArea({
			id:'txtCvctg_observacion',
			name:'txtCvctg_observacion',
			fieldLabel :'Observaci\u00f3n',
			width:'98%'
	});
	/**
	* Boton que permite almacenar la informacion de la ventana winFrmCgg_veh_categoria
	*/
	var btnGuardarCgg_veh_categoria = new Ext.Button({
			id:'btnGuardarCgg_veh_categoria',
			text:'Guardar',
			iconCls:'iconGuardar',
			listeners:{
				click:function(){
					if (pnlCgg_veh_categoria.getForm().isValid()==false){
						return;
					}
					try{
						function CallBackCgg_veh_categoria(r){
							winFrmCgg_veh_categoria.getEl().unmask();
							if(r=='true'){
								Ext.Msg.show({
										title:tituloCgg_veh_categoria,
										msg: 'La informaci\u00f3n de Categor\u00eda ha sido almacenada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
								});winFrmCgg_veh_categoria.close()
							}else{
								Ext.Msg.show({
										title:tituloCgg_veh_categoria,
										msg: 'La informaci\u00f3n de Categor\u00eda no ha podido ser almacenada. '+(r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
								});
							}
						}
						winFrmCgg_veh_categoria.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						if(isEdit)
							param.add('inCvctg_codigo',txtCvctg_codigo.getValue());
						param.add('inCgg_cvctg_codigo',tmpCatPadre?tmpCatPadre:null);
						param.add('inCvctg_nombre',txtCvctg_nombre.getValue());
						param.add('inCvctg_observacion',txtCvctg_observacion.getValue());
						SOAPClient.invoke(urlCgg_veh_categoria,IN_SENTENCIA_CGG_VEH_CATEGORIA,param, true, CallBackCgg_veh_categoria);
					}catch(inErr){
						winFrmCgg_veh_categoria.getEl().unmask();
					}
			}}
	});
	/**
	* Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_veh_categoria.
	*/
	var btnCancelarCgg_veh_categoria = new Ext.Button({
			id:'btnCancelarCgg_veh_categoria',
			text:'Cancelar',
			iconCls:'iconCancelar',
			listeners:{
				click:function(){
					pnlCgg_veh_categoria.getForm().reset();
			}}
	});
	/**
	* Boton que permite cerrar la ventana winFrmCgg_veh_categoria.
	*/
	var btnCerrarCgg_veh_categoria = new Ext.Button({
			id:'btnCerrarCgg_veh_categoria',
			text:'Cerrar',
			iconCls:'iconCerrar',
			listeners:{
				click:function(){
					winFrmCgg_veh_categoria.close();
			}}
	});
	/**
	* Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_veh_categoria.
	*/
	var pnlCgg_veh_categoria = new Ext.form.FormPanel({
			frame:true,
			labelWidth :100,
			items:[txtCvctg_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.92,layout:'form',items:[txtCgg_cvctg_codigo]},{columnWidth:.08,layout:'form',items:[btnCgg_cvctg_codigoCgg_veh_categoria]}]},txtCvctg_nombre,txtCvctg_observacion]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_veh_categoria.
	*/
	var winFrmCgg_veh_categoria = new Ext.Window({
			id:'winFrmCgg_veh_categoria',
			title:tituloCgg_veh_categoria,
			width:400,
			minWidth:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			tbar:getPanelTitulo(tituloCgg_veh_categoria,descCgg_veh_categoria),
			items:[pnlCgg_veh_categoria],
			bbar:[btnGuardarCgg_veh_categoria,btnCancelarCgg_veh_categoria,'->',btnCerrarCgg_veh_categoria]
	});
	/**
	* Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_veh_categoria.
	* @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	*/
	function habilitarCgg_veh_categoriaCtrls(inEstado){
		estado=!inEstado;
		txtCvctg_codigo.setDisabled(estado);
		txtCgg_cvctg_codigo.setDisabled(estado);
		txtCvctg_nombre.setDisabled(estado);
		txtCvctg_observacion.setDisabled(estado);
	}
	/**
	* Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_veh_categoria.
	*/
	function cargarCgg_veh_categoriaCtrls(){
		if(inRecordCgg_veh_categoria){
			tmpCatPadre = inRecordCgg_veh_categoria.get('CGG_CVCTG_CODIGO');
			txtCvctg_codigo.setValue(inRecordCgg_veh_categoria.get('CVCTG_CODIGO'));
			txtCgg_cvctg_codigo.setValue(inRecordCgg_veh_categoria.get('CATEGORIA'));
			txtCvctg_nombre.setValue(inRecordCgg_veh_categoria.get('CVCTG_NOMBRE'));
			txtCvctg_observacion.setValue(inRecordCgg_veh_categoria.get('CVCTG_OBSERVACION'));
			isEdit = true;
			habilitarCgg_veh_categoriaCtrls(true);
	}}
	/**
	* Funcion miembro que devuelve la ventana winFrmCgg_veh_categoria.
	* @returns ventana winFrmCgg_veh_categoria.
	* @base FrmCgg_veh_categoria.prototype.show
	*/
	this.getWindow = function(){
		return winFrmCgg_veh_categoria;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmCgg_veh_categoria.
	* @base FrmCgg_veh_categoria.prototype.loadData
	*/
	this.loadData = function(){
		cargarCgg_veh_categoriaCtrls();
}}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmCgg_veh_categoria desde una instancia.
*/
FrmCgg_veh_categoria.prototype.show = function(){
	this.getWindow().show();
}
/**
*Funcion prototipo. Permite cerrar la ventana winFrmCgg_veh_categoria desde una instancia.
*/
FrmCgg_veh_categoria.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_veh_categoria,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmCgg_veh_categoria.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_veh_categoria desde una instancia.
*/
FrmCgg_veh_categoria.prototype.loadData = function(){
	this.loadData();
}
