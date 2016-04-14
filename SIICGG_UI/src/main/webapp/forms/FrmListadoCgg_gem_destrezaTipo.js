/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_destreza.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */

function FrmListadoCgg_gem_destrezaTipo(in_Cgdst_tipo) {    
    var urlListadoCgg_gem_destreza = URL_WS + "Cgg_gem_destreza";
    var tituloListadoCgg_gem_destreza = 'destreza';
    var descListadoCgg_gem_destreza = 'El formulario permite administrar informaci\u00f3n de la tabla destreza';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_destrezaTipo.
     */
    var btnNuevoCgg_gem_destreza = new Ext.Button({
        id: 'btnNuevoCgg_gem_destreza',
        text: 'Nuevo',
        iconCls: 'iconNuevo',
        listeners: {
            click: function () {
                var objCgg_gem_destreza = new FrmCgg_gem_destreza("insert");
                objCgg_gem_destreza.closeHandler(function () {
                    gsCgg_gem_destreza.reload();
                });
                objCgg_gem_destreza.show();

            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_destrezaTipo.
     */
    var btnEditarCgg_gem_destreza = new Ext.Button({
        id: 'btnEditarCgg_gem_destreza',
        text: 'Editar',
        iconCls: 'iconEditar',
        listeners: {
            click: function () {
                var r = grdCgg_gem_destreza.getSelectionModel().getSelected();
                if (r) {
                    var objCgg_gem_destreza = new FrmCgg_gem_destreza("update", r);
                    objCgg_gem_destreza.closeHandler(function () {
                        gsCgg_gem_destreza.reload();
                    });
                    objCgg_gem_destreza.loadData();
                    objCgg_gem_destreza.show();
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_gem_destrezaTipo.
     */
    var btnEliminarCgg_gem_destreza = new Ext.Button({
        id: 'btnEliminarCgg_gem_destreza',
        text: 'Eliminar',
        iconCls: 'iconEliminar',
        listeners: {
            click: function () {
                Ext.Msg.show({
                    title: 'Aviso',
                    msg: '¿Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_gem_destreza,
                    icon: Ext.MessageBox.QUESTION
                });

                function SWRCgg_gem_destreza(btn) {
                    if (btn == 'yes') {
                        try {
                            function CallBackCgg_gem_destreza(r) {
                                winFrmListadoCgg_gem_destrezaTipo.getEl().unmask();
                                if (r == 'true') {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_gem_destreza,
                                        msg: 'La informaci\u00f3n de destreza ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_gem_destreza.reload();
                                } else {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_gem_destreza,
                                        msg: 'La informaci\u00f3n de destreza no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_gem_destrezaTipo.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCgdst_codigo', grdCgg_gem_destreza.getSelectionModel().getSelected().get('CGDST_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_gem_destreza, "delete", param, true, CallBackCgg_gem_destreza);
                        } catch (inErr) {
                            winFrmListadoCgg_gem_destrezaTipo.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_destrezaTipo.
     */
    var btnSalirCgg_gem_destreza = new Ext.Button({
        id: 'btnSalirCgg_gem_destreza',
        text: 'Salir',
        iconCls: 'iconSalir',
        listeners: {
            click: function () {
                winFrmListadoCgg_gem_destrezaTipo.close();
            }
        }
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_destreza.
     */
    var cmCgg_gem_destreza = new Ext.grid.ColumnModel([{
        dataIndex: 'CGDST_CODIGO',
        header: 'Codigo',
        width: 150,
        sortable: true,hidden:true
    },
    {
        dataIndex: 'CGDST_DESCRIPCION',
        header: 'Descripcion',
        width: 350,
        sortable: true
    }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_destreza por un campo especifico.
     */
    var gsCgg_gem_destreza = new Ext.data.Store({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_gem_destreza",
            method: "selectAllDirectByTipo",
            pagin: true
        }),
        remoteSort: true,
        reader: new Ext.data.JsonReader({
            id: 'CGDST_CODIGO',
            root: 'dataSet',
            totalProperty: 'totalCount'
        }, [{
            name: 'CGDST_CODIGO'
        },
        {
            name: 'CGDST_DESCRIPCION'
        }]),
        sortInfo: {
            field: 'CGDST_DESCRIPCION',
            direction: 'ASC'
        },
        baseParams: {
            keyword: "",
            format: 'JSON',
			inCgdst_tipo: in_Cgdst_tipo
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_gem_destreza.
     */
    var pgBarCgg_gem_destreza = new Ext.PagingToolbar({
        store: gsCgg_gem_destreza,
        displayInfo: true,
        pageSize: RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_destreza en un formato tabular de filas y columnas.
     */
    var grdCgg_gem_destreza = new Ext.grid.GridPanel({
        cm: cmCgg_gem_destreza,
        store: gsCgg_gem_destreza,
        region: 'center',
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true
        }),
        loadMask: {
            msg: "Cargando..."
        },
        tbar: ['Buscar: ', new Ext.ux.bsx.SearchField({
            store: gsCgg_gem_destreza,
            width: 200
        })],
        bbar: pgBarCgg_gem_destreza,
        listeners: {
            rowdblclick: function (inGridComponent, inRowIndex, inEventObject) {
                if (!btnEditarCgg_gem_destreza.disabled) {
                    btnEditarCgg_gem_destreza.fireEvent('click', btnEditarCgg_gem_destreza);
                }
            }
        }
    });
    gsCgg_gem_destreza.reload({
        params: {
            start: 0,
            limit: RECORD_PAGE,
            format: 'JSON'
        }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gem_destreza.
     */
    var winFrmListadoCgg_gem_destrezaTipo = new Ext.Window({
        id: 'winFrmListadoCgg_gem_destrezaTipo',
        title: tituloListadoCgg_gem_destreza,
        width: 600,
        minWidth: 600,
        height: 400,
        minHeight: 400,
        maximizable: true,
        minimizable: true,
        constrainHeader: true,
        layout: 'border',
        tbar: getPanelTitulo('Listado ' + tituloListadoCgg_gem_destreza, descListadoCgg_gem_destreza),
        items: [grdCgg_gem_destreza],
        bbar: [btnNuevoCgg_gem_destreza, btnEditarCgg_gem_destreza, btnEliminarCgg_gem_destreza, '->', btnSalirCgg_gem_destreza]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_gem_destrezaTipo.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_destrezaTipo.
     * @returns ventana winFrmCgg_gem_destreza.
     * @base FrmListadoCgg_gem_destrezaTipo.prototype.show
     */
    this.getWindow = function () {
        return winFrmListadoCgg_gem_destrezaTipo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gem_destrezaTipo.
     * @base FrmListadoCgg_gem_destrezaTipo.prototype.loadData
     */
    this.loadData = function () {
        gsCgg_gem_destreza.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function () {
        return cmCgg_gem_destreza;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function () {
        return gsCgg_gem_destreza;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_gem_destrezaTipo.prototype.getColumnModel = function () {
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_gem_destrezaTipo.prototype.getStore = function () {
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_destrezaTipo desde una instancia.
 */
FrmListadoCgg_gem_destrezaTipo.prototype.show = function () {
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_destrezaTipo desde una instancia.
 */
FrmListadoCgg_gem_destrezaTipo.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_destrezaTipo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_gem_destrezaTipo.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gem_destrezaTipo desde una instancia.
 */
FrmListadoCgg_gem_destrezaTipo.prototype.loadData = function () {
    this.loadData();
}