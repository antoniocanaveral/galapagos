
/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_destreza_persona.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_gem_destreza_persona(inDesktop,IN_CRPER_CODIGO,IN_ADMINISTRACION,IN_BUSQUEDA_PERFIL){
	var urlListadoCgg_gem_destreza_persona=URL_WS+"Cgg_gem_destreza_persona";
	var tituloListadoCgg_gem_destreza_persona='Listado destreza persona';
	var descListadoCgg_gem_destreza_persona='El formulario permite administrar informaci\u00f3n de destreza/habilidad';
	var inCrper_codigo=IN_CRPER_CODIGO;
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_destreza_persona.
	*/
	var btnNuevoCgg_gem_destreza_persona = new Ext.Button({
			id:'btnNuevoCgg_gem_destreza_persona',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_gem_destreza_persona = new FrmCgg_gem_destreza_persona("insert","",inCrper_codigo);
					objCgg_gem_destreza_persona.closeHandler(function(){
							gsCgg_gem_destreza_persona.reload();
					});
					objCgg_gem_destreza_persona.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_destreza_persona.
	*/
	var btnEditarCgg_gem_destreza_persona = new Ext.Button({
			id:'btnEditarCgg_gem_destreza_persona',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_gem_destreza_persona.getSelectionModel().getSelected();
					if(r){
						var objCgg_gem_destreza_persona = new FrmCgg_gem_destreza_persona("update",r,inCrper_codigo);
						objCgg_gem_destreza_persona.closeHandler(function(){
								gsCgg_gem_destreza_persona.reload();
						});
						objCgg_gem_destreza_persona.loadData();
						objCgg_gem_destreza_persona.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_gem_destreza_persona.
	*/
	var btnEliminarCgg_gem_destreza_persona = new Ext.Button({
			id:'btnEliminarCgg_gem_destreza_persona',
			text:'Eliminar',
			iconCls:'iconEliminar',			
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_gem_destreza_persona,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_gem_destreza_persona(btn){if (btn=='yes'){
						try{
							function CallBackCgg_gem_destreza_persona(r){
								pnlListadoCgg_gem_destreza_persona.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_gem_destreza_persona,
											msg: 'La informaci\u00f3n de destreza/habilidad persona ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_gem_destreza_persona.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_gem_destreza_persona,
											msg: 'La informaci\u00f3n de destreza/habilidad no ha podido ser eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							pnlListadoCgg_gem_destreza_persona.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCgdpr_codigo',grdCgg_gem_destreza_persona.getSelectionModel().getSelected().get('CGDPR_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_gem_destreza_persona,"delete",param, true, CallBackCgg_gem_destreza_persona);
						}catch(inErr){
							pnlListadoCgg_gem_destreza_persona.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_destreza_persona.
	*/
	var btnSalirCgg_gem_destreza_persona = new Ext.Button({
			id:'btnSalirCgg_gem_destreza_persona',
			text:'Salir',
			iconCls:'iconSalir',		
			listeners:{
				click:function(){
					if(IN_ADMINISTRACION)
						Ext.getCmp('btnSalirCgg_gem_administracion_hoja_vida').fireEvent('click');
					else
						winFrmListadoCgg_gem_destreza_persona.close();
			}}
	});	
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_destreza_persona.
	*/
	var cmCgg_gem_destreza_persona = new Ext.grid.ColumnModel([
			{dataIndex:'CGDPR_CODIGO',header:'Codigo destreza persona',width:120,sortable:true,hidden:true},
			{dataIndex:'CRPER_CODIGO',header:'Codigo persona',width:150,sortable:true,hidden:true},
			{dataIndex:'CGDST_CODIGO',header:'Codigo destreza',width:150,sortable:true,hidden:true},
			{dataIndex:'CGDST_DESCRIPCION',header:'Destreza',width:400,sortable:true},
			{dataIndex:'CGDST_TIPO',header:'Tipo',width:400,sortable:true,hidden:true,renderer:function(v){v==true?v='Destreza':v='Habilidad'; return v}}
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_destreza_persona por un campo especifico.
	*/
	var gsCgg_gem_destreza_persona = new Ext.data.GroupingStore({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_gem_destreza_persona",
					method:"selectPageDestrezaHabilidadPersona",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CGDPR_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CGDPR_CODIGO'},
				{name:'CRPER_CODIGO'},
				{name:'CGDST_CODIGO'},
				{name:'CGDST_DESCRIPCION'},
				{name:'CGDST_TIPO'}
			]),
			sortInfo:{field: 'CRPER_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:"JSON",inCrper_codigo:inCrper_codigo},
			groupField:'CGDST_TIPO'
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_gem_destreza_persona.
	*/
	var pgBarCgg_gem_destreza_persona= new Ext.PagingToolbar({
			store: gsCgg_gem_destreza_persona,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_destreza_persona en un formato tabular de filas y columnas.
	*/
	var grdCgg_gem_destreza_persona = new Ext.grid.GridPanel({
			cm:cmCgg_gem_destreza_persona,
			store:gsCgg_gem_destreza_persona,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),			
			loadMask:{msg:"Cargando..."},
			view: new Ext.grid.GroupingView({
                groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
                }),
			viewConfig:{forceFit:true},
			tbar: [
				'Buscar: ', ' ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_gem_destreza_persona,
						width:200
				})
			],
			bbar:pgBarCgg_gem_destreza_persona,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_gem_destreza_persona.hidden){
						btnEditarCgg_gem_destreza_persona.fireEvent('click', btnEditarCgg_gem_destreza_persona);
					}
	}}});
	gsCgg_gem_destreza_persona.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:"JSON"
		}
	});	
	var pnlListadoCgg_gem_destreza_persona = new Ext.form.FormPanel({
		id:'pnlListadoCgg_gem_destreza_persona',
		items:[grdCgg_gem_destreza_persona],		
		region:'center',
		layout: 'border',
		bbar:[btnNuevoCgg_gem_destreza_persona, 
			btnEditarCgg_gem_destreza_persona, 
			btnEliminarCgg_gem_destreza_persona, 
			'->', 
			btnSalirCgg_gem_destreza_persona
		]
	});

	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gem_destreza_persona.
	*/
	if(inDesktop){
		var winFrmListadoCgg_gem_destreza_persona = inDesktop.createWindow({			
				id: 'winFrmListadoCgg_gem_destreza_persona',
				title: tituloListadoCgg_gem_destreza_persona,
				iconCls: 'iconAplicacion',
				width: 600,
				minWidth: 600,
				height: 400,
				minHeight: 400,
				maximizable: true,
				minimizable: true,
				constrainHeader: true,
				layout: 'border',
				tbar: getPanelTitulo('Listado ' + tituloListadoCgg_gem_destreza_persona, descListadoCgg_gem_destreza_persona),
				items: [pnlListadoCgg_gem_destreza_persona]
		});
	}else{
		var winFrmListadoCgg_gem_destreza_persona = new Ext.Window({
				id: 'winFrmListadoCgg_gem_destreza_persona',
				title: tituloListadoCgg_gem_destreza_persona,
				iconCls: 'iconAplicacion',
				width: 600,				
				height: 400,
				minWidth: 600,
				minHeight: 400,
				maximizable: true,
				minimizable: true,
				constrainHeader: true,
				layout: 'border',
				tbar: getPanelTitulo('Listado ' + tituloListadoCgg_gem_destreza_persona, descListadoCgg_gem_destreza_persona),
				items: [pnlListadoCgg_gem_destreza_persona]
		});
	}
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
//	applyGrants(pnlListadoCgg_gem_destreza_persona.getBottomToolbar());
	
	/*grdCgg_gem_destreza_persona.getSelectionModel().on("selectionchange",function(sm_cgdst){
		var sm_cgdst=sm_cgdst.hasSelection();
		//alert(sm_cgdst);
		btnEditarCgg_gem_destreza_persona.setDisabled(!sm_cgdst);
		btnEliminarCgg_gem_destreza_persona.setDisabled(!sm_cgdst)		
	});*/
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_destreza_persona.
	* @returns ventana winFrmCgg_gem_destreza_persona.
	* @base FrmListadoCgg_gem_destreza_persona.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_gem_destreza_persona;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gem_destreza_persona.
	* @base FrmListadoCgg_gem_destreza_persona.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_gem_destreza_persona.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_gem_destreza_persona;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_gem_destreza_persona;
	}
	/**
	* Funcion miembro que develve el panel del listado sobre las destrezas de la persona.
	*/
	this.getPanel = function(){
		return pnlListadoCgg_gem_destreza_persona;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_gem_destreza_persona.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_gem_destreza_persona.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_destreza_persona desde una instancia.
*/
FrmListadoCgg_gem_destreza_persona.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_destreza_persona desde una instancia.
*/
FrmListadoCgg_gem_destreza_persona.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_destreza_persona,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_gem_destreza_persona.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gem_destreza_persona desde una instancia.
*/
FrmListadoCgg_gem_destreza_persona.prototype.loadData = function(){
	this.loadData();
}
/**
* Funcion prototipo. Permite obtener el panel del listado sobre las destrezas de la persona
*/
FrmListadoCgg_gem_destreza_persona.prototype.getPanel = function(){
	this.getPanel();
}