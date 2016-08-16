/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_persona.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */
function FrmListadoCgg_res_persona(inDesktop){
    var optMenu = 'Administraci\u00f3n de persona/Persona';
    var urlListadoCgg_res_persona=URL_WS+"Cgg_res_persona";
    var tituloListadoCgg_res_persona='Listado persona';
    var descListadoCgg_res_persona='El formulario permite administrar informaci\u00f3n  general de persona';
	Ext.Ajax.timeout = 900000;
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_persona.
     */
    var btnNuevoCgg_res_persona = new Ext.Button({
        id:'btnNuevoCgg_res_persona',
        text:'Nuevo',
        iconCls:'iconNuevo',
        tooltip:TypeTooltip.NUEVO,
        listeners:{
            click:function(){
                var objCgg_res_persona = new FrmCgg_res_persona("insert");
                objCgg_res_persona.closeHandler(function(){
                    gsCgg_res_persona.reload();
                });
                objCgg_res_persona.show();
            }}
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_res_persona.
     */
    var btnEditarCgg_res_persona = new Ext.Button({
        id:'btnEditarCgg_res_persona',
        text:'Editar',
        iconCls:'iconEditar',
        tooltip:TypeTooltip.EDITAR,
        //disabled:true,
        listeners:{
            click:function(){
                var r=grdCgg_res_persona.getSelectionModel().getSelected();
                if(r){
                    var objCgg_res_persona = new FrmCgg_res_persona("update",r);
                    objCgg_res_persona.closeHandler(function(){
                        gsCgg_res_persona.reload();
                    });
                    objCgg_res_persona.loadData();
                    objCgg_res_persona.show();
                }
            }}
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_res_persona.
     */
    var btnEliminarCgg_res_persona = new Ext.Button({
        id:'btnEliminarCgg_res_persona',
        text:'Eliminar',
        iconCls:'iconEliminar',
        //disabled:true,
        tooltip:TypeTooltip.ELIMINAR,
        listeners:{
            click:function(){
                Ext.Msg.show({title:'Aviso', msg:'Est\u00e1 seguro de eliminar?', buttons: Ext.Msg.YESNO,fn: SWRCgg_res_persona,icon: Ext.MessageBox.QUESTION});
                function SWRCgg_res_persona(btn){if (btn=='yes'){
                    try{
                        function CallBackCgg_res_persona(r){
                            winFrmListadoCgg_res_persona.getEl().unmask();
                            if(r=='true'){
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_persona,
                                    msg: 'La informaci\u00f3n de persona ha sido eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gsCgg_res_persona.reload();
                            }else{
                                Ext.Msg.show({
                                    title:tituloListadoCgg_res_persona,
                                    msg: 'La informaci\u00f3n de persona no ha podido ser eliminada.',
                                    buttons: Ext.Msg.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }}
                        winFrmListadoCgg_res_persona.getEl().mask('Eliminando...', 'x-mask-loading');
                        var param = new SOAPClientParameters();
                        param.add('inCrper_codigo',grdCgg_res_persona.getSelectionModel().getSelected().get('CRPER_CODIGO'));
                        SOAPClient.invoke(urlListadoCgg_res_persona,"delete",param, true, CallBackCgg_res_persona);
                    }catch(inErr){
                        winFrmListadoCgg_res_persona.getEl().unmask();
                    }}}
            }}
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_persona.
     */
    var btnSalirCgg_res_persona = new Ext.Button({
        id:'btnSalirCgg_res_persona',
        text:'Salir',
        iconCls:'iconSalir',
        tooltip:TypeTooltip.SALIR,
        listeners:{
            click:function(){
                winFrmListadoCgg_res_persona.close();
                
                    /*var objCgg_res_persona = new FrmCgg_res_persona("update",'CRPER1001');
                    objCgg_res_persona.closeHandler(function(){
                        gsCgg_res_persona.reload();
                    });
                    objCgg_res_persona.loadData1();
                    objCgg_res_persona.show();*/

            }}
    });
    /**
     * Ext.Button Boton para obtener reportes, general o individual.
     */
    var btnHojaDeVidaCgg_res_persona = new Ext.Toolbar.SplitButton({
        id:'btnHojaDeVidaCgg_res_persona',
        name:'btnHojaDeVidaCgg_res_persona',
        text:'Hoja de Vida',
        disabled:true,
        iconCls:'iconHojaVida',
        //tooltip:TypeTooltip.IMPRIMIR,		
        menu:[
            /*{text:'Contactos',
                handler:function(){
                    var r=grdCgg_res_persona.getSelectionModel().getSelected();
                    var inCrper_codigo = r.get('CRPER_CODIGO');
                    var frmListadoCgg_res_persona_contacto = new FrmListadoCgg_res_persona_contacto(inDesktop,inCrper_codigo);
                    //frmListadoCgg_res_persona_contacto.loadData()
                    frmListadoCgg_res_persona_contacto.show()
                }
            },*/
			{text:'Informaci\u00F3n Laboral',
                handler:function(){
                    var r=grdCgg_res_persona.getSelectionModel().getSelected();
                    var inCrper_codigo = r.get('CRPER_CODIGO');
                    var frmCgg_gem_informacion_laboral = new FrmCgg_gem_informacion_laboral("","",inCrper_codigo);
                    frmCgg_gem_informacion_laboral.show()
                }
            },{text:'Perfil Profesional',
                handler:function(){
                    var r=grdCgg_res_persona.getSelectionModel().getSelected();
                    var inCrper_codigo = r.get('CRPER_CODIGO');
                    var frmListadoCgg_gem_perfil_prof = new FrmListadoCgg_gem_perfil_prof(inDesktop,inCrper_codigo);
                    frmListadoCgg_gem_perfil_prof.show()
                }
            },{text:'Certificados Obtenidos',
                handler:function(){
                    var r=grdCgg_res_persona.getSelectionModel().getSelected();
                    var inCrper_codigo = r.get('CRPER_CODIGO');
                    var frmListadoCgg_gem_certificado = new FrmListadoCgg_gem_certificado(inDesktop,inCrper_codigo);
                    frmListadoCgg_gem_certificado.show()
                }
            },{text:'Idiomas',
                handler:function(){
                    var r=grdCgg_res_persona.getSelectionModel().getSelected();
                    var inCrper_codigo = r.get('CRPER_CODIGO');
                    var frmListadoCgg_gem_idioma_persona = new FrmListadoCgg_gem_idioma_persona(inDesktop,inCrper_codigo);
                    frmListadoCgg_gem_idioma_persona.show()
                }
            },{text:'Experiencia Laboral',
                handler:function(){
					var r=grdCgg_res_persona.getSelectionModel().getSelected();
                    var inCrper_codigo = r.get('CRPER_CODIGO');
                    var frmListadoCgg_gem_experiencia_laboral = new FrmListadoCgg_gem_experiencia_laboral(inDesktop,inCrper_codigo);
                    frmListadoCgg_gem_experiencia_laboral.show()
                }
            },{text:'Destrezas',
                handler:function(){
					var r=grdCgg_res_persona.getSelectionModel().getSelected();
                    var inCrper_codigo = r.get('CRPER_CODIGO');
                    var frmListadoCgg_gem_destreza_persona = new FrmListadoCgg_gem_destreza_persona(inDesktop,inCrper_codigo);
                    frmListadoCgg_gem_destreza_persona.show()
                }
            }
        ],
		listeners:{
            click:function(){        
					var r=grdCgg_res_persona.getSelectionModel().getSelected();
                    var inCrper_codigo = r.get('CRPER_CODIGO');
					var objFrmCgg_gem_administracion_hoja_vida = new FrmCgg_gem_administracion_hoja_vida(inDesktop,inCrper_codigo);
					objFrmCgg_gem_administracion_hoja_vida.closeHandler(function(){
						gsCgg_res_persona.reload();
					});
					objFrmCgg_gem_administracion_hoja_vida.show();
            }
		}
    });
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_persona.
     */
    var cmCgg_res_persona = new Ext.grid.ColumnModel([
        {dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_NUM_DOC_IDENTIFIC',header:'No. documento',width:100,sortable:true},
        {dataIndex:'CRECV_CODIGO',header:'Codigo',width:150,sortable:true,hideable:false,hidden:true},
        {dataIndex:'CRDID_CODIGO',header:'Codigo',width:150,sortable:true,hideable:false,hidden:true},
        {dataIndex:'CRTSG_CODIGO',header:'Codigo',width:150,sortable:true,hideable:false,hidden:true},
        {dataIndex:'CGNCN_CODIGO',header:'Codigo',width:150,sortable:true,hideable:false,hidden:true},
        {dataIndex:'CPRR_CODIGO',header:'Codigo',width:150,sortable:true,hideable:false,hidden:true},
        {dataIndex:'CCTN_CODIGO',header:'Codigo',width:150,sortable:true,hideable:false,hidden:true},
        {dataIndex:'CGG_CCTN_CODIGO',header:'Cctn codigo',width:150,sortable:true,hideable:false,hidden:true},
        {dataIndex:'CRPER_NOMBRES',header:'Nombres',width:150,sortable:true},
        {dataIndex:'CRPER_APELLIDO_PATERNO',header:'Apellidos',width:150,sortable:true,renderer:
                function(value,obj,record){
                    return record.get('CRPER_APELLIDO_PATERNO') + ' ' + record.get('CRPER_APELLIDO_MATERNO')
                }},
        {dataIndex:'CRPER_APELLIDO_MATERNO',header:'Apellido materno',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_NUMERO_RESIDENCIA',header:'No. residencia',width:100,sortable:true},
        {dataIndex:'CRPER_FECHA_NACIMIENTO',header:'Fecha nacimiento',width:100,sortable:true,renderer:truncDate},
        {dataIndex:'CRPER_LUGAR_NACIMIENTO',header:'Lugar nacimiento',width:150,sortable:true},
        {dataIndex:'CRPER_GENERO',header:'Genero',width:150,sortable:true, renderer:
                function(value){
                    return (value==TypeGenero.MASCULINO)?'MASCULINO':'FEMENINO'
                }},
        {dataIndex:'CRPER_OBSERVACIONES',header:'Observaciones',width:150,sortable:true},
        {dataIndex:'CRPER_FOTO',header:'Foto',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_FOTO_CURRICULUM',header:'Foto curriculum',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_HUELLA_DACTILAR',header:'Huella dactilar',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_FIRMA',header:'Firma',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_AUTORIZADO',header:'Autorizado',width:150,sortable:true,xtype:'checkcolumn'},
        {dataIndex:'CRPER_NUMERO_EXPEDIENTE',header:'Numero expediente',width:150,sortable:true},
        {dataIndex:'CRPER_FECHA_ARCHIVO',header:'Fecha archivo',width:150,sortable:true,renderer:truncDate},
        {dataIndex:'CRPER_EMPLEADO',header:'Empleado',width:150,sortable:true,xtype:'checkcolumn'},
        {dataIndex:'CRPER_FECHA_ULTIMO_EMPLEO',header:'Fecha ultimo empleo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_ASPIRACION_SALARIAL',header:'Aspiracion salarial',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_CUPO_VEHICULAR',header:'Cupo vehicular',width:150,sortable:true,xtype:'checkcolumn'},
        {dataIndex:'CRPER_TIPO_PERSONA',header:'Tipo persona',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_ESTADO_INTERFECTO',header:'Estado interfecto',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_FECHA_DEFUNCION',header:'Fecha defuncion',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_NUMERO_ACTA',header:'Numero acta',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_TIPO',header:'Tipo',width:150,sortable:true,hidden:true},
        {dataIndex:'CRPER_ATENCION_CLIENTE',header:'Atencion cliente',width:150,sortable:true,xtype:'checkcolumn',hidden:true}]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_res_persona por un campo especifico.
     */
    var gsCgg_res_persona = new Ext.data.Store({
        proxy:new Ext.ux.bsx.SoapProxy({
            url:URL_WS+"Cgg_res_persona",
            method:"selectPageDirect",
            pagin:true
        }),
        remoteSort:true,
        reader:new Ext.data.JsonReader({
            id:'CRPER_CODIGO',
            root:'dataSet',
            totalProperty: 'totalCount'
        },[
            {name:'CRPER_CODIGO'},
            {name:'CRECV_CODIGO'},
            {name:'CRDID_CODIGO'},
            {name:'CRTSG_CODIGO'},
            {name:'CGNCN_CODIGO'},
            {name:'CPRR_CODIGO'},
            {name:'CCTN_CODIGO'},
            {name:'CGG_CCTN_CODIGO'},
            {name:'CRPER_NOMBRES'},
            {name:'CRPER_APELLIDO_PATERNO'},
            {name:'CRPER_APELLIDO_MATERNO'},
            {name:'CRPER_NUM_DOC_IDENTIFIC'},
            {name:'CRPER_FECHA_NACIMIENTO'},
            {name:'CRPER_LUGAR_NACIMIENTO'},
            {name:'CRPER_GENERO'},
            {name:'CRPER_OBSERVACIONES'},
            {name:'CRPER_NUMERO_RESIDENCIA'},
            {name:'CRPER_FOTO'},
            {name:'CRPER_FOTO_CURRICULUM'},
            {name:'CRPER_HUELLA_DACTILAR'},
            {name:'CRPER_FIRMA'},
            {name:'CRPER_AUTORIZADO'},
            {name:'CRPER_NUMERO_EXPEDIENTE'},
            {name:'CRPER_FECHA_ARCHIVO'},
            {name:'CRPER_EMPLEADO'},
            {name:'CRPER_FECHA_ULTIMO_EMPLEO'},
            {name:'CRPER_ASPIRACION_SALARIAL'},
            {name:'CRPER_CUPO_VEHICULAR'},
            {name:'CRPER_TIPO_PERSONA'},
            {name:'CRPER_ESTADO_INTERFECTO'},
            {name:'CRPER_FECHA_DEFUNCION'},
            {name:'CRPER_NUMERO_ACTA'},
            {name:'CRPER_NOMBRE_ADJUNTO_ACTA'}, 
            {name:'CRPER_TIPO'},
            {name:'CRPER_ATENCION_CLIENTE'}
        ]),
        sortInfo:{field: 'CRECV_CODIGO', direction: 'ASC'},
        baseParams:{keyword:"",format:"JSON"},
		listeners:{
			load:function(){
				if(!grdCgg_res_persona.getSelectionModel().hasSelection())
					btnHojaDeVidaCgg_res_persona.setDisabled(true);
			}
		}
    });    
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_persona.
     */
    var pgBarCgg_res_persona= new Ext.PagingToolbar({
        store: gsCgg_res_persona,
        displayInfo: true,
        pageSize:RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_persona en un formato tabular de filas y columnas.
     */
    var grdCgg_res_persona = new Ext.grid.GridPanel({
        cm:cmCgg_res_persona,
        store:gsCgg_res_persona,
        region:'center',
        sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
        loadMask:{msg:"Cargando..."},
        tbar: [
            'Buscar: ', ' ',
            new Ext.ux.bsx.SearchField({
                store:gsCgg_res_persona,
                width:200
            })
        ],
        bbar:pgBarCgg_res_persona,
        listeners:{
            rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
                if(!btnEditarCgg_res_persona.hidden){
                    btnEditarCgg_res_persona.fireEvent('click', btnEditarCgg_res_persona);
                }
            }
		}
	});
    gsCgg_res_persona.reload({params:{
        start:0,
        limit:RECORD_PAGE,
        format:"JSON"
    }
    });
    grdCgg_res_persona.getSelectionModel().on("selectionchange",function(valor){
		var estado=valor.hasSelection();
		btnHojaDeVidaCgg_res_persona.setDisabled(!estado);
		//btnHojaDeVidaCgg_res_persona.setDisabled(false);
	/*	var sw_cgper=sm_cgper.hasSelection();
        btnEditarCgg_res_persona.setDisabled(!sm_cgper);
		btnEliminarCgg_res_persona.setDisabled(!sm_cgper);
		btnHojaDeVidaCgg_res_persona.setDisabled(!sm_cgper)*/
	});

    //AC==>
    var btnAdjuntos = new Ext.ux.form.AlfrescoFM({
        id:'compAdjunto',   //(opcional)
        name:'compAdjunto', //(opcional)
        text: 'Adjuntos',    //(opcional -> Texto del botón)
        tableName: 'Cgg_res_persona',
        validateRecordID:true
    });

    btnAdjuntos.addListener("updateData",function(t){
        t.recordID = null;
        var rPersona = grdCgg_res_persona.getSelectionModel().getSelected();
        t.recordID = rPersona.get('CRPER_CODIGO');
        t.filter = null;
        rTramite=null;
    });

    //<== AC


    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_persona.
     */
    var winFrmListadoCgg_res_persona = null;

    if(inDesktop!==null && inDesktop!==undefined){
        winFrmListadoCgg_res_persona  = inDesktop.createWindow({
            id:'winFrmListadoCgg_res_persona',
            title:tituloListadoCgg_res_persona,
            tbar:getPanelTitulo(tituloListadoCgg_res_persona,descListadoCgg_res_persona),
            items:[grdCgg_res_persona],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_persona,btnEditarCgg_res_persona,btnEliminarCgg_res_persona,'-',btnHojaDeVidaCgg_res_persona,'-',btnAdjuntos,'->',btnSalirCgg_res_persona]
        });
    }
    else
    {
        winFrmListadoCgg_res_persona = new Ext.Window({
            id:'winFrmListadoCgg_res_persona',
            title:tituloListadoCgg_res_persona,
            tbar:getPanelTitulo(tituloListadoCgg_res_persona,descListadoCgg_res_persona),
            items:[grdCgg_res_persona],
            width:600,
            minWidth:600,
            height:400,
            minHeight:400,
            maximizable:true,
            minimizable:true,
            constrain:true,
            layout:'border',
            bbar:[btnNuevoCgg_res_persona,btnEditarCgg_res_persona,btnEliminarCgg_res_persona,'-',btnHojaDeVidaCgg_res_persona,'-',btnAdjuntos,'->',btnSalirCgg_res_persona]
        });
    }

    /**
     * Funcion que aplica los privilegios del usuario.
     */
    applyGrants(winFrmListadoCgg_res_persona.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_res_persona.
     * @returns ventana winFrmCgg_res_persona.
     * @base FrmListadoCgg_res_persona.prototype.show
     */
    this.getWindow = function(){
        return winFrmListadoCgg_res_persona;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_persona.
     * @base FrmListadoCgg_res_persona.prototype.loadData
     */
    this.loadData = function(){
        gsCgg_res_persona.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function(){
        return cmCgg_res_persona;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function(){
        return gsCgg_res_persona;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_res_persona.prototype.getColumnModel = function(){
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_res_persona.prototype.getStore = function(){
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_persona desde una instancia.
 */
FrmListadoCgg_res_persona.prototype.show = function(){
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_persona desde una instancia.
 */
FrmListadoCgg_res_persona.prototype.close = function(){
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_persona,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_res_persona.prototype.closeHandler = function(inFunctionHandler){
    this.getWindow().on('close',inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_persona desde una instancia.
 */
FrmListadoCgg_res_persona.prototype.loadData = function(){
    this.loadData();
}
