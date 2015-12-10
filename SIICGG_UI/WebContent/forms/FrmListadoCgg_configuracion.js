/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_configuracion.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_configuracion(inDesktop){
	var optMenu = 'Configuraci\u00f3n/Administraci\u00f3n par\u00E1metros configuraci\u00F3n';
    var urlListadoCgg_configuracion=URL_WS+"Cgg_configuracion";
    var tituloListadoCgg_configuracion='Listado de parametros de configuraci\u00f3n';
    var descListadoCgg_configuracion='El formulario permite administrar informaci\u00f3n de parametros de configuraci\u00f3n de todo el SIICGG';
    /**
* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_configuracion.
*/
    var btnNuevoCgg_configuracion = new Ext.Button({
        id:'btnNuevoCgg_configuracion',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_configuracion = new FrmCgg_configuracion("insert");
                objCgg_configuracion.closeHandler(function(){
                    gsCgg_configuracion.reload();
                });
                objCgg_configuracion.show();
            }
        }
    });
    /**
* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_configuracion.
*/
    var btnEditarCgg_configuracion = new Ext.Button({
        id:'btnEditarCgg_configuracion',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_configuracion.getSelectionModel().getSelected();
                if(r){
                    var objCgg_configuracion = new FrmCgg_configuracion("update",r);
                    objCgg_configuracion.closeHandler(function(){
                        gsCgg_configuracion.reload();
                    });
                    objCgg_configuracion.loadData();
                    objCgg_configuracion.show();
                }
            }
        }
    });
    /**
* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_configuracion.
*/
    var btnEliminarCgg_configuracion = new Ext.Button({
        id:'btnEliminarCgg_configuracion',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({
                    title:'Aviso',
                    msg:'Est\u00e1 seguro de eliminar?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_configuracion,
                    icon: Ext.MessageBox.QUESTION
                });
                function SWRCgg_configuracion(btn){
                    if (btn=='yes'){
                        try{
                            function CallBackCgg_configuracion(r){
                                winFrmListadoCgg_configuracion.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_configuracion,
                                        msg: 'La informaci\u00f3n de Configuracion ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_configuracion.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_configuracion,
                                        msg: 'La informaci\u00f3n de configuracion no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_configuracion.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCgcnf_codigo',grdCgg_configuracion.getSelectionModel().getSelected().get('CGCNF_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_configuracion,"delete",param, true, CallBackCgg_configuracion);
                        }catch(inErr){
                            winFrmListadoCgg_configuracion.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_configuracion.
*/
    var btnSalirCgg_configuracion = new Ext.Button({
        id:'btnSalirCgg_configuracion',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_configuracion.close();
            }
        }
    });
   
    /**
* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_configuracion.
*/
    var cmCgg_configuracion = new Ext.grid.ColumnModel([
    {
        dataIndex:'CGCNF_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CGCNF_CONFIGURACION',
        header:'Configuracion',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CGCNF_VALOR_CADENA',
        header:'Valor cadena',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CGCNF_VALOR_NUMERICO',
        header:'Valor numerico',
        width:150,
        sortable:true
    }]);
    /**
* Ext.data.Store Agrupacion de registros de la tabla Cgg_configuracion por un campo especifico.
*/
    var gsCgg_configuracion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_configuracion",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CGCNF_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CGCNF_CODIGO'
        },

        {
            name:'CGCNF_CONFIGURACION'
        },

        {
            name:'CGCNF_VALOR_CADENA'
        },

        {
            name:'CGCNF_VALOR_NUMERICO'
        }
        ]),
        sortInfo:{
            field: 'CGCNF_CONFIGURACION',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    /**
* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_configuracion.
*/
    var pgBarCgg_configuracion= new Ext.PagingToolbar({
        store: gsCgg_configuracion,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_configuracion en un formato tabular de filas y columnas.
*/
    var grdCgg_configuracion = new Ext.grid.GridPanel({
        cm:cmCgg_configuracion,
        store:gsCgg_configuracion,
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
            store:gsCgg_configuracion,
            width:200
        })
        ],
        bbar:pgBarCgg_configuracion,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_configuracion.hidden){
                    btnEditarCgg_configuracion.fireEvent('click', btnEditarCgg_configuracion);
                }
            }
        }
    });
    gsCgg_configuracion.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON"
        }
    });

    /**
* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_configuracion.
*/
    var winFrmListadoCgg_configuracion = null;
    
    if(inDesktop !== null && inDesktop !== undefined){
        winFrmListadoCgg_configuracion = new inDesktop.createWindow({
            id:'winFrmListadoCgg_configuracion',
            title:tituloListadoCgg_configuracion,
            tbar:getPanelTitulo(tituloListadoCgg_configuracion,descListadoCgg_configuracion),
            items:[grdCgg_configuracion],
            iconCls:'iconConfiguracion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_configuracion,btnEditarCgg_configuracion,btnEliminarCgg_configuracion,'->',btnSalirCgg_configuracion]
        }); 
    }else{
        winFrmListadoCgg_configuracion = new Ext.Window({        
            id:'winFrmListadoCgg_configuracion',
            title:tituloListadoCgg_configuracion,
            tbar:getPanelTitulo(tituloListadoCgg_configuracion,descListadoCgg_configuracion),
            items:[grdCgg_configuracion],
            iconCls:'iconConfiguracion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_configuracion,btnEditarCgg_configuracion,btnEliminarCgg_configuracion,'->',btnSalirCgg_configuracion]
        });
    }

    /**
* Funcion que aplica los privilegios del usuario.
*/
    applyGrants(winFrmListadoCgg_configuracion.getBottomToolbar());
    /**
* Funcion miembro que devuelve la ventana winFrmListadoCgg_configuracion.
* @returns ventana winFrmCgg_configuracion.
* @base FrmListadoCgg_configuracion.prototype.show
*/
    this.getWindow = function(){
        return winFrmListadoCgg_configuracion;
    }
    /**
* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_configuracion.
* @base FrmListadoCgg_configuracion.prototype.loadData
*/
    this.loadData = function(){
        gsCgg_configuracion.load();
    }
    /**
* Funcion miembro que develve el ColumnModel utilizado en el listado.
*/
    this.getColumnModel = function(){
        return cmCgg_configuracion;
    }
    /**
* Funcion miembro que develve el Store utilizado en el listado.
*/
    this.getStore = function(){
        return gsCgg_configuracion;
    }
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_configuracion.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_configuracion.prototype.getStore = function(){
    this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_configuracion desde una instancia.
*/
FrmListadoCgg_configuracion.prototype.show = function(){
    this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_configuracion desde una instancia.
*/
FrmListadoCgg_configuracion.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_configuracion,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_configuracion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_configuracion desde una instancia.
*/
FrmListadoCgg_configuracion.prototype.loadData = function(){
    this.loadData();
}
