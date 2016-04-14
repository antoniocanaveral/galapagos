/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_fase.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_fase(inDesktop){
    var urlListadoCgg_res_fase=URL_WS+"Cgg_res_fase";
    var tituloListadoCgg_res_fase='Fase';
    var descListadoCgg_res_fase='El formulario permite administrar informaci\u00f3n de fases';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_fase.
     */
    var btnNuevoCgg_res_fase = new Ext.Button({
        id:'btnNuevoCgg_res_fase',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_fase = new FrmCgg_res_fase("insert");
                objCgg_res_fase.closeHandler(function(){
                    gsCgg_res_fase.reload();
                });
                objCgg_res_fase.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_fase.
     */
    var btnEditarCgg_res_fase = new Ext.Button({
        id:'btnEditarCgg_res_fase',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_fase.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_fase = new FrmCgg_res_fase("update",r);
                    objCgg_res_fase.closeHandler(function(){
                        gsCgg_res_fase.reload();
                    });
                    objCgg_res_fase.loadData();
                    objCgg_res_fase.show();
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_fase.
     */
    var btnEliminarCgg_res_fase = new Ext.Button({
        id:'btnEliminarCgg_res_fase',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({
                    title:'Aviso',
                    msg:'Est\u00e1 seguro de eliminar?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_res_fase,
                    icon: Ext.MessageBox.QUESTION
                });
                function SWRCgg_res_fase(btn){
                    if (btn=='yes'){
                        try{
                            function CallBackCgg_res_fase(r){
                                winFrmListadoCgg_res_fase.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_res_fase,
                                        msg: 'La informaci\u00f3n de Res fase ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_res_fase.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_res_fase,
                                        msg: 'La informaci\u00f3n de Cgg_res_fase no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_res_fase.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCrfas_codigo',grdCgg_res_fase.getSelectionModel().getSelected().get('CRFAS_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_res_fase,"delete",param, true, CallBackCgg_res_fase);
                        }catch(inErr){
                            winFrmListadoCgg_res_fase.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_fase.
     */
    var btnSalirCgg_res_fase = new Ext.Button({
        id:'btnSalirCgg_res_fase',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_fase.close();
            }
        }
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_fase.
     */
    var cmCgg_res_fase = new Ext.grid.ColumnModel([
    {
        dataIndex:'CRFAS_CODIGO',
        header:'Codigo',
        width:150,        
        hidden:true,
        hiddeable:false
    },
    {
        dataIndex:'CRPRO_CODIGO',
        hidden:true
    },
	{
        dataIndex:'CRPRO_NOMBRE',
        header:'Proceso',
        width:100,
        sortable:true
    },
    {
        dataIndex:'CRFAS_NOMBRE',
        header:'Fase',
        width:150,
        sortable:true

    },
    {
        dataIndex:'CRFAS_TAREA_REALIZA',
        header:'Tarea realiza',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CGG_CRFAS_CODIGO',
        header:'Fase principal',
        width:150,
        sortable:true,
        renderer:function(inCGG_CRFAS_CODIGO){
            try{
                var rFasePadre=gsCgg_res_fase.getAt(gsCgg_res_fase.findExact('CRFAS_CODIGO',inCGG_CRFAS_CODIGO,0));
                return (inCGG_CRFAS_CODIGO == rFasePadre.get('CRFAS_CODIGO'))?rFasePadre.get('CRFAS_NOMBRE'):'sin datos';
            }catch(inError){
                return '';
            }
        }
    },
    {
        dataIndex:'CRFAS_ORDEN',
        header:'Orden',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRETT_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CGG_CRETT_CODIGO',
        header:'Crett codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRSEC_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CGG_CUSU_CODIGO',
        header:'Cusu codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRFAS_SUBE_ADJUNTO',
        header:'Sube adjunto',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_fase por un campo especifico.
     */
    var gsCgg_res_fase = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_fase",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRFAS_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CRFAS_CODIGO'
        },

        {
            name:'CRPRO_CODIGO'
        },

        {
            name:'CRFAS_NOMBRE'
        },
        {
            name:'CRFAS_TAREA_REALIZA'
        },
        {
            name:'CGG_CRFAS_CODIGO'
        },
                   
        {
            name:'CRETT_CODIGO'
        },

        {
            name:'CGG_CRETT_CODIGO'
        },

        {
            name:'CRSEC_CODIGO'
        },
        {
            name:'CGG_CUSU_CODIGO'
        },
        {
            name:'CRFAS_ORDEN'
        },
        {
            name:'CRFAS_SUBE_ADJUNTO'
        },
		{
            name:'CRPRO_NOMBRE'
        }
        ]),
        sortInfo:{
            field: 'CRPRO_CODIGO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_fase.
     */
    var pgBarCgg_res_fase= new Ext.PagingToolbar({
        store: gsCgg_res_fase,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_fase en un formato tabular de filas y columnas.
     */
    var grdCgg_res_fase = new Ext.grid.GridPanel({
        cm:cmCgg_res_fase,
        store:gsCgg_res_fase,
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
            store:gsCgg_res_fase,
            width:200
        })
        ],
        bbar:pgBarCgg_res_fase,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_fase.hidden){
                    btnEditarCgg_res_fase.fireEvent('click', btnEditarCgg_res_fase);
                }
            }
        }
    });
    gsCgg_res_fase.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON"
        }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_fase.
     */
    var winFrmListadoCgg_res_fase = null;
    if(inDesktop!==null && inDesktop!==undefined){
        winFrmListadoCgg_res_fase  = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_fase',
            title:tituloListadoCgg_res_fase,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_fase,descListadoCgg_res_fase),
            items:[grdCgg_res_fase],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_fase,btnEditarCgg_res_fase,btnEliminarCgg_res_fase,'->',btnSalirCgg_res_fase]
        });
    }
    else
    {
        winFrmListadoCgg_res_fase = new Ext.Window({
            id:'winFrmListadoCgg_res_fase',
            title:tituloListadoCgg_res_fase,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_fase,descListadoCgg_res_fase),
            items:[grdCgg_res_fase],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_fase,btnEditarCgg_res_fase,btnEliminarCgg_res_fase,'->',btnSalirCgg_res_fase]
        });
    }

    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_fase.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_fase.
     * @returns ventana winFrmCgg_res_fase.
     * @base FrmListadoCgg_res_fase.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_fase;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_fase.
     * @base FrmListadoCgg_res_fase.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_fase.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_fase;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_fase;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_fase.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_fase.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_fase desde una instancia.
 */
FrmListadoCgg_res_fase.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_fase desde una instancia.
 */
FrmListadoCgg_res_fase.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_fase,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_fase.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_fase desde una instancia.
 */
FrmListadoCgg_res_fase.prototype.loadData = function(){
    this.loadData();
}
