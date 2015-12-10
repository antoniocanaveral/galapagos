/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_entrevista.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */

function FrmListadoCgg_gem_entrevista(inRecordVacante) {	
	var urlListadoCgg_gem_entrevista = URL_WS + "Cgg_gem_entrevista";
	var tituloListadoCgg_gem_entrevista = 'Listado entrevistas';
	var descListadoCgg_gem_entrevista = 'El formulario permite listar la informaci\u00f3n de las entrevistas realizadas';
	/**
	 * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_entrevista.
	 */
	var btnNuevoCgg_gem_entrevista = new Ext.Button({
		id: 'btnNuevoCgg_gem_entrevista',
		text: 'Nuevo',
		iconCls: 'iconNuevo',
		listeners: {
			click: function () {
				var objCgg_gem_entrevista = new FrmCgg_gem_entrevista("insert",null,inRecordVacante);
				objCgg_gem_entrevista.closeHandler(function () {
					gsCgg_gem_entrevista.reload();
				});
				objCgg_gem_entrevista.show();
			}
		}
	});
	/**
	 * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_entrevista.
	 */
	var btnEditarCgg_gem_entrevista = new Ext.Button({
		id: 'btnEditarCgg_gem_entrevista',
		text: 'Editar',
		disabled:true,
		iconCls: 'iconEditar',
		listeners: {
			click: function () {
				var r = grdCgg_gem_entrevista.getSelectionModel().getSelected();
				if (r) {
					var objCgg_gem_entrevista = new FrmCgg_gem_entrevista("update", r,inRecordVacante);
					objCgg_gem_entrevista.closeHandler(function () {
						gsCgg_gem_entrevista.reload();
					});
					objCgg_gem_entrevista.loadData();
					objCgg_gem_entrevista.show();
				}
			}
		}
	});
	/**
	 * Ext.Button Permite registrar el criterio tecnico por parte del administrador con respecto a la entrevista.
	 */
	var btnCriterioCgg_gem_entrevista = new Ext.Button({
		id: 'btnCriterioCgg_gem_entrevista',
		text: 'Criterio t\u00e9cnico',
		disabled:true,
		iconCls: 'iconEditar',
		listeners: {
			click: function () {
				var r = grdCgg_gem_entrevista.getSelectionModel().getSelected();
				if (r) {
					var objCgg_gem_entrevista = new FrmCgg_gem_entrevista("criterio", r,inRecordVacante);
					objCgg_gem_entrevista.closeHandler(function () {
						gsCgg_gem_entrevista.reload();
					});
					objCgg_gem_entrevista.loadData();
					objCgg_gem_entrevista.show();
				}
			}
		}
	});
	/**
	 * Ext.Button Permite registrar el criterio tecnico por parte del administrador con respecto a la entrevista.
	 */
	var btnVerCgg_gem_entrevista = new Ext.Button({
		id: 'btnVerCgg_gem_entrevista',
		text: 'Ver entrevista',
		disabled:true,
		iconCls: 'iconBuscar',
		listeners: {
			click: function () {
				var r = grdCgg_gem_entrevista.getSelectionModel().getSelected();
				if (r) {
					var objCgg_gem_entrevista = new FrmCgg_gem_entrevista("ver", r,inRecordVacante);
					objCgg_gem_entrevista.closeHandler(function () {
						gsCgg_gem_entrevista.reload();
					});
					objCgg_gem_entrevista.loadData();
					objCgg_gem_entrevista.show();
				}
			}
		}
	});
	/**
	 * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_gem_entrevista.
	 */
	var btnEliminarCgg_gem_entrevista = new Ext.Button({
		id: 'btnEliminarCgg_gem_entrevista',
		text: 'Eliminar',
		iconCls: 'iconEliminar',
		disabled:true,
		listeners: {
			click: function () {
				Ext.Msg.show({
					title: 'Aviso',
					msg: '¿Seguro de eliminar el registro seleccionado?',
					buttons: Ext.Msg.YESNO,
					fn: SWRCgg_gem_entrevista,
					icon: Ext.MessageBox.QUESTION
				});

				function SWRCgg_gem_entrevista(btn) {
					if (btn == 'yes') {
						try {
							function CallBackCgg_gem_entrevista(r) {
								winFrmListadoCgg_gem_entrevista.getEl().unmask();
								if (r == 'true') {
									Ext.Msg.show({
										title: tituloListadoCgg_gem_entrevista,
										msg: 'La informaci\u00f3n de Gem entrevista ha sido eliminada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.INFO
									});
									gsCgg_gem_entrevista.reload();
								} else {
									Ext.Msg.show({
										title: tituloListadoCgg_gem_entrevista,
										msg: 'La informaci\u00f3n de Gem entrevista no ha podido ser eliminada.',
										buttons: Ext.Msg.OK,
										icon: Ext.MessageBox.ERROR
									});
								}
							}
							winFrmListadoCgg_gem_entrevista.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCgent_codigo', grdCgg_gem_entrevista.getSelectionModel().getSelected().get('CGENT_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_gem_entrevista, "delete", param, true, CallBackCgg_gem_entrevista);
						} catch (inErr) {
							winFrmListadoCgg_gem_entrevista.getEl().unmask();
						}
					}
				}
			}
		}
	});
	/**
	 * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_entrevista.
	 */
	var btnSalirCgg_gem_entrevista = new Ext.Button({
		id: 'btnSalirCgg_gem_entrevista',
		text: 'Salir',
		iconCls: 'iconSalir',
		listeners: {
			click: function () {
				winFrmListadoCgg_gem_entrevista.close();
			}
		}
	});	
	/*0 - NO REALIZADA	
	1 - NO FINALIZADA
	2 - FINALIZADA*/
	function rndEstadoEntrevista(v){
		switch (v){
			case "0": v= "NO REALIZADA"; break;
			case "1": v= "NO FINALIZADA"; break;
			case "2": v= "FINALIZADA"; break;
		}
		return v;
	}
	function rndFormatFecha(v){
		return Ext.util.Format.date(v,"Y-m-d");
	}
	/**
	 * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_entrevista.
	 */
	var cmCgg_gem_entrevista = new Ext.grid.ColumnModel([			
		{dataIndex: 'NOMBRE_USUARIO',header: 'Candidato',width: 150,sortable: true,hidden:true},
		{dataIndex: 'CGENT_FECHA_REALIZACION',header: 'Fecha realizaci\u00f3n',width: 100,sortable: true,renderer:rndFormatFecha},
		{dataIndex: 'CGENT_ESTADO_ENTREVISTA',header: 'Estado entrevista',width: 100,sortable: true,renderer:rndEstadoEntrevista},
		{dataIndex: 'CGENT_LUGAR',header: 'Lugar',width: 150,sortable: true},
		{dataIndex: 'CGENT_OBSERVACION',header: 'Observaci\u00f3n',width: 250,sortable: true},
		{dataIndex: 'CGENT_FECHA_CRITERIO_TECNICO',header: 'Fecha criterio t\u00e9cnico',width: 100,sortable: true,renderer:rndFormatFecha},
		{dataIndex: 'CGENT_CRITERIO_TECNICO',header: 'Criterio t\u00e9cnico',width: 250,sortable: true}
	]);
	/**
	 * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_entrevista por un campo especifico.
	 */
	var gsCgg_gem_entrevista = new Ext.data.GroupingStore({
		proxy: new Ext.ux.bsx.SoapProxy({
			url: URL_WS + "Cgg_gem_entrevista",
			method: "selectPageDirect"
		}),
		remoteSort:true,
		reader: new Ext.data.JsonReader({
			id:'CGENT_CODIGO',
			root:'dataSet',
			totalProperty: 'totalCount'
		}, [
			{name: 'CGENT_CODIGO'},
			{name: 'CGCND_CODIGO'},
			{name: 'NOMBRE_USUARIO'},
			{name: 'CGENT_ESTADO_ENTREVISTA'},
			{name: 'CGENT_FECHA_REALIZACION',type:"date",dateFormat:'Y-m-d H:i:s.u'},
			{name: 'CGENT_FECHA_CRITERIO_TECNICO',type:"date",dateFormat:'Y-m-d H:i:s.u'},
			{name: 'CGENT_CRITERIO_TECNICO'},
			{name: 'CGENT_LUGAR'},
			{name: 'CGENT_OBSERVACION'}
		]),
		sortInfo: {
			field: 'CGCND_CODIGO',
			direction: 'ASC'
		},
		baseParams: {
			inCgvcn_codigo: inRecordVacante.get("CGVCN_CODIGO"),
			keyword:"",			
			format: 'JSON'
		},
		groupField:'NOMBRE_USUARIO'		
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_gem_entrevista.
	*/
	var pgBarCgg_gem_entrevista= new Ext.PagingToolbar({
		store: gsCgg_gem_entrevista,
		displayInfo: true,
		pageSize:RECORD_PAGE,
		displayMsg: 'Mostrando {0} - {1} de {2}',
		temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	 * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_entrevista en un formato tabular de filas y columnas.
	 */
	var grdCgg_gem_entrevista = new Ext.grid.GridPanel({
		cm: cmCgg_gem_entrevista,
		store: gsCgg_gem_entrevista,
		region: 'center',
		sm: new Ext.grid.RowSelectionModel({
			singleSelect: true
		}),
		loadMask: {
			msg: "Cargando..."
		},
		view: new Ext.grid.GroupingView({            
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
		tbar: [
			'Buscar: ',
			new Ext.ux.bsx.SearchField({
				store:gsCgg_gem_entrevista,
				width:250
			})
		],
		bbar:pgBarCgg_gem_entrevista,
		listeners: {
			rowdblclick: function (inGridComponent, inRowIndex, inEventObject) {
				btnVerCgg_gem_entrevista.fireEvent("click");
			}
		}
	});
	grdCgg_gem_entrevista.getSelectionModel().on("selectionchange",function(selecModel){		
		var swModel=selecModel.hasSelection();
		var tmpData;
		if (swModel){
			tmpData = grdCgg_gem_entrevista.getSelectionModel().getSelected().get("CGENT_CRITERIO_TECNICO");
		}
		btnVerCgg_gem_entrevista.setDisabled(!swModel);
		btnCriterioCgg_gem_entrevista.setDisabled(!swModel);		
		btnEliminarCgg_gem_entrevista.setDisabled(!swModel);
		btnEditarCgg_gem_entrevista.setDisabled((tmpData)?true:false);
	});
	gsCgg_gem_entrevista.reload({
        params: {
            start: 0,
            limit: RECORD_PAGE,
            format: 'JSON'
        }
    });
	
	/**
	 * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gem_entrevista.
	 */
	var estadoOfertaENT= inRecordVacante.get("CGVCN_ESTADO_OFERTA");
	var arrBBar = new Array();
	arrBBar.push(btnVerCgg_gem_entrevista);
	if (SEG_GES_EMP == "CSROL_GEADM")
		arrBBar.push(btnCriterioCgg_gem_entrevista)
	if (SEG_GES_EMP == "CSROL_GEEMP"){
		arrBBar.push(btnNuevoCgg_gem_entrevista);
		arrBBar.push(btnEditarCgg_gem_entrevista);
		arrBBar.push(btnEliminarCgg_gem_entrevista);		
	}
	arrBBar.push('->');		
	arrBBar.push(btnSalirCgg_gem_entrevista);			
	
	var winFrmListadoCgg_gem_entrevista = new Ext.Window({
		id: 'winFrmListadoCgg_gem_entrevista',
		title: tituloListadoCgg_gem_entrevista,
		width: 650,
		minWidth: 500,
		height: 475,
		minHeight: 300,
		maximizable: true,
		minimizable: true,
		constrainHeader: true,
		layout: 'border',
		tbar: getPanelTitulo('Listado de entrevistas', descListadoCgg_gem_entrevista),
		items: [grdCgg_gem_entrevista],
		bbar: arrBBar
	});
	/**
	 * Funcion que aplica los privilegios del usuario.
	 */
	applyGrants(winFrmListadoCgg_gem_entrevista.getBottomToolbar());
	/**
	 * Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_entrevista.
	 * @returns ventana winFrmCgg_gem_entrevista.
	 * @base FrmListadoCgg_gem_entrevista.prototype.show
	 */
	this.getWindow = function () {
		return winFrmListadoCgg_gem_entrevista;
	}
	/**
	 * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gem_entrevista.
	 * @base FrmListadoCgg_gem_entrevista.prototype.loadData
	 */
	this.loadData = function () {
		gsCgg_gem_entrevista.load();
	}
	/**
	 * Funcion miembro que develve el ColumnModel utilizado en el listado.
	 */
	this.getColumnModel = function () {
		return cmCgg_gem_entrevista;
	}
	/**
	 * Funcion miembro que develve el Store utilizado en el listado.
	 */
	this.getStore = function () {
		return gsCgg_gem_entrevista;
	}
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_gem_entrevista.prototype.getColumnModel = function () {
	this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_gem_entrevista.prototype.getStore = function () {
	this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_entrevista desde una instancia.
 */
FrmListadoCgg_gem_entrevista.prototype.show = function () {
	this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_entrevista desde una instancia.
 */
FrmListadoCgg_gem_entrevista.prototype.close = function () {
	this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_entrevista,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_gem_entrevista.prototype.closeHandler = function (inFunctionHandler) {
	this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gem_entrevista desde una instancia.
 */
FrmListadoCgg_gem_entrevista.prototype.loadData = function () {
	this.loadData();
}