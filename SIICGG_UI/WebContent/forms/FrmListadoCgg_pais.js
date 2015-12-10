/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_pais.
 * @constructor 
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_pais(inDesktop){
    var optMenu = 'Pais';
	var optMenu = 'Configuraci\u00F3n/Distribuci\u00F3n geogr\u00E1fica/Administraci\u00F3n de pa\u00EDs';
    var urlListadoCgg_pais=URL_WS+"Cgg_pais";
    var tituloListadoCgg_pais='Listado pa\u00EDs';
    var descListadoCgg_pais='El formulario permite administrar informaci\u00f3n del pa\u00EDs';
    /**
	 * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_pais.
	 */
    var btnNuevoCgg_pais = new Ext.Button({
        id:'btnNuevoCgg_pais',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Nuevo pa\u00EDs',
        listeners:{
            click:function(){
                var objCgg_pais = new FrmCgg_pais("insert");
                objCgg_pais.closeHandler(function(){
                    gsCgg_pais.reload();
                });
                objCgg_pais.show();
            }
        }
    });
    /**
	 * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_pais.
	 */
    var btnEditarCgg_pais = new Ext.Button({
        id:'btnEditarCgg_pais',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:'Editar pa\u00EDs',
        listeners:{
            click:function(){
                var r=grdCgg_pais.getSelectionModel().getSelected();
                if(r){
                    var objCgg_pais = new FrmCgg_pais("update",r);
                    objCgg_pais.closeHandler(function(){
                        gsCgg_pais.reload();
                    });
                    objCgg_pais.loadData();
                    objCgg_pais.show();
                }
            }
        }
    });
    /**
	 * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_pais.
	 */
    var btnEliminarCgg_pais = new Ext.Button({
        id:'btnEliminarCgg_pais',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:'Eliminar pa\u00EDs',
        listeners:{
            click:function(){
                var r=grdCgg_pais.getSelectionModel().getSelected();
                if(r){
                    function SWRCgg_pais(btn){
                        if (btn=='yes'){
                            try{
                                function CallBackCgg_pais(r){
                                    winFrmListadoCgg_pais.getEl().unmask();
                                    if(r=='true'){
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_pais,
                                            msg: 'La informaci\u00f3n de pa\u00EDs ha sido eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });
                                        gsCgg_pais.reload();
                                    }else{
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_pais,
                                            msg: 'La informaci\u00f3n de pa\u00EDs no ha podido ser eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.ERROR
                                        });
                                    }
                                }
                                winFrmListadoCgg_pais.getEl().mask('Eliminando...', 'x-mask-loading');
                                var param = new SOAPClientParameters();
                                param.add('inCpais_codigo',grdCgg_pais.getSelectionModel().getSelected().get('CPAIS_CODIGO'));
                                SOAPClient.invoke(urlListadoCgg_pais,"delete",param, true, CallBackCgg_pais);
                            }catch(inErr){
                                winFrmListadoCgg_pais.getEl().unmask();
                            }
                        }
                    }
                }
                Ext.Msg.show({
                    title:'Aviso',
                    msg:'Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_pais,
                    icon: Ext.MessageBox.QUESTION
                });
            }
        }
    });
    /**
	 * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_pais.
	 */
    var btnSalirCgg_pais = new Ext.Button({
        id:'btnSalirCgg_pais',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Salir del formulario',
        listeners:{
            click:function(){
                winFrmListadoCgg_pais.close();
            }
        }
    });
    /**
	  * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_pais.
	  */
    var cmCgg_pais = new Ext.grid.ColumnModel([
		{dataIndex:'CPAIS_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
		{dataIndex:'CPAIS_NOMBRE',header:'Pa\u00eds',width:150,sortable:true},
		{dataIndex:'CPAIS_ISO',header:'ISO',width:20,sortable:true},
		{dataIndex:'CPAIS_DESCRIPCION',header:'Descripci\u00F3n',width:150,sortable:true}
	]);
    /**
	  * Ext.data.Store Agrupacion de registros de la tabla Cgg_pais por un campo especifico.
	  */
    var gsCgg_pais = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_pais",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CPAIS_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {name:'CPAIS_CODIGO'},
        {name:'CPAIS_NOMBRE'},
		{name:'CPAIS_ISO'},
        {name:'CPAIS_DESCRIPCION'}
        ]),
        sortInfo:{
            field: 'CPAIS_NOMBRE',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    /**
	  * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_pais.
	  */
    var pgBarCgg_pais= new Ext.PagingToolbar({
        store: gsCgg_pais,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
	  * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_pais en un formato tabular de filas y columnas.
	  */
    var grdCgg_pais = new Ext.grid.GridPanel({
        viewConfig:{
            forceFit:true
        },
        cm:cmCgg_pais,
        store:gsCgg_pais,
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
            store:gsCgg_pais,
            width:200
        })
        ],
        bbar:pgBarCgg_pais,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_pais.hidden){
                    btnEditarCgg_pais.fireEvent('click', btnEditarCgg_pais);
                }
            }
        }
    });
    gsCgg_pais.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON"
        }
    });
    /**
	  * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_pais.
	  */
    if(inDesktop){
        var winFrmListadoCgg_pais = inDesktop.createWindow({
            id:'winFrmListadoCgg_pais',
            title:tituloListadoCgg_pais,
            tbar:getPanelTitulo(tituloListadoCgg_pais,descListadoCgg_pais),
            items:[grdCgg_pais],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_pais,btnEditarCgg_pais,btnEliminarCgg_pais,'->',btnSalirCgg_pais]
        });
    
		/**
		  * Funcion que aplica los privilegios del usuario.
		  */
		applyGrants(winFrmListadoCgg_pais.getBottomToolbar());
	}
    /**
	  * Funcion miembro que devuelve la ventana winFrmListadoCgg_pais.
	  * @returns ventana winFrmCgg_pais.
	  * @base FrmListadoCgg_pais.prototype.show
	  */
    this.getWindow = function(){
        return winFrmListadoCgg_pais;
    }
    /**
	  * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_pais.
	  * @base FrmListadoCgg_pais.prototype.loadData
	  */
    this.loadData = function(){
        gsCgg_pais.load();
    }
    /**
	  * Funcion miembro que develve el ColumnModel utilizado en el listado.
	  */
    this.getColumnModel = function(){
        return cmCgg_pais;
    }
    /**
	  * Funcion miembro que develve el Store utilizado en el listado.
	  */
    this.getStore = function(){
        return gsCgg_pais;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_pais.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_pais.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_pais desde una instancia.
 */
FrmListadoCgg_pais.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_pais desde una instancia.
 */
FrmListadoCgg_pais.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_pais,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_pais.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_pais desde una instancia.
 */
FrmListadoCgg_pais.prototype.loadData = function(){
    this.loadData();
}
