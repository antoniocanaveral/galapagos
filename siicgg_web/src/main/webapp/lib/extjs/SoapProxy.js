Ext.namespace("Ext.ux.bsx");
Ext.ux.bsx.SoapProxy=function(o){
    Ext.ux.bsx.SoapProxy.superclass.constructor.call(this,o);
    this.conn=Ext.Ajax;
    Ext.apply(this,o);
};
Ext.extend(Ext.ux.bsx.SoapProxy, Ext.data.DataProxy,{
    load : function(params, reader, callback, scope, arg){
        if(this.fireEvent("beforeload", this, params) !== false){
            this.params= params.params || this.params;
            if (params){
                this.paginParams=params;
            }else{
                this.paginParams=null;
            }
			
            this.url=params.url || this.url;
            this.method=params.method || this.method;
            this.reader=reader || this.reader;
            this.callback=callback || this.callback;
            this.scope=scope || this.scope || this;
            this.arg=arg || this.arg || null;
            var wsdlOption={
                url: this.url,
                callback: this.loadWsdl,
                scope: this
            };
            Ext.ux.data.soap.WsdlContainer.loadWsdl(wsdlOption);
        }else{
            this.callback.call(this.scope, this.arg, false);
        }
    },
    loadWsdl : function(success, options) {
        var url=options.url;
        var wsdl=JSON.parse(Ext.ux.data.soap.WsdlContainer.cachedWsdl[url]);
        var xml=this.getXmlEnvelope(this.method,this.paginParams, JSON.parse(wsdl.namespaces));
        this.conn.request({
            url: url,
            callback : this.loadResponse,
            scope: this,
            xmlData : xml
        });
    },
    loadResponse : function(options, success, response) {
        delete this.activeRequest;
        if(!success){
            this.fireEvent("loadexception", this, options, response);
            this.callback.call(this.scope, null, this.arg, false);
            return;
        }
        var result;
        try {
            var bsxResponseText=this.bsxGetData(response.responseXML, "ns0:result");			
            if(bsxResponseText == "401"){
                Ext.Msg.show({
                    title:'Informaci&oacute;n',
                    msg: MSG_ACCESS_ERROR+this.url+'/'+this.method,
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
            }
            var JsonSoap={
                responseText:bsxResponseText
            };
            result=this.reader.read(JsonSoap, this.url, this.method);
        }catch(e){
			if (bsxResponseText==null)
				window.location = '/siiws/SessionManager?request=login';
            this.fireEvent("loadexception", this, options, response, e);
            this.callback.call(this.scope, null, this.arg, false);
            return;
        }
        this.fireEvent("load", this, options, this.arg);
        this.callback.call(this.scope, result, this.arg, true);
    },
    setPagin:function(ws){
        this.pagin = ws;
    },
    paginParams:[],
    getXmlEnvelope : function(method, params, namespaces) {
		
        var sr ="<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
        "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\""+namespaces[0]+"\""+
        " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" >"+
        "<soapenv:Header/>"+
        "<soapenv:Body>"+
        "<ws:"+ method + ">";
        if(this.paginParams.length>0 && this.pagin){
            for (fp=0;fp<this.paginParams.length;fp++){
                if(this.paginParams[fp].value !== null && this.paginParams[fp].value !== undefined){
                    sr+= "<"+this.paginParams[fp].name+">"+ this.paginParams[fp].value +"</"+this.paginParams[fp].name+">";
                }else{                     
                    sr=+ '<' + this.paginParams[fp].name + ' xsi:nil="true"/>';
                }
            }
        }
        if(params){
            var paramJSON;
            paramJSON = Ext.util.JSON.encode(params).slice(1, -1).split(',');
            if(paramJSON[0].length > 0){
                for (fp=0;fp<paramJSON.length;fp++){
                    var prm =paramJSON[fp].split(':');
                    var value = prm[1].replace(/\"/g,"")
                    if(prm[0].slice(1,-1) !== 'anode'){
                        if(value!==null && value!==undefined && value!=='null'){
                            sr=sr+"<"+prm[0].slice(1,-1)+">"+prm[1].replace(/\"/g,"") +"</"+prm[0].slice(1,-1)+">";
                        }else{
                            sr=sr+"<"+prm[0].slice(1,-1)+ ' xsi:nil="true"/>';
                        }
                    }
                }
            }
        }
        sr=sr + "</ws:"+ method + ">"+
        "</soapenv:Body>"+
        "</soapenv:Envelope>";
        return sr;
    },
    bsxGetData:function(req){
        var o = null;
        var nd = SOAPClient._getElementsByTagName(req, "ns0:result");
        if(nd.length == 0){
            nd = req.childNodes;
        }
        if(nd.length == 0){
            if(req.responseXML.getElementsByTagName("faultcode").length > 0){
                if(async || callback)
                    o = new Error(500, req.responseXML.getElementsByTagName("faultstring")[0].childNodes[0].nodeValue);
                else
                    throw new Error(500, req.responseXML.getElementsByTagName("faultstring")[0].childNodes[0].nodeValue);
            }
        }else
            o = SOAPClient._soapresult2object(nd[0], req);
        return o;
    }
});
