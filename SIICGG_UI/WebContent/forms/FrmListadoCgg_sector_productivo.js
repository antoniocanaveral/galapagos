/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_sector_productivo.
 * @constructor 
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_sector_productivo(inDesktop){
    var optMenu = 'Configuraci\u00f3n/Administraci\u00f3n sector productivo';
    var urlListadoCgg_sector_productivo=URL_WS+"Cgg_sector_productivo";
    var tituloListadoCgg_sector_productivo='Administraci\u00f3n sector productivo';
    var descListadoCgg_sector_productivo='El formulario permite administrar informaci\u00f3n del Sector productivo';
    /**
	 * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_sector_productivo.
	 */
    var btnNuevoCgg_sector_productivo = new Ext.Button({
        id:'btnNuevoCgg_sector_productivo',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Nuevo sector productivo',
        listeners:{
            click:function(){
                var objCgg_sector_productivo = new FrmCgg_sector_productivo("insert");
                objCgg_sector_productivo.closeHandler(function(){
                    gsCgg_sector_productivo.reload();
                });
                objCgg_sector_productivo.show();
            }
        }
    });
    /**
	 * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_sector_productivo.
	 */
    var btnEditarCgg_sector_productivo = new Ext.Button({
        id:'btnEditarCgg_sector_productivo',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:'Editar sector productivo',
        listeners:{
            click:function(){
                var r=grdCgg_sector_productivo.getSelectionModel().getSelected();
                if(r){
                    var objCgg_sector_productivo = new FrmCgg_sector_productivo("update",r);
                    objCgg_sector_productivo.closeHandler(function(){
                        gsCgg_sector_productivo.reload();
                    });
                    objCgg_sector_productivo.loadData();
                    objCgg_sector_productivo.show();
                }
            }
        }
    });
    /**
	 * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_sector_productivo.
	 */
    var btnEliminarCgg_sector_productivo = new Ext.Button({
        id:'btnEliminarCgg_sector_productivo',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:'Eliminar sector productivo',
        listeners:{
            click:function(){
                Ext.Msg.show({
                    title:'Aviso',
                    msg:'Est\u00e1 seguro de eliminar el sector productivo?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_sector_productivo,
                    icon: Ext.MessageBox.QUESTION
                });
                function SWRCgg_sector_productivo(btn){
                    if (btn=='yes'){
                        try{
                            function CallBackCgg_sector_productivo(r){
                                winFrmListadoCgg_sector_productivo.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_sector_productivo,
                                        msg: 'La informaci\u00f3n de sector productivo ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_sector_productivo.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_sector_productivo,
                                        msg: 'La informaci\u00f3n de sector productivo no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_sector_productivo.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCsctp_codigo',grdCgg_sector_productivo.getSelectionModel().getSelected().get('CSCTP_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_sector_productivo,"delete",param, true, CallBackCgg_sector_productivo);
                        }catch(inErr){
                            winFrmListadoCgg_sector_productivo.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
	 * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_sector_productivo.
	 */
    var btnSalirCgg_sector_productivo = new Ext.Button({
        id:'btnSalirCgg_sector_productivo',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Salir del formulario',
        listeners:{
            click:function(){
                winFrmListadoCgg_sector_productivo.close();
            }
        }
    });
    
    /**
	  * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_sector_productivo.
	  */
    var cmCgg_sector_productivo = new Ext.grid.ColumnModel([
    {
        dataIndex:'CSCTP_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CGG_CSCTP_CODIGO',
        header:'Sector',
        width:150,
        sortable:true,
        renderer:function(inCGG_CSCTP_CODIGO){
            var scpSectorProductivo = new SOAPClientParameters();
            scpSectorProductivo.add('inCsctp_codigo',inCGG_CSCTP_CODIGO);
            scpSectorProductivo.add('format',TypeFormat.JSON);
            var tmpCsctpSectorProductivo = SOAPClient.invoke(URL_WS+"Cgg_sector_productivo", 'select', scpSectorProductivo, false, null);
            try{
                tmpCsctpSectorProductivo = Ext.util.JSON.decode(tmpCsctpSectorProductivo);
                return tmpCsctpSectorProductivo[0].CSCTP_NOMBRE;
            }catch(inErr){
                return "Informaci\u00F3n no disponible";
            }
        }
    },
    {
        dataIndex:'CSCTP_NOMBRE',
        header:'Nombre',
        width:150,
        sortable:true
    },{
        dataIndex:'CSCTP_DESCRIPCION',
        header:'Descripci\u00F3n',
        width:150,
        sortable:true
    }]);
    /**
	  * Ext.data.Store Agrupacion de registros de la tabla Cgg_sector_productivo por un campo especifico.
	  */
    var gsCgg_sector_productivo = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_sector_productivo",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CSCTP_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CSCTP_CODIGO'
        },

        {
            name:'CGG_CSCTP_CODIGO'
        },
        {
            name:'CSCTP_NOMBRE'
        },
        {
            name:'CSCTP_DESCRIPCION'
        }
        ]),
        sortInfo:{
            field: 'CGG_CSCTP_CODIGO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON"
        }
    });
    /**
	  * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_sector_productivo.
	  */
    var pgBarCgg_sector_productivo= new Ext.PagingToolbar({
        store: gsCgg_sector_productivo,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
	  * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_sector_productivo en un formato tabular de filas y columnas.
	  */
    var grdCgg_sector_productivo = new Ext.grid.GridPanel({
        cm:cmCgg_sector_productivo,
        store:gsCgg_sector_productivo,
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
            store:gsCgg_sector_productivo,
            width:200
        })
        ],
        bbar:pgBarCgg_sector_productivo,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_sector_productivo.hidden){
                    btnEditarCgg_sector_productivo.fireEvent('click', btnEditarCgg_sector_productivo);
                }
            }
        }
    });
    gsCgg_sector_productivo.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:"JSON"
        }
    });
    /**
	  * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_sector_productivo.
	  */
    var winFrmListadoCgg_sector_productivo = null;
    if(inDesktop!==null && inDesktop!==undefined)
    {
        var winFrmListadoCgg_sector_productivo = inDesktop.createWindow({
            id:'winFrmListadoCgg_sector_productivo',
            title:tituloListadoCgg_sector_productivo,
            tbar:getPanelTitulo(tituloListadoCgg_sector_productivo,descListadoCgg_sector_productivo),
            items:[grdCgg_sector_productivo],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_sector_productivo,btnEditarCgg_sector_productivo,btnEliminarCgg_sector_productivo,'->',btnSalirCgg_sector_productivo]
        });
    }else{
        var winFrmListadoCgg_sector_productivo = new Ext.Window({
            id:'winFrmListadoCgg_sector_productivo',
            title:tituloListadoCgg_sector_productivo,
            tbar:getPanelTitulo(tituloListadoCgg_sector_productivo,descListadoCgg_sector_productivo),
            items:[grdCgg_sector_productivo],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_sector_productivo,btnEditarCgg_sector_productivo,btnEliminarCgg_sector_productivo,'->',btnSalirCgg_sector_productivo]
        });
		 
    }
    /**
	  * Funcion que aplica los privilegios del usuario.
	  */
    applyGrants(winFrmListadoCgg_sector_productivo.getBottomToolbar());
    /**
	  * Funcion miembro que devuelve la ventana winFrmListadoCgg_sector_productivo.
	  * @returns ventana winFrmCgg_sector_productivo.
	  * @base FrmListadoCgg_sector_productivo.prototype.show
	  */
    this.getWindow = function(){
        return winFrmListadoCgg_sector_productivo;
    }
    /**
	  * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_sector_productivo.
	  * @base FrmListadoCgg_sector_productivo.prototype.loadData
	  */
    this.loadData = function(){
        gsCgg_sector_productivo.load();
    }
    /**
	  * Funcion miembro que develve el ColumnModel utilizado en el listado.
	  */
    this.getColumnModel = function(){
        return cmCgg_sector_productivo;
    }
    /**
	  * Funcion miembro que develve el Store utilizado en el listado.
	  */
    this.getStore = function(){
        return gsCgg_sector_productivo;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_sector_productivo.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_sector_productivo.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_sector_productivo desde una instancia.
 */
FrmListadoCgg_sector_productivo.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_sector_productivo desde una instancia.
 */
FrmListadoCgg_sector_productivo.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_sector_productivo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_sector_productivo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_sector_productivo desde una instancia.
 */
FrmListadoCgg_sector_productivo.prototype.loadData = function(){
    this.loadData();
}
