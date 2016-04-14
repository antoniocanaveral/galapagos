/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_tramite.
 * @param {String} INSENTENCIA_CGG_RES_TRAMITE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_TRAMITE Registro de datos de la tabla Cgg_res_tramite.
 * @constructor
 * @base FrmListadoCgg_res_tramite
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_tramite_transeunte_grupo(INSENTENCIA_CGG_RES_TRAMITE,INRECORD_CGG_RES_TRAMITE){
    var inSentenciaCgg_res_tramite = INSENTENCIA_CGG_RES_TRAMITE;
    var inRecordCgg_res_tramite=INRECORD_CGG_RES_TRAMITE;
    var urlCgg_res_tramite=URL_WS+"Cgg_res_tramite";
    var tituloCgg_res_tramite='Registro de tr\u00E1mites de transeuntes';
    var descCgg_res_tramite='El formulario permite establecer informaci\u00f3n de los tr\u00E1mites del CGG.';
    var isEdit = false;
    var tmpRecordTipoSolicitud = null;
    var tmpIsla = null;
    var tmpProceso =  null;
    var tmpAuspiciante = null;
    var tmpAuspiciantePJ = null;    
    var userInfo = null;
    var tmpCargo = null;
    var crfaseSiguiente = null;
    var crfaseActual = null;
    var tmpTiempoEstadia ={
        AUTORIZADO:1
    }
    
    var reglasValidacion = null;    

    var rFilaBeneficiarioNuevo = Ext.data.Record.create([
        'CRTRA_CODIGO',
        'CRPER_CODIGO',
        'CRECV_CODIGO',
        'CRDID_CODIGO',
        'CGNCN_CODIGO',
        'CRPER_NOMBRES',
        'CRPER_APELLIDO_PATERNO',
        'CRPER_APELLIDO_MATERNO',
        'CRPER_NUM_DOC_IDENTIFIC',
        'CRPER_FECHA_NACIMIENTO',
        'CPAIS_CODIGO',
        'CRPER_GENERO',
        'CRPER_REQUISITOS_JSON'
        ]);

    var rBeneficiario = new rFilaBeneficiarioNuevo({
        CRTRA_CODIGO:'',
        CRPER_CODIGO:'',
        CRECV_CODIGO:'',
        CRDID_CODIGO:'',
        CGNCN_CODIGO:'',
        CRPER_NOMBRES:'',
        CRPER_APELLIDO_PATERNO:'',
        CRPER_APELLIDO_MATERNO:'',
        CRPER_NUM_DOC_IDENTIFIC:'',
        CRPER_FECHA_NACIMIENTO:'',
        CPAIS_CODIGO:'',
        CRPER_GENERO:0,
        CRPER_REQUISITOS_JSON:''
    });

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_tramite
     */
    var btnGuardarCgg_res_tramite_transeunte = new Ext.Button({
        id: 'btnGuardarCgg_res_tramite_transeunte',
        text: 'Guardar y despachar',
        iconCls: 'iconGuardarDespachar',
        tooltip: 'Guarda y despacha el tr\u00e1mite actual hacia la fase siguiente establecida.',
        handler: function(){
            if (validarFormulario() == false) {
                return;
            }
            try {
                pnlFrmCgg_res_tramite_transeunte_grupoPrincipal.getEl().mask('Espere un momento por favor.<br>El tiempo de respuesta depender\u00E1 del tama\u00F1o de sus archivos adjuntos.', 'x-mask-loading');
                Ext.getCmp('pnlFrmCgg_res_tramite_transeunte_adjunto').getForm().submit({
                    url: URL_WS + "TramiteTranseunteSRV",
                    success: function(inForm, inAction){
                        try {
                            pnlFrmCgg_res_tramite_transeunte_grupoPrincipal.getEl().unmask();
                            var resultadoTramite = inAction.result.msg;
                            resultadoTramite = eval(resultadoTramite.trim());
                            if (resultadoTramite[0]!==null && resultadoTramite[0].substring(0, 5) == 'CRTRA') {
                                Ext.Msg.show({
                                    title: tituloCgg_res_tramite,
                                    msg: 'El tr\u00E1mite grupal ha sido registrado. El n\u00FAmero de su tr\u00E1mite es: <span class="numeroTramite">'+ new Date().format('Y')+'-'+resultadoTramite[1] + '</span>.<br>Para mayor informaci\u00F3n consulte el historial del tr\u00E1mite.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });

                                if(Ext.getCmp('miChkEmitirComprobante').checked == true){
                                    var reporte = new Reporte("rptComprobanteTramiteTranseuntes", '/Reports/sii/residencia', {
                                        P_CRTRA_CODIGO:resultadoTramite[0]

                                    });
                                    reporte.show();
                                }


                                winFrmCgg_res_tramite_transeunte_grupo.close();
                            }else {
                                Ext.Msg.show({
                                    title: tituloCgg_res_tramite,
                                    msg: 'Se present\u00F3 un problema al momento de guardar su tr\u00E1mite.<br>Error:' + resultadoTramite[1] + '.<br>' + ERR_MESSAGE,
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                        }catch (inErr) {
                            pnlFrmCgg_res_tramite_transeunte_grupoPrincipal.getEl().unmask();
                            Ext.Msg.show({
                                title: tituloCgg_res_tramite,
                                msg: 'Se present\u00F3 un problema al momento de guardar su tr\u00E1mite.<br>Error:' + inErr + '.<br>' + ERR_MESSAGE,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }

                    },
                    failure: function(inForm, inAction){
                        pnlFrmCgg_res_tramite_transeunte_grupoPrincipal.getEl().unmask();
                        Ext.Msg.show({
                            title: tituloCgg_res_tramite,
                            msg: 'Se present\u00F3 un problema al momento de guardar su tr\u00E1mite.<br>Error:' + inAction.result.msg + '.<br>' + ERR_MESSAGE,
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    },
                    params: {
                        inCrper_codigo: tmpAuspiciante,
                        inCrpjr_codigo: tmpAuspiciantePJ,
                        inCgg_crper_codigo: null,
                        inCrpro_codigo: tmpProceso,
                        inCrtst_codigo: tmpRecordTipoSolicitud.get('CRTST_CODIGO'),
                        inCvveh_codigo: null,
                        inCisla_codigo: cbxCisla_codigo.getValue(),
                        inCvmtr_codigo: null,
                        inCrtra_actividad_residencia: tmpCargo,
                        inCrtra_observacion: txtCrtra_observacion.getValue(),
                        inCrtra_dias_permanencia: tmpTiempoEstadia.AUTORIZADO,
                        inCrtra_atencion_cliente: false,
                        inCrtra_comunicado_radial: null,
                        inCrtra_motivo:null,
                        inCrtra_folio: 0,
                        inCrtra_fecha_ingreso:dtCrtra_fecha_ingreso.getValue().format('d/m/Y'),
                        inCrtra_fecha_salida:dtCrtra_fecha_salida.getValue().format('d/m/Y'),
                        inCrfas_codigo: createJSONObject(cbsmFaseTranseunte.getSelections()),
                        inBeneficiarios_JSON: grdCgg_res_persona.getStore().getJsonData()
                    }
                });

            }catch (inErr) {
                pnlFrmCgg_res_tramite_transeunte_grupoPrincipal.getEl().unmask();
                Ext.Msg.show({
                    title: tituloCgg_res_tramite,
                    msg: 'Se present\u00F3 un problema al momento de guardar su tr\u00E1mite.\nError:' + inErr + '.\n' + ERR_MESSAGE,
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
            }
        }
    });

    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_tramite.
     */
    var btnCerrarCgg_res_tramite_transeunte = new Ext.Button({
        id:'btnCerrarCgg_res_tramite_transeunte',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:TypeTooltip.CERRAR,
        listeners:{
            click:function(){
                winFrmCgg_res_tramite_transeunte_grupo.close();
            }
        }
    });
    /**
     * Ext.form.NumberField ANIO DE REALIZACION DEL TRAMITE
     */
    var numCrtra_anio = new Ext.form.NumberField({
        id:'numCrtra_anio',
        nname:'numCrtra_anio',
        fieldLabel :'A\u00F1o',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.DateField FECHA DE INGRESO A LA PROVINCIA DEL SOLICITANTE
     */
    var dtCrtra_fecha_ingreso = new Ext.form.DateField({
        id:'dtCrtra_fecha_ingreso',
        name:'dtCrtra_fecha_ingreso',
        fieldLabel :'Fecha ingreso',
        allowBlank :false,
        minValue:new Date(),
        format:'d/m/Y',
        value:new Date(),
        listeners:{
            change:function(obj,newValue,oldValue){
                if(newValue > dtCrtra_fecha_salida.getValue()){
                    dtCrtra_fecha_salida.setMinValue(newValue);
                    dtCrtra_fecha_salida.setValue(newValue);
                }
                tmpTiempoEstadia.AUTORIZADO = daysBetween(dtCrtra_fecha_salida.getValue(),newValue) + 1;
                tplInfoPersona.overwrite('lblEstadia',tmpTiempoEstadia);

            },
            select:function(obj,value){
                if(value > dtCrtra_fecha_salida.getValue())
                {
                    dtCrtra_fecha_salida.setMinValue(value);
                    dtCrtra_fecha_salida.setValue(value);
                }
                tmpTiempoEstadia.AUTORIZADO = daysBetween(dtCrtra_fecha_salida.getValue(),value) + 1;
                tplInfoPersona.overwrite('lblEstadia',tmpTiempoEstadia);
            }
        }
    });
    /**
     * Ext.form.DateField FECHA DE SALIDA DE LA PROVINCIA DEL SOLICITANTE
     */
    var dtCrtra_fecha_salida = new Ext.form.DateField({
        id:'dtCrtra_fecha_salida',
        name:'dtCrtra_fecha_salida',
        fieldLabel :'Fecha salida',
        allowBlank :false,
        format:'d/m/Y',
        value:new Date(),
        minValue:new Date(),
        listeners:{
            change:function(obj,newValue,oldValue){
                tmpTiempoEstadia.AUTORIZADO = daysBetween(newValue,dtCrtra_fecha_ingreso.getValue()) + 1 ;
                tplInfoPersona.overwrite('lblEstadia',tmpTiempoEstadia);
            },
            select:function(obj,value){
                tmpTiempoEstadia.AUTORIZADO = daysBetween(value,dtCrtra_fecha_ingreso.getValue()) + 1;
                tplInfoPersona.overwrite('lblEstadia',tmpTiempoEstadia);
            }
        }
    });

    var tplInfoPersona = new Ext.Template(
        '<span class="tituloTemplate">Tiempo autorizado:</span><span class="itemTemplate">{AUTORIZADO} (d\u00edas)</span>'
        );

    /**
     * Ext.form.NumberField NUMERO SECUENCIAL UNICO
     */
    var numCrtra_numero = new Ext.form.NumberField({
        id:'numCrtra_numero',
        nname:'numCrtra_numero',
        fieldLabel :'Tr\u00E1mite',
        disabled:true,
        anchor:'98%'
    });
    /**
     * Ext.form.DateField FECHA DE RECEPCION DEL TRAMITE
     */
    var dtCrtra_fecha_recepcion = new Ext.form.DateField({
        id:'dtCrtra_fecha_recepcion',
        name:'dtCrtra_fecha_recepcion',
        fieldLabel :'Fecha recepci\u00F3n',
        allowBlank :false,
        value:new Date(),
        format:'d/m/Y H:i:s',
        disabled:true,
        anchor:'70%'
    });

    /**
     * Ext.form.TextField. OBSERVACION DEL TRAMITE- HISTORIAL FORMATO JSON
     */
    var txtCrtra_observacion = new Ext.form.TextField({
        id: 'txtCrtra_observacion',
        name: 'txtCrtra_observacion',
        fieldLabel: 'Observaci\u00F3n',
        anchor: '100%'
    });

    /**
     * Ext.form.TextField ACTIVIDAD A REALIZAR EN LA PROVINCIA POR PARTE DEL BENEFICIARIO RESIDENCIA
     */
    var txtCrtra_actividad_residencia = new Ext.form.TextField({
        id: 'txtCrtra_actividad_residencia',
        fieldLabel: 'Actividad',
        anchor: '99%',
        readOnly: 'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE CARGO
     */
    var btnCgcrg_codigoCgg_gem_vacante = new Ext.Button({
        id: 'btnCgcrg_codigoCgg_gem_vacante',
        text: '',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpFLCgg_gem_cargo = new FrmListadoCgg_gem_cargo();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_gem_cargo.getStore(), tmpFLCgg_gem_cargo.getColumnModel());
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord!== null && tmpRecord !== undefined) {
                        txtCrtra_actividad_residencia.setValue(tmpRecord.get('CGCRG_NOMBRE'));
                        tmpCargo=tmpRecord.get('CGCRG_CODIGO');
                    }else{
                        txtCrtra_actividad_residencia.setValue('');
                        tmpCargo=null;
                    }
                });
                objBusqueda.show();
            }
        }
    });



    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO TIPO DE SOLICITUD DE RESIDENCIA
     */
    var txtCrtst_codigo = new Ext.form.TextField({
        id:'txtCrtst_codigo',
        name:'txtCrtst_codigo',
        fieldLabel :'Tipo solicitud',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO TIPO DE SOLICITUD DE RESIDENCIA
     */
    var btnCrtst_codigo= new Ext.Button({
        id:'btnCrtst_codigo',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_tipo_solicitud_tramite = new FrmListadoCgg_res_tipo_solicitud_tramite();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_tipo_solicitud_tramite.getStore(),tmpFLCgg_res_tipo_solicitud_tramite.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord!== null && tmpRecord !== undefined){

                        if(verificarSolicitudTranseunte(tmpRecord)==false){
                            limpiarTramiteTranseunte();
                            habilitarTramiteTranseunte(false);
                            return;
                        }

                        pnlFrmCgg_res_tramite_transeunte_grupoPrincipal.getEl().mask('Espere un momento, por favor.', 'x-mask-loading');

                        tmpRecordTipoSolicitud=tmpRecord;
                        txtCrtst_codigo.setValue(tmpRecord.get('CRTST_DESCRIPCION'));

                        //TODO CONSULTAR REGLAS DE VALIDACION
                        listarReglasValidacion(tmpRecordTipoSolicitud.get('CRTST_CODIGO'));

                        // TODO CONSULTAR FASES DEL PROCESO
                        tmpProceso=tmpRecordTipoSolicitud.get('CRPRO_CODIGO');

                        var scpProceso = new SOAPClientParameters();
                        scpProceso.add('inCrpro_codigo', tmpProceso);
                        scpProceso.add('format', TypeFormat.JSON);
                        var tmpCrproRegistro = SOAPClient.invoke(URL_WS + "Cgg_res_proceso", 'select', scpProceso, false, null);
                        try {
                            tmpCrproRegistro = Ext.util.JSON.decode(tmpCrproRegistro);
                            txtCrpro_codigo.setValue(tmpCrproRegistro[0].CRPRO_NOMBRE);
                        }catch (inErr) {
                            txtCrpro_codigo.setValue(NO_DATA_MESSAGE);
                            tmpProceso = null;
                        }

                        //Consulta de la fase actual del proceso.
                        var scpFaseInicio = new SOAPClientParameters();
                        scpFaseInicio.add('inCrpro_codigo', tmpProceso);
                        scpFaseInicio.add('inCisla_codigo', userInfo.CISLA_CODIGO);
                        scpFaseInicio.add('format', TypeFormat.JSON);
                        var tmpFaseInicio = SOAPClient.invoke(URL_WS+"Cgg_res_fase", 'selectFaseInicio', scpFaseInicio, false, null);
                        try{
                            tmpFaseInicio = Ext.util.JSON.decode(tmpFaseInicio);
                            tmpFaseInicio = tmpFaseInicio[0];
                            crfaseActual = tmpFaseInicio;
                        }catch(inErr){
                            crfaseActual = null;
                        }

                        if(crfaseActual !== null){
                            //Establecimiento de la fase siguiente a la actual.
                            var scpFaseSiguiente = new SOAPClientParameters();
                            scpFaseSiguiente.add('inCrfas_codigo', crfaseActual.CRFAS_CODIGO);
                            scpFaseSiguiente.add('inCisla_codigo',userInfo.CISLA_CODIGO);
                            scpFaseSiguiente.add('format', TypeFormat.JSON);
                            var tmpFaseSiguiente = SOAPClient.invoke(URL_WS+"Cgg_res_fase", 'selectFaseSiguiente', scpFaseSiguiente, false, null);
                            try{
                                crfaseSiguiente = Ext.util.JSON.decode(tmpFaseSiguiente);
                                crfaseSiguiente = crfaseSiguiente[0];

                                sCgg_res_fase_usuario.reload({
                                    params:{
                                        inCrfas_codigo:crfaseSiguiente.CRFAS_CODIGO,
                                        inCisla_codigo:userInfo.CISLA_CODIGO,
                                        format:TypeFormat.JSON
                                    }
                                });

                            }catch(inErr){
                                crfaseSiguiente = null;
                            }
                        }

                        sCgg_res_fase.reload({
                            params: {
                                inCrpro_codigo:tmpProceso,
                                inCisla_codigo:userInfo.CISLA_CODIGO,
                                format: TypeFormat.JSON
                            }
                        });

                        dtCrtra_fecha_salida.setValue(new Date().add(Date.DAY, tmpRecord.get('CRTST_NUMERO_DIAS')));
                        tmpTiempoEstadia.AUTORIZADO = daysBetween(dtCrtra_fecha_salida.getValue(),new Date()) + 1 ;
                        tplInfoPersona.overwrite('lblEstadia',tmpTiempoEstadia);
                        pnlFrmCgg_res_tramite_transeunte_grupoPrincipal.getEl().unmask();

                    }
                });
                objBusqueda.show();
            }
        }
    });

    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var txtCgg_crper_codigo  = new Ext.form.TextField({
        id:'txtCgg_crper_codigo',
        name:'txtCgg_crper_codigo',
        fieldLabel :'Beneficiario',
        anchor:'98%'
    //value:"KEYGEN",
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DEL BENEFICIARIO
     */
    var btnCgg_crper_codigoCgg_res_tramite = new Ext.Button({
        id:'btnCgg_crper_codigoCgg_res_tramite',
        iconCls:'iconBuscar',
        tooltip:'Buscar beneficiario',
        listeners:{
            click:function(){
                var objPersona = new Persona();
                var objBusqueda = new DlgBusqueda(objPersona.getStore(), objPersona.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord!=null && tmpRecord!=undefined){
                        txtCgg_crper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('CRPER_APELLIDO_PATERNO'));
                        tmpBeneficiario=tmpRecord.get('CRPER_CODIGO');
                    }
                });
                objBusqueda.show();
            }
        }
    });


    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE AUSPICIANTE PERSONA JURIDICA
     */
    var txtCrpjr_codigo = new Ext.form.TextField({
        id:'txtCrpjr_codigo',
        name:'txtCrpjr_codigo',
        //fieldLabel :'Empresa',
        anchor:'98%',
        readOnly:'true',
        hidden:true
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE AUSPICIANTE PERSONA JURIDICA
     */
    var txtCrpjr_representante_legal= new Ext.form.TextField({
        id:'txtCrpjr_representante_legal',
        name:'txtCrpjr_representante_legal',
        fieldLabel :'Representante',
        anchor:'97%',
        readOnly:'true',
        disabled:true

    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id:'txtCrper_codigo',
        name:'txtCrper_codigo',
        fieldLabel :'Auspiciante',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true'
    //hidden:true
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE
     */
    var btnCrper_codigoCgg_res_tramite = new Ext.Button({
        id:'btnCrper_codigoCgg_res_tramite',
        iconCls:'iconBuscar',
        tooltip:'Buscar auspiciante',
        listeners:{
            click:function(){
                var objBusqueda =null;
                if(rdgTipoPersona.getValue().getRawValue() == TypeAuspiciante.NATURAL){
                    var objPersona = new Persona();
                    objBusqueda =new DlgBusqueda(objPersona.getStore(), objPersona.getColumnModel());
                    objBusqueda.closeHandler(function(){
                        var tmpRecord = objBusqueda.getSelectedRow();
                        if(tmpRecord!=null && tmpRecord!=undefined)
                        {
                            txtCrper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+" "+tmpRecord.get('CRPER_APELLIDO_PATERNO'));
                            tmpAuspiciante=tmpRecord.get('CRPER_CODIGO');
                            tmpAuspiciantePJ = null;
                        }
                    });
                    objBusqueda.show();
                }else{
                    var tmpFLCgg_res_persona_juridica = new FrmListadoCgg_res_persona_juridica();
                    objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona_juridica.getStore(),tmpFLCgg_res_persona_juridica.getColumnModel());
                    objBusqueda.closeHandler(function(){
                        var tmpRecord = objBusqueda.getSelectedRow();
                        if(tmpRecord!=null && tmpRecord!=undefined){
                            txtCrper_codigo.setValue(tmpRecord.get('CRPJR_RAZON_SOCIAL'));
                            tmpAuspiciante = null;
                            tmpAuspiciantePJ=tmpRecord.get('CRPJR_CODIGO');
                            // Consulta de representante Legal
                            var scpRepresentantePersona = new SOAPClientParameters();
                            scpRepresentantePersona.add('inCrpjr_codigo',tmpRecord.get('CRPJR_CODIGO'));
                            scpRepresentantePersona.add('format',TypeFormat.JSON);
                            var tmpRepresentantePersonaRegistro = SOAPClient.invoke(URL_WS+"Cgg_res_representante_legal", 'selectRepresentantePersona', scpRepresentantePersona, false, null);
                            try{
                                tmpRepresentantePersonaRegistro = Ext.util.JSON.decode(tmpRepresentantePersonaRegistro);
                                txtCrpjr_representante_legal.setValue(tmpRepresentantePersonaRegistro[0].CRPER_NOMBRES);
                            }
                            catch(inErr){}
                        //

                        }
                    });
                    objBusqueda.show();
                }
            }
        }
    });

    /**
     * Ext.form.NumberField NUMERO DE DIAS AUTORIZADOS PARA PERMANENCIA DE UNA PERSONA
     */
    var numCrtra_dias_permanencia = new Ext.ux.form.SpinnerField({
        id:'numCrtra_dias_permanencia',
        nname:'numCrtra_dias_permanencia',
        fieldLabel :'Permanencia',
        anchor:'50%',
        value:90,
        submitValue:false
    //TODO CONSULTAR LOS DIAS DE PERMANECIA DE LA SOLICITUD PARA ESTE CAMPO.
    });

    /*
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ISLA
     */
    var cbxCisla_codigo = new Ext.form.ComboBox({
        id:'cbxCisla_codigo',
        name:'cbxCisla_codigo',
        fieldLabel :'Isla',
        anchor:'98%',
        store: SCGG_ISLA,
        displayField:'CISLA_NOMBRE',
        editable:false,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CISLA_NOMBRE}" class="x-combo-list-item">{CISLA_NOMBRE}</div></tpl>',
        valueField:'CISLA_CODIGO'
    });

    var rdgTipoPersona = new Ext.form.RadioGroup({
        id:'rdgTipoPersona',
        fieldLabel: 'Tipo',
        itemCls: 'x-check-group-alt',
        items: [
        {
            boxLabel: 'Persona Natural',
            id:'rbPersonaNatural',
            name: 'rbAuspiciante',
            inputValue: TypeAuspiciante.NATURAL,
            checked: true
        },

        {
            boxLabel: 'Empresa',
            id: 'rbEmpresa',
            name: 'rbAuspiciante',
            inputValue: TypeAuspiciante.JURIDICA
        }
        ],
        listeners:{
            change: function(group,radio){
                txtCrper_codigo.reset();
                txtCrpjr_representante_legal.reset();
                if(radio.getRawValue() == TypeAuspiciante.NATURAL)
                {
                    txtCrpjr_representante_legal.disable();
                }
                else
                {
                    txtCrpjr_representante_legal.enable();

                }

            }
        }

    });

    var pnlCgg_res_persona = new Ext.form.FormPanel({
        id:'pnlCgg_res_persona',
        anchor:'100% 100%',
        height:280,
        region:'north',
        layout:'form',
        frame:true,
        labelWidth :95,
        items:[
        {
            xtype:'fieldset',
            // columnWidth: 0.75,
            title: 'Datos tr\u00e1mite',
            layout: 'form',
            items :[
            {
                xtype:'panel',
                layout:'column',
                items:
                [
                {
                    columnWidth:.5,
                    layout:'form',
                    items:[numCrtra_numero,

                    {
                        xtype:'panel',
                        layout:'column',
                        items:[

                        {
                            columnWidth:.93,
                            layout:'form',
                            items:[txtCrtst_codigo]
                        },

                        {
                            columnWidth:.07,
                            layout:'form',
                            items:[btnCrtst_codigo]
                        }]
                    }
                    ]
                },

                {
                    columnWidth:.5,
                    layout:'form',
                    items:[cbxCisla_codigo]
                }
                ]
            },
            {
                xtype:'panel',
                layout:'column',
                items:[

                {
                    columnWidth:.34,
                    layout:'form',
                    items:[dtCrtra_fecha_ingreso]
                },

                {
                    columnWidth:.34,
                    layout:'form',
                    items:[dtCrtra_fecha_salida]
                },

                {
                    columnWidth:.32,
                    layout:'form',
                    items:[ {
                        xtype:'label',
                        id:'lblEstadia',
                        text:'estadia',
                        tpl:tplInfoPersona,
                        data:tmpTiempoEstadia
                    }]
                },{
                    columnWidth:1,
                    layout: 'column',
                    items: [{
                        columnWidth: .96,
                        layout: 'form',
                        items: [txtCrtra_actividad_residencia]
                    },{
                        columnWidth: .04,
                        layout: 'form',
                        items: [btnCgcrg_codigoCgg_gem_vacante]
                    }]
                }
                ]
            },
            txtCrtra_observacion
            ]
        },
        {
            xtype:'fieldset',
            id :'pnlAuspiciante',
            title: 'Auspiciantes',
            collapsible: true,
            bodyStyle: 'padding:0px 0px 0px 5px',
            layout: 'form',
            autoHeight:true,
            items :[
            rdgTipoPersona,
            {
                xtype:'panel',
                layout:'column',
                items:[

                {
                    columnWidth:.5,
                    layout:'form',
                    items:[{
                        xtype:'panel',
                        layout:'column',
                        items:[

                        {
                            columnWidth:.9,
                            layout:'form',
                            items:[txtCrper_codigo]
                        },

                        {
                            columnWidth:.1,
                            layout:'form',
                            items:[btnCrper_codigoCgg_res_tramite]
                        }]
                    }
                    ]
                },
                {
                    columnWidth:.5,
                    layout:'form',
                    items:[txtCrpjr_representante_legal]
                }
                ]
            }

            ],
            listeners: {
                collapse: function(inPanel){
                    Ext.getCmp('pnlCgg_res_persona').setHeight(180);
                    pnlFrmCgg_res_tramite_transeunte_grupoPrincipal.doLayout(true,true);
                },
                expand: function(inPanel){
                    Ext.getCmp('pnlCgg_res_persona').setHeight(250);
                    pnlFrmCgg_res_tramite_transeunte_grupoPrincipal.doLayout(true,true);
                }
            }
        }
        ]
    });

    var cmAdjuntos=new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            header: "Archivos",
            dataIndex:"ARCHIVO",
            width:'100%',
            sortable: true
        }
        ]);

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_adjunto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_adjunto = new Ext.grid.GridPanel({
        id:'grdCgg_res_adjunto',
        cm:cmAdjuntos,
        store: new Ext.data.JsonStore({}),
        region:'center',
        sm: new Ext.grid.RowSelectionModel({
            singleSelect:true,
            moveEditorOnEnter:false
        }),
        viewConfig: {
            forceFit: true
        },
        loadMask:{
            msg:"Cargando..."
        },
        trackMouseOver: true,
        tbar:['Adjuntos',{
            id:'btnAgregarAdjuntoTramiteTranseunte',
            iconCls:'iconNuevo',
            handler:function(){
                var values = {};
                var dato = "<div width='95%'><INPUT TYPE='file' id='fu"+grdCgg_res_adjunto.getStore().getCount()+"'  name='inAdjuntos'/></div> ";
                values['ARCHIVO'] = dato;
                var record = new Ext.data.Record(values,grdCgg_res_adjunto.getStore().getCount());
                grdCgg_res_adjunto.getStore().add(record);
            }
        },{
            id:'btnEliminarAdjuntoTramiteTranseunte',
            iconCls:'iconEliminar',
            handler:function(){
                var seleccionado = grdCgg_res_adjunto.getSelectionModel().getSelected();
                if(seleccionado !=null){
                    grdCgg_res_adjunto.getStore().remove(seleccionado);
                }else if(grdCgg_res_adjunto.getStore().getCount()>=1){
                    grdCgg_res_adjunto.getSelectionModel().selectLastRow();
                    grdCgg_res_adjunto.getStore().remove(grdCgg_res_adjunto.getSelectionModel().getSelected());
                }
            }
        }]

    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
     */
    var txtCrpro_codigo = new Ext.form.TextField({
        id:'txtCrpro_codigo',
        name:'txtCrpro_codigo',
        fieldLabel :'Proceso',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
     */
    var btnCrpro_codigoCgg_res_tramite = new Ext.Button({
        id:'btnCrpro_codigoCgg_res_tramite',
        iconCls:'iconBuscar',
        disabled:true,
        listeners:{
            click:function(){

            }
        }
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_persona.
     */
    var cmCgg_res_persona = new Ext.grid.ColumnModel([
    {
        dataIndex:'CRPER_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CRECV_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hideable:false,
        hidden:true
    },

    {
        dataIndex:'CRDID_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hideable:false,
        hidden:true
    },

    {
        dataIndex:'CGNCN_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hideable:false,
        hidden:true
    },

    {
        dataIndex:'CRPER_NOMBRES',
        header:'Nombres',
        width:150,
        sortable:true,
        renderer:function(value,obj,record){
            return record.get('CRPER_NOMBRES') + ' ' + record.get('CRPER_APELLIDO_PATERNO') + ' ' + record.get('CRPER_APELLIDO_MATERNO');
        }
    },

    {
        dataIndex:'CRPER_APELLIDO_PATERNO',
        header:'Apellido paterno',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CRPER_APELLIDO_MATERNO',
        header:'Apellido materno',
        width:150,
        sortable:true,
        hidden:true
    },

    {
        dataIndex:'CRPER_NUM_DOC_IDENTIFIC',
        header:'No. doc. identif.',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_FECHA_NACIMIENTO',
        header:'Fecha nacimiento',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CPAIS_CODIGO',
        header:'Pais',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRPER_GENERO',
        header:'Genero',
        width:150,
        sortable:true,
        renderer:function(value){
            if (value == TypeGenero.MASCULINO)
                return "MASCULINO"
            else
                return "FEMENINO"
        }
    },
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona por un campo especifico.
     */
    var gsCgg_res_persona = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_persona",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPER_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CRTRA_CODIGO'
        },

        {
            name:'CRPER_CODIGO'
        },

        {
            name:'CRECV_CODIGO'
        },

        {
            name:'CRDID_CODIGO'
        },

        {
            name:'CGNCN_CODIGO'
        },

        {
            name:'CRPER_NOMBRES'
        },

        {
            name:'CRPER_APELLIDO_PATERNO'
        },

        {
            name:'CRPER_APELLIDO_MATERNO'
        },

        {
            name:'CRPER_NUM_DOC_IDENTIFIC'
        },

        {
            name:'CRPER_FECHA_NACIMIENTO'
        },

        {
            name:'CPAIS_CODIGO'
        },

        {
            name:'CRPER_GENERO'
        },

        {
            name:'CRPER_REQUISITOS_JSON'
        }
        ]),
        sortInfo:{
            field: 'CRECV_CODIGO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_persona en un formato tabular de filas y columnas.
     */
    var grdCgg_res_persona = new Ext.grid.EditorGridPanel({
        cm:cmCgg_res_persona,
        store:gsCgg_res_persona,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        }
    });

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_fase por un campo especifico.
     */
    var sCgg_res_fase =new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_fase",
            method: "selectCGG_RES_PROCESO"
        }),
        reader:new Ext.data.JsonReader({
            },[

            {
                name:'CRFAS_CODIGO'
            },

            {
                name:'CRPRO_CODIGO'
            },

            {
                name:'CRETT_CODIGO'
            },

            {
                name:'CGG_CRETT_CODIGO'
            },

            {
                name:'CRSEC_CODIGO'
            },

            {
                name:'CGG_CRFAS_CODIGO'
            },

            {
                name:'CUSU_CODIGO'
            },

            {
                name:'CRFAS_NOMBRE'
            },

            {
                name:'CRFAS_ORDEN'
            },{
                name:'CRFAS_TAREA_REALIZA'
            },{
                name:'CRFAS_SUBE_ADJUNTO'
            }, {
                name: 'CRFAS_SUMILLA'
            }]),
        baseParams:{
            inCrpro_codigo:null,
            inCisla_codigo:null,
            format:TypeFormat.JSON
        },
        sortInfo:{
            field: 'CRFAS_ORDEN',
            direction: 'ASC'
        },
        listeners:{
            load:function(inThis,inRecords){

                if(crfaseSiguiente == null){
                    return;
                }

                for(var i =0;i<inRecords.length;i++){
                    if(inRecords[i].get('CRFAS_CODIGO')==crfaseSiguiente.CRFAS_CODIGO){
                        var tmpRegistro = [];
                        tmpRegistro[0]=inRecords[i];
                        cbsmFaseTranseunte.selectRecords(tmpRegistro, false);
                        cbsmFaseTranseunte.lock();
                    }
                }
            }
        }
    });

    var btnAgregarPersonaGrupo = new Ext.Button({
        id: 'btnRegistrarPersona',
        iconCls: 'iconNuevo',
        tooltip: 'Agrega un nuevo beneficiario',
        listeners: {
            click:function(){
                if (tmpRecordTipoSolicitud){
                    if(tmpAuspiciante || tmpAuspiciantePJ){
                        var tmpRecordPersona = grdCgg_res_persona.getStore().recordType;
                        rBeneficiario = new tmpRecordPersona({
                            CRTRA_CODIGO:'',
                            CRPER_CODIGO:'',
                            CRECV_CODIGO:'',
                            CRDID_CODIGO:'',
                            CGNCN_CODIGO:'',
                            CRPER_NOMBRES:'',
                            CRPER_APELLIDO_PATERNO:'',
                            CRPER_APELLIDO_MATERNO:'',
                            CRPER_NUM_DOC_IDENTIFIC:'',
                            CRPER_FECHA_NACIMIENTO:'',
                            CPAIS_CODIGO:'',
                            CRPER_GENERO:0,
                            CRPER_REQUISITOS_JSON:''
                        });
                        var objBeneficiario = new FrmCgg_res_beneficiario_transeunte(rBeneficiario,tmpRecordTipoSolicitud);
                        objBeneficiario.closeHandler(function(){
                            if(objBeneficiario.getData().get('CRPER_NUM_DOC_IDENTIFIC').length > 0 ){
                                var flagPersona = false;
                                var rBeneficiario = objBeneficiario.getData();
                                for(var j=0;j<grdCgg_res_persona.getStore().getCount();j++){
                                    var rTmpPersona = grdCgg_res_persona.getStore().getAt(j);
                                    if(rTmpPersona.get('CRPER_NUM_DOC_IDENTIFIC')==rBeneficiario.get('CRPER_NUM_DOC_IDENTIFIC') &&
                                        rTmpPersona.get('CRDID_CODIGO')==rBeneficiario.get('CRDID_CODIGO')){
                                        flagPersona = true;
                                    }
                                }

                                if(flagPersona == false){
                                    grdCgg_res_persona.stopEditing();
                                    grdCgg_res_persona.getStore().insert(0,rBeneficiario);
                                    grdCgg_res_persona.startEditing(0, 0);
                                    grdCgg_res_persona.getView().refresh();
                                    grdCgg_res_persona.getSelectionModel().selectRow(0);
                                }else{
                                    Ext.MsgPopup.msg(tituloCgg_res_tramite, 'El beneficiario ya esta en el listado de tr\u00E1mite, establezca otro, por favor.', MsgPopup.WARNING);
                                }
                            }
                        });
                        objBeneficiario.setRegla(reglasValidacion);
                        objBeneficiario.setAuspiciante(tmpAuspiciante?tmpAuspiciante:tmpAuspiciantePJ);                        
                        objBeneficiario.show();
                        objBeneficiario.loadData();
                    }else{
                        Ext.Msg.show({
                            title: tituloCgg_res_tramite,
                            msg: 'Seleccione un auspiciante, por favor.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.WARNING
                        });
                        btnCrper_codigoCgg_res_tramite.focus(true);
                    }
                }else{
                    Ext.Msg.show({
                        title: tituloCgg_res_tramite,
                        msg: 'Seleccione un tipo de solicitud para continuar, por favor.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.WARNING
                    });
                    btnCrtst_codigo.focus(true);
                }
            }
        }
    });

    var btnEditarPersonaGrupo = new Ext.Button({
        id: 'btnEditarPersonaGrupo',
        iconCls: 'iconEditar',
        tooltip: 'Edita el beneficiario seleccionado del tr\u00E1mite',
        listeners: {
            click:function(){
                if(grdCgg_res_persona.getSelectionModel().getSelected())
                {
                    var tmpIndex = grdCgg_res_persona.getStore().indexOf(grdCgg_res_persona.getSelectionModel().getSelected());
                    var objBeneficiario = new FrmCgg_res_beneficiario_transeunte(grdCgg_res_persona.getSelectionModel().getSelected());
                    objBeneficiario.closeHandler(function(){
                        rBeneficiario = objBeneficiario.getData();
                        grdCgg_res_persona.getStore().removeAt(tmpIndex);
                        grdCgg_res_persona.stopEditing();
                        grdCgg_res_persona.getStore().insert(tmpIndex,rBeneficiario);
                        grdCgg_res_persona.startEditing(0, 0);
                        grdCgg_res_persona.getView().refresh();
                        grdCgg_res_persona.getSelectionModel().selectRow(tmpIndex);
                    });
                    objBeneficiario.setRegla(reglasValidacion);
                    objBeneficiario.setAuspiciante(tmpAuspiciante?tmpAuspiciante:tmpAuspiciantePJ);  
                    objBeneficiario.show();
                    objBeneficiario.loadData();
                }
                else
                {
                    Ext.Msg.show({
                        title: tituloCgg_res_tramite,
                        msg: 'Por favor seleccione un registro para continuar.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                }
            }
        }
    });

    var cbsmFaseTranseunte = new Ext.grid.CheckboxSelectionModel({
        singleSelect:true,
        moveEditorOnEnter:false,
        renderer: function(value, metaData, record){
            if(record.get('CRFAS_CODIGO') !== crfaseSiguiente.CRFAS_CODIGO){
                return;
            }
            return Ext.grid.CheckboxSelectionModel.prototype.renderer.apply(this, arguments);
        }
    });

    /**
     * Ext.data.Store. Almacenamiento de los usuarios de una fase por su isla.
     */
    var sCgg_res_fase_usuario = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_fase_usuario",
            method:"selectUsuariosFase"
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({},[
        {
            name:'CUSU_CODIGO'
        },

        {
            name:'CRPER_NOMBRES'
        },

        {
            name:'CUSU_NOMBRE_USUARIO'
        }
        ]),
        baseParams:{
            inCrfas_codigo:'',
            inCisla_codigo:'',
            format:TypeFormat.JSON
        }
    });

    var cbxCUSU_CODIGOEditor = new Ext.form.ComboBox({
        id:'cbxCUSU_CODIGOEditor',
        store: sCgg_res_fase_usuario,
        displayField:'CRPER_NOMBRES',
        mode: 'local',
        editable:false,
        triggerAction:'all',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CRPER_NOMBRES}" class="x-combo-list-item">{CRPER_NOMBRES}</div></tpl>',
        valueField:'CUSU_CODIGO'
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_fase.
     */
    var cmCgg_res_faseTranseunte = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        cbsmFaseTranseunte,{
            dataIndex: 'CRFAS_CODIGO',
            header: 'Codigo',
            width: 150,
            hidden: true,
            hideable: true
        }, {
            dataIndex: 'CRPRO_CODIGO',
            header: 'Codigo',
            width: 150,
            hidden: true,
            hideable: true
        }, {
            dataIndex: 'CRETT_CODIGO',
            header: 'Codigo',
            width: 150,
            hidden: true,
            hideable: true
        }, {
            dataIndex: 'CGG_CRETT_CODIGO',
            header: 'Crett codigo',
            width: 150,
            hidden: true,
            hideable: true
        }, {
            dataIndex: 'CRSEC_CODIGO',
            header: 'Codigo',
            width: 150,
            hidden: true,
            hideable: true
        }, {
            dataIndex: 'CGG_CRFAS_CODIGO',
            header: 'Crfas codigo',
            width: 150,
            hidden: true,
            hideable: true
        }, {
            dataIndex: 'CGG_CUSU_CODIGO',
            header: 'Cusu codigo',
            width: 150,
            hidden: true,
            hideable: true
        }, {
            dataIndex: 'CRFAS_NOMBRE',
            header: 'Nombre',
            width: 150
        }, {
            dataIndex: 'CRFAS_ORDEN',
            header: 'Orden',
            width: 150,
            hidden:true
        }, {
            dataIndex: 'CRFAS_SUBE_ADJUNTO',
            header: 'Sube adjunto',
            width: 150,
            hidden: true,
            hideable: true
        }, {
            dataIndex:'CUSU_CODIGO',
            header: 'Usuario',
            width: 150,
            sortable: true,
            editor:cbxCUSU_CODIGOEditor,
            renderer:function(inCUSU_CODIGO){
                var scpUsuario = new SOAPClientParameters();
                scpUsuario.add('inCusu_codigo',Ext.util.Format.undef(inCUSU_CODIGO));
                scpUsuario.add('format',TypeFormat.JSON);
                var tmpCusuUsuario = SOAPClient.invoke(URL_WS+"Cgg_usuario", 'selectUsuarioPersona', scpUsuario, false, null);
                try{
                    tmpCusuUsuario = Ext.util.JSON.decode(tmpCusuUsuario);
                    tmpCusuUsuario= tmpCusuUsuario[0];
                    return tmpCusuUsuario.CRPER_NOMBRES+' '+tmpCusuUsuario.CRPER_APELLIDO_PATERNO+' '+tmpCusuUsuario.CRPER_APELLIDO_MATERNO;
                }catch(inErr){
                    return NO_DATA_MESSAGE;
                }
            }
        }, {
            dataIndex: 'CRFAS_SUMILLA',
            header: 'Comentario/Sumilla',
            width: 150,
            sortable: true,
            editor: {
                xtype: 'textfield'
            }
        }, {
            dataIndex: 'CRFAS_TAREA_REALIZA',
            header: 'Actividad',
            width: 150,
            sortable: true
        }]);

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_fase en un formato tabular de filas y columnas.
     */
    var grdCgg_res_faseTranseunte = new Ext.grid.EditorGridPanel({
        cm: cmCgg_res_faseTranseunte,
        store: sCgg_res_fase,
        region:'center',
        frame:true,
        sm:cbsmFaseTranseunte,
        tbar: ['Destinatario/s'],
        loadMask: {
            msg: "Cargando..."
        },
        clicksToEdit: 1,
        listeners: {
            afteredit: function(inObject){
                if (inObject.value.trim().length == 0) {
                    inObject.value = 'Atender, por favor.'
                }
            }
        }
    });

    var tpFrmCgg_res_tramite_transeunte = new Ext.TabPanel({
        id:'tpFrmCgg_res_tramite_transeunte',
        region:'center',
        activeTab:0,
        height:'100%',
        width:'60%',
        items:[{
            layout:'border',
            id:'tpFrmCgg_res_tramiteBeneficiarios',
            title:'Beneficiario(s)',
            tbar:[btnAgregarPersonaGrupo,btnEditarPersonaGrupo,{
                id:'btnEliminarPersonaGrupo',
                iconCls:'iconEliminar',
                handler:function(){
                    var rBeneficiario = grdCgg_res_persona.getSelectionModel().getSelected();
                    if(rBeneficiario!==null && rBeneficiario !== undefined){
                        grdCgg_res_persona.getStore().remove(rBeneficiario);
                    }
                }
            }],
            items:[grdCgg_res_persona]
        },{
            id:'tpFrmCgg_res_tramiteProceso',
            frame: true,
            layout: 'border',
            items: [{
                xtype: 'panel',
                layout: 'column',
                region: 'north',
                anchor: '98%',
                height: 35,
                minHeight: 35,
                items: [{
                    columnWidth: .93,
                    layout: 'form',
                    items: [txtCrpro_codigo]
                }, {
                    columnWidth: .07,
                    layout: 'form',
                    items: [btnCrpro_codigoCgg_res_tramite]
                }]
            }, grdCgg_res_faseTranseunte],
            title: 'Proceso - seguimiento'
        }]
    });

    var pnlFrmCgg_res_tramite_transeunte_adjunto = new Ext.FormPanel({
        id:'pnlFrmCgg_res_tramite_transeunte_adjunto',
        region:'east',
        layout:'border',
        fileUpload:true,
        split:true,
        width:'40%',
        collapsible:true,
        collapsed:true,
        items:[grdCgg_res_adjunto]
    });

    var pnlFrmCgg_res_tramite2= new Ext.Panel({
        id:'pnlFrmCgg_res_tramite2',
        region:'center',
        layout:'border',
        anchor:'100% 100%',
        items:[tpFrmCgg_res_tramite_transeunte,pnlFrmCgg_res_tramite_transeunte_adjunto]
    });

    var pnlFrmCgg_res_tramite_transeunte_grupoPrincipal = new Ext.Panel({
        id:'pnlFrmCgg_res_tramite_transeunte_grupoPrincipal',
        region:'center',
        layout:'border',
        items:[pnlCgg_res_persona,pnlFrmCgg_res_tramite2]
    });

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_tramite.
     */
    var winFrmCgg_res_tramite_transeunte_grupo = new Ext.Window({
        id:'winFrmCgg_res_tramite_transeunte_grupo',
        iconCls:'iconRegistrarTramite',
        title:tituloCgg_res_tramite,
        tbar:getPanelTitulo(tituloCgg_res_tramite,descCgg_res_tramite),
        layout:'border',
        items:[pnlFrmCgg_res_tramite_transeunte_grupoPrincipal],
        width:800,
        minWidth:600,
        height:600,
        minHeight:500,
        maximizable:true,
        constrain:true,
        modal:true,
        bbar:[btnGuardarCgg_res_tramite_transeunte,{
            id:'btnOpciones',
            text: 'Opciones',
            menu: {
                xtype: 'menu',
                plain: true,
                items: [
                {
                    id: 'miChkEmitirComprobante',
                    checked: true,
                    text: 'Emitir comprobante'
                }
                ,{
                    id: 'miChkSugerirSumilla',
                    checked: true,
                    text: 'Sugerir a comentario/sumilla vac\u00EDa'
                }]
            }
        },
        '->',
        btnCerrarCgg_res_tramite_transeunte],
        listeners:{
            show:function(){

                userInfo = new UserSession().getUserData();

                var scpIsla = new SOAPClientParameters();
                scpIsla.add('inCisla_codigo',userInfo.CISLA_CODIGO);
                scpIsla.add('format',TypeFormat.JSON);

                SOAPClient.invoke(URL_WS+'Cgg_isla', 'select', scpIsla, true, function(inServiceResponse){
                    var tmpIsla1 = null;
                    try{
                        tmpIsla1 = Ext.util.JSON.decode(inServiceResponse);
                        tmpIsla1=tmpIsla1[0];
                        cbxCisla_codigo.setValue(tmpIsla1.CISLA_CODIGO);
                    }catch(inErr){
                        cbxCisla_codigo.setValue(NO_DATA_MESSAGE);
                    }
                });

                Ext.getCmp('tpFrmCgg_res_tramite_transeunte').activate('tpFrmCgg_res_tramiteProceso');
                Ext.getCmp('tpFrmCgg_res_tramite_transeunte').activate('tpFrmCgg_res_tramiteBeneficiarios');
                habilitarTramiteTranseunte(false);

            }
        }
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_tramite_transeunte_grupo.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_tramite_transeunte_grupo_Ctrls(inEstado){
        var estado=!inEstado;
        txtCrtra_codigo.setDisabled(estado);
        txtCrper_codigo.setDisabled(estado);
        txtCrpjr_codigo.setDisabled(estado);
        txtCgg_crper_codigo.setDisabled(estado);
        txtCrpro_codigo.setDisabled(estado);
        txtCrtst_codigo.setDisabled(estado);
        cbxCisla_codigo.setDisabled(estado);
        numCrtra_anio.setDisabled(estado);
        numCrtra_numero.setDisabled(estado);
        dtCrtra_fecha_recepcion.setDisabled(estado);
        txtCrtra_actividad_residencia.setDisabled(estado);
        numCrtra_dias_permanencia.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_tramite_transeunte_grupo.
     */
    function cargarCgg_res_tramiteCtrls(){
        if(inRecordCgg_res_tramite){

    }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_tramite_transeunte_grupo.
     * @returns ventana winFrmCgg_res_tramite_transeunte_grupo.
     * @base FrmCgg_res_tramite_transeunte_grupo.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_tramite_transeunte_grupo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_tramite_transeunte_grupo.
     * @base FrmCgg_res_tramite_transeunte_grupo.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_tramiteCtrls();
    }

    /**
     *Funcion. Valida las reglas basicas de control sobre el formulario.
     *@return Verdadero/falso a la validacion de los controles del formulario.
     */
    function validarFormulario(){
        var flagValidar = true;

        if ((tmpRecordTipoSolicitud == null || tmpRecordTipoSolicitud == undefined)) {
            txtCrtst_codigo.markInvalid('Establezca el tipo de solicutud del tr\u00E1mite, por favor.');
            btnCrtst_codigo.focus();
            flagValidar = false;
            return flagValidar;
        }

        if(tmpCargo == null){
            txtCrtra_actividad_residencia.markInvalid('Establezca la actividad del tr\u00E1mite, por favor.');
            btnCgcrg_codigoCgg_gem_vacante.focus();
            flagValidar = false;
            return flagValidar;
        }

        if (rdgTipoPersona.getValue().getRawValue() == TypeAuspiciante.NATURAL){
            if(tmpAuspiciante == null){
                txtCrper_codigo.markInvalid('Establezca el auspiciante del tr\u00E1mite, por favor.');
                btnCrper_codigoCgg_res_tramite.focus();
                flagValidar = false;
                return flagValidar;
            }
        }else{
            if(tmpAuspiciantePJ== null){
                txtCrpjr_representante_legal.markInvalid('Establezca el auspiciante del tr\u00E1mite, por favor.');
                btnCrper_codigoCgg_res_tramite.focus();
                flagValidar = false;
                return flagValidar;
            }
        }

        if(grdCgg_res_persona.getStore().getCount()==0){
            Ext.Msg.show({
                title: tituloCgg_res_tramite,
                msg: 'Establezca al menos un beneficiario para el tr\u00e1mite, por favor.',
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.WARNING
            });
            Ext.getCmp('tpFrmCgg_res_tramite_transeunte').activate('tpFrmCgg_res_tramiteBeneficiarios');
            flagValidar = false;
            return flagValidar;
        }
		tmpFecha = new Date();
		fecha_Actual= new Date(tmpFecha.getFullYear(),tmpFecha.getMonth(),tmpFecha.getDate());
		if (dtCrtra_fecha_ingreso.getValue()<fecha_Actual){
			flagValidar=false;
		}
		
        if (Ext.getCmp('miChkSugerirSumilla').checked == true){
            if (txtCrtra_observacion.getValue().trim().length == 0) {
                grdCgg_res_faseTranseunte.getSelectionModel().getSelected().set('CRFAS_SUMILLA', 'Atender, por favor.');
            }else {
                grdCgg_res_faseTranseunte.getSelectionModel().getSelected().set('CRFAS_SUMILLA', txtCrtra_observacion.getValue().trim());
            }
        }

        return flagValidar;
    }   

    /**
     *Funcion. Verifica los controles y permisos deacuerdo a la informacon de tipo de solicitud.
     *La funcion cumple con reglas basicas de validar y habilitar componentes deacuerdo al tipo de solicitud.
     *@param inCrtst_data Informacion de la solicutud.
     *@return Verdadero/Falso.
     */
    function verificarSolicitudTranseunte(inCrtst_data){
        var flagSolicitud  = true;

        if (inCrtst_data.get('CRTST_APLICA_TRAMITE') !== true || new Tramite().iniciaTramite(inCrtst_data.get('CRTST_CODIGO'), userInfo.CUSU_CODIGO)==false) {
            Ext.Msg.show({
                title: tituloCgg_res_tramite,
                msg: 'El tipo de solicitud o el usuario no puede iniciar un tr\u00E1mite, seleccione otro por favor.',
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.WARNING
            });
            return false;
        }

        if (inCrtst_data.get('CRTST_APLICA_GRUPO') ==false){
            Ext.Msg.show({
                title: tituloCgg_res_tramite,
                msg: 'Este formulario no aplica para solicitudes normales de tr\u00E1mites, seleccione otro por favor.',
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.WARNING
            });
            return false;
        }

        habilitarTramiteTranseunte(true);

        return flagSolicitud;
    }

    /**
     *Habilita los paneles principales del tramite de transeunte.
     *@param inFlag true|false.
     */
    function habilitarTramiteTranseunte(inFlag){
        dtCrtra_fecha_ingreso.setDisabled(!inFlag);
        dtCrtra_fecha_salida.setDisabled(!inFlag);
        txtCrtra_actividad_residencia.setDisabled(!inFlag);
        btnCgcrg_codigoCgg_gem_vacante.setDisabled(!inFlag);
        txtCrtra_observacion.setDisabled(!inFlag);

        Ext.getCmp('pnlAuspiciante').setDisabled(!inFlag);
        pnlFrmCgg_res_tramite2.setDisabled(!inFlag);
    }

    /**
     *Limpia todos lo controles del formulario.
     */
    function limpiarTramiteTranseunte(){
        txtCrtst_codigo.setValue('');
        dtCrtra_fecha_ingreso.setValue(new Date());
        dtCrtra_fecha_salida.setValue(new Date());
        txtCrtra_actividad_residencia.setValue('');
        txtCrtra_observacion.setValue('');
        rdgTipoPersona.setValue('rbPersonaNatural',true);
        txtCrper_codigo.setValue('');
        txtCgg_crper_codigo.setValue('');

        grdCgg_res_persona.getStore().removeAll();
        grdCgg_res_faseTranseunte.getStore().removeAll();
    }

    function listarReglasValidacion(inCrtst_codigo){
        function CallBackReglasTipoSolicitud(r)
        {
            try
            {                
                reglasValidacion = r;                
            }
            catch(inErr)
            {
                reglasValidacion = '[]';
            }

        }
        var param = new SOAPClientParameters();
        param.add('inCrtst_codigo',inCrtst_codigo);
        param.add('format',TypeFormat.JSON);
        SOAPClient.invoke(URL_WS+'Cgg_regla_validacion' ,'selectReglaTipoSolicitud',param, true,CallBackReglasTipoSolicitud);
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_tramite_transeunte_grupo desde una instancia.
 */
FrmCgg_res_tramite_transeunte_grupo.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_tramite_transeunte_grupo desde una instancia.
 */
FrmCgg_res_tramite_transeunte_grupo.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_tramite_transeunte_grupo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_tramite_transeunte_grupo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_tramite_transeunte_grupo desde una instancia.
 */
FrmCgg_res_tramite_transeunte_grupo.prototype.loadData = function(){
    this.loadData();
}
