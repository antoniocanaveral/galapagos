/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_titulo_profesional.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_titulo_profesional(inDesktop){
	var optMenu = 'Configuraci\u00F3n/Educaci\u00F3n/T\u00edtulo Profesional';
	var urlListadoCgg_titulo_profesional=URL_WS+"Cgg_titulo_profesional";
	var tituloListadoCgg_titulo_profesional='Titulo profesional';
	var descListadoCgg_titulo_profesional='El formulario permite administrar informaci\u00f3n de la tabla Titulo profesional';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_titulo_profesional.
	*/
	var btnNuevoCgg_titulo_profesional = new Ext.Button({
			id:'btnNuevoCgg_titulo_profesional',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_titulo_profesional = new FrmCgg_titulo_profesional("insert");
					objCgg_titulo_profesional.closeHandler(function(){
							gsCgg_titulo_profesional.reload();
					});
					objCgg_titulo_profesional.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_titulo_profesional.
	*/
	var btnEditarCgg_titulo_profesional = new Ext.Button({
			id:'btnEditarCgg_titulo_profesional',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_titulo_profesional.getSelectionModel().getSelected();
					if(r){
						var objCgg_titulo_profesional = new FrmCgg_titulo_profesional("update",r);
						objCgg_titulo_profesional.closeHandler(function(){
								gsCgg_titulo_profesional.reload();
						});
						objCgg_titulo_profesional.loadData();
						objCgg_titulo_profesional.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_titulo_profesional.
	*/
	var btnEliminarCgg_titulo_profesional = new Ext.Button({
			id:'btnEliminarCgg_titulo_profesional',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_titulo_profesional,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_titulo_profesional(btn){if (btn=='yes'){
						try{
							function CallBackCgg_titulo_profesional(r){
								winFrmListadoCgg_titulo_profesional.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_titulo_profesional,
											msg: 'La informaci\u00f3n de Titulo profesional ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_titulo_profesional.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_titulo_profesional,
											msg: 'La informaci\u00f3n de Titulo profesional no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_titulo_profesional.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCgtpr_codigo',grdCgg_titulo_profesional.getSelectionModel().getSelected().get('CGTPR_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_titulo_profesional,"delete",param, true, CallBackCgg_titulo_profesional);
						}catch(inErr){
							winFrmListadoCgg_titulo_profesional.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_titulo_profesional.
	*/
	var btnSalirCgg_titulo_profesional = new Ext.Button({
			id:'btnSalirCgg_titulo_profesional',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_titulo_profesional.close();
			}}
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_titulo_profesional.
	*/
	var cmCgg_titulo_profesional = new Ext.grid.ColumnModel([
			{dataIndex:'CGTPR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CGNES_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CGNES_DESCRIPCION',header:'Nivel de Estudio',width:120,sortable:true,hidden:true},
	{dataIndex:'CGTPR_DESCRIPCION',header:'Descripci\u00F3n',width:380,sortable:true}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_titulo_profesional por un campo especifico.
	*/
	var gsCgg_titulo_profesional = new Ext.data.GroupingStore({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_titulo_profesional",
					method:"selectPage",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CGTPR_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CGTPR_CODIGO'},
				{name:'CGNES_CODIGO'},
				{name:'CGNES_DESCRIPCION'},
				{name:'CGTPR_DESCRIPCION'}
			]),
			sortInfo:{field: 'CGNES_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'},
			groupField:'CGNES_DESCRIPCION'
	});
	
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_titulo_profesional.
	*/
	var pgBarCgg_titulo_profesional= new Ext.PagingToolbar({
			store: gsCgg_titulo_profesional,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_titulo_profesional en un formato tabular de filas y columnas.
	*/
	var grdCgg_titulo_profesional = new Ext.grid.GridPanel({
			cm:cmCgg_titulo_profesional,
			store:gsCgg_titulo_profesional,
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
						store:gsCgg_titulo_profesional,
						width:200
				})
			],
			bbar:pgBarCgg_titulo_profesional,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_titulo_profesional.hidden){
						btnEditarCgg_titulo_profesional.fireEvent('click', btnEditarCgg_titulo_profesional);
					}
	}}});
	gsCgg_titulo_profesional.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_titulo_profesional.
	*/
	if(inDesktop!==null && inDesktop!==undefined){
		var winFrmListadoCgg_titulo_profesional = inDesktop.createWindow({
				id:'winFrmListadoCgg_titulo_profesional',
				title:tituloListadoCgg_titulo_profesional,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_titulo_profesional,descListadoCgg_titulo_profesional),
				items:[grdCgg_titulo_profesional],
				bbar:[btnNuevoCgg_titulo_profesional,btnEditarCgg_titulo_profesional,btnEliminarCgg_titulo_profesional,'->',btnSalirCgg_titulo_profesional]
		});
	}else{
		var winFrmListadoCgg_titulo_profesional = new Ext.Window({
				id:'winFrmListadoCgg_titulo_profesional',
				title:tituloListadoCgg_titulo_profesional,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_titulo_profesional,descListadoCgg_titulo_profesional),
				items:[grdCgg_titulo_profesional],
				bbar:[btnNuevoCgg_titulo_profesional,btnEditarCgg_titulo_profesional,btnEliminarCgg_titulo_profesional,'->',btnSalirCgg_titulo_profesional]
		});
	}
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_titulo_profesional.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_titulo_profesional.
	* @returns ventana winFrmCgg_titulo_profesional.
	* @base FrmListadoCgg_titulo_profesional.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_titulo_profesional;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_titulo_profesional.
	* @base FrmListadoCgg_titulo_profesional.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_titulo_profesional.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_titulo_profesional;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_titulo_profesional;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_titulo_profesional.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_titulo_profesional.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_titulo_profesional desde una instancia.
*/
FrmListadoCgg_titulo_profesional.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_titulo_profesional desde una instancia.
*/
FrmListadoCgg_titulo_profesional.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_titulo_profesional,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_titulo_profesional.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_titulo_profesional desde una instancia.
*/
FrmListadoCgg_titulo_profesional.prototype.loadData = function(){
	this.loadData();
}
