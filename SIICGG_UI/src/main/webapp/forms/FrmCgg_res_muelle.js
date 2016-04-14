/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_muelle.
 * @param {String} INSENTENCIA_CGG_RES_MUELLE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_MUELLE Registro de datos de la tabla Cgg_res_muelle.
 * @constructor
 * @base FrmListadoCgg_res_muelle
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_muelle(INSENTENCIA_CGG_RES_MUELLE,INRECORD_CGG_RES_MUELLE){
    var inSentenciaCgg_res_muelle = INSENTENCIA_CGG_RES_MUELLE;
    var inRecordCgg_res_muelle=INRECORD_CGG_RES_MUELLE;
    var urlCgg_res_muelle=URL_WS+"Cgg_res_muelle";
    var tituloCgg_res_muelle='Muelle';
    var descCgg_res_muelle='El formulario permite administrar informaci\u00f3n de Muelle';
    var isEdit = false;

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrmle_codigo = new Ext.form.TextField({
        id:'txtCrmle_codigo',
        name:'txtCrmle_codigo',
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
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO
     */
    /*var btnCctn_codigoCgg_res_muelle = new Ext.Button({
        id:'btnCctn_codigoCgg_res_muelle',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_canton = new FrmListadoCgg_canton();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_canton.getStore(),tmpFLCgg_canton.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpCctn_codigo =tmpRecord.get('CCTN_CODIGO');
                        txtCctn_codigo.setValue(tmpRecord.get('CCTN_NOMBRE'));
                    }
                });
                objBusqueda.show();
            }}
    });*/
     //Creamos una definici?n de los campos que vienen en el Json remoto

    var cbxCanton_muelle = new Ext.form.ComboBox({
        store:SCGG_CANTON,
        id:'cbxCanton_muelle',
        name:'cbxCanton_muelle',
        displayField: "CCTN_NOMBRE",
        fieldLabel :'Cant\u00f3n',
        valueField: 'CCTN_CODIGO',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
		selectOnFocus:true,
        hiddenId:'cbxCanton_muelleH',
        hiddenName:'cbxCanton_muelleH',
        hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        anchor:'98%',
        emptyText:'Seleccione una opci\u00f3n..'
    });
    /**
     * Ext.form.TextField NOMBRE DEL MUELLE
     */
    var txtCrmle_nombre = new Ext.form.TextField({
        id:'txtCrmle_nombre',
        name:'txtCrmle_nombre',
        fieldLabel :'Nombre',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_muelle
     */
    var btnGuardarCgg_res_muelle = new Ext.Button({
        id:'btnGuardarCgg_res_muelle',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_muelle.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_res_muelle(r){
                        winFrmCgg_res_muelle.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_res_muelle,
                                msg: 'La informaci\u00f3n de Muelle ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_res_muelle.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_res_muelle,
                                msg: 'La informaci\u00f3n de Muelle no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_res_muelle.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCrmle_codigo',txtCrmle_codigo.getValue());
                    param.add('inCctn_codigo',cbxCanton_muelle.getValue());
                    param.add('inCrmle_nombre',txtCrmle_nombre.getValue());
                    SOAPClient.invoke(urlCgg_res_muelle,INSENTENCIA_CGG_RES_MUELLE,param, true, CallBackCgg_res_muelle);
                }catch(inErr){
                    winFrmCgg_res_muelle.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_muelle.
     */
    var btnCancelarCgg_res_muelle = new Ext.Button({
        id:'btnCancelarCgg_res_muelle',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_muelle.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_muelle.
     */
    var btnCerrarCgg_res_muelle = new Ext.Button({
        id:'btnCerrarCgg_res_muelle',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_muelle.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_muelle.
     */
    var pnlCgg_res_muelle = new Ext.form.FormPanel({
        frame:true,
        labelWidth :80,
        items:[cbxCanton_muelle,txtCrmle_nombre]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_muelle.
     */
    var winFrmCgg_res_muelle = new Ext.Window({
        id:'winFrmCgg_res_muelle',
        title:tituloCgg_res_muelle,
        tbar:getPanelTitulo(tituloCgg_res_muelle,descCgg_res_muelle),
        items:[pnlCgg_res_muelle],
        width:350,
        minWidth:350,
        modal:true,
        maximizable:false,
        minimizable:false,
        constrain:true,
        bbar:[btnGuardarCgg_res_muelle,btnCancelarCgg_res_muelle,'->',btnCerrarCgg_res_muelle]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_muelle.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_muelleCtrls(inEstado){
        estado=!inEstado;
        txtCrmle_codigo.setDisabled(estado);
        cbxCanton_muelle.setDisabled(estado);
        txtCrmle_nombre.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_muelle.
     */
    function cargarCgg_res_muelleCtrls(){
        if(inRecordCgg_res_muelle){
            txtCrmle_codigo.setValue(inRecordCgg_res_muelle.get('CRMLE_CODIGO'));
            cbxCanton_muelle.setValue(inRecordCgg_res_muelle.get('CCTN_CODIGO'));
            cbxCanton_muelle.setValue(inRecordCgg_res_muelle.get('CANTON'));
            txtCrmle_nombre.setValue(inRecordCgg_res_muelle.get('CRMLE_NOMBRE'));
            isEdit = true;
            habilitarCgg_res_muelleCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_muelle.
     * @returns ventana winFrmCgg_res_muelle.
     * @base FrmCgg_res_muelle.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_muelle;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_muelle.
     * @base FrmCgg_res_muelle.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_muelleCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_muelle desde una instancia.
 */
FrmCgg_res_muelle.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_muelle desde una instancia.
 */
FrmCgg_res_muelle.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_muelle,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_muelle.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_muelle desde una instancia.
 */
FrmCgg_res_muelle.prototype.loadData = function(){
    this.loadData();
}
