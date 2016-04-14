$(function() {
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
    var crdptCodigo = 'CRDPT_AT001';
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
    var swEdit;

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
        RESIDENCIA_PERMANENTE:'03',
        RESIDENCIA_TEMPORAL:'04',
        TRANSEUNTE:'05'
    }



    $('#dtFechaNacimiento').datepicker({
        showOn: 'both',
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
        showButtonPanel: false,
        nextText: 'Siguiente',
        prevText: 'Anterior'
    });



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

    function consultarReglaValidacion(inCrtst_codigo_select)
    {
        //Consulta de regla de validacion.
        var scpReglaValidacion= new SOAPClientParameters();
        scpReglaValidacion.add('inCrtst_codigo',inCrtst_codigo_select);
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
            width:"180",
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

    $("select#cbxTipoResidenciaPadre").change(function(){
        //cbxTipoSolicitudResidencia.setParam('inCrtst_codigo',$(this).val());
        //cbxTipoSolicitudResidencia.reload();
        $('#txtMotivoResidencia').val('');
        tmpMotivoResidenciaId=null;
        selectMotivoResidenciaTree($(this).val());
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

    function consultarBeneficiario()
    {
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
                        if(inTipoPersona == 'AUSPICIANTE')
                        {
                            $("#txtNombreAuspiciante").val(tmpRecordPersona[0].CRPER_NOMBRES);
                            $("#txtApellidoAuspiciante").val(tmpRecordPersona[0].CRPER_APELLIDO_PATERNO);
                            $("#txtNumResidenciaAuspiciante").val(tmpRecordPersona[0].CRPER_NUMERO_RESIDENCIA != undefined? tmpRecordPersona[0].CRPER_NUMERO_RESIDENCIA:'' );
                            tmpRecordAuspiciante = tmpRecordPersona;
                        }
                        else
                        {
                            $("#txtNombreBeneficiario").val(tmpRecordPersona[0].CRPER_NOMBRES);
                            $("#txtApellidoPaternoBeneficiario").val(tmpRecordPersona[0].CRPER_APELLIDO_PATERNO);
                            $("#txtApellidoMaternoBeneficiario").val(tmpRecordPersona[0].CRPER_APELLIDO_MATERNO);
                            $("#dtFechaNacimiento").val(tmpRecordPersona[0].CRPER_FECHA_NACIMIENTO != undefined?$.format.date(tmpRecordPersona[0].CRPER_FECHA_NACIMIENTO, "dd/MM/yyyy") : '' );
                            $("#cbxNacionalidad").val(tmpRecordPersona[0].CGNCN_CODIGO);
                            $("#cbxPaisResidencia").val(tmpRecordPersona[0].CPAIS_CODIGO);
                            tmpRecordBeneficiario = tmpRecordPersona;
                            manejarCtrlsBeneficiario(true);
                        }

                    }
                    else
                    {
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
    $('#btnGuardarTramiteResidencia').click(function(){
        var inContactosJSON = obtenerJSONContactos();
        if (verificarInformacionTramite() == false)
        {
            //alert('');
            new bsxMessageBox({
                title:'Alerta',
                msg: 'Por favor verifique que todos los datos hayan sido ingresados correctamente.',
                icon: "iconInfo"
            });
            return;
        }
        if(inContactosJSON.length<3)
        {
            new bsxMessageBox({
                title:'Alerta',
                msg: 'Por favor verifique que se haya ingresado al menos una informacion de contacto.',
                icon: "iconInfo"
            });
            $("#tabs").tabs("select",1);
            return;
        }
        if( validarReglaTramite() == false){
            $('#divCargando1').hide();
            $('#divCargando1').html('Cargando..');
            return;
        }
        $('#divCargando1').html('Cargando..');


        //DEFINICION DEL OBJETO BENEFICIARIO PARA EL ALMACENAMIENTO CUANDO SEA UN NUEVO REGISTRO
        var objBeneficiario ={
            CRPER_CODIGO :tmpRecordBeneficiario !=null?tmpRecordBeneficiario[0].CRPER_CODIGO:'KEYGEN',
            CRPER_NUM_DOC_IDENTIFIC:$('#txtNumDocBeneficiario').val(),
            CRDID_CODIGO:$('#cbxTipoDocumentoBeneficiario').val(),
            CRPER_NOMBRES:$('#txtNombreBeneficiario').val(),
            CRPER_APELLIDO_PATERNO:$('#txtApellidoPaternoBeneficiario').val(),
            CRPER_APELLIDO_MATERNO:$('#txtApellidoMaternoBeneficiario').val(),
            CRPER_GENERO:$("input[name='rdbtnGenero']:checked").val(),
            CRPER_FECHA_NACIMIENTO:$('#dtFechaNacimiento').val()
        }

        var objBeneficiarioJSON = JSON.stringify(objBeneficiario);
        function CallBackCgg_res_tramite(r){
            $('#divCargando1').hide();
            var tmpRespuestaTramite = eval(r);

            if (tmpRespuestaTramite[0].substring(0, 5) == 'CRTRA') {
                //alert('');
                new bsxMessageBox({
                    title:'Informaci\u00F3n',
                    msg: 'El tr\u00E1mite ha sido guardado y despachado. El n\u00FAmero de su tr\u00E1mite es: <span style="color:#039BD7"><b>'+ new Date().getFullYear()+'-'+tmpRespuestaTramite[1]/*.split('CRTRA')[1]*/ + '</b></span>.\n A continuaci\u00f3n se gener\u00E1 el detalle de su solicitud.',
                    icon: "iconOk",
                    close:function(){
                        printSolicitud(tmpRespuestaTramite[0]);
                        $('#myForm').hide();
                        //window.open(urlReport);
                    }
                });
            }
            else
            {
                //alert('');
                new bsxMessageBox({
                    title:'Error',
                    msg: 'Ha ocurrido un problema al gestionar su petici&oacute;n. Pedimos disculpas por las molestias ocasionadas!!',
                    icon: "iconError"
                });
            }
        }
        var param = new SOAPClientParameters();
        param.add('inCrper_codigo',tmpRecordAuspiciante !=null?tmpRecordAuspiciante[0].CRPER_CODIGO:null) ;
        param.add('inCgg_crper_codigo',tmpRecordBeneficiario !=null?tmpRecordBeneficiario[0].CRPER_CODIGO:'KEYGEN') ;
        // param.add('inCrtst_codigo', $("#cbxTipoSolicitudResidencia").val()) ;
        param.add('inCrtst_codigo', tmpMotivoResidenciaId);
        param.add('inCisla_codigo', $("#cbxIslaTramite").val()) ;
        param.add('inCrtra_observacion','Registro desde Atencion al Cliente') ;
        param.add('inCvveh_codigo',null) ;
        param.add('inCvmtr_codigo',null) ;
        param.add('inCgg_cvveh_codigo',null) ;
        param.add('inCgg_cvmtr_codigo',null) ;
        param.add('inCrtra_atencion_cliente',true) ;
        param.add('inNuevoBeneficiarioJSON',objBeneficiarioJSON) ;
        param.add('inContactoPersonaJSON',inContactosJSON);//'[]') ;
        param.add('inInfoVehiculos',null) ;
        SOAPClient.invoke(URL_WS+"Cgg_res_tramite",'registrarTramiteLite',param, true, CallBackCgg_res_tramite);
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
    function evaluarReglaTramite(){
        var res = null;
        colReglaValidacion=eval(reglaValidacion);
        if(colReglaValidacion!==null){
            for(var i=0;i<colReglaValidacion.length;i++){
                var objTmp = eval(colReglaValidacion[i].CRTSE_CAMPO_EVALUACION)[0];
                for (var key in objTmp) {
                    objTmp[key] = eval(objTmp[key]);
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

            var resultadoRegla = evaluarReglaTramite();
            if(resultadoRegla!==null){
                var param = new SOAPClientParameters();
                param.add('inJSON_reglas_validacion',resultadoRegla);
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
    $("select").width('140');






    /*
     * Inicializacion de los datos asignados al objeto de tipo dialogo para seleccion de vehiculos
     * */
    function viewDialogMotivoResidencia() {
        var cancel = function() {
            $("#dlgMotivoResidencia").dialog("close");
        }
        var getResponse = function(){
            if(tmpAplicaTramite =='true')
            {
                $("#txtMotivoResidencia").val(tmpMotivoResidencia);
                $("#dlgMotivoResidencia").dialog("close");
                consultarReglaValidacion(tmpMotivoResidenciaId);

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
        }
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

    };

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

});
