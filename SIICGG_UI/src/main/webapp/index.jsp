<%@page import="java.sql.Connection"%>
<%@page import="com.besixplus.sii.db.ManagerConnection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.besixplus.sii.objects.DesktopSettings"%>
<%@page import="java.util.Map"%>


<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.FileFilter"%>
<%@ page import="com.besixplus.sii.util.Env" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Sistema inform&aacute;tico integral</title>
        <%
                    Connection tmpCon = null;
                    ArrayList<String> tmpObjects = null;
                    ArrayList<String> tmpDeps = null;

                    java.util.HashMap<String, com.besixplus.sii.objects.Cgg_sec_sesion> tmpSessions = (java.util.HashMap<String, com.besixplus.sii.objects.Cgg_sec_sesion>) request.getSession().getAttribute("sessions");
                    com.besixplus.sii.objects.Cgg_sec_sesion tmpSession = tmpSessions.get(request.getSession().getId());

                    if (tmpSession.getCUSU_CODIGO() == null) {
                        com.besixplus.sii.objects.Cgg_usuario tmpUsuario = new com.besixplus.sii.objects.Cgg_usuario();

                        tmpCon = ManagerConnection.getConnection();

                        tmpCon.setAutoCommit(false);
                        tmpUsuario.setCUSU_NOMBRE_USUARIO(request.getUserPrincipal().getName());
                        new com.besixplus.sii.db.Cgg_usuario(tmpUsuario).selectByUsername(tmpCon);

                        String ipAddress = request.getHeader("x-forwarded-for");
                        if (ipAddress == null) {
                            ipAddress = request.getHeader("X_FORWARDED_FOR");
                            if (ipAddress == null) {
                                ipAddress = request.getRemoteAddr();
                            }
                        }
                        String tmpZona = request.getParameter("timezone");
                        tmpSession.setCSSSN_IP(ipAddress);
                        tmpSession.setCUSU_CODIGO(tmpUsuario.getCUSU_CODIGO());
                        tmpSession.setCUSU_NOMBRE_USUARIO(tmpUsuario.getCUSU_NOMBRE_USUARIO());
                        tmpSession.setCSSSN_ZONA_TIEMPO(tmpZona);
                        tmpSession.setCSSSN_ACTIVO(true);

                        new com.besixplus.sii.db.Cgg_sec_sesion(tmpSession).insert(tmpCon);

                        tmpCon.commit();
                        tmpCon.close();

                    }
                    tmpCon = ManagerConnection.getConnection();
                    tmpCon.setAutoCommit(false);

                    com.besixplus.sii.objects.Cgg_configuracion tmpConf = new com.besixplus.sii.objects.Cgg_configuracion();
                    tmpConf.setCGCNF_CODIGO("CONF15");

                    new com.besixplus.sii.db.Cgg_configuracion(tmpConf).select(tmpCon);

                    int tmpActiveSessions = com.besixplus.sii.db.Cgg_sec_sesion.selectCountUserSession(tmpCon, request.getUserPrincipal().getName(), request.getSession().getId(), request.getContextPath());

                    if (tmpActiveSessions > 0) {
                        request.getSession().invalidate();
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('La cuenta de acceso \"" + request.getUserPrincipal().getName() + "\" ya esta en uso. Por favor contactese con el Administrador del sistema.');");
                        out.println("window.location='" + tmpConf.getCGCNF_VALOR_CADENA() + "';");
                        out.println("</script>");
                    } else {
                        tmpObjects = new com.besixplus.sii.db.Cgg_sec_objeto().getObjectsFor(tmpCon, request.getUserPrincipal().getName(), false);
                        tmpDeps = new com.besixplus.sii.db.Cgg_sec_objeto().getDepFor(tmpCon, request.getUserPrincipal().getName());
                    }

                    tmpCon.close();
        %>
        <LINK REL="SHORTCUT ICON" HREF="favicon.ico">
        <!--<script type="text/javascript" src="https://getfirebug.com/firebug-lite-debug.js"></script>
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="lib/extjs/resources/css/ext-all.css" />
        <link rel="stylesheet" type="text/css" href="lib/extjs/resources/css/ux-all.css" /> 
        <link rel="stylesheet" type="text/css" href="lib/extjs/resources/css/Spinner.css" />       
        <link rel="stylesheet" type="text/css" href="lib/extjs/resources/css/animated-dataview.css" />       
        <link rel="stylesheet" type="text/css" href="desktop/css/desktop.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/bsxStyle.css" />                
        <link type="text/css" href="lib/jit/css/base.css" rel="stylesheet" />
        <link type="text/css" href="lib/jit/css/Spacetree.css" rel="stylesheet" />
        <!-- ENDCSS -->

        <!-- LIBS -->
        <script type="text/javascript" src="lib/prototype.js"></script>

        <script type="text/javascript" src="lib/date.js"></script>        
        <script type="text/javascript" src="lib/extjs/adapter/ext/ext-base.js"></script>
        <script type="text/javascript" src="lib/extjs/ext-all.js"></script>
        <script type="text/javascript" src="lib/extjs/ux-all.js"></script>
        <script type="text/javascript" src="lib/extjs/CheckColumn.js"></script>       
        <script type="text/javascript" src="lib/extjs/SearchField.js"></script>
        <script type="text/javascript" src="lib/extjs/SoapProxy.js"></script>
        <script type="text/javascript" src="lib/extjs/WsdlContainer.js"></script>        
        <script type="text/javascript" src="lib/extjs/MsgPopup.js"></script>
        <script type="text/javascript" src="lib/extjs/ux-DataViewTransition.js"></script>
        <script type="text/javascript" src="lib/extjs/attachment.js"></script>
        <script type="text/javascript" src="lib/extjs/AlfrescoMng.js"></script>
        <%
                    java.io.File tmpFilesDeps = new java.io.File(request.getSession().getServletContext().getRealPath("/") + "lib" + java.io.File.separatorChar + "dep");
                    java.util.ArrayList<String> tmpJSLines = new java.util.ArrayList<String>();
                    File[] tmpFiles = tmpFilesDeps.listFiles(new FileFilter() {

                        public boolean accept(File pathname) {
                            return !pathname.getName().startsWith(".");
                        }
                    });
                    boolean tmpSW = false;
                    for (File tmpFile : tmpFiles) {
                        tmpSW = false;
                        if (request.isUserInRole("administrador")) {
                            tmpSW = true;
                        } else {
                            if (tmpObjects.contains("/" + tmpFile.getName())) {
                                tmpSW = true;
                            }
                        }
                        if (tmpSW) {
                            BufferedReader tmpBR = new BufferedReader(new FileReader(tmpFile));
                            String tmpLine = null;
                            while ((tmpLine = tmpBR.readLine()) != null) {
                                if (!tmpJSLines.contains(tmpLine)) {
                                    out.println(tmpLine);
                                    tmpJSLines.add(tmpLine);
                                }
                            }
                            tmpBR.close();
                        }
                    }
        %>
        <script type="text/javascript" src="lib/extjs/Spinner.js"></script>
        <script type="text/javascript" src="lib/extjs/SpinnerStrategy.js"></script>
        <script type="text/javascript" src="lib/extjs/AutoSizeColumns.js"></script>
        <script type="text/javascript" src="lib/extjs/ext-lang-es.js"></script>
        <script type="text/javascript" src="lib/extjs/MessageWindow.js"></script>
        <script type="text/javascript" src="lib/JasperServer.js"></script>
        <script type="text/javascript" src="forms/DlgUsuarioAC.js"></script>
        <script type="text/javascript" src="lib/CommonFunction.js"></script>
        <script type="text/javascript" src="lib/ManagerCookies.js"></script>
        <script type="text/javascript" src="lib/SoapClient.js"></script>		
        <script type="text/javascript" src="objects/Tramite.js"></script>
        <script type="text/javascript" src="objects/Reporte.js"></script>
        <!-- ENDLIBS -->		

        <!-- DESKTOP -->
        <script type="text/javascript" src="desktop/js/StartMenu.js"></script>
        <script type="text/javascript" src="desktop/js/TaskBar.js"></script>
        <script type="text/javascript" src="desktop/js/Desktop.js"></script>
        <script type="text/javascript" src="desktop/js/App.js"></script>
        <script type="text/javascript" src="desktop/js/Module.js"></script>

        <!-- INCLUIR LOS FORMULARIOS AQUI -->
        <script type="text/javascript" src="forms/FrmCriterioReporte.js"></script>
        <script type="text/javascript" src="forms/FrmAcercade.js"></script>
        <script type="text/javascript" src="forms/DlgIngresoFecha.js"></script>
        <%out.println(Env.loadExternalScripts("siicgg_ui/javascripts.properties"));%>
        <!--script type="text/javascript" src="forms/bsxExtras.js"></script-->
        <script type="text/javascript" src="forms/DlgBusqueda.js"></script>
        <script type="text/javascript" src="forms/DlgBusquedaNoPaginado.js"></script>
        <script type="text/javascript" src="forms/DlgSeleccionDespacho.js"></script>
        <script type="text/javascript" src="forms/DlgSeleccionDistribucion.js"></script>
        <script type="text/javascript" src="forms/DlgBusquedaObjDep.js"></script>
		<script type="text/javascript" src="forms/DlgExportableResidencia.js"></script>
        <script type="text/javascript" src="forms/FrmCgg_usuario_pvt.js"></script>
        <%
                    java.util.Map<String, String> tmpTitles = null;
                    if (request.isUserInRole("administrador")) {
                        out.println("<script type=\"text/javascript\" src=\"lib/sii.js\"></script>");
                        out.println("<script type=\"text/javascript\" src=\"desktop/deskConfig.js\"></script>");
                    } else if (request.isUserInRole("usuario")) {

                        if (tmpObjects != null) {
                            for (int i = 0; i < tmpObjects.size(); i += 2) {
                                String tmpObject = tmpObjects.get(i);
                                out.println("<script type=\"text/javascript\" src=\"forms" + tmpObject + "\"></script>");
                            }
                        }

                        if (tmpDeps != null) {
                            for (int j = 0; j < tmpDeps.size(); j++) {
                                String tmpDep = tmpDeps.get(j);
                                out.println("<script type=\"text/javascript\" src=\"forms" + tmpDep + "\"></script>");
                            }
                        }

                        DesktopSettings tmpDS = new DesktopSettings(request);
                        tmpTitles = tmpDS.getTitles();
                        out.println("<script type=\"text/javascript\" src=\"desktop/desk" + request.getUserPrincipal().getName() + ".js\"></script>");
                    }
        %>
        <script type="text/javascript" src="lib/reports.js"></script>

        <!-- ALFRESCO MNG-->
        <script type="text/javascript" src="lib/extjs/attachment.js"></script>
        <script type="text/javascript" src="lib/extjs/AlfrescoMng.js"></script>
    </head>
    <body scroll="no" id="body">
        <div id="x-desktop">
            <table width="100%" height="100%">
                <tr height="100px" rowspan="2">
                    <td width="20%">
                        <div id="divShortcuts" ><!--class="icon-heart"-->
                            <table width="100%" height="100%">
                                <tr><%
                                            if (request.isUserInRole("administrador")) {
                                                out.println("<td width=\"50%\">");
                                                out.println("<dl id=\"x-shortcuts\">");
                                                out.println("<dt id=\"FrmListadoCgg_res_tramite-subitem\"><a href=\"#\"><img src=\"resources/images/48x48/residencia.png\" /><div class=\"textDesktop\">Tramites</div></a></dt>");
                                                out.println("<dt id=\"FrmCgg_res_fase_general-subitem\"><a href=\"#\"><img src=\"resources/images/48x48/proceso.png\" /><div class=\"textDesktop\">Definicion proceso</div></a></dt>");
                                                out.println("<dt id=\"FrmListadoCgg_res_tipo_solicitud_tramite-subitem\"><a href=\"#\"><img src=\"resources/images/48x48/tiposolicitud.png\" /><div class=\"textDesktop\">Tipo de solicitudes</div></a></dt>");
                                                out.println("<dt id=\"FrmListadoCgg_res_persona-subitem\"><a href=\"#\"><img src=\"resources/images/48x48/persona.png\"/><div class=\"textDesktop\">Control persona</div></a></dt>");
                                                out.println("<dt id=\"FrmListadoCgg_res_seguimiento-subitem\"><a href=\"#\"><img src=\"resources/images/48x48/seguimiento.png\" /><div id=\"divLnkSeguimiento\" class=\"textDesktop\">Seguimiento de tramites</div></a></dt>");
                                                out.println("<dt id=\"FrmHistorialTramite-subitem\"><a href=\"#\"><img src=\"resources/images/48x48/historialTramite.png\" /><div class=\"textDesktop\">Historial tr&aacute;mite</div></a></dt>");
                                                out.println("</dl>");
                                                out.println("</td>");
                                            }
                                            if (tmpTitles != null) {
                                                tmpCon = ManagerConnection.getConnection();
                                                tmpCon.setAutoCommit(false);
                                                tmpObjects = new com.besixplus.sii.db.Cgg_sec_objeto().getObjectsFor(tmpCon, request.getUserPrincipal().getName(), true);
                                                String tmpObject = null;
                                                String tmpIconName = null;
                                                tmpSW = false;
                                                for (int i = 0; i < tmpObjects.size(); i += 2) {
                                                    tmpObject = tmpObjects.get(i);
                                                    if (i % 6 == 0 && tmpSW) {
                                                        out.println("</dl></td>");
                                                        tmpSW = false;
                                                    }
                                                    if (i % 6 == 0) {
                                                        out.println("<td width=\"50%\">");
                                                        out.println("<dl id=\"x-shortcuts\">");
                                                        tmpSW = true;
                                                    }
                                                    if (new java.io.File(request.getSession().getServletContext().getRealPath("/") + "resources" + java.io.File.separatorChar + "images" + java.io.File.separatorChar + "48x48" + java.io.File.separatorChar + tmpObject.substring(1, tmpObject.lastIndexOf(".")) + ".png").exists()) {
                                                        tmpIconName = tmpObject.substring(1, tmpObject.lastIndexOf("."));
                                                    } else {
                                                        tmpIconName = "services";
                                                    }
                                                    out.println("<dt id=\"" + tmpObject.substring(1, tmpObject.lastIndexOf(".")) + "-subitem\"><a href=\"#\"><img src=\"resources/images/48x48/" + tmpIconName + ".png\" /><div class=\"textDesktop\">" + tmpObjects.get(i + 1) + "</div></a></dt>");

                                                }
                                                tmpCon.close();
                                                if (tmpSW) {
                                                    out.println("</dl></td>");
                                                }
                                            }
                                    %>
                                </tr>
                            </table>
                        </div>
                    </td>
                    <td colspan="2" width="80%" valign="top"><a href="http://www.cgg.gob.ec/"
                                                                target="_blank" style="margin: 5px; float: right;"> <img
                                src="resources/images/cgg.png" /> </a>
                    </td>
                </tr>
                <tr>
                    <td>
                    </td>
                </tr>
                <tr style="height: 50px">
                    <td>
                        <div align="left"><span class="headline1"> Sistema integral inform&aacute;tico SIICGG</span><br></div>
                    </td>
                    <td>
                        <div align="center"><a href="http://www.besixplus.com"
                                               target="_blank" style="margin: 5px; float: right;"> <img
                                    src="resources/images/besixplus.png" /> </a></div>
                    </td>
                </tr>
            </table>            
        </div>
        <div id="ux-taskbar">
            <div id="ux-taskbar-start"></div>
            <div id="ux-taskbar-panel-wrap">
                <div id="ux-taskbuttons-panel"></div>                
            </div>
            <div id="ux-taskclock-panel"></div>
            <div class="x-clear"></div>
        </div>
    </body>
</html>
