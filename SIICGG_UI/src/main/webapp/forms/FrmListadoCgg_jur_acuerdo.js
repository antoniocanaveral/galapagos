/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_jur_acuerdo.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_jur_acuerdo(inDesktop){
    var optMenu = 'Jur\u00eddico/Acuerdos';
    var urlListadoCgg_jur_acuerdo=URL_WS+"Cgg_jur_acuerdo";
    var tituloListadoCgg_jur_acuerdo='Acuerdo: Contrato - Convenio';
    var descListadoCgg_jur_acuerdo='El formulario permite administrar informaci\u00f3n de Acuerdo: Contrato - Convenio';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_jur_acuerdo.
     */
    var btnNuevoCgg_jur_acuerdo = new Ext.Button({
        id:'btnNuevoCgg_jur_acuerdo',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_jur_acuerdo = new FrmCgg_jur_acuerdo("insert");
                objCgg_jur_acuerdo.closeHandler(function(){
                    gsCgg_jur_acuerdo.reload();
                });
                objCgg_jur_acuerdo.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_jur_acuerdo.
     */
    var btnEditarCgg_jur_acuerdo = new Ext.Button({
        id:'btnEditarCgg_jur_acuerdo',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_jur_acuerdo.getSelectionModel().getSelected();
                if(r){
                    var objCgg_jur_acuerdo = new FrmCgg_jur_acuerdo("update",r);
                    objCgg_jur_acuerdo.closeHandler(function(){
                        gsCgg_jur_acuerdo.reload();
                    });
                    objCgg_jur_acuerdo.loadData();
                    objCgg_jur_acuerdo.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_jur_acuerdo.
     */
    var btnEliminarCgg_jur_acuerdo = new Ext.Button({
        id:'btnEliminarCgg_jur_acuerdo',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_jur_acuerdo,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_jur_acuerdo(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_jur_acuerdo(r){
                            winFrmListadoCgg_jur_acuerdo.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_jur_acuerdo,
                                    msg: 'La informaci\u00f3n de Acuerdo ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_jur_acuerdo.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_jur_acuerdo,
                                    msg: 'La informaci\u00f3n de Acuerdo no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_jur_acuerdo.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCjacu_codigo',grdCgg_jur_acuerdo.getSelectionModel().getSelected().get('CJACU_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_jur_acuerdo,"delete",param, true, CallBackCgg_jur_acuerdo);
                    }catch(inErr){
                        winFrmListadoCgg_jur_acuerdo.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_jur_acuerdo.
     */
    var btnSalirCgg_jur_acuerdo = new Ext.Button({
        id:'btnSalirCgg_jur_acuerdo',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_jur_acuerdo.close();
            }}
    });    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_jur_acuerdo.
     */
    var chkCjacu_adendum = new Ext.grid.CheckColumn(
    {dataIndex:'CJACU_ADENDUM',header:'Adendum',width:150,sortable:true});
    var cmCgg_jur_acuerdo = new Ext.grid.ColumnModel([
        {dataIndex:'CJACU_CODIGO',header:'Codigo',width:150,sortable:true, hidden:true,hideable:false},
        {dataIndex:'CUSU_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CRPJR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CJACU_NUMERO',header:'N\u00famero',width:100,sortable:true},
        {dataIndex:'CRPJR_RAZON_SOCIAL',header:'Raz\u00f3n Social',width:200,sortable:true,renderer:
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
        {dataIndex:'CJACU_COSTO',header:'$ Costo',width:100,sortable:true,align: 'right',renderer: Ext.util.Format.usMoney},
        {dataIndex:'CJACU_TIEMPO',header:'Tiempo',width:100,sortable:true,align: 'right',renderer:function(value)
        {
            return value==1?value+ ' dia': value+ ' dias'
        }},
        //        {dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        //        {dataIndex:'RAZON_SOCIAL',header:'Raz\u00f3n Social',width:150,sortable:true},
        {dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        //  {dataIndex:'PERSONA',header:'Persona',width:150,sortable:true},
        {dataIndex:'CGG_CUSU_CODIGO',header:'Cusu codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CSCTP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'SECTOR_PRODUCTIVO',header:'Sector Productivo',width:150,sortable:true},
        {dataIndex:'CJTPR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'NOMBRE_PROCESO',header:'Nombre Proceso',width:150,sortable:true},
        {dataIndex:'CAINF_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'AREA',header:'\u00c1rea Influencia',width:150,sortable:true},
        {dataIndex:'CJACU_ANIO',header:'A\u00f1o',width:150,sortable:true},
        {dataIndex:'CJACU_OBJETO',header:'Objeto',width:150,sortable:true},
        {dataIndex:'CJACU_DESCRIPCION',header:'Descripci\u00f3n',width:150,sortable:true},
        {dataIndex:'CJACU_JURISDICCION_AMBITO',header:'Jurisdicci\u00f3n \u00e1mbito',width:150,sortable:true},
        {dataIndex:'CJACU_INSTITUCION_FIRMA',header:'Instituci\u00f3n firma',width:150,sortable:true},
        {dataIndex:'CJACU_FECHA_INICIO',header:'Fecha inicio',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'RESPONSABLE',header:'Responsable',width:150,sortable:true},
        {dataIndex:'CJACU_PARTIDA_PRESUPUESTARIA',header:'Partida presupuestaria',width:150,sortable:true},


        {dataIndex:'CJACU_ESTADO_EJECUCION',header:'Estado ejecuci\u00f3n',width:150,sortable:true,renderer:function(inCjacu_estado_ejecucion) {
            return dsEstadoEjecucion[inCjacu_estado_ejecucion][1];

        }
        },
        {dataIndex:'CJACU_FECHA_FINALIZACION',header:'Fecha finalizaci\u00f3n',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CJACU_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true},
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

        }
        },
        chkCjacu_adendum,
        {dataIndex:'CJACU_FECHA_ADENDUM',header:'Fecha adendum',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CJACU_OBJETO_ADENDUM',header:'Objeto adendum',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_jur_acuerdo por un campo especifico.
     */
    var gsCgg_jur_acuerdo = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_acuerdo",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CJACU_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CJACU_CODIGO'},
            {name:'CUSU_CODIGO'},
            {name:'CRPJR_CODIGO'},
            {name:'CRPJR_RAZON_SOCIAL'},
            {name:'CRPER_CODIGO'},
            {name:'PERSONA'},
            {name:'CGG_CUSU_CODIGO'},
            {name:'CSCTP_CODIGO'},
            {name:'SECTOR_PRODUCTIVO'},
            {name:'CJTPR_CODIGO'},
            {name:'NOMBRE_PROCESO'},
            {name:'CAINF_CODIGO'},
            {name:'AREA'},
            {name:'CJACU_ANIO'},
            {name:'CJACU_NUMERO'},
            {name:'CJACU_OBJETO'},
            {name:'CJACU_DESCRIPCION'},
            {name:'CJACU_JURISDICCION_AMBITO'},
            {name:'CJACU_FECHA_SUSCRIPCION'},
            {name:'CJACU_INSTITUCION_FIRMA'},
            {name:'CJACU_FECHA_INICIO'},
            {name:'RESPONSABLE'},
            {name:'CJACU_PARTIDA_PRESUPUESTARIA'},
            {name:'CJACU_COSTO'},
            {name:'CJACU_TIEMPO'},
            {name:'CJACU_ESTADO_EJECUCION'},
            {name:'CJACU_FECHA_FINALIZACION'},
            {name:'CJACU_OBSERVACION'},
            {name:'CJACU_TIPO'},
            {name:'CJACU_TIPO_PERSONA'},
            {name:'CJACU_ADENDUM'},
            {name:'CJACU_FECHA_ADENDUM'},
            {name:'CJACU_OBJETO_ADENDUM'}
        ]),
        baseParams:{keyword:"",format:'JSON'},
        groupField:'CJACU_TIPO',
        sortInfo: {
            field: 'CJACU_TIPO',
            direction: 'ASC'
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_jur_acuerdo.
     */
    var pgBarCgg_jur_acuerdo= new Ext.PagingToolbar({
        store: gsCgg_jur_acuerdo,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_jur_acuerdo en un formato tabular de filas y columnas.
     */
    var grdCgg_jur_acuerdo = new Ext.grid.GridPanel({
        cm:cmCgg_jur_acuerdo,
        store:gsCgg_jur_acuerdo,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_jur_acuerdo,
                width:200
            })
        ],
        bbar:pgBarCgg_jur_acuerdo,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_jur_acuerdo.hidden){
                    btnEditarCgg_jur_acuerdo.fireEvent('click', btnEditarCgg_jur_acuerdo);
                }
            }}});
    gsCgg_jur_acuerdo.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_jur_acuerdo.
     */
    if(inDesktop){
        var winFrmListadoCgg_jur_acuerdo = inDesktop.createWindow({
            id:'winFrmListadoCgg_jur_acuerdo',
            title:tituloListadoCgg_jur_acuerdo,
            iconCls:'iconAplicacion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_jur_acuerdo,descListadoCgg_jur_acuerdo),
            items:[grdCgg_jur_acuerdo],
            bbar:[btnNuevoCgg_jur_acuerdo,btnEditarCgg_jur_acuerdo,btnEliminarCgg_jur_acuerdo,'->',btnSalirCgg_jur_acuerdo]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_jur_acuerdo.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_jur_acuerdo.
     * @returns ventana winFrmCgg_jur_acuerdo.
     * @base FrmListadoCgg_jur_acuerdo.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_jur_acuerdo;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_jur_acuerdo.
     * @base FrmListadoCgg_jur_acuerdo.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_jur_acuerdo.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_jur_acuerdo;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_jur_acuerdo;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_jur_acuerdo.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_jur_acuerdo.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_jur_acuerdo desde una instancia.
 */
FrmListadoCgg_jur_acuerdo.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_jur_acuerdo desde una instancia.
 */
FrmListadoCgg_jur_acuerdo.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_jur_acuerdo,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_jur_acuerdo.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_jur_acuerdo desde una instancia.
 */
FrmListadoCgg_jur_acuerdo.prototype.loadData = function(){
    this.loadData();
}
