/**
 * Funcion publica. Formulario que permite visualizar en forma de listado la informacion de los registros de de tramites para aprobacion definitiva.
 * @constructor
 * @param inDesktop Escritorio web de la aplicacion.
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_transeunte(inDesktop){
    var optMenu = 'Control de Residencia/Listado de transeuntes';
    var tituloListadoCgg_res_transeunte='Listado de transeuntes aprobados.';
    var descListadoCgg_res_transeunte='El formulario permite visualizar informaci\u00f3n de los tr\u00E1mites de transeuntes aprobados.';

    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_transeunte_aprobacion.
     */
    var btnSalirCgg_res_transeunte = new Ext.Button({
        id:'btnSalirCgg_res_transeunte',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_transeunte.close();
            }
        }
    });

    /**
     * Ext.Button Boton para obtener reportes, general o individual.
     */
    var btnReporteCgg_res_transeunte = new Ext.Button({
        id:'btnReporteCgg_res_transeunte',
        name:'btnReporteCgg_res_transeunte',
        text:'Reportes',
        iconCls:'iconImprimir',
        menu:[{
            text:'Certificado de transe\u00fante',
            id:'btnEmitirCertificado',
            listeners:{
                click:function(){
                    var rTranseunte = grdCgg_res_transeunte.getSelectionModel().getSelected();
                    if(rTranseunte!==null && rTranseunte !==undefined){
                        var report = '';
                        var tmpParams = [];
                        try{
                            var scpSolicitudPadre= new SOAPClientParameters();
                            scpSolicitudPadre.add('inCrtst_codigo',rTranseunte.get('CRTST_CODIGO'));
                            scpSolicitudPadre.add('format',TypeFormat.JSON);
                            var crtstPadre = SOAPClient.invoke(URL_WS+'Cgg_res_tipo_solicitud_tramite','select',scpSolicitudPadre, false,null);

                            crtstPadre = eval(crtstPadre);
                            crtstPadre = crtstPadre[0];

                            if(crtstPadre.CRTST_APLICA_OTRO == undefined || crtstPadre.CRTST_APLICA_OTRO == null){
                                Ext.MsgPopup.msg(tituloListadoCgg_res_transeunte, 'Se present\u00f3 un problema al presentar su reporte.<br>Error:'+ERR_MESSAGE, MsgPopup.WARNING);
                                return;
                            }else if(crtstPadre.CRTST_APLICA_OTRO == true){
                                if(rTranseunte.get('CRRSD_FECHA_INICIO') != undefined && rTranseunte.get('CRRSD_FECHA_INICIO') != null){
                                    printTranseunteTemporal(rTranseunte);
                                }
                                else
                                {
                                    var ingresoTranseunte = new DlgIngresoFecha();
                                    ingresoTranseunte.closeHandler(function(){
                                        if(!ingresoTranseunte.isSuccess()){
                                            Ext.Msg.show({
                                                title:tituloListadoCgg_res_transeunte,
                                                msg: 'No se puede establecer la fecha de ingreso del residente como transeunte.<br>Por favor establezca esta informaci\u00f3n para continuar.',
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.WARNING
                                            });
                                            return;
                                        }
                                        var scpFechaIngreso = new SOAPClientParameters({
                                            inCrrsd_codigo:rTranseunte.get('CRRSD_CODIGO'),
                                            inCrrsd_fecha_inicio:ingresoTranseunte.getValue().format(TypeDateFormat.Custom)
                                        });

                                        try{
                                            var tmpFechaIngreso = SOAPClient.invoke(URL_WS+'Cgg_res_residencia','updateFechaInicio', scpFechaIngreso, false, false);
                                            tmpFechaIngreso = Ext.util.JSON.decode(tmpFechaIngreso);
                                            if(tmpFechaIngreso == true){
                                                printTranseunteTemporal(rTranseunte);
                                            }else{
                                                Ext.Msg.show({
                                                    title:tituloListadoCgg_res_transeunte,
                                                    msg: 'No se pudo establecer la fecha de ingreso del residente como transeunte.<br>Error:'+tmpFechaIngreso+'.<br>'+ERR_MESSAGE,
                                                    buttons: Ext.Msg.OK,
                                                    icon: Ext.MessageBox.WARNING
                                                });
                                            }
                                        }catch(inErr){
                                            Ext.Msg.show({
                                                title:tituloListadoCgg_res_transeunte,
                                                msg: 'No se pudo establecer la fecha de ingreso del residente como transeunte.<br>Error:'+inErr+'.<br>'+ERR_MESSAGE,
                                                buttons: Ext.Msg.OK,
                                                icon: Ext.MessageBox.WARNING
                                            });
                                        }
                                    });
                                    ingresoTranseunte.show();
                                }

                            }else if(crtstPadre.CRTST_APLICA_OTRO == false){
                                report = 'rptCertificadoTranseunteporNumeroTramiteOficio';

                                tmpParams[0]={
                                    label:'Tr\u00E1mite',
                                    paramName:'P_CRTRA_CODIGO',
                                    paramValue:rTranseunte.get('CRTRA_CODIGO'),
                                    value:rTranseunte.get('CRTRA_ANIO')+'-'+rTranseunte.get('CRTRA_NUMERO'),
                                    type:'direct'
                                };

                                tmpParams[1]={
                                    objectName:'Cgg_usuario',
                                    label:'Autorizado por',
                                    valueField:'CUSU_CODIGO',
                                    displayField:'NOMBRES|APELLIDOS',
                                    paramName:'P_CUSU_RESPONSABLE',
                                    paramValue:'',
                                    type:'searchable'
                                };

                                tmpParams[2]={
                                    objectName:'Cgg_usuario',
                                    label:'Certificado por',
                                    valueField:'CUSU_CODIGO',
                                    displayField:'NOMBRES|APELLIDOS',
                                    paramName:'P_CUSU_CODIGO',
                                    paramValue:'',
                                    type:'searchable'
                                };

                                var reporte = new FrmCriterioReporte(report, '/Reports/sii/residencia', null);
                                reporte.addParams(tmpParams);
                                reporte.show();
                            }
                        }catch(inErr){
                            Ext.MsgPopup.msg(tituloListadoCgg_res_transeunte, 'Se present\u00f3 un problema al presentar su reporte.<br>Error:'+inErr+'.<br>'+ERR_MESSAGE, MsgPopup.WARNING);
                        }
                    }
                }
            }
        }
        ]
    });

    function printTranseunteTemporal(record)
    {
        //GENERACION DEL REPORTE
        var inReport = 'rptCertificadoTranseunteporTemporal';
        var inTmpParams = [];
        inTmpParams[0]={
            label:'Tr\u00E1mite',
            paramName:'P_CRTRA_CODIGO',
            paramValue:record.get('CRTRA_CODIGO'),
            value:record.get('CRTRA_ANIO')+'-'+record.get('CRTRA_NUMERO'),
            type:'direct'
        };

        inTmpParams[1]={
            objectName:'Cgg_usuario',
            label:'Autorizado por',
            valueField:'CUSU_CODIGO',
            displayField:'NOMBRES|APELLIDOS',
            paramName:'P_CUSU_RESPONSABLE',
            paramValue:'',
            type:'searchable'
        };
        var reporte = new FrmCriterioReporte(inReport, '/Reports/sii/residencia', null);
        reporte.addParams(inTmpParams);
        reporte.show();
    }
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_transeunte por un campo especifico.
     */
    var gsCgg_res_transeunte = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_residencia",
            method:"selectTranseunteDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRTRA_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {
                name:'CRRSD_CODIGO'
            },
            {
                name:'CRTRA_CODIGO'
            },
            {
                name:'CRPER_CODIGO'
            },
            {
                name:'CRPER_TBENEFICIARIO'
            },
            {
                name:'CRPJR_CODIGO'
            },
            {
                name:'CRPJR_NOMBRES'
            },
            {
                name:'CGG_CRPER_CODIGO'
            },
            {
                name:'CRPER_NUM_DOC_IDENTIFIC'
            },
            {
                name:'CRPER_TAUSPICIANTE'
            },
            {
                name:'CRPRO_CODIGO'
            },
            {
                name:'CRTST_CODIGO'
            },
            {
                name:'CRTST_DESCRIPCION'
            },
            {
                name:'CISLA_CODIGO'
            },
            {
                name:'CRTRA_ANIO'
            },
            {
                name:'CRTRA_NUMERO'
            },
            {
                name:'CRTRA_FECHA_RECEPCION'
            },
            {
                name:'CRTRA_ACTIVIDAD_RESIDENCIA'
            },
            {
                name:'ACTIVIDAD_RESIDENCIA'
            },
            {
                name:'CRTRA_OBSERVACION'
            },
            ,{
                name:'CRTRA_GRUPO'
            },
            {
                name:'CRTRA_ORDEN'
            },
            {
                name:'CRRSD_FECHA_INICIO'
            },

            {
                name:'CRRSD_FECHA_CADUCIDAD'
            },

            {
                name:'CRRSD_VIGENTE'
            }
        ]),
        groupField:'CRTRA_FECHA_RECEPCION',
        sortInfo:{
            field: 'CRTRA_FECHA_RECEPCION',
            direction: 'DESC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });

    var cbcCRTRA_GRUPO =  new Ext.grid.CheckColumn({
        dataIndex:'CRTRA_GRUPO',
        header:'Grupal',
        width:80,
        sortable:true
    });

    var cbcCRRSD_VIGENTE =  new Ext.grid.CheckColumn({
        dataIndex:'CRRSD_VIGENTE',
        header:'Vigente',
        width:80,
        sortable:true
    });


    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_tramite.
     */
    var cmCgg_res_transeunte = new Ext.grid.ColumnModel([{
        dataIndex:'CRTRA_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
        {
            dataIndex:'CRTRA_ANIO',
            header:'A\u00F1o',
            width:80,
            sortable:true
        },
        {
            dataIndex:'CRTRA_NUMERO',
            header:'Tr\u00E1mite',
            width:100,
            sortable:true
        },
        {
            dataIndex:'CRPER_TAUSPICIANTE',
            header:'Auspiciante',
            width:210,
            sortable:true,
            renderer:function(value,metaData,record)
            {
                if (record.data.CRPJR_NOMBRES)
                {
                    return record.data.CRPJR_NOMBRES;
                }
                else
                {
                    return value;
                }
            }
        },
        {
            dataIndex:'CRPJR_NOMBRES',
            //header:'Persona jur\u00EDdica',
            header:'Tipo',
            width:50,
            sortable:true,
            renderer:function(value,metaData,record)
            {
                if (record.data.CRPJR_NOMBRES) {
                    metaData.css = 'iconPersonaJuridica';

                }
                else
                {

                    metaData.css = 'iconPersonaNatural';

                }
                return '';
            }
        },
        {
            dataIndex:'CRPER_NUM_DOC_IDENTIFIC',
            header:'No. documento',
            width:80,
            sortable:true
        },
        {
            dataIndex:'CRPER_TBENEFICIARIO',
            header:'Beneficiario',
            width:210,
            sortable:true
        },
        {
            dataIndex:'CRPRO_CODIGO',
            header:'Proceso',
            width:100,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRTST_DESCRIPCION',
            header:'Solicitud',
            width:100,
            sortable:true
        },
        {
            dataIndex:'CISLA_CODIGO',
            header:'Isla',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },{
            dataIndex:'CISLA_NOMBRE',
            header:'Isla',
            width:100,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRTRA_FECHA_RECEPCION',
            header:'Recepci\u00F3n',
            width:90,
            sortable:true,
            renderer:truncDate
        },
        {
            dataIndex:'ACTIVIDAD_RESIDENCIA',
            header:'Actividad',
            width:100
        },
        {
            dataIndex:'CRTRA_OBSERVACION',
            header:'Observaciones',
            width:150,
            sortable:true
        },cbcCRTRA_GRUPO,{
            dataIndex:'CRTRA_ORDEN',
            header:'Transeunte',
            width:80
        },
        {
            dataIndex:'CRRSD_FECHA_INICIO',
            header:'Fecha inicio',
            width:80,
            renderer:truncDate
        },{
            dataIndex:'CRRSD_FECHA_CADUCIDAD',
            header:'Fecha caducidad',
            width:80,
            renderer:truncDate
        },cbcCRRSD_VIGENTE
    ]);

    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_transeunte.
     */
    var pgBarCgg_res_transeunte= new Ext.PagingToolbar({
        store: gsCgg_res_transeunte,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });

    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_transeunte en un formato tabular de filas y columnas.
     */
    var grdCgg_res_transeunte = new Ext.grid.GridPanel({
        cm:cmCgg_res_transeunte,
        store:gsCgg_res_transeunte,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Tr\u00E1mites" : "Tr\u00E1mite"]})'
        }),
        loadMask:{
            msg:"Cargando..."
        },
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_transeunte,
                width:200
            })
        ],
        plugins:[new Ext.ux.grid.AutoSizeColumns()],
        bbar:pgBarCgg_res_transeunte
    });

    gsCgg_res_transeunte.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:TypeFormat.JSON
        }
    });

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_transeunte.
     */
    var winFrmListadoCgg_res_transeunte=null;

    if(inDesktop !== null && inDesktop !== undefined){
        winFrmListadoCgg_res_transeunte=inDesktop.createWindow({
            id:'winFrmListadoCgg_res_transeunte',
            title:tituloListadoCgg_res_transeunte,
            tbar:getPanelTitulo(tituloListadoCgg_res_transeunte,descListadoCgg_res_transeunte),
            items:[grdCgg_res_transeunte],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            iconCls:'iconAprobacionResidencia',
            bbar:[btnReporteCgg_res_transeunte,'->',btnSalirCgg_res_transeunte]
        });
    }else{
        winFrmListadoCgg_res_transeunte = new Ext.Window({
            id:'winFrmListadoCgg_res_transeunte',
            title:tituloListadoCgg_res_transeunte,
            tbar:getPanelTitulo(tituloListadoCgg_res_transeunte,descListadoCgg_res_transeunte),
            items:[grdCgg_res_transeunte],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            iconCls:'iconAprobacionResidencia',
            bbar:[btnReporteCgg_res_transeunte,'->',btnSalirCgg_res_transeunte]
        });
    }

    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_transeunte.getBottomToolbar());

    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_transeunte_aprobacion.
     * @returns ventana winFrmCgg_res_transeunte.
     * @base FrmListadoCgg_res_transeunte_aprobacion.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_transeunte;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_transeunte_aprobacion.
     * @base FrmListadoCgg_res_transeunte_aprobacion.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_transeunte.load();
    }

}

/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_transeunte_aprobacion desde una instancia.
 */
FrmListadoCgg_res_transeunte.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_transeunte_aprobacion desde una instancia.
 */
FrmListadoCgg_res_transeunte.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_transeunte_aprobacion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_transeunte.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_transeunte_aprobacion desde una instancia.
 */
FrmListadoCgg_res_transeunte.prototype.loadData = function(){
    this.loadData();
}
