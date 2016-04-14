/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_web_agencia.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_web_agencia(inDektop){	
	var optMenu = 'Configuraci\u00F3n/Sitio Web/Administraci\u00F3n de agencias';
	var urlListadoCgg_web_agencia=URL_WS+"PublicWS/Cgg_web_agencia";
	var tituloListadoCgg_web_agencia='Agencias';
	var descListadoCgg_web_agencia='El formulario permite administrar informaci\u00f3n de la tabla Web agencia';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_web_agencia.
	*/
	var btnNuevoCgg_web_agencia = new Ext.Button({
			id:'btnNuevoCgg_web_agencia',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_web_agencia = new FrmCgg_web_agencia("insert");
					objCgg_web_agencia.closeHandler(function(){
							gsCgg_web_agencia.reload();
					});
					objCgg_web_agencia.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_web_agencia.
	*/
	var btnEditarCgg_web_agencia = new Ext.Button({
			id:'btnEditarCgg_web_agencia',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_web_agencia.getSelectionModel().getSelected();
					if(r){
						var objCgg_web_agencia = new FrmCgg_web_agencia("update",r);
						objCgg_web_agencia.closeHandler(function(){
								gsCgg_web_agencia.reload();
						});
						objCgg_web_agencia.loadData();
						objCgg_web_agencia.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_web_agencia.
	*/
	var btnEliminarCgg_web_agencia = new Ext.Button({
			id:'btnEliminarCgg_web_agencia',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_web_agencia,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_web_agencia(btn){if (btn=='yes'){
						try{
							function CallBackCgg_web_agencia(r){
								winFrmListadoCgg_web_agencia.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_web_agencia,
											msg: 'La informaci\u00f3n de Web agencia ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_web_agencia.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_web_agencia,
											msg: 'La informaci\u00f3n de Web agencia no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_web_agencia.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCwage_codigo',grdCgg_web_agencia.getSelectionModel().getSelected().get('CWAGE_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_web_agencia,"delete",param, true, CallBackCgg_web_agencia);
						}catch(inErr){
							winFrmListadoCgg_web_agencia.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_web_agencia.
	*/
	var btnSalirCgg_web_agencia = new Ext.Button({
			id:'btnSalirCgg_web_agencia',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_web_agencia.close();
			}}
	});
	
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_web_agencia.
	*/
	var cmCgg_web_agencia = new Ext.grid.ColumnModel([
			{dataIndex:'CWAGE_CODIGO',header:'C\u00F3digo',width:150,sortable:true,hidden:true},
			{dataIndex:'CWMOD_CODIGO',header:'C\u00F3digo m\u00F3dulo',width:150,sortable:true,hidden:true},
			{dataIndex:'CWAGE_NOMBRE',header:'Nombre',width:150,sortable:true},
			{dataIndex:'CWAGE_DESCRIPCION',header:'Descripci\u00F3n',width:150,sortable:true},
	{dataIndex:'CWAGE_ENCARGADO',header:'Encargado',width:150,sortable:true}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_web_agencia por un campo especifico.
	*/
	var gsCgg_web_agencia = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"/PublicWS/Cgg_web_agencia",
					method:"selectPage",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CWAGE_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CWAGE_CODIGO'},
				{name:'CWMOD_CODIGO'},
				{name:'CWAGE_NOMBRE'},
				{name:'CWAGE_DESCRIPCION'},
				{name:'CWAGE_ENCARGADO'}
			]),
			sortInfo:{field: 'CWMOD_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_web_agencia.
	*/
	var pgBarCgg_web_agencia= new Ext.PagingToolbar({
			store: gsCgg_web_agencia,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_web_agencia en un formato tabular de filas y columnas.
	*/
	var grdCgg_web_agencia = new Ext.grid.GridPanel({
			cm:cmCgg_web_agencia,
			store:gsCgg_web_agencia,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_web_agencia,
						width:200
				})
			],
			bbar:pgBarCgg_web_agencia,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_web_agencia.hidden){
						btnEditarCgg_web_agencia.fireEvent('click', btnEditarCgg_web_agencia);
					}
	}}});
	gsCgg_web_agencia.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_web_agencia.
	*/
	if(inDektop){
		var winFrmListadoCgg_web_agencia = inDektop.createWindow({
			id:'winFrmListadoCgg_web_agencia',
			title:tituloListadoCgg_web_agencia,
			iconCls:'iconAplicacion',
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			layout:'border',
			tbar:getPanelTitulo('Listado '+tituloListadoCgg_web_agencia,descListadoCgg_web_agencia),
			items:[grdCgg_web_agencia],
			bbar:[btnNuevoCgg_web_agencia,btnEditarCgg_web_agencia,btnEliminarCgg_web_agencia,'->',btnSalirCgg_web_agencia]
		});
	}else{
		var winFrmListadoCgg_web_agencia = new Ext.Window({
			id:'winFrmListadoCgg_web_agencia',
			title:tituloListadoCgg_web_agencia,
			iconCls:'iconAplicacion',
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			layout:'border',
			tbar:getPanelTitulo('Listado '+tituloListadoCgg_web_agencia,descListadoCgg_web_agencia),
			items:[grdCgg_web_agencia],
			bbar:[btnNuevoCgg_web_agencia,btnEditarCgg_web_agencia,btnEliminarCgg_web_agencia,'->',btnSalirCgg_web_agencia]
		});

	}
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_web_agencia.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_web_agencia.
	* @returns ventana winFrmCgg_web_agencia.
	* @base FrmListadoCgg_web_agencia.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_web_agencia;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_web_agencia.
	* @base FrmListadoCgg_web_agencia.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_web_agencia.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_web_agencia;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_web_agencia;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_web_agencia.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_web_agencia.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_web_agencia desde una instancia.
*/
FrmListadoCgg_web_agencia.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_web_agencia desde una instancia.
*/
FrmListadoCgg_web_agencia.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_web_agencia,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_web_agencia.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_web_agencia desde una instancia.
*/
FrmListadoCgg_web_agencia.prototype.loadData = function(){
	this.loadData();
}
