/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_persona_juridica.
 * @param {String} INSENTENCIA_CGG_RES_PERSONA_JURIDICA Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_PERSONA_JURIDICA Registro de datos de la tabla Cgg_res_persona_juridica.
 * @constructor
 * @base FrmListadoCgg_res_persona_juridica
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_persona_juridica(INSENTENCIA_CGG_RES_PERSONA_JURIDICA,INRECORD_CGG_RES_PERSONA_JURIDICA,inEmpresa,inEditarEmpresa){
    var inSentenciaCgg_res_persona_juridica = INSENTENCIA_CGG_RES_PERSONA_JURIDICA;
    var inRecordCgg_res_persona_juridica=INRECORD_CGG_RES_PERSONA_JURIDICA;
    var urlCgg_res_persona_juridica=URL_WS+"Cgg_res_persona_juridica";
    var tituloCgg_res_persona_juridica='Registro de empresas';
    var descCgg_res_persona_juridica='El formulario permite administrar informaci\u00f3n de las empresas';
    var isEdit = false;
    var tmpSectorProductivo = null;
    var tmpVehiculoSector = null;
    var tmpDomicilio;
    var tmpRepresentanteLegal =  null;
    var tmpUserSession = new UserSession();
    var tmpPJDelCuentas = new Array();
    var codigoPreregistroEmpresa='';
    var codigoIslaPreregistroEmpresa='';
    var codigoPreregistroEmpresaDelete='';
    var codigoRepresentante='';
    var nombreAdjuntoRepresentante='';
    var urlCgg_gem_preregistro_empresa=URL_WS+"PublicWS/Cgg_gem_preregistro_empresa";
	var tmpInsertUser =false;
    var rFilaRepresentanteLegal = Ext.data.Record.create([
        'CRRPT_CODIGO',
        'CRPER_CODIGO',
        'CRPER_CODIGO_ANTERIOR',
        'CRPJR_CODIGO',
        'CRRPT_ACTIVO',
        'CRRPT_FECHA_REGISTRO'
    ]);
    var rRepresentanteLegal = new rFilaRepresentanteLegal({
        CRRPT_CODIGO:'KEYGEN',
        CRPER_CODIGO:'',
        CRPER_CODIGO_ANTERIOR:'',
        CRPJR_CODIGO:'KEYGEN',
        CRRPT_ACTIVO:TypeEstado.ACTIVO,
        CRRPT_FECHA_REGISTRO:new Date().format(TypeDateFormat.ISO8601Long)
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PERSONA JURIDICA
     */
    var txtCrpjr_codigo = new Ext.form.TextField({
        id:'txtCrpjr_codigo',
        name:'txtCrpjr_codigo',
        fieldLabel:'Codigo',
        anchor:'98%',
        allowBlank:false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength:20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE  SECTOR PRODUCTIVO
     */
    var txtCsctp_codigo = new Ext.form.TextField({
        id:'txtCsctp_codigo',
        name:'txtCsctp_codigo',
        fieldLabel:'Sector',
        anchor:'100%',
        readOnly:'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE  SECTOR PRODUCTIVO
     */
    var btnCsctp_codigoCgg_res_persona_juridica = new Ext.Button({
        id:'btnCsctp_codigoCgg_res_persona_juridica',
        iconCls:'iconBuscar',
        tooltip:'Buscar sector productivo',
        listeners:{
            click:function(){
                var tmpFLCgg_sector_productivo = new FrmListadoCgg_sector_productivo();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_sector_productivo.getStore(),tmpFLCgg_sector_productivo.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord!=null && tmpRecord!=undefined)
                    {
                        txtCsctp_codigo.setValue(tmpRecord.get('CSCTP_NOMBRE'));
                        tmpSectorProductivo=tmpRecord.get('CSCTP_CODIGO');
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
        fieldLabel:'Tipo',
        anchor:'100%',
        readOnly:'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE VEHICULO SECTOR
     */
    var btnCvsct_codigoCgg_res_persona_juridica = new Ext.Button({
        id:'btnCvsct_codigoCgg_res_persona_juridica',
        iconCls:'iconBuscar',
        tooltip:'Buscar tipo empresa',
        listeners:{
            click:function(){
                var tmpFLCgg_veh_sector = new FrmListadoCgg_veh_sector();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_veh_sector.getStore(),tmpFLCgg_veh_sector.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord!=null && tmpRecord!=undefined)
                    {
                        txtCvsct_codigo.setValue(tmpRecord.get('CVSCT_NOMBRE'));
                        tmpVehiculoSector=tmpRecord.get('CVSCT_CODIGO');
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField NOMBRE COMERCIAL DE LA PERSONA JURIDICA
     */
    var txtCrpjr_razon_social = new Ext.form.TextField({
        id:'txtCrpjr_razon_social',
        name:'txtCrpjr_razon_social',
        fieldLabel:'Raz\u00f3n social',
        anchor:'98%',
        allowBlank:false,
        maxLength:100
    });
    /**
     * Ext.form.TextField NUMERO DE IDENTIFICACION DE LA PERSONA JURIDICA
     */
    var txtCrpjr_numero_identificacion = new Ext.form.TextField({
        id:'txtCrpjr_numero_identificacion',
        name:'txtCrpjr_numero_identificacion',
        fieldLabel:'RUC/Ident.',
        anchor:'98%',
        allowBlank:false,
        maxLength:20
    });
    /**
     * Ext.form.DateField FECHA DE CONSTITUCION DE LA EMPRESA
     */
    var dtCrpjr_fecha_constitucion = new Ext.form.DateField({
        id:'dtCrpjr_fecha_constitucion',
        name:'dtCrpjr_fecha_constitucion',
        fieldLabel:'Creaci\u00F3n',
        allowBlank:false,
        value:new Date(),
        format:'d/m/Y',
        maxValue:CURRENT_DATE
    });
    /**
     * Ext.form.TextField DIRECCION DE LA PERSONA JURIDICA
     */
    var txtCrpjr_direccion = new Ext.form.TextField({
        id:'txtCrpjr_direccion',
        name:'txtCrpjr_direccion',
        fieldLabel:'Direcci\u00F3n',
        anchor:'98%'
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
     */
    var txtCctn_codigo = new Ext.form.TextField({
        id:'txtCctn_codigo',
        name:'txtCctn_codigo',
        fieldLabel :'Domicilio',
        anchor:'100%',
        readOnly:'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE CANTON
     */
    var btnCctn_codigoCgg_res_persona_juridica = new Ext.Button({
        id:'btnCctn_codigoCgg_res_persona_juridica',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_canton = new FrmListadoCgg_canton();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_canton.getStore(),tmpFLCgg_canton.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        tmpDomicilio = tmpRecord.get('CCTN_CODIGO');
                        txtCctn_codigo.setValue(tmpRecord.get('CCTN_NOMBRE'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField DESCRIPCION DE LA ACTIVIDAD A LA QUE SE DIDICA LA EMPRESA
     */
    var txtCrpjr_actividad = new Ext.form.TextField({
        id:'txtCrpjr_actividad',
        name:'txtCrpjr_actividad',
        fieldLabel:'Actividad',
        anchor:'98%',
        allowBlank:false
    });
    /**
     * Ext.form.NumberField NUMERO DE EMPLEADOS QUE CONFORMAN LA EMPRESA
     */
    var numCrpjr_numero_empleados = new Ext.ux.form.SpinnerField({
        id:'numCrpjr_numero_empleados',
        nname:'numCrpjr_numero_empleados',
        fieldLabel:'Empleados',
        anchor:'98%',
        minValue:1,
        value:1,
        allowDecimals:false
    });
    /**
     * Ext.form.TextField CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA REPRESENTANTE LEGAL
     */
    var txtPJCrper_codigo = new Ext.form.TextField({
        id: 'txtPJCrper_codigo',
        name: 'txtPJCrper_codigo',
        fieldLabel: 'Representante',
        anchor: '100%',
        readOnly: 'true'
    });
    /**
     * Ext.form.TextArea INFORMACION ADICIONAL
     */
    var txtCrpjr_observacion = new Ext.form.TextArea({
        id:'txtCrpjr_observacion',
        name:'txtCrpjr_observacion',
        fieldLabel :'Observaci\u00f3n',
        width:'98%',
        title:'Observaci\u00f3n'
    });
    /**
     * CODIGO IDENTIFICATIVO DE REGISTRO DE PERSONA
     */
    var btnCrper_codigoCgg_res_persona_juridica = new Ext.Button({
        id: 'btnCrper_codigoCgg_res_persona_juridica',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpBckTimeout = Ext.Ajax.timeout;
                Ext.Ajax.timeout = 90000;
                var tmpPersona = new Persona();
                var objBusqueda = new DlgBusqueda(tmpPersona.getStore(), tmpPersona.getCm());
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord){
                        //tmpRepresentanteLegal= tmpRecord.get('CRPER_CODIGO');
                        rRepresentanteLegal.set('CRPER_CODIGO',tmpRecord.get('CRPER_CODIGO'));
                        txtPJCrper_codigo.setValue(tmpRecord.get('CRPER_NOMBRES')+' '+tmpRecord.get('CRPER_APELLIDO_PATERNO')+' '+tmpRecord.get('CRPER_APELLIDO_MATERNO'));
                    }
                    Ext.Ajax.timeout = tmpBckTimeout;
                });
                objBusqueda.show();
            }
        }
    });
    function AsignarRol(usuario,rol){
        function CallBackCgg_sec_perfil_rol(r) {
            if (r == 'true') {

            } else {

            }
        }
        var param = new SOAPClientParameters();

        param.add('inCsrol_codigo', rol);
        param.add('inCusu_codigo', usuario);
        SOAPClient.invoke(URL_WS + "Cgg_sec_usuario_rol", 'insert', param, true, CallBackCgg_sec_perfil_rol);
    }
    /**
     *Ext.form.ComboBox Combox para el ingreso de tipo de persona juridica interna/externa
     */
    var cbxCRPJR_TipoPersonaJuridica = new Ext.form.ComboBox({
        id:'cbxCRPJR_TipoPersonaJuridica',
        fieldLabel:'Localidad',
        store:dsTipoPersonaJuridica,
        typeAhead: true,
        anchor:'98%',
        mode: 'local',
        triggerAction:'all',
        editable:false,
        forceSelection:true,
        allowBlank:false
    });
    function fnCrearUsuario(codigoPJ,cantonUsuario,codigoIsla){
        function CallBackCgg_usuario(r) {
            if (r == 'true') {
                function CallBackCgg_usuario_codigo(r) {
                    var a = eval("("+r+")")
                    AsignarRol(a[0].CUSU_CODIGO,'CSROL_GEEMP');
                    AsignarRol(a[0].CUSU_CODIGO,'1');
                    AsignarRol(a[0].CUSU_CODIGO,'2');
                    Ext.Msg.show({
                        title:tituloCgg_res_persona_juridica,
                        msg: 'La informaci\u00f3n de persona jur\u00EDdica ha sido almacenada.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    winFrmCgg_res_persona_juridica.close();

                }
                var param = new SOAPClientParameters();
                param.add('inCusu_nombre_usuario', tmpUsuario);
                param.add('format', 'JSON');
                SOAPClient.invoke(URL_WS + "Cgg_usuario", "selectCodigoUsuarioByIdUsuario", param, true, CallBackCgg_usuario_codigo);



            } else {
                Ext.Msg.show({
                    title: 'Usuario',
                    msg: 'La informaci\u00f3n de Usuario no ha podido ser almacenada. '+(r.message?r.message:r),
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
            }
        }
        var tmpUsuario =  txtCrpjr_razon_social.getValue().replace(/[.]+/g, "");
        tmpUsuario =  tmpUsuario.replace(/[ ]+/g, "_");
        tmpUsuario = tmpUsuario.toLowerCase();
        var param = new SOAPClientParameters();
        param.add('inCrcrg_codigo', null);
        param.add('inCrper_codigo', rRepresentanteLegal.get('CRPER_CODIGO'));
        param.add('inCrpjr_codigo', codigoPJ);
        param.add('inCctn_codigo', cantonUsuario);
        param.add('inCisla_codigo', codigoIsla);
        param.add('inCusu_nombre_usuario', tmpUsuario);
        param.add('inCusu_clave_acceso', txtCrpjr_numero_identificacion.getValue());
        param.add('inCusu_usuario_interno', false);
        param.add('inCusu_caduca_clave', true);
        param.add('inCusu_activo', true);
        param.add('inCusu_cambiar_clave',true);
        param.add('inCusu_fecha_clave_act', new Date());
        param.add('inPersona', null);
        SOAPClient.invoke(URL_WS + "Cgg_usuario", "insert", param, true, CallBackCgg_usuario);
    }

    var btnGuardarCgg_res_persona_juridica = new Ext.Button({
        id:'btnGuardarCgg_res_persona_juridica',
        text:'Guardar',
        iconCls:'iconGuardar',
        tooltip:'Guaradar persona jur\u00EDdica',
        listeners:{
            click:function(){
                if(numCrpjr_numero_empleados.getValue() < 0){
                    Ext.Msg.show({
                        title:tituloCgg_res_persona_juridica,
                        msg: 'El numero de empleados no puede ser menor a 0.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.ERROR
                    });
                    return;
                }
                if (pnlCgg_res_persona_juridica.getForm().isValid()==false){
                    return;
                }
                /**
                 *	GUARDAR DESDE GESTION DE EMPLEO
                 **/
                if(inEmpresa && tmpInsertUser){
                    try{
                        function CallBackCgg_res_persona_juridicaGE(r){
                            winFrmCgg_res_persona_juridica.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloCgg_res_persona_juridica,
                                    msg: 'La informaci\u00f3n de persona jur\u00eddica ha sido almacenada correctamente. ',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                winFrmCgg_res_persona_juridica.close();
                            }else{
                                Ext.Msg.show({
                                    title:tituloCgg_res_persona_juridica,
                                    msg: 'La informaci\u00f3n de persona jur\u00eddica no ha podido ser almacenada. '+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                        }
                        winFrmCgg_res_persona_juridica.getEl().mask('Guardando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        var tmpPJuridicaRepresentante = '['+Ext.util.JSON.encode(rRepresentanteLegal.data)+']';
                        if(isEdit)
                            param.add('inCrpjr_codigo',txtCrpjr_codigo.getValue());
                        param.add('inCsctp_codigo',tmpSectorProductivo?tmpSectorProductivo:null);
                        param.add('inCvsct_codigo',tmpVehiculoSector?tmpVehiculoSector:null);
                        param.add('inCctn_codigo',(tmpDomicilio?tmpDomicilio:null));
                        param.add('inCrpjr_razon_social',txtCrpjr_razon_social.getValue());
                        param.add('inCrpjr_numero_identificacion',txtCrpjr_numero_identificacion.getValue());
                        param.add('inCrpjr_fecha_constitucion',dtCrpjr_fecha_constitucion.getValue().format('c'));
                        param.add('inCrpjr_direccion',txtCrpjr_direccion.getValue());
                        param.add('inCrpjr_actividad',txtCrpjr_actividad.getValue());
                        param.add('inCrpjr_numero_empleados',numCrpjr_numero_empleados.getValue());
                        param.add('inCrpjr_observacion',txtCrpjr_observacion.getValue()?txtCrpjr_observacion.getValue():null);
                        param.add('inCrpjr_tipo',cbxCRPJR_TipoPersonaJuridica.getValue()?cbxCRPJR_TipoPersonaJuridica.getValue():0);
                        param.add('inPJuridicaRepresentante_JSON',txtPJCrper_codigo.getValue()?tmpPJuridicaRepresentante:'[]') ;
                        param.add('inPJuridicaContacto_JSON',grdCgg_res_pjuridica_contacto.getStore().getJsonData());
                        param.add('inPJuridicaCuentas_JSON',grdCgg_res_cuenta_personajuridica.getStore().getJsonData());
                        param.add('inCgpre_codigo',codigoPreregistroEmpresa);
                        param.add('inCgpre_cisla_codigo',codigoIslaPreregistroEmpresa?codigoIslaPreregistroEmpresa:null);
                        SOAPClient.invoke(urlCgg_res_persona_juridica,INSENTENCIA_CGG_RES_PERSONA_JURIDICA + 'All'+'GestionEmpleo',param, true, CallBackCgg_res_persona_juridicaGE);
                    }catch(inErr){
                        winFrmCgg_res_persona_juridica.getEl().unmask();
                    }
                }else{
                    try{
                        function CallBackCgg_res_persona_juridica(r){
                            winFrmCgg_res_persona_juridica.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloCgg_res_persona_juridica,
                                    msg: 'La informaci\u00f3n de persona jur\u00EDdica ha sido almacenada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                winFrmCgg_res_persona_juridica.close();
                            }else{
                                Ext.Msg.show({
                                    title:tituloCgg_res_persona_juridica,
                                    msg: 'La informaci\u00f3n de persona jur\u00eddica no ha podido ser almacenada. '+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                        }
                        winFrmCgg_res_persona_juridica.getEl().mask('Guardando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        var tmpPJuridicaRepresentante = '['+Ext.util.JSON.encode(rRepresentanteLegal.data)+']';
                        if(isEdit)
                            param.add('inCrpjr_codigo',txtCrpjr_codigo.getValue());
                        param.add('inCsctp_codigo',tmpSectorProductivo?tmpSectorProductivo:null);
                        param.add('inCvsct_codigo',tmpVehiculoSector?tmpVehiculoSector:null);
                        param.add('inCctn_codigo',(tmpDomicilio?tmpDomicilio:null));
                        param.add('inCrpjr_razon_social',txtCrpjr_razon_social.getValue());
                        param.add('inCrpjr_numero_identificacion',txtCrpjr_numero_identificacion.getValue());
                        param.add('inCrpjr_fecha_constitucion',dtCrpjr_fecha_constitucion.getValue().format('c'));
                        param.add('inCrpjr_direccion',txtCrpjr_direccion.getValue()?txtCrpjr_direccion.getValue():null);
                        param.add('inCrpjr_actividad',txtCrpjr_actividad.getValue()?txtCrpjr_actividad.getValue():null);
                        param.add('inCrpjr_numero_empleados',numCrpjr_numero_empleados.getValue());
                        param.add('inCrpjr_tipo',cbxCRPJR_TipoPersonaJuridica.getValue()?cbxCRPJR_TipoPersonaJuridica.getValue():0);
                        param.add('inCrpjr_observacion',txtCrpjr_observacion.getValue()?txtCrpjr_observacion.getValue():null);
                        param.add('inPJuridicaRepresentante_JSON',txtPJCrper_codigo.getValue()?tmpPJuridicaRepresentante:'[]') ;
                        param.add('inPJuridicaContacto_JSON',grdCgg_res_pjuridica_contacto.getStore().getJsonData());
                        param.add('inPJuridicaCuentas_JSON',grdCgg_res_cuenta_personajuridica.getStore().getJsonData());
                        SOAPClient.invoke(urlCgg_res_persona_juridica,INSENTENCIA_CGG_RES_PERSONA_JURIDICA + 'All',param, true, CallBackCgg_res_persona_juridica);
                    }catch(inErr){
                        winFrmCgg_res_persona_juridica.getEl().unmask();
                    }
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_persona_juridica.
     */
    var btnCancelarCgg_res_persona_juridica = new Ext.Button({
        id:'btnCancelarCgg_res_persona_juridica',
        text:'Cancelar',
        iconCls:'iconCancelar',
        tooltip:'Cancelar informaci\u00f3n',
        listeners:{
            click:function(){
                pnlCgg_res_persona_juridica.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_persona_juridica.
     */
    var btnCerrarCgg_res_persona_juridica = new Ext.Button({
        id:'btnCerrarCgg_res_persona_juridica',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerrar formulario',
        listeners:{
            click:function(){
                winFrmCgg_res_persona_juridica.close();
            }
        }
    });
    ////////////////////////////////////////////////////////
    /**
     *Ext.form.ComboBox Combo para edicion de tipo de contacto.
     */
    var cbxCRTCO_CODIGOEditor = new Ext.form.ComboBox({
        id:'cbxCRTCO_CODIGOEditor',
        store: SCGG_RES_TIPO_CONTACTO,
        displayField:'CRTCO_NOMBRE',
        typeAhead: true,
        mode:'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un tipo',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CRTCO_NOMBRE}" class="x-combo-list-item">{CRTCO_NOMBRE}</div></tpl>',
        valueField:'CRTCO_CODIGO'
    });
    /**
     * Ext.form.TextField para el ingreso del contacto
     */
    var txtCTAGC_CONTACTOEditor = new Ext.form.TextField({
        id:'txtCTAGC_CONTACTOEditor',
        emptyText:'Establezca el contacto',
        allowBlank:false
    });
    /**
     * Ext.form.TextField para el ingreso de la descripcion
     */
    var txtCTAGC_DESCRIPCIONEditor = new Ext.form.TextField({
        id:'txtCTAGC_DESCRIPCIONEditor',
        emptyText:'Establezca una descripci\u00F3n'

    });
    /**
     * Ext.ux.grid.RowEditor Editor de filas personalizado para utilizacion en el grid de contacto
     */
    var reContacto= new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        cancelText:'Cancelar',
        listeners:{
            validateedit:function(inRowEditor,inObject,inRecord,inRowIndex){
                marcarPredeterminado(inObject.CRPJC_PRINCIPAL,inRowIndex);

            },
            canceledit:function(inRowEditor,inFlag){
                var inRecord=grdCgg_res_pjuridica_contacto.getStore().getAt(0);
                if((inRecord.get('CRPJC_CODIGO')) =='KEYGEN')
                {
                    grdCgg_res_pjuridica_contacto.getStore().remove(inRecord);
                }
            }
        }
    });

    /**
     * Ext.ColumnModel Agrupacion de registros de la tabla Cgg_res_pjuridica_contacto por un campo especifico.
     */
    var cmCgg_res_pjuridica_contacto = new Ext.grid.ColumnModel([
        {dataIndex:'CRPJC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPJR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRTCO_CODIGO',header:'Tipo',width:40,sortable:true,
            editor:cbxCRTCO_CODIGOEditor,renderer:
                function(value, metaData, record,rowIndex){
                    var tmpHtml = null;
                    var tmpNombreImagen = null;
                    var rTipoContaco= record;
                    try{
                        rTipoContaco=SCGG_RES_TIPO_CONTACTO.getAt(SCGG_RES_TIPO_CONTACTO.findExact('CRTCO_CODIGO',value));
                        tmpNombreImagen = rTipoContaco.get('CRTCO_NOMBRE_IMAGEN');
                        new Ajax.Request(URL_DOC_VIEWER, {
                            onSuccess: function(response) {
                                tmpHtml = '<div><img src="/siiws/tmp/'+tmpUserSession.getUserName().trim()+'/'+ tmpNombreImagen +'" alt= "'+ rTipoContaco.get('CRTCO_NOMBRE')+'"/></div>';
                            },
                            onFailure:function(response){
                            },
                            asynchronous:false,
                            parameters:{
                                table:'cgg_res_tipo_contacto',
                                keyc:'crtco_codigo',
                                keyv:rTipoContaco.get('CRTCO_CODIGO'),
                                column:'crtco_imagen',
                                fn:tmpNombreImagen,
                                request:'view'
                            }
                        });
                        return tmpHtml;
                    }
                    catch(inError)
                    {
                        return 'codigo';
                    }
                }},

        {dataIndex:'CRPJC_CONTACTO',header:'Contacto',width:150,sortable:true, editor:txtCTAGC_CONTACTOEditor},
        {dataIndex:'CRPJC_DESCRIPCION',header:'Descripci\u00f3n',width:150,sortable:true,hidden:true,editor:txtCTAGC_DESCRIPCIONEditor},
        {dataIndex:'CRPJC_PRINCIPAL',header:'Principal',width:50,sortable:true,xtype:'checkcolumn',editor: {
            xtype: 'checkbox'
        }}
    ]);


    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_tct_agencia_contacto por un campo especifico.
     */
    var gsCgg_res_pjuridica_contacto = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_pjuridica_contacto",
            method:"selectPJuridicaContacto",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
            id:'CRPJC_CODIGO'
        },[
            {name:'CRPJC_CODIGO'},
            {name:'CRPJR_CODIGO'},
            {name:'CRTCO_CODIGO'},
            {name:'CRPJC_DESCRIPCION'},
            {name:'CRPJC_CONTACTO'},
            {name:'CRPJC_PRINCIPAL'}
        ]),
        sortInfo: {
            field: 'CRPJC_PRINCIPAL',
            direction: 'DESC'
        },
        baseParams:{inCrpjr_codigo:"",format:"JSON"}
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_persona_contacto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_pjuridica_contacto = new Ext.grid.EditorGridPanel({
        cm:cmCgg_res_pjuridica_contacto,
        store:gsCgg_res_pjuridica_contacto,
        anchor:'100% 100%',
        viewConfig:{forceFit:true},
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        plugins:[reContacto]
    });


    function marcarPredeterminado(inValue,inRowIndex)
    {
        if(inValue == true)
        {
            for(var i =0;i<grdCgg_res_pjuridica_contacto.getStore().getCount();i++){
                if(i != inRowIndex)
                {
                    grdCgg_res_pjuridica_contacto.getStore().getAt(i).set('CRPJC_PRINCIPAL',TypeEstado.INACTIVO);
                }
            }
        }
    }

    var pnlCgg_res_pjuridica_contacto = new Ext.Panel({
        labelWidth:100,
        title:'Contactos',
        layout:'form',
        frame:false,
        height:200,
        tbar:[{
            iconCls:'iconNuevo',
            tooltip:'Agregar contacto',
            handler:function(){
                var tmpRecordPJuridicaContacto = grdCgg_res_pjuridica_contacto.getStore().recordType;
                reContacto.stopEditing();
                grdCgg_res_pjuridica_contacto.getStore().insert(0,
                        new tmpRecordPJuridicaContacto({
                            CRPJC_CODIGO:'KEYGEN',
                            CRPJR_CODIGO:'',
                            CRTCO_CODIGO: '',
                            CRPJC_DESCRIPCION: '',
                            CRPJC_CONTACTO: '',
                            CRPJC_PRINCIPAL:false

                        })
                        );
                grdCgg_res_pjuridica_contacto.getView().refresh();
                grdCgg_res_pjuridica_contacto.getSelectionModel().selectRow(0);
                reContacto.startEditing(0);
            }
        },{
            iconCls:'iconEliminar',
            tooltip:'Eliminar contacto',
            handler:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRgrdCgg_res_pjuridica_contacto,icon: Ext.MessageBox.QUESTION});
                function SWRgrdCgg_res_pjuridica_contacto(btn){
                    if (btn=='yes')
                    {
                        try{
                            function CallBackgrdCgg_res_pjuridica_contacto(r){
                                winFrmCgg_res_persona_juridica.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloCgg_res_persona_juridica,
                                        msg: 'La informaci\u00f3n del Contacto ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    var seleccionado = grdCgg_res_pjuridica_contacto.getSelectionModel().getSelected();
                                    if(seleccionado != null ){
                                        grdCgg_res_pjuridica_contacto.getStore().remove(seleccionado);
                                    }
                                }else{
                                    Ext.Msg.show({
                                        title:tituloCgg_res_persona_juridica,
                                        msg: 'La informaci\u00f3n de Contacto no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }}
                            winFrmCgg_res_persona_juridica.getEl().mask('Eliminando...', 'x-mask-loading');
                            if(grdCgg_res_pjuridica_contacto.getSelectionModel().getSelected().get('CRPJC_CODIGO') != 'KEYGEN')
                            {
                                var param = new SOAPClientParameters();
                                param.add('inCrpjc_codigo',grdCgg_res_pjuridica_contacto.getSelectionModel().getSelected().get('CRPJC_CODIGO'));
                                SOAPClient.invoke(URL_WS+"Cgg_res_pjuridica_contacto","delete",param, true, CallBackgrdCgg_res_pjuridica_contacto);
                            }
                            else
                            {
                                grdCgg_res_pjuridica_contacto.getStore().remove(grdCgg_res_pjuridica_contacto.getSelectionModel().getSelected());
                                winFrmCgg_res_persona_juridica.getEl().unmask();
                            }

                        }catch(inErr){
                            winFrmCgg_res_persona_juridica.getEl().unmask();
                        }
                    }
                }
            }
        }],
        items:[grdCgg_res_pjuridica_contacto]
    });
    /////////////////////////////////////////////////////////
    var btnCrpjr_razon_social = new Ext.Button({
        id:'btnCrpjr_razon_social',
        text:'Pre-registrados',
        iconCls:'iconBuscar',
        tooltip:'Buscar persona jur\u00EDdica pre-registrada',
        listeners:{
            click:function(){
                var objCgg_gem_preregistroEmpresa = new Cgg_preregistro_empresa_data();
                var objBusqueda = new DlgBusqueda(objCgg_gem_preregistroEmpresa.store,objCgg_gem_preregistroEmpresa.columnModel);
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
						tmpInsertUser = true;
                        txtCrpjr_razon_social.setValue(tmpRecord.get('CGPRE_RAZON_SOCIAL'));
                        txtCrpjr_numero_identificacion.setValue(tmpRecord.get('CGPRE_RUC'));
                        txtCrpjr_direccion.setValue(tmpRecord.get('CGPRE_DIRECCION'));
                        codigoPreregistroEmpresa = tmpRecord.get('CGPRE_CODIGO');
                        codigoIslaPreregistroEmpresa = tmpRecord.get('CGPRE_CISLA_CODIGO');

                        nombreAdjuntoRepresentante = tmpRecord.get('CGPRE_NOMBRE_ADJUNTO');
                        tmpDomicilio = tmpRecord.get('CGPRE_CCTN_CODIGO');
                        var params = new SOAPClientParameters();
                        params.add('inCctn_codigo',tmpRecord.get('CGPRE_CCTN_CODIGO'));
                        params.add('format',TypeFormat.JSON);
                        var tmpModulo = SOAPClient.invoke(URL_WS+"Cgg_canton", 'select', params, false, null);
                        try{
                            tmpModulo = Ext.util.JSON.decode(tmpModulo);
                            txtCctn_codigo.setValue(tmpModulo[0].CCTN_NOMBRE);
                        }catch(inErr){
                            txtCctn_codigo.setValue(NO_DATA_MESSAGE);
                        }
                        rRepresentanteLegal.set('CRPER_CODIGO',tmpRecord.get('CGPRE_REPRESENTANTE'));

                        if(nombreAdjuntoRepresentante){
                            btnCrpjr_verAdjunto.setDisabled(false);
                            btnCrpjr_verAdjunto.setIconClass('iconVerAdjunto');
                        }
                        function CallBackgrdCgg_res_personaDatos(v){
                            var a = eval('('+v+')');
                            if(a.length>0){
                                txtPJCrper_codigo.setValue(a[0].CRPER_NOMBRES+' '+a[0].CRPER_APELLIDO_PATERNO+' '+a[0].CRPER_APELLIDO_MATERNO);
                            }
                        }
                        var param = new SOAPClientParameters();
                        param.add('inCrper_codigo',tmpRecord.get('CGPRE_REPRESENTANTE'));
                        param.add('format','JSON');
                        SOAPClient.invoke(URL_WS+"Cgg_res_persona","select",param, true, CallBackgrdCgg_res_personaDatos);

                        txtCrpjr_actividad.setValue(tmpRecord.get('CGPRE_ACTIVIDAD'));
                        dtCrpjr_fecha_constitucion.setValue(tmpRecord.get('CGPRE_FECHA_CREACION'));
                        tmpSectorProductivo = tmpRecord.get('CGPRE_SECTOR');
                        codigoSectorProductivo = tmpRecord.get('CGPRE_SECTOR');
                        function CallBackgrdCgg_sectorProductivo(v){
                            var a = eval('('+v+')');
                            if(a.length>0){
                                txtCsctp_codigo.setValue(a[0].CSCTP_NOMBRE);
                            }
                        }
                        var param = new SOAPClientParameters();
                        param.add('inCsctp_codigo',tmpRecord.get('CGPRE_SECTOR'));
                        param.add('format','JSON');
                        SOAPClient.invoke(URL_WS+"Cgg_sector_productivo","select",param, true, CallBackgrdCgg_sectorProductivo);


                        tmpVehiculoSector=tmpRecord.get('CGPRE_TIPO');
                        codigoVehiculo = tmpRecord.get('CGPRE_TIPO');
                        function CallBackgrdCgg_tipo(v){
                            var a = eval('('+v+')');
                            if(a.length>0){
                                txtCvsct_codigo.setValue(a[0].CVSCT_NOMBRE);
                            }
                        }
                        var param = new SOAPClientParameters();
                        param.add('inCvsct_codigo',tmpRecord.get('CGPRE_TIPO'));
                        param.add('format','JSON');
                        SOAPClient.invoke(URL_WS+"Cgg_veh_sector","select",param, true, CallBackgrdCgg_tipo);

                        numCrpjr_numero_empleados.setValue(tmpRecord.get('CGPRE_NUMERO_EMPLEADO')?tmpRecord.get('CGPRE_NUMERO_EMPLEADO'):0);
                        cbxCRPJR_TipoPersonaJuridica.setValue(0);

                        grdCgg_res_pjuridica_contacto.getStore().removeAll();
                        grdCgg_res_pjuridica_contacto.removeAll(true);

                        var tmpRecordPJuridicaContacto = grdCgg_res_pjuridica_contacto.getStore().recordType;
                        grdCgg_res_pjuridica_contacto.getStore().insert(0,
                                new tmpRecordPJuridicaContacto({
                                    CRPJC_CODIGO:'KEYGEN',
                                    CRPJR_CODIGO:'',
                                    CRTCO_CODIGO: 'CRTCO3',
                                    CRPJC_DESCRIPCION: '',
                                    CRPJC_CONTACTO: tmpRecord.get('CGPRE_TELEFONO'),
                                    CRPJC_PRINCIPAL:false
                                })
                                );
                        grdCgg_res_pjuridica_contacto.getStore().insert(0,
                                new tmpRecordPJuridicaContacto({
                                    CRPJC_CODIGO:'KEYGEN',
                                    CRPJR_CODIGO:'',
                                    CRTCO_CODIGO: 'CRTCO1',
                                    CRPJC_DESCRIPCION: '',
                                    CRPJC_CONTACTO: tmpRecord.get('CGPRE_EMAIL'),
                                    CRPJC_PRINCIPAL:false
                                })
                                );
                        grdCgg_res_pjuridica_contacto.getView().refresh();
                    }
                });
                objBusqueda.show();
            }
        }
    });
    var colRazonSocial ={
        xtype:'panel',
        layout:'column',
        items:[{
            columnWidth:.77,
            layout:'form',
            items:[txtCrpjr_numero_identificacion]
        },{
            columnWidth:.23,
            layout:'form',
            items:[btnCrpjr_razon_social]
        }]
    };
    var btnCrpjr_verAdjunto = new Ext.Button({
        id:'btnCrpjr_verAdjunto',
        text:'',
        iconCls:'iconCargando',
        //fieldLabel :'Adjunto',
        disabled : true,
        tooltip:'Ver adjunto del representante legal de la empresa',
        hidden:inEmpresa?false:inEditarEmpresa?false:true,
        listeners:{
            click:function(){
                if(codigoPreregistroEmpresa && nombreAdjuntoRepresentante){
                    var url1 = URL_DOC_VIEWER+'?table=cgg_gem_preregistro_empresa&keyc=cgpre_codigo&keyv='+codigoPreregistroEmpresa +'&column=cgpre_adjunto&fn='+nombreAdjuntoRepresentante+'&request=view';
                    window.open(url1);
                }
            }
        }
    });
    function actualizarArchivo(){
        function CallBackCgg_gem_preregistro_codigo1(r){
            codigoPreregistroEmpresa=r;
            if(r){
                if(cgpre_adjunto.getValue().length==0)return;
                var a = cgpre_adjunto.getValue().split('\\');
                var b = cgpre_adjunto.getValue().split('.');
                nombreAdjuntoRepresentante = a[a.length-1];
                pnlCgg_res_persona_juridica.getForm().submit({
                    url: URL_WS+"/Cgg_gem_preregistroEmpresa_actualizarAdjuntoSRV",
                    waitMsg: 'Enviando formulario...',
                    success: function(fp, o){
                        Ext.Msg.show({
                            title:'Adjunto Empresa',
                            msg: 'El adjunto ha sido almacenado correctamente.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                    },
                    failure:function(r){
                        Ext.Msg.show({
                            title:'Adjunto Empresa',
                            msg: 'El adjunto no ha podido ser almacenado.'+(r.message?r.message:r),
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    },
                    params: {request:'update',
                        cgpre_codigo: codigoPreregistroEmpresa,
                        cgpre_tipo_adjunto: b[b.length-1],
                        cgpre_nombre_adjunto : a[a.length-1]
                    }
                });

            }
        }
        var param = new SOAPClientParameters();
        param.add('inCrpjr_codigo',txtCrpjr_numero_identificacion.getValue());
        SOAPClient.invoke(urlCgg_gem_preregistro_empresa,'selectCodigoByRUC',param, true, CallBackCgg_gem_preregistro_codigo1);
    }
    var cgpre_adjunto = new Ext.form.FileUploadField({
        id: 'cgpre_adjunto',
        name: 'cgpre_adjunto',
        fieldLabel: 'Adjunto',
        anchor: '98%',
        width : 100,
        disabled: false,
        hidden: (inEditarEmpresa)?false:true,
        buttonCfg: {
            text: '',
            iconCls: 'iconAdjunto'
        },
        listeners: {
            'fileselected': function(fb, v){
                if(inEditarEmpresa){
                    function CallBackCgg_gem_preregistro_codigo(r){
                        if(r){
                            actualizarArchivo();
                        }else{
                            if (pnlCgg_res_persona_juridica.getForm().isValid()==false){
                                return;
                            }
                            try{
                                function CallBackCgg_gem_preregistro_empresas(r){
                                    if(r=='true'){
                                        actualizarArchivo();
                                    }
                                }
                                var param = new SOAPClientParameters();
                                param.add('inCgpre_razon_social',txtCrpjr_razon_social.getValue());
                                param.add('inCgpre_ruc',txtCrpjr_numero_identificacion.getValue());
                                param.add('inCgpre_representante',rRepresentanteLegal.get('CRPER_CODIGO'));
                                param.add('inCgpre_fecha_creacion',dtCrpjr_fecha_constitucion.getValue().format('c'));
                                param.add('inCgpre_actividad',txtCrpjr_actividad.getValue());
                                param.add('inCgpre_direccion',txtCrpjr_direccion.getValue());
                                param.add('inCgpre_sector',tmpSectorProductivo);
                                param.add('inCgpre_tipo',tmpVehiculoSector);
                                param.add('inCgpre_numero_empleado',numCrpjr_numero_empleados.getValue());
                                SOAPClient.invoke(urlCgg_gem_preregistro_empresa,'insert',param, true, CallBackCgg_gem_preregistro_empresas);
                            }catch(inErr){
                                winFrmCgg_res_persona_juridica.getEl().unmask();
                            }
                        }
                    }
                    var param = new SOAPClientParameters();
                    param.add('inCrpjr_codigo',txtCrpjr_numero_identificacion.getValue());
                    SOAPClient.invoke(urlCgg_gem_preregistro_empresa,'selectCodigoByRUC',param, true, CallBackCgg_gem_preregistro_codigo);
                }
            }
        }
    });

    var colCreacionAdjunto ={
        xtype:'panel',
        layout:'column',
        items:[{
            columnWidth:.50,
            layout:'form',
            items:[dtCrpjr_fecha_constitucion]
        },{
            columnWidth:.38,
            layout:'form',
            labelWidth:50,
            items:[cgpre_adjunto]
        },{
            columnWidth:.12,
            layout:'form',
            items:[btnCrpjr_verAdjunto]
        }

        ]
    };
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_persona_juridica.
     */
    var pnlCgg_res_persona_juridica = new Ext.form.FormPanel({
        frame:true,
        region:'center',
        fileUpload:true,
        items:[txtCrpjr_codigo,
            inEmpresa?colRazonSocial:txtCrpjr_numero_identificacion,
            txtCrpjr_razon_social,
            {
                xtype:'panel',
                layout:'column',
                items:[{
                    columnWidth:.92,
                    layout:'form',
                    items:[txtPJCrper_codigo]
                },{
                    columnWidth:.08,
                    layout:'form',
                    items:[btnCrper_codigoCgg_res_persona_juridica]
                }]
            },
            colCreacionAdjunto,
            txtCrpjr_actividad,
            txtCrpjr_direccion,
            {xtype:'panel',layout:'column',items:[{columnWidth:.92,layout:'form',items:[txtCctn_codigo]},{columnWidth:.08,layout:'form',items:[btnCctn_codigoCgg_res_persona_juridica]}]},
            {
                xtype:'panel',
                layout:'column',
                anchor:'100%',
                items:[{
                    columnWidth:.5,
                    layout:'form',
                    items:[{
                        xtype:'panel',
                        layout:'column',
                        anchor:'100%',
                        items:[{
                            columnWidth:.9,
                            layout:'form',
                            items:[txtCsctp_codigo]
                        },{
                            columnWidth:.1,
                            layout:'form',
                            items:[btnCsctp_codigoCgg_res_persona_juridica]
                        }]
                    }]
                },{
                    columnWidth:.5,
                    layout:'form',
                    items:[{
                        xtype:'panel',
                        layout:'column',
                        anchor:'100%',
                        items:[{
                            columnWidth:.9,
                            layout:'form',
                            items:[txtCvsct_codigo]
                        },{
                            columnWidth:.1,
                            layout:'form',
                            items:[btnCvsct_codigoCgg_res_persona_juridica]
                        }]
                    }]
                }]
            }

            ,
            {
                xtype:'panel',
                layout:'column',
                anchor:'100%',
                items:[{
                    columnWidth:.5,
                    layout:'form',
                    items:[numCrpjr_numero_empleados]
                },{
                    columnWidth:.5,
                    layout:'form',
                    items:[cbxCRPJR_TipoPersonaJuridica]
                }]
            }]
    });
    var btnPJAddCuenta = new Ext.Button({
        id:'btnPJAddCuenta',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var tmpPJCuenta = gsCgg_res_cuenta_personajuridica.recordType;
                var tmpPJCuentaRecord = new tmpPJCuenta({
                    CRCPJ_CODIGO:'KEYGEN',
                    CRETF_CODIGO:'',
                    CRPJR_CODIGO:txtCrpjr_codigo.getValue(),
                    CRPER_CODIGO:'',
                    CRCPJ_NUMERO_CUENTA:'',
                    CRCPJ_DESCRIPCION:'',
                    CRCPJ_TIPO_CUENTA:0,
                    TITULAR:'',
                    CRETF_NOMBRE_ENTIDAD:''
                });
                var tmpCuenta = new FrmCgg_res_cuenta_personajuridica(false, tmpPJCuentaRecord);
                tmpCuenta.closeHandler(function(){
                    gsCgg_res_cuenta_personajuridica.insert(0, tmpPJCuentaRecord);
                });
                tmpCuenta.show();
            }}
    });
    var btnPJDelCuenta = new Ext.Button({
        id:'btnPJDelCuenta',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                tmpPJDelCuentas.push(grdCgg_res_cuenta_personajuridica.getSelectionModel().getSelected().get('CRCPJ_CODIGO'));
                grdCgg_res_cuenta_personajuridica.getStore().remove(grdCgg_res_cuenta_personajuridica.getSelectionModel().getSelected());
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_cuenta_personajuridica.
     */
    var cmCgg_res_cuenta_personajuridica = new Ext.grid.ColumnModel([
        {dataIndex:'TITULAR',header:'Titular',width:200,sortable:true},
        {dataIndex:'CRPJR_RAZON_SOCIAL',header:'Entidad financiera',width:150,sortable:true},
        {dataIndex:'CRCPJ_NUMERO_CUENTA',header:'Numero de cuenta',width:150,sortable:true},
        {dataIndex:'CRCPJ_TIPO_CUENTA',header:'Tipo de cuenta',width:150,sortable:true,renderer:function(inData){
            return dsTipoCuentaBancaria[inData][1];
        }},
        {dataIndex:'CRCPJ_DESCRIPCION',header:'Descripci\u00f3n',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_cuenta_personajuridica por un campo especifico.
     */
    var gsCgg_res_cuenta_personajuridica = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_cuenta_personajuridica",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRCPJ_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRCPJ_CODIGO'},
            {name:'CGG_CRPJR_CODIGO'},
            {name:'CRPJR_CODIGO'},
            {name:'CRPER_CODIGO'},
            {name:'TITULAR'},
            {name:'CRPJR_RAZON_SOCIAL'},
            {name:'CRCPJ_NUMERO_CUENTA'},
            {name:'CRCPJ_DESCRIPCION'},
            {name:'CRCPJ_TIPO_CUENTA'}
        ]),
        baseParams:{keyword:"",format:'JSON',inCrpjr_codigo:''}
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_cuenta_personajuridica en un formato tabular de filas y columnas.
     */
    var grdCgg_res_cuenta_personajuridica = new Ext.grid.EditorGridPanel({
        id:'grdCgg_res_cuenta_personajuridica',
        title:'Cuentas bancarias',
        cm:cmCgg_res_cuenta_personajuridica,
        store:gsCgg_res_cuenta_personajuridica,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [btnPJAddCuenta,btnPJDelCuenta]
    });
    var tbPJOpciones = new Ext.TabPanel({
        activeTab:0,
        region:'south',
        items:[pnlCgg_res_pjuridica_contacto,grdCgg_res_cuenta_personajuridica,txtCrpjr_observacion]
    });
    if(inEmpresa || inEditarEmpresa){
        tbPJOpciones.getItem('grdCgg_res_cuenta_personajuridica').disable();
        tbPJOpciones.getItem('txtCrpjr_observacion').disable();
    }
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_persona_juridica.
     */
    var winFrmCgg_res_persona_juridica = new Ext.Window({
        id:'winFrmCgg_res_persona_juridica',
        title:tituloCgg_res_persona_juridica,
        tbar:getPanelTitulo(tituloCgg_res_persona_juridica,descCgg_res_persona_juridica),
        layout:'border',
        items:[pnlCgg_res_persona_juridica,tbPJOpciones],
        height:580,
        width:500,
        minWidth:500,
        minHeight:560,
        resizable:true,
        constrain:true,
        modal:true,
        bbar:[btnGuardarCgg_res_persona_juridica,btnCancelarCgg_res_persona_juridica,'->',btnCerrarCgg_res_persona_juridica]
    });
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_persona_juridica.
     */
    function cargarCgg_res_persona_juridicaCtrls(){
        if(inRecordCgg_res_persona_juridica){
            txtCrpjr_codigo.setValue(inRecordCgg_res_persona_juridica.get('CRPJR_CODIGO'));
            tmpSectorProductivo = inRecordCgg_res_persona_juridica.get('CSCTP_CODIGO');

            if(inRecordCgg_res_persona_juridica.data.CGPRE_CCTN_CODIGO && inRecordCgg_res_persona_juridica.data.CGPRE_CCTN_CODIGO.length > 0)
                tmpDomicilio = inRecordCgg_res_persona_juridica.get('CCTN_CODIGO');

            var params = new SOAPClientParameters();
            params.add('inCctn_codigo',tmpDomicilio);
            params.add('format',TypeFormat.JSON);
            var tmpModulo = SOAPClient.invoke(URL_WS+"Cgg_canton", 'select', params, false, null);
            try{
                tmpModulo = Ext.util.JSON.decode(tmpModulo);
                txtCctn_codigo.setValue(tmpModulo[0].CCTN_NOMBRE);
            }catch(inErr){
                txtCctn_codigo.setValue(NO_DATA_MESSAGE);
            }
            //txtCctn_codigo.setValue(inRecordCgg_res_persona_juridica.get('CCTN_CODIGO'));//inRecordCgg_res_persona_juridica.get('CCTN_NOMBRE'));

            var scpSectorProductivo = new SOAPClientParameters();
            scpSectorProductivo.add('inCsctp_codigo',tmpSectorProductivo);
            scpSectorProductivo.add('format',TypeFormat.JSON);
            var tmpCsctpRegistro = SOAPClient.invoke(URL_WS+"Cgg_sector_productivo", 'select', scpSectorProductivo, false, null);
            try{
                tmpCsctpRegistro = Ext.util.JSON.decode(tmpCsctpRegistro);
                txtCsctp_codigo.setValue(tmpCsctpRegistro[0].CSCTP_NOMBRE);
            }catch(inErr){
                tmpSectorProductivo = null;
                tmpCsctpRegistro = null;
                txtCsctp_codigo.setValue('Informaci\u00F3n no disponible');
            }

            tmpVehiculoSector = inRecordCgg_res_persona_juridica.get('CVSCT_CODIGO');
            var scpVehiculoSector = new SOAPClientParameters();
            scpVehiculoSector.add('inCvsct_codigo',tmpVehiculoSector);
            scpVehiculoSector.add('format',TypeFormat.JSON);
            var tmpCvsctRegistro = SOAPClient.invoke(URL_WS+"Cgg_veh_sector", 'select', scpVehiculoSector, false, null);
            try{
                tmpCvsctRegistro = Ext.util.JSON.decode(tmpCvsctRegistro);
                txtCvsct_codigo.setValue(tmpCvsctRegistro[0].CVSCT_NOMBRE);
            }catch(inErr){
                tmpVehiculoSector = null;
                tmpCvsctRegistro = null;
                txtCvsct_codigo.setValue('Informaci\u00F3n no disponible');
            }
            txtCrpjr_razon_social.setValue(inRecordCgg_res_persona_juridica.get('CRPJR_RAZON_SOCIAL'));
            txtCrpjr_numero_identificacion.setValue(inRecordCgg_res_persona_juridica.get('CRPJR_NUMERO_IDENTIFICACION'));
            dtCrpjr_fecha_constitucion.setValue(truncDate(inRecordCgg_res_persona_juridica.get('CRPJR_FECHA_CONSTITUCION')));
            txtCrpjr_direccion.setValue(inRecordCgg_res_persona_juridica.get('CRPJR_DIRECCION'));
            txtCrpjr_actividad.setValue(inRecordCgg_res_persona_juridica.get('CRPJR_ACTIVIDAD'));
            numCrpjr_numero_empleados.setValue(inRecordCgg_res_persona_juridica.get('CRPJR_NUMERO_EMPLEADOS'));
            cbxCRPJR_TipoPersonaJuridica.setValue(inRecordCgg_res_persona_juridica.get('CRPJR_TIPO'));
            txtCrpjr_observacion.setValue(inRecordCgg_res_persona_juridica.get('CRPJR_OBSERVACION'));

            gsCgg_res_pjuridica_contacto.reload({params:{
                inCrpjr_codigo:inRecordCgg_res_persona_juridica.get('CRPJR_CODIGO'),
                format:TypeFormat.JSON}
            });

            gsCgg_res_cuenta_personajuridica.baseParams.inCrpjr_codigo = inRecordCgg_res_persona_juridica.get('CRPJR_CODIGO');
            gsCgg_res_cuenta_personajuridica.baseParams.start = 0;
            gsCgg_res_cuenta_personajuridica.baseParams.limit = 30;
            gsCgg_res_cuenta_personajuridica.baseParams.sort = 'CRCPJ_NUMERO_CUENTA';
            gsCgg_res_cuenta_personajuridica.baseParams.dir = 'ASC';
            gsCgg_res_cuenta_personajuridica.reload();

            var scpRepresentantePersona = new SOAPClientParameters();
            scpRepresentantePersona.add('inCrpjr_codigo',inRecordCgg_res_persona_juridica.get('CRPJR_CODIGO'));
            scpRepresentantePersona.add('format',TypeFormat.JSON);
            var tmpRepresentantePersonaRegistro = SOAPClient.invoke(URL_WS+"Cgg_res_representante_legal", 'selectRepresentantePersona', scpRepresentantePersona, false, null);
            try{
                tmpRepresentantePersonaRegistro = Ext.util.JSON.decode(tmpRepresentantePersonaRegistro);
                rRepresentanteLegal.set('CRRPT_CODIGO',tmpRepresentantePersonaRegistro[0].CRRPT_CODIGO);
                rRepresentanteLegal.set('CRPER_CODIGO',tmpRepresentantePersonaRegistro[0].CRPER_CODIGO);
                rRepresentanteLegal.set('CRPER_CODIGO_ANTERIOR',tmpRepresentantePersonaRegistro[0].CRPER_CODIGO);
                rRepresentanteLegal.set('CRPJR_CODIGO',tmpRepresentantePersonaRegistro[0].CRPJR_CODIGO);
                rRepresentanteLegal.set('CRRPT_ACTIVO',tmpRepresentantePersonaRegistro[0].CRRPT_ACTIVO);
                rRepresentanteLegal.set('CRRPT_FECHA_REGISTRO',tmpRepresentantePersonaRegistro[0].CRRPT_FECHA_REGISTRO);
                txtPJCrper_codigo.setValue(tmpRepresentantePersonaRegistro[0].CRPER_NOMBRES);
            }catch(inErr){

            }
            isEdit = true;
        }

        function CallBackCgg_gem_preregistro_codigo2(r){
            if(r){
                codigoPreregistroEmpresa=r;
                function CallBackCgg_gem_preregistro_select(r){
                    var a = eval('('+r+')');
                    if(a.length>0){
                        nombreAdjuntoRepresentante = a[0].CGPRE_NOMBRE_ADJUNTO;
                        btnCrpjr_verAdjunto.setDisabled(false);
                        btnCrpjr_verAdjunto.setIconClass('iconVerAdjunto');
                    }
                }
                var param = new SOAPClientParameters();
                param.add('inCgpre_codigo',codigoPreregistroEmpresa);
                param.add('format','JSON');
                SOAPClient.invoke(urlCgg_gem_preregistro_empresa,'select',param, true, CallBackCgg_gem_preregistro_select);
            }
        }
        var param = new SOAPClientParameters();
        param.add('inCrpjr_codigo',txtCrpjr_numero_identificacion.getValue());
        SOAPClient.invoke(urlCgg_gem_preregistro_empresa,'selectCodigoByRUC',param, true, CallBackCgg_gem_preregistro_codigo2);
    }

    function Cgg_preregistro_empresa_data(){
        /**
         * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_preregistro_empresa.
         */
        this.columnModel = new Ext.grid.ColumnModel([
            {dataIndex:'CGPRE_RAZON_SOCIAL',header:'Raz\u00F3n social',width:100,sortable:true},
            {dataIndex:'CGPRE_RUC',header:'Ruc',width:100,sortable:true},
            {dataIndex:'CGPRE_REPRESENTANTE',header:'Representante',width:150,sortable:true,hidden:true},
            {dataIndex:'CGPRE_FECHA_CREACION',header:'Fecha creacion',width:150,sortable:true,hidden:true},
            {dataIndex:'CGPRE_ACTIVIDAD',header:'Actividad',width:120,sortable:true},
            {dataIndex:'CGPRE_DIRECCION',header:'Direccion',width:120,sortable:true},
            {dataIndex:'CGPRE_SECTOR',header:'Sector',width:150,sortable:true,hidden:true},
            {dataIndex:'CGPRE_NUMERO_EMPLEADO',header:'Numero empleado',width:150,sortable:true,hidden:true},
            {dataIndex:'CGPRE_TELEFONO',header:'Telefono',width:70,sortable:true},
            {dataIndex:'CGPRE_EMAIL',header:'Email',width:90,sortable:true},
            {dataIndex:'CGPRE_CEDULA',header:'Cedula',width:150,sortable:true,hidden:true}
        ]);
        /**
         * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_preregistro_empresa por un campo especifico.
         */
        this.store = new Ext.data.Store({
            proxy:new Ext.ux.bsx.SoapProxy({
                url:URL_WS+"/PublicWS/Cgg_gem_preregistro_empresa",
                method:"selectPage"
            }),
            remoteSort:true,
            reader:new Ext.data.JsonReader({
                id:'CGPRE_CODIGO',
                root:'dataSet',
                totalProperty: 'totalCount'
            },[
                {name:'CGPRE_CODIGO'},
                {name:'CGPRE_RAZON_SOCIAL'},
                {name:'CGPRE_RUC'},
                {name:'CGPRE_REPRESENTANTE'},
                {name:'CGPRE_FECHA_CREACION'},
                {name:'CGPRE_ACTIVIDAD'},
                {name:'CGPRE_DIRECCION'},
                {name:'CGPRE_SECTOR'},
                {name:'CGPRE_TIPO'},
                {name:'CGPRE_NUMERO_EMPLEADO'},
                {name:'CGPRE_TELEFONO'},
                {name:'CGPRE_EMAIL'},
                {name:'CGPRE_CEDULA'},
                {name:'CGPRE_NOMBRE_ADJUNTO'},
                {name:'CGPRE_CCTN_CODIGO'},
                {name:'CGPRE_CISLA_CODIGO'}
            ]),
            sortInfo:{field: 'CGPRE_RAZON_SOCIAL', direction: 'ASC'},
            baseParams:{keyword:"",format:'JSON'}
        });
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_persona_juridica.
     * @returns ventana winFrmCgg_res_persona_juridica.
     * @base FrmCgg_res_persona_juridica.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_persona_juridica;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_persona_juridica.
     * @base FrmCgg_res_persona_juridica.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_persona_juridicaCtrls();
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_persona_juridica desde una instancia.
 */
FrmCgg_res_persona_juridica.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_persona_juridica desde una instancia.
 */
FrmCgg_res_persona_juridica.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_persona_juridica,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_persona_juridica.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_persona_juridica desde una instancia.
 */
FrmCgg_res_persona_juridica.prototype.loadData = function(){
    this.loadData();
}
