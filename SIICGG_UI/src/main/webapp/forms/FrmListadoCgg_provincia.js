/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_provincia.
 * @constructor 
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_provincia(inDesktop){    
	var optMenu = 'Configuraci\u00F3n/Distribuci\u00F3n geogr\u00E1fica/Administraci\u00F3n de provincia';
    var urlListadoCgg_provincia=URL_WS+"Cgg_provincia";
    var tituloListadoCgg_provincia='Listado provincia';
    var descListadoCgg_provincia='El formulario permite administrar informaci\u00f3n de la provincia';	
    /**
	 * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_provincia.
	 */
    var btnNuevoCgg_provincia = new Ext.Button({
        id:'btnNuevoCgg_provincia',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Nueva provincia',
        listeners:{
            click:function(){
                var objCgg_provincia = new FrmCgg_provincia("insert");
                objCgg_provincia.closeHandler(function(){
                    gsCgg_provincia.reload();
                });
                objCgg_provincia.show();
            }
        }
    });
    /**
	 * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_provincia.
	 */
    var btnEditarCgg_provincia = new Ext.Button({
        id:'btnEditarCgg_provincia',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:'Editar provincia',
        listeners:{
            click:function(){
                var r=grdCgg_provincia.getSelectionModel().getSelected();
                if(r){
                    var objCgg_provincia = new FrmCgg_provincia("update",r);
                    objCgg_provincia.closeHandler(function(){
                        gsCgg_provincia.reload();
                    });
                    objCgg_provincia.loadData();
                    objCgg_provincia.show();
                }
            }
        }
    });
    /**
	 * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_provincia.
	 */
    var btnEliminarCgg_provincia = new Ext.Button({
        id:'btnEliminarCgg_provincia',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:'Eliminar provincia',
        listeners:{
            click:function(){
                var r=grdCgg_provincia.getSelectionModel().getSelected();
                if(r){
                    function SWRCgg_provincia(btn){
                        if (btn=='yes'){
                            try{
                                function CallBackCgg_provincia(r){
                                    winFrmListadoCgg_provincia.getEl().unmask();
                                    if(r=='true'){
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_provincia,
                                            msg: 'La informaci\u00f3n de provincia ha sido eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });
                                        gsCgg_provincia.reload();
                                    }else{
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_provincia,
                                            msg: 'La informaci\u00f3n de provincia no ha podido ser eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.ERROR
                                        });
                                    }
                                }
                                winFrmListadoCgg_provincia.getEl().mask('Eliminando...', 'x-mask-loading');
                                var param = new SOAPClientParameters();
                                param.add('inCgprv_codigo',grdCgg_provincia.getSelectionModel().getSelected().get('CGPRV_CODIGO'));
                                SOAPClient.invoke(urlListadoCgg_provincia,"delete",param, true, CallBackCgg_provincia);
                            }catch(inErr){
                                winFrmListadoCgg_provincia.getEl().unmask();
                            }
                        }
                    }
                }
                Ext.Msg.show({
                    title:'Aviso',
                    msg:'Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_provincia,
                    icon: Ext.MessageBox.QUESTION
                });
            }
        }
    });
/**
	 * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_provincia.
	 */
var btnSalirCgg_provincia = new Ext.Button({
    id:'btnSalirCgg_provincia',
    text:'Salir',
    iconCls:'iconSalir',
    tooltip:'Salir del formulario',
    listeners:{
        click:function(){
            winFrmListadoCgg_provincia.close();
        }
    }
});
/**
	  * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_provincia.
	  */
var cmCgg_provincia = new Ext.grid.ColumnModel([    
{
    dataIndex:'CGPRV_CODIGO',
    header:'Codigo',
    width:150,
    sortable:true,
    hidden:true,
    hideable:false
},
{
    dataIndex:'CPAIS_CODIGO',
    header:'Pa\u00EDs',
    width:150,
    sortable:true,
    renderer:function(inCPAIS_CODIGO){
        var i =0;
        var result = 'no datos';
        for(i=0;i<SCGG_PAIS.getCount();i++){
            var rPais = SCGG_PAIS.getAt(i);
            if(rPais.get('CPAIS_CODIGO') == inCPAIS_CODIGO){
                result = rPais.get('CPAIS_NOMBRE');
                break;
            }
        }
        return result;
    }
},
{
    dataIndex:'CGPRV_NOMBRE',
    header:'Provincia',
    width:150,
    sortable:true
},
{
    dataIndex:'CGPRV_DESCRIPCION',
    header:'Descripci\u00F3n',
    width:150,
    sortable:true
}]);
/**
	  * Ext.data.Store Agrupacion de registros de la tabla Cgg_provincia por un campo especifico.
	  */
