/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_deposito_garantia.
* @constructor
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_res_deposito_garantia(inDesktop){
    var optMenu = 'Control de Residencia/Dep\u00f3sito de garant\u00EDas';
    var urlListadoCgg_res_deposito_garantia=URL_WS+"Cgg_res_deposito_garantia";
    var tituloListadoCgg_res_deposito_garantia='Listado dep\u00F3sito garant\u00EDa';
    var descListadoCgg_res_deposito_garantia='El formulario permite ingresar un nuevo dep\u00F3sito garant\u00EDa para residencia';
    var tmpTotal = 0;
    var tmpCrtra_codigo = '';
    var tmpCrdpt_codigo = '';
    /**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_deposito_garantia.
	*/
    var btnNuevoCgg_res_deposito_garantia = new Ext.Button({
        id:'btnNuevoCgg_res_deposito_garantia',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_deposito_garantia = new FrmCgg_res_deposito_garantia("insert");
                objCgg_res_deposito_garantia.closeHandler(function(){
                    gsCgg_res_deposito_garantia.reload();
                });
                objCgg_res_deposito_garantia.show();
            }
        }
    });
    /**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_deposito_garantia.
	*/
    var btnEditarCgg_res_deposito_garantia = new Ext.Button({
        id:'btnEditarCgg_res_deposito_garantia',
        text:'Editar',
        iconCls:'iconEditar',
        disabled:true,
        listeners:{
            click:function(){
                var r=grdCgg_res_deposito_garantia.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_deposito_garantia = new FrmCgg_res_deposito_garantia("update",r);
                    objCgg_res_deposito_garantia.setTotal(tmpTotal);
                    objCgg_res_deposito_garantia.closeHandler(function(){
                        gsCgg_res_deposito_garantia.reload();
                    });
                    objCgg_res_deposito_garantia.loadData();
                    objCgg_res_deposito_garantia.show();
                }
            }
        }
    });
    /**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_deposito_garantia.
	*/
    var btnEliminarCgg_res_deposito_garantia = new Ext.Button({
        id:'btnEliminarCgg_res_deposito_garantia',
        text:'Eliminar',
        iconCls:'iconEliminar',
        disabled:true,
        listeners:{
            click:function(){
                var r=grdCgg_res_deposito_garantia.getSelectionModel().getSelected();
                if(r){
                    function SWRCgg_res_deposito_garantia(btn){
                        if (btn=='yes'){
                            try{
                                function CallBackCgg_res_deposito_garantia(r){
                                    winFrmListadoCgg_res_deposito_garantia.getEl().unmask();
                                    if(r=='true'){
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_res_deposito_garantia,
                                            msg: 'La informaci\u00f3n del dep\u00F3sito garant\u00EDa ha sido eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });
                                        gsCgg_res_deposito_garantia.reload();
                                    }else{
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_res_deposito_garantia,
                                            msg: 'La informaci\u00f3n del dep\u00F3sito garant\u00EDa no ha podido ser eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.ERROR
                                        });
                                    }
                                }
                                winFrmListadoCgg_res_deposito_garantia.getEl().mask('Eliminando...', 'x-mask-loading');
                                var param = new SOAPClientParameters();
                                param.add('inCrdpt_codigo',grdCgg_res_deposito_garantia.getSelectionModel().getSelected().get('CRDPT_CODIGO'));
                                SOAPClient.invoke(urlListadoCgg_res_deposito_garantia,"delete",param, true, CallBackCgg_res_deposito_garantia);
                            }catch(inErr){
                                winFrmListadoCgg_res_deposito_garantia.getEl().unmask();
                            }
                        }
                    }
                }
                Ext.Msg.show({
                    title:'Aviso',
                    msg:'Est\u00e1 seguro de eliminar el dep\u00F3sito de garant\u00EDa ?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_res_deposito_garantia,
                    icon: Ext.MessageBox.QUESTION
                });
            }
        }
    });
    var btnDptDevolucion = new Ext.Button({
        id:'btnDptDevolucion',
        text:'Devoluci\u00f3n',
        iconCls:'iconCalc',
        disabled:true,
        listeners:{
            click:function(){
                var tmpRecord = grdCgg_res_deposito_garantia.getSelectionModel().getSelected();
                var tmpRecordTramites = grdGarantiaTramite.getSelectionModel().getSelected();
                if(tmpRecordTramites && tabCgg_res_deposito_garantia.getActiveTab() == grdGarantiaTramite){
                    if(tmpRecordTramites.data.CRTGR_ESTADO_ASIGNACION == 0){
                        Ext.Msg.show({
                            title:tituloListadoCgg_res_deposito_garantia,
                            msg: 'No esta autorizado la devoluci\u00f3n de la garant\u00eda del tr\u00e1mite seleccionado.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                        return;
                    }else if(tmpRecordTramites.data.CRTGR_ESTADO_ASIGNACION == 2){
                        Ext.Msg.show({
                            title:tituloListadoCgg_res_deposito_garantia,
                            msg: 'La garant\u00eda del tr\u00e1mite ya esta devuelta.',
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.INFO
                        });
                        return;
                    }
                }
                if(tmpRecord){
                    if(tabCgg_res_deposito_garantia.getActiveTab() == grdCgg_res_deposito_garantia){
                        if(tmpRecord.data.CRDPT_ESTADO_DEPOSITO == 0 ||
                            tmpRecord.data.CRDPT_ESTADO_DEPOSITO == 1){
                            Ext.Msg.show({
                                title:tituloListadoCgg_res_deposito_garantia,
                                msg: 'No esta autorizado la devoluci\u00f3n de la garant\u00eda.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            return;
                        }else if(tmpRecord.data.CRDPT_ESTADO_DEPOSITO == 3){
                            Ext.Msg.show({
                                title:tituloListadoCgg_res_deposito_garantia,
                                msg: 'La garant\u00eda ya esta devuelta.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            return;
                        }else if(tmpRecord.data.CRDPT_ESTADO_DEPOSITO == 4){
                            Ext.Msg.show({
                                title:tituloListadoCgg_res_deposito_garantia,
                                msg: 'A\u00fan se ha receptado la garant\u00eda.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            return;
                        }
                    }
                    var param = new SOAPClientParameters();
                    param.add('inCrdpt_codigo',tmpRecord.get('CRDPT_CODIGO'));
                    param.add('inCrtra_codigo',tmpCrtra_codigo?tmpCrtra_codigo:null);
                    SOAPClient.invoke(urlListadoCgg_res_deposito_garantia,'updateDevolucionGarantia',param, true, function(inResponse){
                        if(inResponse == 'true'){
                            var garantia = new Reporte('rptDevolucionGarantiaComp', '/Reports/sii/residencia', {
                                P_CRTRA_CODIGO:tmpCrtra_codigo,
                                P_CRDPT_CODIGO:tmpCrdpt_codigo
                            });
                            garantia.show();
                            Ext.Msg.show({
                                title:tituloListadoCgg_res_deposito_garantia,
                                msg: 'Se ha registrado la devoluci\u00f3n de la garant\u00eda.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                        }else{
                            Ext.Msg.show({
                                title:tituloListadoCgg_res_deposito_garantia,
                                msg: 'No se ha registrado la devoluci\u00f3n de la garant\u00eda. '+(inResponse.message?inResponse.message:inResponse),
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    });
                }
            }
        }
    });
    /**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_deposito_garantia.
	*/
    var btnSalirCgg_res_deposito_garantia = new Ext.Button({
        id:'btnSalirCgg_res_deposito_garantia',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_deposito_garantia.close();
            }
        }
    });
    var actDptCompRecepcion = new Ext.Action({
        id:'actDptCompDespacho',
        text:'Comprobante de recepci\u00f3n',
        handler:function(){
            var tmpRecord=grdCgg_res_deposito_garantia.getSelectionModel().getSelected();
            if(tmpRecord.data.CRDPT_ESTADO_DEPOSITO == 4){
                Ext.Msg.show({
                    title:tituloListadoCgg_res_deposito_garantia,
                    msg:'Por favor actualice la informaci\u00f3n de la garant\u00EDa para obtener el comprobante de recepci\u00f3n.',
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.INFO
                });
                return;
            }
            if(tmpRecord.data.CRDPT_ESTADO_DEPOSITO == 2 || tmpRecord.data.CRDPT_ESTADO_DEPOSITO == 3){
                Ext.Msg.show({
                    title:tituloListadoCgg_res_deposito_garantia,
                    msg:'La garant\u00EDa ya esta en proceso de devoluci\u00f3n.',
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.INFO
                });
                return;
            }
            if(tmpRecord){
                var garantia = new Reporte("rptComprobanteRecepcionGarantia", '/Reports/sii/residencia', {
                    P_CRDPT_CODIGO:tmpRecord.data.CRDPT_CODIGO,
                    P_CRTRA_CODIGO:tmpCrtra_codigo
                });
                garantia.show();
            }else{
                Ext.Msg.show({
                    title:tituloListadoCgg_res_deposito_garantia,
                    msg:'Seleccione un garant\u00eda asociada a un tr\u00e1mite, por favor.',
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.INFO
                });
            }
        }
    });
    var actDptCompDevolucion = new Ext.Action({
        id:'actDptCompDevolucion',
        text:'Comprobante de devoluci\u00f3n',
        handler:function(){
            var tmpRecord=grdCgg_res_deposito_garantia.getSelectionModel().getSelected();
            var tmpTramite = grdGarantiaTramite.getSelectionModel().getSelected();
            if (tmpRecord && tmpTramite){
                if(tmpRecord.data.CRDPT_ESTADO_DEPOSITO == 4){
                    Ext.Msg.show({
                        title:tituloListadoCgg_res_deposito_garantia,
                        msg:'Por favor actualice la informaci\u00f3n de la garant\u00EDa para realizar la devoluci\u00f3n.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    return;
                }
                if(tmpRecord.data.CRDPT_ESTADO_DEPOSITO == 2){
                    Ext.Msg.show({
                        title:tituloListadoCgg_res_deposito_garantia,
                        msg:'La garant\u00EDa esta en proceso de devoluci\u00f3n.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    return;
                }
                if(tmpRecord.data.CRDPT_ESTADO_DEPOSITO < 2){
                    Ext.Msg.show({
                        title:tituloListadoCgg_res_deposito_garantia,
                        msg:'No tiene autorizado la devoluci\u00f3n de la garant\u00EDa.',
                        buttons: Ext.Msg.OK,
                        icon: Ext.MessageBox.INFO
                    });
                    return;
                }
                var tmpParams = new SOAPClientParameters();
                tmpParams.add('inCrdpt_codigo', tmpRecord.data.CRDPT_CODIGO);
                tmpParams.add('format',TypeFormat.JSON);
				
                //				SOAPClient.invoke(URL_WS+'Cgg_res_tramite_garantia', 'selectCGG_RES_DEPOSITO_GARANTIA',tmpParams, true, function(inServiceResponse){
                //						var tmpTramites = Ext.util.JSON.decode(inServiceResponse);
                //						if(tmpTramites.length > 0){
                //							tmpCrtra_codigo = tmpTramites[0].CRTRA_CODIGO;
                //							var garantia = new Reporte("rptDevolucionGarantiaComp", '/Reports/sii/residencia', {
                //								P_CRTRA_CODIGO:tmpCrtra_codigo,
                //								P_CRDPT_CODIGO:tmpCrdpt_codigo
                //							});
                //							garantia.show();
                //						}
                //				});


                var garantia = new Reporte("rptDevolucionGarantiaComp", '/Reports/sii/residencia', {
                    P_CRTRA_CODIGO:tmpTramite.get('CRTRA_CODIGO'),
                    P_CRDPT_CODIGO:tmpCrdpt_codigo
                });
                garantia.show();

            }else{
                Ext.Msg.show({
                    title:tituloListadoCgg_res_deposito_garantia,
                    msg:'Seleccione un garant\u00eda asociada a un tr\u00e1mite, por favor.',
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.INFO
                });
            }
        }
    });
    /**
	* Ext.Button Boton para obtener reportes, general o individual.
	*/
    var btnReporteCgg_res_deposito_garantia = new Ext.Button({
        id:'btnReporteCgg_res_deposito_garantia',
        name:'btnReporteCgg_res_deposito_garantia',
        text:'Reportes',
        iconCls:'iconImprimir',
        menu:[actDptCompRecepcion, actDptCompDevolucion]
    });
    /**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_deposito_garantia.
	*/
    var checkColumn = new Ext.grid.CheckColumn({
        header: 'Devuelto',
        dataIndex: 'CRDPT_DEVUELTO',
        width: 70
    });
    var chkCrdpt_caduca = new Ext.grid.CheckColumn(
    {
        dataIndex:'CRDPT_CADUCA',
        header:'Caduca',
        width:70,
        sortable:true
    });
    var cmCgg_res_deposito_garantia = new Ext.grid.ColumnModel([
    {
        dataIndex:'CRDPT_NUMERO',
        header:'N\u00FAmero',
        width:70
    },

    {
        dataIndex:'TRAMITES',
        header:'Tr\u00e1mites',
        width:100,
        sortable:true
    },

    {
        dataIndex:'CRPER_NOMBRES',
        header:'Auspiciante',
        width:150,
        sortable:true,
        hideable:false
    },

    {
        dataIndex:'EMPRESA',
        header:'Empresa',
        width:150,
        sortable:true,
        hideable:false
    },

    {
        dataIndex:'CRPJR_RAZON_SOCIAL',
        header:'Ent. Financiera',
        width:150,
        sortable:true,
        hideable:false
    },

    {
        dataIndex:'CRDPT_NUMERO_DOCUMENTO',
        header:'Numero documento',
        width:150,
        sortable:true
    },
    chkCrdpt_caduca,
    {
        dataIndex:'CRDPT_TIPO',
        header:'Tipo',
        width:70,
        sortable:true,
        renderer:function(inData){
            if(inData.length == 0)
                inData = 0;
            return dsTipoGarantia[inData][1];
        }
    },

    {
        dataIndex:'CRDPT_VALOR_DEPOSITO',
        header:'Valor',
        width:70,
        sortable:true,
        renderer: 'usMoney',
        align: 'right'
    },

    {
        dataIndex:'CRDPT_FECHA_DEPOSITO',
        header:'Fecha deposito',
        width:100,
        sortable:true,
        renderer: truncDate
    },

    {
        dataIndex:'CRDPT_FECHA_ENTREGA',
        header:'Fecha entrega',
        width:100,
        sortable:true,
        renderer: truncDate
    },

    {
        dataIndex:'CRDPT_FECHA_CADUCIDAD',
        header:'Fecha caducidad',
        width:100,
        sortable:true,
        renderer: truncDate
    },
    checkColumn,
    {
        dataIndex:'CRDPT_ESTADO_DEPOSITO',
        header:'Estado deposito',
        width:150,
        sortable:true,
        renderer:function(inData){
            return dsEstadoDeposito[inData][1];
        }
    }
]);
/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_res_deposito_garantia por un campo especifico.
	*/
var gsCgg_res_deposito_garantia = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_res_deposito_garantia",
        method:"selectPageDirect",
        pagin:true
    }),
    remoteSort:true,
    reader:new Ext.data.JsonReader({
        id:'CRDPT_CODIGO',
        root:'dataSet',
        totalProperty: 'totalCount'
    },[
    {
        name:'CRDPT_CODIGO'
    },

    {
        name:'CRCPJ_CODIGO'
    },

    {
        name:'CRPJR_CODIGO'
    },

    {
        name:'CRPER_CODIGO'
    },

    {
        name:'CGG_CRPJR_CODIGO'
    },

    {
        name:'CRDPT_NUMERO'
    },

    {
        name:'CRPJR_RAZON_SOCIAL'
    },

    {
        name:'CRPER_NOMBRES'
    },

    {
        name:'EMPRESA'
    },

    {
        name:'CRCPJ_NUMERO_CUENTA'
    },

    {
        name:'CRTRA_CODIGO'
    },

    {
        name:'TRAMITES'
    },

    {
        name:'CUPO_DISPONIBLE'
    },

    {
        name:'CRDPT_NUMERO_DOCUMENTO'
    },

    {
        name:'CRDPT_CADUCA'
    },

    {
        name:'CRDPT_TIPO'
    },

    {
        name:'CRDPT_VALOR_DEPOSITO'
    },

    {
        name:'CRDPT_FECHA_DEPOSITO'
    },

    {
        name:'CRDPT_FECHA_ENTREGA'
    },

    {
        name:'CRDPT_FECHA_CADUCIDAD'
    },

    {
        name:'CRDPT_FECHA_CONTABILIZACION'
    },

    {
        name:'CRDPT_FECHA_SOLIC_DEVOLUCION'
    },

    {
        name:'CRDPT_FECHA_DEVOLUCION_DEFINITI'
    },

    {
        name:'CRDPT_DEVUELTO'
    },

    {
        name:'CRDPT_ESTADO_DEPOSITO'
    },

    {
        name:'CRDPT_OBSERVACION'
    }
    ]),
    sortInfo:{
        field: 'CRDPT_NUMERO_DOCUMENTO',
        direction: 'ASC'
    },
    baseParams:{
        inDisponibles:false,
        keyword:'',
        format:'JSON'
    }
});
/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_deposito_garantia.
	*/
var pgBarCgg_res_deposito_garantia= new Ext.PagingToolbar({
    store: gsCgg_res_deposito_garantia,
    displayInfo: true,
    pageSize:RECORD_PAGE,
    displayMsg: 'Mostrando {0} - {1} de {2}',
    temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_deposito_garantia en un formato tabular de filas y columnas.
	*/
var grdCgg_res_deposito_garantia = new Ext.grid.GridPanel({
    title:'Garant\u00edas',
    cm:cmCgg_res_deposito_garantia,
    store:gsCgg_res_deposito_garantia,
    region:'center',
    sm:new Ext.grid.RowSelectionModel({
        singleSelect:true
    }),
    loadMask:{
        msg:"Cargando..."
    },
    tbar: [
    'Buscar: ', ' ',
    new Ext.ux.bsx.SearchField({
        store:gsCgg_res_deposito_garantia,
        width:200
    })
    ],
    bbar:pgBarCgg_res_deposito_garantia,
    listeners:{
        rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
            if(!btnEditarCgg_res_deposito_garantia.hidden){
                btnEditarCgg_res_deposito_garantia.fireEvent('click', btnEditarCgg_res_deposito_garantia);
            }
        }
    }
});

var dsEstadoTramiteGarantia = [[0, 'Asignado'], [1, 'Autorizado devo.'], [2, 'Devuelto']];

var summary = new Ext.ux.grid.GroupSummary();

/**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_tramite.
     */
var cmGarantiaTramite = new Ext.grid.ColumnModel([
{
    dataIndex:'CRTRA_NUMERO',
    header:'Numero',
    width:100,
    sortable:false
},
{
    dataIndex:'TIPO',
    header:'Tipo',
    width:300,
    sortable:false
},{
    dataIndex:'CRTGR_ESTADO_ASIGNACION',
    header:'Estado',
    width:100,
    sortable:false,
	renderer:function(inData){return dsEstadoTramiteGarantia[inData][1];}
},
{
    dataIndex:'TOTAL',
    header:'Garant\u00eda',
    renderer:Ext.util.Format.usMoney,
    width:150,
    sortable:false,
    summaryType:'sum',
    summaryRenderer:Ext.util.Format.usMoney
    }
]);
/**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_tramite por un campo especifico.
     */
var gsGarantiaTramite = new Ext.data.GroupingStore({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_res_deposito_garantia",
        method:"selectTramites",
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
        name:'CRPJR_CODIGO'
    },

    {
        name:'CGG_CRPER_CODIGO'
    },

    {
        name:'CRPRO_CODIGO'
    },

    {
        name:'CRTST_CODIGO'
    },

    {
        name:'CVVEH_CODIGO'
    },

    {
        name:'CRETT_CODIGO'
    },

    {
        name:'CISLA_CODIGO'
    },

    {
        name:'CRDPT_CODIGO'
    },

    {
        name:'CVMTR_CODIGO'
    },

    {
        name:'CRTGR_ESTADO_ASIGNACION'
    },

    {
        name:'CRTRA_NUMERO'
    },

    {
        name:'TIPO'
    },

    {
        name:'TOTAL',
        type:'float'
    }
    ]),
    groupField:'CRTRA_NUMERO',
    sortInfo:{
        field: 'CRTRA_NUMERO',
        direction: 'ASC'
    },
    baseParams:{
        keyword:'',
        format:'JSON',
        inCrdpt_codigo:''
    },
    listeners:{
        load:function(inStore, inRecords, inOptions){
            tmpTotal = 0;
            for(i = 0; i < inRecords.length; i++){
                if(inRecords[i].data.TOTAL){
                    inRecords[i].data.TOTAL = eval(inRecords[i].data.TOTAL);
                    tmpTotal = tmpTotal + inRecords[i].data.TOTAL;
                }
            }
        }
    }
});
/**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_tramite.
     */
var pgBarGarantiaTramite= new Ext.PagingToolbar({
    store: gsGarantiaTramite,
    displayInfo: true,
    pageSize:RECORD_PAGE,
    displayMsg: 'Mostrando {0} - {1} de {2}',
    temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_tramite en un formato tabular de filas y columnas.
     */
var grdGarantiaTramite = new Ext.grid.GridPanel({
    title:'Tramites',
    cm:cmGarantiaTramite,
    store:gsGarantiaTramite,
    disabled:true,
    sm:new Ext.grid.RowSelectionModel({
        singleSelect:true
    }),
    loadMask:{
        msg:"Cargando..."
    },
    tbar: ['Buscar: ',
    new Ext.ux.bsx.SearchField({
        store:gsGarantiaTramite,
        width:200
    })],
    bbar:pgBarGarantiaTramite,
    plugins:summary,
    view: new Ext.grid.GroupingView({
        showGroupName: false,
        groupTextTpl:'Tramites asociados a la garant\u00eda',
        enableNoGroups: false,
        enableGroupingMenu: false        
    })
});
/**
     * Ext.form.FormPanel Panel principal que contiene los controles de la ventana winFrmCgg_res_deposito_garantia.
     */
var tabCgg_res_deposito_garantia = new Ext.TabPanel({
    region:'center',
    activeTab:0,
    tabPosition:'bottom',
    items:[grdCgg_res_deposito_garantia, grdGarantiaTramite],
    listeners:{
        tabchange:function(inSource, inCurrentTab){
            if(inCurrentTab == grdCgg_res_deposito_garantia)
                tmpCrtra_codigo = null;
        }
    }
});
/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_deposito_garantia.
	*/
if(inDesktop){
    gsCgg_res_deposito_garantia.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON"
        }
    });
		
    grdGarantiaTramite.getSelectionModel().on("selectionchange",function(inSelectionModel){
        var tmpRecord = grdGarantiaTramite.getSelectionModel().getSelected();
        if(tmpRecord){
            tmpCrtra_codigo = tmpRecord.data.CRTRA_CODIGO;
        }
    });
		
    grdCgg_res_deposito_garantia.getSelectionModel().on("selectionchange",function(inSelectionModel){
        var tmpRecord = grdCgg_res_deposito_garantia.getSelectionModel().getSelected();
        btnEditarCgg_res_deposito_garantia.setDisabled(!inSelectionModel.hasSelection());
        btnEliminarCgg_res_deposito_garantia.setDisabled(!inSelectionModel.hasSelection());
        btnDptDevolucion.setDisabled(!inSelectionModel.hasSelection());
        tmpCrtra_codigo = '';
        if(tmpRecord){
            tmpCrdpt_codigo = tmpRecord.data.CRDPT_CODIGO;
            if(tmpRecord.data.TRAMITES.length > 0){
                gsGarantiaTramite.baseParams.inCrdpt_codigo = tmpRecord.data.CRDPT_CODIGO;
                gsGarantiaTramite.reload({
                    params:{
                        start:0,
                        limit:RECORD_PAGE,
                        inCrdpt_codigo:tmpRecord.data.CRDPT_CODIGO
                    }
                });
            }
            grdGarantiaTramite.setDisabled(tmpRecord.data.TRAMITES.length == 0);
        }
    });
		
    var winFrmListadoCgg_res_deposito_garantia = inDesktop.createWindow({
        id:'winFrmListadoCgg_res_deposito_garantia',
        title:tituloListadoCgg_res_deposito_garantia,
        tbar:getPanelTitulo(tituloListadoCgg_res_deposito_garantia,descListadoCgg_res_deposito_garantia),
        items:[tabCgg_res_deposito_garantia],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_res_deposito_garantia,btnEditarCgg_res_deposito_garantia,btnEliminarCgg_res_deposito_garantia,'-',btnDptDevolucion,btnReporteCgg_res_deposito_garantia,'->',btnSalirCgg_res_deposito_garantia]
    });
    /**
		* Funcion que aplica los privilegios del usuario.
		*/
    applyGrants(winFrmListadoCgg_res_deposito_garantia.getBottomToolbar());
}
	
/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_res_deposito_garantia.
	* @returns ventana winFrmCgg_res_deposito_garantia.
	* @base FrmListadoCgg_res_deposito_garantia.prototype.show
	*/
this.getWindow = function(){
    return winFrmListadoCgg_res_deposito_garantia;
}
/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_deposito_garantia.
	* @base FrmListadoCgg_res_deposito_garantia.prototype.loadData
	*/
this.loadData = function(){
    gsCgg_res_deposito_garantia.load();
}
/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
this.getColumnModel = function(){
    return cmCgg_res_deposito_garantia;
}
/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
this.getStore = function(){
    return gsCgg_res_deposito_garantia;
}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_res_deposito_garantia.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_res_deposito_garantia.prototype.getStore = function(){
    this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_deposito_garantia desde una instancia.
*/
FrmListadoCgg_res_deposito_garantia.prototype.show = function(){
    this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_deposito_garantia desde una instancia.
*/
FrmListadoCgg_res_deposito_garantia.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_deposito_garantia,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_res_deposito_garantia.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_deposito_garantia desde una instancia.
*/
FrmListadoCgg_res_deposito_garantia.prototype.loadData = function(){
    this.loadData();
}
