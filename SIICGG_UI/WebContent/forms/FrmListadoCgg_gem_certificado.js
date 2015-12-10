/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_certificado.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */

function FrmListadoCgg_gem_certificado(inDesktop,inCrper_codigo,IN_ADMINISTRACION,IN_BUSQUEDA_PERFIL) {    
    var urlListadoCgg_gem_certificado = URL_WS + "Cgg_gem_certificado";
    var tituloListadoCgg_gem_certificado = 'Certificados';
    var descListadoCgg_gem_certificado = 'El formulario permite administrar informaci\u00f3n sobre los certificado que tiene la persona';
	
	function rndDuracionHoras(v){
		return v + " horas";
	}
	function rndTipoCertificado(v){
		switch(v){
			case 0:v="Curso de capacitaci\u00F3n";break;
			case 1:v="Seminario";break;
			case 2:v="Cartificafi\u00F3nes laborales o acad\u00E9micas";break;
        }
		return v;
	}
    /**
     * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_certificado.
     */
    var btnNuevoCgg_gem_certificado = new Ext.Button({
        id: 'btnNuevoCgg_gem_certificado',
        text: 'Nuevo',
        iconCls: 'iconNuevo',
        listeners: {
            click: function () {
                var objCgg_gem_certificado = new FrmCgg_gem_certificado("insert","",inCrper_codigo);
                objCgg_gem_certificado.closeHandler(function () {
                    gsCgg_gem_certificado.reload();
                });
                objCgg_gem_certificado.show();
            }
        }
    });
    /**
     * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_certificado.
     */
    var btnEditarCgg_gem_certificado = new Ext.Button({
        id: 'btnEditarCgg_gem_certificado',
        text: 'Editar',
        iconCls: 'iconEditar',
        listeners: {
            click: function () {
                var r = grdCgg_gem_certificado.getSelectionModel().getSelected();
                if (r) {
                    var objCgg_gem_certificado = new FrmCgg_gem_certificado("update", r,inCrper_codigo);
                    objCgg_gem_certificado.closeHandler(function () {
                        gsCgg_gem_certificado.reload();
                    });
                    objCgg_gem_certificado.loadData();
                    objCgg_gem_certificado.show();
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_gem_certificado.
     */
    var btnEliminarCgg_gem_certificado = new Ext.Button({
        id: 'btnEliminarCgg_gem_certificado',
        text: 'Eliminar',
        iconCls: 'iconEliminar',
        listeners: {
            click: function () {
                Ext.Msg.show({
                    title: 'Aviso',
                    msg: '¿Seguro de eliminar el registro seleccionado?',
                    buttons: Ext.Msg.YESNO,
                    fn: SWRCgg_gem_certificado,
                    icon: Ext.MessageBox.QUESTION
                });

                function SWRCgg_gem_certificado(btn) {
                    if (btn == 'yes') {
                        try {
                            function CallBackCgg_gem_certificado(r) {
                                pnlListadoCgg_gem_certificado.getEl().unmask();
                                if (r == 'true') {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_gem_certificado,
                                        msg: 'La informaci\u00f3n sobre el certificado ha sido eliminada.',
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.INFO
                                    });
                                    gsCgg_gem_certificado.reload();
                                } else {
                                    Ext.Msg.show({
                                        title: tituloListadoCgg_gem_certificado,
                                        msg: 'La informaci\u00f3n sobre el certificado no ha podido ser eliminada.' + (r.message ? r.message : r),
                                        buttons: Ext.Msg.OK,
                                        icon: Ext.MessageBox.ERROR
                                    });
                                }
                            }
                            pnlListadoCgg_gem_certificado.getEl().mask('Eliminando...', 'x-mask-loading');
                            var param = new SOAPClientParameters();
                            param.add('inCgcer_codigo', grdCgg_gem_certificado.getSelectionModel().getSelected().get('CGCER_CODIGO'));
                            SOAPClient.invoke(urlListadoCgg_gem_certificado, "delete", param, true, CallBackCgg_gem_certificado);
                        } catch (inErr) {
                            pnlListadoCgg_gem_certificado.getEl().unmask();
                        }
                    }
                }
            }
        }
    });
    /**
     * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_certificado.
     */
    var btnSalirCgg_gem_certificado = new Ext.Button({
        id: 'btnSalirCgg_gem_certificado',
        text: 'Salir',
        iconCls: 'iconSalir',		
        listeners: {
            click: function () {
				if(IN_ADMINISTRACION)
					Ext.getCmp('btnSalirCgg_gem_administracion_hoja_vida').fireEvent('click');
				else
					winFrmListadoCgg_gem_certificado.close();
            }
        }
    });    
    /**
     * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_certificado.
     */
    var cmCgg_gem_certificado = new Ext.grid.ColumnModel([{
			dataIndex: 'CGCER_CODIGO',
			header: 'Codigo',
			width: 150,
			sortable: true,
			hidden:true
		},
		{
			dataIndex: 'CRPER_CODIGO',
			header: 'Codigo',
			width: 150,
			sortable: true,
			hidden:true
		},		
		{
			dataIndex: 'CGCER_TIPO',
			header: 'Tipo',
			width: 150,
			sortable: true,
			renderer:rndTipoCertificado
		},
		{
			dataIndex: 'CGCER_INSTITUCION',
			header: 'Institucion',
			width: 150,
			sortable: true
		},
		{
			dataIndex: 'CGCER_NOMBRE',
			header: 'Nombre',
			width: 150,
			sortable: true
		},
		{
			dataIndex: 'CGCER_DESCRIPCION',
			header: 'Descripcion',
			width: 150,
			sortable: true
		},
		{
			dataIndex: 'CGCER_DURACION',
			header: 'Duracion',
			width: 150,
			sortable: true,
			renderer: rndDuracionHoras
		},
		{
			dataIndex: 'CGCER_FECHA_INICIO',
			header: 'Fecha inicio',
			width: 150,
			sortable: true,
			renderer:truncDate
		},
		{
			dataIndex: 'CGCER_FECHA_FIN',
			header: 'Fecha fin',
			width: 150,
			sortable: true,
			renderer:truncDate
		},
		{
			dataIndex: 'CGCER_TIPO_ADJUNTO',
			header: 'Tipo adjunto',
			width: 150,
			sortable: true,
			hidden:true
		},
		{
			dataIndex: 'CGCER_NOMBRE_ADJUNTO',
			header: 'Nombre adjunto',
			width: 150,
			sortable: true,
			hidden:true
		},
		{
			dataIndex: 'CGCER_OBSERVACION',
			header: 'Observacion',
			width: 150,
			sortable: true
		},
		{xtype: 'actioncolumn',
				width: 80,
				header:'Adjunto',
				items: [{
					iconCls: 'iconBuscar',                // Use a URL in the icon config
					tooltip: 'Ver adjunto',
					handler: function(grid, rowIndex, colIndex) {
						grdCgg_gem_certificado.getSelectionModel().selectRow(rowIndex);
						var rAdjuntoPerfil = grdCgg_gem_certificado.getSelectionModel().getSelected();
						if(rAdjuntoPerfil){
							var objCrate_data = rAdjuntoPerfil.get('CGCER_CODIGO');
							if(objCrate_data){
								var url1 = URL_DOC_VIEWER+'?table=cgg_gem_certificado&keyc=cgcer_codigo&keyv='+objCrate_data +'&column=cgcer_adjunto&fn='+rAdjuntoPerfil.get('CGCER_NOMBRE_ADJUNTO')+'&request=view';
								//alert(url1);
								window.open(url1);
							}
							
						}
					}
				}]
		}
	]);
    /**
     * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_certificado por un campo especifico.
     */
    var gsCgg_gem_certificado = new Ext.data.Store({
        proxy: new Ext.ux.bsx.SoapProxy({
            url: URL_WS + "Cgg_gem_certificado",
            method: "selectPageCertificadosPersona",
            pagin: true
        }),
        remoteSort: true,
        reader: new Ext.data.JsonReader({
            id: 'CGCER_CODIGO',
            root: 'dataSet',
            totalProperty: 'totalCount'
        }, [{
            name: 'CGCER_CODIGO'
        },
        {
            name: 'CRPER_CODIGO'
        },
        {
            name: 'CGCER_INSTITUCION'
        },
        {
            name: 'CGCER_NOMBRE'
        },
        {
            name: 'CGCER_DESCRIPCION'
        },
        {
            name: 'CGCER_DURACION'
        },
        {
            name: 'CGCER_FECHA_INICIO'
        },
        {
            name: 'CGCER_FECHA_FIN'
        },
        {
            name: 'CGCER_TIPO_ADJUNTO'
        },
        {
            name: 'CGCER_NOMBRE_ADJUNTO'
        },        
        {
            name: 'CGCER_OBSERVACION'
        },
        {
            name: 'CGCER_TIPO'
        }]),
        sortInfo: {
            field: 'CRPER_CODIGO',
            direction: 'ASC'
        },
        baseParams: {
            keyword: "",
            format: 'JSON',
            inCrper_codigo: inCrper_codigo
        }
    });
    /**
     * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_gem_certificado.
     */
    var pgBarCgg_gem_certificado = new Ext.PagingToolbar({
        store: gsCgg_gem_certificado,
        displayInfo: true,
        pageSize: RECORD_PAGE,
        displayMsg: 'Mostrando {0} - {1} de {2}',
        temptyMsg: 'No hay informaci\u00f3n para mostrar'
    });
    /**
     * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_certificado en un formato tabular de filas y columnas.
     */
    var grdCgg_gem_certificado = new Ext.grid.GridPanel({
        cm: cmCgg_gem_certificado,
        store: gsCgg_gem_certificado,
        region: 'center',
        sm: new Ext.grid.RowSelectionModel({
            singleSelect: true
        }),
        loadMask: {
            msg: "Cargando..."
        },
        tbar: ['Buscar: ', new Ext.ux.bsx.SearchField({
            store: gsCgg_gem_certificado,
            width: 200
        })],
        bbar: pgBarCgg_gem_certificado,
        listeners: {
            rowdblclick: function (inGridComponent, inRowIndex, inEventObject) {
                if (!btnEditarCgg_gem_certificado.disabled) {
                    btnEditarCgg_gem_certificado.fireEvent('click', btnEditarCgg_gem_certificado);
                }
            }
        }
    });
    gsCgg_gem_certificado.reload({
        params: {
            start: 0,
            limit: RECORD_PAGE,
            format: 'JSON'
        }
    });
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_perfil_adjunto.
	*/
	var cmCgg_gem_perfil_adjunto = new Ext.grid.ColumnModel([
			{dataIndex:'CGPFA_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CGPPR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CGPFA_DESCRIPCION',header:'Descripcion',width:150,sortable:true},
			{dataIndex:'CGPFA_NOMBRE_ADJUNTO',header:'Nombre adjunto',width:150,sortable:true,hidden:true},
			{dataIndex:'CGPFA_TIPO_ADJUNTO',header:'Tipo adjunto',width:150,sortable:true,hidden:true},			
			{xtype: 'actioncolumn',
				width: 80,
				header:'Adjunto',
				items: [{
					iconCls: 'iconBuscar',                // Use a URL in the icon config
					tooltip: 'Ver adjunto',
					handler: function(grid, rowIndex, colIndex) {
						grdCgg_gem_perfil_adjunto.getSelectionModel().selectRow(rowIndex);
						var rAdjuntoPerfil = grdCgg_gem_perfil_adjunto.getSelectionModel().getSelected();
						if(rAdjuntoPerfil){
							var objCrate_data = rAdjuntoPerfil.get('CGPFA_CODIGO');
							if(objCrate_data){
								var url1 = URL_DOC_VIEWER+'?table=cgg_gem_perfil_adjunto&keyc=cgpfa_codigo&keyv='+objCrate_data +'&column=cgpfa_adjunto&fn='+rAdjuntoPerfil.get('CGPFA_NOMBRE_ADJUNTO')+'&request=view';
								//alert(url1);
								window.open(url1);
							}
							
						}
					}
				}]
			}
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_perfil_adjunto por un campo especifico.
	*/
	var gsCgg_gem_perfil_adjunto = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_gem_perfil_adjunto",
					method:"selectAdjuntosByIdPersona"
			}),
			reader:new Ext.data.JsonReader({
			},[
				{name:'CGPFA_CODIGO'},
				{name:'CGPPR_CODIGO'},
				{name:'CGPFA_DESCRIPCION'},
				{name:'CGPFA_NOMBRE_ADJUNTO'},
				{name:'CGPFA_TIPO_ADJUNTO'}
			]),
			sortInfo:{field: 'CGPFA_CODIGO', direction: 'ASC'},
			baseParams:{format:'JSON',inCgpfa_tipo:1,inCrper_codigo:inCrper_codigo}				
	});
	
	/**
	* Ext.grid.GridPanel Representacion de los adjuntos que puede tener un perfil profesional
	*/
	var grdCgg_gem_perfil_adjunto = new Ext.grid.GridPanel({
			cm:cmCgg_gem_perfil_adjunto,
			store:gsCgg_gem_perfil_adjunto,					
			//region:'center',
			anchor:'100% 100%',
			viewConfig:{forceFit:true},
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},			
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					/*if(!btnEditarCgg_gem_perfil_prof.disabled){
						btnEditarCgg_gem_perfil_prof.fireEvent('click', btnEditarCgg_gem_perfil_prof);
					}*/
					var r=grdCgg_gem_perfil_adjunto.getSelectionModel().getSelected();
					if(r){
						var objCgg_gem_perfil_adjunto = new FrmCgg_gem_perfil_adjunto("update",r);
						objCgg_gem_perfil_adjunto.closeHandler(function(){
								gsCgg_gem_perfil_adjunto.reload();
						});
						objCgg_gem_perfil_adjunto.loadData();
						objCgg_gem_perfil_adjunto.show();
					}
				},
				cellclick:function(grid, rowIndex, columnIndex, e) {
					btnEliminarAdjunto.setDisabled(false);
				}
			}
	});
	
	/**
	* Boton que permite crear un nuevo adjunto al perfil profesional
	*/
	var btnAnadirAdjunto = new Ext.Button({
			id:'btnAnadirAdjunto',
			text:'A\u00F1adir',
			iconCls:'iconNuevo',
			tooltip:'Agregar adjunto',
			//disabled:true,			
			listeners:{
				click:function(){
					/*var r=grdCgg_gem_perfil_prof.getSelectionModel().getSelected();
                    var codigoPerfil = r.get('CGPPR_CODIGO');*/
					var objCgg_gem_perfil_adjunto = new FrmCgg_gem_perfil_adjunto("insert","",inCrper_codigo,1);					
					objCgg_gem_perfil_adjunto.closeHandler(function(){
						gsCgg_gem_perfil_adjunto.reload();
						btnEliminarAdjunto.setDisabled(true);
					});
					objCgg_gem_perfil_adjunto.show();
				}
			}
	});
	/**
	* Boton que permite eliminar un nuevo adjunto al perfil profesional
	*/
	var btnEliminarAdjunto = new Ext.Button({
			id:'btnEliminarAdjunto',
			text:'Eliminar',
			iconCls:'iconEliminar',
			tooltip:'Eliminar adjunto',
			disabled:true,			
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_gem_perfil_adjunto,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_gem_perfil_adjunto(btn){
						if (btn=='yes'){
							try{
								function CallBackCgg_gem_perfil_adjunto(r){
									pnlListadoCgg_gem_perfil_prof_persona.getEl().unmask();
									if(r=='true'){
										Ext.Msg.show({
												title:'Adjuntos',
												msg: 'El adjunto ha sido eliminada.',
												buttons: Ext.Msg.OK,
												icon: Ext.MessageBox.INFO
										});
										gsCgg_gem_perfil_adjunto.reload();
										btnEliminarAdjunto.setDisabled(true);
									}else{
										Ext.Msg.show({
												title:'Adjuntos',
												msg: 'El adjunto no ha podido ser eliminado.'+(r.message?r.message:r),
												buttons: Ext.Msg.OK,
												icon: Ext.MessageBox.ERROR
										});
								}}
								pnlListadoCgg_gem_perfil_prof_persona.getEl().mask('Eliminando...', 'x-mask-loading');
								var param = new SOAPClientParameters();
								param.add('inCgpfa_codigo',grdCgg_gem_perfil_adjunto.getSelectionModel().getSelected().get('CGPFA_CODIGO'));
								SOAPClient.invoke(urlListadoCgg_gem_perfil_adjunto,"delete",param, true, CallBackCgg_gem_perfil_adjunto);
							}catch(inErr){
								pnlListadoCgg_gem_perfil_prof_persona.getEl().unmask();
							}
						}
					}
				}
			}
	});
	/**
    * new Ext.Panel Panel que contiene el template para visualizar la informacion sobre los Niveles de Educacion de la Institucion
    */
	var pnlCgg_gem_perfil_adjunto = new Ext.Panel({
		labelWidth:100,        
        layout:'form',
		region:'south',
		title:'Adjuntos',
        frame:false,
        height:150,
		collapsible:true,
		split: true,
		tbar:[btnAnadirAdjunto,btnEliminarAdjunto],
		items:[grdCgg_gem_perfil_adjunto]
	});
	var pnlListadoCgg_gem_certificado = new Ext.form.FormPanel({
		id:"pnlListadoCgg_gem_certificado",
		items:[grdCgg_gem_certificado,pnlCgg_gem_perfil_adjunto],
		region:'center',
		layout: 'border',
		bbar: [btnNuevoCgg_gem_certificado, btnEditarCgg_gem_certificado, btnEliminarCgg_gem_certificado, '->', btnSalirCgg_gem_certificado]
	});
    /**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gem_certificado.
     */
	 if(!IN_ADMINISTRACION){
		if(inDesktop){
			var winFrmListadoCgg_gem_certificado = inDesktop.createWindow({
				id: 'winFrmListadoCgg_gem_certificado',
				title: tituloListadoCgg_gem_certificado,
				iconCls: 'iconAplicacion',
				width: 600,
				minWidth: 600,
				height: 400,
				minHeight: 400,
				maximizable: true,
				minimizable: true,
				constrainHeader: true,
				layout: 'border',
				tbar: getPanelTitulo('Listado ' + tituloListadoCgg_gem_certificado, descListadoCgg_gem_certificado),
				items: [pnlListadoCgg_gem_certificado]
				
			});
		}else{
			var winFrmListadoCgg_gem_certificado = new Ext.Window({
				id: 'winFrmListadoCgg_gem_certificado',
				title: tituloListadoCgg_gem_certificado,
				iconCls: 'iconAplicacion',
				width: 600,
				minWidth: 600,
				height: 400,
				minHeight: 400,
				maximizable: true,
				minimizable: true,
				constrainHeader: true,
				layout: 'border',
				tbar: getPanelTitulo('Listado ' + tituloListadoCgg_gem_certificado, descListadoCgg_gem_certificado),
				items: [pnlListadoCgg_gem_certificado]
				
			});

		}
	}
    /**
     * Funcion que aplica los privilegios del usuario.
     */
