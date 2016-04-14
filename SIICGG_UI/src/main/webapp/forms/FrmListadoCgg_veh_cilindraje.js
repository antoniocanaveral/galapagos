/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_veh_cilindraje.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_veh_cilindraje(inDesktop){
    var optMenu = 'Vehiculos/Configuraci\u00f3n/Cilindraje';
    var urlListadoCgg_veh_cilindraje=URL_WS+"Cgg_veh_cilindraje";
    var tituloListadoCgg_veh_cilindraje='Listado de cilindrajes';
    var descListadoCgg_veh_cilindraje='El formulario permite administrar informaci\u00f3n de los cilindrajes los vehiculos.';
    /**
* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_veh_cilindraje.
*/
    var btnNuevoCgg_veh_cilindraje = new Ext.Button({
        id:'btnNuevoCgg_veh_cilindraje',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Nuevo cilindraje',
        listeners:{
            click:function(){
                var objCgg_veh_cilindraje = new FrmCgg_veh_cilindraje("insert");
                objCgg_veh_cilindraje.closeHandler(function(){
                    gsCgg_veh_cilindraje.reload();
                });
                objCgg_veh_cilindraje.show();
            }
        }
    });
/**
* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_veh_cilindraje.
*/
var btnEditarCgg_veh_cilindraje = new Ext.Button({
    id:'btnEditarCgg_veh_cilindraje',
    text:'Editar',
    iconCls:'iconEditar',
    tooltip:'Editar cilindraje',
    listeners:{
        click:function(){
            var r=grdCgg_veh_cilindraje.getSelectionModel().getSelected();
            if(r){
                var objCgg_veh_cilindraje = new FrmCgg_veh_cilindraje("update",r);
                objCgg_veh_cilindraje.closeHandler(function(){
                    gsCgg_veh_cilindraje.reload();
                });
                objCgg_veh_cilindraje.loadData();
                objCgg_veh_cilindraje.show();
            }
        }
    }
});
/**
* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_veh_cilindraje.
*/
var btnEliminarCgg_veh_cilindraje = new Ext.Button({
    id:'btnEliminarCgg_veh_cilindraje',
    text:'Eliminar',
    iconCls:'iconEliminar',
    tooltip:'Eliminar cilindraje',
    listeners:{
        click:function(){
            Ext.Msg.show({
                title:'Aviso',
                msg:'Seguro de eliminar el registro seleccionado?',
                buttons: Ext.Msg.YESNO,
                fn: SWRCgg_veh_cilindraje,
                icon: Ext.MessageBox.QUESTION
                });
            function SWRCgg_veh_cilindraje(btn){
                if (btn=='yes'){
                    try{
                        function CallBackCgg_veh_cilindraje(r){
                            winFrmListadoCgg_veh_cilindraje.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_veh_cilindraje,
                                    msg: 'La informaci\u00f3n de cilindraje ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_veh_cilindraje.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_veh_cilindraje,
                                    msg: 'La informaci\u00f3n de cilindraje no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                        }
                    winFrmListadoCgg_veh_cilindraje.getEl().mask('Eliminando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    param.add('inCvcln_codigo',grdCgg_veh_cilindraje.getSelectionModel().getSelected().get('CVCLN_CODIGO'));
                    SOAPClient.invoke(urlListadoCgg_veh_cilindraje,"delete",param, true, CallBackCgg_veh_cilindraje);
                }catch(inErr){
                    winFrmListadoCgg_veh_cilindraje.getEl().unmask();
                }
            }
        }
}
}
});
/**
* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_veh_cilindraje.
*/
var btnSalirCgg_veh_cilindraje = new Ext.Button({
    id:'btnSalirCgg_veh_cilindraje',
    text:'Salir',
    iconCls:'iconSalir',
    tooltip:'Salir del formulario',
    listeners:{
        click:function(){
            winFrmListadoCgg_veh_cilindraje.close();
        }
    }
});
/**
* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_veh_cilindraje.
*/
var cmCgg_veh_cilindraje = new Ext.grid.ColumnModel([
{
    dataIndex:'CVCLN_CILINDRAJE',
    header:'Cilindraje',
    width:80,
    sortable:true
},
{
    dataIndex:'CVCLN_OBSERVACION',
    header:'Observaci\u00f3n',
    width:150,
    sortable:true
}]);
/**
* Ext.data.Store Agrupacion de registros de la tabla Cgg_veh_cilindraje por un campo especifico.
*/
var gsCgg_veh_cilindraje = new Ext.data.Store({
    proxy:new Ext.ux.bsx.SoapProxy({
        url:URL_WS+"Cgg_veh_cilindraje",
        method:"selectPage",
        pagin:true
    }),
    remoteSort:true,
    reader:new Ext.data.JsonReader({
        id:'CVCLN_CODIGO',
        root:'dataSet',
        totalProperty: 'totalCount'
    },[
    {
        name:'CVCLN_CODIGO'
    },

    {
        name:'CVCLN_CILINDRAJE'
    },

    {
        name:'CVCLN_OBSERVACION'
    }
    ]),
    sortInfo:{
        field: 'CVCLN_CILINDRAJE',
        direction: 'ASC'
    },
    baseParams:{
        keyword:'',
        format:'JSON'
    }
});
/**
* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_veh_cilindraje.
*/
var pgBarCgg_veh_cilindraje= new Ext.PagingToolbar({
    store: gsCgg_veh_cilindraje,
    displayInfo: true,
    pageSize:RECORD_PAGE,
    displayMsg: 'Mostrando {0} - {1} de {2}',
    temptyMsg: 'No hay informaci\u00f3n para mostrar'
});
/**
* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_veh_cilindraje en un formato tabular de filas y columnas.
*/
var grdCgg_veh_cilindraje = new Ext.grid.GridPanel({
    cm:cmCgg_veh_cilindraje,
    store:gsCgg_veh_cilindraje,
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
        store:gsCgg_veh_cilindraje,
        width:200
    })
    ],
    bbar:pgBarCgg_veh_cilindraje,
    listeners:{
        rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
            if(!btnEditarCgg_veh_cilindraje.hidden){
                btnEditarCgg_veh_cilindraje.fireEvent('click', btnEditarCgg_veh_cilindraje);
            }
        }
    }
});

	if(inDesktop){
		gsCgg_veh_cilindraje.reload({
			params:{
				start:0,
				limit:RECORD_PAGE,
				format:"JSON"
			}
		});
		/**
		* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_veh_cilindraje.
		*/
		var winFrmListadoCgg_veh_cilindraje = inDesktop.createWindow({
			id:'winFrmListadoCgg_veh_cilindraje',
			title:tituloListadoCgg_veh_cilindraje,
			tbar:getPanelTitulo(tituloListadoCgg_veh_cilindraje,descListadoCgg_veh_cilindraje),
			items:[grdCgg_veh_cilindraje],
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			layout:'border',
			bbar:[btnNuevoCgg_veh_cilindraje,btnEditarCgg_veh_cilindraje,btnEliminarCgg_veh_cilindraje,'->',btnSalirCgg_veh_cilindraje]
		});
		/**
		* Funcion que aplica los privilegios del usuario.
		*/
		applyGrants(winFrmListadoCgg_veh_cilindraje.getBottomToolbar());
	}
