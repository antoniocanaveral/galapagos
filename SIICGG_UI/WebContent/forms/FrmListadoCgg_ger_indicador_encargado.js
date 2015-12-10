/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_ger_indicador_encargado.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_ger_indicador_encargado(inDesktop){
	var optMenu = 'Gerencial/Administraci\u00f3n de responsables para indicadores';
	var urlListadoCgg_ger_indicador_encargado=URL_WS+"Cgg_ger_indicador_encargado";
	var tituloListadoCgg_ger_indicador_encargado='Encargados de registrar un indicador';
	var descListadoCgg_ger_indicador_encargado='El formulario permite administrar informaci\u00f3n sobre los encargados de registrar los indicadores';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_ger_indicador_encargado.
	*/
	var btnNuevoCgg_ger_indicador_encargado = new Ext.Button({
			id:'btnNuevoCgg_ger_indicador_encargado',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_ger_indicador_encargado = new FrmCgg_ger_indicador_encargado("insert");
					objCgg_ger_indicador_encargado.closeHandler(function(){
							gsCgg_ger_indicador_encargado.reload();
					});
					objCgg_ger_indicador_encargado.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_ger_indicador_encargado.
	*/
	var btnEditarCgg_ger_indicador_encargado = new Ext.Button({
			id:'btnEditarCgg_ger_indicador_encargado',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_ger_indicador_encargado.getSelectionModel().getSelected();
					if(r){
						var objCgg_ger_indicador_encargado = new FrmCgg_ger_indicador_encargado("update",r);
						objCgg_ger_indicador_encargado.closeHandler(function(){
								gsCgg_ger_indicador_encargado.reload();
						});
						objCgg_ger_indicador_encargado.loadData();
						objCgg_ger_indicador_encargado.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_ger_indicador_encargado.
	*/
	var btnEliminarCgg_ger_indicador_encargado = new Ext.Button({
			id:'btnEliminarCgg_ger_indicador_encargado',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_ger_indicador_encargado,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_ger_indicador_encargado(btn){if (btn=='yes'){
						try{
							function CallBackCgg_ger_indicador_encargado(r){
								winFrmListadoCgg_ger_indicador_encargado.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_ger_indicador_encargado,
											msg: 'La informaci\u00f3n de Ger indicador encargado ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_ger_indicador_encargado.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_ger_indicador_encargado,
											msg: 'La informaci\u00f3n de Ger indicador encargado no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_ger_indicador_encargado.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCggie_codigo',grdCgg_ger_indicador_encargado.getSelectionModel().getSelected().get('CGGIE_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_ger_indicador_encargado,"delete",param, true, CallBackCgg_ger_indicador_encargado);
						}catch(inErr){
							winFrmListadoCgg_ger_indicador_encargado.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_ger_indicador_encargado.
	*/
	var btnSalirCgg_ger_indicador_encargado = new Ext.Button({
			id:'btnSalirCgg_ger_indicador_encargado',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_ger_indicador_encargado.close();
			}}
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_ger_indicador_encargado.
	*/
	var cmCgg_ger_indicador_encargado = new Ext.grid.ColumnModel([
			{dataIndex:'CGGIE_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true},
			{dataIndex:'CCTN_NOMBRE',header:'Cant\u00f3n',width:150,sortable:true},
			{dataIndex:'CUSU_NOMBRE_USUARIO',header:'Usuario',width:150,sortable:true},
			{dataIndex:'CGGIN_NOMBRE',header:'Indicador',width:150,sortable:true,hidden:true}
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_ger_indicador_encargado por un campo especifico.
	*/
	var gsCgg_ger_indicador_encargado = new Ext.data.GroupingStore({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_ger_indicador_encargado",
					method:"selectPageDirect",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CGGIE_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CGGIE_CODIGO'},
				{name:'CCTN_CODIGO'},
				{name:'CUSU_CODIGO'},
				{name:'CGGIN_CODIGO'},
				{name:'CGGIN_NOMBRE'},
				{name:'CCTN_NOMBRE'},
				{name:'CUSU_NOMBRE_USUARIO'}
			]),
			sortInfo:{field: 'CCTN_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'},
			groupField:'CGGIN_NOMBRE'
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_ger_indicador_encargado.
	*/
	var pgBarCgg_ger_indicador_encargado= new Ext.PagingToolbar({
			store: gsCgg_ger_indicador_encargado,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_ger_indicador_encargado en un formato tabular de filas y columnas.
	*/
	var grdCgg_ger_indicador_encargado = new Ext.grid.GridPanel({
			cm:cmCgg_ger_indicador_encargado,
			store:gsCgg_ger_indicador_encargado,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			view: new Ext.grid.GroupingView({
				groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
			}),
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_ger_indicador_encargado,
						width:200
				})
			],
			bbar:pgBarCgg_ger_indicador_encargado,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_ger_indicador_encargado.hidden){
						btnEditarCgg_ger_indicador_encargado.fireEvent('click', btnEditarCgg_ger_indicador_encargado);
					}
	}}});
	gsCgg_ger_indicador_encargado.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_ger_indicador_encargado.
	*/
	if (inDesktop){
		var winFrmListadoCgg_ger_indicador_encargado = inDesktop.createWindow({
				id:'winFrmListadoCgg_ger_indicador_encargado',
				title:tituloListadoCgg_ger_indicador_encargado,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_ger_indicador_encargado,descListadoCgg_ger_indicador_encargado),
				items:[grdCgg_ger_indicador_encargado],
				bbar:[btnNuevoCgg_ger_indicador_encargado,btnEditarCgg_ger_indicador_encargado,btnEliminarCgg_ger_indicador_encargado,'->',btnSalirCgg_ger_indicador_encargado]
		});
	}
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_ger_indicador_encargado.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_ger_indicador_encargado.
	* @returns ventana winFrmCgg_ger_indicador_encargado.
	* @base FrmListadoCgg_ger_indicador_encargado.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_ger_indicador_encargado;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_ger_indicador_encargado.
	* @base FrmListadoCgg_ger_indicador_encargado.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_ger_indicador_encargado.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_ger_indicador_encargado;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_ger_indicador_encargado;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_ger_indicador_encargado.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_ger_indicador_encargado.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_ger_indicador_encargado desde una instancia.
*/
FrmListadoCgg_ger_indicador_encargado.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_ger_indicador_encargado desde una instancia.
*/
FrmListadoCgg_ger_indicador_encargado.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_ger_indicador_encargado,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_ger_indicador_encargado.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_ger_indicador_encargado desde una instancia.
*/
FrmListadoCgg_ger_indicador_encargado.prototype.loadData = function(){
	this.loadData();
}
