/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_dhu_beca.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_dhu_beca(inDesktop){
    var optMenu = 'Desarrollo Humano/Administraci\u00F3n de Beca/Registro beca';
    var urlListadoCgg_dhu_beca=URL_WS+"Cgg_dhu_beca";
    var tituloListadoCgg_dhu_beca='Beca';
    var descListadoCgg_dhu_beca='El formulario permite administrar informaci\u00f3n de beca';
   
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_dhu_beca.
     */
    var btnNuevoCgg_dhu_beca = new Ext.Button({
        id:'btnNuevoCgg_dhu_beca',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_dhu_beca = new FrmCgg_dhu_beca("insert");
                objCgg_dhu_beca.closeHandler(function(){
                    gsCgg_dhu_beca.reload();
                });
                objCgg_dhu_beca.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_dhu_beca.
     */
    var btnEditarCgg_dhu_beca = new Ext.Button({
        id:'btnEditarCgg_dhu_beca',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        listeners:{
            click:function(){
                var r=grdCgg_dhu_beca.getSelectionModel().getSelected();
                if(r){
                    var objCgg_dhu_beca = new FrmCgg_dhu_beca("update",r);
                    objCgg_dhu_beca.closeHandler(function(){
                        gsCgg_dhu_beca.reload();
                    });
                    objCgg_dhu_beca.loadData();
                    objCgg_dhu_beca.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_dhu_beca.
     */
    var btnEliminarCgg_dhu_beca = new Ext.Button({
        id:'btnEliminarCgg_dhu_beca',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'\u00BFSeguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_dhu_beca,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_dhu_beca(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_dhu_beca(r){
                            winFrmListadoCgg_dhu_beca.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_beca,
                                    msg: 'La informaci\u00f3n de  beca ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_dhu_beca.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_dhu_beca,
                                    msg: 'La informaci\u00f3n de beca no ha podido ser eliminada.<br/>'+((r.message).split(': ')[1]),
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_dhu_beca.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCdbec_codigo',grdCgg_dhu_beca.getSelectionModel().getSelected().get('CDBEC_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_dhu_beca,"delete",param, true, CallBackCgg_dhu_beca);
                    }catch(inErr){
                        winFrmListadoCgg_dhu_beca.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_dhu_beca.
     */
    var btnSalirCgg_dhu_beca = new Ext.Button({
        id:'btnSalirCgg_dhu_beca',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_dhu_beca.close();
            }}
    });
    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_dhu_beca.
     */
    var chkCdbec_titulo_entregado = new Ext.grid.CheckColumn(
    {dataIndex:'CDBEC_TITULO_ENTREGADO',header:'Titulo entregado',width:150,sortable:true});
    var chkCdbec_beca_devengada = new Ext.grid.CheckColumn(
    {dataIndex:'CDBEC_BECA_DEVENGADA',header:'Beca devengada',width:150,sortable:true});
    var cmCgg_dhu_beca = new Ext.grid.ColumnModel([
        {dataIndex:'CDBEC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDTBC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CGESP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CGIED_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CPAIS_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CGTPR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPJR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CGG_CRPER_CODIGO',header:'Crper codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CDBEC_NUMERO',header:'No. Beca',width:150,sortable:true,
				renderer:function(v,s,r){
					if(r.data.CDBEC_ESTADO_APROBACION == 0){
						return '<span style="color:green;" title = "No concluida">' + v + '</span>';
					}
					if(r.data.CDBEC_ESTADO_APROBACION == 1){
						return '<span style="color:black;" title = "Registrada">' + v + '</span>';
					}
					if(r.data.CDBEC_ESTADO_APROBACION == 2){
						return '<span style="color:red;" title = "Proceso de seguimiento">' + v + '</span>';
					}
					if(r.data.CDBEC_ESTADO_APROBACION == 3){
						return '<span style="color:blue;" title = "Concluida">' + v + '</span>';
					}
					if(r.data.CDBEC_ESTADO_APROBACION == 4){
						return '<span style="color:orange;" title = "Reprobada">' + v + '</span>';
					}else{
						return '<span style="color:Purple;" title = "Terminada caso fortuito">' + v + '</span>';
					}
				}
		},
        {dataIndex:'CRPER_NOMBRES',header:'Nombre',width:150,sortable:true},
        {dataIndex:'CRPER_APELLIDO_PATERNO',header:'Primer apellido',width:150,sortable:true},
        {dataIndex:'CRPER_APELLIDO_MATERNO',header:'Segundo apellido',width:150,sortable:true},
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'N.Identificativo',width:150,sortable:true},
        {dataIndex:'CRPER_NUMERO_RESIDENCIA',header:'Residencia',width:100,sortable:true,hidden:true},
        {dataIndex:'CRPER_LUGAR_NACIMIENTO',header:'Lugar de nacimiento',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_FECHA_NACIMIENTO',header:'Fecha Nacimiento',width:150,sortable:true,renderer:truncDate,hidden:true},
        {dataIndex:'CDBEC_NUMERO_CONVENIO',header:'No. convenio',width:150,sortable:true},
        {dataIndex:'CDBEC_NUMERO_APROBACION',header:'No.aprobaci\u00f3n',width:150,sortable:true},
        {dataIndex:'CRETF_NOMBRE',header:'Banco',width:150,sortable:true},
        {dataIndex:'CDBEC_NUMERO_CUENTO',header:'No.cuenta',width:150,sortable:true},
        {dataIndex:'CDBEC_VALOR_REEMBOLSO',header:'Reembolso',width:150,sortable:true},
        {dataIndex:'CDBEC_FECHA_INGRESO',header:'Fecha ingreso',width:150,sortable:true,renderer:truncDate,hidden:true},
        {dataIndex:'CDBEC_FUNCIONARIO',header:'Funcionario',width:150,sortable:true},
        {dataIndex:'CDBEC_FECHA_INICIO',header:'Fecha inicio',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CDBEC_FECHA_FIN',header:'Fecha fin',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CDBEC_VSALIDA_ORIGEN',header:'Vsalida origen',width:150,sortable:true,hidden:true},
        {dataIndex:'CDBEC_VSALIDA_DESTINO',header:'Vsalida destino',width:150,sortable:true,hidden:true},
        {dataIndex:'CDBEC_VSALIDA_VALOR',header:'Vsalida valor',width:150,sortable:true,hidden:true},
        {dataIndex:'CDBEC_VRETORNO_ORIGEN',header:'Vretorno origen',width:150,sortable:true,hidden:true},
        {dataIndex:'CDBEC_VRETORNO_DESTINO',header:'Vretorno destino',width:150,sortable:true,hidden:true},
        {dataIndex:'CDBEC_VRETORNO_VALOR',header:'Vretorno valor',width:150,sortable:true,hidden:true},
        {dataIndex:'CDBEC_CARRERA',header:'Carrera',width:150,sortable:true},
        {dataIndex:'CDBEC_TIPO_CICLO',header:'Tipo ciclo',width:150,sortable:true,renderer:function(inCdbecTipoCiclo){
            if(inCdbecTipoCiclo==TypeCiclo.ANUAL)
            {return('ANUAL');}
             if(inCdbecTipoCiclo==TypeCiclo.SEMESTRAL)
            {return('SEMESTRAL');}
             if(inCdbecTipoCiclo==TypeCiclo.QUIMESTRAL)
            {return('QUIMESTRAL');}
             if(inCdbecTipoCiclo==TypeCiclo.OTROS)
            {return('OTROS');}
        }},
        {dataIndex:'CDBEC_TOTAL_CICLOS',header:'Total ciclos',width:150,sortable:true},
        {dataIndex:'CDBEC_NUMERO_APROBACION_MODIFICATORIO',header:'No.Aprobaci\u00f3n mod',width:150,sortable:true},
        {dataIndex:'CDBEC_NUMERO_CONTRATO_MODIFICATORIO',header:'Contrato mod',width:150,sortable:true},
        {dataIndex:'CDBEC_OBSRERVACION_CONTRATO_MODIFICATORIO',header:'Observaci\u00f3n mod',width:150,sortable:true},
        {dataIndex:'CDBEC_OBSERVACION',header:'Observaci\u00f3n',width:150,sortable:true},
        chkCdbec_titulo_entregado,
        chkCdbec_beca_devengada,
        {dataIndex:'CDBEC_ESTADO_APROBACION',header:'Estado aprobaci\u00f3n',width:150,sortable:true,renderer:function(inCdbecEstadoBeca){
            if(inCdbecEstadoBeca==TypeBecaAprobacion.NO_CONCLUIDA)
            {return('NO CONCLUIDA');}
            if(inCdbecEstadoBeca==TypeBecaAprobacion.REGISTRADA)
            {return('REGISTRADA');}
            if(inCdbecEstadoBeca==TypeBecaAprobacion.EN_SEGUIMIENTO)
            {return('EN SEGUIMIENTO');}
            if(inCdbecEstadoBeca==TypeBecaAprobacion.CONCLUIDA)
            {return('CONCLUIDA');}
            if(inCdbecEstadoBeca==TypeBecaAprobacion.REPROBADA)
            {return('REPROBADA');}
            if(inCdbecEstadoBeca==TypeBecaAprobacion.TERMINADA_CASO_FORTUITO)
            {return('TERMINADA CASO FORTUITO');}
        }}
       ]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_dhu_beca por un campo especifico.
     */
    var gsCgg_dhu_beca = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_dhu_beca",
            method:"selectPageBeca",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CDBEC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CDBEC_CODIGO'},
            {name:'CDTBC_CODIGO'},
            {name:'CGESP_CODIGO'},
            {name:'CGIED_CODIGO'},
            {name:'CPAIS_CODIGO'},
            {name:'CGTPR_CODIGO'},
            {name:'CRPER_CODIGO'},
            {name:'CGG_CRPER_CODIGO'},
            {name:'CRPJR_CODIGO'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_APELLIDO_MATERNO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_NUMERO_RESIDENCIA'},
            {name:'CRPER_LUGAR_NACIMIENTO'},
            {name:'CRPER_FECHA_NACIMIENTO'},
            {name:'CRPJR_NOMBRE'},
            {name:'CGESP_NOMBRE'},
            {name:'CGIED_NOMBRE'},
            {name:'CGTPR_NOMBRE'},
            {name:'CGNES_DESCRIPCION'},
            {name:'CGG_CRPER_CODIGO'},
            {name:'CDBEC_NUMERO'},
            {name:'CDBEC_FECHA_INGRESO'},
            {name:'CDBEC_FUNCIONARIO'},
            {name:'CDBEC_NUMERO_APROBACION'},
            {name:'CDBEC_FECHA_INICIO'},
            {name:'CDBEC_FECHA_FIN'},
            {name:'CDBEC_NUMERO_CONVENIO'},
            {name:'CDBEC_DOC_CONVENIO'},
            {name:'CDBEC_VSALIDA_ORIGEN'},
            {name:'CDBEC_VSALIDA_DESTINO'},
            {name:'CDBEC_VSALIDA_VALOR'},
            {name:'CDBEC_VRETORNO_ORIGEN'},
            {name:'CDBEC_VRETORNO_DESTINO'},
            {name:'CDBEC_VRETORNO_VALOR'},
            {name:'CDBEC_CARRERA'},
            {name:'CDBEC_TIPO_CICLO'},
            {name:'CDBEC_TOTAL_CICLOS'},
            {name:'CDBEC_NUMERO_CUENTO'},
            {name:'CDBEC_NUMERO_APROBACION_MODIFICATORIO'},
            {name:'CDBEC_NUMERO_CONTRATO_MODIFICATORIO'},
            {name:'CDBEC_OBSRERVACION_CONTRATO_MODIFICATORIO'},
            {name:'CDBEC_OBSERVACION'},
            {name:'CDBEC_TITULO_ENTREGADO'},
            {name:'CDBEC_NOMBRE_ADJUNTO'},
            {name:'CDBEC_ADJUNTO_TITULO'},
            {name:'CDBEC_BECA_DEVENGADA'},
            {name:'CDBEC_ESTADO_APROBACION'},
            {name:'CDBEC_VALOR_REEMBOLSO'},
            {name:'CRDID_TIPO'}
        ]),
        sortInfo:{field: 'CDBEC_NUMERO', direction: 'ASC'},
        baseParams:{keyword:"",format:'JSON'}
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_dhu_beca.
     */
    var pgBarCgg_dhu_beca= new Ext.PagingToolbar({
        store: gsCgg_dhu_beca,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_dhu_beca en un formato tabular de filas y columnas.
     */
    var grdCgg_dhu_beca = new Ext.grid.GridPanel({
        cm:cmCgg_dhu_beca,
        store:gsCgg_dhu_beca,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_dhu_beca,
                width:200
            })
        ],
        bbar:pgBarCgg_dhu_beca,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_dhu_beca.hidden){
                    btnEditarCgg_dhu_beca.fireEvent('click', btnEditarCgg_dhu_beca);
                }
            }}});
    gsCgg_dhu_beca.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:'JSON'
    }
    });
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_dhu_beca.
     */
     if(inDesktop){
        var winFrmListadoCgg_dhu_beca = inDesktop.createWindow({
        id:'winFrmListadoCgg_dhu_beca',
        title:tituloListadoCgg_dhu_beca,
        width:600,
        minWidth:600,
        height:400,
        minHeight:400,
        maximizable:true,
        minimizable:true,
        constrain:true,
        layout:'border',
        tbar:getPanelTitulo('Listado '+tituloListadoCgg_dhu_beca,descListadoCgg_dhu_beca),
        items:[grdCgg_dhu_beca],
        bbar:[btnNuevoCgg_dhu_beca,btnEditarCgg_dhu_beca,btnEliminarCgg_dhu_beca,'->',btnSalirCgg_dhu_beca]
    });
    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_dhu_beca.getBottomToolbar());
     }
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_dhu_beca.
     * @returns ventana winFrmCgg_dhu_beca.
     * @base FrmListadoCgg_dhu_beca.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_dhu_beca;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_dhu_beca.
     * @base FrmListadoCgg_dhu_beca.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_dhu_beca.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_dhu_beca;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_dhu_beca;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_dhu_beca.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_dhu_beca.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_dhu_beca desde una instancia.
 */
FrmListadoCgg_dhu_beca.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_dhu_beca desde una instancia.
 */
FrmListadoCgg_dhu_beca.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_dhu_beca,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_dhu_beca.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_dhu_beca desde una instancia.
 */
FrmListadoCgg_dhu_beca.prototype.loadData = function(){
    this.loadData();
}
