/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_proceso.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_proceso(inDesktop){    
	var optMenu = 'Configuraci\u00F3n/Listados adicionales/Administraci\u00F3n de Procesos';
    var urlListadoCgg_res_proceso=URL_WS+"Cgg_res_proceso";
    var tituloListadoCgg_res_proceso='Listado de procesos';
    var descListadoCgg_res_proceso='Formulario que permite la administraci\u00f3n de la informaci\u00f3n de procesos';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_proceso.
     */
    var btnNuevoCgg_res_proceso = new Ext.Button({
        id:'btnNuevoCgg_res_proceso',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Ingreso de nuevo proceso',
        listeners:{
            click:function(){
                var objCgg_res_proceso = new FrmCgg_res_proceso("insert");
                objCgg_res_proceso.closeHandler(function(){
                    gsCgg_res_proceso.reload();
                });
                objCgg_res_proceso.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_proceso.
     */
    var btnEditarCgg_res_proceso = new Ext.Button({
        id:'btnEditarCgg_res_proceso',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:'Edita el proceso seleccionado',
        listeners:{
            click:function(){
                var r=grdCgg_res_proceso.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_proceso = new FrmCgg_res_proceso("update",r);
                    objCgg_res_proceso.closeHandler(function(){
                        gsCgg_res_proceso.reload();
                    });
                    objCgg_res_proceso.loadData();
                    objCgg_res_proceso.show();
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_proceso.
     */
    var btnEliminarCgg_res_proceso = new Ext.Button({
        id:'btnEliminarCgg_res_proceso',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:'Elimina la informaci\u00f3n del proceso',
        listeners:{
            click:function(){
                //var r = grdCgg_res_proceso.getSelectionModel().getSelected();
                //if (r){
                Ext.Msg.show({
                    title:'Aviso',
                    msg:'Est\u00e1 seguro de eliminar?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_res_proceso,
                    icon: Ext.MessageBox.QUESTION
                });
                function SWRCgg_res_proceso(btn){
                    if (btn=='yes'){
                        try{
                            function CallBackCgg_res_proceso(r){
                                winFrmListadoCgg_res_proceso.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_res_proceso,
                                        msg:'La informaci\u00f3n de proceso ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_res_proceso.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_res_proceso,
                                        msg: 'La informaci\u00f3n de proceso no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_res_proceso.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCrpro_codigo',grdCgg_res_proceso.getSelectionModel().getSelected().get('CRPRO_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_res_proceso,"delete",param, true, CallBackCgg_res_proceso);
                        }catch(inErr){
                            winFrmListadoCgg_res_proceso.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_proceso.
     */
    var btnSalirCgg_res_proceso = new Ext.Button({
        id:'btnSalirCgg_res_proceso',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Cerrar',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_proceso.close();
            }
        }
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_proceso.
     */
    var cmCgg_res_proceso = new Ext.grid.ColumnModel([        
        {
            dataIndex:'CRPRO_CODIGO',
            hidden:true,
            header:'Codigo',
            width:150,
            sortable:true
        },

        {
            dataIndex:'CRPRO_NOMBRE',
            header:'Nombre',
            width:370,
            sortable:true
        }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_proceso por un campo especifico.
     */
    var gsCgg_res_proceso = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_proceso",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPRO_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CRPRO_CODIGO'
        },

        {
            name:'CRPRO_NOMBRE'
        }
        ]),
        sortInfo:{
            field: 'CRPRO_NOMBRE',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_proceso.
     */
    var pgBarCgg_res_proceso= new Ext.PagingToolbar({
        store: gsCgg_res_proceso,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No existe informaci\u00f3n para vizualizar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_proceso en un formato tabular de filas y columnas.
     */
    var grdCgg_res_proceso = new Ext.grid.GridPanel({
        cm:cmCgg_res_proceso,
        store:gsCgg_res_proceso,
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
            store:gsCgg_res_proceso,
            width:200
        })
        ],
        bbar:pgBarCgg_res_proceso,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_proceso.hidden){
                    btnEditarCgg_res_proceso.fireEvent('click', btnEditarCgg_res_proceso);
                }
            }
        }
    });
    gsCgg_res_proceso.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON"
        }
    });

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_proceso.
     */
    var winFrmListadoCgg_res_proceso = null;

    if(inDesktop !== null && inDesktop !== undefined){
        winFrmListadoCgg_res_proceso = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_proceso',
            title:tituloListadoCgg_res_proceso,
            tbar:getPanelTitulo(tituloListadoCgg_res_proceso,descListadoCgg_res_proceso),
            items:[grdCgg_res_proceso],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,            
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_proceso,btnEditarCgg_res_proceso,btnEliminarCgg_res_proceso,'->',btnSalirCgg_res_proceso]
        });
    }else{
        winFrmListadoCgg_res_proceso = new Ext.Window({
            id:'winFrmListadoCgg_res_proceso',
            title:tituloListadoCgg_res_proceso,
            tbar:getPanelTitulo(tituloListadoCgg_res_proceso,descListadoCgg_res_proceso),
            items:[grdCgg_res_proceso],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,            
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_proceso,btnEditarCgg_res_proceso,btnEliminarCgg_res_proceso,'->',btnSalirCgg_res_proceso]
        });
    }


    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_proceso.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_proceso.
     * @returns ventana winFrmCgg_res_proceso.
     * @base FrmListadoCgg_res_proceso.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_proceso;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_proceso.
     * @base FrmListadoCgg_res_proceso.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_proceso.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_proceso;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_proceso;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_proceso.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_proceso.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_proceso desde una instancia.
 */
FrmListadoCgg_res_proceso.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_proceso desde una instancia.
 */
FrmListadoCgg_res_proceso.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_proceso,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_proceso.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_proceso desde una instancia.
 */
FrmListadoCgg_res_proceso.prototype.loadData = function(){
    this.loadData();
}
