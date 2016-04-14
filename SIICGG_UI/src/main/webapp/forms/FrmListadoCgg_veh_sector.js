/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_veh_sector.
 * @constructor 
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_veh_sector(inDesktop){
    var optMenu = 'Configuraci\u00F3n/Listados adicionales/Administraci\u00F3n veh\u00EDculo sector';
    var urlListadoCgg_veh_sector=URL_WS+"Cgg_veh_sector";
    var tituloListadoCgg_veh_sector='Listado veh\u00EDculo sector';
    var descListadoCgg_veh_sector='El formulario permite administrar informaci\u00f3n del veh\u00EDculo sector';
    /**
	 * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_veh_sector.
	 */
    var btnNuevoCgg_veh_sector = new Ext.Button({
        id:'btnNuevoCgg_veh_sector',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Nuevo veh\u00EDculo sector',
        listeners:{
            click:function(){
                var objCgg_veh_sector = new FrmCgg_veh_sector("insert");
                objCgg_veh_sector.closeHandler(function(){
                    gsCgg_veh_sector.reload();
                });
                objCgg_veh_sector.show();
            }
        }
    });
/**
	 * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_veh_sector.
	 */
var btnEditarCgg_veh_sector = new Ext.Button({
    id:'btnEditarCgg_veh_sector',
    text:'Editar',
    iconCls:'iconEditar',
    tooltip:'Editar veh\u00EDculo sector',
    listeners:{
        click:function(){
            var r=grdCgg_veh_sector.getSelectionModel().getSelected();
            if(r){
                var objCgg_veh_sector = new FrmCgg_veh_sector("update",r);
                objCgg_veh_sector.closeHandler(function(){
                    gsCgg_veh_sector.reload();
                });
                objCgg_veh_sector.loadData();
                objCgg_veh_sector.show();
            }
        }
    }
});
/**
	 * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_veh_sector.
	 */
var btnEliminarCgg_veh_sector = new Ext.Button({
    id:'btnEliminarCgg_veh_sector',
    text:'Eliminar',
    iconCls:'iconEliminar',
    tooltip:'Eliminar veh\u00EDculo sector',
    listeners:{
        click:function(){
            var r=grdCgg_veh_sector.getSelectionModel().getSelected();
            if(r){
                function SWRCgg_veh_sector(btn){
                    if (btn=='yes'){
                        try{
                            function CallBackCgg_veh_sector(r){
                                winFrmListadoCgg_veh_sector.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_veh_sector,
                                        msg: 'La informaci\u00f3n de veh\u00EDculo sector ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_veh_sector.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_veh_sector,
                                        msg: 'La informaci\u00f3n de veh\u00EDculo sector no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                        winFrmListadoCgg_veh_sector.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCvsct_codigo',grdCgg_veh_sector.getSelectionModel().getSelected().get('CVSCT_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_veh_sector,"delete",param, true, CallBackCgg_veh_sector);
                    }catch(inErr){
                        winFrmListadoCgg_veh_sector.getEl().unmask();
                    }
                }
            }
}
Ext.Msg.show({
    title:'Aviso',
    msg:'Seguro de eliminar el registro seleccionado?',
    buttons: Ext.Msg.YESNO,
    fn: SWRCgg_veh_sector,
    icon: Ext.MessageBox.QUESTION
    });
}
}
});
/**
	 * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_veh_sector.
	 */
var btnSalirCgg_veh_sector = new Ext.Button({
    id:'btnSalirCgg_veh_sector',
    text:'Salir',
    iconCls:'iconSalir',
    tooltip:'Salir del formulario',
    listeners:{
        click:function(){
            winFrmListadoCgg_veh_sector.close();
        }
    }
});
/**
              * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_veh_sector.
              */
var cmCgg_veh_sector = new Ext.grid.ColumnModel([    
    {
        dataIndex:'CVSCT_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CVSCT_NOMBRE',
        header:'Nombre',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CVSCT_DESCRIPCION',
        header:'Descripci\u00F3n',
        width:150,
        sortable:true
    }
    ]);
/**
              * Ext.data.Store Agrupacion de registros de la tabla Cgg_veh_sector por un campo especifico.
              */
var gsCgg_veh_sector = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_veh_sector",
        method:"selectPage",
        pagin:true
    }),
    remoteSort:true,
    reader:new Ext.data.JsonReader({
        id:'CVSCT_CODIGO',
        root:'dataSet',
        totalProperty: 'totalCount'
    },[
    {
        name:'CVSCT_CODIGO'
    },

    {
        name:'CVSCT_NOMBRE'
    },
    {
        name:'CVSCT_DESCRIPCION'
    }
    ]),
    sortInfo:{
        field: 'CVSCT_NOMBRE',
        direction: 'ASC'
    },
    baseParams:{
        keyword:"",
        format:"JSON"
    }
});
/**
	  * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_veh_sector.
	  */
