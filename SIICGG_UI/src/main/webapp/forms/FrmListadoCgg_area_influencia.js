/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_area_influencia.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_area_influencia(inDesktop){
    var urlListadoCgg_area_influencia=URL_WS+"Cgg_area_influencia";
    var tituloListadoCgg_area_influencia='Area de influencia';
    var descListadoCgg_area_influencia='El formulario permite administrar informaci\u00f3n de Area influencia';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_area_influencia.
     */
    var btnNuevoCgg_area_influencia = new Ext.Button({
        id:'btnNuevoCgg_area_influencia',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_area_influencia = new FrmCgg_area_influencia("insert");
                objCgg_area_influencia.closeHandler(function(){
                    gsCgg_area_influencia.reload();
                });
                objCgg_area_influencia.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_area_influencia.
     */
    var btnEditarCgg_area_influencia = new Ext.Button({
        id:'btnEditarCgg_area_influencia',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_area_influencia.getSelectionModel().getSelected();
                if(r){
                    var objCgg_area_influencia = new FrmCgg_area_influencia("update",r);
                    objCgg_area_influencia.closeHandler(function(){
                        gsCgg_area_influencia.reload();
                    });
                    objCgg_area_influencia.loadData();
                    objCgg_area_influencia.show();
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_area_influencia.
     */
    var btnEliminarCgg_area_influencia = new Ext.Button({
        id:'btnEliminarCgg_area_influencia',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                if(grdCgg_area_influencia.getSelectionModel().getSelected() == undefined || grdCgg_area_influencia.getSelectionModel().getSelected() == null){
                    return;
                }
                Ext.Msg.show({
                    title:tituloListadoCgg_area_influencia,
                    msg:'Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_area_influencia,
                    icon: Ext.MessageBox.QUESTION
                });
                function SWRCgg_area_influencia(btn){
                    if (btn=='yes'){
                        try{
                            function CallBackCgg_area_influencia(r){
                                winFrmListadoCgg_area_influencia.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_area_influencia,
                                        msg: 'El Area de influencia ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_area_influencia.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_area_influencia,
                                        msg: 'El Area de influencia no ha podido ser eliminada.'+(r.message?r.message:r),
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_area_influencia.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCainf_codigo',grdCgg_area_influencia.getSelectionModel().getSelected().get('CAINF_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_area_influencia,"delete",param, true, CallBackCgg_area_influencia);
                        }catch(inErr){
                            winFrmListadoCgg_area_influencia.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_area_influencia.
     */
    var btnSalirCgg_area_influencia = new Ext.Button({
        id:'btnSalirCgg_area_influencia',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_area_influencia.close();
            }
        }
    });    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_area_influencia.
     */
    var cmCgg_area_influencia = new Ext.grid.ColumnModel([
    {
        dataIndex:'CAINF_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CAINF_NOMBRE',
        header:'Nombre',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CAINF_DESCRIPCION',
        header:'Descripci\u00f3n',
        width:150,
        sortable:true
    }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_area_influencia por un campo especifico.
     */
    var gsCgg_area_influencia = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_area_influencia",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CAINF_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CAINF_CODIGO'
        },

        {
            name:'CAINF_NOMBRE'
        },

        {
            name:'CAINF_DESCRIPCION'
        }
        ]),
        sortInfo:{
            field: 'CAINF_NOMBRE',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:'JSON'
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_area_influencia.
     */
    var pgBarCgg_area_influencia= new Ext.PagingToolbar({
        store: gsCgg_area_influencia,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_area_influencia en un formato tabular de filas y columnas.
     */
    var grdCgg_area_influencia = new Ext.grid.GridPanel({
        cm:cmCgg_area_influencia,
        store:gsCgg_area_influencia,
        region:'center',
        anchor:'100% 100%',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        tbar: [
        'Buscar: ',
        new Ext.ux.bsx.SearchField({
            store:gsCgg_area_influencia,
            width:200
        })
        ],
        bbar:pgBarCgg_area_influencia,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_area_influencia.hidden){
                    btnEditarCgg_area_influencia.fireEvent('click', btnEditarCgg_area_influencia);
                }
            }
        }
    });
    gsCgg_area_influencia.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:'JSON'
        }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_area_influencia.
     */
    if(inDesktop){
        var winFrmListadoCgg_area_influencia = inDesktop.createWindow({
            id:'winFrmListadoCgg_area_influencia',
            title:tituloListadoCgg_area_influencia,
            iconCls:'iconAplicacion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_area_influencia,descListadoCgg_area_influencia),
            items:[grdCgg_area_influencia],
            bbar:[btnNuevoCgg_area_influencia,btnEditarCgg_area_influencia,btnEliminarCgg_area_influencia,'->',btnSalirCgg_area_influencia]
        });

    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_area_influencia.
     * @returns ventana winFrmCgg_area_influencia.
     * @base FrmListadoCgg_area_influencia.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_area_influencia;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_area_influencia.
     * @base FrmListadoCgg_area_influencia.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_area_influencia.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_area_influencia;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_area_influencia;
    }

    /**
         * Funcion que aplica los privilegios del usuario.
         */
    applyGrants(winFrmListadoCgg_area_influencia.getBottomToolbar());
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_area_influencia.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_area_influencia.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_area_influencia desde una instancia.
 */
FrmListadoCgg_area_influencia.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_area_influencia desde una instancia.
 */
FrmListadoCgg_area_influencia.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_area_influencia,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_area_influencia.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_area_influencia desde una instancia.
 */
FrmListadoCgg_area_influencia.prototype.loadData = function(){
    this.loadData();
}
