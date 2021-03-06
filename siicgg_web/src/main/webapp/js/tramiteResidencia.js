$(function() {
    //Funciones necesarias para calculos de fecha.
    Date.prototype.addMilliseconds=function(value){this.setMilliseconds(this.getMilliseconds()+value);return this;};
    Date.prototype.addDays=function(value){return this.addMilliseconds(value*86400000);};

    var swEdit;
    var tipoTramiteSelected = null;
    var modeTranseuntes = false;
    var modeTemporal = false;
    var isRenovacion = false;
    //AC****VARIABLES PARA TRANSEUNTE*******/
    var frmPersona = $("#frmPersona");
    var btnAgregar = $("#btnTranAgregar");
    var btnEliminar = $("#btnTranEliminar");
    var btnEditar = $("#btnTranEditar");
    var btnAceptarIngreso = $("#btnAceptarIngreso");
    var btnSalirIngreso = $("#btnSalirIngreso");
    var tblPersona = document.getElementById("tblPersona");
    var tblResidenciaPersona = document.getElementById("tblResidenciaPersona");

    var attachView = document.getElementById("attachView");
    var btnAceptarAdjunto = $("#btnAceptarAdjunto");

    btnAceptarAdjunto.click(function(){
        btnSalirAll($("attachView"));
        //Con esto deberia arreglarse el problema de que muestra en el frame principal.
        var frame = document.getElementById("frameAttachment");
        frame.src = 'about:blank';
        //frame.src ="bienvenida.jsp?CWPAG_CODIGO=CWPAG1";
    });


    function cancelEditing(){
        $("#cbxActividad").attr("disabled", true);
        $("#dtFechaIngreso").attr('disabled', 'disabled');
        $("#dtFechaIngreso").datepicker( "disable" );
        $("#dtFechaSalida").attr('disabled', 'disabled');
        $("#dtFechaSalida").datepicker( "disable" );
        $("#txtObservacion").attr("disabled", true);
        $("#btnTranAgregar").attr("disabled", true);
        $("#btnTranEliminar").attr("disabled", true);
        $("#btnTranEditar").attr("disabled", true);
        $("#btnGuardarTramiteResidencia").attr("disabled", true);
    }

    function continueEditing(){
        document.getElementById('btnTranAgregar').style.display='block';
        document.getElementById('btnTranEliminar').style.display='block';
        document.getElementById('btnTranEditar').style.display='block';
        $("#cbxActividad").attr("disabled", false);
        $("#dtFechaIngreso").removeAttr('disabled');
        $("#dtFechaIngreso").datepicker( "enable" );
        $("#dtFechaSalida").removeAttr('disabled');
        $("#dtFechaSalida").datepicker( "enable" );
        $("#txtObservacion").attr("disabled", false);
        $("#btnTranAgregar").attr("disabled", false);
        $("#btnTranEliminar").attr("disabled", false);
        $("#btnTranEditar").attr("disabled", false);
        $("#btnGuardarTramiteResidencia").attr("disabled", false);
    }

    var objRepresentante = null;
    $('#txtRepresentante').keypress(function(event) {
        if (event.which == '10')
            consultarRepresentante();
    });
    $('#txtRepresentante').blur(function() {
        if($('#txtRepresentante').val().length >0)
            consultarRepresentante();
    });

    //Buscador de Beneficiarios en la tabla.
    $('#txtBuscarBeneficiario').keypress(function(event) {
        if (event.which == '10'||event.which == '13'){
            if($('#txtBuscarBeneficiario').val()!=null && $('#txtBuscarBeneficiario').val().length>0){
                var rows = document.querySelectorAll("tr[id^=\""+$('#txtBuscarBeneficiario').val()+"\"]");
                if(rows.length>0){
                    document.getElementById("vigentesSizing").scrollTop = rows[0].offsetTop;
                    $("#"+rows[0].id).trigger("click");
                }
            }
        }
    });

    function consultarRepresentante(){
        var documentoValido = validarCedula($('#txtRepresentante').val());
        objRepresentante=null;
        if(!documentoValido){
            new bsxMessageBox({
                title:'Alerta',
                msg: 'El documento del representante debe ser una c&eacute;dula valida.',
                icon: "iconInfo",
                close:function(){
                    $('#txtRepresentante').val('');
                }
            });
        }else{
            consultarDatosPersona(objRepresentante,$('#txtRepresentante').val(),'REPRESENTANTE');
        }
    }


    function showForm(frm){
        document.getElementById("divBgModal").style.display="block";
        document.getElementById(frm.selector).style.display="block";
    }
    function btnSalirAll(frm){
        document.getElementById("divBgModal").style.display="none";
        document.getElementById(frm.selector).style.display="none";
        clearFormPersona();
    }
    btnAgregar.click(function(){
        //txtNumeroDocumento.readOnly = false;
        swEdit = false;
        showForm($("FrmIngresoPersona"));
        //fnHabilitarControles(true);
        //btnAceptarIngreso.disabled = true;
    });

    btnEliminar.click(function(){
        if(filaTablaPersona){
            var tbodyPersona = tblPersona.tBodies[0];
            tbodyPersona.removeChild(filaTablaPersona);
            filaTablaPersona='';
        }
    });

    btnSalirIngreso.click(function(){
        btnSalirAll($("FrmIngresoPersona"));
    });

    btnAceptarIngreso.click(function(){
        fnLlenarPersona(false);
    });

    btnEditar.click(function(){
        if (filaTablaPersona){
            if(posicion>0){
                cbxTipoDocumentoBeneficiario.dom.value=tblPersona.rows[posicion].cells[0].id;
                $('#txtNumDocBeneficiario').val(tblPersona.rows[posicion].cells[1].innerHTML);
                $('#txtNombreBeneficiario').val(tblPersona.rows[posicion].cells[2].innerHTML);
                $('#txtApellidoPaternoBeneficiario').val(tblPersona.rows[posicion].cells[3].innerHTML);
                $('#txtApellidoMaternoBeneficiario').val(tblPersona.rows[posicion].cells[4].innerHTML);
                cbxPaisResidencia.dom.value=tblPersona.rows[posicion].cells[5].id;
                cbxNacionalidad.dom.value=tblPersona.rows[posicion].cells[6].id;
                $('#dtFechaNacimiento').val(tblPersona.rows[posicion].cells[7].innerHTML);
                if(tblPersona.rows[posicion].cells[8].innerHTML == 'M')
                    $("input[name='rdbtnGenero']")[0].checked = true;
                else
                    $("input[name='rdbtnGenero']")[1].checked = true;
                swEdit = true;
                //btnAceptarIngreso.visibled=false;
                showForm($("FrmIngresoPersona"));
            }
        }
    });

    var cont = 1;
    function limpiarTablaPersonas(){
        while(tblPersona.rows.length > 1) {
            tblPersona.deleteRow(1);
        }
    }
    function fnLlenarPersona(_isAuto){
        if(_isAuto!=null && _isAuto==true)
            _isAuto = true;
        else
            _isAuto = false;
        var tbodyPersona = tblPersona.tBodies[0];
        if(_isAuto || verificarInformacionTramite()) {
            if (swEdit == false) {
                if (tblPersona.rows.length > 1) {
                    for (var i = 1; i < tblPersona.rows.length; i++) {
                        if (tblPersona.rows[i].cells[1].innerHTML == $('#txtNumDocBeneficiario').val()) {
                            new bsxMessageBox({
                                title: "Error de ingreso",
                                msg: 'La persona ya pertenece al listado de pre-registro.',
                                icon: "iconError"
                            });
                            return;
                        }
                    }
                }
            } else {
                //tblPersona.rows[posicion].cells[0].id = cbxTipoDocumentoBeneficiario.dom.value;
                //tblPersona.rows[posicion].cells[0].innerHTML = cbxTipoDocumentoBeneficiario.dom.options[cbxTipoDocumentoBeneficiario.dom.selectedIndex].text;
                //tblPersona.rows[posicion].cells[1].id = tmpRecordBeneficiario != null ? tmpRecordBeneficiario[0].CRPER_CODIGO : 'KEYGEN';
                //tblPersona.rows[posicion].cells[1].innerHTML = $('#txtNumDocBeneficiario').val();
                tblPersona.rows[posicion].cells[2].innerHTML = $('#txtNombreBeneficiario').val();
                tblPersona.rows[posicion].cells[3].innerHTML = $('#txtApellidoPaternoBeneficiario').val();
                tblPersona.rows[posicion].cells[4].innerHTML = $('#txtApellidoMaternoBeneficiario').val();
                tblPersona.rows[posicion].cells[5].id = cbxPaisResidencia.dom.value;
                tblPersona.rows[posicion].cells[5].innerHTML = cbxPaisResidencia.dom.options[cbxPaisResidencia.dom.selectedIndex].text;
                tblPersona.rows[posicion].cells[6].id = cbxNacionalidad.dom.value;
                tblPersona.rows[posicion].cells[6].innerHTML = cbxNacionalidad.dom.options[cbxNacionalidad.dom.selectedIndex].text;
                tblPersona.rows[posicion].cells[7].innerHTML = $('#dtFechaNacimiento').val();
                if ($("input[name='rdbtnGenero']:checked").val() == 0) {
                    tblPersona.rows[posicion].cells[8].innerHTML = 'M';
                } else {
                    tblPersona.rows[posicion].cells[8].innerHTML = 'F';
                }
                //tblPersona.rows[posicion].cells[10].id = (txtCodigoTramite.value)?txtCodigoTramite.value:"";
                //tblPersona.rows[posicion].cells[10].innerHTML = txtCodigoTramite.value;
                swEdit = false;
                btnSalirAll($("FrmIngresoPersona"));
                return;
            }
            //Validamos que el beneficiario pase las reglas
            var objBeneficiario = {
                CRPER_CODIGO: tmpRecordAuspiciante[0].CRPER_CODIGO,
                CGGCRPER_CODIGO: tmpRecordBeneficiario != null ? tmpRecordBeneficiario[0].CRPER_CODIGO : 'KEYGEN',
                CRPER_NUM_DOC_IDENTIFIC: $('#txtNumDocBeneficiario').val(),
                CRDID_CODIGO: cbxTipoDocumentoBeneficiario.dom.value,
                CRPER_NOMBRES: $('#txtNombreBeneficiario').val(),
                CRPER_APELLIDO_PATERNO: $('#txtApellidoPaternoBeneficiario').val(),
                CRPER_APELLIDO_MATERNO: $('#txtApellidoMaternoBeneficiario').val(),
                CRPER_GENERO: $("input[name='rdbtnGenero']:checked").val(),
                CRPER_FECHA_NACIMIENTO: $('#dtFechaNacimiento').val(),
                CPAIS_CODIGO: cbxNacionalidad.dom.value,
                CRDPT_CODIGO: crdptCodigo,
                CGG_CPAIS_CODIGO: cbxPaisResidencia.dom.value
            };
            //De una vez hacemos el insert antes de entrar en las reglas de validacion.
            if(!_isAuto) {
                if(!validarReglaTranseuntes(objBeneficiario)){
                    $('#divCargando1').hide();
                    $('#divCargando1').html('Cargando..');
                    return;
                }
            }
            var fila = tbodyPersona.insertRow(tblPersona.rows.length - 1);
            fila.id = 'tr' + cont;
            fila.onclick = function () {
                filaTablaPersona = this;
                posicion = this.sectionRowIndex + 1;
                for (var i = 1; i < tblPersona.rows.length; i++) {
                    tblPersona.rows[i].className = "rowNoSelectTable";
                }
                this.className = "rowSelectTable";

            };

            cont++;

            var celda = fila.insertCell(0);
            celda.id = cbxTipoDocumentoBeneficiario.dom.value;
            celda.innerHTML = cbxTipoDocumentoBeneficiario.dom.options[cbxTipoDocumentoBeneficiario.dom.selectedIndex].text;
            celda.width = 80;

            celda = fila.insertCell(1);
            celda.id = objBeneficiario.CGGCRPER_CODIGO != null ? objBeneficiario.CGGCRPER_CODIGO : 'KEYGEN';
            celda.innerHTML = $('#txtNumDocBeneficiario').val();
            celda.width = 80;

            celda = fila.insertCell(2);
            //celda.id = txtCodigoPersona.value;
            celda.innerHTML = $('#txtNombreBeneficiario').val();
            celda.width = 110;

            celda = fila.insertCell(3);
            celda.innerHTML = $('#txtApellidoPaternoBeneficiario').val();
            celda.width = 110;

            celda = fila.insertCell(4);
            celda.innerHTML = $('#txtApellidoMaternoBeneficiario').val();
            celda.width = 110;

            celda = fila.insertCell(5);
            celda.id = cbxPaisResidencia.dom.value;
            celda.innerHTML = cbxPaisResidencia.dom.options[cbxPaisResidencia.dom.selectedIndex].text;
            celda.width = 80;

            celda = fila.insertCell(6);
            celda.id = cbxNacionalidad.dom.value;
            celda.innerHTML = cbxNacionalidad.dom.options[cbxNacionalidad.dom.selectedIndex].text;
            celda.width = 80;

            celda = fila.insertCell(7);
            celda.innerHTML = $('#dtFechaNacimiento').val();
            celda.width = 80;

            celda = fila.insertCell(8);
            if ($("input[name='rdbtnGenero']:checked").val() == 0) {
                celda.id = '0';
                celda.innerHTML = 'M';
            } else {
                celda.innerHTML = 'F';
                celda.id = '1';
            }
            celda.width = 40;


            //LLAMAMOS A ALFRESCO POR CADA PERSONA
            if(!_isAuto)
                showAlfrescoUploader("Cgg_res_persona", objBeneficiario.CGGCRPER_CODIGO, "tipoResidencia=CRTST7");

            /*var _tableName = encodeURIComponent("Cgg_res_persona");
            var _recordId = encodeURIComponent(objBeneficiario.CGGCRPER_CODIGO);
            var _filter = encodeURIComponent("tipoResidencia=CRTST7");
            PopupCenter("alfrescoMng.html?tableName=" + _tableName + "&recordId=" + _recordId + "&filter=" + _filter, 'Adjuntos', '820', '630');
            */

            btnSalirAll($("FrmIngresoPersona"));
            $('#divCargando1').hide();
            $('#divCargando1').html('Cargando..');
        }else{
            new bsxMessageBox({
                title:'Alerta',
                msg: 'Por favor verifique que todos los datos del tramite hayan sido ingresados correctamente, antes de incluir beneficiarios.',
                icon: "iconInfo"
            });
        }
    }

    function limpiarTablaResidenciasVigentes(){
        while(tblResidenciaPersona.rows.length > 1) {
            tblResidenciaPersona.deleteRow(1);
        }
    }
    function fillTablaResidenciasVigentes(r){
        var records = eval('('+r+')');
        if(records!=null && records.length>0){
            var tbodyPersona = tblResidenciaPersona.tBodies[0];
            //Limpiamos la consulta anterior.
            if(tbodyPersona.rows.length>0){
                for(var j=0;j<tbodyPersona.rows.length;j++)
                    tbodyPersona.removeChild(tbodyPersona.rows[j]);
            }
            for(var i=0;i<records.length;i++) {
                var benef = records[i];
                var agregarFila = true;
                if (isRenovacion)
                    agregarFila = benef.CRTST_PARENT_CODIGO!="CRTST1";
                if (agregarFila) {
                    var fila = tbodyPersona.insertRow(tblResidenciaPersona.rows.length - 1);
                    fila.id = benef.CRPER_NUM_DOC_IDENTIFIC;
                    fila.onclick = function () {
                        $('#txtNumDocBeneficiario').val(this.id);
                        consultarDatosPersona(null, this.id, "BENEFICIARIO");
                        if (isRenovacion) {
                            tmpAplicaTramite = 'true';//En la consulta vienen solo los que se pueden hacer en atencion al cliente
                            $('#cbxTipoResidenciaPadre').val(this.cells[2].id).trigger('change');
                            tmpMotivoResidenciaId = this.cells[1].id;//Seteamos a mano el ID
                            getResponse();
                            $('#txtMotivoResidencia').val(this.cells[1].CRTST_TIPO_DESCRIPCION);
                            tmpAplicaTramite = 'false';
                            //Por si es Transeuntes
                            if (this.cells[2].id == 'CRTST7') {
                                swEdit = false;
                                limpiarTablaPersonas();
                                fnLlenarPersona(true);
                                document.getElementById('btnTranAgregar').style.display='none';
                                document.getElementById('btnTranEliminar').style.display='none';
                                document.getElementById('btnTranEditar').style.display='none';
                            }
                        }
                        for (var i = 1; i < tblResidenciaPersona.rows.length; i++) {
                            tblResidenciaPersona.rows[i].className = "rowNoSelectTable";
                        }
                        this.className = "rowSelectTable";

                    };
                    var celda = fila.insertCell(0);
                    celda.id = benef.CRPER_CODIGO;
                    celda.innerHTML = "<strong>" + benef.CRPER_NUM_DOC_IDENTIFIC + "</strong> - " + benef.CRPER_APELLIDO_PATERNO.toString().toUpperCase() + " " + benef.CRPER_NOMBRES.toString().toUpperCase();
                    celda.width = 400;

                    celda = fila.insertCell(1);
                    celda.id = benef.CRTST_CODIGO;
                    celda.CRTST_TIPO_DESCRIPCION = benef.CRTST_TIPO_DESCRIPCION.toString();
                    celda.innerHTML = "<strong>" + benef.CRTST_TIPO_DESCRIPCION.toString().toUpperCase() + "</strong> - " + benef.CRTST_MOTIVO_DESCRIPCION.toString().toUpperCase();
                    celda.width = 300;

                    celda = fila.insertCell(2);
                    celda.id = benef.CRTST_PARENT_CODIGO;
                    celda.innerHTML = benef.CRRSD_FECHA_INICIO ? benef.CRRSD_FECHA_INICIO.toString().toUpperCase() : "";
                    celda.width = 200;

                    celda = fila.insertCell(3);
                    celda.innerHTML = benef.CRRSD_FECHA_CADUCIDAD ? benef.CRRSD_FECHA_CADUCIDAD.toString().toUpperCase() : "";
                    celda.width = 200;
                }
            }
        }
    }

    function showAlfrescoUploader(_tableName, _recordId, _filter){
        /*$("#frameAttachment").load("alfrescoMng.html?tableName=" + encodeURIComponent(_tableName) + "&recordId=" + encodeURIComponent(_recordId) + "&filter=" + encodeURIComponent(_filter), function(){
            showForm($("attachView"));
        });*/


        var frame = document.getElementById("frameAttachment");
        frame.src = "alfrescoMng.html?tableName=" + encodeURIComponent(_tableName) + "&recordId=" + encodeURIComponent(_recordId) + "&filter=" + encodeURIComponent(_filter);
        showForm($("attachView"));
    }

    function clearFormPersona(){
        try{
            cbxTipoDocumentoBeneficiario.dom.value = null;
            cbxTipoDocumentoBeneficiario.dom.value = null;
            tmpRecordBeneficiario= null;
            $('#txtNumDocBeneficiario').val("");
            $('#txtNombreBeneficiario').val("");
            $('#txtApellidoPaternoBeneficiario').val("");
            $('#txtApellidoMaternoBeneficiario').val("");
            cbxPaisResidencia.dom.value= "";
            cbxNacionalidad.dom.value= "";
            $('#dtFechaNacimiento').val("");
            $('#dtFechaMatrimonio').val("");
            $('#txtCiConyuge').val("");
        }catch(e){
            console.log(e.message);
        }
    }

    //CAMPOS DE FECHAS Y ACTIVIDAD:
    $('#dtFechaIngreso').datepicker({
        showOn: 'button',
        buttonImage: 'css/icon/date.gif',
        buttonImageOnly: false,
        appendText: '(dd/mm/yyyy)',
        dateFormat: 'dd/mm/yy',
        currentText: 'Now',
        defaultDate:null,
        minDate: new Date(),
        changeYear: false,
        changeMonth: true,
        showButtonPanel: false,
        nextText: 'Siguiente',
        prevText: 'Anterior',
        beforeShow: function(input, inst)
        {
            inst.dpDiv.css({marginLeft: (input.offsetWidth+50) + 'px'});
        },
        onSelect: function(dateText) {
            if(tipoTramiteSelected!= null && tipoTramiteSelected.CRTST_NUMERO_DIAS!=null){
                var today = $(this).datepicker( "getDate" );
                var limit = today.addDays(tipoTramiteSelected.CRTST_NUMERO_DIAS-1);
                $("#dtFechaSalida").datepicker( "option", "maxDate", limit );
            }
        }
    });
    $('#dtFechaSalida').datepicker({
        showOn: 'button',
        buttonImage: 'css/icon/date.gif',
        buttonImageOnly: false,
        appendText: '(dd/mm/yyyy)',
        dateFormat: 'dd/mm/yy',
        currentText: 'Now',
        defaultDate:null,
        minDate: new Date(),
        changeYear: false,
        changeMonth: true,
        showButtonPanel: false,
        nextText: 'Siguiente',
        prevText: 'Anterior',
        beforeShow: function(input, inst)
        {
            inst.dpDiv.css({marginLeft: (input.offsetWidth+50) + 'px'});
        }
    });

    var codigoActividad=null;
    var cbxActividad = new bsxComboBox({
        id:"cbxActividad",
        renderTo:"divActividad",
        displayField:"CGCRG_NOMBRE",
        valueField:"CGCRG_CODIGO",
        webService:{
            url:URL_WS+"Cgg_gem_cargo",
            method:"selectAll",
            params:[
                {name:"format",value:"JSON"}

            ]
        },
        events:{
            load:function(v){

                $('#cbxActividad').prepend("<option value=></option>");
                $("#cbxActividad").val(0);

            }
        }
    });
    cbxActividad.reload();
    
    
    var tmpConfiguracion;//Variable utilizada para almacenar datos de configuracion consultados en la base;
    var tmpRecordPersona;//Variable almacena informacion de persona
    var tmpRecordBeneficiario;
    var reglaValidacion = null; //variable utilizada para almacenar los datos de las reglas de validacion a aplicar como control 
    var colReglaValidacion = null;
    var urlReport = null;
    var tmpRecordAuspiciante;
    var tmpMotivoResidencia;
    var tmpMotivoResidenciaId;
    var tmpAplicaTramite = "false";

    /******************INICIO DE DEFINICION DE VARIABLES PARA REGLA DE VALIDACION DE INFORMAICON*******************/
    var crperCodigo = null;
    var cggcrperCodigo = null;
    var crperNumDocIdentific=null;
    var cggCrperFechaNacimiento = null;
    var repCrperCodigo = null;
    var crdptCodigo = 'CRDPT_AT001';
    var valFechaIngreso = null;
    var valFechaSalida = null;

    /******************FIN DE DEFINICION DE VARIABLES PARA REGLA DE VALIDACION DE INFORMAICON*******************/

    /******************INICIO DE DEFINICION DE VARIABLES PARA LOS CONTACTOS DE LA PERSONA*******************/
    var btnNuevoCgg_gem_contacto_persona = document.getElementById("btnNuevoCgg_gem_contacto_persona");
    var btnEditarCgg_gem_contacto_persona = document.getElementById("btnEditarCgg_gem_contacto_persona");
    var btnEliminarCgg_gem_contacto_persona = document.getElementById("btnEliminarCgg_gem_contacto_persona");
    var txtCrprc_codigo = document.getElementById("txtCrprc_codigo");
    var txtCrprc_contacto = document.getElementById("txtCrprc_contacto");
    var btnGuardarCgg_gem_contacto_persona = document.getElementById("btnGuardarCgg_gem_contacto_persona");
    var btnSalirCgg_gem_contacto_persona = document.getElementById("btnSalirCgg_gem_contacto_persona");
    var filaTablaContacto;
    var posicion;


    /******************INICIO DE DEFINICION DE VARIABLES PARA DOCUMENTACION SOLICITADA*******************/
    var filaTablaDocumentacion;
    var posicionD;


    /******************FIN DE DEFINICION DE VARIABLES PARA LOS CONTACTOS DE LA PERSONA*******************/

    if (document.getElementById("txtUsuario").value != "false") {
        document.getElementById("divLogineo").style.display = 'none';
        document.getElementById("myForm").style.display = 'block';
    }else{
        document.getElementById("myForm").style.display = 'none';
        document.getElementById("divLogineo").style.display = 'block';
        document.getElementById("divLogineo").innerHTML = msgUsuarioLogin;
        document.getElementById("spanMsgUsuarioLogin").onclick = function(){
            parent.window.location = 'PrivateWS/SessionWeb';
        }
        setHeightForm();
        return;
    }
    var TypeTramite = {
        RESIDENCIA:'13',
        VEHICULOS:'12'
    };

    $("#tabs").tabs({
        collapsible: false
    });
    //DATOS DE LOS PARAMETROS DE CONFIGURACION QUE SE UTILIZARAN PARA VERIFICACIONES Y OPERACIONES
    var dataConfiguracion={
        TIPO_DOCUMENTO:'CONF33',
        RESIDENCIA_PERMANENTE:'CRTST1',
        RESIDENCIA_TEMPORAL:'CRTST2',
        TRANSEUNTE:'CRTST7',
        REVOCATORIA:'CRTST65'
    };



    $('#dtFechaNacimiento').datepicker({
        showOn: 'button',
        buttonImage: 'css/icon/date.gif',
        buttonImageOnly: false,
        appendText: '(dd/mm/yyyy)',
        dateFormat: 'dd/mm/yy',
        currentText: 'Now',
        defaultDate:null,
        maxDate: new Date(),
        minDate: new Date(1930, 1 - 1, 1),
        changeYear: true,
        changeMonth: true,
        showButtonPanel: true,
        nextText: 'Siguiente',
        prevText: 'Anterior',
        beforeShow: function(input, inst)
        {
            inst.dpDiv.css({marginLeft: (input.offsetWidth+50) + 'px'});
        }
    });

    $('#dtFechaMatrimonio').datepicker({
        showOn: 'button',
        buttonImage: 'css/icon/date.gif',
        buttonImageOnly: false,
        appendText: '(dd/mm/yyyy)',
        dateFormat: 'dd/mm/yy',
        currentText: 'Now',
        defaultDate:null,
        maxDate: new Date(),
        minDate: new Date(1930, 1 - 1, 1),
        changeYear: true,
        changeMonth: true,
        showButtonPanel: true,
        nextText: 'Siguiente',
        prevText: 'Anterior',
        beforeShow: function(input, inst)
        {
            inst.dpDiv.css({marginLeft: (input.offsetWidth+50) + 'px'});
        }
    });

    //PRUEBA ADJUNTO

   /* var adjunto = new Ext.ux.form.AlfrescoFM({
        id:'identificador_componente',  //(opcional)
        name:'nombre_componente',       //(opcional)
        fieldLabel :'Adjuntos',         //(opcional -> Despliega la etiqueta del comoponente. Si no se define, aparece solo el botón)
        text: 'Adjunto',                //(opcional -> Texto del botón)
        tableName : 'CGG_TABLA_DE REFERENCIA',
        recordID : 'RECORD_ID',
        filter: 'FILTRO_PARA_EL_MODELO' //(opcional)
    });*/


    //



    var cbxPaisResidencia = new bsxComboBox({
        id:"cbxPaisResidencia",
        renderTo:"divPaisResidencia",
        displayField:"CPAIS_NOMBRE",
        valueField:"CPAIS_CODIGO",
        webService:{
            url:URL_WS+"Cgg_pais",
            method:"selectAll",
            params:[
                {name:"format",value:"JSON"}
            ]
        },
        events:{
            load:function(v){
                $('#cbxPaisResidencia').prepend("<option value=></option>");
                $("#cbxPaisResidencia").val(0);
            }
        }
    });
    cbxPaisResidencia.reload();

    var cbxNacionalidad = new bsxComboBox({
        id:"cbxNacionalidad",
        renderTo:"divNacionalidadBeneficiario",
        displayField:"CGNCN_NACIONALIDAD",
        valueField:"CGNCN_CODIGO",
        webService:{
            url:URL_WS+"Cgg_nacionalidad",
            method:"selectAll",
            params:[
                {name:"format",value:"JSON"}
            ]
        },
        events:{
            load:function(v){
                $('#cbxNacionalidad').prepend("<option value=></option>");
                $("#cbxNacionalidad").val(0);
            }
        }
    });
    cbxNacionalidad.reload();

    var cbxTipoDocumentoBeneficiario = new bsxComboBox({
        id:"cbxTipoDocumentoBeneficiario",
        renderTo:"divTipoIdentificacionBeneficiario",
        displayField:"CRDID_DESCRIPCION",
        valueField:"CRDID_CODIGO",
        webService:{
            url:URL_WS+"Cgg_res_documento_identificacio",
            method:"selectAll",
            params:[
                {name:"format",value:"JSON"}
            ]
        },
        events:{
            load:function(v){

            }
        }
    });
    cbxTipoDocumentoBeneficiario.reload();

    var cbxTipoResidenciaPadre = new bsxComboBox({
        id:"cbxTipoResidenciaPadre",
        renderTo:"divTipoResidenciaPadre",
        displayField:"CRTST_DESCRIPCION",
        valueField:"CRTST_CODIGO",
        webService:{
            url:URL_WS+"Cgg_res_tipo_solicitud_tramite",
            method:"selectTipoPadreATC",
            params:[
                {name:"format",value:"JSON"},
                {name:"inCgcnf_codigo",value:TypeTramite.RESIDENCIA}
            ]
        },
        events:{
            load:function(v){
                $('#cbxTipoResidenciaPadre').prepend("<option value=></option>");
                $("#cbxTipoResidenciaPadre").val(0);
            }
        }
    });
    cbxTipoResidenciaPadre.reload();

    /*var cbxTipoSolicitudResidencia = new bsxComboBox({
     id:"cbxTipoSolicitudResidencia",
     renderTo:"divTipoSolicitudResidencia",
     displayField:"CRTST_DESCRIPCION",
     valueField:"CRTST_CODIGO",
     webService:{
     url:URL_WS+"Cgg_res_tipo_solicitud_tramite",
     method:"selectTipoAtencionCliente",
     params:[
     {name:"format",value:"JSON"},
     {name:"inCrtst_codigo",value:""},
     {name:"inCgcnf_codigo",value:TypeTramite.RESIDENCIA}
     ]
     },
     events:{
     load:function(v){

     $('#cbxTipoSolicitudResidencia').prepend("<option value=></option>");
     $("#cbxTipoSolicitudResidencia").val(0);
     }
     }
     });*/

    /* $("select#cbxTipoSolicitudResidencia").change(function(){
     //Consulta de regla de validacion.
     var scpReglaValidacion= new SOAPClientParameters();
     scpReglaValidacion.add('inCrtst_codigo',$(this).val());
     scpReglaValidacion.add('format',TypeFormat.JSON);
     var tmpReglaValidacion = SOAPClient.invoke(URL_WS+'Cgg_regla_validacion','selectReglaTipoSolicitud',scpReglaValidacion, false,null);
     try{
     reglaValidacion = tmpReglaValidacion;
     colReglaValidacion = eval(tmpReglaValidacion);
     }catch(inErr){
     colReglaValidacion=null;
     }

     });*/

    function consultarReglaValidacion(inCrtst_codigo_select, inCrtt_codigo_select)
    {
        //Consulta de regla de validacion.
        var scpReglaValidacion= new SOAPClientParameters();
        scpReglaValidacion.add('inCrtst_codigo',inCrtst_codigo_select);
        scpReglaValidacion.add('inCrtt_codigo',inCrtt_codigo_select);
        scpReglaValidacion.add('format',TypeFormat.JSON);
        var tmpReglaValidacion = SOAPClient.invoke(URL_WS+'Cgg_regla_validacion','selectReglaTipoSolicitud',scpReglaValidacion, false,null);
        try{
            reglaValidacion = tmpReglaValidacion;
            colReglaValidacion = eval(tmpReglaValidacion);
        }catch(inErr){
            colReglaValidacion=null;
        }
    }

    var cbxIslaTramite = new bsxComboBox({
        id:"cbxIslaTramite",
        renderTo:"divIslaTramite",
        displayField:"CISLA_NOMBRE",
        valueField:"CISLA_CODIGO",
        webService:{
            url:URL_WS+"Cgg_isla",
            method:"selectAllAtencionCliente",
            params:[
                {name:"format",value:"JSON"}
            ]
        },
        events:{
            load:function(v){
                $('#cbxIslaTramite').prepend("<option value=></option>");
                $("#cbxIslaTramite").val(0);

            }
        }
    });
    cbxIslaTramite.reload();

    //MO
    var codigoTipoTramite='';
    var cbxTipoTramite = new bsxComboBox({
        id:"cbxTipoTramite",
        renderTo:"divTipoTramite",
        displayField:"CRTT_NOMBRE",
        valueField:"CRTT_CODIGO",
        webService:{
            url:URL_WS+"Cgg_tipo_tramite",
            method:"selectAll",
            params:[
                {name:"format",value:"JSON"}

            ]
        },
        events:{
            load:function(v){

                $('#cbxTipoTramite').prepend("<option value=></option>");
                $("#cbxTipoTramite").val(0);

            }
        }
    });

    cbxTipoTramite.addEventListener('change', function(e){
        limpiarTabla();
        codigoTipoTramite=cbxTipoTramite.getRowSelected().CRTT_CODIGO;
        cargarDocumentos(codigoTipoTramite);
        isRenovacion = false;
        if(codigoTipoTramite=='CRTT7'){//REVOCATORIA
            var cbxTR=document.getElementById("cbxTipoResidenciaPadre");
            $('#cbxTipoResidenciaPadre').val('CRTST65').trigger('change');
            cbxTR.disabled=true;
            var cbxDB=document.getElementById("cbxTipoDocumentoBeneficiario");
            cbxDB.disabled=true;
            var btnMotivo = document.getElementById("btnBuscarMotivo");
            btnMotivo.disabled=false;
            var txtMotivo = document.getElementById("txtMotivoResidencia");
            txtMotivo.disabled=false;
            var cbxNB=document.getElementById("txtNumDocBeneficiario");
            cbxNB.disabled=true;
            var cbxNombreB=document.getElementById("txtNombreBeneficiario");
            cbxNombreB.disabled=true;
            var cbxAPB=document.getElementById("txtApellidoPaternoBeneficiario");
            cbxAPB.disabled=true;
            var cbxAMB=document.getElementById("txtApellidoMaternoBeneficiario");
            cbxAMB.disabled=true;
            var cbxFN=document.getElementById("dtFechaNacimiento");
            cbxFN.disabled=true;
        }else if(codigoTipoTramite=='CRTT6'){//RENOVACION
            isRenovacion = true;
            //Consulta en la base de las residencias vigentes que el auspiciante tenga.
            document.getElementById("divResidenciasVigentes").style.display = "block";
            //Llenamos la tabla.
            limpiarTablaResidenciasVigentes();
            var param = new SOAPClientParameters();
            param.add('inCrper_codigo',tmpRecordAuspiciante[0].CRPER_CODIGO);
            SOAPClient.invoke(URL_WS+"Cgg_res_residencia","selectResidenciasByAuspiciante",param, true, fillTablaResidenciasVigentes);
            var cbxTR=document.getElementById("cbxTipoResidenciaPadre");
            cbxTR.disabled=true;
            var btnMotivo = document.getElementById("btnBuscarMotivo");
            btnMotivo.disabled=true;
            var txtMotivo = document.getElementById("txtMotivoResidencia");
            txtMotivo.disabled=true;
            var cbxDB=document.getElementById("cbxTipoDocumentoBeneficiario");
            cbxDB.disabled=true;
            var cbxNB=document.getElementById("txtNumDocBeneficiario");
            cbxNB.disabled=true;
            var cbxNombreB=document.getElementById("txtNombreBeneficiario");
            cbxNombreB.disabled=true;
            var cbxAPB=document.getElementById("txtApellidoPaternoBeneficiario");
            cbxAPB.disabled=true;
            var cbxAMB=document.getElementById("txtApellidoMaternoBeneficiario");
            cbxAMB.disabled=true;
            var cbxFN=document.getElementById("dtFechaNacimiento");
            cbxFN.disabled=true;
        }else{
            var cbxIT=document.getElementById("cbxIslaTramite");
            cbxIT.disabled=false;
            var cbxTR=document.getElementById("cbxTipoResidenciaPadre");
            $('#cbxTipoResidenciaPadre').val('');
            cbxTR.disabled=false;
            var btnMotivo = document.getElementById("btnBuscarMotivo");
            btnMotivo.disabled=false;
            var txtMotivo = document.getElementById("txtMotivoResidencia");
            txtMotivo.disabled=false;
            var cbxBM=document.getElementById("btnBuscarMotivo");
            cbxBM.disabled=false;
            var cbxDB=document.getElementById("cbxTipoDocumentoBeneficiario");
            cbxDB.disabled=false
            var cbxNB=document.getElementById("txtNumDocBeneficiario");
            cbxNB.disabled=false;
            var cbxNombreB=document.getElementById("txtNombreBeneficiario");
            cbxNombreB.disabled=false;
            var cbxAPB=document.getElementById("txtApellidoPaternoBeneficiario");
            cbxAPB.disabled=false;
            var cbxAMB=document.getElementById("txtApellidoMaternoBeneficiario");
            cbxAMB.disabled=false;
            var cbxFN=document.getElementById("dtFechaNacimiento");
            cbxFN.disabled=false;
            document.getElementById("divResidenciasVigentes").style.display = "none";
        }
    });
    cbxTipoTramite.reload();

    /////


    /**
     *	DETERMINA DATOS RELACIONADOS CON EL USUARIO LOGONEADO.
     **/
    //if ($('#txtUsuario").value =="false")return;

    var userObject;
    var codigoPersona='';

    $.ajax({
        type: "POST",
        url: URL_WS+"SessionManager?request=userobject",
        data: "{}",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            codigoPersona = response.CRPER_CODIGO;
            cargarContactos(codigoPersona);

            /*userObject = eval("("+response.responseText+")");
             var contactos = (typeof response.d) == 'string' ?
             eval('(' + response.d + ')') :
             response.d;*/
            //alert(userObject);
        },
        error: function (msg) {
            alert(msg);
        }
    });

    /**
     *	CONTACTOS
     **/

    function cargarContactos(codPersona){

        /**
         *Creacion de un combobox con datos de un webservices
         **/
        var cbxTipoContacto = new bsxComboBox({
            id:"cbxTipoContacto",
            style:"width: 280px; margin: 10px;",
            renderTo:"tdCbxTipoContacto",
            displayField:"CRTCO_NOMBRE",
            valueField:"CRTCO_CODIGO",
            webService:{
                url:URL_WS+"Cgg_res_tipo_contacto",
                method:"selectAll",
                params:[
                    {name:"format",value:"JSON"}
                ]
            }
        });
        cbxTipoContacto.reload();

        function CallBackCgg_res_contacto_persona(r){
            var a = eval('('+r+')');
            var tbodyContactosPersona = document.getElementById("tblContactosPersona").tBodies[0];
            for(i=0;i<a.dataSet.length;i++){
                var fila = insertarFila();
                //Tipo de Contacto
                var celda= fila.insertCell(0);
                celda.id = a.dataSet[i].CRTCO_CODIGO;
                celda.innerHTML = a.dataSet[i].CRTCO_NOMBRE;
                celda.width = 225;

                //Contacto
                celda= fila.insertCell(1);
                celda.id = a.dataSet[i].CRPRC_CODIGO;
                celda.innerHTML = a.dataSet[i].CRPRC_CONTACTO;
                celda.width = 250;

                celda= fila.insertCell(2);
                celda.innerHTML = a.dataSet[i].CRPRC_DESCRIPCION;
                celda.width = 80;
            }
        }

        var param = new SOAPClientParameters();
        param.add('format','JSON');
        param.add('start',0);
        param.add('limit',10);
        param.add('sort','CRTCO_CODIGO');
        param.add('dir','ASC');
        param.add('keyword','');
        param.add('inCrper_codigo',codPersona);
        SOAPClient.invoke(URL_WS+"Cgg_res_persona_contacto","selectPageContactosPersona",param, true, CallBackCgg_res_contacto_persona);


        btnNuevoCgg_gem_contacto_persona.onclick=function(){
            swEdit=false;
            cbxTipoContacto.dom.disabled = false;
            limpiarControlesContactoPersona();
            showForm(FrmContactoPersona);
        }
        btnEditarCgg_gem_contacto_persona.onclick=function(){
            cbxTipoContacto.dom.disabled = true;
            if (filaTablaContacto){
                if(posicion>0){
                    var tblContacto = document.getElementById("tblContactosPersona");
                    cbxTipoContacto.dom.value = tblContacto.rows[posicion].cells[0].id;
                    txtCrprc_contacto.value = tblContacto.rows[posicion].cells[1].id;
                    txtCrprc_contacto.value = tblContacto.rows[posicion].cells[1].innerHTML;
                    swEdit = true;
                    showForm(FrmContactoPersona);
                }
            }else{
                new bsxMessageBox({
                    title:"Contacto",
                    msg:"Seleccione un contacto",
                    icon:"iconInfo"
                });
            }
        }
        btnEliminarCgg_gem_contacto_persona.onclick = function(){
            swEdit=false;
            if(filaTablaContacto){
                if(confirm("Esta seguro que desea eliminar el contacto?")){
                    var tbodyContacto = document.getElementById("tblContactosPersona").tBodies[0];
                    tbodyContacto.removeChild(filaTablaContacto);
                    filaTablaContacto='';
                }
            }else{
                new bsxMessageBox({
                    title:"Contacto",
                    msg:"Seleccione un Contacto",
                    icon:"iconInfo"
                });
            }
        }
        /**
         *	Permite crear un nuevo formulario para ingresos o modificaciones de datos
         **/
        function showForm(frm){
            $('#txtCrprc_contacto').removeClass("form-line-error");
            document.getElementById("divBgModal").style.display="block";
            frm.style.display="block";
        }
        function btnSalirAll(frm){
            divBgModal.style.display="none";
            frm.style.display="none";
        }
        function insertarFila(){
            var tbodyContactosPersona = document.getElementById("tblContactosPersona").tBodies[0];
            var fila =tbodyContactosPersona.insertRow(-1);
            fila.onclick = function(){
                filaTablaContacto = this;
                posicion = this.sectionRowIndex+1;
                for (var i=1;i<document.getElementById("tblContactosPersona").rows.length;i++) {
                    document.getElementById("tblContactosPersona").rows[i].className = "rowNoSelectTable";
                }
                this.className="rowSelectTable";
            };
            return fila;
        }
        /**
         *	GUARDAR O ACTUALIZAR DATOS SOBRE CONTACTOS DE LA PERSONA
         */
        btnGuardarCgg_gem_contacto_persona.onclick=function(){
            if(txtCrprc_contacto.value.length ==0 )
            {
                $('#txtCrprc_contacto').addClass("form-line-error");
                return;
            }
            if (swEdit==true){
                var tbodyContacto = document.getElementById("tblContactosPersona").tBodies[0];
                tbodyContacto.removeChild(filaTablaContacto);
                filaTablaContacto='';
            }
            var fila = insertarFila();
            //Tipo de Contacto
            var celda= fila.insertCell(0);
            celda.id = cbxTipoContacto.dom.value;
            celda.innerHTML = cbxTipoContacto.dom.options[cbxTipoContacto.dom.selectedIndex].text;
            celda.width = 100;

            //Contacto
            celda= fila.insertCell(1);
            celda.id = txtCrprc_codigo.value?txtCrprc_codigo.value:'KEYGEN';
            celda.innerHTML = txtCrprc_contacto.value;
            celda.width = 150;

            celda= fila.insertCell(2);
            celda.innerHTML = '';
            celda.width = 80;
            btnSalirAll(FrmContactoPersona);
        }
        btnSalirCgg_gem_contacto_persona.onclick=function(){
            btnSalirAll(FrmContactoPersona);
        }
        function limpiarControlesContactoPersona(){
            txtCrprc_codigo.value = '';
            txtCrprc_contacto.value = '';
        }
    }

    function obtenerJSONContactos(){
        /*
         * Formar Json de la tabla tblPersona
         */
        var jsonContactos = '[';
        var i=0;
        var textos='';
        var tblContacto = document.getElementById("tblContactosPersona");
        for (var i=1;i<tblContacto.rows.length;i++) {
            jsonContactos += ((i==1)?'':',')+'{"CRPRC_CODIGO":"'+tblContacto.rows[i].cells[1].id+'","CRPER_CODIGO":"'+codigoPersona+'",'+
                    '"CRTCO_CODIGO":"'+tblContacto.rows[i].cells[0].id+'",'+
                    '"CRPRC_DESCRIPCION":"'+tblContacto.rows[i].cells[2].innerHTML+'",'+
                    '"CRPRC_CONTACTO":"'+tblContacto.rows[i].cells[1].innerHTML+'"}';
        }
        jsonContactos += ']';
        return jsonContactos;

    }

    //AC
    //Requisitos

    var dsTipoParticipante = [[0,'Auspiciante'],[1,'Beneficiario'],[2,'Conyuge/Conviviente'],[3,'Padre/Madre'],[4,'General']];

    function getParticipante(codParticipante){
        for(var i=0;i<dsTipoParticipante.length;i++){
            var item=dsTipoParticipante[i];
            if(item[0]==codParticipante){
                return item[1];
            }
        }
        return "";
    }

    function cargarRequisitos(crtst_codigo){
        function callBackCgg_res_requisitos(r) {
            var a = eval('('+r+')');
            var tbodyDocumentacionSolicitada = document.getElementById("tblRequisitos").tBodies[0];
            for(var i=0;i<a.length;i++){
                var fila = insertarFila();
                //Tipo de Documento
                var celda= fila.insertCell(0);
                celda.id = a[i].CRREQ_CODIGO;
                celda.innerHTML = a[i].CRREQ_DESCRIPCION;

                //Participante
                celda= fila.insertCell(1);
                celda.id = a[i].CRREQ_CODIGO;
                celda.innerHTML = getParticipante(a[i].CRSRQ_PARTICIPANTE);
            }

        }
        limpiarRequisitos();
        var param = new SOAPClientParameters();
        param.add('inCrtst_codigo',crtst_codigo);
        param.add('inCrtra_codigo',null);
        param.add('format',"JSON");
        SOAPClient.invoke(URL_WS+"Cgg_res_requisito_tramite","selectTramiteTipoSolcitudRequisito",param, true, callBackCgg_res_requisitos);

        function insertarFila(){
            var tbodyDocumentacionSolicitada = document.getElementById("tblRequisitos").tBodies[0];
            var fila =tbodyDocumentacionSolicitada.insertRow(-1);
            fila.onclick = function(){
                filaTablaDocumentacion = this;
                posicionD = this.sectionRowIndex+1;
                for (var i=1;i<document.getElementById("tblRequisitos").rows.length;i++) {
                    document.getElementById("tblRequisitos").rows[i].className = "rowNoSelectTable";
                }
                this.className="rowSelectTable";
            };
            return fila;
        }
    }

    function limpiarRequisitos(){
        var tbodyDocumentacionSolicitada = document.getElementById("tblRequisitos").tBodies[0];
        while(tbodyDocumentacionSolicitada.rows.length > 0) {
            tbodyDocumentacionSolicitada.deleteRow(0);
        }
    }


    //MO

    /**
     *	DOCUMENTOS
     **/

    function cargarDocumentos(crtst_codigo){

        function CallBackCgg_res_documentacion_solicitada(r){
            var a = eval('('+r+')');
            var tbodyDocumentacionSolicitada = document.getElementById("tblDocumentacion").tBodies[0];

            for(i=0;i<a.length;i++){
                if(a[i].insertable!=null && a[i].insertable==true){
                    var fila = insertarFila();
                    //Tipo de Documento
                    var celda= fila.insertCell(0);
                    celda.id = a[i].code;
                    celda.innerHTML = a[i].fileDescription;
                    celda.width = 600;
                }
            }
        }
        limpiarTabla();
        var param = new SOAPClientParameters();
        param.add('tableName','Cgg_res_tramite');
        param.add('filter',"crtst_codigo='"+crtst_codigo+"'");
        SOAPClient.invoke(URL_WS+"Alf_query","getLocalMetadata",param, true, CallBackCgg_res_documentacion_solicitada);

        function insertarFila(){
            var tbodyDocumentacionSolicitada = document.getElementById("tblDocumentacion").tBodies[0];
            var fila =tbodyDocumentacionSolicitada.insertRow(-1);
            fila.onclick = function(){
                filaTablaDocumentacion = this;
                posicionD = this.sectionRowIndex+1;
                for (var i=1;i<document.getElementById("tblDocumentacion").rows.length;i++) {
                    document.getElementById("tblDocumentacion").rows[i].className = "rowNoSelectTable";
                }
                this.className="rowSelectTable";
            };
            return fila;
        }

    }

    function limpiarTabla(){
        var tbodyDocumentacionSolicitada = document.getElementById("tblDocumentacion").tBodies[0];
        while(tbodyDocumentacionSolicitada.rows.length > 0) {
            tbodyDocumentacionSolicitada.deleteRow(0);
        }
    }


    //




    $("select#cbxTipoResidenciaPadre").change(function(){
        //cbxTipoSolicitudResidencia.setParam('inCrtst_codigo',$(this).val());
        //cbxTipoSolicitudResidencia.reload();
        $('#txtMotivoResidencia').val('');
        tmpMotivoResidenciaId=null;
        selectMotivoResidenciaTree($(this).val());

        //AC -> QUEMADO! Cambiar a Modo Transeuntes si fuese el caso (CRTST7)
        var personaForm = document.getElementById("personaForm");
        personaForm.style.display = "block";

        if(!isRenovacion)
            document.getElementById("divResidenciasVigentes").style.display = "none";

        document.getElementById("divRepresentante").style.display = "none";
        document.getElementById("divDatosTranseunte").style.display = "none";
        document.getElementById("divDatosActividad").style.display = "none";
        modeTemporal = false;

        modeTranseuntes = false;
        var auspiciado = document.getElementById("divAuspiciado");
        document.getElementById("divFieldActividad").style.display = "block";
        document.getElementById("divMultiTranseuntes").style.display = "none";
        auspiciado.style.display = "block";
        document.getElementById("liAuspiciado").style.display = "block";
        auspiciado.appendChild(personaForm);
        $("#tabs").tabs("select",0);

        switch ($(this).val()){
            case 'CRTST65':
                //Consulta en la base de las residencias vigentes que el auspiciante tenga.
                document.getElementById("divDatosActividad").style.display = "block";
                document.getElementById("divFieldActividad").style.display = "none";
                document.getElementById("divResidenciasVigentes").style.display = "block";
                //Llenamos la tabla.
                limpiarTablaResidenciasVigentes();
                var param = new SOAPClientParameters();
                param.add('inCrper_codigo',tmpRecordAuspiciante[0].CRPER_CODIGO);
                SOAPClient.invoke(URL_WS+"Cgg_res_residencia","selectResidenciasByAuspiciante",param, true, fillTablaResidenciasVigentes);
                break;
            case 'CRTST2':
                document.getElementById("divDatosTranseunte").style.display = "block";
                document.getElementById("divDatosActividad").style.display = "block";
                document.getElementById("divRepresentante").style.display = "block";
                modeTemporal = true;
                break;
            case 'CRTST7':
                modeTranseuntes = true;
                $("#tabs").tabs("select",1);
                document.getElementById("divMultiTranseuntes").style.display = "block";
                document.getElementById("divAuspiciado").style.display = "none";
                document.getElementById("liAuspiciado").style.display = "none";
                document.getElementById("divDatosTranseunte").style.display = "block";
                document.getElementById("divDatosActividad").style.display = "block";
                var contentPersona = document.getElementById("contentPersona");
                contentPersona.appendChild(personaForm);
                break;

        }

        /*if($(this).val()=='CRTST65'){
            //Consulta en la base de las residencias vigentes que el auspiciante tenga.
            document.getElementById("divResidenciasVigentes").style.display = "block";
            //Llenamos la tabla.
            var param = new SOAPClientParameters();
            param.add('inCrper_codigo',tmpRecordAuspiciante[0].CRPER_CODIGO);
            SOAPClient.invoke(URL_WS+"Cgg_res_residencia","selectResidenciasByAuspiciante",param, true, fillTablaResidenciasVigentes);

        }else{
            document.getElementById("divResidenciasVigentes").style.display = "none";
        }

        if($(this).val()=='CRTST2'){
            document.getElementById("divDatosTranseunte").style.display = "block";
            document.getElementById("divDatosActividad").style.display = "block";
            document.getElementById("divRepresentante").style.display = "block";
            modeTemporal = true;
        }else if(modeTemporal){
            document.getElementById("divRepresentante").style.display = "none";
            document.getElementById("divDatosTranseunte").style.display = "none";
            document.getElementById("divDatosActividad").style.display = "none";
            modeTemporal = false;
        }

        if($(this).val()==='CRTST7'){
            modeTranseuntes = true;
            $("#tabs").tabs("select",1);
            document.getElementById("divMultiTranseuntes").style.display = "block";
            document.getElementById("divAuspiciado").style.display = "none";
            document.getElementById("liAuspiciado").style.display = "none";
            document.getElementById("divDatosTranseunte").style.display = "block";
            document.getElementById("divDatosActividad").style.display = "block";
            var contentPersona = document.getElementById("contentPersona");
            contentPersona.appendChild(personaForm);
        }else if(modeTranseuntes){
            modeTranseuntes = false;
            var auspiciado = document.getElementById("divAuspiciado");
            document.getElementById("divMultiTranseuntes").style.display = "none";
            auspiciado.style.display = "block";
            document.getElementById("liAuspiciado").style.display = "block";
            document.getElementById("divDatosTranseunte").style.display = "none";
            document.getElementById("divDatosActividad").style.display = "none";
            auspiciado.appendChild(personaForm);
            $("#tabs").tabs("select",0);
        }*/
    });



    $("#btnBuscarBeneficiario").click(function() {
        consultarBeneficiario();

    });

    /*
     * MANEJO DE EVENTOS DE CONTROL txtNumDocBeneficiario PARA CONSULTA DE INFORMACION DE BENEFICIARIO
     * */
    $('#txtNumDocBeneficiario').keypress(function(event) {
        if (event.which == '13') {

            consultarBeneficiario();

        }

    });

    $('#txtNumDocBeneficiario').blur(function() {
        if($('#txtNumDocBeneficiario').val().length >0)
        {
            consultarBeneficiario();
        }
    });

    function consultarBeneficiario() {
        var documentoValido = true;
        if (dataConfiguracion.TIPO_DOCUMENTO == $('#cbxTipoDocumentoBeneficiario').val())
        {
            if ( $('#txtNumDocAuspiciante').val() !=   $('#txtNumDocBeneficiario').val() )
            {
                documentoValido = validarCedula($('#txtNumDocBeneficiario').val());
                manejarCtrlsBeneficiario(true);
            }
            else
            {
                documentoValido = false;
            }
        }
        if(documentoValido)
        {
            tmpRecordBeneficiario = null;
            consultarDatosPersona(tmpRecordBeneficiario,$('#txtNumDocBeneficiario').val(),'BENEFICIARIO');
            manejarCtrlsBeneficiario(true);

        }
        else
        {
            //alert('');
            new bsxMessageBox({
                title:'Alerta',
                msg: 'El documento ingresado no es valido',
                icon: "iconInfo",
                close:function(){
                    tmpRecordBeneficiario = null;
                    limpiarCtrlsBeneficiario();
                }
            });
        }
    }
    /*
     *OBTIENE LOS DATOS DE UN PARAMETRO DE CONFIGURACION
     * */
    function selectDataConfiguracion(inParam){
        function CallBackConfiguracion(r){
            tmpConfiguracion = eval(r);
            if(inParam == dataConfiguracion.TIPO_DOCUMENTO)
            {
                dataConfiguracion.TIPO_DOCUMENTO = tmpConfiguracion[0].CGCNF_VALOR_CADENA;
            }
            if(inParam == dataConfiguracion.RESIDENCIA_PERMANENTE)
            {
                dataConfiguracion.RESIDENCIA_PERMANENTE = tmpConfiguracion[0].CGCNF_VALOR_CADENA;
            }
            if(inParam == dataConfiguracion.RESIDENCIA_TEMPORAL)
            {
                dataConfiguracion.RESIDENCIA_TEMPORAL = tmpConfiguracion[0].CGCNF_VALOR_CADENA;
            }
            if(inParam == dataConfiguracion.TRANSEUNTE)
            {
                dataConfiguracion.TRANSEUNTE = tmpConfiguracion[0].CGCNF_VALOR_CADENA;
            }

        }
        var param = new SOAPClientParameters();
        param.add('inCgcnf_codigo',inParam);
        param.add('format','JSON');
        SOAPClient.invoke(URL_WS + 'Cgg_configuracion',"select",param, true, CallBackConfiguracion);

    }


    function consultarDatosAuspiciante()
    {
        var flagConsultarDatos = true;
        try{

            if(flagConsultarDatos )
            {
                $("#divCargando1").show();
                function CallBackCgg_res_auspiciante(r){
                    tmpRecordAuspiciante = eval(r);
//                    alert(r);
                    $('#divCargando1').hide();
                    if(tmpRecordAuspiciante.length>0)
                    {
                        if (tmpRecordAuspiciante[0].CRPJR_IS_USER == true)
                        {
                            $('#divEmpresa').show();
                            $('#txtNombreAuspiciantePJ').val(tmpRecordAuspiciante[0].CRPJR_RAZON_SOCIAL);
                        }

                        $('#txtNumDocAuspiciante').val(tmpRecordAuspiciante[0].CRPER_NUM_DOC_IDENTIFIC);
                        $('#txtIdentificacionAuspiciante').val(tmpRecordAuspiciante[0].CRDID_DESCRIPCION);
                        $('#txtNombreAuspiciante').val(tmpRecordAuspiciante[0].CRPER_NOMBRES);
                        if(tmpRecordAuspiciante[0].CRPER_NUMERO_RESIDENCIA !=undefined)
                        {
                            $('#txtNumResidenciaAuspiciante').val(tmpRecordAuspiciante[0].CRPER_NUMERO_RESIDENCIA);
                        }
                        else
                        {
                            $('#txtNumResidenciaAuspiciante').val('000000');
                        }
                        manejarCtrlsAuspiciante();

                    }

                }
                var param = new SOAPClientParameters();
                param.add('format','JSON');
                SOAPClient.invoke(URL_WS+"Cgg_res_persona",'selectDatosAuspiciante',param, true, CallBackCgg_res_auspiciante);

            }
            else
            {
                $('#divCargando1').hide();
            }
        }catch(inErr){
            $('#divCargando1').hide();
            //winFrmCgg_res_persona_juridica.getEl().unmask();
        }
    }

    consultarDatosAuspiciante();

    function insertPersona(objPersona){
        if (objPersona.CRPER_CODIGO == null || objPersona.CRPER_CODIGO == "KEYGEN") {
            objPersona.CRPER_CODIGO=null;
            var objPersonaJSON = JSON.stringify(objPersona);
            var param = new SOAPClientParameters();
            param.add('inNuevoBeneficiarioJSON', objPersonaJSON);
            var tmpPersona = SOAPClient.invoke(URL_WS + 'Cgg_res_persona', 'insertLite', param, false, null);
            try {
                var result = eval('(' + tmpPersona + ')');
                if (result == false) {
                    new bsxMessageBox({
                        title: 'Alerta',
                        msg: 'Ha ocurrido un error al registrar el beneficiario. No es posible validar la informaci&oacute;n',
                        icon: "iconInfo"
                    });
                    return false;
                } else {
                    tmpRecordPersona[0].CRPER_CODIGO = result.CRPER_CODIGO;
                    objPersona.CRPER_CODIGO = result.CRPER_CODIGO;
                }
                return true;
            } catch (inErr) {
                console.log(inErr.message);
                return false;
            }
        }else
            return true;
    }


    function consultarDatosPersona(inTmpRecordPersona,inValue,inTipoPersona)
    {
        var flagConsultarDatos = false;
        try{
            if (inTmpRecordPersona != null)
            {
                if(inTmpRecordPersona[0].CRPER_NUM_DOC_IDENTIFIC != inValue)
                {
                    flagConsultarDatos = true;
                }
            }
            else
            {
                flagConsultarDatos = true;
            }
            if(flagConsultarDatos )
            {
                $("#divCargando1").show();
                function CallBackCgg_res_persona(r){
                    tmpRecordPersona = eval(r);
                    $('#divCargando1').hide();
                    if(tmpRecordPersona[0].CRPER_CODIGO != undefined)
                    {
                        if(inTipoPersona == 'REPRESENTANTE'){
                            objRepresentante = tmpRecordPersona[0];
                            if(objRepresentante!=null){
                                $('#txtRepresentanteData').val(objRepresentante.CRPER_APELLIDO_PATERNO + " " + objRepresentante.CRPER_APELLIDO_MATERNO +" "+ objRepresentante.CRPER_NOMBRES);
                                repCrperCodigo=objRepresentante!=null?objRepresentante.CRPER_CODIGO:null;
                            }
                        }
                        else if(inTipoPersona == 'AUSPICIANTE')
                        {
                            $("#txtNombreAuspiciante").val(tmpRecordPersona[0].CRPER_NOMBRES);
                            $("#txtApellidoAuspiciante").val(tmpRecordPersona[0].CRPER_APELLIDO_PATERNO);
                            $("#txtNumResidenciaAuspiciante").val(tmpRecordPersona[0].CRPER_NUMERO_RESIDENCIA != undefined? tmpRecordPersona[0].CRPER_NUMERO_RESIDENCIA:'' );
                            tmpRecordAuspiciante = tmpRecordPersona;
                        }
                        else
                        {
                            if($("#cbxTipoDocumentoBeneficiario").val()==null||$("#cbxTipoDocumentoBeneficiario").val()=='')
                                $("#cbxTipoDocumentoBeneficiario").val(tmpRecordPersona[0].CRDID_CODIGO);
                            $("#txtNombreBeneficiario").val(tmpRecordPersona[0].CRPER_NOMBRES);
                            $("#txtApellidoPaternoBeneficiario").val(tmpRecordPersona[0].CRPER_APELLIDO_PATERNO);
                            $("#txtApellidoMaternoBeneficiario").val(tmpRecordPersona[0].CRPER_APELLIDO_MATERNO);
                            $("#dtFechaNacimiento").val(tmpRecordPersona[0].CRPER_FECHA_NACIMIENTO != undefined?$.format.date(tmpRecordPersona[0].CRPER_FECHA_NACIMIENTO, "dd/MM/yyyy") : '' );
                            $("#cbxNacionalidad").val(tmpRecordPersona[0].CPAIS_CODIGO);
                            //$("#cbxPaisResidencia").val(tmpRecordPersona[0].CGG_CPAIS_CODIGO);
                            $("input[name='rdbtnGenero']")[tmpRecordPersona[0].CRPER_GENERO].checked = true;
                            if(tmpRecordPersona[0].CRPER_CONYUGE!=null){
                                $("#txtCiConyuge").val(tmpRecordPersona[0].CRPER_CONYUGE);
                                $("#txtCiConyuge").attr('disabled', 'disabled');
                            }else{
                                $("#txtCiConyuge").val("");
                                $("#txtCiConyuge").removeAttr('disabled');
                            }
                            if(tmpRecordPersona[0].CRPER_FECHA_MATRIMONIO){
                                $("#dtFechaMatrimonio").val(tmpRecordPersona[0].CRPER_FECHA_MATRIMONIO != undefined?$.format.date(tmpRecordPersona[0].CRPER_FECHA_MATRIMONIO, "dd/MM/yyyy") : '' );
                                $("#dtFechaMatrimonio").attr('disabled', 'disabled');
                                $("#dtFechaMatrimonio").datepicker( "disable" );
                            }else {
                                $("#dtFechaMatrimonio").val("");
                                $("#dtFechaMatrimonio").removeAttr('disabled');
                                $("#dtFechaMatrimonio").datepicker( "enable" );
                            }
                            tmpRecordBeneficiario = tmpRecordPersona;
                            manejarCtrlsBeneficiario(true);
                        }

                    }
                    else
                    {
                        /*var objBeneficiario = {
                            CRPER_CODIGO: null,
                            CRPER_NUM_DOC_IDENTIFIC: $('#txtNumDocBeneficiario').val(),
                            CRDID_CODIGO: tmpRecordPersona[0].CRDID_CODIGO,
                            CRPER_NOMBRES: tmpRecordPersona[0].CRPER_NOMBRES,
                            CRPER_APELLIDO_PATERNO: tmpRecordPersona[0].CRPER_APELLIDO_PATERNO,
                            CRPER_APELLIDO_MATERNO: tmpRecordPersona[0].CRPER_APELLIDO_MATERNO,
                            CRPER_GENERO: tmpRecordPersona[0].CRPER_GENERO,
                            CRPER_FECHA_NACIMIENTO: tmpRecordPersona[0].CRPER_FECHA_NACIMIENTO,
                            CPAIS_CODIGO: tmpRecordPersona[0].CPAIS_CODIGO,
                            CRDPT_CODIGO: crdptCodigo,
                            CGG_CPAIS_CODIGO: tmpRecordPersona[0].CPAIS_CODIGO
                        };
                        insertPersona(objBeneficiario);
                        tmpRecordPersona[0].CRPER_CODIGO = objBeneficiario.CRPER_CODIGO;
*/
                        if(inTipoPersona == 'AUSPICIANTE')
                        {
                            //alert('');
                            new bsxMessageBox({
                                title:'Idiomas',
                                msg: 'El auspiciante no existe',
                                icon: "iconInfo",
                                close:function(){
                                    limpiarCtrlsAuspiciante();
                                }
                            });
                        }
                        else
                        {
                            manejarCtrlsBeneficiario(false);
                            limpiarCtrlsBeneficiario();
                            $("#txtNombreBeneficiario").val(tmpRecordPersona[0].CRPER_NOMBRES);
                            $("#txtApellidoPaternoBeneficiario").val(tmpRecordPersona[0].CRPER_APELLIDO_PATERNO);
                            $("#txtApellidoMaternoBeneficiario").val(tmpRecordPersona[0].CRPER_APELLIDO_MATERNO);
                            $("#dtFechaNacimiento").val(tmpRecordPersona[0].CRPER_FECHA_NACIMIENTO != undefined?$.format.date(tmpRecordPersona[0].CRPER_FECHA_NACIMIENTO, "dd/MM/yyyy") : '' );
                            $("#cbxNacionalidad").val(tmpRecordPersona[0].CPAIS_CODIGO);
                            if(tmpRecordPersona[0].CRPER_CONYUGE!=null){
                                $("#txtCiConyuge").val(tmpRecordPersona[0].CRPER_CONYUGE);
                                $("#txtCiConyuge").attr('disabled', 'disabled');
                            }else{
                                $("#txtCiConyuge").val("");
                                $("#txtCiConyuge").removeAttr('disabled');
                            }
                            if(tmpRecordPersona[0].CRPER_FECHA_MATRIMONIO){
                                $("#dtFechaMatrimonio").val(tmpRecordPersona[0].CRPER_FECHA_MATRIMONIO != undefined?$.format.date(tmpRecordPersona[0].CRPER_FECHA_MATRIMONIO, "dd/MM/yyyy") : '' );
                                $("#dtFechaMatrimonio").attr('disabled', 'disabled');
                                $("#dtFechaMatrimonio").datepicker( "disable" );
                            }else {
                                $("#dtFechaMatrimonio").val("");
                                $("#dtFechaMatrimonio").removeAttr('disabled');
                                $("#dtFechaMatrimonio").datepicker( "enable" );
                            }

                            if(tmpRecordPersona[0].CRPER_GENERO == 1){
                                $("#rdFemenino").checked(true);
                                $("#rdMasculino").checked(false);
                            }else{
                                $("#rdMasculino").checked(true);
                                $("#rdFemenino").checked(false);
                            }
                        }
                    }

                }
                var param = new SOAPClientParameters();
                param.add('inCrper_num_doc_identific',inValue) ;
                param.add('format','JSON');
                SOAPClient.invoke(URL_WS+"Cgg_res_persona",'selectNumDoc',param, true, CallBackCgg_res_persona);

            }
            else
            {
                $('#divCargando1').hide();
            }
        }catch(inErr){
            $('#divCargando1').hide();
            //winFrmCgg_res_persona_juridica.getEl().unmask();
        }
    }
    selectDataConfiguracion(dataConfiguracion.TIPO_DOCUMENTO);
    selectDataConfiguracion(dataConfiguracion.RESIDENCIA_PERMANENTE);
    selectDataConfiguracion(dataConfiguracion.RESIDENCIA_TEMPORAL);
    selectDataConfiguracion(dataConfiguracion.TRANSEUNTE);




    function manejarCtrlsAuspiciante()
    {
        $("#txtNombreAuspiciante").attr("readonly", true);
        $("#txtApellidoAuspiciante").attr("readonly", true);
        $("#txtNumResidenciaAuspiciante").attr("readonly", true);
        $("#txtNombreAuspiciantePJ").attr("readonly", true);
        $('#txtNumDocAuspiciante').attr("readonly", true);
        $('#txtIdentificacionAuspiciante').attr("readonly", true);
        //cbxTipoDocumentoAuspiciante.attr("readonly", true);
    }

    function manejarCtrlsBeneficiario(enable)
    {
        $("#txtNombreBeneficiario").attr("readonly", enable);
        $("#txtApellidoPaternoBeneficiario").attr("readonly", enable);
        $("#txtApellidoMaternoBeneficiario").attr("readonly", enable);
        $("#dtFechaNacimiento").attr("readonly", enable);
        $("#rdbtnGenero").attr("readonly", enable);
        $("#cbxNacionalidad").attr("readonly", enable);
        $("#cbxPaisResidencia").attr("readonly", enable);

    }

    function limpiarCtrlsAuspiciante()
    {

        $("#txtNombreAuspiciante").val('');
        $("#txtApellidoAuspiciante").val('');
        $("#txtNumResidenciaAuspiciante").val('');
    }

    function limpiarCtrlsBeneficiario()
    {

        $("#txtNombreBeneficiario").val('');
        $("#txtApellidoPaternoBeneficiario").val('');
        $("#txtApellidoMaternoBeneficiario").val('');
        $("#dtFechaNacimiento").val('');

        /*$("#rdbtnGenero").attr("readonly", enable);
         $("#cbxNacionalidad").attr("readonly", enable);
         $("#cbxPaisResidencia").attr("readonly", enable);*/
    }


    $('#btnSalirTramiteResidencia').click(function(){
        $('#myForm').hide();
    });
    $('#btnGuardarTramiteResidencia').click(function() {

        if((modeTemporal || modeTranseuntes) && tipoTramiteSelected!= null && tipoTramiteSelected.CRTST_NUMERO_DIAS!=null){
            if(($("#dtFechaIngreso").val() == null || $("#dtFechaIngreso").val().length<=0) ||
                ($("#dtFechaSalida").val() == null || $("#dtFechaSalida").val().length<=0)){
                new bsxMessageBox({
                    title: 'Alerta',
                    msg: 'Fechas de Ingreso y Salida son obligatorias',
                    icon: "iconInfo"
                });
                $('#divCargando1').hide();
                $('#divCargando1').html('Cargando..');
                return;
            }
            var today = $("#dtFechaIngreso").datepicker( "getDate" );
            var limit = today.addDays(tipoTramiteSelected.CRTST_NUMERO_DIAS-1);
            var selectedDate = $("#dtFechaSalida").datepicker( "getDate" );
            if(selectedDate.getMilliseconds()>limit.getMilliseconds()){
                new bsxMessageBox({
                    title: 'Alerta',
                    msg: 'Ha excedido la fecha permitida. Para este tipo de residencia el tiempo m&aacute;ximo es '+tipoTramiteSelected.CRTST_NUMERO_DIAS + ' d&iacute;as.',
                    icon: "iconInfo"
                });
                $('#divCargando1').hide();
                $('#divCargando1').html('Cargando..');
                return;
            }
        }
        if(modeTemporal && (objRepresentante==null || objRepresentante.CRPER_CODIGO==null)){
            new bsxMessageBox({
                title: 'Alerta',
                msg: 'Debe especificar la c&eacute;dula de un representante v&aacute;lido y vigente.',
                icon: "iconInfo"
            });
            $('#divCargando1').hide();
            $('#divCargando1').html('Cargando..');
            return;
        }

        var inContactosJSON = obtenerJSONContactos();
        if(cbxActividad != null && cbxActividad.getRowSelected()!=null)
            codigoActividad = cbxActividad.getRowSelected().CGCRG_CODIGO;

        if (!modeTranseuntes) {
            if (verificarInformacionTramite() == false) {
                //alert('');
                new bsxMessageBox({
                    title: 'Alerta',
                    msg: 'Por favor verifique que todos los datos hayan sido ingresados correctamente.',
                    icon: "iconInfo"
                });
                $('#divCargando1').hide();
                $('#divCargando1').html('Cargando..');
                return;
            }else{
                //HACEMOS DE UNA VEZ EL INSERT DE LA PERSONA PARA PODER VALIDAR
                var objPersona = {
                    CRPER_CODIGO: tmpRecordBeneficiario != null ? tmpRecordBeneficiario[0].CRPER_CODIGO :null,
                    CRPER_NUM_DOC_IDENTIFIC: $('#txtNumDocBeneficiario').val(),
                    CRDID_CODIGO: cbxTipoDocumentoBeneficiario.dom.value,
                    CRPER_NOMBRES: $('#txtNombreBeneficiario').val(),
                    CRPER_APELLIDO_PATERNO: $('#txtApellidoPaternoBeneficiario').val(),
                    CRPER_APELLIDO_MATERNO: $('#txtApellidoMaternoBeneficiario').val(),
                    CRPER_GENERO: $("input[name='rdbtnGenero']:checked").val(),
                    CRPER_FECHA_NACIMIENTO: $('#dtFechaNacimiento').val(),
                    CPAIS_CODIGO: cbxNacionalidad.dom.value,
                    CRDPT_CODIGO: crdptCodigo,
                    CGG_CPAIS_CODIGO: cbxPaisResidencia.dom.value
                };
                if(!insertPersona(objPersona))
                    return;
                else
                    tmpRecordBeneficiario[0].CRPER_CODIGO=objPersona.CRPER_CODIGO;
            }
        }
        if (inContactosJSON.length < 3) {
            new bsxMessageBox({
                title: 'Alerta',
                msg: 'Por favor verifique que se haya ingresado al menos una informacion de contacto.',
                icon: "iconInfo"
            });
            $("#tabs").tabs("select", 1);
            $('#divCargando1').hide();
            $('#divCargando1').html('Cargando..');
            return;
        }
        if (!modeTranseuntes) {
            if (validarReglaTramite() == false) {
                $('#divCargando1').hide();
                $('#divCargando1').html('Cargando..');
                return;
            }
        }else{
            if (validarReglaTranseuntes() == false) {
                $('#divCargando1').hide();
                $('#divCargando1').html('Cargando..');
                return;
            }
        }
        $('#divCargando1').html('Cargando..');

        function CallBackCgg_res_tramite(r) {
            $('#divCargando1').hide();
            var tmpRespuestaTramite = eval(r);

            if (tmpRespuestaTramite[0].substring(0, 5) == 'CRTRA') {
                //alert('');
                new bsxMessageBox({
                    title: 'Informaci\u00F3n',
                    msg: 'El tr\u00E1mite ha sido guardado y despachado. El n\u00FAmero de su tr\u00E1mite es: <span style="color:#039BD7"><b>' + new Date().getFullYear() + '-' + tmpRespuestaTramite[1]/*.split('CRTRA')[1]*/ + '</b></span>.\n A continuaci\u00f3n se gener\u00E1 el detalle de su solicitud.',
                    icon: "iconOk",
                    close: function () {
                        printSolicitud(tmpRespuestaTramite[0]);
                        $('#myForm').hide();
                        //window.open(urlReport);
                    }
                });
                if(!modeTranseuntes) {
                    showAlfrescoUploader("Cgg_res_tramite", tmpRespuestaTramite[0],"crtst_codigo='" + tmpMotivoResidenciaId + "'");
                    //Invocacion Alfresco del FrontEnd
                    /*var _tableName = encodeURIComponent("Cgg_res_tramite");
                    var _recordId = encodeURIComponent(tmpRespuestaTramite[0]);
                    var _filter = encodeURIComponent("crtst_codigo='" + tmpMotivoResidenciaId + "'");
                    PopupCenter("alfrescoMng.html?tableName=" + _tableName + "&recordId=" + _recordId + "&filter=" + _filter, 'Adjuntos', '820', '630');*/
                    //Fin Alfresco
                }
            }else {
                //alert('');
                new bsxMessageBox({
                    title: 'Error',
                    msg: 'Ha ocurrido un problema al gestionar su petici&oacute;n. Pedimos disculpas por las molestias ocasionadas!!',
                    icon: "iconError"
                });
            }
        }

        if(!modeTranseuntes) {
            //DEFINICION DEL OBJETO BENEFICIARIO PARA EL ALMACENAMIENTO CUANDO SEA UN NUEVO REGISTRO
            var objBeneficiario = {
                CRPER_CODIGO: tmpRecordBeneficiario != null ? tmpRecordBeneficiario[0].CRPER_CODIGO : 'KEYGEN',
                CRPER_NUM_DOC_IDENTIFIC: $('#txtNumDocBeneficiario').val(),
                CRDID_CODIGO: $('#cbxTipoDocumentoBeneficiario').val(),
                CRPER_NOMBRES: $('#txtNombreBeneficiario').val(),
                CRPER_APELLIDO_PATERNO: $('#txtApellidoPaternoBeneficiario').val(),
                CRPER_APELLIDO_MATERNO: $('#txtApellidoMaternoBeneficiario').val(),
                CRPER_GENERO: $("input[name='rdbtnGenero']:checked").val(),
                CRPER_FECHA_NACIMIENTO: $('#dtFechaNacimiento').val(),
                CPAIS_CODIGO: $('#cbxNacionalidad').val(),
                CGG_CPAIS_CODIGO: $('#cbxPaisResidencia').val()
            };

            var objBeneficiarioJSON = JSON.stringify(objBeneficiario);

            var param = new SOAPClientParameters();
            param.add('inCrper_codigo', tmpRecordAuspiciante != null ? tmpRecordAuspiciante[0].CRPER_CODIGO : null);
            param.add('inCgg_crpjr_codigo', tmpRecordAuspiciante != null ? tmpRecordAuspiciante[0].CRPJR_CODIGO : null);
            param.add('inCgg_crper_codigo', tmpRecordBeneficiario != null ? tmpRecordBeneficiario[0].CRPER_CODIGO : 'KEYGEN');
            // param.add('inCrtst_codigo', $("#cbxTipoSolicitudResidencia").val()) ;
            param.add('inCrtst_codigo', tmpMotivoResidenciaId);
            param.add('inCisla_codigo', $("#cbxIslaTramite").val());
            //MO
            param.add('inCrtt_codigo', $("#cbxTipoTramite").val());
            //
            param.add('inCrtra_observacion', 'Registro desde Atencion al Cliente');
            param.add('inCvveh_codigo', null);
            param.add('inCvmtr_codigo', null);
            param.add('inCgg_cvveh_codigo', null);
            param.add('inCgg_cvmtr_codigo', null);
            param.add('inCrtra_atencion_cliente', true);
            param.add('inNuevoBeneficiarioJSON', objBeneficiarioJSON);
            param.add('inContactoPersonaJSON', inContactosJSON);//'[]') ;
            param.add('inInfoVehiculos', null);
            param.add('inCrtra_fecha_ingreso', $('#dtFechaIngreso').val());
            param.add('inCrtra_fecha_salida', $('#dtFechaSalida').val());
            param.add('inCrtra_actividad_residencia', codigoActividad);
            param.add('inRep_crper_codigo',repCrperCodigo);
            SOAPClient.invoke(URL_WS + "Cgg_res_tramite", 'registrarTramiteLite', param, true, CallBackCgg_res_tramite);
        }else{
            var beneficiarios = [];
            if (tblPersona.rows.length > 1) {
                for (var i = 1; i < tblPersona.rows.length; i++) {
                    var objBeneficiario = {
                        CRPER_CODIGO: tblPersona.rows[i].cells[1].id,
                        CRPER_NUM_DOC_IDENTIFIC: tblPersona.rows[i].cells[1].innerHTML,
                        CRDID_CODIGO: tblPersona.rows[i].cells[0].id,
                        CRPER_NOMBRES: tblPersona.rows[i].cells[2].innerHTML,
                        CRPER_APELLIDO_PATERNO: tblPersona.rows[i].cells[3].innerHTML,
                        CRPER_APELLIDO_MATERNO: tblPersona.rows[i].cells[4].innerHTML,
                        CRPER_GENERO: tblPersona.rows[i].cells[8].innerHTML == 'M'?"0":"1",
                        CRPER_FECHA_NACIMIENTO: tblPersona.rows[i].cells[7].innerHTML,
                        CPAIS_CODIGO: tblPersona.rows[i].cells[6].id,
                        CGG_CPAIS_CODIGO: tblPersona.rows[i].cells[5].id
                    };
                    beneficiarios.push(objBeneficiario);
                }
            }
            if(beneficiarios.length<=0){
                new bsxMessageBox({
                    title: 'Alerta',
                    msg: 'Por favor ingrese al menos un beneficiario.',
                    icon: "iconInfo"
                });
                $('#divCargando1').hide();
                $('#divCargando1').html('Cargando..');
                return;
            }
            var objBeneficiarioJSON = JSON.stringify(beneficiarios);

            var param = new SOAPClientParameters();
            param.add('inCrper_codigo', tmpRecordAuspiciante != null ? tmpRecordAuspiciante[0].CRPER_CODIGO : null);
            param.add('inCgg_crpjr_codigo', tmpRecordAuspiciante != null ? tmpRecordAuspiciante[0].CRPJR_CODIGO : null);
            param.add('inCgg_crper_codigo', null);
            param.add('inCrtst_codigo', tmpMotivoResidenciaId);
            param.add('inCisla_codigo', $("#cbxIslaTramite").val());
            param.add('inCrtt_codigo', $("#cbxTipoTramite").val());
            param.add('inCrtra_observacion', $("#txtObservacion").val());
            param.add('inCvveh_codigo', null);
            param.add('inCvmtr_codigo', null);
            param.add('inCgg_cvveh_codigo', null);
            param.add('inCgg_cvmtr_codigo', null);
            param.add('inCrtra_atencion_cliente', true);
            param.add('inNuevoBeneficiarioJSON', objBeneficiarioJSON);
            param.add('inContactoPersonaJSON', inContactosJSON);//'[]') ;
            param.add('inInfoVehiculos', null);
            param.add('inBeneficiarios_JSON', objBeneficiarioJSON);
            param.add('inCrtra_fecha_ingreso', $('#dtFechaIngreso').val());
            param.add('inCrtra_fecha_salida', $('#dtFechaSalida').val());
            param.add('inCrtra_actividad_residencia', codigoActividad);

            SOAPClient.invoke(URL_WS + "Cgg_res_tramite", 'registrarTramiteTranseunteLite', param, true, CallBackCgg_res_tramite);
        }
    });

    manejarCtrlsAuspiciante();


    function printSolicitud(inCrtraCodigo)
    {
        if($("#cbxTipoResidenciaPadre").val() == dataConfiguracion.RESIDENCIA_PERMANENTE)
        {
            urlReport = new Reporte('rptSolicitudResidenciaPermanente','/Reports/sii/atencionalcliente',{P_CRTRA_CODIGO:inCrtraCodigo});

        }
        else if ($("#cbxTipoResidenciaPadre").val() == dataConfiguracion.RESIDENCIA_TEMPORAL)
        {
            urlReport = new Reporte('rptSolicitudResidenciaTemporales','/Reports/sii/atencionalcliente',{P_CRTRA_CODIGO:inCrtraCodigo});
        }
        else
        {
            urlReport = new Reporte('rptSolicitudResidenciaTranseunte','/Reports/sii/atencionalcliente',{P_CRTRA_CODIGO:inCrtraCodigo});
        }
        urlReport.show();

    }


    /******************SECCION REGLAS DE VALIDACION*****************/
    /**
     *Funcion. Evalua las reglas de validacion del tramite.
     *@return Cadena de datos con informacion de las reglas validadas.
     */
    function evaluarReglaTramite(_benef){
        var res = null;
        colReglaValidacion=eval(reglaValidacion);
        if(colReglaValidacion!==null){
            for(var i=0;i<colReglaValidacion.length;i++){
                var objTmp = eval(colReglaValidacion[i].CRTSE_CAMPO_EVALUACION)[0];
                var searchVal=null;
                for (var key in objTmp) {
                    searchVal = objTmp[key];
                    objTmp[key] = eval(objTmp[key]);
                }
                if(objTmp[key]==null && _benef!=null){
                    if(searchVal!=null && searchVal=='cggcrperCodigo'){
                        objTmp[key] = _benef.CGGCRPER_CODIGO;
                    }else if(searchVal!=null && searchVal=='crperNumDocIdentific'){
                        objTmp[key] = _benef.CRPER_NUM_DOC_IDENTIFIC;
                    }else if(searchVal!=null && searchVal=='crperCodigo'){
                        objTmp[key] = _benef.CRPER_CODIGO;
                    }else if(searchVal!=null && searchVal=='cggCrperFechaNacimiento') {
                        objTmp[key] = _benef.CRPER_FECHA_NACIMIENTO;
                    }else if(searchVal!=null && searchVal=='repCrperCodigo'){
                        objTmp[key] = _benef.REP_CRPER_CODIGO;
                    }else{
                        if(key.toString().search("IN_")==0)
                            objTmp[key] = _benef[key.toString().slice(3)];
                        else
                            objTmp[key] = _benef[key];
                    }
                }
                colReglaValidacion[i].CRTSE_CAMPO_EVALUACION ='['+JSON.stringify(objTmp)+']';
            }
            res =JSON.stringify(colReglaValidacion);
        }
        return res;
    }

    /**
     *Funcion. consulta las reglas de validacion que aplican a este tipo de solicitud de tramite, las ejecuta y obtiene un resultado si es o no viable el registro de un tramite.
     */
    function validarReglaTramite(){
        var flagRegla = false;
        $('#divCargando1').html('Validando..');
        $('#divCargando1').show();
        try{
            valFechaSalida = $('#dtFechaSalida').val();
            valFechaIngreso = $('#dtFechaIngreso').val();
            crperCodigo = tmpRecordAuspiciante[0].CRPER_CODIGO;
            try{
                cggcrperCodigo = tmpRecordBeneficiario != null? tmpRecordBeneficiario[0].CRPER_CODIGO:'KEYGEN';
            }
            catch(errCggcrper)
            {
                cggcrperCodigo = 'KEYGEN';
            }
            crperNumDocIdentific = $('#txtNumDocBeneficiario').val();
            cggCrperFechaNacimiento = $('#dtFechaNacimiento').val();
            var crdidCodigo = $('#cbxTipoDocumentoBeneficiario').val();
            var jsonData = {
                'CRPER_CODIGO':crperCodigo,
                'CRPJR_CODIGO': tmpRecordAuspiciante != null ? tmpRecordAuspiciante[0].CRPJR_CODIGO : null,
                'CRDID_CODIGO':crdidCodigo,
                'CGGCRPER_CODIGO':cggcrperCodigo,
                'CRPER_NUM_DOC_IDENTIFIC':crperNumDocIdentific,
                'CRPER_FECHA_NACIMIENTO':cggCrperFechaNacimiento,
                'CRDPT_CODIGO':crdptCodigo,
                'CRPER_CONYUGE':$("#txtCiConyuge").val(),
                'CRPER_FECHA_MATRIMONIO':$("#dtFechaMatrimonio").val(),
                'REP_CRPER_CODIGO': repCrperCodigo,
                'REP_CRPER_NUM_DOC_IDENTIFIC': objRepresentante!=null?objRepresentante.REP_CRPER_NUM_DOC_IDENTIFIC:null
            };
            var resultadoRegla = evaluarReglaTramite();
            if(resultadoRegla!==null){
                var param = new SOAPClientParameters();
                param.add('inJSON_reglas_validacion',resultadoRegla);
                param.add('jsonData',JSON.stringify(jsonData));
                var validacion = SOAPClient.invoke(URL_WS+'Cgg_regla_validacion' ,'ejecutarReglaTipoSolicitud',param, false, null);
                validacion = eval('('+validacion+')');
                if(validacion.resultadoValidacion !== undefined){
                    if(validacion.resultadoValidacion == 'false'){

                        $("#divReglaValidacion").html($.tmpl( "resultadoReglaTemplate", validacion ));
                        $("#dlgReglaValidacion").dialog("open");
                    }
                    flagRegla=eval(validacion.resultadoValidacion);
                }else{
                    flagRegla = null;
                }
            }
        }catch(inErr){
            //   Ext.MsgPopup.msg(tituloCgg_res_tramite, "No se ha podido validar la informaci\u00f3n a almacenar.<br>Error:"+inErr+'<br>'+ERR_MESSAGE);
            flagRegla = false;
        }
        // pnlFrmCgg_res_tramitePrincipal.getEl().unmask();
        return flagRegla;
    }

    function validarReglaTranseuntes(_benef){
        var flagRegla = false;
        $('#divCargando1').html('Validando..');
        $('#divCargando1').show();

        crperCodigo = tmpRecordAuspiciante[0].CRPER_CODIGO;
        valFechaSalida = $('#dtFechaSalida').val();
        valFechaIngreso = $('#dtFechaIngreso').val();

        try{
            var beneficiarios = [];
            var multiReglas = [];
            if(_benef) {
                var resultadoRegla = evaluarReglaTramite(_benef);
                if(resultadoRegla!=null) {
                    multiReglas.push(resultadoRegla);
                    beneficiarios.push(_benef);
                }
            }else{
                if (tblPersona.rows.length > 1) {
                    for (var i = 1; i < tblPersona.rows.length; i++) {
                        var objBeneficiario = {
                            CRPER_CODIGO: crperCodigo,
                            CRPJR_CODIGO: tmpRecordAuspiciante != null ? tmpRecordAuspiciante[0].CRPJR_CODIGO : null,
                            CGGCRPER_CODIGO: tblPersona.rows[i].cells[1].id,
                            CRPER_NUM_DOC_IDENTIFIC: tblPersona.rows[i].cells[1].innerHTML,
                            CRDID_CODIGO: tblPersona.rows[i].cells[0].id,
                            CRPER_NOMBRES: tblPersona.rows[i].cells[2].innerHTML,
                            CRPER_APELLIDO_PATERNO: tblPersona.rows[i].cells[3].innerHTML,
                            CRPER_APELLIDO_MATERNO: tblPersona.rows[i].cells[4].innerHTML,
                            CRPER_GENERO: tblPersona.rows[i].cells[8].innerHTML == 'M'?"0":"1",
                            CRPER_FECHA_NACIMIENTO: tblPersona.rows[i].cells[7].innerHTML,
                            CPAIS_CODIGO: tblPersona.rows[i].cells[6].id,
                            CRDPT_CODIGO: crdptCodigo,
                            CGG_CPAIS_CODIGO: tblPersona.rows[i].cells[5].id
                        };
                        var resultadoRegla = evaluarReglaTramite(objBeneficiario);
                        if(resultadoRegla!=null){
                            multiReglas.push(resultadoRegla);

                            beneficiarios.push(objBeneficiario);
                        }
                    }
                }
            }
            if(beneficiarios.length<=0){
                new bsxMessageBox({
                    title: 'Alerta',
                    msg: 'Por favor ingrese al menos un beneficiario.',
                    icon: "iconInfo"
                });
                return;
            }
            var objBeneficiarioJSON = JSON.stringify(beneficiarios);


            if(multiReglas!==null && multiReglas.length>0) {
                var param = new SOAPClientParameters();
                param.add('inJSON_reglas_validacion', JSON.stringify(multiReglas));
                param.add('jsonData', objBeneficiarioJSON);
                var validacion = SOAPClient.invoke(URL_WS + 'Cgg_regla_validacion', 'ejecutarReglaTranseuntesTipoSolicitud', param, false, null);
                validacion = eval('(' + validacion + ')');
                if (validacion != null & validacion.length > 0) {
                    for(var j=0;j<validacion.length;j++){
                        if (validacion[j].resultadoValidacion !== undefined) {
                            if (validacion[j].resultadoValidacion == 'false') {
                                $("#divReglaValidacion").html($.tmpl("resultadoReglaTemplate", validacion[j]));
                                $("#dlgReglaValidacion").dialog("open");
                            }
                            flagRegla = eval(validacion[j].resultadoValidacion);
                        } else {
                            flagRegla = null;
                        }
                    }
                }
            }
        }catch(inErr){
            //   Ext.MsgPopup.msg(tituloCgg_res_tramite, "No se ha podido validar la informaci\u00f3n a almacenar.<br>Error:"+inErr+'<br>'+ERR_MESSAGE);
            flagRegla = false;
        }
        // pnlFrmCgg_res_tramitePrincipal.getEl().unmask();
        return flagRegla;
    }

    /******************FIN DE SECCION REGLAS DE VALIDACION*/

    function verificarInformacionTramite()
    {

        $('.form-line-error').removeClass("form-line-error");
        var isComplete =  true;
        if(!$('#txtNumDocAuspiciante').val())
        {
            $('#txtNumDocAuspiciante').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }
        if(!$('#txtNumDocBeneficiario').val())
        {
            $('#txtNumDocBeneficiario').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }

        if(!$('#txtNombreBeneficiario').val())
        {
            $('#txtNombreBeneficiario').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }
        if(!$('#txtApellidoPaternoBeneficiario').val())
        {
            $('#txtApellidoPaternoBeneficiario').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }

        if(!$('#cbxPaisResidencia').val())
        {
            $('#cbxPaisResidencia').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }
        if(!$('#cbxNacionalidad').val())
        {
            $('#cbxNacionalidad').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }
        if(!$('#dtFechaNacimiento').val()||!isDate($('#dtFechaNacimiento').val()))
        {
            $('#dtFechaNacimiento').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }
        if(!$('#cbxIslaTramite').val())
        {
            $('#cbxIslaTramite').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }

        //MO
        if(!$('#cbxTipoTramite').val())
        {
            $('#cbxTipoTramite').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }
        //

        if(!$('#cbxTipoResidenciaPadre').val())
        {
            $('#cbxTipoResidenciaPadre').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }

        if(!$('#txtMotivoResidencia').val())
        {
            $('#txtMotivoResidencia').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }

        if(modeTranseuntes){
            if(!$('#dtFechaIngreso').val())
            {
                $('#dtFechaIngreso').addClass("form-line-error");
                isComplete = false;
                return isComplete;
            }
            if(!$('#dtFechaSalida').val())
            {
                $('#dtFechaSalida').addClass("form-line-error");
                isComplete = false;
                return isComplete;
            }
            if(!$('#cbxActividad').val())
            {
                $('#cbxActividad').addClass("form-line-error");
                isComplete = false;
                return isComplete;
            }
            if(!$('#txtObservacion').val())
            {
                $('#txtObservacion').addClass("form-line-error");
                isComplete = false;
                return isComplete;
            }
        }

        return isComplete;
    }

    $.template(
            "resultadoReglaTemplate",
            '<table id="tableResultado" style="font-size:11px">'+
                    '<tr class="even" style=" border-top: 2px #3399ff solid; padding: 0.4em;">'+
                    '<th colspan=3 style="text-align:left;">Validaci&oacute;n:</TH>'+
                    '</tr>'+
                    '{{each dataSet}}'+
                    '{{if CRVAL_APROBADO == "FALSE"}}'+
                    '<tr class="even">'+
                    '<td><b>${$index + 1}</b> .- ${CRVAL_SUGERENCIA}</td>'+
                    '<td><image style="float : left;" src="css/icon/eliminar.png"></image></td>'+
                    '</tr>'+
                    '{{/if}}'+
                    '{{/each}}'+
                    '</table>'
            );


    /*
     * Inicializacion de los datos asignados al objeto de tipo dialogo para seleccion de vehiculos
     * */
    function viewDialogRegla() {
        var getResponse = function(){
            $("#dlgReglaValidacion").dialog("close");
        }
        var dialogOpts = {
            modal: true,
            buttons: {
                "Aceptar": getResponse
                //"Cancel": cancel
            },
            autoOpen: false,
            width: 520,
            close: function(event, ui) {
                //alert('cerrando');

            }

        };
        $("#dlgReglaValidacion").dialog(dialogOpts);

    };

    viewDialogRegla();
    $("select").width('240');




    var getResponse = function(){
        if(tmpAplicaTramite =='true')
        {
            $("#txtMotivoResidencia").val(tmpMotivoResidencia);
            try{
                $("#dlgMotivoResidencia").dialog("close");
            }catch (e){}
            var cbxTipoTramite = $("#cbxTipoTramite").val();
            consultarReglaValidacion(tmpMotivoResidenciaId,cbxTipoTramite);

            cargarDocumentos(tmpMotivoResidenciaId);
            cargarRequisitos(tmpMotivoResidenciaId);
            /*AC-> Nos traemos los dias permitidos*/
            var tipoTramiteParams= new SOAPClientParameters();
            tipoTramiteParams.add('inCrtst_codigo',tmpMotivoResidenciaId);
            tipoTramiteParams.add('format',TypeFormat.JSON);
            var tmpTipoTramite = SOAPClient.invoke(URL_WS+'Cgg_res_tipo_solicitud_tramite','select',tipoTramiteParams, false,null);
            if(tmpTipoTramite!=null){
                var tmpSelected = eval("("+tmpTipoTramite+")");
                if(tmpSelected.length>0) {
                    tipoTramiteSelected = tmpSelected[0];
                    if(tipoTramiteSelected!= null && tipoTramiteSelected.CRTST_NUMERO_DIAS!=null){
                        var today = new Date();
                        var limit = today.addDays(tipoTramiteSelected.CRTST_NUMERO_DIAS-1);
                        $("#dtFechaSalida").datepicker( "option", "maxDate", limit );
                        //SOLO AQUI DEBERIAMOS LIBERAR LOS CAMPOS BLOQUEADOS.
                        continueEditing();
                    }
                }
            }

            if($('#txtMotivoResidencia').val() == 'Permanente octava transitoria')
                alert('Para iniciar este tr\u00e1mite debe acercarse a ventanilla.\n Seleccione otra para continuar.');
        }
        else
        {
            /* new bsxMessageBox({
             title:'Error',
             msg: 'El tipo de solicitud seleccionado no puede iniciar un tr\u00e1mite. <br> Seleccione otra para continuar.',
             icon: "iconError"
             });*/
            alert('El tipo de solicitud seleccionado no puede iniciar un tramite.\n Seleccione otra para continuar.');
        }
    };

    /*
     * Inicializacion de los datos asignados al objeto de tipo dialogo para seleccion de vehiculos
     * */
    function viewDialogMotivoResidencia() {
        cancelEditing();
        var cancel = function() {
            $("#dlgMotivoResidencia").dialog("close");
        };

        var dialogOpts = {
            modal: true,
            position: 'top',
            buttons: {
                "Ok": getResponse,
                "Cancel": cancel
            },
            autoOpen: false,
            width: 300,
            close: function(event, ui) {
                //alert('cerrando');

            }

        };
        $("#dlgMotivoResidencia").dialog(dialogOpts);
    }

    viewDialogMotivoResidencia();
    /*
     * Consulta de informacion  de Categorias de vehiculos
     * */
    function selectMotivoResidenciaTree(inCrtst_codigo){
        function CallBackMotivoResidenciaTree(r){
            $("#divMotivoResidencia").jstree({
                "json_data" : {
                    "data" :[eval('('+r+')') ]
                },
                "ui" : {
                    "select_limit" : 10,
                    "select_multiple_modifier" : "alt",
                    "selected_parent_close" : "deselect"//"select_parent"
                },
                "plugins" : [ "themes", "json_data","ui" ]
            });

            $("#divMotivoResidencia").bind("select_node.jstree", function (e, data) {
                tmpMotivoResidenciaId =  data.rslt.obj.attr('id');
                tmpMotivoResidencia = data.inst.get_text(data.rslt.obj);
                tmpAplicaTramite  = data.rslt.obj.attr('aplica');
            });
        }
        var param = new SOAPClientParameters();
        param.add('inCgg_crtst_codigo',inCrtst_codigo);
        SOAPClient.invoke(URL_WS + 'Cgg_res_tipo_solicitud_tramite',"selectTipoSolicitudTree",param, true, CallBackMotivoResidenciaTree);
    }

    /*$("#divMotivoResidencia").bind("select_node.jstree", function (e, data) {
     tmpMotivoResidenciaId =  data.rslt.obj.attr('id');
     tmpMotivoResidencia = data.inst.get_text(data.rslt.obj);
     tmpAplicaTramite  = data.rslt.obj.attr('aplica');
     });*/
    //Definicion de eventos para el arbol de categoria de vehiculos


    $("#btnBuscarMotivo").click(function(){
        if($("#cbxTipoResidenciaPadre").val().length>0)
        {
            $("#dlgMotivoResidencia").dialog("open");
            tmpAplicaTramite = "false";
        }
        else
        {
             new bsxMessageBox({
                 title:'Error',
                 msg: 'Por favor seleccione el tipo de residencia para continuar.',
                 icon: "iconError"
                 });
        }
    });

    setHeightForm();
    cancelEditing();
});
