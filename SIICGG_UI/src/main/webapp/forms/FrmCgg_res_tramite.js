/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_tramite.
 * @param {String} INSENTENCIA_CGG_RES_TRAMITE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_TRAMITE Registro de datos de la tabla Cgg_res_tramite.
 * @constructor
 * @base FrmListadoCgg_res_tramite
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_tramite(INSENTENCIA_CGG_RES_TRAMITE, INRECORD_CGG_RES_TRAMITE){
    var inRecordCgg_res_tramite = INRECORD_CGG_RES_TRAMITE;
    var tituloCgg_res_tramite = 'Registro de tr\u00E1mites';
    var descCgg_res_tramite = 'El formulario permite establecer informaci\u00f3n de los tr\u00E1mites.';
    var isEdit = false;
    var tmpIsla = null;
    var tmpEstadoTramite = null;
    var tmpTipoSolicitud = null;
    var tmpProceso = null;
    var tmpAuspiciante = null;
    var tmpPersonaJuridica = null;
    var tmpDepositoGarantia = null;
    var tmpBeneficiario = null;
    var tmpCrper_codigo = null;
    var tmpCargo = null;
    var disable = true;
    var rFilaBeneficiarioNuevo = Ext.data.Record.create(['CRPER_CODIGO', 'CRDID_CODIGO', 'CRPER_NUM_DOC_IDENTIFIC', 'CRPER_NOMBRES', 'CRPER_APELLIDO_PATERNO', 'CRPER_APELLIDO_MATERNO', 'CRPER_GENERO', 'CRECV_CODIGO', 'CRPER_FECHA_NACIMIENTO']);
    var colReglaValidacion = null;
    var userInfo = null;
    var crfaseSiguiente = null;
    var crfaseActual = null;
    var isVehiculo = false;
    var tmpDatos = new Array();
    var crtstPadre = null;
    var reglaValidacion = null;
    var strVehiculosActuales;    
    var esHistorico = false;
    var crgrtCodigo = null;
    var flagAuspiciante = false;
    var tmpPersonaAuspiciante = new Persona();
    var tmpPersonaBeneficiario = new Persona();
    var tmpVehiculo = {
        VEHICULO:'KEYGEN',
        MOTOR:'KEYGEN'
    };
    var tmpVehiculoReemplazo = {
        VEHICULO:null,
        MOTOR:null
    };
    var tmpTipoTramite = 0;
    var tmpTipoVehiculo = 0;
    var tmpAccionVehiculo;

    /******************INICIO DE DEFINICION DE VARIABLES PARA REGLA DE VALIDACION DE INFORMAICON*******************/
    var crtstCodigo = null;
    var crperCodigo = null;
    var cggcrperCodigo = null;
    var crperNumDocIdentific=null;
    var cggCrperFechaNacimiento = null;
    var crdptCodigo = null;
    var cvvehCodigo;
    var cvmtrCodigo;
    /******************FIN DE DEFINICION DE VARIABLES PARA REGLA DE VALIDACION DE INFORMAICON*******************/

    var crettSoloGuardado = null;

    /*********************SECCION PARA CARGA DE INFORMACION COMO CONSTRUCTOR*************/
    var scpEstadoGuardado = new SOAPClientParameters({
        inCgcnf_configuracion:'ESTADO TRAMITE SOLO GUARDADO',
        format:TypeFormat.JSON
    });

    var tmpEstado =  SOAPClient.invoke(URL_WS+'Cgg_configuracion', 'selectCGCNF_CONFIGURACION', scpEstadoGuardado, false, null);
    try{
        var inServiceResponse = Ext.util.JSON.decode(tmpEstado);
        inServiceResponse=inServiceResponse[0] ;
        crettSoloGuardado = inServiceResponse.CGCNF_VALOR_CADENA;
    }catch(inErr){
        crettSoloGuardado = null;
    }
    userInfo = new UserSession().getUserData();
    /*********************FIN SECCION PARA CARGA DE INFORMACION COMO CONSTRUCTOR*************/

    var rBeneficiario = new rFilaBeneficiarioNuevo({
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

//MO
    /*var rFilaDepositoGarantia = Ext.data.Record.create(['CRDPT_CODIGO', 'CRDPT_NUMERO_DOCUMENTO']);
    var rDepositoGarantia = new rFilaDepositoGarantia({
        CRDPT_CODIGO: '',
        CRDPT_NUMERO: '',
        CRGRT_CODIGO:''
    });*/
//

    var rFilaAuspiciante = Ext.data.Record.create(['CRPER_CODIGO', 'CRPER_NOMBRES', 'CRPER_APELLIDO_PATERNO']);
    var rAuspiciante = new rFilaAuspiciante({
        CRPER_CODIGO: '',
        CRPER_NOMBRES: '',
        CRPER_APELLIDO_PATERNO: ''
    });

    var rFilaIsla = Ext.data.Record.create(['CISLA_CODIGO', 'ISLA_NOMBRE']);
    var rIsla = new rFilaIsla({
        CISLA_CODIGO: '',
        CISLA_NOMBRE: ''
    });
    var rFilaProceso = Ext.data.Record.create(['CRPRO_CODIGO', 'CRPRO_NOMBRE']);
    var rProcesoNombre = new rFilaProceso({
        CRPRO_CODIGO: '',
        CRPRO_NOMBRE: ''
    });
    var rFilaPersonaJuridicaRazonSocial = Ext.data.Record.create(['CRPJR_CODIGO', 'CRPJR_RAZON_SOCIAL']);
    var rPersonaJuridicaRazonSocial = new rFilaPersonaJuridicaRazonSocial({
        CRPJR_CODIGO: '',
        CRPJR_RAZON_SOCIAL: ''
    });

    var tmpInfoVehiculo = new Ext.XTemplate(
        '<table width="100%" height="100%" cellpadding="0">'+
        '<tr rowspan="0">'+
        '<td><div class="tituloTemplate">Residencia</div></td>'+
        '<td><div class="itemTemplate">{CRPER_NUMERO_RESIDENCIA}</div></td>'+
        '<td><div class="tituloTemplate"> Tipo:</div></td>'+
        '<td><div class="itemTemplate"><div id="divTipoResidencia"></div></div></td>'+
        '</tr>'+
        '<tr rowspan="0">'+
        '<td><div class="tituloTemplate">Nombres:</div></td>'+
        '<td><div class="itemTemplate">{CRPER_NOMBRES}</div></td>'+
        '<td><div class="tituloTemplate"> Apellidos:</div></td>'+
        '<td><div class="itemTemplate">{CRPER_APELLIDO_PATERNO} {CRPER_APELLIDO_MATERNO}</div></td></tr>'+
        '</table>'
        );

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGSITRO DE TRAMITE
     */
    var txtCrtra_codigo = new Ext.form.TextField({
        id: 'txtCrtra_codigo',
        name: 'txtCrtra_codigo',
        fieldLabel: 'Codigo',
        anchor: '98%',
        allowBlank: false,
        value: "KEYGEN",
        hidden: true,
        hideLabel: true,
        maxLength: 20
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE
     */
    var txtCrper_codigo = new Ext.form.TextField({
        id: 'txtCrper_codigo',
        name: 'txtCrper_codigo',
        fieldLabel: 'Auspiciante',
        anchor: '98%',
        readOnly: true
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE AUSPICIANTE
     */
    var btnCrper_codigoCgg_res_tramite = new Ext.Button({
        id: 'btnCrper_codigoCgg_res_tramite',
        iconCls: 'iconBuscar',
        tooltip: 'Buscar auspiciante',
        listeners: {
            click: function(){
                var objBusqueda = new DlgBusqueda(tmpPersonaAuspiciante.getStore(), new Persona().getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord != null && tmpRecord != undefined) {
                        txtCrper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES') + ' ' + tmpRecord.get('CRPER_APELLIDO_PATERNO')+ ' ' + (tmpRecord.data.CRPER_APELLIDO_MATERNO?tmpRecord.data.CRPER_APELLIDO_MATERNO:''));
                        tmpAuspiciante = tmpRecord;
                        checkIsVehiculo();
                        rPersonaJuridicaRazonSocial = null;
                        txtCrpjr_codigo.setValue(undefined);
                    }
                });
                objBusqueda.show();
            }
        }
    });

    function checkIsVehiculo(){
        if(isVehiculo){
            if(Ext.getCmp('pnlTramiteVehiculo')){
                Ext.getCmp('pnlTramiteVehiculo').setDisabled(false);
                tpFrmCgg_res_tramite.setActiveTab(Ext.getCmp('pnlTramiteVehiculo'));
            }
            if(tmpAuspiciante)
                strVehiculosActuales.baseParams.inCrper_codigo = tmpAuspiciante.data.CRPER_CODIGO;
            
            if(rBeneficiario)
                strVehiculosActuales.baseParams.inCrper_codigo = rBeneficiario.get('CRPER_CODIGO')=='KEYGEN' ? '':rBeneficiario.get('CRPER_CODIGO');
            
            strVehiculosActuales.baseParams.inCvveh_tipo = 0;

            cbxCaducidadTramite.show();
            dtCrtra_fecha_salida.show();
            
            strVehiculosActuales.reload();
            if(cbxVehiculosActuales.store)
                cbxVehiculosActuales.reset();
            if(cbxMotoresActuales.store)
                cbxMotoresActuales.reset();
        }
    }
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE AUSPICIANTE PERSONA JURIDICA
     */
    var txtCrpjr_codigo = new Ext.form.TextField({
        id: 'txtCrpjr_codigo',
        name: 'txtCrpjr_codigo',
        fieldLabel: 'Empresa',
        anchor: '98%',
        readOnly: 'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE AUSPICIANTE PERSONA JURIDICA
     */
    var btnCrpjr_codigoCgg_res_tramite = new Ext.Button({
        id: 'btnCrpjr_codigoCgg_res_tramite',
        iconCls: 'iconBuscar',
        tooltip: 'Buscar persona jur\u00EDdica',
        listeners: {
            click: function(){
                var tmpFLCgg_res_persona_juridica = new FrmListadoCgg_res_persona_juridica();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_persona_juridica.getStore(), tmpFLCgg_res_persona_juridica.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord != null && tmpRecord != undefined) {
                        txtCrpjr_codigo.setValue(tmpRecord.get('CRPJR_RAZON_SOCIAL'));
                        rPersonaJuridicaRazonSocial=tmpRecord;

                        //consulta de representante legal.
                        var scpRepresentante = new SOAPClientParameters({
                            inCrpjr_codigo:rPersonaJuridicaRazonSocial.get('CRPJR_CODIGO'),
                            format:TypeFormat.JSON
                        });

                        var tmpRepresentante = SOAPClient.invoke(URL_WS+'Cgg_res_representante_legal', 'selectRepresentantePersona', scpRepresentante, false, null);
                        try{
                            tmpRepresentante = Ext.util.JSON.decode(tmpRepresentante)[0];
                            if(tmpRepresentante.CRPER_CODIGO == null || tmpRepresentante.CRPER_CODIGO == undefined){
                                tmpAuspiciante = null;
                                txtCrper_codigo.setValue('');
                            }else{
                                rAuspiciante.set('CRPER_CODIGO', tmpRepresentante.CRPER_CODIGO!==undefined ? tmpRepresentante.CRPER_CODIGO:'');
                                rAuspiciante.set('CRPER_NOMBRES', tmpRepresentante.CRPER_NOMBRES!==undefined ? tmpRepresentante.CRPER_NOMBRES :'');
                                rAuspiciante.set('CRPER_APELLIDO_PATERNO', tmpRepresentante.CRPER_APELLIDO_PATERNO!==undefined ? tmpRepresentante.CRPER_APELLIDO_PATERNO:'');
                                txtCrper_codigo.setValue(rAuspiciante.get('CRPER_NOMBRES') + " " + rAuspiciante.get('CRPER_APELLIDO_PATERNO'));
                                tmpAuspiciante = rAuspiciante;
                                checkIsVehiculo();
                            }
                        }catch(inErr){
                            tmpAuspiciante = null;
                            txtCrper_codigo.setValue('');
                            Ext.MsgPopup.msg(tituloCgg_res_tramite, "Se produjo una inusualidad al consultar el comunicado.<br>Error:"+inErr+'<br>'+ERR_MESSAGE, MsgPopup.WARNING);
                        }
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DEL BENEFICIARIO
     */
    var txtCgg_crper_codigo = new Ext.form.TextField({
        id: 'txtCgg_crper_codigo',
        name: 'txtCgg_crper_codigo',
        fieldLabel: 'Beneficiario',
        anchor: '98%',
        allowBlank: false,
        readOnly: true
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DEL BENEFICIARIO
     */
    var btnCgg_crper_codigoCgg_res_tramite = new Ext.Button({
        id: 'btnCgg_crper_codigoCgg_res_tramite',
        iconCls: 'iconBuscar',
        tooltip: 'Buscar beneficiario',
        listeners: {
            click: function(){
                var objBusqueda = new DlgBusqueda(tmpPersonaBeneficiario.getStore(), new Persona().getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord != null && tmpRecord != undefined) {
                        txtCgg_crper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES') + " " + tmpRecord.get('CRPER_APELLIDO_PATERNO')+ ' ' + (tmpRecord.data.CRPER_APELLIDO_MATERNO?tmpRecord.data.CRPER_APELLIDO_MATERNO:''));                        
                        rBeneficiario = tmpRecord;                        
                        checkIsVehiculo();
                    }
                });
               objBusqueda.show();                                
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
     */
    var txtCrpro_codigo = new Ext.form.TextField({
        id: 'txtCrpro_codigo',
        name: 'txtCrpro_codigo',
        fieldLabel: 'Proceso',
        anchor: '98%',
        allowBlank: false,
        readOnly: 'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
     */
    var btnCrpro_codigoCgg_res_tramite = new Ext.Button({
        id: 'btnCrpro_codigoCgg_res_tramite',
        iconCls: 'iconBuscar',
        disabled:true,
        listeners: {
            click: function(){
                var tmpFLCgg_res_proceso = new FrmListadoCgg_res_proceso();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_proceso.getStore(), tmpFLCgg_res_proceso.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord) {
                        txtCrpro_codigo.setValue(tmpRecord.get('CRPRO_NOMBRE'));
                        tmpProceso = tmpRecord.get('CRPRO_CODIGO');

                        new ManagerCookies().erase('CGG_RES_PROCESO');
                        new ManagerCookies().create('CGG_RES_PROCESO', Ext.util.JSON.encode(tmpRecord.data), 168);
                        sCgg_res_fase.reload({
                            params: {
                                inCrpro_codigo: tmpRecord.get('CRPRO_CODIGO'),
                                format: TypeFormat.JSON
                            }
                        });
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
        id: 'txtCrtst_codigo',
        name: 'txtCrtst_codigo',
        fieldLabel:'Tipo solicitud',
        anchor: '98%',
        allowBlank: false,
        readOnly: 'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO TIPO DE SOLICITUD DE RESIDENCIA
     */
    var btnCrtst_codigo = new Ext.Button({
        id: 'btnCrtst_codigo',
        iconCls: 'iconBuscar',
        listeners: {
            click: function(){
                var tmpFLCgg_res_tipo_solicitud_tramite = new FrmListadoCgg_res_tipo_solicitud_tramite();
                var tmpStore = tmpFLCgg_res_tipo_solicitud_tramite.getStore();
                tmpStore.baseParams.inSW = true;
                if(isVehiculo){
                    tmpStore.baseParams.inCrtst_codigo = SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','12')).get('CGCNF_VALOR_CADENA');
                }
                var objBusqueda = new DlgBusqueda(tmpStore, tmpFLCgg_res_tipo_solicitud_tramite.getColumnModel());
                objBusqueda.closeHandler(function(){
                    cargarSolicitud(objBusqueda.getSelectedRow(),false);
                });
                objBusqueda.show();
            }
        }
    });

    /**
     *Carga los datos y consideraciones de un tipo de solicitud de tramite.
     *@param {Ext.data.record} inCrtstData Record de tipo de solicitud.
     *@param inHistorico Indica si el tramite es consultado del historial de tramite por lo que carga la solicitud pero no controla el usuario.
     */
    function cargarSolicitud(inCrtstData,inHistorico){
        var tmpRecord = inCrtstData;
        if (tmpRecord !== null && tmpRecord !== undefined) {

            var tmpParams = new SOAPClientParameters();
            tmpParams.add('inCrtst_codigo', tmpRecord.data.CRTST_CODIGO);
            tmpParams.add('format', TypeFormat.JSON);
            var tmpTSTOpciones = SOAPClient.invoke(URL_WS + "Cgg_res_tst_aplica", 'selectCGG_RES_TIPO_SOLICITUD_TRAMITE', tmpParams, false, null);
            tmpTSTOpciones = Ext.util.JSON.decode(tmpTSTOpciones);
            if(tmpTSTOpciones){
                var tmpSWAuspicianteTodos = false;
                var tmpSWBeneficiarioTodos = false;
                for(i = 0; i < tmpTSTOpciones.length; i++){
                    if(tmpTSTOpciones[i].CRTSO_CODIGO == 'CRTSO2')
                        Ext.getCmp('pnlTrmAuspiciante').setVisible(tmpTSTOpciones[i].APLICA);
                    else if(tmpTSTOpciones[i].CRTSO_CODIGO == 'CRTSO1')
                        Ext.getCmp('pnlTrmEmpresa').setVisible(tmpTSTOpciones[i].APLICA);
                    else if(tmpTSTOpciones[i].CRTSO_CODIGO == 'CRTSO7' && tmpTSTOpciones[i].APLICA){
                        tmpSWAuspicianteTodos = true;
                        tmpPersonaAuspiciante.getStore().baseParams.inCrtst_codigo = '';
                    }else if(tmpTSTOpciones[i].CRTSO_CODIGO == 'CRTSO12' && tmpTSTOpciones[i].APLICA){
                        tmpSWBeneficiarioTodos = true;
                        tmpPersonaBeneficiario.getStore().baseParams.inCrtst_codigo = '';
                    }else if(!tmpSWAuspicianteTodos && tmpTSTOpciones[i].CRTSO_CODIGO == 'CRTSO3' && tmpTSTOpciones[i].APLICA){
                        if(tmpPersonaAuspiciante.getStore().baseParams.inCrtst_codigo.length > 0)
                            tmpPersonaAuspiciante.getStore().baseParams.inCrtst_codigo += ' ';
                        tmpPersonaAuspiciante.getStore().baseParams.inCrtst_codigo += SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','03')).get('CGCNF_VALOR_CADENA');
                    }else if(!tmpSWAuspicianteTodos && tmpTSTOpciones[i].CRTSO_CODIGO == 'CRTSO4' && tmpTSTOpciones[i].APLICA){
                        if(tmpPersonaAuspiciante.getStore().baseParams.inCrtst_codigo.length > 0)
                            tmpPersonaAuspiciante.getStore().baseParams.inCrtst_codigo += ' ';
                        tmpPersonaAuspiciante.getStore().baseParams.inCrtst_codigo += SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','04')).get('CGCNF_VALOR_CADENA');
                    }else if(!tmpSWAuspicianteTodos && tmpTSTOpciones[i].CRTSO_CODIGO == 'CRTSO5' && tmpTSTOpciones[i].APLICA){
                        if(tmpPersonaAuspiciante.getStore().baseParams.inCrtst_codigo.length > 0)
                            tmpPersonaAuspiciante.getStore().baseParams.inCrtst_codigo += ' ';
                        tmpPersonaAuspiciante.getStore().baseParams.inCrtst_codigo += SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','05')).get('CGCNF_VALOR_CADENA');
                    }else if(!tmpSWAuspicianteTodos && tmpTSTOpciones[i].CRTSO_CODIGO == 'CRTSO6' && tmpTSTOpciones[i].APLICA){
                        if(tmpPersonaAuspiciante.getStore().baseParams.inCrtst_codigo.length > 0)
                            tmpPersonaAuspiciante.getStore().baseParams.inCrtst_codigo += ' ';
                        tmpPersonaAuspiciante.getStore().baseParams.inCrtst_codigo += SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','06')).get('CGCNF_VALOR_CADENA');
                    }else if(!tmpSWBeneficiarioTodos && tmpTSTOpciones[i].CRTSO_CODIGO == 'CRTSO8' && tmpTSTOpciones[i].APLICA){
                        if(tmpPersonaBeneficiario.getStore().baseParams.inCrtst_codigo.length > 0)
                            tmpPersonaBeneficiario.getStore().baseParams.inCrtst_codigo += ' ';
                        tmpPersonaBeneficiario.getStore().baseParams.inCrtst_codigo += SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','03')).get('CGCNF_VALOR_CADENA');
                    }else if(!tmpSWBeneficiarioTodos && tmpTSTOpciones[i].CRTSO_CODIGO == 'CRTSO9' && tmpTSTOpciones[i].APLICA){
                        if(tmpPersonaBeneficiario.getStore().baseParams.inCrtst_codigo.length > 0)
                            tmpPersonaBeneficiario.getStore().baseParams.inCrtst_codigo += ' ';
                        tmpPersonaBeneficiario.getStore().baseParams.inCrtst_codigo += SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','04')).get('CGCNF_VALOR_CADENA');
                    }else if(!tmpSWBeneficiarioTodos && tmpTSTOpciones[i].CRTSO_CODIGO == 'CRTSO10' && tmpTSTOpciones[i].APLICA){
                        if(tmpPersonaBeneficiario.getStore().baseParams.inCrtst_codigo.length > 0)
                            tmpPersonaBeneficiario.getStore().baseParams.inCrtst_codigo += ' ';
                        tmpPersonaBeneficiario.getStore().baseParams.inCrtst_codigo += SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','05')).get('CGCNF_VALOR_CADENA');
                    }else if(!tmpSWBeneficiarioTodos && tmpTSTOpciones[i].CRTSO_CODIGO == 'CRTSO11' && tmpTSTOpciones[i].APLICA){
                        if(tmpPersonaBeneficiario.getStore().baseParams.inCrtst_codigo.length > 0)
                            tmpPersonaBeneficiario.getStore().baseParams.inCrtst_codigo += ' ';
                        tmpPersonaBeneficiario.getStore().baseParams.inCrtst_codigo += SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','06')).get('CGCNF_VALOR_CADENA');
                    }else if(!tmpSWAuspicianteTodos && tmpTSTOpciones[i].CRTSO_CODIGO == 'CRTSO13' && tmpTSTOpciones[i].APLICA){
                        if(tmpPersonaAuspiciante.getStore().baseParams.inCrtst_codigo.length > 0)
                            tmpPersonaAuspiciante.getStore().baseParams.inCrtst_codigo += ' ';
                        tmpPersonaAuspiciante.getStore().baseParams.inCrtst_codigo += 'SIN';
                    }else if(!tmpSWBeneficiarioTodos && tmpTSTOpciones[i].CRTSO_CODIGO == 'CRTSO14' && tmpTSTOpciones[i].APLICA){
                        if(tmpPersonaBeneficiario.getStore().baseParams.inCrtst_codigo.length > 0)
                            tmpPersonaBeneficiario.getStore().baseParams.inCrtst_codigo += ' ';
                        tmpPersonaBeneficiario.getStore().baseParams.inCrtst_codigo += 'SIN';
                    }

                }
            }
            Ext.getCmp('pnlTrmBeneficiario').setVisible(tmpRecord.data.CRTST_APLICA_BENEFICIARIO);

            if(tmpRecord.get('CRTST_VEHICULO')==true){
                setVehiculo();
            }else{
                tmpVehiculo.MOTOR=null;
                tmpVehiculo.VEHICULO=null;
            }

            if(inHistorico !== undefined && inHistorico == false){
                if(verificarSolicitud(tmpRecord)==false){
                    limpiarTramite();
                    habilitarTramite(false);
                    return;
                }
            }

            pnlFrmCgg_res_tramitePrincipal.getEl().mask('Espere un momento por favor.', 'x-mask-loading');

            tmpTipoSolicitud = tmpRecord;
            txtCrtst_codigo.setValue(tmpRecord.get('CRTST_DESCRIPCION'));

            tmpProceso = tmpRecord.get('CRPRO_CODIGO');
            var scpProceso = new SOAPClientParameters();
            scpProceso.add('inCrpro_codigo', tmpProceso);
            scpProceso.add('format', TypeFormat.JSON);
            var tmpCrproRegistro = SOAPClient.invoke(URL_WS + "Cgg_res_proceso", 'select', scpProceso, false, null);
            try {
                tmpCrproRegistro = Ext.util.JSON.decode(tmpCrproRegistro);
                rProcesoNombre.set('CRPRO_CODIGO', tmpCrproRegistro[0].CRPRO_CODIGO);
                rProcesoNombre.set('CRPRO_NOMBRE', tmpCrproRegistro[0].CRPRO_NOMBRE);
                txtCrpro_codigo.setValue(rProcesoNombre.get('CRPRO_NOMBRE'));
            }
            catch (inErr) {
                txtCrpro_codigo.setValue(NO_DATA_MESSAGE);
                tmpProceso = null;
            }

            //Consulta de regla de validacion.
            if(tmpRecord.data.CRTST_RESTRINGIDO != undefined && tmpRecord.data.CRTST_RESTRINGIDO){
                var scpReglaValidacion= new SOAPClientParameters();
                scpReglaValidacion.add('inCrtst_codigo',tmpRecord.get('CRTST_CODIGO'));
                scpReglaValidacion.add('format',TypeFormat.JSON);
                var tmpReglaValidacion = SOAPClient.invoke(URL_WS+'Cgg_regla_validacion','selectReglaTipoSolicitud',scpReglaValidacion, false,null);
                try{
                    reglaValidacion = tmpReglaValidacion;
                    colReglaValidacion = eval(tmpReglaValidacion);
                }catch(inErr){
                    colReglaValidacion=null;
                }
            }

            //Consulta de tipo de solicitud padre.
            var scpSolicitudPadre= new SOAPClientParameters();
            scpSolicitudPadre.add('inCrtst_codigo',tmpRecord.get('CRTST_CODIGO'));
            scpSolicitudPadre.add('format',TypeFormat.JSON);
            crtstPadre = SOAPClient.invoke(URL_WS+'Cgg_res_tipo_solicitud_tramite','selectCGG_RES_TIPO_SOLICITUD_PADRE',scpSolicitudPadre, false,null);
            try{
                crtstPadre = eval(crtstPadre);
                crtstPadre = crtstPadre[0];
            }
            catch(inErr){
                crtstPadre=null;
            }

            //Consulta de la fase actual del proceso.
            var scpFaseInicio = new SOAPClientParameters();
            scpFaseInicio.add('inCrpro_codigo', rProcesoNombre.get('CRPRO_CODIGO'));
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
                    inCrpro_codigo:tmpRecord.get('CRPRO_CODIGO'),
                    inCisla_codigo:userInfo.CISLA_CODIGO,
                    format: TypeFormat.JSON
                }
            });

            gsCgg_res_solicitud_requisito.reload({
                params: {
                    inCrtst_codigo: tmpRecord.get('CRTST_CODIGO'),
                    inCrtra_codigo: null,
                    format: TypeFormat.JSON
                }
            });

//MO
         /*   sCgg_res_garantia_solicitud.reload({
                params: {
                    inCrtst_codigo: tmpRecord.get('CRTST_CODIGO'),
                    format: TypeFormat.JSON
                }
            });*/
//

            pnlFrmCgg_res_tramitePrincipal.getEl().unmask();
            winFrmCgg_res_tramite.doLayout();
        }
    }

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO ESTADO TRAMITE
     */
    var txtCrett_codigo = new Ext.form.TextField({
        id: 'txtCrett_codigo',
        name: 'txtCrett_codigo',
        fieldLabel: 'Estado tr\u00e1mite',
        anchor: '98%',
        allowBlank: false,
        readOnly: 'true',
        maxLength: 20
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO ESTADO TRAMITE
     */
    var btnCrett_codigoCgg_res_tramite = new Ext.Button({
        id: 'btnCrett_codigoCgg_res_tramite',
        iconCls: 'iconBuscar',
        listeners: {
            click: function(){
                var tmpFLCgg_res_estado_tramite = new FrmListadoCgg_res_estado_tramite();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_estado_tramite.getStore(), tmpFLCgg_res_estado_tramite.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord != null && tmpRecord != undefined) {
                        txtCrett_codigo.setValue(tmpRecord.get('CRETT_NOMBRE'));
                        tmpEstadoTramite = tmpRecord.get('CRETT_CODIGO');
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE ISLA
     */
    var txtCisla_codigo = new Ext.form.TextField({
        id: 'txtCisla_codigo',
        name: 'txtCisla_codigo',
        fieldLabel: 'Ciudad/isla',
        anchor: '98%',
        allowBlank: false,
        readOnly: 'true'
    });
    //AC=>
    var btnChangeIsla = new Ext.Button({
        id:'btnChangeIsla',
        iconCls: 'iconRecargar',
        listeners:{
            click: function(){
                var tmpFLCgg_isla = new FrmListadoCgg_isla();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_isla.getStore(), tmpFLCgg_isla.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord != null && tmpRecord != undefined) {
                        txtCisla_codigo.setValue(tmpRecord.get('CISLA_NOMBRE'));
                        tmpIsla = tmpRecord.get('CISLA_CODIGO');

                        new ManagerCookies().erase('CGG_ISLA');
                        new ManagerCookies().create('CGG_ISLA', Ext.util.JSON.encode(tmpRecord.data), 168);

                        if(inRecordCgg_res_tramite && inRecordCgg_res_tramite.get('CRTRA_CODIGO')!='KEYGEN') {
                            var params = new SOAPClientParameters();
                            params.add('inCrtra_codigo', inRecordCgg_res_tramite.get('CRTRA_CODIGO'));
                            params.add('inCisla_codigo', tmpIsla);
                            var tmpEstado = SOAPClient.invoke(URL_WS + 'Cgg_res_tramite', 'updateIsla', params, false, null);
                            if(tmpEstado == 'true')
                                winFrmCgg_res_tramite.close();
                            else
                                Ext.MsgPopup.msg("Tramite","Ha ocurrido un error al cambiar de Isla", MsgPopup.ERROR);
                        }
                    }
                });
                objBusqueda.show();
                if(inRecordCgg_res_tramite && inRecordCgg_res_tramite.get('CRTRA_CODIGO')!='KEYGEN')
                    Ext.MsgPopup.msg("Isla","Al cambiar la Isla el tramite puede desaparecer de su bandeja", MsgPopup.INFO);
            }
        }
    });
    //<=
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE ISLA
     */
    var btnCisla_codigoCgg_res_tramite = new Ext.Button({
        id: 'btnCisla_codigoCgg_res_tramite',
        iconCls: 'iconBuscar',
        listeners: {
            click: function(){
                var tmpFLCgg_isla = new FrmListadoCgg_isla();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_isla.getStore(), tmpFLCgg_isla.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord != null && tmpRecord != undefined) {
                        txtCisla_codigo.setValue(tmpRecord.get('CISLA_NOMBRE'));
                        tmpIsla = tmpRecord.get('CISLA_CODIGO');

                        new ManagerCookies().erase('CGG_ISLA');
                        new ManagerCookies().create('CGG_ISLA', Ext.util.JSON.encode(tmpRecord.data), 168);
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
     */
    var txtCrdpt_codigo = new Ext.form.TextField({
        id: 'txtCrdpt_codigo',
        name: 'txtCrdpt_codigo',
        fieldLabel: 'Dep. garant\u00EDa',
        anchor: '98%',
        readOnly: 'true'
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DEPOSITO DE GARANTIA
     */
    var btnCrdpt_codigoCgg_res_tramite = new Ext.Button({
        id: 'btnCrdpt_codigoCgg_res_tramite',
        iconCls: 'iconBuscar',
        tooltip:'Selecciona una garant\u00eda existente',
        listeners: {
            click: function(){
                if(tmpAuspiciante == null || tmpAuspiciante == undefined){
                    Ext.Msg.show({
                        title:tituloCgg_res_tramite,
                        msg:'Seleccione el auspiciante del tramite antes de continuar.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    return;
                }
                var rGarantia = grdCgg_res_garantia_solicitud.getSelectionModel().getSelected();
                if(rGarantia){
                    crgrtCodigo = rGarantia.get('CRGRT_CODIGO');

                    var tmpFLCgg_res_deposito_garantia = new FrmListadoCgg_res_deposito_garantia();
                    var tmpStore = tmpFLCgg_res_deposito_garantia.getStore();
                    tmpStore.baseParams.inDisponibles = true;
                    var objBusqueda = new DlgBusqueda(tmpStore, tmpFLCgg_res_deposito_garantia.getColumnModel());
                    objBusqueda.closeHandler(function(){
                        var tmpRecord = objBusqueda.getSelectedRow();
                        if (tmpRecord) {
                            if(tmpRecord.data.CGG_CRPJR_CODIGO.length > 0){
                                if(!rPersonaJuridicaRazonSocial || rPersonaJuridicaRazonSocial.data.CRPJR_CODIGO != tmpRecord.data.CGG_CRPJR_CODIGO){
                                    Ext.Msg.show({
                                        title:tituloCgg_res_tramite,
                                        msg:'La garant\u00eda seleccionada no pertenece a la empresa seleccionada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    return;
                                }
                            }else{
                                if(!tmpAuspiciante || tmpAuspiciante.data.CRPER_CODIGO != tmpRecord.data.CRPER_CODIGO){
                                    Ext.Msg.show({
                                        title:tituloCgg_res_tramite,
                                        msg:'La garant\u00eda seleccionada no pertenece al auspiciante seleccionado.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    return;
                                }
                            }
                            var tmpDisponible = eval(tmpRecord.data.CUPO_DISPONIBLE);
                            var tmpValorGarantia = eval(rGarantia.data.CRGRT_VALOR);
                            if( tmpDisponible >= tmpValorGarantia){
                                tmpDepositoGarantia = tmpRecord;
                                txtCrdpt_codigo.setValue(tmpRecord.get('CRDPT_NUMERO') + ' - $' + tmpRecord.get('CRDPT_VALOR_DEPOSITO'));
                            }else{
                                Ext.Msg.show({
                                    title:tituloCgg_res_tramite,
                                    msg:'La garant\u00eda seleccionada no tiene cupo disponible.<br>El cupo actual disponible es de '+tmpDisponible,
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                            }
                        }
                    });
                    objBusqueda.show();
                }else{
                    Ext.MsgPopup.msg(tituloCgg_res_tramite, 'Seleccione un valor de garant\u00eda, por favor.', MsgPopup.WARNING);
                }
            }
        }
    });

    var btnCrearGarantia = new Ext.Button({
        id:'btnCrearGarantia',
        iconCls:'iconNuevo',
        tooltip:'Crea una garant\u00eda del valor seleccionado',
        listeners: {
            click: function(){
                var rGarantia = grdCgg_res_garantia_solicitud.getSelectionModel().getSelected();
                if(rGarantia){
                    crgrtCodigo = rGarantia.get('CRGRT_CODIGO');
                    var objDepositoGarantia = new FrmCgg_res_deposito_garantia('insert',null);
                    if(rPersonaJuridicaRazonSocial){
                        objDepositoGarantia.setEmpresa(rPersonaJuridicaRazonSocial);
                    }
                    objDepositoGarantia.setPersona(tmpAuspiciante);
                    objDepositoGarantia.closeHandler(function(){
                        var resultado = objDepositoGarantia.dialogResult();
                        if(resultado !== null && resultado !== undefined){
                            rDepositoGarantia.set('CRDPT_CODIGO',resultado.CRDPT_CODIGO);
                            rDepositoGarantia.set('CRDPT_NUMERO', resultado.CRDPT_NUMERO_DOCUMENTO);
                            tmpDepositoGarantia = rDepositoGarantia;
                            txtCrdpt_codigo.setValue(resultado.CRDPT_NUMERO + ' - $' + resultado.CRDPT_VALOR_DEPOSITO);
                        }
                    });
                    objDepositoGarantia.setValue(rGarantia.get('CRGRT_VALOR')*1);
                    objDepositoGarantia.setObservacion(rGarantia.get('CRGRT_DESCRPCION'));
                    objDepositoGarantia.show();
                }else{
                    Ext.MsgPopup.msg(tituloCgg_res_tramite, 'Seleccione un valor de garant\u00eda, por favor.', MsgPopup.WARNING);
                }
            }
        }
    });

    /**
     * Ext.form.NumberField ANIO DE REALIZACION DEL TRAMITE
     */
    var numCrtra_anio = new Ext.form.NumberField({
        id: 'numCrtra_anio',
        nname: 'numCrtra_anio',
        fieldLabel: 'A\u00F1o',
        allowBlank: false,
        disabled: false
    });
    /**
     * Ext.form.NumberField NUMERO SECUENCIAL UNICO
     */
    var txtCrtra_numero = new Ext.form.TextField({
        id: 'txtCrtra_numero',
        nname: 'txtCrtra_numero',
        fieldLabel: 'Tr\u00E1mite',
        disabled: true,
        anchor: '98%'
    });

    /**
     * Ext.form.DateField FECHA DE RECEPCION DEL TRAMITE
     */
    var dtCrtra_fecha_recepcion = new Ext.form.DateField({
        id: 'dtCrtra_fecha_recepcion',
        name: 'dtCrtra_fecha_recepcion',
        fieldLabel: 'Fecha recepci\u00F3n',
        allowBlank: false,
        value: new Date()
    });

    /**
     * Ext.form.DateField FECHA DE RECEPCION DEL TRAMITE
     */
    var dtCrtra_fecha_salida = new Ext.form.DateField({
        id: 'dtCrtra_fecha_salida',
        allowBlank: false,
        blankText:'Ingrese lo fecha, por favor.',
        value: new Date(),
		minValue:new Date()
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
                        tmpCargo= tmpRecord.get('CGCRG_CODIGO');
                    }
                });
                objBusqueda.show();
            }
        }
    });


    /**
     * Ext.form.TextArea OBSERVACION DEL TRAMITE- HISTORIAL FORMATO JSON
     */
    var txtCrtra_observacion = new Ext.form.TextArea({
        id: 'txtCrtra_observacion',
        name: 'txtCrtra_observacion',
        fieldLabel: 'Observaci\u00F3n',
        anchor: '100%'
    });
    /**
     * Ext.form.NumberField NUMERO DE DIAS AUTORIZADOS PARA PERMANENCIA DE UNA PERSONA
     */
    var numCrtra_dias_permanencia = new Ext.ux.form.SpinnerField({
        id: 'numCrtra_dias_permanencia',
        nname: 'numCrtra_dias_permanencia',
        fieldLabel: 'Permanencia',
        allowNegative:false,
        allowDecimals:false,
        minValue:0,
        value:0,
        anchor:'80%',
        blankText:'Ingreso los d\u00edas, por favor.',
        submitValue: false,
        hidden:true
    });
    /**
     * Ext.form.Checkbox DETERMINA SI UN TRAMITE YA HA SIDO EVALUADO POR COMITE
     */
    var chkCrtra_pendiente = new Ext.form.Checkbox({
        id: 'chkCrtra_pendiente',
        name: 'chkCrtra_pendiente',
        fieldLabel: 'Pendiente',
        checked: true,
        submitValue: false
    });
    /**
     * Ext.form.TextArea JUSTIFICACION DE PORQUE EL TRAMITE QUEDO PENDIENTE
     */
    var txtCrtra_observacion_pendiente = new Ext.form.TextArea({
        id: 'txtCrtra_observacion_pendiente',
        name: 'txtCrtra_observacion_pendiente',
        fieldLabel: 'Observaci\u00F3n pendiente',
        width: '90%',
        allowBlank: false
    });
    /**
     * Ext.form.Checkbox SI LA INFORMACION FUE REGISTRADA DESDE ATENCION AL CLIENTE
     */
    var chkCrtra_atencion_cliente = new Ext.form.Checkbox({
        id: 'chkCrtra_atencion_cliente',
        name: 'chkCrtra_atencion_cliente',
        fieldLabel: 'Atenci\u00F3n cliente',
        allowBlank: false,
        checked: true
    });
    /**
     * Ext.form.TextField NUMERO DE COMUNICADO RADIAL QUE PATROCINA EL TRAMITE DE RESIDENCIA TEMPORAL
     */
    var txtCrtra_comunicado_radial = new Ext.form.TextField({
        id: 'txtCrtra_comunicado_radial',
        name: 'txtCrtra_comunicado_radial',
        fieldLabel: 'C. radial',
        hidden : true,
        anchor: '100%',
        listeners:{
            specialkey: function(inThis, inE){
                if (inE.getKey() == inE.ENTER) {
                    try{
                        var numCom = Number(inThis.getValue());
                        if (numCom){
                            Ext.Msg.show({
                                title: tituloCgg_res_tramite,
                                msg: 'El n\u00FAmero de comunicado no corresponde al formato actual,<br> si el comunicado pertenece al sistema anterior, <br>por favor ingrese la informaci\u00F3n correspondiente de auspiciante y actividad.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                            btnCrper_codigoCgg_res_tramite.setDisabled(false);
                            btnCrpjr_codigoCgg_res_tramite.setDisabled(false);
                            btnCgcrg_codigoCgg_gem_vacante.setDisabled(false);
                        }else{
                            consultarComunicado(inThis.getValue());
                        }
                    }catch(e){
                        consultarComunicado(inThis.getValue());
                    }
                }
            }
        }
    });

    /**
     *Consulta la persona juridica y representante legal de un comunicado radial al igual que la validez del mismo.
     *@param inCGVCN_NUMERO_COMUNICADO Numero de comunicado radial.
     */
    function consultarComunicado(inCGVCN_NUMERO_COMUNICADO){

        var scpComunicado = new SOAPClientParameters();
        scpComunicado.add('inCgvcn_numero_comunicado',inCGVCN_NUMERO_COMUNICADO);

        SOAPClient.invoke(URL_WS+'Cgg_gem_vacante','verificarComunicado', scpComunicado, true, function(inServiceResponse){
            try{

                inServiceResponse = Ext.util.JSON.decode(inServiceResponse);
                inServiceResponse=inServiceResponse[0];

                if(inServiceResponse.CGVCN_CODIGO.trim().length >=1 && inServiceResponse.CGVCN_CODIGO.substring(0,5)=='CGVCN'){

                    var spcComunicado1 = new SOAPClientParameters();
                    spcComunicado1.add('inCgvcn_codigo',inServiceResponse.CGVCN_CODIGO);
                    spcComunicado1.add('format',TypeFormat.JSON);

                    SOAPClient.invoke(URL_WS+'Cgg_gem_vacante', 'select', spcComunicado1, true, function(inServiceResponse){
                        try{
                            inServiceResponse = Ext.util.JSON.decode(inServiceResponse);
                            inServiceResponse=inServiceResponse[0];

                            var scpCargo = new SOAPClientParameters();
                            scpCargo.add('inCgcrg_codigo',inServiceResponse.CGCRG_CODIGO);
                            scpCargo.add('format',TypeFormat.JSON);

                            SOAPClient.invoke(URL_WS+'Cgg_gem_cargo', 'select', scpCargo, true, function(inServiceResponse){
                                try{
                                    inServiceResponse = Ext.util.JSON.decode(inServiceResponse );
                                    inServiceResponse  = inServiceResponse[0];

                                    txtCrtra_actividad_residencia.setValue(inServiceResponse.CGCRG_NOMBRE);
                                    tmpCargo= inServiceResponse.CGCRG_CODIGO;
                                }
                                catch(inErr){
                                    txtCrtra_actividad_residencia.setValue(NO_DATA_MESSAGE);
                                    tmpCargo = null;
                                }
                            });

                            var scpUsuario = new SOAPClientParameters();
                            scpUsuario.add('inCusu_codigo',inServiceResponse.CUSU_CODIGO);
                            scpUsuario.add('format',TypeFormat.JSON);

                            var tmpUsuario = SOAPClient.invoke(URL_WS+'Cgg_usuario', 'select', scpUsuario, false, null);
                            try{
                                tmpUsuario = Ext.util.JSON.decode(tmpUsuario)[0];
                                if (tmpUsuario.CRPJR_CODIGO){
                                    //PERSONAS JURIDICAS
                                    var scpRepresentante = new SOAPClientParameters();
                                    scpRepresentante.add('inCrpjr_codigo',tmpUsuario.CRPJR_CODIGO);
                                    scpRepresentante.add('format',TypeFormat.JSON);

                                    var tmpRepresentante = SOAPClient.invoke(URL_WS+'Cgg_res_representante_legal', 'selectRepresentantePersona', scpRepresentante, false, null);
                                    try{
                                        tmpRepresentante = Ext.util.JSON.decode(tmpRepresentante)[0];

                                        rAuspiciante.set('CRPER_CODIGO', tmpRepresentante.CRPER_CODIGO!==undefined ? tmpRepresentante.CRPER_CODIGO:'');
                                        rAuspiciante.set('CRPER_NOMBRES', tmpRepresentante.CRPER_NOMBRES!==undefined ? tmpRepresentante.CRPER_NOMBRES :'');
                                        rAuspiciante.set('CRPER_APELLIDO_PATERNO', tmpRepresentante.CRPER_APELLIDO_PATERNO!==undefined ? tmpRepresentante.CRPER_APELLIDO_PATERNO:'');
                                        rAuspiciante.set('CRPER_APELLIDO_MATERNO', tmpRepresentante.CRPER_APELLIDO_MATERNO!==undefined ? tmpRepresentante.CRPER_APELLIDO_MATERNO:'');
                                        txtCrper_codigo.setValue(rAuspiciante.get('CRPER_NOMBRES') + " " + rAuspiciante.get('CRPER_APELLIDO_PATERNO')+' '+rAuspiciante.data.CRPER_APELLIDO_MATERNO);
                                        tmpAuspiciante = rAuspiciante;

                                    }catch(inErr){
                                        tmpAuspiciante = null;
                                        txtCrper_codigo.setValue('');
                                    //Ext.MsgPopup.msg(tituloCgg_res_tramite, "Se produjo una inusualidad al consultar el comunicado.<br>Error:"+inErr+'<br>'+ERR_MESSAGE, MsgPopup.WARNING);
                                    }

                                    var tmpPJuridica = SOAPClient.invoke(URL_WS+'Cgg_res_persona_juridica', 'select', scpRepresentante, false, null);
                                    try{
                                        tmpPJuridica = Ext.util.JSON.decode(tmpPJuridica);
                                        rPersonaJuridicaRazonSocial.set('CRPJR_CODIGO', tmpPJuridica[0].CRPJR_CODIGO);
                                        rPersonaJuridicaRazonSocial.set('CRPJR_RAZON_SOCIAL', tmpPJuridica[0].CRPJR_RAZON_SOCIAL);
                                        tmpPJuridica= rPersonaJuridicaRazonSocial;
                                        txtCrpjr_codigo.setValue(rPersonaJuridicaRazonSocial.get('CRPJR_RAZON_SOCIAL'));
                                    }catch(inErr){
                                        tmpAuspiciante = null;
                                        rPersonaJuridicaRazonSocial = new rFilaPersonaJuridicaRazonSocial({
                                            CRPJR_CODIGO: '',
                                            CRPJR_RAZON_SOCIAL: ''
                                        });
                                        txtCrper_codigo.setValue('');
                                        txtCrpjr_codigo.setValue('');
                                        Ext.MsgPopup.msg(tituloCgg_res_tramite, "Se produjo una inusualidad al consultar el comunicado.<br>Error:"+inErr+'<br>'+ERR_MESSAGE, MsgPopup.WARNING);
                                    }
                                }else{
                                    //PERSONAS NATURALES
                                    var scpPersona = new SOAPClientParameters();
                                    scpPersona.add('inCrper_codigo',tmpUsuario.CRPER_CODIGO);
                                    scpPersona.add('format',TypeFormat.JSON);

                                    var tmpPersona = SOAPClient.invoke(URL_WS+'Cgg_res_persona', 'select', scpPersona, false, null);
                                    try{
                                        tmpPersona = Ext.util.JSON.decode(tmpPersona)[0];

                                        rAuspiciante.set('CRPER_CODIGO', tmpPersona.CRPER_CODIGO!==undefined ? tmpPersona.CRPER_CODIGO:'');
                                        rAuspiciante.set('CRPER_NOMBRES', tmpPersona.CRPER_NOMBRES!==undefined ? tmpPersona.CRPER_NOMBRES :'');
                                        rAuspiciante.set('CRPER_APELLIDO_PATERNO', tmpPersona.CRPER_APELLIDO_PATERNO!==undefined ? tmpPersona.CRPER_APELLIDO_PATERNO:'');
                                        rAuspiciante.set('CRPER_APELLIDO_MATERNO', tmpPersona.CRPER_APELLIDO_MATERNO!==undefined ? tmpPersona.CRPER_APELLIDO_MATERNO:'');
                                        txtCrper_codigo.setValue(rAuspiciante.get('CRPER_NOMBRES') + " " + rAuspiciante.get('CRPER_APELLIDO_PATERNO')+' '+rAuspiciante.data.CRPER_APELLIDO_MATERNO);
                                        tmpAuspiciante = rAuspiciante;
                                        txtCrpjr_codigo.setValue('');

                                    }catch(inErr){
                                        tmpAuspiciante = null;
                                        txtCrper_codigo.setValue('');
                                    //Ext.MsgPopup.msg(tituloCgg_res_tramite, "Se produjo una inusualidad al consultar el comunicado.<br>Error:"+inErr+'<br>'+ERR_MESSAGE, MsgPopup.WARNING);
                                    }
                                }
                            }catch(inErr){
                                tmpAuspiciante = null;
                                rPersonaJuridicaRazonSocial = new rFilaPersonaJuridicaRazonSocial({
                                    CRPJR_CODIGO: '',
                                    CRPJR_RAZON_SOCIAL: ''
                                });
                                txtCrper_codigo.setValue('');
                                txtCrpjr_codigo.setValue('');
                                Ext.MsgPopup.msg(tituloCgg_res_tramite, "Se produjo una inusualidad al consultar el comunicado.<br>Error:"+inErr+'<br>'+ERR_MESSAGE, MsgPopup.WARNING);
                            }
                        }catch(inErr){
                            tmpAuspiciante = null;
                            rPersonaJuridicaRazonSocial = new rFilaPersonaJuridicaRazonSocial({
                                CRPJR_CODIGO: '',
                                CRPJR_RAZON_SOCIAL: ''
                            });
                            txtCrper_codigo.setValue('');
                            txtCrpjr_codigo.setValue('');
                            Ext.MsgPopup.msg(tituloCgg_res_tramite, "Se produjo una inusualidad al consultar el comunicado.<br>Error:"+inErr+'<br>'+ERR_MESSAGE, MsgPopup.WARNING);
                        }
                    });

                }else{
                    Ext.Msg.show({
                        title: tituloCgg_res_tramite,
                        msg: 'El comunicado radial no es valido para una residencia.<br>'+inServiceResponse.CGVCN_MENSAJE+'<br>Para mayor informaci\u00f3n consulte con el area de gesti\u00f3n de empleo, por favor.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.ERROR
                    });

                    tmpAuspiciante = null;
                    rPersonaJuridicaRazonSocial = new rFilaPersonaJuridicaRazonSocial({
                        CRPJR_CODIGO: '',
                        CRPJR_RAZON_SOCIAL: ''
                    });
                    txtCrper_codigo.setValue('');
                    txtCrpjr_codigo.setValue('');
                    tmpCargo = null;
                    txtCrtra_actividad_residencia.setValue('');
                }
            }catch(inErr){
                tmpAuspiciante = null;
                rPersonaJuridicaRazonSocial = new rFilaPersonaJuridicaRazonSocial({
                    CRPJR_CODIGO: '',
                    CRPJR_RAZON_SOCIAL: ''
                });
                txtCrper_codigo.setValue('');
                txtCrpjr_codigo.setValue('');
                Ext.MsgPopup.msg(tituloCgg_res_tramite, "Se produjo una inusualidad al consultar el comunicado.<br>Error:"+inErr+'<br>'+ERR_MESSAGE, MsgPopup.WARNING);
            }
        });

    }

    /**
     * Ext.form.TextField Articulo que motivo la solicitud de residencia.
     */
    var txtCrtra_motivo = new Ext.form.TextField({
        id: 'txtCrtra_motivo',
        name: 'txtCrtra_motivo',
        fieldLabel: 'Motivo',
        anchor: '98%',
        allowBlank: false,
        maxLength: 20
    });
    /**
     * Ext.ux.form.SpinnerField NUMERO DE HOJAS FOLIADAS PARA EL TRAMITE
     */
    var spfCrtra_folio = new Ext.ux.form.SpinnerField({
        id: 'spfCrtra_folio',
        name: 'spfCrtra_folio',
        fieldLabel: 'Folios',
        anchor: '98%',
        allowBlank: false,
        value: 1,
        minValue: 1,
        allowDecimals: false,
        allowNegative: false,
        accelerate: true
    });

    /**
     *Ext.form.ComboBox Combo para establecer la caducidad del tramite.
     */
    var cbxCaducidadTramite = new Ext.form.ComboBox({
        id:'cbxCaducidadTramite',
        store:dsTipoCaducidad,
        fieldLabel:'Caducidad',
        mode: 'local',
        forceSelection:true,
        editable:false,
        triggerAction:'all',
        selectOnFocus:true,
        anchor:'98%',
        value:0,
        listeners:{
            select:function(inThis,inRecord,inIndex){
                if(inIndex==0){
                    dtCrtra_fecha_salida.show();
                    numCrtra_dias_permanencia.hide();
                }else{
                    dtCrtra_fecha_salida.hide();
                    numCrtra_dias_permanencia.show();
                }
                Ext.getCmp('pnlCaducidad').doLayout();
            }
        }
    });

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_tramite
     */
    var btnGuardarCgg_res_tramite = new Ext.Button({
        id: 'btnGuardarCgg_res_tramite',
        text: 'Guardar y despachar',
        iconCls: 'iconGuardarDespachar',
        tooltip: 'Guarda y despacha el tr\u00e1mite actual hacia la fase siguiente establecida.',
        handler: function(){
            var tmpTipoGarantia = '';
            if(validarFormularioTramite() == false) {
                return;
            }
            if(validarReglaTramite() == false){
                return;
            }
            try {
                if(tmpDepositoGarantia){
                    tmpTipoGarantia = "{CRDPT_CODIGO:\""+tmpDepositoGarantia.get('CRDPT_CODIGO')+"\",CRGRT_CODIGO:\""+crgrtCodigo+"\"}";
                }
                pnlFrmCgg_res_tramitePrincipal.getEl().mask('Espere un momento por favor.<br>El tiempo de respuesta depender\u00E1 del tama\u00F1o de sus archivos adjuntos.', 'x-mask-loading');
                Ext.getCmp('pnlFrmCgg_res_tramite3').getForm().submit({
                    url: URL_WS + "TramiteSRV",
                    success: function(inForm, inAction){
                        try {
                            pnlFrmCgg_res_tramitePrincipal.getEl().unmask();
                            var resultadoTramite = inAction.result.msg;

                            var tmpFlag = false;
                            var errMsg ='';
                            var numTramite = '';

                            if(isEdit==true){
                                if(resultadoTramite=='false'){
                                    errMsg='El tr\u00E1mite no ha podido ser actualizado y despachado.';
                                }else{
                                    tmpFlag=true;
                                    numTramite = txtCrtra_numero.getValue();
                                }
                            }else{
                                resultadoTramite = eval(resultadoTramite.trim());
                                if(resultadoTramite[0].substring(0, 5) == 'CRTRA'){
                                    tmpFlag=true;
                                    numTramite= new Date().format('Y')+'-'+resultadoTramite[1];
                                }else{
                                    errMsg=resultadoTramite[1];
                                }
                            }

                            if(tmpFlag==true) {
                                Ext.Msg.show({
                                    title: tituloCgg_res_tramite,
                                    msg: 'El tr\u00E1mite ha sido guardado y despachado. El n\u00FAmero de su tr\u00E1mite es: <span class="numeroTramite">'+ numTramite + '</span>.<br>Para mayor informaci\u00F3n consulte el historial del tr\u00E1mite.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });

                                if(Ext.getCmp('miChkEmitirComprobante').checked == true){
                                    var reporte = new Reporte("rptComprobanteTramite", '/Reports/sii/residencia', {
                                        P_CRTRA_CODIGO: isEdit == true?inRecordCgg_res_tramite.get('CRTRA_CODIGO'):resultadoTramite[0]

                                    });
                                    reporte.show();
                                }
                                if(Ext.getCmp('miChkEmitirGarantia').checked == true){
                                    if(tmpDepositoGarantia!==null){
                                        var garantia = new Reporte("rptComprobanteDepositoGarantia", '/Reports/sii/residencia', {
                                            P_CRTRA_CODIGO: isEdit == true?inRecordCgg_res_tramite.get('CRTRA_CODIGO'):resultadoTramite[0]
                                        });
                                        garantia.show();
                                    }
                                }
                                winFrmCgg_res_tramite.close();
                            }else {
                                Ext.Msg.show({
                                    title: tituloCgg_res_tramite,
                                    msg: 'Se present\u00F3 un problema al momento de guardar su tr\u00E1mite.<br>Error:' + errMsg + '<br>' + ERR_MESSAGE,
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                        }catch (inErr) {
                            Ext.Msg.show({
                                title: tituloCgg_res_tramite,
                                msg: 'Se present\u00F3 un problema al momento de guardar su tr\u00E1mite.<br>Error:' + inErr + '.<br>' + ERR_MESSAGE,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    },
                    failure: function(inForm, inAction){
                        pnlFrmCgg_res_tramitePrincipal.getEl().unmask();
                        Ext.Msg.show({
                            title: tituloCgg_res_tramite,
                            msg: 'Se present\u00F3 un problema al momento de guardar su tr\u00E1mite.<br>Error:' + inAction.result.msg + '.<br>' + ERR_MESSAGE,
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    },
                    params: {
                        inCrtra_codigo: isEdit==false?'':inRecordCgg_res_tramite.get('CRTRA_CODIGO'),
                        inCrper_codigo: (tmpAuspiciante == null || tmpAuspiciante.get('CRPER_CODIGO')==undefined ||tmpAuspiciante.get('CRPER_CODIGO')==null)?null:tmpAuspiciante.get('CRPER_CODIGO'),
                        inCrpjr_codigo: (rPersonaJuridicaRazonSocial !==null && rPersonaJuridicaRazonSocial.get('CRPJR_CODIGO') !== null && rPersonaJuridicaRazonSocial.get('CRPJR_CODIGO').trim().length >= 0)?rPersonaJuridicaRazonSocial.get('CRPJR_CODIGO'):null,
                        inCgg_crper_codigo: rBeneficiario.get('CRPER_CODIGO')=='KEYGEN' ? '':rBeneficiario.get('CRPER_CODIGO'),
                        inCrpro_codigo: tmpProceso,
                        inCrtst_codigo: tmpTipoSolicitud.get('CRTST_CODIGO'),
                        inCvveh_codigo: tmpVehiculo.VEHICULO,
                        inCisla_codigo: tmpIsla,
                        inCrdpt_codigo: tmpTipoGarantia,
                        inCvmtr_codigo: tmpVehiculo.MOTOR,
                        inCgg_cvmtr_codigo:tmpVehiculoReemplazo.MOTOR,
                        inCgg_cvveh_codigo:tmpVehiculoReemplazo.VEHICULO,
                        inCrtra_actividad_residencia: tmpCargo,
                        inCrtra_observacion: txtCrtra_observacion.getValue(),
                        inCrtra_dias_permanencia:numCrtra_dias_permanencia.isVisible() ? numCrtra_dias_permanencia.getValue():0,
                        inCrtra_atencion_cliente:false,
                        inCrtra_comunicado_radial:txtCrtra_comunicado_radial.getValue(),
                        inCrtra_motivo: chkCrtra_recalificacion.getValue(),
                        inCrtra_folio: spfCrtra_folio.getValue(),
                        inCrfas_codigo: "["+ Ext.util.JSON.encode(cbsmFase.getSelected().data)+"]",
                        inTramiteRequisitos: gsCgg_res_solicitud_requisito.getJsonData(),
                        inNuevoBeneficiario: rBeneficiario.get('CRPER_CODIGO')=='KEYGEN' ? Ext.util.JSON.encode(rBeneficiario.data):null,
                        inCrgts_aplica:'[]',
                        inCrtra_fecha_salida:dtCrtra_fecha_salida.isVisible()?dtCrtra_fecha_salida.getValue().toString('dd/MM/yyyy'):null,
                        inOperacion:isEdit==false?'registrar':'actualizar',
                        inVehiculo:crearJSONVehiculo()
                    }
                });
            }catch (inErr) {
                pnlFrmCgg_res_tramitePrincipal.getEl().unmask();
                Ext.Msg.show({
                    title: tituloCgg_res_tramite,
                    msg: 'Se present\u00F3 un problema al momento de guardar su tr\u00E1mite.\nError:' + inErr + '.\n' + ERR_MESSAGE,
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
            }
        }
    });

    var btnCgg_res_tramiteSoloGuardar = new Ext.Button({
        id: 'btnSoloGuardarTramite',
        text: 'Solo guardar',
        iconCls:'iconSoloGuardar',
        handler: function(){
            var tmpTipoGarantia = '';
            if (validarFormularioTramite(true) == false) {
                return;
            }/*else{
                var flagSoloGuardar = confirm('Va a solo guardar el tr\u00e1mite.\nInformaci\u00f3n de requisitos, seguimiento y adjuntos ser\u00e1n omitidos.\nSeguro de continuar?');
                if(flagSoloGuardar ==false){
                    return;
                }
            }*/
            try {
                if(tmpDepositoGarantia){
                    tmpTipoGarantia = "{CRDPT_CODIGO:\""+tmpDepositoGarantia.get('CRDPT_CODIGO')+"\",CRGRT_CODIGO:\""+crgrtCodigo+"\"}";
                }
                pnlFrmCgg_res_tramitePrincipal.getEl().mask('Espere un momento por favor.', 'x-mask-loading');
                Ext.getCmp('pnlFrmCgg_res_tramite3').getForm().submit({
                    url: URL_WS + "TramiteSRV",
                    success: function(inForm,inAction){
                        try {
                            pnlFrmCgg_res_tramitePrincipal.getEl().unmask();

                            var resultadoTramite = inAction.result.msg;

                            var tmpFlag = false;
                            var errMsg ='';
                            var numTramite = '';

                            if(isEdit==true){
                                if(resultadoTramite=='false'){
                                    errMsg='El tr\u00E1mite no ha podido ser actualizado.';
                                }else{
                                    tmpFlag=true;
                                    numTramite = txtCrtra_numero.getValue();
                                }
                            }else{
                                resultadoTramite = eval(resultadoTramite.trim());
                                if(resultadoTramite[0].substring(0, 5) == 'CRTRA'){
                                    tmpFlag=true;
                                    numTramite= new Date().format('Y')+'-'+resultadoTramite[1];
                                }else{
                                    errMsg=resultadoTramite[1];
                                }
                            }

                            if(tmpFlag==true) {

                                Ext.Msg.show({
                                    title: tituloCgg_res_tramite,
                                    msg: 'El tr\u00E1mite ha sido solo guardado.<br>El n\u00FAmero de su tr\u00E1mite es: <span class="numeroTramite">'+numTramite+ '</span>.<br>Para mayor informaci\u00F3n consulte el historial del tr\u00E1mite.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });

                                if(Ext.getCmp('miChkEmitirComprobante').checked == true){
                                    var reporte = new Reporte("rptComprobanteTramite", '/Reports/sii/residencia', {
                                        P_CRTRA_CODIGO:resultadoTramite[0]
                                    });
                                    reporte.show();
                                }
                                if(Ext.getCmp('miChkEmitirGarantia').checked == true){
                                    if(tmpDepositoGarantia!==null){

                                        var garantia = new Reporte("rptComprobanteDepositoGarantia", '/Reports/sii/residencia', {
                                            P_CRTRA_CODIGO:resultadoTramite[0]
                                        });
                                        garantia.show();
                                    }
                                }

                                winFrmCgg_res_tramite.close();
                            }else {
                                Ext.Msg.show({
                                    title: tituloCgg_res_tramite,
                                    msg: 'Se present\u00F3 un problema al momento de guardar su tr\u00E1mite.<br>Error:' + errMsg + '<br>' + ERR_MESSAGE,
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                        }catch (inErr) {
                            Ext.Msg.show({
                                title: tituloCgg_res_tramite,
                                msg: 'Se present\u00F3 un problema al momento de guardar su tr\u00E1mite.<br>Error:' + inAction.result.msg + '.<br>' + ERR_MESSAGE,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    },
                    failure: function(inForm, inAction){
                        pnlFrmCgg_res_tramitePrincipal.getEl().unmask();
                        Ext.Msg.show({
                            title: tituloCgg_res_tramite,
                            msg: 'Se present\u00F3 un problema al momento de guardar su tr\u00E1mite.<br>Error:' + inAction.result.msg + '.<br>' + ERR_MESSAGE,
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    },
                    params: {
                        inCrtra_codigo: isEdit==false?'':inRecordCgg_res_tramite.get('CRTRA_CODIGO'),
                        inCrper_codigo: (!tmpAuspiciante || tmpAuspiciante.get('CRPER_CODIGO')==undefined ||tmpAuspiciante.get('CRPER_CODIGO')==null)?null:tmpAuspiciante.get('CRPER_CODIGO'),
                        inCrpjr_codigo: (rPersonaJuridicaRazonSocial !==null && rPersonaJuridicaRazonSocial.get('CRPJR_CODIGO')!==null && rPersonaJuridicaRazonSocial.get('CRPJR_CODIGO').trim().length >= 0)?rPersonaJuridicaRazonSocial.get('CRPJR_CODIGO'):null,
                        inCgg_crper_codigo: rBeneficiario.get('CRPER_CODIGO')=='KEYGEN' ? '':rBeneficiario.get('CRPER_CODIGO'),
                        inCrpro_codigo: tmpProceso,
                        inCrtst_codigo: tmpTipoSolicitud.get('CRTST_CODIGO'),
                        inCvveh_codigo: tmpVehiculo.VEHICULO,
                        inCisla_codigo: tmpIsla,
                        inCrdpt_codigo: tmpTipoGarantia,
                        inCvmtr_codigo: tmpVehiculo.MOTOR,
                        inCgg_cvmtr_codigo:tmpVehiculoReemplazo.MOTOR,
                        inCgg_cvveh_codigo:tmpVehiculoReemplazo.VEHICULO,
                        inCrtra_actividad_residencia: tmpCargo,
                        inCrtra_observacion: txtCrtra_observacion.getValue(),
                        inCrtra_dias_permanencia:numCrtra_dias_permanencia.isVisible() ? numCrtra_dias_permanencia.getValue():0,
                        inCrtra_atencion_cliente:false,
                        inCrtra_comunicado_radial:txtCrtra_comunicado_radial.getValue(),
                        inCrtra_motivo: chkCrtra_recalificacion.getValue(),
                        inCrtra_folio: spfCrtra_folio.getValue(),
                        inCrfas_codigo: "[]",
                        inTramiteRequisitos: "[]",
                        inNuevoBeneficiario:rBeneficiario.get('CRPER_CODIGO')=='KEYGEN' ? Ext.util.JSON.encode(rBeneficiario.data):null,
                        inCrgts_aplica:'[]',
                        inCrtra_fecha_salida:dtCrtra_fecha_salida.isVisible()?dtCrtra_fecha_salida.getValue().toString('dd/MM/yyyy'):null,
                        inOperacion:(isEdit==false)?'registrar':'actualizar',
                        inVehiculo:crearJSONVehiculo()
                    }
                });

            }catch (inErr) {
                pnlFrmCgg_res_tramitePrincipal.getEl().unmask();
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
    var btnCerrarCgg_res_tramite = new Ext.Button({
        id: 'btnCerrarCgg_res_tramite',
        text: 'Cerrar',
        iconCls: 'iconCerrar',
        tooltip: 'Cerrar formulario',
        listeners: {
            click: function(){
                winFrmCgg_res_tramite.close();
            }
        }
    });

    var btnRegistrarPersona = new Ext.Button({
        id: 'btnRegistrarPersona',
        iconCls: 'iconNuevo',
        tooltip: 'Agrega una nueva persona o beneficiario al tr\u00E1mite',
        listeners: {
            click: function(){
                var objBeneficiario = new FrmCgg_res_beneficiario(rBeneficiario);
                objBeneficiario.closeHandler(function(){
                    rBeneficiario = objBeneficiario.getData();
                    txtCgg_crper_codigo.setValue(trim(rBeneficiario.get('CRPER_NOMBRES') + ' ' + rBeneficiario.get('CRPER_APELLIDO_PATERNO') + ' ' + rBeneficiario.get('CRPER_APELLIDO_MATERNO')));
                });
                objBeneficiario.loadData();
                objBeneficiario.show();
            }
        }
    });

    var pnlFrmCgg_res_tramite1Norte1 = new Ext.Panel({
        id: 'pnlFrmCgg_res_tramite1Norte1',
        layout: 'column',
        region: 'north',
        height: 55,
        items: [{
            columnWidth: .5,
            layout: 'form',
            items: [txtCrtra_numero, {
                xtype: 'panel',
                layout: 'column',
                anchor: '98%',
                items: [{
                    columnWidth: .93,
                    layout: 'form',
                    items: [txtCrtst_codigo]
                }, {
                    columnWidth: .07,
                    layout: 'form',
                    items: [btnCrtst_codigo]
                }]
            }]
        }, {
            columnWidth: .5,
            items: [{
                xtype: 'panel',
                layout: 'column',
                anchor: '98%',
                items: [{
                    columnWidth: .93,
                    layout: 'form',
                    items: [txtCisla_codigo]
                }, {
                    columnWidth: .07,
                    layout: 'form',
                    items: [btnChangeIsla]
                }]
            }, {
                columnWidth: 1,
                layout: 'form',
                items: [spfCrtra_folio]
            }]
        }]
    });

    var pnlFrmCgg_res_tramite1Norte2 = new Ext.form.FieldSet({
        id: 'pnlFrmCgg_res_tramite1Norte2',
        layout: 'column',
        title: 'Interesados',
        collapsible: true,
        region: 'center',
        height: 65,
        items: [{
            columnWidth: .5,
            items: [{
                xtype: 'panel',
                id:'pnlTrmAuspiciante',
                layout: 'column',
                items: [{
                    columnWidth: .93,
                    layout: 'form',
                    items: [txtCrper_codigo]
                }, {
                    columnWidth: .07,
                    layout: 'form',
                    items: [btnCrper_codigoCgg_res_tramite]
                }]
            }]
        }, {
            columnWidth: .5,
            items: [{
                id:'pnlTrmBeneficiario',
                xtype: 'panel',
                layout: 'column',
                items: [{
                    columnWidth: .88,
                    layout: 'form',
                    items: [txtCgg_crper_codigo]
                }, {
                    columnWidth: .06,
                    layout: 'form',
                    items: [btnCgg_crper_codigoCgg_res_tramite]
                }, {
                    columnWidth: .06,
                    layout: 'form',
                    items: [btnRegistrarPersona]
                }]
            }]
        }, {
            columnWidth: .5,
            items: [{
                xtype: 'panel',
                id:'pnlTrmEmpresa',
                layout: 'column',
                items: [{
                    columnWidth: .93,
                    layout: 'form',
                    items: [txtCrpjr_codigo]
                }, {
                    columnWidth: .07,
                    layout: 'form',
                    items: [btnCrpjr_codigoCgg_res_tramite]
                }]
            }]

        }, {
            id:'pnlTrmComRadial',
            columnWidth: .5,
            layout: 'form',
            items: [txtCrtra_comunicado_radial]
        }, {
            id:'pnlTrmActividad',
            columnWidth:1,
            layout: 'column',
            items: [{
                columnWidth: .94,
                layout: 'form',
                items: [txtCrtra_actividad_residencia]
            },{
                columnWidth: .06,
                layout: 'form',
                items: [btnCgcrg_codigoCgg_gem_vacante]
            }]
        }, {
            columnWidth: 1,
            layout: 'form',
            items: [txtCrtra_observacion]
        }],
        listeners: {
            collapse: function(inPanel){
                Ext.getCmp('pnlFrmCgg_res_tramite1Norte').setHeight(100);
                pnlFrmCgg_res_tramitePrincipal.doLayout(true);
            },
            expand: function(inPanel){
                Ext.getCmp('pnlFrmCgg_res_tramite1Norte').setHeight(245);
                pnlFrmCgg_res_tramitePrincipal.doLayout(true);
            }
        }
    });

    var pnlFrmCgg_res_tramite1Norte = new Ext.Panel({
        id: 'pnlFrmCgg_res_tramite1Norte',
        region: 'north',
        layout: 'border',
        frame: true,
        height: 245,
        items: [pnlFrmCgg_res_tramite1Norte1, pnlFrmCgg_res_tramite1Norte2]
    });


    var cbcCRRQT_CUMPLE = new Ext.grid.CheckColumn({
        dataIndex: 'CRRQT_CUMPLE',
        header: 'Cumple',
        width: 80,
        align: 'center'
    });

    var chkCrsrq_requerido = new Ext.ux.grid.CheckColumn(
    {
        dataIndex:'CRSRQ_REQUERIDO',
        header:'Requerido',
        width:90,
        sortable:true
    }
    );
    ////////////////////////////////VEHICULOS//////////////////////////

    var txtCvveh_codigo1 = new Ext.form.TextField({
        id: 'txtCvveh_codigo1',
        name: 'txtCvveh_codigo1',
        fieldLabel: 'Vehiculo',
        anchor: '98%',
        readOnly: true
    });

    var btnCvveh_codigo1 = new Ext.Button({
        id: 'btnCvveh_codigo1',
        iconCls: 'iconBuscar',
        tooltip: 'Buscar vehiculo existente libre',
        listeners: {
            click: function(){
                var objVehiculo = new Cgg_vehiculo_libre();
                var objBusqueda = new DlgBusqueda(objVehiculo.getStore(), objVehiculo.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord != null && tmpRecord != undefined) {
                        txtCvveh_codigo1.setValue(tmpRecord.get('MARCA') + ' - ' + tmpRecord.get('CVVEH_PLACA')+ ' - ' + tmpRecord.get('CVVEH_CHASIS'));
                        tmpVehiculo.VEHICULO = tmpRecord.get('CVVEH_CODIGO');
                        tmpVehiculo.MOTOR = null;                        
                    }
                });
                objBusqueda.show();
            }
        }
    });

    var cbxVehiculosActuales = new Ext.form.ComboBox({
        id:'cbxVehiculosActuales',
        fieldLabel :'Veh\u00EDculo',
        typeAhead: true,
        triggerAction: 'all',
        lazyRender:true,
        editable:true,
        forceSelection:true,
        mode: 'local',
        anchor:'98%',
        displayField:'RESUMEN',
        valueField:'CVVEH_CODIGO',
        emptyText:'Seleccione el veh\u00EDculo ...',
        listeners:{
            select:function(inSource, inRecord, inIndex){
                tmpVehiculo.VEHICULO = inRecord.data.CVVEH_CODIGO;
                cvvehCodigo = tmpVehiculo.VEHICULO;
                cbxCaducidadTramite.setVisible(true);
                cbxCaducidadTramite.setDisabled(true);
                cbxCaducidadTramite.setValue(0);
                dtCrtra_fecha_salida.setVisible(true);
                dtCrtra_fecha_salida.minValue = new Date(inRecord.data.CVVEH_FECHA_INGRESO);
                dtCrtra_fecha_salida.maxValue = CURRENT_DATE;

                if(cbxTramiteVehiculo.getValue() == 1){
                    strMotoresActuales.baseParams.inCvveh_codigo = tmpVehiculo.VEHICULO;
                    strMotoresActuales.reload();
                }
            }
        }
    });

    var cbxMotoresActuales = new Ext.form.ComboBox({
        id:'cbxMotoresActuales',
        fieldLabel :'Motor',
        typeAhead: true,
        triggerAction: 'all',
        lazyRender:true,
        editable:true,
        forceSelection:true,
        mode: 'local',
        anchor:'98%',
        displayField:'RESUMEN',
        valueField:'CVMTR_CODIGO',
        emptyText:'Seleccione el motor ...',
        listeners:{
            select:function(inSource, inRecord, inIndex){
                tmpVehiculo.MOTOR = inRecord.data.CVMTR_CODIGO;
                tmpVehiculo.VEHICULO = inRecord.data.CVVEH_CODIGO;

                cvvehCodigo = tmpVehiculo.VEHICULO;
                cvmtrCodigo = tmpVehiculo.MOTOR;

                cbxCaducidadTramite.setVisible(true);
                cbxCaducidadTramite.setDisabled(true);
                cbxCaducidadTramite.setValue(0);
                dtCrtra_fecha_salida.setVisible(true);
                dtCrtra_fecha_salida.minValue = new Date(inRecord.data.CVMTR_FECHA_INGRESO);
                dtCrtra_fecha_salida.maxValue = CURRENT_DATE;
            }
        }
    });

    var cbxVehiculoReemplazo = new Ext.form.ComboBox({
        id:'cbxVehiculoReemplazo',
        fieldLabel :'Reemplaza a',
        typeAhead: true,
        triggerAction: 'all',
        lazyRender:true,
        editable:false,
        forceSelection:true,
        mode: 'local',
        anchor:'98%',
        displayField:'RESUMEN',
        valueField:'CVVEH_CODIGO',
        emptyText:'Seleccione el veh\u00EDculo ...',
        listeners:{
            select:function(inSource, inRecord, inIndex){
                tmpVehiculoReemplazo.VEHICULO = inRecord.data.CVVEH_CODIGO;
                tmpVehiculoReemplazo.MOTOR = null;
            }
        }
    });

    var cbxMotorReemplazo = new Ext.form.ComboBox({
        id:'cbxMotorReemplazo',
        fieldLabel :'Reemplaza a',
        typeAhead: true,
        triggerAction: 'all',
        lazyRender:true,
        editable:false,
        forceSelection:true,
        mode: 'local',
        anchor:'98%',
        displayField:'RESUMEN',
        valueField:'CVMTR_CODIGO',
        emptyText:'Seleccione el motor ...',
        listeners:{
            select:function(inSource, inRecord, inIndex){
                tmpVehiculoReemplazo.MOTOR = inRecord.data.CVMTR_CODIGO;
                tmpVehiculoReemplazo.VEHICULO = null;
            }
        }
    });
    //////////////////////////////////////////////////////////////////////////

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_solicitud_requisito.
     */
    var cmCgg_res_solicitud_requisito = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(),
    {
        dataIndex: 'CRREQ_CODIGO',
        header: 'Requisito',
        width: 240,
        sortable: true,
        renderer: function(inCRREQ_CODIGO){
            var i = 0;
            var result = 'no datos';
            for (i = 0; i < SCGG_RES_REQUISITO.getCount(); i++) {
                var rRequisito = SCGG_RES_REQUISITO.getAt(i);
                if (rRequisito.get('CRREQ_CODIGO') == inCRREQ_CODIGO) {
                    result = rRequisito.get('CRREQ_DESCRIPCION');
                    break;
                }
            }
            return result;
        }
    }, {
        dataIndex: 'CRSRQ_DESCRIPCION',
        header: 'Descripci\u00F3n',
        width: 170,
        sortable: true,
        hidden:true
    }, {
        dataIndex: 'CRSRQ_PARTICIPANTE',
        header: 'Participante',
        width: 80,
        sortable: true,
        hidden: true,
        renderer: function(inCRSRQ_PARTICIPANTE){
            var result = 'no datos';
            for (var i = 0; i < dsTipoParticipante.length; i++) {
                if (dsTipoParticipante[i][0] == inCRSRQ_PARTICIPANTE) {
                    result = dsTipoParticipante[i][1];
                    break;
                }
            }
            return result;
        }
    }, chkCrsrq_requerido, {
        dataIndex: 'CRRQT_CODIGO',
        header: 'Codigo',
        width: 100,
        sortable: true,
        hidden: true,
        hideable: false
    }, {
        dataIndex: 'CRTRA_CODIGO',
        header: 'Tramite',
        hidden: true,
        hideable: false
    }, cbcCRRQT_CUMPLE, {
        dataIndex: 'CRRQT_OBSERVACION',
        header: 'Observaci\u00F3n',
        width: 350,
        sortable: true,
        editor: {
            xtype: 'textfield'
        }
    },{
        dataIndex: 'CRATE_DATA',
        header: 'Datos adjunto',
        hidden:true,
        hideable:false
    }]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_solicitud_requisito por un campo especifico.
     */
    var gsCgg_res_solicitud_requisito = new Ext.data.GroupingStore({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_res_requisito_tramite",
            method: "selectTramiteTipoSolcitudRequisito"
        }),
        reader: new Ext.data.JsonReader({}, [
        {
            name: 'CRSRQ_CODIGO'
        },

        {
            name: 'CRTSR_CODIGO'
        },

        {
            name: 'CRREQ_CODIGO'
        },

        {
            name: 'CRSRQ_DESCRIPCION'
        },

        {
            name: 'CRSRQ_REQUERIDO'
        },

        {
            name: 'CRSRQ_PARTICIPANTE'
        },

        {
            name: 'CRRQT_CODIGO'
        },

        {
            name: 'CRTRA_CODIGO'
        },

        {
            name: 'CRRQT_CUMPLE'
        },

        {
            name: 'CRRQT_OBSERVACION'
        },

        {
            name: 'CRATE_DATA'
        }
        ]),
        groupField: 'CRSRQ_PARTICIPANTE',
        baseParams: {
            inCrtst_codigo: null,
            inCrtra_codigo: null,
            format: TypeFormat.JSON
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_solicitud_requisito en un formato tabular de filas y columnas.
     */
    var grdCgg_res_solicitud_requisito = new Ext.grid.EditorGridPanel({
        store: gsCgg_res_solicitud_requisito,
        cm: cmCgg_res_solicitud_requisito,
        region: 'center',
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Requisitos" : "Requisito"]})'
        }),
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true,
            moveEditorOnEnter:false
        }),
        plugins: cbcCRRQT_CUMPLE,
        loadMask: {
            msg: "Cargando..."
        },
        clicksToEdit: 1
    });

    var cbsmFase = new Ext.grid.CheckboxSelectionModel({
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
        forceSelection:true,
        triggerAction:'all',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CRPER_NOMBRES}" class="x-combo-list-item">{CRPER_NOMBRES}</div></tpl>',
        valueField:'CUSU_CODIGO'
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_fase.
     */
    var cmCgg_res_fase = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        cbsmFase,
        {
            dataIndex: 'CRFAS_CODIGO',
            header: 'Codigo',
            width: 150,
            hidden: true,
            hideable: true
        },

        {
            dataIndex: 'CRPRO_CODIGO',
            header: 'Codigo',
            width: 150,
            hidden: true,
            hideable: true
        },

        {
            dataIndex: 'CRETT_CODIGO',
            header: 'Codigo',
            width: 150,
            hidden: true,
            hideable: true
        },

        {
            dataIndex: 'CGG_CRETT_CODIGO',
            header: 'Crett codigo',
            width: 150,
            hidden: true,
            hideable: true
        },

        {
            dataIndex: 'CRSEC_CODIGO',
            header: 'Codigo',
            width: 150,
            hidden: true,
            hideable: true
        },

        {
            dataIndex: 'CGG_CRFAS_CODIGO',
            header: 'Crfas codigo',
            width: 150,
            hidden: true,
            hideable: true
        },

        {
            dataIndex: 'CGG_CUSU_CODIGO',
            header: 'Cusu codigo',
            width: 150,
            hidden: true,
            hideable: true
        },

        {
            dataIndex: 'CRFAS_NOMBRE',
            header: 'Nombre',
            width: 150
        },

        {
            dataIndex: 'CRFAS_ORDEN',
            header: 'Orden',
            width: 150,
            hidden:true
        },

        {
            dataIndex: 'CRFAS_SUBE_ADJUNTO',
            header: 'Sube adjunto',
            width: 150,
            hidden: true,
            hideable: true
        },

        {
            dataIndex: 'CUSU_CODIGO',
            header: 'Usuario',
            width: 240,
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
        },
        /*{
            dataIndex: 'CRFAS_SUMILLA',
            header: 'Comentario/Sumilla',
            width: 150,
            sortable: true,
            editor: {
                xtype: 'textfield'
            }
        },*/ {
            dataIndex: 'CRFAS_TAREA_REALIZA',
            header: 'Actividad',
            width: 150,
            sortable: true
        }]);

    var sCgg_res_fase = new Ext.data.Store({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_res_fase",
            method: "selectCGG_RES_PROCESO"
        }),
        reader: new Ext.data.JsonReader({}, [{
            name: 'CRFAS_CODIGO'
        }, {
            name: 'CRPRO_CODIGO'
        }, {
            name: 'CRETT_CODIGO'
        }, {
            name: 'CGG_CRETT_CODIGO'
        }, {
            name: 'CRSEC_CODIGO'
        }, {
            name: 'CGG_CRFAS_CODIGO'
        }, {
            name: 'CGG_CUSU_CODIGO'
        }, {
            name: 'CRFAS_NOMBRE'
        }, {
            name: 'CRFAS_ORDEN'
        }, {
            name: 'CRFAS_TAREA_REALIZA'
        }, {
            name: 'CRFAS_SUBE_ADJUNTO'
        }, {
            name: 'CRFAS_SUMILLA'
        }, {
            name: 'CUSU_CODIGO'
        }]),
        baseParams: {
            inCrpro_codigo: null,
            inCisla_codigo:null,
            format:TypeFormat.JSON
        },
        listeners:{
            load:function(inThis,inRecords){
                if(crfaseSiguiente == null){
                    return;
                }

                inThis.each(function(inRecord){
                    if(inRecord.get('CRFAS_CODIGO')==crfaseSiguiente.CRFAS_CODIGO){
                        cbsmFase.unlock();
                        cbsmFase.clearSelections();
                        var tmpRegistro = [];
                        tmpRegistro[0]=inRecord;
                        cbsmFase.selectRecords(tmpRegistro, false);
                        cbsmFase.lock();
                    }
                });
            }
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_fase en un formato tabular de filas y columnas.
     */
    var grdCgg_res_fase = new Ext.grid.EditorGridPanel({
        cm: cmCgg_res_fase,
        store: sCgg_res_fase,
        region: 'center',
        frame: true,
        sm: cbsmFase,
        tbar: ['Destinatario/s'],
        loadMask: {
            msg: "Cargando..."
        },
        clicksToEdit: 1,
        listeners: {
            afteredit: function(inObject){
                if (inObject.value.trim().length == 0) {
                    inObject.value = 'Atender, por favor.';
                }
            }
        }
    });

    var fsPendiente = new Ext.form.FieldSet({
        id: 'fsPendiente',
        title: 'Tr\u00E1mite pendiente',
        layout: 'form',
        collapsible: true,
        collapsed: true,
        disabled: true,
        items: [chkCrtra_pendiente, txtCrtra_observacion_pendiente]
    });

    var cmAdjuntos = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
        header: "Archivos",
        dataIndex: "ARCHIVO",
        width: '100%',
        sortable: true
    }]);

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_adjunto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_adjunto = new Ext.grid.GridPanel({
        id: 'grdCgg_res_adjunto',
        cm: cmAdjuntos,
        store: new Ext.data.JsonStore({}),
        region: 'center',
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true,
            moveEditorOnEnter: false
        }),
        viewConfig: {
            forceFit: true
        },
        loadMask: {
            msg: "Cargando..."
        },
        trackMouseOver: true,
        tbar: ['Adjuntos', {
            id: 'btnAgregarAdjunto',
            iconCls: 'iconNuevo',
            handler: function(){
                var values = {};
                var dato = "<div width='100%'><INPUT TYPE='file' id='fu" + grdCgg_res_adjunto.getStore().getCount() + "' size='25' name='inAdjuntos'/></div> ";
                values['ARCHIVO'] = dato;
                var record = new Ext.data.Record(values, grdCgg_res_adjunto.getStore().getCount());
                grdCgg_res_adjunto.getStore().add(record);
            }
        }, {
            id: 'btnEliminarAdjunto',
            iconCls: 'iconEliminar',
            handler: function(){
                var seleccionado = grdCgg_res_adjunto.getSelectionModel().getSelected();
                if (seleccionado != null) {
                    grdCgg_res_adjunto.getStore().remove(seleccionado);
                }
                else
                if (grdCgg_res_adjunto.getStore().getCount() >= 1) {
                    grdCgg_res_adjunto.getSelectionModel().selectLastRow();
                    grdCgg_res_adjunto.getStore().remove(grdCgg_res_adjunto.getSelectionModel().getSelected());
                }
            }
        }]

    });

    var fsSeleccionaGarantia = new Ext.form.FieldSet({
        id:'fsSeleccionaGarantia',
        collapsed:false,
        title: 'Seleccionar garant\u00eda',
        autoHeight:true,
        items:[{
            xtype:'panel',
            layout:'column',
            items:[{
                columnWidth:.88,
                layout:'form',
                items:[txtCrdpt_codigo]
            },{
                columnWidth:.06,
                layout:'form',
                items:[btnCrdpt_codigoCgg_res_tramite]
            },{
                columnWidth:.06,
                layout:'form',
                items:[btnCrearGarantia]
            }]
        }]
    });

    var pnlGarantia = new Ext.Panel({
        id:'pnlGarantia',
        items:[fsSeleccionaGarantia],
        region:'north',
        autoHeight:true
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_garantia_solicitud.
     */
    var cmCgg_res_garantia_solicitud = new Ext.grid.ColumnModel([
    {
        dataIndex:'CRGTS_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRGRT_CODIGO',
        header:'Garant\u00EDa',
        width:150,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRTST_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRTST_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },{
        dataIndex:'CRGRT_DESCRPCION',
        header:'Descripci\u00F3n',
        width:150,
        sortable:true
    },{
        dataIndex:'CRGRT_VALOR',
        header:'Valor',
        width:100,
        sortable:true
    }
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_garantia_solicitud por un campo especifico.
     */
    var sCgg_res_garantia_solicitud = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_garantia_solicitud",
            method:"selectCgg_res_tipo_solicitud_tramite1"
        }),
        reader:new Ext.data.JsonReader({},[
        {
            name:'CRGTS_CODIGO'
        },

        {
            name:'CRGRT_CODIGO'
        },

        {
            name:'CRTST_CODIGO'
        },

        {
            name:'CRGRT_DESCRPCION'
        },

        {
            name:'CRGRT_VALOR'
        }
        ]),
        baseParams:{
            inCrtst_codigo:null,
            format:TypeFormat.JSON
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_garantia_solicitud en un formato tabular de filas y columnas.
     */
    var grdCgg_res_garantia_solicitud = new Ext.grid.GridPanel({
        cm:cmCgg_res_garantia_solicitud,
        store:sCgg_res_garantia_solicitud,
        region:'center',
        loadMask:{
            msg:"Cargando..."
        },
        tbar: ['Garantia/s'],
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        viewConfig:{
            forceFit:true
        }
    });

    var chkCrtra_recalificacion= new Ext.form.Checkbox({
        id:'chkCrtra_recalificacion',
        name:'chkCrtra_recalificacion',
        fieldLabel:'Recalificaci\u00f3n',
        checked: false,
        hidden:true,
        submitValue: false
    });

    var tpFrmCgg_res_tramite = new Ext.TabPanel({
        id: 'tpFrmCgg_res_tramite2',
        region: 'center',
        activeTab: 0,
        width: '60%',
        items: [{
            layout: 'border',
            id: 'tpFrmCgg_res_tramite21',
            title: 'Requisitos',
            items: [{
                xtype:'panel',
                layout:'border',
                id:'pnlTpFrmCgg_res_tramite21',
                region:'center',
                items:[grdCgg_res_solicitud_requisito]
            }]
        }, {
            layout: 'border',
            title: 'Proceso - seguimiento',
            id: 'tpFrmCgg_res_tramite23',
            frame: true,
            items: [{
                xtype:'panel',
                layout:'border',
                region:'center',
                id:'pnlTpFrmCgg_res_tramite23',
                items:[{
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
                }, grdCgg_res_fase]
            }]
        },
//MO
        /*{
            title: 'Garant\u00EDas',
            id: 'tpFrmCgg_res_tramite24',
            frame: true,
            layout: 'border',
            items: [{
                xtype: 'panel',
                layout: 'border',
                id: 'pnlTpFrmCgg_res_tramite24',
                region: 'center',
                items: [pnlGarantia, grdCgg_res_garantia_solicitud]
            }]
        },*/
//
            {
            title: 'Mas informaci\u00F3n',
            id: 'tpFrmCgg_res_tramite22',
            frame: true,
            layout:'border',
            items:[
            {
                xtype:'panel',
                id:'pnlTpFrmCgg_res_tramite22',
                region:'center',
                layout: 'form',
                autoScroll: true,
                anchor:'100%',
                items:[
                {
                    xtype:'panel',
                    id:'pnlCaducidad',
                    anchor:'100%',
                    layout:'column',
                    items:[{
                        labelWidth:160,
                        columnWidth:.4,
                        layout:'form',
                        items:[cbxCaducidadTramite]
                    },{
                        xtype:'panel',
                        columnWidth:.6,
                        layout:'hbox',
                        items:[numCrtra_dias_permanencia,dtCrtra_fecha_salida]
                    }]
                },
                chkCrtra_recalificacion,
                fsPendiente]
            }]
        }]
    });

    var pnlFrmCgg_res_tramite3 = new Ext.FormPanel({
        id: 'pnlFrmCgg_res_tramite3',
        region: 'east',
        layout: 'border',
        fileUpload: true,
        hidden : true,
        collapsible:true,
        collapsed:true,
        split: true,
        width: '40%',
        frame:true,
        items: [grdCgg_res_adjunto]
    });

    var pnlFrmCgg_res_tramite2 = new Ext.Panel({
        id: 'pnlFrmCgg_res_tramite2',
        region: 'center',
        layout: 'border',
        items: [tpFrmCgg_res_tramite, pnlFrmCgg_res_tramite3]
    });

    var pnlFrmCgg_res_tramitePrincipal = new Ext.Panel({
        id: 'pnlFrmCgg_res_tramitePrincipal',
        region: 'center',
        layout: 'border',
        items: [pnlFrmCgg_res_tramite2, pnlFrmCgg_res_tramite1Norte]
    });

    //AC=>
    var btnAdjuntos = new Ext.ux.form.AlfrescoFM({
        id:'compAdjunto',   //(opcional)
        name:'compAdjunto', //(opcional)
        text: 'Adjuntos',    //(opcional -> Texto del botón)
        tableName: 'Cgg_res_tramite',
        validateRecordID:true,
        recordID : (inRecordCgg_res_tramite?inRecordCgg_res_tramite.get('CRTRA_CODIGO'):null),
        filter: "crtst_codigo='"+(inRecordCgg_res_tramite?inRecordCgg_res_tramite.get('CRTST_CODIGO'):null)+"'"
    });


    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_tramite.
     */
    var winFrmCgg_res_tramite = new Ext.Window({
        id: 'winFrmCgg_res_tramite',
        iconCls: 'iconRegistrarTramite',
        title: tituloCgg_res_tramite,
        tbar: getPanelTitulo(tituloCgg_res_tramite, descCgg_res_tramite),
        layout: 'border',
        items:[pnlFrmCgg_res_tramitePrincipal],
        width: 800,
        minWidth: 600,
        height: 600,
        minHeight: 500,
        maximizable: true,
        constrain: true,
        modal: true,
        bbar: [btnGuardarCgg_res_tramite,btnCgg_res_tramiteSoloGuardar,'-',btnAdjuntos,{
            id:'btnOpciones',
            text: 'Opciones',
            menu: {
                xtype: 'menu',
                plain: true,
                items: [{
                    id: 'miChkEmitirComprobante',
                    checked: true,
                    text: 'Emitir comprobante'
                }, {
                    id: 'miChkEmitirGarantia',
                    checked: true,
                    text: 'Emitir garant\u00EDa'
                }, '-', {
                    id: 'miChkSugerirSumilla',
                    checked: true,
                    text: 'Sugerir a comentario/sumilla vac\u00EDa'
                }]
            }
        },{
            id:'btnAvisoTramite',
            hidden:true,
            iconCls:'iconAviso',
            text:'Este tr\u00e1mite fue despachado.'
        },'->', btnCerrarCgg_res_tramite],
        listeners: {
            show:function(){

                var scpIsla = new SOAPClientParameters();
                scpIsla.add('inCisla_codigo',userInfo.CISLA_CODIGO);
                scpIsla.add('format',TypeFormat.JSON);

                SOAPClient.invoke(URL_WS+'Cgg_isla', 'select', scpIsla, true, function(inServiceResponse){
                    var tmpIsla1 = null;
                    try{
                        tmpIsla1 = Ext.util.JSON.decode(inServiceResponse);
                        tmpIsla1=tmpIsla1[0];
                        txtCisla_codigo.setValue(tmpIsla1.CISLA_NOMBRE);
                        tmpIsla = tmpIsla1.CISLA_CODIGO;
                    }catch(inErr){
                        if (new ManagerCookies().read('CGG_ISLA') != null) {
                            var rIsla = eval('[' + new ManagerCookies().read('CGG_ISLA') + ']')[0];
                            txtCisla_codigo.setValue(rIsla.CISLA_NOMBRE);
                            tmpIsla = rIsla.CISLA_CODIGO;
                        }
                    }
                });

                for (var i = 0; i < tpFrmCgg_res_tramite.items.length; i++) {
                    tpFrmCgg_res_tramite.setActiveTab(i);
                }
                tpFrmCgg_res_tramite.setActiveTab(0);

                if(inRecordCgg_res_tramite ==null && inRecordCgg_res_tramite ==undefined ){
                    habilitarTramite(false);
                }

            }
        }
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_res_tramite.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_res_tramiteCtrls(inEstado){
        var estado = inEstado;
        txtCrtra_codigo.setDisabled(estado);
        txtCrper_codigo.setDisabled(estado);
        txtCrpjr_codigo.setDisabled(estado);
        txtCgg_crper_codigo.setDisabled(estado);
        txtCrpro_codigo.setDisabled(estado);
        txtCrtst_codigo.setDisabled(estado);
        txtCrett_codigo.setDisabled(estado);
        //txtCisla_codigo.setDisabled(estado);
        txtCrdpt_codigo.setDisabled(estado);
        numCrtra_anio.setDisabled(estado);
        txtCrtra_numero.setDisabled(estado);
        dtCrtra_fecha_recepcion.setDisabled(estado);
        txtCrtra_actividad_residencia.setDisabled(estado);
        txtCrtra_observacion.setDisabled(estado);
        numCrtra_dias_permanencia.setDisabled(estado);
        chkCrtra_pendiente.setDisabled(estado);
        txtCrtra_observacion_pendiente.setDisabled(estado);
        chkCrtra_atencion_cliente.setDisabled(estado);
        txtCrtra_comunicado_radial.setDisabled(estado);
        txtCrtra_motivo.setDisabled(estado);
        //numCrtra_folio.setDisabled(estado);
        spfCrtra_folio.setDisabled(estado);

        Ext.getCmp('btnGuardarCgg_res_tramite').setDisabled(estado);
        Ext.getCmp('btnOpciones').setDisabled(estado);
        btnCgg_crper_codigoCgg_res_tramite.setDisabled(estado);
        btnChangeIsla.setDisabled(estado);
        btnCisla_codigoCgg_res_tramite.setDisabled(estado);
        btnCrdpt_codigoCgg_res_tramite.setDisabled(estado);
        btnCrett_codigoCgg_res_tramite.setDisabled(estado);
        btnCrper_codigoCgg_res_tramite.setDisabled(estado);
        btnCrpjr_codigoCgg_res_tramite.setDisabled(estado);
        btnCrpro_codigoCgg_res_tramite.setDisabled(estado);
        btnCrtst_codigo.setDisabled(estado);
    }

    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_tramite.
     */
    function cargarCgg_res_tramiteCtrls(){
        var scpIsla = null;
        var tmpCislaRegistro =null;
        if (inRecordCgg_res_tramite){

            var scpTipoSolicitud=new SOAPClientParameters({
                inCrtst_codigo:inRecordCgg_res_tramite.get('CRTST_CODIGO'),
                format:TypeFormat.JSON
            });
            var tmpSolicitud = null;
            try{
                tmpSolicitud = SOAPClient.invoke(URL_WS+'Cgg_res_tipo_solicitud_tramite', 'select', scpTipoSolicitud, false, null);
                tmpSolicitud = eval(tmpSolicitud);
                tmpSolicitud=tmpSolicitud[0];
                txtCrtst_codigo.setValue(tmpSolicitud.CRTST_DESCRIPCION);
                tmpSolicitud = parseRecord(tmpSolicitud);
            }catch(inErr){
                Ext.MsgPopup.msg(tituloCgg_res_tramite, 'Lo sentimos sentimos se presento un problema al momento de consultar el tramite.<br>Error:'+inErr+'<br>'+ERR_MESSAGE,MsgPopup.WARNING);
                habilitarTramite(false);
                return;
            }

            txtCrtra_codigo.setValue(inRecordCgg_res_tramite.get('CRTRA_CODIGO'));

            if(inRecordCgg_res_tramite.get('CRPER_CODIGO')==null){
                tmpAuspiciante = null;
                txtCrper_codigo.setValue('');
            }else{
                var tmpAuspiciante1 = Ext.util.Format.undef(inRecordCgg_res_tramite.get('CRPER_CODIGO'));
                var scpAuspiciante = new SOAPClientParameters();
                scpAuspiciante.add('inCrper_codigo', tmpAuspiciante1);
                scpAuspiciante.add('format', TypeFormat.JSON);
                var tmpCrperRegistro = SOAPClient.invoke(URL_WS + "Cgg_res_persona", 'select', scpAuspiciante, false, null);
                try {
                    tmpCrperRegistro = Ext.util.JSON.decode(tmpCrperRegistro);
                    rAuspiciante.set('CRPER_CODIGO', tmpCrperRegistro[0].CRPER_CODIGO);
                    rAuspiciante.set('CRPER_NOMBRES', tmpCrperRegistro[0].CRPER_NOMBRES);
                    rAuspiciante.set('CRPER_APELLIDO_PATERNO', tmpCrperRegistro[0].CRPER_APELLIDO_PATERNO);
                    rAuspiciante.set('CRPER_APELLIDO_MATERNO', tmpCrperRegistro[0].CRPER_APELLIDO_MATERNO);
                    tmpAuspiciante = rAuspiciante;
                    txtCrper_codigo.setValue(rAuspiciante.get('CRPER_NOMBRES') + " " + rAuspiciante.get('CRPER_APELLIDO_PATERNO')+' '+(rAuspiciante.data.CRPER_APELLIDO_MATERNO?rAuspiciante.data.CRPER_APELLIDO_MATERNO:''));
                }catch (inErr) {
                    txtCrper_codigo.setValue(NO_DATA_MESSAGE);
                    tmpAuspiciante = null;
                }
            }

            txtCrpjr_codigo.setValue(inRecordCgg_res_tramite.get('CRPJR_CODIGO'));
            var tmpPersonaJuridicaRazonS = Ext.util.Format.undef(inRecordCgg_res_tramite.get('CRPJR_CODIGO'));
            var scpPersonaJuridica = new SOAPClientParameters();
            scpPersonaJuridica.add('inCrpjr_codigo', tmpPersonaJuridicaRazonS);
            scpPersonaJuridica.add('format', TypeFormat.JSON);
            var tmpCrpjrRegistro = SOAPClient.invoke(URL_WS + "Cgg_res_persona_juridica", 'select', scpPersonaJuridica, false, null);
            try {
                tmpCrpjrRegistro = Ext.util.JSON.decode(tmpCrpjrRegistro);
                rPersonaJuridicaRazonSocial.set('CRPJR_CODIGO', tmpCrpjrRegistro[0].CRPJR_CODIGO);
                rPersonaJuridicaRazonSocial.set('CRPJR_RAZON_SOCIAL', tmpCrpjrRegistro[0].CRPJR_RAZON_SOCIAL);
                txtCrpjr_codigo.setValue(rPersonaJuridicaRazonSocial.get('CRPJR_RAZON_SOCIAL'));
            }
            catch (inErr) {
                txtCrpjr_codigo.setValue(NO_DATA_MESSAGE);
                rPersonaJuridicaRazonSocial = null;
            }
            txtCgg_crper_codigo.setValue(inRecordCgg_res_tramite.get('CGG_CRPER_CODIGO'));
            var tmpBeneficiario = Ext.util.Format.undef(inRecordCgg_res_tramite.get('CGG_CRPER_CODIGO'));
            var scpBeneficiario = new SOAPClientParameters();
            scpBeneficiario.add('inCrper_codigo', tmpBeneficiario);
            scpBeneficiario.add('format', TypeFormat.JSON);
            var tmpCggcrperRegistro = SOAPClient.invoke(URL_WS + "Cgg_res_persona", 'select', scpBeneficiario, false, null);
            try {
                tmpCggcrperRegistro = Ext.util.JSON.decode(tmpCggcrperRegistro);
                rBeneficiario.set('CRPER_CODIGO', tmpCggcrperRegistro[0].CRPER_CODIGO);
                rBeneficiario.set('CRPER_NOMBRES', tmpCggcrperRegistro[0].CRPER_NOMBRES);
                rBeneficiario.set('CRPER_APELLIDO_PATERNO', tmpCggcrperRegistro[0].CRPER_APELLIDO_PATERNO);
                rBeneficiario.set('CRPER_APELLIDO_MATERNO', tmpCggcrperRegistro[0].CRPER_APELLIDO_MATERNO);
                rBeneficiario.set('CRPER_NUM_DOC_IDENTIFIC', tmpCggcrperRegistro[0].CRPER_NUM_DOC_IDENTIFIC);
                rBeneficiario.set('CRPER_FECHA_NACIMIENTO', tmpCggcrperRegistro[0].CRPER_FECHA_NACIMIENTO);
                txtCgg_crper_codigo.setValue(rBeneficiario.get('CRPER_NOMBRES') + " " + rBeneficiario.get('CRPER_APELLIDO_PATERNO')+ ' ' + (rBeneficiario.data.CRPER_APELLIDO_MATERNO?rBeneficiario.data.CRPER_APELLIDO_MATERNO:''));
            }catch (inErr) {
                txtCgg_crper_codigo.setValue(NO_DATA_MESSAGE);
                rBeneficiario = null;
            }

            txtCrett_codigo.setValue(inRecordCgg_res_tramite.get('CRETT_CODIGO'));

            var tmpIsla = inRecordCgg_res_tramite.get('CISLA_CODIGO');
            scpIsla = new SOAPClientParameters();
            scpIsla.add('inCisla_codigo', tmpIsla);
            scpIsla.add('format', TypeFormat.JSON);
            tmpCislaRegistro = SOAPClient.invoke(URL_WS + "Cgg_isla", 'select', scpIsla, false, null);
            try {
                tmpCislaRegistro = Ext.util.JSON.decode(tmpCislaRegistro);
                rIsla.set('CISLA_CODIGO', tmpCislaRegistro[0].CISLA_CODIGO);
                rIsla.set('CISLA_NOMBRE', tmpCislaRegistro[0].CISLA_NOMBRE);
                tmpIsla = rIsla;
                txtCisla_codigo.setValue(rIsla.get('CISLA_NOMBRE'));
            }
            catch (inErr) {
                txtCisla_codigo.setValue(NO_DATA_MESSAGE);
                tmpIsla = null;
            }

            var scpDepositoGarantia = new SOAPClientParameters({
                inCrtra_codigo:inRecordCgg_res_tramite.get('CRTRA_CODIGO'),
                format:TypeFormat.JSON
            });

            var tmpCrdptRegistro = SOAPClient.invoke(URL_WS + "Cgg_res_tramite_garantia", 'selectCGG_RES_TRAMITE_GARANTIA', scpDepositoGarantia, false, null);
            try {
                tmpCrdptRegistro = Ext.util.JSON.decode(tmpCrdptRegistro);
                tmpCrdptRegistro = tmpCrdptRegistro[0];
                rDepositoGarantia.set('CRDPT_CODIGO', tmpCrdptRegistro.CRDPT_CODIGO);
                rDepositoGarantia.set('CRDPT_NUMERO', tmpCrdptRegistro.CRDPT_NUMERO);
                rDepositoGarantia.set('CRGRT_CODIGO', tmpCrdptRegistro.CRGRT_CODIGO);
                crgrtCodigo = tmpCrdptRegistro.CRGRT_CODIGO;
                tmpDepositoGarantia = rDepositoGarantia;
                txtCrdpt_codigo.setValue(rDepositoGarantia.get('CRDPT_NUMERO')+ ' - $' + tmpCrdptRegistro.CRDPT_VALOR_DEPOSITO);
            }catch (inErr) {
                txtCrdpt_codigo.setValue(NO_DATA_MESSAGE);
                rDepositoGarantia = null;
                tmpDepositoGarantia = null;
            }

            txtCrtra_numero.setValue(inRecordCgg_res_tramite.get('CRTRA_ANIO')+'-'+inRecordCgg_res_tramite.get('CRTRA_NUMERO'));

            if(inRecordCgg_res_tramite.get('CRTRA_ACTIVIDAD_RESIDENCIA')!==undefined && inRecordCgg_res_tramite.get('CRTRA_ACTIVIDAD_RESIDENCIA')!==undefined && inRecordCgg_res_tramite.get('CRTRA_ACTIVIDAD_RESIDENCIA') !== null && inRecordCgg_res_tramite.get('CRTRA_ACTIVIDAD_RESIDENCIA').trim().length >=0){
                var scpCargo = new SOAPClientParameters({
                    inCgcrg_codigo:inRecordCgg_res_tramite.get('CRTRA_ACTIVIDAD_RESIDENCIA'),
                    format:TypeFormat.JSON
                });

                SOAPClient.invoke(URL_WS+'Cgg_gem_cargo','select',scpCargo,true,function(inServiceResponse){
                    inServiceResponse = Ext.util.JSON.decode(inServiceResponse);
                    inServiceResponse=inServiceResponse[0];
                    tmpCargo= inServiceResponse.CGCRG_CODIGO;
                    txtCrtra_actividad_residencia.setValue(inServiceResponse.CGCRG_NOMBRE);
                });
            }

            txtCrtra_observacion.setValue(inRecordCgg_res_tramite.get('CRTRA_OBSERVACION'));

            chkCrtra_pendiente.setValue(inRecordCgg_res_tramite.get('CRTRA_PENDIENTE'));
            txtCrtra_observacion_pendiente.setValue(inRecordCgg_res_tramite.get('CRTRA_OBSERVACION_PENDIENTE'));
            chkCrtra_atencion_cliente.setValue(inRecordCgg_res_tramite.get('CRTRA_ATENCION_CLIENTE'));
            txtCrtra_comunicado_radial.setValue(inRecordCgg_res_tramite.get('CRTRA_COMUNICADO_RADIAL'));

            chkCrtra_recalificacion.setValue(inRecordCgg_res_tramite.get('CRTRA_MOTIVO'));

            spfCrtra_folio.setValue(inRecordCgg_res_tramite.get('CRTRA_FOLIO'));

            if(inRecordCgg_res_tramite.get('CRETT_CODIGO')==crettSoloGuardado && esHistorico == true){

                Ext.getCmp('pnlTpFrmCgg_res_tramite21').disable();
                Ext.getCmp('pnlTpFrmCgg_res_tramite23').disable();
                btnCrtst_codigo.disable();
                grdCgg_res_garantia_solicitud.disable();
                btnCgg_crper_codigoCgg_res_tramite.disable();
                btnCrper_codigoCgg_res_tramite.disable();
                btnGuardarCgg_res_tramite.disable();
                btnCgg_res_tramiteSoloGuardar.disable();
                Ext.getCmp('btnOpciones').disable();

                cargarSolicitud(tmpSolicitud,true);

                habilitarTramite(false);

            }else if(inRecordCgg_res_tramite.get('CRETT_CODIGO')==crettSoloGuardado && esHistorico == false){
                Ext.getCmp('pnlTpFrmCgg_res_tramite21').enable();
                Ext.getCmp('pnlTpFrmCgg_res_tramite23').enable();
                btnCrtst_codigo.enable();
                grdCgg_res_garantia_solicitud.enable();
                btnCgg_crper_codigoCgg_res_tramite.enable();
                btnCrper_codigoCgg_res_tramite.enable();
                btnGuardarCgg_res_tramite.enable();
                habilitarTramite(true);
                cargarSolicitud(tmpSolicitud,false);

                btnCrtst_codigo.disable();
                btnCgg_crper_codigoCgg_res_tramite.disable();
                btnRegistrarPersona.disable()

                isEdit = true;
            }else{
                //GRUPO DE COMPONENTES DESABILITADOS POR LA IMPORTANCIA DEL TRAMITE EN ESTE FORMULARIO.
                Ext.MsgPopup.msg(tituloCgg_res_tramite, 'Este tr\u00e1mite ya fue despachado y no puede ser modificado.', MsgPopup.INFO);
                Ext.getCmp('pnlTpFrmCgg_res_tramite21').disable();
                Ext.getCmp('pnlTpFrmCgg_res_tramite23').disable();
                btnCrtst_codigo.disable();
                grdCgg_res_garantia_solicitud.disable();
                btnCgg_crper_codigoCgg_res_tramite.disable();
                btnCrper_codigoCgg_res_tramite.disable();
                btnGuardarCgg_res_tramite.disable();
                btnCgg_res_tramiteSoloGuardar.disable();
                Ext.getCmp('btnAvisoTramite').show();
                Ext.getCmp('btnOpciones').disable();
                habilitarTramite(false);
            }

            if(inRecordCgg_res_tramite.get('CRTRA_FECHA_SALIDA')!==undefined && inRecordCgg_res_tramite.get('CRTRA_FECHA_SALIDA')!==null && inRecordCgg_res_tramite.get('CRTRA_FECHA_SALIDA').trim().length >= 0){
                cbxCaducidadTramite.setValue(0);
                var tmpFecha = formatShortDate(inRecordCgg_res_tramite.get('CRTRA_FECHA_SALIDA'));
                dtCrtra_fecha_salida.setValue(tmpFecha);
                numCrtra_dias_permanencia.setValue(1);
                dtCrtra_fecha_salida.show();
                numCrtra_dias_permanencia.hide();
            }else{

                if(inRecordCgg_res_tramite.get('CRTRA_DIAS_PERMANENCIA')==0){
                    numCrtra_dias_permanencia.setValue(0);
                    dtCrtra_fecha_salida.setValue(new Date());
                    dtCrtra_fecha_salida.hide();
                    numCrtra_dias_permanencia.hide();
                    cbxCaducidadTramite.hide();
                }else{
                    cbxCaducidadTramite.setValue(1);
                    numCrtra_dias_permanencia.setValue(inRecordCgg_res_tramite.get('CRTRA_DIAS_PERMANENCIA'));
                    dtCrtra_fecha_salida.setValue(new Date());
                    dtCrtra_fecha_salida.hide();
                    numCrtra_dias_permanencia.show();
                }
            }

            isEdit = true;

        }else{

            var cisla_codigo = new UserSession().getUserData().CISLA_CODIGO;
            if(cisla_codigo !== null && cisla_codigo !== undefined){
                scpIsla = new SOAPClientParameters();
                scpIsla.add('inCisla_codigo', tmpIsla);
                scpIsla.add('format', TypeFormat.JSON);
                tmpCislaRegistro = SOAPClient.invoke(URL_WS + "Cgg_isla", 'select', scpIsla, false, null);
                try {
                    tmpCislaRegistro = Ext.util.JSON.decode(tmpCislaRegistro);
                    rIsla.set('CISLA_CODIGO', tmpCislaRegistro[0].CISLA_CODIGO);
                    rIsla.set('CISLA_NOMBRE', tmpCislaRegistro[0].CISLA_NOMBRE);
                    tmpIsla = rIsla;
                    txtCisla_codigo.setValue(rIsla.get('CISLA_NOMBRE'));
                }catch (inErr) {
                    txtCisla_codigo.setValue(NO_DATA_MESSAGE);
                    tmpIsla = null;
                }
            }

        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_tramite.
     * @returns ventana winFrmCgg_res_tramite.
     * @base FrmCgg_res_tramite.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_tramite;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_tramite.
     * @base FrmCgg_res_tramite.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_tramiteCtrls();
    }

    this.setDisabled=function(inFlag){
        disable = inFlag;
    }

    /**
     *Funcion. Valida las reglas basicas de control sobre el formulario.
     *@param inSoloGuardar Indica si la validacion es solo para guardar un tramite.
     *@return Verdadero/falso a la validacion de los controles del formulario.
     */
    function validarFormularioTramite(inSoloGuardar){
        var flagValidar = true;
        var flagValidarRequisito = true;

        if(isVehiculo && tmpVehiculo.VEHICULO == 'KEYGEN' && tmpVehiculo.MOTOR =='KEYGEN' && (!numCvmtr_tonelaje.getValue() || !cbxTrmVehCmb.getValue() || !cbxTrmVehCln.getValue() || !numCvmtr_anio_fabricacion.getValue())){
            Ext.Msg.show({
                title: tituloCgg_res_tramite,
                msg: 'Establezca todas las caracter\u00edsticas del veh\u00edculo.',
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.WARNING
            });
            return false;
        }       

        if(isVehiculo && cbxTramiteVehiculo.getValue() == 0 && cbxAccionVehiculo.getValue() == 1 && (!cbxVehiculosActuales.getValue())){
            Ext.Msg.show({
                title: tituloCgg_res_tramite,
                msg: 'Seleccione el vehiculo exitente antes de continuar.',
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.WARNING
            });
            return false;
        }

        if(isVehiculo && cbxTramiteVehiculo.getValue() == 1 && cbxAccionVehiculo.getValue() == 1 && (!cbxVehiculosActuales.getValue() || !cbxMotoresActuales.getValue())){
            Ext.Msg.show({
                title: tituloCgg_res_tramite,
                msg: 'Seleccione el vehiculo o motor exitente antes de continuar.',
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.WARNING
            });
            return false;
        }

        if(isVehiculo && cbxTramiteVehiculo.getValue() == 0 && cbxAccionVehiculo.getValue() == 2 && (!cbxVehiculosActuales.getValue())){
            Ext.Msg.show({
                title: tituloCgg_res_tramite,
                msg: 'Seleccione el vehiculo exitente libre, por favor.',
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.WARNING
            });
            return false;
        }

        if ((tmpTipoSolicitud == null || tmpTipoSolicitud == undefined)) {
            txtCrtst_codigo.markInvalid('Establezca el tipo de solicutud del tr\u00E1mite, por favor.');
            btnCrtst_codigo.focus();
            flagValidar = false;
            return flagValidar;
        }

        if (txtCisla_codigo.getValue() == null || txtCisla_codigo.getValue().trim().length == 0) {
            //txtCisla_codigo.setDisabled(false);
            txtCisla_codigo.markInvalid('Establezca la isla de tr\u00E1mite, por favor.');
            //btnCisla_codigoCgg_res_tramite.focus();
            btnChangeIsla.focus();
            flagValidar = false;
            return flagValidar;
        }

        if(!isVehiculo && (rBeneficiario.get('CRPER_CODIGO') == null || rBeneficiario.get('CRPER_CODIGO')==undefined || rBeneficiario.get('CRPER_CODIGO').trim().length == 0)){
            txtCgg_crper_codigo.markInvalid('Establezca el beneficiario del tr\u00e1mite, por favor.');
            btnCgg_crper_codigoCgg_res_tramite.focus();
            flagValidar = false;
            return flagValidar;
        }

        if (tmpTipoSolicitud.get('CRTST_COMUNICADO_RADIAL') == true) {
            if (txtCrtra_comunicado_radial.getValue().trim().length == 0) {
                txtCrtra_comunicado_radial.markInvalid('Establezca un comunicado radial, por favor.');
                txtCrtra_comunicado_radial.focus();
                flagValidar = false;
                return flagValidar;
            }
        }else{
            if(tmpAuspiciante == null && flagAuspiciante == false){
                flagAuspiciante = confirm('Esta seguro de no establecer el auspiciante?\nNo establecer auspiciante es recomendado para tr\u00e1mites por iniciativa propia.');
                if(flagAuspiciante==false){
                    txtCrper_codigo.markInvalid('Establezca el auspiciante del tr\u00e1mite o la empresa, por favor.');
                    btnCrper_codigoCgg_res_tramite.focus();
                    flagValidar = false;
                }
            }
        }

        if (tmpTipoSolicitud.get('CRTST_NUMERO_DIAS') > 0) {
            if(dtCrtra_fecha_salida.getValue() <= new Date()){
                Ext.Msg.show({
                    title: tituloCgg_res_tramite,
                    msg: 'Establezca una fecha de caducidad de la residencia correcta, por favor.',
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.WARNING
                });
                Ext.getCmp('tpFrmCgg_res_tramite2').activate('tpFrmCgg_res_tramite22');
                dtCrtra_fecha_salida.focus();
                flagValidar = false;
                return flagValidar;
            }
        }                
      
        //Validacion de garantia
       /* if(tmpTipoSolicitud.get('CRTST_APLICA_GARANTIA') == true) {
            if(tmpDepositoGarantia == null){
                Ext.Msg.show({
                    title: tituloCgg_res_tramite,
                    msg: 'Seleccione o establezca la garant\u00eda del tr\u00E1mite, por favor.',
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.WARNING
                });
                Ext.getCmp('tpFrmCgg_res_tramite2').activate('tpFrmCgg_res_tramite24');
                flagValidar = false;
            }else{
                flagValidar = true;
            }
        }*/

        if(inSoloGuardar == undefined){

            for (var i = 0; i < gsCgg_res_solicitud_requisito.getCount(); i++) {
                var rRequisito = gsCgg_res_solicitud_requisito.getAt(i);
                if (rRequisito.get('CRSRQ_REQUERIDO') == true) {
                    if (rRequisito.get('CRRQT_CUMPLE') == false) {
                        flagValidarRequisito = false;
                    }
                }
            }

            if (flagValidarRequisito == false) {
                Ext.Msg.show({
                    title: tituloCgg_res_tramite,
                    msg: 'Uno de los requisitos necesita cumplirse, por favor verifiquelos.',
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.WARNING
                });
                Ext.getCmp('tpFrmCgg_res_tramite2').activate('tpFrmCgg_res_tramite21');
                grdCgg_res_solicitud_requisito.focus();
                flagValidar = false;
                return flagValidar;
            }

            if(grdCgg_res_fase.getSelectionModel().getSelected()==null || grdCgg_res_fase.getSelectionModel().getSelected()==undefined){
                Ext.Msg.show({
                    title: tituloCgg_res_tramite,
                    msg: 'Seleccione una fase para despachar el tr\u00E1mite, por favor.',
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.WARNING
                });
                Ext.getCmp('tpFrmCgg_res_tramite2').activate('tpFrmCgg_res_tramite23');
                grdCgg_res_fase.focus();
                flagValidar = false;
                return flagValidar;
            }else{
                if (Ext.getCmp('miChkSugerirSumilla').checked == true) {
                    if (grdCgg_res_fase.getSelectionModel().getSelected().get('CRFAS_SUMILLA').trim().length == 0) {
                        if (txtCrtra_observacion.getValue().trim().length == 0) {
                            grdCgg_res_fase.getSelectionModel().getSelected().set('CRFAS_SUMILLA', 'Atender, por favor.');
                        }else {
                            grdCgg_res_fase.getSelectionModel().getSelected().set('CRFAS_SUMILLA', txtCrtra_observacion.getValue().trim());
                        }
                    }
                }
            }

        }
        return flagValidar;
    }

    /**
     *Funcion. Evalua las reglas de validacion del tramite.
     *@return Cadena de datos con informacion de las reglas validadas.
     */
    function evaluarReglaTramite(){
        var res = null;
        colReglaValidacion=eval(reglaValidacion);
        if(colReglaValidacion!==null){
            for(var i=0;i<colReglaValidacion.length;i++){
                var objTmp = Ext.decode(colReglaValidacion[i].CRTSE_CAMPO_EVALUACION)[0];
                for (var key in objTmp) {
                    objTmp[key] = eval(objTmp[key]);
                }
                colReglaValidacion[i].CRTSE_CAMPO_EVALUACION ='['+Ext.encode(objTmp)+']';
            }
            res = Ext.encode(colReglaValidacion);
        }
        return res;
    }

    /**
     *Funcion. consulta las reglas de validacion que aplican a este tipo de solicitud de tramite, las ejecuta y obtiene un resultado si es o no viable el registro de un tramite.
     */
    function validarReglaTramite(){
        var flagRegla = false;

        if(!tmpTipoSolicitud.data.CRTST_RESTRINGIDO)
            return true;

        pnlFrmCgg_res_tramitePrincipal.getEl().mask('Validando...', 'x-mask-loading');
        try{
            var jsonData = {};
            try{
                crtstCodigo = tmpTipoSolicitud.get('CRTST_CODIGO');
                crperCodigo = (tmpAuspiciante)?tmpAuspiciante.get('CRPER_CODIGO'):null;
                cggcrperCodigo = (rBeneficiario)?rBeneficiario.get('CRPER_CODIGO'):null;
                crperNumDocIdentific = rBeneficiario.get('CRPER_NUM_DOC_IDENTIFIC');
                cggCrperFechaNacimiento = rBeneficiario.get('CRPER_FECHA_NACIMIENTO');                
                crdptCodigo = tmpDepositoGarantia.data.CRDPT_CODIGO;
                jsonData = {'CRTST_CODIGO':crtstCodigo,
                            'CRPER_CODIGO':crperCodigo,
                            'CGGCRPER_CODIGO':cggcrperCodigo,
                            'CRPER_NUM_DOC_IDENTIFIC':crperNumDocIdentific,
                            'CRPER_FECHA_NACIMIENTO':cggCrperFechaNacimiento,
                            'CRDPT_CODIGO':crdptCodigo
                            };
            }catch(inErr){}

            var resultadoRegla = evaluarReglaTramite();
            if(resultadoRegla!==null){
                var param = new SOAPClientParameters();
                param.add('inJSON_reglas_validacion',resultadoRegla);
                param.add('jsonData',jsonData);
                var validacion = SOAPClient.invoke(URL_WS+'Cgg_regla_validacion' ,'ejecutarReglaTipoSolicitud',param, false, null);
                validacion = Ext.util.JSON.decode(validacion);
                if(validacion.resultadoValidacion !== undefined){
                    if(validacion.resultadoValidacion == 'false'){
                        var objCgg_regla_validacion = new FrmListadoCgg_regla_validacion_resultado(validacion);
                        objCgg_regla_validacion.loadData();
                        objCgg_regla_validacion.show();
                    }
                    flagRegla=eval(validacion.resultadoValidacion);
                }else{
                    flagRegla = null;
                }
            }
        }catch(inErr){
            Ext.MsgPopup.msg(tituloCgg_res_tramite, "No se ha podido validar la informaci\u00f3n a almacenar.<br>Error:"+inErr+'<br>'+ERR_MESSAGE);
            flagRegla = false;
        }
        pnlFrmCgg_res_tramitePrincipal.getEl().unmask();
        return flagRegla;
    }

    /**
     *Funcion. Verifica los controles y permisos deacuerdo a la informacon de tipo de solicitud.
     *La funcion cumple con reglas basicas de validar y habilitar componentes deacuerdo al tipo de solicitud.
     *@param inCrtst_data Informacion de la solicutud.
     *@return Verdadero/Falso.
     */
    function verificarSolicitud(inCrtst_data){
        var flagSolicitud  = true;

        if (inCrtst_data.data.CRTST_APLICA_TRAMITE !== true || new Tramite().iniciaTramite(inCrtst_data.data.CRTST_CODIGO, userInfo.CUSU_CODIGO)==false) {
            Ext.Msg.show({
                title: tituloCgg_res_tramite,
                msg: 'El tipo de solicitud o el usuario no puede iniciar un tr\u00E1mite, seleccione otro por favor.',
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.WARNING
            });
            return false;
        }

        if (inCrtst_data.data.CRTST_APLICA_GRUPO ==true){
            Ext.Msg.show({
                title: tituloCgg_res_tramite,
                msg: 'Este formulario no aplica para solicitudes grupales de tr\u00E1mites, seleccione otro por favor.',
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.WARNING
            });
            return false;
        }

       /* Ext.getCmp('miChkEmitirGarantia').checked =inCrtst_data.data.CRTST_APLICA_GARANTIA;
        Ext.getCmp('miChkEmitirGarantia').setDisabled(!inCrtst_data.data.CRTST_APLICA_GARANTIA);*/

        if(inCrtst_data.data.CRTST_NUMERO_DIAS==0){
            numCrtra_dias_permanencia.setValue(0);
            cbxCaducidadTramite.setVisible(false);
            numCrtra_dias_permanencia.setVisible(false);
            dtCrtra_fecha_salida.setVisible(false);
        }else{
            numCrtra_dias_permanencia.setValue(inCrtst_data.data.CRTST_NUMERO_DIAS);
            numCrtra_dias_permanencia.setMaxValue(inCrtst_data.data.CRTST_NUMERO_DIAS);

            var tmpFecha = new Date().add(Date.DAY,inCrtst_data.data.CRTST_NUMERO_DIAS);
            dtCrtra_fecha_salida.setValue(tmpFecha);
            dtCrtra_fecha_salida.setMaxValue(tmpFecha);
        }

       // Ext.getCmp('tpFrmCgg_res_tramite24').setDisabled(!inCrtst_data.data.CRTST_APLICA_GARANTIA);


        if(inCrtst_data.data.CRTST_COMUNICADO_RADIAL == true){
            txtCrtra_comunicado_radial.setDisabled( false );
            txtCrper_codigo.setDisabled( false );
            btnCrper_codigoCgg_res_tramite.setDisabled(true);
            txtCrpjr_codigo.setDisabled(false);
            btnCrpjr_codigoCgg_res_tramite.setDisabled(true);
            btnCgcrg_codigoCgg_gem_vacante.setDisabled(true);
            txtCrtra_actividad_residencia.setDisabled(false);

        }else{
            txtCrtra_comunicado_radial.setDisabled( true );
            txtCrper_codigo.setDisabled( false );
            btnCrper_codigoCgg_res_tramite.setDisabled(false);
            txtCrpjr_codigo.setDisabled(false);
            btnCrpjr_codigoCgg_res_tramite.setDisabled(false);
            btnCgcrg_codigoCgg_gem_vacante.setDisabled(true);
            txtCrtra_actividad_residencia.setDisabled(true);
        }

        habilitarTramite(true);

        return flagSolicitud;
    }

    ////////////////////////////////////////VEHICULOS///////////////////////////////
    function setVehiculo(){
        var tmpStoreCombustible = new FrmListadoCgg_veh_combustible().getStore();
        tmpStoreCombustible.baseParams.start = 0;
        tmpStoreCombustible.baseParams.limit = 1000;
        tmpStoreCombustible.reload();

        var tmpStoreCilindraje = new FrmListadoCgg_veh_cilindraje().getStore();
        tmpStoreCilindraje.baseParams.start = 0;
        tmpStoreCilindraje.baseParams.limit = 1000;
        tmpStoreCilindraje.reload();

        isVehiculo = true;
        /**
         * Ext.form.TextField IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
         */
        var txtCvctg_codigo = new Ext.form.TextField({
            id:'txtCvctg_codigo',
            name:'txtCvctg_codigo',
            fieldLabel :'Categor\u00eda',
            anchor:'98%',
            readOnly:'true',
            allowBlank :false
        });
        /**
         * IDENTIFICADOR UNICO DE REGISTRO DE CATEGORIA.
         */
        var btnCvctg_codigoCgg_veh_vehiculo = new Ext.Button({
            id:'btnCvctg_codigoCgg_veh_vehiculo',
            iconCls:'iconBuscar',
            listeners:{
                click:function(){
                    var tmpFLCgg_veh_categoria = new FrmListadoCgg_veh_categoria();
                    var objBusqueda = new DlgBusqueda(tmpFLCgg_veh_categoria.getStore(),tmpFLCgg_veh_categoria.getColumnModel());
                    objBusqueda.closeHandler(function(){
                        var tmpRecord = objBusqueda.getSelectedRow();
                        if(tmpRecord){
                            tmpDatos['CATEGORIA'] = tmpRecord.get('CVCTG_CODIGO');
                            txtCvctg_codigo.setValue(tmpRecord.get('CVCTG_NOMBRE'));
                        }
                    });
                    objBusqueda.show();
                }
            }
        });
        /**
         * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
         */
        var txtCvsct_codigo = new Ext.form.TextField({
            id:'txtCvsct_codigo',
            name:'txtCvsct_codigo',
            fieldLabel :'Sector',
            anchor:'98%',
            readOnly:'true',
            allowBlank :false
        });
        /**
         * IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR
         */
        var btnCvsct_codigoCgg_veh_vehiculo = new Ext.Button({
            id:'btnCvsct_codigoCgg_veh_vehiculo',
            iconCls:'iconBuscar',
            listeners:{
                click:function(){
                    var tmpFLCgg_veh_sector = new FrmListadoCgg_veh_sector();
                    var objBusqueda = new DlgBusqueda(tmpFLCgg_veh_sector.getStore(),tmpFLCgg_veh_sector.getColumnModel());
                    objBusqueda.closeHandler(function(){
                        var tmpRecord = objBusqueda.getSelectedRow();
                        if(tmpRecord){
                            tmpDatos['SECTOR'] = tmpRecord.get('CVSCT_CODIGO');
                            txtCvsct_codigo.setValue(tmpRecord.get('CVSCT_NOMBRE'));
                        }
                    });
                    objBusqueda.show();
                }
            }
        });
        /**
         * Ext.form.NumberField CAPACIDAD DE CARGA
         */
        var numCvmtr_tonelaje = new Ext.form.NumberField({
            id: 'numCvmtr_tonelaje',
            name: 'numCvmtr_tonelaje',
            fieldLabel: 'Tonelaje',
            allowBlank:false,
            disabled:false,
            minValue:0,
            value:0
        });

        var cbxTrmVehCmb = new Ext.form.ComboBox({
            id:'cbxTrmVehCmb',
            fieldLabel :'Combustible',
            typeAhead: true,
            triggerAction: 'all',
            lazyRender:true,
            forceSelection:true,
            mode: 'local',
            anchor:'98%',
            editable:false,
            displayField:'CVCMB_NOMBRE',
            valueField:'CVCMB_CODIGO',
            emptyText:'Seleccione el combustible del motor ...',
            store:tmpStoreCombustible,
            listeners:{
                select:function(inSource, inRecord, inIndex){
                    tmpDatos['COMBUSTIBLE'] = cbxTrmVehCmb.getValue();
                }
            }
        });
        var cbxTrmVehCln = new Ext.form.ComboBox({
            id:'cbxTrmVehCln',
            fieldLabel :'Cilindraje',
            typeAhead: true,
            triggerAction: 'all',
            lazyRender:true,
            editable:false,
            forceSelection:true,
            mode: 'local',
            anchor:'98%',
            displayField:'CVCLN_CILINDRAJE',
            valueField:'CVCLN_CODIGO',
            emptyText:'Seleccione el cilindraje del motor ...',
            store:tmpStoreCilindraje,
            listeners:{
                select:function(inSource, inRecord, inIndex){
                    tmpDatos['CILINDRAJE'] = cbxTrmVehCln.getValue();
                }
            }
        });

        /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_solicitud_requisito por un campo especifico.
         */
        strVehiculosActuales = new Ext.data.Store({
            proxy: new Ext.ux.bsx.SoapProxy({
                url: URL_WS + "Cgg_veh_historial",
                method: "selectVehiculo"
            }),
            reader: new Ext.data.JsonReader({}, [
            {
                name: 'CVVEH_CODIGO'
            },

            {
                name: 'RESUMEN'
            },

            {
                name: 'CVVEH_NOMBRE'
            },

            {
                name: 'CVVEH_TIPO'
            },

            {
                name: 'CVVEH_ANIO_PRODUCCION'
            },

            {
                name: 'CVVEH_CHASIS'
            },

            {
                name: 'CVVEH_PLACA'
            },

            {
                name: 'CVVEH_FECHA_INGRESO'
            },

            {
                name: 'CVVEH_OBSERVACION'
            }
            ]),
            baseParams: {
                inCrper_codigo: '',
                inCvveh_tipo: 0,
                format: TypeFormat.JSON
            },
            listeners:{
                load:function(inStore, inRecords, inOptions){
                    cbxVehiculosActuales.store = strVehiculosActuales;
                    cbxVehiculoReemplazo.store = strVehiculosActuales;
                }
            }
        });      

        /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_solicitud_requisito por un campo especifico.
         */
        var strMotoresActuales = new Ext.data.Store({
            proxy: new Ext.ux.bsx.SoapProxy({
                url: URL_WS + "Cgg_veh_vehiculo_motor",
                method: "selectCGG_VEH_VEHICULO"
            }),
            reader: new Ext.data.JsonReader({}, [
            {
                name: 'CVVMT_CODIGO'
            },

            {
                name: 'CVVEH_CODIGO'
            },

            {
                name: 'CVMTR_CODIGO'
            },

            {
                name: 'CVMTR_SERIE'
            },

            {
                name: 'RESUMEN'
            },

            {
                name: 'CVMTR_ANIO_FABRICACION'
            },

            {
                name: 'CVMTR_ESTADO_FUNCIONAL'
            },

            {
                name: 'CVMTR_TONELAJE'
            },

            {
                name: 'CVMTR_INGRESO'
            },

            {
                name: 'CVMTR_FECHA_INGRESO'
            },

            {
                name: 'CVMTR_SALIO'
            },

            {
                name: 'CVMTR_FECHA_SALIDA'
            },

            {
                name: 'CVVMT_FECHA'
            }
            ]),
            baseParams: {
                inCvveh_codigo: '',
                format: TypeFormat.JSON
            },
            listeners:{
                load:function(inStore, inRecords, inOptions){
                    if(!cbxMotoresActuales.store){
                        cbxMotoresActuales.store = strMotoresActuales;
                        cbxMotoresActuales.setValue(undefined);
                    }
                    if(!cbxMotorReemplazo.store)
                        cbxMotorReemplazo.store = strMotoresActuales;

                }
            }
        });


        /**
         * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
         */
        var txtCsctp_codigo = new Ext.form.TextField({
            id:'txtCsctp_codigo',
            name:'txtCsctp_codigo',
            fieldLabel :'Sct. productivo',
            anchor:'98%',
            readOnly:'true',
            allowBlank :false
        });
        /**
         * IDENTIFICATIVO UNICO DE REGISTRO DE SECTOR PRODUCTIVO
         */
        var btnCsctp_codigoCgg_veh_vehiculo = new Ext.Button({
            id:'btnCsctp_codigoCgg_veh_vehiculo',
            iconCls:'iconBuscar',
            listeners:{
                click:function(){
                    var tmpFLCgg_sector_productivo = new FrmListadoCgg_sector_productivo();
                    var objBusqueda = new DlgBusqueda(tmpFLCgg_sector_productivo.getStore(),tmpFLCgg_sector_productivo.getColumnModel());
                    objBusqueda.closeHandler(function(){
                        var tmpRecord = objBusqueda.getSelectedRow();
                        if(tmpRecord){
                            tmpDatos['PRODUCTIVO'] = tmpRecord.get('CSCTP_CODIGO');
                            txtCsctp_codigo.setValue(tmpRecord.get('CSCTP_NOMBRE'));
                        }
                    });
                    objBusqueda.show();
                }
            }
        });
        /**
         * Ext.form.NumberField ANIO DE FABRICACION DEL MOTOR.
         */
        var numCvmtr_anio_fabricacion = new Ext.form.NumberField({
            id: 'numCvmtr_anio_fabricacion',
            name: 'numCvmtr_anio_fabricacion',
            fieldLabel: 'A\u00f1o de fab.',
            allowBlank: false,
            disabled: false,
            maxValue:CURRENT_DATE.format('Y'),
            minValue:SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF19')).get('CGCNF_VALOR_NUMERICO')
        });

        var pnlIngresoVehiculo = new Ext.Panel({
            title:'Nuevo - Caracter\u00edsticas',
            frame:true,
            layout:'form',
            items:[ {
                id:'pnlInfoNuevoVeh',
                xtype:'panel',
                layout:'form',
                items:[

                {
                    xtype:'panel',
                    layout:'column',
                    items:[

                    {
                        columnWidth:.92,
                        layout:'form',
                        items:[txtCvctg_codigo]
                    },

                    {
                        columnWidth:.08,
                        layout:'form',
                        items:[btnCvctg_codigoCgg_veh_vehiculo]
                    }]
                },

                {
                    xtype:'panel',
                    layout:'column',
                    items:[

                    {
                        columnWidth:.92,
                        layout:'form',
                        items:[txtCvsct_codigo]
                    },

                    {
                        columnWidth:.08,
                        layout:'form',
                        items:[btnCvsct_codigoCgg_veh_vehiculo]
                    }]
                },

                {
                    xtype:'panel',
                    layout:'column',
                    items:[

                    {
                        columnWidth:.92,
                        layout:'form',
                        items:[txtCsctp_codigo]
                    },

                    {
                        columnWidth:.08,
                        layout:'form',
                        items:[btnCsctp_codigoCgg_veh_vehiculo]
                    }]
                }]
            },

            {
                xtype:'panel',
                layout:'column',
                items:[

                {
                    columnWidth:.5,
                    layout:'form',
                    items:[cbxTrmVehCln]
                },

                {
                    columnWidth:.5,
                    layout:'form',
                    items:[numCvmtr_tonelaje]
                }]
            },

            {
                xtype:'panel',
                layout:'column',
                items:[

                {
                    columnWidth:.5,
                    layout:'form',
                    items:[cbxTrmVehCmb]
                },

                {
                    columnWidth:.5,
                    layout:'form',
                    items:[numCvmtr_anio_fabricacion]
                }]
            },
            {
                xtype:'panel',
                id:'pnlMotorReemplazo',
                layout:'form',
                items:[cbxMotorReemplazo]
            },

            {
                xtype:'panel',
                id:'pnlVehiculoReemplazo',
                layout:'form',
                items:[cbxVehiculoReemplazo]
            }
            ]
        });
        /**
         * Ext.form.NumberField TIPO DE VEHICULO
         * 0 - TERRESTRE
         * 1 - MARITIMO
         * 2 - AEREO
         */
        var cbxTramiteTipoVehiculo = new Ext.form.ComboBox({
            id:'cbxTramiteTipoVehiculo',
            fieldLabel :'Grupo',
            typeAhead: true,
            triggerAction: 'all',
            lazyRender:true,
            forceSelection:true,
            editable:false,
            mode: 'local',
            anchor:'98%',
            value:0,
            submitValue:false,
            emptyText:'Seleccione el grupo ...',
            store:dsTipoVehiculo,
            listeners:{
                select:function(inSource, inRecord, inIndex){
                    tmpTipoVehiculo = cbxTramiteTipoVehiculo.getValue();
                    if(cbxTramiteVehiculo.getValue() == 0){
                        strVehiculosActuales.baseParams.inCvveh_tipo = inIndex;
                        strVehiculosActuales.reload();
                    }
                }
            }
        });

        var cbxAccionVehiculo = new Ext.form.ComboBox({
            id:'cbxAccionVehiculo',
            fieldLabel :'Tipo',            
            triggerAction: 'all',
            editable:false,
            lazyRender:true,
            mode: 'local',
            anchor:'98%',
            submitValue:false,
            emptyText:'Seleccione el tipo ...',
            store:dsTipoAccionVehiculo,
            listeners:{
                select:function(inSource, inRecord, inIndex){
                    if(inIndex == 0){
                        if(cbxTramiteVehiculo.getValue() == 0)
                            tmpVehiculo.VEHICULO = 'KEYGEN';
                        if(cbxTramiteVehiculo.getValue() == 1)
                            tmpVehiculo.MOTOR = 'KEYGEN';
                    }else if(inIndex == 2){
                        tmpVehiculo.VEHICULO = null;
                        tmpVehiculo.MOTOR = null;
                    }
                    
                    tmpAccionVehiculo = cbxAccionVehiculo.getValue();
                    Ext.getCmp('pnlVehExistente').setVisible(
                        tmpTipoTramite == 1 && (tmpAccionVehiculo == 1 || tmpAccionVehiculo == 0)||
                        tmpTipoTramite == 0 && (tmpAccionVehiculo == 1) );
                    
                    Ext.getCmp('pnlVehExistenteLibre').setVisible(                        
                        tmpTipoTramite == 0 && tmpAccionVehiculo == 2 );

                    Ext.getCmp('pnlMotExistente').setVisible(tmpAccionVehiculo == 1 &&
                        tmpTipoTramite == 1
                        );
                    tpVehiculosTipos.setVisible(tmpAccionVehiculo == 0);
                    Ext.getCmp('pnlInfoNuevoVeh').setVisible(tmpAccionVehiculo == 0 && tmpTipoTramite == 0);

                    Ext.getCmp('pnlVehiculoReemplazo').setVisible(cbxAccionVehiculo.getValue() == 0 && tmpTipoTramite == 0 );
                    Ext.getCmp('pnlMotorReemplazo').setVisible(cbxAccionVehiculo.getValue() == 0 && tmpTipoTramite == 1 );

                    if(inIndex==2){
                        Ext.MsgPopup.msg(tituloCgg_res_tramite, 'Esta opci\u00f3n es utilizada bajo su responsabilidad!.', MsgPopup.WARNING);
                    }

                    if(cbxMotorReemplazo.store)
                        cbxMotorReemplazo.reset();
                    if(cbxVehiculoReemplazo.store)
                        cbxVehiculoReemplazo.reset();
                    tmpVehiculoReemplazo.VEHICULO = null;
                    tmpVehiculoReemplazo.MOTOR = null;
                }
            }
        });

        var cbxTramiteVehiculo = new Ext.form.ComboBox({
            id:'cbxTramiteVehiculo',
            fieldLabel :'Tramite para',
            typeAhead: true,
            triggerAction: 'all',
            lazyRender:true,
            forceSelection:true,
            editable:false,
            submitValue:false,
            mode: 'local',
            value:0,
            anchor:'98%',
            emptyText:'Seleccione el tipo de tramite ...',
            store:dsTipoTramiteVehiculo,
            listeners:{
                select:function(inSource, inRecord, inIndex){
                    if(inIndex == 0)
                        tmpVehiculo.MOTOR = null;
                    cbxTramiteTipoVehiculo.setDisabled(inIndex != 0);
                    tmpTipoTramite = cbxTramiteVehiculo.getValue();
                    cbxAccionVehiculo.fireEvent('select');
                }
            }
        });

        var tpVehiculosTipos = new Ext.TabPanel({
            activeTab:0,
            height:200,
            hidden:true,
            layoutOnTabChange:true,
            items:[pnlIngresoVehiculo]
        });

        var pnlTramiteVehiculo = new Ext.Panel({
            id: 'pnlTramiteVehiculo',
            title: 'Vehiculos',
            layout: 'form',
            disabled:true,
            frame:true,
            items: [{
                xtype: 'panel',
                layout: 'column',
                items: [

                {
                    columnWidth: .3,
                    layout: 'form',
                    items: [cbxTramiteVehiculo]
                },

                {
                    columnWidth: .3,
                    layout: 'form',
                    items: [cbxTramiteTipoVehiculo]
                },

                {
                    columnWidth: .4,
                    layout: 'form',
                    items: [cbxAccionVehiculo]
                }]
            },

            {
                id:'pnlVehExistente',
                xtype:'panel',
                hidden:true,
                layout:'form',
                items:[cbxVehiculosActuales]
            },
            {
                id:'pnlVehExistenteLibre',
                xtype:'panel',
                hidden:true,
                layout:'form',
                items:[{
                    columnWidth: .5,
                    items: [{
                        xtype: 'panel',
                        id:'pnlVehExisteLibre',
                        layout: 'column',
                        items: [{
                            columnWidth: .93,
                            layout: 'form',
                            items: [txtCvveh_codigo1]
                        },{
                            columnWidth: .07,
                            layout: 'form',
                            items: [btnCvveh_codigo1]
                        }]
                    }]
                }]
            },
            {
                id:'pnlMotExistente',
                xtype:'panel',
                hidden:true,
                layout:'form',
                items:[cbxMotoresActuales]
            },
            tpVehiculosTipos]
        });

        tituloCgg_res_tramite = 'Registro de tr\u00E1mites de veh\u00edculos'; 
        descCgg_res_tramite = 'El formulario permite establecer informaci\u00f3n de los tr\u00E1mites de veh\u00edculos.';
        winFrmCgg_res_tramite.setTitle(tituloCgg_res_tramite);
        winFrmCgg_res_tramite.getTopToolbar().html = String.format('<div class="fondoTitulo"><div class="logoTitulo"><div class="lblTitulo">{0}</div><div class="lblDescripcion">{1}</div></div></div>', tituloCgg_res_tramite, descCgg_res_tramite);

        tpFrmCgg_res_tramite.insert(0, pnlTramiteVehiculo);
        Ext.getCmp('pnlTrmComRadial').setVisible(false);
        Ext.getCmp('pnlTrmActividad').setVisible(false);
        pnlFrmCgg_res_tramite1Norte2.setTitle('Solicitante');
        txtCrper_codigo.fieldLabel = 'Residente';
        pnlFrmCgg_res_tramite1Norte.setHeight(220);
        tpFrmCgg_res_tramite.setActiveTab(0);
    }

    /**
     * Funcion. Crea un Objeto JSON con la informacion de vehiculo.
     * @return string
     */
    function crearJSONVehiculo(){
        try{      
        
        if(!isVehiculo)
            return '';
        if(Ext.getCmp('cbxAccionVehiculo').getValue()==2)
            return '';
        
        var tmpJSONVehiculo = '{';
        tmpJSONVehiculo += 'ACCION:"'+tmpAccionVehiculo+'",';
        tmpJSONVehiculo += 'TIPO:"'+tmpTipoTramite+'",';
        tmpJSONVehiculo += 'VEHICULO:"'+tmpTipoVehiculo+'",';
        tmpJSONVehiculo += 'FABRICACION:"'+numCvmtr_anio_fabricacion.getValue()+'",';
        tmpJSONVehiculo += 'CVCMB_CODIGO:"'+tmpDatos['COMBUSTIBLE']+'",';
        tmpJSONVehiculo += 'CVCLN_CODIGO:"'+tmpDatos['CILINDRAJE']+'",';
        tmpJSONVehiculo += 'CVMTR_TONELAJE:"'+numCvmtr_tonelaje.getValue()+'"';
        if(txtCvctg_codigo.getValue())
            tmpJSONVehiculo += ',CVCTG_CODIGO:"'+tmpDatos['CATEGORIA']+'"';
        if(txtCvsct_codigo.getValue())
            tmpJSONVehiculo += ',CVSCT_CODIGO:"'+tmpDatos['SECTOR']+'"';
        if(txtCsctp_codigo.getValue())
            tmpJSONVehiculo += ',CSCTP_CODIGO:"'+tmpDatos['PRODUCTIVO']+'"';
        tmpJSONVehiculo +='}';
        }catch(inErr){
            alert(inErr);            
        }
        return tmpJSONVehiculo;
    }

    /**
     *Habilita los paneles principales del tramite.
     *@param inFlag true|false.
     */
    function habilitarTramite(inFlag){
        pnlFrmCgg_res_tramite1Norte2.setDisabled(!inFlag);
        //tpFrmCgg_res_tramite.setDisabled(!inFlag);
        Ext.getCmp('pnlTpFrmCgg_res_tramite21').setDisabled(!inFlag);
        Ext.getCmp('pnlTpFrmCgg_res_tramite23').setDisabled(!inFlag);
        //Ext.getCmp('pnlTpFrmCgg_res_tramite24').setDisabled(!inFlag);
        Ext.getCmp('pnlTpFrmCgg_res_tramite22').setDisabled(!inFlag);
    }

    /**
     *Limpia los componentes de tramite y las variables del mismo.
     */
    function limpiarTramite(){
        txtCrper_codigo.setValue('');
        txtCgg_crper_codigo.setValue('');
        spfCrtra_folio.setValue(1);
        txtCrtst_codigo.setValue('');
        txtCrtra_actividad_residencia.setValue('');
        txtCrtra_observacion.setValue('');
        txtCrpjr_codigo.setValue('');
        txtCrtra_comunicado_radial.setValue('');

        tmpAuspiciante = null;
        rPersonaJuridicaRazonSocial = new rFilaPersonaJuridicaRazonSocial({
            CRPJR_CODIGO: '',
            CRPJR_RAZON_SOCIAL: ''
        });
        tmpBeneficiario = null;
        tmpTipoSolicitud = null;
        tmpCargo = null;

        txtCrpro_codigo.setValue('');

        sCgg_res_fase.reload({
            params: {
                inCrpro_codigo:null,
                inCisla_codigo:null,
                format: TypeFormat.JSON
            }
        });

        gsCgg_res_solicitud_requisito.reload({
            params: {
                inCrtst_codigo: null,
                inCrtra_codigo: null,
                format: TypeFormat.JSON
            }
        });

        sCgg_res_garantia_solicitud.reload({
            params: {
                inCrtst_codigo: null,
                format: TypeFormat.JSON
            }
        });

        tmpDepositoGarantia = null;
        fsSeleccionaGarantia.expand(false);

        cbxCaducidadTramite.setValue(0);
    }

    /**
     *Establece si un tramite es abierto desde el historial de tramite.
     *@param inHistorico Verdadero/false.
     */
    this.setHistorico = function(inHistorico){
        esHistorico = inHistorico;
    }
}

/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_tramite desde una instancia.
 */
FrmCgg_res_tramite.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_tramite desde una instancia.
 */
FrmCgg_res_tramite.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_tramite,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_tramite.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close', inFunctionHandler);
}

/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_tramite desde una instancia.
 */
FrmCgg_res_tramite.prototype.loadData = function(){
    this.loadData();
}

FrmCgg_res_tramite.prototype.setDisabled = function(inFlag){
    this.setDisabled(inFlag);
}

FrmCgg_res_tramite.prototype.setHistorico = function(inHistorico){
    this.setHistorico(inHistorico);
}