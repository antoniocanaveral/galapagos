/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_ger_indicador.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_ger_indicador(inDesktop){
	var urlListadoCgg_ger_indicador=URL_WS+"Cgg_ger_indicador";
	var tituloListadoCgg_ger_indicador='Ger indicador';
	var descListadoCgg_ger_indicador='El formulario permite administrar informaci\u00f3n de la tabla Ger indicador';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_ger_indicador.
	*/
	var btnNuevoCgg_ger_indicador = new Ext.Button({
			id:'btnNuevoCgg_ger_indicador',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_ger_indicador = new FrmCgg_ger_indicador("insert");
					objCgg_ger_indicador.closeHandler(function(){
							gsCgg_ger_indicador.reload();
					});
					objCgg_ger_indicador.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_ger_indicador.
	*/
	var btnEditarCgg_ger_indicador = new Ext.Button({
			id:'btnEditarCgg_ger_indicador',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_ger_indicador.getSelectionModel().getSelected();
					if(r){
						var objCgg_ger_indicador = new FrmCgg_ger_indicador("update",r);
						objCgg_ger_indicador.closeHandler(function(){
								gsCgg_ger_indicador.reload();
						});
						objCgg_ger_indicador.loadData();
						objCgg_ger_indicador.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_ger_indicador.
	*/
	var btnEliminarCgg_ger_indicador = new Ext.Button({
			id:'btnEliminarCgg_ger_indicador',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_ger_indicador,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_ger_indicador(btn){if (btn=='yes'){
						try{
							function CallBackCgg_ger_indicador(r){
								winFrmListadoCgg_ger_indicador.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_ger_indicador,
											msg: 'La informaci\u00f3n de Ger indicador ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_ger_indicador.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_ger_indicador,
											msg: 'La informaci\u00f3n de Ger indicador no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_ger_indicador.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCggin_codigo',grdCgg_ger_indicador.getSelectionModel().getSelected().get('CGGIN_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_ger_indicador,"delete",param, true, CallBackCgg_ger_indicador);
						}catch(inErr){
							winFrmListadoCgg_ger_indicador.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_ger_indicador.
	*/
	var btnSalirCgg_ger_indicador = new Ext.Button({
			id:'btnSalirCgg_ger_indicador',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_ger_indicador.close();
			}}
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_ger_indicador.
	*/
	var cmCgg_ger_indicador = new Ext.grid.ColumnModel([
			{dataIndex:'CGGIN_NOMBRE',header:'Nombre',width:500,sortable:true},
			{dataIndex:'CGGIN_DESCRIPCION',header:'Descripcion',width:350,sortable:true,hidden:true}
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_ger_indicador por un campo especifico.
	*/
	var gsCgg_ger_indicador = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_ger_indicador",
					method:"selectPageDirect",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CGGIN_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CGGIN_CODIGO'},
				{name:'CGGIT_CODIGO'},
				/*{name:'CUSU_CODIGO'},
				{name:'CCTN_CODIGO'},*/
				{name:'CGGIN_NOMBRE'},
				{name:'CGGIN_DESCRIPCION'}
			]),
			sortInfo:{field: 'CGGIT_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_ger_indicador.
	*/
	var pgBarCgg_ger_indicador= new Ext.PagingToolbar({
			store: gsCgg_ger_indicador,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_ger_indicador en un formato tabular de filas y columnas.
	*/
	var grdCgg_ger_indicador = new Ext.grid.GridPanel({
			cm:cmCgg_ger_indicador,
			store:gsCgg_ger_indicador,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_ger_indicador,
						width:200
				})
			],
			bbar:pgBarCgg_ger_indicador,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_ger_indicador.hidden){
						btnEditarCgg_ger_indicador.fireEvent('click', btnEditarCgg_ger_indicador);
					}
	}}});
	gsCgg_ger_indicador.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_ger_indicador.
	*/
	if (inDesktop){
		var winFrmListadoCgg_ger_indicador = inDesktop.createWindow({
				id:'winFrmListadoCgg_ger_indicador',
				title:tituloListadoCgg_ger_indicador,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_ger_indicador,descListadoCgg_ger_indicador),
				items:[grdCgg_ger_indicador],
				bbar:[btnNuevoCgg_ger_indicador,btnEditarCgg_ger_indicador,btnEliminarCgg_ger_indicador,'->',btnSalirCgg_ger_indicador]
		});
	}
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	//applyGrants(winFrmListadoCgg_ger_indicador.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_ger_indicador.
	* @returns ventana winFrmCgg_ger_indicador.
	* @base FrmListadoCgg_ger_indicador.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_ger_indicador;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_ger_indicador.
	* @base FrmListadoCgg_ger_indicador.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_ger_indicador.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_ger_indicador;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_ger_indicador;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_ger_indicador.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_ger_indicador.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_ger_indicador desde una instancia.
*/
FrmListadoCgg_ger_indicador.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_ger_indicador desde una instancia.
*/
FrmListadoCgg_ger_indicador.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_ger_indicador,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_ger_indicador.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_ger_indicador desde una instancia.
*/
FrmListadoCgg_ger_indicador.prototype.loadData = function(){
	this.loadData();
}
