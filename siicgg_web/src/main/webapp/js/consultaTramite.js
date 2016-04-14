/**
 * Created by IntelliJ IDEA.
 * User: bsxbk
 * Date: 25-ene-2011
 * Time: 8:01:58
 * To change this template use File | Settings | File Templates.
 */ 
$(function() {
    var tmpRespuestaTramite = null; //VARIABLE UTILIZADA PARA ALMACENAR LA RESPUESTA DE LA CONSULTA DE UN TRAMITE
    var tmpValor = 0; //VARIABLE UTILIZADA PARA IDENTIFICAR EL TIPO BUSQUEDA CONFORME EL RADIO BUTTON
	
	if (document.getElementById("txtUsuario").value != "false") {            
        document.getElementById("divLogineo").style.display = 'none';
		document.getElementById("divFrmConsultaTramite").style.display = 'block';
	}else{
		document.getElementById("divFrmConsultaTramite").style.display = 'none';
		document.getElementById("divLogineo").style.display = 'block';
        document.getElementById("divLogineo").innerHTML = msgUsuarioLogin;
		document.getElementById("spanMsgUsuarioLogin").onclick = function(){			
			parent.window.location = 'PrivateWS/SessionWeb';
		}
		setHeightForm();
		return;
	}
	
    function consultarEstadoTramite()
    {
        var flagConsulta =  true;
        if(tmpValor ==0)
        {
            var rege = /[0-9]{4,4}\-[0-9]+/;
            if(!rege.test($('#txtNumeroTramite').val()))
            {
              flagConsulta = false;
            }
        }        
        if(flagConsulta){
			function CallBackCgg_res_tramite(r){
                tmpRespuestaTramite = JSON.parse(r);
                if(tmpRespuestaTramite.length>0)
                {
                    if(tmpRespuestaTramite.length>1)
                    {
                        $("#divTramite").html($.tmpl( "tramiteGeneralTemplate", tmpRespuestaTramite ));
                    }
                    else
                    {
                        $("#divTramite").html($.tmpl( "tramiteTemplate", tmpRespuestaTramite ));

                    }
                    $("#divOpciones").hide();
                }
                else
                {
                    if(tmpValor ==0)
                    {
                        $("#divTramite").html(' <div class="font">'+
                                '<image style="float : left;" src="css/image/noencontrado.png"></image>'+
                                '<p>El tr&aacute;mite  No. <b>'+$('#txtNumeroTramite').val()+'</b>, no contiene informaci&oacute;n relacionada!!.</p>'+
                                '</div>');
                    }
                    else
                    {
                       $("#divTramite").html(' <div class="font">'+
                                '<image style="float : left;" src="css/image/noencontrado.png"></image>'+
                                '<p>La persona con documento de identidad <b>'+$('#txtNumeroTramite').val()+'</b>, no contiene informaci&oacute;n relacionada!!.</p>'+
                                '</div>');
                    }
                }
                setHeightForm();
            }
            var param = new SOAPClientParameters();
            param.add('inCrtra_codigo',$('#txtNumeroTramite').val()) ;
            param.add('format','JSON') ;
            SOAPClient.invoke(URL_WS+"Cgg_res_tramite",'selectTramiteSeguimientoStatus',param, true, CallBackCgg_res_tramite);
        }
        else
        {
            alert ('El formato ingresado para la busqueda no es valido.\nEj:2011-145');
        }
    }

    $('#btnBuscarEstadoTramite').click(function(){
        consultarEstadoTramite();
    });

    $('#txtNumeroTramite').keypress(function(event) {
        if (event.which == '13') consultarEstadoTramite();
    });

    var TypeRespuestaSeguimiento = {
        RECIBIDO:0,
        REVISADO:1,
        DISTRIBUIDO:2,
        PENDIENTE:3,
        DESPACHADO:4,
        FINALIZADO :5,
        INHABILITADO:6,
        REVISADODISTRIBUIDO:7
    }

    $.template(
            "tramiteTemplate",
            '<table id="tableSeguimiento">'+
                    '<tr>'+
                    '<th colspan=3><div id="divInfoTramite"></div><span>Tr&aacute;mite  ${CRTRA_ANIO}-${CRTRA_NUMERO}</span></th>'+
                    '</tr>'+
                    '<tr class="odd">'+
                    '<td style="width:20%"></td>'+
                    '<td>Tipo tramite:</td>'+
                    '<td>${CRTRA_TIPO_SOLICITUD}</td>'+
                    '</tr>'+
                    '<tr class="even">'+
                    '<td></td>'+
                    '<td>Fecha recepci&oacute;n</td>'+
                    '<td>${CRTRA_FECHA_RECEPCION}</td>'+
                    '</tr>'+
                    '<tr class="odd">'+
                    '<td></td>'+
                    '<td>Beneficiario</td>'+
                    '<td>${CRTRA_BENEFICIARIO}</td>'+
                    '</tr>' +
                    '<tr class="even" >'+//border-bottom: 5px solid #f00; padding: 0.4em; ">'+
                    '<td></td>'+
                    '<td>Estado</td>'+
                    '<td>${CRETT_NOMBRE}</td>'+
                    '</tr>'+
                    '{{each SEGUIMIENTO}}'+
                    '<tr class="even" style=" border-top: 2px #3399ff solid; padding: 0.4em;">'+
                    '{{if CRSEG_ESTADO_ATENCION == 4 }}'+
                    '<th colspan=3 style="text-align:left;"></TH>'+
                    '{{else}}'+
                    '<th colspan=3 style="text-align:left;">Su tr&aacute;mite se halla en:</TH>'+
                    '{{/if}}'+
                    '</tr>'+
                    '<tr class="even">'+
                    '<th rowspan=5 >' +
                    '{{if CRSEG_ESTADO_ATENCION == 4 }}'+
                    '<div class="divSeguimientoAtendido"></div><span style="float:inherit;font-style:italic; font-size:11px">${CRSEG_TIEMPO_ATENCION} (d&iacute;as)<br/>Atendido</span></TH>'+
                    '{{else}}'+
                    '<div class="divSeguimientoPendiente"></div><span style="float:inherit; font-style:italic; font-size:11px">${CRSEG_TIEMPO_ATENCION} (d&iacute;as)<br/>En atenci&oacute;n</span></TH>'+
                    '{{/if}}'+
                    '<td>Fase:</td>'+
                    '<td>${CRFAS_NOMBRE}</td>'+
                    '</tr>'+
                    '<tr class="odd">'+
                    '<td>Responsable.:</td>'+
                    '<td>${CRPER_NOMBRES}(${CUSU_NOMBRE_USUARIO})</td>'+
                    '</tr>'+
                    '<tr class="even">'+
                    '<td>Seccion:</td>'+
                    '<td>${CRSEC_NOMBRE}</td>'+
                    '</tr>'+
                    '<tr class="odd">'+
                    '<td>Fecha recepci&oacute;n</td>'+
                    '<td>${CRSEG_FECHA_RECEPCION}</td>'+
                    '</tr>'+
                    '<tr class="even" style=" border-bottom: 2px #3399ff solid; padding: 0.4em;">'+
                    '<td>Fecha despacho</td>'+
                    '<td>${CRSEG_FECHA_DESPACHO}</td>'+
                    '</tr>'+
                    '{{/each}}'+
                    '</table>'
            );

    $.template(
            "tramiteGeneralTemplate",
            '<table id="tableSeguimiento">'+
                    '<tr style=" border-top: 2px #3399ff solid; padding: 0.4em;">'+
                    '<th rowspan=5><div class="divTramiteGeneral"><a href="#"></a></div><span>Tr&aacute;mite  ${CRTRA_ANIO}-${CRTRA_NUMERO}</span></th>'+
                    '</tr>'+
                    '<tr class="odd">'+
                    '<td style="width:20%"></td>'+
                    '<td>Tipo tramite:</td>'+
                    '<td>${CRTRA_TIPO_SOLICITUD}</td>'+
                    '</tr>'+
                    '<tr class="even">'+
                    '<td></td>'+
                    '<td>Fecha recepci&oacute;n</td>'+
                    '<td>${CRTRA_FECHA_RECEPCION}</td>'+
                    '</tr>'+
                    '<tr class="odd">'+
                    '<td></td>'+
                    '<td>Beneficiario</td>'+
                    '<td>${CRTRA_BENEFICIARIO}</td>'+
                    '</tr>' +
                    '<tr class="even"  >'+
                    '<td></td>'+
                    '<td>Estado</td>'+
                    '<td>${CRETT_NOMBRE}<span style="float:right;"><a class="link" id =${CGG_CRPER_CODIGO} href="#"> Ver detalles</a> </span></td>'+
                    '</tr>'+
                    '</table>'
            );
			
    $( ".divTramiteGeneral" ).live( "click", function() {
        var tmplItem = $.tmplItem(this);
        for (var i=0;i<tmpRespuestaTramite.length;i++)
        {
            if (tmplItem.data.CGG_CRPER_CODIGO == tmpRespuestaTramite[i].CGG_CRPER_CODIGO && tmplItem.data.CRTRA_NUMERO == tmpRespuestaTramite[i].CRTRA_NUMERO)
            {
                $("#divTramite").html($.tmpl( "tramiteTemplate", tmpRespuestaTramite[i] ));
                $("#divOpciones").show();
            }
        }
    });

    $( ".link" ).live( "click", function() {
        var tmplItem = $.tmplItem(this);
        for (var i=0;i<tmpRespuestaTramite.length;i++)
        {
            if (tmplItem.data.CGG_CRPER_CODIGO == tmpRespuestaTramite[i].CGG_CRPER_CODIGO && tmplItem.data.CRTRA_NUMERO == tmpRespuestaTramite[i].CRTRA_NUMERO)
            {
                $("#divTramite").html($.tmpl( "tramiteTemplate", tmpRespuestaTramite[i] ));
                $("#divOpciones").show();
            }
        }
    });
    $('#btnImprimirRequisitos').click(function(){
        $("#divTramite").html($.tmpl( "tramiteGeneralTemplate", tmpRespuestaTramite ));
        $("#divOpciones").hide();
    });

    $("input[name='rdbtnBuscar']").click(function(){
        if ($( this ).val() == '0')
        {
            $("#lblNumeroTramite").text('N\u00famero de tr\u00e1mite:');
            $("#lblFormato").text('(Ej: 2011-145)');
             tmpValor = 0;
        }
        else
        {
            $("#lblNumeroTramite").text('No. doc. identificaci\u00f3n:');
            $("#lblFormato").text('(Ej:1803437965)');
            tmpValor = 1;
        }
        $('#txtNumeroTramite').val('');
    });
	setHeightForm();
});