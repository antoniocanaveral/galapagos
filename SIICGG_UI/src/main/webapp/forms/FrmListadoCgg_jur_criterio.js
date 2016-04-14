/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_jur_criterio.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_jur_criterio(inDesktop){
	var optMenu = 'Configuraci\u00F3n/Listados adicionales/Administraci\u00F3n criterio de fase';
    var urlListadoCgg_jur_criterio=URL_WS+"Cgg_jur_criterio";
    var tituloListadoCgg_jur_criterio='Listado de criterios';
    var descListadoCgg_jur_criterio='Formulario para administrar informaci\u00f3n de los criterios';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_jur_criterio.
     */
    var btnNuevoCgg_jur_criterio = new Ext.Button({
        id:'btnNuevoCgg_jur_criterio',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Ingresa un nuevo criterio',
        listeners:{
            click:function(){
                var objCgg_jur_criterio = new FrmCgg_jur_criterio("insert");
                objCgg_jur_criterio.closeHandler(function(){
                    gsCgg_jur_criterio.reload();
                });
                objCgg_jur_criterio.show();
            }
        }
    });
/**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_jur_criterio.
     */
var btnEditarCgg_jur_criterio = new Ext.Button({
    id:'btnEditarCgg_jur_criterio',
    text:'Editar',
    iconCls:'iconEditar',
    tooltip:'Edita el criterio seleccionado',
    listeners:{
        click:function(){
            var r=grdCgg_jur_criterio.getSelectionModel().getSelected();
            if(r){
                var objCgg_jur_criterio = new FrmCgg_jur_criterio("update",r);
                objCgg_jur_criterio.closeHandler(function(){
                    gsCgg_jur_criterio.reload();
                });
                objCgg_jur_criterio.loadData();
                objCgg_jur_criterio.show();
            }
        }
    }
});
/**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_jur_criterio.
     */
var btnEliminarCgg_jur_criterio = new Ext.Button({
    id:'btnEliminarCgg_jur_criterio',
    text:'Eliminar',
    iconCls:'iconEliminar',
    tooltip:'Elimina el criterio seleccionado',
    listeners:{
        click:function(){
            Ext.Msg.show({
                title:'Aviso',
                msg:'Est\u00e1 seguro de eliminar?',
                buttons: Ext.Msg.YESNO,
                fn: SWRCgg_jur_criterio,
                icon: Ext.MessageBox.QUESTION
                });
            function SWRCgg_jur_criterio(btn){
                if (btn=='yes'){
                    try{
                        function CallBackCgg_jur_criterio(r){
                            winFrmListadoCgg_jur_criterio.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_jur_criterio,
                                    msg: 'La informaci\u00f3n del criterio ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_jur_criterio.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_jur_criterio,
                                    msg: 'La informaci\u00f3n del criterio no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                        }
                    winFrmListadoCgg_jur_criterio.getEl().mask('Eliminando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    param.add('inCjcri_codigo',grdCgg_jur_criterio.getSelectionModel().getSelected().get('CJCRI_CODIGO'));
                    SOAPClient.invoke(urlListadoCgg_jur_criterio,"delete",param, true, CallBackCgg_jur_criterio);
                }catch(inErr){
                    winFrmListadoCgg_jur_criterio.getEl().unmask();
                }
            }
        }
}
}
});
/**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_jur_criterio.
     */
var btnSalirCgg_jur_criterio = new Ext.Button({
    id:'btnSalirCgg_jur_criterio',
    text:'Salir',
    iconCls:'iconSalir',
    tooltip:'cerrar',
    listeners:{
        click:function(){
            winFrmListadoCgg_jur_criterio.close();
        }
    }
});
/**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_jur_criterio.
     */
var cmCgg_jur_criterio = new Ext.grid.ColumnModel([    
    {
        dataIndex:'CJCRI_CODIGO',
        hidden:true,
        header:'Codigo',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CRFAS_CODIGO',
        hidden:true,
        header:'Codigo',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CJCRI_REQUERIMIENTO',
        header:'Requerimiento',
        width:500,
        sortable:true
    }]);
/**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_jur_criterio por un campo especifico.
     */
var gsCgg_jur_criterio = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_jur_criterio",
        method:"selectPage",
        pagin:true
    }),
    remoteSort:true,
    reader:new Ext.data.JsonReader({
        id:'CJCRI_CODIGO',
        root:'dataSet',
        totalProperty: 'totalCount'
    },[
    {
        name:'CJCRI_CODIGO'
    },

    {
        name:'CRFAS_CODIGO'
    },

    {
        name:'CJCRI_REQUERIMIENTO'
    }
    ]),
    sortInfo:{
        field: 'CRFAS_CODIGO',
        direction: 'ASC'
    },
    baseParams:{
        keyword:"",
        format:"JSON"
    }
});
/**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_jur_criterio.
     */
