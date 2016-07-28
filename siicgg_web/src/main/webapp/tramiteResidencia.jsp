<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
    <script type="text/javascript" src="js/config.js"></script>
    <script type="text/javascript" src="lib/jquery/jquery.js"></script>
    <script type="text/javascript" src="lib/jquery/ui.core.min.js"></script>
    <script type="text/javascript" src="lib/jquery/ui.tabs.min.js"></script>
    <script type="text/javascript" src="lib/jquery/ui.datepicker.js"></script>
    <script type="text/javascript" src="lib/jquery/jquery.validate.js"></script>
    <script type="text/javascript" src="lib/jquery/jquery.tmpl.min.js"></script>
    <script type="text/javascript" src="lib/jquery/ui.dialog.js"></script>
    <script type="text/javascript" src="lib/jquery/jquery.dateFormat.js"></script>
    <!--script type="text/javascript" src="lib/jquery/ui.resizable.js"></script> <script type="text/javascript" src="lib/jquery/ui.draggable.js"></script-->
    <script type="text/javascript" src="js/tramiteResidencia.js"></script>
    <script type="text/javascript" src="lib/validador.js"></script>
    <script type="text/javascript" src="js/SoapClient.js"></script>
    <script type="text/javascript" src="js/bsxComboBox.js"></script>
    <script type="text/javascript" src="js/Reporte.js"></script>
    <script type="text/javascript" src="js/bsxTable.js"></script>
    <script type="text/javascript" src="js/bsxMessageBox.js"></script>
    <script type="text/javascript" src="lib/jquery/jquery.jstree.js"></script>
    <link rel="stylesheet" type="text/css" href="css/jquery/jquery-ui.css"/>
    <link rel="stylesheet" type="text/css" href="css/jquery/ui.all.css"/>
    <link rel="stylesheet" type="text/css" href="css/modulo.css"/>
    <link rel="stylesheet" type="text/css" href="css/form.css"/>
    <link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css"/>
    <link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css"/>
    <link rel="stylesheet" type="text/css" href="css/jquery/jstree/style.css"/>
    <style type="text/css">
        .Visible {
            display: block;
        }

        .Invisible {
            display: none;
        }

        .form-label {
            width: 150px !important;
        }

        .form-label-left {
            width: 150px !important;
        }

        .form-line {
            padding: 3px;
        }

        .form-label-right {
            width: 150px !important;
        }

        .form-all {
            /*width: 650px;*/
            /*)color:#000000 !important;
                        (*/
            /*) font-family:"Arial Black";
                           (*/
            font-size: 10px;
        }

        .form-all > fieldset {
            margin-bottom: 5px;
        }

        #tabs {
            margin-top: 5px;
        }

        td.hovered {
            background-color: lightblue;
            color: #666;
        }

        div.divTramite {
            font-size: 10px;
        }
        .divTranseuntes{
            display:none;
        }
        .tabBeneficiario{
            display:block;
        }

        #cbxTipoResidenciaPadre > option[value="CRTST65"] {
            display: none;
        }
    </style>
    <!--ALFRESCO-->
    <script>
        function PopupCenter(url, title, w, h) {
            // Fixes dual-screen position                         Most browsers      Firefox
            var dualScreenLeft = window.screenLeft != undefined ? window.screenLeft : screen.left;
            var dualScreenTop = window.screenTop != undefined ? window.screenTop : screen.top;

            var width = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth ? document.documentElement.clientWidth : screen.width;
            var height = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight ? document.documentElement.clientHeight : screen.height;

            var left = ((width / 2) - (w / 2)) + dualScreenLeft;
            var top = ((height / 2) - (h / 2)) + dualScreenTop;
            var newWindow = window.open(url, title, 'scrollbars=yes, width=' + w + ', height=' + h + ', top=' + top + ', left=' + left);

            // Puts focus on the newWindow
            if (window.focus) {
                newWindow.focus();
            }
        }
    </script>
