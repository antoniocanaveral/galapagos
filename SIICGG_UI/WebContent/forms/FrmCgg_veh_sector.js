/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_veh_sector.
 * @param {String} INSENTENCIA_CGG_VEH_SECTOR Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_VEH_SECTOR Registro de datos de la tabla Cgg_veh_sector.
 * @constructor
 * @base FrmListadoCgg_veh_sector
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_veh_sector(INSENTENCIA_CGG_VEH_SECTOR,INRECORD_CGG_VEH_SECTOR){
	var inSentenciaCgg_veh_sector = INSENTENCIA_CGG_VEH_SECTOR;
	var inRecordCgg_veh_sector=INRECORD_CGG_VEH_SECTOR;
	var urlCgg_veh_sector=URL_WS+"Cgg_veh_sector";
	var tituloCgg_veh_sector='Registro veh\u00EDculo sector';
	var descCgg_veh_sector='El formulario permite ingresar informaci\u00f3n del veh\u00EDculo sector';
	var isEdit = false;
	/**
	 * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
	 */
	var txtCvsct_codigo = new Ext.form.TextField({
		id:'txtCvsct_codigo',
		name:'txtCvsct_codigo',
		fieldLabel :'Codigo',
		anchor:'98%',
		allowBlank :false,
		value:"KEYGEN",
		hidden:true,
		hideLabel:true,
		maxLength :20
	});
	/**
	 * Ext.form.TextField NOMBRE DESCRIPTIVO DEL SECTOR
	 */
	var txtCvsct_nombre = new Ext.form.TextField({
		id:'txtCvsct_nombre',
		name:'txtCvsct_nombre',
		fieldLabel :'Nombre',
		anchor:'98%',
		allowBlank :false,
		maxLength :20
	});
        /**
        * Ext.form.TextField DESCRIPCION DEL VEHICULO SECTOR
        */
        var txtCvsct_descripcion = new Ext.form.TextField({
        id:'txtCvsct_descripcion',
        name:'txtCvsct_descripcion',
        fieldLabel :'Descripci\u00F3n',
        anchor:'98%',
        allowBlank :true
        });
	/**
	 * Boton que permite almacenar la informacion de la ventana winFrmCgg_veh_sector
	 */
	var btnGuardarCgg_veh_sector = new Ext.Button({
		id:'btnGuardarCgg_veh_sector',
		text:'Guardar',
		iconCls:'iconGuardar',
                tooltip:'Guardar veh\u00EDculo sector',
		listeners:{
		click:function(){
		if (pnlCgg_veh_sector.getForm().isValid()==false){
			return;
		}
		try{
			function CallBackCgg_veh_sector(r){
				winFrmCgg_veh_sector.getEl().unmask();
				if(r=='true'){
					Ext.Msg.show({
						title:tituloCgg_veh_sector,
						msg: 'La informaci\u00f3n de veh\u00EDculo sector ha sido almacenada.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});winFrmCgg_veh_sector.close()
				}else{
					Ext.Msg.show({
						title:tituloCgg_veh_sector,
						msg: 'La informaci\u00f3n de veh\u00EDculo sector no ha podido ser almacenada. '+(r.message?r.message:r),
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
				}
			}
			winFrmCgg_veh_sector.getEl().mask('Guardando...', 'x-mask-loading');
			var param = new SOAPClientParameters();
			if(isEdit)
			param.add('inCvsct_codigo',txtCvsct_codigo.getValue());
			param.add('inCvsct_nombre',txtCvsct_nombre.getValue());
                        param.add('inCvsct_descripcion',txtCvsct_descripcion.getValue());
			SOAPClient.invoke(urlCgg_veh_sector,INSENTENCIA_CGG_VEH_SECTOR,param, true, CallBackCgg_veh_sector);
		}catch(inErr){
			winFrmCgg_veh_sector.getEl().unmask();
		}
	}}
	});
	/**
	 * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_veh_sector.
	 */
	var btnCancelarCgg_veh_sector = new Ext.Button({
		id:'btnCancelarCgg_veh_sector',
		text:'Cancelar',
		iconCls:'iconCancelar',
                tooltip:'Cancelar infrmaci\u00F3n',
		listeners:{
		click:function(){
		pnlCgg_veh_sector.getForm().reset();
	}}
	});
	/**
	 * Boton que permite cerrar la ventana winFrmCgg_veh_sector.
	 */
	var btnCerrarCgg_veh_sector = new Ext.Button({
		id:'btnCerrarCgg_veh_sector',
		text:'Cerrar',
		iconCls:'iconCerrar',
                tooltip:'Cerrar formulario',
		listeners:{
		click:function(){
		winFrmCgg_veh_sector.close();
	}}
	});
	/**
	 * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_veh_sector.
	 */
	var pnlCgg_veh_sector = new Ext.form.FormPanel({
		frame:true,
		labelWidth :100,
		items:[txtCvsct_codigo,txtCvsct_nombre,txtCvsct_descripcion]
	});
	/**
	 * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_veh_sector.
	 */
	var winFrmCgg_veh_sector = new Ext.Window({
		id:'winFrmCgg_veh_sector',
		title:tituloCgg_veh_sector,
		tbar:getPanelTitulo(tituloCgg_veh_sector,descCgg_veh_sector),
		items:[pnlCgg_veh_sector],
		width:400,
		minWidth:400,
		modal:true,
		resizable:false,
		maximizable:false,
		minimizable:false,
		constrain:true,
		bbar:[btnGuardarCgg_veh_sector,btnCancelarCgg_veh_sector,'->',btnCerrarCgg_veh_sector]
	});
	/**
	 * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_veh_sector.
	 * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	 */
	function habilitarCgg_veh_sectorCtrls(inEstado){
		estado=!inEstado;
		txtCvsct_codigo.setDisabled(estado);
		txtCvsct_nombre.setDisabled(estado);
                txtCvsct_descripcion.setDisabled(estado);
	}
	/**
	 * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_veh_sector.
	 */
	function cargarCgg_veh_sectorCtrls(){
		if(inRecordCgg_veh_sector){
			txtCvsct_codigo.setValue(inRecordCgg_veh_sector.get('CVSCT_CODIGO'));
			txtCvsct_nombre.setValue(inRecordCgg_veh_sector.get('CVSCT_NOMBRE'));
                        txtCvsct_descripcion.setValue(inRecordCgg_veh_sector.get('CVSCT_DESCRIPCION'));
			isEdit = true;
			habilitarCgg_veh_sectorCtrls(true);
		}}
	/**
	 * Funcion miembro que devuelve la ventana winFrmCgg_veh_sector.
	 * @returns ventana winFrmCgg_veh_sector.
	 * @base FrmCgg_veh_sector.prototype.show
	 */
	this.getWindow = function(){
		return winFrmCgg_veh_sector;
	}
	/**
	 * Funcion miembro que carga los controles de la ventana winFrmCgg_veh_sector.
	 * @base FrmCgg_veh_sector.prototype.loadData
	 */
	this.loadData = function(){
		cargarCgg_veh_sectorCtrls();
	}}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_veh_sector desde una instancia.
 */
FrmCgg_veh_sector.prototype.show = function(){
	this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_veh_sector desde una instancia.
 */
FrmCgg_veh_sector.prototype.close = function(){
	this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_veh_sector,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_veh_sector.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_veh_sector desde una instancia.
 */
FrmCgg_veh_sector.prototype.loadData = function(){
	this.loadData();
}
