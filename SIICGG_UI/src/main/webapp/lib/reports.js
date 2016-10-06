MyDesktop.mReporte = Ext.extend(MyDesktop.StartMenuItem, {
    init : function(){
        this.launcher = {
            id:'mnRootReports',
            text:'Reportes',
            hidden:true,
            iconCls:'iconImprimir',
            handler: function() {
                return false;
            },
            menu: {
                items:[{
                    text:'Control de residencia',
                    iconCls:'iconReporte',
                    hidden:true,
                    id:'mnRes',
                    scope:this,
                    menu:{
                        items:[{
                            text: 'Listado de tramites recibidos-despachado por secci\u00f3n',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnRes-rptListadoSolicitudesResidenciaReceptados',
                            handler:function(){
                                //Revisado
                                var params = [];
                                params[0]=
                                {
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date',
                                    required:true
                                };

                                params[1]=
                                {
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date',
                                    required:true
                                };

                                params[2]=
                                {
                                    label:'Usuario',
                                    paramName:'P_CUSU_CODIGO',
                                    paramValue:new UserSession().getUserID(),
                                    value:new UserSession().getUserData().CUSU_NOMBRE_USUARIO,
                                    type:'direct'
                                };

                                params[3]=
                                {
                                    label:'Tipo residencia',
                                    paramName:'P_CRTST_CODIGO',
                                    value: dsTipoSolicitudPadreTranseunte,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };

                                params[4]=
                                {
                                    objectName:'FrmListadoCgg_res_seccion',
                                    label:'Secci\u00f3n',
                                    valueField:'CRSEC_CODIGO',
                                    displayField:'CRSEC_NOMBRE',
                                    paramName:'P_CRSEC_CODIGO',
                                    paramValue:'',
                                    type:'searchable',
                                    required:true
                                };

                                params[5]=
                                {
                                    label:'Atenci\u00f3n',
                                    paramName:'P_CRSEG_ESTADO_ATENCION',
                                    value:dsEstadoAtencion,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };

                                var reporte = new FrmCriterioReporte('rptListadoSolicitudesResidenciaReceptados', '/Reports/sii/residencia', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text: 'Tr\u00e1mites administrativos de residencias',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnRes-Ana',
                            menu:{
                                items:[
                                {
                                    text: 'Listado de tramite para legalizaci\u00f3n contrato',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Ana-rptListadoCarpetasControlLegalizacionContrato',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[1]=
                                        {
                                            objectName:'FrmListadoCgg_res_tipo_solicitud_tramite',
                                            label:'Tipo solicitud',
                                            valueField:'CRTST_CODIGO',
                                            displayField:'CRTST_DESCRIPCION',
                                            paramName:'P_CRTST_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_res_estado_tramite',
                                            label:'Estado tr\u00E1mite',
                                            valueField:'CRETT_CODIGO',
                                            displayField:'CRETT_NOMBRE',
                                            paramName:'P_CRETT_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[3]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[4]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoCarpetasControlLegalizacionContrato', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Listado de tr\u00E1mites por fases',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Ana-rptTramitesFasesUsuarioEntregaRecibe',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_res_fase',
                                            label:'Fase',
                                            valueField:'CRFAS_CODIGO',
                                            displayField:'CRFAS_NOMBRE',
                                            paramName:'P_CRFAS_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[3]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
											required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptTramitesFasesUsuarioEntregaRecibe', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado de tramite para legalizaci\u00f3n y control contrato',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Ana-rptListadoCarpetasControlLegalizacionContrato',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[1]=
                                        {
                                            objectName:'FrmListadoCgg_res_tipo_solicitud_tramite',
                                            label:'Tipo solicitud',
                                            valueField:'CRTST_CODIGO',
                                            displayField:'CRTST_DESCRIPCION',
                                            paramName:'P_CRTST_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_res_estado_tramite',
                                            label:'Estado tr\u00E1mite',
                                            valueField:'CRETT_CODIGO',
                                            displayField:'CRETT_NOMBRE',
                                            paramName:'P_CRETT_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[3]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[4]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoCarpetasControlLegalizacionContrato', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text: 'Listado de tr\u00E1mites para pre aprobaci\u00f3n',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Ana-rptListadoTramitesporEstado1',
                                    handler:function(){
                                        //Revisado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable'

                                        };

                                        var scpEstadoTramite = new SOAPClientParameters({
                                            inCgcnf_codigo:'27',
                                            format:TypeFormat.JSON
                                        });
                                        var crettCodigo = null;
                                        try{
                                            crettCodigo = SOAPClient.invoke(URL_WS+'Cgg_configuracion', 'select', scpEstadoTramite, false, null);
                                            crettCodigo = Ext.util.JSON.decode(crettCodigo)[0];
                                            crettCodigo = crettCodigo.CGCNF_VALOR_CADENA;
                                        }catch(inErr){
                                            crettCodigo ='CRETT8';
                                        }

                                        params[1]=
                                        {
                                            label:'Estado tramite',
                                            paramName:'P_CRETT_CODIGO',
                                            value:'PRE APROBACION',
                                            paramValue:crettCodigo,
                                            type:'direct'
                                        };

                                        params[2]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[3]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoTramitesporEstado', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text: 'Listado de tr\u00E1mites pre aprobados para comite',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Ana-rptListadoTramitesporEstado2',
                                    handler:function(){
                                        //Revisado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable'

                                        };

                                        var scpEstadoTramite = new SOAPClientParameters({
                                            inCgcnf_codigo:'17',
                                            format:TypeFormat.JSON
                                        });
                                        var crettCodigo = null;
                                        try{
                                            crettCodigo = SOAPClient.invoke(URL_WS+'Cgg_configuracion', 'select', scpEstadoTramite, false, null);
                                            crettCodigo = Ext.util.JSON.decode(crettCodigo)[0];
                                            crettCodigo = crettCodigo.CGCNF_VALOR_CADENA;
                                        }catch(inErr){
                                            crettCodigo ='CRETT2';
                                        }

                                        params[1]=
                                        {
                                            label:'Estado tramite',
                                            paramName:'P_CRETT_CODIGO',
                                            value:'LISTO PARA COMITE',
                                            paramValue:crettCodigo,
                                            type:'direct'
                                        };

                                        params[2]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[3]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoTramitesporEstado', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                }
                                ]
                            }
                        },{
                            text: 'Seguimiento',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnRes-Seg',
                            menu:{
                                items:[{
                                    text: 'Listado de informes seguimiento parejas',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Seg-rptListadoDetalladoSeguimientoParejas',
                                    handler:function(){
                                        //Revisado
                                        var params = [];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoDetalladoSeguimientoParejas', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Listado de personas notificadas por periodo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Seg-rptListadoPersonasNotificadas',
                                    handler:function(){
                                        //Revisado y enlazado
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[2]={
                                            objectName:'FrmListadoCgg_canton',//objeto con getStore and get Columnmodel
                                            label:'Cant\u00f3n',
                                            valueField:'CCTN_CODIGO',
                                            displayField:'CCTN_NOMBRE',
                                            paramName:'P_CCTN_CODIGO',//nombre parametro
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[3]={
                                            label:'Estado',
                                            paramName:'P_PERMITIDO',
                                            value:dsEstadoPermitidoNotificacion,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };

                                        params[4]={
                                            label:'Ubicaci\u00f3n',
                                            paramName:'P_UBICACION_NOTIFICADO',
                                            value:dsUbicacion,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoPersonasNotificadas', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Registro notificaciones por periodo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Seg-rptListadoNotificacionesDetalladoAnualporMes',
                                    handler:function(){
                                        //Revisado y enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_canton',
                                            label:'Cant\u00f3n',
                                            valueField:'CCTN_CODIGO',
                                            displayField:'CCTN_NOMBRE',
                                            paramName:'P_CCTN_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[1]=
                                        {
                                            label:'A\u00f1o',
                                            paramName:'P_ANIO',
                                            paramValue:'',
                                            type:'input',
                                            required:true
                                        };
                                        params[2]=
                                        {
                                            label:'Mes',
                                            paramName:'P_MES',
                                            value:dsMes,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoNotificacionesDetalladoAnualporMes', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text: 'Listado total de notificaciones anual',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Seg-rptListadoNotificacionesAnual',
                                    handler:function(){
                                        //Revisado y enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_canton',
                                            label:'Cant\u00f3n',
                                            valueField:'CCTN_CODIGO',
                                            displayField:'CCTN_NOMBRE',
                                            paramName:'P_CCTN_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[1]=
                                        {
                                            label:'A\u00f1o',
                                            paramName:'P_ANIO',
                                            paramValue:'',
                                            type:'input'
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoNotificacionesAnual', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                }]
                            }
                        },{
                            text: 'Comit\u00e9',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnRes-Com',
                            menu:{
                                items:[{
                                    text: 'Listado de residentes temporales',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Com-rptListadoActualizadoResidentesTemporales',
                                    handler:function(){
                                        var params = [];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
									
                                        var reporte = new FrmCriterioReporte('rptListadoActualizadoResidentesTemporales', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Tr\u00E1mites residencia con resoluci\u00f3n',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Com-rptListadoTramitesResidencia',
                                    handler:function(){
                                        var params = [];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoTramitesResidencia', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text: 'Tr\u00E1mites para aprobaci\u00f3n definitiva en comit\u00e9 de residencia',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Com-rptListadoTramiteResidenciaComite',
                                    handler:function(){
                                        //Revisado
                                        var params = [];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_res_comite',
                                            label:'Comit\u00e9',
                                            valueField:'CRCOM_CODIGO',
                                            displayField:'CRCOM_NOMBRE',
                                            paramName:'P_CRCOM_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };

                                        params[3]={
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoTramiteResidenciaComite', '/Reports/sii/comite', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                }, {
                                    text: 'Listado de tramites temporales para votaci\u00f3n en comit\u00e9',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Sec-rptListadoResidentesTemporalesPreaprobados',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoResidentesTemporalesPreaprobados', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Listado tr\u00E1mites para calificaci\u00f3n o por estado',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Sec-rptListadosTramitesporIslaEstado',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            objectName:'FrmListadoCgg_res_estado_tramite',
                                            label:'Estado tr\u00E1mite',
                                            valueField:'CRETT_CODIGO',
                                            displayField:'CRETT_NOMBRE',
                                            paramName:'P_CRETT_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_res_tipo_solicitud_tramite',
                                            label:'Tipo solicitud',
                                            valueField:'CRTST_CODIGO',
                                            displayField:'CRTST_DESCRIPCION',
                                            paramName:'P_CRTST_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
											
                                        };
                                        params[3]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[4]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
										
                                        var reporte = new FrmCriterioReporte('rptListadosTramitesporIslaEstado', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Listado de resoluciones por periodo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Sec-rptListadoResolucionPeriodo',
                                    handler:function(){
                                        //Revisado
                                        var params=[];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_res_comite',
                                            label:'Comit\u00e9',
                                            valueField:'CRCOM_CODIGO',
                                            displayField:'CRCOM_NOMBRE',
                                            paramName:'P_CRCOM_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoResolucionPeriodo', '/Reports/sii/comite', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Listado de resoluciones por estado',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Sec-rptListadoResolucionPeriodoEstado',
                                    handler:function(){
                                        //Revisado
                                        var params=[];
                                        params[0]=
                                        {
                                            label:'Estado resoluci\u00f3n',
                                            paramName:'P_CRRES_ESTADO_RESOLUCION',
                                            value: dsEstadoResolucion,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[3]=
                                        {
                                            objectName:'FrmListadoCgg_res_comite',
                                            label:'Comit\u00e9',
                                            valueField:'CRCOM_CODIGO',
                                            displayField:'CRCOM_NOMBRE',
                                            paramName:'P_CRCOM_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoResolucionPeriodoEstado', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado de sesiones realizadas por periodo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Sec-rptSesionesRealizadasporPeriodo',
                                    handler:function(){
                                        //Revisado y enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptSesionesRealizadasporPeriodo', '/Reports/sii/comite', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Asistentes a sesiones realizadas por periodo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Sec-rptAsistentesaSesionesporPeriodo',
                                    handler:function(){
                                        //Revisado y enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptAsistentesaSesionesporPeriodo', '/Reports/sii/comite', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Asistentes que votaron en sesion por resoluci\u00f3n',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Sec-rptVotosSesion',
                                    handler:function(){
                                        //Revisado y enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_res_resolucion',
                                            label:'N. Tr\u00E1mite',
                                            valueField:'CRRES_CODIGO',
                                            displayField:'CRRES_NUMERO_RESOLUCION|CRRES_EXTRACTO_RESOLUCION',
                                            paramName:'P_CRRES_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[1]=
                                        {
                                            objectName:'FrmListadoCgg_res_sesion_comite',
                                            label:'Sesi\u00f3n',
                                            valueField:'CRSSC_CODIGO',
                                            displayField:'CRSSC_NUMERO_SESION',
                                            paramName:'P_CRSSC_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
										
                                        var reporte = new FrmCriterioReporte('rptVotosSesion', '/Reports/sii/comite', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                }]
                            }
                        },{
                            text: 'Carnetizaci\u00f3n',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnRes-Car',
                            menu:{
                                items:[{
                                    text: 'Reporte de carnetizados por periodo y por usuario',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Car-rptReporteTotalCarnetizados',
                                    handler:function(){
                                        //Revisado
                                        var params = [];

                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_usuario',
                                            label:'Usuario',
                                            valueField:'CUSU_CODIGO',
                                            displayField:'CUSU_NOMBRE_USUARIO',
                                            paramName:'P_CUSU_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptReporteTotalCarnetizados', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Reporte total carnetizados por tipo residencia',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Car-rptReporteTotalCarnetizadoTipoResidencia',
                                    handler:function(){
                                        //Revisado
                                        var params = [];

                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
											
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_res_tipo_solicitud_tramite',
                                            label:'Tipo solicitud',
                                            valueField:'CRTST_CODIGO',
                                            displayField:'CRTST_DESCRIPCION',
                                            paramName:'P_CRTST_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        var reporte = new FrmCriterioReporte('rptReporteTotalCarnetizadoTipoResidencia', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado tramites aprobado para carnetizar',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Car-rptListadoResidentesAprobadosparaCarnetizacion1',
                                    handler:function(){
                                        //Enlazado
                                        var params =[];
                                        params[0]={
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        params[1]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoResidentesAprobadosparaCarnetizacion', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Informe de valores por carnetizaci\u00f3n',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Car-rptInformeValorIngresoCarnetizacion',
                                    handler:function(){
                                        var params=[];
                                        params[0]=
                                        {
                                            label:'A\u00f1o',
                                            paramName:'P_ANIO',
                                            paramValue:'',
                                            type:'input'
                                        };

                                        params[1]=
                                        {
                                            label:'Mes',
                                            paramName:'P_MES',
                                            value:dsMes,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };

                                        params[2]=
                                        {
                                            label:'Tipo residencia',
                                            paramName:'P_CRTST_CODIGO',
                                            value: dsTipoSolicitudPadre,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };

                                        params[3]=
                                        {
                                            label:'Motivo carnet',
                                            paramName:'P_CRCNT_MOTIVO',
                                            value: dsMotivoCarnet,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptInformeValorIngresoCarnetizacion', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text: 'Stock especies carnetizaci\u00f3n',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Car-rptStockEspeciesCarnetizacion',
                                    handler:function(){
                                       
                                        var reporte = new Reporte('rptStockEspeciesCarnetizacion', '/Reports/sii/kardex', null);
                                        reporte.show();

                                    }
                                },{
                                    text: 'Listado residentes sin carnetizar por periodo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Car-rptListadoResidentesSinCarnetizar',
                                    handler:function(){
                                        //Revisado
                                        var params = [];

                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[2]={
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoResidentesSinCarnetizar', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },'-',{
                                    text: 'Control de especies',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Car-Ctr',
                                    menu:{
                                        items:[{
                                            text: 'Listado de transferencias de especies por canton',
                                            iconCls:'iconReporte',
                                            hidden:true,
                                            id:'mnRes-Car-Ctr-rptListadoEspeciesCantones',
                                            handler:function(){
                                                //Revisado
                                                var params = [];
                                              
                                                params[0]=
                                                {
                                                    objectName:'FrmListadoCgg_canton',
                                                    label:'Cant\u00f3n',
                                                    valueField:'CCTN_CODIGO',
                                                    displayField:'CCTN_NOMBRE',
                                                    paramName:'P_CCTN_CODIGO',
                                                    paramValue:'',
                                                    type:'searchable'
                                                };
                                                var reporte = new FrmCriterioReporte('rptListadoEspeciesCantones', '/Reports/sii/residencia', null);
                                                reporte.addParams(params);
                                                reporte.show();

                                            }
                                        }
                                        ]
                                    }
                                }
                                ]
                            }
                        },'-',{
                            text: 'Transe\u00fantes',
                            iconCls:'iconReporte',
                            hidden:false,
                            id:'mnRes-rptListadoTranseunte',
                            handler:function(){
                                //Enlazado
                                var params = [];
                                params[0]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date',
									required:true
                                };

                                params[1]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date',
									required:true
                                };
                                
								params[2]=
                                {
                                    label:'Estado',
                                    paramName:'P_TIPO_RESPUESTA',
                                    value: dsRespuestaSeguimientoRpt,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };
								params[3]=
                                {
                                    objectName:'FrmListadoCgg_isla',
                                    label:'Isla',
                                    valueField:'CISLA_CODIGO',
                                    displayField:'CISLA_NOMBRE',
                                    paramName:'P_CISLA_CODIGO',
                                    paramValue:'',
                                    type:'searchable'
                                };

                                var reporte = new FrmCriterioReporte('rptListadoTranseunte', '/Reports/sii/residencia', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text: 'Entrada/salida de personas',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnRes-Ent',
                            menu:{
                                items:[{
                                    text: 'Total ingreso/salida por tipo residencia Perm/Temp',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Ent-rptTotalIngresoSalidaPorTipo',
                                    handler:function(){
                                        //Revisado
                                        var params = [];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[2]=
                                        {
                                            label:'Tipo residencia',
                                            paramName:'P_CRTST_CODIGO',
                                            value: dsTipoSolicitudPadre,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };

                                        params[3]=
                                        {
                                            objectName:'FrmListadoCgg_res_aerolinea',
                                            label:'Aerolinea',
                                            valueField:'CRALN_CODIGO',
                                            displayField:'CRALN_NOMBRE',
                                            paramName:'P_CRALN_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
											
                                        };
                                        var reporte = new FrmCriterioReporte('rptTotalIngresoSalidaPorTipo', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Total de Nacionales/Extranjeros Turistas-Transeuntes',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Ent-rptNacionalesExtranjerosTuristasTranseuntes',
                                    handler:function(){
                                        var params = [];

                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        params[2]=
                                        {
                                            label:'Tipo Nacionalidad',
                                            paramName:'P_TIPO_NACIONALIDAD',
                                            value: dsTipoNacionalidad,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };
                                        params[3]=
                                        {
                                            objectName:'FrmListadoCgg_res_aerolinea',
                                            label:'Aerolinea',
                                            valueField:'CRALN_CODIGO',
                                            displayField:'CRALN_NOMBRE',
                                            paramName:'P_CRALN_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                            
                                        };
                                       
                                        var reporte = new FrmCriterioReporte('rptNacionalesExtranjerosTuristasTranseuntes', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Listado de turista/transeunte por usuario',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Ent-rptIngresoSalidaTuristaTranseunte',
                                    handler:function(){
                                        //Revisado
                                        var params = [];

                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[2]={
                                            label:'Tipo Operaci\u00f3n',
                                            paramName:'P_CRMOV_TIPO_OPERACION',
                                            value:dsRptTipoOperacion,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };
                                        params[3]=
                                        {
                                            objectName:'FrmListadoCgg_res_aerolinea',
                                            label:'Aerolinea',
                                            valueField:'CRALN_CODIGO',
                                            displayField:'CRALN_NOMBRE',
                                            paramName:'P_CRALN_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        params[4]=
                                        {
                                            objectName:'FrmListadoCgg_usuario',
                                            label:'Usuario',
                                            valueField:'CUSU_CODIGO',
                                            displayField:'CUSU_NOMBRE_USUARIO',
                                            paramName:'P_CUSU_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
										
                                        var reporte = new FrmCriterioReporte('rptIngresoSalidaTuristaTranseunte', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Total ingreso/salida residentes por aerolinea',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Ent-rptListadoIngresoSalidaResidentes',
                                    handler:function(){
                                        //Revisado
                                        var params = [];

                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_res_aerolinea',
                                            label:'Aerolinea',
                                            valueField:'CRALN_CODIGO',
                                            displayField:'CRALN_NOMBRE',
                                            paramName:'P_CRALN_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoIngresoSalidaResidentes', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Listado residentes por vuelo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Ent-rptListadoResidentesPorVuelo',
                                    handler:function(){
                                        //Revisado
                                        var params = [];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]={
                                            label:'Tipo Operaci\u00f3n',
                                            paramName:'P_CRMOV_TIPO_OPERACION',
                                            value:dsRptTipoOperacion,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };

                                        params[3]=
                                        {
                                            objectName:'FrmListadoCgg_res_aerolinea',
                                            label:'Aerolinea',
                                            valueField:'CRALN_CODIGO',
                                            displayField:'CRALN_NOMBRE',
                                            paramName:'P_CRALN_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        params[4]= 
                                        {
                                            label:'N\u00FAmero vuelo',
                                            paramName:'P_CRMOV_NUMERO_VUELO',
                                            paramValue:'',
                                            type:'input'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoResidentesPorVuelo', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Listado de cabotaje por periodo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Ent-rptListadoCabotajePasajerosDestinosIslasPeriodo',
                                    handler:function(){
                                        //Revisado
                                        var params = [];

                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoCabotajePasajerosDestinosIslasPeriodo', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado de cabotaje por isla',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Ent-rptListadoPasajerosCabotajePorIsla',
                                    handler:function(){
                                        //revisado
                                        var params=[];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoPasajerosCabotajePorIsla', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Listado ingresos/salidas por persona',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Ent-rptTotalIngresosSalidasPorPersona',
                                    handler:function(){
                                        //Revisado
                                        var params=[];

                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]=
                                        {
                                            label:'Num. documento o carnet',
                                            paramName:'P_CRPER_NUM_DOC_IDENTIFIC',
                                            paramValue:'',
                                            type:'input',
                                            required:true
                                        };

                                        var reporte = new FrmCriterioReporte('rptTotalIngresosSalidasPorPersona', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text: 'Personas notificadas no han salido provincia',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Ent-rptListadoPersonasNotificadas',
                                    handler:function(){
                                        var params=[];										
                                        params[0]=
                                        {   
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[2]={
                                            label:'Estado',
                                            paramName:'P_PERMITIDO',
                                            value:dsEstadoPermitidoNotificacion,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };

                                        params[3]={
                                            label:'Ubicaci\u00f3n',
                                            paramName:'P_UBICACION_NOTIFICADO',
                                            value:dsUbicacion,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoPersonasNotificadas', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                }
                                ]
                            }
                        },{
                            text: 'Garant\u00EDas de tesorer\u00EDa',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnRes-Gar',
                            menu:{
                                items:[
                                {
                                    text: 'Listado de garant\u00EDas por periodo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Gar-rptGarantiasGlobalPeriodo',
                                    handler:function(){
                                        var params=[];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptGarantiasGlobalPeriodo', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Listado de garant\u00EDas por caducidad',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Gar-rptListadoGarantiasCaducaPeriodo',
                                    handler:function(){
                                        var params=[];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoGarantiasCaducaPeriodo', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Listado de garant\u00EDas devueltas',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Gar-rptGarantiasDevueltas',
                                    handler:function(){
                                        //Revisado
                                        var params=[];
                                        params[0]=
                                        {
                                            label:'Estado dep\u00f3sito',
                                            paramName:'P_CRDPT_ESTADO_DEPOSITO',
                                            value:'Devueltas',
                                            paramValue:3,
                                            type:'direct'
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptGarantiasDevueltas', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Listado de garant\u00EDas en tesoreria',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Gar-rptGarantiasDevueltas',
                                    handler:function(){
                                        //Revisado
                                        var params=[];
                                        params[0]=
                                        {
                                            label:'Estado dep\u00f3sito',
                                            paramName:'P_CRDPT_ESTADO_DEPOSITO',
                                            value:'Contabilizadas en tesoreria',
                                            paramValue:1,
                                            type:'direct'
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptGarantiasDevueltas', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Resumen econ\u00f3mico garant\u00edas tesorer\u00EDa devueltas',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Gar-rptResumenEconomicoGarantiasDevueltas',
                                    handler:function(){
                                        //Revisado y enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            label:'Tipo dep\u00f3sito',
                                            paramName:'P_CRDPT_TIPO',
                                            value: dsTipoGarantia,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            label:'Estado dep\u00f3sito',
                                            paramName:'P_CRDPT_ESTADO_DEPOSITO',
                                            value: dsRptEstadoDeposito,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };
                                        params[2]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[3]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptResumenEconomicoGarantiasDevueltas', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                }
                                ]
                            }
                        },{
                            text: 'Estad\u00edsticos y listados varios',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnRes-Est',
                            menu:{
                                items:[{
                                    text: 'Tr\u00E1mites residencia permanentes',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Est-rptListadoTramitesResidenciasPermanentes',
                                    handler:function(){
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        params[2]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoTramitesResidenciasPermanentes', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Tr\u00E1mites residencia temporal',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Est-rptListadoTramitesResidenciasTemporales',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]={
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoTramitesResidenciasTemporales', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Listado residentes para entrega a las aerol\u00edneas',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Est-rptListadoResidentesAerolineas',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            label:'Tipo residencia',
                                            paramName:'P_CRTST_CODIGO',
                                            value: dsTipoSolicitudPadre,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[2]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoResidentesAerolineas', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text: 'Total de tipos de residencia',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Est-rptTotaldeTipoResidencias',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];

                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        var reporte = new FrmCriterioReporte('rptTotaldeTipoResidencias', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text: 'Reporte de denuncias de acuerdo criterio',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Est-rptDenuncia',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]={
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        var reporte = new FrmCriterioReporte('rptDenuncia', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Estadistico total de residencias por estado',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Est-rptTotalResidencias',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]={
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:false
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        
                                         params[3]=
                                        {
                                            label:'Tipo residencia',
                                            paramName:'P_CRTST_CODIGO',
                                            value: dsTipoSolicitudPadre,
                                            paramValue:'',
                                            type:'combo',
                                            required:false
                                        };
                                        
                                        params[4]=
                                        {
                                            label:'Estado',
                                            paramName:'P_CRSEG_TIPO_RESPUESTA',
                                            value: [[-1,'INDETERMINADO'],[0,'NEGADO'],[1,'APROBADO'],[2,'TODOS']],
                                            paramValue:'',
                                            type:'combo',
                                            required:false
                                        };                                                                                

                                        var reporte = new FrmCriterioReporte('rptTotalResidencias', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Listado total de residencias por estado',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnRes-Est-rptListadoTotalResidencias',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]={
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:false
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        
                                         params[3]=
                                        {
                                            label:'Tipo residencia',
                                            paramName:'P_CRTST_CODIGO',
                                            value: dsTipoSolicitudPadreTranseunteTodos,
                                            paramValue:'',
                                            type:'combo',
                                            required:false
                                        };
                                        
                                        params[4]=
                                        {
                                            label:'Estado',
                                            paramName:'P_CRSEG_TIPO_RESPUESTA',
                                            value: [[-1,'INDETERMINADO'],[0,'NEGADO'],[1,'APROBADO'],[2,'TODOS']],
                                            paramValue:'',
                                            type:'combo',
                                            required:false
                                        };                                                                                

                                        var reporte = new FrmCriterioReporte('rptListadoTotalResidencias', '/Reports/sii/residencia', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                }
                                ]
                            }
                        }]
                    }
                },{
                    text:'Kardex',
                    iconCls:'iconReporte',
                    hidden:true,
                    id:'mnKdx',
                    scope:this,
                    menu:{
                        items:[ {
                            text: 'Totales especies con da\u00f1o por tipo',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnKdx-rptTotalesEspeciesTipoDano',
                            handler:function(){
                                //revisado
                                var params = [];
                                params[0]=
                                {
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date',
                                    required:true
                                };

                                params[1]=
                                {
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date',
                                    required:true
                                };

                                params[2]={
                                    label:'Tipo especie',
                                    paramName:'P_CKESP_TIPO',
                                    value: dsTipoEspecie,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };

                                var reporte = new FrmCriterioReporte('rptTotalesEspeciesTipoDano', '/Reports/sii/kardex', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text: 'Totales utilizaci\u00f3n especie por tipo',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnKdx-rptTotalUtilizacionEspecie',
                            handler:function(){
                                var params = [];
                                params[0]=
                                {
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };
                                params[1]=
                                {
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[2]={
                                    label:'Tipo especie',
                                    paramName:'P_CKESP_TIPO',
                                    value: dsTipoEspecie,
                                    paramValue:'',
                                    type:'combo'
                                };

                                var reporte = new FrmCriterioReporte('rptTotalUtilizacionEspecie', '/Reports/sii/kardex', null);
                                reporte.addParams(params);
                                reporte.show();

                            }
                        },{
                            text: 'Informe de stock especie por tipo',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnKdx-rptTotalStockEspecies',
                            handler:function(){
                                //revisado
                                var params = [];
                                params[0]=
                                {
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };
                                params[1]=
                                {
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[2]={
                                    label:'Tipo especie',
                                    paramName:'P_CKESP_TIPO',
                                    value: dsTipoEspecie,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };

                                var reporte = new FrmCriterioReporte('rptTotalStockEspecies', '/Reports/sii/kardex', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text: 'Informe General de Ventas',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnKdx-rptInformeVentasGeneralporFechaBodegaUsuario',
                            handler:function(){
                                //Enlazado
                                var params = [];
                                params[0]={
                                    objectName:'FrmListadoCgg_kdx_punto_venta',//objeto con getStore and get Columnmodel
                                    label:'Punto de venta',
                                    valueField:'CKPVT_CODIGO',
                                    displayField:'CKPVT_NOMBRE',
                                    paramName:'P_CKPVT_CODIGO',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'
                                };

                                params[1]={
                                    objectName:'Cgg_kdx_usuario_pv',//objeto con getStore and get Columnmodel
                                    label:'Usuario PV',
                                    valueField:'CKUPV_CODIGO',
                                    displayField:'CRPER_NOMBRES',
                                    paramName:'P_CKUPV_CODIGO',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'
                                };

                                params[2]={
                                    label:'Fecha inicial',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[3]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                var reporte = new FrmCriterioReporte('rptInformeVentasGeneralporFechaBodegaUsuario', '/Reports/sii/kardex', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text: 'Informe Individual de Ventas',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnKdx-rptInformeVentasIndividualporFechaBodegaUsuario',
                            handler:function(){
                                //Enlazado
                                var params = [];

                                params[0]={
                                    objectName:'FrmListadoCgg_kdx_venta',//objeto con getStore and get Columnmodel
                                    label:'Venta',
                                    valueField:'CKVNT_NUMERO_VENTA',
                                    displayField:'CKVNT_NUMERO_VENTA',
                                    paramName:'P_CKVNT_NUMERO_VENTA',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'
                                };

                                params[1]={
                                    objectName:'FrmListadoCgg_kdx_punto_venta',//objeto con getStore and get Columnmodel
                                    label:'Punto de venta',
                                    valueField:'CKPVT_CODIGO',
                                    displayField:'CKPVT_NOMBRE',
                                    paramName:'P_CKPVT_CODIGO',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'
                                };

                                params[2]={
                                    label:'Fecha inicial',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[3]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                var reporte = new FrmCriterioReporte('rptInformeVentasIndividualporFechaBodegaUsuario', '/Reports/sii/kardex', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text: 'Reporte de custodias',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnKdx-rptListadoCustodiasKardexTCT',
                            handler:function(){
                                //Enlazado
                                var params = [];
                                params[0]={
                                    objectName:'FrmListadoCgg_kdx_punto_venta',//objeto con getStore and get Columnmodel
                                    label:'Punto de venta',
                                    valueField:'CKPVT_CODIGO',
                                    displayField:'CKPVT_NOMBRE',
                                    paramName:'P_CKPVT_CODIGO',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'
                                };

                                params[1]={
                                    objectName:'Cgg_kdx_usuario_pv',//objeto con getStore and get Columnmodel
                                    label:'Usuario PV',
                                    valueField:'CKUPV_CODIGO',
                                    displayField:'CRPER_NOMBRES',
                                    paramName:'P_CGG_CKUPV_CODIGO',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'

                                };
                                params[2]={
                                    label:'Fecha inicial',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };
                                params[3]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                var reporte = new FrmCriterioReporte('rptListadoCustodiasKardexTCT', '/Reports/sii/kardex', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text: 'Cierre de Caja diario',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnKdx-rptCierreCaja',
                            handler:function(){
                                //Enlazado
                                var params = [];
                                params[0]=
                                {
                                    objectName:'FrmListadoCgg_usuario',
                                    label:'Para',
                                    valueField:'CUSU_CODIGO',
                                    displayField:'CUSU_NOMBRE_USUARIO',
                                    paramName:'P_CUSU_CODIGO',
                                    paramValue:'',
                                    type:'searchable'
                                };

                                params[1]={
                                    objectName:'FrmListadoCgg_kdx_cierre',//objeto con getStore and get Columnmodel
                                    label:'No Cierre',
                                    valueField:'CKCRR_CODIGO',
                                    displayField:'CKCRR_NUMERO_CIERRE',
                                    paramName:'P_CKCRR_CODIGO',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'

                                };
                                params[2]=
                                {
                                    label:'No guia blindado',
                                    paramName:'P_NUMERO_GUIA',
                                    paramValue:'',
                                    type:'input',
                                    required:true

                                };
                                params[3]=
                                {
                                    label:'No funda entregado',
                                    paramName:'P_NUMERO_FUNDA',
                                    paramValue:'',
                                    type:'input',
                                    required:true
                                };
                                params[4]=
                                {
                                    label:'Recibo caja',
                                    paramName:'P_RECIBO_CAJA',
                                    paramValue:'',
                                    type:'input',
                                    required:true
                                };

                                var reporte = new FrmCriterioReporte('rptCierreCaja', '/Reports/sii/kardex', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text:'Existencias por Tipo de Especies',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnTct-Ctr-rptTipoEspeciesEnBodegasInventario2',
                            handler:function(){
                                var params = [];
                                params[0]={
                                    objectName:'FrmListadoCgg_kdx_punto_venta',//objeto con getStore and get Columnmodel
                                    label:'Punto de venta',
                                    valueField:'CKPVT_CODIGO',
                                    displayField:'CKPVT_NOMBRE',
                                    paramName:'P_CKPVT_CODIGO',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'

                                };
                                params[1]={
                                    objectName:'Cgg_kdx_usuario_pv',//objeto con getStore and get Columnmodel
                                    label:'Usuario PV',
                                    valueField:'CKUPV_CODIGO',
                                    displayField:'CRPER_NOMBRES',
                                    paramName:'P_CKUPV_CODIGO',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'

                                };
                                params[2]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[3]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                var reporte = new FrmCriterioReporte('rptTipoEspeciesEnBodegasInventario', '/Reports/sii/kardex', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text:'Reporte por Tipo de Especies',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnTct-Ctr-rptStockTipoTarjetas2',
                            handler:function(){
                                var params = [];
                                params[0]={
                                    objectName:'FrmListadoCgg_kdx_punto_venta',//objeto con getStore and get Columnmodel
                                    label:'Punto de venta',
                                    valueField:'CKPVT_CODIGO',
                                    displayField:'CKPVT_NOMBRE',
                                    paramName:'P_CKPVT_CODIGO',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'
                                };
                                params[1]={
                                    objectName:'FrmListadoCgg_kdx_especie',//objeto con getStore and get Columnmodel
                                    valueField:'CKESP_CODIGO',
                                    label:'Especie',
                                    displayField:'CKESP_NOMBRE',
                                    paramName:'P_CKESP_CODIGO',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'
                                };
                                var reporte = new FrmCriterioReporte('rptStockTipoTarjetas', '/Reports/sii/kardex', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text:'Reporte General de Ingresos o Compras',
                            iconCls:'iconReporte',
                            hidden:false,
                            id:'mnTct-Ctr-rptComprasGeneralporPeriodo',
                            handler:function(){
                                var params = [];
                                params[0]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[1]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                var reporte = new FrmCriterioReporte('rptComprasGeneralporPeriodo', '/Reports/sii/kardex', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text:'Reporte Individual de Ingresos o Compras',
                            iconCls:'iconReporte',
                            hidden:false,
                            id:'mnTct-Ctr-rptComprasIndividualporPeriodo',
                            handler:function(){
                                var params = [];
                                params[0]={
                                    objectName:'FrmListadoCgg_kdx_compra',//objeto con getStore and get Columnmodel
                                    label:'Factura Compra',
                                    valueField:'CKCMP_CODIGO',
                                    displayField:'CKCMP_FACTURA',
                                    paramName:'P_CKCMP_CODIGO',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'
                                };
                                params[1]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[2]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                var reporte = new FrmCriterioReporte('rptComprasIndividualporPeriodo', '/Reports/sii/kardex', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text:'Reporte Totalizado de Ventas',
                            iconCls:'iconReporte',
                            hidden:false,
                            id:'mnTct-Ctr-rptTotalizadoVentas',
                            handler:function(){
                                var params = [];
                                params[0]={
                                    objectName:'FrmListadoCgg_kdx_punto_venta',//objeto con getStore and get Columnmodel
                                    label:'Punto de venta',
                                    valueField:'CKPVT_CODIGO',
                                    displayField:'CKPVT_NOMBRE',
                                    paramName:'P_CKPVT_CODIGO',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'
                                };
                                params[1]={
                                    objectName:'Cgg_kdx_usuario_pv',//objeto con getStore and get Columnmodel
                                    label:'Usuario PV',
                                    valueField:'CKUPV_CODIGO',
                                    displayField:'CRPER_NOMBRES',
                                    paramName:'P_CKUPV_CODIGO',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'
                                };
                                params[2]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[3]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                var reporte = new FrmCriterioReporte('rptTotalizadoVentas', '/Reports/sii/kardex', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text:'Reporte Totalizado de Ventas por Oficina',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnTct-Ctr-rptTipoTotalizadoVentasPorOficina2',
                            handler:function(){
                                //Enlazado
                                var params = [];
                                params[0]={
                                    objectName:'FrmListadoCgg_kdx_punto_venta',//objeto con getStore and get Columnmodel
                                    label:'Punto venta',
                                    valueField:'CKPVT_CODIGO',
                                    displayField:'CKPVT_NOMBRE',
                                    paramName:'P_CKPVT_CODIGO',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'
                                };
                                params[1]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[2]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };
                                var reporte = new FrmCriterioReporte('rptTipoTotalizadoVentasPorOficina', '/Reports/sii/kardex', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text:'Reporte Totalizado de Ventas por Especie',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnTct-Ctr-rptTotalizadoVentasporTipoEspecie',
                            handler:function(){
                                //Enlazado
                                var params = [];
                                params[0]={
                                    objectName:'FrmListadoCgg_kdx_especie',//objeto con getStore and get Columnmodel
                                    valueField:'CKESP_CODIGO',
                                    label:'Especie',
                                    displayField:'CKESP_NOMBRE',
                                    paramName:'P_CKESP_CODIGO',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'
                                };
                                params[1]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[2]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };
                                var reporte = new FrmCriterioReporte('rptTotalizadoVentasporTipoEspecie', '/Reports/sii/kardex', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        }

                        ]
                    }
                },{
                    text:'Veh\u00EDculos',
                    iconCls:'iconReporte',
                    hidden:true,
                    id:'mnVeh',
                    menu:{
                        items:[{
                            text:'Control de veh\u00EDculos',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnVeh-Ctr',
                            menu:{
                                items:[{
                                    text:'Listado de solicitudes por periodo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnVeh-Ctr-rptListadoSolicitudesVehiculosporFecha',
                                    handler:function(){
                                        var params = [];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoSolicitudesVehiculosporFecha', '/Reports/sii/vehiculos', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text:'Listado de solicitudes por tipo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnVeh-Ctr-rptListadoSolicitudesVehiculosporTipo',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_res_proceso',
                                            label:'Proceso',
                                            valueField:'CRPRO_CODIGO',
                                            displayField:'CRPRO_NOMBRE',
                                            paramName:'P_CRPRO_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoSolicitudesVehiculosporTipo', '/Reports/sii/vehiculos', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado de solicitudes por Isla',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnVeh-Ctr-rptListadoSolicitudesVehiculosporIsla',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoSolicitudesVehiculosporIsla', '/Reports/sii/vehiculos', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Tramites por persona/empresa',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnVeh-Ctr-rptNumeroTramitesporPersona',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_res_persona',
                                            label:'Nombre persona',
                                            valueField:'CRPER_CODIGO',
                                            displayField:'CRPER_NOMBRES|CRPER_APELLIDO_PATERNO',
                                            paramName:'P_CRPER_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        params[1]=
                                        {
                                            objectName:'FrmListadoCgg_res_persona_juridica',
                                            label:'Empresa',
                                            valueField:'CRPJR_CODIGO',
                                            displayField:'CRPJR_RAZON_SOCIAL',
                                            paramName:'P_CRPJR_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[2]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[3]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptNumeroTramitesporPersona', '/Reports/sii/vehiculos', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                }/*,{
                                    text:'Listado de tramites con criterio',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnVeh-Ctr-rptListadoCriteriosporTramiteFase',
                                    handler:function(){
                                        //Revisado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            objectName:'FrmListadoCgg_res_tramite',
                                            label:'Tr\u00E1mite',
                                            valueField:'CRTRA_CODIGO',
                                            displayField:'CRTRA_OBSERVACION',
                                            paramName:'P_CRTRA_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };

                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_res_tipo_solicitud_tramite',
                                            label:'Tipo solicitud',
                                            valueField:'CRTST_CODIGO',
                                            displayField:'CRTST_DESCRIPCION',
                                            paramName:'P_CRTST_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        params[3]=
                                        {
                                            objectName:'FrmListadoCgg_res_fase',
                                            label:'Fase',
                                            valueField:'CRFAS_CODIGO',
                                            displayField:'CRFAS_NOMBRE',
                                            paramName:'P_CRFAS_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[4]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[5]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoCriteriosporTramiteFase', '/Reports/sii/vehiculos', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }

                                }*/,{
                                    text:'Pre aprobado y pre negado de cada proceso',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnVeh-Ctr-rptPreAprobadoyPreNegadoporProceso',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            objectName:'FrmListadoCgg_res_proceso',
                                            label:'Proceso',
                                            valueField:'CRPRO_CODIGO',
                                            displayField:'CRPRO_NOMBRE',
                                            paramName:'P_CRPRO_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_res_tipo_solicitud_tramite',
                                            label:'Tipo solicitud',
                                            valueField:'CRTST_CODIGO',
                                            displayField:'CRTST_DESCRIPCION',
                                            paramName:'P_CRTST_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[3]=
                                        {
                                            label:'Atenci\u00f3n',
                                            paramName:'P_CRSEG_ESTADO_ATENCION',
                                            value: [[-1,'INDETERMINADO'],[0,'NEGADO'],[1,'APROBADO']],
                                            paramValue:'',
                                            type:'combo'
                                        };
                                        params[4]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[5]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptPreAprobadoyPreNegadoporProceso', '/Reports/sii/vehiculos', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text:'Listado de parque automotor institucional',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnVeh-Ctr-rptListadoParqueAutomotorInstitucional',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_veh_sector',
                                            label:'Sector',
                                            valueField:'CVSCT_CODIGO',
                                            displayField:'CVSCT_NOMBRE',
                                            paramName:'P_CVSCT_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoParqueAutomotorInstitucional', '/Reports/sii/vehiculos', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Veh\u00EDculos de las instituciones del estado',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnVeh-Ctr-rptListadoVehiculosInstitucionesEstado',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoVehiculosInstitucionesEstado', '/Reports/sii/vehiculos', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Veh\u00EDculos livianos por isla/tipo/combustible',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnVeh-Ctr-rptListadoVehiculosporIslaTipoCombustible',
                                    handler:function(){
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[1]=
                                        {
                                            objectName:'FrmListadoCgg_veh_categoria',
                                            label:'Categoria',
                                            valueField:'CVCTG_CODIGO',
                                            displayField:'CVCTG_NOMBRE',
                                            paramName:'P_CVCTG_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_veh_combustible',
                                            label:'Combustible',
                                            valueField:'CVCMB_CODIGO',
                                            displayField:'CVCMB_NOMBRE',
                                            paramName:'P_CVCMB_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[3]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[4]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoVehiculosporIslaTipoCombustible', '/Reports/sii/vehiculos', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text:'Listado por sector productivo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnVeh-Ctr-rptListadoporSectorProductivoVehiculos',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_sector_productivo',
                                            label:'Sector Productivo',
                                            valueField:'CSCTP_CODIGO',
                                            displayField:'CSCTP_NOMBRE',
                                            paramName:'P_CSCTP_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoporSectorProductivoVehiculos', '/Reports/sii/vehiculos', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado de tramites para tratar en comit\u00e9',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnVeh-Ctr-rptListadoVehiculosTramitesParaComite',
                                    handler:function(){
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_res_comite',
                                            label:'Comit\u00e9',
                                            valueField:'CRCOM_CODIGO',
                                            displayField:'CRCOM_NOMBRE',
                                            paramName:'P_CRCOM_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoVehiculosTramitesParaComite', '/Reports/sii/vehiculos', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Certificado control vehicular municipio',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnVeh-Ctr-rptCertificadoRegistroVehiculos',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_veh_vehiculo',
                                            label:'Vehiculo',
                                            valueField:'CVVEH_CODIGO',
                                            displayField:'CVVEH_MODELO',
                                            paramName:'P_CVVEH_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            label:'N\u00FAmero certificado',
                                            paramName:'P_NUMERO_CERTIFICADO',
                                            paramValue:'',
                                            type:'input',
                                            required:true
                                        };                                       

                                        var reporte = new FrmCriterioReporte('rptCertificadoRegistroVehiculos', '/Reports/sii/vehiculos', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado veh\u00EDculos temporales pr\u00f3ximos a salir',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnVeh-Ctr-rptListadoVehiculosTemporalesProximosSalir',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoVehiculosTemporalesProximosSalir', '/Reports/sii/vehiculos', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                }
                                ]
                            }
                        },{
                            text:'Historial veh\u00EDculos',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnVeh-His',
                            menu:{
                                items:[
                                {
                                    text:'Listado ingreso salida por periodo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnVeh-His-rptCertificadoRegistroVehiculos1',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];

                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]=
                                        {
                                            label:'Tipo veh\u00EDculo',
                                            paramName:'P_CVVEH_TIPO',
                                            value:dsTipoVehiculo,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };

                                        params[3]=
                                        {
                                            label:'Ubicaci\u00f3n',
                                            paramName:'P_CVVEH_INGRESO',
                                            value:[['true','Dentro'],['false','Fuera'],['','Todos']],
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoIngresoSalidaVehiculosporPeriodo', '/Reports/sii/vehiculos', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text:'D\u00edas ingreso tr\u00e1mite',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnVeh-His-rptCertificadoRegistroVehiculos2',
                                    handler:function(){
                                        var params = [];

                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_res_tipo_solicitud_tramite',
                                            label:'Tipo solicitud',
                                            valueField:'CRTST_CODIGO',
                                            displayField:'CRTST_DESCRIPCION',
                                            paramName:'P_CRTST_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[3]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CISLA_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CISLA_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoTramitesRecepcionporFecha', '/Reports/sii/vehiculos', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                }]
                            }
                        }
                        ]
                    }
                },{
                    text:'TCT',
                    iconCls:'iconReporte',
                    hidden:true,
                    id:'mnTct',
                    menu:{
                        items:[{
                            text:'Tarjetas control transito',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnTct-Tar',
                            menu:{
                                items:[{
                                    text:'Tiempo de estadia de personas',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Tar-rptTiemposEstadiaporPersona',
                                    handler:function(){
                                        //Revisado y enlazado
                                        var params = [];
                                        var tmpCurrentDate = new Date();
                                        tmpCurrentDate.setDate(tmpCurrentDate.getDate()-365);
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            value: tmpCurrentDate,
                                            paramValue:tmpCurrentDate.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        params[2]={
                                            label:'Nombres',
                                            paramName:'P_CRPER_NOMBRES',
                                            paramValue:'',
                                            value:'',
                                            type:'input'
                                        };
                                        params[3]={
                                            label:'Apellidos',
                                            paramName:'P_CRPER_APELLIDOS',
                                            paramValue:'',
                                            value:'',
                                            type:'input'
                                        };
                                        params[4]={
                                            label:'Identificaci\u00f3n',
                                            paramName:'P_CRPER_NUM_DOC_IDENTIFIC',
                                            paramValue:'',
                                            value:'',
                                            type:'input'
                                        };
                                        var reporte = new FrmCriterioReporte('rptTiemposEstadiaporPersona', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Registro TCT de agencia de viaje por grupo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Tar-rptRegistroTCTparaAgenciaViajes',
                                    handler:function(){
                                        //Enlazado.
                                        var params=[];
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_tct_grupo_turista',
                                            label:'Grupo turista',
                                            valueField:'CTGTR_CODIGO',
                                            displayField:'CTGTR_NUMERO',
                                            paramName:'P_CTGTR_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptRegistroTCTparaAgenciaViajes', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text:'Personas no autorizadas ingreso a galapagos',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Tar-rptListadoPersonasNoAutorizadoIngresoGPS',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]={
                                            objectName:'FrmListadoCgg_canton',
                                            label:'Cant\u00f3n',
                                            valueField:'CCTN_CODIGO',
                                            displayField:'CCTN_NOMBRE',
                                            paramName:'P_CCTN_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoPersonasNoAutorizadoIngresoGPS', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Total de turista y transeunte por estado',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Tar-rptTotalesTuristasTranseuntes',
                                    handler:function(){
                                        //Revisado y enlazado
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]={
                                            objectName:'FrmListadoCgg_kdx_punto_venta',
                                            label:'Punto venta',
                                            valueField:'CKPVT_CODIGO',
                                            displayField:'CKPVT_NOMBRE',
                                            paramName:'P_CKPVT_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptTotalesTuristasTranseuntes', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text:'Listado de tct impresas por usuario',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Tar-rptImpresionesTCTporUsuario',
                                    handler:function(){
                                        //Revisado
                                        var params = [];

                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_kdx_especie',
                                            label:'Tipo especie',
                                            valueField:'CKESP_CODIGO',
                                            displayField:'CKESP_NOMBRE',
                                            paramName:'P_CKESP_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        params[3]=
                                        {
                                            objectName:'FrmListadoCgg_usuario',
                                            label:'Usuario',
                                            valueField:'CUSU_CODIGO',
                                            displayField:'CUSU_NOMBRE_USUARIO',
                                            paramName:'P_CUSU_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptImpresionesTCTporUsuario', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Turista Transeunte por lugar emisi\u00f3n',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Tar-rptTuristaTranseunteporLugarEmision',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]={
                                            objectName:'FrmListadoCgg_kdx_punto_venta',
                                            label:'Punto venta',
                                            valueField:'CKPVT_CODIGO',
                                            displayField:'CKPVT_NOMBRE',
                                            paramName:'P_CKPVT_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        params[1]={
                                            objectName:'FrmListadoCgg_res_aerolinea',
                                            label:'Aerolinea',
                                            valueField:'CRALN_CODIGO',
                                            displayField:'CRALN_NOMBRE',
                                            paramName:'P_CRALN_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        params[2]={
                                            objectName:'FrmListadoCgg_usuario',
                                            label:'Usuario',
                                            valueField:'CUSU_CODIGO',
                                            displayField:'CUSU_NOMBRE_USUARIO',
                                            paramName:'P_CUSU_CODIGO',
                                            paramValue:'',
                                            type:'searchable'

                                        };
                                        params[3]=
                                        {
                                            objectName:'FrmListadoCgg_res_tipo_solicitud_tramite',
                                            label:'Tipo solicitud',
                                            valueField:'CRTST_CODIGO',
                                            displayField:'CRTST_DESCRIPCION',
                                            paramName:'P_CRTST_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[4]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[5]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        var reporte = new FrmCriterioReporte('rptTuristaTranseunteporLugarEmision', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text:'Consulta de residente por c\u00e9dula',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Tar-rptConsultaResidenteNumeroCedula',
                                    handler:function(){
                                        //Enlazado
                                        var params=[];
                                        params[0]=
                                        {
                                            label:'Nombres',
                                            paramName:'P_NOMBRES',
                                            paramValue:'',
                                            type:'input'
                                        };
                                        params[1]=
                                        {
                                            label:'Apellidos',
                                            paramName:'P_APELLIDOS',
                                            paramValue:'',
                                            type:'input'
                                        };
                                        params[2]=
                                        {
                                            label:'N. Documento',
                                            paramName:'P_CRPER_NUM_DOC_IDENTIFIC',
                                            paramValue:'',
                                            type:'input'
                                        };
                                        var reporte = new FrmCriterioReporte('rptConsultaResidenteNumeroCedula', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Estad\u00EDstico de notificados que trataron de ingresar',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Tar-rptNotificadosTrataronIngresar',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        var reporte = new FrmCriterioReporte('rptNotificadosTrataronIngresar', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Estad\u00EDstico por tiempo de estad\u00EDa acumulado',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Tar-rptEstadisticoEstadiaAcumuladaporCategoria',
                                    handler:function(){
                                        //Enlazado
                                        var params=[];

                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[2]=
                                        {
                                            label:'N. Documento',
                                            paramName:'P_CRPER_NUM_DOC_IDENTIFIC',
                                            paramValue:'',
                                            type:'input',
                                            required:true
                                        };

                                        var reporte = new FrmCriterioReporte('rptEstadisticoEstadiaAcumuladaporCategoria', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Listado turista/transeunte pr\u00f3ximos a salir',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Tar-rptEstadiaTuristasTranseuntesProximosSalida',
                                    handler:function(){
                                        //Enlazado
                                        var params=[];
                                        params[0]=
                                        {
                                            label:'N. documento',
                                            paramName:'P_CRPER_NUM_DOC_IDENTIFIC',
                                            paramValue:'',
                                            type:'input'
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha m\u00E1xima',
                                            paramName:'P_FECHA_CORTE',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptEstadiaTuristasTranseuntesProximosSalida', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Cantidades de formularios y especies emitidas',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Tar-rptCantidadFormularioEspeciesEmitidas',
                                    handler:function(){
                                        //Enlazado
                                        var params=[];
                                        //aaaaaa
                                        params[0]={
                                            objectName:'FrmListadoCgg_kdx_punto_venta',//objeto con getStore and get Columnmodel
                                            label:'Lugar de emisi\u00f3n',
                                            valueField:'CKPVT_CODIGO',
                                            displayField:'CKPVT_NOMBRE',
                                            paramName:'P_CKPVT_CODIGO',//nombre parametro
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[1]=
                                        {
                                            objectName:'FrmListadoCgg_res_aerolinea',
                                            label:'Aerol\u00ednea',
                                            valueField:'CRALN_CODIGO',
                                            displayField:'CRALN_NOMBRE',
                                            paramName:'P_CRALN_CODIGO',
                                            paramValue:'',
                                            type:'searchable'											
                                        };										
                                        params[2]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };											
                                        params[3]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[4]=
                                        {
                                            objectName:'FrmListadoCgg_kdx_especie',//objeto con getStore and get Columnmodel
                                            valueField:'CKESP_CODIGO',
                                            label:'Especie',
                                            displayField:'CKESP_NOMBRE',
                                            paramName:'P_CKESP_CODIGO',//nombre parametro
                                            paramValue:'',
                                            type:'searchable'
                                        };										
                                        params[5]=
                                        {
                                            label:'Categoria',
                                            paramName:'P_CATEGORIA',
                                            value:dsCategoriasTCT,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };
                                        params[6]=
                                        {
                                            label:'Tipo Nacionalidad',
                                            paramName:'P_TIPO_NACIONALIDAD',
                                            value: dsTipoNacionalidad,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };
                                        params[7]=
                                        {
                                            label:'Tipo de Ingreso',
                                            paramName:'P_TIPO_INGRESO',
                                            value: dsTipoIngreso,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };										
                                        params[8]=
                                        {
                                            objectName:'FrmListadoCgg_usuario',
                                            label:'Usuario',
                                            valueField:'CUSU_CODIGO',
                                            displayField:'CUSU_NOMBRE_USUARIO',
                                            paramName:'P_CUSU_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        var reporte = new FrmCriterioReporte('rptCantidadFormularioEspeciesEmitidas', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text: 'Cantidades de formularios y especies emitidas por turista',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Tar-rptCantidadFormularioEspeciesEmitidasporTurista',
                                    handler:function(){
                                        //Enlazado
                                        var params=[];
                                        params[0]=
                                        {
                                            label:'Nombres',
                                            paramName:'P_CRPER_NOMBRES',
                                            paramValue:'',
                                            type:'input'
                                        };
                                        params[1]=
                                        {
                                            label:'Apellidos',
                                            paramName:'P_CRPER_APELLIDOS',
                                            paramValue:'',
                                            type:'input'
                                        };
                                        params[2]=
                                        {
                                            label:'N. Documento',
                                            paramName:'P_CRPER_NUM_DOC_IDENTIFIC',
                                            paramValue:'',
                                            type:'input'											
                                        };										
										
                                        params[3]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };											
                                        params[4]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[5]=
                                        {
                                            objectName:'FrmListadoCgg_kdx_especie',//objeto con getStore and get Columnmodel
                                            valueField:'CKESP_CODIGO',
                                            label:'Especie',
                                            displayField:'CKESP_NOMBRE',
                                            paramName:'P_CKESP_CODIGO',//nombre parametro
                                            paramValue:'',
                                            type:'searchable'
                                        };																											
                                        var reporte = new FrmCriterioReporte('rptCantidadFormularioEspeciesEmitidasporTurista', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                }
								
                                ]
                            }
                        },{
                            text:'Ingreso/salida turista/transeunte',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnTct-Ing',
                            menu:{
                                items:[
                                {
                                    text:'Listado de turistas y transeuntes',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Ing-rptListadodeTuristasTranseuntesNacionalesExtranjeros',
                                    handler:function(){
                                        var params = [];
                    
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        /*params[2]={
                        objectName:'FrmListadoCgg_res_tipo_solicitud_tramite',
                        label:'Tipo solicitud',
                        valueField:'CRTST_CODIGO',
                        displayField:'CRTST_DESCRIPCION',
                        paramName:'P_CRTST_CODIGO',
                        value:'',
						paramValue:'',
                        required:false,
                        type:'searchable'
                    };*/

                                        params[2]=
                                        {
                                            label:'Tipo residencia',
                                            paramName:'P_CRTST_CODIGO',
                                            value: dsTipoSolicitudPadreTuristaTranseunteTodos,
                                            paramValue:'',
                                            type:'combo',
                                            required:false
                                        };
                                        
                                        params[3]={
                                            label:'Operaci\u00f3n',
                                            paramName:'P_CRMOV_TIPO_OPERACION',
                                            value:dsTipoOperacion,
                                            paramValue:'',
                                            type:'combo',
                                            required:false
                                        };
                                        params[4]={
                                            objectName:'FrmListadoCgg_res_aeropuerto',
                                            label:'Aeropuerto',
                                            valueField:'CARPT_CODIGO',
                                            displayField:'CARPT_NOMBRE',
                                            paramName:'P_CARPT_CODIGO',
                                            value:'',
                                            paramValue:'',
                                            required:false,
                                            type:'searchable'
                                        };
                                        params[5] = {
                                            type:'input',
                                            label:'Vuelo',
                                            value:'',
                                            paramValue:'',
                                            required:false,
                                            paramName:'P_CRMOV_NUMERO_VUELO'
                                        };
                                        params[6]=
                                        {
                                            objectName:'FrmListadoCgg_usuario',
                                            label:'Usuario',
                                            valueField:'CUSU_CODIGO',
                                            displayField:'CUSU_NOMBRE_USUARIO',
                                            paramName:'P_CUSU_CODIGO',
                                            paramValue:'',
                                            value:'',                
                                            required:false,
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadodeTuristasTranseuntesNacionalesExtranjeros', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                }
                                ,                                    
                                {
                                    text:'Totales turista/transe\u00FAnte por usuario',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Ing-rptTotalesTuristasTranseuntesNacionalesExtranjeros',
                                    handler:function(){
                                        //revisado
                                        var params=[];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_usuario',
                                            label:'Usuario',
                                            valueField:'CUSU_CODIGO',
                                            displayField:'CUSU_NOMBRE_USUARIO',
                                            paramName:'P_CUSU_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };

                                        var reporte = new FrmCriterioReporte('rptTotalesTuristasTranseuntesNacionalesExtranjeros','/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Totales temporales/permanentes por usuario',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Ing-rptTotalesTemporalesPermanentesNacionalesExtranjeros',
                                    handler:function(){
                                        //revisado
                                        var params=[];
                                        params[0]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_usuario',
                                            label:'Usuario',
                                            valueField:'CUSU_CODIGO',
                                            displayField:'CUSU_NOMBRE_USUARIO',
                                            paramName:'P_CUSU_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };

                                        var reporte = new FrmCriterioReporte('rptTotalesTemporalesPermanentesNacionalesExtranjeros','/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Totales personas por aeropuerto y aerol\u00EDnea',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Ing-rptTotalTuristaTranseunteporPeriodoAeropuertoAerolinea',
                                    handler:function(){
                                        //revisado
                                        var params=[];											
                                        params[0]={
                                            label:'Tipo Operaci\u00f3n',
                                            paramName:'P_CRMOV_TIPO_OPERACION',
                                            value:dsTipoOperacion,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };
                                        params[1]=
                                        {
                                            objectName:'FrmListadoCgg_res_aeropuerto',
                                            label:'Aeropuerto',
                                            valueField:'CARPT_CODIGO',
                                            displayField:'CARPT_NOMBRE',
                                            paramName:'P_CARPT_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_res_aerolinea',
                                            label:'Aerolinea',
                                            valueField:'CRALN_CODIGO',
                                            displayField:'CRALN_NOMBRE',
                                            paramName:'P_CRALN_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[3]=
                                        {
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        params[4]=
                                        {
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        var reporte = new FrmCriterioReporte('rptTotalTuristaTranseunteporPeriodoAeropuertoAerolinea','/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{ 
                                    text:'Listado turistas/transe\u00FAnte ingreso/salida por periodo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Ing-rptListadoTuristasTranseuntesIngresosSalidasporPeriodo',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
											
                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CCTN_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CCTN_CODIGO',
                                            paramValue:'',
                                            type:'searchable'                                                
                                        };
											
                                        params[1]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoTuristasTranseuntesIngresosSalidasporPeriodo', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado de ingreso/salida por persona',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Ing-rptListadoTuristasTranseuntesIngresosSalidasporPersona',
                                    handler:function(){
                                        //Enlazado
                                        var params=[];
                                        params[0]=
                                        {
                                            label:'Nombres',
                                            paramName:'P_NOMBRES',
                                            paramValue:'',
                                            type:'input'
                                        };
                                        params[1]=
                                        {
                                            label:'Apellidos',
                                            paramName:'P_APELLIDOS',
                                            paramValue:'',
                                            type:'input'
                                        };
                                        params[2]=
                                        {
                                            label:'N. Documento',
                                            paramName:'P_CRPER_NUM_DOC_IDENTIFIC',
                                            paramValue:'',
                                            type:'input'
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoTuristasTranseuntesIngresosSalidasporPersona', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado de ingreso/salida por aerol\u00EDnea',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Ing-rptListadodeIngresoSalidasporAerolinea',
                                    handler:function(){
                                        //Enlazado
                                        var params=[];

                                        params[0]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CCTN_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CCTN_CODIGO',
                                            paramValue:'',
                                            type:'searchable'                                                
                                        };
											
                                        params[1]=
                                        {
                                            objectName:'FrmListadoCgg_res_aerolinea',
                                            label:'Aerolinea',
                                            valueField:'CRALN_CODIGO',
                                            displayField:'CRALN_NOMBRE',
                                            paramName:'P_CRALN_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
											
                                        params[2]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[3]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadodeIngresoSalidasporAerolinea', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Informe de totales de turistas por periodo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Ing-rptTotaledeTuristasMensualporTipo',
                                    handler:function(){
                                        //Enlazado
                                        var params=[];
                                            
                                        params[0]={
                                            label:'Tipo Operaci\u00f3n',
                                            paramName:'P_CRMOV_TIPO_OPERACION',
                                            value:dsRptTipoOperacion,
                                            paramValue:'',
                                            type:'combo',
                                            required:true
                                        };	

                                        params[1]=
                                        {
                                            objectName:'FrmListadoCgg_isla',
                                            label:'Isla',
                                            valueField:'CCTN_CODIGO',
                                            displayField:'CISLA_NOMBRE',
                                            paramName:'P_CCTN_CODIGO',
                                            paramValue:'',
                                            type:'searchable'                                                
                                        };											
											
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_res_aerolinea',
                                            label:'Aerolinea',
                                            valueField:'CRALN_CODIGO',
                                            displayField:'CRALN_NOMBRE',
                                            paramName:'P_CRALN_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
										
                                        params[3]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        params[4]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date',
                                            required:true
                                        };

                                        var reporte = new FrmCriterioReporte('rptTotaledeTuristasMensualporTipo', '/Reports/sii/tct', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                }
                                ]
                            }
                        },{
                            text:'Control Especies',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnTct-Ctr',
                            menu:{
                                items:[
                                {
                                    text:'Reporte totalizado por oficina',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Ctr-rptTipoTotalizadoVentasPorOficina',
                                    handler:function(){
                                        //Enlazado
                                        var params = [];
                                        params[0]={
                                            objectName:'FrmListadoCgg_kdx_punto_venta',//objeto con getStore and get Columnmodel
                                            label:'Punto venta',
                                            valueField:'CKPVT_CODIGO',
                                            displayField:'CKPVT_NOMBRE',
                                            paramName:'P_CKPVT_CODIGO',//nombre parametro
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[1]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        var reporte = new FrmCriterioReporte('rptTipoTotalizadoVentasPorOficina', '/Reports/sii/kardex', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Reporte totalizado por oficina_especies',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Ctr-rptTipoEspeciesEnBodegasInventario',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            objectName:'FrmListadoCgg_kdx_punto_venta',//objeto con getStore and get Columnmodel
                                            label:'Punto de venta',
                                            valueField:'CKPVT_CODIGO',
                                            displayField:'CKPVT_NOMBRE',
                                            paramName:'P_CKPVT_CODIGO',//nombre parametro
                                            paramValue:'',
                                            type:'searchable'

                                        };
                                        params[1]={
                                            objectName:'Cgg_kdx_usuario_pv',//objeto con getStore and get Columnmodel
                                            label:'Usuario PV',
                                            valueField:'CKUPV_CODIGO',
                                            displayField:'CRPER_NOMBRES',
                                            paramName:'P_CKUPV_CODIGO',//nombre parametro
                                            paramValue:'',
                                            type:'searchable'

                                        };
                                        params[2]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[3]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        var reporte = new FrmCriterioReporte('rptTipoEspeciesEnBodegasInventario', '/Reports/sii/kardex', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text:'Reporte por tipo de tarjetas',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnTct-Ctr-rptStockTipoTarjetas',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            objectName:'FrmListadoCgg_kdx_punto_venta',//objeto con getStore and get Columnmodel
                                            label:'Punto de venta',
                                            valueField:'CKPVT_CODIGO',
                                            displayField:'CKPVT_NOMBRE',
                                            paramName:'P_CKPVT_CODIGO',//nombre parametro
                                            paramValue:'',
                                            type:'searchable'

                                        };
                                        params[1]={
                                            objectName:'FrmListadoCgg_kdx_especie',//objeto con getStore and get Columnmodel
                                            valueField:'CKESP_CODIGO',
                                            label:'Especie',
                                            displayField:'CKESP_NOMBRE',
                                            paramName:'P_CKESP_CODIGO',//nombre parametro
                                            paramValue:'',
                                            type:'searchable'

                                        };
                                        var reporte = new FrmCriterioReporte('rptStockTipoTarjetas', '/Reports/sii/kardex', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                }
                                ]
                            }
                        }
                        ]
                    }
                },{
                    text:'Comit\u00e9',
                    iconCls:'iconReporte',
                    hidden:true,
                    id:'mnCom',
                    scope:this,
                    menu:{
                        items:[
                        {
                            text: 'Solicitudes de residencia tratadas',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnCom-rptListadoSolicitudesResidenciaTratadasSesionComite',
                            handler:function(){
                                var params = [];
                                params[0]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };
                                params[1]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };
                                var reporte = new FrmCriterioReporte('rptListadoSolicitudesResidenciaTratadasSesionComite', '/Reports/sii/comite', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text: 'Resoluciones tratadas',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnCom-rptListadoResolucionesComite',
                            handler:function(){
                                var params = [];
                                params[0]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };
                                params[1]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };
                                var reporte = new FrmCriterioReporte('rptListadoResolucionesComite', '/Reports/sii/comite', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text: 'Listado de tramites de comite',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnCom-rptListadoTramitesSesionComite',
                            handler:function(){
                                var params = [];
                                params[0]={
		                                objectName:'FrmListadoCgg_res_sesion_comite',
		                                label:'Sesi\u00f3n',
		                                valueField:'CRSSC_CODIGO',
		                                displayField:'CRSSC_NUMERO_SESION',
		                                paramName:'P_CRSSC_CODIGO',
		                                paramValue:'',
		                                type:'searchable'
		                            };
                                params[1]={
                                    objectName:'FrmListadoCgg_isla',
                                    label:'Isla',
                                    valueField:'CISLA_CODIGO',
                                    displayField:'CISLA_NOMBRE',
                                    paramName:'P_CISLA_CODIGO',
                                    paramValue:'',
                                    type:'searchable',
                                    required:true
                                };
                                 params[2]={
                                    label:'Tipo',
                                    paramName:'P_TIPO_TRAMITE',
                                    value:[[0,"Resoluciones"],[1,"Tramites"]],
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };
                                var reporte = new FrmCriterioReporte('rptListadoResolucionesComite', '/Reports/sii/comite', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        }
                        ]
                    }
                },{
                    text:'Gestion de empleo',
                    iconCls:'iconReporte',
                    hidden:true,
                    id:'mnGem',
                    scope:this,
                    menu:{
                        items:[ {
                            text: 'Estad\u00EDstico de empleos ofertados por criterio',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnGem-rptEstadisticoNumeroEmpleosOfertadosGeneral',
                            handler:function(){
                                //Enlazado
                                var params = [];
                                params[0]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[1]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[2]={
                                    label:'Peri\u00F3do',
                                    paramName:'P_TIPO_FECHA',
                                    value:dsTipoPeriodoGem,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };

                                params[3]={
                                    label:'Agrupado por',
                                    paramName:' P_TIPO_BUSQUEDA',
                                    value:dsFiltroGem,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };

                                var reporte = new FrmCriterioReporte('rptEstadisticoNumeroEmpleosOfertadosGeneral', '/Reports/sii/gem', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text: 'Estad\u00EDstico de comunicado, aplicado y contratado por isla',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnGem-rptEstadisticoComunicadoAplicadoContratado',
                            handler:function(){
                                //Enlazado
                                var params = [];
                                params[0]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[1]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };
								
                                params[2]={
                                    label:'Peri\u00F3do',
                                    paramName:'P_TIPO_FECHA',
                                    value:dsTipoPeriodoGem,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };

                                params[3]={
                                    label:'Agrupado por',
                                    paramName:' P_TIPO_OFERTA',
                                    value:dsFiltroGem,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };

                                var reporte = new FrmCriterioReporte('rptEstadisticoAplicadoContratadoGeneral', '/Reports/sii/gem', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text: 'Estad\u00EDstico de selecciones de candidatos por criterio',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnGem-rptEstadisticoAplicacionesUbicacionesGeneral',
                            handler:function(){
                                //Enlazado
                                var params = [];
                                params[0]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[1]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[2]={
                                    label:'Peri\u00F3do',
                                    paramName:'P_TIPO_FECHA',
                                    value:dsTipoPeriodoGem,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };

                                params[3]={
                                    label:'Agrupado por',
                                    paramName:' P_TIPO_BUSQUEDA',
                                    value:dsFiltroGem,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };

                                params[4]={
                                    label:'Candidatos',
                                    paramName:' P_TIPO_OFERTA',
                                    value:dsCandidatosGem,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };

                                var reporte = new FrmCriterioReporte('rptEstadisticoAplicacionesUbicacionesGeneral', '/Reports/sii/gem', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text: 'Estad\u00EDstico por nivel academico',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnGem-rptEstadisticoNivelProfesionalOfertaSectorIsla',
                            handler:function(){
                                var params = [];

                                params[0]=
                                {
                                    objectName:'FrmListadoCgg_nivel_estudio',
                                    label:'Nivel estudio',
                                    valueField:'CGNES_CODIGO',
                                    displayField:'CGNES_DESCRIPCION',
                                    paramName:'P_CGNES_CODIGO',
                                    paramValue:'',
                                    type:'searchable',
                                    required:true
                                };
                                
                                params[1]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[2]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };      
                                params[3]={
                                    label:'Peri\u00F3do',
                                    paramName:'P_TIPO_FECHA',
                                    value:dsTipoPeriodoGem,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };

                                params[4]={
                                    label:'Agrupado por',
                                    paramName:' P_TIPO_BUSQUEDA',
                                    value:dsFiltroGem,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };								
								

                                var reporte = new FrmCriterioReporte('rptEstadisticoNivelProfesionalOfertaGeneral', '/Reports/sii/gem', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text:'Listado de numero de ubicaciones empresa',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnGem-rptListadoUbicacionesEmpresaIsla',
                            handler:function(){
                                //Enlazado
                                var params = [];
                                params[0]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[1]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };      
                                params[2]={
                                    label:'Peri\u00F3do',
                                    paramName:'P_TIPO_FECHA',
                                    value:dsTipoPeriodoGem,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };

                                params[3]={
                                    label:'Agrupado por',
                                    paramName:' P_TIPO_BUSQUEDA',
                                    value:dsFiltroGem,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };			
                                var reporte = new FrmCriterioReporte('rptEstadisticoUbicacionesEmpresaGeneral', '/Reports/sii/gem', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text:'Ofertas para la Radio',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnGem-rptOfertaRadio',
                            handler:function(){
                                //Enlazado
                                var params = [];
                                params[0]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[1]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };
                                var reporte = new FrmCriterioReporte('rptOfertaRadio', '/Reports/sii/gem', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        }
                        ]
                    }
                },{
                    text:'Desarrollo humano',
                    iconCls:'iconReporte',
                    hidden:true,
                    id:'mnDhu',
                    menu:{
                        items:[
                        {
                            text:'Beneficiario de becas ',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnDhu-Bec',
                            menu:{
                                items:[
                                {
                                    text:'Listado de becarios por programa',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Bec-rptListadoNumerobecarios',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_dhu_tipo_beca',
                                            label:'Programa',
                                            valueField:'CDTBC_CODIGO',
                                            displayField:'CDTBC_NOMBRE',
                                            paramName:'P_CDTBC_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoNumerobecarios', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado de beca por espeialidades',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Bec-rptListadoBeneficiariosbecaporEspecialidad',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_especialidad',
                                            label:'Especialidad',
                                            valueField:'CGESP_CODIGO',
                                            displayField:'CGESP_NOMBRE',
                                            paramName:'P_CGESP_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoBeneficiariosbecaporEspecialidad', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text:'Listado de becas por titulo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Bec-rptListadoBeneficiariosporTitulo',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_titulo_profesional',
                                            label:'Titulo',
                                            valueField:'CGTPR_CODIGO',
                                            displayField:'CGTPR_DESCRIPCION',
                                            paramName:'P_CGTPR_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoBeneficiariosporTitulo', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado Fechas de graduaci\u00f3n',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Bec-rptListadoBeneficiariosporTitulo',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoBeneficiariosporTitulo', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text:'Listado seguimiento acad\u00e9mico',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Bec-rptListadoSeguimientoAcademico',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_res_persona',
                                            label:'Num Documento',
                                            valueField:'CRPER_CODIGO',
                                            displayField:'CRPER_NUM_DOC_IDENTIFIC',
                                            paramName:'P_CRPER_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoSeguimientoAcademico', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado seguimiento econ\u00f3mico del becario',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Bec-rptListadoSeguimientoEconomico',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_res_persona',
                                            label:'N. Documento',
                                            valueField:'CRPER_CODIGO',
                                            displayField:'CRPER_NUM_DOC_IDENTIFIC',
                                            paramName:'P_CRPER_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        var reporte = new FrmCriterioReporte('rptListadoSeguimientoEconomico', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado seguimiento econ\u00f3mico semestral',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Bec-rptSeguimientoEconomicoSemestral',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_dhu_tipo_beca',
                                            label:'Programa',
                                            valueField:'CDTBC_CODIGO',
                                            displayField:'CDTBC_NOMBRE',
                                            paramName:'P_CDTBC_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[3]=
                                        {
                                            label:'Ciclo',
                                            paramName:'P_CDACD_NUMERO_CICLO',
                                            paramValue:'',
                                            type:'number',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptSeguimientoEconomicoSemestral', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado seguimiento profesional del becario',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Bec-rptSeguimientoProfesional',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_res_persona',
                                            label:'N. Documento',
                                            valueField:'CRPER_CODIGO',
                                            displayField:'CRPER_NUM_DOC_IDENTIFIC',
                                            paramName:'P_CRPER_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        var reporte = new FrmCriterioReporte('rptSeguimientoProfesional', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                }
                                ]
                            }
                        },{
                            text:'Beneficiarios de cursos',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnDhu-Cur',
                            menu:{
                                items:[
                                {
                                    text:'Certificado de aprobaci\u00f3n de curso',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Cur-rptListadoAsistenteCurso',
                                    handler:function(){
                                        var params = [];

                                        params[1]=
                                        {
                                            label:'Num. documento o carnet',
                                            paramName:'P_CRPER_NUM_DOC_IDENTIFIC',
                                            paramValue:'',
                                            type:'input',
                                            required:true
                                        };

                                        params[2]={
                                            objectName:'FrmListadoCgg_dhu_curso',
                                            label:'Curso',
                                            valueField:'CDCUR_CODIGO',
                                            displayField:'CDCUR_DESCRIPCION',
                                            paramName:'P_CDCUR_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoAsistenteCurso', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },
                                {
                                    text:'Listado n\u00FAmero de personas asistentes',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Cur-rptListadoAsistenteCurso',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]={
                                            objectName:'FrmListadoCgg_dhu_tipo_curso',
                                            label:'Tipo curso',
                                            valueField:'CDTCR_CODIGO',
                                            displayField:'CDTCR_NOMBRE',
                                            paramName:'P_CDTCR_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoAsistenteCurso', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado tipos de residencia',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Cur-rptListadoAsistenteCursoTipoResidencia',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]={
                                            objectName:'FrmListadoCgg_dhu_tipo_curso',
                                            label:'Tipo curso',
                                            valueField:'CDTCR_CODIGO',
                                            displayField:'CDTCR_NOMBRE',
                                            paramName:'P_CDTCR_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoAsistenteCursoTipoResidencia', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text:'Listado especialidades',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Cur-rptListadoAsistenteCursoEspecialidad',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]={
                                            objectName:'FrmListadoCgg_dhu_tipo_curso',
                                            label:'Tipo curso',
                                            valueField:'CDTCR_CODIGO',
                                            displayField:'CDTCR_NOMBRE',
                                            paramName:'P_CDTCR_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoAsistenteCursoEspecialidad', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();

                                    }
                                },{
                                    text:'Listado lugar del curso',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Cur-rptListadoAsistenteCursoCanton',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]={
                                            objectName:'FrmListadoCgg_dhu_tipo_curso',
                                            label:'Tipo curso',
                                            valueField:'CDTCR_CODIGO',
                                            displayField:'CDTCR_NOMBRE',
                                            paramName:'P_CDTCR_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };
                                        params[3]=
                                        {
                                            objectName:'FrmListadoCgg_canton',
                                            label:'Cant\u00f3n',
                                            valueField:'CCTN_CODIGO',
                                            displayField:'CCTN_NOMBRE',
                                            paramName:'P_CCTN_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoAsistenteCursoCanton', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado sectores beneficiados',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Cur-rptListadoAsistenteCursoSecotres',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]={
                                            objectName:'FrmListadoCgg_dhu_tipo_curso',
                                            label:'Tipo curso',
                                            valueField:'CDTCR_CODIGO',
                                            displayField:'CDTCR_NOMBRE',
                                            paramName:'P_CDTCR_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoAsistenteCursoSecotres', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado actividades de empleo',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Cur-rptListadoAsistenteCursoActividadEmpleo',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]={
                                            objectName:'FrmListadoCgg_dhu_tipo_curso',
                                            label:'Tipo curso',
                                            valueField:'CDTCR_CODIGO',
                                            displayField:'CDTCR_NOMBRE',
                                            paramName:'P_CDTCR_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoAsistenteCursoActividadEmpleo', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado nivel de educaci\u00f3n',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Cur-rptListadoAsistenteCursoNivelEstudio',
                                    handler:function(){
                                        var params = [];

                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]={
                                            objectName:'FrmListadoCgg_dhu_tipo_curso',
                                            label:'Tipo curso',
                                            valueField:'CDTCR_CODIGO',
                                            displayField:'CDTCR_NOMBRE',
                                            paramName:'P_CDTCR_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoAsistenteCursoNivelEstudio', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado de asistentes por edades',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Cur-rptListadoAsistentesEdades',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]={
                                            objectName:'FrmListadoCgg_dhu_tipo_curso',
                                            label:'Tipo curso',
                                            valueField:'CDTCR_CODIGO',
                                            displayField:'CDTCR_NOMBRE',
                                            paramName:'P_CDTCR_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoAsistentesEdades', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado de asistentes por procedencia',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Cur-rptListadoAsistentesCursoProcedencia',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        params[2]={
                                            objectName:'FrmListadoCgg_canton',//objeto con getStore and get Columnmodel
                                            label:'Cant\u00f3n',
                                            valueField:'CCTN_CODIGO',
                                            displayField:'CCTN_NOMBRE',
                                            paramName:'P_CCTN_CODIGO',//nombre parametro
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        params[3]={
                                            objectName:'FrmListadoCgg_dhu_tipo_curso',
                                            label:'Tipo curso',
                                            valueField:'CDTCR_CODIGO',
                                            displayField:'CDTCR_NOMBRE',
                                            paramName:'P_CDTCR_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoAsistentesCursoProcedencia', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Listado de asistentes con auspiciante',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Cur-rptAsistenteCursoAuspiciantes',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]={
                                            objectName:'FrmListadoCgg_dhu_tipo_curso',
                                            label:'Tipo curso',
                                            valueField:'CDTCR_CODIGO',
                                            displayField:'CDTCR_NOMBRE',
                                            paramName:'P_CDTCR_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptAsistenteCursoAuspiciantes', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Reporte asistentes Aprobados/Reprobados',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Cur-rptListadoAsistenteCursoApro_Repro',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]={
                                            objectName:'FrmListadoCgg_dhu_tipo_curso',
                                            label:'Tipo curso',
                                            valueField:'CDTCR_CODIGO',
                                            displayField:'CDTCR_NOMBRE',
                                            paramName:'P_CDTCR_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };
                                        params[3]={
                                            objectName:'FrmListadoCgg_dhu_curso',
                                            label:'Curso',
                                            valueField:'CDCUR_CODIGO',
                                            displayField:'CDCUR_DESCRIPCION',
                                            paramName:'P_CDCUR_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptListadoAsistenteCursoApro_Repro', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                }
                                ]
                            }
                        },{
                            text:'Inversi\u00f3n CGG por curso capacitaci\u00f3n,formaci\u00f3n',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnDhu-rptListadoInversionporCurso',
                            handler:function(){
                                var params = [];
                                params[0]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[1]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[2]={
                                    objectName:'FrmListadoCgg_dhu_tipo_curso',
                                    label:'Tipo curso',
                                    valueField:'CDTCR_CODIGO',
                                    displayField:'CDTCR_NOMBRE',
                                    paramName:'P_CDTCR_CODIGO',
                                    paramValue:'',
                                    type:'searchable'
                                };

                                var reporte = new FrmCriterioReporte('rptListadoInversionporCurso', '/Reports/sii/dhu', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text:'Listado de certificados emitidos',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnDhu-rptListadoCertificadoEmitido',
                            handler:function(){
                                var params = [];
                                params[0]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[1]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };
                                var reporte = new FrmCriterioReporte('rptListadoCertificadoEmitido', '/Reports/sii/dhu', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text:'Cronograma cursos de inducci\u00f3n de residentes',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnDhu-rptCronogramaCursoporPeriodo',
                            handler:function(){
                                var params = [];
                                params[0]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[1]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };
                                params[2]={
                                    objectName:'FrmListadoCgg_canton',//objeto con getStore and get Columnmodel
                                    label:'Cant\u00f3n',
                                    valueField:'CCTN_CODIGO',
                                    displayField:'CCTN_NOMBRE',
                                    paramName:'P_CCTN_CODIGO',//nombre parametro
                                    paramValue:'',
                                    type:'searchable'
                                };

                                params[3]={
                                    objectName:'FrmListadoCgg_dhu_tipo_curso',
                                    label:'Tipo curso',
                                    valueField:'CDTCR_CODIGO',
                                    displayField:'CDTCR_NOMBRE',
                                    paramName:'P_CDTCR_CODIGO',
                                    paramValue:'',
                                    type:'searchable'
                                };
                                var reporte = new FrmCriterioReporte('rptCronogramaCursoporPeriodo', '/Reports/sii/dhu', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text:'Listado pre-inscritos a cursos de residentes',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnDhu-rptListadoPre_inscrito_periodo',
                            handler:function(){
                                var params = [];
                                params[0]={
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[1]={
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[2]={
                                    objectName:'FrmListadoCgg_dhu_tipo_curso',
                                    label:'Tipo curso',
                                    valueField:'CDTCR_CODIGO',
                                    displayField:'CDTCR_NOMBRE',
                                    paramName:'P_CDTCR_CODIGO',
                                    paramValue:'',
                                    type:'searchable'
                                };
                                params[3]={
                                    objectName:'FrmListadoCgg_dhu_curso',
                                    label:'Curso',
                                    valueField:'CDCUR_CODIGO',
                                    displayField:'CDCUR_DESCRIPCION',
                                    paramName:'P_CDCUR_CODIGO',
                                    paramValue:'',
                                    type:'searchable'
                                };

                                var reporte = new FrmCriterioReporte('rptListadoPre_inscrito_periodo', '/Reports/sii/dhu', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },{
                            text:'Reporte de Plantillas de Encuestas',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnDhu-rptEncuestasCursos',
                            handler:function(){
                                var params = [];
                                params[0]={
                                    objectName:'FrmListadoCgg_dhu_encuesta',
                                    label:'Encuesta',
                                    valueField:'CDENC_CODIGO',
                                    displayField:'CDENC_NOMBRE',
                                    paramName:'P_CDENC_CODIGO',
                                    paramValue:'',
                                    type:'searchable'
                                };

                                var reporte = new FrmCriterioReporte('rptEncuestasCursos', '/Reports/sii/dhu', null);
                                reporte.addParams(params);
                                reporte.show();
                            }
                        },'-',{
                            text:'Estadistico',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnDhu-Est',
                            menu:{
                                items:[
                                {
                                    text:'Estad\u00EDsticas de becas',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Est-rptReporteEstadisticoBecas',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };
                                        params[2]=
                                        {
                                            objectName:'FrmListadoCgg_dhu_tipo_beca',
                                            label:'Programa',
                                            valueField:'CDTBC_CODIGO',
                                            displayField:'CDTBC_NOMBRE',
                                            paramName:'P_CDTBC_CODIGO',
                                            paramValue:'',
                                            type:'searchable',
                                            required:true
                                        };

                                        var reporte = new FrmCriterioReporte('rptReporteEstadisticoBecas', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                },{
                                    text:'Estad\u00EDsticas de capacitaciones',
                                    iconCls:'iconReporte',
                                    hidden:true,
                                    id:'mnDhu-Est-rptReporteEstadisticoCapacitaciones',
                                    handler:function(){
                                        var params = [];
                                        params[0]={
                                            label:'Fecha inicio',
                                            paramName:'P_FECHA_INICIAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[1]={
                                            label:'Fecha fin',
                                            paramName:'P_FECHA_FINAL',
                                            paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                            type:'date'
                                        };

                                        params[2]={
                                            objectName:'FrmListadoCgg_dhu_tipo_curso',
                                            label:'Tipo curso',
                                            valueField:'CDTCR_CODIGO',
                                            displayField:'CDTCR_NOMBRE',
                                            paramName:'P_CDTCR_CODIGO',
                                            paramValue:'',
                                            type:'searchable'
                                        };

                                        var reporte = new FrmCriterioReporte('rptReporteEstadisticoCapacitaciones', '/Reports/sii/dhu', null);
                                        reporte.addParams(params);
                                        reporte.show();
                                    }
                                }

                                ]
                            }
                        }
                        ]
                    }
                },{
                    text:'Jur\u00EDdico',
                    iconCls:'iconReporte',
                    hidden:true,
                    id:'mnJur',
                    menu:{
                        items:[
                        {
                            text:'Criterios jur\u00EDdicos de residentes',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnJur-rptListadoCriteriosporTramiteFase',
                            handler:function(){
                                //Enlazado
                                var params = [];
                                params[0]=
                                {
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[1]=
                                {
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[2]=
                                {
                                    label:'Tipo residencia',
                                    paramName:'P_CRTST_CODIGO',
                                    value: dsTipoSolicitudPadre,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };

                                params[3]=
                                {
                                    objectName:'Cgg_res_tramite',
                                    label:'Tr\u00e1mite',
                                    valueField:'CRTRA_CODIGO',
                                    displayField:'CRTRA_NUMERO',
                                    paramName:'P_CRTRA_CODIGO',
                                    paramValue:'',
                                    type:'searchable',
                                    required:true
                                };

                                params[4]=
                                {
                                    objectName:'FrmListadoCgg_res_seccion',
                                    label:'Secci\u00f3n',
                                    valueField:'CRSEC_CODIGO',
                                    displayField:'CRSEC_NOMBRE',
                                    paramName:'P_CRSEC_CODIGO',
                                    paramValue:'',
                                    type:'searchable',
                                    required:true
                                };

                                params[5]=
                                {
                                    objectName:'FrmListadoCgg_isla',
                                    label:'Isla',
                                    valueField:'CISLA_CODIGO',
                                    displayField:'CISLA_NOMBRE',
                                    paramName:'P_CISLA_CODIGO',
                                    paramValue:'',
                                    type:'searchable',
                                    required:true
                                };

                                var reporte = new FrmCriterioReporte('rptListadoCriteriosporTramiteFase', '/Reports/sii/residencia', null);
                                reporte.addParams(params);
                                reporte.show();

                            }
                        },{
                            text:'Criterios jur\u00EDdicos de veh\u00EDculos por periodo',
                            iconCls:'iconReporte',
                            hidden:true,
                            id:'mnJur-rptListadoCriteriosporTramiteFase1',
                            handler:function(){
                                //Enlazado
                                var params = [];
                                params[0]=
                                {
                                    label:'Fecha inicio',
                                    paramName:'P_FECHA_INICIAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[1]=
                                {
                                    label:'Fecha fin',
                                    paramName:'P_FECHA_FINAL',
                                    paramValue:CURRENT_DATE.toString('yyyyMMdd'),
                                    type:'date'
                                };

                                params[2]=
                                {
                                    label:'Tipo residencia',
                                    paramName:'P_CRTST_CODIGO',
                                    value: dsTipoSolicitudPadre,
                                    paramValue:'',
                                    type:'combo',
                                    required:true
                                };

                                params[3]=
                                {
                                    objectName:'Cgg_res_tramite',
                                    label:'Tr\u00e1mite',
                                    valueField:'CRTRA_CODIGO',
                                    displayField:'CRTRA_NUMERO',
                                    paramName:'P_CRTRA_CODIGO',
                                    paramValue:'',
                                    type:'searchable',
                                    required:true
                                };

                                params[4]=
                                {
                                    objectName:'FrmListadoCgg_res_seccion',
                                    label:'Secci\u00f3n',
                                    valueField:'CRSEC_CODIGO',
                                    displayField:'CRSEC_NOMBRE',
                                    paramName:'P_CRSEC_CODIGO',
                                    paramValue:'',
                                    type:'searchable',
                                    required:true
                                };

                                params[5]=
                                {
                                    objectName:'FrmListadoCgg_isla',
                                    label:'Isla',
                                    valueField:'CISLA_CODIGO',
                                    displayField:'CISLA_NOMBRE',
                                    paramName:'P_CISLA_CODIGO',
                                    paramValue:'',
                                    type:'searchable',
                                    required:true
                                };

                                var reporte = new FrmCriterioReporte('rptListadoCriteriosporTramiteFase', '/Reports/sii/residencia', null);
                                reporte.addParams(params);
                                reporte.show();

                            }
                        }
                        ]
                    }
                }
                ]
            }
        }
    }
});

function setVisibleReport(){
    try{
        var store = storeReports;
        if (store.getCount()>0) Ext.getCmp("mnRootReports").setVisible(true);
        for (i=0;i<store.getCount();i++){
            var idMenu = store.getAt(i).get("CSRPT_REPORTE");
            var arrMenuReports = idMenu.split("-");
            var tmpIdMenu ="";
            for (j=0;j<arrMenuReports.length;j++){
                tmpIdMenu += ((j>0)?"-":"")+arrMenuReports[j];
                var tmpCmp = Ext.getCmp(tmpIdMenu);
                try{
                    tmpCmp.setVisible(true);
                }catch(ex){}
            }
        }
    }catch(ex){
    }
}
