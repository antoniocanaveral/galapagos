/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_persona_contacto.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_persona_contacto(inDesktop,IN_CRPER_CODIGO,IN_ADMINISTRACION,IN_BUSQUEDA_PERFIL){
    var urlListadoCgg_res_persona_contacto=URL_WS+"Cgg_res_persona_contacto";
    var tituloListadoCgg_res_persona_contacto='Listado Res persona contacto';
    var descListadoCgg_res_persona_contacto='El formulario permite administrar informaci\u00f3n de la tabla Res persona contacto';
    //var in_Crper_codigo = "CRPER1033";
    var RECORD_PAGE=30;
	var inCrper_codigo=IN_CRPER_CODIGO;
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_persona_contacto.
     */
    var btnNuevoCgg_res_persona_contacto = new Ext.Button({
        id:'btnNuevoCgg_res_persona_contacto',
        text:'Nuevo',
        iconCls:'iconNuevo',
        listeners:{
            click:function(){
                var objCgg_res_persona_contacto = new FrmCgg_res_persona_contacto("insert","",inCrper_codigo);
                objCgg_res_persona_contacto.closeHandler(function(){
                    gsCgg_res_persona_contacto.reload();                    
                });
                objCgg_res_persona_contacto.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_persona_contacto.
     */
    var btnEditarCgg_res_persona_contacto = new Ext.Button({
        id:'btnEditarCgg_res_persona_contacto',
        text:'Editar',
        iconCls:'iconEditar',
		disabled:true,
        listeners:{
            click:function(){
                var r=grdCgg_res_persona_contacto.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_persona_contacto = new FrmCgg_res_persona_contacto("update",r);
                    objCgg_res_persona_contacto.closeHandler(function(){
                        gsCgg_res_persona_contacto.reload();
                    });
                    objCgg_res_persona_contacto.loadData();
                    objCgg_res_persona_contacto.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_persona_contacto.
     */
    var btnEliminarCgg_res_persona_contacto = new Ext.Button({
        id:'btnEliminarCgg_res_persona_contacto',
        text:'Eliminar',
        iconCls:'iconEliminar',
		disabled:true,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_persona_contacto,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_persona_contacto(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_persona_contacto(r){
                            pnlListadoCgg_res_persona_contacto.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_persona_contacto,
                                    msg: 'La informaci\u00f3n de Res persona contacto ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_persona_contacto.reload();
								btnEditarCgg_res_persona_contacto.setDisabled(true);
								btnEliminarCgg_res_persona_contacto.setDisabled(true);
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_persona_contacto,
                                    msg: 'La informaci\u00f3n de Cgg_res_persona_contacto no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        pnlListadoCgg_res_persona_contacto.getEl().mask('Eliminando...', 'x-mask-loading');						
                        var param = new SOAPClientParameters();
                        param.add('inCrprc_codigo',grdCgg_res_persona_contacto.getSelectionModel().getSelected().get('CRPRC_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_persona_contacto,"delete",param, true, CallBackCgg_res_persona_contacto);
                    }catch(inErr){
                        pnlListadoCgg_res_persona_contacto.getEl().unmask();
                    }}
					}
            }}
    });
    
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_persona_contacto.
     */
    var btnSalirCgg_res_persona_contacto = new Ext.Button({
        id:'btnSalirCgg_res_persona_contacto',
        text:'Salir',
        iconCls:'iconSalir',
		//hidden:IN_ADMINISTRACION?true:false,
        listeners:{
            click:function(){
				if(IN_ADMINISTRACION)
					Ext.getCmp('btnSalirCgg_gem_administracion_hoja_vida').fireEvent('click');
				else
					winFrmListadoCgg_res_persona_contacto.close();
            }}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_persona_contacto.
     */
    var cmCgg_res_persona_contacto = new Ext.grid.ColumnModel([
        {dataIndex:'CRTCO_NOMBRE',header:'Nombre',width:150,sortable:true},        
        {dataIndex:'CRPRC_CONTACTO',header:'Contacto',width:150,sortable:true}]);
	
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona_contacto por un campo especifico.
	*/
	var gsCgg_res_persona_contacto = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_res_persona_contacto",
					method:"selectPageContactosPersona",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
            id:'CRPRC_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRPRC_CODIGO'},
            {name:'CRPER_CODIGO'},
            {name:'CRTCO_CODIGO'},
            {name:'CRTCO_NOMBRE'},
            {name:'CRPRC_DESCRIPCION'},
            {name:'CRPRC_CONTACTO'}
        ]),
			sortInfo:{field: 'CRPER_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:"JSON",inCrper_codigo:inCrper_codigo}
	});
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_persona_contacto.
     */
    var pgBarCgg_res_persona_contacto= new Ext.PagingToolbar({
        store: gsCgg_res_persona_contacto,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_persona_contacto en un formato tabular de filas y columnas.
     */
    var grdCgg_res_persona_contacto = new Ext.grid.GridPanel({
        cm:cmCgg_res_persona_contacto,
        store:gsCgg_res_persona_contacto,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_persona_contacto,
                width:200
            })
        ],
        bbar:pgBarCgg_res_persona_contacto,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_persona_contacto.hidden){
                    btnEditarCgg_res_persona_contacto.fireEvent('click', btnEditarCgg_res_persona_contacto);
                }
            },
			cellclick:function(grid, rowIndex, columnIndex, e){
				btnEditarCgg_res_persona_contacto.setDisabled(false);
				btnEliminarCgg_res_persona_contacto.setDisabled(false);
			}
		}
	});
	gsCgg_res_persona_contacto.reload({params:{
			start:0,
			limit:RECORD_PAGE,
			format:"JSON"
		}
	});	
	var pnlListadoCgg_res_persona_contacto = new Ext.form.FormPanel({
		id:"pnlListadoCgg_res_persona_contacto",
		items:[grdCgg_res_persona_contacto],
		region:'center',
		layout: 'border',
		bbar:[btnNuevoCgg_res_persona_contacto,btnEditarCgg_res_persona_contacto,btnEliminarCgg_res_persona_contacto,'->',btnSalirCgg_res_persona_contacto]
	});
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_persona_contacto.
     */
	if (inDesktop){	 
		var winFrmListadoCgg_res_persona_contacto = inDesktop.createWindow({
			id:'winFrmListadoCgg_res_persona_contacto',
			title:tituloListadoCgg_res_persona_contacto,
			tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_persona_contacto,descListadoCgg_res_persona_contacto),
			items:[pnlListadoCgg_res_persona_contacto],
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			layout:'border'        
		});
	}else{
		var winFrmListadoCgg_res_persona_contacto = new Ext.Window({
			id:'winFrmListadoCgg_res_persona_contacto',
			title:tituloListadoCgg_res_persona_contacto,
			tbar:getPanelTitulo('Listado '+tituloListadoCgg_res_persona_contacto,descListadoCgg_res_persona_contacto),
			items:[pnlListadoCgg_res_persona_contacto],
			width:600,
			minWidth:600,
			height:400,
			minHeight:400,
			maximizable:true,
			minimizable:true,
			constrain:true,
			layout:'border'        
		});
	}
    /**
     * Funcion que aplica los privilegios del usuario.
     */
//    applyGrants(pnlListadoCgg_res_persona_contacto.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_persona_contacto.
     * @returns ventana winFrmCgg_res_persona_contacto.
     * @base FrmListadoCgg_res_persona_contacto.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_persona_contacto;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_persona_contacto.
     * @base FrmListadoCgg_res_persona_contacto.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_persona_contacto.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_persona_contacto;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_persona_contacto;
    }
	/**
	* Funcion miembro que develve el panel del listado de contactos de la persona.
	*/
	this.getPanel = function(){			
		return pnlListadoCgg_res_persona_contacto;
	}
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_persona_contacto.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_persona_contacto.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_persona_contacto desde una instancia.
 */
FrmListadoCgg_res_persona_contacto.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_persona_contacto desde una instancia.
 */
FrmListadoCgg_res_persona_contacto.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_persona_contacto,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_persona_contacto.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_persona_contacto desde una instancia.
 */
FrmListadoCgg_res_persona_contacto.prototype.loadData = function(){
    this.loadData();
}
/**
* Funcion prototipo. Permite obtener el panel del listado de las contactos de la persona
*/
FrmListadoCgg_res_persona_contacto.prototype.getPanel = function(){
	this.getPanel();
}
