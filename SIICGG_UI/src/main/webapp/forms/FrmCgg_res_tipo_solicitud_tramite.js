/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_tipo_solicitud_tramite.
 * @param {String} INSENTENCIA_CGG_RES_TIPO_SOLICITUD_TRAMITE Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_RES_TIPO_SOLICITUD_TRAMITE Registro de datos de la tabla Cgg_res_tipo_solicitud_tramite.
 * @constructor
 * @base FrmListadoCgg_res_tipo_solicitud_tramite
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_tipo_solicitud_tramite(INSENTENCIA_CGG_RES_TIPO_SOLICITUD_TRAMITE,INRECORD_CGG_RES_TIPO_SOLICITUD_TRAMITE){
    var inSentenciaCgg_res_tipo_solicitud_tramite = INSENTENCIA_CGG_RES_TIPO_SOLICITUD_TRAMITE;
    var inRecordCgg_res_tipo_solicitud_tramite=INRECORD_CGG_RES_TIPO_SOLICITUD_TRAMITE;
    var urlCgg_res_tipo_solicitud_tramite=URL_WS+"Cgg_res_tipo_solicitud_tramite";
    var tituloCgg_res_tipo_solicitud_tramite='Tipo de solicitud tr\u00E1mite';
    var descCgg_res_tipo_solicitud_tramite='El formulario permite ingresar o editar informaci\u00f3n del tipo de solicitud tr\u00E1mite';
    var isEdit = false;

    var tmpTipoTramite=null;
    var tmpTipoSolicitudTramitePadre = null;
    var tmpProceso = null;
    var recordRegla = null;
    var tmpResolucion = null;
	var tmpStoreTipoStramite;

    var rSolicitudRequisito = Ext.data.Record.create([
    	{name:'CRSRQ_CODIGO',mapping:'CRSRQ_CODIGO'},
    	{name:'CRTSR_CODIGO',dataIndex:'CRTSR_CODIGO'},
    	{name:'CRREQ_CODIGO',dataIndex:'CRREQ_CODIGO'},
    	{name:'CRSRQ_DESCRIPCION',dataIndex:'CRSRQ_DESCRIPCION'},
    	{name:'CRSRQ_REQUERIDO',dataIndex:'CRSRQ_REQUERIDO'},
    	{name:'CRSRQ_PARTICIPANTE',dataIndex:'CRSRQ_PARTICIPANTE'}
    ]);

   var rGarantiaSolicitud = Ext.data.Record.create([
    	{name:'CRGTS_CODIGO',mapping:'CRGTS_CODIGO'},
    	{name:'CRGRT_CODIGO',mapping:'CRGRT_CODIGO'},
    	{name:'CRTST_CODIGO',mapping:'CRTSR_CODIGO'}
    ]);

    var rTipoSolicitudRegla = Ext.data.Record.create([
    	{name:'CRTSE_CODIGO'},
    	{name:'CRTST_CODIGO'},
    	{name:'CRVAL_CODIGO'},
    	{name:'CRVAL_NOMBRE'},
    	{name:'CRTSE_CAMPO_EVALUACION'},
    	{name:'CRTSE_VALOR_1'}
    ]);

    var rFilaProceso = Ext.data.Record.create(['CRPRO_CODIGO', 'CRPRO_NOMBRE']);
    var rProceso= new rFilaProceso({
        CRPRO_CODIGO: '',
        CRPRO_NOMBRE: ''
    });

    var rFilaResolucion= Ext.data.Record.create(['CRRES_CODIGO', 'CRRES_NUMERO_RESOLUCION']);
    var rResolucion=new rFilaResolucion({
        CRRES_CODIGO: '',
        CRRES_NUMERO_RESOLUCION: ''
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO TIPO SOLICITUD
     */
    var txtCrtst_codigo = new Ext.form.TextField({
        id:'txtCrtst_codigo',
        name:'txtCrtst_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGSITRO DE TIPO DE SOLICITUD RECURSIVO
     */
    var txtCgg_crtst_codigo = new Ext.form.TextField({
        id:'txtCgg_crtst_codigo',
        name:'txtCgg_crtst_codigo',
        fieldLabel:'Solicitud',
        anchor:'98%',
        readOnly:'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGSITRO DE TIPO DE SOLICITUD RECURSIVO
     */
    var btnCgg_crtst_codigoCgg_res_tipo_solicitud_tramite = new Ext.Button({
        id:'btnCgg_crtst_codigoCgg_res_tipo_solicitud_tramite',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_tipo_solicitud_tramite = new FrmListadoCgg_res_tipo_solicitud_tramite();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_tipo_solicitud_tramite.getStore(),tmpFLCgg_res_tipo_solicitud_tramite.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        txtCgg_crtst_codigo.setValue(tmpRecord.get('CRTST_DESCRIPCION'));
                        tmpTipoSolicitudTramitePadre=tmpRecord.get('CRTST_CODIGO');

                        if(tmpRecord.get('CRPRO_CODIGO')==null || tmpRecord.get('CRPRO_CODIGO') == undefined || tmpRecord.get('CRPRO_CODIGO').trim().length ==0){
                            return;
                        }

                        var scpProceso = new SOAPClientParameters();
                        scpProceso.add('inCrpro_codigo', tmpRecord.get('CRPRO_CODIGO'));
                        scpProceso.add('format', TypeFormat.JSON);
                        var tmpCrproRegistro = SOAPClient.invoke(URL_WS + "Cgg_res_proceso", 'select', scpProceso, false, null);
                        try {
                            tmpCrproRegistro = Ext.util.JSON.decode(tmpCrproRegistro);
                            tmpCrproRegistro = tmpCrproRegistro[0];
                            
                            rProceso.set('CRPRO_CODIGO', tmpCrproRegistro.CRPRO_CODIGO);
                            rProceso.set('CRPRO_NOMBRE', tmpCrproRegistro.CRPRO_NOMBRE);
                            tmpProceso = rProceso;
                            txtCrpro_codigo.setValue(rProceso.get('CRPRO_NOMBRE'));
                        }catch(inErr) {
                            txtCrpro_codigo.setValue(NO_DATA_MESSAGE);
                            tmpProceso = null;
                        }                                               
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
     */
    var txtCrtpt_codigo = new Ext.form.TextField({
        id:'txtCrtpt_codigo',
        name:'txtCrtpt_codigo',
        fieldLabel:'Area de tr\u00E1mite',
        anchor:'98%',        
        readOnly:'true'
    });
	
    var cbxCkesp_codigo = new Ext.form.ComboBox({
        fieldLabel:'Especie',
        anchor:'98%',
        valueField:'CKESP_CODIGO',
        displayField:'CKESP_NOMBRE',
        typeAhead: true,
        editable:false,
        allowBlank:true,
        mode: 'local',
        triggerAction: 'all',
        emptyText:'Seleccione una especie',
        forceSelection: true
    });
	
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE TIPO DE TRAMITE
     */
    var btnCrtpt_codigoCgg_res_tipo_solicitud_tramite = new Ext.Button({
        id:'btnCrtpt_codigoCgg_res_tipo_solicitud_tramite',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_tipo_tramite = new FrmListadoCgg_res_tipo_tramite();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_tipo_tramite.getStore(),tmpFLCgg_res_tipo_tramite.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        txtCrtpt_codigo.setValue(tmpRecord.get('CRTPT_NOMBRE'));
                        tmpTipoTramite = tmpRecord.get('CRTPT_CODIGO');
                    }
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.form.TextField DESCRIPCION DEL TIPO DE RESIDENCIA
     */
    var txtCrtst_descripcion = new Ext.form.TextField({
        id:'txtCrtst_descripcion',
        name:'txtCrtst_descripcion',
        fieldLabel :'Descripci\u00F3n',
        anchor:'98%',
        allowBlank :false,
        maxLength :100
    });
    /**
     * Ext.form.TextArea NO ESPECIFICADO
     */
    var txtCrtst_observacion = new Ext.form.TextArea({
        id:'txtCrtst_observacion',
        name:'txtCrtst_observacion',
        fieldLabel:'Observaci\u00F3n',
		height:46,
        width:'98%'
    });
    /**
     * Ext.form.Checkbox ESTADO DE CONTROL PARA DESPOSITO DE GARANTIA.
     EN ESTE CASO SE RELACIONA CON UNA O VARIAS GARANTIAS, LAS CUALES DEBEN SER CREADAS.
     */
    var chkCrtst_aplica_garantia = new Ext.form.Checkbox({
        id:'chkCrtst_aplica_garantia',
        name:'chkCrtst_aplica_garantia',
        fieldLabel :'Aplica garant\u00EDa',
        disabled:true,
        listeners:{
            check:function(inThis,inChecked){
                if(inChecked == true){
                    Ext.getCmp('tpGarantia').enable();
                }else{
                    Ext.getCmp('tpGarantia').disable();
                }
            }
        }
    });
    /**
     * Ext.form.Checkbox ESTADO DE CONTROL PARA DETERMINAR SI SE CONSIDERA COMO INICIO DE DE UN TRAMITE, EN OTRAS PALABRAS ESTABLECE SI ESTE TRAMITE ES UN TRAMITE DE TRABAJO O SOLO DE AGRUPAMIENTO
     SI
     NO
     */
    var chkCrtst_aplica_tramite = new Ext.form.Checkbox({
        id:'chkCrtst_aplica_tramite',
        name:'chkCrtst_aplica_tramite',
        fieldLabel :'Genera tr\u00E1mite',
        allowBlank :false,
        listeners:{
            check:function(inSource, inChecked){
                chkCrtst_restringido.setDisabled(!inChecked);
                chkCrtst_unanimidad.setDisabled(!inChecked);
                chkCrtst_aplica_garantia.setDisabled(!inChecked);
                chkCrtst_comunicado_radial.setDisabled(!inChecked);
                chkCrtst_atencion_cliente.setDisabled(!inChecked);
                chkCrtst_aplica_beneficiario.setDisabled(!inChecked);
                chkCrtst_aplica_otro.setDisabled(!inChecked);
                Ext.getCmp('tpRequisito').setDisabled(!inChecked);
                chkCrtst_restringido.setValue(false);
            }
        }
    });
    /**
     * Ext.form.Checkbox SI EL TRAMITE PUEDE TENER VARIOS BENEFICIARIOS O ES UN TRAMITE QUE APLICA PARA VARIAS PERSONAS.
     */
    var chkCrtst_aplica_grupo = new Ext.form.Checkbox({
        id:'chkCrtst_aplica_grupo',
        name:'chkCrtst_aplica_grupo',
        fieldLabel :'Grupal',
        allowBlank :false
    });
    /**
     * Ext.form.Checkbox SI EL TRAMITE ESTA DISPONIBLE PARA UN PRE REGISTRO POR MEDIO DE ATENCION AL CLIENTE
     */
    var chkCrtst_atencion_cliente = new Ext.form.Checkbox({
        id:'chkCrtst_atencion_cliente',
        name:'chkCrtst_atencion_cliente',
        fieldLabel :'Atenci\u00F3n al cliente',
        allowBlank :false,
        disabled:true
    });
    /**
     * Ext.form.Checkbox SI SE APLICA UN CONTROL ESPECIFICO PARA PODER INICIAR UN TRAMITE
     */
    var chkCrtst_restringido = new Ext.form.Checkbox({
        id:'chkCrtst_restringido',
        name:'chkCrtst_restringido',
        fieldLabel :'Validaci\u00F3n',
        allowBlank :false,
        disabled:true,
        listeners:{
            check:function(inThis,inChecked){
                if(inChecked == true){
                    Ext.getCmp('tpReglaValidacion').enable();
                }else{
                    Ext.getCmp('tpReglaValidacion').disable();
                }
            }
        }
    });
    /**
     * Ext.form.Checkbox SI EL TRAMITE NECESITA DE UN COMUNICADO RADIAL PARA SU INICIO
     */
    var chkCrtst_comunicado_radial = new Ext.form.Checkbox({
        id:'chkCrtst_comunicado_radial',
        name:'chkCrtst_comunicado_radial',
        fieldLabel :'C. radial',
        allowBlank :false,
        disabled:true
    });
    /**
     * Ext.ux.form.SpinnerField NUMERO DE DIAS MAXIMO PERMITIDO PARA LA RESIDENCIA O MOVILIDAD
     */
    var spfCrtst_numero_dias = new Ext.ux.form.SpinnerField({
        id:'spfCrtst_numero_dias',
        name:'spfCrtst_numero_dias',
        fieldLabel :'N\u00FAmero d\u00EDas',
        anchor:'98%',
        allowBlank :false,
        value:0,
        minValue:0,
        allowDecimals: false,
        allowNegative: false,
        alternateIncrementValue: 1,
        accelerate:true
    });
    /**
     * Ext.form.Checkbox ALMACENA INFORMACION DEL VEHICULO
     */
    var chkCrtst_vehiculo = new Ext.form.Checkbox({
        id:'chkCrtst_vehiculo',
        name:'chkCrtst_vehiculo',
        fieldLabel :'Veh\u00EDculo',
        allowBlank :true
    });
    /**
     * Ext.form.Checkbox CONTEO APLICADO AL TRAMITE
     */
    var chkCrtst_unanimidad = new Ext.form.Checkbox({
        id:'chkCrtst_unanimidad',
        name:'chkCrtst_unanimidad',
        fieldLabel :'Unanimidad',
        allowBlank :false,
        disabled:true
    });

    /**
     * Ext.form.Checkbox CAMPO PARA VALIDACION DE OTRO VALOR QUE SE PUEDIERA MANEJAR ADICIONALMENTE PARA EL TIPO DE SOLICITUD DE TRAMITE
     */
    var chkCrtst_aplica_otro = new Ext.form.Checkbox({
        id:'chkCrtst_aplica_otro',
        name:'chkCrtst_aplica_otro',
        fieldLabel :'Aplica transeunte',
        disabled:true        
    });
    /**
	* Ext.form.Checkbox SI EL TIPO DE SOLICITUD REQUIERE DE UN BENEFICIARIO
	*/
    var chkCrtst_aplica_beneficiario = new Ext.form.Checkbox({
        id:'chkCrtst_aplica_beneficiario',
        name:'chkCrtst_aplica_beneficiario',
        fieldLabel :'Aplica beneficiario',
        allowBlank :true,
        disabled:true
    });

    /**
* Ext.form.NumberField INDICE NUMERICO UTIL PARA LA GENERACION DE EXPEDIENTE DE PERSONA O NUMERO DE CARNET PARA RESIDENCIA
*/
    var numCrtst_indice = new Ext.form.NumberField({
        id:'numCrtst_indice',
        name:'numCrtst_indice',
        fieldLabel :'Indice',        
        allowDecimals:false,
        allowNegative:false,
        minValue:0,
        value:0
    });

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
     */
    var txtCrpro_codigo = new Ext.form.TextField({
        id:'txtCrpro_codigo',
        name:'txtCrpro_codigo',
        fieldLabel :'Proceso',
        anchor:'98%',
        readOnly:'true'
    });

    /**
* Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
*/
    var txtCrres_codigo = new Ext.form.TextField({
        id:'txtCrres_codigo',
        name:'txtCrres_codigo',
        fieldLabel :'Resoluci\u00f3n',
        anchor:'98%',
        readOnly:'true'
    });
     
    /**
* IDENTIFICATIVO UNICO DE REGISTRO DE RESOLUCIONES
*/
    var btnCrres_codigoCgg_res_tipo_solicitud_tramite = new Ext.Button({
        id:'btnCrres_codigoCgg_res_tipo_solicitud_tramite',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_resolucion = new FrmListadoCgg_res_resolucion();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_resolucion.getStore(),tmpFLCgg_res_resolucion.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord!==null && tmpRecord !== undefined)
                        tmpResolucion = tmpRecord;
                    txtCrres_codigo.setValue(tmpResolucion.get('CRRES_NUMERO_RESOLUCION'));
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE PROCESO
     */
    var btnCrpro_codigoCgg_res_tipo_solicitud_tramite = new Ext.Button({
        id:'btnCrpro_codigoCgg_res_tipo_solicitud_tramite',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_res_proceso = new FrmListadoCgg_res_proceso();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_res_proceso.getStore(),tmpFLCgg_res_proceso.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord!==null && tmpRecord !== undefined){
                        tmpProceso = tmpRecord;
                        txtCrpro_codigo.setValue(tmpRecord.get('CRPRO_NOMBRE'));
                    }
                });
                objBusqueda.show();
            }
        }
    });

    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_tipo_solicitud_tramite
     */
    var btnGuardarCgg_res_tipo_solicitud_tramite = new Ext.Button({
        id:'btnGuardarCgg_res_tipo_solicitud_tramite',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_res_tipo_solicitud_tramite.getForm().isValid()==false){
                    return;
                }else if((chkCrtst_aplica_garantia.getValue()==true)){
                    if(grdCgg_res_garantia_solicitud.getStore().getCount()==0){
                        Ext.Msg.show({
                            title:tituloCgg_res_tipo_solicitud_tramite,
                            msg: 'El tipo de solicitud requiere que establezca una garant\u00EDa, por favor.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.WARNING
                        });
                        return;
                    }
                }else if(chkCrtst_aplica_tramite.getValue() && grdCgg_res_solicitud_requisito.getStore().getCount() == 0){
                    var respuesta =  confirm("Esta solicitud no tiene requisitos desea continuar?");
                    if(!respuesta){
                        return;
                    }
                }else if((spfCrtst_numero_dias.getValue()==0)){
                    var flagDias =  confirm("Colocar en cero(0) el n\u00FAmero de d\u00EDas se lo reserva a residencias permanentes.\nEsta seguro de continuar?");
                    if(!flagDias){
                        return;
                    }
                }
                try{
                    function CallBackCgg_res_tipo_solicitud_tramite(r){
                        winFrmCgg_res_tipo_solicitud_tramite.getEl().unmask();
                        try{
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloCgg_res_tipo_solicitud_tramite,
                                    msg: 'El tipo de solicitud de tr\u00E1mite ha sido actualizado.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                winFrmCgg_res_tipo_solicitud_tramite.close();
                            }else{
                                Ext.Msg.show({
                                    title:tituloCgg_res_tipo_solicitud_tramite,
                                    msg: 'El tipo de solicitud de tr\u00E1mite no ha podido ser almacenado. '+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                            
                        }catch(inErr){
                            Ext.Msg.show({
                                title:tituloCgg_res_tipo_solicitud_tramite,
                                msg: 'El tipo de solicitud de tr\u00E1mite no ha podido ser almacenado. '+(r.message?r.message:r),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }

                    winFrmCgg_res_tipo_solicitud_tramite.getEl().mask('Guardando...', 'x-mask-loading');

                    var param = new SOAPClientParameters();
                    if(isEdit){
                        param.add('inCrtst_codigo',txtCrtst_codigo.getValue());
                    }
                    param.add('inCgg_crtst_codigo',(tmpTipoSolicitudTramitePadre==null || tmpTipoSolicitudTramitePadre.trim().length ==0)?null:tmpTipoSolicitudTramitePadre);
                    param.add('inCrtpt_codigo',(tmpTipoTramite == null || tmpTipoTramite.trim().length ==0)?null:tmpTipoTramite);
                    param.add('inCrpro_codigo',(tmpProceso ==null || tmpProceso.get('CRPRO_CODIGO').trim().length ==0)?null:tmpProceso.get('CRPRO_CODIGO'));
                    param.add('inCrres_codigo',(tmpResolucion == null || tmpResolucion.get('CRRES_CODIGO').trim().length ==0)? null:tmpResolucion.get('CRRES_CODIGO'));
                    param.add('inCkesp_codigo',(cbxCkesp_codigo.getValue() == null || cbxCkesp_codigo.getValue().trim().length ==0)? null: cbxCkesp_codigo.getValue());
                    param.add('inCrtst_descripcion',txtCrtst_descripcion.getValue());
                    param.add('inCrtst_observacion',txtCrtst_observacion.getValue());
                    param.add('inCrtst_aplica_garantia',chkCrtst_aplica_garantia.getValue());
                    param.add('inCrtst_aplica_tramite',chkCrtst_aplica_tramite.getValue());
                    param.add('inCrtst_aplica_grupo',chkCrtst_aplica_grupo.getValue());
                    param.add('inCrtst_atencion_cliente',chkCrtst_atencion_cliente.getValue());
                    param.add('inCrtst_restringido',chkCrtst_restringido.getValue());
                    param.add('inCrtst_comunicado_radial',chkCrtst_comunicado_radial.getValue());
                    param.add('inCrtst_numero_dias',spfCrtst_numero_dias.getValue());
                    param.add('inCrtst_vehiculo',chkCrtst_vehiculo.getValue());
                    param.add('inCrtst_unanimidad',chkCrtst_unanimidad.getValue());
                    param.add('inCrtst_aplica_otro',chkCrtst_aplica_otro.getValue());
                    param.add('inCrtst_aplica_beneficiario',chkCrtst_aplica_beneficiario.getValue());
                    param.add('inCrtst_indice',numCrtst_indice.getValue());
                    param.add('inCrtst_requisito',grdCgg_res_solicitud_requisito.getStore().getJsonData());
                    param.add('inCrtst_garantia',grdCgg_res_garantia_solicitud.getStore().getJsonData());
                    param.add('inCrtst_regla',obtenerReglasJson());
			param.add('inCrtst_opcion',gsCgg_res_tst_aplica.getJsonData());
                    SOAPClient.invoke(urlCgg_res_tipo_solicitud_tramite,INSENTENCIA_CGG_RES_TIPO_SOLICITUD_TRAMITE,param, true, CallBackCgg_res_tipo_solicitud_tramite);
                }catch(inErr){
                    winFrmCgg_res_tipo_solicitud_tramite.getEl().unmask();
                    Ext.Msg.show({
                        title:tituloCgg_res_tipo_solicitud_tramite,
                        msg: 'El tipo de solicitud de tr\u00E1mite no ha podido ser almacenado.<br>Error:'+inErr,
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.ERROR
                    });
                }
            }
        }
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_res_tipo_solicitud_tramite.
     */
    var btnCancelarCgg_res_tipo_solicitud_tramite = new Ext.Button({
        id:'btnCancelarCgg_res_tipo_solicitud_tramite',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_res_tipo_solicitud_tramite.getForm().reset();
            }
        }
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_tipo_solicitud_tramite.
     */
    var btnCerrarCgg_res_tipo_solicitud_tramite = new Ext.Button({
        id:'btnCerrarCgg_res_tipo_solicitud_tramite',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_res_tipo_solicitud_tramite.close();
            }
        }
    });

    var pnlTipoSolicitudNorte=new Ext.Panel({
        id:'pnlTipoSolicitudNorte',
        region:'north',
        layout:'border',
        height:264,
        minHeight:264,
        items:[{
            xtype:'panel',
            id:'pnlTSN1',
            region:'center',
            layout:'border',
            width:'70%',
            anchor:'70%',
            items:[{
                xtype:'panel',
                id:'pnlTSN11',
                region:'center',
                layout:'form',
                items:[
                {
                    xtype:'panel',
                    layout:'column',
                    anchor:'100%',
                    items:[{
                        columnWidth:.5,
                        layout:'form',
                        items:[txtCrtst_descripcion,txtCrtst_observacion,spfCrtst_numero_dias,cbxCkesp_codigo]
                    },{
                        columnWidth:.45,
                        layout:'form',
                        items:[txtCrtpt_codigo,txtCgg_crtst_codigo,txtCrpro_codigo,txtCrres_codigo,numCrtst_indice]
                    },{
                        columnWidth:.05,
                        layout:'form',
                        buttonAlign:'center',                        
                        items:[
                        {
                            items:[btnCrtpt_codigoCgg_res_tipo_solicitud_tramite]
                        },
                        {
                            bodyStyle:'padding:4px 0px 0px 0px',
                            items:[btnCgg_crtst_codigoCgg_res_tipo_solicitud_tramite]
                        },
                        {
                            bodyStyle:'padding:4px 0px 0px 0px',
                            items:[btnCrpro_codigoCgg_res_tipo_solicitud_tramite]
                        },

                        {
                            bodyStyle:'padding:4px 0px 0px 0px',
                            items:[btnCrres_codigoCgg_res_tipo_solicitud_tramite]
                        }
                        ]
                    }
                    ]
                },
                {
                    items:[{
                        xtype:'fieldset',
                        title:'Opciones',                        
                        items:[
                        {
                            xtype:'panel',
                            layout:'column',
                            items:[{
                                columnWidth:.25,
                                layout:'form',
                                labelWidth:90,
                                items:[chkCrtst_aplica_tramite,chkCrtst_aplica_beneficiario] //chkCrtst_aplica_garantia
                            },
                            {
                                columnWidth:.25,
                                layout:'form',
                                labelWidth:90,
                                items:[chkCrtst_aplica_grupo]   //chkCrtst_comunicado_radial

                            },
                            {
                                columnWidth:.25,
                                layout:'form',
                                labelWidth:90,
                                items:[chkCrtst_restringido,chkCrtst_vehiculo,chkCrtst_unanimidad]

                            },
                            {
                                columnWidth:.25,
                                layout:'form',
                                labelWidth:90,
                                items:[chkCrtst_aplica_otro,chkCrtst_atencion_cliente]

                            }
                            ]
                        }
                        ]
                    }
                    ]
                }
                ]
            }
            ]
        }]
    });
    /**
     *Ext.form.ComboBox Combo para edicion de requisitos.
     */
    var cbxCRREQ_PARTICIPANTEEditor = new Ext.form.ComboBox({
        id:'cbxCRREQ_PARTICIPANTEEditor',
        store:dsTipoParticipante,
        displayField:'DESCRIPCION',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
		editable:false,
        triggerAction:'all',
        selectOnFocus:true,
        valueField:'INDICE'
    });

    /**
     *Ext.form.ComboBox Combo para edicion de requisitos.
     */
    var cbxCRREQ_CODIGOEditor = new Ext.form.ComboBox({
        id:'cbxCRREQ_CODIGOEditor',
        store: SCGG_RES_REQUISITO,
        displayField:'CRREQ_DESCRIPCION',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
		editable:true,
        triggerAction:'all',
        emptyText:'Seleccione un requisito',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CRREQ_DESCRIPCION}. {CRREQ_OBSERVACION}" class="x-combo-list-item">{CRREQ_DESCRIPCION}</div></tpl>',
        valueField:'CRREQ_CODIGO'
    });

    var txtCRSRQ_DESCRIPCIONEditor = new Ext.form.TextField({
        id:'txtCRSRQ_DESCRIPCIONEditor',
        emptyText:'Establezca una descripci\u00F3n'
    });

    var cbcCRSRQ_REQUERIDO =  new Ext.grid.CheckColumn({
        dataIndex:'CRSRQ_REQUERIDO',
        header:'Requerido',
        width:70,
        editor:{
            xtype:'checkbox'
        }
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_solicitud_requisito.
     */
    var cmCgg_res_solicitud_requisito = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            dataIndex:'CRSRQ_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRTSR_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRREQ_CODIGO',
            header:'Requisito',
            width:300,
            sortable:true,
            editor:cbxCRREQ_CODIGOEditor,
            renderer:function(inCRREQ_CODIGO){
                var i =0;
                var result = 'no datos';
                for(i=0;i<SCGG_RES_REQUISITO.getCount();i++){
                    var rRequisito = SCGG_RES_REQUISITO.getAt(i);
                    if(rRequisito.get('CRREQ_CODIGO') == inCRREQ_CODIGO){
                        result = rRequisito.get('CRREQ_DESCRIPCION');
                        break;
                    }
                }
                return result;
            }
        },
        {
            dataIndex:'CRSRQ_DESCRIPCION',
            header:'Descripci\u00F3n',
            width:150,
            sortable:true,
            editor:txtCRSRQ_DESCRIPCIONEditor
        },{
            dataIndex:'CRSRQ_PARTICIPANTE',
            header:'Participante',
            width:100,
            sortable:true,
            editor:cbxCRREQ_PARTICIPANTEEditor,
            renderer:function(inCrsrq_participante){
                for(var i = 0; i < dsTipoParticipante.length ;i++){
                    if(dsTipoParticipante[i][0]==inCrsrq_participante){
                        return dsTipoParticipante[i][1];
                    }
                }
            }
        },cbcCRSRQ_REQUERIDO]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_solicitud_requisito por un campo especifico.
     */
    var sCgg_res_solicitud_requisito = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_solicitud_requisito",
            method:"selectCgg_res_tipo_solicitud_tramite"
        }),
        reader:new Ext.data.JsonReader({},[
        {
            name:'CRSRQ_CODIGO'
        },

        {
            name:'CRTSR_CODIGO'
        },

        {
            name:'CRREQ_CODIGO'
        },
        {
            name:'CRSRQ_DESCRIPCION'
        },
        {
            name:'CRSRQ_REQUERIDO'
        },{
            name:'CRSRQ_PARTICIPANTE'
        }
        ]),
        baseParams:{
            inCrtst_codigo:null,
            format:"JSON"
        }
    });
    
    var reSolicitudRequisito = new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        errorSummary: false,
        listeners:{
            canceledit:function(inRowEditor,inFlag){
                var inRecord=grdCgg_res_solicitud_requisito.getStore().getAt(0);
                if(inRecord.get('CRREQ_CODIGO')==null){
                    grdCgg_res_solicitud_requisito.getStore().remove(inRecord);
                }
            },
            afteredit:function(inRowEditor,inObject,inRecord,inRowIndex){
                if(inRecord.get('CRREQ_CODIGO').trim().length==0){
                    grdCgg_res_solicitud_requisito.getStore().remove(inRecord);
                }else{
                    for(var i=0;i<grdCgg_res_solicitud_requisito.getStore().getCount();i++){
                        
                        if(inRowIndex !== i &&
                            inRecord.get('CRREQ_CODIGO')==grdCgg_res_solicitud_requisito.getStore().getAt(i).get('CRREQ_CODIGO') &&
                            inRecord.get('CRSRQ_PARTICIPANTE') == grdCgg_res_solicitud_requisito.getStore().getAt(i).get('CRSRQ_PARTICIPANTE')){
                            Ext.Msg.show({
                                title:tituloCgg_res_tipo_solicitud_tramite,
                                msg: 'El requerimiento seleccionado ya esta establecido.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.WARNING
                            });
                            grdCgg_res_solicitud_requisito.getStore().removeAt(inRowIndex);
                        }
                    }
                }
            }
        }
    });
    
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_solicitud_requisito en un formato tabular de filas y columnas.
     */
    var grdCgg_res_solicitud_requisito = new Ext.grid.EditorGridPanel({
        cm:cmCgg_res_solicitud_requisito,
        store:sCgg_res_solicitud_requisito,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        viewConfig: {
            forceFit: true
        },
        loadMask:{
            msg:"Cargando..."
        },
        plugins:[reSolicitudRequisito]
    });

    /**
     *Ext.form.ComboBox Combo para edicion de requisitos.
     */
    var cbxCRGRT_CODIGOEditor = new Ext.form.ComboBox({
        id:'cbxCRGRT_CODIGOEditor',
        displayField:'CRGRT_DESCRPCION',
        typeAhead: true,
        mode:'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un requisito',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CRGRT_DESCRPCION}.{CRGRT_VALOR}" class="x-combo-list-item">{CRGRT_DESCRPCION}</div></tpl>',
        valueField:'CRGRT_CODIGO',
        allowBlank:false
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_garantia_solicitud.
     */
    var cmCgg_res_garantia_solicitud = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
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
            sortable:true,
            editor:cbxCRGRT_CODIGOEditor,
            renderer:function(inCRGRT_CODIGO){
                var i =0;
                var result = 'no datos';
                for(i=0;i<cbxCRGRT_CODIGOEditor.store.getCount();i++){
                    var rGarantia = cbxCRGRT_CODIGOEditor.store.getAt(i);
                    if(rGarantia.get('CRGRT_CODIGO') == inCRGRT_CODIGO){
                        result = rGarantia.get('CRGRT_DESCRPCION')+' - '+rGarantia.get('CRGRT_VALOR');
                        break;
                    }
                }
                return result;
            }
        },
        {
            dataIndex:'CRTST_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_garantia_solicitud por un campo especifico.
     */
    var sCgg_res_garantia_solicitud = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_garantia_solicitud",
            method:"selectCgg_res_tipo_solicitud_tramite"
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
        }
        ]),
        baseParams:{
            inCrtst_codigo:null,
            format:TypeFormat.JSON
        }
    });

    var reGarantia= new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        errorSummary:false,
        listeners:{
            validateedit:function(inRowEditor,inObject,inRecord,inRowIndex){
                for(var i =0;i<grdCgg_res_garantia_solicitud.getStore().getCount();i++){
                    if(inObject.CRGRT_CODIGO==grdCgg_res_garantia_solicitud.getStore().getAt(i).get('CRGRT_CODIGO')){
                        Ext.Msg.show({
                            title:tituloCgg_res_tipo_solicitud_tramite,
                            msg: 'La garant\u00EDa seleccionada ya esta establecida.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.WARNING
                        });
                        grdCgg_res_garantia_solicitud.getStore().remove(inRecord);
                    }
                }
            }
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_garantia_solicitud en un formato tabular de filas y columnas.
     */
    var grdCgg_res_garantia_solicitud = new Ext.grid.EditorGridPanel({
        cm:cmCgg_res_garantia_solicitud,
        store:sCgg_res_garantia_solicitud,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        viewConfig:{
            forceFit:true
        },
        plugins:[reGarantia]
    });


    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_regla_validacion por un campo especifico.
     */
    var sCgg_regla_validacion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_regla_validacion",
            method:"selectAll"
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({},[
        {
            name:'CRVAL_CODIGO'
        },
        {
            name:'CRVAL_NOMBRE'
        },

        {
            name:'CRVAL_DESCRIPCION'
        },
        {
            name:'CRTSE_VALOR_1'
        }
        ]),
        baseParams:{
            format:TypeFormat.JSON
        }
    });

    Ext.util.Format.comboRenderer = function(combo){
        return function(value){
            var record = combo.findRecord(combo.valueField, value);
            return record ? record.get(combo.displayField) : combo.valueNotFoundText;
        }
    }

    /**
     * Ext.form.TextField IDENTIFICATIVO de seleccion de funcion.
     */
    var cbxCgg_regla_validacionEditor = new Ext.form.ComboBox({
        id:'cbxCgg_regla_validacionEditor',
        name:'cbxCgg_regla_validacionEditor',
        anchor:'98%',
        store:sCgg_regla_validacion,
        displayField:'CRVAL_NOMBRE',
        typeAhead: true,
        mode:'local',
        triggerAction:'all',
        emptyText:'Establezca la funci\u00F3n de validaci\u00f3n',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="Parametros:{CRVAL_DESCRIPCION}" class="x-combo-list-item">{CRVAL_NOMBRE}</div></tpl>',
        valueField:'CRVAL_CODIGO',
        allowBlank:false
    });
    sCgg_regla_validacion.load();

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_tipo_solicitud_regla.
     */
    var cmCgg_res_tipo_solicitud_regla = new Ext.grid.ColumnModel([
    {
        dataIndex:'CRTSE_CODIGO',
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
    },

    {
        dataIndex:'CRVAL_CODIGO',
        header:'Regla validaci\u00f3n',
        width:150,
        sortable:true,
        hidden:true

    //renderer: Ext.util.Format.comboRenderer(cbxCgg_regla_validacionEditor)
    //editor:cbxCgg_regla_validacionEditor
    /*renderer:function(inCRVAL_CODIGO){
             var scpReglaValidacion = new SOAPClientParameters();
             var resultRegla = null;
             scpReglaValidacion.add('inCRVAL_CODIGO',inCRVAL_CODIGO);
             scpReglaValidacion.add('format',TypeFormat.JSON);
             var tmpRegla = SOAPClient.invoke(URL_WS+'Cgg_regla_validacion','select', scpReglaValidacion, false,null);
             try{
             tmpRegla = Ext.util.JSON.decode(tmpRegla);
             tmpRegla = tmpRegla[0];
             resultRegla = tmpRegla.CRVAL_NOMBRE;
             }catch(inErr){
             resultRegla = NO_DATA_MESSAGE;
             }
             return resultRegla;
             }*/
    },
    {
        dataIndex:'CRVAL_NOMBRE',
        header:'Regla validaci\u00f3n',
        width:150,
        sortable:true,
        hidden:true
    },
    {
        dataIndex:'CRTSE_VALOR_1',
        header:'Parametro',
        width:150,
        sortable:true,
        hidden:false,
        hideable:false
    },
    {
        dataIndex:'CRTSE_CAMPO_EVALUACION',
        header:'Campo evaluaci\u00f3n',
        width:150,
        sortable:true,
        editor:{
            xtype:'textfield'
        }
    }
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_tipo_solicitud_regla por un campo especifico.
     */
    var gsCgg_res_tipo_solicitud_regla = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_tipo_solicitud_regla",
            method:"selectCGG_RES_TIPO_SOLICITUD_TRAMITE1"
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({},rTipoSolicitudRegla),
        baseParams:{
            inCrtst_codigo:'',
            format:'JSON'
        },
        groupField: 'CRVAL_NOMBRE'
    });

    var reTipoSolicitudRegla = new Ext.ux.grid.RowEditor({
        saveText: 'Aceptar',
        listeners:{
            canceledit:function(inRowEditor,inFlag){
            /* var inRecord=grdCgg_res_tipo_solicitud_regla.getStore().getAt(0);
                 grdCgg_res_tipo_solicitud_regla.getStore().remove(inRecord);*/
            },
            afteredit:function(inRowEditor,inObject,inRecord,inRowIndex){
            /*  if(inRecord.get('CRVAL_CODIGO').trim().length==0){
                 grdCgg_res_tipo_solicitud_regla.getStore().remove(inRecord);
                 }else{
                 for(var i=0;i<grdCgg_res_tipo_solicitud_regla.getStore().getCount();i++){
                 if(i > 0){
                 if(inRecord.get('CRVAL_CODIGO')==grdCgg_res_tipo_solicitud_regla.getStore().getAt(i).get('CRVAL_CODIGO')){
                 Ext.Msg.show({
                 title:tituloCgg_res_tipo_solicitud_tramite,
                 msg: 'La regla seleccionada ya esta establecida.',
                 buttons: Ext.Msg.OK,
                 icon: Ext.MessageBox.WARNING
                 });
                 grdCgg_res_tipo_solicitud_regla.getStore().removeAt(0);
                 }
                 }
                 }
                 }*/
            }
        }
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_tipo_solicitud_regla en un formato tabular de filas y columnas.
     */
    var grdCgg_res_tipo_solicitud_regla = new Ext.grid.GridPanel({
        cm:cmCgg_res_tipo_solicitud_regla,
        store:gsCgg_res_tipo_solicitud_regla,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        //viewConfig: {forceFit: true },
        plugins:[reTipoSolicitudRegla],
        view: new Ext.grid.GroupingView({
            forceFit: true,
            // custom grouping text template to display the number of items per group
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        })

    });

    gsCgg_res_tipo_solicitud_regla.reload({
        params:{
            inCrtst_codigo:null,
            format:'JSON'
        }
    });
	///////////////////////////////OPCIONES DE LOS TIPOS DE SOLICITUD DE TRAMITE/////////////////
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto Cgg_res_tst_aplica.
	*/
	var chkAplica =  new Ext.grid.CheckColumn({
		dataIndex:'APLICA',
		header:'Aplica?',
		width:70,
		editor:{
		xtype:'checkbox'
		}
	});
	var cmCgg_res_tst_aplica = new Ext.grid.ColumnModel([
		{dataIndex:'CRTSO_NOMBRE',header:'Nombre',width:200,sortable:true},
		chkAplica,
		{dataIndex:'CRTSO_DESCRIPCION',header:'Nombre',width:300,sortable:true}
		]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_res_tst_aplica por un campo especifico.
	*/
	var gsCgg_res_tst_aplica = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_res_tst_aplica",
					method:"selectCGG_RES_TIPO_SOLICITUD_TRAMITE",
					pagin:false
			}),
			remoteSort:false,
			reader:new Ext.data.JsonReader({},[
				{name:'CRTAO_CODIGO'},
				{name:'CRTSO_CODIGO'},
				{name:'CRTST_CODIGO'},
				{name:'CRTSO_NOMBRE'},
				{name:'CRTSO_DESCRIPCION'},
				{name:'APLICA'}
			]),
			baseParams:{format:'JSON',inCrtst_codigo:''}
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_tst_aplica en un formato tabular de filas y columnas.
	*/
	var grdCgg_res_tst_aplica = new Ext.grid.GridPanel({
		title:'Opciones',
		cm:cmCgg_res_tst_aplica,
		store:gsCgg_res_tst_aplica,
		region:'center',
		sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
		loadMask:{msg:"Cargando..."},
		plugins:[chkAplica],
		listeners:{
			rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
				if(!btnEditarCgg_res_tst_aplica.disabled){
					btnEditarCgg_res_tst_aplica.fireEvent('click', btnEditarCgg_res_tst_aplica);
				}
	}}});
	gsCgg_res_tst_aplica.reload({params:{
			format:'JSON'
		}
	});
	
    var pnlTabTipoSolicitud = new Ext.TabPanel({
        id:'pnlTabTipoSolicitud',
        activeTab: 0,
        region:'center',
        items: [{
            id:'tpRequisito',
            title: 'Requisitos',
            layout:'border',
            disabled:true,
            items:[grdCgg_res_solicitud_requisito],
            tbar:[{
                iconCls:'iconNuevo',
                tooltip:'Agregar requisito',
                handler:function(){
                    var rFilaRequisitoSolicitud = new rSolicitudRequisito({
                        CRSRQ_CODIGO:'KEYGEN',
                        CRTSR_CODIGO:'KEYGEN',
                        CRREQ_CODIGO:null,
                        CRSRQ_DESCRIPCION:'',
                        CRSRQ_REQUERIDO:false,
                        CRSRQ_PARTICIPANTE:0
                    });
                    reSolicitudRequisito.stopEditing();
                    sCgg_res_solicitud_requisito.insert(0,rFilaRequisitoSolicitud);
                    grdCgg_res_solicitud_requisito.getView().refresh();
                    grdCgg_res_solicitud_requisito.getSelectionModel().selectRow(0);
                    reSolicitudRequisito.startEditing(0);
                }
            },{
                iconCls:'iconEliminar',
                tooltip:'Eliminar requisito',
                handler:function(){
                    var seleccionado = grdCgg_res_solicitud_requisito.getSelectionModel().getSelected();
                    if(seleccionado != null ){
                        grdCgg_res_solicitud_requisito.getStore().remove(seleccionado);
                    }else if(grdCgg_res_solicitud_requisito.getStore().getCount()>=1){
                        grdCgg_res_solicitud_requisito.getSelectionModel().selectLastRow();
                        grdCgg_res_solicitud_requisito.getStore().remove(grdCgg_res_solicitud_requisito.getSelectionModel().getSelected());
                    }
                }
            }]
        },{
            id:'tpGarantia',
            title: 'Garant\u00EDas',
            layout:'border',
            items:[grdCgg_res_garantia_solicitud],
            disabled:true,
            tbar:[{
                iconCls:'iconNuevo',
                handler:function(){

                    var rFilaGarantiaSolicitud = new rGarantiaSolicitud({
                        CRGTS_CODIGO:'KEYGEN',
                        CRGRT_CODIGO:'',
                        CRTST_CODIGO:'KEYGEN'
                    });
                    reGarantia.stopEditing();
                    sCgg_res_garantia_solicitud.insert(0,rFilaGarantiaSolicitud);
                    grdCgg_res_garantia_solicitud.getView().refresh();
                    grdCgg_res_garantia_solicitud.getSelectionModel().selectRow(0);
                    reGarantia.startEditing(0);
                }
            },{
                iconCls:'iconEliminar',
                handler:function(){
                    var seleccionado = grdCgg_res_garantia_solicitud.getSelectionModel().getSelected();
                    if(seleccionado != null ){
                        grdCgg_res_garantia_solicitud.getStore().remove(seleccionado);
                    }else if(grdCgg_res_garantia_solicitud.getStore().getCount()>=1){
                        grdCgg_res_garantia_solicitud.getSelectionModel().selectLastRow();
                        grdCgg_res_garantia_solicitud.getStore().remove(grdCgg_res_garantia_solicitud.getSelectionModel().getSelected());
                    }
                }
            }]
        },{
            id:'tpReglaValidacion',
            title: 'Reglas de validaci\u00F3n',
            disabled:true,
            layout:'border',
            items:[grdCgg_res_tipo_solicitud_regla],
            tbar:[{
                iconCls:'iconNuevo',
                tooltip:'Agregar regla',
                handler:function(){
                    var rFilaRegla = null;
                    var objReglaValidacion =  new Cgg_res_regla_validacion_lite();
                    var objDlgBusquedas = new DlgBusqueda(objReglaValidacion.getStore(),objReglaValidacion.getColumnModel(),false);
                    objDlgBusquedas.closeHandler(
                        function(){
                            var tmpRecordRegla =  objDlgBusquedas.getSelectedRow();
                            if(tmpRecordRegla)
                            {
                                recordRegla = tmpRecordRegla;
                                var tmpRuleExist =gsCgg_res_tipo_solicitud_regla.getAt(gsCgg_res_tipo_solicitud_regla.findExact('CRVAL_CODIGO',recordRegla.get('CRVAL_CODIGO')));
                                if (!tmpRuleExist)
                                {
                                    var tmpParams = recordRegla.get('CRVAL_FUNCION_PLSQL_PARAMETROS');
                                    //tmpParams = tmpParams.substring(1,tmpParams.length-1).split(',');
                                    if(tmpParams.length>0)
                                    {
                                        tmpParams = tmpParams.split(',');
                                        for(var i=0;i<(tmpParams.length-2);i++)
                                        {
                                            //alert(tmpParams[i]);
                                            var rFilaRegla = new rTipoSolicitudRegla({
                                                CRTSE_CODIGO:'KEYGEN',
                                                CRTST_CODIGO:inRecordCgg_res_tipo_solicitud_tramite != null?inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_CODIGO'):'',
                                                CRVAL_CODIGO:recordRegla.get('CRVAL_CODIGO'),
                                                CRVAL_NOMBRE:recordRegla.get('CRVAL_NOMBRE'),
                                                CRTSE_VALOR_1:tmpParams[i].toUpperCase(),
                                                CRTSE_CAMPO_EVALUACION:''
                                            });
                                            reTipoSolicitudRegla.stopEditing();
                                            gsCgg_res_tipo_solicitud_regla.insert(0,rFilaRegla);
                                            grdCgg_res_tipo_solicitud_regla.getView().refresh();
                                        }
                                        grdCgg_res_tipo_solicitud_regla.getSelectionModel().selectRow(0);
                                    }
                                //  reTipoSolicitudRegla.startEditing(0);
                                }
                            }
                        }
                        )
                    objDlgBusquedas.show();
                }
            },{
                iconCls:'iconEliminar',
                tooltip:'Eliminar regla',
                handler:function(){
                    var seleccionado = grdCgg_res_tipo_solicitud_regla.getSelectionModel().getSelected();
                    if(seleccionado != null ){
                        grdCgg_res_tipo_solicitud_regla.getStore().each(function(inRecord){
                            if(inRecord.get('CRVAL_NOMBRE')== seleccionado.get('CRVAL_NOMBRE')){
                                grdCgg_res_tipo_solicitud_regla.getStore().remove(inRecord);
                            }
                        });
                    }
                }
            }]
        },grdCgg_res_tst_aplica]
    });
  
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_tipo_solicitud_tramite.
     */
    var pnlCgg_res_tipo_solicitud_tramite = new Ext.form.FormPanel({
        frame:true,
        labelWidth :100,
        layout:'border',
        region:'center',
        items:[pnlTipoSolicitudNorte,pnlTabTipoSolicitud]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_tipo_solicitud_tramite.
     */
    var winFrmCgg_res_tipo_solicitud_tramite = new Ext.Window({
        id:'winFrmCgg_res_tipo_solicitud_tramite',
        layout:'border',
        title:tituloCgg_res_tipo_solicitud_tramite,
        tbar:getPanelTitulo(tituloCgg_res_tipo_solicitud_tramite,descCgg_res_tipo_solicitud_tramite),
        items:[pnlCgg_res_tipo_solicitud_tramite],
        width:800,
        height:550,
        modal:true,
        constrain:true,
        resizable:true,
        maximizable:true,
        iconCls:'iconTipoSolicitud',
        bbar:[btnGuardarCgg_res_tipo_solicitud_tramite,btnCancelarCgg_res_tipo_solicitud_tramite,'->',btnCerrarCgg_res_tipo_solicitud_tramite],
        listeners:{
            show:function(inThis){
                Ext.getCmp('pnlTabTipoSolicitud').activate('tpGarantia');
                Ext.getCmp('pnlTabTipoSolicitud').activate('tpRequisito');
            }
        }
    });
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_tipo_solicitud_tramite.
     */
    function cargarCgg_res_tipo_solicitud_tramiteCtrls(){
        if(inRecordCgg_res_tipo_solicitud_tramite){
            txtCrtst_codigo.setValue(inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_CODIGO'));

            tmpTipoSolicitudTramitePadre = inRecordCgg_res_tipo_solicitud_tramite.get('CGG_CRTST_CODIGO');

            var scpTramitePadre = new SOAPClientParameters();
            scpTramitePadre.add('inCrtst_codigo',tmpTipoSolicitudTramitePadre);
            scpTramitePadre.add('format',TypeFormat.JSON);
            var tmpCrtstRegistro = SOAPClient.invoke(urlCgg_res_tipo_solicitud_tramite, 'select', scpTramitePadre, false, null);
            try{
                tmpCrtstRegistro = Ext.util.JSON.decode(tmpCrtstRegistro);
                tmpTipoSolicitudTramitePadre = tmpCrtstRegistro[0].CRTST_CODIGO;
                txtCgg_crtst_codigo.setValue(tmpCrtstRegistro[0].CRTST_DESCRIPCION);
            }catch(inErr){
                tmpTipoSolicitudTramitePadre = null;
                tmpCrtstRegistro = null;
                txtCgg_crtst_codigo.setValue(NO_DATA_MESSAGE);
            }

            tmpTipoTramite = inRecordCgg_res_tipo_solicitud_tramite.get('CRTPT_CODIGO');
            txtCrtpt_codigo.setValue(getRecordFromStore(tmpStoreTipoStramite,'CRTPT_CODIGO',tmpTipoTramite,'CRTPT_NOMBRE'));

            tmpProceso = inRecordCgg_res_tipo_solicitud_tramite.get('CRPRO_CODIGO');

            var scpProceso = new SOAPClientParameters();
            scpProceso.add('inCrpro_codigo',tmpProceso);
            scpProceso.add('format',TypeFormat.JSON);

            SOAPClient.invoke(URL_WS+'Cgg_res_proceso', 'select', scpProceso, true, function(inServiceResponse){
                var tmpProceso1 = null;
                try{
                    tmpProceso1 = Ext.util.JSON.decode(inServiceResponse);
                    tmpProceso1 = tmpProceso1[0];
                                        
                    rProceso.set('CRPRO_CODIGO', tmpProceso1.CRPRO_CODIGO);
                    rProceso.set('CRPRO_NOMBRE', tmpProceso1.CRPRO_NOMBRE);
                    tmpProceso = rProceso;
                    txtCrpro_codigo.setValue(rProceso.get('CRPRO_NOMBRE'));
                            
                }catch(inErr){
                    txtCrpro_codigo.setValue(NO_DATA_MESSAGE);
                }
            });

            var scpResolucion = new SOAPClientParameters();
            scpResolucion.add('inCrres_codigo',inRecordCgg_res_tipo_solicitud_tramite.get('CRRES_CODIGO'));
            scpResolucion.add('format',TypeFormat.JSON);
            SOAPClient.invoke(URL_WS+'Cgg_res_resolucion', 'select', scpResolucion, true, function(inServiceResponse){
                var tmpResolucion1 = null;
                try{
                    tmpResolucion1 = Ext.util.JSON.decode(inServiceResponse);
                    tmpResolucion1 = tmpResolucion1[0];

                    rResolucion.set('CRRES_CODIGO', tmpResolucion1.CRRES_CODIGO);
                    rResolucion.set('CRRES_NUMERO_RESOLUCION', tmpResolucion1.CRRES_NUMERO_RESOLUCION);
                    tmpResolucion= rResolucion;
                    txtCrres_codigo.setValue(rResolucion.get('CRRES_NUMERO_RESOLUCION'));

                }catch(inErr){
                    txtCrpro_codigo.setValue(NO_DATA_MESSAGE);
                }
            });
            cbxCkesp_codigo.setValue(inRecordCgg_res_tipo_solicitud_tramite.get('CKESP_CODIGO'));
            txtCrtst_descripcion.setValue(inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_DESCRIPCION'));
            txtCrtst_observacion.setValue(inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_OBSERVACION'));
            chkCrtst_aplica_garantia.setValue(inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_APLICA_GARANTIA'));
            Ext.getCmp('tpGarantia').setDisabled(!inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_APLICA_GARANTIA'));

            chkCrtst_aplica_tramite.setValue(inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_APLICA_TRAMITE'));
            chkCrtst_aplica_grupo.setValue(inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_APLICA_GRUPO'));
            chkCrtst_atencion_cliente.setValue(inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_ATENCION_CLIENTE'));
            chkCrtst_restringido.setValue(inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_RESTRINGIDO'));
            Ext.getCmp('tpReglaValidacion').setDisabled(!inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_RESTRINGIDO'));

            chkCrtst_comunicado_radial.setValue(inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_COMUNICADO_RADIAL'));
            spfCrtst_numero_dias.setValue(inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_NUMERO_DIAS'));
            chkCrtst_vehiculo.setValue(inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_VEHICULO'));
            chkCrtst_unanimidad.setValue(inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_UNANIMIDAD'));
            chkCrtst_aplica_otro.setValue(inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_APLICA_OTRO'));
            numCrtst_indice.setValue(inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_INDICE'));

            chkCrtst_aplica_beneficiario.setValue(inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_APLICA_BENEFICIARIO'));
            sCgg_res_solicitud_requisito.reload({
                params:{
                    inCrtst_codigo:inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_CODIGO'),
                    format:"JSON"
                }
            });

            sCgg_res_garantia_solicitud.reload({
                params:{
                    inCrtst_codigo:inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_CODIGO'),
                    format:"JSON"
                }
            });
            gsCgg_res_tipo_solicitud_regla.reload({
                params:{
                    inCrtst_codigo:inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_CODIGO'),
                    format:"JSON"
                }
            });
            
            gsCgg_res_tst_aplica.reload({
                params:{
                    inCrtst_codigo:inRecordCgg_res_tipo_solicitud_tramite.get('CRTST_CODIGO'),
                    format:"JSON"
                }
            });

            isEdit = true;
        }
    }
    
    function obtenerReglasJson(){
        var tmpReglaGuardar ={};
        var tmpParams = {};
        var rRegla = null;
        var reglaJSON = [];
        var tmpNombreRegla =  null
        if(chkCrtst_restringido.getValue()==false){
            return Ext.util.JSON.encode(reglaJSON);
        }
        for(var i=0;i<gsCgg_res_tipo_solicitud_regla.getCount();i++){
            rRegla = gsCgg_res_tipo_solicitud_regla.getAt(i);
            if((tmpNombreRegla == null)||(tmpNombreRegla !=rRegla.get('CRVAL_NOMBRE')))
            {
                if(tmpNombreRegla != null)
                {
                    tmpReglaGuardar.CRTSE_CAMPO_EVALUACION = '['+Ext.util.JSON.encode(tmpParams)+']';//Ext.util.JSON.encode(tmpParams);
                    reglaJSON.push(tmpReglaGuardar);
                }
                tmpReglaGuardar ={};
                tmpParams = {};
                tmpReglaGuardar.CRTSE_CODIGO = rRegla.get('CRTSE_CODIGO');
                tmpReglaGuardar.CRTST_CODIGO = rRegla.get('CRTST_CODIGO');
                tmpReglaGuardar.CRVAL_CODIGO = rRegla.get('CRVAL_CODIGO');
                tmpReglaGuardar.CRVAL_NOMBRE = rRegla.get('CRVAL_NOMBRE');
                tmpReglaGuardar.CRTSE_VALOR_1  = '';
                tmpReglaGuardar.CRTSE_CAMPO_EVALUACION = '';
                tmpNombreRegla = rRegla.get('CRVAL_NOMBRE');
                tmpParams[rRegla.get('CRTSE_VALOR_1')] = rRegla.get('CRTSE_CAMPO_EVALUACION');

                if((i+1) == gsCgg_res_tipo_solicitud_regla.getCount()){
                    tmpReglaGuardar.CRTSE_CAMPO_EVALUACION = tmpReglaGuardar.CRTSE_CAMPO_EVALUACION = '['+Ext.util.JSON.encode(tmpParams)+']';//Ext.util.JSON.encode(tmpParams);
                    reglaJSON.push(tmpReglaGuardar);

                }
            }
            else
            {
                tmpParams[rRegla.get('CRTSE_VALOR_1')] = rRegla.get('CRTSE_CAMPO_EVALUACION');
                if((i+1) == gsCgg_res_tipo_solicitud_regla.getCount())
                {
                    tmpReglaGuardar.CRTSE_CAMPO_EVALUACION = tmpReglaGuardar.CRTSE_CAMPO_EVALUACION = '['+Ext.util.JSON.encode(tmpParams)+']';//Ext.util.JSON.encode(tmpParams);
                    reglaJSON.push(tmpReglaGuardar);

                }


            }
        }
        return Ext.util.JSON.encode(reglaJSON);
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_tipo_solicitud_tramite.
     * @returns ventana winFrmCgg_res_tipo_solicitud_tramite.
     * @base FrmCgg_res_tipo_solicitud_tramite.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_tipo_solicitud_tramite;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_tipo_solicitud_tramite.
     * @base FrmCgg_res_tipo_solicitud_tramite.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_tipo_solicitud_tramiteCtrls();
    }
    /**
	* Establece el store de las especies.
	*/
    this.setEspeciesStore = function (inStore) {
        cbxCkesp_codigo.store = inStore;
    }
	
	this.setStoreTipoTramite = function(inStoreTipoTramite){
		tmpStoreTipoStramite = inStoreTipoTramite;
	}
	
	this.setStoreGarantia = function(inStoreGarantia){
		cbxCRGRT_CODIGOEditor.store = inStoreGarantia;
	}
}
/**
 * Funcion prototipo. Establece el store de las especies.
 */
FrmCgg_res_tipo_solicitud_tramite.prototype.setEspeciesStore = function(inStore){
    this.setEspeciesStore(inStore);
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_tipo_solicitud_tramite desde una instancia.
 */
FrmCgg_res_tipo_solicitud_tramite.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_tipo_solicitud_tramite desde una instancia.
 */
FrmCgg_res_tipo_solicitud_tramite.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_tipo_solicitud_tramite,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_tipo_solicitud_tramite.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_tipo_solicitud_tramite desde una instancia.
 */
FrmCgg_res_tipo_solicitud_tramite.prototype.loadData = function(){
    this.loadData();
}

FrmCgg_res_tipo_solicitud_tramite.prototype.setStoreTipoTramite = function(inStoreTipoTramite){
    this.setStoreTipoTramite(inStoreTipoTramite);
}


FrmCgg_res_tipo_solicitud_tramite.prototype.setStoreGarantia = function(inStoreGarantia){
    this.setStoreGarantia(inStoreGarantia);
}
