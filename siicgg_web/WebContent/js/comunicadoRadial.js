function loadComunicadoRadial(){
	/*VARIABLES DE LOS COMPONENTES DE REGISTRO DATOS EMPRESA*/
	var txtDsuge_denunciante = document.getElementById("txtDsuge_denunciante");
	
	/**
	*	GRID LISTADO DESTREZA PERSONA
	*/
	function rndComunicado(v){
		return v.split(" ")[0]||" ";
	}
	var colTableComunicadoRadial=[					
		{name:'CGVCN_ANIO',title:'A\u00F1o',width:50,align:"center"},
		{name:'CGVCN_NUMERO_COMUNICADO',title:'No. comunicado',width:100,align:"center"},
		{name:'CGCRG_NOMBRE',title:'Cargo',width:200},
		{name:'CGVCN_FECHA_PUBLICACION',title:'Fecha de publicaci\u00F3n',width:100,renderer:rndComunicado},
		{name:'CGVCN_FECHA_EXPIRACION',title:'Fecha de Expiraci\u00F3n',width:100,renderer:rndComunicado},			
		{name:'CGVCN_ESTADO_OFERTA',title:'Estado',width:80}
	];
			
	var grdComunicadoRadial = new bsxTable({
		id:"grdComunicadoRadial",
		renderTo:"divGrdComunicadoRadial",
		width:"650",
		height:"300",		
		webService:{
			url:URL_WS_PUBLIC+"Cgg_atc_comunicado_radial",
			method:"selectPage",
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},			
			params:[
				{name:"start",value:"0"},
				{name:"limit",value:"10"},
				{name:"sort",value:"CGVCN_CODIGO"},
				{name:"dir",value:"ASC"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"}				
			]			
		},
		columns:colTableComunicadoRadial,
		pagin:true,
		search:true,		
		events:{
			selectedRow:function(t,dr,r){
				
			}
		}
	});	
	grdComunicadoRadial.show();
	grdComunicadoRadial.reload();	
	
}
	