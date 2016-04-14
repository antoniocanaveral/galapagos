/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_sec_perfil_rol.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */

function FrmListadoCgg_sec_usuario_rol(inDesktop) {
    var optMenu = 'Seguridad/Perfiles';
	var urlCgg_sec_usuario_rol = URL_WS + "Cgg_sec_usuario_rol";
    var urlListadoCgg_sec_usuario_rol = URL_WS + "Cgg_sec_usuario_rol";
    var tituloListadoCgg_sec_usuario_rol = 'Listado de perfiles';
    var descListadoCgg_sec_perfil_rol = 'El formulario permite administrar informaci\u00f3n de los roles concedidos a los usuarios.';
    var tmpUsuario;
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_sec_usuario_rol.
     */
    var btnNuevoCgg_sec_perfil_rol = new Ext.Button({
        id: 'btnNuevoCgg_sec_perfil_rol',
        text: 'Agregar',
        iconCls: 'iconNuevo',
		disabled:true,
        listeners: {
            click: function () {
				if(!tmpUsuario)
					return;
                var tmpFLCgg_sec_rol = new FrmListadoCgg_sec_rol();
                var objBusqueda = new DlgBusqueda(tmpFLCgg_sec_rol.getStore(), tmpFLCgg_sec_rol.getColumnModel());
                objBusqueda.closeHandler(function () {
                    var tmpRecord = objBusqueda.getSelectedRow();
                    if (tmpRecord){
						tmpRol = tmpRecord.get('CSROL_CODIGO');

						function CallBackCgg_sec_perfil_rol(r) {
							winFrmListadoCgg_sec_usuario_rol.getEl().unmask();
							if (r == 'true') {
								Ext.Msg.show({
									title: tituloListadoCgg_sec_usuario_rol,
									msg: 'La informaci\u00f3n del Rol ha sido almacenada.',
									buttons: Ext.Msg.OK,
									icon: Ext.MessageBox.INFO
								});
								gsCgg_usuario_rol.reload();
							} else {
								Ext.Msg.show({
									title: tituloListadoCgg_sec_usuario_rol,
									msg: 'La informaci\u00f3n del Rol no ha podido ser almacenada. '+r,
									buttons: Ext.Msg.OK,
									icon: Ext.MessageBox.ERROR
								});
							}
						}
						
						winFrmListadoCgg_sec_usuario_rol.getEl().mask('Guardando...', 'x-mask-loading');
						var param = new SOAPClientParameters();
						param.add('inCsrol_codigo', tmpRol);
						param.add('inCusu_codigo', tmpUsuario);
						SOAPClient.invoke(urlCgg_sec_usuario_rol, 'insert', param, true, CallBackCgg_sec_perfil_rol);
					}
                });
                objBusqueda.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_sec_usuario_rol.
     */
    var btnEliminarCgg_sec_perfil_rol = new Ext.Button({
        id: 'btnEliminarCgg_sec_perfil_rol',
        text: 'Eliminar',
        iconCls: 'iconEliminar',
		disabled:true,
        listeners: {
            click: function () {
                Ext.Msg.show({
                    title: 'Aviso',
                    msg: 'Est\u00e1 seguro de eliminar?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_sec_perfil_rol,
                    icon: Ext.MessageBox.QUESTION
                });

                function SWRCgg_sec_perfil_rol(btn) {
                    if (btn == 'yes') {
                        try {
                            function CallBackCgg_sec_perfil_rol(r) {
                                winFrmListadoCgg_sec_usuario_rol.getEl().unmask();
                                if (r == 'true') {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_sec_usuario_rol,
                                        msg: 'El Rol seleccionado ha sido retirado del Perfil.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_usuario_rol.reload();
                                } else {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_sec_usuario_rol,
                                        msg: 'El Rol seleccionado no ha sido retirado del Perfil. '+r,
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_sec_usuario_rol.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCsper_codigo', grdCgg_usuario_rol.getSelectionModel().getSelected().get('CSPER_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_sec_usuario_rol, "delete", param, true, CallBackCgg_sec_perfil_rol);
                        } catch (inErr) {
                            winFrmListadoCgg_sec_usuario_rol.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_sec_usuario_rol.
     */
    var btnSalirCgg_sec_perfil_rol = new Ext.Button({
        id: 'btnSalirCgg_sec_perfil_rol',
        text: 'Salir',
        iconCls: 'iconSalir',
        listeners: {
            click: function () {
                winFrmListadoCgg_sec_usuario_rol.close();
            }
        }
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sec_perfil_rol.
     */
    var cmCgg_sec_perfil_rol = new Ext.grid.ColumnModel([
        {dataIndex: 'CSPER_CODIGO',header: 'Codigo',width: 150,sortable: true,hideable:false,hidden:true},
		{dataIndex: 'CSROL_CODIGO',header: 'Codigo',width: 150,sortable: true,hideable:false,hidden:true},
		{dataIndex: 'ROL',header: 'Rol',width: 250,sortable: true},
		{dataIndex: 'CUSU_CODIGO',header: 'Codigo',width: 150,sortable: true,hideable:false,hidden:true}
	]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_sec_perfil_rol por un campo especifico.
     */
    var gsCgg_usuario_rol = new Ext.data.Store({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_sec_usuario_rol",
            method: "selectPageUsuario",
            pagin: true
        }),
        remoteSort: true,
        reader: new Ext.data.JsonReader({
            id: 'CSPER_CODIGO',
            root: 'dataSet',
            totalProperty: 'totalCount'
        }, [
            {name: 'CSPER_CODIGO'},
			{name: 'CSROL_CODIGO'},
			{name: 'ROL'},
			{name: 'CUSU_CODIGO'},
			{name: 'USUARIO'},
        ]),
        sortInfo: {
            field: 'ROL',
            direction: 'ASC'
        },
        baseParams: {
            keyword: "",
            format: 'JSON',
			inCusu_codigo:''
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_sec_perfil_rol.
     */
    var pgBarCgg_sec_perfil_rol = new Ext.PagingToolbar({
        store: gsCgg_usuario_rol,
        displayInfo: true,
        pageSize: RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sec_perfil_rol en un formato tabular de filas y columnas.
     */
    var grdCgg_usuario_rol = new Ext.grid.GridPanel({
		title:'Roles',
        cm: cmCgg_sec_perfil_rol,
        store: gsCgg_usuario_rol,
        region: 'center',
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true
        }),
        loadMask: {
            msg: "Cargando..."
        },
        tbar: ['Buscar: ',
            new Ext.ux.bsx.SearchField({
            store: gsCgg_usuario_rol,
            width: 200
        })
            ],
        bbar: pgBarCgg_sec_perfil_rol
    });
    gsCgg_usuario_rol.reload({
        params: {
            start: 0,
            limit: RECORD_PAGE,
			inCusu_codigo:''
        }
    });
    
	/**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sec_perfil.
     */
    var chkUsuarioInterno = new Ext.ux.grid.CheckColumn(
    {dataIndex:'CUSU_USUARIO_INTERNO',header:'Usuario interno',width:150,sortable:true,editable:false}
            );
    var cmCgg_sec_perfil = new Ext.grid.ColumnModel([
    {
	    dataIndex: 'CUSU_NOMBRE_USUARIO',
        header: 'Usuario',
        width: 150,
        sortable: true},
	chkUsuarioInterno
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_sec_perfil por un campo especifico.
     */
    var gsCgg_usuario = new Ext.data.Store({
        proxy: new Ext.ux.bsx.SoapProxy({
		url: URL_WS + "Cgg_usuario",
            method: "selectPageDirect",
            pagin: true
        }),
        remoteSort: true,
        reader: new Ext.data.JsonReader({
		id: 'CUSU_CODIGO',
            root: 'dataSet',
            totalProperty: 'totalCount'
        }, [
			{name:'CUSU_CODIGO'},
			{name:'CRCRG_CODIGO'},
			{name:'CRPER_CODIGO'},
			{name:'CRPJR_CODIGO'},
			{name:'CTAGV_CODIGO'},
			{name:'CCTN_CODIGO'},
			{name:'CUSU_NOMBRE_USUARIO'},
			{name:'CUSU_CLAVE_ACCESO'},
			{name:'CUSU_USUARIO_INTERNO'},
			{name:'CUSU_CADUCA_CLAVE'},
			{name:'CUSU_FECHA_CLAVE_ACT'},
			{name:'CUSU_ACTIVO'}
        ]),
        sortInfo: {
		field: 'CUSU_NOMBRE_USUARIO',
            direction: 'ASC'
        },
        baseParams: {
            keyword: "",
            format: 'JSON',
			inCusu_usuario_interno:'1',
			inCrper_codigo:''
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_sec_perfil.
     */
    var pgBarCgg_sec_perfil = new Ext.PagingToolbar({
        store: gsCgg_usuario,
        displayInfo: true,
        pageSize: RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sec_perfil en un formato tabular de filas y columnas.
     */
    var grdCgg_usuario = new Ext.grid.GridPanel({
        cm: cmCgg_sec_perfil,
        store: gsCgg_usuario,
        region: 'center',
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true
        }),
        loadMask: {
            msg: "Cargando..."
        },
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
            store: gsCgg_usuario,
            width: 200
        })
            ],
        bbar: pgBarCgg_sec_perfil,
        listeners: {
            cellclick:function (inGridComponent, inRowIndex, inEventObject) {
				tmpUsuario = grdCgg_usuario.getSelectionModel().getSelected().get('CUSU_CODIGO');
				gsCgg_usuario_rol.reload({
							params: {
								start: 0,
								limit: RECORD_PAGE,
								format: 'JSON',
								inCusu_codigo:tmpUsuario
							}
						});
            }
        }
    });
    gsCgg_usuario.reload({
        params: {
            start: 0,
            limit: RECORD_PAGE
        }
    });
	var pnlUsuario = new Ext.Panel({
		layout:'border',
		region: 'west',
		width:300,
		split:true,
		title:'Usuarios',
		items:[
			{
				xtype: 'panel',
				height:34,
				layout:'column',
				region:'north',
				frame:true,
				items: [{
					columnWidth:.5,
					layout:'form',
					items:[
					{
					xtype:'button',
					text: 'Internos',
					anchor:'100%',
					pressed:true,
					enableToggle:true,
					toggleGroup:'pnlPrfTipoUsuario',
					handler:function(){
						gsCgg_usuario.baseParams.inCusu_usuario_interno = '1';
						gsCgg_usuario.baseParams.start = 0;
						gsCgg_usuario.baseParams.limit = RECORD_PAGE;
						gsCgg_usuario.reload();
					}
					}]
				},{columnWidth:.5,
					layout:'form',
					items:[{
					xtype:'button',
					text:'Externos',
					anchor:'100%',
					toggleGroup:'pnlPrfTipoUsuario',
					enableToggle:true,
					handler:function(){
						gsCgg_usuario.baseParams.inCusu_usuario_interno = '0';
						gsCgg_usuario.baseParams.start = 0;
						gsCgg_usuario.baseParams.limit = RECORD_PAGE;
						gsCgg_usuario.reload();
					}
					}
					]
				}
				]
			},
			grdCgg_usuario
		]
	});
	grdCgg_usuario.getSelectionModel().on("selectionchange",function(inSelectionModel){
		btnNuevoCgg_sec_perfil_rol.setDisabled(!inSelectionModel.hasSelection());
		gsCgg_usuario_rol.removeAll();
	});
	grdCgg_usuario_rol.getSelectionModel().on("selectionchange",function(inSelectionModel){
		btnEliminarCgg_sec_perfil_rol.setDisabled(!inSelectionModel.hasSelection());
	});
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_sec_perfil_rol.
     */
    var winFrmListadoCgg_sec_usuario_rol = inDesktop.createWindow({
        id: 'winFrmListadoCgg_sec_usuario_rol',
        title: tituloListadoCgg_sec_usuario_rol,
        tbar: getPanelTitulo(tituloListadoCgg_sec_usuario_rol, descListadoCgg_sec_perfil_rol),
		layout:'border',
        items: [ pnlUsuario,grdCgg_usuario_rol],
        width: 600,
        minWidth: 600,
        height: 400,
        minHeight: 400,
        maximizable: true,
        minimizable: true,
        constrain: true,
        bbar: [btnNuevoCgg_sec_perfil_rol,btnEliminarCgg_sec_perfil_rol, '->', btnSalirCgg_sec_perfil_rol]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_sec_usuario_rol.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_sec_usuario_rol.
     * @returns ventana winFrmCgg_sec_perfil_rol.
     * @base FrmListadoCgg_sec_usuario_rol.prototype.show
     */
    this.getWindow = function () {
        return winFrmListadoCgg_sec_usuario_rol;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_sec_usuario_rol.
     * @base FrmListadoCgg_sec_usuario_rol.prototype.loadData
     */
    this.loadData = function () {
        gsCgg_usuario_rol.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function () {
        return cmCgg_sec_perfil_rol;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function () {
        return gsCgg_usuario_rol;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_sec_usuario_rol.prototype.getColumnModel = function () {
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_sec_usuario_rol.prototype.getStore = function () {
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_sec_usuario_rol desde una instancia.
 */
FrmListadoCgg_sec_usuario_rol.prototype.show = function () {
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_sec_usuario_rol desde una instancia.
 */
FrmListadoCgg_sec_usuario_rol.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_sec_usuario_rol,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_sec_usuario_rol.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_sec_usuario_rol desde una instancia.
 */
FrmListadoCgg_sec_usuario_rol.prototype.loadData = function () {
    this.loadData();
}