<%@ page import="com.besixplus.sii.util.Env" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Adjuntos</title>

    <!--script type="text/javascript" src="js/config.js"></script-->
    <%out.println(Env.loadExternalScripts("siicgg_web/javascripts.properties"));%>

    <script type="text/javascript" src="lib/jquery/jquery.js"></script>
    <script type="text/javascript" src="lib/jquery/ui.core.min.js"></script>
    <script type="text/javascript" src="lib/jquery/ui.tabs.min.js"></script>
    <script type="text/javascript" src="lib/jquery/ui.datepicker.js"></script>
    <script type="text/javascript" src="lib/jquery/jquery.validate.js"></script>
    <script type="text/javascript" src="lib/jquery/jquery.tmpl.min.js"></script>
    <script type="text/javascript" src="lib/jquery/ui.dialog.js"></script>
    <script type="text/javascript" src="lib/jquery/jquery.dateFormat.js"></script>
    <!--script type="text/javascript" src="lib/jquery/ui.resizable.js"></script> <script type="text/javascript" src="lib/jquery/ui.draggable.js"></script-->
    <!--script type="text/javascript" src="js/tramiteResidencia.js"></script-->
    <!--script type="text/javascript" src="lib/validador.js"></script-->
    <script type="text/javascript" src="js/SoapClient.js"></script>
    <!--script type="text/javascript" src="js/bsxComboBox.js"></script-->
    <!--script type="text/javascript" src="js/Reporte.js"></script-->
    <!--script type="text/javascript" src="js/bsxTable.js"></script-->
    <!--script type="text/javascript" src="js/bsxMessageBox.js"></script-->
    <script type="text/javascript" src="lib/jquery/jquery.jstree.js"></script>
    <link rel="stylesheet" type="text/css" href="css/jquery/jquery-ui.css"/>
    <link rel="stylesheet" type="text/css" href="css/jquery/ui.all.css"/>
    <!--link rel="stylesheet" type="text/css" href="css/modulo.css"/-->
    <!--link rel="stylesheet" type="text/css" href="css/form.css"/-->
    <!--link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css"/-->
    <link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css"/>
    <link rel="stylesheet" type="text/css" href="css/jquery/jstree/style.css"/>

    <!--IMPORTS PARA ALFRESCO-->
    <link rel="stylesheet" type="text/css" href="lib/extjs/resources/css/ext-all.css" />
    <link rel="stylesheet" type="text/css" href="lib/extjs/resources/css/ux-all.css" />
    <script type="text/javascript" src="lib/extjs/adapter/ext/ext-base.js"></script>
    <script type="text/javascript" src="lib/extjs/ext-all.js"></script>
    <script type="text/javascript" src="lib/extjs/ux-all.js"></script>
    <script type="text/javascript" src="lib/extjs/SoapProxy.js"></script>
    <script type="text/javascript" src="lib/extjs/WsdlContainer.js"></script>
    <script type="text/javascript" src="lib/extjs/MsgPopup.js"></script>
    <script type="text/javascript" src="lib/extjs/ext-lang-es.js"></script>
    <script type="text/javascript" src="lib/extjs/MessageWindow.js"></script>
    <script type="text/javascript" src="lib/extjs/AlfrescoMng.js"></script>
    <script type="text/javascript" src="lib/extjs/attachment.js"></script>

    <style>
        /*Base sii*/
        .iconGuardar{background-image:url(css/image/actions/16x16/actions/filesave.png) !important;}
        .x-btn-noicon .x-btn-small .x-btn-text {
            font: 10px verdana;
            height: 16px;
            text-transform: none;
        }
        /*Alfresco*/
        .ecmTransparentBtn .x-btn td {background-image: none}
        .ecmDownload{background-image:url(css/image/ecm/16x16/ecm-download.png); !important;}
        .ecmDownload:hover{background-color: #ffeeee}
        .ecmUpload{background-image:url(css/image/ecm/16x16/ecm-upload.png); !important;}
        .ecmUpload:hover{background-color: #ffeeee}
        .ecmRefresh{background-image:url(css/image/ecm/16x16/ecm-refresh.png); !important;}
        .ecmRefresh:hover{background-color: #ffeeee}
        .ecmFile{white-space: normal; float:left; text-align: left;}
    </style>
</head>
<body>
    <script>
        var ALF_VIEWER_TIMER=10000;

        var query = location.search.substring(1);
        var parameters = {};
        var keyValues = query.split(/&/);
        for(var i=0;i<keyValues.length;i++){
            var keyValuePairs = keyValues[i].split(/=/);
            var key = keyValuePairs[0];
            var value = keyValuePairs[1];
            parameters[key] = value;
        }
        var alfrescoMng = new AlfrescoMng(decodeURIComponent(parameters.tableName)
                , decodeURIComponent(parameters.recordId)
                , decodeURIComponent(parameters.filter));
        alfrescoMng.show();
    </script>
</body>
</html>