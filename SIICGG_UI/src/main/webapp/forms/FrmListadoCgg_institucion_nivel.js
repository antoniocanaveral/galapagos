/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_institucion_nivel.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_institucion_nivel(IN_CGNES_CODIGO){
	var urlListadoCgg_institucion_nivel=URL_WS+"Cgg_institucion_nivel";
	var tituloListadoCgg_institucion_nivel='Institucion nivel';
	var descListadoCgg_institucion_nivel='El formulario permite administrar informaci\u00f3n de la tabla Institucion nivel';
	var inCgnes_codigo = IN_CGNES_CODIGO;
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_institucion_nivel.
	*/
	var btnNuevoCgg_institucion_nivel = new Ext.Button({
			id:'btnNuevoCgg_institucion_nivel',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_institucion_nivel = new FrmCgg_institucion_nivel("insert");
					objCgg_institucion_nivel.closeHandler(function(){
							gsCgg_institucion_nivel.reload();
					});
					objCgg_institucion_nivel.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_institucion_nivel.
	*/
	var btnEditarCgg_institucion_nivel = new Ext.Button({
			id:'btnEditarCgg_institucion_nivel',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_institucion_nivel.getSelectionModel().getSelected();
					if(r){
						var objCgg_institucion_nivel = new FrmCgg_institucion_nivel("update",r);
						objCgg_institucion_nivel.closeHandler(function(){
								gsCgg_institucion_nivel.reload();
						});
						objCgg_institucion_nivel.loadData();
						objCgg_institucion_nivel.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_institucion_nivel.
	*/
	var btnEliminarCgg_institucion_nivel = new Ext.Button({
			id:'btnEliminarCgg_institucion_nivel',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_institucion_nivel,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_institucion_nivel(btn){if (btn=='yes'){
						try{
							function CallBackCgg_institucion_nivel(r){
								winFrmListadoCgg_institucion_nivel.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_institucion_nivel,
											msg: 'La informaci\u00f3n de Institucion nivel ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_institucion_nivel.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_institucion_nivel,
											msg: 'La informaci\u00f3n de Institucion nivel no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_institucion_nivel.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCgien_codigo',grdCgg_institucion_nivel.getSelectionModel().getSelected().get('CGIEN_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_institucion_nivel,"delete",param, true, CallBackCgg_institucion_nivel);
						}catch(inErr){
							winFrmListadoCgg_institucion_nivel.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_institucion_nivel.
	*/
	var btnSalirCgg_institucion_nivel = new Ext.Button({
			id:'btnSalirCgg_institucion_nivel',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_institucion_nivel.close();
			}}
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_institucion_nivel.
	*/
	var cmCgg_institucion_nivel = new Ext.grid.ColumnModel([
			{dataIndex:'CGIEN_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CGNES_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CGIED_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CGIED_NOMBRE',header:'Instituci\u00F3n',width:150,sortable:true},
			{dataIndex:'CGIED_DESCRIPCION',header:'Descripci\u00F3n',width:150,sortable:true},
			{dataIndex:'CGIED_DIRECCION',header:'Direcci\u00F3n',width:150,sortable:true}
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_institucion_nivel por un campo especifico.
	*/
	/*var gsCgg_institucion_nivel = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_institucion_nivel",
					method:"selectPage",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CGIEN_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CGIEN_CODIGO'},
				{name:'CGNES_CODIGO'},
				{name:'CGIED_CODIGO'}
			]),
			sortInfo:{field: 'CGNES_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'}
	});*/
	var gsCgg_institucion_nivel = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_institucion_nivel",
					method:"selectPageInstitucionByIdNivel",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CGIEN_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CGIEN_CODIGO'},
				{name:'CGNES_CODIGO'},
				{name:'CGIED_CODIGO'},
				{name:'CGIED_NOMBRE'},
				{name:'CGIED_DESCRIPCION'},
				{name:'CGIED_DIRECCION'}
			]),
			sortInfo:{field: 'CGNES_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON',inCgnes_codigo:inCgnes_codigo}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_institucion_nivel.
	*/
	var pgBarCgg_institucion_nivel= new Ext.PagingToolbar({
			store: gsCgg_institucion_nivel,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_institucion_nivel en un formato tabular de filas y columnas.
	*/
	var grdCgg_institucion_nivel = new Ext.grid.GridPanel({
			cm:cmCgg_institucion_nivel,
			store:gsCgg_institucion_nivel,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_institucion_nivel,
						width:200
				})
			],
			bbar:pgBarCgg_institucion_nivel,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_institucion_nivel.hidden){
						btnEditarCgg_institucion_nivel.fireEvent('click', btnEditarCgg_institucion_nivel);
					}
	}}});
	gsCgg_institucion_nivel.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_institucion_nivel.
	*/
	var winFrmListadoCgg_institucion_nivel = new Ext.Window({
				id:'winFrmListadoCgg_institucion_nivel',
				title:tituloListadoCgg_institucion_nivel,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_institucion_nivel,descListadoCgg_institucion_nivel),
				items:[grdCgg_institucion_nivel],
				bbar:[btnNuevoCgg_institucion_nivel,btnEditarCgg_institucion_nivel,btnEliminarCgg_institucion_nivel,'->',btnSalirCgg_institucion_nivel]
		});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_institucion_nivel.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_institucion_nivel.
	* @returns ventana winFrmCgg_institucion_nivel.
	* @base FrmListadoCgg_institucion_nivel.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_institucion_nivel;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_institucion_nivel.
	* @base FrmListadoCgg_institucion_nivel.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_institucion_nivel.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_institucion_nivel;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_institucion_nivel;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_institucion_nivel.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_institucion_nivel.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_institucion_nivel desde una instancia.
*/
FrmListadoCgg_institucion_nivel.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_institucion_nivel desde una instancia.
*/
FrmListadoCgg_institucion_nivel.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_institucion_nivel,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_institucion_nivel.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_institucion_nivel desde una instancia.
*/
FrmListadoCgg_institucion_nivel.prototype.loadData = function(){
	this.loadData();
}
