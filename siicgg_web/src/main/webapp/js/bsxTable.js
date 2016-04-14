/**
 *Funcion publica. PErmite la creacion de un componente tabla.
 *@constructor
 *@author Besixplus Cia. Ltda.
 */
function bsxTable(v){	
	if(!v)//alert("objeto mal formado");
	onLoad=v.onLoad;
	var renderTo=v.renderTo||"";
	var srcTable=null;
	var cols =v.columns||[];
	var cmpTBody=null;
	var firstCol=null;
	var id=v.id||"";
	var title=v.title||null;
	var lastRow=null;	
	
	var paginParam={size:RECORD_PAGE,totalPagins:0,btnClick:'btnF'};	
	var pagin=v.pagin||false;	
	var search=v.search||false;	
	this.getCurrentPage= function(){return txt.value};
	this.setCurrentPage= function(val){txt.value=val};
	
	/*definicion y metodo para obtener el area (TR)*/
	var titleBar;this.getTitleBar=function(){return titleBar};
	var searchBar;this.getSearchBar=function(){return searchBar};	
	var paginBar;this.getPaginBar=function(){return paginBar};
	
	var iconCls = v.iconCls||null;
	
	/*Parametros para los servicios web*/
		this.webService=v.webService||null;	
		var dataReader;
		var totalCount;
		var totalCountName =0;
		var dataSetName;
		var dataSet=[];
		var params;
		if (this.webService){
			params=v.webService.params||null;
			dataReader=v.webService.reader||null;
		}
		if (dataReader){
			if (dataReader) totalCountName=dataReader.totalCountName||null;
			if (dataReader) dataSetName=dataReader.dataSetName||null;
		}
	/*End Parametros para los servicios web*/
	var cmpTHead ;
	this.columns=v.columns||[];
	
	this.width=v.width||"300px";
	this.height=v.height||"200px";
	
	/*Variables corresponidentes los botones e informacion de la barra de paginacion*/
	var btnF,btnP,btnN,btnL,txt,lblTotalPaginas,lblInfoPaginacion;	
	this.getSearchBarValue =function(){return txtSearch.value};	
	
	/*Evento que se ejecuta cuando una fila de la tabla ha sido seleccionada
	* @param {tr element} this element TR seleccionado
	* @param {array} dataRow Fila de datos seleccionado
	* @param {int} rowIndex Index de la fila seleccionado			
	*/
	var selectedRow = (v.events)?v.events.selectedRow:null;
	/*Evento que se ejecuta cuando finaliza la carga de los datos
	* @param {array} dataSet Array de objetos json
	* @param {array} dataRow Fila de datos seleccionado
	* @param {int} rowIndex Index de la fila seleccionado			
	*/
	this.load = (v.events)?v.events.load:null;
	
	this.beforeLoad=(v.events)?v.events.beforeLoad:null;;
	/*End Eventos*/
	
	
	this.show=function(){				
		var tmpRow,tmpCell;
		var tmpRenderTo=document.getElementById(renderTo);		
		tmpRenderTo.innerHTML=
			"<table width='"+this.width +"' border=0 id='parent"+ id +"'>"+
				"<tbody><tr><td>"+
					"<table border=0 id='"+ id +"' width='"+this.width +"' >"+
						"<tbody id='"+ id +"-tbody'></tbody>"+
					"</table>"+
				"</td></tr></tbody>"+
			"</table>";	
		srcTableParent=document.getElementById("parent"+id);		
		srcTable=document.getElementById(id);		
		srcTableParent.cellSpacing = 0;
		srcTableParent.cellPadding = 0;		
				
		srcTable.cellSpacing = 0;
		srcTable.cellPadding = 0;
		srcTableParent.style.cssText = "width:"+(this.width);
		srcTable.className="tabla";
		srcTable.style.cssText = "width:"+this.width;
		
		cmpTHead = srcTable.createTHead();
		cmpTBody = document.getElementById(id+"-tbody");
		
		cmpTBody.onscroll = function(e) { 
			e.currentTarget.previousSibling.scrollLeft = e.currentTarget.scrollLeft; 
		}
		cmpTBody.className="csstbody";		
		cmpTBody.style.cssText="width:"+(this.width)+";height:"+this.height+";";
		cmpTHead.style.cssText="width:"+(this.width);
		
		cmpTBodyParent = srcTableParent.tBodies[0];
				
		if (search){
			var tmpRow=cmpTBodyParent.insertRow(0);
			tmpRow.insertCell(-1).innerHTML="<table border=0 class='searchBar' id='sb-"+id+"'><tbody></tbody></table>";
			var tblsearchBar=document.getElementById("sb-"+id);		
			var tblsearchBarTBody =tblsearchBar.tBodies[0];
			
			searchBar =tblsearchBarTBody.insertRow(-1);			
			searchBar.className ="cssSearch" ;			
			var tmpBuscar = searchBar.insertCell(0);
			tmpBuscar.innerHTML="Buscar:\u00A0";
			tmpBuscar.width="40px";
			var tmpText = searchBar.insertCell(-1);
			tmpText.width="125px";
			txtSearch= tmpText.appendChild(document.createElement("INPUT"));
			txtSearch.size = 20;			
			txtSearch.onchange=function(){cmpBsxTable.reload();};			
			btnSearch = searchBar.insertCell(-1).appendChild(document.createElement("BUTTON"));
			btnSearch.className ="icon iconBuscar";
			
			btnSearch.onclick=function(){	
				cmpBsxTable.reload();	
			}
			searchBar.insertCell(-1).innerHTML="&nbsp;";
		}

		if (title || iconCls){
			var tmpRow=cmpTBodyParent.insertRow(0);
			tmpRow.insertCell(-1).innerHTML="<table border=0 class='titleBar' id='tb-"+id+"'><tbody></tbody></table>";
			var tblsearchBar=document.getElementById("tb-"+id);		
			var tblsearchBarTBody =tblsearchBar.tBodies[0];
			
			var titleBar =tblsearchBarTBody.insertRow(-1);
			titleBar.className ="cssHeadTitle" ;
			if (iconCls){
				var tmpIcon = titleBar.appendChild(document.createElement("TH"));
				tmpIcon.innerHTML="";
				tmpIcon.className="icon "+iconCls;				
			}
			if (title)titleBar.appendChild(document.createElement("TH")).innerHTML=title;		
		}			
		cmpTHead.className="tableThead";
		tmpRow = cmpTHead.insertRow(-1);
		tmpRow.className ="cssColumnTitle" ;			
		for(var j=0; j<this.columns.length; j++){
			if (!cols[j].hidden || cols[j].hidden==false){
				tmpCell = tmpRow.appendChild(document.createElement("TH"));				
				tmpCell.width=cols[j].width;
				tmpCell.style.cssText="min-width:"+this.columns[j].width;
				tmpCell.align=cols[j].align||"left";
				tmpCell.innerHTML = this.columns[j].title||"&nbsp;";
			}			
		}	
		
		if 	(pagin){
			var tmpRow=cmpTBodyParent.insertRow(-1);
			tmpRow.insertCell(-1).innerHTML="<table class='paginBar' border=0 id='pg-"+id+"' width='100%'><tbody></tbody></table>";
			var tblPaginBox=document.getElementById("pg-"+id);		
			var tblPaginBoxTBody =tblPaginBox.tBodies[0];			
			lastRow = tblPaginBoxTBody.insertRow(-1);
			lastRow.style.cssText = "border:1";
			/* boton btnFirst*/ 
			btnF = lastRow.insertCell(-1).appendChild(document.createElement("BUTTON"));
			btnF.className ="iconFirst";
			btnF.style.cssText ="margin-left:3px";
			btnF.onclick=function(){
				paginParam.btnClick ="btnF";
				txt.value=1;
				cmpBsxTable.reload();
			}
			/*boton btnPrevious*/ 
			btnP = lastRow.insertCell(-1).appendChild(document.createElement("BUTTON"));
			btnP.className ="iconPrevious";
			btnP.onclick=function(){
				paginParam.btnClick ="btnP";
				txt.value = parseInt(txt.value)-1;
				cmpBsxTable.reload();
			}
			/*Texto descriptivo Pagina*/
			lastRow.insertCell(-1).innerHTML="P\u00e1gina ";
			
			/*textbox Numero de pagina actual*/ 
			txt = lastRow.insertCell(-1).appendChild(document.createElement("INPUT"));
			txt.size = 4;txt.value=1;
			txt.onchange=function(){cmpBsxTable.reload();};
			txt.onkeypress=function(e) { 
				tecla = (document.all) ? e.keyCode : e.which;
				if (tecla==8 || tecla==13) return true; 
				patron = /\d/;
				te = String.fromCharCode(tecla); 
				return patron.test(te);  
			} ; 
			/*Texto descriptivo Pagina*/
			lastRow.insertCell(-1).innerHTML=" de ";
			
			/*Texto descriptivo Pagina*/
			lblTotalPaginas = lastRow.insertCell(-1).appendChild(document.createElement("LABEL"));								
			/*boton btnNext*/
			btnN = lastRow.insertCell(-1).appendChild(document.createElement("BUTTON"));
			btnN.className ="iconNext";
			btnN.onclick=function(){
				paginParam.btnClick ="btnN";
				txt.value = parseInt(txt.value)+1;
				cmpBsxTable.reload();				
			}
			
			/*boton btnLast*/
			btnL = lastRow.insertCell(-1).appendChild(document.createElement("BUTTON"));
			btnL.className ="iconLast";
			btnL.onclick=function(){
				paginParam.btnClick ="btnL";
				cmpBsxTable.reload();
			}
			lastRow.insertCell(-1).innerHTML="|";
			
			/*boton reload*/
			btnR = lastRow.insertCell(-1).appendChild(document.createElement("BUTTON"));
			btnR.className ="iconReload";
			btnR.onclick=function(){				
				cmpBsxTable.reload();
			}
			
			/*Informacion de navegacion en la paginacion*/			
			var tmpTd = lastRow.insertCell(-1);
			tmpTd.style.cssText="width:"+this.width+";";
			tmpTd.align ="right";
			lblInfoPaginacion = tmpTd.appendChild(document.createElement("LABEL"));
			lblInfoPaginacion.style.cssText = "text-align:right;"
			lblInfoPaginacion.style.cssText ="margin-right:3px";
		}
	}
	this.setParam=function(n,v){		
		for (i=0;i<params.length;i++)
			if (params[i])
				if(params[i].name ==n)
					params[i].value=v;
	}
	var varPagin={
		totalPagins:1
	}	
	
	this.reload=function(){
		var loade = (this.load)?this.load:null;
		if (this.beforeLoad)this.beforeLoad();
		if (pagin){
			if (paginParam.btnClick == "btnL")
				txt.value=varPagin.totalPagins;
			btnF.disabled = true;
			btnP.disabled = true;
			btnN.disabled = true;
			btnL.disabled = true;
		}
		var tmpCell=null;
		for(var k=cmpTBody.rows.length-1;k>=0;k--)
			cmpTBody.removeChild(cmpTBody.rows[k]);
		cmpTBody.insertRow(-1).insertCell(-1).innerHTML="<img src='css/icon/cargando.gif'/>Cargando...";
		//cmpTBody.innerHTML="<tr><td><img src='css/icon/cargando.gif'/>Cargando...</td></tr>";
		function callBackBsx(v){			
			var  ex="";
			try{
				cmpTBody.removeChild(cmpTBody.rows[0]);	
				var t=eval("("+v+")");
				var ds=loadLocal(t);
				if(loade)
					loade(ds);				
			}catch(ex){
				new Error(ex);
			}
		}
		function loadLocal(t){			
				dataSet=(dataSetName)?t[dataSetName]:t;
				totalCount=(totalCountName)?t[totalCountName]:dataSet.length;
				if (pagin){
					var lenData= dataSet.length;
					var totalData = totalCount;
					var sizePagin = paginParam.size;
					var tmpDiv = (totalData == sizePagin)?0:parseInt(totalData / sizePagin);
					varPagin.totalPagins= tmpDiv+1;
					lblTotalPaginas.textContent = varPagin.totalPagins;		
						
					if (varPagin.totalPagins<=1){						
						txt.value=1;
					}else if(txt.value <= 1){						
						txt.value=1;
						btnN.disabled = false;
						btnL.disabled = false;
					}else if (txt.value >= varPagin.totalPagins){
						txt.value=varPagin.totalPagins;
						btnF.disabled = false;
						btnP.disabled = false;
					}else{
						btnF.disabled = false;
						btnP.disabled = false;
						btnN.disabled = false;
						btnL.disabled = false;
					}
					if (totalData != 0){
						var tmp1 = ((parseInt(txt.value)-1)*sizePagin);
						var tmp2 = tmp1+lenData;
						lblInfoPaginacion.textContent = "Mostrando "+ ((tmp1==0)?'1':tmp1+1) + " - "+ tmp2 +" de " +totalData;					
					}else
						lblInfoPaginacion.textContent = "No existe datos";					
				}
			
			var numRows = dataSet.length;
			for(i=0; i<numRows; i++){
				var tmp = dataSet[i];				
				tmpRow = cmpTBody.insertRow(-1);
				if (selectedRow)
					tmpRow.onclick=function(){
						selectedRow(this,dataSet[this.sectionRowIndex],this.sectionRowIndex+1);
						var rows = cmpTBody.getElementsByTagName("tr");   
						for(i = 0; i < rows.length; i++)   					 
						   rows[i].className = "rowNoSelectTable";						
						this.className="rowSelectTable";
					}
				for(j=0; j<cols.length; j++){
					function insCell(){
						tmpCell = tmpRow.insertCell(-1);
						tmpCell.align=cols[j].align||"left";
						if(i==0)tmpCell.style.cssText="min-width:"+cols[j].width;
						tmpCell.width=cols[j].width;
						if (cols[j].renderer)
							tmpCell.innerHTML = cols[j].renderer(tmp[cols[j].name]||"",tmp);
						else
							tmpCell.innerHTML = tmp[cols[j].name]||"&nbsp;";
						tmpCell = null;
					}
					
					if (!cols[j].hidden) 
						if	(cols[j].hidden == false) 
							insCell();
					else
						insCell();
				}
				tmpRow = null;
			}
			return dataSet;
		}		
		var param = new SOAPClientParameters();
		for (i=0;i<params.length;i++){			
			if(params[i]){
				if (pagin){
					if (txt.value <1)txt.value = 1;
					else if(txt.value >varPagin.totalPagins)txt.value = txt.value;//varPagin.totalPagins;					
						if (params[i].name == 'start')
							params[i].value = 
								(paginParam.btnClick !="btnL")?
									(parseInt(txt.value)-1) * paginParam.size:
									(varPagin.totalPagins-1)*paginParam.size;
				}
				if (search)
					if(params[i])
						if (params[i].name == 'keyword')
							params[i].value = txtSearch.value;
				param.add(params[i].name,params[i].value);
			}
		}		
        SOAPClient.invoke(this.webService.url,this.webService.method,param, true, callBackBsx);
	}	
	
	var cmpBsxTable =this;
}