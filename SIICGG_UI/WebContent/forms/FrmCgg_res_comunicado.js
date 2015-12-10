/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_comunicado.
 * @param {String} IN_SENTENCIA_CGG_RES_COMUNICADO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} IN_RECORD_CGG_RES_COMUNICADO Registro de datos de la tabla Cgg_res_comunicado.
 * @constructor
 * @base FrmListadoCgg_res_comunicado
 * @author Besixplus Cia. Ltda.
 */

function FrmCgg_res_comunicado(IN_SENTENCIA_CGG_RES_COMUNICADO, IN_RECORD_CGG_RES_COMUNICADO) {
    var inSentenciaCgg_res_comunicado = IN_SENTENCIA_CGG_RES_COMUNICADO;
    var inRecordCgg_res_comunicado = IN_RECORD_CGG_RES_COMUNICADO;
    var urlCgg_res_comunicado = URL_WS + "Cgg_res_comunicado";
    var tituloCgg_res_comunicado = 'Comunicaciones';
    var descCgg_res_comunicado = 'El formulario permite administrar la informaci\u00f3n de comunicaciones.';
    var isEdit = false;
    var rFilaNuevaPersona = Ext.data.Record.create(['CRPER_CODIGO', 'CRDID_CODIGO', 'CRPER_NUM_DOC_IDENTIFIC', 'CRPER_NOMBRES', 'CRPER_APELLIDO_PATERNO', 'CRPER_APELLIDO_MATERNO', 'CRPER_GENERO', 'CRECV_CODIGO', 'CRPER_FECHA_NACIMIENTO']);
    var tmpResolucion;
    var tmpRemitente;
    var tmpRemitentePJ;
    var tmpDestinatario;

    var rNuevoRemitente = new rFilaNuevaPersona({
        CRPER_CODIGO: '',
        CRDID_CODIGO: '',
        CRPER_NUM_DOC_IDENTIFIC: '',
        CRPER_NOMBRES: '',
        CRPER_APELLIDO_PATERNO: '',
        CRPER_APELLIDO_MATERNO: '',
        CRPER_GENERO: 0,
        CRECV_CODIGO: '',
        CRPER_FECHA_NACIMIENTO: ''
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE COMUNICADO
     */
    var txtCrcom_codigo = new Ext.form.TextField({
        id: 'txtCrcom_codigo',
        name: 'txtCrcom_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        value: "KEYGEN",
        hidden: true,
        hideLabel: true,
        allowBlank: false
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
     */
    var txtCrres_codigo = new Ext.form.TextField({
        id: 'txtCrres_codigo',
        name: 'txtCrres_codigo',
        fieldLabel: 'Resoluci\u00f3n',
        anchor: '98%',
        readOnly: 'true',
        submitValue:false
    });
    var rdgTipoRemitente = new Ext.form.RadioGroup({
        id:'rdgTipoRemitente',
        fieldLabel: 'Tipo',
        itemCls: 'x-check-group-alt',
        items: [
            {
                boxLabel: 'Persona Natural',
                id:'rbPersonaNatural',
                name: 'rdgTipoRemitente',
                inputValue: TypeAuspiciante.NATURAL,
                checked: true
            },

            {
                boxLabel: 'Empresa',
                id: 'rbEmpresa',
                name: 'rdgTipoRemitente',
                inputValue: TypeAuspiciante.JURIDICA
            }
        ],
        listeners:{
            change: function(group,radio)
            {
                if (radio.getRawValue() == TypeAuspiciante.NATURAL)
                {
                    btnRegistrarPersonaRemitente.setVisible(true);
                    txtCrcom_remitente.reset();
                }
                else
                {
                    btnRegistrarPersonaRemitente.setVisible(false);
                    txtCrcom_remitente.reset();
                }
            }
        }

    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
     */
    var btnCrres_codigoCgg_res_comunicado = new Ext.Button({
        id: 'btnCrres_codigoCgg_res_comunicado',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpFLCgg_res_resolucion = new FrmListadoCgg_res_resolucion();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_resolucion.getStore(), tmpFLCgg_res_resolucion.getColumnModel());
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord){
                        tmpResolucion = tmpRecord.get('CRRES_CODIGO');
                        txtCrres_codigo.setValue(tmpRecord.get('CRRES_NUMERO_RESOLUCION'));
                    }
                });
                objBusqueda.show();
                ///

            }
        }
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA REMITENTE DEL COMUNICADO
     */
    var btnCrper_codigoCgg_res_comunicado = new Ext.Button({
        id: 'btnCrper_codigoCgg_res_comunicado',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                if (rdgTipoRemitente.getValue().getRawValue() == TypeAuspiciante.NATURAL){

                    var objPersona = new Persona();
                    var objBusqueda = new DlgBusqueda(objPersona.getStore(), objPersona.getColumnModel());
                    objBusqueda.closeHandler(function(){
                        var tmpRecord = objBusqueda.getSelectedRow();
                        if(tmpRecord!=null && tmpRecord!=undefined)
                        {
                            tmpRemitente = tmpRecord.get('CRPER_CODIGO');
                            tmpRemitentePJ = null;
                            txtCrcom_remitente.setValue(tmpRecord.get('CRPER_NOMBRES')+' '+tmpRecord.get('CRPER_APELLIDO_PATERNO')+' '+tmpRecord.get('CRPER_APELLIDO_MATERNO'));
                            rNuevoRemitente = new rFilaNuevaPersona({
                                CRPER_CODIGO: '',
                                CRDID_CODIGO: '',
                                CRPER_NUM_DOC_IDENTIFIC: '',
                                CRPER_NOMBRES: '',
                                CRPER_APELLIDO_PATERNO: '',
                                CRPER_APELLIDO_MATERNO: '',
                                CRPER_GENERO: 0,
                                CRECV_CODIGO: '',
                                CRPER_FECHA_NACIMIENTO: ''
                            });
                        }
                    });
                    objBusqueda.show();
                }else{

                    var tmpFLCgg_res_persona_juridica = new FrmListadoCgg_res_persona_juridica();
                    var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona_juridica.getStore(),tmpFLCgg_res_persona_juridica.getColumnModel());
                    objBusqueda.closeHandler(function(){
                        var tmpRecord = objBusqueda.getSelectedRow();
                        if(tmpRecord!=null && tmpRecord!=undefined){
                            txtCrcom_remitente.setValue(tmpRecord.get('CRPJR_RAZON_SOCIAL'));
                            tmpRemitente = null;
                            tmpRemitentePJ=tmpRecord.get('CRPJR_CODIGO');

                            //

                        }
                    });
                    objBusqueda.show();
                }


            }
        }
    });
    var btnRegistrarPersonaRemitente = new Ext.Button({
        id: 'btnRegistrarPersonaRemitente',
        iconCls: 'iconNuevo',
        tooltip: 'Registro de persona no existente',
        listeners: {
            click: function(){
                var objBeneficiario = new FrmCgg_res_beneficiario(rNuevoRemitente);
                objBeneficiario.closeHandler(function(){
                    //alert(rNuevoRemitente.get('CRPER_CODIGO'));

                    rNuevoRemitente = objBeneficiario.getData();
                    if(rNuevoRemitente.get('CRPER_CODIGO').trim().length > 0 )
                    {

                        tmpRemitente = rNuevoRemitente.get('CRPER_CODIGO');
                        tmpRemitentePJ = null;
                        txtCrcom_remitente.setValue(rNuevoRemitente.get('CRPER_NOMBRES')+' '+rNuevoRemitente.get('CRPER_APELLIDO_PATERNO')+' '+rNuevoRemitente.get('CRPER_APELLIDO_MATERNO'));

                    }

                });
                objBeneficiario.show();
                objBeneficiario.loadData();
            }
        }
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA DESTINATARIO DEL COMUNICADO
     */
    var btnCgg_crper_codigoCgg_res_comunicado = new Ext.Button({
        id: 'btnCgg_crper_codigoCgg_res_comunicado',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                /* var tmpFLCgg_res_persona = new FrmListadoCgg_res_persona();
                 var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona.getStore(), tmpFLCgg_res_persona.getColumnModel());
                 objBusqueda.closeHandler(function () {
                 var tmpRecord = objBusqueda.getSelectedRow();
                 if (tmpRecord){
                 tmpDestinatario = tmpRecord.get('CRPER_CODIGO');
                 txtCrcom_destinatario.setValue(tmpRecord.get('CRPER_NOMBRES')+' '+tmpRecord.get('CRPER_APELLIDO_PATERNO')+' '+tmpRecord.get('CRPER_APELLIDO_MATERNO'));
                 }
                 });
                 objBusqueda.show();*/

                var tmpUsuarioFase = new Cgg_usuario();
                var objBusqueda = new DlgBusqueda(tmpUsuarioFase.getStore(),tmpUsuarioFase.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpDestinatario = tmpRecord.get('CRPER_CODIGO');
                        txtCrcom_destinatario.setValue(tmpRecord.get('CRPER_NOMBRES')+' '+tmpRecord.get('CRPER_APELLIDO_PATERNO')+' '+tmpRecord.get('CRPER_APELLIDO_MATERNO'));
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField PERSONA QUE RECIBE DEL COMUNICADO
     */
    var txtCrcom_destinatario = new Ext.form.TextField({
        id: 'txtCrcom_destinatario',
        name: 'txtCrcom_destinatario',
        fieldLabel: 'Destinatario',
        anchor: '98%',
        allowBlank: false,
        emptyText:'Seleccione el destinatario ...',
        maxLength:100,
        readOnly:true

    });
    /**
     * Ext.form.TextField ASUNTO DEL COMUNICADO
     */
    var txtCrcom_asunto = new Ext.form.TextField({
        id: 'txtCrcom_asunto',
        name: 'txtCrcom_asunto',
        fieldLabel: 'Asunto',
        anchor: '98%',
        allowBlank: false,
        maxLength:200
    });
    /**
     * Ext.form.DateField FECHA DE RECEPCION DEL COMUNICADO
     */
    var dtCrcom_fecha_recepcion = new Ext.form.DateField({
        id: 'dtCrcom_fecha_recepcion',
        name: 'dtCrcom_fecha_recepcion',
        fieldLabel: 'Fecha recepci\u00f3n',
        allowBlank: false,
        format: 'd/m/Y',
        value: new Date(),
        submitValue:false
    });
    /**
     * Ext.form.DateField FECHA DE REVISION
     */
    var dtCrcom_fecha_revision = new Ext.form.DateField({
        id: 'dtCrcom_fecha_revision',
        name: 'dtCrcom_fecha_revision',
        fieldLabel: 'Fecha revisi\u00f3n',
        allowBlank: false,
        format: 'd/m/Y',
        disabled:true,
        value: new Date(),
        submitValue:false
    });
    /**
     * Ext.form.TextField NUMERO DE DOCUMENTO
     */
    var txtCrcom_numero_documento = new Ext.form.TextField({
        id: 'txtCrcom_numero_documento',
        name: 'txtCrcom_numero_documento',
        fieldLabel: 'Numero',
        anchor: '98%',
        allowBlank: false,
        maxLength:20
    });
    /**
     * Ext.form.TextArea DETALLE CORTO DEL COMUNICADO
     */
    var txtCrcom_descripcion = new Ext.form.TextArea({
        id: 'txtCrcom_descripcion',
        name: 'txtCrcom_descripcion',
        fieldLabel: 'Descripci\u00f3n',
        width: '98%',
        allowBlank:false
    });
    /**
     * Ext.form.TextArea OBSERVACION DEL COMUNICADO
     */
    var txtCrcom_observacion = new Ext.form.TextArea({
        id: 'txtCrcom_observacion',
        name: 'txtCrcom_observacion',
        fieldLabel: 'Respuesta',
        width: '98%'
    });
    /**
     * Ext.form.TextField DESCRIPCION DEL DOCUMENTO ADJUNTO
     */
    var txtCrcom_descripcion_adjunto = new Ext.form.TextField({
        id: 'txtCrcom_descripcion_adjunto',
        name: 'txtCrcom_descripcion_adjunto',
        fieldLabel: 'Descripci\u00f3n',
        anchor: '98%'
    });
    /**
     * Ext.form.TextField NOMBRE DEL DOCUMENTO ADJUNTO
     */
    var txtCrcom_nombre_adjunto = new Ext.form.TextField({
        id: 'txtCrcom_nombre_adjunto',
        name: 'txtCrcom_nombre_adjunto',
        fieldLabel: 'Nombre',
        anchor: '98%',
        readOnly:true
    });
    /**
     * Ext.form.TextField PERSONA QUE EMITE EL COMUNICADO
     */
    var txtCrcom_remitente = new Ext.form.TextField({
        id: 'txtCrcom_remitente',
        name: 'txtCrcom_remitente',
        fieldLabel: 'Datos',
        anchor: '98%',
        allowBlank: false,
        emptyText:'Seleccione el remitente ...',
        maxLength:100,
        readOnly:true
    });
    /**
     * ARCHIVO DIGITAL ANEXO
     */
    var filCrcom_adjunto = new Ext.form.FileUploadField({
        id: 'filCrcom_adjunto',
        name: 'filCrcom_adjunto',
        fieldLabel: 'Archivo',
        anchor: '98%',
        disabled: false,
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        },
        listeners:{
            fileselected: function(fb, v){
                txtCrcom_nombre_adjunto.setValue(filCrcom_adjunto.getValue());
            }
        }
    });
    var fldCmnAdjunto = new Ext.form.FieldSet({
        title:'Adjunto',
        collapsible: false,
        collapsed:true,
        autoHeight:true,
        checkboxToggle: true,
        items:[txtCrcom_descripcion_adjunto,
            {
                xtype:'panel',layout:'column',items:[
                {columnWidth:.8,layout:'form',items:[filCrcom_adjunto]},
                {columnWidth:.06,layout:'form',items:[{
                    xtype:'button',
                    iconCls:'iconVer',
                    tooltip:'Ver documento',
                    listeners:{
                        click:function()
                        {
                            if (txtCrcom_nombre_adjunto.getValue() && isEdit)
                            {
                                var url1 = URL_DOC_VIEWER+'?table=cgg_res_comunicado&keyc=crcom_codigo&keyv='+txtCrcom_codigo.getValue() +'&column=Crcom_adjunto&fn='+txtCrcom_nombre_adjunto.getValue()+'&request=view';
                                window.open(url1);
                            }
                        }
                    }

                }]},
                {columnWidth:.06,layout:'form',items:[{
                    xtype:'button',
                    iconCls:'iconDescargar',
                    tooltip:'Descargar documento',
                    listeners:{
                        click:function()
                        {
                            if (txtCrcom_nombre_adjunto.getValue() && isEdit)
                            {
                                var url2 = URL_DOC_VIEWER+'?table=cgg_res_comunicado&keyc=crcom_codigo&keyv='+txtCrcom_codigo.getValue() +'&column=Crcom_adjunto&fn='+txtCrcom_nombre_adjunto.getValue()+'&request=download';
                                window.open(url2);
                            }
                        }
                    }

                }]}
            ]
            }


        ]
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_comunicado
     */
    var btnGuardarCgg_res_comunicado = new Ext.Button({
        id: 'btnGuardarCgg_res_comunicado',
        text: 'Guardar',
        iconCls: 'iconGuardar',
        listeners: {
            click: function () {
                if (pnlCgg_res_comunicado.getForm().isValid() == false) {
                    return;
                }
                pnlCgg_res_comunicado.getEl().mask('Eviando informaci\u00f3n...', 'x-mask-loading');
                pnlCgg_res_comunicado.getForm().submit({
                    url: URL_WS + "Cgg_res_comunicadoSRV",
                    success: function (fp, o) {
                        pnlCgg_res_comunicado.getEl().unmask();
                        Ext.Msg.show({
                            title: tituloCgg_res_comunicado,
                            msg: 'La informaci\u00f3n de la comunicaci\u00f3n ha sido almacenada.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                        winFrmCgg_res_comunicado.close();
                    },
                    failure: function (o) {
                        pnlCgg_res_comunicado.getEl().unmask();
                        Ext.Msg.show({
                            title: tituloCgg_res_comunicado,
                            msg: 'La informaci\u00f3n de la comunicaci\u00f3n no ha podido ser almacenada.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    },
                    params:{
                        request:IN_SENTENCIA_CGG_RES_COMUNICADO,
                        crres_codigo:tmpResolucion,
                        crper_codigo:tmpRemitente?tmpRemitente:null,
                        crpjr_codigo:tmpRemitentePJ?tmpRemitentePJ:null,
                        cgg_crper_codigo:tmpDestinatario,
                        dtCrcom_fecha_recepcion:dtCrcom_fecha_recepcion.getValue().format('Y-m-d H:i:s'),
                        dtCrcom_fecha_revision:dtCrcom_fecha_revision.getValue().format('Y-m-d H:i:s'),
                        inNuevoBeneficiario: rNuevoRemitente.get('CRPER_CODIGO').trim().length == 0 ? null : Ext.util.JSON.encode(rNuevoRemitente.data),
                        crcom_estado_comunicado:TypeEstadoComunicado.REGISTRADO
                    }
                });
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_comunicado.
     */
    var btnCancelarCgg_res_comunicado = new Ext.Button({
        id: 'btnCancelarCgg_res_comunicado',
        text: 'Cancelar',
        iconCls: 'iconCancelar',
        listeners: {
            click: function () {
                pnlCgg_res_comunicado.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_comunicado.
     */
    var btnCerrarCgg_res_comunicado = new Ext.Button({
        id: 'btnCerrarCgg_res_comunicado',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        listeners: {
            click: function () {
                winFrmCgg_res_comunicado.close();
            }
        }
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_comunicado.
     */
    var pnlCgg_res_comunicado = new Ext.form.FormPanel({
        frame: true,
        labelWidth: 100,
        fileUpload:true,
        items: [txtCrcom_codigo,
            {
                xtype: 'panel',
                layout: 'column',
                items: [{
                    columnWidth: .6,
                    layout: 'form',
                    items: [txtCrres_codigo]},
                    {
                        columnWidth: .4,
                        layout: 'form',
                        items: [btnCrres_codigoCgg_res_comunicado]}]
            },
            {
                xtype:'fieldset',
                id :'pnlRemitente',
                title: 'Remitente',
                labelWidth: 82,
                collapsible: false,
                bodyStyle: 'padding:0px 0px 0px 5px',
                layout: 'form',
                autoHeight:true,
                items :
                        [ rdgTipoRemitente,
                            {
                                xtype: 'panel',
                                layout: 'column',
                                items: [
                                    {
                                        columnWidth: .9,
                                        layout: 'form',
                                        items: [txtCrcom_remitente]
                                    },
                                    {
                                        columnWidth: .05,
                                        layout: 'form',
                                        items: [btnCrper_codigoCgg_res_comunicado]
                                    },
                                    {
                                        columnWidth: .05,
                                        layout: 'form',
                                        items: [btnRegistrarPersonaRemitente]
                                    }
                                ]
                            }
                        ]
            },
            {
                xtype: 'panel',
                layout: 'column',
                items: [{
                    columnWidth: .92,
                    layout: 'form',
                    items: [txtCrcom_destinatario]},
                    {
                        columnWidth: .08,
                        layout: 'form',
                        items: [btnCgg_crper_codigoCgg_res_comunicado]}]},
            txtCrcom_numero_documento,
            {type:'panel',layout:'column',items:[
                {columnWidth:.5,layout:'form',items:[dtCrcom_fecha_recepcion]},
                {columnWidth:.5,layout:'form',labelWidth:80,items:[dtCrcom_fecha_revision]}
            ]},
            txtCrcom_asunto,
            txtCrcom_descripcion,
            txtCrcom_observacion,
            fldCmnAdjunto]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_comunicado.
     */
    var winFrmCgg_res_comunicado = new Ext.Window({
        id: 'winFrmCgg_res_comunicado',
        title: tituloCgg_res_comunicado,
        width: 500,
        minWidth: 400,
        maximizable: false,
        minimizable: false,
        modal:true,
        autoHeight:true,
        constrainHeader: true,
        tbar: getPanelTitulo(tituloCgg_res_comunicado, descCgg_res_comunicado),
        items: [pnlCgg_res_comunicado],
        bbar: [btnGuardarCgg_res_comunicado, btnCancelarCgg_res_comunicado, '->', btnCerrarCgg_res_comunicado],
        listeners:{
            show:function()
            {
                if (isEdit)
                {
                    if(inRecordCgg_res_comunicado.get('CRCOM_NOMBRE_ADJUNTO'))
                    {
                        fldCmnAdjunto.expand(false);
                    }
                }
            }
        }
    });
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_comunicado.
     */

    function cargarCgg_res_comunicadoCtrls() {
        if (inRecordCgg_res_comunicado) {
            txtCrcom_codigo.setValue(inRecordCgg_res_comunicado.get('CRCOM_CODIGO'));
            tmpResolucion = inRecordCgg_res_comunicado.get('CRRES_CODIGO');
            txtCrres_codigo.setValue(inRecordCgg_res_comunicado.get('CRRES_NUMERO_RESOLUCION'));
            tmpRemitente = inRecordCgg_res_comunicado.get('CRPER_CODIGO');
            tmpRemitentePJ = inRecordCgg_res_comunicado.get('CRPJR_CODIGO');
            if (inRecordCgg_res_comunicado.get('CRPER_CODIGO'))
            {
                rdgTipoRemitente.setValue('rdgTipoRemitente',TypeAuspiciante.NATURAL);
            }
            else
            {
                rdgTipoRemitente.setValue('rdgTipoRemitente',TypeAuspiciante.JURIDICA);
            }
            tmpDestinatario = inRecordCgg_res_comunicado.get('CGG_CRPER_CODIGO');
            txtCrcom_destinatario.setValue(inRecordCgg_res_comunicado.get('CRCOM_DESTINATARIO'));
            txtCrcom_asunto.setValue(inRecordCgg_res_comunicado.get('CRCOM_ASUNTO'));
            dtCrcom_fecha_recepcion.setValue(truncDate(inRecordCgg_res_comunicado.get('CRCOM_FECHA_RECEPCION')));
            dtCrcom_fecha_revision.setValue(truncDate(inRecordCgg_res_comunicado.get('CRCOM_FECHA_REVISION')));
            txtCrcom_numero_documento.setValue(inRecordCgg_res_comunicado.get('CRCOM_NUMERO_DOCUMENTO'));
            txtCrcom_descripcion.setValue(inRecordCgg_res_comunicado.get('CRCOM_DESCRIPCION'));
            txtCrcom_observacion.setValue(inRecordCgg_res_comunicado.get('CRCOM_OBSERVACION'));
            txtCrcom_descripcion_adjunto.setValue(inRecordCgg_res_comunicado.get('CRCOM_DESCRIPCION_ADJUNTO'));

            txtCrcom_nombre_adjunto.setValue(inRecordCgg_res_comunicado.get('CRCOM_NOMBRE_ADJUNTO'));
            filCrcom_adjunto.setValue(inRecordCgg_res_comunicado.get('CRCOM_NOMBRE_ADJUNTO'));
            txtCrcom_remitente.setValue(inRecordCgg_res_comunicado.get('CRCOM_REMITENTE'));
            isEdit = true;
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_comunicado.
     * @returns ventana winFrmCgg_res_comunicado.
     * @base FrmCgg_res_comunicado.prototype.show
     */
    this.getWindow = function () {
        return winFrmCgg_res_comunicado;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_comunicado.
     * @base FrmCgg_res_comunicado.prototype.loadData
     */
    this.loadData = function () {
        cargarCgg_res_comunicadoCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_comunicado desde una instancia.
 */
FrmCgg_res_comunicado.prototype.show = function () {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_comunicado desde una instancia.
 */
FrmCgg_res_comunicado.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_comunicado,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_comunicado.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_comunicado desde una instancia.
 */
FrmCgg_res_comunicado.prototype.loadData = function () {
    this.loadData();
}