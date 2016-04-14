/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_usuario.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_usuario(inDesktop){
    var optMenu = 'Seguridad/Usuarios';
    var urlListadoCgg_usuario=URL_WS+"Cgg_usuario";
    var tituloListadoCgg_usuario='Listado de usuarios del SII';
    var descListadoCgg_usuario='El formulario permite administrar informaci\u00f3n de los usuarios del SII.';
	
	var gsCgg_res_documento_identificacio = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_documento_identificacio",
            method:"selectAll",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {name:'CRDID_CODIGO'},
            {name:'CRDID_DESCRIPCION'
            }
        ]),
        baseParams:{
            format:TypeFormat.JSON
        }
    });
	gsCgg_res_documento_identificacio.load();
	
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_usuario.
     */
    var btnNuevoCgg_usuario = new Ext.Button({
        id:'btnNuevoCgg_usuario',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_usuario = new FrmCgg_usuario("insert");
                objCgg_usuario.closeHandler(function(){
                    gsCgg_usuario.reload();
					gsCgg_usuarioExterno.reload();
                });
                objCgg_usuario.setStoreTipoDoc(gsCgg_res_documento_identificacio);
                objCgg_usuario.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_usuario.
     */
    var btnEditarCgg_usuario = new Ext.Button({
        id:'btnEditarCgg_usuario',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
				var r
				if(tbpTipoUsuarios.getActiveTab() == grdCgg_usuario)
					r=grdCgg_usuario.getSelectionModel().getSelected();
				else
					r=grdCgg_usuarioExterno.getSelectionModel().getSelected();
                if(r){
                    var objCgg_usuario = new FrmCgg_usuario("update",r);
                    objCgg_usuario.closeHandler(function(){
                        gsCgg_usuario.reload();
						gsCgg_usuarioExterno.reload();
                    });
                    objCgg_usuario.setStoreTipoDoc(gsCgg_res_documento_identificacio);
                    objCgg_usuario.loadData();
                    objCgg_usuario.show();
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_usuario.
     */
    var btnEliminarCgg_usuario = new Ext.Button({
        id:'btnEliminarCgg_usuario',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({
                    title:'Aviso',
                    msg:'Est\u00e1 seguro de eliminar?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_usuario,
                    icon: Ext.MessageBox.QUESTION
                });
                function SWRCgg_usuario(btn){
                    if (btn=='yes'){
                        try{
                            function CallBackCgg_usuario(r){
                                winFrmListadoCgg_usuario.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_usuario,
                                        msg: 'La informaci\u00f3n del Usuario ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_usuario.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_usuario,
                                        msg: 'La informaci\u00f3n del Usuario no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_usuario.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCusu_codigo',grdCgg_usuario.getSelectionModel().getSelected().get('CUSU_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_usuario,"delete",param, true, CallBackCgg_usuario);
                        }catch(inErr){
                            winFrmListadoCgg_usuario.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_usuario.
     */
    var btnSalirCgg_usuario = new Ext.Button({
        id:'btnSalirCgg_usuario',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_usuario.close();
            }
        }
    });
    var btnCambioClaveCgg_usuario = new Ext.Button({
        id:'btnCambioClaveCgg_usuario',
        name:'btnCambioClaveCgg_usuario',
        text:'Reestablecer clave',
        iconCls:'iconClave',
        handler:function(){
            var tmpRecord;
			if(tbpTipoUsuarios.getActiveTab() == grdCgg_usuario)
				tmpRecord = grdCgg_usuario.getSelectionModel().getSelected();
			if(tbpTipoUsuarios.getActiveTab() == grdCgg_usuarioExterno)
				tmpRecord = grdCgg_usuarioExterno.getSelectionModel().getSelected();
            if(tmpRecord){
                var tmpDlg = new DlgUsuarioAC();
                tmpDlg.setUserID(tmpRecord.get('CUSU_CODIGO'));
                tmpDlg.setUserName(tmpRecord.get('CUSU_NOMBRE_USUARIO'));
                tmpDlg.setOp();
                tmpDlg.show();
            }
        }
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_usuario.
     */
    var chkCaducaClave = new Ext.grid.CheckColumn(
		{dataIndex:'CUSU_CADUCA_CLAVE',header:'Caduca clave',width:150,sortable:true}
	);
    var chkCusu_activo = new Ext.grid.CheckColumn(
		{dataIndex:'CUSU_ACTIVO',header:'Activo',width:150,sortable:true}
	);
    var cmCgg_usuario = new Ext.grid.ColumnModel([
        {dataIndex:'NOMBRES',header:'Nombres',width:150,sortable:true},
        {dataIndex:'APELLIDOS',header:'Apellidos',width:150,sortable:true},
		{dataIndex:'CISLA_NOMBRE',header:'Isla',width:150,sortable:true},
        {dataIndex:'EMPRESA',header:'Empresa',width:150,sortable:true},
        {dataIndex:'CUSU_NOMBRE_USUARIO',header:'Nombre usuario',width:150,sortable:true},
        {dataIndex:'CUSU_CLAVE_ACCESO',header:'Clave acceso',width:150,sortable:true,hideable:false,hidden:true},
		chkCaducaClave,
        chkCusu_activo
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_usuario por un campo especifico.
     */
    var gsCgg_usuario = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_usuario",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CUSU_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CUSU_CODIGO'},
            {name:'CRCRG_CODIGO'},
            {name:'CRCRG_NOMBRE'},
            {name:'CRPER_CODIGO'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_APELLIDO_MATERNO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPJR_CODIGO'},
            {name:'CRPJR_RAZON_SOCIAL'},
            {name:'CTAGV_NOMBRE'},
            {name:'CCTN_CODIGO'},
            {name:'CCTN_NOMBRE'},
            {name:'NOMBRES'},
            {name:'APELLIDOS'},
            {name:'EMPRESA'},
            {name:'CUSU_NOMBRE_USUARIO'},
            {name:'CUSU_CLAVE_ACCESO'},
            {name:'CUSU_USUARIO_INTERNO'},
            {name:'CUSU_CADUCA_CLAVE'},
            {name:'CUSU_ACTIVO'},
            {name:'CUSU_CAMBIAR_CLAVE'},
            {name:'VIGENCIA'},
            {name:'TRANSCURRIDO'},
            {name:'CISLA_CODIGO'},
			{name:'CISLA_NOMBRE'}
        ]),
        sortInfo:{
            field: 'CUSU_NOMBRE_USUARIO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON",
			inCusu_usuario_interno:'1',
			inCrper_codigo:''
        },
        listeners:{
            load:function(inStore, inRecords, inOptions){
                try{
					for (var i = 0; i < inRecords.length; i++){
						var tmpCaduca = inRecords[i].get('CUSU_CADUCA_CLAVE');
						if(tmpCaduca){
							var tmpVigencia = inRecords[i].get('VIGENCIA');
							var tmpTranscurrido = inRecords[i].get('TRANSCURRIDO');
							grdCgg_usuario.getView().getRow(i).style.backgroundColor = Fade(255,255,255,255,0,0,tmpVigencia,tmpTranscurrido);
						}

					}
				}catch(e){}
            }
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_usuario.
     */
    var pgBarCgg_usuario= new Ext.PagingToolbar({
        store: gsCgg_usuario,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_usuario en un formato tabular de filas y columnas.
     */
    var grdCgg_usuario = new Ext.grid.GridPanel({
        cm:cmCgg_usuario,
        store:gsCgg_usuario,
        title:'Internos',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_usuario,
                width:200
            })
        ],
        bbar:pgBarCgg_usuario,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_usuario.hidden){
                    btnEditarCgg_usuario.fireEvent('click', btnEditarCgg_usuario);
                }
            }
        }
    });
	
	/**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_usuario.
     */
    var chkCaducaClaveExterno = new Ext.grid.CheckColumn(
		{dataIndex:'CUSU_CADUCA_CLAVE',header:'Caduca clave',width:150,sortable:true}
	);
    var chkCusu_activoExterno = new Ext.grid.CheckColumn(
		{dataIndex:'CUSU_ACTIVO',header:'Activo',width:150,sortable:true}
	);
    var cmCgg_usuarioExterno = new Ext.grid.ColumnModel([
        {dataIndex:'NOMBRES',header:'Nombres',width:150,sortable:true},
        {dataIndex:'APELLIDOS',header:'Apellidos',width:150,sortable:true},
		{dataIndex:'CISLA_NOMBRE',header:'Isla',width:150,sortable:true},
        {dataIndex:'EMPRESA',header:'Empresa',width:150,sortable:true},
        {dataIndex:'CUSU_NOMBRE_USUARIO',header:'Nombre usuario',width:150,sortable:true},
        {dataIndex:'CUSU_CLAVE_ACCESO',header:'Clave acceso',width:150,sortable:true,hideable:false,hidden:true},
		chkCaducaClaveExterno,
        chkCusu_activoExterno
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_usuario por un campo especifico.
     */
    var gsCgg_usuarioExterno = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_usuario",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CUSU_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CUSU_CODIGO'},
            {name:'CRCRG_CODIGO'},
            {name:'CRCRG_NOMBRE'},
            {name:'CRPER_CODIGO'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_APELLIDO_MATERNO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPJR_CODIGO'},
            {name:'CRPJR_RAZON_SOCIAL'},
            {name:'CTAGV_NOMBRE'},
            {name:'CCTN_CODIGO'},
            {name:'CCTN_NOMBRE'},
            {name:'NOMBRES'},
            {name:'APELLIDOS'},
            {name:'EMPRESA'},
            {name:'CUSU_NOMBRE_USUARIO'},
            {name:'CUSU_CLAVE_ACCESO'},
            {name:'CUSU_USUARIO_INTERNO'},
            {name:'CUSU_CADUCA_CLAVE'},
            {name:'CUSU_ACTIVO'},
            {name:'CUSU_CAMBIAR_CLAVE'},
            {name:'VIGENCIA'},
            {name:'TRANSCURRIDO'},
            {name:'CISLA_CODIGO'},
			{name:'CISLA_NOMBRE'}
        ]),
        sortInfo:{
            field: 'CUSU_NOMBRE_USUARIO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:'',
            format:'JSON',
			inCusu_usuario_interno:'0',
			inCrper_codigo:''
        },
        listeners:{
            load:function(inStore, inRecords, inOptions){
                for (var i = 0; i < inRecords.length; i++){
                    var tmpCaduca = inRecords[i].get('CUSU_CADUCA_CLAVE');
                    if(tmpCaduca){
                        var tmpVigencia = inRecords[i].get('VIGENCIA');
                        var tmpTranscurrido = inRecords[i].get('TRANSCURRIDO');
                        grdCgg_usuarioExterno.getView().getRow(i).style.backgroundColor = Fade(255,255,255,255,0,0,tmpVigencia,tmpTranscurrido);
                    }

                }
            }
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_usuario.
     */
    var pgBarCgg_usuarioExterno = new Ext.PagingToolbar({
        store: gsCgg_usuarioExterno,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_usuario en un formato tabular de filas y columnas.
     */
    var grdCgg_usuarioExterno = new Ext.grid.GridPanel({
        cm:cmCgg_usuarioExterno,
        store:gsCgg_usuarioExterno,
        title:'Externos',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_usuarioExterno,
                width:200
            })
        ],
        bbar:pgBarCgg_usuarioExterno,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_usuario.hidden){
                    btnEditarCgg_usuario.fireEvent('click', btnEditarCgg_usuario);
                }
            }
        }
    });
	
	var tbpTipoUsuarios = new Ext.TabPanel({
		activeTab:0,
		region:'center',
		items:[grdCgg_usuario,grdCgg_usuarioExterno]
	});
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_usuario.
     */
    if(inDesktop){
		gsCgg_usuario.reload({
			params:{
				start:0,
				limit:RECORD_PAGE
			}
		});
		gsCgg_usuarioExterno.reload({
			params:{
				start:0,
				limit:RECORD_PAGE
			}
		});
        var winFrmListadoCgg_usuario = inDesktop.createWindow({
            id:'winFrmListadoCgg_usuario',
            title:tituloListadoCgg_usuario,
            tbar:getPanelTitulo(tituloListadoCgg_usuario,descListadoCgg_usuario),
            items:[tbpTipoUsuarios],
            width:700,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_usuario,btnEditarCgg_usuario,btnEliminarCgg_usuario,'-',btnCambioClaveCgg_usuario,'->',btnSalirCgg_usuario]
        });
		/**
		 * Funcion que aplica los privilegios del usuario.
		 */
		applyGrants(winFrmListadoCgg_usuario.getBottomToolbar());
    } 
    
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_usuario.
     * @returns ventana winFrmCgg_usuario.
     * @base FrmListadoCgg_usuario.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_usuario;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_usuario.
     * @base FrmListadoCgg_usuario.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_usuario.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_usuario;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_usuario;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_usuario.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_usuario.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_usuario desde una instancia.
 */
FrmListadoCgg_usuario.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_usuario desde una instancia.
 */
FrmListadoCgg_usuario.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_usuario,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_usuario.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_usuario desde una instancia.
 */
FrmListadoCgg_usuario.prototype.loadData = function(){
    this.loadData();
}
