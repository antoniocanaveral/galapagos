/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_jur_proceso_judicial.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_jur_proceso_judicial(inDesktop){
    var optMenu = 'Jur\u00eddico/Proceso judiciales';
    var urlListadoCgg_jur_proceso_judicial=URL_WS+"Cgg_jur_proceso_judicial";
    var tituloListadoCgg_jur_proceso_judicial='Proceso Judicial';
    var descListadoCgg_jur_proceso_judicial='El formulario permite administrar informaci\u00f3n de Proceso Judicial';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_jur_proceso_judicial.
     */
    var btnNuevoCgg_jur_proceso_judicial = new Ext.Button({
        id:'btnNuevoCgg_jur_proceso_judicial',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_jur_proceso_judicial = new FrmCgg_jur_proceso_judicial("insert");
                objCgg_jur_proceso_judicial.closeHandler(function(){
                    gsCgg_jur_proceso_judicial.reload();
                });
                objCgg_jur_proceso_judicial.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_jur_proceso_judicial.
     */
    var btnEditarCgg_jur_proceso_judicial = new Ext.Button({
        id:'btnEditarCgg_jur_proceso_judicial',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_jur_proceso_judicial.getSelectionModel().getSelected();
                if(r){
                    var objCgg_jur_proceso_judicial = new FrmCgg_jur_proceso_judicial("update",r);
                    objCgg_jur_proceso_judicial.closeHandler(function(){
                        gsCgg_jur_proceso_judicial.reload();
                    });
                    objCgg_jur_proceso_judicial.loadData();
                    objCgg_jur_proceso_judicial.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_jur_proceso_judicial.
     */
    var btnEliminarCgg_jur_proceso_judicial = new Ext.Button({
        id:'btnEliminarCgg_jur_proceso_judicial',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_jur_proceso_judicial,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_jur_proceso_judicial(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_jur_proceso_judicial(r){
                            winFrmListadoCgg_jur_proceso_judicial.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_jur_proceso_judicial,
                                    msg: 'La informaci\u00f3n de Proceso Judicial ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_jur_proceso_judicial.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_jur_proceso_judicial,
                                    msg: 'La informaci\u00f3n de Proceso Judicial no ha podido ser eliminada.'+(r.message?r.message:r),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_jur_proceso_judicial.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCjpju_codigo',grdCgg_jur_proceso_judicial.getSelectionModel().getSelected().get('CJPJU_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_jur_proceso_judicial,"delete",param, true, CallBackCgg_jur_proceso_judicial);
                    }catch(inErr){
                        winFrmListadoCgg_jur_proceso_judicial.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_jur_proceso_judicial.
     */
    var btnSalirCgg_jur_proceso_judicial = new Ext.Button({
        id:'btnSalirCgg_jur_proceso_judicial',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_jur_proceso_judicial.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_jur_proceso_judicial.
     */
    var cmCgg_jur_proceso_judicial = new Ext.grid.ColumnModel([
        {dataIndex:'CJPJU_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CCTN_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CANTON',header:'Canton',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPJR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
        {dataIndex:'CJPJU_NUMERO',header:'N\u00famero',width:100,sortable:true},
        {dataIndex:'CRPJR_RAZON_SOCIAL',header:'Raz\u00f3n Social',width:200,sortable:true,
            renderer:function(value,metaData,record)
            {
                if (record.data.CRPJR_RAZON_SOCIAL)
                {
                    return value;
                }
                else
                {
                    return record.data.PERSONA;
                }
            }
        },
        {dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true,hideable:false},
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
        {dataIndex:'CJPJU_FECHA_INICIO',header:'Fecha inicio',width:150,sortable:true, renderer:truncDate},
        {dataIndex:'CJPJU_ESTADO_EJECUCION',header:'Estado ejecuci\u00f3n',width:150,sortable:true,renderer:function(inCjpj_estado_ejecucion) {
            return dsEstadoEjecucion[inCjpj_estado_ejecucion][1];
        }},
        {dataIndex:'CJPJU_RESPONSABLE',header:'Responsable',width:150,sortable:true},
        {dataIndex:'CJPJU_TIPO_PROCESO',header:'Tipo proceso',width:150,sortable:true,renderer:function(inCjpju_tipo_proceso) {
            return dsTipoProceso[inCjpju_tipo_proceso][1];
        }},
        {dataIndex:'CJPJU_TIPO_ADVERSARIO',header:'Tipo adversario',width:150,sortable:true,renderer:function(inCjpju_tipo_adversario) {
            return dsTipoAdversario[inCjpju_tipo_adversario][1];
        }},
        {dataIndex:'CJPJU_FECHA_FINALIZACION',header:'Fecha finalizaci\u00f3n',width:150,sortable:true, renderer:truncDate},
        {dataIndex:'CJPJU_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_jur_proceso_judicial por un campo especifico.
     */
    var gsCgg_jur_proceso_judicial = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_jur_proceso_judicial",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CJPJU_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CJPJU_CODIGO'},
            {name:'CCTN_CODIGO'},
            {name:'CANTON'},
            {name:'CRPJR_CODIGO'},
            {name:'CRPJR_RAZON_SOCIAL'},
            {name:'CRPER_CODIGO'},
            {name:'PERSONA'},
            {name:'CJPJU_NUMERO'},
            {name:'CJPJU_TIPO_PROCESO'},
            {name:'CJPJU_TIPO_ADVERSARIO'},
            {name:'CJPJU_FECHA_INICIO'},
            {name:'CJPJU_FECHA_FINALIZACION'},
            {name:'CJPJU_ESTADO_EJECUCION'},
            {name:'CJPJU_RESPONSABLE'},
            {name:'CJPJU_OBSERVACION'}
        ]),
        baseParams:{keyword:"",format:'JSON'},
        groupField:'CANTON',
        sortInfo: {
            field: 'CJPJU_CODIGO',
            direction: 'ASC'
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_jur_proceso_judicial.
     */
    var pgBarCgg_jur_proceso_judicial= new Ext.PagingToolbar({
        store: gsCgg_jur_proceso_judicial,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_jur_proceso_judicial en un formato tabular de filas y columnas.
     */
    var grdCgg_jur_proceso_judicial = new Ext.grid.GridPanel({
        cm:cmCgg_jur_proceso_judicial,
        store:gsCgg_jur_proceso_judicial,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'

        }),
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_jur_proceso_judicial,
                width:200
            })
        ],
        bbar:pgBarCgg_jur_proceso_judicial,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_jur_proceso_judicial.hidden){
                    btnEditarCgg_jur_proceso_judicial.fireEvent('click', btnEditarCgg_jur_proceso_judicial);
                }
            }}});
    gsCgg_jur_proceso_judicial.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_jur_proceso_judicial.
     */
    if(inDesktop){
        var winFrmListadoCgg_jur_proceso_judicial = inDesktop.createWindow({
            id:'winFrmListadoCgg_jur_proceso_judicial',
            title:tituloListadoCgg_jur_proceso_judicial,
            iconCls:'iconAplicacion',
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            tbar:getPanelTitulo('Listado '+tituloListadoCgg_jur_proceso_judicial,descListadoCgg_jur_proceso_judicial),
            items:[grdCgg_jur_proceso_judicial],
            bbar:[btnNuevoCgg_jur_proceso_judicial,btnEditarCgg_jur_proceso_judicial,btnEliminarCgg_jur_proceso_judicial,'->',btnSalirCgg_jur_proceso_judicial]
        });
        /**
         * Funcion que aplica los privilegios del usuario.
         */
        applyGrants(winFrmListadoCgg_jur_proceso_judicial.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_jur_proceso_judicial.
     * @returns ventana winFrmCgg_jur_proceso_judicial.
     * @base FrmListadoCgg_jur_proceso_judicial.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_jur_proceso_judicial;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_jur_proceso_judicial.
     * @base FrmListadoCgg_jur_proceso_judicial.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_jur_proceso_judicial.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_jur_proceso_judicial;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_jur_proceso_judicial;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_jur_proceso_judicial.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_jur_proceso_judicial.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_jur_proceso_judicial desde una instancia.
 */
FrmListadoCgg_jur_proceso_judicial.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_jur_proceso_judicial desde una instancia.
 */
FrmListadoCgg_jur_proceso_judicial.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_jur_proceso_judicial,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_jur_proceso_judicial.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_jur_proceso_judicial desde una instancia.
 */
FrmListadoCgg_jur_proceso_judicial.prototype.loadData = function(){
    this.loadData();
}
