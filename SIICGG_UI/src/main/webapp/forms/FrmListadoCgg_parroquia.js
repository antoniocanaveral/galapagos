/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_parroquia.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_parroquia(inDesktop){    
	var optMenu = 'Configuraci\u00F3n/Distribuci\u00F3n geogr\u00E1fica/Administraci\u00F3n de parroquias';
    var urlListadoCgg_parroquia=URL_WS+"Cgg_parroquia";
    var tituloListadoCgg_parroquia='Listado parroquias';
    var descListadoCgg_parroquia='El formulario permite administrar informaci\u00f3n de parroquia';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_parroquia.
     */
    var btnNuevoCgg_parroquia = new Ext.Button({
        id:'btnNuevoCgg_parroquia',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_parroquia = new FrmCgg_parroquia("insert");
                objCgg_parroquia.closeHandler(function(){
                    gsCgg_parroquia.reload();
                });
                objCgg_parroquia.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_parroquia.
     */
    var btnEditarCgg_parroquia = new Ext.Button({
        id:'btnEditarCgg_parroquia',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_parroquia.getSelectionModel().getSelected();
                if(r){
                    var objCgg_parroquia = new FrmCgg_parroquia("update",r);
                    objCgg_parroquia.closeHandler(function(){
                        gsCgg_parroquia.reload();
                    });
                    objCgg_parroquia.loadData();
                    objCgg_parroquia.show();
                }

            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_parroquia.
     */
    var btnEliminarCgg_parroquia = new Ext.Button({
        id:'btnEliminarCgg_parroquia',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_parroquia,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_parroquia(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_parroquia(r){
                            winFrmListadoCgg_parroquia.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_parroquia,
                                    msg: 'La informaci\u00f3n de parroquia ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_parroquia.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_parroquia,
                                    msg: 'La informaci\u00f3n de parroquia no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_parroquia.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCprr_codigo',grdCgg_parroquia.getSelectionModel().getSelected().get('CPRR_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_parroquia,"delete",param, true, CallBackCgg_parroquia);
                    }catch(inErr){
                        winFrmListadoCgg_parroquia.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_parroquia.
     */
    var btnSalirCgg_parroquia = new Ext.Button({
        id:'btnSalirCgg_parroquia',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_parroquia.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_parroquia.
     */
    var cmCgg_parroquia = new Ext.grid.ColumnModel([
        {dataIndex:'CPRR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CCTN_CODIGO',header:'Ciudad',width:150,sortable:true,
            renderer:function(inCCTN_CODIGO){
                try{
                    var rCantonParroquia=SCGG_CANTON.getAt(SCGG_CANTON.findExact('CCTN_CODIGO',inCCTN_CODIGO));
                    return rCantonParroquia.get('CCTN_NOMBRE');
                }catch(inError){
                    return '';
                }

            }
        },
        {dataIndex:'CPRR_NOMBRE',header:'Parroquia',width:150,sortable:true},
        {dataIndex:'CPRR_DESCRIPCION',header:'Descripci\u00f3n',width:150,sortable:true},
        {dataIndex:'CPRR_TIPO',header:'Tipo',width:150,sortable:true,
            renderer:function(inCPRR_TIPO)
            {
                if (inCPRR_TIPO ==0)
                    return 'Urbano'
                else
                    return 'Rural'
            }
        }
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_parroquia por un campo especifico.
     */
    var gsCgg_parroquia = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_parroquia",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CPRR_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CPRR_CODIGO'},
            {name:'CCTN_CODIGO'},
            {name:'CPRR_NOMBRE'},
            {name:'CPRR_DESCRIPCION'},
            {name:'CPRR_TIPO'}
        ]),
        sortInfo:{field: 'CCTN_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_parroquia.
     */
    var pgBarCgg_parroquia= new Ext.PagingToolbar({
        store: gsCgg_parroquia,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_parroquia en un formato tabular de filas y columnas.
     */
    var grdCgg_parroquia = new Ext.grid.GridPanel({
        cm:cmCgg_parroquia,
        store:gsCgg_parroquia,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        viewConfig:{forceFit:true},
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_parroquia,
                width:200
            })
        ],
        bbar:pgBarCgg_parroquia,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_parroquia.hidden){
                    btnEditarCgg_parroquia.fireEvent('click', btnEditarCgg_parroquia);
                }
            }}});
    gsCgg_parroquia.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_parroquia.
     */
    var winFrmListadoCgg_parroquia = null;
    if(inDesktop!==null && inDesktop!==undefined){
        winFrmListadoCgg_parroquia = inDesktop.createWindow({
            id:'winFrmListadoCgg_parroquia',
            title:tituloListadoCgg_parroquia,
            tbar:getPanelTitulo(tituloListadoCgg_parroquia,descListadoCgg_parroquia),
            items:[grdCgg_parroquia],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_parroquia,btnEditarCgg_parroquia,btnEliminarCgg_parroquia,'->',btnSalirCgg_parroquia]
        });
    }
    else
    {
         winFrmListadoCgg_parroquia = new Ext.Window({
            id:'winFrmListadoCgg_parroquia',
            title:tituloListadoCgg_parroquia,
            tbar:getPanelTitulo(tituloListadoCgg_parroquia,descListadoCgg_parroquia),
            items:[grdCgg_parroquia],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_parroquia,btnEditarCgg_parroquia,btnEliminarCgg_parroquia,'->',btnSalirCgg_parroquia]
        });
    }

    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_parroquia.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_parroquia.
     * @returns ventana winFrmCgg_parroquia.
     * @base FrmListadoCgg_parroquia.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_parroquia;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_parroquia.
     * @base FrmListadoCgg_parroquia.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_parroquia.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_parroquia;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_parroquia;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_parroquia.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_parroquia.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_parroquia desde una instancia.
 */
FrmListadoCgg_parroquia.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_parroquia desde una instancia.
 */
FrmListadoCgg_parroquia.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_parroquia,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_parroquia.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_parroquia desde una instancia.
 */
FrmListadoCgg_parroquia.prototype.loadData = function(){
    this.loadData();
}
