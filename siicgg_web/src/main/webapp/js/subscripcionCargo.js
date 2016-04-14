function loadModulo(){
	if ($("txtUsuario").value == "false")return
	var userObject;	
	var url = URL_WS+"SessionManager?request=userobject";
	new Ajax.Request(url, {
		method: 'get',
		asynchronous : false,
		onSuccess: function(transport){
			userObject = eval("("+transport.responseText+")");
		},
		onFailure: function(transport){
			alert(transport);
		}
	});
	var codigoUsuario=userObject.CUSU_CODIGO;
	var codigoUsuario="CUSU9";
	var colTable=[
		{title:"<INPUT type='checkbox' id='chkSelectAll'/>",name:"CGCRG_ESTADO_SUBSCRIPCION", width:"50",align:"center",
			renderer:function(v,rec){
				return  "<INPUT type='checkbox' id='chk"+(rec.CGUCR_CODIGO)+"' "+ ((v>0)?"checked":"") +" value='"+(rec.CGCRG_CODIGO||"")+"-"+v+"'/>";
			}
		},
		{title:"Cargo",name:"CGCRG_NOMBRE", width:"150"},
		{title:"Descripci\u00f3n",name:"CGCRG_DESCRIPCION", width:"180"}
	];
	var grdAreaCargos = new bsxTable({
		id:"grdAreaCargos",
		renderTo:"trGrdAreaCargos",
		width:"500",
		height:"500",
		webService:{
			url:URL_WS+"Cgg_gem_cargo",
			method:"SelectPageCargoByArea",
			reader:{
				totalCountName:"totalCount",
				dataSetName:"dataSet"
			},
			params:[
				{name:"start",value:"0"},
				{name:"limit",value:"100"},
				{name:"sort",value:"CGCRG_NOMBRE"},
				{name:"dir",value:"ASC"},
				{name:"keyword",value:""},
				{name:"cgare_codigo",value:""},	
				{name:"format",value:"JSON"}
			]
		},
		columns:colTable,
		pagin:true,
		search:true,
		events:{
			load:function(ds){
				for(var i =0;i<ds.length;i++){
					var chk = document.getElementById("chk"+ds[i].CGUCR_CODIGO);
					chk.onchange=function(){
						try {
							function CallBackCgg_gem_usuario_cargo(r) {
								grdAreaCargos.reload();
							}
							var param = new SOAPClientParameters();
							var sentenciaUC = "insert";
							var inCgucr_codigo = this.id.split("chk")[1]
							if ( inCgucr_codigo!="undefined"){
								param.add('inCgucr_codigo', inCgucr_codigo);
								sentenciaUC="update";
							}
							param.add('inCusu_codigo', codigoUsuario);
							param.add('inCgcrg_codigo', this.value.split("-")[0]);
							param.add('inCgcrg_estado_subscripcion', (this.checked)?1:0);
							SOAPClient.invoke(URL_WS+"Cgg_gem_usuario_cargo",sentenciaUC , param, true, CallBackCgg_gem_usuario_cargo);
						} catch (inErr) {
							
						}
					}
				}
				setHeightForm();
			},
			beforeLoad:function(){grdAreaCargos.setParam("cgare_codigo",(cbxGrupoDato)?cbxGrupoDato.dom.value:"");}
		}
	});
	grdAreaCargos.show();
	var trSearch=grdAreaCargos.getSearchBar();
	var tmpCell = trSearch.insertCell(0);
	tmpCell.width=80;
	tmpCell.id="cellCbxGrupoDato";
	grdAreaCargos.reload();	
	var cbxGrupoDato = new bsxComboBox({
		id:"cbxGrupoDato",
		renderTo:"cellCbxGrupoDato",
		displayField:"CGARE_NOMBRE",
		valueField:"CGARE_CODIGO",
		webService:{
			url:URL_WS+"Cgg_gem_area_funcional",
			method:"selectAll",
			params:[{name:"format",value:"JSON"}]
		},
		events:{
			load:function(v){
				var newOpt = new Option("Todos", "");
				cbxGrupoDato.dom.options[cbxGrupoDato.dom.length] = newOpt;
				cbxGrupoDato.dom.selectedIndex=cbxGrupoDato.dom.length-1;
				cbxGrupoDato.dom.onchange= function(){
					grdAreaCargos.reload();
				}
				//setHeightForm();
			}
		}
	});	
	cbxGrupoDato.reload();
	cbxGrupoDato.dom.style.cssText ="width:120";
	$("chkSelectAll").onclick = function(){
		try {
			function CallBackCgg_gem_usuario_cargoAll(r) {
				grdAreaCargos.reload();
			}
			var tmpBus = grdAreaCargos.getSearchBarValue();
			var param = new SOAPClientParameters();
			param.add('inCusu_codigo', codigoUsuario);
			param.add('inCgare_codigo', cbxGrupoDato.dom.value);
			param.add('inBusqueda', tmpBus);
			param.add('inEstado', (this.checked)?1:0);
			SOAPClient.invoke(URL_WS+"Cgg_gem_usuario_cargo","insertAll" , param, true, CallBackCgg_gem_usuario_cargoAll);
		} catch (inErr) {
			
		}
	}
}