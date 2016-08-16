<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
    <script type="text/javascript" src="js/config.js"></script>
    <script type="text/javascript" src="lib/jquery/jquery.js"></script>
    <script type="text/javascript" src="lib/jquery/jquery.validate.js"></script>
    <script type="text/javascript" src="lib/jquery/jquery.tmpl.min.js"></script>
    <script type="text/javascript" src="js/SoapClient.js"></script>
    <script type="text/javascript" src="js/bsxComboBox.js"></script>
    <script type="text/javascript" src="js/consultaTramite.js"></script>


    <link rel="stylesheet" type="text/css" href="css/jquery/ui.all.css"/>
    <link rel="stylesheet" type="text/css" href="css/modulo.css"/>
    <link rel="stylesheet" type="text/css" href="css/form.css"/>

    <style type="text/css">
        .form-label {
            width: 150px !important;
        }

        .form-label-left {
            width: 150px !important;
        }

        .form-line {
            padding: 10px;
        }

        .form-label-right {
            width: 150px !important;
        }

        .form-all {
            width: 650px;
            font-family: "Trebuchet MS";
            font-size: 12px;
        }

        #myDiv {
            background-image: url(css/image/com.gif);
            background-repeat: no-repeat;
            background-position: 400px 5px;
            padding-top: 0px;
            text-align: justify;
            background-color: #ebf8fc;
            border-radius: 10px;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
        }

        div.divTramite {
            width: 98%;
            margin: 1%;
            padding: 10px
        }

        table#tableSeguimiento {
            text-align: center;
            margin-left: auto;
            margin-right: auto;
            width: 90%;
            border-spacing: 5px 5px;
            border-collapse: collapse;
            font-family: verdana, arial;
            font-size: 10pt
        }

        .font {
            font-family: verdana, arial;
            font-size: 10pt
        }

        #tableSeguimiento tbody tr.even td {
            background-color: #eee;
        }

        #tableSeguimiento tbody tr.odd td {
            background-color: #fff;
        }

        tr, td {
            text-align: left;
        }

        th {
            text-align: center;
        }

        th:hover {
            cursor: pointer;
        }

        #divInfoTramite {
            background-image: url(css/image/tramite.png);
            background-repeat: no-repeat;
            background-position: top center;
            padding-top: 0px;
            text-align: justify;
            height: 48px;
        }

        .divTramiteGeneral {
            background-image: url(css/image/tramite.png);
            background-repeat: no-repeat;
            background-position: top center;
            padding-top: 0px;
            text-align: justify;
            height: 48px;
        }

        .divSeguimiento {
            background-image: url(css/image/nodo.png);
            background-repeat: no-repeat;
            background-position: top center;
            padding-top: 0px;
            text-align: justify;
            height: 48px;
        }

        .divSeguimientoAtendido {
            background-image: url(css/image/despachado.png);
            background-repeat: no-repeat;
            background-position: top center;
            padding-top: 0px;
            text-align: justify;
            height: 48px;
        }

        .divSeguimientoPendiente {
            background-image: url(css/image/pendiente.png);
            background-repeat: no-repeat;
            background-position: top center;
            padding-top: 0px;
            text-align: justify;
            height: 48px;
        }

        .link {

        }
    </style>

</head>
<body SCROLLING="AUTO">
<input type="hidden" id="txtUsuario"
       value=<% try{ out.println(request.getUserPrincipal().getName()); }catch(Exception ex){ out.println(false); } %>/></input>
<div class="tituloPrincipal">Consulta de tr&aacute;mites</div>
<div class="descripcionPrincipal">Ahora usted puede de manera
    &aacute;gil consultar en donde se halla su tr&aacute;mite sin necesidad
    de acercarse personalmente.
</div>
<br/>
<br/>
<div id="divLogineo" style="display: none; width: 646" class="divAviso"></div>
<div style="padding-top: 10px; overflow: auto;">
    <div class="form-all" style="display: none" id="divFrmConsultaTramite">
        <div id="myDiv">
            <li class="form-line"><label class="form-label-left"
                                         id="lblNumeroTramite" for="txtNumeroTramite"> N&uacute;mero de
                tr&aacute;mite: </label>
                <div class="form-input"><input type="text" class="form-textbox"
                                               id="txtNumeroTramite" name="txtNumeroTramite" size="20"/>
                    <button id="btnBuscarEstadoTramite"><img
                            src="css/icon/buscar.png"/></button>
                    <label class="form-sub-label" for="txtNumeroTramite" id="lblFormato">
                        (Ej: 2011-145)</label></div>
            </li>
            <li class="form-line"><label class="form-label-left"
                                         id="llblBuscar"> <b>Buscar por : </b></label> <input type="radio"
                                                                                              name="rdbtnBuscar"
                                                                                              value="0"
                                                                                              checked="checked"
                                                                                              id="rdMasculino"/> <label
                    for="rdMasculino">Por n&uacute;mero de tr&aacute;mite</label> <input
                    type="radio" name="rdbtnBuscar" value="1" id="rdFemenino"/> <label
                    for="rdFemenino">No. doc. identificaci&oacute;n</label></li>
            <!--<div class="form-input" style="padding:10 5 5 5; color:rgb(255, 82, 0)">
                                 <span>Ahora usted puede de manera &aacute;gil consultar en donde se halla su tr&aacute;mite sin necesidad de acercarse personalmente.</span>
                                 </div>--></div>
        <div id='divOpciones'
             style="padding-top: 20px; float: right; display: none; width: 10%">
            <button id="btnImprimirRequisitos"><img
                    src="css/icon/revert.png"/>Volver
            </button>
        </div>
        <div id="divTramite" class="divTramite"></div>

    </div>
</div>
</body>
</html>