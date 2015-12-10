/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_cargo.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */

function FrmListadoCgg_gem_cargo(inDesktop) {
    var optMenu = 'Gesti\u00F3n de Empleo/Configuraci\u00f3n/Cargos';
    var urlListadoCgg_gem_cargo = URL_WS + "Cgg_gem_cargo";
    var tituloListadoCgg_gem_cargo = 'Listado de cargos';
    var descListadoCgg_gem_cargo = 'El formulario permite listar la informaci\u00f3n de los cargos existentes.';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_cargo.
     */
    var btnNuevoCgg_gem_cargo = new Ext.Button({
        id: 'btnNuevoCgg_gem_cargo',
        text: 'Nuevo',
        iconCls: 'iconNuevo',
        listeners: {
            click: function () {
                var objCgg_gem_cargo = new FrmCgg_gem_cargo("insert");
                objCgg_gem_cargo.closeHandler(function () {
                    gsCgg_gem_cargo.reload();
                });
                objCgg_gem_cargo.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_cargo.
     */
    var btnEditarCgg_gem_cargo = new Ext.Button({
        id: 'btnEditarCgg_gem_cargo',
        text: 'Editar',
        iconCls: 'iconEditar',
        listeners: {
            click: function () {
                var r = grdCgg_gem_cargo.getSelectionModel().getSelected();
                if (r) {
                    var objCgg_gem_cargo = new FrmCgg_gem_cargo("update", r);
                    objCgg_gem_cargo.closeHandler(function () {
                        gsCgg_gem_cargo.reload();
                    });
                    objCgg_gem_cargo.loadData();
                    objCgg_gem_cargo.show();
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_gem_cargo.
     */
    var btnEliminarCgg_gem_cargo = new Ext.Button({
        id: 'btnEliminarCgg_gem_cargo',
        text: 'Eliminar',
        iconCls: 'iconEliminar',
        listeners: {
            click: function () {
                Ext.Msg.show({
                    title: 'Aviso',
                    msg: 'Est\u00e1 seguro de eliminar?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_gem_cargo,
                    icon: Ext.MessageBox.QUESTION
                });

                function SWRCgg_gem_cargo(btn) {
                    if (btn == 'yes') {
                        try {
                            function CallBackCgg_gem_cargo(r) {
                                winFrmListadoCgg_gem_cargo.getEl().unmask();
                                if (r == 'true') {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_gem_cargo,
                                        msg: 'La informaci\u00f3n sobre el cargo ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_gem_cargo.reload();
                                } else {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_gem_cargo,
                                        msg: 'La informaci\u00f3n del cargo no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_gem_cargo.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCgcrg_codigo', grdCgg_gem_cargo.getSelectionModel().getSelected().get('CGCRG_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_gem_cargo, "delete", param, true, CallBackCgg_gem_cargo);
                        } catch (inErr) {
                            winFrmListadoCgg_gem_cargo.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_cargo.
     */
    var btnSalirCgg_gem_cargo = new Ext.Button({
        id: 'btnSalirCgg_gem_cargo',
        text: 'Salir',
        iconCls: 'iconSalir',
        listeners: {
            click: function () {
                winFrmListadoCgg_gem_cargo.close();
            }
        }
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_cargo.
     */
    var cmCgg_gem_cargo = new Ext.grid.ColumnModel([
    {
        dataIndex:'CGARE_NOMBRE',
        header:'Area',
        width:200,
        sortable:true,
        hidden:false
    },

    {
        dataIndex:'CGCRG_NOMBRE',
        header:'Nombre',
        width:200,
        sortable:true
    },

    {
        dataIndex:'CGCRG_DESCRIPCION',
        header:'Descripci\u00F3n',
        width:200,
        sortable:true
    }
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_cargo por un campo especifico.
     */
    var gsCgg_gem_cargo = new Ext.data.GroupingStore({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_gem_cargo",
            method: "selectPageDirect",
            pagin: true
        }),
        groupField:'CGARE_NOMBRE',
        remoteSort: true,
        reader: new Ext.data.JsonReader({
            id: 'CGCRG_CODIGO',
            root: 'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name: 'CGCRG_CODIGO'
        },

        {
            name: 'CGARE_CODIGO'
        },

        {
            name: 'CGARE_NOMBRE'
        },

        {
            name: 'CGCRG_NOMBRE'
        },

        {
            name: 'CGCRG_DESCRIPCION'
        }
        ]),
        sortInfo: {
            field: 'CGARE_NOMBRE',
            direction: 'ASC'
        },
        baseParams: {
            keyword: "",
            format: "JSON"
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_gem_cargo.
     */
    var pgBarCgg_gem_cargo = new Ext.PagingToolbar({
        store: gsCgg_gem_cargo,
        displayInfo: true,
        pageSize: RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_cargo en un formato tabular de filas y columnas.
     */
    var grdCgg_gem_cargo = new Ext.grid.GridPanel({
        cm: cmCgg_gem_cargo,
        store: gsCgg_gem_cargo,
        region: 'center',
        view: new Ext.grid.GroupingView({
            forceFit:true,
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true
        }),
        loadMask: {
            msg: "Cargando..."
        },
        tbar: ['Buscar: ', ' ', new Ext.ux.bsx.SearchField({
            store: gsCgg_gem_cargo,
            width: 200
        })],
        bbar: pgBarCgg_gem_cargo,
        listeners: {
            rowdblclick: function (inGridComponent, inRowIndex, inEventObject) {
                if (!btnEditarCgg_gem_cargo.disabled) {
                    btnEditarCgg_gem_cargo.fireEvent('click', btnEditarCgg_gem_cargo);
                }
            }
        }
    });
    gsCgg_gem_cargo.reload({
        params: {
            start: 0,
            limit: RECORD_PAGE,
            format: "JSON"
        }
    });
    
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gem_cargo.
     */
    var winFrmListadoCgg_gem_cargo = null;

    if(inDesktop){
        winFrmListadoCgg_gem_cargo = new inDesktop.createWindow({
            id: 'winFrmListadoCgg_gem_cargo',
            title: tituloListadoCgg_gem_cargo,
            tbar: getPanelTitulo(tituloListadoCgg_gem_cargo, descListadoCgg_gem_cargo),
            items: [grdCgg_gem_cargo],
            width: 600,
            minWidth: 600,
            height: 400,
            minHeight: 400,
            maximizable: true,
            minimizable: true,
            constrainHeader: true,
            layout: 'border',
            bbar: [btnNuevoCgg_gem_cargo, btnEditarCgg_gem_cargo, btnEliminarCgg_gem_cargo, '->', btnSalirCgg_gem_cargo]
        });
		applyGrants(winFrmListadoCgg_gem_cargo.getBottomToolbar());
    }
     
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_cargo.
     * @returns ventana winFrmCgg_gem_cargo.
     * @base FrmListadoCgg_gem_cargo.prototype.show
     */
    this.getWindow = function () {
        return winFrmListadoCgg_gem_cargo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gem_cargo.
     * @base FrmListadoCgg_gem_cargo.prototype.loadData
     */
    this.loadData = function () {
        gsCgg_gem_cargo.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function () {
        return cmCgg_gem_cargo;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function () {
        return gsCgg_gem_cargo;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_gem_cargo.prototype.getColumnModel = function () {
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_gem_cargo.prototype.getStore = function () {
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_cargo desde una instancia.
 */
FrmListadoCgg_gem_cargo.prototype.show = function () {
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_cargo desde una instancia.
 */
FrmListadoCgg_gem_cargo.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_cargo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_gem_cargo.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gem_cargo desde una instancia.
 */
FrmListadoCgg_gem_cargo.prototype.loadData = function () {
    this.loadData();
}
