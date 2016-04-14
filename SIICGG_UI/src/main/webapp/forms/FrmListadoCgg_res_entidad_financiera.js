/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_entidad_financiera.
 * @constructor 
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_entidad_financiera(inDesktop){
    var optMenu = 'Res entidad financiera';
    var urlListadoCgg_res_entidad_financiera=URL_WS+"Cgg_res_entidad_financiera";
    var tituloListadoCgg_res_entidad_financiera='Administraci\u00f3n entidad financiera';
    var descListadoCgg_res_entidad_financiera='El formulario permite administrar informaci\u00f3n de la entidad financiera';
   
    /**
	 * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_entidad_financiera.
	 */
    var btnNuevoCgg_res_entidad_financiera = new Ext.Button({
        id:'btnNuevoCgg_res_entidad_financiera',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Nueva entidad financiera',
        listeners:{
            click:function(){
                var objCgg_res_entidad_financiera = new FrmCgg_res_entidad_financiera("insert");
                objCgg_res_entidad_financiera.closeHandler(function(){
                    gsCgg_res_entidad_financiera.reload();
                });
                objCgg_res_entidad_financiera.show();
            }
        }
    });
    /**
	 * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_entidad_financiera.
	 */
    var btnEditarCgg_res_entidad_financiera = new Ext.Button({
        id:'btnEditarCgg_res_entidad_financiera',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:'Editar entidad financiera',
        listeners:{
            click:function(){
                var r=grdCgg_res_entidad_financiera.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_entidad_financiera = new FrmCgg_res_entidad_financiera("update",r);
                    objCgg_res_entidad_financiera.closeHandler(function(){
                        gsCgg_res_entidad_financiera.reload();
                    });
                    objCgg_res_entidad_financiera.loadData();
                    objCgg_res_entidad_financiera.show();
                }
            }
        }
    });
    /**
	 * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_entidad_financiera.
	 */
    var btnEliminarCgg_res_entidad_financiera = new Ext.Button({
        id:'btnEliminarCgg_res_entidad_financiera',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:'Eliminar entidad financiera',
        listeners:{
            click:function(){
                var r=grdCgg_res_entidad_financiera.getSelectionModel().getSelected();
                if(r){
                    function SWRCgg_res_entidad_financiera(btn){
                        if (btn=='yes'){
                            try{
				
                                function CallBackCgg_res_entidad_financiera(r){
                                    winFrmListadoCgg_res_entidad_financiera.getEl().unmask();
                                    if(r=='true'){
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_res_entidad_financiera,
                                            msg: 'La informaci\u00f3n de entidad financiera ha sido eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });
                                        gsCgg_res_entidad_financiera.reload();
                                    }else{
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_res_entidad_financiera,
                                            msg: 'La informaci\u00f3n de entidad financiera no ha podido ser eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.ERROR
                                        });
                                    }
                                }
                                winFrmListadoCgg_res_entidad_financiera.getEl().mask('Eliminando...', 'x-mask-loading');
                                var param = new SOAPClientParameters();
                                param.add('inCretf_codigo',grdCgg_res_entidad_financiera.getSelectionModel().getSelected().get('CRETF_CODIGO'));
                                SOAPClient.invoke(urlListadoCgg_res_entidad_financiera,"delete",param, true, CallBackCgg_res_entidad_financiera);
                            }catch(inErr){
                                winFrmListadoCgg_res_entidad_financiera.getEl().unmask();
                            }
                        }
                    }
                }
                Ext.Msg.show({
                    title:'Aviso',
                    msg:'Est\u00e1 seguro de eliminar la entidad financiera?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_res_entidad_financiera,
                    icon: Ext.MessageBox.QUESTION
                });
            }
        }
    });
    /**
	 * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_entidad_financiera.
	 */
    var btnSalirCgg_res_entidad_financiera = new Ext.Button({
        id:'btnSalirCgg_res_entidad_financiera',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Salir del formulario',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_entidad_financiera.close();
            }
        }
    });
    /**
	  * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_entidad_financiera.
	  */
    var cmCgg_res_entidad_financiera = new Ext.grid.ColumnModel([
		{dataIndex:'CRETF_NOMBRE_ENTIDAD',header:'Entidad financiera',width:200,sortable:true},
		{dataIndex:'CRETF_DESCRIPCION',header:'Descripci\u00f3n',width:150,sortable:true}]);
    /**
	  * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_entidad_financiera por un campo especifico.
	  */
    var gsCgg_res_entidad_financiera = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_entidad_financiera",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRETF_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
			{name:'CRETF_CODIGO'},
			{name:'CRETF_NOMBRE_ENTIDAD'},
			{name:'CRETF_DESCRIPCION'}
        ]),
        sortInfo:{
            field: 'CRETF_NOMBRE_ENTIDAD',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    /**
	  * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_entidad_financiera.
	  */
    var pgBarCgg_res_entidad_financiera= new Ext.PagingToolbar({
        store: gsCgg_res_entidad_financiera,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
	  * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_entidad_financiera en un formato tabular de filas y columnas.
	  */
    var grdCgg_res_entidad_financiera = new Ext.grid.GridPanel({
        viewConfig:{forceFit:true},
        cm:cmCgg_res_entidad_financiera,
        store:gsCgg_res_entidad_financiera,
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
            store:gsCgg_res_entidad_financiera,
            width:200
        })
        ],
        bbar:pgBarCgg_res_entidad_financiera,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_entidad_financiera.hidden){
                    btnEditarCgg_res_entidad_financiera.fireEvent('click', btnEditarCgg_res_entidad_financiera);
                }
            }
        }
    });
    gsCgg_res_entidad_financiera.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON"
        }
    });
	 
    var winFrmListadoCgg_res_entidad_financiera = null;
	 
    if(inDesktop != null && inDesktop != undefined){
        /**
		  * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_entidad_financiera.
		  */
        winFrmListadoCgg_res_entidad_financiera = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_entidad_financiera',
            title:tituloListadoCgg_res_entidad_financiera,
            tbar:getPanelTitulo(tituloListadoCgg_res_entidad_financiera,descListadoCgg_res_entidad_financiera),
            items:[grdCgg_res_entidad_financiera],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_entidad_financiera,btnEditarCgg_res_entidad_financiera,btnEliminarCgg_res_entidad_financiera,'->',btnSalirCgg_res_entidad_financiera]
        });
    }else{
        winFrmListadoCgg_res_entidad_financiera = new Ext.Window({
            id:'winFrmListadoCgg_res_entidad_financiera',
            title:tituloListadoCgg_res_entidad_financiera,
            tbar:getPanelTitulo(tituloListadoCgg_res_entidad_financiera,descListadoCgg_res_entidad_financiera),
            items:[grdCgg_res_entidad_financiera],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_entidad_financiera,btnEditarCgg_res_entidad_financiera,btnEliminarCgg_res_entidad_financiera,'->',btnSalirCgg_res_entidad_financiera]
        });
    }
	 
	 
	 
    /**
	  * Funcion que aplica los privilegios del usuario.
	  */
    applyGrants(winFrmListadoCgg_res_entidad_financiera.getBottomToolbar());
    /**
	  * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_entidad_financiera.
	  * @returns ventana winFrmCgg_res_entidad_financiera.
	  * @base FrmListadoCgg_res_entidad_financiera.prototype.show
	  */
    this.getWindow = function(){
        return winFrmListadoCgg_res_entidad_financiera;
    }
    /**
	  * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_entidad_financiera.
	  * @base FrmListadoCgg_res_entidad_financiera.prototype.loadData
	  */
    this.loadData = function(){
        gsCgg_res_entidad_financiera.load();
    }
    /**
	  * Funcion miembro que develve el ColumnModel utilizado en el listado.
	  */
    this.getColumnModel = function(){
        return cmCgg_res_entidad_financiera;
    }
    /**
	  * Funcion miembro que develve el Store utilizado en el listado.
	  */
    this.getStore = function(){
        return gsCgg_res_entidad_financiera;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_entidad_financiera.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_entidad_financiera.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_entidad_financiera desde una instancia.
 */
FrmListadoCgg_res_entidad_financiera.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_entidad_financiera desde una instancia.
 */
FrmListadoCgg_res_entidad_financiera.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_entidad_financiera,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_entidad_financiera.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_entidad_financiera desde una instancia.
 */
FrmListadoCgg_res_entidad_financiera.prototype.loadData = function(){
    this.loadData();
}
