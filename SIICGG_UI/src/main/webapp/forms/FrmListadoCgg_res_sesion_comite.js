/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_sesion_comite.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_sesion_comite(inDesktop){
    var optMenu = 'Comit\u00e9/Sesiones de comite';
    var urlListadoCgg_res_sesion_comite=URL_WS+"Cgg_res_sesion_comite";
    var tituloListadoCgg_res_sesion_comite='Listado de sesiones de comites.';
    var descListadoCgg_res_sesion_comite='El formulario permite administrar informaci\u00f3n de la Sesi\u00f3n  del Comit\u00e9';
	var myJasperServer = new JasperServer();
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_sesion_comite.
     */
    var btnNuevoCgg_res_sesion_comite = new Ext.Button({
        id:'btnNuevoCgg_res_sesion_comite',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_res_sesion_comite = new FrmCgg_res_sesion_comite("insert");
                objCgg_res_sesion_comite.closeHandler(function(){
                    gsCgg_res_sesion_comite.reload();
                });
                objCgg_res_sesion_comite.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_sesion_comite.
     */
    var btnEditarCgg_res_sesion_comite = new Ext.Button({
        id:'btnEditarCgg_res_sesion_comite',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
		disabled:true,
        listeners:{
            click:function(){
                var r=grdCgg_res_sesion_comite.getSelectionModel().getSelected();
                if(r){
					if(r.data.CRSSC_ESTADO_CONVOCATORIA == TypeEstadoConvocatoria.CONCLUIDA){
						Ext.MessageBox.alert('Sesi\u00f3n de comit\u00e9', 'La sesi\u00f3n concluy\u00f3, no se puede editar la informaci\u00f3n.');
						return;
					}
					if(r.data.CRSSC_ESTADO_CONVOCATORIA == TypeEstadoConvocatoria.ANULADA){
						Ext.MessageBox.alert('Sesi\u00f3n de comit\u00e9', 'La sesi\u00f3n fue anulada, no se puede editar la informaci\u00f3n.');
						return;
					}
                    var objCgg_res_sesion_comite = new FrmCgg_res_sesion_comite("update",r);
                    objCgg_res_sesion_comite.closeHandler(function(){
                        gsCgg_res_sesion_comite.reload();
                    });
                    objCgg_res_sesion_comite.loadData();
                    objCgg_res_sesion_comite.show();
                }else{
                    Ext.MessageBox.alert('Sesi\u00f3n Comit\u00e9', 'Seleccione un registro para continuar');
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_sesion_comite.
     */
    var btnEliminarCgg_res_sesion_comite = new Ext.Button({
        id:'btnEliminarCgg_res_sesion_comite',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
		disabled:true,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_sesion_comite,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_sesion_comite(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_sesion_comite(r){
                            winFrmListadoCgg_res_sesion_comite.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_sesion_comite,
                                    msg: 'La informaci\u00f3n de la Sesi\u00f3n Comit\u00e9 ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_sesion_comite.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_sesion_comite,
                                    msg: 'La informaci\u00f3n de la Sesi\u00f3n Comit\u00e9 no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_sesion_comite.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrssc_codigo',grdCgg_res_sesion_comite.getSelectionModel().getSelected().get('CRSSC_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_sesion_comite,"delete",param, true, CallBackCgg_res_sesion_comite);
                    }catch(inErr){
                        winFrmListadoCgg_res_sesion_comite.getEl().unmask();
                    }}}

            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_sesion_comite.
     */
    var btnSalirCgg_res_sesion_comite = new Ext.Button({
        id:'btnSalirCgg_res_sesion_comite',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_res_sesion_comite.close();
            }}
    });
	var btnVotarCgg_res_sesion_comite = new Ext.Button({
		id:'btnVotarCgg_res_sesion_comite',
		text:'Votar',
		tooltip:'Registrar la votaci\u00f3n del miembro seleccionado.',
		iconCls:'iconOk',
		disabled:true,
		listeners:{
			click:function(){
				var tmpRecord;
				if(tplSesionComite.getActiveTab() == grdSCTramites)
					tmpRecord = grdSCTramites.getSelectionModel().getSelected();
				if(tplSesionComite.getActiveTab() == grdSCResoluciones)
					tmpRecord = grdSCResoluciones.getSelectionModel().getSelected();					
                if(tmpRecord){
					if(tmpRecord.data.CRRES_ESTADO_RESOLUCION != 0){
						Ext.MessageBox.alert('Sesi\u00f3n de comit\u00e9', 'No se puede registrar el voto por que el registro seleccionado dejo de estar para votaci\u00f3n.');
						return;
					}
					if(tmpRecord.data.CRVTO_VOTACION.length != 0 ){
						Ext.MessageBox.alert('Sesi\u00f3n de comit\u00e9', 'El voto ya esta registrado.');
						return;
					}
                    var objCgg_res_voto = new FrmCgg_res_voto("insert");
					if(tplSesionComite.getActiveTab() == grdSCTramites){
						tmpResoluciones = grdSCTramites.getSelectionModel().getSelections();
					}
					if(tplSesionComite.getActiveTab() == grdSCResoluciones){
						tmpResoluciones = grdSCResoluciones.getSelectionModel().getSelections();
					}
                    objCgg_res_voto.loadResolucion(tmpResoluciones);
                    objCgg_res_voto.closeHandler(function(){
						gsSCResoluciones.reload();
						gsSCTramites.reload();
                    });
                    objCgg_res_voto.show();
                }
                else{
                    Ext.MessageBox.alert('Sesi\u00f3n de comit\u00e9', 'Seleccione un registro para continuar');
                }
			}
		}
	});
    /**
     * Ext.Button Boton para obtener reportes, general o individual.
     */var btnReporteCgg_res_sesion_comite = new Ext.Toolbar.SplitButton({
        id:'btnReporteCgg_res_sesion_comite',
        name:'btnReporteCgg_res_sesion_comite',
        text:'Resoluciones',
        iconCls:'iconImprimir',
		handler:function(){
			var r = grdCgg_res_sesion_comite.getSelectionModel().getSelected();
				if(r){
					myJasperServer.addParam('P_CRSSC_CODIGO', r.data.CRSSC_CODIGO);
					myJasperServer.setReportName('rptVotosSesion');
					myJasperServer.setReportFolder('/Reports/sii/comite');
					myJasperServer.run();
				}
		},
		menu:[{text:'Todos',handler:function(){
			myJasperServer.addParam('P_CRSSC_CODIGO', '');
			myJasperServer.setReportName('rptVotosSesion');
			myJasperServer.setReportFolder('/Reports/sii/comite');
			myJasperServer.run();
		}}]
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_sesion_comite.
     */
    var cmCgg_res_sesion_comite = new Ext.grid.ColumnModel([
        {dataIndex:'CISLA_NOMBRE',header:'Isla',width:150,sortable:true},
        {dataIndex:'COMITE',header:'Comit\u00e9',width:150,sortable:true},
		{dataIndex:'CRSSC_NUMERO_SESION',header:'Numero sesi\u00f3n',width:150,sortable:true},
        {dataIndex:'CRSSC_FECHA_REUNION',header:'Fecha reuni\u00f3n',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CRSSC_FECHA_FINALIZACION',header:'Fecha finalizaci\u00f3n',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CRSSC_EXTRACTO',header:'Extracto',width:150,sortable:true},
        {dataIndex:'CRSSC_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true,hidden:true},
        {dataIndex:'CRSSC_DESCRIPCION_ADJUNTO',header:'Descripcion adjunto',width:150,sortable:true, hidden:true},
        {dataIndex:'CRSSC_NOMBRE_ADJUNTO',header:'Nombre adjunto',width:150,sortable:true},      
        {dataIndex:'CRSSC_ESTADO_CONVOCATORIA',header:'Estado convocatoria',width:150,sortable:true,renderer:function(inCrsscestadoConvocatoria){
            return dsEstadoConvocatoria[inCrsscestadoConvocatoria][1];
        }
        }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_sesion_comite por un campo especifico.
     */
    var gsCgg_res_sesion_comite = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_sesion_comite",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRSSC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRSSC_CODIGO'},
            {name:'CISLA_CODIGO'},
            {name:'CISLA_NOMBRE'},
            {name:'CRCOM_CODIGO'},
            {name:'COMITE'},
            {name:'CRSSC_FECHA_REUNION'},
            {name:'CRSSC_FECHA_FINALIZACION'},
            {name:'CRSSC_NUMERO_SESION'},
            {name:'CRSSC_EXTRACTO'},
            {name:'CRSSC_OBSERVACION'},
            {name:'CRSSC_FECHA_CONVOCATORIA'},
            {name:'CRSSC_MOTIVO_CONVOCATORIA'},
            {name:'CRSSC_DESCRIPCION_ADJUNTO'},
            {name:'CRSSC_NOMBRE_ADJUNTO'},
            {name:'CRSSC_ESTADO_CONVOCATORIA'}
        ]),
        sortInfo:{field: 'CRSSC_NUMERO_SESION', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_sesion_comite.
     */
    var pgBarCgg_res_sesion_comite= new Ext.PagingToolbar({
        store: gsCgg_res_sesion_comite,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_sesion_comite en un formato tabular de filas y columnas.
     */
    var grdCgg_res_sesion_comite = new Ext.grid.GridPanel({
		title:'Sesiones',
        cm:cmCgg_res_sesion_comite,
        store:gsCgg_res_sesion_comite,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_sesion_comite,
                width:200
            })
        ],
        bbar:pgBarCgg_res_sesion_comite,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_sesion_comite.hidden){
                    btnEditarCgg_res_sesion_comite.fireEvent('click', btnEditarCgg_res_sesion_comite);
                }
            }}});
	
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_voto.
	*/
	var chkSCTramitesDirimente = new Ext.grid.CheckColumn(
		{dataIndex:'CRCRG_VOTO_DIRIMENTE',header:'Dirimente',width:70,sortable:true}
	);
	var cmSCTramites = new Ext.grid.ColumnModel([
		{dataIndex:'TRAMITE',header:'Tramite',width:70,sortable:true,hidden:true},
		{dataIndex:'CRPER_NOMBRES',header:'Miembro',width:250,sortable:true},
		{dataIndex:'CRCRG_NOMBRE',header:'Cargo',width:150,sortable:true},
		{dataIndex:'CUSU_NOMBRE_USUARIO',header:'Usuario',width:100,sortable:true},
		{dataIndex:'VOTO',header:'Votaci\u00f3n',width:80,sortable:true},
		{dataIndex:'CRVTO_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true},
		chkSCTramitesDirimente
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_res_voto por un campo especifico.
	*/
	var gsSCTramites = new Ext.data.GroupingStore({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_res_sesion_comite",
					method:"selectTramiteVotos"
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
				root:'dataSet',
				totalProperty: 'totalCount'
			},[
				{name:'CRVTO_CODIGO'},
				{name:'CRSMB_CODIGO'},
				{name:'CRRES_CODIGO'},
				{name:'TRAMITE'},
				{name:'CRPER_NOMBRES'},
				{name:'CRCRG_NOMBRE'},
				{name:'CUSU_NOMBRE_USUARIO'},
				{name:'CRCRG_VOTO_DIRIMENTE'},
				{name:'CRVTO_VOTACION'},
				{name:'CRTRA_CODIGO'},
				{name:'VOTO'},
				{name:'CRRES_ESTADO_RESOLUCION'},
				{name:'CRVTO_OBSERVACION'}
			]),
			groupField:'TRAMITE',
			sortInfo:{field: 'CRRES_CODIGO', direction: 'ASC'},
			baseParams:{
				keyword:'',
				inCrssc_codigo:'',
				inTramites:true,
				format:'JSON'
			}
	});
	/**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_sesion_comite.
     */
    var pgBarSCTramites= new Ext.PagingToolbar({
        store: gsSCTramites,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
	var grdSCTramites = new Ext.grid.GridPanel({
		title:'Tr\u00e1mites',
        cm:cmSCTramites,
        store:gsSCTramites,
        region:'center',
		disabled:true,
		view: new Ext.grid.GroupingView({
				groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
			}),
		tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsSCTramites,
                width:200
            })
        ],
		bbar:pgBarSCTramites,
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."}
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_voto.
	*/
	var chkSCResolucionesDirimente = new Ext.grid.CheckColumn(
		{dataIndex:'CRCRG_VOTO_DIRIMENTE',header:'Dirimente',width:70,sortable:true}
	);
	var cmSCResoluciones = new Ext.grid.ColumnModel([
		{dataIndex:'CRRES_EXTRACTO_RESOLUCION',header:'Resoluci\u00f3n',width:150,sortable:true,hidden:true},
		{dataIndex:'CRPER_NOMBRES',header:'Miembro',width:250,sortable:true},
		{dataIndex:'CRCRG_NOMBRE',header:'Cargo',width:150,sortable:true},
		{dataIndex:'CUSU_NOMBRE_USUARIO',header:'Usuario',width:100,sortable:true},
		{dataIndex:'VOTO',header:'Votaci\u00f3n',width:80,sortable:true},
		{dataIndex:'CRVTO_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true},
		chkSCResolucionesDirimente
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_res_voto por un campo especifico.
	*/
	var gsSCResoluciones = new Ext.data.GroupingStore({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_res_sesion_comite",
					method:"selectTramiteVotos"
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
				root:'dataSet',
				totalProperty: 'totalCount'
			},[
				{name:'CRVTO_CODIGO'},
				{name:'CRSMB_CODIGO'},
				{name:'CRRES_CODIGO'},
				{name:'CRRES_EXTRACTO_RESOLUCION'},
				{name:'CRPER_NOMBRES'},
				{name:'CUSU_NOMBRE_USUARIO'},
				{name:'CRCRG_NOMBRE'},
				{name:'CRVTO_VOTACION'},
				{name:'CRCRG_VOTO_DIRIMENTE'},
				{name:'CRTRA_CODIGO'},
				{name:'VOTO'},
				{name:'CRRES_ESTADO_RESOLUCION'},
				{name:'CRVTO_OBSERVACION'}
			]),
			groupField:'CRRES_EXTRACTO_RESOLUCION',
			sortInfo:{field: 'CRRES_CODIGO', direction: 'ASC'},
			baseParams:{
				keyword:'',
				inCrssc_codigo:'',
				inTramites:false,
				format:'JSON'
			}
	});
	/**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_sesion_comite.
     */
    var pgBarSCResoluciones= new Ext.PagingToolbar({
        store: gsSCResoluciones,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
	var grdSCResoluciones = new Ext.grid.GridPanel({
		title:'Resoluciones',
        cm:cmSCResoluciones,
        store:gsSCResoluciones,
		disabled:true,
		tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsSCResoluciones,
                width:200
            })
        ],
		view: new Ext.grid.GroupingView({
				groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
			}),
		bbar:pgBarSCResoluciones,
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."}
	});		
	var tplSesionComite = new Ext.TabPanel({
		activeTab:0,
		region:'center',
		tabPosition:'bottom',
		items:[grdCgg_res_sesion_comite,grdSCTramites,grdSCResoluciones]
	});
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_sesion_comite.
     */
    if(inDesktop){
		gsCgg_res_sesion_comite.reload({params:{
			start:0,
			limit:RECORD_PAGE
		}
		});
		
		grdSCResoluciones.getSelectionModel().on("selectionchange",function(inSelectionModel){
			btnVotarCgg_res_sesion_comite.setDisabled(!inSelectionModel.hasSelection());
		});
		
		grdSCTramites.getSelectionModel().on("selectionchange",function(inSelectionModel){
			btnVotarCgg_res_sesion_comite.setDisabled(!inSelectionModel.hasSelection());
		});
		
		grdCgg_res_sesion_comite.getSelectionModel().on("selectionchange",function(inSelectionModel){
			var tmpRecord = grdCgg_res_sesion_comite.getSelectionModel().getSelected();
			btnEliminarCgg_res_sesion_comite.setDisabled(!inSelectionModel.hasSelection());
			btnEditarCgg_res_sesion_comite.setDisabled(!inSelectionModel.hasSelection());
			grdSCTramites.setDisabled(!inSelectionModel.hasSelection());
			grdSCResoluciones.setDisabled(!inSelectionModel.hasSelection());
			
			if(tmpRecord){
				gsSCTramites.baseParams.inCrssc_codigo = tmpRecord.data.CRSSC_CODIGO;
				gsSCTramites.reload({params:{
					start:0,
					limit:RECORD_PAGE,
					inCrssc_codigo:tmpRecord.data.CRSSC_CODIGO
				}
				});
				gsSCResoluciones.baseParams.inCrssc_codigo = tmpRecord.data.CRSSC_CODIGO;
				gsSCResoluciones.reload({params:{
					start:0,
					limit:RECORD_PAGE,
					inCrssc_codigo:tmpRecord.data.CRSSC_CODIGO
				}
				});
			}
		});
		
        var winFrmListadoCgg_res_sesion_comite = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_sesion_comite',
            title:tituloListadoCgg_res_sesion_comite,
            tbar:getPanelTitulo(tituloListadoCgg_res_sesion_comite,descListadoCgg_res_sesion_comite),
            items:[tplSesionComite],
            width:700,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_sesion_comite,btnEditarCgg_res_sesion_comite,btnEliminarCgg_res_sesion_comite,'-',btnReporteCgg_res_sesion_comite,'->',btnSalirCgg_res_sesion_comite]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_res_sesion_comite.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_sesion_comite.
     * @returns ventana winFrmCgg_res_sesion_comite.
     * @base FrmListadoCgg_res_sesion_comite.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_sesion_comite;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_sesion_comite.
     * @base FrmListadoCgg_res_sesion_comite.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_sesion_comite.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_sesion_comite;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_sesion_comite;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_sesion_comite.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_sesion_comite.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_sesion_comite desde una instancia.
 */
FrmListadoCgg_res_sesion_comite.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_sesion_comite desde una instancia.
 */
FrmListadoCgg_res_sesion_comite.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_sesion_comite,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_sesion_comite.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_sesion_comite desde una instancia.
 */
FrmListadoCgg_res_sesion_comite.prototype.loadData = function(){
    this.loadData();
}
