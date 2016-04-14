/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_observado.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_observado(inDesktop){
    var optMenu = 'Control de Residencia/Observados';
    var urlListadoCgg_res_observado=URL_WS+"Cgg_res_observado";
    var tituloListadoCgg_res_observado='Persona observada';
    var descListadoCgg_res_observado='El formulario permite administrar informaci\u00f3n de persona observada';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_observado.
     */
    var btnNuevoCgg_res_observado = new Ext.Button({
        id:'btnNuevoCgg_res_observado',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_res_observado = new FrmCgg_res_observado("insert");
                objCgg_res_observado.closeHandler(function(){
                    gsCgg_res_observado.reload();
                });
                objCgg_res_observado.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_observado.
     */
    var btnEditarCgg_res_observado = new Ext.Button({
        id:'btnEditarCgg_res_observado',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_res_observado.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_observado = new FrmCgg_res_observado("update",r);
                    objCgg_res_observado.closeHandler(function(){
                        gsCgg_res_observado.reload();
                    });
                    objCgg_res_observado.loadData();
                    objCgg_res_observado.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_observado.
     */
    var btnEliminarCgg_res_observado = new Ext.Button({
        id:'btnEliminarCgg_res_observado',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_observado,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_observado(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_observado(r){
                            winFrmListadoCgg_res_observado.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_observado,
                                    msg: 'La informaci\u00f3n de observaci\u00f3n ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_observado.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_observado,
                                    msg: 'La informaci\u00f3n de observaci\u00f3n no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_observado.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrobs_codigo',grdCgg_res_observado.getSelectionModel().getSelected().get('CROBS_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_observado,"delete",param, true, CallBackCgg_res_observado);
                    }catch(inErr){
                        winFrmListadoCgg_res_observado.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_observado.
     */
    var btnSalirCgg_res_observado = new Ext.Button({
        id:'btnSalirCgg_res_observado',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_res_observado.close();
            }}
    });
    var expanderObservado = new Ext.ux.grid.RowExpander({
        tpl : new Ext.XTemplate(
                '<SPAN style="color:blue"><b>Oficiales:</b><br></SPAN>'+
                    '<table id="box-table-a" cborder="0" align="left">' +
                        '<tbody>' +
                        '<tr>' +
                        '<th style="width: 2%;">No.</th>' +
                        '<th style="width: 15%;">Observacion</th>' +
                        '<th style="width: 10%;">Fecha observacion</th>' +
                        '<th style="width: 5%;">Resuelto</th>' +
                        '<tpl for="OBSERVADO">'+                        
                            '<tr>' +
                            '<td ><b>{#}</td> ' +
                            '<td >{CROBS_DESCRIPCION} </td> ' +
                            '<td >{[this.myDate(values.CROBS_FECHA_OBSERVACION)]} </td> ' +
                            '<td >',
                                '<tpl if="CROBS_RESUELTO == false">',
                                     '<b>NO</b>',
                                '</tpl>',
                                '<tpl if="CROBS_RESUELTO == true">',
                                      '<b>SI</b>',
                                '</tpl>',
                            '</td>' +
                            '</tr>'+
                        '</tpl>',
                        '</tbody>' +
                    '</table>',
        {
            // XTemplate configuration:
            disableFormats: true,
            // member functions:
            myDate: function(CROBS_FECHA_OBSERVACION){
                return truncDate(CROBS_FECHA_OBSERVACION);
            }
        }
      )
    });

    var cmCgg_res_observado = new Ext.grid.ColumnModel([
        expanderObservado,
        {dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'Documento ident.',width:150,sortable:true},
        {dataIndex:'CRPER_NOMBRES',header:'Nombres',width:150,sortable:true},
        {dataIndex:'CRPER_APELLIDO_PATERNO',header:'Apellidos',width:150,sortable:true,renderer:
                            function(value,obj,record)
                            {
                                return value + ' '+ record.get('CRPER_APELLIDO_MATERNO');
                            }
        },

        {dataIndex:'CRPER_NUMERO_RESIDENCIA',header:'No. residencia',width:150,sortable:true},
        {dataIndex:'TIPO_RESIDENCIA',header:'Tipo residencia',width:150,sortable:true}]);
    //chkCrobs_resuelto,
    //{dataIndex:'CROBS_FECHA_RESUELTO',header:'Fecha resuelto',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_observado por un campo especifico.
     */
    var gsCgg_res_observado = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_persona",
            method:"selectPageObservado",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPER_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRPER_CODIGO'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_APELLIDO_MATERNO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_FECHA_NACIMIENTO'},
            {name:'CRPER_LUGAR_NACIMIENTO'},
            {name:'CRDID_DESCRIPCION'},
            {name:'CRPER_GENERO'},
            {name:'CRPER_OBSERVACIONES'},
            {name:'CRPER_NUMERO_RESIDENCIA'},
            {name:'CRPER_AUTORIZADO'},
            {name:'CRPER_FECHA_ARCHIVO'},
            {name:'CRTSR_CODIGO'},
            {name:'CRRSD_MODALIDAD'},
            {name:'TIPO_RESIDENCIA'},
            {name:'OBSERVADO'}
        ]),
        sortInfo:{field: 'CRPER_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /*
     * CRPER.CRPER_CODIGO,
     CRPER.CRPER_NOMBRES,
     CRPER.CRPER_APELLIDO_PATERNO,
     CRPER.CRPER_APELLIDO_MATERNO,
     CRPER.CRPER_NUM_DOC_IDENTIFIC,
     CRPER.CRPER_FECHA_NACIMIENTO,
     CRPER.CRPER_LUGAR_NACIMIENTO,
     CRDID.CRDID_DESCRIPCION,
     CRPER.CRPER_GENERO,
     CRPER.CRPER_OBSERVACIONES,
     CRPER.CRPER_NUMERO_RESIDENCIA,
     CRPER.CRPER_AUTORIZADO,
     CRPER.CRPER_NUMERO_EXPEDIENTE,
     CRPER.CRPER_FECHA_ARCHIVO ,
     CRRSD.CRTSR_CODIGO,
     CRRSD.CRRSD_MODALIDAD,
     CRTST.CRTST_DESCRIPCION
     *
     *
     * */
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_observado.
     */
    var pgBarCgg_res_observado= new Ext.PagingToolbar({
        store: gsCgg_res_observado,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_observado en un formato tabular de filas y columnas.
     */
    var grdCgg_res_observado = new Ext.grid.GridPanel({
        cm:cmCgg_res_observado,
        store:gsCgg_res_observado,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        viewConfig:{forceFit:true},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_observado,
                width:200
            })
        ],
        bbar:pgBarCgg_res_observado,
        plugins:[expanderObservado],
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_observado.hidden){
                    btnEditarCgg_res_observado.fireEvent('click', btnEditarCgg_res_observado);
                }
            }}});
    gsCgg_res_observado.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_observado.
     */
    var winFrmListadoCgg_res_observado = null;
    if(inDesktop!==null && inDesktop!==undefined){
        winFrmListadoCgg_res_observado = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_observado',
            title:tituloListadoCgg_res_observado,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_observado,descListadoCgg_res_observado),
            items:[grdCgg_res_observado],
            bbar:[btnNuevoCgg_res_observado,btnEditarCgg_res_observado,btnEliminarCgg_res_observado,'->',btnSalirCgg_res_observado]
        });
    }
    else
    {
        winFrmListadoCgg_res_observado = new Ext.Window({
            id:'winFrmListadoCgg_res_observado',
            title:tituloListadoCgg_res_observado,
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_observado,descListadoCgg_res_observado),
            items:[grdCgg_res_observado],
            bbar:[btnNuevoCgg_res_observado,btnEditarCgg_res_observado,btnEliminarCgg_res_observado,'->',btnSalirCgg_res_observado]
        });
    }
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_observado.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_observado.
     * @returns ventana winFrmCgg_res_observado.
     * @base FrmListadoCgg_res_observado.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_observado;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_observado.
     * @base FrmListadoCgg_res_observado.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_observado.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_observado;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_observado;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_observado.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_observado.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_observado desde una instancia.
 */
FrmListadoCgg_res_observado.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_observado desde una instancia.
 */
FrmListadoCgg_res_observado.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_observado,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_observado.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_observado desde una instancia.
 */
FrmListadoCgg_res_observado.prototype.loadData = function(){
    this.loadData();
}
