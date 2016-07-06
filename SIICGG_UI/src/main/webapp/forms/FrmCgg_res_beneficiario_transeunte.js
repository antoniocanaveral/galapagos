/**
 * Funcion publica. Formulario que permite administrar la informacion a travez de las operaciones basicas de insercion y actualizacion de los registros de tabla Cgg_res_beneficiario.
 * @param {Ext.data.Record} Record con informacion del beneficiario a registrarse.  
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_beneficiario_transeunte(inRecordCgg_res_beneficiario,INRECORD_TIPO_SOLICITUD){

    var tituloCgg_res_beneficiario='Informaci\u00f3n de beneficiario';
    var descCgg_res_beneficiario='Ingreso de informaci\u00f3n del beneficiario';
    var isEdit = false;
    var tmpRecordPersona =  null;    

    /******************INICIO DE DEFINICION DE VARIABLES PARA REGLA DE VALIDACION DE INFORMACION*******************/
    var reglasValidacion = null;
    var objReglasValidacion = null;
    var crperCodigo = null;
    var cggcrperCodigo = null;
    var crperNumDocIdentific=null;
    var cggCrperFechaNacimiento = null;
    /******************FIN DE DEFINICION DE VARIABLES PARA REGLA DE VALIDACION DE INFORMACION*******************/
    
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DEL BENEFICIARIO
     */
    var txtCrben_codigo = new Ext.form.TextField({
        id:'txtCrben_codigo',
        name:'txtCrben_codigo',
        fieldLabel :'Codigo',
        anchor:'98%',
        value:"KEYGEN",
        hidden:true,
        hideLabel:true,
        allowBlank :false
    });
    /**
     * Ext.form.TextField NOMBRES DEL BENEFICIARIO
     */
    var txtCrben_nombres = new Ext.form.TextField({
        id:'txtCrben_nombres',
        name:'txtCrben_nombres',
        fieldLabel :'Nombres',
        anchor:'99%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField APELLIDO PATERNO DE BENEFICIARIO
     */
    var txtCrben_apellido_paterno = new Ext.form.TextField({
        id:'txtCrben_apellido_paterno',
        name:'txtCrben_apellido_paterno',
        fieldLabel :'Primer apellido',
        anchor:'98%',
        allowBlank :false
    });
    /**
     * Ext.form.TextField APELLIDO PATERNO DE BENEFICIARIO
     */
    var txtCrben_apellido_materno = new Ext.form.TextField({
        id:'txtCrben_apellido_materno',
        name:'txtCrben_apellido_materno',
        fieldLabel :'Segundo apellido',
        anchor:'98%'
    });

    /**
     * Ext.form.TextField NUMERO DE IDENTIFICACION DE BENEFICIARIO
     */
    var txtCrben_num_doc_identific = new Ext.form.TextField({
        id:'txtCrben_num_doc_identific',
        name:'txtCrben_num_doc_identific',
        fieldLabel :'Identificaci\u00f3n',
        anchor:'98%',
        allowBlank :false,
        maxLength: 20,
        listeners:{
            change:function(obj,newValue,oldValue){
                if(cbxCrdid_codigo.getValue() == SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF33')).get('CGCNF_VALOR_CADENA')){
                    var tmp = validarCedula(newValue);
                    if (tmp== true)
                        consultarDatosPersona(newValue);
                    else
                        Ext.MessageBox.alert(tituloCgg_res_beneficiario, 'N\u00famero de identificaci\u00f3n no valido');
                }else{
                    consultarDatosPersona(newValue);
                }
            },
            specialkey: function(field, e){                
                if (e.getKey() == e.ENTER) {
                    if(cbxCrdid_codigo.getValue() == SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF33')).get('CGCNF_VALOR_CADENA')){
                        var tmp = validarCedula(field.getValue());
                        if (tmp== true)
                            consultarDatosPersona(field.getValue());
                        else
                            Ext.MessageBox.alert(tituloCgg_res_beneficiario, 'El n\u00famero de identificaci\u00f3n no es valido, verifiquelo por favor.');
                    }else{
                        consultarDatosPersona(field.getValue());
                    }
                }
            }
        }
    });

    /**
 *Consulta si una persona esta previamente registrada.
 *@param inValue Numero de documento de la persona.
 */
    function consultarDatosPersona(inValue){
        var flagConsultarDatos = false;
        try{
            if (tmpRecordPersona != null){
                if(tmpRecordPersona[0].CRPER_NUM_DOC_IDENTIFIC != txtCrben_num_doc_identific.getValue())
                {
                    flagConsultarDatos = true;
                }
            }
            else{
                flagConsultarDatos = true;
            }
            if(flagConsultarDatos ){

                function CallBackCgg_res_persona(r){
                    tmpRecordPersona = Ext.util.JSON.decode(r);
                    if(tmpRecordPersona[0].CRPER_CODIGO != undefined){
                        cggcrperCodigo = tmpRecordPersona[0].CRPER_CODIGO;
                        txtCrben_nombres.setValue(tmpRecordPersona[0].CRPER_NOMBRES);
                        if(tmpRecordPersona[0].CRPER_APELLIDO_MATERNO)
                            txtCrben_apellido_materno.setValue(tmpRecordPersona[0].CRPER_APELLIDO_MATERNO);
                        txtCrben_apellido_paterno.setValue(tmpRecordPersona[0].CRPER_APELLIDO_PATERNO);
                        cbxCrecv_codigo.setValue(tmpRecordPersona[0].CRECV_CODIGO);
                        cbxCrben_genero.setValue(tmpRecordPersona[0].CRPER_GENERO);
                        dtCrper_fecha_nacimiento.setValue(tmpRecordPersona[0].CRPER_FECHA_NACIMIENTO?truncDate(tmpRecordPersona[0].CRPER_FECHA_NACIMIENTO):new Date());
                        cbxCpais_nombre_nacimiento.setValue(tmpRecordPersona[0].CGG_CPAIS_CODIGO);                        
                    
                    }else{                        
                        txtCrben_nombres.setValue('');                        
                        txtCrben_apellido_materno.setValue('');
                        txtCrben_apellido_paterno.setValue('');
                        dtCrper_fecha_nacimiento.setValue(new Date());                        
                    }
                }
                var param = new SOAPClientParameters();
                param.add('inCrper_num_doc_identific',inValue) ;
                param.add('format',TypeFormat.JSON);
                SOAPClient.invoke(URL_WS+"Cgg_res_persona",'selectNumDoc',param, true, CallBackCgg_res_persona);
            }
        }catch(inErr){
        //winFrmCgg_res_persona_juridica.getEl().unmask();
        }
    }
    /**
     *Ext.form.ComboBox GENERO DEL BENEFICIARIO
     */
    var cbxCrben_genero = new Ext.form.ComboBox({
        id:'cbxCrben_genero',
        fieldLabel:'Genero',
        store:dsGeneroPersona,
        editable:false,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un genero',
        selectOnFocus:true,
        anchor:'98%',
        value:0
    });

    /**
     * Ext.data.Store Seleccion de registros de la tabla Cgg_res_estado_civil
     */
    var gsCgg_res_estado_civil = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_estado_civil",
            method:"selectAll",
            pagin:false
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            },[
            {
                name:'CRECV_CODIGO'
            },

            {
                name:'CRECV_DESCRPCION'
            }
            ]),
        baseParams:{
            format:TypeFormat.JSON
        },
        listeners:{
            load:function(inThis,inRecords,inObject){
                if(inRecordCgg_res_beneficiario.get('CRECV_CODIGO')!== null && inRecordCgg_res_beneficiario.get('CRECV_CODIGO').trim().length!==0 ){
                    cbxCrecv_codigo.setValue(inRecordCgg_res_beneficiario.get('CRECV_CODIGO'));
                }else{
                    if(new ManagerCookies().read('CRECV_CODIGO')!=null){
                        cbxCrecv_codigo.setValue(new ManagerCookies().read('CRECV_CODIGO'));
                    }
                }
            }
        }
    });
    gsCgg_res_estado_civil.load();
    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DEL ESTADO CIVIL
     */
    var cbxCrecv_codigo = new Ext.form.ComboBox({
        id:'cbxCrecv_codigo',
        name:'cbxCrecv_codigo',
        fieldLabel :'Estado civil',
        anchor:'98%',
        store: gsCgg_res_estado_civil,
        displayField:'CRECV_DESCRPCION',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un estado civil',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CRECV_DESCRPCION}. {CRECV_DESCRPCION}" class="x-combo-list-item">{CRECV_DESCRPCION}</div></tpl>',
        valueField:'CRECV_CODIGO',
        listeners:{
            change:function(inThis,inNewValue,inOldValue){
                new ManagerCookies().erase('CRECV_CODIGO');
                new ManagerCookies().create('CRECV_CODIGO',inNewValue, 168);
            }
        }
    });

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_documento_identificacio por un campo especifico.
     */
    var gsCgg_res_documento_identificacio = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_documento_identificacio",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({
            },[
            {
                name:'CRDID_CODIGO'
            },

            {
                name:'CRDID_DESCRIPCION'
            }
            ]),
        baseParams:{
            format:"JSON"
        },
        listeners:{
            load:function(inThis,inRecords,inObject){
                if(inRecordCgg_res_beneficiario.get('CRDID_CODIGO')!== null && inRecordCgg_res_beneficiario.get('CRDID_CODIGO').trim().length!==0 ){
                    cbxCrdid_codigo.setValue(inRecordCgg_res_beneficiario.get('CRDID_CODIGO'));
                    txtCrben_num_doc_identific.focus();
                }else{
                    if(new ManagerCookies().read('CRDID_CODIGO')!=null){
                        cbxCrdid_codigo.setValue(new ManagerCookies().read('CRDID_CODIGO'));
                        txtCrben_num_doc_identific.focus();
                    }
                }
            }
        }
    });
    gsCgg_res_documento_identificacio.load();

    var cbxCrdid_codigo = new Ext.form.ComboBox({
        id:'cbxCrdid_codigo',
        name:'cbxCrdid_codigo',
        fieldLabel :'Documento',
        anchor:'98%',
        store: gsCgg_res_documento_identificacio,
        displayField:'CRDID_DESCRIPCION',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un tipo documento identidad',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CRDID_DESCRIPCION}" class="x-combo-list-item">{CRDID_DESCRIPCION}</div></tpl>',
        valueField:'CRDID_CODIGO',
        allowBlank:false,
        listeners:{
            change:function(inThis,inNewValue,inOldValue){
                new ManagerCookies().erase('CRDID_CODIGO');
                new ManagerCookies().create('CRDID_CODIGO',inNewValue, 168);
            }
        }
    });
    gsCgg_res_documento_identificacio.load();

    /**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO DE PAIS DE NACIMIENTO
     */
    var cbxCpais_nombre_nacimiento = new Ext.form.ComboBox({
        id:'cbxCpais_nombre_nacimiento',
        name:'cbxCpais_nombre_nacimiento',
        fieldLabel :'Pais',
        anchor:'98%',
        store: SCGG_PAIS,
        displayField:'CPAIS_NOMBRE',
        typeAhead: true,
        mode: 'local',
        forceSelection:true,
        triggerAction:'all',
        emptyText:'Seleccione un pais',
        selectOnFocus:true,
        tpl: '<tpl for="."><div ext:qtip="{CPAIS_NOMBRE}. {CPAIS_NOMBRE}" class="x-combo-list-item">{CPAIS_NOMBRE}</div></tpl>',
        valueField:'CPAIS_CODIGO'
    });
    /**
     * Ext.form.DateField FECHA DE NACIMIENTO
     */
    var dtCrper_fecha_nacimiento = new Ext.form.DateField({
        id:'dtCrper_fecha_nacimiento',
        name:'dtCrper_fecha_nacimiento',
        fieldLabel :'Fecha nacimiento',
        format :'d/m/Y',
        anchor:'98%',
        value:new Date(),
        maxValue:new Date(),
        allowBlank:false
    });

    function setBeneficiario(){
        inRecordCgg_res_beneficiario.set('CRPER_CODIGO',txtCrben_codigo.getValue());
        inRecordCgg_res_beneficiario.set('CRPER_NOMBRES',ucFirst(txtCrben_nombres.getValue()));
        inRecordCgg_res_beneficiario.set('CRPER_APELLIDO_PATERNO',txtCrben_apellido_paterno.getValue());
        inRecordCgg_res_beneficiario.set('CRPER_APELLIDO_MATERNO',txtCrben_apellido_materno.getValue());
        inRecordCgg_res_beneficiario.set('CRPER_NUM_DOC_IDENTIFIC',txtCrben_num_doc_identific.getValue());
        inRecordCgg_res_beneficiario.set('CRPER_GENERO',cbxCrben_genero.getValue());
        inRecordCgg_res_beneficiario.set('CRDID_CODIGO',cbxCrdid_codigo.getValue());
        inRecordCgg_res_beneficiario.set('CRECV_CODIGO',cbxCrecv_codigo.getValue());
        inRecordCgg_res_beneficiario.set('CRPER_FECHA_NACIMIENTO',dtCrper_fecha_nacimiento.getValue().format('d/m/Y'));
        inRecordCgg_res_beneficiario.set('CRPER_REQUISITOS_JSON',grdCgg_res_solicitud_requisito.getStore().getJsonData());
        inRecordCgg_res_beneficiario.set('CPAIS_CODIGO',cbxCpais_nombre_nacimiento.getRawValue());
    }
    /**
     * Boton que permite cerrar la ventana winFrmCgg_res_beneficiario_transeunte.
     */
    var btnCerrarCgg_res_beneficiario = new Ext.Button({
        id:'btnCerrarCgg_res_beneficiario',
        text:'Cerrar',
        iconCls:'iconCerrar',
        tooltip:'Cerrar formulario',
        listeners:{
            click:function(){
                winFrmCgg_res_beneficiario_transeunte.close();
            }
        }
    });

    var txtCRRQT_OBSERVACIONEditor= new Ext.form.TextField({
        id:'txtCRRQT_OBSERVACIONEditor',
        emptyText:'Establezca una observaci\u00F3n, por favor.'
    });

    var cbcCRSRQ_REQUERIDO =  new Ext.grid.CheckColumn({            
        dataIndex:'CRSRQ_REQUERIDO',
        header:'Requerido',
        width:90
    });

    var cbcCRRQT_CUMPLE =  new Ext.grid.CheckColumn({
        dataIndex:'CRRQT_CUMPLE',
        header:'Cumple',
        width:90
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
            width:120,
            sortable:true,
            editable:false,
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
            width:170,
            sortable:true
        },{
            dataIndex:'CRSRQ_PARTICIPANTE',
            header:'Participante',
            width:80,
            sortable:true,
            hidden:true,
            renderer:function(inCRSRQ_PARTICIPANTE){
                var result = 'no datos';
                for(var i=0;i<dsTipoParticipante.length;i++){
                    if(dsTipoParticipante[i][0]==inCRSRQ_PARTICIPANTE){
                        result = dsTipoParticipante[i][1];
                        break;
                    }
                }
                return result;
            }
        },
        {
            dataIndex:'CRRQT_CODIGO',
            header:'Codigo',
            width:100,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRTRA_CODIGO',
            header:'Tramite',
            hidden:true,
            hideable:false
        },
        cbcCRSRQ_REQUERIDO,
        cbcCRRQT_CUMPLE
        ,{
            dataIndex:'CRRQT_OBSERVACION',
            header:'Observaci\u00F3n',
            width:200,
            sortable:true,
            editor:txtCRRQT_OBSERVACIONEditor
        },{
            xtype: 'actioncolumn',
            width: 80,
            header:'Adjunto',
            items: [
            {
                iconCls: 'iconAdjunto',                // Use a URL in the icon config
                tooltip: 'Subir adjunto',
                handler: function(grid, rowIndex, colIndex) {
                    grdCgg_res_solicitud_requisito.getSelectionModel().selectRow(rowIndex);
                    var rAdjuntoTemporal = grdCgg_res_solicitud_requisito.getSelectionModel().getSelected();
                    if(rAdjuntoTemporal!== null){
                        var objSubirAdjunto = new FrmCgg_res_adjunto_temporal();
                        objSubirAdjunto.closeHandler(function(){
                            var dialogResult = objSubirAdjunto.dialogResult();
                            if(dialogResult  !== null){
                                rAdjuntoTemporal.set('CRATE_DATA',objSubirAdjunto.dialogResult());
                            }
                        });
                        objSubirAdjunto.show();
                    }
                }
            },{
                iconCls: 'iconEliminar',                // Use a URL in the icon config
                tooltip: 'Eliminar adjunto',
                handler: function(grid, rowIndex, colIndex) {
                    grdCgg_res_solicitud_requisito.getSelectionModel().selectRow(rowIndex);
                    var rAdjuntoRequisito = grdCgg_res_solicitud_requisito.getSelectionModel().getSelected();
                    if(rAdjuntoRequisito!== null){
                        rAdjuntoRequisito.set('CRATE_DATA',null);
                    }
                }
            },{
                iconCls: 'iconBuscar',                // Use a URL in the icon config
                tooltip: 'Ver adjunto',
                handler: function(grid, rowIndex, colIndex) {
                    grdCgg_res_solicitud_requisito.getSelectionModel().selectRow(rowIndex);
                    var rAdjuntoRequisito = grdCgg_res_solicitud_requisito.getSelectionModel().getSelected();
                    if(rAdjuntoRequisito!== null){
                        var objCrate_data = rAdjuntoRequisito.get('CRATE_DATA');
                        if(objCrate_data!==undefined && objCrate_data!==null && objCrate_data!==''){
                            var url1 = URL_DOC_VIEWER+'?table=cgg_res_adjunto_temporal&keyc=crate_codigo&keyv='+objCrate_data.CRATE_CODIGO +'&column=crate_archivo&fn='+objCrate_data.CRATE_NOMBRE+'&request=view';
                            window.open(url1);
                        }

                    }
                }
            },{
                iconCls: 'iconGuardar',
                tooltip: 'Guardar adjunto',
                handler: function(grid, rowIndex, colIndex) {
                    grdCgg_res_solicitud_requisito.getSelectionModel().selectRow(rowIndex);
                    var rAdjuntoRequisito = grdCgg_res_solicitud_requisito.getSelectionModel().getSelected();
                    if(rAdjuntoRequisito!== null){
                        var objCrate_data = rAdjuntoRequisito.get('CRATE_DATA');
                        if(objCrate_data!==undefined && objCrate_data!==null && objCrate_data!==''){
                            var url2 = URL_DOC_VIEWER+'?table=cgg_res_adjunto_temporal&keyc=crate_codigo&keyv='+objCrate_data.CRATE_CODIGO +'&column=crate_archivo&fn='+objCrate_data.CRATE_NOMBRE+'&request=download';
                            window.open(url2);
                        }
                    }
                }
            }
            ]
        },{
            dataIndex: 'CRATE_DATA',
            header: 'Datos adjunto',
            hidden:true,
            hideable:false
        }
        ]);

    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_solicitud_requisito por un campo especifico.
     */
    var gsCgg_res_solicitud_requisito = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_requisito_tramite",
            method:"selectTramiteTipoSolcitudRequisito"
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
        },{
            name:'CRRQT_CODIGO'
        },{
            name:'CRTRA_CODIGO'
        },{
            name:'CRRQT_CUMPLE'
        },{
            name:'CRRQT_OBSERVACION'
        },{
            name:'CRATE_DATA'
        }
        ]),
        groupField:'CRSRQ_PARTICIPANTE',
        baseParams:{
            inCrtra_codigo:null,
            inCrtst_codigo:null,
            format:TypeFormat.JSON
        }
    });
    /**
     * Boton que permite almacenar la informacion de la ventana winFrmCgg_res_tramite
     */
    var btnAceptarCgg_res_beneficiario = new Ext.Button({
        id: 'btnAceptarCgg_res_beneficiario',
        text: 'Aceptar',
        iconCls: 'iconAceptar',        
        handler: function(){
            if (validarFormulario() == false) {
                return;
            }
            if (validarReglas() == 'false') {
                return;
            }
            if(grdCgg_res_adjuntos.getStore().getCount() < 1 ){
                setBeneficiario();
                winFrmCgg_res_beneficiario_transeunte.close();
                return;
            }
            try {
                pnlCgg_res_beneficiario.getEl().mask('Espere un momento por favor.<br>El tiempo de respuesta depender\u00E1 del tama\u00F1o de sus archivos adjuntos.', 'x-mask-loading');
                pnlFrmCgg_res_beneficiario_adjuntos.getForm().submit({
                    url: URL_WS + "TranseunteSRV",
                    success: function(form, action){
                        try{
                            pnlCgg_res_beneficiario.getEl().unmask();
                            var resultadoTramite = action.result.msg;
                            
                            if(resultadoTramite.trim() == 'true'){
                                setBeneficiario();
                                winFrmCgg_res_beneficiario_transeunte.close();
                            }
                            else {
                                Ext.Msg.show({
                                    title: tituloCgg_res_beneficiario,
                                    msg: 'Se present\u00F3 un problema al procesar la informaci\u00f3n.<br>Error:' + resultadoTramite + '<br>' + ERR_MESSAGE,
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                       
                        }catch (inErr) {
                            pnlCgg_res_beneficiario.getEl().unmask();
                            Ext.Msg.show({
                                title: tituloCgg_res_beneficiario,
                                msg: 'Se present\u00F3 un problema al procesar la informaci\u00f3n.<br>Error:' + inErr + '<br>' + ERR_MESSAGE,
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }

                    },
                    failure: function(form, action){
                        
                        pnlCgg_res_beneficiario.getEl().unmask();
                        Ext.Msg.show({
                            title: tituloCgg_res_beneficiario,
                            msg: 'Se present\u00F3 un problema al momento de guardar su tr\u00E1mite.<br>Error:' + action.result.msg + '.<br>' + ERR_MESSAGE,
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });

                    },
                    params: {
                        inTranseunteIdentificacion: txtCrben_num_doc_identific.getValue()
                    }
                });

            }catch (inErr) {
                pnlCgg_res_beneficiario.getEl().unmask();
                Ext.Msg.show({
                    title: tituloCgg_res_beneficiario,
                    msg: 'Se present\u00F3 un problema al procesar la informaci\u00f3n.<br>Error:' + inErr + '<br>' + ERR_MESSAGE,
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
            }
        }
    });
    var cmAdjunto = new Ext.grid.ColumnModel([new Ext.grid.RowNumberer(), {
        header: "Archivos",
        dataIndex: "ARCHIVOS",
        width: 300,
        sortable: true
    }]);
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_adjunto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_adjuntos = new Ext.grid.GridPanel({
        id: 'grdCgg_res_adjuntos',
        cm: cmAdjunto,
        store: new Ext.data.JsonStore({}),
        region: 'center',
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true,
            moveEditorOnEnter: false
        }),        
        loadMask: {
            msg: "Cargando..."
        },
        trackMouseOver: true,
        tbar: ['Adjuntos', {
            id: 'btnAgregarAdjuntoTranseunte',
            iconCls: 'iconNuevo',
            handler: function(){
                var coleccion = {};

                var datos = "<div width='100%'><INPUT TYPE='file' id='ful" + grdCgg_res_adjuntos.getStore().getCount() + "' size='25' name='inBeneficiarioAdjuntos'/></div> ";
                coleccion['ARCHIVOS'] = datos;
                var recordAdjunto = new Ext.data.Record(coleccion, grdCgg_res_adjuntos.getStore().getCount());
                grdCgg_res_adjuntos.getStore().add(recordAdjunto);
            }
        }, {
            id: 'btnEliminarAdjuntoTranseunte',
            iconCls: 'iconEliminar',
            handler: function(){
                var seleccionado = grdCgg_res_adjuntos.getSelectionModel().getSelected();
                if (seleccionado != null) {
                    grdCgg_res_adjuntos.getStore().remove(seleccionado);
                    grdCgg_res_adjuntos.getSelectionModel().selectFirstRow();
                }
                else
                if (grdCgg_res_adjuntos.getStore().getCount() >= 1) {
                    grdCgg_res_adjuntos.getSelectionModel().selectLastRow();
                    grdCgg_res_adjuntos.getStore().remove(grdCgg_res_adjuntos.getSelectionModel().getSelected());
                }
            }
        }]

    });

    var pnlFrmCgg_res_beneficiario_adjuntos = new Ext.FormPanel({
        id: 'pnlFrmCgg_res_beneficiario_adjuntos',        
        layout: 'border',
        anchor:'100% 100%',
        title:'Adjuntos',
        fileUpload: true,        
        items: [grdCgg_res_adjuntos]
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_solicitud_requisito en un formato tabular de filas y columnas.
     */
    var grdCgg_res_solicitud_requisito = new Ext.grid.EditorGridPanel({
        cm:cmCgg_res_solicitud_requisito,
        store:gsCgg_res_solicitud_requisito,
        region:'center',
        anchor:'100% 100%',
        height:'250',
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Requisitos" : "Requisito"]})'
        }),
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        plugins:[cbcCRRQT_CUMPLE],
        loadMask:{
            msg:"Cargando..."
        },
        clicksToEdit:1
    });

    var tpOpcionesBeneficiario = new Ext.TabPanel({
        //layout:'border',
        id:'tpOpcionesBeneficiario',
        // title:'Requisitos',
        region:'center',
        height:'100%',
        //width:'60%',
        activeTab:0,
        items:[
        {
            layout:'border',
            id:'pnlRequisitosBeneficiario',
            title:'Requisitos',
            //tbar:[btnAgregarPersonaGrupo],
            items:[grdCgg_res_solicitud_requisito]
        },
        pnlFrmCgg_res_beneficiario_adjuntos

        ]
    });

    var pnlOpciones= new Ext.Panel({
        id:'pnlOpciones',
        region:'center',
        layout:'border',
        anchor:'100% 100%',
        items:[tpOpcionesBeneficiario]
    });
    /**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_beneficiario_transeunte.
     */
    var pnlCgg_res_beneficiario = new Ext.form.FormPanel({
        frame:true,
        region:'north',
        // anchor:'40%',
        height:145,
        labelWidth:100,
        //layout:'form',
        items:[
        {
            xtype:'panel',
            layout:'column',
            items:[{
                columnWidth:.5,
                layout:'form',
                items:[cbxCrdid_codigo]
            },{
                columnWidth:.5,
                layout:'form',
                items:[txtCrben_num_doc_identific]
            }]
        },
        txtCrben_nombres,
        {
            xtype:'panel',
            layout:'column',
            items:[{
                columnWidth:.5,
                layout:'form',
                items:[txtCrben_apellido_paterno]
            },{
                columnWidth:.5,
                layout:'form',
                items:[txtCrben_apellido_materno]
            }]
        },
        {
            xtype:'panel',
            layout:'column',
            items:[{
                columnWidth:.5,
                layout:'form',
                items:[cbxCrben_genero]
            },{
                columnWidth:.5,
                layout:'form',
                items:[cbxCrecv_codigo]
            }]
        },
        {
            xtype:'panel',
            layout:'column',
            items:[{
                columnWidth:.5,
                layout:'form',
                items:[cbxCpais_nombre_nacimiento ]
            },{
                columnWidth:.5,
                layout:'form',
                items:[dtCrper_fecha_nacimiento]
            }]
        }
        ]
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para administrar la informacion de los registros de la tabla Cgg_res_beneficiario.
     */
    var winFrmCgg_res_beneficiario_transeunte = new Ext.Window({
        title:tituloCgg_res_beneficiario,
        tbar:getPanelTitulo(tituloCgg_res_beneficiario,descCgg_res_beneficiario),
        items:[pnlCgg_res_beneficiario,pnlOpciones],
        width:600,
        height:500,
        layout:'border',        
        constrain:true,
        maximizable:true,
        modal:true,
        bbar:[btnAceptarCgg_res_beneficiario,'->',btnCerrarCgg_res_beneficiario],
        listener:{
            show:function(inThis){
                txtCrben_num_doc_identific.focus(400);
            }
        }
    });

    /**
     * Funcion que permite cargar la informacion de los controles de la ventana winFrmCgg_res_beneficiario_transeunte.
     */
    function cargarCgg_res_beneficiarioCtrls(){
        if(inRecordCgg_res_beneficiario!== null){
            if(inRecordCgg_res_beneficiario.get('CRPER_CODIGO'))
            {
                txtCrben_codigo.setValue(inRecordCgg_res_beneficiario.get('CRPER_CODIGO'));
                txtCrben_nombres.setValue(inRecordCgg_res_beneficiario.get('CRPER_NOMBRES'));
                txtCrben_apellido_paterno.setValue(inRecordCgg_res_beneficiario.get('CRPER_APELLIDO_PATERNO'));
                txtCrben_apellido_materno.setValue(inRecordCgg_res_beneficiario.get('CRPER_APELLIDO_MATERNO'))
                txtCrben_num_doc_identific.setValue(inRecordCgg_res_beneficiario.get('CRPER_NUM_DOC_IDENTIFIC'));
                cbxCrben_genero.setValue(inRecordCgg_res_beneficiario.get('CRPER_GENERO'));
                cbxCrdid_codigo.setValue(inRecordCgg_res_beneficiario.get('CRDID_CODIGO'));
                cbxCrecv_codigo.setValue(inRecordCgg_res_beneficiario.get('CRECV_CODIGO'));
                cbxCpais_nombre_nacimiento.setValue(inRecordCgg_res_beneficiario.get('CPAIS_CODIGO'));
                var tmpFecha = null;
                if(inRecordCgg_res_beneficiario.get('CRPER_FECHA_NACIMIENTO')== null || inRecordCgg_res_beneficiario.get('CRPER_FECHA_NACIMIENTO').trim().length ==0){
                    tmpFecha = new Date();
                }else{
                    tmpFecha = Date.parse(inRecordCgg_res_beneficiario.get('CRPER_FECHA_NACIMIENTO'));
                }
                dtCrper_fecha_nacimiento.setValue(tmpFecha);
            }
            if(inRecordCgg_res_beneficiario.get('CRPER_REQUISITOS_JSON')){
                gsCgg_res_solicitud_requisito.loadData(Ext.util.JSON.decode(inRecordCgg_res_beneficiario.get('CRPER_REQUISITOS_JSON')),true);
            }else{
                gsCgg_res_solicitud_requisito.reload({
                    params:{
                        inCrtra_codigo:null,                        
                        inCrtst_codigo:INRECORD_TIPO_SOLICITUD.get('CRTST_CODIGO'),
                        format:TypeFormat.JSON
                    }
                });
            }
        }
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_beneficiario_transeunte.
     * @returns ventana winFrmCgg_res_beneficiario_transeunte.
     * @base FrmCgg_res_beneficiario_transeunte.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_beneficiario_transeunte;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_beneficiario_transeunte.
     * @base FrmCgg_res_beneficiario_transeunte.prototype.loadData
     */
    this.loadData = function(){
        cargarCgg_res_beneficiarioCtrls();
    }

    this.data = function(){
        return inRecordCgg_res_beneficiario;
    }
    /**
     *Valida las reglas basicas de control sobre el formulario.
     *@return Verdadero/falso a la validacion de los controles del formulario.
     */
    function validarFormulario(){
        var flagValidar = true;
        var flagValidarRequisito = true;

        if(txtCrben_num_doc_identific.getValue() == null || txtCrben_num_doc_identific.getValue().trim().length ==0){
            txtCrben_num_doc_identific.markInvalid('Establezca el numero de documento, por favor.');
            flagValidar = false;
            return flagValidar;
        }

        if(txtCrben_nombres.getValue() == null ||  txtCrben_nombres.getValue().trim().length ==0){
            txtCrben_nombres.markInvalid('Establezca el nombre, por favor.');
            flagValidar = false;
            return flagValidar;
        }

        if(cbxCrecv_codigo.getValue() == null || cbxCrecv_codigo.getValue().trim().length ==0){
            cbxCrecv_codigo.markInvalid('Establezca el estado civil, por favor.');
            flagValidar = false;
            return flagValidar;
        }

        if(txtCrben_apellido_paterno.getValue() == null || txtCrben_apellido_paterno.getValue().trim().length ==0){
            txtCrben_apellido_paterno.markInvalid('Establezca el apellido, por favor.');
            flagValidar = false;
            return flagValidar;
        }

        if(cbxCpais_nombre_nacimiento.getValue() == null || cbxCpais_nombre_nacimiento.getValue().trim().length ==0){
            cbxCpais_nombre_nacimiento.markInvalid('Establezca el pais de nacimiento, por favor.');
            flagValidar = false;
            return flagValidar;
        }

        if(dtCrper_fecha_nacimiento.isValid()==false){
            dtCrper_fecha_nacimiento.markInvalid('Establezca la fecha de nacimiento, por favor.');
            flagValidar = false;
            return flagValidar;
        }

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
                title: tituloCgg_res_beneficiario,
                msg: 'Uno de los requisitos necesita cumplirse, por favor verifiquelos.',
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.WARNING
            });            
            grdCgg_res_solicitud_requisito.focus();
            flagValidar = false;
        }
        return flagValidar;
    }   

    /**
     *Evalua las reglas de validacion con los parametros del formulario.
     */
    function evaluarReglasValidacion(){
        objReglasValidacion = eval(reglasValidacion);
        for(var i=0;i<objReglasValidacion.length;i++){
            var objTmp = Ext.decode(objReglasValidacion[i].CRTSE_CAMPO_EVALUACION)[0]; //[0].INPARAMETRO1);
            for (var key in objTmp) {
                objTmp[key] = eval(objTmp[key]);
            }
            objReglasValidacion[i].CRTSE_CAMPO_EVALUACION ='['+Ext.encode(objTmp)+']';
        }
        return(Ext.encode(objReglasValidacion));
    }

    /**
     *Valida las reglas aplicadas a este tipo de tramite por cada uno de los beneficiarios.
     */
    function validarReglas(){
        try{
            pnlCgg_res_beneficiario.getEl().mask('Validando...', 'x-mask-loading');
            var flagResultado = 'true';            

            //El auspiciante ya esta establecido en la apertura del formulario.            
            crperNumDocIdentific = txtCrben_num_doc_identific.getValue();            
            cggCrperFechaNacimiento = dtCrper_fecha_nacimiento.getValue().format('d/m/Y');
            //cggcrperCodigo = txtCrben_codigo.getValue();
            var jsonData = {
                'CRPER_CODIGO':crperCodigo,
                'CGGCRPER_CODIGO':cggcrperCodigo,
                'CRPER_NUM_DOC_IDENTIFIC':crperNumDocIdentific,
                'CRPER_FECHA_NACIMIENTO':cggCrperFechaNacimiento
            };
            var param = new SOAPClientParameters();
            var tmpEvaluacion = evaluarReglasValidacion();
            param.add('inJSON_reglas_validacion',tmpEvaluacion);
            param.add('jsonData',jsonData);
            var r = SOAPClient.invoke(URL_WS+'Cgg_regla_validacion' ,'ejecutarReglaTipoSolicitud',param, false, null);

            var validacion = Ext.util.JSON.decode(r);

            if(validacion.resultadoValidacion != undefined){
                if(validacion.resultadoValidacion == 'false'){
                    var objCgg_regla_validacion = new FrmListadoCgg_regla_validacion_resultado(validacion);
                    objCgg_regla_validacion.loadData();
                    objCgg_regla_validacion.show();
                }
                flagResultado = validacion.resultadoValidacion;
            }
            pnlCgg_res_beneficiario.getEl().unmask();
            return flagResultado;
        }catch(inErr){
            Ext.MsgPopup.msg(tituloCgg_res_beneficiario, "No se ha podido validar la informaci\u00f3n a almacenar.<br>Error:"+inErr);
            pnlCgg_res_beneficiario.getEl().unmask();
            return 'false';
        }
    }

    /**
    *Establece las reglas de validacion para una persona.
    * @param inReglas Reglas de validacion en formato JSON.
    */
    this.establecerReglas=function(inReglas){
        reglasValidacion = inReglas;
    }

    this.setAuspiciante = function(inAuspiciante){
        crperCodigo = inAuspiciante;
    }
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_beneficiario_transeunte desde una instancia.
 */
FrmCgg_res_beneficiario_transeunte.prototype.show = function(){
    this.getWindow().show();
}
/**
 *Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_beneficiario_transeunte desde una instancia.
 */
FrmCgg_res_beneficiario_transeunte.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_beneficiario_transeunte,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_beneficiario_transeunte.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_beneficiario_transeunte desde una instancia.
 */
FrmCgg_res_beneficiario_transeunte.prototype.loadData = function(){
    this.loadData();
}

FrmCgg_res_beneficiario_transeunte.prototype.getData = function(){
    return this.data();
}

/**
 * Establce la reglas de validacion del formulario.
 * @param inReglas Reglas de validacion en formato JSON.
 */
FrmCgg_res_beneficiario_transeunte.prototype.setRegla = function(inReglas){
    this.establecerReglas(inReglas);
}

FrmCgg_res_beneficiario_transeunte.prototype.setAuspiciante = function(inAuspiciante){
    this.setAuspiciante(inAuspiciante);
}
