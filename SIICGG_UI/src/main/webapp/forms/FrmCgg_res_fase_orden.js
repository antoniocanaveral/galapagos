/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_fase.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmCgg_res_fase_orden(INSENTENCIA_CGG_RES_FASE,INCRPRO_CODIGO){
    var urlCgg_res_fase=URL_WS+"Cgg_res_fase";
    var tituloListadoCgg_res_fase='Listado Res fase';
    var descListadoCgg_res_fase='El formulario permite administrar informaci\u00f3n de la tabla Res fase';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmCgg_res_fase_orden.
     */
    var btnAceptarCgg_res_fase_orden = new Ext.Button({
        id:'btnAceptarCgg_res_fase_orden',
        text:'Aceptar',
        iconCls:'iconAceptar',
        listeners:{
            click:function(){
                /*  if (pnlCgg_res_fase.getForm().isValid()==false){
                 return;
                 }*/
                try{
                    function CallBackCgg_res_fase(r){
                        grdCgg_res_fase.getEl().unmask();
                        if(r=='true'){
                            Ext.Msg.show({
                                title:tituloListadoCgg_res_fase,
                                msg: 'La informaci\u00f3n de fase ha sido actualizada correctamente.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.INFO
                            });
                            winFrmCgg_res_fase_orden.close()
                        }else{
                            Ext.Msg.show({
                                title:tituloListadoCgg_res_fase,
                                msg: 'La informaci\u00f3n de fase NO ha podido ser almacenada.',
                                buttons: Ext.Msg.OK,
                                icon: Ext.MessageBox.ERROR
                            });
                        }
                    }
                    grdCgg_res_fase.getEl().mask('Guardando...', 'x-mask-loading');
                    var param = new SOAPClientParameters();
                    param.add('inCrfase_JSON',grdCgg_res_fase.getStore().getJsonData());
                    SOAPClient.invoke(urlCgg_res_fase,INSENTENCIA_CGG_RES_FASE + '2',param, true, CallBackCgg_res_fase);
                }catch(inErr){
                    alert(inErr);
                    winFrmCgg_res_fase_orden.getEl().unmask();
                }
            }
        }
    });

    /**
     * Ext.Button Boton que permite salir de la ventana winFrmCgg_res_fase_orden.
     */
    var btnSalirCgg_res_fase_orden = new Ext.Button({
        id:'btnSalirCgg_res_fase_orden',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmCgg_res_fase_orden.close();
            }
        }
    });

    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_fase.
     */
    var cmCgg_res_fase = new Ext.grid.ColumnModel([
        new Ext.grid.RowNumberer(),
        {
            dataIndex:'CRFAS_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CRPRO_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CRFAS_NOMBRE',
            header:'Nombre',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CRFAS_TAREA_REALIZA',
            header:'Tarea realiza',
            width:200,
            sortable:true
        },
        {
            dataIndex:'CGG_CRFAS_CODIGO',
            header:'Fase principal',
            width:150,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CRFAS_ORDEN',
            header:'Orden',
            width:150,
            sortable:true,
            hidden:true,
            renderer:function(value,obj,record){
                //grdCgg_res_fase.getStore().set('CRFAS_ORDEN',grdCgg_res_fase.getStore().indexOf(record));
                return grdCgg_res_fase.getStore().indexOf(record);
            }
        },
        {
            dataIndex:'CRETT_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CGG_CRETT_CODIGO',
            header:'Crett codigo',
            width:150,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CRSEC_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CGG_CUSU_CODIGO',
            header:'Cusu codigo',
            width:150,
            sortable:true,
            hidden:true
        },
        {
            dataIndex:'CRFAS_SUBE_ADJUNTO',
            header:'Sube adjunto',
            width:50,
            sortable:true,
            xtype:'checkcolumn'
        }
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_fase por un campo especifico.
     */
    var gsCgg_res_fase = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_fase",
            method:"selectParentFase",
            pagin:false
        }),
        remoteSort:false,
        reader:new Ext.data.JsonReader({
        },[
            {
                name:'CRFAS_CODIGO'
            },

            {
                name:'CRPRO_CODIGO'
            },

            {
                name:'CRFAS_NOMBRE'
            },
            {
                name:'CRFAS_TAREA_REALIZA'
            },
            {
                name:'CGG_CRFAS_CODIGO'
            },

            {
                name:'CRETT_CODIGO'
            },

            {
                name:'CGG_CRETT_CODIGO'
            },

            {
                name:'CRSEC_CODIGO'
            },
            {
                name:'CGG_CUSU_CODIGO'
            },


            {
                name:'CRFAS_ORDEN'
            },
            {
                name:'CRFAS_SUBE_ADJUNTO'
            }
        ]),
        sortInfo:{
            field: 'CRFAS_ORDEN',
            direction: 'ASC'
        },
        baseParams:{
            inCrpro_codigo:"",
            format:TypeFormat.JSON
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_fase.
     */
    var pgBarCgg_res_fase= new Ext.PagingToolbar({
        store: gsCgg_res_fase,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    var html='<div id="tituloGeneral">titulo</div>';
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_fase en un formato tabular de filas y columnas.
     */
    var grdCgg_res_fase = new Ext.grid.GridPanel({
        cm:cmCgg_res_fase,
        store:gsCgg_res_fase,
        region:'center',
        title:'Ordenamiento fases',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        viewConfig:{forceFit:true},
        loadMask:{
            msg:"Cargando..."
        },
        tbar: [
            {
                iconCls:'iconInicio',
                tooltip:'Inicio',
                handler:function()
                {
                    var tmpRecord = grdCgg_res_fase.getSelectionModel().getSelected();
                    var tmpIndex = grdCgg_res_fase.getStore().indexOf(tmpRecord);
                    if(tmpIndex>0)
                    {
                        //tmpRecord.set('CRFAS_ORDEN',tmpIndex-1);
                        grdCgg_res_fase.getStore().removeAt(tmpIndex);
                        grdCgg_res_fase.getStore().insert(0,tmpRecord);
                        grdCgg_res_fase.getSelectionModel().selectFirstRow();
                        for(var i=0;i<grdCgg_res_fase.getStore().getCount();i++){
                            grdCgg_res_fase.getStore().getAt(i).set('CRFAS_ORDEN',i);

                        }

                    }
                }
            },
            {
                iconCls:'iconArriba',
                tooltip:'Arriba',
                handler:function()
                {
                    var tmpRecord = grdCgg_res_fase.getSelectionModel().getSelected();
                    var tmpIndex = grdCgg_res_fase.getStore().indexOf(tmpRecord);
                    if(tmpIndex>0)
                    {
                        //tmpRecord.set('CRFAS_ORDEN',tmpIndex-1);
                        grdCgg_res_fase.getStore().removeAt(tmpIndex);
                        grdCgg_res_fase.getStore().insert(tmpIndex-1,tmpRecord);
                        grdCgg_res_fase.getSelectionModel().selectPrevious();
                        for(var i=0;i<grdCgg_res_fase.getStore().getCount();i++){
                            grdCgg_res_fase.getStore().getAt(i).set('CRFAS_ORDEN',i);

                        }

                    }
                }
            },
            {
                iconCls:'iconAbajo',
                tooltip:'Abajo',
                handler:function()
                {
                    var tmpRecord = grdCgg_res_fase.getSelectionModel().getSelected();
                    var tmpIndex = grdCgg_res_fase.getStore().indexOf(tmpRecord);
                    if(grdCgg_res_fase.getStore().getCount()-1>tmpIndex)
                    {
                        tmpRecord.set('CRFAS_ORDEN',tmpIndex+1);
                        grdCgg_res_fase.getStore().removeAt(tmpIndex);
                        grdCgg_res_fase.getStore().insert(tmpIndex+1,tmpRecord);
                        grdCgg_res_fase.getSelectionModel().selectNext();
                        for(var i=0;i<grdCgg_res_fase.getStore().getCount();i++){
                            grdCgg_res_fase.getStore().getAt(i).set('CRFAS_ORDEN',i);

                        }

                    }


                }
            },
            {
                iconCls:'iconFinal',
                tooltip:'Final',
                handler:function()
                {
                    var tmpRecord = grdCgg_res_fase.getSelectionModel().getSelected();
                    var tmpIndex = grdCgg_res_fase.getStore().indexOf(tmpRecord);
                    if(grdCgg_res_fase.getStore().getCount()-1>tmpIndex)
                    {
                        tmpRecord.set('CRFAS_ORDEN',tmpIndex+1);
                        grdCgg_res_fase.getStore().removeAt(tmpIndex);
                        grdCgg_res_fase.getStore().insert(grdCgg_res_fase.getStore().getCount(),tmpRecord);
                        grdCgg_res_fase.getSelectionModel().selectLastRow();
                        for(var i=0;i<grdCgg_res_fase.getStore().getCount();i++){
                            grdCgg_res_fase.getStore().getAt(i).set('CRFAS_ORDEN',i);

                        }

                    }


                }
            }

        ],
        bbar:pgBarCgg_res_fase

    });
    gsCgg_res_fase.reload({
        params:{
            inCrpro_codigo:INCRPRO_CODIGO,
            format:TypeFormat.JSON
        }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_fase.
     */
    /* var winFrmCgg_res_fase_orden = null;
     if(inDesktop!==null && inDesktop!==undefined){
     winFrmCgg_res_fase_orden  = inDesktop.createWindow({
     id:'winFrmCgg_res_fase_orden',
     title:tituloListadoCgg_res_fase,
     tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_fase,descListadoCgg_res_fase),
     items:[grdCgg_res_fase],
     width:600,
     minWidth:600,
     height:400,
     minHeight:400,
     maximizable:true,
     minimizable:true,
     constrain:true,
     layout:'border',
     bbar:[btnAceptarCgg_res_fase_orden,'->',btnSalirCgg_res_fase_orden]
     });
     }
     else
     {*/
    var winFrmCgg_res_fase_orden = new Ext.Window({
        id:'winFrmCgg_res_fase_orden',
        title:tituloListadoCgg_res_fase,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_fase,descListadoCgg_res_fase),
        items:[grdCgg_res_fase],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnAceptarCgg_res_fase_orden,'->',btnSalirCgg_res_fase_orden]
    });
    //  }

    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmCgg_res_fase_orden.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmCgg_res_fase_orden.
     * @returns ventana winFrmCgg_res_fase.
     * @base FrmCgg_res_fase_orden.prototype.show
     */
    this.getWindow = function(){
        return winFrmCgg_res_fase_orden;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmCgg_res_fase_orden.
     * @base FrmCgg_res_fase_orden.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_fase.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_fase;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_fase;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmCgg_res_fase_orden.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmCgg_res_fase_orden.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmCgg_res_fase_orden desde una instancia.
 */
FrmCgg_res_fase_orden.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmCgg_res_fase_orden desde una instancia.
 */
FrmCgg_res_fase_orden.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmCgg_res_fase_orden,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmCgg_res_fase_orden.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmCgg_res_fase_orden desde una instancia.
 */
FrmCgg_res_fase_orden.prototype.loadData = function(){
    this.loadData();
}
