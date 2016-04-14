/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_cargo_comite.
 * @param {String} INSENTENCIA_CGG_RES_CARGO_COMITE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_CARGO_COMITE Registro de datos de la tabla Cgg_res_cargo_comite.
 * @constructor
 * @base FrmListadoCgg_res_cargo_comite
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_cargo_comite(INSENTENCIA_CGG_RES_CARGO_COMITE,INRECORD_CGG_RES_CARGO_COMITE){
    var inSentenciaCgg_res_cargo_comite = INSENTENCIA_CGG_RES_CARGO_COMITE;
    var inRecordCgg_res_cargo_comite=INRECORD_CGG_RES_CARGO_COMITE;
    var urlCgg_res_cargo_comite=URL_WS+"Cgg_res_cargo_comite";
    var tituloCgg_res_cargo_comite='Cargo Comit\u00e9';
    var descCgg_res_cargo_comite='El formulario permite administrar informaci\u00f3n delCargo Comit\u00e9';
    var isEdit = false;
    var tmpCrcmcomite;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGSITRO
     */
    var txtCrcrg_codigo = new Ext.form.TextField({
        id:'txtCrcrg_codigo',
        name:'txtCrcrg_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrcom_codigo = new Ext.form.TextField({
        id:'txtCrcom_codigo',
        name:'txtCrcom_codigo',
        fieldLabel :'Comit\u00e9',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO
     */
    var btnCrcom_codigoCgg_res_cargo_comite = new Ext.Button({
        id:'btnCrcom_codigoCgg_res_cargo_comite',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_comite = new FrmListadoCgg_res_comite();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_comite.getStore(),tmpFLCgg_res_comite.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        tmpCrcmcomite= tmpRecord.get('CRCOM_CODIGO')
                        txtCrcom_codigo.setValue(tmpRecord.get('CRCOM_NOMBRE'));
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField DESCRIPCION DEL CARGO
     */
    var txtCrcrg_nombre = new Ext.form.TextField({
        id:'txtCrcrg_nombre',
        name:'txtCrcrg_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false
    });
	/**
	* Ext.form.Checkbox INDICADOR DE QUE EL CARGO ES PRINCIPAL
	*/
	var chkCrcrg_principal = new Ext.form.Checkbox({
			id:'chkCrcrg_principal',
			name:'chkCrcrg_principal',
			fieldLabel :'Principal',
			allowBlank :false,
			checked:true
	});
    /**
     * Ext.form.Checkbox ESTATUS QUE DETERMINA SI EL VOTO APLICADO POR EL REPRESENTANTE TIENE MAYOR INCIDENCIA EN CASOS ESPECIALES
     */
    var chkCrcrg_voto_dirimente = new Ext.form.Checkbox({
        id:'chkCrcrg_voto_dirimente',
        name:'chkCrcrg_voto_dirimente',
        fieldLabel :'Voto dirimente',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_cargo_comite
     */
    var btnGuardarCgg_res_cargo_comite = new Ext.Button({
        id:'btnGuardarCgg_res_cargo_comite',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_cargo_comite.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_cargo_comite(r){
                        winFrmCgg_res_cargo_comite.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_cargo_comite,
                                msg: 'La informaci\u00f3n del Cargo Comit\u00e9 ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_cargo_comite.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_cargo_comite,
                                msg: 'La informaci\u00f3n del Cargo Comit\u00e9 no ha podido ser almacenada. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_cargo_comite.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrcrg_codigo',txtCrcrg_codigo.getValue());
                    param.add('inCrcom_codigo',tmpCrcmcomite);
                    param.add('inCrcrg_nombre',txtCrcrg_nombre.getValue());
					param.add('inCrcrg_principal',chkCrcrg_principal.getValue());
                    param.add('inCrcrg_voto_dirimente',chkCrcrg_voto_dirimente.getValue());
                    SOAPClient.invoke(urlCgg_res_cargo_comite,INSENTENCIA_CGG_RES_CARGO_COMITE,param, true, CallBackCgg_res_cargo_comite);
                }catch(inErr){
                    winFrmCgg_res_cargo_comite.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_cargo_comite.
     */
    var btnCancelarCgg_res_cargo_comite = new Ext.Button({
        id:'btnCancelarCgg_res_cargo_comite',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_cargo_comite.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_cargo_comite.
     */
    var btnCerrarCgg_res_cargo_comite = new Ext.Button({
        id:'btnCerrarCgg_res_cargo_comite',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_cargo_comite.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_cargo_comite.
     */
    var pnlCgg_res_cargo_comite = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCrcrg_codigo,{xtype:'panel',layout:'column',
            items:[{columnWidth:.92,layout:'form',items:[txtCrcom_codigo]},{columnWidth:.08,layout:'form',items:[btnCrcom_codigoCgg_res_cargo_comite]}]},txtCrcrg_nombre,chkCrcrg_principal,chkCrcrg_voto_dirimente]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_cargo_comite.
     */
    var winFrmCgg_res_cargo_comite = new Ext.Window({
        id:'winFrmCgg_res_cargo_comite',
        title:tituloCgg_res_cargo_comite,
        tbar:getPanelTitulo(tituloCgg_res_cargo_comite,descCgg_res_cargo_comite),
        items:[pnlCgg_res_cargo_comite],
        width:400,
        modal:true,
        resizable:false,
        minWidth:400,
        resizable:false,
        maximizable:false,
        minimizable:true,
        constrain:true,
        bbar:[btnGuardarCgg_res_cargo_comite,btnCancelarCgg_res_cargo_comite,'->',btnCerrarCgg_res_cargo_comite]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_cargo_comite.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_cargo_comiteCtrls(inEstado){
        estado=!inEstado;
        txtCrcrg_codigo.setDisabled(estado);
        txtCrcom_codigo.setDisabled(estado);
        txtCrcrg_nombre.setDisabled(estado);
        chkCrcrg_voto_dirimente.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_cargo_comite.
     */
    function cargarCgg_res_cargo_comiteCtrls(){
        if(inRecordCgg_res_cargo_comite){
            txtCrcrg_codigo.setValue(inRecordCgg_res_cargo_comite.get('CRCRG_CODIGO'));
            tmpCrcmcomite=inRecordCgg_res_cargo_comite.get('CRCOM_CODIGO');
            txtCrcom_codigo.setValue(inRecordCgg_res_cargo_comite.get('COMITE'));
            txtCrcrg_nombre.setValue(inRecordCgg_res_cargo_comite.get('CRCRG_NOMBRE'));
			chkCrcrg_principal.setValue(inRecordCgg_res_cargo_comite.get('CRCRG_PRINCIPAL'));
            chkCrcrg_voto_dirimente.setValue(inRecordCgg_res_cargo_comite.get('CRCRG_VOTO_DIRIMENTE'));
            isEdit = true;
            habilitarCgg_res_cargo_comiteCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_cargo_comite.
     * @returns ventana winFrmCgg_res_cargo_comite.
     * @base FrmCgg_res_cargo_comite.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_cargo_comite;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_cargo_comite.
     * @base FrmCgg_res_cargo_comite.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_cargo_comiteCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_cargo_comite desde una instancia.
 */
FrmCgg_res_cargo_comite.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_cargo_comite desde una instancia.
 */
FrmCgg_res_cargo_comite.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_cargo_comite,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_cargo_comite.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_cargo_comite desde una instancia.
 */
FrmCgg_res_cargo_comite.prototype.loadData = function(){
    this.loadData();
}
