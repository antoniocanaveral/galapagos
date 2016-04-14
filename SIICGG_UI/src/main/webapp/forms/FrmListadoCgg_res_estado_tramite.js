/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_estado_tramite.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */

function FrmListadoCgg_res_estado_tramite(inDesktop){
    var optMenu = 'Res estado tramite';
	var optMenu = 'Configuraci\u00F3n/Administraci\u00F3n de residencia/Administraci\u00F3n estado tr\u00E1mite';
    var urlListadoCgg_res_estado_tramite=URL_WS+"Cgg_res_estado_tramite";
    var tituloListadoCgg_res_estado_tramite='Listado de los estados de tr\u00E1mite';
    var descListadoCgg_res_estado_tramite='Formulario para administrar la informaci\u00f3n de los estados de tr\u00E1mite';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_estado_tramite.
     */
    var btnNuevoCgg_res_estado_tramite = new Ext.Button({
        id:'btnNuevoCgg_res_estado_tramite',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Almacena la informaci\u00f3n de los estados del tr\u00E1mite',
        listeners:{
            click:function(){
                var objCgg_res_estado_tramite = new FrmCgg_res_estado_tramite("insert");
                objCgg_res_estado_tramite.closeHandler(function(){
                    gsCgg_res_estado_tramite.reload();
                });
                objCgg_res_estado_tramite.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_estado_tramite.
     */
    var btnEditarCgg_res_estado_tramite = new Ext.Button({
        id:'btnEditarCgg_res_estado_tramite',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:'Edita el Estado seleccionado',
        listeners:{
            click:function(){
                var r=grdCgg_res_estado_tramite.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_estado_tramite = new FrmCgg_res_estado_tramite("update",r);
                    objCgg_res_estado_tramite.closeHandler(function(){
                        gsCgg_res_estado_tramite.reload();
                    });
                    objCgg_res_estado_tramite.loadData();
                    objCgg_res_estado_tramite.show();
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_estado_tramite.
     */
    var btnEliminarCgg_res_estado_tramite = new Ext.Button({
        id:'btnEliminarCgg_res_estado_tramite',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:'Elimina el estado seleccionado',
        listeners:{
            click:function(){
                //var r = grdCgg_res_estado_tramite.getSelectionModel().getSelected();
                // if (r){
                Ext.Msg.show({
                    title:'Aviso',
                    msg:'Est\u00e1 seguro de eliminar?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_res_estado_tramite,
                    icon: Ext.MessageBox.QUESTION
                });
                function SWRCgg_res_estado_tramite(btn){
                    if (btn=='yes'){
                        try{
                            function CallBackCgg_res_estado_tramite(r){
                                winFrmListadoCgg_res_estado_tramite.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_res_estado_tramite,
                                        msg: 'La informaci\u00f3n del estado tr\u00E1mite ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_res_estado_tramite.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_res_estado_tramite,
                                        msg: 'La informaci\u00f3n del estado de tr\u00E1mite no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_res_estado_tramite.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCrett_codigo',grdCgg_res_estado_tramite.getSelectionModel().getSelected().get('CRETT_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_res_estado_tramite,"delete",param, true, CallBackCgg_res_estado_tramite);
                        }catch(inErr){
                            winFrmListadoCgg_res_estado_tramite.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_estado_tramite.
     */
    var btnSalirCgg_res_estado_tramite = new Ext.Button({
        id:'btnSalirCgg_res_estado_tramite',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Cerrar',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_estado_tramite.close();
            }
        }
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_estado_tramite.
     */
    var cmCgg_res_estado_tramite = new Ext.grid.ColumnModel([        
        {
            dataIndex:'CRETT_CODIGO',
            hidden:true,
            header:'Codigo',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRETT_NOMBRE',
            header:'Nombre Estado',
            width:300,
            sortable:true
        },

        {
            dataIndex:'CRETT_ABREVIATURA',
            header:'Abreviatura',
            width:200,
            sortable:true
        }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_estado_tramite por un campo especifico.
     */
    var gsCgg_res_estado_tramite = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_estado_tramite",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRETT_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CRETT_CODIGO'
        },

        {
            name:'CRETT_NOMBRE'
        },

        {
            name:'CRETT_ABREVIATURA'
        }
        ]),
        sortInfo:{
            field: 'CRETT_NOMBRE',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_estado_tramite.
     */
    var pgBarCgg_res_estado_tramite= new Ext.PagingToolbar({
        store: gsCgg_res_estado_tramite,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_estado_tramite en un formato tabular de filas y columnas.
     */
    var grdCgg_res_estado_tramite = new Ext.grid.GridPanel({
        cm:cmCgg_res_estado_tramite,
        store:gsCgg_res_estado_tramite,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        tbar: [
        'Buscar: ', ' ',
        new Ext.ux.bsx.SearchField({
            store:gsCgg_res_estado_tramite,
            width:200
        })
        ],
        bbar:pgBarCgg_res_estado_tramite,
        viewConfig: {
            forceFit:true
        },
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_estado_tramite.hidden){
                    btnEditarCgg_res_estado_tramite.fireEvent('click', btnEditarCgg_res_estado_tramite);
                }
            }
        }
    });
    gsCgg_res_estado_tramite.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON"
        }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_estado_tramite.
     */
    var winFrmListadoCgg_res_estado_tramite = null;
    if(inDesktop !== undefined && inDesktop !== null){
        winFrmListadoCgg_res_estado_tramite = new inDesktop.createWindow({
            id:'winFrmListadoCgg_res_estado_tramite',
            title:tituloListadoCgg_res_estado_tramite,
            tbar:getPanelTitulo(''+tituloListadoCgg_res_estado_tramite,descListadoCgg_res_estado_tramite),
            items:[grdCgg_res_estado_tramite],
            width:500,
            minWidth:500,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_estado_tramite,btnEditarCgg_res_estado_tramite,btnEliminarCgg_res_estado_tramite,'->',btnSalirCgg_res_estado_tramite]
        });
    }else{

        winFrmListadoCgg_res_estado_tramite = new Ext.Window({
            id:'winFrmListadoCgg_res_estado_tramite',
            title:tituloListadoCgg_res_estado_tramite,
            tbar:getPanelTitulo(''+tituloListadoCgg_res_estado_tramite,descListadoCgg_res_estado_tramite),
            items:[grdCgg_res_estado_tramite],
            width:500,
            minWidth:500,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_estado_tramite,btnEditarCgg_res_estado_tramite,btnEliminarCgg_res_estado_tramite,'->',btnSalirCgg_res_estado_tramite]
        });
    }
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_estado_tramite.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_estado_tramite.
     * @returns ventana winFrmCgg_res_estado_tramite.
     * @base FrmListadoCgg_res_estado_tramite.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_estado_tramite;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_estado_tramite.
     * @base FrmListadoCgg_res_estado_tramite.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_estado_tramite.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_estado_tramite;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_estado_tramite;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_estado_tramite.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_estado_tramite.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_estado_tramite desde una instancia.
 */
FrmListadoCgg_res_estado_tramite.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_estado_tramite desde una instancia.
 */
FrmListadoCgg_res_estado_tramite.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_estado_tramite,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_estado_tramite.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_estado_tramite desde una instancia.
 */
FrmListadoCgg_res_estado_tramite.prototype.loadData = function(){
    this.loadData();
}
