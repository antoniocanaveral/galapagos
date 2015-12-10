/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_veh_combustible.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_veh_combustible(inDesktop){
	var optMenu = 'Vehiculos/Configuraci\u00f3n/Combustible';
	var urlListadoCgg_veh_combustible=URL_WS+"Cgg_veh_combustible";
	var tituloListadoCgg_veh_combustible='Listado de combustibles';
	var descListadoCgg_veh_combustible='El formulario permite administrar informaci\u00f3n de los tipos de combustibles de los veh\u00edculos.';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_veh_combustible.
	*/
	var btnNuevoCgg_veh_combustible = new Ext.Button({
			id:'btnNuevoCgg_veh_combustible',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_veh_combustible = new FrmCgg_veh_combustible("insert");
					objCgg_veh_combustible.closeHandler(function(){
							gsCgg_veh_combustible.reload();
					});
					objCgg_veh_combustible.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_veh_combustible.
	*/
	var btnEditarCgg_veh_combustible = new Ext.Button({
			id:'btnEditarCgg_veh_combustible',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_veh_combustible.getSelectionModel().getSelected();
					if(r){
						var objCgg_veh_combustible = new FrmCgg_veh_combustible("update",r);
						objCgg_veh_combustible.closeHandler(function(){
								gsCgg_veh_combustible.reload();
						});
						objCgg_veh_combustible.loadData();
						objCgg_veh_combustible.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_veh_combustible.
	*/
	var btnEliminarCgg_veh_combustible = new Ext.Button({
			id:'btnEliminarCgg_veh_combustible',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_veh_combustible,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_veh_combustible(btn){if (btn=='yes'){
						try{
							function CallBackCgg_veh_combustible(r){
								winFrmListadoCgg_veh_combustible.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_veh_combustible,
											msg: 'La informaci\u00f3n de Combustible ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_veh_combustible.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_veh_combustible,
											msg: 'La informaci\u00f3n de Combustible no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_veh_combustible.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCvcmb_codigo',grdCgg_veh_combustible.getSelectionModel().getSelected().get('CVCMB_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_veh_combustible,"delete",param, true, CallBackCgg_veh_combustible);
						}catch(inErr){
							winFrmListadoCgg_veh_combustible.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_veh_combustible.
	*/
	var btnSalirCgg_veh_combustible = new Ext.Button({
			id:'btnSalirCgg_veh_combustible',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_veh_combustible.close();
			}}
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_veh_combustible.
	*/
	var cmCgg_veh_combustible = new Ext.grid.ColumnModel([
		{dataIndex:'CVCMB_NOMBRE',header:'Nombre',width:150,sortable:true},
		{dataIndex:'CVCMB_OBSERVACION',header:'Observaci\u00f3n',width:250,sortable:true}
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_veh_combustible por un campo especifico.
	*/
	var gsCgg_veh_combustible = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_veh_combustible",
					method:"selectPage",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CVCMB_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CVCMB_CODIGO'},
				{name:'CVCMB_NOMBRE'},
				{name:'CVCMB_OBSERVACION'}
			]),
			sortInfo:{field: 'CVCMB_NOMBRE', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_veh_combustible.
	*/
	var pgBarCgg_veh_combustible= new Ext.PagingToolbar({
			store: gsCgg_veh_combustible,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_veh_combustible en un formato tabular de filas y columnas.
	*/
	var grdCgg_veh_combustible = new Ext.grid.GridPanel({
			cm:cmCgg_veh_combustible,
			store:gsCgg_veh_combustible,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_veh_combustible,
						width:200
				})
			],
			bbar:pgBarCgg_veh_combustible,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_veh_combustible.hidden){
						btnEditarCgg_veh_combustible.fireEvent('click', btnEditarCgg_veh_combustible);
					}
	}}});
	if(inDesktop){
		gsCgg_veh_combustible.reload({params:{
				start:0,
				limit:RECORD_PAGE,
				format:'JSON'
			}
		});
		/**
		* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_veh_combustible.
		*/
		var winFrmListadoCgg_veh_combustible = new Ext.Window({
				id:'winFrmListadoCgg_veh_combustible',
				title:tituloListadoCgg_veh_combustible,
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo(tituloListadoCgg_veh_combustible,descListadoCgg_veh_combustible),
				items:[grdCgg_veh_combustible],
				bbar:[btnNuevoCgg_veh_combustible,btnEditarCgg_veh_combustible,btnEliminarCgg_veh_combustible,'->',btnSalirCgg_veh_combustible]
		});
		/**
		* Funcion que aplica los privilegios del usuario.
		*/
		applyGrants(winFrmListadoCgg_veh_combustible.getBottomToolbar());
	}
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_veh_combustible.
	* @returns ventana winFrmCgg_veh_combustible.
	* @base FrmListadoCgg_veh_combustible.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_veh_combustible;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_veh_combustible.
	* @base FrmListadoCgg_veh_combustible.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_veh_combustible.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_veh_combustible;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_veh_combustible;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_veh_combustible.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_veh_combustible.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_veh_combustible desde una instancia.
*/
FrmListadoCgg_veh_combustible.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_veh_combustible desde una instancia.
*/
FrmListadoCgg_veh_combustible.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_veh_combustible,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_veh_combustible.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_veh_combustible desde una instancia.
*/
FrmListadoCgg_veh_combustible.prototype.loadData = function(){
	this.loadData();
}