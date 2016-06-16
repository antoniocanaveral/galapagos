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
    <link rel="stylesheet" type="text/css"
          href="css/jquery/jstree/style.css"/>
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
            width: 650px;
            /*)color:#000000 !important;
                        (*/
            /*) font-family:"Arial Black";
                           (*/
            font-size: 10px;
        }

        td.hovered {
            background-color: lightblue;
            color: #666;
        }

        div.divTramite {
            font-size: 10px;
        }
    </style>
</head>
<BODY>
<input type="hidden" id="txtUsuario"
       value=<% try{ out.println(request.getUserPrincipal().getName()); }catch(Exception ex){ out.println(false); } %>/></input>
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
            <li class="form-line"><label class="form-label-left"
                                         id="lblTipoTramite" for="divTipoTramite"> Tipo de tramite:</label>
                <div class="form-input">
                    <div id='divTipoTramite'></div>
                </div>
                <label class="obligatorio">(*)</label></li>
            <%----%>

            <li class="form-line"><label class="form-label-left"
                                         id="lblIslaTramite" for="divIslaTramite"> Lugar registro:</label>
                <div class="form-input">
                    <div id='divIslaTramite'></div>
                </div>
                <label class="obligatorio">(*)</label></li>

            <li class="form-line"><label class="form-label-left"
                                         id="lblTipoResidencia" for="divTipoResidenciaPadre"> Tipo
                residencia </label>
                <div class="form-input">
                    <div id='divTipoResidenciaPadre'></div>
                </div>
                <label class="obligatorio">(*)</label></li>
            <!--li class="form-line">
                                    <label class="form-label-left" id="llblMotivoResidencia" for="divTipoSolicitudResidencia">
                                        Motivo residencia
                                    </label>
                                    <div class="form-input">
                                        <div id='divTipoSolicitudResidencia'></div>
                                    </div>
                                    <label class="obligatorio">(*)</label>
                                </li-->
            <li class="form-line"><label class="form-label-left"
                                         id="llblMotivoResidencia" for="txtMotivoResidencia"> Motivo
                residencia </label>
                <div class="form-input"><input type="text" class="form-textbox"
                                               name="txtMotivoResidencia" id="txtMotivoResidencia" size="30"/> <label
                        class="obligatorio">(*)</label>
                    <button id="btnBuscarMotivo" title="Buscar motivo"><img
                            src="css/icon/buscar.png"/></button>
                </div>
            </li>
        </fieldset>
        <fieldset>
            <legend><b>Informaci&oacute;n auspiciante</b></legend>
            <ul class="form-section">
                <div class="form-line"><label class="form-label-left"
                                              id="lblCrper_identificacion"> Tipo identificaci&oacute;n </label>
                    <div class="form-input"><input type="text" class="form-textbox"
                                                   id="txtIdentificacionAuspiciante" name="txtIdentificacionAuspiciante"
                                                   size="20"/></div>
                </div>
                <div id="divCargando1" class="cargando"
                     style="display: none; position: fixed;"><span>Cargando...</span></div>
                <div class="form-line"><label class="form-label-left"
                                              id="lblNumDocAuspiciante" for="txtNumDocAuspiciante"> No. doc.
                    identific </label>
                    <div class="form-input"><input type="text" class="form-textbox"
                                                   id="txtNumDocAuspiciante" name="txtNumDocAuspiciante" size="20"/>
                    </div>
                </div>
                <div class="form-line"><label class="form-label-left"
                                              id="lblAuspiciante" for="txtNombreAuspiciante"> Auspiciante </label>
                    <div class="form-input"><span class="form-sub-label-container">
	<input class="form-textbox" type="text" size="40"
           name="txtNombreAuspiciante" id="txtNombreAuspiciante"/> <label
                            class="form-sub-label" for="txtNombreAuspiciante"
                            id="lblNombreAuspiciante1"> Nombres y Apellidos </label> </span></div>
                </div>
                <div id="divEmpresa" class="form-line" style="display: none"><label
                        class="form-label-left" id="lblAuspiciantePJ"
                        for="txtNombreAuspiciantePJ"> Empresa </label>
                    <div class="form-input"><span class="form-sub-label-container">
	<input class="form-textbox" type="text" size="20"
           name="txtNombreAuspiciantePJ" id="txtNombreAuspiciantePJ"/> </span></div>
                </div>

                <li class="form-line"><label class="form-label-left"
                                             id="lblNumResidenciaAuspiciante" for="txtNumResidenciaAuspiciante">
                    No. residencia </label>
                    <div class="form-input"><input type="text" class="form-textbox"
                                                   id="txtNumResidenciaAuspiciante" name="txtNumResidenciaAuspiciante"
                                                   size="20"/></div>
                </li>
            </ul>
        </fieldset>
        <div id="tabs">
            <ul>
                <li><a href="#divAuspiciado"><b>Informaci&oacute;n Beneficiario</b></a></li>
                <li><a href="#divContacto"><b>Contacto</b></a></li>
                <li><a href="#divDocumentacion"><b>Documentaci&oacute;n</b></a></li>
            </ul>
            <div id="divAuspiciado">
                <ul class="form-section">
                    <li class="form-line"><label class="form-label-left"
                                                 id="lblIdentificacionBeneficiario"
                                                 for="divTipoIdentificacionBeneficiario"> Tipo
                        identificaci&oacute;n </label>
                        <div class="form-input">
                            <div id='divTipoIdentificacionBeneficiario'></div>
                        </div>
                        <label class="obligatorio">(*)</label></li>
                    <li class="form-line"><label class="form-label-left"
                                                 id="lblNumDocBeneficiario" for="txtNumDocBeneficiario"> No.
                        doc. identific </label>
                        <div class="form-input"><input type="text" class="form-textbox"
                                                       id="txtNumDocBeneficiario" name="txtNumDocBeneficiario"
                                                       size="20"/>
                            <button id="btnBuscarBeneficiario" title="Buscar beneficiario"><img
                                    src="css/icon/buscar.png"/></button>
                        </div>
                        <label class="obligatorio">(*)</label></li>
                    <li class="form-line" id="id_1"><label class="form-label-left"
                                                           id="lblBeneficiario" for="txtNombreBeneficiario">
                        Beneficiario
                    </label>
                        <div class="form-input"><span class="form-sub-label-container">
	<input class="form-textbox" type="text" size="25"
           name="txtNombreBeneficiario" id="txtNombreBeneficiario"/> <label
                                class="obligatorio">(*)</label> <label class="form-sub-label"
                                                                       for="txtNombreBeneficiario" id="sublabel_first"> Nombres </label> </span> <span
                                class="form-sub-label-container"> <input class="form-textbox"
                                                                         type="text" size="15"
                                                                         name="txtApellidoPaternoBeneficiario"
                                                                         id="txtApellidoPaternoBeneficiario"/> <label
                                class="obligatorio">(*)</label>
	<label class="form-sub-label" for="txtApellidoPaternoBeneficiario"
           id="sublabel_middle"> Primer Apellido </label> </span> <span
                                class="form-sub-label-container"> <input class="form-textbox"
                                                                         type="text" size="15"
                                                                         name="txtApellidoMaternoBeneficiario"
                                                                         id="txtApellidoMaternoBeneficiario"/> <label
                                class="form-sub-label"
                                for="txtApellidoMaternoBeneficiario" id="sublabel_last">
	Segundo Apellido </label> </span></div>
                    </li>
                    <li class="form-line"><label class="form-label-left"
                                                 id="lblPaisResidencia" for="divPaisResidencia"> Pa&iacute;s
                        residencia </label>
                        <div class="form-input">
                            <div id='divPaisResidencia'></div>
                        </div>
                        <label class="obligatorio">(*)</label></li>
                    <li class="form-line"><label class="form-label-left"
                                                 id="lblNacionalidadBeneficiario" for="divNacionalidadBeneficiario">
                        Nacionalidad </label>
                        <div class="form-input">
                            <div id='divNacionalidadBeneficiario'></div>
                        </div>
                        <label class="obligatorio">(*)</label></li>

                    <li class="form-line"><label class="form-label-left"
                                                 id="lblFechaNacimiento" for="dtFechaNacimiento"> Fecha de
                        nacimiento </label> <input type="text" id="dtFechaNacimiento"
                                                   name='dtFechaNacimiento'/> <label class="obligatorio">(*)</label>
                    </li>

                    <li class="form-line"><label class="form-label-left"
                                                 id="llblGenero" for="divTipoSolicitudResidencia"> Genero </label>
                        <input
                                type="radio" name="rdbtnGenero" value="0" checked="checked"
                                id="rdMasculino"/> <label for="rdMasculino">Masculino</label> <input
                                type="radio" name="rdbtnGenero" value="1" id="rdFemenino"/> <label
                                for="rdFemenino">Femenino</label></li>
                </ul>
<span class="obligatorio"> Los campos marcados con (*) son
obligatorios</span></div>

            <div id="divContacto">
                <div class="form-line cssTabButton">
                    <div id="divBgModal" class="bgtransparent"
                         style="width: 100%; height: 100%"></div>
                    <table width="200" border="0" style="font-size: 11px">
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
                                     style="position: fixed; left: 140; top: 315; background-color: #fff;">
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
                                                           id="txtCrprc_contacto" style="width: 180px"/></td>
                                            </tr>
                                        </table>
                                        <div class="cssTabButton">
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
            <div id="divDocumentacion">
                <div class="form-line cssTabButton">
                    <div id="divBgModal" class="bgtransparent"
                         style="width: 100%; height: 100%"></div>
                    <table width="200" border="0" style="font-size: 11px">
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
                                            <th width="365px">
                                                <div align="left">Documentos</div>
                                            </th>
                                            <th width="225px">
                                                <div align="left">Adjuntos</div>
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
</BODY>
</html>