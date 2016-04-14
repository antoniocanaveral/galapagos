/**
 *Funcion publica. Permite crear un combo con datos de un servicio web
 *@constructor
 *@author Besixplus Cia. Ltda.
 */
function bsxComboBox(v){
	this.dom = document.createElement('select');	
	if (v.id)this.dom.id=v.id;
	
	if  (v.width)
		this.dom.style.width=v.width;
	this.eventListeners=v.eventListeners;
	this.webService =v.webService||null;	
	this.method=(this.webService)?this.webService.method:null;
	this.url=(this.webService)?this.webService.url:null;
	this.params=(this.webService)?this.webService.params:null;	
	this.valueField=v.valueField;
    this.displayField=v.displayField;
	this.isArray=false;
	this.renderTo=v.renderTo||"";
	this.dataSet=v.dataSet||null;
	if (!this.displayField)
		this.isArray=true;		
	var rndCtrl= document.getElementById(this.renderTo);			
	rndCtrl.innerHTML = "";
	rndCtrl.name=v.name||"";
	rndCtrl.appendChild(this.dom);
	this.events = v.events||null;
	var load = (this.events)?this.events.load:null;
}
bsxComboBox.prototype.setParam=function(n,v){
	for (i=0;i<this.webService.params.length;i++)
		if(this.webService.params[i].name ==n)
			this.webService.params[i].value=v;
}
bsxComboBox.prototype.getRowSelected=function(){
	for (i=0;i<this.dataSet.length;i++)
		if(this.dataSet[i][this.valueField] ==this.dom.value)
			return this.dataSet[i];
	return null;
}
bsxComboBox.prototype.reload=function(){
	var displayField1=this.displayField;
	var valueField1=this.valueField;
	this.dom.innerHTML="";
	var dom1=this.dom;
	var tmpThis =this;
	var loadTmp = (this.events)?this.events.load:null;
	if (this.isArray==true){
		for (var k=0;k<this.dataSet.length;k++){			
			var elOptNew = document.createElement('option');				
			elOptNew.value = this.dataSet[k][0];
			elOptNew.text = this.dataSet[k][1];
			try {
				this.dom.add(elOptNew, null);
			}catch(ex) {this.dom.add(elOptNew);}
		}
		
	}else{
		
		function loadData(dataSet){
			for (var k=0;k<dataSet.length;k++){
				var elOptNew = document.createElement('option');				
				elOptNew.value = dataSet[k][valueField1];
				elOptNew.text = dataSet[k][displayField1];
				try {
					dom1.add(elOptNew, null);
				}catch(ex) {dom1.add(elOptNew);}
			}
			tmpThis.dataSet= dataSet;
		}
		function loadDataCBX(v){
			try{	
				var tmpdataSet=eval("("+v+")");
				loadData(tmpdataSet);
				if(loadTmp)loadTmp(tmpdataSet);
			}catch(ex){
				//alertalert("loadDataCBX :"+v+" "+ex)
			}			
		}
		var param = new SOAPClientParameters();
		if (this.params.length>0 )
			for (i=0;i<this.params.length;i++)
				param.add(this.params[i].name,this.params[i].value)
		else
			param=null;
        SOAPClient.invoke(this.url,this.method,param, true, loadDataCBX);
	}
}