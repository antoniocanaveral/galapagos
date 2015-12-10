function loadModulo(){	
	var colTable=[		
		{title:"Oferente",name:"CGCRG_NOMBRE", width:"100"},
		{title:"Ciudad",name:"CGCRG_DESCRIPCION", width:"200"}		
	];
			
	var grdAreaCargos2 = new bsxTable({
		id:"grdAreaCargos2",
		renderTo:"trGrdAreaCargos2",
		width:"400",
		height:"300",
		webService:{
			url:URL_WS+"Cgg_gem_cargo",
			method:"SelectPageCargoByArea",
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},
			params:[
				{name:"start",value:"0"},
				{name:"limit",value:"10"},
				{name:"sort",value:"CGCRG_NOMBRE"},
				{name:"dir",value:"ASC"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"},
				{name:"cgare_codigo",value:""},				
			]
		},
		columns:colTable,
		pagin:true,	
		search:true,		
		events:{
			load:function(ds){
				
			},
			selectedRow:function(tr,rec,i){
				alert(i);
			},
			beforeLoad:function(){
				grdAreaCargos2.setParam("cgare_codigo",(cbxGrupoDato)?cbxGrupoDato.dom.value:"");
			}
		}
	});	
	grdAreaCargos2.show();	
	var trSearch=grdAreaCargos2.getSearchBox();
	var tmpCell = trSearch.insertCell(1);
	tmpCell.id="cellCbxGrupoDato";
	grdAreaCargos2.reload();
	
	
	var cbxGrupoDato = new bsxComboBox({
		id:"cbxGrupoDato",
		renderTo:"cellCbxGrupoDato",		
		displayField:"CGARE_NOMBRE",
		valueField:"CGARE_CODIGO",
		webService:{
			url:URL_WS+"Cgg_gem_area_funcional",
			method:"selectAll",
			params:[				
				{name:"format",value:"JSON"}
			]
		},
		events:{
			load:function(v){
				var newOpt1 = new Option("Todos", "");
				cbxGrupoDato.dom.options[0] = newOpt1;
			}
		}
	});	
    cbxGrupoDato.reload();
}