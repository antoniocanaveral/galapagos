/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_sec_objeto.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function DlgBusquedaObjDep(inObject, inObjectType){
	var optMenu = 'Seguridad/Objetos';
	var urlListadoCgg_sec_objeto=URL_WS+"Cgg_sec_objeto";
	var tituloListadoCgg_sec_objeto='Listado de objetos del sistema';
	var descListadoCgg_sec_objeto='El formulario permite visualizar la informaci\u00f3n de los objetos.';
	var tmpSelectedRows;
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winDlgBusquedaObjDep.
	*/
	var btnSelecDepCgg_sec_objeto = new Ext.Button({
			id:'btnSelecDepCgg_sec_objeto',
			text:'Seleccionar',
			iconCls:'iconAceptar',
			listeners:{
				click:function(){
					if(inObjectType==0)
						tmpSelectedRows = smObjDep.getSelections();
					else
						tmpSelectedRows = smWSDep.getSelections();
					winDlgBusquedaObjDep.close();
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winDlgBusquedaObjDep.
	*/
	var btnSalirDepCgg_sec_objeto = new Ext.Button({
			id:'btnSalirDepCgg_sec_objeto',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winDlgBusquedaObjDep.close();
			}}
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sec_objeto.
	*/
	var smObjDep = new Ext.grid.CheckboxSelectionModel();
	var cmCgg_sec_objeto = new Ext.grid.ColumnModel([
		smObjDep,
		{dataIndex:'CSOBJ_NOMBRE',header:'Nombre',width:200,sortable:true},
		{dataIndex:'CSOBJ_RUTA',header:'Ruta',width:150,sortable:true,hidden:true},
		{dataIndex:'CSOBJ_DESCRIPCION',header:'Descripci\u00f3n',width:350,sortable:true}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_sec_objeto por un campo especifico.
	*/
	var gsCgg_sec_objeto_dep = new Ext.data.GroupingStore({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_sec_obj_dependencia",
					method:"selectPageDirect",
					pagin:true
			}),
			remoteSort:true,
			groupField:'CSOBJ_RUTA',
			reader:new Ext.data.JsonReader({
					id:'CSOBJ_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CSOBJ_CODIGO'},
				{name:'CSOBJ_NOMBRE'},
				{name:'CSOBJ_RUTA'},
				{name:'CSOBJ_DESCRIPCION'}
			]),
				sortInfo:{field: 'CSOBJ_RUTA', direction: 'ASC'},
				baseParams:{keyword:"",
					format:'JSON',
					inTypeObject:'0',
					inCsobj_codigo:inObject.get('CSOBJ_CODIGO'),
					inSW:true}
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sec_objeto.
	*/
	var smWSDep = new Ext.grid.CheckboxSelectionModel();
	var cmWSObjetosDep = new Ext.grid.ColumnModel([
		smWSDep,
		{dataIndex:'CSOBJ_NOMBRE',header:'Nombre',width:200,sortable:true},
		{dataIndex:'CSOBJ_RUTA',header:'Ruta',width:150,sortable:true,hidden:true},
		{dataIndex:'CSOBJ_DESCRIPCION',header:'Descripci\u00f3n',width:350,sortable:true}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_sec_objeto por un campo especifico.
	*/
	var gsWSObjetosDep = new Ext.data.GroupingStore({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_sec_obj_dependencia",
			method:"selectPageDirect",
			pagin:true
		}),
		remoteSort:true,
		groupField:'CSOBJ_RUTA',
		reader:new Ext.data.JsonReader({
			id:'CSOBJ_CODIGO',
			root:'dataSet',
			totalProperty: 'totalCount'
		},[
		{name:'CSOBJ_CODIGO'},
		{name:'CSOBJ_NOMBRE'},
		{name:'CSOBJ_RUTA'},
		{name:'CSOBJ_DESCRIPCION'}
		]),
		sortInfo:{field: 'CSOBJ_RUTA', direction: 'ASC'},
		baseParams:{keyword:"",format:'JSON',inTypeObject:'1',inCsobj_codigo:inObject.get('CSOBJ_CODIGO'),inSW:true}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_sec_objeto.
	*/
	var pgBarCgg_sec_objetoDep = new Ext.PagingToolbar({
			store: gsCgg_sec_objeto_dep,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_sec_objeto.
	*/
	var pgBarWSObjetosDep= new Ext.PagingToolbar({
		store: gsWSObjetosDep,
		displayInfo: true,
		pageSize:RECORD_PAGE,
		displayMsg: 'Mostrando {0} - {1} de {2}',
		temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sec_objeto en un formato tabular de filas y columnas.
	*/
	var grdCgg_sec_objeto_dep = new Ext.grid.GridPanel({
			cm:cmCgg_sec_objeto,
			store:gsCgg_sec_objeto_dep,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_sec_objeto_dep,
						width:200
				})
			],
			sm:smObjDep,
			view: new Ext.grid.GroupingView({
				groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
			}),
			bbar:pgBarCgg_sec_objetoDep
	});
	gsCgg_sec_objeto_dep.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sec_objeto en un formato tabular de filas y columnas.
	*/
	var grdWSObjetosDep = new Ext.grid.GridPanel({
		cm:cmWSObjetosDep,
		store:gsWSObjetosDep,
		region:'center',
		sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
		loadMask:{msg:"Cargando..."},
		tbar: [
				'Buscar: ',
		new Ext.ux.bsx.SearchField({
			store:gsWSObjetosDep,
			width:200
		})
				],
				view: new Ext.grid.GroupingView({
					groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
				}),
				bbar:pgBarWSObjetosDep,
				sm:smWSDep
	});
	gsWSObjetosDep.reload({params:{
		start:0,
		limit:RECORD_PAGE,
		format:'JSON'
	}
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_sec_objeto.
	*/
	var winDlgBusquedaObjDep = new Ext.Window({
			id:'winDlgBusquedaObjDep',
			title:tituloListadoCgg_sec_objeto,
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			modal:true,
			layout:'border',
			bbar:[btnSelecDepCgg_sec_objeto,'->',btnSalirDepCgg_sec_objeto]
	});
	if(inObjectType==0)
		winDlgBusquedaObjDep.add(grdCgg_sec_objeto_dep);
	else
		winDlgBusquedaObjDep.add(grdWSObjetosDep);
	/**
	* Funcion miembro que devuelve la ventana winDlgBusquedaObjDep.
	* @returns ventana winFrmCgg_sec_objeto.
	* @base DlgBusquedaObjDep.prototype.show
	*/
	this.getWindow = function(){
		return winDlgBusquedaObjDep;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winDlgBusquedaObjDep.
	* @base DlgBusquedaObjDep.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_sec_objeto_dep.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_sec_objeto;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_sec_objeto_dep;
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getWSColumnModel = function(){
		return cmWSObjetosDep;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getWSStore = function(){
		return gsWSObjetosDep;
	}
	
	this.getSelectedRows = function(){
		return tmpSelectedRows;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
DlgBusquedaObjDep.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
DlgBusquedaObjDep.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
DlgBusquedaObjDep.prototype.getWSColumnModel = function(){
	this.getWSColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
DlgBusquedaObjDep.prototype.getWSStore = function(){
	this.getWSStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winDlgBusquedaObjDep desde una instancia.
*/
DlgBusquedaObjDep.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winDlgBusquedaObjDep desde una instancia.
*/
DlgBusquedaObjDep.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winDlgBusquedaObjDep,
* con el fin de realizar otras acciones desde una instancia.
*/
DlgBusquedaObjDep.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winDlgBusquedaObjDep desde una instancia.
*/
DlgBusquedaObjDep.prototype.loadData = function(){
	this.loadData();
}
/**
 * Funcion prototipo. Devuelve las filas seleccionadas.
 */
DlgBusquedaObjDep.prototype.getSelectedRows = function(){
    this.getSelectedRows();
}