//    applyGrants(pnlListadoCgg_gem_certificado.getBottomToolbar());
    /**
     * Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_certificado.
     * @returns ventana winFrmCgg_gem_certificado.
     * @base FrmListadoCgg_gem_certificado.prototype.show
     */
    this.getWindow = function () {
        return winFrmListadoCgg_gem_certificado;
    }
    /**
     * Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gem_certificado.
     * @base FrmListadoCgg_gem_certificado.prototype.loadData
     */
    this.loadData = function () {
        gsCgg_gem_certificado.load();
    }
    /**
     * Funcion miembro que develve el ColumnModel utilizado en el listado.
     */
    this.getColumnModel = function () {
        return cmCgg_gem_certificado;
    }
    /**
     * Funcion miembro que develve el Store utilizado en el listado.
     */
    this.getStore = function () {
        return gsCgg_gem_certificado;
    }
	/**
	* Funcion miembro que develve el panel del listado de certificados de la persona.
	*/
	this.getPanel = function () {
        return pnlListadoCgg_gem_certificado;
    }
}
/**
 * Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
 */
FrmListadoCgg_gem_certificado.prototype.getColumnModel = function () {
    this.getColumnModel();
}
/**
 * Funcion prototipo. Devuelve el Store utilizado en el formulario.
 */
FrmListadoCgg_gem_certificado.prototype.getStore = function () {
    this.getStore();
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_certificado desde una instancia.
 */
FrmListadoCgg_gem_certificado.prototype.show = function () {
    this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_certificado desde una instancia.
 */
FrmListadoCgg_gem_certificado.prototype.close = function () {
    this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_certificado,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_gem_certificado.prototype.closeHandler = function (inFunctionHandler) {
    this.getWindow().on('close', inFunctionHandler);
}
/**
 * Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gem_certificado desde una instancia.
 */
FrmListadoCgg_gem_certificado.prototype.loadData = function () {
    this.loadData();
}
/**
* Funcion prototipo. Permite obtener el panel del listado de certificados de la persona
*/
FrmListadoCgg_gem_certificado.prototype.getPanel = function () {
    this.getPanel();
}