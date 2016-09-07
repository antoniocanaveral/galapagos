/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_tct_registro.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_tct_registro(inDesktop){
    var optMenu = 'TCT/Registro TCT';
    var urlListadoCgg_tct_registro=URL_WS+"Cgg_tct_registro";
    var tituloListadoCgg_tct_registro='Pre-registro de personas';
    var descListadoCgg_tct_registro='El formulario permite administrar informaci\u00f3n del pre-registro de personas';
	var urlCgg_tct_registro = URL_WS + "Cgg_tct_registro";
    var nacionalidad= new Nacionalidad();
    var residencia= new Residencia();
    var especie_kardex= new Especie_Kardex();
	var myJasperServer = new JasperServer();
	var tmpPrintMode = false;
    var isOperational = true;
	
	var gsCgg_res_documento_identificacio = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_documento_identificacio",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({
        },[
            {name:'CRDID_CODIGO'},
            {name:'CRDID_DESCRIPCION'
            }
        ]),
        baseParams:{
            format:TypeFormat.JSON
        },
		listeners:{
			load:function(){
				btnNuevoCgg_tct_registro.setDisabled(false);
			}
		}
    });
	
	var gsCgg_tct_actividad = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_tct_actividad",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({
            id:'CTACT_CODIGO'
        },[
            {name:'CTACT_CODIGO'},
            {name:'CTACT_NOMBRE'}
        ]),
        baseParams:{
            format:"JSON"
        },
		listeners:{
			load:function(){
				gsCgg_res_documento_identificacio.load();
			}
		}
    });
	
	var gsCgg_tct_tipo_hospedaje = new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_tct_tipo_hospedaje",
			method:"selectAll"
		}),
		reader:new Ext.data.JsonReader({
			id:'CTTHJ_CODIGO'
		},[
			{name:'CTTHJ_CODIGO'},
			{name:'CTTHJ_NOMBRE'}
		]),
		baseParams:{
			format:'JSON'
		},
		listeners:{
			load:function(){
				gsCgg_tct_actividad.load();
			}
		}
	});
	gsCgg_tct_tipo_hospedaje.load();
	
	/**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_tct_registro.
     */
    var btnNuevoCgg_tct_registro = new Ext.Button({
        id:'btnNuevoCgg_tct_registro',
        text:'Nuevo',
        iconCls:'iconNuevo',
	disabled:true,
        listeners:{
            click:function(){
                var objCgg_tct_registro = new FrmCgg_tct_registro("insert",undefined,undefined,gsCgg_tct_actividad,gsCgg_tct_tipo_hospedaje,inDesktop);
                objCgg_tct_registro.closeHandler(function(){
                    gsCgg_tct_registro.reload();
                    btnNuevoCgg_tct_registro.setDisabled(false);
                    btnEditarCgg_tct_registro.setDisabled(false);
                });                
                objCgg_tct_registro.setStoreActividad(gsCgg_tct_actividad);
                objCgg_tct_registro.setStoreHospedaje(gsCgg_tct_tipo_hospedaje);
                objCgg_tct_registro.setTipoDocumento(gsCgg_res_documento_identificacio);
                objCgg_tct_registro.setNacionalidad(nacionalidad.getStore());
                objCgg_tct_registro.setEspecie_Kardex(especie_kardex.getStore());
                objCgg_tct_registro.show();
                btnNuevoCgg_tct_registro.setDisabled(true);
                btnEditarCgg_tct_registro.setDisabled(true);
            }
        }
    });
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_tct_registro.
     */
    var btnNuevoCSVCgg_tct_registro = new Ext.Button({
        id:'btnNuevoCSVCgg_tct_registro',
        text:'Agregar CSV',
        iconCls:'iconAddCSV',
        listeners:{
            click:function(){
				var winCSV = MyDesktop.desktop.getWindow('winFrmCgg_tct_adjunto_csv');
				if (!winCSV)
					winCSV = new FrmCgg_tct_adjunto_csv(MyDesktop.desktop);				
				winCSV.show();				
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_tct_registro.
     */
    var btnEditarCgg_tct_registro = new Ext.Button({
        id:'btnEditarCgg_tct_registro',
        text:'Editar',
        iconCls:'iconEditar',	
        listeners:{
            click:function(){
                var r=grdCgg_tct_registro.getSelectionModel().getSelected();
                if(r){
                    if (r.get('CTREG_ESTADO_REGISTRO')==1 && !tmpPrintMode){
                        Ext.MessageBox.alert('Registro de Ingreso de Personas a la Provincia', 'Registro impreso, imposible editar');
                        return;
                    }else{
                        if  (r.get('CTREG_ESTADO_REGISTRO')==3 && !tmpPrintMode){
                            Ext.MessageBox.alert('Registro de Ingreso de Personas a la Provincia', 'Registro anulado, imposible editar');
                            return;
                        }
                    }
                    var objCgg_tct_registro = new FrmCgg_tct_registro("update",r, tmpPrintMode,gsCgg_tct_actividad,gsCgg_tct_tipo_hospedaje,inDesktop);
                    objCgg_tct_registro.closeHandler(function(){
                        gsCgg_tct_registro.reload();
                        tmpPrintMode = false;
                        btnNuevoCgg_tct_registro.setDisabled(false);
                        btnEditarCgg_tct_registro.setDisabled(false);
                    });
                    objCgg_tct_registro.setTipoDocumento(gsCgg_res_documento_identificacio);
                    objCgg_tct_registro.setNacionalidad(nacionalidad.getStore());
                    objCgg_tct_registro.setEspecie_Kardex(especie_kardex.getStore());
                    objCgg_tct_registro.loadData();
                    objCgg_tct_registro.show();
                    btnNuevoCgg_tct_registro.setDisabled(true);
                    btnEditarCgg_tct_registro.setDisabled(true);
                }else{
                    Ext.MessageBox.alert(tituloListadoCgg_tct_registro, 'Seleccione un registro para continuar');
                }
            }
        }
    });

    
    function CallBackCgg_tct_registroAnular(r){
        winFrmListadoCgg_tct_registro.getEl().unmask();
        if (r == 'true') {
            Ext.Msg.show({
                title:tituloListadoCgg_tct_registro,
                msg: 'La informaci\u00f3n ha sido anulada.',
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.INFO
            });
            gsCgg_tct_registro.reload(
                {
                    params:{
                        operational:isOperational,
                        start:0,
                        limit:(RECORD_PAGE - 10)
                    }
                }
            );
        } else
            Ext.Msg.show({
                title:tituloListadoCgg_tct_registro,
                msg: 'La informaci\u00f3n no ha podido ser anulada. ' + (r.message?r.message:r),
                buttons: Ext.Msg.OK,
                icon: Ext.MessageBox.ERROR
            });
    }
    

    var btnAnularCgg_tct_registro = new Ext.Button({
        id:'btnAnularCgg_tct_registro',
        text:'Anular',
        iconCls:'iconAnularTramite',
        listeners:{
            click:function(){
                var r=grdCgg_tct_registro.getSelectionModel().getSelected();
                if(r){
                    if (r.get('CTREG_ESTADO_REGISTRO')==3){
                        Ext.MessageBox.alert('Registro de Ingreso de Personas a la Provincia', 'Registro anulado, Imposible anular');
                        return;
                    }else{
                        if  (r.get('CTREG_ESTADO_REGISTRO')<3 && !tmpPrintMode){
                            winFrmListadoCgg_tct_registro.getEl().mask('Anulando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCtreg_codigo', grdCgg_tct_registro.getSelectionModel().getSelected().get('CTREG_CODIGO'));
                            param.add('inCtreg_estado_registro',3);
                            SOAPClient.invoke(urlCgg_tct_registro, "updateEstadoAnulada", param, true, CallBackCgg_tct_registroAnular);
                        }
                    }
                }else{
                    Ext.MessageBox.alert(tituloListadoCgg_tct_registro, 'Seleccione un registro para continuar');
                }
            }
        }
    });

    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_tct_registro.
     */
    var btnSalirCgg_tct_registro = new Ext.Button({
        id:'btnSalirCgg_tct_registro',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_tct_registro.close();
            }
        }
    });
	var btnTctPrintLst = new Ext.Action({
		id:'btnTctPrintLst',
		text:'Imprimir listado',
		iconCls:'iconImprimir',
		disabled:true,
		handler:function(){
			var tmpRecord = grdCgg_tct_registro.getSelectionModel().getSelected();
			if(tmpRecord){
				myJasperServer.addParam('P_CTGTR_CODIGO',tmpRecord.data.CTGTR_CODIGO);
				myJasperServer.setReportFolder('/Reports/sii/tct');
				myJasperServer.setReportName('rptRegistroTCTparaAgenciaViajes');
				myJasperServer.run();
			}
		}
	});
    /**
     * Ext.Button Boton para obtener reportes, general o individual.
     */var btnReporteCgg_tct_registro = new Ext.Toolbar.SplitButton({
        id:'btnReporteCgg_tct_registro',
        name:'btnReporteCgg_tct_registro',
        text:'Imprimir especie',
        iconCls:'iconImprimir',
		disabled:true,
        menu:[{text:'Seleccionado',
                handler:function(){
					var tmpRecord = grdCgg_tct_registro.getSelectionModel().getSelected();
					if(tmpRecord){
						if(tmpRecord.data.CTREG_ESTADO_REGISTRO > 0){
							
							Ext.Msg.show({title:'Aviso', msg:'El registro selecionado ya fue impreso.<br> La nueva impresion desea que sea contabilizada.?', buttons: Ext.Msg.YESNO,fn:function(inBtnText){
									if(inBtnText == 'yes'){							
										printEspecie(tmpRecord);
									}
									else
									{
										printEspecieOnly(tmpRecord);
									}
									},icon: Ext.MessageBox.QUESTION});
							
							
							
						}else
							printEspecie(tmpRecord);
							
					}
                }
            },{
				text:'Grupo',
				handler:function(){
					var tmpRecord = grdCgg_tct_registro.getSelectionModel().getSelected();
					var tmpIsPrint = false;
					if(tmpRecord){
						function CallBackPersonaGrupo(inResponse){
							var tmpRecords = Ext.util.JSON.decode(inResponse);
							var tmpArrayReports = new Array();
							var tmpImpRegistros = '';
							function CallBackCgg_tct_registro(r) {
								if (r == 'true') {
									Ext.Msg.show({
										title:tituloListadoCgg_tct_registro,
										msg: 'Las especies de Tct han sido impresas.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
									});
									printGroup(tmpRecords[0].CTGTR_CODIGO, tmpImpRegistros,tmpArrayReports);
									gsCgg_tct_registro.reload();
								} else
									Ext.Msg.show({
										title:tituloListadoCgg_tct_registro,
										msg: 'Las especies de TCT no ha podido ser impresas. ' + (r.message?r.message:r),
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
									});
							}
							var tmpData = '[';
							for(i = 0; i < tmpRecords.length; i++){
								if(i>0){
									tmpData += ',';
									tmpImpRegistros += ',';
								}
								if (tmpRecords[i].CTREG_ESTADO_REGISTRO == 1)
								{
									tmpIsPrint = true;
								}
								tmpImpRegistros += tmpRecords[i].CTREG_CODIGO;
								tmpArrayReports[tmpRecords[i].CKESP_REPORTE] = tmpRecords[i].CKESP_CODIGO;
								tmpData += '{\"CTREG_CODIGO\":\"'+tmpRecords[i].CTREG_CODIGO+'\",\"CKESP_CODIGO\":\"'+tmpRecords[i].CKESP_CODIGO+'\"}';
							}
							tmpData +=']';
							if (tmpIsPrint)
							{
								Ext.Msg.show({title:'Aviso', msg:'El grupo selecionado ya fue impreso.<br> La nueva impresion desea que sea contabilizada.?', buttons: Ext.Msg.YESNO,fn:function(inBtnText){
									if(inBtnText == 'yes'){							
										var param = new SOAPClientParameters();
										param.add('inPersona_JSON', tmpData);
										param.add('inCtreg_estado_registro',1);
										SOAPClient.invoke(urlCgg_tct_registro, 'updateEstadoImpresa', param, true, CallBackCgg_tct_registro);
									}
									else
									{
										printGroup(tmpRecords[0].CTGTR_CODIGO, tmpImpRegistros,tmpArrayReports);
									}},icon: Ext.MessageBox.QUESTION});
							}
							else
							{
								var param = new SOAPClientParameters();
								param.add('inPersona_JSON', tmpData);
								param.add('inCtreg_estado_registro',1);
								SOAPClient.invoke(urlCgg_tct_registro, 'updateEstadoImpresa', param, true, CallBackCgg_tct_registro);
							}
						}
						var param = new SOAPClientParameters();
						param.add('inCtgtr_codigo', tmpRecord.data.CTGTR_CODIGO);
						param.add('inCtreg_estado_registro', '0,1');
						param.add('format','JSON');
						SOAPClient.invoke(urlCgg_tct_registro, 'selectTctPersonaTct', param, true, CallBackPersonaGrupo);
					}
				}
			}
        ],
		handler:function(){
			if(!btnEditarCgg_tct_registro.disabled){
				tmpPrintMode = true;
				btnEditarCgg_tct_registro.fireEvent('click', btnEditarCgg_tct_registro);
			}
		}
    });
	
	function  printGroup(inCtgtr_codigo, inImpRegistros,inArrayReports)
	{
	
		
		/*	for(var tmpRN in tmpArrayReports){
				if(typeof(tmpArrayReports[tmpRN]) == 'string'){
					myJasperServer.addParam('P_PREVIEW',0);
					myJasperServer.addParam('P_CTGTR_CODIGO',tmpRecords[0].CTGTR_CODIGO);
					myJasperServer.addParam('P_CKESP_CODIGO',tmpArrayReports[tmpRN]);
					myJasperServer.addParam('P_CTREG_CODIGO',tmpImpRegistros);
					myJasperServer.setReportName(tmpRN);
					myJasperServer.setTitle(tmpRN);
					myJasperServer.setReportFolder('/Reports/sii/tct');
					myJasperServer.run();
				}
			}*/
			for(var tmpRN in inArrayReports){
				if(typeof(inArrayReports[tmpRN]) == 'string'){
					myJasperServer.addParam('P_PREVIEW',0);
					myJasperServer.addParam('P_CTGTR_CODIGO',inCtgtr_codigo);
					myJasperServer.addParam('P_CKESP_CODIGO',inArrayReports[tmpRN]);
					myJasperServer.addParam('P_CTREG_CODIGO',inImpRegistros);
					myJasperServer.setReportName(tmpRN);
					myJasperServer.setTitle(tmpRN);
					myJasperServer.setReportFolder('/Reports/sii/tct');
					myJasperServer.run();
				}
			}
	
	}
	/**
     * Ext.Button Boton para obtener reportes, general o individual.
     */
    var btnEspecieCgg_tct_registro = new Ext.Toolbar.SplitButton({
        id:'btnEspecieCgg_tct_registro',
        name:'btnEspecieCgg_tct_registro',
        text:'Vista preliminar',
        iconCls:'iconPreview',
        disabled:true,
        menu:[{
            text:'Seleccionado',
            handler:function(){
                var tmpRecord = grdCgg_tct_registro.getSelectionModel().getSelected();
                if(tmpRecord){
                    if (tmpRecord.get('CTREG_ESTADO_REGISTRO') == 3)
                        Ext.MessageBox.alert(tituloListadoCgg_tct_registro, 'Registro anulado, imposible imprimir.');
                    else{
                        function CallBackTipoEspecie(inServerResponse){
                            var tmpRecords = Ext.util.JSON.decode(inServerResponse);
                            myJasperServer.addParam('P_PREVIEW',1);
							myJasperServer.addParam('P_CTGTR_CODIGO',tmpRecord.data.CTGTR_CODIGO);
                            myJasperServer.addParam('P_CTREG_CODIGO',tmpRecord.data.CTREG_CODIGO);
                            myJasperServer.addParam('P_CKESP_CODIGO',tmpRecords[0].CKESP_CODIGO);
                            myJasperServer.setReportName(tmpRecords[0].CKESP_REPORTE);
                            myJasperServer.setReportFolder('/Reports/sii/tct');
                            myJasperServer.run();
                        }
                        var param = new SOAPClientParameters();
                        param.add('inCtreg_codigo', tmpRecord.data.CTREG_CODIGO);
                        param.add('format','JSON');
                        SOAPClient.invoke(URL_WS+'Cgg_kdx_venta_detalle', 'selectCGG_TCT_REGISTRO', param, true, CallBackTipoEspecie);
                    }
                }
            }
        }],
    listeners:{
        click:function(){
            var tmpRecord = grdCgg_tct_registro.getSelectionModel().getSelected();
            var tmpArrayReports = new Array();
            var tmpCount = 0;
            var tmpRN = '';
            if(tmpRecord){
                function CallBackPersonaGrupo(inResponse){
                    var tmpRecords = Ext.util.JSON.decode(inResponse);
                    for(i = 0; i < tmpRecords.length; i++)
                        tmpArrayReports[tmpRecords[i].CKESP_REPORTE] = tmpRecords[i].CKESP_CODIGO;
                    for(var tmpRN in tmpArrayReports){
                        if(typeof(tmpArrayReports[tmpRN]) == 'string'){
                            myJasperServer.addParam('P_PREVIEW',1);
                            myJasperServer.addParam('P_CTGTR_CODIGO',tmpRecords[0].CTGTR_CODIGO);
                            myJasperServer.addParam('P_CKESP_CODIGO',tmpArrayReports[tmpRN]);
                            myJasperServer.setReportName(tmpRN);
                            myJasperServer.setTitle(tmpRN);
                            myJasperServer.setReportFolder('/Reports/sii/tct');
                            myJasperServer.run();
                        }
                    }
                }
                var param = new SOAPClientParameters();
                param.add('inCtgtr_codigo', tmpRecord.data.CTGTR_CODIGO);
                param.add('inCtreg_estado_registro', '0,1');
                param.add('format','JSON');
                SOAPClient.invoke(urlCgg_tct_registro, 'selectTctPersonaTct', param, true, CallBackPersonaGrupo);
            }
        }
    }
    });


    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_tct_registro.
     */
    var cmCgg_tct_registro = new Ext.grid.ColumnModel([
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'No documento',width:90,sortable:true},
        {dataIndex:'CRPER_NOMBRES',header:'Nombres',width:150,sortable:true},
        {dataIndex:'CRPER_FECHA_NACIMIENTO',header:'Fecha Nacimiento',width:70,sortable:true,renderer:truncDate},
        {dataIndex:'CGNCN_CODIGO',header:'Nacionalidad',width:150,sortable:true},
        {dataIndex:'CGG_CPAIS_CODIGO',header:'Residencia',width:150,sortable:true},
        {dataIndex:'AEROPUER_ORIGEN',header:'Aeropuerto Origen',width:150,sortable:true},        
        {dataIndex:'AEROPUER_DESTINO',header:'Aeropuerto Destino',width:150,sortable:true},        
        {dataIndex:'AEROLINEA',header:'Aerol\u00ednea',width:70,sortable:true},
        {dataIndex:'CTREG_NUMERO_VUELO',header:'Nro. Vuelo',width:70,sortable:true},
        {dataIndex:'CTGTR_NUMERO',header:'Grupo',width:70,sortable:true},
        {dataIndex:'NUMERO',header:'No. Certificado',width:100,sortable:true},
		{dataIndex:'CTREG_CODIGO_BARRAS',header:'C\u00f3digo barras',width:100,sortable:true},
		{dataIndex:'CTREG_FECHA_INSERT',header:'Registro',width:70,sortable:true,renderer:truncDate},
        {dataIndex:'CTREG_FECHA_INGRESO',header:'Ingreso',width:70,sortable:true,renderer:truncDate},
        {dataIndex:'CTREG_FECHA_SALIDA',header:'Salida',width:70,sortable:true,renderer:truncDate},
        {dataIndex:'CTREG_IMPRESION_ESPECIE',header:'Impresi\u00f3n',width:120,sortable:true,renderer:truncDateTime},
        {dataIndex:'CTREG_ESTADO_REGISTRO',header:'Estado registro',width:150,sortable:true,renderer:function(inCtreg_estado){
                return dsEstadoRegistroTct[inCtreg_estado][1];
		}},
		{dataIndex:'CTREG_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true},
		{dataIndex:'CTREG_USUARIO_INSERT',header:'Usuario',width:70,sortable:true},
        {dataIndex:'CTAGV_NOMBRE',header:'Agencia de viaje',width:200,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_tct_registro por un campo especifico.
     */
    var gsCgg_tct_registro = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_tct_registro",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CTREG_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CTREG_CODIGO'},
            {name:'CARPT_CODIGO'},
			{name:'CRPER_NUM_DOC_IDENTIFIC'},
			{name:'CRPER_NOMBRES'},
            {name:'CRPER_FECHA_NACIMIENTO'},
            {name:'CGNCN_CODIGO'},
            {name:'CGG_CPAIS_CODIGO'},
            {name:'AEROPUER_ORIGEN'},
            {name:'CGG_CARPT_CODIGO'},
            {name:'AEROPUER_DESTINO'},
            {name:'CRALN_CODIGO'},
            {name:'AEROLINEA'},
            {name:'CTGTR_CODIGO'},
			{name:'CTGTR_NUMERO'},
            {name:'CRTRA_CODIGO'},
            {name:'NUMERO'},
            {name:'CTREG_NUMERO'},
            {name:'CTREG_FECHA_PREREGISTRO'},
            {name:'CTREG_FECHA_INGRESO'},
            {name:'CTREG_CODIGO_BARRAS'},
            {name:'CTREG_FECHA_SALIDA'},
            {name:'CTREG_IMPRESION_ESPECIE'},
			{name:'CTAGV_NOMBRE'},
            {name:'CTREG_ESTADO_REGISTRO'},
			{name:'CTREG_OBSERVACION'},
			{name:'CTREG_FECHA_INSERT'},
			{name:'CTREG_USUARIO_INSERT'},
			{name:'USUARIO_UPDATE'},
            {name:'CTREG_NUMERO_VUELO'}
        ]),
        sortInfo:{
            field: 'CTREG_FECHA_INSERT',
            direction: 'DESC'
        },
        baseParams:{
            keyword:"",
            format:TypeFormat.JSON
        },
        groupField:'CTREG_FECHA_INSERT'
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_tct_registro.
     */
    var pgBarCgg_tct_registro= new Ext.PagingToolbar({
        store: gsCgg_tct_registro,
        displayInfo: true,
        pageSize:(RECORD_PAGE - 10),
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_tct_registro en un formato tabular de filas y columnas.
     */
    var grdCgg_tct_registro = new Ext.grid.GridPanel({
        cm:cmCgg_tct_registro,
        store:gsCgg_tct_registro,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_tct_registro,
                width:200
            }),'-', 'No impresos: ',new Ext.form.Checkbox({
                checked:true,
                fieldLabel: 'No mostrar impresos',
                listeners:{
                    check:function(_this,_checked){
                        isOperational = _checked;
                        gsCgg_tct_registro.reload({params:{
                            operational:isOperational,
                            start:0,
                            limit:(RECORD_PAGE - 10)
                        }});
                    }
                }
            })],
        bbar:pgBarCgg_tct_registro,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_tct_registro.hidden){
                    btnEditarCgg_tct_registro.fireEvent('click', btnEditarCgg_tct_registro);
                }
            }
        },
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        })
    });
    gsCgg_tct_registro.reload({params:{
        operational:isOperational,
		start:0,
		limit:(RECORD_PAGE - 10)
	}});
	
	grdCgg_tct_registro.getSelectionModel().on("selectionchange",function(inSelectionModel){
            
		btnEspecieCgg_tct_registro.setDisabled(!inSelectionModel.hasSelection());
		btnReporteCgg_tct_registro.setDisabled(!inSelectionModel.hasSelection());
		btnTctPrintLst.setDisabled(!inSelectionModel.hasSelection());
	});
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_tct_registro.
     */
    if(inDesktop){
        var winFrmListadoCgg_tct_registro = inDesktop.createWindow({
            id:'winFrmListadoCgg_tct_registro',
            title:tituloListadoCgg_tct_registro,
            width:700,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_tct_registro,descListadoCgg_tct_registro),
            items:[grdCgg_tct_registro],
            bbar:[btnNuevoCgg_tct_registro,btnNuevoCSVCgg_tct_registro,btnEditarCgg_tct_registro,'-',btnTctPrintLst,btnReporteCgg_tct_registro,btnEspecieCgg_tct_registro,'->',btnAnularCgg_tct_registro,'-',btnSalirCgg_tct_registro]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_tct_registro.getBottomToolbar());
    }
	
	/**
	* Obtiene un reporte de la especie seleccionada para impresion, sin considerar su contabilizacion.
	*/
	function printEspecieOnly(inRecord)
	{
		function CallBackTipoEspecie(inServerResponse){
			var tmpRecords = Ext.util.JSON.decode(inServerResponse);	
					myJasperServer.addParam('P_PREVIEW', 0);
					myJasperServer.addParam('P_CTGTR_CODIGO',inRecord.data.CTGTR_CODIGO);
					myJasperServer.addParam('P_CTREG_CODIGO',inRecord.data.CTREG_CODIGO);
					myJasperServer.addParam('P_CKESP_CODIGO',tmpRecords[0].CKESP_CODIGO);
					myJasperServer.setReportName(tmpRecords[0].CKESP_REPORTE);
					myJasperServer.setReportFolder('/Reports/sii/tct');
					myJasperServer.run();									
		}
		var param = new SOAPClientParameters();
		param.add('inCtreg_codigo', inRecord.data.CTREG_CODIGO);
		param.add('format','JSON');
		SOAPClient.invoke(URL_WS+'Cgg_kdx_venta_detalle', 'selectCGG_TCT_REGISTRO', param, true, CallBackTipoEspecie);	
	}
	
	/**
	* Obtiene un reporte de la especie seleccionada para impresion.
	*/
	function printEspecie(inRecord){
		function CallBackTipoEspecie(inServerResponse){
			var tmpRecords = Ext.util.JSON.decode(inServerResponse);
			function CallBackCgg_tct_registro(r){
				if(r == 'true'){
					myJasperServer.addParam('P_PREVIEW', 0);
					myJasperServer.addParam('P_CTGTR_CODIGO',inRecord.data.CTGTR_CODIGO);
					myJasperServer.addParam('P_CTREG_CODIGO',inRecord.data.CTREG_CODIGO);
					myJasperServer.addParam('P_CKESP_CODIGO',tmpRecords[0].CKESP_CODIGO);
					myJasperServer.setReportName(tmpRecords[0].CKESP_REPORTE);
					myJasperServer.setReportFolder('/Reports/sii/tct');
					myJasperServer.run();
					gsCgg_tct_registro.reload();
				}else{
					Ext.Msg.show({
						title:tituloListadoCgg_tct_registro,
						msg: 'El registro seleccionado no ha sido impreso. ' + (r.message?r.message:r),
						buttons: Ext.Msg.OK,
						icon: Ext.MessageBox.ERROR
					});
				}
			}
			var param = new SOAPClientParameters();
			param.add('inPersona_JSON', '[{\"CTREG_CODIGO\":\"'+inRecord.data.CTREG_CODIGO+'\",\"CKESP_CODIGO\":\"'+tmpRecords[0].CKESP_CODIGO+'\"}]');
			param.add('inCtreg_estado_registro',1);
			SOAPClient.invoke(urlCgg_tct_registro, 'updateEstadoImpresa', param, true, CallBackCgg_tct_registro);
		}
		var param = new SOAPClientParameters();
		param.add('inCtreg_codigo', inRecord.data.CTREG_CODIGO);
		param.add('format','JSON');
		SOAPClient.invoke(URL_WS+'Cgg_kdx_venta_detalle', 'selectCGG_TCT_REGISTRO', param, true, CallBackTipoEspecie);				
	}
	
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_tct_registro.
     * @returns ventana winFrmCgg_tct_registro.
     * @base FrmListadoCgg_tct_registro.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_tct_registro;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_tct_registro.
     * @base FrmListadoCgg_tct_registro.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_tct_registro.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_tct_registro;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_tct_registro;
    }

}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_tct_registro.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_tct_registro.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_tct_registro desde una instancia.
 */
FrmListadoCgg_tct_registro.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_tct_registro desde una instancia.
 */
FrmListadoCgg_tct_registro.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_tct_registro,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_tct_registro.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_tct_registro desde una instancia.
 */
FrmListadoCgg_tct_registro.prototype.loadData = function(){
    this.loadData();
}

