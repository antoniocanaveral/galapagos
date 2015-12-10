/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_resolucion.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_resolucion(inDesktop){
    var optMenu = 'Comite/Resoluciones';
    var urlListadoCgg_res_resolucion=URL_WS+"Cgg_res_resolucion";
    var tituloListadoCgg_res_resolucion='Listado de resoluciones';
    var descListadoCgg_res_resolucion='El formulario permite administrar informaci\u00f3n de las resoluciones emitidas por los comites.';
	var myJasperServer = new JasperServer();
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_resolucion.
     */
    var btnNuevoCgg_res_resolucion = new Ext.Button({
        id:'btnNuevoCgg_res_resolucion',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_resolucion = new FrmCgg_res_resolucion("insert");
                objCgg_res_resolucion.closeHandler(function(){
                    gsCgg_res_resolucion.reload();
                });
                objCgg_res_resolucion.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_resolucion.
     */
    var btnEditarCgg_res_resolucion = new Ext.Button({
        id:'btnEditarCgg_res_resolucion',
        text:'Editar',
        iconCls:'iconEditar',
		disabled:true,
        listeners:{
            click:function(){
                var r=grdCgg_res_resolucion.getSelectionModel().getSelected();
                if(r.data.CRRES_ESTADO_RESOLUCION == 4){
                	Ext.MessageBox.alert(tituloListadoCgg_res_resolucion, 'La resoluci\u00f3n esta anulada y no se puede editar.');
                	return;
                }
                if(r){
                    var objCgg_res_resolucion = new FrmCgg_res_resolucion("update",r);
                    objCgg_res_resolucion.closeHandler(function(){
                        gsCgg_res_resolucion.reload();
                    });
                    objCgg_res_resolucion.loadData();
                    objCgg_res_resolucion.show();
                }
                else{
                    Ext.MessageBox.alert('Resoluci\u00f3n', 'Seleccione un registro para continuar');
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_resolucion.
     */
    var btnEliminarCgg_res_resolucion = new Ext.Button({
        id:'btnEliminarCgg_res_resolucion',
        text:'Eliminar',
        iconCls:'iconEliminar',
		disabled:true,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_resolucion,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_resolucion(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_resolucion(r){
                            winFrmListadoCgg_res_resolucion.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_resolucion,
                                    msg: 'La informaci\u00f3n de la Resoluci\u00f3n ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_resolucion.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_resolucion,
                                    msg: 'La informaci\u00f3n de la Resoluci\u00f3n no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_resolucion.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrres_codigo',grdCgg_res_resolucion.getSelectionModel().getSelected().get('CRRES_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_resolucion,"delete",param, true, CallBackCgg_res_resolucion);
                    }catch(inErr){
                        winFrmListadoCgg_res_resolucion.getEl().unmask();
                    }}}
            }}
    });
    var btnAnularCgg_res_resolucion = new Ext.Button({
    	id:'btnAnularCgg_res_resolucion',
    	text:'Anular',
    	disabled:true,
    	iconCls:'iconAnularTramite',
    	listeners:{
    		click:function(){
    			Ext.Msg.show({title:'Aviso', msg:'Seguro de anular el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_resolucion_anular,icon: Ext.MessageBox.QUESTION});
    			function SWRCgg_res_resolucion_anular(btn){if (btn=='yes'){
				function CallBackCgg_res_resolucion_anulacion(inResponse){
					winFrmListadoCgg_res_resolucion.getEl().unmask();
					if(inResponse == 'true'){
						Ext.Msg.show({
							title:tituloListadoCgg_res_resolucion,
							msg: 'La resoluci\u00f3n ha sido anulada.',
							buttons: Ext.Msg.OK,
							icon: Ext.MessageBox.INFO
						});
					}else{
						Ext.Msg.show({
							title:tituloListadoCgg_res_resolucion,
							msg: 'La resoluci\u00f3n no ha sido anulada. '+(inResponse.message?inResponse.message:inResponse),
							buttons: Ext.Msg.OK,
							icon: Ext.MessageBox.ERROR
						});
					}
				}
				winFrmListadoCgg_res_resolucion.getEl().mask('Anulando ...', 'x-mask-loading');
				var param = new SOAPClientParameters();
				param.add('inCrres_codigo',grdCgg_res_resolucion.getSelectionModel().getSelected().get('CRRES_CODIGO'));
				SOAPClient.invoke(urlListadoCgg_res_resolucion,'anular',param, true, CallBackCgg_res_resolucion_anulacion);
                        	}
                        }
    		}
    	}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_resolucion.
     */
    var btnSalirCgg_res_resolucion = new Ext.Button({
        id:'btnSalirCgg_res_resolucion',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_resolucion.close();
            }}
    });
    /**
     * Ext.Button Boton para obtener reportes, general o individual.
     */var btnReporteCgg_res_resolucion = new Ext.Button({
        id:'btnReporteCgg_res_resolucion',
        name:'btnReporteCgg_res_resolucion',
        text:'Votos',
        iconCls:'iconImprimir',
		disabled:true,
        listeners:{
			click:function(){
				var r = grdCgg_res_resolucion.getSelectionModel().getSelected();
				myJasperServer.addParam('P_CRRES_CODIGO', r.data.CRRES_CODIGO);
				myJasperServer.setReportName('rptVotosSesion');
				myJasperServer.setReportFolder('/Reports/sii/comite');
				myJasperServer.run();
			}
		}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_resolucion.
     */
    var cmCgg_res_resolucion = new Ext.grid.ColumnModel([
        {dataIndex:'NUMERO',header:'Tr\u00e1mite',width:150,sortable:true},
        {dataIndex:'CRSSC_NUMERO_SESION',header:'Sesi\u00f3n',width:150,sortable:true},
        {dataIndex:'CRRES_NUMERO_RESOLUCION',header:'N\u00famero',width:150,sortable:true},
        {dataIndex:'CRRES_TIPO',header:'Tipo',width:150,sortable:true, renderer:function(inCrres_Tipo){
            return dsTipoResolucion[inCrres_Tipo][1];
        }},
        {dataIndex:'CRRES_OBSERVACIONES',header:'Observaciones',width:150,sortable:true,hidden:true},
        {dataIndex:'CRRES_EXTRACTO_RESOLUCION',header:'Extracto',width:150,sortable:true},
        {dataIndex:'CRRES_VOTOS_APROBACION',header:'Votos aprobaci\u00f3n',width:150,sortable:true},
        {dataIndex:'CRRES_VOTOS_NEGACION',header:'Votos negaci\u00f3n',width:150,sortable:true},
        {dataIndex:'CRRES_VOTOS_ABSTENCION',header:'Votos abstenci\u00f3n',width:150,sortable:true},
        {dataIndex:'CRRES_FECHA_EMISION',header:'Fecha emisi\u00f3n',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CRRES_FECHA_EJECUCION',header:'Fecha ejecucion',width:150,sortable:true,hidden:true,renderer:truncDate},
        {dataIndex:'CRRES_FECHA_ANULACION',header:'Fecha anulacion',width:150,sortable:true,hidden:true,renderer:truncDate},
        {dataIndex:'CRRES_RESOLUCION_REEMPLAZA',header:'Resolucion reemplaza',width:150,sortable:true,hidden:true},
        {dataIndex:'CRRES_DESCRIPCION_ADJUNTO',header:'Descripcion adjunto',width:150,sortable:true,hidden:true},
        {dataIndex:'CRRES_FECHA_APELACION',header:'Fecha apelacion',width:150,sortable:true,hidden:true,renderer:truncDate},
        {dataIndex:'CRRES_EXTRACTO_APELACION',header:'Extracto apelacion',width:150,sortable:true,hidden:true},
        {dataIndex:'CRRES_NUMERO_APELACION',header:'Numero apelacion',width:150,sortable:true,hidden:true},
        {dataIndex:'CRRES_ESTADO_RESOLUCION',header:'Estado resolucion',width:150,sortable:true, renderer:function(inCrres_estado){
            return dsEstadoResolucion[inCrres_estado][1];
        }
        }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_resolucion por un campo especifico.
     */
    var gsCgg_res_resolucion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_resolucion",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRRES_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRRES_CODIGO'},            
            {name:'NUMERO'},
            {name:'CRSSC_CODIGO'},
            {name:'CRSSC_NUMERO_SESION'},
            {name:'CRRES_NUMERO_RESOLUCION'},
            {name:'CRRES_TIPO'},
            {name:'CRRES_OBSERVACIONES'},
            {name:'CRRES_EXTRACTO_RESOLUCION'},
            {name:'CRRES_VOTOS_APROBACION'},
            {name:'CRRES_VOTOS_NEGACION'},
            {name:'CRRES_VOTOS_ABSTENCION'},
            {name:'CRRES_FECHA_EMISION'},
            {name:'CRRES_FECHA_EJECUCION'},
            {name:'CRRES_FECHA_ANULACION'},
            {name:'CRRES_RESOLUCION_REEMPLAZA'},
            {name:'CRRES_NOMBRE_ADJUNTO_RESOL'},
            {name:'CRRES_DESCRIPCION_ADJUNTO'},
            {name:'CRRES_FECHA_APELACION'},
            {name:'CRRES_EXTRACTO_APELACION'},
            {name:'CRRES_NUMERO_APELACION'},
            {name:'CRRES_NOMBRE_ADJUNTO_APELAC'},                           
            {name:'CRRES_ESTADO_RESOLUCION'}
        ]),        
        sortInfo:{field: 'CRRES_FECHA_EMISION', direction: 'DESC'},
        baseParams:{keyword:"",
			format:'JSON',
			inCrres_estado_resolucion:-1,
			inCrssc_codigo:''}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_resolucion.
     */
    var pgBarCgg_res_resolucion= new Ext.PagingToolbar({
        store: gsCgg_res_resolucion,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_resolucion en un formato tabular de filas y columnas.
     */
    var grdCgg_res_resolucion = new Ext.grid.GridPanel({
        cm:cmCgg_res_resolucion,
        store:gsCgg_res_resolucion,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_resolucion,
                width:200
            })
        ],
        bbar:pgBarCgg_res_resolucion,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_resolucion.hidden){
                    btnEditarCgg_res_resolucion.fireEvent('click', btnEditarCgg_res_resolucion);
                }
            }}});
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_resolucion.
     */
    if(inDesktop){
		gsCgg_res_resolucion.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
		});
		
		grdCgg_res_resolucion.getSelectionModel().on("selectionchange",function(inSelectionModel){
			btnEditarCgg_res_resolucion.setDisabled(!inSelectionModel.hasSelection());
			btnEliminarCgg_res_resolucion.setDisabled(!inSelectionModel.hasSelection());
			btnAnularCgg_res_resolucion.setDisabled(!inSelectionModel.hasSelection());
			btnReporteCgg_res_resolucion.setDisabled(!inSelectionModel.hasSelection());
		});
		
        var winFrmListadoCgg_res_resolucion = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_resolucion',
            title:tituloListadoCgg_res_resolucion,
            tbar:getPanelTitulo(tituloListadoCgg_res_resolucion,descListadoCgg_res_resolucion),
            items:[grdCgg_res_resolucion],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_resolucion,btnEditarCgg_res_resolucion,btnEliminarCgg_res_resolucion,'-',btnAnularCgg_res_resolucion,btnReporteCgg_res_resolucion,'->',btnSalirCgg_res_resolucion]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_res_resolucion.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_resolucion.
     * @returns ventana winFrmCgg_res_resolucion.
     * @base FrmListadoCgg_res_resolucion.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_resolucion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_resolucion.
     * @base FrmListadoCgg_res_resolucion.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_resolucion.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_resolucion;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_resolucion;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_resolucion.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_resolucion.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_resolucion desde una instancia.
 */
FrmListadoCgg_res_resolucion.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_resolucion desde una instancia.
 */
FrmListadoCgg_res_resolucion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_resolucion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_resolucion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_resolucion desde una instancia.
 */
FrmListadoCgg_res_resolucion.prototype.loadData = function(){
    this.loadData();
}
