/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_buzon_correo.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_buzon_correo(inDesktop){
	var optMenu = 'Configuraci\u00f3n/Servicio de notificaciones';
	var urlListadoCgg_buzon_correo=URL_WS+"Cgg_buzon_correo";
	var tituloListadoCgg_buzon_correo='Buzon correo';
	var descListadoCgg_buzon_correo='El formulario permite visualizar el estado de las notificaciones a e-mails del sistema.';
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_buzon_correo.
	*/
	var btnEliminarCgg_buzon_correo = new Ext.Button({
			id:'btnEliminarCgg_buzon_correo',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_buzon_correo,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_buzon_correo(btn){if (btn=='yes'){
						try{
							function CallBackCgg_buzon_correo(r){
								winFrmListadoCgg_buzon_correo.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_buzon_correo,
											msg: 'La informaci\u00f3n de Buzon correo ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_buzon_correo.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_buzon_correo,
											msg: 'La informaci\u00f3n de Buzon correo no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_buzon_correo.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCbzc_codigo',grdCgg_buzon_correo.getSelectionModel().getSelected().get('CBZC_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_buzon_correo,"delete",param, true, CallBackCgg_buzon_correo);
						}catch(inErr){
							winFrmListadoCgg_buzon_correo.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_buzon_correo.
	*/
	var btnSalirCgg_buzon_correo = new Ext.Button({
			id:'btnSalirCgg_buzon_correo',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_buzon_correo.close();
			}}
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_buzon_correo.
	*/
	var chkCbzc_enviado = new Ext.grid.CheckColumn(
		{dataIndex:'CBZC_ENVIADO',header:'Enviado',width:150,sortable:true});
	var cmCgg_buzon_correo = new Ext.grid.ColumnModel([
			{dataIndex:'CBZC_DESTINATARIO',header:'Destinatario',width:150,sortable:true},
			{dataIndex:'CBZC_ASUNTO',header:'Asunto',width:150,sortable:true},
			{dataIndex:'CBZC_TIPO_CONTENIDO',header:'Tipo contenido',width:150,sortable:true},
			{dataIndex:'CBZC_NUMERO_INTENTOS',header:'Numero de intentos',width:150,sortable:true},
	chkCbzc_enviado]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_buzon_correo por un campo especifico.
	*/
	var gsCgg_buzon_correo = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_buzon_correo",
					method:"selectPage",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CBZC_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CBZC_CODIGO'},
				{name:'CBZC_DESTINATARIO'},
				{name:'CBZC_ASUNTO'},
				{name:'CBZC_MENSAJE'},
				{name:'CBZC_TIPO_CONTENIDO'},
				{name:'CBZC_NUMERO_INTENTOS'},
				{name:'CBZC_ENVIADO'}
			]),
			sortInfo:{field: 'CBZC_DESTINATARIO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON'}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_buzon_correo.
	*/
	var pgBarCgg_buzon_correo= new Ext.PagingToolbar({
			store: gsCgg_buzon_correo,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_buzon_correo en un formato tabular de filas y columnas.
	*/
	var grdCgg_buzon_correo = new Ext.grid.GridPanel({
			cm:cmCgg_buzon_correo,
			store:gsCgg_buzon_correo,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_buzon_correo,
						width:200
				})
			],
			bbar:pgBarCgg_buzon_correo,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_buzon_correo.hidden){
						btnEditarCgg_buzon_correo.fireEvent('click', btnEditarCgg_buzon_correo);
					}
	}}});
	gsCgg_buzon_correo.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_buzon_correo.
	*/
	var winFrmListadoCgg_buzon_correo = inDesktop.createWindow({
			id:'winFrmListadoCgg_buzon_correo',
			title:tituloListadoCgg_buzon_correo,
			iconCls:'iconAplicacion',
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			layout:'border',
			tbar:getPanelTitulo(tituloListadoCgg_buzon_correo,descListadoCgg_buzon_correo),
			items:[grdCgg_buzon_correo],
			bbar:[btnEliminarCgg_buzon_correo,'->',btnSalirCgg_buzon_correo]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_buzon_correo.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_buzon_correo.
	* @returns ventana winFrmCgg_buzon_correo.
	* @base FrmListadoCgg_buzon_correo.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_buzon_correo;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_buzon_correo.
	* @base FrmListadoCgg_buzon_correo.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_buzon_correo.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_buzon_correo;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_buzon_correo;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_buzon_correo.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_buzon_correo.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_buzon_correo desde una instancia.
*/
FrmListadoCgg_buzon_correo.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_buzon_correo desde una instancia.
*/
FrmListadoCgg_buzon_correo.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_buzon_correo,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_buzon_correo.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_buzon_correo desde una instancia.
*/
FrmListadoCgg_buzon_correo.prototype.loadData = function(){
	this.loadData();
}
