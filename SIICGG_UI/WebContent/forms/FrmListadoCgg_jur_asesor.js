/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_jur_asesor.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_jur_asesor(inDesktop){
     var optMenu = 'Jur\u00eddico/Asesor';
    var urlListadoCgg_jur_asesor=URL_WS+"Cgg_jur_asesor";
    var tituloListadoCgg_jur_asesor='Asesor de proceso judicial';
    var descListadoCgg_jur_asesor='El formulario permite administrar informaci\u00f3n del Asesor de un proceso judicial';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_jur_asesor.
     */
    var btnNuevoCgg_jur_asesor = new Ext.Button({
        id:'btnNuevoCgg_jur_asesor',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_jur_asesor = new FrmCgg_jur_asesor("insert");
                objCgg_jur_asesor.closeHandler(function(){
                    gsCgg_jur_asesor.reload();
                });
                objCgg_jur_asesor.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_jur_asesor.
     */
    var btnEditarCgg_jur_asesor = new Ext.Button({
        id:'btnEditarCgg_jur_asesor',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_jur_asesor.getSelectionModel().getSelected();
                if(r){
                    var objCgg_jur_asesor = new FrmCgg_jur_asesor("update",r);
                    objCgg_jur_asesor.closeHandler(function(){
                        gsCgg_jur_asesor.reload();
                    });
                    objCgg_jur_asesor.show();
                    objCgg_jur_asesor.loadData(r);
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_jur_asesor.
     */
    var btnEliminarCgg_jur_asesor = new Ext.Button({
        id:'btnEliminarCgg_jur_asesor',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                if(grdCgg_jur_asesor.getSelectionModel().getSelected()==undefined && grdCgg_jur_asesor.getSelectionModel().getSelected()==null){
                    return;
                }
                Ext.Msg.show({
                    title:tituloListadoCgg_jur_asesor,
                    msg:'Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_jur_asesor,
                    icon: Ext.MessageBox.QUESTION
                });
                function SWRCgg_jur_asesor(btn){
                    if (btn=='yes'){
                        try{
                            function CallBackCgg_jur_asesor(r){
                                winFrmListadoCgg_jur_asesor.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_jur_asesor,
                                        msg: 'El Asesor ha sido eliminado.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_jur_asesor.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_jur_asesor,
                                        msg: 'El Asesor no ha podido ser eliminado.'+(r.message?r.message:r),
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_jur_asesor.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCjase_codigo',grdCgg_jur_asesor.getSelectionModel().getSelected().get('CJASE_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_jur_asesor,"delete",param, true, CallBackCgg_jur_asesor);
                        }catch(inErr){
                            winFrmListadoCgg_jur_asesor.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_jur_asesor.
     */
    var btnSalirCgg_jur_asesor = new Ext.Button({
        id:'btnSalirCgg_jur_asesor',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_jur_asesor.close();
            }
        }
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_jur_asesor.
     */
    var cmCgg_jur_asesor = new Ext.grid.ColumnModel([
    {
        dataIndex:'CJASE_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CUSU_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CUSU_NOMBRE_USUARIO',
        header:'Usuario',
        width:150
    },
    {
        dataIndex:'CRPER_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRDID_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'DOCUMENTO',
        header:'Documento',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRPER_NUM_DOC_IDENTIFIC',
        header:'Num. Documento',
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
        dataIndex:'APELLIDO',
        header:'Apellidos',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CCTN_CODIGO',
        header:'Canton',
        width:150,
        sortable:true,
        hidden:true
    },
    {
        dataIndex:'CANTON',
        header:'Cant\u00f3n',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CJPJU_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },
    {
        dataIndex:'CJPJU_NUMERO',
        header:'Proceso jur\u00eddico',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CJASE_ACTIVO',
        header:'Activo',
        width:150,
        sortable:true,
        renderer:function(inCjase_activo) {
            return dsEstadoAsesor[inCjase_activo][1];
        }
    },
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_jur_asesor por un campo especifico.
     */
    var gsCgg_jur_asesor = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_asesor",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CJASE_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CJASE_CODIGO'
        },

        {
            name:'CUSU_CODIGO'
        },

        {
            name:'CUSU_NOMBRE_USUARIO'
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
            name:'CRPER_NOMBRES'
        },

        {
            name:'APELLIDO'
        },

        {
            name:'CRPER_NUM_DOC_IDENTIFIC'
        },

        {
            name:'CRPER_FECHA_NACIMIENTO'
        },

        {
            name:'CRPER_GENERO'
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
            name:'CJPJU_CODIGO'
        },

        {
            name:'CJPJU_NUMERO'
        },

        {
            name:'CJASE_ACTIVO'
        }
        ]),
        // sortInfo:{field: 'CRPER_CODIGO', direction: 'ASC'},
        baseParams:{
            keyword:"",
            format:'JSON'
        },
        groupField:'CUSU_NOMBRE_USUARIO',
        sortInfo: {
            field: 'CRPER_CODIGO',
            direction: 'ASC'
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_jur_asesor.
     */
    var pgBarCgg_jur_asesor= new Ext.PagingToolbar({
        store: gsCgg_jur_asesor,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_jur_asesor en un formato tabular de filas y columnas.
     */
    var grdCgg_jur_asesor = new Ext.grid.GridPanel({
        cm:cmCgg_jur_asesor,
        store:gsCgg_jur_asesor,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        loadMask:{
            msg:"Cargando..."
        },
        tbar: [
        'Buscar: ',
        new Ext.ux.bsx.SearchField({
            store:gsCgg_jur_asesor,
            width:200
        })
        ],
        bbar:pgBarCgg_jur_asesor,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_jur_asesor.hidden){
                    btnEditarCgg_jur_asesor.fireEvent('click', btnEditarCgg_jur_asesor);
                }
            }
        }
    });
    gsCgg_jur_asesor.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:'JSON'
        }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_jur_asesor.
     */
    if(inDesktop){
        var winFrmListadoCgg_jur_asesor = inDesktop.createWindow({
            id:'winFrmListadoCgg_jur_asesor',
            title:tituloListadoCgg_jur_asesor,
            iconCls:'iconAplicacion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_jur_asesor,descListadoCgg_jur_asesor),
            items:[grdCgg_jur_asesor],
            bbar:[btnNuevoCgg_jur_asesor,btnEditarCgg_jur_asesor,btnEliminarCgg_jur_asesor,'->',btnSalirCgg_jur_asesor]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_jur_asesor.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_jur_asesor.
     * @returns ventana winFrmCgg_jur_asesor.
     * @base FrmListadoCgg_jur_asesor.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_jur_asesor;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_jur_asesor.
     * @base FrmListadoCgg_jur_asesor.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_jur_asesor.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_jur_asesor;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_jur_asesor;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_jur_asesor.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_jur_asesor.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_jur_asesor desde una instancia.
 */
FrmListadoCgg_jur_asesor.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_jur_asesor desde una instancia.
 */
FrmListadoCgg_jur_asesor.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_jur_asesor,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_jur_asesor.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_jur_asesor desde una instancia.
 */
FrmListadoCgg_jur_asesor.prototype.loadData = function(){
    this.loadData();
}
