/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_especie.
 * @param {String} INSENTENCIA_CGG_KDX_ESPECIE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_KDX_ESPECIE Registro de datos de la tabla Cgg_kdx_especie.
 * @constructor
 * @base FrmListadoCgg_kdx_especie
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_kdx_especie(INSENTENCIA_CGG_KDX_ESPECIE,INRECORD_CGG_KDX_ESPECIE){
    var inSentenciaCgg_kdx_especie = INSENTENCIA_CGG_KDX_ESPECIE;
    var inRecordCgg_kdx_especie=INRECORD_CGG_KDX_ESPECIE;
    var urlCgg_kdx_especie=URL_WS+"Cgg_kdx_especie";
    var tituloCgg_kdx_especie='Especie';
    var descCgg_kdx_especie='El formulario permite administrar informaci\u00f3n de Especie';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ESPECIES
     */
    var txtCkesp_codigo = new Ext.form.TextField({
        id:'txtCkesp_codigo',
        name:'txtCkesp_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField NOMBRE DEL TIPO DE ESPECIE
     */
    var txtCkesp_nombre = new Ext.form.TextField({
        id:'txtCkesp_nombre',
        name:'txtCkesp_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false

    });
    /**
     * Ext.form.NumberField VALOR DE VENTA DE LA ESPECIE
     */
    var spfCkesp_precio = new Ext.ux.form.SpinnerField({
        id:'spfCkesp_precio',
        name:'spfCkesp_precio',
        fieldLabel :'Precio',
        anchor:'60%',
        allowBlank :false,
        disabled :false,
        value:'0',
        minValue: 0,
        maxValue: 100,
        allowDecimals: true,
        allowNegative: false,
        decimalPrecision: 1,
        incrementValue: 0.5,
        alternateIncrementValue: 1,
        accelerate: true
    });



    /**
     * Ext.form.NumberField CANTIDAD DISPONIBLE DE LA ESPECIE
     */
    var numCkesp_cantidad = new Ext.form.NumberField({
        id:'numCkesp_cantidad',
        name:'numCkesp_cantidad',
        fieldLabel :'Inventario',
        allowBlank :true,
        value:0,
        anchor:'60%',
        readOnly : true
    });
    /**
     * Ext.form.NumberField CANTIDAD MINIMA DE DISPONIBILIDAD
     */
     var spfCkesp_disponible_min = new Ext.ux.form.SpinnerField({
        id:'spfCkesp_disponible_min',
        name:'spfCkesp_disponible_min',
        fieldLabel :'Stock min',
        anchor:'60%',
        allowBlank :false,
        disabled :false,
        value:'0',
        minValue: 0,
        maxValue: 5000,
        allowDecimals: false,
        allowNegative: false,
        decimalPrecision: 1,
        incrementValue: 10,
        alternateIncrementValue: 10,
        accelerate: true
    });

    /**
     * Ext.form.NumberField CANTIDAD MAXIMA DE DISPONIBILIDAD
     */
     var spfCkesp_disponible_max = new Ext.ux.form.SpinnerField({
        id:'spfCkesp_disponible_max',
        name:'spfCkesp_disponible_max',
        fieldLabel :'Stock max',
        anchor:'60%',
        allowBlank :true,
        disabled :false,
        value:'0',
        minValue: 0,
        //maxValue: 1000,
        allowDecimals: false,
        allowNegative: false,
        decimalPrecision: 1,
        incrementValue: 10,
        alternateIncrementValue: 10,
        accelerate: true
    });
    /**
     * Ext.form.NumberField TIPO DE ESPECIE
     0 - RESIDENCIA
     1 - TCT
     2 - OTROS
     */
    var cbxCkesp_tipo = new Ext.form.ComboBox({
        id:'cbxCkesp_tipo',
        store: dsTipoEspecie,
        fieldLabel :'Tipo especie',
        typeAhead: true,
        mode:'local',
        forceSelection:true,
        triggerAction:'all',
        value:TypeEspecie.TCT,
        anchor:'60%',
        emptyText:'Seleccione un tipo',
        selectOnFocus:true
    });
	/**
	* Ext.form.NumberField INDICE DE LA ESPECIE DENTRO DE LA CATEGORIA
	*/
	var numCkesp_indice = new Ext.form.NumberField({
			id:'numCkesp_indice',
			name:'numCkesp_indice',
			fieldLabel :'Indice',
			allowBlank :false,
			disabled :false
	});
	/**
	* Ext.form.TextField NOMBRE DEL REPORTE QUE SE APLICA A ESTA ESPECIE
	*/
	var txtCkesp_reporte = new Ext.form.TextField({
			id:'txtCkesp_reporte',
			name:'txtCkesp_reporte',
			fieldLabel :'Reporte',
			anchor:'98%'
	});
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_especie
     */
    var btnGuardarCgg_kdx_especie = new Ext.Button({
        id:'btnGuardarCgg_kdx_especie',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_kdx_especie.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_kdx_especie(r){
                        winFrmCgg_kdx_especie.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_kdx_especie,
                                msg: 'La informaci\u00f3n de Especie  ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_kdx_especie.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_kdx_especie,
                                msg: 'La informaci\u00f3n de Especie no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_kdx_especie.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCkesp_codigo',txtCkesp_codigo.getValue());
                    param.add('inCkesp_nombre',txtCkesp_nombre.getValue());
                    param.add('inCkesp_precio',spfCkesp_precio.getValue());
                    param.add('inCkesp_cantidad',numCkesp_cantidad.getValue());
                    param.add('inCkesp_disponible_min',spfCkesp_disponible_min.getValue());
                    param.add('inCkesp_disponible_max',spfCkesp_disponible_max.getValue());
                    param.add('inCkesp_tipo',cbxCkesp_tipo.getValue());
                    param.add('inCkesp_indice',numCkesp_indice.getValue());
					param.add('inCkesp_reporte',txtCkesp_reporte.getValue());
					SOAPClient.invoke(urlCgg_kdx_especie,INSENTENCIA_CGG_KDX_ESPECIE,param, true, CallBackCgg_kdx_especie);
                }catch(inErr){
                    winFrmCgg_kdx_especie.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_especie.
     */
    var btnCancelarCgg_kdx_especie = new Ext.Button({
        id:'btnCancelarCgg_kdx_especie',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_kdx_especie.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_kdx_especie.
     */
    var btnCerrarCgg_kdx_especie = new Ext.Button({
        id:'btnCerrarCgg_kdx_especie',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_kdx_especie.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_especie.
     */
    var pnlCgg_kdx_especie = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCkesp_codigo,txtCkesp_nombre,spfCkesp_precio,numCkesp_cantidad,spfCkesp_disponible_min,spfCkesp_disponible_max,cbxCkesp_tipo,numCkesp_indice,txtCkesp_reporte]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_especie.
     */
    var winFrmCgg_kdx_especie = new Ext.Window({
        id:'winFrmCgg_kdx_especie',
        title:tituloCgg_kdx_especie,
        tbar:getPanelTitulo(tituloCgg_kdx_especie,descCgg_kdx_especie),
        items:[pnlCgg_kdx_especie],
        width:450,
        minWidth:450,
        maximizable:false,
        minimizable:false,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_kdx_especie,btnCancelarCgg_kdx_especie,'->',btnCerrarCgg_kdx_especie]
    });
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_especie.
     */
    function cargarCgg_kdx_especieCtrls(){
        if(inRecordCgg_kdx_especie){
            txtCkesp_codigo.setValue(inRecordCgg_kdx_especie.get('CKESP_CODIGO'));
            txtCkesp_nombre.setValue(inRecordCgg_kdx_especie.get('CKESP_NOMBRE'));
            spfCkesp_precio.setValue(inRecordCgg_kdx_especie.get('CKESP_PRECIO'));
            numCkesp_cantidad.setValue(inRecordCgg_kdx_especie.get('CKESP_CANTIDAD'));
            spfCkesp_disponible_min.setValue(inRecordCgg_kdx_especie.get('CKESP_DISPONIBLE_MIN'));
            spfCkesp_disponible_max.setValue(inRecordCgg_kdx_especie.get('CKESP_DISPONIBLE_MAX'));
            cbxCkesp_tipo.setValue(inRecordCgg_kdx_especie.get('CKESP_TIPO'));
            numCkesp_indice.setValue(inRecordCgg_kdx_especie.get('CKESP_INDICE'));
			txtCkesp_reporte.setValue(inRecordCgg_kdx_especie.get('CKESP_REPORTE'));
			isEdit = true;
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_kdx_especie.
     * @returns ventana winFrmCgg_kdx_especie.
     * @base FrmCgg_kdx_especie.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_kdx_especie;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_especie.
     * @base FrmCgg_kdx_especie.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_kdx_especieCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_especie desde una instancia.
 */
FrmCgg_kdx_especie.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_especie desde una instancia.
 */
FrmCgg_kdx_especie.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_especie,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_kdx_especie.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_especie desde una instancia.
 */
FrmCgg_kdx_especie.prototype.loadData = function(){
    this.loadData();
}
