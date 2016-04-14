/**
 * Funcion publica. Formulario que permite visualizar en forma de listado, la informacion de los registros de tabla Cgg_gem_vacante.
 * @constructor
 * @author Besixplus Cia. Ltda.
 */

var SEG_GES_EMP = '';
var userSessionData = "";
var iconRol= {
	icono:'logoTitulo',
	fondo:''
}
function FrmListadoCgg_gem_vacante(inDesktop) {
	var optMenu = 'Gesti\u00F3n de Empleo/Ofertas de empleo';
	var tituloListadoCgg_gem_vacante = 'Listado de ofertas';
	var descListadoCgg_gem_vacante = 'El formulario lista informaci\u00f3n de las ofertas registradas';
	userSessionData = new UserSession().getUserData();	
	function CallBackCgg_gem_rol_usuario(r){SEG_GES_EMP = r;}	
	SOAPClient.invoke(URL_WS + "Cgg_gem_vacante", "getRolUsuario", null, false, CallBackCgg_gem_rol_usuario);
	var botonesListadoVacante = "[btnDetalleCgg_gem_vacante,btnReporteCgg_gem_vacante,'->',btnSalirCgg_gem_vacante]";
	
	if (SEG_GES_EMP == "CSROL_GEADM")
		botonesListadoVacante = "[btnNuevoCgg_gem_vacante,btnEditarCgg_gem_vacante,btnDetalleCgg_gem_vacante,btnReporteCgg_gem_vacante,'->',btnSalirCgg_gem_vacante]";		
	else if (SEG_GES_EMP == "CSROL_GEEMP" || SEG_GES_EMP == "CSROL_GEAPL")
		botonesListadoVacante = "[btnNuevoCgg_gem_vacante,btnEditarCgg_gem_vacante,btnDetalleCgg_gem_vacante,'->',btnSalirCgg_gem_vacante]";
	switch (SEG_GES_EMP){
		case 'CSROL_GEADM': 
			iconRol.icono ="logoTituloAdm";
			iconRol.fondo = "fondoTituloGE";
			break;
		case 'CSROL_GEEMP': iconRol.icono ="logoTituloEmp";break;		
		default: iconRol.icono = "logoTitulo";
	}
	var urlListadoCgg_gem_vacante = URL_WS + "Cgg_gem_vacante";	
	/**
	 * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_tipo_salario por un campo especifico.
	 */
	var storeCgg_gem_tipo_salario = new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_gem_tipo_salario",
			method:"selectAll"
		}),
		reader:new Ext.data.JsonReader({},[
			{name:'CGTSA_CODIGO'},
			{name:'CGTSA_NOMBRE'},
			{name:'CGTSA_DESCRIPCION'}
		]),
		sortInfo:{
			field: 'CGTSA_NOMBRE',
			direction: 'ASC'
		},
		baseParams:{
			format:'JSON'
		}
	});
	storeCgg_gem_tipo_salario.load();
	/**
	 * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_tipo_contrato por un campo especifico.
	 */
	var storeCgg_gem_tipo_contrato = new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_gem_tipo_contrato",
			method:"selectAll"
		}),
		reader:new Ext.data.JsonReader({},[
			{name:'CGTCN_CODIGO'},
			{name:'CGTCN_DESCRIPCION'},
			{name:'CGTCN_OBSERVACION'}
		]),
		sortInfo:{
			field: 'CGTCN_DESCRIPCION',
			direction: 'ASC'
		},
		baseParams:{
			format:'JSON'
		}
	});
	storeCgg_gem_tipo_contrato.load();
	/**
	 * Ext.data.Store Agrupacion de registros de la tabla Cgg_sector_productivo por un campo especifico.
	 */
	var storeCgg_sector_productivo = new Ext.data.Store({
		proxy:new Ext.ux.bsx.SoapProxy({
			url:URL_WS+"Cgg_sector_productivo",
			method:"selectAll"
		}),
		reader:new Ext.data.JsonReader({},[
			{name:'CSCTP_CODIGO'},
			{name:'CGG_CSCTP_CODIGO'},
			{name:'CSCTP_NOMBRE'},
			{name:'CSCTP_DESCRIPCION'}
		]),
		sortInfo:{
			field: 'CGG_CSCTP_CODIGO',
			direction: 'ASC'
		},
		baseParams:{
			format:"JSON"
		}
	});
	storeCgg_sector_productivo.load();
	/**
	 * Ext.Button Boton que permite insertar un nuevo registro de la ventana winFrmListadoCgg_gem_vacante.
	 */
	var btnNuevoCgg_gem_vacante = new Ext.Button({
		id: 'btnNuevoCgg_gem_vacante',
		text: 'Nuevo',
		iconCls: 'iconNuevo',
		tooltip: 'Permite crear una nueva oferta de empleo',
		listeners: {
			click: function () {				
				var objCgg_gem_vacante = new FrmCgg_gem_vacante("insert");
				objCgg_gem_vacante.closeHandler(function () {
					gsCgg_gem_vacante.reload();
				});
				objCgg_gem_vacante.setStoreSectorProductivo(storeCgg_sector_productivo);
				objCgg_gem_vacante.setStoreTipoContrato(storeCgg_gem_tipo_contrato);
				objCgg_gem_vacante.setStoreTipoSalario(storeCgg_gem_tipo_salario);
				objCgg_gem_vacante.show();				
			}
		}
	});
	/**
	 * Ext.Button Boton que permite editar un registro de la ventana winFrmListadoCgg_gem_vacante.
	 */
	var btnEditarCgg_gem_vacante = new Ext.Button({
		id: 'btnEditarCgg_gem_vacante',
		text: 'Editar',
		tooltip: 'Permite editar una nueva oferta de empleo',
		iconCls: 'iconEditar',		
		disabled:true,		
		listeners: {
			click: function () {
				var r = grdCgg_gem_vacante.getSelectionModel().getSelected();
				if (r) {
					var objCgg_gem_vacante = new FrmCgg_gem_vacante("update", r);
					objCgg_gem_vacante.closeHandler(function () {gsCgg_gem_vacante.reload();});
					objCgg_gem_vacante.setStoreSectorProductivo(storeCgg_sector_productivo);
					objCgg_gem_vacante.setStoreTipoContrato(storeCgg_gem_tipo_contrato);
					objCgg_gem_vacante.setStoreTipoSalario(storeCgg_gem_tipo_salario);
					objCgg_gem_vacante.loadData();
					objCgg_gem_vacante.show();
				}
			}
		}
	});	
	/**
	 * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_vacante.
	 */
	var btnDetalleCgg_gem_vacante = new Ext.Button({
		id: 'btnDetalleCgg_gem_vacante',
		text: 'Ver detalle',
		tooltip: 'Permite ver el detalle de la oferta de empleo, junto con varias opciones de administraci\u00F3n.',
		iconCls: 'iconBuscar',
		disabled:true,
		listeners: {
			click: function () {
				var r = grdCgg_gem_vacante.getSelectionModel().getSelected();
				if (r) {
					if (r.get("CGVCN_FECHA_EXPIRACION") && r.get("CGVCN_FECHA_EXPIRACION")<new Date() && r.get("CGVCN_ESTADO_OFERTA")==1 && r.get("CGVCN_OFERTA_APROBADA") == 1)	{
						r.set("CGVCN_ESTADO_OFERTA",3);
						try{							
							var param = new SOAPClientParameters();
							param.add('inCgvcn_codigo', r.get("CGVCN_CODIGO"));
							param.add('inCgvcn_estado_oferta',3 );
							param.add('inCgvcn_justificacion_no_contrat', 'La vigencia del comunicado radial caduc\u00F3');
							SOAPClient.invoke( URL_WS + "Cgg_gem_vacante", "finalizarProceso", param, true, null);
						}catch(ex){
						}
					}
					var objListadoCgg_gem_vacante_detalle = new FrmCgg_gem_vacante_detalle(SEG_GES_EMP,r,storeCgg_gem_tipo_contrato,storeCgg_sector_productivo,storeCgg_gem_tipo_salario);
					objListadoCgg_gem_vacante_detalle.closeHandler(function () {
						gsCgg_gem_vacante.reload();
					});
					objListadoCgg_gem_vacante_detalle.show();
				}
			}
		}
	});
	/**
	 * Ext.Button Boton para obtener reportes, general o individual.
	 */
	var btnReporteCgg_gem_vacante = new Ext.Button({
		id: 'btnReporteCgg_gem_vacante',
		name: 'btnReporteCgg_gem_vacante',
		text: 'Reportes',
		disabled:true,
		iconCls: 'iconImprimir',
		handler:function(){
			var tmpVisible1 = false;
			var tmpVisible2 = false;
			var tmpVisible3 = false;
			var tmpSelectStore= grdCgg_gem_vacante.getSelectionModel().getSelected();
			if (tmpSelectStore){
				var tmpEstado = tmpSelectStore.get("CGVCN_ESTADO_OFERTA");
				if (tmpEstado>0)tmpVisible1=true;
				if (tmpEstado>2)tmpVisible2=true;
				if (tmpEstado==6)tmpVisible3=true;
			}
			Ext.getCmp("btnComunicadoRadial").setDisabled(!tmpVisible1);
			Ext.getCmp("btnManoObra").setDisabled(!tmpVisible2);				
			Ext.getCmp("btnNoContratacionCompleta").setDisabled(!tmpVisible3);
		},
		menu: [{
			text: 'Comunicado radial',
			id:'btnComunicadoRadial',
			handler: function () {
				new Reporte("rptComunicadoRadial", '/Reports/sii/gem', {
					P_CGVCN_CODIGO:grdCgg_gem_vacante.getSelectionModel().getSelected().get('CGVCN_CODIGO')					
				}).show();
			}
		},
		{
			text: 'Certificado de mano de obra',
			id:'btnManoObra',
			handler: function () {
				new Reporte("rptCertificadoExistenciaManObra", '/Reports/sii/gem', {
					P_CGVCN_CODIGO:grdCgg_gem_vacante.getSelectionModel().getSelected().get('CGVCN_CODIGO')			
				}).show();								
			}
		},{
			text: 'Certificado de no cubrir vacantes',
			id:'btnNoContratacionCompleta',
			handler: function () {
				new Reporte("rptCertificadoNoCubiertoVacantes", '/Reports/sii/gem', {
					P_CGVCN_CODIGO:grdCgg_gem_vacante.getSelectionModel().getSelected().get('CGVCN_CODIGO')			
				}).show();								
			}
		}]
	});
	/**
	 * Ext.Button Boton que permite salir de la ventana winFrmListadoCgg_gem_vacante.
	 */
	var btnSalirCgg_gem_vacante = new Ext.Button({
		id: 'btnSalirCgg_gem_vacante',
		text: 'Salir',
		iconCls: 'iconSalir',
		listeners: {
			click: function () {
				winFrmListadoCgg_gem_vacante.close();
			}
		}
	});
	function rndFormatFechaHora(v){
		return Ext.util.Format.date(v,"Y-m-d H:i");
	}
	function rndFormatFecha(v){
		return Ext.util.Format.date(v,"Y-m-d");
	}
	/**
	 * Ext.grid.ColumnModel Define el modelo de columnas para el objeto cgg_gem_vacante.
	 */
	var chkCgvcn_cubierta  = new Ext.grid.CheckColumn({
		id : "chkCgvcn_cubierta",
		dataIndex: 'CGVCN_CUBIERTA',
		header: 'Cubierta',
		width: 50,
		sortable: true		
	});
	/*
	ESTADO EN EL QUE SE HALLA LA PUBLICACION DE LA VACANTE
		-1 - REGISTRADA
		0 - POR APROBAR
		1 - APROBADA Y GENERADO EL COMUNICADO RADIAL
		2 - RECHAZADA FINALIZADA
		3 - VENCIDA FECHA DE PUBLICACION 
		4 - GENERADO LA CERTIFICACION DE NO EXISTENCIA DE MANO DE OBRA Y FINALIZADA
		5 - GENERADO LA CERTIFICACION DE EXISTENCIA DE MANO DE OBRA E INICIO DE ENTREVISTA
		6 - FINALIZADA SIN OCUPAR TODAS LAS VACANTES
		7 - FINALIZADA EXITOSAMENTE
		8 - FINALIZADA POR OTROS MOTIVOS
		9 - CONTRATACION DIRECTA SIN COMUNICADO RADIAL NI CERTIFICADO DE MANO DE OBRA
	*/
	function rndEstadoOferta(v,x,r){
		if (r.get("CGVCN_FECHA_EXPIRACION") && r.get("CGVCN_FECHA_EXPIRACION")<new Date() && v==1 && r.get("CGVCN_OFERTA_APROBADA") == 1 )	
			v=3;
		switch (v){			
			case -1:v= "<span style='color:GRAY;font-style: italic'>PENDIENTE</span>";break;
			case 0:v= "<span style='font-style: italic'>Por aprobar</span>";break;
			case 1:v= "<span style='color:green'>Aprobada</span>";break;
			case 2:v= "<span style='color:red'>Rechazada</span>";break;
			case 3:v= "<span style='color:orange'>Vencida</span>";break;
			case 4:v= "<span style='color:red'>No mano obra</span>";break;
			case 5:v= (r.get("CGVCN_OFERTA_APROBADA")==2)?"<span style='color:#4194BC'>Selecci\u00F3n</span>":"<span style='color:#4194BC'>Entrevista</span>";break;
			case 6:v= "<span >Finalizada</span>";break;
			case 7:v= "<span >Finalizada</span>";break;
			case 8:v= "<span >Cancelada</span>";break;			
			case 9:v= "<span style='color:green'>Aprobada</span>";break;
		}
		return v;
	}
	function rndDuracionTiempo(v, md, r){		
		var t=r.get("CGVCN_DURACION");
		switch (r.get("CGVCN_DURACION")){
			case 0:t= "Hora" + ((v>1)?"s":"");break;
			case 1:t= "D\u00eda"+((v>1)?"s":"");break;
			case 2:t= "Mes"+((v>1)?"es":"");break;
			case 3:t= "A\u00f1o"+((v>1)?"s":"");break;
		}		
		return v+" "+t;		
	}
	function rndTipoPersona(v){
		switch(v){
			case 0:v='iconPersonaNatural';break;
			case 1:v='iconPersonaJuridica'; break;
		}
		return '<div class="'+ v +' iconCell"/>';
	}
	function rndIslas(v){		
		var f = SCGG_ISLA.findExact("CISLA_CODIGO",v);
		return (f==-1)?v:SCGG_ISLA.getAt(f).get("CISLA_NOMBRE");
	}
	function rndTipoContrato(v){
		var f = storeCgg_gem_tipo_contrato.findExact("CGTCN_CODIGO",v);
		return (f==-1)?v:storeCgg_gem_tipo_contrato.getAt(f).get("CGTCN_DESCRIPCION");
	}
	var cmCgg_gem_vacante = new Ext.grid.ColumnModel([		
		{dataIndex:'EMPRESA',header:' ',width:40,sortable:true,renderer:rndTipoPersona},		
		{dataIndex:'CGVCN_ANIO',header:'A\u00f1o',width:40,sortable:true},
		{dataIndex:'CGVCN_NUMERO',header:'#',align:'right',width:50,sortable:true,tooltip:'N\u00famero de la oferta'},		
		{dataIndex:'CGCRG_NOMBRE',header:'Cargo',width:100,sortable:true,renderer:function(v,x,r){
			if (r.get('CGCRG_CODIGO')=='CGCRG0'){
				var tmpR = eval ('('+r.get('CGVCN_TITULO')+')');
				return '<span style="color:GRAY;font-style: italic">'+ tmpR.cargo +'</span>';
			}else
				return v;
		}},
		{dataIndex:'CGTPR_DESCRIPCION',header:'T\u00EDitulo profesional',width:150,sortable:true,renderer:function(v,x,r){
			if(r.get('CGTPR_CODIGO')=='CGTPR0'){
				var tmpR = eval ('('+r.get('CGVCN_TITULO')+')');
				return '<span style="color:GRAY;font-style: italic">'+tmpR.titulo+'</span>';
			}else
				return v;			
		}},		
		{dataIndex:'CGVCN_OFERTA_APROBADA',header:' ',width:30,sortable:true,renderer:
			function(v){
				if (v==2)
					return '<img src="resources/images/16x16/apps/ktip.png" title="Oferta por contrataci\u00F3n directa"/>';
			}
		},
		{dataIndex:'CGVCN_ESTADO_OFERTA',header:'Estado oferta',width:80,sortable:true,renderer:rndEstadoOferta},		
		{dataIndex:'CGVCN_NUMERO_VACANTES',header:'# vacantes',width:40,sortable:true,tooltip:'N\u00famero de vacantes disponibles'},
		{dataIndex:'CGVCN_FECHA_INGRESO',header:'F. Registro',width:70,sortable:true,renderer:rndFormatFecha,hidden:true},
		{dataIndex:'CGVCN_FECHA_PUBLICACION',header:'F. Publicaci\u00F3n',width:70,sortable:true,
			renderer:function(v,x,r){
				if (r.get ("CGVCN_ESTADO_OFERTA")==1 && r.get ("CGVCN_FECHA_PUBLICACION")){
					var fechaPublicacion = r.get ("CGVCN_FECHA_PUBLICACION");
					var duracionOferta = r.get ("CGVCN_DURACION_OFERTA");
					var fechaReal= fechaPublicacion.add(Date.DAY, duracionOferta);
					if (new Date() >= fechaReal)
						return '<span style="color:red;font-weight:bolder" title="La fecha de publicaci\u00F3n en la web finaliz\u00F3">'+Ext.util.Format.date(v,"Y-m-d")+'</span>';
					else
						return Ext.util.Format.date(v,"Y-m-d");
				}else
					return Ext.util.Format.date(v,"Y-m-d");
			}
		},
		{dataIndex:'CGVCN_FECHA_EXPIRACION',header:'F. Expiraci\u00F3n',width:70,sortable:true,renderer:rndFormatFecha},		
		{dataIndex:'CGVCN_NUMERO_COMUNICADO',header:'Com. radial',width:120,sortable:true},
		{dataIndex:'CGVCN_NUMERO_MANOBRA',header:'N\u00b0 manobra',width:90,sortable:true},		
		chkCgvcn_cubierta		
	]);
	/**
	 * Ext.data.Store Agrupacion de registros de la tabla Cgg_gem_vacante por un campo especifico.
	 */
	var gsCgg_gem_vacante = new Ext.data.GroupingStore({
		proxy: new Ext.ux.bsx.SoapProxy({
			url: URL_WS + "Cgg_gem_vacante",
			method: "selectByRolPage",
			pagin: true
		}),
		remoteSort: true,
		reader: new Ext.data.JsonReader({
			id: 'CGVCN_CODIGO',
			root: 'dataSet',
			totalProperty: 'totalCount'
		}, [
			{name:'CGVCN_CODIGO'},
			{name:'CUSU_CODIGO'},
			{name:'EMPRESA'},
			{name:'APLICO'},
			{name:'CUSU_NOMBRE_USUARIO'},			
			{name:'CSCTP_CODIGO'},
			{name:'CGTCN_CODIGO'},
			{name:'CGTSA_CODIGO'},{name:'CGTSA_NOMBRE'},
			{name:'CGCRG_CODIGO'},{name:'CGCRG_NOMBRE'},
			{name:'CGTPR_CODIGO'},{name:'CGTPR_DESCRIPCION'},
			{name:'CGVCN_NUMERO'},
			{name:'CGVCN_TITULO'},
			{name:'CGVCN_DESCRIPCION'},
			{name:'CGVCN_SALARIO'},
			{name:'CGVCN_DIRECCION'},
			{name:'CGVCN_FECHA_INGRESO',type:"date",dateFormat:'Y-m-d H:i:s.u'},
			{name:'CGVCN_FECHA_PUBLICACION',type:"date",dateFormat:'Y-m-d H:i:s.u'},
			{name:'CGVCN_DURACION_OFERTA'},
			{name:'CGVCN_FECHA_EXPIRACION',type:"date",dateFormat:'Y-m-d H:i:s.u'},
			{name:'CGVCN_ESTADO_OFERTA'},
			{name:'CGVCN_NUMERO_VACANTES'},
			{name:'CGVCN_DURACION'},
			{name:'CGVCN_DURACION_TIEMPO'},
			{name:'CGVCN_EXPERIENCIA'},
			{name:'CGVCN_EXISTENCIA_MANOBRA'},
			{name:'CGVCN_NUMERO_MANOBRA'},
			{name:'CGVCN_ANIO'},
			{name:'CGVCN_NUMERO_COMUNICADO'},
			{name:'CGVCN_OFERTA_APROBADA'},
			{name:'CGVCN_CUBIERTA'},
			{name:'CGVCN_JUSTIFICACION_NO_CONTRAT'}
		]),
		sortInfo:{field: 'CGVCN_FECHA_INGRESO', direction: 'desc'},
		baseParams:{keyword:"",format:'JSON',rol:SEG_GES_EMP},
		groupField:'CGVCN_FECHA_INGRESO'
	});
	/**
	 * Ext.PagingToolbar Barra de navegacion que permite la visualizacion organizada de los registros de la tabla Cgg_gem_vacante.
	 */
	var pgBarCgg_gem_vacante = new Ext.PagingToolbar({
		store: gsCgg_gem_vacante,
		displayInfo: true,
		pageSize: RECORD_PAGE,
		displayMsg: 'Mostrando {0} - {1} de {2}',
		temptyMsg: 'No hay informaci\u00f3n para mostrar'
	});
	/**
	 * Ext.grid.GridPanel Representacion de los datos de la tabla Cgg_gem_vacante en un formato tabular de filas y columnas.
	 */
	var grdCgg_gem_vacante = new Ext.grid.GridPanel({
		cm: cmCgg_gem_vacante,
		store: gsCgg_gem_vacante,
		region: 'center',
		sm: new Ext.grid.RowSelectionModel({singleSelect: true}),
		loadMask: {msg: "Cargando..."},
		tbar: ['Buscar: ', new Ext.ux.bsx.SearchField({store: gsCgg_gem_vacante,width: 200})],
		bbar: pgBarCgg_gem_vacante,
		listeners: {
			rowdblclick: function (inGridComponent, inRowIndex, inEventObject) {
				btnDetalleCgg_gem_vacante.fireEvent('click');
			}
		},
		view: new Ext.grid.GroupingView({
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "Items" : "Item"]})'
        })
	});
	grdCgg_gem_vacante.getSelectionModel().on("selectionchange",function(sm_cgvcn){		
		var sw_cgvcn=sm_cgvcn.hasSelection();
		btnDetalleCgg_gem_vacante.setDisabled(!sw_cgvcn);
		btnReporteCgg_gem_vacante.setDisabled(!sw_cgvcn);
		if (sw_cgvcn == false) btnEditarCgg_gem_vacante.setDisabled(true);					
	});
	grdCgg_gem_vacante.getSelectionModel().on("rowselect",function(SelectionModel, rowIndex,  r ){		
		var recAprobada= SelectionModel.getSelected().get("CGVCN_OFERTA_APROBADA");
		var recEstadoVacante= SelectionModel.getSelected().get("CGVCN_ESTADO_OFERTA");
		btnEditarCgg_gem_vacante.setDisabled((recAprobada=='2' || recEstadoVacante > '0')?true:false);
	})
	gsCgg_gem_vacante.reload({
		params: {
			start: 0,
			limit: RECORD_PAGE,
			format: 'JSON',
			rol:SEG_GES_EMP
		}
	});
