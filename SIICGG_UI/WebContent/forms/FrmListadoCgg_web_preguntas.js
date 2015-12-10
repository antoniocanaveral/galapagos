/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_web_preguntas.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_web_preguntas(inDesktop){
	var optMenu = 'Sitio Web/Preguntas frecuentes';
	var urlListadoCgg_web_preguntas=URL_WS+"Cgg_web_preguntas";
	var tituloListadoCgg_web_preguntas='Preguntas frecuentes';
	var descListadoCgg_web_preguntas='El formulario permite administrar informaci\u00f3n sobre las preguntas frecuentes que fueron ingresadas desde el sistema de atenci\u00F3n al cliente';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_web_preguntas.
	*/
	var btnNuevoCgg_web_preguntas = new Ext.Button({
			id:'btnNuevoCgg_web_preguntas',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_web_preguntas = new FrmCgg_web_preguntas("insert");
					objCgg_web_preguntas.closeHandler(function(){
							gsCgg_web_preguntas.reload();
					});
					objCgg_web_preguntas.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_web_preguntas.
	*/
	var btnEditarCgg_web_preguntas = new Ext.Button({
			id:'btnEditarCgg_web_preguntas',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_web_preguntas.getSelectionModel().getSelected();
					if(r){
						var objCgg_web_preguntas = new FrmCgg_web_preguntas("update",r);
						objCgg_web_preguntas.closeHandler(function(){
								gsCgg_web_preguntas.reload();
						});
						objCgg_web_preguntas.loadData();
						objCgg_web_preguntas.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_web_preguntas.
	*/
	var btnEliminarCgg_web_preguntas = new Ext.Button({
			id:'btnEliminarCgg_web_preguntas',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'\u00BFSeguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_web_preguntas,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_web_preguntas(btn){if (btn=='yes'){
						try{
							function CallBackCgg_web_preguntas(r){
								winFrmListadoCgg_web_preguntas.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_web_preguntas,
											msg: 'La informaci\u00f3n de la pregunta ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_web_preguntas.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_web_preguntas,
											msg: 'La informaci\u00f3n de la pregunta no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_web_preguntas.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCwprg_codigo',grdCgg_web_preguntas.getSelectionModel().getSelected().get('CWPRG_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_web_preguntas,"delete",param, true, CallBackCgg_web_preguntas);
						}catch(inErr){
							winFrmListadoCgg_web_preguntas.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_web_preguntas.
	*/
	var btnSalirCgg_web_preguntas = new Ext.Button({
			id:'btnSalirCgg_web_preguntas',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_web_preguntas.close();
			}}
	});
	
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_web_preguntas.
	*/
	var cmCgg_web_preguntas = new Ext.grid.ColumnModel([
			{dataIndex:'CWPRG_CODIGO',header:'C\u00F3digo',width:150,sortable:true,hidden:true},			
			{dataIndex:'CWMOD_NOMBRE',header:'M\u00F3dulo',width:150,sortable:true,hidden:true},
			{dataIndex:'CWPRG_PREGUNTA',header:'Pregunta',width:350,sortable:true},
			{dataIndex:'CWPRG_RESPUESTA',header:'Respuesta',width:250,sortable:true},
			{dataIndex:'CWPRG_OBSERVACION',header:'Observaci\u00F3n',width:150,sortable:true,hidden:true},
			{dataIndex:'CWPRG_PRIORIDAD',header:'Prioridad',width:150,sortable:true,hidden:true}
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_web_preguntas por un campo especifico.
	*/
	var gsCgg_web_preguntas = new Ext.data.GroupingStore({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_web_preguntas",
					method:"selectPageDirect",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CWPRG_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CWPRG_CODIGO'},
				{name:'CWMOD_CODIGO'},
				{name:'CWPRG_PREGUNTA'},
				{name:'CWPRG_RESPUESTA'},
				{name:'CWPRG_OBSERVACION'},
				{name:'CWPRG_PRIORIDAD'},
				{name:'CWMOD_NOMBRE'}
			]),
			sortInfo:{field: 'CWMOD_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'},
			groupField:'CWMOD_NOMBRE'
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_web_preguntas.
	*/
	var pgBarCgg_web_preguntas= new Ext.PagingToolbar({
			store: gsCgg_web_preguntas,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_web_preguntas en un formato tabular de filas y columnas.
	*/
	var grdCgg_web_preguntas = new Ext.grid.GridPanel({
			cm:cmCgg_web_preguntas,
			store:gsCgg_web_preguntas,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			view: new Ext.grid.GroupingView({
                groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
            }),
			viewConfig:{forceFit:true},
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_web_preguntas,
						width:200
				})
			],
			bbar:pgBarCgg_web_preguntas,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_web_preguntas.hidden){
						btnEditarCgg_web_preguntas.fireEvent('click', btnEditarCgg_web_preguntas);
					}
	}}});
	gsCgg_web_preguntas.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_web_preguntas.
	*/
	if(inDesktop){	
		var winFrmListadoCgg_web_preguntas = inDesktop.createWindow({
				id:'winFrmListadoCgg_web_preguntas',
				title:tituloListadoCgg_web_preguntas,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_web_preguntas,descListadoCgg_web_preguntas),
				items:[grdCgg_web_preguntas],
				bbar:[btnNuevoCgg_web_preguntas,btnEditarCgg_web_preguntas,btnEliminarCgg_web_preguntas,'->',btnSalirCgg_web_preguntas]
		});
	}else{
		var winFrmListadoCgg_web_preguntas = new Ext.Window({
			id:'winFrmListadoCgg_web_preguntas',
			title:tituloListadoCgg_web_preguntas,
			iconCls:'iconAplicacion',
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			layout:'border',
			tbar:getPanelTitulo('Listado '+tituloListadoCgg_web_preguntas,descListadoCgg_web_preguntas),
			items:[grdCgg_web_preguntas],
			bbar:[btnNuevoCgg_web_preguntas,btnEditarCgg_web_preguntas,btnEliminarCgg_web_preguntas,'->',btnSalirCgg_web_preguntas]
		});
	}
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_web_preguntas.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_web_preguntas.
	* @returns ventana winFrmCgg_web_preguntas.
	* @base FrmListadoCgg_web_preguntas.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_web_preguntas;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_web_preguntas.
	* @base FrmListadoCgg_web_preguntas.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_web_preguntas.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_web_preguntas;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_web_preguntas;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_web_preguntas.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_web_preguntas.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_web_preguntas desde una instancia.
*/
FrmListadoCgg_web_preguntas.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_web_preguntas desde una instancia.
*/
FrmListadoCgg_web_preguntas.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_web_preguntas,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_web_preguntas.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_web_preguntas desde una instancia.
*/
FrmListadoCgg_web_preguntas.prototype.loadData = function(){
	this.loadData();
}
