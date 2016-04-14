/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_jur_tipo_proceso.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_jur_tipo_proceso(inDesktop){
    var optMenu = 'Jur\u00eddico/Tipo Proceso';
    var urlListadoCgg_jur_tipo_proceso=URL_WS+"Cgg_jur_tipo_proceso";
    var tituloListadoCgg_jur_tipo_proceso='Tipo proceso jur\u00EDdico';
    var descListadoCgg_jur_tipo_proceso='El formulario permite administrar informaci\u00f3n de Tipo de proceso.';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_jur_tipo_proceso.
     */
    var btnNuevoCgg_jur_tipo_proceso = new Ext.Button({
        id:'btnNuevoCgg_jur_tipo_proceso',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_jur_tipo_proceso = new FrmCgg_jur_tipo_proceso("insert");
                objCgg_jur_tipo_proceso.closeHandler(function(){
                    gsCgg_jur_tipo_proceso.reload();
                });
                objCgg_jur_tipo_proceso.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_jur_tipo_proceso.
     */
    var btnEditarCgg_jur_tipo_proceso = new Ext.Button({
        id:'btnEditarCgg_jur_tipo_proceso',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_jur_tipo_proceso.getSelectionModel().getSelected();
                if(r){
                    var objCgg_jur_tipo_proceso = new FrmCgg_jur_tipo_proceso("update",r);
                    objCgg_jur_tipo_proceso.closeHandler(function(){
                        gsCgg_jur_tipo_proceso.reload();
                    });
                    objCgg_jur_tipo_proceso.loadData();
                    objCgg_jur_tipo_proceso.show();
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_jur_tipo_proceso.
     */
    var btnEliminarCgg_jur_tipo_proceso = new Ext.Button({
        id:'btnEliminarCgg_jur_tipo_proceso',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                if(grdCgg_jur_tipo_proceso.getSelectionModel().getSelected() == undefined || grdCgg_jur_tipo_proceso.getSelectionModel().getSelected()==null){
                    return;
                }
                Ext.Msg.show({
                    title:tituloListadoCgg_jur_tipo_proceso,
                    msg:'Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_jur_tipo_proceso,
                    icon: Ext.MessageBox.QUESTION
                });
                function SWRCgg_jur_tipo_proceso(btn){
                    if (btn=='yes'){
                        try{
                            function CallBackCgg_jur_tipo_proceso(r){
                                winFrmListadoCgg_jur_tipo_proceso.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_jur_tipo_proceso,
                                        msg: 'La informaci\u00f3n de Tipo Proceso ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_jur_tipo_proceso.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_jur_tipo_proceso,
                                        msg: 'La informaci\u00f3n de Tipo Proceso no ha podido ser eliminada.'+(r.message?r.message:r),
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_jur_tipo_proceso.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCjtpr_codigo',grdCgg_jur_tipo_proceso.getSelectionModel().getSelected().get('CJTPR_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_jur_tipo_proceso,"delete",param, true, CallBackCgg_jur_tipo_proceso);
                        }catch(inErr){
                            winFrmListadoCgg_jur_tipo_proceso.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_jur_tipo_proceso.
     */
    var btnSalirCgg_jur_tipo_proceso = new Ext.Button({
        id:'btnSalirCgg_jur_tipo_proceso',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_jur_tipo_proceso.close();
            }
        }
    });    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_jur_tipo_proceso.
     */
    var cmCgg_jur_tipo_proceso = new Ext.grid.ColumnModel([
    {
        dataIndex:'CJTPR_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CJTPR_NOMBRE',
        header:'Nombre',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CJTPR_DESCRIPCION',
        header:'Descripci\u00f3n',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CJTPR_TIPO',
        header:'Tipo',
        width:150,
        sortable:true,
        renderer:function(inCjtpr_tipo){
            return dsTipoAcuerdo[inCjtpr_tipo][1];
        }
    }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_jur_tipo_proceso por un campo especifico.
     */
    var gsCgg_jur_tipo_proceso = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_tipo_proceso",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CJTPR_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CJTPR_CODIGO'
        },

        {
            name:'CJTPR_NOMBRE'
        },

        {
            name:'CJTPR_DESCRIPCION'
        },

        {
            name:'CJTPR_TIPO'
        }
        ]),
        baseParams:{
            keyword:"",
            format:'JSON'
        },
        groupField:'CJTPR_TIPO',
        sortInfo: {
            field: 'CJTPR_TIPO',
            direction: 'ASC'
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_jur_tipo_proceso.
     */
    var pgBarCgg_jur_tipo_proceso= new Ext.PagingToolbar({
        store: gsCgg_jur_tipo_proceso,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_jur_tipo_proceso en un formato tabular de filas y columnas.
     */
    var grdCgg_jur_tipo_proceso = new Ext.grid.GridPanel({
        cm:cmCgg_jur_tipo_proceso,
        store:gsCgg_jur_tipo_proceso,
        region:'center',
        anchor:'100% 100%',
        viewConfig:{
            forceFit:true
        },
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
            store:gsCgg_jur_tipo_proceso,
            width:200
        })
        ],
        bbar:pgBarCgg_jur_tipo_proceso,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_jur_tipo_proceso.hidden){
                    btnEditarCgg_jur_tipo_proceso.fireEvent('click', btnEditarCgg_jur_tipo_proceso);
                }
            }
        }
    });
    gsCgg_jur_tipo_proceso.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:'JSON'
        }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_jur_tipo_proceso.
     */
    var winFrmListadoCgg_jur_tipo_proceso = null;
    
    if(inDesktop!==undefined && inDesktop!==null ){
        winFrmListadoCgg_jur_tipo_proceso = inDesktop.createWindow({
            id:'winFrmListadoCgg_jur_tipo_proceso',
            title:tituloListadoCgg_jur_tipo_proceso,
            iconCls:'iconAplicacion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_jur_tipo_proceso,descListadoCgg_jur_tipo_proceso),
            items:[grdCgg_jur_tipo_proceso],
            bbar:[btnNuevoCgg_jur_tipo_proceso,btnEditarCgg_jur_tipo_proceso,btnEliminarCgg_jur_tipo_proceso,'->',btnSalirCgg_jur_tipo_proceso]
        });
    }else{
        winFrmListadoCgg_jur_tipo_proceso = new Ext.Window({
            id:'winFrmListadoCgg_jur_tipo_proceso',
            title:tituloListadoCgg_jur_tipo_proceso,
            iconCls:'iconAplicacion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_jur_tipo_proceso,descListadoCgg_jur_tipo_proceso),
            items:[grdCgg_jur_tipo_proceso],
            bbar:[btnNuevoCgg_jur_tipo_proceso,btnEditarCgg_jur_tipo_proceso,btnEliminarCgg_jur_tipo_proceso,'->',btnSalirCgg_jur_tipo_proceso]
        });
    }

    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_jur_tipo_proceso.
     * @returns ventana winFrmCgg_jur_tipo_proceso.
     * @base FrmListadoCgg_jur_tipo_proceso.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_jur_tipo_proceso;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_jur_tipo_proceso.
     * @base FrmListadoCgg_jur_tipo_proceso.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_jur_tipo_proceso.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_jur_tipo_proceso;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_jur_tipo_proceso;
    }

    /**
         * Funcion que aplica los privilegios del usuario.
         */
    applyGrants(winFrmListadoCgg_jur_tipo_proceso.getBottomToolbar());
    
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_jur_tipo_proceso.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_jur_tipo_proceso.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_jur_tipo_proceso desde una instancia.
 */
FrmListadoCgg_jur_tipo_proceso.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_jur_tipo_proceso desde una instancia.
 */
FrmListadoCgg_jur_tipo_proceso.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_jur_tipo_proceso,
 * con el fin de realizar otras acciones desde una instancia.
 */ 
FrmListadoCgg_jur_tipo_proceso.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_jur_tipo_proceso desde una instancia.
 */
FrmListadoCgg_jur_tipo_proceso.prototype.loadData = function(){
    this.loadData();
}
