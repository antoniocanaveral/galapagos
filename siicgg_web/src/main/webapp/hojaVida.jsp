<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es">
    <head>
        <title>Hoja de vida</title>
        <link rel="stylesheet" type="text/css" href="css/bsxTablaGE.css"/>
        <link rel="stylesheet" type="text/css" href="css/modulo.css"/>
        <link rel="stylesheet" type="text/css" href="css/bsxTabPanel.css"/>
        <link rel="stylesheet" type="text/css" href="css/bsxMessageBox.css"/>
        <link rel="stylesheet" type="text/css" href="css/jsDatePick_ltr.css"/>
        <script type="text/javascript" src="js/config.js"></script>
        <script type="text/javascript" src="js/SoapClient.js"></script>
        <script type="text/javascript" src="js/bsxTable.js"></script>
        <script type="text/javascript" src="js/bsxComboBox.js"></script>
        <script type="text/javascript" src="js/bsxTabPanel.js"></script>
        <script type="text/javascript" src="js/bsxMessageBox.js"></script>
        <script type="text/javascript" src="js/hojaVida.js"></script>
        <script src="js/prototype.js" type="text/javascript"></script>
        <script language="javascript" type="text/javascript" src="js/SpinnerControl.jsmin.js"></script>
        <script type="text/javascript" src="js/jsDatePick.min.1.3.js"></script>
        <!-- edfgdg-->
        <style type="text/css">
            .Visible {
                display:block;
            }
            .Invisible {
                display:none;
            }
            .Estilo2 {
                font-size:40%;
            }
            .Estilo3 {
                font-size:30%
            }

            div.outline {
                border:0px;
                padding:0px;
                float:left;
            }

            input.spin-integer {
                margin:0;
                padding:3px 0;
                text-align:center;
                border:medium none;
                width:40px;
                font-weight:normal;
                font-size:14px;
            }

            input.spin-button {
                height:21px;
                width:21px;
                border:1px solid #777;
                background-color:#d5d5d5;
                margin:0;
                padding:0px;
                color:#424b6d;
                font-weight:bold;
                cursor:pointer;
            }
            input.up, input.dn {
                margin:0;
                width:42px;
                border:1px solid #777;
                background-color:#d5d5d5;
                padding:0px;
                color:#424b6d;
                font-size:18px;
                font-weight:normal;
                cursor:pointer;
            }
            a {
                text-decoration:none;
                color:#000;
            }
            a:hover {
                color:#444;
            }
            a.up {
                display:block;
                height:9px;
                width:15px;
                background:#ccc url(css/image/vista-up.gif);
            }
            a.up:hover {
                background:#ccc url(css/image/vista-up-hover.gif);
            }
            a.dn {
                margin-top:1px;
                display:block;
                height:9px;
                width:15px;
                background:#ccc url(css/image/vista-dn.gif);
            }
            a.dn:hover {
                background:#ccc url(css/image/vista-dn-hover.gif);
            }
        </style>
    </head>
    <body onLoad="loadHojaVida();">
        <input type="hidden" id="txtUsuario" value=<% try{ out.println(request.getUserPrincipal().getName()); }catch(Exception ex){ out.println(false); } %>/></input>
        <div id="divBgModal" class="bgtransparent" style="width:100%;height:100%"></div>
        <div class="tituloPrincipal">Curriculum Vitae</div>
        <div class="descripcionPrincipal">Si sus datos no est&aacute;n actualizados en el sistema, por favor editelos en esta secci&oacute;n.</div>
        <div id="divTabInfo"></div>
        <br/>
        <br/>
        <!--style="display:none" -->
        <table id="divTablaHojaVida" width="690" border=0 cellpadding=0 cellspacing=0 class="fuenteTabla">
            <tr>
                <td width="637">
                    <div id="FrmPresentacionPerfil">
                        <table width="100%" border=0 class="fuenteTabla">
                            <tr class="Invisible">
                                <td colspan="3">Datos personales</td>
                            </tr>
                            <tr>
                                <th align="center" valign="top">
                                    <iframe id="upload_target" name="upload_target" src="" style="width:0;height:0;border:0px solid #fff;"></iframe>
                                    <table width="141" border="0" class="fuenteTabla">
                                        <form id="frmFotoCurriculum" name="frmFotoCurriculum" action="#" method="post" enctype="multipart/form-data" target="upload_target">
                                            <tr>
                                                <td colspan="2" valign="bottom">
                                                    <input name="request" type="hidden" id="txtCrper_request"/>
                                                    <input name="crper_codigo" type="hidden" id="txtCrper_codigo"/>
                                                    <div style="width:110px;margin:5px 5px 5px 20px;float:left">
                                                        <img id="imgCargando" src="css/icon/cargando.gif" style="position:absolute;"/>
                                                        <img name="imgFotoCurriculum" id="imgFotoCurriculum" width="110px" height="120px" align="middle"/>
                                                    </div>
                                                    <div class="uploadFile" style="float:left">
                                                        <input type="file" name="crper_foto_curriculum" id="crper_foto_curriculum" accept="image/gif, image/jpeg, image/png, image/bmp,/image/jpg"/>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <fieldset style="font-size:11px">
                                                        <legend><b>Residencia
                                                            </b>
                                                        </legend>
                                                        <table style="font-size:11px">
                                                            <tr>
                                                                <th width="69">Pa&iacute;s:</th>
                                                                <td width="56" id="tdPais">&nbsp;</td>
                                                            </tr>
                                                            <tr>
                                                                <th>Provincia:</th>
                                                                <td id="tdProvincia">&nbsp;</td>
                                                            </tr>
                                                            <tr>
                                                                <th>Ciudad:</th>
                                                                <td id="tdCanton">&nbsp;</td>
                                                            </tr>
                                                            <tr>
                                                                <th style="display:none"><input type="hidden" id="cprr_codigo" name="cprr_codigo"/>
                                                                    <input type="hidden" id="cctn_codigo" name="cctn_codigo"/>
                                                                    <input type="hidden" id="cgg_cpais_codigo" name="cgg_cpais_codigo"/>
                                                                    <input type="hidden" id="crper_empleado" name="crper_empleado"/>
                                                                </th>
                                                                <td id="tdParroquia" style="display:none">&nbsp;</td>
                                                            </tr>
                                                        </table>
                                                    </fieldset>
                                                </td>
                                            </tr>
                                            <div id="divStatus"></div>
                                        </form>
                                        <tr>
                                            <td colspan="2"><button name="btnSubirFoto" id="btnSubirFoto">Guardar
                                                    <img src="css/icon/save.png"/>
                                                </button>
                                            </td>
                                        </tr>
                                    </table>
                                </th>
                                <td valign="top">
                                    <fieldset style="font-size:11px">
                                        <legend><b>Datos Personales
                                            </b>
                                        </legend>
                                        <table width="100%" class="cssCV" border="0" style="font-size:11px" cellspacing="0" cellpadding="5">
                                            <tr style="border:1px dashed #CCCCCC">
                                                <th width="90"><div align="left">Nombre:</div></th>
                                                <td width="140" id="tdNombres">&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <th><div align="left">Apellido:</div></th>
                                                <td id="tdApellidos">&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <th><div align="left">Doc.Ident:</div></th>
                                                <td id="tdDocumentoIdentidad">&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <th><div align="left">Fecha nac.:
                                                    </div>
                                                </th>
                                                <td id="tdFechaNacimiento">&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <th><div align="left">G&eacute;nero:</div></th>
                                                <td id="tdGenero">&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <th><div align="left">Estado civ&iacute;l
                                                    </div>
                                                </th>
                                                <td id="tdEstadoCivil">&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <th><div align="left">No. de hijos:</div></th>
                                                <td id="tdNumeroHijos">&nbsp;</td>
                                            </tr>
                                            <tr>
                                                <th><div align="left">Nacionalidad:</div></th>
                                                <td id="tdNacionalidad">&nbsp;</td>
                                            </tr>
                                            <tr class="fuenteTabla">
                                                <th align="left">Estado laboral:</th>
                                                <td>
                                                    <input name="chkEstadoLaboral" class="Invisible" type="checkbox" id="chkEstadoLaboral" value="checkbox"/>
                                                    <div style="font-size:10px"><input type="radio" id="gbxEstadoLaboral" name="gbxEstadoLaboral" value="true"/>Empleado</div>
                                                    <input type="radio" name="gbxEstadoLaboral" value="false" checked="checked"/>Desempleado
                                                </td>
                                            </tr>
                                        </table>
                                    </fieldset>
                                </td>
                                <th valign="top">
                                    Datos de contacto
                                    <table width="100%" border="0" class="fuenteTabla">
                                        <tr>
                                            <td>
                                                <div id="FrmListadoContactoPersona" style="border:1px solid gray">
                                                    <div id="divGrdContactoPersona"></div>
                                                    <div id="divBtnControlesContactoPersona" class="cssTabButton" style="border-top:1px solid gray">
                                                        <button id="btnNuevoCgg_gem_contacto_persona"><img src="css/icon/add.png"/>A&ntilde;adir</button>
                                                        <button id="btnEditarCgg_gem_contacto_persona"><img src="css/icon/edit.png"/>Editar</button>
                                                        <button id="btnEliminarCgg_gem_contacto_persona"><img src="css/icon/eliminar.png"/>Borrar</button>
                                                    </div>
                                                </div>
                                                <div id="FrmContactoPersona" class="bgmodal componetHide">
                                                    <div class="cssFormularioBorde">
                                                        <span class="cssFormularioTitulo"><b>Contactos</b></span>
                                                        <input type="hidden" id="txtCrprc_codigo" name="txtCrprc_codigo"/>
                                                        <table width="300" border="0">
                                                            <tr><th>Tipo:</th>
                                                                <td id="tdCbxTipoContacto"></td>
                                                            </tr>
                                                            <tr><th>Contacto:</th>
                                                                <td><input name="txtCrprc_contacto" type="text" id="txtCrprc_contacto" size=40/></td></tr>
                                                        </table>
                                                        <div class="cssTabButton">
                                                            <button id="btnGuardarCgg_gem_contacto_persona"><img src="css/icon/save.png"/>Guardar</button>
                                                            <button id="btnSalirCgg_gem_contacto_persona"><img src="css/icon/salir.png"/>Salir</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </table>
                                </th>
                            </tr>
                            <tr>
                                <td colspan="3">
                                    <div class="cssFormularioBorde">
                                        <b>Datos Acad&eacute;micos (Eduaci&oacute;n formal)</b>
                                    </div>
                                    <table width="650" border="0" style="border:1px solid gray">
                                        <tr>
                                            <td>
                                                <div id="FrmListadoPerfilProfesional">
                                                    <div id="divGrdPerfilProfesional"></div>
                                                    <div id="divBtnControlesPerfilProfesional" class="cssTabButton">
                                                        <button id="btnNuevoCgg_gem_perfil_profesional"><img src="css/icon/add.png"/>A&ntilde;adir</button>
                                                        <button id="btnEditarCgg_gem_perfil_profesional"><img src="css/icon/edit.png"/>Editar</button>
														<button id="btnEliminarCgg_gem_perfil_profesional"><img src="css/icon/eliminar.png"/>Borrar</button>
                                                    </div>
                                                </div>
                                                <div id="FrmPerfilProfesional" class="bgmodal componetHide" style="position:fixed;left:150;top:320;background-color:#fff;">
                                                    <div class="cssFormularioBorde">
                                                        <span class="cssFormularioTitulo"><b>Educacion Formal</b></span>
                                                        <table width=350 border="0">
                                                            <tr>
                                                                <td><input type="hidden" id="txtCgppr_codigo" name="txtCgppr_codigo"/></td>
                                                            </tr>
                                                            <tr>
                                                                <th>Nivel de Estudio:</th>
                                                                <td colspan="3" id="tdNivelEstudio"></td>
                                                            </tr>
                                                            <tr>
                                                                <th>Instituci&oacute;n educativa:</th>
                                                                <td colspan="3"><input name="txtCgien_codigo" type="text" id="txtCgien_codigo" readonly style="width:140px"/>
                                                                    &#160;<button id="btnListadoCgg_gem_institucion_nivel"><img src="css/icon/buscar.png"/></button></td>
                                                            </tr>
                                                            <tr>
                                                                <th>T&iacute;tulo profesional:</th>
                                                                <td colspan="3"><input name="txtCgtpr_codigo" type="text" id="txtCgtpr_codigo" readonly style="width:140px"/>
                                                                    &#160;<button id="btnListadoCgg_titulo_profesional"><img src="css/icon/buscar.png"/></button></td>
                                                            </tr>
                                                            <tr>
                                                                <th>Especialidad:</th>
                                                                <td colspan="3"><input name="txtCgesp_codigo" type="text" id="txtCgesp_codigo" readonly style="width:140px"/>
                                                                    &#160;<button id="btnListadoCgg_especialidad"><img src="css/icon/buscar.png"/></button></td>
                                                            </tr>
                                                            <tr>
                                                                <th>Modalidad de estudio:</th>
                                                                <td colspan="3" id="tdModalidadEstudio"></td>
                                                            </tr>
                                                            <tr>
                                                                <th>Niveles finalizados :</th>
																<td>
																<table cellspacing="0" cellpadding="0" border="0" style = "font-size:10px;border:none" ><tr>
																	<td width="20">
																		<input type="checkbox" id="chkCgppr_finalizado" name="chkCgppr_finalizado" value="checkbox" checked="checked"/>
																  </td>
																	<td width="95">
																		Niveles Aprobados:																	</td>
																	<td width="47">
																		<table cellspacing="0" cellpadding="0" border="0" style="border:none">
																			<tr>
																				<td rowspan="2"><input name="text" type="text" class="spin-number" id="numCgppr_nivel_aprobado" style="width:20px" value="0" />
																				</td>
																				<td>
																					<a href="javascript:;" id="up2" class="up"></a>
																				</td>
																			</tr>
																			<tr>
																				<td>
																					<a href="javascript:;" id="dn2" class="dn"></a>
																				</td>
																			</tr>
																		</table>
																  </td>
																</tr></table>	
																</td>															
                                                                <!--<td>                                                                    
                                                                    <input type="checkbox" id="chkCgppr_finalizado" name="chkCgppr_finalizado" value="checkbox"/>
                                                                </td>
                                                                <th>Niveles Aprobados:
                                                                </th>
                                                                <td>
                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                                        <tr>
                                                                            <td rowspan="2"><input name="text" type="text" class="spin-number" id="numCgppr_nivel_aprobado" style="width:20px" value="1"/>
                                                                            </td>
                                                                            <td>
                                                                                <a href="javascript:;" id="up2" class="up"></a>
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>
                                                                                <a href="javascript:;" id="dn2" class="dn"></a>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </td>-->
                                                            </tr>
                                                            <tr>
                                                                <th>Fecha inicio:</th>
                                                                <td colspan="3"><input name="dtCgppr_fecha_inicio" type="text" id="dtCgppr_fecha_inicio" readonly style="width:140px"/></td>
                                                            </tr>
                                                            <tr>
                                                                <th>Fecha f&iacute;n:</th>
                                                                <td colspan="3"><input type="text" id="dtCgppr_fecha_fin" name="dtCgppr_fecha_fin" readonly style="width:140px"/></td>
                                                            </tr>
                                                            <tr class="Invisible">
                                                                <th>Confirmado:</th>
                                                                <td colspan="3"><input type="checkbox" id="chkCgppr_confirmado" name="chkCgppr_confirmado" value="checkbox"/></td>
                                                            </tr>
                                                            <tr class="Invisible">
                                                                <th>Predeterminado:</th>
                                                                <td colspan="3"><input type="checkbox" id="chkCgppr_predeterminado" name="chkCgppr_predeterminado" value="checkbox"/></td>
                                                            </tr>
                                                        </table>
                                                        <div class="cssTabButton">
                                                            <button id="btnGuardarCgg_gem_perfil_prof"><img src="css/icon/save.png"/>Guardar</button>
                                                            <button id="btnSalirCgg_gem_perfil_prof"><img src="css/icon/salir.png"/>Salir</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="3">
                                    <div class="cssFormularioBorde">
                                        <b>Adjuntar solo Documentación de respaldo de sus datos académicos que acrediten su C.V.</b>
                                    </div>
                                    <table width="650" border="0" style="border:1px solid gray">
                                        <tr>
                                            <td width="569">
                                                <div id="FrmListadoPerfilAdjunto">
                                                    <div id="divGrdPerfilAdjunto"></div>
                                                    <div class="cssTabButton">
                                                        <button id="btnNuevoListadoCgg_gem_perfil_adjunto"><img src="css/icon/add.png"/>A&ntilde;adir</button>
                                                        <button id="btnEditarListadoCgg_gem_perfil_adjunto"><img src="css/icon/edit.png"/>Editar</button>
                                                        <button id="btnEliminarListadoCgg_gem_perfil_adjunto"><img src="css/icon/eliminar.png"/>Borrar</button>
                                                    </div>
                                                </div>
                                                <div id="FrmPerfilAdjunto" class="bgmodal componetHide" style="position:fixed;left:180;top:520;background-color:#fff;">
                                                    <div class="cssFormularioBorde">
                                                        <span class="cssFormularioTitulo"><b>Adjuntos referente al perf&iacute;l profesional</b></span>
                                                        <form id="frmPerfilAdjunto" enctype="multipart/form-data" method="post" action="#" target="upload_target">
                                                            <input type="hidden" id="cgpfa_codigo" name="cgpfa_codigo"/>
                                                            <table width="50" border="0">
                                                                <tr>
                                                                    <td colspan=2><input type="hidden" id="crper_codigoAdjunto" name="crper_codigo"/></td>
                                                                </tr>
                                                                <tr>
                                                                    <th>Descripcion</th>
                                                                    <td colspan=2 style="font-size:10" valign='bottom'>Ingrese una peque&ntilde;a descripci&oacute;n a cerca del archivo adjunto
                                                                        <br/>
                                                                        <input type="text" id="cgpfa_descripcion" name="cgpfa_descripcion" style="width:205px"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <th>Adjunto:</th>
                                                                    <td>
                                                                        <input name="cgpfa_adjunto" type="file" id="cgpfa_adjunto" accept="application/msword,application/PDF,image/*" value="-"/>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan=2><input type="hidden" id="cgpfa_tipo_adjunto" name="cgpfa_tipo_adjunto"/></td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan=2><input type="hidden" id="cgpfa_nombre_adjunto" name="cgpfa_nombre_adjunto"/></td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan=2><input type="hidden" id="cgpfa_tipo" name="cgpfa_tipo"/></td>
                                                                </tr>
                                                                <tr>
                                                                    <td colspan=2><input type="hidden" id="requestAdjuntos" name="request"/></td>
                                                                </tr>
                                                            </table>
                                                        </form>
                                                        <div class="cssTabButton">
                                                            <button id="btnGuardarCgg_gem_perfil_adjunto"><img src="css/icon/save.png"/>Guardar</button>
                                                            <button id="btnSalirCgg_gem_perfil_adjunto" type="reset"><img src="css/icon/salir.png"/>Salir</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div id="FrmListadoInformacionLaboral" style="display:block">
                        <table border=0 class="cssTabPanel" width="100%" >
                            <tr>
                                <th width=150>Trabajaria en otra ciudad?:</th>
                                <td><input type="checkbox" id="chkCginf_trab_otra_ciudad" name="chkCginf_trab_otra_ciudad" value="checkbox"/></td>
                                <td rowspan =6>								
									<fieldset width="200"><legend>Calificaci&oacute;n</legend>
									<table border=0 class="cssTabPanel" >
										<tr>
											<th>Calificaci&oacute;n laboral:</th>
											<td><div id ="divCginf_Calificacion"><img src="css/icon/cargando.gif"/></div><input type="hidden" id="txtCginf_Calificacion" name="txtCginf_Calificacion" value=""/>								
											</td>
										</tr>
										<tr>
											<th>Detalle laboral:</th>
											<td>												
											</td>
										</tr>
										<tr>
											<td colspan=2>
												<textarea id="cbmCginf_obserbaciones" name="cbmCginf_obserbaciones" style="width:100%; height:100px" readonly></textarea>
											</td>
										</tr>										
									</table>
									</fieldset>
								</td>
                            </tr>
                            <tr>
                                <th>Aspiraci&#243;n salarial $:</th>
                                <td><input name="txtCrper_aspiracion_salarial" type="text" id="txtCrper_aspiracion_salarial" style="width:140px"/></td>
                            </tr>
                            <tr>
                                <th>Disponibilidad de tiempo para el nuevo puesto:</th>
                                <td><input name="txtCginf_disponibilidad" type="text" id="txtCginf_disponibilidad" style="width:140px"/></td>
                            </tr>
                            <tr>
                                <th>N&uacute;mero de hijos:</th>
                                <td><!--<input name="txtCginf_hijos" type="text" id="txtCginf_hijos" maxlength="2" style="width:auto"/>-->
									<table cellspacing="0" cellpadding="0" border="0">
										<tr>
											<td rowspan="2"><input name="text" type="text" class="spin-number" id="txtCginf_hijos" style="width:20" value="0" />
											</td>
											<td>
												<a href="javascript:;" id="up3" class="up"></a>
											</td>
										</tr>
										<tr>
											<td>
												<a href="javascript:;" id="dn3" class="dn"></a>
											</td>
										</tr>
									</table>
								</td>
                            </tr>                            
                            <tr>
                                <th>Licencia de conducir:</th>
                                <td><input type="checkbox" id="txtCginf_licencia_cond" name="txtCginf_licencia_cond" value=""/></td>
                            </tr>
                            <tr>
                                <th>Estado Laboral:</th>
                                <td>
                                    <select id="cbmCginf_estado_laboral" name="cbmCginf_estado_laboral">
                                        <option value="0">Actualmente trabajando</option>
                                        <option value="1">Ama de casa</option>
                                        <option value="2">En busca de empleo</option>
                                        <option value="3">Estudiante</option>
                                        <option value="4">Negocio propio</option>
                                    </select>
                                </td>
                            </tr>							
                            
                        </table>			
						<button id="btnCginf_Guardar"><img src="css/icon/save.png"/>Guardar</button>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div id="FrmListadoIdiomaPersona">
                        <div id="divGrdIdiomaPersona"></div>
                        <div id="divBtnControlesIdiomaPersona" class="cssTabButton">
                            <button id="btnNuevoCgg_gem_idioma_persona"><img src="css/icon/add.png"/>A&ntilde;adir</button>
                            <button id="btnEditarCgg_gem_idioma_persona"><img src="css/icon/edit.png"/>Editar</button>
                            <button id="btnEliminarCgg_gem_idioma_persona"><img src="css/icon/eliminar.png"/>Borrar</button>
                        </div>
                    </div>
                    <div id="FrmIdiomaPersona" class="bgmodal componetHide">
                        <div class="cssFormularioBorde">
                            <span class="cssFormularioTitulo"><b>Idiomas</b></span>
                            <input type="hidden" id="txtCgidp_codigo" name="txtCgidp_codigo"/>

							<table width="300" border="0">
                                <tr>
									<th style="color:#039BD7" colspan="2">
									Por favor, ingrese valores <b>del 0 al 100</b>
									</th>
								</tr>
								<tr>
                                    <th>Idioma:</th>
                                    <td id="tdCbxIdiomas"></td>
                                </tr>
                                <tr>
                                    <th>Escritura:</th>
                                    <td><input name="numCgidp_escritura" type="text" id="numCgidp_escritura" maxlength="3" size="10"/>%</td>
                                </tr>
                                <tr>
                                    <th>Lectura:</th>
                                    <td><input name="numCgidp_lectura" type="text" id="numCgidp_lectura" maxlength="3" size="10"/>%</td>
                                </tr>
                                <tr>
                                    <th>Hablar:</th>
                                    <td><input name="numCgidp_hablar" type="text" id="numCgidp_hablar" maxlength="3" size="10"/>%</td>
                                </tr>
                                <tr>
                                    <th>Escuchar:</th>
                                    <td><input name="numCgidp_escuchar" type="text" id="numCgidp_escuchar" maxlength="3" size="10"/>%</td>
                                </tr>
                            </table>
                            <div class="cssTabButton">
                                <button id="btnGuardarCgg_gem_idioma_persona"><img src="css/icon/save.png"/>Guardar</button>
                                <button id="btnSalirCgg_gem_idioma_persona"><img src="css/icon/salir.png"/>Salir</button>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div id="FrmListadoCertificado">
                        <div id="divGrdCertificado" style="border:1px solid gray"></div>
                        <div id="divBtnControlesCertificados" class="cssTabButton">
                            <button id="btnNuevoCgg_gem_certificado"><img src="css/icon/add.png"/>A&ntilde;adir</button>
                            <button id="btnEditarCgg_gem_certificado"><img src="css/icon/edit.png"/>Editar</button>
                            <button id="btnEliminarCgg_gem_certificado"><img src="css/icon/eliminar.png"/>Borrar</button>
                        </div>
                        <div id="FrmCertificado" class="bgmodal componetHide">
                            <div class="cssFormularioBorde">
                                <span class="cssFormularioTitulo"><b>Certificados obtenidos</b></span>
                                <form id="frmCertificado" enctype="multipart/form-data" method="post" action="#">
                                    <input type="hidden" id="cgcer_codigo" name="cgcer_codigo"/>
                                    <table width="300" border="0">
                                        <tr>
                                            <th>Tipo:</th>
                                            <td>
                                                <select id="cgcer_tipo" style="width:140px">
                                                    <option value="0" selected>Curso de Capacitaci&oacute;n</option>
                                                    <option value="1">Seminario</option>
                                                    <option value="2">Cer. Labor. o Acad&eacute;micas</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Instituci&oacute;n:</th>
                                            <td><input type="text" id="cgcer_institucion" name="cgcer_institucion" style="width:140px"/>
												
											</td>
                                        </tr>
                                        <tr>
                                            <th>Certificado:</th>
                                            <td><input type="hidden" id="crper_codigo" name="crper_codigo"/>
                                                <input type="text" id="cgcer_nombre" name="cgcer_nombre" style="width:140px"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Descripci&oacute;n:</th>
                                            <td>
                                                <textarea id="cgcer_descripcion" name="cgcer_descripcion" style="width:140px"></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Horas:</th>
                                            <td><!--<input type="text" id="cgcer_duracion" name="cgcer_duracion"/>-->
												<table cellspacing="0" cellpadding="0" border="0">
													<tr>
														<td rowspan="2"><input type="text" class="spin-number" id="cgcer_duracion" name="cgcer_duracion" style="width:20px" value="0" />
														</td>
														<td>
															<a href="javascript:;" id="up4" class="up"></a>
														</td>
													</tr>
													<tr>
														<td>
															<a href="javascript:;" id="dn4" class="dn"></a>
														</td>
													</tr>
												</table>
											</td>
                                        </tr>
                                        <tr>
                                            <th>Fecha inicio:</th>
                                            <td><input name="cgcer_fecha_inicio" type="text" id="cgcer_fecha_inicio" readonly style="width:140px"/></td>
                                        </tr>
                                        <tr>
                                            <th>Fecha f&iacute;n:</th>
                                            <td><input name="cgcer_fecha_fin" type="text" id="cgcer_fecha_fin" readonly style="width:140px"/></td>
                                        </tr>
                                        <tr class="Invisible">
                                            <th>Adjunto:</th>
                                            <td>
                                                <input name="cgcer_adjunto" type="file" id="cgcer_adjunto"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td td colspan=2><input type="hidden" id="cgcer_tipo_adjunto" name="cgcer_tipo_adjunto"/></td>
                                        </tr>
                                        <tr class="Invisible">
                                            <th>Nombre adjunto:</th>
                                            <td colspan=2><input type="text" id="cgcer_nombre_adjunto" name="cgcer_nombre_adjunto"/></td>
                                        </tr>
                                        <tr>
                                            <th>Observaci&oacute;n:</th>
                                            <td>
                                                <textarea id="cgcer_observacion" name="cgcer_observacion" style="width:140px"></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan=2><input type="hidden" id="request" name="request"/></td>
                                        </tr>
                                    </table>
                                </form>
                                <div class="cssTabButton">
                                    <button id="btnGuardarCgg_gem_certificado"><img src="css/icon/save.png"/>Guardar</button>
                                    <button id="btnSalirCgg_gem_certificado" type="reset"><img src="css/icon/salir.png"/>Salir</button>
                                </div>
                            </div>
                        </div>
                        <table width="650" border="0" style="border:1px solid gray">
                            <tr>
                                <td>
                                    <div id="FrmListadoPerfilAdjuntoCertificado">
                                        <div class="cssFormularioBorde">
                                            <span class="cssFormularioTitulo"><b>Adjuntos</b></span>
                                        </div>
                                        <div id="divGrdPerfilAdjuntoCertificado"></div>
                                        <div class="cssTabButton">
                                            <button id="btnNuevoListadoCgg_gem_perfil_adjuntoCertificado"><img src="css/icon/add.png"/>A&ntilde;adir</button>
                                            <button id="btnEditarListadoCgg_gem_perfil_adjuntoCertificado"><img src="css/icon/edit.png"/>Editar</button>
                                            <button id="btnEliminarListadoCgg_gem_perfil_adjuntoCertificado"><img src="css/icon/eliminar.png"/>Borrar</button>
                                        </div>
                                        <div id="FrmPerfilAdjuntoCertificado" class="bgmodal componetHide">
                                            <div class="cssFormularioBorde">
                                                <span class="cssFormularioTitulo"><b>Adjuntos</b></span>
                                                <form id="frmPerfilAdjuntoCertificado" enctype="multipart/form-data" method="post" action="#" target="upload_target">
                                                    <input type="hidden" id="cgpfa_codigoCertificado" name="cgpfa_codigo"/>
                                                    <table width="50" border="0">
                                                        <tr>
                                                            <td td colspan=2><input type="hidden" id="crper_codigoCertificado" name="crper_codigo"/></td>
                                                        </tr>
                                                        <tr>
                                                            <th>Descripcion</th>
                                                            <td td colspan=2><input type="text" id="cgpfa_descripcionCertificado" name="cgpfa_descripcion"/></td>
                                                        </tr>
                                                        <tr>
                                                            <th>Adjunto:</th>
                                                            <td>
                                                                <input name="cgpfa_adjunto" type="file" id="cgpfa_adjuntoCertificado" accept="application/msword,application/PDF,image/*" value="-"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td td colspan=2><input type="hidden" id="cgpfa_tipo_adjuntoCertificado" name="cgpfa_tipo_adjunto"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan=2><input type="hidden" id="cgpfa_nombre_adjuntoCertificado" name="cgpfa_nombre_adjunto"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan=2><input type="hidden" id="cgpfa_tipoCertificado" name="cgpfa_tipo"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan=2><input type="hidden" id="requestAdjuntosCertificado" name="request"/></td>
                                                        </tr>
                                                    </table>
                                                </form>
                                                <div class="cssTabButton">
                                                    <button id="btnGuardarCgg_gem_perfil_adjuntoCertificado"><img src="css/icon/save.png"/>Guardar</button>
                                                    <button id="btnSalirCgg_gem_perfil_adjuntoCertificado" type="reset"><img src="css/icon/salir.png"/>Salir</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div id="FrmListadoExperienciaLaboral">
                        <div id="divGrdExperienciaLaboral"></div>
                        <div id="divBtnControlesExperienciaLaboral" class="cssTabButton">
                            <button id="btnNuevoCgg_gem_experiencia_laboral"><img src="css/icon/add.png"/>A&ntilde;adir</button>
                            <button id="btnEditarCgg_gem_experiencia_laboral"><img src="css/icon/edit.png"/>Editar</button>
                            <button id="btnEliminarCgg_gem_experiencia_laboral"><img src="css/icon/eliminar.png"/>Borrar</button>
                        </div>
                    </div>
                    <div id="FrmExperienciaLaboral" class="bgmodal componetHide">
                        <div class="cssFormularioBorde">
                            <span class="cssFormularioTitulo"><b>Experiencia Laboral</b></span>
                            <input type="hidden" id="txtCgexl_codigo" name="txtCgexl_codigo"/>
                            <table width="350" border="0">
                                <tr>
                                    <th>Empresa:</th>
                                    <td><input type="text" id="txtCgexl_razon_social" name="txtCgexl_razon_social"/></td>
                                </tr>
                                <tr>
                                    <th>Ciudad:</th>
                                    <td><input type="text" id="txtCgexl_ciudad" name="txtCgexl_ciudad"/></td>
                                </tr>
                                <tr>
                                    <th>Cargo:</th>
                                    <td><input type="text" id="txtCgexl_cargo" name="txtCgexl_cargo"/></td>
                                </tr>
                                <tr>
                                    <th>Descripci&oacute;n:</th>
                                    <td>
                                        <textarea id="txtCgexl_descripcion" name="txtCgexl_descripcion"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Fecha inicio:</th>
                                    <td><input name="dtCgexl_fecha_inicio" type="text" id="dtCgexl_fecha_inicio" readonly/></td>
                                </tr>
                                <tr>
                                    <th>Fecha fin:</th>
                                    <td><input name="dtCgexl_fecha_fin" type="text" id="dtCgexl_fecha_fin" readonly/></td>
                                </tr>
                                <tr>
                                    <th>Personas a cargo:</th>
                                    <td><input type="text" id="numCgexl_personas_cargo" name="numCgexl_personas_cargo"/></td>
                                </tr>
                                <tr>
                                    <th>Persona referencia:</th>
                                    <td><input type="text" id="txtCgexl_contacto" name="txtCgexl_contacto"/></td>
                                </tr>
                                <tr>
                                    <th>Telefono:</th>
                                    <td><input type="text" id="txtCgexl_telefono" name="txtCgexl_telefono"/></td>
                                </tr>
                                <tr>
                                    <th>Observaciones:</th>
                                    <td>
                                        <textarea id="txtCgexl_observaciones" name="txtCgexl_observaciones"></textarea>
                                    </td>
                                </tr>
                            </table>
                            <div class="cssTabButton">
                                <button id="btnGuardarCgg_gem_experiencia_laboral"><img src="css/icon/save.png"/>Guardar</button>
                                <button id="btnSalirCgg_gem_experiencia_laboral"><img src="css/icon/salir.png"/>Salir</button>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div id="FrmListadoDestrezaPersona">
                        <table width="650" border="0">
                            <tr>
                                <td style="border-right:1px solid gray">
                                    <div id="divGrdDestrezaPersona"></div>
                                    <div id="divBtnControlesDestrezaPersona" class="cssTabButton">
                                        <button id="btnNuevoCgg_gem_destreza_persona"><img src="css/icon/add.png"/>A&ntilde;adir</button>
                                        <button id="btnEditarCgg_gem_destreza_persona" class="Invisible"><img src="css/icon/edit.png"/>Editar</button>
                                        <button id="btnEliminarCgg_gem_destreza_persona"><img src="css/icon/eliminar.png"/>Borrar</button>
                                    </div>
                                    <div id="FrmDestrezaPersona" class="bgmodal componetHide">
                                        <div class="cssFormularioBorde">
                                            <span class="cssFormularioTitulo"><b>Destreza</b></span>
                                            <input type="hidden" id="txtCgdpr_codigo" name="txtCgdpr_codigo"/>
                                            <table width="300" border="0">
                                                <tr>
                                                    <th>Destreza:</th>
                                                    <td id="tdDestrezas"></td>
                                                </tr>
                                            </table>
                                            <div class="cssTabButton">
                                                <button id="btnGuardarCgg_gem_destreza_persona"><img src="css/icon/save.png"/>Guardar</button>
                                                <button id="btnSalirCgg_gem_destreza_persona"><img src="css/icon/salir.png"/>Salir</button>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <div id="divGrdHabilidadesPersona"></div>
                                    <div id="divBtnControlesHabilidadesPersona" class="cssTabButton">
                                        <button id="btnNuevoCgg_gem_habilidades_persona"><img src="css/icon/add.png"/>A&ntilde;adir</button>
                                        <button id="btnEditarCgg_gem_habilidades_persona" class="Invisible"><img src="css/icon/edit.png"/>Editar</button>
                                        <button id="btnEliminarCgg_gem_habilidades_persona"><img src="css/icon/eliminar.png"/>Borrar</button>
                                    </div>
                                    <div id="FrmHabilidadesPersona" class="bgmodal componetHide">
                                        <div class="cssFormularioBorde">
                                            <span class="cssFormularioTitulo"><b>Habilidades</b></span>
                                            <input type="hidden" id="txtCgdpr_codigoHabilidades" name="txtCgdpr_codigoHabilidades"/>
                                            <table width="300" border="0">
                                                <tr>
                                                    <th>Habilidades:</th>
                                                    <td id="tdHabilidades"></td>
                                                </tr>
                                            </table>
                                            <div class="cssTabButton">

                                                <button id="btnGuardarCgg_gem_habilidades_persona"><img src="css/icon/save.png"/>Guardar</button>
                                                <button id="btnSalirCgg_gem_habilidades_persona"><img src="css/icon/salir.png"/>Salir</button>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div id="FrmListadoInstitucionNivel" class="bgmodal componetHide" style="position:fixed;left:80;top:315;background-color:#fff;">
                        <div class="cssFormularioBorde">
                            <span class="cssFormularioTitulo"><b>Instituci&#243;n Educativa</b></span>
                            <div id="divGrdInstitucionNivel"></div>
                            <div class="cssTabButton">
                                <button id="btnSeleccionarInstitucionNivel"><img src="css/icon/save.png"/>Seleccionar</button>
                                <button id="btnSalirInstitucionNivel"><img src="css/icon/save.png"/>Cerrar</button>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div id="FrmListadoTituloProfesional" class="bgmodal componetHide" style="position:fixed;left:80;top:315;background-color:#fff;">
                        <div class="cssFormularioBorde">
                            <span class="cssFormularioTitulo"><b>T&#237;tulo Profesional</b></span>
                            <div id="divGrdTituloProfesional"></div>
                            <div class="cssTabButton">
                                <button id="btnSeleccionarTituloProfesional"><img src="css/icon/save.png"/>Seleccionar</button>
                                <button id="btnSalirTituloProfesional"><img src="css/icon/save.png"/>Cerrar</button>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div id="FrmListadoEspecialidad" class="bgmodal componetHide" style="position:fixed;left:80;top:315;background-color:#fff;">
                        <div class="cssFormularioBorde">
                            <span class="cssFormularioTitulo"><b>T&#237;tulo Profesional</b></span>
                            <div id="divGrdEspecialidad"></div>
                            <div class="cssTabButton">
                                <button id="btnSeleccionarEspecialidad"><img src="css/icon/save.png"/>Seleccionar</button>
                                <button id="btnSalirEspecialidad"><img src="css/icon/save.png"/>Cerrar</button>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
        <div id="divAlmacenando" class="bgtransparent" style="width:100%;height:100%">
            <div style="position:fixed;left:350;top:180;background-color:#fff;">
                <img id="imgCargando" src="css/icon/loading.gif"/>
            </div>
        </div>
    </body>
</html>
