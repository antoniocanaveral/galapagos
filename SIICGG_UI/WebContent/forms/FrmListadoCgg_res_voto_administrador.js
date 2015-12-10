/**
* Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_res_voto.
* @constructor
* @author Besixplus Cia. Ltda.
*/
function FrmListadoCgg_res_voto_administrador(inDesktop){
	var optMenu = 'Comite/Registro de votos';
	var urlListadoCgg_res_voto=URL_WS+"Cgg_res_voto";
	var tituloListadoCgg_res_voto='Registro de votos';
	var descListadoCgg_res_voto='El formulario permite hacer un registro de los votos que no se registraron durante la sesi\u00f3n.';
	var tmpUsuario=new UserSession();
	var tmpResoluciones;
	var tmpMiembro;
	var tmpCrssc_codigo;
	var tmpCrres_codigo;
	var tmpDatosJson;
	var tmpPorTipo;
	var tmpColumnEdit  = new Array();
	var pnlSesion = new Ext.Panel({
			tbar:[{type:'button',text:'Sesi\u00f3n ',id:'btnSesion',iconCls:'iconBuscar',handler:function(){
					var tmpSesion = new Cgg_res_sesion_comite();
					var objBusqueda = new DlgBusqueda(tmpSesion.getStore(), tmpSesion.getColumnModel());
					objBusqueda.closeHandler(function () {
							tmpSesion = objBusqueda.getSelectedRow();
							if (tmpSesion) {
								document.getElementById('divInfoSesion').innerHTML =tmpInfoSesion.apply(tmpSesion.json);
								tmpCrssc_codigo = tmpSesion.get('CRSSC_CODIGO');
								btnVotoCgg_res_voto_administrador.enable();
								
								gsCgg_res_resolucion_votacion.baseParams.inCrssc_codigo=tmpCrssc_codigo;
								gsCgg_res_resolucion_votacion.reload({params:{
										start:0,
										limit:RECORD_PAGE
								}});
								gsCgg_res_resolucion_votacion1.baseParams.inCrssc_codigo = tmpCrssc_codigo;
								gsCgg_res_resolucion_votacion1.reload();
							}
					});
					objBusqueda.show();
			}}],
			frame:true,
			height:110,
			region:'north',
			html:'<div id="divInfoSesion" style="padding:0px 0px 0px 0px;"></div>'
	});
	var tmpInfoSesion = new Ext.XTemplate(
		'<table width="100%" height="100%" cellpadding="0">' +
		'<tr rowspan="0"><td>' +
		'<div class="tituloTemplate">Numero.</div></td>' +
		'<td><div class="itemTemplate">{CRSSC_NUMERO_SESION}</div></td>' +
		'<td><div class="tituloTemplate"> Isla:</div></td>' +
		'<td><div class="itemTemplate">{ISLA}</div></td></tr>' +
		'<tr rowspan="0">' +
		'<td><div class="tituloTemplate">Comit\u00e9:</div></td>' +
		'<td><div class="itemTemplate">{COMITE}</div></td>' +
		'<td><div class="tituloTemplate"> Fecha Reuni\u00f3n:</div></td>' +
		'<td><div class="itemTemplate">{[this.myDate(values.CRSSC_FECHA_REUNION)]}</div>' +
		'</td></tr></table>',
		{
			// XTemplate configuration:
			disableFormats: true,
			// member functions:
			myDate: function(CRSSC_FECHA_REUNION){
				return truncDate(CRSSC_FECHA_REUNION);
			}
		}
		);
	
	/**
	* Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_res_voto_administrador.
	*/
	var btnVotoCgg_res_voto_administrador = new Ext.Button({
			id:'btnVotoCgg_res_voto_administrador',
			text:'Voto',
			iconCls:'iconNuevo',
			disabled :true,
			listeners:{
				click:function(){
					if (gsCgg_res_votacion_miembro1.getTotalCount()!=0 && tblOrdenar1.getActiveTab() == pnlPorMiembro || 
						gsCgg_res_resolucion_votacion.getTotalCount() !=0 && tblOrdenar1.getActiveTab() == pnlPorTramite){
						try{
							function CallBackCgg_res_voto(r){
								winFrmListadoCgg_res_voto_administrador.getEl().unmask();
								if(r=='true'){
									Ext.Msg.show({
											title:tituloListadoCgg_res_voto,
											msg: 'La informaci\u00f3n del Voto ha sido almacenada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.INFO
									});
									gsCgg_res_resolucion_votacion1.reload();
									gsCgg_res_votacion_miembro1.reload();
									gsCgg_res_resolucion_votacion.reload();
									gsCgg_res_votacion_miembro.reload();
								}else{
									Ext.Msg.show({
											title:tituloListadoCgg_res_voto,
											msg: 'La informaci\u00f3n del Voto no ha podido ser almacenada.',
											buttons: Ext.Msg.OK,
											icon: Ext.MessageBox.ERROR
									});
									gsCgg_res_resolucion_votacion1.reload();
									gsCgg_res_votacion_miembro1.reload();
									gsCgg_res_resolucion_votacion.reload();
									gsCgg_res_votacion_miembro.reload();
								}
							}
							winFrmListadoCgg_res_voto_administrador.getEl().mask('Guardando...', 'x-mask-loading');
							if (tblOrdenar1.getActiveTab()==pnlPorTramite){
								setValoresRadio();
								var tmpMiembros = grdCgg_res_votacion_miembro.getStore().getJsonData();
								var tmpResolVotos = grdCgg_res_resolucion.getStore().getJsonData();
								var param = new SOAPClientParameters();
								param.add('inMiembros',tmpMiembros);
								param.add('inResolVotos',tmpResolVotos);
								param.add('inPorTipo',1);
							}else{
								var tmpRecord = grdCgg_res_resolucion1.getSelectionModel().getSelected(); 
								if(!tmpRecord){
									Ext.Msg.alert(tituloListadoCgg_res_voto, 'Seleccione un tramite antes de continuar.');
									winFrmListadoCgg_res_voto_administrador.getEl().unmask();
									return;
								}
								setValoresRadio1();
								var param = new SOAPClientParameters();
								param.add('inMiembros',grdCgg_res_votacion_miembro1.getStore().getJsonData());
								param.add('inResolVotos',createJSONObject(grdCgg_res_resolucion1.getSelectionModel().getSelections()));
								param.add('inPorTipo',2);
							}
							SOAPClient.invoke(URL_WS+"Cgg_res_voto","insertAdmin",param, true, CallBackCgg_res_voto);
						}catch(inErr){
							winFrmListadoCgg_res_voto_administrador.getEl().unmask();
						}
						
					}else{
						Ext.MessageBox.alert(tituloListadoCgg_res_voto, 'La informacion no puede ser almacenada, por falta de datos adicionales');
					}
				}
			}
			
	});
	var btnPosponerCgg_res_voto_administrador = new Ext.Button({
			id:'btnPosponerCgg_res_voto_administrador',
			iconCls:'iconPendiente',
			text:'Dejar pendiente',
			disabled:true,
			listeners:{
				click:function(){
					function CallBackDeleteTmpResol(inResponse){
						if(inResponse == 'true'){
							Ext.Msg.show({
								title:tituloListadoCgg_res_voto,
								msg: 'El tr\u00e1mite seleccionado ha quedado pendiente para la siguiente sesi\u00f3n.',
								buttons: Ext.Msg.OK,
								icon: Ext.MessageBox.INFO
							});
							winFrmListadoCgg_res_voto_administrador.getEl().unmask();
						}else{
							Ext.Msg.show({
								title:tituloListadoCgg_res_voto,
								msg: 'El tr\u00e1mite seleccionado no ha quedado pendiente para la siguiente sesi\u00f3n. '+(inResponse.message?inResponse.message:inResponse),
								buttons: Ext.Msg.OK,
								icon: Ext.MessageBox.ERROR
							});
							winFrmListadoCgg_res_voto_administrador.getEl().unmask();
						}
						gsCgg_res_resolucion_votacion.baseParams.inCrssc_codigo=tmpCrssc_codigo;
						gsCgg_res_resolucion_votacion.reload();
						gsCgg_res_resolucion_votacion1.baseParams.inCrssc_codigo = tmpCrssc_codigo;
						gsCgg_res_resolucion_votacion1.reload();
					}
					winFrmListadoCgg_res_voto_administrador.getEl().mask('Guardando...', 'x-mask-loading');
					var param = new SOAPClientParameters();
					param.add('inCrres_codigo', tmpCrres_codigo);
					SOAPClient.invoke(URL_WS+"Cgg_res_resolucion","deleteTmpResolucion",param, true, CallBackDeleteTmpResol);
				}
			}
	});
	/**
	* Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_res_voto_administrador.
	*/
	var btnVotoSalirCgg_res_voto_administrador = new Ext.Button({
			id:'btnVotoSalirCgg_res_voto_administrador',
			text:'Salir',
			iconCls:'iconSalir',
			listeners:{
				click:function(){
					winFrmListadoCgg_res_voto_administrador.close();
			}}
	});
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	function rndRadioAprobado(v,f,r){
		if (swRadio) return;
		var x = r.get('CRRES_CODIGO');
		return '<span><input type="radio" name="'+x+'" id="'+x+'_1" checked/></span>';
	}
	function rndRadioNegado(v,f,r){
		if (swRadio) return;
		var x = r.get('CRRES_CODIGO');
		return '<span><input type="radio" name="'+x+'" id="'+x+'_2" /></span>';
	}
	function rndRadioAbstencion(v,f,r){
		if (swRadio) return;
		var x = r.get('CRRES_CODIGO');
		return '<span><input type="radio" name="'+x+'" id="'+x+'_3" /></span>';
	}
	var swRadio=false;
	function setValoresRadio()
	{
		swRadio=true;
		for (k=0;k<gsCgg_res_resolucion_votacion.getCount();k++){
			var rb0=null;var rb1=null;var rb2=null;
			var rt = gsCgg_res_resolucion_votacion.getAt(k);
			rb0 = document.getElementById(rt.get("CRRES_CODIGO")+"_1");
			rb1 = document.getElementById(rt.get("CRRES_CODIGO")+"_2");
			rb2 = document.getElementById(rt.get("CRRES_CODIGO")+"_3");
			if (rb0.checked == true)
				rt.set("TOT_VOTOS","0");
			else if (rb1.checked == true)
				rt.set("TOT_VOTOS","1");
			else if (rb2.checked == true)
				rt.set("TOT_VOTOS","2");
		}
		swRadio=false;
	}
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_resolucion y la seleccion de las resoluciones de esperando votacion.
	*/
	var cmCgg_res_resolucion_votacion = new Ext.grid.ColumnModel([
			{dataIndex:'NUMERO',header:'Tr\u00e1mite',width:150,sortable:true},
			{dataIndex:'BENEFICIARIO',header:'Beneficiario',width:250,sortable:true},
			{dataIndex:'CRRES_TIPO',header:'Tipo',width:80,sortable:true,renderer:function(inCrres_Tipo){
				return dsTipoResolucion[inCrres_Tipo][1];
			}},
			{header:'Aprobado',width:70,sortable:true,renderer:rndRadioAprobado,align:'center'},
			{header:'Negado',width:70,sortable:true,renderer:rndRadioNegado,align:'center'},
			{header:'Abstenci\u00f3n',width:70,sortable:true,renderer:rndRadioAbstencion,align:'center'}
			
			
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_res_resolucion por un campo especifico.
	*/
	var gsCgg_res_resolucion_votacion = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_res_resolucion",
					method:"selectVotoAdmin",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CRRES_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CRRES_CODIGO'},
				{name:'CRTRA_CODIGO'},
				{name:'NUMERO'},
				{name:'CRSSC_CODIGO'},
				{name:'BENEFICIARIO'},
				{name:'CRRES_NUMERO_RESOLUCION'},
				{name:'CRRES_TIPO'},
				{name:'TOTAL'},
				{name:'NUMERO_VOTO'},
				{name:'RESOL_VOTO'},
				{name:'TOT_VOTOS'}
			]),
			sortInfo:{field: 'CRRES_CODIGO', direction: 'ASC'},
			baseParams:{inCrssc_codigo:'',keyword:"",format:"JSON"},
			listeners:{
				
				load :function(inObjeto){
					gsCgg_res_votacion_miembro.reload({params:{
							inCrssc_codigo:tmpCrssc_codigo,
							format:"JSON"
					}});
					
				}
			}
			
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_voto.
	*/
	var pgBarCgg_res_resolucion= new Ext.PagingToolbar({
			store: gsCgg_res_resolucion_votacion,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_voto en un formato tabular de filas y columnas.
	*/
	var grdCgg_res_resolucion = new Ext.grid.EditorGridPanel({
			cm:cmCgg_res_resolucion_votacion,
			store:gsCgg_res_resolucion_votacion,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ', ' ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_res_resolucion_votacion,
						width:200
				})
			],
			bbar:pgBarCgg_res_resolucion
	});
	
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas los miemmbros de la sesion
	*/
	var cmCgg_res_votacion_miembro = new Ext.grid.ColumnModel([
			{dataIndex:'CRSMB_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CRPER_NOMBRES',header:'Nombre',width:100,sortable:true},
			{dataIndex:'CRPER_APELLIDO_PATERNO',header:'Apellido',width:100,sortable:true}
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_res_resolucion por un campo especifico.
	*/
	var gsCgg_res_votacion_miembro = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_res_resolucion",
					method:"selectMiembroSesion",
					pagin:false
			}),
			remoteSort:false,
			reader:new Ext.data.JsonReader({
					id:'CRMBC_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CRSMB_CODIGO'},
				{name:'CRPER_NOMBRES'},
				{name:'CRPER_APELLIDO_PATERNO'}
			]),
			baseParams:{inCrssc_codigo:'',format:"JSON"}
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_voto en un formato tabular de filas y columnas.
	*/
	var grdCgg_res_votacion_miembro = new Ext.grid.GridPanel({
			title: 'Miembro',
			region: 'west',
			split: true,
			width: 210,
			collapsible: true,
			cm: cmCgg_res_votacion_miembro,
			store:gsCgg_res_votacion_miembro,
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."}
	});
	grdCgg_res_votacion_miembro.getSelectionModel().lock();
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_res_resolucion y la seleccion de las resoluciones de esperando votacion.
	*/
	var cmCgg_res_resolucion_votacion1 = new Ext.grid.ColumnModel([
			{dataIndex:'NUMERO',header:'Tr\u00e1mite',width:150,sortable:true},
			{dataIndex:'CRRES_TIPO',header:'Tipo',width:80,sortable:true,renderer:function(inCrres_Tipo){
				return dsTipoResolucion[inCrres_Tipo][1];
			}},
			{dataIndex:'BENEFICIARIO',header:'Beneficiario',width:250,sortable:true}
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_res_resolucion por un campo especifico.
	*/
	var gsCgg_res_resolucion_votacion1 = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_res_resolucion",
					method:"selectVotoAdmin1",
					pagin:false
			}),
			remoteSort:false,
			reader:new Ext.data.JsonReader({
					id:'CRRES_CODIGO',
					root:'dataSet'
			},[
				{name:'CRRES_CODIGO'},
				{name:'CRTRA_CODIGO'},
				{name:'NUMERO'},
				{name:'CRSSC_CODIGO'},
				{name:'BENEFICIARIO'},
				{name:'CRRES_NUMERO_RESOLUCION'},
				{name:'CRRES_TIPO'},
				{name:'TOTAL'},
				{name:'NUMERO_VOTO'},
				{name:'RESOL_VOTO'}
			]),
			baseParams:{inCrssc_codigo:'',format:"JSON"}
	});
	
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_voto en un formato tabular de filas y columnas.
	*/
	var grdCgg_res_resolucion1 = new Ext.grid.GridPanel( {
			title: 'Tramite ',
			region:'west',
			collapsible:true,
			split: true,
			width:210,
			cm:cmCgg_res_resolucion_votacion1,
			store:gsCgg_res_resolucion_votacion1,
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			loadMask:{msg:"Cargando..."}
	});
	grdCgg_res_resolucion1.getSelectionModel().on("selectionchange",function(inSelectionModel){
			var tmpRecord = grdCgg_res_resolucion1.getSelectionModel().getSelected();
			if(tmpRecord){
				gsCgg_res_votacion_miembro1.baseParams.inCrssc_codigo = tmpCrssc_codigo;
				gsCgg_res_votacion_miembro1.baseParams.inCrres_codigo = tmpRecord.data.CRRES_CODIGO;
				gsCgg_res_votacion_miembro1.reload({params:{
						start:0,
						limit:RECORD_PAGE
				}});
			}
	});
	
	function rndRadioAprobado1(v,f,r){
		if (swRadio1) return;
		var x = r.get('CRSMB_CODIGO');
		return '<span><input type="radio" name="x_'+x+'" id="'+x+'_01" checked/></span>';
	}
	function rndRadioNegado1(v,f,r){
		if (swRadio1) return;
		var x = r.get('CRSMB_CODIGO');
		return '<span><input type="radio" name="x_'+x+'" id="'+x+'_02" /></span>';
	}
	function rndRadioAbstencion1(v,f,r){
		if (swRadio1) return;
		var x = r.get('CRSMB_CODIGO');
		return '<span><input type="radio" name="x_'+x+'" id="'+x+'_03" /></span>';
	}
	var swRadio1=false;
	function setValoresRadio1()
	{
		swRadio1=true;
		for (k=0;k<gsCgg_res_votacion_miembro1.getTotalCount();k++){
			var rbm0=null;var rbm1=null;var rbm2=null;
			var rt1 = gsCgg_res_votacion_miembro1.getAt(k);
			rbm0 = document.getElementById(rt1.get("CRSMB_CODIGO")+"_01");
			rbm1 = document.getElementById(rt1.get("CRSMB_CODIGO")+"_02");
			rbm2= document.getElementById(rt1.get("CRSMB_CODIGO")+"_03");
			if (rbm0.checked == true)
				rt1.set("TOT_VOTOS","0");
			else if (rbm1.checked == true)
				rt1.set("TOT_VOTOS","1");
			else if (rbm2.checked == true)
				rt1.set("TOT_VOTOS","2");
		}
		swRadio1=false;
	}
	/**
	* Ext.grid.ColumnModel Define el modelo de columnas los miemmbros de la sesion
	*/
	var cmCgg_res_votacion_miembro1 = new Ext.grid.ColumnModel([
			{dataIndex:'CRSMB_CODIGO',header:'Codigo',width:150,sortable:true,hidden:true},
			{dataIndex:'CRPER_NOMBRES',header:'Nombre',width:100,sortable:true},
			{dataIndex:'CRPER_APELLIDO_PATERNO',header:'Apellido',width:100,sortable:true},
			{dataIndex:'TOT_VOTOS',header:'VOTO',width:80,sortable:true,align:'center',hidden:true},
			{header:'Aprobado',width:80,sortable:true,renderer:rndRadioAprobado1,align:'center'},
			{header:'Negado',width:80,sortable:true,renderer:rndRadioNegado1,align:'center'},
			{header:'Abstenci\u00f3n',width:80,sortable:true,renderer:rndRadioAbstencion1,align:'center'}
	]);
	/**
	* Ext.data.Store Agrupacion de registros de la tabla Cgg_res_resolucion por un campo especifico.
	*/
	var gsCgg_res_votacion_miembro1 = new Ext.data.Store({
			proxy:new Ext.ux.bsx.SoapProxy({
					url:URL_WS+"Cgg_res_resolucion",
					method:"selectMiembroSesion1",
					pagin:true
			}),
			remoteSort:true,
			reader:new Ext.data.JsonReader({
					id:'CRMBC_CODIGO',
					root:'dataSet',
					totalProperty: 'totalCount'
			},[
				{name:'CRSMB_CODIGO'},
				{name:'CRPER_NOMBRES'},
				{name:'CRPER_APELLIDO_PATERNO'},
				{name:'TOT_VOTOS'}
			]),
			sortInfo:{field: 'CRSMB_CODIGO', direction: 'ASC'},
			baseParams:{
				inCrssc_codigo:'',
				keyword:'',
				format:'JSON',
				inCrres_codigo:''
			}
	});
	/**
	* Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_res_voto.
	*/
	var pgBarCgg_res_miembro_comite1= new Ext.PagingToolbar({
			store: gsCgg_res_votacion_miembro1,
			displayInfo: true,
			pageSize:RECORD_PAGE,
			displayMsg: 'Mostrando {0} - {1} de {2}',
			temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	* Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_res_voto en un formato tabular de filas y columnas.
	*/
	var grdCgg_res_votacion_miembro1 = new Ext.grid.EditorGridPanel({
			cm: cmCgg_res_votacion_miembro1,
			store:gsCgg_res_votacion_miembro1,
			region:'center',
			sm:new Ext.grid.RowSelectionModel({singleSelect:true}),
			viewConfig:{forceFit:true},
			loadMask:{msg:"Cargando..."},
			tbar: [
				'Buscar: ', ' ',
				new Ext.ux.bsx.SearchField({
						store:gsCgg_res_votacion_miembro1,
						width:200
				})
			],
			bbar:pgBarCgg_res_miembro_comite1
	});
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	* Ext.form.Panel panel para la direccion de winFrmCgg_res_miembro_comite.
	*/
	var pnlPorTramite= new Ext.Panel({
			id:'pnlPorTramite',
			frame:true,
			labelWidth :100,
			layout:'border',
			title:'Por unanimidad',
			items:[grdCgg_res_votacion_miembro,grdCgg_res_resolucion]
	});
	var pnlPorMiembro = new Ext.Panel({
			id:'pnlPorMiembro',
			frame:true,
			labelWidth :100,
			layout:'border',
			title:'Por tr\u00e1mite',
			items:[grdCgg_res_resolucion1,grdCgg_res_votacion_miembro1]
			
	});
	var tblOrdenar1 = new Ext.TabPanel({
			activeTab:0,
			frame:true,
			region:'center',
			height:280,
			items:[pnlPorTramite,pnlPorMiembro]
	});
	
	
	
	/**
	* Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_voto.
	*/
	if(inDesktop){
		grdCgg_res_resolucion.getSelectionModel().on("selectionchange",function(inSelectionModel){
			var tmpRecord = grdCgg_res_resolucion.getSelectionModel().getSelected();
			if(tmpRecord){
				tmpCrres_codigo = tmpRecord.data.CRRES_CODIGO;
				btnPosponerCgg_res_voto_administrador.setDisabled(!inSelectionModel.hasSelection() || tmpRecord.data.NUMERO_VOTO > 0);
			}
		});
		
		grdCgg_res_resolucion1.getSelectionModel().on("selectionchange",function(inSelectionModel){
			var tmpRecord = grdCgg_res_resolucion1.getSelectionModel().getSelected();
			if (tmpRecord){
				tmpCrres_codigo = tmpRecord.data.CRRES_CODIGO;
				btnPosponerCgg_res_voto_administrador.setDisabled(!inSelectionModel.hasSelection() || tmpRecord.data.NUMERO_VOTO > 0);
			}
		});
		var winFrmListadoCgg_res_voto_administrador =    inDesktop.createWindow({
				id:'winFrmListadoCgg_res_voto_administrador',
				title:tituloListadoCgg_res_voto,
				tbar:getPanelTitulo(tituloListadoCgg_res_voto,descListadoCgg_res_voto),
				items:[pnlSesion,tblOrdenar1],
				width:600,
				minWidth:600,
				height:450,
				minHeight:400,
				maximizable:true,
				minimizable:true,
				constrain:true,
				layout:'border',
				bbar:[btnVotoCgg_res_voto_administrador,'-',btnPosponerCgg_res_voto_administrador,'->',btnVotoSalirCgg_res_voto_administrador]
		});
		/**
		* Funcion que aplica los privilegios del usuario.
		*/
		applyGrants(winFrmListadoCgg_res_voto_administrador.getBottomToolbar());
		
	}
	
	
	/**
	* Funcion miembro que devuelve la ventana winFrmListadoCgg_res_voto_administrador.
	* @returns ventana winFrmCgg_res_voto.
	* @base FrmListadoCgg_res_voto_administrador.prototype.show
	*/
	this.getWindow = function(){
		return winFrmListadoCgg_res_voto_administrador;
	}
	/**
	* Funcion miembro que carga los controles de la ventana winFrmListadoCgg_res_voto_administrador.
	* @base FrmListadoCgg_res_voto_administrador.prototype.loadData
	*/
	this.loadData = function(){
		gsCgg_res_resolucion_votacion.load();
	}
	/**
	* Funcion miembro que develve el ColumnModel utilizado en el listado.
	*/
	this.getColumnModel = function(){
		return cmCgg_res_resolucion_votacion;
	}
	/**
	* Funcion miembro que develve el Store utilizado en el listado.
	*/
	this.getStore = function(){
		return gsCgg_res_resolucion_votacion;
	}
	
}
/**
* Funcion prototipo. Devuelve el ColumnModel utilizado en el formulario.
*/
FrmListadoCgg_res_voto_administrador.prototype.getColumnModel = function(){
	this.getColumnModel();
}
/**
* Funcion prototipo. Devuelve el Store utilizado en el formulario.
*/
FrmListadoCgg_res_voto_administrador.prototype.getStore = function(){
	this.getStore();
}
/**
* Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_res_voto_administrador desde una instancia.
*/
FrmListadoCgg_res_voto_administrador.prototype.show = function(){
	this.getWindow().show();
}
/**
* Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_res_voto_administrador desde una instancia.
*/
FrmListadoCgg_res_voto_administrador.prototype.close = function(){
	this.getWindow().close();
}
/**
* Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_res_voto_administrador,
* con el fin de realizar otras acciones desde una instancia.
*/
FrmListadoCgg_res_voto_administrador.prototype.closeHandler = function(inFunctionHandler){
	this.getWindow().on('close',inFunctionHandler);
}
/**
* Funcion prototipo. Permite cargar los controles de la ventana winFrmListadoCgg_res_voto_administrador desde una instancia.
*/
FrmListadoCgg_res_voto_administrador.prototype.loadData = function(){
	this.loadData();
}
