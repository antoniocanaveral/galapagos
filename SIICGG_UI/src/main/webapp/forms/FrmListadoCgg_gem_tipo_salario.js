/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_tipo_salario.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_gem_tipo_salario(){
	var optMenu = 'Gesti\u00F3n de Empleo/Configuraci\u00f3n/Tipo de salarios';
	var urlListadoCgg_gem_tipo_salario=URL_WS+"Cgg_gem_tipo_salario";
	var tituloListadoCgg_gem_tipo_salario='Tipos de salarios';
	var descListadoCgg_gem_tipo_salario='El formulario permite administrar informaci\u00f3n de los tipos de salarios';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_tipo_salario.
	*/
	var btnNuevoCgg_gem_tipo_salario = new Ext.Button({
			id:'btnNuevoCgg_gem_tipo_salario',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_gem_tipo_salario = new FrmCgg_gem_tipo_salario("insert");
					objCgg_gem_tipo_salario.closeHandler(function(){
							gsCgg_gem_tipo_salario.reload();
					});
					objCgg_gem_tipo_salario.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_tipo_salario.
	*/
	var btnEditarCgg_gem_tipo_salario = new Ext.Button({
			id:'btnEditarCgg_gem_tipo_salario',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_gem_tipo_salario.getSelectionModel().getSelected();
					if(r){
						var objCgg_gem_tipo_salario = new FrmCgg_gem_tipo_salario("update",r);
						objCgg_gem_tipo_salario.closeHandler(function(){
								gsCgg_gem_tipo_salario.reload();
						});
						objCgg_gem_tipo_salario.loadData();
						objCgg_gem_tipo_salario.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_gem_tipo_salario.
	*/
	var btnEliminarCgg_gem_tipo_salario = new Ext.Button({
			id:'btnEliminarCgg_gem_tipo_salario',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'\u00BFSeguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_gem_tipo_salario,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_gem_tipo_salario(btn){if (btn=='yes'){
						try{
							function CallBackCgg_gem_tipo_salario(r){
								winFrmListadoCgg_gem_tipo_salario.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_gem_tipo_salario,
											msg: 'La informaci\u00f3n sobre tipo salario ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_gem_tipo_salario.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_gem_tipo_salario,
											msg: 'La informaci\u00f3n sobre tipo salario no ha podido ser eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_gem_tipo_salario.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCgtsa_codigo',grdCgg_gem_tipo_salario.getSelectionModel().getSelected().get('CGTSA_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_gem_tipo_salario,"delete",param, true, CallBackCgg_gem_tipo_salario);
						}catch(inErr){
							winFrmListadoCgg_gem_tipo_salario.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_tipo_salario.
	*/
	var btnSalirCgg_gem_tipo_salario = new Ext.Button({
			id:'btnSalirCgg_gem_tipo_salario',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_gem_tipo_salario.close();
			}}
	});
	
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_tipo_salario.
	*/
	var cmCgg_gem_tipo_salario = new Ext.grid.ColumnModel([
			{dataIndex:'CGTSA_NOMBRE',header:'Nombre',width:150,sortable:true},
	{dataIndex:'CGTSA_DESCRIPCION',header:'Descripci\u00f3n',width:350,sortable:true}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_tipo_salario por un campo especifico.
	*/
	var gsCgg_gem_tipo_salario = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_gem_tipo_salario",
					method:"selectPage",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CGTSA_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CGTSA_CODIGO'},
				{name:'CGTSA_NOMBRE'},
				{name:'CGTSA_DESCRIPCION'}
			]),
			sortInfo:{field: 'CGTSA_NOMBRE', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_gem_tipo_salario.
	*/
	var pgBarCgg_gem_tipo_salario= new Ext.PagingToolbar({
			store: gsCgg_gem_tipo_salario,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_tipo_salario en un formato tabular de filas y columnas.
	*/
	var grdCgg_gem_tipo_salario = new Ext.grid.GridPanel({
			cm:cmCgg_gem_tipo_salario,
			store:gsCgg_gem_tipo_salario,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_gem_tipo_salario,
						width:200
				})
			],
			bbar:pgBarCgg_gem_tipo_salario,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_gem_tipo_salario.hidden){
						btnEditarCgg_gem_tipo_salario.fireEvent('click', btnEditarCgg_gem_tipo_salario);
					}
	}}});
	gsCgg_gem_tipo_salario.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gem_tipo_salario.
	*/
	var winFrmListadoCgg_gem_tipo_salario = new Ext.Window({
			id:'winFrmListadoCgg_gem_tipo_salario',
			title:tituloListadoCgg_gem_tipo_salario,
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrainHeader:true,
			layout:'border',
			tbar:getPanelTitulo('Listado '+tituloListadoCgg_gem_tipo_salario,descListadoCgg_gem_tipo_salario),
			items:[grdCgg_gem_tipo_salario],
			bbar:[btnNuevoCgg_gem_tipo_salario,btnEditarCgg_gem_tipo_salario,btnEliminarCgg_gem_tipo_salario,'->',btnSalirCgg_gem_tipo_salario]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_gem_tipo_salario.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_tipo_salario.
	* @returns ventana winFrmCgg_gem_tipo_salario.
	* @base FrmListadoCgg_gem_tipo_salario.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_gem_tipo_salario;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gem_tipo_salario.
	* @base FrmListadoCgg_gem_tipo_salario.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_gem_tipo_salario.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_gem_tipo_salario;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_gem_tipo_salario;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_gem_tipo_salario.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_gem_tipo_salario.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_tipo_salario desde una instancia.
*/
FrmListadoCgg_gem_tipo_salario.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_tipo_salario desde una instancia.
*/
FrmListadoCgg_gem_tipo_salario.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_tipo_salario,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_gem_tipo_salario.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gem_tipo_salario desde una instancia.
*/
FrmListadoCgg_gem_tipo_salario.prototype.loadData = function(){
	this.loadData();
}
