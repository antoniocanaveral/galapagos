/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_perfil_prof.
* @constructor 
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_gem_perfil_prof(inDesktop,IN_CRPER_CODIGO,IN_ADMINISTRACION,IN_BUSQUEDA_PERFIL){	
	var urlListadoCgg_gem_perfil_prof=URL_WS+"Cgg_gem_perfil_prof";
	var tituloListadoCgg_gem_perfil_prof='Perfil profesional';
	var descListadoCgg_gem_perfil_prof='El formulario permite administrar informaci\u00f3n sobre el perfil profesional de la persona para su correspondiente hoja de vida';
	var inCrper_codigo = IN_CRPER_CODIGO;
	var urlListadoCgg_gem_perfil_adjunto=URL_WS+"Cgg_gem_perfil_adjunto";
	
	function rndNivelAprobado(v){
		switch(v){
			case 0:v= "Finalizado";break;			
			default: v= v + " Niveles"
        }
		return v;
	}
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_perfil_prof.
	*/
	var btnNuevoCgg_gem_perfil_prof = new Ext.Button({
			id:'btnNuevoCgg_gem_perfil_prof',
			text:'Nuevo',
			iconCls:'iconNuevo',
			listeners:{
				click:function(){
					var objCgg_gem_perfil_prof = new FrmCgg_gem_perfil_prof("insert","","",inCrper_codigo);
					objCgg_gem_perfil_prof.closeHandler(function(){
							gsCgg_gem_perfil_prof.reload();
					});
					objCgg_gem_perfil_prof.show();
			}}
	});
	/**
	* Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_perfil_prof.
	*/
	var btnEditarCgg_gem_perfil_prof = new Ext.Button({
			id:'btnEditarCgg_gem_perfil_prof',
			text:'Editar',
			iconCls:'iconEditar',
			disabled:true,
			listeners:{
				click:function(){
					var r=grdCgg_gem_perfil_prof.getSelectionModel().getSelected();
					if(r){
						var objCgg_gem_perfil_prof = new FrmCgg_gem_perfil_prof("update",r,"",inCrper_codigo);
						objCgg_gem_perfil_prof.closeHandler(function(){
								gsCgg_gem_perfil_prof.reload();
						});
						objCgg_gem_perfil_prof.loadData();
						objCgg_gem_perfil_prof.show();
					}
			}}
	});
	/**
	* Ext.Button Boton que permite eliminar un registro de la ventana winFrmListadoCgg_gem_perfil_prof.
	*/
	var btnEliminarCgg_gem_perfil_prof = new Ext.Button({
			id:'btnEliminarCgg_gem_perfil_prof',
			text:'Eliminar',
			iconCls:'iconEliminar',
			disabled:true,
			listeners:{
				click:function(){
					Ext.Msg.show({title:'Aviso', msg:'¿Seguro de eliminar el registro seleccionado?', buttons: Ext.Msg.YESNO,fn: SWRCgg_gem_perfil_prof,icon: Ext.MessageBox.QUESTION});
					function SWRCgg_gem_perfil_prof(btn){if (btn=='yes'){
						try{
							function CallBackCgg_gem_perfil_prof(r){
								pnlListadoCgg_gem_perfil_prof_persona.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_gem_perfil_prof,
											msg: 'La informaci\u00f3n de Gem perfil prof ha sido eliminada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_gem_perfil_prof.reload();
									btnEliminarCgg_gem_perfil_prof.setDisabled(true);
									btnEditarCgg_gem_perfil_prof.setDisabled(true);
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_gem_perfil_prof,
											msg: 'La informaci\u00f3n de Gem perfil prof no ha podido ser eliminada.'+(r.message?r.message:r),
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
							}}
							pnlListadoCgg_gem_perfil_prof_persona.getEl().mask('Eliminando...', 'x-mask-loading');
							var param = new SOAPClientParameters();
							param.add('inCgppr_codigo',grdCgg_gem_perfil_prof.getSelectionModel().getSelected().get('CGPPR_CODIGO'));
							SOAPClient.invoke(urlListadoCgg_gem_perfil_prof,"delete",param, true, CallBackCgg_gem_perfil_prof);
						}catch(inErr){
							pnlListadoCgg_gem_perfil_prof_persona.getEl().unmask();
					}}}
			}}
	});
	
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_perfil_prof.
	*/
	var btnSalirCgg_gem_perfil_prof = new Ext.Button({
			id:'btnSalirCgg_gem_perfil_prof',
			text:'Salir',
			iconCls:'iconSalir',
			//hidden:IN_ADMINISTRACION?true:false,
			listeners:{
				click:function(){
					if(IN_ADMINISTRACION)
						Ext.getCmp('btnSalirCgg_gem_administracion_hoja_vida').fireEvent('click');
					else
						winFrmListadoCgg_gem_perfil_prof.close();
			}}
	});	
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_perfil_prof.
	*/
	var chkCgppr_confirmado = new Ext.grid.CheckColumn(
		{dataIndex:'CGPPR_CONFIRMADO',header:'Confirmado',width:150,sortable:true,hidden:true});
	var chkCgppr_predeterminado = new Ext.grid.CheckColumn(
		{dataIndex:'CGPPR_PREDETERMINADO',header:'Predeterminado',width:150,sortable:true});
	var cmCgg_gem_perfil_prof = new Ext.grid.ColumnModel([
			{dataIndex:'CGPPR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CGESP_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CGTPR_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CGMDC_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CRPER_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CGIEN_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},	
			{dataIndex:'CGNES_DESCRIPCION',header:'Nivel de estudio',width:150,sortable:true},			
			{dataIndex:'CGIED_NOMBRE',header:'Instituci\u00F3n',width:150,sortable:true},
			{dataIndex:'CGTPR_DESCRIPCION',header:'Titulo Profesional',width:150,sortable:true},
			{dataIndex:'CGESP_NOMBRE',header:'Especialidad',width:150,sortable:true},
			{dataIndex:'CGMDC_DESCRIPCION',header:'Modalidad',width:150,sortable:true},
			{dataIndex:'CGPPR_NIVEL_APROBADO',header:'Nivel aprobado',width:150,sortable:true, renderer:rndNivelAprobado},		
			{dataIndex:'CGPPR_FECHA_INICIO',header:'Fecha inicio',width:150,sortable:true},
			{dataIndex:'CGPPR_FECHA_FIN',header:'Fecha fin',width:150,sortable:true},
			chkCgppr_confirmado,
			{dataIndex:'CGPPR_FECHA_CONFIRMACION',header:'Fecha confirmacion',width:150,sortable:true,renderer:truncDate,hidden:true},
			{dataIndex:'CGNES_CODIGO',header:'Codigo Nivel de Estudio',width:150,sortable:true,hidden: true},			
			chkCgppr_predeterminado
		]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_perfil_prof por un campo especifico.
	*/
	var gsCgg_gem_perfil_prof = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_gem_perfil_prof",
					method:"selectPagePerfilProfesional",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CGPPR_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CGPPR_CODIGO'},
				{name:'CGESP_CODIGO'},
				{name:'CGTPR_CODIGO'},
				{name:'CGMDC_CODIGO'},
				{name:'CRPER_CODIGO'},
				{name:'CGIEN_CODIGO'},
				{name:'CGPPR_NIVEL_APROBADO'},
				{name:'CGPPR_FECHA_INICIO'},
				{name:'CGPPR_FECHA_FIN'},
				{name:'CGPPR_CONFIRMADO'},
				{name:'CGPPR_FECHA_CONFIRMACION'},
				{name:'CGPPR_PREDETERMINADO'},
				{name:'CGIED_NOMBRE'},
				{name:'CGTPR_DESCRIPCION'},
				{name:'CGESP_NOMBRE'},
				{name:'CGMDC_DESCRIPCION'},
				{name:'CRPER_NOMBRES'},
				{name:'CRPER_APELLIDO_PATERNO'},
				{name:'CRPER_APELLIDO_MATERNO'},
				{name:'CGNES_CODIGO'},
				{name:'CGNES_DESCRIPCION'}
			]),
			sortInfo:{field: 'CGESP_CODIGO', direction: 'ASC'},
			baseParams:{keyword:"",format:'JSON',inCrper_codigo:inCrper_codigo}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_gem_perfil_prof.
	*/
	var pgBarCgg_gem_perfil_prof= new Ext.PagingToolbar({
			store: gsCgg_gem_perfil_prof,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_perfil_prof en un formato tabular de filas y columnas.
	*/
	var grdCgg_gem_perfil_prof = new Ext.grid.GridPanel({
			cm:cmCgg_gem_perfil_prof,
			store:gsCgg_gem_perfil_prof,
			height:220,        
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_gem_perfil_prof,
						width:200
				})
			],
			//bbar:pgBarCgg_gem_perfil_prof,
			listeners:{
				rowdblclick:function(inGridComponent, inRowIndex, inEventObject){
					if(!btnEditarCgg_gem_perfil_prof.hidden){
						btnEditarCgg_gem_perfil_prof.fireEvent('click', btnEditarCgg_gem_perfil_prof);
					}
				},
				cellclick:function(grid, rowIndex, columnIndex, e) {					
						var record = grid.getStore().getAt(rowIndex);  // Get the Record
						var fieldName = grid.getColumnModel().getDataIndex(columnIndex); // Get field name
						var data = record.get(fieldName);
						/*gsCgg_gem_perfil_adjunto.reload({
							params:{
								inCgppr_codigo: record.get('CGPPR_CODIGO')
							}
						});*/
						//HABILITAR EL BOTONES
						btnAnadirAdjunto.setDisabled(false);					
						btnEliminarAdjunto.setDisabled(true);
						
						btnEditarCgg_gem_perfil_prof.setDisabled(false);
						btnEliminarCgg_gem_perfil_prof.setDisabled(false);					
				}
			}
	});
	gsCgg_gem_perfil_prof.reload({params:{
			start:0,
			limit:100,
			format:'JSON'
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
			baseParams:{format:'JSON',inCgpfa_tipo:0,inCrper_codigo:inCrper_codigo}				
	});
	gsCgg_gem_perfil_adjunto.reload();
	
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
					var objCgg_gem_perfil_adjunto = new FrmCgg_gem_perfil_adjunto("insert","",inCrper_codigo,0);					
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
	var pnlListadoCgg_gem_perfil_prof_persona = new Ext.form.FormPanel({
		id:"pnlListadoCgg_gem_perfil_prof_persona",
		items:[grdCgg_gem_perfil_prof,pnlCgg_gem_perfil_adjunto],
		region:'center',
		layout: 'border',
		bbar:[btnNuevoCgg_gem_perfil_prof,btnEditarCgg_gem_perfil_prof,btnEliminarCgg_gem_perfil_prof,'->',btnSalirCgg_gem_perfil_prof]
	});
	
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_gem_perfil_prof.
	*/
	if (inDesktop){
		var winFrmListadoCgg_gem_perfil_prof = inDesktop.createWindow({
				id:'winFrmListadoCgg_gem_perfil_prof',
				title:tituloListadoCgg_gem_perfil_prof,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:500,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrainHeader:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_gem_perfil_prof,descListadoCgg_gem_perfil_prof),
				items:[pnlListadoCgg_gem_perfil_prof_persona]				
		});
	}else{
		var winFrmListadoCgg_gem_perfil_prof = new Ext.Window({
				id:'winFrmListadoCgg_gem_perfil_prof',
				title:tituloListadoCgg_gem_perfil_prof,
				iconCls:'iconAplicacion',
				width:600,
				minWidth:600,
				height:500,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrainHeader:true,
				layout:'border',
				tbar:getPanelTitulo('Listado '+tituloListadoCgg_gem_perfil_prof,descListadoCgg_gem_perfil_prof),
				items:[pnlListadoCgg_gem_perfil_prof_persona]				
		});
	}
	/**
	* Funcion que aplica los privilegios del usuario.
	*/
	applyGrants(pnlListadoCgg_gem_perfil_prof_persona.getBottomToolbar());
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_perfil_prof.
	* @returns ventana winFrmCgg_gem_perfil_prof.
	* @base FrmListadoCgg_gem_perfil_prof.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_gem_perfil_prof;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_gem_perfil_prof.
	* @base FrmListadoCgg_gem_perfil_prof.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_gem_perfil_prof.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_gem_perfil_prof;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_gem_perfil_prof;
	}
	/**
	* Funcion miembro que develve el panel del listado de perfl profesional de la persona.
	*/
	this.getPanel = function(){
		return pnlListadoCgg_gem_perfil_prof_persona;
	}
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_gem_perfil_prof.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_gem_perfil_prof.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_perfil_prof desde una instancia.
*/
FrmListadoCgg_gem_perfil_prof.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_perfil_prof desde una instancia.
*/
FrmListadoCgg_gem_perfil_prof.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_perfil_prof,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_gem_perfil_prof.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_gem_perfil_prof desde una instancia.
*/
FrmListadoCgg_gem_perfil_prof.prototype.loadData = function(){
	this.loadData();
}
/**
* Funcion prototipo. Permite obtener el panel del listado de perfil profesional de la persona
*/
FrmListadoCgg_gem_perfil_prof.prototype.getPanel = function(){
	this.getPanel();
}
