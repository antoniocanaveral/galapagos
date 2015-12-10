/**
 * Created by IntelliJ IDEA.
 * User: bsxbk
 * Date: 25-ene-2011
 * Time: 8:01:58
 * To change this template use File | Settings | File Templates.
 */
$(function() {
    var tmpRespuestaTramite = null; //VARIABLE UTILIZADA PARA ALMACENAR LA RESPUESTA DE LA CONSULTA DE UN TRAMITE
    var urlReport = null;
	
	if (document.getElementById("txtUsuario").value != "false") {            
        document.getElementById("divLogineo").style.display = 'none';
		document.getElementById("divTramite").style.display = 'block';
	}else{
		document.getElementById("divTramite").style.display = 'none';
		document.getElementById("divLogineo").style.display = 'block';
        document.getElementById("divLogineo").innerHTML = msgUsuarioLogin;
		document.getElementById("spanMsgUsuarioLogin").onclick = function(){			
			parent.window.location = 'PrivateWS/SessionWeb';
		}
		setHeightForm();
		return;
	}
    function consultarTramite()
    {
            function CallBackCgg_res_tramite(r){
                tmpRespuestaTramite =JSON.parse(r);
                if(tmpRespuestaTramite.length >0)// SI EXISTEN ELEMENTOS EN LA CONSULTA
                {
                    $("#divTramite").html(' <div class="font">'+
                            '<p>El certificado de transeunte No. <b>'+tmpRespuestaTramite[0].CRTRA_NUMERO+'</b> correspondiente al tr&aacute;mite  <b>'+
                            tmpRespuestaTramite[0].CRTRA_ANIO+'-'+tmpRespuestaTramite[0].CRTRA_NUMERO+'</b> ha sido generado exitosamente.</p>'+
                            '<div style="float:right;"> <button id="btnImprimirSolicitud" ><img src="css/icon/printer2.png" alt="Imprime certificado de transeunte"/>Imprimir</button></div>'+
                            '</div>');


                    $('#btnImprimirSolicitud').click(function(){
                        printSolicitud();
                    });
                }
                else
                {
                    $("#divTramite").html(' <div class="font">'+
                            '<image style="float : left;" src="css/image/noencontrado.png"></image>'+
                            '<p>No se ha encontrado ninguna autorizaci&oacute;n de transeunte aprobada!!.</p>'+
                            '</div>');

                }
                setHeightForm(500);

            }
            var param = new SOAPClientParameters();
            param.add('format','JSON') ;
            SOAPClient.invoke(URL_WS+"Cgg_res_residencia",'selectResidenciaTranseunteTramite',param, true, CallBackCgg_res_tramite);
    }
    consultarTramite();
    function printSolicitud(){
        if(tmpRespuestaTramite[0].CRTST_APLICA_OTRO!= true)
        {
            urlReport = new Reporte('rptCertificadoTranseunteporNumeroTramiteOficio','/Reports/sii/residencia',{P_CRTRA_CODIGO:tmpRespuestaTramite[0].CRTRA_CODIGO,P_CUSU_RESPONSABLE:'',P_CUSU_CODIGO:''});
            urlReport.show();
        }
        else
        {
            urlReport = new Reporte('rptCertificadoTranseunteporTemporal','/Reports/sii/residencia',{P_CRTRA_CODIGO:tmpRespuestaTramite[0].CRTRA_CODIGO,P_CUSU_RESPONSABLE:'',P_CUSU_CODIGO:''});
            urlReport.show();
        }

    }
    setHeightForm();
});
