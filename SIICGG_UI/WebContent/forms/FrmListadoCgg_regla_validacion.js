/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_regla_validacion.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_regla_validacion(inDesktop){    
	var optMenu = 'Configuraci\u00F3n/Control de informaci\u00F3n/Administraci\u00F3n de validaci\u00F3nes';
    var urlListadoCgg_regla_validacion=URL_WS+"Cgg_regla_validacion";
    var tituloListadoCgg_regla_validacion='Regla de validaci\u00F3n';
    var descListadoCgg_regla_validacion='El formulario permite administrar informaci\u00f3n de reglas de validaci\u00F3n que deben de cumplir cierta informaci\u00F3n.';
    /**
* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_regla_validacion.
*/
    var btnNuevoCgg_regla_validacion = new Ext.Button({
        id:'btnNuevoCgg_regla_validacion',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_regla_validacion = new FrmCgg_regla_validacion("insert");
                objCgg_regla_validacion.closeHandler(function(){
                    gsCgg_regla_validacion.reload();
                });
                objCgg_regla_validacion.show();
            }
        }
    });
    /**
* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_regla_validacion.
*/
    var btnEditarCgg_regla_validacion = new Ext.Button({
        id:'btnEditarCgg_regla_validacion',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_regla_validacion.getSelectionModel().getSelected();
                if(r){
                    var objCgg_regla_validacion = new FrmCgg_regla_validacion("update",r);
                    objCgg_regla_validacion.closeHandler(function(){
                        gsCgg_regla_validacion.reload();
                    });
                    objCgg_regla_validacion.loadData();
                    objCgg_regla_validacion.show();
                }
            }
        }
    });
    /**
* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_regla_validacion.
*/
    var btnEliminarCgg_regla_validacion = new Ext.Button({
        id:'btnEliminarCgg_regla_validacion',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({
                    title:'Aviso',
                    msg:'¿Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_regla_validacion,
                    icon: Ext.MessageBox.QUESTION
                });
                function SWRCgg_regla_validacion(btn){
                    if (btn=='yes'){
                        try{
                            function CallBackCgg_regla_validacion(r){
                                winFrmListadoCgg_regla_validacion.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_regla_validacion,
                                        msg: 'La informaci\u00f3n de Regla validacion ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_regla_validacion.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_regla_validacion,
                                        msg: 'La informaci\u00f3n de Regla validacion no ha podido ser eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_regla_validacion.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCrval_codigo',grdCgg_regla_validacion.getSelectionModel().getSelected().get('CRVAL_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_regla_validacion,"delete",param, true, CallBackCgg_regla_validacion);
                        }catch(inErr){
                            winFrmListadoCgg_regla_validacion.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_regla_validacion.
*/
    var btnSalirCgg_regla_validacion = new Ext.Button({
        id:'btnSalirCgg_regla_validacion',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_regla_validacion.close();
            }
        }
    });
    /**
* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_regla_validacion.
*/
    var cmCgg_regla_validacion = new Ext.grid.ColumnModel([
    {
        dataIndex:'CRVAL_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRVAL_NOMBRE',
        header:'Nombre',
        width:100,
        sortable:true
    },
    {
        dataIndex:'CRVAL_DESCRIPCION',
        header:'Descripci\u00F3n',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRVAL_FUNCION_VALIDACION',
        header:'Funci\u00f3n validaci\u00F3n',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRVAL_OPERADOR_COMPARADOR',
        header:'Comparador',
        width:80,
        renderer:function(inCRVAL_OPERADOR_COMPARADOR){            
            for(var i=0;i<dsOperador.length;i++){
                if(dsOperador[i][0]==inCRVAL_OPERADOR_COMPARADOR){
                    return dsOperador[i][1];
                }
            }
            return NO_DATA_MESSAGE;
        }
    },
    {
        dataIndex:'CGCNF_CODIGO',
        header:'Parametro',
        width:100,
        sortable:true,
        renderer:function(inCGCNF_CODIGO){
            var rConfiguracion = SCGG_CONFIGURACION.getAt(SCGG_CONFIGURACION.findExact('CGCNF_CODIGO',inCGCNF_CODIGO));
            if(rConfiguracion ){
                return rConfiguracion.get('CGCNF_CONFIGURACION');
            }else{
                return NO_DATA_MESSAGE;
            }
        }
    },
    {
        dataIndex:'CRVAL_VALOR_LIBRE',
        header:'Valor',
        width:80
    },
    {
        dataIndex:'CRVAL_RESULTADO_ACEPTACION',
        header:'Resultado aceptaci\u00F3n',
        width:100,
        sortable:true
    },
    {
        dataIndex:'CRVAL_SUGERENCIA',
        header:'Sugerencia',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CRVAL_TIPO',
        header:'Tipo',
        width:150,
        sortable:true,
        renderer:function(inCRVAL_TIPO){
            for(var i=0;i<dsModalidad.length;i++){
                if(dsModalidad[i][0]==inCRVAL_TIPO){
                    return dsModalidad[i][1];
                }
            }
            return NO_DATA_MESSAGE;
        }
    },
    {
        dataIndex:'CRVAR_FECHA_INICIO',
        header:'Fecha inicio',
        width:80,
        sortable:true,
        renderer:truncDate
    },
    {
        dataIndex:'CRVAR_FECHA_FIN',
        header:'Fecha fin',
        width:150,
        sortable:true,
        renderer:truncDate
    },
    {
        dataIndex:'CRVAL_VALOR_1',
        header:'Valor 1',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    },
    {
        dataIndex:'CRVAL_VALOR_2',
        header:'Valor 2',
        width:150,
        sortable:true,
        hidden:true,
        hideable:false
    }]);
    /**
* Ext.data.Store Agrupacion de registros de la tabla Cgg_regla_validacion por un campo especifico.
*/
    var gsCgg_regla_validacion = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_regla_validacion",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRVAL_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CRVAL_CODIGO'
        },

        {
            name:'CGCNF_CODIGO'
        },

        {
            name:'CRVAL_NOMBRE'
        },

        {
            name:'CRVAL_DESCRIPCION'
        },

        {
            name:'CRVAL_FUNCION_VALIDACION'
        },

        {
            name:'CRVAL_OPERADOR_COMPARADOR'
        },

        {
            name:'CRVAL_VALOR_LIBRE'
        },

        {
            name:'CRVAL_RESULTADO_ACEPTACION'
        },

        {
            name:'CRVAL_SUGERENCIA'
        },

        {
            name:'CRVAL_TIPO'
        },

        {
            name:'CRVAR_FECHA_INICIO'
        },

        {
            name:'CRVAR_FECHA_FIN'
        },

        {
            name:'CRVAL_VALOR_1'
        },

        {
            name:'CRVAL_VALOR_2'
        }
        ]),
        sortInfo:{
            field: 'CGCNF_CODIGO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:'JSON'
        }
    });
    /**
* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_regla_validacion.
*/
    var pgBarCgg_regla_validacion= new Ext.PagingToolbar({
        store: gsCgg_regla_validacion,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_regla_validacion en un formato tabular de filas y columnas.
*/
    var grdCgg_regla_validacion = new Ext.grid.GridPanel({
        cm:cmCgg_regla_validacion,
        store:gsCgg_regla_validacion,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        loadMask:{
            msg:"Cargando..."
        },
        tbar: [
        'Buscar: ',
        new Ext.ux.bsx.SearchField({
            store:gsCgg_regla_validacion,
            width:200
        })
        ],
        bbar:pgBarCgg_regla_validacion,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_regla_validacion.hidden){
                    btnEditarCgg_regla_validacion.fireEvent('click', btnEditarCgg_regla_validacion);
                }
            }
        }
    });
    gsCgg_regla_validacion.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:'JSON'
        }
    });
    /**
* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_regla_validacion.
*/
    var winFrmListadoCgg_regla_validacion = null;
    if(inDesktop !== null || inDesktop !== undefined){
        winFrmListadoCgg_regla_validacion = inDesktop.createWindow({
            id:'winFrmListadoCgg_regla_validacion',
            title:tituloListadoCgg_regla_validacion,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            iconCls:'iconRegla',
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_regla_validacion,descListadoCgg_regla_validacion),
            items:[grdCgg_regla_validacion],
            bbar:[btnNuevoCgg_regla_validacion,btnEditarCgg_regla_validacion,btnEliminarCgg_regla_validacion,'->',btnSalirCgg_regla_validacion]
        });
    }else{
        winFrmListadoCgg_regla_validacion = new Ext.Window({
            id:'winFrmListadoCgg_regla_validacion',
            title:tituloListadoCgg_regla_validacion,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            iconCls:'iconRegla',
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_regla_validacion,descListadoCgg_regla_validacion),
            items:[grdCgg_regla_validacion],
            bbar:[btnNuevoCgg_regla_validacion,btnEditarCgg_regla_validacion,btnEliminarCgg_regla_validacion,'->',btnSalirCgg_regla_validacion]
        });
    }

    /**
* Funcion que aplica los privilegios del usuario.
*/
    applyGrants(winFrmListadoCgg_regla_validacion.getBottomToolbar());
    /**
* Funcion miembro que devuelve la ventana winFrmListadoCgg_regla_validacion.
* @returns ventana winFrmCgg_regla_validacion.
* @base FrmListadoCgg_regla_validacion.prototype.show
*/
    this.getWindow = function(){
        return winFrmListadoCgg_regla_validacion;
    }
    /**
* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_regla_validacion.
* @base FrmListadoCgg_regla_validacion.prototype.loadData
*/
    this.loadData = function(){
        gsCgg_regla_validacion.load();
    }
    /**
* Funcion miembro que develve el ColumnModel utilizado en el listado.
*/
    this.getColumnModel = function(){
        return cmCgg_regla_validacion;
    }
    /**
* Funcion miembro que develve el Store utilizado en el listado.
*/
    this.getStore = function(){
        return gsCgg_regla_validacion;
    }
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_regla_validacion.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_regla_validacion.prototype.getStore = function(){
    this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_regla_validacion desde una instancia.
*/
FrmListadoCgg_regla_validacion.prototype.show = function(){
    this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_regla_validacion desde una instancia.
*/
FrmListadoCgg_regla_validacion.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_regla_validacion,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_regla_validacion.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_regla_validacion desde una instancia.
*/
FrmListadoCgg_regla_validacion.prototype.loadData = function(){
    this.loadData();
}
