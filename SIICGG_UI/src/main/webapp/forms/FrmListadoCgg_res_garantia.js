/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_garantia.
 * @constructor 
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_garantia(inDesktop){
	var optMenu = 'Configuraci\u00F3n/Administraci\u00F3n de residencia/Administraci\u00F3n garant\u00EDa';
    var urlListadoCgg_res_garantia=URL_WS+"Cgg_res_garantia";
    var tituloListadoCgg_res_garantia='Listado de garant\u00EDa de residencia';
    var descListadoCgg_res_garantia='El formulario permite administrar informaci\u00f3n de garant\u00EDas a aplicarse a los tr\u00E1mites de residencia';
    /**
	 * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_garantia.
	 */
    var btnNuevoCgg_res_garantia = new Ext.Button({
        id:'btnNuevoCgg_res_garantia',
        text:'Nuevo',
        tooltip:'Nueva garant\u00EDa',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_garantia = new FrmCgg_res_garantia("insert");
                objCgg_res_garantia.closeHandler(function(){
                    gsCgg_res_garantia.reload();
                });
                objCgg_res_garantia.show();
            }
        }
    });
/**
	 * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_garantia.
	 */
var btnEditarCgg_res_garantia = new Ext.Button({
    id:'btnEditarCgg_res_garantia',
    text:'Editar',
    tooltip:'Editar garant\u00EDa',
    iconCls:'iconEditar',
    listeners:{
        click:function(){
            var r=grdCgg_res_garantia.getSelectionModel().getSelected();
            if(r){
                var objCgg_res_garantia = new FrmCgg_res_garantia("update",r);
                objCgg_res_garantia.closeHandler(function(){
                    gsCgg_res_garantia.reload();
                });
                objCgg_res_garantia.loadData();
                objCgg_res_garantia.show();
            }
        }
    }
});
/**
	 * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_garantia.
	 */
var btnEliminarCgg_res_garantia = new Ext.Button({
    id:'btnEliminarCgg_res_garantia',
    text:'Eliminar',
    tooltip:'Eliminar garant\u00EDa',
    iconCls:'iconEliminar',
    listeners:{
        click:function(){
            var r=grdCgg_res_garantia.getSelectionModel().getSelected();
            if(r){
		
                function SWRCgg_res_garantia(btn){
                    if (btn=='yes'){
                        try{
                            function CallBackCgg_res_garantia(r){
                                winFrmListadoCgg_res_garantia.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_res_garantia,
                                        msg: 'La informaci\u00f3n de garant\u00EDa ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_res_garantia.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_res_garantia,
                                        msg: 'La informaci\u00f3n de garant\u00EDa no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                        winFrmListadoCgg_res_garantia.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrgrt_codigo',grdCgg_res_garantia.getSelectionModel().getSelected().get('CRGRT_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_garantia,"delete",param, true, CallBackCgg_res_garantia);
                    }catch(inErr){
                        winFrmListadoCgg_res_garantia.getEl().unmask();
                    }
                }
            }
}
Ext.Msg.show({
    title:'Aviso',
    msg:'Est\u00e1 seguro de eliminar la garant\u00EDa?',
    buttons: Ext.Msg.YESNO,
    fn: SWRCgg_res_garantia,
    icon: Ext.MessageBox.QUESTION
    });
}
}
});
/**
	 * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_garantia.
	 */
var btnSalirCgg_res_garantia = new Ext.Button({
    id:'btnSalirCgg_res_garantia',
    text:'Salir',
    tooltip:'Salir del formulario garant\u00EDa',
    iconCls:'iconSalir',
    listeners:{
        click:function(){
            winFrmListadoCgg_res_garantia.close();
        }
    }
});
/**
	  * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_garantia.
	  */
var cmCgg_res_garantia = new Ext.grid.ColumnModel([
{
    dataIndex:'CRGRT_CODIGO',
    header:'Codigo',
    width:150,
    sortable:true,
    hidden:true,
    hideable:false
},
{
    dataIndex:'CRGRT_DESCRPCION',
    header:'Descripci\u00F3n',
    width:150,
    sortable:true
},
{
    dataIndex:'CRGRT_VALOR',
    header:'Valor',
    width:150,
    sortable:true
}]);
/**
	  * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_garantia por un campo especifico.
	  */
var gsCgg_res_garantia = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_res_garantia",
        method:"selectPage",
        pagin:true
    }),
    remoteSort:true,
    reader:new Ext.data.JsonReader({
        id:'CRGRT_CODIGO',
        root:'dataSet',
        totalProperty: 'totalCount'
    },[
    {
        name:'CRGRT_CODIGO'
    },

    {
        name:'CRGRT_DESCRPCION'
    },

    {
        name:'CRGRT_VALOR'
    }
    ]),
    sortInfo:{
        field: 'CRGRT_DESCRPCION',
        direction: 'ASC'
    },
    baseParams:{
        keyword:"",
        format:"JSON"
    }
});
/**
	  * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_garantia.
	  */
