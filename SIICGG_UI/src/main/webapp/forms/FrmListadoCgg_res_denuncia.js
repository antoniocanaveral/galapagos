/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_denuncia.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_denuncia(inDesktop){
    var optMenu = 'Control de Residencia/Denuncias';
    var urlListadoCgg_res_denuncia=URL_WS+"Cgg_res_denuncia";
    var tituloListadoCgg_res_denuncia='Listado denuncia';	
    var descListadoCgg_res_denuncia='El formulario permite administrar informaci\u00f3n sobre las direfentes denuncias';
	var inCrdenTipo =0;
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_denuncia.
     */
    var btnNuevoCgg_res_denuncia = new Ext.Button({
        id:'btnNuevoCgg_res_denuncia',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_denuncia = new FrmCgg_res_denuncia("insert",null,inCrdenTipo);
                objCgg_res_denuncia.closeHandler(function(){
                    gsCgg_res_denuncia.reload();
                });
                objCgg_res_denuncia.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_denuncia.
     */
    var btnEditarCgg_res_denuncia = new Ext.Button({
        id:'btnEditarCgg_res_denuncia',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_denuncia.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_denuncia = new FrmCgg_res_denuncia("update",r,inCrdenTipo);
                    objCgg_res_denuncia.closeHandler(function(){
                        gsCgg_res_denuncia.reload();
                    });
                    objCgg_res_denuncia.loadData();
                    objCgg_res_denuncia.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_denuncia.
     */
    var btnEliminarCgg_res_denuncia = new Ext.Button({
        id:'btnEliminarCgg_res_denuncia',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_denuncia,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_denuncia(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_denuncia(r){
                            winFrmListadoCgg_res_denuncia.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_denuncia,
                                    msg: 'La informaci\u00f3n de la denuncia ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_denuncia.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_denuncia,
                                    msg: 'La informaci\u00f3n de la denuncia no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_denuncia.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrden_codigo',grdCgg_res_denuncia.getSelectionModel().getSelected().get('CRDEN_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_denuncia,"delete",param, true, CallBackCgg_res_denuncia);
                    }catch(inErr){
                        winFrmListadoCgg_res_denuncia.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_denuncia.
     */
    var btnAnularCgg_res_denuncia = new Ext.Button({
        id:'btnAnularCgg_res_denuncia',
        text:'Anular',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Desea anular el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_denuncia,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_denuncia(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_denuncia(r){
                            winFrmListadoCgg_res_denuncia.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_denuncia,
                                    msg: 'El registro anulado.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_denuncia.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_denuncia,
                                    msg: 'El registro no se pudo anular',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_denuncia.getEl().mask('Anulando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrden_codigo',grdCgg_res_denuncia.getSelectionModel().getSelected().get('CRDEN_CODIGO'));
                        param.add('inCrden_estado_denuncia',2);
                        SOAPClient.invoke(urlListadoCgg_res_denuncia,"updateDenunciaEstado",param, true, CallBackCgg_res_denuncia);
                    }catch(inErr){
                        winFrmListadoCgg_res_denuncia.getEl().unmask();
                    }}}
            }}
    });
     /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_denuncia.
     */

    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_denuncia.
     */
    var btnSalirCgg_res_denuncia = new Ext.Button({
        id:'btnSalirCgg_res_denuncia',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_denuncia.close();
            }}
    });
   
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_denuncia.
     */
    var cmCgg_res_denuncia = new Ext.grid.ColumnModel([
        {dataIndex:'CRDEN_CODIGO',hidden:true,header:'Codigo',width:150,sortable:true},
        {dataIndex:'CUSU_CODIGO',hidden:true,header:'Codigo',width:150,sortable:true},
        {dataIndex:'CRDEN_ANIO',hidden:true,header:'Anio',width:80,sortable:true},
        {dataIndex:'CRDEN_NUMERO',header:'Numero',width:90,sortable:true},
		{dataIndex:'CRDEN_ESTADO_DENUNCIA',header:'Estado',width:80,sortable:true,renderer:function(inCrresestadoDenuncia){
            if (inCrresestadoDenuncia=='0'){
                return('REGISTRADA')
            }else if(inCrresestadoDenuncia=='1'){
                return('REVISADA')
            }else if(inCrresestadoDenuncia=='2'){
                return('ANULADA')
            }}
		},
        {dataIndex:'CRDEN_NOMBRES',header:'Nombres',width:120,sortable:true},
        {dataIndex:'CRDEN_APELLIDOS',header:'Apellidos',width:120,sortable:true},
        {dataIndex:'CRDEN_NUMERO_DOC_IDENT',header:'Numero doc ident',width:80,sortable:true},
        {dataIndex:'CRDEN_FECHA_RECEPCION',header:'Fecha recepcion',width:80,sortable:true,renderer:truncDate},
        {dataIndex:'CRDEN_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
        {dataIndex:'CRDEN_CONTACTO',header:'Contacto',width:150,sortable:true},
        {dataIndex:'CRDEN_DENUNCIA',hidden:true,header:'Denuncia',width:80,sortable:true,renderer:function(v){return (v==true) ? "Telef&oacute;nica":"Presencial";}},
        {dataIndex:'CRDEN_SEGUIMIENTO',header:'Seguimiento',width:150,sortable:true}        
		]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_denuncia por un campo especifico.
     */
    var gsCgg_res_denuncia = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_denuncia",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRDEN_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRDEN_CODIGO'},
            {name:'CUSU_CODIGO'},
            {name:'CRDEN_ANIO'},
            {name:'CRDEN_NUMERO'},
            {name:'CRDEN_FECHA_RECEPCION'},
            {name:'CRDEN_NUMERO_DOC_IDENT'},
            {name:'CRDEN_NOMBRES'},
            {name:'CRDEN_APELLIDOS'},
            {name:'CRDEN_DESCRIPCION'},
            {name:'CRDEN_CONTACTO'},
            {name:'CRDEN_TIPO'},
            {name:'CRDEN_DENUNCIA'},
            {name:'CRDEN_SEGUIMIENTO'},
            {name:'CRDEN_ESTADO_DENUNCIA'}
        ]),
        sortInfo:{field: 'CRDEN_FECHA_RECEPCION', direction: 'ASC'},
		groupField:"CRDEN_FECHA_RECEPCION",
        baseParams:{keyword:"",format:"JSON",inTipo:inCrdenTipo}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_denuncia.
     */
    var pgBarCgg_res_denuncia= new Ext.PagingToolbar({
        store: gsCgg_res_denuncia,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_denuncia en un formato tabular de filas y columnas.
     */
    var grdCgg_res_denuncia = new Ext.grid.GridPanel({
        cm:cmCgg_res_denuncia,
        store:gsCgg_res_denuncia,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
		view: new Ext.grid.GroupingView({
            //forceFit:true,
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_denuncia,
                width:200
            })
        ],
        bbar:pgBarCgg_res_denuncia,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_denuncia.hidden){
                    btnEditarCgg_res_denuncia.fireEvent('click', btnEditarCgg_res_denuncia);



                }
            }}});
    gsCgg_res_denuncia.reload({params:{
        start:0,
        limit:RECORD_PAGE
    }
    });
	if(inDesktop){
		/**
		 * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_denuncia.
		 */
		var winFrmListadoCgg_res_denuncia = inDesktop.createWindow({
			id:'winFrmListadoCgg_res_denuncia',
			title:tituloListadoCgg_res_denuncia,
			tbar:getPanelTitulo(' '+tituloListadoCgg_res_denuncia,descListadoCgg_res_denuncia),
			items:[grdCgg_res_denuncia],
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			layout:'border',
			bbar:[btnNuevoCgg_res_denuncia,btnEditarCgg_res_denuncia,btnEliminarCgg_res_denuncia,btnAnularCgg_res_denuncia,'->',btnSalirCgg_res_denuncia]
		});
		/**
		 * Funcion que aplica los privilegios del usuario.
		 */
		applyGrants(winFrmListadoCgg_res_denuncia.getBottomToolbar());
	}
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_denuncia.
     * @returns ventana winFrmCgg_res_denuncia.
     * @base FrmListadoCgg_res_denuncia.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_denuncia;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_denuncia.
     * @base FrmListadoCgg_res_denuncia.prototype.loadData
     */
    this.loadData = function(){
		gsCgg_res_denuncia.baseParams.inTipo=inCrdenTipo;
        gsCgg_res_denuncia.reload();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_denuncia;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_denuncia;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_denuncia.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_denuncia.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_denuncia desde una instancia.
 */
FrmListadoCgg_res_denuncia.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_denuncia desde una instancia.
 */
FrmListadoCgg_res_denuncia.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_denuncia,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_denuncia.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_denuncia desde una instancia.
 */
FrmListadoCgg_res_denuncia.prototype.loadData = function(){
    this.loadData();
}
