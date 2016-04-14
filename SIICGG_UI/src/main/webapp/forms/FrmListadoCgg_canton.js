/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_canton.
 * @constructor 
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_canton(inDesktop){
	var optMenu = 'Configuraci\u00F3n/Distribuci\u00F3n geogr\u00E1fica/Administraci\u00F3n de cant\u00f3n';
    var urlListadoCgg_canton=URL_WS+"Cgg_canton";
    var tituloListadoCgg_canton='Listado cant\u00f3n';
    var descListadoCgg_canton='El formulario permite administrar informaci\u00f3n del cant\u00f3n';
    /**
	 * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_canton.
	 */
    var btnNuevoCgg_canton = new Ext.Button({
        id:'btnNuevoCgg_canton',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Nuevo cant\u00f3n',
        listeners:{
            click:function(){
                var objCgg_canton = new FrmCgg_canton("insert");
                objCgg_canton.closeHandler(function(){
                    gsCgg_canton.reload();
                });
                objCgg_canton.show();
            }
        }
    });
    /**
	 * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_canton.
	 */
    var btnEditarCgg_canton = new Ext.Button({
        id:'btnEditarCgg_canton',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:'Editar cant\u00f3n',
        listeners:{
            click:function(){
                var r=grdCgg_canton.getSelectionModel().getSelected();
                if(r){
                    var objCgg_canton = new FrmCgg_canton("update",r);
                    objCgg_canton.closeHandler(function(){
                        gsCgg_canton.reload();
                    });
                    objCgg_canton.loadData();
                    objCgg_canton.show();
                }
            }
        }
    });
    /**
	 * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_canton.
	 */
    var btnEliminarCgg_canton = new Ext.Button({
        id:'btnEliminarCgg_canton',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:'Eliminar cant\u00f3n',
        listeners:{
            click:function(){
                var r=grdCgg_canton.getSelectionModel().getSelected();
                if(r){
                    function SWRCgg_canton(btn){
                        if (btn=='yes'){
                            try{
                                function CallBackCgg_canton(r){
                                    winFrmListadoCgg_canton.getEl().unmask();
                                    if(r=='true'){
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_canton,
                                            msg: 'La informaci\u00f3n de cant\u00f3n ha sido eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });
                                        gsCgg_canton.reload();
                                    }else{
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_canton,
                                            msg: 'La informaci\u00f3n de cant\u00f3n no ha podido ser eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.ERROR
                                        });
                                    }
                                }
                                winFrmListadoCgg_canton.getEl().mask('Eliminando...', 'x-mask-loading');
                                var param = new SOAPClientParameters();
                                param.add('inCctn_codigo',grdCgg_canton.getSelectionModel().getSelected().get('CCTN_CODIGO'));
                                SOAPClient.invoke(urlListadoCgg_canton,"delete",param, true, CallBackCgg_canton);
                            }catch(inErr){
                                winFrmListadoCgg_canton.getEl().unmask();
                            }
                        }
                    }
                }
                Ext.Msg.show({
                    title:'Aviso',
                    msg:'Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_canton,
                    icon: Ext.MessageBox.QUESTION
                });
            }
        }
    });
    /**
	 * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_canton.
	 */
    var btnSalirCgg_canton = new Ext.Button({
        id:'btnSalirCgg_canton',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Salir del formulario',
        listeners:{
            click:function(){
                winFrmListadoCgg_canton.close();
            }
        }
    });   
    /**
	  * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_canton.
	  */
    var cmCgg_canton = new Ext.grid.ColumnModel([
        {
            dataIndex:'CCTN_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CGPRV_CODIGO',
            header:'Provincia',
            width:150,
            sortable:true,
            renderer:function(inCGPRV_CODIGO){
                var i =0;
                var result = 'no datos';
                for(i=0;i<SCGG_PROVINCIA.getCount();i++){
                    var rProvincia = SCGG_PROVINCIA.getAt(i);
                    if(rProvincia.get('CGPRV_CODIGO') == inCGPRV_CODIGO){
                        result = rProvincia.get('CGPRV_NOMBRE');
                        break;
                    }
                }
                return result;
            }
        },
        {
            dataIndex:'CCTN_NOMBRE',
            header:'Canton',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CCTN_DESCRIPCION',
            header:'Descripci\u00f3n',
            width:150,
            sortable:true
        },{
            dataIndex:'CCTN_ABREVIATURA',
            header:'Abreviatura',
            width:150,
            sortable:true
        }
		]);
    /**
	  * Ext.data.Store Agrupacion de registros de la tabla Cgg_canton por un campo especifico.
	  */
    var gsCgg_canton = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_canton",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CCTN_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CCTN_CODIGO'
        },

        {
            name:'CGPRV_CODIGO'
        },

        {
            name:'CCTN_NOMBRE'
        },

        {
            name:'CCTN_DESCRIPCION'
        },
		{
            name:'CCTN_ABREVIATURA'
        }
        ]),
        sortInfo:{
            field: 'CGPRV_CODIGO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    /**
	  * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_canton.
	  */
    var pgBarCgg_canton= new Ext.PagingToolbar({
        store: gsCgg_canton,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
	  * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_canton en un formato tabular de filas y columnas.
	  */
    var grdCgg_canton = new Ext.grid.GridPanel({
        viewConfig:{
            forceFit:true
        },
        cm:cmCgg_canton,
        store:gsCgg_canton,
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
            store:gsCgg_canton,
            width:200
        })
        ],
        bbar:pgBarCgg_canton,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_canton.hidden){
                    btnEditarCgg_canton.fireEvent('click', btnEditarCgg_canton);
                }
            }
        }
    });
    gsCgg_canton.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON"
        }
    });
    /**
	  * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_canton.
	  */
    var winFrmListadoCgg_canton = null;
    if(inDesktop!==null && inDesktop!==undefined)
    {
        var winFrmListadoCgg_canton = inDesktop.createWindow({
            id:'winFrmListadoCgg_canton',
            title:tituloListadoCgg_canton,
            tbar:getPanelTitulo(tituloListadoCgg_canton,descListadoCgg_canton),
            items:[grdCgg_canton],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_canton,btnEditarCgg_canton,btnEliminarCgg_canton,'->',btnSalirCgg_canton]
        });
    }else{
        var winFrmListadoCgg_canton = new Ext.Window({
            id:'winFrmListadoCgg_canton',
			iconCls:'iconAplicacion',
            title:tituloListadoCgg_canton,
            tbar:getPanelTitulo(tituloListadoCgg_canton,descListadoCgg_canton),
            items:[grdCgg_canton],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_canton,btnEditarCgg_canton,btnEliminarCgg_canton,'->',btnSalirCgg_canton]
        });
    }
    /**
	  * Funcion que aplica los privilegios del usuario.
	  */
    applyGrants(winFrmListadoCgg_canton.getBottomToolbar());
    /**
	  * Funcion miembro que devuelve la ventana winFrmListadoCgg_canton.
	  * @returns ventana winFrmCgg_canton.
	  * @base FrmListadoCgg_canton.prototype.show
	  */
    this.getWindow = function(){
        return winFrmListadoCgg_canton;
    }
    /**
	  * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_canton.
	  * @base FrmListadoCgg_canton.prototype.loadData
	  */
    this.loadData = function(){
        gsCgg_canton.load();
    }
    /**
	  * Funcion miembro que develve el ColumnModel utilizado en el listado.
	  */
    this.getColumnModel = function(){
        return cmCgg_canton;
    }
    /**
	  * Funcion miembro que develve el Store utilizado en el listado.
	  */
    this.getStore = function(){
        return gsCgg_canton;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_canton.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_canton.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_canton desde una instancia.
 */
FrmListadoCgg_canton.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_canton desde una instancia.
 */
FrmListadoCgg_canton.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_canton,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_canton.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_canton desde una instancia.
 */
FrmListadoCgg_canton.prototype.loadData = function(){
    this.loadData();
}
