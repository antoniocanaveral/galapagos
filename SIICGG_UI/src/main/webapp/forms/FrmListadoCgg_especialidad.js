/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_especialidad.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_especialidad(inDesktop){
	var optMenu = 'Configuraci\u00F3n/Educaci\u00F3n/Especialidad';
	var urlListadoCgg_especialidad=URL_WS+"Cgg_especialidad";
	var tituloListadoCgg_especialidad='Especialidad';
	var descListadoCgg_especialidad='El formulario permite administrar informaci\u00f3n de la tabla Especialidad';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_especialidad.
	*/
	var btnNuevoCgg_especialidad = new Ext.Button({
			id:'btnNuevoCgg_especialidad',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_especialidad = new FrmCgg_especialidad("insert");
					objCgg_especialidad.closeHandler(function(){
							gsCgg_especialidad.reload();
					});
					objCgg_especialidad.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_especialidad.
	*/
	var btnEditarCgg_especialidad = new Ext.Button({
			id:'btnEditarCgg_especialidad',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_especialidad.getSelectionModel().getSelected();
					if(r){
						var objCgg_especialidad = new FrmCgg_especialidad("update",r);
						objCgg_especialidad.closeHandler(function(){
								gsCgg_especialidad.reload();
						});
						objCgg_especialidad.loadData();
						objCgg_especialidad.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_especialidad.
	*/
	var btnEliminarCgg_especialidad = new Ext.Button({
			id:'btnEliminarCgg_especialidad',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_especialidad,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_especialidad(btn){if (btn=='yes'){
						try{
							function CallBackCgg_especialidad(r){
								winFrmListadoCgg_especialidad.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_especialidad,
											msg: 'La informaci\u00f3n de Especialidad ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_especialidad.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_especialidad,
											msg: 'La informaci\u00f3n de Especialidad no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_especialidad.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCgesp_codigo',grdCgg_especialidad.getSelectionModel().getSelected().get('CGESP_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_especialidad,"delete",param, true, CallBackCgg_especialidad);
						}catch(inErr){
							winFrmListadoCgg_especialidad.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_especialidad.
	*/
	var btnSalirCgg_especialidad = new Ext.Button({
			id:'btnSalirCgg_especialidad',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_especialidad.close();
			}}
	});	
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_especialidad.
	*/
	var cmCgg_especialidad = new Ext.grid.ColumnModel([
			{dataIndex:'CGESP_CODIGO',header:'Codigo',width:90,sortable:true,hidden:true},
			{dataIndex:'CGNES_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CGNES_DESCRIPCION',header:'Nivel de Educaci\u00F3n',width:130,sortable:true,hidden:true},
			{dataIndex:'CGESP_NOMBRE',header:'Nombre',width:200,sortable:true},
	{dataIndex:'CGESP_DESCRIPCION',header:'Descripcion',width:350,sortable:true}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_especialidad por un campo especifico.
	*/
	var gsCgg_especialidad = new Ext.data.GroupingStore({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_especialidad",
					method:"selectPage",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CGESP_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CGESP_CODIGO'},
				{name:'CGNES_CODIGO'},
				{name:'CGESP_NOMBRE'},
				{name:'CGESP_DESCRIPCION'},
				{name:'CGNES_DESCRIPCION'}
			]),
			sortInfo:{field: 'CGNES_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'},
			groupField:'CGNES_DESCRIPCION'
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_especialidad.
	*/
	var pgBarCgg_especialidad= new Ext.PagingToolbar({
			store: gsCgg_especialidad,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_especialidad en un formato tabular de filas y columnas.
	*/
	var grdCgg_especialidad = new Ext.grid.GridPanel({
			cm:cmCgg_especialidad,
			store:gsCgg_especialidad,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},			
			view: new Ext.grid.GroupingView({
                groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
                }),
			viewConfig:{forceFit:true},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_especialidad,
						width:200
				})
			],
			bbar:pgBarCgg_especialidad,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_especialidad.hidden){
						btnEditarCgg_especialidad.fireEvent('click', btnEditarCgg_especialidad);
					}
	}}});
	gsCgg_especialidad.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_especialidad.
	*/
	if(inDesktop!==null && inDesktop!==undefined){
		var winFrmListadoCgg_especialidad = inDesktop.createWindow({
				id:'winFrmListadoCgg_especialidad',
				title:tituloListadoCgg_especialidad,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_especialidad,descListadoCgg_especialidad),
				items:[grdCgg_especialidad],
				bbar:[btnNuevoCgg_especialidad,btnEditarCgg_especialidad,btnEliminarCgg_especialidad,'->',btnSalirCgg_especialidad]
		});
	}else{
		var winFrmListadoCgg_especialidad = new Ext.Window({
				id:'winFrmListadoCgg_especialidad',
				title:tituloListadoCgg_especialidad,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_especialidad,descListadoCgg_especialidad),
				items:[grdCgg_especialidad],
				bbar:[btnNuevoCgg_especialidad,btnEditarCgg_especialidad,btnEliminarCgg_especialidad,'->',btnSalirCgg_especialidad]
		});
	}
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_especialidad.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_especialidad.
	* @returns ventana winFrmCgg_especialidad.
	* @base FrmListadoCgg_especialidad.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_especialidad;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_especialidad.
	* @base FrmListadoCgg_especialidad.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_especialidad.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_especialidad;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_especialidad;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_especialidad.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_especialidad.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_especialidad desde una instancia.
*/
FrmListadoCgg_especialidad.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_especialidad desde una instancia.
*/
FrmListadoCgg_especialidad.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_especialidad,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_especialidad.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_especialidad desde una instancia.
*/
FrmListadoCgg_especialidad.prototype.loadData = function(){
	this.loadData();
}
