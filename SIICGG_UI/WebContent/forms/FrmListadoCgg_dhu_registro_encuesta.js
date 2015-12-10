/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_registro_encuesta.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_registro_encuesta(inDescktop){    
    var urlListadoCgg_dhu_registro_encuesta=URL_WS+"Cgg_dhu_registro_encuesta";
    var tituloListadoCgg_dhu_registro_encuesta='Encuestas aplicadas';
    var descListadoCgg_dhu_registro_encuesta='El formulario permite administrar informaci\u00f3n las encuestas aplicadas';

    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_registro_encuesta.
     */
    var btnSalirCgg_dhu_registro_encuesta = new Ext.Button({
        id:'btnSalirCgg_dhu_registro_encuesta',
        text:'Salir',
        iconCls:'iconSalir',
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_registro_encuesta.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_registro_encuesta.
     */
    var cmCgg_dhu_registro_encuesta = new Ext.grid.ColumnModel([
        {dataIndex:'CDRGE_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDPRG_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDRES_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDAPE_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDENC_NOMBRE',header:'Encuesta',width:150,sortable:true,hidden:true},
        {dataIndex:'CDPRG_DESCRIPCION',header:'Pregunta',width:750,sortable:true},
        {dataIndex:'CDRES_DESCRIPCION',header:'Respuesta',width:450,sortable:true,
			renderer:function(v,s,r){
				var a = eval('['+r.data.JSON_INFO+']');
				if (a.length>1){
					var cadena ='';
					for(i=0;i<a.length;i++){
						cadena += ((i>0)?',':'' )+ a[i].CDRES_DESCRIPCION ;
					}
					return cadena;
				}else{
					if (a[0].CDPRG_CUANTIFICABLE == 'false'){
						return r.data.CDRGE_RESPUESTA_ABIERTA;
					}else{
						return a[0].CDRES_DESCRIPCION;
					}
					
				}
				
				return ;
			}
		},
        //{dataIndex:'CDRGE_RESPUESTA_ABIERTA',header:'Respuesta abierta',width:150,sortable:true},
        {dataIndex:'CDRGE_FECHA_REGISTRO',header:'Fecha registro',width:150,sortable:true,hidden:true},
        {dataIndex:'CDRGE_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true}
	]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_registro_encuesta por un campo especifico.
     */
    var gsCgg_dhu_registro_encuesta = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_registro_encuesta",
            method:"selectPage",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDRGE_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDRGE_CODIGO'},
            {name:'CDPRG_CODIGO'},
            {name:'CDRES_CODIGO'},
            {name:'CDAPE_CODIGO'},
            {name:'CDENC_NOMBRE'},
            {name:'CDPRG_DESCRIPCION'},
            {name:'CDRES_DESCRIPCION'},
            {name:'CDRGE_RESPUESTA_ABIERTA'},
            {name:'CDRGE_FECHA_REGISTRO'},
            {name:'CDRGE_OBSERVACION'},
			{name:'JSON_INFO'}
        ]),
        sortInfo:{field: 'CDENC_NOMBRE', direction: 'ASC'},
        groupField:"CDENC_NOMBRE",//'CDRGE_FECHA_REGISTRO'],
        baseParams:{keyword:"",format:"JSON"}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_registro_encuesta.
     */
    var pgBarCgg_dhu_registro_encuesta= new Ext.PagingToolbar({
        store: gsCgg_dhu_registro_encuesta,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_registro_encuesta en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_registro_encuesta = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_registro_encuesta,
        store:gsCgg_dhu_registro_encuesta,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
		view : new Ext.grid.GroupingView({  
			forceFit            : true,  
			ShowGroupName       : true,  
			enableNoGroup       : false,  
			enableGropingMenu   : false,  
			hideGroupedColumn   : true  
		}),
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_registro_encuesta,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_registro_encuesta       
	});
    gsCgg_dhu_registro_encuesta.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_registro_encuesta.
     */
    //if(inDescktop){
    var winFrmListadoCgg_dhu_registro_encuesta = new Ext.Window({
        id:'winFrmListadoCgg_dhu_registro_encuesta',
        title:tituloListadoCgg_dhu_registro_encuesta,
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_registro_encuesta,descListadoCgg_dhu_registro_encuesta),
        items:[grdCgg_dhu_registro_encuesta],
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:false,
        constrain:true,
		modal : true,
        layout:'border',
        bbar:['->',btnSalirCgg_dhu_registro_encuesta]
    });
//	}
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_dhu_registro_encuesta.getBottomToolbar());
   
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_registro_encuesta.
     * @returns ventana winFrmCgg_dhu_registro_encuesta.
     * @base FrmListadoCgg_dhu_registro_encuesta.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_registro_encuesta;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_registro_encuesta.
     * @base FrmListadoCgg_dhu_registro_encuesta.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_registro_encuesta.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_registro_encuesta;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_registro_encuesta;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_registro_encuesta.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_registro_encuesta.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_registro_encuesta desde una instancia.
 */
FrmListadoCgg_dhu_registro_encuesta.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_registro_encuesta desde una instancia.
 */
FrmListadoCgg_dhu_registro_encuesta.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_registro_encuesta,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_registro_encuesta.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_registro_encuesta desde una instancia.
 */
FrmListadoCgg_dhu_registro_encuesta.prototype.loadData = function(){
    this.loadData();
}
