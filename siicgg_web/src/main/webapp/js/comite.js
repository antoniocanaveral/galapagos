function loadComite(){		
	
	function CBSelectMiembrosComite(v){
		var a = eval('('+v+')');		
		if(a.length>0){	
			var tmpCom = "";
			for (i=0;i<a.length;i++){
				tmpCom += a[i].NOMBRE_PERSONA + ((a[i].CRMBC_TITULAR)?', ':'(*), ');
			}
			$('divMiembrosComite').innerHTML = tmpCom;
		}
	}
	var param = new SOAPClientParameters();				
	param.add('inCrcom_Codigo','CRCOM1');
	
	SOAPClient.invoke(
		URL_WS+"PublicWS/Cgg_atc_comite",
		"selectMiembrosComite",
		param, 
		true, 
		CBSelectMiembrosComite
	);
	
	var colTableResolucion=[		
		{name:'CISLA_NOMBRE',title:'Isla',width:'80'},		
		{name:'CRRES_NUMERO_RESOLUCION',title:'Num. resol.',width:'130'},		
		{name:'CRRES_FECHA_EJECUCION',title:'F. Ejecucion',width:'80',align:'center'},		
		{name:'CRRES_EXTRACTO_RESOLUCION',title:'Extracto'},		
		{name:'CRRES_ESTADO_RESOLUCION',title:'Estado',
			renderer:function(v){
				switch(v){
					case 0: v="ESPERANDO VOTACION"; break;
					case 1: v="APROBADA"; break;
					case 2: v="NEGADA"; break;
					case 3: v="EJECUTADA"; break;
					case 4: v="ANULADA"; break;
				}
				return v;
			}
		}		
	];
	
	var grdResolucionesComite = new bsxTable({
		id:"grdResolucionesComite",
		renderTo:"divResolucionesComite",
		width:"100%",
		height:"450",
		webService:{
			url:URL_WS+"PublicWS/Cgg_atc_comite",
			method:"selectResolucionesDirect",	
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},			
			params:[
				{name:"inCrcom_Codigo",value:'CRCOM1'},
				{name:"start",value:0},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:'CRRES_NUMERO_RESOLUCION'},
				{name:"dir",value:'DESC'},
				{name:"keyword",value:''}
			]
		},
		pagin:true,
		search:true,
		columns:colTableResolucion,		
		events:{
			load:function(){
				setHeightForm();
			}
		}
	});
	grdResolucionesComite.show();
	grdResolucionesComite.reload();
	setHeightForm();
}
	