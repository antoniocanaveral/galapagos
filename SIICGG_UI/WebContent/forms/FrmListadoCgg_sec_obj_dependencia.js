/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_sec_obj_dependencias.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_sec_obj_dependencia(inDesktop, inObject, inObjectType){
	var urlListadoCgg_sec_obj_dependencia=URL_WS+"Cgg_sec_obj_dependencia";
	var tituloListadoCgg_sec_obj_dependencias='Dependencias';
	var descListadoCgg_sec_obj_dependencias='El formulario permite administrar las dependencias de los objetos del sistema.';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_sec_obj_dependencia.
	*/
	var btnNuevoCgg_sec_obj_dependencia = new Ext.Button({
			id:'btnNuevoCgg_sec_obj_dependencia',
			text:'Agregar',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var tmpObjDep = new DlgBusquedaObjDep(inObject, inObjectType);
					tmpObjDep.closeHandler(function(){
						var tmpRows = tmpObjDep.getSelectedRows();
						if(tmpRows){
							function CallbackAddDep(r){
								winFrmListadoCgg_sec_obj_dependencia.getEl().unmask();
								gsCgg_sec_obj_dependencia.reload();
							}
							winFrmListadoCgg_sec_obj_dependencia.getEl().mask('Agregando dependencias ...', 'x-mask-loading');
							var tmpJSONObj = '[';
							for (i in tmpRows){
								if(i < tmpRows.length){
									if(tmpJSONObj.length > 1)
										tmpJSONObj += ',';
									tmpJSONObj += '{\"CSOBJ_CODIGO\":\"'+inObject.get('CSOBJ_CODIGO')+'\",';
									tmpJSONObj += '\"CGG_CSOBJ_CODIGO\":\"'+tmpRows[i].data.CSOBJ_CODIGO+'\"}';
								}
							}
							tmpJSONObj += ']';
							var param = new SOAPClientParameters();
							param.add('inObjects',tmpJSONObj);
							SOAPClient.invoke(urlListadoCgg_sec_obj_dependencia,'insertJSON',param, true, CallbackAddDep);
						}
					});
					tmpObjDep.show();
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_sec_obj_dependencia.
	*/
	var btnEliminarCgg_sec_obj_dependencia = new Ext.Button({
			id:'btnEliminarCgg_sec_obj_dependencia',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_sec_obj_dependencias,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_sec_obj_dependencias(btn){if (btn=='yes'){
						try{
							function CallBackCgg_sec_obj_dependencias(r){
								winFrmListadoCgg_sec_obj_dependencia.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_sec_obj_dependencias,
											msg: 'La informaci\u00f3n de dependencias ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_sec_obj_dependencia.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_sec_obj_dependencias,
											msg: 'La informaci\u00f3n de dependencias no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_sec_obj_dependencia.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCsbjd_codigo',grdCgg_sec_obj_dependencia.getSelectionModel().getSelected().get('CSBJD_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_sec_obj_dependencia,"delete",param, true, CallBackCgg_sec_obj_dependencias);
						}catch(inErr){
							winFrmListadoCgg_sec_obj_dependencia.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_sec_obj_dependencia.
	*/
	var btnSalirCgg_sec_obj_dependencia = new Ext.Button({
			id:'btnSalirCgg_sec_obj_dependencia',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_sec_obj_dependencia.close();
			}}
	});	
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sec_obj_dependencias.
	*/
	var cmCgg_sec_obj_dependencia = new Ext.grid.ColumnModel([
		{dataIndex:'CSOBJ_NOMBRE',header:'Nombre',width:200,sortable:true},
		{dataIndex:'CSOBJ_RUTA',header:'Ruta',width:150,sortable:true,hidden:true},
		{dataIndex:'CSOBJ_DESCRIPCION',header:'Descripci\u00f3n',width:350,sortable:true}
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_sec_obj_dependencias por un campo especifico.
	*/
	var gsCgg_sec_obj_dependencia = new Ext.data.GroupingStore({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_sec_obj_dependencia",
					method:"selectPageDirect",
					pagin:true
			}),
			remoteSort:true,
			groupField:'CSOBJ_RUTA',
			reader:new Ext.data.JsonReader({
					id:'CSBJD_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CSBJD_CODIGO'},
				{name:'CSOBJ_CODIGO'},
				{name:'CGG_CSOBJ_CODIGO'},
				{name:'CSOBJ_NOMBRE'},
				{name:'CSOBJ_RUTA'},
				{name:'CSOBJ_DESCRIPCION'}
			]),
			sortInfo:{field: 'CSOBJ_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",
				format:'JSON',
				inCsobj_codigo:inObject.get('CSOBJ_CODIGO'),
				inSW:false,
				inTypeObject:inObjectType}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_sec_obj_dependencias.
	*/
	var pgBarCgg_sec_obj_dependencia= new Ext.PagingToolbar({
			store: gsCgg_sec_obj_dependencia,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sec_obj_dependencias en un formato tabular de filas y columnas.
	*/
	var grdCgg_sec_obj_dependencia = new Ext.grid.GridPanel({
			cm:cmCgg_sec_obj_dependencia,
			store:gsCgg_sec_obj_dependencia,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_sec_obj_dependencia,
						width:200
				})
			],
			view: new Ext.grid.GroupingView({
				groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
			}),
			bbar:pgBarCgg_sec_obj_dependencia,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEliminarCgg_sec_obj_dependencia.hidden){
						btnEliminarCgg_sec_obj_dependencia.fireEvent('click', btnEliminarCgg_sec_obj_dependencia);
					}
	}}});
	gsCgg_sec_obj_dependencia.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	var tmpDepPanel = new Ext.Panel({
		frame:true,
		layout:'border',
		region:'center',
		tbar:['<b>Ruta:</b> '+inObject.get('CSOBJ_RUTA')+' <b>Objeto:</b> '+inObject.get('CSOBJ_NOMBRE')],
		items:[grdCgg_sec_obj_dependencia]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_sec_obj_dependencias.
	*/
	if(inDesktop){
		var winFrmListadoCgg_sec_obj_dependencia = inDesktop.createWindow({
				id:'winFrmListadoCgg_sec_obj_dependencia',
				title:tituloListadoCgg_sec_obj_dependencias,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo('Listado de '+tituloListadoCgg_sec_obj_dependencias,descListadoCgg_sec_obj_dependencias),
				items:[tmpDepPanel],
				bbar:[btnNuevoCgg_sec_obj_dependencia,btnEliminarCgg_sec_obj_dependencia,'->',btnSalirCgg_sec_obj_dependencia]
		});
		/**
		* Funcion que aplica los privilegios del usuario.
		*/
		applyGrants(winFrmListadoCgg_sec_obj_dependencia.getBottomToolbar());
	}
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_sec_obj_dependencia.
	* @returns ventana winFrmCgg_sec_obj_dependencias.
	* @base FrmListadoCgg_sec_obj_dependencia.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_sec_obj_dependencia;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_sec_obj_dependencia.
	* @base FrmListadoCgg_sec_obj_dependencia.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_sec_obj_dependencia.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_sec_obj_dependencia;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_sec_obj_dependencia;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_sec_obj_dependencia.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_sec_obj_dependencia.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_sec_obj_dependencia desde una instancia.
*/
FrmListadoCgg_sec_obj_dependencia.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_sec_obj_dependencia desde una instancia.
*/
FrmListadoCgg_sec_obj_dependencia.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_sec_obj_dependencia,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_sec_obj_dependencia.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_sec_obj_dependencia desde una instancia.
*/
FrmListadoCgg_sec_obj_dependencia.prototype.loadData = function(){
	this.loadData();
}
