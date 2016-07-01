/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla HistorialTramite.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmHistorialTramite(inDesktop){
    var optMenu = 'Control de Residencia/Historial de tramite';
    var urlListadoHistorialTramite=URL_WS+"Cgg_res_tramite";
    var tituloListadoHistorialTramite='Historial de tr\u00e1mite';
    var descListadoHistorialTramite='El formulario permite consultar informaci\u00f3n del historial de los tr\u00e1mites de residencia del C.G.G.';
    var cmHistorialTramite = new Cgg_res_tramite().getColumnModel();//DEFINICION DE VARIABLE PARA UTILIZACION EN EL COLUMN MODEL DEL LISTADO
    var tmpVerificar = true;
    /**
* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmHistorialTramite.
*/
    var btnRevisarHistorialTramite = new Ext.Button({
        id:'btnRevisarHistorialTramite',
        text:'Ver seguimiento',
        iconCls:'iconBuscar',
        listeners:{
            click:function(){                                
                pnlHistorialTramite.activate('tpHistorialTramite2');
            }
        }
    });

    /**
* Ext.Button Boton que permite anular un tramite.
*/
    var btnAnularTramite = new Ext.Button({
        id:'btnAnularTramite',
        text:'Anular',
        iconCls:'iconAnularTramite',
        listeners:{
            click:function(){
                var rTramite = grdHistorialTramite.getSelectionModel().getSelected();
                if(rTramite !== undefined &&  rTramite !== null ){

                    Ext.Msg.show({
                        title:tituloListadoHistorialTramite,
                        prompt:true,
                        multiline:true,
                        msg: 'Esta seguro que desea anular el tr\u00E1mite '+rTramite.get('CRTRA_ANIO')+'-'+rTramite.get('CRTRA_NUMERO')+'?.<br>Esta operaci\u00F3n anula un tr\u00E1mite definitivamente.<br>Ingrese una observaci\u00f3n para la anulaci\u00f3n, por favor.',
                        value:'Tr\u00E1mite anulado...',
                        buttons: Ext.Msg.YESNO,
                        fn: function(inBtn,inText){
                            if(inBtn == 'yes'){
                                
                                var scpAnular = new SOAPClientParameters();
                                scpAnular.add('inCrtra_codigo',rTramite.get('CRTRA_CODIGO'));
                                scpAnular.add('inCrtra_observacion',inText);

                                SOAPClient.invoke(URL_WS+'Cgg_res_tramite', 'anularTramite', scpAnular , true, function(inServiceResponse){
                                    inServiceResponse = Ext.util.JSON.decode(inServiceResponse);
                                    if(inServiceResponse.success == true){
                                        Ext.Msg.show({
                                            title:tituloListadoHistorialTramite,
                                            msg: 'El tr\u00E1mite ha sido anulado definitivamente.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });
                                        gsHistorialTramite.reload();
                                    }else{
                                        Ext.Msg.show({
                                            title:tituloListadoHistorialTramite,
                                            msg: 'El tr\u00E1mite no ha sido anulado definitivamente.\nError:'+inServiceResponse.msg+'\n'+ERR_MESSAGE,
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });
                                    }
                                });
                            }

                        },                        
                        icon: Ext.MessageBox.QUESTION
                    });
                 
                }else{
                    Ext.Msg.show({
                        title:tituloListadoHistorialTramite,
                        msg: 'Seleccione un tr\u00e1mite, por favor.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.WARNING
                    });                    
                }
            }
        }
    });

    /**
* Ext.Button Boton que permite salir de la ventana winFrmHistorialTramite.
*/
    var btnSalirHistorialTramite = new Ext.Button({
        id:'btnSalirHistorialTramite',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmHistorialTramite.close();
            }
        }
    });
    var actHstRptTramitePersonal = new Ext.Action({
        id:'actHstRptTramitePersonal',
        text:'Tr\u00E1mites del personal recibidos - despachados',
        handler:function(){

            var params = [];
            params[0]=
            {
                label:'Fecha inicio',
                paramName:'P_FECHA_INICIAL',
                paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
                type:'date'
            };

            params[1]=
            {
                label:'Fecha fin',
                paramName:'P_FECHA_FINAL',
                paramValue:CURRENT_DATE.toString('yyyyMMddhhmmss'),
                type:'date'
            };

            params[2]={
                objectName:'Cgg_usuario',
                label:'Usuario',
                valueField:'CUSU_CODIGO',
                displayField:'NOMBRES|APELLIDOS',
                paramName:'P_CUSU_CODIGO',
                paramValue:'',
                type:'searchable',
                required:true
            }

            params[3]=
            {
                label:'Tipo residencia',
                paramName:'P_CRTST_CODIGO',
                value: dsTipoSolicitudPadre,
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
                type:'searchable'
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
    });
    var actHstRptFormularioPentacontrol = new Ext.Action({
        id:'actHstRptFormularioPentacontrol',
        text:'Formulario de pentacontrol',
        handler:function(){
            var rTramite = grdHistorialTramite.getSelectionModel().getSelected();
			var tmpIsPrintable=false;
            if(rTramite ){
				if ((rTramite.data.CRETT_CODIGO == SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','01')).data.CGCNF_VALOR_CADENA)|| 
					(rTramite.data.CRETT_CODIGO == SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','14')).data.CGCNF_VALOR_CADENA)||
					(rTramite.data.CRETT_CODIGO == SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','29')).data.CGCNF_VALOR_CADENA))
				{
					tmpIsPrintable = true;
				}
                if(!tmpIsPrintable)
				{
                    Ext.Msg.show({
                        title:tituloListadoHistorialTramite,
                        msg: 'El tr\u00E1mite seleccionado no se halla en un estado apropiado para generar el formulario.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    return;
                }
                var reporte = new Reporte('rptFormularioSolicitudResidenciaPentacontrol','/Reports/sii/residencia',{
                    P_CRTRA_CODIGO:grdHistorialTramite.getSelectionModel().getSelected().get('CRTRA_CODIGO')
                }
                );
                reporte.show();
            }else{
                Ext.MsgPopup.msg(tituloListadoHistorialTramite, 'Seleccione un tr\u00e1mite, por favor.',MsgPopup.WARNING);
            }
        }
    });
    var actHstRptInformeTecnico = new Ext.Action({
        id:'actHstRptInformeTecnico',
        text:'Informe Tecnico de Residencia',
        handler:function(){
            var rTramite = grdHistorialTramite.getSelectionModel().getSelected();
            if(rTramite ){
                /*if(rTramite.data.CRETT_CODIGO != SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','01')).data.CGCNF_VALOR_CADENA){
						Ext.Msg.show({
							title:tituloListadoHistorialTramite,
							msg: 'El tr\u00E1mite seleccionado no esta para ser tratado en el comit\u00e9.',
							buttons: Ext.Msg.OK,
							icon: Ext.MessageBox.INFO
						});
						return;
					}*/
                var reporte = new Reporte('rptInformeTecnicoResidencia','/Reports/sii/residencia',{
                    P_CRTRA_CODIGO:grdHistorialTramite.getSelectionModel().getSelected().get('CRTRA_CODIGO')
                }
                );
                reporte.show();
            }else{
                Ext.MsgPopup.msg(tituloListadoHistorialTramite, 'Seleccione un tr\u00e1mite, por favor.',MsgPopup.WARNING);
            }
        }
    });
    var actHstRptComprobanteTramite = new Ext.Action({
        id:'actHstRptComprobanteTramite',
        text:'Comprobante de tr\u00e1mite',
        handler:function(){
            var rTramite = grdHistorialTramite.getSelectionModel().getSelected();
            if(rTramite ){
                var reporte = new Reporte("rptComprobanteTramite", '/Reports/sii/residencia', {
                    P_CRTRA_CODIGO:grdHistorialTramite.getSelectionModel().getSelected().get('CRTRA_CODIGO')
                });
                reporte.show();
            }else{
                Ext.MsgPopup.msg(tituloListadoHistorialTramite, 'Seleccione un tr\u00e1mite, por favor.',MsgPopup.WARNING);
            }
        }
    });
    var btnHstRptDevolucionGarantia = new Ext.Toolbar.SplitButton({
        id:'btnHstRptDevolucionGarantia',
        iconCls:'iconCalc',
        text:'Dev. de garant\u00eda',
        menu:[{
            text:'Sin verificaci\u00f3n',
            handler:function(){
                tmpVerificar = false;
                btnHstRptDevolucionGarantia.fireEvent('click', btnHstRptDevolucionGarantia);
            }
        }],
        listeners:{
            click:function(){
                var rTramite = grdHistorialTramite.getSelectionModel().getSelected();
                if(rTramite){
                    var tmpParams = new SOAPClientParameters();
                    tmpParams.add('inCrtra_codigo', rTramite.get('CRTRA_CODIGO'));
                    SOAPClient.invoke(URL_WS+'Cgg_res_tramite_garantia', 'selectPendientes',tmpParams, true, function(inServiceResponse){
                        var tmpPendientes = eval(inServiceResponse);
                        if(tmpPendientes == 1){
                            Ext.Msg.show({
                                title:tituloListadoHistorialTramite,
                                msg: 'Tiene solo un tr\u00E1mite asociado a la garant\u00eda. Desea devolverla? <br/>Presione <b>SI</b> para retirar definitivamente.<br/>Presione <b>NO</b> para liberar la garant\u00eda.<br/>Presione <b>CANCELAR</b> para cerrar la ventana.',
                                buttons: Ext.Msg.YESNOCANCEL,
                                fn: function(inBtn,inText){
                                    if (inBtn == 'cancel') return;	    
				    var tmpTodo = false;
                                    if(inBtn == 'yes')
                                        tmpTodo = true;
                                    devolucionGarantia(rTramite.get('CRTRA_CODIGO'),tmpTodo, tmpVerificar);
                                },
                                icon: Ext.MessageBox.QUESTION
                            });
                        }else{
                            if(tmpPendientes == 0){
                                Ext.Msg.show({
                                    title:tituloListadoHistorialTramite,
                                    msg: 'El tr\u00E1mite seleccionado no tiene garant\u00edas pendientes por retirar.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                            }else
                                devolucionGarantia(rTramite.get('CRTRA_CODIGO'),false, tmpVerificar);
                        }
                    });
                }
            }
        }
    });

    var btnAdjuntos = new Ext.ux.form.AlfrescoFM({
        id:'compAdjunto',   //(opcional)
        name:'compAdjunto', //(opcional)
        text: 'Adjuntos',    //(opcional -> Texto del botón)
        tableName: 'Cgg_res_tramite',
        validateRecordID:true
    });

    btnAdjuntos.addListener("updateData",function(t){
        t.recordID = null;
        var rTramite = grdHistorialTramite.getSelectionModel().getSelected();
        t.recordID = rTramite.get('CRTRA_CODIGO');
        t.filter = "crtst_codigo='"+rTramite.get('CRTST_CODIGO')+"'";
        rTramite=null;
    });

    function devolucionGarantia(inCrtra_codigo,inTodo, inVerificar){
        var scpHistorialTramite = new SOAPClientParameters();
        scpHistorialTramite.add('inCrtra_codigo', inCrtra_codigo);
        scpHistorialTramite.add('inTodo', inTodo);
        scpHistorialTramite.add('inVerificar', inVerificar);
        scpHistorialTramite.add('format',TypeFormat.JSON);

        SOAPClient.invoke(URL_WS+'Cgg_res_deposito_garantia', 'selectDevolucionGarantia',scpHistorialTramite, true, function(inServiceResponse){
            var tmpRes = Ext.util.JSON.decode(inServiceResponse);
            if(tmpRes.length > 0){
                var tmpMsg = 'No se autoriza la devolucion de la garant\u00eda por:<br>';
                for (i = 0; i < tmpRes.length; i++){
                    tmpMsg += tmpRes[i]+'<br>';
                }
                Ext.Msg.show({
                    title:tituloListadoHistorialTramite,
                    msg: tmpMsg,
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.INFO
                });
            }else{
                var tmpParam = [];
                tmpParam[0] = {
                    type:'input',
                    label:'Destinatario',
                    paramName:'P_DESTINATARIO'
                };
                tmpParam[1] = {
                    type:'input',
                    label:'Cargo de destinatario',
                    paramName:'P_CARGO_DESTINATARIO'
                };
                tmpParam[2] = {
                    type:'input',
                    label:'Responsable',
                    paramName:'P_RESPONSABLE'
                };
                tmpParam[3] = {
                    type:'input',
                    label:'Dargo del responsable',
                    paramName:'P_CARGO_RESPONSABLE'
                };
                tmpParam[4] = {
                    type:'input',
                    label:'Memorandum',
                    paramName:'P_NUM_MEMO'
                };
                tmpParam[5] = {
                    paramName:'P_CRTRA_CODIGO',
                    paramValue:inCrtra_codigo
                };
                var reporte = new FrmCriterioReporte('rptMemorandumDevolucionGarantia', '/Reports/sii/residencia', null);
                reporte.addParams(tmpParam);
                reporte.show();
                gsHistorialTramite.reload();
            }
        });
				
        tmpVerificar = true;
    }
		
    var actHstRptCompDevGrn = new Ext.Action({
        id:'actHstRptCompDevGrn',
        text:'Memorandum dev. garant\u00eda',
        handler:function(){
            var rTramite = grdHistorialTramite.getSelectionModel().getSelected();
            if(rTramite){
                if(rTramite.data.CRTGR_ESTADO_ASIGNACION == undefined || rTramite.data.CRTGR_ESTADO_ASIGNACION == null){
                    Ext.Msg.show({
                        title:tituloListadoHistorialTramite,
                        msg: 'El tramite seleccionado no tiene garant\u00edas.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    return;
                }
                if(rTramite.data.CRTGR_ESTADO_ASIGNACION == 0){
                    Ext.Msg.show({
                        title:tituloListadoHistorialTramite,
                        msg: 'No tiene autorizado la devoluci\u00f3n de la garant\u00eda.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    return;
                }
                var tmpParam = [];
                tmpParam[0] = {
                    type:'input',
                    label:'Destinatario',
                    paramName:'P_DESTINATARIO'
                };
                tmpParam[1] = {
                    type:'input',
                    label:'Cargo de destinatario',
                    paramName:'P_CARGO_DESTINATARIO'
                };
                tmpParam[2] = {
                    type:'input',
                    label:'Responsable',
                    paramName:'P_RESPONSABLE'
                };
                tmpParam[3] = {
                    type:'input',
                    label:'Dargo del responsable',
                    paramName:'P_CARGO_RESPONSABLE'
                };
                tmpParam[4] = {
                    type:'input',
                    label:'Memorandum',
                    paramName:'P_NUM_MEMO'
                };
                tmpParam[5] = {
                    paramName:'P_CRTRA_CODIGO',
                    paramValue:rTramite.data.CRTRA_CODIGO
                };
                var reporte = new FrmCriterioReporte('rptMemorandumDevolucionGarantia', '/Reports/sii/residencia', null);
                reporte.addParams(tmpParam);
                reporte.show();
            }
        }
    });
    /**
* Ext.Button Boton para obtener reportes, general o individual.
*/var btnReporteHistorialTramite = new Ext.Button({
        id:'btnReporteHistorialTramite',
        name:'btnReporteHistorialTramite',
        text:'Reportes',
        iconCls:'iconImprimir',
        menu:[actHstRptTramitePersonal,actHstRptFormularioPentacontrol,actHstRptInformeTecnico,actHstRptComprobanteTramite,'-',actHstRptCompDevGrn]
    });
    var btnRevisarTramite = new Ext.Button({
        id:'btnRevisarTramite',
        text:'Revisar',
        iconCls:'iconRevisar',
        tooltip:'Revisar',
        listeners:{
            click:function(){
                var tmpRecord=grdHistorialTramite.getSelectionModel().getSelected();
                if(tmpRecord){
                    var objCgg_res_seguimiento = inDesktop.getWindow('winFrmCgg_res_revision_tramite');
                    if (objCgg_res_seguimiento){
                        objCgg_res_seguimiento.maximize();
                        objCgg_res_seguimiento.close();
                    }
                    objCgg_res_seguimiento = new FrmCgg_res_revision_tramite(tmpRecord,inDesktop);
                    objCgg_res_seguimiento.closeHandler(function(){
                        //gsCgg_res_resolucion_votacion.reload();
                        // comprobarSeguimiento();
                        });
                    objCgg_res_seguimiento.loadData();
                    objCgg_res_seguimiento.show();
                }
            }
        }
    });
    /**
* Ext.data.Store Agrupacion de registros de la tabla HistorialTramite por un campo especifico.
*/
    var gsHistorialTramite = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_tramite",
            method:"selectPageHistorial",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRTRA_CODIGO',
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
            name:'CVVEH_CODIGO'
        },

        {
            name:'CRETT_CODIGO'
        },

        {
            name:'CRETT_NOMBRE'
        },

        {
            name:'CISLA_CODIGO'
        },

        {
            name:'CVMTR_CODIGO'
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
            name:'CGCRG_NOMBRE'
        },

        {
            name:'CRTRA_OBSERVACION'
        },

        {
            name:'CRTRA_DIAS_PERMANENCIA'
        },

        {
            name:'CRTRA_PENDIENTE'
        },

        {
            name:'CRTRA_OBSERVACION_PENDIENTE'
        },

        {
            name:'CRTRA_ATENCION_CLIENTE'
        },

        {
            name:'CRTRA_COMUNICADO_RADIAL'
        },

        {
            name:'CRTRA_MOTIVO'
        },

        {
            name:'CRTRA_FOLIO'
        },

        {
            name:'CRTRA_GRUPO'
        },

        {
            name:'CRTRA_ORDEN'
        },

        {
            name:'CRTGR_ESTADO_ASIGNACION'
        },

        {
            name:'CRSEG_ESTADO_ATENCION'
        }
        ]),
        groupField:'CRTRA_FECHA_RECEPCION',
        sortInfo:{
            field: 'CRTRA_FECHA_RECEPCION',
            direction: 'DESC'
        },
        baseParams:{
            keyword:"",
            format:'JSON'
        }
    });

    /**
* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla HistorialTramite.
*/
    var pgBarHistorialTramite= new Ext.PagingToolbar({
        store: gsHistorialTramite,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    
    /**
* Ext.grid.GridPanel Representacion de los datos de la tabla HistorialTramite en un formato tabular de filas y columnas.
*/
    var grdHistorialTramite = new Ext.grid.GridPanel({
        cm:cmHistorialTramite,
        store:gsHistorialTramite,
        region:'center',
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Tr\u00E1mites" : "Tr\u00E1mite"]})'
        }),
        loadMask:{
            msg:"Cargando..."
        },
        tbar: [
        'Buscar: ',
        new Ext.ux.bsx.SearchField({
            id:'sfBusquedaHistorial',
            store:gsHistorialTramite,
            width:200
        })
        ],
        bbar:pgBarHistorialTramite,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                pnlHistorialTramite.activate('tpHistorialTramite2');
            }
        }
    });
    gsHistorialTramite.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:'JSON'
        }
    });

    var pnlHistorialTramite = new Ext.TabPanel({
        id:'pnlHistorialTramite',
        region:'center',
        items:[{
            id:'tpHistorialTramite1',
            title:'Listado tr\u00e1mites',
            layout:'border',
            items:[grdHistorialTramite]
        },{
            id:'tpHistorialTramite2',
            title:'Workflow',
            layout:'border',
            items:[{
                id:'pnlWorkflow',
                html:'<div id="infovis"/>',
                autoScroll:true,
                region:'center'
            },{
                id:'pnlWorkflowInfo',
                frame:true,
                region:'east',
                width:200,
                split:true,
                collapsible:true,
                collapsed:true,
                autoScroll:true,
                items:[{
                    id:'lblWorkflowInfo',
                    xtype:'label'
                }],
                title:'Informaci\u00f3n de tr\u00e1mite'
            }
            ]
        }],
        activeTab:0,
        tabPosition:'bottom',
        listeners:{
            tabchange:function(inThis,inTab){
                if(inTab.getId()=='tpHistorialTramite2'){
                    var rTramite = grdHistorialTramite.getSelectionModel().getSelected();
                    if(rTramite!== null && rTramite != undefined){
                        inThis.getEl().mask('Espere un momento por favor.', 'x-mask-loading');

                        var scpHistorialTramite = new SOAPClientParameters();
                        scpHistorialTramite.add('inCrtra_codigo',rTramite.get('CRTRA_CODIGO'));
                        scpHistorialTramite.add('format',TypeFormat.JSON);

                        SOAPClient.invoke(URL_WS+'Cgg_res_tramite', 'selectHistorialTramite',scpHistorialTramite, true, function(inServiceResponse){
                            var objNodoHistorial = null;
                            try{
                                objNodoHistorial = Ext.util.JSON.decode(inServiceResponse);
                                crearFlujoTrabajo('infovis',objNodoHistorial);
                            }catch(inErr){
                                objNodoHistorial = null;
                                Ext.MsgPopup.msg(tituloListadoHistorialTramite, "Se present\u00f3 un problema al momento de presentar el historial de tr\u00e1mite.<br>Error:"+inErr, MsgPopup.WARNING );
                            }
                            inThis.getEl().unmask();
                        })
                    }else{
                        Ext.MsgPopup.msg(tituloListadoHistorialTramite, "Es necesario seleccionar un tr\u00e1mite para continuar" );
                        pnlHistorialTramite.activate('tpHistorialTramite1');
                    }
                }
            }
        }
    });

    /**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla HistorialTramite.
	*/
    if(inDesktop){
        var winFrmHistorialTramite = inDesktop.createWindow({
            id:'winFrmHistorialTramite',
            title:tituloListadoHistorialTramite,
            width:800,
            minWidth:600,
            height:500,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            iconCls:'iconHistorial',
            tbar:getPanelTitulo('Listado '+tituloListadoHistorialTramite,descListadoHistorialTramite),
            items:[pnlHistorialTramite],
            bbar:[btnRevisarHistorialTramite,btnAnularTramite,'-',btnRevisarTramite,btnAdjuntos,'-',btnReporteHistorialTramite,'->',btnSalirHistorialTramite],
            listeners:{
                show:function(){
                    Ext.getCmp('sfBusquedaHistorial').focus(true,400);
                },
                close:function(){
                    stDiagramaHistorial=null;
                }
            }
        });
        /**
		* Funcion que aplica los privilegios del usuario.
		*/
        applyGrants(winFrmHistorialTramite.getBottomToolbar());
  
    }
   
    /**
	* Funcion miembro que devuelve la ventana winFrmHistorialTramite.
	* @returns ventana winFrmHistorialTramite.
	* @base FrmHistorialTramite.prototype.show
	*/
    this.getWindow = function(){
        return winFrmHistorialTramite;
    }
    /**
	* Funcion miembro que carga los controles de la ventana winFrmHistorialTramite.
	* @base FrmHistorialTramite.prototype.loadData
	*/
    this.loadData = function(){
        gsHistorialTramite.load();
    }
    /**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
    this.getColumnModel = function(){
        return cmHistorialTramite;
    }
    /**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
    this.getStore = function(){
        return gsHistorialTramite;
    }
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmHistorialTramite.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmHistorialTramite.prototype.getStore = function(){
    this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmHistorialTramite desde una instancia.
*/
FrmHistorialTramite.prototype.show = function(){
    this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmHistorialTramite desde una instancia.
*/
FrmHistorialTramite.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmHistorialTramite,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmHistorialTramite.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmHistorialTramite desde una instancia.
*/
FrmHistorialTramite.prototype.loadData = function(){
    this.loadData();
}
