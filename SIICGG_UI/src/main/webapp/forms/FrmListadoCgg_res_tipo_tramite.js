/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_tipo_tramite.
 * @param inDesktop Escritorio web de la aplicacion.
 * @constructor 
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_tipo_tramite(inDesktop){    
	var optMenu = 'Configuraci\u00F3n/Administraci\u00F3n de residencia/Administraci\u00F3n tipo de tr\u00E1mites';
    var urlListadoCgg_res_tipo_tramite=URL_WS+"Cgg_res_tipo_tramite";
    var tituloListadoCgg_res_tipo_tramite='Administraci\u00f3n de tipos de tr\u00E1mite';
    var descListadoCgg_res_tipo_tramite='El formulario permite administrar informaci\u00f3n de tipos de tr\u00E1mites.';
    /**
	 * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_tipo_tramite.
	 */
    var btnNuevoCgg_res_tipo_tramite = new Ext.Button({
        id:'btnNuevoCgg_res_tipo_tramite',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Nuevo tipo tr\u00E1mite',
        listeners:{
            click:function(){
                var objCgg_res_tipo_tramite = new FrmCgg_res_tipo_tramite("insert");
                objCgg_res_tipo_tramite.closeHandler(function(){
                    gsCgg_res_tipo_tramite.reload();
                });
                objCgg_res_tipo_tramite.show();
            }
        }
    });
    /**
	 * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_tipo_tramite.
	 */
    var btnEditarCgg_res_tipo_tramite = new Ext.Button({
        id:'btnEditarCgg_res_tipo_tramite',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:'Editar tipo tr\u00E1mite',
        listeners:{
            click:function(){
                var r=grdCgg_res_tipo_tramite.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_tipo_tramite = new FrmCgg_res_tipo_tramite("update",r);
                    objCgg_res_tipo_tramite.closeHandler(function(){
                        gsCgg_res_tipo_tramite.reload();
                    });
                    objCgg_res_tipo_tramite.loadData();
                    objCgg_res_tipo_tramite.show();
                }
            }
        }
    });
    /**
	 * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_tipo_tramite.
	 */
    var btnEliminarCgg_res_tipo_tramite = new Ext.Button({
        id:'btnEliminarCgg_res_tipo_tramite',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:'Eliminar tipo tr\u00E1mite',
        listeners:{
            click:function(){
                var r=grdCgg_res_tipo_tramite.getSelectionModel().getSelected();
                if(r){                
                    function SWRCgg_res_tipo_tramite(btn){
                        if (btn=='yes'){
                            try{
                                function CallBackCgg_res_tipo_tramite(r){
                                    winFrmListadoCgg_res_tipo_tramite.getEl().unmask();
                                    if(r=='true'){
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_res_tipo_tramite,
                                            msg: 'El tipo de tr\u00E1mite ha sido eliminado.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });
                                        gsCgg_res_tipo_tramite.reload();
                                    }else{
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_res_tipo_tramite,
                                            msg: 'El tipo de tr\u00E1mite no ha sido eliminado.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.ERROR
                                        });
                                    }
                                }
                                winFrmListadoCgg_res_tipo_tramite.getEl().mask('Eliminando...', 'x-mask-loading');
                                var param = new SOAPClientParameters();
                                param.add('inCrtpt_codigo',grdCgg_res_tipo_tramite.getSelectionModel().getSelected().get('CRTPT_CODIGO'));
                                SOAPClient.invoke(urlListadoCgg_res_tipo_tramite,"delete",param, true, CallBackCgg_res_tipo_tramite);
                            }catch(inErr){
                                winFrmListadoCgg_res_tipo_tramite.getEl().unmask();
                            }
                        }
                    }

                    Ext.Msg.show({
                        title:tituloListadoCgg_res_tipo_tramite,
                        msg:'Est\u00e1 seguro de eliminar el tipo de tr\u00E1mite seleccionado?',
                        buttons: Ext.Msg.YESNO,
                        fn: SWRCgg_res_tipo_tramite,
                        icon: Ext.MessageBox.QUESTION
                    });
                
                }
            }
        }
    });
    /**
	 * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_tipo_tramite.
	 */
    var btnSalirCgg_res_tipo_tramite = new Ext.Button({
        id:'btnSalirCgg_res_tipo_tramite',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Salir del formulario',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_tipo_tramite.close();
            }
        }
    });
    /**
	  * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_tipo_tramite.
	  */
    var cmCgg_res_tipo_tramite = new Ext.grid.ColumnModel([
        {dataIndex:'CRTPT_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CRTPT_NOMBRE',header:'Nombre',width:150,sortable:true},
		{dataIndex:'CRTPT_ABREVIATURA',header:'Abreviatura',width:70,sortable:true},
		{dataIndex:'CRTPT_INDICE',header:'Indice',width:50,sortable:true},
        {dataIndex:'CRTPT_OBSERVACIONES',header:'Observaciones',width:200,sortable:true}
        ]);
    /**
	  * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_tipo_tramite por un campo especifico.
	  */
    var gsCgg_res_tipo_tramite = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_tipo_tramite",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRTPT_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {name:'CRTPT_CODIGO'},
        {name:'CRTPT_NOMBRE'},
		{name:'CRTPT_ABREVIATURA'},
		{name:'CRTPT_INDICE'},
        {name:'CRTPT_OBSERVACIONES'}
        ]),
        sortInfo:{
            field: 'CRTPT_NOMBRE',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    /**
	  * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_tipo_tramite.
	  */
    var pgBarCgg_res_tipo_tramite= new Ext.PagingToolbar({
        store: gsCgg_res_tipo_tramite,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
	  * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_tipo_tramite en un formato tabular de filas y columnas.
	  */
    var grdCgg_res_tipo_tramite = new Ext.grid.GridPanel({
        viewConfig: {
            forceFit: true
        },
        cm:cmCgg_res_tipo_tramite,
        store:gsCgg_res_tipo_tramite,
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
            store:gsCgg_res_tipo_tramite,
            width:200
        })
        ],
        bbar:pgBarCgg_res_tipo_tramite,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_tipo_tramite.hidden){
                    btnEditarCgg_res_tipo_tramite.fireEvent('click', btnEditarCgg_res_tipo_tramite);
                }
            }
        }
    });
    gsCgg_res_tipo_tramite.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON"
        }
    });
    /**
	  * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_tipo_tramite.
	  */
    var winFrmListadoCgg_res_tipo_tramite = null;
    if(inDesktop !== null && inDesktop!==undefined){
        winFrmListadoCgg_res_tipo_tramite = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_tipo_tramite',
            title:tituloListadoCgg_res_tipo_tramite,
            tbar:getPanelTitulo(tituloListadoCgg_res_tipo_tramite,descListadoCgg_res_tipo_tramite),
            items:[grdCgg_res_tipo_tramite],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_tipo_tramite,btnEditarCgg_res_tipo_tramite,btnEliminarCgg_res_tipo_tramite,'->',btnSalirCgg_res_tipo_tramite]
        });
    }else{
        winFrmListadoCgg_res_tipo_tramite = new Ext.Window({
            id:'winFrmListadoCgg_res_tipo_tramite',
            title:tituloListadoCgg_res_tipo_tramite,
            tbar:getPanelTitulo(tituloListadoCgg_res_tipo_tramite,descListadoCgg_res_tipo_tramite),
            items:[grdCgg_res_tipo_tramite],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_tipo_tramite,btnEditarCgg_res_tipo_tramite,btnEliminarCgg_res_tipo_tramite,'->',btnSalirCgg_res_tipo_tramite]
        });
    }
    
    /**
	  * Funcion que aplica los privilegios del usuario.
	  */
    applyGrants(winFrmListadoCgg_res_tipo_tramite.getBottomToolbar());
    /**
	  * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_tipo_tramite.
	  * @returns ventana winFrmCgg_res_tipo_tramite.
	  * @base FrmListadoCgg_res_tipo_tramite.prototype.show
	  */
    this.getWindow = function(){
        return winFrmListadoCgg_res_tipo_tramite;
    }
    /**
	  * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_tipo_tramite.
	  * @base FrmListadoCgg_res_tipo_tramite.prototype.loadData
	  */
    this.loadData = function(){
        gsCgg_res_tipo_tramite.load();
    }
    /**
	  * Funcion miembro que develve el ColumnModel utilizado en el listado.
	  */
    this.getColumnModel = function(){
        return cmCgg_res_tipo_tramite;
    }
    /**
	  * Funcion miembro que develve el Store utilizado en el listado.
	  */
    this.getStore = function(){
        return gsCgg_res_tipo_tramite;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_tipo_tramite.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_tipo_tramite.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_tipo_tramite desde una instancia.
 */
FrmListadoCgg_res_tipo_tramite.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_tipo_tramite desde una instancia.
 */
FrmListadoCgg_res_tipo_tramite.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_tipo_tramite,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_tipo_tramite.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_tipo_tramite desde una instancia.
 */
FrmListadoCgg_res_tipo_tramite.prototype.loadData = function(){
    this.loadData();
}
