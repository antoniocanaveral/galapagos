/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_web_pagina.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_web_pagina(inDesktop){
	var optMenu = 'Configuraci\u00F3n/Sitio Web/Administraci\u00F3n de p\u00E1ginas';
	var urlListadoCgg_web_pagina=URL_WS+"Cgg_web_pagina";
	var tituloListadoCgg_web_pagina='Sitio Web';
	var descListadoCgg_web_pagina='El formulario permite administrar informaci\u00f3n de sobre el contenido del sitio web';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_web_pagina.
	*/
	var btnNuevoCgg_web_pagina = new Ext.Button({
			id:'btnNuevoCgg_web_pagina',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_web_pagina = new FrmCgg_web_pagina("insert");
					objCgg_web_pagina.closeHandler(function(){
							gsCgg_web_pagina.reload();
					});
					objCgg_web_pagina.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_web_pagina.
	*/
	var btnEditarCgg_web_pagina = new Ext.Button({
			id:'btnEditarCgg_web_pagina',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_web_pagina.getSelectionModel().getSelected();
					if(r){
						var objCgg_web_pagina = new FrmCgg_web_pagina("update",r);
						objCgg_web_pagina.closeHandler(function(){
								gsCgg_web_pagina.reload();
						});
						objCgg_web_pagina.loadData();
						objCgg_web_pagina.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_web_pagina.
	*/
	var btnEliminarCgg_web_pagina = new Ext.Button({
			id:'btnEliminarCgg_web_pagina',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_web_pagina,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_web_pagina(btn){if (btn=='yes'){
						try{
							function CallBackCgg_web_pagina(r){
								winFrmListadoCgg_web_pagina.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_web_pagina,
											msg: 'La informaci\u00f3n de Web pagina ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_web_pagina.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_web_pagina,
											msg: 'La informaci\u00f3n de Web pagina no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_web_pagina.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCwpag_codigo',grdCgg_web_pagina.getSelectionModel().getSelected().get('CWPAG_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_web_pagina,"delete",param, true, CallBackCgg_web_pagina);
						}catch(inErr){
							winFrmListadoCgg_web_pagina.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_web_pagina.
	*/
	var btnSalirCgg_web_pagina = new Ext.Button({
			id:'btnSalirCgg_web_pagina',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_web_pagina.close();
			}}
	});
	
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_web_pagina.
	*/
	var cmCgg_web_pagina = new Ext.grid.ColumnModel([			
			{dataIndex:'CWPAG_NOMBRE',header:'Nombre',width:150,sortable:true},
			{dataIndex:'CWPAG_TITULO',header:'T\u00EDtulo',width:150,sortable:true}			
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_web_pagina por un campo especifico.
	*/
	var gsCgg_web_pagina = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:urlListadoCgg_web_pagina,
					method:"selectPage",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CWPAG_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CWPAG_CODIGO'},
				{name:'CWPAG_NOMBRE'},
				{name:'CWPAG_TITULO'},
				{name:'CWPAG_DESCRIPCION'},
				{name:'CWPAG_CONFIGURACION'}
			]),
			sortInfo:{field: 'CWPAG_NOMBRE', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_web_pagina.
	*/
	var pgBarCgg_web_pagina= new Ext.PagingToolbar({
			store: gsCgg_web_pagina,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_web_pagina en un formato tabular de filas y columnas.
	*/
	var grdCgg_web_pagina = new Ext.grid.GridPanel({
			cm:cmCgg_web_pagina,
			store:gsCgg_web_pagina,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_web_pagina,
						width:200
				})
			],
			bbar:pgBarCgg_web_pagina,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_web_pagina.hidden){
						btnEditarCgg_web_pagina.fireEvent('click', btnEditarCgg_web_pagina);
					}
				}
			}
	});
	gsCgg_web_pagina.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_web_pagina.
	*/
	if(inDesktop){
		var winFrmListadoCgg_web_pagina = inDesktop.createWindow({
				id:'winFrmListadoCgg_web_pagina',
				title:tituloListadoCgg_web_pagina,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_web_pagina,descListadoCgg_web_pagina),
				items:[grdCgg_web_pagina],
				bbar:[btnNuevoCgg_web_pagina,btnEditarCgg_web_pagina,btnEliminarCgg_web_pagina,'->',btnSalirCgg_web_pagina]
		});
	}else{
		var winFrmListadoCgg_web_pagina = new Ext.Window({
				id:'winFrmListadoCgg_web_pagina',
				title:tituloListadoCgg_web_pagina,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_web_pagina,descListadoCgg_web_pagina),
				items:[grdCgg_web_pagina],
				bbar:[btnNuevoCgg_web_pagina,btnEditarCgg_web_pagina,btnEliminarCgg_web_pagina,'->',btnSalirCgg_web_pagina]
		});
	}
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_web_pagina.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_web_pagina.
	* @returns ventana winFrmCgg_web_pagina.
	* @base FrmListadoCgg_web_pagina.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_web_pagina;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_web_pagina.
	* @base FrmListadoCgg_web_pagina.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_web_pagina.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_web_pagina;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_web_pagina;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_web_pagina.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_web_pagina.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_web_pagina desde una instancia.
*/
FrmListadoCgg_web_pagina.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_web_pagina desde una instancia.
*/
FrmListadoCgg_web_pagina.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_web_pagina,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_web_pagina.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_web_pagina desde una instancia.
*/
FrmListadoCgg_web_pagina.prototype.loadData = function(){
	this.loadData();
}
