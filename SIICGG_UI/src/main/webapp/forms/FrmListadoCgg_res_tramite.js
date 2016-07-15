/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_tramite.
 * @constructor
 * @param inDesktop Escritorio web de la aplicacion.
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_tramite(inDesktop){
    var optMenu = 'Control de Residencia/Tr\u00E1mites';
    var urlListadoCgg_res_tramite=URL_WS+"Cgg_res_tramite";
    var tituloListadoCgg_res_tramite='Listado tr\u00E1mite';
    var descListadoCgg_res_tramite='El formulario permite administrar informaci\u00f3n de tr\u00E1mites';
	var cmCgg_res_tramite = new Cgg_res_tramite().getColumnModel();
    /**
	 * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_tramite.
	 */
    var btnNuevoCgg_res_tramite = new Ext.Button({
        id:'btnNuevoCgg_res_tramite',
        text:'Nuevo',
        iconCls:'iconNuevo',        
        listeners:{
            click:function(){
                var objCgg_res_tramite = new FrmCgg_res_tramite("registrarTramite");
                objCgg_res_tramite.closeHandler(function(){
                    gsCgg_res_tramite.reload();
                });
                objCgg_res_tramite.show();
            }
        }
    });

    var btnNuevoTranseunte = new Ext.Button({
        id:'btnNuevoTranseunte',
        text:'Nuevo transe\u00fante',
        iconCls:'iconNuevoTranseunte',
        listeners:{
            click:function(){
                var objCgg_res_tramiteTranseunte = new FrmCgg_res_tramite_transeunte_grupo();
                    objCgg_res_tramiteTranseunte.closeHandler(function(){
                        gsCgg_res_tramite.reload();
                    });
                    objCgg_res_tramiteTranseunte.show();
            }
        }
    });


    /**
	 * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_tramite.
	 */
    var btnEditarCgg_res_tramite = new Ext.Button({
        id:'btnEditarCgg_res_tramite',
        text:'Abrir',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_tramite.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_tramite = new FrmCgg_res_tramite("update",r);
                    objCgg_res_tramite.closeHandler(function(){
                        gsCgg_res_tramite.reload();
                    });                    
                    objCgg_res_tramite.show();
                    objCgg_res_tramite.loadData();
                }
            }
        }
    });
    /**
	 * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_tramite.
	 */
    var btnEliminarCgg_res_tramite = new Ext.Button({
        id:'btnEliminarCgg_res_tramite',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                var rTramite = grdCgg_res_tramite.getSelectionModel().getSelected();
                if(rTramite){
                    function SWRCgg_res_tramite(btn){
                        if (btn=='yes'){
                            try{
                                function CallBackCgg_res_tramite(r){
                                    winFrmListadoCgg_res_tramite.getEl().unmask();
                                    r = Ext.util.JSON.decode(r);
                                    if(r.success==true){
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_res_tramite,
                                            msg: 'El tramite ha sido eliminado.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });
                                        gsCgg_res_tramite.reload();
                                    }
                                    else{
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_res_tramite,
                                            msg: 'El tr\u00e1mite no ha sido eliminado.<br>Error:'+r.msg,
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.ERROR
                                        });
                                    }
                                }
                                winFrmListadoCgg_res_tramite.getEl().mask('Eliminando...', 'x-mask-loading');
                                var param = new SOAPClientParameters();
                                param.add('inCrtra_codigo',grdCgg_res_tramite.getSelectionModel().getSelected().get('CRTRA_CODIGO'));
                                SOAPClient.invoke(urlListadoCgg_res_tramite,"eliminarTramite",param, true, CallBackCgg_res_tramite);
                            }catch(inErr){
                                winFrmListadoCgg_res_tramite.getEl().unmask();
                            }
                        }
                    }
                    
                    Ext.Msg.show({
                        title:tituloListadoCgg_res_tramite,
                        msg:'Seguro de eliminar el registro seleccionado?',
                        buttons: Ext.Msg.YESNO,
                        fn: SWRCgg_res_tramite,
                        icon: Ext.MessageBox.QUESTION
                    });
                    
                }
            }
        }
    });
    /**
	 * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_tramite.
	 */
    var btnSalirCgg_res_tramite = new Ext.Button({
        id:'btnSalirCgg_res_tramite',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_tramite.close();
            }
        }
    });
    var actDptCompDeposito = new Ext.Action({
        id:'actDptCompDeposito',
        text:'Comprobante de deposito',
        handler:function(){
            var tmpRecord = grdCgg_res_tramite.getSelectionModel().getSelected();
            if (tmpRecord){
                var garantia = new Reporte("rptComprobanteDepositoGarantia", '/Reports/sii/residencia', {
                    P_CRTRA_CODIGO:tmpRecord.data.CRTRA_CODIGO
                });
                garantia.show();
            }else{
                Ext.Msg.show({
                    title:tituloListadoCgg_res_deposito_garantia,
                    msg:'Seleccione un tr\u00e1mite, por favor.',
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.INFO
                });
            }
        }
    });
	var actTrmRptComprobanteTramite = new Ext.Action({
        	id:'actTrmRptComprobanteTramite',
            text:'Comprobante de tr\u00e1mite',
            handler:function(){
                var rTramite = grdCgg_res_tramite.getSelectionModel().getSelected();
                if(rTramite ){
                    var reporte = new Reporte("rptComprobanteTramite", '/Reports/sii/residencia', {
                        P_CRTRA_CODIGO:grdCgg_res_tramite.getSelectionModel().getSelected().get('CRTRA_CODIGO')
                    });
                    reporte.show();
                }else{
                    Ext.MsgPopup.msg(tituloListadoCgg_res_tramite, 'Seleccione un tr\u00e1mite, por favor.',MsgPopup.WARNING);
                }
            }
        });
    /**
	 * Ext.Button Boton para obtener reportes, general o individual.
	 */var btnReporteCgg_res_tramite = new Ext.Button({
        id:'btnReporteCgg_res_tramite',
        name:'btnReporteCgg_res_tramite',
        text:'Reportes',
        iconCls:'iconImprimir',
        menu:[actDptCompDeposito,actTrmRptComprobanteTramite,
		{
            text:'Mis tr\u00E1mites recibido - despachado',
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

                params[2]=
                {
                    label:'Usuario',
                    paramName:'P_CUSU_CODIGO',
                    paramValue:new UserSession().getUserID(),
                    value:new UserSession().getUserData().CUSU_NOMBRE_USUARIO,
                    type:'direct'
                };

                params[3]={
                    objectName:'FrmListadoCgg_res_tipo_solicitud_tramite',
                    label:'Tipo solicitud',
                    valueField:'CRTST_CODIGO',
                    displayField:'CRTST_DESCRIPCION',
                    paramName:'P_CRTST_CODIGO',
                    paramValue:'',
                    type:'searchable'
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
        }]
    });
       
    /**
	  * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_tramite por un campo especifico.
	  */
    var gsCgg_res_tramite = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_tramite",
            method:"selectPageDirect1",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRTRA_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {name:'CRTRA_CODIGO'},
        {name:'CRPER_CODIGO'},
        {name:'CRPER_TBENEFICIARIO'},
        {name:'CRPJR_CODIGO'},
        {name:'CRPJR_NOMBRES'},
        {name:'CGG_CRPER_CODIGO'},
        {name:'CRPER_TAUSPICIANTE'},
        {name:'CRPRO_CODIGO'},
        {name:'CRTST_CODIGO'},
        {name:'CRTST_DESCRIPCION'},
        {name:'CVVEH_CODIGO'},
        {name:'CRETT_CODIGO'},
		{name:'CRETT_NOMBRE'},
        {name:'CISLA_CODIGO'},
        {name:'CVMTR_CODIGO'},
        {name:'CRTRA_ANIO'},
        {name:'CRTRA_NUMERO'},
        {name:'CRTRA_FECHA_RECEPCION'},
        {name:'CRTRA_ACTIVIDAD_RESIDENCIA'},
		{name:'CGCRG_NOMBRE'},
		{name:'ACTIVIDAD_RESIDENCIA'},
        {name:'CRTRA_OBSERVACION'},
        {name:'CRTRA_DIAS_PERMANENCIA'},
        {name:'CRTRA_PENDIENTE'},
        {name:'CRTRA_OBSERVACION_PENDIENTE'},
        {name:'CRTRA_ATENCION_CLIENTE'},
        {name:'CRTRA_COMUNICADO_RADIAL'},
        {name:'CRTRA_MOTIVO'},
		{name:'CRTRA_FECHA_INGRESO'},
		{name:'CRTRA_FECHA_SALIDA'},
        {name:'CRTRA_FOLIO'},
		{name:'CRTRA_GRUPO'},
        {name:'CRTRA_ORDEN'}
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
    /**
	  * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_tramite.
	  */
    var pgBarCgg_res_tramite= new Ext.PagingToolbar({
        store: gsCgg_res_tramite,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
	  * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_tramite en un formato tabular de filas y columnas.
	  */
    var grdCgg_res_tramite = new Ext.grid.GridPanel({
        cm:new Cgg_res_tramite().getColumnModel(),
        store:gsCgg_res_tramite,
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
            store:gsCgg_res_tramite,
            width:200
        })
        ],
        plugins:[new Ext.ux.grid.AutoSizeColumns()],
        bbar:pgBarCgg_res_tramite,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_tramite.hidden){
                    btnEditarCgg_res_tramite.fireEvent('click', btnEditarCgg_res_tramite);
                }
            }
        }
    });
    gsCgg_res_tramite.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON"
        }
    });


    /**
	  * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_tramite.
	  */
    var winFrmListadoCgg_res_tramite=null;

    if(inDesktop !== null && inDesktop !== undefined){
        winFrmListadoCgg_res_tramite = new inDesktop.createWindow({
            id:'winFrmListadoCgg_res_tramite',
            title:tituloListadoCgg_res_tramite,
            tbar:getPanelTitulo(tituloListadoCgg_res_tramite,descListadoCgg_res_tramite),
            items:[grdCgg_res_tramite],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            iconCls:'iconTramite',
            //bbar:[btnNuevoCgg_res_tramite,btnEditarCgg_res_tramite,btnEliminarCgg_res_tramite,'-',btnReporteCgg_res_tramite,'->',btnSalirCgg_res_tramite]
//MO
           bbar:[btnNuevoCgg_res_tramite,btnNuevoTranseunte,btnEditarCgg_res_tramite,btnEliminarCgg_res_tramite,'-',btnReporteCgg_res_tramite,'->',btnSalirCgg_res_tramite]
//
        });
    }else{
        winFrmListadoCgg_res_tramite = new Ext.Window({
            id:'winFrmListadoCgg_res_tramite',
            title:tituloListadoCgg_res_tramite,
            tbar:getPanelTitulo(tituloListadoCgg_res_tramite,descListadoCgg_res_tramite),
            items:[grdCgg_res_tramite],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            iconCls:'iconTramite',
            bbar:[btnNuevoCgg_res_tramite,btnEditarCgg_res_tramite,btnEliminarCgg_res_tramite,'-',btnReporteCgg_res_tramite,'->',btnSalirCgg_res_tramite]
        });
    }
 
    /**
	  * Funcion que aplica los privilegios del usuario.
	  */
    applyGrants(winFrmListadoCgg_res_tramite.getBottomToolbar());
    /**
	  * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_tramite.
	  * @returns ventana winFrmCgg_res_tramite.
	  * @base FrmListadoCgg_res_tramite.prototype.show
	  */
    this.getWindow = function(){
        return winFrmListadoCgg_res_tramite;
    }
    /**
	  * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_tramite.
	  * @base FrmListadoCgg_res_tramite.prototype.loadData
	  */
    this.loadData = function(){
        gsCgg_res_tramite.load();
    }
    /**
	  * Funcion miembro que develve el ColumnModel utilizado en el listado.
	  */
    this.getColumnModel = function(){
        return cmCgg_res_tramite;
    }
    /**
	  * Funcion miembro que develve el Store utilizado en el listado.
	  */
    this.getStore = function(){
        return gsCgg_res_tramite;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_tramite.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_tramite.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_tramite desde una instancia.
 */
FrmListadoCgg_res_tramite.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_tramite desde una instancia.
 */
FrmListadoCgg_res_tramite.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_tramite,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_tramite.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_tramite desde una instancia.
 */
FrmListadoCgg_res_tramite.prototype.loadData = function(){
    this.loadData();
}
