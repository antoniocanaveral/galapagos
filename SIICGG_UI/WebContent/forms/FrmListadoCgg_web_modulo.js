/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_web_modulo.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_web_modulo(inDesktop){
	var optMenu = 'Configuraci\u00F3/Sitio Web/Administraci\u00F3 de m\u00f3ndulos';
	var urlListadoCgg_web_modulo=URL_WS+"PublicWS/Cgg_web_modulo";
	var tituloListadoCgg_web_modulo='Modulos';
	var descListadoCgg_web_modulo='El formulario permite administrar informaci\u00f3n sobre los diferentes m\u00F3dulos del sistema';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_web_modulo.
	*/
	var btnNuevoCgg_web_modulo = new Ext.Button({
			id:'btnNuevoCgg_web_modulo',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_web_modulo = new FrmCgg_web_modulo("insert");
					objCgg_web_modulo.closeHandler(function(){
							gsCgg_web_modulo.reload();
					});
					objCgg_web_modulo.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_web_modulo.
	*/
	var btnEditarCgg_web_modulo = new Ext.Button({
			id:'btnEditarCgg_web_modulo',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_web_modulo.getSelectionModel().getSelected();
					if(r){
						var objCgg_web_modulo = new FrmCgg_web_modulo("update",r);
						objCgg_web_modulo.closeHandler(function(){
								gsCgg_web_modulo.reload();
						});
						objCgg_web_modulo.loadData();
						objCgg_web_modulo.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_web_modulo.
	*/
	var btnEliminarCgg_web_modulo = new Ext.Button({
			id:'btnEliminarCgg_web_modulo',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_web_modulo,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_web_modulo(btn){if (btn=='yes'){
						try{
							function CallBackCgg_web_modulo(r){
								winFrmListadoCgg_web_modulo.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_web_modulo,
											msg: 'La informaci\u00f3n de Web modulo ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_web_modulo.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_web_modulo,
											msg: 'La informaci\u00f3n de Web modulo no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_web_modulo.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCwmod_codigo',grdCgg_web_modulo.getSelectionModel().getSelected().get('CWMOD_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_web_modulo,"delete",param, true, CallBackCgg_web_modulo);
						}catch(inErr){
							winFrmListadoCgg_web_modulo.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_web_modulo.
	*/
	var btnSalirCgg_web_modulo = new Ext.Button({
			id:'btnSalirCgg_web_modulo',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_web_modulo.close();
			}}
	});
	
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_web_modulo.
	*/
	var cmCgg_web_modulo = new Ext.grid.ColumnModel([
			{dataIndex:'CWMOD_CODIGO',header:'C\u00F3digo',width:150,sortable:true,hidden:true},
			{dataIndex:'CWMOD_NOMBRE',header:'Nombre',width:150,sortable:true},
	{dataIndex:'CWMOD_DESCRIPCION',header:'Descripci\u00F3n',width:150,sortable:true}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_web_modulo por un campo especifico.
	*/
	var gsCgg_web_modulo = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"PublicWS/Cgg_web_modulo",
					method:"selectPage",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CWMOD_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CWMOD_CODIGO'},
				{name:'CWMOD_NOMBRE'},
				{name:'CWMOD_DESCRIPCION'}
			]),
			sortInfo:{field: 'CWMOD_NOMBRE', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_web_modulo.
	*/
	var pgBarCgg_web_modulo= new Ext.PagingToolbar({
			store: gsCgg_web_modulo,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_web_modulo en un formato tabular de filas y columnas.
	*/
	var grdCgg_web_modulo = new Ext.grid.GridPanel({
			cm:cmCgg_web_modulo,
			store:gsCgg_web_modulo,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_web_modulo,
						width:200
				})
			],
			bbar:pgBarCgg_web_modulo,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_web_modulo.hidden){
						btnEditarCgg_web_modulo.fireEvent('click', btnEditarCgg_web_modulo);
					}
	}}});
	gsCgg_web_modulo.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_web_modulo.
	*/
	if(inDesktop){
		var winFrmListadoCgg_web_modulo = inDesktop.createWindow({
				id:'winFrmListadoCgg_web_modulo',
				title:tituloListadoCgg_web_modulo,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_web_modulo,descListadoCgg_web_modulo),
				items:[grdCgg_web_modulo],
				bbar:[btnNuevoCgg_web_modulo,btnEditarCgg_web_modulo,btnEliminarCgg_web_modulo,'->',btnSalirCgg_web_modulo]
		});
	}else{
		var winFrmListadoCgg_web_modulo = new Ext.Window({
				id:'winFrmListadoCgg_web_modulo',
				title:tituloListadoCgg_web_modulo,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_web_modulo,descListadoCgg_web_modulo),
				items:[grdCgg_web_modulo],
				bbar:[btnNuevoCgg_web_modulo,btnEditarCgg_web_modulo,btnEliminarCgg_web_modulo,'->',btnSalirCgg_web_modulo]
		});
	}
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_web_modulo.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_web_modulo.
	* @returns ventana winFrmCgg_web_modulo.
	* @base FrmListadoCgg_web_modulo.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_web_modulo;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_web_modulo.
	* @base FrmListadoCgg_web_modulo.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_web_modulo.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_web_modulo;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_web_modulo;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_web_modulo.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_web_modulo.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_web_modulo desde una instancia.
*/
FrmListadoCgg_web_modulo.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_web_modulo desde una instancia.
*/
FrmListadoCgg_web_modulo.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_web_modulo,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_web_modulo.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_web_modulo desde una instancia.
*/
FrmListadoCgg_web_modulo.prototype.loadData = function(){
	this.loadData();
}
