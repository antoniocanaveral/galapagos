/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_sector_productivo.
 * @param {String} INSENTENCIA_CGG_SECTOR_PRODUCTIVO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_SECTOR_PRODUCTIVO Registro de datos de la tabla Cgg_sector_productivo.
 * @constructor
 * @base FrmListadoCgg_sector_productivo
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_sector_productivo(INSENTENCIA_CGG_SECTOR_PRODUCTIVO,INRECORD_CGG_SECTOR_PRODUCTIVO){
	var inSentenciaCgg_sector_productivo = INSENTENCIA_CGG_SECTOR_PRODUCTIVO;
	var inRecordCgg_sector_productivo=INRECORD_CGG_SECTOR_PRODUCTIVO;
	var urlCgg_sector_productivo=URL_WS+"Cgg_sector_productivo";
	var tituloCgg_sector_productivo='Sector productivo';
	var descCgg_sector_productivo='El formulario permite ingresar informaci\u00f3n del sector productivo';
	var isEdit = false;
	var tmpSectorProductivo = null;
	
	/**
	 * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
	 */
	var txtCsctp_codigo = new Ext.form.TextField({
		id:'txtCsctp_codigo',
		name:'txtCsctp_codigo',
		fieldLabel :'Codigo',
		anchor:'98%',
		allowBlank :false,
		value:"KEYGEN",
		hidden:true,
		hideLabel:true,
		maxLength :20
	});
	/**
	 * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO RELACIONADO
	 */
	var txtCgg_csctp_codigo = new Ext.form.TextField({
		id:'txtCgg_csctp_codigo',
		name:'txtCgg_csctp_codigo',
		fieldLabel :'Sector',
		anchor:'98%',
		//allowBlank :false,		
		readOnly:'true',
		maxLength :20
	});
	/**
	 * IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO RELACIONADO
	 */
	var btnCgg_csctp_codigoCgg_sector_productivo = new Ext.Button({
		id:'btnCgg_csctp_codigoCgg_sector_productivo',		
		iconCls:'iconBuscar',
                tooltip:'Buscar sector productivo',
		listeners:{
		click:function(){
		var tmpFLCgg_sector_productivo = new FrmListadoCgg_sector_productivo();
		var objBusqueda = new DlgBusqueda(tmpFLCgg_sector_productivo.getStore(),tmpFLCgg_sector_productivo.getColumnModel());
		objBusqueda.closeHandler(function(){
			var tmpRecord = objBusqueda.getSelectedRow();
			if(tmpRecord!=null && tmpRecord!=undefined)
                            {
			    txtCgg_csctp_codigo.setValue(tmpRecord.get('CSCTP_NOMBRE'));
			    tmpSectorProductivo=tmpRecord.get('CSCTP_CODIGO');
                            }
		});
		objBusqueda.show();
	}}
	});
	/**
	 * Ext.form.TextField NOMBRE DEL SECTOR PRODUCTIVO
	 */
	var txtCsctp_nombre = new Ext.form.TextField({
		id:'txtCsctp_nombre',
		name:'txtCsctp_nombre',
		fieldLabel :'Nombre',
		anchor:'98%',
		allowBlank :false,
		maxLength :20
	});

        /**
        * Ext.form.TextField ALMACENA LA DESCRIPCION DEL SECTOR PRODUCTIVO
        */
        var txtCsctp_descripcion = new Ext.form.TextField({
        id:'txtCsctp_descripcion',
        name:'txtCsctp_descripcion',
        fieldLabel :'Descripci\u00F3n',
        anchor:'98%',
        allowBlank :true
        });
	/**
	 * Boton que permite almacenar la informacion de la ventana winFrmCgg_sector_productivo
	 */
	var btnGuardarCgg_sector_productivo = new Ext.Button({
		id:'btnGuardarCgg_sector_productivo',
		text:'Guardar',
		iconCls:'iconGuardar',
                tooltip:'Guardar sector productivo',
		listeners:{
		click:function(){
		if (pnlCgg_sector_productivo.getForm().isValid()==false){
			return;
		}
		try{
			function CallBackCgg_sector_productivo(r){
				winFrmCgg_sector_productivo.getEl().unmask();
				if(r=='true'){
					Ext.Msg.show({
						title:tituloCgg_sector_productivo,
						msg: 'La informaci\u00f3n de sector productivo ha sido almacenada.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.INFO
					});winFrmCgg_sector_productivo.close()
				}else{
					Ext.Msg.show({
						title:tituloCgg_sector_productivo,
						msg: 'La informaci\u00f3n de sector productivo no ha podido ser almacenada.',
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
				}
			}
			winFrmCgg_sector_productivo.getEl().mask('Guardando...', 'x-mask-loading');
			var param = new SOAPClientParameters();
			if(isEdit)
			param.add('inCsctp_codigo',txtCsctp_codigo.getValue());			
			param.add('inCgg_csctp_codigo',tmpSectorProductivo);
			param.add('inCsctp_nombre',txtCsctp_nombre.getValue());
                        param.add('inCsctp_descripcion',txtCsctp_descripcion.getValue());
			SOAPClient.invoke(urlCgg_sector_productivo,INSENTENCIA_CGG_SECTOR_PRODUCTIVO,param, true, CallBackCgg_sector_productivo);
		}catch(inErr){
			winFrmCgg_sector_productivo.getEl().unmask();
		}
	}}
	});
	/**
	 * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_sector_productivo.
	 */
	var btnCancelarCgg_sector_productivo = new Ext.Button({
		id:'btnCancelarCgg_sector_productivo',
		text:'Cancelar',
		iconCls:'iconCancelar',
                tooltip:'Cancelar informaci\u00F3n',
		listeners:{
		click:function(){
		pnlCgg_sector_productivo.getForm().reset();
	}}
	});
	/**
	 * Boton que permite cerrar la ventana winFrmCgg_sector_productivo.
	 */
	var btnCerrarCgg_sector_productivo = new Ext.Button({
		id:'btnCerrarCgg_sector_productivo',
		text:'Cerrar',
		iconCls:'iconCerrar',
                tooltip:'Cerrar formulario',
		listeners:{
		click:function(){
		winFrmCgg_sector_productivo.close();
	}}
	});
	/**
	 * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_sector_productivo.
	 */
        var pnlCgg_sector_productivo = new Ext.form.FormPanel({
            frame:true,
            labelWidth :100,
            items:[txtCsctp_codigo,{
                xtype:'panel',
                layout:'column',
                anchor:'100%',
                items:[{
                    columnWidth:.9,
                    layout:'form',
                    items:[txtCgg_csctp_codigo]
                    },{
                    columnWidth:.1,
                    layout:'form',
                    items:[btnCgg_csctp_codigoCgg_sector_productivo]
                    }]
                },txtCsctp_nombre,txtCsctp_descripcion]
        });
    /**
	 * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_sector_productivo.
	 */
	var winFrmCgg_sector_productivo = new Ext.Window({
		id:'winFrmCgg_sector_productivo',
		title:tituloCgg_sector_productivo,
		tbar:getPanelTitulo(tituloCgg_sector_productivo,descCgg_sector_productivo),
		items:[pnlCgg_sector_productivo],
		width:400,
		minWidth:400,

		maximizable:true,
		minimizable:true,
		constrain:true,
		bbar:[btnGuardarCgg_sector_productivo,btnCancelarCgg_sector_productivo,'->',btnCerrarCgg_sector_productivo]
	});
	/**
	 * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_sector_productivo.
	 * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
	 */
	function habilitarCgg_sector_productivoCtrls(inEstado){
		estado=!inEstado;
		txtCsctp_codigo.setDisabled(estado);
		txtCgg_csctp_codigo.setDisabled(estado);
		txtCsctp_nombre.setDisabled(estado);
                txtCsctp_descripcion.setDisabled(estado);
	}
	/**
	 * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_sector_productivo.
	 */
	function cargarCgg_sector_productivoCtrls(){
		if(inRecordCgg_sector_productivo){
			txtCsctp_codigo.setValue(inRecordCgg_sector_productivo.get('CSCTP_CODIGO'));
			txtCgg_csctp_codigo.setValue(inRecordCgg_sector_productivo.get('CGG_CSCTP_CODIGO'));
			txtCsctp_nombre.setValue(inRecordCgg_sector_productivo.get('CSCTP_NOMBRE'));
                        txtCsctp_descripcion.setValue(inRecordCgg_sector_productivo.get('CSCTP_DESCRIPCION'));
			isEdit = true;
			habilitarCgg_sector_productivoCtrls(true);
		}}
	/**
	 * Funcion miembro que devuelve la ventana winFrmCgg_sector_productivo.
	 * @returns ventana winFrmCgg_sector_productivo.
	 * @base FrmCgg_sector_productivo.prototype.show
	 */
	this.getWindow = function(){
		return winFrmCgg_sector_productivo;
	}
	/**
	 * Funcion miembro que carga los controles de la ventana winFrmCgg_sector_productivo.
	 * @base FrmCgg_sector_productivo.prototype.loadData
	 */
	this.loadData = function(){
		cargarCgg_sector_productivoCtrls();
	}}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_sector_productivo desde una instancia.
 */
FrmCgg_sector_productivo.prototype.show = function(){
	this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_sector_productivo desde una instancia.
 */
FrmCgg_sector_productivo.prototype.close = function(){
	this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_sector_productivo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_sector_productivo.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_sector_productivo desde una instancia.
 */
FrmCgg_sector_productivo.prototype.loadData = function(){
	this.loadData();
}
