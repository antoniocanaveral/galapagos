/**
 * Created by acanaveral on 8/8/16.
 * Permite Administrar los documentos de Alfresco
 */
var tipoArchivo = [['SIST','Documentos de Sistema'],['GENE','Documentos Generales'],['NORM','Documentos Normativos'],['PERS','Documentos Personales']];


function FrmListadoCgg_ecm_archivo() {
    var optMenu = 'Administraci\u00f3n de Archivos';
    var urlListadoCgg_ecm_archivo = URL_WS + "Cgg_ecm_archivo";
    var tituloListadoCgg_ecm_archivo = 'Administraci\u00f3n de Archivos';
    var descListadoCgg_ecm_archivo = 'El formulario permite administrar documentos del repositorio (Alfresco).';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_ecm_archivo.
     */
    var btnNuevoCgg_ecm_archivo = new Ext.Button({
        id: 'btnNuevoCgg_ecm_archivo',
        text: 'Nuevo',
        iconCls: 'iconNuevo',
        listeners: {
            click: function () {
                var objCgg_ecm_archivo = new FrmCgg_ecm_archivo("insert");
                objCgg_ecm_archivo.closeHandler(function () {
                    gsCgg_ecm_archivo.reload();
                });
                objCgg_ecm_archivo.show();
            }
        }
    });

    /**

     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_ecm_archivo.

     */

    var btnEditarCgg_ecm_archivo = new Ext.Button({
        id: 'btnEditarCgg_ecm_archivo',
        text: 'Editar',
        iconCls: 'iconEditar',
        listeners: {
            click: function () {
                var r = grdCgg_ecm_archivo.getSelectionModel().getSelected();
                if (r) {
                    var objCgg_ecm_archivo = new FrmCgg_ecm_archivo("update", r);
                    objCgg_ecm_archivo.closeHandler(function () {
                        gsCgg_ecm_archivo.reload();
                    });
                    objCgg_ecm_archivo.loadData();
                    objCgg_ecm_archivo.show();
                }
            }
        }
    });

    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_ecm_archivo.
     */
    var btnEliminarCgg_ecm_archivo = new Ext.Button({
        id: 'btnEliminarCgg_ecm_archivo',
        text: 'Eliminar',
        iconCls: 'iconEliminar',
        listeners: {
            click: function () {
                Ext.Msg.show({
                    title: 'Aviso',
                    msg: 'Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_ecm_archivo,
                    icon: Ext.MessageBox.QUESTION
                });

                function SWRCgg_ecm_archivo(btn) {
                    if (btn == 'yes') {
                        try {
                            function CallBackCgg_ecm_archivo(r) {
                                winFrmListadoCgg_ecm_archivo.getEl().unmask();
                                if (r == 'true') {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_ecm_archivo,
                                        msg: 'La informaci\u00f3n del archivo ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_ecm_archivo.reload();
                                } else {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_ecm_archivo,
                                        msg: 'La informaci\u00f3n del archivo no ha podido ser eliminada.'+(r.message?r.message:r),
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_ecm_archivo.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inEcmch_codigo', grdCgg_ecm_archivo.getSelectionModel().getSelected().get('ECMCH_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_ecm_archivo, "delete", param, true, CallBackCgg_ecm_archivo);
                        } catch (inErr) {
                            winFrmListadoCgg_ecm_archivo.getEl().unmask();
                        }
                    }
                }
            }
        }
    });

    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_ecm_archivo.
     */

    var btnSalirCgg_ecm_archivo = new Ext.Button({
        id: 'btnSalirCgg_ecm_archivo',
        text: 'Salir',
        iconCls: 'iconSalir',
        listeners: {
            click: function () {
                winFrmListadoCgg_ecm_archivo.close();
            }
        }
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto Cgg_ecm_archivo.
     */

    var cmCgg_ecm_archivo = new Ext.grid.ColumnModel([
        {   dataIndex: 'ECMCH_TIPO',
            header: 'Tipo',
            width: 150,
            sortable: true,
            renderer:function(inNtml_codigo){
                var i =0;
                var result = inNtml_codigo;
                for(i=0;i<tipoArchivo.length;i++){
                    if(tipoArchivo[i][0] == inNtml_codigo){
                        result = tipoArchivo[i][1];
                        break;
                    }
                }
                return result;
            }
        },{
            dataIndex: 'ECMCH_ASUNTO',
            header: 'Asunto',
            width: 150,
            sortable: true
        },{
            dataIndex: 'ECMCH_FECHA',
            header: 'Fecha',
            width: 150,
            sortable: true
        },{
            dataIndex: 'ECMCH_DESCRIPCION',
            header: 'Descripci\u00f3n',
            width: 200,
            sortable: true
        },{
            dataIndex: 'ECMCH_UPDATEABLE',
            header: 'Editable',
            width: 100,
            sortable: false,
            xtype:'checkcolumn',
            editor:{
                xtype: 'checkbox'
            }
        },{
            dataIndex: 'ECMCH_USUARIO_INSERT',
            header: 'Usuario',
            width: 150,
            sortable: true
        }]);

    /**

     * Ext.data.Store Agrupacion de registros de la tabla Cgg_ecm_archivo por un campo especifico.

     */

    var gsCgg_ecm_archivo = new Ext.data.Store({

        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_ecm_archivo",
            method: "selectPage",
            pagin: true
        }),
        remoteSort: true,
        reader: new Ext.data.JsonReader({
            id: 'ECMCH_CODIGO',
            root: 'dataSet',
            totalProperty: 'totalCount'
        }, [
            {name: 'ECMCH_CODIGO'},
            {name: 'ECMCH_TIPO'},
            {name: 'ECMCH_ASUNTO'},
            {name: 'ECMCH_FECHA'},
            {name: 'ECMCH_DESCRIPCION'},
            {name: 'ECMCH_UPDATEABLE'},
            {name: 'ECMCH_USUARIO_INSERT'}
        ]),
        sortInfo: {
            field: 'ECMCH_TIPO',
            direction: 'ASC'
        },
        baseParams: {
            keyword: "",
            format: 'JSON'
        }
    });

    /**

     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_ecm_archivo.

     */

    var pgBarCgg_ecm_archivo = new Ext.PagingToolbar({
        store: gsCgg_ecm_archivo,
        displayInfo: true,
        pageSize: RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });

    /**

     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_ecm_archivo en un formato tabular de filas y columnas.

     */

    var grdCgg_ecm_archivo = new Ext.grid.GridPanel({
        cm: cmCgg_ecm_archivo,
        store: gsCgg_ecm_archivo,
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
                store: gsCgg_ecm_archivo,
                width: 200
            })
        ],
        bbar: pgBarCgg_ecm_archivo,
        listeners: {
            rowdblclick: function (inGridComponent, inRowIndex, inEventObject) {
                if (!btnEditarCgg_ecm_archivo.disabled) {
                    btnEditarCgg_ecm_archivo.fireEvent('click', btnEditarCgg_ecm_archivo);
                }
            }
        }
    });

    gsCgg_ecm_archivo.reload({
        params: {
            start: 0,
            limit: RECORD_PAGE,
            format: 'JSON'
        }
    });

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_ecm_archivo.
     */

    var winFrmListadoCgg_ecm_archivo = new Ext.Window({
        id: 'winFrmListadoCgg_ecm_archivo',
        title: tituloListadoCgg_ecm_archivo,
        width: 800,
        minWidth: 600,
        height: 400,
        minHeight: 400,
        maximizable: true,
        minimizable: true,
        constrain: true,
        layout: 'border',
        tbar: getPanelTitulo(tituloListadoCgg_ecm_archivo, descListadoCgg_ecm_archivo),
        items: [grdCgg_ecm_archivo],
        bbar: [btnNuevoCgg_ecm_archivo, btnEditarCgg_ecm_archivo, btnEliminarCgg_ecm_archivo, '->', btnSalirCgg_ecm_archivo]
    });

    /**
     * Funcion que aplica los privilegios del usuario.
     */

    applyGrants(winFrmListadoCgg_ecm_archivo.getBottomToolbar());

    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_ecm_archivo.
     * @returns ventana winFrmCgg_ecm_archivo.
     * @base FrmListadoCgg_ecm_archivo.prototype.show
     */

    this.getWindow = function () {
        return winFrmListadoCgg_ecm_archivo;
    };

    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_ecm_archivo.
     * @base FrmListadoCgg_ecm_archivo.prototype.loadData
     */

    this.loadData = function () {
        gsCgg_ecm_archivo.load();
    };

    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */

    this.getColumnModel = function () {
        return cmCgg_ecm_archivo;
    };

    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function () {
        return gsCgg_ecm_archivo;
    };

}

/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */

FrmListadoCgg_ecm_archivo.prototype.getColumnModel = function () {
    this.getColumnModel();
};

/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */

FrmListadoCgg_ecm_archivo.prototype.getStore = function () {
    this.getStore();
};

/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_ecm_archivo desde una instancia.
 */

FrmListadoCgg_ecm_archivo.prototype.show = function () {
    this.getWindow().show();
};

/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_ecm_archivo desde una instancia.
 */

FrmListadoCgg_ecm_archivo.prototype.close = function () {
    this.getWindow().close();
};

/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_ecm_archivo,
 * con el fin de realizar otras acciones desde una instancia.
 */

FrmListadoCgg_ecm_archivo.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
};

/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_ecm_archivo desde una instancia.
 */

FrmListadoCgg_ecm_archivo.prototype.loadData = function () {
    this.loadData();
};
