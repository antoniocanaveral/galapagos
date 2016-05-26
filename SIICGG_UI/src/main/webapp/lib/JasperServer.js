/**
* Funcion JasperServer
* Encapsula las tareas de llamadas al servidor de reportes.
*
*/
function JasperServer(){
	this.myFormat = RPT_FORMAT;
	this.myReportFolder;
	this.myReportName;
	this.myParams = new Array();
	this.myUserName = 'user';
	this.myPassword = 'user'
	this.myTitle = 'JasperServer';
	/**
	* Agrega un parametro de reporte.
	* @param string inName Nombre del parametro.
	* @param string inValue Valor del parametro.
	*/
	this.addParam = function(inName, inValue){
		this.myParams[inName] = inValue;
	}
	/**
	* Establece la carpeta donde se encuentra el reporte dentro de la taxonomia del JasperServer
	* @param string inReportFolder Nombre de carpeta. Nota: la ruta inicia con / y termina sin /
	*/
	this.setReportFolder = function(inReportFolder){
		this.myReportFolder = inReportFolder;
	}
	/**
	* Establece el nombre del reporte que se quiere visualizar.
	* @param string in inReportName Nombre del reporte.
	*/
	this.setReportName = function(inReportName){
		this.myReportName = inReportName;
	}
	/**
	* Establece el formato de salida del reporte.
	* @param string inReportFormat Nombre del formato de salida del reporte (pdf,html,xls,...).
	*/
	this.setReportFormat = function(inReportFormat){
		this.myFormat = inReportFormat;
	}
	/**
	* Establece el nombre de usuario que tiene acceso al servidor de reportes.
	* @param string inUserName Nombre de usuario.
	*/
	this.setUserName = function(inUserName){
		this.myUserName = inUserName;
	}
	/**
	* Establece la clave de acceso del usuario del servidor de reportes.
	* @param string inPassword Clave de acceso del usuario.
	*/
	this.setPassword = function(inPassword){
		this.myPassword = inPassword;
	}
	
	/**
	* Establece el titulo utilizado por la ventana.
	* @param string Titulo de la ventana.
	*/
	this.setTitle = function(inTitle){
		this.myTitle = inTitle;
	}
	
	/**
	* Realiza la llamada al servidor de reportes para visualizar el reporte requerido
	* de acuerdo a los parametros establecidos.
	*/
	this.run = function(){
		var c = 0;
		var tmpParams='';
		//Verificamos la existencia del reporte en el servidor jasper. Nueva funcionalidad.
		var param = new SOAPClientParameters();
		param.add('reportFolder', this.myReportFolder);
		param.add('reportName', this.myReportName);
		var jasperResponse = SOAPClient.invoke(URL_WS+'JasperServerService', "validateReport", param, false, null);
		if(jasperResponse) {
			jasperResponse = eval("(" + jasperResponse + ')');
			if (jasperResponse.result == true) {
				for (var tmpParamName in this.myParams) {
					if (typeof(this.myParams[tmpParamName]) == 'function')
						break;
					if (c > 0)
						tmpParams += '&';
					tmpParams += tmpParamName + '=' + this.myParams[tmpParamName];
					c++;
				}
				window.open(URL_REPORT + '&j_username=' + this.myUserName + '&j_password=' + this.myPassword + '&output=' + this.myFormat + '&reportUnit=' + this.myReportFolder + '/' + this.myReportName + '&ParentFolderUri=' + this.myReportFolder + '&' + tmpParams, this.myTitle, 'location=no');
				this.myParams = new Array();
			} else {
				Ext.Msg.show({
					title: "JasperServer",
					msg: jasperResponse.errorMessage,
					buttons: Ext.Msg.OK,
					icon: Ext.MessageBox.ERROR
				});
			}
		}
	}
}