var pgBarCgg_veh_sector= new Ext.PagingToolbar({
    store: gsCgg_veh_sector,
    displayInfo: true,
    pageSize:RECORD_PAGE,
    displayMsg: 'Mostrando {0} - {1} de {2}',
    temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
	  * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_veh_sector en un formato tabular de filas y columnas.
	  */
var grdCgg_veh_sector = new Ext.grid.GridPanel({
    viewConfig:{
        forceFit:true
    },
    cm:cmCgg_veh_sector,
    store:gsCgg_veh_sector,
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
        store:gsCgg_veh_sector,
        width:200
    })
    ],
    bbar:pgBarCgg_veh_sector,
    listeners:{
        rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
            if(!btnEditarCgg_veh_sector.hidden){
                btnEditarCgg_veh_sector.fireEvent('click', btnEditarCgg_veh_sector);
            }
        }
    }
});
gsCgg_veh_sector.reload({
    params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
});
/**
	  * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_veh_sector.
	  */
var winFrmListadoCgg_veh_sector = null;
if(inDesktop!==null && inDesktop!==undefined)
{
    var winFrmListadoCgg_veh_sector = new inDesktop.createWindow({
        id:'winFrmListadoCgg_veh_sector',
        title:tituloListadoCgg_veh_sector,
        tbar:getPanelTitulo(tituloListadoCgg_veh_sector,descListadoCgg_veh_sector),
        items:[grdCgg_veh_sector],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_veh_sector,btnEditarCgg_veh_sector,btnEliminarCgg_veh_sector,'->',btnSalirCgg_veh_sector]
    });
}else{
    var winFrmListadoCgg_veh_sector = new Ext.Window({
        id:'winFrmListadoCgg_veh_sector',
        title:tituloListadoCgg_veh_sector,
        tbar:getPanelTitulo(tituloListadoCgg_veh_sector,descListadoCgg_veh_sector),
        items:[grdCgg_veh_sector],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_veh_sector,btnEditarCgg_veh_sector,btnEliminarCgg_veh_sector,'->',btnSalirCgg_veh_sector]
    });
}
/**
	  * Funcion que aplica los privilegios del usuario.
	  */
applyGrants(winFrmListadoCgg_veh_sector.getBottomToolbar());
/**
	  * Funcion miembro que devuelve la ventana winFrmListadoCgg_veh_sector.
	  * @returns ventana winFrmCgg_veh_sector.
	  * @base FrmListadoCgg_veh_sector.prototype.show
	  */
this.getWindow = function(){
    return winFrmListadoCgg_veh_sector;
}
/**
	  * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_veh_sector.
	  * @base FrmListadoCgg_veh_sector.prototype.loadData
	  */
this.loadData = function(){
    gsCgg_veh_sector.load();
}
/**
	  * Funcion miembro que develve el ColumnModel utilizado en el listado.
	  */
this.getColumnModel = function(){
    return cmCgg_veh_sector;
}
/**
	  * Funcion miembro que develve el Store utilizado en el listado.
	  */
this.getStore = function(){
    return gsCgg_veh_sector;
}
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_veh_sector.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_veh_sector.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_veh_sector desde una instancia.
 */
FrmListadoCgg_veh_sector.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_veh_sector desde una instancia.
 */
FrmListadoCgg_veh_sector.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_veh_sector,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_veh_sector.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_veh_sector desde una instancia.
 */
FrmListadoCgg_veh_sector.prototype.loadData = function(){
    this.loadData();
}
