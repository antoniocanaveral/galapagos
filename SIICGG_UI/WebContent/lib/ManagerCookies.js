function ManagerCookies(){
	
	this.create = function Create(name,value,hours) {
		var expires='';
		if (hours) {			
			var auxFecha =new Date().addHours(hours);
			expires = "; expires="+auxFecha.toGMTString();
		}else{
			expires = "";
		}		
		document.cookie = name+"="+value+expires+"; path=/";
	}

	this.read = function Read(name) {
		var nameEQ = name + "=";
		var ca = document.cookie.split(';');
		for(var i=0;i < ca.length;i++) {
			var c = ca[i];
			while (c.charAt(0)==' ') c = c.substring(1,c.length);
			if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
		}
		return null;
	}

	this.erase = function Erase(name) {
		this.create(name,"",-3);
	}
}

ManagerCookies.prototype.create = function(inName,inValue,inHours){
	this.create(inName,inValue,inHours);
}

ManagerCookies.prototype.read = function(inName){
	this.read(inName);
}

ManagerCookies.prototype.erase = function(inName,inValue,inHours){
	this.erase(inName);
}
