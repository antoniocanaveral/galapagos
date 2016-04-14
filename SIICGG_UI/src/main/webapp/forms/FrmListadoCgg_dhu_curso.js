/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_curso.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_curso(inDescktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Curso/Cursos';
    var urlListadoCgg_dhu_curso=URL_WS+"Cgg_dhu_curso";
    var tituloListadoCgg_dhu_curso='Curso';
    var descListadoCgg_dhu_curso='El formulario permite administrar informaci\u00f3n del registro de cursos';
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_curso.
     */
    var btnNuevoCgg_dhu_curso = new Ext.Button({
        id:'btnNuevoCgg_dhu_curso',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_dhu_curso = new FrmCgg_dhu_curso("insert");
                objCgg_dhu_curso.closeHandler(function(){
                    gsCgg_dhu_curso.reload();
                });
                objCgg_dhu_curso.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_curso.
     */
    var btnEditarCgg_dhu_curso = new Ext.Button({
        id:'btnEditarCgg_dhu_curso',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_dhu_curso.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_curso = new FrmCgg_dhu_curso("update",r);
                    objCgg_dhu_curso.closeHandler(function(){
                        gsCgg_dhu_curso.reload();
                    });
                    objCgg_dhu_curso.loadData();
                    objCgg_dhu_curso.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_curso.
     */
    var btnEliminarCgg_dhu_curso = new Ext.Button({
        id:'btnEliminarCgg_dhu_curso',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'\u00BFSeguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_curso,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_curso(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_curso(r){
                            winFrmListadoCgg_dhu_curso.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_curso,
                                    msg: 'La informaci\u00f3n del registro curso ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_curso.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_curso,
                                    msg: 'La informaci\u00f3n del registro curso no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_curso.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdcur_codigo',grdCgg_dhu_curso.getSelectionModel().getSelected().get('CDCUR_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_curso,"delete",param, true, CallBackCgg_dhu_curso);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_curso.getEl().unmask();
                    }}}
            }}
    });
	
	var btnNuevoCgg_dhu_curso_historial = new Ext.Button({
		id:'btnNuevoCgg_dhu_curso_historial',
		text:'Historial curso',
		tooltip:'Historial curso',
		iconCls:'iconListado',
		listeners:{
			click:function(){
					var objListadoCgg_dhu_curso_historial = new FrmListadoCgg_dhu_curso_historial();					
					objListadoCgg_dhu_curso_historial.show();
			}
		}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_curso.
     */
    var btnSalirCgg_dhu_curso = new Ext.Button({
        id:'btnSalirCgg_dhu_curso',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_curso.close();
            }}
    });
   
         /**
     *  Ext.ux.grid.RowExpander Expandir fila
     **/
    var expanderCurso = new Ext.ux.grid.RowExpander({
        tpl : new Ext.XTemplate(
               '<table id="box-table-a" cborder="8" align="left"> <width="180%" height="100%" cellpadding="4">' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><span style="font-family: Arial, Helvetica, sans-serif; ">Fec:</span></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{[this.myDate(values.CDCUR_FECHA_PREVISTA_INICIO)]}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Fecha fin:</font></div></td>' +
                    '<td><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{[this.myDate(values.CDCUR_FECHA_PREVISTA_CULMINACION)]}</span></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Modulo:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDCUR_NUMERO_MODULOS}</font></td></tr>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">Horario:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDCUR_HORARIO} a {CDCUR_HORARIO1}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">No.horas:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDCUR_NUMERO_HORAS}</font></td>' +
                    '<td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">No.horas pedag:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDCUR_NUMERO_HORAS_PEDAGOGICAS}</font></td></td></tr>' +
                    '<tr rowspan="0"><td><div class="tituloTemplate"><font  face="Arial, Helvetica, sans-serif">Costo:</font></div></td>' +
                    '<td><font size="1" face="Arial, Helvetica, sans-serif">{CDCUR_COSTO}</font></td></td>' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">V.financiado:</font></div></td>' +
                    '<td><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CDCUR_PORCENTAJE_FINANCIADO}</span></td></td>' +
                    '<td><div class="tituloTemplate"><font face="Arial, Helvetica, sans-serif">V. contra parte</font></div></td>' +
                    '<td><span  style="font-size: xx-small; font-family: Arial, Helvetica, sans-serif; ">{CDCUR_VALORACION}</span></td></td></tr>' +
                       '</table>',
                 {
            // XTemplate configuration:
            compiled: true,
            disableFormats: true,
            // member functions:
            myDate: function(CDCUR_FECHA){
                return truncDate(CDCUR_FECHA);
            }
        })
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_curso.
     */
    var cmCgg_dhu_curso = new Ext.grid.ColumnModel([
        expanderCurso,
        {dataIndex:'CDCUR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDTCR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCUR_DESCRIPCION',header:'Curso',width:150,sortable:true},
        {dataIndex:'CDTCR_NOMBRE',header:'Tipo curso',width:150,sortable:true,hidden:true},
        {dataIndex:'CCTN_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CCTN_NOMBRE',header:'Cant\u00f3n',width:150,sortable:true},
        {dataIndex:'CSCTP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CSCTP_NOMBRE',header:'Sector productivo',width:150,sortable:true},
        {dataIndex:'CISLA_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CISLA_NOMBRE',header:'Isla',width:150,sortable:true,hidden:true},
        {dataIndex:'CDITR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDITR_NOMBRE',header:'Instituci\u00f3n',width:150,sortable:true},
        {dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_INSTRUCTOR',header:'Cordinador',width:150,sortable:true},
		{dataIndex:'CDCUR_FECHA_PREVISTA_INICIO',header:'Fecha prevista inicio',width:150,sortable:true,renderer:truncDate,hidden:true},
        {dataIndex:'CDCUR_FECHA_INICIO',header:'Fecha inicio',width:150,sortable:true,renderer:truncDate,hidden:true},
        {dataIndex:'CDCUR_FECHA_CULMINACION',header:'Fecha culminaci\u00f3n',width:150,sortable:true,renderer:truncDate,hidden:true},
        {dataIndex:'CDCUR_FECHA_PREVISTA_CULMINACION',header:'Fecha prevista culminaci\u00f3n',width:150,sortable:true,renderer:truncDate,hidden:true},
        {dataIndex:'CDCUR_HORARIO',header:'Horario',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCUR_HORARIO1',header:'Horario',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCUR_NUMERO_HORAS_PEDAGOGICAS',header:'Numero horas pedagogicas',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCUR_NUMERO_HORAS',header:'Numero horas',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCUR_NUMERO_MODULOS',header:'Numero m\u00f3dulos',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCUR_CONTENIDO',header:'Contenido',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCUR_INSTITUCION',header:'Instituci\u00f3n',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCUR_ESTABLECIMIENTO',header:'Establecimiento',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCUR_COSTO',header:'Costo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCUR_PORCENTAJE_FINANCIADO',header:'Porcentaje financiado',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCUR_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCUR_VALORACION',header:'Valoracion',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCUR_ESTADO_CURSO',header:'Estado curso',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCUR_NUMERO_ASISTENTE',header:'Numero de asistentes',width:150,sortable:true,hidden:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_curso por un campo especifico.
     */
    var gsCgg_dhu_curso = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_curso",
            method:"selectCursoPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDCUR_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDCUR_CODIGO'},
            {name:'CDTCR_CODIGO'},
            {name:'CDTCR_NOMBRE'},
            {name:'CCTN_CODIGO'},
            {name:'CCTN_NOMBRE'},
            {name:'CISLA_CODIGO'},
            {name:'CISLA_NOMBRE'},
            {name:'CSCTP_CODIGO'},
            {name:'CSCTP_NOMBRE'},
            {name:'CDITR_CODIGO'},
            {name:'CDITR_NOMBRE'},
            {name:'CRPER_CODIGO'},
            {name:'CRPER_INSTRUCTOR'},
            {name:'CDCUR_DESCRIPCION'},
			{name:'CDCUR_FECHA_PREVISTA_INICIO'},
            {name:'CDCUR_FECHA_INICIO'},
            {name:'CDCUR_FECHA_CULMINACION'},
            {name:'CDCUR_FECHA_PREVISTA_CULMINACION'},
            {name:'CDCUR_HORARIO'},
            {name:'CDCUR_HORARIO1'},
            {name:'CDCUR_NUMERO_HORAS_PEDAGOGICAS'},
            {name:'CDCUR_NUMERO_HORAS'},
            {name:'CDCUR_NUMERO_MODULOS'},
            {name:'CDCUR_CONTENIDO'},
            {name:'CDCUR_INSTITUCION'},
            {name:'CDCUR_ESTABLECIMIENTO'},
            {name:'CDCUR_COSTO'},
            {name:'CDCUR_PORCENTAJE_FINANCIADO'},
            {name:'CDCUR_OBSERVACION'},
            {name:'CDCUR_VALORACION'},
            {name:'CDCUR_ESTADO_CURSO'},
            {name:'CDCUR_NUMERO_ASISTENTE'}
        ]),
        sortInfo:{field: 'CDTCR_NOMBRE', direction: 'ASC'},
        groupField:"CDTCR_NOMBRE",
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_curso.
     */
    var pgBarCgg_dhu_curso= new Ext.PagingToolbar({
        store: gsCgg_dhu_curso,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_curso en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_curso = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_curso,
        store:gsCgg_dhu_curso,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
         view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_curso,
                width:200
            })
        ], plugins: expanderCurso,
        animCollapse: false,
        bbar:pgBarCgg_dhu_curso,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_curso.hidden){
                    btnEditarCgg_dhu_curso.fireEvent('click', btnEditarCgg_dhu_curso);
                }
            }}});
    gsCgg_dhu_curso.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_curso.
     */
    if(inDescktop){
    var winFrmListadoCgg_dhu_curso = inDescktop.createWindow({
        id:'winFrmListadoCgg_dhu_curso',
        title:tituloListadoCgg_dhu_curso,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_curso,descListadoCgg_dhu_curso),
        items:[grdCgg_dhu_curso],
        bbar:[btnNuevoCgg_dhu_curso,btnEditarCgg_dhu_curso,btnEliminarCgg_dhu_curso,btnNuevoCgg_dhu_curso_historial,'->',btnSalirCgg_dhu_curso]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_dhu_curso.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_curso.
     * @returns ventana winFrmCgg_dhu_curso.
     * @base FrmListadoCgg_dhu_curso.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_curso;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_curso.
     * @base FrmListadoCgg_dhu_curso.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_curso.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_curso;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_curso;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_curso.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_curso.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_curso desde una instancia.
 */
FrmListadoCgg_dhu_curso.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_curso desde una instancia.
 */
FrmListadoCgg_dhu_curso.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_curso,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_curso.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_curso desde una instancia.
 */
FrmListadoCgg_dhu_curso.prototype.loadData = function(){
    this.loadData();
}
