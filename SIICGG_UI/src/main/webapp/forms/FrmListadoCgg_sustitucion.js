/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_sustitucion.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */

function FrmListadoCgg_sustitucion(inDesktop) {
    var optMenu = 'Seguridad/Sustituci\u00f3n';
    var urlListadoCgg_sustitucion = URL_WS + "Cgg_sustitucion";
    var tituloListadoCgg_sustitucion = 'Sustituci\u00f3n de usuario';
    var descListadoCgg_sustitucion = 'El formulario permite administrar informaci\u00f3n de los reemplazos de los usuarios del sistema.';    
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_sustitucion.
     */
    var btnNuevoCgg_sustitucion = new Ext.Button({
        id: 'btnNuevoCgg_sustitucion',
        text: 'Nuevo',
        iconCls: 'iconNuevo',
        listeners: {
            click: function () {
                var objCgg_sustitucion = new FrmCgg_sustitucion("insert");
                objCgg_sustitucion.closeHandler(function () {
                    gsCgg_sustitucion.reload();
                });
                objCgg_sustitucion.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_sustitucion.
     */
    var btnEditarCgg_sustitucion = new Ext.Button({
        id: 'btnEditarCgg_sustitucion',
        text: 'Editar',
        iconCls: 'iconEditar',
        listeners: {
            click: function () {
                var r = grdCgg_sustitucion.getSelectionModel().getSelected();
                if (r) {
                    var objCgg_sustitucion = new FrmCgg_sustitucion("update", r);
                    objCgg_sustitucion.closeHandler(function () {
                        gsCgg_sustitucion.reload();
                    });
                    objCgg_sustitucion.loadData();
                    objCgg_sustitucion.show();
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_sustitucion.
     */
    var btnEliminarCgg_sustitucion = new Ext.Button({
        id: 'btnEliminarCgg_sustitucion',
        text: 'Eliminar',
        iconCls: 'iconEliminar',
        listeners: {
            click: function () {
                Ext.Msg.show({
                    title: 'Aviso',
                    msg: 'Seguro de eliminar el registro selecionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_sustitucion,
                    icon: Ext.MessageBox.QUESTION
                });

                function SWRCgg_sustitucion(btn) {
                    if (btn == 'yes') {
                        try {
                            function CallBackCgg_sustitucion(r) {
                                winFrmListadoCgg_sustitucion.getEl().unmask();
                                if (r == 'true') {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_sustitucion,
                                        msg: 'La informaci\u00f3n de Sustituci\u00f3n ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_sustitucion.reload();
                                } else {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_sustitucion,
                                        msg: 'La informaci\u00f3n de Sustituci\u00f3n no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_sustitucion.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCsust_codigo', grdCgg_sustitucion.getSelectionModel().getSelected().get('CSUST_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_sustitucion, "delete", param, true, CallBackCgg_sustitucion);
                        }catch (inErr) {
                            winFrmListadoCgg_sustitucion.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_sustitucion.
     */
    var btnSalirCgg_sustitucion = new Ext.Button({
        id: 'btnSalirCgg_sustitucion',
        text: 'Salir',
        iconCls: 'iconSalir',
        listeners: {
            click: function () {
                winFrmListadoCgg_sustitucion.close();
            }
        }
    });	
function rdrModalidad(inData){
    return dsModalidad[inData];
}
/**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sustitucion.
     */	

var cmCgg_sustitucion = new Ext.grid.ColumnModel([
{
    dataIndex: 'SUSTITUIDO',
    header: 'Usuario',
    width: 200,
    sortable: true
},
{
    dataIndex: 'SUSTITUTO',
    header: 'Sustituto',
    width: 200,
    sortable: true
},
{
    dataIndex:'CSUST_MODALIDAD',
    header:'Modalidad',
    width:150,
    sortable:true,
    renderer:rdrModalidad
},
{
    dataIndex:'CSUST_FECHA_INICIO',
    header:'Fecha inicio',
    width:150,
    sortable:true,
    renderer:truncDate
},
{
    dataIndex:'CSUST_FECHA_FIN',
    header:'Fecha fin',
    width:150,
    sortable:true,
    renderer:truncDate
},
{
    dataIndex: 'CSUST_ESTADO_ENCARGO',
    header: 'Vigente',
    xtype:'checkcolumn',
    width: 80,
    sortable: true
}
]);
/**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_sustitucion por un campo especifico.
     */
var gsCgg_sustitucion = new Ext.data.Store({
    proxy: new Ext.ux.bsx.SoapProxy({
        url: URL_WS + "Cgg_sustitucion",
        method: "selectPageDirect",
        pagin: true
    }),
    remoteSort: true,
    reader: new Ext.data.JsonReader({
        id: 'CSUST_CODIGO',
        root: 'dataSet',
        totalProperty: 'totalCount'
    }, [
    {
        name: 'CSUST_CODIGO'
    },

    {
        name: 'SUSTITUIDO'
    },

    {
        name: 'CUSU_CODIGO'
    },

    {
        name: 'SUSTITUTO'
    },

    {
        name: 'CGG_CUSU_CODIGO'
    },

    {
        name:'CSUST_MODALIDAD'
    },

    {
        name:'CSUST_FECHA_INICIO'
    },

    {
        name:'CSUST_FECHA_FIN'
    },

    {
        name: 'CSUST_ESTADO_ENCARGO'
    }
    ]),
    sortInfo: {
        field: 'CUSU_CODIGO',
        direction: 'ASC'
    },
    baseParams: {
        keyword: "",
        format: "JSON"
    }
});
/**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_sustitucion.
     */
var pgBarCgg_sustitucion = new Ext.PagingToolbar({
    store: gsCgg_sustitucion,
    displayInfo: true,
    pageSize: RECORD_PAGE,
    displayMsg: 'Mostrando {0} - {1} de {2}',
    temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sustitucion en un formato tabular de filas y columnas.
     */
var grdCgg_sustitucion = new Ext.grid.GridPanel({
    cm: cmCgg_sustitucion,
    store: gsCgg_sustitucion,
    region: 'center',
    sm: new Ext.grid.RowSelectionModel({
        singleSelect: true
    }),
    loadMask: {
        msg: "Cargando..."
    },
    tbar: [
    'Buscar: ', ' ',
    new Ext.ux.bsx.SearchField({
        store: gsCgg_sustitucion,
        width: 200
    })
    ],
    bbar: pgBarCgg_sustitucion,
    listeners: {
        rowdblclick: function (inGridComponent, inRowIndex, inEventObject) {
            if (!btnEditarCgg_sustitucion.disabled) {
                btnEditarCgg_sustitucion.fireEvent('click', btnEditarCgg_sustitucion);
            }
        }
    }
});
gsCgg_sustitucion.reload({
    params: {
        start: 0,
        limit: RECORD_PAGE,
        format: "JSON"
    }
});
/**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_sustitucion.
     */
var winFrmListadoCgg_sustitucion = inDesktop.createWindow({
    id: 'winFrmListadoCgg_sustitucion',
    title: tituloListadoCgg_sustitucion,
    tbar: getPanelTitulo('Listado ' + tituloListadoCgg_sustitucion, descListadoCgg_sustitucion),
    items: [grdCgg_sustitucion],
    width: 600,
    minWidth: 600,
    height: 400,
    minHeight: 400,
    maximizable: true,
    minimizable: true,
    constrain: true,
    layout: 'border',
    bbar: [btnNuevoCgg_sustitucion, btnEditarCgg_sustitucion, btnEliminarCgg_sustitucion, '->', btnSalirCgg_sustitucion]
});
/**
     * Funcion que aplica los privilegios del usuario.
     */
applyGrants(winFrmListadoCgg_sustitucion.getBottomToolbar());
/**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_sustitucion.
     * @returns ventana winFrmCgg_sustitucion.
     * @base FrmListadoCgg_sustitucion.prototype.show
     */
this.getWindow = function () {
    return winFrmListadoCgg_sustitucion;
}
/**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_sustitucion.
     * @base FrmListadoCgg_sustitucion.prototype.loadData
     */
this.loadData = function () {
    gsCgg_sustitucion.load();
}
/**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
this.getColumnModel = function () {
    return cmCgg_sustitucion;
}
/**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
this.getStore = function () {
    return gsCgg_sustitucion;
}
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_sustitucion.prototype.getColumnModel = function () {
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_sustitucion.prototype.getStore = function () {
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_sustitucion desde una instancia.
 */
FrmListadoCgg_sustitucion.prototype.show = function () {
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_sustitucion desde una instancia.
 */
FrmListadoCgg_sustitucion.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_sustitucion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_sustitucion.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_sustitucion desde una instancia.
 */
FrmListadoCgg_sustitucion.prototype.loadData = function () {
    this.loadData();
}