/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_tct_grupo_turista.
 * @param {String} IN_SENTENCIA_CGG_TCT_GRUPO_TURISTA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_TCT_GRUPO_TURISTA Registro de datos de la tabla Cgg_tct_grupo_turista.
 * @constructor
 * @base FrmListadoCgg_tct_grupo_turista
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_tct_grupo_turista(IN_SENTENCIA_CGG_TCT_GRUPO_TURISTA,IN_RECORD_CGG_TCT_GRUPO_TURISTA){    
    var inSentenciaCgg_tct_grupo_turista = IN_SENTENCIA_CGG_TCT_GRUPO_TURISTA;
    var inRecordCgg_tct_grupo_turista=IN_RECORD_CGG_TCT_GRUPO_TURISTA;
    var urlCgg_tct_grupo_turista=URL_WS+"Cgg_tct_grupo_turista";
    var tituloCgg_tct_grupo_turista='Grupo Turista';
    var descCgg_tct_grupo_turista='El formulario permite administrar la informaci\u00f3n de Grupo Turista';
    var isEdit = false;
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCtgtr_codigo = new Ext.form.TextField({
        id:'txtCtgtr_codigo',
        name:'txtCtgtr_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
     */
    var txtCusu_codigo = new Ext.form.TextField({
        id:'txtCusu_codigo',
        name:'txtCusu_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        readOnly:'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
     */
    var btnCusu_codigoCgg_tct_grupo_turista = new Ext.Button({
        id:'btnCusu_codigoCgg_tct_grupo_turista',
        text:'Cusu_codigo',
        iconCls:'iconCusu_codigo',
        listeners:{
            click:function(){
                var tmpFLCgg_usuario = new FrmListadoCgg_usuario();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_usuario.getStore(),tmpFLCgg_usuario.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord)
                        txtCusu_codigo.setValue(tmpRecord.get('CUSU_CODIGO'));
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField NOMBRE DEL DOCUMENTO ADJUNTO
     */
    var txtCtadc_nombre = new Ext.form.TextField({
        id:'txtCtadc_codigo',
        name:'txtCtadc_codigo',
        fieldLabel :'Nombre',
        anchor:'98%',
        readOnly:'true'
    });
    /**
     * ARCHIVO DIGITAL ANEXO
     */
    var filCrres_adjunto_grupo_turista= new Ext.form.FileUploadField({
        id:'filCrres_adjunto_grupo_turista',
        name:'filCrres_adjunto_grupo_turista',
        fieldLabel :'Archivo',
        disabled :false,
        anchor:'98%',
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        }
    });

    /**
     * Ext.form.NumberField NUMERO SECUENCIAL UNICO DE IDENTIFICACION DEL GRUPO
     */
    var numCtgtr_numero = new Ext.form.NumberField({
        id:'numCtgtr_numero',
        name:'numCtgtr_numero',
        fieldLabel :'Numero',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.DateField FECHA DE RESERVA
     */
    var dtCtgtr_fecha_reserva = new Ext.form.DateField({
        id:'dtCtgtr_fecha_reserva',
        name:'dtCtgtr_fecha_reserva',
        fieldLabel :'Reserva',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    /**
     * Ext.form.DateField FECHA DE INGRESO  A LA PROVINCIA
     */
    var dtCtgtr_fecha_ingreso = new Ext.form.DateField({
        id:'dtCtgtr_fecha_ingreso',
        name:'dtCtgtr_fecha_ingreso',
        fieldLabel :'Ingreso',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    /**
     * Ext.form.DateField FECHA DE SALIDA DE LA PROVINCIA
     */
    var dtCtgtr_fecha_salida = new Ext.form.DateField({
        id:'dtCtgtr_fecha_salida',
        name:'dtCtgtr_fecha_salida',
        fieldLabel :'Salida',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_tct_grupo_turista
     */
    var btnGuardarCgg_tct_grupo_turista = new Ext.Button({
        id:'btnGuardarCgg_tct_grupo_turista',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_tct_grupo_turista.getForm().isValid()==false){
                    return;
                }
                try{
                    function CallBackCgg_tct_grupo_turista(r){
                        winFrmCgg_tct_grupo_turista.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_tct_grupo_turista,
                                msg: 'La informaci\u00f3n de Grupo Turista ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_tct_grupo_turista.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_tct_grupo_turista,
                                msg: 'La informaci\u00f3n de Grupo Turista no ha podido ser almacenada. '+r,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_tct_grupo_turista.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                        param.add('inCtgtr_codigo',txtCtgtr_codigo.getValue());
                    param.add('inCusu_codigo',txtCusu_codigo.getValue());
                    param.add('inCtadc_codigo',txtCtadc_codigo.getValue());
                    param.add('inCtgtr_numero',numCtgtr_numero.getValue());
                    param.add('inCtgtr_fecha_reserva',dtCtgtr_fecha_reserva.getValue().format('c'));
                    param.add('inCtgtr_fecha_ingreso',dtCtgtr_fecha_ingreso.getValue().format('c'));
                    param.add('inCtgtr_fecha_salida',dtCtgtr_fecha_salida.getValue().format('c'));
                    SOAPClient.invoke(urlCgg_tct_grupo_turista,IN_SENTENCIA_CGG_TCT_GRUPO_TURISTA,param, true, CallBackCgg_tct_grupo_turista);
                }catch(inErr){
                    winFrmCgg_tct_grupo_turista.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_tct_grupo_turista.
     */
    var btnCancelarCgg_tct_grupo_turista = new Ext.Button({
        id:'btnCancelarCgg_tct_grupo_turista',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_tct_grupo_turista.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_tct_grupo_turista.
     */
    var btnCerrarCgg_tct_grupo_turista = new Ext.Button({
        id:'btnCerrarCgg_tct_grupo_turista',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_tct_grupo_turista.close();
            }}
    });
    /**
     * Ext.form.FormPanel Panel para los tipos de votos de winFrmCgg_res_resolucion.
     */
     var pnlfsCgg_tct_adjunto = new Ext.form.FieldSet({
        id:'pnlfsCgg_tct_adjunto',
        title:'Adjunto',
        collapsible:false,
        region:'center',
        labelWidth :70,
        height:90,
        width:310,
        layout:'form',
        items:[txtCtadc_nombre,filCrres_adjunto_grupo_turista]
    });
    /**
     * Ext.form.FormPanel Panel para los tipos de votos de winFrmCgg_res_resolucion.
     */
     var pnlfsFecha = new Ext.form.FieldSet({
        id:'pnlfsFecha',
        title:'Fecha',
        collapsible:false,
        region:'center',
        labelWidth :70,
        height:110,
        width:310,
        layout:'form',
        items:[dtCtgtr_fecha_reserva,dtCtgtr_fecha_ingreso,dtCtgtr_fecha_salida]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_tct_grupo_turista.
     */
    var pnlCgg_tct_grupo_turista = new Ext.form.FormPanel({
        frame:true,
        labelWidth :70,
        items:[txtCtgtr_codigo,numCtgtr_numero,numCtgtr_numero,pnlfsFecha,pnlfsCgg_tct_adjunto]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_tct_grupo_turista.
     */
    var winFrmCgg_tct_grupo_turista = new Ext.Window({
        id:'winFrmCgg_tct_grupo_turista',
        title:tituloCgg_tct_grupo_turista,
        width:350,
        minWidth:350,
        maximizable:false,
        minimizable:false,
        modal:true,
        resizable:false,
        constrain:true,
        tbar:getPanelTitulo(tituloCgg_tct_grupo_turista,descCgg_tct_grupo_turista),
        items:[pnlCgg_tct_grupo_turista],
        bbar:[btnGuardarCgg_tct_grupo_turista,btnCancelarCgg_tct_grupo_turista,'->',btnCerrarCgg_tct_grupo_turista]
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_tct_grupo_turista.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_tct_grupo_turistaCtrls(inEstado){
        estado=!inEstado;
        txtCtgtr_codigo.setDisabled(estado);
        txtCusu_codigo.setDisabled(estado);
        txtCtadc_codigo.setDisabled(estado);
        numCtgtr_numero.setDisabled(estado);
        dtCtgtr_fecha_reserva.setDisabled(estado);
        dtCtgtr_fecha_ingreso.setDisabled(estado);
        dtCtgtr_fecha_salida.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_tct_grupo_turista.
     */
    function cargarCgg_tct_grupo_turistaCtrls(){
        if(inRecordCgg_tct_grupo_turista){
            txtCtgtr_codigo.setValue(inRecordCgg_tct_grupo_turista.get('CTGTR_CODIGO'));
            txtCusu_codigo.setValue(inRecordCgg_tct_grupo_turista.get('CUSU_CODIGO'));
            txtCtadc_codigo.setValue(inRecordCgg_tct_grupo_turista.get('CTADC_CODIGO'));
            numCtgtr_numero.setValue(inRecordCgg_tct_grupo_turista.get('CTGTR_NUMERO'));
            dtCtgtr_fecha_reserva.setValue(inRecordCgg_tct_grupo_turista.get('CTGTR_FECHA_RESERVA'));
            dtCtgtr_fecha_ingreso.setValue(inRecordCgg_tct_grupo_turista.get('CTGTR_FECHA_INGRESO'));
            dtCtgtr_fecha_salida.setValue(inRecordCgg_tct_grupo_turista.get('CTGTR_FECHA_SALIDA'));
            isEdit = true;
            habilitarCgg_tct_grupo_turistaCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_tct_grupo_turista.
     * @returns ventana winFrmCgg_tct_grupo_turista.
     * @base FrmCgg_tct_grupo_turista.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_tct_grupo_turista;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_tct_grupo_turista.
     * @base FrmCgg_tct_grupo_turista.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_tct_grupo_turistaCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_tct_grupo_turista desde una instancia.
 */
FrmCgg_tct_grupo_turista.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_tct_grupo_turista desde una instancia.
 */
FrmCgg_tct_grupo_turista.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_tct_grupo_turista,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_tct_grupo_turista.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_tct_grupo_turista desde una instancia.
 */
FrmCgg_tct_grupo_turista.prototype.loadData = function(){
    this.loadData();
}