/**
* Funcion miembro que devuelve la ventana winFrmListadoCgg_veh_cilindraje.
* @returns ventana winFrmCgg_veh_cilindraje.
* @base FrmListadoCgg_veh_cilindraje.prototype.show
*/
this.getWindow = function(){
    return winFrmListadoCgg_veh_cilindraje;
}
/**
* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_veh_cilindraje.
* @base FrmListadoCgg_veh_cilindraje.prototype.loadData
*/
this.loadData = function(){
    gsCgg_veh_cilindraje.load();
}
/**
* Funcion miembro que develve el ColumnModel utilizado en el listado.
*/
this.getColumnModel = function(){
    return cmCgg_veh_cilindraje;
}
/**
* Funcion miembro que develve el Store utilizado en el listado.
*/
this.getStore = function(){
    return gsCgg_veh_cilindraje;
}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_veh_cilindraje.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_veh_cilindraje.prototype.getStore = function(){
    this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_veh_cilindraje desde una instancia.
*/
FrmListadoCgg_veh_cilindraje.prototype.show = function(){
    this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_veh_cilindraje desde una instancia.
*/
FrmListadoCgg_veh_cilindraje.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_veh_cilindraje,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_veh_cilindraje.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_veh_cilindraje desde una instancia.
*/
FrmListadoCgg_veh_cilindraje.prototype.loadData = function(){
    this.loadData();
}
