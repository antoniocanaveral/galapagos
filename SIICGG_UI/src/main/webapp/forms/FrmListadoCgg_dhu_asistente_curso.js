/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_asistente_curso.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_asistente_curso(inDescktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Curso/Asistentes curso/Registro asistente';
    var urlListadoCgg_dhu_asistente_curso=URL_WS+"Cgg_dhu_asistente_curso";
    var tituloListadoCgg_dhu_asistente_curso='Asistente curso';
    var descListadoCgg_dhu_asistente_curso='El formulario permite administrar informaci\u00f3n de los asistentes a los cursos';
	var myJasperServer = new JasperServer();
    /**
	 * Ext.data.Store Almacenamiento de informacion del tipo de curso.
	 */
	var SCGG_DHU_TIPO_CURSO = new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_dhu_tipo_curso",
			method:"selectAll"
		}),
		reader:new Ext.data.JsonReader({},[
			{name:'CDTCR_CODIGO'},
			{name:'CDTCR_NOMBRE'}
		]),
		baseParams:{
			format:TypeFormat.JSON
		}
	});
	SCGG_DHU_TIPO_CURSO.load();
	/**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_asistente_curso.
     */
    var btnNuevoCgg_dhu_asistente_curso = new Ext.Button({
        id:'btnNuevoCgg_dhu_asistente_curso',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_dhu_asistente_curso = new FrmCgg_dhu_asistente_curso("insert");
                objCgg_dhu_asistente_curso.closeHandler(function(){
                    gsCgg_dhu_asistente_curso.reload();
                });
				objCgg_dhu_asistente_curso.setStoreTipoCurso(SCGG_DHU_TIPO_CURSO);
                objCgg_dhu_asistente_curso.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_asistente_curso.
     */
    var btnEditarCgg_dhu_asistente_curso = new Ext.Button({
        id:'btnEditarCgg_dhu_asistente_curso',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_dhu_asistente_curso.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_asistente_curso = new FrmCgg_dhu_asistente_curso("update",r);
                    objCgg_dhu_asistente_curso.closeHandler(function(){
                        gsCgg_dhu_asistente_curso.reload();
                    });
					objCgg_dhu_asistente_curso.setStoreTipoCurso(SCGG_DHU_TIPO_CURSO);
                    objCgg_dhu_asistente_curso.loadData();
					
                    objCgg_dhu_asistente_curso.show();
                }
            }}
    });
        /**
     * Ext.Button Boton que permite ingresar los registro de la ventana winFrmListadoCgg_dhu_asistente_curso.
     */
    var btnRegistrarCgg_dhu_asistente_curso = new Ext.Button({
        id:'btnRegistrarCgg_dhu_asistente_curso',
        text:'Registro asistencia',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
				var objCgg_dhu_asistente_curso = new FrmCgg_dhu_asistente_curso_calificacion();
                objCgg_dhu_asistente_curso.closeHandler(function(){
					gsCgg_dhu_asistente_curso.reload({
						params:{
							start:0,
							limit:RECORD_PAGE,
							format:"JSON"
						}
					});
				});
				objCgg_dhu_asistente_curso.setStoreTipoCurso(SCGG_DHU_TIPO_CURSO);
                objCgg_dhu_asistente_curso.show();
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_asistente_curso.
     */
    var btnEliminarCgg_dhu_asistente_curso = new Ext.Button({
        id:'btnEliminarCgg_dhu_asistente_curso',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_asistente_curso,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_asistente_curso(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_asistente_curso(r){
                            winFrmListadoCgg_dhu_asistente_curso.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_asistente_curso,
                                    msg: 'La informaci\u00f3n  ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_asistente_curso.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_asistente_curso,
                                    msg: 'La informaci\u00f3n  no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_asistente_curso.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdasc_codigo',grdCgg_dhu_asistente_curso.getSelectionModel().getSelected().get('CDASC_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_asistente_curso,"delete",param, true, CallBackCgg_dhu_asistente_curso);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_asistente_curso.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_asistente_curso.
     */
    var btnSalirCgg_dhu_asistente_curso = new Ext.Button({
        id:'btnSalirCgg_dhu_asistente_curso',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_asistente_curso.close();
            }}
    });
	  /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_asistente_curso.
     */
	 	var btnReporteCertificado = new Ext.Action({
		id:'btnReporteCertificado',
		text:'Imprimir Certificado',
		iconCls:'iconImprimir',
		//disabled:true,
		handler:function(){
			var tmpRecord = grdCgg_dhu_asistente_curso.getSelectionModel().getSelected();
			if(tmpRecord){
				 var pReport = [];
                    pReport[0]={
                   
                        label:'Curso',
                        paramName:'P_CDCUR_CODIGO',
                        paramValue:tmpRecord.get('CDCUR_CODIGO'),
                        value:tmpRecord.get('CDCUR_DESCRIPCION'),
                        type:'direct'
                    };
					
					  pReport[1]={
                        label:'Curso',
                        paramName:'P_CRPER_CODIGO',
                        paramValue:tmpRecord.get('CRPER_CODIGO'),
                        value:tmpRecord.get('CRPER_NOMBRES'),
                        type:'direct'
                    };
      
                    var reporte = new FrmCriterioReporte('rptCertificadoCursos', '/Reports/sii/dhu', null);
                    reporte.addParams(pReport);
                    reporte.show();
			}
		}
	});
	
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_asistente_curso.
     */
    var cmCgg_dhu_asistente_curso = new Ext.grid.ColumnModel([
        {dataIndex:'CDASC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_CODIGO',header:'Codigoper',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCUR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CSCTP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CUSU_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDCUR_DESCRIPCION',header:'Curso',width:150,sortable:true,hidden:true},
        {dataIndex:'CSCTP_NOMBRE',header:'Sector productivo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'No. documento',width:150,sortable:true},
        {dataIndex:'CRPER_NOMBRES',header:'Nombres',width:150,sortable:true},
        {dataIndex:'CRPER_APELLIDO_PATERNO',header:'Apellido paterno',width:150,sortable:true},
        {dataIndex:'CRPER_APELLIDO_MATERNO',header:'Apellido materno',width:150,sortable:true},
        {dataIndex:'CRPER_FECHA_NACIMIENTO',header:'Fecha nacimiento',width:150,sortable:true,renderer:truncDate,hidden:true},
        {dataIndex:'CRPER_LUGAR_NACIMIENTO',header:'Lugar nacimiento',width:150,sortable:true,hidden:true},
		{dataIndex:'CRPER_NUMERO_RESIDENCIA',header:'Numero residencia',width:150,sortable:true,hidden:true},
        {dataIndex:'TIPO_RESIDENCIA',header:'Tipo residencia',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_AUSPICIANTE',header:'Auspiciante',width:150,sortable:true,hidden:true},
        {dataIndex:'CDASC_ACTIVIDAD_REALIZADA',header:'Actividad realizada',width:150,sortable:true,hidden:true},
        {dataIndex:'CDASC_NOTA_FINAL',header:'Nota final',width:150,sortable:true,hidden:true},
        {dataIndex:'CDASC_NUMERO_CERTIFICADO',header:'N\u00famero certificado',width:150,sortable:true},
        {dataIndex:'CDASC_FECHA_EMISION_CERTIFICADO',header:'Fecha emisi\u00f3n certificado',width:150,sortable:true,hidden:true,renderer:truncDate},
        {dataIndex:'CDASC_ESTADO_INSCRIPCION',header:'Estado inscripci\u00f3n',width:150,sortable:true,renderer:function(inEstadoInscripcion){
            if(inEstadoInscripcion==TypeEstadoInscripcion.PRE_INSCRITO){
                return('PRE-INSCRITO')
            }
            if(inEstadoInscripcion==TypeEstadoInscripcion.INSCRITO){
                return('INSCRITO')
            }
            if(inEstadoInscripcion==TypeEstadoInscripcion.ANULADO){
                return('ANULADO')
            }
        }},
        {dataIndex:'CDASC_APROBADO',header:'Aprobado',width:150,sortable:true,renderer:function(inCasc_Aprobado){
            if(inCasc_Aprobado==TypeEstadoAprobadoCurso.APROBADO){
                return('APROBADO');
            }
             if(inCasc_Aprobado==TypeEstadoAprobadoCurso.REPROBADO){
                return('REPROBADO');
            }
             if(inCasc_Aprobado==TypeEstadoAprobadoCurso.RETIRADO){
                return('RETIRADO');
            }
             if(inCasc_Aprobado==TypeEstadoAprobadoCurso.SIN_CALIFICACION){
                return('SIN CALIFICACION');
            }
        }}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_asistente_curso por un campo especifico.
     */
    var gsCgg_dhu_asistente_curso = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_asistente_curso",
            method:"selectAistenteCursoPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDASC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDASC_CODIGO'},
            {name:'CRPER_CODIGO'},
            {name:'CDCUR_CODIGO'},
            {name:'CDCUR_DESCRIPCION'},
            {name:'CSCTP_CODIGO'},
            {name:'CSCTP_NOMBRE'},
            {name:'CUSU_CODIGO'},
            {name:'CRDID_TIPO'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_APELLIDO_MATERNO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_FECHA_NACIMIENTO'},
            {name:'CRPER_LUGAR_NACIMIENTO'},
            {name:'CRPER_NUMERO_RESIDENCIA'},
            {name:'TIPO_RESIDENCIA'},
            {name:'CRPER_AUSPICIANTE'},
            {name:'CDASC_ACTIVIDAD_REALIZADA'},
            {name:'CDASC_NOTA_FINAL'},
            {name:'CDASC_NUMERO_CERTIFICADO'},
            {name:'CDASC_FECHA_EMISION_CERTIFICADO'},
            {name:'CDASC_ESTADO_INSCRIPCION'},
            {name:'CDASC_APROBADO'},
			{name:'CDTCR_CODIGO'}
        ]),
        sortInfo:{field: 'CDCUR_DESCRIPCION', direction: 'ASC'},
        groupField:"CDCUR_DESCRIPCION",
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_asistente_curso.
     */
    var pgBarCgg_dhu_asistente_curso= new Ext.PagingToolbar({
        store: gsCgg_dhu_asistente_curso,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_asistente_curso en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_asistente_curso = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_asistente_curso,
        store:gsCgg_dhu_asistente_curso,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        }),
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_asistente_curso,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_asistente_curso,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_asistente_curso.hidden){
                    btnEditarCgg_dhu_asistente_curso.fireEvent('click', btnEditarCgg_dhu_asistente_curso);
                }
            }}});
    gsCgg_dhu_asistente_curso.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_asistente_curso.
     */
    if(inDescktop){
    var winFrmListadoCgg_dhu_asistente_curso = inDescktop.createWindow({
        id:'winFrmListadoCgg_dhu_asistente_curso',
        title:tituloListadoCgg_dhu_asistente_curso,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_asistente_curso,descListadoCgg_dhu_asistente_curso),
        items:[grdCgg_dhu_asistente_curso],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        bbar:[btnNuevoCgg_dhu_asistente_curso,btnRegistrarCgg_dhu_asistente_curso,btnEditarCgg_dhu_asistente_curso,btnEliminarCgg_dhu_asistente_curso,'->',btnReporteCertificado,btnSalirCgg_dhu_asistente_curso]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_dhu_asistente_curso.getBottomToolbar());
    }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_asistente_curso.
     * @returns ventana winFrmCgg_dhu_asistente_curso.
     * @base FrmListadoCgg_dhu_asistente_curso.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_asistente_curso;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_asistente_curso.
     * @base FrmListadoCgg_dhu_asistente_curso.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_asistente_curso.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_asistente_curso;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_asistente_curso;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_asistente_curso.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_asistente_curso.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_asistente_curso desde una instancia.
 */
FrmListadoCgg_dhu_asistente_curso.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_asistente_curso desde una instancia.
 */
FrmListadoCgg_dhu_asistente_curso.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_asistente_curso,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_asistente_curso.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_asistente_curso desde una instancia.
 */
FrmListadoCgg_dhu_asistente_curso.prototype.loadData = function(){
    this.loadData();
}
