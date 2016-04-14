/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_kdx_compra_detalle.
 * @param {String} IN_SENTENCIA_CGG_KDX_COMPRA_DETALLE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_KDX_COMPRA_DETALLE Registro de datos de la tabla Cgg_kdx_compra_detalle.
 * @constructor
 * @base FrmListadoCgg_kdx_compra_detalle
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_kdx_compra_detalle(IN_SENTENCIA_CGG_KDX_COMPRA_DETALLE,IN_RECORD_CGG_KDX_COMPRA_DETALLE){
    var inSentenciaCgg_kdx_compra_detalle = IN_SENTENCIA_CGG_KDX_COMPRA_DETALLE;
    var inRecordCgg_kdx_compra_detalle=IN_RECORD_CGG_KDX_COMPRA_DETALLE;
    var urlCgg_kdx_compra_detalle=URL_WS+"Cgg_kdx_compra_detalle";
    var tituloCgg_kdx_compra_detalle='Kdx compra detalle';
    var descCgg_kdx_compra_detalle='El formulario permite administrar la informaci\u00f3n de la tabla Kdx compra detalle';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA DETALLE
     */
    var txtCkcmd_codigo = new Ext.form.TextField({
        id:'txtCkcmd_codigo',
        name:'txtCkcmd_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA
     */
    var txtCkcmp_codigo = new Ext.form.TextField({
        id:'txtCkcmp_codigo',
        name:'txtCkcmp_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE COMPRA
     */
    var btnCkcmp_codigoCgg_kdx_compra_detalle = new Ext.Button({
        id:'btnCkcmp_codigoCgg_kdx_compra_detalle',
        text:'Ckcmp_codigo',
        iconCls:'iconCkcmp_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_kdx_compra = new FrmListadoCgg_kdx_compra();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_compra.getStore(),tmpFLCgg_kdx_compra.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCkcmp_codigo.setValue(tmpRecord.get('CKCMP_CODIGO'));
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCktes_codigo = new Ext.form.TextField({
        id:'txtCktes_codigo',
        name:'txtCktes_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true',
        allowBlank :false
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO
     */
    var btnCktes_codigoCgg_kdx_compra_detalle = new Ext.Button({
        id:'btnCktes_codigoCgg_kdx_compra_detalle',
        text:'Cktes_codigo',
        iconCls:'iconCktes_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_kdx_especie = new FrmListadoCgg_kdx_especie();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_kdx_especie.getStore(),tmpFLCgg_kdx_especie.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCktes_codigo.setValue(tmpRecord.get('CKTES_CODIGO'));
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.NumberField CANTIDAD DE ESPECIES
     */
    var numCkcmd_cantidad = new Ext.form.NumberField({
        id:'numCkcmd_cantidad',
        name:'numCkcmd_cantidad',
        fieldLabel :'Cantidad',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.NumberField PRECIO UNITARIO DE LA ESPECIE
     */
    var numCkcmd_precio_unitario = new Ext.form.NumberField({
        id:'numCkcmd_precio_unitario',
        name:'numCkcmd_precio_unitario',
        fieldLabel :'Precio unitario',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.NumberField TOTAL DE LA COMPRA
     */
    var numCkcmd_total = new Ext.form.NumberField({
        id:'numCkcmd_total',
        name:'numCkcmd_total',
        fieldLabel :'Total',
        allowBlank :false,
        disabled :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_kdx_compra_detalle
     */
    var btnGuardarCgg_kdx_compra_detalle = new Ext.Button({
        id:'btnGuardarCgg_kdx_compra_detalle',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_kdx_compra_detalle.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_kdx_compra_detalle(r){
                        winFrmCgg_kdx_compra_detalle.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_kdx_compra_detalle,
                                msg: 'La informaci\u00f3n de Kdx compra detalle ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_kdx_compra_detalle.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_kdx_compra_detalle,
                                msg: 'La informaci\u00f3n de Kdx compra detalle no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_kdx_compra_detalle.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCkcmd_codigo',txtCkcmd_codigo.getValue());
                    param.add('inCkcmp_codigo',txtCkcmp_codigo.getValue());
                    param.add('inCktes_codigo',txtCktes_codigo.getValue());
                    param.add('inCkcmd_cantidad',numCkcmd_cantidad.getValue());
                    param.add('inCkcmd_precio_unitario',numCkcmd_precio_unitario.getValue());
                    param.add('inCkcmd_total',numCkcmd_total.getValue());
                    SOAPClient.invoke(urlCgg_kdx_compra_detalle,IN_SENTENCIA_CGG_KDX_COMPRA_DETALLE,param, true, CallBackCgg_kdx_compra_detalle);
                }catch(inErr){
                    winFrmCgg_kdx_compra_detalle.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_kdx_compra_detalle.
     */
    var btnCancelarCgg_kdx_compra_detalle = new Ext.Button({
        id:'btnCancelarCgg_kdx_compra_detalle',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_kdx_compra_detalle.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_kdx_compra_detalle.
     */
    var btnCerrarCgg_kdx_compra_detalle = new Ext.Button({
        id:'btnCerrarCgg_kdx_compra_detalle',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_kdx_compra_detalle.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_kdx_compra_detalle.
     */
    var pnlCgg_kdx_compra_detalle = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCkcmd_codigo,{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCkcmp_codigo]},{columnWidth:.4,layout:'form',items:[btnCkcmp_codigoCgg_kdx_compra_detalle]}]},{xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCktes_codigo]},{columnWidth:.4,layout:'form',items:[btnCktes_codigoCgg_kdx_compra_detalle]}]},numCkcmd_cantidad,numCkcmd_precio_unitario,numCkcmd_total]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_kdx_compra_detalle.
     */
    var winFrmCgg_kdx_compra_detalle = new Ext.Window({
        id:'winFrmCgg_kdx_compra_detalle',
        title:tituloCgg_kdx_compra_detalle,
        width:400,
        minWidth:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_kdx_compra_detalle,descCgg_kdx_compra_detalle),
        items:[pnlCgg_kdx_compra_detalle],
        bbar:[btnGuardarCgg_kdx_compra_detalle,btnCancelarCgg_kdx_compra_detalle,'->',btnCerrarCgg_kdx_compra_detalle]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_kdx_compra_detalle.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_kdx_compra_detalleCtrls(inEstado){
        estado=!inEstado;
        txtCkcmd_codigo.setDisabled(estado);
        txtCkcmp_codigo.setDisabled(estado);
        txtCktes_codigo.setDisabled(estado);
        numCkcmd_cantidad.setDisabled(estado);
        numCkcmd_precio_unitario.setDisabled(estado);
        numCkcmd_total.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_kdx_compra_detalle.
     */
    function cargarCgg_kdx_compra_detalleCtrls(){
        if(inRecordCgg_kdx_compra_detalle){
            txtCkcmd_codigo.setValue(inRecordCgg_kdx_compra_detalle.get('CKCMD_CODIGO'));
            txtCkcmp_codigo.setValue(inRecordCgg_kdx_compra_detalle.get('CKCMP_CODIGO'));
            txtCktes_codigo.setValue(inRecordCgg_kdx_compra_detalle.get('CKTES_CODIGO'));
            numCkcmd_cantidad.setValue(inRecordCgg_kdx_compra_detalle.get('CKCMD_CANTIDAD'));
            numCkcmd_precio_unitario.setValue(inRecordCgg_kdx_compra_detalle.get('CKCMD_PRECIO_UNITARIO'));
            numCkcmd_total.setValue(inRecordCgg_kdx_compra_detalle.get('CKCMD_TOTAL'));
            isEdit = true;
            habilitarCgg_kdx_compra_detalleCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_kdx_compra_detalle.
     * @returns ventana winFrmCgg_kdx_compra_detalle.
     * @base FrmCgg_kdx_compra_detalle.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_kdx_compra_detalle;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_kdx_compra_detalle.
     * @base FrmCgg_kdx_compra_detalle.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_kdx_compra_detalleCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_kdx_compra_detalle desde una instancia.
 */
FrmCgg_kdx_compra_detalle.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_kdx_compra_detalle desde una instancia.
 */
FrmCgg_kdx_compra_detalle.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_kdx_compra_detalle,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_kdx_compra_detalle.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_kdx_compra_detalle desde una instancia.
 */
FrmCgg_kdx_compra_detalle.prototype.loadData = function(){
    this.loadData();
}