var gsCgg_provincia = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_provincia",
        method:"selectPage",
        pagin:true
    }),
    remoteSort:true,
    reader:new Ext.data.JsonReader({
        id:'CGPRV_CODIGO',
        root:'dataSet',
        totalProperty: 'totalCount'
    },[
    {
        name:'CGPRV_CODIGO'
    },

    {
        name:'CPAIS_CODIGO'
    },

    {
        name:'CGPRV_NOMBRE'
    },

    {
        name:'CGPRV_DESCRIPCION'
    }
    ]),
    sortInfo:{
        field: 'CPAIS_CODIGO',
        direction: 'ASC'
    },
    baseParams:{
        keyword:"",
        format:"JSON"
    }
});
/**
	  * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_provincia.
	  */
var pgBarCgg_provincia= new Ext.PagingToolbar({
    store: gsCgg_provincia,
    displayInfo: true,
    pageSize:RECORD_PAGE,
    displayMsg: 'Mostrando {0} - {1} de {2}',
    temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
	  * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_provincia en un formato tabular de filas y columnas.
	  */
var grdCgg_provincia = new Ext.grid.GridPanel({
    viewConfig:{
        forceFit:true
    },
    cm:cmCgg_provincia,
    store:gsCgg_provincia,
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
        store:gsCgg_provincia,
        width:200
    })
    ],
    bbar:pgBarCgg_provincia,
    listeners:{
        rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
            if(!btnEditarCgg_provincia.hidden){
                btnEditarCgg_provincia.fireEvent('click', btnEditarCgg_provincia);
            }
        }
    }
});
gsCgg_provincia.reload({
    params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
});
/**
	  * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_provincia.
	  */	 
var winFrmListadoCgg_provincia = null;
if(inDesktop!==null && inDesktop!==undefined)
{
    var winFrmListadoCgg_provincia = inDesktop.createWindow({
        id:'winFrmListadoCgg_provincia',
        title:tituloListadoCgg_provincia,
        tbar:getPanelTitulo(tituloListadoCgg_provincia,descListadoCgg_provincia),
        items:[grdCgg_provincia],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_provincia,btnEditarCgg_provincia,btnEliminarCgg_provincia,'->',btnSalirCgg_provincia]
    });
}else{
		 
    var winFrmListadoCgg_provincia = new Ext.Window({
        id:'winFrmListadoCgg_provincia',
        title:tituloListadoCgg_provincia,
        tbar:getPanelTitulo(tituloListadoCgg_provincia,descListadoCgg_provincia),
        items:[grdCgg_provincia],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_provincia,btnEditarCgg_provincia,btnEliminarCgg_provincia,'->',btnSalirCgg_provincia]
    });
		 
}
/**
	  * Funcion que aplica los privilegios del usuario.
	  */
applyGrants(winFrmListadoCgg_provincia.getBottomToolbar());
/**
	  * Funcion miembro que devuelve la ventana winFrmListadoCgg_provincia.
	  * @returns ventana winFrmCgg_provincia.
	  * @base FrmListadoCgg_provincia.prototype.show
	  */
this.getWindow = function(){
    return winFrmListadoCgg_provincia;
}
/**
	  * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_provincia.
	  * @base FrmListadoCgg_provincia.prototype.loadData
	  */
this.loadData = function(){
    gsCgg_provincia.load();
}
/**
	  * Funcion miembro que develve el ColumnModel utilizado en el listado.
	  */
this.getColumnModel = function(){
    return cmCgg_provincia;
}
/**
	  * Funcion miembro que develve el Store utilizado en el listado.
	  */
this.getStore = function(){
    return gsCgg_provincia;
}
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_provincia.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_provincia.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_provincia desde una instancia.
 */
FrmListadoCgg_provincia.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_provincia desde una instancia.
 */
FrmListadoCgg_provincia.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_provincia,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_provincia.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_provincia desde una instancia.
 */
FrmListadoCgg_provincia.prototype.loadData = function(){
    this.loadData();
}
