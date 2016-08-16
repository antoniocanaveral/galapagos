/**
 *Funcion publica. Permite crear un combo con datos de un servicio web
 *@constructor
 *@author Besixplus Cia. Ltda.
 */
function bsxMessageBox(v){	
	this.events = 	v.events||null;		
	this.title=v.title||"";
	this.msg=v.msg||""
	this.icon=v.icon||null;
	this.close = v.close||null;
	
	this.width=		v.width||275;
	this.height=	v.height||80;	
	
	/*Fondo transparente*/
	this.bmsgbBackground = null;
	if(document.getElementById("bmsgbBackground")!=null)
		this.bmsgbBackground = document.getElementById("bmsgbBackground");
	else {
		this.bmsgbBackground = document.createElement("div");
		this.bmsgbBackground.id = "bmsgbBackground";
		document.body.appendChild(this.bmsgbBackground);
	}
	
	/*div que contiene la ventana */
	this.bmsgbModal = null;
	if(document.getElementById("bmsgbModal")!=null)
		this.bmsgbModal = document.getElementById("bmsgbModal");
	else {
		this.bmsgbModal = document.createElement("div");
		this.bmsgbModal.id = "bmsgbModal";
		document.body.appendChild(this.bmsgbModal);
	}

	var tmp =document.getElementById("bsxMsgBox");
	tmp = (tmp)?null:null;
	this.bmsgbModal.innerHTML="<TABLE id='bsxMsgBox' border=1><TBODY></TABLE>";	
	
	this.component=	(document.all) ? document.all.bsxMsgBox : document.getElementById("bsxMsgBox");	
	this.component.style.cssText="width:"+this.width+";height:"+this.height;
	this.component.className ="bmsgbWindow" ;
	this.component.cellSpacing=0;
		
	this.component.border=0;
	this.THead = this.component.createTHead();
	this.TBody = this.component.tBodies[0];	
	this.TFoot = this.component.createTFoot();
		
	var tmpCell = this.THead.insertRow(-1).insertCell(-1);	
	tmpCell.innerHTML = this.title;
	
	var tmpCell = this.TBody.insertRow(-1).insertCell(-1);
	tmpCell.className="bmsgbMsg";
	var tmpDivIcon="";
	if (this.icon)
		tmpDivIcon ="<div id='iconMsg' class='iconMsg'>"
	tmpCell.innerHTML = tmpDivIcon + "</div><div style:'float:left;'>"+this.msg+"</div>";	
	var iconMsg=document.getElementById("iconMsg")||null;
	if (iconMsg)
		iconMsg.className ="iconMsg "+this.icon;
	
	var tmpCell = this.TFoot.insertRow(-1).insertCell(-1);
	tmpCell.innerHTML ="<button id='btnSalirBmsgb' style='float:right'>Aceptar</button>";	
	document.getElementById("btnSalirBmsgb").onclick=function(){
		if (cmpBsxMessageBox.close)
			cmpBsxMessageBox.close();
        document.body.removeChild(cmpBsxMessageBox.bmsgbBackground);
        document.body.removeChild(cmpBsxMessageBox.bmsgbModal);				
	}
	this.bmsgbBackground.style.display ="block";
	this.bmsgbModal.style.display ="block";	
	
	cmpBsxMessageBox=this;	
}
