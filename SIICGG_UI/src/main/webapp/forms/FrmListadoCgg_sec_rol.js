/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_sec_rol.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_sec_rol(inDesktop){
    var optMenu = 'Seguridad/Roles';
    var urlListadoCgg_sec_rol=URL_WS+"Cgg_sec_rol";
    var tituloListadoCgg_sec_rol='Roles';
    var descListadoCgg_sec_rol='El formulario permite administrar informaci\u00f3n de los roles del sistema.';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_sec_rol.
     */
    var btnNuevoCgg_sec_rol = new Ext.Button({
        id:'btnNuevoCgg_sec_rol',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_sec_rol = new FrmCgg_sec_rol("insert");
                objCgg_sec_rol.closeHandler(function(){
                    gsCgg_sec_rol.reload();
                });
                objCgg_sec_rol.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_sec_rol.
     */
    var btnEditarCgg_sec_rol = new Ext.Button({
        id:'btnEditarCgg_sec_rol',
        text:'Editar',
        iconCls:'iconEditar',
		disabled:true,
        listeners:{
            click:function(){
                var r=grdCgg_sec_rol.getSelectionModel().getSelected();
                if(r){
                    var objCgg_sec_rol = new FrmCgg_sec_rol("update",r);
                    objCgg_sec_rol.closeHandler(function(){
                        gsCgg_sec_rol.reload();
                    });
                    objCgg_sec_rol.loadData();
                    objCgg_sec_rol.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_sec_rol.
     */
    var btnEliminarCgg_sec_rol = new Ext.Button({
        id:'btnEliminarCgg_sec_rol',
        text:'Eliminar',
        iconCls:'iconEliminar',
		disabled:true,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_sec_rol,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_sec_rol(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_sec_rol(r){
                            winFrmListadoCgg_sec_rol.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_sec_rol,
                                    msg: 'La informaci\u00f3n del Rol ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_sec_rol.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_sec_rol,
                                    msg: 'La informaci\u00f3n del Rol no ha podido ser eliminada. '+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_sec_rol.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCsrol_codigo',grdCgg_sec_rol.getSelectionModel().getSelected().get('CSROL_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_sec_rol,"delete",param, true, CallBackCgg_sec_rol);
                    }catch(inErr){
                        winFrmListadoCgg_sec_rol.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_sec_rol.
     */
    var btnSalirCgg_sec_rol = new Ext.Button({
        id:'btnSalirCgg_sec_rol',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_sec_rol.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sec_rol.
     */
    var cmCgg_sec_rol = new Ext.grid.ColumnModel([
        {dataIndex:'CSROL_CODIGO',header:'Codigo',width:150,sortable:true,hideable:false,hidden:true},
        {dataIndex:'CSROL_NOMBRE',header:'Nombre',width:200,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_sec_rol por un campo especifico.
     */
    var gsCgg_sec_rol = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_sec_rol",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CSROL_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CSROL_CODIGO'},
            {name:'CSROL_NOMBRE'}
        ]),
        sortInfo:{field: 'CSROL_NOMBRE', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_sec_rol.
     */
    var pgBarCgg_sec_rol= new Ext.PagingToolbar({
        store: gsCgg_sec_rol,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sec_rol en un formato tabular de filas y columnas.
     */
    var grdCgg_sec_rol = new Ext.grid.GridPanel({
		title:'Roles',
        cm:cmCgg_sec_rol,
        store:gsCgg_sec_rol,
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_sec_rol,
                width:200
            })
        ],
        bbar:pgBarCgg_sec_rol,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_sec_rol.hidden){
                    btnEditarCgg_sec_rol.fireEvent('click', btnEditarCgg_sec_rol);
                }
            }}});
	/**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sec_rol.
     */
    var cmCgg_sec_rolUsuario = new Ext.grid.ColumnModel([
        {dataIndex:'CUSU_NOMBRE_USUARIO',header:'Usuario',width:200,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_sec_rol por un campo especifico.
     */
    var gsCgg_sec_rolUsuario = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_sec_usuario_rol",
            method:"selectPageRol",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CSPER_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
			{name:'CSPER_CODIGO'},
            {name:'CUSU_CODIGO'},
            {name:'CUSU_NOMBRE_USUARIO'}
        ]),
        sortInfo:{field: 'CUSU_NOMBRE_USUARIO', direction: 'ASC'},
        baseParams:{keyword:'',
			format:'JSON',
			inCsrol_codigo:''
		}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_sec_rol.
     */
    var pgBarCgg_sec_rolUsuario = new Ext.PagingToolbar({
        store: gsCgg_sec_rolUsuario,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sec_rol en un formato tabular de filas y columnas.
     */
    var grdCgg_sec_rolUsuario = new Ext.grid.GridPanel({
		title:'Usuarios',
        cm:cmCgg_sec_rolUsuario,
        store:gsCgg_sec_rolUsuario,
        disabled:true,
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_sec_rolUsuario,
                width:200
            })
        ],
        bbar:pgBarCgg_sec_rolUsuario
	});
	var tplCgg_sec_rol = new Ext.TabPanel({
		activeTab:0,
		region:'center',
		tabPosition:'bottom',
		items:[grdCgg_sec_rol,grdCgg_sec_rolUsuario],
		listeners:{
			tabchange:function(inSource, inActivePanel){
				btnEditarCgg_sec_rol.setDisabled(inActivePanel==grdCgg_sec_rolUsuario);
				btnEliminarCgg_sec_rol.setDisabled(inActivePanel==grdCgg_sec_rolUsuario);
				btnNuevoCgg_sec_rol.setDisabled(inActivePanel==grdCgg_sec_rolUsuario);
			}
		}
	});
	if(inDesktop){
		gsCgg_sec_rol.reload({params:{
			start:0,
			limit:RECORD_PAGE
		}
		});
		gsCgg_sec_rolUsuario.reload({params:{
			start:0,
			limit:RECORD_PAGE
		}
		});
		grdCgg_sec_rol.getSelectionModel().on("selectionchange",function(inSelectionModel){
			btnEditarCgg_sec_rol.setDisabled(!inSelectionModel.hasSelection());
			btnEliminarCgg_sec_rol.setDisabled(!inSelectionModel.hasSelection());
			grdCgg_sec_rolUsuario.setDisabled(!inSelectionModel.hasSelection());
			var tmpRecord = grdCgg_sec_rol.getSelectionModel().getSelected();
			if(tmpRecord){
				gsCgg_sec_rolUsuario.baseParams.inCsrol_codigo = tmpRecord.data.CSROL_CODIGO;
				gsCgg_sec_rolUsuario.reload();
			}
		});
		/**
		 * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_sec_rol.
		 */
		var winFrmListadoCgg_sec_rol = inDesktop.createWindow({
			id:'winFrmListadoCgg_sec_rol',
			title:tituloListadoCgg_sec_rol,
			tbar:getPanelTitulo('Listado '+tituloListadoCgg_sec_rol,descListadoCgg_sec_rol),
			items:[tplCgg_sec_rol],
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			layout:'border',
			bbar:[btnNuevoCgg_sec_rol,btnEditarCgg_sec_rol,btnEliminarCgg_sec_rol,'->',btnSalirCgg_sec_rol]
		});
		/**
		 * Funcion que aplica los privilegios del usuario.
		 */
		applyGrants(winFrmListadoCgg_sec_rol.getBottomToolbar());
	}
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_sec_rol.
     * @returns ventana winFrmCgg_sec_rol.
     * @base FrmListadoCgg_sec_rol.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_sec_rol;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_sec_rol.
     * @base FrmListadoCgg_sec_rol.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_sec_rol.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_sec_rol;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_sec_rol;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_sec_rol.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_sec_rol.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_sec_rol desde una instancia.
 */
FrmListadoCgg_sec_rol.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_sec_rol desde una instancia.
 */
FrmListadoCgg_sec_rol.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_sec_rol,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_sec_rol.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_sec_rol desde una instancia.
 */
FrmListadoCgg_sec_rol.prototype.loadData = function(){
    this.loadData();
}
