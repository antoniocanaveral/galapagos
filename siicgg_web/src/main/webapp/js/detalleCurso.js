function loadDetalleCurso() {

        var userObject;
        var url = URL_WS + "SessionManager?request=userobject";

        var codigoUsuario;
        var codigoPersona;
        var cedulaPersona;
        var swPreregistro = true;

        var txtDatosCurso = ($("divDatosCurso").innerHTML).replace(/[¶]+/g, ' ');
        var objCurso = eval('(' + txtDatosCurso + ')');
        var txtTipoCurso = $("txtTipoCurso");

        var con = 1;
        //alert('codigo: '+codigoPersona+' cedula: '+cedulaPersona);
        var tdCurso = $("tdCurso");
        var tdCoordinador = $("tdCoordinador");
        var tdTipoCurso = $("tdTipoCurso");
        var tdPatrocinador = $("tdPatrocinador");
        var tdNumeroModulos = $("tdNumeroModulos");
        var tdContenidoModulos = $("tdContenidoModulos");
        var tdLugar = $("tdLugar");
        var tdLocal = $("tdLocal");
        var tdDuracion = $("tdDuracion");
        var tdCosto = $("tdCosto");
        var tdFechaInicio = $("tdFechaInicio");
        var tdFechaFin = $("tdFechaFin");
        var tdHorario = $("tdHorario");
        var btnInscribirse = $("btnInscribirse");
        var tdCuposDisponibles = $("tdCuposDisponibles");
        var tdCuposMaximos = $("tdCuposMaximos");
        var txtUsuario = $("txtUsuario");
        var divCabecera = $("divCabecera");
        var btnCancelar = $("btnCancelar");
        var btnGuardar = $("btnGuardar");
        var txtActividad = $("txtActividad");
        var frmPreRegistroCurso = $("frmPreRegistroCurso");
        var btnAtras = $("btnAtras");
        var cbxSectorProductivo;
        var swMensajeDiv = false;

        btnAtras.onclick = function () {
            document.location = 'listadoCurso.jsp';
            }
        //alert(objCurso.CDTCR_TIPO_RESIDENTE);
        tdCurso.innerHTML = objCurso.CDCUR_DESCRIPCION; //.toUpperCase();
        tdCoordinador.innerHTML = objCurso.CRPER_INSTRUCTOR;
        tdTipoCurso.innerHTML = txtTipoCurso.value;
        tdPatrocinador.innerHTML = objCurso.CDITR_NOMBRE;
        tdNumeroModulos.innerHTML = objCurso.CDCUR_NUMERO_MODULOS;
        tdContenidoModulos.innerHTML = objCurso.CDCUR_CONTENIDO;
        tdLugar.innerHTML = objCurso.CDCUR_INSTITUCION;
        tdLocal.innerHTML = objCurso.CDCUR_ESTABLECIMIENTO;
        tdDuracion.innerHTML = (objCurso.CDCUR_NUMERO_HORAS) ? (objCurso.CDCUR_NUMERO_HORAS) + ' horas' : 'No establecido';
        tdCosto.innerHTML = '$ ' + objCurso.CDCUR_VALORACION; //CDCUR_COSTO;
        var fechaInicio = objCurso.CDCUR_FECHA_INICIO; //CDCUR_FECHA_PREVISTA_INICIO
        tdFechaInicio.innerHTML = (fechaInicio) ? (fechaInicio).split(" ")[0] : 'No establecido';
        var fechaFin = objCurso.CDCUR_FECHA_CULMINACION; //CDCUR_FECHA_PREVISTA_CULMINACION
        tdFechaFin.innerHTML = (fechaFin) ? (fechaFin).split(" ")[0] : 'No establecido';
        tdHorario.innerHTML = objCurso.CDCUR_HORARIO + ' - ' + objCurso.CDCUR_HORARIO1;
        tdCuposMaximos.innerHTML = objCurso.CDCUR_NUMERO_ASISTENTE;

        btnCancelar.onclick = function () {
            btnSalirAll($("FrmPreRegistroCurso"));
        }
        btnGuardar.onclick = function () {
            if (!txtActividad.value) {
                new bsxMessageBox({
                    title: "Actividades",
                    msg: "Por favor ingrese al menos una actividad",
                    icon: "iconInfo"
                });
                //alert('Por favor ingrese algunas actividades que usted realiza');
                txtActividad.focus();
                return;
            }
            if (swPreregistro == true) {
                try {
                    function CallBackCgg_dhu_asistente_curso(r) {
                        //alert(r);					
                        if (r == "true") {
                            new bsxMessageBox({
                                title: "Pre-inscripci\u00F3n al curso",
                                msg: "La informaci\u00F3n a sido almacenada correctamente.<br/> " + 'Por favor usted debe acercarse a las oficinas durante ' + 'los proximos 5 d\u00EDas para legalizar su matr\u00EDcula, ' + 'caso contrario su inscripci\u00F3n ser\u00E1 anulada',
                                icon: "iconInfo",
                                close:
                                    function () {
                                        document.location = 'listadoCurso.jsp';
                                    }
                            });
                            //alert("La informaci\u00F3n a sido almacenada correctamente");
                            frmPreRegistroCurso.reset();
                            btnSalirAll($("FrmPreRegistroCurso"));
                        } else {
                            //alert(r);
                            new bsxMessageBox({
                                title: "Error",
                                msg: r.split(': ')[1],
                                icon: "iconError",
                                close:
                                    function () {
                                        document.location = 'listadoCurso.jsp';
                                    }
                            });
                        }
                    }
                    var param = new SOAPClientParameters();
                    param.add('inCrper_codigo', codigoPersona);
                    param.add('inCdcur_codigo', objCurso.CDCUR_CODIGO); // txtCodigoCurso.value);
                    param.add('inCsctp_codigo', cbxSectorProductivo.dom.value);
                    param.add('inCusu_codigo', codigoUsuario);
                    param.add('inCdasc_actividad_realizada', txtActividad.value);
                    param.add('inCdasc_nota_final', null);
                    param.add('inCdasc_numero_certificado', null);
                    param.add('inCdasc_fecha_emision_certificado', null);
                    param.add('inCdasc_estado_inscripcion', 0); ////0 pre-inscritos
                    param.add('inCdasc_aprobado', 3);
                    SOAPClient.invoke(URL_WS + "Cgg_dhu_asistente_curso", 'insert', param, true, CallBackCgg_dhu_asistente_curso);
                } catch (inErr) {
                    alert(inErr);
                }
            }
        }

        btnInscribirse.onclick = function () {
            //document.location = 'preRegistroCurso.jsp?codigoCurso='+objCurso.CDCUR_CODIGO+'&tipoResidente='+objCurso.CDTCR_TIPO_RESIDENTE;
            cbxSectorProductivo = new bsxComboBox({
                id: "cbxSectorProductivo",
                width: 150,
                renderTo: "tdSectorProductivo",
                displayField: "CSCTP_NOMBRE",
                valueField: "CSCTP_CODIGO",
                webService: {
                    url: URL_WS + "Cgg_sector_productivo",
                    method: "selectAll",
                    params: [{
                        name: "format",
                        value: "JSON"
                    }]
                }
            });
            cbxSectorProductivo.reload();

            new Ajax.Request(url, {
                method: 'get',
                asynchronous: false,
                onSuccess:
                    function (transport) {
                        userObject = eval("(" + transport.responseText + ")");
                    }, onFailure:
                        function (transport) {
                            alert(transport);
                        }
            });
            codigoUsuario = userObject.CUSU_CODIGO;
            codigoPersona = userObject.CRPER_CODIGO;
            cedulaPersona = userObject.CRPER_NUM_DOC_IDENTIFIC;

            function CallBackSelectDatos(v) {
                //alert(v);				
                var a = eval('(' + v + ')');
                if (a.length > 0) {
                    if (a[0].CODIGO == '04' && txtTipoResidente != 0) {
                        swPreregistro = false;
						new bsxMessageBox({
							title: "Pre-inscripci\u00F3n al curso",
							msg: 'Usted no puede inscribirse al curso por ser residente temporal',
							icon: "iconError"							
						});
                        //alert('NO se puede inscribir al curso por ser residente temporal');
                        btnSalirAll($("FrmPreRegistroCurso"));
                    }
                }
            }
            var param = new SOAPClientParameters();
            param.add('inCrper_num_doc_identific', cedulaPersona);
            param.add('format', 'JSON');
            SOAPClient.invoke(URL_WS + "Cgg_dhu_asistente_curso", "selectAsistenteResidente", param, true, CallBackSelectDatos);

            showForm($("FrmPreRegistroCurso"));
            $("tdNombrePersona").innerHTML = userObject.CRPER_NOMBRES + ' ' + userObject.CRPER_APELLIDO_PATERNO + ' ' + userObject.CRPER_APELLIDO_MATERNO
            $("tdCedulaIdentidad").innerHTML = cedulaPersona; //userObject.CRPER_NUM_DOC_IDENTIFIC;
            $("tdCursoPreRegistrar").innerHTML = objCurso.CDCUR_DESCRIPCION;

        }
        if (txtUsuario.value != "false") {
            btnInscribirse.style.visibility = "visible";
            $("divLogineo").style.display = 'none';//visibility = 'hidden';
			if(objCurso.TMP_INSCRITO > 0){
				$("divRegistrado").style.display = 'block';
				$("divRegistrado").innerHTML = 'Usted ya se encuentra pre-registrado en el curso. Por favor acuda a legalizar su matricula en el caso de que no lo haya hecho';
				btnInscribirse.style.visibility = 'hidden';
			}
			if(objCurso.CDCUR_ESTADO_CURSO ==0){
				btnInscribirse.style.visibility = "hidden";
			}
        } else {
            btnInscribirse.style.visibility = "hidden";
            $("divLogineo").style.display = 'block';//visibility = 'visible';
            $("divLogineo").innerHTML = 'Para poder pre-inscribirse a un curso usted debe poseer una cuenta de usuario y estar habilitado en el sistema. Si no lo est\u00E1, comun\u00EDquese con el administrador del sistema.';
            swMensajeDiv = true;
        }

        function CallBackCgg_dhu_numero_asistente(r) {
            var tmpNumeroAsistente = Math.round(((objCurso.CDCUR_NUMERO_ASISTENTE) - (r)));
            if (tmpNumeroAsistente > 0) {
                tdCuposDisponibles.innerHTML = tmpNumeroAsistente;
            } else {
                btnInscribirse.style.display = 'none';
                if (swMensajeDiv == false) {
                    divCabecera.style.display = 'block';//visibility = 'visible';
                    divCabecera.innerHTML = 'Por el momento no hay cupos disponibles.' + '<br/>' + 'Por favor intente mas tarde, puede existir cupos disponibles';
                }
                tdCuposDisponibles.innerHTML = 'Ninguno'; //+'<br/>'+'Por el momento no hay cupos disponibles, intente nuevamente';         
            }
        }
        var param = new SOAPClientParameters();
        param.add('in_Cdcur_codigo', objCurso.CDCUR_CODIGO);
        SOAPClient.invoke(URL_WS + "PublicWS/Cgg_dhu_curso", "numeroInscrito", param, true, CallBackCgg_dhu_numero_asistente);

        function btnSalirAll(frm) {
            $("divBgModal").style.display = "none";
            frm.style.display = "none";
        }

        function showForm(frm) {
            document.getElementById("divBgModal").style.display = "block";
            frm.style.display = "block";
        }
        setHeightForm(500);
}