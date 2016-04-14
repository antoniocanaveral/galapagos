/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_perfil_adjunto.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_gem_perfil_adjunto(inDesktop,IN_CRPER_CODIGO){
	var urlListadoCgg_gem_perfil_adjunto=URL_WS+"Cgg_gem_perfil_adjunto";
	var tituloListadoCgg_gem_perfil_adjunto='Gem perfil adjunto';
	var descListadoCgg_gem_perfil_adjunto='El formulario permite administrar informaci\u00f3n de la tabla Gem perfil adjunto';
	var inCrper_codigo=IN_CRPER_CODIGO;
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_perfil_adjunto.
	*/
	var btnNuevoCgg_gem_perfil_adjunto = new Ext.Button({
			id:'btnNuevoCgg_gem_perfil_adjunto',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_gem_perfil_adjunto = new FrmCgg_gem_perfil_adjunto("insert");
					objCgg_gem_perfil_adjunto.closeHandler(function(){
							gsCgg_gem_perfil_adjunto.reload();
					});
					objCgg_gem_perfil_adjunto.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_perfil_adjunto.
	*/
	var btnEditarCgg_gem_perfil_adjunto = new Ext.Button({
			id:'btnEditarCgg_gem_perfil_adjunto',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_gem_perfil_adjunto.getSelectionModel().getSelected();
					if(r){
						var objCgg_gem_perfil_adjunto = new FrmCgg_gem_perfil_adjunto("update",r);
						objCgg_gem_perfil_adjunto.closeHandler(function(){
								gsCgg_gem_perfil_adjunto.reload();
						});
						objCgg_gem_perfil_adjunto.loadData();
						objCgg_gem_perfil_adjunto.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_gem_perfil_adjunto.
	*/
	var btnEliminarCgg_gem_perfil_adjunto = new Ext.Button({
			id:'btnEliminarCgg_gem_perfil_adjunto',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_gem_perfil_adjunto,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_gem_perfil_adjunto(btn){if (btn=='yes'){
						try{
							function CallBackCgg_gem_perfil_adjunto(r){
								winFrmListadoCgg_gem_perfil_adjunto.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_gem_perfil_adjunto,
											msg: 'La informaci\u00f3n de Gem perfil adjunto ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_gem_perfil_adjunto.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_gem_perfil_adjunto,
											msg: 'La informaci\u00f3n de Gem perfil adjunto no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_gem_perfil_adjunto.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCgpfa_codigo',grdCgg_gem_perfil_adjunto.getSelectionModel().getSelected().get('CGPFA_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_gem_perfil_adjunto,"delete",param, true, CallBackCgg_gem_perfil_adjunto);
						}catch(inErr){
							winFrmListadoCgg_gem_perfil_adjunto.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_perfil_adjunto.
	*/
	var btnSalirCgg_gem_perfil_adjunto = new Ext.Button({
			id:'btnSalirCgg_gem_perfil_adjunto',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_gem_perfil_adjunto.close();
			}}
	});	
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_perfil_adjunto.
	*/
	var cmCgg_gem_perfil_adjunto = new Ext.grid.ColumnModel([
			{dataIndex:'CGPFA_CODIGO',header:'Codigo',width:150,sortable:true},
			{dataIndex:'CGPPR_CODIGO',header:'Codigo',width:150,sortable:true},
			{dataIndex:'CGPFA_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
			{dataIndex:'CGPFA_NOMBRE_ADJUNTO',header:'Nombre adjunto',width:150,sortable:true},
			{dataIndex:'CGPFA_TIPO_ADJUNTO',header:'Tipo adjunto',width:150,sortable:true},
	{dataIndex:'CGPFA_ADJUNTO',header:'Adjunto',width:150,sortable:true}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_perfil_adjunto por un campo especifico.
	*/
	var gsCgg_gem_perfil_adjunto = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_gem_perfil_adjunto",
					method:"selectPage",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CGPFA_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CGPFA_CODIGO'},
				{name:'CGPPR_CODIGO'},
				{name:'CGPFA_DESCRIPCION'},
				{name:'CGPFA_NOMBRE_ADJUNTO'},
				{name:'CGPFA_TIPO_ADJUNTO'},
				{name:'CGPFA_ADJUNTO'}
			]),
			sortInfo:{field: 'CGPPR_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_gem_perfil_adjunto.
	*/
	var pgBarCgg_gem_perfil_adjunto= new Ext.PagingToolbar({
			store: gsCgg_gem_perfil_adjunto,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_perfil_adjunto en un formato tabular de filas y columnas.
	*/
	var grdCgg_gem_perfil_adjunto = new Ext.grid.GridPanel({
			cm:cmCgg_gem_perfil_adjunto,
			store:gsCgg_gem_perfil_adjunto,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_gem_perfil_adjunto,
						width:200
				})
			],
			bbar:pgBarCgg_gem_perfil_adjunto,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_gem_perfil_adjunto.hidden){
						btnEditarCgg_gem_perfil_adjunto.fireEvent('click', btnEditarCgg_gem_perfil_adjunto);
					}
	}}});
	gsCgg_gem_perfil_adjunto.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gem_perfil_adjunto.
	*/
	var winFrmListadoCgg_gem_perfil_adjunto = new Ext.Window({
			id:'winFrmListadoCgg_gem_perfil_adjunto',
			title:tituloListadoCgg_gem_perfil_adjunto,
			iconCls:'iconAplicacion',
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrainHeader:true,
			layout:'border',
			tbar:getPanelTitulo('Listado '+tituloListadoCgg_gem_perfil_adjunto,descListadoCgg_gem_perfil_adjunto),
			items:[grdCgg_gem_perfil_adjunto],
			bbar:[btnNuevoCgg_gem_perfil_adjunto,btnEditarCgg_gem_perfil_adjunto,btnEliminarCgg_gem_perfil_adjunto,'->',btnSalirCgg_gem_perfil_adjunto]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_gem_perfil_adjunto.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_perfil_adjunto.
	* @returns ventana winFrmCgg_gem_perfil_adjunto.
	* @base FrmListadoCgg_gem_perfil_adjunto.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_gem_perfil_adjunto;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gem_perfil_adjunto.
	* @base FrmListadoCgg_gem_perfil_adjunto.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_gem_perfil_adjunto.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_gem_perfil_adjunto;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_gem_perfil_adjunto;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_gem_perfil_adjunto.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_gem_perfil_adjunto.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_perfil_adjunto desde una instancia.
*/
FrmListadoCgg_gem_perfil_adjunto.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_perfil_adjunto desde una instancia.
*/
FrmListadoCgg_gem_perfil_adjunto.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_perfil_adjunto,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_gem_perfil_adjunto.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gem_perfil_adjunto desde una instancia.
*/
FrmListadoCgg_gem_perfil_adjunto.prototype.loadData = function(){
	this.loadData();
}
