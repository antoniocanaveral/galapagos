/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_jur_anticipo.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_jur_anticipo(inDesktop){
    var optMenu = 'Jur\u00eddico/Anticipo';
    var urlListadoCgg_jur_anticipo=URL_WS+"Cgg_jur_anticipo";
    var tituloListadoCgg_jur_anticipo='Anticipo del Acuerdo';
    var descListadoCgg_jur_anticipo='El formulario permite administrar informaci\u00f3n del Anticipo del Acuerdo ';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_jur_anticipo.
     */
    var btnNuevoCgg_jur_anticipo = new Ext.Button({
        id:'btnNuevoCgg_jur_anticipo',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_jur_anticipo = new FrmCgg_jur_anticipo("insert");
                objCgg_jur_anticipo.closeHandler(function(){
                    gsCgg_jur_anticipo.reload();
                });
                objCgg_jur_anticipo.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_jur_anticipo.
     */
    var btnEditarCgg_jur_anticipo = new Ext.Button({
        id:'btnEditarCgg_jur_anticipo',
        text:'Editar',
        iconCls:'iconEditar',
        listeners:{
            click:function(){
                var r=grdCgg_jur_anticipo.getSelectionModel().getSelected();
                if(r){
                    var objCgg_jur_anticipo = new FrmCgg_jur_anticipo("update",r);
                    objCgg_jur_anticipo.closeHandler(function(){
                        gsCgg_jur_anticipo.reload();
                    });
                    objCgg_jur_anticipo.show();
                    objCgg_jur_anticipo.loadData(r);
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_jur_anticipo.
     */
    var btnEliminarCgg_jur_anticipo = new Ext.Button({
        id:'btnEliminarCgg_jur_anticipo',
        text:'Eliminar',
        iconCls:'iconEliminar',
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_jur_anticipo,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_jur_anticipo(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_jur_anticipo(r){
                            winFrmListadoCgg_jur_anticipo.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_jur_anticipo,
                                    msg: 'La informaci\u00f3n de Anticipo ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_jur_anticipo.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_jur_anticipo,
                                    msg: 'La informaci\u00f3n de Anticipo no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_jur_anticipo.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCjaac_codigo',grdCgg_jur_anticipo.getSelectionModel().getSelected().get('CJAAC_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_jur_anticipo,"delete",param, true, CallBackCgg_jur_anticipo);
                    }catch(inErr){
                        winFrmListadoCgg_jur_anticipo.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_jur_anticipo.
     */
    var btnSalirCgg_jur_anticipo = new Ext.Button({
        id:'btnSalirCgg_jur_anticipo',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_jur_anticipo.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_jur_anticipo.
     */
    var cmCgg_jur_anticipo = new Ext.grid.ColumnModel([
        {dataIndex:'CJAAC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CJACU_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true,hideable:false},
        {dataIndex:'CRPJR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CJACU_NUMERO',header:'N\u00famero',width:150,sortable:true},
        {dataIndex:'RAZON_SOCIAL',header:'Raz\u00f3n Social',width:200,sortable:true,renderer:
                function(value,metadata,record)
                {
                    if (value.length >0)
                    {
                        return value;
                    }
                    else
                    {
                        return record.get('PERSONA');
                    }

                }
        },
        {dataIndex:'PERSONA',header:'Tipo',width:50,sortable:true,renderer:function(value,metaData,record)
        {
            if (record.data.PERSONA) {
                metaData.css = 'iconPersonaNatural';

            }
            else
            {

                metaData.css = 'iconPersonaJuridica';

            }
            return '';
        }},
        {dataIndex:'CJACU_FECHA_SUSCRIPCION',header:'Fecha suscripci\u00f3n',width:150,sortable:true,renderer:truncDate},
        //{dataIndex:'RAZON_SOCIAL',header:'Razon Social',width:150,sortable:true},
        {dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        //  {dataIndex:'PERSONA',header:'Persona',width:150,sortable:true},
        {dataIndex:'CJTPR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'NOMBRE_PROCESO',header:'Nombre Proceso',width:150,sortable:true},
        {dataIndex:'CJACU_ANIO',header:'A\u00f1o',width:150,sortable:true},
        {dataIndex:'CJACU_OBJETO',header:'Objeto',width:150,sortable:true},
        {dataIndex:'CJACU_FECHA_INICIO',header:'Fecha inicio',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CJACU_RESPONSABLE',header:'Responsable',width:150,sortable:true},
        {dataIndex:'CJACU_ESTADO_EJECUCION',header:'Estado ejecuci\u00f3n',width:150,sortable:true,renderer:function(inCjacu_estado_ejecucion) {
            return dsEstadoEjecucion[inCjacu_estado_ejecucion][1];

        }
        },
        {dataIndex:'CJACU_TIPO',header:'Tipo',width:150,sortable:true,renderer:function(inCjacu_tipo) {
            return dsTipoAcuerdo[inCjacu_tipo][1];

        } },
        {dataIndex:'CJACU_TIPO_PERSONA',header:'Tipo persona',width:150,sortable:true,renderer:function(inCjacu_tipo_adversario) {
            var result = "";
            switch (inCjacu_tipo_adversario) {
                case 0:
                    result = 'PERSONA NATURAL';
                    break;
                case 1:
                    result = 'PERSONA JURIDICA';
                    break;
                default:
                    result =NO_DATA_MESSAGE;
                    break;
            }
            return result;
        }},

        {dataIndex:'CJAAC_FECHA',header:'Fecha',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CJACU_COSTO',header:'Costo Total',width:150,sortable:true,renderer: Ext.util.Format.usMoney},
        {dataIndex:'CJAAC_MONTO',header:' $ Monto',width:150,sortable:true,renderer: Ext.util.Format.usMoney},
        {dataIndex:'CJAAC_PORCENTAJE',header:' % Porcentaje',width:150,sortable:true},
        {dataIndex:'CJAAC_VALOR_1',header:'$ Valor',width:150,sortable:true,renderer: Ext.util.Format.usMoney},
        {dataIndex:'CJAAC_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_jur_anticipo por un campo especifico.
     */
    var gsCgg_jur_anticipo = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_anticipo",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CJAAC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CJAAC_CODIGO'},
            {name:'CJACU_CODIGO'},
            {name:'CRPJR_CODIGO'},
            {name:'RAZON_SOCIAL'},
            {name:'CRPER_CODIGO'},
            {name:'PERSONA'},
            {name:'CJTPR_CODIGO'},
            {name:'NOMBRE_PROCESO'},
            {name:'CJACU_ANIO'},
            {name:'CJACU_NUMERO'},
            {name:'CJACU_OBJETO'},
            {name:'CJACU_FECHA_SUSCRIPCION'},
            {name:'CJACU_FECHA_INICIO'},
            {name:'CJACU_RESPONSABLE'},
            {name:'CJACU_ESTADO_EJECUCION'},
            {name:'CJACU_TIPO'},
            {name:'CJACU_TIPO_PERSONA'},
            {name:'CJACU_COSTO'},
            {name:'CJAAC_PORCENTAJE'},
            {name:'CJAAC_OBSERVACION'},
            {name:'CJAAC_FECHA'},
            {name:'CJAAC_MONTO'},
            {name:'CJAAC_VALOR_1'}
        ]),
        //sortInfo:{field: 'CJACU_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'},
        groupField:'CJACU_TIPO',
        sortInfo: {
            field: 'CJACU_TIPO',
            direction: 'ASC'
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_jur_anticipo.
     */
    var pgBarCgg_jur_anticipo= new Ext.PagingToolbar({
        store: gsCgg_jur_anticipo,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_jur_anticipo en un formato tabular de filas y columnas.
     */
    var grdCgg_jur_anticipo = new Ext.grid.GridPanel({
        cm:cmCgg_jur_anticipo,
        store:gsCgg_jur_anticipo,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_jur_anticipo,
                width:200
            })
        ],
        bbar:pgBarCgg_jur_anticipo,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_jur_anticipo.hidden){
                    btnEditarCgg_jur_anticipo.fireEvent('click', btnEditarCgg_jur_anticipo);
                }
            }}});
    gsCgg_jur_anticipo.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_jur_anticipo.
     */
    if(inDesktop){
        var winFrmListadoCgg_jur_anticipo = inDesktop.createWindow({
            id:'winFrmListadoCgg_jur_anticipo',
            title:tituloListadoCgg_jur_anticipo,
            iconCls:'iconAplicacion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_jur_anticipo,descListadoCgg_jur_anticipo),
            items:[grdCgg_jur_anticipo],
            bbar:[btnNuevoCgg_jur_anticipo,btnEditarCgg_jur_anticipo,btnEliminarCgg_jur_anticipo,'->',btnSalirCgg_jur_anticipo]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_jur_anticipo.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_jur_anticipo.
     * @returns ventana winFrmCgg_jur_anticipo.
     * @base FrmListadoCgg_jur_anticipo.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_jur_anticipo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_jur_anticipo.
     * @base FrmListadoCgg_jur_anticipo.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_jur_anticipo.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_jur_anticipo;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_jur_anticipo;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_jur_anticipo.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_jur_anticipo.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_jur_anticipo desde una instancia.
 */
FrmListadoCgg_jur_anticipo.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_jur_anticipo desde una instancia.
 */
FrmListadoCgg_jur_anticipo.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_jur_anticipo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_jur_anticipo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_jur_anticipo desde una instancia.
 */
FrmListadoCgg_jur_anticipo.prototype.loadData = function(){
    this.loadData();
}