</head>
<body>
<input type="hidden" id="txtUsuario"
       value=<% try {
    out.println(request.getUserPrincipal().getName());
} catch (Exception ex) {
    out.println(false);
} %>/></input>
<div class="tituloPrincipal" style="padding-top: 8px">Registro de
    tr&aacute;mites de residencia
</div>
<div class="descripcionPrincipal">El formulario permite registrar
    e iniciar un tramite de residencia
</div>
<br/>
<br/>
<div id="divLogineo" style="display: none; width: 646px" class="divAviso"></div>
<div class="jotform-form" id="myForm" style="display: none">
    <div class="form-all">
        <fieldset>
            <legend><b>Datos tr&aacute;mite</b></legend>

            <%--MO--%>
            <div class="form-line"><label class="form-label-left"
                                         id="lblTipoTramite" for="divTipoTramite"> Tipo de tramite:</label>
                <div class="form-input">
                    <div id='divTipoTramite'></div>
                </div>
                <label class="obligatorio">(*)</label></div>
            <%----%>

            <div class="form-line"><label class="form-label-left"
                                         id="lblIslaTramite" for="divIslaTramite"> Lugar registro:</label>
                <div class="form-input">
                    <div id='divIslaTramite'></div>
                </div>
                <label class="obligatorio">(*)</label></div>

            <div class="form-line">
                <label class="form-label-left"
                                         id="lblTipoResidencia" for="divTipoResidenciaPadre"> Tipo residencia </label>
                <div class="form-input">
                    <div id='divTipoResidenciaPadre'></div>
                </div>
                <label class="obligatorio">(*)</label>
            </div>
            <!--li class="form-line">
                                    <label class="form-label-left" id="llblMotivoResidencia" for="divTipoSolicitudResidencia">
                                        Motivo residencia
                                    </label>
                                    <div class="form-input">
                                        <div id='divTipoSolicitudResidencia'></div>
                                    </div>
                                    <label class="obligatorio">(*)</label>
                                </li-->
            <div class="form-line">
                <label class="form-label-left"
                                         id="llblMotivoResidencia" for="txtMotivoResidencia"> Motivo residencia </label>
                <div class="form-input">
                    <input type="text" class="form-textbox"
                                               name="txtMotivoResidencia" id="txtMotivoResidencia" size="42"/>
                    <label class="obligatorio">(*)</label>
                    <button id="btnBuscarMotivo" title="Buscar motivo"><img
                            src="css/icon/buscar.png"/></button>
                </div>
            </div>
            <div id="divRepresentante" style="display: none;">
                <div class="form-line">
                    <label class="form-label-left" id="lblRepresentante" for="txtRepresentante">Representante</label>
                    <input class="form-textbox" type="text" name="txtRepresentante" id="txtRepresentante" size="42"/>
                    <label class="obligatorio">(*)</label>
                </div>
            </div>
            <div id="divDatosTranseunte" style="display: none;">
                <div class="form-line">
                    <label class="form-label-left" id="lblFechasResidencia" for="dtFechaIngreso">Tiempo Autorizado</label>
                    <div class="form-input">
                        <span class="form-sub-label-container">
                            <input class="form-textbox" type="text" name="dtFechaIngreso" id="dtFechaIngreso" size="19"/>
                            <label class="obligatorio">(*)</label>
                            <label class="form-sub-label" id="llblFechaIngreso" for="dtFechaIngreso">Fecha ingreso</label>
                        </span>
                        <span class="form-sub-label-container">
                            <input class="form-textbox" type="text" name="dtFechaSalida" id="dtFechaSalida" size="19"/>
                            <label class="obligatorio">(*)</label>
                            <label class="form-sub-label" id="llblFechaSalida" for="dtFechaSalida">Fecha salida</label>
                        </span>
                        <!--span class="form-sub-label-container">
                            <input class="form-textbox" type="text" name="txtTiempoAutorizado" id="txtTiempoAutorizado" disabled/>
                            <label class="form-sub-label" id="llblTiempoAutorizado" for="txtTiempoAutorizado">D&iacute;as</label>
                        </span-->
                    </div>
                </div>
            </div>
            <div id="divDatosActividad" style="display: none;">
                <div class="form-line">
                    <label class="form-label-left" id="lblActividad" for="divActividad"> Actividad:</label>
                    <div class="form-input"><div id='divActividad'></div></div>
                    <label class="obligatorio">(*)</label>
                </div>
                <div class="form-line">
                    <label class="form-label-left" id="lblObservacion" for="txtObservacion"> Observaci&oacute;n:</label>
                    <div class="form-input">
                        <textarea class="form-textarea-limit" cols=36 rows = 5 type="text" name="txtObservacion" id="txtObservacion"></textarea>
                    </div>
                    <label class="obligatorio">(*)</label>
                </div>
            </div>
        </fieldset>
        <fieldset>
            <legend><b>Informaci&oacute;n auspiciante</b></legend>
            <ul class="form-section">
                <div class="form-line"><label class="form-label-left"
                                              id="lblCrper_identificacion"> Tipo identificaci&oacute;n </label>
                    <div class="form-input"><input type="text" class="form-textbox"
                                                   id="txtIdentificacionAuspiciante" name="txtIdentificacionAuspiciante"
                                                   size="42"/></div>
                </div>
                <div id="divCargando1" class="cargando"
                     style="z-index: 10;display: none; position: fixed;"><span>Cargando...</span></div>
                <div class="form-line"><label class="form-label-left"
                                              id="lblNumDocAuspiciante" for="txtNumDocAuspiciante"> No. doc.
                    identific </label>
                    <div class="form-input"><input type="text" class="form-textbox"
                                                   id="txtNumDocAuspiciante" name="txtNumDocAuspiciante" size="42"/>
                    </div>
                </div>
                <div class="form-line"><label class="form-label-left"
                                              id="lblAuspiciante" for="txtNombreAuspiciante"> Auspiciante </label>
                    <div class="form-input"><span class="form-sub-label-container">
	<input class="form-textbox" type="text" size="42"
           name="txtNombreAuspiciante" id="txtNombreAuspiciante"/> <label
                            class="form-sub-label" for="txtNombreAuspiciante"
                            id="lblNombreAuspiciante1"> Nombres y Apellidos </label> </span></div>
                </div>
                <div id="divEmpresa" class="form-line" style="display: none"><label
                        class="form-label-left" id="lblAuspiciantePJ"
                        for="txtNombreAuspiciantePJ"> Empresa </label>
                    <div class="form-input"><span class="form-sub-label-container">
	<input class="form-textbox" type="text" size="42"
           name="txtNombreAuspiciantePJ" id="txtNombreAuspiciantePJ"/> </span></div>
                </div>

                <div class="form-line"><label class="form-label-left"
                                             id="lblNumResidenciaAuspiciante" for="txtNumResidenciaAuspiciante">
                    No. residencia </label>
                    <div class="form-input"><input type="text" class="form-textbox"
                                                   id="txtNumResidenciaAuspiciante" name="txtNumResidenciaAuspiciante"
                                                   size="42"/></div>
                </div>
            </ul>
        </fieldset>

        <div id="divResidenciasVigentes" style="width: 100%; display:none; ">
            <div class="divAviso" style="margin: 10px;">Seleccione un registro para continuar</div>
            <fieldset style="font-size: 11px"><legend><b>Listado de Residencias Vigentes</b></legend>
                <input class="form-textbox" type="text" name="txtBuscarBeneficiario" id="txtBuscarBeneficiario" size="25" style="margin-top: 5px; margin-bottom: 5px;" placeholder='Buscar por No Documento'/>
                <div id="vigentesSizing" style="display: inline-block; max-height: 300px; overflow-y: scroll; width: 100%;">
                    <table style="width: 100%;" border="0" align="center" cellspacing="0" cellpadding="0">
                        <tbody>
                        <tr>
                            <td colspan="2">
                                <form action="" id="frmResidenciaPersona" method="get">
                                    <table class="tabla" cellspacing="0" width="100%" border="0" id='tblResidenciaPersona' style="font-size: 11px; border: 1px solid #CCCCCC">
                                        <thead style="border-bottom: 1px solid #CCCCCC; width: 100%">
                                        <tr height="30px">
                                            <th width="400">
                                                <div align="left">Auspiciado</div>
                                            </th>
                                            <th width="300">
                                                <div align="left">Tipo de Residencia</div>
                                            </th>
                                            <th width="200">
                                                <div align="left">Fecha Ingreso</div>
                                            </th>
                                            <th width="200">
                                                <div align="left">Fecha Caducidad</div>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody style="width: 100%; height: 120; overflow: auto; display: block"></tbody>
                                    </table>
                                </form>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </fieldset>
        </div>

        <div id="divMultiTranseuntes" style="width: 100%" class="divTranseuntes">
            <fieldset style="font-size: 11px"><legend><b>Listado de beneficiarios transeuntes</b></legend>
                <table style="width: 100%;" border="0" align="center" cellspacing="0" cellpadding="0">
                    <tbody>
                    <tr>
                        <td>
                            <table style="font-size: 11px; border: 1px solid transparent"
                                   border="0" cellspacing="0">
                                <tbody>
                                <tr>
                                    <td>
                                        <button id="btnTranAgregar" type="button"><img src="css/icon/add.png" alt="add" />A&ntilde;adir</button>
                                    </td>
                                    <td>
                                        <button id="btnTranEliminar" type="button"><img src="css/icon/remove.png" alt="remove" />Borrar</button>
                                    </td>
                                    <td>
                                        <button id="btnTranEditar" type="button"><img src="css/icon/edit.png" alt="edit" />Editar</button>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <form action="" id="frmPersonaRegistro" method="get">
                                <table class="tabla" cellspacing="0" width="100%" border="0" id='tblPersona' style="font-size: 11px; border: 1px solid #CCCCCC">
                                    <thead style="border-bottom: 1px solid #CCCCCC; width: 100%">
                                        <tr height="30px">
                                            <th width="80">
                                                <div align="left">Tipo</div>
                                            </th>
                                            <th width="80">
                                                <div align="left">N&uacute;mero D.</div>
                                            </th>
                                            <th width="110">
                                                <div align="left">Nombres</div>
                                            </th>
                                            <th width="110">
                                                <div align="left">Primer Apellido</div>
                                            </th>
                                            <th width="110">
                                                <div align="left">Segundo Apellido</div>
                                            </th>
                                            <th width="80">
                                                <div align="left">Pa&iacute;s Residencia</div>
                                            </th>
                                            <th width="80">
                                                <div align="left">Nacionalidad</div>
                                            </th>
                                            <th width="100">
                                                <div align="left">F. nacimiento</div>
                                            </th>
                                            <th width="50">
                                                <div align="left">G&eacute;nero</div>
                                            </th>
                                            <th width="80" class="Invisible">
                                                <div align="left">Estado</div>
                                            </th>
                                            <th class="Invisible">
                                                <div align="left">Codigo Tramite</div>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody style="width: 100%; height: 120; overflow: auto; display: block"></tbody>
                                </table>
                            </form>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </div>





        <div id="tabs">
            <ul>
                <li id="liAuspiciado"><a href="#divAuspiciado" class="tabBeneficiario"><b>Informaci&oacute;n Beneficiario</b></a></li>
                <li><a href="#divContacto"><b>Contactos del Auspiciante</b></a></li>
                <li><a href="#divRequisitos"><b>Requisitos del tramite</b></a></li>
                <li><a href="#divDocumentacion"><b>Documentos para el tramite</b></a></li>
            </ul>
            <div id="divAuspiciado" style="width: 100%" class="tabBeneficiario">
                <div id="personaForm">
                    <ul class="form-section">
                        <div class="form-line">
                            <label class="form-label-left"
                                   id="lblIdentificacionBeneficiario"
                                   for="divTipoIdentificacionBeneficiario"> Tipo identificaci&oacute;n </label>
                            <div class="form-input">
                                <div id='divTipoIdentificacionBeneficiario'></div>
                            </div>
                            <label class="obligatorio">(*)</label>
                        </div>
                        <div class="form-line">
                            <label class="form-label-left"
                                   id="lblNumDocBeneficiario" for="txtNumDocBeneficiario"> No. doc. identific </label>
                            <div class="form-input">
                                <input type="text" class="form-textbox"
                                       id="txtNumDocBeneficiario" name="txtNumDocBeneficiario"
                                       size="36"/>
                                <button id="btnBuscarBeneficiario" title="Buscar beneficiario"><img
                                        src="css/icon/buscar.png"/></button>
                            </div>
                            <label class="obligatorio">(*)</label>
                        </div>
                        <div class="form-line" id="id_1">
                            <label class="form-label-left" id="lblBeneficiario" for="txtNombreBeneficiario">Beneficiario</label>
                            <div class="form-input"><span class="form-sub-label-container">
                            <input class="form-textbox" type="text" size="25"
                                   name="txtNombreBeneficiario" id="txtNombreBeneficiario"/> <label
                                    class="obligatorio">(*)</label>
                                <label class="form-sub-label" for="txtNombreBeneficiario" id="sublabel_first"> Nombres </label> </span>
                                <span
                                        class="form-sub-label-container"> <input class="form-textbox"
                                                                                 type="text" size="15"
                                                                                 name="txtApellidoPaternoBeneficiario"
                                                                                 id="txtApellidoPaternoBeneficiario"/> <label class="obligatorio">(*)</label>
                                <label class="form-sub-label" for="txtApellidoPaternoBeneficiario"
                                       id="sublabel_middle"> Primer Apellido </label> </span> <span
                                        class="form-sub-label-container"> <input class="form-textbox"
                                                                                 type="text" size="15"
                                                                                 name="txtApellidoMaternoBeneficiario"
                                                                                 id="txtApellidoMaternoBeneficiario"/> <label
                                        class="form-sub-label"
                                        for="txtApellidoMaternoBeneficiario" id="sublabel_last">Segundo Apellido </label> </span></div>
                        </div>
                        <div class="form-line">
                            <label class="form-label-left" id="lblCiConyuge" for="txtCiConyuge"> C&eacute;dula conyuge </label>
                            <div class="form-input">
                                <input type="text" class="form-textbox" id="txtCiConyuge" name="txtCiConyuge" size="42"/>
                            </div>
                        </div>
                        <div class="form-line">
                            <label class="form-label-left" id="lblFechaMatrimonio" for="dtFechaMatrimonio"> Fecha matrimonio/uni&oacute;n de echo </label>
                            <div class="form-input">
                                <input type="text" class="form-textbox" id="dtFechaMatrimonio" name="dtFechaMatrimonio" size="42"/>
                            </div>
                        </div>
                        <div class="form-line">
                            <label class="form-label-left"
                                   id="lblPaisResidencia" for="divPaisResidencia"> Pa&iacute;s
                                residencia </label>
                            <div class="form-input">
                                <div id='divPaisResidencia'></div>
                            </div>
                            <label class="obligatorio">(*)</label>
                        </div>
                        <div class="form-line">
                            <label class="form-label-left"
                                   id="lblNacionalidadBeneficiario" for="divNacionalidadBeneficiario">
                                Nacionalidad </label>
                            <div class="form-input">
                                <div id='divNacionalidadBeneficiario'></div>
                            </div>
                            <label class="obligatorio">(*)</label>
                        </div>
                        <div class="form-line">
                            <label class="form-label-left"
                                   id="lblFechaNacimiento" for="dtFechaNacimiento"> Fecha de
                                nacimiento </label> <input type="text" id="dtFechaNacimiento"
                                                           name='dtFechaNacimiento' size="19"/> <label class="obligatorio">(*)</label>
                        </div>
                        <div class="form-line">
                            <label class="form-label-left"
                                   id="llblGenero" for="divTipoSolicitudResidencia"> Genero </label>
                            <input
                                    type="radio" name="rdbtnGenero" value="0" checked="checked"
                                    id="rdMasculino"/> <label for="rdMasculino">Masculino</label> <input
                                type="radio" name="rdbtnGenero" value="1" id="rdFemenino"/> <label
                                for="rdFemenino">Femenino</label>
                        </div>

                    </ul>
                    <span class="obligatorio"> Los campos marcados con (*) son obligatorios</span>
                </div>
            </div>

            <div id="divContacto">
                <div class="form-line cssTabButton">
                    <!--div id="divBgModal" class="bgtransparent"
                         style="width: 100%; height: 100%"></div-->
                    <table width="100%" border="0" style="font-size: 11px">
                        <tr>
                            <td><!--  -->
                                <div id="divBtnControlesContactoPersona" class="cssTabButton"
                                     style="border-top: 1px solid gray; border: medium">
                                    <button id="btnNuevoCgg_gem_contacto_persona"><img
                                            src="css/icon/add.png"/>A&ntilde;adir
                                    </button>
                                    <button id="btnEditarCgg_gem_contacto_persona"><img
                                            src="css/icon/edit.png"/>Editar
                                    </button>
                                    <button id="btnEliminarCgg_gem_contacto_persona"><img
                                            src="css/icon/eliminar.png"/>Borrar
                                    </button>
                                </div>
                                <br/>
                                <div id="FrmListadoContactoPersona" style="border: 1px solid gray">
                                    <!--<div id="divGrdContactoPersona"></div>-->
                                    <table class="tabla" cellspacing="0" border="0"
                                           id='tblContactosPersona'
                                           style="font-size: 11px; border: 1px solid #CCCCCC; width: 600px">
                                        <thead
                                                style="display: block; border-bottom: 1px solid #CCCCCC; width: 100%">
                                        <tr>
                                            <th width="225px">
                                                <div align="left">Tipo</div>
                                            </th>
                                            <th width="365px">
                                                <div align="left">Contacto</div>
                                            </th>
                                            <th class="Invisible">
                                                <div align="left">Descripcion</div>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody
                                                style="width: 100%; height: 130px; overflow: auto; display: block"></tbody>
                                    </table>
                                </div>
                                <div id="FrmContactoPersona" class="bgmodal componetHide"
                                     style="z-index: 10;position: fixed; left: 140; top: 315; background-color: #fff;">
                                    <div class="cssFormularioBorde"><span
                                            class="cssFormularioTitulo"><b>Contactos</b></span> <input
                                            type="hidden" id="txtCrprc_codigo" name="txtCrprc_codigo"/>
                                        <table width="300" border="0" style="font-size: 11px">
                                            <tr>
                                                <th>Tipo:</th>
                                                <td id="tdCbxTipoContacto"></td>
                                            </tr>
                                            <tr>
                                                <th>Contacto:</th>
                                                <td><input name="txtCrprc_contacto" type="text"
                                                           id="txtCrprc_contacto" style="width: 280px; margin: 10px;"/></td>
                                            </tr>
                                        </table>
                                        <div class="cssTabButton" style="margin-top: 10px; position: relative; display: inline-flex;">
                                            <button id="btnGuardarCgg_gem_contacto_persona"><img
                                                    src="css/icon/save.png"/>Guardar
                                            </button>
                                            <button id="btnSalirCgg_gem_contacto_persona"><img
                                                    src="css/icon/salir.png"/>Salir
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                    </table>
                </div>
            </div>

            <%--MO--%>
            <div id="divRequisitos">
                <div class="form-line cssTabButton">
                    <table width="100%" border="0" style="font-size: 11px">
                        <tr>
                            <td><!--  -->
                                <br/>
                                <div id="FrmListaRequisitos" style="border: 1px solid gray">

                                    <table class="tabla" cellspacing="0" border="0"
                                           id='tblRequisitos'
                                           style="font-size: 11px; border: 1px solid #CCCCCC; width: 600px">
                                        <thead
                                                style="display: block; border-bottom: 1px solid #CCCCCC; width: 100%">
                                        <tr>
                                            <th width="70%">
                                                <div align="left">Requisitos</div>
                                            </th>
                                            <th width="30%">
                                                <div align="left">Participante</div>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody
                                                style="width: 100%; height: 130px; overflow: auto; display: block"></tbody>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                    </table>
                </div>
            </div>

            <%----%>

            <%--MO--%>
            <div id="divDocumentacion">
                <div class="form-line cssTabButton">
                    <div id="infoDocs" style="width: 100%">
                        <div style="font: 12px 'Helvetica'" class="divAviso">
                            Los documentos listados a continuaci&oacute;n se le solicitar&aacute;n al guardar el
                            formulario.<br/>
                            Por favor tengalos a la mano en formato digital.
                        </div>
                    </div>
                    <table width="100%" border="0" style="font-size: 11px">
                        <tr>
                            <td><!--  -->
                                <br/>
                                <div id="FrmListaDocumentacion" style="border: 1px solid gray">

                                    <table class="tabla" cellspacing="0" border="0"
                                           id='tblDocumentacion'
                                           style="font-size: 11px; border: 1px solid #CCCCCC; width: 600px">
                                        <thead
                                                style="display: block; border-bottom: 1px solid #CCCCCC; width: 100%">
                                        <tr>
                                            <th width="600px">
                                                <div align="left">Documentos</div>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody
                                                style="width: 100%; height: 130px; overflow: auto; display: block"></tbody>
                                    </table>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                        </tr>
                    </table>
                </div>
            </div>

            <%----%>

        </div>
    </div>
    <br/>
    <div id="dlgMotivoResidencia" title="Motivo residencia">
        <div id='divMotivoResidencia'></div>

    </div>

    <div id="dlgReglaValidacion" title="Regla validacion">
        <div id="divReglaValidacion" class="divTramite"></div>
    </div>
    <div class="cssTabButton">
        <button id="btnGuardarTramiteResidencia"><img
                src="css/icon/save.png"/>Guardar
        </button>
        <button id="btnSalirTramiteResidencia"><img
                src="css/icon/salir.png"/>Cerrar
        </button>
    </div>
