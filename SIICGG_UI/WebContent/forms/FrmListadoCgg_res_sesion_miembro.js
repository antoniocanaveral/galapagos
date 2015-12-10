/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_sesion_miembro.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_sesion_miembro(inDesktop){
    var optMenu = 'Comit\u00e9/Asistencia a sesi\u00f3n de comit\u00e9';
    var urlListadoCgg_res_sesion_miembro=URL_WS+"Cgg_res_sesion_miembro";
    var tituloListadoCgg_res_sesion_miembro='Asistencia a sesi\u00f3n de comit\u00e9';
    var descListadoCgg_res_sesion_miembro='El formulario permite administrar informaci\u00f3n de los asistentes a las sesiones de comites.';
    var tmpCrcom_codigo;

    var pnlComite1 = new Ext.Panel({
        tbar:[{type:'button',text:'Comite',id:'btnComite1',iconCls:'iconBuscar',handler:function(){
            var tmpComite1 = new Cgg_res_comite();
            var objBusqueda = new DlgBusqueda(tmpComite1.getStoreComite(), tmpComite1.getColumnModelComite());
            objBusqueda.closeHandler(function () {
                tmpComite1 = objBusqueda.getSelectedRow();

                if (tmpComite1) {
                    document.getElementById('divInfoComite1').innerHTML =tmpInfoComite1.apply(tmpComite1.json);
                     tmpCrcom_codigo=tmpComite1.get('CRCOM_CODIGO');
                    btnNuevoCgg_res_sesion_miembro.enable();
                    btnEditarCgg_res_sesion_miembro.enable();
                    btnEliminarCgg_res_sesion_miembro.enable();

                }
                gsCgg_res_sesion_miembro.reload({params:{
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
        html:'<div id="divInfoComite1" style="padding:0px 0px 0px 0px;"></div>'
    });
    var tmpInfoComite1 = new Ext.XTemplate(
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
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_sesion_miembro.
     */
    var btnNuevoCgg_res_sesion_miembro = new Ext.Button({
        id:'btnNuevoCgg_res_sesion_miembro',
        text:'Nuevo',
        disabled :true,
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_sesion_miembro = new FrmCgg_res_sesion_miembro("insert");
                objCgg_res_sesion_miembro.setLoadCargarComite(tmpCrcom_codigo);
                objCgg_res_sesion_miembro.closeHandler(function(){
                    gsCgg_res_sesion_miembro.reload();
                });
                objCgg_res_sesion_miembro.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_sesion_miembro.
     */
    var btnEditarCgg_res_sesion_miembro = new Ext.Button({
        id:'btnEditarCgg_res_sesion_miembro',
        text:'Editar',
        disabled :true,
        iconCls:'iconEditar',
        listeners:{
            click:function(){
				var r = grdCgg_res_sesion_miembro.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_sesion_miembro = new FrmCgg_res_sesion_miembro("update",r);
                    objCgg_res_sesion_miembro.setLoadCargarComite(tmpCrcom_codigo);
                    objCgg_res_sesion_miembro.closeHandler(function(){
                        gsCgg_res_sesion_miembro.reload();
                    });
                    objCgg_res_sesion_miembro.loadData();
                    objCgg_res_sesion_miembro.show();
                }else{
                    Ext.MessageBox.alert('Asistencia Comit\u00e9', 'Seleccione un registro para continuar');
                }

            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_sesion_miembro.
     */
    var btnEliminarCgg_res_sesion_miembro = new Ext.Button({
        id:'btnEliminarCgg_res_sesion_miembro',
        text:'Eliminar',
        disabled :true,
        iconCls:'iconEliminar',
        listeners:{
            click:function(){

                Ext.Msg.show({title:'Aviso', msg:'Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_sesion_miembro,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_sesion_miembro(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_sesion_miembro(r){
                            winFrmListadoCgg_res_sesion_miembro.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_sesion_miembro,
                                    msg: 'La informaci\u00f3n de Asistencia Comit\u00e9 ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_sesion_miembro.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_sesion_miembro,
                                    msg: 'La informaci\u00f3n de Asistencia Comit\u00e9 no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_sesion_miembro.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrsmb_codigo',grdCgg_res_sesion_miembro.getSelectionModel().getSelected().get('CRSMB_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_sesion_miembro,"delete",param, true, CallBackCgg_res_sesion_miembro);
                    }catch(inErr){
                        winFrmListadoCgg_res_sesion_miembro.getEl().unmask();
                    }}}

            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_sesion_miembro.
     */
    var btnSalirCgg_res_sesion_miembro = new Ext.Button({
        id:'btnSalirCgg_res_sesion_miembro',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_sesion_miembro.close();
            }}
    });
    /**
     *  Ext.grid.CheckColumn ESTATUS QUE DETERMINA EL GENERO DEL MIEMBRO DEL COMITE
     */
    var chkColPresidente = new Ext.grid.CheckColumn({
        header: 'Presidente',
        dataIndex:'CRSMB_PRESIDENTE',
        width: 80,
        sortable:true
    });
    /**
     *  Ext.grid.CheckColumn ESTATUS QUE DETERMINA EL GENERO DEL MIEMBRO DEL COMITE
     */
    var chkColPresente = new Ext.grid.CheckColumn({
        header: 'Presente',
        dataIndex:'CRSMB_PRESENTE',
        width: 80,
        sortable:true
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_sesion_miembro.
     */
    var cmCgg_res_sesion_miembro = new Ext.grid.ColumnModel([
        {dataIndex:'SESION',header:'Sesi\u00f3n',width:150,sortable:true},
        {dataIndex:'CRSSC_ESTADO_CONVOCATORIA',header:'Estado de la sesi\u00f3n' ,width:150,sortable:true,renderer:function(inCrsscestadoConvocatoria){
            return dsEstadoConvocatoria[inCrsscestadoConvocatoria][1];
        }},
        {dataIndex:'PRINCIPAL',header:'Principal',width:250,sortable:true},
        {dataIndex:'CGG_CRMBC_CODIGO',header:'Crmbc codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'SUPLENTE',header:'Suplente',width:250,sortable:true},
        chkColPresidente,
        chkColPresente
    ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_sesion_miembro por un campo especifico.
     */
    var gsCgg_res_sesion_miembro = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_sesion_miembro",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRSMB_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRSMB_CODIGO'},
            {name:'CRSSC_CODIGO'},
            {name:'SESION'},
            {name:'CRSSC_ESTADO_CONVOCATORIA'},
            {name:'CRMBC_CODIGO'},
            {name:'PRINCIPAL'},
            {name:'CGG_CRMBC_CODIGO'},
            {name:'SUPLENTE'},
            {name:'CRSMB_PRESIDENTE'},
            {name:'CRSMB_PRESENTE'}
        ]),
        sortInfo:{field: 'CRSSC_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON",inCrcom_codigo:''}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_sesion_miembro.
     */
    var pgBarCgg_res_sesion_miembro= new Ext.PagingToolbar({
        store: gsCgg_res_sesion_miembro,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_sesion_miembro en un formato tabular de filas y columnas.
     */
    var grdCgg_res_sesion_miembro = new Ext.grid.GridPanel({
        cm:cmCgg_res_sesion_miembro,
        store:gsCgg_res_sesion_miembro,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_sesion_miembro,
                width:200
            })
        ],
        bbar:pgBarCgg_res_sesion_miembro,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_sesion_miembro.hidden){
                    btnEditarCgg_res_sesion_miembro.fireEvent('click', btnEditarCgg_res_sesion_miembro);
                }
            }}});
    gsCgg_res_sesion_miembro.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_sesion_miembro.
     */
    if(inDesktop){
        var winFrmListadoCgg_res_sesion_miembro = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_sesion_miembro',
            title:tituloListadoCgg_res_sesion_miembro,
            tbar:getPanelTitulo(tituloListadoCgg_res_sesion_miembro,descListadoCgg_res_sesion_miembro),
            items:[pnlComite1,grdCgg_res_sesion_miembro],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_sesion_miembro,btnEditarCgg_res_sesion_miembro,btnEliminarCgg_res_sesion_miembro,'->',btnSalirCgg_res_sesion_miembro]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_res_sesion_miembro.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_sesion_miembro.
     * @returns ventana winFrmCgg_res_sesion_miembro.
     * @base FrmListadoCgg_res_sesion_miembro.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_sesion_miembro;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_sesion_miembro.
     * @base FrmListadoCgg_res_sesion_miembro.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_sesion_miembro.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_sesion_miembro;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_sesion_miembro;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_sesion_miembro.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_sesion_miembro.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_sesion_miembro desde una instancia.
 */
FrmListadoCgg_res_sesion_miembro.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_sesion_miembro desde una instancia.
 */
FrmListadoCgg_res_sesion_miembro.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_sesion_miembro,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_sesion_miembro.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_sesion_miembro desde una instancia.
 */
FrmListadoCgg_res_sesion_miembro.prototype.loadData = function(){
    this.loadData();
}
