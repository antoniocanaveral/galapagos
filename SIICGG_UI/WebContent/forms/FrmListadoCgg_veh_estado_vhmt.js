/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_veh_estado_vhmt.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_veh_estado_vhmt(inDesktop){
	var optMenu = 'Vehiculos/Configuraci\u00f3n/Estados';
	var urlListadoCgg_veh_estado_vhmt=URL_WS+"Cgg_veh_estado_vhmt";
	var tituloListadoCgg_veh_estado_vhmt='Estado de Veh\u00edculos o Motores';
	var descListadoCgg_veh_estado_vhmt='El formulario permite administrar informaci\u00f3n de los estados que pueden tener un Veh\u00edculo o un Motor.';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_veh_estado_vhmt.
	*/
	var btnNuevoCgg_veh_estado_vhmt = new Ext.Button({
			id:'btnNuevoCgg_veh_estado_vhmt',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_veh_estado_vhmt = new FrmCgg_veh_estado_vhmt("insert");
					objCgg_veh_estado_vhmt.closeHandler(function(){
							gsCgg_veh_estado_vhmt.reload();
					});
					objCgg_veh_estado_vhmt.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_veh_estado_vhmt.
	*/
	var btnEditarCgg_veh_estado_vhmt = new Ext.Button({
			id:'btnEditarCgg_veh_estado_vhmt',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_veh_estado_vhmt.getSelectionModel().getSelected();
					if(r){
						var objCgg_veh_estado_vhmt = new FrmCgg_veh_estado_vhmt("update",r);
						objCgg_veh_estado_vhmt.closeHandler(function(){
								gsCgg_veh_estado_vhmt.reload();
						});
						objCgg_veh_estado_vhmt.loadData();
						objCgg_veh_estado_vhmt.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_veh_estado_vhmt.
	*/
	var btnEliminarCgg_veh_estado_vhmt = new Ext.Button({
			id:'btnEliminarCgg_veh_estado_vhmt',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_veh_estado_vhmt,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_veh_estado_vhmt(btn){if (btn=='yes'){
						try{
							function CallBackCgg_veh_estado_vhmt(r){
								winFrmListadoCgg_veh_estado_vhmt.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_veh_estado_vhmt,
											msg: 'La informaci\u00f3n de Estado ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_veh_estado_vhmt.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_veh_estado_vhmt,
											msg: 'La informaci\u00f3n de Estado no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_veh_estado_vhmt.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCvsvm_codigo',grdCgg_veh_estado_vhmt.getSelectionModel().getSelected().get('CVSVM_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_veh_estado_vhmt,"delete",param, true, CallBackCgg_veh_estado_vhmt);
						}catch(inErr){
							winFrmListadoCgg_veh_estado_vhmt.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_veh_estado_vhmt.
	*/
	var btnSalirCgg_veh_estado_vhmt = new Ext.Button({
			id:'btnSalirCgg_veh_estado_vhmt',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_veh_estado_vhmt.close();
			}}
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_veh_estado_vhmt.
	*/
	var cmCgg_veh_estado_vhmt = new Ext.grid.ColumnModel([
			{dataIndex:'CVSVM_NOMBRE',header:'Nombre',width:150,sortable:true},
	{dataIndex:'CVSVM_OBERVACION',header:'Obervaci\u00f3n',width:350,sortable:true}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_veh_estado_vhmt por un campo especifico.
	*/
	var gsCgg_veh_estado_vhmt = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_veh_estado_vhmt",
					method:"selectPage",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CVSVM_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CVSVM_CODIGO'},
				{name:'CVSVM_NOMBRE'},
				{name:'CVSVM_OBERVACION'}
			]),
			sortInfo:{field: 'CVSVM_NOMBRE', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_veh_estado_vhmt.
	*/
	var pgBarCgg_veh_estado_vhmt= new Ext.PagingToolbar({
			store: gsCgg_veh_estado_vhmt,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_veh_estado_vhmt en un formato tabular de filas y columnas.
	*/
	var grdCgg_veh_estado_vhmt = new Ext.grid.GridPanel({
			cm:cmCgg_veh_estado_vhmt,
			store:gsCgg_veh_estado_vhmt,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_veh_estado_vhmt,
						width:200
				})
			],
			bbar:pgBarCgg_veh_estado_vhmt,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_veh_estado_vhmt.hidden){
						btnEditarCgg_veh_estado_vhmt.fireEvent('click', btnEditarCgg_veh_estado_vhmt);
					}
	}}});
	gsCgg_veh_estado_vhmt.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	if(inDesktop){
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_veh_estado_vhmt.
	*/
	var winFrmListadoCgg_veh_estado_vhmt = new Ext.Window({
			id:'winFrmListadoCgg_veh_estado_vhmt',
			title:tituloListadoCgg_veh_estado_vhmt,
			iconCls:'iconAplicacion',
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			layout:'border',
			tbar:getPanelTitulo(tituloListadoCgg_veh_estado_vhmt,descListadoCgg_veh_estado_vhmt),
			items:[grdCgg_veh_estado_vhmt],
			bbar:[btnNuevoCgg_veh_estado_vhmt,btnEditarCgg_veh_estado_vhmt,btnEliminarCgg_veh_estado_vhmt,'->',btnSalirCgg_veh_estado_vhmt]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_veh_estado_vhmt.getBottomToolbar());
	}
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_veh_estado_vhmt.
	* @returns ventana winFrmCgg_veh_estado_vhmt.
	* @base FrmListadoCgg_veh_estado_vhmt.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_veh_estado_vhmt;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_veh_estado_vhmt.
	* @base FrmListadoCgg_veh_estado_vhmt.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_veh_estado_vhmt.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_veh_estado_vhmt;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_veh_estado_vhmt;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_veh_estado_vhmt.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_veh_estado_vhmt.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_veh_estado_vhmt desde una instancia.
*/
FrmListadoCgg_veh_estado_vhmt.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_veh_estado_vhmt desde una instancia.
*/
FrmListadoCgg_veh_estado_vhmt.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_veh_estado_vhmt,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_veh_estado_vhmt.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_veh_estado_vhmt desde una instancia.
*/
FrmListadoCgg_veh_estado_vhmt.prototype.loadData = function(){
	this.loadData();
}
