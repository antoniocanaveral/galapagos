/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_web_frase_bienvenida.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */

function FrmListadoCgg_web_frase_bienvenida(inDesktop) {
    var optMenu = 'Configuraci\u00F3n/Sitio Web/Administraci\u00F3n de frases de bienvenida';
    var urlListadoCgg_web_frase_bienvenida = URL_WS + "Cgg_web_frase_bienvenida";
    var tituloListadoCgg_web_frase_bienvenida = 'Frases de bienvenida';
    var descListadoCgg_web_frase_bienvenida = 'El formulario permite administrar informaci\u00f3n sofre las diferentes fraces que se van utilizar en el Sitio Web';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_web_frase_bienvenida.
     */
    var btnNuevoCgg_web_frase_bienvenida = new Ext.Button({
        id: 'btnNuevoCgg_web_frase_bienvenida',
        text: 'Nuevo',
        iconCls: 'iconNuevo',
        listeners: {
            click: function () {
                var objCgg_web_frase_bienvenida = new FrmCgg_web_frase_bienvenida("insert");
                objCgg_web_frase_bienvenida.closeHandler(function () {
                    gsCgg_web_frase_bienvenida.reload();
                });
                objCgg_web_frase_bienvenida.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_web_frase_bienvenida.
     */
    var btnEditarCgg_web_frase_bienvenida = new Ext.Button({
        id: 'btnEditarCgg_web_frase_bienvenida',
        text: 'Editar',
        iconCls: 'iconEditar',
        listeners: {
            click: function () {
                var r = grdCgg_web_frase_bienvenida.getSelectionModel().getSelected();
                if (r) {
                    var objCgg_web_frase_bienvenida = new FrmCgg_web_frase_bienvenida("update", r);
                    objCgg_web_frase_bienvenida.closeHandler(function () {
                        gsCgg_web_frase_bienvenida.reload();
                    });
                    objCgg_web_frase_bienvenida.loadData();
                    objCgg_web_frase_bienvenida.show();
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_web_frase_bienvenida.
     */
    var btnEliminarCgg_web_frase_bienvenida = new Ext.Button({
        id: 'btnEliminarCgg_web_frase_bienvenida',
        text: 'Eliminar',
        iconCls: 'iconEliminar',
        listeners: {
            click: function () {
                Ext.Msg.show({
                    title: 'Aviso',
                    msg: 'Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_web_frase_bienvenida,
                    icon: Ext.MessageBox.QUESTION
                });

                function SWRCgg_web_frase_bienvenida(btn) {
                    if (btn == 'yes') {
                        try {
                            function CallBackCgg_web_frase_bienvenida(r) {
                                winFrmListadoCgg_web_frase_bienvenida.getEl().unmask();
                                if (r == 'true') {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_web_frase_bienvenida,
                                        msg: 'La informaci\u00f3n de Web frase bienvenida ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_web_frase_bienvenida.reload();
                                } else {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_web_frase_bienvenida,
                                        msg: 'La informaci\u00f3n de Web frase bienvenida no ha podido ser eliminada.' + (r.message ? r.message : r),
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_web_frase_bienvenida.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCwfb_codigo', grdCgg_web_frase_bienvenida.getSelectionModel().getSelected().get('CWFB_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_web_frase_bienvenida, "delete", param, true, CallBackCgg_web_frase_bienvenida);
                        } catch (inErr) {
                            winFrmListadoCgg_web_frase_bienvenida.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_web_frase_bienvenida.
     */
    var btnSalirCgg_web_frase_bienvenida = new Ext.Button({
        id: 'btnSalirCgg_web_frase_bienvenida',
        text: 'Salir',
        iconCls: 'iconSalir',
        listeners: {
            click: function () {
                winFrmListadoCgg_web_frase_bienvenida.close();
            }
        }
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_web_frase_bienvenida.
     */
    var chkCwfb_hibilitado = new Ext.grid.CheckColumn({
        dataIndex: 'CWFB_HIBILITADO',
        header: 'Hibilitado',
        width: 75,
        sortable: true
    });
    var cmCgg_web_frase_bienvenida = new Ext.grid.ColumnModel([
    {
        dataIndex: 'CWFB_CONTENIDO',
        header: 'Contenido',
        width: 500,
        sortable: true
    },
    chkCwfb_hibilitado]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_web_frase_bienvenida por un campo especifico.
     */
    var gsCgg_web_frase_bienvenida = new Ext.data.Store({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_web_frase_bienvenida",
            method: "selectPageDirect"         
        }),
        remoteSort: true,
        reader: new Ext.data.JsonReader({
            id: 'CWFB_CODIGO',
            root: 'dataSet',
            totalProperty: 'totalCount'
        }, [{
            name: 'CWFB_CODIGO'
        },
        {
            name: 'CWFB_CONTENIDO'
        },
        {
            name: 'CWFB_HIBILITADO'
        }]),
        sortInfo: {
            field: 'CWFB_CONTENIDO',
            direction: 'ASC'
        },
        baseParams: {
            keyword: "",
            format: 'JSON'
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_web_frase_bienvenida.
     */
    var pgBarCgg_web_frase_bienvenida = new Ext.PagingToolbar({
        store: gsCgg_web_frase_bienvenida,
        displayInfo: true,
        pageSize: RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_web_frase_bienvenida en un formato tabular de filas y columnas.
     */
    var grdCgg_web_frase_bienvenida = new Ext.grid.GridPanel({
        cm: cmCgg_web_frase_bienvenida,
        store: gsCgg_web_frase_bienvenida,
        region: 'center',
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true
        }),
        loadMask: {
            msg: "Cargando..."
        },
        tbar: ['Buscar: ', new Ext.ux.bsx.SearchField({
            store: gsCgg_web_frase_bienvenida,
            width: 200
        })],
        bbar: pgBarCgg_web_frase_bienvenida,
        listeners: {
            rowdblclick: function (inGridComponent, inRowIndex, inEventObject) {
                if (!btnEditarCgg_web_frase_bienvenida.disabled) {
                    btnEditarCgg_web_frase_bienvenida.fireEvent('click', btnEditarCgg_web_frase_bienvenida);
                }
            }
        }
    });
    gsCgg_web_frase_bienvenida.reload({
        params: {
            start: 0,
            limit: RECORD_PAGE,
            format: 'JSON'
        }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_web_frase_bienvenida.
     */
	 if (inDesktop)
    var winFrmListadoCgg_web_frase_bienvenida = inDesktop.createWindow({
        id: 'winFrmListadoCgg_web_frase_bienvenida',
        title: tituloListadoCgg_web_frase_bienvenida,
        iconCls: 'iconAplicacion',
        width: 700,
        minWidth: 600,
        height: 400,
        minHeight: 400,
        maximizable: true,
        minimizable: true,
        constrain: true,
        layout: 'border',
        tbar: getPanelTitulo('Listado ' + tituloListadoCgg_web_frase_bienvenida, descListadoCgg_web_frase_bienvenida),
        items: [grdCgg_web_frase_bienvenida],
        bbar: [btnNuevoCgg_web_frase_bienvenida, btnEditarCgg_web_frase_bienvenida, btnEliminarCgg_web_frase_bienvenida, '->', btnSalirCgg_web_frase_bienvenida]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_web_frase_bienvenida.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_web_frase_bienvenida.
     * @returns ventana winFrmCgg_web_frase_bienvenida.
     * @base FrmListadoCgg_web_frase_bienvenida.prototype.show
     */
    this.getWindow = function () {
        return winFrmListadoCgg_web_frase_bienvenida;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_web_frase_bienvenida.
     * @base FrmListadoCgg_web_frase_bienvenida.prototype.loadData
     */
    this.loadData = function () {
        gsCgg_web_frase_bienvenida.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function () {
        return cmCgg_web_frase_bienvenida;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function () {
        return gsCgg_web_frase_bienvenida;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_web_frase_bienvenida.prototype.getColumnModel = function () {
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_web_frase_bienvenida.prototype.getStore = function () {
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_web_frase_bienvenida desde una instancia.
 */
FrmListadoCgg_web_frase_bienvenida.prototype.show = function () {
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_web_frase_bienvenida desde una instancia.
 */
FrmListadoCgg_web_frase_bienvenida.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_web_frase_bienvenida,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_web_frase_bienvenida.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_web_frase_bienvenida desde una instancia.
 */
FrmListadoCgg_web_frase_bienvenida.prototype.loadData = function () {
    this.loadData();
}