/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_persona_juridica.
 * @constructor 
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_persona_juridica(inDesktop){
	var optMenu='Configuraci\u00F3n/Administraci\u00F3n de persona/Administraci\u00F3n de persona jur\u00EDdica';
    var urlListadoCgg_res_persona_juridica=URL_WS+"Cgg_res_persona_juridica";
    var tituloListadoCgg_res_persona_juridica='Listado de empresas registradas';
    var descListadoCgg_res_persona_juridica='El formulario permite listar informaci\u00f3n de las empresas registradas';
    /**
	 * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_persona_juridica.
	 */
    var btnNuevoCgg_res_persona_juridica = new Ext.Button({
        id:'btnNuevoCgg_res_persona_juridica',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Nueva persona jur\u00EDdica',
        listeners:{
            click:function(){
                var objCgg_res_persona_juridica = new FrmCgg_res_persona_juridica("insert");
                objCgg_res_persona_juridica.closeHandler(function(){
                    gsCgg_res_persona_juridica.reload();
                });
                objCgg_res_persona_juridica.show();
            }
        }
    });
    /**
	 * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_persona_juridica.
	 */
    var btnEditarCgg_res_persona_juridica = new Ext.Button({
        id:'btnEditarCgg_res_persona_juridica',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:'Editar persona jur\u00EDdica',
        listeners:{
            click:function(){
                var r=grdCgg_res_persona_juridica.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_persona_juridica = new FrmCgg_res_persona_juridica("update",r);
                    objCgg_res_persona_juridica.closeHandler(function(){
                        gsCgg_res_persona_juridica.reload();
                    });
                    objCgg_res_persona_juridica.loadData();
                    objCgg_res_persona_juridica.show();
                }
            }
        }
    });
    /**
	 * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_persona_juridica.
	 */
    var btnEliminarCgg_res_persona_juridica = new Ext.Button({
        id:'btnEliminarCgg_res_persona_juridica',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:'Eliminar persona jur\u00EDdica',
        listeners:{
            click:function(){
                var r=grdCgg_res_persona_juridica.getSelectionModel().getSelected();
                if(r){
                    function SWRCgg_res_persona_juridica(btn){
                        if (btn=='yes'){
                            try{
                                function CallBackCgg_res_persona_juridica(r){
                                    winFrmListadoCgg_res_persona_juridica.getEl().unmask();
                                    if(r=='true'){
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_res_persona_juridica,
                                            msg: 'La informaci\u00f3n de persona jur\u00EDdica ha sido eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });
                                        gsCgg_res_persona_juridica.reload();
                                    }else{
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_res_persona_juridica,
                                            msg: 'La informaci\u00f3n de persona jur\u00EDdica no ha podido ser eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.ERROR
                                        });
                                    }
                                }
                                winFrmListadoCgg_res_persona_juridica.getEl().mask('Eliminando...', 'x-mask-loading');
                                var param = new SOAPClientParameters();
                                param.add('inCrpjr_codigo',grdCgg_res_persona_juridica.getSelectionModel().getSelected().get('CRPJR_CODIGO'));
                                SOAPClient.invoke(urlListadoCgg_res_persona_juridica,"delete",param, true, CallBackCgg_res_persona_juridica);
                            }catch(inErr){
                                winFrmListadoCgg_res_persona_juridica.getEl().unmask();
                            }
                        }
                    }
                }
                Ext.Msg.show({
                    title:'Aviso',
                    msg:'Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_res_persona_juridica,
                    icon: Ext.MessageBox.QUESTION
                });
            }
        }
    });
    /**
	 * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_persona_juridica.
	 */
    var btnSalirCgg_res_persona_juridica = new Ext.Button({
        id:'btnSalirCgg_res_persona_juridica',
        text:'Salir',
        iconCls:'iconSalir',
        tootip:'Salir del formulario',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_persona_juridica.close();
            }
        }
    });
    /**
	  * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_persona_juridica.
	  */
    var cmCgg_res_persona_juridica = new Ext.grid.ColumnModel([        
        {dataIndex:'CRPJR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CRPJR_RAZON_SOCIAL',header:'Nombre',width:150,sortable:true},
        {dataIndex:'CRPJR_NUMERO_IDENTIFICACION',header:'Ruc/Ident.',width:100,sortable:true},
        {dataIndex:'CRPJR_FECHA_CONSTITUCION',header:'Creaci\u00F3n',width:75,sortable:true,renderer:truncDate},
        {dataIndex:'CRPJR_ACTIVIDAD',header:'Actividad',width:150,sortable:true},
        {dataIndex:'CRPJR_DIRECCION',header:'Direcci\u00F3n',width:150,sortable:true},
        {dataIndex:'CSCTP_NOMBRE',header:'Sector prod.',width:100,sortable:true},
        {dataIndex:'CVSCT_NOMBRE',header:'Sector',width:100,sortable:true},
        {dataIndex:'CRPJR_NUMERO_EMPLEADOS',header:'Empleados',width:75,sortable:true},
        {dataIndex:'CRPJR_TIPO',header:'Localidad',width:80,sortable:true,renderer:function(inCrpjr_Tipo){
                if (inCrpjr_Tipo==1){
                    return('Externa')
                }else{
                    return('Interna')
                }
            }
        }]);
    /**
	  * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona_juridica por un campo especifico.
	  */
    var gsCgg_res_persona_juridica = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_persona_juridica",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPJR_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {name:'CRPJR_CODIGO'},
        {name:'CSCTP_CODIGO'},
		{name:'CSCTP_NOMBRE'},
        {name:'CVSCT_CODIGO'},
		{name:'CVSCT_NOMBRE'},
		{name:'CCTN_CODIGO'},
		{name:'CCTN_NOMBRE'},
        {name:'CRPJR_RAZON_SOCIAL'},
        {name:'CRPJR_NUMERO_IDENTIFICACION'},
        {name:'CRPJR_FECHA_CONSTITUCION'},
        {name:'CRPJR_DIRECCION'},
        {name:'CRPJR_ACTIVIDAD'},
        {name:'CRPJR_NUMERO_EMPLEADOS'},
        {name:'CRPJR_TIPO'}
        ]),
        sortInfo:{
            field: 'CSCTP_CODIGO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    /**
	  * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_persona_juridica.
	  */
    var pgBarCgg_res_persona_juridica= new Ext.PagingToolbar({
        store: gsCgg_res_persona_juridica,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
	  * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_persona_juridica en un formato tabular de filas y columnas.
	  */
    var grdCgg_res_persona_juridica = new Ext.grid.GridPanel({
        cm:cmCgg_res_persona_juridica,
        store:gsCgg_res_persona_juridica,
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
            store:gsCgg_res_persona_juridica,
            width:200
        })
        ],
        bbar:pgBarCgg_res_persona_juridica,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_persona_juridica.hidden){
                    btnEditarCgg_res_persona_juridica.fireEvent('click', btnEditarCgg_res_persona_juridica);
                }
            }
        }
    });
    /**
	  * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_persona_juridica.
	  */
    if(inDesktop){
		gsCgg_res_persona_juridica.reload({
			params:{
				start:0,
				limit:RECORD_PAGE,
				format:"JSON"
			}
		});
        var winFrmListadoCgg_res_persona_juridica = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_persona_juridica',
            title:tituloListadoCgg_res_persona_juridica,
            tbar:getPanelTitulo(tituloListadoCgg_res_persona_juridica,descListadoCgg_res_persona_juridica),
            items:[grdCgg_res_persona_juridica],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_persona_juridica,btnEditarCgg_res_persona_juridica,btnEliminarCgg_res_persona_juridica,'->',btnSalirCgg_res_persona_juridica]
        });
		/**
		  * Funcion que aplica los privilegios del usuario.
		  */
		applyGrants(winFrmListadoCgg_res_persona_juridica.getBottomToolbar());
    }
    /**
	  * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_persona_juridica.
	  * @returns ventana winFrmCgg_res_persona_juridica.
	  * @base FrmListadoCgg_res_persona_juridica.prototype.show
	  */
    this.getWindow = function(){
        return winFrmListadoCgg_res_persona_juridica;
    }
    /**
	  * Funcion miembro que develve el ColumnModel utilizado en el listado.
	  */
    this.getColumnModel = function(){
        return cmCgg_res_persona_juridica;
    }
    /**
	  * Funcion miembro que develve el Store utilizado en el listado.
	  */
    this.getStore = function(){
        return gsCgg_res_persona_juridica;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_persona_juridica.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_persona_juridica.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_persona_juridica desde una instancia.
 */
FrmListadoCgg_res_persona_juridica.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_persona_juridica desde una instancia.
 */
FrmListadoCgg_res_persona_juridica.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_persona_juridica,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_persona_juridica.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}