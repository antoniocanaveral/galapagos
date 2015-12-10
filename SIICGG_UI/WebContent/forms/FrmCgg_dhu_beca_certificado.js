/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_beca_certificado.
 * @param {String} INSENTENCIA_CGG_DHU_BECA_CERTIFICADO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_DHU_BECA_CERTIFICADO Registro de datos de la tabla Cgg_dhu_beca_certificado.
 * @constructor
 * @base FrmListadoCgg_dhu_beca_certificado
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_beca_certificado(INSENTENCIA_CGG_DHU_BECA_CERTIFICADO,INRECORD_CGG_DHU_BECA_CERTIFICADO){
    var inSentenciaCgg_dhu_beca_certificado = INSENTENCIA_CGG_DHU_BECA_CERTIFICADO;
    var inRecordCgg_dhu_beca_certificado=INRECORD_CGG_DHU_BECA_CERTIFICADO;
    var urlCgg_dhu_beca_certificado=URL_WS+"Cgg_dhu_beca_certificado";
    var tituloCgg_dhu_beca_certificado='Beca certificado';
    var descCgg_dhu_beca_certificado='El formulario permite administrar informaci\u00f3n de certificado beca';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CERTIFICADO
     */
    var txtCdbcr_codigo = new Ext.form.TextField({
        id:'txtCdbcr_codigo',
        name:'txtCdbcr_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CERTIFICADO ACADEMICO
     */
    var txtCdtca_codigo = new Ext.form.TextField({
        id:'txtCdtca_codigo',
        name:'txtCdtca_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
       /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CERTIFICADO ACADEMICO
     */
    var txtCdtca_certificado= new Ext.form.TextField({
        id:'txtCdtca_certificado',
        name:'txtCdtca_certificado',
        fieldLabel :'Certificado',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :200
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO TIPO DE CERTIFICADO ACADEMICO
     */
    var btnCdtca_codigoCgg_dhu_beca_certificado = new Ext.Button({
        id:'btnCdtca_codigoCgg_dhu_beca_certificado',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_dhu_tipo_cacademico = new FrmListadoCgg_dhu_tipo_cacademico();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_tipo_cacademico.getStore(),tmpFLCgg_dhu_tipo_cacademico.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
			{
                        txtCdtca_codigo.setValue(tmpRecord.get('CDTCA_CODIGO'));
                        txtCdtca_certificado.setValue(tmpRecord.get('CDTCA_NOMBRE'));
			}
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
     */
    var txtCdtbc_codigo = new Ext.form.TextField({
        id:'txtCdtbc_codigo',
        name:'txtCdtbc_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
      /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
     */
    var txtCdtbc_nombre = new Ext.form.TextField({
        id:'txtCdtbc_nombre',
        name:'txtCdtbc_nombre',
        fieldLabel :'Tipo beca',
        anchor:'98%',
        readOnly:'true',
        maxLength :200
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE BECA
     */
    var btnCdtbc_codigoCgg_dhu_beca_certificado = new Ext.Button({
        id:'btnCdtbc_codigoCgg_dhu_beca_certificado',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_dhu_tipo_beca = new FrmListadoCgg_dhu_tipo_beca();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_tipo_beca.getStore(),tmpFLCgg_dhu_tipo_beca.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCdtbc_codigo.setValue(tmpRecord.get('CDTBC_CODIGO'));
                            txtCdtbc_nombre.setValue(tmpRecord.get('CDTBC_NOMBRE'));
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.Checkbox OBLIGATORIEDAD DEL CERTIFICADO.
     */
    var chkCdbcr_obligatorio = new Ext.form.Checkbox({
        id:'chkCdbcr_obligatorio',
        name:'chkCdbcr_obligatorio',
        fieldLabel :'Obligatorio',
        allowBlank :false,
        checked:true
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_beca_certificado
     */
    var btnGuardarCgg_dhu_beca_certificado = new Ext.Button({
        id:'btnGuardarCgg_dhu_beca_certificado',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_dhu_beca_certificado.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_dhu_beca_certificado(r){
                        winFrmCgg_dhu_beca_certificado.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_beca_certificado,
                                msg: 'La informaci\u00f3n certificado ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_beca_certificado.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_beca_certificado,
                                msg: 'La informaci\u00f3n  no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_beca_certificado.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCdbcr_codigo',txtCdbcr_codigo.getValue());
                    param.add('inCdtca_codigo',txtCdtca_codigo.getValue());
                    param.add('inCdtbc_codigo',txtCdtbc_codigo.getValue());
                    param.add('inCdbcr_obligatorio',chkCdbcr_obligatorio.getValue());
                    SOAPClient.invoke(urlCgg_dhu_beca_certificado,INSENTENCIA_CGG_DHU_BECA_CERTIFICADO,param, true, CallBackCgg_dhu_beca_certificado);
                }catch(inErr){
                    winFrmCgg_dhu_beca_certificado.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_beca_certificado.
     */
    var btnCancelarCgg_dhu_beca_certificado = new Ext.Button({
        id:'btnCancelarCgg_dhu_beca_certificado',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_dhu_beca_certificado.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_beca_certificado.
     */
    var btnCerrarCgg_dhu_beca_certificado = new Ext.Button({
        id:'btnCerrarCgg_dhu_beca_certificado',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_dhu_beca_certificado.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_beca_certificado.
     */
    var pnlCgg_dhu_beca_certificado = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        items:[txtCdbcr_codigo,{xtype:'panel',layout:'column',
            items:[{columnWidth:.6,layout:'form',items:[txtCdtca_certificado]},
                {columnWidth:.4,layout:'form',items:[btnCdtca_codigoCgg_dhu_beca_certificado]}]},
            {xtype:'panel',layout:'column',
            items:[{columnWidth:.6,layout:'form',items:[txtCdtbc_nombre]},
            {columnWidth:.4,layout:'form',items:[btnCdtbc_codigoCgg_dhu_beca_certificado]}]},chkCdbcr_obligatorio]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_beca_certificado.
     */
    var winFrmCgg_dhu_beca_certificado = new Ext.Window({
        id:'winFrmCgg_dhu_beca_certificado',
        title:tituloCgg_dhu_beca_certificado,
        tbar:getPanelTitulo(tituloCgg_dhu_beca_certificado,descCgg_dhu_beca_certificado),
        items:[pnlCgg_dhu_beca_certificado],
        width:400,
        minWidth:400,
        maximizable:false,
        minimizable:false,
		resizable : false,
        constrain:true,
		modal : true,
        bbar:[btnGuardarCgg_dhu_beca_certificado,btnCancelarCgg_dhu_beca_certificado,'->',btnCerrarCgg_dhu_beca_certificado]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_beca_certificado.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_beca_certificadoCtrls(inEstado){
        estado=!inEstado;
        txtCdbcr_codigo.setDisabled(estado);
        txtCdtca_codigo.setDisabled(estado);
        txtCdtbc_codigo.setDisabled(estado);
        chkCdbcr_obligatorio.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_beca_certificado.
     */
    function cargarCgg_dhu_beca_certificadoCtrls(){
        if(inRecordCgg_dhu_beca_certificado){
            txtCdbcr_codigo.setValue(inRecordCgg_dhu_beca_certificado.get('CDBCR_CODIGO'));
            txtCdtca_codigo.setValue(inRecordCgg_dhu_beca_certificado.get('CDTCA_CODIGO'));
            txtCdtbc_codigo.setValue(inRecordCgg_dhu_beca_certificado.get('CDTBC_CODIGO'));
            chkCdbcr_obligatorio.setValue(inRecordCgg_dhu_beca_certificado.get('CDBCR_OBLIGATORIO'));
            isEdit = true;
            habilitarCgg_dhu_beca_certificadoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_beca_certificado.
     * @returns ventana winFrmCgg_dhu_beca_certificado.
     * @base FrmCgg_dhu_beca_certificado.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_beca_certificado;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_beca_certificado.
     * @base FrmCgg_dhu_beca_certificado.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_beca_certificadoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_beca_certificado desde una instancia.
 */
FrmCgg_dhu_beca_certificado.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_beca_certificado desde una instancia.
 */
FrmCgg_dhu_beca_certificado.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_beca_certificado,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_beca_certificado.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_beca_certificado desde una instancia.
 */
FrmCgg_dhu_beca_certificado.prototype.loadData = function(){
    this.loadData();
}
