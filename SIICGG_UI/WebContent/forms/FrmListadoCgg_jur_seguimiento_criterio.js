/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_jur_seguimiento_criterio.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_jur_seguimiento_criterio(){    
    var urlListadoCgg_jur_seguimiento_criterio=URL_WS+"Cgg_jur_seguimiento_criterio";
    var tituloListadoCgg_jur_seguimiento_criterio='Jur seguimiento criterio';
    var descListadoCgg_jur_seguimiento_criterio='El formulario permite administrar informaci\u00f3n de la tabla Jur seguimiento criterio';
    /**
* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_jur_seguimiento_criterio.
*/
    var btnNuevoCgg_jur_seguimiento_criterio = new Ext.Button({
        id:'btnNuevoCgg_jur_seguimiento_criterio',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_jur_seguimiento_criterio = new FrmCgg_jur_seguimiento_criterio("insert");
                objCgg_jur_seguimiento_criterio.closeHandler(function(){
                    gsCgg_jur_seguimiento_criterio.reload();
                });
                objCgg_jur_seguimiento_criterio.show();
            }
        }
    });
/**
* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_jur_seguimiento_criterio.
*/
var btnEditarCgg_jur_seguimiento_criterio = new Ext.Button({
    id:'btnEditarCgg_jur_seguimiento_criterio',
    text:'Editar',
    iconCls:'iconEditar',
    listeners:{
        click:function(){
            var r=grdCgg_jur_seguimiento_criterio.getSelectionModel().getSelected();
            if(r){
                var objCgg_jur_seguimiento_criterio = new FrmCgg_jur_seguimiento_criterio("update",r);
                objCgg_jur_seguimiento_criterio.closeHandler(function(){
                    gsCgg_jur_seguimiento_criterio.reload();
                });
                objCgg_jur_seguimiento_criterio.loadData();
                objCgg_jur_seguimiento_criterio.show();
            }
        }
    }
});
/**
* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_jur_seguimiento_criterio.
*/
var btnEliminarCgg_jur_seguimiento_criterio = new Ext.Button({
    id:'btnEliminarCgg_jur_seguimiento_criterio',
    text:'Eliminar',
    iconCls:'iconEliminar',
    listeners:{
        click:function(){
            Ext.Msg.show({
                title:'Aviso',
                msg:'¿Seguro de eliminar el registro seleccionado?',
                buttons: Ext.Msg.YESNO,
                fn: SWRCgg_jur_seguimiento_criterio,
                icon: Ext.MessageBox.QUESTION
                });
            function SWRCgg_jur_seguimiento_criterio(btn){
                if (btn=='yes'){
                    try{
                        function CallBackCgg_jur_seguimiento_criterio(r){
                            winFrmListadoCgg_jur_seguimiento_criterio.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_jur_seguimiento_criterio,
                                    msg: 'La informaci\u00f3n de Jur seguimiento criterio ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_jur_seguimiento_criterio.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_jur_seguimiento_criterio,
                                    msg: 'La informaci\u00f3n de Jur seguimiento criterio no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                        }
                    winFrmListadoCgg_jur_seguimiento_criterio.getEl().mask('Eliminando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    param.add('inCjsgc_codigo',grdCgg_jur_seguimiento_criterio.getSelectionModel().getSelected().get('CJSGC_CODIGO'));
                    SOAPClient.invoke(urlListadoCgg_jur_seguimiento_criterio,"delete",param, true, CallBackCgg_jur_seguimiento_criterio);
                }catch(inErr){
                    winFrmListadoCgg_jur_seguimiento_criterio.getEl().unmask();
                }
            }
        }
}
}
});
/**
* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_jur_seguimiento_criterio.
*/
var btnSalirCgg_jur_seguimiento_criterio = new Ext.Button({
    id:'btnSalirCgg_jur_seguimiento_criterio',
    text:'Salir',
    iconCls:'iconSalir',
    listeners:{
        click:function(){
            winFrmListadoCgg_jur_seguimiento_criterio.close();
        }
    }
});
/**
* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_jur_seguimiento_criterio.
*/
var chkCjsgc_respuesta = new Ext.grid.CheckColumn(
{
    dataIndex:'CJSGC_RESPUESTA',
    header:'Respuesta',
    width:150,
    sortable:true
});

var cmCgg_jur_seguimiento_criterio = new Ext.grid.ColumnModel([
{
    dataIndex:'CJSGC_CODIGO',
    header:'Codigo',
    width:150,
    sortable:true
},
{
    dataIndex:'CRSEG_CODIGO',
    header:'Codigo',
    width:150,
    sortable:true
},
{
    dataIndex:'CJCRI_CODIGO',
    header:'Codigo',
    width:150,
    sortable:true
},
chkCjsgc_respuesta,
{
    dataIndex:'CJSGC_JUSTIFICACION',
    header:'Justificacion',
    width:150,
    sortable:true
},
{
    dataIndex:'CJSGC_OBSERVACION',
    header:'Observacion',
    width:150,
    sortable:true
},
{
    dataIndex:'CJSGC_NOMBRE_ADJUNTO',
    header:'Nombre adjunto',
    width:150,
    sortable:true
},
{
    dataIndex:'CJSGC_ADJUNTO',
    header:'Adjunto',
    width:150,
    sortable:true
}]);
/**
* Ext.data.Store Agrupacion de registros de la tabla Cgg_jur_seguimiento_criterio por un campo especifico.
*/
var gsCgg_jur_seguimiento_criterio = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_jur_seguimiento_criterio",
        method:"selectPage",
        pagin:true
    }),
    remoteSort:true,
    reader:new Ext.data.JsonReader({
        id:'CJSGC_CODIGO',
        root:'dataSet',
        totalProperty: 'totalCount'
    },[
    {
        name:'CJSGC_CODIGO'
    },

    {
        name:'CRSEG_CODIGO'
    },

    {
        name:'CJCRI_CODIGO'
    },

    {
        name:'CJSGC_RESPUESTA'
    },

    {
        name:'CJSGC_JUSTIFICACION'
    },

    {
        name:'CJSGC_OBSERVACION'
    },

    {
        name:'CJSGC_NOMBRE_ADJUNTO'
    },

    {
        name:'CJSGC_ADJUNTO'
    }
    ]),
    sortInfo:{
        field: 'CRSEG_CODIGO',
        direction: 'ASC'
    },
    baseParams:{
        keyword:"",
        format:'JSON'
    }
});
/**
* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_jur_seguimiento_criterio.
*/
var pgBarCgg_jur_seguimiento_criterio= new Ext.PagingToolbar({
    store: gsCgg_jur_seguimiento_criterio,
    displayInfo: true,
    pageSize:RECORD_PAGE,
    displayMsg: 'Mostrando {0} - {1} de {2}',
    temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_jur_seguimiento_criterio en un formato tabular de filas y columnas.
*/
var grdCgg_jur_seguimiento_criterio = new Ext.grid.GridPanel({
    cm:cmCgg_jur_seguimiento_criterio,
    store:gsCgg_jur_seguimiento_criterio,
    region:'center',
    sm:new Ext.grid.RowSelectionModel({
        singleSelect:true
    }),
    loadMask:{
        msg:"Cargando..."
    },
    tbar: [
    'Buscar: ',
    new Ext.ux.bsx.SearchField({
        store:gsCgg_jur_seguimiento_criterio,
        width:200
    })
    ],
    bbar:pgBarCgg_jur_seguimiento_criterio,
    listeners:{
        rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
            if(!btnEditarCgg_jur_seguimiento_criterio.hidden){
                btnEditarCgg_jur_seguimiento_criterio.fireEvent('click', btnEditarCgg_jur_seguimiento_criterio);
            }
        }
    }
});
gsCgg_jur_seguimiento_criterio.reload({
    params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
});
/**
* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_jur_seguimiento_criterio.
*/
var winFrmListadoCgg_jur_seguimiento_criterio = new Ext.Window({
    id:'winFrmListadoCgg_jur_seguimiento_criterio',
    title:tituloListadoCgg_jur_seguimiento_criterio,
    width:600,
    minWidth:600,
    height:400,
    minHeight:400,
    maximizable:true,
    minimizable:true,
    constrain:true,
    layout:'border',
    tbar:getPanelTitulo('Listado '+tituloListadoCgg_jur_seguimiento_criterio,descListadoCgg_jur_seguimiento_criterio),
    items:[grdCgg_jur_seguimiento_criterio],
    bbar:[btnNuevoCgg_jur_seguimiento_criterio,btnEditarCgg_jur_seguimiento_criterio,btnEliminarCgg_jur_seguimiento_criterio,'->',btnSalirCgg_jur_seguimiento_criterio]
});
/**
* Funcion que aplica los privilegios del usuario.
*/
applyGrants(winFrmListadoCgg_jur_seguimiento_criterio.getBottomToolbar());
/**
* Funcion miembro que devuelve la ventana winFrmListadoCgg_jur_seguimiento_criterio.
* @returns ventana winFrmCgg_jur_seguimiento_criterio.
* @base FrmListadoCgg_jur_seguimiento_criterio.prototype.show
*/
this.getWindow = function(){
    return winFrmListadoCgg_jur_seguimiento_criterio;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_jur_seguimiento_criterio.
* @base FrmListadoCgg_jur_seguimiento_criterio.prototype.loadData
*/
this.loadData = function(){
    gsCgg_jur_seguimiento_criterio.load();
}
/**
* Funcion miembro que develve el ColumnModel utilizado en el listado.
*/
this.getColumnModel = function(){
    return cmCgg_jur_seguimiento_criterio;
}
/**
* Funcion miembro que develve el Store utilizado en el listado.
*/
this.getStore = function(){
    return gsCgg_jur_seguimiento_criterio;
}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_jur_seguimiento_criterio.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_jur_seguimiento_criterio.prototype.getStore = function(){
    this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_jur_seguimiento_criterio desde una instancia.
*/
FrmListadoCgg_jur_seguimiento_criterio.prototype.show = function(){
    this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_jur_seguimiento_criterio desde una instancia.
*/
FrmListadoCgg_jur_seguimiento_criterio.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_jur_seguimiento_criterio,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_jur_seguimiento_criterio.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_jur_seguimiento_criterio desde una instancia.
*/
FrmListadoCgg_jur_seguimiento_criterio.prototype.loadData = function(){
    this.loadData();
}
