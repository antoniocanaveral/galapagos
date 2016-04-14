function loadListadoEmpresas(){
	var txtRdemp_razon_social = document.getElementById("txtRdemp_razon_social");
	if($("txtUsuario").value == "false") return
	var colTableEmpresas=[		
		{name:'CRPJR_RAZON_SOCIAL',title:'Raz\u00F3n Social',width:250},
		{name:'CRPJR_DIRECCION',title:'Dirección',width:150},
		{name:'CRPJR_ACTIVIDAD',title:'Actividad',width:150}
	];		
	var grdEmpresas = new bsxTable({
		id:"grdEmpresas",
		renderTo:"divGrdListadoEmpresas",
		width:"600",
		height:"650",		
		webService:{
			url:URL_WS+"Cgg_res_persona_juridica",
			method:"selectPageByRol",
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},			
			params:[
				{name:"start",value:"0"},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:"CRPJR_CODIGO"},
				{name:"dir",value:"ASC"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"}				
			]			
		},
		columns:colTableEmpresas,
		pagin:true,
		search:true
	});	
	grdEmpresas.show();
	grdEmpresas.reload();	
	setHeightForm(670);
}
	