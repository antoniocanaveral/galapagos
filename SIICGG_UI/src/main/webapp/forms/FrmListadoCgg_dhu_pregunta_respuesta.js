/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_pregunta_respuesta.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_pregunta_respuesta(inDesktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Curso/Encuestas/Pregunta-Respuesta';
    var urlListadoCgg_dhu_pregunta_respuesta=URL_WS+"Cgg_dhu_pregunta_respuesta";
    var tituloListadoCgg_dhu_pregunta_respuesta='Asignaci\u00f3n de opciones de respuesta a las categor\u00edas';
    var descListadoCgg_dhu_pregunta_respuesta='El formulario permite administrar informaci\u00f3n sobre las opciones que se le pueden asignar a las categor\u00edas';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_pregunta_respuesta.
     */
    var btnNuevoCgg_dhu_pregunta_respuesta = new Ext.Button({
        id:'btnNuevoCgg_dhu_pregunta_respuesta',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_dhu_pregunta_respuesta = new FrmCgg_dhu_pregunta_respuesta("insert");
                objCgg_dhu_pregunta_respuesta.closeHandler(function(){
                    gsCgg_dhu_pregunta_respuesta.reload();
                });
                objCgg_dhu_pregunta_respuesta.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_pregunta_respuesta.
     */
    var btnEditarCgg_dhu_pregunta_respuesta = new Ext.Button({
        id:'btnEditarCgg_dhu_pregunta_respuesta',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_dhu_pregunta_respuesta.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_pregunta_respuesta = new FrmCgg_dhu_pregunta_respuesta("update",r);
                    objCgg_dhu_pregunta_respuesta.closeHandler(function(){
                        gsCgg_dhu_pregunta_respuesta.reload();
                    });
                    objCgg_dhu_pregunta_respuesta.loadData();
                    objCgg_dhu_pregunta_respuesta.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_pregunta_respuesta.
     */
    var btnEliminarCgg_dhu_pregunta_respuesta = new Ext.Button({
        id:'btnEliminarCgg_dhu_pregunta_respuesta',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_pregunta_respuesta,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_pregunta_respuesta(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_pregunta_respuesta(r){
                            winFrmListadoCgg_dhu_pregunta_respuesta.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_pregunta_respuesta,
                                    msg: 'La informaci\u00f3n de Pregunta - Respuesta ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_pregunta_respuesta.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_pregunta_respuesta,
                                    msg: 'La informaci\u00f3n de Pregunta - Respuesta no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
						//alert(grdCgg_dhu_pregunta_respuesta.getSelectionModel().getSelected().get('CDCAT_CODIGO'));
						//return;
                        winFrmListadoCgg_dhu_pregunta_respuesta.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdcate_codigo',grdCgg_dhu_pregunta_respuesta.getSelectionModel().getSelected().get('CDCAT_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_pregunta_respuesta,"deleteAllByCategoria",param, true, CallBackCgg_dhu_pregunta_respuesta);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_pregunta_respuesta.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_pregunta_respuesta.
     */
    var btnSalirCgg_dhu_pregunta_respuesta = new Ext.Button({
        id:'btnSalirCgg_dhu_pregunta_respuesta',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_pregunta_respuesta.close();
            }}
    });
    
	
	var rowExpander1 = new Ext.ux.grid.RowExpander({
        tpl : new Ext.Template(            
            '<b>Descripci\u00f3n del administrador:</b> {JSON_INFO}<br>'
        )
    });
	
	var rowExpander = new Ext.ux.grid.RowExpander({
        tpl : new Ext.XTemplate(
               '<SPAN style="color:blue"><b>Opciones de Respuestas:</b><br></SPAN>'+
                    '<table id="box-table-a" cborder="0" align="left">' +
                        '<tbody>' +
                        '<tr>' +
                        '<th style="width: 2%;">Opcion</th>' +
                        '<th style="width: 10%;">Valoracion</th>' +
                        
                        '</tr>'+
						'{JSON_INFO}'+
                        
                        '</tbody>' +
                    '</table>'
                 )
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_pregunta_respuesta.
     */
    var cmCgg_dhu_pregunta_respuesta = new Ext.grid.ColumnModel([
		//rowExpander,
        /*{dataIndex:'CDPRS_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true, hideable:false},
        {dataIndex:'CDPRG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true, hideable:false},*/
        {dataIndex:'CDCAT_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true, hideable:false},
        {dataIndex:'CDCAT_NOMBRE',header:'Categor\u00eda',width:150,sortable:true}
       /* {dataIndex:'CDPRG_DESCRIPCION',header:'Pregunta',width:150,sortable:true},
        {dataIndex:'CDRES_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true, hideable:false},
        {dataIndex:'CDRES_DESCRIPCION',header:'Respuesta',width:150,sortable:true},
        {dataIndex:'CDPRS_VALORACION',header:'Valoracion',width:150,sortable:true}*/
	]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_pregunta_respuesta por un campo especifico.
     */
    var gsCgg_dhu_pregunta_respuesta = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_pregunta_respuesta",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDPRS_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDPRS_CODIGO'},
            {name:'CDPRG_CODIGO'},
            {name:'CDCAT_CODIGO'},
            {name:'CDCAT_NOMBRE'},
            {name:'CDPRG_DESCRIPCION'},
            {name:'CDRES_CODIGO'},
            {name:'CDRES_DESCRIPCION'},
            {name:'CDPRS_VALORACION'},
			{name:'JSON_INFO'}
        ]),
        //groupField:'CDCAT_NOMBRE',
        sortInfo: {
            field: 'CDCAT_NOMBRE',
            direction: 'ASC'
        },
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_pregunta_respuesta.
     */
    var pgBarCgg_dhu_pregunta_respuesta= new Ext.PagingToolbar({
        store: gsCgg_dhu_pregunta_respuesta,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_pregunta_respuesta en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_pregunta_respuesta = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_pregunta_respuesta,
        store:gsCgg_dhu_pregunta_respuesta,
        region:'center',
       /* view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})',forceFit:true
        }),*/
		//plugins: rowExpander, 
		viewConfig:{forceFit:true},
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_pregunta_respuesta,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_pregunta_respuesta,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_pregunta_respuesta.hidden){
                    btnEditarCgg_dhu_pregunta_respuesta.fireEvent('click', btnEditarCgg_dhu_pregunta_respuesta);
                }
            }}});
    gsCgg_dhu_pregunta_respuesta.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_pregunta_respuesta.
     */
    if(inDesktop){
        var winFrmListadoCgg_dhu_pregunta_respuesta = inDesktop.createWindow({
            id:'winFrmListadoCgg_dhu_pregunta_respuesta',
            title:tituloListadoCgg_dhu_pregunta_respuesta,
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_pregunta_respuesta,descListadoCgg_dhu_pregunta_respuesta),
            items:[grdCgg_dhu_pregunta_respuesta],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_dhu_pregunta_respuesta,btnEditarCgg_dhu_pregunta_respuesta,btnEliminarCgg_dhu_pregunta_respuesta,'->',btnSalirCgg_dhu_pregunta_respuesta]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_dhu_pregunta_respuesta.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_pregunta_respuesta.
     * @returns ventana winFrmCgg_dhu_pregunta_respuesta.
     * @base FrmListadoCgg_dhu_pregunta_respuesta.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_pregunta_respuesta;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_pregunta_respuesta.
     * @base FrmListadoCgg_dhu_pregunta_respuesta.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_pregunta_respuesta.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_pregunta_respuesta;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_pregunta_respuesta;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_pregunta_respuesta.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_pregunta_respuesta.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_pregunta_respuesta desde una instancia.
 */
FrmListadoCgg_dhu_pregunta_respuesta.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_pregunta_respuesta desde una instancia.
 */
FrmListadoCgg_dhu_pregunta_respuesta.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_pregunta_respuesta,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_pregunta_respuesta.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_pregunta_respuesta desde una instancia.
 */
FrmListadoCgg_dhu_pregunta_respuesta.prototype.loadData = function(){
    this.loadData();
}
