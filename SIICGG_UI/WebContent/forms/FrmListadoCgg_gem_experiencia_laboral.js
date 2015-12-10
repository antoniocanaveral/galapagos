/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_experiencia_laboral.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_gem_experiencia_laboral(inDesktop,IN_CRPER_CODIGO,IN_ADMINISTRACION,IN_BUSQUEDA_PERFIL){
	var urlListadoCgg_gem_experiencia_laboral=URL_WS+"Cgg_gem_experiencia_laboral";
	var tituloListadoCgg_gem_experiencia_laboral='Experiencia laboral';
	var descListadoCgg_gem_experiencia_laboral='El formulario permite administrar informaci\u00f3n sobre la experiencia laboral de la persona';
	var inCrper_codigo=IN_CRPER_CODIGO;
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_experiencia_laboral.
	*/
	var btnNuevoCgg_gem_experiencia_laboral = new Ext.Button({
			id:'btnNuevoCgg_gem_experiencia_laboral',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_gem_experiencia_laboral = new FrmCgg_gem_experiencia_laboral("insert","",inCrper_codigo);
					objCgg_gem_experiencia_laboral.closeHandler(function(){
							gsCgg_gem_experiencia_laboral.reload();
					});
					objCgg_gem_experiencia_laboral.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_experiencia_laboral.
	*/
	var btnEditarCgg_gem_experiencia_laboral = new Ext.Button({
			id:'btnEditarCgg_gem_experiencia_laboral',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_gem_experiencia_laboral.getSelectionModel().getSelected();
					if(r){
						var objCgg_gem_experiencia_laboral = new FrmCgg_gem_experiencia_laboral("update",r,inCrper_codigo);
						objCgg_gem_experiencia_laboral.closeHandler(function(){
								gsCgg_gem_experiencia_laboral.reload();
						});
						objCgg_gem_experiencia_laboral.loadData();
						objCgg_gem_experiencia_laboral.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_gem_experiencia_laboral.
	*/
	var btnEliminarCgg_gem_experiencia_laboral = new Ext.Button({
			id:'btnEliminarCgg_gem_experiencia_laboral',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_gem_experiencia_laboral,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_gem_experiencia_laboral(btn){if (btn=='yes'){
						try{
							function CallBackCgg_gem_experiencia_laboral(r){
								pnlListadoCgg_gem_experiencia_laboral.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_gem_experiencia_laboral,
											msg: 'La informaci\u00f3n sobre la experiencia laboral ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_gem_experiencia_laboral.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_gem_experiencia_laboral,
											msg: 'La informaci\u00f3n sobre la experiencia laboral no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							pnlListadoCgg_gem_experiencia_laboral.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCgexl_codigo',grdCgg_gem_experiencia_laboral.getSelectionModel().getSelected().get('CGEXL_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_gem_experiencia_laboral,"delete",param, true, CallBackCgg_gem_experiencia_laboral);
						}catch(inErr){
							pnlListadoCgg_gem_experiencia_laboral.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_experiencia_laboral.
	*/
	var btnSalirCgg_gem_experiencia_laboral = new Ext.Button({
			id:'btnSalirCgg_gem_experiencia_laboral',
			text:'Salir',
			iconCls:'iconSalir',
			//hidden:IN_ADMINISTRACION?true:false,
			listeners:{
				click:function(){
					if(IN_ADMINISTRACION)
						Ext.getCmp('btnSalirCgg_gem_administracion_hoja_vida').fireEvent('click');
					else
						winFrmListadoCgg_gem_experiencia_laboral.close();
			}}
	});	
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_experiencia_laboral.
	*/	
    function rndFormatFecha(v){
		alert(v);
		alert(Ext.util.Format.date(v,"Y-m-d H:i"));
		return Ext.util.Format.date(v,"Y-m-d");
		
	}
	var cmCgg_gem_experiencia_laboral = new Ext.grid.ColumnModel([
			{dataIndex:'CGEXL_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},			
			{dataIndex:'CGEXL_RAZON_SOCIAL',header:'Razon social',width:130,sortable:true},
			{dataIndex:'CGEXL_CIUDAD',header:'Ciudad',width:130,sortable:true},
			{dataIndex:'CGEXL_CARGO',header:'Cargo',width:150,sortable:true},
			{dataIndex:'CGEXL_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
			{dataIndex:'CGEXL_PERSONAS_CARGO',header:'Personas a cargo',width:120,sortable:true},
			{dataIndex:'CGEXL_FECHA_INICIO',header:'Fecha inicio',width:90,sortable:true,renderer:truncDate},
			{dataIndex:'CGEXL_FECHA_FIN',header:'Fecha fin',width:90,sortable:true,renderer:truncDate},			
			{dataIndex:'CGEXL_CONTACTO',header:'Referencia',width:150,sortable:true},
			{dataIndex:'CGEXL_TELEFONO',header:'Telefono',width:90,sortable:true},
	{dataIndex:'CGEXL_OBSERVACIONES',header:'Observaciones',width:150,sortable:true}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_experiencia_laboral por un campo especifico.
	*/
	var gsCgg_gem_experiencia_laboral = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_gem_experiencia_laboral",
					method:"selectPageExpLabPersona",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CGEXL_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CGEXL_CODIGO'},
				{name:'CRPER_CODIGO'},
				{name:'CGEXL_FECHA_INICIO'},
				{name:'CGEXL_FECHA_FIN'},
				{name:'CGEXL_RAZON_SOCIAL'},
				{name:'CGEXL_CIUDAD'},
				{name:'CGEXL_CARGO'},
				{name:'CGEXL_DESCRIPCION'},
				{name:'CGEXL_PERSONAS_CARGO'},
				{name:'CGEXL_CONTACTO'},
				{name:'CGEXL_TELEFONO'},
				{name:'CGEXL_OBSERVACIONES'}
			]),
			sortInfo:{field: 'CRPER_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON',inCrper_codigo:inCrper_codigo},
			listeners:{
				'load':function(){
					//alert(gsCgg_gem_experiencia_laboral.getAt(0).get('CGEXL_FECHA_INICIO'))
				}
			}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_gem_experiencia_laboral.
	*/
	var pgBarCgg_gem_experiencia_laboral= new Ext.PagingToolbar({
			store: gsCgg_gem_experiencia_laboral,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_experiencia_laboral en un formato tabular de filas y columnas.
	*/
	var grdCgg_gem_experiencia_laboral = new Ext.grid.GridPanel({
			cm:cmCgg_gem_experiencia_laboral,
			store:gsCgg_gem_experiencia_laboral,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_gem_experiencia_laboral,
						width:200
				})
			],
			bbar:pgBarCgg_gem_experiencia_laboral,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_gem_experiencia_laboral.hidden){
						btnEditarCgg_gem_experiencia_laboral.fireEvent('click', btnEditarCgg_gem_experiencia_laboral);
					}
	}}});
	gsCgg_gem_experiencia_laboral.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	var pnlListadoCgg_gem_experiencia_laboral = new Ext.form.FormPanel({
		id:"pnlListadoCgg_gem_experiencia_laboral",
		items:[grdCgg_gem_experiencia_laboral],
		region:'center',
		layout: 'border',
		bbar:[btnNuevoCgg_gem_experiencia_laboral,btnEditarCgg_gem_experiencia_laboral,btnEliminarCgg_gem_experiencia_laboral,'->',btnSalirCgg_gem_experiencia_laboral]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gem_experiencia_laboral.
	*/
	if(inDesktop){
		var winFrmListadoCgg_gem_experiencia_laboral = inDesktop.createWindow({
				id:'winFrmListadoCgg_gem_experiencia_laboral',
				title:tituloListadoCgg_gem_experiencia_laboral,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrainHeader:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_gem_experiencia_laboral,descListadoCgg_gem_experiencia_laboral),
				items:[pnlListadoCgg_gem_experiencia_laboral]			
		});
	}else{
		var winFrmListadoCgg_gem_experiencia_laboral = new Ext.Window({
				id:'winFrmListadoCgg_gem_experiencia_laboral',
				title:tituloListadoCgg_gem_experiencia_laboral,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrainHeader:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_gem_experiencia_laboral,descListadoCgg_gem_experiencia_laboral),
				items:[pnlListadoCgg_gem_experiencia_laboral]			
		});
	}
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
//	applyGrants(pnlListadoCgg_gem_experiencia_laboral.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_experiencia_laboral.
	* @returns ventana winFrmCgg_gem_experiencia_laboral.
	* @base FrmListadoCgg_gem_experiencia_laboral.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_gem_experiencia_laboral;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gem_experiencia_laboral.
	* @base FrmListadoCgg_gem_experiencia_laboral.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_gem_experiencia_laboral.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_gem_experiencia_laboral;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_gem_experiencia_laboral;
	}
	/**
	* Funcion miembro que develve el panel del listado sobre la experiencia laboral de la persona.
	*/
	this.getPanel = function(){
		return pnlListadoCgg_gem_experiencia_laboral;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_gem_experiencia_laboral.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_gem_experiencia_laboral.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_experiencia_laboral desde una instancia.
*/
FrmListadoCgg_gem_experiencia_laboral.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_experiencia_laboral desde una instancia.
*/
FrmListadoCgg_gem_experiencia_laboral.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_experiencia_laboral,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_gem_experiencia_laboral.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gem_experiencia_laboral desde una instancia.
*/
FrmListadoCgg_gem_experiencia_laboral.prototype.loadData = function(){
	this.loadData();
}
/**
* Funcion prototipo. Permite obtener el panel del listado sobre la experiencia laboral de la persona
*/
FrmListadoCgg_gem_experiencia_laboral.prototype.getPanel = function(){
	this.getPanel();
}
