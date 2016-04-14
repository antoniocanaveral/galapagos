function loadOfertasByUsuario(){	
	var userObject;	
	var url = URL_WS+"SessionManager?request=userobject";
	new Ajax.Request(url, {
		method: 'get',
		asynchronous : false,
		onSuccess: function(transport) {
			userObject = eval("("+transport.responseText+")");
		},
		onFailure: function(transport) {
			alert(transport);
		}
	});
	var codigoUsuario=userObject.CUSU_CODIGO;
	var FrmOfertasDetalle = document.getElementById("FrmOfertasDetalle");
	var codigoVacante;
	
	/**
	*	GRID LISTADO DESTREZA PERSONA
	*/
	function rndComunicado(v){
		return v.split(" ")[0]||" ";
	}
	var colTableOfertasByUsuario=[							
		{name:'CGVCN_CODIGO',title:'C\u00F3digo Vacante',width:10,hidden:true},
		{name:'CGVCN_NUMERO_COMUNICADO',title:'No. comunicado',width:120,align:"center"},
		{name:'CGCRG_NOMBRE',title:'Cargo',width:200},
		{name:'CGVCN_FECHA_PUBLICACION',title:'Fecha de publicaci\u00F3n',width:100,renderer:rndComunicado},
		{name:'CGVCN_FECHA_EXPIRACION',title:'Fecha de Expiraci\u00F3n',width:100,renderer:rndComunicado},			
		{name:'CGVCN_ESTADO_OFERTA',title:'Estado',width:80,hidden:true},	
		{name:'CUSU_CODIGO',title:'C\u00F3digo usuario',width:80,hidden:true},
		{title:"",name:"APLICO",width:40,align:"center",
			renderer:function(v,r){
				return "<div class='divBtnAplicar' onclick=\"document.location = \'detalleOferta.jsp?codVacante="+r.CGVCN_CODIGO+"\&codUsuario="+r.CUSU_CODIGO+"\&view=true'; \">Detalle</div>";
			}
		}
	];
			
	var grdOfertasByUsuario = new bsxTable({
		id:"grdOfertasByUsuario",
		renderTo:"divGrdOfertasByUsuario",
		width:"680",
		height:"300",		
		webService:{
			url:URL_WS+"Cgg_gem_vacante",
			method:"selectOfertasByUsuarios",
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},			
			params:[
				{name:"start",value:"0"},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:"CGVCN_FECHA_PUBLICACION"},
				{name:"dir",value:"ASC"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"},
				{name:"inCusu_codigo",value:codigoUsuario}
			]			
		},
		columns:colTableOfertasByUsuario,
		pagin:true,
		search:true		
		
	});	
	grdOfertasByUsuario.show();
	grdOfertasByUsuario.reload();	
}
	