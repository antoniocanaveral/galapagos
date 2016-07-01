/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_seguimiento.
 * @param {Ext.data.Record} INRECORD_CGG_RES_SEGUIMIENTO Registro de datos de la tabla Cgg_res_seguimiento.
 * @param inDesktop Escritorio
 * @constructor
 * @base FrmListadoCgg_res_seguimiento
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_seguimiento(INRECORD_CGG_RES_SEGUIMIENTO, inDesktop) {    
    var inRecordCgg_res_seguimiento = INRECORD_CGG_RES_SEGUIMIENTO;    
    var tituloCgg_res_seguimiento = 'Seguimiento';
    var tituloCgg_res_informe_seguimiento = 'Informe seguimiento';
    var descCgg_res_seguimiento = 'El formulario permite administrar informaci\u00f3n del seguimiento';    
    var tmpFase = null;
    var tmpFaseActual = null;
    var tmpPersonaJuridica = null;
    var enableDelayRow = null;
    var numFase = 0;
    var crettCodigo = null;    
    var crresData = null;
    var isVehiculo = false;
    var necesitaFechaIngreso = false;
    var crtstRegistro = null;
    var esHistorico = false;
    var crtraData = null;
	var tmpUsuarioConectado = new UserSession().getUserName();

    var datosTramite = {
        CRTRA_ANIO:'2010',
        CRTRA_NUMERO:'',
        CRPER_BENEFICIARIO:'',
		CGG_CRPER_NUM_DOC_IDENTIFIC:'',
        CRPER_AUSPICIANTE:'',
        CRTRA_FECHA_RECEPCION:'',
        CRPJR_RAZON_SOCIAL:'',
        CISLA_NOMBRE:'',
        CRTRA_OBSERVACION:'',
        CRTRA_COMUNICADO_RADIAL:'',
        CRTRA_CODIGO:'',
        CRTRA_DIAS_PERMANENCIA:0,
        CRTRA_ACTIVIDAD_RESIDENCIA:'',
        CRTRA_FOLIO:0,
        CRPER_CODIGO:'',
        CRFAS_NOMBRE:'',
        CRTRA_MOTIVO:''
    };

    var datosSeguimiento = {
        CRSEG_NUMERO:'0',
        CRSEG_OBSERVACION:'0',
        CRSEG_FECHA_RECEPCION:'0',
        CRFAS_NOMBRE:'0',
        CUSU_CODIGO:'0',
        CRSEG_TIPO_ACTIVIDAD:'0',
        CRSEG_FECHA_DESPACHO:'0',
        CRSEG_DESCRIPCION:'0',
        CUSUNOMBRES:'0',
        CUSU_NOMBRES:'0'

    };
    var tplTramite = new Ext.Template(
            '<table id="ver-zebra2" width="100%" border="0"> <colgroup> <col class="vzebra-odd-strong"/> <col class="vzebra-even-tight"/> <col class="vzebra-odd-strong"/> <col class="vzebra-even-tight"/> </colgroup> <tr> <td width=80> N&uacute;mero:</td> <td width="33%"> {CRTRA_ANIO}-{CRTRA_NUMERO}</td> <td width=80> Tipo solicitud:</td> <td width="33%"> {CRTST_DESCRIPCION:ellipsis(25)}</td> </tr> <tr> <td> <div id="idDivBeneficiario">{ETIQUETA}</div></td> <td> {CRPER_BENEFICIARIO:ellipsis(25)}<br>{CGG_CRPER_NUM_DOC_IDENTIFIC}<a id ="lnkPersona" href="#" onClick="abrirPersona(\'{CRPER_CODIGO}\')"> Ver mas...</a></td> <td> Isla:</td> <td> {CISLA_NOMBRE}</td> </tr> <tr> <td> Auspiciante:</td> <td> {CRPER_AUSPICIANTE:ellipsis(25)}</td> <td> Recepci&oacute;n:</td> <td> {CRTRA_FECHA_RECEPCION}</td> </tr> <tr> <td> Pers. jur&iacute;dica:</td> <td> {CRPJR_RAZON_SOCIAL}</td> <td> N. folios:</td> <td> {CRTRA_FOLIO}</td> </tr> <tr> <td> Observaci&oacute;n:</td> <td> {CRTRA_OBSERVACION:ellipsis(30)}</td> <td> Comunicado(R):</td> <td> {CRTRA_COMUNICADO_RADIAL}</td> </tr> <tr> <td>Actividad:</td> <td>{CRTRA_ACTIVIDAD_RESIDENCIA}</td> <td>Permanencia:</td> <td>{CRTRA_DIAS_PERMANENCIA}</td> </tr> <tr> <td>Fase:</td> <td><span class="textoResultado">{CRFAS_NOMBRE:ellipsis(30)}</span></td> <td>Recalificaci\u00f3n</td> <td>{CRTRA_MOTIVO}</td> </tr> <tr> <td></td> <td></td> <td></td> <td> <a id ="lnkSeguimiento" href="#" onClick="abrirTramite(\'{CRTRA_CODIGO}\')"> Ver mas...</a> </td> </tr> </table>'
            );

    var tplSeguimientoFase = new Ext.Template(
            '<table id="ver-zebra2" width="100%" border="0"> <colgroup> <col class="vzebra-odd-strong"/> <col class="vzebra-even-tight"/> <col class="vzebra-odd-strong"/> <col class="vzebra-even-tight"/> <col class="vzebra-odd-strong"/> <col class="vzebra-even-tight"/> </colgroup> <tr> <td width="80px"> Seguimiento: </td> <td width="50%">{CRSEG_NUMERO}</td> <td width="80px"> Observaci&oacute;n: </td> <td width="50%">{CRSEG_OBSERVACION}</td> <td width="80px"> Recepci&oacute;n: </td> <td width="25%">{CRSEG_FECHA_RECEPCION}</td> </tr> <tr> <td> Fase: </td> <td><span class="textoResultado">{CRFAS_NOMBRE:ellipsis(30)}</span></td> <td> Usuario: </td> <td>{CUSU_NOMBRES}</td> <td> Despacho: </td> <td>{CRSEG_FECHA_DESPACHO}</td> </tr> <tr> <td> Actividad: </td> <td>{CRSEG_TIPO_ACTIVIDAD}</td> <td> Descripci&oacute;n: </td> <td>{CRSEG_DESCRIPCION}</td> <td></td> <td><a href="#">Ver mas...</a></td> </tr> </table>'
            );

    var rNovedadNotificacion = new Ext.data.Record.create([
    {
        name:'CRNOV_CODIGO'
    },

    {
        name:'CRSEG_CODIGO'
    },

    {
        name:'CRNOV_FECHA_REGISTRO'
    },

    {
        name:'CRNOV_DESCRIPCION'
    },

    {
        name:'CRNOV_TIPO'
    },

    {
        name:'CRNOV_USUARIO_INSERT'
    },

    {
        name:'CRNOV_USUARIO_UPDATE'
    },

    {
        name:'CRFAS_CODIGO'
    },
	{
        name:'CRFAS_NOMBRE'
    }
    ]);
    
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO
     */
    var txtCrseg_codigo = new Ext.form.TextField({
        id:'txtCrseg_codigo',
        name:'txtCrseg_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO SEGUIMIENTO RECURSIVO
     */
    var txtCgg_crseg_codigo = new Ext.form.TextField({
        id:'txtCgg_crseg_codigo',
        name:'txtCgg_crseg_codigo',
        fieldLabel :'Crseg codigo',
        anchor:'98%',
        //allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO
     */
    var txtCrtra_codigo = new Ext.form.TextField({
        id:'txtCrtra_codigo',
        name:'txtCrtra_codigo',
        fieldLabel :'Tr\u00E1mite',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE FASE DE SEGUIMIENTO
     */
    var txtCrfas_codigo = new Ext.form.TextField({
        id:'txtCrfas_codigo',
        name:'txtCrfas_codigo',
        fieldLabel :'Fase',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE FASE ANTERIOR
     */
    var txtCgg_crfas_codigo = new Ext.form.TextField({
        id:'txtCgg_crfas_codigo',
        name:'txtCgg_crfas_codigo',
        fieldLabel :'Fase anterior',
        anchor:'98%',
        //allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE USUARIO
     */
    var txtCusu_codigo = new Ext.form.TextField({
        id:'txtCusu_codigo',
        name:'txtCusu_codigo',
        fieldLabel :'Usuario',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * Ext.form.TextField DESCRIPCION DEL SEGUIMIENTO
     */
    var txtCrseg_descripcion = new Ext.form.TextField({
        id:'txtCrseg_descripcion',
        name:'txtCrseg_descripcion',
        fieldLabel :'Descripci\u00F3n',
        anchor:'98%',
        allowBlank :false,
        maxLength :20
    });
    /**
     * Ext.form.NumberField VALORES QUE PUEDE TOMAR UN SEGUIMIENTO
     0 - RECIBIDO
     1 - REVISADO
     2 - DISTRIBUIDO
     3 - PENDIENTE
     4 - DESPACHADO
     5 - FINALIZADO
     6 - INHABILITADO
     */
    var numCrseg_estado_atencion = new Ext.form.NumberField({
        id:'numCrseg_estado_atencion',
        nname:'numCrseg_estado_atencion',
        fieldLabel :'Estado atenci\u00F3n',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.TextArea DATOS DE INTERES APUNTADOS EN EL SEGUIMIENTO  - HISTORIAL FORMATO JSON
     */
    var txtCrseg_observacion = new Ext.form.TextArea({
        id:'txtCrseg_observacion',
        name:'txtCrseg_observacion',
        fieldLabel :'Observaci\u00F3n',
        width:'90%',
        allowBlank :false
    });

    /**
     * Ext.form.NumberField VALORES FINALES RESULTADO DEL SEGUIMIENTO
     -1 - INDETERMINADO
     0 - NEGADO
     1 - APROBADO

     */
    var numCrseg_tipo_respuesta = new Ext.form.NumberField({
        id:'numCrseg_tipo_respuesta',
        nname:'numCrseg_tipo_respuesta',
        fieldLabel :'Tipo respuesta',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.TextField ACTIVIDAD SUGERIDA EN EL SEGUIMIENTO ANTERIOR
     */
    var txtCrseg_tipo_actividad = new Ext.form.TextField({
        id:'txtCrseg_tipo_actividad',
        name:'txtCrseg_tipo_actividad',
        fieldLabel :'Tipo actividad',
        anchor:'98%',
        allowBlank :false,
        maxLength :20
    });
    /**
     * Ext.form.DateField FECHA DE RECEPCION DEL SEGUIMIENTO
     */
    var dtCrseg_fecha_recepcion = new Ext.form.DateField({
        id:'dtCrseg_fecha_recepcion',
        name:'dtCrseg_fecha_recepcion',
        fieldLabel :'Fecha recepci\u00F3n',
        allowBlank :false,
        value:new Date()
    });
    /**
     * Ext.form.DateField FECHA DE REVISION DEL SEGUIMIENTO
     */
    var dtCrseg_fecha_revision = new Ext.form.DateField({
        id:'dtCrseg_fecha_revision',
        name:'dtCrseg_fecha_revision',
        fieldLabel :'Fecha revisi\u00F3n',
        allowBlank :false,
        value:new Date()
    });
    /**
     * Ext.form.DateField FECHA DE ATENCION Y DESPACHO DEL TRAMITE GENERANDO UN NUEVO SEGUIMIENTO
     */
    var dtCrseg_fecha_despacho = new Ext.form.DateField({
        id:'dtCrseg_fecha_despacho',
        name:'dtCrseg_fecha_despacho',
        fieldLabel :'Fecha despacho',
        allowBlank :false,
        value:new Date()
    });
    /**
     * Ext.form.NumberField ESTADO DE LAS RESPUESTAS DE LOS NODOS HIJOS
     -1 - SIN HIJOS
     0 - SIN RESPUESTAS
     1 - RESPUESTA PARCIAL
     2 - RESPUESTA TOTAL
     */
    var numCrseg_estado_hijo = new Ext.form.NumberField({
        id:'numCrseg_estado_hijo',
        nname:'numCrseg_estado_hijo',
        fieldLabel :'Estado hijo',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.DateField FECHA DE REAPERTURA DEL SEGUIMIENTO
     */
    var dtCrseg_fecha_reapertura = new Ext.form.DateField({
        id:'dtCrseg_fecha_reapertura',
        name:'dtCrseg_fecha_reapertura',
        fieldLabel :'Fecha reapertura',
        allowBlank :false,
        format :'d/m/Y',
        value:new Date()
    });
    /**
     * Ext.form.NumberField NUMERO DE VECES QUE SE HA REVISADO EL SEGUIMIENTO
     */
    var numCrseg_veces_revision = new Ext.form.NumberField({
        id:'numCrseg_veces_revision',
        name:'numCrseg_veces_revision',
        fieldLabel :'Veces revisi\u00F3n',
        allowBlank :false,
        disabled :false
    });
    /**
     * Ext.form.NumberField NUMERO ASIGNADO AL SEGUIMIENTO
     */
    var numCrseg_numero = new Ext.form.NumberField({
        id:'numCrseg_numero',
        name:'numCrseg_numero',
        fieldLabel :'N\u00FAmero',
        allowBlank :false,
        disabled :false
    });

    /**
     * Boton que permite despachar el seguimiento actual hacia hijos o mas seguimientos.
     */
    var btnDistribuirCgg_res_seguimiento = new Ext.Button({
        id:'btnDistribuirCgg_res_seguimiento',
        text:'Distribuir',
        iconCls:'iconDistribuir',
        tooltip:'Envia el seguimiento actual a una sub fase para la atenci\u00F3n',
        listeners:{
            click:function() {
                var objSeleccionSeguimiento = new DlgSeleccionDistribucion(inRecordCgg_res_seguimiento.get('CRPRO_CODIGO'), inRecordCgg_res_seguimiento.get('CRFAS_CODIGO'));
                objSeleccionSeguimiento.closeHandler(function() {
                    if (objSeleccionSeguimiento.getCrfasSeguimiento() !== null) {
                        var scpDejarPendiente = new SOAPClientParameters();
                        scpDejarPendiente.add('inCrseg_codigo', inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'));
                        scpDejarPendiente.add('inTipo_atencion', TypeEstadoAtencion.DISTRIBUIDO);
                        scpDejarPendiente.add('inCrseg_seguimiento', objSeleccionSeguimiento.getCrfasSeguimiento());
                        scpDejarPendiente.add('inCrseg_tipo_respuesta', TypeRespuestaSeguimiento.INDETERMINADO);
                        SOAPClient.invoke(URL_WS + 'Cgg_res_seguimiento', 'enviarSeguimiento', scpDejarPendiente, true, function(inServiceResponse) {
                            inServiceResponse = Ext.util.JSON.decode(inServiceResponse);
                            if (inServiceResponse.success == true) {
                                 var tmpMsg = "";
                                    if(inServiceResponse.msg.trim().length >=1){
                                        tmpMsg = "Mensaje: "+inServiceResponse.msg;
                                        Ext.Msg.show({
                                            title:tituloCgg_res_seguimiento,
                                            msg:'El tr\u00e1mite ' + inRecordCgg_res_seguimiento.get('CRTRA_ANIO') + '-' + inRecordCgg_res_seguimiento.get('CRTRA_NUMERO') + ' ha sido despachado!<br><b>'+tmpMsg+'</b>',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });
                                    }else{
                                        Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El tr\u00e1mite ' + inRecordCgg_res_seguimiento.get('CRTRA_ANIO') + '-' + inRecordCgg_res_seguimiento.get('CRTRA_NUMERO') + ' ha sido despachado!', MsgPopup.INFO);
                                    }
                                winFrmCgg_res_seguimiento.close();
                            } else {
                                Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El tr\u00e1mite ' + inRecordCgg_res_seguimiento.get('CRTRA_ANIO') + '-' + inRecordCgg_res_seguimiento.get('CRTRA_NUMERO') + ' no ha sido despachado!<br>Error:' + inServiceResponse, MsgPopup.WARNING);
                            }
                        });
                    }
                });
                objSeleccionSeguimiento.loadData();
                objSeleccionSeguimiento.show();
            }
        }
    });

    /**
     *Realiza el proceso de seguimiento de un tramite.
     *@param inTipoRespuesta Tipo de respesta que le dio el usuario actual al seguimiento en curso.
     */
    function enviarSeguimiento(inTipoRespuesta){        
        if(validarRequisitoFase()==true){
            if(tieneSubfase()==true){
                if (esFaseHija() == true){
                    var scpDespacharSeguimientoHijo = new SOAPClientParameters();
                    scpDespacharSeguimientoHijo.add('inCrseg_codigo', inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'));
                    scpDespacharSeguimientoHijo.add('inCrseg_tipo_respuesta', inTipoRespuesta);
                    SOAPClient.invoke(URL_WS + 'Cgg_res_seguimiento', 'despacharSeguimientoHijo', scpDespacharSeguimientoHijo, true, function(inServiceResponse) {                        
                        if (inServiceResponse == 'true') {
                            Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El tr\u00e1mite ' + inRecordCgg_res_seguimiento.get('CRTRA_ANIO') + '-' + inRecordCgg_res_seguimiento.get('CRTRA_NUMERO') + ' ha sido despachado!', MsgPopup.INFO);
                            winFrmCgg_res_seguimiento.close();
                        } else {
                            Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El tr\u00e1mite ' + inRecordCgg_res_seguimiento.get('CRTRA_ANIO') + '-' + inRecordCgg_res_seguimiento.get('CRTRA_NUMERO') + ' no ha sido despachado!<br>Error:' + inServiceResponse, MsgPopup.WARNING);
                        }
                    });
                }else {
                    var faseFinal = esFaseFinal();
                    if (faseFinal && confirm('Esta es la etapa final del tr\u00E1mite.\nDesea continuar?')){
                        var scpAprobarSeguimiento = new SOAPClientParameters();
                        scpAprobarSeguimiento.add('inCrseg_codigo', inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'));
                        scpAprobarSeguimiento.add('inTipo_atencion', TypeEstadoAtencion.DESPACHADO);
                        scpAprobarSeguimiento.add('inCrseg_seguimiento', null);
                        scpAprobarSeguimiento.add('inCrseg_tipo_respuesta', inTipoRespuesta);
                        SOAPClient.invoke(URL_WS + 'Cgg_res_seguimiento', 'enviarSeguimiento', scpAprobarSeguimiento, true, function(inServiceResponse) {
                            try{
                                inServiceResponse = Ext.util.JSON.decode(inServiceResponse);
                                if (inServiceResponse.success == true) {
                                    var tmpMsg = "";
                                    if(inServiceResponse.msg.trim().length >=1){
                                        tmpMsg = "Mensaje: "+inServiceResponse.msg;
                                        Ext.Msg.show({
                                            title:tituloCgg_res_seguimiento,
                                            msg:'El tr\u00e1mite ' + inRecordCgg_res_seguimiento.get('CRTRA_ANIO') + '-' + inRecordCgg_res_seguimiento.get('CRTRA_NUMERO') + ' ha sido despachado!<br><b>'+tmpMsg+'</b>',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });
                                    }else{
                                        Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El tr\u00e1mite ' + inRecordCgg_res_seguimiento.get('CRTRA_ANIO') + '-' + inRecordCgg_res_seguimiento.get('CRTRA_NUMERO') + ' ha sido despachado!', MsgPopup.INFO);
                                    }
                                    winFrmCgg_res_seguimiento.close();
                                } else {
                                    Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El tr\u00e1mite ' + inRecordCgg_res_seguimiento.get('CRTRA_ANIO') + '-' + inRecordCgg_res_seguimiento.get('CRTRA_NUMERO') + ' no ha sido despachado!<br>Error:' + inServiceResponse.msg, MsgPopup.WARNING);
                                }
                            }catch(inErr){
                                Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El tr\u00e1mite ' + inRecordCgg_res_seguimiento.get('CRTRA_ANIO') + '-' + inRecordCgg_res_seguimiento.get('CRTRA_NUMERO') + ' no ha sido despachado!<br>Error:' + inErr, MsgPopup.WARNING);
                            }
                        });
                    }
                    if (!faseFinal) {
                        var objSeleccionSeguimiento = new DlgSeleccionDespacho(inRecordCgg_res_seguimiento.get('CRPRO_CODIGO'));
                        objSeleccionSeguimiento.closeHandler(function() {
                            if (objSeleccionSeguimiento.getCrfasSeguimiento() !== null){
								seguimientoHandler(objSeleccionSeguimiento,inTipoRespuesta);
                            }
                        });
                        objSeleccionSeguimiento.setCrfasCodigo(inRecordCgg_res_seguimiento.get('CRFAS_CODIGO'));
                        objSeleccionSeguimiento.loadData();
                        objSeleccionSeguimiento.show();
                    }
                }
            }
        }else{
            Ext.Msg.show({
                title:tituloCgg_res_informe_seguimiento,
                msg: 'hay requisitos que no se han cumplido, verifiquelos por favor. ',
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.WARNING
            });
            pnlTabSeguimientoP3.activate('tpSeguimientoRequerimiento');
        }
    }

    function seguimientoHandler(inSeguimiento,inTipoRespuesta){
        var scpAprobarSeguimiento = new SOAPClientParameters();
        scpAprobarSeguimiento.add('inCrseg_codigo', inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'));
        scpAprobarSeguimiento.add('inTipo_atencion', TypeEstadoAtencion.DESPACHADO);
        scpAprobarSeguimiento.add('inCrseg_seguimiento', inSeguimiento.getCrfasSeguimiento());
        scpAprobarSeguimiento.add('inCrseg_tipo_respuesta', inTipoRespuesta);
        SOAPClient.invoke(URL_WS + 'Cgg_res_seguimiento', 'enviarSeguimiento', scpAprobarSeguimiento, true, function(inServiceResponse) {
            try{
                inServiceResponse = Ext.util.JSON.decode(inServiceResponse);
                if (inServiceResponse.success == true) {
                    var tmpMsg = "";
                    if(inServiceResponse.msg.trim().length >=1){
                        tmpMsg = "Mensaje: "+inServiceResponse.msg;
                        Ext.Msg.show({
                            title:tituloCgg_res_seguimiento,
                            msg:'El tr\u00e1mite ' + inRecordCgg_res_seguimiento.get('CRTRA_ANIO') + '-' + inRecordCgg_res_seguimiento.get('CRTRA_NUMERO') + ' ha sido despachado!<br><b>'+tmpMsg+'</b>',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });



                    }else{
                        Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El tr\u00e1mite ' + inRecordCgg_res_seguimiento.get('CRTRA_ANIO') + '-' + inRecordCgg_res_seguimiento.get('CRTRA_NUMERO') + ' ha sido despachado!', MsgPopup.INFO);
                    }
                    winFrmCgg_res_seguimiento.close();
                } else {
                    Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El tr\u00e1mite ' + inRecordCgg_res_seguimiento.get('CRTRA_ANIO') + '-' + inRecordCgg_res_seguimiento.get('CRTRA_NUMERO') + ' no ha sido despachado!<br>Error:' + inServiceResponse.msg, MsgPopup.WARNING);
                }
            }catch(inErr){
                Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El tr\u00e1mite ' + inRecordCgg_res_seguimiento.get('CRTRA_ANIO') + '-' + inRecordCgg_res_seguimiento.get('CRTRA_NUMERO') + ' no ha sido despachado!<br>Error:' + inErr, MsgPopup.WARNING);
            }

        });
    }

    /**
     * Boton que permite aprobar el seguimiento actual.
     */
    var btnAprobarCgg_res_seguimiento = new Ext.Button({
        id:'btnAprobarCgg_res_seguimiento',
        text:'Aprobar',
        iconCls:'iconAprobar',
        tooltip:'Aprueba el seguimiento actual',
        handler:function(){
            enviarSeguimiento(TypeRespuestaSeguimiento.APROBADO);
        }
    });

    /**
     * Boton que permite negar el seguimiento actual.
     */
    var btnNegarCgg_res_seguimiento = new Ext.Button({
        id:'btnNegarCgg_res_seguimiento',
        text:'Negar',
        iconCls:'iconNegar',
        tooltip:'Niega el seguimiento actual',
        handler:function(){
            enviarSeguimiento(TypeRespuestaSeguimiento.NEGADO);
        }
    });


//MO
    /**
     * Boton que permite adjuntar el documento correspondiente a la Resolución.
     */
    var btnResolucionCgg_res_seguimiento = new Ext.Button({
        id:'btnResolucionCgg_res_seguimiento',
        text:'Resoluci\u00f3n',
        iconCls:'iconGuardar',
        tooltip:'Adjuntar documento de Resoluci\u00f3n',
        handler:function(){
            // enviarSeguimiento(TypeRespuestaSeguimiento.APROBADO);
        }
    });
//

    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_seguimiento.
     */
    var btnCerrarCgg_res_seguimiento = new Ext.Button({
        id:'btnCerrarCgg_res_seguimiento',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerrar formulario',
        listeners:{
            click:function() {
                winFrmCgg_res_seguimiento.close();
            }
        }
    });

    //AC=>
    var btnAdjuntos = new Ext.ux.form.AlfrescoFM({
        id:'compAdjunto',   //(opcional)
        name:'compAdjunto', //(opcional)
        text: 'Adjuntos',    //(opcional -> Texto del botón)
        tableName: 'Cgg_res_tramite',
        validateRecordID:true,
        recordID : inRecordCgg_res_seguimiento.get('CRTRA_CODIGO'),
        filter: "crtst_codigo='"+inRecordCgg_res_seguimiento.get('CRTST_CODIGO')+"'"
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_informe.
     */
    var cmCgg_res_informe_seguimiento = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            dataIndex:'CRISE_NUMERO_INFORME',
            header:'N\u00FAmero',
            width:80,
            sortable:true
        },

        {
            dataIndex:'CRISE_FECHA_INFORME',
            header:'Fecha',
            width:80,
            sortable:true,
            renderer:truncDate
        },

        {
            dataIndex:'CRISE_ASUNTO_INFORME',
            header:'Asunto',
            width:130,
            sortable:true
        },

        {
            dataIndex:'CRISE_EXTRACTO_INFORME',
            header:'Extracto informe',
            width:500,
            sortable:true
        },

        {
            dataIndex:'CRFAS_NOMBRE',
            header:'Fase',
            width:100,
			sortable:true            
        },
        {
            dataIndex:'CRISE_USUARIO_INSERT',
            header:'Registrado por',
            width:100,
            sortable:true,
            hidden:true
        },

        {
            dataIndex:'CRISE_USUARIO_UPDATE',
            header:'Actualizado por',
            width:100,
            sortable:true,
            hidden:true
        }
        ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_informe por un campo especifico.
     */
    var gsCgg_res_informe_seguimiento = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_res_informe_seguimiento",
            method:"selectCGG_RES_SEGUIMIENTO"
        }),
        reader:new Ext.data.JsonReader({
            }, [
			{name:'CRISE_CODIGO'},
			{name:'CRSEG_CODIGO'},
			{name:'CRSEC_CODIGO'},
			{name:'CRISE_NUMERO_INFORME'},
			{name:'CRISE_FECHA_INFORME'},
			{name:'CRISE_ASUNTO_INFORME'},
			{name:'CRISE_EXTRACTO_INFORME'},
			{name:'CRISE_DESCRIPCION_ADJUNTO'},
			{name:'CRFAS_CODIGO'},
			{name:'CRFAS_NOMBRE'},
			{name:'CRISE_USUARIO_INSERT'},
			{name:'CRISE_USUARIO_UPDATE'}
        ]),
        baseParams:{
            inCrseg_codigo:inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'),
            format:TypeFormat.JSON
        },
        groupField:'CRFAS_NOMBRE'
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_informe en un formato tabular de filas y columnas.
     */
    var grdCgg_res_informe_seguimiento = new Ext.grid.GridPanel({
        cm:cmCgg_res_informe_seguimiento,
        store:gsCgg_res_informe_seguimiento,
        region:'center',
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Informes" : "informe"]})'
        }),
        plugins:[new Ext.ux.grid.AutoSizeColumns()],
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        tbar:[{
            iconCls:'iconNuevo',
            id:'btnAgregarInforme',
            tooltip:'Agregar informe',
            handler:function() {
                var objCgg_res_informe = new FrmCgg_res_informe('Insert', INRECORD_CGG_RES_SEGUIMIENTO.get('CRSEG_CODIGO'));
                objCgg_res_informe.closeHandler(function() {
                    gsCgg_res_informe_seguimiento.reload();
                    gsCgg_res_adjunto.reload();
                });
                objCgg_res_informe.show();
            }
        },
        {
            id:'btnEliminarInforme',
			disabled:true,
            iconCls:'iconEliminar',
            tooltip:'Eliminar informe',
            listeners:{
                click:function() {
                    var rInformeSeguimiento = grdCgg_res_informe_seguimiento.getSelectionModel().getSelected();
                    if (rInformeSeguimiento !== null && rInformeSeguimiento !== undefined) {
                        if(rInformeSeguimiento.get('CRISE_USUARIO_INSERT') == tmpUsuarioConectado && rInformeSeguimiento.get('CRSEG_CODIGO') == inRecordCgg_res_seguimiento.get('CRSEG_CODIGO')){
                            Ext.Msg.show({
                                title:tituloCgg_res_seguimiento,
                                msg:'Est\u00e1 seguro de eliminar el informe?',
                                buttons: Ext.Msg.YESNO,
                                fn:function(inBtn) {
                                    if (inBtn == 'yes') {
                                        var scpEliminarInforme = new SOAPClientParameters();
                                        scpEliminarInforme.add('inCrise_codigo', rInformeSeguimiento.get('CRISE_CODIGO'));
                                        SOAPClient.invoke(URL_WS + "Cgg_res_informe_seguimiento", 'delete', scpEliminarInforme, true, function(inServiceResponse) {
                                            if (inServiceResponse == 'true') {
                                                Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El informe ha sido eliminado.', MsgPopup.INFO);
                                                gsCgg_res_informe_seguimiento.reload();
                                            } else {
                                                Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El informe ha sido eliminado.\nError:' + inServiceResponse, MsgPopup.WARNING);
                                            }
                                        })

                                    }
                                },
                                icon: Ext.MessageBox.QUESTION
                            });
                        }else{
                            Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El informe no puede ser modificado.', MsgPopup.INFO);
                        }
                    }
                }
            }
        }
        ]
    });
	grdCgg_res_informe_seguimiento.getSelectionModel().on("selectionchange",function(sm){
		if (sm.hasSelection()){			
			var rInforme=sm.getSelected();
			if(rInforme.get('CRISE_USUARIO_INSERT') == tmpUsuarioConectado && rInforme.get('CRSEG_CODIGO') == inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'))
				Ext.getCmp('btnEliminarInforme').setDisabled(false);
			else
					Ext.getCmp('btnEliminarInforme').setDisabled(true);				
		}
	});
    gsCgg_res_informe_seguimiento.load();

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_novedad_notificacion.
     */
    var cmCgg_res_novedad_notificacion = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),      
        {
            dataIndex:'CRNOV_DESCRIPCION',
            header:'Mensaje',
            width:200,
            sortable:true
        },
        {
            dataIndex:'CRNOV_FECHA_REGISTRO',
            header:'Fecha',
            width:100,
            sortable:true,
            renderer:truncDate
        },
        {
            dataIndex:'CRNOV_TIPO',
            header:'Tipo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:true
        },
        {
            dataIndex:'CRNOV_USUARIO_INSERT',
            header:'Registrado',
            width:100,
            hidden:true
        },
        {
            dataIndex:'CRNOV_USUARIO_UPDATE',
            header:'Actualizado',
            width:100,
            hidden:true
        },
		{
            dataIndex:'CRFAS_NOMBRE',
            header:'Fase',
            width:100,
            hidden:true
        }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_novedad_notificacion por un campo especifico.
     */
    var gsCgg_res_novedad_notificacion = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_res_novedad_notificacion",
            method:"selectCGG_RES_SEGUIMIENTO"
        }),
        reader:new Ext.data.JsonReader({}, rNovedadNotificacion),
        baseParams:{
            inCrseg_codigo:inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'),
            format:"JSON"
        },
        groupField:'CRFAS_NOMBRE'
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_novedad_notificacion en un formato tabular de filas y columnas.
     */
    var grdCgg_res_novedad_notificacion = new Ext.grid.GridPanel({
        cm:cmCgg_res_novedad_notificacion,
        store:gsCgg_res_novedad_notificacion,
        region:'center',
        //frame:true,
        width:'40%',
        anchor:'40%',
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Comentarios/sumillas" : "Comentario/sumilla"]})'
        }),
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        plugins:[new Ext.ux.grid.AutoSizeColumns()],
        tbar:['Comentarios/sumillas',{
            id:'btnAgregarNovedad',
            iconCls:'iconNuevo',
            tooltip:'Agrega un nuevo comentario/sumilla',
            handler:function() {
                Ext.Msg.show({
                    title:tituloCgg_res_seguimiento,
                    msg:'Ingrese su comentario/sumilla/observaci\u00f3n',
                    buttons: Ext.Msg.OK,
                    fn: function(inButtonId, inText) {
                        if (inButtonId == 'ok') {
                            if (inText.trim().length >= 1) {

                                var rNuevaNovedad = new rNovedadNotificacion({
                                    CRNOV_CODIGO:'KEYGEN',
                                    CRSEG_CODIGO:inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'),
                                    CRNOV_FECHA_REGISTRO:'',
                                    CRNOV_DESCRIPCION:inText,
                                    CRNOV_TIPO:TypeNovedadNotificacion.COMENTARIO
                                });

                                var scpAgregarNovedad = new SOAPClientParameters();
                                scpAgregarNovedad.add('inCrseg_codigo', rNuevaNovedad.get('CRSEG_CODIGO'));
                                scpAgregarNovedad.add('inCrnov_descripcion', rNuevaNovedad.get('CRNOV_DESCRIPCION'));
                                scpAgregarNovedad.add('inCrnov_tipo', rNuevaNovedad.get('CRNOV_TIPO'));

                                SOAPClient.invoke(URL_WS + 'Cgg_res_novedad_notificacion', 'insert1', scpAgregarNovedad, true, function(inServiceResponse) {
                                    if (inServiceResponse == 'true') {
                                        Ext.MsgPopup.msg(tituloCgg_res_seguimiento, "Su comentario/sumilla/observaci\u00F3n fue guardada!.", MsgPopup.INFO);
                                        gsCgg_res_novedad_notificacion.reload();
                                    } else {
                                        Ext.MsgPopup.msg(tituloCgg_res_seguimiento, "No se pudo registrar su comentario/sumilla/observaci\u00F3n\nError:" + inServiceResponse, MsgPopup.WARNING);
                                    }
                                });
                            }
                        }
                    },
                    prompt:true,
                    multiline:true,
                    value:'Seguimiento atendido'
                });
            }
        },{
            id:'btnEliminarNovedad',
            iconCls:'iconEliminar',
			disabled:true,
            tooltip:'Elimina el registro seleccionado',
            handler:function() {
                var rNovedadSeleccionada = grdCgg_res_novedad_notificacion.getSelectionModel().getSelected();
                if (rNovedadSeleccionada){
                    if(rNovedadSeleccionada.get('CRNOV_USUARIO_INSERT') == tmpUsuarioConectado && rNovedadSeleccionada.get('CRSEG_CODIGO') == inRecordCgg_res_seguimiento.get('CRSEG_CODIGO')){
                        var scpEliminarNovedad = new SOAPClientParameters();
                        scpEliminarNovedad.add('inCrnov_codigo', rNovedadSeleccionada.get('CRNOV_CODIGO'));
                        SOAPClient.invoke(URL_WS + 'Cgg_res_novedad_notificacion', 'delete', scpEliminarNovedad, true, function(inServiceResponse) {
                            if (inServiceResponse == 'true') {
                                Ext.MsgPopup.msg(tituloCgg_res_seguimiento, "Su comentario/sumilla/observaci\u00F3n fue eliminada!.", MsgPopup.INFO);
                                gsCgg_res_novedad_notificacion.reload();
                            } else {
                                Ext.MsgPopup.msg(tituloCgg_res_seguimiento, "No se pudo eliminar su comentario/sumilla/observaci\u00F3n\nError:" + inServiceResponse, MsgPopup.WARNING);
                            }
                        });
                    }else{
                        Ext.MsgPopup.msg(tituloCgg_res_seguimiento, "No puede editar esta informaci\u00f3n!", MsgPopup.INFO);
                    }
                }
            }
        }]
    });
	grdCgg_res_novedad_notificacion.getSelectionModel().on("selectionchange",function(sm){
		if (sm.hasSelection()){			
			var rNovedad=sm.getSelected();
			if(rNovedad.get('CRNOV_USUARIO_INSERT') == tmpUsuarioConectado && rNovedad.get('CRSEG_CODIGO') == inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'))
				Ext.getCmp('btnEliminarNovedad').setDisabled(false);
			else
					Ext.getCmp('btnEliminarNovedad').setDisabled(true);				
		}
	});
    gsCgg_res_novedad_notificacion.load();
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_adjunto.
     */
    var cmCgg_res_adjunto = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),        
        {dataIndex:'CRADJ_NOMBRE_ADJUNTO',header:'Adjunto',width:200,sortable:true},        

        {
            dataIndex:'CRADJ_OBSERVACION',
            header:'Observaci\u00F3n',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRADJ_FECHA_REGISTRO',
            header:'Fecha',
            width:100,
            sortable:true,
            renderer:truncDate
        },

        {
            dataIndex:'CRADJ_USUARIO_INSERT',
            header:'Registrado por',
            width:100,
            sortable:true,
            hidden:true
        },

        {
            dataIndex:'CRADJ_USUARIO_UPDATE',
            header:'Actualizado por',
            width:100,
            sortable:true,
            hidden:true
        }
        ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_adjunto por un campo especifico.
     */
    var gsCgg_res_adjunto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_res_adjunto",
            method:"selectCGG_RES_SEGUIMIENTO1"
        }),
        reader:new Ext.data.JsonReader({}, [
        {
            name:'CRADJ_CODIGO'
        },

        {
            name:'CRSEG_CODIGO'
        },

        {
            name:'CRADJ_NOMBRE_ADJUNTO'
        },

        {
            name:'CRADJ_OBSERVACION'
        },

        {
            name:'CRADJ_FECHA_REGISTRO'
        },

        {
            name:'CRADJ_USUARIO_INSERT'
        },

        {
            name:'CRADJ_USUARIO_UPDATE'
        }
        ]),
        baseParams:{
            inCrseg_codigo:inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'),
            format:"JSON"
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_adjunto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_adjunto = new Ext.grid.GridPanel({
        cm:cmCgg_res_adjunto,
        store: gsCgg_res_adjunto,
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
        plugins:[new Ext.ux.grid.AutoSizeColumns()],
        trackMouseOver: true,
        tbar:[
        {
            id:'btnAgregarAdjunto',
            iconCls:'iconNuevo',
            tooltip:'Agrega un adjunto',
            handler:function() {
                var objSubirAdjunto = new FrmSubirAdjunto(inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'));
                objSubirAdjunto.closeHandler(function() {
                    gsCgg_res_adjunto.reload();
                });
                objSubirAdjunto.show();
            }
        },
        {
            id:'btnEliminarAdjunto',
            iconCls:'iconEliminar',
			disabled:true,
            tooltip:'Elimina un adjunto',
            handler:function() {
                var rAdjuntoSeleccionado = grdCgg_res_adjunto.getSelectionModel().getSelected();
                if (rAdjuntoSeleccionado !== null && rAdjuntoSeleccionado !== undefined) {
                    Ext.Msg.show({
                        title:tituloCgg_res_seguimiento,
                        msg:'Est\u00e1 seguro de eliminar el archivo adjunto?',
                        buttons: Ext.Msg.YESNO,
                        fn:function(inBtn) {
                            if (inBtn == 'yes') {
                                var scpEliminarAdjunto = new SOAPClientParameters();
                                scpEliminarAdjunto.add('inCradj_codigo', rAdjuntoSeleccionado.get('CRADJ_CODIGO'));
                                SOAPClient.invoke(URL_WS + "Cgg_res_adjunto", 'delete', scpEliminarAdjunto, true, function(inServiceResponse) {
                                    if (inServiceResponse == 'true') {
                                        Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El informe ha sido eliminado.', MsgPopup.INFO);
                                        gsCgg_res_adjunto.reload();
                                    } else {
                                        Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El informe ha sido eliminado.\nError:' + inServiceResponse, MsgPopup.WARNING);
                                    }
                                })
                            }
                        },
                        icon: Ext.MessageBox.QUESTION
                    });
                }
            }
        },
        {
            id:'btnVerAdjunto',
            iconCls:'iconBuscar',
            handler:function() {
                var rAdjunto = grdCgg_res_adjunto.getSelectionModel().getSelected();
                if (rAdjunto !== null) {
                    window.open(URL_DOC_VIEWER + '?table=cgg_res_adjunto&keyc=cradj_codigo&keyv=' + rAdjunto.get('CRADJ_CODIGO') + '&column=cradj_archivo_adjunto&fn=' + rAdjunto.get('CRADJ_NOMBRE_ADJUNTO') + '&request=view');
                }
            }
        },{            
            iconCls:'iconDescargar',
            handler:function() {
                var mAdjunto = new Ext.menu.Menu({
                    items:[
                    {
                        text: 'Descargar',
                        handler:function() {
                            var rAdjunto = inComponent.getSelectionModel().getSelected();
                            window.open(URL_DOC_VIEWER + '?table=cgg_res_adjunto&keyc=cradj_codigo&keyv=' + rAdjunto.get('CRADJ_CODIGO') + '&column=cradj_archivo_adjunto&fn=' + rAdjunto.get('CRADJ_NOMBRE_ADJUNTO') + '&request=download');
                        }
                    }
                    ]
                });
            }
        }
        ],
        listeners:{
            rowcontextmenu:function(inComponent, inRowIndex, inEventObject) {
                inComponent.getSelectionModel().selectRow(inRowIndex);
                var mAdjunto = new Ext.menu.Menu({
                    items:[
                    {
                        text: 'Descargar',
                        handler:function() {
                            var rAdjunto = inComponent.getSelectionModel().getSelected();
                            window.open(URL_DOC_VIEWER + '?table=cgg_res_adjunto&keyc=cradj_codigo&keyv=' + rAdjunto.get('CRADJ_CODIGO') + '&column=cradj_archivo_adjunto&fn=' + rAdjunto.get('CRADJ_NOMBRE_ADJUNTO') + '&request=download');
                        }
                    }
                    ]
                });
                inEventObject.stopEvent();
                mAdjunto.showAt(inEventObject.getXY());
            },
            rowdblclick:function(inGrid, rowIndex, e) {
                var rAdjunto = inGrid.getSelectionModel().getSelected();
                window.open(URL_DOC_VIEWER + '?table=cgg_res_adjunto&keyc=cradj_codigo&keyv=' + rAdjunto.get('CRADJ_CODIGO') + '&column=cradj_archivo_adjunto&fn=' + rAdjunto.get('CRADJ_NOMBRE_ADJUNTO') + '&request=view');
            }
        }
    });
	grdCgg_res_adjunto.getSelectionModel().on("selectionchange",function(sm){
		if (sm.hasSelection()){			
			var rAdjunto=sm.getSelected();
			if(rAdjunto.get('CRADJ_USUARIO_INSERT') == tmpUsuarioConectado && rAdjunto.get('CRSEG_CODIGO') == inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'))
				Ext.getCmp('btnEliminarAdjunto').setDisabled(false);
			else
					Ext.getCmp('btnEliminarAdjunto').setDisabled(true);				
		}
	});
    gsCgg_res_adjunto.load();


    var ccCJCRI_REQUERIDO=new Ext.grid.CheckColumn({
        dataIndex:'CJCRI_REQUERIDO',
        header:'Requerido',
        width:70,
        sortable:true
    });

    var ccCJSGC_RESPUESTA=new Ext.grid.CheckColumn({
        dataIndex:'CJSGC_RESPUESTA',
        header:'Cumplido',
        width:60,
        sortable:true
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_jur_seguimiento_criterio.
     */
    var cmCgg_jur_seguimiento_criterio = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),    
        {
            dataIndex:'CJCRI_REQUERIMIENTO',
            header:'Requerimiento',
            width:180,
            sortable:true
        },
        ccCJCRI_REQUERIDO,ccCJSGC_RESPUESTA,
        {
            dataIndex:'CJSGC_JUSTIFICACION',
            header:'Justificaci\u00F3n',
            width:150,
            sortable:true,
            editor:{
                xtype:'textfield',
                emptyText:'Establezca una justificaci\u00F3n, por favor.'
            }
        },
        {
            dataIndex:'CJSGC_NOMBRE_ADJUNTO',
            header:'Adjunto',
            width:150,
            sortable:true,
            hidden:true,
            hiddeable:true
        },{
            dataIndex:'CJSGC_OBSERVACION',
            header:'Observaci\u00f3n',
            width:150,
            sortable:true,
            editor:{
                xtype:'textfield'
            }
        }
        ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_jur_seguimiento_criterio por un campo especifico.
     */
    var gsCgg_jur_seguimiento_criterio = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS + "Cgg_jur_seguimiento_criterio",
            method:"selectSEGUIMIENTO_CRITERIO"
        }),
        reader:new Ext.data.JsonReader({}, [
		{name:'CJSGC_CODIGO'},
		{name:'CRSEG_CODIGO'},
		{name:'CJCRI_CODIGO'},
		{name:'CJSGC_RESPUESTA'},
		{name:'CJSGC_JUSTIFICACION'},
		{name:'CJSGC_OBSERVACION'},
		{name:'CJSGC_NOMBRE_ADJUNTO'},
		{name:'CJCRI_REQUERIMIENTO'},
		{name:'CJCRI_REQUERIDO'		}
		]),
        baseParams:{
            inCrseg_codigo:inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'),
            inCrfas_codigo:inRecordCgg_res_seguimiento.get('CRFAS_CODIGO'),
            format:TypeFormat.JSON
        },
        listeners:{
            load:function(){
                if(enableDelayRow !== null && enableDelayRow!==undefined){
                    grdCgg_jur_seguimiento_criterio.getSelectionModel().selectRow(enableDelayRow);
                    var rAdjuntoCriterio = grdCgg_jur_seguimiento_criterio.getSelectionModel().getSelected();
                    var objSubirAdjunto = new FrmSubirAdjuntoCriterio(rAdjuntoCriterio.get('CJSGC_CODIGO'));
                    objSubirAdjunto.closeHandler(function() {
                        enableDelayRow=null;
                        gsCgg_jur_seguimiento_criterio.load();
                    });
                    objSubirAdjunto.show();                    
                }
            }
        }
    });
    
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_jur_seguimiento_criterio en un formato tabular de filas y columnas.
     */
    var grdCgg_jur_seguimiento_criterio = new Ext.grid.EditorGridPanel({
        cm:cmCgg_jur_seguimiento_criterio,
        store:gsCgg_jur_seguimiento_criterio,
        region:'center',
        cliksToEdit:'auto',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true,
            moveEditorOnEnter:false
        }),
        plugins:[(esHistorico==true)?null:ccCJSGC_RESPUESTA],
        loadMask:{
            msg:"Cargando..."
        },
        listeners:{
            afteredit:function(inObject) {

                if(esHistorico == true){
                    //if(new UserSession().getUserID() != inRecordCgg_res_seguimiento.get('CUSU_CODIGO')){
                        return;
                    //}
                }

                var scpCriterioSeguimiento = new SOAPClientParameters();
                var method = 'insert1';

                if (inObject.record.get('CJSGC_CODIGO') != 'KEYGEN') {
                    method = 'update1';
                    scpCriterioSeguimiento.add('inCjsgc_codigo', inObject.record.get('CJSGC_CODIGO'));
                }
                scpCriterioSeguimiento.add('inCrseg_codigo', inObject.record.get('CRSEG_CODIGO'));
                scpCriterioSeguimiento.add('inCjcri_codigo', inObject.record.get('CJCRI_CODIGO'));
                scpCriterioSeguimiento.add('inCjsgc_respuesta', inObject.record.get('CJSGC_RESPUESTA'));
                scpCriterioSeguimiento.add('inCjsgc_justificacion', inObject.record.get('CJSGC_JUSTIFICACION'));
                scpCriterioSeguimiento.add('inCjsgc_observacion', inObject.record.get('CJSGC_OBSERVACION'));

                SOAPClient.invoke(URL_WS + 'Cgg_jur_seguimiento_criterio', method, scpCriterioSeguimiento, true, function(inServiceResponse) {
                    if (inServiceResponse == 'true') {
                        Ext.MsgPopup.msg(tituloCgg_res_informe_seguimiento, "El criterio fue actualizado.", MsgPopup.INFO);
                    } else {
                        Ext.MsgPopup.msg(tituloCgg_res_informe_seguimiento, "El criterio no ha sido actualizado.<br>Error:" + inServiceResponse, MsgPopup.WARNING);
                    }
                    gsCgg_jur_seguimiento_criterio.load();
                });
            }
        }
    });
    gsCgg_jur_seguimiento_criterio.load();

    /**
     * Ext.Panel Panel que contiene los fielset con informaciÃ³n del trÃ¡mite y el seguimiento
     */
    var pnlSeguimientoP2 = new Ext.Panel({
        id:'pnlSeguimientoP2',
        labelWidth:100,
        region:'north',
        layout:'accordion',
        height:190,
        minHeight:190,
        bodyStyle:'background-color: #EBEBEB',
        items:[{
            title:'Datos tr\u00E1mite',
            html:'<div class="wfl" id="divTramite"/>',
            cls:'empty',
            autoScroll:true
        },
        {
            title:'Datos fase seguimiento',
            html:'<div class="wfl" id="divSeguimiento"/>',
            cls:'empty',
            autoScroll:true
        }
        ]
    });
    /*
     * Ext.form.FormPanel
     */
    var pnlAdjuntoSeguimiento = new Ext.form.FormPanel({
        id:'pnlAdjuntoSeguimiento',
        region:'center',
        layout:'border',
        fileUpload:true,
        items:[grdCgg_res_adjunto]
    });

    /**
     * Funcion que elimina un informe relacionado al seguimiento
     */
    function SWRCgg_res_informe_seguimiento(btn) {
        if (btn == 'yes') {
            try {
                function CallBackCgg_res_informe_seguimiento(r) {
                    winFrmCgg_res_seguimiento.getEl().unmask();
                    if (r == 'true') {
                        Ext.Msg.show({
                            title:tituloCgg_res_informe_seguimiento,
                            msg: 'El informe del seguimiento ha sido eliminada',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                        gsCgg_res_informe_seguimiento.reload();
                    } else {
                        Ext.Msg.show({
                            title:tituloCgg_res_informe_seguimiento,
                            msg: 'El informe del seguimiento no ha podido ser eliminada',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    }
                }

                winFrmCgg_res_seguimiento.getEl().mask('Eliminando...', 'x-mask-loading');
                var param = new SOAPClientParameters();
                param.add('inCrinf_codigo', grdCgg_res_informe_seguimiento.getSelectionModel().getSelected().get('CRINF_CODIGO'));
                SOAPClient.invoke(URL_WS + "Cgg_res_informe", "delete", param, true, CallBackCgg_res_informe_seguimiento);
            } catch(inErr) {
                //logCGG.error('Error al eliminar el informe ', inErr);
                alert(inErr);
                winFrmCgg_res_seguimiento.getEl().unmask();
            }
        }
    }

    var cbcCRRQT_CUMPLE = new Ext.grid.CheckColumn({
        dataIndex: 'CRRQT_CUMPLE',
        header: 'Cumple',
        width: 80        
    });

    var ccCRSRQ_REQUERIDO = new Ext.grid.CheckColumn({
        dataIndex: 'CRRQT_REQUERIDO',
        header: 'Requerido',
        width: 90
    });

    //PRUEBA ADJUNTO

    var adjunto = new Ext.ux.form.AlfrescoFM({
        id:'identificador_componente',  //(opcional)
        name:'nombre_componente',       //(opcional)
        fieldLabel :'Adjuntos',         //(opcional -> Despliega la etiqueta del comoponente. Si no se define, aparece solo el botón)
        text: 'Adjunto',                //(opcional -> Texto del botón)
        tableName : 'CGG_TABLA_DE REFERENCIA',
        recordID : 'RECORD_ID',
        filter: 'FILTRO_PARA_EL_MODELO' //(opcional)
    });

    //


    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_seguimiento_requisito.
     */
    var cmCgg_res_seguimiento_requisito = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(), {
            dataIndex: 'CRREQ_CODIGO',
            header: 'Requisito',
            width: 120,
            sortable: true,
            renderer: function(inCRREQ_CODIGO) {
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
            renderer: function(inCRSRQ_PARTICIPANTE) {
                var result = 'no datos';
                for (var i = 0; i < dsTipoParticipante.length; i++) {
                    if (dsTipoParticipante[i][0] == inCRSRQ_PARTICIPANTE) {
                        result = dsTipoParticipante[i][1];
                        break;
                    }
                }
                return result;
            }
        },ccCRSRQ_REQUERIDO, cbcCRRQT_CUMPLE,{
            dataIndex: 'CRRQT_OBSERVACION',
            header: 'Observaci\u00F3n',
            width: 200,
            sortable: true
        }
//MO
        /*,{
            dataIndex: 'CRADJ_DATA',
            header: 'Adjuntado por',
            hidden:true,
            renderer:function(inCRADJ_DATA){
                var result = "";
                if(inCRADJ_DATA!==null && inCRADJ_DATA.CRADJ_USUARIO_INSERT!==null && inCRADJ_DATA.CRADJ_USUARIO_INSERT.trim().length>=1){
                    result = inCRADJ_DATA.CRADJ_USUARIO_INSERT;
                }else{
                    result = NO_DATA_MESSAGE;
                }
                return result;
            }
        }*/
//
    ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_seguimiento_requisito por un campo especifico.
     */
    var gsCgg_res_seguimiento_requisito = new Ext.data.GroupingStore({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_res_requisito_tramite",
            method: "selectRequisitoAdjunto"
        }),
        reader: new Ext.data.JsonReader({}, [
		{name: 'CRSRQ_CODIGO'},
		{name: 'CRTSR_CODIGO'},
		{name: 'CRREQ_CODIGO'},
		{name: 'CRSRQ_DESCRIPCION'},
		{name: 'CRRQT_REQUERIDO'},
		{name: 'CRSRQ_PARTICIPANTE'},
		{name: 'CRRQT_CODIGO'},
		{name: 'CRTRA_CODIGO'},
		{name: 'CRRQT_CUMPLE'},
		{name: 'CRRQT_OBSERVACION'},
		{name: 'CRADJ_DATA'}
        ]),
        groupField: 'CRSRQ_PARTICIPANTE',
        baseParams: {
            inCrtst_codigo: null,
            inCrtra_codigo: null,
            format: TypeFormat.JSON
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_seguimiento_requisito en un formato tabular de filas y columnas.
     */
    var grdCgg_res_seguimiento_requisito = new Ext.grid.GridPanel({
        store: gsCgg_res_seguimiento_requisito,
        cm: cmCgg_res_seguimiento_requisito,
        region: 'center',
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Requisitos" : "Requisito"]})'
        }),
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true
        }),        
        loadMask: {
            msg: "Cargando..."
        }
    });
    
    /**
     * Ext.TabPanel Contienen los tab de listado de informes que tiene el seguimiento y adjuntos
     * propios del seguimiento
     */
    var pnlTabSeguimientoP3 = new Ext.TabPanel({
        id:'pnlTabSeguimientoP3',
        activeTab:0,
        width:'60%',
        anchor:'60%',
        region:'east',
        split:true,        
        enableTabScroll:true,
        items:[
        {
            id:'tpRequisitoTramite',
            title:'Requisito de tr\u00E1mite',
            layout:'border',
            items: [grdCgg_res_seguimiento_requisito]
        },
        {
            id:'tpSeguimientoInforme',
            title:'Informes',
            layout:'border',            
            items:[grdCgg_res_informe_seguimiento]
        },
        /*{AC=>
            id:'tpSeguimientoAdjunto',
            title:'Adjuntos',
            layout:'border',
            items:[pnlAdjuntoSeguimiento]
        },*/
        {
            id:'tpSeguimientoRequerimiento',
            title:'Requisitos a cumplir',
            layout:'border',
            items:[grdCgg_jur_seguimiento_criterio]
        }
        ]
    });

    /**
     * Ext.Panel
     */
    var pnlFaseP4 = new Ext.Panel({
        id:'pnlFaseP4',
        region:'center',
        layout:'border',
        items:[grdCgg_res_novedad_notificacion,pnlTabSeguimientoP3]
    });

    /**
     * Ext.Panel Contenedor principal
     */
    var pnlSeguimientoP1 = new Ext.Panel({
        id:'pnlSeguimientoP1',
        labelWidth :100,
        layout:'border',
        region:'center',
        fileUpload:true,
        items:[pnlSeguimientoP2,pnlFaseP4]
    });

    var fsBeneficiarios = new Ext.form.FieldSet({
        title:'Beneficiarios',
        items:[{
            layout:'column',
            items:[{
                columnWidth:0.5,
                layout:'form',
                items:[{
                    xtype:'textfield',
                    fieldLabel:'Beneficiario',
                    readOnly:true,
                    id:'txtCrperBeneficiario'
                },{
                    xtype:'textfield',
                    fieldLabel:'Auspiciante',
                    readOnly:true,
                    id:'txtCrperAuspiciante'
                }]
            },{
                columnWidth:0.5,
                layout:'form',
                items:[{
                    xtype:'textfield',
                    fieldLabel:'Tipo solicitud',
                    readOnly:true,
                    id:'txtCrtstDescripcion'
                }]
            }]
        }]
    });

    var fsResolucion= new Ext.form.FieldSet({
        title:'Resoluci\u00f3n',
        items:[{
            layout:'column',
            items:[{
                columnWidth:0.5,
                layout:'form',
                items:[{
                    xtype:'textfield',
                    fieldLabel:'Numero',
                    readOnly:true,
                    id:'txtCrresNumeroResolucion'
                },{
                    xtype:'textfield',
                    fieldLabel:'Lugar',
                    readOnly:true,
                    id:'txtCislaNombre'
                },{
                    xtype:'panel',
                    layout:'column',
                    items:[{
                        width:105,
                        items:[{
                            xtype:'label',
                            text:'Adjunto:'
                        }]
                    },{
                        columnWidth:0.5,
                        items:[{
                            xtype:'button',
                            iconCls:'iconBuscar',
                            handler:function(){
                                if(crresData.CRRES_NOMBRE_ADJUNTO_RESOL!== undefined && crresData.CRRES_NOMBRE_ADJUNTO_RESOL!==null ){
                                    var url1 = URL_DOC_VIEWER+'?table=cgg_res_resolucion&keyc=crres_codigo&keyv='+crresData.CRRES_CODIGO +'&column=crres_adjunto_resolucion&fn='+crresData.CRRES_NOMBRE_ADJUNTO_RESOL+'&request=view';
                                    window.open(url1);
                                }
                            }
                        }]
                    }]
                }]
            },{
                columnWidth:0.5,
                layout:'form',
                items:[{
                    xtype:'textfield',
                    fieldLabel:'Fecha',
                    readOnly:true,
                    id:'txtCrresFechaEjecucion'
                },{
                    xtype:'textarea',
                    fieldLabel:'Observaci\u00f3n',
                    readOnly:true,
                    id:'txtCrresObservaciones',
                    anchor:'100%'
                }]
            }]
        }]
    });

    var fsCarnet = new Ext.form.FieldSet({
        title:'Carnetizaci\u00f3n',
        items:[{
            layout:'column',
            items:[{
                columnWidth:0.5,
                layout:'form',
                items:[{
                    xtype:'textfield',
                    fieldLabel:'N. carnet',
                    readOnly:true,
                    id:'txtNumeroCarnet'
                },{
                    xtype:'textfield',
                    fieldLabel:'Fecha expedici\u00f3n',
                    readOnly:true,
                    id:'txtFechaExpedicion'
                }]
            },{
                columnWidth:0.5,
                layout:'form',
                items:[{
                    xtype:'textfield',
                    fieldLabel:'Fecha caducidad',
                    readOnly:true,
                    id:'txtFechaCaducidad'
                }]
            }]
        }]
    });

    var tpSeguimiento = new Ext.TabPanel({
        id:'tpSeguimiento',        
        region:'center',
        layoutOnTabChange:true,
        tabPosition:'bottom',
        items:[{
            title:'Seguimiento',
            xtype:'panel',
            layout:'border',
            id:'tpSeguimiento1',
            items:[pnlSeguimientoP1]
        }/*,{
            title:'Informaci\u00f3n residencia',
            xtype:'panel',
            id:'tpInfoResidencia',
            frame:true,
            disabled:true,
            items:[pnlTramite_aprobacion]
        }*/]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_seguimiento.
     */
    var winFrmCgg_res_seguimiento = null;

    if (inDesktop !== null && inDesktop !== undefined) {
        winFrmCgg_res_seguimiento = inDesktop.createWindow({
            id:'winFrmCgg_res_seguimiento',
            layout:'border',
            title:tituloCgg_res_seguimiento,
            tbar:getPanelTitulo(tituloCgg_res_seguimiento, descCgg_res_seguimiento),
            items:[pnlSeguimientoP1],
            width:700,
            height:550,
            maximizable:true,
            minimizable:true,
            constrain:true,
            iconCls:'iconSeguimiento',
            bbar:[btnAprobarCgg_res_seguimiento,btnNegarCgg_res_seguimiento,'-',btnDistribuirCgg_res_seguimiento,'-',{
                id:'btnOtraAccionCgg_res_seguimiento',
                text:'Otras acciones',
                iconCls:'iconGuardar',
                tooltip:'Otras acciones',
                menu: {
                    id:'mOtrasAcciones',
                    items:[{
                        id:'miPendiente',
                        text:'Dejar pendiente',
                        iconCls:'iconPendiente',
                        handler:function() {
                            var scpDejarPendiente = new SOAPClientParameters();
                            scpDejarPendiente.add('inCrseg_codigo', inRecordCgg_res_seguimiento.get('CRSEG_CODIGO'));
                            SOAPClient.invoke(URL_WS + 'Cgg_res_seguimiento', 'dejarPendiente', scpDejarPendiente, true, function(inServiceResponse) {
                                if (inServiceResponse == 'true') {
                                    Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El tr\u00e1mite ' + inRecordCgg_res_seguimiento.get('CRTRA_ANIO') + '-' + inRecordCgg_res_seguimiento.get('CRTRA_NUMERO') + ' fue dejado pendiente!.', MsgPopup.INFO);
                                    winFrmCgg_res_seguimiento.close();
                                } else {
                                    Ext.MsgPopup.msg(tituloCgg_res_seguimiento, 'El tr\u00e1mite ' + inRecordCgg_res_seguimiento.get('CRTRA_ANIO') + '-' + inRecordCgg_res_seguimiento.get('CRTRA_NUMERO') + ' no ha sido actualizado!.<br>Error:' + inServiceResponse, MsgPopup.WARNING);
                                }
                            })
                        }
                    }
                    ]
                }
            },'-',btnAdjuntos,'->',btnCerrarCgg_res_seguimiento],
            listeners:{
                show:function(){
                    tpSeguimiento.activate('tpSeguimiento1');
                    //tpSeguimiento.activate('tpInfoResidencia');
                    tpSeguimiento.activate('tpSeguimiento1');

                    tplTramite.compile();
                    tplTramite.overwrite('divTramite', datosTramite);
                    tplSeguimientoFase.compile();
                    tplSeguimientoFase.overwrite('divSeguimiento', datosSeguimiento);
                    if(isVehiculo)
                        $("idDivBeneficiario").innerHTML = 'Vehiculo';
                    if(esHistorico)
                    {
                        Ext.get('lnkSeguimiento').setVisible(false);
                        Ext.get('lnkPersona').setVisible(false);
                    }
                }
            }
        });
    } else {
        winFrmCgg_res_seguimiento = new Ext.Window({
            id:'winFrmCgg_res_seguimiento',
            layout:'border',
            title:tituloCgg_res_seguimiento,
            tbar:getPanelTitulo(tituloCgg_res_seguimiento, descCgg_res_seguimiento),
            items:[pnlSeguimientoP1],
            width:650,
            height:500,
            maximizable:true,
            minimizable:true,
            constrain:true,
            iconCls:'iconSeguimiento',
            bbar:[btnAprobarCgg_res_seguimiento,btnNegarCgg_res_seguimiento,btnOtraAccionCgg_res_seguimiento,'->',btnCerrarCgg_res_seguimiento],
            listeners:{
                show:function() {
                    $('divTramite').innerHTML = tplTramite.apply(datosTramite);
                    $('divSeguimiento').innerHTML = tplSeguimientoFase.apply(datosSeguimiento);
                }
            }
        });
    }


    function isla(inCISLA_CODIGO) {
        var tmp1 = SCGG_ISLA.findExact('CISLA_CODIGO', inCISLA_CODIGO);
        var resultado = null;
        if (tmp1 >= 0) {
            resultado = SCGG_ISLA.getAt(tmp1);
        } else {
            resultado = null;
        }
        return resultado;
    }

    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_seguimiento.
     */
    function cargarCgg_res_seguimientoCtrls(inHistorico) {
        if (inRecordCgg_res_seguimiento) {
            datosTramite.CRTRA_CODIGO = inRecordCgg_res_seguimiento.get('CRTRA_CODIGO');
            datosTramite.CRTRA_ANIO = inRecordCgg_res_seguimiento.get('CRTRA_ANIO');
            datosTramite.CRTRA_NUMERO = inRecordCgg_res_seguimiento.get('CRTRA_NUMERO');
            datosTramite.CRPER_BENEFICIARIO = inRecordCgg_res_seguimiento.get('CRPER_BENEFICIARIO')==null&& inRecordCgg_res_seguimiento.get('CRPJR_RAZON_SOCIAL')==null ? inRecordCgg_res_seguimiento.get('VEHICULO'):inRecordCgg_res_seguimiento.get('CRPER_BENEFICIARIO');
			datosTramite.CGG_CRPER_NUM_DOC_IDENTIFIC = inRecordCgg_res_seguimiento.get('CGG_CRPER_NUM_DOC_IDENTIFIC');
            datosTramite.CRPER_AUSPICIANTE = inRecordCgg_res_seguimiento.get('CRPER_AUSPICIANTE')==null ? '':inRecordCgg_res_seguimiento.get('CRPER_AUSPICIANTE');
            datosTramite.ETIQUETA = inRecordCgg_res_seguimiento.get('CRPER_BENEFICIARIO')== null&&inRecordCgg_res_seguimiento.get('CRPJR_RAZON_SOCIAL') == null?'Vehiculo':'Beneficiario';
            datosTramite.CRTRA_FECHA_RECEPCION = truncDate(inRecordCgg_res_seguimiento.get('CRTRA_FECHA_RECEPCION'));
            datosTramite.CRPJR_RAZON_SOCIAL = inRecordCgg_res_seguimiento.get('CRPJR_RAZON_SOCIAL')==null ? ' ': inRecordCgg_res_seguimiento.get('CRPJR_RAZON_SOCIAL');
            datosTramite.CISLA_NOMBRE = inRecordCgg_res_seguimiento.get('CISLA_NOMBRE');
            datosTramite.CRTRA_OBSERVACION = Ext.util.Format.undef(inRecordCgg_res_seguimiento.get('CRTRA_OBSERVACION'));
            datosTramite.CRTRA_COMUNICADO_RADIAL = inRecordCgg_res_seguimiento.get('CRTRA_COMUNICADO_RADIAL') == 'null' ? '' : inRecordCgg_res_seguimiento.get('CRTRA_COMUNICADO_RADIAL');
            datosTramite.CRTRA_DIAS_PERMANENCIA = inRecordCgg_res_seguimiento.get('CRTRA_DIAS_PERMANENCIA') != 0?inRecordCgg_res_seguimiento.get('CRTRA_DIAS_PERMANENCIA') +' dias':inRecordCgg_res_seguimiento.get('CRTRA_FECHA_SALIDA')?truncDate(inRecordCgg_res_seguimiento.get('CRTRA_FECHA_SALIDA')):'INDEFINIDO';

            var scpTramite = new SOAPClientParameters({
                inCrtra_codigo:inRecordCgg_res_seguimiento.get('CRTRA_CODIGO'),
                format:TypeFormat.JSON
            });

            try{
                crtraData = SOAPClient.invoke(URL_WS+'Cgg_res_tramite', 'select', scpTramite, false, null);
                crtraData = Ext.util.JSON.decode(crtraData);
                crtraData = crtraData[0];
            }catch(inErr){
                crtraData = null;
            }
            
            if(crtraData.CRTRA_DIAS_PERMANENCIA == 0){

                if(crtraData.CRTRA_FECHA_SALIDA!==undefined && crtraData.CRTRA_FECHA_SALIDA !== null && crtraData.CRTRA_FECHA_SALIDA.trim().length >=1){
                    datosTramite.CRTRA_DIAS_PERMANENCIA=crtraData.CRTRA_FECHA_SALIDA.toString('dd/MM/yyyy');
                }else{
                    datosTramite.CRTRA_DIAS_PERMANENCIA='Indefinido';
                }

            }else if(crtraData.CRTRA_DIAS_PERMANENCIA >=1){
                datosTramite.CRTRA_DIAS_PERMANENCIA=crtraData.CRTRA_DIAS_PERMANENCIA+' D\u00edas';
            }

            if(crtraData.CRTRA_MOTIVO!== undefined && crtraData.CRTRA_MOTIVO == 'true'){
                datosTramite.CRTRA_MOTIVO = 'Si';
            }else if(crtraData.CRTRA_MOTIVO!== undefined && crtraData.CRTRA_MOTIVO == 'false'){
                datosTramite.CRTRA_MOTIVO = 'No';
            }

            var scpCargo = new SOAPClientParameters();
            scpCargo.add('inCgcrg_codigo',inRecordCgg_res_seguimiento.get('CRTRA_ACTIVIDAD_RESIDENCIA'));
            scpCargo.add('format',TypeFormat.JSON);

            var tmpCargo = SOAPClient.invoke(URL_WS+'Cgg_gem_cargo', 'select', scpCargo, false, null);
            try{
                tmpCargo = Ext.util.JSON.decode(tmpCargo);
                tmpCargo =  tmpCargo[0];
                datosTramite.CRTRA_ACTIVIDAD_RESIDENCIA = tmpCargo.CGCRG_NOMBRE ;
            }catch(inErr){
                datosTramite.CRTRA_ACTIVIDAD_RESIDENCIA =NO_DATA_MESSAGE;
            }                      

            datosTramite.CRTRA_FOLIO = inRecordCgg_res_seguimiento.get('CRTRA_FOLIO');
            datosTramite.CRPER_CODIGO = inRecordCgg_res_seguimiento.get('CGG_CRPER_CODIGO');
            datosTramite.CRFAS_NOMBRE = inRecordCgg_res_seguimiento.get('CRFAS_NOMBRE');

            datosSeguimiento.CRSEG_NUMERO = inRecordCgg_res_seguimiento.get('CRSEG_NUMERO');
            datosSeguimiento.CRFAS_NOMBRE = inRecordCgg_res_seguimiento.get('CRFAS_NOMBRE');
            datosSeguimiento.CRSEG_FECHA_RECEPCION = truncDate(inRecordCgg_res_seguimiento.get('CRSEG_FECHA_RECEPCION'));
            datosSeguimiento.CRSEG_FECHA_DESPACHO = truncDate(inRecordCgg_res_seguimiento.get('CRSEG_FECHA_DESPACHO'));
            datosSeguimiento.CRSEG_OBSERVACION = inRecordCgg_res_seguimiento.get('CRSEG_OBSERVACION');
            datosSeguimiento.CRSEG_TIPO_ACTIVIDAD = inRecordCgg_res_seguimiento.get('CRSEG_TIPO_ACTIVIDAD');
            datosSeguimiento.CRSEG_DESCRIPCION = inRecordCgg_res_seguimiento.get('CRSEG_DESCRIPCION');
            datosSeguimiento.CUSU_NOMBRES = inRecordCgg_res_seguimiento.get('CUSU_NOMBRES');           

            var tmpTipoSolicitudTramite = inRecordCgg_res_seguimiento.get('CRTST_CODIGO');
            var scpTipoSolicitudTramite = new SOAPClientParameters();
            scpTipoSolicitudTramite.add('inCrtst_codigo', tmpTipoSolicitudTramite);
            scpTipoSolicitudTramite.add('format', TypeFormat.JSON);
            crtstRegistro = SOAPClient.invoke(URL_WS + "Cgg_res_tipo_solicitud_tramite", 'select', scpTipoSolicitudTramite, false, null);
            try {
                crtstRegistro = Ext.util.JSON.decode(crtstRegistro);
                crtstRegistro = crtstRegistro[0];

                //Consulta de tipo de solicitud padre.
                var scpSolicitudPadre= new SOAPClientParameters();
                scpSolicitudPadre.add('inCrtst_codigo',inRecordCgg_res_seguimiento.get('CRTST_CODIGO'));
                scpSolicitudPadre.add('format',TypeFormat.JSON);
                var crtstPadre = SOAPClient.invoke(URL_WS+'Cgg_res_tipo_solicitud_tramite','selectCGG_RES_TIPO_SOLICITUD_PADRE',scpSolicitudPadre, false,null);

                crtstPadre = eval(crtstPadre);
                crtstPadre = crtstPadre[0];
                datosTramite.CRTST_DESCRIPCION = crtstPadre.CRTST_DESCRIPCION+'-'+ crtstRegistro.CRTST_DESCRIPCION;

            } catch(inErr) {
                datosTramite.CRTST_DESCRIPCION = '';
            }

            //SELECCION DE LA FASE DEL SEGUIMIENTO.
            var scpFase = new SOAPClientParameters();
            scpFase.add('inCrfas_codigo', inRecordCgg_res_seguimiento.get('CRFAS_CODIGO'));
            scpFase.add('format', TypeFormat.JSON);

            tmpFase = SOAPClient.invoke(URL_WS + 'Cgg_res_fase', 'select', scpFase, false, null)
            try {
                tmpFase = Ext.util.JSON.decode(tmpFase);
                tmpFase = tmpFase[0];
            } catch(inErr) {
                tmpFase = null;
            }
            tmpFaseActual = tmpFase;
			
            //CARGADA DE INFORMACION DE REQUERIMIENTOS.
            gsCgg_res_seguimiento_requisito.reload({
                params:{
                    inCrtst_codigo: inRecordCgg_res_seguimiento.get('CRTST_CODIGO'),
                    inCrtra_codigo: inRecordCgg_res_seguimiento.get('CRTRA_CODIGO'),
                    format: TypeFormat.JSON
                }
            });

            var scpParam=new SOAPClientParameters();
            scpParam.add('inCgg_crfas_codigo',inRecordCgg_res_seguimiento.get('CRFAS_CODIGO'));
            scpParam.add('inCisla_codigo',new UserSession().getUserData().CISLA_CODIGO);
            scpParam.add('format',TypeFormat.JSON);

            SOAPClient.invoke(URL_WS+"Cgg_res_fase",'selectCGG_RES_FASE1',scpParam,true, function(inServiceResponse){
                var tmpFase = null;
                try{
                    tmpFase = Ext.util.JSON.decode(inServiceResponse);
                    numFase = tmpFase.length;
                    Ext.getCmp('btnDistribuirCgg_res_seguimiento').setText('Distribuir('+numFase+')');
                    if(numFase == 0){
                        Ext.getCmp('btnDistribuirCgg_res_seguimiento').disable();
                    }
                }catch(inErr){
                    numFase = -1;
                }
            });

            //CONSULTA SI EL TRAMITE TIENE QUE ESCRIBIR EN RESIDENCIA DE ACUERDO A SU ESTADO DE TRAMITE.           
			crettCodigo = (SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact("CGCNF_CODIGO","01")).get("CGCNF_VALOR_CADENA"))||null;
            if(crettCodigo !== null && tmpFaseActual.CRETT_CODIGO == crettCodigo){
                necesitaFechaIngreso = true;
            }
            
            isEdit = true;

            //DESICION DE ESTADO DE ATENCION DISTRIBUIDO NO PERMITE EDICION DE ACCIONES.
            if (inRecordCgg_res_seguimiento.get('CRSEG_ESTADO_ATENCION') == TypeEstadoAtencion.DISTRIBUIDO) {
                btnAprobarCgg_res_seguimiento.disable();
                btnDistribuirCgg_res_seguimiento.disable();
                btnNegarCgg_res_seguimiento.disable();
                Ext.getCmp('btnOtraAccionCgg_res_seguimiento').disable();
                //MO
                btnResolucionCgg_res_seguimiento.disable();
                //
                Ext.MsgPopup.msg(tituloCgg_res_seguimiento, "El seguimiento se encuentra distribuido.<br>No puede realizar ninguna actividad hasta la ateci\u00F3n del mismo.", MsgPopup.INFO);
            }else if(inRecordCgg_res_seguimiento.get('CRSEG_ESTADO_ATENCION') == TypeEstadoAtencion.REVISADODISTRIBUIDO) {
                btnDistribuirCgg_res_seguimiento.disable();                
                Ext.MsgPopup.msg(tituloCgg_res_seguimiento, "El seguimiento debe ser obligatoriamente despachado.<br>No puede realizar ninguna actividad de distribuci\u00f3n del seguimiento.", MsgPopup.INFO);
            }else if(inRecordCgg_res_seguimiento.get('CRSEG_ESTADO_ATENCION') == TypeEstadoAtencion.PENDIENTE) {
                Ext.getCmp('btnOtraAccionCgg_res_seguimiento').disable();
            }

            if(inHistorico !==undefined &&  inHistorico !==null && inHistorico == true){
                esHistorico = true;
                //Deshabilitacion de controles de seguimiento.
                btnAprobarCgg_res_seguimiento.hide();
                btnNegarCgg_res_seguimiento.hide();
                btnDistribuirCgg_res_seguimiento.hide();
                Ext.getCmp('btnOtraAccionCgg_res_seguimiento').hide();
                //MO
                btnResolucionCgg_res_seguimiento.hide();
                //

                Ext.getCmp('btnAgregarNovedad').hide();
                Ext.getCmp('btnEliminarNovedad').hide();
                Ext.getCmp('btnAgregarAdjunto').hide();
                Ext.getCmp('btnEliminarAdjunto').hide();
                Ext.getCmp('btnEliminarInforme').hide();
                Ext.getCmp('btnAgregarInforme').hide();
                /* if(new UserSession().getUserID() == inRecordCgg_res_seguimiento.get('CUSU_CODIGO')){

                 Ext.getCmp('btnAgregarNovedad').show();
                 Ext.getCmp('btnEliminarNovedad').show();
                 Ext.getCmp('btnAgregarAdjunto').show();
                 Ext.getCmp('btnEliminarAdjunto').show();
                 Ext.getCmp('btnEliminarInforme').show();
                 Ext.getCmp('btnAgregarInforme').show();
                 }*/

                                      
            }
        }
    }

    /**
     *Funcion. Comprueba que la fase del seguimiento actual es o no la fase final del proceso.
     *@return true/false.
     */
    function esFaseFinal() {
        var flagFinalizacion = false;
        //SELECCION DE LA FASE FINAL DEL PROCESO.
        var scpFaseFinalizacion = new SOAPClientParameters();
        scpFaseFinalizacion.add('inCrpro_codigo', tmpFase.CRPRO_CODIGO);
        scpFaseFinalizacion.add('inCisla_codigo', new UserSession().getUserData().CISLA_CODIGO);
        scpFaseFinalizacion.add('format', TypeFormat.JSON);

        var tmpFaseFinalizacion = SOAPClient.invoke(URL_WS + 'Cgg_res_fase', 'selectFaseFinalizacion', scpFaseFinalizacion, false, null);
        try {
            tmpFaseFinalizacion = Ext.util.JSON.decode(tmpFaseFinalizacion);
            tmpFaseFinalizacion = tmpFaseFinalizacion[0];
        } catch(inErr) {
            tmpFaseFinalizacion = null;
        }

        if (tmpFaseFinalizacion !== null) {
            if (tmpFase.CRFAS_CODIGO == tmpFaseFinalizacion.CRFAS_CODIGO) {
                flagFinalizacion = true;
            } else {
                flagFinalizacion = false;
            }
        } else {
            Ext.Msg.show({
                title:tituloCgg_res_seguimiento,
                msg:'El seguimiento no puede ser enviado!<br>' + ERR_MESSAGE,
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.ERROR,
                fn:function() {
                    btnAprobarCgg_res_seguimiento.disable();
                    btnNegarCgg_res_seguimiento.disable();
                    btnDistribuirCgg_res_seguimiento.disable();
                    Ext.getCmp('btnOtraAccionCgg_res_seguimiento').disable();
                    //MO
                    btnResolucionCgg_res_seguimiento.disable();
                    //
                }
            });
            flagFinalizacion = null;
        }
        return flagFinalizacion;
    }

    /**
     *Funcion. Comprueba que si el seguimiento actual es un seguimiento hijo.
     *@return true/false.
     */
    function esFaseHija() {
        var flagHija = false;
        if (inRecordCgg_res_seguimiento.get('CGG_CRSEG_CODIGO') == null || inRecordCgg_res_seguimiento.get('CGG_CRSEG_CODIGO').trim().length == 0) {
            flagHija = false;
        } else {
            flagHija = true;
        }
        return flagHija;
    }

    /**
     *Funcion. Consulta si el movimiento actual tiene subfase y devuelve el numero de las mismas.
     *@return Numero de fases.
     */
    function tieneSubfase() {                
        var flagSubfase = true;
        if(numFase >=1 && inRecordCgg_res_seguimiento.get('CRSEG_ESTADO_ATENCION') !== TypeEstadoAtencion.REVISADODISTRIBUIDO ){
            flagSubfase= confirm('El tr\u00e1mite actual tiene '+numFase+' fase(s) para revisi\u00f3n.\nEsta seguro de continuar?');
        }
        return flagSubfase;
    }

    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_seguimiento.
     * @returns ventana winFrmCgg_res_seguimiento.
     * @base FrmCgg_res_seguimiento.prototype.show
     */
    this.getWindow = function() {
        return winFrmCgg_res_seguimiento;

    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_seguimiento.
     * @param inHistorico Verdadero/falso Indica de donde proviene la apertura del seguimiento. Verdadero proviene del diagrama de historial de un tramite.
     * @base FrmCgg_res_seguimiento.prototype.loadData
     */
    this.loadData = function(inHistorico) {
        cargarCgg_res_seguimientoCtrls(inHistorico);
    }
	
    /**
	*Funcion que valida los requisitios del seguimiento que se cumplan antes de continuar con la aprobacion o negacion del tramite.
	*/
    function validarRequisitoFase(){
        var flag = true;
        for(var i =0;i<grdCgg_jur_seguimiento_criterio.getStore().getTotalCount();i++){
            var rRequisitoFase = grdCgg_jur_seguimiento_criterio.getStore().getAt(i);
            if(rRequisitoFase.get('CJCRI_REQUERIDO')==true){
                if(rRequisitoFase.get('CJSGC_RESPUESTA')!==true){
                    flag = false;
                }
            }
            if(flag == false)
                break;
        }
        return flag;
    }


    function bloquearSeguimiento(){
        Ext.getCmp('btnAgregarNovedad').disable();
        Ext.getCmp('btnEliminarNovedad').disable();
    }

    this.setVehiculo = function(){
        isVehiculo = true;
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_seguimiento desde una instancia.
 */
FrmCgg_res_seguimiento.prototype.show = function() {
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_seguimiento desde una instancia.
 */
FrmCgg_res_seguimiento.prototype.close = function() {
    this.getWindow().close();
}

/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_seguimiento,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_seguimiento.prototype.closeHandler = function(inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_seguimiento desde una instancia.
 * @parama inHistorico Verdadero/false. Establece si la apertura de un seguimiento viene de diagrama de historia de un tramite.
 */
FrmCgg_res_seguimiento.prototype.loadData = function(inHistorico) {
    this.loadData(inHistorico);
}

/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_seguimiento desde una instancia.
 */
FrmCgg_res_seguimiento.prototype.setVehiculo = function() {
    this.setVehiculo();
}
