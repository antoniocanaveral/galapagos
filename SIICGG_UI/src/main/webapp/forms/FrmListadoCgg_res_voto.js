/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_voto.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_voto(inDesktop){
    var optMenu = 'Comit\u00e9/Votaci\u00f3n';
    var urlListadoCgg_res_voto=URL_WS+"Cgg_res_voto";
    var tituloListadoCgg_res_voto='Votaci\u00f3n';
    var descListadoCgg_res_voto='El formulario permite registrar los votos de los miembros asistentes a una sesi\u00f3n.';
    var tmpUsuario=new UserSession();
    var tmpResoluciones;
	var tmpSW = true;
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_voto.
     */
    var btnNuevoCgg_res_voto = new Ext.Button({
        id:'btnNuevoCgg_res_voto',
        text:'Votar',
        iconCls:'iconOk',
        listeners:{
            click:function(){
                var r = grdCgg_res_resolucion.getSelectionModel().getSelected();
				if(!r)
					r = grdCgg_res_votoResolucion.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_voto = new FrmCgg_res_voto("insert");
					if(tabVotos.getActiveTab() == grdCgg_res_votoResolucion){
						tmpResoluciones = smVotoResolucion.getSelections();
					}else{
						tmpResoluciones = smResolucion.getSelections();
					}
                    objCgg_res_voto.loadResolucion(tmpResoluciones);
                    objCgg_res_voto.closeHandler(function(){
						if(tabVotos.getActiveTab() == grdCgg_res_votoResolucion)
							gsCgg_res_votoResolucion.reload();
						else
							gsCgg_res_resolucion_votacion.reload();
                    });
                    objCgg_res_voto.show();
                }
                else{
                    Ext.MessageBox.alert('Voto', 'Seleccione un registro para continuar');
                }
            }}

    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_voto.
     */
    var btnSalirCgg_res_voto = new Ext.Button({
        id:'btnSalirCgg_res_voto',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_voto.close();
            }}
    });
    /**
     * Ext.grid.CheckboxSelectionModel Seleccion de las resoluciones para emitir los votos
     */
    var smResolucion = new Ext.grid.CheckboxSelectionModel();
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_resolucion y la seleccion de las resoluciones de esperando votacion.
     */
    var cmCgg_res_resolucion_votacion = new Ext.grid.ColumnModel([
        smResolucion,
        {dataIndex:'NUMERO',header:'Tr\u00e1mite',width:50,sortable:true},
        {dataIndex:'CRRES_NUMERO_RESOLUCION',header:'Numero resoluci\u00f3n',width:150,sortable:true,hidden:true},
        {dataIndex:'TIPO_TRAMITE',header:'Tipo',width:350,sortable:true},
		{dataIndex:'BENEFICIARIO',header:'Beneficiario',width:200,sortable:true},
		{dataIndex:'ACTIVIDAD',header:'Actividad',width:100,sortable:true},
		{id:'clmTipoVeh',dataIndex:'CVCTG_NOMBRE',header:'Tipo de veh.',width:100,sortable:true},
        {dataIndex:'CRRES_FECHA_EMISION',header:'Fecha emisi\u00f3n',width:150,sortable:true,renderer:truncDate,hidden:true},
        {dataIndex:'TOTAL',header:'Asistentes',width:150,sortable:true},
        {dataIndex:'RESOL_VOTO',header:'Resol_voto',width:150,sortable:true,hidden:true}
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_resolucion por un campo especifico.
     */
    var gsCgg_res_resolucion_votacion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_resolucion",
            method:"selectVoto",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRRES_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRRES_CODIGO'},
            {name:'CRTRA_CODIGO'},
            {name:'NUMERO'},
			{name:'TIPO_TRAMITE'},
            {name:'CRSSC_CODIGO'},
            {name:'CRSMB_CODIGO'},
            {name:'CRRES_NUMERO_RESOLUCION'},
            {name:'CRRES_TIPO'},
            {name:'CRRES_EXTRACTO_RESOLUCION'},
            {name:'CRRES_VOTOS_APROBACION'},
            {name:'CRRES_VOTOS_NEGACION'},
            {name:'CRRES_VOTOS_ABSTENCION'},
            {name:'CRRES_FECHA_EMISION'},
            {name:'CRRES_NOMBRE_ADJUNTO_RESOL'},
            {name:'CRRES_ESTADO_RESOLUCION'},
            {name:'TOTAL'},
            {name:'NUMERO_VOTO'},
            {name:'RESOL_VOTO'},
			{name:'ACTIVIDAD'},
			{name:'CVCTG_NOMBRE'},
			{name:'BENEFICIARIO'}
        ]),
        sortInfo:{field: 'CRRES_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON',inSW:true},
        listeners:{
            load:function (inStore, inRecords, inOptions){
				if(inRecords.length > 0){
					if(inRecords[0].get('CVCTG_NOMBRE') && inRecords[0].get('CVCTG_NOMBRE').length == 0){
						if(tmpSW)
							cmCgg_res_resolucion_votacion.setHidden(6,true);
						tmpSW = false;
					}else if(!inRecords[0].get('CVCTG_NOMBRE')) {
						if(tmpSW)
							cmCgg_res_resolucion_votacion.setHidden(6,true);
						tmpSW = false;
					}
				}
                for (i = 0; i < inRecords.length; i++){
                    var tmpTotal = inRecords[i].get('TOTAL');
                    var tmpNumero_voto = inRecords[i].get('NUMERO_VOTO');
                    if( grdCgg_res_resolucion.getView().getRow(i))
                        grdCgg_res_resolucion.getView().getRow(i).style.backgroundColor = Fade(255,255,255,145,255,172,tmpTotal,tmpNumero_voto);
                }
            }
        }
    });
	if(SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF29')).get('CGCNF_VALOR_CADENA') != 'SI'){
		cmCgg_res_resolucion_votacion.setHidden(4,true);
	}
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_voto.
     */
    var pgBarCgg_res_resolucion= new Ext.PagingToolbar({
        store: gsCgg_res_resolucion_votacion,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_voto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_resolucion = new Ext.grid.GridPanel({
		title:'Tr\u00e1mites',
        cm:cmCgg_res_resolucion_votacion,
        store:gsCgg_res_resolucion_votacion,
        region:'center',
        sm:smResolucion,
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_resolucion_votacion,
                width:200
            })
        ],
        bbar:pgBarCgg_res_resolucion,
        listeners:{
            rowclick :function(inGrid,inNumero,inObjeto){
                if (grdCgg_res_resolucion.getSelectionModel().getSelected().get('RESOL_VOTO')==1){
                    btnNuevoCgg_res_voto.disable();
                }else{
                    btnNuevoCgg_res_voto.enable();
                }
            }
        }

    });
    gsCgg_res_resolucion_votacion.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
	/////////////////////////////////////////////RESOLUCIONES///////////////////////////////////
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_voto.
	*/
	var smVotoResolucion = new Ext.grid.CheckboxSelectionModel();
	
	var cmCgg_res_votoResolucion = new Ext.grid.ColumnModel([
		smVotoResolucion,
			{dataIndex:'CRRES_TIPO',header:'Tipo',width:150,sortable:true,renderer:function(inTipo){
				return dsTipoResolucion[inTipo][1];
			}},
		{dataIndex:'CRRES_OBSERVACIONES',header:'Observaci\u00f3n',width:250,sortable:true},
		{dataIndex:'TOTAL',header:'Asistentes',width:150,sortable:true},]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_res_voto por un campo especifico.
	*/
	var gsCgg_res_votoResolucion = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_res_resolucion",
					method:"selectVoto",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CRVTO_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CRVTO_CODIGO'},
				{name:'CRSMB_CODIGO'},
				{name:'CRTRA_CODIGO'},
				{name:'CRRES_TIPO'},
				{name:'TOTAL'},
				{name:'CRRES_OBSERVACIONES'},
				{name:'CRRES_CODIGO'},
				{name:'CRVTO_VOTACION'},
				{name:'NUMERO_VOTO'},
				{name:'CRVTO_OBSERVACION'}
			]),
			sortInfo:{field: 'CRSMB_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON',inSW:false}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_voto.
	*/
	var pgBarCgg_res_votoResolucion= new Ext.PagingToolbar({
			store: gsCgg_res_votoResolucion,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_voto en un formato tabular de filas y columnas.
	*/
	var grdCgg_res_votoResolucion = new Ext.grid.GridPanel({
		title:'Resoluciones',
			cm:cmCgg_res_votoResolucion,
			store:gsCgg_res_votoResolucion,
			region:'center',
			sm:smVotoResolucion,
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_res_votoResolucion,
						width:200
				})
			],
			bbar:pgBarCgg_res_votoResolucion,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_res_voto.hidden){
						btnEditarCgg_res_voto.fireEvent('click', btnEditarCgg_res_voto);
					}
	}}});
	gsCgg_res_votoResolucion.reload({params:{
			start:0,
			limit:RECORD_PAGE
		}
	});
	////////////////////////////////////////////////////////////////////////////////////////////
	var tabVotos = new Ext.TabPanel({
		activeTab:0,
		tabPosition:'bottom',
		region:'center',
		items:[grdCgg_res_resolucion,grdCgg_res_votoResolucion]
	});
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_voto.
     */
    if(inDesktop){
        var winFrmListadoCgg_res_voto = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_voto',
            title:tituloListadoCgg_res_voto,
            tbar:getPanelTitulo(tituloListadoCgg_res_voto,descListadoCgg_res_voto),
            items:[tabVotos],
            width:700,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_voto,'->',btnSalirCgg_res_voto]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_res_voto.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_voto.
     * @returns ventana winFrmCgg_res_voto.
     * @base FrmListadoCgg_res_voto.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_voto;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_voto.
     * @base FrmListadoCgg_res_voto.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_resolucion_votacion.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_resolucion_votacion;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_resolucion_votacion;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_voto.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_voto.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_voto desde una instancia.
 */
FrmListadoCgg_res_voto.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_voto desde una instancia.
 */
FrmListadoCgg_res_voto.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_voto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_voto.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_voto desde una instancia.
 */
FrmListadoCgg_res_voto.prototype.loadData = function(){
    this.loadData();
}
