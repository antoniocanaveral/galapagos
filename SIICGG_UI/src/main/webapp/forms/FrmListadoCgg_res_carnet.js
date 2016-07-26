/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_carnet.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */

function FrmListadoCgg_res_carnet(inDesktop) {
    var optMenu = 'Control de Residencia/Carnetizaci\u00f3n';
    var urlListadoCgg_res_carnet = URL_WS + "Cgg_res_carnet";
    var tituloListadoCgg_res_carnet = 'Carnets';
    var descListadoCgg_res_carnet = 'El formulario permite administrar informaci\u00f3n de los carnets emitidos en favor de una Persona.';
    var tmpPersona;
    var tmpResidencia;
    var tmpCarnet;
    var tmpLocal = false;
    var tmpAdjuntosPersonal;
    var myJasperServer = new JasperServer();
    var tmpFlag = false;
    var tmpPersonaUpdateAus ={
        CRTRA_CODIGO:'',
        CRPER_NOMBRES:'',
        CRPER_APELLIDO_PATERNO:'',
        CRPER_NUMERO_RESIDENCIA:'',
        CRPER_TIPO_RESIDENCIA:'',
        CRPER_NOMBRE_AUSPICIANTE:'',
        CRPER_CODIGO_AUSPICIANTE:'',
        CRPJR_RAZON_SOCIAL:'',
        CRPJR_CODIGO:''
    };

    var tmpInfoPersona = new Ext.XTemplate(
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
                    '<tr rowspan="0">'+
                    '<td><div class="tituloTemplate">Motivo:</div></td>'+
                    '<td colspan="3"><div class="itemTemplate"><div id="divMotivoResidencia"></div></div></td></tr>'+
                    '<tr id="trInfoTempAuspiciante" rowspan="0">'+
                    '<td><div class="tituloTemplate">Auspiciante:</div></td>'+
                    '<td colspan="3"><div class="itemTemplate"><div id="divAuspiciante"></div></div></td></tr>'+
                    '<tr id="trInfoTempOcupacion" rowspan="0">'+
                    '<td><div class="tituloTemplate">Ocupaci\u00f3n:</div></td>'+
                    '<td colspan="3"><div class="itemTemplate"><div id="divOcupacion"></div></div></td></tr>'+
                    '</table>',
    {myTipoDoc:function(inTipoDoc){
        for(i = 0; i < tmpStoreTipoDocumento.getTotalCount(); i++){
            tmpRecord = tmpStoreTipoDocumento.getAt(i);
            if(tmpRecord.data.CRDID_CODIGO = inTipoDoc)
                return tmpRecord.data.CRDID_DESCRIPCION
        }
    }
    }
            );

    var strPersona = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_persona",
            method:"selectPageLite",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPER_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRPER_CODIGO'},
            {name:'CRDID_CODIGO'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_APELLIDO_MATERNO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_FECHA_NACIMIENTO'},
            {name:'CRPER_LUGAR_NACIMIENTO'},
            {name:'CRPER_GENERO'},
            {name:'CRPER_OBSERVACIONES'},
            {name:'CRPER_NUMERO_RESIDENCIA'},
            {name:'CRPER_AUTORIZADO'},
            {name:'CRPER_NUMERO_EXPEDIENTE'}
        ]),
        sortInfo:{
            field: 'CRPER_APELLIDO_PATERNO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON",
            inCrtst_codigo:TypeResidencia.NINGUNA,
            inCarnet:false,
            inIdentificacion:''
        },
        listeners:{
            load:function(inSource, inRecords, inOptions){
                if(inRecords.length > 0 && tmpLocal){
                    tmpPersona = inRecords[0];
                    loadPersona(tmpPersona);
                    tmpLocal = false;

                }
                else
                {
                    if(tmpFlag)
                    {
                        Ext.Msg.show({
                            title: 'Aviso',
                            msg: 'La persona solicitada no posee informaci\u00f3n asociada.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO

                        });
                        tmpFlag =  false;
                    }
                }
                winFrmListadoCgg_res_carnet.getEl().unmask();
            }
        }
    });

    var txtCrnCrper_codigo = new Ext.form.TextField({
        id:'txtCrnCrper_codigo',
        anchor:'100%',
        fieldLabel:'Numero de documento',
        listeners:{
            specialkey:function(inSource, inEvent){
                if(inEvent.getKey() == inEvent.ENTER){
                    strPersona.baseParams.start = 0;
                    strPersona.baseParams.limit = RECORD_PAGE;
                    strPersona.baseParams.inCarnet = true;
                    strPersona.baseParams.inIdentificacion = txtCrnCrper_codigo.getValue();
                    strPersona.reload();
                    tmpLocal = true;
                    tmpFlag = true;
                    winFrmListadoCgg_res_carnet.getEl().mask('Cargando datos...', 'x-mask-loading');
                }
            }
        }
    });

    var pnlPersona = new Ext.Panel({
        layout:'border',
        frame:true,
        region:'north',
        height:200,
        items:[
            {	xtype:'fieldset',
                title:'Datos personales',
                region:'center',
                layout:'border',
                items:[
                    {region:'center',layout:'form',items:[
                        {xtype:'panel',layout:'column',items:[
                            {layout:'form',labelWidth:140,columnWidth:0.92,items:[txtCrnCrper_codigo]},
                            {layout:'form',columnWidth:0.08,items:[{xtype:'button',iconCls:'iconBuscar',handler:function(){
                                var tmpTimeout = Ext.Ajax.timeout;
                                Ext.Ajax.timeout = 90000;
                                var tmpObjPersona = new Persona();
                                strPersona.baseParams.inCarnet = true;
                                strPersona.baseParams.inIdentificacion = '';
                                var objBusqueda = new DlgBusqueda(strPersona, tmpObjPersona.getColumnModel());
                                objBusqueda.closeHandler(function () {
                                    tmpCarnet = false;
                                    Ext.Ajax.timeout = tmpTimeout;
                                    tmpPersona = objBusqueda.getSelectedRow();
                                    if (tmpPersona) {
                                        loadPersona(tmpPersona);
                                    }
                                });
                                objBusqueda.show();
                            }}]}
                        ]},
                        {xtype:'panel', height:130,html:'<div id="divCrnPersona"></div>'}
                    ]},
                    {region:'east',width:138,layout:'form',items:[{xtype:'panel',html:'<img id="imgFotoPersonaCrn" height="128" width="128" src="resources/images/male_avatar.jpeg"/>'}]}
                ]}
        ]
    });

    function loadPersona(inPersona){
		tmpCarnet = undefined;
		tmpResidencia = undefined;
        function CallBackResidencia(inResponse){
            if(inResponse.length == 0){
                Ext.MessageBox.alert(tituloListadoCgg_res_carnet, 'La persona seleccionada no tiene una residencia vigente.');
                return;
            }
            btnNuevoCgg_res_carnet.setDisabled(false);
            btnActualizarPersonaCgg_res_carnet.setDisabled(false);
            btnActualizarAuspicianteCgg_res_carnet.setDisabled(false);
            tmpResidencia = Ext.util.JSON.decode(inResponse);
			
            gsCgg_res_carnet.baseParams.inCrrsd_codigo = tmpResidencia.CRRSD_CODIGO;
            gsCgg_res_carnet.reload();

            document.getElementById('divAuspiciante').innerHTML = tmpResidencia.AUSPICIANTE;

            if(tmpResidencia.CRRSD_MODALIDAD == 0){
                tmpPersonaUpdateAus.CRPER_TIPO_RESIDENCIA = 'Permanente';
                document.getElementById('divTipoResidencia').innerHTML = "Permanente";
                //document.getElementById('trInfoTempAuspiciante').style.display = 'none';
                document.getElementById('trInfoTempOcupacion').style.display = 'none';

            }else if(tmpResidencia.CRRSD_MODALIDAD == 1){
                tmpPersonaUpdateAus.CRPER_TIPO_RESIDENCIA = 'Temporal';
                document.getElementById('divTipoResidencia').innerHTML = "Temporal";

                document.getElementById('divOcupacion').innerHTML = tmpResidencia.OCUPACION;
            }
            document.getElementById('divMotivoResidencia').innerHTML = tmpResidencia.MOTIVO;
            tmpPersonaUpdateAus.CRTRA_CODIGO = tmpResidencia.CRTRA_CODIGO;
            tmpPersonaUpdateAus.CRPER_NOMBRE_AUSPICIANTE = tmpResidencia.REPRESENTANTE_LEGAL;
            tmpPersonaUpdateAus.CRPER_CODIGO_AUSPICIANTE = tmpResidencia.TRM_CRPER_CODIGO;
            tmpPersonaUpdateAus.CRPJR_RAZON_SOCIAL = tmpResidencia.CRPJR_RAZON_SOCIAL!=undefined?tmpResidencia.CRPJR_RAZON_SOCIAL:'';
            tmpPersonaUpdateAus.CRPJR_CODIGO = tmpResidencia.CRPJR_CODIGO!=undefined?tmpResidencia.CRPJR_CODIGO:'';

            function CallBackCarnet(inResponse){
                if(inResponse && inResponse.length > 2)
                    tmpCarnet = Ext.util.JSON.decode(inResponse);
            }

            var param = new SOAPClientParameters();
            param.add('inCrrsd_codigo', tmpResidencia.CRRSD_CODIGO);
            param.add('format', TypeFormat.JSON);
            SOAPClient.invoke(urlListadoCgg_res_carnet, "selectCarnet", param, true, CallBackCarnet);

        }

        function CallbackAdjuntoPersonal(inResponse){
            tmpAdjuntosPersonal = Ext.util.JSON.decode(inResponse);
            if(tmpAdjuntosPersonal[0].CRPER_FOTO){
                var tmpImgFoto = document.getElementById("imgFotoPersonaCrn");
                tmpImgFoto.src = 'data:image/jpg;base64,'+tmpAdjuntosPersonal[0].CRPER_FOTO;
            }

        }
        tmpPersonaUpdateAus.CRPER_NOMBRES = inPersona.get('CRPER_NOMBRES');
        tmpPersonaUpdateAus.CRPER_APELLIDO_PATERNO = inPersona.get('CRPER_APELLIDO_PATERNO') + ' '+ inPersona.get('CRPER_APELLIDO_MATERNO');
        tmpPersonaUpdateAus.CRPER_NUMERO_RESIDENCIA = inPersona.get('CRPER_NUMERO_RESIDENCIA');


        document.getElementById('divCrnPersona').innerHTML =tmpInfoPersona.apply(inPersona.json);

        Ext.getCmp('txtCrnCrper_codigo').setValue(inPersona.get('CRPER_NUM_DOC_IDENTIFIC'));

        var param = new SOAPClientParameters();
        param.add('inCrper_codigo', inPersona.get('CRPER_CODIGO'));
        param.add('format', TypeFormat.JSON);
        SOAPClient.invoke(urlListadoCgg_res_carnet, "selectResidencia", param, true, CallBackResidencia);

        var param = new SOAPClientParameters();
        param.add('inCrper_codigo', inPersona.get('CRPER_CODIGO'));
        param.add('format', TypeFormat.JSON);
        SOAPClient.invoke(URL_WS+'Cgg_res_persona', "selectAdjuntosIdentificacionById", param, true, CallbackAdjuntoPersonal);

    }
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_carnet.
     */
    var btnNuevoCgg_res_carnet = new Ext.Button({
        id: 'btnNuevoCgg_res_carnet',
        text: 'Nuevo',
        iconCls: 'iconNuevo',
        disabled:true,
        listeners: {
            click: function () {
                if(tmpPersona){
                    var objCgg_res_carnet = new FrmCgg_res_carnet("insert");
                    objCgg_res_carnet.setPersona(tmpPersona);
                    objCgg_res_carnet.setAdjuntos(tmpAdjuntosPersonal);
                    objCgg_res_carnet.setCarnet(tmpCarnet);
                    objCgg_res_carnet.setResidencia(tmpResidencia);
                    objCgg_res_carnet.closeHandler(function () {
                        gsCgg_res_carnet.reload();
                    });
                    objCgg_res_carnet.show();
                }
            }
        }
    });


    /**
     * Ext.Button Boton para registrar acciones adicionales
     */
    var btnActualizarPersonaCgg_res_carnet = new Ext.Button({
        id: 'btnActualizarPersonaCgg_res_carnet',
        name: 'btnActualizarPersonaCgg_res_carnet',
        text: 'Persona',
        tooltip:'Actualizar informaci\u00f3n de Persona',
        iconCls: 'iconEditar',
        disabled:true,
        listeners:{
                    click: function () {
                        abrirPersona(tmpPersona.get('CRPER_CODIGO'));
                    }
                }
    });

      /**
     * Ext.Button Boton para registrar acciones adicionales
     */
    var btnActualizarAuspicianteCgg_res_carnet = new Ext.Button({
        id: 'btnActualizarAuspicianteCgg_res_carnet',
        name: 'btnActualizarAuspicianteCgg_res_carnet',
        text: 'Auspiciante',
        iconCls: 'iconEditar',
         tooltip:'Actualizar informaci\u00f3n de auspiciante',
        disabled:true,
                       listeners:{
                    click: function () {

                        var objAuspicianteActualizar = new FrmCgg_res_carnet_tramite(tmpPersonaUpdateAus);
                        objAuspicianteActualizar.closeHandler(function () {
                            loadPersona(tmpPersona);
                        });
                        objAuspicianteActualizar.loadData();
                        objAuspicianteActualizar.show();
                    }
                }

    });


    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_carnet.
     */
    /* var btnActualizarPersonaCgg_res_carnet = new Ext.Button({
     id: 'btnActualizarPersonaCgg_res_carnet',
     text: 'Actualizar persona',
     iconCls: 'iconEditar',
     disabled:true,
     listeners: {
     click: function () {
     abrirPersona(tmpPersona.get('CRPER_CODIGO'));
     }
     }
     });*/

    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_carnet.
     */
    var btnEliminarCgg_res_carnet = new Ext.Button({
        id: 'btnEliminarCgg_res_carnet',
        text: 'Eliminar',
        iconCls: 'iconEliminar',
        listeners: {
            click: function () {
                Ext.Msg.show({
                    title: 'Aviso',
                    msg: 'Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_res_carnet,
                    icon: Ext.MessageBox.QUESTION
                });

                function SWRCgg_res_carnet(btn) {
                    if (btn == 'yes') {
                        try {
                            function CallBackCgg_res_carnet(r) {
                                winFrmListadoCgg_res_carnet.getEl().unmask();
                                if (r == 'true') {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_res_carnet,
                                        msg: 'La informaci\u00f3n del Carnet ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_res_carnet.reload();
                                } else {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_res_carnet,
                                        msg: 'La informaci\u00f3n de Carnet no ha podido ser eliminada. '+r,
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_res_carnet.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCrcnt_codigo', grdCgg_res_carnet.getSelectionModel().getSelected().get('CRCNT_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_res_carnet, "delete", param, true, CallBackCgg_res_carnet);
                        } catch (inErr) {
                            winFrmListadoCgg_res_carnet.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_carnet.
     */
    var btnSalirCgg_res_carnet = new Ext.Button({
        id: 'btnSalirCgg_res_carnet',
        text: 'Salir',
        iconCls: 'iconSalir',
        listeners: {
            click: function () {
                winFrmListadoCgg_res_carnet.close();
            }
        }
    });


    //AC==>
    var btnAdjuntos = new Ext.ux.form.AlfrescoFM({
        id:'compAdjunto',   //(opcional)
        name:'compAdjunto', //(opcional)
        text: 'Adjuntos',    //(opcional -> Texto del botón)
        tableName: 'Cgg_res_carnet',
        validateRecordID:true,
        recordID: null,
        filter: null
    });
    btnAdjuntos.addListener("updateData",function(t){
        t.recordID = null;
        var r = grdCgg_res_carnet.getSelectionModel().getSelected();
        if(r)
            t.recordID = r.data.CRCNT_CODIGO;
        t.filter = null;
        r=null;
    });
    //<== AC

    /**
     * Ext.Button Boton para obtener reportes, general o individual.
     */
    var btnReporteCgg_res_carnet = new Ext.Button({
        id: 'btnReporteCgg_res_carnet',
        name: 'btnReporteCgg_res_carnet',
        text: 'Imprimir',
        iconCls: 'iconImprimir',
        listeners:{
            click:function(){
                var r = grdCgg_res_carnet.getSelectionModel().getSelected();
                if (!r){
                    Ext.Msg.show({
                        title: tituloListadoCgg_res_carnet,
                        msg: 'Seleccione un registro antes de continuar.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    return;
                }
                function CallBackVentaEspecie(inResponse){
                    if(inResponse == 'true'){
                        printEspecie(r,0);
                    }else{
                        Ext.Msg.show({
                            title:tituloListadoCgg_res_carnet,
                            msg: 'No se ha podido imprimir el registro seleccionado. '+(inResponse.message?inResponse.message:inResponse),
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR
                        });
                    }
                }
                var param = new SOAPClientParameters();
                param.add('inCkesp_codigo',r.data.CKESP_CODIGO);
                param.add('inCtreg_codigo',r.data.CRCNT_CODIGO);
                param.add('inAmbito',TypeAmbitoEspecie.RESIDENCIA);
                SOAPClient.invoke(URL_WS+'Cgg_kdx_venta_detalle','ventaRegistro',param, true, CallBackVentaEspecie);
            }
        }
    });

    /**
     * Ext.Button Boton para obtener el listado de datos informativos de una persona
     */
    var btnDatosPersonaCgg_res_carnet = new Ext.Button({
        id: 'btnDatosPersonaCgg_res_carnet',
        name: 'btnDatosPersonaCgg_res_carnet',
        text: 'Datos Persona',
        iconCls: 'iconImprimir',
        listeners:{
            click:function(){
                var r = tmpPersona.data.CRPER_CODIGO;
                if (!r){
                    Ext.Msg.show({
                        title: 'Datos de Persona',
                        msg: 'Seleccione un registro antes de continuar.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    return;
                }
                var reporte = new Reporte("rptListadoCarnetizacion", '/Reports/sii/residencia', {
                    P_CRPER_CODIGO:r
                });
                reporte.show();
            }
        }
    });

//MO

    /**
     * Ext.Button Boton para obtener información relevante para el área financiera
     */
    var btnNotificacionFinanCgg_res_carnet = new Ext.Button({
        id: 'btnNotificacionFinanCgg_res_carnet',
        name: 'btnNotificacionFinanCgg_res_carnet',
        text: 'Generar Notificaci\u00f3n Finan.',
        //iconCls: 'iconImprimir',
        listeners:{
                click: function () {
                    abrirNotificacionFinan(tmpPersona.get('CRPER_CODIGO'),grdCgg_res_carnet.get('CRCNT_CODIGO'));
                }
            }
    });

//

    /**
     * Ext.Button Boton para obtener reportes, general o individual.
     */
    var btnPreviewCgg_res_carnet = new Ext.Button({
        id: 'btnPreviewCgg_res_carnet',
        name: 'btnPreviewCgg_res_carnet',
        text: 'Vista preliminar',
        iconCls: 'iconPreview',
        listeners:{
            click:function(){
                var r = grdCgg_res_carnet.getSelectionModel().getSelected();
                if (!r){
                    Ext.Msg.show({
                        title: tituloListadoCgg_res_carnet,
                        msg: 'Seleccione un registro antes de continuar.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    return;
                }
                printEspecie(r, 1);
            }
        }
    });
    function printEspecie(inRecord, inMode){
        myJasperServer.addParam('P_PREVIEW',inMode);
        myJasperServer.addParam('P_CRCNT_CODIGO',inRecord.get('CRCNT_CODIGO'));
        myJasperServer.setReportFolder('/Reports/sii/residencia');
        myJasperServer.setReportName(inRecord.data.CKESP_REPORTE);
        myJasperServer.run();
    }
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_carnet.
     */
    var chkCrcnt_carnet_impreso = new Ext.grid.CheckColumn(
    {dataIndex:'CRCNT_CARNET_IMPRESO',header:'Impreso?',width:100,sortable:true}
            );
    var cmCgg_res_carnet = new Ext.grid.ColumnModel([
        {dataIndex: 'CRCNT_SERIE',header: 'Serie',width: 150,sortable: true},
        {dataIndex: 'CRCNT_FECHA_EMISION',header: 'Fecha emisi\u00f3n',width: 100,sortable: true,renderer:truncDate},
        {dataIndex: 'CRCNT_FECHA_APROBACION',header: 'Fecha aprobaci\u00f3n',width: 100,sortable: true,renderer:truncDate},
        {dataIndex: 'CRCNT_FECHA_CADUCIDAD',header: 'Fecha caducidad',width: 100,sortable: true,renderer:truncDate},
        {dataIndex: 'CRCNT_FECHA_DEPOSITO',header: 'Fecha deposito',width: 100,sortable: true,renderer:truncDate},
        {dataIndex:'CRCNT_NUMERO_COMP',header:'Comprobante',width:150,sortable:true},
        {dataIndex:'CUENTA',header:'Cuenta',width:180,sortable:true},
        {dataIndex: 'CRCNT_VALOR',header: 'Valor',width: 100,sortable: true,renderer: 'usMoney',align: 'right'},
        chkCrcnt_carnet_impreso
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_carnet por un campo especifico.
     */
    var gsCgg_res_carnet = new Ext.data.Store({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_res_carnet",
            method: "selectPageDirect",
            pagin: true
        }),
        remoteSort: true,
        reader: new Ext.data.JsonReader({
            id: 'CRCNT_CODIGO',
            root: 'dataSet',
            totalProperty: 'totalCount'
        }, [
            {name: 'CRCNT_CODIGO'},
            {name: 'CRPER_CODIGO'},
            {name: 'CRPER_NUM_DOC_IDENTIFIC'},
            {name: 'CRPER_NUMERO_RESIDENCIA'},
            {name: 'CRRSD_CODIGO'},
            {name: 'CRCOM_CODIGO'},
            {name: 'CRADJ_CODIGO'},
            {name: 'CRCNT_SERIE'},
            {name: 'CRCNT_FECHA_EMISION'},
            {name: 'CRCNT_FECHA_APROBACION'},
            {name: 'CRCNT_FECHA_CADUCIDAD'},
            {name: 'CRCNT_FECHA_DEPOSITO'},
            {name:'CRCNT_NUMERO_COMP'},
            {name:'CRCNT_CARNET_IMPRESO'},
            {name: 'CUENTA'},
            {name: 'CRCNT_VALOR'},
            {name: 'CRCNT_OBSERVACION'},
            {name: 'CKESP_CODIGO'},
            {name: 'CKESP_REPORTE'},
            {name: 'AUSPICIANTE'},
            {name: 'OCUPACION'}
        ]),
        sortInfo: {
            field: 'CRCNT_SERIE',
            direction: 'ASC'
        },
        baseParams: {
            keyword: "",
            format: 'JSON',
            inCrrsd_codigo:''
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_carnet.
     */
    var pgBarCgg_res_carnet = new Ext.PagingToolbar({
        store: gsCgg_res_carnet,
        displayInfo: true,
        pageSize: RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_carnet en un formato tabular de filas y columnas.
     */
    var grdCgg_res_carnet = new Ext.grid.GridPanel({
        cm: cmCgg_res_carnet,
        store: gsCgg_res_carnet,
        region: 'center',
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true
        }),
        loadMask: {
            msg: "Cargando..."
        },
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store: gsCgg_res_carnet,
                width: 200
            })
        ],
        bbar: pgBarCgg_res_carnet
    });
    gsCgg_res_carnet.reload({
        params: {
            start: 0,
            limit: RECORD_PAGE,
            format: 'JSON'
        }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_carnet.
     */
    if(inDesktop){
        var winFrmListadoCgg_res_carnet = inDesktop.createWindow({
            id: 'winFrmListadoCgg_res_carnet',
            title: tituloListadoCgg_res_carnet,
            width: 800,
            minWidth: 600,
            frame:true,
            height: 600,
            minHeight: 400,
            maximizable: true,
            minimizable: true,
            constrain: true,
            layout: 'border',
            tbar: getPanelTitulo(tituloListadoCgg_res_carnet, descListadoCgg_res_carnet),
            items: [pnlPersona,grdCgg_res_carnet],
            bbar: [btnNuevoCgg_res_carnet,btnActualizarPersonaCgg_res_carnet,btnActualizarAuspicianteCgg_res_carnet, btnAdjuntos,'-',btnPreviewCgg_res_carnet, btnReporteCgg_res_carnet,btnDatosPersonaCgg_res_carnet,/*'-',btnNotificacionFinanCgg_res_carnet,*/'->', btnSalirCgg_res_carnet]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_res_carnet.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_carnet.
     * @returns ventana winFrmCgg_res_carnet.
     * @base FrmListadoCgg_res_carnet.prototype.show
     */
    this.getWindow = function () {
        return winFrmListadoCgg_res_carnet;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_carnet.
     * @base FrmListadoCgg_res_carnet.prototype.loadData
     */
    this.loadData = function () {
        gsCgg_res_carnet.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function () {
        return cmCgg_res_carnet;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function () {
        return gsCgg_res_carnet;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_carnet.prototype.getColumnModel = function () {
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_carnet.prototype.getStore = function () {
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_carnet desde una instancia.
 */
FrmListadoCgg_res_carnet.prototype.show = function () {
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_carnet desde una instancia.
 */
FrmListadoCgg_res_carnet.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_carnet,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_carnet.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_carnet desde una instancia.
 */
FrmListadoCgg_res_carnet.prototype.loadData = function () {
    this.loadData();
}