/**
     * Ext.Window Ventana en la que reside los controles necesarios para visualizar la informacion de los registros de la tabla Cgg_res_carnet.
     */
	if(inDesktop){
		var winFrmListadoCgg_gem_vacante = inDesktop.createWindow({
			id: 'winFrmListadoCgg_gem_vacante',
			title: tituloListadoCgg_gem_vacante,
			width: 810,
			minWidth: 400,
			height: 550,
			minHeight: 200,
			maximizable: true,
			minimizable: true,
			constrainHeader: true,
			layout: 'border',
			tbar: getPanelTitulo(tituloListadoCgg_gem_vacante, descListadoCgg_gem_vacante),
			items: [grdCgg_gem_vacante],
			bbar:eval(botonesListadoVacante)
		});
	}	
	
	/**
	 * Funcion miembro que devuelve la ventana winFrmListadoCgg_gem_vacante.
	 * @returns ventana winFrmCgg_gem_vacante.
	 * @base FrmListadoCgg_gem_vacante.prototype.show
	 */
	this.getWindow = function () {
		return winFrmListadoCgg_gem_vacante;
	}
}
/**
 * Funcion prototipo. Permite mostrar la ventana winFrmListadoCgg_gem_vacante desde una instancia.
 */
FrmListadoCgg_gem_vacante.prototype.show = function () {
	this.getWindow().show();
}
/**
 * Funcion prototipo. Permite cerrar la ventana winFrmListadoCgg_gem_vacante desde una instancia.
 */
FrmListadoCgg_gem_vacante.prototype.close = function () {
	this.getWindow().close();
}
/**
 * Funcion prototipo. Permite saber si se ha cerrado la ventana winFrmListadoCgg_gem_vacante,
 * con el fin de realizar otras acciones desde una instancia.
 */
FrmListadoCgg_gem_vacante.prototype.closeHandler = function (inFunctionHandler) {
	this.getWindow().on('close', inFunctionHandler);
}
