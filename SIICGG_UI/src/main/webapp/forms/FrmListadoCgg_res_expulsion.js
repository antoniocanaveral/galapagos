/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_expulsion.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_expulsion(inDesktop){
    var optMenu = 'Movilidad/Expulsion';
    var urlListadoCgg_res_expulsion=URL_WS+"Cgg_res_expulsion";
    var tituloListadoCgg_res_expulsion='Salida Especial de la provincia';
    var descListadoCgg_res_expulsion='El formulario permite administrar informaci\u00f3n sobre la Salida especial de la Provincia';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_expulsion.
     */
    var btnNuevoCgg_res_expulsion = new Ext.Button({
        id:'btnNuevoCgg_res_expulsion',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_expulsion = new FrmCgg_res_expulsion("insert");
                objCgg_res_expulsion.closeHandler(function(){
                    gsCgg_res_expulsion.reload();
                });
                objCgg_res_expulsion.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_expulsion.
     */
    var btnEditarCgg_res_expulsion = new Ext.Button({
        id:'btnEditarCgg_res_expulsion',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_expulsion.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_expulsion = new FrmCgg_res_expulsion("update",r);
                    objCgg_res_expulsion.closeHandler(function(){
                        gsCgg_res_expulsion.reload();
                    });
                    objCgg_res_expulsion.show();
                    objCgg_res_expulsion.loadData(grdCgg_res_expulsion.getSelectionModel().getSelected());

                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_expulsion.
     */
    var btnEliminarCgg_res_expulsion = new Ext.Button({
        id:'btnEliminarCgg_res_expulsion',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({
                    title:'Aviso', 
                    msg:'¿Seguro de eliminar el registro seleccionado?', 
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_res_expulsion,
                    icon: Ext.MessageBox.QUESTION
                });
                function SWRCgg_res_expulsion(btn){
                    if (btn=='yes'){
                        try{
                            function CallBackCgg_res_expulsion(r){
                                winFrmListadoCgg_res_expulsion.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_res_expulsion,
                                        msg: 'La informaci\u00f3n de la Salida Especial ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_res_expulsion.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_res_expulsion,
                                        msg: 'La informaci\u00f3n de la Salida Especial no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_res_expulsion.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCrexp_codigo',grdCgg_res_expulsion.getSelectionModel().getSelected().get('CREXP_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_res_expulsion,"delete",param, true, CallBackCgg_res_expulsion);
                        }catch(inErr){
                            winFrmListadoCgg_res_expulsion.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_expulsion.
     */
    var btnSalirCgg_res_expulsion = new Ext.Button({
        id:'btnSalirCgg_res_expulsion',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_expulsion.close();
            }
        }
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_expulsion.
     */
    var cmCgg_res_expulsion = new Ext.grid.ColumnModel([
    {
        dataIndex:'DOCUMENTO',
        header:'Tipo Documento',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRPER_NUM_DOC_IDENTIFIC',
        header:'Numero Documento',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRPER_NOMBRES',
        header:'Nombres',
        width:150,
        sortable:true
    },
    {
        dataIndex:'APELLIDOS',
        header:'Apellidos',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRPER_GENERO',
        header:'Genero',
        width:150,
        sortable:true,
        renderer:function(inCrper_genero){
            return dsGeneroPersona[inCrper_genero][1];
        }
    },
    {
        dataIndex:'CRPER_FECHA_NACIMIENTO',
        header:'Fecha Nacimiento',
        width:150,
        sortable:true,
        renderer:truncDate
    },
    {
        dataIndex:'CRNOT_NUMERO_NOTIFICACION',
        header:'Numero Notificacion',
        width:150,
        sortable:true
    },
    {
        dataIndex:'FECHA',
        header:'Fecha Notificacion',
        width:150,
        sortable:true,
        renderer:truncDate
    },
    {
        dataIndex:'CGG_CARPT_CODIGO',
        header:'Carpt codigo',
        width:150,
        sortable:true,
        hidden: true
    },
    {
        dataIndex:'AEROPUERTO',
        header:'Aeropuerto Destino',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRMOV_NUMERO_VUELO',
        header:'Numero Vuelo',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CROSG_CODIGO',
        header:'Carpt codigo',
        width:150,
        sortable:true,
        hidden: true
    },
    {
        dataIndex:'OFICIAL_SEGUIMIENTO',
        header:'Oficial',
        width:150,
        sortable:true
    },
    {
        dataIndex:'TESTIGO',
        header:'Testigo',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CTFSL_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden: true
    },
    {
        dataIndex:'FORMA_SALIDA',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden: true
    },
    {
        dataIndex:'CREXP_FECHA_EXPULSION',
        header:'Fecha viaje',
        width:150,
        sortable:true,
        renderer:truncDate
    },
    {
        dataIndex:'CREXP_TIPO_PAGO',
        header:'Tipo pago',
        width:150,
        sortable:true,
        renderer:function(inCrexp_tipo_pago){
            return dsTipoPagoSalida[inCrexp_tipo_pago][1];
        }
    },
    {
        dataIndex:'CREXP_VALOR_VUELO',
        header:'Valor vuelo',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CREXP_OBSERVACION',
        header:'Observacion',
        width:150,
        sortable:true
    }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_expulsion por un campo especifico.
     */
    var gsCgg_res_expulsion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_expulsion",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CREXP_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CREXP_CODIGO'
        },

        {
            name:'CRMOV_CODIGO'
        },

        {
            name:'CRNOT_CODIGO'
        },

        {
            name:'CRNOT_NUMERO_NOTIFICACION'
        },

        {
            name:'FECHA'
        },

        {
            name:'CRPER_CODIGO'
        },

        {
            name:'CRDID_CODIGO'
        },

        {
            name:'DOCUMENTO'
        },

        {
            name:'CRPER_NUM_DOC_IDENTIFIC'
        },

        {
            name:'CPRR_CODIGO'
        },

        {
            name:'PARROQUIA'
        },

        {
            name:'CCTN_CODIGO'
        },

        {
            name:'CANTON'
        },

        {
            name:'CRPER_NOMBRES'
        },

        {
            name:'APELLIDOS'
        },

        {
            name:'CRPER_GENERO'
        },

        {
            name:'CRPER_FECHA_NACIMIENTO'
        },

        {
            name:'CGG_CARPT_CODIGO'
        },

        {
            name:'AEROPUERTO'
        },

        {
            name:'CRMOV_NUMERO_VUELO'
        },

        {
            name:'CROSG_CODIGO'
        },

        {
            name:'OFICIAL_SEGUIMIENTO'
        },

        {
            name:'TESTIGO'
        },

        {
            name:'CTFSL_CODIGO'
        },

        {
            name:'FORMA_SALIDA'
        },

        {
            name:'CREXP_FECHA_EXPULSION'
        },

        {
            name:'CREXP_TIPO_PAGO'
        },

        {
            name:'CREXP_VALOR_VUELO'
        },

        {
            name:'CREXP_OBSERVACION'
        }

        ]),
        sortInfo:{
            field: 'CRMOV_CODIGO', 
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:'JSON'
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_expulsion.
     */
    var pgBarCgg_res_expulsion= new Ext.PagingToolbar({
        store: gsCgg_res_expulsion,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_expulsion en un formato tabular de filas y columnas.
     */
    var grdCgg_res_expulsion = new Ext.grid.GridPanel({
        cm:cmCgg_res_expulsion,
        store:gsCgg_res_expulsion,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        tbar: [
        'Buscar: ',
        new Ext.ux.bsx.SearchField({
            store:gsCgg_res_expulsion,
            width:200
        })
        ],
        bbar:pgBarCgg_res_expulsion,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_expulsion.hidden){
                    btnEditarCgg_res_expulsion.fireEvent('click', btnEditarCgg_res_expulsion);
                }
            }
        }
    });
    gsCgg_res_expulsion.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:'JSON'
        }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_expulsion.
     */
    var winFrmListadoCgg_res_expulsion = null;
    if(inDesktop){
        winFrmListadoCgg_res_expulsion = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_expulsion',
            title:tituloListadoCgg_res_expulsion,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_expulsion,descListadoCgg_res_expulsion),
            items:[grdCgg_res_expulsion],
            bbar:[btnNuevoCgg_res_expulsion,btnEditarCgg_res_expulsion,btnEliminarCgg_res_expulsion,'->',btnSalirCgg_res_expulsion]
        });
    }else{
        winFrmListadoCgg_res_expulsion = new Ext.Window({
            id:'winFrmListadoCgg_res_expulsion',
            title:tituloListadoCgg_res_expulsion,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_expulsion,descListadoCgg_res_expulsion),
            items:[grdCgg_res_expulsion],
            bbar:[btnNuevoCgg_res_expulsion,btnEditarCgg_res_expulsion,btnEliminarCgg_res_expulsion,'->',btnSalirCgg_res_expulsion]
        });
    }

    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_expulsion.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_expulsion.
     * @returns ventana winFrmCgg_res_expulsion.
     * @base FrmListadoCgg_res_expulsion.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_expulsion;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_expulsion.
     * @base FrmListadoCgg_res_expulsion.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_expulsion.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_expulsion;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_expulsion;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_expulsion.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_expulsion.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_expulsion desde una instancia.
 */
FrmListadoCgg_res_expulsion.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_expulsion desde una instancia.
 */
FrmListadoCgg_res_expulsion.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_expulsion,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_expulsion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_expulsion desde una instancia.
 */
FrmListadoCgg_res_expulsion.prototype.loadData = function(){
    this.loadData();
}
