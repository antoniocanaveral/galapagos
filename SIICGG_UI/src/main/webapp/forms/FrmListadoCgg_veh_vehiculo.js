/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_veh_vehiculo.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_veh_vehiculo(inDesktop){
	var optMenu = 'Vehiculos/Vehiculos';
    var urlListadoCgg_veh_vehiculo=URL_WS+"Cgg_veh_vehiculo";
	var tituloListadoCgg_veh_vehiculo='Listado de veh\u00edculos';
	var descListadoCgg_veh_vehiculo='El formulario permite administrar informaci\u00f3n de los veh\u00edculos registrados.';
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_veh_color por un campo especifico.
	*/
	var gsCgg_veh_color = new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_veh_color",
			method:"selectPageDirect"
		}),
		remoteSort:true,
		reader:new Ext.data.JsonReader({
			id:'CVCLR_CODIGO',
			root:'dataSet',
			totalProperty: 'totalCount'
		},[
			{name:'CVCLR_CODIGO'},
			{name:'CVCLR_NOMBRE'},
		]),
		sortInfo:{field: 'CVCLR_NOMBRE', direction: 'ASC'},
		baseParams:{keyword:"",format:'JSON'}
	});
	gsCgg_veh_color.baseParams.start = 0;
	gsCgg_veh_color.baseParams.limit = 1000;
	gsCgg_veh_color.reload();
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_veh_vehiculo.
	*/
	var btnNuevoCgg_veh_vehiculo = new Ext.Button({
			id:'btnNuevoCgg_veh_vehiculo',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_veh_vehiculo = new FrmCgg_veh_vehiculo("insert");
					objCgg_veh_vehiculo.setStoreColor(gsCgg_veh_color);
					objCgg_veh_vehiculo.closeHandler(function(){
							gsCgg_veh_vehiculo.reload();
					});
					objCgg_veh_vehiculo.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_veh_vehiculo.
	*/
	var btnEditarCgg_veh_vehiculo = new Ext.Button({
			id:'btnEditarCgg_veh_vehiculo',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_veh_vehiculo.getSelectionModel().getSelected();
					if(r){
						var objCgg_veh_vehiculo = new FrmCgg_veh_vehiculo("update",r);
						objCgg_veh_vehiculo.setStoreColor(gsCgg_veh_color);
						objCgg_veh_vehiculo.closeHandler(function(){
								gsCgg_veh_vehiculo.reload();
						});
						objCgg_veh_vehiculo.loadData();
						objCgg_veh_vehiculo.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_veh_vehiculo.
	*/
	var btnEliminarCgg_veh_vehiculo = new Ext.Button({
			id:'btnEliminarCgg_veh_vehiculo',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_veh_vehiculo,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_veh_vehiculo(btn){if (btn=='yes'){
						try{
							function CallBackCgg_veh_vehiculo(r){
								winFrmListadoCgg_veh_vehiculo.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_veh_vehiculo,
											msg: 'La informaci\u00f3n de Veh vehiculo ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_veh_vehiculo.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_veh_vehiculo,
											msg: 'La informaci\u00f3n de Veh vehiculo no ha podido ser eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_veh_vehiculo.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCvveh_codigo',grdCgg_veh_vehiculo.getSelectionModel().getSelected().get('CVVEH_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_veh_vehiculo,"delete",param, true, CallBackCgg_veh_vehiculo);
						}catch(inErr){
							winFrmListadoCgg_veh_vehiculo.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_veh_vehiculo.
	*/
	var btnSalirCgg_veh_vehiculo = new Ext.Button({
			id:'btnSalirCgg_veh_vehiculo',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_veh_vehiculo.close();
			}}
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_veh_vehiculo.
	*/
	var cmCgg_veh_vehiculo = new Ext.grid.ColumnModel([
		{dataIndex:'PROPIETARIO',header:'Propietario',width:200,sortable:true},
		{dataIndex:'TRAMITE',header:'Tramite',width:50,sortable:true},
			{dataIndex:'MARCA',header:'Marca',width:150,sortable:true},
			{dataIndex:'CATEGORIA',header:'Categor\u00eda',width:150,sortable:true},
			{dataIndex:'PRODUCTIVO',header:'Sct. Productivo',width:150,sortable:true},
			{dataIndex:'SECTOR',header:'Sector',width:150,sortable:true},
			{dataIndex:'CVVEH_NOMBRE',header:'Nombre',width:150,sortable:true},
			{dataIndex:'CVVEH_MODELO',header:'Modelo',width:80,sortable:true},
			{dataIndex:'CVVEH_TIPO',header:'Tipo',width:80,sortable:true,renderer:function(inData){return TypeVehiculo[inData]}},
			{dataIndex:'CVVEH_ANIO_PRODUCCION',header:'A\u00f1o',width:80,sortable:true},
			{dataIndex:'CVVEH_CHASIS',header:'Chasis',width:150,sortable:true},
			{dataIndex:'ESTADOS',header:'Estados',width:250,sortable:true},
	{dataIndex:'CVVEH_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_veh_vehiculo por un campo especifico.
	*/
	var gsCgg_veh_vehiculo = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_veh_vehiculo",
					method:"selectPageDirect",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CVVEH_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CVVEH_CODIGO'},
				{name:'CVMRC_CODIGO'},
				{name:'TRAMITE'},
				{name:'MARCA'},
				{name:'CVCLR_CODIGO'},				
				{name:'CVCTG_CODIGO'},
				{name:'PROPIETARIO'},
				{name:'CATEGORIA'},
				{name:'ESTADOS'},
				{name:'CSCTP_CODIGO'},
				{name:'PRODUCTIVO'},
				{name:'CVSCT_CODIGO'},
				{name:'SECTOR'},
				{name:'CGG_CVCLR_CODIGO'},				
				{name:'CVVEH_NOMBRE'},
				{name:'CVVEH_MODELO'},
				{name:'CVVEH_TIPO'},
				{name:'CVVEH_ANIO_PRODUCCION'},
				{name:'CVVEH_CHASIS'},
				{name:'CVVEH_PLACA'},
				{name:'CVVEH_ESTADO_PROCESO'},
				{name:'CVVEH_FECHA_CENSO'},
				{name:'CVVEH_FECHA_SALIDA'},
				{name:'CVVEH_ESLORA'},
				{name:'CVVEH_MANGA'},
				{name:'CVVEH_PUNTAL'},
				{name:'CVVEH_MATERIAL'},
				{name:'CVVEH_INGRESO'},
				{name:'CVVEH_FECHA_INGRESO'},
				{name:'CVVEH_TIPO_INGRESO'},
				{name:'CVVEH_TIEMPO_ESTADIA'},
				{name:'CVVEH_SALIO'},
				{name:'CVVEH_FECHA_SALIDA'},
				{name:'CVVEH_OBSERVACION'}
			]),
			sortInfo:{field: 'CVMRC_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON',inSW:false}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_veh_vehiculo.
	*/
	var pgBarCgg_veh_vehiculo= new Ext.PagingToolbar({
			store: gsCgg_veh_vehiculo,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_veh_vehiculo en un formato tabular de filas y columnas.
	*/
	var grdCgg_veh_vehiculo = new Ext.grid.GridPanel({
		title:'Veh\u00edculos',
		iconCls:'iconVehiculo',
			cm:cmCgg_veh_vehiculo,
			store:gsCgg_veh_vehiculo,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_veh_vehiculo,
						width:200
				})
			],
			bbar:pgBarCgg_veh_vehiculo,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_veh_vehiculo.hidden){
						btnEditarCgg_veh_vehiculo.fireEvent('click', btnEditarCgg_veh_vehiculo);
					}
	}}});
	////////////////////////////HISTORIAL///////////////////////////////////////////////
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_veh_historial.
	*/
	var chkCvhst_propietario = new Ext.grid.CheckColumn(
		{dataIndex:'CVHST_PROPIETARIO',header:'Propietario',width:150,sortable:true});
		
	var cmCgg_veh_historial = new Ext.grid.ColumnModel([
			{dataIndex:'PROPIETARIO',header:'Propietario',width:250,sortable:true},
			{dataIndex:'CVHST_FECHA_TRASPASO',header:'Posesi\u00f3n',width:80,sortable:true,renderer:truncDate},
			chkCvhst_propietario,
			{dataIndex:'CVHST_CONCEPTO',header:'Concepto',width:200,sortable:true},
	{dataIndex:'CVHST_OBSERVACIONES',header:'Observaciones',width:250,sortable:true}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_veh_historial por un campo especifico.
	*/
	var gsCgg_veh_historial = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_veh_historial",
					method:"selectPageDirect",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CVHST_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CVHST_CODIGO'},
				{name:'CVVEH_CODIGO'},
				{name:'CRPER_CODIGO'},
				{name:'CRPJR_CODIGO'},
				{name:'PROPIETARIO'},
				{name:'CVHST_FECHA_TRASPASO'},
				{name:'CVHST_PROPIETARIO'},
				{name:'CVHST_CONCEPTO'},
				{name:'CVHST_OBSERVACIONES'}
			]),
			sortInfo:{field: 'CVVEH_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:"JSON",inCvveh_codigo:''}
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_veh_historial en un formato tabular de filas y columnas.
	*/
	var grdCgg_veh_historial = new Ext.grid.GridPanel({
			cm:cmCgg_veh_historial,
			store:gsCgg_veh_historial,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."}
	});
	////////////////////////////////////////////////////////////////////////////////////
	var pnlVehHistorial = new Ext.Panel({
		iconCls:'iconHistorial',
		title:'Historial',
		layout:'border',
		items:[grdCgg_veh_historial],
		tbar:['<div id="divVehiculo"></div>']
	});
	
	var tabVehiculo = new Ext.TabPanel({
		frame:true,
		activeTab:0,
		region:'center',
		tabPosition:'bottom',
		items:[grdCgg_veh_vehiculo,pnlVehHistorial],
		listeners:{
			tabchange:function(inSource, inCurrentTab){
				btnEditarCgg_veh_vehiculo.setDisabled(inCurrentTab == pnlVehHistorial);
				btnEliminarCgg_veh_vehiculo.setDisabled(inCurrentTab == pnlVehHistorial);
				btnNuevoCgg_veh_vehiculo.setDisabled(inCurrentTab == pnlVehHistorial);
			}
		}
	});
	if(inDesktop){
		gsCgg_veh_vehiculo.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON',
			inSW:false
		}
		});
		grdCgg_veh_vehiculo.getSelectionModel().on("selectionchange",function(inSelectionModel){
			var r = grdCgg_veh_vehiculo.getSelectionModel().getSelected();
			if(r){
				gsCgg_veh_historial.baseParams.start = 0;
				gsCgg_veh_historial.baseParams.limit = 100;
				gsCgg_veh_historial.baseParams.inCvveh_codigo = r.data.CVVEH_CODIGO;
				gsCgg_veh_historial.reload();
				
				document.getElementById('divVehiculo').innerHTML = '<b>Veh\u00edculo: </b>'+r.data.CVVEH_NOMBRE+' '+r.data.CVVEH_PLACA+' '+r.data.CVVEH_CHASIS;
			}
		});
		/**
		* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_veh_vehiculo.
		*/
		var winFrmListadoCgg_veh_vehiculo = inDesktop.createWindow({
				id:'winFrmListadoCgg_veh_vehiculo',
				title:tituloListadoCgg_veh_vehiculo,
				width:800,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo(tituloListadoCgg_veh_vehiculo,descListadoCgg_veh_vehiculo),
				items:[tabVehiculo],
				bbar:[btnNuevoCgg_veh_vehiculo,btnEditarCgg_veh_vehiculo,btnEliminarCgg_veh_vehiculo,'->',btnSalirCgg_veh_vehiculo],
				listeners:{
					show:function(){
						for (var i = 0; i < tabVehiculo.items.length; i++) {
							tabVehiculo.setActiveTab(i);
						}
						tabVehiculo.setActiveTab(0);
					}
				}
		});
		/**
		* Funcion que aplica los privilegios del usuario.
		*/
		applyGrants(winFrmListadoCgg_veh_vehiculo.getBottomToolbar());
	}
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_veh_vehiculo.
	* @returns ventana winFrmCgg_veh_vehiculo.
	* @base FrmListadoCgg_veh_vehiculo.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_veh_vehiculo;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_veh_vehiculo.
	* @base FrmListadoCgg_veh_vehiculo.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_veh_vehiculo.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_veh_vehiculo;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_veh_vehiculo;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_veh_vehiculo.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_veh_vehiculo.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_veh_vehiculo desde una instancia.
*/
FrmListadoCgg_veh_vehiculo.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_veh_vehiculo desde una instancia.
*/
FrmListadoCgg_veh_vehiculo.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_veh_vehiculo,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_veh_vehiculo.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_veh_vehiculo desde una instancia.
*/
FrmListadoCgg_veh_vehiculo.prototype.loadData = function(){
	this.loadData();
}