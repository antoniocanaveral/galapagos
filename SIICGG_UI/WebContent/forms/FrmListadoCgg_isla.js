/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_isla.
 * @constructor 
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_isla(inDesktop){    
	var optMenu = 'Configuraci\u00F3n/Distribuci\u00F3n geogr\u00E1fica/Administraci\u00F3n de isla';
    var urlListadoCgg_isla=URL_WS+"Cgg_isla";
    var tituloListadoCgg_isla='Listado isla - ciudad';
    var descListadoCgg_isla='El formulario permite administrar informaci\u00f3n de la isla o ciudad';
    /**
	 * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_isla.
	 */
    var btnNuevoCgg_isla = new Ext.Button({
        id:'btnNuevoCgg_isla',
        text:'Nuevo',
        iconCls:'iconNuevo',        
        listeners:{
            click:function(){
                var objCgg_isla = new FrmCgg_isla("insert");
                objCgg_isla.closeHandler(function(){
                    gsCgg_isla.reload();
                });
                objCgg_isla.show();
            }
        }
    });
    /**
	 * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_isla.
	 */
    var btnEditarCgg_isla = new Ext.Button({
        id:'btnEditarCgg_isla',
        text:'Editar',
        iconCls:'iconEditar',        
        listeners:{
            click:function(){
                var r=grdCgg_isla.getSelectionModel().getSelected();
                if(r){
                    var objCgg_isla = new FrmCgg_isla("update",r);
                    objCgg_isla.closeHandler(function(){
                        gsCgg_isla.reload();
                    });
                    objCgg_isla.loadData();
                    objCgg_isla.show();
                }
            }
        }
    });
    /**
	 * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_isla.
	 */
    var btnEliminarCgg_isla = new Ext.Button({
        id:'btnEliminarCgg_isla',
        text:'Eliminar',
        iconCls:'iconEliminar',        
        listeners:{
            click:function(){
                var r=grdCgg_isla.getSelectionModel().getSelected();
                if(r){
                    function SWRCgg_isla(btn){
                        if (btn=='yes'){
                            try{
                                function CallBackCgg_isla(r){
                                    winFrmListadoCgg_isla.getEl().unmask();
                                    if(r=='true'){
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_isla,
                                            msg: 'La informaci\u00F3n de la isla ha sido eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });
                                        gsCgg_isla.reload();
                                    }else{
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_isla,
                                            msg: 'La informaci\u00F3n de isla no ha podido ser eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.ERROR
                                        });
                                    }
                                }
                                winFrmListadoCgg_isla.getEl().mask('Eliminando...', 'x-mask-loading');
                                var param = new SOAPClientParameters();
                                param.add('inCisla_codigo',grdCgg_isla.getSelectionModel().getSelected().get('CISLA_CODIGO'));
                                SOAPClient.invoke(urlListadoCgg_isla,"delete",param, true, CallBackCgg_isla);
                            }catch(inErr){
                                winFrmListadoCgg_isla.getEl().unmask();
                            }
                        }
                    }
                }
                Ext.Msg.show({
                    title:'Aviso',
                    msg:'Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_isla,
                    icon: Ext.MessageBox.QUESTION
                });
            }
        }
    });
    /**
	 * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_isla.
	 */
    var btnSalirCgg_isla = new Ext.Button({
        id:'btnSalirCgg_isla',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Salir del formulario',
        listeners:{
            click:function(){
                winFrmListadoCgg_isla.close();
            }
        }
    });
    /**
	  * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_isla.
	  */
    var cmCgg_isla = new Ext.grid.ColumnModel([
    {
        dataIndex:'CISLA_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CCTN_CODIGO',
        header:'Cant\u00F3n',
        width:150,
        sortable:true,
        renderer:function(inCCTN_CODIGO){
            var i =0;
            var result = 'no datos';
            for(i=0;i<SCGG_CANTON.getCount();i++){
                var rCanton = SCGG_CANTON.getAt(i);
                if(rCanton.get('CCTN_CODIGO') == inCCTN_CODIGO){
                    result = rCanton.get('CCTN_NOMBRE');
                    break;
                }
            }
            return result;
        }
    },
    {
        dataIndex:'CISLA_NOMBRE',
        header:'Isla',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CISLA_ABREVIATURA',
        header:'Abreviatura',
        width:150,
        sortable:true
    },

    {
        dataIndex:'CISLA_INDICE',
        header:'Indice',
        width:100,
        sortable:true
    }]);
    /**
	  * Ext.data.Store Agrupacion de registros de la tabla Cgg_isla por un campo especifico.
	  */
    var gsCgg_isla = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_isla",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CISLA_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CISLA_CODIGO'
        },

        {
            name:'CCTN_CODIGO'
        },

        {
            name:'CISLA_NOMBRE'
        },

        {
            name:'CISLA_ABREVIATURA'
        },

        {
            name:'CISLA_INDICE'
        }
        ]),
        sortInfo:{
            field: 'CCTN_CODIGO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    /**
	  * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_isla.
	  */
    var pgBarCgg_isla= new Ext.PagingToolbar({
        store: gsCgg_isla,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00F3n para mostrar'
    });
    /**
	  * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_isla en un formato tabular de filas y columnas.
	  */
    var grdCgg_isla = new Ext.grid.GridPanel({
        viewConfig:{
            forceFit:true
        },
        cm:cmCgg_isla,
        store:gsCgg_isla,
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
            store:gsCgg_isla,
            width:200
        })
        ],
        bbar:pgBarCgg_isla,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_isla.hidden){
                    btnEditarCgg_isla.fireEvent('click', btnEditarCgg_isla);
                }
            }
        }
    });
    gsCgg_isla.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON"
        }
    });
    /**
	  * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_isla.
	  */
    var winFrmListadoCgg_isla = null;
    if(inDesktop!==null && inDesktop!==undefined)
    {
        var winFrmListadoCgg_isla = inDesktop.createWindow({
            id:'winFrmListadoCgg_isla',
            title:tituloListadoCgg_isla,
            tbar:getPanelTitulo(tituloListadoCgg_isla,descListadoCgg_isla),
            items:[grdCgg_isla],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_isla,btnEditarCgg_isla,btnEliminarCgg_isla,'->',btnSalirCgg_isla]
        });
    }else{
        var winFrmListadoCgg_isla = new Ext.Window({
            id:'winFrmListadoCgg_isla',
            title:tituloListadoCgg_isla,
            tbar:getPanelTitulo(tituloListadoCgg_isla,descListadoCgg_isla),
            items:[grdCgg_isla],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_isla,btnEditarCgg_isla,btnEliminarCgg_isla,'->',btnSalirCgg_isla]
        });
    }
    /**
	  * Funcion que aplica los privilegios del usuario.
	  */
    applyGrants(winFrmListadoCgg_isla.getBottomToolbar());
    /**
	  * Funcion miembro que devuelve la ventana winFrmListadoCgg_isla.
	  * @returns ventana winFrmCgg_isla.
	  * @base FrmListadoCgg_isla.prototype.show
	  */
    this.getWindow = function(){
        return winFrmListadoCgg_isla;
    }
    /**
	  * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_isla.
	  * @base FrmListadoCgg_isla.prototype.loadData
	  */
    this.loadData = function(){
        gsCgg_isla.load();
    }
    /**
	  * Funcion miembro que develve el ColumnModel utilizado en el listado.
	  */
    this.getColumnModel = function(){
        return cmCgg_isla;
    }
    /**
	  * Funcion miembro que develve el Store utilizado en el listado.
	  */
    this.getStore = function(){
        return gsCgg_isla;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_isla.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_isla.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_isla desde una instancia.
 */
FrmListadoCgg_isla.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_isla desde una instancia.
 */
FrmListadoCgg_isla.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_isla,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_isla.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_isla desde una instancia.
 */
FrmListadoCgg_isla.prototype.loadData = function(){
    this.loadData();
}
