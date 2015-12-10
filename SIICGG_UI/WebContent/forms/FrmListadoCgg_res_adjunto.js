/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_adjunto.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_res_adjunto(inDesktop){
	var optMenu = 'Control de Residencia/Informaci\u00f3n Documental';
	var urlListadoCgg_res_adjunto=URL_WS+"Cgg_res_adjunto";
	var tituloListadoCgg_res_adjunto='Listado de documentaci\u00f3n digitalizada';
	var descListadoCgg_res_adjunto='El formulario permite administrar informaci\u00f3n de la tabla Res adjunto';
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_adjunto.
	*/
	var btnNuevoCgg_res_adjunto = new Ext.Button({
			id:'btnNuevoCgg_res_adjunto',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_res_adjunto = new FrmCgg_res_adjuntoOrg("insert");
					objCgg_res_adjunto.closeHandler(function(){
							gsCgg_res_adjunto.reload();
					});
					objCgg_res_adjunto.show();
				}
			}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_adjunto.
	*/
	var btnEliminarCgg_res_adjunto = new Ext.Button({
			id:'btnEliminarCgg_res_adjunto',
			text:'Eliminar',
			iconCls:'iconEliminar',
			listeners:{
				click:function(){
					Ext.Msg.show({
							title:'Aviso',
							msg:'Est\u00e1 seguro de eliminar?',
							buttons: Ext.Msg.YESNO,
							fn: SWRCgg_res_adjunto,
							icon: Ext.MessageBox.QUESTION
					});
					function SWRCgg_res_adjunto(btn){
						if (btn=='yes'){
							try{
								function CallBackCgg_res_adjunto(r){
									winFrmListadoCgg_res_adjunto.getEl().unmask();
									if(r=='true'){
										Ext.Msg.show({
												title:tituloListadoCgg_res_adjunto,
												msg: 'La informaci\u00f3n de Res adjunto ha sido eliminada.',
												buttons: Ext.Msg.OK,
												icon: Ext.MessageBox.INFO
										});
										gsCgg_res_adjunto.reload();
									}else{
										Ext.Msg.show({
												title:tituloListadoCgg_res_adjunto,
												msg: 'La informaci\u00f3n de Cgg_res_adjunto no ha podido ser eliminada.',
												buttons: Ext.Msg.OK,
												icon: Ext.MessageBox.ERROR
										});
									}
								}
								winFrmListadoCgg_res_adjunto.getEl().mask('Eliminando...', 'x-mask-loading');
								var param = new SOAPClientParameters();
								param.add('inCradj_codigo',grdCgg_res_adjunto.getSelectionModel().getSelected().get('CRADJ_CODIGO'));
								SOAPClient.invoke(urlListadoCgg_res_adjunto,"delete",param, true, CallBackCgg_res_adjunto);
							}catch(inErr){
								winFrmListadoCgg_res_adjunto.getEl().unmask();
							}
						}
					}
				}
			}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_adjunto.
	*/
	var btnSalirCgg_res_adjunto = new Ext.Button({
			id:'btnSalirCgg_res_adjunto',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_res_adjunto.close();
				}
			}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_adjunto.
	*/
	var btnVerCgg_res_adjunto = new Ext.Button({
			id:'btnVerCgg_res_adjunto',
			text:'Ver',
			iconCls:'iconVer',
			listeners:{
				click:function(){
					var r=grdCgg_res_adjunto.getSelectionModel().getSelected();
					if(r)
						window.open(URL_DOC_VIEWER+'?table=cgg_res_adjunto&keyc=cradj_codigo&keyv='+r.get('CRADJ_CODIGO')+'&column=cradj_archivo_adjunto&fn='+r.get('CRADJ_NOMBRE_ADJUNTO')+'&request=view');
				}
			}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_adjunto.
	*/
	var btnDescargarCgg_res_adjunto = new Ext.Button({
			id:'btnDescargarCgg_res_adjunto',
			text:'Descargar',
			iconCls:'iconDescargar',
			listeners:{
				click:function(){
					var r=grdCgg_res_adjunto.getSelectionModel().getSelected();
					if(r)
						window.open(URL_DOC_VIEWER+'?table=cgg_res_adjunto&keyc=cradj_codigo&keyv='+r.get('CRADJ_CODIGO')+'&column=cradj_archivo_adjunto&fn='+r.get('CRADJ_NOMBRE_ADJUNTO')+'&request=download');
				}
			}
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_adjunto.
	*/
	var cmCgg_res_adjunto = new Ext.grid.ColumnModel([
			{dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'Doc. Identific.',width:100,sortable:false},
			{dataIndex:'CRTRA_NUMERO',header:'No. Tramite',width:100,sortable:false},
			{dataIndex:'CRADJ_NOMBRE_ADJUNTO',header:'Nombre adjunto',width:150,sortable:true},
			{dataIndex:'PERSONA',header:'Persona',width:200,sortable:false},
			{dataIndex:'CRADJ_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true},
			{dataIndex:'CRADJ_FECHA_REGISTRO',header:'Registro',width:150,sortable:true}
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_res_adjunto por un campo especifico.
	*/
	var gsCgg_res_adjunto = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_res_adjunto",
					method:"selectPageDirect",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CRADJ_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CRADJ_CODIGO'},
				{name:'CRPER_CODIGO'},
				{name:'CRPER_NUM_DOC_IDENTIFIC'},
				{name:'CRTRA_NUMERO'},
				{name:'PERSONA'},
				{name:'CRINF_CODIGO'},
				{name:'CRNOT_CODIGO'},
				{name:'CRRES_CODIGO'},
				{name:'CRDPT_CODIGO'},
				{name:'CRSEG_CODIGO'},
				{name:'CRTPT_CODIGO'},
				{name:'TRAMITE'},
				{name:'CRADJ_CONTENIDO'},
				{name:'CRADJ_NOMBRE_ADJUNTO'},
				{name:'CRADJ_OBSERVACION'},
				{name:'CRADJ_FECHA_REGISTRO'}
			]),
			sortInfo:{
				field: 'CRADJ_FECHA_REGISTRO',
				direction: 'desc'
			},
			baseParams:{
				keyword:"",
				format:"JSON"
			}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_adjunto.
	*/
	var pgBarCgg_res_adjunto= new Ext.PagingToolbar({
			store: gsCgg_res_adjunto,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_adjunto en un formato tabular de filas y columnas.
	*/
	var grdCgg_res_adjunto = new Ext.grid.GridPanel({
			cm:cmCgg_res_adjunto,
			store:gsCgg_res_adjunto,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({
					singleSelect:true
			}),
			loadMask:{
				msg:"Cargando..."
			},
			tbar: [
				'Buscar: ', ' ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_res_adjunto,
						width:200
				})
			],
			bbar:pgBarCgg_res_adjunto
	});
	gsCgg_res_adjunto.reload({
			params:{
				start:0,
				limit:RECORD_PAGE,
				format:"JSON"
			}
	});
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_adjunto.
	*/
	var winFrmListadoCgg_res_adjunto = inDesktop.createWindow({
			id:'winFrmListadoCgg_res_adjunto',
			title:tituloListadoCgg_res_adjunto,
			tbar:getPanelTitulo(tituloListadoCgg_res_adjunto,descListadoCgg_res_adjunto),
			items:[grdCgg_res_adjunto],
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			layout:'border',
			bbar:[btnNuevoCgg_res_adjunto,btnEliminarCgg_res_adjunto,'-',btnVerCgg_res_adjunto,btnDescargarCgg_res_adjunto,'->',btnSalirCgg_res_adjunto]
	});
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(winFrmListadoCgg_res_adjunto.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_res_adjunto.
	* @returns ventana winFrmCgg_res_adjunto.
	* @base FrmListadoCgg_res_adjunto.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_res_adjunto;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_adjunto.
	* @base FrmListadoCgg_res_adjunto.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_res_adjunto.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_res_adjunto;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_res_adjunto;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_res_adjunto.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_res_adjunto.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_adjunto desde una instancia.
*/
FrmListadoCgg_res_adjunto.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_adjunto desde una instancia.
*/
FrmListadoCgg_res_adjunto.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_adjunto,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_res_adjunto.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_adjunto desde una instancia.
*/
FrmListadoCgg_res_adjunto.prototype.loadData = function(){
	this.loadData();
}
