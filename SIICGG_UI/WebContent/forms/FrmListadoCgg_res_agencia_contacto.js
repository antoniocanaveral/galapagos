/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_agencia_contacto.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_res_agencia_contacto(inDesktop){	
	var optMenu = 'Configuraci\u00F3n/Sitio Web/Contactos Agencias';
	var urlListadoCgg_res_agencia_contacto=URL_WS+"PublicWS/Cgg_res_agencia_contacto";
	var tituloListadoCgg_res_agencia_contacto='Contactos de las Agencias';
	var descListadoCgg_res_agencia_contacto='El formulario permite administrar informaci\u00f3n sobre los diferentes contactos de las agencias';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_agencia_contacto.
	*/
	var btnNuevoCgg_res_agencia_contacto = new Ext.Button({
			id:'btnNuevoCgg_res_agencia_contacto',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_res_agencia_contacto = new FrmCgg_res_agencia_contacto("insert");
					objCgg_res_agencia_contacto.closeHandler(function(){
							gsCgg_res_agencia_contacto.reload();
					});
					objCgg_res_agencia_contacto.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_agencia_contacto.
	*/
	var btnEditarCgg_res_agencia_contacto = new Ext.Button({
			id:'btnEditarCgg_res_agencia_contacto',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_res_agencia_contacto.getSelectionModel().getSelected();
					if(r){
						var objCgg_res_agencia_contacto = new FrmCgg_res_agencia_contacto("update",r);
						objCgg_res_agencia_contacto.closeHandler(function(){
								gsCgg_res_agencia_contacto.reload();
						});
						objCgg_res_agencia_contacto.loadData();
						objCgg_res_agencia_contacto.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_agencia_contacto.
	*/
	var btnEliminarCgg_res_agencia_contacto = new Ext.Button({
			id:'btnEliminarCgg_res_agencia_contacto',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'\u00BFSeguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_agencia_contacto,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_res_agencia_contacto(btn){if (btn=='yes'){
						try{
							function CallBackCgg_res_agencia_contacto(r){
								winFrmListadoCgg_res_agencia_contacto.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_res_agencia_contacto,
											msg: 'La informaci\u00f3n sobre el contacto ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_res_agencia_contacto.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_res_agencia_contacto,
											msg: 'La informaci\u00f3n sobre el contacto no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_res_agencia_contacto.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCwcag_codigo',grdCgg_res_agencia_contacto.getSelectionModel().getSelected().get('CWCAG_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_res_agencia_contacto,"delete",param, true, CallBackCgg_res_agencia_contacto);
						}catch(inErr){
							winFrmListadoCgg_res_agencia_contacto.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_agencia_contacto.
	*/
	var btnSalirCgg_res_agencia_contacto = new Ext.Button({
			id:'btnSalirCgg_res_agencia_contacto',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_res_agencia_contacto.close();
			}}
	});
	
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_agencia_contacto.
	*/
	var cmCgg_res_agencia_contacto = new Ext.grid.ColumnModel([
			{dataIndex:'CWCAG_CODIGO',header:'C\00F3digo',width:150,sortable:true,hidden:true},
			{dataIndex:'CWAGE_CODIGO',header:'C\u00F3digo agencia',width:150,sortable:true,hidden:true},
			{dataIndex:'CRTCO_CODIGO',header:'C\u00F3digo tipo contacto',width:150,sortable:true,hidden:true},
			{dataIndex:'CWCAG_DESCRIPCION',header:'Descripci\u00F3n',width:150,sortable:true},
	{dataIndex:'CWCAG_CONTACTO',header:'Contacto',width:150,sortable:true}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_res_agencia_contacto por un campo especifico.
	*/
	var gsCgg_res_agencia_contacto = new Ext.data.GroupingStore({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"PublicWS/Cgg_res_agencia_contacto",
					method:"selectPage",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CWCAG_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CWCAG_CODIGO'},
				{name:'CWAGE_CODIGO'},
				{name:'CRTCO_CODIGO'},
				{name:'CWCAG_DESCRIPCION'},
				{name:'CWCAG_CONTACTO'}
			]),
			sortInfo:{field: 'CWAGE_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'},
			groupField:'CWAGE_CODIGO'
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_agencia_contacto.
	*/
	var pgBarCgg_res_agencia_contacto= new Ext.PagingToolbar({
			store: gsCgg_res_agencia_contacto,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_agencia_contacto en un formato tabular de filas y columnas.
	*/
	var grdCgg_res_agencia_contacto = new Ext.grid.GridPanel({
			cm:cmCgg_res_agencia_contacto,
			store:gsCgg_res_agencia_contacto,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			view: new Ext.grid.GroupingView({
                groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
            }),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_res_agencia_contacto,
						width:200
				})
			],
			bbar:pgBarCgg_res_agencia_contacto,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_res_agencia_contacto.hidden){
						btnEditarCgg_res_agencia_contacto.fireEvent('click', btnEditarCgg_res_agencia_contacto);
					}
	}}});
	gsCgg_res_agencia_contacto.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_agencia_contacto.
	*/
	if(inDesktop){
		var winFrmListadoCgg_res_agencia_contacto = inDesktop.createWindow({
				id:'winFrmListadoCgg_res_agencia_contacto',
				title:tituloListadoCgg_res_agencia_contacto,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_agencia_contacto,descListadoCgg_res_agencia_contacto),
				items:[grdCgg_res_agencia_contacto],
				bbar:[btnNuevoCgg_res_agencia_contacto,btnEditarCgg_res_agencia_contacto,btnEliminarCgg_res_agencia_contacto,'->',btnSalirCgg_res_agencia_contacto]
		});
	}else{
		var winFrmListadoCgg_res_agencia_contacto = new Ext.Window({
			id:'winFrmListadoCgg_res_agencia_contacto',
			title:tituloListadoCgg_res_agencia_contacto,
			iconCls:'iconAplicacion',
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			layout:'border',
			tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_agencia_contacto,descListadoCgg_res_agencia_contacto),
			items:[grdCgg_res_agencia_contacto],
			bbar:[btnNuevoCgg_res_agencia_contacto,btnEditarCgg_res_agencia_contacto,btnEliminarCgg_res_agencia_contacto,'->',btnSalirCgg_res_agencia_contacto]
		});
	}
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_res_agencia_contacto.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_res_agencia_contacto.
	* @returns ventana winFrmCgg_res_agencia_contacto.
	* @base FrmListadoCgg_res_agencia_contacto.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_res_agencia_contacto;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_agencia_contacto.
	* @base FrmListadoCgg_res_agencia_contacto.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_res_agencia_contacto.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_res_agencia_contacto;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_res_agencia_contacto;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_res_agencia_contacto.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_res_agencia_contacto.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_agencia_contacto desde una instancia.
*/
FrmListadoCgg_res_agencia_contacto.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_agencia_contacto desde una instancia.
*/
FrmListadoCgg_res_agencia_contacto.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_agencia_contacto,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_res_agencia_contacto.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_agencia_contacto desde una instancia.
*/
FrmListadoCgg_res_agencia_contacto.prototype.loadData = function(){
	this.loadData();
}
