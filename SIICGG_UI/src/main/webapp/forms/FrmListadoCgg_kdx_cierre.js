/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_kdx_cierre.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_kdx_cierre(inDescktop){
    var optMenu = 'Kardex/Cierre Caja';
    var urlListadoCgg_kdx_cierre=URL_WS+"Cgg_kdx_cierre";
    var tituloListadoCgg_kdx_cierre='Cierre de caja';
    var descListadoCgg_kdx_cierre='El formulario permite administrar informaci\u00f3n de cierre de caja';
    var myJasperServer = new JasperServer();
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_kdx_cierre.
     */
    var btnNuevoCgg_kdx_cierre = new Ext.Button({
        id:'btnNuevoCgg_kdx_cierre',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_kdx_cierre = new FrmCgg_kdx_cierre("insert");
                objCgg_kdx_cierre.closeHandler(function(){
                    gsCgg_kdx_cierre.reload();
                });
                objCgg_kdx_cierre.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_kdx_cierre.
     */
    var btnEditarCgg_kdx_cierre = new Ext.Button({
        id:'btnEditarCgg_kdx_cierre',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_kdx_cierre.getSelectionModel().getSelected();
                if(r){
                    var objCgg_kdx_cierre = new FrmCgg_kdx_cierre("update",r);
                    objCgg_kdx_cierre.closeHandler(function(){
                        gsCgg_kdx_cierre.reload();
                    });
                    objCgg_kdx_cierre.loadData();
                    objCgg_kdx_cierre.show();
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_kdx_cierre.
     */
    var btnEliminarCgg_kdx_cierre = new Ext.Button({
        id:'btnEliminarCgg_kdx_cierre',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({
                    title:'Aviso',
                    msg:'¿Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_kdx_cierre,
                    icon: Ext.MessageBox.QUESTION
                });
                function SWRCgg_kdx_cierre(btn){
                    if (btn=='yes'){
                        try{
                            function CallBackCgg_kdx_cierre(r){
                                winFrmListadoCgg_kdx_cierre.getEl().unmask();
                                if(r=='true'){
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_kdx_cierre,
                                        msg: 'La informaci\u00f3n de Cierre de caja ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_kdx_cierre.reload();
                                }else{
                                    Ext.Msg.show({
                                        title:tituloListadoCgg_kdx_cierre,
                                        msg: 'La informaci\u00f3n de Cierre de caja no ha podido ser eliminada.'+(r.message?r.message:r),
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            winFrmListadoCgg_kdx_cierre.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCkcrr_codigo',grdCgg_kdx_cierre.getSelectionModel().getSelected().get('CKCRR_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_kdx_cierre,"delete",param, true, CallBackCgg_kdx_cierre);
                        }catch(inErr){
                            winFrmListadoCgg_kdx_cierre.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
	
	
    /**
*Ext.Button Boton que permite imprimir el reporte de cierre de caja
*/
    var btnReporteCgg_kdx_cierre=new Ext.Button({
        id:'btnReporteCgg_kdx_cierre',
        name:'btnReporteCgg_kdx_cierre',
        text:'Imprimir cierre',
        iconCls:'iconImprimir',
        listeners:{
            click:function(){
                var tmpRecord = grdCgg_kdx_cierre.getSelectionModel().getSelected();
                if(tmpRecord){
				
                    var pReport = [];
                    pReport[0]=
                    {
                        objectName:'FrmListadoCgg_usuario',
                        label:'Para',
                        valueField:'CUSU_CODIGO',
                        displayField:'CUSU_NOMBRE_USUARIO',
                        paramName:'P_CUSU_CODIGO',
                        paramValue:'',
                        type:'searchable'
                    };

                    pReport[1]={
                        label:'N. Cierre',
                        paramName:'P_CKCRR_CODIGO',
                        paramValue:tmpRecord.get('CKCRR_CODIGO'),
                        value:tmpRecord.get('CKCRR_NUMERO_CIERRE'),
                        type:'direct'
                    };

                    pReport[2]=
                    {
                        label:'N. guia blindado',
                        paramName:'P_NUMERO_GUIA',
                        paramValue:'',
                        type:'input',
                        required:true
                    };
                    pReport[3]=
                    {
                        label:'No. funda entregado',
                        paramName:'P_NUMERO_FUNDA',
                        paramValue:'',
                        type:'input',
                        required:true
                    };
                    pReport[4]=
                    {
                        label:'Recibo caja',
                        paramName:'P_RECIBO_CAJA',
                        paramValue:'',
                        type:'input',
                        required:true
                    };
                    
                    var reporte = new FrmCriterioReporte('rptCierreCaja', '/Reports/sii/kardex', null);
                    reporte.addParams(pReport);
                    reporte.show();
                }	
            }			
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_kdx_cierre.
     */
    var btnSalirCgg_kdx_cierre = new Ext.Button({
        id:'btnSalirCgg_kdx_cierre',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_kdx_cierre.close();
            }
        }
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_kdx_cierre.
     */
    var cmCgg_kdx_cierre = new Ext.grid.ColumnModel([
    {
        dataIndex:'CKCRR_NUMERO_CIERRE',
        header:'Numero cierre',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CKCRR_FECHA_CIERRE',
        header:'Fecha cierre',
        width:150,
        sortable:true,
        renderer:truncDate
    },
    {
        dataIndex:'CKCRR_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },
    {
        dataIndex:'CKPVT_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },
    {
        dataIndex:'CKPVT_NOMBRE',
        header:'Punto Venta',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CKVNT_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },
    {
        dataIndex:'CKVNT_NUMERO_VENTA',
        header:'No. Venta',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CKUPV_CODIGO',
        header:'Codigo',
        width:150,
        sortable:true,
        hidden:true
    },
    {
        dataIndex:'CRPER_NOMBRES',
        header:'Usuario',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CKCRR_TOTAL_VENTA',
        header:'Total venta',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CKCRR_TOTAL',
        header:'Total',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CKCRR_OBSERVACION',
        header:'Observacion',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CKCRR_DIFERENCIA',
        header:'Diferencia',
        width:150,
        sortable:true
    },
    {
        dataIndex:'CKCRR_ESTADO_CIERRE',
        header:'Estado cierre',
        width:150,
        sortable:true,
        renderer:function(inCkcrr_estado){
            if(inCkcrr_estado==TypeEstadoCierre.REGISTRADA){
                return('REGISTRADA')
            }
            if(inCkcrr_estado==TypeEstadoCierre.CONFIRMADA){
                return('CONFIRMADA')
            }
        }
    }]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_kdx_cierre por un campo especifico.
     */
    var gsCgg_kdx_cierre = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_cierre",
            method:"selectPageDirect1",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CKCRR_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {
            name:'CKCRR_CODIGO'
        },

        {
            name:'CKPVT_CODIGO'
        },

        {
            name:'CKPVT_NOMBRE'
        },

        {
            name:'CKVNT_CODIGO'
        },

        {
            name:'CKVNT_NUMERO_VENTA'
        },

        {
            name:'CKUPV_CODIGO'
        },

        {
            name:'CRPER_NOMBRES'
        },

        {
            name:'CKCRR_FECHA_CIERRE'
        },

        {
            name:'CKCRR_NUMERO_CIERRE'
        },

        {
            name:'CKCRR_TOTAL_VENTA'
        },

        {
            name:'CKCRR_TOTAL'
        },

        {
            name:'CKCRR_OBSERVACION'
        },

        {
            name:'CKCRR_DIFERENCIA'
        },

        {
            name:'CKCRR_ESTADO_CIERRE'
        }
        ]),
        sortInfo:{
            field: 'CKCRR_FECHA_CIERRE',
            direction: 'DESC'
        },
        baseParams:{
            keyword:"",
            format:'JSON'
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_kdx_cierre.
     */
    var pgBarCgg_kdx_cierre= new Ext.PagingToolbar({
        store: gsCgg_kdx_cierre,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_kdx_cierre en un formato tabular de filas y columnas.
     */
    var grdCgg_kdx_cierre = new Ext.grid.GridPanel({
        cm:cmCgg_kdx_cierre,
        store:gsCgg_kdx_cierre,
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
            store:gsCgg_kdx_cierre,
            width:200
        })
        ],
        bbar:pgBarCgg_kdx_cierre,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_kdx_cierre.hidden){
                    btnEditarCgg_kdx_cierre.fireEvent('click', btnEditarCgg_kdx_cierre);
                }
            }
        }
    });
    gsCgg_kdx_cierre.reload({
        params:{
            start:0,
            limit:RECORD_PAGE,
            format:'JSON'
        }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_kdx_cierre.
     */
    if(inDescktop){
        var winFrmListadoCgg_kdx_cierre = inDescktop.createWindow({
            id:'winFrmListadoCgg_kdx_cierre',
            title:tituloListadoCgg_kdx_cierre,
            iconCls:'iconAplicacion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_kdx_cierre,descListadoCgg_kdx_cierre),
            items:[grdCgg_kdx_cierre],
            bbar:[btnNuevoCgg_kdx_cierre,btnEditarCgg_kdx_cierre,btnEliminarCgg_kdx_cierre,btnReporteCgg_kdx_cierre,'->',btnSalirCgg_kdx_cierre]
        });
        /**
     * Funcion que aplica los privilegios del usuario.
     */
        applyGrants(winFrmListadoCgg_kdx_cierre.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_kdx_cierre.
     * @returns ventana winFrmCgg_kdx_cierre.
     * @base FrmListadoCgg_kdx_cierre.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_kdx_cierre;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_kdx_cierre.
     * @base FrmListadoCgg_kdx_cierre.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_kdx_cierre.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_kdx_cierre;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_kdx_cierre;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_kdx_cierre.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_kdx_cierre.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_kdx_cierre desde una instancia.
 */
FrmListadoCgg_kdx_cierre.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_kdx_cierre desde una instancia.
 */
FrmListadoCgg_kdx_cierre.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_kdx_cierre,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_kdx_cierre.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_kdx_cierre desde una instancia.
 */
FrmListadoCgg_kdx_cierre.prototype.loadData = function(){
    this.loadData();
}
