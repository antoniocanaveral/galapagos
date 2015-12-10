/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_dhu_seguimiento_economico.
 * @param {String} INSENTENCIA_CGG_DHU_SEGUIMIENTO_ECONOMICO Sentencia (insert/update) para el tratamiento de la informacion.
 * @param {Ext.data.Record} INRECORD_CGG_DHU_SEGUIMIENTO_ECONOMICO Registro de datos de la tabla Cgg_dhu_seguimiento_economico.
 * @constructor
 * @base FrmListadoCgg_dhu_seguimiento_economico
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_dhu_seguimiento_economico(INSENTENCIA_CGG_DHU_SEGUIMIENTO_ECONOMICO,INRECORD_CGG_DHU_SEGUIMIENTO_ECONOMICO){
    var inSentenciaCgg_dhu_seguimiento_economico = INSENTENCIA_CGG_DHU_SEGUIMIENTO_ECONOMICO;
    var inRecordCgg_dhu_seguimiento_economico=INRECORD_CGG_DHU_SEGUIMIENTO_ECONOMICO;
    var urlCgg_dhu_seguimiento_economico=URL_WS+"Cgg_dhu_seguimiento_economico";
    var tituloCgg_dhu_seguimiento_economico='Seguimiento econ\u00F3mico';
    var descCgg_dhu_seguimiento_economico='El formulario permite administrar informaci\u00f3n del seguimiento econ\u00F3mico';
    var isEdit = false;
    var tmpInformacionBecaSeguimiento;
   
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO SEGUIMIENTO ECONOMICO
     */
    var txtCdsec_codigo = new Ext.form.TextField({
        id:'txtCdsec_codigo',
        name:'txtCdsec_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        maxLength :20
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE CONCEPTO DE DESEMBOLSO
     */
    var txtCdtcp_codigo = new Ext.form.TextField({
        id:'txtCdtcp_codigo',
        name:'txtCdtcp_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE CONCEPTO DE DESEMBOLSO
     */
    var btnCdtcp_codigoCgg_dhu_seguimiento_economico = new Ext.Button({
        id:'btnCdtcp_codigoCgg_dhu_seguimiento_economico',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_dhu_tipo_concepto = new FrmListadoCgg_dhu_tipo_concepto();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_tipo_concepto.getStore(),tmpFLCgg_dhu_tipo_concepto.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if(tmpRecord){
                        txtCdtcp_codigo.setValue(tmpRecord.get('CDTCP_CODIGO'));
                    }
                });
                objBusqueda.show();
            }}
    });
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
     */
    var txtCdacd_codigo = new Ext.form.TextField({
        id:'txtCdacd_codigo',
        name:'txtCdacd_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        allowBlank :false,
        readOnly:'true',
        maxLength :20
    });
    /**
             * Ext.form.Checkbox DETERMINA SI SE DA POR TERMINADO EL DESEMBOLSO DE ESE CICLO
             */
            var chkCdsec_desembolso = new Ext.form.Checkbox({
                id:'chkCdsec_desembolso',
                name:'chkCdsec_desembolso',
                fieldLabel :'Ultimo desembolso',
                checked:false,
                listeners: {
                    check: function(){
                        if(chkCdsec_desembolso.getValue()==true){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_seguimiento_economico,
                                msg: 'Cierre de registro de desembolso.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO});
                            chkCdsec_desembolso.disable();


                        }
                    }
                }
            });

     /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
     */
    var txtCdacd_num_doc = new Ext.form.TextField({
        id:'txtCdacd_num_doc',
        name:'txtCdacd_num_doc',
        fieldLabel :'No. Documento',
        anchor:'98%',
                listeners: {
            specialkey: function(field, e){
                if (e.getKey() == e.ENTER) {
                    try{
                        function CallBackCgg_dhu_seguimiento_academico(r){
                            tmpInformacionBecaSeguimiento = Ext.util.JSON.decode(r)[0];
                            if(tmpInformacionBecaSeguimiento!=null){
                                txtCdacd_codigo.setValue(tmpInformacionBecaSeguimiento.CDACD_CODIGO);
                                tmpInfoPersonaSeguimientoAcademico.overwrite(Ext.getCmp('pnlCgg_dhu_seguimiento_aca_economico').body,tmpInformacionBecaSeguimiento);

                            }else{
                                Ext.Msg.show({
                                    title:tituloCgg_dhu_seguimiento_economico,
                                    msg: 'No existe el registro solicitado.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO});
                            }

                        }
                        var param = new SOAPClientParameters();
                        param.add('in_crper_num_doc_identific',txtCdacd_num_doc.getValue());
                        param.add('format',TypeFormat.JSON);
                        SOAPClient.invoke(URL_WS+"Cgg_dhu_seguimiento_economico","selectSeguimientoAcademico",param, true, CallBackCgg_dhu_seguimiento_academico);
                    }catch(inErr){
                        //winFrmCgg_institucion_educativa.getEl().unmask();
                    }

                }
            }
        }
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_seguimiento_academico.
     */
       function SeguimientoAcademico() {
        var cmSeguimientoAcademico = null;
        var gsSeguimientoAcademico = null;
         cmSeguimientoAcademico = new Ext.grid.ColumnModel([
        {dataIndex:'CDBEC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDACD_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_NOMBRES',header:'Nombre',width:150,sortable:true},
        {dataIndex:'CRPER_APELLIDOS_PERSONA',header:'Apellidos',width:150,sortable:true},
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'No.documento',width:150,sortable:true},
        {dataIndex:'CRPER_NUMERO_RESIDENCIA',header:'No.residencia',width:150,sortable:true},
        {dataIndex:'CDBEC_NUMERO_CONVENIO',header:'No. convenio',width:150,sortable:true},
        {dataIndex:'CDBEC_FUNCIONARIO',header:'Funcionario',width:150,sortable:true},
        {dataIndex:'CGESP_NOMBRE',header:'Especialidad',width:150,sortable:true},
        {dataIndex:'CDBEC_TIPO_CICLO',header:'Total ciclo',width:150,sortable:true,renderer:function(inCdbsegTipoCiclo){
            if(inCdbsegTipoCiclo==TypeCiclo.ANUAL)
            {return('ANUAL');}
             if(inCdbsegTipoCiclo==TypeCiclo.SEMESTRAL)
            {return('SEMESTRAL');}
             if(inCdbsegTipoCiclo==TypeCiclo.QUIMESTRAL)
            {return('QUIMESTRAL');}
             if(inCdbsegTipoCiclo==TypeCiclo.OTROS)
            {return('OTROS');}
        }},
        {dataIndex:'CDACD_NUMERO_CICLO',header:'Numero ciclo',width:150,sortable:true},
        {dataIndex:'CDACD_FECHA_INICIO',header:'Fecha inicio',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CDACD_FECHA_FIN',header:'Fecha fin',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CDACD_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true},
        {dataIndex:'CDACD_ESTADO_APROBACION',header:'Estado aprobaci\u00f3n',width:150,sortable:true,renderer:function(inCdbacdAprobacion){
            if(inCdbacdAprobacion==TypeEstadoCicloAcademico.NO_APROBADO)
            {return('NO APROBADO');}
            if(inCdbacdAprobacion==TypeEstadoCicloAcademico.REGISTRADO)
            {return('REGISTRADO');}
             if(inCdbacdAprobacion==TypeEstadoCicloAcademico.POR_APROBAR)
            {return('POR APROBAR');}
             if(inCdbacdAprobacion==TypeEstadoCicloAcademico.APROBADO)
            {return('APROBAR');}
             if(inCdbacdAprobacion==TypeEstadoCicloAcademico.OTROS)
            {return('OTROS');}
        }}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_seguimiento_academico por un campo especifico.
     */
    var gsSeguimientoAcademico = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_seguimiento_economico",
            method:"selectPageSeguimiento",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDACD_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDBEC_CODIGO'},
            {name:'CDACD_CODIGO'},
            {name:'CDTBC_CODIGO'},
            {name:'CDTBC_NOMBRE'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDOS_PERSONA'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_NUMERO_RESIDENCIA'},
            {name:'CDBEC_NUMERO_CONVENIO'},
            {name:'CDBEC_FUNCIONARIO'},
            {name:'CGESP_NOMBRE'},
            {name:'CDBEC_TIPO_CICLO'},
            {name:'CDACD_NUMERO_CICLO'},
            {name:'CDACD_FECHA_INICIO'},
            {name:'CDACD_FECHA_FIN'},
            {name:'CDACD_OBSERVACION'},
            {name:'CDACD_ESTADO_APROBACION'}
        ]),
        sortInfo:{field: 'CDBEC_NUMERO_CONVENIO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
     this.getCm = function() {
            return cmSeguimientoAcademico;
        };

        this.getStore = function() {
            return gsSeguimientoAcademico;
        }
    }

    SeguimientoAcademico.prototype.getColumnModel = function() {
        return this.getCm();
    };

    SeguimientoAcademico.prototype.getStore = function() {
        return this.getStore();
    };

    /**
     * IDENTIFICATIVO UNICO DE REGISTRO DE SEGUIMIENTO ACADEMICO
     */
    var btnCdacd_codigoCgg_dhu_seguimiento_economico = new Ext.Button({
        id:'btnCdacd_codigoCgg_dhu_seguimiento_economico',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){
                var tmpFLCgg_dhu_seguimiento_academico = new SeguimientoAcademico();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_dhu_seguimiento_academico.getStore(),tmpFLCgg_dhu_seguimiento_academico.getColumnModel());
                objBusqueda.closeHandler(function(){
                    var tmpSegcoRecord = objBusqueda.getSelectedRow();
                    if(tmpSegcoRecord){
                        txtCdacd_codigo.setValue(tmpSegcoRecord.get('CDACD_CODIGO'));
                        txtCdacd_num_doc.setValue(tmpSegcoRecord.get('CRPER_NUM_DOC_IDENTIFIC'));
                        //if(tmpSegcoRecord.get('CDACD_CODIGO')=='APROBADO'){
                        tmpInfoPersonaSeguimientoAcademico.overwrite(Ext.getCmp('pnlCgg_dhu_seguimiento_aca_economico').body,tmpSegcoRecord.json);
                        /*}else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_seguimiento_economico,
                                msg: 'No puede realizar el registro de la transferencia no esta aprobado el ciclo',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }*/


                    }
                });
                objBusqueda.show();
            }}
    });
        var datosPersonaSeguimiento= {
           CRPER_NOMBRES:'0',
           CRPER_APELLIDOS_PERSONA:'0',
           CDBEC_NUMERO_CONVENIO:'0',
           CRPER_NUM_IDENTIFIC:'0',
           CGESP_NOMBRE:'0',
           CDBEC_FUNCIONARIO:'0',
           CDACD_ESTADO_APROBACION:'0',
           CDACD_NUMERO_CICLO:'0'
       };
    /*template de la consulta de PERSONA Y DATOS DEL SEGUIMIENTO ACADEMICO*/
       var tmpInfoPersonaSeguimientoAcademico = new Ext.XTemplate(
               '<table width="100%" height="100%" cellpadding="0">' +
                       '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Nombres:</font></div></td>' +
                       '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_NOMBRES}</font></td></td>' +
                       '<td><div class="tituloTemplate"<font  face="Arial, Helvetica, sans-serif">Apellidos:</font></div></td>' +
                       '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_APELLIDOS_PERSONA}</font></td></td>' +
                       '<tr rowspan="0"><td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Convenio:</font></div></td>' +
                       '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDBEC_NUMERO_CONVENIO}</font></td></td>' +
                       '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Funcionario:</font></div></td>' +
                       '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDBEC_FUNCIONARIO}</font></td></td>' +
                       '<tr rowspan="0"><td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Ciclo academico:</font></div></td>' +
                       '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDACD_NUMERO_CICLO}</font></td></td>' +
                       '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Estado:</font></div></td>' +
                       ' <td><font size="1" face="Arial, Helvetica, sans-serif">',
                        '<tpl if="CDACD_ESTADO_APROBACION ==TypeEstadoCicloAcademico.NO_APROBADO">',
                        '<span style="font-weight: bold;">No Aprobado</span>',
                        '</tpl>',
                        '<tpl if="CDACD_ESTADO_APROBACION ==TypeEstadoCicloAcademico.REGISTRADO">',
                        '<span style="font-weight: bold;">Registrado</span>',
                        '</tpl>',
                        '<tpl if="CDACD_ESTADO_APROBACION ==TypeEstadoCicloAcademico.POR_APROBAR">',
                        '<b>Por Aprobar</b>',
                        '</tpl>',
                         '<tpl if="CDACD_ESTADO_APROBACION ==TypeEstadoCicloAcademico.APROBADO">',
                        '<b>Aprobado</b>',
                        '</tpl>',
                         '<tpl if="CDACD_ESTADO_APROBACION ==TypeEstadoCicloAcademico.OTROS">',
                        '<b>Otros</b>',
                        '</tpl>',
                        '</font></td>' +
                       '</table>'

               );
    /*template de la consulta de PERSONA Y DATOS DEL SEGUIMIENTO ACADEMICO*/
       var tmpInfoPersonaSeguimientoAcademicoEdit = new Ext.XTemplate(
               '<table width="100%" height="100%" cellpadding="0">' +
                       '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Nombres:</font></div></td>' +
                       '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_NOMBRES}</font></td></td>' +
                       '<td><div class="tituloTemplate"<font  face="Arial, Helvetica, sans-serif">Apellidos:</font></div></td>' +
                       '<td><font size="1" face="Arial, Helvetica, sans-serif">{CRPER_APELLIDO_PATERNO} {CRPER_APELLIDO_MATERNO}</font></td></td>' +
                       '<tr rowspan="0"><td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Convenio:</font></div></td>' +
                       '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDBEC_NUMERO_CONVENIO}</font></td></td>' +
                       '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Funcionario:</font></div></td>' +
                       '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDBEC_FUNCIONARIO}</font></td></td>' +
                       '<tr rowspan="0"><td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Ciclo academico:</font></div></td>' +
                       '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDACD_NUMERO_CICLO}</font></td></td>' +
                       '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Estado:</font></div></td>' +
                       ' <td><font size="1" face="Arial, Helvetica, sans-serif">',
                        '<tpl if="CDACD_ESTADO_APROBACION ==TypeEstadoCicloAcademico.NO_APROBADO">',
                        '<span style="font-weight: bold;">No Aprobado</span>',

                        '</tpl>',
                        '<tpl if="CDACD_ESTADO_APROBACION ==TypeEstadoCicloAcademico.POR_APROBAR">',
                        '<b>Por Aprobar</b>',
                        '</tpl>',
                         '<tpl if="CDACD_ESTADO_APROBACION ==TypeEstadoCicloAcademico.APROBADO">',
                        '<b>Aprobado</b>',
                        '</tpl>',
                         '<tpl if="CDACD_ESTADO_APROBACION ==TypeEstadoCicloAcademico.OTROS">',
                        '<b>Otros</b>',
                        '</tpl>',
                        '</font></td>' +
                       '</table>'

               );
    /**
     * Ext.form.TextField CODIGO ESPECIAL IDENTIFICATIVO DE  LA TRANSFERENCIA REALIZAD POR PARTE DEL CGG HACIA EL IECE
     */
    var txtCdsec_codigo_transferencia = new Ext.form.TextField({
        id:'txtCdsec_codigo_transferencia',
        name:'txtCdsec_codigo_transferencia',
        fieldLabel :'Cod. trans beca',
        anchor:'98%'

    });
    /**
     * Ext.form.NumberField VALOR DE LA TRANSFERENCIA
     */
    var numCdsec_valor = new Ext.form.NumberField({
        id:'numCdsec_valor',
        name:'numCdsec_valor',
        fieldLabel :'Valor'});/**
     * Ext.form.DateField FECHA DE REALIZACION  DEL DESEMBOLSO
     */
    var dtCdsec_fecha_transferencia = new Ext.form.DateField({
        id:'dtCdsec_fecha_transferencia',
        name:'dtCdsec_fecha_transferencia',
        fieldLabel :'Fecha trans beca',
        value:new Date()
    });
    /**
     * Ext.form.TextField CODIGO ESPECIAL IDENTIFICATIVO DE  LA TRANSFERENCIA REALIZAD POR PARTE DEL IECE AL BENEFICIARIO
     */
    var txtCdsec_codigo_transf_iece = new Ext.form.TextField({
        id:'txtCdsec_codigo_transf_iece',
        name:'txtCdsec_codigo_transf_iece',
        fieldLabel :'Cod trans iece',
        anchor:'98%'
    });
    /**
     * Ext.form.NumberField VALOR DE LA TRANSFERENCIA DEL IECE AL BENEFICIARIO
     */
    var numCdsec_valor_iece = new Ext.form.NumberField({
        id:'numCdsec_valor_iece',nname:'numCdsec_valor_iece',
        fieldLabel :'Valor iece',disabled :false});/**
     * Ext.form.DateField FECHA DE REALIZACION  DEL DESEMBOLSO DEL IECE AL BENEFICIARIO
     */
    var dtCdsec_fecha_transf_iece = new Ext.form.DateField({
        id:'dtCdsec_fecha_transf_iece',
        name:'dtCdsec_fecha_transf_iece',
        fieldLabel :'Fecha transf iece',
        allowBlank :false,
        value:new Date()
    });
    /**
     * Ext.form.TextArea OBSERVACION DE LA TRANSFERENCIA - FORMATO JSON
     */
    var txtCdsec_observacion = new Ext.form.TextArea({
        id:'txtCdsec_observacion',
        name:'txtCdsec_observacion',
        fieldLabel :'Observaci\u00f3n',
        width:'90%'
    });
     //Creamos una definici?n de los campos que vienen en el Json remoto para seleccionar el tipo de concepto de desembolso
	/**
	 * Ext.data.Store Almacenamiento de informacion de certificado academico.
	 */
	var strTipoConceptoDesembolso = new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_dhu_tipo_concepto",
			method:"selectAll"
		}),
		reader:new Ext.data.JsonReader({},[
			{name:'CDTCP_CODIGO'},
			{name:'CDTCP_NOMBRE_DESEMBOLSO'}
		]),
		baseParams:{
			format:TypeFormat.JSON
		},
		listeners:{
			load:function(){
				cbxTipoConcepto.store = strTipoConceptoDesembolso;
				if (isEdit)
				cbxTipoConcepto.setValue(inRecordCgg_dhu_seguimiento_economico.get('CDTCP_CODIGO'));
			}
		}
	});
	strTipoConceptoDesembolso.load();
	
    var cbxTipoConcepto = new Ext.form.ComboBox({
        id:'cbxTipoConcepto',
        name:'cbxTipoConcepto',
        displayField: "CDTCP_NOMBRE_DESEMBOLSO",
        fieldLabel :'Desembolso',
        valueField: 'CDTCP_CODIGO',
        mode:'local',
        typeAhead:true,
        autoSelect:true,
        hiddenId:'cbxTipoConceptoH',
        hiddenName:'cbxTipoConceptoH',
        hiddenValue:'id',
        forceSelection:true,
        editable: true,
        triggerAction:'all',
        submitValue:true,
        anchor:'75%',
        emptyText : 'Seleccione una opci\u00f3n..'

    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_dhu_seguimiento_economico
     */
    var btnGuardarCgg_dhu_seguimiento_economico = new Ext.Button({
        id:'btnGuardarCgg_dhu_seguimiento_economico',
        text:'Guardar',
        iconCls:'iconGuardar',
        listeners:{
            click:function(){
                if (pnlCgg_dhu_seguimiento_economico.getForm().isValid()==false){
                    return;
                }
                    var tmpTrans=null;
                    var tmpTrans1=0;
                    var tmpTrans2=null;

                    if (txtCdsec_codigo_transferencia.getValue()!=null && txtCdsec_codigo_transferencia.getValue()!=undefined) {
                        tmpTrans=txtCdsec_codigo_transferencia.getValue();
                    }else {
                        tmpTrans=null;
                    }
                    if (numCdsec_valor.getValue()) {
                        tmpTrans1=numCdsec_valor.getValue();
                    }else {
                        tmpTrans1=0;
                    }
/*!=null && dtCdsec_fecha_transferencia.getValue()!=undefined) {*/
                    if (dtCdsec_fecha_transferencia.getValue()){
					
                        tmpTrans2=dtCdsec_fecha_transferencia.getValue();
                    }else {
                        tmpTrans2=null;
                    }

                try{
                    function CallBackCgg_dhu_seguimiento_economico(r){
                        winFrmCgg_dhu_seguimiento_economico.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloCgg_dhu_seguimiento_economico,
                                msg: 'La informaci\u00f3n  ha sido almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });winFrmCgg_dhu_seguimiento_economico.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloCgg_dhu_seguimiento_economico,
                                msg: 'La informaci\u00f3n  no ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    winFrmCgg_dhu_seguimiento_economico.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    if(isEdit)
                    param.add('inCdsec_codigo',txtCdsec_codigo.getValue());
                    param.add('inCdtcp_codigo',cbxTipoConcepto.getValue());
                    param.add('inCdacd_codigo',txtCdacd_codigo.getValue());
                    param.add('inCdsec_codigo_transferencia',tmpTrans);
                    param.add('inCdsec_valor',tmpTrans1);
                    param.add('inCdsec_fecha_transferencia',tmpTrans2);
                    param.add('inCdsec_codigo_transf_iece',txtCdsec_codigo_transf_iece.getValue());
                    param.add('inCdsec_valor_iece',numCdsec_valor_iece.getValue());
                    param.add('inCdsec_fecha_transf_iece',dtCdsec_fecha_transf_iece.getValue().format('c'));
                    param.add('inCdsec_observacion',txtCdsec_observacion.getValue());
                    param.add('inCdsec_cierre_desembolso',chkCdsec_desembolso.getValue());
                    SOAPClient.invoke(urlCgg_dhu_seguimiento_economico,INSENTENCIA_CGG_DHU_SEGUIMIENTO_ECONOMICO,param, true, CallBackCgg_dhu_seguimiento_economico);
                }catch(inErr){
                    winFrmCgg_dhu_seguimiento_economico.getEl().unmask();
                }
            }}
    });
    /**
     * Boton que permite cancelar los cambios de la informacion de la ventana winFrmCgg_dhu_seguimiento_economico.
     */
    var btnCancelarCgg_dhu_seguimiento_economico = new Ext.Button({
        id:'btnCancelarCgg_dhu_seguimiento_economico',
        text:'Cancelar',
        iconCls:'iconCancelar',
        listeners:{
            click:function(){
                pnlCgg_dhu_seguimiento_economico.getForm().reset();
            }}
    });
    /**
     * Boton que permite cerrar la ventana winFrmCgg_dhu_seguimiento_economico.
     */
    var btnCerrarCgg_dhu_seguimiento_economico = new Ext.Button({
        id:'btnCerrarCgg_dhu_seguimiento_economico',
        text:'Cerrar',
        iconCls:'iconCerrar',
        listeners:{
            click:function(){
                winFrmCgg_dhu_seguimiento_economico.close();
            }}
    });
         /**
     * Ext.Panel Panel que contiene los datos informativos del seguimiento academico
     */
    var pnlCgg_dhu_inf_seguimiento_academico = new Ext.form.FieldSet({
        id:'pnlCgg_dhu_inf_seguimiento_academico',
        title:'Seguimiento Acad\u00E9mico',
        collapsible:true,
        region:'north',
        height:120,
           items:[{xtype:'panel', id :'pnlCgg_dhu_seguimiento_aca_economico',data:datosPersonaSeguimiento,tlp:tmpInfoPersonaSeguimientoAcademico} ]
    });
     /* ExtPanel Panel que contiene los controles de la transferencia del cgg
     */
    var pnlfsTransferenciaCgg = new Ext.form.FieldSet({
        id:'pnlfsTransferenciaCgg',
        title:'Transferencia becario',
        collapsible:true,
        region:'center',
        labelWidth :100,
        items:[txtCdsec_codigo_transferencia,numCdsec_valor,dtCdsec_fecha_transferencia]
    });
      /* ExtPanel Panel que contiene los controles de la transferencia al iese
     */
    var pnlfsTransferenciaIECE = new Ext.form.FieldSet({
        id:'pnlfsTransferenciaIECE',
        title:'Transferencia IECE',
        collapsible:true,
        region:'center',
        labelWidth :100,
        items:[txtCdsec_codigo_transf_iece, numCdsec_valor_iece,dtCdsec_fecha_transf_iece]
    });

     /**
     * Ext.form.FormPanel Panel para las Transferencias
     */
    var pnlOrganizacionTransferencia = new Ext.Panel({
        id:'pnlOrganizacionTransferencia',
        region:'center',
        items:[
            {xtype:'panel',layout:'column',
                items:[
                    {columnWidth:.50,layout:'form',
                        items:[pnlfsTransferenciaIECE]},
                    {columnWidth:.50,layout:'form',
                        items:[pnlfsTransferenciaCgg]}
                ]}
        ]
    });

    /**
       * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_dhu_seguimiento_economico.
       */

    var pnlCgg_dhu_seguimiento_economico  = new Ext.form.FormPanel({
        id:'pnlCgg_dhu_seguimiento_academico',
        frame:true,
        layout:'form',
		region :'center',
        labelWidth :100,
        items:[{xtype:'panel',layout:'column',
            items:[{columnWidth:.45,layout:'form',
                items:[txtCdacd_num_doc]},
                {columnWidth:.05,layout:'form',
                items:[btnCdacd_codigoCgg_dhu_seguimiento_economico]},
            {columnWidth:.50,layout:'form',
                items:[cbxTipoConcepto]}]},pnlCgg_dhu_inf_seguimiento_academico,pnlOrganizacionTransferencia,txtCdsec_observacion,chkCdsec_desembolso]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_dhu_seguimiento_economico.
     */
    var winFrmCgg_dhu_seguimiento_economico = new Ext.Window({
        id:'winFrmCgg_dhu_seguimiento_economico',
        title:tituloCgg_dhu_seguimiento_economico,
        tbar:getPanelTitulo(tituloCgg_dhu_seguimiento_economico,descCgg_dhu_seguimiento_economico),
        items:[pnlCgg_dhu_seguimiento_economico],
        width:600,
        minWidth:600,
		height : 400,
        maximizable:false,
        minimizable:false,
        constrain:true,
		modal:true,
		layout : 'border',
		//resizable : false,
        bbar:[btnGuardarCgg_dhu_seguimiento_economico,btnCancelarCgg_dhu_seguimiento_economico,'->',btnCerrarCgg_dhu_seguimiento_economico],
        listeners:{
            show:function(){
                if(isEdit){
                if(INRECORD_CGG_DHU_SEGUIMIENTO_ECONOMICO)
                {
                    txtCdacd_num_doc.setVisible(false);
                    btnCdacd_codigoCgg_dhu_seguimiento_economico.setVisible(false);
                    cbxTipoConcepto.setVisible(false);
                    tmpInfoPersonaSeguimientoAcademicoEdit.overwrite( Ext.getCmp('pnlCgg_dhu_seguimiento_aca_economico').body,inRecordCgg_dhu_seguimiento_economico.json);
                }
                else
                {
                    alert('No se puede mostrar la informaci\u00f3n');
                }
                }
            }
        }
    });
    /**
     * Funcion que permite habilitar los controles que contienen la informacion de la ventana winFrmCgg_dhu_seguimiento_economico.
     * @param {Boolean} inEstado Estado (true/false) para la habilitacion de los controles.
     */
    function habilitarCgg_dhu_seguimiento_economicoCtrls(inEstado){
        estado=!inEstado;
        txtCdsec_codigo.setDisabled(estado);
        cbxTipoConcepto.setDisabled(estado);
        txtCdacd_codigo.setDisabled(estado);
        txtCdsec_codigo_transferencia.setDisabled(estado);
        numCdsec_valor.setDisabled(estado);
        dtCdsec_fecha_transferencia.setDisabled(estado);
        txtCdsec_codigo_transf_iece.setDisabled(estado);
        numCdsec_valor_iece.setDisabled(estado);
        dtCdsec_fecha_transf_iece.setDisabled(estado);
        txtCdsec_observacion.setDisabled(estado);
    }
    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_dhu_seguimiento_economico.
     */
    function cargarCgg_dhu_seguimiento_economicoCtrls(){
        if(inRecordCgg_dhu_seguimiento_economico){
            txtCdsec_codigo.setValue(inRecordCgg_dhu_seguimiento_economico.get('CDSEC_CODIGO'));
            //cbxTipoConcepto.setValue(inRecordCgg_dhu_seguimiento_economico.get('CDTCP_CODIGO'));
            txtCdacd_codigo.setValue(inRecordCgg_dhu_seguimiento_economico.get('CDACD_CODIGO'));
            txtCdsec_codigo_transferencia.setValue(inRecordCgg_dhu_seguimiento_economico.get('CDSEC_CODIGO_TRANSFERENCIA'));
            numCdsec_valor.setValue(inRecordCgg_dhu_seguimiento_economico.get('CDSEC_VALOR'));
            dtCdsec_fecha_transferencia.setValue(truncDate(inRecordCgg_dhu_seguimiento_economico.get('CDSEC_FECHA_TRANSFERENCIA')));
            txtCdsec_codigo_transf_iece.setValue(inRecordCgg_dhu_seguimiento_economico.get('CDSEC_CODIGO_TRANSF_IECE'));
            numCdsec_valor_iece.setValue(inRecordCgg_dhu_seguimiento_economico.get('CDSEC_VALOR_IECE'));
            dtCdsec_fecha_transf_iece.setValue(truncDate(inRecordCgg_dhu_seguimiento_economico.get('CDSEC_FECHA_TRANSF_IECE')));
            txtCdsec_observacion.setValue(inRecordCgg_dhu_seguimiento_economico.get('CDSEC_OBSERVACION'));
            chkCdsec_desembolso.setVisible(false);
            isEdit = true;
            habilitarCgg_dhu_seguimiento_economicoCtrls(true);
        }}
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_dhu_seguimiento_economico.
     * @returns ventana winFrmCgg_dhu_seguimiento_economico.
     * @base FrmCgg_dhu_seguimiento_economico.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_dhu_seguimiento_economico;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_dhu_seguimiento_economico.
     * @base FrmCgg_dhu_seguimiento_economico.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_dhu_seguimiento_economicoCtrls();
    }}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_dhu_seguimiento_economico desde una instancia.
 */
FrmCgg_dhu_seguimiento_economico.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_dhu_seguimiento_economico desde una instancia.
 */
FrmCgg_dhu_seguimiento_economico.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_dhu_seguimiento_economico,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_dhu_seguimiento_economico.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_dhu_seguimiento_economico desde una instancia.
 */
FrmCgg_dhu_seguimiento_economico.prototype.loadData = function(){
    this.loadData();
}
