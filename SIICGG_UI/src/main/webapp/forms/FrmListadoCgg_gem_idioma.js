/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_idioma.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_gem_idioma(inDesktop){
    var optMenu = 'Configuraci\u00F3n/Administraci\u00F3n de persona/Idiomas';
    var urlListadoCgg_gem_idioma=URL_WS+"Cgg_gem_idioma";
    var tituloListadoCgg_gem_idioma='Listado idiomas';
    var descListadoCgg_gem_idioma='El formulario permite administrar informaci\u00f3n sobre los diferentes idiomas';
    /**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_idioma.
	*/
    var btnNuevoCgg_gem_idioma = new Ext.Button({
        id:'btnNuevoCgg_gem_idioma',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_gem_idioma = new FrmCgg_gem_idioma("insert");
                objCgg_gem_idioma.closeHandler(function(){
                    gsCgg_gem_idioma.reload();
                });
                objCgg_gem_idioma.show();
            }
        }
    });
/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_idioma.
	*/
var btnEditarCgg_gem_idioma = new Ext.Button({
    id:'btnEditarCgg_gem_idioma',
    text:'Editar',
    iconCls:'iconEditar',
    listeners:{
        click:function(){
            var r=grdCgg_gem_idioma.getSelectionModel().getSelected();
            if(r){
                var objCgg_gem_idioma = new FrmCgg_gem_idioma("update",r);
                objCgg_gem_idioma.closeHandler(function(){
                    gsCgg_gem_idioma.reload();
                });
                objCgg_gem_idioma.loadData();
                objCgg_gem_idioma.show();
            }
        }
    }
});
/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_gem_idioma.
	*/
var btnEliminarCgg_gem_idioma = new Ext.Button({
    id:'btnEliminarCgg_gem_idioma',
    text:'Eliminar',
    iconCls:'iconEliminar',
    listeners:{
        click:function(){
            Ext.Msg.show({
                title:'Aviso',
                msg:'Est\u00E1 seguro de eliminar?',
                buttons: Ext.Msg.YESNO,
                fn: SWRCgg_gem_idioma,
                icon: Ext.MessageBox.QUESTION
                });
            function SWRCgg_gem_idioma(btn){
                if (btn=='yes'){
                    try{
                        function CallBackCgg_gem_idioma(r){
                            winFrmListadoCgg_gem_idioma.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_gem_idioma,
                                    msg: 'La informaci\u00F3n sobre el idioma ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_gem_idioma.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_gem_idioma,
                                    msg: 'La informaci\u00F3n sobre el idioma no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                        }
                    winFrmListadoCgg_gem_idioma.getEl().mask('Eliminando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    param.add('inCgidm_codigo',grdCgg_gem_idioma.getSelectionModel().getSelected().get('CGIDM_CODIGO'));
                    SOAPClient.invoke(urlListadoCgg_gem_idioma,"delete",param, true, CallBackCgg_gem_idioma);
                }catch(inErr){
                    winFrmListadoCgg_gem_idioma.getEl().unmask();
                }
            }
        }
}
}
});
/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_idioma.
	*/
var btnSalirCgg_gem_idioma = new Ext.Button({
    id:'btnSalirCgg_gem_idioma',
    text:'Salir',
    iconCls:'iconSalir',
    listeners:{
        click:function(){
            winFrmListadoCgg_gem_idioma.close();
        }
    }
});
/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_idioma.
	*/
var cmCgg_gem_idioma = new Ext.grid.ColumnModel([
{
    dataIndex:'CGIDM_CODIGO',
    header:'Codigo',
    width:150,
    sortable:true,
    hidden:true
},
{
    dataIndex:'CGIDM_NOMBRE',
    header:'Nombre',
    width:150,
    sortable:true
}]);
/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_idioma por un campo especifico.
	*/
var gsCgg_gem_idioma = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_gem_idioma",
        method:"selectPage",
        pagin:true
    }),
    remoteSort:true,
    reader:new Ext.data.JsonReader({
        id:'CGIDM_CODIGO',
        root:'dataSet',
        totalProperty: 'totalCount'
    },[
    {
        name:'CGIDM_CODIGO'
    },

    {
        name:'CGIDM_NOMBRE'
    }
    ]),
    sortInfo:{
        field: 'CGIDM_NOMBRE',
        direction: 'ASC'
    },
    baseParams:{
        keyword:"",
        format:"JSON"
    }
});
/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_gem_idioma.
	*/
