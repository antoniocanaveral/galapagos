/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_requisito.
 * @constructor 
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_requisito(inDesktop){
    var optMenu = 'Configuraci\u00F3n/Administraci\u00F3n de residencia/Administraci\u00F3n reguisitos tr\u00E1mites residencia';
    var urlListadoCgg_res_requisito=URL_WS+"Cgg_res_requisito";
    var tituloListadoCgg_res_requisito='Administraci\u00F3n requisitos para tr\u00E1mites';
    var descListadoCgg_res_requisito='El formulario permite administrar informaci\u00F3n de los requisitos que se aplican al tr\u00e1mite para solicitud de residencia ';
    /**
	 * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_requisito.
	 */
    var btnNuevoCgg_res_requisito = new Ext.Button({
        id:'btnNuevoCgg_res_requisito',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_requisito = new FrmCgg_res_requisito("insert");
                objCgg_res_requisito.closeHandler(function(){
                    gsCgg_res_requisito.reload();
                });
                objCgg_res_requisito.show();
            }
        }
    });
    /**
	 * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_requisito.
	 */
    var btnEditarCgg_res_requisito = new Ext.Button({
        id:'btnEditarCgg_res_requisito',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_requisito.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_requisito = new FrmCgg_res_requisito("update",r);
                    objCgg_res_requisito.closeHandler(function(){
                        gsCgg_res_requisito.reload();
                    });
                    objCgg_res_requisito.loadData();
                    objCgg_res_requisito.show();
                }
            }
        }
    });
    /**
	 * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_requisito.
	 */
    var btnEliminarCgg_res_requisito = new Ext.Button({
        id:'btnEliminarCgg_res_requisito',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                var r=grdCgg_res_requisito.getSelectionModel().getSelected();
                if(r){
                    function SWRCgg_res_requisito(btn){
                        if (btn=='yes'){
                            try{
                                function CallBackCgg_res_requisito(r){
                                    winFrmListadoCgg_res_requisito.getEl().unmask();
                                    if(r=='true'){
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_res_requisito,
                                            msg: 'La informaci\u00F3n de requisito de residencia ha sido eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });
                                        gsCgg_res_requisito.reload();
                                    }else{
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_res_requisito,
                                            msg: 'La informaci\u00F3n del requisito de residencia no ha podido ser eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.ERROR
                                        });
                                    }
                                }
                                winFrmListadoCgg_res_requisito.getEl().mask('Eliminando...', 'x-mask-loading');
                                var param = new SOAPClientParameters();
                                param.add('inCrreq_codigo',grdCgg_res_requisito.getSelectionModel().getSelected().get('CRREQ_CODIGO'));
                                SOAPClient.invoke(urlListadoCgg_res_requisito,"delete",param, true, CallBackCgg_res_requisito);
                            }catch(inErr){
                                winFrmListadoCgg_res_requisito.getEl().unmask();
                            }
                        }
                    }
			
                    Ext.Msg.show({
                        title:'Aviso',
                        msg:'Seguro de eliminar el registro seleccionado?',
                        buttons: Ext.Msg.YESNO,
                        fn: SWRCgg_res_requisito,
                        icon: Ext.MessageBox.QUESTION
                    });
                }
            }
        }
    });
    /**
	 * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_requisito.
	 */
    var btnSalirCgg_res_requisito = new Ext.Button({
        id:'btnSalirCgg_res_requisito',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_requisito.close();
            }
        }
    });    
    /**
	  * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_requisito.
	  */
    var cmCgg_res_requisito = new Ext.grid.ColumnModel([    
    {
        dataIndex:'CRREQ_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRREQ_DESCRIPCION',
        header:'Descripci\u00F3n',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRREQ_OBSERVACION',
        header:'Observaci\u00F3n',
        width:250,
        sortable:true
    }]);
    /**
	  * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_requisito por un campo especifico.
	  */
    var gsCgg_res_requisito = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_requisito",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRREQ_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CRREQ_CODIGO'
        },

        {
            name:'CRREQ_DESCRIPCION'
        },

        {
            name:'CRREQ_OBSERVACION'
        }
        ]),
        sortInfo:{
            field: 'CRREQ_DESCRIPCION',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    /**
	  * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_requisito.
	  */
    var pgBarCgg_res_requisito= new Ext.PagingToolbar({
        store: gsCgg_res_requisito,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
	  * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_requisito en un formato tabular de filas y columnas.
	  */
    var grdCgg_res_requisito = new Ext.grid.GridPanel({
        viewConfig:{forceFit:true},
        cm:cmCgg_res_requisito,
        store:gsCgg_res_requisito,
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
            store:gsCgg_res_requisito,
            width:200
        })
        ],
        bbar:pgBarCgg_res_requisito,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_requisito.hidden){
                    btnEditarCgg_res_requisito.fireEvent('click', btnEditarCgg_res_requisito);
                }
            }
        }
    });
    gsCgg_res_requisito.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON"
        }
    });

    /**
	  * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_requisito.
	  */
    var winFrmListadoCgg_res_requisito =  null;
         
    if(inDesktop !==null && inDesktop !== undefined ){
        winFrmListadoCgg_res_requisito = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_requisito',
            title:tituloListadoCgg_res_requisito,
            tbar:getPanelTitulo(tituloListadoCgg_res_requisito,descListadoCgg_res_requisito),
            items:[grdCgg_res_requisito],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_requisito,btnEditarCgg_res_requisito,btnEliminarCgg_res_requisito,'->',btnSalirCgg_res_requisito]
        });
    }else{
        winFrmListadoCgg_res_requisito = new Ext.Window({
            id:'winFrmListadoCgg_res_requisito',
            title:tituloListadoCgg_res_requisito,
            tbar:getPanelTitulo(tituloListadoCgg_res_requisito,descListadoCgg_res_requisito),
            items:[grdCgg_res_requisito],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_requisito,btnEditarCgg_res_requisito,btnEliminarCgg_res_requisito,'->',btnSalirCgg_res_requisito]
        });
    }

    /**
	  * Funcion que aplica los privilegios del usuario.
	  */
    applyGrants(winFrmListadoCgg_res_requisito.getBottomToolbar());
    /**
	  * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_requisito.
	  * @returns ventana winFrmCgg_res_requisito.
	  * @base FrmListadoCgg_res_requisito.prototype.show
	  */
    this.getWindow = function(){
        return winFrmListadoCgg_res_requisito;
    }
    /**
	  * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_requisito.
	  * @base FrmListadoCgg_res_requisito.prototype.loadData
	  */
    this.loadData = function(){
        gsCgg_res_requisito.load();
    }
    /**
	  * Funcion miembro que develve el ColumnModel utilizado en el listado.
	  */
    this.getColumnModel = function(){
        return cmCgg_res_requisito;
    }
    /**
	  * Funcion miembro que develve el Store utilizado en el listado.
	  */
    this.getStore = function(){
        return gsCgg_res_requisito;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_requisito.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_requisito.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_requisito desde una instancia.
 */
FrmListadoCgg_res_requisito.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_requisito desde una instancia.
 */
FrmListadoCgg_res_requisito.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_requisito,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_requisito.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_requisito desde una instancia.
 */
FrmListadoCgg_res_requisito.prototype.loadData = function(){
    this.loadData();
}
