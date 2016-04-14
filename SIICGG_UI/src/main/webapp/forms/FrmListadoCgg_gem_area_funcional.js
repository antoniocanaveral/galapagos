/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_area_funcional.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */

function FrmListadoCgg_gem_area_funcional(inDesktop) {   
	var optMenu = 'Gesti\u00F3n de Empleo/Configuraci\u00f3n/Areas funcionales';
    var urlListadoCgg_gem_area_funcional = URL_WS + "Cgg_gem_area_funcional";
    var tituloListadoCgg_gem_area_funcional = 'Area Funcional';
    var descListadoCgg_gem_area_funcional = 'El formulario permite listar la informaci\u00f3n de las diferentes \u00E1reas funcionales.';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_area_funcional.
     */
    var btnNuevoCgg_gem_area_funcional = new Ext.Button({
        id: 'btnNuevoCgg_gem_area_funcional',
        text: 'Nuevo',
        iconCls: 'iconNuevo',
        listeners: {
            click: function () {
                var objCgg_gem_area_funcional = new FrmCgg_gem_area_funcional("insert");
                objCgg_gem_area_funcional.closeHandler(function () {
                    gsCgg_gem_area_funcional.reload();
                });
                objCgg_gem_area_funcional.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_area_funcional.
     */
    var btnEditarCgg_gem_area_funcional = new Ext.Button({
        id: 'btnEditarCgg_gem_area_funcional',
        text: 'Editar',
        iconCls: 'iconEditar',
        listeners: {
            click: function () {
                var r = grdCgg_gem_area_funcional.getSelectionModel().getSelected();
                if (r) {
                    var objCgg_gem_area_funcional = new FrmCgg_gem_area_funcional("update", r);
                    objCgg_gem_area_funcional.closeHandler(function () {
                        gsCgg_gem_area_funcional.reload();
                    });
                    objCgg_gem_area_funcional.loadData();
                    objCgg_gem_area_funcional.show();
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_gem_area_funcional.
     */
    var btnEliminarCgg_gem_area_funcional = new Ext.Button({
        id: 'btnEliminarCgg_gem_area_funcional',
        text: 'Eliminar',
        iconCls: 'iconEliminar',
        listeners: {
            click: function () {
                Ext.Msg.show({
                    title: 'Aviso',
                    msg: '�Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_gem_area_funcional,
                    icon: Ext.MessageBox.QUESTION
                });

                function SWRCgg_gem_area_funcional(btn) {
                    if (btn == 'yes') {
                        try {
                            function CallBackCgg_gem_area_funcional(r) {
                                winFrmListadoCgg_gem_area_funcional.getEl().unmask();
                                if (r == 'true') {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_gem_area_funcional,
                                        msg: 'La informaci\u00f3n sobre la categor\u00EDa ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_gem_area_funcional.reload();
                                } else {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_gem_area_funcional,
                                        msg: 'La informaci\u00f3n sobre la categir\u00EDa no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_gem_area_funcional.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCgare_codigo', grdCgg_gem_area_funcional.getSelectionModel().getSelected().get('CGARE_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_gem_area_funcional, "delete", param, true, CallBackCgg_gem_area_funcional);
                        } catch (inErr) {
                            winFrmListadoCgg_gem_area_funcional.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_area_funcional.
     */
    var btnSalirCgg_gem_area_funcional = new Ext.Button({
        id: 'btnSalirCgg_gem_area_funcional',
        text: 'Salir',
        iconCls: 'iconSalir',
        listeners: {
            click: function () {
                winFrmListadoCgg_gem_area_funcional.close();
            }
        }
    });
   
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_area_funcional.
     */
    var cmCgg_gem_area_funcional = new Ext.grid.ColumnModel([		
		{dataIndex:'CGARE_NOMBRE',header:'Nombre',width:150,sortable:true},
		{dataIndex:'CGARE_DESCRIPCION',header:'Descripci\u00f3n',width:400,sortable:true}
	]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_area_funcional por un campo especifico.
     */
    var gsCgg_gem_area_funcional = new Ext.data.Store({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_gem_area_funcional",
            method: "selectPage",
            pagin: true
        }),
        remoteSort: true,
        reader: new Ext.data.JsonReader({
            id: 'CGARE_CODIGO',
            root: 'dataSet',
            totalProperty: 'totalCount'
        }, [
			{name:'CGARE_CODIGO'},
			{name:'CGARE_NOMBRE'},
			{name:'CGARE_DESCRIPCION'}
		]),
        sortInfo: {
            field: 'CGARE_NOMBRE',
            direction: 'ASC'
        },
        baseParams: {
            keyword: "",
            format: 'JSON'
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_gem_area_funcional.
     */
    var pgBarCgg_gem_area_funcional = new Ext.PagingToolbar({
        store: gsCgg_gem_area_funcional,
        displayInfo: true,
        pageSize: RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_area_funcional en un formato tabular de filas y columnas.
     */
    var grdCgg_gem_area_funcional = new Ext.grid.GridPanel({
        cm: cmCgg_gem_area_funcional,
        store: gsCgg_gem_area_funcional,
        region: 'center',
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true
        }),
        loadMask: {
            msg: "Cargando..."
        },
        tbar: ['Buscar: ', new Ext.ux.bsx.SearchField({
            store: gsCgg_gem_area_funcional,
            width: 200
        })],
        bbar: pgBarCgg_gem_area_funcional,
        listeners: {
            rowdblclick: function (inGridComponent, inRowIndex, inEventObject) {
                if (!btnEditarCgg_gem_area_funcional.disabled) {
                    btnEditarCgg_gem_area_funcional.fireEvent('click', btnEditarCgg_gem_area_funcional);
                }
            }
        }
    });
    gsCgg_gem_area_funcional.reload({
        params: {
            start: 0,
            limit: RECORD_PAGE,
            format: 'JSON'
        }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gem_area_funcional.
     */
	if (inDesktop)
		var winFrmListadoCgg_gem_area_funcional = inDesktop.createWindow({
			id: 'winFrmListadoCgg_gem_area_funcional',
			title: tituloListadoCgg_gem_area_funcional,
			width: 600,
			minWidth: 600,
			height: 400,
			minHeight: 400,
			maximizable: true,
			minimizable: true,
			constrainHeader: true,
			layout: 'border',
			tbar: getPanelTitulo('Listado ' + tituloListadoCgg_gem_area_funcional, descListadoCgg_gem_area_funcional),
			items: [grdCgg_gem_area_funcional],
			bbar: [btnNuevoCgg_gem_area_funcional, btnEditarCgg_gem_area_funcional, btnEliminarCgg_gem_area_funcional,'->', btnSalirCgg_gem_area_funcional]
		});
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_gem_area_funcional.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_area_funcional.
     * @returns ventana winFrmCgg_gem_area_funcional.
     * @base FrmListadoCgg_gem_area_funcional.prototype.show
     */
    this.getWindow = function () {
        return winFrmListadoCgg_gem_area_funcional;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gem_area_funcional.
     * @base FrmListadoCgg_gem_area_funcional.prototype.loadData
     */
    this.loadData = function () {
        gsCgg_gem_area_funcional.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function () {
        return cmCgg_gem_area_funcional;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function () {
        return gsCgg_gem_area_funcional;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_gem_area_funcional.prototype.getColumnModel = function () {
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_gem_area_funcional.prototype.getStore = function () {
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_area_funcional desde una instancia.
 */
FrmListadoCgg_gem_area_funcional.prototype.show = function () {
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_area_funcional desde una instancia.
 */
FrmListadoCgg_gem_area_funcional.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_area_funcional,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_gem_area_funcional.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gem_area_funcional desde una instancia.
 */
FrmListadoCgg_gem_area_funcional.prototype.loadData = function () {
    this.loadData();
}