/**
 * Administra la creacion de una url para la visualizacion de reportes de manera mas trasparente.
 * @param inReportName Nombre de reporte. Ejem. miReporte
 * @param inReportFolder Directorio del reporte Eje. /Reports/sii/gem
 * @param inParams Parametros del reporte en formato de objecto: 
 *  {
 *      param1:value1
 *      .
 *      .
 *      paramN:valueN
 *  }
 *
 */
function Reporte(inReportName,inReportFolder,inParams){
    var reportName = inReportName;
    var params = inParams;
    var urlReport = URL_REPORT;
    var output = OUTPUT_REPORT;

    this.show = function(inShow){
        urlReport+='&ParentFolderUri='+inReportFolder+'&reportUnit='+inReportFolder+'/'+inReportName+'&output='+output;
        var tmpParams = '';

        //Verificamos la existencia del reporte en el servidor jasper. Nueva funcionalidad.
        var param = new SOAPClientParameters();
        param.add('reportFolder', inReportFolder);
        param.add('reportName', inReportName);
        var jasperResponse = SOAPClient.invoke(URL_WS+'JasperServerService', "validateReport", param, false, null);

        if(jasperResponse) {
            jasperResponse = eval("(" + jasperResponse + ')'); //Convierte string a Objeto JSON
            if (jasperResponse.result == true) {

                for (var p in params) {
                    var value = eval('params.' + p);
                    urlReport += '&' + p + '=' + (value != undefined ? value : '');
                }
                if (inShow == undefined || inShow == true) {
                    try {
                        var open_link = window.open('');
                        open_link.location = urlReport;
                    } catch (inErr) {

                    }

                }
            }else {
                Ext.Msg.show({
                    title: "JasperServer",
                    msg: jasperResponse.errorMessage,
                    buttons: Ext.Msg.OK,
                    icon: Ext.MessageBox.ERROR
                });
            }
        }
    }

    this.getUrl = function(){
        this.show(false);
        return urlReport;
    }

}

/**
 * Visualiza el reporte.
 */
Reporte.prototype.show = function(){
    this.show();
}

Reporte.prototype.getUrl= function(){
    return this.getUrl();
}