var pgBarCgg_jur_criterio= new Ext.PagingToolbar({
    store: gsCgg_jur_criterio,
    displayInfo: true,
    pageSize:RECORD_PAGE,
    displayMsg: 'Mostrando {0} - {1} de {2}',
    temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_jur_criterio en un formato tabular de filas y columnas.
     */
var grdCgg_jur_criterio = new Ext.grid.GridPanel({
    cm:cmCgg_jur_criterio,
    store:gsCgg_jur_criterio,
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
        store:gsCgg_jur_criterio,
        width:200
    })
    ],
    bbar:pgBarCgg_jur_criterio,
    viewConfig: {
        forceFit: true
    },
    listeners:{
        rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
            if(!btnEditarCgg_jur_criterio.hidden){
                btnEditarCgg_jur_criterio.fireEvent('click', btnEditarCgg_jur_criterio);
            }
        }
    }
});
gsCgg_jur_criterio.reload({
    params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
});
/**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_jur_criterio.
     */
	 if(inDesktop){
		var winFrmListadoCgg_jur_criterio = inDesktop.createWindow({
			id:'winFrmListadoCgg_jur_criterio',
			title:tituloListadoCgg_jur_criterio,
			tbar:getPanelTitulo(''+tituloListadoCgg_jur_criterio,descListadoCgg_jur_criterio),
			items:[grdCgg_jur_criterio],
			width:500,
			minWidth:500,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			resizable: false,
			constrain:true,
			layout:'border',
			bbar:[btnNuevoCgg_jur_criterio,btnEditarCgg_jur_criterio,btnEliminarCgg_jur_criterio,'->',btnSalirCgg_jur_criterio]
		});
	}else{
		var winFrmListadoCgg_jur_criterio = new Ext.Window({
			id:'winFrmListadoCgg_jur_criterio',
			title:tituloListadoCgg_jur_criterio,
			tbar:getPanelTitulo(''+tituloListadoCgg_jur_criterio,descListadoCgg_jur_criterio),
			items:[grdCgg_jur_criterio],
			width:500,
			minWidth:500,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			resizable: false,
			constrain:true,
			layout:'border',
			bbar:[btnNuevoCgg_jur_criterio,btnEditarCgg_jur_criterio,btnEliminarCgg_jur_criterio,'->',btnSalirCgg_jur_criterio]
		});
	}
/**
     * Funcion que aplica los privilegios del usuario.
     */
applyGrants(winFrmListadoCgg_jur_criterio.getBottomToolbar());
/**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_jur_criterio.
     * @returns ventana winFrmCgg_jur_criterio.
     * @base FrmListadoCgg_jur_criterio.prototype.show
     */
this.getWindow = function(){
    return winFrmListadoCgg_jur_criterio;
}
/**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_jur_criterio.
     * @base FrmListadoCgg_jur_criterio.prototype.loadData
     */
this.loadData = function(){
    gsCgg_jur_criterio.load();
}
/**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
this.getColumnModel = function(){
    return cmCgg_jur_criterio;
}
/**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
this.getStore = function(){
    return gsCgg_jur_criterio;
}
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_jur_criterio.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_jur_criterio.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_jur_criterio desde una instancia.
 */
FrmListadoCgg_jur_criterio.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_jur_criterio desde una instancia.
 */
FrmListadoCgg_jur_criterio.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_jur_criterio,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_jur_criterio.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_jur_criterio desde una instancia.
 */
FrmListadoCgg_jur_criterio.prototype.loadData = function(){
    this.loadData();
}
