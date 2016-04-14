/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_miembro_comite.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_miembro_comite(inDesktop){
    var optMenu = 'Comit\u00e9/Miembros de comit\u00e9';
    var urlListadoCgg_res_miembro_comite=URL_WS+"Cgg_res_miembro_comite";
    var tituloListadoCgg_res_miembro_comite='Miembros de comit\u00e9';
    var descListadoCgg_res_miembro_comite='El formulario permite administrar informaci\u00f3n de los miembros que pertenecen a un comit\u00e9.';
    var tmpCrcom_codigo;

    var pnlComite = new Ext.Panel({
	    tbar:[{type:'button',id:'btnSesion',text:'Comite',iconCls:'iconBuscar',handler:function(){
            var tmpComite = new Cgg_res_comite();
            var objBusqueda = new DlgBusqueda(tmpComite.getStoreComite(), tmpComite.getColumnModelComite());
            objBusqueda.closeHandler(function () {
                tmpComite = objBusqueda.getSelectedRow();
                if (tmpComite) {
                    document.getElementById('divInfoComite').innerHTML =tmpInfoComite.apply(tmpComite.json);
                    tmpCrcom_codigo=tmpComite.get('CRCOM_CODIGO');
                    btnNuevoCgg_res_miembro_comite.enable();
                    btnEditarCgg_res_miembro_comite.enable();
                    btnEliminarCgg_res_miembro_comite.enable();

                }
                gsCgg_res_miembro_comite.reload({params:{
                    start:0,
                    limit:RECORD_PAGE,
                    inCrcom_codigo:tmpCrcom_codigo
                }});
            });
            objBusqueda.show();
        }}],
        //bodyStyle:'padding:0px 0px 0px 0px;',
        frame:true,
        height:65,
        region:'north',
        html:'<div id="divInfoComite" style="padding:0px 0px 0px 0px;"></div>'
    });
    var tmpInfoComite = new Ext.XTemplate(
            '<table width="100%" height="100%" cellpadding="0">' +
                    '<tr rowspan="0"><td>' +
                    '<div class="tituloTemplate">Comite</div></td>' +
                    '<td><div class="itemTemplate">{CRCOM_NOMBRE}</div>' +
                    '</td></tr></table>',
    {
        // XTemplate configuration:
        disableFormats: true
        // member functions:

    }
            );
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_miembro_comite.
     */
    var btnNuevoCgg_res_miembro_comite = new Ext.Button({
        id:'btnNuevoCgg_res_miembro_comite',
        text:'Nuevo',
        iconCls:'iconNuevo',
        disabled :true,
        listeners:{
            click:function(){
                var objCgg_res_miembro_comite = new FrmCgg_res_miembro_comite("insert");
                objCgg_res_miembro_comite.setLoadCarComite(tmpCrcom_codigo);
                objCgg_res_miembro_comite.closeHandler(function(){
                    gsCgg_res_miembro_comite.reload();
                });
                objCgg_res_miembro_comite.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_miembro_comite.
     */
    var btnEditarCgg_res_miembro_comite = new Ext.Button({
        id:'btnEditarCgg_res_miembro_comite',
        text:'Editar',
        disabled :true,
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_res_miembro_comite.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_miembro_comite = new FrmCgg_res_miembro_comite("update",r);
                    objCgg_res_miembro_comite.setLoadCarComite(tmpCrcom_codigo);
                    objCgg_res_miembro_comite.closeHandler(function(){
                        gsCgg_res_miembro_comite.reload();
                    });
                    objCgg_res_miembro_comite.show();
                    objCgg_res_miembro_comite.loadData(grdCgg_res_miembro_comite.getSelectionModel().getSelected() );
                }else{
                    Ext.MessageBox.alert('Miembro Comit\u00e9', 'Seleccione un registro para continuar');
                }

            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_miembro_comite.
     */
    var btnEliminarCgg_res_miembro_comite = new Ext.Button({
        id:'btnEliminarCgg_res_miembro_comite',
        text:'Eliminar',
        disabled :true,
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_miembro_comite,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_miembro_comite(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_miembro_comite(r){
                            winFrmListadoCgg_res_miembro_comite.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_miembro_comite,
                                    msg: 'La informaci\u00f3n del Miembro Comit\u00e9 ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_miembro_comite.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_miembro_comite,
                                    msg: 'La informaci\u00f3n del Miembro Comit\u00e9 comite no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_miembro_comite.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrmbc_codigo',grdCgg_res_miembro_comite.getSelectionModel().getSelected().get('CRMBC_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_miembro_comite,"delete",param, true, CallBackCgg_res_miembro_comite);
                    }catch(inErr){
                        winFrmListadoCgg_res_miembro_comite.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_miembro_comite.
     */
    var btnSalirCgg_res_miembro_comite = new Ext.Button({
        id:'btnSalirCgg_res_miembro_comite',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_miembro_comite.close();
            }}
    });
    /**
     *  Ext.grid.CheckColumn ESTATUS QUE DETERMINA EL TITULAR DEL MIEMBRO DEL COMITE
     */
    var chkColTitular = new Ext.grid.CheckColumn({
        header: 'Titular',
        dataIndex:'CRMBC_TITULAR',
        width: 80,
        sortable:true
    });
    /**
     *  Ext.grid.CheckColumn ESTATUS QUE DETERMINA EL GENERO DEL MIEMBRO DEL COMITE
     */
    var chkColAutorizado = new Ext.grid.CheckColumn({
        header: 'Autorizado',
        dataIndex:'CRMBC_AUTORIZADO',
        width: 80,
        sortable:true
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_miembro_comite.
     */
    var cmCgg_res_miembro_comite = new Ext.grid.ColumnModel([
        {dataIndex:'CARGO',header:'Cargo',width:150,sortable:true},
        {dataIndex:'DOCUMENTO',header:'Tipo Documento',width:150,sortable:true},
        {dataIndex:'CRPER_NOMBRES',header:'Nombres',width:150,sortable:true},
        {dataIndex:'APELLIDO',header:'Apellidos',width:150,sortable:true},
		{dataIndex:'CUSU_NOMBRE_USUARIO',header:'Usuario',width:80,sortable:true},
        {dataIndex:'CRMBC_NUM_DOC_IDENTIFIC',header:'Numero Identificativo',width:150,sortable:true},
        {dataIndex:'CRPER_GENERO',header:'Genero',width:150,sortable:true , renderer:function(inCrmbc_Genero){
			if(inCrmbc_Genero)
            return dsGeneroPersona[inCrmbc_Genero][1];
        }},
        {dataIndex:'CRMBC_FECHA_INICIO_FUNCIONES',header:'Fecha inicio funciones',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CRMBC_FECHA_FIN_FUNCIONES',header:'Fecha fin funciones',width:150,sortable:true,renderer:truncDate},
		{dataIndex:'CANTON',header:'Canton',width:150,sortable:true},
		{dataIndex:'PARROQUIA',header:'Parroquia',width:150,sortable:true},
        chkColTitular,
        chkColAutorizado
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_miembro_comite por un campo especifico.
     */
    var gsCgg_res_miembro_comite = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_miembro_comite",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRMBC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRMBC_CODIGO'},
            {name:'CRCRG_CODIGO'},
            {name:'CARGO'},
            {name:'CUSU_CODIGO'},
            {name:'CRPER_CODIGO'},
            {name:'CRDID_CODIGO'},
            {name:'DOCUMENTO'},
            {name:'CPRR_CODIGO'},
            {name:'PARROQUIA'},
            {name:'CCTN_CODIGO'},
            {name:'CANTON'},
            {name:'CRPER_NOMBRES'},
            {name:'APELLIDO'},
            {name:'CRMBC_NUM_DOC_IDENTIFIC'},
            {name:'CRMBC_FECHA_NACIMIENTO'},
            {name:'CRPER_GENERO'},
            {name:'CRMBC_FECHA_INICIO_FUNCIONES'},
            {name:'CRMBC_FECHA_FIN_FUNCIONES'},
            {name:'CRMBC_TITULAR'},
            {name:'CRMBC_AUTORIZADO'},
			{name:'CUSU_NOMBRE_USUARIO'}
        ]),
        sortInfo:{field: 'CRMBC_CODIGO', direction: 'ASC'},
        baseParams:{
			keyword:"",
			format:'JSON', 
			inCrcom_codigo:'',
			inShowAll:true
		}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_miembro_comite.
     */
    var pgBarCgg_res_miembro_comite= new Ext.PagingToolbar({
        store: gsCgg_res_miembro_comite,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_miembro_comite en un formato tabular de filas y columnas.
     */
    var grdCgg_res_miembro_comite = new Ext.grid.GridPanel({
        cm:cmCgg_res_miembro_comite,
        store:gsCgg_res_miembro_comite,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_miembro_comite,
                width:200
            })
        ],
        bbar:pgBarCgg_res_miembro_comite,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_miembro_comite.hidden){
                    btnEditarCgg_res_miembro_comite.fireEvent('click', btnEditarCgg_res_miembro_comite);
                }
            }}});

    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_miembro_comite.
     */
    if(inDesktop){
        var winFrmListadoCgg_res_miembro_comite =  inDesktop.createWindow({
            id:'winFrmListadoCgg_res_miembro_comite',
            title:tituloListadoCgg_res_miembro_comite,
            tbar:getPanelTitulo(tituloListadoCgg_res_miembro_comite,descListadoCgg_res_miembro_comite),
            items:[pnlComite,grdCgg_res_miembro_comite],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_miembro_comite,btnEditarCgg_res_miembro_comite,btnEliminarCgg_res_miembro_comite,'->',btnSalirCgg_res_miembro_comite]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_res_miembro_comite.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_miembro_comite.
     * @returns ventana winFrmCgg_res_miembro_comite.
     * @base FrmListadoCgg_res_miembro_comite.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_miembro_comite;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_miembro_comite.
     * @base FrmListadoCgg_res_miembro_comite.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_miembro_comite.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_miembro_comite;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_miembro_comite;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_miembro_comite.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_miembro_comite.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_miembro_comite desde una instancia.
 */
FrmListadoCgg_res_miembro_comite.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_miembro_comite desde una instancia.
 */
FrmListadoCgg_res_miembro_comite.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_miembro_comite,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_miembro_comite.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_miembro_comite desde una instancia.
 */
FrmListadoCgg_res_miembro_comite.prototype.loadData = function(){
    this.loadData();
}
