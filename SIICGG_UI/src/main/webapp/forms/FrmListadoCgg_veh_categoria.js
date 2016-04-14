/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_veh_categoria.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_veh_categoria(inDesktop){
	var optMenu = 'Vehiculos/Configuraci\u00f3n/Categoria';
	var urlListadoCgg_veh_categoria=URL_WS+"Cgg_veh_categoria";
	var tituloListadoCgg_veh_categoria='Listado de categorias';
	var descListadoCgg_veh_categoria='El formulario permite administrar informaci\u00f3n de las categorias de los veh\u00edculos.';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_veh_categoria.
	*/
	var btnNuevoCgg_veh_categoria = new Ext.Button({
			id:'btnNuevoCgg_veh_categoria',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_veh_categoria = new FrmCgg_veh_categoria("insert");
					objCgg_veh_categoria.closeHandler(function(){
							gsCgg_veh_categoria.reload();
					});
					objCgg_veh_categoria.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_veh_categoria.
	*/
	var btnEditarCgg_veh_categoria = new Ext.Button({
			id:'btnEditarCgg_veh_categoria',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_veh_categoria.getSelectionModel().getSelected();
					if(r){
						var objCgg_veh_categoria = new FrmCgg_veh_categoria("update",r);
						objCgg_veh_categoria.closeHandler(function(){
								gsCgg_veh_categoria.reload();
						});
						objCgg_veh_categoria.loadData();
						objCgg_veh_categoria.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_veh_categoria.
	*/
	var btnEliminarCgg_veh_categoria = new Ext.Button({
			id:'btnEliminarCgg_veh_categoria',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_veh_categoria,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_veh_categoria(btn){if (btn=='yes'){
						try{
							function CallBackCgg_veh_categoria(r){
								winFrmListadoCgg_veh_categoria.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_veh_categoria,
											msg: 'La informaci\u00f3n de Veh categoria ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_veh_categoria.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_veh_categoria,
											msg: 'La informaci\u00f3n de Veh categoria no ha podido ser eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_veh_categoria.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCvctg_codigo',grdCgg_veh_categoria.getSelectionModel().getSelected().get('CVCTG_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_veh_categoria,"delete",param, true, CallBackCgg_veh_categoria);
						}catch(inErr){
							winFrmListadoCgg_veh_categoria.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_veh_categoria.
	*/
	var btnSalirCgg_veh_categoria = new Ext.Button({
			id:'btnSalirCgg_veh_categoria',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_veh_categoria.close();
			}}
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_veh_categoria.
	*/
	var cmCgg_veh_categoria = new Ext.grid.ColumnModel([
		{dataIndex:'CATEGORIA',header:'Cat. padre',width:150,sortable:true},
		{dataIndex:'CVCTG_NOMBRE',header:'Nombre',width:150,sortable:true},
		{dataIndex:'CVCTG_OBSERVACION',header:'Observaci\u00f3n',width:250,sortable:true}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_veh_categoria por un campo especifico.
	*/
	var gsCgg_veh_categoria = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_veh_categoria",
					method:"selectPageDirect",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CVCTG_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CVCTG_CODIGO'},
				{name:'CGG_CVCTG_CODIGO'},
				{name:'CATEGORIA'},
				{name:'CVCTG_NOMBRE'},
				{name:'CVCTG_OBSERVACION'}
			]),
			sortInfo:{field: 'CGG_CVCTG_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_veh_categoria.
	*/
	var pgBarCgg_veh_categoria= new Ext.PagingToolbar({
			store: gsCgg_veh_categoria,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_veh_categoria en un formato tabular de filas y columnas.
	*/
	var grdCgg_veh_categoria = new Ext.grid.GridPanel({
			cm:cmCgg_veh_categoria,
			store:gsCgg_veh_categoria,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_veh_categoria,
						width:200
				})
			],
			bbar:pgBarCgg_veh_categoria,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_veh_categoria.hidden){
						btnEditarCgg_veh_categoria.fireEvent('click', btnEditarCgg_veh_categoria);
					}
	}}});
	gsCgg_veh_categoria.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	if(inDesktop){
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_veh_categoria.
	*/
	var winFrmListadoCgg_veh_categoria = inDesktop.createWindow({
			id:'winFrmListadoCgg_veh_categoria',
			title:tituloListadoCgg_veh_categoria,
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			layout:'border',
			tbar:getPanelTitulo(tituloListadoCgg_veh_categoria,descListadoCgg_veh_categoria),
			items:[grdCgg_veh_categoria],
			bbar:[btnNuevoCgg_veh_categoria,btnEditarCgg_veh_categoria,btnEliminarCgg_veh_categoria,'->',btnSalirCgg_veh_categoria]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_veh_categoria.getBottomToolbar());
	}
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_veh_categoria.
	* @returns ventana winFrmCgg_veh_categoria.
	* @base FrmListadoCgg_veh_categoria.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_veh_categoria;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_veh_categoria.
	* @base FrmListadoCgg_veh_categoria.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_veh_categoria.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_veh_categoria;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_veh_categoria;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_veh_categoria.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_veh_categoria.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_veh_categoria desde una instancia.
*/
FrmListadoCgg_veh_categoria.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_veh_categoria desde una instancia.
*/
FrmListadoCgg_veh_categoria.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_veh_categoria,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_veh_categoria.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_veh_categoria desde una instancia.
*/
FrmListadoCgg_veh_categoria.prototype.loadData = function(){
	this.loadData();
}
