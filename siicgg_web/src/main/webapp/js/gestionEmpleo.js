function loadModulo(){
	var txtUsuario=$("txtUsuario");
	var RolUsuario="";
	if (txtUsuario.value!="false"){
		function CallBackRolUsuario(r){
			RolUsuario = r;
		}	
		SOAPClient.invoke(URL_WS+"Cgg_gem_vacante", "getRolUsuario", null, false, CallBackRolUsuario);	
	}
	/*Variables correspondiente a los componentes registrados*/
	var txtCodigoGrup=$("txtCodigoGrup");
	var txtBuscar= $("txtBuscar");
	var btnBuscar=$("btnBuscar");
	var trTabBusqueda0=$("trTabBusqueda0");
	var trTabBusqueda1=$("trTabBusqueda1");	
	var divModalAplicar=$("divModalAplicar");
	var winAplicar=$("winAplicar");
	var spanTitle=$("spanTitle");
	var txtAspiracion=$("txtAspiracion");
	var txtDescripcion=$("txtDescripcion");
	var tblFiltroTitulo=$("tblFiltroTitulo");
	var txtCodigoVacante=$("txtCodigoVacante");	
	var tblFilto=$("tblFilto");
	var tblFiltoBody = tblFilto.tBodies[0];		
	
	//{GRID DE OFERTAS VACANTES
	var colTable=[		
		{title:"Fecha de publicaci\u00f3n",name:"CGVCN_FECHA_PUBLICACION", width:"75",
			renderer:function(v){
				return v.split(" ")[0];
			}
		},		
		{title:"Ciudad",name:"CGVCN_DIRECCION", width:85},
		{title:"Cargo",name:"CGCRG_NOMBRE", width:95},
		{title:"Area Funcional",name:"CGARE_NOMBRE", width:80},		
		{title:"Empresa",name:"CRPJR_RAZON_SOCIAL", width:110},
		{title:"",name:"APLICO",width:16,align:"center",hidden:(RolUsuario == "CSROL_GEAPL")?false:true,
			renderer:function(v,r){
				return r.APLICO==0?"":"<div class='aplicado'></div>";
			}
		},
		{title:"",name:"APLICO",width:35,align:"center",
			renderer:function(v,r){
				return "<div class='divBtnAplicar' onclick=\"document.location = \'detalleOferta.jsp?codVacante="+r.CGVCN_CODIGO+"&codUsuario="+r.CUSU_CODIGO+"&aplico="+r.APLICO+"'; \">Detalle</div>"				
			}
		}
	];
	var currentPagina =new ManagerCookies().read('oferta');	
			
	var grdOfertas = new bsxTable({
		id:"grdOfertas",renderTo:"divTabla1",
		width:"100%",height:"500px",
		webService:{
			url:URL_WS+"Cgg_atc_gestion_empleo",
			method:"selectPage",
			reader:{totalCountName:"totalCount",dataSetName:"dataSet"},
			params:[
				{name:"start",value:20},
				{name:"limit",value:RECORD_PAGE},
				{name:"sort",value:"CGVCN_FECHA_PUBLICACION"},
				{name:"dir",value:"DESC"},
				{name:"keyword",value:""},
				{name:"format",value:"JSON"},
				{name:"groupName",value:""},
				{name:"groupValue",value:""}
			]
		},	
		events:{
			load:function(){				
				new ManagerCookies().create ('oferta',grdOfertas.getCurrentPage());
			}
		},
		columns:colTable,
		search:true,
		pagin:true
	});	
	grdOfertas.show();	
	grdOfertas.setCurrentPage(currentPagina);
	grdOfertas.reload();
	
	var valoresComboGrupo=[
		['LAST','\u00DAtimas ofertas de trabajo','',"100px",'\u00DAtimas ofertas de trabajo'],
		['ISLA','Ofertas por Ciudad','Ciudades','80px','Ofertas distribuidas por ciudad'],
		['CARGO','Ofertas por cargo','Cargos','80px','Ofertas distribuidas por cargos'],
		['AREA','Ofertas por \u00E1rea funcional','Areas','110px','Ofertas distribuidas por \u00E1reas funcionales'],
		['OFERENTE','Ofertas por Empresa','Empresas','80px','Ofertas distribuidas por empleadores (Empresas)']
	];	
	for(j=0; j<valoresComboGrupo.length; j++){
		var tmpCell= trTabBusqueda0.insertCell(-1);
		tmpCell.className=(j==0)?"tabSelect":"tabNoSelect";
		tmpCell.width=valoresComboGrupo[j][3];
		tmpCell.align="left";
		tmpCell.innerHTML = valoresComboGrupo[j][1];
		tmpCell.title= valoresComboGrupo[j][4];
		tmpCell.id = valoresComboGrupo[j][0];
		tmpCell.onclick=function(a,b,c){
			for (var i = 0;i< valoresComboGrupo.length;i++)
				if (this.id==valoresComboGrupo[i][0])
					tblFiltroTitulo.innerHTML = valoresComboGrupo[i][2];
			var parentThis = this.parentNode;
			for (i=0;i<parentThis.childNodes.length-2;i=i+2)
				parentThis.children[i].className="tabNoSelect";
			this.className = "tabSelect";
			if(this.id=="LAST")
				tblFilto.style.display="none";
			else{
				grdOfertas.setParam("groupName", this.id);
				grdOfertas.setParam("groupValue", "");
				loadPanelFiltro(this.id);
				tblFilto.style.display="block";				
			}
			grdOfertas.reload();
		}
		trmTemp = trTabBusqueda0.insertCell(-1);
		trmTemp.width="1px";		
		trmTemp.style.cssText="border-bottom:1px solid #E7C794";
	}		
	var tmpCell= trTabBusqueda0.appendChild(document.createElement("TD"));
	tmpCell.style.cssText="border-bottom:1px solid #E7C794";
		
	var tmpCell= trTabBusqueda1.appendChild(document.createElement("TD"));	
	tmpCell.height="30px";
	tmpCell.colSpan=(valoresComboGrupo.length*2)+1;
	tmpCell.className="tabFooter";		
	
	/**
	*Creacion de un combobox con datos de un webservices
	*/
	function loadPanelFiltro(grupo){
		for(var k=tblFiltoBody.rows.length-1;k>=0;k--)
			tblFiltoBody.removeChild(tblFiltoBody.rows[k]);		
		function callBackFiltro(v){
			var res = eval(v);			
			for (var k=0;k<res.length;k++){
				tmpRow=tblFiltoBody.insertRow(-1);
				tmpRow.onclick=function(){
					var rows = tblFiltoBody.getElementsByTagName("tr");   
					for(i = 0; i < rows.length; i++) 
						rows[i].childNodes[1].className = "rowLink";
					this.childNodes[1].className="rowLinkSelect";
					var tmpGrupoValue = rows[this.sectionRowIndex].childNodes[0].innerHTML;		
					grdOfertas.setParam("keyword","");					
					grdOfertas.setParam("groupValue", tmpGrupoValue);
					grdOfertas.reload();
				}
				tmpCellCodigo=tmpRow.insertCell(-1);
				tmpCellCodigo.style.display="none";
				tmpCellCodigo.innerHTML =res[k].CODIGO;
				tmpCellValue=tmpRow.insertCell(-1);
				tmpCellValue.className ="rowLink";
				tmpCellValue.innerHTML =res[k].NOMBRE;
			}
			setHeightForm();
		}
		var param = new SOAPClientParameters();
		param.add('grupo',grupo);
		param.add('format',"JSON");
        SOAPClient.invoke(URL_WS+"Cgg_atc_gestion_empleo","selectGrupo",param, true, callBackFiltro);
	}
	setHeightForm();
	
}