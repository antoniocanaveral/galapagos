/**
 *Funcion publica. Permite crear un combo con datos de un servicio web
 *@constructor
 *@author Besixplus Cia. Ltda.
 */
function bsxTabPanel(v){	
	this.events = 	v.events||null;		
	this.tabSelect = (v.events)?v.events.tabSelect:null;
	/*Array de objetos que corresponden a cada tab*/
	this.id=		v.id||null;
	this.width=		v.width||250;
	this.height=	v.height||150;
	this.renderTo=	v.renderTo||"";
	this.items=		v.items||[];
	var tmpId=(this.id)?"id='"+this.id +"'":"";
	document.getElementById(this.renderTo).innerHTML="<TABLE  "+ tmpId +" border=1><TBODY></TABLE>";	
	
	this.component=	(document.all) ? eval("document.all."+this.id) : document.getElementById(this.id);
	this.component.style.cssText="width:"+this.width;
	this.component.cellSpacing=0;
	this.component.cellPadding=0;
	this.component.border=0;
	this.THead = this.component.createTHead();
	this.TBody = this.component.tBodies[0];	
	
	//this.TFoot = this.component.createTFoot();
	
	var tmpRow =this.THead.insertRow(-1);
	for (var k=0;k<this.items.length;k++){
		if (this.items[k]){
			tmpRow.appendChild(document.createElement("TH")).className="tabBlanco";
			var tmpCell = tmpRow.appendChild(document.createElement("TH"));
			tmpCell.id ="tab"+this.items[k].contentId||null;		
			tmpCell.style.cssText ="width:"+this.items[k].width||20;		
			tmpCell.innerHTML=this.items[k].title||"";
			tmpCell.title=this.items[k].toolTip||"";
			tmpCell.className= "tabNoSelect";
			tmpCell.onclick=function(){
				var tmpId=(this.id.split("tab"))[1];
				var h = tmpCell;
				cmp.setVisible(tmpId);
				if(v.events){
					if(v.events.tabSelect){
						v.events.tabSelect(this.id);
					}
				}
			}
		}
	}	
	var tmpCell = tmpRow.appendChild(document.createElement("TH"));//tmpRow.insertCell(-1);
	tmpCell.innerHTML="&nbsp;";	
	tmpCell.className="tabBlancoFull";
	
	var tmpRow =this.THead.insertRow(-1);
	var tmpCell = tmpRow.insertCell(-1);
	tmpCell.colSpan = this.items.length*2+2;	
	this.setVisible=function( id ){	
		for (var k=0;k<this.items.length;k++){
			if (this.items[k]){
				var tmpVar = document.getElementById(this.items[k].contentId);
				if(tmpVar){
					tmpVar.style.cssText= "display:none";
					document.getElementById("tab"+this.items[k].contentId).className="tabNoSelect";
				}
			}
		}
		document.getElementById("tab"+id).className="tabSelect";
		var tmpVar = document.getElementById(id);
		tmpVar.style.cssText="display:block";
		
	}
	var tmpRow=this.TBody.insertRow(-1);
	var tmpCell=tmpRow.insertCell(-1);
	tmpCell.className="cssRowBody";
	for (var k=0;k<this.items.length;k++){
		if (this.items[k]){
			tmpCell.colSpan = this.items.length*2+2;
			var tmpVar = document.getElementById(this.items[k].contentId);		
			tmpCell.appendChild(tmpVar);
			if(tmpVar){
				tmpVar.style.cssText= "display:none";			
			}
		}
	}
	this.setVisible(this.items[0].contentId);

	cmp=this;	
}
