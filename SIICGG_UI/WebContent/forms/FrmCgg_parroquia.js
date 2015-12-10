/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_parroquia.
 * @param {String} INSENTENCIA_CGG_PARROQUIA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_PARROQUIA Registro de datos de la tabla Cgg_parroquia.
 * @constructor
 * @base FrmListadoCgg_parroquia
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_parroquia(INSENTENCIA_CGG_PARROQUIA,INRECORD_CGG_PARROQUIA){
    var inSentenciaCgg_parroquia = INSENTENCIA_CGG_PARROQUIA;
    var inRecordCgg_parroquia=INRECORD_CGG_PARROQUIA;
    var urlCgg_parroquia=URL_WS+"Cgg_parroquia";
    var tituloCgg_parroquia='Parroquia';
    var descCgg_parroquia='El formulario permite administrar informaci\u00f3n de Parroquia';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PARROQUIA
     */
    var txtCprr_codigo = new Ext.form.TextField({
        id:'txtCprr_codigo',
        name:'txtCprr_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
     */
    var txtCctn_codigo = new Ext.form.TextField({
        id:'txtCctn_codigo',
        name:'txtCctn_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
     */
    var txtCctn_nombre = new Ext.form.TextField({
        id:'txtCctn_nombre',
        name:'txtCctn_nombre',
        fieldLabel :'Cant\u00f3n',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :200
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
     */
    var btnCctn_codigoCgg_parroquia = new Ext.Button({
        id:'btnCctn_codigoCgg_parroquia',
        iconCls:'iconBuscar',
        tooltip:TypeTooltip.BUSCAR + 'Cant\u00f3n',
        listeners:{
            click:function(){
                var tmpFLCgg_canton = new FrmListadoCgg_canton();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_canton.getStore(),tmpFLCgg_canton.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                    {
                        txtCctn_codigo.setValue(tmpRecord.get('CCTN_CODIGO'));
                        txtCctn_nombre.setValue(tmpRecord.get('CCTN_NOMBRE'));
                    }

                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField NOMBRE DE LA PARROQUIA
     */
    var txtCprr_nombre = new Ext.form.TextField({
        id:'txtCprr_nombre',
        name:'txtCprr_nombre',
        fieldLabel :'Parroquia',
        anchor:'98%',
        allowBlank :false,
        maxLength :200
    });
    /**
     * Ext.form.TextField DESCRIPCION DE LA PARROQUIA
     */
    var txtCprr_descripcion = new Ext.form.TextField({
        id:'txtCprr_descripcion',
        name:'txtCprr_descripcion',
        fieldLabel :'Descripci\u00f3n',
        anchor:'98%',
        allowBlank :true,
        maxLength :200
    });
    /**
     *  Ext.form.RadioGroup UBICACION GEOGRAFICA DETERMINADA
     0 - URBANA
     1 - RURAL
     */

    var rdgCprr_tipo = new Ext.form.RadioGroup({
        fieldLabel: 'Tipo parroquia',
         //columns: 2, //display the radiobuttons in two columns
        items: [
            {boxLabel: 'Urbano', name: 'rdgCprr_tipo', inputValue: 0, checked: true},
            {boxLabel: 'Rural', name: 'rdgCprr_tipo', inputValue: 1}
        ]
    });

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_parroquia
     */
    var btnGuardarCgg_parroquia = new Ext.Button({
        id:'btnGuardarCgg_parroquia',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:TypeTooltip.GUARDAR,
        listeners:{
            click:function(){
                if (pnlCgg_parroquia.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_parroquia(r){
                        winFrmCgg_parroquia.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_parroquia,
                                msg: 'La informaci\u00f3n de Parroquia ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_parroquia.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_parroquia,
                                msg: 'La informaci\u00f3n de Parroquia no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_parroquia.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCprr_codigo',txtCprr_codigo.getValue());
                    param.add('inCctn_codigo',txtCctn_codigo.getValue());
                    param.add('inCprr_nombre',txtCprr_nombre.getValue());
                    param.add('inCprr_descripcion',txtCprr_descripcion.getValue());
                    param.add('inCprr_tipo',rdgCprr_tipo.getValue().getRawValue());
                    SOAPClient.invoke(urlCgg_parroquia,INSENTENCIA_CGG_PARROQUIA,param, true, CallBackCgg_parroquia);
                }catch(inErr){
                    winFrmCgg_parroquia.getEl().unmask();
                }

            }}
        //alert(rdgCprr_tipo.getValue().getRawValue());
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_parroquia.
     */
    var btnCancelarCgg_parroquia = new Ext.Button({
        id:'btnCancelarCgg_parroquia',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:TypeTooltip.CANCELAR,
        listeners:{
            click:function(){
                pnlCgg_parroquia.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_parroquia.
     */
    var btnCerrarCgg_parroquia = new Ext.Button({
        id:'btnCerrarCgg_parroquia',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_parroquia.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_parroquia.
     */
    var pnlCgg_parroquia = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCprr_codigo,
               {xtype:'panel',layout:'column',items:[{columnWidth:.6,layout:'form',items:[txtCctn_nombre]},{columnWidth:.4,layout:'form',items:[btnCctn_codigoCgg_parroquia]}]},
                txtCprr_nombre,
                txtCprr_descripcion,
                rdgCprr_tipo]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_parroquia.
     */
    var winFrmCgg_parroquia = new Ext.Window({
        id:'winFrmCgg_parroquia',
        title:tituloCgg_parroquia,
        tbar:getPanelTitulo(tituloCgg_parroquia,descCgg_parroquia),
        items:[pnlCgg_parroquia],
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
        resizable:false,
        modal:true,
        constrain:true,
        bbar:[btnGuardarCgg_parroquia,btnCancelarCgg_parroquia,'->',btnCerrarCgg_parroquia]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_parroquia.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_parroquiaCtrls(inEstado){
        estado=!inEstado;
        txtCprr_codigo.setDisabled(estado);
        txtCctn_codigo.setDisabled(estado);
        txtCprr_nombre.setDisabled(estado);
        txtCprr_descripcion.setDisabled(estado);
      //  numCprr_tipo.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_parroquia.
     */
    function cargarCgg_parroquiaCtrls(){
        if(inRecordCgg_parroquia){
            txtCprr_codigo.setValue(inRecordCgg_parroquia.get('CPRR_CODIGO'));
            txtCctn_codigo.setValue(inRecordCgg_parroquia.get('CCTN_CODIGO'));
              var rCanton=SCGG_CANTON.getAt(SCGG_CANTON.findExact('CCTN_CODIGO',inRecordCgg_parroquia.get('CCTN_CODIGO')));
            txtCctn_nombre.setValue(rCanton.get('CCTN_NOMBRE'));
            txtCprr_nombre.setValue(inRecordCgg_parroquia.get('CPRR_NOMBRE'));
            txtCprr_descripcion.setValue(inRecordCgg_parroquia.get('CPRR_DESCRIPCION'));
            //numCprr_tipo.setValue(inRecordCgg_parroquia.get('CPRR_TIPO'));
            rdgCprr_tipo.setValue(inRecordCgg_parroquia.get('CPRR_TIPO'));
            isEdit = true;
            habilitarCgg_parroquiaCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_parroquia.
     * @returns ventana winFrmCgg_parroquia.
     * @base FrmCgg_parroquia.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_parroquia;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_parroquia.
     * @base FrmCgg_parroquia.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_parroquiaCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_parroquia desde una instancia.
 */
FrmCgg_parroquia.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_parroquia desde una instancia.
 */
FrmCgg_parroquia.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_parroquia,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_parroquia.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_parroquia desde una instancia.
 */
FrmCgg_parroquia.prototype.loadData = function(){
    this.loadData();
}