var pgBarCgg_gem_idioma= new Ext.PagingToolbar({
    store: gsCgg_gem_idioma,
    displayInfo: true,
    pageSize:RECORD_PAGE,
    displayMsg: 'Mostrando {0} - {1} de {2}',
    temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_idioma en un formato tabular de filas y columnas.
	*/
var grdCgg_gem_idioma = new Ext.grid.GridPanel({
    cm:cmCgg_gem_idioma,
    store:gsCgg_gem_idioma,
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
        store:gsCgg_gem_idioma,
        width:200
    })
    ],
    bbar:pgBarCgg_gem_idioma,
    listeners:{
        rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
            if(!btnEditarCgg_gem_idioma.hidden){
                btnEditarCgg_gem_idioma.fireEvent('click', btnEditarCgg_gem_idioma);
            }
        }
    }
});
gsCgg_gem_idioma.reload({
    params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
});
/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gem_idioma.
	*/
var winFrmListadoCgg_gem_idioma = null;

if(inDesktop !== null && inDesktop !==undefined){
    winFrmListadoCgg_gem_idioma = inDesktop.createWindow({
        id:'winFrmListadoCgg_gem_idioma',
        title:tituloListadoCgg_gem_idioma,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_gem_idioma,descListadoCgg_gem_idioma),
        items:[grdCgg_gem_idioma],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrainHeader:true,
        layout:'border',
        bbar:[btnNuevoCgg_gem_idioma,btnEditarCgg_gem_idioma,btnEliminarCgg_gem_idioma,'->',btnSalirCgg_gem_idioma]
    });
}else{
    winFrmListadoCgg_gem_idioma = new Ext.Window({
        id:'winFrmListadoCgg_gem_idioma',
        title:tituloListadoCgg_gem_idioma,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_gem_idioma,descListadoCgg_gem_idioma),
        items:[grdCgg_gem_idioma],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrainHeader:true,
        layout:'border',
        bbar:[btnNuevoCgg_gem_idioma,btnEditarCgg_gem_idioma,btnEliminarCgg_gem_idioma,'->',btnSalirCgg_gem_idioma]
    });
}
           
/**
	* Funcion que aplica los privilegios del usuario.
	*/
applyGrants(winFrmListadoCgg_gem_idioma.getBottomToolbar());
/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_idioma.
	* @returns ventana winFrmCgg_gem_idioma.
	* @base FrmListadoCgg_gem_idioma.prototype.show
	*/
this.getWindow = function(){
    return winFrmListadoCgg_gem_idioma;
}
/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gem_idioma.
	* @base FrmListadoCgg_gem_idioma.prototype.loadData
	*/
this.loadData = function(){
    gsCgg_gem_idioma.load();
}
/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
this.getColumnModel = function(){
    return cmCgg_gem_idioma;
}
/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
this.getStore = function(){
    return gsCgg_gem_idioma;
}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_gem_idioma.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_gem_idioma.prototype.getStore = function(){
    this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_idioma desde una instancia.
*/
FrmListadoCgg_gem_idioma.prototype.show = function(){
    this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_idioma desde una instancia.
*/
FrmListadoCgg_gem_idioma.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_idioma,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_gem_idioma.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gem_idioma desde una instancia.
*/
FrmListadoCgg_gem_idioma.prototype.loadData = function(){
    this.loadData();
}
