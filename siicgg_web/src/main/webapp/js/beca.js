function loadBeca(){		
	var colTableBecaBeneficiario=[		
		{name:'NOMBRE_BENEFICIARIO',title:'Beneficiario',width:'250'},
		{name:'CDTBC_NOMBRE',title:'Beca',width:'150'},	
		{name:'CDBEC_FECHA_INICIO',title:'F. Inicio',width:'80',align:'center'},		
		{name:'CDBEC_FECHA_FIN',title:'F. Fin',width:'80',align:'center'}
	];
	
	var grdBecaBeneficiario = new bsxTable({
		id:"grdBecaBeneficiario",
		renderTo:"divBecaBeneficiario",
		width:"100%",
		height:"450",
		webService:{
			url:URL_WS+"PublicWS/Cgg_atc_beca",
			method:"selectBecaBeneficiario",	
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},			
			params:[
				{name:"start",value:0},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:'NOMBRE_BENEFICIARIO'},
				{name:"dir",value:'DESC'},
				{name:"keyword",value:''}
			]
		},
		pagin:true,
		search:true,
		columns:colTableBecaBeneficiario,		
		events:{
			load:function(){
				setHeightForm();
			}
		}
	});
	grdBecaBeneficiario.show();
	grdBecaBeneficiario.reload();
	setHeightForm();
}
	