/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_tipo_solicitud_tramite.
* @param inDesktop Escritio web de la aplicacion.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_res_tipo_solicitud_tramite(inDesktop){    
	var optMenu = 'Configuraci\u00F3n/Administraci\u00F3n de residencia/Administraci\u00F3n de tipo de solicitud tr\u00E1mite';
    var urlListadoCgg_res_tipo_solicitud_tramite=URL_WS+"Cgg_res_tipo_solicitud_tramite";
    var tituloListadoCgg_res_tipo_solicitud_tramite='Listado de tipos de solicitud tr\u00E1mite';
    var descListadoCgg_res_tipo_solicitud_tramite='El formulario permite administrar informaci\u00F3n de tipos de solicitud tr\u00E1mite';
	
    var gsCgg_kdx_especie = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_kdx_especie",
            method:"selectAll"
        }),
        reader:new Ext.data.JsonReader({
            id:'CKESP_CODIGO'
        },[
        {name:'CKESP_CODIGO'},
        {name:'CKESP_NOMBRE'},
        {name:'CKESP_PRECIO'},
        {name:'CKESP_CANTIDAD'},
        {name:'CKESP_DISPONIBLE_MIN'},
        {name:'CKESP_DISPONIBLE_MAX'},
        {name:'CKESP_TIPO'},
        {name:'CKESP_INDICE'},
        {name:'CKESP_REPORTE'}
        ]),
        baseParams:{
            format:"JSON",
            inCkesp_tipo:-1
        }
    });
    gsCgg_kdx_especie.load();
	
	/**
	 * * Ext.data.Store Coleccion de datos de los tipos de tramites.
	 */
	var SCGG_RES_TIPO_TRAMITE= new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_res_tipo_tramite",
			method:"selectAll"
		}),
		reader:new Ext.data.JsonReader({},[
			{name:'CRTPT_CODIGO'},
			{name:'CRTPT_NOMBRE'},
			{name:'CRTPT_ABREVIATURA'},
			{name:'CRTPT_INDICE'},
			{name:'CRTPT_OBSERVACIONES'}
		]),
		baseParams:{
			format:TypeFormat.JSON
		}
	});
	SCGG_RES_TIPO_TRAMITE.load();
	/**
	 * Ext.data.Store Almacenamiento de informacion de garantia para tramites.
	 */
	var SCGG_RES_GARANTIA = new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_res_garantia",
			method:"selectAll"
		}),
		remoteSort:true,
		reader:new Ext.data.JsonReader({},[
			{name:'CRGRT_CODIGO'},
			{name:'CRGRT_DESCRPCION'},
			{name:'CRGRT_VALOR'}
		]),
		baseParams:{
			format:TypeFormat.JSON
		}
	});
	SCGG_RES_GARANTIA.load();
    /**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_tipo_solicitud_tramite.
	*/
    var btnNuevoCgg_res_tipo_solicitud_tramite = new Ext.Button({
        id:'btnNuevoCgg_res_tipo_solicitud_tramite',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:'Nuevo tipo solicitud tr\u00E1mite',
        listeners:{
            click:function(){
                var objCgg_res_tipo_solicitud_tramite = new FrmCgg_res_tipo_solicitud_tramite("insertTipoSolicitudTramite");
                objCgg_res_tipo_solicitud_tramite.setEspeciesStore(gsCgg_kdx_especie);
                objCgg_res_tipo_solicitud_tramite.closeHandler(function(){
                    gsCgg_res_tipo_solicitud_tramite.reload();
                });
				objCgg_res_tipo_solicitud_tramite.setStoreGarantia(SCGG_RES_GARANTIA);
				objCgg_res_tipo_solicitud_tramite.setStoreTipoTramite(SCGG_RES_TIPO_TRAMITE);
                objCgg_res_tipo_solicitud_tramite.show();
            }
        }
    });
    /**
* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_tipo_solicitud_tramite.
*/
    var btnEditarCgg_res_tipo_solicitud_tramite = new Ext.Button({
        id:'btnEditarCgg_res_tipo_solicitud_tramite',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:'Editar tipo solicitud tra\u00E1mite',
        listeners:{
            click:function(){
                var r=grdCgg_res_tipo_solicitud_tramite.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_tipo_solicitud_tramite = new FrmCgg_res_tipo_solicitud_tramite("updateTipoSolicitudTramite",r);
                    objCgg_res_tipo_solicitud_tramite.setEspeciesStore(gsCgg_kdx_especie);
                    objCgg_res_tipo_solicitud_tramite.closeHandler(function(){
                        gsCgg_res_tipo_solicitud_tramite.reload();
                    });
					objCgg_res_tipo_solicitud_tramite.setStoreGarantia(SCGG_RES_GARANTIA);
					objCgg_res_tipo_solicitud_tramite.setStoreTipoTramite(SCGG_RES_TIPO_TRAMITE);
                    objCgg_res_tipo_solicitud_tramite.loadData();
                    objCgg_res_tipo_solicitud_tramite.show();
                }
            }
        }
    });
    /**
* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_tipo_solicitud_tramite.
*/
    var btnEliminarCgg_res_tipo_solicitud_tramite = new Ext.Button({
        id:'btnEliminarCgg_res_tipo_solicitud_tramite',
        text:'Eliminar',
        iconCls:'iconEliminar',
        tooltip:'Eliminar tipo solicitud tra\u00E1mite',
        listeners:{
            click:function(){

                var r=grdCgg_res_tipo_solicitud_tramite.getSelectionModel().getSelected();
                if(r){
                
                    function SWRCgg_res_tipo_solicitud_tramite(btn){
                        if (btn=='yes'){
                            try{
                                function CallBackCgg_res_tipo_solicitud_tramite(r){
                                    winFrmListadoCgg_res_tipo_solicitud_tramite.getEl().unmask();
                                    if(r=='true'){
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_res_tipo_solicitud_tramite,
                                            msg: 'El tipo de solicitud de tr\u00E1mite ha sido eliminado.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.INFO
                                        });
                                        gsCgg_res_tipo_solicitud_tramite.reload();
                                    }else{
                                        Ext.Msg.show({
                                            title:tituloListadoCgg_res_tipo_solicitud_tramite,
                                            msg: 'El tipo de solicitud de tr\u00E1mite no ha podido ser eliminada.',
                                            buttons: Ext.Msg.OK,
                                            icon: Ext.MessageBox.ERROR
                                        });
                                    }
                                }
                                winFrmListadoCgg_res_tipo_solicitud_tramite.getEl().mask('Eliminando...', 'x-mask-loading');
                                var param = new SOAPClientParameters();
                                param.add('inCrtst_codigo',grdCgg_res_tipo_solicitud_tramite.getSelectionModel().getSelected().get('CRTST_CODIGO'));
                                SOAPClient.invoke(urlListadoCgg_res_tipo_solicitud_tramite,"delete",param, true, CallBackCgg_res_tipo_solicitud_tramite);
                            }catch(inErr){
                                winFrmListadoCgg_res_tipo_solicitud_tramite.getEl().unmask();
                            }
                        }
                    }

                    Ext.Msg.show({
                        title:tituloListadoCgg_res_tipo_solicitud_tramite,
                        msg:'Seguro de eliminar el registro seleccionado?',
                        buttons: Ext.Msg.YESNO,
                        fn: SWRCgg_res_tipo_solicitud_tramite,
                        icon: Ext.MessageBox.QUESTION
                    });
            
                }
            }
        }
    });
    /**
* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_tipo_solicitud_tramite.
*/
    var btnSalirCgg_res_tipo_solicitud_tramite = new Ext.Button({
        id:'btnSalirCgg_res_tipo_solicitud_tramite',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:'Salir del formulario',
        listeners:{
            click:function(){
                winFrmListadoCgg_res_tipo_solicitud_tramite.close();
            }
        }
    });

    var ccCRTST_APLICA_TRAMITE = new Ext.grid.CheckColumn({
        dataIndex:'CRTST_APLICA_TRAMITE',
        header:'Genera tr\u00E1mite',
        width:150,
        sortable:true
    });

    var ccCRTST_VEHICULO=new Ext.grid.CheckColumn({
        dataIndex:'CRTST_VEHICULO',
        header:'Veh\u00EDculo',
        width:150
    });

    var ccCRTST_UNANIMIDAD=new Ext.grid.CheckColumn({
        dataIndex:'CRTST_UNANIMIDAD',
        header:'Unanimidad',
        width:150
    });

    var ccCRTST_APLICA_GARANTIA=new Ext.grid.CheckColumn({
        dataIndex:'CRTST_APLICA_GARANTIA',
        header:'Aplica garant\u00EDa',
        width:150
    });

    var ccCRTST_APLICA_GRUPO=new Ext.grid.CheckColumn({
        dataIndex:'CRTST_APLICA_GRUPO',
        header:'Tr\u00E1mite grupal',
        width:150
    });

    var ccCRTST_APLICA_OTRO=new Ext.grid.CheckColumn({
        dataIndex:'CRTST_APLICA_OTRO',
        header:'Aplica transeunte temporal',
        width:150
    });

    var ccCRTST_COMUNICADO_RADIAL=new Ext.grid.CheckColumn({
        dataIndex:'CRTST_COMUNICADO_RADIAL',
        header:'Comunicado radial',
        width:150
    });

    var ccCRTST_ATENCION_CLIENTE = new Ext.grid.CheckColumn({
        dataIndex:'CRTST_ATENCION_CLIENTE',
        header:'Atenci\u00F3n cliente',
        width:150
    });

    var ccCRTST_RESTRINGIDO = new Ext.grid.CheckColumn({
        dataIndex:'CRTST_RESTRINGIDO',
        header:'Validaci\u00F3n',
        width:150
    });
    var chkCrtst_aplica_beneficiario = new Ext.grid.CheckColumn(
    {
        dataIndex:'CRTST_APLICA_BENEFICIARIO',
        header:'Aplica beneficiario',
        width:150,
        sortable:true
    });
    /**
* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_tipo_solicitud_tramite.
*/
    var cmCgg_res_tipo_solicitud_tramite = new Ext.grid.ColumnModel({
        columns:[
        {
            dataIndex:'CRTST_CODIGO',
            header:'Codigo',
            width:150,
            sortable:true,
            hidden:true,
            hideable:false
        },
        {
            dataIndex:'CRTST_DESCRIPCION',
            header:'Descripci\u00F3n',
            width:150,
            sortable:true
        },
        {
            dataIndex:'CRTST_OBSERVACION',
            header:'Observaci\u00F3n',
            width:150,
            sortable:true
        },
        {
            dataIndex:'TST_PADRE',
            header:'Solicitud',
            width:150,
            sortable:true,
            groupable:true
        },
        {
            dataIndex:'CRTPT_NOMBRE',
            header:'Area tr\u00E1mite',
            width:150,
            sortable:true,
            groupable:true
        },
        {
            dataIndex:'CRRES_CODIGO',
            header:'Resolucion',
            hidden:true,
            hiddeable:false
        },
        ccCRTST_APLICA_TRAMITE,
        {
            dataIndex:'CRTST_NUMERO_DIAS',
            header:'N\u00FAmero d\u00EDas',
            width:150,
            sortable:true
        },
        ccCRTST_VEHICULO,
        ccCRTST_UNANIMIDAD,
        ccCRTST_APLICA_GARANTIA,
        ccCRTST_APLICA_GRUPO,
        ccCRTST_APLICA_OTRO,
        ccCRTST_COMUNICADO_RADIAL,
        ccCRTST_ATENCION_CLIENTE,
        ccCRTST_RESTRINGIDO,
        chkCrtst_aplica_beneficiario,
        {
            dataIndex:'CRTST_INDICE',
            header:'Indice',
            width:100,
            sortable:true
        },
        ],
        defaults: {
            groupable:false
        }
    });
    /**
* Ext.data.Store Agrupacion de registros de la tabla Cgg_res_tipo_solicitud_tramite por un campo especifico.
*/
    var gsCgg_res_tipo_solicitud_tramite = new Ext.data.GroupingStore({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_tipo_solicitud_tramite",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRTST_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
        {name:'CRTST_CODIGO'},
        {name:'CGG_CRTST_CODIGO'},
		{name:'TST_PADRE'},
        {name:'CRTPT_CODIGO'},
		{name:'CRTPT_NOMBRE'},
        {name:'CKESP_CODIGO'},
        {name:'CRTST_DESCRIPCION'},
        {name:'CRTST_OBSERVACION'},
        {name:'CRTST_APLICA_GARANTIA'},
        {name:'CRTST_APLICA_TRAMITE'},
        {name:'CRTST_APLICA_GRUPO'},        
        {name:'CRTST_ATENCION_CLIENTE'},
        {name:'CRTST_RESTRINGIDO'},
        {name:'CRTST_COMUNICADO_RADIAL'},
        {name:'CRTST_NUMERO_DIAS'},
        {name:'CRTST_VEHICULO'},
        {name:'CRTST_UNANIMIDAD'},
        {name:'CRPRO_CODIGO'},
        {name:'CRRES_CODIGO'},
        {name:'CRTST_APLICA_OTRO'},
        {name:'CRTST_APLICA_BENEFICIARIO'},
        {name:'CRTST_INDICE'}
        ]),
        sortInfo:{
            field: 'CGG_CRTST_CODIGO',
            direction: 'ASC'
        },
        baseParams:{
            keyword:"",
            format:"JSON",
            inCrtst_codigo:'',
            inSW:false
        },
        groupField:'TST_PADRE'
    });
    /**
* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_tipo_solicitud_tramite.
*/
    var pgBarCgg_res_tipo_solicitud_tramite= new Ext.PagingToolbar({
        store: gsCgg_res_tipo_solicitud_tramite,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_tipo_solicitud_tramite en un formato tabular de filas y columnas.
*/
    var grdCgg_res_tipo_solicitud_tramite = new Ext.grid.GridPanel({
        cm:cmCgg_res_tipo_solicitud_tramite,
        store:gsCgg_res_tipo_solicitud_tramite,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        view: new Ext.grid.GroupingView({            
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Solicitudes" : "Solicitud"]})'
        }),
        loadMask:{
            msg:"Cargando..."
        },
        tbar: [
        'Buscar: ', ' ',
        new Ext.ux.bsx.SearchField({
            store:gsCgg_res_tipo_solicitud_tramite,
            width:200
        })
        ],
        bbar:pgBarCgg_res_tipo_solicitud_tramite,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_tipo_solicitud_tramite.hidden){
                    btnEditarCgg_res_tipo_solicitud_tramite.fireEvent('click', btnEditarCgg_res_tipo_solicitud_tramite);
                }
            }
        }
    });
    /**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_tipo_solicitud_tramite.
	*/
    if(inDesktop){
		gsCgg_res_tipo_solicitud_tramite.reload({
            params:{
                start:0,
                limit:RECORD_PAGE,
                format:"JSON"
            }
        });
        var winFrmListadoCgg_res_tipo_solicitud_tramite = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_tipo_solicitud_tramite',
            title:tituloListadoCgg_res_tipo_solicitud_tramite,
            tbar:getPanelTitulo(tituloListadoCgg_res_tipo_solicitud_tramite,descListadoCgg_res_tipo_solicitud_tramite),
            items:[grdCgg_res_tipo_solicitud_tramite],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            iconCls:'iconTipoSolicitud',
            bbar:[btnNuevoCgg_res_tipo_solicitud_tramite,btnEditarCgg_res_tipo_solicitud_tramite,btnEliminarCgg_res_tipo_solicitud_tramite,'->',btnSalirCgg_res_tipo_solicitud_tramite]
        });
        /**
		* Funcion que aplica los privilegios del usuario.
		*/
        applyGrants(winFrmListadoCgg_res_tipo_solicitud_tramite.getBottomToolbar());
    }
    /**
* Funcion miembro que devuelve la ventana winFrmListadoCgg_res_tipo_solicitud_tramite.
* @returns ventana winFrmCgg_res_tipo_solicitud_tramite.
* @base FrmListadoCgg_res_tipo_solicitud_tramite.prototype.show
*/
    this.getWindow = function(){
        return winFrmListadoCgg_res_tipo_solicitud_tramite;
    }
    /**
* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_tipo_solicitud_tramite.
* @base FrmListadoCgg_res_tipo_solicitud_tramite.prototype.loadData
*/
    this.loadData = function(){
        gsCgg_res_tipo_solicitud_tramite.load();
    }
    /**
* Funcion miembro que develve el ColumnModel utilizado en el listado.
*/
    this.getColumnModel = function(){
        return cmCgg_res_tipo_solicitud_tramite;
    }
    /**
* Funcion miembro que develve el Store utilizado en el listado.
*/
    this.getStore = function(){
        return gsCgg_res_tipo_solicitud_tramite;
    }
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_res_tipo_solicitud_tramite.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_res_tipo_solicitud_tramite.prototype.getStore = function(){
    this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_tipo_solicitud_tramite desde una instancia.
*/
FrmListadoCgg_res_tipo_solicitud_tramite.prototype.show = function(){
    this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_tipo_solicitud_tramite desde una instancia.
*/
FrmListadoCgg_res_tipo_solicitud_tramite.prototype.close = function(){
    this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_tipo_solicitud_tramite,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_res_tipo_solicitud_tramite.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_tipo_solicitud_tramite desde una instancia.
*/
FrmListadoCgg_res_tipo_solicitud_tramite.prototype.loadData = function(){
    this.loadData();
}