var pgBarCgg_res_garantia= new Ext.PagingToolbar({
    store: gsCgg_res_garantia,
    displayInfo: true,
    pageSize:RECORD_PAGE,
    displayMsg: 'Mostrando {0} - {1} de {2}',
    temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
	  * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_garantia en un formato tabular de filas y columnas.
	  */
var grdCgg_res_garantia = new Ext.grid.GridPanel({
    viewConfig:{forceFit:true},
    cm:cmCgg_res_garantia,
    store:gsCgg_res_garantia,
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
        store:gsCgg_res_garantia,
        width:200
    })
    ],
    bbar:pgBarCgg_res_garantia,
    listeners:{
        rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
            if(!btnEditarCgg_res_garantia.hidden){
                btnEditarCgg_res_garantia.fireEvent('click', btnEditarCgg_res_garantia);
            }
        }
    }
});
gsCgg_res_garantia.reload({
    params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
});
/**
	  * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_garantia.
	  */
var winFrmListadoCgg_res_garantia = null;
if(inDesktop!==null && inDesktop!==undefined)
{
    var winFrmListadoCgg_res_garantia = inDesktop.createWindow({
        id:'winFrmListadoCgg_res_garantia',
        title:tituloListadoCgg_res_garantia,
        tbar:getPanelTitulo(tituloListadoCgg_res_garantia,descListadoCgg_res_garantia),
        items:[grdCgg_res_garantia],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_res_garantia,btnEditarCgg_res_garantia,btnEliminarCgg_res_garantia,'->',btnSalirCgg_res_garantia]
    });
}else{
    var winFrmListadoCgg_res_garantia = new Ext.Window({
        id:'winFrmListadoCgg_res_garantia',
        title:tituloListadoCgg_res_garantia,
        tbar:getPanelTitulo(tituloListadoCgg_res_garantia,descListadoCgg_res_garantia),
        items:[grdCgg_res_garantia],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_res_garantia,btnEditarCgg_res_garantia,btnEliminarCgg_res_garantia,'->',btnSalirCgg_res_garantia]
    });
}
/**
	  * Funcion que aplica los privilegios del usuario.
	  */
applyGrants(winFrmListadoCgg_res_garantia.getBottomToolbar());
/**
	  * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_garantia.
	  * @returns ventana winFrmCgg_res_garantia.
	  * @base FrmListadoCgg_res_garantia.prototype.show
	  */
this.getWindow = function(){
    return winFrmListadoCgg_res_garantia;
}
/**
	  * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_garantia.
	  * @base FrmListadoCgg_res_garantia.prototype.loadData
	  */
this.loadData = function(){
    gsCgg_res_garantia.load();
}
/**
	  * Funcion miembro que develve el ColumnModel utilizado en el listado.
	  */
this.getColumnModel = function(){
    return cmCgg_res_garantia;
}
/**
	  * Funcion miembro que develve el Store utilizado en el listado.
	  */
this.getStore = function(){
    return gsCgg_res_garantia;
}
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_garantia.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_garantia.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_garantia desde una instancia.
 */
FrmListadoCgg_res_garantia.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_garantia desde una instancia.
 */
FrmListadoCgg_res_garantia.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_garantia,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_garantia.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_garantia desde una instancia.
 */
FrmListadoCgg_res_garantia.prototype.loadData = function(){
    this.loadData();
}
