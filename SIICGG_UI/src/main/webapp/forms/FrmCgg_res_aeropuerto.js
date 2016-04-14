/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_aeropuerto.
 * @param {String} INSENTENCIA_CGG_RES_AEROPUERTO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_AEROPUERTO Registro de datos de la tabla Cgg_res_aeropuerto.
 * @constructor
 * @base FrmListadoCgg_res_aeropuerto
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_aeropuerto(INSENTENCIA_CGG_RES_AEROPUERTO,INRECORD_CGG_RES_AEROPUERTO){
    var inSentenciaCgg_res_aeropuerto = INSENTENCIA_CGG_RES_AEROPUERTO;
    var inRecordCgg_res_aeropuerto=INRECORD_CGG_RES_AEROPUERTO;
    var urlCgg_res_aeropuerto=URL_WS+"Cgg_res_aeropuerto";
    var tituloCgg_res_aeropuerto='Aeropuerto';
    var descCgg_res_aeropuerto='El formulario permite administrar informaci\u00f3n del Aeropuerto';
    var isEdit = false;
    var tmpCctn_codigo;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCarpt_codigo = new Ext.form.TextField({
        id:'txtCarpt_codigo',
        name:'txtCarpt_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCctn_codigo = new Ext.form.TextField({
        id:'txtCctn_codigo',
        name:'txtCctn_codigo',
        fieldLabel :'Cant\u00f3n',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO
     */
    var btnCctn_codigoCgg_res_aeropuerto = new Ext.Button({
        id:'btnCctn_codigoCgg_res_aeropuerto',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_canton = new FrmListadoCgg_canton();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_canton.getStore(),tmpFLCgg_canton.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCctn_codigo=tmpRecord.get('CCTN_CODIGO');
                        txtCctn_codigo.setValue(tmpRecord.get('CCTN_NOMBRE'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField NOMBRE DEL AEROPUERTO
     */
    var txtCarpt_nombre = new Ext.form.TextField({
        id:'txtCarpt_nombre',
        name:'txtCarpt_nombre',
        fieldLabel :'Nombre',
        anchor:'98%'
    });
	/**
* Ext.form.NumberField IDENTIFICATIVO SI EL AEROPUERTO ES INTERNO O EXTERNO
0 - EXTERNO
1 - INTERNO
*/
var numCarpt_tipo_aereopuerto = new Ext.form.NumberField({
id:'numCarpt_tipo_aereopuerto',
name:'numCarpt_tipo_aereopuerto',
fieldLabel :'Tipo aereopuerto',
allowBlank :false,
disabled :false
});
  var sttipo_aeropuerto = new Ext.data.ArrayStore({
        fields:['id','tipoaeropuerto'],
        data:dsTipoAeropuerto
    });
    var cbxCarpt_tipo = new Ext.form.ComboBox({
        id:'cbxCarpt_tipo',
        name:'cbxCarpt_tipo',
        store:sttipo_aeropuerto ,
        fieldLabel :'Tipo aeropuerto',
        displayField: 'tipoaeropuerto',
        valueField: 'id',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        hiddenId:'cbxCarpt_tipoH',
        hiddenName:'cbxCarpt_tipoH',
        hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'70%',
        triggerAction:'all',
        emptyText : 'Seleccione una opci\u00f3n..'
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_aeropuerto
     */
    var btnGuardarCgg_res_aeropuerto = new Ext.Button({
        id:'btnGuardarCgg_res_aeropuerto',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_aeropuerto.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_aeropuerto(r){
                        winFrmCgg_res_aeropuerto.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_aeropuerto,
                                msg: 'La informaci\u00f3n del Aeropuerto ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_aeropuerto.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_aeropuerto,
                                msg: 'La informaci\u00f3n del Aeropuerto no ha podido ser almacenada.'+ (r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_aeropuerto.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCarpt_codigo',txtCarpt_codigo.getValue());
                    param.add('inCctn_codigo',tmpCctn_codigo);
                    param.add('inCarpt_nombre',txtCarpt_nombre.getValue());
					param.add('inCarpt_tipo_aereopuerto',cbxCarpt_tipo.getValue());
                    SOAPClient.invoke(urlCgg_res_aeropuerto,INSENTENCIA_CGG_RES_AEROPUERTO,param, true, CallBackCgg_res_aeropuerto);
                }catch(inErr){
                    winFrmCgg_res_aeropuerto.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_aeropuerto.
     */
    var btnCancelarCgg_res_aeropuerto = new Ext.Button({
        id:'btnCancelarCgg_res_aeropuerto',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_aeropuerto.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_aeropuerto.
     */
    var btnCerrarCgg_res_aeropuerto = new Ext.Button({
        id:'btnCerrarCgg_res_aeropuerto',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_aeropuerto.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_aeropuerto.
     */
    var pnlCgg_res_aeropuerto = new Ext.form.FormPanel({
        frame:true,
        labelWidth :50,
        items:[txtCarpt_codigo,
            {xtype:'panel',layout:'column',
                items:[{columnWidth:.92,layout:'form',
                    items:[txtCctn_codigo]},{columnWidth:.08,layout:'form',
                    items:[btnCctn_codigoCgg_res_aeropuerto]}]},txtCarpt_nombre,cbxCarpt_tipo]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_aeropuerto.
     */
    var winFrmCgg_res_aeropuerto = new Ext.Window({
        id:'winFrmCgg_res_aeropuerto',
        title:tituloCgg_res_aeropuerto,
        tbar:getPanelTitulo(tituloCgg_res_aeropuerto,descCgg_res_aeropuerto),
        items:[pnlCgg_res_aeropuerto],
        width:400,
        minWidth:400,
        	resizable :false,
        modal:true,
        maximizable:false,
        minimizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_res_aeropuerto,btnCancelarCgg_res_aeropuerto,'->',btnCerrarCgg_res_aeropuerto]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_aeropuerto.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_aeropuertoCtrls(inEstado){
        estado=!inEstado;
        txtCarpt_codigo.setDisabled(estado);
        txtCctn_codigo.setDisabled(estado);
        txtCarpt_nombre.setDisabled(estado);
		numCarpt_tipo_aereopuerto.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_aeropuerto.
     */
    function cargarCgg_res_aeropuertoCtrls(){
        if(inRecordCgg_res_aeropuerto){
            txtCarpt_codigo.setValue(inRecordCgg_res_aeropuerto.get('CARPT_CODIGO'));
            tmpCctn_codigo= inRecordCgg_res_aeropuerto.get('CCTN_CODIGO');
            txtCctn_codigo.setValue(inRecordCgg_res_aeropuerto.get('CANTON'));
            txtCarpt_nombre.setValue(inRecordCgg_res_aeropuerto.get('CARPT_NOMBRE'));
			cbxCarpt_tipo.setValue(inRecordCgg_res_aeropuerto.get('CARPT_TIPO_AEREOPUERTO'));
            isEdit = true;
            habilitarCgg_res_aeropuertoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_aeropuerto.
     * @returns ventana winFrmCgg_res_aeropuerto.
     * @base FrmCgg_res_aeropuerto.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_aeropuerto;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_aeropuerto.
     * @base FrmCgg_res_aeropuerto.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_aeropuertoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_aeropuerto desde una instancia.
 */
FrmCgg_res_aeropuerto.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_aeropuerto desde una instancia.
 */
FrmCgg_res_aeropuerto.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_aeropuerto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_aeropuerto.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_aeropuerto desde una instancia.
 */
FrmCgg_res_aeropuerto.prototype.loadData = function(){
    this.loadData();
}
