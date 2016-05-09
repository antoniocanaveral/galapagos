/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_sec_objeto.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_sec_objeto_rol(inDesktop){
	var optMenu = 'Seguridad/Privilegios';
	var urlListadoCgg_sec_objeto_rol=URL_WS+"Cgg_sec_objeto_rol";
	var tituloListadoCgg_sec_objeto_rol='Privilegios';
	var descListadoCgg_sec_objeto_rol='El formulario permite la asignacion de privilegios a los roles sobre los objetos del sistema.';
	var tmpRol;
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_sec_objeto_rol.
	*/
	var btnNuevoCgg_sec_objeto_rol = new Ext.Button({
			id:'btnNuevoCgg_sec_objeto_rol',
			text:'Agregar',
			iconCls:'iconNuevo',
			disabled:true,
			listeners:{
				click:function(){
					var objCgg_sec_objeto_rol = new FrmCgg_sec_objeto_rol("insert");
					objCgg_sec_objeto_rol.setRol(tmpRol);
					if(tbTiposObjetos_rol.getActiveTab() == grdCgg_sec_objeto_rol )
						objCgg_sec_objeto_rol.setTypeObject(0);
					else
						objCgg_sec_objeto_rol.setTypeObject(1);
					objCgg_sec_objeto_rol.closeHandler(function(){
							gsCgg_sec_objeto_rol.reload();
							gsWSObjetos_rol.reload();
					});
					objCgg_sec_objeto_rol.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_sec_objeto_rol.
	*/
	var btnEditarCgg_sec_objeto_rol = new Ext.Button({
			id:'btnEditarCgg_sec_objeto_rol',
			text:'Editar',
			iconCls:'iconEditar',
			disabled:true,
			listeners:{
				click:function(){
				var r;				
				if(tbTiposObjetos_rol.getActiveTab() == grdCgg_sec_objeto_rol)
					r=grdCgg_sec_objeto_rol.getSelectionModel().getSelected();
				else
					r=grdWSObjetos_rol.getSelectionModel().getSelected();
				if(r){
					var objCgg_sec_objeto_rol = new FrmCgg_sec_objeto_rol("update",r);
					if(tbTiposObjetos_rol.getActiveTab() == grdCgg_sec_objeto_rol )
						objCgg_sec_objeto_rol.setTypeObject(0);
					else
						objCgg_sec_objeto_rol.setTypeObject(1);
					objCgg_sec_objeto_rol.closeHandler(function(){
							gsCgg_sec_objeto_rol.reload();
							gsWSObjetos_rol.reload();
					});
					objCgg_sec_objeto_rol.loadData();
					objCgg_sec_objeto_rol.show();
				}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_sec_objeto_rol.
	*/
	var btnEliminarCgg_sec_objeto_rol = new Ext.Button({
			id:'btnEliminarCgg_sec_objeto_rol',
			text:'Eliminar',
			iconCls:'iconEliminar',
			disabled:true,
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_sec_objeto_rol,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_sec_objeto_rol(btn){if (btn=='yes'){
						try{
							function CallBackCgg_sec_objeto_rol(r){
								winFrmListadoCgg_sec_objeto_rol.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_sec_objeto_rol,
											msg: 'La informaci\u00f3n de Sec objeto rol ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsWSObjetos_rol.reload();
									gsCgg_sec_objeto_rol.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_sec_objeto_rol,
											msg: 'La informaci\u00f3n de Sec objeto rol no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							var tmpCodigo;
							if(tbTiposObjetos_rol.getActiveTab() == grdWSObjetos_rol)
								tmpCodigo = grdWSObjetos_rol.getSelectionModel().getSelected().get('CSBJR_CODIGO');
							else
								tmpCodigo = grdCgg_sec_objeto_rol.getSelectionModel().getSelected().get('CSBJR_CODIGO');
							winFrmListadoCgg_sec_objeto_rol.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCsbjr_codigo',tmpCodigo);
							SOAPClient.invoke(urlListadoCgg_sec_objeto_rol,"delete",param, true, CallBackCgg_sec_objeto_rol);
						}catch(inErr){
							winFrmListadoCgg_sec_objeto_rol.getEl().unmask();
					}}}
			}}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_sec_objeto_rol.
	*/
	var btnSalirCgg_sec_objeto_rol = new Ext.Button({
			id:'btnSalirCgg_sec_objeto_rol',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_sec_objeto_rol.close();
			}}
	});
	/**
     * Ext.form.TextField IDENTIFICATIVO UNICO DE REGISTRO ROL
     */
    var txtCsrol_codigo = new Ext.form.TextField({
        id: 'txtCsrol_codigo',
        name: 'txtCsrol_codigo',
        fieldLabel: 'Rol',
        anchor: '98%',
		width:200,
		emptyText:'Seleccione un Rol ...',
        allowBlank: false,
        readOnly: 'true'
    });
    /**
     * IDENTIFICATIVO UNICO DE REGISTRO ROL
     */
	 var tmpRecord;
    var btnCsrol_codigoCgg_sec_objeto = new Ext.Button({
        id: 'btnCsrol_codigoCgg_sec_objeto',
        iconCls: 'iconBuscar',
        listeners: {
            click: function () {
                var tmpFLCgg_sec_rol = new FrmListadoCgg_sec_rol();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_sec_rol.getStore(), tmpFLCgg_sec_rol.getColumnModel());
                objBusqueda.closeHandler(function () {
                    tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord){
						tmpRol = tmpRecord.get('CSROL_CODIGO');
						txtCsrol_codigo.setValue(tmpRecord.get('CSROL_NOMBRE'));
						
						gsCgg_sec_objeto_rol.baseParams.start = 0;
						gsCgg_sec_objeto_rol.baseParams.limit = RECORD_PAGE;
						gsCgg_sec_objeto_rol.baseParams.inTypeObject = 0;
						gsCgg_sec_objeto_rol.baseParams.inCsrol_codigo = tmpRol;
						gsCgg_sec_objeto_rol.reload();
						
						gsWSObjetos_rol.baseParams.start = 0;
						gsWSObjetos_rol.baseParams.limit = RECORD_PAGE;
						gsWSObjetos_rol.baseParams.inTypeObject = 1;
						gsWSObjetos_rol.baseParams.inCsrol_codigo = tmpRol;
						gsWSObjetos_rol.reload();
						
						gsCgg_sec_reporte.baseParams.start = 0;
						gsCgg_sec_reporte.baseParams.limit = RECORD_PAGE;
						gsCgg_sec_reporte.baseParams.inCsrol_codigo = tmpRol;
						gsCgg_sec_reporte.reload();
						
						btnNuevoCgg_sec_objeto_rol.setDisabled(false);
					}
                });
                objBusqueda.show();
            }
        }
    });
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sec_objeto.
	*/
	var chkCsbjr_acceso_directo = new Ext.grid.CheckColumn(
		{dataIndex:'CSBJR_ACCESO_DIRECTO',header:'Acceso directo',width:100,sortable:true});
	var cmCgg_sec_objeto_rol = new Ext.grid.ColumnModel([
		{dataIndex:'CSOBJ_NOMBRE',header:'Nombre',width:200,sortable:true},
		{dataIndex:'CSOBJ_RUTA',header:'Ruta',width:150,sortable:true,hidden:true},
		{dataIndex:'CSOBJ_DESCRIPCION',header:'Descripci\u00f3n',width:320,sortable:true},
		chkCsbjr_acceso_directo,
		{dataIndex:'CSBJR_ACCESO_DIRECTO_TEXTO',header:'Acceso directo',width:100,sortable:true}
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_sec_objeto por un campo especifico.
	*/
	var gsCgg_sec_objeto_rol = new Ext.data.GroupingStore({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_sec_objeto_rol",
					method:"selectPageDirect",
					pagin:true
			}),
			remoteSort:true,
			groupField:'CSOBJ_RUTA',
			reader:new Ext.data.JsonReader({
					id:'CSBJR_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CSBJR_CODIGO'},
				{name:'CSOBJ_CODIGO'},
				{name:'CSROL_CODIGO'},
				{name:'CSOBJ_NOMBRE'},
				{name:'CSOBJ_RUTA'},
				{name:'CSOBJ_DESCRIPCION'},
				{name:'CSBJR_ACCESO_DIRECTO'},
				{name:'CSBJR_ACCESO_DIRECTO_TEXTO'}
			]),
				sortInfo:{field: 'CSOBJ_RUTA', direction: 'ASC'},
				baseParams:{keyword:"",format:'JSON',inTypeObject:'0',inCsrol_codigo:''}
	});
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sec_objeto.
	*/
	var cmWSObjetos_rol = new Ext.grid.ColumnModel([
	{dataIndex:'CSOBJ_NOMBRE',header:'Nombre',width:200,sortable:true},
	{dataIndex:'CSOBJ_RUTA',header:'Ruta',width:150,sortable:true,hidden:true},
	{dataIndex:'CSOBJ_DESCRIPCION',header:'Descripci\u00f3n',width:350,sortable:true}]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_sec_objeto por un campo especifico.
	*/
	var gsWSObjetos_rol = new Ext.data.GroupingStore({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_sec_objeto_rol",
			method:"selectPageDirect",
			pagin:true
		}),
		remoteSort:true,
		groupField:'CSOBJ_RUTA',
		reader:new Ext.data.JsonReader({
			id:'CSBJR_CODIGO',
			root:'dataSet',
			totalProperty: 'totalCount'
		},[
		{name:'CSBJR_CODIGO'},
		{name:'CSROL_CODIGO'},
		{name:'CSOBJ_CODIGO'},
		{name:'CSOBJ_NOMBRE'},
		{name:'CSOBJ_RUTA'},
		{name:'CSOBJ_DESCRIPCION'}
		]),
		sortInfo:{field: 'CSOBJ_RUTA', direction: 'ASC'},
		baseParams:{keyword:"",format:'JSON',inTypeObject:'1',inCsrol_codigo:''}
	});
	
	
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_sec_objeto.
	*/
	var pgBarCgg_sec_objeto_rol= new Ext.PagingToolbar({
			store: gsCgg_sec_objeto_rol,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_sec_objeto.
	*/
	var pgBarWSObjetos_rol= new Ext.PagingToolbar({
		store: gsWSObjetos_rol,
		displayInfo: true,
		pageSize:RECORD_PAGE,
		displayMsg: 'Mostrando {0} - {1} de {2}',
		temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sec_objeto en un formato tabular de filas y columnas.
	*/
	var grdCgg_sec_objeto_rol = new Ext.grid.GridPanel({
		title:'Interface visual',
			cm:cmCgg_sec_objeto_rol,
			store:gsCgg_sec_objeto_rol,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_sec_objeto_rol,
						width:200
				})
			],
			view: new Ext.grid.GroupingView({
				groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
			}),
			bbar:pgBarCgg_sec_objeto_rol,
			listeners:{
				dblclick :function(inSource){
					if(!btnEditarCgg_sec_objeto_rol.disabled){
						btnEditarCgg_sec_objeto_rol.fireEvent('click', btnEditarCgg_sec_objeto_rol);
					}
				}
			}
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sec_objeto en un formato tabular de filas y columnas.
	*/
	var grdWSObjetos_rol = new Ext.grid.GridPanel({
		title:'Servicios web',
		cm:cmWSObjetos_rol,
		store:gsWSObjetos_rol,
		region:'center',
		sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
		loadMask:{msg:"Cargando..."},
		tbar: [
				'Buscar: ',
		new Ext.ux.bsx.SearchField({
			store:gsWSObjetos_rol,
			width:200
		})
				],
				view: new Ext.grid.GroupingView({
					groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
				}),
				bbar:pgBarWSObjetos_rol,
		listeners:{
			rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
				if(!btnEditarCgg_sec_objeto_rol.hidden){
					btnEditarCgg_sec_objeto_rol.fireEvent('click', btnEditarCgg_sec_objeto_rol);
				}
			}
		}
	});

	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sec_reporte.
	*/
	var chkCsrpt_activo = new Ext.grid.CheckColumn(
	{dataIndex:'CSRPR_ESTADO',header:'Autorizado?',width:60,sortable:true});
	var cmCgg_sec_reporte = new Ext.grid.ColumnModel([
	{dataIndex:'CSRPT_REPORTE',header:'Reporte',width:150,sortable:true},
	{dataIndex:'CSRPT_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
	chkCsrpt_activo]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_sec_reporte por un campo especifico.
	*/
	var gsCgg_sec_reporte = new Ext.data.Store({
	proxy:new Ext.ux.bsx.SoapProxy({
	url:URL_WS+"Cgg_sec_reporte",
	method:"selectPageDirect",
	pagin:true
	}),
	remoteSort:true,
	reader:new Ext.data.JsonReader({
	id:'CSRPR_CODIGO',
	root:'dataSet',
	totalProperty: 'totalCount'
	},[
	{name:'CSRPR_CODIGO'},
	{name:'CSRPT_CODIGO'},
	{name:'CSRPT_REPORTE'},
	{name:'CSRPT_DESCRIPCION'},
	{name:'CSRPR_ESTADO'},
	{name:'CSRPT_ACTIVO'}
	]),
	sortInfo:{field: 'CSRPT_REPORTE', direction: 'ASC'},
	baseParams:{keyword:"",format:'JSON',inCsrol_codigo:''}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_sec_reporte.
	*/
	var pgBarCgg_sec_reporte= new Ext.PagingToolbar({
	store: gsCgg_sec_reporte,
	displayInfo: true,
	pageSize:RECORD_PAGE,
	displayMsg: 'Mostrando {0} - {1} de {2}',
	temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sec_reporte en un formato tabular de filas y columnas.
	*/
	var grdCgg_sec_reporte = new Ext.grid.EditorGridPanel({
	cm:cmCgg_sec_reporte,
	store:gsCgg_sec_reporte,
	title:"Reportes",
	region:'center',
	sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
	loadMask:{msg:"Cargando..."},
	clicksToEdit: 1,
	plugins:[chkCsrpt_activo],
	tbar: [
	'Buscar: ',
	new Ext.ux.bsx.SearchField({
	store:gsCgg_sec_reporte,
	width:200
	})
	],
	bbar:pgBarCgg_sec_reporte,
	listeners:{
		afteredit:function(rec){
			var prmRpt = new SOAPClientParameters();
			prmRpt.add("inCsrpr_codigo",rec.record.get("CSRPR_CODIGO"));
			prmRpt.add("inCsrol_codigo",tmpRecord.get('CSROL_CODIGO'));
			prmRpt.add("inCsrpt_codigo",rec.record.get("CSRPT_CODIGO"));
			SOAPClient.invoke(URL_WS + 'Cgg_sec_reporte_rol', 'insertDelete', prmRpt, true, function(inServiceResponse) {				
				gsCgg_sec_reporte.reload();
			});
		}
	}
	});	
	
	var tbTiposObjetos_rol = new Ext.TabPanel({
		activeTab:0,
		tbar:['Rol: ',txtCsrol_codigo,btnCsrol_codigoCgg_sec_objeto],
		region:'center',
		items:[grdCgg_sec_objeto_rol,grdWSObjetos_rol,grdCgg_sec_reporte]
	});
	if(inDesktop){
		gsCgg_sec_objeto_rol.reload({
			params:{
				start:0,
				limit:RECORD_PAGE
			}
		});
		gsWSObjetos_rol.reload({
			params:{
				start:0,
				limit:RECORD_PAGE
			}
		});						
		grdCgg_sec_objeto_rol.getSelectionModel().on("selectionchange",function(inSelectionModel){
			btnEditarCgg_sec_objeto_rol.setDisabled(!inSelectionModel.hasSelection());
			btnEliminarCgg_sec_objeto_rol.setDisabled(!inSelectionModel.hasSelection());
		});
		grdWSObjetos_rol.getSelectionModel().on("selectionchange",function(inSelectionModel){
			btnEditarCgg_sec_objeto_rol.setDisabled(!inSelectionModel.hasSelection());
			btnEliminarCgg_sec_objeto_rol.setDisabled(!inSelectionModel.hasSelection());
		});
		grdCgg_sec_reporte.getSelectionModel().on("selectionchange",function(inSelectionModel){
			btnEditarCgg_sec_objeto_rol.setDisabled(!inSelectionModel.hasSelection());
			btnEliminarCgg_sec_objeto_rol.setDisabled(!inSelectionModel.hasSelection());
		});
		/**
		* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_sec_objeto.
		*/
		var winFrmListadoCgg_sec_objeto_rol = inDesktop.createWindow({
				id:'winFrmListadoCgg_sec_objeto_rol',
				title:tituloListadoCgg_sec_objeto_rol,
				width:660,
				minWidth:600,
				height:400,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				tbar:getPanelTitulo(tituloListadoCgg_sec_objeto_rol,descListadoCgg_sec_objeto_rol),
				items:[tbTiposObjetos_rol],
				bbar:[btnNuevoCgg_sec_objeto_rol,btnEditarCgg_sec_objeto_rol,btnEliminarCgg_sec_objeto_rol,'->',btnSalirCgg_sec_objeto_rol]
		});
		/**
		* Funcion que aplica los privilegios del usuario.
		*/
		applyGrants(winFrmListadoCgg_sec_objeto_rol.getBottomToolbar());
	}
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_sec_objeto_rol.
	* @returns ventana winFrmCgg_sec_objeto.
	* @base FrmListadoCgg_sec_objeto_rol.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_sec_objeto_rol;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_sec_objeto_rol.
	* @base FrmListadoCgg_sec_objeto_rol.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_sec_objeto_rol.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_sec_objeto_rol;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_sec_objeto_rol;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_sec_objeto_rol.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_sec_objeto_rol.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_sec_objeto_rol desde una instancia.
*/
FrmListadoCgg_sec_objeto_rol.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_sec_objeto_rol desde una instancia.
*/
FrmListadoCgg_sec_objeto_rol.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_sec_objeto_rol,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_sec_objeto_rol.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_sec_objeto_rol desde una instancia.
*/
FrmListadoCgg_sec_objeto_rol.prototype.loadData = function(){
	this.loadData();
}
