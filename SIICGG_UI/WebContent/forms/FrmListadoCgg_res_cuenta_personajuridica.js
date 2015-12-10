/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_cuenta_personajuridica.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_res_cuenta_personajuridica(){
	var urlListadoCgg_res_cuenta_personajuridica=URL_WS+"Cgg_res_cuenta_personajuridica";
	var tituloListadoCgg_res_cuenta_personajuridica='Res cuenta personajuridica';
	var descListadoCgg_res_cuenta_personajuridica='El formulario permite administrar informaci\u00f3n de la tabla Res cuenta personajuridica';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_cuenta_personajuridica.
	*/
	var btnNuevoCgg_res_cuenta_personajuridica = new Ext.Button({
			id:'btnNuevoCgg_res_cuenta_personajuridica',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_res_cuenta_personajuridica = new FrmCgg_res_cuenta_personajuridica("insert");
					objCgg_res_cuenta_personajuridica.closeHandler(function(){
							gsCgg_res_cuenta_personajuridica.reload();
					});
					objCgg_res_cuenta_personajuridica.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_cuenta_personajuridica.
	*/
	var btnEditarCgg_res_cuenta_personajuridica = new Ext.Button({
			id:'btnEditarCgg_res_cuenta_personajuridica',
			text:'Editar',
			iconCls:'iconEditar',
			listeners:{
				click:function(){
					var r=grdCgg_res_cuenta_personajuridica.getSelectionModel().getSelected();
					if(r){
						var objCgg_res_cuenta_personajuridica = new FrmCgg_res_cuenta_personajuridica("update",r);
						objCgg_res_cuenta_personajuridica.closeHandler(function(){
								gsCgg_res_cuenta_personajuridica.reload();
						});
						objCgg_res_cuenta_personajuridica.loadData();
						objCgg_res_cuenta_personajuridica.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_cuenta_personajuridica.
	*/
	var btnEliminarCgg_res_cuenta_personajuridica = new Ext.Button({
			id:'btnEliminarCgg_res_cuenta_personajuridica',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_cuenta_personajuridica,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_res_cuenta_personajuridica(btn){if (btn=='yes'){
						try{
							function CallBackCgg_res_cuenta_personajuridica(r){
								winFrmListadoCgg_res_cuenta_personajuridica.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_res_cuenta_personajuridica,
											msg: 'La informaci\u00f3n de Res cuenta personajuridica ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_res_cuenta_personajuridica.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_res_cuenta_personajuridica,
											msg: 'La informaci\u00f3n de Res cuenta personajuridica no ha podido ser eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							winFrmListadoCgg_res_cuenta_personajuridica.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCrcpj_codigo',grdCgg_res_cuenta_personajuridica.getSelectionModel().getSelected().get('CRCPJ_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_res_cuenta_personajuridica,"delete",param, true, CallBackCgg_res_cuenta_personajuridica);
						}catch(inErr){
							winFrmListadoCgg_res_cuenta_personajuridica.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_cuenta_personajuridica.
	*/
	var btnSalirCgg_res_cuenta_personajuridica = new Ext.Button({
			id:'btnSalirCgg_res_cuenta_personajuridica',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_res_cuenta_personajuridica.close();
			}}
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_cuenta_personajuridica.
	*/
	var cmCgg_res_cuenta_personajuridica = new Ext.grid.ColumnModel([
		{dataIndex:'CRPJR_RAZON_SOCIAL',header:'Entidad',width:200,sortable:true},
			{dataIndex:'CRCPJ_NUMERO_CUENTA',header:'Numero',width:100,sortable:true},
			{dataIndex:'CRCPJ_DESCRIPCION',header:'Descripci\u00F3n',width:150,sortable:true},
		{dataIndex:'CRCPJ_TIPO_CUENTA',header:'Tipo de cuenta',width:150,sortable:true,renderer:function(inData){
			return dsTipoCuentaBancaria[inData][1];
	}}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_res_cuenta_personajuridica por un campo especifico.
	*/
	var gsCgg_res_cuenta_personajuridica = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_res_cuenta_personajuridica",
					method:"selectPageDirect",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CRCPJ_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CRCPJ_CODIGO'},
				{name:'CGG_CRPJR_CODIGO'},
				{name:'CRPJR_CODIGO'},
				{name:'CRPER_CODIGO'},
				{name:'CRPJR_RAZON_SOCIAL'},
				{name:'CRCPJ_NUMERO_CUENTA'},
				{name:'CRCPJ_DESCRIPCION'},
				{name:'CRCPJ_TIPO_CUENTA'}
			]),
			sortInfo:{field: 'CGG_CRPJR_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON',inCrpjr_codigo:''}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_cuenta_personajuridica.
	*/
	var pgBarCgg_res_cuenta_personajuridica= new Ext.PagingToolbar({
			store: gsCgg_res_cuenta_personajuridica,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_cuenta_personajuridica en un formato tabular de filas y columnas.
	*/
	var grdCgg_res_cuenta_personajuridica = new Ext.grid.GridPanel({
			cm:cmCgg_res_cuenta_personajuridica,
			store:gsCgg_res_cuenta_personajuridica,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_res_cuenta_personajuridica,
						width:200
				})
			],
			bbar:pgBarCgg_res_cuenta_personajuridica,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_res_cuenta_personajuridica.hidden){
						btnEditarCgg_res_cuenta_personajuridica.fireEvent('click', btnEditarCgg_res_cuenta_personajuridica);
					}
	}}});
	gsCgg_res_cuenta_personajuridica.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:'JSON'
		}
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_cuenta_personajuridica.
	*/
	var winFrmListadoCgg_res_cuenta_personajuridica = new Ext.Window({
			id:'winFrmListadoCgg_res_cuenta_personajuridica',
			title:tituloListadoCgg_res_cuenta_personajuridica,
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			layout:'border',
			tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_cuenta_personajuridica,descListadoCgg_res_cuenta_personajuridica),
			items:[grdCgg_res_cuenta_personajuridica],
			bbar:[btnNuevoCgg_res_cuenta_personajuridica,btnEditarCgg_res_cuenta_personajuridica,btnEliminarCgg_res_cuenta_personajuridica,'->',btnSalirCgg_res_cuenta_personajuridica]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_res_cuenta_personajuridica.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_res_cuenta_personajuridica.
	* @returns ventana winFrmCgg_res_cuenta_personajuridica.
	* @base FrmListadoCgg_res_cuenta_personajuridica.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_res_cuenta_personajuridica;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_cuenta_personajuridica.
	* @base FrmListadoCgg_res_cuenta_personajuridica.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_res_cuenta_personajuridica.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_res_cuenta_personajuridica;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_res_cuenta_personajuridica;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_res_cuenta_personajuridica.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_res_cuenta_personajuridica.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_cuenta_personajuridica desde una instancia.
*/
FrmListadoCgg_res_cuenta_personajuridica.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_cuenta_personajuridica desde una instancia.
*/
FrmListadoCgg_res_cuenta_personajuridica.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_cuenta_personajuridica,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_res_cuenta_personajuridica.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_cuenta_personajuridica desde una instancia.
*/
FrmListadoCgg_res_cuenta_personajuridica.prototype.loadData = function(){
	this.loadData();
}
