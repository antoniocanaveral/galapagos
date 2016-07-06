$(function() {
    var tmpConfiguracion;//Variable utilizada para almacenar datos de configuracion consultados en la base;
    var tmpTipoReemplazo;
    var tmpRecordPersona;//Variable almacena informacion de persona
    var tmpRecordAuspiciante;
    var tmpRecordBeneficiario;
    var dsTipoVehiculo= {0:'Terrestre',1:'Mar\u00edtimo',2:'A\u00e9reo'};
    var options = '';
    var tmpRecordVehiculoExistente =  null;
    var tmpCategoriaId;
    var tmpCategoriaDescripcion;

    var reglaValidacion = null; //variable utilizada para almacenar los datos de las reglas de validacion a aplicar como control
    var colReglaValidacion = null;

    /******************INICIO DE DEFINICION DE VARIABLES PARA REGLA DE VALIDACION DE INFORMAICON*******************/
    var crperCodigo = null;
    var cggcrperCodigo = null;
    var crperNumDocIdentific=null;
    var cvvehCodigo;
    var cvmtrCodigo;
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
    $("#tabs").tabs({
        collapsible: false
    });
    var TypeInfoVehiculo={
        Vehiculo:0,
        Motor:1
    };
    var TypeVehiculo={
        Terrestre:0,
        Maritimo:1,
        Aereo:2
    };
    var TypeVehiculoAccion={
        Nuevo:0,
        Existente:1
    };
    var tmpVehiculo = {
        VEHICULO:'KEYGEN',
        MOTOR:'KEYGEN'
    };
    var tmpVehiculoReemplazo = {
        VEHICULO:null,
        MOTOR:null
    };
    var TypeTramite = {
        RESIDENCIA:'13',
        VEHICULOS:'12'
    };

    var TypeConfiguracionData = {
        DOCUMENTO_VALIDO:'CONF33',
        REEMPLAZO_VEHICULO:'25'
    }
    //Agregar los registros al Combobox
    $.each(dsTipoVehiculo, function(key, value) {
        options += '<option value="' + key + '">' + value + '</option>';
    });
    $("select#cbxVehiculoTipo").html(options);


    $("#chkDatosConyuge").click(function(){
        if ($(this).is(":checked"))
        {
            $("#divConyuge").show();
            //setHeightForm();
            //alert('sii')
        }
        else{
            $("#divConyuge").hide();}
        setHeightForm();
    });

    //Combobox Isla

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


    //Combobox tipo de solicitud de tramite padre
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
                {name:"inCgcnf_codigo",value:TypeTramite.VEHICULOS}
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


    //Definicion de eventos
    $("select#cbxTipoResidenciaPadre").change(function(){
        cbxTipoSolicitudResidencia.setParam('inCrtst_codigo',$(this).val());
        cbxTipoSolicitudResidencia.reload();
        if (tmpTipoReemplazo[0].CGCNF_VALOR_CADENA == $(this).val())
        {
            $("#divReemplaza").show();
            $("#chkVehiculoExistente").hide();
            $("#lblVehiculoExistente").hide();

            cbxVehiculoReemplaza.setParam("inCrper_codigo",tmpRecordAuspiciante[0].CRPER_CODIGO);
            cbxVehiculoReemplaza.reload();
        }
        else
        {
            $("#chkVehiculoExistente").show();
            $("#lblVehiculoExistente").show();
            $("#divReemplaza").hide();
            tmpVehiculoReemplazo.VEHICULO = null;
            tmpVehiculoReemplazo.MOTOR = null;

        }
    });

    //Combobox tipo de tipo de solicitud de tramite
    var cbxTipoSolicitudResidencia = new bsxComboBox({
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
                {name:"inCgcnf_codigo",value:TypeTramite.VEHICULOS}
            ]
        },
        events:{
            load:function(v){
                $('#cbxTipoSolicitudResidencia').prepend("<option value=>Ninguna</option>");
                $("#cbxTipoSolicitudResidencia").val(0);
            }
        }
    });

    var cbxVehiculoReemplaza = new bsxComboBox({
        id:"cbxVehiculoReemplaza",
        renderTo:"divVehiculoReemplaza",
        displayField:"RESUMEN",
        valueField:"CVVEH_CODIGO",
        webService:{
            url:URL_WS+"Cgg_veh_historial",
            method:"selectVehiculo",
            params:[
                {name:"format", value:"JSON"},
                {name:"inCrper_codigo", value:""},
                {name:"inCvveh_tipo", value:0}

            ]
        }
    });

    $("select#cbxVehiculoReemplaza").change(function(){

        tmpVehiculoReemplazo.VEHICULO = $(this).val();
        tmpVehiculoReemplazo.MOTOR = null;

    });

    /*****************************************************************************************************/
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
                    msg:"Seleccione un Contacto",
                    icon:"iconInfo"
                });
            }
        }
        btnEliminarCgg_gem_contacto_persona.onclick = function(){
            if(filaTablaContacto){
                if(confirm("�Esta seguro que desea eliminar el contacto?")){
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
            var fila = insertarFila();
            //Tipo de Contacto
            var celda= fila.insertCell(0);
            celda.id = cbxTipoContacto.dom.value;
            celda.innerHTML = cbxTipoContacto.dom.options[cbxTipoContacto.dom.selectedIndex].text;
            celda.width = 65;

            //Contacto
            celda= fila.insertCell(1);
            celda.id = txtCrprc_codigo.value?txtCrprc_codigo.value:'KEYGEN';
            celda.innerHTML = txtCrprc_contacto.value;
            celda.width = 80;

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
    /*****************************************************************************************************/

    $("select#cbxTipoSolicitudResidencia").change(function(){
        var tmpRecordTipo = cbxTipoSolicitudResidencia.getRowSelected();
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


        //alert(tmpRecordTipo.CRTST_APLICA_BENEFICIARIO);

    });




    //Combobox Vehiculo Sector
    var cbxVehiculoSector = new bsxComboBox({
        id:"cbxVehiculoSector",
        renderTo:"divVehiculoSector",
        displayField:"CVSCT_NOMBRE",
        valueField:"CVSCT_CODIGO",
        webService:{
            url:URL_WS+"Cgg_veh_sector",
            method:"selectAll",
            params:[
                {name:"format",value:"JSON"}
            ]
        }
    });
    cbxVehiculoSector.reload();


    //Combobox Vehiculo Sector Productivo
    var cbxVehiculoSectorProductivo = new bsxComboBox({
        id:"cbxVehiculoSectorProductivo",
        renderTo:"divVehiculoSectorProductivo",
        displayField:"CSCTP_NOMBRE",
        valueField:"CSCTP_CODIGO",
        webService:{
            url:URL_WS+"Cgg_sector_productivo",
            method:"selectAllParent",
            params:[
                {name:"format",value:"JSON"}
            ]
        }
    });
    cbxVehiculoSectorProductivo.reload();


    //Combobox Vehiculo Cilindraje
    var cbxVehiculoCilindraje = new bsxComboBox({
        id:"cbxVehiculoCilindraje",
        renderTo:"divVehiculoCilindraje",
        displayField:"CVCLN_CILINDRAJE",
        valueField:"CVCLN_CODIGO",
        webService:{
            url:URL_WS+"Cgg_veh_cilindraje",
            method:"selectAll",
            params:[
                {name:"format",value:"JSON"}
            ]
        }
    });
    cbxVehiculoCilindraje.reload();



    //Combobox Vehiculo Combustible
    var cbxVehiculoCombustible = new bsxComboBox({
        id:"cbxVehiculoCombustible",
        renderTo:"divVehiculoCombustible",
        displayField:"CVCMB_NOMBRE",
        valueField:"CVCMB_CODIGO",
        webService:{
            url:URL_WS+"Cgg_veh_combustible",
            method:"selectAll",
            params:[
                {name:"format",value:"JSON"}
            ]
        }
    });
    cbxVehiculoCombustible.reload();

    /*
     * MANEJO DE EVENTOS DE CONTROL txtNumDocAuspiciante PAREA CONSULTA DE INFORMACION DE AUSPICIANTE
     * */
    $('#txtNumConyuge').keypress(function(event) {
        if (event.which == '13') {
            consultarAuspiciante();

        }

    });

    $("#btnBuscarConyuge").click(function() {
        consultarAuspiciante();

    });

    /*
     * MANEJO DE EVENTOS DE CONTROL txtNumDocAuspiciante PAREA CONSULTA DE INFORMACION DE AUSPICIANTE
     * */
    $('#txtNumDocBeneficiario').keypress(function(event) {
        if (event.which == '13') {
            var documentoValido = true;
            if(tmpConfiguracion.length>0)
            {
                if (tmpConfiguracion[0].CGCNF_VALOR_CADENA == $('#cbxTipoDocumentoBeneficiario').val())
                {
                    documentoValido = validarCedula($(this).val())
                }
            }
            //alert($(this).val() +'  '+ $('#txtNumDocAuspiciante').val());
            if(documentoValido && ($(this).val() != $('#txtNumDocAuspiciante').val()))
            {
                consultarDatosPersona(tmpRecordBeneficiario,$(this).val(),'BENEFICIARIO');

            }
            else
            {
                //alert('');
                new bsxMessageBox({
                    title:'Error',
                    msg: 'El documento ingresado no es valido',
                    icon: "iconError"
                });

            }


        }

    });

    /*$('#txtNumDocAuspiciante').focusout(function() {
     alert('aqui otra vez');
     });*/


    /*
     *  Selecion del dato de configuracion que identifica la informacion suceptible de validacion
     * */
    function selectDataConfiguracion(inData){
        function CallBackConfiguracion(r){
            if(inData == TypeConfiguracionData.DOCUMENTO_VALIDO)
            {
                tmpConfiguracion = eval(r);
            }
            else
            {
                tmpTipoReemplazo = eval(r);
            }

        }
        var param = new SOAPClientParameters();
        param.add('inCgcnf_codigo',inData);
        param.add('format','JSON');
        SOAPClient.invoke(URL_WS + 'Cgg_configuracion',"select",param, true, CallBackConfiguracion);

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

                function CallBackCgg_res_persona(r){
                    tmpRecordPersona = eval(r);
                    $('#divCargando1').hide();
                    if(tmpRecordPersona[0].CRPER_CODIGO != undefined)
                    {
                        if(inTipoPersona == 'AUSPICIANTE')
                        {
                            $("#txtNombreConyuge").val(tmpRecordPersona[0].CRPER_NOMBRES);
                            $("#txtApellidoConyuge").val(tmpRecordPersona[0].CRPER_APELLIDO_PATERNO);
                            manejarCtrlsConyuge();
                        }


                    }
                    else
                    {
                        if(inTipoPersona == 'AUSPICIANTE')
                        {
                            //alert('');
                            new bsxMessageBox({
                                title:'Alerta',
                                msg: 'La persona consultada no existe',
                                icon: "iconInfo",
                                close:function(){
                                    limpiarCtrlsConyuge();
                                }
                            });

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
            //winFrmCgg_res_persona_juridica.getEl().unmask();
        }
    }
    selectDataConfiguracion(TypeConfiguracionData.DOCUMENTO_VALIDO);
    selectDataConfiguracion(TypeConfiguracionData.REEMPLAZO_VEHICULO);

    function consultarDatosAuspiciante()
    {
        var flagConsultarDatos = true;
        try{

            if(flagConsultarDatos )
            {
                $("#divCargando1").show();
                function CallBackCgg_res_auspiciante(r){
                    tmpRecordAuspiciante = eval(r);
                    //alert(r);
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
                            $('#txtNumeroResidencia').val(tmpRecordAuspiciante[0].CRPER_NUMERO_RESIDENCIA);
                        }
                        else
                        {
                            $('#txtNumeroResidencia').val('000000');
                        }
                        if(tmpRecordAuspiciante[0].CGNCN_NACIONALIDAD !=undefined)
                        {
                            $('#txtNacionalidad').val(tmpRecordAuspiciante[0].CGNCN_NACIONALIDAD);
                        }
                        else
                        {
                            $('#txtNacionalidad').val('Ecuador');
                        }
                        if(tmpRecordAuspiciante[0].CRECV_DESCRPCION !=undefined)
                        {
                            $('#txtEstadoCivil').val(tmpRecordAuspiciante[0].CRECV_DESCRPCION);
                        }
                        else
                        {
                            $('#txtEstadoCivil').val('N/D');
                        }
                        manejarCtrlsAuspiciante();
                        grdVehiculo.setParam("inCrper_codigo",tmpRecordAuspiciante[0].CRPER_CODIGO);
                        grdVehiculo.show();
                        grdVehiculo.reload();


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
    // document.getElementById("divCargando").style.visibility="hidden";
    /**
     * VERIFICA Y VALIDA LA INFORMACION  DEL AUSPICIANTE PARA SER CONSULTADA EN LA BASE DE DATOS
     * */
    function consultarAuspiciante()
    {
        $('#divCargando1').show();
        //document.getElementById("divCargando").style.visibility="visible";
        //divCargando.style.visibility="visible";
        var documentoValido = true;

        if(tmpConfiguracion.length>0)
        {
            if (tmpConfiguracion[0].CGCNF_VALOR_CADENA == $('#cbxTipoDocumentoAuspiciante').val())
            {
                documentoValido = validarCedula($('#txtNumConyuge').val())
            }
        }
        if(documentoValido)
        {
            tmpRecordPersona = consultarDatosPersona(tmpRecordPersona,$('#txtNumConyuge').val(),'AUSPICIANTE');

        }
        else
        {
            //alert('');
            new bsxMessageBox({
                title:'Alerta',
                msg: 'El documento ingresado no es valido',
                icon: "iconInfo",
                close:function(){
                    limpiarCtrlsConyuge();
                    $('#divCargando1').hide();
                }
            });

        }

    }

    function manejarCtrlsAuspiciante()
    {
        // $('#target').attr("disabled", true); 
        $("#txtNombreAuspiciante").attr("readonly", true);
        $("#txtNumeroResidencia").attr("readonly", true);
        $('#txtNombreAuspiciantePJ').attr("readonly", true);
        $('#txtNumDocAuspiciante').attr("readonly", true);
        $('#txtNacionalidad').attr("readonly", true);
        $('#txtEstadoCivil').attr("readonly", true);
        $('#txtIdentificacionAuspiciante').attr("readonly", true);


    }

    function manejarCtrlsConyuge()
    {
        // $('#target').attr("disabled", true);
        $("#txtApellidoConyuge").attr("readonly", true);
        $("#txtNombreConyuge").attr("readonly", true);
    }
    function limpiarCtrlsConyuge()
    {

        $("#txtNombreConyuge").val('');
        $("#txtApellidoConyuge").val('');
       
    }

    $('#btnSalirTramiteVehiculos').click(function(){
        $('#myForm').hide();
    });

    function verificarInformacionTramite()
    {

        $('.form-line-error').removeClass("form-line-error");
        var isComplete =  true;
        if(!$('#cbxIslaTramite').val())
        {
            $('#cbxIslaTramite').addClass("form-line-error");//css("background-color","#FFE3EE");
            isComplete = false;
            return isComplete;
        }
        if(!$('#cbxTipoSolicitudResidencia').val())
        {
            $('#cbxTipoSolicitudResidencia').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }
        if(!$('#txtNumDocAuspiciante').val())
        {
            $('#txtNumDocAuspiciante').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }

        if(!$('#txtJustificacion').val())
        {
            $('#txtJustificacion').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }

        if(!$('#cbxVehiculoCombustible').val())
        {
            $('#cbxVehiculoCombustible').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }
        if(!$('#cbxVehiculoCilindraje').val())
        {
            $('#cbxVehiculoCilindraje').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }
        if(!$('#txtVehiculoTonelaje').val())
        {
            $('#txtVehiculoTonelaje').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }
        if(!$('#cbxVehiculoSector').val())
        {
            $('#cbxVehiculoSector').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }
        if(!$('#cbxVehiculoSectorProductivo').val())
        {
            $('#cbxVehiculoSectorProductivo').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }

        if(!$('#txtVehiculoCategoria').val())
        {
            $('#txtVehiculoCategoria').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }
        if(!$('#txtVehiculoFabricacion').val())
        {
            $('#txtVehiculoFabricacion').addClass("form-line-error");
            isComplete = false;
            return isComplete;
        }

        return isComplete;
    }

    /*
     * Guardado de informacion de un tramite de vehiculos
     * */

    $('#btnGuardarTramiteVehiculos').click(function(){
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
        if( validarReglaTramite() == false){
            $('#divCargando1').hide();
            $('#divCargando1').html('Cargando..');
            return;
        }
        $('#divCargando1').html('Cargando..');

        var objVehiculo = null;
        if( !$("#chkVehiculoExistente").is(":checked"))
        {
            var  objInfoVehiculo ={
                ACCION:TypeVehiculoAccion.Nuevo,
                TIPO:TypeInfoVehiculo.Vehiculo,
                VEHICULO:TypeVehiculo.Terrestre,
                FABRICACION:$('#txtVehiculoFabricacion').val(),
                CVCMB_CODIGO:$('#cbxVehiculoCombustible').val(),
                CVCLN_CODIGO:$('#cbxVehiculoCilindraje').val(),
                CVMTR_TONELAJE:$('#txtVehiculoTonelaje').val(),
                CVCTG_CODIGO:tmpCategoriaId,
                CVSCT_CODIGO:$('#cbxVehiculoSector').val(),
                CSCTP_CODIGO:$('#cbxVehiculoSectorProductivo').val()

            }
            objVehiculo = JSON.stringify(objInfoVehiculo);
            tmpVehiculo.VEHICULO = 'KEYGEN' ;
            tmpVehiculo.MOTOR = 'KEYGEN';
        }
        if (tmpTipoReemplazo[0].CGCNF_VALOR_CADENA == $('#cbxTipoResidenciaPadre').val())
        {
            tmpVehiculoReemplazo.VEHICULO = $('#cbxVehiculoReemplaza').val();
            tmpVehiculoReemplazo.MOTOR = null;
        }
        else
        {
            tmpVehiculoReemplazo.VEHICULO = null;
            tmpVehiculoReemplazo.MOTOR = null;
        }



        //var objBeneficiarioJSON = JSON.stringify(objBeneficiario);

        function CallBackCgg_res_tramite(r){
            /*var tmpRespuestaTramite = eval(r);
             alert(tmpRespuestaTramite);*/
            var tmpRespuestaTramite = eval(r);

            if (tmpRespuestaTramite[0].substring(0, 5) == 'CRTRA') {
                //  winFrmCgg_res_tramite.close();
                //alert('El tr\u00E1mite ha sido guardado y despachado. El n\u00FAmero de su tr\u00E1mite es: <span class="numeroTramite">'+ new Date().getFullYear()+'-'+tmpRespuestaTramite[1] + '</span>.<br>Para mayor informaci\u00F3n consulte el historial del tr\u00E1mite.');
                //alert(');
                new bsxMessageBox({
                    title:'Informaci\u00F3n',
                    msg: 'El tr\u00E1mite ha sido guardado y despachado. El n\u00FAmero de su tr\u00E1mite es: <span style="color:#039BD7"><b>'+ new Date().getFullYear()+'-'+tmpRespuestaTramite[1]/*.split('CRTRA')[1]*/ + '</b></span>.',
                    icon: "iconOk",
                    close:function(){
                        // urlReport = new Reporte('rptSolicitudesResidenciaPermanente','/Reports/sii/atencionalcliente',{P_CRTRA_CODIGO:tmpRespuestaTramite[0],P_CRTST_CODIGO:$("#cbxTipoSolicitudResidencia").val()});
                        //urlReport.show();
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
        param.add('inCgg_crper_codigo',tmpRecordBeneficiario !=null?tmpRecordBeneficiario[0].CRPER_CODIGO:null) ;
        param.add('inCrtst_codigo', $("#cbxTipoSolicitudResidencia").val()) ;
        param.add('inCisla_codigo', $("#cbxIslaTramite").val()) ;
        param.add('inCrtra_observacion',$("#txtJustificacion").val()) ;
        param.add('inCvveh_codigo',tmpVehiculo.VEHICULO) ;
        param.add('inCvmtr_codigo',tmpVehiculo.MOTOR) ;
        param.add('inCgg_cvveh_codigo',tmpVehiculoReemplazo.VEHICULO) ;
        param.add('inCgg_cvmtr_codigo',tmpVehiculoReemplazo.MOTOR) ;
        param.add('inCrtra_atencion_cliente',true) ;
        param.add('inNuevoBeneficiarioJSON',null) ;
        param.add('inContactoPersonaJSON',inContactosJSON);//'[]') ;
        param.add('inInfoVehiculos',objVehiculo?objVehiculo:null) ;
        SOAPClient.invoke(URL_WS+"Cgg_res_tramite",'registrarTramiteLite',param, true, CallBackCgg_res_tramite);
    });
    /*
     *  Selecion del dato de configuracion que identifica la informacion suceptible de validacion
     * */
    var ingresoVehiculo = '';
    var salidaVehiculo = '';
    function fnValorConf(inCod){
        function CallBackConfiguracion2(r){
            //var a = eval(r);
            if(inCod=='24')
                ingresoVehiculo = eval(r);
            if(inCod=='23')
                salidaVehiculo = eval(r);
        }
        var param = new SOAPClientParameters();
        param.add('inCgcnf_codigo',inCod);
        param.add('format','JSON');
        SOAPClient.invoke(URL_WS + 'Cgg_configuracion',"select",param, false, CallBackConfiguracion2);
    }

    function printSolicitud(inCrtraCodigo)
    {
        fnValorConf('24');
        fnValorConf('23');
        var codCbx = $("#cbxTipoResidenciaPadre").val();
        //alert(codCbx);
        if(codCbx ==ingresoVehiculo[0].CGCNF_VALOR_CADENA)
        {
            urlReport = new Reporte('rptSolicitudIngresoVehiculo','/Reports/sii/atencionalcliente',{P_CRTRA_CODIGO:inCrtraCodigo,P_NOMBRE_CONYUGUE:$("#txtNombreConyuge").val(),P_IDENTIFICACION_CONYUGUE:$("#txtNumConyuge").val()});

        }
        else if (codCbx == salidaVehiculo[0].CGCNF_VALOR_CADENA)
        {
            urlReport = new Reporte('rptSolicitudSalidaVehiculoReemplazo','/Reports/sii/atencionalcliente',{P_CRTRA_CODIGO:inCrtraCodigo,P_NOMBRE_CONYUGUE:$("#txtNombreConyuge").val(),P_IDENTIFICACION_CONYUGUE:$("#txtNumConyuge").val()});
        }
        else
        {
            urlReport = new Reporte('rptSolicitudIngresoVehiculoReemplazo','/Reports/sii/atencionalcliente',{P_CRTRA_CODIGO:inCrtraCodigo,P_NOMBRE_CONYUGUE:$("#txtNombreConyuge").val(),P_IDENTIFICACION_CONYUGUE:$("#txtNumConyuge").val()});
        }
        urlReport.show();

    }


    $("#chkVehiculoExistente").click(function(){
        if ($(this).is(":checked"))
        {

            $("#dlgVehiculos").dialog("open");
        }

    });


    /*
     * Inicializacion de los datos asignados al objeto de tipo dialogo para seleccion de vehiculos
     * */
    function viewDialogVehiculo() {
        var cancel = function() {
            $('input[name=chkVehiculoExistente]').attr('checked', false);
            $("#dlgVehiculos").dialog("close");
        }
        var getResponse = function(){

            if (tmpRecordVehiculoExistente)
            {

                $("#txtVehiculoCategoria").val(tmpRecordVehiculoExistente.CATEGORIA);
                $("#cbxVehiculoSector").val(tmpRecordVehiculoExistente.CVSCT_CODIGO);
                $("#cbxVehiculoSectorProductivo").val(tmpRecordVehiculoExistente.CSCTP_CODIGO);
                tmpVehiculo.VEHICULO = tmpRecordVehiculoExistente.CVVEH_CODIGO;
                tmpVehiculo.MOTOR = tmpRecordVehiculoExistente.CVMTR_CODIGO;
                $("#cbxVehiculoCilindraje").val(tmpRecordVehiculoExistente.CVCLN_CILINDRAJE);
                $("#cbxVehiculoCombustible").val(tmpRecordVehiculoExistente.CVCMB_NOMBRE);
                $("#txtVehiculoTonelaje").val(tmpRecordVehiculoExistente.CVMTR_TONELAJE);
                $("#txtVehiculoFabricacion").val(tmpRecordVehiculoExistente.CVVEH_ANIO_PRODUCCION);

            }
            else
            {
                //alert("");
                new bsxMessageBox({
                    title:'Alerta',
                    msg: 'No se ha seleccionado ningun vehiculo',
                    icon: "iconInfo"
                });
            }
            $("#dlgVehiculos").dialog("close");

        }
        var dialogOpts = {
            modal: true,
            buttons: {
                "Ok": getResponse,
                "Cancel": cancel
            },
            autoOpen: false,
            width: 520,
            close: function(event, ui) {
                //alert('cerrando');

            }

        };
        $("#dlgVehiculos").dialog(dialogOpts);

    };

    viewDialogVehiculo();

    var cmCgg_veh_vehiculo = [
        //      {name:'PROPIETARIO',title:'Propietario',width:300},
        //      {name:'TRAMITE',title:'Tramite',width:50},
        {name:'MARCA',title:'Marca',width:80},
        {name:'CATEGORIA',title:'Categor\u00eda',width:70},
        {name:'PRODUCTIVO',title:'Sct. Prod.',width:70},
        {name:'SECTOR',title:'Sector',width:70},
        //      {name:'CVVEH_NOMBRE',title:'Nombre',width:80},
        //     {name:'CVVEH_TIPO',title:'Tipo',width:70},
        {name:'CVVEH_ANIO_PRODUCCION',title:'Anio fab.',width:70},
        {name:'CVVEH_CHASIS',title:'Chasis',width:80}]
    //{name:'ESTADOS',title:'Estados',width:80}];

    var grdVehiculo  = new bsxTable({
        id:"grdVehiculo",
        renderTo:"divGrdVehiculo",
        width:"500",
        height:"150",
        webService:{
            url:URL_WS+"Cgg_veh_historial",
            method:"selectAllVehiculo",
            reader:{
                totalCountName:"totalCount",
                dataSetName:"dataSet"
            },
            params:[
                {name:"inCrper_codigo",value:""},
                {name:"inCvveh_tipo",value:0},
                {name:"format",value:"JSON"}

            ]
        },
        columns:cmCgg_veh_vehiculo,
        pagin:true,
        search:true,
        events:{
            selectedRow:function(t,dr,r){
                //alert(dr.CATEGORIA+'  '+r);
                tmpRecordVehiculoExistente = dr;
            }
        }
    });




    /*
     * Inicializacion de los datos asignados al objeto de tipo dialogo para seleccion de vehiculos
     * */
    function viewDialogCategoria() {
        var cancel = function() {
            $("#dlgVehiculoCategoria").dialog("close");
        }
        var getResponse = function(){
            $("#txtVehiculoCategoria").val(tmpCategoriaDescripcion);
            $("#dlgVehiculoCategoria").dialog("close");
        }
        var dialogOpts = {
            modal: true,
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
        $("#dlgVehiculoCategoria").dialog(dialogOpts);

    };

    viewDialogCategoria();
    /*
     * Consulta de informacion  de Categorias de vehiculos
     * */
    function selectCategoriaTree(){
        function CallBackCategoriaTree(r){
            $("#divVehiculoCategoria").jstree({
                "json_data" : {
                    "data" :[eval('('+r+')') ]
                },
                "ui" : {
                    "select_limit" : 2,
                    "select_multiple_modifier" : "alt",
                    "selected_parent_close" : "select_parent"
                },
                "plugins" : [ "themes", "json_data","ui" ]
            });

        }
        var param = new SOAPClientParameters();
        param.add('inCgg_cvctg_codigo',null);
        SOAPClient.invoke(URL_WS + 'Cgg_veh_categoria',"selectCategoriaTree",param, true, CallBackCategoriaTree);
    }

    selectCategoriaTree();
    //Definicion de eventos para el arbol de categoria de vehiculos
    $("#divVehiculoCategoria").bind("select_node.jstree", function (e, data) {
        tmpCategoriaId =  data.rslt.obj.attr('id');
        tmpCategoriaDescripcion = data.inst.get_text(data.rslt.obj);
    });

    $("#btnBuscarCategoria").click(function(){
        $("#dlgVehiculoCategoria").dialog("open");
    });

    $("select").width('150');
    $("#cbxVehiculoReemplaza").width('250');


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
            //ASIGNACION DE VARIABLES PARA
            crperCodigo = tmpRecordAuspiciante[0].CRPER_CODIGO;
            // cggcrperCodigo = tmpRecordBeneficiario[0].CRPER_CODIGO!=undefined?tmpRecordBeneficiario[0].CRPER_CODIGO:null;
            crperNumDocIdentific = $('#txtNumDocBeneficiario').val();
            cvvehCodigo = tmpVehiculo.VEHICULO;
            var jsonData = {'CVVEH_CODIGO':cvvehCodigo,
                'CRPER_CODIGO':crperCodigo,
                'CGGCRPER_CODIGO':cggcrperCodigo,
                'CRPER_NUM_DOC_IDENTIFIC':crperNumDocIdentific
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
            //alert('');
            new bsxMessageBox({
                title:'Error',
                msg: 'No se ha podido validar la informacion a almacenar',
                icon: "iconError"
            });
            flagRegla = false;
        }
        // pnlFrmCgg_res_tramitePrincipal.getEl().unmask();
        return flagRegla;
    }

    /******************FIN DE SECCION REGLAS DE VALIDACION*/
    /********/


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
    setHeightForm();
});
