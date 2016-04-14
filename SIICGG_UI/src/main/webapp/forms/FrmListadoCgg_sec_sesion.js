/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_sec_sesion.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_sec_sesion(inDesktop){
	var optMenu = 'Seguridad/Sesiones';
	var urlListadoCgg_sec_sesion=URL_WS+"Cgg_sec_sesion";
	var tituloListadoCgg_sec_sesion='Listado de Sesiones del sistema';
	var descListadoCgg_sec_sesion='El formulario permite administrar las sesiones activas.';
	
	var btnRecargarCgg_sec_sesion = new Ext.Button({
			id:'btnRecargarCgg_sec_sesion',
			text:'Recargar',
			iconCls:'iconRecargar',
			listeners:{
				click:function(){
					gsCgg_sec_sesion.reload();
				}
			}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_sec_sesion.
	*/
	var btnEliminarCgg_sec_sesion = new Ext.Button({
			id:'btnEliminarCgg_sec_sesion',
			text:'Terminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					var r = grdCgg_sec_sesion.getSelectionModel().getSelected();
					if (r) {
						Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de terminar la sesi\u00f3n seleccionada?', buttons: Ext.Msg.YESNO,fn:function (btn){if (btn=='yes'){
								winFrmListadoCgg_sec_sesion.getEl().mask('Eliminando...', 'x-mask-loading');
								Ext.Ajax.request({
										url: URL_APP+"SessionManager",
										success: function(inResponse){
											winFrmListadoCgg_sec_sesion.getEl().unmask();
											Ext.Msg.show({
													title: tituloListadoCgg_sec_sesion,
													msg: 'La sessi\u00f3n ha sido terminada.',
													buttons: Ext.Msg.OK,
													icon: Ext.MessageBox.INFO
											});
											gsCgg_sec_sesion.reload();
										},
										failure: function(inResponse){
											winFrmListadoCgg_sec_sesion.getEl().unmask();
											Ext.Msg.show({
													title: tituloListadoCgg_sec_sesion,
													msg: 'La sessi\u00f3n no ha sido terminada.'+(r.message?r.message:r),
													buttons: Ext.Msg.OK,
													icon: Ext.MessageBox.ERROR
											});
										},
										params: { 
											request: 'kill',
											id:r.get('CSSSN_ID') 
										}
								});
						}},icon: Ext.MessageBox.QUESTION});
					}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_sec_sesion.
	*/
	var btnSalirCgg_sec_sesion = new Ext.Button({
			id:'btnSalirCgg_sec_sesion',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_sec_sesion.close();
			}}
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sec_sesion.
	*/
	var chkUsuarioInterno = new Ext.ux.grid.CheckColumn(
		{dataIndex:'CSSSN_ACTIVO',header:'Activo',width:150,sortable:true}
		);
	var cmCgg_sec_sesion = new Ext.grid.ColumnModel([
                        new Ext.grid.RowNumberer(),
			{dataIndex:'CUSU_NOMBRE_USUARIO',header:'Usuario',width:100,sortable:true},
			{dataIndex:'CSSSN_FECHA_INICIO',header:'Fecha de inicio',width:150,sortable:true,renderer:truncDateTime},
			{dataIndex:'CSSSN_ID',header:'ID',width:250,sortable:true},
			{dataIndex:'CSSSN_IP',header:'IP',width:150,sortable:true},
			chkUsuarioInterno
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_sec_sesion por un campo especifico.
	*/
	var gsCgg_sec_sesion = new Ext.data.Store({
			proxy:new Ext.data.HttpProxy({
					url:URL_APP+"SessionManager",
					method:"POST"
			}),
			reader:new Ext.data.JsonReader({},[
					{name:'CSSSN_CODIGO'},
					{name:'CUSU_CODIGO'},
					{name:'CUSU_NOMBRE_USUARIO'},
					{name:'CSSSN_FECHA_INICIO'},
					{name:'CSSSN_FECHA_FIN'},
					{name:'CSSSN_ID'},
					{name:'CSSSN_IP'},
					{name:'CSSSN_ZONA_TIEMPO'},
					{name:'CSSSN_ACTIVO'}
			]),
			baseParams:{request:'activeSessions'}
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sec_sesion en un formato tabular de filas y columnas.
	*/
	var grdCgg_sec_sesion = new Ext.grid.GridPanel({
			cm:cmCgg_sec_sesion,
			store:gsCgg_sec_sesion,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEliminarCgg_sec_sesion.hidden){
						btnEliminarCgg_sec_sesion.fireEvent('click', btnEliminarCgg_sec_sesion);
					}
	}}});
	gsCgg_sec_sesion.reload();
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_sec_sesion.
	*/
	if(inDesktop){
		var winFrmListadoCgg_sec_sesion = inDesktop.createWindow({
				id:'winFrmListadoCgg_sec_sesion',
				title:tituloListadoCgg_sec_sesion,
				tbar:getPanelTitulo(tituloListadoCgg_sec_sesion,descListadoCgg_sec_sesion),
				items:[grdCgg_sec_sesion],
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				bbar:[btnRecargarCgg_sec_sesion,btnEliminarCgg_sec_sesion,'->',btnSalirCgg_sec_sesion]
		});
		/**
		* Funcion que aplica los privilegios del usuario.
		*/
		applyGrants(winFrmListadoCgg_sec_sesion.getBottomToolbar());
	}
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_sec_sesion.
	* @returns ventana winFrmCgg_sec_sesion.
	* @base FrmListadoCgg_sec_sesion.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_sec_sesion;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_sec_sesion.
	* @base FrmListadoCgg_sec_sesion.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_sec_sesion.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_sec_sesion;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_sec_sesion;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_sec_sesion.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_sec_sesion.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_sec_sesion desde una instancia.
*/
FrmListadoCgg_sec_sesion.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_sec_sesion desde una instancia.
*/
FrmListadoCgg_sec_sesion.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_sec_sesion,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_sec_sesion.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_sec_sesion desde una instancia.
*/
FrmListadoCgg_sec_sesion.prototype.loadData = function(){
	this.loadData();
}
