/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_idioma_persona.
* @constructor
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_gem_idioma_persona(inDesktop,in_Crper_codigo,IN_ADMINISTRACION,IN_BUSQUEDA_PERFIL){	
	var urlListadoCgg_gem_idioma_persona=URL_WS+"Cgg_gem_idioma_persona";
	var tituloListadoCgg_gem_idioma_persona='Listado de idiomas de la persona';
	var descListadoCgg_gem_idioma_persona='El formulario permite administrar informaci\u00f3n sobre los idiomas de una persona';
	//var in_Crper_codigo = "CRPER1010";
	var RECORD_PAGE=30;
	
	function rndPorcentaje(v){
		return v + " %";
	}
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_idioma_persona.
	*/
	var btnNuevoCgg_gem_idioma_persona = new Ext.Button({
			id:'btnNuevoCgg_gem_idioma_persona',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_gem_idioma_persona = new FrmCgg_gem_idioma_persona("insert","",in_Crper_codigo);
					objCgg_gem_idioma_persona.closeHandler(function(){
							gsCgg_gem_idioma_persona.reload();
					});
					objCgg_gem_idioma_persona.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_idioma_persona.
	*/
	var btnEditarCgg_gem_idioma_persona = new Ext.Button({
			id:'btnEditarCgg_gem_idioma_persona',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_gem_idioma_persona.getSelectionModel().getSelected();
					if(r){
						var objCgg_gem_idioma_persona = new FrmCgg_gem_idioma_persona("update",r,in_Crper_codigo);
						objCgg_gem_idioma_persona.closeHandler(function(){
								gsCgg_gem_idioma_persona.reload();
						});
						objCgg_gem_idioma_persona.loadData();
						objCgg_gem_idioma_persona.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_gem_idioma_persona.
	*/
	var btnEliminarCgg_gem_idioma_persona = new Ext.Button({
			id:'btnEliminarCgg_gem_idioma_persona',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_gem_idioma_persona,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_gem_idioma_persona(btn){if (btn=='yes'){
						try{
							function CallBackCgg_gem_idioma_persona(r){
								pnlListadoCgg_gem_idioma_persona.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_gem_idioma_persona,
											msg: 'La informaci\u00f3n sobre el idioma de la persona ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_gem_idioma_persona.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_gem_idioma_persona,
											msg: 'La informaci\u00f3n sobre el idioma no ha podido ser eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							pnlListadoCgg_gem_idioma_persona.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCgidp_codigo',grdCgg_gem_idioma_persona.getSelectionModel().getSelected().get('CGIDP_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_gem_idioma_persona,"delete",param, true, CallBackCgg_gem_idioma_persona);
						}catch(inErr){
							pnlListadoCgg_gem_idioma_persona.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_idioma_persona.
	*/
	var btnSalirCgg_gem_idioma_persona = new Ext.Button({
			id:'btnSalirCgg_gem_idioma_persona',
			text:'Salir',
			iconCls:'iconSalir',
			//hidden:IN_ADMINISTRACION?true:false,
			listeners:{
				click:function(){
					if(IN_ADMINISTRACION)
						Ext.getCmp('btnSalirCgg_gem_administracion_hoja_vida').fireEvent('click');
					else
						winFrmListadoCgg_gem_idioma_persona.close();
			}}
	});	
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_idioma_persona.
	*/
	var cmCgg_gem_idioma_persona = new Ext.grid.ColumnModel([
			{dataIndex:'CGIDP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CGIDM_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CGIDM_NOMBRE',header:'Idioma',width:80,sortable:true},
			{dataIndex:'CGIDP_ESCRITURA',header:'% Escritura',width:120,sortable:true,renderer: rndPorcentaje},
			{dataIndex:'CGIDP_LECTURA',header:'% Lectura',width:120,sortable:true,renderer:rndPorcentaje},
			{dataIndex:'CGIDP_HABLAR',header:'% Hablar',width:120,sortable:true,renderer:rndPorcentaje},
			{dataIndex:'CGIDP_ESCUCHAR',header:'% Escuchar',width:120,sortable:true,renderer:rndPorcentaje}
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_idioma_persona por un campo especifico.
	*/

	var gsCgg_gem_idioma_persona = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_gem_idioma_persona",
					method:"selectPageIdiomasPersona"
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CRPRC_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CGIDP_CODIGO'},
				{name:'CRPER_CODIGO'},
				{name:'CGIDM_CODIGO'},
				{name:'CGIDM_NOMBRE'},
				{name:'CGIDP_ESCRITURA'},
				{name:'CGIDP_LECTURA'},
				{name:'CGIDP_HABLAR'},
				{name:'CGIDP_ESCUCHAR'}			
			]),
			sortInfo:{field: 'CRPER_CODIGO', direction: 'ASC'},
			baseParams:{start: 0,limit: RECORD_PAGE,keyword:"",format:"JSON",inCrper_codigo:in_Crper_codigo}
	});
	gsCgg_gem_idioma_persona.reload();
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_gem_idioma_persona.
	*/
	var pgBarCgg_gem_idioma_persona= new Ext.PagingToolbar({
			store: gsCgg_gem_idioma_persona,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_idioma_persona en un formato tabular de filas y columnas.
	*/
	var grdCgg_gem_idioma_persona = new Ext.grid.GridPanel({
			cm:cmCgg_gem_idioma_persona,
			store:gsCgg_gem_idioma_persona,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ', ' ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_gem_idioma_persona,
						width:200
				})
			],
			bbar:pgBarCgg_gem_idioma_persona,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_gem_idioma_persona.hidden){
						btnEditarCgg_gem_idioma_persona.fireEvent('click', btnEditarCgg_gem_idioma_persona);
					}
	}}});
	gsCgg_gem_idioma_persona.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:"JSON"
		}
	});
	var pnlListadoCgg_gem_idioma_persona = new Ext.form.FormPanel({
		id:"pnlListadoCgg_gem_idioma_persona",
		items:[grdCgg_gem_idioma_persona],
		region:'center',
		layout: 'border',
		bbar:[btnNuevoCgg_gem_idioma_persona,btnEditarCgg_gem_idioma_persona,btnEliminarCgg_gem_idioma_persona,'->',btnSalirCgg_gem_idioma_persona]
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gem_idioma_persona.
	*/
	if(inDesktop){
		var winFrmListadoCgg_gem_idioma_persona = inDesktop.createWindow({
				id:'winFrmListadoCgg_gem_idioma_persona',
				title:tituloListadoCgg_gem_idioma_persona,
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_gem_idioma_persona,descListadoCgg_gem_idioma_persona),
				items:[pnlListadoCgg_gem_idioma_persona],
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrainHeader:true,
				layout:'border'			
		});
	}else{
		var winFrmListadoCgg_gem_idioma_persona = new Ext.Window({
				id:'winFrmListadoCgg_gem_idioma_persona',
				title:tituloListadoCgg_gem_idioma_persona,
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_gem_idioma_persona,descListadoCgg_gem_idioma_persona),
				items:[pnlListadoCgg_gem_idioma_persona],
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrainHeader:true,
				layout:'border'			
		});

	}
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
//	applyGrants(pnlListadoCgg_gem_idioma_persona.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_idioma_persona.
	* @returns ventana winFrmCgg_gem_idioma_persona.
	* @base FrmListadoCgg_gem_idioma_persona.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_gem_idioma_persona;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gem_idioma_persona.
	* @base FrmListadoCgg_gem_idioma_persona.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_gem_idioma_persona.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_gem_idioma_persona;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_gem_idioma_persona;
	}
	/**
	* Funcion miembro que develve el panel del listado de idiomas de la persona.
	*/
	this.getPanel = function(){
		return pnlListadoCgg_gem_idioma_persona;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_gem_idioma_persona.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_gem_idioma_persona.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_idioma_persona desde una instancia.
*/
FrmListadoCgg_gem_idioma_persona.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_idioma_persona desde una instancia.
*/
FrmListadoCgg_gem_idioma_persona.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_idioma_persona,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_gem_idioma_persona.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gem_idioma_persona desde una instancia.
*/
FrmListadoCgg_gem_idioma_persona.prototype.loadData = function(){
	this.loadData();
}
/**
* Funcion prototipo. Permite obtener el panel del listado de idiomas de la persona
*/
FrmListadoCgg_gem_idioma_persona.prototype.getPanel = function(){
	this.getPanel();
}