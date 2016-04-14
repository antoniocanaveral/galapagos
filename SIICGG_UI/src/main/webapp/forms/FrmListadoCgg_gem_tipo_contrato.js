/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_tipo_contrato.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */

function FrmListadoCgg_gem_tipo_contrato(inDesktop) {
    var optMenu = 'Gesti\u00F3n de Empleo/Configuraci\u00f3n/Tipo de contrato';
    var urlListadoCgg_gem_tipo_contrato = URL_WS + "Cgg_gem_tipo_contrato";
    var tituloListadoCgg_gem_tipo_contrato = 'Tipo de contratos';
    var descListadoCgg_gem_tipo_contrato = 'El formulario muestra los tipos de contratos existentes.';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_tipo_contrato.
     */
    var btnNuevoCgg_gem_tipo_contrato = new Ext.Button({
        id: 'btnNuevoCgg_gem_tipo_contrato',
        text: 'Nuevo',
        iconCls: 'iconNuevo',
        listeners: {
            click: function () {
                var objCgg_gem_tipo_contrato = new FrmCgg_gem_tipo_contrato("insert");
                objCgg_gem_tipo_contrato.closeHandler(function () {
                    gsCgg_gem_tipo_contrato.reload();
                });
                objCgg_gem_tipo_contrato.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_tipo_contrato.
     */
    var btnEditarCgg_gem_tipo_contrato = new Ext.Button({
        id: 'btnEditarCgg_gem_tipo_contrato',
        text: 'Editar',
        iconCls: 'iconEditar',
        listeners: {
            click: function () {
                var r = grdCgg_gem_tipo_contrato.getSelectionModel().getSelected();
                if (r) {
                    var objCgg_gem_tipo_contrato = new FrmCgg_gem_tipo_contrato("update", r);
                    objCgg_gem_tipo_contrato.closeHandler(function () {
                        gsCgg_gem_tipo_contrato.reload();
                    });
                    objCgg_gem_tipo_contrato.loadData();
                    objCgg_gem_tipo_contrato.show();
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_gem_tipo_contrato.
     */
    var btnEliminarCgg_gem_tipo_contrato = new Ext.Button({
        id: 'btnEliminarCgg_gem_tipo_contrato',
        text: 'Eliminar',
        iconCls: 'iconEliminar',
        listeners: {
            click: function () {
				var r = grdCgg_gem_tipo_contrato.getSelectionModel().getSelected();
                if (!r) return;
                Ext.Msg.show({
                    title: 'Aviso',
                    msg: '\u00BFSeguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_gem_tipo_contrato,
                    icon: Ext.MessageBox.QUESTION
                });

                function SWRCgg_gem_tipo_contrato(btn) {
                    if (btn == 'yes') {
                        try {
                            function CallBackCgg_gem_tipo_contrato(r) {
                                winFrmListadoCgg_gem_tipo_contrato.getEl().unmask();
                                if (r == 'true') {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_gem_tipo_contrato,
                                        msg: 'La informaci\u00f3n sobre el tipo de contrato ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_gem_tipo_contrato.reload();
                                } else {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_gem_tipo_contrato,
                                        msg: 'La informaci\u00f3n sobre el tipo de contrato no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_gem_tipo_contrato.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCgtcn_codigo', grdCgg_gem_tipo_contrato.getSelectionModel().getSelected().get('CGTCN_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_gem_tipo_contrato, "delete", param, true, CallBackCgg_gem_tipo_contrato);
                        } catch (inErr) {
                            winFrmListadoCgg_gem_tipo_contrato.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_tipo_contrato.
     */
    var btnSalirCgg_gem_tipo_contrato = new Ext.Button({
        id: 'btnSalirCgg_gem_tipo_contrato',
        text: 'Salir',
        iconCls: 'iconSalir',
        listeners: {
            click: function () {
                winFrmListadoCgg_gem_tipo_contrato.close();
            }
        }
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_tipo_contrato.
     */
    var cmCgg_gem_tipo_contrato = new Ext.grid.ColumnModel([
    {
        dataIndex: 'CGTCN_DESCRIPCION',
        header: 'Nombre',
        width: 150,
        sortable: true
    },
    {
        dataIndex: 'CGTCN_OBSERVACION',
        header: 'Observaci\u00f3nn',
        width: 340,
        sortable: true
    }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_tipo_contrato por un campo especifico.
     */
    var gsCgg_gem_tipo_contrato = new Ext.data.Store({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_gem_tipo_contrato",
            method: "selectPage",
            pagin: true
        }),
        remoteSort: true,
        reader: new Ext.data.JsonReader({
            id: 'CGTCN_CODIGO',
            root: 'dataSet',
            totalProperty: 'totalCount'
        }, [{
            name: 'CGTCN_CODIGO'
        },
        {
            name: 'CGTCN_DESCRIPCION'
        },
        {
            name: 'CGTCN_OBSERVACION'
        }]),
        sortInfo: {
            field: 'CGTCN_DESCRIPCION',
            direction: 'ASC'
        },
        baseParams: {
            keyword: "",
            format: 'JSON'
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_gem_tipo_contrato.
     */
    var pgBarCgg_gem_tipo_contrato = new Ext.PagingToolbar({
        store: gsCgg_gem_tipo_contrato,
        displayInfo: true,
        pageSize: RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_tipo_contrato en un formato tabular de filas y columnas.
     */
    var grdCgg_gem_tipo_contrato = new Ext.grid.GridPanel({
        cm: cmCgg_gem_tipo_contrato,
        store: gsCgg_gem_tipo_contrato,
        region: 'center',
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true
        }),
        loadMask: {
            msg: "Cargando..."
        },
        tbar: ['Buscar: ', new Ext.ux.bsx.SearchField({
            store: gsCgg_gem_tipo_contrato,
            width: 200
        })],
        bbar: pgBarCgg_gem_tipo_contrato,
        listeners: {
            rowdblclick: function (inGridComponent, inRowIndex, inEventObject) {
                if (!btnEditarCgg_gem_tipo_contrato.disabled) {
                    btnEditarCgg_gem_tipo_contrato.fireEvent('click', btnEditarCgg_gem_tipo_contrato);
                }
            }
        }
    });
    gsCgg_gem_tipo_contrato.reload({
        params: {
            start: 0,
            limit: RECORD_PAGE,
            format: 'JSON'
        }
    });
    
	if (inDesktop){
		/**
		 * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gem_tipo_contrato.
		 */
		var winFrmListadoCgg_gem_tipo_contrato = inDesktop.createWindow({
			id: 'winFrmListadoCgg_gem_tipo_contrato',
			title: tituloListadoCgg_gem_tipo_contrato,
			width: 520,
			minWidth: 350,
			height: 325,
			minHeight: 300,
			maximizable: true,
			minimizable: true,
			constrainHeader: true,
			layout: 'border',
			tbar: getPanelTitulo('Listado ' + tituloListadoCgg_gem_tipo_contrato, descListadoCgg_gem_tipo_contrato),
			items: [grdCgg_gem_tipo_contrato],
			bbar: [btnNuevoCgg_gem_tipo_contrato, btnEditarCgg_gem_tipo_contrato, btnEliminarCgg_gem_tipo_contrato, '->', btnSalirCgg_gem_tipo_contrato]
		});
		/**
		 * Funcion que aplica los privilegios del usuario.
		 */
		applyGrants(winFrmListadoCgg_gem_tipo_contrato.getBottomToolbar());
	}
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_tipo_contrato.
     * @returns ventana winFrmCgg_gem_tipo_contrato.
     * @base FrmListadoCgg_gem_tipo_contrato.prototype.show
     */
    this.getWindow = function () {
        return winFrmListadoCgg_gem_tipo_contrato;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gem_tipo_contrato.
     * @base FrmListadoCgg_gem_tipo_contrato.prototype.loadData
     */
    this.loadData = function () {
        gsCgg_gem_tipo_contrato.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function () {
        return cmCgg_gem_tipo_contrato;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function () {
        return gsCgg_gem_tipo_contrato;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_gem_tipo_contrato.prototype.getColumnModel = function () {
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_gem_tipo_contrato.prototype.getStore = function () {
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_tipo_contrato desde una instancia.
 */
FrmListadoCgg_gem_tipo_contrato.prototype.show = function () {
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_tipo_contrato desde una instancia.
 */
FrmListadoCgg_gem_tipo_contrato.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_tipo_contrato,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_gem_tipo_contrato.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gem_tipo_contrato desde una instancia.
 */
FrmListadoCgg_gem_tipo_contrato.prototype.loadData = function () {
    this.loadData();
}