</div>
<div id="divBgModal" class="bgtransparent" style="width: 100%; height: 100%"></div>
<!--INGRESO PERSONA TRANSEUNTES-->
<div id="FrmIngresoPersona" class="componetHide" style="position: fixed; top: 100px; background-color: #fff;">
    <div class="cssFormularioBorde"><span class="cssFormularioTitulo"><b>Datos de la persona</b></span>
        <div id="contentPersona"></div>
        <div id="divBtnControlesIngresoPersona" class="cssTabButton">
            <button id="btnAceptarIngreso">
                <img src="css/icon/apply.png" />Aceptar</button>
            <button id="btnSalirIngreso" type="reset">
                <img src="css/icon/salir.png" />Salir</button>
        </div>
    </div>
</div>
<div id="attachView" class="componetHide">
    <div id="divBgAttachModal" style="position:fixed;left:0px; top:0px; background-color:#fff; opacity:0.80;	filter:alpha(opacity=80); width: 100%; height: 100%"></div>
    <div id="attachContainter" style="z-index: 99; position: fixed; left: 50px; top: 50px; background-color: #fff; height: 675px; border: 1px solid #999999; border-radius: 2px;">
        <iframe frameborder="0" scrolling="no" id="frameAttachment" src="" style="width: 820px; height: 630px; overflow-x:hidden !important; overflow:hidden; margin: 0; padding: 0">
        </iframe>
        <div id="divBtnControlesAdjuntos" class="cssTabButton" style="margin-top: 10px; margin-left: 10px;">
            <button id="btnAceptarAdjunto">
                <img src="css/icon/apply.png" />Aceptar</button>
        </div>
    </div>
</div>
</BODY>
</html>