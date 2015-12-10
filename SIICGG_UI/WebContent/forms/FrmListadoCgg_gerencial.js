/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gerencial.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_gerencial(inDesktop){
	var urlListadoCgg_gerencial=URL_WS+"Cgg_gerencial";
	var tituloListadoCgg_gerencial='Gerencial';
	var descListadoCgg_gerencial='El formulario permite administrar informaci\u00f3n de la tabla Gerencial';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gerencial.
	*/
	var btnNuevoCgg_gerencial = new Ext.Button({
			id:'btnNuevoCgg_gerencial',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_gerencial = new FrmCgg_gerencial("insert");
					objCgg_gerencial.closeHandler(function(){
							gsCgg_gerencial.reload();
					});
					objCgg_gerencial.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gerencial.
	*/
	var btnEditarCgg_gerencial = new Ext.Button({
			id:'btnEditarCgg_gerencial',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_gerencial.getSelectionModel().getSelected();
					if(r){
						var objCgg_gerencial = new FrmCgg_gerencial("update",r);
						objCgg_gerencial.closeHandler(function(){
								gsCgg_gerencial.reload();
						});
						objCgg_gerencial.loadData();
						objCgg_gerencial.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_gerencial.
	*/
	var btnEliminarCgg_gerencial = new Ext.Button({
			id:'btnEliminarCgg_gerencial',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_gerencial,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_gerencial(btn){if (btn=='yes'){
						try{
							function CallBackCgg_gerencial(r){
								winFrmListadoCgg_gerencial.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_gerencial,
											msg: 'La informaci\u00f3n de Gerencial ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_gerencial.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_gerencial,
											msg: 'La informaci\u00f3n de Gerencial no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_gerencial.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCgger_codigo',grdCgg_gerencial.getSelectionModel().getSelected().get('CGGER_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_gerencial,"delete",param, true, CallBackCgg_gerencial);
						}catch(inErr){
							winFrmListadoCgg_gerencial.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gerencial.
	*/
	var btnSalirCgg_gerencial = new Ext.Button({
			id:'btnSalirCgg_gerencial',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_gerencial.close();
			}}
	});	
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gerencial.
	*/
	var cmCgg_gerencial = new Ext.grid.ColumnModel([
			{dataIndex:'CGGER_CODIGO',header:'C\u00F3digo Gerencial',width:150,sortable:true,hidden:true},
			//{dataIndex:'CWMOD_CODIGO',header:'C\u00F3digo M\u00F3dulo',width:150,sortable:true,hidden:true},
			{dataIndex:'CWMOD_CODIGO',header:'M\u00F3dulo',width:150,sortable:true,hidden:true,
				renderer:function(v){
					var params = new SOAPClientParameters();
					params.add('inCwmod_codigo',v);
					params.add('format',TypeFormat.JSON);
					var tmpModulo = SOAPClient.invoke(URL_WS+"PublicWS/Cgg_web_modulo", 'select', params, false, null);
					try{
						tmpModulo = Ext.util.JSON.decode(tmpModulo);
						return tmpModulo[0].CWMOD_NOMBRE;
					}catch(inErr){
						return NO_DATA_MESSAGE;
					}
				}
			},
			{dataIndex:'CGGER_NOMBRE',header:'Nombre',width:150,sortable:true},
			{dataIndex:'CGGER_TITULO',header:'Titulo',width:150,sortable:true},
			{dataIndex:'CGGER_URL',header:'Url',width:150,sortable:true},
			{dataIndex:'CGGER_PARAMETROS',header:'Parametros',width:150,sortable:true},
			{dataIndex:'CGGER_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
			{dataIndex:'CGGER_TIPO',header:'Tipo',width:150,sortable:true,
				renderer:function(v){
					return storeTipoReporte[v][1];
				}
			}
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_gerencial por un campo especifico.
	*/
	var gsCgg_gerencial = new Ext.data.GroupingStore({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_gerencial",
					method:"selectPageDirect",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CGGER_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CGGER_CODIGO'},
				{name:'CWMOD_CODIGO'},
				{name:'CGGER_NOMBRE'},
				{name:'CGGER_TITULO'},
				{name:'CGGER_URL'},
				{name:'CGGER_PARAMETROS'},
				{name:'CGGER_DESCRIPCION'},
				{name:'CGGER_TIPO'}
			]),
			sortInfo:{field: 'CWMOD_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'},
			groupField:'CWMOD_CODIGO'
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_gerencial.
	*/
	var pgBarCgg_gerencial= new Ext.PagingToolbar({
			store: gsCgg_gerencial,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gerencial en un formato tabular de filas y columnas.
	*/
	var grdCgg_gerencial = new Ext.grid.GridPanel({
			cm:cmCgg_gerencial,
			store:gsCgg_gerencial,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			view: new Ext.grid.GroupingView({
                groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
                }),
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_gerencial,
						width:200
				})
			],
			bbar:pgBarCgg_gerencial,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_gerencial.hidden){
						btnEditarCgg_gerencial.fireEvent('click', btnEditarCgg_gerencial);
					}
	}}});
	gsCgg_gerencial.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gerencial.
	*/
	if (inDesktop)
		var winFrmListadoCgg_gerencial = inDesktop.createWindow({
			id:'winFrmListadoCgg_gerencial',
			title:tituloListadoCgg_gerencial,
			iconCls:'iconAplicacion',
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			layout:'border',
			tbar:getPanelTitulo('Listado '+tituloListadoCgg_gerencial,descListadoCgg_gerencial),
			items:[grdCgg_gerencial],
			bbar:[btnNuevoCgg_gerencial,btnEditarCgg_gerencial,btnEliminarCgg_gerencial,'->',btnSalirCgg_gerencial]
		});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_gerencial.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_gerencial.
	* @returns ventana winFrmCgg_gerencial.
	* @base FrmListadoCgg_gerencial.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_gerencial;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gerencial.
	* @base FrmListadoCgg_gerencial.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_gerencial.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_gerencial;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_gerencial;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_gerencial.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_gerencial.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gerencial desde una instancia.
*/
FrmListadoCgg_gerencial.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gerencial desde una instancia.
*/
FrmListadoCgg_gerencial.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gerencial,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_gerencial.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gerencial desde una instancia.
*/
FrmListadoCgg_gerencial.prototype.loadData = function(){
	this.loadData();
}
