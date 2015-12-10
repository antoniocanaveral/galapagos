/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_seguimiento_academico.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_seguimiento_academico(inDesktop){    
	var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Beca/Seguimiento Acad\u00E9mico';
    var urlListadoCgg_dhu_seguimiento_academico=URL_WS+"Cgg_dhu_seguimiento_academico";
    var tituloListadoCgg_dhu_seguimiento_academico='Seguimiento acad\u00E9mico';
    var descListadoCgg_dhu_seguimiento_academico='El formulario permite administrar informaci\u00f3n sobre los diferentes seguimientos acad\u00E9micos';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_seguimiento_academico.
     */
    var btnNuevoCgg_dhu_seguimiento_academico = new Ext.Button({
        id:'btnNuevoCgg_dhu_seguimiento_academico',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_dhu_seguimiento_academico = new FrmCgg_dhu_seguimiento_academico("insert");
                objCgg_dhu_seguimiento_academico.closeHandler(function(){
                    gsCgg_dhu_seguimiento_academico.reload();
                });
                objCgg_dhu_seguimiento_academico.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_seguimiento_academico.
     */
    var btnEditarCgg_dhu_seguimiento_academico = new Ext.Button({
        id:'btnEditarCgg_dhu_seguimiento_academico',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_dhu_seguimiento_academico.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_seguimiento_academico = new FrmCgg_dhu_seguimiento_academico("update",r);
                    objCgg_dhu_seguimiento_academico.closeHandler(function(){
                        gsCgg_dhu_seguimiento_academico.reload();
                    });
                    objCgg_dhu_seguimiento_academico.loadData();
                    objCgg_dhu_seguimiento_academico.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_seguimiento_academico.
     */
    var btnEliminarCgg_dhu_seguimiento_academico = new Ext.Button({
        id:'btnEliminarCgg_dhu_seguimiento_academico',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_seguimiento_academico,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_seguimiento_academico(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_seguimiento_academico(r){
                            winFrmListadoCgg_dhu_seguimiento_academico.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_seguimiento_academico,
                                    msg: 'La informaci\u00f3n del seguimiento acad\u00E9mico ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_seguimiento_academico.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_seguimiento_academico,
                                    msg: 'La informaci\u00f3n de Cgg_dhu_seguimiento_academico no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_seguimiento_academico.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdacd_codigo',grdCgg_dhu_seguimiento_academico.getSelectionModel().getSelected().get('CDACD_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_seguimiento_academico,"delete",param, true, CallBackCgg_dhu_seguimiento_academico);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_seguimiento_academico.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_seguimiento_academico.
     */
    var btnSalirCgg_dhu_seguimiento_academico = new Ext.Button({
        id:'btnSalirCgg_dhu_seguimiento_academico',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_seguimiento_academico.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_seguimiento_academico.
     */
    var cmCgg_dhu_seguimiento_academico = new Ext.grid.ColumnModel([
        {dataIndex:'CDBEC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDACD_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_NOMBRES',header:'Nombre',width:150,sortable:true},
        {dataIndex:'CRPER_APELLIDOS_PERSONA',header:'Apellidos',width:150,sortable:true},
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'No.documento',width:150,sortable:true},
        {dataIndex:'CRPER_NUMERO_RESIDENCIA',header:'No.residencia',width:150,sortable:true},
        {dataIndex:'CDBEC_NUMERO_CONVENIO',header:'No. contrato',width:150,sortable:true},
        {dataIndex:'CDBEC_FUNCIONARIO',header:'Funcionario',width:150,sortable:true},
        {dataIndex:'CGESP_NOMBRE',header:'Especialidad',width:150,sortable:true},
        {dataIndex:'CDBEC_TIPO_CICLO',header:'Total ciclo',width:150,sortable:true,renderer:function(inCdbsegTipoCiclo){
            if(inCdbsegTipoCiclo==TypeCiclo.ANUAL)
            {return('ANUAL');}
             if(inCdbsegTipoCiclo==TypeCiclo.SEMESTRAL)
            {return('SEMESTRAL');}
             if(inCdbsegTipoCiclo==TypeCiclo.QUIMESTRAL)
            {return('QUIMESTRAL');}
             if(inCdbsegTipoCiclo==TypeCiclo.OTROS)
            {return('OTROS');}
        }},
        {dataIndex:'CDACD_NUMERO_CICLO',header:'No.ciclo',width:150,sortable:true},
        {dataIndex:'CDACD_FECHA_INICIO',header:'Fecha inicio',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CDACD_FECHA_FIN',header:'Fecha fin',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CDACD_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true},
        {dataIndex:'CDACD_ESTADO_APROBACION',header:'Estado aprobaci\u00f3n',width:150,sortable:true,renderer:function(inCdbacdAprobacion){
            if(inCdbacdAprobacion==TypeEstadoCicloAcademico.NO_APROBADO)
            {return('NO APROBADO');}
            if(inCdbacdAprobacion==TypeEstadoCicloAcademico.REGISTRADO)
            {return('REGISTRADO');}
             if(inCdbacdAprobacion==TypeEstadoCicloAcademico.POR_APROBAR)
            {return('POR APROBAR');}
             if(inCdbacdAprobacion==TypeEstadoCicloAcademico.APROBADO)
            {return('APROBAR');}
             if(inCdbacdAprobacion==TypeEstadoCicloAcademico.OTROS)
            {return('OTROS');}
        }}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_seguimiento_academico por un campo especifico.
     */
    var gsCgg_dhu_seguimiento_academico = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_seguimiento_academico",
            method:"selectPageBeca",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDACD_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDBEC_CODIGO'},
            {name:'CDACD_CODIGO'},
            {name:'CDTBC_CODIGO'},
            {name:'CDTBC_NOMBRE'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDOS_PERSONA'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_NUMERO_RESIDENCIA'},
            {name:'CDBEC_NUMERO_CONVENIO'},
            {name:'CDBEC_FUNCIONARIO'},
            {name:'CGESP_NOMBRE'},
            {name:'CDBEC_TIPO_CICLO'},
            {name:'CDACD_NUMERO_CICLO'},
            {name:'CDACD_FECHA_INICIO'},
            {name:'CDACD_FECHA_FIN'},
            {name:'CDACD_OBSERVACION'},
            {name:'CDACD_ESTADO_APROBACION'}
        ]),
        sortInfo:{field: 'CDBEC_NUMERO_CONVENIO', direction: 'ASC'},
        groupField:"CDBEC_NUMERO_CONVENIO",
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_seguimiento_academico.
     */
    var pgBarCgg_dhu_seguimiento_academico= new Ext.PagingToolbar({
        store: gsCgg_dhu_seguimiento_academico,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'

    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_seguimiento_academico en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_seguimiento_academico = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_seguimiento_academico,
        store:gsCgg_dhu_seguimiento_academico,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_seguimiento_academico,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_seguimiento_academico,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_seguimiento_academico.hidden){
                    btnEditarCgg_dhu_seguimiento_academico.fireEvent('click', btnEditarCgg_dhu_seguimiento_academico);
                }
            }}});
    gsCgg_dhu_seguimiento_academico.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_seguimiento_academico.
     */
   if(inDesktop){
        var winFrmListadoCgg_dhu_seguimiento_academico = inDesktop.createWindow({
        id:'winFrmListadoCgg_dhu_seguimiento_academico',
        title:tituloListadoCgg_dhu_seguimiento_academico,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_seguimiento_academico,descListadoCgg_dhu_seguimiento_academico),
        items:[grdCgg_dhu_seguimiento_academico],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_dhu_seguimiento_academico,btnEditarCgg_dhu_seguimiento_academico,btnEliminarCgg_dhu_seguimiento_academico,'->',btnSalirCgg_dhu_seguimiento_academico]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_dhu_seguimiento_academico.getBottomToolbar());
}
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_seguimiento_academico.
     * @returns ventana winFrmCgg_dhu_seguimiento_academico.
     * @base FrmListadoCgg_dhu_seguimiento_academico.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_seguimiento_academico;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_seguimiento_academico.
     * @base FrmListadoCgg_dhu_seguimiento_academico.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_seguimiento_academico.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_seguimiento_academico;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_seguimiento_academico;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_seguimiento_academico.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_seguimiento_academico.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_seguimiento_academico desde una instancia.
 */
FrmListadoCgg_dhu_seguimiento_academico.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_seguimiento_academico desde una instancia.
 */
FrmListadoCgg_dhu_seguimiento_academico.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_seguimiento_academico,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_seguimiento_academico.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_seguimiento_academico desde una instancia.
 */
FrmListadoCgg_dhu_seguimiento_academico.prototype.loadData = function(){
    this.loadData();
}
