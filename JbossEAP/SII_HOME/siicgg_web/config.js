var URL_SERVER= document.URL.split('/')[2];
var URL_WS ="/siiws/";
var URL_WS_PUBLIC ="/siiws/PublicWS/";
var URL_APP="/siicgg_web/";
var URL_DOC_VIEWER="/siiws/DocViewer";
var URL_SESSION='/siiws/Private/SessionManager';
var APP_TITLE='SIICGG';
var OUTPUT_REPORT='pdf';
//var URL_REPORTS_SERVER='/jasperserver/flow.html?_flowId=viewReportFlow&j_username=user&j_password=user';
//var URL_REPORT='/jasperserver/flow.html?_flowId=viewReportFlow&standAlone=true&j_username=sii&j_password=sii';
//var URL_REPORT='http://'+document.domain+':8081/jasperserver/flow.html?_flowId=viewReportFlow&standAlone=true&j_username=sii&j_password=sii';
var URL_REPORT='http://sii.gobiernogalapagos.gob.ec:8081/jasperserver/flow.html?_flowId=viewReportFlow&standAlone=true&j_username=sii&j_password=sii';
//var URL_REPORT='http://190.95.187.82:8081/jasperserver/flow.html?_flowId=viewReportFlow&standAlone=true&j_username=sii&j_password=sii';
var MSG_ACCESS_ERROR = 'Acceso no autorizado, por favor consulte con el Administrador del Sistema. ';
var ERR_MESSAGE='Por favor pongase en contacto con el administrador o proveedor de software informando la secci\u00F3n, fecha y hora del problema.\nLe pedimos disculpas por las molestias ocasionadas.'
var RECORD_PAGE = 30;
var msgUsuarioLogin = 'Para utilizar esta secci\u00F3n del portal usted debe poseer una cuenta de usuario y estar habilitado en el sistema.<br>Si ya tiene una cuenta de usuario y una clave por favor de click <span id="spanMsgUsuarioLogin" style="cursor:pointer"><b>aqu\u00ed</b></span>.<br>  Si no lo est\u00e1, comun\u00edquese con el administrador del sistema.';
var codigoModulo;
if ('https://'+URL_SERVER+URL_APP != document.URL && 'https://'+URL_SERVER+URL_APP+'index.jsp' != document.URL)
	if('https://'+URL_SERVER+URL_APP+'bienvenida.jsp?CWPAG_CODIGO=CWPAG1' != document.URL )
		new ManagerCookies().create ('page',document.URL,1);
/*var TypeDateFormat = {
	ISO8601Long:"Y-m-d H:i:s",
    ISO8601Short:"Y-m-d",
	CGG:'d/m/Y'
}*/
var TypeFormat ={
    JSON:"JSON",
    XML:"XML"
};

function $(id) {  
    controlWeb = document.getElementById(id);
	return controlWeb;
}
function $$(id) {  
    controlWeb = document.getElementById(id);
	return controlWeb;
}


function getErrorMessage(err){
	return err.substr(6);
}

/**
*Modifica el tamanio del frame dinamicamente
*/
function setHeightForm(h){
	try{
		var padre = parent.document.getElementById('iFrameBody');
		var body1=document["body"];
		var lenForm =0;
		if (document.all){
			lenForm = (h)?h:(body1.scrollHeight);			
		}else{
			parent.document.getElementById('iFrameBody').height =0;			
			if (String(navigator.appVersion).indexOf('Opera'))
				lenForm = (body1.scrollHeight);
			else
				lenForm = (body1.offsetHeight);
		}
		parent.document.getElementById('iFrameBody').height = lenForm+20;
	}catch(e){				
	}			
}	

function ManagerCookies(){
	this.create = function Create(name,value,hours) {
		var expires='';
		if (hours) {			
			var auxFecha =new Date().setHours(hours);			
			expires = "; expires="+auxFecha;
		}else{
			expires = "";
		}		
		document.cookie = name+"="+value+expires+"; path=/";
	};

	this.read = function Read(name) {
		var nameEQ = name + "=";
		var ca = document.cookie.split(';');
		for(var i=0;i < ca.length;i++) {
			var c = ca[i];
			while (c.charAt(0)==' ') c = c.substring(1,c.length);
			if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
		}
		return null;
	};

	this.erase = function Erase(name) {
		this.create(name,"",-3);
	};
}

ManagerCookies.prototype.create = function(inName,inValue,inHours){
	this.create(inName,inValue,inHours);
};

ManagerCookies.prototype.read = function(inName){
	this.read(inName);
};

ManagerCookies.prototype.erase = function(inName,inValue,inHours){
	this.erase(inName);
};

