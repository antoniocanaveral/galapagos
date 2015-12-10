Ext.namespace("Ext.ux.data.soap.WsdlContainer");

Ext.ux.data.soap.WsdlContainer.cachedWsdl = (supports_html5_storage() == true) ? localStorage : new Array() ;

Ext.ux.data.soap.WsdlContainer.getWsdl = function(o) {
	var url = o.url;
	var callback = o.callback || function() { };
	var scope = o.scope || Ext.ux.data.soap.WsdlContainer;
	Ext.ux.data.soap.WsdlContainer.loadWsdl(url, callback, scope);
}
Ext.ux.data.soap.WsdlContainer.loadWsdl = function(o) {
	if(!Ext.ux.data.soap.WsdlContainer.cachedWsdl[o.url]) {
		Ext.Ajax.request({
			url: o.url,
			callback: Ext.ux.data.soap.WsdlContainer.loadWsdlCallback,
			params: 'wsdl',
			disableCaching: false,
			method: 'GET',
			request: {callback: o.callback, scope: o.scope, options: o}
		});
	} else o.callback.call(o.scope, true, o);
}
Ext.ux.data.soap.WsdlContainer.loadWsdlCallback = function(options, success, response) {
	var xml = response.responseXML;	
	if (response.responseText.substring(0,38)=='<?xml version="1.0" encoding="UTF-8"?>')
		window.location = '/siiws/SessionManager?request=login';
	var namespaces = new Array();
	namespaces.push((xml.documentElement.attributes["targetNamespace"] + "" == "undefined") ? xml.documentElement.attributes.getNamedItem("targetNamespace").nodeValue : xml.documentElement.attributes["targetNamespace"].value);
	var master = xml.getElementsByTagName("schema");
	var types = Ext.ux.data.soap.WsdlContainer.getTypesFromWsdl(xml);
	var wsdl = {namespaces:namespaces, types: types};        
        Ext.ux.data.soap.WsdlContainer.cachedWsdl[options.url] = JSON.stringify(wsdl);
	options.request.callback.call(options.request.scope, success, options);
}
Ext.ux.data.soap.WsdlContainer.getTypesFromWsdl = function(wsdl) {
	var wsdlTypes = new Array();
	var ell = wsdl.getElementsByTagName("s:element");	
	var useNamedItem = true;
	if(ell.length == 0)	{ell = wsdl.getElementsByTagName("element");useNamedItem = false;}
	for(var i = 0; i < ell.length; i++)	{
		if(useNamedItem){
			if(ell[i].attributes.getNamedItem("name") != null && ell[i].attributes.getNamedItem("type") != null) 
				wsdlTypes[ell[i].attributes.getNamedItem("name").nodeValue] = ell[i].attributes.getNamedItem("type").nodeValue;
		}else{
			if(ell[i].attributes["name"] != null && ell[i].attributes["type"] != null)
				wsdlTypes[ell[i].attributes["name"].value] = ell[i].attributes["type"].value;
		}
	}
	return wsdlTypes;
}

function supports_html5_storage() {
    try {
        return 'localStorage' in window && window['localStorage'] !== null;
    } catch (e) {
        return false;
    }
}
