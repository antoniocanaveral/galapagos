/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_tct_ingreso_fallido.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_tct_ingreso_fallido(inDesktop){
    var optMenu = 'TCT/Ingresos fallidos';
    var urlListadoCgg_tct_ingreso_fallido=URL_WS+"Cgg_tct_ingreso_fallido";
    var tituloListadoCgg_tct_ingreso_fallido='Listado de ingresos fallidos';
    var descListadoCgg_tct_ingreso_fallido='El formulario permite administrar informaci\u00f3n del ingreso fallido';
	var myJasperServer = new JasperServer();
	/*var gsCgg_kdx_especie = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_especie",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({
            id:'CKESP_CODIGO'
        },[
            {name:'CKESP_CODIGO'},
            {name:'CKESP_NOMBRE'},
            {name:'CKESP_PRECIO'},
            {name:'CKESP_CANTIDAD'},
            {name:'CKESP_DISPONIBLE_MIN'},
            {name:'CKESP_DISPONIBLE_MAX'},
            {name:'CKESP_TIPO'},
			{name:'CKESP_INDICE'},
			{name:'CKESP_REPORTE'}
        ]),
        baseParams:{format:"JSON",inCkesp_tipo:TypeEspecie.TCT}
    });
	gsCgg_kdx_especie.load();*/
	
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_tct_ingreso_fallido.
     */
    var btnEliminarCgg_tct_ingreso_fallido = new Ext.Button({
        id:'btnEliminarCgg_tct_ingreso_fallido',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_tct_ingreso_fallido,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_tct_ingreso_fallido(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_tct_ingreso_fallido(r){
                            winFrmListadoCgg_tct_ingreso_fallido.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_tct_ingreso_fallido,
                                    msg: 'La informaci\u00f3n de Tct ingreso fallido ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_tct_ingreso_fallido.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_tct_ingreso_fallido,
                                    msg: 'La informaci\u00f3n de Tct ingreso fallido no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_tct_ingreso_fallido.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCtigf_codigo',grdCgg_tct_ingreso_fallido.getSelectionModel().getSelected().get('CTIGF_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_tct_ingreso_fallido,"delete",param, true, CallBackCgg_tct_ingreso_fallido);
                    }catch(inErr){
                        winFrmListadoCgg_tct_ingreso_fallido.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_tct_ingreso_fallido.
     */
    var btnSalirCgg_tct_ingreso_fallido = new Ext.Button({
        id:'btnSalirCgg_tct_ingreso_fallido',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_tct_ingreso_fallido.close();
            }}
    });
    /**
     * Ext.Button Boton para obtener reportes, general o individual.
     */var btnReporteCgg_tct_ingreso_fallido = new Ext.Button({
        id:'btnReporteCgg_tct_ingreso_fallido',
        name:'btnReporteCgg_tct_ingreso_fallido',
        text:'Imprimir especie',
        iconCls:'iconImprimir',
        listeners:{
			click:function(){
				var tmpRecord = grdCgg_tct_ingreso_fallido.getSelectionModel().getSelected();
				if(tmpRecord){
					printEspecie(SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF50')).get('CGCNF_VALOR_CADENA'), tmpRecord);
				}
			}
		}
    });
	function printEspecie(inCKESP_CODIGO, inRecord){
		function CallBackVentaEspecie(inResponse){
			if(inResponse == 'true'){
				myJasperServer.addParam('P_CTIGF_CODIGO',inRecord.data.CTIGF_CODIGO);
				myJasperServer.setReportFolder('/Reports/sii/tct');
				myJasperServer.setReportName(SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO','CONF37')).get('CGCNF_VALOR_CADENA'));
				myJasperServer.run();
				gsCgg_tct_ingreso_fallido.reload();
			}else{
				Ext.Msg.show({
					title:tituloListadoCgg_tct_ingreso_fallido,
					msg: 'No se ha podido imprimir el registro seleccionado. '+(inResponse.message?inResponse.message:inResponse),
					buttons: Ext.Msg.OK,
					icon: Ext.MessageBox.ERROR
				});
			}
		}
		var param = new SOAPClientParameters();
		param.add('inCkesp_codigo',inCKESP_CODIGO);
        param.add('inCtreg_codigo',inRecord.data.CTIGF_CODIGO);
        param.add('inAmbito',TypeAmbitoEspecie.INTF);
		SOAPClient.invoke(URL_WS+'Cgg_kdx_venta_detalle','ventaRegistro',param, true, CallBackVentaEspecie);
	}
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_tct_ingreso_fallido.
     */
    var cmCgg_tct_ingreso_fallido = new Ext.grid.ColumnModel([
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'Documento',width:100},
        {dataIndex:'CRPER_NOMBRE_PERSONA',header:'Persona',width:200,sortable:true},
        {dataIndex:'CARPT_NOMBRE_INGRESO',header:'Aeropuerto',width:150,sortable:true},
		{dataIndex:'CTIGF_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
        {dataIndex:'CTIGF_FECHA_INTENTO',header:'Fecha',width:120,sortable:true,renderer:truncDateTime},
        {dataIndex:'CKVDT_FECHA_UPDATE',header:'Impresi\u00f3n',width:120,sortable:true,renderer:truncDateTime}        
	]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_tct_ingreso_fallido por un campo especifico.
     */
    var gsCgg_tct_ingreso_fallido = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_tct_ingreso_fallido",
            method:"selectIngresoFallido",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CTIGF_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CTIGF_CODIGO'},
            {name:'CRPER_CODIGO'},
            {name:'CRPER_NOMBRE_PERSONA'},
			{name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CARPT_CODIGO'},
            {name:'CARPT_NOMBRE_INGRESO'},
            {name:'CTIGF_FECHA_INTENTO'},
            {name:'CTIGF_TIPO_INGRESO_FALLIDO'},
            {name:'CTIGF_DESCRIPCION'},
			{name:'CKVDT_FECHA_UPDATE'}
        ]),
        sortInfo:{field: 'CTIGF_FECHA_INTENTO', direction: 'DESC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_tct_ingreso_fallido.
     */
    var pgBarCgg_tct_ingreso_fallido= new Ext.PagingToolbar({
        store: gsCgg_tct_ingreso_fallido,
        displayInfo: true,
        pageSize:(RECORD_PAGE - 10),
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_tct_ingreso_fallido en un formato tabular de filas y columnas.
     */
    var grdCgg_tct_ingreso_fallido = new Ext.grid.GridPanel({
        cm:cmCgg_tct_ingreso_fallido,
        store:gsCgg_tct_ingreso_fallido,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_tct_ingreso_fallido,
                width:200
            })
        ],
        bbar:pgBarCgg_tct_ingreso_fallido
      });
    gsCgg_tct_ingreso_fallido.reload({params:{
        start:0,
        limit:(RECORD_PAGE - 10),
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_tct_ingreso_fallido.
     */
    var winFrmListadoCgg_tct_ingreso_fallido = inDesktop.createWindow({
        id:'winFrmListadoCgg_tct_ingreso_fallido',
        title:tituloListadoCgg_tct_ingreso_fallido,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo(tituloListadoCgg_tct_ingreso_fallido,descListadoCgg_tct_ingreso_fallido),
        items:[grdCgg_tct_ingreso_fallido],
        bbar:[btnReporteCgg_tct_ingreso_fallido,'->',btnSalirCgg_tct_ingreso_fallido]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_tct_ingreso_fallido.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_tct_ingreso_fallido.
     * @returns ventana winFrmCgg_tct_ingreso_fallido.
     * @base FrmListadoCgg_tct_ingreso_fallido.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_tct_ingreso_fallido;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_tct_ingreso_fallido.
     * @base FrmListadoCgg_tct_ingreso_fallido.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_tct_ingreso_fallido.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_tct_ingreso_fallido;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_tct_ingreso_fallido;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_tct_ingreso_fallido.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_tct_ingreso_fallido.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_tct_ingreso_fallido desde una instancia.
 */
FrmListadoCgg_tct_ingreso_fallido.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_tct_ingreso_fallido desde una instancia.
 */
FrmListadoCgg_tct_ingreso_fallido.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_tct_ingreso_fallido,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_tct_ingreso_fallido.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_tct_ingreso_fallido desde una instancia.
 */
FrmListadoCgg_tct_ingreso_fallido.prototype.loadData = function(){
    this.loadData();
}
